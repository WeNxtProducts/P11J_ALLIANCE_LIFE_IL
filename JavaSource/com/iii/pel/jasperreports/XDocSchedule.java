
package com.iii.pel.jasperreports;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.apps.persistence.PremiaCryptograph;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.pel.forms.REPORT.CommonReport;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.utils.CommonUtils;
import com.sun.java.util.*;

/**
 * Servlet implementation class XDocSchedule
 */
public class XDocSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OP_REP_INFO OP_REP_INFO_BEAN;
	private IP_REP_INFO IP_REP_INFO_BEAN;



	//int paramCount = 0,valuecount = 0;
	/**
	 * @see HttpServlet#HttpServlet()
	 */


	/*added by Janani on 12.9.2016 for dynamic report*/

	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("Report_ID");
	private final static ResourceBundle resourceBundleDatabase = ResourceBundle
			.getBundle("login");
	/*end*/

	public XDocSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Get Method");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		int paramCount = 0,valuecount = 0;
		Connection con = null;
		String clientId = null;
		OP_REP_INFO_BEAN= new OP_REP_INFO();
		ResultSet rs=null ;
		
		
		if(session != null){
			System.out.println("INSIDE SESSION IN Premia Schedule         ");
			System.out.println("clientId         :"+session.getAttribute("CLIENT_ID"));
			
			try {	
				System.out.println("Welcome to POST Method");
				String REP_ID = request.getParameter("REP_ID");
				String REP_KEY_NO = request.getParameter("REP_KEY_NO");
				String POL_APPRV_STATUS =request.getParameter("STATUS");
				String REPORT_TYPE =request.getParameter("REPORT_TYPE");
				String moduleId =request.getParameter("MODULE_ID");
				clientId = (String) session.getAttribute("CLIENT_ID");
				
				/* Added by ganesh on 12-05-2017 for multiple report display */
				String Type=CommonUtils.nvl(request.getParameter("Type"),"S");
				String viewtype=CommonUtils.nvl(request.getParameter("viewtype"),"view");
				/*end*/
				/*Modified by Ganesh on 02/03/2017 for Mail attachment*/
				if(clientId!=null){
				con = ((SimpleConnectionAgent) getServletContext()
						.getAttribute("connectionAgent")).getConnection(clientId);
				IP_REP_INFO_BEAN =(IP_REP_INFO)session.getAttribute("REP_IP_REP_INFO");
				}else{
					
					con = getConnectionforXDOCS();
					 
					
				}
				/*End*/
				/*Added by saranya on 03-05-2017*/
				if(Type.equalsIgnoreCase("S")){
				
				ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
				ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				List<String> paramList = new ArrayList<String>();


				String IOParam = null,ParamDatatype = null, ProcName = null; 


				String query1 = "SELECT * FROM pm_rep_tab_hdr WHERE PMRTH_REP_ID = ?";
				ResultSet rs2 = new CRUDHandler().executeSelectStatement(query1, con,new Object[]{REP_ID});
				String jasperReportName = null,connectionReqd = null, procedureReqd = null,reportType = null;
				while(rs2.next())
				{
					procedureReqd = rs2.getString("PMRTH_PROC_REQD");
					reportType = rs2.getString("PMRTH_REP_CATG");
				}

				System.out.println("jasperReportName           "+jasperReportName);
				System.out.println("connectionReqd           "+connectionReqd);
				System.out.println("procedureReqd           "+procedureReqd);
				System.out.println("reportType           "+reportType);



				if(CommonUtils.nvl(procedureReqd,"X").equals("Y"))
				{
					String query = "SELECT * FROM PM_REP_PROC_PARAMS WHERE PMRTH_REP_ID = ?  ORDER BY 1";
					rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{REP_ID});
					query = "SELECT * FROM IP_REP_INFO WHERE REP_KEY_NO = ?";
					ResultSet rs1 = new CRUDHandler().executeSelectStatement(query, con,new Object[]{REP_KEY_NO});
					while(rs1.next())
					{

						for(int valueCount = 1;valueCount <= 8;valueCount++)
						{
							String paramValue=null;
							/*Modified by gopi for handling null on 08/06/17*/
							/*Modified by gopi for increasing count 2 to 8 on 31/05/17*/
							/*if(valueCount!=2)
							{
								paramValue = rs1.getString("REP_VALUE_"+valueCount);
								paramList.add(paramValue);
							}
							else
							{
								paramValue = rs1.getString("REP_KEY_NO");
								paramList.add(paramValue);

							}*/
							if(rs1.getString("REP_VALUE_"+valueCount)!=null){
								
								paramValue = rs1.getString("REP_VALUE_"+valueCount);
								paramList.add(paramValue);
							}


						}
							paramList.add(rs1.getString("REP_KEY_NO"));
	                        //end

					}
					int outcount=0;
					while(rs.next())
					{
						IOParam = rs.getString("PMRTH_PARAM_TYPE");
						ParamDatatype = rs.getString("PMRTH_PARAM_DATATYPE");
						ProcName = rs.getString("PMRTH_PROC_NAME");

						System.out.println("IOParam           "+IOParam);
						System.out.println("ParamDatatype           "+ParamDatatype);
						System.out.println("ProcName           "+ProcName);

						OracleParameter param111; 
						if(IOParam != null)
						{
							if(IOParam.equals("IN"))
							{
								param111 = new OracleParameter(IOParam+(paramCount+1),ParamDatatype,IOParam,paramList.get(valuecount));
								parameterList.add(param111);
								valuecount++;
							}
							else
							{
								param111 = new OracleParameter(IOParam+(paramCount+1),ParamDatatype,IOParam,null);
								parameterList.add(param111);	
								outcount++;

							}
						}
						paramCount++;
					}
					System.out.println("valuecount  : "+valuecount);
					System.out.println("outcount    : "+outcount);
					System.out.println("parameterList SIZE   : "+parameterList.size());


					ListIterator<OracleParameter> itr=parameterList.listIterator();  

					System.out.println("traversing elements in forward direction...");  
					while(itr.hasNext()){  
						System.out.println(itr.next());  
					}  

					outputList = procHandler.execute(parameterList, con,
							ProcName);

					/*	if(outputList!=null)
					{

						Iterator<OracleParameter> iterator = outputList.iterator();
						int count =0;
						while (iterator.hasNext()) {
							count++;
							OracleParameter oracleParameter = iterator.next();
							System.out.println("Output value:::" + oracleParameter.getValue());
							System.out.println("bean value  :"+OP_REP_INFO_BEAN);
							Class cls = OP_REP_INFO_BEAN.getClass();
							for (Method method : cls.getMethods()) {
								if ((method.getName()) != null) {
									String setMethodName = "setOP_REP_VALUE_"+(count);
									//System.out.println("setMethodName    :  "+setMethodName);
									if ((method.getName().equals(setMethodName))) {


										try {
											method.setAccessible(true);

											method.invoke(OP_REP_INFO_BEAN, oracleParameter.getValue()==null?"":oracleParameter.getValue());

										} catch (Exception e) {
										e.getMessage();
										}

									}
								}
								//}

							}

						}
						OP_REP_INFO_BEAN.setOP_REP_KEY_NO(REP_KEY_NO);	
						OP_REP_INFO_BEAN.setOP_REP_ID(REP_ID);
						insertinfo(con,OP_REP_INFO_BEAN);
						String rep_template_name = template_name(moduleId,POL_APPRV_STATUS,REPORT_TYPE,con);
						String url=genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null,con);
					System.out.println(url);
						response.sendRedirect(url);
					}
					
					comented by dhinesh on 13.12.2016
					
					*/
					String rep_template_name = template_name(moduleId,POL_APPRV_STATUS,REPORT_TYPE,con);
					/* Modified by ganesh on 12-05-2017*/
					/*Modified by Ram on 02/03/2017 for Mail purpose*/
					String url=genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null,con,moduleId,REP_KEY_NO,REP_ID,"S",viewtype);
					/*End*/
					System.out.println(url);
					response.sendRedirect(url);
				}
				else
				{
					System.out.println("Procedure not required else block");
					String rep_template_name = template_name(moduleId,POL_APPRV_STATUS,REPORT_TYPE,con);
					/* Modified by ganesh on 12-05-2017*/
					/*Modified by Ram on 02/03/2017 for Mail purpose*/
					String url=genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null,con,moduleId,REP_KEY_NO,REP_ID,"S",viewtype);
					/*End*/
					System.out.println(url);
					response.sendRedirect(url);
				}
				}else{
					String multiRepID = null;
					if("view".equalsIgnoreCase(viewtype)){
					String queryNew = "SELECT PMRTH_MULTIPLE_REPORT_NAMES FROM pm_rep_tab_hdr WHERE PMRTH_REP_ID = ?";
					ResultSet rs5 = new CRUDHandler().executeSelectStatement(queryNew, con,new Object[]{REP_ID});
					while(rs5.next())
					{
						multiRepID = rs5.getString("PMRTH_MULTIPLE_REPORT_NAMES");
					}
					}else{
						String queryNew = "SELECT PMRTH_MAIL_ATTACH_REQD FROM pm_rep_tab_hdr WHERE PMRTH_REP_ID = ?";
						ResultSet rs5 = new CRUDHandler().executeSelectStatement(queryNew, con,new Object[]{REP_ID});
						/*String multiRepID = null;*/
						while(rs5.next())
						{
							multiRepID = rs5.getString("PMRTH_MAIL_ATTACH_REQD");
						}
						System.out.println("multiRepID   :"+multiRepID  );
					}
					System.out.println("multiRepID   :"+multiRepID   +"MULTI_REP_KEY_NO   :"+REP_KEY_NO);
					
					String[] splitRepIDArray = multiRepID.split(",");
					String[] splitRepKeyNoArray= REP_KEY_NO.split(",");
					int length=splitRepIDArray.length;
					System.out.println("length splitRepID :"+length);
					
					for(int i=0;i<length;i++){
						
						System.out.println("splitRepID :"+splitRepIDArray[i]);
						System.out.println("splitRepKeyNo :"+splitRepKeyNoArray[i]);			
						ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
						ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
						OracleProcedureHandler procHandler = new OracleProcedureHandler();
						List<String> paramList = new ArrayList<String>();


						String IOParam = null,ParamDatatype = null, ProcName = null; 


						String query1 = "SELECT * FROM pm_rep_tab_hdr WHERE PMRTH_REP_ID = ?";
						ResultSet rs2 = new CRUDHandler().executeSelectStatement(query1, con,new Object[]{splitRepIDArray[i]});
						String jasperReportName = null,connectionReqd = null, procedureReqd = null,reportType = null;
						while(rs2.next())
						{
							procedureReqd = rs2.getString("PMRTH_PROC_REQD");
							reportType = rs2.getString("PMRTH_REP_CATG");
							
						}

						System.out.println("jasperReportName           "+jasperReportName);
						System.out.println("connectionReqd           "+connectionReqd);
						System.out.println("procedureReqd           "+procedureReqd);
						System.out.println("reportType           "+reportType);
						if(CommonUtils.nvl(procedureReqd,"X").equals("Y"))
						{
							String query = "SELECT * FROM PM_REP_PROC_PARAMS WHERE PMRTH_REP_ID = ?  ORDER BY 1";
							rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{splitRepIDArray[i]});
							query = "SELECT * FROM IP_REP_INFO WHERE REP_KEY_NO = ?";
							ResultSet rs1 = new CRUDHandler().executeSelectStatement(query, con,new Object[]{splitRepKeyNoArray[i]});
							while(rs1.next())
							{

								for(int valueCount = 1;valueCount <= 8;valueCount++)
								{
									String paramValue=null;
									/*Modified by gopi for handling null on 08/06/17*/
									/*Modified by gopi for increasing count 2 to 8 on 31/05/17*/
									/*if(valueCount!=2)
									{
										paramValue = rs1.getString("REP_VALUE_"+valueCount);
										paramList.add(paramValue);
									}
									else
									{
										paramValue = rs1.getString("REP_KEY_NO");
										paramList.add(paramValue);

									}*/
									if(rs1.getString("REP_VALUE_"+valueCount)!=null){
										
										paramValue = rs1.getString("REP_VALUE_"+valueCount);
										paramList.add(paramValue);
									}
								}
									paramList.add(rs1.getString("REP_KEY_NO"));
			                      //end
							}
							
							int outcount=0;
							valuecount = 0;
							while(rs.next())
							{
								IOParam = rs.getString("PMRTH_PARAM_TYPE");
								ParamDatatype = rs.getString("PMRTH_PARAM_DATATYPE");
								ProcName = rs.getString("PMRTH_PROC_NAME");

								System.out.println("IOParam           "+IOParam);
								System.out.println("ParamDatatype           "+ParamDatatype);
								System.out.println("ProcName           "+ProcName);
								
								OracleParameter param111; 
								if(IOParam != null)
								{
									if(IOParam.equals("IN"))
									{
										param111 = new OracleParameter(IOParam+(paramCount+1),ParamDatatype,IOParam,paramList.get(valuecount));
										parameterList.add(param111);
										valuecount++;
									}
									else
									{
										param111 = new OracleParameter(IOParam+(paramCount+1),ParamDatatype,IOParam,null);
										parameterList.add(param111);	
										outcount++;

									}
								}
								paramCount++;
							}
							System.out.println("valuecount  : "+valuecount);
							System.out.println("outcount    : "+outcount);
							System.out.println("parameterList SIZE   : "+parameterList.size());
							ListIterator<OracleParameter> itr=parameterList.listIterator();  

							System.out.println("traversing elements in forward direction...");  
							while(itr.hasNext()){  
								System.out.println(itr.next());  
							}  
							outputList = procHandler.execute(parameterList, con,
									ProcName);
						
					}
						
					
					}
					String rep_template_name ="";
						String url=genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null,con,moduleId,REP_KEY_NO,REP_ID,"M",viewtype);
						System.out.println("["+url+"]");
						response.sendRedirect(url);
					
				}

				/*End*/


			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	void insertinfo(Connection con,OP_REP_INFO bean) {
		try{
			//PRE_INSERT(bean);
			String deleteQuery="DELETE FROM OP_REP_INFO WHERE OP_REP_KEY_NO= ?";

			new CRUDHandler().executeDeleteStatement(deleteQuery, con, new Object[]{bean.getOP_REP_KEY_NO()});
			con.commit();
			new CRUDHandler().executeInsert(bean, con);
			con.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void PRE_INSERT(OP_REP_INFO OP_REP_INFO_BEAN) {

		try {
			OP_REP_INFO_BEAN.setOP_REP_ID("PGLR_REC_C");
			/*	IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
				.getGlobalVariable("GLOBAL.M_COMP_CODE"));
		IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
				.getGlobalVariable("GLOBAL.M_LANG_CODE"));
		IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
				.getGlobalVariable("GLOBAL.M_USER_ID"));*/
			OP_REP_INFO_BEAN.setOP_REP_UPD_DT(new Date());
			//IP_REP_INFO_BEAN.setOLD_UPD_DT(new Date());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*added by Janani on 12.9.2016 for dynamic report */


/*Modified by ganesh on 12-05-2017 */
	/*public static String genReport(IP_REP_INFO IP_REP_INFO_BEAN,
			String reportType,String reportName,String reportCategory,String reportTemplateName,String status,Connection con,String MODULE_ID,String REP_KEY_NO)*/
	public static String genReport(IP_REP_INFO IP_REP_INFO_BEAN,
			String reportType,String reportName,String reportCategory,String reportTemplateName,String status,Connection con,String MODULE_ID
			,String REP_KEY_NO,String reportTemplateRepID,String Type,String viewtype)
	{
		String url=null;
		try
		{
			String jasperReportName = null,connectionReqd = null, procedureReqd = null,query= null;
			String rep_id=MODULE_ID;
			System.out.println("MODULE_ID             :"+MODULE_ID+"          "+"con               "+con );
			//query = "SELECT * FROM PM_REP_TAB_HDR WHERE PMRTH_MODULE_ID = ?";
			/*Modified by saranya for Multiple report attachment on 05/05/2017*/
			query = "SELECT * FROM PM_REP_TAB_HDR WHERE PMRTH_MODULE_ID = ? AND PMRTH_REP_ID=?";
			/*End*/
			ResultSet rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{MODULE_ID,reportTemplateRepID});
			while(rs.next())
			{
				connectionReqd = rs.getString("PMRTH_CONN_REQD");
				procedureReqd = rs.getString("PMRTH_PROC_REQD");
			}

			System.out.println("procedureReqd in common report               "+procedureReqd);
			System.out.println("reportCategory           "+reportCategory);
			if("S".equalsIgnoreCase(reportCategory))
			{
				System.out.println("enters into reportCategory S");
				//if(reportType !=null && reportName !=null && reportTemplateName !=null)
				//url=resourceBundle.getString("mdocsUrl")+"repKeyNo="+REP_KEY_NO+"&repId="+MODULE_ID+"&templateId="+reportTemplateName;
				/*Modified by saranya for Multiple report attachment on 05/05/2017*/
				url=resourceBundle.getString("mdocsUrl")+"repKeyNo="+REP_KEY_NO+"&repId="+MODULE_ID+"&templateId="+reportTemplateName+"&templateRepId="+reportTemplateRepID+"&Type="+Type+"&viewtype="+viewtype;
				/*End*/
				System.out.println("getREP_KEY_NO()       :"+REP_KEY_NO);

				System.out.println("getMODULE_ID()           :"+MODULE_ID);

				System.out.println("templateId()          :"+reportTemplateName);

				System.out.println("url         :"+url);
				System.out.println("templateRepId()          :"+reportTemplateRepID+"  Type    :"+Type);
			}
			else if("L".equalsIgnoreCase(reportCategory))
			{
				String rep_key=REP_KEY_NO;

				/*if(procedureReqd != null && procedureReqd.equals("Y"))*/
				if(procedureReqd != null && (CommonUtils.nvl(procedureReqd,"X").equals("Y")))
				{
					url=resourceBundle.getString("Jasper_bordeauxUrl")+"MODULE_ID="+reportTemplateName+"&REP_GL_ID="+MODULE_ID+"&REP_KEY_NO="+REP_KEY_NO;
				}
				else
				{
					url=resourceBundle.getString("premiaReportUrl")+"MODULE_ID="+reportTemplateName+"&REP_GL_ID="+MODULE_ID+"&REP_SEQ_ID="+REP_KEY_NO;

				}
				//response.sendRedirect(url);

			}
			/*else if("LS".equalsIgnoreCase(reportCategory))
		{
			String rep_key=REP_KEY_NO;
			String MODULE_ID=MODULE_ID;
			url=resourceBundle.getString("Jasper_bordeauxUrl")+"MODULE_ID="+reportTemplateName+"&REP_GL_ID="+MODULE_ID+"&REP_SEQ_ID="+REP_KEY_NO;

		}*/
			else
			{
				String rep_key=REP_KEY_NO;
				MODULE_ID=MODULE_ID;

				query = "SELECT * FROM pm_rep_tab_hdr WHERE PMRTH_MODULE_ID = ?";
				rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{MODULE_ID});
				String jasperReportid = null;
				while(rs.next())
				{
					jasperReportid = rs.getString("PMRTH_REP_ID");
				}
				System.out.println("jasperReportid       "+jasperReportid);
				url=resourceBundle.getString("Jasper_bordeauxUrl")+"MODULE_ID="+jasperReportid+"&REP_KEY_NO="+REP_KEY_NO;


			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return url;

	}


	public String template_name(String moduleId,String POL_APPRV_STATUS,String reportType,Connection con)throws Exception
	{

		System.out.println("inside template_name method");



		//String userGroup = (String) request.getSession().getAttribute("GLOBAL.M_MODULE_ID");


		Connection connection = null;
		connection = con;
		ResultSet resultSet = null;
		String PMRTH_REP_TEMPLETE_NAME = null;

		CRUDHandler handler = new CRUDHandler();	

		//String query ="SELECT * FROM pm_rep_tab_hdr WHERE PMRTH_MODULE_ID = 'PILT002_APAC' AND PMRTH_REP_STATUS = "+POL_APPRV_STATUS+" AND PMRTH_REP_TYPE = 'PRO' AND PMRTH_REP_CATG = 'S'";

		System.out.println("moduleId          		:"+moduleId);
		System.out.println("POL_APPRV_STATUS        :"+POL_APPRV_STATUS);
		System.out.println("reportType          	:"+reportType);


		if(POL_APPRV_STATUS!=null&&reportType!=null){

			String query ="SELECT PMRTH_REP_TEMP_NAME_ID FROM pm_rep_tab_hdr WHERE PMRTH_MODULE_ID = ? AND PMRTH_REP_STATUS = ? AND PMRTH_REP_ID = ? AND PMRTH_REP_CATG = 'S'";

			resultSet = new CRUDHandler().executeSelectStatement(
					query, connection,new Object[]{moduleId,POL_APPRV_STATUS,reportType});


			while (resultSet.next()) {

				PMRTH_REP_TEMPLETE_NAME=resultSet.getString("PMRTH_REP_TEMP_NAME_ID");
			}	
		}
		else
		{

			String query ="SELECT PMRTH_REP_TEMP_NAME_ID FROM pm_rep_tab_hdr WHERE PMRTH_MODULE_ID = ? AND PMRTH_REP_CATG = 'L'";

			resultSet = new CRUDHandler().executeSelectStatement(
					query, connection,new Object[]{moduleId});


			while (resultSet.next()) {

				PMRTH_REP_TEMPLETE_NAME=resultSet.getString("PMRTH_REP_TEMP_NAME_ID");
			}	
		}



		return PMRTH_REP_TEMPLETE_NAME;
	}

	/*Modified by Ganesh on 02/03/2017 for Mail attachment*/
	public Connection getConnectionforXDOCS() throws  Exception {
		Connection dbCon=null;
		String userName = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_user_name"));
		String passWord = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_password"));
		String jdbcURL = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_url"));
		String jdbcDriver = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("jdbc.datasource.driver"));
	
		
		try{
			System.out.println("welcome to getConnectionforXDOCS      "+userName+"  "+passWord+"  "+jdbcURL+"  "+jdbcDriver+"  ");
			Class.forName(jdbcDriver);
			dbCon = DriverManager.getConnection(jdbcURL,userName,passWord);
			dbCon.setAutoCommit(false);
			
			System.out.println("dbCon     "+dbCon);
			
		}catch(Exception e){
			
			
			e.printStackTrace();
		}
		return dbCon;
	}
/*End*/
















}