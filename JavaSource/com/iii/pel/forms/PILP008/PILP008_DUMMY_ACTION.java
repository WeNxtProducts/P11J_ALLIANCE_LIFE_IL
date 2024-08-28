package com.iii.pel.forms.PILP008;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY_ACTION;
import com.iii.pel.forms.PILT007.PILT007_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT007.PT_IL_CLAIM_ACTION;
import com.iii.pel.forms.PILT007.PT_IL_CLAIM_PAID_ACTION;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PILP008_DUMMY_ACTION extends CommonAction {

	private HtmlInputText COMP_UI_M_M_POL_NO;


	private HtmlCalendar COMP_UI_M_M_APPRV_DATE;

	private HtmlOutputLabel COMP_UI_M_M_CLAIM_GEN_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_M_CLAIM_GEN_YN;

	private HtmlOutputLabel COMP_UI_M_M_BROK_GEN_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_M_BROK_GEN_YN;

	private HtmlCommandButton COMP_UI_M_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_M_BUT_CANCEL;

	private HtmlCommandButton COMP_UI_M_M_BUT_POL_LOV;

	private HtmlInputText COMP_ROWID;
	
	private HtmlOutputLabel COMP_UI_M_APPRV_DATE_LABEL;

	private List<SelectItem> CLAIM_GEN_LIST = new ArrayList<SelectItem>()  ;
	private List<SelectItem> BROK_GEN_LIST = new ArrayList<SelectItem>();

	private DUMMY DUMMY_BEAN;
	
	//Added by ganesh on 17-03-2017 for settlement report generation on approval
	private PILP008_PRINT_ACTION PRINT_ACTION_BEAN;
	//end

	public PILP008_DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		instantiateAllComponent();
		//Added by ganesh on 17-03-2017 for settlement report generation on approval
				PRINT_ACTION_BEAN = new PILP008_PRINT_ACTION();
				PRINT_ACTION_BEAN.compositeDummyAction = this;
				//end
	}

	public HtmlInputText getCOMP_UI_M_M_POL_NO() {

		return COMP_UI_M_M_POL_NO;
	}

	public void setCOMP_UI_M_M_POL_NO(HtmlInputText COMP_UI_M_M_POL_NO) {
		this.COMP_UI_M_M_POL_NO = COMP_UI_M_M_POL_NO;
	}


	public HtmlCalendar getCOMP_UI_M_M_APPRV_DATE() {
		return COMP_UI_M_M_APPRV_DATE;
	}

	public void setCOMP_UI_M_M_APPRV_DATE(HtmlCalendar COMP_UI_M_M_APPRV_DATE) {
		this.COMP_UI_M_M_APPRV_DATE = COMP_UI_M_M_APPRV_DATE;
	}


	public HtmlOutputLabel getCOMP_UI_M_M_CLAIM_GEN_YN_LABEL() {
		return COMP_UI_M_M_CLAIM_GEN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_M_CLAIM_GEN_YN() {
		return COMP_UI_M_M_CLAIM_GEN_YN;
	}

	public void setCOMP_UI_M_M_CLAIM_GEN_YN_LABEL(HtmlOutputLabel COMP_UI_M_M_CLAIM_GEN_YN_LABEL) {
		this.COMP_UI_M_M_CLAIM_GEN_YN_LABEL = COMP_UI_M_M_CLAIM_GEN_YN_LABEL;
	}

	public void setCOMP_UI_M_M_CLAIM_GEN_YN(HtmlSelectOneMenu COMP_UI_M_M_CLAIM_GEN_YN) {
		this.COMP_UI_M_M_CLAIM_GEN_YN = COMP_UI_M_M_CLAIM_GEN_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_M_BROK_GEN_YN_LABEL() {
		return COMP_UI_M_M_BROK_GEN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_M_BROK_GEN_YN() {
		return COMP_UI_M_M_BROK_GEN_YN;
	}

	public void setCOMP_UI_M_M_BROK_GEN_YN_LABEL(HtmlOutputLabel COMP_UI_M_M_BROK_GEN_YN_LABEL) {
		this.COMP_UI_M_M_BROK_GEN_YN_LABEL = COMP_UI_M_M_BROK_GEN_YN_LABEL;
	}

	public void setCOMP_UI_M_M_BROK_GEN_YN(HtmlSelectOneMenu COMP_UI_M_M_BROK_GEN_YN) {
		this.COMP_UI_M_M_BROK_GEN_YN = COMP_UI_M_M_BROK_GEN_YN;
	}

	public HtmlCommandButton getCOMP_UI_M_M_BUT_OK() {
		return COMP_UI_M_M_BUT_OK;
	}

	public void setCOMP_UI_M_M_BUT_OK(HtmlCommandButton COMP_UI_M_M_BUT_OK) {
		this.COMP_UI_M_M_BUT_OK = COMP_UI_M_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_M_BUT_CANCEL() {
		return COMP_UI_M_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_M_BUT_CANCEL) {
		this.COMP_UI_M_M_BUT_CANCEL = COMP_UI_M_M_BUT_CANCEL;
	}

	public HtmlCommandButton getCOMP_UI_M_M_BUT_POL_LOV() {
		return COMP_UI_M_M_BUT_POL_LOV;
	}

	public void setCOMP_UI_M_M_BUT_POL_LOV(HtmlCommandButton COMP_UI_M_M_BUT_POL_LOV) {
		this.COMP_UI_M_M_BUT_POL_LOV = COMP_UI_M_M_BUT_POL_LOV;
	}

	public HtmlInputText getCOMP_ROWID() {
		return COMP_ROWID;
	}

	public void setCOMP_ROWID(HtmlInputText COMP_ROWID) {
		this.COMP_ROWID = COMP_ROWID;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public String setActionForCancelButton() {
		return "claimToBePaid";
	}

	@SuppressWarnings("deprecation")
	public String setActionForOkButton() {
		FacesContext context = FacesContext.getCurrentInstance();
		ApprovalBean abve = (ApprovalBean)context.getApplication().getExpressionFactory().createValueExpression(context.getELContext(), "#{PILP008_policy}", ApprovalBean.class).getValue(context.getELContext());
		String clm_no = abve.getclm_no();
		String pol_no = DUMMY_BEAN.getUI_M_M_POL_NO();
		Connection connection = null;
		try {
			CRUDHandler handler = new CRUDHandler();
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			connection = CommonUtils.getConnection();
			PreparedStatement ps1 = connection.prepareStatement("SELECT CLAIM_SYS_ID FROM PT_IL_CLAIM WHERE CLAIM_NO = ?");
			ps1.setString(1, clm_no);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			String CLAIM_SYS_ID = rs1.getString("CLAIM_SYS_ID");

			rs1.close();
			ps1.close();

			PreparedStatement ps2 = connection.prepareStatement("SELECT CP_CE_SYS_ID FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID = ?");
			ps2.setString(1, CLAIM_SYS_ID);
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			String CP_CE_SYS_ID = rs2.getString("CP_CE_SYS_ID");
			
			rs2.close();
			ps2.close();
				
			java.util.Date dateUtil = DUMMY_BEAN.getUI_M_M_APPRV_DATE();
			java.sql.Date dateProcedure = new java.sql.Date(dateUtil.getTime());
			CallableStatement call = connection.prepareCall("{call P9ILPK_CLAIM_APPROVAL.P_CLAIM_APPROVAL(?, ?, ?, ?, ?)}");
			call.setString(1, CLAIM_SYS_ID);
			call.setString(2, pol_no);
			call.setString(3, clm_no);
			call.setDate(4, dateProcedure);
			call.setString(5, CP_CE_SYS_ID);
			boolean yn = call.execute();
			call.close();

			return "ok";
		}catch(Exception e) {
			getErrorMap().put("current", "No Record to Approve");
			getErrorMap().put("DUMMY", "No Record to Approve");
			return "fail";
		}finally {
		}
	}


	public String approve() {

		System.out.println("PILP008_DUMMY_ACTION.approve() ... approve method called");

		/*try {
			CRUDHandler handler = new CRUDHandler();
			Connection con = CommonUtils.getConnection();
			if(con != null) {
				System.out.println("con not null");
			}

			String queryForClaim = "select liv_code_desc from pp_list_item_values where liv_sys_param in (select li_sys_param from pp_list_item where li_module_name='PILP008')";
			PreparedStatement ps = con.prepareStatement(queryForClaim);
			ResultSet rs = ps.executeQuery();
			if(rs == null) {
				System.out.println("PILP008_DUMMY_ACTION.approve() rs null");
			}
			while(rs.next()) {
				SelectItem item = new SelectItem(rs.getString("LIV_CODE_DESC"));
				CLAIM_GEN_LIST.add(item);
			}
			getDUMMY_BEAN().setUI_M_M_CLAIM_GEN_YN(CLAIM_GEN_LIST.get(0).getValue().toString());
			System.out.println("PILP008_DUMMY_ACTION.approve()......... ");
			rs.close();

			String queryForBrok = "SELECT LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = (SELECT LI_SYS_PARAM FROM PP_LIST_ITEM WHERE LI_MODULE_NAME = 'PILP008' AND LI_ITEM_NAME LIKE '%M_BROK_GEN_YN%')";
			PreparedStatement ps2 = con.prepareStatement(queryForBrok);
			ResultSet rs2 = ps2.executeQuery();
			if(rs2 != null) {
				System.out.println("rs2 not null");
			}
			while(rs2.next()) {
				SelectItem item = new SelectItem(rs2.getString("LIV_CODE_DESC"));
				BROK_GEN_LIST.add(item);
			}
			getDUMMY_BEAN().setUI_M_M_BROK_GEN_YN(BROK_GEN_LIST.get(0).getValue().toString());
			rs2.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}finally {
			System.out.println(DUMMY_BEAN.getUI_M_M_POL_NO()+"  "+DUMMY_BEAN.getUI_M_M_APPRV_DATE()+"  ");
		}
		System.out.println("success"); */
		return "success";
	}

	public List<SelectItem> getCLAIM_GEN_LIST() {
		if (CLAIM_GEN_LIST.size() == 0){
			try{
				Connection con = CommonUtils.getConnection();
				CLAIM_GEN_LIST=ListItemUtil.getDropDownListValue(con, "PILP008", "DUMMY", "DUMMY.M_CLAIM_GEN_YN", "YESNO");				
			}catch (Exception e){
				
			}
		}
		
		return CLAIM_GEN_LIST;
	}

	public void setCLAIM_GEN_LIST(List<SelectItem> claim_gen_list) {
		CLAIM_GEN_LIST = claim_gen_list;
	}

	public List<SelectItem> getBROK_GEN_LIST() {
		if (BROK_GEN_LIST.size() == 0){
			try{
				Connection con = CommonUtils.getConnection();
				BROK_GEN_LIST=ListItemUtil.getDropDownListValue(con, "PILP008", "DUMMY", "DUMMY.M_BROK_GEN_YN", "YESNO");				
			}catch (Exception e){
				
			}
		}
		
		return BROK_GEN_LIST;
	}

	public void setBROK_GEN_LIST(List<SelectItem> brok_gen_list) {
		BROK_GEN_LIST = brok_gen_list;
	}

	public void validateUI_M_M_POL_NO(ActionEvent ae){
		UIInput input = (UIInput) ae.getComponent().getParent();		
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateUI_M_M_APPRV_DATE(ActionEvent ae ) {
		UIInput input = (UIInput)ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateDate(FacesContext fc,UIComponent component, Object value){
		
		
		
		}
	
	public String mainForm() {
		return "mainForm";
	}
	
	private boolean onLoadFlag = false;
	
	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public void onLoad(PhaseEvent event){
	  if(!onLoadFlag){
		 preForm();
		 whenNewFormInstance();
		 whenCreateRecord();
			onLoadFlag = true;
		}
	}
	// Base_Curr changes PREMIAGDC-0030 : Added by Shankar Bodduluri : 25/03/09
	
	/*public void preForm(){
		String M_FILE=null;
        String M_TITLE=null;
        String sql_C1="SELECT PARA_VALUE FROM  FP_PARAMETER  WHERE  PARA_ID  = 'BASE.CURR' ";
        ResultSet vembu_C1=null;
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        String callingForm = (String) sessionMap.get("CALLING_FORM");
        if(callingForm== null)
        {
//            :GLOBAL.M_PRIVILEGE="YYY";
        	sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
        	sessionMap.put("GLOBAL.M_NAME", "COMPANY NAME..................");
        	sessionMap.put("GLOBAL.M_DFLT_VALUES", "00101    01");
//        	sessionMap.put("GLOBAL.M_PARAM_1", " ");
        }
//        M_TITLE=:CTRL.M_USER_ID+"                 "+:CTRL.M_SCR_NAME+"          "+ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
        CRUDHandler handler = new CRUDHandler();
        Connection connection = null;
        String M_BASE_CURR_CODE = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(sql_C1, connection, new Object[]{});
			while(rst.next()){
				M_BASE_CURR_CODE = rst.getString(1);
			}
			rst.close();
			DUMMY_BEAN.setUI_M_BASE_CURR_CODE(M_BASE_CURR_CODE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	
	/*public void preForm(){
		String M_FILE=null;
        String M_TITLE=null;
     // Base_Curr changes PREMIAGDC-0030	helperF_GET_BASE_CURRENCY added
        String P_CURR_CODE = null;
		String P_NAME = null;
		int P_DECIMAL = -1;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_BASE_CURR_CODE = null;
		DBProcedures procedures = new DBProcedures();
		
		try {
		ArrayList<String> list = procedures.helperF_GET_BASE_CURRENCY(CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N", P_CURR_CODE, P_NAME, P_DECIMAL+"", "E");
		if(list!= null && list.size()>0){
			P_CURR_CODE = list.get(0);
			P_NAME = list.get(1);
			P_DECIMAL = CommonUtils.parseToInt(list.get(2));
		}
        
        String sql_C1="SELECT PARA_VALUE FROM  FP_PARAMETER  WHERE  PARA_ID  = '"+ P_CURR_CODE +"' ";
     // Base_Curr changes PREMIAGDC-0030	helperF_GET_BASE_CURRENCY added
        ResultSet vembu_C1=null;
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        String callingForm = (String) sessionMap.get("CALLING_FORM");
        if(callingForm== null)
        {
//            :GLOBAL.M_PRIVILEGE="YYY";
        	sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
        	sessionMap.put("GLOBAL.M_NAME", "COMPANY NAME..................");
        	sessionMap.put("GLOBAL.M_DFLT_VALUES", "00101    01");
//        	sessionMap.put("GLOBAL.M_PARAM_1", " ");
        }
//        M_TITLE=:CTRL.M_USER_ID+"                 "+:CTRL.M_SCR_NAME+"          "+ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(sql_C1, connection, new Object[]{});
			while(rst.next()){
				M_BASE_CURR_CODE = rst.getString(1);
			}
			rst.close();
			DUMMY_BEAN.setUI_M_BASE_CURR_CODE(M_BASE_CURR_CODE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	public void preForm(){
		String M_FILE=null;
        String M_TITLE=null;
     // Base_Curr changes PREMIAGDC-0030	helperF_GET_BASE_CURRENCY added
        String P_CURR_CODE = null;
		String P_NAME = null;
		int P_DECIMAL = -1;
		CRUDHandler handler = new CRUDHandler();
		//Connection connection = null;
		String M_BASE_CURR_CODE = null;
		DBProcedures procedures = new DBProcedures();
		
		try {
		ArrayList<String> list = procedures.helperF_GET_BASE_CURRENCY(CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N", P_CURR_CODE, P_NAME, P_DECIMAL+"", "E");
		if(list!= null && list.size()>0){
			P_CURR_CODE = list.get(0);
			P_NAME = list.get(1);
			P_DECIMAL = CommonUtils.parseToInt(list.get(2));
			M_BASE_CURR_CODE = P_CURR_CODE;
		}
        
        String sql_C1="SELECT PARA_VALUE FROM  FP_PARAMETER  WHERE  PARA_ID  = '"+ P_CURR_CODE +"' ";
     // Base_Curr changes PREMIAGDC-0030	helperF_GET_BASE_CURRENCY added
        ResultSet vembu_C1=null;
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        String callingForm = (String) sessionMap.get("CALLING_FORM");
        if(callingForm== null)
        {
//            :GLOBAL.M_PRIVILEGE="YYY";
        	sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
        	sessionMap.put("GLOBAL.M_NAME", "COMPANY NAME..................");
        	sessionMap.put("GLOBAL.M_DFLT_VALUES", "00101    01");
//        	sessionMap.put("GLOBAL.M_PARAM_1", " ");
        }
//        M_TITLE=:CTRL.M_USER_ID+"                 "+:CTRL.M_SCR_NAME+"          "+ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
        	//Commented for Validating F_GET_BASE_CURRENCY : Added by Shankar Bodduluri : 20-04-2009
			/*connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(sql_C1, connection, new Object[]{});
			while(rst.next()){
				M_BASE_CURR_CODE = rst.getString(1);
			}
			rst.close();
			*/
			DUMMY_BEAN.setUI_M_BASE_CURR_CODE(M_BASE_CURR_CODE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void whenNewFormInstance(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		DUMMY_BEAN.setUI_M_M_POL_NO((String) sessionMap.get("GLOBAL.CLAIM_NO"));
		getCOMP_UI_M_M_POL_NO().setDisabled(false);
	}
	
	public void whenCreateRecord(){
		getDUMMY_BEAN().setUI_M_M_CLAIM_GEN_YN("Y");
		getDUMMY_BEAN().setUI_M_M_BROK_GEN_YN("Y");
		getDUMMY_BEAN().setUI_M_M_APPRV_DATE(Calendar.getInstance().getTime());
	}
	
	public String okButtonPressed() throws DBException{
		CommonUtils.clearMaps(this);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Long CLAIM_SYS_ID = (Long) sessionMap.get("GLOBAL.CLAIM_SYS_ID");
		String CLAIM_POL_NO = (String) sessionMap.get("GLOBAL.CLAIM_POL_NO");
		Long CP_CE_SYS_ID = (Long) sessionMap.get("GLOBAL.CP_CE_SYS_ID");
		java.util.Date currDate = Calendar.getInstance().getTime();
		
		
		PILT007_COMPOSITE_ACTION pilt007CompositeAction = (PILT007_COMPOSITE_ACTION)CommonUtils.getGlobalObject("PILT007_COMPOSITE_ACTION");
		PT_IL_CLAIM_ACTION claimAction = pilt007CompositeAction.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_PAID_ACTION claimPaidAction = pilt007CompositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION();

		/*Added by Saritha on 22.03.2017 for ZB*/
		
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		String product_code=null;
		String message = "";
		CRUDHandler handler = new CRUDHandler();
		
		/*End*/
		
		try {
			P_CLAIM_APPROVAL(CLAIM_SYS_ID,
							 CLAIM_POL_NO, 
							 getDUMMY_BEAN().getUI_M_M_POL_NO(),
							 currDate,
							 CP_CE_SYS_ID);
			CommonUtils.getConnection().commit();
			//Added by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.
			PRINT_ACTION_BEAN.runAction();
			PRINT_ACTION_BEAN.runActionAfterValidate();
			
			String emailStatusMessage = sendPostRequest(PRINT_ACTION_BEAN.getRedirectUrl(),claimAction);					
			claimPaidAction.getWarningMap().put("current", "Claim "+CLAIM_POL_NO+" is approved!"+emailStatusMessage);
	//end
			//claimPaidAction.getWarningMap().put("current", "Claim "+CLAIM_POL_NO+" is approved!");
			claimPaidAction.setWarningMessages("Claim "+CLAIM_POL_NO+" is approved!");
			claimAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
			claimAction.getCOMP_UI_M_BUT_RI_CLOSE().setDisabled(false);
			claimPaidAction.setBlockFlag(true);
			
			/*Added by saritha on 16-Feb-2017 for On registration on claim(CL05-Approved & Settlement-Approvd)
			 (including surrender, maturity and partial withdrawal) email should be sent to finance user.*/
			 
			/*emailTriggerProcCall();*/
			System.out.println("pol no::::"+claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO());
		 	String pol_no=claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO();
			String C1 ="SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO=?";
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] {pol_no});
			while(resultSet.next()) {
				product_code =resultSet.getString("POL_PROD_CODE");
				System.out.println("product code::::"+product_code);
			}

			long pol_sys_id = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
			System.out.println("pol_sys_id--------------"+pol_sys_id);

			String P_CUST_TYPE=" ";
			String emailStatusmessage = Email_Procedure_Call.emailStatusMsg(product_code,"SET",String.valueOf(pol_sys_id),"U","");
			message = message + emailStatusmessage;

			/*End*/	
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
			return null;
		}
	
		/*Added by saritha on 13-09-2017 for ssp call id ZBILQC-1735997*/
		String outCome = pilt007CompositeAction.RIClose();
		String riCheckFlag = CommonUtils.nvl(checkRICloseFlagYN(claimAction),"X");
		if(riCheckFlag.equalsIgnoreCase("Y")){
			
			outCome = "claimToBePaid";

		}
		return outCome;
		/*End*/
	}
	
	  /**
    *
    * @param P_CLAIM_SYS_ID-IN
    * @param P_CLAIM_POL_NO-IN
    * @param P_CLAIM_NO-IN
    * @param P_AS_ON_DT-IN
    * @param P_CE_SYS_ID-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> P_CLAIM_APPROVAL(
                    Object P_CLAIM_SYS_ID,
         Object P_CLAIM_POL_NO,
         Object P_CLAIM_NO,
         Object P_AS_ON_DT,
         Object P_CE_SYS_ID) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_POL_NO);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_NO);
          parameterList.add(param3);
          OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_AS_ON_DT);
          parameterList.add(param4);
          OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CE_SYS_ID);
          parameterList.add(param5);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_CLAIM_APPROVAL.P_CLAIM_APPROVAL");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

	 public void selectionChanged(ActionEvent ae){
			UIInput input= (UIInput)ae.getComponent().getParent();
			if("N".equalsIgnoreCase((String)input.getSubmittedValue())){
				this.DUMMY_BEAN.setUI_M_M_BROK_GEN_YN("N");
				getCOMP_UI_M_M_BROK_GEN_YN().setSubmittedValue(null);
				getCOMP_UI_M_M_BROK_GEN_YN().setDisabled(true);
				
			}else if("Y".equalsIgnoreCase((String)input.getSubmittedValue())){
				getCOMP_UI_M_M_BROK_GEN_YN().setDisabled(false);
			}
				
			 		 
		 }
	 

		/**
		 * Instantiates all components in PILP008_DUMMY_ACTION
		 */
		public void instantiateAllComponent(){
			// Instantiating HtmlInputText
			COMP_UI_M_M_POL_NO				 = new HtmlInputText();
			COMP_ROWID					 = new HtmlInputText();

			// Instantiating HtmlSelectOneMenu
			COMP_UI_M_M_CLAIM_GEN_YN			 = new HtmlSelectOneMenu();
			COMP_UI_M_M_BROK_GEN_YN				 = new HtmlSelectOneMenu();

			// Instantiating HtmlCalendar
			COMP_UI_M_M_APPRV_DATE				 = new HtmlCalendar();

			// Instantiating HtmlCommandButton
			COMP_UI_M_M_BUT_OK				 = new HtmlCommandButton();
			COMP_UI_M_M_BUT_CANCEL				 = new HtmlCommandButton();
			COMP_UI_M_M_BUT_POL_LOV				 = new HtmlCommandButton();

		}

		public HtmlOutputLabel getCOMP_UI_M_APPRV_DATE_LABEL() {
			return COMP_UI_M_APPRV_DATE_LABEL;
		}

		public void setCOMP_UI_M_APPRV_DATE_LABEL(
				HtmlOutputLabel comp_ui_m_apprv_date_label) {
			COMP_UI_M_APPRV_DATE_LABEL = comp_ui_m_apprv_date_label;
		}
		
		/*Commented by saritha on 16-Feb-2017 for On registration on claim(CL05-Approved & Settlement-Approvd)
		 (including surrender, maturtiy and partial withdrwal) email should be sent to finance user.
		 *
		 */
		
		 /*public String emailTriggerProcCall() throws Exception{
			   	String subject="SELECT PMT_PROD_CODE,PMT_MAIL_SUB,PMT_MAIL_TEXT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE = 'SET'";
			   	String tomail="SELECT USER_EMAIL_ID FROM MENU_USER WHERE USER_GROUP_ID='FINUSER'";
			   	String insert="INSERT INTO PW_LIFE_EMAIL_DATA (PLED_SRNO, PLED_TYPE, PLED_TO, PLED_SUB, PLED_BODY, PLED_STATUS) VALUES (PIL_MAIL_SYS_ID.NEXTVAL,?,?,?,?,?)";
			   	String out="N";
			   	ResultSet rs2=null;
			   	ResultSet rs3=null;
			   
			   	int seqno = 0;
			   	String productcode = null;
			   	String sub = null;
			   	String body = null;
			   	String mailid = null;
			   	Connection con=CommonUtils.getConnection();
			   	System.out.println("Connection :"+con);

			   	rs2=new CRUDHandler().executeSelectStatement(subject, con);
			   	rs3=new CRUDHandler().executeSelectStatement(tomail, con);
			  
			   	if(rs2.next()){
			   		productcode=rs2.getString("PMT_PROD_CODE");
			   		sub=rs2.getString("PMT_MAIL_SUB");
			   		body=rs2.getString("PMT_MAIL_TEXT");
			   	}
			   	if(rs3.next()){
			   		mailid=rs3.getString("USER_EMAIL_ID");
			   		if(mailid!=null){
			   			Object[] values1 = {"SET",mailid,sub,body,"N" };
					   	new CRUDHandler().executeInsertStatement(insert, con, values1);
					   	con.commit();
			   			
			   		out="Y";
			   		}
			   	}
			   	System.out.println("seqno  :"+seqno);
			   	System.out.println("mailid  :"+mailid);
				System.out.println("sub  :"+sub);
				System.out.println("body  :"+body);
			   	
				return out;
				}*/

		 		/*End*/
		//Added by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.
			
			public String sendPostRequest(String finalURL, PT_IL_CLAIM_ACTION PILP007_claimAction) throws Exception{
				finalURL = finalURL+"&viewtype=email";
				System.out.println("Post URL-->"+finalURL);
				
				
				URL obj = new URL(finalURL.split("\\?")[0]);
				String POST_PARAMS = finalURL.split("\\?")[1];
				System.out.println("POST_PARAMS --"+POST_PARAMS);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("User-Agent", "Mozilla/5.0");

				// For POST only - START
				con.setDoOutput(true);
				OutputStream os = con.getOutputStream();
				os.write(POST_PARAMS.getBytes());
				os.flush();
				os.close();
				// For POST only - END

				int responseCode = con.getResponseCode();
				StringBuffer response = new StringBuffer();
				StringBuffer outPutFileName = new StringBuffer();
				System.out.println("POST Response Code :: " + responseCode);
				
				if (responseCode == HttpURLConnection.HTTP_OK) { //success
					BufferedReader in = new BufferedReader(new InputStreamReader(
							con.getInputStream()));
					
					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						outPutFileName.append(inputLine);
					}
					in.close();
					
					
					System.out.println("Received Attachment File names---->[" + outPutFileName+"]");	
					
					String polSysID = PILP007_claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID().toString();
					String prodCode = getProdCode(polSysID);
								
					String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(prodCode, "CSTL", polSysID, "C", outPutFileName.toString());
					System.out.println("Email Response message in post request--->"+emailStatusMessage);
					response.append(outPutFileName.toString().equals("")?"Unable to send attachment for this approval":emailStatusMessage);
					
				} else {
					System.out.println("POST request not worked");
					response.append("Unable to send the email");
				}
				
				return (response!=null?response.toString():"");
			}
			
			public String getProdCode(String polSysID) throws Exception {
				 Connection connection = null;
				 ResultSet resultSet = null;
				 String prodCode = null;
				 String query = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
				 try {
					 connection = CommonUtils.getConnection();
					 resultSet = new CRUDHandler().executeSelectStatement(query,
							 connection, new Object[] { polSysID });
					 if (resultSet.next()) {
						 prodCode = resultSet.getString(1);
					 }
				 } catch (DBException e) {
					 e.printStackTrace();
					 throw e;
				 } catch (SQLException e) {
					 e.printStackTrace();
					 throw e;
				 } catch (Exception e) {
					 e.printStackTrace();
					 throw e;
				 } finally {
					 CommonUtils.closeCursor(resultSet);
				 }
				 return prodCode;
			 }
			
			
			//end
			
			/*Added by saritha on 13-09-2017 for ssp call id ZBILQC-1735997*/
			public String checkRICloseFlagYN(PT_IL_CLAIM_ACTION claimAction) {

				Connection connection = null;				
				CRUDHandler handler = new CRUDHandler();
				String closeRI_FACFlag = null;	
				ResultSet closeRIFACResultset = null;
				
				try {
					connection = CommonUtils.getConnection();
					String closeRIFACQuery = "Select P9ILPK_RI_ALLOC.F_RI_CLOSE_FLAG(?) from dual";
					closeRIFACResultset = handler.executeSelectStatement(closeRIFACQuery, connection,
							new Object[] {claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()});
					if(closeRIFACResultset.next()){
						closeRI_FACFlag = closeRIFACResultset.getString(1);
						System.out.println("closeRI_FACFlag::::"+closeRI_FACFlag);
					}

				}catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						CommonUtils.closeCursor(closeRIFACResultset);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				return closeRI_FACFlag;

			}
			/*End*/
	
}



