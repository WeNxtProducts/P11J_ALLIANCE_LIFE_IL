package com.iii.pel.forms.PILM052_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import com.iii.pel.forms.PILM043.PM_IL_RI_POOL_SETUP;
import com.iii.pel.forms.PLM006_APAC.Code_Bean;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.utl_tcp.connection;

public class PM_DEPT_DRCR_LINK_ACTION extends CommonAction {

	public Map session = FacesContext.getCurrentInstance().getExternalContext()
			.getSessionMap();

	private HtmlOutputLabel COMP_DDL_TXN_TYPE_FM_LABEL;

	private HtmlInputText COMP_DDL_TXN_TYPE_FM;

	private HtmlOutputLabel COMP_DDL_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_DDL_FRZ_FLAG;

	private HtmlOutputLabel COMP_DDL_TXN_TYPE_TO_LABEL;

	private HtmlInputText COMP_DDL_TXN_TYPE_TO;

	private HtmlOutputLabel COMP_DDL_DIVN_CODE_LABEL;

	private HtmlInputText COMP_DDL_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_NAME;

	private HtmlOutputLabel COMP_DDL_DEPT_CODE_LABEL;

	private HtmlInputText COMP_DDL_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_NAME;

	private HtmlOutputLabel COMP_DDL_DR_TXN_CODE_LABEL;

	private HtmlInputText COMP_DDL_DR_TXN_CODE;

	private HtmlOutputLabel COMP_UI_M_TXN_DR_NAME_LABEL;

	private HtmlInputText COMP_UI_M_TXN_DR_NAME;

	private HtmlOutputLabel COMP_DDL_CR_TXN_CODE_LABEL;

	private HtmlInputText COMP_DDL_CR_TXN_CODE;

	private HtmlOutputLabel COMP_UI_M_TXN_CR_NAME_LABEL;

	private HtmlInputText COMP_UI_M_TXN_CR_NAME;

	private HtmlOutputLabel COMP_DDL_RCT_TXN_CODE_LABEL;

	private HtmlInputText COMP_DDL_RCT_TXN_CODE;

	private HtmlOutputLabel COMP_UI_M_TXN_RCT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_TXN_RCT_NAME;

	private HtmlOutputLabel COMP_DDL_PAY_TXN_CODE_LABEL;

	private HtmlInputText COMP_DDL_PAY_TXN_CODE;

	private HtmlOutputLabel COMP_UI_M_TXN_PAY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_TXN_PAY_NAME;

	private HtmlOutputLabel COMP_DDL_JV_TXN_CODE_LABEL;

	private HtmlInputText COMP_DDL_JV_TXN_CODE;

	private HtmlOutputLabel COMP_UI_M_TXN_JV_NAME_LABEL;

	private HtmlInputText COMP_UI_M_TXN_JV_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_DIVN;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_JV_TRN;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_DEPT;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_PAY_TRN;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_RCT_TRN;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CR_TRN;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_DEB_TRN;

	private PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN;

	public PILM052_APAC_COMPOSITE_ACTION compositeAction;

	private PM_DEPT_DRCR_LINK_HELPER helper;

	public PM_DEPT_DRCR_LINK_ACTION() {

		PM_DEPT_DRCR_LINK_BEAN = new PM_DEPT_DRCR_LINK();
		helper = new PM_DEPT_DRCR_LINK_HELPER();
	}

	public HtmlOutputLabel getCOMP_DDL_TXN_TYPE_FM_LABEL() {
		return COMP_DDL_TXN_TYPE_FM_LABEL;
	}

	public HtmlInputText getCOMP_DDL_TXN_TYPE_FM() {
		return COMP_DDL_TXN_TYPE_FM;
	}

	public void setCOMP_DDL_TXN_TYPE_FM_LABEL(
			HtmlOutputLabel COMP_DDL_TXN_TYPE_FM_LABEL) {
		this.COMP_DDL_TXN_TYPE_FM_LABEL = COMP_DDL_TXN_TYPE_FM_LABEL;
	}

	public void setCOMP_DDL_TXN_TYPE_FM(HtmlInputText COMP_DDL_TXN_TYPE_FM) {
		this.COMP_DDL_TXN_TYPE_FM = COMP_DDL_TXN_TYPE_FM;
	}

	public HtmlOutputLabel getCOMP_DDL_FRZ_FLAG_LABEL() {
		return COMP_DDL_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_DDL_FRZ_FLAG() {
		return COMP_DDL_FRZ_FLAG;
	}

	public void setCOMP_DDL_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_DDL_FRZ_FLAG_LABEL) {
		this.COMP_DDL_FRZ_FLAG_LABEL = COMP_DDL_FRZ_FLAG_LABEL;
	}

	public void setCOMP_DDL_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_DDL_FRZ_FLAG) {
		this.COMP_DDL_FRZ_FLAG = COMP_DDL_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_DDL_TXN_TYPE_TO_LABEL() {
		return COMP_DDL_TXN_TYPE_TO_LABEL;
	}

	public HtmlInputText getCOMP_DDL_TXN_TYPE_TO() {
		return COMP_DDL_TXN_TYPE_TO;
	}

	public void setCOMP_DDL_TXN_TYPE_TO_LABEL(
			HtmlOutputLabel COMP_DDL_TXN_TYPE_TO_LABEL) {
		this.COMP_DDL_TXN_TYPE_TO_LABEL = COMP_DDL_TXN_TYPE_TO_LABEL;
	}

	public void setCOMP_DDL_TXN_TYPE_TO(HtmlInputText COMP_DDL_TXN_TYPE_TO) {
		this.COMP_DDL_TXN_TYPE_TO = COMP_DDL_TXN_TYPE_TO;
	}

	public HtmlOutputLabel getCOMP_DDL_DIVN_CODE_LABEL() {
		return COMP_DDL_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DDL_DIVN_CODE() {
		return COMP_DDL_DIVN_CODE;
	}

	public void setCOMP_DDL_DIVN_CODE_LABEL(
			HtmlOutputLabel COMP_DDL_DIVN_CODE_LABEL) {
		this.COMP_DDL_DIVN_CODE_LABEL = COMP_DDL_DIVN_CODE_LABEL;
	}

	public void setCOMP_DDL_DIVN_CODE(HtmlInputText COMP_DDL_DIVN_CODE) {
		this.COMP_DDL_DIVN_CODE = COMP_DDL_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_NAME_LABEL() {
		return COMP_UI_M_DIVN_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_NAME() {
		return COMP_UI_M_DIVN_NAME;
	}

	public void setCOMP_UI_M_DIVN_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL) {
		this.COMP_UI_M_DIVN_NAME_LABEL = COMP_UI_M_DIVN_NAME_LABEL;
	}

	public void setCOMP_UI_M_DIVN_NAME(HtmlInputText COMP_UI_M_DIVN_NAME) {
		this.COMP_UI_M_DIVN_NAME = COMP_UI_M_DIVN_NAME;
	}

	public HtmlOutputLabel getCOMP_DDL_DEPT_CODE_LABEL() {
		return COMP_DDL_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DDL_DEPT_CODE() {
		return COMP_DDL_DEPT_CODE;
	}

	public void setCOMP_DDL_DEPT_CODE_LABEL(
			HtmlOutputLabel COMP_DDL_DEPT_CODE_LABEL) {
		this.COMP_DDL_DEPT_CODE_LABEL = COMP_DDL_DEPT_CODE_LABEL;
	}

	public void setCOMP_DDL_DEPT_CODE(HtmlInputText COMP_DDL_DEPT_CODE) {
		this.COMP_DDL_DEPT_CODE = COMP_DDL_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_NAME_LABEL() {
		return COMP_UI_M_DEPT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_NAME() {
		return COMP_UI_M_DEPT_NAME;
	}

	public void setCOMP_UI_M_DEPT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL) {
		this.COMP_UI_M_DEPT_NAME_LABEL = COMP_UI_M_DEPT_NAME_LABEL;
	}

	public void setCOMP_UI_M_DEPT_NAME(HtmlInputText COMP_UI_M_DEPT_NAME) {
		this.COMP_UI_M_DEPT_NAME = COMP_UI_M_DEPT_NAME;
	}

	public HtmlOutputLabel getCOMP_DDL_DR_TXN_CODE_LABEL() {
		return COMP_DDL_DR_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DDL_DR_TXN_CODE() {
		return COMP_DDL_DR_TXN_CODE;
	}

	public void setCOMP_DDL_DR_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_DDL_DR_TXN_CODE_LABEL) {
		this.COMP_DDL_DR_TXN_CODE_LABEL = COMP_DDL_DR_TXN_CODE_LABEL;
	}

	public void setCOMP_DDL_DR_TXN_CODE(HtmlInputText COMP_DDL_DR_TXN_CODE) {
		this.COMP_DDL_DR_TXN_CODE = COMP_DDL_DR_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TXN_DR_NAME_LABEL() {
		return COMP_UI_M_TXN_DR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TXN_DR_NAME() {
		return COMP_UI_M_TXN_DR_NAME;
	}

	public void setCOMP_UI_M_TXN_DR_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_TXN_DR_NAME_LABEL) {
		this.COMP_UI_M_TXN_DR_NAME_LABEL = COMP_UI_M_TXN_DR_NAME_LABEL;
	}

	public void setCOMP_UI_M_TXN_DR_NAME(HtmlInputText COMP_UI_M_TXN_DR_NAME) {
		this.COMP_UI_M_TXN_DR_NAME = COMP_UI_M_TXN_DR_NAME;
	}

	public HtmlOutputLabel getCOMP_DDL_CR_TXN_CODE_LABEL() {
		return COMP_DDL_CR_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DDL_CR_TXN_CODE() {
		return COMP_DDL_CR_TXN_CODE;
	}

	public void setCOMP_DDL_CR_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_DDL_CR_TXN_CODE_LABEL) {
		this.COMP_DDL_CR_TXN_CODE_LABEL = COMP_DDL_CR_TXN_CODE_LABEL;
	}

	public void setCOMP_DDL_CR_TXN_CODE(HtmlInputText COMP_DDL_CR_TXN_CODE) {
		this.COMP_DDL_CR_TXN_CODE = COMP_DDL_CR_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TXN_CR_NAME_LABEL() {
		return COMP_UI_M_TXN_CR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TXN_CR_NAME() {
		return COMP_UI_M_TXN_CR_NAME;
	}

	public void setCOMP_UI_M_TXN_CR_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_TXN_CR_NAME_LABEL) {
		this.COMP_UI_M_TXN_CR_NAME_LABEL = COMP_UI_M_TXN_CR_NAME_LABEL;
	}

	public void setCOMP_UI_M_TXN_CR_NAME(HtmlInputText COMP_UI_M_TXN_CR_NAME) {
		this.COMP_UI_M_TXN_CR_NAME = COMP_UI_M_TXN_CR_NAME;
	}

	public HtmlOutputLabel getCOMP_DDL_RCT_TXN_CODE_LABEL() {
		return COMP_DDL_RCT_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DDL_RCT_TXN_CODE() {
		return COMP_DDL_RCT_TXN_CODE;
	}

	public void setCOMP_DDL_RCT_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_DDL_RCT_TXN_CODE_LABEL) {
		this.COMP_DDL_RCT_TXN_CODE_LABEL = COMP_DDL_RCT_TXN_CODE_LABEL;
	}

	public void setCOMP_DDL_RCT_TXN_CODE(HtmlInputText COMP_DDL_RCT_TXN_CODE) {
		this.COMP_DDL_RCT_TXN_CODE = COMP_DDL_RCT_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TXN_RCT_NAME_LABEL() {
		return COMP_UI_M_TXN_RCT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TXN_RCT_NAME() {
		return COMP_UI_M_TXN_RCT_NAME;
	}

	public void setCOMP_UI_M_TXN_RCT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_TXN_RCT_NAME_LABEL) {
		this.COMP_UI_M_TXN_RCT_NAME_LABEL = COMP_UI_M_TXN_RCT_NAME_LABEL;
	}

	public void setCOMP_UI_M_TXN_RCT_NAME(HtmlInputText COMP_UI_M_TXN_RCT_NAME) {
		this.COMP_UI_M_TXN_RCT_NAME = COMP_UI_M_TXN_RCT_NAME;
	}

	public HtmlOutputLabel getCOMP_DDL_PAY_TXN_CODE_LABEL() {
		return COMP_DDL_PAY_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DDL_PAY_TXN_CODE() {
		return COMP_DDL_PAY_TXN_CODE;
	}

	public void setCOMP_DDL_PAY_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_DDL_PAY_TXN_CODE_LABEL) {
		this.COMP_DDL_PAY_TXN_CODE_LABEL = COMP_DDL_PAY_TXN_CODE_LABEL;
	}

	public void setCOMP_DDL_PAY_TXN_CODE(HtmlInputText COMP_DDL_PAY_TXN_CODE) {
		this.COMP_DDL_PAY_TXN_CODE = COMP_DDL_PAY_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TXN_PAY_NAME_LABEL() {
		return COMP_UI_M_TXN_PAY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TXN_PAY_NAME() {
		return COMP_UI_M_TXN_PAY_NAME;
	}

	public void setCOMP_UI_M_TXN_PAY_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_TXN_PAY_NAME_LABEL) {
		this.COMP_UI_M_TXN_PAY_NAME_LABEL = COMP_UI_M_TXN_PAY_NAME_LABEL;
	}

	public void setCOMP_UI_M_TXN_PAY_NAME(HtmlInputText COMP_UI_M_TXN_PAY_NAME) {
		this.COMP_UI_M_TXN_PAY_NAME = COMP_UI_M_TXN_PAY_NAME;
	}

	public HtmlOutputLabel getCOMP_DDL_JV_TXN_CODE_LABEL() {
		return COMP_DDL_JV_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DDL_JV_TXN_CODE() {
		return COMP_DDL_JV_TXN_CODE;
	}

	public void setCOMP_DDL_JV_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_DDL_JV_TXN_CODE_LABEL) {
		this.COMP_DDL_JV_TXN_CODE_LABEL = COMP_DDL_JV_TXN_CODE_LABEL;
	}

	public void setCOMP_DDL_JV_TXN_CODE(HtmlInputText COMP_DDL_JV_TXN_CODE) {
		this.COMP_DDL_JV_TXN_CODE = COMP_DDL_JV_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TXN_JV_NAME_LABEL() {
		return COMP_UI_M_TXN_JV_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TXN_JV_NAME() {
		return COMP_UI_M_TXN_JV_NAME;
	}

	public void setCOMP_UI_M_TXN_JV_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_TXN_JV_NAME_LABEL) {
		this.COMP_UI_M_TXN_JV_NAME_LABEL = COMP_UI_M_TXN_JV_NAME_LABEL;
	}

	public void setCOMP_UI_M_TXN_JV_NAME(HtmlInputText COMP_UI_M_TXN_JV_NAME) {
		this.COMP_UI_M_TXN_JV_NAME = COMP_UI_M_TXN_JV_NAME;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_DIVN() {
		return COMP_UI_M_BUT_LOV_DIVN;
	}

	public void setCOMP_UI_M_BUT_LOV_DIVN(
			HtmlCommandButton COMP_UI_M_BUT_LOV_DIVN) {
		this.COMP_UI_M_BUT_LOV_DIVN = COMP_UI_M_BUT_LOV_DIVN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_JV_TRN() {
		return COMP_UI_M_BUT_LOV_JV_TRN;
	}

	public void setCOMP_UI_M_BUT_LOV_JV_TRN(
			HtmlCommandButton COMP_UI_M_BUT_LOV_JV_TRN) {
		this.COMP_UI_M_BUT_LOV_JV_TRN = COMP_UI_M_BUT_LOV_JV_TRN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_DEPT() {
		return COMP_UI_M_BUT_LOV_DEPT;
	}

	public void setCOMP_UI_M_BUT_LOV_DEPT(
			HtmlCommandButton COMP_UI_M_BUT_LOV_DEPT) {
		this.COMP_UI_M_BUT_LOV_DEPT = COMP_UI_M_BUT_LOV_DEPT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PAY_TRN() {
		return COMP_UI_M_BUT_LOV_PAY_TRN;
	}

	public void setCOMP_UI_M_BUT_LOV_PAY_TRN(
			HtmlCommandButton COMP_UI_M_BUT_LOV_PAY_TRN) {
		this.COMP_UI_M_BUT_LOV_PAY_TRN = COMP_UI_M_BUT_LOV_PAY_TRN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_RCT_TRN() {
		return COMP_UI_M_BUT_LOV_RCT_TRN;
	}

	public void setCOMP_UI_M_BUT_LOV_RCT_TRN(
			HtmlCommandButton COMP_UI_M_BUT_LOV_RCT_TRN) {
		this.COMP_UI_M_BUT_LOV_RCT_TRN = COMP_UI_M_BUT_LOV_RCT_TRN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CR_TRN() {
		return COMP_UI_M_BUT_LOV_CR_TRN;
	}

	public void setCOMP_UI_M_BUT_LOV_CR_TRN(
			HtmlCommandButton COMP_UI_M_BUT_LOV_CR_TRN) {
		this.COMP_UI_M_BUT_LOV_CR_TRN = COMP_UI_M_BUT_LOV_CR_TRN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_DEB_TRN() {
		return COMP_UI_M_BUT_LOV_DEB_TRN;
	}

	public void setCOMP_UI_M_BUT_LOV_DEB_TRN(
			HtmlCommandButton COMP_UI_M_BUT_LOV_DEB_TRN) {
		this.COMP_UI_M_BUT_LOV_DEB_TRN = COMP_UI_M_BUT_LOV_DEB_TRN;
	}

	public PM_DEPT_DRCR_LINK getPM_DEPT_DRCR_LINK_BEAN() {
		return PM_DEPT_DRCR_LINK_BEAN;
	}


	public void validateDDL_FRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				PM_DEPT_DRCR_LINK_BEAN
						.setDDL_FRZ_FLAG(PELConstants.CHECKBOX_CHECKED);
			} else {
				PM_DEPT_DRCR_LINK_BEAN
						.setDDL_FRZ_FLAG(PELConstants.CHECKBOX_UNCHECKED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String getFreezeValue(){
		String freeze_Value = "N";
		if(PM_DEPT_DRCR_LINK_BEAN.isDDL_FRZ_FLAG_VALUE()){
			freeze_Value = "Y";
		}
		return freeze_Value;
	}
	public String deleteRecord() {
		getErrorMap().clear();
		CRUDHandler handler = new CRUDHandler();
		try {
			handler.executeDelete(PM_DEPT_DRCR_LINK_BEAN,
					CommonUtils.getConnection());
			CommonUtils.getConnection().commit();
			PM_DEPT_DRCR_LINK_BEAN= new PM_DEPT_DRCR_LINK();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			"Record Deleted Successfully");
	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
			"Record Deleted Successfully");
			getWarningMap().put("current", "Record Deleted Successfully");
		} catch (Exception er) {
			er.printStackTrace();
		}
		return "";
	}
	
	public void saveRecord() {
		String message = "";
	try {
		if (getPM_DEPT_DRCR_LINK_BEAN().getROWID() == null) {
			//PM_DEPT_DRCR_LINK_PRE_INSERT(getPM_DEPT_DRCR_LINK_BEAN());
			new CRUDHandler().executeInsert(getPM_DEPT_DRCR_LINK_BEAN(),
					CommonUtils.getConnection());
			message = Messages.getString(
					PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");

		} else {
			//PM_DEPT_DRCR_LINK_PRE_UPDATE(getPM_DEPT_DRCR_LINK_BEAN());
			new CRUDHandler().executeUpdate(getPM_DEPT_DRCR_LINK_BEAN(),
					CommonUtils.getConnection());
			message = Messages.getString(
					PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update");
		}
		CommonUtils.getConnection().commit();
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				message);
		getWarningMap().put("SAVE",message);
	} catch (Exception e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("SAVE", e.getMessage());
	}
}

	public void fireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		PM_DEPT_DRCR_LINK_DELEGATE delegate = new PM_DEPT_DRCR_LINK_DELEGATE();
		try {
			if (isBlockFlag()) {
				delegate.executeSelectStatement(compositeAction);
				if (PM_DEPT_DRCR_LINK_BEAN.getROWID() != null) {
					helper.postQuery(PM_DEPT_DRCR_LINK_BEAN);
				}
				setBlockFlag(false);
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}

	public List DDL_DIVN_CODE_KEY_LISTVAL(Object obj) throws Exception {
		session = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		List suggesionList = new ArrayList();
		getCOMP_DDL_DIVN_CODE().setSubmittedValue(null);
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();

		String query = null;
		if (obj.toString().equals("*")) {
			query = "SELECT DIVN_CODE,DIVN_NAME,DIVN_BL_NAME FROM FM_DIVISION WHERE DIVN_COMP_CODE = '"
					+ CommonUtils.getControlBean().getM_COMP_CODE()
					+ "' AND DIVN_FRZ_FLAG = 'N' AND  rownum < 50 ORDER BY DIVN_CODE ASC";
		} else {
			query = "SELECT DIVN_CODE,DIVN_NAME,DIVN_BL_NAME FROM FM_DIVISION WHERE DIVN_COMP_CODE = '"
					+ CommonUtils.getControlBean().getM_COMP_CODE()
					+ "' AND DIVN_FRZ_FLAG = 'N' AND DIVN_CODE LIKE '"
					+ obj.toString()
					+ "%' AND rownum < 50 ORDER BY DIVN_CODE ASC";
		}
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while (resultSet.next()) {
			PM_DEPT_DRCR_LINK cbean = new PM_DEPT_DRCR_LINK();
			cbean.setDDL_DIVN_CODE(resultSet.getString("DIVN_CODE"));
			cbean.setUI_M_DIVN_NAME(resultSet.getString("DIVN_NAME"));
			suggesionList.add(cbean);
		}
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggesionList;
	}

	public void validatorDDL_DIVN_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DEPT_DRCR_LINK_BEAN.setDDL_DIVN_CODE((String) value);
			helper.whenValidateDDL_DIVN_CODE(PM_DEPT_DRCR_LINK_BEAN);
			COMP_UI_M_DIVN_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List DDL_DEPT_CODE_KEY_LISTVAL(Object obj) throws SQLException,
			DBException {
		List suggesionList = new ArrayList();
		ResultSet resultSet = null;
		getCOMP_DDL_DIVN_CODE().setSubmittedValue(null);
		String DDL_DIVN_CODE = getPM_DEPT_DRCR_LINK_BEAN().getDDL_DIVN_CODE();
		String query = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();

		if (obj.toString().equals("*")) {
			query = "SELECT DEPT_CODE, DEPT_NAME FROM FM_DEPARTMENT WHERE NVL(DEPT_FRZ_FLAG,'N') = 'N' "
					+ "AND DEPT_DIVN_CODE=? "
					+ "AND rownum < 50 ORDER BY DEPT_CODE ASC";
		} else {
			query = "SELECT DEPT_CODE, DEPT_NAME FROM FM_DEPARTMENT WHERE NVL(DEPT_FRZ_FLAG,'N') = 'N' "
					+ "AND DEPT_DIVN_CODE=? AND DEPT_CODE LIKE '"
					+ obj.toString()
					+ "%' AND rownum < 50 ORDER BY DEPT_CODE ASC";
		}
		resultSet = handler.executeSelectStatement(query, connection,
				new Object[] { DDL_DIVN_CODE });
		resultSet.setFetchSize(25);
		while (resultSet.next()) {
			PM_DEPT_DRCR_LINK cbean = new PM_DEPT_DRCR_LINK();
			cbean.setDDL_DEPT_CODE(resultSet.getString("DEPT_CODE"));
			cbean.setUI_M_DEPT_NAME(resultSet.getString("DEPT_NAME"));
			suggesionList.add(cbean);
		}
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggesionList;
	}

	public void validatorDDL_DEPT_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DEPT_DRCR_LINK_BEAN.setDDL_DEPT_CODE((String) value);
			helper.whenValidateDDL_DEPT_CODE(PM_DEPT_DRCR_LINK_BEAN);
			COMP_UI_M_DEPT_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List DDL_DR_TXN_CODE_KEY_LISTVAL(Object obj) throws SQLException,
			DBException {
		List suggesionList = new ArrayList<PM_DEPT_DRCR_LINK>();
		ResultSet resultSet = null;
		getCOMP_DDL_DIVN_CODE().setSubmittedValue(null);
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();
		String query = null;

		if (obj.toString().equals("*")) {
			query = "SELECT TRAN_CODE, TRAN_NAME FROM FM_TRANSACTION WHERE rownum < 50 ORDER BY TRAN_CODE ASC";
		} else {
			query = "SELECT TRAN_CODE, TRAN_NAME FROM FM_TRANSACTION WHERE TRAN_CODE LIKE '"
					+ obj.toString()
					+ "%'AND rownum < 50 ORDER BY TRAN_CODE ASC";
		}
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while (resultSet.next()) {
			PM_DEPT_DRCR_LINK cbean = new PM_DEPT_DRCR_LINK();
			cbean.setDDL_DR_TXN_CODE(resultSet.getString("TRAN_CODE"));
			cbean.setUI_M_TXN_DR_NAME(resultSet.getString("TRAN_NAME"));
			suggesionList.add(cbean);
		}
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggesionList;
	}

	public void validatorDDL_DR_TXN_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DEPT_DRCR_LINK_BEAN.setDDL_DR_TXN_CODE((String) value);
			helper.whenValidateDDL_DR_TXN_CODE(PM_DEPT_DRCR_LINK_BEAN);
			COMP_UI_M_TXN_DR_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List DDL_CR_TXN_CODE_KEY_LISTVAL(Object obj) throws SQLException,
			DBException {
		List suggesionList = new ArrayList();
		ResultSet resultSet = null;
		getCOMP_DDL_DIVN_CODE().setSubmittedValue(null);
		String query = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();

		if (obj.toString().equals("*")) {
			query = "SELECT TRAN_CODE, TRAN_NAME FROM FM_TRANSACTION WHERE rownum < 50 ORDER BY TRAN_CODE ASC";
		} else {
			query = "SELECT TRAN_CODE, TRAN_NAME FROM FM_TRANSACTION WHERE TRAN_CODE LIKE '"
					+ obj.toString()
					+ "%'AND rownum < 50 ORDER BY TRAN_CODE ASC";
		}
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while (resultSet.next()) {
			PM_DEPT_DRCR_LINK cbean = new PM_DEPT_DRCR_LINK();
			cbean.setDDL_CR_TXN_CODE(resultSet.getString("TRAN_CODE"));
			cbean.setUI_M_TXN_CR_NAME(resultSet.getString("TRAN_NAME"));
			suggesionList.add(cbean);
		}
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggesionList;
	}

	public void validatorDDL_CR_TXN_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DEPT_DRCR_LINK_BEAN.setDDL_CR_TXN_CODE((String) value);
			helper.whenValidateDDL_CR_TXN_CODE(PM_DEPT_DRCR_LINK_BEAN);
			COMP_UI_M_TXN_CR_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List DDL_RCT_TXN_CODE_KEY_LISTVAL(Object obj) throws SQLException,
			DBException {
		List suggesionList = new ArrayList();
		ResultSet resultSet = null;
		getCOMP_DDL_DIVN_CODE().setSubmittedValue(null);
		String query = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();

		if (obj.toString().equals("*")) {
			query = "SELECT TRAN_CODE, TRAN_NAME FROM FM_TRANSACTION WHERE rownum < 50 ORDER BY TRAN_CODE ASC";
		} else {
			query = "SELECT TRAN_CODE, TRAN_NAME FROM FM_TRANSACTION WHERE TRAN_CODE LIKE '"
					+ obj.toString()
					+ "%'AND rownum < 50 ORDER BY TRAN_CODE ASC";
		}
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while (resultSet.next()) {
			PM_DEPT_DRCR_LINK cbean = new PM_DEPT_DRCR_LINK();
			cbean.setDDL_RCT_TXN_CODE(resultSet.getString("TRAN_CODE"));
			cbean.setUI_M_TXN_RCT_NAME(resultSet.getString("TRAN_NAME"));
			suggesionList.add(cbean);
		}
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggesionList;
	}

	public void validatorDDL_RCT_TXN_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DEPT_DRCR_LINK_BEAN.setDDL_RCT_TXN_CODE((String) value);
			helper.whenValidateDDL_RCT_TXN_CODE(PM_DEPT_DRCR_LINK_BEAN);
			COMP_UI_M_TXN_RCT_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List DDL_PAY_TXN_CODE_KEY_LISTVAL(Object obj) throws SQLException,
			DBException {
		List suggesionList = new ArrayList();
		ResultSet resultSet = null;
		getCOMP_DDL_DIVN_CODE().setSubmittedValue(null);
		String query = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();

		if (obj.toString().equals("*")) {
			query = "SELECT TRAN_CODE, TRAN_NAME FROM FM_TRANSACTION WHERE rownum < 50 ORDER BY TRAN_CODE ASC";
		} else {
			query = "SELECT TRAN_CODE, TRAN_NAME FROM FM_TRANSACTION WHERE TRAN_CODE LIKE '"
					+ obj.toString()
					+ "%'AND rownum < 50 ORDER BY TRAN_CODE ASC";
		}
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while (resultSet.next()) {
			PM_DEPT_DRCR_LINK cbean = new PM_DEPT_DRCR_LINK();
			cbean.setDDL_PAY_TXN_CODE(resultSet.getString("TRAN_CODE"));
			cbean.setUI_M_TXN_PAY_NAME(resultSet.getString("TRAN_NAME"));
			suggesionList.add(cbean);
		}
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggesionList;
	}

	public void validatorDDL_PAY_TXN_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DEPT_DRCR_LINK_BEAN.setDDL_PAY_TXN_CODE((String) value);
			helper.whenValidateDDL_PAY_TXN_CODE(PM_DEPT_DRCR_LINK_BEAN);
			COMP_UI_M_TXN_PAY_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List DDL_JV_TXN_CODE_KEY_LISTVAL(Object obj) throws SQLException,
			DBException {
		List suggesionList = new ArrayList();
		ResultSet resultSet = null;
		getCOMP_DDL_DIVN_CODE().setSubmittedValue(null);
		String query = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();

		if(obj.toString().equals("*")){
			query = "SELECT TRAN_CODE, TRAN_NAME FROM FM_TRANSACTION WHERE TRAN_BANK_LINE_FLAG = 'N' AND rownum < 50 ORDER BY TRAN_CODE ASC";
		}else{
			query = "SELECT TRAN_CODE, TRAN_NAME FROM FM_TRANSACTION WHERE TRAN_BANK_LINE_FLAG = 'N' AND TRAN_CODE LIKE '"+obj.toString()+"%'AND rownum < 50 ORDER BY TRAN_CODE ASC";
		}	
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while (resultSet.next()) {
			PM_DEPT_DRCR_LINK cbean = new PM_DEPT_DRCR_LINK();
			cbean.setDDL_JV_TXN_CODE(resultSet.getString("TRAN_CODE"));
			cbean.setUI_M_TXN_JV_NAME(resultSet.getString("TRAN_NAME"));
			suggesionList.add(cbean);
		}
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggesionList;
	}

	public void validatorDDL_JV_TXN_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_DEPT_DRCR_LINK_BEAN.setDDL_JV_TXN_CODE((String) value);
			helper.whenValidateDDL_JV_TXN_CODE(PM_DEPT_DRCR_LINK_BEAN);
			COMP_UI_M_TXN_JV_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

}