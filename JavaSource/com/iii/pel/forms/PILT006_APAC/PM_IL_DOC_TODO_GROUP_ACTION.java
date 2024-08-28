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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DTG_GROUP_TYPE_LABEL;

	private HtmlInputText COMP_DTG_GROUP_TYPE;

	private HtmlOutputLabel COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DTG_GROUP_CODE_DESC;

	private HtmlOutputLabel COMP_DTG_GROUP_CODE_LABEL;

	private HtmlInputText COMP_DTG_GROUP_CODE;

	private HtmlOutputLabel COMP_DTG_GROUP_DESC_LABEL;

	private HtmlInputText COMP_DTG_GROUP_DESC;

	private PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_DOC_TODO_GROUP_HELPER helper;
	
	private String filterByDTG_GROUP_TYPE;
	private String filterByUI_M_DTG_GROUP_CODE_DESC;
	private String filterByDTG_GROUP_CODE;
	private String filterByDTG_GROUP_DESC;

	private List<PM_IL_DOC_TODO_GROUP> dataList_PM_IL_DOC_TODO_GROUP = new ArrayList<PM_IL_DOC_TODO_GROUP>();

	private UIData dataTable;

	public PM_IL_DOC_TODO_GROUP_ACTION() {

		PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
		helper = new PM_IL_DOC_TODO_GROUP_HELPER();
	}

	
	public PM_IL_DOC_TODO_GROUP getPM_IL_DOC_TODO_GROUP_BEAN() {
		return PM_IL_DOC_TODO_GROUP_BEAN;
	}

	public void setPM_IL_DOC_TODO_GROUP_BEAN(
			PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN) {
		this.PM_IL_DOC_TODO_GROUP_BEAN = PM_IL_DOC_TODO_GROUP_BEAN;
	}

	public List<PM_IL_DOC_TODO_GROUP> getDataList_PM_IL_DOC_TODO_GROUP() {
		return dataList_PM_IL_DOC_TODO_GROUP;
	}

	public void setDataListPM_IL_DOC_TODO_GROUP(
			List<PM_IL_DOC_TODO_GROUP> dataList_PM_IL_DOC_TODO_GROUP) {
		this.dataList_PM_IL_DOC_TODO_GROUP = dataList_PM_IL_DOC_TODO_GROUP;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
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

				new CRUDHandler().executeDelete(PM_IL_DOC_TODO_GROUP_BEAN,
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
				dataList_PM_IL_DOC_TODO_GROUP.remove(PM_IL_DOC_TODO_GROUP_BEAN);
				if (dataList_PM_IL_DOC_TODO_GROUP.size() > 0) {

					PM_IL_DOC_TODO_GROUP_BEAN = dataList_PM_IL_DOC_TODO_GROUP
							.get(0);
				} else if (dataList_PM_IL_DOC_TODO_GROUP.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
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
			if (PM_IL_DOC_TODO_GROUP_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PM_IL_DOC_TODO_GROUP_BEAN,
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
				dataList_PM_IL_DOC_TODO_GROUP.add(PM_IL_DOC_TODO_GROUP_BEAN);
			} else if (PM_IL_DOC_TODO_GROUP_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PM_IL_DOC_TODO_GROUP_BEAN,
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

			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
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
			PM_IL_DOC_TODO_GROUP_BEAN = (PM_IL_DOC_TODO_GROUP) dataTable
					.getRowData();
			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	public String fetchRecords() {
		CommonUtils.clearMaps(this);
		try {
			PM_IL_DOC_TODO_GROUP_BEAN = (PM_IL_DOC_TODO_GROUP) dataTable
					.getRowData();
			resetSelectedRow();
			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
/*Comented By Saritha 1.6.2016  if(!compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().isBlockFlag()){
				new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().executeSelectStatement(compositeAction);
			List<PT_IL_DOC_TODO_LIST_STATUS> list = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getDataList_PT_IL_DOC_TODO_LIST_STATUS();
			
			if(list!=null && !list.isEmpty()){
				for(int i=0;i<list.size();i++){
					PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status = list.get(i);
					if(i==0){
						pt_il_doc_todo_list_status.setRowSelected(true);
						compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setPT_IL_DOC_TODO_LIST_STATUS_BEAN(pt_il_doc_todo_list_status);
					}else{
						pt_il_doc_todo_list_status.setRowSelected(false);
					}
				}
			}*/
			new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().executeSelectStatement(compositeAction);
			List<PT_IL_DOC_TODO_LIST_STATUS> list = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getDataList_PT_IL_DOC_TODO_LIST_STATUS();
			
			if(list!=null && !list.isEmpty()){
				for(int i=0;i<list.size();i++){
					PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status = list.get(i);
					if(i==0){
						pt_il_doc_todo_list_status.setRowSelected(true);
						compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setPT_IL_DOC_TODO_LIST_STATUS_BEAN(pt_il_doc_todo_list_status);
					}else{
						pt_il_doc_todo_list_status.setRowSelected(false);
					}
				}
			}else{
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setPT_IL_DOC_TODO_LIST_STATUS_BEAN(new PT_IL_DOC_TODO_LIST_STATUS());
			}
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
		return "toDoList";
	}

	
	
	private void resetSelectedRow() {
		Iterator<PM_IL_DOC_TODO_GROUP> PM_IL_DOC_TODO_GROUP_ITR = dataList_PM_IL_DOC_TODO_GROUP
				.iterator();
		while (PM_IL_DOC_TODO_GROUP_ITR.hasNext()) {
			PM_IL_DOC_TODO_GROUP_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_DTG_GROUP_TYPE.resetValue();
		COMP_DTG_GROUP_TYPE.resetValue();
		COMP_UI_M_DTG_GROUP_CODE_DESC.resetValue();
		COMP_UI_M_DTG_GROUP_CODE_DESC.resetValue();
		COMP_DTG_GROUP_CODE.resetValue();
		COMP_DTG_GROUP_CODE.resetValue();
		COMP_DTG_GROUP_DESC.resetValue();
		COMP_DTG_GROUP_DESC.resetValue();
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
				helper.postQuery(PM_IL_DOC_TODO_GROUP_BEAN);
				
				/*Added by sankara narayanan for checklist load on onload*/
				new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().executeSelectStatement(compositeAction);
				List<PT_IL_DOC_TODO_LIST_STATUS> list = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getDataList_PT_IL_DOC_TODO_LIST_STATUS();
				
				if(list!=null && !list.isEmpty()){
					for(int i=0;i<list.size();i++){
						PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status = list.get(i);
						if(i==0){
							pt_il_doc_todo_list_status.setRowSelected(true);
							compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setPT_IL_DOC_TODO_LIST_STATUS_BEAN(pt_il_doc_todo_list_status);
						}else{
							pt_il_doc_todo_list_status.setRowSelected(false);
						}
					}
				}else{
					compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setPT_IL_DOC_TODO_LIST_STATUS_BEAN(new PT_IL_DOC_TODO_LIST_STATUS());
				}
				/*end*/
				
				
				
				/* Added by Janani on 23/05/2017 for hands-on-feedback point(checklist)*/
				
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDataTable(dataTable);
				
				/*End*/
				
				
				setBlockFlag(false);
			}
			if("CL05".equalsIgnoreCase(compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
					.getCLAIM_ADDL_STATUS())) {
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().
			disableAllComponent(true);
		}
			if(dataList_PM_IL_DOC_TODO_GROUP!=null && !dataList_PM_IL_DOC_TODO_GROUP.isEmpty()){
				PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group = null;
				for(int i =0;i<dataList_PM_IL_DOC_TODO_GROUP.size();i++){
					pm_il_doc_todo_group = dataList_PM_IL_DOC_TODO_GROUP.get(i);
					if(i==0){
						//pm_il_doc_todo_group.setRowSelected(true);
						setPM_IL_DOC_TODO_GROUP_BEAN(pm_il_doc_todo_group);
					}else{
						//pm_il_doc_todo_group.setRowSelected(false);
					}
				}
			}
			
			/*Added by Janani on 21.08.2017 for ZBILQC-1732254*/
			if(compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getROWID() != null)
			{				
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getCOMP_DTLS_SR_NO().setDisabled(true);
			}
			else
			{
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getCOMP_DTLS_SR_NO().setDisabled(false);
			}
			
			/*End*/
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}


	/**
	 * @return the cOMP_DTG_GROUP_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_DTG_GROUP_TYPE_LABEL() {
		return COMP_DTG_GROUP_TYPE_LABEL;
	}


	/**
	 * @param comp_dtg_group_type_label the cOMP_DTG_GROUP_TYPE_LABEL to set
	 */
	public void setCOMP_DTG_GROUP_TYPE_LABEL(
			HtmlOutputLabel comp_dtg_group_type_label) {
		COMP_DTG_GROUP_TYPE_LABEL = comp_dtg_group_type_label;
	}


	/**
	 * @return the cOMP_DTG_GROUP_TYPE
	 */
	public HtmlInputText getCOMP_DTG_GROUP_TYPE() {
		return COMP_DTG_GROUP_TYPE;
	}


	/**
	 * @param comp_dtg_group_type the cOMP_DTG_GROUP_TYPE to set
	 */
	public void setCOMP_DTG_GROUP_TYPE(HtmlInputText comp_dtg_group_type) {
		COMP_DTG_GROUP_TYPE = comp_dtg_group_type;
	}


	/**
	 * @return the cOMP_UI_M_DTG_GROUP_CODE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_DTG_GROUP_CODE_DESC_LABEL() {
		return COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL;
	}


	/**
	 * @param comp_ui_m_dtg_group_code_desc_label the cOMP_UI_M_DTG_GROUP_CODE_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_DTG_GROUP_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_dtg_group_code_desc_label) {
		COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL = comp_ui_m_dtg_group_code_desc_label;
	}


	/**
	 * @return the cOMP_UI_M_DTG_GROUP_CODE_DESC
	 */
	public HtmlInputText getCOMP_UI_M_DTG_GROUP_CODE_DESC() {
		return COMP_UI_M_DTG_GROUP_CODE_DESC;
	}


	/**
	 * @param comp_ui_m_dtg_group_code_desc the cOMP_UI_M_DTG_GROUP_CODE_DESC to set
	 */
	public void setCOMP_UI_M_DTG_GROUP_CODE_DESC(
			HtmlInputText comp_ui_m_dtg_group_code_desc) {
		COMP_UI_M_DTG_GROUP_CODE_DESC = comp_ui_m_dtg_group_code_desc;
	}


	/**
	 * @return the cOMP_DTG_GROUP_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_DTG_GROUP_CODE_LABEL() {
		return COMP_DTG_GROUP_CODE_LABEL;
	}


	/**
	 * @param comp_dtg_group_code_label the cOMP_DTG_GROUP_CODE_LABEL to set
	 */
	public void setCOMP_DTG_GROUP_CODE_LABEL(
			HtmlOutputLabel comp_dtg_group_code_label) {
		COMP_DTG_GROUP_CODE_LABEL = comp_dtg_group_code_label;
	}


	/**
	 * @return the cOMP_DTG_GROUP_CODE
	 */
	public HtmlInputText getCOMP_DTG_GROUP_CODE() {
		return COMP_DTG_GROUP_CODE;
	}


	/**
	 * @param comp_dtg_group_code the cOMP_DTG_GROUP_CODE to set
	 */
	public void setCOMP_DTG_GROUP_CODE(HtmlInputText comp_dtg_group_code) {
		COMP_DTG_GROUP_CODE = comp_dtg_group_code;
	}


	/**
	 * @return the cOMP_DTG_GROUP_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_DTG_GROUP_DESC_LABEL() {
		return COMP_DTG_GROUP_DESC_LABEL;
	}


	/**
	 * @param comp_dtg_group_desc_label the cOMP_DTG_GROUP_DESC_LABEL to set
	 */
	public void setCOMP_DTG_GROUP_DESC_LABEL(
			HtmlOutputLabel comp_dtg_group_desc_label) {
		COMP_DTG_GROUP_DESC_LABEL = comp_dtg_group_desc_label;
	}


	/**
	 * @return the cOMP_DTG_GROUP_DESC
	 */
	public HtmlInputText getCOMP_DTG_GROUP_DESC() {
		return COMP_DTG_GROUP_DESC;
	}


	/**
	 * @param comp_dtg_group_desc the cOMP_DTG_GROUP_DESC to set
	 */
	public void setCOMP_DTG_GROUP_DESC(HtmlInputText comp_dtg_group_desc) {
		COMP_DTG_GROUP_DESC = comp_dtg_group_desc;
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
	public PM_IL_DOC_TODO_GROUP_HELPER getHelper() {
		return helper;
	}


	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PM_IL_DOC_TODO_GROUP_HELPER helper) {
		this.helper = helper;
	}


	/**
	 * @param dataList_PM_IL_DOC_TODO_GROUP the dataList_PM_IL_DOC_TODO_GROUP to set
	 */
	public void setDataList_PM_IL_DOC_TODO_GROUP(
			List<PM_IL_DOC_TODO_GROUP> dataList_PM_IL_DOC_TODO_GROUP) {
		this.dataList_PM_IL_DOC_TODO_GROUP = dataList_PM_IL_DOC_TODO_GROUP;
	}


	/**
	 * @return the filterByDTG_GROUP_TYPE
	 */
	public String getFilterByDTG_GROUP_TYPE() {
		return filterByDTG_GROUP_TYPE;
	}


	/**
	 * @param filterByDTG_GROUP_TYPE the filterByDTG_GROUP_TYPE to set
	 */
	public void setFilterByDTG_GROUP_TYPE(String filterByDTG_GROUP_TYPE) {
		this.filterByDTG_GROUP_TYPE = filterByDTG_GROUP_TYPE;
	}


	/**
	 * @return the filterByUI_M_DTG_GROUP_CODE_DESC
	 */
	public String getFilterByUI_M_DTG_GROUP_CODE_DESC() {
		return filterByUI_M_DTG_GROUP_CODE_DESC;
	}


	/**
	 * @param filterByUI_M_DTG_GROUP_CODE_DESC the filterByUI_M_DTG_GROUP_CODE_DESC to set
	 */
	public void setFilterByUI_M_DTG_GROUP_CODE_DESC(
			String filterByUI_M_DTG_GROUP_CODE_DESC) {
		this.filterByUI_M_DTG_GROUP_CODE_DESC = filterByUI_M_DTG_GROUP_CODE_DESC;
	}


	/**
	 * @return the filterByDTG_GROUP_CODE
	 */
	public String getFilterByDTG_GROUP_CODE() {
		return filterByDTG_GROUP_CODE;
	}


	/**
	 * @param filterByDTG_GROUP_CODE the filterByDTG_GROUP_CODE to set
	 */
	public void setFilterByDTG_GROUP_CODE(String filterByDTG_GROUP_CODE) {
		this.filterByDTG_GROUP_CODE = filterByDTG_GROUP_CODE;
	}


	/**
	 * @return the filterByDTG_GROUP_DESC
	 */
	public String getFilterByDTG_GROUP_DESC() {
		return filterByDTG_GROUP_DESC;
	}


	/**
	 * @param filterByDTG_GROUP_DESC the filterByDTG_GROUP_DESC to set
	 */
	public void setFilterByDTG_GROUP_DESC(String filterByDTG_GROUP_DESC) {
		this.filterByDTG_GROUP_DESC = filterByDTG_GROUP_DESC;
	}

}
