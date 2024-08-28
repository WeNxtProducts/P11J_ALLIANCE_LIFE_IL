package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_BUS_RULE_DTL2_ACTION extends CommonAction {

	private UIDataTable dataTable;
	
	private HtmlOutputLabel COMP_DTL_SNO_LABEL;
	
	private HtmlInputText COMP_DTL_SNO;
	
	private HtmlOutputLabel COMP_TAB_NAME_LABEL;
	
	private HtmlInputText COMP_TAB_NAME;
	
	private HtmlOutputLabel COMP_COL_NAME_LABEL;
	
	private HtmlInputText COMP_COL_NAME;
	
	private HtmlOutputLabel COMP_OPERATOR_LABEL;
	
	private HtmlSelectOneMenu COMP_OPERATOR;
	
	private HtmlOutputLabel COMP_LINK_TAB_NAME_LABEL;
	
	private HtmlInputText COMP_LINK_TAB_NAME;
	
	private HtmlOutputLabel COMP_LINK_COL_NAME_LABEL;
	
	private HtmlInputText COMP_LINK_COL_NAME;
	
	private HtmlOutputLabel COMP_LINK_VALUE_LABEL;
	
	private HtmlInputText COMP_LINK_VALUE;
	
	private HtmlInputText COMP_TAB_NAME_DESC;
	
	private HtmlInputText COMP_COL_NAME_DESC;
	
	private PM_BUS_RULE_DTL2 PM_BUS_RULE_DTL2_BEAN;
	
	public PILM086_APAC_COMPOSITE_ACTION compositeAction;
	
	private PM_BUS_RULE_DTL2_HELPER helper;
	
	private List<PM_BUS_RULE_DTL2> listColumnLinkConditions = new ArrayList<PM_BUS_RULE_DTL2>();
	
	private ArrayList<PM_BUS_RULE_DTL2> breakupList=new ArrayList<PM_BUS_RULE_DTL2>();
	
	private List tabNameList;
	
	private List colNameList;
	
	private List<SelectItem> list_COMP_OPERATOR = new ArrayList<SelectItem>();
	
	public PM_BUS_RULE_DTL2_ACTION() {
		// TODO Auto-generated constructor stub
		PM_BUS_RULE_DTL2_BEAN = new PM_BUS_RULE_DTL2();
		System.out.println("dts2 const");
		helper =new PM_BUS_RULE_DTL2_HELPER();
		prepareDropDownList();
		//instantiateAllComponent();
	}
	
		//TabName SET-SUBMIT
		public void setTabNameSubmitValue(List tabNameCode){
			if(!tabNameCode.isEmpty()){
				System.out.println("tabName.size() ==================>>>>>"+tabNameCode.size());
				for(int i=0;i<tabNameCode.size();i++){
					PM_BUS_RULE_DTL2 PM_BUS_RULE_DTL2_bean =(PM_BUS_RULE_DTL2)tabNameCode.get(i);
					PM_BUS_RULE_DTL2_BEAN.setBRD2_TAB_NAME(PM_BUS_RULE_DTL2_bean.getBRD2_TAB_NAME());
					System.out.println("setsubmitted value PM_BUS_RULE_DTL2_BEAN.getBRD2_TAB_NAME()"+PM_BUS_RULE_DTL2_BEAN.getBRD2_TAB_NAME());
					System.out.println("PM_BUS_RULE_DTL2_bean.getCOMP_DFLT_DIVN()"+PM_BUS_RULE_DTL2_bean.getBRD2_TAB_NAME());
					COMP_TAB_NAME.setSubmittedValue(PM_BUS_RULE_DTL2_bean.getBRD2_TAB_NAME());
					System.out.println("COMP_TAB_NAME"+COMP_TAB_NAME.getSubmittedValue());
				}
			}
		}
		//COL_NAME SET-SUBMIT
		public void setColNameSubmitValue(List columnNameList){
			if(!columnNameList.isEmpty()){
				System.out.println("colName.size() ==================>>>>>"+columnNameList.size());
				PM_BUS_RULE_DTL2 PM_BUS_RULE_DTL2_bean =(PM_BUS_RULE_DTL2)columnNameList.get(0);
				System.out.println("PM_BUS_RULE_DTL2_bean.getCOMP_DEFAULT_DEPT_CODE_INPUT()"+PM_BUS_RULE_DTL2_bean.getBRD2_COL_NAME());
				COMP_COL_NAME.setSubmittedValue(PM_BUS_RULE_DTL2_bean.getBRD2_COL_NAME());
				System.out.println("COMP_COL_NAME"+COMP_COL_NAME.getSubmittedValue());
			}
		}
		
		public void prepareDropDownList(){
			Connection connection;
			try{
				connection = CommonUtils.getConnection();
				list_COMP_OPERATOR = ListItemUtil.getDropDownListValue(
						connection, "PILM086_APAC", "PM_BUS_RULE_DTL2",
						"PM_BUS_RULE_DTL2.BRD2_OPERATOR", "OPERATOR");
				
			}catch (DBException e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
				getErrorMap().put("prepareDropDownList", e.getMessage());
			}
		}
	
	
	
		
	public List<SelectItem> getList_COMP_OPERATOR() {
			return list_COMP_OPERATOR;
		}

		public void setList_COMP_OPERATOR(List<SelectItem> list_COMP_OPERATOR) {
			this.list_COMP_OPERATOR = list_COMP_OPERATOR;
		}

	public PM_BUS_RULE_DTL2_HELPER getHelper() {
		return helper;
	}



	public void setHelper(PM_BUS_RULE_DTL2_HELPER helper) {
		this.helper = helper;
	}



	public PILM086_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}



	public void setCompositeAction(PILM086_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}



	public PM_BUS_RULE_DTL2 getPM_BUS_RULE_DTL2_BEAN() {
		return PM_BUS_RULE_DTL2_BEAN;
	}



	public void setPM_BUS_RULE_DTL2_BEAN(PM_BUS_RULE_DTL2 pM_BUS_RULE_DTL2_BEAN) {
		PM_BUS_RULE_DTL2_BEAN = pM_BUS_RULE_DTL2_BEAN;
	}



	public HtmlOutputLabel getCOMP_DTL_SNO_LABEL() {
		return COMP_DTL_SNO_LABEL;
	}



	public void setCOMP_DTL_SNO_LABEL(HtmlOutputLabel cOMP_DTL_SNO_LABEL) {
		COMP_DTL_SNO_LABEL = cOMP_DTL_SNO_LABEL;
	}



	public HtmlInputText getCOMP_DTL_SNO() {
		return COMP_DTL_SNO;
	}



	public void setCOMP_DTL_SNO(HtmlInputText cOMP_DTL_SNO) {
		COMP_DTL_SNO = cOMP_DTL_SNO;
	}



	public HtmlOutputLabel getCOMP_TAB_NAME_LABEL() {
		return COMP_TAB_NAME_LABEL;
	}



	public void setCOMP_TAB_NAME_LABEL(HtmlOutputLabel cOMP_TAB_NAME_LABEL) {
		COMP_TAB_NAME_LABEL = cOMP_TAB_NAME_LABEL;
	}




	public HtmlOutputLabel getCOMP_COL_NAME_LABEL() {
		return COMP_COL_NAME_LABEL;
	}



	public void setCOMP_COL_NAME_LABEL(HtmlOutputLabel cOMP_COL_NAME_LABEL) {
		COMP_COL_NAME_LABEL = cOMP_COL_NAME_LABEL;
	}


	public HtmlOutputLabel getCOMP_OPERATOR_LABEL() {
		return COMP_OPERATOR_LABEL;
	}



	public void setCOMP_OPERATOR_LABEL(HtmlOutputLabel cOMP_OPERATOR_LABEL) {
		COMP_OPERATOR_LABEL = cOMP_OPERATOR_LABEL;
	}



	public HtmlSelectOneMenu getCOMP_OPERATOR() {
		return COMP_OPERATOR;
	}



	public void setCOMP_OPERATOR(HtmlSelectOneMenu cOMP_OPERATOR) {
		COMP_OPERATOR = cOMP_OPERATOR;
	}



	public HtmlOutputLabel getCOMP_LINK_TAB_NAME_LABEL() {
		return COMP_LINK_TAB_NAME_LABEL;
	}



	public void setCOMP_LINK_TAB_NAME_LABEL(HtmlOutputLabel cOMP_LINK_TAB_NAME_LABEL) {
		COMP_LINK_TAB_NAME_LABEL = cOMP_LINK_TAB_NAME_LABEL;
	}



	public HtmlInputText getCOMP_LINK_TAB_NAME() {
		return COMP_LINK_TAB_NAME;
	}



	public void setCOMP_LINK_TAB_NAME(HtmlInputText cOMP_LINK_TAB_NAME) {
		COMP_LINK_TAB_NAME = cOMP_LINK_TAB_NAME;
	}



	public HtmlOutputLabel getCOMP_LINK_COL_NAME_LABEL() {
		return COMP_LINK_COL_NAME_LABEL;
	}



	public void setCOMP_LINK_COL_NAME_LABEL(HtmlOutputLabel cOMP_LINK_COL_NAME_LABEL) {
		COMP_LINK_COL_NAME_LABEL = cOMP_LINK_COL_NAME_LABEL;
	}



	public HtmlInputText getCOMP_LINK_COL_NAME() {
		return COMP_LINK_COL_NAME;
	}



	public void setCOMP_LINK_COL_NAME(HtmlInputText cOMP_LINK_COL_NAME) {
		COMP_LINK_COL_NAME = cOMP_LINK_COL_NAME;
	}



	public HtmlOutputLabel getCOMP_LINK_VALUE_LABEL() {
		return COMP_LINK_VALUE_LABEL;
	}



	public void setCOMP_LINK_VALUE_LABEL(HtmlOutputLabel cOMP_LINK_VALUE_LABEL) {
		COMP_LINK_VALUE_LABEL = cOMP_LINK_VALUE_LABEL;
	}



	public HtmlInputText getCOMP_LINK_VALUE() {
		return COMP_LINK_VALUE;
	}



	public void setCOMP_LINK_VALUE(HtmlInputText cOMP_LINK_VALUE) {
		COMP_LINK_VALUE = cOMP_LINK_VALUE;
	}



	public UIDataTable getDataTable() {
		return dataTable;
	}



	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	
	
	public List<PM_BUS_RULE_DTL2> getListColumnLinkConditions() {
		return listColumnLinkConditions;
	}



	public void setListColumnLinkConditions(
			List<PM_BUS_RULE_DTL2> listColumnLinkConditions) {
		this.listColumnLinkConditions = listColumnLinkConditions;
	}
	
	



	public HtmlInputText getCOMP_TAB_NAME() {
		return COMP_TAB_NAME;
	}



	public void setCOMP_TAB_NAME(HtmlInputText cOMP_TAB_NAME) {
		COMP_TAB_NAME = cOMP_TAB_NAME;
	}



	public HtmlInputText getCOMP_COL_NAME() {
		return COMP_COL_NAME;
	}



	public void setCOMP_COL_NAME(HtmlInputText cOMP_COL_NAME) {
		COMP_COL_NAME = cOMP_COL_NAME;
	}

	


	public HtmlInputText getCOMP_TAB_NAME_DESC() {
		return COMP_TAB_NAME_DESC;
	}



	public void setCOMP_TAB_NAME_DESC(HtmlInputText cOMP_TAB_NAME_DESC) {
		COMP_TAB_NAME_DESC = cOMP_TAB_NAME_DESC;
	}



	public HtmlInputText getCOMP_COL_NAME_DESC() {
		return COMP_COL_NAME_DESC;
	}



	public void setCOMP_COL_NAME_DESC(HtmlInputText cOMP_COL_NAME_DESC) {
		COMP_COL_NAME_DESC = cOMP_COL_NAME_DESC;
	}



	public void getDataTableVals(){
		System.out.println("inside data table vals");
		Iterator<PM_BUS_RULE_DTL2> PM_BUS_RULE_DTL2_val = listColumnLinkConditions.iterator();
		while(PM_BUS_RULE_DTL2_val.hasNext()){
			PM_BUS_RULE_DTL2_val.next().setRowSelected(false);
		}
	}
	
	public void displayRecords() 
	{
		CommonUtils.clearMaps(this);
		try {
			getDataTableVals();
			PM_BUS_RULE_DTL2_BEAN = (PM_BUS_RULE_DTL2) dataTable.getRowData();
			PM_BUS_RULE_DTL2_BEAN.setRowSelected(true);
			System.out.println("PM_BUS_RULE_DTL2_BEAN in display record    +++++++        "+PM_BUS_RULE_DTL2_BEAN);
			resetAllComponent();
			//getDataTableVals();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	/*public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		System.out.println("instantiateAllComponent");
		COMP_DTL_SNO				 = new HtmlInputText();
		COMP_TAB_NAME			 = new HtmlInputText();
		COMP_COL_NAME				 = new HtmlInputText();
		COMP_OPERATOR				 = new HtmlSelectOneMenu();
		COMP_LINK_TAB_NAME				 = new HtmlInputText();
		COMP_LINK_COL_NAME			 = new HtmlInputText();
		COMP_LINK_VALUE				 = new HtmlInputText();
		COMP_TAB_NAME_DESC			 = new HtmlInputText();
		COMP_COL_NAME_DESC				 = new HtmlInputText();
		System.out.println("instantiateAllComponent end");
	}*/
	
	public void resetAllComponent() {
		COMP_DTL_SNO.resetValue();
		COMP_TAB_NAME.resetValue();
		COMP_COL_NAME.resetValue();
		COMP_OPERATOR.resetValue();
		COMP_LINK_TAB_NAME.resetValue();
		COMP_LINK_COL_NAME.resetValue();
		COMP_LINK_VALUE.resetValue();
	}

	
	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				System.out.println("compositeAction11112");
				helper.executeQuery(compositeAction);
				resetAllComponent();
					//helper.whenCreateRecord(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void saveRecord(){
		System.out.println("saveRecord");
	}
	
	//Ameen Sugg DTL2 1
	
	public List suggestionActionTabName(Object event) {
		String tabNameCode = (String) event;
		System.out.println("tabNameCode ::     "+tabNameCode);
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			tabNameList =new PILM086_APAC_COMPOSITE_ACTION()
					.prepareTabNameList(connection, tabNameCode, tabNameList);
					//setTabNameSubmitValue(tabNameList);
			System.out.println("sugg tabname end"+tabNameList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tabNameList;
	}
	
	/*public void getTabNameDesc(ActionEvent event) {
		// COMP_UI_M_CONT_MAR_STATUS_DESC.setSubmittedValue(null);
		// COMP_CONT_CITY_CODE.setSubmittedValue(null);
		System.out.println("tabnamedesc");
		System.out.println("COMP_TAB_NAME.getSubmittedValue() ------------------>>>>>>>>"+COMP_TAB_NAME.getSubmittedValue());
		if (COMP_TAB_NAME.getSubmittedValue()!=null) {
			String tabname = (String) COMP_TAB_NAME.getSubmittedValue();
			System.out.println("tab_name ::" + tabname);
			String tabDesc = new PILM086_APAC_COMPOSITE_ACTION().getTabDescforName(tabname, tabNameList);
			System.out.println("tabDesc ------------------>>>>> DESC :" + tabname);
			// COMP_UI_M_CONT_MAR_STATUS_DESC.setSubmittedValue(stateDesc);
			// COMP_UI_M_BUT_CITY_CODE
			COMP_TAB_NAME.setSubmittedValue(tabDesc);
			System.out.println(COMP_TAB_NAME.getSubmittedValue());
			COMP_TAB_NAME.setDisabled(false);
			//PM010_A_COMPANY_BEAN.setCOMP_DFLT_DIVN_NAME(divnDesc);
			PM_BUS_RULE_DTL2_BEAN.setBRD2_TAB_NAME_DESC(tabDesc);
			System.out.println(PM_BUS_RULE_DTL2_BEAN.getBRD2_TAB_NAME_DESC());
			System.out.println("tab name end");
		}
	}*/
	
	//Ameen Sugg DTL2 2
	
		public List suggestionActionColName(Object event) {
			System.out.println("column name");
			/*String colNameCode = (String) event;
			System.out.println("colNameCode ::     "+colNameCode);
			Connection connection = null;
			
			try {
				connection = CommonUtils.getConnection();
				String tabName=(String) COMP_TAB_NAME.getSubmittedValue();
				System.out.println("tabName ---------->> ::"+tabName);
				colNameList =new PILM086_APAC_COMPOSITE_ACTION()
						.prepareColNameList(connection, colNameCode, colNameList);
						//setColNameSubmitValue(colNameList);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return colNameList;
		}
		
		
		/*public void getColName(ActionEvent event) {
			System.out.println("ColName");
			System.out.println("COMP_COL_NAME.getSubmittedValue() ------------------>>>>>>>>"+COMP_COL_NAME.getSubmittedValue());
			if (COMP_COL_NAME.getSubmittedValue()!=null) {
				String colName = (String) COMP_COL_NAME.getSubmittedValue();
				System.out.println("DEPT Code ::" + colName);
				String colNameDesc = new PILM086_APAC_COMPOSITE_ACTION().getColDescforName(colName, colNameList);
				System.out.println("deptDesc ------------------>>>>> DESC :" + colNameDesc);
				COMP_COL_NAME.setSubmittedValue(colNameDesc);
				System.out.println(COMP_COL_NAME.getSubmittedValue());
				PM_BUS_RULE_DTL2_BEAN.setBRD2_COL_NAME(colNameDesc);
				System.out.println(PM_BUS_RULE_DTL2_BEAN.getBRD2_COL_NAME());
				System.out.println("col name end");
			}
		}*/
		
	
		public void addRow(ActionEvent event) {
			try {
				System.out.println("ADDDD TRY");
				if (isINSERT_ALLOWED()) {
					PM_BUS_RULE_DTL2_BEAN = new PM_BUS_RULE_DTL2();
					System.out.println("PM_BUS_RULE_DTL2_BEAN.getBRD2_DTL_SNO() !!!"+PM_BUS_RULE_DTL2_BEAN.getBRD2_DTL_SNO());
					resetAllComponent();
					getDataTableVals();
				} else {
					getErrorMap().put(
							"somekey",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getErrorMap().put(
							"current",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current", e.getMessage());
				getErrorMap().put("details", e.getMessage());
			}
		}
	
	public void deleteRow(ActionEvent ae) {
		System.out.println("deleteRow");
		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (PM_BUS_RULE_DTL2_BEAN.getROWID() != null && isDELETE_ALLOWED()) {
				System.out.println("ROOOOW ID"+PM_BUS_RULE_DTL2_BEAN.getROWID());
					new CRUDHandler().executeDelete(PM_BUS_RULE_DTL2_BEAN,
							CommonUtils.getConnection());
					//CommonUtils.doComitt();
				
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllComponent();
				listColumnLinkConditions.remove(PM_BUS_RULE_DTL2_BEAN);
			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}
	
	/*public void preUpdate() throws Exception{
		System.out.println("PT_AGENT_BUDGET_BREAKUP_ACTION.preUpdate()");
		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rsDate=handler.executeSelectStatement("SELECT SYSDATE FROM DUAL", connection);
		if(rsDate.next())
			PM_BUS_RULE_DTL2_BEAN.setABGTB_UPD_DT(rsDate.getDate(1));

		PM_BUS_RULE_DTL2_BEAN.setABGTB_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		//:PT_AGENT_BUDGET_BREAKUP.ABGTB_UPD_UID := :CTRL.M_USER_ID;
	}*/
	
/*public void post(ActionEvent ae) {
		System.out.println("post");
		try {
			System.out.println("post delete try rowid"+PM_BUS_RULE_DTL2_BEAN.getROWID());
			if (PM_BUS_RULE_DTL2_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					//preUpdate();
					System.out.println("PM_BUS_RULE_DTL2_BEAN.getBRD2_DTL_SNO() ===>>>>>>>"+PM_BUS_RULE_DTL2_BEAN.getBRD2_DTL_SNO());
					new CRUDHandler().executeInsert(PM_BUS_RULE_DTL2_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					listColumnLinkConditions.add(PM_BUS_RULE_DTL2_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {
					//preInsert();
					new CRUDHandler().executeInsert(PM_BUS_RULE_DTL2_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}*/
	
	public void post(ActionEvent ae) {
		getErrorMap().clear();
		getWarningMap().clear();
		System.out.println("post");
		try {
			System.out.println("post rowid"+PM_BUS_RULE_DTL2_BEAN.getROWID());
			if (PM_BUS_RULE_DTL2_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				
				/*String qry = "SELECT PM_RBH_SYS_ID.NEXTVAL FROM DUAL";
				ResultSet rs = null;
				if (getErrorMap().size() == 0) {
					rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection());
					if (rs.next()) {
						PM_BUS_RULE_DTL2_BEAN.setBRD2_BRH_SYS_ID(Long.parseLong(rs.getString(1)));
					}
				}*/
				
				PM_BUS_RULE_DTL2_BEAN.setBRD2_BRH_SYS_ID(compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());
				
				
					new CRUDHandler().executeInsert(PM_BUS_RULE_DTL2_BEAN,
							CommonUtils.getConnection());
					getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getErrorMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					listColumnLinkConditions.add(PM_BUS_RULE_DTL2_BEAN);
			}else if (PM_BUS_RULE_DTL2_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
					//preInsert();
				
				/*Added by Raja on 28-04-2016 for TISB POC*/
				PM_BUS_RULE_DTL2_BEAN.setBRD2_BRH_SYS_ID(compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());
				/*End*/
				
					new CRUDHandler().executeInsert(PM_BUS_RULE_DTL2_BEAN,
							CommonUtils.getConnection());
					getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getErrorMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				}
			resetAllComponent();
			PM_BUS_RULE_DTL2_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	

public String saveAction() {
	String message = null;
	CommonUtils.clearMaps(this);
		CRUDHandler handler = new CRUDHandler();
		System.out.println("save methods");
		try {
			CommonUtils.getConnection().commit();
			System.out.println("ROW --------====ID"+this.PM_BUS_RULE_DTL2_BEAN.getROWID());
			System.out.println("PM_BUS_RULE_DTL2_BEAN.getBRD2_DTL_SNO() ===>>>>>>>"+PM_BUS_RULE_DTL2_BEAN.getBRD2_DTL_SNO());
			if (this.PM_BUS_RULE_DTL2_BEAN.getROWID() == null && this.isINSERT_ALLOWED() == true) {
				System.out.println("save if row id null");
				//compositeAction.getPM_BUS_RULE_DTL2_ACTION_BEAN().getPM_BUS_RULE_DTL2_BEAN().getROWID();
				handler.executeInsert(PM_BUS_RULE_DTL2_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));
				getWarningMap().put(
						"save",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));	
			} else {
				System.out.println("save else row id not null");
				System.out.println(PM_BUS_RULE_DTL2_BEAN.getBRD2_COL_NAME());
				
				handler.executeUpdate(PM_BUS_RULE_DTL2_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));
				getWarningMap().put(
						"update",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());

		}

		return "";
	}

public ArrayList<LovBean> prepareSuggestionList_BRD2_TAB_NAME(Object object){
	
	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
	ListItemUtil itemUtil = new ListItemUtil();
	String currentValue = (String) object;
	String moduleName = "PILM086_APAC";
	String blockName = "PM_BUS_RULE_DTL2";
	String fieldName = "BRD2_TAB_NAME";
	//Object param1 = PM_BUS_RULE_DTL2_BEAN.getBRD2_TAB_NAME();
	Object param1 = "TABLE_NAME";
System.out.println("parameter =========="+(String)param1);
	try {
		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,param1, 

null,
				null, null, null, currentValue);
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("SUGGETION", e.getMessage());
	}
	return lovList;
}

public ArrayList<LovBean> suggestionList_BRD2_COL_NAME(Object object){
	
	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
	ListItemUtil itemUtil = new ListItemUtil();
	String currentValue = (String) object;
	String moduleName = "PILM086_APAC";
	String blockName = "PM_BUS_RULE_DTL2";
	String fieldName = "BRD2_COL_NAME";
	Object param1 = PM_BUS_RULE_DTL2_BEAN.getBRD2_TAB_NAME();
System.out.println("parameter =========="+(String)param1);
	try {
		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,param1, 

null,
				null, null, null, currentValue);
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("SUGGETION", e.getMessage());
	}
	return lovList;
}

public void fireFieldValidation(ActionEvent actionEvent) {
	UIInput input = (UIInput) actionEvent.getComponent().getParent();
	ErrorHelpUtil.validate(input, getErrorMap());
}

public void validateBRD2_TAB_NAME(FacesContext context ,UIComponent component,Object object){
		try{
			System.out.println("table name BRD2");
			PM_BUS_RULE_DTL2_BEAN.setBRD2_TAB_NAME((String)object);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

}
