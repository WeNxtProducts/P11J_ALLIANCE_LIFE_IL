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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM003_APAC.PILM003_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_SURRENDER_ACTION extends CommonAction {
	
	private HtmlOutputLabel COMP_PSD_TERM_FM_LABEL;

	private HtmlInputText COMP_PSD_TERM_FM;
	
	private HtmlOutputLabel COMP_PSD_TERM_TO_LABEL;

	private HtmlInputText COMP_PSD_TERM_TO;
	
	private HtmlOutputLabel COMP_PSD_SURR_YRS_LABEL;

	private HtmlInputText COMP_PSD_SURR_YRS;
	
	private HtmlOutputLabel COMP_PSD_PROD_CODE_LABEL;

	private HtmlInputText COMP_PSD_PROD_CODE;
	
	private List<PM_IL_PROD_APPL_SURRENDER> dataList_PM_IL_PROD_SURRENDER = new ArrayList<PM_IL_PROD_APPL_SURRENDER>();

	private UIData dataTable;
	
	public HtmlOutputLabel getCOMP_PSD_PROD_CODE_LABEL() {
		return COMP_PSD_PROD_CODE_LABEL;
	}

	public void setCOMP_PSD_PROD_CODE_LABEL(HtmlOutputLabel cOMP_PSD_PROD_CODE_LABEL) {
		COMP_PSD_PROD_CODE_LABEL = cOMP_PSD_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PSD_PROD_CODE() {
		return COMP_PSD_PROD_CODE;
	}

	public void setCOMP_PSD_PROD_CODE(HtmlInputText cOMP_PSD_PROD_CODE) {
		COMP_PSD_PROD_CODE = cOMP_PSD_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_PSD_SURR_YRS_LABEL() {
		return COMP_PSD_SURR_YRS_LABEL;
	}

	public void setCOMP_PSD_SURR_YRS_LABEL(HtmlOutputLabel cOMP_PSD_SURR_YRS_LABEL) {
		COMP_PSD_SURR_YRS_LABEL = cOMP_PSD_SURR_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PSD_SURR_YRS() {
		return COMP_PSD_SURR_YRS;
	}

	public void setCOMP_PSD_SURR_YRS(HtmlInputText cOMP_PSD_SURR_YRS) {
		COMP_PSD_SURR_YRS = cOMP_PSD_SURR_YRS;
	}

	public HtmlOutputLabel getCOMP_PSD_TERM_FM_LABEL() {
		return COMP_PSD_TERM_FM_LABEL;
	}

	public void setCOMP_PSD_TERM_FM_LABEL(HtmlOutputLabel cOMP_PSD_TERM_FM_LABEL) {
		COMP_PSD_TERM_FM_LABEL = cOMP_PSD_TERM_FM_LABEL;
	}

	public HtmlInputText getCOMP_PSD_TERM_FM() {
		return COMP_PSD_TERM_FM;
	}

	public void setCOMP_PSD_TERM_FM(HtmlInputText cOMP_PSD_TERM_FM) {
		COMP_PSD_TERM_FM = cOMP_PSD_TERM_FM;
	}

	public HtmlOutputLabel getCOMP_PSD_TERM_TO_LABEL() {
		return COMP_PSD_TERM_TO_LABEL;
	}

	public void setCOMP_PSD_TERM_TO_LABEL(HtmlOutputLabel cOMP_PSD_TERM_TO_LABEL) {
		COMP_PSD_TERM_TO_LABEL = cOMP_PSD_TERM_TO_LABEL;
	}

	public HtmlInputText getCOMP_PSD_TERM_TO() {
		return COMP_PSD_TERM_TO;
	}

	public void setCOMP_PSD_TERM_TO(HtmlInputText cOMP_PSD_TERM_TO) {
		COMP_PSD_TERM_TO = cOMP_PSD_TERM_TO;
	}
	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_APPL_SURRENDER_ACTION PM_IL_PROD_APPL_SURRENDER_ACTION_BEAN;
	
	private PM_IL_PROD_APPL_SURRENDER PM_IL_PROD_APPL_SURRENDER_BEAN;
	
	private PM_IL_PROD_APPL_SURRENDER_HELPER helper;
	
	public PM_IL_PROD_APPL_SURRENDER_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_PROD_APPL_SURRENDER_HELPER helper) {
		this.helper = helper;
	}

	public PILM035_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PM_IL_PROD_APPL_SURRENDER getPM_IL_PROD_APPL_SURRENDER_BEAN() {
		return PM_IL_PROD_APPL_SURRENDER_BEAN;
	}

	public void setPM_IL_PROD_APPL_SURRENDER_BEAN(
			PM_IL_PROD_APPL_SURRENDER pM_IL_PROD_APPL_SURRENDER_BEAN) {
		PM_IL_PROD_APPL_SURRENDER_BEAN = pM_IL_PROD_APPL_SURRENDER_BEAN;
	}


	public PM_IL_PROD_APPL_SURRENDER_ACTION getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN() {
		return PM_IL_PROD_APPL_SURRENDER_ACTION_BEAN;
	}

	public void setPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN(
			PM_IL_PROD_APPL_SURRENDER_ACTION pM_IL_PROD_APPL_SURRENDER_ACTION_BEAN) {
		PM_IL_PROD_APPL_SURRENDER_ACTION_BEAN = pM_IL_PROD_APPL_SURRENDER_ACTION_BEAN;
	}
	PM_IL_PROD_APPL_SURRENDER_ACTION(){
		
		PM_IL_PROD_APPL_SURRENDER_BEAN=new PM_IL_PROD_APPL_SURRENDER();
		helper =new PM_IL_PROD_APPL_SURRENDER_HELPER();
		//compositeAction=new PILM035_APAC_COMPOSITE_ACTION();
	}
	public void onLoad(PhaseEvent event) {
		try {
			if (PM_IL_PROD_APPL_SURRENDER_BEAN.getROWID() == null)
			{
			PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());
			}
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
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public List<PM_IL_PROD_APPL_SURRENDER> getDataList_PM_IL_PROD_SURRENDER() {
		return dataList_PM_IL_PROD_SURRENDER;
	}

	public void setDataList_PM_IL_PROD_SURRENDER(
			List<PM_IL_PROD_APPL_SURRENDER> dataList_PM_IL_PROD_SURRENDER) {
		this.dataList_PM_IL_PROD_SURRENDER = dataList_PM_IL_PROD_SURRENDER;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
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
	public void addRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (isINSERT_ALLOWED()) {
				//helper.WHEN_CREATE_RECORD(compositeAction);
				PM_IL_PROD_APPL_SURRENDER_BEAN=new PM_IL_PROD_APPL_SURRENDER();
				PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());

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
	
	public void postRecord(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (PM_IL_PROD_APPL_SURRENDER_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_APPL_SURRENDER_BEAN,
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
				dataList_PM_IL_PROD_SURRENDER.add(PM_IL_PROD_APPL_SURRENDER_BEAN);
			} else if (PM_IL_PROD_APPL_SURRENDER_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_APPL_SURRENDER_BEAN,
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

			PM_IL_PROD_APPL_SURRENDER_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			/*getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());*/
					
					
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					 exc.getMessage());
			getErrorMap().put("postRecord",
					 exc.getMessage());
		
					
					
		}

	}
	public void deleteRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_PROD_APPL_SURRENDER_BEAN,
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
				dataList_PM_IL_PROD_SURRENDER
						.remove(PM_IL_PROD_APPL_SURRENDER_BEAN);
				if (dataList_PM_IL_PROD_SURRENDER.size() > 0) {

					PM_IL_PROD_APPL_SURRENDER_BEAN = dataList_PM_IL_PROD_SURRENDER
							.get(0);
				} else if (dataList_PM_IL_PROD_SURRENDER.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_APPL_SURRENDER_BEAN.setRowSelected(true);
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
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PROD_APPL_SURRENDER_BEAN = (PM_IL_PROD_APPL_SURRENDER) dataTable
					.getRowData();
			PM_IL_PROD_APPL_SURRENDER_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetAllComponent() {
		COMP_PSD_TERM_FM.resetValue();
		COMP_PSD_TERM_TO.resetValue();
		COMP_PSD_SURR_YRS.resetValue();
		COMP_PSD_PROD_CODE.resetValue();
	}
	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_APPL_SURRENDER> PM_IL_PROD_APPL_SURRENDER = dataList_PM_IL_PROD_SURRENDER.iterator();
		while (PM_IL_PROD_APPL_SURRENDER.hasNext()) {
			PM_IL_PROD_APPL_SURRENDER.next().setRowSelected(false);
		}
	}
	public void PSD_TERM_FM_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PSD_TERM_FM(compositeAction, value);
			getPM_IL_PROD_APPL_SURRENDER_BEAN().setPSD_TERM_FM((Integer) value);
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
	public void PSD_TERM_TO_Validator(FacesContext facesContext,
			UIComponent component, Object value) {
		try {
			helper.WHEN_VALIDATE_ITEM_PSD_TERM_TO(compositeAction, value);
			getPM_IL_PROD_APPL_SURRENDER_BEAN().setPSD_TERM_FM((Integer) value);
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
