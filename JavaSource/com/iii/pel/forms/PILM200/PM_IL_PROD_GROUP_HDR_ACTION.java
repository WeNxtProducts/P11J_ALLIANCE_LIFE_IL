package com.iii.pel.forms.PILM200;

import java.lang.Character.Subset;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.tahoe.appbuilder.guidesigner.codeconfigurator.functions.SubStr;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_GROUP_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PGH_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PGH_FRZ_FLAG;

	private HtmlOutputLabel COMP_PGH_GROUP_CODE_LABEL;

	private HtmlInputText COMP_PGH_GROUP_CODE;

	private HtmlOutputLabel COMP_PGH_DESC_LABEL;

	private HtmlInputText COMP_PGH_DESC;

	private HtmlOutputLabel COMP_PGH_SHORT_DESC_LABEL;
	
	private HtmlCommandButton test;
	
	private HtmlInputText COMP_PGH_SHORT_DESC;

	private HtmlOutputLabel COMP_PGH_APPL_PLAN_CODE_LABEL;

	private HtmlInputText COMP_PGH_APPL_PLAN_CODE;

	private HtmlOutputLabel COMP_UI_M_APPL_PLAN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_APPL_PLAN_DESC;

	private HtmlOutputLabel COMP_PGH_LONG_DESC_LABEL;

	private HtmlInputText COMP_PGH_LONG_DESC;

	private HtmlOutputLabel COMP_PGH_BL_DESC_LABEL;

	private HtmlInputText COMP_PGH_BL_DESC;

	private HtmlOutputLabel COMP_PGH_BL_SHORT_DESC_LABEL;

	private HtmlInputText COMP_PGH_BL_SHORT_DESC;

	private HtmlOutputLabel COMP_PGH_BL_LONG_DESC_LABEL;

	private HtmlInputText COMP_PGH_BL_LONG_DESC;
	
	private HtmlInputText COMP_UI_M_PLAN_TYPE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_PLAN_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_PROD_CODE;

	public PM_IL_PROD_GROUP_HDR PM_IL_PROD_GROUP_HDR_BEAN;
	
	public PILM200_COMPOSITE_ACTION compositeAction;
	
	private PM_IL_PROD_GROUP_HDR_HELPER helper ;
	
	
	//ControlBean ctrlBean = null;
	CRUDHandler handler = null;
	ArrayList applCodeSuggestion = new ArrayList();
	
	private TabbedBar tabbedBar;
	
	public ArrayList getApplCodeSuggestion() {
		return applCodeSuggestion;
	}

	public void setApplCodeSuggestion(ArrayList applCodeSuggestion) {
		this.applCodeSuggestion = applCodeSuggestion;
	}

	public PM_IL_PROD_GROUP_HDR_ACTION() {
		PM_IL_PROD_GROUP_HDR_BEAN = new PM_IL_PROD_GROUP_HDR();
		helper = new PM_IL_PROD_GROUP_HDR_HELPER();
		
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public HtmlOutputLabel getCOMP_PGH_FRZ_FLAG_LABEL() {
		return COMP_PGH_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PGH_FRZ_FLAG() {
		return COMP_PGH_FRZ_FLAG;
	}

	public void setCOMP_PGH_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_PGH_FRZ_FLAG_LABEL) {
		this.COMP_PGH_FRZ_FLAG_LABEL = COMP_PGH_FRZ_FLAG_LABEL;
	}

	public void setCOMP_PGH_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_PGH_FRZ_FLAG) {
		this.COMP_PGH_FRZ_FLAG = COMP_PGH_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_PGH_GROUP_CODE_LABEL() {
		return COMP_PGH_GROUP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PGH_GROUP_CODE() {
		return COMP_PGH_GROUP_CODE;
	}

	public void setCOMP_PGH_GROUP_CODE_LABEL(HtmlOutputLabel COMP_PGH_GROUP_CODE_LABEL) {
		this.COMP_PGH_GROUP_CODE_LABEL = COMP_PGH_GROUP_CODE_LABEL;
	}

	public void setCOMP_PGH_GROUP_CODE(HtmlInputText COMP_PGH_GROUP_CODE) {
		this.COMP_PGH_GROUP_CODE = COMP_PGH_GROUP_CODE;
	}

	public HtmlOutputLabel getCOMP_PGH_DESC_LABEL() {
		return COMP_PGH_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PGH_DESC() {
		return COMP_PGH_DESC;
	}

	public void setCOMP_PGH_DESC_LABEL(HtmlOutputLabel COMP_PGH_DESC_LABEL) {
		this.COMP_PGH_DESC_LABEL = COMP_PGH_DESC_LABEL;
	}

	public void setCOMP_PGH_DESC(HtmlInputText COMP_PGH_DESC) {
		this.COMP_PGH_DESC = COMP_PGH_DESC;
	}

	public HtmlOutputLabel getCOMP_PGH_SHORT_DESC_LABEL() {
		return COMP_PGH_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PGH_SHORT_DESC() {
		return COMP_PGH_SHORT_DESC;
	}

	public void setCOMP_PGH_SHORT_DESC_LABEL(HtmlOutputLabel COMP_PGH_SHORT_DESC_LABEL) {
		this.COMP_PGH_SHORT_DESC_LABEL = COMP_PGH_SHORT_DESC_LABEL;
	}

	public void setCOMP_PGH_SHORT_DESC(HtmlInputText COMP_PGH_SHORT_DESC) {
		this.COMP_PGH_SHORT_DESC = COMP_PGH_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_PGH_APPL_PLAN_CODE_LABEL() {
		return COMP_PGH_APPL_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PGH_APPL_PLAN_CODE() {
		return COMP_PGH_APPL_PLAN_CODE;
	}

	public void setCOMP_PGH_APPL_PLAN_CODE_LABEL(HtmlOutputLabel COMP_PGH_APPL_PLAN_CODE_LABEL) {
		this.COMP_PGH_APPL_PLAN_CODE_LABEL = COMP_PGH_APPL_PLAN_CODE_LABEL;
	}

	public void setCOMP_PGH_APPL_PLAN_CODE(HtmlInputText COMP_PGH_APPL_PLAN_CODE) {
		this.COMP_PGH_APPL_PLAN_CODE = COMP_PGH_APPL_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_APPL_PLAN_DESC_LABEL() {
		return COMP_UI_M_APPL_PLAN_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_APPL_PLAN_DESC() {
		return COMP_UI_M_APPL_PLAN_DESC;
	}

	public void setCOMP_UI_M_APPL_PLAN_DESC_LABEL(HtmlOutputLabel COMP_UI_M_APPL_PLAN_DESC_LABEL) {
		this.COMP_UI_M_APPL_PLAN_DESC_LABEL = COMP_UI_M_APPL_PLAN_DESC_LABEL;
	}

	public void setCOMP_UI_M_APPL_PLAN_DESC(HtmlInputText COMP_UI_M_APPL_PLAN_DESC) {
		this.COMP_UI_M_APPL_PLAN_DESC = COMP_UI_M_APPL_PLAN_DESC;
	}

	public HtmlOutputLabel getCOMP_PGH_LONG_DESC_LABEL() {
		return COMP_PGH_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PGH_LONG_DESC() {
		return COMP_PGH_LONG_DESC;
	}

	public void setCOMP_PGH_LONG_DESC_LABEL(HtmlOutputLabel COMP_PGH_LONG_DESC_LABEL) {
		this.COMP_PGH_LONG_DESC_LABEL = COMP_PGH_LONG_DESC_LABEL;
	}

	public void setCOMP_PGH_LONG_DESC(HtmlInputText COMP_PGH_LONG_DESC) {
		this.COMP_PGH_LONG_DESC = COMP_PGH_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_PGH_BL_DESC_LABEL() {
		return COMP_PGH_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PGH_BL_DESC() {
		return COMP_PGH_BL_DESC;
	}

	public void setCOMP_PGH_BL_DESC_LABEL(HtmlOutputLabel COMP_PGH_BL_DESC_LABEL) {
		this.COMP_PGH_BL_DESC_LABEL = COMP_PGH_BL_DESC_LABEL;
	}

	public void setCOMP_PGH_BL_DESC(HtmlInputText COMP_PGH_BL_DESC) {
		this.COMP_PGH_BL_DESC = COMP_PGH_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_PGH_BL_SHORT_DESC_LABEL() {
		return COMP_PGH_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PGH_BL_SHORT_DESC() {
		return COMP_PGH_BL_SHORT_DESC;
	}
	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	public void setCOMP_PGH_BL_SHORT_DESC_LABEL(HtmlOutputLabel COMP_PGH_BL_SHORT_DESC_LABEL) {
		this.COMP_PGH_BL_SHORT_DESC_LABEL = COMP_PGH_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_PGH_BL_SHORT_DESC(HtmlInputText COMP_PGH_BL_SHORT_DESC) {
		this.COMP_PGH_BL_SHORT_DESC = COMP_PGH_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_PGH_BL_LONG_DESC_LABEL() {
		return COMP_PGH_BL_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PGH_BL_LONG_DESC() {
		return COMP_PGH_BL_LONG_DESC;
	}

	public void setCOMP_PGH_BL_LONG_DESC_LABEL(HtmlOutputLabel COMP_PGH_BL_LONG_DESC_LABEL) {
		this.COMP_PGH_BL_LONG_DESC_LABEL = COMP_PGH_BL_LONG_DESC_LABEL;
	}

	public void setCOMP_PGH_BL_LONG_DESC(HtmlInputText COMP_PGH_BL_LONG_DESC) {
		this.COMP_PGH_BL_LONG_DESC = COMP_PGH_BL_LONG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PLAN_CODE() {
		return COMP_UI_M_BUT_LOV_PLAN_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_PLAN_CODE(HtmlCommandButton COMP_UI_M_BUT_LOV_PLAN_CODE) {
		this.COMP_UI_M_BUT_LOV_PLAN_CODE = COMP_UI_M_BUT_LOV_PLAN_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PROD_CODE() {
		return COMP_UI_M_BUT_LOV_PROD_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_PROD_CODE(HtmlCommandButton COMP_UI_M_BUT_LOV_PROD_CODE) {
		this.COMP_UI_M_BUT_LOV_PROD_CODE = COMP_UI_M_BUT_LOV_PROD_CODE;
	}

	public PM_IL_PROD_GROUP_HDR getPM_IL_PROD_GROUP_HDR_BEAN() {
		return PM_IL_PROD_GROUP_HDR_BEAN;
	}

	public void setPM_IL_PROD_GROUP_HDR_BEAN(PM_IL_PROD_GROUP_HDR PM_IL_PROD_GROUP_HDR_BEAN) {
		this.PM_IL_PROD_GROUP_HDR_BEAN = PM_IL_PROD_GROUP_HDR_BEAN;
	}
	
	//onLoad added by Dileshwar....
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
			
				helper.excuteQuery(PM_IL_PROD_GROUP_HDR_BEAN);
				if (PM_IL_PROD_GROUP_HDR_BEAN.getROWID() != null) {
					this.COMP_PGH_GROUP_CODE.setDisabled(true);
					helper.postQuery(PM_IL_PROD_GROUP_HDR_BEAN);
				}else {
					helper.whenCreateRecord(PM_IL_PROD_GROUP_HDR_BEAN);
				}
				setBlockFlag(false);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),
						FacesContext.getCurrentInstance(),"onLoad", getErrorMap());
			}catch(ValidatorException vl){
				vl.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						vl.getFacesMessage().getSummary());
				getErrorMap().put("onLoad", vl.getFacesMessage().getSummary());
			}
			catch (DBException e1) {
				e1.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e1.getMessage());
				getErrorMap().put("onLoad", e1.getMessage());
			}
		}
	}
	
	//saveRecord Added by Dileshwar....
	public void saveRecord() {

		String message = null;
		try {
			if (getPM_IL_PROD_GROUP_HDR_BEAN().getROWID() == null) {
				helper.preInsert(PM_IL_PROD_GROUP_HDR_BEAN);
				new CRUDHandler().executeInsert(PM_IL_PROD_GROUP_HDR_BEAN, CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			} else {
				helper.preUpdate(PM_IL_PROD_GROUP_HDR_BEAN);
				new CRUDHandler().executeInsert(PM_IL_PROD_GROUP_HDR_BEAN, CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("SAVE_RECORD",message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	
	
	//delete method added by Dileshwar
	
	public void delete() {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				helper.preDelete(PM_IL_PROD_GROUP_HDR_BEAN);
				new CRUDHandler().executeDelete(PM_IL_PROD_GROUP_HDR_BEAN,CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete");
				getWarningMap().put("deleteRow", message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				//resetAllComponent();
				PM_IL_PROD_GROUP_HDR_BEAN = new PM_IL_PROD_GROUP_HDR();
				setBlockFlag(false);
			} else {
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}


				
	
	
	
	
	
	public Map<String, Object> getSession(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}
	/*public void createCtrlBean(){
		ControlBean bean = new ControlBean();
		getSession().put("ctrlbean", bean);
	}
	public ControlBean getCtrlBean(){
		return (ControlBean) getSession().get("ctrlbean");
	}
	public void putCtrlBean(ControlBean bean){
		getSession().put("ctrlbean", bean);
	}*/
	public void preForm(PhaseEvent event){
		System.out.println("PM_IL_PROD_GROUP_HDR_ACTION.preForm()");
//		IF GET_APPLICATION_PROPERTY(CALLING_FORM) IS NULL THEN
		Map<String, Object> session = getSession();
		/*session.put("GLOBAL.M_PRIVILEGE", "YYY");
		session.put("GLOBAL.M_FAILURE", "FALSE");
		
		session.put("GLOBAL.M_USER_ID", "PREMIA");
		session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM NAME");
		session.put("GLOBAL.M_LANG_CODE", "ENG");
		session.put("GLOBAL.M_DFLT_VALUES", "00101    01");
		session.put("GLOBAL.M_PARA_1", " ");
		session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR2");*/
//		:GLOBAL.M_MODULE_NAME    := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(
//		CURRENT_FORM_NAME),FORM_NAME) ;
		STD_PRE_FORM();
//		IF SUBSTR(:GLOBAL.M_FOR_LANG_CODE,5,1) = '1' THEN
//  	NULL ;
//		END IF ;
//		M_TITLE:= :CTRL.M_USER_ID ||'                 '||:CTRL.M_SCR_NAME||'          '||TO_CHAR(SYSDATE,'DD/MM/YY');
//   	SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
		//getTest().setDisabled(true);
		PILM200_SEARCHACTION action = (PILM200_SEARCHACTION) getSession().get("PILM200_SEARCH_ACTION");
		System.out.println("PM_IL_PROD_GROUP_HDR_ACTION.preForm()"+isINSERT_ALLOWED()+"\t update : "+isUPDATE_ALLOWED());
		if(action.isUPDATE_ALLOWED()){
			System.out.println("PM_IL_PROD_GROUP_HDR_ACTION.preForm(isUPDATE_ALLOWED)");
			getCOMP_PGH_GROUP_CODE().setDisabled(true);
		}
	}
	public void STD_PRE_FORM(){
//		P_GET_LOGO;
//		COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');
		//createCtrlBean();
		//ctrlBean = getCtrlBean();
		Map<String, Object> session = getSession();
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()\n---------->\n"+session.toString()+"\n----------");
	/*	ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		ctrlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID"));*/
//		bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
//		ctrlBean.setM_PROG_NAME("PILT010");
//		COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM(------)" +(String)session.get("GLOBAL.M_NAME"));
		//ctrlBean.setM_SCR_NAME(((String)session.get("GLOBAL.M_NAME")).substring(30, 42));
//		COPY('10','SYSTEM.MESSAGE_LEVEL');
		//session.put("GLOBAL.M_FAILURE", "FALSE");
		/*ctrlBean.setM_GOFLD_NAME("NULL");
		ctrlBean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
		ctrlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		ctrlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));*/
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM(!!!! ) "+(String)session.get("GLOBAL.M_DFLT_VALUES"));
		//ctrlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));

		//putCtrlBean(ctrlBean);
		//System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()--- \n "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
		/** GLOBAL.M_MODULE_NAME IS ADDED IN ORDER TO QUERY HINT DETAILS IN RECORD GROUP **/
		
	}
	public void whenNewBlockInstancw(ActionEvent ae){
//		CHECK_BLK_NAVG ;
	}
	public void whenCreateRecord(){
//		LOAD_DFLT_VALUES ;
	}
	public void whenNewFormInstance(){
		System.out.println("PM_IL_PROD_GROUP_HDR_ACTION.whenNewFormInstance()");
		getCOMP_PGH_FRZ_FLAG().setSelected(true);
	}
	public void preBlock(){
		System.out.println("PM_IL_PROD_GROUP_HDR_ACTION.preBlock()");
//		IF FORM_FAILURE THEN
			getSession().put("GLOBAL.M_FAILURE", "TRUE");
			CommonUtils.getControlBean().setM_DELETE_MSG_FLAG("N");
			//putCtrlBean(ctrlBean);
	}
	public void preInsert(PM_IL_PROD_GROUP_HDR PM_IL_PROD_GROUP_HDR_BEAN){
		System.out.println("PM_IL_PROD_GROUP_HDR_ACTION.executeQuery()");
//		 :PM_IL_PROD_GROUP_HDR.PGH_FRZ_FLAG := 'N';
		ResultSet rs = null;
		try {
			rs = handler.executeSelectStatement("SELECT SYSDATE FROM DUAL", CommonUtils.getConnection());
			if(rs.next()){
				PM_IL_PROD_GROUP_HDR_BEAN.setPGH_CR_DT(rs.getDate(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(PM_IL_PROD_GROUP_HDR_BEAN.isPGH_FREEZE_FLAG())
		{
			PM_IL_PROD_GROUP_HDR_BEAN.setPGH_FRZ_FLAG("Y");
		}
		else
		{
			PM_IL_PROD_GROUP_HDR_BEAN.setPGH_FRZ_FLAG("N");
		}
		System.out.println("USER ID:"+CommonUtils.getControlBean().getM_USER_ID());
		PM_IL_PROD_GROUP_HDR_BEAN.setPGH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		System.out.println("PM_IL_PROD_GROUP_HDR_ACTION.preInsert() CR_DT :- "+PM_IL_PROD_GROUP_HDR_BEAN.getPGH_CR_DT()+"\t CR_UID :-"+PM_IL_PROD_GROUP_HDR_BEAN.getPGH_CR_UID());
	}
	
		
	
	
	
	
	public void PGH_APPL_PLAN_CODEDesc(){
		//getCOMP_PGH_APPL_PLAN_CODE().getSubmittedValue().toString();
		String value = null;
		value = PM_IL_PROD_GROUP_HDR_BEAN.getPGH_APPL_PLAN_CODE();
		boolean flag = false;
		if (value == null) {
			flag = true;
			value = getCOMP_PGH_APPL_PLAN_CODE().getSubmittedValue().toString();
		}
		String query = "SELECT PC_DESC,PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = 'APPLPLANS' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE = '"+value+"'";
		System.out.println("PGH_APPL_PLAN_CODEDesc(query) " +query);
		ResultSet rs = null;
		try {
			rs = handler.executeSelectStatement(query, CommonUtils.getConnection());
			if(rs.next()){
				if (flag) {
					getCOMP_UI_M_APPL_PLAN_DESC().setSubmittedValue(rs.getString(1));
				}else{
					PM_IL_PROD_GROUP_HDR_BEAN.setUI_M_APPL_PLAN_DESC(rs.getString(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//P_VAL_CODES();
		
//		return null;
	}
	
	
	
	
	
	
	

	public HtmlInputText getCOMP_UI_M_PLAN_TYPE() {
		return COMP_UI_M_PLAN_TYPE;
	}

	public void setCOMP_UI_M_PLAN_TYPE(HtmlInputText comp_ui_m_plan_type) {
		COMP_UI_M_PLAN_TYPE = comp_ui_m_plan_type;
	}
	
	
	public void groupCodeWhenValidate(String groupCode) throws ValidatorException{
		duplicateGroupCodeCheckOnInsert();
	}
		
	
	
	
	
	public void duplicateGroupCodeCheckOnInsert() throws ValidatorException{
		PM_IL_PROD_GROUP_HDR_ACTION hdrActionBean=(PM_IL_PROD_GROUP_HDR_ACTION)new CommonUtils().getMappedBeanFromSession("PILM200_PM_IL_PROD_GROUP_HDR_ACTION");
		PM_IL_PROD_GROUP_HDR hdrValueBean=hdrActionBean.getPM_IL_PROD_GROUP_HDR_BEAN();
		CRUDHandler handler=new CRUDHandler();
		try{
			
			Connection connection=CommonUtils.getConnection();
			//duplicateValidationCheck();
			if(hdrValueBean.getROWID() == null){
				hdrValueBean.setPGH_CR_DT(new CommonUtils().getCurrentDate());
				hdrValueBean.setPGH_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			}else{
				hdrValueBean.setPGH_UPD_DT(new CommonUtils().getCurrentDate());
				hdrValueBean.setPGH_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			}
			handler.executeInsert(hdrValueBean, connection);
			
		
		}catch(DBException exception){
			exception.printStackTrace();
		}catch(SQLException exception){
			exception.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public ArrayList<LovBean> prepareSuggestionList_PGH_APPL_PLAN_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT PC_CODE,PC_DESC,PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = 'APPLPLANS' " +
				"AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE LIKE ?  AND ROWNUM < ? ORDER BY PC_CODE";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] {  currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void PGH_GROUP_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			getPM_IL_PROD_GROUP_HDR_BEAN().setPGH_GROUP_CODE((String)value);
			helper.PGH_GROUP_CODE_WHEN_VALIDATE_ITEM(getPM_IL_PROD_GROUP_HDR_BEAN());
			

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void PGH_APPL_PLAN_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			getPM_IL_PROD_GROUP_HDR_BEAN().setPGH_APPL_PLAN_CODE((String)value);
			helper.PGH_APPL_PLAN_CODE_WHEN_VALIDATE_ITEM(getPM_IL_PROD_GROUP_HDR_BEAN());
			//COMP_UI_M_PLAN_TYPE.resetValue();
			COMP_UI_M_APPL_PLAN_DESC.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {

				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void validatePGH_BL_DESC(FacesContext context,
			UIComponent component, Object value)  {

		try {
			getPM_IL_PROD_GROUP_HDR_BEAN().setPGH_BL_DESC((String)value);
			if(getPM_IL_PROD_GROUP_HDR_BEAN().getPGH_BL_DESC()!=null &&
					!(getPM_IL_PROD_GROUP_HDR_BEAN().getPGH_BL_DESC().isEmpty())){
				getPM_IL_PROD_GROUP_HDR_BEAN().setPGH_SHORT_DESC(CommonUtils.SUBSTR(
						PM_IL_PROD_GROUP_HDR_BEAN.getPGH_BL_DESC(),1,30));
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		COMP_PGH_BL_SHORT_DESC.resetValue();
	}
	
	public void validatePGH_DESC(FacesContext context,
			UIComponent component, Object value)  {

		try {
			getPM_IL_PROD_GROUP_HDR_BEAN().setPGH_DESC((String)value);
			if(getPM_IL_PROD_GROUP_HDR_BEAN().getPGH_DESC()!=null &&
					!(getPM_IL_PROD_GROUP_HDR_BEAN().getPGH_DESC().isEmpty())){
				getPM_IL_PROD_GROUP_HDR_BEAN().setPGH_SHORT_DESC(CommonUtils.SUBSTR(
						PM_IL_PROD_GROUP_HDR_BEAN.getPGH_DESC(),1,30));
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	COMP_PGH_SHORT_DESC.resetValue();
	}
}
