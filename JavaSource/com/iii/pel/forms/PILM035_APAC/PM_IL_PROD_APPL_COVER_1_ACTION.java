package com.iii.pel.forms.PILM035_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_APPL_COVER_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PAC_COVER_CODE_LABEL;

	private HtmlInputText COMP_PAC_COVER_CODE;

	private HtmlOutputLabel COMP_PAC_MANDATORY_YN_LABEL;

	private HtmlSelectOneMenu COMP_PAC_MANDATORY_YN;

	private HtmlOutputLabel COMP_PAC_DEFAULT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PAC_DEFAULT_YN;

	private HtmlOutputLabel COMP_PAC_TARIFF_TERM_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PAC_TARIFF_TERM_FLAG;

	private HtmlOutputLabel COMP_PAC_PERIOD_LABEL;

	private HtmlInputText COMP_PAC_PERIOD;

	private HtmlOutputLabel COMP_PAC_MAT_PAYEE_AGE_LABEL;

	private HtmlInputText COMP_PAC_MAT_PAYEE_AGE;

	private HtmlOutputLabel COMP_PAC_SA_ADD_FACTOR_LABEL;

	private HtmlInputText COMP_PAC_SA_ADD_FACTOR;

	private HtmlOutputLabel COMP_PAC_MAT_PAYER_AGE_LABEL;

	private HtmlInputText COMP_PAC_MAT_PAYER_AGE;

	private HtmlOutputLabel COMP_PAC_SA_FACTOR_LABEL;

	private HtmlInputText COMP_PAC_SA_FACTOR;

	private HtmlOutputLabel COMP_PAC_COVER_START_AGE_LABEL;
	private HtmlOutputLabel COMP_PAC_COVER_ASSR_TYPE_LABEL;

	private HtmlInputText COMP_PAC_COVER_START_AGE;

	private HtmlOutputLabel COMP_PAC_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_PAC_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_PAC_MAX_AGE_ON_MAT_LABEL;

	private HtmlInputText COMP_PAC_MAX_AGE_ON_MAT;

	private HtmlOutputLabel COMP_PAC_BCH_CODE_LABEL;

	private HtmlInputText COMP_PAC_BCH_CODE;

	private HtmlOutputLabel COMP_PAC_PRODUCTION_PERC_LABEL;

	private HtmlInputText COMP_PAC_PRODUCTION_PERC;

	private HtmlOutputLabel COMP_PAC_THRESHOLD_PERC_LABEL;

	private HtmlInputText COMP_PAC_THRESHOLD_PERC;

	private HtmlOutputLabel COMP_PAC_MED_DAYS_LABEL;

	private HtmlInputText COMP_PAC_MED_DAYS;

	private HtmlOutputLabel COMP_PAC_MED_AMT_LABEL;

	private HtmlInputText COMP_PAC_MED_AMT;

	private HtmlOutputLabel COMP_PAC_GRP_THRESHOLD_PERC_LABEL;

	private HtmlInputText COMP_PAC_GRP_THRESHOLD_PERC;

	private HtmlOutputLabel COMP_PAC_BCH_TERM_LABEL;

	private HtmlSelectOneMenu COMP_PAC_BCH_TERM;
	private HtmlSelectOneMenu COMP_PAC_COVER_ASSR_TYPE;

	private HtmlOutputLabel COMP_UI_M_PAC_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PAC_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_PAC_BCH_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PAC_BCH_CODE_DESC;

	private HtmlCommandButton COMP_PBN_BACK_CVR;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_PAC_COVER_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_PAC_BCH_CODE_LOV;

	private PM_IL_PROD_APPL_COVER_1 PM_IL_PROD_APPL_COVER_1_BEAN;
	
	private PM_IL_PROD_APPL_COVER_1_DELEGATE delegate;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_APPL_COVER_1_HELPER helper;
	
	private List<SelectItem> listPAC_COVER_ASSR_TYPE = new ArrayList<SelectItem>();

	private List<PM_IL_PROD_APPL_COVER_1> dataList_PM_IL_PROD_APPL_COVER_1 = new ArrayList<PM_IL_PROD_APPL_COVER_1>();

	private UIData dataTable;

	private List<SelectItem> listPAC_MANDATORY_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPAC_DEFAULT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPAC_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPAC_BCH_TERM = new ArrayList<SelectItem>();

	public PM_IL_PROD_APPL_COVER_1_ACTION() {

		PM_IL_PROD_APPL_COVER_1_BEAN = new PM_IL_PROD_APPL_COVER_1();
		helper = new PM_IL_PROD_APPL_COVER_1_HELPER();
		delegate = new PM_IL_PROD_APPL_COVER_1_DELEGATE();
		prepareDropDowns();
		COMP_PAC_MAT_PAYER_AGE = new HtmlInputText();
		COMP_PAC_MAT_PAYEE_AGE = new HtmlInputText();
		COMP_PAC_COVER_START_AGE = new HtmlInputText();
		 
	}
	
	public List<SelectItem> getListPAC_COVER_ASSR_TYPE() {
		if (listPAC_COVER_ASSR_TYPE.size() == 0) {
			listPAC_COVER_ASSR_TYPE.clear();
			try {
				listPAC_COVER_ASSR_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_COVER_ASSR_TYPE;
	}

	public void setListPAC_COVER_ASSR_TYPE(
			List<SelectItem> listPAC_COVER_ASSR_TYPE) {
		this.listPAC_COVER_ASSR_TYPE = listPAC_COVER_ASSR_TYPE;
	}

	public HtmlOutputLabel getCOMP_PAC_COVER_CODE_LABEL() {
		return COMP_PAC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAC_COVER_CODE() {
		return COMP_PAC_COVER_CODE;
	}

	public void setCOMP_PAC_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_PAC_COVER_CODE_LABEL) {
		this.COMP_PAC_COVER_CODE_LABEL = COMP_PAC_COVER_CODE_LABEL;
	}

	public void setCOMP_PAC_COVER_CODE(HtmlInputText COMP_PAC_COVER_CODE) {
		this.COMP_PAC_COVER_CODE = COMP_PAC_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_PAC_MANDATORY_YN_LABEL() {
		return COMP_PAC_MANDATORY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAC_MANDATORY_YN() {
		return COMP_PAC_MANDATORY_YN;
	}

	public void setCOMP_PAC_MANDATORY_YN_LABEL(
			HtmlOutputLabel COMP_PAC_MANDATORY_YN_LABEL) {
		this.COMP_PAC_MANDATORY_YN_LABEL = COMP_PAC_MANDATORY_YN_LABEL;
	}

	public void setCOMP_PAC_MANDATORY_YN(HtmlSelectOneMenu COMP_PAC_MANDATORY_YN) {
		this.COMP_PAC_MANDATORY_YN = COMP_PAC_MANDATORY_YN;
	}

	public HtmlOutputLabel getCOMP_PAC_DEFAULT_YN_LABEL() {
		return COMP_PAC_DEFAULT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAC_DEFAULT_YN() {
		return COMP_PAC_DEFAULT_YN;
	}

	public void setCOMP_PAC_DEFAULT_YN_LABEL(
			HtmlOutputLabel COMP_PAC_DEFAULT_YN_LABEL) {
		this.COMP_PAC_DEFAULT_YN_LABEL = COMP_PAC_DEFAULT_YN_LABEL;
	}

	public void setCOMP_PAC_DEFAULT_YN(HtmlSelectOneMenu COMP_PAC_DEFAULT_YN) {
		this.COMP_PAC_DEFAULT_YN = COMP_PAC_DEFAULT_YN;
	}

	public HtmlOutputLabel getCOMP_PAC_TARIFF_TERM_FLAG_LABEL() {
		return COMP_PAC_TARIFF_TERM_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAC_TARIFF_TERM_FLAG() {
		return COMP_PAC_TARIFF_TERM_FLAG;
	}

	public void setCOMP_PAC_TARIFF_TERM_FLAG_LABEL(
			HtmlOutputLabel COMP_PAC_TARIFF_TERM_FLAG_LABEL) {
		this.COMP_PAC_TARIFF_TERM_FLAG_LABEL = COMP_PAC_TARIFF_TERM_FLAG_LABEL;
	}

	public void setCOMP_PAC_TARIFF_TERM_FLAG(
			HtmlSelectOneMenu COMP_PAC_TARIFF_TERM_FLAG) {
		this.COMP_PAC_TARIFF_TERM_FLAG = COMP_PAC_TARIFF_TERM_FLAG;
	}

	public HtmlOutputLabel getCOMP_PAC_PERIOD_LABEL() {
		return COMP_PAC_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_PAC_PERIOD() {
		return COMP_PAC_PERIOD;
	}

	public void setCOMP_PAC_PERIOD_LABEL(HtmlOutputLabel COMP_PAC_PERIOD_LABEL) {
		this.COMP_PAC_PERIOD_LABEL = COMP_PAC_PERIOD_LABEL;
	}

	public void setCOMP_PAC_PERIOD(HtmlInputText COMP_PAC_PERIOD) {
		this.COMP_PAC_PERIOD = COMP_PAC_PERIOD;
	}

	public HtmlOutputLabel getCOMP_PAC_PREM_PAY_YRS_LABEL() {
		return COMP_PAC_PREM_PAY_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PAC_PREM_PAY_YRS() {
		return COMP_PAC_PREM_PAY_YRS;
	}

	public void setCOMP_PAC_PREM_PAY_YRS_LABEL(
			HtmlOutputLabel COMP_PAC_PREM_PAY_YRS_LABEL) {
		this.COMP_PAC_PREM_PAY_YRS_LABEL = COMP_PAC_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_PAC_PREM_PAY_YRS(HtmlInputText COMP_PAC_PREM_PAY_YRS) {
		this.COMP_PAC_PREM_PAY_YRS = COMP_PAC_PREM_PAY_YRS;
	}

	public HtmlOutputLabel getCOMP_PAC_MAX_AGE_ON_MAT_LABEL() {
		return COMP_PAC_MAX_AGE_ON_MAT_LABEL;
	}

	public HtmlInputText getCOMP_PAC_MAX_AGE_ON_MAT() {
		return COMP_PAC_MAX_AGE_ON_MAT;
	}

	public void setCOMP_PAC_MAX_AGE_ON_MAT_LABEL(
			HtmlOutputLabel COMP_PAC_MAX_AGE_ON_MAT_LABEL) {
		this.COMP_PAC_MAX_AGE_ON_MAT_LABEL = COMP_PAC_MAX_AGE_ON_MAT_LABEL;
	}

	public void setCOMP_PAC_MAX_AGE_ON_MAT(HtmlInputText COMP_PAC_MAX_AGE_ON_MAT) {
		this.COMP_PAC_MAX_AGE_ON_MAT = COMP_PAC_MAX_AGE_ON_MAT;
	}

	public HtmlOutputLabel getCOMP_PAC_BCH_CODE_LABEL() {
		return COMP_PAC_BCH_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAC_BCH_CODE() {
		return COMP_PAC_BCH_CODE;
	}

	public void setCOMP_PAC_BCH_CODE_LABEL(
			HtmlOutputLabel COMP_PAC_BCH_CODE_LABEL) {
		this.COMP_PAC_BCH_CODE_LABEL = COMP_PAC_BCH_CODE_LABEL;
	}

	public void setCOMP_PAC_BCH_CODE(HtmlInputText COMP_PAC_BCH_CODE) {
		this.COMP_PAC_BCH_CODE = COMP_PAC_BCH_CODE;
	}

	public HtmlOutputLabel getCOMP_PAC_PRODUCTION_PERC_LABEL() {
		return COMP_PAC_PRODUCTION_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PAC_PRODUCTION_PERC() {
		return COMP_PAC_PRODUCTION_PERC;
	}

	public void setCOMP_PAC_PRODUCTION_PERC_LABEL(
			HtmlOutputLabel COMP_PAC_PRODUCTION_PERC_LABEL) {
		this.COMP_PAC_PRODUCTION_PERC_LABEL = COMP_PAC_PRODUCTION_PERC_LABEL;
	}

	public void setCOMP_PAC_PRODUCTION_PERC(
			HtmlInputText COMP_PAC_PRODUCTION_PERC) {
		this.COMP_PAC_PRODUCTION_PERC = COMP_PAC_PRODUCTION_PERC;
	}

	public HtmlOutputLabel getCOMP_PAC_THRESHOLD_PERC_LABEL() {
		return COMP_PAC_THRESHOLD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PAC_THRESHOLD_PERC() {
		return COMP_PAC_THRESHOLD_PERC;
	}

	public void setCOMP_PAC_THRESHOLD_PERC_LABEL(
			HtmlOutputLabel COMP_PAC_THRESHOLD_PERC_LABEL) {
		this.COMP_PAC_THRESHOLD_PERC_LABEL = COMP_PAC_THRESHOLD_PERC_LABEL;
	}

	public void setCOMP_PAC_THRESHOLD_PERC(HtmlInputText COMP_PAC_THRESHOLD_PERC) {
		this.COMP_PAC_THRESHOLD_PERC = COMP_PAC_THRESHOLD_PERC;
	}

	public HtmlOutputLabel getCOMP_PAC_MED_DAYS_LABEL() {
		return COMP_PAC_MED_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_PAC_MED_DAYS() {
		return COMP_PAC_MED_DAYS;
	}

	public void setCOMP_PAC_MED_DAYS_LABEL(
			HtmlOutputLabel COMP_PAC_MED_DAYS_LABEL) {
		this.COMP_PAC_MED_DAYS_LABEL = COMP_PAC_MED_DAYS_LABEL;
	}

	public void setCOMP_PAC_MED_DAYS(HtmlInputText COMP_PAC_MED_DAYS) {
		this.COMP_PAC_MED_DAYS = COMP_PAC_MED_DAYS;
	}

	public HtmlOutputLabel getCOMP_PAC_MED_AMT_LABEL() {
		return COMP_PAC_MED_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PAC_MED_AMT() {
		return COMP_PAC_MED_AMT;
	}

	public void setCOMP_PAC_MED_AMT_LABEL(HtmlOutputLabel COMP_PAC_MED_AMT_LABEL) {
		this.COMP_PAC_MED_AMT_LABEL = COMP_PAC_MED_AMT_LABEL;
	}

	public void setCOMP_PAC_MED_AMT(HtmlInputText COMP_PAC_MED_AMT) {
		this.COMP_PAC_MED_AMT = COMP_PAC_MED_AMT;
	}

	public HtmlOutputLabel getCOMP_PAC_GRP_THRESHOLD_PERC_LABEL() {
		return COMP_PAC_GRP_THRESHOLD_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PAC_GRP_THRESHOLD_PERC() {
		return COMP_PAC_GRP_THRESHOLD_PERC;
	}

	public void setCOMP_PAC_GRP_THRESHOLD_PERC_LABEL(
			HtmlOutputLabel COMP_PAC_GRP_THRESHOLD_PERC_LABEL) {
		this.COMP_PAC_GRP_THRESHOLD_PERC_LABEL = COMP_PAC_GRP_THRESHOLD_PERC_LABEL;
	}

	public void setCOMP_PAC_GRP_THRESHOLD_PERC(
			HtmlInputText COMP_PAC_GRP_THRESHOLD_PERC) {
		this.COMP_PAC_GRP_THRESHOLD_PERC = COMP_PAC_GRP_THRESHOLD_PERC;
	}

	public HtmlOutputLabel getCOMP_PAC_BCH_TERM_LABEL() {
		return COMP_PAC_BCH_TERM_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAC_BCH_TERM() {
		return COMP_PAC_BCH_TERM;
	}

	public void setCOMP_PAC_BCH_TERM_LABEL(
			HtmlOutputLabel COMP_PAC_BCH_TERM_LABEL) {
		this.COMP_PAC_BCH_TERM_LABEL = COMP_PAC_BCH_TERM_LABEL;
	}

	public void setCOMP_PAC_BCH_TERM(HtmlSelectOneMenu COMP_PAC_BCH_TERM) {
		this.COMP_PAC_BCH_TERM = COMP_PAC_BCH_TERM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAC_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_PAC_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAC_COVER_CODE_DESC() {
		return COMP_UI_M_PAC_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_PAC_COVER_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PAC_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_PAC_COVER_CODE_DESC_LABEL = COMP_UI_M_PAC_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAC_COVER_CODE_DESC(
			HtmlInputText COMP_UI_M_PAC_COVER_CODE_DESC) {
		this.COMP_UI_M_PAC_COVER_CODE_DESC = COMP_UI_M_PAC_COVER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAC_BCH_CODE_DESC_LABEL() {
		return COMP_UI_M_PAC_BCH_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAC_BCH_CODE_DESC() {
		return COMP_UI_M_PAC_BCH_CODE_DESC;
	}

	public void setCOMP_UI_M_PAC_BCH_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PAC_BCH_CODE_DESC_LABEL) {
		this.COMP_UI_M_PAC_BCH_CODE_DESC_LABEL = COMP_UI_M_PAC_BCH_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAC_BCH_CODE_DESC(
			HtmlInputText COMP_UI_M_PAC_BCH_CODE_DESC) {
		this.COMP_UI_M_PAC_BCH_CODE_DESC = COMP_UI_M_PAC_BCH_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_PBN_BACK_CVR() {
		return COMP_PBN_BACK_CVR;
	}

	public void setCOMP_PBN_BACK_CVR(HtmlCommandButton COMP_PBN_BACK_CVR) {
		this.COMP_PBN_BACK_CVR = COMP_PBN_BACK_CVR;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_PAC_COVER_CODE() {
		return COMP_UI_M_BUT_LOV_PAC_COVER_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_PAC_COVER_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_PAC_COVER_CODE) {
		this.COMP_UI_M_BUT_LOV_PAC_COVER_CODE = COMP_UI_M_BUT_LOV_PAC_COVER_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PAC_BCH_CODE_LOV() {
		return COMP_UI_M_BUT_PAC_BCH_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_PAC_BCH_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_PAC_BCH_CODE_LOV) {
		this.COMP_UI_M_BUT_PAC_BCH_CODE_LOV = COMP_UI_M_BUT_PAC_BCH_CODE_LOV;
	}

	public PM_IL_PROD_APPL_COVER_1 getPM_IL_PROD_APPL_COVER_1_BEAN() {
		return PM_IL_PROD_APPL_COVER_1_BEAN;
	}

	public void setPM_IL_PROD_APPL_COVER_1_BEAN(
			PM_IL_PROD_APPL_COVER_1 PM_IL_PROD_APPL_COVER_1_BEAN) {
		this.PM_IL_PROD_APPL_COVER_1_BEAN = PM_IL_PROD_APPL_COVER_1_BEAN;
	}

	public List<PM_IL_PROD_APPL_COVER_1> getDataList_PM_IL_PROD_APPL_COVER_1() {
		return dataList_PM_IL_PROD_APPL_COVER_1;
	}

	public void setDataListPM_IL_PROD_APPL_COVER_1(
			List<PM_IL_PROD_APPL_COVER_1> dataList_PM_IL_PROD_APPL_COVER_1) {
		this.dataList_PM_IL_PROD_APPL_COVER_1 = dataList_PM_IL_PROD_APPL_COVER_1;
	}

	public void addRow(ActionEvent event) {
		try {
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {
				PM_IL_PROD_APPL_COVER_1_BEAN = new PM_IL_PROD_APPL_COVER_1();
				setPM_IL_PROD_APPL_COVER_1_BEAN(PM_IL_PROD_APPL_COVER_1_BEAN);
				helper.WHEN_CREATE_RECORD(compositeAction);
				resetAllComponent();
				resetSelectedRow();
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

	}

	public void deleteRow(ActionEvent event) {
		try {
			CommonUtils.clearMaps(this);
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_PROD_APPL_COVER_1_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
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
				dataList_PM_IL_PROD_APPL_COVER_1
						.remove(PM_IL_PROD_APPL_COVER_1_BEAN);
				if (dataList_PM_IL_PROD_APPL_COVER_1.size() > 0) {
					PM_IL_PROD_APPL_COVER_1_BEAN = dataList_PM_IL_PROD_APPL_COVER_1
							.get(0);
				} else if (dataList_PM_IL_PROD_APPL_COVER_1.size() == 0) {
					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_APPL_COVER_1_BEAN.setRowSelected(true);
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

	public String  postRecord() {
		try {
			CommonUtils.clearMaps(this);
			if (PM_IL_PROD_APPL_COVER_1_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_APPL_COVER_1_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_PM_IL_PROD_APPL_COVER_1
						.add(PM_IL_PROD_APPL_COVER_1_BEAN);
			} else if (PM_IL_PROD_APPL_COVER_1_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_APPL_COVER_1_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PM_IL_PROD_APPL_COVER_1_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
		
		return "";

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PROD_APPL_COVER_1_BEAN = (PM_IL_PROD_APPL_COVER_1) dataTable
					.getRowData();
			PM_IL_PROD_APPL_COVER_1_BEAN.setRowSelected(true);
			helper.POST_QUERY(compositeAction);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_APPL_COVER_1> PM_IL_PROD_APPL_COVER_1_ITR = dataList_PM_IL_PROD_APPL_COVER_1
				.iterator();
		while (PM_IL_PROD_APPL_COVER_1_ITR.hasNext()) {
			PM_IL_PROD_APPL_COVER_1_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PAC_COVER_CODE.resetValue();
		COMP_PAC_MANDATORY_YN.resetValue();
		COMP_PAC_DEFAULT_YN.resetValue();
		COMP_PAC_TARIFF_TERM_FLAG.resetValue();
		COMP_PAC_PERIOD.resetValue();
		COMP_PAC_PREM_PAY_YRS.resetValue();
		COMP_PAC_MAX_AGE_ON_MAT.resetValue();
		COMP_PAC_BCH_CODE.resetValue();
		COMP_PAC_PRODUCTION_PERC.resetValue();
		COMP_PAC_THRESHOLD_PERC.resetValue();
		COMP_PAC_MED_DAYS.resetValue();
		COMP_PAC_MED_AMT.resetValue();
		COMP_PAC_GRP_THRESHOLD_PERC.resetValue();
		COMP_PAC_BCH_TERM.resetValue();
		COMP_UI_M_PAC_COVER_CODE_DESC.resetValue();
		COMP_UI_M_PAC_BCH_CODE_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public String detailCoverback(){
		return "PILM035_APAC_PM_IL_PROD_APPL_COVER";
	}

	public List<SelectItem> getListPAC_MANDATORY_YN() {
		if (listPAC_MANDATORY_YN.size() == 0) {
			listPAC_MANDATORY_YN.clear();
			try {
				listPAC_MANDATORY_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_MANDATORY_YN;
	}

	public void setListPAC_MANDATORY_YN(List<SelectItem> listPAC_MANDATORY_YN) {
		this.listPAC_MANDATORY_YN = listPAC_MANDATORY_YN;
	}

	public List<SelectItem> getListPAC_DEFAULT_YN() {
		if (listPAC_DEFAULT_YN.size() == 0) {
			listPAC_DEFAULT_YN.clear();
			try {
				listPAC_DEFAULT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_DEFAULT_YN;
	}

	public void setListPAC_DEFAULT_YN(List<SelectItem> listPAC_DEFAULT_YN) {
		this.listPAC_DEFAULT_YN = listPAC_DEFAULT_YN;
	}

	public List<SelectItem> getListPAC_TARIFF_TERM_FLAG() {
		if (listPAC_TARIFF_TERM_FLAG.size() == 0) {
			listPAC_TARIFF_TERM_FLAG.clear();
			try {
				listPAC_TARIFF_TERM_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_TARIFF_TERM_FLAG;
	}

	public void setListPAC_TARIFF_TERM_FLAG(
			List<SelectItem> listPAC_TARIFF_TERM_FLAG) {
		this.listPAC_TARIFF_TERM_FLAG = listPAC_TARIFF_TERM_FLAG;
	}

	public List<SelectItem> getListPAC_BCH_TERM() {
		if (listPAC_BCH_TERM.size() == 0) {
			listPAC_BCH_TERM.clear();
			try {
				listPAC_BCH_TERM = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAC_BCH_TERM;
	}

	public void setListPAC_BCH_TERM(List<SelectItem> listPAC_BCH_TERM) {
		this.listPAC_BCH_TERM = listPAC_BCH_TERM;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				CommonUtils.clearMaps(this);
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.executeQuery(compositeAction);
				if(getPM_IL_PROD_APPL_COVER_1_BEAN().getROWID() != null){
					helper.POST_QUERY(compositeAction);
				}
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				setBlockFlag(false);
			}
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	private void prepareDropDowns(){
		try {
				setListPAC_DEFAULT_YN(ListItemUtil.getDropDownListValue(CommonUtils
						.getConnection(), "PILM035_APAC", "PM_IL_PROD_APPL_COVER",
						"PM_IL_PROD_APPL_COVER.PAC_DEFAULT_YN", "YESNO"));
				setListPAC_MANDATORY_YN(ListItemUtil.getDropDownListValue(
						CommonUtils.getConnection(), "PILM035_APAC",
						"PM_IL_PROD_APPL_COVER",
						"PM_IL_PROD_APPL_COVER.PAC_MANDATORY_YN", "YESNO"));
				setListPAC_TARIFF_TERM_FLAG(ListItemUtil.getDropDownListValue(
						CommonUtils.getConnection(), "PILM035_APAC",
						"PM_IL_PROD_APPL_COVER",
						"PM_IL_PROD_APPL_COVER.PAC_TARIFF_TERM_FLAG", "TRMFLAG"));
				setListPAC_BCH_TERM(ListItemUtil.getDropDownListValue(CommonUtils
						.getConnection(), "PILM035_APAC", "PM_IL_PROD_APPL_COVER",
						"PM_IL_PROD_APPL_COVER.PAC_BCH_TERM", "IL_COMM_TERM"));
				setListPAC_COVER_ASSR_TYPE(ListItemUtil
						.getDropDownListValue(CommonUtils.getConnection(),
								"PILM035_APAC", "PM_IL_PROD_APPL_COVER",
								"PM_IL_PROD_APPL_COVER.PAC_COVER_ASSR_TYPE",
								"PROD_DRP_CLM"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_PAC_SA_FACTOR_LABEL() {
		return COMP_PAC_SA_FACTOR_LABEL;
	}

	public void setCOMP_PAC_SA_FACTOR_LABEL(
			HtmlOutputLabel comp_pac_sa_factor_label) {
		COMP_PAC_SA_FACTOR_LABEL = comp_pac_sa_factor_label;
	}

	public HtmlInputText getCOMP_PAC_SA_FACTOR() {
		return COMP_PAC_SA_FACTOR;
	}

	public void setCOMP_PAC_SA_FACTOR(HtmlInputText comp_pac_sa_factor) {
		COMP_PAC_SA_FACTOR = comp_pac_sa_factor;
	}

	public HtmlOutputLabel getCOMP_PAC_SA_ADD_FACTOR_LABEL() {
		return COMP_PAC_SA_ADD_FACTOR_LABEL;
	}

	public void setCOMP_PAC_SA_ADD_FACTOR_LABEL(
			HtmlOutputLabel comp_pac_sa_add_factor_label) {
		COMP_PAC_SA_ADD_FACTOR_LABEL = comp_pac_sa_add_factor_label;
	}

	public HtmlInputText getCOMP_PAC_SA_ADD_FACTOR() {
		return COMP_PAC_SA_ADD_FACTOR;
	}

	public void setCOMP_PAC_SA_ADD_FACTOR(HtmlInputText comp_pac_sa_add_factor) {
		COMP_PAC_SA_ADD_FACTOR = comp_pac_sa_add_factor;
	}

	public HtmlInputText getCOMP_PAC_MAT_PAYEE_AGE() {
		return COMP_PAC_MAT_PAYEE_AGE;
	}

	public void setCOMP_PAC_MAT_PAYEE_AGE(HtmlInputText comp_pac_mat_payee_age) {
		COMP_PAC_MAT_PAYEE_AGE = comp_pac_mat_payee_age;
	}

	public HtmlOutputLabel getCOMP_PAC_MAT_PAYEE_AGE_LABEL() {
		return COMP_PAC_MAT_PAYEE_AGE_LABEL;
	}

	public void setCOMP_PAC_MAT_PAYEE_AGE_LABEL(
			HtmlOutputLabel comp_pac_mat_payee_age_label) {
		COMP_PAC_MAT_PAYEE_AGE_LABEL = comp_pac_mat_payee_age_label;
	}

	public HtmlOutputLabel getCOMP_PAC_MAT_PAYER_AGE_LABEL() {
		return COMP_PAC_MAT_PAYER_AGE_LABEL;
	}

	public void setCOMP_PAC_MAT_PAYER_AGE_LABEL(
			HtmlOutputLabel comp_pac_mat_payer_age_label) {
		COMP_PAC_MAT_PAYER_AGE_LABEL = comp_pac_mat_payer_age_label;
	}

	public HtmlInputText getCOMP_PAC_MAT_PAYER_AGE() {
		return COMP_PAC_MAT_PAYER_AGE;
	}

	public void setCOMP_PAC_MAT_PAYER_AGE(HtmlInputText comp_pac_mat_payer_age) {
		COMP_PAC_MAT_PAYER_AGE = comp_pac_mat_payer_age;
	}

	public HtmlOutputLabel getCOMP_PAC_COVER_START_AGE_LABEL() {
		return COMP_PAC_COVER_START_AGE_LABEL;
	}

	public void setCOMP_PAC_COVER_START_AGE_LABEL(
			HtmlOutputLabel comp_pac_cover_start_age_label) {
		COMP_PAC_COVER_START_AGE_LABEL = comp_pac_cover_start_age_label;
	}

	public HtmlInputText getCOMP_PAC_COVER_START_AGE() {
		return COMP_PAC_COVER_START_AGE;
	}

	public void setCOMP_PAC_COVER_START_AGE(
			HtmlInputText comp_pac_cover_start_age) {
		COMP_PAC_COVER_START_AGE = comp_pac_cover_start_age;
	}
	public void PAC_COVER_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_COVER_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_PAC_COVER_CODE(compositeAction, value);
			COMP_UI_M_PAC_COVER_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void PAC_PERIOD_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_PERIOD(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_PERIOD((Integer) value);
			COMP_PAC_PREM_PAY_YRS.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	public void PAC_MAX_AGE_ON_MAT_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_MAX_AGE_ON_MAT(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_MAX_AGE_ON_MAT((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	public void PAC_COVER_START_AGE_VAL_YN_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_COVER_START_AGE_VAL_YN(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_COVER_START_AGE_VAL_YN((String) value);
			COMP_PAC_COVER_START_AGE.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	public void PAC_COVER_START_AGE_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_COVER_START_AGE(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_COVER_START_AGE((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	
	public void PAC_PREM_PAY_YRS_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_PREM_PAY_YRS(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_PREM_PAY_YRS((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	public void PAC_PRODUCTION_PERC_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_PRODUCTION_PERC(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_PRODUCTION_PERC((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	public void PAC_THRESHOLD_PERC_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_THRESHOLD_PERC(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_THRESHOLD_PERC((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	public void PAC_MED_DAYS_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_MED_DAYS(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_MED_DAYS((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	public void PAC_MED_AMT_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_MED_AMT(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_MED_AMT((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	
	public void PAC_BCH_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_BCH_CODE(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_BCH_CODE((String) value);
			COMP_UI_M_PAC_BCH_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void PAC_GRP_THRESHOLD_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_GRP_THRESHOLD_PERC(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_GRP_THRESHOLD_PERC((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void PAC_COVER_ASSR_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_COVER_ASSR_TYPE(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_COVER_ASSR_TYPE((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void PAC_AGE_BASIS_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_AGE_BASIS(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_AGE_BASIS((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void PAC_MAT_PAYER_AGE_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_MAT_PAYER_AGE(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_MAT_PAYER_AGE((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void PAC_MAT_PAYEE_AGE_Validator(FacesContext context,
			UIComponent component, Object value) throws Exception {
		try {
			helper.WHEN_VALIDATE_ITEM_PAC_MAT_PAYEE_AGE(compositeAction, value);
			getPM_IL_PROD_APPL_COVER_1_BEAN().setPAC_MAT_PAYEE_AGE((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public List<LovBean> lovPAC_COVER_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_COVER_1", "PAC_COVER_CODE", "A","S", null, null,
					null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return suggestionList;
	}
	public List<LovBean> lovPAC_BCH_CODE(Object obj){
		String bchcode = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object={};
		String query=null;
		try {
			if ("*".equals(bchcode)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = PILM035_APAC_QUERYCONSTANTS.BCH_CODE_LOV;
			} else {
				object = new Object[] { bchcode + "%", bchcode + "%",
						PELConstants.suggetionRecordSize };
				query = PILM035_APAC_QUERYCONSTANTS.BCH_CODE_LOV_LIKE;
			}
			suggestionList = delegate.prepareLovList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public HtmlOutputLabel getCOMP_PAC_COVER_ASSR_TYPE_LABEL() {
		return COMP_PAC_COVER_ASSR_TYPE_LABEL;
	}

	public void setCOMP_PAC_COVER_ASSR_TYPE_LABEL(
			HtmlOutputLabel comp_pac_cover_assr_type_label) {
		COMP_PAC_COVER_ASSR_TYPE_LABEL = comp_pac_cover_assr_type_label;
	}

	public HtmlSelectOneMenu getCOMP_PAC_COVER_ASSR_TYPE() {
		return COMP_PAC_COVER_ASSR_TYPE;
	}

	public void setCOMP_PAC_COVER_ASSR_TYPE(
			HtmlSelectOneMenu comp_pac_cover_assr_type) {
		COMP_PAC_COVER_ASSR_TYPE = comp_pac_cover_assr_type;
	}

}
