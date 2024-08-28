package com.iii.pel.forms.PILM035_APAC;

import java.util.ArrayList;
import java.util.Date;
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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_TOP_UP_CHARGE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_TUC_AMT_LC_FROM_LABEL;

	private HtmlInputText COMP_TUC_AMT_LC_FROM;

	private HtmlOutputLabel COMP_TUC_AMT_LC_TO_LABEL;

	private HtmlInputText COMP_TUC_AMT_LC_TO;

	private HtmlOutputLabel COMP_TUC_RATE_LABEL;

	private HtmlInputText COMP_TUC_RATE;

	private HtmlOutputLabel COMP_TUC_RATE_PER_LABEL;

	private HtmlInputText COMP_TUC_RATE_PER;

	private HtmlOutputLabel COMP_TUC_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_TUC_EFF_FM_DT;

	private HtmlOutputLabel COMP_TUC_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_TUC_EFF_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_TOP_UP;

	private PM_IL_TOP_UP_CHARGE PM_IL_TOP_UP_CHARGE_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_TOP_UP_CHARGE_HELPER helper;

	private List<PM_IL_TOP_UP_CHARGE> dataList_PM_IL_TOP_UP_CHARGE = new ArrayList<PM_IL_TOP_UP_CHARGE>();

	private UIData dataTable;

	public PM_IL_TOP_UP_CHARGE_ACTION() {

		PM_IL_TOP_UP_CHARGE_BEAN = new PM_IL_TOP_UP_CHARGE();
		helper = new PM_IL_TOP_UP_CHARGE_HELPER();
	}

	public HtmlOutputLabel getCOMP_TUC_AMT_LC_FROM_LABEL() {
		return COMP_TUC_AMT_LC_FROM_LABEL;
	}

	public HtmlInputText getCOMP_TUC_AMT_LC_FROM() {
		return COMP_TUC_AMT_LC_FROM;
	}

	public void setCOMP_TUC_AMT_LC_FROM_LABEL(
			HtmlOutputLabel COMP_TUC_AMT_LC_FROM_LABEL) {
		this.COMP_TUC_AMT_LC_FROM_LABEL = COMP_TUC_AMT_LC_FROM_LABEL;
	}

	public void setCOMP_TUC_AMT_LC_FROM(HtmlInputText COMP_TUC_AMT_LC_FROM) {
		this.COMP_TUC_AMT_LC_FROM = COMP_TUC_AMT_LC_FROM;
	}

	public HtmlOutputLabel getCOMP_TUC_AMT_LC_TO_LABEL() {
		return COMP_TUC_AMT_LC_TO_LABEL;
	}

	public HtmlInputText getCOMP_TUC_AMT_LC_TO() {
		return COMP_TUC_AMT_LC_TO;
	}

	public void setCOMP_TUC_AMT_LC_TO_LABEL(
			HtmlOutputLabel COMP_TUC_AMT_LC_TO_LABEL) {
		this.COMP_TUC_AMT_LC_TO_LABEL = COMP_TUC_AMT_LC_TO_LABEL;
	}

	public void setCOMP_TUC_AMT_LC_TO(HtmlInputText COMP_TUC_AMT_LC_TO) {
		this.COMP_TUC_AMT_LC_TO = COMP_TUC_AMT_LC_TO;
	}

	public HtmlOutputLabel getCOMP_TUC_RATE_LABEL() {
		return COMP_TUC_RATE_LABEL;
	}

	public HtmlInputText getCOMP_TUC_RATE() {
		return COMP_TUC_RATE;
	}

	public void setCOMP_TUC_RATE_LABEL(HtmlOutputLabel COMP_TUC_RATE_LABEL) {
		this.COMP_TUC_RATE_LABEL = COMP_TUC_RATE_LABEL;
	}

	public void setCOMP_TUC_RATE(HtmlInputText COMP_TUC_RATE) {
		this.COMP_TUC_RATE = COMP_TUC_RATE;
	}

	public HtmlOutputLabel getCOMP_TUC_RATE_PER_LABEL() {
		return COMP_TUC_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_TUC_RATE_PER() {
		return COMP_TUC_RATE_PER;
	}

	public void setCOMP_TUC_RATE_PER_LABEL(
			HtmlOutputLabel COMP_TUC_RATE_PER_LABEL) {
		this.COMP_TUC_RATE_PER_LABEL = COMP_TUC_RATE_PER_LABEL;
	}

	public void setCOMP_TUC_RATE_PER(HtmlInputText COMP_TUC_RATE_PER) {
		this.COMP_TUC_RATE_PER = COMP_TUC_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_TUC_EFF_FM_DT_LABEL() {
		return COMP_TUC_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TUC_EFF_FM_DT() {
		return COMP_TUC_EFF_FM_DT;
	}

	public void setCOMP_TUC_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_TUC_EFF_FM_DT_LABEL) {
		this.COMP_TUC_EFF_FM_DT_LABEL = COMP_TUC_EFF_FM_DT_LABEL;
	}

	public void setCOMP_TUC_EFF_FM_DT(HtmlCalendar COMP_TUC_EFF_FM_DT) {
		this.COMP_TUC_EFF_FM_DT = COMP_TUC_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_TUC_EFF_TO_DT_LABEL() {
		return COMP_TUC_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TUC_EFF_TO_DT() {
		return COMP_TUC_EFF_TO_DT;
	}

	public void setCOMP_TUC_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_TUC_EFF_TO_DT_LABEL) {
		this.COMP_TUC_EFF_TO_DT_LABEL = COMP_TUC_EFF_TO_DT_LABEL;
	}

	public void setCOMP_TUC_EFF_TO_DT(HtmlCalendar COMP_TUC_EFF_TO_DT) {
		this.COMP_TUC_EFF_TO_DT = COMP_TUC_EFF_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TOP_UP() {
		return COMP_UI_M_BUT_TOP_UP;
	}

	public void setCOMP_UI_M_BUT_TOP_UP(HtmlCommandButton COMP_UI_M_BUT_TOP_UP) {
		this.COMP_UI_M_BUT_TOP_UP = COMP_UI_M_BUT_TOP_UP;
	}

	public PM_IL_TOP_UP_CHARGE getPM_IL_TOP_UP_CHARGE_BEAN() {
		return PM_IL_TOP_UP_CHARGE_BEAN;
	}

	public void setPM_IL_TOP_UP_CHARGE_BEAN(
			PM_IL_TOP_UP_CHARGE PM_IL_TOP_UP_CHARGE_BEAN) {
		this.PM_IL_TOP_UP_CHARGE_BEAN = PM_IL_TOP_UP_CHARGE_BEAN;
	}

	public List<PM_IL_TOP_UP_CHARGE> getDataList_PM_IL_TOP_UP_CHARGE() {
		return dataList_PM_IL_TOP_UP_CHARGE;
	}

	public void setDataListPM_IL_TOP_UP_CHARGE(
			List<PM_IL_TOP_UP_CHARGE> dataList_PM_IL_TOP_UP_CHARGE) {
		this.dataList_PM_IL_TOP_UP_CHARGE = dataList_PM_IL_TOP_UP_CHARGE;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_TOP_UP_CHARGE_BEAN = new PM_IL_TOP_UP_CHARGE();
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

				new CRUDHandler().executeDelete(PM_IL_TOP_UP_CHARGE_BEAN,
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
				dataList_PM_IL_TOP_UP_CHARGE.remove(PM_IL_TOP_UP_CHARGE_BEAN);
				if (dataList_PM_IL_TOP_UP_CHARGE.size() > 0) {

					PM_IL_TOP_UP_CHARGE_BEAN = dataList_PM_IL_TOP_UP_CHARGE
							.get(0);
				} else if (dataList_PM_IL_TOP_UP_CHARGE.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_TOP_UP_CHARGE_BEAN.setRowSelected(true);
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
	public String mainAction(){

		return "PILM035_APAC_PM_IL_PRODUCT";
		
	}
	

	public void postRecord(ActionEvent event) {
		try {
			if (PM_IL_TOP_UP_CHARGE_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_TOP_UP_CHARGE_BEAN,
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
				dataList_PM_IL_TOP_UP_CHARGE.add(PM_IL_TOP_UP_CHARGE_BEAN);
			} else if (PM_IL_TOP_UP_CHARGE_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
                helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_TOP_UP_CHARGE_BEAN,
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

			PM_IL_TOP_UP_CHARGE_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_TOP_UP_CHARGE_BEAN = (PM_IL_TOP_UP_CHARGE) dataTable
					.getRowData();
			PM_IL_TOP_UP_CHARGE_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_TOP_UP_CHARGE> PM_IL_TOP_UP_CHARGE_ITR = dataList_PM_IL_TOP_UP_CHARGE
				.iterator();
		while (PM_IL_TOP_UP_CHARGE_ITR.hasNext()) {
			PM_IL_TOP_UP_CHARGE_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_TUC_AMT_LC_FROM.resetValue();
		COMP_TUC_AMT_LC_TO.resetValue();
		COMP_TUC_RATE.resetValue();
		COMP_TUC_RATE_PER.resetValue();
		COMP_TUC_EFF_FM_DT.resetValue();
		COMP_TUC_EFF_TO_DT.resetValue();
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
					"postRecord",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
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
	public void TUC_AMT_LC_FROM_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_TOP_UP_CHARGE_BEAN().setTUC_AMT_LC_FROM((Double) value);
			helper.TUC_AMT_LC_FROM_WHEN_VALIDATE_ITEM(compositeAction);
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
	public void TUC_AMT_LC_TO_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_TOP_UP_CHARGE_BEAN().setTUC_AMT_LC_TO((Double) value);
			helper.TUC_AMT_LC_TO_WHEN_VALIDATE_ITEM(compositeAction);
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
	public void TUC_EFF_FM_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_TOP_UP_CHARGE_BEAN().setTUC_EFF_FM_DT((Date) value);
			helper.TUC_EFF_FM_DT_WHEN_VALIDATE_ITEM(compositeAction);
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
	public void TUC_EFF_TO_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_TOP_UP_CHARGE_BEAN().setTUC_EFF_TO_DT((Date) value);
			helper.TUC_EFF_TO_DT_WHEN_VALIDATE_ITEM(compositeAction);
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
	public String navigationEnabled() {
		getErrorMap().clear();
		return "";

	}

}
