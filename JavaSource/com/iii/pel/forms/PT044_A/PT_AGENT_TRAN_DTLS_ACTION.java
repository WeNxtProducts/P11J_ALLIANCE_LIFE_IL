package com.iii.pel.forms.PT044_A;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_TRAN_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ATD_AGENT_CODE_LABEL;

	private HtmlInputText COMP_ATD_AGENT_CODE;
	private HtmlInputText COMP_ATD_AGENT_CODE_DESC;

	private HtmlOutputLabel COMP_ATD_OLD_PARENT_CODE_LABEL;

	private HtmlInputText COMP_ATD_OLD_PARENT_CODE;
	private HtmlInputText COMP_ATD_OLD_PARENT_CODE_DESC;


	private HtmlOutputLabel COMP_ATD_OLD_AGENCY_CODE_LABEL;

	private HtmlInputText COMP_ATD_OLD_AGENCY_CODE;

	private HtmlOutputLabel COMP_ATD_NEW_PARENT_CODE_LABEL;

	private HtmlInputText COMP_ATD_NEW_PARENT_CODE;
	private HtmlInputText COMP_ATD_NEW_PARENT_CODE_DESC;
	
	private HtmlInputText COMP_ATD_NEW_PARENT_CODE_1;

	private HtmlOutputLabel COMP_ATD_NEW_AGENCY_CODE_LABEL;

	private HtmlInputText COMP_ATD_NEW_AGENCY_CODE;
	private HtmlInputText COMP_ATD_NEW_AGENCY_CODE_DESC;

	private HtmlOutputLabel COMP_ATD_NEW_UNIT_CODE_LABEL;

	private HtmlInputText COMP_ATD_NEW_UNIT_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_NAME;

	private HtmlOutputLabel COMP_UI_M_ATD_NEW_PARENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ATD_NEW_PARENT_NAME;

	private HtmlOutputLabel COMP_UI_M_OLD_PARENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_OLD_PARENT_NAME;

	private HtmlOutputLabel COMP_UI_M_ATD_NEW_AGENCY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ATD_NEW_AGENCY_NAME;

	private HtmlOutputLabel COMP_UI_M_OLD_AGENCY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_OLD_AGENCY_NAME;

	private HtmlOutputLabel COMP_UI_M_NEW_UNIT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_NEW_UNIT_DESC;

	private PT_AGENT_TRAN_DTLS PT_AGENT_TRAN_DTLS_BEAN;
	
	public PT044_A_COMPOSITE_ACTION compositeAction;

	private UIDataTable dataTable;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	
	private String filterByATD_AGENT_CODE ;
	private String filterByUI_M_AGENT_NAME;
	private String filterByUI_M_OLD_PARENT_NAME ;
	private String filterByATD_OLD_PARENT_CODE ;
	private String filterByATD_NEW_PARENT_CODE ;
	private String filterByATD_OLD_AGENCY_CODE ;
	private String filterByUI_M_ATD_NEW_PARENT_NAME ;
	
	private int recordsPerPage = PELConstants.datatableRecordSize;

	private int lastUpdatedRowIndex;

	private int prevRowIndex;

	private int currPage;
	private List<PT_AGENT_TRAN_DTLS> locConditionList = null;
	private ArrayList<PT_AGENT_TRAN_DTLS> list = new ArrayList<PT_AGENT_TRAN_DTLS>();
	
	/*private boolean compAtdAgentCodeDisabled;
	
	private boolean compUiMAgentNameDisabled;
	
	private boolean compAtdOldParentCodeDisabled;
	
	private boolean compUiMOldParentNameDisabled;
	
	private boolean compAtdOldAgencyCodeDisabled;
	
	private boolean compAtdNewParentCodeDisabled;
	
	private boolean compUiMAtdNewAgencyNameDisabled;
	
	private boolean compAtdNewAgencyCodeDisabled;
	
	private boolean compUiMOldAgencyNameDisabled;*/

	public PT_AGENT_TRAN_DTLS_ACTION() {
		PT_AGENT_TRAN_DTLS_BEAN = new PT_AGENT_TRAN_DTLS();

		prevRowIndex = 0;
		currPage = 1;
		initialize();
	}
	
	

	public HtmlInputText getCOMP_ATD_AGENT_CODE_DESC() {
		return COMP_ATD_AGENT_CODE_DESC;
	}



	public void setCOMP_ATD_AGENT_CODE_DESC(HtmlInputText cOMP_ATD_AGENT_CODE_DESC) {
		COMP_ATD_AGENT_CODE_DESC = cOMP_ATD_AGENT_CODE_DESC;
	}



	public HtmlInputText getCOMP_ATD_OLD_PARENT_CODE_DESC() {
		return COMP_ATD_OLD_PARENT_CODE_DESC;
	}



	public void setCOMP_ATD_OLD_PARENT_CODE_DESC(
			HtmlInputText cOMP_ATD_OLD_PARENT_CODE_DESC) {
		COMP_ATD_OLD_PARENT_CODE_DESC = cOMP_ATD_OLD_PARENT_CODE_DESC;
	}



	public HtmlInputText getCOMP_ATD_NEW_PARENT_CODE_DESC() {
		return COMP_ATD_NEW_PARENT_CODE_DESC;
	}



	public void setCOMP_ATD_NEW_PARENT_CODE_DESC(
			HtmlInputText cOMP_ATD_NEW_PARENT_CODE_DESC) {
		COMP_ATD_NEW_PARENT_CODE_DESC = cOMP_ATD_NEW_PARENT_CODE_DESC;
	}



	public HtmlInputText getCOMP_ATD_NEW_AGENCY_CODE_DESC() {
		return COMP_ATD_NEW_AGENCY_CODE_DESC;
	}



	public void setCOMP_ATD_NEW_AGENCY_CODE_DESC(
			HtmlInputText cOMP_ATD_NEW_AGENCY_CODE_DESC) {
		COMP_ATD_NEW_AGENCY_CODE_DESC = cOMP_ATD_NEW_AGENCY_CODE_DESC;
	}



	public HtmlOutputLabel getCOMP_ATD_AGENT_CODE_LABEL() {
		return COMP_ATD_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATD_AGENT_CODE() {
		return COMP_ATD_AGENT_CODE;
	}

	public void setCOMP_ATD_AGENT_CODE_LABEL(
			HtmlOutputLabel COMP_ATD_AGENT_CODE_LABEL) {
		this.COMP_ATD_AGENT_CODE_LABEL = COMP_ATD_AGENT_CODE_LABEL;
	}

	public void setCOMP_ATD_AGENT_CODE(HtmlInputText COMP_ATD_AGENT_CODE) {
		this.COMP_ATD_AGENT_CODE = COMP_ATD_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_ATD_OLD_PARENT_CODE_LABEL() {
		return COMP_ATD_OLD_PARENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATD_OLD_PARENT_CODE() {
		return COMP_ATD_OLD_PARENT_CODE;
	}

	public void setCOMP_ATD_OLD_PARENT_CODE_LABEL(
			HtmlOutputLabel COMP_ATD_OLD_PARENT_CODE_LABEL) {
		this.COMP_ATD_OLD_PARENT_CODE_LABEL = COMP_ATD_OLD_PARENT_CODE_LABEL;
	}

	public void setCOMP_ATD_OLD_PARENT_CODE(
			HtmlInputText COMP_ATD_OLD_PARENT_CODE) {
		this.COMP_ATD_OLD_PARENT_CODE = COMP_ATD_OLD_PARENT_CODE;
	}

	public HtmlOutputLabel getCOMP_ATD_OLD_AGENCY_CODE_LABEL() {
		return COMP_ATD_OLD_AGENCY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATD_OLD_AGENCY_CODE() {
		return COMP_ATD_OLD_AGENCY_CODE;
	}

	public void setCOMP_ATD_OLD_AGENCY_CODE_LABEL(
			HtmlOutputLabel COMP_ATD_OLD_AGENCY_CODE_LABEL) {
		this.COMP_ATD_OLD_AGENCY_CODE_LABEL = COMP_ATD_OLD_AGENCY_CODE_LABEL;
	}

	public void setCOMP_ATD_OLD_AGENCY_CODE(
			HtmlInputText COMP_ATD_OLD_AGENCY_CODE) {
		this.COMP_ATD_OLD_AGENCY_CODE = COMP_ATD_OLD_AGENCY_CODE;
	}

	public HtmlOutputLabel getCOMP_ATD_NEW_PARENT_CODE_LABEL() {
		return COMP_ATD_NEW_PARENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATD_NEW_PARENT_CODE() {
		return COMP_ATD_NEW_PARENT_CODE;
	}

	public void setCOMP_ATD_NEW_PARENT_CODE_LABEL(
			HtmlOutputLabel COMP_ATD_NEW_PARENT_CODE_LABEL) {
		this.COMP_ATD_NEW_PARENT_CODE_LABEL = COMP_ATD_NEW_PARENT_CODE_LABEL;
	}

	public void setCOMP_ATD_NEW_PARENT_CODE(
			HtmlInputText COMP_ATD_NEW_PARENT_CODE) {
		this.COMP_ATD_NEW_PARENT_CODE = COMP_ATD_NEW_PARENT_CODE;
	}

	public HtmlOutputLabel getCOMP_ATD_NEW_AGENCY_CODE_LABEL() {
		return COMP_ATD_NEW_AGENCY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATD_NEW_AGENCY_CODE() {
		return COMP_ATD_NEW_AGENCY_CODE;
	}

	public void setCOMP_ATD_NEW_AGENCY_CODE_LABEL(
			HtmlOutputLabel COMP_ATD_NEW_AGENCY_CODE_LABEL) {
		this.COMP_ATD_NEW_AGENCY_CODE_LABEL = COMP_ATD_NEW_AGENCY_CODE_LABEL;
	}

	public void setCOMP_ATD_NEW_AGENCY_CODE(
			HtmlInputText COMP_ATD_NEW_AGENCY_CODE) {
		this.COMP_ATD_NEW_AGENCY_CODE = COMP_ATD_NEW_AGENCY_CODE;
	}

	public HtmlOutputLabel getCOMP_ATD_NEW_UNIT_CODE_LABEL() {
		return COMP_ATD_NEW_UNIT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATD_NEW_UNIT_CODE() {
		return COMP_ATD_NEW_UNIT_CODE;
	}

	public void setCOMP_ATD_NEW_UNIT_CODE_LABEL(
			HtmlOutputLabel COMP_ATD_NEW_UNIT_CODE_LABEL) {
		this.COMP_ATD_NEW_UNIT_CODE_LABEL = COMP_ATD_NEW_UNIT_CODE_LABEL;
	}

	public void setCOMP_ATD_NEW_UNIT_CODE(HtmlInputText COMP_ATD_NEW_UNIT_CODE) {
		this.COMP_ATD_NEW_UNIT_CODE = COMP_ATD_NEW_UNIT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_NAME_LABEL() {
		return COMP_UI_M_AGENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_NAME() {
		return COMP_UI_M_AGENT_NAME;
	}

	public void setCOMP_UI_M_AGENT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_NAME_LABEL) {
		this.COMP_UI_M_AGENT_NAME_LABEL = COMP_UI_M_AGENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_AGENT_NAME(HtmlInputText COMP_UI_M_AGENT_NAME) {
		this.COMP_UI_M_AGENT_NAME = COMP_UI_M_AGENT_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_ATD_NEW_PARENT_NAME_LABEL() {
		return COMP_UI_M_ATD_NEW_PARENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ATD_NEW_PARENT_NAME() {
		return COMP_UI_M_ATD_NEW_PARENT_NAME;
	}

	public void setCOMP_UI_M_ATD_NEW_PARENT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ATD_NEW_PARENT_NAME_LABEL) {
		this.COMP_UI_M_ATD_NEW_PARENT_NAME_LABEL = COMP_UI_M_ATD_NEW_PARENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_ATD_NEW_PARENT_NAME(
			HtmlInputText COMP_UI_M_ATD_NEW_PARENT_NAME) {
		this.COMP_UI_M_ATD_NEW_PARENT_NAME = COMP_UI_M_ATD_NEW_PARENT_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_OLD_PARENT_NAME_LABEL() {
		return COMP_UI_M_OLD_PARENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_OLD_PARENT_NAME() {
		return COMP_UI_M_OLD_PARENT_NAME;
	}

	public void setCOMP_UI_M_OLD_PARENT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_OLD_PARENT_NAME_LABEL) {
		this.COMP_UI_M_OLD_PARENT_NAME_LABEL = COMP_UI_M_OLD_PARENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_OLD_PARENT_NAME(
			HtmlInputText COMP_UI_M_OLD_PARENT_NAME) {
		this.COMP_UI_M_OLD_PARENT_NAME = COMP_UI_M_OLD_PARENT_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_ATD_NEW_AGENCY_NAME_LABEL() {
		return COMP_UI_M_ATD_NEW_AGENCY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ATD_NEW_AGENCY_NAME() {
		return COMP_UI_M_ATD_NEW_AGENCY_NAME;
	}

	public void setCOMP_UI_M_ATD_NEW_AGENCY_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ATD_NEW_AGENCY_NAME_LABEL) {
		this.COMP_UI_M_ATD_NEW_AGENCY_NAME_LABEL = COMP_UI_M_ATD_NEW_AGENCY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ATD_NEW_AGENCY_NAME(
			HtmlInputText COMP_UI_M_ATD_NEW_AGENCY_NAME) {
		this.COMP_UI_M_ATD_NEW_AGENCY_NAME = COMP_UI_M_ATD_NEW_AGENCY_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_OLD_AGENCY_NAME_LABEL() {
		return COMP_UI_M_OLD_AGENCY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_OLD_AGENCY_NAME() {
		return COMP_UI_M_OLD_AGENCY_NAME;
	}

	public void setCOMP_UI_M_OLD_AGENCY_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_OLD_AGENCY_NAME_LABEL) {
		this.COMP_UI_M_OLD_AGENCY_NAME_LABEL = COMP_UI_M_OLD_AGENCY_NAME_LABEL;
	}

	public void setCOMP_UI_M_OLD_AGENCY_NAME(
			HtmlInputText COMP_UI_M_OLD_AGENCY_NAME) {
		this.COMP_UI_M_OLD_AGENCY_NAME = COMP_UI_M_OLD_AGENCY_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_NEW_UNIT_DESC_LABEL() {
		return COMP_UI_M_NEW_UNIT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_NEW_UNIT_DESC() {
		return COMP_UI_M_NEW_UNIT_DESC;
	}

	public void setCOMP_UI_M_NEW_UNIT_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_NEW_UNIT_DESC_LABEL) {
		this.COMP_UI_M_NEW_UNIT_DESC_LABEL = COMP_UI_M_NEW_UNIT_DESC_LABEL;
	}

	public void setCOMP_UI_M_NEW_UNIT_DESC(HtmlInputText COMP_UI_M_NEW_UNIT_DESC) {
		this.COMP_UI_M_NEW_UNIT_DESC = COMP_UI_M_NEW_UNIT_DESC;
	}

	public PT_AGENT_TRAN_DTLS getPT_AGENT_TRAN_DTLS_BEAN() {
		return PT_AGENT_TRAN_DTLS_BEAN;
	}

	public void setPT_AGENT_TRAN_DTLS_BEAN(
			PT_AGENT_TRAN_DTLS PT_AGENT_TRAN_DTLS_BEAN) {
		this.PT_AGENT_TRAN_DTLS_BEAN = PT_AGENT_TRAN_DTLS_BEAN;
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

	public ArrayList<PT_AGENT_TRAN_DTLS> getList() {
		return list;
	}

	public void setList(ArrayList<PT_AGENT_TRAN_DTLS> list) {
		this.list = list;
	}

	public String getCurrentValue(ActionEvent event) {
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

	public String checkBoxStatus(ActionEvent actionEvent) {

		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setCHECK_BOX(check);
		return "";
	}

	public void checkBoxValidation(ActionEvent event) {
		//gridtabListener();
	}

	public String checkBoxFlagStatus(ActionEvent actionEvent) {
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
	
	
	public void getDetails() {
		try {
			resetSelectedRow();
			if ( list.size() != 0) {				
				 this.PT_AGENT_TRAN_DTLS_BEAN = (PT_AGENT_TRAN_DTLS) dataTable.getRowData();
			}
						
			
			this.PT_AGENT_TRAN_DTLS_BEAN.setRowSelected(true);	
			resetAllComponent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		
		COMP_ATD_OLD_PARENT_CODE.resetValue();
		
		COMP_ATD_OLD_PARENT_CODE_DESC.resetValue();
		
		
		COMP_ATD_AGENT_CODE.resetValue();
		COMP_ATD_NEW_AGENCY_CODE.resetValue();
		COMP_ATD_NEW_PARENT_CODE.resetValue();
		COMP_ATD_NEW_UNIT_CODE.resetValue();
		COMP_ATD_OLD_AGENCY_CODE.resetValue();
		COMP_ATD_OLD_PARENT_CODE.resetValue();
		COMP_UI_M_AGENT_NAME.resetValue();
		COMP_UI_M_ATD_NEW_AGENCY_NAME.resetValue();
		COMP_UI_M_ATD_NEW_PARENT_NAME.resetValue();
		COMP_UI_M_OLD_PARENT_NAME.resetValue();
	}
	
	
	public void initialize()
	{
		COMP_ATD_OLD_PARENT_CODE=new HtmlInputText();
		COMP_ATD_OLD_PARENT_CODE_DESC=new HtmlInputText();
		COMP_ATD_AGENT_CODE=new HtmlInputText();
		COMP_ATD_NEW_AGENCY_CODE=new HtmlInputText();
		COMP_ATD_NEW_PARENT_CODE=new HtmlInputText();
		COMP_ATD_NEW_UNIT_CODE= new HtmlInputText();
		COMP_ATD_OLD_AGENCY_CODE =new HtmlInputText();
		COMP_ATD_OLD_PARENT_CODE=new HtmlInputText();
		COMP_UI_M_AGENT_NAME=new HtmlInputText();
		COMP_UI_M_ATD_NEW_AGENCY_NAME=new HtmlInputText();
		COMP_UI_M_ATD_NEW_PARENT_NAME=new HtmlInputText();
		COMP_UI_M_OLD_PARENT_NAME=new HtmlInputText();
		
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PT_AGENT_TRAN_DTLS>  iterator = list.iterator();
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	
	/*private void gridtabListener() {
		int currRowIndex  =getDataTable().getRowIndex();
		PT044_A_DELEGATE delegate =null;
		int rowUpdated =0;
		PT_AGENT_TRAN_DTLS detailBean = null;
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex == 0) {
						if (currRowIndex != prevRowIndex) {
							detailBean = new PT_AGENT_TRAN_DTLS();
							delegate = new PT044_A_DELEGATE();
							detailBean = (PT_AGENT_TRAN_DTLS) list.get(prevRowIndex);
							rowUpdated = delegate.updateData(detailBean);
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
	
	public String addNew(ActionEvent ae) {
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PT_AGENT_TRAN_DTLS_BEAN=null;
			if (isINSERT_ALLOWED()){
				PT_AGENT_TRAN_DTLS_BEAN = new PT_AGENT_TRAN_DTLS();
				delegate.loaddefalutDetailValues(PT_AGENT_TRAN_DTLS_BEAN);
					resetAllComponent();
			}
			else{
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
	/* 
		LIST_dataTable.add(PM_IL_CVR_BNF_LINK_BEAN);
		// Settings to navigate to last page
		rowCount = getLIST_COMP_DATATABLE().getRowCount();
		currPage = rowCount/recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}*/
		return "newadded";
	}
	
	public String addNew() {
		int rowCount = 0;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		PT_AGENT_TRAN_DTLS localBean = null;
		if (list == null) {
			list = new ArrayList<PT_AGENT_TRAN_DTLS>();
		}
		localBean = new PT_AGENT_TRAN_DTLS();
		delegate.loaddefalutDetailValues(localBean);
		list.add(localBean);
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return null;
	}
	public String deleteRow() {
		PT_AGENT_TRAN_DTLS bean = null;
		ArrayList deletedRecordList = null;
		PT044_A_DELEGATE delegate =new PT044_A_DELEGATE();
		int deletedRecordIndex = 0;
		if (list != null) {
			deletedRecordList = new ArrayList();
			for (int index = 0; index < list.size();) {
				bean = list.get(index);
				if (bean.isCHECK_BOX()) {
					list.remove(bean);
					deletedRecordIndex = delegate.deleteData(bean);
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
			
			System.out.println("inside into post button");
			 System.out.println("row id in post        "+PT_AGENT_TRAN_DTLS_BEAN.getROWID());
			 System.out.println("getROWID           "+compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().getPT_AGENT_POL_DTLS_BEAN().getROWID());
			if(PT_AGENT_TRAN_DTLS_BEAN.getROWID()!=null){
				if(isUPDATE_ALLOWED()) {
					
					System.out.println("inside update");
					
					delegate.pt_agent_tran_detail_pre_update(PT_AGENT_TRAN_DTLS_BEAN);
					rowUpdated = delegate.updateData(PT_AGENT_TRAN_DTLS_BEAN);
					
					System.out.println("row update value        "+rowUpdated);
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
					delegate.pt_agent_tran_detail_pre_insert(PT_AGENT_TRAN_DTLS_BEAN);
					rowUpdated = delegate.updateData(PT_AGENT_TRAN_DTLS_BEAN);
					if(rowUpdated>0)
					{
						list.add(PT_AGENT_TRAN_DTLS_BEAN);
						getWarningMap().put("current",Messages.getString("messageProperties", "errorPanel$message$insert"));
						getWarningMap().put("post", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					}
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PT_AGENT_TRAN_DTLS_BEAN.setRowSelected(true);

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
		PT_AGENT_TRAN_DTLS gridValueBean = null;
		String rowId = null;
		try {
				gridValueBean = (PT_AGENT_TRAN_DTLS)list.get(currRowIndex);
				rowId = gridValueBean.getROWID();
				
				if (rowId == null) {
					delegate.pt_agent_tran_detail_pre_insert(gridValueBean);
				}else{
					delegate.pt_agent_tran_detail_pre_update(gridValueBean);
				}
				rowUpdated = delegate.updateData(gridValueBean);
				if (rowId == null) {
					String errorMessage = Messages.getString("messageProperties", "errorPanel$message$save");
					getWarningMap().put("details", errorMessage);
					getWarningMap().put("current", errorMessage);
				}else{
					String errorMessage = Messages.getString("messageProperties", "errorPanel$message$update");
					getWarningMap().put("details", errorMessage);
					getWarningMap().put("current", errorMessage);
				}
				lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}

	public String saveDetailRecord(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put("current",Messages.getString("messageProperties", "errorPanel$message$save"));
			getWarningMap().put("save", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void validateAgentCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		String agentValue = getCurrentValue(event);
		getCurrentBean().setATD_AGENT_CODE(agentValue);
		//[Method call is commented for the new implementations of the Grid.By Phanikumar Dated:13-Feb-2009]
		//gridtabListener();
	}
	public void validateOldParentCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		String oldParentCode = getCurrentValue(event);
		getCurrentBean().setATD_OLD_PARENT_CODE(oldParentCode);
		//[Method call is commented for the new implementations of the Grid.By Phanikumar Dated:13-Feb-2009]
		//gridtabListener();
	}
	public void validateOldAgencyCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		String oldAgencyCode = getCurrentValue(event);
		getCurrentBean().setATD_OLD_AGENCY_CODE(oldAgencyCode);
		//[Method call is commented for the new implementations of the Grid.By Phanikumar Dated:13-Feb-2009]
		//gridtabListener();
	}
	public void validateNewParentCode(FacesContext context, UIComponent component,Object value){
		
		CommonUtils.clearMaps(this);
		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_DTLS localBean = getCurrentBean();
		//BugId:PREMIAGDC-0160 - Validating higher rank code : added by Shankar Bodduluri 18-Apr-09]
		String newParentCode =null;
		Connection con = null;
		int errorCode=-1;
		try {
			con = CommonUtils.getConnection();
			newParentCode = (String)value;
			localBean.setATD_NEW_PARENT_CODE(newParentCode);
			
			helper.atdNewParentCode_WhenValidateItem(localBean);
			//[Method call is commented for the new implementations of the Grid.By Phanikumar Dated:13-Feb-2009]
			//gridtabListener();
		}catch (SQLException exc) {
			exc.printStackTrace();
			try{
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(), 
						FacesContext.getCurrentInstance(), 
						"PT_AGENT_TRAN_DTLS", getWarningMap());
			}catch(ValidatorException vexc){
				vexc.printStackTrace();
				String errorMessage = vexc.getMessage();
				errorMessage = errorMessage.replace("{0}", newParentCode);
				getErrorMap().put("current", vexc.getFacesMessage().getSummary());
				throw new ValidatorException(new FacesMessage(errorMessage));
			} catch (DBException e) {
				e.printStackTrace();
			}  
		}catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			errorMessage = errorMessage.replace("{0}", newParentCode);
			getErrorMap().put("current", errorMessage);
			throw new ValidatorException(new FacesMessage(errorMessage));
		}
	}
	public void validateNewAgencyCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_DTLS localBean = getCurrentBean();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			String newAgencyCode = getCurrentValue(event);
			if (newAgencyCode != null) {
				localBean.setATD_NEW_AGENCY_CODE(newAgencyCode);
				helper.atdNewAgencyCode_WhenValidate_item(localBean);
				//[Method is commented for the new Grid Tab implementations.This method calling from the saveRecordMethod.
					//Commented by Phanikumar.Dated:13-Feb-2009
				//lastColumnListener();]
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			getErrorMap().put("keyError", errorMessage);
			getErrorMap().put("current", errorMessage);
			throw new ValidatorException(new FacesMessage(errorMessage));
		}
		
	}
	public void validateAtdAgentCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		String atdAgencyCode = getCurrentValue(event);
		getCurrentBean().setATD_AGENT_CODE(atdAgencyCode);
		//[Method call is commented for the new implementations of the Grid.By Phanikumar Dated:13-Feb-2009]
		//gridtabListener();
	}
	public void validateAtdOldParentCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		String atdAgencyCode = getCurrentValue(event);
		getCurrentBean().setATD_OLD_PARENT_CODE(atdAgencyCode);
		//[Method call is commented for the new implementations of the Grid.By Phanikumar Dated:13-Feb-2009]
		//gridtabListener();
	}
	public void validateAtdOldAgencyCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		String atdAgencyCode = getCurrentValue(event);
		getCurrentBean().setATD_OLD_AGENCY_CODE(atdAgencyCode);
		//[Method call is commented for the new implementations of the Grid.By Phanikumar Dated:13-Feb-2009]
		//gridtabListener();
	}
	public void validateAtdNewAgencyCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		String atdAgencyCode = getCurrentValue(event);
		getCurrentBean().setATD_NEW_PARENT_CODE(atdAgencyCode);
		//[Method call is commented for the new implementations of the Grid.By Phanikumar Dated:13-Feb-2009]
		//gridtabListener();
	}
	
	public void validateNewUnitCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		String newUnitCode = getCurrentValue(event);
		getCurrentBean().setATD_NEW_UNIT_CODE(newUnitCode);
	}
	
	public PT_AGENT_TRAN_DTLS getCurrentBean(){
		CommonUtils.clearMaps(this);
		//int rowIndex = getDataTable().getRowIndex(); 
		return  PT_AGENT_TRAN_DTLS_BEAN;//list.get(rowIndex);
	}
	public List newParentCodeSuggestionList(Object obj) {
		String currCode = (String)obj;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		locConditionList = delegate.getNewParentLov(currCode);
		return locConditionList;
	}
	public void renderNewParentCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		Iterator<PT_AGENT_TRAN_DTLS> iterator = null;
		PT_AGENT_TRAN_DTLS bean = null;
		PT_AGENT_TRAN_DTLS listBean = getCurrentBean();
		boolean keepLooking = true;
		String forPdRefId = null;
		UIInput inputtext = (UIInput)event.getComponent().getParent().getParent();
		forPdRefId = (String) inputtext.getSubmittedValue();
		if(forPdRefId  != null && !forPdRefId .trim().isEmpty()){
			if(locConditionList != null){
				iterator = locConditionList.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					if(forPdRefId.equals(bean.getATD_NEW_PARENT_CODE())){
						listBean.setATD_NEW_PARENT_CODE(bean.getATD_NEW_PARENT_CODE());
						listBean.setUI_M_ATD_NEW_PARENT_NAME(bean.getUI_M_ATD_NEW_PARENT_NAME());
						getCOMP_UI_M_ATD_NEW_PARENT_NAME().resetValue();
						//[Method call is commented for the new implementations of the Grid.By Phanikumar Dated:13-Feb-2009]
						//gridtabListener();
						keepLooking = false;
					}
				}
			}
		}
	}
	
	
	public List newAgencyCodeSuggestionList(Object obj) {
		String currCode = (String)obj;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		locConditionList = delegate.getNewAgencyLov(currCode);
		return locConditionList;
	}
	public void renderNewAgencyCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		Iterator<PT_AGENT_TRAN_DTLS> iterator = null;
		PT_AGENT_TRAN_DTLS bean = null;
		PT_AGENT_TRAN_DTLS listBean = getCurrentBean();
		boolean keepLooking = true;
		String forPdRefId = null;
		UIInput inputtext = (UIInput)event.getComponent().getParent().getParent();
		forPdRefId = (String) inputtext.getSubmittedValue();
		if(forPdRefId  != null && !forPdRefId .trim().isEmpty()){
			if(locConditionList != null){
				iterator = locConditionList.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					if(forPdRefId.equals(bean.getATD_NEW_AGENCY_CODE())){
						listBean.setATD_NEW_AGENCY_CODE(bean.getATD_NEW_AGENCY_CODE());
						listBean.setUI_M_ATD_NEW_AGENCY_NAME(bean.getUI_M_ATD_NEW_AGENCY_NAME());
						//[Method call is commented for the new implementations of the Grid.By Phanikumar Dated:13-Feb-2009]
						//gridtabListener();();
						keepLooking = false;
					}
				}
			}
		}
	}
	
	public List newUnitCodeSuggestionList(Object obj) {
		String currCode = (String)obj;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		locConditionList = delegate.getNewUnitLov(currCode);
		return locConditionList;
	}
	public void renderNewUnitCode(ActionEvent event){
		CommonUtils.clearMaps(this);
		Iterator<PT_AGENT_TRAN_DTLS> iterator = null;
		PT_AGENT_TRAN_DTLS bean = null;
		PT_AGENT_TRAN_DTLS listBean = getCurrentBean();
		boolean keepLooking = true;
		String forPdRefId = null;
		UIInput inputtext = (UIInput)event.getComponent().getParent().getParent();
		forPdRefId = (String) inputtext.getSubmittedValue();
		if(forPdRefId  != null && !forPdRefId .trim().isEmpty()){
			if(locConditionList != null){
				iterator = locConditionList.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					if(forPdRefId.equals(bean.getATD_NEW_UNIT_CODE())){
						listBean.setATD_NEW_UNIT_CODE(bean.getATD_NEW_UNIT_CODE());
						listBean.setUI_M_NEW_UNIT_DESC(bean.getUI_M_NEW_UNIT_DESC());
						keepLooking = false;
					}
				}
			}
		}
	}


	/*public boolean isCompAtdAgentCodeDisabled() {
		return compAtdAgentCodeDisabled;
	}

	public void setCompAtdAgentCodeDisabled(boolean compAtdAgentCodeDisabled) {
		this.compAtdAgentCodeDisabled = compAtdAgentCodeDisabled;
	}

	public boolean isCompUiMAgentNameDisabled() {
		return compUiMAgentNameDisabled;
	}

	public void setCompUiMAgentNameDisabled(boolean compUiMAgentNameDisabled) {
		this.compUiMAgentNameDisabled = compUiMAgentNameDisabled;
	}

	public boolean isCompAtdOldParentCodeDisabled() {
		return compAtdOldParentCodeDisabled;
	}

	public void setCompAtdOldParentCodeDisabled(boolean compAtdOldParentCodeDisabled) {
		this.compAtdOldParentCodeDisabled = compAtdOldParentCodeDisabled;
	}

	public boolean isCompUiMOldParentNameDisabled() {
		return compUiMOldParentNameDisabled;
	}

	public void setCompUiMOldParentNameDisabled(boolean compUiMOldParentNameDisabled) {
		this.compUiMOldParentNameDisabled = compUiMOldParentNameDisabled;
	}

	public boolean isCompAtdOldAgencyCodeDisabled() {
		return compAtdOldAgencyCodeDisabled;
	}

	public void setCompAtdOldAgencyCodeDisabled(boolean compAtdOldAgencyCodeDisabled) {
		this.compAtdOldAgencyCodeDisabled = compAtdOldAgencyCodeDisabled;
	}

	public boolean isCompAtdNewParentCodeDisabled() {
		return compAtdNewParentCodeDisabled;
	}

	public void setCompAtdNewParentCodeDisabled(boolean compAtdNewParentCodeDisabled) {
		this.compAtdNewParentCodeDisabled = compAtdNewParentCodeDisabled;
	}

	public boolean isCompUiMAtdNewAgencyNameDisabled() {
		return compUiMAtdNewAgencyNameDisabled;
	}

	public void setCompUiMAtdNewAgencyNameDisabled(
			boolean compUiMAtdNewAgencyNameDisabled) {
		this.compUiMAtdNewAgencyNameDisabled = compUiMAtdNewAgencyNameDisabled;
	}

	public boolean isCompAtdNewAgencyCodeDisabled() {
		return compAtdNewAgencyCodeDisabled;
	}

	public void setCompAtdNewAgencyCodeDisabled(boolean compAtdNewAgencyCodeDisabled) {
		this.compAtdNewAgencyCodeDisabled = compAtdNewAgencyCodeDisabled;
	}

	public boolean isCompUiMOldAgencyNameDisabled() {
		return compUiMOldAgencyNameDisabled;
	}

	public void setCompUiMOldAgencyNameDisabled(boolean compUiMOldAgencyNameDisabled) {
		this.compUiMOldAgencyNameDisabled = compUiMOldAgencyNameDisabled;
	}*/

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
	// Added for grid implementation change, Added by:Phanikumar, Dated: 16-Feb-2009 ]
	
	
	public void whenValidateNewParentCode(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public String getFilterByATD_AGENT_CODE() {
		return filterByATD_AGENT_CODE;
	}

	public void setFilterByATD_AGENT_CODE(String filterByATD_AGENT_CODE) {
		this.filterByATD_AGENT_CODE = filterByATD_AGENT_CODE;
	}

	public String getFilterByUI_M_AGENT_NAME() {
		return filterByUI_M_AGENT_NAME;
	}

	public void setFilterByUI_M_AGENT_NAME(String filterByUI_M_AGENT_NAME) {
		this.filterByUI_M_AGENT_NAME = filterByUI_M_AGENT_NAME;
	}

	public String getFilterByUI_M_OLD_PARENT_NAME() {
		return filterByUI_M_OLD_PARENT_NAME;
	}

	public void setFilterByUI_M_OLD_PARENT_NAME(String filterByUI_M_OLD_PARENT_NAME) {
		this.filterByUI_M_OLD_PARENT_NAME = filterByUI_M_OLD_PARENT_NAME;
	}

	public String getFilterByATD_OLD_PARENT_CODE() {
		return filterByATD_OLD_PARENT_CODE;
	}

	public void setFilterByATD_OLD_PARENT_CODE(String filterByATD_OLD_PARENT_CODE) {
		this.filterByATD_OLD_PARENT_CODE = filterByATD_OLD_PARENT_CODE;
	}

	public String getFilterByATD_NEW_PARENT_CODE() {
		return filterByATD_NEW_PARENT_CODE;
	}

	public void setFilterByATD_NEW_PARENT_CODE(String filterByATD_NEW_PARENT_CODE) {
		this.filterByATD_NEW_PARENT_CODE = filterByATD_NEW_PARENT_CODE;
	}

	public String getFilterByATD_OLD_AGENCY_CODE() {
		return filterByATD_OLD_AGENCY_CODE;
	}

	public void setFilterByATD_OLD_AGENCY_CODE(String filterByATD_OLD_AGENCY_CODE) {
		this.filterByATD_OLD_AGENCY_CODE = filterByATD_OLD_AGENCY_CODE;
	}

	public String getFilterByUI_M_ATD_NEW_PARENT_NAME() {
		return filterByUI_M_ATD_NEW_PARENT_NAME;
	}

	public void setFilterByUI_M_ATD_NEW_PARENT_NAME(
			String filterByUI_M_ATD_NEW_PARENT_NAME) {
		this.filterByUI_M_ATD_NEW_PARENT_NAME = filterByUI_M_ATD_NEW_PARENT_NAME;
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

	public HtmlInputText getCOMP_ATD_NEW_PARENT_CODE_1() {
		return COMP_ATD_NEW_PARENT_CODE_1;
	}

	public void setCOMP_ATD_NEW_PARENT_CODE_1(
			HtmlInputText comp_atd_new_parent_code_1) {
		COMP_ATD_NEW_PARENT_CODE_1 = comp_atd_new_parent_code_1;
	}
}
