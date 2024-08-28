package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PAYVOU_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_APPRV_STATUS;

	private HtmlOutputLabel COMP_PAH_APPRV_DT_LABEL;

	private HtmlCalendar COMP_PAH_APPRV_DT;

	private HtmlOutputLabel COMP_UI_M_MATCH_STATUS;

	private HtmlOutputLabel COMP_PAH_FREEZE_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PAH_FREEZE_FLAG;

	private HtmlOutputLabel COMP_PAH_FM_DT_LABEL;

	private HtmlCalendar COMP_PAH_FM_DT;

	private HtmlOutputLabel COMP_PAH_TO_DT_LABEL;

	private HtmlCalendar COMP_PAH_TO_DT;

	private HtmlOutputLabel COMP_PAH_CONTROL_NO_LABEL;

	private HtmlInputText COMP_PAH_CONTROL_NO;
	
	private PT_IL_PAYVOU_HDR PT_IL_PAYVOU_HDR_BEAN;
	
	private boolean onLoadFlag = false;
	
	private boolean preFormFlag = false;
	
	private List<SelectItem> PAH_FREEZE_FLAG_LIST = null;
	
	public PILT030_APAC_COMPOSITE_ACTION compositeAction;

	public PT_IL_PAYVOU_HDR_ACTION() {
		PT_IL_PAYVOU_HDR_BEAN = new PT_IL_PAYVOU_HDR();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		PAH_FREEZE_FLAG_LIST = ListItemUtil.getDropDownListValue(connection, "PILT030_APAC", "PT_IL_PAYVOU_HDR", "PT_IL_PAYVOU_HDR.PAH_FREEZE_FLAG", "YESNO");
	}

	public List<SelectItem> getPAH_FREEZE_FLAG_LIST() {
		return PAH_FREEZE_FLAG_LIST;
	}

	public void setPAH_FREEZE_FLAG_LIST(List<SelectItem> pah_freeze_flag_list) {
		PAH_FREEZE_FLAG_LIST = pah_freeze_flag_list;
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputLabel COMP_UI_M_APPRV_STATUS) {
		this.COMP_UI_M_APPRV_STATUS = COMP_UI_M_APPRV_STATUS;
	}

	public HtmlOutputLabel getCOMP_PAH_APPRV_DT_LABEL() {
		return COMP_PAH_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PAH_APPRV_DT() {
		return COMP_PAH_APPRV_DT;
	}

	public void setCOMP_PAH_APPRV_DT_LABEL(HtmlOutputLabel COMP_PAH_APPRV_DT_LABEL) {
		this.COMP_PAH_APPRV_DT_LABEL = COMP_PAH_APPRV_DT_LABEL;
	}

	public void setCOMP_PAH_APPRV_DT(HtmlCalendar COMP_PAH_APPRV_DT) {
		this.COMP_PAH_APPRV_DT = COMP_PAH_APPRV_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_MATCH_STATUS() {
		return COMP_UI_M_MATCH_STATUS;
	}

	public void setCOMP_UI_M_MATCH_STATUS(HtmlOutputLabel COMP_UI_M_MATCH_STATUS) {
		this.COMP_UI_M_MATCH_STATUS = COMP_UI_M_MATCH_STATUS;
	}

	public HtmlOutputLabel getCOMP_PAH_FREEZE_FLAG_LABEL() {
		return COMP_PAH_FREEZE_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAH_FREEZE_FLAG() {
		return COMP_PAH_FREEZE_FLAG;
	}

	public void setCOMP_PAH_FREEZE_FLAG_LABEL(HtmlOutputLabel COMP_PAH_FREEZE_FLAG_LABEL) {
		this.COMP_PAH_FREEZE_FLAG_LABEL = COMP_PAH_FREEZE_FLAG_LABEL;
	}

	public void setCOMP_PAH_FREEZE_FLAG(HtmlSelectOneMenu COMP_PAH_FREEZE_FLAG) {
		this.COMP_PAH_FREEZE_FLAG = COMP_PAH_FREEZE_FLAG;
	}

	public HtmlOutputLabel getCOMP_PAH_FM_DT_LABEL() {
		return COMP_PAH_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PAH_FM_DT() {
		return COMP_PAH_FM_DT;
	}

	public void setCOMP_PAH_FM_DT_LABEL(HtmlOutputLabel COMP_PAH_FM_DT_LABEL) {
		this.COMP_PAH_FM_DT_LABEL = COMP_PAH_FM_DT_LABEL;
	}

	public void setCOMP_PAH_FM_DT(HtmlCalendar COMP_PAH_FM_DT) {
		this.COMP_PAH_FM_DT = COMP_PAH_FM_DT;
	}

	public HtmlOutputLabel getCOMP_PAH_TO_DT_LABEL() {
		return COMP_PAH_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PAH_TO_DT() {
		return COMP_PAH_TO_DT;
	}

	public void setCOMP_PAH_TO_DT_LABEL(HtmlOutputLabel COMP_PAH_TO_DT_LABEL) {
		this.COMP_PAH_TO_DT_LABEL = COMP_PAH_TO_DT_LABEL;
	}

	public void setCOMP_PAH_TO_DT(HtmlCalendar COMP_PAH_TO_DT) {
		this.COMP_PAH_TO_DT = COMP_PAH_TO_DT;
	}

	public HtmlOutputLabel getCOMP_PAH_CONTROL_NO_LABEL() {
		return COMP_PAH_CONTROL_NO_LABEL;
	}

	public HtmlInputText getCOMP_PAH_CONTROL_NO() {
		return COMP_PAH_CONTROL_NO;
	}

	public void setCOMP_PAH_CONTROL_NO_LABEL(HtmlOutputLabel COMP_PAH_CONTROL_NO_LABEL) {
		this.COMP_PAH_CONTROL_NO_LABEL = COMP_PAH_CONTROL_NO_LABEL;
	}

	public void setCOMP_PAH_CONTROL_NO(HtmlInputText COMP_PAH_CONTROL_NO) {
		this.COMP_PAH_CONTROL_NO = COMP_PAH_CONTROL_NO;
	}

	public PT_IL_PAYVOU_HDR getPT_IL_PAYVOU_HDR_BEAN() {
		return PT_IL_PAYVOU_HDR_BEAN;
	}

	public void setPT_IL_PAYVOU_HDR_BEAN(PT_IL_PAYVOU_HDR PT_IL_PAYVOU_HDR_BEAN) {
		this.PT_IL_PAYVOU_HDR_BEAN = PT_IL_PAYVOU_HDR_BEAN;
	}
	
	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public void onLoad(PhaseEvent event){
		try {
			DUMMY_HELPER dummyHelper = new DUMMY_HELPER();
			PT_IL_PAYVOU_HDR_HELPER helper = new PT_IL_PAYVOU_HDR_HELPER();
			if(!preFormFlag){
				dummyHelper.preForm();
				dummyHelper.WHEN_NEW_FORM_INSTANCE();
//				dummyHelper.whenCreateRecord();
				preFormFlag = true;
			}
			
			if(!isOnLoadFlag()){
				dummyHelper.whenNewBlockInstance();
				helper.whenNewBlockInstance();
				helper.whenNewRecordInstance();
				setOnLoadFlag(true);
			}
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	/*public void onLoad(PhaseEvent event){
		try {
			DUMMY_HELPER dummyHelper = new DUMMY_HELPER();
			PT_IL_PAYVOU_HDR_HELPER helper = new PT_IL_PAYVOU_HDR_HELPER();
			if(isFormFlag()){
				System.out.println("inside formmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
				dummyHelper.preForm();
				dummyHelper.WHEN_NEW_FORM_INSTANCE();
//				dummyHelper.whenCreateRecord();
				setFormFlag(false);
			}
			
			if(isBlockFlag()){
				System.out.println("inside blockkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
				dummyHelper.whenNewBlockInstance();
				helper.whenNewBlockInstance();
				helper.whenNewRecordInstance();
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}*/
	
	public void UI_M_CL_CLAIM_FM_NOValidate(ActionEvent event){
		try {
			getErrorMap().clear();
			UIInput input = (UIInput) event.getComponent().getParent();
			String value = (String) input.getSubmittedValue();
			DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
			dummyAction.getDUMMY_BEAN().setUI_M_CL_CLAIM_FM_NO(value);
			DUMMY_HELPER helper = new DUMMY_HELPER();
			helper.UI_M_CL_CLAIM_FM_NOValidator();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void UI_M_CL_CLAIM_TO_NOValidate(ActionEvent event){
		try {
			getErrorMap().clear();
			UIInput input = (UIInput) event.getComponent().getParent();
			String value = (String) input.getSubmittedValue();
			DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
			dummyAction.getDUMMY_BEAN().setUI_M_CL_CLAIM_TO_NO(value);
			DUMMY_HELPER helper = new DUMMY_HELPER();
			helper.UI_M_CL_CLAIM_TO_NOValidator();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void UI_M_CL_POLICY_FM_NOValidate(ActionEvent event){
		try {
			getErrorMap().clear();
			UIInput input = (UIInput) event.getComponent().getParent();
			String value = (String) input.getSubmittedValue();
			DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
			dummyAction.getDUMMY_BEAN().setUI_M_CL_POLICY_FM_NO(value);
			DUMMY_HELPER helper = new DUMMY_HELPER();
			helper.UI_M_CL_POLICY_FM_NOValidator();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void UI_M_CL_POLICY_TO_NOValidate(ActionEvent event){
		try {
			getErrorMap().clear();
			UIInput input = (UIInput) event.getComponent().getParent();
			String value = (String) input.getSubmittedValue();
			DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
			dummyAction.getDUMMY_BEAN().setUI_M_CL_POLICY_TO_NO(value);
			DUMMY_HELPER helper = new DUMMY_HELPER();
			helper.UI_M_CL_POLICY_TO_NOValidator();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void UI_M_CL_PROCESS_FM_DTValidator(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		dummyAction.getDUMMY_BEAN().setUI_M_CL_PROCESS_FM_DT((Date) value);
		DUMMY_HELPER helper = new DUMMY_HELPER();
		helper.UI_M_CL_PROCESS_FM_DTValidator();
	}
	
	public void UI_M_CL_PROCESS_FM_DTValidate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void UI_M_CL_PROCESS_TO_DTValidator(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		dummyAction.getDUMMY_BEAN().setUI_M_CL_PROCESS_TO_DT((Date)value);
		DUMMY_HELPER helper = new DUMMY_HELPER();
		helper.UI_M_CL_PROCESS_TO_DTValidator();
	}
	
	public void UI_M_CL_PROCESS_TO_DTValidate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public List<DUMMY> claimNoList(Object value){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		return helper.M_CL_CLAIM_NO_LIST((String) value);
	}
	
	public List<DUMMY> policyNoList(Object value){
		DUMMY_HELPER helper = new DUMMY_HELPER();
		return helper.M_CL_POLICY_NO_LIST((String) value);
	}
	
	
	/*public void saveRecord(){
		try {
		getErrorMap().clear();
		getWarningMap().clear();
		DUMMY_HELPER helper = new DUMMY_HELPER();
		if (getPT_IL_PAYVOU_HDR_BEAN().getROWID() != null) {
			new CRUDHandler().executeInsert(getPT_IL_PAYVOU_HDR_BEAN(),
					CommonUtils.getConnection());
			helper.keyCommit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelErrorMessagePath, "UPDATE_MESSAGE"));
		} else {
			helper.preInsert(getPT_IL_PAYVOU_HDR_BEAN());
			new CRUDHandler().executeInsert(getPT_IL_PAYVOU_HDR_BEAN(),
					CommonUtils.getConnection());
			helper.keyCommit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
		}
		CommonUtils.getConnection().commit();
	} catch (Exception e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		//getErrorMap().put("SAVE", e.getMessage());
	}
	
  }*/
	
	
	
	public void saveRecord(){
		try {
			DUMMY_HELPER helper = new DUMMY_HELPER();
			helper.keyCommit();
			PILT030_APAC_ACTION_INSTANCE.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelErrorMessagePath, "UPDATE_MESSAGE"));
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("description", e.getMessage());
		}
	}
	
}
