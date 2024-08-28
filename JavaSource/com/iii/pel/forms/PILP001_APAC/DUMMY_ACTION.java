package com.iii.pel.forms.PILP001_APAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
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
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP002_APAC.DB_Procedures;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD_DELEGATE;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.pel.utils.PILPK_POLICY_APPROVAL;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class DUMMY_ACTION extends CommonAction {

    // private HtmlCommandButton test;

    Connection connection = null;
    CRUDHandler handler = null;

    private HtmlOutputLabel COMP_UI_M_PROP_NO_LABEL;

    private HtmlOutputLabel COMP_UI_M_RE_UW_REQ_YN_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_RE_UW_REQ_YN;

    private HtmlOutputLabel COMP_UI_M_RE_UW_REQ_REASON_LABEL;

    private HtmlInputText COMP_UI_M_RE_UW_REQ_REASON;

    private HtmlInputText COMP_UI_M_PROP_NO;

    private HtmlOutputLabel COMP_UI_M_APPRV_DATE_LABEL;

    private HtmlCalendar COMP_UI_M_APPRV_DATE;

    private HtmlOutputLabel COMP_UI_M_PROP_STATUS_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_PROP_STATUS;

    private HtmlOutputLabel COMP_UI_M_PROP_CONVERT_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_PROP_CONVERT;

    private HtmlOutputLabel COMP_UI_M_POL_DOCCODE_LABEL;

    private HtmlInputText COMP_UI_M_POL_DOCCODE;

    private HtmlOutputLabel COMP_UI_M_DS_DESC_LABEL;

    private HtmlInputText COMP_UI_M_DS_DESC;

    private HtmlOutputLabel COMP_UI_M_POLICY_NO_LABEL;

    private HtmlInputText COMP_UI_M_POLICY_NO;

    private HtmlOutputLabel COMP_UI_M_DEPPREM_REFUND_YN_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_DEPPREM_REFUND_YN;

    private HtmlOutputLabel COMP_UI_M_MED_FEE_RECOVER_YN_LABEL;

    private HtmlSelectOneMenu COMP_UI_M_MED_FEE_RECOVER_YN;

    private HtmlOutputLabel COMP_UI_M_PS_REASON_CODE_LABEL;

    private HtmlInputText COMP_UI_M_PS_REASON_CODE;

    private HtmlOutputLabel COMP_UI_M_REASON_DESC_LABEL;

    private HtmlInputText COMP_UI_M_REASON_DESC;

    private HtmlOutputLabel COMP_UI_M_PS_REMARKS_LABEL;

    private HtmlInputText COMP_UI_M_PS_REMARKS;

    private HtmlCommandButton COMP_UI_M_BUT_PROP_LOV;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_DOC_CODE;

    private HtmlCommandButton COMP_UI_M_BUT_POLICY_NO;

    private HtmlCommandButton COMP_UI_M_BUT_LOV_PC_CODE;

    private HtmlCommandButton COMP_UI_M_BUT_PS_REMARKS;

    private HtmlAjaxCommandButton COMP_UI_M_BUT_OK;

    private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

    private HtmlCommandButton COMP_UI_M_BUT_PRINT;

    private List<SelectItem> UI_M_PROCESS_TYPE_LIST = new ArrayList<SelectItem>();

    private List<SelectItem> UI_M_PROP_TYPE_LIST = new ArrayList<SelectItem>();

    private List<SelectItem> RE_UW_REQ_YN_LIST = new ArrayList<SelectItem>();

    private List<SelectItem> UI_M_DEPPREM_REFUND_YN_LIST = new ArrayList<SelectItem>();

    private List<SelectItem> UI_M_MED_FEE_RECOVER_YN_LIST = new ArrayList<SelectItem>();
    /*added by saranya on 8-04-16 for email capture*/
    private HtmlOutputLabel COMP_MAIL_SEND_TO_LABEL;
    
    private HtmlSelectOneMenu  COMP_MAIL_SEND_TO_TYPE;
    
	public HtmlOutputLabel getCOMP_MAIL_SEND_TO_LABEL() {
		return COMP_MAIL_SEND_TO_LABEL;
	}

	public void setMAIL_SEND_TO_LABEL(
			HtmlOutputLabel cOMP_MAIL_SEND_TO_LABEL) {
		COMP_MAIL_SEND_TO_LABEL = cOMP_MAIL_SEND_TO_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_MAIL_SEND_TO_TYPE() {
		return COMP_MAIL_SEND_TO_TYPE;
	}

	public void setCOMP_MAIL_SEND_TO_TYPE(
			HtmlSelectOneMenu cOMP_MAIL_SEND_TO_TYPE) {
		COMP_MAIL_SEND_TO_TYPE = cOMP_MAIL_SEND_TO_TYPE;
	}
    
    /*end*/

    Map session = null;
    DUMMY_HELPER helper;

    FacesContext ctx = FacesContext.getCurrentInstance();

    public List list = new ArrayList();

    private DUMMY DUMMY_BEAN;

    private ControlBean controlBean;
    public  PILP001_APAC_COMPOSITE_ACTION compositeAction;

    public ControlBean getControlBean() {
	return controlBean;
    }

    public void setControlBean(ControlBean controlBean) {
	this.controlBean = controlBean;
    }
    //added by saranya on 8-04-16 for email capture
    private String MAIL_SEND_TO;

    public String getMAIL_SEND_TO() {
		return MAIL_SEND_TO;
	}

	public void setMAIL_SEND_TO(String mAIL_SEND_TO) {
		MAIL_SEND_TO = mAIL_SEND_TO;
	}
	private List<SelectItem> listMAIL_SEND_TO = new ArrayList<SelectItem>();
	

	public List<SelectItem> getListMAIL_SEND_TO() {
		listMAIL_SEND_TO=MAIL_SEND_TO_LIST();
		return listMAIL_SEND_TO;
	}

	public void setListMAIL_SEND_TO(List<SelectItem> listMAIL_SEND_TO) {
		this.listMAIL_SEND_TO = listMAIL_SEND_TO;
	}
	
	/*String val_cus=CommonUtils.getGlobalVariable("GLOBAL_CUST_MAIL_ID");
	String val_bro=CommonUtils.getGlobalVariable("GLOBAL_BRO_MAIL_ID");*/
	/*FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session1 = request.getSession();
	
	String val= session1.getAttribute("POL_FLEX_26").toString();*/

	
	/*end*/

    public DUMMY_ACTION() {
	DUMMY_BEAN = new DUMMY();
	helper = new DUMMY_HELPER();
	//aded by saranya for email capture
	getListMAIL_SEND_TO();
	//end
	controlBean = (ControlBean) CommonUtils.getControlBean().clone();
	try {
	    instantiateAllComponent();
	    connection = CommonUtils.getConnection();
	    List<SelectItem> listItemReReqYN = ListItemUtil
		    .getDropDownListValue(connection, "PILP001_APAC", "DUMMY",
			    "DUMMY.M_RE_UW_REQ_YN", "YESNO");
	    setRE_UW_REQ_YN_LIST(listItemReReqYN);

	    List<SelectItem> contributionYN = ListItemUtil
		    .getDropDownListValue(connection, "PILP001_APAC", "DUMMY",
			    "DUMMY.M_DEPPREM_REFUND_YN", "YESNO");
	    setUI_M_DEPPREM_REFUND_YN_LIST(contributionYN);

	    List<SelectItem> medFreeRecoverYN = ListItemUtil
		    .getDropDownListValue(connection, "PILP001_APAC", "DUMMY",
			    "DUMMY.M_MED_FEE_RECOVER_YN", "YESNO");
	    setUI_M_MED_FEE_RECOVER_YN_LIST(medFreeRecoverYN);

	   /* preform();
	    helper.pilp001_apac_when_new_form_instance(this, DUMMY_BEAN);*/
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public HtmlOutputLabel getCOMP_UI_M_PROP_NO_LABEL() {
	return COMP_UI_M_PROP_NO_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PROP_NO() {
	return COMP_UI_M_PROP_NO;
    }

    public void setCOMP_UI_M_PROP_NO_LABEL(
	    HtmlOutputLabel COMP_UI_M_PROP_NO_LABEL) {
	this.COMP_UI_M_PROP_NO_LABEL = COMP_UI_M_PROP_NO_LABEL;
    }

    public void setCOMP_UI_M_PROP_NO(HtmlInputText COMP_UI_M_PROP_NO) {
	this.COMP_UI_M_PROP_NO = COMP_UI_M_PROP_NO;
    }

    public HtmlOutputLabel getCOMP_UI_M_APPRV_DATE_LABEL() {
	return COMP_UI_M_APPRV_DATE_LABEL;
    }

    public HtmlCalendar getCOMP_UI_M_APPRV_DATE() {
	return COMP_UI_M_APPRV_DATE;
    }

    public void setCOMP_UI_M_APPRV_DATE_LABEL(
	    HtmlOutputLabel COMP_UI_M_APPRV_DATE_LABEL) {
	this.COMP_UI_M_APPRV_DATE_LABEL = COMP_UI_M_APPRV_DATE_LABEL;
    }

    public void setCOMP_UI_M_APPRV_DATE(HtmlCalendar COMP_UI_M_APPRV_DATE) {
	this.COMP_UI_M_APPRV_DATE = COMP_UI_M_APPRV_DATE;
    }

    public HtmlOutputLabel getCOMP_UI_M_PROP_STATUS_LABEL() {
	return COMP_UI_M_PROP_STATUS_LABEL;
    }

    public void setCOMP_UI_M_PROP_STATUS_LABEL(
	    HtmlOutputLabel COMP_UI_M_PROP_STATUS_LABEL) {
	this.COMP_UI_M_PROP_STATUS_LABEL = COMP_UI_M_PROP_STATUS_LABEL;
    }

    public HtmlOutputLabel getCOMP_UI_M_PROP_CONVERT_LABEL() {
	return COMP_UI_M_PROP_CONVERT_LABEL;
    }

    public void setCOMP_UI_M_PROP_CONVERT_LABEL(
	    HtmlOutputLabel COMP_UI_M_PROP_CONVERT_LABEL) {
	this.COMP_UI_M_PROP_CONVERT_LABEL = COMP_UI_M_PROP_CONVERT_LABEL;
    }

    public HtmlOutputLabel getCOMP_UI_M_POL_DOCCODE_LABEL() {
	return COMP_UI_M_POL_DOCCODE_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POL_DOCCODE() {
	return COMP_UI_M_POL_DOCCODE;
    }

    public void setCOMP_UI_M_POL_DOCCODE_LABEL(
	    HtmlOutputLabel COMP_UI_M_POL_DOCCODE_LABEL) {
	this.COMP_UI_M_POL_DOCCODE_LABEL = COMP_UI_M_POL_DOCCODE_LABEL;
    }

    public void setCOMP_UI_M_POL_DOCCODE(HtmlInputText COMP_UI_M_POL_DOCCODE) {
	this.COMP_UI_M_POL_DOCCODE = COMP_UI_M_POL_DOCCODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_DS_DESC_LABEL() {
	return COMP_UI_M_DS_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_DS_DESC() {
	return COMP_UI_M_DS_DESC;
    }

    public void setCOMP_UI_M_DS_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_DS_DESC_LABEL) {
	this.COMP_UI_M_DS_DESC_LABEL = COMP_UI_M_DS_DESC_LABEL;
    }

    public void setCOMP_UI_M_DS_DESC(HtmlInputText COMP_UI_M_DS_DESC) {
	this.COMP_UI_M_DS_DESC = COMP_UI_M_DS_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_POLICY_NO_LABEL() {
	return COMP_UI_M_POLICY_NO_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_POLICY_NO() {
	return COMP_UI_M_POLICY_NO;
    }

    public void setCOMP_UI_M_POLICY_NO_LABEL(
	    HtmlOutputLabel COMP_UI_M_POLICY_NO_LABEL) {
	this.COMP_UI_M_POLICY_NO_LABEL = COMP_UI_M_POLICY_NO_LABEL;
    }

    public void setCOMP_UI_M_POLICY_NO(HtmlInputText COMP_UI_M_POLICY_NO) {
	this.COMP_UI_M_POLICY_NO = COMP_UI_M_POLICY_NO;
    }

    public HtmlOutputLabel getCOMP_UI_M_DEPPREM_REFUND_YN_LABEL() {
	return COMP_UI_M_DEPPREM_REFUND_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_DEPPREM_REFUND_YN() {
	return COMP_UI_M_DEPPREM_REFUND_YN;
    }

    public void setCOMP_UI_M_DEPPREM_REFUND_YN_LABEL(
	    HtmlOutputLabel COMP_UI_M_DEPPREM_REFUND_YN_LABEL) {
	this.COMP_UI_M_DEPPREM_REFUND_YN_LABEL = COMP_UI_M_DEPPREM_REFUND_YN_LABEL;
    }

    public void setCOMP_UI_M_DEPPREM_REFUND_YN(
	    HtmlSelectOneMenu COMP_UI_M_DEPPREM_REFUND_YN) {
	this.COMP_UI_M_DEPPREM_REFUND_YN = COMP_UI_M_DEPPREM_REFUND_YN;
    }

    public HtmlOutputLabel getCOMP_UI_M_MED_FEE_RECOVER_YN_LABEL() {
	return COMP_UI_M_MED_FEE_RECOVER_YN_LABEL;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_MED_FEE_RECOVER_YN() {
	return COMP_UI_M_MED_FEE_RECOVER_YN;
    }

    public void setCOMP_UI_M_MED_FEE_RECOVER_YN_LABEL(
	    HtmlOutputLabel COMP_UI_M_MED_FEE_RECOVER_YN_LABEL) {
	this.COMP_UI_M_MED_FEE_RECOVER_YN_LABEL = COMP_UI_M_MED_FEE_RECOVER_YN_LABEL;
    }

    public void setCOMP_UI_M_MED_FEE_RECOVER_YN(
	    HtmlSelectOneMenu COMP_UI_M_MED_FEE_RECOVER_YN) {
	this.COMP_UI_M_MED_FEE_RECOVER_YN = COMP_UI_M_MED_FEE_RECOVER_YN;
    }

    public HtmlOutputLabel getCOMP_UI_M_PS_REASON_CODE_LABEL() {
	return COMP_UI_M_PS_REASON_CODE_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PS_REASON_CODE() {
	return COMP_UI_M_PS_REASON_CODE;
    }

    public void setCOMP_UI_M_PS_REASON_CODE_LABEL(
	    HtmlOutputLabel COMP_UI_M_PS_REASON_CODE_LABEL) {
	this.COMP_UI_M_PS_REASON_CODE_LABEL = COMP_UI_M_PS_REASON_CODE_LABEL;
    }

    public void setCOMP_UI_M_PS_REASON_CODE(
	    HtmlInputText COMP_UI_M_PS_REASON_CODE) {
	this.COMP_UI_M_PS_REASON_CODE = COMP_UI_M_PS_REASON_CODE;
    }

    public HtmlOutputLabel getCOMP_UI_M_REASON_DESC_LABEL() {
	return COMP_UI_M_REASON_DESC_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_REASON_DESC() {
	return COMP_UI_M_REASON_DESC;
    }

    public void setCOMP_UI_M_REASON_DESC_LABEL(
	    HtmlOutputLabel COMP_UI_M_REASON_DESC_LABEL) {
	this.COMP_UI_M_REASON_DESC_LABEL = COMP_UI_M_REASON_DESC_LABEL;
    }

    public void setCOMP_UI_M_REASON_DESC(HtmlInputText COMP_UI_M_REASON_DESC) {
	this.COMP_UI_M_REASON_DESC = COMP_UI_M_REASON_DESC;
    }

    public HtmlOutputLabel getCOMP_UI_M_PS_REMARKS_LABEL() {
	return COMP_UI_M_PS_REMARKS_LABEL;
    }

    public HtmlInputText getCOMP_UI_M_PS_REMARKS() {
	return COMP_UI_M_PS_REMARKS;
    }

    public void setCOMP_UI_M_PS_REMARKS_LABEL(
	    HtmlOutputLabel COMP_UI_M_PS_REMARKS_LABEL) {
	this.COMP_UI_M_PS_REMARKS_LABEL = COMP_UI_M_PS_REMARKS_LABEL;
    }

    public void setCOMP_UI_M_PS_REMARKS(HtmlInputText COMP_UI_M_PS_REMARKS) {
	this.COMP_UI_M_PS_REMARKS = COMP_UI_M_PS_REMARKS;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PROP_LOV() {
	return COMP_UI_M_BUT_PROP_LOV;
    }

    public void setCOMP_UI_M_BUT_PROP_LOV(
	    HtmlCommandButton COMP_UI_M_BUT_PROP_LOV) {
	this.COMP_UI_M_BUT_PROP_LOV = COMP_UI_M_BUT_PROP_LOV;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_DOC_CODE() {
	return COMP_UI_M_BUT_LOV_DOC_CODE;
    }

    public void setCOMP_UI_M_BUT_LOV_DOC_CODE(
	    HtmlCommandButton COMP_UI_M_BUT_LOV_DOC_CODE) {
	this.COMP_UI_M_BUT_LOV_DOC_CODE = COMP_UI_M_BUT_LOV_DOC_CODE;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_POLICY_NO() {
	return COMP_UI_M_BUT_POLICY_NO;
    }

    public void setCOMP_UI_M_BUT_POLICY_NO(
	    HtmlCommandButton COMP_UI_M_BUT_POLICY_NO) {
	this.COMP_UI_M_BUT_POLICY_NO = COMP_UI_M_BUT_POLICY_NO;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PC_CODE() {
	return COMP_UI_M_BUT_LOV_PC_CODE;
    }

    public void setCOMP_UI_M_BUT_LOV_PC_CODE(
	    HtmlCommandButton COMP_UI_M_BUT_LOV_PC_CODE) {
	this.COMP_UI_M_BUT_LOV_PC_CODE = COMP_UI_M_BUT_LOV_PC_CODE;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PS_REMARKS() {
	return COMP_UI_M_BUT_PS_REMARKS;
    }

    public void setCOMP_UI_M_BUT_PS_REMARKS(
	    HtmlCommandButton COMP_UI_M_BUT_PS_REMARKS) {
	this.COMP_UI_M_BUT_PS_REMARKS = COMP_UI_M_BUT_PS_REMARKS;
    }

    public HtmlAjaxCommandButton getCOMP_UI_M_BUT_OK() {
	return COMP_UI_M_BUT_OK;
    }

    public void setCOMP_UI_M_BUT_OK(HtmlAjaxCommandButton COMP_UI_M_BUT_OK) {
	this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
	return COMP_UI_M_BUT_CANCEL;
    }

    public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
	this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
    }

    public HtmlCommandButton getCOMP_UI_M_BUT_PRINT() {
	return COMP_UI_M_BUT_PRINT;
    }

    public void setCOMP_UI_M_BUT_PRINT(HtmlCommandButton COMP_UI_M_BUT_PRINT) {
	this.COMP_UI_M_BUT_PRINT = COMP_UI_M_BUT_PRINT;
    }

    public DUMMY getDUMMY_BEAN() {
	return DUMMY_BEAN;
    }

    public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
	this.DUMMY_BEAN = DUMMY_BEAN;
    }

    public void preform() throws Exception {

	ResultSet resultSet = null;
	Connection connection = null;
	handler = new CRUDHandler();
	CommonUtils commonUtils = new CommonUtils();

	// FacesContext facecon = FacesContext.getCurrentInstance();
	// SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,WINDOW_STATE,MAXIMIZE);

	if (CommonUtils.getGlobalVariable("GLOBAL.M_NAME") == null) {
	    CommonUtils.setGlobalVariable("GLOBAL.M_NAME",
		    "COMPANY NAME..................PROGRAM NAME");
	}

	if (CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES") == null) {
	    CommonUtils
		    .setGlobalVariable("GLOBAL.M_DFLT_VALUES", "00101    01");
	}

	/*
	 * session=
	 * FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	 * session.put("GLOBAL.M_PRIVILEGE", "YYY");
	 * session.put("GLOBAL.M_FAILURE", "FALSE");
	 * session.put("GLOBAL.M_USER_ID", "PREMIA");
	 * session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM
	 * NAME");
	 * 
	 * 
	 * 
	 * session.put("GLOBAL.M_LANG_CODE", "ENG");
	 * session.put("GLOBAL.M_DFLT_VALUES", "00101 01");
	 * session.put("GLOBAL.M_PARA_1", " ");
	 * session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
	 */
	// values should take from
	// GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME)
	// Developing purpose hard coded it.
	// session.put("GLOBAL.M_MODULE_NAME", "PILP001_APAC");
	CommonUtils.setGlobalVariable("GLOBAL.M_MODULE_NAME", "PILP001_APAC");

	// calling STD_PRE_FORM PLL
	STD_PRE_FORM();

	try {
	    connection = CommonUtils.getConnection();
	    FacesContext context = FacesContext.getCurrentInstance();
	    context.getExternalContext().getSessionMap();
	    session = FacesContext.getCurrentInstance().getExternalContext()
		    .getSessionMap();

	    Date apprvDate = (Date) CommonUtils.getGlobalObject("GLOBAL.M_POL_APPRV_DT");

	    
	    if(CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID") != null){
		DUMMY_BEAN.setM_POL_SYS_ID( (Long)CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID"));
	    DUMMY_BEAN.setUI_M_POL_NO( CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO"));
	    DUMMY_BEAN.setUI_M_PROP_NO(CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO"));
	    DUMMY_BEAN.setUI_M_APPRV_DATE(apprvDate == null ? commonUtils.getCurrentDate() : apprvDate);
	    }

	    String query = SQLQueryInterfacePILP001.PreForm_Query;
	    // WHEN NEWFORM INSTANCE CALLING........
	    helper.pilp001_apac_when_new_form_instance(this,DUMMY_BEAN);
	    // WHEN CREATE RECORD CALLING......
	    helper.pilp001_apac_dummy_when_create_record(DUMMY_BEAN);
	    // WHEN NEW RECORD INSTANCE CALLING.......
	    helper.pilp001_apac_dummy_when_new_record_instance(this,DUMMY_BEAN);
	    /*String value = helper.toConvertButtonED(DUMMY_BEAN.getUI_M_PROP_NO());
	    if("Y".equalsIgnoreCase(value)){
	    	COMP_UI_M_PROP_CONVERT.setDisabled(false);
	    }else{
	    	COMP_UI_M_PROP_CONVERT.setDisabled(true);
	    }*/
	} catch (Exception exp) {
	    exp.printStackTrace();
	} finally {
	    try {
		CommonUtils.closeCursor(resultSet);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public void STD_PRE_FORM() {
	// P_GET_LOGO;
	// COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');
	// ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));

	controlBean.setM_PARA_1(CommonUtils
		.getGlobalVariable("GLOBAL.M_PARA_1"));

	// ctrlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID"));

	// bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));

	controlBean.setM_PROG_NAME("PILP001_APAC");
	// COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30),
	// 'BUTTON_PALETTE.M_COMP_NAME') ;

	// ctrlBean.setM_SCR_NAME(((String)session.get("GLOBAL.M_NAME")).substring(30,
	// 42));

	// COPY('10','SYSTEM.MESSAGE_LEVEL');
	// session.put("GLOBAL.M_FAILURE", "FALSE");

	CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");

	controlBean.setM_GOFLD_NAME("NULL");
	// ctrlBean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
	// ctrlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
	// ctrlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
	// System.out.println("DUMMYACTION.STD_PRE_FORM(!!!! )
	// "+(String)session.get("GLOBAL.M_DFLT_VALUES"));
	// ctrlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));

    }

    /*
     * public Connection getConnection() throws Exception{ FacesContext fc =
     * FacesContext.getCurrentInstance(); ServletContext context =
     * (ServletContext)fc.getExternalContext().getContext();
     * SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent)
     * context.getAttribute("connectionAgent"); return
     * connectionAgent.getConnection("System.currentTimeMillis()"); }
     */

    public void ModelSelected(ActionEvent event) throws Exception {
	String proposal = DUMMY_BEAN.getUI_M_PROP_NO();
	String query = "select * from PT_IL_POLICY WHERE POL_PROP_NO = ?";
	ResultSet rs = null;

	try {
	    connection = CommonUtils.getConnection();
	    PreparedStatement ps = connection.prepareStatement(query);
	    ps.setString(1, proposal);
	    rs = ps.executeQuery();
	    while (rs.next()) {
		if (COMP_UI_M_PROP_CONVERT.getSubmittedValue().equals("Y")) {
		    getCOMP_UI_M_POL_DOCCODE().setDisabled(false);
		    getCOMP_UI_M_POL_DOCCODE().setSubmittedValue(
			    rs.getString("POL_DS_CODE"));
		}
		if (COMP_UI_M_PROP_CONVERT.getSubmittedValue().equals("N")) {
		    getCOMP_UI_M_POL_DOCCODE().setSubmittedValue("");
		    getCOMP_UI_M_POL_DOCCODE().setDisabled(true);
		    // COMP_UI_M_POL_DOCCODE
		}
	    }
	} catch (DBException exc) {
	    throw new Exception(exc.getMessage());
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} finally {
	    try {
		CommonUtils.closeCursor(rs);
	    } catch (Exception e) {

	    }
	}
    }
 
    public String PILP001_APAC_DUMMY_M_BUT_OK_WHEN_BUTTON_PRESSED()
	    throws Exception {

	handler = new CRUDHandler();

	ResultSet rs_C1 = null;
	ResultSet rs_C2 = null;
	ResultSet rs_C3 = null;
	ResultSet rs_C4 = null;
	ResultSet rs_C5 = null;
	ResultSet rs_C6 = null;
	ResultSet rs_C7 = null;
	ResultSet rs_C8 = null;
	ResultSet rs_C9 = null;
	ResultSet rs_C10 = null;
	ResultSet rs_C11 = null;
	ResultSet rs_C12 = null;
	ResultSet rs_C13 = null;
	ResultSet rs_C14 = null;
	ResultSet rs_C15 = null;
	ResultSet rs_C16 = null;
	ResultSet rs_C17 = null;
	ResultSet rs_C18 = null;
	ResultSet rs_C19 = null;
	ResultSet rs_C20 = null;
	ResultSet rs_C21 = null;
	ResultSet rs_C22 = null;
	ResultSet rs_C23 = null;
	ResultSet rs_C24 = null;
	ResultSet rs_C25 = null;
	ResultSet rs_C26 = null;
	ResultSet rs_C27 = null;

	String M_POL_PLAN_TYPE = null;
	String M_POL_MODE_OF_PYMT = null;
	String M_AA_PS_DESC = null;
	String M_AA_PS_VALUE = null;
	String M_POAD_LC_THRESHOLD_LMT = null;
	String M_TH_ASD_NUM_VALUE = null;
	String M_TEMP = null;
	String M_SUM = null;
	String M_POL_CUST_CURR_CODE = null;
	String M_POL_EXCHANGE_RATE = null;
	String M_POL_END_NO_IDX = null;
	String M_POL_CONT_CODE = null;
	String M_POL_FC_DEPOSIT_AMOUNT = null;
	String M_POL_LC_DEPOSIT_AMOUNT = null;
	String M_POL_FC_FIRST_PREM = null;
	String M_POL_LC_FIRST_PREM = null;
	Double M_CONT_LC_DEP_TEMP = null;
	Double M_CONT_FC_DEP_TEMP = null;
	Double M_CONT_LC_PROP_DEP_AMT = null;
	Double M_CONT_LC_PROP_UTIL_AMT = null;
	String M_CONT_LC_POL_DEP_AMT = null;
	String M_CONT_LC_POL_UTIL_AMT = null;
	String M_LC_JOURNAL_AMT_1 = null;
	Double M_LC_JOURNAL_AMT_2 = null;
	Double M_LC_JOURNAL_AMT = null;
	Double M_FC_JOURNAL_AMT = null;
	String M_NEW_POL_SYS_ID = null;
	String M_POL_PROP_NO = null;
	String M_DEP_GROSS_NET_FLAG = null;
	String M_TEMP_1 = null;
	String M_FLAG = null;
	String M_VAL = null;
	String M_ASD_CHAR_VALUE = null;
	String M_ASD_NUM_VALUE = null;
	String M_POL_LC_SUM_ASSURED = null;
	String M_POL_FC_NET_PREM = null;
	String M_POL_LC_NET_PREM = null;
	String M_FC_INST_PREM = null;
	String M_LC_INST_PREM = null;
	String M_POL_NO_OF_INST = null;
	String M_PS_VALUE = null;
	String M_PROD_CBC_YN = null;
	String M_PS_CODE_DESC = null;
	String M_CODE_DESC = null;
	String M_VALUE = null;
	double M_SHORT_COLL_VALUE = -1;
	String M_MED_PAID = null;
	String M_CALC_METHOD = null;
	String M_LC_GROSS_CONT = null;
	String M_FC_GROSS_CONT = null;
	String M_FC_OCC_LOAD = null;
	String M_LC_OCC_LOAD = null;
	String M_FC_DEATH_LOAD = null;
	String M_LC_DEATH_LOAD = null;
	String M_FC_TPD_LOAD = null;
	String M_LC_TPD_LOAD = null;
	String M_PDL_DISC_LOAD_CODE_TPD = null;
	String M_PDL_DISC_LOAD_CODE_DEATH = null;
	String M_PDL_DISC_LOAD_CODE_OCC = null;
	String M_FC_MED_LOAD = null;
	String M_LC_MED_LOAD = null;
	String M_POL_FC_BASIC_PREM = null;
	String M_POL_LC_BASIC_PREM = null;
	String M_POL_FC_ADDL_PREM = null;
	String M_POL_LC_ADDL_PREM = null;
	String M_POL_FC_SUM_ASSURED = null;
	String M_FC_TEMP_GROSS_CONT = null;
	String M_LC_TEMP_GROSS_CONT = null;
	String M_POL_INCORPORATED_YN = null;
	String M_POL_PLAN_CODE = null;
	String M_FC_TEMP_NET_PREM = null;
	String M_LC_TEMP_NET_PREM = null;
	String M_POL_ADDL_STATUS = null;
	String M_PR_PSTPND_YN = null;
	String M_POL_DS_CODE = null;
	String M_DR_REPORT_CODE = null;
	String M_PC_DESC = null;
	String M_PC_BL_DESC = null;
	String M_CONT_PREFERRED_LANG = null;
	String M_REP_NAME = null;
	double M_DSRC_SYS_ID = -1;
	String M_POL_DS_TYPE = null;
	String M_CAN_CONVERT_FLAG = "N";
	Double M_FC_FIRST_PREM = null;
	Double M_LC_FIRST_PREM = null;
	String M_PROD_AUTO_APPROV = null;
	String M_PROD_PREM_CALC_MTHD = null;
	Double M_MFD_FC_VALUE = null;
	String M_PROD_AGENT_HIRE_YN = null;
	String M_POL_PREM_PAY_YRS = null;
	double M_PMOP_SHORT_RATE = -1;
	double M_PMOP_SHORT_RATE_PER = -1;
	String M_PMOP_TOLL_TYP = null;
	String M_POL_PROD_CODE = null;
	String M_POL_FAC_YN = null;
	String M_POL_STD_RISK_YN = null;
	String M_DS_POST_BO = null;
	String M_PS_CODE = null;

	String navigateTo = null;

	int Update1 = 0;
	int Update2 = 0;
	int update3 = 0;
	int update4 = 0;
	int update5 = 0;
	int update6 = 0;
	int update7 = 0;
	int update8 = 0;
	int update9 = 0;
	int update10 = 0;
	int update11 = 0;

	int vembu12 = 0;
	int vembu13 = 0;
	int vembu14 = 0;
	int vembu15 = 0;
	int vembu16 = 0;
	int vembu17 = 0;
	int vembu18 = 0;
	int vembu19 = 0;
	int vembu20 = 0;
	int vembu21 = 0;
	int vembu22 = 0;
	int vembu23 = 0;
	int vembu24 = 0;
	int vembu25 = 0;

	int insert1 = 0;
	int insert2 = 0;
	int insert3 = 0;
	int insert4 = 0;
	int insert5 = 0;
	int insert11 = 0;

	DB_PROCEDURES pilp001dbProcedures = new DB_PROCEDURES();

	try {
	    connection = CommonUtils.getConnection();

	    String sql_C5 = SQLQueryInterfacePILP001.sql_C5;
	    Object[] objectsql_C5 = { DUMMY_BEAN.getUI_M_PROP_NO() };
	    rs_C5 = handler.executeSelectStatement(sql_C5, connection,
		    objectsql_C5);

	    String sql_C6 = SQLQueryInterfacePILP001.sql_C6;
	    Object[] objectsql_C6 = { DUMMY_BEAN.getM_POL_SYS_ID() };
	    rs_C6 = handler.executeSelectStatement(sql_C6, connection,
		    objectsql_C6);

	    // NOT BEING USED ANYWHERE
	    /*
	     * String sql_C13 = SQLQueryInterfacePILP001.sql_C13; Object[]
	     * objectsql_C13 = {M_PS_CODE,DUMMY_BEAN.getM_POL_SYS_ID()}; rs_C13 =
	     * handler.executeSelectStatement(sql_C13, connection,
	     * objectsql_C13);
	     */

	    String sql_C14 = SQLQueryInterfacePILP001.sql_C14;
	    Object[] objectsql_C14 = { DUMMY_BEAN.getM_POL_SYS_ID() };
	    rs_C14 = handler.executeSelectStatement(sql_C14, connection,
		    objectsql_C14);

	    /*
	     * if(rs_C10!=null) { rs_C10.close(); }
	     */

	    String sql_C10 = SQLQueryInterfacePILP001.sql_C10;
	    Object[] objectsql_C10 = {};
	    rs_C10 = handler.executeSelectStatement(sql_C10, connection,
		    objectsql_C10);

	    if (rs_C10.next()) {
		M_CALC_METHOD = rs_C10.getString(1);
	    }
	    // rs_C10.close();
	    CommonUtils.closeCursor(rs_C10);

	    /*
	     * if(rs_C1!=null) { rs_C1.close(); }
	     */

	    String sql_C1 = SQLQueryInterfacePILP001.sql_C1;
	    Object[] objectsql_C1 = { DUMMY_BEAN.getM_POL_SYS_ID() };
	    rs_C1 = handler.executeSelectStatement(sql_C1, connection,
		    objectsql_C1);

	    if (rs_C1.next()) {
		M_POL_CUST_CURR_CODE = rs_C1.getString(1);
		M_POL_EXCHANGE_RATE = rs_C1.getString(2);
		M_POL_CONT_CODE = rs_C1.getString(3);
		M_POL_END_NO_IDX = rs_C1.getString(4);
		M_POL_FC_DEPOSIT_AMOUNT = rs_C1.getString(5);
		M_POL_LC_DEPOSIT_AMOUNT = rs_C1.getString(6);
		M_POL_FC_FIRST_PREM = rs_C1.getString(7);
		M_POL_LC_FIRST_PREM = rs_C1.getString(8);
		M_POL_FC_NET_PREM = rs_C1.getString(9);
		M_POL_LC_NET_PREM = rs_C1.getString(10);
		M_POL_NO_OF_INST = rs_C1.getString(11);
		M_POL_INCORPORATED_YN = rs_C1.getString(12);
		M_POL_FC_BASIC_PREM = rs_C1.getString(13);
		M_POL_LC_BASIC_PREM = rs_C1.getString(14);
		M_POL_FC_ADDL_PREM = rs_C1.getString(15);
		M_POL_LC_ADDL_PREM = rs_C1.getString(16);
		M_POL_FC_SUM_ASSURED = rs_C1.getString(17);
		M_POL_LC_SUM_ASSURED = rs_C1.getString(18);
		M_POL_PLAN_CODE = rs_C1.getString(19);
		M_POL_PROP_NO = rs_C1.getString(20);
		M_POL_DS_CODE = rs_C1.getString(21);
		M_POL_DS_TYPE = rs_C1.getString(22);
		M_POL_PREM_PAY_YRS = rs_C1.getString(23);
		M_POL_PROD_CODE = rs_C1.getString(24);
		System.out.println("M_POL_PROD_CODE :" + M_POL_PROD_CODE);
		M_POL_FAC_YN = rs_C1.getString(25);
	    }
	    // rs_C1.close();
	    CommonUtils.closeCursor(rs_C1);
	    // Added By Shankar BOdduluri (CCHN1148)
	    if ("Y".equals(DUMMY_BEAN.getUI_M_RE_UW_REQ_YN())) {
		String M_POL_SYS_ID = CommonUtils
			.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
		if (DUMMY_BEAN.getUI_M_RE_UW_REQ_REASON() == null) {
		    throw new ValidatorException(Messages.getMessage(
			    PELConstants.pelErrorMessagePath, "91991"));
		}
		DB_Procedures.P9ILPK_POLICY_P_INS_UPD_RUW_STS(M_POL_SYS_ID,
			M_POL_END_NO_IDX + "", DUMMY_BEAN
				.getUI_M_RE_UW_REQ_REASON(), CommonUtils
				.dateToStringFormatter(DUMMY_BEAN
					.getUI_M_APPRV_DATE()));
		// [PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 -Replaced
		// validaotor with errorMap]
		getPolicyWarningMap().put(
			PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			Messages.getMessage(PELConstants.pelErrorMessagePath,
				"91989").getSummary());
		getPolicyWarningMap().put(
			PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
			Messages.getMessage(PELConstants.pelErrorMessagePath,
				"91989").getSummary());
		navigateTo = navigateToPolicy();
		// [PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 -Replaced
		// validaotor with errorMap]
	    } else {
		String sql_C27 = SQLQueryInterfacePILP001.sql_C27;
		Object[] objectsql_C27 = { M_POL_DS_TYPE, M_POL_DS_CODE };
		rs_C27 = handler.executeSelectStatement(sql_C27, connection,
			objectsql_C27);

		if (rs_C27.next()) {
		    M_DS_POST_BO = rs_C27.getString(1);
		}
		// rs_C27.close();
		CommonUtils.closeCursor(rs_C27);
		/*
		 * if(rs_C16!=null) { rs_C16.close(); }
		 */
		String sql_C16 = SQLQueryInterfacePILP001.sql_C16;
		Object[] objectsql_C16 = { M_POL_PLAN_CODE };
		rs_C16 = handler.executeSelectStatement(sql_C16, connection,
			objectsql_C16);

		if (rs_C16.next()) {
		    M_POL_PLAN_TYPE = rs_C16.getString(1);
		}
		// rs_C16.close();
		CommonUtils.closeCursor(rs_C16);
		/*
		 * if(rs_C9!=null) { rs_C9.close(); }
		 */

		String sql_C9 = SQLQueryInterfacePILP001.sql_C9;
		Object[] objectsql_C9 = { DUMMY_BEAN.getM_POL_SYS_ID() };
		rs_C9 = handler.executeSelectStatement(sql_C9, connection,
			objectsql_C9);

		if (rs_C9.next()) {
		    M_POL_LC_SUM_ASSURED = rs_C9.getString(1);
		    M_POL_STD_RISK_YN = rs_C9.getString(2);
		}
		// rs_C9.close();
		CommonUtils.closeCursor(rs_C9);
		/*
		 * if(rs_C7!=null) { rs_C7.close(); }
		 */

		String sql_C7 = SQLQueryInterfacePILP001.sql_C7;
		Object[] objectsql_C7 = { controlBean.getM_USER_ID(),
			M_POL_STD_RISK_YN, M_POL_PROD_CODE };
		rs_C7 = handler.executeSelectStatement(sql_C7, connection,
			objectsql_C7);

		if (rs_C7.next()) {
		    M_ASD_CHAR_VALUE = rs_C7.getString(1);
		}
		// rs_C7.close();
		CommonUtils.closeCursor(rs_C7);
		/*
		 * if(rs_C17!=null) { rs_C17.close(); }
		 */
		String sql_C17 = SQLQueryInterfacePILP001.sql_C17;
		Object[] objectsql_C17 = { DUMMY_BEAN.getUI_M_PROP_NO() };
		rs_C17 = handler.executeSelectStatement(sql_C17, connection,
			objectsql_C17);

		if (rs_C17.next()) {
		    M_DEP_GROSS_NET_FLAG = rs_C17.getString(1);
		}
		// rs_C17.close();
		CommonUtils.closeCursor(rs_C17);
		/*
		 * if(rs_C24!=null) { rs_C24.close(); }
		 */

		String sql_C24 = SQLQueryInterfacePILP001.sql_C24;
		Object[] objectsql_C24 = { DUMMY_BEAN.getM_POL_SYS_ID() };
		rs_C24 = handler.executeSelectStatement(sql_C24, connection,
			objectsql_C24);

		if (rs_C24.next()) {
		    M_MFD_FC_VALUE = rs_C24.getDouble(1);
		}
		// rs_C24.close();
		CommonUtils.closeCursor(rs_C24);
		if ("N".equals(MigratingFunctions.nvl(M_POL_FAC_YN, "N"))) {
		    // if(MigratingFunctions.nvl(M_POL_FAC_YN,"N").equals("N"))
		    // {
		    /*
		     * the Below Procedure Is Moved to Freezeflag when list
		     * changed in policy action due to PREMIAGDC-277588
		     * -Throwing waring masg if traety amt exceeds treaty limit
		     * VIJAYANAND.V 10-08-2009
		     */
		    // pilp001dbProcedures.callP9ILPK_RI_ALLOC_P_VAL_PROP_TREATY_LIMIT(DUMMY_BEAN.getM_POL_SYS_ID(),this);
		    // p9ilpk_ri_alloc.p9ilpk_ri_alloc.p_val_prop_treaty_limit(:DUMMY.M_POL_SYS_ID);
		}
		
		//ADDDED BY AKASH TO MAKE NORMAL FLOW TO BHE WORK --M_CALC_METHOD.equals("2")
		
		if ((MigratingFunctions.nvl(DUMMY_BEAN
			.getUI_M_MED_FEE_RECOVER_YN(), "N") == "Y"
			&& M_POL_DS_TYPE == "1" && (M_CALC_METHOD.equals("1") || M_CALC_METHOD.equals("2")))) {
		    if (DUMMY_BEAN.getUI_M_PROP_STATUS().equals("C")
			    || DUMMY_BEAN.getUI_M_PROP_STATUS().equals("I")) {
			/*
			 * if(rs_C25!=null) { rs_C25.close(); }
			 */

			String sql_C25 = SQLQueryInterfacePILP001.sql_C25;
			Object[] objectsql_C25 = { DUMMY_BEAN.getM_POL_SYS_ID() };
			rs_C25 = handler.executeSelectStatement(sql_C25,
				connection, objectsql_C25);

			if (rs_C25.next()) {
			    M_MED_PAID = rs_C25.getString(1);
			}
			// rs_C25.close();
			try {
			    CommonUtils.closeCursor(rs_C25);
			} catch (Exception e) {
			    e.printStackTrace();
			}
			if (MigratingFunctions.nvl(M_MED_PAID, "N").equals("X")) {
			    throw new ValidatorException(Messages.getMessage(
				    "com.iii.premia.common.errorUtil.PELErrorMessages",
				    "91525"));
			    /*
			     * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE("91525",:CTRL.M_LANG_CODE);
			     * throw new FORM_TRIGGER_FAILURE();
			     */
			}
		    }
		}
		if (MigratingFunctions.nvl(M_ASD_CHAR_VALUE, "N").equals("N")) {
		    throw new ValidatorException(Messages.getMessage(
			    "com.iii.premia.common.errorUtil.PELErrorMessages", "91137"));
		    /*
		     * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91137,:CTRL.M_LANG_CODE);
		     * throw new FORM_TRIGGER_FAILURE();
		     */
		} else {
		    /*
		     * if(rs_C8!=null) { rs_C8.close(); }
		     */

		    String sql_C8 = SQLQueryInterfacePILP001.sql_C8;
		    Object[] objectsql_C8 = { controlBean.getM_USER_ID(),
			    M_POL_STD_RISK_YN, M_POL_PROD_CODE };
		    rs_C8 = handler.executeSelectStatement(sql_C8, connection,
			    objectsql_C8);

		    if (rs_C8.next()) {
			M_ASD_NUM_VALUE = rs_C8.getString(1);
		    }
		    // rs_C8.close();
		    try {
			CommonUtils.closeCursor(rs_C8);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    if (MigratingFunctions.nvl(CommonUtils
			    .parseToDouble(M_POL_LC_SUM_ASSURED), 0) > MigratingFunctions
			    .nvl(CommonUtils.parseToDouble(M_ASD_NUM_VALUE), 0)) {
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"80329"));
			/*
			 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(80329,:CTRL.M_LANG_CODE);
			 * throw new FORM_TRIGGER_FAILURE();
			 */
		    }
		    /*
		     * if(rs_C22!=null) { rs_C22.close(); }
		     */

		    String sql_C22 = SQLQueryInterfacePILP001.sql_C22;
		    Object[] objectsql_C22 = { DUMMY_BEAN.getM_POL_SYS_ID() };
		    rs_C22 = handler.executeSelectStatement(sql_C22,
			    connection, objectsql_C22);

		    if (rs_C22.next()) {
			M_POAD_LC_THRESHOLD_LMT = rs_C22.getString(1);
		    }
		    // rs_C22.close();
		    try {
			CommonUtils.closeCursor(rs_C22);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    /*
		     * if(rs_C23!=null) { rs_C23.close(); }
		     */

		    String sql_C23 = SQLQueryInterfacePILP001.sql_C23;
		    Object[] objectsql_C23 = { controlBean.getM_USER_ID(),
			    M_POL_STD_RISK_YN, M_POL_PROD_CODE };
		    rs_C23 = handler.executeSelectStatement(sql_C23,
			    connection, objectsql_C23);

		    if (rs_C23.next()) {
			M_TH_ASD_NUM_VALUE = rs_C23.getString(1);
		    }
		    // rs_C23.close();
		    try {
			CommonUtils.closeCursor(rs_C23);
		    } catch (Exception e) {
			e.printStackTrace();
		    }

		    if (MigratingFunctions.nvl(CommonUtils
			    .parseToDouble(M_POAD_LC_THRESHOLD_LMT), 0) > MigratingFunctions
			    .nvl(CommonUtils.parseToDouble(M_TH_ASD_NUM_VALUE),
				    0)) {
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91331"));
			// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91331,:CTRL.M_LANG_CODE);
		    }
		}
		if (MigratingFunctions
			.nvl(DUMMY_BEAN.getUI_M_PROP_STATUS(), "").equals("C")
			|| MigratingFunctions.nvl(
				DUMMY_BEAN.getUI_M_PROP_STATUS(), "").equals(
				"I")) {
		    // if(rs_C5!=null)
		    // {
		    // rs_C5.close();
		    // }

		    if (rs_C5.next()) {
			M_TEMP_1 = rs_C5.getString(1);
			// rs_C5.close();
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91103"));
		    }

		    if (rs_C6.next()) {
			M_VAL = rs_C6.getString(1);
		    } else {
			// rs_C6.close();
			try {
			    CommonUtils.closeCursor(rs_C6);
			} catch (Exception e) {
			    e.printStackTrace();
			}
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91128"));

		    }
		    if (DUMMY_BEAN.getUI_M_DEPPREM_REFUND_YN().equals("Y")) {
		    	
		    	//COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
		    	
			/*if (MigratingFunctions.nvl(M_CALC_METHOD, "").equals(
				"2")) {

			    String sql_C3 = SQLQueryInterfacePILP001.sql_C3;
			    Object[] objectsql_C3 = { M_POL_CONT_CODE };
			    rs_C3 = handler.executeSelectStatement(sql_C3,
				    connection, objectsql_C3);

			    if (rs_C3.next()) {
				M_CONT_LC_PROP_DEP_AMT = rs_C3.getDouble(1);
				M_CONT_LC_PROP_UTIL_AMT = rs_C3.getDouble(2);
				M_CONT_LC_POL_DEP_AMT = rs_C3.getString(3);
				M_CONT_LC_POL_UTIL_AMT = rs_C3.getString(4);
			    }
			    // rs_C3.close();
			    try {
				CommonUtils.closeCursor(rs_C3);
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			    M_CONT_LC_DEP_TEMP = ((M_CONT_LC_PROP_DEP_AMT) - (M_CONT_LC_PROP_UTIL_AMT));
			    if (M_CONT_LC_DEP_TEMP > 0) {
				DBProcedures dbProcedures = new DBProcedures();
				dbProcedures.callP_VAL_ROUND_AMT(DUMMY_BEAN
					.getM_BASE_CURR_CODE(),
					M_CONT_LC_DEP_TEMP.toString(), "R");
				// P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(DUMMY_BEAN.getM_BASE_CURR_CODE(),M_CONT_LC_DEP_TEMP,"R");
				M_CONT_FC_DEP_TEMP = M_CONT_LC_DEP_TEMP
					/ Double
						.parseDouble(M_POL_EXCHANGE_RATE);

				dbProcedures.callP_VAL_ROUND_AMT(
					M_POL_CUST_CURR_CODE,
					M_CONT_FC_DEP_TEMP.toString(), "R");
				// P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(M_POL_CUST_CURR_CODE,M_CONT_FC_DEP_TEMP,"R");
				M_CONT_LC_DEP_TEMP = M_CONT_LC_DEP_TEMP * -1;
				M_CONT_FC_DEP_TEMP = M_CONT_FC_DEP_TEMP * -1;

				pilp001dbProcedures
					.callP9ILPK_POLICY_PROP_APPROVAL(
						CommonUtils.getProcedureValue(DUMMY_BEAN.getM_POL_SYS_ID()),
						M_POL_FC_FIRST_PREM,
						M_POL_LC_FIRST_PREM,
						M_CONT_LC_DEP_TEMP.toString(),
						M_CONT_FC_DEP_TEMP.toString(),
						DUMMY_BEAN.getUI_M_APPRV_DATE()
							.toString());

				// p9ilpk_policy.prop_approval(DUMMY_BEAN.getM_POL_SYS_ID(),M_POL_FC_FIRST_PREM,M_POL_LC_FIRST_PREM,M_CONT_LC_DEP_TEMP,M_CONT_FC_DEP_TEMP,:DUMMY.M_APPRV_DATE);
				pilp001dbProcedures
					.callP9ILPK_ENDORSE_GEN_MEDFEE_RECVR_ACCNTG_PROP(CommonUtils.getProcedureValue(DUMMY_BEAN
						.getM_POL_SYS_ID()));
				// p9ilpk_endorse.p9ilpk_endorse.gen_medfee_recvr_accntg_prop(DUMMY_BEAN.getM_POL_SYS_ID());
			    }
			}*/
			if (DUMMY_BEAN.getUI_M_PROP_STATUS().equals("C")) {
			    String sql_Update1 = SQLQueryInterfacePILP001.sql_Update1;
			    Object[] objectsql_Update1 = {
				    DUMMY_BEAN.getUI_M_PROP_STATUS(),
				    M_CALC_METHOD, DUMMY_BEAN.getM_POL_SYS_ID() };
			    Update1 = handler.executeUpdateStatement(
				    sql_Update1, connection, objectsql_Update1);
			} else {
			    String sql_Update2 = SQLQueryInterfacePILP001.sql_Update2;
			    Object[] objectsql_Update2 = {
				    DUMMY_BEAN.getUI_M_PROP_STATUS(),
				    M_CALC_METHOD, DUMMY_BEAN.getM_POL_SYS_ID() };
			    Update2 = handler.executeUpdateStatement(
				    sql_Update2, connection, objectsql_Update2);
			}
			if (MigratingFunctions.nvl(M_CALC_METHOD, "").equals(
				"1")) {

			    if (MigratingFunctions.nvl(
				    DUMMY_BEAN.getUI_M_DEPPREM_REFUND_YN(), "")
				    .equals("Y")) {

				if ((MigratingFunctions
					.nvl(
						DUMMY_BEAN
							.getUI_M_MED_FEE_RECOVER_YN(),
						"").equals("Y") && MigratingFunctions
					.nvl(M_MFD_FC_VALUE, 0) == 0)
					|| MigratingFunctions
						.nvl(
							DUMMY_BEAN
								.getUI_M_MED_FEE_RECOVER_YN(),
							"").equals("N")) {

				    pilp001dbProcedures
					    .callP9ILPK_DEP_APPROVAL_P_REFUND_DEP(
						    CommonUtils.getProcedureValue( DUMMY_BEAN.getM_POL_SYS_ID()),
						    DUMMY_BEAN
							    .getUI_M_APPRV_DATE()
							    .toString(), null,
						    null);

				    // p9ilpk_dep_approval.p9ilpk_dep_approval.p_refund_dep(DUMMY_BEAN.getM_POL_SYS_ID(),DUMMY_BEAN.getUI_M_APPRV_DATE());
				} else if (MigratingFunctions
					.nvl(
						DUMMY_BEAN
							.getUI_M_MED_FEE_RECOVER_YN(),
						"").equals("Y")
					&& MigratingFunctions.nvl(
						M_MFD_FC_VALUE, 0) > 0) {
				    pilp001dbProcedures
					    .callP9ILPK_DEP_APPROVAL_P_MED_FEE_RECOVER(
						    DUMMY_BEAN
							    .getUI_M_PROP_NO(),
						    DUMMY_BEAN
							    .getUI_M_APPRV_DATE()
							    .toString());
				    // p9ilpk_dep_approval.p_med_fee_recover(DUMMY_BEAN.getUI_M_PROP_NO(),DUMMY_BEAN.getUI_M_APPRV_DATE());
				}
			    }
			    if (MigratingFunctions.nvl(
				    DUMMY_BEAN.getUI_M_PROP_STATUS(), "")
				    .equals("C")) {
				String sql_insert1 = SQLQueryInterfacePILP001.sql_insert1;
				Object[] objectsql_insert1 = {
					DUMMY_BEAN.getM_POL_SYS_ID(),
					M_POL_END_NO_IDX,
					DUMMY_BEAN.getUI_M_APPRV_DATE(),
					DUMMY_BEAN.getUI_M_PS_REASON_CODE(),
					DUMMY_BEAN.getUI_M_PS_REMARKS(),
					session.get("GLOBAL.M_USER_ID"),
					session.get("GLOBAL.M_USER_ID") };
				insert1 = handler.executeInsertStatement(
					sql_insert1, connection,
					objectsql_insert1);

			    } else {
				String sql_insert2 = SQLQueryInterfacePILP001.sql_insert2;
				Object[] objectsql_insert2 = {
					DUMMY_BEAN.getM_POL_SYS_ID(),
					M_POL_END_NO_IDX,
					DUMMY_BEAN.getUI_M_APPRV_DATE(),
					DUMMY_BEAN.getUI_M_PS_REASON_CODE(),
					DUMMY_BEAN.getUI_M_PS_REMARKS(),
					session.get("GLOBAL.M_USER_ID"),
					session.get("GLOBAL.M_USER_ID") };
				insert2 = handler.executeInsertStatement(
					sql_insert2, connection,
					objectsql_insert2);
			    }
			}
		    } else {
			if (MigratingFunctions.nvl(
				DUMMY_BEAN.getUI_M_PROP_STATUS(), "").equals(
				"C")) {
			    String sql_update3 = SQLQueryInterfacePILP001.sql_update3;
			    Object[] objectsql_update3 = {
				    DUMMY_BEAN.getUI_M_PROP_STATUS(),
				    M_CALC_METHOD, DUMMY_BEAN.getM_POL_SYS_ID() };
			    update3 = handler.executeUpdateStatement(
				    sql_update3, connection, objectsql_update3);

			    String sql_insert3 = SQLQueryInterfacePILP001.sql_insert3;
			    Object[] objectsql_insert3 = {
				    DUMMY_BEAN.getM_POL_SYS_ID(),
				    M_POL_END_NO_IDX,
				    DUMMY_BEAN.getUI_M_APPRV_DATE(),
				    DUMMY_BEAN.getUI_M_PS_REASON_CODE(),
				    DUMMY_BEAN.getUI_M_PS_REMARKS(),
				    session.get("GLOBAL.M_USER_ID"),
				    session.get("GLOBAL.M_USER_ID") };
			    insert3 = handler.executeInsertStatement(
				    sql_insert3, connection, objectsql_insert3);

			} else {
			    String sql_update4 = SQLQueryInterfacePILP001.sql_update4;
			    Object[] objectsql_update4 = {
				    DUMMY_BEAN.getUI_M_PROP_STATUS(),
				    M_CALC_METHOD, DUMMY_BEAN.getM_POL_SYS_ID() };
			    update4 = handler.executeUpdateStatement(
				    sql_update4, connection, objectsql_update4);

			    String sql_insert4 = SQLQueryInterfacePILP001.sql_insert4;
			    Object[] objectsql_insert4 = {
				    DUMMY_BEAN.getM_POL_SYS_ID(),
				    M_POL_END_NO_IDX,
				    DUMMY_BEAN.getUI_M_APPRV_DATE(),
				    DUMMY_BEAN.getUI_M_PS_REASON_CODE(),
				    DUMMY_BEAN.getUI_M_PS_REMARKS(),
				    session.get("GLOBAL.M_USER_ID"),
				    session.get("GLOBAL.M_USER_ID") };
			    insert4 = handler.executeInsertStatement(
				    sql_insert4, connection, objectsql_insert4);
			}
			if (MigratingFunctions.nvl(
				DUMMY_BEAN.getUI_M_PROP_STATUS(), "").equals(
				"C")) {
			    throw new ValidatorException(Messages.getMessage(
				    "com.iii.premia.common.errorUtil.PELErrorMessages",
				    "91110"));
			    // STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91110,:CTRL.M_LANG_CODE,DUMMY_BEAN.getUI_M_PROP_NO());
			} else {
			    throw new ValidatorException(Messages.getMessage(
				    "com.iii.premia.common.errorUtil.PELErrorMessages",
				    "91214"));
			    // STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91214,:CTRL.M_LANG_CODE,DUMMY_BEAN.getUI_M_PROP_NO());
			}
		    }
		}

		String sql_C18 = SQLQueryInterfacePILP001.sql_C18;
		Object[] objectsql_C18 = { controlBean.getM_USER_ID(),
			M_POL_PROD_CODE };
		rs_C18 = handler.executeSelectStatement(sql_C18, connection,
			objectsql_C18);

		if (rs_C18.next()) {
		    M_PR_PSTPND_YN = rs_C18.getString(1);
		}
		// rs_C18.close();
		try {
		    CommonUtils.closeCursor(rs_C18);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		if (MigratingFunctions.nvl(M_PR_PSTPND_YN, "N") == "N"
			&& DUMMY_BEAN.getUI_M_PROP_STATUS() == "P") {
		    throw new ValidatorException(Messages.getMessage(
			    "com.iii.premia.common.errorUtil.PELErrorMessages", "91222"));
		    // STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91222,:CTRL.M_LANG_CODE);
		}
		if (MigratingFunctions
			.nvl(DUMMY_BEAN.getUI_M_PROP_STATUS(), "").equals("O")
			|| MigratingFunctions.nvl(
				DUMMY_BEAN.getUI_M_PROP_STATUS(), "").equals(
				"W")
			|| MigratingFunctions.nvl(
				DUMMY_BEAN.getUI_M_PROP_STATUS(), "").equals(
				"P")) {

		    if (rs_C5.next()) {
			M_TEMP_1 = rs_C5.getString(1);
		    }
		    if (!rs_C5.isLast()) {
			if (MigratingFunctions.nvl(
				DUMMY_BEAN.getUI_M_PROP_STATUS(), "").equals(
				"P")) {
			    // rs_C5.close();
			    try {
				CommonUtils.closeCursor(rs_C5);
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			    throw new ValidatorException(Messages.getMessage(
				    "com.iii.premia.common.errorUtil.PELErrorMessages",
				    "91215"));
			    // STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91215,:CTRL.M_LANG_CODE);
			} else if (MigratingFunctions.nvl(
				DUMMY_BEAN.getUI_M_PROP_STATUS(), "").equals(
				"O")) {
			    throw new ValidatorException(Messages.getMessage(
				    "com.iii.premia.common.errorUtil.PELErrorMessages",
				    "91215"));
			    // rs_C5.close();
			    // STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91215,:CTRL.M_LANG_CODE);
			}
		    }
		    // rs_C5.close();
		    try {
			CommonUtils.closeCursor(rs_C5);
		    } catch (Exception e) {
			e.printStackTrace();
		    }

		    if (rs_C6.next()) {
			M_VAL = rs_C6.getString(1);
		    }
		    if (rs_C6.next()) {
			if ("P".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())) {
			    // rs_C6.close();
			    try {
				CommonUtils.closeCursor(rs_C6);
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			    throw new ValidatorException(Messages.getMessage(
				    "com.iii.premia.common.errorUtil.PELErrorMessages",
				    "91217"));
			    // STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91217,:CTRL.M_LANG_CODE);
			}
		    }
		    // rs_C6.close();
		    try {
			CommonUtils.closeCursor(rs_C6);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    if ("P".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())) {
			M_POL_ADDL_STATUS = "B07";
		    } else if ("W".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())) {
			M_POL_ADDL_STATUS = "W01";
		    } else if ("O".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())) {
			M_POL_ADDL_STATUS = DUMMY_BEAN.getUI_M_PS_REASON_CODE();
		    }
		    if ("Y".equals(DUMMY_BEAN.getUI_M_DEPPREM_REFUND_YN())) {
		    	
		   //COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
		    	
			/*if ("2".equals(M_CALC_METHOD)) {
			    // if(rs_C3!=null)
			    // {
			    // rs_C3.close();
			    // }
			    // rs_C3=stmt_C3.executeQuery(SQLQueryInterfacePILP001.sql_C3);
			    if (rs_C3.next()) {
				M_CONT_LC_PROP_DEP_AMT = rs_C3.getDouble(1);
				M_CONT_LC_PROP_UTIL_AMT = rs_C3.getDouble(2);
				M_CONT_LC_POL_DEP_AMT = rs_C3.getString(3);
				M_CONT_LC_POL_UTIL_AMT = rs_C3.getString(4);
			    }
			    // rs_C3.close();
			    try {
				CommonUtils.closeCursor(rs_C3);
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			    M_CONT_LC_DEP_TEMP = M_CONT_LC_PROP_DEP_AMT
				    - M_CONT_LC_PROP_UTIL_AMT;
			    if (M_CONT_LC_DEP_TEMP > 0) {
				DBProcedures dbProcedures = new DBProcedures();

				dbProcedures.callP_VAL_ROUND_AMT(DUMMY_BEAN
					.getM_BASE_CURR_CODE(),
					M_CONT_LC_DEP_TEMP.toString(), "R");
				// P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(:DUMMY1.M_BASE_CURR_CODE,M_CONT_LC_DEP_TEMP,"R");
				M_CONT_FC_DEP_TEMP = M_CONT_LC_DEP_TEMP
					/ Double
						.parseDouble(M_POL_EXCHANGE_RATE);
				dbProcedures.callP_VAL_ROUND_AMT(
					M_POL_CUST_CURR_CODE,
					M_CONT_FC_DEP_TEMP.toString(), "R");
				// P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(M_POL_CUST_CURR_CODE,M_CONT_FC_DEP_TEMP,"R");
				M_CONT_LC_DEP_TEMP = M_CONT_LC_DEP_TEMP * -1;
				M_CONT_FC_DEP_TEMP = M_CONT_FC_DEP_TEMP * -1;

				pilp001dbProcedures
					.callP9ILPK_POLICY_PROP_APPROVAL(
						CommonUtils.getProcedureValue(	DUMMY_BEAN.getM_POL_SYS_ID()),
						M_POL_FC_FIRST_PREM,
						M_POL_LC_FIRST_PREM,
						M_CONT_LC_DEP_TEMP.toString(),
						M_CONT_FC_DEP_TEMP.toString(),
						DUMMY_BEAN.getUI_M_APPRV_DATE()
							.toString());

				// p9ilpk_policy.p9ilpk_policy.prop_approval(DUMMY_BEAN.getM_POL_SYS_ID(),M_POL_FC_FIRST_PREM,M_POL_LC_FIRST_PREM,M_CONT_LC_DEP_TEMP,M_CONT_FC_DEP_TEMP,DUMMY_BEAN.getUI_M_APPRV_DATE());
			    }
			}*/
		    	//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK --"2".equals(M_CALC_METHOD) 
		    	
			if ("1".equals(M_CALC_METHOD) || "2".equals(M_CALC_METHOD)) {
			    if ("Y".equals(DUMMY_BEAN
				    .getUI_M_DEPPREM_REFUND_YN())) {
				if (("Y".equals(DUMMY_BEAN
					.getUI_M_MED_FEE_RECOVER_YN()) && MigratingFunctions
					.nvl(M_MFD_FC_VALUE, 0) == 0)
					|| "N".equals(DUMMY_BEAN
						.getUI_M_MED_FEE_RECOVER_YN())) {
				    pilp001dbProcedures
					    .callP9ILPK_DEP_APPROVAL_P_REFUND_DEP(
						    CommonUtils.getProcedureValue(DUMMY_BEAN.getM_POL_SYS_ID()),
						    CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_APPRV_DATE()), null,
						    null);

				    // p9ilpk_dep_approval.p9ilpk_dep_approval.p_refund_dep(DUMMY_BEAN.getM_POL_SYS_ID(),DUMMY_BEAN.getUI_M_APPRV_DATE());
				} else if ("Y".equals(DUMMY_BEAN
					.getUI_M_MED_FEE_RECOVER_YN())
					&& MigratingFunctions.nvl(
						M_MFD_FC_VALUE, 0) > 0) {
				    pilp001dbProcedures
					    .callP9ILPK_DEP_APPROVAL_P_MED_FEE_RECOVER(
						    DUMMY_BEAN
							    .getUI_M_PROP_NO(),
						    DUMMY_BEAN
							    .getUI_M_APPRV_DATE()
							    .toString());

				    // p9ilpk_dep_approval.p9ilpk_dep_approval.p_med_fee_recover(DUMMY_BEAN.getUI_M_PROP_NO(),DUMMY_BEAN.getUI_M_APPRV_DATE());
				}
			    }
			}
		    }

		    String sql_Update9 = SQLQueryInterfacePILP001.sql_Update9;
		    Object[] objectsql_Update9 = { M_POL_ADDL_STATUS,
			    M_CALC_METHOD, DUMMY_BEAN.getM_POL_SYS_ID() };
		    update9 = handler.executeUpdateStatement(sql_Update9,
			    connection, objectsql_Update9);

		    String sql_insert5 = SQLQueryInterfacePILP001.sql_insert5;
		    Object[] objectsql_insert5 = {
			    DUMMY_BEAN.getM_POL_SYS_ID(), M_POL_END_NO_IDX,
			    DUMMY_BEAN.getUI_M_APPRV_DATE(), M_POL_ADDL_STATUS,
			    DUMMY_BEAN.getUI_M_PS_REASON_CODE(),
			    DUMMY_BEAN.getUI_M_PS_REMARKS(),
			    session.get("GLOBAL.M_USER_ID"),
			    session.get("GLOBAL.M_USER_ID") };
		    insert5 = handler.executeInsertStatement(sql_insert5,
			    connection, objectsql_insert5);

		    // if(rs_C19!=null)
		    // {
		    // rs_C19.close();
		    // }

		    String sql_C19 = SQLQueryInterfacePILP001.sql_C19;
		    Object[] objectsql_C19 = { M_POL_DS_CODE,
			    DUMMY_BEAN.getUI_M_PS_REASON_CODE() };
		    rs_C19 = handler.executeSelectStatement(sql_C19,
			    connection, objectsql_C19);

		    if (rs_C19.next()) {
			M_DR_REPORT_CODE = rs_C19.getString(1);
		    }
		    // rs_C19.close();
		    try {
			CommonUtils.closeCursor(rs_C19);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    // if(rs_C20!=null)
		    // {
		    // rs_C20.close();
		    // }

		    String sql_C20 = SQLQueryInterfacePILP001.sql_C20;
		    Object[] objectsql_C20 = { M_DR_REPORT_CODE };
		    rs_C20 = handler.executeSelectStatement(sql_C20,
			    connection, objectsql_C20);

		    if (rs_C20.next()) {
			M_PC_DESC = rs_C20.getString(1);
			M_PC_BL_DESC = rs_C20.getString(2);
		    }

		    // rs_C20.close();
		    try {
			CommonUtils.closeCursor(rs_C20);
		    } catch (Exception e) {
			e.printStackTrace();
		    }

		    // if(rs_C21!=null)
		    // {
		    // rs_C21.close();
		    // }

		    String sql_C21 = SQLQueryInterfacePILP001.sql_C21;
		    Object[] objectsql_C21 = { M_POL_CONT_CODE };
		    rs_C21 = handler.executeSelectStatement(sql_C21,
			    connection, objectsql_C21);

		    if (rs_C21.next()) {
			M_CONT_PREFERRED_LANG = rs_C21.getString(1);
		    }
		    // rs_C21.close();
		    try {
			CommonUtils.closeCursor(rs_C21);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    if ("E".equals(MigratingFunctions.nvl(
			    M_CONT_PREFERRED_LANG, "E"))) {
			M_REP_NAME = M_PC_DESC;
		    } else {
			M_REP_NAME = M_PC_BL_DESC;
		    }

		    String sql_insert11 = SQLQueryInterfacePILP001.sql_insert11;
		    Object[] objectsql_insert11 = { M_POL_DS_TYPE,
			    DUMMY_BEAN.getM_POL_SYS_ID(), M_POL_END_NO_IDX,
			    DUMMY_BEAN.getUI_M_PS_REASON_CODE(), M_REP_NAME,
			    controlBean.getM_USER_ID() };
		    insert11 = handler.executeInsertStatement(sql_insert11,
			    connection, objectsql_insert11);

		    //ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
		    
		    if (("1".equals(M_CALC_METHOD) || "2".equals(M_CALC_METHOD)) 
			    && "O".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())) {
			if ("M".equals(M_POL_PLAN_TYPE)) {
			    if ("N01".equals(DUMMY_BEAN
				    .getUI_M_PS_REASON_CODE())) {
				// P_NOT_TAKEN_UP_MEDICAL.P_NOT_TAKEN_UP_MEDICAL(M_REP_NAME,"B");
			    } else if ("N02".equals(DUMMY_BEAN
				    .getUI_M_PS_REASON_CODE())) {
				// P_NOT_TAKEN_UP_DOC.P_NOT_TAKEN_UP_DOC(M_REP_NAME,"B");
			    } else if ("N03".equals(DUMMY_BEAN
				    .getUI_M_PS_REASON_CODE())) {
				// P_NOT_TAKEN_UP_UW.P_NOT_TAKEN_UP_UW(M_REP_NAME,"B");
			    }
			} else if (!"M".equals(M_POL_PLAN_TYPE)) {

			    if ("N01".equals(DUMMY_BEAN
				    .getUI_M_PS_REASON_CODE())) {

				ArrayList<String> list = pilp001dbProcedures
					.callP9ILPK_UW_LETTERS_GEN_JE_NTU_SHORT_PAYMENT(
						M_REP_NAME, CommonUtils.getProcedureValue(DUMMY_BEAN.getM_POL_SYS_ID()));
				if (list != null && list.size() > 0) {
				    M_DSRC_SYS_ID = Double.parseDouble(list
					    .get(0));
				}
				// p9ilpk_uw_letters.p9ilpk_uw_letters.gen_je_ntu_short_payment(M_DSRC_SYS_ID,M_REP_NAME,DUMMY_BEAN.getM_POL_SYS_ID());
				// P_LIFE_LETTER.P_LIFE_LETTER(M_DSRC_SYS_ID,M_REP_NAME,"B","UW");
			    } else if ("N02".equals(DUMMY_BEAN
				    .getUI_M_PS_REASON_CODE())) {
				ArrayList<String> list = pilp001dbProcedures
					.callP9ILPK_UW_LETTERS_GEN_JE_NTU_PENDING_REQUIREMENT(
						M_REP_NAME,
						CommonUtils.getProcedureValue(DUMMY_BEAN.getM_POL_SYS_ID()));
				if (list != null && list.size() > 0) {
				    M_DSRC_SYS_ID = Double.parseDouble(list
					    .get(0));
				}
				// p9ilpk_uw_letters.p9ilpk_uw_letters.gen_je_ntu_pending_requirement(M_DSRC_SYS_ID,M_REP_NAME,DUMMY_BEAN.getM_POL_SYS_ID());
				// P_LIFE_LETTER.P_LIFE_LETTER(M_DSRC_SYS_ID,M_REP_NAME,"B","UW");
			    } else if ("N03".equals(DUMMY_BEAN
				    .getUI_M_PS_REASON_CODE())) {
				ArrayList<String> list = pilp001dbProcedures
					.callP9ILPK_UW_LETTERS_GEN_JE_NTU_MEDICAL_REQUIREMENT(
						M_REP_NAME, 
						CommonUtils.getProcedureValue(DUMMY_BEAN.getM_POL_SYS_ID()));
				if (list != null && list.size() > 0) {
				    M_DSRC_SYS_ID = Double.parseDouble(list
					    .get(0));
				}

				/*
				 * p9ilpk_uw_letters.p9ilpk_uw_letters.gen_je_ntu_medical_requirement(M_DSRC_SYS_ID,M_REP_NAME,DUMMY_BEAN.getM_POL_SYS_ID());
				 * P_LIFE_LETTER.P_LIFE_LETTER(M_DSRC_SYS_ID,M_REP_NAME,"B","UW");
				 */
			    } else if ("N04".equals(DUMMY_BEAN
				    .getUI_M_PS_REASON_CODE())) {

				ArrayList<String> list = pilp001dbProcedures
					.callP9ILPK_UW_LETTERS_GEN_JE_NTU_COUNTER_OFFER(
						M_REP_NAME,
						CommonUtils.getProcedureValue(DUMMY_BEAN.getM_POL_SYS_ID()));
				if (list != null && list.size() > 0) {
				    M_DSRC_SYS_ID = Double.parseDouble(list
					    .get(0));
				}

				/*
				 * p9ilpk_uw_letters.p9ilpk_uw_letters.gen_je_ntu_counter_offer(M_DSRC_SYS_ID,M_REP_NAME,DUMMY_BEAN.getM_POL_SYS_ID());
				 * P_LIFE_LETTER.P_LIFE_LETTER(M_DSRC_SYS_ID,M_REP_NAME,"B","UW");
				 */
			    }
			}
		    }
		    if ("P".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())) {
		    	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
		    			Messages.getString(PELConstants.pelMessagePropertiesPath,"91219"));
			/*throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91219"));*/
			// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91219,:CTRL.M_LANG_CODE,DUMMY_BEAN.getUI_M_PROP_NO());
		    } else if ("O".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())) {
		    	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
		    			Messages.getString(PELConstants.pelMessagePropertiesPath,"91220"));
			/*throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91220"));*/
			// STD_MESSAGE_ROUTINE(91220,:CTRL.M_LANG_CODE,DUMMY_BEAN.getUI_M_PROP_NO());
		    } else if ("W".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())) {
		    	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
		    			Messages.getString(PELConstants.pelMessagePropertiesPath,"91221"));
			/*throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91221"));*/
			// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91221,:CTRL.M_LANG_CODE,DUMMY_BEAN.getUI_M_PROP_NO());
		    }
		}
		if ("A".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())) {

		    if (rs_C5.next()) {
			M_TEMP_1 = rs_C5.getString(1);
		    }
		    if (rs_C5.next()) {
			// rs_C5.close();
			try {
			    CommonUtils.closeCursor(rs_C5);
			} catch (Exception e) {
			    e.printStackTrace();
			}
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91104"));
			/*
			 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91104,:CTRL.M_LANG_CODE);
			 * throw new FORM_TRIGGER_FAILURE();
			 */
		    }
		    // rs_C5.close();
		    try {
			CommonUtils.closeCursor(rs_C5);
		    } catch (Exception e) {
			e.printStackTrace();
		    }

		    if (rs_C6.next()) {
			M_FLAG = rs_C6.getString(1);
		    }
		    if (rs_C6.next()) {
			// rs_C6.close();
			try {
			    CommonUtils.closeCursor(rs_C6);
			} catch (Exception e) {
			    e.printStackTrace();
			}
			throw new ValidatorException(Messages.getMessage(
				"com.iii.premia.common.errorUtil.PELErrorMessages",
				"91124"));
			/*
			 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91124,:CTRL.M_LANG_CODE);
			 * throw new FORM_TRIGGER_FAILURE();
			 */
		    }
		    // rs_C6.close();
		    try {
			CommonUtils.closeCursor(rs_C6);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    // if(rs_C4!=null)
		    // {
		    // rs_C4.close();
		    // }

		    String sql_C4 = SQLQueryInterfacePILP001.sql_C4;
		    Object[] objectsql_C4 = { DUMMY_BEAN.getM_POL_SYS_ID() };
		    rs_C4 = handler.executeSelectStatement(sql_C4, connection,
			    objectsql_C4);

		    if (rs_C4.next()) {
			M_TEMP = rs_C4.getString(1);
		    }
		    if (rs_C4.next()) {
			if (rs_C2 != null) {
			    // rs_C2.close();
			    try {
				CommonUtils.closeCursor(rs_C2);
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			}

			String sql_C2 = SQLQueryInterfacePILP001.sql_C2;
			Object[] objectsql_C2 = { DUMMY_BEAN.getM_POL_SYS_ID() };
			rs_C2 = handler.executeSelectStatement(sql_C2,
				connection, objectsql_C2);

			if (rs_C2.next()) {
			    M_SUM = rs_C2.getString(1);
			}
			if (java.lang.Math.abs(MigratingFunctions.nvl(Double
				.parseDouble(M_POL_FC_DEPOSIT_AMOUNT), 0)) != MigratingFunctions
				.nvl(Double.parseDouble(M_SUM), 0)) {
			    try {
				CommonUtils.closeCursor(rs_C2);
				CommonUtils.closeCursor(rs_C4);
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			    // rs_C2.close();
			    // rs_C4.close();
			    throw new ValidatorException(Messages.getMessage(
				    "com.iii.premia.common.errorUtil.PELErrorMessages",
				    "91043"));
			    /*
			     * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91043,:CTRL.M_LANG_CODE);
			     * throw new FORM_TRIGGER_FAILURE();
			     */
			}
			// rs_C2.close();
			try {
			    CommonUtils.closeCursor(rs_C2);
			} catch (Exception e) {
			    e.printStackTrace();
			}
		    }
		    // rs_C4.close();
		    try {
			CommonUtils.closeCursor(rs_C4);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		    
		    //COMMNETD BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
		    
		   /* if ("2".equals(M_CALC_METHOD)) {
			if (Double.parseDouble(M_POL_FC_DEPOSIT_AMOUNT) > 0) {
			    pilp001dbProcedures
				    .callP9ILPK_POLICY_PROP_APPROVAL(
					    CommonUtils.getProcedureValue(DUMMY_BEAN.getM_POL_SYS_ID()),
					    M_POL_FC_FIRST_PREM,
					    M_POL_LC_FIRST_PREM,
					    M_POL_LC_DEPOSIT_AMOUNT,
					    M_POL_FC_DEPOSIT_AMOUNT, DUMMY_BEAN
						    .getUI_M_APPRV_DATE()
						    .toString());

			    // p9ilpk_policy.p9ilpk_policy.prop_approval(DUMMY_BEAN.getM_POL_SYS_ID(),M_POL_FC_FIRST_PREM,M_POL_LC_FIRST_PREM,M_POL_LC_DEPOSIT_AMOUNT,M_POL_FC_DEPOSIT_AMOUNT,DUMMY_BEAN.getUI_M_APPRV_DATE());
			}
			if (MigratingFunctions.nvl(Double
				.parseDouble(M_POL_FC_DEPOSIT_AMOUNT), 0) == 0) {
			    if (rs_C3 != null) {
				// rs_C3.close();
				try {
				    CommonUtils.closeCursor(rs_C3);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			    }

			    if (rs_C3.next()) {
				M_CONT_LC_PROP_DEP_AMT = rs_C3.getDouble(1);
				M_CONT_LC_PROP_UTIL_AMT = rs_C3.getDouble(2);
				M_CONT_LC_POL_DEP_AMT = rs_C3.getString(3);
				M_CONT_LC_POL_UTIL_AMT = rs_C3.getString(4);
			    }
			    // rs_C3.close();
			    try {
				CommonUtils.closeCursor(rs_C3);
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			    if (M_CONT_LC_PROP_DEP_AMT >= Double
				    .parseDouble(M_POL_LC_FIRST_PREM)) {
			    } else {
				if (Double.parseDouble(M_CONT_LC_POL_DEP_AMT) > Double
					.parseDouble(M_CONT_LC_POL_UTIL_AMT)) {
				    M_LC_JOURNAL_AMT_1 = M_POL_LC_FIRST_PREM;
				    M_LC_JOURNAL_AMT_2 = Double
					    .parseDouble(M_CONT_LC_POL_DEP_AMT)
					    - Double
						    .parseDouble(M_CONT_LC_POL_UTIL_AMT);
				    if (Double.parseDouble(M_LC_JOURNAL_AMT_1) < M_LC_JOURNAL_AMT_2) {
					M_LC_JOURNAL_AMT = Double
						.parseDouble(M_LC_JOURNAL_AMT_1);
				    } else {
					M_LC_JOURNAL_AMT = M_LC_JOURNAL_AMT_2;
				    }
				    DBProcedures dbProcedures = new DBProcedures();
				    dbProcedures.callP_VAL_ROUND_AMT(DUMMY_BEAN
					    .getM_BASE_CURR_CODE(),
					    M_LC_JOURNAL_AMT + "", "R");

				    // P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(:DUMMY1.M_BASE_CURR_CODE,M_LC_JOURNAL_AMT,"R");
				    M_FC_JOURNAL_AMT = M_LC_JOURNAL_AMT
					    / Double
						    .parseDouble(M_POL_EXCHANGE_RATE);

				    dbProcedures.callP_VAL_ROUND_AMT(
					    M_POL_CUST_CURR_CODE,
					    M_FC_JOURNAL_AMT + "", "R");
				    // P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(M_POL_CUST_CURR_CODE,M_FC_JOURNAL_AMT,"R");
				    pilp001dbProcedures
					    .callP9ILPK_POLICY_PASS_JOURNAL(
						    CommonUtils.getProcedureValue( DUMMY_BEAN.getM_POL_SYS_ID()),
						    M_LC_JOURNAL_AMT + "",
						    M_FC_JOURNAL_AMT + "",
						    DUMMY_BEAN
							    .getUI_M_APPRV_DATE()
							    .toString());

				    // p9ilpk_policy.p9ilpk_policy.pass_journal(DUMMY_BEAN.getM_POL_SYS_ID(),M_LC_JOURNAL_AMT,M_FC_JOURNAL_AMT,DUMMY_BEAN.getUI_M_APPRV_DATE());
				}
			    }
			}
		    }*/
		    if ("Y".equals(DUMMY_BEAN.getUI_M_PROP_CONVERT())) {
		    	
		   //ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK 	
		    	
			if ("1".equals(M_CALC_METHOD) || "2".equals(M_CALC_METHOD)) {
			    if (rs_C11 != null) {
				// rs_C11.close();
				try {
				    CommonUtils.closeCursor(rs_C11);
				} catch (Exception e) {
				    e.printStackTrace();
				}
			    }

			    String sql_C11 = SQLQueryInterfacePILP001.sql_C11;
			    Object[] objectsql_C11 = { 
				    CommonUtils.getProcedureValue(DUMMY_BEAN.getM_POL_SYS_ID()) };
			    rs_C11 = handler.executeSelectStatement(sql_C11,
				    connection, objectsql_C11);

			    if (rs_C11.next()) {
				M_PROD_AUTO_APPROV = rs_C11.getString(1);
				M_PROD_CBC_YN = rs_C11.getString(2);
				M_PROD_PREM_CALC_MTHD = rs_C11.getString(3);
				M_PROD_AGENT_HIRE_YN = rs_C11.getString(4);
			    }
			    // rs_C11.close();
			    try {
				CommonUtils.closeCursor(rs_C11);
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			    if (MigratingFunctions.nvl(M_PROD_CBC_YN, "N")
				    .equals("Y")) {
				ArrayList<String> list = pilp001dbProcedures
					.callP_VAL_SYSTEM("IL_TOLL_TYPE",
						"IL_TOLL_TYPE", "N");
				if (list != null && list.size() > 0) {
				    M_PS_CODE_DESC = list.get(0);
				    M_PS_VALUE = list.get(1);
				}

				// P_VAL_SYSTEM.P_VAL_SYSTEM("IL_TOLL_TYPE","IL_TOLL_TYPE",M_PS_CODE_DESC,"N",M_PS_VALUE);
				// if(rs_C15!=null)
				// {
				// rs_C15.close();
				// }

				String sql_C15 = SQLQueryInterfacePILP001.sql_C15;
				Object[] objectsql_C15 = { DUMMY_BEAN
					.getM_POL_SYS_ID() };
				rs_C15 = handler.executeSelectStatement(
					sql_C15, connection, objectsql_C15);

				if (rs_C15.next()) {
				    M_POL_MODE_OF_PYMT = rs_C15.getString(1);
				}
				// rs_C15.close();
				try {
				    CommonUtils.closeCursor(rs_C15);
				} catch (Exception e) {
				    e.printStackTrace();
				}

				ArrayList<String> list1 = pilp001dbProcedures
					.callP_VAL_SYSTEM("IL_SHORT_COL",
						M_POL_MODE_OF_PYMT, "N");
				if (list1 != null && list1.size() > 0) {
				    M_CODE_DESC = list1.get(0);
				    M_VALUE = list1.get(1);
				}

				// P_VAL_SYSTEM.P_VAL_SYSTEM("IL_SHORT_COL",M_POL_MODE_OF_PYMT,M_CODE_DESC,"N",M_VALUE);
				if (MigratingFunctions
					.nvl(M_POL_PLAN_TYPE, "0").equals("M")
					&& MigratingFunctions.nvl(
						M_PROD_PREM_CALC_MTHD, "T")
						.equals("X")) {
				    // L_GET_FIRST_PREMReturns Returns =
				    // L_GET_FIRST_PREM.L_GET_FIRST_PREM(DUMMY_BEAN.getM_POL_SYS_ID(),M_DEP_GROSS_NET_FLAG);
				} else if (((MigratingFunctions.nvl(
					M_POL_PLAN_TYPE, "0").equals("M") && MigratingFunctions
					.nvl(M_PROD_PREM_CALC_MTHD, "T")
					.equals("T")) || !MigratingFunctions
					.nvl(M_POL_PLAN_TYPE, "0").equals("M"))
					&& "1".equals(M_POL_PREM_PAY_YRS)
					&& "N".equals(M_PROD_AGENT_HIRE_YN)) {
				    ArrayList<String> list2 = pilp001dbProcedures
					    .callP9ILPK_POLICY_P_GET_FIRST_PREM(
						    CommonUtils.getProcedureValue(DUMMY_BEAN.getM_POL_SYS_ID()),
						    M_DEP_GROSS_NET_FLAG);
				    if (list2 != null && list2.size() > 0) {
					M_FC_FIRST_PREM = Double
						.parseDouble(list2.get(0));
					M_LC_FIRST_PREM = Double
						.parseDouble(list2.get(1));

				    }

				    ArrayList<String> list3 = pilp001dbProcedures
					    .callP9ILPK_POLICY_P_GET_FIRST_PREM(
						    CommonUtils.getProcedureValue(    DUMMY_BEAN.getM_POL_SYS_ID()),
						    M_DEP_GROSS_NET_FLAG);
				    if (list3 != null && list3.size() > 0) {
					M_FC_FIRST_PREM = Double
						.parseDouble(list3.get(0));
					M_LC_FIRST_PREM = Double
						.parseDouble(list3.get(1));
				    }

				    // p9ilpk_policy.p9ilpk_policy.p_get_first_prem(DUMMY_BEAN.getM_POL_SYS_ID(),M_DEP_GROSS_NET_FLAG,M_FC_FIRST_PREM,M_LC_FIRST_PREM);
				} else {
				    M_FC_FIRST_PREM = MigratingFunctions
					    .nvl(
						    Double
							    .parseDouble(M_POL_FC_FIRST_PREM),
						    0);
				    M_LC_FIRST_PREM = MigratingFunctions
					    .nvl(
						    Double
							    .parseDouble(M_POL_LC_FIRST_PREM),
						    0);
				}
				if ("1".equals(M_PS_VALUE)) {
				    M_SHORT_COLL_VALUE = (MigratingFunctions
					    .nvl(
						    Double
							    .parseDouble(M_POL_LC_FIRST_PREM),
						    0) * MigratingFunctions
					    .nvl(Double.parseDouble(M_VALUE), 0)) / 100;
				} else {
				    M_SHORT_COLL_VALUE = MigratingFunctions
					    .nvl(Double.parseDouble(M_VALUE), 0);
				}
				if (rs_C26 != null) {
				    // rs_C26.close();
				    try {
					CommonUtils.closeCursor(rs_C26);
				    } catch (Exception e) {
					e.printStackTrace();
				    }
				}

				String sql_C26 = SQLQueryInterfacePILP001.sql_C26;
				Object[] objectsql_C26 = { M_POL_PLAN_CODE,
					M_POL_MODE_OF_PYMT };
				rs_C26 = handler.executeSelectStatement(
					sql_C26, connection, objectsql_C26);

				if (rs_C26.next()) {
				    M_PMOP_SHORT_RATE = rs_C26.getDouble(1);
				    M_PMOP_SHORT_RATE_PER = rs_C26.getDouble(2);
				    M_PMOP_TOLL_TYP = rs_C26.getString(3);
				}
				// rs_C26.close();
				try {
				    CommonUtils.closeCursor(rs_C26);
				} catch (Exception e) {
				    e.printStackTrace();
				}
				if (("" + "P").equals(M_PMOP_TOLL_TYP)) {
				    M_SHORT_COLL_VALUE = (MigratingFunctions
					    .nvl(
						    Double
							    .parseDouble(M_POL_LC_FIRST_PREM),
						    0) * (MigratingFunctions
					    .nvl(M_PMOP_SHORT_RATE, 0) / MigratingFunctions
					    .nvl(M_PMOP_SHORT_RATE_PER, 0)));
				} else {
				    M_SHORT_COLL_VALUE = MigratingFunctions
					    .nvl(M_PMOP_SHORT_RATE, 0);
				}
				// if(rs_C12!=null)
				// {
				// rs_C12.close();
				// }

				String sql_C12 = SQLQueryInterfacePILP001.sql_C12;
				Object[] objectsql_C12 = { DUMMY_BEAN
					.getM_POL_SYS_ID() };
				rs_C12 = handler.executeSelectStatement(
					sql_C12, connection, objectsql_C12);

				if (rs_C12.next()) {
				    M_CONT_LC_PROP_DEP_AMT = rs_C12
					    .getDouble(1);
				}
				// rs_C12.close();
				try {
				    CommonUtils.closeCursor(rs_C12);
				} catch (Exception e) {
				    e.printStackTrace();
				}
				if (MigratingFunctions.nvl(
					M_CONT_LC_PROP_DEP_AMT, 0) >= MigratingFunctions
					.nvl(M_LC_FIRST_PREM, 0)) {
				    M_CAN_CONVERT_FLAG = "Y";
				    // String sql_vembu12="UPDATE PT_IL_POLICY
				    // SET POL_STATUS = 'A', POL_APPRV_STATUS =
				    // 'A', POL_APPRV_DT = :DUMMY.M_APPRV_DATE,
				    // POL_ADDL_STATUS =
				    // DECODE("+M_CALC_METHOD+", 1, 'C01',
				    // NULL), POL_TRAN_DT = TO_DATE(SYSDATE),
				    // POL_APPRV_UID = :CTRL.M_USER_ID WHERE
				    // POL_SYS_ID = :DUMMY.M_POL_SYS_ID ";

				    String sql_vembu12 = SQLQueryInterfacePILP001.sql_vembu12;
				    Object[] objectsql_vembu12 = {
					    DUMMY_BEAN.getUI_M_APPRV_DATE(),
					    M_CALC_METHOD,
					    controlBean.getM_USER_ID(),
					    DUMMY_BEAN.getM_POL_SYS_ID() };
				    vembu12 = handler.executeUpdateStatement(
					    sql_vembu12, connection,
					    objectsql_vembu12);

				    String sql_vembu13 = SQLQueryInterfacePILP001.sql_vembu13;
				    Object[] objectsql_vembu13 = {
					    DUMMY_BEAN.getM_POL_SYS_ID(),
					    M_POL_END_NO_IDX,
					    DUMMY_BEAN.getUI_M_APPRV_DATE(),
					    DUMMY_BEAN.getUI_M_PS_REASON_CODE(),
					    DUMMY_BEAN.getUI_M_PS_REMARKS(),
					    session.get("GLOBAL.M_USER_ID"),
					    session.get("GLOBAL.M_USER_ID") };
				    vembu13 = handler.executeInsertStatement(
					    sql_vembu13, connection,
					    objectsql_vembu13);
				} else {
				    if (MigratingFunctions.nvl(
					    M_CONT_LC_PROP_DEP_AMT, 0)
					    + MigratingFunctions.nvl(
						    M_SHORT_COLL_VALUE, 0) >= MigratingFunctions
					    .nvl(M_LC_FIRST_PREM, 0)) {
					M_CAN_CONVERT_FLAG = "Y";

					String sql_vembu14 = SQLQueryInterfacePILP001.sql_vembu14;
					Object[] objectsql_vembu14 = {
						DUMMY_BEAN.getUI_M_APPRV_DATE(),
						M_CALC_METHOD,
						controlBean.getM_USER_ID(),
						DUMMY_BEAN.getM_POL_SYS_ID() };
					vembu14 = handler
						.executeUpdateStatement(
							sql_vembu14,
							connection,
							objectsql_vembu14);

					String sql_vembu15 = SQLQueryInterfacePILP001.sql_vembu15;
					Object[] objectsql_vembu15 = {
						DUMMY_BEAN.getM_POL_SYS_ID(),
						M_POL_END_NO_IDX,
						DUMMY_BEAN.getUI_M_APPRV_DATE(),
						DUMMY_BEAN
							.getUI_M_PS_REASON_CODE(),
						DUMMY_BEAN.getUI_M_PS_REMARKS(),
						session.get("GLOBAL.M_USER_ID"),
						session.get("GLOBAL.M_USER_ID") };
					vembu15 = handler
						.executeInsertStatement(
							sql_vembu15,
							connection,
							objectsql_vembu15);
				    } else {
					M_CAN_CONVERT_FLAG = "N";

					String sql_vembu16 = SQLQueryInterfacePILP001.sql_vembu16;
					Object[] objectsql_vembu16 = {
						DUMMY_BEAN.getUI_M_APPRV_DATE(),
						M_CALC_METHOD,
						controlBean.getM_USER_ID(),
						DUMMY_BEAN.getM_POL_SYS_ID() };
					vembu16 = handler
						.executeUpdateStatement(
							sql_vembu16,
							connection,
							objectsql_vembu16);

					String sql_vembu17 = SQLQueryInterfacePILP001.sql_vembu17;
					Object[] objectsql_vembu17 = {
						DUMMY_BEAN.getM_POL_SYS_ID(),
						M_POL_END_NO_IDX,
						DUMMY_BEAN.getUI_M_APPRV_DATE(),
						DUMMY_BEAN
							.getUI_M_PS_REASON_CODE(),
						DUMMY_BEAN.getUI_M_PS_REMARKS(),
						session.get("GLOBAL.M_USER_ID"),
						session.get("GLOBAL.M_USER_ID") };
					vembu17 = handler
						.executeInsertStatement(
							sql_vembu17,
							connection,
							objectsql_vembu17);

					throw new ValidatorException(
						Messages
							.getMessage(
								"com.iii.premia.common.errorUtil.PELErrorMessages",
								"91151"));
					// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91151,:CTRL.M_LANG_CODE);
					/*
					 * if(MigratingFunctions.nvl(M_CONT_LC_PROP_DEP_AMT,0)!=0) {
					 * String sql_vembu18 =
					 * SQLQueryInterfacePILP001.sql_vembu18;
					 * Object[] objectsql_vembu18 =
					 * {DUMMY_BEAN.getUI_M_APPRV_DATE(),M_CALC_METHOD,ctrlBean.getM_USER_ID(),DUMMY_BEAN.getM_POL_SYS_ID()};
					 * vembu18 =
					 * handler.executeUpdateStatement(sql_vembu18,
					 * connection, objectsql_vembu18);
					 * 
					 * String sql_vembu19 =
					 * SQLQueryInterfacePILP001.sql_vembu19;
					 * Object[] objectsql_vembu19 =
					 * {DUMMY_BEAN.getM_POL_SYS_ID(),M_POL_END_NO_IDX,DUMMY_BEAN.getUI_M_APPRV_DATE(),DUMMY_BEAN.getUI_M_PS_REASON_CODE(),DUMMY_BEAN.getUI_M_PS_REMARKS(),session.get("GLOBAL.M_USER_ID"),session.get("GLOBAL.M_USER_ID")};
					 * vembu19 =
					 * handler.executeInsertStatement(sql_vembu19,
					 * connection, objectsql_vembu19); }
					 */
				    }
				}
			    } else {
				M_CAN_CONVERT_FLAG = "Y";

				String sql_vembu20 = SQLQueryInterfacePILP001.sql_vembu20;
				Object[] objectsql_vembu20 = {
					DUMMY_BEAN.getUI_M_APPRV_DATE(),
					M_CALC_METHOD,
					controlBean.getM_USER_ID(),
					DUMMY_BEAN.getM_POL_SYS_ID() };
				vembu20 = handler.executeUpdateStatement(
					sql_vembu20, connection,
					objectsql_vembu20);

				String sql_vembu21 = SQLQueryInterfacePILP001.sql_vembu21;
				Object[] objectsql_vembu21 = {
					DUMMY_BEAN.getM_POL_SYS_ID(),
					M_POL_END_NO_IDX,
					DUMMY_BEAN.getUI_M_APPRV_DATE(),
					DUMMY_BEAN.getUI_M_PS_REASON_CODE(),
					DUMMY_BEAN.getUI_M_PS_REMARKS(),
					session.get("GLOBAL.M_USER_ID"),
					session.get("GLOBAL.M_USER_ID") };
				vembu21 = handler.executeInsertStatement(
					sql_vembu21, connection,
					objectsql_vembu21);
			    }
			} else {
			    M_CAN_CONVERT_FLAG = "Y";

			    String sql_vembu22 = SQLQueryInterfacePILP001.sql_vembu22;
			    Object[] objectsql_vembu22 = {
				    DUMMY_BEAN.getUI_M_APPRV_DATE(),
				    controlBean.getM_USER_ID(),
				    DUMMY_BEAN.getM_POL_SYS_ID() };
			    vembu22 = handler.executeUpdateStatement(
				    sql_vembu22, connection, objectsql_vembu22);

			}
			if ("Y".equals(M_CAN_CONVERT_FLAG)) {
			    throw new ValidatorException(Messages.getMessage(
				    "com.iii.premia.common.errorUtil.PELErrorMessages",
				    "91118", new Object[] { DUMMY_BEAN
					    .getUI_M_PROP_NO() }));
			    // STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91118,:CTRL.M_LANG_CODE,DUMMY_BEAN.getUI_M_PROP_NO());
			}
		    } else {
			String sql_vembu23 = SQLQueryInterfacePILP001.sql_vembu23;
			Object[] objectsql_vembu23 = {
				DUMMY_BEAN.getUI_M_APPRV_DATE(), M_CALC_METHOD,
				controlBean.getM_USER_ID(),
				DUMMY_BEAN.getM_POL_SYS_ID() };
			vembu23 = handler.executeUpdateStatement(sql_vembu23,
				connection, objectsql_vembu23);

			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
			
			if ("1".equals(M_CALC_METHOD) || "2".equals(M_CALC_METHOD)) {
			    String sql_vembu24 = SQLQueryInterfacePILP001.sql_vembu24;

			    Object[] objectsql_vembu24 = null;
			    objectsql_vembu24 = new Object[7];
			    objectsql_vembu24[0] = DUMMY_BEAN.getM_POL_SYS_ID();
			    objectsql_vembu24[1] = M_POL_END_NO_IDX;
			    objectsql_vembu24[2] = DUMMY_BEAN
				    .getUI_M_APPRV_DATE();
			    objectsql_vembu24[3] = DUMMY_BEAN
				    .getUI_M_PS_REASON_CODE();
			    objectsql_vembu24[4] = DUMMY_BEAN
				    .getUI_M_PS_REMARKS();
			    objectsql_vembu24[5] = CommonUtils
				    .getGlobalVariable("GLOBAL.M_USER_ID");
			    objectsql_vembu24[6] = CommonUtils
				    .getGlobalVariable("GLOBAL.M_USER_ID");

			    vembu24 = handler.executeUpdateStatement(
				    sql_vembu24, connection, objectsql_vembu24);
			}
		    }

		    CommonUtils commonUtils = new CommonUtils();
		    PILT002_APAC_COMPOSITE_ACTION compositeAction = (PILT002_APAC_COMPOSITE_ACTION) commonUtils
			    .getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");

		    Map<String, String> warnMap = compositeAction
			    .getPT_IL_POLICY_ACTION_BEAN().getWarningMap();

		    warnMap.put("current", Messages.getString(
			    "com.iii.premia.common.errorUtil.PELErrorMessages", "71058",
			    new Object[] { DUMMY_BEAN.getUI_M_PROP_NO() }));

		    navigateTo = navigateToPolicy();
		    /*
		     * compositeAction.getPT_IL_POLICY_ACTION_BEAN()
		     * .loadingBaseValues();
		     */
		    // compositeAction.getPT_IL_POLICY_ACTION_BEAN().onLoad(event)
		    /*
		     * PILT002_APAC_DELEGATE delegate = new
		     * PILT002_APAC_DELEGATE();
		     * delegate.fetchPolicyRecords(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		     * 
		     * PILT002_APAC_HELPER helper = new PILT002_APAC_HELPER();
		     * helper.callPOST_QUERY(compositeAction);
		     */

		    // throw new ValidatorException(message);
		    // throw new
		    // ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages",
		    // "71058", new Object[]{DUMMY_BEAN.getUI_M_PROP_NO()}));
		    // STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71058,:CTRL.M_LANG_CODE,DUMMY_BEAN.getUI_M_PROP_NO());
		}
		if ("Y".equals(M_CAN_CONVERT_FLAG)) {
		    ArrayList<String> list = pilp001dbProcedures
			    .callP9ILPK_POLICY_TRNS_PROP_POL(
				    CommonUtils.getProcedureValue( DUMMY_BEAN.getM_POL_SYS_ID()),
				    DUMMY_BEAN.getUI_M_POLICY_NO(), DUMMY_BEAN
				    .getUI_M_POLICY_NO(), "0");
		    if (list != null && list.size() > 0) {
			M_NEW_POL_SYS_ID = list.get(0);
		    }
		    // p9ilpk_policy.p9ilpk_policy.trns_prop_pol(:DUMMY.M_POL_SYS_ID,:DUMMY.M_POLICY_NO,DUMMY_BEAN.getUI_M_POLICY_NO(),0,M_NEW_POL_SYS_ID);
		    if (DUMMY_BEAN.getUI_M_POLICY_NO() == null) {
			L_GENERATE_POLICY_NUMBER();

			String sql_vembu25 = SQLQueryInterfacePILP001.sql_vembu25;
			Object[] objectsql_vembu25 = {
				DUMMY_BEAN.getUI_M_POLICY_NO(),
				M_NEW_POL_SYS_ID };
			vembu25 = handler.executeUpdateStatement(sql_vembu25,
				connection, objectsql_vembu25);

			DUMMY_BEAN.setM_FLAG("N");
		    }
		}
		pilp001dbProcedures
			.callP9ILPK_MEDICAL_FEES_INS_MEDEX_FEE_DTL(M_NEW_POL_SYS_ID);
		// p9ilpk_medical_fees.p9ilpk_medical_fees.ins_medex_fee_dtl(M_NEW_POL_SYS_ID);
		controlBean.setM_COMM_DEL("C");

		connection.commit();
		controlBean.setM_COMM_DEL(null);
		
		//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK
		
		if ("1".equals(M_CALC_METHOD) || "2".equals(M_CALC_METHOD)) {
		    // L_PRINT_LETTER.L_PRINT_LETTER();
		}
		controlBean.setM_COMM_DEL("C");
		if (!connection.getAutoCommit())
		    connection.commit();
		if ("O".equals(M_DS_POST_BO)) {
		    if ("N".equals(M_CAN_CONVERT_FLAG)) {
			
			CommonUtils.setGlobalVariable("GLOBAL.M_PROP_SYS_ID",DUMMY_BEAN.getM_POL_SYS_ID().toString());
			CommonUtils.setGlobalVariable("GLOBAL.M_CLM_SYS_ID",
				"0");
			// session.put("GLOBAL.M_PROP_SYS_ID",
			// DUMMY_BEAN.getM_POL_SYS_ID());
			// session.put("GLOBAL.M_CLM_SYS_ID", 0);

			/*
			 * :GLOBAL.M_PROP_SYS_ID=DUMMY_BEAN.getM_POL_SYS_ID();
			 * :GLOBAL.M_CLM_SYS_ID=0;
			 */
			/*
			 * SYNCHRONIZE.SYNCHRONIZE();
			 * CALL_FORM.CALL_FORM("PILP010",NO_HIDE,NO_REPLACE);
			 */
		    }
		}
		if ("Y".equals(M_CAN_CONVERT_FLAG)) {
		    if ("Y".equals(M_PROD_AUTO_APPROV)) {
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",
				DUMMY_BEAN.getUI_M_POLICY_NO());
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
				M_NEW_POL_SYS_ID);

			// session.put("GLOBAL.M_POL_NO",
			// DUMMY_BEAN.getUI_M_POLICY_NO());
			// session.put("GLOBAL.M_POL_SYS_ID", M_NEW_POL_SYS_ID);

			/*
			 * :GLOBAL.M_POL_NO=DUMMY_BEAN.getUI_M_POLICY_NO();
			 * :GLOBAL.M_POL_SYS_ID=M_NEW_POL_SYS_ID;
			 */
			pilp001dbProcedures
				.callP9ILPK_AUTO_APPROVAL_UPD_PT_IL_DOC_TODO_LIST_STATUS(M_NEW_POL_SYS_ID);

			// p9ilpk_auto_approval.p9ilpk_auto_approval.upd_pt_il_doc_todo_list_status(M_NEW_POL_SYS_ID);
			// CALL_FORM.CALL_FORM("PILP001_APAC",NO_HIDE,NO_REPLACE);

			navigateTo = navigateToPolicyApproval();

		    }
		}
		controlBean.setM_COMM_DEL("C");
		// :CTRL.M_COMM_DEL="C";

		connection.commit();
		controlBean.setM_COMM_DEL(null);
		if (DUMMY_BEAN.getUI_M_PROP_NO() != null) {
		    // L_RESTORE_DEFAULT.L_RESTORE_DEFAULT();
		    if (DUMMY_BEAN.getM_GEN_POL_NO() != null) {/*
								 * throw new
								 * ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages",
								 * "71058"));
								 * throw new
								 * ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages",
								 * "71111"));
								 * 
								 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71058,:CTRL.M_LANG_CODE,DUMMY_BEAN.getUI_M_PROP_NO());
								 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71111,:CTRL.M_LANG_CODE,DUMMY_BEAN.getM_GEN_POL_NO());
								 * if(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM)=="PILP001_APAC") {
								 * EXIT_FORM.EXIT_FORM(NO_VALIDATE); }
								 * else {
								 * GO_ITEM.GO_ITEM("DUMMY_BEAN.getUI_M_POLICY_NO()");
								 * CLEAR_BLOCK.CLEAR_BLOCK(); }
								 */
		    }
		}
		/*
		 * if(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM) ==
		 * ("PILP001_APAC") ||
		 * GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM) ==
		 * ("PILP001_APAC") ||
		 * GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM) ==
		 * ("PILP001_APAC")) { EXIT_FORM.EXIT_FORM(NO_VALIDATE); }
		 */
	    }

	}
	/*
	 * catch(SQLException se){ se.printStackTrace();
	 * 
	 * getErrorMap().put("current", se.getMessage());
	 * getErrorMap().put("detail", se.getMessage()); }
	 */
	catch (Exception e) {
	    e.printStackTrace();
	    // ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),
	    // FacesContext.getCurrentInstance(), "", getWarningMap());
	    getErrorMap().put("current", e.getMessage());
	    getErrorMap().put("detail", e.getMessage());
	} finally {

	    try {
		CommonUtils.closeCursor(rs_C1);
		CommonUtils.closeCursor(rs_C2);
		CommonUtils.closeCursor(rs_C3);
		CommonUtils.closeCursor(rs_C4);
		CommonUtils.closeCursor(rs_C5);
		CommonUtils.closeCursor(rs_C6);
		CommonUtils.closeCursor(rs_C7);
		CommonUtils.closeCursor(rs_C8);
		CommonUtils.closeCursor(rs_C9);
		CommonUtils.closeCursor(rs_C10);
		CommonUtils.closeCursor(rs_C11);
		CommonUtils.closeCursor(rs_C12);
		CommonUtils.closeCursor(rs_C13);
		CommonUtils.closeCursor(rs_C14);
		CommonUtils.closeCursor(rs_C15);
		CommonUtils.closeCursor(rs_C16);
		CommonUtils.closeCursor(rs_C17);
		CommonUtils.closeCursor(rs_C18);
		CommonUtils.closeCursor(rs_C19);
		CommonUtils.closeCursor(rs_C20);
		CommonUtils.closeCursor(rs_C21);
		CommonUtils.closeCursor(rs_C22);
		CommonUtils.closeCursor(rs_C23);
		CommonUtils.closeCursor(rs_C24);
		CommonUtils.closeCursor(rs_C25);
		CommonUtils.closeCursor(rs_C26);
		CommonUtils.closeCursor(rs_C27);

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

	return navigateTo;
    }
    
    
    public String okButtonAction() throws Exception {
	PILPK_POLICY_APPROVAL pilpk_policy_approval = new PILPK_POLICY_APPROVAL();
	//ArrayList<OracleParameter> list = null;
	//PILT002_APAC_COMPOSITE_ACTION compositeAction = new  PILT002_APAC_COMPOSITE_ACTION(); 
	List<OracleParameter> list=new ArrayList<OracleParameter>();
	CommonUtils.clearMaps(this);
	String P_CUST_TYPE="";
	String P_CALL_FORM_OUT = null;
	String message = null;
	ResultSet agentStatusRS=null;
	ResultSet cust_statusRS=null;
	try {
		
		/*Newly Added By Dhinesh on 02.4.2017*/ 
		String updateQuery = "UPDATE PT_IL_POLICY SET POL_APPRV_STATUS = ? WHERE POL_NO = ? ";
		/*End*/
		
		//Added by Ameen for Agent termination scenario on 30-08-2016
		
		System.out.println("Pol_Sys_id"+CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString());
		String BROKER_CODE_Query="SELECT POBH_BROKER_CODE FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID=?";
		agentStatusRS=new CRUDHandler().executeSelectStatement(BROKER_CODE_Query, CommonUtils.getConnection(),new Object[]{
			CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString()});
		String POBH_BROKER_CODE=null;
		while(agentStatusRS.next()){
			POBH_BROKER_CODE=agentStatusRS.getString("POBH_BROKER_CODE");
		}
		System.out.println("POBH_BROKER_CODE     :   "+POBH_BROKER_CODE);
		
		String CUST_STATUS_Query="SELECT CUST_STATUS FROM PM_CUSTOMER WHERE CUST_CODE=?";
		cust_statusRS=new CRUDHandler().executeSelectStatement(CUST_STATUS_Query, CommonUtils.getConnection(),new Object[]{
			POBH_BROKER_CODE});
		String CUST_STATUS=null;
		while(cust_statusRS.next()){
			CUST_STATUS=cust_statusRS.getString("CUST_STATUS");
		}
		System.out.println("CUST_STATUS     :   "+CUST_STATUS);
		
		if(POBH_BROKER_CODE!=null)
		{
			if((CUST_STATUS!=null)&& CUST_STATUS.equalsIgnoreCase("T"))
			{
				throw new Exception("Agent has been terminated, kindly check and proceed");
			}
		}

		///end agent termination scenario		
		
		//added for email trigger
		if(getMAIL_SEND_TO().equalsIgnoreCase("CUSTOMER")){
			P_CUST_TYPE="C";
    	}else if(getMAIL_SEND_TO().equalsIgnoreCase("BROKER")){
    		P_CUST_TYPE="A";
    	}else if(getMAIL_SEND_TO().equalsIgnoreCase("BOTH")){
    		P_CUST_TYPE="B";;
    	}
 
		CommonUtils commonUtils = new CommonUtils();
		PILT002_APAC_COMPOSITE_ACTION compositeActionsa = (PILT002_APAC_COMPOSITE_ACTION) commonUtils
			    .getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
		String pro=compositeActionsa.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE();
			
		
		
		
		/*Commented by Dhinesh on 03/04/2017
		 * 
		 * if("N".equals(DUMMY_BEAN.getUI_M_PROP_CONVERT())){
			message = "Proposal Approved Successfully";
		}else if("Y".equals(DUMMY_BEAN.getUI_M_PROP_CONVERT())){
			message = "Proposal "+DUMMY_BEAN.getUI_M_PROP_NO()+" approved and  Converted to Policy!";
		}*/
	    list = pilpk_policy_approval.PR_PILP001_APAC( DUMMY_BEAN.getM_POL_SYS_ID(),
		    DUMMY_BEAN.getUI_M_APPRV_DATE() , 
		    DUMMY_BEAN.getUI_M_PROP_NO()  , 
		    DUMMY_BEAN.getUI_M_MED_FEE_RECOVER_YN() ,
		    DUMMY_BEAN.getUI_M_PROP_STATUS()  ,
		    DUMMY_BEAN.getUI_M_DEPPREM_REFUND_YN()  ,
		    DUMMY_BEAN.getUI_M_PS_REASON_CODE()  , 
		    DUMMY_BEAN.getUI_M_PS_REMARKS()  , 
		    DUMMY_BEAN.getUI_M_PROP_CONVERT() ,
		    DUMMY_BEAN.getUI_M_POLICY_NO() , 
		    DUMMY_BEAN.getUI_M_POL_NO()/* P_POL_NO*/, 
		    DUMMY_BEAN.getM_GEN_POL_NO(),
		    DUMMY_BEAN.getROWID(), 
		    null,
		    null, 
		    null, 
		    null,
		    null, 
		    null,
		    null,  
		    null,
		    null,
		    null,
		    P_CALL_FORM_OUT);
	    if (list != null && !list.isEmpty()) {
	    	compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_POLICY_NO((String)list.get(0).getValueObject());
	    	compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_PRINT_TYPE((String)list.get(1).getValueObject());
	    	compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_FLAG((String)list.get(2).getValueObject());
	    	//compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_POLICY_NO((String)list.get(3).getValueObject());
	    	compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_PROP_SYS_ID((Long) list.get(4).getValueObject());
	    	compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLM_SYS_ID((Long)list.get(5).getValueObject());
	    	compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_POL_SYS_ID((Long)list.get(6).getValueObject());
	    	compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_DOCUMENT((String)list.get(7).getValueObject());
	    	compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_REP_NAME((String)list.get(8).getValueObject());
	    	compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_ERR_IDX((String)list.get(9).getValueObject());
	    	compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_STATUS((String)list.get(10).getValueObject());	    	
			P_CALL_FORM_OUT = (String)list.get(11).getValueObject(); 
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_POLICY_NO().resetValue();
		}
	    
	    /*Added by Dhinesh on 03/04/2017 for Mail triggering after approval of Policy*/
	    String selectedValue = DUMMY_BEAN.getUI_M_PROP_STATUS();
	    String outputString="";

	    for(int i=0;i<UI_M_PROCESS_TYPE_LIST.size();i++){

	    	if(selectedValue.equals(UI_M_PROCESS_TYPE_LIST.get(i).getValue()))
	    	{
	    		outputString = UI_M_PROCESS_TYPE_LIST.get(i).getLabel().toString();
	    	}

	    }
	    
	    
	    if("N".equals(DUMMY_BEAN.getUI_M_PROP_CONVERT())){
			message = "Proposal "+outputString +" Successfully";
		}else if("Y".equals(DUMMY_BEAN.getUI_M_PROP_CONVERT())){
			message = "Proposal "+DUMMY_BEAN.getUI_M_PROP_NO()+" "+outputString +"and  Converted to Policy!";
		}
	       /*End*/
	    
	    //FALCONQC-1716214 added for mail trigger calling procedure to insert row in a scheduler table for mail
	    String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(pro,"PRO",CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString(),P_CUST_TYPE,"");
	    message = message + emailStatusMessage;
	    
	    
	    /*Added by Dhinesh on 2/3/2016. Code for set PolicyNo in CommonUtils variable(Start)*/
	    CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",
				DUMMY_BEAN.getUI_M_POLICY_NO());
	    System.out.println("UI_M_POLICY_NO          : "+DUMMY_BEAN.getUI_M_POLICY_NO());
		System.out.println("UI_M_POL_NO             : "+DUMMY_BEAN.getUI_M_POL_NO());
		/*Added by Dhinesh on 2/3/2016. Code for set PolicyNo in CommonUtils variable(End)*/
		
		/*Newly Added By Dhinesh on 02.4.2017*/ 
		 if("I".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PROP_STATUS())){
		    	handler.executeUpdateStatement(updateQuery, connection,
		    			new Object[]{"I",DUMMY_BEAN.getUI_M_PROP_NO()}); 
		    	CommonUtils.getConnection().commit();
		    }
		    else if("W".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PROP_STATUS())){
		    	handler.executeUpdateStatement(updateQuery, connection,
		    			new Object[]{"W",DUMMY_BEAN.getUI_M_PROP_NO()}); 
		    	CommonUtils.getConnection().commit();
		    }
		    else if("O".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PROP_STATUS())){
		    	handler.executeUpdateStatement(updateQuery, connection,
		    			new Object[]{"O",DUMMY_BEAN.getUI_M_PROP_NO()}); 
		    	CommonUtils.getConnection().commit();
		    }
		/*End*/
		
	    getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				message);
	    getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
	    		message);
	    
	} catch (Exception e) {
	   e.printStackTrace();
	   getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			e.getMessage());
	   getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
		   e.getMessage());
	   
	}
	return P_CALL_FORM_OUT;
    }

    public void L_GENERATE_POLICY_NUMBER() throws ValidatorException, Exception {
	connection = CommonUtils.getConnection();
	handler = new CRUDHandler();

	String M_CHECK_POL_NO = null;
	String M_DIVN_CODE = null;
	String M_CLASS_CODE = null;
	String M_PLAN_CODE = null;
	String M_UW_YEAR = null;
	String M_DS_CODE = null;
	String M_POL_CODE = null;
	String M_PROD_CODE = null;

	ResultSet resultSet_sql_C1 = null;
	ResultSet resultSet_sql_C2 = null;
	ResultSet resultSet_sql_C3 = null;

	try {
	    String sql_C1 = SQLQueryInterfacePILP001.L_GENERATE_POLICY_NUMBER_SQL_C1;
	    Object[] objectsql_C1 = { DUMMY_BEAN.getM_POL_SYS_ID() };
	    resultSet_sql_C1 = handler.executeSelectStatement(sql_C1,
		    connection, objectsql_C1);

	    if (resultSet_sql_C1.next()) {
		M_DIVN_CODE = resultSet_sql_C1.getString(1);
		M_CLASS_CODE = resultSet_sql_C1.getString(2);
		M_PLAN_CODE = resultSet_sql_C1.getString(3);
		M_UW_YEAR = resultSet_sql_C1.getString(4);
		M_DS_CODE = resultSet_sql_C1.getString(5);
		M_PROD_CODE = resultSet_sql_C1.getString(6);
	    }

	    String sql_C2 = SQLQueryInterfacePILP001.L_GENERATE_POLICY_NUMBER_SQL_C2;
	    Object[] objectsql_C2 = { M_DS_CODE };
	    resultSet_sql_C2 = handler.executeSelectStatement(sql_C2,
		    connection, objectsql_C2);

	    if (resultSet_sql_C2.next()) {
		M_POL_CODE = resultSet_sql_C2.getString(1);
	    }

	    if (M_POL_CODE == null) {
		throw new ValidatorException(Messages.getMessage(
			"com.iii.premia.common.errorUtil.PELErrorMessages", "71063"));
	    }

	    String sql_C3 = SQLQueryInterfacePILP001.L_GENERATE_POLICY_NUMBER_SQL_C3;
	    Object[] objectsql_C3 = { DUMMY_BEAN.getUI_M_POLICY_NO() };
	    resultSet_sql_C3 = handler.executeSelectStatement(sql_C3,
		    connection, objectsql_C3);

	    while ((true)) {
		// P_GEN_DOC_NO.P_GEN_DOC_NO("2",M_POL_CODE,M_DIVN_CODE,M_CLASS_CODE,M_PLAN_CODE,M_PROD_CODE,ConvertFunctions.to_char(M_UW_YEAR),"DUMMY.M_POLICY_NO","DUMMY","N");
		if (resultSet_sql_C3.next()) {
		    M_CHECK_POL_NO = resultSet_sql_C3.getString(1);
		}
		if (resultSet_sql_C3.isAfterLast()
			|| resultSet_sql_C3.isBeforeFirst())
		    break;
	    }

	    if (DUMMY_BEAN.getUI_M_POLICY_NO() == null) {
		getCOMP_UI_M_POLICY_NO().setDisabled(false);
		//getCOMP_UI_M_POLICY_NO().setRequired(true);
		getCOMP_UI_M_POLICY_NO().setReadonly(false);
		getCOMP_UI_M_BUT_POLICY_NO().setDisabled(false);
		/*
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_POLICY_NO",ENABLED,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_POLICY_NO",NAVIGABLE,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_POLICY_NO",UPDATE_NULL,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_POLICY_NO",REQUIRED,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_POLICY_NO",UPDATEABLE,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_BUT_POLICY_NO",ENABLED,PROPERTY_TRUE);
		 * HIDE_WINDOW.HIDE_WINDOW("DUMMY");
		 */
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    CommonUtils.closeCursor(resultSet_sql_C1);
	    CommonUtils.closeCursor(resultSet_sql_C2);
	    CommonUtils.closeCursor(resultSet_sql_C3);
	}

    }

    /*
     * public void L_PRINT_LETTER() throws ValidatorException,Exception {
     * connection = getConnection();
     * 
     * handler = new CRUDHandler(); String M_DR_REPORT_CODE=null; String
     * M_PC_DESC=null; String M_PC_BL_DESC=null; String
     * M_CONT_PREFERRED_LANG=null; String M_REP_NAME=null; String
     * M_POL_END_NO_IDX=null; String M_POL_CONT_CODE=null; String
     * M_POL_DS_TYPE=null; String M_POL_DS_CODE=null; String M_PLAN_TYPE=null;
     * String M_DSRC_SYS_ID=null;
     * 
     * ResultSet resultSet_sql_C1 = null; ResultSet resultSet_sql_C2 = null;
     * ResultSet resultSet_sql_C3 = null; ResultSet resultSet_sql_C4 = null;
     * 
     * 
     * if(resultSet_sql_C4!=null) { resultSet_sql_C4.close(); } String sql_C4
     * =SQLQueryInterfacePILP001.L_PRINT_LETTER_SQL_C4; Object[] objectsql_C4 =
     * {DUMMY_BEAN.getM_POL_SYS_ID()}; resultSet_sql_C4 =
     * handler.executeSelectStatement(sql_C4, connection, objectsql_C4);
     * 
     * if(resultSet_sql_C4.next()) { M_PLAN_TYPE=resultSet_sql_C4.getString(1); }
     * resultSet_sql_C4.close();
     * 
     * if(resultSet_sql_C1!=null) { resultSet_sql_C1.close(); }
     * 
     * if(resultSet_sql_C1.next()) {
     * M_POL_DS_TYPE=resultSet_sql_C1.getString(1);
     * M_POL_CONT_CODE=resultSet_sql_C1.getString(2);
     * M_POL_END_NO_IDX=resultSet_sql_C1.getString(3);
     * M_POL_DS_CODE=resultSet_sql_C1.getString(4); } resultSet_sql_C1.close();
     * if(resultSet_sql_C3!=null) { resultSet_sql_C3.close(); } String sql_C3
     * =SQLQueryInterfacePILP001.L_PRINT_LETTER_SQL_C3; Object[] objectsql_C3 =
     * {M_POL_DS_TYPE,M_POL_DS_CODE,DUMMY_BEAN.getUI_M_PROP_STATUS()};
     * resultSet_sql_C3 = handler.executeSelectStatement(sql_C3, connection,
     * objectsql_C3);
     * 
     * if(resultSet_sql_C3.next()) {
     * M_DR_REPORT_CODE=resultSet_sql_C3.getString(1); }
     * if(!resultSet_sql_C3.isLast()) { String
     * sql_C1=SQLQueryInterfacePILP001.L_PRINT_LETTER_SQL_C1; Object[]
     * objectsql_C1 = {DUMMY_BEAN.getM_POL_SYS_ID()}; resultSet_sql_C1 =
     * handler.executeSelectStatement(sql_C1, connection, objectsql_C1);
     * if(resultSet_sql_C1.next()) { M_PC_DESC=resultSet_sql_C1.getString(1);
     * M_PC_BL_DESC=resultSet_sql_C1.getString(2); } resultSet_sql_C1.close();
     * if(resultSet_sql_C2!=null) { resultSet_sql_C2.close(); } String sql_C2
     * =SQLQueryInterfacePILP001.L_PRINT_LETTER_SQL_C2; Object[] objectsql_C2 =
     * {M_POL_CONT_CODE}; resultSet_sql_C2 =
     * handler.executeSelectStatement(sql_C2, connection, objectsql_C2);
     * 
     * if(resultSet_sql_C2.next()) {
     * M_CONT_PREFERRED_LANG=resultSet_sql_C2.getString(1); }
     * resultSet_sql_C2.close();
     * if(MigratingFunctions.nvl(M_CONT_PREFERRED_LANG,"E")=="E") {
     * M_REP_NAME=M_PC_DESC; } else { M_REP_NAME=M_PC_BL_DESC; }
     * 
     * Statement
     * stmt_vembu1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
     * String sql_vembu1="INSERT INTO PW_IL_REMINDER_SUMMARY ( RS_PROCESS_DT ,
     * RS_DS_TYPE , RS_POL_SYS_ID , RS_END_NO_IDX , RS_STATUS_CODE ,
     * RS_REPORT_NAME , RS_CR_DT , RS_CR_UID ) VALUES ( SYSDATE ,
     * "+M_POL_DS_TYPE+" , :DUMMY.M_POL_SYS_ID , "+M_POL_END_NO_IDX+" ,
     * DECODE(:DUMMY.M_PROP_STATUS, 'A', 'C01', 'C', 'B05') , "+M_REP_NAME+" ,
     * SYSDATE , :CTRL.M_USER_ID ) ";
     * GlobalVariables.ROWCOUNT=stmt_vembu1.executeUpdate(sql_vembu1);
     * stmt_vembu1.close(); :CTRL.M_COMM_DEL="C";
     * if(!vembu_conn.getAutoCommit()) vembu_conn.commit();
     * :CTRL.M_COMM_DEL=null; if(M_PLAN_TYPE=="M") {
     * if(:DUMMY.M_PROP_STATUS=="C") {
     * P_CANCELLATION_DOC.P_CANCELLATION_DOC(M_REP_NAME,"B"); } else
     * if(:DUMMY.M_PROP_STATUS=="A") {
     * P_ACCEPTENCE_LETTER.P_ACCEPTENCE_LETTER(M_REP_NAME,"B"); } } else {
     * :DUMMY.M_PRINT_TYPE="B"; if(:DUMMY.M_PROP_STATUS=="A") {
     * p9ilpk_uw_letters.p9ilpk_uw_letters.gen_je_acceptance_letter(M_DSRC_SYS_ID,M_REP_NAME,:DUMMY.M_POL_SYS_ID);
     * P_LIFE_LETTER.P_LIFE_LETTER(M_DSRC_SYS_ID,M_REP_NAME,:DUMMY.M_PRINT_TYPE,"UW"); } }
     * vembu_C3.close(); } }catch(Exception e) { e.printStackTrace(); throw e; }
     * finally { if(vembu_conn != null) {
     * SwisSqlConnection.getInstance().closeConnection(vembu_conn); } } }
     */

    public void pilp001_apac_dummy_m_but_print_when_button_pressed()
	    throws SQLException, Exception {
	String M_DR_REPORT_CODE = null;
	String M_PC_DESC = null;
	String M_PC_BL_DESC = null;
	String M_REP_NAME = null;
	String M_DSRC_SYS_ID = null;
	String M_POL_DS_TYPE = null;
	String M_POL_DS_CODE = null;
	String M_POL_ADDL_STATUS = null;
	String M_POL_PLAN_CODE = null;
	String M_PLAN_TYPE = null;
	String sql_C1 = "SELECT    POL_DS_TYPE,    POL_DS_CODE,    POL_ADDL_STATUS,    POL_PLAN_CODE FROM  PT_IL_POLICY  WHERE  POL_SYS_ID  = :DUMMY.M_POL_SYS_ID ";
	ResultSet rs_C1 = null;
	Statement stmt_C1 = connection.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	String sql_C2 = "SELECT DR_REPORT_CODE FROM  PM_IL_DOC_REMINDERS  WHERE  DR_DS_TYPE  = "
		+ M_POL_DS_TYPE
		+ "  AND DR_DS_CODE  = "
		+ M_POL_DS_CODE
		+ "  AND DR_STATUS_CODE  = 'RF01'  AND DR_REMINDER_TYPE  = 'N' ";
	ResultSet rs_C2 = null;
	Statement stmt_C2 = connection.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	String sql_C3 = "SELECT    PC_DESC,    PC_BL_DESC FROM  PM_CODES  WHERE  PC_TYPE  = 'IL_REMIN_RPT'  AND PC_CODE  = "
		+ M_DR_REPORT_CODE + " ";
	ResultSet rs_C3 = null;
	Statement stmt_C3 = connection.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	String sql_C4 = "SELECT PLAN_TYPE FROM  PM_IL_PLAN  WHERE  PLAN_CODE  = "
		+ M_POL_PLAN_CODE + " ";
	ResultSet rs_C4 = null;
	Statement stmt_C4 = connection.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

	try {
	    connection = CommonUtils.getConnection();
	    rs_C1 = stmt_C1.executeQuery(sql_C1);
	    if (rs_C1.next()) {
		M_POL_DS_TYPE = rs_C1.getString(1);
		M_POL_DS_CODE = rs_C1.getString(2);
		M_POL_ADDL_STATUS = rs_C1.getString(3);
		M_POL_PLAN_CODE = rs_C1.getString(4);
	    }

	    rs_C2 = stmt_C2.executeQuery(sql_C2);
	    if (rs_C2.next()) {
		M_DR_REPORT_CODE = rs_C2.getString(1);
	    }

	    rs_C3 = stmt_C3.executeQuery(sql_C3);
	    if (rs_C3.next()) {
		M_PC_DESC = rs_C3.getString(1);
		M_PC_BL_DESC = rs_C3.getString(2);
	    }

	    rs_C4 = stmt_C4.executeQuery(sql_C4);
	    if (rs_C4.next()) {
		M_PLAN_TYPE = rs_C4.getString(1);
	    }

	    M_REP_NAME = M_PC_DESC;
	    if (DUMMY_BEAN.getUI_M_PROP_STATUS().equals("C")
		    || DUMMY_BEAN.getUI_M_PROP_STATUS().equals("I")
		    || DUMMY_BEAN.getUI_M_PROP_STATUS().equals("P")) {
		if (M_PLAN_TYPE == "M"
			&& DUMMY_BEAN.getUI_M_DEPPREM_REFUND_YN().equals("Y")) {
		    // P_REFUND_CONTRIBUTION.P_REFUND_CONTRIBUTION(M_REP_NAME,"O");
		}
		if (M_PLAN_TYPE != "M"
			&& DUMMY_BEAN.getUI_M_DEPPREM_REFUND_YN().equals("Y")) {
		    // p9ilpk_uw_letters.p9ilpk_uw_letters.gen_je_cancellation(M_DSRC_SYS_ID,M_REP_NAME,:DUMMY.M_POL_SYS_ID);
		    // P_LIFE_LETTER.P_LIFE_LETTER(M_DSRC_SYS_ID,M_REP_NAME,:DUMMY.M_PRINT_TYPE,"UW");
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	} finally {
	    CommonUtils.closeCursor(rs_C1);
	    CommonUtils.closeCursor(rs_C2);
	    CommonUtils.closeCursor(rs_C3);
	    CommonUtils.closeCursor(rs_C4);

	}
    }

    /*
     * public List DivisionSuggestionBox(Object obj) throws Exception{
     * 
     * 
     * Get the query and execute it. Iterate over the resultset and create a
     * object "Suggest" Insert the Queried columns into the object and finally
     * insert this object into List.
     * 
     * 
     * String divisionCode = (String)obj; Divisionlist = new
     * PILP001DUMMY_VALIDATIONS().prepareDivisonCodeList(getConnection(),divisionCode,Divisionlist);
     * System.out.println("Entered String Is Thissssss= "+obj.toString());
     * return Divisionlist; }
     */

    public List lovAction(Object obj) {

	List lovList = new ArrayList();
	if (obj.toString().equals("*")) {
	    // String query = "select rownum,POL_NO,POL_SYS_ID,POL_ISSUE_DT FROM
	    // PT_IL_POLICY where rownum < 51";
	    String query = "select rownum,POL_PROP_NO,TO_CHAR(POL_ISSUE_DT) from PT_IL_POLICY where rownum < 51";
	    lovList = suggestionList(query);
	}
	/*
	 * else{ String query = "select rownum,POL_NO,POL_SYS_ID,POL_ISSUE_DT
	 * FROM PT_IL_POLICY where POL_NO like '"+obj.toString()+"%' and rownum<51" ;
	 * lovList = suggestionList(query); }
	 */
	return lovList;
    }

    public List suggestionList(String query) {
	// String query="SELECT POL_NO,POL_SYS_ID,POL_ISSUE_DT FROM
	// PT_IL_POLICY";
	// String query = "select rownum,POL_NO,POL_SYS_ID,POL_ISSUE_DT FROM
	// PT_IL_POLICY where rownum < 51";
	// String query = "SELECT POL_NO,POL_SYS_ID,POL_ISSUE_DT FROM
	// PT_IL_POLICY WHERE POL_NO IS NOT NULL AND POL_DS_TYPE = '2'";
	Statement stmt = null;
	List list = new ArrayList();
	ResultSet rs = null;
	try {
	    Connection con = CommonUtils.getConnection();

	    stmt = con.createStatement();
	    rs = stmt.executeQuery(query);
	    while (rs.next()) {
		PT_IL_POLICY_LOV lovBox = new PT_IL_POLICY_LOV();
		lovBox.setUI_M_PROP_NO(rs.getString("POL_PROP_NO"));
		lovBox
			.setUI_M_APPRV_DATE(rs
				.getString("TO_CHAR(POL_ISSUE_DT)"));
		list.add(lovBox);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		CommonUtils.closeCursor(rs);
	    } catch (SQLException se) {
		se.printStackTrace();
	    } catch (Exception ee) {
		ee.printStackTrace();
	    }
	}
	return list;
    }

   

    public List<SelectItem> getUI_M_PROCESS_TYPE_LIST() throws Exception {
    	//newly added to remove cancel button from proposal approval 
//    	if (UI_M_PROCESS_TYPE_LIST.size() == 0) {
//	    UI_M_PROCESS_TYPE_LIST.clear();
//	    connection = CommonUtils.getConnection();
//	    UI_M_PROCESS_TYPE_LIST = ListItemUtil.getDropDownListValue(
//		    connection, "PILP001_APAC", "DUMMY", "DUMMY.M_PROP_STATUS",
//		    "IL_STATUS");
    	UI_M_PROCESS_TYPE_LIST = new ArrayList<SelectItem>();
    	UI_M_PROCESS_TYPE_LIST.add(new SelectItem("A","Approve"));
    	UI_M_PROCESS_TYPE_LIST.add(new SelectItem("I","Declined"));
    	UI_M_PROCESS_TYPE_LIST.add(new SelectItem("O","Not Taken Up"));
    	
    	
    	/*Modified by ganesh on 13-04-2017 to display status screen description suggested by Chandramohan*/
    	/*UI_M_PROCESS_TYPE_LIST.add(new SelectItem("P","Postponed"));*/
    	UI_M_PROCESS_TYPE_LIST.add(new SelectItem("Z","Postponed"));
    	/*end*/
    	
    	UI_M_PROCESS_TYPE_LIST.add(new SelectItem("W","Withdrawn"));    
    	return UI_M_PROCESS_TYPE_LIST;
    }

    public List<SelectItem> getUI_M_PROP_TYPE_LIST() throws Exception {
	if (UI_M_PROP_TYPE_LIST.size() == 0) {
	    UI_M_PROP_TYPE_LIST.clear();
	    connection = CommonUtils.getConnection();
	    UI_M_PROP_TYPE_LIST = ListItemUtil.getDropDownListValue(connection,
		    "PILP001_APAC", "DUMMY", "DUMMY.M_PROP_CONVERT", "YESNO");
	}
	return UI_M_PROP_TYPE_LIST;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_PROP_STATUS() {
	return COMP_UI_M_PROP_STATUS;
    }

    public void setCOMP_UI_M_PROP_STATUS(HtmlSelectOneMenu comp_ui_m_prop_status) {
	COMP_UI_M_PROP_STATUS = comp_ui_m_prop_status;
    }

    public void setUI_M_PROCESS_TYPE_LIST(
	    List<SelectItem> ui_m_process_type_list) {
	UI_M_PROCESS_TYPE_LIST = ui_m_process_type_list;
    }

    public void setUI_M_PROP_TYPE_LIST(List<SelectItem> ui_m_prop_type_list) {
	UI_M_PROP_TYPE_LIST = ui_m_prop_type_list;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_PROP_CONVERT() {
	return COMP_UI_M_PROP_CONVERT;
    }

    public void setCOMP_UI_M_PROP_CONVERT(
	    HtmlSelectOneMenu comp_ui_m_prop_convert) {
	COMP_UI_M_PROP_CONVERT = comp_ui_m_prop_convert;
    }

    public HtmlOutputLabel getCOMP_UI_M_RE_UW_REQ_YN_LABEL() {
	return COMP_UI_M_RE_UW_REQ_YN_LABEL;
    }

    public void setCOMP_UI_M_RE_UW_REQ_YN_LABEL(
	    HtmlOutputLabel comp_ui_m_re_uw_req_yn_label) {
	COMP_UI_M_RE_UW_REQ_YN_LABEL = comp_ui_m_re_uw_req_yn_label;
    }

    public HtmlSelectOneMenu getCOMP_UI_M_RE_UW_REQ_YN() {
	return COMP_UI_M_RE_UW_REQ_YN;
    }

    public void setCOMP_UI_M_RE_UW_REQ_YN(
	    HtmlSelectOneMenu comp_ui_m_re_uw_req_yn) {
	COMP_UI_M_RE_UW_REQ_YN = comp_ui_m_re_uw_req_yn;
    }

    public HtmlOutputLabel getCOMP_UI_M_RE_UW_REQ_REASON_LABEL() {
	return COMP_UI_M_RE_UW_REQ_REASON_LABEL;
    }

    public void setCOMP_UI_M_RE_UW_REQ_REASON_LABEL(
	    HtmlOutputLabel comp_ui_m_re_uw_req_reason_label) {
	COMP_UI_M_RE_UW_REQ_REASON_LABEL = comp_ui_m_re_uw_req_reason_label;
    }

    public HtmlInputText getCOMP_UI_M_RE_UW_REQ_REASON() {
	return COMP_UI_M_RE_UW_REQ_REASON;
    }

    public void setCOMP_UI_M_RE_UW_REQ_REASON(
	    HtmlInputText comp_ui_m_re_uw_req_reason) {
	COMP_UI_M_RE_UW_REQ_REASON = comp_ui_m_re_uw_req_reason;
    }

    public List<SelectItem> getRE_UW_REQ_YN_LIST() {
	return RE_UW_REQ_YN_LIST;
    }

    public void setRE_UW_REQ_YN_LIST(List<SelectItem> re_uw_req_yn_list) {
	RE_UW_REQ_YN_LIST = re_uw_req_yn_list;
    }

   

    /**
     * METHOD CALLED ON VALIDATOR FOR UI_M_RE_UW_REQ_YN
     * 
     * @param context
     * @param component
     * @param value
     * @throws Exception
     */
    public void validateUI_M_RE_UW_REQ_YN(FacesContext context,
	    UIComponent component, Object value) throws ValidatorException,
	    Exception {
	DUMMY_BEAN.setUI_M_RE_UW_REQ_YN((String) value);
	helper.ui_m_re_uw_req_yn_when_list_changed(this, DUMMY_BEAN);
    }

    /**
     * METHOD CALLED ON a4j support onblur actionListener FOR
     * COMP_UI_M_TRAN_DATE
     * 
     * @param e
     */
    public void fireFieldValidation(ActionEvent e) {
	UIInput input = (UIInput) e.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
    }


    public String navigateToPolicy() {
	PILT002_APAC_COMPOSITE_ACTION pilt002_apacCompositeAction = (PILT002_APAC_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
	pilt002_apacCompositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
	compositeAction.getDUMMY_ACTION_BEAN().setFormFlag(true);
	//compositeAction.getDUMMY_ACTION_BEAN().setBlockFlag(true);
	return "navigateToPolicyEntry";
    }

    public String navigateToPolicyApproval() {

	return "navigateToPolicyApproval";
    }

    public List<SelectItem> getUI_M_DEPPREM_REFUND_YN_LIST() {
	return UI_M_DEPPREM_REFUND_YN_LIST;
    }

    public void setUI_M_DEPPREM_REFUND_YN_LIST(
	    List<SelectItem> ui_m_depprem_refund_yn_list) {
	UI_M_DEPPREM_REFUND_YN_LIST = ui_m_depprem_refund_yn_list;
    }

    public List<SelectItem> getUI_M_MED_FEE_RECOVER_YN_LIST() {
	return UI_M_MED_FEE_RECOVER_YN_LIST;
    }

    public void setUI_M_MED_FEE_RECOVER_YN_LIST(
	    List<SelectItem> ui_m_med_fee_recover_yn_list) {
	UI_M_MED_FEE_RECOVER_YN_LIST = ui_m_med_fee_recover_yn_list;
    }

    private Map<String, String> getPolicyWarningMap() {
	CommonUtils commonUtils = new CommonUtils();
	PILT002_APAC_COMPOSITE_ACTION compositeAction = (PILT002_APAC_COMPOSITE_ACTION) commonUtils
		.getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");

	return compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap();
    }
    
    public ArrayList<com.iii.premia.common.bean.LovBean>lovUI_M_POL_DOCCODE(
	    Object currValue) {

	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('DUMMY.M_POL_DOCCODE','2');
	    suggestionList = listitemutil.P_CALL_LOV("PILP001_APAC",
		    "DUMMY", "M_POL_DOCCODE", "2", null,
		    null, null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }
    
    public ArrayList<com.iii.premia.common.bean.LovBean>lovUI_M_PS_REASON_CODE(
	    Object currValue) {
	
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
	    // P_CALL_LOV('DUMMY.M_PS_REASON_CODE','IL_REASON');
	    suggestionList = listitemutil.P_CALL_LOV("PILP001_APAC",
		    "DUMMY", "M_PS_REASON_CODE", "IL_REASON", null,
		    null, null, null, (String) currValue);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return suggestionList;
    }
    
    public void onLoad(PhaseEvent event) {
	try {
		//CommonUtils.clearMaps(this);
	    if (isFormFlag()) {
	    	CommonUtils.clearMaps(this);
		/*helper.pilp001_apac_when_new_form_instance(this, DUMMY_BEAN);
		setBlockFlag(true);*/
	    	preform();
		setFormFlag(false);
	    }
	    if (isBlockFlag()) {
		helper.pilp001_apac_dummy_when_new_record_instance(this,DUMMY_BEAN);
		helper.pilp001_apac_dummy_when_create_record(DUMMY_BEAN);
		setBlockFlag(false);	
		}
	    COMP_UI_M_PROP_NO.resetValue();
	    COMP_UI_M_POLICY_NO.resetValue();
	}
	catch (Exception e) {
	    e.printStackTrace();
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,  e.getMessage());
	    getErrorMap().put("onLoad", e.getMessage());
	}
    }
    
    public void validateUI_M_APPRV_DATE(FacesContext context,
	    UIComponent component, Object value) {
	try {
	    	DUMMY_BEAN.setUI_M_APPRV_DATE((Date) value);
	     helper.ui_m_apprv_date_when_validate_item(this, DUMMY_BEAN);
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
	    		.getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_APPRV_DATE",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    public void validateUI_M_PROP_NO(FacesContext context,
	    UIComponent component, Object value) {
	try {
	    DUMMY_BEAN.setUI_M_PROP_NO((String) value);
	    helper.ui_m_prop_no_when_validate_item( this, DUMMY_BEAN);
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_APPRV_DATE",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    public void VALIDATEUI_M_DEPPREM_REFUND_YN(FacesContext context,
	    UIComponent component, Object value) {
	try {
	    DUMMY_BEAN.setUI_M_DEPPREM_REFUND_YN((String) value);
	    helper.ui_m_depprem_refund_yn_when_list_changed(this, DUMMY_BEAN);
	    COMP_UI_M_MED_FEE_RECOVER_YN.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_DEPPREM_REFUND_YN",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    
    public void VALIDATEUI_M_POL_DOCCODE(FacesContext context,
	    UIComponent component, Object value) {
	try {
	    DUMMY_BEAN.setUI_M_POL_DOCCODE((String) value);
	    helper.ui_m_pol_doccode_when_validate_item(this, DUMMY_BEAN);
	    COMP_UI_M_DS_DESC.resetValue();
	    COMP_UI_M_POLICY_NO.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_POL_DOCCODE",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    
    public void VALIDATEUI_M_POLICY_NO(FacesContext context,
	    UIComponent component, Object value) {
	try {
	    DUMMY_BEAN.setUI_M_POLICY_NO((String) value);
	    helper.ui_m_policy_no_when_validate_item(DUMMY_BEAN);
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_POLICY_NO",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    
    public void VALIDATEUI_M_PROP_CONVERT(FacesContext context,
	    UIComponent component, Object value) {
	try {
	    DUMMY_BEAN.setUI_M_PROP_CONVERT((String) value);
	    helper.ui_m_prop_convert_when_list_changed(this, DUMMY_BEAN);
    	   COMP_UI_M_POL_DOCCODE.resetValue();
    	   COMP_UI_M_POLICY_NO.resetValue();
    	   COMP_UI_M_DS_DESC.resetValue();
    	   checkDocSetUp();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_PROP_CONVERT",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    //added by Akash to enable policy field if document set up is not available.
    
    public void checkDocSetUp(){
    	if(DUMMY_BEAN.getUI_M_POL_DOCCODE() != null ){
    		COMP_UI_M_POLICY_NO.setDisabled(true);
    	}else{
    		COMP_UI_M_POLICY_NO.setDisabled(false);
    	}
    }
    
    
    public void VALIDATEUI_M_PROP_STATUS(FacesContext context,
	    UIComponent component, Object value) {
	try {
	    DUMMY_BEAN.setUI_M_PROP_STATUS((String) value);
	    helper.ui_m_prop_status_when_list_changed(this, DUMMY_BEAN);
	    DUMMY_BEAN.setUI_M_PS_REASON_CODE(null);
	    COMP_UI_M_PS_REMARKS.resetValue();
	    COMP_UI_M_REASON_DESC.resetValue();
	    COMP_UI_M_DEPPREM_REFUND_YN.resetValue();
	    COMP_UI_M_MED_FEE_RECOVER_YN.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_PROP_STATUS",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    
    
    public void VALIDATEUI_M_PS_REASON_CODE(FacesContext context,
	    UIComponent component, Object value) {
	try {
	    DUMMY_BEAN.setUI_M_PS_REASON_CODE((String) value);
	    helper.ui_m_ps_reason_code_when_list_changed(this, DUMMY_BEAN);
	    COMP_UI_M_REASON_DESC.resetValue();
	} catch (Exception exception) {
	    exception.printStackTrace();
	    throw new ValidatorException(new FacesMessage(exception
		    .getMessage()));
	} finally {
	    try {
		ErrorHelpUtil.getWarningForProcedure(CommonUtils
			.getConnection(), "UI_M_PS_REASON_CODE",
			getWarningMap());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    //added by saranya on 8-04-16 for email captured
    public void validatorMAIL_SEND_TO_TYPE(FacesContext context,
			UIComponent component, Object value) {
    	try {
    		 CommonUtils commonUtils = new CommonUtils();
    		 PILT002_APAC_COMPOSITE_ACTION compositeAction = (PILT002_APAC_COMPOSITE_ACTION) commonUtils
    				    .getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
    			PT_IL_POL_BROKER_HEAD_DELEGATE obj =new PT_IL_POL_BROKER_HEAD_DELEGATE();
    			obj.executeSelectStatement(compositeAction);
    		 
	    		System.out.println("*********** Enter the validatorMAIL_SEND_TO_TYPE *************");
	    		setMAIL_SEND_TO(value.toString());
	    		System.out.println("getMAIL_SEND_TO : "+getMAIL_SEND_TO());
	    		if("CUSTOMER".equalsIgnoreCase(getMAIL_SEND_TO()))
	    		{
	    			
	    			String val_cus=CommonUtils.getGlobalVariable("GLOBAL_CUST_MAIL_ID");
	    			
	    			System.out.println("***ENTER INTO CUSTOMER**** ");
	    			System.out.println("in validation block get customer mail id:  "+val_cus);
	    			//PT_IL_POLICY_BEAN.getPOL_RES_EMAIL_ID();

	    		}
	    		else if("BROKER".equalsIgnoreCase(getMAIL_SEND_TO()))
	    		{
	    			String val_bro=CommonUtils.getGlobalVariable("GLOBAL_BRO_MAIL_ID");
	    			System.out.println("***ENTER INTO BROKER**** ");
	    			System.out.println("in validation block get customer mail id:  "+val_bro);
	    			//PT_IL_POL_BROKER_HEAD_BEAN.getMAIL_ID();
	    		}
	    		else if("BOTH".equalsIgnoreCase(getMAIL_SEND_TO()))
	    		{
	    		
	    			
	    			String val_cus=CommonUtils.getGlobalVariable("GLOBAL_CUST_MAIL_ID");
	    			String val_bro=CommonUtils.getGlobalVariable("GLOBAL_BRO_MAIL_ID");
	    			System.out.println("***ENTER INTO BOTH**** ");
	    			System.out.println("in validation block get customer mail id:  "+","+val_cus);
	    			System.out.println("in validation block get customer mail id:  "+val_bro);
	    			//PT_IL_POLICY_BEAN.getPOL_RES_EMAIL_ID();
	    			//PT_IL_POL_BROKER_HEAD_BEAN.getMAIL_ID();
	    			
	    		}
	    	} catch (Exception e) {
	    		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    	}
		}
    
    public ArrayList<SelectItem> MAIL_SEND_TO_LIST(){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			System.out.println("****************   BROKER_MAIL_ID_LIST   *****************");
			
			selectItem = new SelectItem();
			selectItem.setLabel("CUSTOMER");
			selectItem.setValue("CUSTOMER");
			list.add(selectItem);
			
			selectItem = new SelectItem();
			selectItem.setLabel("BROKER");
			selectItem.setValue("BROKER");
			list.add(selectItem);
			
			selectItem = new SelectItem();
			selectItem.setLabel("BOTH");
			selectItem.setValue("BOTH");
			list.add(selectItem);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}return list;
		}
    //end
    

	/**
	 * Instantiates all components in DUMMY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_RE_UW_REQ_REASON			 = new HtmlInputText();
		COMP_UI_M_PROP_NO				 = new HtmlInputText();
		COMP_UI_M_POL_DOCCODE				 = new HtmlInputText();
		COMP_UI_M_DS_DESC				 = new HtmlInputText();
		COMP_UI_M_POLICY_NO				 = new HtmlInputText();
		COMP_UI_M_PS_REASON_CODE			 = new HtmlInputText();
		COMP_UI_M_REASON_DESC				 = new HtmlInputText();
		COMP_UI_M_PS_REMARKS				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_UI_M_PROP_NO_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_RE_UW_REQ_YN_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_RE_UW_REQ_REASON_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_APPRV_DATE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PROP_STATUS_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PROP_CONVERT_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_DOCCODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_DS_DESC_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_POLICY_NO_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_DEPPREM_REFUND_YN_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_MED_FEE_RECOVER_YN_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_PS_REASON_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_REASON_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PS_REMARKS_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_UI_M_RE_UW_REQ_YN				 = new HtmlSelectOneMenu();
		COMP_UI_M_PROP_STATUS				 = new HtmlSelectOneMenu();
		COMP_UI_M_PROP_CONVERT				 = new HtmlSelectOneMenu();
		COMP_UI_M_DEPPREM_REFUND_YN			 = new HtmlSelectOneMenu();
		COMP_UI_M_MED_FEE_RECOVER_YN			 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_UI_M_APPRV_DATE				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_PROP_LOV				 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_DOC_CODE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_POLICY_NO				 = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_PC_CODE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_PS_REMARKS			 = new HtmlCommandButton();
		COMP_UI_M_BUT_OK				 = new HtmlAjaxCommandButton();
		COMP_UI_M_BUT_CANCEL				 = new HtmlCommandButton();
		COMP_UI_M_BUT_PRINT				 = new HtmlCommandButton();

	}

	public String emailTriggerProcCall(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH) throws Exception{
		
		Connection con=CommonUtils.getConnection();
		System.out.println("P_MAIL_TYPE-->"+P_MAIL_TYPE);
		String out="";
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
		  parameterList.add(param1); 
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_MAIL_TYPE);
		  parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
		  parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CUST_TYPE);
		  parameterList.add(param4);
		  OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_MAIL_PATH);
		  parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("OUT1", "STRING", "OUT",out);
	    parameterList.add(param6);
	    OracleProcedureHandler procHandler = new OracleProcedureHandler();
	    outputList = procHandler.execute(parameterList, con,
	            "P_MAIL_TEMP");
	    CommonUtils.doComitt();
	    Iterator<OracleParameter> iterator = outputList.iterator();
	    while (iterator.hasNext()) {
	        OracleParameter oracleParameter = iterator.next();
	        System.out.println("Output value:::" + oracleParameter.getValue());
			out=(String)oracleParameter.getValue();
	    }
		return out;
		}

}
