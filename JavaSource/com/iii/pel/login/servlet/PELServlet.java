package com.iii.pel.login.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.pel.login.model.MenuParameter;
import com.iii.pel.login.service.CookPitService;
import com.iii.premia.common.utils.CommonUtils;

/**
 * Servlet implementation class for Servlet: PELServlet
 *
 */
 public class PELServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public PELServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String redirectPage = null;
		try {
			redirectPage = processRequestedScreen(request);
		} catch (Exception e) {
			throw new ServletException(e.getCause());
		}
		request.getRequestDispatcher(redirectPage).forward(request, response);
	}
	
	public String processRequestedScreen(HttpServletRequest request) throws Exception {
		String actionType = null;
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<String> parameterSet = parameterMap.keySet();
		Iterator<String> parameterItr = parameterSet.iterator();
		HttpSession session = request.getSession();
		while(parameterItr.hasNext()) {
			String paramKey = parameterItr.next();
			String paramValue = request.getParameter(paramKey);
			session.setAttribute(paramKey, paramValue);
		}
		String menuId = request.getParameter("MENU_ID");
		setConnection(session);
		CookPitService menuService = new CookPitService();
		actionType = menuService.getMenuAction(session, getServletContext(), menuId);
		setMenuParameters(menuId, request);
		return menuService.getMenuScreenURL(session, getServletContext(), actionType);
	}
	
	public void setMenuParameters(String screenId, HttpServletRequest request){
		CookPitService menuService = new CookPitService();
		String userGroup = (String) request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
//		deallocateSessionObject(request);
		if(screenId!=null){
			MenuParameter menuParameter = menuService.getMenuParameter(screenId, userGroup, request, getServletContext());
			if(menuParameter!=null){
				request.getSession().setAttribute("GLOBAL.M_PARAM_1", menuParameter.getMENU_PARAMETER_1());
				request.getSession().setAttribute("GLOBAL.M_PARAM_2", menuParameter.getMENU_PARAMETER_2());
				request.getSession().setAttribute("GLOBAL.M_PARAM_3", menuParameter.getMENU_PARAMETER_3());
				request.getSession().setAttribute("GLOBAL.M_PARAM_4", menuParameter.getMENU_PARAMETER_4());
				request.getSession().setAttribute("GLOBAL.M_PARAM_5", menuParameter.getMENU_PARAMETER_5());
				request.getSession().setAttribute("GLOBAL.M_PARAM_6", menuParameter.getMENU_PARAMETER_6());
				request.getSession().setAttribute("GLOBAL.M_PARAM_7", menuParameter.getMENU_PARAMETER_7());
				request.getSession().setAttribute("GLOBAL.M_PARAM_8", menuParameter.getMENU_PARAMETER_8());
				request.getSession().setAttribute("GLOBAL.M_PARAM_9", menuParameter.getMENU_PARAMETER_9());
				request.getSession().setAttribute("GLOBAL.M_PARAM_10", menuParameter.getMENU_PARAMETER_10());
				request.getSession().setAttribute("GLOBAL.M_PARAM_11", menuParameter.getMENU_PARAMETER_11());
				request.getSession().setAttribute("GLOBAL.M_PARAM_12", menuParameter.getMENU_PARAMETER_12());
				request.getSession().setAttribute("GLOBAL.M_PARAM_13", menuParameter.getMENU_PARAMETER_13());
				request.getSession().setAttribute("GLOBAL.M_PARAM_14", menuParameter.getMENU_PARAMETER_14());
				request.getSession().setAttribute("GLOBAL.M_PARAM_15", menuParameter.getMENU_PARAMETER_15());
				request.getSession().setAttribute("GLOBAL.M_PARAM_16", menuParameter.getMENU_PARAMETER_16());
				request.getSession().setAttribute("GLOBAL.M_PARAM_17", menuParameter.getMENU_PARAMETER_17());
				request.getSession().setAttribute("GLOBAL.M_PARAM_18", menuParameter.getMENU_PARAMETER_18());
				request.getSession().setAttribute("GLOBAL.M_PARAM_19", menuParameter.getMENU_PARAMETER_19());
				request.getSession().setAttribute("GLOBAL.M_PARAM_20", menuParameter.getMENU_PARAMETER_20());
				request.getSession().setAttribute("GLOBAL.M_MODULE_NAME", menuParameter.getMENU_ACTION());
				request.getSession().setAttribute("GLOBAL.M_MODULE_CODE", menuParameter.getMENU_ACTION());
				request.getSession().setAttribute("GLOBAL.STD_CALLED_INST_CODE", menuParameter.getMENU_ACTION());
				request.getSession().setAttribute("GLOBAL.M_INST_CODE", menuParameter.getMENU_ACTION());
//				request.getSession().setAttribute("GLOBAL.M_SCR_NAME", menuParameter.getMENU_SCR_NAME());
				request.getSession().setAttribute("GLOBAL.M_PROG_CODE", new CookPitService().getProgramCode(request.getSession(), getServletContext(), menuParameter.getMENU_ACTION()));
			}
		}
	}
	
	public void deallocateSessionObject(HttpServletRequest request) {
		try {
			Enumeration<String> sessionAttr = request.getSession().getAttributeNames();
			CommonUtils.getConnection().rollback();
			while(sessionAttr.hasMoreElements()){
				String sessionAttrName = sessionAttr.nextElement();
				request.getSession().removeAttribute((String) sessionAttrName);
			}
		} catch (Exception e) {
		}
	}
	
	public void setConnection(HttpSession session) throws Exception {
		try {
			String userId = (String) session.getAttribute("GLOBAL.M_USER_ID");
			String clientId = userId+Calendar.getInstance().getTimeInMillis();
			 ((SimpleConnectionAgent) getServletContext().getAttribute("connectionAgent")).getConnection(clientId);
			 session.setAttribute("CLIENT_ID", clientId);
		} catch (Exception e) {
			throw e;
		}
	}
}
