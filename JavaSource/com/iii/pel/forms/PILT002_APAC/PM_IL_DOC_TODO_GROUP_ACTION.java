package com.iii.pel.forms.PILT002_APAC;

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

public class PM_IL_DOC_TODO_GROUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DTG_GROUP_TYPE_LABEL;

	private HtmlInputText COMP_DTG_GROUP_TYPE;

	private HtmlOutputLabel COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DTG_GROUP_CODE_DESC;

	private HtmlOutputLabel COMP_DTG_GROUP_CODE_LABEL;

	private HtmlInputText COMP_DTG_GROUP_CODE;

	private HtmlOutputLabel COMP_DTG_GROUP_DESC_LABEL;

	private HtmlInputText COMP_DTG_GROUP_DESC;
	
	private HtmlCommandButton COMP_UI_M_BUT_CHK_LIST_DTL;

	private PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_DOC_TODO_GROUP_HELPER helper;
	
	private PT_IL_DOC_TODO_LIST_STATUS_HELPER helperDocToDoList;
	
	private PT_IL_DOC_TODO_LIST_STATUS_ACTION todolistAction;

	private List<PM_IL_DOC_TODO_GROUP> dataList_PM_IL_DOC_TODO_GROUP = new ArrayList<PM_IL_DOC_TODO_GROUP>();

	private UIData dataTable;

	public PM_IL_DOC_TODO_GROUP_ACTION() {

		PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
		helper = new PM_IL_DOC_TODO_GROUP_HELPER();
		instantiateAllComponent();
		helperDocToDoList = new PT_IL_DOC_TODO_LIST_STATUS_HELPER();
		todolistAction=new PT_IL_DOC_TODO_LIST_STATUS_ACTION();
		
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
			getErrorMap().clear();
			getWarningMap().clear();
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
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				helper.preDelete(compositeAction);
				
				new CRUDHandler().executeDelete(PM_IL_DOC_TODO_GROUP_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("deleteRow",message);
				dataList_PM_IL_DOC_TODO_GROUP.remove(PM_IL_DOC_TODO_GROUP_BEAN);
				if (dataList_PM_IL_DOC_TODO_GROUP.size() > 0) {
					PM_IL_DOC_TODO_GROUP_BEAN = dataList_PM_IL_DOC_TODO_GROUP.get(0);
				} else if (dataList_PM_IL_DOC_TODO_GROUP.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
				getErrorMap().put("deleteRow",message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			if (PM_IL_DOC_TODO_GROUP_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PM_IL_DOC_TODO_GROUP_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
				dataList_PM_IL_DOC_TODO_GROUP.add(PM_IL_DOC_TODO_GROUP_BEAN);
						
			} else if (PM_IL_DOC_TODO_GROUP_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(PM_IL_DOC_TODO_GROUP_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
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
			PM_IL_DOC_TODO_GROUP_BEAN = (PM_IL_DOC_TODO_GROUP) dataTable.getRowData();
			
			
			System.out.println("POAD_BMI     : "+compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_BMI());
			
			System.out.println("PM_IL_DOC_TODO_GROUP_BEAN.getDTG_DS_CODE()   : "+PM_IL_DOC_TODO_GROUP_BEAN.getDTG_DS_CODE());
			
			helper.postQuery(compositeAction);
			
			/*Added by Raja .R on 04-07-2016.SSP Call ID - FALCONQC-1714757

            Start*/ 
			helper.executeQuery1(compositeAction);
			
			/*End of SSP Call ID - FALCONQC-1714757 */
			
			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
			resetAllComponent();
			todolistAction.resetAllComponent();
			/* calling onload executequery from doc_todo_list for combinig same page*/
			//helperDocToDoList.executeQuery(compositeAction);
			
			//todolistAction.displayRecords();
			//todolistAction.resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
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
		
		/*Added by Raja .R on 04-07-2016.SSP Call ID - FALCONQC-1714757

	    Start*/ 
		
		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getCOMP_DTLS_APPR_STS().resetValue();
		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getCOMP_DTLS_MANDATORY_YN().resetValue();
		//compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().COMP_DTLS_APPR_STS.resetValue();
		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getCOMP_DTLS_DOC_REC_DT().resetValue();
		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getCOMP_DTLS_REMARKS().resetValue();
		
		/*End of SSP Call ID - FALCONQC-1714757 */
		
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
			getWarningMap().put(
					"postRecord",
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
				helper.preQuery(PM_IL_DOC_TODO_GROUP_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
				//if (PM_IL_DOC_TODO_GROUP_BEAN.getROWID() != null) {
				    helper.executeQuery(compositeAction);
					helper.postQuery(compositeAction);
					helper.onPopulateDetails(compositeAction);
					
					/*Added by Raja .R on 04-07-2016.SSP Call ID - FALCONQC-1714757

                    Start*/ 
					helper.executeQuery1(compositeAction);
					
					/*End of SSP Call ID - FALCONQC-1714757 */

				//} 
					
					/*Modified by saranya on 18-03-2017*/
					if(("A".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS()))||
							("Y".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())))
					{
						compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().disableAllComponent(true);
						
					}
					/*End*/

					
				setBlockFlag(false);
				
				/*Added by Ram on 31/03/2017 for SelectAll functionality*/
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDataTable(dataTable);
				System.out.println("PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDataTable() onload        "
				+compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDataTable());
				/*End*/
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PM_IL_DOC_TODO_GROUP_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_DOC_TODO_GROUP_HELPER helper) {
		this.helper = helper;
	}

	public void setDataList_PM_IL_DOC_TODO_GROUP(
			List<PM_IL_DOC_TODO_GROUP> dataList_PM_IL_DOC_TODO_GROUP) {
		this.dataList_PM_IL_DOC_TODO_GROUP = dataList_PM_IL_DOC_TODO_GROUP;
	}


	/**
	 * Disables all components in PM_IL_DOC_TODO_GROUP_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		
		//always disadled
		COMP_DTG_GROUP_TYPE.setDisabled(true);
		COMP_UI_M_DTG_GROUP_CODE_DESC.setDisabled(true);
		COMP_DTG_GROUP_CODE.setDisabled(true);
		COMP_DTG_GROUP_DESC.setDisabled(true);

	}



	/**
	 * Instantiates all components in PM_IL_DOC_TODO_GROUP_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_DTG_GROUP_TYPE				 = new HtmlInputText();
		COMP_UI_M_DTG_GROUP_CODE_DESC			 = new HtmlInputText();
		COMP_DTG_GROUP_CODE				 = new HtmlInputText();
		COMP_DTG_GROUP_DESC				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_DTG_GROUP_TYPE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_DTG_GROUP_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_DTG_GROUP_DESC_LABEL			 = new HtmlOutputLabel();

	}
	
	public String goToChkListDtl() {
	    
	    return "PILT002_APAC_PT_IL_DOC_TODO_LIST_STATUS";
	    
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CHK_LIST_DTL() {
	    return COMP_UI_M_BUT_CHK_LIST_DTL;
	}

	public void setCOMP_UI_M_BUT_CHK_LIST_DTL(
		HtmlCommandButton comp_ui_m_but_chk_list_dtl) {
	    COMP_UI_M_BUT_CHK_LIST_DTL = comp_ui_m_but_chk_list_dtl;
	}

}
