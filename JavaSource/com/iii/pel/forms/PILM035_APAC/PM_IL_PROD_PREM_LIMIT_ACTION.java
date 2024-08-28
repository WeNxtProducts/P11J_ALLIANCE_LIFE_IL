package com.iii.pel.forms.PILM035_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
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

public class PM_IL_PROD_PREM_LIMIT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PPL_FM_TERM_LABEL;

	private HtmlInputText COMP_PPL_FM_TERM;

	private HtmlOutputLabel COMP_PPL_TO_TERM_LABEL;

	private HtmlInputText COMP_PPL_TO_TERM;

	private HtmlOutputLabel COMP_PPL_MODE_OF_PYMT_LABEL;

	private HtmlSelectOneMenu COMP_PPL_MODE_OF_PYMT;

	private HtmlOutputLabel COMP_PPL_CHECK_BASIS_LABEL;

	private HtmlSelectOneMenu COMP_PPL_CHECK_BASIS;

	private HtmlOutputLabel COMP_PPL_LC_MIN_PREM_LABEL;

	private HtmlInputText COMP_PPL_LC_MIN_PREM;

	private HtmlOutputLabel COMP_PPL_LC_MAX_PREM_LABEL;

	private HtmlInputText COMP_PPL_LC_MAX_PREM;

	private PM_IL_PROD_PREM_LIMIT PM_IL_PROD_PREM_LIMIT_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_PREM_LIMIT_HELPER helper;

	private List<PM_IL_PROD_PREM_LIMIT> dataList_PM_IL_PROD_PREM_LIMIT = new ArrayList<PM_IL_PROD_PREM_LIMIT>();

	private UIData dataTable;

	private List<SelectItem> listPPL_MODE_OF_PYMT = new ArrayList<SelectItem>();

	private List<SelectItem> listPPL_CHECK_BASIS = new ArrayList<SelectItem>();

	public PM_IL_PROD_PREM_LIMIT_ACTION() {

		PM_IL_PROD_PREM_LIMIT_BEAN = new PM_IL_PROD_PREM_LIMIT();
		helper = new PM_IL_PROD_PREM_LIMIT_HELPER();
		prepareDropDowns();
	}

	public HtmlOutputLabel getCOMP_PPL_FM_TERM_LABEL() {
		return COMP_PPL_FM_TERM_LABEL;
	}

	public HtmlInputText getCOMP_PPL_FM_TERM() {
		return COMP_PPL_FM_TERM;
	}

	public void setCOMP_PPL_FM_TERM_LABEL(HtmlOutputLabel COMP_PPL_FM_TERM_LABEL) {
		this.COMP_PPL_FM_TERM_LABEL = COMP_PPL_FM_TERM_LABEL;
	}

	public void setCOMP_PPL_FM_TERM(HtmlInputText COMP_PPL_FM_TERM) {
		this.COMP_PPL_FM_TERM = COMP_PPL_FM_TERM;
	}

	public HtmlOutputLabel getCOMP_PPL_TO_TERM_LABEL() {
		return COMP_PPL_TO_TERM_LABEL;
	}

	public HtmlInputText getCOMP_PPL_TO_TERM() {
		return COMP_PPL_TO_TERM;
	}

	public void setCOMP_PPL_TO_TERM_LABEL(HtmlOutputLabel COMP_PPL_TO_TERM_LABEL) {
		this.COMP_PPL_TO_TERM_LABEL = COMP_PPL_TO_TERM_LABEL;
	}

	public void setCOMP_PPL_TO_TERM(HtmlInputText COMP_PPL_TO_TERM) {
		this.COMP_PPL_TO_TERM = COMP_PPL_TO_TERM;
	}

	public HtmlOutputLabel getCOMP_PPL_MODE_OF_PYMT_LABEL() {
		return COMP_PPL_MODE_OF_PYMT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PPL_MODE_OF_PYMT() {
		return COMP_PPL_MODE_OF_PYMT;
	}

	public void setCOMP_PPL_MODE_OF_PYMT_LABEL(
			HtmlOutputLabel COMP_PPL_MODE_OF_PYMT_LABEL) {
		this.COMP_PPL_MODE_OF_PYMT_LABEL = COMP_PPL_MODE_OF_PYMT_LABEL;
	}

	public void setCOMP_PPL_MODE_OF_PYMT(HtmlSelectOneMenu COMP_PPL_MODE_OF_PYMT) {
		this.COMP_PPL_MODE_OF_PYMT = COMP_PPL_MODE_OF_PYMT;
	}

	public HtmlOutputLabel getCOMP_PPL_CHECK_BASIS_LABEL() {
		return COMP_PPL_CHECK_BASIS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PPL_CHECK_BASIS() {
		return COMP_PPL_CHECK_BASIS;
	}

	public void setCOMP_PPL_CHECK_BASIS_LABEL(
			HtmlOutputLabel COMP_PPL_CHECK_BASIS_LABEL) {
		this.COMP_PPL_CHECK_BASIS_LABEL = COMP_PPL_CHECK_BASIS_LABEL;
	}

	public void setCOMP_PPL_CHECK_BASIS(HtmlSelectOneMenu COMP_PPL_CHECK_BASIS) {
		this.COMP_PPL_CHECK_BASIS = COMP_PPL_CHECK_BASIS;
	}

	public HtmlOutputLabel getCOMP_PPL_LC_MIN_PREM_LABEL() {
		return COMP_PPL_LC_MIN_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PPL_LC_MIN_PREM() {
		return COMP_PPL_LC_MIN_PREM;
	}

	public void setCOMP_PPL_LC_MIN_PREM_LABEL(
			HtmlOutputLabel COMP_PPL_LC_MIN_PREM_LABEL) {
		this.COMP_PPL_LC_MIN_PREM_LABEL = COMP_PPL_LC_MIN_PREM_LABEL;
	}

	public void setCOMP_PPL_LC_MIN_PREM(HtmlInputText COMP_PPL_LC_MIN_PREM) {
		this.COMP_PPL_LC_MIN_PREM = COMP_PPL_LC_MIN_PREM;
	}

	public HtmlOutputLabel getCOMP_PPL_LC_MAX_PREM_LABEL() {
		return COMP_PPL_LC_MAX_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PPL_LC_MAX_PREM() {
		return COMP_PPL_LC_MAX_PREM;
	}

	public void setCOMP_PPL_LC_MAX_PREM_LABEL(
			HtmlOutputLabel COMP_PPL_LC_MAX_PREM_LABEL) {
		this.COMP_PPL_LC_MAX_PREM_LABEL = COMP_PPL_LC_MAX_PREM_LABEL;
	}

	public void setCOMP_PPL_LC_MAX_PREM(HtmlInputText COMP_PPL_LC_MAX_PREM) {
		this.COMP_PPL_LC_MAX_PREM = COMP_PPL_LC_MAX_PREM;
	}

	public PM_IL_PROD_PREM_LIMIT getPM_IL_PROD_PREM_LIMIT_BEAN() {
		return PM_IL_PROD_PREM_LIMIT_BEAN;
	}

	public void setPM_IL_PROD_PREM_LIMIT_BEAN(
			PM_IL_PROD_PREM_LIMIT PM_IL_PROD_PREM_LIMIT_BEAN) {
		this.PM_IL_PROD_PREM_LIMIT_BEAN = PM_IL_PROD_PREM_LIMIT_BEAN;
	}

	public List<PM_IL_PROD_PREM_LIMIT> getDataList_PM_IL_PROD_PREM_LIMIT() {
		return dataList_PM_IL_PROD_PREM_LIMIT;
	}

	public void setDataListPM_IL_PROD_PREM_LIMIT(
			List<PM_IL_PROD_PREM_LIMIT> dataList_PM_IL_PROD_PREM_LIMIT) {
		this.dataList_PM_IL_PROD_PREM_LIMIT = dataList_PM_IL_PROD_PREM_LIMIT;
	}

	public void addRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (isINSERT_ALLOWED()) {
				//helper.WHEN_CREATE_RECORD(compositeAction);
				PM_IL_PROD_PREM_LIMIT_BEAN = new PM_IL_PROD_PREM_LIMIT();
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
		CommonUtils.clearMaps(this);
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_PROD_PREM_LIMIT_BEAN,
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
				dataList_PM_IL_PROD_PREM_LIMIT
						.remove(PM_IL_PROD_PREM_LIMIT_BEAN);
				if (dataList_PM_IL_PROD_PREM_LIMIT.size() > 0) {

					PM_IL_PROD_PREM_LIMIT_BEAN = dataList_PM_IL_PROD_PREM_LIMIT
							.get(0);
				} else if (dataList_PM_IL_PROD_PREM_LIMIT.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_PREM_LIMIT_BEAN.setRowSelected(true);
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

	public void postRecord(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (PM_IL_PROD_PREM_LIMIT_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_PREM_LIMIT_BEAN,
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
				dataList_PM_IL_PROD_PREM_LIMIT.add(PM_IL_PROD_PREM_LIMIT_BEAN);
			} else if (PM_IL_PROD_PREM_LIMIT_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_PREM_LIMIT_BEAN,
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

			PM_IL_PROD_PREM_LIMIT_BEAN.setRowSelected(true);
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
			PM_IL_PROD_PREM_LIMIT_BEAN = (PM_IL_PROD_PREM_LIMIT) dataTable
					.getRowData();
			PM_IL_PROD_PREM_LIMIT_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_PREM_LIMIT> PM_IL_PROD_PREM_LIMIT_ITR = dataList_PM_IL_PROD_PREM_LIMIT
				.iterator();
		while (PM_IL_PROD_PREM_LIMIT_ITR.hasNext()) {
			PM_IL_PROD_PREM_LIMIT_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PPL_FM_TERM.resetValue();
		COMP_PPL_TO_TERM.resetValue();
		COMP_PPL_MODE_OF_PYMT.resetValue();
		COMP_PPL_CHECK_BASIS.resetValue();
		COMP_PPL_LC_MIN_PREM.resetValue();
		COMP_PPL_LC_MAX_PREM.resetValue();
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
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPPL_MODE_OF_PYMT() {
		if (listPPL_MODE_OF_PYMT.size() == 0) {
			listPPL_MODE_OF_PYMT.clear();
			try {
				listPPL_MODE_OF_PYMT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPPL_MODE_OF_PYMT;
	}

	public void setListPPL_MODE_OF_PYMT(List<SelectItem> listPPL_MODE_OF_PYMT) {
		this.listPPL_MODE_OF_PYMT = listPPL_MODE_OF_PYMT;
	}

	public List<SelectItem> getListPPL_CHECK_BASIS() {
		if (listPPL_CHECK_BASIS.size() == 0) {
			listPPL_CHECK_BASIS.clear();
			try {
				listPPL_CHECK_BASIS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPPL_CHECK_BASIS;
	}

	public void setListPPL_CHECK_BASIS(List<SelectItem> listPPL_CHECK_BASIS) {
		this.listPPL_CHECK_BASIS = listPPL_CHECK_BASIS;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
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

	public void PPL_FM_TERM_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PPL_FM_TERM(compositeAction, value);
			getPM_IL_PROD_PREM_LIMIT_BEAN().setPPL_FM_TERM((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PPL_TO_TERM_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PPL_TO_TERM(compositeAction, value);
			getPM_IL_PROD_PREM_LIMIT_BEAN().setPPL_TO_TERM((Integer) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PPL_MODE_OF_PYMT_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_LIST_CHANGED_PPL_MODE_OF_PYMT(compositeAction);
			getPM_IL_PROD_PREM_LIMIT_BEAN().setPPL_MODE_OF_PYMT((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PPL_CHECK_BASIS_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_LIST_CHANGED_PPL_CHECK_BASIS(compositeAction);
			getPM_IL_PROD_PREM_LIMIT_BEAN().setPPL_CHECK_BASIS((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	public void PPL_LC_MIN_PREM_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PPL_LC_MIN_PREM(compositeAction,
					(Double) value);
			getPM_IL_PROD_PREM_LIMIT_BEAN().setPPL_LC_MIN_PREM((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PPL_LC_MAX_PREM_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PPL_LC_MAX_PREM(compositeAction,
					(Double) value);
			getPM_IL_PROD_PREM_LIMIT_BEAN().setPPL_LC_MAX_PREM((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}

	private void prepareDropDowns() {
		try {
			setListPPL_MODE_OF_PYMT(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_PREM_LIMIT",
					"PM_IL_PROD_PREM_LIMIT.PPL_MODE_OF_PYMT", "PAYMODE"));
			setListPPL_CHECK_BASIS(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_PREM_LIMIT",
					"PM_IL_PROD_PREM_LIMIT.PPL_CHECK_BASIS", "CHECKBASIS"));
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
