package com.iii.pel.forms.PILT006_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_STATUS_2_ACTION extends CommonAction {

	private HtmlCalendar COMP_CS_STATUS_DT;

	private HtmlOutputLabel COMP_CS_STATUS_DT_LABEL;

	private HtmlOutputLabel COMP_CS_REMINDER_NO_LABEL;

	private HtmlInputText COMP_CS_REMINDER_NO;

	private HtmlOutputLabel COMP_CS_STATUS_CODE_LABEL;

	private HtmlInputText COMP_CS_STATUS_CODE;

	private HtmlOutputLabel COMP_UI_M_CS_REMINDER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CS_REMINDER_DESC;

	private HtmlOutputLabel COMP_CS_STATUS_UID_LABEL;

	private HtmlInputText COMP_CS_STATUS_UID;

	private PT_IL_CLAIM_STATUS_2 PT_IL_CLAIM_STATUS_2_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_CLAIM_STATUS_2_HELPER helper;
	
	public String filterByCS_REMINDER_NO;
	
	public String filterByCS_STATUS_DT;
	
	public String filterByCS_STATUS_UID;
	
	public String filterByUI_M_CS_REMINDER_DESC;
	
	public String filterByCS_STATUS_CODE;

	private List<PT_IL_CLAIM_STATUS_2> dataList_PT_IL_CLAIM_STATUS_2 = new ArrayList<PT_IL_CLAIM_STATUS_2>();

	public UIData dataTable;

	/**
	 * @return the cOMP_CS_STATUS_DT
	 */
	public HtmlCalendar getCOMP_CS_STATUS_DT() {
		return COMP_CS_STATUS_DT;
	}

	/**
	 * @param comp_cs_status_dt the cOMP_CS_STATUS_DT to set
	 */
	public void setCOMP_CS_STATUS_DT(HtmlCalendar comp_cs_status_dt) {
		COMP_CS_STATUS_DT = comp_cs_status_dt;
	}

	/**
	 * @return the cOMP_CS_STATUS_DT_LABEL
	 */
	public HtmlOutputLabel getCOMP_CS_STATUS_DT_LABEL() {
		return COMP_CS_STATUS_DT_LABEL;
	}

	/**
	 * @param comp_cs_status_dt_label the cOMP_CS_STATUS_DT_LABEL to set
	 */
	public void setCOMP_CS_STATUS_DT_LABEL(HtmlOutputLabel comp_cs_status_dt_label) {
		COMP_CS_STATUS_DT_LABEL = comp_cs_status_dt_label;
	}

	/**
	 * @return the cOMP_CS_REMINDER_NO_LABEL
	 */
	public HtmlOutputLabel getCOMP_CS_REMINDER_NO_LABEL() {
		return COMP_CS_REMINDER_NO_LABEL;
	}

	/**
	 * @param comp_cs_reminder_no_label the cOMP_CS_REMINDER_NO_LABEL to set
	 */
	public void setCOMP_CS_REMINDER_NO_LABEL(
			HtmlOutputLabel comp_cs_reminder_no_label) {
		COMP_CS_REMINDER_NO_LABEL = comp_cs_reminder_no_label;
	}

	/**
	 * @return the cOMP_CS_REMINDER_NO
	 */
	public HtmlInputText getCOMP_CS_REMINDER_NO() {
		return COMP_CS_REMINDER_NO;
	}

	/**
	 * @param comp_cs_reminder_no the cOMP_CS_REMINDER_NO to set
	 */
	public void setCOMP_CS_REMINDER_NO(HtmlInputText comp_cs_reminder_no) {
		COMP_CS_REMINDER_NO = comp_cs_reminder_no;
	}

	/**
	 * @return the cOMP_CS_STATUS_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CS_STATUS_CODE_LABEL() {
		return COMP_CS_STATUS_CODE_LABEL;
	}

	/**
	 * @param comp_cs_status_code_label the cOMP_CS_STATUS_CODE_LABEL to set
	 */
	public void setCOMP_CS_STATUS_CODE_LABEL(
			HtmlOutputLabel comp_cs_status_code_label) {
		COMP_CS_STATUS_CODE_LABEL = comp_cs_status_code_label;
	}

	/**
	 * @return the cOMP_CS_STATUS_CODE
	 */
	public HtmlInputText getCOMP_CS_STATUS_CODE() {
		return COMP_CS_STATUS_CODE;
	}

	/**
	 * @param comp_cs_status_code the cOMP_CS_STATUS_CODE to set
	 */
	public void setCOMP_CS_STATUS_CODE(HtmlInputText comp_cs_status_code) {
		COMP_CS_STATUS_CODE = comp_cs_status_code;
	}

	/**
	 * @return the cOMP_UI_M_CS_REMINDER_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_CS_REMINDER_DESC_LABEL() {
		return COMP_UI_M_CS_REMINDER_DESC_LABEL;
	}

	/**
	 * @param comp_ui_m_cs_reminder_desc_label the cOMP_UI_M_CS_REMINDER_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_CS_REMINDER_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_cs_reminder_desc_label) {
		COMP_UI_M_CS_REMINDER_DESC_LABEL = comp_ui_m_cs_reminder_desc_label;
	}

	/**
	 * @return the cOMP_UI_M_CS_REMINDER_DESC
	 */
	public HtmlInputText getCOMP_UI_M_CS_REMINDER_DESC() {
		return COMP_UI_M_CS_REMINDER_DESC;
	}

	/**
	 * @param comp_ui_m_cs_reminder_desc the cOMP_UI_M_CS_REMINDER_DESC to set
	 */
	public void setCOMP_UI_M_CS_REMINDER_DESC(
			HtmlInputText comp_ui_m_cs_reminder_desc) {
		COMP_UI_M_CS_REMINDER_DESC = comp_ui_m_cs_reminder_desc;
	}

	/**
	 * @return the cOMP_CS_STATUS_UID_LABEL
	 */
	public HtmlOutputLabel getCOMP_CS_STATUS_UID_LABEL() {
		return COMP_CS_STATUS_UID_LABEL;
	}

	/**
	 * @param comp_cs_status_uid_label the cOMP_CS_STATUS_UID_LABEL to set
	 */
	public void setCOMP_CS_STATUS_UID_LABEL(HtmlOutputLabel comp_cs_status_uid_label) {
		COMP_CS_STATUS_UID_LABEL = comp_cs_status_uid_label;
	}

	/**
	 * @return the cOMP_CS_STATUS_UID
	 */
	public HtmlInputText getCOMP_CS_STATUS_UID() {
		return COMP_CS_STATUS_UID;
	}

	/**
	 * @param comp_cs_status_uid the cOMP_CS_STATUS_UID to set
	 */
	public void setCOMP_CS_STATUS_UID(HtmlInputText comp_cs_status_uid) {
		COMP_CS_STATUS_UID = comp_cs_status_uid;
	}

	/**
	 * @return the compositeAction
	 */
	public PILT006_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PILT006_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the helper
	 */
	public PT_IL_CLAIM_STATUS_2_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PT_IL_CLAIM_STATUS_2_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @param dataList_PT_IL_CLAIM_STATUS_2 the dataList_PT_IL_CLAIM_STATUS_2 to set
	 */
	public void setDataList_PT_IL_CLAIM_STATUS_2(
			List<PT_IL_CLAIM_STATUS_2> dataList_PT_IL_CLAIM_STATUS_2) {
		this.dataList_PT_IL_CLAIM_STATUS_2 = dataList_PT_IL_CLAIM_STATUS_2;
	}

	public PT_IL_CLAIM_STATUS_2_ACTION() {

		PT_IL_CLAIM_STATUS_2_BEAN = new PT_IL_CLAIM_STATUS_2();
		helper = new PT_IL_CLAIM_STATUS_2_HELPER();
		instantiateAllComponent();
	}

	public PT_IL_CLAIM_STATUS_2 getPT_IL_CLAIM_STATUS_2_BEAN() {
		return PT_IL_CLAIM_STATUS_2_BEAN;
	}

	public void setPT_IL_CLAIM_STATUS_2_BEAN(
			PT_IL_CLAIM_STATUS_2 PT_IL_CLAIM_STATUS_2_BEAN) {
		this.PT_IL_CLAIM_STATUS_2_BEAN = PT_IL_CLAIM_STATUS_2_BEAN;
	}

	public List<PT_IL_CLAIM_STATUS_2> getDataList_PT_IL_CLAIM_STATUS_2() {
		return dataList_PT_IL_CLAIM_STATUS_2;
	}

	public void setDataListPT_IL_CLAIM_STATUS_2(
			List<PT_IL_CLAIM_STATUS_2> dataList_PT_IL_CLAIM_STATUS_2) {
		this.dataList_PT_IL_CLAIM_STATUS_2 = dataList_PT_IL_CLAIM_STATUS_2;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PT_IL_CLAIM_STATUS_2_BEAN = new PT_IL_CLAIM_STATUS_2();
				resetAllComponent();
				/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions */
				resetSelectedRow();
				//END
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

				new CRUDHandler().executeDelete(PT_IL_CLAIM_STATUS_2_BEAN,
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
				dataList_PT_IL_CLAIM_STATUS_2.remove(PT_IL_CLAIM_STATUS_2_BEAN);
				if (dataList_PT_IL_CLAIM_STATUS_2.size() > 0) {

					PT_IL_CLAIM_STATUS_2_BEAN = dataList_PT_IL_CLAIM_STATUS_2
							.get(0);
				} else if (dataList_PT_IL_CLAIM_STATUS_2.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_CLAIM_STATUS_2_BEAN.setRowSelected(true);
				/*Added by saranya for Avoidance of POST button required in all screens on 21/02/2017*/
				CommonUtils.getConnection().commit();
				/*End*/
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
/*Modified by saranya for Avoidance of POST button required in all screens on 21/02/2017*/
	public void postRecord(ActionEvent event) {
		try {
			//added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions
			getErrorMap().clear();
			getWarningMap().clear();
			//end
			if (PT_IL_CLAIM_STATUS_2_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				helper.preInsert(compositeAction);
				
				new CRUDHandler().executeInsert(PT_IL_CLAIM_STATUS_2_BEAN,
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
				
				dataList_PT_IL_CLAIM_STATUS_2.add(PT_IL_CLAIM_STATUS_2_BEAN);
			} else if (PT_IL_CLAIM_STATUS_2_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_CLAIM_STATUS_2_BEAN,
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

			PT_IL_CLAIM_STATUS_2_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
			String message ="";
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		/*} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}*/

	}
	/*End*/
	

	/**
	 * Disables all components in PT_IL_CLAIM_STATUS_2_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_CS_REMINDER_NO.setDisabled(disabled);
		COMP_CS_STATUS_CODE.setDisabled(disabled);
		COMP_UI_M_CS_REMINDER_DESC.setDisabled(disabled);
		COMP_CS_STATUS_UID.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_CS_STATUS_DT.setDisabled(disabled);
		/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
		UI_M_BUT_DEL.setDisabled(disabled);
		UI_M_BUT_POST.setDisabled(disabled);
		UI_M_BUT_ADD.setDisabled(disabled);
	//END
	}
	

	/**
	 * Instantiates all components in PT_IL_CLAIM_STATUS_2_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CS_REMINDER_NO				 = new HtmlInputText();
		COMP_CS_STATUS_CODE				 = new HtmlInputText();
		COMP_UI_M_CS_REMINDER_DESC			 = new HtmlInputText();
		COMP_CS_STATUS_UID				 = new HtmlInputText();
		/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
		UI_M_BUT_DEL= new HtmlAjaxCommandButton();
		UI_M_BUT_POST= new HtmlAjaxCommandButton();
		UI_M_BUT_ADD= new HtmlAjaxCommandButton();
//END
		// Instantiating HtmlCalendar
		COMP_CS_STATUS_DT				 = new HtmlCalendar();

	}





	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_CLAIM_STATUS_2_BEAN = (PT_IL_CLAIM_STATUS_2) dataTable
					.getRowData();
			PT_IL_CLAIM_STATUS_2_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_CLAIM_STATUS_2> PT_IL_CLAIM_STATUS_2_ITR = dataList_PT_IL_CLAIM_STATUS_2
				.iterator();
		while (PT_IL_CLAIM_STATUS_2_ITR.hasNext()) {
			PT_IL_CLAIM_STATUS_2_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_CS_STATUS_DT.resetValue();
		COMP_CS_STATUS_DT.resetValue();
		COMP_CS_REMINDER_NO.resetValue();
		COMP_CS_REMINDER_NO.resetValue();
		COMP_CS_STATUS_CODE.resetValue();
		COMP_CS_STATUS_CODE.resetValue();
		COMP_UI_M_CS_REMINDER_DESC.resetValue();
		COMP_UI_M_CS_REMINDER_DESC.resetValue();
		COMP_CS_STATUS_UID.resetValue();
		COMP_CS_STATUS_UID.resetValue();
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
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
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
				//added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions
				getErrorMap().clear();
				getWarningMap().clear();
				//end
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
				/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
				if("CL05".equalsIgnoreCase(compositeAction
						.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
						.getCLAIM_ADDL_STATUS())) {
				
				disableAllComponent(true);
			}
			}//END
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/**
	 * @return the filterByCS_REMINDER_NO
	 */
	public String getFilterByCS_REMINDER_NO() {
		return filterByCS_REMINDER_NO;
	}

	/**
	 * @param filterByCS_REMINDER_NO the filterByCS_REMINDER_NO to set
	 */
	public void setFilterByCS_REMINDER_NO(String filterByCS_REMINDER_NO) {
		this.filterByCS_REMINDER_NO = filterByCS_REMINDER_NO;
	}

	/**
	 * @return the filterByCS_STATUS_DT
	 */
	public String getFilterByCS_STATUS_DT() {
		return filterByCS_STATUS_DT;
	}

	/**
	 * @param filterByCS_STATUS_DT the filterByCS_STATUS_DT to set
	 */
	public void setFilterByCS_STATUS_DT(String filterByCS_STATUS_DT) {
		this.filterByCS_STATUS_DT = filterByCS_STATUS_DT;
	}

	/**
	 * @return the filterByCS_STATUS_UID
	 */
	public String getFilterByCS_STATUS_UID() {
		return filterByCS_STATUS_UID;
	}

	/**
	 * @param filterByCS_STATUS_UID the filterByCS_STATUS_UID to set
	 */
	public void setFilterByCS_STATUS_UID(String filterByCS_STATUS_UID) {
		this.filterByCS_STATUS_UID = filterByCS_STATUS_UID;
	}

	/**
	 * @return the filterByUI_M_CS_REMINDER_DESC
	 */
	public String getFilterByUI_M_CS_REMINDER_DESC() {
		return filterByUI_M_CS_REMINDER_DESC;
	}

	/**
	 * @param filterByUI_M_CS_REMINDER_DESC the filterByUI_M_CS_REMINDER_DESC to set
	 */
	public void setFilterByUI_M_CS_REMINDER_DESC(
			String filterByUI_M_CS_REMINDER_DESC) {
		this.filterByUI_M_CS_REMINDER_DESC = filterByUI_M_CS_REMINDER_DESC;
	}

	/**
	 * @return the filterByCS_STATUS_CODE
	 */
	public String getFilterByCS_STATUS_CODE() {
		return filterByCS_STATUS_CODE;
	}

	/**
	 * @param filterByCS_STATUS_CODE the filterByCS_STATUS_CODE to set
	 */
	public void setFilterByCS_STATUS_CODE(String filterByCS_STATUS_CODE) {
		this.filterByCS_STATUS_CODE = filterByCS_STATUS_CODE;
	}
	
	/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
	
private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton uI_M_BUT_DEL) {
		UI_M_BUT_DEL = uI_M_BUT_DEL;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton uI_M_BUT_POST) {
		UI_M_BUT_POST = uI_M_BUT_POST;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton uI_M_BUT_ADD) {
		UI_M_BUT_ADD = uI_M_BUT_ADD;
	}
//END
}
