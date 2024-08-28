package com.iii.pel.forms.PILT013;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;







import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.common.dms.DMSUtil;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY_ACTION extends CommonReportAction/*CommonAction*/ {
	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("Report_ID");
	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_PLAN_CODE_LABEL;

	private HtmlInputText COMP_POL_PLAN_CODE;

	private HtmlOutputLabel COMP_UI_M_PLAN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PLAN_DESC;

	private HtmlOutputLabel COMP_POL_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_POL_ASSURED_NAME;

	private HtmlOutputLabel COMP_POL_PERIOD_LABEL;

	private HtmlInputText COMP_POL_PERIOD;

	private HtmlOutputLabel COMP_POL_START_DT_LABEL;

	private HtmlCalendar COMP_POL_START_DT;

	private HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_POL_EXPIRY_DT;

	private HtmlOutputLabel COMP_UI_M_ACNT_CODE_LABEL;

	private HtmlInputText COMP_UI_M_ACNT_CODE;

	private HtmlOutputLabel COMP_POL_END_NO_LABEL;

	private HtmlInputText COMP_POL_END_NO;

	private HtmlCommandButton COMP_UI_M_BUT_ASSR_NAME_ED;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_PLAN_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_BONUS;

	private HtmlCommandButton COMP_UI_M_BUT_RESERVE;

	private HtmlCommandButton COMP_UI_M_BUT_REP_POLICY;

	private HtmlCommandButton COMP_UI_M_STATUS;
//MODIFIED BYGOPI FOR KIC MATURITY PROCESS AS SUGGESTED BY VIJAY SIR ON 19/03/2019
	//private HtmlOutputText COMP_UI_B_POL_STATUS;
	
	private HtmlOutputLabel COMP_UI_B_POL_STATUS;
	
	public HtmlOutputLabel getCOMP_UI_B_POL_STATUS() {
		return COMP_UI_B_POL_STATUS;
	}

	public void setCOMP_UI_B_POL_STATUS(HtmlOutputLabel cOMP_UI_B_POL_STATUS) {
		COMP_UI_B_POL_STATUS = cOMP_UI_B_POL_STATUS;
	}



	private HtmlOutputText COMP_UI_B_POL_STATUS_LABLE;
	
	

	public HtmlOutputText getCOMP_UI_B_POL_STATUS_LABLE() {
		return COMP_UI_B_POL_STATUS_LABLE;
	}

	public void setCOMP_UI_B_POL_STATUS_LABLE(
			HtmlOutputText cOMP_UI_B_POL_STATUS_LABLE) {
		COMP_UI_B_POL_STATUS_LABLE = cOMP_UI_B_POL_STATUS_LABLE;
	}



	private PT_IL_POLICY PT_IL_POLICY_BEAN;

	public PILT013_COMPOSITE_ACTION compositeAction;

	private PT_IL_POLICY_HELPER helper;

	private String UI_B_SMV_FLAG ;

	private String UI_B_SMV_FLAG1;

	private String UI_B_POL_STATUS;

	/*Added By dhinesh 11.3.2016*/

private PT_IL_POLICY_DELEGATE delegate=null;
	private HtmlOutputLabel COMP_UI_SCHEDULE_TYPE_LABEL;
	private HtmlOutputLabel COMP_UI_POLICY_NO_LABEL;
	private HtmlOutputText COMP_UI_POLICY_NO;
	private HtmlSelectOneMenu  COMP_UI_SCHEDULE_TYPE;

	
	private List<SelectItem> listUI_M_SCHEDULE_TYPE = new ArrayList<SelectItem>();




	public List<SelectItem> getListUI_M_SCHEDULE_TYPE() 
	{
		listUI_M_SCHEDULE_TYPE=UI_M_SCHEDULE_TYPELIST();		
		
		System.out.println("listUI_M_SCHEDULE_TYPE   88888 : "+listUI_M_SCHEDULE_TYPE.size());
		
		return listUI_M_SCHEDULE_TYPE;
	}

	public void setListUI_M_SCHEDULE_TYPE(List<SelectItem> listUI_M_SCHEDULE_TYPE) {
		this.listUI_M_SCHEDULE_TYPE = listUI_M_SCHEDULE_TYPE;
	}

	

	public HtmlOutputLabel getCOMP_UI_SCHEDULE_TYPE_LABEL() {
		return COMP_UI_SCHEDULE_TYPE_LABEL;
	}

	public void setCOMP_UI_SCHEDULE_TYPE_LABEL(
			HtmlOutputLabel cOMP_UI_SCHEDULE_TYPE_LABEL) {
		COMP_UI_SCHEDULE_TYPE_LABEL = cOMP_UI_SCHEDULE_TYPE_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_POLICY_NO_LABEL() {
		return COMP_UI_POLICY_NO_LABEL;
	}

	public void setCOMP_UI_POLICY_NO_LABEL(HtmlOutputLabel cOMP_UI_POLICY_NO_LABEL) {
		COMP_UI_POLICY_NO_LABEL = cOMP_UI_POLICY_NO_LABEL;
	}

	public HtmlOutputText getCOMP_UI_POLICY_NO() {
		return COMP_UI_POLICY_NO;
	}

	public void setCOMP_UI_POLICY_NO(HtmlOutputText cOMP_UI_POLICY_NO) {
		COMP_UI_POLICY_NO = cOMP_UI_POLICY_NO;
	}

	public HtmlSelectOneMenu getCOMP_UI_SCHEDULE_TYPE() {
		return COMP_UI_SCHEDULE_TYPE;
	}

	public void setCOMP_UI_SCHEDULE_TYPE(HtmlSelectOneMenu cOMP_UI_SCHEDULE_TYPE) {
		COMP_UI_SCHEDULE_TYPE = cOMP_UI_SCHEDULE_TYPE;
	}


	/*End*/



	public PT_IL_POLICY_ACTION() {
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
		helper = new PT_IL_POLICY_HELPER();
		delegate=new PT_IL_POLICY_DELEGATE();
		getListUI_M_SCHEDULE_TYPE();
		
		 /*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
		initializeAllComponent();
		
		/*End*/
		
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_PLAN_CODE_LABEL() {
		return COMP_POL_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_PLAN_CODE() {
		return COMP_POL_PLAN_CODE;
	}

	public void setCOMP_POL_PLAN_CODE_LABEL(
			HtmlOutputLabel COMP_POL_PLAN_CODE_LABEL) {
		this.COMP_POL_PLAN_CODE_LABEL = COMP_POL_PLAN_CODE_LABEL;
	}

	public void setCOMP_POL_PLAN_CODE(HtmlInputText COMP_POL_PLAN_CODE) {
		this.COMP_POL_PLAN_CODE = COMP_POL_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PLAN_DESC_LABEL() {
		return COMP_UI_M_PLAN_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PLAN_DESC() {
		return COMP_UI_M_PLAN_DESC;
	}

	public void setCOMP_UI_M_PLAN_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PLAN_DESC_LABEL) {
		this.COMP_UI_M_PLAN_DESC_LABEL = COMP_UI_M_PLAN_DESC_LABEL;
	}

	public void setCOMP_UI_M_PLAN_DESC(HtmlInputText COMP_UI_M_PLAN_DESC) {
		this.COMP_UI_M_PLAN_DESC = COMP_UI_M_PLAN_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_ASSURED_NAME_LABEL() {
		return COMP_POL_ASSURED_NAME_LABEL;
	}

	public HtmlInputText getCOMP_POL_ASSURED_NAME() {
		return COMP_POL_ASSURED_NAME;
	}

	public void setCOMP_POL_ASSURED_NAME_LABEL(
			HtmlOutputLabel COMP_POL_ASSURED_NAME_LABEL) {
		this.COMP_POL_ASSURED_NAME_LABEL = COMP_POL_ASSURED_NAME_LABEL;
	}

	public void setCOMP_POL_ASSURED_NAME(HtmlInputText COMP_POL_ASSURED_NAME) {
		this.COMP_POL_ASSURED_NAME = COMP_POL_ASSURED_NAME;
	}

	public HtmlOutputLabel getCOMP_POL_PERIOD_LABEL() {
		return COMP_POL_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_POL_PERIOD() {
		return COMP_POL_PERIOD;
	}

	public void setCOMP_POL_PERIOD_LABEL(HtmlOutputLabel COMP_POL_PERIOD_LABEL) {
		this.COMP_POL_PERIOD_LABEL = COMP_POL_PERIOD_LABEL;
	}

	public void setCOMP_POL_PERIOD(HtmlInputText COMP_POL_PERIOD) {
		this.COMP_POL_PERIOD = COMP_POL_PERIOD;
	}

	public HtmlOutputLabel getCOMP_POL_START_DT_LABEL() {
		return COMP_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_START_DT() {
		return COMP_POL_START_DT;
	}

	public void setCOMP_POL_START_DT_LABEL(
			HtmlOutputLabel COMP_POL_START_DT_LABEL) {
		this.COMP_POL_START_DT_LABEL = COMP_POL_START_DT_LABEL;
	}

	public void setCOMP_POL_START_DT(HtmlCalendar COMP_POL_START_DT) {
		this.COMP_POL_START_DT = COMP_POL_START_DT;
	}

	public HtmlOutputLabel getCOMP_POL_EXPIRY_DT_LABEL() {
		return COMP_POL_EXPIRY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_EXPIRY_DT() {
		return COMP_POL_EXPIRY_DT;
	}

	public void setCOMP_POL_EXPIRY_DT_LABEL(
			HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL) {
		this.COMP_POL_EXPIRY_DT_LABEL = COMP_POL_EXPIRY_DT_LABEL;
	}

	public void setCOMP_POL_EXPIRY_DT(HtmlCalendar COMP_POL_EXPIRY_DT) {
		this.COMP_POL_EXPIRY_DT = COMP_POL_EXPIRY_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACNT_CODE_LABEL() {
		return COMP_UI_M_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACNT_CODE() {
		return COMP_UI_M_ACNT_CODE;
	}

	public void setCOMP_UI_M_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_ACNT_CODE_LABEL) {
		this.COMP_UI_M_ACNT_CODE_LABEL = COMP_UI_M_ACNT_CODE_LABEL;
	}

	public void setCOMP_UI_M_ACNT_CODE(HtmlInputText COMP_UI_M_ACNT_CODE) {
		this.COMP_UI_M_ACNT_CODE = COMP_UI_M_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_END_NO_LABEL() {
		return COMP_POL_END_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_END_NO() {
		return COMP_POL_END_NO;
	}

	public void setCOMP_POL_END_NO_LABEL(HtmlOutputLabel COMP_POL_END_NO_LABEL) {
		this.COMP_POL_END_NO_LABEL = COMP_POL_END_NO_LABEL;
	}

	public void setCOMP_POL_END_NO(HtmlInputText COMP_POL_END_NO) {
		this.COMP_POL_END_NO = COMP_POL_END_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ASSR_NAME_ED() {
		return COMP_UI_M_BUT_ASSR_NAME_ED;
	}

	public void setCOMP_UI_M_BUT_ASSR_NAME_ED(
			HtmlCommandButton COMP_UI_M_BUT_ASSR_NAME_ED) {
		this.COMP_UI_M_BUT_ASSR_NAME_ED = COMP_UI_M_BUT_ASSR_NAME_ED;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO() {
		return COMP_UI_M_BUT_LOV_POL_NO;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO) {
		this.COMP_UI_M_BUT_LOV_POL_NO = COMP_UI_M_BUT_LOV_POL_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PLAN_CODE() {
		return COMP_UI_M_BUT_LOV_PLAN_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_PLAN_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_PLAN_CODE) {
		this.COMP_UI_M_BUT_LOV_PLAN_CODE = COMP_UI_M_BUT_LOV_PLAN_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BONUS() {
		return COMP_UI_M_BUT_BONUS;
	}

	public void setCOMP_UI_M_BUT_BONUS(HtmlCommandButton COMP_UI_M_BUT_BONUS) {
		this.COMP_UI_M_BUT_BONUS = COMP_UI_M_BUT_BONUS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RESERVE() {
		return COMP_UI_M_BUT_RESERVE;
	}

	public void setCOMP_UI_M_BUT_RESERVE(HtmlCommandButton COMP_UI_M_BUT_RESERVE) {
		this.COMP_UI_M_BUT_RESERVE = COMP_UI_M_BUT_RESERVE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REP_POLICY() {
		return COMP_UI_M_BUT_REP_POLICY;
	}

	public void setCOMP_UI_M_BUT_REP_POLICY(
			HtmlCommandButton COMP_UI_M_BUT_REP_POLICY) {
		this.COMP_UI_M_BUT_REP_POLICY = COMP_UI_M_BUT_REP_POLICY;
	}

	public HtmlCommandButton getCOMP_UI_M_STATUS() {
		return COMP_UI_M_STATUS;
	}

	public void setCOMP_UI_M_STATUS(HtmlCommandButton COMP_UI_M_STATUS) {
		this.COMP_UI_M_STATUS = COMP_UI_M_STATUS;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}

	public void saveRecord() {
		try {
			if (getPT_IL_POLICY_BEAN().getROWID() != null) {
				new CRUDHandler().executeUpdate(getPT_IL_POLICY_BEAN(),CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record Updated Successfully");
				getWarningMap().put("current", "Record Updated Successfully");
			} else {
				new CRUDHandler().executeInsert(getPT_IL_POLICY_BEAN(),CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record Saved Successfully");
				getWarningMap().put("current", "Record Saved Successfully");
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) throws Exception {
		try {
			if(isFormFlag()){
				helper.PRE_FORM(compositeAction);
				helper.WHEN_NEW_FORM_INSTANCE(compositeAction);
				setFormFlag(false);
			}
			helper.loadcurrency();
			if (isBlockFlag()){
				helper.PRE_QUERY(compositeAction);
				helper.executeQuery(compositeAction);
				if(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("S")){
					COMP_UI_B_POL_STATUS_LABLE.setValue("Surrender Payment Status : ");
				}else if(PT_IL_POLICY_BEAN.getPOL_STATUS().equals("M")){
					COMP_UI_B_POL_STATUS_LABLE.setValue("Maturity Payment Status : ");
				}
				new PT_IL_SURR_MAT_VALUES_DELEGATE().executeSelectStatement(compositeAction);
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getROWID()!=null)
					helper.POST_QUERY(compositeAction);
				//helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				setBlockFlag(false);
			}
			System.out.println("************* Enter the PT_IL_POLICY_ACTION **********");
			System.out.println("PT_IL_POLICY_BEAN.getPOL_NO()        : "+PT_IL_POLICY_BEAN.getPOL_NO());
			System.out.println("PT_IL_POLICY_BEAN.getPOL_SYS_ID()    : "+PT_IL_POLICY_BEAN.getPOL_SYS_ID());
			System.out.println("******************************************************");
			if(PT_IL_POLICY_BEAN.getPOL_NO()!= null){
				disablefunddetails(PT_IL_POLICY_BEAN.getPOL_PLAN_CODE());
			}

			 /*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
			
			System.out.println("getSMV_APPRV_FLAG                 "+compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_APPRV_FLAG());
			
	
			if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_APPRV_FLAG() != null && compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_APPRV_FLAG().equalsIgnoreCase("a"))
			{
				disableAllComponent(true);
			}
			
			/*End*/
			
			//			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().onLoad(event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}finally {
			ErrorHelpUtil.getWarningForProcedure(CommonUtils
					.getConnection(), "onLoad", getErrorMap());
		}
	}

	public void disablefunddetails(String plancode) throws Exception{
		String C1="select plan_type from pm_il_plan where plan_code = ? ";
		String plantype=null;
		Connection con=null;
		ResultSet rs=null;
		CRUDHandler handler=null;
		try{
			con=CommonUtils.getConnection();
			handler=new CRUDHandler();
			rs=handler.executeSelectStatement(C1, con, new Object[]{plancode});
			if(rs.next()){
				plantype=rs.getString(1);
			}	

			if("U".equalsIgnoreCase(plantype)){
				compositeAction.getTabbedBar().setTabEnabled(3);
			}else{
				compositeAction.getTabbedBar().setTabDisabled(3);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(rs);
		}
	}


	public List<com.iii.premia.common.bean.LovBean> lovPLAN_CODE(Object obj) throws Exception {
		List<LovBean> suggestionList = null;
		try{
			String planCode = (String) obj;
			suggestionList = helper.POL_PLAN_CODE_KEY_LISTVAL(compositeAction, planCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		return suggestionList;
	}

	public String getUI_B_SMV_FLAG() {
		return UI_B_SMV_FLAG;
	}

	public void setUI_B_SMV_FLAG(String ui_b_smv_flag) {
		UI_B_SMV_FLAG = ui_b_smv_flag;
	}

	public String getUI_B_SMV_FLAG1() {
		return UI_B_SMV_FLAG1;
	}

	public void setUI_B_SMV_FLAG1(String ui_b_smv_flag1) {
		UI_B_SMV_FLAG1 = ui_b_smv_flag1;
	}

	public String getUI_B_POL_STATUS() {
		return UI_B_POL_STATUS;
	}

	public void setUI_B_POL_STATUS(String ui_b_pol_status) {
		UI_B_POL_STATUS = ui_b_pol_status;
	}

	public String M_BUT_REP_POLICY_action()throws Exception { 
		try{
			helper.M_BUT_REP_POLICY_WHEN_BUTTON_PRESSED(getPT_IL_POLICY_BEAN());
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Approve", e.getMessage());

		}
		return "PILQ108_APAC";
	}
	public String M_BUT_APPROVE_action()throws Exception{
		try{
			compositeAction.getDUMMY_ACTION_BEAN().getErrorMap().clear();
			compositeAction.getDUMMY_ACTION_BEAN().getWarningMap().clear();
			helper.M_BUT_APPROVE_WHEN_BUTTON_PRESSED(compositeAction);
			return "PILT013_DUMMY";
		}catch(Exception e){
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());

			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getErrorMap().put("Approve", e.getMessage());

		}
		return null;
	}

	public String UI_M_STATUSaction()throws Exception{
		try{
			compositeAction.getDUMMY_ACTION_BEAN().getErrorMap().clear();
			compositeAction.getDUMMY_ACTION_BEAN().getWarningMap().clear();
			return "PILT013_PT_IL_SURR_STATUS";
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Approve", e.getMessage());

		}
		return null;
	}

	public String actionUI_M_BUT_RESERVE(){
		
		Connection connection = null;
		
		
		try{
			/*Added by agalya for Maturity Payout on 08/07/2016,ssp call no- FALCONQC-1714914*/
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getErrorMap().clear();
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getWarningMap().clear();
			//end
			helper.M_BUT_RESERVE_WHEN_BUTTON_PRESSED(compositeAction);
			
			/*Added by Janani on 25.07.2017 for ZBILQC-1731997 */
			System.out.println("getSMV_APPRV_FLAG  before    "+compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_APPRV_FLAG());
			
			if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_APPRV_FLAG().equalsIgnoreCase("n"))
			{
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
				setSMV_APPRV_FLAG("P");
			}
			
			
			System.out.println("getSMV_APPRV_FLAG  after    "+compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_APPRV_FLAG());

			PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			connection = CommonUtils.getConnection();
			//added by saranya for paidup issue
			/*update query modified by gopi for ssp call id ZBLIFE-1465513 on 06/01/18*/
			/*String C6 = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_APPRV_FLAG ='P' WHERE SMV_POL_SYS_ID = ? ";
			new CRUDHandler().executeUpdateStatement(C6, connection, new Object[]{pt_il_policy_bean.getPOL_SYS_ID()});*/
			
			String C6 = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_APPRV_FLAG ='P' WHERE SMV_POL_SYS_ID = ? AND SMV_SYS_ID = ?";
			new CRUDHandler().executeUpdateStatement(C6, connection, new Object[]{pt_il_policy_bean.getPOL_SYS_ID(), compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID()});
			connection.commit();
			connection.close();
			
			System.out.println("getSMV_APPRV_FLAG  after  update  "+compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_APPRV_FLAG());
			
			
			/*End*/
			//commented by gopi for ssp call id ZBLIFE-1465513
			//compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().setBlockFlag(true);
		}catch(Exception e){
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getErrorMap().put("Approve", e.getMessage());

		}
		return null;
	}

	/*public HtmlOutputText getCOMP_UI_B_POL_STATUS() {
		return COMP_UI_B_POL_STATUS;
	}

	public void setCOMP_UI_B_POL_STATUS(HtmlOutputText comp_ui_b_pol_status) {
		COMP_UI_B_POL_STATUS = comp_ui_b_pol_status;
	}
*/



	public void validatorSCHEDULE_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			PT_IL_POLICY_BEAN.setUI_M_SCHEDULE_TYPE((String)value);
			System.out.println("PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE()   : "+PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE());


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<SelectItem> UI_M_SCHEDULE_TYPELIST(){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			System.out.println("****************  UI_M_SCHEDULE_TYPELIST   *****************");
			selectItem = new SelectItem();

			selectItem.setLabel("1");
			selectItem.setValue("Payment");
			list.add(selectItem);
			selectItem = new SelectItem();
			
			selectItem.setLabel("2");
			selectItem.setValue("SurrenderValue");
			list.add(selectItem);
			selectItem = new SelectItem();
			
			selectItem.setLabel("3");
			selectItem.setValue("MaturityNotice");
			list.add(selectItem);
			selectItem = new SelectItem();
			
			selectItem.setLabel("4");
			selectItem.setValue("LifeAssrSurrDischarge");
			list.add(selectItem);
			selectItem = new SelectItem();
			
			selectItem.setLabel("5");
			selectItem.setValue("LifeAssMatuyDischarge");
			list.add(selectItem);
			
			System.out.println("SELECITEM   : "+selectItem.getValue());
			
			
			/*ArrayList<String> schedule_type = new ArrayList<String>();

			schedule_type.add("Payment");
			schedule_type.add("SurrenderValue");
			schedule_type.add("MaturityNotice");
			schedule_type.add("LifeAssrSurrDischarge");
			schedule_type.add("LifeAssMatuyDischarge");
			 */
			System.out.println("schedule_type  Size   : "+list.size());


		} catch (Exception e) {
			// TODO: handle exception
		}


		return list;

	}


	public String printButtonAction()
	{

		System.out.println("***************** ENTER THE PT_IL_POLICY_ACTION *****************");
		System.out.println("***************** printButtonAction  *******************");

		String outcome = null;
		try {
			/*added by gopi for dynamic report config on 03/04/2017*/
			PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN();
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
					policyBean.getPOL_SYS_ID().toString());
			//end
			outcome="PILT013_PRINT";
		} catch (Exception e) {
			// TODO: handle exception
		}

		return outcome;
	}


	/*
	 * Commented by Janani ,its not been used
	 * 
	 * 
	 * public String callReportModalPanel()
	{
	System.out.println(" ************ callReportModalPanel ************");
				
	
	System.out.println("PT_IL_POLICY_BEAN.getPOL_NO()    : "+PT_IL_POLICY_BEAN.getPOL_NO());
	System.out.println("PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE()   : "+PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE());
	
	String ReportName=PT_IL_POLICY_BEAN.getPOL_NO();
	String PolSysId=PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE();

	String urlStr ="http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/FalconIL/ReportServlet?JasperReportName="+ReportName+"&JasperPolSysId="+PolSysId;
	System.out.println("urlStr   : "+urlStr);
	
	
	String line;
	
	URL url=null;
	try {
		System.out.println("Connecting to Servlet");

		url = new URL(urlStr);

		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);

		BufferedWriter out = 
		new BufferedWriter( new OutputStreamWriter( conn.getOutputStream() ) );
		out.write("username=name\r\n");
		out.flush();
		out.close();
		BufferedReader in = 
		new BufferedReader( new InputStreamReader( conn.getInputStream() ) );

		String response;
		while ( (response = in.readLine()) != null ) {
		System.out.println( response );
		}
		in.close();
		}
		catch ( MalformedURLException ex ) {
		System.out.println("########"+ex);
		ex.printStackTrace();
		}
		catch ( IOException ex ) {
		System.out.println("@@@@@@@@@@@@@@"+ex); 
		ex.printStackTrace();
		}catch(Exception e){
		System.out.println("$$$$$$$$$$$$$$"+e);
		e.printStackTrace();
		}

	return null;
	}
*/
	
	
	public void validatorM_POL_NO(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			PT_IL_POLICY_BEAN.getPOL_NO();
			System.out.println("PT_IL_POLICY_BEAN.getPOL_NO()    : "+PT_IL_POLICY_BEAN.getPOL_NO());
			
			PT_IL_POLICY_BEAN.setUI_M_SCHEDULE_TYPE((String)value);
			System.out.println("PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE()   : "+PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE());


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	 /*Added By Janani on 3.01.2017 for DMS Integration*/
	
	 public void callReportModalPanel(ActionEvent event) {
		 String input = event.getComponent().getId();
		 runAction_DMS();
		 try {
		
				 String dmsUrl = new DMSUtil().getDmsUrl();
				 System.out.println("PT_IL_CLAIM_ACTION.invokeDMS()" + dmsUrl);
				 setRedirectUrl(dmsUrl);
			

			 if (getRedirectUrl() != null) {
				 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
			 } else {
				 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
			 }

		 } catch (Exception e) {
			 e.printStackTrace();
		 }

	 }

	
	 public String runAction_DMS() {
		 System.out.println("PT_IL_CLAIM_ACTION.invokeDMS()");
		 try {

		 } catch (Exception e) {
			 // TODO: handle exception
		 }
		 return "";

	 }
	 
	 /*End*/
	 /*Added by saranya for  RM018T - FSD_IL_ZB Life_028-Cash Back */
	 public ArrayList<OracleParameter> P_INS_ADJ_DATA(
				String P_SMV_TYPE,
				String P_POL_NO,
				String P_SMV_SYS_ID,
				String P_SMV_PAID_DT,
				String P_POL_CUST_CODE) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_SMV_TYPE);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_POL_NO);
				parameterList.add(param2);
				OracleParameter param3 = new OracleParameter("IN3", "INT", "IN",P_SMV_SYS_ID);
				parameterList.add(param3);
				OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_SMV_PAID_DT);
				parameterList.add(param4);
				OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_POL_CUST_CODE);
				parameterList.add(param5);
				
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.execute(parameterList, connection,
						"P9ILPK_ADJ_OS.P_INS_ADJ_DATA");
			} catch(Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new ProcedureException(e.getMessage());
			}
			return outputList;
		}
		/*End*/
		
		
			/* Added by saranya on 02-01-2016 for RM018T - DEV_IL_ZB Life_028-Cash Back*/
		private HtmlCommandButton COMP_M_BUT_INT_TRANSFER;

		public HtmlCommandButton getCOMP_M_BUT_INT_TRANSFER() {
			return COMP_M_BUT_INT_TRANSFER;
		}

		public void setCOMP_M_BUT_INT_TRANSFER(HtmlCommandButton cOMP_M_BUT_INT_TRANSFER) {
			COMP_M_BUT_INT_TRANSFER = cOMP_M_BUT_INT_TRANSFER;
		}
		
		public String actionINT_TRANSFER(){
			String outcome = null;
			try {
			String SMV_APPV_FLAG=compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_APPRV_FLAG();
				if(CommonUtils.nvl(SMV_APPV_FLAG,"N").equalsIgnoreCase("N")){
				String SMV_SYS_ID=compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID().toString();
				Date SMV_PAID_DT=(Date) compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_PAID_DT();
				String SMV_TYPE=compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_TYPE();
				//SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("SMV_PAID_DT :"+SMV_PAID_DT);
				String SMV_PAID_DATE = CommonUtils.dateToStringFormat(SMV_PAID_DT);
				System.out.println("SMV_PAID_DATE :"+SMV_PAID_DATE);
				P_INS_ADJ_DATA(SMV_TYPE,
						PT_IL_POLICY_BEAN.getPOL_NO(),
						SMV_SYS_ID,
						SMV_PAID_DATE,
						PT_IL_POLICY_BEAN.getPOL_CUST_CODE());
				}
				// SESSION TAKEN FOR GET POL_NO ON INTERNAL TRANSFER SCREEN 
				ResultSet resultSet = null;
		        FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest) context
						.getExternalContext().getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("POL_NO",PT_IL_POLICY_BEAN.getPOL_NO());
				session.setAttribute("SMV_APPV_FLAG",CommonUtils.nvl(SMV_APPV_FLAG,"N"));
				System.out.println("POL_NO   "+session.getAttribute("POL_NO").toString());
				System.out.println("SMV_APPV_FLAG  :"+session.getAttribute("SMV_APPV_FLAG").toString());
				
				/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
				
				session.setAttribute("PILT013_compositeAction",compositeAction);
				
				/*eND*/
				
				setBlockFlag(true);
				outcome="PILP078_INTERNAL_TRANSFER";
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return outcome;
		}
		
	
		
		 /*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
		 
		 public void disableAllComponent(boolean disabled) {
			
			 COMP_POL_NO.setDisabled(disabled);
			 COMP_POL_ASSURED_NAME.setDisabled(disabled);
			 COMP_POL_START_DT.setDisabled(disabled);
			 COMP_POL_END_NO.setDisabled(disabled);
			 COMP_POL_PLAN_CODE.setDisabled(disabled);
			 COMP_POL_PERIOD.setDisabled(disabled);
			 COMP_POL_EXPIRY_DT.setDisabled(disabled);
			 COMP_UI_M_ACNT_CODE.setDisabled(disabled);
			 COMP_UI_M_BUT_RESERVE.setDisabled(disabled);
			 
		 }
		
		 private void initializeAllComponent() {
			 
			 COMP_POL_NO = new HtmlInputText();
			 COMP_POL_ASSURED_NAME = new HtmlInputText();
			 COMP_POL_START_DT = new HtmlCalendar();
			 COMP_POL_END_NO = new HtmlInputText();
			 COMP_POL_PLAN_CODE = new HtmlInputText();
			 COMP_POL_PERIOD = new HtmlInputText();
			 COMP_POL_EXPIRY_DT = new HtmlCalendar();
			 COMP_UI_M_ACNT_CODE = new HtmlInputText();
			 COMP_UI_M_BUT_RESERVE = new HtmlCommandButton();
		 }
		
		 /*End*/
		
}
