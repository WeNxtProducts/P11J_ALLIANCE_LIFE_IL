package com.iii.pel.forms.PILT012;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;


public class PS_IL_RI_CLAIM_REG_1_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_RCR_POL_NO_LABEL;

	private HtmlInputText COMP_RCR_POL_NO;

	private HtmlOutputText COMP_M_RI_CLOSE;

	private HtmlOutputLabel COMP_RCR_CLM_NO_LABEL;

	private HtmlInputText COMP_RCR_CLM_NO;

	private HtmlOutputLabel COMP_RCR_CLM_COVER_CODE_LABEL;

	private HtmlInputText COMP_RCR_CLM_COVER_CODE;

	private PS_IL_RI_CLAIM_REG_1 PS_IL_RI_CLAIM_REG_1_BEAN;

	private HtmlCommandButton COMP_UI_M_BUT_FAC_DETAILS;

	private HtmlCommandButton COMP_UI_M_BUT_CLOSE;

	private HtmlInputText COMP_M_COVER_DESC;

	Map<String, Object> session = null;

	private HtmlCommandButton PREFORMBUTTON;

//	private TabbedBar tabbedBar;
	
	PILT012_COMPOSITE_ACTION compositeAction;
	
	PS_IL_RI_CLAIM_REG_1_HELPER  helper;

	public PS_IL_RI_CLAIM_REG_1_ACTION() {
//		this.tabbedBar=new TabbedBar();
		helper = new PS_IL_RI_CLAIM_REG_1_HELPER();
		PS_IL_RI_CLAIM_REG_1_BEAN = new PS_IL_RI_CLAIM_REG_1();
//		try {
//			this.tabbedBar.addTab(1, "#{PILT012_PS_IL_RI_CLAIM_REG_1_ACTION.currentPage}", Messages.getString("messageProperties_PILT012","PILT012$currentPage") ,false);
//			this.tabbedBar.addTab(2, "#{PILT012_PS_IL_RI_CLAIM_REG_1_ACTION.next}", Messages.getString("messageProperties_PILT012", "PILT012$next"), false);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public HtmlOutputLabel getCOMP_RCR_POL_NO_LABEL() {
		return COMP_RCR_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_RCR_POL_NO() {
		return COMP_RCR_POL_NO;
	}

	public void setCOMP_RCR_POL_NO_LABEL(HtmlOutputLabel COMP_RCR_POL_NO_LABEL) {
		this.COMP_RCR_POL_NO_LABEL = COMP_RCR_POL_NO_LABEL;
	}

	public void setCOMP_RCR_POL_NO(HtmlInputText COMP_RCR_POL_NO) {
		this.COMP_RCR_POL_NO = COMP_RCR_POL_NO;
	}

	public HtmlOutputLabel getCOMP_RCR_CLM_NO_LABEL() {
		return COMP_RCR_CLM_NO_LABEL;
	}

	public HtmlInputText getCOMP_RCR_CLM_NO() {
		return COMP_RCR_CLM_NO;
	}

	public void setCOMP_RCR_CLM_NO_LABEL(HtmlOutputLabel COMP_RCR_CLM_NO_LABEL) {
		this.COMP_RCR_CLM_NO_LABEL = COMP_RCR_CLM_NO_LABEL;
	}

	public void setCOMP_RCR_CLM_NO(HtmlInputText COMP_RCR_CLM_NO) {
		this.COMP_RCR_CLM_NO = COMP_RCR_CLM_NO;
	}

	public HtmlOutputLabel getCOMP_RCR_CLM_COVER_CODE_LABEL() {
		return COMP_RCR_CLM_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RCR_CLM_COVER_CODE() {
		return COMP_RCR_CLM_COVER_CODE;
	}

	public void setCOMP_RCR_CLM_COVER_CODE_LABEL(HtmlOutputLabel COMP_RCR_CLM_COVER_CODE_LABEL) {
		this.COMP_RCR_CLM_COVER_CODE_LABEL = COMP_RCR_CLM_COVER_CODE_LABEL;
	}

	public void setCOMP_RCR_CLM_COVER_CODE(HtmlInputText COMP_RCR_CLM_COVER_CODE) {
		this.COMP_RCR_CLM_COVER_CODE = COMP_RCR_CLM_COVER_CODE;
	}

	public PS_IL_RI_CLAIM_REG_1 getPS_IL_RI_CLAIM_REG_1_BEAN() {
		return PS_IL_RI_CLAIM_REG_1_BEAN;
	}

	public void setPS_IL_RI_CLAIM_REG_1_BEAN(PS_IL_RI_CLAIM_REG_1 PS_IL_RI_CLAIM_REG_1_BEAN) {
		this.PS_IL_RI_CLAIM_REG_1_BEAN = PS_IL_RI_CLAIM_REG_1_BEAN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC_DETAILS() {
		return COMP_UI_M_BUT_FAC_DETAILS;
	}

	public void setCOMP_UI_M_BUT_FAC_DETAILS(
			HtmlCommandButton comp_ui_m_but_fac_details) {
		COMP_UI_M_BUT_FAC_DETAILS = comp_ui_m_but_fac_details;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLOSE() {
		return COMP_UI_M_BUT_CLOSE;
	}

	public void setCOMP_UI_M_BUT_CLOSE(HtmlCommandButton comp_ui_m_but_close) {
		COMP_UI_M_BUT_CLOSE = comp_ui_m_but_close;
	}


	/*	public String nextPageButtonClickAction(){
		String returnString="GO_TO_PILT012_PS_IL_RI_CLAIM_REG";
		System.out.println("in action class "+returnString );
		return returnString;
	}


	public String saveNextButtonClickAction(){
		String returnString="GO_TO_PILT012_PS_IL_RI_CLAIM_REG";
		return returnString;
	}*/

	public String preForm()throws Exception{
		try{

		if(CommonUtils.getGlobalVariable("CALLING_FORM")==null || 
				(CommonUtils.getGlobalVariable("CALLING_FORM").isEmpty())){
			CommonUtils.setGlobalVariable("GLOBAL.M_PRIVILEGE","YYY") ;
			CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE","FALSE");
			
			CommonUtils.setGlobalVariable("GLOBAL.M_DFLT_VALUES","00101    01");
			CommonUtils.setGlobalVariable("GLOBAL.M_PARAM_1","") ;
			CommonUtils.setGlobalVariable("CALLING_FORM","PILT012");
			
			}
//		STD_PRE_FORM();	
				session = getSessionMap();

//		Set Window condition and IF condition to be implemented
//		SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,WINDOW_STATE,MAXIMIZE);
//		IF GET_APPLICATION_PROPERTY(CALLING_FORM) IS NULL THEN
		session.put("GLOBAL.M_FAILURE", "FALSE");
//		values should take from GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME)
//		Developing purpose hard coded it.
		session.put("GLOBAL.M_MODULE_NAME", "PILT012");
//		calling STD_PRE_FORM PLL
		

		ControlBean ctrlBean = CommonUtils.getControlBean();
		String M_TITLE = ctrlBean.getM_USER_ID()+" "+ctrlBean.getM_SCR_NAME()+" "+new Date();

//		Set Window Porperty to be implemented
//		SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
//		getPREFORMBUTTON().setDisabled(true);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	public void STD_PRE_FORM(){
//		P_GET_LOGO;
//		COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');

		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
//		bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
//		ctrlBean.setM_PROG_NAME("PILT010");
//		COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM(------)" +(String)session.get("GLOBAL.M_NAME"));
//		COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM(!!!! ) "+(String)session.get("GLOBAL.M_DFLT_VALUES"));
		System.out.println("PILP010.STD_PRE_FORM()--- \n "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
		/** GLOBAL.M_MODULE_NAME IS ADDED IN ORDER TO QUERY HINT DETAILS IN RECORD GROUP **/
	}

	public Map<String, Object> getSessionMap(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public HtmlCommandButton getPREFORMBUTTON() {
		return PREFORMBUTTON;
	}

	public void setPREFORMBUTTON(HtmlCommandButton preformbutton) {
		PREFORMBUTTON = preformbutton;
	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

	public HtmlInputText getCOMP_M_COVER_DESC() {
		return COMP_M_COVER_DESC;
	}

	public void setCOMP_M_COVER_DESC(HtmlInputText comp_m_cover_desc) {
		COMP_M_COVER_DESC = comp_m_cover_desc;
	}

	public String next(){
		//[PREMIAGDC-CLAIM-RI-CLOSING-0088:CHARAN 28-Feb-09 Internal Fix
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PS_IL_RI_CLAIM_REG_ACTION riClaimReg = (PS_IL_RI_CLAIM_REG_ACTION) sessionMap.get("PILT012_PS_IL_RI_CLAIM_REG_ACTION");
		if(riClaimReg!=null){
			riClaimReg.setOnLoadFlag(false);
		}
		//PREMIAGDC-CLAIM-RI-CLOSING-0088:CHARAN 28-Feb-09 Internal Fix]
		return "PILT012_PS_IL_RI_CLAIM_REG";
	}

	public String prevPage(){
		return "PILT012_SEARCH";
	}

	public String currentPage(){
		return "PILT012_PS_IL_RI_CLAIM_REG_1";
	}
	
	public HtmlOutputText getCOMP_M_RI_CLOSE() {
		return COMP_M_RI_CLOSE;
	}

	public void setCOMP_M_RI_CLOSE(HtmlOutputText comp_m_ri_close) {
		COMP_M_RI_CLOSE = comp_m_ri_close;
	}

	public String whenFacButtonPressed() {
		try{
			String query="SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ?";
			Object[] values = new Object[1];
			values[0] = getCOMP_RCR_POL_NO().getValue();
			ResultSet rs = getHandler().executeSelectStatement(query, CommonUtils.getConnection(), values);
			while(rs.next()){
				getSessionMap().put("GLOBAL.POL_SYS_ID", rs.getString("POL_SYS_ID"));
			}
			rs.close();
			getSessionMap().put("GLOBAL.CLM_SYS_ID", getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_SYS_ID()!=null?Long.valueOf(getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_SYS_ID()):null);
			getSessionMap().put("GLOBAL.CLM_COVER_CODE", getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_COVER_CODE());
			getSessionMap().put("GLOBAL.COVER_CODE", "X");
			// ADDED FOR CALLING THE Claim RI Closing
			getSessionMap().put("PILT011_CALLING_FORM","PILT012");
//			CALL_FORM('PILT011',NO_HIDE,NO_REPLACE,QUERY_ONLY);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "PILT011";

	}
	
	public String whenCloseButtonPressed(){
		try{
			String query="SELECT 'X' FROM PT_IL_RI_CLAIM_ALLOC WHERE RCA_CLM_SYS_ID = ? " +
			"   AND NVL(RCA_RI_CLM_CLOSE_FLAG,'N') = 'N' " +
			"   AND RCA_CLAIM_COVER_CODE = ? AND RCA_DT = ?";
			String temp="";
			Object[] values = new Object[3];
			values[0] = getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_SYS_ID();
			values[1] = getCOMP_RCR_CLM_COVER_CODE().getValue();
			values[2] = CommonUtils.dateToStringFormatter(getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_DT());
			ResultSet rs = getHandler().executeSelectStatement(query, CommonUtils.getConnection(), values);
			while(rs.next()){
				temp=rs.getString(1);
				throw new Exception("Claim RI has been already closed ");
			}
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_SYS_ID().toString());
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_NO());
			OracleParameter param3 = new OracleParameter("in3","STRING","IN",getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_POL_NO());
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			procHandler.execute(paramList, CommonUtils.getConnection(), "L_CLOSE_CLAIM");

//			:CTRL.M_COMM_DEL := 'C';
//			:CTRL.M_COMM_DEL := NULL;
//			getCtrlBean().setM_COMM_DEL("C");
//			getCtrlBean().setM_COMM_DEL("");
			getPS_IL_RI_CLAIM_REG_1_BEAN().setUI_M_RI_CLOSE("Claim RI Closed");
		}catch(SQLException sqle){
			getErrorMap().put("current", Messages.getMessage("messageProperties_PILT012","PILT012$CLOSE_BUTTON$MESSAGE").getSummary());
			sqle.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("close", e.getMessage());
		}
		return null;
	}

	/*public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}*/
	
	public void onLoad(PhaseEvent event){
		try {
			if(isFormFlag()){
				preForm();
				setFormFlag(false);
			}
			if(isBlockFlag()){
				helper.executeQuery(compositeAction);
				helper.WHEN_NEW_RECORD_INSTACE(
						compositeAction.getPS_IL_RI_CLAIM_REG_1_ACTION_BEAN());
				setBlockFlag(false);
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
}
