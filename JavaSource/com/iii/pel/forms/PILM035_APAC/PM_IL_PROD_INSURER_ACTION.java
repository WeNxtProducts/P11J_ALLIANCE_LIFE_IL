/**
 * 
 */
package com.iii.pel.forms.PILM035_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55368
 *
 */
public class PM_IL_PROD_INSURER_ACTION extends CommonAction{
	public PILM035_APAC_COMPOSITE_ACTION compositeAction;
	
	public List<PM_IL_PROD_INSURER> dataList_PM_IL_PROD_Insurer = new ArrayList<PM_IL_PROD_INSURER>();
	
	private HtmlOutputLabel COMP_PROD_INS_AGE_FM_LABEL;
	
	private HtmlOutputLabel COMP_PROD_INS_AGE_TO_LABEL;
	
	private HtmlOutputLabel COMP_PROD_INS_SA_FM_LABEL;
	
	private HtmlOutputLabel COMP_PROD_INS_SA_TO_LABEL;
	
	private HtmlOutputLabel COMP_PROD_INS_TM_FM_LABEL;
	
	private HtmlOutputLabel COMP_PROD_INS_TM_TO_LABEL;
	
	private HtmlInputText COMP_PROD_INS_AGE_FM;
	
	private HtmlInputText COMP_PROD_INS_AGE_TO;
	
	private HtmlInputText COMP_PROD_INS_SA_FM;
	
	private HtmlInputText COMP_PROD_INS_SA_TO;
	
	private HtmlInputText COMP_PROD_INS_TM_FM;
	
	private HtmlInputText COMP_PROD_INS_TM_TO;

	private UIData dataTable;
	
	private PM_IL_INSURER_HELPER helper;
	
	private PM_IL_PROD_INSURER PM_IL_PROD_INSURER;
	
	public PM_IL_PROD_INSURER_ACTION(){
		helper = new PM_IL_INSURER_HELPER();
		PM_IL_PROD_INSURER = new PM_IL_PROD_INSURER();
	}
	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the compositeAction
	 */
	public PILM035_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the cOMP_PROD_INS_AGE_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_AGE_FM_LABEL() {
		return COMP_PROD_INS_AGE_FM_LABEL;
	}

	/**
	 * @param comp_prod_ins_age_fm_label the cOMP_PROD_INS_AGE_FM_LABEL to set
	 */
	public void setCOMP_PROD_INS_AGE_FM_LABEL(
			HtmlOutputLabel comp_prod_ins_age_fm_label) {
		COMP_PROD_INS_AGE_FM_LABEL = comp_prod_ins_age_fm_label;
	}

	/**
	 * @return the cOMP_PROD_INS_AGE_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_AGE_TO_LABEL() {
		return COMP_PROD_INS_AGE_TO_LABEL;
	}

	/**
	 * @param comp_prod_ins_age_to_label the cOMP_PROD_INS_AGE_TO_LABEL to set
	 */
	public void setCOMP_PROD_INS_AGE_TO_LABEL(
			HtmlOutputLabel comp_prod_ins_age_to_label) {
		COMP_PROD_INS_AGE_TO_LABEL = comp_prod_ins_age_to_label;
	}

	/**
	 * @return the cOMP_PROD_INS_SA_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_SA_FM_LABEL() {
		return COMP_PROD_INS_SA_FM_LABEL;
	}

	/**
	 * @param comp_prod_ins_sa_fm_label the cOMP_PROD_INS_SA_FM_LABEL to set
	 */
	public void setCOMP_PROD_INS_SA_FM_LABEL(
			HtmlOutputLabel comp_prod_ins_sa_fm_label) {
		COMP_PROD_INS_SA_FM_LABEL = comp_prod_ins_sa_fm_label;
	}

	/**
	 * @return the cOMP_PROD_INS_SA_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_SA_TO_LABEL() {
		return COMP_PROD_INS_SA_TO_LABEL;
	}

	/**
	 * @param comp_prod_ins_sa_to_label the cOMP_PROD_INS_SA_TO_LABEL to set
	 */
	public void setCOMP_PROD_INS_SA_TO_LABEL(
			HtmlOutputLabel comp_prod_ins_sa_to_label) {
		COMP_PROD_INS_SA_TO_LABEL = comp_prod_ins_sa_to_label;
	}

	/**
	 * @return the cOMP_PROD_INS_TM_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_TM_FM_LABEL() {
		return COMP_PROD_INS_TM_FM_LABEL;
	}

	/**
	 * @param comp_prod_ins_tm_fm_label the cOMP_PROD_INS_TM_FM_LABEL to set
	 */
	public void setCOMP_PROD_INS_TM_FM_LABEL(
			HtmlOutputLabel comp_prod_ins_tm_fm_label) {
		COMP_PROD_INS_TM_FM_LABEL = comp_prod_ins_tm_fm_label;
	}

	/**
	 * @return the cOMP_PROD_INS_TM_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_PROD_INS_TM_TO_LABEL() {
		return COMP_PROD_INS_TM_TO_LABEL;
	}

	/**
	 * @param comp_prod_ins_tm_to_label the cOMP_PROD_INS_TM_TO_LABEL to set
	 */
	public void setCOMP_PROD_INS_TM_TO_LABEL(
			HtmlOutputLabel comp_prod_ins_tm_to_label) {
		COMP_PROD_INS_TM_TO_LABEL = comp_prod_ins_tm_to_label;
	}

	/**
	 * @return the cOMP_PROD_INS_AGE_FM
	 */
	public HtmlInputText getCOMP_PROD_INS_AGE_FM() {
		return COMP_PROD_INS_AGE_FM;
	}

	/**
	 * @param comp_prod_ins_age_fm the cOMP_PROD_INS_AGE_FM to set
	 */
	public void setCOMP_PROD_INS_AGE_FM(HtmlInputText comp_prod_ins_age_fm) {
		COMP_PROD_INS_AGE_FM = comp_prod_ins_age_fm;
	}

	/**
	 * @return the cOMP_PROD_INS_AGE_TO
	 */
	public HtmlInputText getCOMP_PROD_INS_AGE_TO() {
		return COMP_PROD_INS_AGE_TO;
	}

	/**
	 * @param comp_prod_ins_age_to the cOMP_PROD_INS_AGE_TO to set
	 */
	public void setCOMP_PROD_INS_AGE_TO(HtmlInputText comp_prod_ins_age_to) {
		COMP_PROD_INS_AGE_TO = comp_prod_ins_age_to;
	}

	/**
	 * @return the cOMP_PROD_INS_SA_FM
	 */
	public HtmlInputText getCOMP_PROD_INS_SA_FM() {
		return COMP_PROD_INS_SA_FM;
	}

	/**
	 * @param comp_prod_ins_sa_fm the cOMP_PROD_INS_SA_FM to set
	 */
	public void setCOMP_PROD_INS_SA_FM(HtmlInputText comp_prod_ins_sa_fm) {
		COMP_PROD_INS_SA_FM = comp_prod_ins_sa_fm;
	}

	/**
	 * @return the cOMP_PROD_INS_SA_TO
	 */
	public HtmlInputText getCOMP_PROD_INS_SA_TO() {
		return COMP_PROD_INS_SA_TO;
	}

	/**
	 * @param comp_prod_ins_sa_to the cOMP_PROD_INS_SA_TO to set
	 */
	public void setCOMP_PROD_INS_SA_TO(HtmlInputText comp_prod_ins_sa_to) {
		COMP_PROD_INS_SA_TO = comp_prod_ins_sa_to;
	}

	/**
	 * @return the cOMP_PROD_INS_TM_FM
	 */
	public HtmlInputText getCOMP_PROD_INS_TM_FM() {
		return COMP_PROD_INS_TM_FM;
	}

	/**
	 * @param comp_prod_ins_tm_fm the cOMP_PROD_INS_TM_FM to set
	 */
	public void setCOMP_PROD_INS_TM_FM(HtmlInputText comp_prod_ins_tm_fm) {
		COMP_PROD_INS_TM_FM = comp_prod_ins_tm_fm;
	}

	/**
	 * @return the cOMP_PROD_INS_TM_TO
	 */
	public HtmlInputText getCOMP_PROD_INS_TM_TO() {
		return COMP_PROD_INS_TM_TO;
	}

	/**
	 * @param comp_prod_ins_tm_to the cOMP_PROD_INS_TM_TO to set
	 */
	public void setCOMP_PROD_INS_TM_TO(HtmlInputText comp_prod_ins_tm_to) {
		COMP_PROD_INS_TM_TO = comp_prod_ins_tm_to;
	}
	/**
	 * @return the helper
	 */
	public PM_IL_INSURER_HELPER getHelper() {
		return helper;
	}
	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PM_IL_INSURER_HELPER helper) {
		this.helper = helper;
	}
	/**
	 * @return the pM_IL_PROD_INSURER
	 */
	public PM_IL_PROD_INSURER getPM_IL_PROD_INSURER() {
		return PM_IL_PROD_INSURER;
	}
	/**
	 * @param pm_il_prod_insurer the pM_IL_PROD_INSURER to set
	 */
	public void setPM_IL_PROD_INSURER(PM_IL_PROD_INSURER pm_il_prod_insurer) {
		PM_IL_PROD_INSURER = pm_il_prod_insurer;
	}
	
	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_PROD_INSURER = new PM_IL_PROD_INSURER();
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
				new CRUDHandler().executeDelete(PM_IL_PROD_INSURER,
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
				dataList_PM_IL_PROD_Insurer.remove(PM_IL_PROD_INSURER);
				if (dataList_PM_IL_PROD_Insurer.size() > 0) {

					PM_IL_PROD_INSURER = dataList_PM_IL_PROD_Insurer
							.get(0);
				} else if (dataList_PM_IL_PROD_Insurer.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_INSURER.setRowSelected(true);
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
		getWarningMap().clear();
		try {
			PM_IL_PROD_INSURER.setPT_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());
			PM_IL_PROD_INSURER.setPT_CREATED_DATE(new CommonUtils().getCurrentDate());
			PM_IL_PROD_INSURER.setPT_CREATED_UID(new ControlBean().getM_USER_ID());
			
			if (PM_IL_PROD_INSURER.getROWID() == null
					&& isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PM_IL_PROD_INSURER,
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
				dataList_PM_IL_PROD_Insurer.add(PM_IL_PROD_INSURER);
			} else if (PM_IL_PROD_INSURER.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(PM_IL_PROD_INSURER,
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

			PM_IL_PROD_INSURER.setRowSelected(true);
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
			PM_IL_PROD_INSURER = (PM_IL_PROD_INSURER) dataTable
					.getRowData();
			PM_IL_PROD_INSURER.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_INSURER> PM_IL_PROD_APPL_COND_ITR = dataList_PM_IL_PROD_Insurer
				.iterator();
		while (PM_IL_PROD_APPL_COND_ITR.hasNext()) {
			PM_IL_PROD_APPL_COND_ITR.next().setRowSelected(false);
		}
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
				CommonUtils.clearMaps(this);
				//helper.executeQuery(compositeAction);
				if(getPM_IL_PROD_INSURER().getROWID() != null){
					//helper.POST_QUERY(compositeAction);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	/**
	 * @return the dataList_PM_IL_PROD_Insurer
	 */
	public List<PM_IL_PROD_INSURER> getDataList_PM_IL_PROD_Insurer() {
		return dataList_PM_IL_PROD_Insurer;
	}
	/**
	 * @param dataList_PM_IL_PROD_Insurer the dataList_PM_IL_PROD_Insurer to set
	 */
	public void setDataList_PM_IL_PROD_Insurer(
			List<PM_IL_PROD_INSURER> dataList_PM_IL_PROD_Insurer) {
		this.dataList_PM_IL_PROD_Insurer = dataList_PM_IL_PROD_Insurer;
	}
	

	/**
	 * Instantiates all components in PM_IL_PROD_INSURER_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PROD_INS_AGE_FM				 = new HtmlInputText();
		COMP_PROD_INS_AGE_TO				 = new HtmlInputText();
		COMP_PROD_INS_SA_FM				 = new HtmlInputText();
		COMP_PROD_INS_SA_TO				 = new HtmlInputText();
		COMP_PROD_INS_TM_FM				 = new HtmlInputText();
		COMP_PROD_INS_TM_TO				 = new HtmlInputText();

	}


	/**
	 * Resets all components in PM_IL_PROD_INSURER_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PROD_INS_AGE_FM.resetValue();
		COMP_PROD_INS_AGE_TO.resetValue();
		COMP_PROD_INS_SA_FM.resetValue();
		COMP_PROD_INS_SA_TO.resetValue();
		COMP_PROD_INS_TM_FM.resetValue();
		COMP_PROD_INS_TM_TO.resetValue();

	}


}
