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
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_PA_BENEFIT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PPB_BEN_CALC_YN_LABEL;

	private HtmlSelectOneMenu COMP_PPB_BEN_CALC_YN;

	private HtmlOutputLabel COMP_PPB_COVER_CODE_LABEL;

	private HtmlInputText COMP_PPB_COVER_CODE;

	private HtmlOutputLabel COMP_PPB_BUSN_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PPB_BUSN_TYPE;

	private HtmlOutputLabel COMP_PPB_ACNT_YEAR_LABEL;

	private HtmlInputText COMP_PPB_ACNT_YEAR;

	private HtmlOutputLabel COMP_PPB_MORT_CODE_LABEL;

	private HtmlInputText COMP_PPB_MORT_CODE;

	private PM_IL_PROD_PA_BENEFIT PM_IL_PROD_PA_BENEFIT_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_PA_BENEFIT_HELPER helper;

	private List<PM_IL_PROD_PA_BENEFIT> dataList_PM_IL_PROD_PA_BENEFIT = new ArrayList<PM_IL_PROD_PA_BENEFIT>();

	private UIData dataTable;

	private List<SelectItem> listPPB_BEN_CALC_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPPB_BUSN_TYPE = new ArrayList<SelectItem>();

	public PM_IL_PROD_PA_BENEFIT_ACTION() {

		PM_IL_PROD_PA_BENEFIT_BEAN = new PM_IL_PROD_PA_BENEFIT();
		helper = new PM_IL_PROD_PA_BENEFIT_HELPER();
		prepareDropDowns();
	}

	public HtmlOutputLabel getCOMP_PPB_BEN_CALC_YN_LABEL() {
		return COMP_PPB_BEN_CALC_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PPB_BEN_CALC_YN() {
		return COMP_PPB_BEN_CALC_YN;
	}

	public void setCOMP_PPB_BEN_CALC_YN_LABEL(
			HtmlOutputLabel COMP_PPB_BEN_CALC_YN_LABEL) {
		this.COMP_PPB_BEN_CALC_YN_LABEL = COMP_PPB_BEN_CALC_YN_LABEL;
	}

	public void setCOMP_PPB_BEN_CALC_YN(HtmlSelectOneMenu COMP_PPB_BEN_CALC_YN) {
		this.COMP_PPB_BEN_CALC_YN = COMP_PPB_BEN_CALC_YN;
	}

	public HtmlOutputLabel getCOMP_PPB_COVER_CODE_LABEL() {
		return COMP_PPB_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PPB_COVER_CODE() {
		return COMP_PPB_COVER_CODE;
	}

	public void setCOMP_PPB_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_PPB_COVER_CODE_LABEL) {
		this.COMP_PPB_COVER_CODE_LABEL = COMP_PPB_COVER_CODE_LABEL;
	}

	public void setCOMP_PPB_COVER_CODE(HtmlInputText COMP_PPB_COVER_CODE) {
		this.COMP_PPB_COVER_CODE = COMP_PPB_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_PPB_BUSN_TYPE_LABEL() {
		return COMP_PPB_BUSN_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PPB_BUSN_TYPE() {
		return COMP_PPB_BUSN_TYPE;
	}

	public void setCOMP_PPB_BUSN_TYPE_LABEL(
			HtmlOutputLabel COMP_PPB_BUSN_TYPE_LABEL) {
		this.COMP_PPB_BUSN_TYPE_LABEL = COMP_PPB_BUSN_TYPE_LABEL;
	}

	public void setCOMP_PPB_BUSN_TYPE(HtmlSelectOneMenu COMP_PPB_BUSN_TYPE) {
		this.COMP_PPB_BUSN_TYPE = COMP_PPB_BUSN_TYPE;
	}

	public HtmlOutputLabel getCOMP_PPB_ACNT_YEAR_LABEL() {
		return COMP_PPB_ACNT_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_PPB_ACNT_YEAR() {
		return COMP_PPB_ACNT_YEAR;
	}

	public void setCOMP_PPB_ACNT_YEAR_LABEL(
			HtmlOutputLabel COMP_PPB_ACNT_YEAR_LABEL) {
		this.COMP_PPB_ACNT_YEAR_LABEL = COMP_PPB_ACNT_YEAR_LABEL;
	}

	public void setCOMP_PPB_ACNT_YEAR(HtmlInputText COMP_PPB_ACNT_YEAR) {
		this.COMP_PPB_ACNT_YEAR = COMP_PPB_ACNT_YEAR;
	}

	public HtmlOutputLabel getCOMP_PPB_MORT_CODE_LABEL() {
		return COMP_PPB_MORT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PPB_MORT_CODE() {
		return COMP_PPB_MORT_CODE;
	}

	public void setCOMP_PPB_MORT_CODE_LABEL(
			HtmlOutputLabel COMP_PPB_MORT_CODE_LABEL) {
		this.COMP_PPB_MORT_CODE_LABEL = COMP_PPB_MORT_CODE_LABEL;
	}

	public void setCOMP_PPB_MORT_CODE(HtmlInputText COMP_PPB_MORT_CODE) {
		this.COMP_PPB_MORT_CODE = COMP_PPB_MORT_CODE;
	}

	public PM_IL_PROD_PA_BENEFIT getPM_IL_PROD_PA_BENEFIT_BEAN() {
		return PM_IL_PROD_PA_BENEFIT_BEAN;
	}

	public void setPM_IL_PROD_PA_BENEFIT_BEAN(
			PM_IL_PROD_PA_BENEFIT PM_IL_PROD_PA_BENEFIT_BEAN) {
		this.PM_IL_PROD_PA_BENEFIT_BEAN = PM_IL_PROD_PA_BENEFIT_BEAN;
	}

	public List<PM_IL_PROD_PA_BENEFIT> getDataList_PM_IL_PROD_PA_BENEFIT() {
		return dataList_PM_IL_PROD_PA_BENEFIT;
	}

	public void setDataListPM_IL_PROD_PA_BENEFIT(
			List<PM_IL_PROD_PA_BENEFIT> dataList_PM_IL_PROD_PA_BENEFIT) {
		this.dataList_PM_IL_PROD_PA_BENEFIT = dataList_PM_IL_PROD_PA_BENEFIT;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				helper.WHEN_CREATE_RECORD(compositeAction);
				PM_IL_PROD_PA_BENEFIT_BEAN = new PM_IL_PROD_PA_BENEFIT();
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

				new CRUDHandler().executeDelete(PM_IL_PROD_PA_BENEFIT_BEAN,
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
				dataList_PM_IL_PROD_PA_BENEFIT
						.remove(PM_IL_PROD_PA_BENEFIT_BEAN);
				if (dataList_PM_IL_PROD_PA_BENEFIT.size() > 0) {

					PM_IL_PROD_PA_BENEFIT_BEAN = dataList_PM_IL_PROD_PA_BENEFIT
							.get(0);
				} else if (dataList_PM_IL_PROD_PA_BENEFIT.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_PA_BENEFIT_BEAN.setRowSelected(true);
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
		try {
			if (PM_IL_PROD_PA_BENEFIT_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_PA_BENEFIT_BEAN,
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
				dataList_PM_IL_PROD_PA_BENEFIT.add(PM_IL_PROD_PA_BENEFIT_BEAN);
			} else if (PM_IL_PROD_PA_BENEFIT_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_PA_BENEFIT_BEAN,
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

			PM_IL_PROD_PA_BENEFIT_BEAN.setRowSelected(true);
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
			PM_IL_PROD_PA_BENEFIT_BEAN = (PM_IL_PROD_PA_BENEFIT) dataTable
					.getRowData();
			PM_IL_PROD_PA_BENEFIT_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_PA_BENEFIT> PM_IL_PROD_PA_BENEFIT_ITR = dataList_PM_IL_PROD_PA_BENEFIT
				.iterator();
		while (PM_IL_PROD_PA_BENEFIT_ITR.hasNext()) {
			PM_IL_PROD_PA_BENEFIT_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PPB_BEN_CALC_YN.resetValue();
		COMP_PPB_COVER_CODE.resetValue();
		COMP_PPB_BUSN_TYPE.resetValue();
		COMP_PPB_ACNT_YEAR.resetValue();
		COMP_PPB_MORT_CODE.resetValue();
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

	public List<SelectItem> getListPPB_BEN_CALC_YN() {
		if (listPPB_BEN_CALC_YN.size() == 0) {
			listPPB_BEN_CALC_YN.clear();
			try {
				listPPB_BEN_CALC_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPPB_BEN_CALC_YN;
	}

	public void setListPPB_BEN_CALC_YN(List<SelectItem> listPPB_BEN_CALC_YN) {
		this.listPPB_BEN_CALC_YN = listPPB_BEN_CALC_YN;
	}

	public List<SelectItem> getListPPB_BUSN_TYPE() {
		if (listPPB_BUSN_TYPE.size() == 0) {
			listPPB_BUSN_TYPE.clear();
			try {
				listPPB_BUSN_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPPB_BUSN_TYPE;
	}

	public void setListPPB_BUSN_TYPE(List<SelectItem> listPPB_BUSN_TYPE) {
		this.listPPB_BUSN_TYPE = listPPB_BUSN_TYPE;
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

	public List<LovBean> lovPPB_COVER_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_PA_BENEFIT", "PPB_COVER_CODE", null, null,
					null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovPPB_MORT_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_PA_BENEFIT", "PPB_MORT_CODE", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	private void prepareDropDowns() {
		try {
			setListPPB_BEN_CALC_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_PA_BENEFIT",
					"PM_IL_PROD_PA_BENEFIT.PPB_BEN_CALC_YN", "YESNO"));
			setListPPB_BUSN_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_PA_BENEFIT",
					"PM_IL_PROD_PA_BENEFIT.PPB_BUSN_TYPE", "PABUSTYPE"));
			
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public void PPB_COVER_CODE_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			getPM_IL_PROD_PA_BENEFIT_BEAN().setPPB_COVER_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_PPB_COVER_CODE(compositeAction);
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

	public void PPB_ACNT_YEAR_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			getPM_IL_PROD_PA_BENEFIT_BEAN().setPPB_ACNT_YEAR((Integer) value);
			helper.WHEN_VALIDATE_ITEM_PPB_ACNT_YEAR(compositeAction);
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

	public void PPB_MORT_CODE_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			getPM_IL_PROD_PA_BENEFIT_BEAN().setPPB_MORT_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_PPB_MORT_CODE(compositeAction);
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

	public void PPB_BEN_CALC_YN_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			getPM_IL_PROD_PA_BENEFIT_BEAN().setPPB_BEN_CALC_YN((String) value);
			helper.WHEN_VALIDATE_ITEM_PPB_BEN_CALC_YN(compositeAction);
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
}
