package com.iii.pel.forms.PILM007;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLM_REPAY_DTL_ACTION extends
		com.iii.premia.common.action.CommonAction {

	private HtmlOutputLabel COMP_CRD_COVER_CODE_LABEL;

	private HtmlInputText COMP_CRD_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_1_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC_1;

	private HtmlOutputLabel COMP_CRD_LOSS_TYPE_LABEL;

	private HtmlInputText COMP_CRD_LOSS_TYPE;

	private HtmlOutputLabel COMP_UI_M_LOSS_DESC_1_LABEL;

	private HtmlInputText COMP_UI_M_LOSS_DESC_1;

	private HtmlOutputLabel COMP_CRD_DISABLE_TYPE_LABEL;

	private HtmlInputText COMP_CRD_DISABLE_TYPE;

	private HtmlOutputLabel COMP_UI_M_DISABLE_DESC_1_LABEL;

	private HtmlInputText COMP_UI_M_DISABLE_DESC_1;

	private PM_IL_CLM_REPAY_DTL PM_IL_CLM_REPAY_DTL_BEAN;

	public PILM007_COMPOSITE_ACTION compositeAction;

	private PM_IL_CLM_REPAY_DTL_HELPER helper;

	private List<PM_IL_CLM_REPAY_DTL> dataList_PM_IL_CLM_REPAY_DTL = new ArrayList<PM_IL_CLM_REPAY_DTL>();

	private UIData dataTable;

	public PM_IL_CLM_REPAY_DTL_ACTION() {

		PM_IL_CLM_REPAY_DTL_BEAN = new PM_IL_CLM_REPAY_DTL();
		helper = new PM_IL_CLM_REPAY_DTL_HELPER();
	}

	public HtmlOutputLabel getCOMP_CRD_COVER_CODE_LABEL() {
		return COMP_CRD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CRD_COVER_CODE() {
		return COMP_CRD_COVER_CODE;
	}

	public void setCOMP_CRD_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_CRD_COVER_CODE_LABEL) {
		this.COMP_CRD_COVER_CODE_LABEL = COMP_CRD_COVER_CODE_LABEL;
	}

	public void setCOMP_CRD_COVER_CODE(HtmlInputText COMP_CRD_COVER_CODE) {
		this.COMP_CRD_COVER_CODE = COMP_CRD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_1_LABEL() {
		return COMP_UI_M_COVER_DESC_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC_1() {
		return COMP_UI_M_COVER_DESC_1;
	}

	public void setCOMP_UI_M_COVER_DESC_1_LABEL(
			HtmlOutputLabel COMP_UI_M_COVER_DESC_1_LABEL) {
		this.COMP_UI_M_COVER_DESC_1_LABEL = COMP_UI_M_COVER_DESC_1_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC_1(HtmlInputText COMP_UI_M_COVER_DESC_1) {
		this.COMP_UI_M_COVER_DESC_1 = COMP_UI_M_COVER_DESC_1;
	}

	public HtmlOutputLabel getCOMP_CRD_LOSS_TYPE_LABEL() {
		return COMP_CRD_LOSS_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_CRD_LOSS_TYPE() {
		return COMP_CRD_LOSS_TYPE;
	}

	public void setCOMP_CRD_LOSS_TYPE_LABEL(
			HtmlOutputLabel COMP_CRD_LOSS_TYPE_LABEL) {
		this.COMP_CRD_LOSS_TYPE_LABEL = COMP_CRD_LOSS_TYPE_LABEL;
	}

	public void setCOMP_CRD_LOSS_TYPE(HtmlInputText COMP_CRD_LOSS_TYPE) {
		this.COMP_CRD_LOSS_TYPE = COMP_CRD_LOSS_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOSS_DESC_1_LABEL() {
		return COMP_UI_M_LOSS_DESC_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOSS_DESC_1() {
		return COMP_UI_M_LOSS_DESC_1;
	}

	public void setCOMP_UI_M_LOSS_DESC_1_LABEL(
			HtmlOutputLabel COMP_UI_M_LOSS_DESC_1_LABEL) {
		this.COMP_UI_M_LOSS_DESC_1_LABEL = COMP_UI_M_LOSS_DESC_1_LABEL;
	}

	public void setCOMP_UI_M_LOSS_DESC_1(HtmlInputText COMP_UI_M_LOSS_DESC_1) {
		this.COMP_UI_M_LOSS_DESC_1 = COMP_UI_M_LOSS_DESC_1;
	}

	public HtmlOutputLabel getCOMP_CRD_DISABLE_TYPE_LABEL() {
		return COMP_CRD_DISABLE_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_CRD_DISABLE_TYPE() {
		return COMP_CRD_DISABLE_TYPE;
	}

	public void setCOMP_CRD_DISABLE_TYPE_LABEL(
			HtmlOutputLabel COMP_CRD_DISABLE_TYPE_LABEL) {
		this.COMP_CRD_DISABLE_TYPE_LABEL = COMP_CRD_DISABLE_TYPE_LABEL;
	}

	public void setCOMP_CRD_DISABLE_TYPE(HtmlInputText COMP_CRD_DISABLE_TYPE) {
		this.COMP_CRD_DISABLE_TYPE = COMP_CRD_DISABLE_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DISABLE_DESC_1_LABEL() {
		return COMP_UI_M_DISABLE_DESC_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DISABLE_DESC_1() {
		return COMP_UI_M_DISABLE_DESC_1;
	}

	public void setCOMP_UI_M_DISABLE_DESC_1_LABEL(
			HtmlOutputLabel COMP_UI_M_DISABLE_DESC_1_LABEL) {
		this.COMP_UI_M_DISABLE_DESC_1_LABEL = COMP_UI_M_DISABLE_DESC_1_LABEL;
	}

	public void setCOMP_UI_M_DISABLE_DESC_1(
			HtmlInputText COMP_UI_M_DISABLE_DESC_1) {
		this.COMP_UI_M_DISABLE_DESC_1 = COMP_UI_M_DISABLE_DESC_1;
	}

	public PM_IL_CLM_REPAY_DTL getPM_IL_CLM_REPAY_DTL_BEAN() {
		return PM_IL_CLM_REPAY_DTL_BEAN;
	}

	public void setPM_IL_CLM_REPAY_DTL_BEAN(
			PM_IL_CLM_REPAY_DTL PM_IL_CLM_REPAY_DTL_BEAN) {
		this.PM_IL_CLM_REPAY_DTL_BEAN = PM_IL_CLM_REPAY_DTL_BEAN;
	}

	public List<PM_IL_CLM_REPAY_DTL> getDataList_PM_IL_CLM_REPAY_DTL() {
		return dataList_PM_IL_CLM_REPAY_DTL;
	}

	public void setDataListPM_IL_CLM_REPAY_DTL(
			List<PM_IL_CLM_REPAY_DTL> dataList_PM_IL_CLM_REPAY_DTL) {
		this.dataList_PM_IL_CLM_REPAY_DTL = dataList_PM_IL_CLM_REPAY_DTL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_CLM_REPAY_DTL_BEAN = new PM_IL_CLM_REPAY_DTL();
				resetAllComponent();
				resetSelectedRow();
			} else {

				throw new Exception(Messages.getString(
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
				new CRUDHandler().executeDelete(PM_IL_CLM_REPAY_DTL_BEAN,
						CommonUtils.getConnection());
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
				dataList_PM_IL_CLM_REPAY_DTL.remove(PM_IL_CLM_REPAY_DTL_BEAN);
				if (dataList_PM_IL_CLM_REPAY_DTL.size() > 0) {

					PM_IL_CLM_REPAY_DTL_BEAN = dataList_PM_IL_CLM_REPAY_DTL
							.get(0);
				} else if (dataList_PM_IL_CLM_REPAY_DTL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_CLM_REPAY_DTL_BEAN.setRowSelected(true);
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
			if (PM_IL_CLM_REPAY_DTL_BEAN.getROWID() == null) {
				if(isINSERT_ALLOWED()){
					helper.PRE_INSERT(compositeAction);
					new CRUDHandler().executeInsert(PM_IL_CLM_REPAY_DTL_BEAN,
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
							"errorPanel$message$insert"));
					dataList_PM_IL_CLM_REPAY_DTL.add(PM_IL_CLM_REPAY_DTL_BEAN);
					
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PM_IL_CLM_REPAY_DTL_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()){
					helper.PRE_UPDATE(PM_IL_CLM_REPAY_DTL_BEAN);
					new CRUDHandler().executeUpdate(PM_IL_CLM_REPAY_DTL_BEAN,
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
					
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$udpatenotallowed"));
				}
			}

			PM_IL_CLM_REPAY_DTL_BEAN.setRowSelected(true);
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
			PM_IL_CLM_REPAY_DTL_BEAN = (PM_IL_CLM_REPAY_DTL) dataTable
					.getRowData();
			helper.POST_QUERY(compositeAction);
			PM_IL_CLM_REPAY_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_CLM_REPAY_DTL> PM_IL_CLM_REPAY_DTL_ITR = dataList_PM_IL_CLM_REPAY_DTL
				.iterator();
		while (PM_IL_CLM_REPAY_DTL_ITR.hasNext()) {
			PM_IL_CLM_REPAY_DTL_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_CRD_COVER_CODE.resetValue();
		COMP_UI_M_COVER_DESC_1.resetValue();
		COMP_CRD_LOSS_TYPE.resetValue();
		COMP_UI_M_LOSS_DESC_1.resetValue();
		COMP_CRD_DISABLE_TYPE.resetValue();
		COMP_UI_M_DISABLE_DESC_1.resetValue();
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
			String message ="";
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,message);
		} catch (Exception e) {
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if(compositeAction.getPM_IL_CLM_REPAY_DTL_ACTION_BEAN().getPM_IL_CLM_REPAY_DTL_BEAN().getROWID()!=null)
				helper.POST_QUERY(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public void CRD_COVER_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_CLM_REPAY_DTL_BEAN().setCRD_COVER_CODE((String) value);
			helper.CRD_COVER_CODE_WHEN_VALIDATE_ITEM(compositeAction);
			COMP_UI_M_COVER_DESC_1.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CR_LOSS_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_CLM_REPAY_DTL_BEAN().setCRD_LOSS_TYPE((String) value);
			helper.CRD_LOSS_TYPE_WHEN_VALIDATE_ITEM(compositeAction);
			COMP_UI_M_LOSS_DESC_1.resetValue();
			} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CR_DISABLE_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_CLM_REPAY_DTL_BEAN().setCRD_DISABLE_TYPE((String) value);
			helper.CRD_DISABLE_TYPE_WHEN_VALIDATE_ITEM(compositeAction);
			COMP_UI_M_DISABLE_DESC_1.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}


}
