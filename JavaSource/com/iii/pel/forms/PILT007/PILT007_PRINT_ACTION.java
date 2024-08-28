package com.iii.pel.forms.PILT007;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PILT007_PRINT_ACTION extends CommonReportAction{
	
	public PILT007_COMPOSITE_ACTION compositeAction;
	
	public PILT007_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT007_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	private IP_REP_INFO IP_REP_INFO_BEAN;

	private HtmlOutputLabel COMP_UI_M_CLAIM_REPORT_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_CLAIM_REPORT;
	private PT_IL_CLAIM_HELPER helper;
	String CLAIM_STATUS="";
	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("FalconReports");
	
	private List<SelectItem> listUI_M_CLAIM_REPORT_TYPE = new ArrayList<SelectItem>();
	
	
	public HtmlOutputLabel getCOMP_UI_M_CLAIM_REPORT_LABEL() {
		return COMP_UI_M_CLAIM_REPORT_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_REPORT_LABEL(
			HtmlOutputLabel cOMP_UI_M_CLAIM_REPORT_LABEL) {
		COMP_UI_M_CLAIM_REPORT_LABEL = cOMP_UI_M_CLAIM_REPORT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_CLAIM_REPORT() {
		return COMP_UI_M_CLAIM_REPORT;
	}

	public void setCOMP_UI_M_CLAIM_REPORT(HtmlSelectOneMenu cOMP_UI_M_CLAIM_REPORT) {
		COMP_UI_M_CLAIM_REPORT = cOMP_UI_M_CLAIM_REPORT;
	}

	public List<SelectItem> getListUI_M_CLAIM_REPORT_TYPE() {
		return listUI_M_CLAIM_REPORT_TYPE;
	}

	public void setListUI_M_CLAIM_REPORT_TYPE(
			List<SelectItem> listUI_M_CLAIM_REPORT_TYPE) {
		this.listUI_M_CLAIM_REPORT_TYPE = listUI_M_CLAIM_REPORT_TYPE;
	}
	


	private String UI_M_CLAIM_REPORT;

	public String getUI_M_CLAIM_REPORT() {
		return UI_M_CLAIM_REPORT;
	}

	public void setUI_M_CLAIM_REPORT(String uI_M_CLAIM_REPORT) {
		UI_M_CLAIM_REPORT = uI_M_CLAIM_REPORT;
	}

	public PT_IL_CLAIM_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_CLAIM_HELPER helper) {
		this.helper = helper;
	}

	public PILT007_PRINT_ACTION() {
		// TODO Auto-generated constructor stub
		helper = new PT_IL_CLAIM_HELPER();
		IP_REP_INFO_BEAN=new IP_REP_INFO();
	}
	
	
	
	
	
	private void prepareDropDowns(){
		try{

			/*
			 * Commented modified by gopi on 22/05/17*
			 * 
			 * listUI_M_CLAIM_REPORT_TYPE=(CommonReportAction.getDropDownListValue( CommonUtils.getConnection(),CLAIM_STATUS, 
					"CLM","C"));*/
			String plan_code=Product_code();
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String moduleId = (String) sessionMap.get("GLOBAL.M_MODULE_ID");
			
			
			/*
			 * Commented modified by gopi on 22/05/17*
			 * 
			 * listUI_M_CLAIM_REPORT_TYPE=(CommonReportAction.getDropDownListValue_1(
					CommonUtils.getConnection(),CLAIM_STATUS,"CLM","C",plan_code,null));*/
			
			/*Added modified by gopi on 22/05/17*/
			
			listUI_M_CLAIM_REPORT_TYPE=getDropDownListValue_1(
					CommonUtils.getConnection(),CLAIM_STATUS,"CLM","C",plan_code,moduleId,null);
			
			/*End*/
			

			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
		
	
	public void onLoad(PhaseEvent event){
		CommonUtils.clearMaps(this);
		try
		{
			System.out.println("inside onload");
			CLAIM_STATUS = compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_ADDL_STATUS();
			System.out.println("CLAIM_STATUS ::" + CLAIM_STATUS);
			prepareDropDowns();
	}catch(Exception Ex){
		Ex.printStackTrace();
	}
	
}
	
	public void validatorUI_M_CLAIM_REPORT(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			setUI_M_CLAIM_REPORT((String)value);
			System.out.println("getUI_M_SCHEDULE_TYPE()   : "+getUI_M_CLAIM_REPORT());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public String backButton() {
		
		return "GO_TO_PT_IL_CLAIM";
	}
	
	//added by gopi for toi on 05/07/2018
	String ScheduleReportType = null;
	
	public  String getScheduleReportType()throws Exception{

		System.out.println("inside selectpolstatus method");
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();	
		
		String query = "select ps_value from pp_system1 where ps_type like 'SCHDREPTYPE%'";
		System.out.println("schedule type query "+query);	     
		resultSet = new CRUDHandler().executeSelectStatement(query, connection);
		System.out.println("value for insert"+	handler.executeSelectStatement(query, connection));
		while (resultSet.next()) {
			ScheduleReportType=resultSet.getString("ps_value");

		}
		
		
		System.out.println("ScheduleReportType                    :"+ScheduleReportType);
		
		return ScheduleReportType;
	}
	
	
	//end
	public String runAction(){

		Connection runActionConnection = null;


		//String url = null;
		String POL_SYS_ID=null;
		/*HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/XDocSchedule?";
		System.out.println("url   :  "+url);
		setRedirectUrl(url);*/

		try{
			
			String SCHEDULE_REPORT_TYPE=compositeAction.getPILT007_PRINT_ACTION_BEAN().getUI_M_CLAIM_REPORT();
			String REPORT_CATG = null;
			String reportQuery1 = "SELECT PMRTH_REPORT_CATG FROM PM_REP_TAB_HDR WHERE PMRTH_REP_ID=? ";
			ResultSet reportRSSS = new CRUDHandler().executeSelectStatement(reportQuery1, CommonUtils.getConnection(),new Object[]{SCHEDULE_REPORT_TYPE});
			while(reportRSSS.next())
			{
				REPORT_CATG = reportRSSS.getString("pmrth_report_catg");
			}
			if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("S")){
					ScheduleReportType = "1";	
				}else{
					ScheduleReportType = "2";
				}
			//END
			if(ScheduleReportType.equalsIgnoreCase("2"))

			{
			
			/*Added by saritha on 28-09-2020 for Alliance : RedirectUrl*/
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK(this));
			/*End*/

			runActionConnection = CommonUtils.getConnection();
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				System.out.println("ENTER IP_REP_INFO_BEAN");

				Connection connection = null;
				ResultSet resultSet = null;
				Object[] values = null;
				POL_SYS_ID =String.valueOf(compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID());
				String CLAIM_SYS_ID=compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID().toString();
				PRE_INSERT(this.IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setREP_VALUE_1(POL_SYS_ID);
				IP_REP_INFO_BEAN.setREP_VALUE_2(CLAIM_SYS_ID);
				int recordCount = new CRUDHandler().executeInsert(IP_REP_INFO_BEAN,
						runActionConnection);
				runActionConnection.commit();
			}else {

				PRE_UPDATE(this.IP_REP_INFO_BEAN);
				//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
			}
			}else
			{
				//setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
				setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK(this));
			}


		}catch(Exception e){
			e.printStackTrace();
		}
		return getRedirectUrl();



	}
	StringBuffer url=null;
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session = request.getSession();
	public String runActionAfterValidate() {

		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		try {
			String SCHEDULE_REPORT_TYPE_NEW=compositeAction.getPILT007_PRINT_ACTION_BEAN().getUI_M_CLAIM_REPORT();
			String REPORT_CATG = null;
			String reportQuery1 = "SELECT PMRTH_REPORT_CATG FROM PM_REP_TAB_HDR WHERE PMRTH_REP_ID=? ";
			ResultSet reportRSSS = new CRUDHandler().executeSelectStatement(reportQuery1, CommonUtils.getConnection(),new Object[]{SCHEDULE_REPORT_TYPE_NEW});
			while(reportRSSS.next())
			{
				REPORT_CATG = reportRSSS.getString("pmrth_report_catg");
			}
			if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("S")){
					ScheduleReportType = "1";	
				}else{
					ScheduleReportType = "2";
				}
			//END
			
			
			
			if(ScheduleReportType != null && ScheduleReportType.equals("2")){
			String rep_template_name=null;
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String moduleId = (String) sessionMap.get("GLOBAL.M_MODULE_ID");
			session.setAttribute("REP_IP_REP_INFO", IP_REP_INFO_BEAN);
			/*setRedirectUrl(getRedirectUrl()+"REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&REP_ID=PREMIREP127&REPORT_TYPE=PREMIREP117&STATUS=A&MODULE_ID="+moduleId);
			System.out.println("End");*/
			String SCHEDULE_REPORT_TYPE=compositeAction.getPILT007_PRINT_ACTION_BEAN().getUI_M_CLAIM_REPORT();
			//String POL_APPRV_STATUS=compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_STATUS();
			String POL_APPRV_STATUS = CLAIM_STATUS();
			rep_template_name="&REP_ID="+SCHEDULE_REPORT_TYPE+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+SCHEDULE_REPORT_TYPE;
			System.out.println("request.getServerName()  :"+request.getServerName());
			setRedirectUrl(getRedirectUrl()+rep_template_name);
			System.out.println("End");

			if(rep_template_name == null)
			{
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "77775",
						new Object[]{"Not a valid report"})));
			}
		
			if (getRedirectUrl() != null) {
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				response.sendRedirect(getRedirectUrl());
			}

			}else{
				Long CLAIM_SYS_ID=compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
				Long CLAIM_POL_SYS_ID=compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
				System.out.println("PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID()   : "+CLAIM_SYS_ID);
				String report_id = "";
			
				report_id = compositeAction.getPILT007_PRINT_ACTION_BEAN().getUI_M_CLAIM_REPORT();
				
				
				IP_REP_INFO repInfo = new IP_REP_INFO();
				String REP_KEY_NO = new ReportUtils().getRepKeyNo();
				repInfo.setREP_KEY_NO(REP_KEY_NO);
				repInfo.setREP_VALUE_1("20");
				repInfo.setREP_VALUE_2("POL_SYS_ID"+"&&&"+CLAIM_POL_SYS_ID);
				repInfo.setREP_VALUE_3("CLAIM_POL_SYS_ID"+"&&&"+CLAIM_SYS_ID);
				int repInfoLoop = 4;
				String Logoquery="SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE='IL_REP_LOGO'"; 
				 ResultSet RESULT = null;
				 int psvalue=0;
					try {
					 RESULT = new CRUDHandler().executeSelectStatement(Logoquery, CommonUtils.getConnection());
					 if(RESULT.next()) {
						 psvalue = RESULT.getInt("PS_VALUE");
					 }
					
					} catch (Exception e) {
					 e.printStackTrace();
				 } 
				String LogoPath=System.getProperty("user.home")+"/ALLIANCE_LOGO/";
				
						for(int i=1;i<=psvalue;i++){
						setvaluesintoRepInfoBean(repInfo,("LOGO"+i+"&&&"+LogoPath+report_id+"_"+i+".jpg"),"setREP_VALUE_"+repInfoLoop);
						repInfoLoop++;
						
						}
				repInfo.setREP_VALUE_1(Integer.toString(repInfoLoop));	
				Connection conn = CommonUtils.getConnection();
				int ins = new CRUDHandler().executeInsert(repInfo, conn);
				conn.commit();
				System.out.println("Claim report_id ::" + report_id);
				url=new StringBuffer(getRedirectUrl());
				System.out.println("this is url"+url.toString());
				url.append("REP_ID="+report_id+"&REP_KEY_NO="+REP_KEY_NO);	
				String reportViewType = CommonUtils.getGlobalVariable("reporttype");
				if(reportViewType!=null){
					url.append("&viewtype="+reportViewType);
				}
				
				/*End*/
				System.out.println("after append"+url.toString());
				setRedirectUrl(url.toString());
				
				if (getRedirectUrl() != null && CommonUtils.getGlobalVariable("reporttype").equals("view")) {
					response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
					System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
					response.sendRedirect(getRedirectUrl());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	
	
	private String Product_code() throws Exception{
		String executeQuery = "select POL_PLAN_CODE from pt_il_policy where  pol_no=?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String POL_PLAN_CODE = null;
		
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(executeQuery, con,
					new Object[] {compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()});
			if (rs.next()) {
				POL_PLAN_CODE = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return POL_PLAN_CODE;
		
	}

	
	
			private String CLAIM_STATUS() throws Exception{
		String executeQuery ="select CLAIM_STATUS from pt_il_claim where CLAIM_POL_NO=?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String CLAIM_STATUS = null;
		
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(executeQuery, con,
					new Object[] {compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()});
			if (rs.next()) {
				CLAIM_STATUS = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return CLAIM_STATUS;
		
	}
	
	
	
	
	public void PRE_INSERT(IP_REP_INFO iP_REP_INFO_BEAN) {

		try {

			iP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			iP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID"));
			iP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			iP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			iP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			iP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID"));
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	
	/*ADDED BY GOPI FOR DYNAMIC LISTING ON 22/05/2017*/
	
	public static List<SelectItem> getDropDownListValue_1(Connection connection, String pol_status, String report_type, String typevalue,String prod_code,String module_id,String Addl_sts){
		
		List<SelectItem> listValues = null;
		String query = null;
		ResultSet rst=null;
		try {
			/*aDDED BY SANKARA NARAYANAN FOR list the report type based on aditional status 16-02-2017*/
			
			

			System.out.println("pol_status                 :"+pol_status+"   report_type        "+report_type+"      typevalue         "+typevalue+"    prod_code       "+
					prod_code+"     Addl_sts        "+Addl_sts);
			
			
			
		if(Addl_sts==null){
		query = "SELECT PMLIT_KEY, PMLIT_VALUE " +
					  "FROM pm_rep_tab_dtl " +
					 " WHERE SYS_PARAM = ? " +
					   " AND ITEM_NAME = ? " +
					   " AND PMLIT_FLAG = ? "+
					   " AND PMLIT_FORM_ID= ? "+
					   " AND PMLIT_PROD_CODE LIKE ? ";
		Object[] values = {pol_status , report_type ,typevalue,module_id,"%"+prod_code+"%"};
		 rst = new CRUDHandler().executeSelectStatement(query, connection, values);
		}else{
			query = "SELECT PMLIT_KEY, PMLIT_VALUE " +
					  "FROM pm_rep_tab_dtl " +
					 " WHERE SYS_PARAM = ? " +
					   " AND ITEM_NAME = ? " +
					   " AND PMLIT_FLAG = ? "+
					   " AND PMLIT_FORM_ID= ? "+
					   " AND PMLIT_PROD_CODE LIKE ?"+
					   "AND PMILT_ADDL_STS LIKE ?";
			Object[] values= {pol_status , report_type ,typevalue,module_id,"%"+prod_code+"%","%"+Addl_sts+"%"};
			
			
			
			rst = new CRUDHandler().executeSelectStatement(query, connection, values);
		}
		/*END*/
		listValues = new ArrayList<SelectItem>();
				while(rst.next()){
					System.out.println("*****************");
						System.out.println("INSIDE WHILE LOOP"+rst.getString("PMLIT_KEY")+"******"+rst.getString("PMLIT_VALUE"));
					
					listValues.add(new SelectItem(rst.getString("PMLIT_KEY"),rst.getString("PMLIT_VALUE")));
				}
				rst.close();
				rst.getStatement().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return listValues;
	}
	
	
	/*End*/
	//added by gopi for toi on 30/06/2018
		 public static Object setvaluesintoRepInfoBean(
					IP_REP_INFO ob, String value,
					String methodName) throws Exception {

				Class cls = ob.getClass();

				for (Method method : cls.getMethods()) {
					if ((method.getName()) != null) {
						String setMethodName = methodName;

						if ((method.getName().equals(setMethodName))) {


							try {
								System.out.println("setMethodName       "+setMethodName);
								method.setAccessible(true);

								method.invoke(ob, value);

							} catch (Exception e) {
								System.err.println("Error Occured in setvaluesintoBean "+e.getMessage());
							}

						}
					}
				}

				return ob;
			}

		 //end
			/*added by gopi for toi on 25/06/2018*/
		 public String callReportModalPanel(){
		 		
		 		CommonUtils.setGlobalVariable("reporttype","view");
		 		
		 		return super.callReportModalPanel();
		 		
		 	}
		 	
		 	//end
		 
}
