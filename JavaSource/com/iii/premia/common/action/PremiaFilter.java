package com.iii.premia.common.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.pel.login.service.LoginService;
import com.iii.premia.common.utils.DBProcedures;

public class PremiaFilter  implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//System.out.println("Enter into Filter");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		String currentURL = request.getRequestURL().toString();
		String applicationContextURL = "http://"+request.getLocalAddr()+":"+request.getServerPort()+request.getContextPath()+"/";
		//System.out.println("applicationContextURL        "+applicationContextURL);
		/*System.out.println("getServerInfo        "+request.getServletContext().getServerInfo());*/
		
		Map<String, String> map = new HashMap<String, String>();

		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		System.out.println("map        "+map);
String previousURL = null;
if(map != null)
{
	previousURL = map.get("referer");
}
System.out.println("previousURL        "+previousURL+"      currentURL       "+currentURL+"        "+applicationContextURL);

		/*System.out.println("request.getLocalAddr()      "+request.getLocalAddr());    // Returns: 127.0.0.1
		System.out.println("request.getLocalName()      "+request.getLocalName());    // Returns: localhost
		System.out.println("request.getServerName()      "+request.getServerName());   // Returns: localhost
		System.out.println("request.getServerPort()      "+request.getServerPort());   // Returns: 8080
		System.out.println("request.getContextPath()      "+request.getContextPath());  // Returns: /MyApp
		System.out.println("request.getProtocol()        "+request.getProtocol());
		
		System.out.println("previous URL     "+request.getAttribute("javax.servlet.forward.request_uri") );*/
		/*
		 *commented by shankar for browser issue on 13-10-16 
		 * 
		 * if((currentURL != null && currentURL.toString().contains("login.xhtml")) || currentURL.equals(applicationContextURL))
		{*/

       /*added by shankar for browser issue on 13-10-16*/
      if((currentURL != null && currentURL.toString().contains("login.xhtml")) || 
		currentURL.equals(applicationContextURL) ||
		(currentURL != null && currentURL.toString().contains("browserNotSupported.xhtml")) )//end
		{
			chain.doFilter(req, res);			
		}
		else
		{
			FacesContext facesContext = FacesContext.getCurrentInstance();
			try {
				
			if(previousURL == null)
			{
				System.out.println("You have no rights to login");
				 
				String outcome = null;
				String requestURL = null;
				String loginRedirectURL = null; 
				String contextPath = null;
				int contextPathIndex = -1;
				
				 
 
				
				
					//new LoginService().invalidateSessionAction(request, context);
					contextPath = request.getContextPath();
					requestURL = request.getRequestURL().toString();
					contextPathIndex = requestURL.indexOf(contextPath);
					loginRedirectURL = requestURL.substring(0, contextPathIndex+contextPath.length());
					HttpSession session = request.getSession();
					session.invalidate();
					
					response.sendRedirect(loginRedirectURL);
					/*facesContext.responseComplete();*/
				
		/*Added by saritha on 05-Mar-2017 for ssp call id ZBILQC-1719135*/		
/*				response.sendRedirect(applicationContextURL);*/
			}
			else
			{
				/*Added by Ram on 03/02/2017 for Handling DBsession variables*/
				HttpSession session=request.getSession();
				if(session != null){
					System.out.println("INSIDE SESSION IN Premia Schedule         ");
					System.out.println("clientId         :"+session.getAttribute("CLIENT_ID"));
					String clientId = (String) session.getAttribute("CLIENT_ID");
					if(clientId != null)
					{
					
						HashMap param = new HashMap();
						ServletContext context = request.getSession().getServletContext();
						Connection con = ((SimpleConnectionAgent) context.getAttribute("connectionAgent")).getConnection(clientId);
						System.out.println("con      "+con);
						if(con != null)
						{
							System.out.println("GLOBAL.M_USER_ID    "+session.getAttribute("GLOBAL.M_USER_ID"));
							if(session.getAttribute("GLOBAL.M_USER_ID") != null)
							{
								setDBvalues(session,con);	
							}
							
						}
						
					}
				}
				
				chain.doFilter(req, res);	
			}
			} catch (IOException e) {
				e.printStackTrace();
				facesContext.addMessage("LOGOUT ERROR", new FacesMessage(e.getMessage()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				facesContext.addMessage("LOGOUT ERROR", new FacesMessage(e.getMessage()));
			}
			
			/*End*/
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	/*Added by saritha on 05-Mar-2017 for ssp call id ZBILQC-1719135*/
	/*Added by Ram on 03/02/2017 for Handling DBsession variables*/
	public void setDBvalues(HttpSession session,Connection conn)
	{


		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				(String)session.getAttribute("GLOBAL.M_LANG_CODE"));
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				(String)session.getAttribute("GLOBAL.M_FOR_LANG_CODE"));
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				(String)session.getAttribute("GLOBAL.M_USER_ID"));
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				(String)session.getAttribute("GLOBAL.M_COMP_CODE"));
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				(String)session.getAttribute("GLOBAL.M_DIVN_CODE"));
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				(String)session.getAttribute("GLOBAL.M_DEPT_CODE"));
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				(String)session.getAttribute("GLOBAL.M_BASE_CURR"));
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN",
				(String)session.getAttribute("GLOBAL.M_NOOF_DEC"));
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				null);
		OracleParameter param10 = new OracleParameter("in10", "STRING", "IN",
				"P11JLIFEJAVA");

		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);
		paramList.add(param7);
		paramList.add(param8);
		paramList.add(param9);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			/*Modified by Ganesh on 29-05-2017, for userid null issue */
			/*procHandler.execute(paramList, conn,
			"PCOPK_SYS_VARS.P_SET_PARA_VALUES");*/
		
			procHandler.execute(paramList, conn,
					"PCOPK_SYS_VARS.P_SET_PARA_VALUES");
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}
	/*End*/
}
