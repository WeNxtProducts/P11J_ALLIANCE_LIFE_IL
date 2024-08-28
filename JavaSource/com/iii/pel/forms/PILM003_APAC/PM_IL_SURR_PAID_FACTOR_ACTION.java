package com.iii.pel.forms.PILM003_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
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

public class PM_IL_SURR_PAID_FACTOR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_SPF_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_SPF_FRZ_FLAG;

	private HtmlOutputLabel COMP_SPF_PERIOD_LABEL;

	private HtmlInputText COMP_SPF_PERIOD;

	private HtmlOutputLabel COMP_SPF_NO_YRS_PREM_PAID_LABEL;

	private HtmlInputText COMP_SPF_NO_YRS_PREM_PAID;

	private HtmlOutputLabel COMP_SPF_UPTO_DAYS_LABEL;

	private HtmlInputText COMP_SPF_UPTO_DAYS;

	private HtmlOutputLabel COMP_SPF_POL_SURR_FACTOR_LABEL;

	private HtmlInputText COMP_SPF_POL_SURR_FACTOR;

	private HtmlOutputLabel COMP_SPF_PRO_SURR_FACTOR_LABEL;

	private HtmlInputText COMP_SPF_PRO_SURR_FACTOR;

	private HtmlOutputLabel COMP_SPF_POL_PAIDUP_FACTOR_LABEL;

	private HtmlInputText COMP_SPF_POL_PAIDUP_FACTOR;

	private HtmlOutputLabel COMP_SPF_PRO_PAIDUP_FACTOR_LABEL;

	private HtmlInputText COMP_SPF_PRO_PAIDUP_FACTOR;

	private HtmlOutputLabel COMP_SPF_RATE_PER_LABEL;

	private HtmlInputText COMP_SPF_RATE_PER;

	private PM_IL_SURR_PAID_FACTOR PM_IL_SURR_PAID_FACTOR_BEAN;

	public PILM003_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_SURR_PAID_FACTOR_HELPER helper;

	private List<PM_IL_SURR_PAID_FACTOR> dataList_PM_IL_SURR_PAID_FACTOR = new ArrayList<PM_IL_SURR_PAID_FACTOR>();

	private UIData dataTable;

	public PM_IL_SURR_PAID_FACTOR_ACTION() {

		PM_IL_SURR_PAID_FACTOR_BEAN = new PM_IL_SURR_PAID_FACTOR();
		helper = new PM_IL_SURR_PAID_FACTOR_HELPER();
	}

	public HtmlOutputLabel getCOMP_SPF_FRZ_FLAG_LABEL() {
		return COMP_SPF_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_SPF_FRZ_FLAG() {
		return COMP_SPF_FRZ_FLAG;
	}

	public void setCOMP_SPF_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_SPF_FRZ_FLAG_LABEL) {
		this.COMP_SPF_FRZ_FLAG_LABEL = COMP_SPF_FRZ_FLAG_LABEL;
	}

	public void setCOMP_SPF_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_SPF_FRZ_FLAG) {
		this.COMP_SPF_FRZ_FLAG = COMP_SPF_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_SPF_PERIOD_LABEL() {
		return COMP_SPF_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_SPF_PERIOD() {
		return COMP_SPF_PERIOD;
	}

	public void setCOMP_SPF_PERIOD_LABEL(HtmlOutputLabel COMP_SPF_PERIOD_LABEL) {
		this.COMP_SPF_PERIOD_LABEL = COMP_SPF_PERIOD_LABEL;
	}

	public void setCOMP_SPF_PERIOD(HtmlInputText COMP_SPF_PERIOD) {
		this.COMP_SPF_PERIOD = COMP_SPF_PERIOD;
	}

	public HtmlOutputLabel getCOMP_SPF_NO_YRS_PREM_PAID_LABEL() {
		return COMP_SPF_NO_YRS_PREM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_SPF_NO_YRS_PREM_PAID() {
		return COMP_SPF_NO_YRS_PREM_PAID;
	}

	public void setCOMP_SPF_NO_YRS_PREM_PAID_LABEL(
			HtmlOutputLabel COMP_SPF_NO_YRS_PREM_PAID_LABEL) {
		this.COMP_SPF_NO_YRS_PREM_PAID_LABEL = COMP_SPF_NO_YRS_PREM_PAID_LABEL;
	}

	public void setCOMP_SPF_NO_YRS_PREM_PAID(
			HtmlInputText COMP_SPF_NO_YRS_PREM_PAID) {
		this.COMP_SPF_NO_YRS_PREM_PAID = COMP_SPF_NO_YRS_PREM_PAID;
	}

	public HtmlOutputLabel getCOMP_SPF_UPTO_DAYS_LABEL() {
		return COMP_SPF_UPTO_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_SPF_UPTO_DAYS() {
		return COMP_SPF_UPTO_DAYS;
	}

	public void setCOMP_SPF_UPTO_DAYS_LABEL(
			HtmlOutputLabel COMP_SPF_UPTO_DAYS_LABEL) {
		this.COMP_SPF_UPTO_DAYS_LABEL = COMP_SPF_UPTO_DAYS_LABEL;
	}

	public void setCOMP_SPF_UPTO_DAYS(HtmlInputText COMP_SPF_UPTO_DAYS) {
		this.COMP_SPF_UPTO_DAYS = COMP_SPF_UPTO_DAYS;
	}

	public HtmlOutputLabel getCOMP_SPF_POL_SURR_FACTOR_LABEL() {
		return COMP_SPF_POL_SURR_FACTOR_LABEL;
	}

	public HtmlInputText getCOMP_SPF_POL_SURR_FACTOR() {
		return COMP_SPF_POL_SURR_FACTOR;
	}

	public void setCOMP_SPF_POL_SURR_FACTOR_LABEL(
			HtmlOutputLabel COMP_SPF_POL_SURR_FACTOR_LABEL) {
		this.COMP_SPF_POL_SURR_FACTOR_LABEL = COMP_SPF_POL_SURR_FACTOR_LABEL;
	}

	public void setCOMP_SPF_POL_SURR_FACTOR(
			HtmlInputText COMP_SPF_POL_SURR_FACTOR) {
		this.COMP_SPF_POL_SURR_FACTOR = COMP_SPF_POL_SURR_FACTOR;
	}

	public HtmlOutputLabel getCOMP_SPF_PRO_SURR_FACTOR_LABEL() {
		return COMP_SPF_PRO_SURR_FACTOR_LABEL;
	}

	public HtmlInputText getCOMP_SPF_PRO_SURR_FACTOR() {
		return COMP_SPF_PRO_SURR_FACTOR;
	}

	public void setCOMP_SPF_PRO_SURR_FACTOR_LABEL(
			HtmlOutputLabel COMP_SPF_PRO_SURR_FACTOR_LABEL) {
		this.COMP_SPF_PRO_SURR_FACTOR_LABEL = COMP_SPF_PRO_SURR_FACTOR_LABEL;
	}

	public void setCOMP_SPF_PRO_SURR_FACTOR(
			HtmlInputText COMP_SPF_PRO_SURR_FACTOR) {
		this.COMP_SPF_PRO_SURR_FACTOR = COMP_SPF_PRO_SURR_FACTOR;
	}

	public HtmlOutputLabel getCOMP_SPF_POL_PAIDUP_FACTOR_LABEL() {
		return COMP_SPF_POL_PAIDUP_FACTOR_LABEL;
	}

	public HtmlInputText getCOMP_SPF_POL_PAIDUP_FACTOR() {
		return COMP_SPF_POL_PAIDUP_FACTOR;
	}

	public void setCOMP_SPF_POL_PAIDUP_FACTOR_LABEL(
			HtmlOutputLabel COMP_SPF_POL_PAIDUP_FACTOR_LABEL) {
		this.COMP_SPF_POL_PAIDUP_FACTOR_LABEL = COMP_SPF_POL_PAIDUP_FACTOR_LABEL;
	}

	public void setCOMP_SPF_POL_PAIDUP_FACTOR(
			HtmlInputText COMP_SPF_POL_PAIDUP_FACTOR) {
		this.COMP_SPF_POL_PAIDUP_FACTOR = COMP_SPF_POL_PAIDUP_FACTOR;
	}

	public HtmlOutputLabel getCOMP_SPF_PRO_PAIDUP_FACTOR_LABEL() {
		return COMP_SPF_PRO_PAIDUP_FACTOR_LABEL;
	}

	public HtmlInputText getCOMP_SPF_PRO_PAIDUP_FACTOR() {
		return COMP_SPF_PRO_PAIDUP_FACTOR;
	}

	public void setCOMP_SPF_PRO_PAIDUP_FACTOR_LABEL(
			HtmlOutputLabel COMP_SPF_PRO_PAIDUP_FACTOR_LABEL) {
		this.COMP_SPF_PRO_PAIDUP_FACTOR_LABEL = COMP_SPF_PRO_PAIDUP_FACTOR_LABEL;
	}

	public void setCOMP_SPF_PRO_PAIDUP_FACTOR(
			HtmlInputText COMP_SPF_PRO_PAIDUP_FACTOR) {
		this.COMP_SPF_PRO_PAIDUP_FACTOR = COMP_SPF_PRO_PAIDUP_FACTOR;
	}

	public HtmlOutputLabel getCOMP_SPF_RATE_PER_LABEL() {
		return COMP_SPF_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_SPF_RATE_PER() {
		return COMP_SPF_RATE_PER;
	}

	public void setCOMP_SPF_RATE_PER_LABEL(
			HtmlOutputLabel COMP_SPF_RATE_PER_LABEL) {
		this.COMP_SPF_RATE_PER_LABEL = COMP_SPF_RATE_PER_LABEL;
	}

	public void setCOMP_SPF_RATE_PER(HtmlInputText COMP_SPF_RATE_PER) {
		this.COMP_SPF_RATE_PER = COMP_SPF_RATE_PER;
	}

	public PM_IL_SURR_PAID_FACTOR getPM_IL_SURR_PAID_FACTOR_BEAN() {
		return PM_IL_SURR_PAID_FACTOR_BEAN;
	}

	public void setPM_IL_SURR_PAID_FACTOR_BEAN(
			PM_IL_SURR_PAID_FACTOR PM_IL_SURR_PAID_FACTOR_BEAN) {
		this.PM_IL_SURR_PAID_FACTOR_BEAN = PM_IL_SURR_PAID_FACTOR_BEAN;
	}

	public void validateSPF_FRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
    			PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_FRZ_FLAG(CommonUtils.booleanToStriingConvertor((Boolean) value));
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<PM_IL_SURR_PAID_FACTOR> getDataList_PM_IL_SURR_PAID_FACTOR() {
		return dataList_PM_IL_SURR_PAID_FACTOR;
	}

	public void setDataListPM_IL_SURR_PAID_FACTOR(
			List<PM_IL_SURR_PAID_FACTOR> dataList_PM_IL_SURR_PAID_FACTOR) {
		this.dataList_PM_IL_SURR_PAID_FACTOR = dataList_PM_IL_SURR_PAID_FACTOR;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				
				PM_IL_SURR_PAID_FACTOR_BEAN = new PM_IL_SURR_PAID_FACTOR();
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

				new CRUDHandler().executeDelete(PM_IL_SURR_PAID_FACTOR_BEAN,
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
				dataList_PM_IL_SURR_PAID_FACTOR
						.remove(PM_IL_SURR_PAID_FACTOR_BEAN);
				if (dataList_PM_IL_SURR_PAID_FACTOR.size() > 0) {

					PM_IL_SURR_PAID_FACTOR_BEAN = dataList_PM_IL_SURR_PAID_FACTOR
							.get(0);
				} else if (dataList_PM_IL_SURR_PAID_FACTOR.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_SURR_PAID_FACTOR_BEAN.setRowSelected(true);
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
			if (PM_IL_SURR_PAID_FACTOR_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(PM_IL_SURR_PAID_FACTOR_BEAN, compositeAction);
				new CRUDHandler().executeInsert(PM_IL_SURR_PAID_FACTOR_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_PM_IL_SURR_PAID_FACTOR
						.add(PM_IL_SURR_PAID_FACTOR_BEAN);
			} else if (PM_IL_SURR_PAID_FACTOR_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PM_IL_SURR_PAID_FACTOR_BEAN, compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_SURR_PAID_FACTOR_BEAN,
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

			PM_IL_SURR_PAID_FACTOR_BEAN.setRowSelected(true);
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
			PM_IL_SURR_PAID_FACTOR_BEAN = (PM_IL_SURR_PAID_FACTOR) dataTable
					.getRowData();
			PM_IL_SURR_PAID_FACTOR_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_SURR_PAID_FACTOR> PM_IL_SURR_PAID_FACTOR_ITR = dataList_PM_IL_SURR_PAID_FACTOR
				.iterator();
		while (PM_IL_SURR_PAID_FACTOR_ITR.hasNext()) {
			PM_IL_SURR_PAID_FACTOR_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_SPF_FRZ_FLAG.resetValue();
		COMP_SPF_PERIOD.resetValue();
		COMP_SPF_NO_YRS_PREM_PAID.resetValue();
		COMP_SPF_UPTO_DAYS.resetValue();
		COMP_SPF_POL_SURR_FACTOR.resetValue();
		COMP_SPF_PRO_SURR_FACTOR.resetValue();
		COMP_SPF_POL_PAIDUP_FACTOR.resetValue();
		COMP_SPF_PRO_PAIDUP_FACTOR.resetValue();
		COMP_SPF_RATE_PER.resetValue();
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
				if(PM_IL_SURR_PAID_FACTOR_BEAN.getROWID() != null){
					helper.preQuery(PM_IL_SURR_PAID_FACTOR_BEAN, compositeAction);
					helper.postBlock(PM_IL_SURR_PAID_FACTOR_BEAN, compositeAction);
				}
				else{
					helper.whenNewBlockInstance(PM_IL_SURR_PAID_FACTOR_BEAN , compositeAction);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	// TODO wait for Manoj Bhai
	  public ArrayList<LovBean> lovSPF_PLAN_CODE(
			    Object object) {
		  ArrayList<LovBean> lovList = new ArrayList<LovBean>();
			String query = "SELECT PLAN_CODE,PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_FRZ_FLAG = 'N' "
					+ "AND (PLAN_CODE LIKE ? OR PLAN_TYPE LIKE ?) AND ROWNUM < ?";
			Object[] values = null;
			String currentValue = (String) object;

			try {
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

				values = new Object[] { currentValue, currentValue,
						PELConstants.suggetionRecordSize };
				lovList = ListItemUtil.prepareSuggestionList(query, values);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return lovList;
	  }
	  
	
	public void validateSPF_PERIOD(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer SPF_PERIOD = (Integer)value;
			PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_PERIOD(SPF_PERIOD);
			helper.whenValidate_SPF_PERIOD(SPF_PERIOD, compositeAction);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateSPF_NO_YRS_PREM_PAID(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer SPF_NO_YRS_PREM_PAID = (Integer)value;
			PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_NO_YRS_PREM_PAID(SPF_NO_YRS_PREM_PAID);
			helper.whenValidate_SPF_NO_YRS_PREM_PAID(compositeAction, SPF_NO_YRS_PREM_PAID);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validateSPF_UPTO_DAYS(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer SPF_UPTO_DAYS = (Integer)value;
			PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_UPTO_DAYS(SPF_UPTO_DAYS);
			helper.whenValidate_SPF_UPTO_DAYS(SPF_UPTO_DAYS);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateSPF_RATE_PER(FacesContext context,
			UIComponent component, Object value){
		try{
			Double SPF_RATE_PER = (Double)value;
			PM_IL_SURR_PAID_FACTOR_BEAN.setSPF_RATE_PER(SPF_RATE_PER);
			helper.whenValidate_SPF_RATE_PER(SPF_RATE_PER);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}
