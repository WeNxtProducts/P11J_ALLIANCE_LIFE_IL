package com.iii.pel.forms.PT044_A;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UISelectOne;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_POL_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_APD_POL_DS_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_APD_POL_DS_TYPE;

	private HtmlOutputLabel COMP_APD_POBH_COMM_CODE_LABEL;

	private HtmlInputText COMP_APD_POBH_COMM_CODE;
	private HtmlInputText COMP_APD_POBH_COMM_CODE_DESC;

	private HtmlOutputLabel COMP_APD_POL_END_NO_LABEL;

	private HtmlInputText COMP_APD_POL_END_NO;

	private HtmlOutputLabel COMP_APD_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_APD_FLAG;

	private HtmlOutputLabel COMP_UI_M_POL_START_DT_LABEL;

	private HtmlCalendar COMP_UI_M_POL_START_DT;

	private HtmlOutputLabel COMP_UI_M_APD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_APD_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_POL_CONT_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POL_CONT_CODE;

	private HtmlOutputLabel COMP_UI_M_POL_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_UI_M_POL_ASSURED_NAME;
	private HtmlInputText COMP_UI_M_POL_ASSURED_NAME_DESC;
	
	private PT_AGENT_POL_DTLS PT_AGENT_POL_DTLS_BEAN;
	
	public PT044_A_COMPOSITE_ACTION compositeAction;

	private UIDataTable dataTable;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	
	
	
	private String  filterByUI_M_POL_NO ;
	private String  filterByUI_M_POL_CONT_CODE ;
	private String  filterByAPD_POBH_COMM_CODE;
	
	private int recordsPerPage = PELConstants.datatableRecordSize;

	private int lastUpdatedRowIndex;

	private int prevRowIndex;

	private int currPage;

	ArrayList<PT_AGENT_POL_DTLS> list = new ArrayList<PT_AGENT_POL_DTLS>();
	
	List<SelectItem> itemAPD_POL_DS_TYPE =null;
	List<SelectItem> itemAPD_FLAG =null;
	
	
	/*added by nadhiya on 30.3.2016*/
	
ArrayList<PT_AGENT_POL_DTLS> templist = new ArrayList<PT_AGENT_POL_DTLS>();
	




	public HtmlInputText getCOMP_APD_POBH_COMM_CODE_DESC() {
	return COMP_APD_POBH_COMM_CODE_DESC;
}

public void setCOMP_APD_POBH_COMM_CODE_DESC(
		HtmlInputText cOMP_APD_POBH_COMM_CODE_DESC) {
	COMP_APD_POBH_COMM_CODE_DESC = cOMP_APD_POBH_COMM_CODE_DESC;
}

public HtmlInputText getCOMP_UI_M_POL_ASSURED_NAME_DESC() {
	return COMP_UI_M_POL_ASSURED_NAME_DESC;
}

public void setCOMP_UI_M_POL_ASSURED_NAME_DESC(
		HtmlInputText cOMP_UI_M_POL_ASSURED_NAME_DESC) {
	COMP_UI_M_POL_ASSURED_NAME_DESC = cOMP_UI_M_POL_ASSURED_NAME_DESC;
}

	public ArrayList<PT_AGENT_POL_DTLS> getTemplist() {
		return templist;
	}

	public void setTemplist(ArrayList<PT_AGENT_POL_DTLS> templist) {
		this.templist = templist;
	}
	private HtmlSelectOneMenu COMP_POL_DS_TYPE;

public HtmlSelectOneMenu getCOMP_POL_DS_TYPE() {
		return COMP_POL_DS_TYPE;
	}

	public void setCOMP_POL_DS_TYPE(HtmlSelectOneMenu cOMP_POL_DS_TYPE) {
		COMP_POL_DS_TYPE = cOMP_POL_DS_TYPE;
	}

	
	/*end*/
	
	

	public PT_AGENT_POL_DTLS_ACTION() {
		
		PT_AGENT_POL_DTLS_BEAN = new PT_AGENT_POL_DTLS();
		itemAPD_POL_DS_TYPE = PT044_A_DELEGATE.getDropDownListValue("PT044_A","PT_AGENT_POL_DTLS","PT_AGENT_POL_DTLS.APD_POL_DS_TYPE","DOC_TYPE");
		itemAPD_FLAG = PT044_A_DELEGATE.getDropDownListValue("PT044_A","PT_AGENT_POL_DTLS","PT_AGENT_POL_DTLS.APD_FLAG","YESNO");
		
		prevRowIndex = 0;
		currPage = 1;
		
		/*added by nadhiya on 30.3.2016*/
		initializeComponents();
		
		/*end*/
		disable();
		postButtonShow();
		
		
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_LABEL) {
		this.COMP_UI_M_POL_NO_LABEL = COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText COMP_UI_M_POL_NO) {
		this.COMP_UI_M_POL_NO = COMP_UI_M_POL_NO;
	}

	public HtmlOutputLabel getCOMP_APD_POL_DS_TYPE_LABEL() {
		return COMP_APD_POL_DS_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APD_POL_DS_TYPE() {
		return COMP_APD_POL_DS_TYPE;
	}

	public void setCOMP_APD_POL_DS_TYPE_LABEL(HtmlOutputLabel COMP_APD_POL_DS_TYPE_LABEL) {
		this.COMP_APD_POL_DS_TYPE_LABEL = COMP_APD_POL_DS_TYPE_LABEL;
	}

	public void setCOMP_APD_POL_DS_TYPE(HtmlSelectOneMenu COMP_APD_POL_DS_TYPE) {
		this.COMP_APD_POL_DS_TYPE = COMP_APD_POL_DS_TYPE;
	}

	public HtmlOutputLabel getCOMP_APD_POBH_COMM_CODE_LABEL() {
		return COMP_APD_POBH_COMM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APD_POBH_COMM_CODE() {
		return COMP_APD_POBH_COMM_CODE;
	}

	public void setCOMP_APD_POBH_COMM_CODE_LABEL(HtmlOutputLabel COMP_APD_POBH_COMM_CODE_LABEL) {
		this.COMP_APD_POBH_COMM_CODE_LABEL = COMP_APD_POBH_COMM_CODE_LABEL;
	}

	public void setCOMP_APD_POBH_COMM_CODE(HtmlInputText COMP_APD_POBH_COMM_CODE) {
		this.COMP_APD_POBH_COMM_CODE = COMP_APD_POBH_COMM_CODE;
	}

	public HtmlOutputLabel getCOMP_APD_POL_END_NO_LABEL() {
		return COMP_APD_POL_END_NO_LABEL;
	}

	public HtmlInputText getCOMP_APD_POL_END_NO() {
		return COMP_APD_POL_END_NO;
	}

	public void setCOMP_APD_POL_END_NO_LABEL(HtmlOutputLabel COMP_APD_POL_END_NO_LABEL) {
		this.COMP_APD_POL_END_NO_LABEL = COMP_APD_POL_END_NO_LABEL;
	}

	public void setCOMP_APD_POL_END_NO(HtmlInputText COMP_APD_POL_END_NO) {
		this.COMP_APD_POL_END_NO = COMP_APD_POL_END_NO;
	}

	public HtmlOutputLabel getCOMP_APD_FLAG_LABEL() {
		return COMP_APD_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APD_FLAG() {
		return COMP_APD_FLAG;
	}

	public void setCOMP_APD_FLAG_LABEL(HtmlOutputLabel COMP_APD_FLAG_LABEL) {
		this.COMP_APD_FLAG_LABEL = COMP_APD_FLAG_LABEL;
	}

	public void setCOMP_APD_FLAG(HtmlSelectOneMenu COMP_APD_FLAG) {
		this.COMP_APD_FLAG = COMP_APD_FLAG;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_START_DT_LABEL() {
		return COMP_UI_M_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_POL_START_DT() {
		return COMP_UI_M_POL_START_DT;
	}

	public void setCOMP_UI_M_POL_START_DT_LABEL(HtmlOutputLabel COMP_UI_M_POL_START_DT_LABEL) {
		this.COMP_UI_M_POL_START_DT_LABEL = COMP_UI_M_POL_START_DT_LABEL;
	}

	public void setCOMP_UI_M_POL_START_DT(HtmlCalendar COMP_UI_M_POL_START_DT) {
		this.COMP_UI_M_POL_START_DT = COMP_UI_M_POL_START_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_APD_CODE_DESC_LABEL() {
		return COMP_UI_M_APD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_APD_CODE_DESC() {
		return COMP_UI_M_APD_CODE_DESC;
	}

	public void setCOMP_UI_M_APD_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_APD_CODE_DESC_LABEL) {
		this.COMP_UI_M_APD_CODE_DESC_LABEL = COMP_UI_M_APD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_APD_CODE_DESC(HtmlInputText COMP_UI_M_APD_CODE_DESC) {
		this.COMP_UI_M_APD_CODE_DESC = COMP_UI_M_APD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CONT_CODE_LABEL() {
		return COMP_UI_M_POL_CONT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CONT_CODE() {
		return COMP_UI_M_POL_CONT_CODE;
	}

	public void setCOMP_UI_M_POL_CONT_CODE_LABEL(HtmlOutputLabel COMP_UI_M_POL_CONT_CODE_LABEL) {
		this.COMP_UI_M_POL_CONT_CODE_LABEL = COMP_UI_M_POL_CONT_CODE_LABEL;
	}

	public void setCOMP_UI_M_POL_CONT_CODE(HtmlInputText COMP_UI_M_POL_CONT_CODE) {
		this.COMP_UI_M_POL_CONT_CODE = COMP_UI_M_POL_CONT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_ASSURED_NAME_LABEL() {
		return COMP_UI_M_POL_ASSURED_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_ASSURED_NAME() {
		return COMP_UI_M_POL_ASSURED_NAME;
	}

	public void setCOMP_UI_M_POL_ASSURED_NAME_LABEL(HtmlOutputLabel COMP_UI_M_POL_ASSURED_NAME_LABEL) {
		this.COMP_UI_M_POL_ASSURED_NAME_LABEL = COMP_UI_M_POL_ASSURED_NAME_LABEL;
	}

	public void setCOMP_UI_M_POL_ASSURED_NAME(HtmlInputText COMP_UI_M_POL_ASSURED_NAME) {
		this.COMP_UI_M_POL_ASSURED_NAME = COMP_UI_M_POL_ASSURED_NAME;
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public ArrayList<PT_AGENT_POL_DTLS> getList() {
		
		return list;
	}

	public void setList(ArrayList<PT_AGENT_POL_DTLS> list) {
		
		this.list = list;
	}
	
	public String getCurrentValue(ActionEvent event) {
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}
	
	

	public String getCurrentSelectedValue(ActionEvent event) {
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		String value = null;
		UISelectOne input = null;
		if (event != null) {
			input = (UISelectOne) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in selected field is : " + value);
			}
		}
		return value;
	}
	public String checkBoxStatus(ActionEvent actionEvent) {
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setCHECK_BOX(check);
		return "";
	}

	public void checkBoxValidation(ActionEvent event) {
		//[Method is commented for the 
		//gridtabListener();
	}

	public String checkBoxFlagStatus(ActionEvent actionEvent) {
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		String checkValue = getCurrentValue(actionEvent);
		String assignCheckValue = "";
		if ("true".equalsIgnoreCase(checkValue)) {
			assignCheckValue = "Y";
		} else {
			assignCheckValue = "N";
		}

		int rowIndex = getDataTable().getRowIndex();

		return "";
	}
	//[Method is commented for the new tab implementation by the Phanikumar dated 16-feb-2006]
	/*private void gridtabListener() {
		int currRowIndex  =getDataTable().getRowIndex();
		PT044_A_DELEGATE delegate =null;
		int rowUpdated =0;
		PT_AGENT_POL_DTLS detailBean = null;
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex == 0) {
						if (currRowIndex != prevRowIndex) {
							detailBean = new PT_AGENT_POL_DTLS();
							delegate = new PT044_A_DELEGATE();
							detailBean = (PT_AGENT_POL_DTLS) list.get(prevRowIndex);
							rowUpdated = delegate.updatePolicyDetails(detailBean);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("Unable to Insert", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
	}*/
	public String addNew() {
		int rowCount = 0;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		PT_AGENT_POL_DTLS localBean = null; 
		if (list == null) {
			list = new ArrayList<PT_AGENT_POL_DTLS>();
		}
		localBean = new PT_AGENT_POL_DTLS();
		delegate.loaddefalutDetailValues(localBean);
		list.add(localBean);
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return null;
	}
	
	public void getDetails() {
		try {
			if ( list.size() != 0) {				
				 this.PT_AGENT_POL_DTLS_BEAN = (PT_AGENT_POL_DTLS) dataTable.getRowData();
			}
			resetAllComponent();			
			resetSelectedRow();
			this.PT_AGENT_POL_DTLS_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		 COMP_APD_POBH_COMM_CODE.resetValue();
		 COMP_APD_FLAG.resetValue();
		 COMP_APD_POL_DS_TYPE.resetValue();
		 COMP_APD_POL_END_NO.resetValue();
		 COMP_UI_M_APD_CODE_DESC.resetValue();
		 COMP_UI_M_POL_ASSURED_NAME.resetValue();
		 COMP_UI_M_POL_CONT_CODE.resetValue();
		 COMP_UI_M_POL_NO.resetValue();
		 COMP_UI_M_POL_START_DT.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PT_AGENT_POL_DTLS>  iterator = list.iterator();
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	public String deleteRow() {
		PT_AGENT_POL_DTLS bean = null;
		ArrayList deletedRecordList = null;
		PT044_A_DELEGATE delegate =new PT044_A_DELEGATE();
		int deletedRecordIndex = 0;
		if (list != null) {
			deletedRecordList = new ArrayList();
			for (int index = 0; index < list.size();) {
				bean = list.get(index);
				if (bean.isCHECK_BOX()) {
					list.remove(bean);
					deletedRecordIndex = delegate.deletePolicyDetails(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if (deletedRecordList.size() > 0) {
				getErrorMap().put("SuccesFully", deletedRecordList.size()+ " records deleted.");
				getErrorMap().put("current", deletedRecordList.size()+ " records deleted.");
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}
	
	//save or update the record
	public void post(ActionEvent ae) {
		int rowUpdated=0;
		PT044_A_DELEGATE delegate =new PT044_A_DELEGATE();
		try{
			 System.out.println("getROWID in Policy Action          "+compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().getPT_AGENT_POL_DTLS_BEAN().getROWID());
			if(PT_AGENT_POL_DTLS_BEAN.getROWID()!=null){
				if(isUPDATE_ALLOWED()) {
					delegate.pt_agent_pol_dtls_pre_update(PT_AGENT_POL_DTLS_BEAN);
					rowUpdated = delegate.updatePolicyDetails(PT_AGENT_POL_DTLS_BEAN);
					if(rowUpdated>0)
					{
						getWarningMap().put("current",Messages.getString("messageProperties", "errorPanel$message$update"));
						getWarningMap().put("post", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					}
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			}else{
				if(isINSERT_ALLOWED()) {
					delegate.pt_agent_pol_dtls_pre_insert(PT_AGENT_POL_DTLS_BEAN);
					rowUpdated = delegate.updatePolicyDetails(PT_AGENT_POL_DTLS_BEAN);
					if(rowUpdated>0)
					{
						list.add(PT_AGENT_POL_DTLS_BEAN);
						getWarningMap().put("current",Messages.getString("messageProperties", "errorPanel$message$insert"));
						getWarningMap().put("post", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					}
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			
			CommonUtils.getConnection().commit();
			resetAllComponent();
			resetSelectedRow();
			PT_AGENT_POL_DTLS_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	public void lastColumnListener(){
		int currRowIndex = getDataTable().getRowIndex();
		PT044_A_DELEGATE delegate =new PT044_A_DELEGATE();
		int rowUpdated = 0;
		PT_AGENT_POL_DTLS gridValueBean = null;
		String rowId = null;
		String successMessage  = null;
		try {
				gridValueBean = (PT_AGENT_POL_DTLS)list.get(currRowIndex);
				rowId = gridValueBean.getROWID();
				if(rowId == null){
					delegate.pt_agent_pol_dtls_pre_insert(gridValueBean);
				}else{
					delegate.pt_agent_pol_dtls_pre_update(gridValueBean);
				}
				
				rowUpdated = delegate.updatePolicyDetails(gridValueBean);
				if (rowId == null) {
					successMessage = Messages.getString("messageProperties", "errorPanel$message$save");
					getWarningMap().put("details", successMessage);
					getWarningMap().put("current", successMessage);
				}else{
					successMessage= Messages.getString("messageProperties", "errorPanel$message$update");
					getWarningMap().put("details", successMessage);
					getWarningMap().put("current", successMessage);
				}
				lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}

	public List<SelectItem> getItemAPD_POL_DS_TYPE() {
		return itemAPD_POL_DS_TYPE;
	}

	public void setItemAPD_POL_DS_TYPE(List<SelectItem> itemAPD_POL_DS_TYPE) {
		this.itemAPD_POL_DS_TYPE = itemAPD_POL_DS_TYPE;
	}

	public List<SelectItem> getItemAPD_FLAG() {
		return itemAPD_FLAG;
	}

	public void setItemAPD_FLAG(List<SelectItem> itemAPD_FLAG) {
		this.itemAPD_FLAG = itemAPD_FLAG;
	}
	public void validatePolicyNumber(ActionEvent event){
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		String UI_M_POL_NO = getCurrentValue(event);
		/*Commented by Nathiya on 30-3-2016 for Datatable updateion issue
		getCurrentBean().setUI_M_POL_NO(UI_M_POL_NO);
		End*/
		//gridtabListener();
	}
	public void validateDsType(ActionEvent event){
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		String APD_POL_DS_TYPE = getCurrentSelectedValue(event);
		/*Commented by Nathiya on 30-3-2016 for Datatable updateion issue
		getCurrentBean().setAPD_POL_DS_TYPE(APD_POL_DS_TYPE);
		End*/
		//gridtabListener();
	}
	public void validateCommCode(ActionEvent event){
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		String APD_POBH_COMM_CODE = getCurrentValue(event);
		/*Commented by Nathiya on 30-3-2016 for Datatable updateion issue
		getCurrentBean().setAPD_POBH_COMM_CODE(APD_POBH_COMM_CODE);
		End*/
		//gridtabListener();
	}
	public void validateAPD_POL_END_NO(ActionEvent event){
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		String APD_POL_END_NO = getCurrentValue(event);
		/*Commented by Nathiya on 30-3-2016 for Datatable updateion issue
		getCurrentBean().setAPD_POL_END_NO(APD_POL_END_NO);
		End*/
		//gridtabListener();
	}
	public void validateAPD_FLAG(ActionEvent event){
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		String APD_FLAG = getCurrentSelectedValue(event);
		//System.out.println("orw id in flag change      "+get);
		getPT_AGENT_POL_DTLS_BEAN().setAPD_FLAG(APD_FLAG);
		
		System.out.println("row id in flag change            "+getPT_AGENT_POL_DTLS_BEAN().getROWID());
		/*Commented by Nathiya on 30-3-2016 for Datatable updateion issue
		getCurrentBean().setAPD_FLAG(APD_FLAG);
		End*/
		//lastColumnListener();
	}
	public void validateCUSTDOB(ActionEvent event){
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		HtmlCalendar inputValue = (HtmlCalendar) event.getComponent().getParent();
		ErrorHelpUtil.validate(inputValue, getErrorMap());
	}
	public void validateStartDate(FacesContext context, UIComponent component,Object value){
		//UI_M_POL_START_DT
		
		PT_AGENT_POL_DTLS localBean = getCurrentBean();
		localBean.setUI_M_POL_START_DT((Date) value);
		//gridtabListener();
	}
	public void validateContCode(ActionEvent event){
		//[CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation
		CommonUtils.clearMaps(this);
		//CommonUtils.clearMaps(this); is added by the Phanikumar dated 16-feb-2009 for the new tab implementation]
		String UI_M_POL_CONT_CODE = getCurrentValue(event);
		/*Commented by Nathiya on 30-3-2016 for Datatable updateion issue
		getCurrentBean().setUI_M_POL_CONT_CODE(UI_M_POL_CONT_CODE);
		End*/
		//gridtabListener();
	}
	
	public PT_AGENT_POL_DTLS getCurrentBean(){
		//int rowIndex = getDataTable().getRowIndex(); 
		return PT_AGENT_POL_DTLS_BEAN; //list.get(rowIndex);
	}
	public String saveRecord(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// [ Added for grid implementation change, Added by: Phanikumar, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	// Added for grid implementation change, Added by: Phanikumar, Dated: 16-Feb-2009 ]

	public PT_AGENT_POL_DTLS getPT_AGENT_POL_DTLS_BEAN() {
		return PT_AGENT_POL_DTLS_BEAN;
	}

	public void setPT_AGENT_POL_DTLS_BEAN(PT_AGENT_POL_DTLS pt_agent_pol_dtls_bean) {
		PT_AGENT_POL_DTLS_BEAN = pt_agent_pol_dtls_bean;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public String getFilterByUI_M_POL_NO() {
		return filterByUI_M_POL_NO;
	}

	public void setFilterByUI_M_POL_NO(String filterByUI_M_POL_NO) {
		this.filterByUI_M_POL_NO = filterByUI_M_POL_NO;
	}

	public String getFilterByUI_M_POL_CONT_CODE() {
		return filterByUI_M_POL_CONT_CODE;
	}

	public void setFilterByUI_M_POL_CONT_CODE(String filterByUI_M_POL_CONT_CODE) {
		this.filterByUI_M_POL_CONT_CODE = filterByUI_M_POL_CONT_CODE;
	}

	public String getFilterByAPD_POBH_COMM_CODE() {
		return filterByAPD_POBH_COMM_CODE;
	}

	public void setFilterByAPD_POBH_COMM_CODE(String filterByAPD_POBH_COMM_CODE) {
		this.filterByAPD_POBH_COMM_CODE = filterByAPD_POBH_COMM_CODE;
	}
	
	
	/*added by nadhiya on 30.3.2016*/
	
	
	private HtmlAjaxCommandButton UI_M_SELECT_ALL;
	private HtmlAjaxCommandButton UI_M_UNSELECT_ALL;
	
	private HtmlOutputLabel COMP_M_PRINT_YN_LABEL;
	
	private HtmlSelectBooleanCheckbox COMP_M_PRINT_YN;
	
	
	
	public HtmlSelectBooleanCheckbox getCOMP_M_PRINT_YN() {
		return COMP_M_PRINT_YN;
	}

	public void setCOMP_M_PRINT_YN(HtmlSelectBooleanCheckbox cOMP_M_PRINT_YN) {
		COMP_M_PRINT_YN = cOMP_M_PRINT_YN;
	}

	public HtmlOutputLabel getCOMP_M_PRINT_YN_LABEL() {
		return COMP_M_PRINT_YN_LABEL;
	}

	public void setCOMP_M_PRINT_YN_LABEL(HtmlOutputLabel cOMP_M_PRINT_YN_LABEL) {
		COMP_M_PRINT_YN_LABEL = cOMP_M_PRINT_YN_LABEL;
	}

	public HtmlAjaxCommandButton getUI_M_SELECT_ALL() {
		return UI_M_SELECT_ALL;
	}

	public void setUI_M_SELECT_ALL(HtmlAjaxCommandButton uI_M_SELECT_ALL) {
		UI_M_SELECT_ALL = uI_M_SELECT_ALL;
	}

	public HtmlAjaxCommandButton getUI_M_UNSELECT_ALL() {
		return UI_M_UNSELECT_ALL;
	}

	public void setUI_M_UNSELECT_ALL(HtmlAjaxCommandButton uI_M_UNSELECT_ALL) {
		UI_M_UNSELECT_ALL = uI_M_UNSELECT_ALL;
	}
	private HtmlAjaxCommandButton UI_M_PRINT;
	public HtmlAjaxCommandButton getUI_M_PRINT() {
		return UI_M_PRINT;
	}

	public void setUI_M_PRINT(HtmlAjaxCommandButton uI_M_PRINT) {
		UI_M_PRINT = uI_M_PRINT;
	}
	
	public void initializeComponents()
	{
		System.out.println("initialize Components");
		UI_M_SELECT_ALL = new HtmlAjaxCommandButton();
		UI_M_UNSELECT_ALL = new HtmlAjaxCommandButton();
		UI_M_BUT_POST=new HtmlAjaxCommandButton();
		COMP_APD_POBH_COMM_CODE = new HtmlInputText();
		COMP_APD_POBH_COMM_CODE_DESC=new HtmlInputText();
		 COMP_APD_FLAG = new HtmlSelectOneMenu();
		 COMP_APD_POL_DS_TYPE = new HtmlSelectOneMenu();
		 COMP_APD_POL_END_NO = new HtmlInputText();
		 COMP_UI_M_APD_CODE_DESC = new HtmlInputText();
		 COMP_UI_M_POL_ASSURED_NAME = new HtmlInputText();
		 COMP_UI_M_POL_ASSURED_NAME_DESC=new HtmlInputText();
		 COMP_UI_M_POL_CONT_CODE = new HtmlInputText();
		 COMP_UI_M_POL_NO = new HtmlInputText();
		 COMP_UI_M_POL_START_DT = new HtmlCalendar();
	}
	
	
	public void selectbutton(ActionEvent ae)
	{
		System.out.println("Inside select button");
		templist = getList();
		compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setList(new ArrayList());
		/*Iterator<PT_AGENT_POL_DTLS>  iterate = templist.iterator();*/
		Iterator<PT_AGENT_POL_DTLS>  iterate = templist.iterator();
		while(iterate.hasNext()){
			PT_AGENT_POL_DTLS obj1=(PT_AGENT_POL_DTLS)iterate.next();

			obj1.setAPD_PRINT_YN("Y");
			obj1.setFreezeFlag(true);
			//comment
			compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().getList().add(obj1);
			
			/*compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setTemplist(new ArrayList());
			compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setTemplist(templist);*/
			
			
		}
		iterate = compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().getList().iterator();
		while(iterate.hasNext()){
			PT_AGENT_POL_DTLS obj1=(PT_AGENT_POL_DTLS)iterate.next();
			System.out.println("obj1.iterate         "+obj1.getAPD_PRINT_YN());
		}
		/*compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setTemplist(new ArrayList());
		compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setTemplist(templist);*/
		
		
		 
		
		getUI_M_SELECT_ALL().setDisabled(true);
		getUI_M_UNSELECT_ALL().setDisabled(false);
	}
	
	public void unselect(ActionEvent ae)
	{
		System.out.println("Inside Unselect button");
		/*Iterator<PT_AGENT_POL_DTLS>  iterate = templist.iterator();*/
		templist = getList();
		compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setList(new ArrayList());
		Iterator<PT_AGENT_POL_DTLS>  iterate = templist.iterator();
		while(iterate.hasNext()){
			PT_AGENT_POL_DTLS obj1=(PT_AGENT_POL_DTLS)iterate.next();
			obj1.setAPD_PRINT_YN("N");
			obj1.setFreezeFlag(false);
			compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().getList().add(obj1);
			
			/*compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setTemplist(new ArrayList());
			compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setTemplist(templist);*/
			
			
		}
		/*compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setTemplist(new ArrayList());
		compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setTemplist(templist);*/
	 
		getUI_M_SELECT_ALL().setDisabled(false);
		getUI_M_UNSELECT_ALL().setDisabled(true);
		
	
	}
	
	
	public void runreport(ActionEvent ae)
	{
		String message = null;
		System.out.println("Inside runreport button");
		 System.out.println(compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().getList()+"          "+templist);
		Iterator<PT_AGENT_POL_DTLS>  iterate = compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().getList().iterator();
		int count = 0;
		while(iterate.hasNext()){
			PT_AGENT_POL_DTLS obj1=(PT_AGENT_POL_DTLS)iterate.next();
	
			System.out.println("obj1.getAPD_PRINT_YN()        "+obj1.getAPD_PRINT_YN());
			  if(obj1.getAPD_PRINT_YN() != null && obj1.getAPD_PRINT_YN().equals("Y"))
			 {
				  System.out.println("Insert Record Here");
				  count++;
				 String P_POL_NO = PT_AGENT_POL_DTLS_BEAN.getUI_M_POL_NO();
				 String P_NEW_AGENT_CODE = compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN().getATH_AGENT_CODE();
				/* String P_NEW_AGENT_NAME;*/
				 String P_ASSIGN_FLAG = PT_AGENT_POL_DTLS_BEAN.getAPD_FLAG();
				 String P_TRAN_DATE = CommonUtils.dateToStringFormatter(
						 compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN().getATH_DATE());
				 String P_PRINT_YN = PT_AGENT_POL_DTLS_BEAN.getAPD_PRINT_YN();
				 
				 System.out.println("P_POL_NO     "+P_POL_NO);
				 System.out.println("P_ASSIGN_FLAG     "+P_ASSIGN_FLAG);
				 System.out.println("P_TRAN_DATE     "+P_TRAN_DATE);
				 System.out.println("P_PRINT_YN     "+P_PRINT_YN);
				 System.out.println("P_NEW_AGENT_CODE      "+P_NEW_AGENT_CODE);
				 /* String ATH_DATE=PT_AGENT_POL_DTLS_BEAN.getUI_M_POL_START_DT().toString();
				 String ATD_AGENT_CODE=PT_AGENT_POL_DTLS_BEAN.get*/
				 
				 
				  
				 try {
					callResetProc(P_TRAN_DATE,P_NEW_AGENT_CODE,P_ASSIGN_FLAG,P_PRINT_YN,P_POL_NO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 } 
				
			 }
		System.out.println("count          "+count);
			if(count > 0)
			{
				message = "Record Saved Successfully"; 
				getWarningMap().put("runreport",message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);		
			}
			else
			{
				message = "No records are Selected"; 
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getErrorMap().put("runreport", message);
			
			}
			
		}
		 
	public void callResetProc(String ATH_DATE,String ATD_AGENT_CODE,String ATH_APPRV_FLAG,String APD_PRINT_YN,String UI_M_POL_NO ) throws Exception {    
		 Connection con=CommonUtils.getConnection();					
							ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
							ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
							/*OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",current);*/
							OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",UI_M_POL_NO);
							OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",ATD_AGENT_CODE);
							/*OracleParameter param3 = new OracleParameter("IN2", "STRING", "IN",AGENT_NAME);*/
							OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",ATH_APPRV_FLAG);
							OracleParameter param4 = new OracleParameter("IN4", "DATE", "IN",ATH_DATE);
							OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",APD_PRINT_YN);
						    parameterList.add(param1);
						    parameterList.add(param2);
						    parameterList.add(param3);
						    parameterList.add(param4);
						    parameterList.add(param5);
						    OracleProcedureHandler procHandler = new OracleProcedureHandler();
						    outputList = procHandler.execute(parameterList, con,
						            "P_AGNT_TRAN_INS");
						    Iterator<OracleParameter> iterator = outputList.iterator();
						    while (iterator.hasNext()) {
						        OracleParameter oracleParameter = iterator.next();
						        System.out.println("Output value:::" + oracleParameter.getValue());
								}
						    CommonUtils.getConnection().commit();
		   
			
		}
		
public void validateM_PRINT_YN_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				PT_AGENT_POL_DTLS_BEAN.setAPD_PRINT_YN("Y");
			} else {
				PT_AGENT_POL_DTLS_BEAN.setAPD_PRINT_YN("N");	
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	
	/*end*/
	
	public void disable()
	{
		if("T".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1")))
		{
			System.out.println("insert into if condition");
			
		COMP_APD_POBH_COMM_CODE.setDisabled(true);
		COMP_APD_POBH_COMM_CODE_DESC.setDisabled(true);
		COMP_APD_POL_DS_TYPE.setDisabled(true);
		 COMP_UI_M_POL_START_DT.setDisabled(true);
		 COMP_UI_M_POL_NO.setDisabled(true);
		 COMP_UI_M_POL_ASSURED_NAME.setDisabled(true);
		 COMP_UI_M_POL_ASSURED_NAME_DESC.setDisabled(true);
		 COMP_APD_POL_END_NO.setDisabled(true);
		}
	}
	
	
	public void postButtonShow()
	{
		
			UI_M_BUT_POST.setRendered(true);
			
		}
	
	
}
