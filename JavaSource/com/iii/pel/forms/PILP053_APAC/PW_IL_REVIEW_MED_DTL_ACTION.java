package com.iii.pel.forms.PILP053_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PW_IL_REVIEW_MED_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_RMD_YEAR_LABEL;

	private HtmlInputText COMP_RMD_YEAR;

	private HtmlOutputLabel COMP_RMD_COVER_CODE_LABEL;

	private HtmlInputText COMP_RMD_COVER_CODE;

	private HtmlOutputLabel COMP_RMD_AGE_LABEL;

	private HtmlInputText COMP_RMD_AGE;

	private HtmlOutputLabel COMP_RMD_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_RMD_SUM_ASSURED;

	private HtmlOutputLabel COMP_RMD_RATE_LABEL;

	private HtmlInputText COMP_RMD_RATE;

	private HtmlOutputLabel COMP_RMD_PREMIUM_LABEL;

	private HtmlInputText COMP_RMD_PREMIUM;

	private HtmlOutputLabel COMP_RMD_UNEARN_CONT_AMT_LABEL;

	private HtmlInputText COMP_RMD_UNEARN_CONT_AMT;

	private HtmlOutputLabel COMP_UI_M_RMD_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_RMD_COVER_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private PW_IL_REVIEW_MED_DTL PW_IL_REVIEW_MED_DTL_BEAN;

	public PILP053_APAC_COMPOSITE_ACTION compositeAction;

	private PW_IL_REVIEW_MED_DTL_HELPER helper;

	private List<PW_IL_REVIEW_MED_DTL> dataList_PW_IL_REVIEW_MED_DTL = new ArrayList<PW_IL_REVIEW_MED_DTL>();

	private UIData dataTable;

	public PW_IL_REVIEW_MED_DTL_ACTION() {

		PW_IL_REVIEW_MED_DTL_BEAN = new PW_IL_REVIEW_MED_DTL();
		helper = new PW_IL_REVIEW_MED_DTL_HELPER();
	}

	public HtmlOutputLabel getCOMP_RMD_YEAR_LABEL() {
		return COMP_RMD_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_RMD_YEAR() {
		return COMP_RMD_YEAR;
	}

	public void setCOMP_RMD_YEAR_LABEL(HtmlOutputLabel COMP_RMD_YEAR_LABEL) {
		this.COMP_RMD_YEAR_LABEL = COMP_RMD_YEAR_LABEL;
	}

	public void setCOMP_RMD_YEAR(HtmlInputText COMP_RMD_YEAR) {
		this.COMP_RMD_YEAR = COMP_RMD_YEAR;
	}

	public HtmlOutputLabel getCOMP_RMD_COVER_CODE_LABEL() {
		return COMP_RMD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RMD_COVER_CODE() {
		return COMP_RMD_COVER_CODE;
	}

	public void setCOMP_RMD_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_RMD_COVER_CODE_LABEL) {
		this.COMP_RMD_COVER_CODE_LABEL = COMP_RMD_COVER_CODE_LABEL;
	}

	public void setCOMP_RMD_COVER_CODE(HtmlInputText COMP_RMD_COVER_CODE) {
		this.COMP_RMD_COVER_CODE = COMP_RMD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_RMD_AGE_LABEL() {
		return COMP_RMD_AGE_LABEL;
	}

	public HtmlInputText getCOMP_RMD_AGE() {
		return COMP_RMD_AGE;
	}

	public void setCOMP_RMD_AGE_LABEL(HtmlOutputLabel COMP_RMD_AGE_LABEL) {
		this.COMP_RMD_AGE_LABEL = COMP_RMD_AGE_LABEL;
	}

	public void setCOMP_RMD_AGE(HtmlInputText COMP_RMD_AGE) {
		this.COMP_RMD_AGE = COMP_RMD_AGE;
	}

	public HtmlOutputLabel getCOMP_RMD_SUM_ASSURED_LABEL() {
		return COMP_RMD_SUM_ASSURED_LABEL;
	}

	public HtmlInputText getCOMP_RMD_SUM_ASSURED() {
		return COMP_RMD_SUM_ASSURED;
	}

	public void setCOMP_RMD_SUM_ASSURED_LABEL(
			HtmlOutputLabel COMP_RMD_SUM_ASSURED_LABEL) {
		this.COMP_RMD_SUM_ASSURED_LABEL = COMP_RMD_SUM_ASSURED_LABEL;
	}

	public void setCOMP_RMD_SUM_ASSURED(HtmlInputText COMP_RMD_SUM_ASSURED) {
		this.COMP_RMD_SUM_ASSURED = COMP_RMD_SUM_ASSURED;
	}

	public HtmlOutputLabel getCOMP_RMD_RATE_LABEL() {
		return COMP_RMD_RATE_LABEL;
	}

	public HtmlInputText getCOMP_RMD_RATE() {
		return COMP_RMD_RATE;
	}

	public void setCOMP_RMD_RATE_LABEL(HtmlOutputLabel COMP_RMD_RATE_LABEL) {
		this.COMP_RMD_RATE_LABEL = COMP_RMD_RATE_LABEL;
	}

	public void setCOMP_RMD_RATE(HtmlInputText COMP_RMD_RATE) {
		this.COMP_RMD_RATE = COMP_RMD_RATE;
	}

	public HtmlOutputLabel getCOMP_RMD_PREMIUM_LABEL() {
		return COMP_RMD_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_RMD_PREMIUM() {
		return COMP_RMD_PREMIUM;
	}

	public void setCOMP_RMD_PREMIUM_LABEL(HtmlOutputLabel COMP_RMD_PREMIUM_LABEL) {
		this.COMP_RMD_PREMIUM_LABEL = COMP_RMD_PREMIUM_LABEL;
	}

	public void setCOMP_RMD_PREMIUM(HtmlInputText COMP_RMD_PREMIUM) {
		this.COMP_RMD_PREMIUM = COMP_RMD_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_RMD_UNEARN_CONT_AMT_LABEL() {
		return COMP_RMD_UNEARN_CONT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_RMD_UNEARN_CONT_AMT() {
		return COMP_RMD_UNEARN_CONT_AMT;
	}

	public void setCOMP_RMD_UNEARN_CONT_AMT_LABEL(
			HtmlOutputLabel COMP_RMD_UNEARN_CONT_AMT_LABEL) {
		this.COMP_RMD_UNEARN_CONT_AMT_LABEL = COMP_RMD_UNEARN_CONT_AMT_LABEL;
	}

	public void setCOMP_RMD_UNEARN_CONT_AMT(
			HtmlInputText COMP_RMD_UNEARN_CONT_AMT) {
		this.COMP_RMD_UNEARN_CONT_AMT = COMP_RMD_UNEARN_CONT_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_RMD_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_RMD_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_RMD_COVER_CODE_DESC() {
		return COMP_UI_M_RMD_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_RMD_COVER_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_RMD_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_RMD_COVER_CODE_DESC_LABEL = COMP_UI_M_RMD_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_RMD_COVER_CODE_DESC(
			HtmlInputText COMP_UI_M_RMD_COVER_CODE_DESC) {
		this.COMP_UI_M_RMD_COVER_CODE_DESC = COMP_UI_M_RMD_COVER_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public PW_IL_REVIEW_MED_DTL getPW_IL_REVIEW_MED_DTL_BEAN() {
		return PW_IL_REVIEW_MED_DTL_BEAN;
	}

	public void setPW_IL_REVIEW_MED_DTL_BEAN(
			PW_IL_REVIEW_MED_DTL PW_IL_REVIEW_MED_DTL_BEAN) {
		this.PW_IL_REVIEW_MED_DTL_BEAN = PW_IL_REVIEW_MED_DTL_BEAN;
	}

	public List<PW_IL_REVIEW_MED_DTL> getDataList_PW_IL_REVIEW_MED_DTL() {
		return dataList_PW_IL_REVIEW_MED_DTL;
	}

	public void setDataListPW_IL_REVIEW_MED_DTL(
			List<PW_IL_REVIEW_MED_DTL> dataList_PW_IL_REVIEW_MED_DTL) {
		this.dataList_PW_IL_REVIEW_MED_DTL = dataList_PW_IL_REVIEW_MED_DTL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PW_IL_REVIEW_MED_DTL_BEAN = new PW_IL_REVIEW_MED_DTL();
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

				new CRUDHandler().executeDelete(PW_IL_REVIEW_MED_DTL_BEAN,
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
				dataList_PW_IL_REVIEW_MED_DTL.remove(PW_IL_REVIEW_MED_DTL_BEAN);
				if (dataList_PW_IL_REVIEW_MED_DTL.size() > 0) {

					PW_IL_REVIEW_MED_DTL_BEAN = dataList_PW_IL_REVIEW_MED_DTL
							.get(0);
				} else if (dataList_PW_IL_REVIEW_MED_DTL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PW_IL_REVIEW_MED_DTL_BEAN.setRowSelected(true);
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
			if (PW_IL_REVIEW_MED_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PW_IL_REVIEW_MED_DTL_BEAN,
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
				dataList_PW_IL_REVIEW_MED_DTL.add(PW_IL_REVIEW_MED_DTL_BEAN);
			} else if (PW_IL_REVIEW_MED_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeDelete(PW_IL_REVIEW_MED_DTL_BEAN,
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

			PW_IL_REVIEW_MED_DTL_BEAN.setRowSelected(true);
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
			PW_IL_REVIEW_MED_DTL_BEAN = (PW_IL_REVIEW_MED_DTL) dataTable
					.getRowData();
			PW_IL_REVIEW_MED_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PW_IL_REVIEW_MED_DTL> PW_IL_REVIEW_MED_DTL_ITR = dataList_PW_IL_REVIEW_MED_DTL
				.iterator();
		while (PW_IL_REVIEW_MED_DTL_ITR.hasNext()) {
			PW_IL_REVIEW_MED_DTL_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_RMD_YEAR.resetValue();
		COMP_RMD_COVER_CODE.resetValue();
		COMP_RMD_AGE.resetValue();
		COMP_RMD_SUM_ASSURED.resetValue();
		COMP_RMD_RATE.resetValue();
		COMP_RMD_PREMIUM.resetValue();
		COMP_RMD_UNEARN_CONT_AMT.resetValue();
		COMP_UI_M_RMD_COVER_CODE_DESC.resetValue();
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

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				helper.POST_QUERY(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String okButtonAction(PILP053_APAC_COMPOSITE_ACTION compositeAction){
		
		try{
		compositeAction.getSURRENDER_ACTION_BEAN().getCOMP_UI_M_SMV_REASON_CODE().setDisabled(true);
		compositeAction.getSURRENDER_ACTION_BEAN().getCOMP_UI_M_SMV_REMARKS().setDisabled(true);
		compositeAction.getSURRENDER_ACTION_BEAN().getCOMP_UI_M_PC_SURR_LETTER_DATE().setDisabled(true);
		compositeAction.getSURRENDER_ACTION_BEAN().getCOMP_UI_M_R_PC_SCHD_PYMT_DT().setDisabled(true);
		String message = "";
		message = Messages.getString(PELConstants.pelErrorMessagePath,
					Messages.getString(PELConstants.pelErrorMessagePath, "60315"));
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							message);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return "";
	}
	
}
