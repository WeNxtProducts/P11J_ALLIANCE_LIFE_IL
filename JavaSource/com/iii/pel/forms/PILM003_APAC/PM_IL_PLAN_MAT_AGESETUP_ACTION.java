package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PLAN_MAT_AGESETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PMA_PLAN_CODE_LABEL;

	private HtmlInputText COMP_PMA_PLAN_CODE;

	private HtmlOutputLabel COMP_PMA_AGE_BASIS_LABEL;

	private HtmlSelectOneMenu COMP_PMA_AGE_BASIS;

	private HtmlOutputLabel COMP_PMA_MAT_MIN_PAYER_AGE_LABEL;

	private HtmlInputText COMP_PMA_MAT_MIN_PAYER_AGE;

	private HtmlOutputLabel COMP_PMA_MAT_PAYER_AGE_LABEL;

	private HtmlInputText COMP_PMA_MAT_PAYER_AGE;

	private HtmlOutputLabel COMP_PMA_MAT_MIN_PAYEE_AGE_LABEL;

	private HtmlInputText COMP_PMA_MAT_MIN_PAYEE_AGE;

	private HtmlOutputLabel COMP_PMA_MAT_PAYEE_AGE_LABEL;

	private HtmlInputText COMP_PMA_MAT_PAYEE_AGE;

	private PM_IL_PLAN_MAT_AGESETUP PM_IL_PLAN_MAT_AGESETUP_BEAN;

	public PILM003_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PLAN_MAT_AGESETUP_HELPER helper;

	private List<SelectItem> listPMA_AGE_BASIS = new ArrayList<SelectItem>();

	public PM_IL_PLAN_MAT_AGESETUP_ACTION() {

		PM_IL_PLAN_MAT_AGESETUP_BEAN = new PM_IL_PLAN_MAT_AGESETUP();
		helper = new PM_IL_PLAN_MAT_AGESETUP_HELPER();
		prepareDropDownList();
	}
	
	public void prepareDropDownList(){
		Connection connection;
		try{
			connection = CommonUtils.getConnection();
			listPMA_AGE_BASIS = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN_MAT_AGESETUP",
					"PM_IL_PLAN_MAT_AGESETUP.PMA_AGE_BASIS", "PACAGEBASIS");
			
			
			
		}catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PMA_PLAN_CODE_LABEL() {
		return COMP_PMA_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PMA_PLAN_CODE() {
		return COMP_PMA_PLAN_CODE;
	}

	public void setCOMP_PMA_PLAN_CODE_LABEL(
			HtmlOutputLabel COMP_PMA_PLAN_CODE_LABEL) {
		this.COMP_PMA_PLAN_CODE_LABEL = COMP_PMA_PLAN_CODE_LABEL;
	}

	public void setCOMP_PMA_PLAN_CODE(HtmlInputText COMP_PMA_PLAN_CODE) {
		this.COMP_PMA_PLAN_CODE = COMP_PMA_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_PMA_AGE_BASIS_LABEL() {
		return COMP_PMA_AGE_BASIS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PMA_AGE_BASIS() {
		return COMP_PMA_AGE_BASIS;
	}

	public void setCOMP_PMA_AGE_BASIS_LABEL(
			HtmlOutputLabel COMP_PMA_AGE_BASIS_LABEL) {
		this.COMP_PMA_AGE_BASIS_LABEL = COMP_PMA_AGE_BASIS_LABEL;
	}

	public void setCOMP_PMA_AGE_BASIS(HtmlSelectOneMenu COMP_PMA_AGE_BASIS) {
		this.COMP_PMA_AGE_BASIS = COMP_PMA_AGE_BASIS;
	}

	public HtmlOutputLabel getCOMP_PMA_MAT_MIN_PAYER_AGE_LABEL() {
		return COMP_PMA_MAT_MIN_PAYER_AGE_LABEL;
	}

	public HtmlInputText getCOMP_PMA_MAT_MIN_PAYER_AGE() {
		return COMP_PMA_MAT_MIN_PAYER_AGE;
	}

	public void setCOMP_PMA_MAT_MIN_PAYER_AGE_LABEL(
			HtmlOutputLabel COMP_PMA_MAT_MIN_PAYER_AGE_LABEL) {
		this.COMP_PMA_MAT_MIN_PAYER_AGE_LABEL = COMP_PMA_MAT_MIN_PAYER_AGE_LABEL;
	}

	public void setCOMP_PMA_MAT_MIN_PAYER_AGE(
			HtmlInputText COMP_PMA_MAT_MIN_PAYER_AGE) {
		this.COMP_PMA_MAT_MIN_PAYER_AGE = COMP_PMA_MAT_MIN_PAYER_AGE;
	}

	public HtmlOutputLabel getCOMP_PMA_MAT_PAYER_AGE_LABEL() {
		return COMP_PMA_MAT_PAYER_AGE_LABEL;
	}

	public HtmlInputText getCOMP_PMA_MAT_PAYER_AGE() {
		return COMP_PMA_MAT_PAYER_AGE;
	}

	public void setCOMP_PMA_MAT_PAYER_AGE_LABEL(
			HtmlOutputLabel COMP_PMA_MAT_PAYER_AGE_LABEL) {
		this.COMP_PMA_MAT_PAYER_AGE_LABEL = COMP_PMA_MAT_PAYER_AGE_LABEL;
	}

	public void setCOMP_PMA_MAT_PAYER_AGE(HtmlInputText COMP_PMA_MAT_PAYER_AGE) {
		this.COMP_PMA_MAT_PAYER_AGE = COMP_PMA_MAT_PAYER_AGE;
	}

	public HtmlOutputLabel getCOMP_PMA_MAT_MIN_PAYEE_AGE_LABEL() {
		return COMP_PMA_MAT_MIN_PAYEE_AGE_LABEL;
	}

	public HtmlInputText getCOMP_PMA_MAT_MIN_PAYEE_AGE() {
		return COMP_PMA_MAT_MIN_PAYEE_AGE;
	}

	public void setCOMP_PMA_MAT_MIN_PAYEE_AGE_LABEL(
			HtmlOutputLabel COMP_PMA_MAT_MIN_PAYEE_AGE_LABEL) {
		this.COMP_PMA_MAT_MIN_PAYEE_AGE_LABEL = COMP_PMA_MAT_MIN_PAYEE_AGE_LABEL;
	}

	public void setCOMP_PMA_MAT_MIN_PAYEE_AGE(
			HtmlInputText COMP_PMA_MAT_MIN_PAYEE_AGE) {
		this.COMP_PMA_MAT_MIN_PAYEE_AGE = COMP_PMA_MAT_MIN_PAYEE_AGE;
	}

	public HtmlOutputLabel getCOMP_PMA_MAT_PAYEE_AGE_LABEL() {
		return COMP_PMA_MAT_PAYEE_AGE_LABEL;
	}

	public HtmlInputText getCOMP_PMA_MAT_PAYEE_AGE() {
		return COMP_PMA_MAT_PAYEE_AGE;
	}

	public void setCOMP_PMA_MAT_PAYEE_AGE_LABEL(
			HtmlOutputLabel COMP_PMA_MAT_PAYEE_AGE_LABEL) {
		this.COMP_PMA_MAT_PAYEE_AGE_LABEL = COMP_PMA_MAT_PAYEE_AGE_LABEL;
	}

	public void setCOMP_PMA_MAT_PAYEE_AGE(HtmlInputText COMP_PMA_MAT_PAYEE_AGE) {
		this.COMP_PMA_MAT_PAYEE_AGE = COMP_PMA_MAT_PAYEE_AGE;
	}

	public PM_IL_PLAN_MAT_AGESETUP getPM_IL_PLAN_MAT_AGESETUP_BEAN() {
		return PM_IL_PLAN_MAT_AGESETUP_BEAN;
	}

	public void setPM_IL_PLAN_MAT_AGESETUP_BEAN(
			PM_IL_PLAN_MAT_AGESETUP PM_IL_PLAN_MAT_AGESETUP_BEAN) {
		this.PM_IL_PLAN_MAT_AGESETUP_BEAN = PM_IL_PLAN_MAT_AGESETUP_BEAN;
	}

  public void saveRecord() {
		String message = null;
		try {
			if (getPM_IL_PLAN_MAT_AGESETUP_BEAN().getROWID() != null) {
				
				
				new CRUDHandler().executeInsert(
						getPM_IL_PLAN_MAT_AGESETUP_BEAN(), CommonUtils
								.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
    	    	message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");

			} else {
				PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_PLAN_CODE(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE());
				new CRUDHandler().executeInsert(
						getPM_IL_PLAN_MAT_AGESETUP_BEAN(), CommonUtils
								.getConnection());
				CommonUtils.getConnection().commit();
			
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
					message = Messages.getString("messageProperties","errorPanel$message$save");
			}
			
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPMA_AGE_BASIS() {
		if (listPMA_AGE_BASIS.size() == 0) {
			listPMA_AGE_BASIS.clear();
			try {
				listPMA_AGE_BASIS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPMA_AGE_BASIS;
	}

	public void setListPMA_AGE_BASIS(List<SelectItem> listPMA_AGE_BASIS) {
		this.listPMA_AGE_BASIS = listPMA_AGE_BASIS;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
					helper.executeQuery(compositeAction);
					if(PM_IL_PLAN_MAT_AGESETUP_BEAN.getROWID() == null){
					    helper.whenCreateRecord(PM_IL_PLAN_MAT_AGESETUP_BEAN);
					}
				helper.whenNewRecordInstance(this);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void validatePMA_AGE_BASIS(FacesContext context,
			UIComponent component, Object value){
		try{
			String  PMA_AGE_BASIS = (String)value;
			PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_AGE_BASIS(PMA_AGE_BASIS);
			helper.whenValidate_PMA_AGE_BASIS(this);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePMA_MAT_MIN_PAYER_AGE(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer  PMA_MAT_MIN_PAYER_AGE = (Integer)value;
			PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_MAT_MIN_PAYER_AGE(PMA_MAT_MIN_PAYER_AGE);
			helper.whenValidate_PMA_MAT_MIN_PAYER_AGE(PM_IL_PLAN_MAT_AGESETUP_BEAN, PMA_MAT_MIN_PAYER_AGE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePMA_MAT_PAYER_AGE(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer  PMA_MAT_PAYER_AGE = (Integer)value;
			PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_MAT_PAYER_AGE(PMA_MAT_PAYER_AGE);
			helper.whenValidate_PMA_MAT_PAYER_AGE(PM_IL_PLAN_MAT_AGESETUP_BEAN, PMA_MAT_PAYER_AGE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePMA_MAT_MIN_PAYEE_AGE(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer  PMA_MAT_MIN_PAYEE_AGE = (Integer)value;
			PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_MAT_MIN_PAYEE_AGE(PMA_MAT_MIN_PAYEE_AGE);
			helper.whenValidate_PMA_MAT_MIN_PAYEE_AGE(PM_IL_PLAN_MAT_AGESETUP_BEAN, PMA_MAT_MIN_PAYEE_AGE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePMA_MAT_PAYEE_AGE(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer  PMA_MAT_PAYEE_AGE = (Integer)value;
			PM_IL_PLAN_MAT_AGESETUP_BEAN.setPMA_MAT_PAYEE_AGE(PMA_MAT_PAYEE_AGE);
			helper.whenValidate_PMA_MAT_PAYEE_AGE(PM_IL_PLAN_MAT_AGESETUP_BEAN, PMA_MAT_PAYEE_AGE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}
