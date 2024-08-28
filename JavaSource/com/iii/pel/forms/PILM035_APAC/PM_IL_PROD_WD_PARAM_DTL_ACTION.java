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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_WD_PARAM_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PWPD_FM_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_PWPD_FM_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_PWPD_TO_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_PWPD_TO_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_PWPD_LIMIT_RATE_LABEL;

	private HtmlInputText COMP_PWPD_LIMIT_RATE;

	private HtmlOutputLabel COMP_PWPD_LIMIT_RATE_PER_LABEL;

	private HtmlInputText COMP_PWPD_LIMIT_RATE_PER;

	private HtmlOutputLabel COMP_PWPD_TOPUP_LIMIT_RATE_LABEL;

	private HtmlInputText COMP_PWPD_TOPUP_LIMIT_RATE;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN2;

	private HtmlOutputLabel COMP_PWPD_TOPUP_LIMIT_RATE_PER_LABEL;

	private HtmlInputText COMP_PWPD_TOPUP_LIMIT_RATE_PER;

	private HtmlOutputLabel COMP_PWPD_LC_MIN_AMT_LABEL;

	private HtmlInputText COMP_PWPD_LC_MIN_AMT;

	private HtmlOutputLabel COMP_PWPD_LC_MAX_AMT_LABEL;

	private HtmlInputText COMP_PWPD_LC_MAX_AMT;

	private PM_IL_PROD_WD_PARAM_DTL PM_IL_PROD_WD_PARAM_DTL_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_WD_PARAM_DTL_HELPER helper;

	private List<PM_IL_PROD_WD_PARAM_DTL> dataList_PM_IL_PROD_WD_PARAM_DTL = new ArrayList<PM_IL_PROD_WD_PARAM_DTL>();

	private UIData dataTable;

	public PM_IL_PROD_WD_PARAM_DTL_ACTION() {

		PM_IL_PROD_WD_PARAM_DTL_BEAN = new PM_IL_PROD_WD_PARAM_DTL();
		helper = new PM_IL_PROD_WD_PARAM_DTL_HELPER();
	}

	public HtmlOutputLabel getCOMP_PWPD_FM_PREM_PAY_YRS_LABEL() {
		return COMP_PWPD_FM_PREM_PAY_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PWPD_FM_PREM_PAY_YRS() {
		return COMP_PWPD_FM_PREM_PAY_YRS;
	}

	public void setCOMP_PWPD_FM_PREM_PAY_YRS_LABEL(
			HtmlOutputLabel COMP_PWPD_FM_PREM_PAY_YRS_LABEL) {
		this.COMP_PWPD_FM_PREM_PAY_YRS_LABEL = COMP_PWPD_FM_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_PWPD_FM_PREM_PAY_YRS(
			HtmlInputText COMP_PWPD_FM_PREM_PAY_YRS) {
		this.COMP_PWPD_FM_PREM_PAY_YRS = COMP_PWPD_FM_PREM_PAY_YRS;
	}

	public HtmlOutputLabel getCOMP_PWPD_TO_PREM_PAY_YRS_LABEL() {
		return COMP_PWPD_TO_PREM_PAY_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PWPD_TO_PREM_PAY_YRS() {
		return COMP_PWPD_TO_PREM_PAY_YRS;
	}

	public void setCOMP_PWPD_TO_PREM_PAY_YRS_LABEL(
			HtmlOutputLabel COMP_PWPD_TO_PREM_PAY_YRS_LABEL) {
		this.COMP_PWPD_TO_PREM_PAY_YRS_LABEL = COMP_PWPD_TO_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_PWPD_TO_PREM_PAY_YRS(
			HtmlInputText COMP_PWPD_TO_PREM_PAY_YRS) {
		this.COMP_PWPD_TO_PREM_PAY_YRS = COMP_PWPD_TO_PREM_PAY_YRS;
	}

	public HtmlOutputLabel getCOMP_PWPD_LIMIT_RATE_LABEL() {
		return COMP_PWPD_LIMIT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PWPD_LIMIT_RATE() {
		return COMP_PWPD_LIMIT_RATE;
	}

	public void setCOMP_PWPD_LIMIT_RATE_LABEL(
			HtmlOutputLabel COMP_PWPD_LIMIT_RATE_LABEL) {
		this.COMP_PWPD_LIMIT_RATE_LABEL = COMP_PWPD_LIMIT_RATE_LABEL;
	}

	public void setCOMP_PWPD_LIMIT_RATE(HtmlInputText COMP_PWPD_LIMIT_RATE) {
		this.COMP_PWPD_LIMIT_RATE = COMP_PWPD_LIMIT_RATE;
	}

	public HtmlOutputLabel getCOMP_PWPD_LIMIT_RATE_PER_LABEL() {
		return COMP_PWPD_LIMIT_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PWPD_LIMIT_RATE_PER() {
		return COMP_PWPD_LIMIT_RATE_PER;
	}

	public void setCOMP_PWPD_LIMIT_RATE_PER_LABEL(
			HtmlOutputLabel COMP_PWPD_LIMIT_RATE_PER_LABEL) {
		this.COMP_PWPD_LIMIT_RATE_PER_LABEL = COMP_PWPD_LIMIT_RATE_PER_LABEL;
	}

	public void setCOMP_PWPD_LIMIT_RATE_PER(
			HtmlInputText COMP_PWPD_LIMIT_RATE_PER) {
		this.COMP_PWPD_LIMIT_RATE_PER = COMP_PWPD_LIMIT_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PWPD_TOPUP_LIMIT_RATE_LABEL() {
		return COMP_PWPD_TOPUP_LIMIT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PWPD_TOPUP_LIMIT_RATE() {
		return COMP_PWPD_TOPUP_LIMIT_RATE;
	}

	public void setCOMP_PWPD_TOPUP_LIMIT_RATE_LABEL(
			HtmlOutputLabel COMP_PWPD_TOPUP_LIMIT_RATE_LABEL) {
		this.COMP_PWPD_TOPUP_LIMIT_RATE_LABEL = COMP_PWPD_TOPUP_LIMIT_RATE_LABEL;
	}

	public void setCOMP_PWPD_TOPUP_LIMIT_RATE(
			HtmlInputText COMP_PWPD_TOPUP_LIMIT_RATE) {
		this.COMP_PWPD_TOPUP_LIMIT_RATE = COMP_PWPD_TOPUP_LIMIT_RATE;
	}

	public HtmlOutputLabel getCOMP_PWPD_TOPUP_LIMIT_RATE_PER_LABEL() {
		return COMP_PWPD_TOPUP_LIMIT_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PWPD_TOPUP_LIMIT_RATE_PER() {
		return COMP_PWPD_TOPUP_LIMIT_RATE_PER;
	}

	public void setCOMP_PWPD_TOPUP_LIMIT_RATE_PER_LABEL(
			HtmlOutputLabel COMP_PWPD_TOPUP_LIMIT_RATE_PER_LABEL) {
		this.COMP_PWPD_TOPUP_LIMIT_RATE_PER_LABEL = COMP_PWPD_TOPUP_LIMIT_RATE_PER_LABEL;
	}

	public void setCOMP_PWPD_TOPUP_LIMIT_RATE_PER(
			HtmlInputText COMP_PWPD_TOPUP_LIMIT_RATE_PER) {
		this.COMP_PWPD_TOPUP_LIMIT_RATE_PER = COMP_PWPD_TOPUP_LIMIT_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PWPD_LC_MIN_AMT_LABEL() {
		return COMP_PWPD_LC_MIN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PWPD_LC_MIN_AMT() {
		return COMP_PWPD_LC_MIN_AMT;
	}

	public void setCOMP_PWPD_LC_MIN_AMT_LABEL(
			HtmlOutputLabel COMP_PWPD_LC_MIN_AMT_LABEL) {
		this.COMP_PWPD_LC_MIN_AMT_LABEL = COMP_PWPD_LC_MIN_AMT_LABEL;
	}

	public void setCOMP_PWPD_LC_MIN_AMT(HtmlInputText COMP_PWPD_LC_MIN_AMT) {
		this.COMP_PWPD_LC_MIN_AMT = COMP_PWPD_LC_MIN_AMT;
	}

	public HtmlOutputLabel getCOMP_PWPD_LC_MAX_AMT_LABEL() {
		return COMP_PWPD_LC_MAX_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PWPD_LC_MAX_AMT() {
		return COMP_PWPD_LC_MAX_AMT;
	}

	public void setCOMP_PWPD_LC_MAX_AMT_LABEL(
			HtmlOutputLabel COMP_PWPD_LC_MAX_AMT_LABEL) {
		this.COMP_PWPD_LC_MAX_AMT_LABEL = COMP_PWPD_LC_MAX_AMT_LABEL;
	}

	public void setCOMP_PWPD_LC_MAX_AMT(HtmlInputText COMP_PWPD_LC_MAX_AMT) {
		this.COMP_PWPD_LC_MAX_AMT = COMP_PWPD_LC_MAX_AMT;
	}

	public PM_IL_PROD_WD_PARAM_DTL getPM_IL_PROD_WD_PARAM_DTL_BEAN() {
		return PM_IL_PROD_WD_PARAM_DTL_BEAN;
	}

	public void setPM_IL_PROD_WD_PARAM_DTL_BEAN(
			PM_IL_PROD_WD_PARAM_DTL PM_IL_PROD_WD_PARAM_DTL_BEAN) {
		this.PM_IL_PROD_WD_PARAM_DTL_BEAN = PM_IL_PROD_WD_PARAM_DTL_BEAN;
	}

	public List<PM_IL_PROD_WD_PARAM_DTL> getDataList_PM_IL_PROD_WD_PARAM_DTL() {
		return dataList_PM_IL_PROD_WD_PARAM_DTL;
	}

	public void setDataListPM_IL_PROD_WD_PARAM_DTL(
			List<PM_IL_PROD_WD_PARAM_DTL> dataList_PM_IL_PROD_WD_PARAM_DTL) {
		this.dataList_PM_IL_PROD_WD_PARAM_DTL = dataList_PM_IL_PROD_WD_PARAM_DTL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_PROD_WD_PARAM_DTL_BEAN = new PM_IL_PROD_WD_PARAM_DTL();
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
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_PROD_WD_PARAM_DTL_BEAN,
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
				dataList_PM_IL_PROD_WD_PARAM_DTL
						.remove(PM_IL_PROD_WD_PARAM_DTL_BEAN);
				if (dataList_PM_IL_PROD_WD_PARAM_DTL.size() > 0) {

					PM_IL_PROD_WD_PARAM_DTL_BEAN = dataList_PM_IL_PROD_WD_PARAM_DTL
							.get(0);
				} else if (dataList_PM_IL_PROD_WD_PARAM_DTL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setRowSelected(true);
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

	public String mainAction() {

		return "PILM035_APAC_PM_IL_PRODUCT";
	}

	public void postRecord(ActionEvent event) {
		compositeAction.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN().getErrorMap().clear();
		compositeAction.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN().getWarningMap().clear();
		try {
			if (PM_IL_PROD_WD_PARAM_DTL_BEAN.getROWID() == null){
				if( isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_WD_PARAM_DTL_BEAN,
						CommonUtils.getConnection());
				compositeAction.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN().getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				compositeAction.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN().getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				dataList_PM_IL_PROD_WD_PARAM_DTL
						.add(PM_IL_PROD_WD_PARAM_DTL_BEAN);
			}
			else{
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$insertnotallowed"));
			}
			}
			else if (PM_IL_PROD_WD_PARAM_DTL_BEAN.getROWID() != null){
					if(isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_WD_PARAM_DTL_BEAN,
						CommonUtils.getConnection());
				compositeAction.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN().getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				compositeAction.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN().getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}
			else{
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$updatenotallowed"));
			}
			}
			PM_IL_PROD_WD_PARAM_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public String displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PROD_WD_PARAM_DTL_BEAN = (PM_IL_PROD_WD_PARAM_DTL) dataTable
					.getRowData();
			PM_IL_PROD_WD_PARAM_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
		return "";

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_WD_PARAM_DTL> PM_IL_PROD_WD_PARAM_DTL_ITR = dataList_PM_IL_PROD_WD_PARAM_DTL
				.iterator();
		while (PM_IL_PROD_WD_PARAM_DTL_ITR.hasNext()) {
			PM_IL_PROD_WD_PARAM_DTL_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PWPD_FM_PREM_PAY_YRS.resetValue();
		COMP_PWPD_TO_PREM_PAY_YRS.resetValue();
		COMP_PWPD_LIMIT_RATE.resetValue();
		COMP_PWPD_LIMIT_RATE_PER.resetValue();
		COMP_PWPD_TOPUP_LIMIT_RATE.resetValue();
		COMP_PWPD_TOPUP_LIMIT_RATE_PER.resetValue();
		COMP_PWPD_LC_MIN_AMT.resetValue();
		COMP_PWPD_LC_MAX_AMT.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		CommonUtils.clearMaps(this);
			try {
				if (getPM_IL_PROD_WD_PARAM_DTL_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(
					getPM_IL_PROD_WD_PARAM_DTL_BEAN(), CommonUtils
					.getConnection());
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));
				getWarningMap().put(
						"save",
						Messages.getString("messageProperties",
						"errorPanel$message$save"));
				} else {
					new CRUDHandler().executeUpdate(
							getPM_IL_PROD_WD_PARAM_DTL_BEAN(), CommonUtils
							.getConnection());
					getWarningMap().put(
							"current",
							Messages.getString("messageProperties",
									"errorPanel$message$update"));
					getWarningMap().put(
							"update",
							Messages.getString("messageProperties",
							"errorPanel$message$update"));
					
				}
			CommonUtils.getConnection().commit();
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PWPD_FM_PREM_PAY_YRS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WHEN_VALIDATATE_ITEM_PWPD_FM_PREM_PAY_YRS(compositeAction,
					value);
			getPM_IL_PROD_WD_PARAM_DTL_BEAN().setPWPD_FM_PREM_PAY_YRS(
					(Double) value);
		} catch (Exception e) {
			e.printStackTrace();
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

	public void PWPD_TO_PREM_PAY_YRS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WHEN_VALIDATATE_ITEM_PWPD_TO_PREM_PAY_YRS(compositeAction,
					value);
			getPM_IL_PROD_WD_PARAM_DTL_BEAN().setPWPD_TO_PREM_PAY_YRS(
					(Double) value);
		} catch (Exception e) {
			e.printStackTrace();
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

	public void PWPD_LC_MIN_AMT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WHEN_VALIDATE_ITEM_PWPD_LC_MIN_AMT(compositeAction, value);
			getPM_IL_PROD_WD_PARAM_DTL_BEAN()
					.setPWPD_LC_MIN_AMT((Double) value);
		} catch (Exception e) {
			e.printStackTrace();
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

	public void PWPD_LC_MAX_AMT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.WHEN_VALIDATE_ITEM_PWPD_LC_MAX_AMT(compositeAction, value);
			getPM_IL_PROD_WD_PARAM_DTL_BEAN()
					.setPWPD_LC_MAX_AMT((Double) value);
		} catch (Exception e) {
			e.printStackTrace();
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

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN2() {
		return COMP_UI_M_BUT_MAIN2;
	}

	public void setCOMP_UI_M_BUT_MAIN2(HtmlCommandButton comp_ui_m_but_main2) {
		COMP_UI_M_BUT_MAIN2 = comp_ui_m_but_main2;
	}

}
