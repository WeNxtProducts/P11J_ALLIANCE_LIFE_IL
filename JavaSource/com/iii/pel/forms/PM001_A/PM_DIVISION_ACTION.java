package com.iii.pel.forms.PM001_A;

import java.util.ArrayList;
import java.util.Date;

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
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_DIVISION_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DIVN_CODE_LABEL;

	private HtmlInputText COMP_DIVN_CODE;

	private HtmlOutputLabel COMP_DIVN_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_DIVN_FRZ_FLAG;

	private HtmlOutputLabel COMP_DIVN_NAME_LABEL;

	private HtmlInputText COMP_DIVN_NAME;

	private HtmlOutputLabel COMP_DIVN_SHORT_NAME_LABEL;

	private HtmlInputText COMP_DIVN_SHORT_NAME;

	private HtmlOutputLabel COMP_DIVN_COMP_CODE_LABEL;

	private HtmlInputText COMP_DIVN_COMP_CODE;

	private HtmlOutputLabel COMP_UI_M_COMP_NAME_LABEL;

	private HtmlInputText COMP_UI_M_COMP_NAME;

	private HtmlOutputLabel COMP_DIVN_ADDR1_LABEL;

	private HtmlInputText COMP_DIVN_ADDR1;

	private HtmlOutputLabel COMP_DIVN_ADDR2_LABEL;

	private HtmlInputText COMP_DIVN_ADDR2;

	private HtmlOutputLabel COMP_DIVN_ADDR3_LABEL;

	private HtmlInputText COMP_DIVN_ADDR3;

	private HtmlOutputLabel COMP_DIVN_MGR_NAME_LABEL;

	private HtmlInputText COMP_DIVN_MGR_NAME;

	private HtmlOutputLabel COMP_DIVN_PHONE_LABEL;

	private HtmlInputText COMP_DIVN_PHONE;

	private HtmlOutputLabel COMP_DIVN_FAX_LABEL;

	private HtmlInputText COMP_DIVN_FAX;

	private HtmlOutputLabel COMP_DIVN_CONTRA_ACNT_CODE_LABEL;

	private HtmlInputText COMP_DIVN_CONTRA_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_CONTRA_ACNT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CONTRA_ACNT_DESC;

	private HtmlOutputLabel COMP_DIVN_BL_NAME_LABEL;

	private HtmlInputText COMP_DIVN_BL_NAME;

	private HtmlOutputLabel COMP_DIVN_BL_SHORT_NAME_LABEL;

	private HtmlInputText COMP_DIVN_BL_SHORT_NAME;

	private HtmlOutputLabel COMP_DIVN_BL_ADDR1_LABEL;

	private HtmlInputText COMP_DIVN_BL_ADDR1;

	private HtmlOutputLabel COMP_DIVN_BL_ADDR2_LABEL;

	private HtmlInputText COMP_DIVN_BL_ADDR2;

	private HtmlOutputLabel COMP_DIVN_BL_ADDR3_LABEL;

	private HtmlInputText COMP_DIVN_BL_ADDR3;

	private HtmlOutputLabel COMP_DIVN_BL_MGR_NAME_LABEL;

	private HtmlInputText COMP_DIVN_BL_MGR_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_EDIT_DEPT_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_EDIT_MGR_NAME;

	private HtmlCommandButton COMP_UI_M_LOV_DIVN_COMP_CODE;

	private HtmlCommandButton COMP_PUSH_BUTTON162;

	private PM_DIVISION PM_DIVISION_BEAN;
	
	//private PM_DEPARTMENT PM_DEPARTMENT_BEAN;
	
	//private PM_DEPARTMENT_ACTION PM_DEPARTMENT_ACTION_BEAN;

	public PM001_A_COMPOSITE_ACTION compositeAction;

	private PM_DIVISION_HELPER helper;

	public PM_DIVISION_ACTION() {
		PM_DIVISION_BEAN = new PM_DIVISION();
		helper = new PM_DIVISION_HELPER();
		/*PM_DEPARTMENT_BEAN = new PM_DEPARTMENT();
		PM_DEPARTMENT_ACTION_BEAN = new PM_DEPARTMENT_ACTION();
		PM_DEPARTMENT_ACTION_BEAN.pm_division_action = this;
		PM_DEPARTMENT_ACTION_BEAN.instantiateAllComponent();*/
		instantiateAllComponent();
		}

	public HtmlOutputLabel getCOMP_DIVN_CODE_LABEL() {
		return COMP_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_CODE() {
		return COMP_DIVN_CODE;
	}

	public void setCOMP_DIVN_CODE_LABEL(HtmlOutputLabel COMP_DIVN_CODE_LABEL) {
		this.COMP_DIVN_CODE_LABEL = COMP_DIVN_CODE_LABEL;
	}

	public void setCOMP_DIVN_CODE(HtmlInputText COMP_DIVN_CODE) {
		this.COMP_DIVN_CODE = COMP_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_DIVN_FRZ_FLAG_LABEL() {
		return COMP_DIVN_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_DIVN_FRZ_FLAG() {
		return COMP_DIVN_FRZ_FLAG;
	}

	public void setCOMP_DIVN_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_DIVN_FRZ_FLAG_LABEL) {
		this.COMP_DIVN_FRZ_FLAG_LABEL = COMP_DIVN_FRZ_FLAG_LABEL;
	}

	public void setCOMP_DIVN_FRZ_FLAG(
			HtmlSelectBooleanCheckbox COMP_DIVN_FRZ_FLAG) {
		this.COMP_DIVN_FRZ_FLAG = COMP_DIVN_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_DIVN_NAME_LABEL() {
		return COMP_DIVN_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_NAME() {
		return COMP_DIVN_NAME;
	}

	public void setCOMP_DIVN_NAME_LABEL(HtmlOutputLabel COMP_DIVN_NAME_LABEL) {
		this.COMP_DIVN_NAME_LABEL = COMP_DIVN_NAME_LABEL;
	}

	public void setCOMP_DIVN_NAME(HtmlInputText COMP_DIVN_NAME) {
		this.COMP_DIVN_NAME = COMP_DIVN_NAME;
	}

	public HtmlOutputLabel getCOMP_DIVN_SHORT_NAME_LABEL() {
		return COMP_DIVN_SHORT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_SHORT_NAME() {
		return COMP_DIVN_SHORT_NAME;
	}

	public void setCOMP_DIVN_SHORT_NAME_LABEL(
			HtmlOutputLabel COMP_DIVN_SHORT_NAME_LABEL) {
		this.COMP_DIVN_SHORT_NAME_LABEL = COMP_DIVN_SHORT_NAME_LABEL;
	}

	public void setCOMP_DIVN_SHORT_NAME(HtmlInputText COMP_DIVN_SHORT_NAME) {
		this.COMP_DIVN_SHORT_NAME = COMP_DIVN_SHORT_NAME;
	}

	public HtmlOutputLabel getCOMP_DIVN_COMP_CODE_LABEL() {
		return COMP_DIVN_COMP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_COMP_CODE() {
		return COMP_DIVN_COMP_CODE;
	}

	public void setCOMP_DIVN_COMP_CODE_LABEL(
			HtmlOutputLabel COMP_DIVN_COMP_CODE_LABEL) {
		this.COMP_DIVN_COMP_CODE_LABEL = COMP_DIVN_COMP_CODE_LABEL;
	}

	public void setCOMP_DIVN_COMP_CODE(HtmlInputText COMP_DIVN_COMP_CODE) {
		this.COMP_DIVN_COMP_CODE = COMP_DIVN_COMP_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COMP_NAME_LABEL() {
		return COMP_UI_M_COMP_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COMP_NAME() {
		return COMP_UI_M_COMP_NAME;
	}

	public void setCOMP_UI_M_COMP_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_COMP_NAME_LABEL) {
		this.COMP_UI_M_COMP_NAME_LABEL = COMP_UI_M_COMP_NAME_LABEL;
	}

	public void setCOMP_UI_M_COMP_NAME(HtmlInputText COMP_UI_M_COMP_NAME) {
		this.COMP_UI_M_COMP_NAME = COMP_UI_M_COMP_NAME;
	}

	public HtmlOutputLabel getCOMP_DIVN_ADDR1_LABEL() {
		return COMP_DIVN_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_ADDR1() {
		return COMP_DIVN_ADDR1;
	}

	public void setCOMP_DIVN_ADDR1_LABEL(HtmlOutputLabel COMP_DIVN_ADDR1_LABEL) {
		this.COMP_DIVN_ADDR1_LABEL = COMP_DIVN_ADDR1_LABEL;
	}

	public void setCOMP_DIVN_ADDR1(HtmlInputText COMP_DIVN_ADDR1) {
		this.COMP_DIVN_ADDR1 = COMP_DIVN_ADDR1;
	}

	public HtmlOutputLabel getCOMP_DIVN_ADDR2_LABEL() {
		return COMP_DIVN_ADDR2_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_ADDR2() {
		return COMP_DIVN_ADDR2;
	}

	public void setCOMP_DIVN_ADDR2_LABEL(HtmlOutputLabel COMP_DIVN_ADDR2_LABEL) {
		this.COMP_DIVN_ADDR2_LABEL = COMP_DIVN_ADDR2_LABEL;
	}

	public void setCOMP_DIVN_ADDR2(HtmlInputText COMP_DIVN_ADDR2) {
		this.COMP_DIVN_ADDR2 = COMP_DIVN_ADDR2;
	}

	public HtmlOutputLabel getCOMP_DIVN_ADDR3_LABEL() {
		return COMP_DIVN_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_ADDR3() {
		return COMP_DIVN_ADDR3;
	}

	public void setCOMP_DIVN_ADDR3_LABEL(HtmlOutputLabel COMP_DIVN_ADDR3_LABEL) {
		this.COMP_DIVN_ADDR3_LABEL = COMP_DIVN_ADDR3_LABEL;
	}

	public void setCOMP_DIVN_ADDR3(HtmlInputText COMP_DIVN_ADDR3) {
		this.COMP_DIVN_ADDR3 = COMP_DIVN_ADDR3;
	}

	public HtmlOutputLabel getCOMP_DIVN_MGR_NAME_LABEL() {
		return COMP_DIVN_MGR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_MGR_NAME() {
		return COMP_DIVN_MGR_NAME;
	}

	public void setCOMP_DIVN_MGR_NAME_LABEL(
			HtmlOutputLabel COMP_DIVN_MGR_NAME_LABEL) {
		this.COMP_DIVN_MGR_NAME_LABEL = COMP_DIVN_MGR_NAME_LABEL;
	}

	public void setCOMP_DIVN_MGR_NAME(HtmlInputText COMP_DIVN_MGR_NAME) {
		this.COMP_DIVN_MGR_NAME = COMP_DIVN_MGR_NAME;
	}

	public HtmlOutputLabel getCOMP_DIVN_PHONE_LABEL() {
		return COMP_DIVN_PHONE_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_PHONE() {
		return COMP_DIVN_PHONE;
	}

	public void setCOMP_DIVN_PHONE_LABEL(HtmlOutputLabel COMP_DIVN_PHONE_LABEL) {
		this.COMP_DIVN_PHONE_LABEL = COMP_DIVN_PHONE_LABEL;
	}

	public void setCOMP_DIVN_PHONE(HtmlInputText COMP_DIVN_PHONE) {
		this.COMP_DIVN_PHONE = COMP_DIVN_PHONE;
	}

	public HtmlOutputLabel getCOMP_DIVN_FAX_LABEL() {
		return COMP_DIVN_FAX_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_FAX() {
		return COMP_DIVN_FAX;
	}

	public void setCOMP_DIVN_FAX_LABEL(HtmlOutputLabel COMP_DIVN_FAX_LABEL) {
		this.COMP_DIVN_FAX_LABEL = COMP_DIVN_FAX_LABEL;
	}

	public void setCOMP_DIVN_FAX(HtmlInputText COMP_DIVN_FAX) {
		this.COMP_DIVN_FAX = COMP_DIVN_FAX;
	}

	public HtmlOutputLabel getCOMP_DIVN_CONTRA_ACNT_CODE_LABEL() {
		return COMP_DIVN_CONTRA_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_CONTRA_ACNT_CODE() {
		return COMP_DIVN_CONTRA_ACNT_CODE;
	}

	public void setCOMP_DIVN_CONTRA_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_DIVN_CONTRA_ACNT_CODE_LABEL) {
		this.COMP_DIVN_CONTRA_ACNT_CODE_LABEL = COMP_DIVN_CONTRA_ACNT_CODE_LABEL;
	}

	public void setCOMP_DIVN_CONTRA_ACNT_CODE(
			HtmlInputText COMP_DIVN_CONTRA_ACNT_CODE) {
		this.COMP_DIVN_CONTRA_ACNT_CODE = COMP_DIVN_CONTRA_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONTRA_ACNT_DESC_LABEL() {
		return COMP_UI_M_CONTRA_ACNT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONTRA_ACNT_DESC() {
		return COMP_UI_M_CONTRA_ACNT_DESC;
	}

	public void setCOMP_UI_M_CONTRA_ACNT_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CONTRA_ACNT_DESC_LABEL) {
		this.COMP_UI_M_CONTRA_ACNT_DESC_LABEL = COMP_UI_M_CONTRA_ACNT_DESC_LABEL;
	}

	public void setCOMP_UI_M_CONTRA_ACNT_DESC(
			HtmlInputText COMP_UI_M_CONTRA_ACNT_DESC) {
		this.COMP_UI_M_CONTRA_ACNT_DESC = COMP_UI_M_CONTRA_ACNT_DESC;
	}

	public HtmlOutputLabel getCOMP_DIVN_BL_NAME_LABEL() {
		return COMP_DIVN_BL_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_BL_NAME() {
		return COMP_DIVN_BL_NAME;
	}

	public void setCOMP_DIVN_BL_NAME_LABEL(
			HtmlOutputLabel COMP_DIVN_BL_NAME_LABEL) {
		this.COMP_DIVN_BL_NAME_LABEL = COMP_DIVN_BL_NAME_LABEL;
	}

	public void setCOMP_DIVN_BL_NAME(HtmlInputText COMP_DIVN_BL_NAME) {
		this.COMP_DIVN_BL_NAME = COMP_DIVN_BL_NAME;
	}

	public HtmlOutputLabel getCOMP_DIVN_BL_SHORT_NAME_LABEL() {
		return COMP_DIVN_BL_SHORT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_BL_SHORT_NAME() {
		return COMP_DIVN_BL_SHORT_NAME;
	}

	public void setCOMP_DIVN_BL_SHORT_NAME_LABEL(
			HtmlOutputLabel COMP_DIVN_BL_SHORT_NAME_LABEL) {
		this.COMP_DIVN_BL_SHORT_NAME_LABEL = COMP_DIVN_BL_SHORT_NAME_LABEL;
	}

	public void setCOMP_DIVN_BL_SHORT_NAME(HtmlInputText COMP_DIVN_BL_SHORT_NAME) {
		this.COMP_DIVN_BL_SHORT_NAME = COMP_DIVN_BL_SHORT_NAME;
	}

	public HtmlOutputLabel getCOMP_DIVN_BL_ADDR1_LABEL() {
		return COMP_DIVN_BL_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_BL_ADDR1() {
		return COMP_DIVN_BL_ADDR1;
	}

	public void setCOMP_DIVN_BL_ADDR1_LABEL(
			HtmlOutputLabel COMP_DIVN_BL_ADDR1_LABEL) {
		this.COMP_DIVN_BL_ADDR1_LABEL = COMP_DIVN_BL_ADDR1_LABEL;
	}

	public void setCOMP_DIVN_BL_ADDR1(HtmlInputText COMP_DIVN_BL_ADDR1) {
		this.COMP_DIVN_BL_ADDR1 = COMP_DIVN_BL_ADDR1;
	}

	public HtmlOutputLabel getCOMP_DIVN_BL_ADDR2_LABEL() {
		return COMP_DIVN_BL_ADDR2_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_BL_ADDR2() {
		return COMP_DIVN_BL_ADDR2;
	}

	public void setCOMP_DIVN_BL_ADDR2_LABEL(
			HtmlOutputLabel COMP_DIVN_BL_ADDR2_LABEL) {
		this.COMP_DIVN_BL_ADDR2_LABEL = COMP_DIVN_BL_ADDR2_LABEL;
	}

	public void setCOMP_DIVN_BL_ADDR2(HtmlInputText COMP_DIVN_BL_ADDR2) {
		this.COMP_DIVN_BL_ADDR2 = COMP_DIVN_BL_ADDR2;
	}

	public HtmlOutputLabel getCOMP_DIVN_BL_ADDR3_LABEL() {
		return COMP_DIVN_BL_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_BL_ADDR3() {
		return COMP_DIVN_BL_ADDR3;
	}

	public void setCOMP_DIVN_BL_ADDR3_LABEL(
			HtmlOutputLabel COMP_DIVN_BL_ADDR3_LABEL) {
		this.COMP_DIVN_BL_ADDR3_LABEL = COMP_DIVN_BL_ADDR3_LABEL;
	}

	public void setCOMP_DIVN_BL_ADDR3(HtmlInputText COMP_DIVN_BL_ADDR3) {
		this.COMP_DIVN_BL_ADDR3 = COMP_DIVN_BL_ADDR3;
	}

	public HtmlOutputLabel getCOMP_DIVN_BL_MGR_NAME_LABEL() {
		return COMP_DIVN_BL_MGR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_BL_MGR_NAME() {
		return COMP_DIVN_BL_MGR_NAME;
	}

	public void setCOMP_DIVN_BL_MGR_NAME_LABEL(
			HtmlOutputLabel COMP_DIVN_BL_MGR_NAME_LABEL) {
		this.COMP_DIVN_BL_MGR_NAME_LABEL = COMP_DIVN_BL_MGR_NAME_LABEL;
	}

	public void setCOMP_DIVN_BL_MGR_NAME(HtmlInputText COMP_DIVN_BL_MGR_NAME) {
		this.COMP_DIVN_BL_MGR_NAME = COMP_DIVN_BL_MGR_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDIT_DEPT_NAME() {
		return COMP_UI_M_BUT_EDIT_DEPT_NAME;
	}

	public void setCOMP_UI_M_BUT_EDIT_DEPT_NAME(
			HtmlCommandButton COMP_UI_M_BUT_EDIT_DEPT_NAME) {
		this.COMP_UI_M_BUT_EDIT_DEPT_NAME = COMP_UI_M_BUT_EDIT_DEPT_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDIT_MGR_NAME() {
		return COMP_UI_M_BUT_EDIT_MGR_NAME;
	}

	public void setCOMP_UI_M_BUT_EDIT_MGR_NAME(
			HtmlCommandButton COMP_UI_M_BUT_EDIT_MGR_NAME) {
		this.COMP_UI_M_BUT_EDIT_MGR_NAME = COMP_UI_M_BUT_EDIT_MGR_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_DIVN_COMP_CODE() {
		return COMP_UI_M_LOV_DIVN_COMP_CODE;
	}

	public void setCOMP_UI_M_LOV_DIVN_COMP_CODE(
			HtmlCommandButton COMP_UI_M_LOV_DIVN_COMP_CODE) {
		this.COMP_UI_M_LOV_DIVN_COMP_CODE = COMP_UI_M_LOV_DIVN_COMP_CODE;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON162() {
		return COMP_PUSH_BUTTON162;
	}

	public void setCOMP_PUSH_BUTTON162(HtmlCommandButton COMP_PUSH_BUTTON162) {
		this.COMP_PUSH_BUTTON162 = COMP_PUSH_BUTTON162;
	}

	public PM_DIVISION getPM_DIVISION_BEAN() {
		return PM_DIVISION_BEAN;
	}

	public void setPM_DIVISION_BEAN(PM_DIVISION PM_DIVISION_BEAN) {
		this.PM_DIVISION_BEAN = PM_DIVISION_BEAN;
	}

	public void validateDIVN_FRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				PM_DIVISION_BEAN
						.setDIVN_FRZ_FLAG(PELConstants.CHECKBOX_CHECKED);
			} else {
				PM_DIVISION_BEAN
						.setDIVN_FRZ_FLAG(PELConstants.CHECKBOX_UNCHECKED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (isDELETE_ALLOWED()) {
				helper.pre_Delete(compositeAction);
				// helper.ON_CHECK_DELETE_MASTER(PM_DIVISION_BEAN);
				new CRUDHandler().executeDelete(PM_DIVISION_BEAN, CommonUtils
						.getConnection());
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));

			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
	}

	public void saveRecord() {
		String message = null;
		CommonUtils.clearMaps(this);
		try {
			if (getPM_DIVISION_BEAN().getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.PRE_UPDATE(compositeAction);
					new CRUDHandler().executeUpdate(PM_DIVISION_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							"current",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");
				}
			} else {
				if (isINSERT_ALLOWED()) {
					helper.preInsert(compositeAction);
					new CRUDHandler().executeInsert(PM_DIVISION_BEAN,
							CommonUtils.getConnection());
					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
				}
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);
		} catch (Exception e) {
			String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, error);
			getErrorMap().put("SAVE", error);

		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				if(PM_DIVISION_BEAN.getROWID() != null){
				helper.executeQuery(compositeAction);
				//new PM_DEPARTMENT_HELPER().executeQuery(compositeAction);
				helper.postQuery(compositeAction);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void validateDIV_CODE(FacesContext context, UIComponent component,
			Object value) {
		String currValue = (String) value;
		String beanValue = PM_DIVISION_BEAN.getDIVN_CODE();
		try {
			if(!(currValue.equalsIgnoreCase(beanValue))){
			helper.DIVN_CODE_WHEN_VALIDATE_ITEM(compositeAction,currValue);
			PM_DIVISION_BEAN.setDIVN_CODE((String) value);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validateDIVN_NAME(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_NAME((String) value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	
	public void validateDIVN_COMP_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_COMP_CODE((String) value);
			helper.DIVN_COMP_CODE_WHEN_VALIDATE_ITEM(compositeAction);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateM_COMP_NAME_(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setUI_M_COMP_NAME((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_ADDR1(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_ADDR1((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_ADDR2(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_ADDR2((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_ADDR3(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_ADDR3((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_MGR_NAME(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_MGR_NAME((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_BL_MGR_NAME(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_BL_MGR_NAME((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_CR_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			Date currvalue = (Date) value;

			PM_DIVISION_BEAN.setDIVN_CR_DT(currvalue);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_DIVN_PHONE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_PHONE((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_DIVN_FAX(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_FAX((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_BL_NAME(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_BL_NAME((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_BL_SHORTNAME(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_BL_SHORT_NAME((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateDIVN_CONTRA_ACNT_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setDIVN_CONTRA_ACNT_CODE((String) value);
			helper.DIVN_CONTRA_ACNT_CODE_WHEN_VALIDATE_ITEM(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_CONTRA_ACNT_DESC(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DIVISION_BEAN.setUI_M_CONTRA_ACNT_DESC((String) value);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	/*public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PM_DEPARTMENT_BEAN = new PM_DEPARTMENT();
				compositeAction.getPM_DEPARTMENT_ACTION_BEAN().resetAllComponent();
				compositeAction.getPM_DEPARTMENT_ACTION_BEAN().resetSelectedRow();
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}*/
	

	/**
	 * Instantiates all components in PM_DIVISION_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_EDIT_DEPT_NAME			 = new HtmlCommandButton();
		COMP_UI_M_BUT_EDIT_MGR_NAME			 = new HtmlCommandButton();
		COMP_UI_M_LOV_DIVN_COMP_CODE			 = new HtmlCommandButton();
		COMP_PUSH_BUTTON162				 = new HtmlCommandButton();

	}

	public String backButton(){
		return "PM001_A";
	}

	/*public PM_DEPARTMENT getPM_DEPARTMENT_BEAN() {
		return PM_DEPARTMENT_BEAN;
	}

	public void setPM_DEPARTMENT_BEAN(PM_DEPARTMENT pm_department_bean) {
		PM_DEPARTMENT_BEAN = pm_department_bean;
	}

	public PM_DEPARTMENT_ACTION getPM_DEPARTMENT_ACTION_BEAN() {
		return PM_DEPARTMENT_ACTION_BEAN;
	}

	public void setPM_DEPARTMENT_ACTION_BEAN(
			PM_DEPARTMENT_ACTION pm_department_action_bean) {
		//PM_DEPARTMENT_ACTION_BEAN = pm_department_action_bean;
	}
*/
	
	
	/*Added by janani on 17.8.2016 for company code suggestion box*/
	
	public ArrayList<LovBean> lovDIVN_COMP_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		/*String query = "SELECT  CONT_CODE,CONT_NAME  FROM   PM_IL_CONTRACTOR WHERE  CONT_EMPLOYER_YN ='Y' "
				+ "AND (CONT_CODE LIKE ? OR CONT_NAME LIKE ?) AND ROWNUM < ?";*/
		
		System.out.println("ENTERS INTO lovDIVN_COMP_CODE");
		
		/*
		 * 
		 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
		 * 
		 * String query ="select comp_code,comp_name from pm_company where comp_code like ?";*/
		
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
		String query ="select comp_code,comp_name from pm_company where upper(comp_code) like upper(?)";
		/*end*/
		
		Object[] values = null;
		String currentValue = (String) object;
		
		System.out.println("currentValue           :"+currentValue);

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] {currentValue};
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}	

/*end*/
	

	
}