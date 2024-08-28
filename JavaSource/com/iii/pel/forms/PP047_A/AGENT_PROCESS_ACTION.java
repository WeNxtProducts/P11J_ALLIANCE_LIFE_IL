package com.iii.pel.forms.PP047_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class AGENT_PROCESS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_AGT_FM_LABEL;

	private HtmlInputText COMP_UI_M_AGT_FM;

	private HtmlOutputLabel COMP_UI_M_AGT_TO_LABEL;

	private HtmlInputText COMP_UI_M_AGT_TO;

	private HtmlOutputLabel COMP_UI_M_PROCESS_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_PROCESS_TYPE;

	private HtmlOutputLabel COMP_UI_M_FREQ_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_FREQ;

	private HtmlOutputLabel COMP_UI_M_QUARTER_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_QUARTER_PERIOD;

	private HtmlOutputLabel COMP_UI_M_BEN_CON_FROM_LABEL;

	private HtmlInputText COMP_UI_M_BEN_CON_FROM;

	private HtmlOutputLabel COMP_UI_M_BEN_CON_TO_LABEL;

	private HtmlInputText COMP_UI_M_BEN_CON_TO;

	private HtmlOutputLabel COMP_UI_M_PROD_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PROD_FM_DT;

	private HtmlOutputLabel COMP_UI_M_PROD_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PROD_TO_DT;

	private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PROCESS_DT;
	
	/*Commented and modified by Janani on 18.06.2018 for KIC as per Sivaram's sugg */
	
	//private HtmlCommandButton COMP_M_BUTTON_OK;
		
	private HtmlAjaxCommandButton COMP_M_BUTTON_OK;

	/*End*/
	
	//PREMIAGDC-326708 BUTTON added VijayAnand 21-AUG-2009
	private HtmlCommandButton COMP_M_BUTTON_BONUS_APPROVAL;
	//PREMIAGDC-326708 BUTTON added VijayAnand 21-AUG-2009
	
	private AGENT_PROCESS AGENT_PROCESS_BEAN;

	private List agentFromList = new ArrayList();

	private List agentToList = new ArrayList();

	private List benConFromList = new ArrayList();

	private List benConToList = new ArrayList();

	private List<SelectItem> processTypeList = new ArrayList<SelectItem>();

	private List<SelectItem> frequencyList = new ArrayList<SelectItem>();

	private List<SelectItem> periodList = new ArrayList<SelectItem>();

	AGENT_PROCESS_DELEGATE delegate = new AGENT_PROCESS_DELEGATE();

	AGENT_PROCESS_HELPER helper = new AGENT_PROCESS_HELPER();
	
	private static final String DEFAULT_FROM_VALUE = "0";
	private static final String DEFAULT_TO_VALUE = "zzzzzzzzzzzz";

	public List agentFromAction(Object obj){
		String agentFrom = (String) obj;
		try {
			agentFromList.clear();
			agentFromList = delegate.agentFromAction(agentFrom, agentFromList);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("agentFromAction", e.getMessage());
		}
		return agentFromList;
	}

	public List agentToAction(Object obj){
		String agentFrom = (String) obj;
		try{
		agentToList = delegate.agentToAction(agentFrom, agentToList);
		if(agentToList.isEmpty() && agentFromList.size() == 0){
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "71103"));
		}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
		return agentToList;
	}
	
	public List conBenFromAction(Object object){
		String conBenFrom = (String) object;
		benConFromList  = delegate.conBenFromAction(conBenFrom, benConFromList,AGENT_PROCESS_BEAN);
		return benConFromList;
	}
	
	public List conBenToAction(Object object){
		String conBenFrom = (String) object;
		benConToList  = delegate.conBenToAction(conBenFrom, benConToList,AGENT_PROCESS_BEAN);
		return benConToList;
	}

	public void initializeComponents(){
		COMP_M_BUTTON_BONUS_APPROVAL = new HtmlCommandButton();
	
		/*Added by Janani on 18.06.2018 for KIC as per Sivaram's sugg */
		COMP_M_BUTTON_OK = new HtmlAjaxCommandButton();
		/*End*/
	}
	
	public AGENT_PROCESS_ACTION() {
		AGENT_PROCESS_BEAN = new AGENT_PROCESS();
		//PREMIAGDC-326708 Method added VijayAnand 21-AUG-2009
		initializeComponents();
		//PREMIAGDC-326708 Method added VijayAnand 21-AUG-2009
		ControlBean ctrlBean=CommonUtils.getControlBean();
		frequencyList = delegate.comboBoxValues("PP047_A", "AGENT_PROCESS","AGENT_PROCESS.M_FREQ", "PYMT_MODE");
		periodList = delegate.comboBoxValues("PP047_A", "AGENT_PROCESS","AGENT_PROCESS.M_QUARTER_PERIOD", "QUARTER_DEFN");
		processTypeList = delegate.comboBoxValues("PP047_A", "AGENT_PROCESS","AGENT_PROCESS.M_PROCESS_TYPE", "AGTPROCESS");
		PRE_FORM();
	}
	
	public void PRE_FORM(){
		COMP_M_BUTTON_BONUS_APPROVAL.setDisabled(true);
		if("M".equals(AGENT_PROCESS_BEAN.getUI_M_FREQ())){
			AGENT_PROCESS_BEAN.setUI_M_PROD_FM_DT(getFirstOfMonth());
		}
		String menuParam=CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		if("F".equalsIgnoreCase(menuParam)){
			AGENT_PROCESS_BEAN.setUI_M_PROCESS_TYPE("F");
			AGENT_PROCESS_BEAN.setUI_M_FREQ("Y");
			HtmlSelectOneMenu PROCESS_TYPE=new HtmlSelectOneMenu();
			PROCESS_TYPE.setDisabled(true);
			setCOMP_UI_M_PROCESS_TYPE(PROCESS_TYPE);
			HtmlSelectOneMenu QUARTER_PERIOD=new HtmlSelectOneMenu();
			QUARTER_PERIOD.setDisabled(true);
			setCOMP_UI_M_QUARTER_PERIOD(QUARTER_PERIOD);
			AGENT_PROCESS_BEAN.setLabelCaption(Messages.getString("messageProperties_PP047_A", "PP047_A$AGENT_PROCESS$BENEFIT$HEADING"));
			AGENT_PROCESS_BEAN.setFromFieldCaption(Messages.getString("messageProperties_PP047_A", "PP047_A$AGENT_PROCESS$UI_M_BEN_CON_FROM$caption"));
			AGENT_PROCESS_BEAN.setToFieldCaption(Messages.getString("messageProperties_PP047_A", "PP047_A$AGENT_PROCESS$UI_M_BEN_CON_TO$caption"));
		}else if("C".equalsIgnoreCase(menuParam)){
			AGENT_PROCESS_BEAN.setUI_M_PROCESS_TYPE("C");
			AGENT_PROCESS_BEAN.setUI_M_FREQ("Y");
			HtmlSelectOneMenu PROCESS_TYPE=new HtmlSelectOneMenu();
			PROCESS_TYPE.setDisabled(true);
			setCOMP_UI_M_PROCESS_TYPE(PROCESS_TYPE);
			HtmlSelectOneMenu QUARTER_PERIOD=new HtmlSelectOneMenu();
			QUARTER_PERIOD.setDisabled(true);
			setCOMP_UI_M_QUARTER_PERIOD(QUARTER_PERIOD);
			AGENT_PROCESS_BEAN.setLabelCaption(Messages.getString("messageProperties_PP047_A", "PP047_A$AGENT_PROCESS$CONTEST$HEADING"));
			AGENT_PROCESS_BEAN.setFromFieldCaption(Messages.getString("messageProperties_PP047_A", "PP047_A$AGENT_PROCESS$UI_M_CON_FROM$caption"));
			AGENT_PROCESS_BEAN.setToFieldCaption(Messages.getString("messageProperties_PP047_A", "PP047_A$AGENT_PROCESS$UI_M_CON_TO$caption"));
		}else if("B".equalsIgnoreCase(menuParam)){
			AGENT_PROCESS_BEAN.setUI_M_PROCESS_TYPE("B");
			AGENT_PROCESS_BEAN.setUI_M_FREQ("Y");
			HtmlSelectOneMenu PROCESS_TYPE=new HtmlSelectOneMenu();
			PROCESS_TYPE.setDisabled(true);
			setCOMP_UI_M_PROCESS_TYPE(PROCESS_TYPE);
			HtmlSelectOneMenu QUARTER_PERIOD=new HtmlSelectOneMenu();
			QUARTER_PERIOD.setDisabled(true);
			setCOMP_UI_M_QUARTER_PERIOD(QUARTER_PERIOD);
			AGENT_PROCESS_BEAN.setLabelCaption(Messages.getString("messageProperties_PP047_A", "PP047_A$AGENT_PROCESS$BONUS$HEADING"));
			AGENT_PROCESS_BEAN.setFromFieldCaption(Messages.getString("messageProperties_PP047_A", "PP047_A$AGENT_PROCESS$UI_M_BONUS_FROM$caption"));
			AGENT_PROCESS_BEAN.setToFieldCaption(Messages.getString("messageProperties_PP047_A", "PP047_A$AGENT_PROCESS$UI_M_BONUS_TO$caption"));
		}
	}
	
	
	public void validateUI_M_AGT_FM(FacesContext context,UIComponent component, Object value) {
		String fromValue = (String) value;
		String toValue = AGENT_PROCESS_BEAN.getUI_M_AGT_TO();
		try {
			if(fromValue == null || fromValue.isEmpty()){
				fromValue = DEFAULT_FROM_VALUE;
				AGENT_PROCESS_BEAN.setUI_M_AGT_FM(fromValue);
				COMP_UI_M_AGT_FM.resetValue();
			}
			
			if(toValue != null && !toValue.isEmpty()) {
				// Compare to returns ascii difference between the Strings
				if(fromValue.compareTo(toValue) > 0){
					throw new Exception("From Agent should not be less than To Agent");
				}
			}
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateUI_M_AGT_TO(FacesContext context,UIComponent component, Object value) {
				
		String fromValue = AGENT_PROCESS_BEAN.getUI_M_AGT_FM();
		String toValue = (String) value;
		try {
			if(toValue == null || toValue.isEmpty()){
				toValue = DEFAULT_TO_VALUE;
				AGENT_PROCESS_BEAN.setUI_M_AGT_TO(toValue);
				COMP_UI_M_AGT_TO.resetValue();
			}
			
			if(fromValue != null && !fromValue.isEmpty()) {
				// Compare to returns ascii difference between the Strings
				if(fromValue.compareTo(toValue) > 0){
					throw new Exception("From Agent should not be less than To Agent");
				}
			}else{
				throw new Exception("From Agent should not be less than To Agent");
			}
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_PROCESS_TYPE(FacesContext context,UIComponent component, Object value) {
		try {
			if (value != null) {
				AGENT_PROCESS_BEAN.setUI_M_PROCESS_TYPE((String) value);
				helper.whenListChangedProcessType(AGENT_PROCESS_BEAN);
				helper.whenValidateProcessType(AGENT_PROCESS_BEAN);
			}
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void validateUI_M_FREQ(FacesContext context, UIComponent component,Object value) {
		try {
			if (value != null) {
				AGENT_PROCESS_BEAN.setUI_M_FREQ((String) value);
				helper.whenListChangedFrequency(AGENT_PROCESS_BEAN);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_QUARTER_PERIOD(FacesContext context,UIComponent component, Object value) {
		try {
			if (value != null) {
				AGENT_PROCESS_BEAN.setUI_M_QUARTER_PERIOD((String) value);
				helper.L_GET_QUARTER_PERIOD(AGENT_PROCESS_BEAN);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_BEN_CON_FROM(FacesContext context,UIComponent component, Object value) {
		try {
			if (value != null) {
				AGENT_PROCESS_BEAN.setUI_M_BEN_CON_FROM((String) value);
				AGENT_PROCESS_BEAN.setUI_M_BEN_CON_TO((String)value);
				COMP_UI_M_BEN_CON_TO.resetValue();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_BEN_CON_TO(FacesContext context,UIComponent component, Object value) {
		if (value != null) {
			AGENT_PROCESS_BEAN.setUI_M_BEN_CON_TO((String) value);
		}
	}

	public void validateUI_M_PROD_FM_DT(FacesContext fc, UIComponent component,Object value) throws ValidatorException {
		if (value != null) {
			HtmlCalendar htmlCalendar = (HtmlCalendar) component;
			Date fromDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue());
			AGENT_PROCESS_BEAN.setUI_M_PROD_FM_DT(fromDate);
		}
		try {
			if(AGENT_PROCESS_BEAN.getUI_M_PROD_FM_DT()!=null){
				Calendar cal=Calendar.getInstance();
				cal.setTime(AGENT_PROCESS_BEAN.getUI_M_PROD_FM_DT());
				if("M".equals(AGENT_PROCESS_BEAN.getUI_M_FREQ())){
					cal.add(Calendar.MONTH, 1);
				}else if("Y".equals(AGENT_PROCESS_BEAN.getUI_M_FREQ())){
					cal.add(Calendar.MONTH, 12);
					cal.add(Calendar.DAY_OF_YEAR,-1);
				}
				AGENT_PROCESS_BEAN.setUI_M_PROD_TO_DT(cal.getTime());
				getCOMP_UI_M_PROD_TO_DT().resetValue();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_PROD_TO_DT(FacesContext fc, UIComponent component,Object value) throws ValidatorException {
		try {
			if (value != null) {
				HtmlCalendar htmlCalendar = (HtmlCalendar) component;
				Date toDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue());
				AGENT_PROCESS_BEAN.setUI_M_PROD_TO_DT(toDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_PROCESS_DT(FacesContext fc, UIComponent component,Object value) throws ValidatorException {
		try {
			if (value != null) {
				HtmlCalendar htmlCalendar = (HtmlCalendar) component;
				Date processDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue());
				AGENT_PROCESS_BEAN.setUI_M_PROCESS_DT(processDate);
				helper.processDateWhenValidate(AGENT_PROCESS_BEAN);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		clearMaps();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void productFromValidation(ActionEvent actionEvent) {
		try {
			clearMaps();
			//validateProdFromDate(false);
			UIInput input=(UIInput)actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input,getErrorMap());
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}

	public void productToValidation(ActionEvent actionEvent) {
		try {
			clearMaps();
			validateProdToDate(false);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}

	public void processDateValidation(ActionEvent actionEvent) {
		try {
			clearMaps();
			validateProcessDate(false);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}

	public void agentFromFireFieldValidation(ActionEvent actionEvent) {
		
		/*UIInput input = (UIInput) actionEvent.getComponent().getParent();
		if("".equals(input.getSubmittedValue()))
		{
			AGENT_PROCESS_BEAN.setUI_M_AGT_FM(DEFAULT_FROM_VALUE);
			COMP_UI_M_AGT_FM.setSubmittedValue(DEFAULT_FROM_VALUE);
		}
		ErrorHelpUtil.validate(input,"Test" ,getErrorMap());
		COMP_UI_M_AGT_FM.resetValue();*/
		
		try {
			clearMaps();
			if(null!=agentFromList&&agentFromList.size()==0){
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Code not exist");
			}
			validateAgentFrom(false);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}
	
	public void agentToFireFieldValidation(ActionEvent actionEvent) {
		
		/*UIInput input = (UIInput) actionEvent.getComponent().getParent();
		if("".equals(input.getSubmittedValue()))
		{
			AGENT_PROCESS_BEAN.setUI_M_AGT_TO("zzzzzz");
			COMP_UI_M_AGT_TO.resetValue();
		}
		ErrorHelpUtil.validate(input, getErrorMap());*/
		
		try {
			clearMaps();
			if(null!=agentToList&&agentToList.size()==0){
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Code not exist");
			}
			validateAgentTo(false);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}

	}
	
	
	public void benefitFromFireFieldValidation(ActionEvent actionEvent) {
		
		/*UIInput input = (UIInput) actionEvent.getComponent().getParent();
		if("".equals(input.getSubmittedValue()))
		{
			AGENT_PROCESS_BEAN.setUI_M_BEN_CON_FROM("0");
			COMP_UI_M_BEN_CON_FROM.resetValue();
		}
		ErrorHelpUtil.validate(input, getErrorMap());*/

		try {
			clearMaps();
			validateContestFrom(false);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}
	
	public void benefitToFireFieldValidation(ActionEvent actionEvent) {
		
		/*UIInput input = (UIInput) actionEvent.getComponent().getParent();
		if("".equals(input.getSubmittedValue()))
		{
			AGENT_PROCESS_BEAN.setUI_M_BEN_CON_TO("zzzzzz");
			COMP_UI_M_BEN_CON_TO.resetValue();
		}
		ErrorHelpUtil.validate(input, getErrorMap());*/

		try {
			clearMaps();
			validateContestTo(false);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}
	//PREMIAGDC-326708 Method added VijayAnand 21-AUG-2009
	
	public String bonusApprovalButtonPressed(){
		try{
		CommonUtils.setGlobalObject("GLOBAL.PP047A_AGENT_FROM", AGENT_PROCESS_BEAN.getUI_M_AGT_FM());
		CommonUtils.setGlobalObject("GLOBAL.PP047A_AGENT_TO", AGENT_PROCESS_BEAN.getUI_M_AGT_TO());
		CommonUtils.setGlobalObject("GLOBAL.PP047A_PROD_FM_DT", AGENT_PROCESS_BEAN.getUI_M_PROD_FM_DT());
		CommonUtils.setGlobalObject("GLOBAL.PP047A_PROD_TO_DT", AGENT_PROCESS_BEAN.getUI_M_PROD_TO_DT());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "PT048_APPROVAL_PAGE";
	}
	//PREMIAGDC-326708 Method added VijayAnand 21-AUG-2009
	/**
	 * ok button pressed
	 */
	
	
	/*Modified by Janani on 18.06.2018 for KIC as per Sivaram's sugg*/
	//public void okButtonPressed()
	public void okButtonPressed(ActionEvent event)
	/*End*/
	
	{
		try {
			// Validate form and process
			validateForm(true);
			CommonUtils.clearMaps(this);
			delegate.sysidCheck(AGENT_PROCESS_BEAN);
			if ("F".equals(AGENT_PROCESS_BEAN.getUI_M_PROCESS_TYPE())) {
				delegate.checkBenefitDetails(AGENT_PROCESS_BEAN);
				helper.helperP9ILPK_AGENT_BENEFITS_BENEFIT_PROCESS(AGENT_PROCESS_BEAN);
			}else if ("B".equals(AGENT_PROCESS_BEAN.getUI_M_PROCESS_TYPE())){
				delegate.checkBonusDetails(AGENT_PROCESS_BEAN);
				helper.helperP9ILPK_AGENT_BONUS_CALC_AGENT_BONUS(AGENT_PROCESS_BEAN);
			}else {
				helper.helperP9ILPK_AGENT_BENEFITS_AGENT_AWARD_PROCESS(AGENT_PROCESS_BEAN);
			}
			CommonUtils commonUtils = new CommonUtils();
			commonUtils.doComitt();
			getWarningMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "60315"));
			getWarningMap().put("PROCESS", Messages.getString(PELConstants.pelErrorMessagePath, "60315"));
			COMP_M_BUTTON_OK.setDisabled(true);
			COMP_M_BUTTON_BONUS_APPROVAL.setDisabled(false);
		}catch (SQLException exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_AGT_FM_LABEL() {
		return COMP_UI_M_AGT_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGT_FM() {
		return COMP_UI_M_AGT_FM;
	}

	public void setCOMP_UI_M_AGT_FM_LABEL(HtmlOutputLabel COMP_UI_M_AGT_FM_LABEL) {
		this.COMP_UI_M_AGT_FM_LABEL = COMP_UI_M_AGT_FM_LABEL;
	}

	public void setCOMP_UI_M_AGT_FM(HtmlInputText COMP_UI_M_AGT_FM) {
		this.COMP_UI_M_AGT_FM = COMP_UI_M_AGT_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGT_TO_LABEL() {
		return COMP_UI_M_AGT_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGT_TO() {
		return COMP_UI_M_AGT_TO;
	}

	public void setCOMP_UI_M_AGT_TO_LABEL(HtmlOutputLabel COMP_UI_M_AGT_TO_LABEL) {
		this.COMP_UI_M_AGT_TO_LABEL = COMP_UI_M_AGT_TO_LABEL;
	}

	public void setCOMP_UI_M_AGT_TO(HtmlInputText COMP_UI_M_AGT_TO) {
		this.COMP_UI_M_AGT_TO = COMP_UI_M_AGT_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_TYPE_LABEL() {
		return COMP_UI_M_PROCESS_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PROCESS_TYPE() {
		return COMP_UI_M_PROCESS_TYPE;
	}

	public void setCOMP_UI_M_PROCESS_TYPE_LABEL(
			HtmlOutputLabel COMP_UI_M_PROCESS_TYPE_LABEL) {
		this.COMP_UI_M_PROCESS_TYPE_LABEL = COMP_UI_M_PROCESS_TYPE_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_TYPE(
			HtmlSelectOneMenu COMP_UI_M_PROCESS_TYPE) {
		this.COMP_UI_M_PROCESS_TYPE = COMP_UI_M_PROCESS_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FREQ_LABEL() {
		return COMP_UI_M_FREQ_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_FREQ() {
		return COMP_UI_M_FREQ;
	}

	public void setCOMP_UI_M_FREQ_LABEL(HtmlOutputLabel COMP_UI_M_FREQ_LABEL) {
		this.COMP_UI_M_FREQ_LABEL = COMP_UI_M_FREQ_LABEL;
	}

	public void setCOMP_UI_M_FREQ(HtmlSelectOneMenu COMP_UI_M_FREQ) {
		this.COMP_UI_M_FREQ = COMP_UI_M_FREQ;
	}

	public HtmlOutputLabel getCOMP_UI_M_QUARTER_PERIOD_LABEL() {
		return COMP_UI_M_QUARTER_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_QUARTER_PERIOD() {
		return COMP_UI_M_QUARTER_PERIOD;
	}

	public void setCOMP_UI_M_QUARTER_PERIOD_LABEL(
			HtmlOutputLabel COMP_UI_M_QUARTER_PERIOD_LABEL) {
		this.COMP_UI_M_QUARTER_PERIOD_LABEL = COMP_UI_M_QUARTER_PERIOD_LABEL;
	}

	public void setCOMP_UI_M_QUARTER_PERIOD(
			HtmlSelectOneMenu COMP_UI_M_QUARTER_PERIOD) {
		this.COMP_UI_M_QUARTER_PERIOD = COMP_UI_M_QUARTER_PERIOD;
	}

	public HtmlOutputLabel getCOMP_UI_M_BEN_CON_FROM_LABEL() {
		return COMP_UI_M_BEN_CON_FROM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BEN_CON_FROM() {
		return COMP_UI_M_BEN_CON_FROM;
	}

	public void setCOMP_UI_M_BEN_CON_FROM_LABEL(
			HtmlOutputLabel COMP_UI_M_BEN_CON_FROM_LABEL) {
		this.COMP_UI_M_BEN_CON_FROM_LABEL = COMP_UI_M_BEN_CON_FROM_LABEL;
	}

	public void setCOMP_UI_M_BEN_CON_FROM(HtmlInputText COMP_UI_M_BEN_CON_FROM) {
		this.COMP_UI_M_BEN_CON_FROM = COMP_UI_M_BEN_CON_FROM;
	}

	public HtmlOutputLabel getCOMP_UI_M_BEN_CON_TO_LABEL() {
		return COMP_UI_M_BEN_CON_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BEN_CON_TO() {
		return COMP_UI_M_BEN_CON_TO;
	}

	public void setCOMP_UI_M_BEN_CON_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_BEN_CON_TO_LABEL) {
		this.COMP_UI_M_BEN_CON_TO_LABEL = COMP_UI_M_BEN_CON_TO_LABEL;
	}

	public void setCOMP_UI_M_BEN_CON_TO(HtmlInputText COMP_UI_M_BEN_CON_TO) {
		this.COMP_UI_M_BEN_CON_TO = COMP_UI_M_BEN_CON_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_FM_DT_LABEL() {
		return COMP_UI_M_PROD_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROD_FM_DT() {
		return COMP_UI_M_PROD_FM_DT;
	}

	public void setCOMP_UI_M_PROD_FM_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_FM_DT_LABEL) {
		this.COMP_UI_M_PROD_FM_DT_LABEL = COMP_UI_M_PROD_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_PROD_FM_DT(HtmlCalendar COMP_UI_M_PROD_FM_DT) {
		this.COMP_UI_M_PROD_FM_DT = COMP_UI_M_PROD_FM_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_TO_DT_LABEL() {
		return COMP_UI_M_PROD_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROD_TO_DT() {
		return COMP_UI_M_PROD_TO_DT;
	}

	public void setCOMP_UI_M_PROD_TO_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_PROD_TO_DT_LABEL) {
		this.COMP_UI_M_PROD_TO_DT_LABEL = COMP_UI_M_PROD_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_PROD_TO_DT(HtmlCalendar COMP_UI_M_PROD_TO_DT) {
		this.COMP_UI_M_PROD_TO_DT = COMP_UI_M_PROD_TO_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}

	public void setCOMP_UI_M_PROCESS_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL) {
		this.COMP_UI_M_PROCESS_DT_LABEL = COMP_UI_M_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar COMP_UI_M_PROCESS_DT) {
		this.COMP_UI_M_PROCESS_DT = COMP_UI_M_PROCESS_DT;
	}

	public AGENT_PROCESS getAGENT_PROCESS_BEAN() {
		return AGENT_PROCESS_BEAN;
	}

	public void setAGENT_PROCESS_BEAN(AGENT_PROCESS AGENT_PROCESS_BEAN) {
		this.AGENT_PROCESS_BEAN = AGENT_PROCESS_BEAN;
	}

	public List getAgentFromList() {
		return agentFromList;
	}

	public void setAgentFromList(List agentFromList) {
		this.agentFromList = agentFromList;
	}

	public List getAgentToList() {
		return agentToList;
	}

	public void setAgentToList(List agentToList) {
		this.agentToList = agentToList;
	}

	public List getBenConFromList() {
		return benConFromList;
	}

	public void setBenConFromList(List benConFromList) {
		this.benConFromList = benConFromList;
	}

	public List getBenConToList() {
		return benConToList;
	}

	public void setBenConToList(List benConToList) {
		this.benConToList = benConToList;
	}

	public List<SelectItem> getProcessTypeList() {
		return processTypeList;
	}

	public void setProcessTypeList(List<SelectItem> processTypeList) {
		this.processTypeList = processTypeList;
	}

	public List<SelectItem> getFrequencyList() {
		return frequencyList;
	}

	public void setFrequencyList(List<SelectItem> frequencyList) {
		this.frequencyList = frequencyList;
	}

	public List<SelectItem> getPeriodList() {
		return periodList;
	}

	public void setPeriodList(List<SelectItem> periodList) {
		this.periodList = periodList;
	}

	/*Commented and modified by Janani on 18.06.2018 for KIC as per Sivaram's sugg */

	/*	public HtmlCommandButton getCOMP_M_BUTTON_OK() {
		return COMP_M_BUTTON_OK;
	}

	public void setCOMP_M_BUTTON_OK(HtmlCommandButton comp_m_button_ok) {
		COMP_M_BUTTON_OK = comp_m_button_ok;
	}*/

	public HtmlAjaxCommandButton getCOMP_M_BUTTON_OK() {
		return COMP_M_BUTTON_OK;
	}

	public void setCOMP_M_BUTTON_OK(HtmlAjaxCommandButton cOMP_M_BUTTON_OK) {
		COMP_M_BUTTON_OK = cOMP_M_BUTTON_OK;
	}

	/*End*/	
	

	public void validateAgentFrom(boolean isSubmit) throws Exception{
		String toValue = AGENT_PROCESS_BEAN.getUI_M_AGT_TO();
		String fromValue = (String) COMP_UI_M_AGT_FM.getSubmittedValue();

		if(isSubmit){
			fromValue = AGENT_PROCESS_BEAN.getUI_M_AGT_FM();;
		}
		
		// Setting value
		if(fromValue == null || fromValue.isEmpty()){
			fromValue = DEFAULT_FROM_VALUE;
		}
		AGENT_PROCESS_BEAN.setUI_M_AGT_FM(fromValue);
		COMP_UI_M_AGT_FM.resetValue();
		
		// Comparing to and from
		if(toValue != null && !toValue.isEmpty()) {
			// Compare to returns ascii difference between the Strings
			if(fromValue.compareTo(toValue) > 0){
				throw new Exception("From Agent should not be less than To Agent");
			}
		}
	}
	
	public void validateAgentTo(boolean isSubmit) throws Exception{
		String fromValue = AGENT_PROCESS_BEAN.getUI_M_AGT_FM();
		String toValue = (String) COMP_UI_M_AGT_TO.getSubmittedValue();

		if(isSubmit){
			toValue = AGENT_PROCESS_BEAN.getUI_M_AGT_TO();;
		}
		
		// Setting values
		if(toValue == null || toValue.isEmpty()){
			if(fromValue != null){
				if(DEFAULT_FROM_VALUE.equals(fromValue)){
					toValue = DEFAULT_TO_VALUE;
				}else{
					toValue = fromValue;
				}
			}else{
				throw new Exception("Agent From and Agent To should not be Empty");
			}
		}
		AGENT_PROCESS_BEAN.setUI_M_AGT_TO(toValue);
		COMP_UI_M_AGT_TO.resetValue();
		
		if(fromValue != null && !fromValue.isEmpty()) {
			// Compare to returns ascii difference between the Strings
			if(fromValue.compareTo(toValue) > 0){
				throw new Exception("From Agent should not be less than To Agent");
			}
		}
	}
	
	public void validateContestFrom(boolean isSubmit) throws Exception{
		String fromValue = (String) COMP_UI_M_BEN_CON_FROM.getSubmittedValue();
		String toValue = AGENT_PROCESS_BEAN.getUI_M_BEN_CON_TO();
		
		if(isSubmit){
			fromValue = AGENT_PROCESS_BEAN.getUI_M_BEN_CON_FROM();;
		}
		
		if(fromValue == null || fromValue.isEmpty()){
			fromValue = DEFAULT_FROM_VALUE;
		}
		AGENT_PROCESS_BEAN.setUI_M_BEN_CON_FROM(fromValue);
		COMP_UI_M_BEN_CON_FROM.resetValue();
		
		if(toValue != null && !toValue.isEmpty()) {
			// Compare to returns ascii difference between the Strings
			if(fromValue.compareTo(toValue) > 0){
				throw new Exception("Benefit From should not be less than Benefit To");
			}
		}
	}
	
	public void validateContestTo(boolean isSubmit) throws Exception{
		String fromValue = AGENT_PROCESS_BEAN.getUI_M_BEN_CON_FROM();
		String toValue = (String) COMP_UI_M_BEN_CON_TO.getSubmittedValue();
		
		if(isSubmit){
			toValue = AGENT_PROCESS_BEAN.getUI_M_BEN_CON_TO();;
		}
		
		if(toValue == null || toValue.isEmpty()){
			if(DEFAULT_FROM_VALUE.equals(fromValue)){
				toValue = DEFAULT_TO_VALUE;
			}else{
				toValue = fromValue;
			}

		}
		AGENT_PROCESS_BEAN.setUI_M_BEN_CON_TO(toValue);
		COMP_UI_M_BEN_CON_TO.resetValue();
		
		if(fromValue != null && !fromValue.isEmpty()) {
			// Compare to returns ascii difference between the Strings
			if(fromValue.compareTo(toValue) > 0){
				throw new Exception("Benefit From should not be less than Benefit To");
			}
		}
	}

	public void validateProdFromDate(boolean isSubmit) throws Exception{
		Object value = COMP_UI_M_PROD_FM_DT.getSubmittedValue();
		Date fromDate = null;
		Date toDate = null;
		/*Calendar cal = null;
		String frequency = null;*/
		
		if (value != null && !((String)value).isEmpty()) {
			fromDate = COMP_UI_M_PROD_FM_DT.getAsDate(value);
			AGENT_PROCESS_BEAN.setUI_M_PROD_FM_DT(fromDate);
		}else{
			if(isSubmit){
				fromDate = AGENT_PROCESS_BEAN.getUI_M_PROD_FM_DT();
			}else{
				throw new Exception("Production From Date required");
			}
		}
		
		toDate = AGENT_PROCESS_BEAN.getUI_M_PROD_TO_DT();
		if(toDate != null && fromDate != null && toDate.before(fromDate)){
			throw new Exception("From Date should not be less than To Date");
		}

	}

	public void validateProdToDate(boolean isSubmit) throws Exception{
		
		/*Added by Janani on 16.06.2018 for KIC as per sivaram sugg*/
		String sql_C2=null;
		String fromDateString = CommonUtils.dateToStringFormatter(AGENT_PROCESS_BEAN.getUI_M_PROD_FM_DT());
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		Connection connection = CommonUtils.getConnection();
		
		/*End*/
		
		try
		{
		Object value = COMP_UI_M_PROD_TO_DT.getSubmittedValue();
		Date toDate = null;
		Date fromDate = null;
		Calendar cal = null;
		String frequency = null;
		
		fromDate = AGENT_PROCESS_BEAN.getUI_M_PROD_FM_DT();
		if (value != null && !((String)value).isEmpty()) {
			toDate = COMP_UI_M_PROD_TO_DT.getAsDate(value);
			AGENT_PROCESS_BEAN.setUI_M_PROD_TO_DT(toDate);
		}else{
			if(isSubmit){
				toDate = AGENT_PROCESS_BEAN.getUI_M_PROD_TO_DT();
			}else{
				// Set to date as per frequency
				if(fromDate != null){
					cal = Calendar.getInstance();
					cal.setTime(fromDate);
					frequency = AGENT_PROCESS_BEAN.getUI_M_FREQ();
					
					/*Commented and modified by Janani on 16.06.2018 for KIC Production To Date value getting defaulted wrongly*/ 
					
					/*if("M".equals(frequency)){
						cal.add(Calendar.MONTH, 1);
					}else if("Y".equals(frequency)){
						cal.add(Calendar.MONTH, 12);
						cal.add(Calendar.DAY_OF_YEAR,-1);
					}
					*/
					
					if("M".equals(AGENT_PROCESS_BEAN.getUI_M_FREQ())){
						sql_C2 = "SELECT TRUNC(LAST_DAY(TO_DATE('"+ fromDateString + "'))) FROM DUAL ";
					}else if("Y".equals(AGENT_PROCESS_BEAN.getUI_M_FREQ())){
						sql_C2="SELECT ADD_MONTHS(TO_DATE('"+fromDateString+"','DD-MON-YYYY'),12)-1 FROM DUAL";
					}else{
						sql_C2="SELECT ADD_MONTHS(TO_DATE('"+fromDateString+"','DD-MON-YYYY'),3)-1 FROM DUAL";
					}
					resultSet1 = handler.executeSelectStatement(sql_C2, connection);
					while (resultSet1.next()) {
						toDate = resultSet1.getDate(1);
					}
					
					/*End*/
					
					//toDate = cal.getTime();
					AGENT_PROCESS_BEAN.setUI_M_PROD_TO_DT(toDate);
					getCOMP_UI_M_PROD_TO_DT().resetValue();
				}else{
					throw new Exception("Production To Date required");
				}
			}
		}
		
		if(toDate != null && fromDate != null && toDate.before(fromDate)){
			throw new Exception("From Date should not be less than To Date");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void validateProcessDate(boolean isSubmit) throws Exception{
		Object value = COMP_UI_M_PROCESS_DT.getSubmittedValue();
		Date processDate = null;
		Date toDate = null;
		CommonUtils utils = new CommonUtils();
		
		try {
			toDate = AGENT_PROCESS_BEAN.getUI_M_PROD_TO_DT();
			if (value != null && !((String)value).isEmpty()) {
				processDate = COMP_UI_M_PROCESS_DT.getAsDate(value);
				AGENT_PROCESS_BEAN.setUI_M_PROCESS_DT(processDate);
				
			}else{
				if(isSubmit){
					processDate = AGENT_PROCESS_BEAN.getUI_M_PROCESS_DT();
				}else{
					if(toDate == null){
						throw new Exception("Process Date required");
					}
				}
			}

			// Compare from ToDate and ProcessDate 
			if(toDate != null){
				if(processDate != null){
					toDate = utils.truncDate(toDate);
					processDate = utils.truncDate(processDate);
					/*
					 * modified by Ameen on 26-04-2018 for KIC as per Ajay sugg.
					 * if(processDate.before(toDate)){
						throw new Exception("Process Date should not be less than To Date");
					}*/
					if(!processDate.equals(new CommonUtils().getCurrentDate())){
						throw new Exception("Process Date should be Today's Date");
					}
				}else{
					throw new Exception("Process Date requred");
				}
			}else{
				throw new Exception("To Date requred");
			}

		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	private void clearMaps(){
		getErrorMap().clear();
		getWarningMap().clear();
	}
	
	public void validateForm(boolean isSubmit) throws Exception{
		validateAgentFrom(isSubmit);
		validateAgentTo(isSubmit);
		validateContestFrom(isSubmit);
		validateContestTo(isSubmit);
		validateProdFromDate(isSubmit);
		validateProdToDate(isSubmit);
		validateProcessDate(isSubmit);
	}
	public Date getFirstOfMonth(){
		Date firstDate=null;
		ResultSet resultSet=null;
		try{
			Connection connection=CommonUtils.getConnection();
			String selectQuery="SELECT TRUNC(SYSDATE,'MONTH') FROM DUAL";
			resultSet=new CRUDHandler().executeSelectStatement(selectQuery, connection);
			while(resultSet.next()){
				firstDate=resultSet.getDate(1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return firstDate;
	}
	public void fromDateValidator(FacesContext context,UIComponent component,Object object){

		Date fromDate = (Date) object;
		AGENT_PROCESS_BEAN.setUI_M_PROD_FM_DT(fromDate);
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		try {
			Connection connection = CommonUtils.getConnection();
			String fromDateString = CommonUtils.dateToStringFormatter(AGENT_PROCESS_BEAN.getUI_M_PROD_FM_DT());
			CRUDHandler handler = new CRUDHandler();
			String sql_C1 = "SELECT 'X' FROM DUAL WHERE TO_DATE('"
					+ fromDateString + "','DD-MON-YYYY')=TRUNC(TO_DATE('"
					+ fromDateString + "','DD-MON-YYYY'),'MONTH')";
			resultSet = handler.executeSelectStatement(sql_C1, connection);
			String output = null;
			if (resultSet.next()) {
				output = resultSet.getString(1);
			}
			if ("X".equals(output)) {
				String sql_C2=null;
				Date toDate = null;
				if("M".equals(AGENT_PROCESS_BEAN.getUI_M_FREQ())){
					sql_C2 = "SELECT TRUNC(LAST_DAY(TO_DATE('"+ fromDateString + "'))) FROM DUAL ";
				}else if("Y".equals(AGENT_PROCESS_BEAN.getUI_M_FREQ())){
					sql_C2="SELECT ADD_MONTHS(TO_DATE('"+fromDateString+"','DD-MON-YYYY'),12)-1 FROM DUAL";
				}else{
					sql_C2="SELECT ADD_MONTHS(TO_DATE('"+fromDateString+"','DD-MON-YYYY'),3)-1 FROM DUAL";
				}
				resultSet1 = handler.executeSelectStatement(sql_C2, connection);
				while (resultSet1.next()) {
					toDate = resultSet1.getDate(1);
				}
				AGENT_PROCESS_BEAN.setUI_M_PROD_TO_DT(toDate);
				//AGENT_PROCESS_BEAN.setUI_M_PROCESS_DT(toDate);
				COMP_UI_M_PROD_TO_DT.setSubmittedValue(null);
				//COMP_UI_M_PROCESS_DT.setSubmittedValue(null);
			} else {
				AGENT_PROCESS_BEAN.setUI_M_PROD_TO_DT(null);
				//AGENT_PROCESS_BEAN.setUI_M_PROCESS_DT(null);
				COMP_UI_M_PROD_TO_DT.setSubmittedValue(null);
				//COMP_UI_M_PROCESS_DT.setSubmittedValue(null);
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "92064"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public HtmlCommandButton getCOMP_M_BUTTON_BONUS_APPROVAL() {
		return COMP_M_BUTTON_BONUS_APPROVAL;
	}

	public void setCOMP_M_BUTTON_BONUS_APPROVAL(
			HtmlCommandButton comp_m_button_bonus_approval) {
		COMP_M_BUTTON_BONUS_APPROVAL = comp_m_button_bonus_approval;
	}
}
