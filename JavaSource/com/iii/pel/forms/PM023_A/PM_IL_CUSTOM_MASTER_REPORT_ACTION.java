package com.iii.pel.forms.PM023_A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM037.PM_IL_BONUS_SETUP;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author Pidugu Raj dt: 04-12-2018
 *
 */
public class PM_IL_CUSTOM_MASTER_REPORT_ACTION extends CommonReportAction/* implements Serializable*/{

	//private static final long serialVersionUID = -8252717247583859207L;

	private PM_CUSTOMIZED_REPORT PM_CUSTOMIZED_REPORT_BEAN;
	private UIData dataTable;
	private List<PM_CUSTOMIZED_REPORT> tableList = new ArrayList<PM_CUSTOMIZED_REPORT>();
	public PM023_A_COMPOSITE_ACTION compositeAction;
	private int lastUpdatedRowIndex;
	private PM023_CUSTOM_REPORT_HELPER helper;
	
	private HtmlOutputLabel COMP_REP_ID_LABEL;
	private HtmlOutputLabel COMP_REP_DESC_LABEL;
	
	private HtmlInputText COMP_REP_ID_TEXT;
	private HtmlInputText COMP_REP_DESC; 	
	
	private HtmlCommandButton UI_M_BUT_ADD;
	private HtmlCommandButton UI_M_BUT_POST;
	private HtmlCommandButton UI_M_BUT_DELETE;
	
	
	int currentPage = 1;
	int recordsPerPage = 5;
	
	public PM_IL_CUSTOM_MASTER_REPORT_ACTION(){
		PM_CUSTOMIZED_REPORT_BEAN = new PM_CUSTOMIZED_REPORT();
		helper = new PM023_CUSTOM_REPORT_HELPER();
		initiatecomponent();
		
	}
	
	public void onLoad(PhaseEvent phaseEvent){
		try{
			if(isBlockFlag()){
			tableList = helper.executeQuery(compositeAction);
			setBlockFlag(false);
			}
			//getDetails();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void instantiateAllComponent() {
		COMP_REP_ID_TEXT = new HtmlInputText();
		COMP_REP_DESC = new HtmlInputText();
		UI_M_BUT_ADD = new HtmlCommandButton();
		UI_M_BUT_POST = new HtmlCommandButton();
		UI_M_BUT_DELETE = new HtmlCommandButton();
	}
	
	public void getDetails() {
		try {
			if (tableList!=null && tableList.size() != 0) {				
				PM_CUSTOMIZED_REPORT_BEAN = (PM_CUSTOMIZED_REPORT) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_CUSTOMIZED_REPORT_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void resetSelectedRow() {
		Iterator<PM_CUSTOMIZED_REPORT> iterator = tableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void saveData(){
		try{
			
		}catch(Exception e){
			new FacesMessage(e.getMessage());
		}
	}
	
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				tableList.remove(PM_CUSTOMIZED_REPORT_BEAN);
				helper.executeDelete(PM_CUSTOMIZED_REPORT_BEAN);
				//CommonUtils.getConnection().commit();
				getWarningMap().put("deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				//tableList.remove(PM_CUSTOMIZED_REPORT_BEAN);
				if (tableList.size() > 0) {

					PM_CUSTOMIZED_REPORT_BEAN = tableList.get(0);
				} else if (tableList.size() == 0) {

					AddRow(null);
				}

				resetAllComponent();
				PM_CUSTOMIZED_REPORT_BEAN.setRowSelected(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			if(compositeAction.getPM_IL_CUSTOM_MASTER_REPORT_ACTION_BEAN().getPM_CUSTOMIZED_REPORT_BEAN().getREP_ID() != null){
			PM_CUSTOMIZED_REPORT_BEAN = helper.getDetails(compositeAction);
			}
			if (PM_CUSTOMIZED_REPORT_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PM_CUSTOMIZED_REPORT_BEAN, CommonUtils.getConnection());
				helper.postQuery(PM_CUSTOMIZED_REPORT_BEAN);
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"); 
				tableList.add(PM_CUSTOMIZED_REPORT_BEAN);
			} else if (PM_CUSTOMIZED_REPORT_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(PM_CUSTOMIZED_REPORT_BEAN, CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
		
			}
			//CommonUtils.getConnection().commit();
			PM_CUSTOMIZED_REPORT_BEAN.setRowSelected(true);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
	
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: " + exc.getMessage());
		}

	}
	
	public void saveRecord() {
		try {
			//postRecord(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString("messageProperties","errorPanel$message$save"));
			getWarningMap().put("SAVE_RECORD", Messages.getString("messageProperties","errorPanel$message$save"));
			new FacesMessage(Messages.getString("messageProperties","errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}


	/*public String deleteRow(ActionEvent ae) {

		try{
		
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_BONUS_SETUP bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		
		if (tableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			deleteRows();
			deletedRecordList.add(deletedRecordIndex);
			}
			for(int i=0;i<tableList.size();i++){
				PM_CUSTOMIZED_REPORT PM_CUSTOMIZED_REPORT = tableList.get(i);
				if(i==0){
					PM_CUSTOMIZED_REPORT.setRowSelected(true);
					setPM_CUSTOMIZED_REPORT_BEAN(PM_CUSTOMIZED_REPORT);
				}else{
					PM_CUSTOMIZED_REPORT.setRowSelected(false);
				}
			}
			if(tableList!=null && tableList.size()==0){
				PM_CUSTOMIZED_REPORT_BEAN = new PM_CUSTOMIZED_REPORT();
				setPM_CUSTOMIZED_REPORT_BEAN(PM_CUSTOMIZED_REPORT_BEAN);
			}
		
			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current",
						+deletedRecordList.size() + "Record Deleted ");

			}
			//lastUpdateRowIndex = -1;

		//}
		resetAllComponent();
		}catch(Exception exception){
		}
		return "";
	}*/
	
	public String deleteRows() {
		DelegateDb dbHelper = new DelegateDb();
		int deleteCount = 0;

		for (int i = tableList.size()-1; i>=0; i--) {
			PM_CUSTOMIZED_REPORT_BEAN = tableList.get(i);
			System.out.println(">>>>>>>>>>deleteRows"+PM_CUSTOMIZED_REPORT_BEAN.isSelected());
			if (PM_CUSTOMIZED_REPORT_BEAN != null && 
					"dataTableSelectedRow".equalsIgnoreCase(PM_CUSTOMIZED_REPORT_BEAN.getRowSelected())){
				deleteCount += dbHelper.deleteData(PM_CUSTOMIZED_REPORT_BEAN);
				tableList.remove(PM_CUSTOMIZED_REPORT_BEAN);
				System.out.println("PM_IL_BONUS_SETUP_ACTION.deleteRows() DELETING ROW");
			}	
		}	
		if(deleteCount>0)
			{
			getErrorMap().put("somekey", deleteCount+" records deleted.");
			getErrorMap().put("current", deleteCount+" records deleted.");
			}
			lastUpdatedRowIndex = -1;
		
		return "row(s)Deleted";
	}

	

	
	public void AddRow(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){	
				/*String repId = getPM_CUSTOMIZED_REPORT_BEAN().getREP_ID();
				String repDesc = compositeAction.getPM_IL_CUSTOM_MASTER_REPORT_ACTION_BEAN().getPM_CUSTOMIZED_REPORT_BEAN().getREP_DESC();
				
*/
				PM_CUSTOMIZED_REPORT_BEAN = new PM_CUSTOMIZED_REPORT();
			/*	PM_CUSTOMIZED_REPORT_BEAN.setREP_ID(repId);
				PM_CUSTOMIZED_REPORT_BEAN.setREP_DESC(repDesc);*/
				resetAllComponent();
				resetSelectedRow();
			}else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void doValidateReportId(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_CUSTOMIZED_REPORT_BEAN.setREP_ID((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	
	public void doValidateReportDesc(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException{
		CommonUtils.clearMaps(this);
		try {
			PM_CUSTOMIZED_REPORT_BEAN.setREP_DESC((String)value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	public void resetAllComponent(){
		 COMP_REP_ID_TEXT.resetValue();
		 COMP_REP_DESC.resetValue(); 	
	}

	public PM_CUSTOMIZED_REPORT getPM_CUSTOMIZED_REPORT_BEAN() {
		return PM_CUSTOMIZED_REPORT_BEAN;
	}

	public void setPM_CUSTOMIZED_REPORT_BEAN(PM_CUSTOMIZED_REPORT pM_CUSTOMIZED_REPORT_BEAN) {
		PM_CUSTOMIZED_REPORT_BEAN = pM_CUSTOMIZED_REPORT_BEAN;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}


	public List<PM_CUSTOMIZED_REPORT> getTableList() {
		return tableList;
	}
	public void setTableList(List<PM_CUSTOMIZED_REPORT> tableList) {
		this.tableList = tableList;
	}
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public PM023_A_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PM023_A_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public HtmlOutputLabel getCOMP_REP_ID_LABEL() {
		return COMP_REP_ID_LABEL;
	}

	public void setCOMP_REP_ID_LABEL(HtmlOutputLabel cOMP_REP_ID_LABEL) {
		COMP_REP_ID_LABEL = cOMP_REP_ID_LABEL;
	}

	

	public HtmlOutputLabel getCOMP_REP_DESC_LABEL() {
		return COMP_REP_DESC_LABEL;
	}
	public void setCOMP_REP_DESC_LABEL(HtmlOutputLabel cOMP_REP_DESC_LABEL) {
		COMP_REP_DESC_LABEL = cOMP_REP_DESC_LABEL;
	}
	public HtmlInputText getCOMP_REP_ID_TEXT() {
		return COMP_REP_ID_TEXT;
	}

	public void setCOMP_REP_ID_TEXT(HtmlInputText cOMP_REP_ID_TEXT) {
		COMP_REP_ID_TEXT = cOMP_REP_ID_TEXT;
	}
	public HtmlInputText getCOMP_REP_DESC() {
		return COMP_REP_DESC;
	}
	public void setCOMP_REP_DESC(HtmlInputText cOMP_REP_DESC) {
		COMP_REP_DESC = cOMP_REP_DESC;
	}
	public HtmlCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}
	public void setUI_M_BUT_ADD(HtmlCommandButton uI_M_BUT_ADD) {
		UI_M_BUT_ADD = uI_M_BUT_ADD;
	}
	public HtmlCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}
	public void setUI_M_BUT_POST(HtmlCommandButton uI_M_BUT_POST) {
		UI_M_BUT_POST = uI_M_BUT_POST;
	}
	public HtmlCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}
	public void setUI_M_BUT_DELETE(HtmlCommandButton uI_M_BUT_DELETE) {
		UI_M_BUT_DELETE = uI_M_BUT_DELETE;
	}



}
