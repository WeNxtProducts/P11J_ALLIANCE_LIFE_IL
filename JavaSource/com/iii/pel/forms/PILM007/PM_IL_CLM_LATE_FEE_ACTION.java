package com.iii.pel.forms.PILM007;

import java.sql.Connection;
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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY_HELPER;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_CLM_LATE_FEE_ACTION extends
		com.iii.premia.common.action.CommonAction {

	private HtmlOutputLabel COMP_CLF_NO_FM_DAYS_LABEL;

	private HtmlInputText COMP_CLF_NO_FM_DAYS;

	private HtmlOutputLabel COMP_CLF_NO_TO_DAYS_LABEL;

	private HtmlInputText COMP_CLF_NO_TO_DAYS;

	private HtmlOutputLabel COMP_CLF_RATE_LABEL;

	private HtmlInputText COMP_CLF_RATE;

	private HtmlOutputLabel COMP_CLF_RATE_PER_LABEL;

	private HtmlInputText COMP_CLF_RATE_PER;

	private HtmlOutputLabel COMP_CLF_MIN_LC_AMT_LABEL;

	private HtmlInputText COMP_CLF_MIN_LC_AMT;

	private HtmlOutputLabel COMP_CLF_MAX_LC_AMT_LABEL;

	private HtmlInputText COMP_CLF_MAX_LC_AMT;

	private HtmlOutputLabel COMP_CLF_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_CLF_EFF_FM_DT;

	private HtmlOutputLabel COMP_CLF_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_CLF_EFF_TO_DT;

	private HtmlCommandButton COMP_PUSH_BUTTON162;

	private PM_IL_CLM_LATE_FEE PM_IL_CLM_LATE_FEE_BEAN;

	public PILM007_COMPOSITE_ACTION compositeAction;

	private PM_IL_CLM_LATE_FEE_HELPER helper;

	private List<PM_IL_CLM_LATE_FEE> dataList_PM_IL_CLM_LATE_FEE = new ArrayList<PM_IL_CLM_LATE_FEE>();

	private UIData dataTable;
	
	public PM_IL_CLM_LATE_FEE_ACTION() {

		PM_IL_CLM_LATE_FEE_BEAN = new PM_IL_CLM_LATE_FEE();
		helper = new PM_IL_CLM_LATE_FEE_HELPER();
		/*Added by Saritha on 30-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
		instantiateAllComponent();
		setListItemValues();
		/*End*/
		
	}

	public HtmlOutputLabel getCOMP_CLF_NO_FM_DAYS_LABEL() {
		return COMP_CLF_NO_FM_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_CLF_NO_FM_DAYS() {
		return COMP_CLF_NO_FM_DAYS;
	}

	public void setCOMP_CLF_NO_FM_DAYS_LABEL(
			HtmlOutputLabel COMP_CLF_NO_FM_DAYS_LABEL) {
		this.COMP_CLF_NO_FM_DAYS_LABEL = COMP_CLF_NO_FM_DAYS_LABEL;
	}

	public void setCOMP_CLF_NO_FM_DAYS(HtmlInputText COMP_CLF_NO_FM_DAYS) {
		this.COMP_CLF_NO_FM_DAYS = COMP_CLF_NO_FM_DAYS;
	}

	public HtmlOutputLabel getCOMP_CLF_NO_TO_DAYS_LABEL() {
		return COMP_CLF_NO_TO_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_CLF_NO_TO_DAYS() {
		return COMP_CLF_NO_TO_DAYS;
	}

	public void setCOMP_CLF_NO_TO_DAYS_LABEL(
			HtmlOutputLabel COMP_CLF_NO_TO_DAYS_LABEL) {
		this.COMP_CLF_NO_TO_DAYS_LABEL = COMP_CLF_NO_TO_DAYS_LABEL;
	}

	public void setCOMP_CLF_NO_TO_DAYS(HtmlInputText COMP_CLF_NO_TO_DAYS) {
		this.COMP_CLF_NO_TO_DAYS = COMP_CLF_NO_TO_DAYS;
	}

	public HtmlOutputLabel getCOMP_CLF_RATE_LABEL() {
		return COMP_CLF_RATE_LABEL;
	}

	public HtmlInputText getCOMP_CLF_RATE() {
		return COMP_CLF_RATE;
	}

	public void setCOMP_CLF_RATE_LABEL(HtmlOutputLabel COMP_CLF_RATE_LABEL) {
		this.COMP_CLF_RATE_LABEL = COMP_CLF_RATE_LABEL;
	}

	public void setCOMP_CLF_RATE(HtmlInputText COMP_CLF_RATE) {
		this.COMP_CLF_RATE = COMP_CLF_RATE;
	}

	public HtmlOutputLabel getCOMP_CLF_RATE_PER_LABEL() {
		return COMP_CLF_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_CLF_RATE_PER() {
		return COMP_CLF_RATE_PER;
	}

	public void setCOMP_CLF_RATE_PER_LABEL(
			HtmlOutputLabel COMP_CLF_RATE_PER_LABEL) {
		this.COMP_CLF_RATE_PER_LABEL = COMP_CLF_RATE_PER_LABEL;
	}

	public void setCOMP_CLF_RATE_PER(HtmlInputText COMP_CLF_RATE_PER) {
		this.COMP_CLF_RATE_PER = COMP_CLF_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_CLF_MIN_LC_AMT_LABEL() {
		return COMP_CLF_MIN_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CLF_MIN_LC_AMT() {
		return COMP_CLF_MIN_LC_AMT;
	}

	public void setCOMP_CLF_MIN_LC_AMT_LABEL(
			HtmlOutputLabel COMP_CLF_MIN_LC_AMT_LABEL) {
		this.COMP_CLF_MIN_LC_AMT_LABEL = COMP_CLF_MIN_LC_AMT_LABEL;
	}

	public void setCOMP_CLF_MIN_LC_AMT(HtmlInputText COMP_CLF_MIN_LC_AMT) {
		this.COMP_CLF_MIN_LC_AMT = COMP_CLF_MIN_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_CLF_MAX_LC_AMT_LABEL() {
		return COMP_CLF_MAX_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CLF_MAX_LC_AMT() {
		return COMP_CLF_MAX_LC_AMT;
	}

	public void setCOMP_CLF_MAX_LC_AMT_LABEL(
			HtmlOutputLabel COMP_CLF_MAX_LC_AMT_LABEL) {
		this.COMP_CLF_MAX_LC_AMT_LABEL = COMP_CLF_MAX_LC_AMT_LABEL;
	}

	public void setCOMP_CLF_MAX_LC_AMT(HtmlInputText COMP_CLF_MAX_LC_AMT) {
		this.COMP_CLF_MAX_LC_AMT = COMP_CLF_MAX_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_CLF_EFF_FM_DT_LABEL() {
		return COMP_CLF_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CLF_EFF_FM_DT() {
		return COMP_CLF_EFF_FM_DT;
	}

	public void setCOMP_CLF_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_CLF_EFF_FM_DT_LABEL) {
		this.COMP_CLF_EFF_FM_DT_LABEL = COMP_CLF_EFF_FM_DT_LABEL;
	}

	public void setCOMP_CLF_EFF_FM_DT(HtmlCalendar COMP_CLF_EFF_FM_DT) {
		this.COMP_CLF_EFF_FM_DT = COMP_CLF_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_CLF_EFF_TO_DT_LABEL() {
		return COMP_CLF_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CLF_EFF_TO_DT() {
		return COMP_CLF_EFF_TO_DT;
	}

	public void setCOMP_CLF_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_CLF_EFF_TO_DT_LABEL) {
		this.COMP_CLF_EFF_TO_DT_LABEL = COMP_CLF_EFF_TO_DT_LABEL;
	}

	public void setCOMP_CLF_EFF_TO_DT(HtmlCalendar COMP_CLF_EFF_TO_DT) {
		this.COMP_CLF_EFF_TO_DT = COMP_CLF_EFF_TO_DT;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON162() {
		return COMP_PUSH_BUTTON162;
	}

	public void setCOMP_PUSH_BUTTON162(HtmlCommandButton COMP_PUSH_BUTTON162) {
		this.COMP_PUSH_BUTTON162 = COMP_PUSH_BUTTON162;
	}

	public PM_IL_CLM_LATE_FEE getPM_IL_CLM_LATE_FEE_BEAN() {
		return PM_IL_CLM_LATE_FEE_BEAN;
	}

	public void setPM_IL_CLM_LATE_FEE_BEAN(
			PM_IL_CLM_LATE_FEE PM_IL_CLM_LATE_FEE_BEAN) {
		this.PM_IL_CLM_LATE_FEE_BEAN = PM_IL_CLM_LATE_FEE_BEAN;
	}

	public List<PM_IL_CLM_LATE_FEE> getDataList_PM_IL_CLM_LATE_FEE() {
		return dataList_PM_IL_CLM_LATE_FEE;
	}

	public void setDataListPM_IL_CLM_LATE_FEE(
			List<PM_IL_CLM_LATE_FEE> dataList_PM_IL_CLM_LATE_FEE) {
		this.dataList_PM_IL_CLM_LATE_FEE = dataList_PM_IL_CLM_LATE_FEE;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_CLM_LATE_FEE_BEAN = new PM_IL_CLM_LATE_FEE();
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

				new CRUDHandler().executeDelete(PM_IL_CLM_LATE_FEE_BEAN,
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
				dataList_PM_IL_CLM_LATE_FEE.remove(PM_IL_CLM_LATE_FEE_BEAN);
				if (dataList_PM_IL_CLM_LATE_FEE.size() > 0) {

					PM_IL_CLM_LATE_FEE_BEAN = dataList_PM_IL_CLM_LATE_FEE
							.get(0);
				} else if (dataList_PM_IL_CLM_LATE_FEE.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_CLM_LATE_FEE_BEAN.setRowSelected(true);
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
			if (PM_IL_CLM_LATE_FEE_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_CLM_LATE_FEE_BEAN,
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
				dataList_PM_IL_CLM_LATE_FEE.add(PM_IL_CLM_LATE_FEE_BEAN);
			} else if (PM_IL_CLM_LATE_FEE_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_CLM_LATE_FEE_BEAN,
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

			PM_IL_CLM_LATE_FEE_BEAN.setRowSelected(true);
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
			PM_IL_CLM_LATE_FEE_BEAN = (PM_IL_CLM_LATE_FEE) dataTable
					.getRowData();
			PM_IL_CLM_LATE_FEE_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_CLM_LATE_FEE> PM_IL_CLM_LATE_FEE_ITR = dataList_PM_IL_CLM_LATE_FEE
				.iterator();
		while (PM_IL_CLM_LATE_FEE_ITR.hasNext()) {
			PM_IL_CLM_LATE_FEE_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_CLF_NO_FM_DAYS.resetValue();
		COMP_CLF_NO_TO_DAYS.resetValue();
		COMP_CLF_RATE.resetValue();
		COMP_CLF_RATE_PER.resetValue();
		COMP_CLF_MIN_LC_AMT.resetValue();
		COMP_CLF_MAX_LC_AMT.resetValue();
		COMP_CLF_EFF_FM_DT.resetValue();
		COMP_CLF_EFF_TO_DT.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		String message ="";
		try {
			CommonUtils.getConnection().commit();
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void CLF_NO_FM_DAYS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CLF_NO_FM_DAYS_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_LATE_FEE_BEAN().setCLF_NO_FM_DAYS((Integer) value);
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

	public void CLF_NO_TO_DAYS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CLF_NO_TO_DAYS_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_LATE_FEE_BEAN().setCLF_NO_TO_DAYS((Integer) value);
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

	public void CLF_MIN_LC_AMT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CLF_MIN_LC_AMT_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_LATE_FEE_BEAN().setCLF_MIN_LC_AMT((Double) value);
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

	public void CLF_MAX_LC_AMT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CLF_MAX_LC_AMT_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_LATE_FEE_BEAN().setCLF_MAX_LC_AMT((Double) value);
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

	public void CLF_EFF_FM_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CLF_EFF_FM_DT_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_LATE_FEE_BEAN().setCLF_EFF_FM_DT((Date) value);
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

	public void CLF_EFF_TO_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CLF_EFF_TO_DT_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_LATE_FEE_BEAN().setCLF_EFF_TO_DT((Date) value);
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

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.PRE_BLOCK(compositeAction);
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public String callPM_IL_CLM_REPAY() {
		setBlockFlag(true);
		return "PILM007_PM_IL_CLM_REPAY";

	}
	
	
	/*Added by Saritha on 30-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
	
	private HtmlOutputLabel COMP_INT_DELAY_CLAIM_LABEL;
	public HtmlOutputLabel getCOMP_INT_DELAY_CLAIM_LABEL() {
		return COMP_INT_DELAY_CLAIM_LABEL;
	}

	public void setCOMP_INT_DELAY_CLAIM_LABEL(
			HtmlOutputLabel cOMP_INT_DELAY_CLAIM_LABEL) {
		COMP_INT_DELAY_CLAIM_LABEL = cOMP_INT_DELAY_CLAIM_LABEL;
	}

	private HtmlSelectOneMenu COMP_INT_DELAY_CLAIM;

	public HtmlSelectOneMenu getCOMP_INT_DELAY_CLAIM() {
		return COMP_INT_DELAY_CLAIM;
	}

	public void setCOMP_INT_DELAY_CLAIM(HtmlSelectOneMenu cOMP_INT_DELAY_CLAIM) {
		COMP_INT_DELAY_CLAIM = cOMP_INT_DELAY_CLAIM;
	}
	
	private List<SelectItem> listCLF_INT_TYPE = new ArrayList<SelectItem>();
	
	public List<SelectItem> getListCLF_INT_TYPE() {
		return listCLF_INT_TYPE;
	}

	public void setListCLF_INT_TYPE(List<SelectItem> listCLF_INT_TYPE) {
		this.listCLF_INT_TYPE = listCLF_INT_TYPE;
	}

	public void setListItemValues() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			
			setListCLF_INT_TYPE (ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM007", "PM_IL_CLM_LATE_FEE",
					"PM_IL_CLM_LATE_FEE.CLF_INT_TYPE", "IL_CLM_INT"));

		}
			
		catch (Exception e) {
			e.printStackTrace();

		}

		}
	
	public void instantiateAllComponent() {

		COMP_INT_DELAY_CLAIM_LABEL=new HtmlOutputLabel();
		COMP_INT_DELAY_CLAIM=new HtmlSelectOneMenu();

	}

	public void disableAllComponentOld(boolean disabled) {
		COMP_INT_DELAY_CLAIM.setDisabled(disabled);
	}
	
	public void validate_INT_DELAY_CLAIM(FacesContext context,
			UIComponent component, Object value)  {
		String CLF_INT_TYPE = (String) value;
		try {
			getPM_IL_CLM_LATE_FEE_BEAN().setCLF_INT_TYPE(CLF_INT_TYPE);
			System.out.println("Interrest type:::::::::::::::::::::"+PM_IL_CLM_LATE_FEE_BEAN.getCLF_INT_TYPE());
			COMP_INT_DELAY_CLAIM.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
		
	/*End*/
			
}
