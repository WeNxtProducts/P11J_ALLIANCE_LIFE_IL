package com.iii.pel.forms.PILT013;

import java.sql.Date;
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

	public PILT013_COMPOSITE_ACTION compositeAction;
	//added by gopi for ssp call id ZBLIFE-1465513
	public PM_IL_DOC_TODO_GROUP_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_DOC_TODO_GROUP_HELPER helper) {
		this.helper = helper;
	}
//end
	private PM_IL_DOC_TODO_GROUP_HELPER helper;
	
	private List<PM_IL_DOC_TODO_GROUP> dataList_PM_IL_DOC_TODO_GROUP = new ArrayList<PM_IL_DOC_TODO_GROUP>();

	private UIData dataTable;

	public PM_IL_DOC_TODO_GROUP_ACTION() {

		PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
		helper = new PM_IL_DOC_TODO_GROUP_HELPER();
		
/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
		
		initializeAllComponent();
		
		/*End*/
		
	}

	public HtmlOutputLabel getCOMP_DTG_GROUP_TYPE_LABEL() {
		return COMP_DTG_GROUP_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_DTG_GROUP_TYPE() {
		return COMP_DTG_GROUP_TYPE;
	}

	public void setCOMP_DTG_GROUP_TYPE_LABEL(
			HtmlOutputLabel COMP_DTG_GROUP_TYPE_LABEL) {
		this.COMP_DTG_GROUP_TYPE_LABEL = COMP_DTG_GROUP_TYPE_LABEL;
	}

	public void setCOMP_DTG_GROUP_TYPE(HtmlInputText COMP_DTG_GROUP_TYPE) {
		this.COMP_DTG_GROUP_TYPE = COMP_DTG_GROUP_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DTG_GROUP_CODE_DESC_LABEL() {
		return COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DTG_GROUP_CODE_DESC() {
		return COMP_UI_M_DTG_GROUP_CODE_DESC;
	}

	public void setCOMP_UI_M_DTG_GROUP_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL) {
		this.COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL = COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DTG_GROUP_CODE_DESC(
			HtmlInputText COMP_UI_M_DTG_GROUP_CODE_DESC) {
		this.COMP_UI_M_DTG_GROUP_CODE_DESC = COMP_UI_M_DTG_GROUP_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DTG_GROUP_CODE_LABEL() {
		return COMP_DTG_GROUP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DTG_GROUP_CODE() {
		return COMP_DTG_GROUP_CODE;
	}

	public void setCOMP_DTG_GROUP_CODE_LABEL(
			HtmlOutputLabel COMP_DTG_GROUP_CODE_LABEL) {
		this.COMP_DTG_GROUP_CODE_LABEL = COMP_DTG_GROUP_CODE_LABEL;
	}

	public void setCOMP_DTG_GROUP_CODE(HtmlInputText COMP_DTG_GROUP_CODE) {
		this.COMP_DTG_GROUP_CODE = COMP_DTG_GROUP_CODE;
	}

	public HtmlOutputLabel getCOMP_DTG_GROUP_DESC_LABEL() {
		return COMP_DTG_GROUP_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DTG_GROUP_DESC() {
		return COMP_DTG_GROUP_DESC;
	}

	public void setCOMP_DTG_GROUP_DESC_LABEL(
			HtmlOutputLabel COMP_DTG_GROUP_DESC_LABEL) {
		this.COMP_DTG_GROUP_DESC_LABEL = COMP_DTG_GROUP_DESC_LABEL;
	}

	public void setCOMP_DTG_GROUP_DESC(HtmlInputText COMP_DTG_GROUP_DESC) {
		this.COMP_DTG_GROUP_DESC = COMP_DTG_GROUP_DESC;
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
				throw new Exception(Messages.getString(
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
			if (PM_IL_DOC_TODO_GROUP_BEAN.getROWID() == null) {		
				if(isINSERT_ALLOWED()){
					new CRUDHandler().executeInsert(PM_IL_DOC_TODO_GROUP_BEAN,
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
					dataList_PM_IL_DOC_TODO_GROUP.add(PM_IL_DOC_TODO_GROUP_BEAN);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}

			} else if (PM_IL_DOC_TODO_GROUP_BEAN.getROWID() != null) {

				if(isUPDATE_ALLOWED()){
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
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
					
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
			helper.POST_QUERY(compositeAction);
			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);		
			resetAllComponent();	
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

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
		COMP_UI_M_DTG_GROUP_CODE_DESC.resetValue();
		COMP_DTG_GROUP_CODE.resetValue();
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
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.PRE_QUERY(compositeAction);
				helper.executeQuery(compositeAction);
				if(compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getROWID()!=null)
				helper.POST_QUERY(compositeAction);
				//committed by Dhinesh For checklist issue SSP Call id is FALCONQC-1714757
				helper.executeQuery1(compositeAction);
				String value=compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_APPR_STS();
				System.out.println("DTLS_APPR_STS value :::"+value);
				if ("N".equals(value))
				{
					compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(null);
					compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
							.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
				}
				//End
				setBlockFlag(false);
				
				/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
				if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
						getSMV_APPRV_FLAG().equalsIgnoreCase("a"))
				{
					disableAllComponent(true);
					compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().disableAllComponent(true);
				}
				
				/*End*/
				
				
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String goToChildBlock(){
		return "PILT013_PT_IL_DOC_TODO_LIST_STATUS"; 
	}
	
	
	
	 /*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
	 
	 public void disableAllComponent(boolean disabled) {
		 
		 COMP_DTG_GROUP_TYPE.setDisabled(disabled);
			COMP_UI_M_DTG_GROUP_CODE_DESC.setDisabled(disabled);
			COMP_DTG_GROUP_CODE.setDisabled(disabled);
			COMP_DTG_GROUP_DESC.setDisabled(disabled);
		
	 }
	
	private void initializeAllComponent() {
		
		 COMP_DTG_GROUP_TYPE = new HtmlInputText();
		 COMP_UI_M_DTG_GROUP_CODE_DESC = new HtmlInputText();
		 COMP_DTG_GROUP_CODE = new HtmlInputText();
		 COMP_DTG_GROUP_DESC = new HtmlInputText();
	}
	
	/*eND*/
	
}
