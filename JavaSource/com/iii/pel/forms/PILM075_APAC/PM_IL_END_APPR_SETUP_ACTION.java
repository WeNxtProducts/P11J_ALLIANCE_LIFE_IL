package com.iii.pel.forms.PILM075_APAC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
import javax.faces.event.PhaseId;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM034.PILM034_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM052_APAC.PM_DEPT_DRCR_LINK_DELEGATE;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;


public class PM_IL_END_APPR_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_USER_GROUP_ID_LABEL;

	private HtmlInputText COMP_USER_GROUP_ID;

	private HtmlOutputLabel COMP_EAS_AS_USER_ID_LABEL;

	private HtmlInputText COMP_EAS_AS_USER_ID;

	private HtmlOutputLabel COMP_UI_M_USER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_USER_DESC;

	private HtmlOutputLabel COMP_EAS_AS_FM_PROD_CODE_LABEL;

	private HtmlInputText COMP_EAS_AS_FM_PROD_CODE;

	private HtmlOutputLabel COMP_EAS_AS_FM_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_EAS_AS_FM_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_EAS_AS_TO_PROD_CODE_LABEL;

	private HtmlInputText COMP_EAS_AS_TO_PROD_CODE;

	private HtmlOutputLabel COMP_EAS_AS_TO_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_EAS_AS_TO_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_EAS_FM_END_CODE_LABEL;

	private HtmlInputText COMP_EAS_FM_END_CODE;

	private HtmlOutputLabel COMP_EAS_FM_END_CODE_DESC_LABEL;

	private HtmlInputText COMP_EAS_FM_END_CODE_DESC;

	private HtmlOutputLabel COMP_EAS_TO_END_CODE_LABEL;

	private HtmlInputText COMP_EAS_TO_END_CODE;

	private HtmlOutputLabel COMP_EAS_TO_END_CODE_DESC_LABEL;

	private HtmlInputText COMP_EAS_TO_END_CODE_DESC;

	private HtmlOutputLabel COMP_EAS_END_PROC_YN_LABEL;

	private HtmlSelectOneMenu COMP_EAS_END_PROC_YN;

	private HtmlOutputLabel COMP_EAS_END_APPR_YN_LABEL;

	private HtmlSelectOneMenu COMP_EAS_END_APPR_YN;

	private HtmlCommandButton COMP_EAS_AS_FM_PROD_CODE_BUT;

	private HtmlCommandButton COMP_EAS_AS_TO_PROD_CODE_BUT;

	private HtmlCommandButton COMP_UI_M_BUT_COPY;

	private HtmlCommandButton COMP_FM_END_CODE_BUT;

	private HtmlCommandButton COMP_TO_END_CODE_BUT;

	private HtmlCommandButton COMP_UI_M_LOV_USER_ID;

	private PM_IL_END_APPR_SETUP PM_IL_END_APPR_SETUP_BEAN;
	private DUMMY DUMMY_BEAN;
	
	private List<SelectItem> endtProcessList = new ArrayList<SelectItem>();
	private List<SelectItem> endtApprovalList = new ArrayList<SelectItem>();
	
	private TabbedBar tabbedBar;
	

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}
	
	private boolean saveExecuted=false;
	
	private boolean userIDDisable;
	
	public PM_IL_END_APPR_SETUP_ACTION() {
		PM_IL_END_APPR_SETUP_BEAN = new PM_IL_END_APPR_SETUP();
		DUMMY_BEAN = new DUMMY();
		tabbedBar = new TabbedBar();		
		try{
			this.tabbedBar.addTab(1, "#{PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION.goBlock_PM_IL_END_APPR_SETUP}", Messages.getString("messageProperties_PILM075_APAC", "PILM075_APAC$PM_IL_END_APPR_SETUP$displayCaption"), false);
			this.tabbedBar.addTab(2, "#{PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION.goBlock_PM_IL_END_SETUP_DET1}", Messages.getString("messageProperties_PILM075_APAC", "PILM075_APAC$PM_IL_END_SETUP_DET1$displayCaption"), false);
			this.tabbedBar.addTab(3, "#{PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION.goBlock_PM_IL_END_SETUP_DET}", Messages.getString("messageProperties_PILM075_APAC", "PILM075_APAC$PM_IL_END_SETUP_DET$displayCaption"), false);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String goBlock_PM_IL_END_APPR_SETUP(){
		saveMethod();
		return "PILM075_APAC_PM_IL_END_APPR_SETUP";
	}
	public String goBlock_PM_IL_END_SETUP_DET1(){		
		saveMethod();
		return "PILM075_APAC_PM_IL_END_SETUP_DET1";
	}
	public String goBlock_PM_IL_END_SETUP_DET(){
		saveMethod();
		return "PILM075_APAC_PM_IL_END_SETUP_DET";
	}

	public HtmlOutputLabel getCOMP_USER_GROUP_ID_LABEL() {
		return COMP_USER_GROUP_ID_LABEL;
	}

	public HtmlInputText getCOMP_USER_GROUP_ID() {
		return COMP_USER_GROUP_ID;
	}

	public void setCOMP_USER_GROUP_ID_LABEL(
			HtmlOutputLabel COMP_USER_GROUP_ID_LABEL) {
		this.COMP_USER_GROUP_ID_LABEL = COMP_USER_GROUP_ID_LABEL;
	}

	public void setCOMP_USER_GROUP_ID(HtmlInputText COMP_USER_GROUP_ID) {
		this.COMP_USER_GROUP_ID = COMP_USER_GROUP_ID;
	}

	public HtmlOutputLabel getCOMP_EAS_AS_USER_ID_LABEL() {
		return COMP_EAS_AS_USER_ID_LABEL;
	}

	public HtmlInputText getCOMP_EAS_AS_USER_ID() {
		return COMP_EAS_AS_USER_ID;
	}

	public void setCOMP_EAS_AS_USER_ID_LABEL(
			HtmlOutputLabel COMP_EAS_AS_USER_ID_LABEL) {
		this.COMP_EAS_AS_USER_ID_LABEL = COMP_EAS_AS_USER_ID_LABEL;
	}

	public void setCOMP_EAS_AS_USER_ID(HtmlInputText COMP_EAS_AS_USER_ID) {
		this.COMP_EAS_AS_USER_ID = COMP_EAS_AS_USER_ID;
	}

	public HtmlOutputLabel getCOMP_UI_M_USER_DESC_LABEL() {
		return COMP_UI_M_USER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_USER_DESC() {
		return COMP_UI_M_USER_DESC;
	}

	public void setCOMP_UI_M_USER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_USER_DESC_LABEL) {
		this.COMP_UI_M_USER_DESC_LABEL = COMP_UI_M_USER_DESC_LABEL;
	}

	public void setCOMP_UI_M_USER_DESC(HtmlInputText COMP_UI_M_USER_DESC) {
		this.COMP_UI_M_USER_DESC = COMP_UI_M_USER_DESC;
	}

	public HtmlOutputLabel getCOMP_EAS_AS_FM_PROD_CODE_LABEL() {
		return COMP_EAS_AS_FM_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_EAS_AS_FM_PROD_CODE() {
		return COMP_EAS_AS_FM_PROD_CODE;
	}

	public void setCOMP_EAS_AS_FM_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_EAS_AS_FM_PROD_CODE_LABEL) {
		this.COMP_EAS_AS_FM_PROD_CODE_LABEL = COMP_EAS_AS_FM_PROD_CODE_LABEL;
	}

	public void setCOMP_EAS_AS_FM_PROD_CODE(
			HtmlInputText COMP_EAS_AS_FM_PROD_CODE) {
		this.COMP_EAS_AS_FM_PROD_CODE = COMP_EAS_AS_FM_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_EAS_AS_FM_PROD_CODE_DESC_LABEL() {
		return COMP_EAS_AS_FM_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_EAS_AS_FM_PROD_CODE_DESC() {
		return COMP_EAS_AS_FM_PROD_CODE_DESC;
	}

	public void setCOMP_EAS_AS_FM_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_EAS_AS_FM_PROD_CODE_DESC_LABEL) {
		this.COMP_EAS_AS_FM_PROD_CODE_DESC_LABEL = COMP_EAS_AS_FM_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_EAS_AS_FM_PROD_CODE_DESC(
			HtmlInputText COMP_EAS_AS_FM_PROD_CODE_DESC) {
		this.COMP_EAS_AS_FM_PROD_CODE_DESC = COMP_EAS_AS_FM_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_EAS_AS_TO_PROD_CODE_LABEL() {
		return COMP_EAS_AS_TO_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_EAS_AS_TO_PROD_CODE() {
		return COMP_EAS_AS_TO_PROD_CODE;
	}

	public void setCOMP_EAS_AS_TO_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_EAS_AS_TO_PROD_CODE_LABEL) {
		this.COMP_EAS_AS_TO_PROD_CODE_LABEL = COMP_EAS_AS_TO_PROD_CODE_LABEL;
	}

	public void setCOMP_EAS_AS_TO_PROD_CODE(
			HtmlInputText COMP_EAS_AS_TO_PROD_CODE) {
		this.COMP_EAS_AS_TO_PROD_CODE = COMP_EAS_AS_TO_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_EAS_AS_TO_PROD_CODE_DESC_LABEL() {
		return COMP_EAS_AS_TO_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_EAS_AS_TO_PROD_CODE_DESC() {
		return COMP_EAS_AS_TO_PROD_CODE_DESC;
	}

	public void setCOMP_EAS_AS_TO_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_EAS_AS_TO_PROD_CODE_DESC_LABEL) {
		this.COMP_EAS_AS_TO_PROD_CODE_DESC_LABEL = COMP_EAS_AS_TO_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_EAS_AS_TO_PROD_CODE_DESC(
			HtmlInputText COMP_EAS_AS_TO_PROD_CODE_DESC) {
		this.COMP_EAS_AS_TO_PROD_CODE_DESC = COMP_EAS_AS_TO_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_EAS_FM_END_CODE_LABEL() {
		return COMP_EAS_FM_END_CODE_LABEL;
	}

	public HtmlInputText getCOMP_EAS_FM_END_CODE() {
		return COMP_EAS_FM_END_CODE;
	}

	public void setCOMP_EAS_FM_END_CODE_LABEL(
			HtmlOutputLabel COMP_EAS_FM_END_CODE_LABEL) {
		this.COMP_EAS_FM_END_CODE_LABEL = COMP_EAS_FM_END_CODE_LABEL;
	}

	public void setCOMP_EAS_FM_END_CODE(HtmlInputText COMP_EAS_FM_END_CODE) {
		this.COMP_EAS_FM_END_CODE = COMP_EAS_FM_END_CODE;
	}

	public HtmlOutputLabel getCOMP_EAS_FM_END_CODE_DESC_LABEL() {
		return COMP_EAS_FM_END_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_EAS_FM_END_CODE_DESC() {
		return COMP_EAS_FM_END_CODE_DESC;
	}

	public void setCOMP_EAS_FM_END_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_EAS_FM_END_CODE_DESC_LABEL) {
		this.COMP_EAS_FM_END_CODE_DESC_LABEL = COMP_EAS_FM_END_CODE_DESC_LABEL;
	}

	public void setCOMP_EAS_FM_END_CODE_DESC(
			HtmlInputText COMP_EAS_FM_END_CODE_DESC) {
		this.COMP_EAS_FM_END_CODE_DESC = COMP_EAS_FM_END_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_EAS_TO_END_CODE_LABEL() {
		return COMP_EAS_TO_END_CODE_LABEL;
	}

	public HtmlInputText getCOMP_EAS_TO_END_CODE() {
		return COMP_EAS_TO_END_CODE;
	}

	public void setCOMP_EAS_TO_END_CODE_LABEL(
			HtmlOutputLabel COMP_EAS_TO_END_CODE_LABEL) {
		this.COMP_EAS_TO_END_CODE_LABEL = COMP_EAS_TO_END_CODE_LABEL;
	}

	public void setCOMP_EAS_TO_END_CODE(HtmlInputText COMP_EAS_TO_END_CODE) {
		this.COMP_EAS_TO_END_CODE = COMP_EAS_TO_END_CODE;
	}

	public HtmlOutputLabel getCOMP_EAS_TO_END_CODE_DESC_LABEL() {
		return COMP_EAS_TO_END_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_EAS_TO_END_CODE_DESC() {
		return COMP_EAS_TO_END_CODE_DESC;
	}

	public void setCOMP_EAS_TO_END_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_EAS_TO_END_CODE_DESC_LABEL) {
		this.COMP_EAS_TO_END_CODE_DESC_LABEL = COMP_EAS_TO_END_CODE_DESC_LABEL;
	}

	public void setCOMP_EAS_TO_END_CODE_DESC(
			HtmlInputText COMP_EAS_TO_END_CODE_DESC) {
		this.COMP_EAS_TO_END_CODE_DESC = COMP_EAS_TO_END_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_EAS_END_PROC_YN_LABEL() {
		return COMP_EAS_END_PROC_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_EAS_END_PROC_YN() {
		return COMP_EAS_END_PROC_YN;
	}

	public void setCOMP_EAS_END_PROC_YN_LABEL(
			HtmlOutputLabel COMP_EAS_END_PROC_YN_LABEL) {
		this.COMP_EAS_END_PROC_YN_LABEL = COMP_EAS_END_PROC_YN_LABEL;
	}

	public void setCOMP_EAS_END_PROC_YN(HtmlSelectOneMenu COMP_EAS_END_PROC_YN) {
		this.COMP_EAS_END_PROC_YN = COMP_EAS_END_PROC_YN;
	}

	public HtmlOutputLabel getCOMP_EAS_END_APPR_YN_LABEL() {
		return COMP_EAS_END_APPR_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_EAS_END_APPR_YN() {
		return COMP_EAS_END_APPR_YN;
	}

	public void setCOMP_EAS_END_APPR_YN_LABEL(
			HtmlOutputLabel COMP_EAS_END_APPR_YN_LABEL) {
		this.COMP_EAS_END_APPR_YN_LABEL = COMP_EAS_END_APPR_YN_LABEL;
	}

	public void setCOMP_EAS_END_APPR_YN(HtmlSelectOneMenu COMP_EAS_END_APPR_YN) {
		this.COMP_EAS_END_APPR_YN = COMP_EAS_END_APPR_YN;
	}

	public HtmlCommandButton getCOMP_EAS_AS_FM_PROD_CODE_BUT() {
		return COMP_EAS_AS_FM_PROD_CODE_BUT;
	}

	public void setCOMP_EAS_AS_FM_PROD_CODE_BUT(
			HtmlCommandButton COMP_EAS_AS_FM_PROD_CODE_BUT) {
		this.COMP_EAS_AS_FM_PROD_CODE_BUT = COMP_EAS_AS_FM_PROD_CODE_BUT;
	}

	public HtmlCommandButton getCOMP_EAS_AS_TO_PROD_CODE_BUT() {
		return COMP_EAS_AS_TO_PROD_CODE_BUT;
	}

	public void setCOMP_EAS_AS_TO_PROD_CODE_BUT(
			HtmlCommandButton COMP_EAS_AS_TO_PROD_CODE_BUT) {
		this.COMP_EAS_AS_TO_PROD_CODE_BUT = COMP_EAS_AS_TO_PROD_CODE_BUT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_COPY() {
		return COMP_UI_M_BUT_COPY;
	}

	public void setCOMP_UI_M_BUT_COPY(HtmlCommandButton COMP_UI_M_BUT_COPY) {
		this.COMP_UI_M_BUT_COPY = COMP_UI_M_BUT_COPY;
	}

	public HtmlCommandButton getCOMP_FM_END_CODE_BUT() {
		return COMP_FM_END_CODE_BUT;
	}

	public void setCOMP_FM_END_CODE_BUT(HtmlCommandButton COMP_FM_END_CODE_BUT) {
		this.COMP_FM_END_CODE_BUT = COMP_FM_END_CODE_BUT;
	}

	public HtmlCommandButton getCOMP_TO_END_CODE_BUT() {
		return COMP_TO_END_CODE_BUT;
	}

	public void setCOMP_TO_END_CODE_BUT(HtmlCommandButton COMP_TO_END_CODE_BUT) {
		this.COMP_TO_END_CODE_BUT = COMP_TO_END_CODE_BUT;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_USER_ID() {
		return COMP_UI_M_LOV_USER_ID;
	}

	public void setCOMP_UI_M_LOV_USER_ID(HtmlCommandButton COMP_UI_M_LOV_USER_ID) {
		this.COMP_UI_M_LOV_USER_ID = COMP_UI_M_LOV_USER_ID;
	}

	public PM_IL_END_APPR_SETUP getPM_IL_END_APPR_SETUP_BEAN() {
		return PM_IL_END_APPR_SETUP_BEAN;
	}

	public void setPM_IL_END_APPR_SETUP_BEAN(
			PM_IL_END_APPR_SETUP PM_IL_END_APPR_SETUP_BEAN) {
		this.PM_IL_END_APPR_SETUP_BEAN = PM_IL_END_APPR_SETUP_BEAN;
	}

	public void preformPILM075_APAC() {

		System.out.println("PT_IL_POLICY_ACTION.preformPILT003_Apac()");

		System.out.println("PREFORM...............");
		FacesContext fc = FacesContext.getCurrentInstance();

		String DUMMY_M_BASE_CURR_CODE = null;
		Map<String, Object> session = fc.getExternalContext().getSessionMap();
		// session.put("GLOBAL.M_PRIVILEGE", "YYY");
		session.put("GLOBAL.M_FAILURE", "FALSE");
		// session.put("GLOBAL.M_USER_ID", "RAGHU");
		session.put("GLOBAL.M_NAME", "COMPANY NAME..................");
		// session.put("GLOBAL.M_LANG_CODE", "ENG");
		// session.put("GLOBAL.M_PARA_1", " ");
		// session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
		session.put("GLOBAL.M_DFLT_VALUES", "00101    01    ");
		DUMMY_BEAN.setPM_IL_APPR_SETUP_CF("N");
		DUMMY_BEAN.setPM_IL_APPR_DEPT_SETUP_CF("N");		
		//if (session.get("MODE") !=null && session.get("MODE").toString().equalsIgnoreCase("Update") ){
		//	postQuery();
		//}
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}
	
	public void actionListnerCommonItems(ActionEvent event){
		System.out.println("COMMON ACTION lISTENER CALLED");
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}
	public void validateEAS_AS_USER_ID(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {	
			PM_IL_END_APPR_SETUP_BEAN.setEAS_AS_USER_ID(value.toString());
			ArrayList<String> descList =callP_VAL_USER_ID(value.toString(), "E");
			PM_IL_END_APPR_SETUP_BEAN.setUI_M_USER_DESC(descList.get(0));
			COMP_UI_M_USER_DESC.setSubmittedValue(descList.get(0));
			PM_IL_END_APPR_SETUP_BEAN.setUSER_GROUP_ID(descList.get(1));
			COMP_USER_GROUP_ID.setSubmittedValue(descList.get(1));
			
		} catch (Exception e) {
			throw e;
		} finally {
			ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
					.getConnection(), FacesContext.getCurrentInstance(),
					component.getClientId(FacesContext.getCurrentInstance()),
					getWarningMap());
		}
	}

	public void actionListnerEAS_AS_FM_PROD_CODE(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		int M_FIELD_LENGTH = 0;
		String M_FIELD_DATA = "";
		String M_DATA_TYPE = "String";
		if ((String) getCOMP_EAS_AS_FM_PROD_CODE().getSubmittedValue() == "") {
			Map attributes = getCOMP_EAS_AS_FM_PROD_CODE().getAttributes();
			M_FIELD_LENGTH = ((Integer) attributes.get("maxlength"));
			if (M_DATA_TYPE.equalsIgnoreCase("String")
					|| M_DATA_TYPE.equalsIgnoreCase("int")) {
				M_FIELD_DATA = "0";
			}
			getCOMP_EAS_AS_FM_PROD_CODE().setSubmittedValue(M_FIELD_DATA);
		}
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validateEAS_AS_FM_PROD_CODE(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try {
			// :PM_IL_END_APPR_SETUP.EAS_AS_FM_PROD_CODE :=:PM_IL_END_APPR_SETUP.EAS_AS_FM_PROD_CODE;
			PM_IL_END_APPR_SETUP_BEAN.setEAS_AS_FM_PROD_CODE((String)value);
			String FM_PROD_CODE_DESC = L_VAL_PROD(PM_IL_END_APPR_SETUP_BEAN
					.getEAS_AS_FM_PROD_CODE());
			PM_IL_END_APPR_SETUP_BEAN
					.setEAS_AS_FM_PROD_CODE_DESC(FM_PROD_CODE_DESC);
			if(PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_TO_PROD_CODE() != null){
				if(PM_IL_END_APPR_SETUP_BEAN
						.getEAS_AS_FM_PROD_CODE().compareTo(PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_TO_PROD_CODE()) > 0 ){
					throw new Exception("Start value can not greater then end value");
				}
			}
			COMP_EAS_AS_FM_PROD_CODE_DESC.setSubmittedValue(FM_PROD_CODE_DESC);
		} catch (Exception e) {
			COMP_EAS_AS_FM_PROD_CODE_DESC.setSubmittedValue("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListnerEAS_AS_TO_PROD_CODE(ActionEvent ae) {
		System.out.println("The value of EAS_AS_TO_PROD_COD code is: "
				+ (getCOMP_EAS_AS_TO_PROD_CODE().getSubmittedValue()));
		int M_FIELD_LENGTH = -1;
		String M_DATA_TYPE = "String", M_FIELD_DATA = "";
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
																	// comp

		if ("".equals(((String) (getCOMP_EAS_AS_TO_PROD_CODE()
				.getSubmittedValue())).trim())) {

			Map attributes = getCOMP_EAS_AS_TO_PROD_CODE().findComponent(
					"PM_IL_END_APPR_SETUP:EAS_AS_TO_PROD_CODE").getAttributes();

			M_FIELD_LENGTH = ((Integer) attributes.get("maxlength"));
			if (M_DATA_TYPE.equalsIgnoreCase("String")
					|| M_DATA_TYPE.equalsIgnoreCase("int")) {
				M_FIELD_DATA = "0";
			}
			if (M_DATA_TYPE.equalsIgnoreCase("String")) {

				if (((String) (getCOMP_EAS_AS_FM_PROD_CODE()).getSubmittedValue())
						.trim().equalsIgnoreCase(M_FIELD_DATA.trim())) {
					System.out.println("***********"+M_FIELD_LENGTH);
					M_FIELD_DATA = "zzzzzzzzzzzzzzzzzzzzzz".substring(0,
							M_FIELD_LENGTH);
					getCOMP_EAS_AS_TO_PROD_CODE().setSubmittedValue(
							M_FIELD_DATA);

				} else if (M_DATA_TYPE.equalsIgnoreCase("String")) {

					getCOMP_EAS_AS_TO_PROD_CODE().setSubmittedValue(
							getCOMP_EAS_AS_FM_PROD_CODE().getSubmittedValue());
				}
			} else if (M_DATA_TYPE.equalsIgnoreCase("int")) {
				if (Integer.parseInt(((String) (getCOMP_EAS_FM_END_CODE())
						.getSubmittedValue())) == Integer
						.parseInt(M_FIELD_DATA)) {
					M_FIELD_DATA = "9999999999999999999999".substring(0,
							M_FIELD_LENGTH);
					getCOMP_EAS_AS_TO_PROD_CODE().setSubmittedValue(
							M_FIELD_DATA);
				} else {
					getCOMP_EAS_AS_TO_PROD_CODE().setSubmittedValue(
							(getCOMP_EAS_FM_END_CODE()).getSubmittedValue());
				}
			}
			PM_IL_END_APPR_SETUP_BEAN
					.setEAS_AS_TO_PROD_CODE((String) getCOMP_EAS_AS_TO_PROD_CODE()
							.getSubmittedValue());
			//return;
		} else {

			M_FIELD_DATA = ((String) (getCOMP_EAS_AS_TO_PROD_CODE())
					.getSubmittedValue());

			getCOMP_EAS_AS_TO_PROD_CODE().setSubmittedValue(M_FIELD_DATA);

		}
		PM_IL_END_APPR_SETUP_BEAN.setEAS_AS_TO_PROD_CODE(getCOMP_EAS_AS_TO_PROD_CODE().getSubmittedValue().toString());
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());

	}

	public void validateEAS_AS_TO_PROD_CODE(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try {
			// :PM_IL_END_APPR_SETUP.EAS_AS_TO_PROD_CODE := :PM_IL_END_APPR_SETUP.EAS_AS_TO_PROD_CODE;
			//PM_IL_END_APPR_SETUP_BEAN.setEAS_AS_TO_PROD_CODE(getCOMP_EAS_AS_TO_PROD_CODE().getSubmittedValue().toString());
			String TO_PROD_CODE_DESC = L_VAL_PROD(PM_IL_END_APPR_SETUP_BEAN
					.getEAS_AS_TO_PROD_CODE());
			PM_IL_END_APPR_SETUP_BEAN
					.setEAS_AS_TO_PROD_CODE_DESC(TO_PROD_CODE_DESC);
			if(PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_FM_PROD_CODE() != null){
				if(PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_FM_PROD_CODE().compareTo(PM_IL_END_APPR_SETUP_BEAN
					.getEAS_AS_TO_PROD_CODE()) > 0 ){
					throw new Exception("Start value can not be greater teh end value ");
				}
			}
			COMP_EAS_AS_TO_PROD_CODE_DESC.setSubmittedValue(TO_PROD_CODE_DESC);
		} catch (Exception e) {
			COMP_EAS_AS_TO_PROD_CODE_DESC.setSubmittedValue("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListnerEAS_FM_END_CODE(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		int M_FIELD_LENGTH = 0;
		String M_FIELD_DATA = "";
		String M_DATA_TYPE = "String";
		if ((String) getCOMP_EAS_FM_END_CODE().getSubmittedValue() == "") {
			Map attributes = getCOMP_EAS_FM_END_CODE().getAttributes();
			M_FIELD_LENGTH = ((Integer) attributes.get("maxlength"));
			if (M_DATA_TYPE.equalsIgnoreCase("String")
					|| M_DATA_TYPE.equalsIgnoreCase("int")) {
				M_FIELD_DATA = "0";
			}
			getCOMP_EAS_FM_END_CODE().setSubmittedValue(M_FIELD_DATA);
		}
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validateEAS_FM_END_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		ResultSet rs = null;
		Connection con = null;
		try {
				con = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				PM_IL_END_APPR_SETUP_BEAN
				.setEAS_FM_END_CODE(value.toString());
				rs = handler
						.executeSelectStatement(
								PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$POST_QUERY_C2,
								con, new Object[] { PM_IL_END_APPR_SETUP_BEAN
										.getEAS_FM_END_CODE() });
				while (rs.next()) {
					PM_IL_END_APPR_SETUP_BEAN.setEAS_FM_END_CODE_DESC(rs
							.getString(1));
					COMP_EAS_FM_END_CODE_DESC.setSubmittedValue(rs.getString(1));
				}
				if(PM_IL_END_APPR_SETUP_BEAN.getEAS_TO_END_CODE() != null){
					if(PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE().compareTo(PM_IL_END_APPR_SETUP_BEAN.getEAS_TO_END_CODE()) > 0 ){
						throw new Exception("Start value can not be greater then end value");
					}
				}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListnerEAS_TO_END_CODE(ActionEvent ae) {
		System.out.println("The value of EAS_TO_END_CODE is: "
				+ (getCOMP_EAS_TO_END_CODE().getSubmittedValue()));
		int M_FIELD_LENGTH = -1;
		String M_DATA_TYPE = "String", M_FIELD_DATA = "";
		UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
																	// comp

		if (""
				.equals(((String) (getCOMP_EAS_TO_END_CODE()
						.getSubmittedValue())).trim())) {

			Map attributes = getCOMP_EAS_TO_END_CODE().findComponent(
					"PM_IL_END_APPR_SETUP:EAS_TO_END_CODE").getAttributes();

			M_FIELD_LENGTH = ((Integer) attributes.get("maxlength"));
			if (M_DATA_TYPE.equalsIgnoreCase("String")
					|| M_DATA_TYPE.equalsIgnoreCase("int")) {
				M_FIELD_DATA = "0";
			}
			if (M_DATA_TYPE.equalsIgnoreCase("String")) {

				if (((String) (getCOMP_EAS_FM_END_CODE()).getSubmittedValue())
						.trim().equalsIgnoreCase(M_FIELD_DATA.trim())) {					
					M_FIELD_DATA = "zzzzzzzzzzzzzzzzzzzzzz".substring(0,
							M_FIELD_LENGTH);
					getCOMP_EAS_TO_END_CODE().setSubmittedValue(M_FIELD_DATA);

				} else if (M_DATA_TYPE.equalsIgnoreCase("String")) {

					getCOMP_EAS_TO_END_CODE().setSubmittedValue(
							getCOMP_EAS_FM_END_CODE().getSubmittedValue());
				}
			} else if (M_DATA_TYPE.equalsIgnoreCase("int")) {
				if (Integer.parseInt(((String) (getCOMP_EAS_FM_END_CODE())
						.getSubmittedValue())) == Integer
						.parseInt(M_FIELD_DATA)) {
					M_FIELD_DATA = "9999999999999999999999".substring(0,
							M_FIELD_LENGTH);
					getCOMP_EAS_TO_END_CODE().setSubmittedValue(M_FIELD_DATA);
				} else {
					getCOMP_EAS_TO_END_CODE().setSubmittedValue(
							(getCOMP_EAS_FM_END_CODE()).getSubmittedValue());
				}
			}
			PM_IL_END_APPR_SETUP_BEAN
					.setEAS_TO_END_CODE((String) getCOMP_EAS_TO_END_CODE()
							.getSubmittedValue());
			//return;
		} else {

			M_FIELD_DATA = ((String) (getCOMP_EAS_TO_END_CODE())
					.getSubmittedValue());

			getCOMP_EAS_TO_END_CODE().setSubmittedValue(M_FIELD_DATA);

		}
		PM_IL_END_APPR_SETUP_BEAN
		.setEAS_TO_END_CODE(getCOMP_EAS_TO_END_CODE().getSubmittedValue().toString());
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());

	}

	public void validateEAS_TO_END_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		ResultSet rs = null;
		Connection con = null;
		try {
				con = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				//PM_IL_END_APPR_SETUP_BEAN
				//.setEAS_TO_END_CODE(getCOMP_EAS_TO_END_CODE().getSubmittedValue().toString());
				rs = handler
						.executeSelectStatement(
								PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$POST_QUERY_C3,
								con, new Object[] { PM_IL_END_APPR_SETUP_BEAN
										.getEAS_TO_END_CODE() });
				while (rs.next()) {
					PM_IL_END_APPR_SETUP_BEAN.setEAS_TO_END_CODE_DESC(rs
							.getString(1));
					COMP_EAS_TO_END_CODE_DESC.setSubmittedValue(rs.getString(1));
				}
				if(PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE() != null){
					if(PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE().compareTo(PM_IL_END_APPR_SETUP_BEAN.getEAS_TO_END_CODE()) > 0 ){
						throw new Exception("Start value can not be greater then end value");
					}
				}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void listChangedEAS_END_PROC_YN(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		System.out.println("lIST cHANGED cALLED"+COMP_EAS_END_APPR_YN.getValue());
		try {

			if (COMP_EAS_END_APPR_YN.getValue() != ""
					&& COMP_EAS_END_APPR_YN.getValue().toString()
							.equalsIgnoreCase("Y")&& PM_IL_END_APPR_SETUP_BEAN.getEAS_END_APPR_YN().equalsIgnoreCase("Y")) {
				PM_IL_END_APPR_SETUP_BEAN.setEAS_END_PROC_YN("Y");
				COMP_EAS_END_PROC_YN.setSubmittedValue("Y");
				getWarningMap().put(
						"current",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"3206",new Object[]{"Endt Process cannot be NO when Endt Approval flag is YES"}).getSummary());
				getWarningMap().put(
						input.getClientId(FacesContext.getCurrentInstance()),
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"3206",new Object[]{"Endt Process cannot be NO when Endt Approval flag is YES"}).getSummary());
				return;
			} else {
				getWarningMap().remove("current");
				getWarningMap().remove(
						input.getClientId(FacesContext.getCurrentInstance()));
			}

		} catch (Exception e) {

		}
	}

	public void validateEAS_END_PROC_YN(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			System.out.println("COMP_EAS_END_APPR_YN.getSubmittedValue()"+COMP_EAS_END_APPR_YN.getValue());
			if (COMP_EAS_END_APPR_YN.getValue() != null
					&& COMP_EAS_END_APPR_YN.getValue().toString()
							.equalsIgnoreCase("Y") && PM_IL_END_APPR_SETUP_BEAN.getEAS_END_APPR_YN().equalsIgnoreCase("Y")) {
				PM_IL_END_APPR_SETUP_BEAN.setEAS_END_PROC_YN("Y");
				COMP_EAS_END_PROC_YN.setSubmittedValue("Y");
			}

		} catch (Exception e) {
			throw e;
		}
	}

	public void listChangedEAS_END_APPR_YN(ActionEvent event) {

		UIInput input = (UIInput) event.getComponent().getParent();
		try {

			if (input.getSubmittedValue() != ""
					&& input.getSubmittedValue().toString().equalsIgnoreCase(
							"Y")) {
				PM_IL_END_APPR_SETUP_BEAN.setEAS_END_APPR_YN("Y");
				PM_IL_END_APPR_SETUP_BEAN.setEAS_END_PROC_YN("Y");
				COMP_EAS_END_PROC_YN.setSubmittedValue("Y");
				System.out.println("COMP_EAS_END_PROC_YN"+COMP_EAS_END_PROC_YN.getSubmittedValue());
			}

		} catch (Exception e) {

		}
	}
	
	public void actionListnerEAS_END_APPR_YN(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		PM_IL_END_APPR_SETUP_BEAN.setEAS_END_APPR_YN(input.getSubmittedValue().toString());
		boolean flag =callP_CHK_DUPL_END_SETUP();
		 System.out.println("validateEAS_END_APPR_YN"+flag);
			if (flag){					
				getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath, "80031").getSummary());
				getErrorMap().put(COMP_EAS_END_APPR_YN.getClientId(FacesContext.getCurrentInstance()), Messages.getMessage(PELConstants.pelErrorMessagePath, "80031").getSummary());
			}else{
				getErrorMap().remove("current");
				getErrorMap().remove(COMP_EAS_END_APPR_YN.getClientId(FacesContext.getCurrentInstance()));
			}
	}
	
	public void validateEAS_END_APPR_YN(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {			 
			 boolean flag =callP_CHK_DUPL_END_SETUP();
			 System.out.println("validateEAS_END_APPR_YN"+flag);
				if (flag){					
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "80031"));
				}
					
		} catch (Exception e) {
			throw e;
		}
	}

	public Map getSession() {
		Map sessionMap = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		return sessionMap;
	}

	public List lovEAS_AS_USER_ID(Object obj) throws Exception {
		ResultSet resultSet = null;
		ArrayList suggesionList = new ArrayList();
		try {
			Vector objVector = new Vector();
			String query = "";
			if (obj.toString().equals("*")) {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_AS_USER_ID_QUERY_STAR;
			} else {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_AS_USER_ID_QUERY_SEARCH;
				objVector
						.add(obj + "%");
			}
			Object[] objects = (Object[]) objVector.toArray();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, CommonUtils
					.getConnection(), objects);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setCode(resultSet.getString(1));
				bean.setName(resultSet.getString(2));
				suggesionList.add(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return suggesionList;
	}

	public List lovEAS_AS_FM_PROD_CODE(Object obj) throws Exception {
		ResultSet resultSet = null;
		ArrayList suggesionList = new ArrayList();
		try {
			Vector objVector = new Vector();
			String query = "";
			if (obj.toString().equals("*")) {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_AS_FM_PROD_CODE_QUERY_STAR;
			} else {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_AS_FM_PROD_CODE_QUERY_SEARCH;
				objVector
						.add(obj + "%");
			}
			Object[] objects = (Object[]) objVector.toArray();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, CommonUtils
					.getConnection(), objects);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setCode(resultSet.getString(1));
				bean.setName(resultSet.getString(2));
				suggesionList.add(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return suggesionList;
	}

	public List lovEAS_FM_END_CODE(Object obj) throws Exception {
		ResultSet resultSet = null;
		ArrayList suggesionList = new ArrayList();
		try {
			Vector objVector = new Vector();
			String query = "";
			if (obj.toString().equals("*")) {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_FM_END_CODE_QUERY_STAR;
			} else {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_FM_END_CODE_QUERY_SEARCH;
				objVector
						.add(obj + "%");
			}
			Object[] objects = (Object[]) objVector.toArray();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, CommonUtils
					.getConnection(), objects);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setCode(resultSet.getString(1));
				bean.setName(resultSet.getString(2));
				suggesionList.add(bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return suggesionList;
	}

	public void postQuery() {
		ResultSet rs = null;
		Connection con = null;
		try {
			System.out.println("POST USER ID"+PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_USER_ID());
			con = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			rs = handler
					.executeSelectStatement(
							PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$POST_QUERY_C1,
							con, new Object[] { PM_IL_END_APPR_SETUP_BEAN
									.getEAS_AS_USER_ID() });
			while (rs.next()) {
				PM_IL_END_APPR_SETUP_BEAN.setUSER_GROUP_ID(rs.getString(1));
				//COMP_USER_GROUP_ID.setSubmittedValue(rs.getString(1));
			}
			rs = handler
					.executeSelectStatement(
							PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$POST_QUERY_C2,
							con, new Object[] { PM_IL_END_APPR_SETUP_BEAN
									.getEAS_FM_END_CODE() });
			while (rs.next()) {
				PM_IL_END_APPR_SETUP_BEAN.setEAS_FM_END_CODE_DESC(rs
						.getString(1));
				//COMP_EAS_FM_END_CODE_DESC.setSubmittedValue(rs.getString(1));
			}
			rs = handler
					.executeSelectStatement(
							PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$POST_QUERY_C3,
							con, new Object[] { PM_IL_END_APPR_SETUP_BEAN
									.getEAS_TO_END_CODE() });
			while (rs.next()) {
				PM_IL_END_APPR_SETUP_BEAN.setEAS_TO_END_CODE_DESC(rs
						.getString(1));
				//COMP_EAS_TO_END_CODE_DESC.setSubmittedValue(rs.getString(1));
			}
			String FM_PROD_CODE_DESC = L_VAL_PROD(PM_IL_END_APPR_SETUP_BEAN
					.getEAS_AS_FM_PROD_CODE());
			PM_IL_END_APPR_SETUP_BEAN
					.setEAS_AS_FM_PROD_CODE_DESC(FM_PROD_CODE_DESC);
			//COMP_EAS_AS_FM_PROD_CODE_DESC.setSubmittedValue(FM_PROD_CODE_DESC);
			String TO_PROD_CODE_DESC = L_VAL_PROD(PM_IL_END_APPR_SETUP_BEAN
					.getEAS_AS_TO_PROD_CODE());
			PM_IL_END_APPR_SETUP_BEAN
					.setEAS_AS_TO_PROD_CODE_DESC(TO_PROD_CODE_DESC);
			//COMP_EAS_AS_TO_PROD_CODE_DESC.setSubmittedValue(TO_PROD_CODE_DESC);
			ArrayList<String> descList = callP_VAL_USER_ID(
					PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_USER_ID(), "E");
			PM_IL_END_APPR_SETUP_BEAN.setUI_M_USER_DESC(descList.get(0));
			System.out.println("iN pOST qUERY"+PM_IL_END_APPR_SETUP_BEAN.getUI_M_USER_DESC());
			//COMP_UI_M_USER_DESC.setSubmittedValue(descList.get(0));
			PM_IL_END_APPR_SETUP_BEAN.setUSER_GROUP_ID(descList.get(1));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con,
					FacesContext.getCurrentInstance(), "PostQuery",
					getErrorMap(), getWarningMap());
		}

	}

	public boolean preInsert() throws Exception {

		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Connection con = null;
		String M_PS_CODE;   
		String M_PS_VALUE;
		int M_P9IL_ESD_SYS_ID = 0;
		boolean flag = false;
		try {

			con = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			
			flag =callP_CHK_DUPL_END_SETUP();
			if (flag){
				getErrorMap().put("current",Messages.getMessage(PELConstants.pelErrorMessagePath, "80031").getSummary());
				getErrorMap().put("preInsert",Messages.getMessage(PELConstants.pelErrorMessagePath, "80031").getSummary());
				return flag;
			}else{
				getErrorMap().remove("current");
				getErrorMap().remove("preInsert");
			}
			PM_IL_END_APPR_SETUP_BEAN.setEAS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			PM_IL_END_APPR_SETUP_BEAN.setEAS_CR_DT(new Date(Calendar.getInstance().getTimeInMillis()));
			rs = handler.executeSelectStatement(
							PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$PRE_INSERT_C1,
							con);
			System.out.println("Result Size In PRE inSERT");
			rs1 = handler.executeSelectStatement(
					PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$PRE_INSERT_C2,
					con);
			while (rs1.next()) {
				PM_IL_END_APPR_SETUP_BEAN.setEAS_SYS_ID(rs1.getInt(1));
			}
			while (rs.next()) {
				M_PS_CODE = rs.getString("PS_CODE");
				System.out.println("PS_CODE in pRE insert"+M_PS_CODE);
				M_PS_VALUE = rs.getString("PS_VALUE");
				System.out.println("PS_CODE in pRE insert"+M_PS_VALUE);
				rs2 = handler
						.executeSelectStatement(
								PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$PRE_INSERT_C3,
								con);
				while (rs2.next()) {
					M_P9IL_ESD_SYS_ID = rs2.getInt(1);
				}
				
				System.out.println("Before calling Insert In to DTLS");
				int i = handler
						.executeInsertStatement(
								PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$PRE_INSERT_ins1,
								con, new Object[] {
										M_P9IL_ESD_SYS_ID,
										PM_IL_END_APPR_SETUP_BEAN
												.getEAS_SYS_ID(),
										PM_IL_END_APPR_SETUP_BEAN
												.getEAS_AS_USER_ID(),
										M_PS_CODE,
										M_PS_VALUE,
										CommonUtils.getControlBean()
												.getM_USER_ID(),
										PM_IL_END_APPR_SETUP_BEAN
												.getEAS_AS_FM_PROD_CODE(),
										PM_IL_END_APPR_SETUP_BEAN
												.getEAS_AS_TO_PROD_CODE() });
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public void preUpdate() {
		ResultSet rs = null;
		Connection con = null;
		try {

			con = CommonUtils.getConnection();
			PM_IL_END_APPR_SETUP_BEAN.setEAS_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PM_IL_END_APPR_SETUP_BEAN.setEAS_UPD_DT(new Date(Calendar
					.getInstance().getTimeInMillis()));
			CRUDHandler handler = new CRUDHandler();
			String FM_END_CODE = PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE();
			String TO_END_CODE = PM_IL_END_APPR_SETUP_BEAN.getEAS_TO_END_CODE();
			String FM_PROD_CODE = PM_IL_END_APPR_SETUP_BEAN
					.getEAS_AS_FM_PROD_CODE();
			String TO_PROD_CODE = PM_IL_END_APPR_SETUP_BEAN
					.getEAS_AS_TO_PROD_CODE();
			rs = handler
					.executeSelectStatement(
							PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$PRE_UPDATE_C1,
							con, new Object[] {
									FM_END_CODE,
									TO_END_CODE,
									FM_END_CODE,
									TO_END_CODE,
									FM_END_CODE,
									TO_END_CODE,
									FM_PROD_CODE,
									TO_PROD_CODE,
									FM_PROD_CODE,
									TO_PROD_CODE,
									FM_PROD_CODE,
									TO_PROD_CODE,
									PM_IL_END_APPR_SETUP_BEAN
											.getEAS_AS_USER_ID(),
									PM_IL_END_APPR_SETUP_BEAN.getROWID(),
									PM_IL_END_APPR_SETUP_BEAN
											.getEAS_END_PROC_YN(),
									PM_IL_END_APPR_SETUP_BEAN
											.getEAS_END_APPR_YN() });
			if (rs.next()) {
				getErrorMap().put(
						"current",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"80031").getSummary());
				getErrorMap().put(
						"preupdate",
						Messages.getMessage(PELConstants.pelErrorMessagePath,
								"80031").getSummary());
				return;
			} else {
				getErrorMap().remove("current");
				getErrorMap().remove("preupdate");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void whenCreateRecord() {
		PM_IL_END_APPR_SETUP_BEAN.setEAS_END_PROC_YN("N");
		COMP_EAS_END_PROC_YN.setSubmittedValue("N");
		PM_IL_END_APPR_SETUP_BEAN.setEAS_END_APPR_YN("N");
		COMP_EAS_END_APPR_YN.setSubmittedValue("N");
	}

	public void loadingBaseValues(PhaseEvent event ) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, Object> session = fc.getExternalContext().getSessionMap();
		if(event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
		if(session.get("PILM075_APAC_FORM") == null) {
			preformPILM075_APAC();
			session.put("PILM075_APAC_FORM","true");
		} 
		}
		if(isBlockFlag()){
			getErrorMap().clear();
			getWarningMap().clear();
			setBlockFlag(false);
		}
	}
	public void onLoad(PhaseEvent ae) {
		
		PILM075_APAC_DELEGATE delegate = new PILM075_APAC_DELEGATE();
		try {
			if(isBlockFlag()){
				 CommonUtils.clearMaps(this);
				if (PM_IL_END_APPR_SETUP_BEAN.getROWID() != null) {
					setPM_IL_END_APPR_SETUP_BEAN(delegate.fetchClassMasterDetails());
					postQuery();
				}
				setBlockFlag(false);
			}
				

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}


	public List<SelectItem> getEndtProcessList() {
		
		if (endtProcessList.size() ==0){
			endtProcessList.clear();				
			Connection con;
			try {
				con = CommonUtils.getConnection();
				endtProcessList = ListItemUtil.getDropDownListValue(con, "PILM075_APAC", "PM_IL_END_APPR_SETUP", "PM_IL_END_APPR_SETUP.EAS_END_PROC_YN", "YESNO");
			} catch (Exception e) {
				
			}
		}
		return endtProcessList;
	}

	public void setEndtProcessList(List<SelectItem> endtProcessList) {
		this.endtProcessList = endtProcessList;
	}

	public List<SelectItem> getEndtApprovalList() {
		if (endtApprovalList.size() ==0){
			endtApprovalList.clear();				
			Connection con;
			try {
				con = CommonUtils.getConnection();
				endtApprovalList = ListItemUtil.getDropDownListValue(con, "PILM075_APAC", "PM_IL_END_APPR_SETUP", "PM_IL_END_APPR_SETUP.EAS_END_APPR_YN", "YESNO");
			} catch (Exception e) {
				
			}
		}
		return endtApprovalList;
	}

	public void setEndtApprovalList(List<SelectItem> endtApprovalList) {
		this.endtApprovalList = endtApprovalList;
	}
	
	private ArrayList<String> callP_VAL_USER_ID(String P_USER_ID,
			String P_ERR_FLAG) throws SQLException, Exception {
		Connection connection = null;
		CommonUtils commonUtils = new CommonUtils();
		connection = commonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_USER_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in1", "STRING", "OUT",
				P_USER_ID);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("in1", "STRING", "OUT",
				P_USER_ID);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("in2", "STRING", "IN",
				P_ERR_FLAG);
		parameterList.add(param4);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"P_VAL_USER_ID");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				returnList.add(oracleParameter.getValue());
			}
		}
		return returnList;
	}
	
	public String saveMethod() {
		CRUDHandler handler = new CRUDHandler();
		int rowStatus = 0;
		String message = null;
		try {
			if (!saveExecuted){
				if (PM_IL_END_APPR_SETUP_BEAN.getROWID() == null) {
					boolean flag=preInsert();
					if (flag){
						return "";
					}
					rowStatus = handler.executeInsert(PM_IL_END_APPR_SETUP_BEAN, CommonUtils
							.getConnection());
					if (rowStatus > 0) {
						getErrorMap().clear();
						/*getWarningMap().put("somekey",
								rowStatus + " record inserted.");
						getWarningMap().put("current",
								rowStatus + " record inserted.");*/
						message=Messages.getString(PELConstants.pelMessagePropertiesPath, 
								"errorPanel$message$save");
						getWarningMap().put("current", message);
						getWarningMap().put("save",
								Messages.getString(PELConstants.pelMessagePropertiesPath, 
										"errorPanel$message$save"));
					}
	
				} else {
					preUpdate();
					rowStatus = handler.executeUpdate(PM_IL_END_APPR_SETUP_BEAN, CommonUtils
							.getConnection());
					if (rowStatus > 0) {
						getErrorMap().clear();
						/*getWarningMap().put("somekey",
								rowStatus + " record updated.");
						getWarningMap().put("current",
								rowStatus + " record updated.");*/
						message=Messages.getString(PELConstants.pelMessagePropertiesPath, 
						"errorPanel$message$update");
				getWarningMap().put("current", message);
				getWarningMap().put("save",
						Messages.getString(PELConstants.pelMessagePropertiesPath, 
								"errorPanel$message$update"));
					}
	
				}
				saveExecuted=true;
				CommonUtils.getConnection().commit();
			}
		} catch (Exception er) {			
			getErrorMap().put("current",er.getLocalizedMessage());
		}
		return "";
	}
	
	public String saveNextMethod() {
		CRUDHandler handler = new CRUDHandler();
		int rowStatus = 0;
		try {
			if (!saveExecuted){
			if (PM_IL_END_APPR_SETUP_BEAN.getROWID() == null) {
				boolean flag =preInsert();
				if (flag)
				{
					return"";
				}
				rowStatus = handler.executeInsert(PM_IL_END_APPR_SETUP_BEAN, CommonUtils
						.getConnection());
				if (rowStatus > 0) {
					getErrorMap().clear();
					getWarningMap().put("somekey",
							rowStatus + " record inserted.");
					getWarningMap().put("current",
							rowStatus + " record inserted.");
				}
			} else {
				preUpdate();
				rowStatus = handler.executeUpdate(PM_IL_END_APPR_SETUP_BEAN, CommonUtils
						.getConnection());
				if (rowStatus > 0) {
					getErrorMap().clear();
					getWarningMap().put("somekey",
							rowStatus + " record updated.");
					getWarningMap().put("current",
							rowStatus + " record updated.");
				}
			}
			saveExecuted=true;
			CommonUtils.getConnection().commit();
		}
		} catch (Exception er) {
			er.printStackTrace();
		}
		return "PILM075_APAC_PM_IL_END_SETUP_DET1";
	}
	
	private boolean callP_CHK_DUPL_END_SETUP(){		
			ResultSet rs = null;			
			Connection con = null;	
			boolean flag = false;
			try {

				con = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				String FM_END_CODE = PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE();
				String TO_END_CODE = PM_IL_END_APPR_SETUP_BEAN.getEAS_TO_END_CODE();
				String FM_PROD_CODE = PM_IL_END_APPR_SETUP_BEAN
						.getEAS_AS_FM_PROD_CODE();
				String TO_PROD_CODE = PM_IL_END_APPR_SETUP_BEAN
						.getEAS_AS_TO_PROD_CODE();
				System.out.println("FM_END_CODE"+FM_END_CODE);
				System.out.println("TO_END_CODE"+TO_END_CODE);
				System.out.println("FM_PROD_CODE"+FM_PROD_CODE);
				System.out.println("TO_PROD_CODE"+TO_PROD_CODE);
				System.out.println("EAS_AS_USER_ID"+PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_USER_ID());
				rs = handler.executeSelectStatement(
								PILM075_APAC_SQL_CONSTANTS.P_CHK_DUPL_END_SETUP$C1,
								con, new Object[]{
										FM_END_CODE,
										TO_END_CODE,
										FM_END_CODE,
										TO_END_CODE,
										FM_END_CODE,
										TO_END_CODE,
										FM_PROD_CODE,
										TO_PROD_CODE,
										FM_PROD_CODE,
										TO_PROD_CODE,
										FM_PROD_CODE,
										TO_PROD_CODE,
										PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_USER_ID()});
				while (rs.next()){
					flag = true;
				}
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	public boolean isUserIDDisable() {
		return userIDDisable;
	}

	public void setUserIDDisable(boolean userIDDisable) {
		this.userIDDisable = userIDDisable;
	}
	
	
	/* [BugId:PREMIAGDC-000069 Deepika 25-Feb-09 Newly added method for Copy Button action */	
	public String copyButtonAction()
	{
		PM_IL_END_APPR_COPY_ACTION pm_il_end_appr_copy_action = new PM_IL_END_APPR_COPY_ACTION();
		HttpSession session = new CommonUtils().getSession();
		session.setAttribute("PILM075_APAC_PM_IL_END_APPR_COPY_ACTION", pm_il_end_appr_copy_action);
		CommonUtils.setGlobalObject("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION", this);
		pm_il_end_appr_copy_action.getPM_IL_END_APPR_COPY_BEAN().setEAS_AS_USER_ID(PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_USER_ID());
		pm_il_end_appr_copy_action.getPM_IL_END_APPR_COPY_BEAN().setUI_M_USER_DESC(PM_IL_END_APPR_SETUP_BEAN.getUI_M_USER_DESC());
		pm_il_end_appr_copy_action.getPM_IL_END_APPR_COPY_BEAN().setEAS_AS_FM_PROD_CODE(PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_FM_PROD_CODE());
		pm_il_end_appr_copy_action.getPM_IL_END_APPR_COPY_BEAN().setEAS_AS_FM_PROD_CODE_DESC(PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_FM_PROD_CODE_DESC());
		pm_il_end_appr_copy_action.getPM_IL_END_APPR_COPY_BEAN().setEAS_AS_TO_PROD_CODE(PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_TO_PROD_CODE());
		pm_il_end_appr_copy_action.getPM_IL_END_APPR_COPY_BEAN().setEAS_AS_TO_PROD_CODE_DESC(PM_IL_END_APPR_SETUP_BEAN.getEAS_AS_TO_PROD_CODE_DESC());
		pm_il_end_appr_copy_action.getPM_IL_END_APPR_COPY_BEAN().setEAS_FM_END_CODE(PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE());
		pm_il_end_appr_copy_action.getPM_IL_END_APPR_COPY_BEAN().setEAS_FM_END_CODE_DESC(PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE_DESC());
		pm_il_end_appr_copy_action.getPM_IL_END_APPR_COPY_BEAN().setEAS_TO_END_CODE(PM_IL_END_APPR_SETUP_BEAN.getEAS_TO_END_CODE());
		pm_il_end_appr_copy_action.getPM_IL_END_APPR_COPY_BEAN().setEAS_TO_END_CODE_DESC(PM_IL_END_APPR_SETUP_BEAN.getEAS_TO_END_CODE_DESC());
		
		return "copyAction";
	}
	
	/* BugId:PREMIAGDC-000069 Deepika 25-Feb-09 Newly added method for Copy Button action ]*/
//added for delete button	
	public String deleteRow(){
		try{
			//String livCode = null;
			
			if (isDELETE_ALLOWED()){
				/*livCode = (String) compositeAction.getPP_LIST_ITEM_VALUES_ACTION_BEAN()
				.getPP_LIST_ITEM_VALUES_BEAN().getLIV_CODE();*/
				//helper.key_delrec(PM_IL_TAR_HDR_BEAN, livCode);
				
				new CRUDHandler().executeDelete(PM_IL_END_APPR_SETUP_BEAN,CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				// Resetting the screen after delete
				
				PM_IL_END_APPR_SETUP_ACTION PM_IL_END_APPR_SETUP_ACTION_BEAN=new PM_IL_END_APPR_SETUP_ACTION();
				CommonUtils.setGlobalObject("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION", PM_IL_END_APPR_SETUP_ACTION_BEAN);
				
				// Assigning message to new action class
				PM_IL_END_APPR_SETUP_ACTION_BEAN.getWarningMap().put(
						"deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				PM_IL_END_APPR_SETUP_ACTION_BEAN.getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
			}else{
				getErrorMap().put("deleteRow",Messages.getString(PELConstants.
						pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
			}
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}
		return "";
	}

	
	public String L_VAL_PROD(String PROD_CODE) throws Exception {
		String M_PROD_DESC = null;
		String C1 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
		Connection connection;
		ResultSet resultSet = null;
		CRUDHandler handler;
		try {
			connection = CommonUtils.getConnection();
		handler = new CRUDHandler();
		resultSet = handler.executeSelectStatement(C1, connection, new Object[]{PROD_CODE});
		if(resultSet.next()){
			M_PROD_DESC = resultSet.getString(1);
		}
		if(M_PROD_DESC == null && (!"0".equals(PROD_CODE) || !"zzzzzzzzzzzz".equals(PROD_CODE))){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "19046"));
		}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} 
		return M_PROD_DESC;
	}

	
}
