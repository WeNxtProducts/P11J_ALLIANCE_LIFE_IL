package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.pel.forms.PILM003_APAC.PILM003_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN_MOP;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
public class PM_IL_COLUMN_LINK_ACTION extends CommonAction{
	
	
	public PILM086_APAC_COMPOSITE_ACTION compositeAction;
	
	private PM_IL_COLUMN_LINK_BEAN PM_IL_COLUMN_BEAN;

	public PM_IL_COLUMN_LINK_BEAN getPM_IL_COLUMN_BEAN() {
		return PM_IL_COLUMN_BEAN;
	}

	public void setPM_IL_COLUMN_BEAN(PM_IL_COLUMN_LINK_BEAN pM_IL_COLUMN_BEAN) {
		PM_IL_COLUMN_BEAN = pM_IL_COLUMN_BEAN;
	}

	private HtmlOutputLabel COMP_BRD1_DTL_SNO_LABEL;
	public HtmlOutputLabel getCOMP_BRD1_DTL_SNO_LABEL() {
		return COMP_BRD1_DTL_SNO_LABEL;
	}

	public void setCOMP_BRD1_DTL_SNO_LABEL(HtmlOutputLabel cOMP_BRD1_DTL_SNO_LABEL) {
		COMP_BRD1_DTL_SNO_LABEL = cOMP_BRD1_DTL_SNO_LABEL;
	}

	public HtmlInputText getCOMP_BRD1_DTL_SNO() {
		return COMP_BRD1_DTL_SNO;
	}

	public void setCOMP_BRD1_DTL_SNO(HtmlInputText cOMP_BRD1_DTL_SNO) {
		COMP_BRD1_DTL_SNO = cOMP_BRD1_DTL_SNO;
	}

	public HtmlOutputLabel getCOMP_BRD1_TAB_NAME_LABEL() {
		return COMP_BRD1_TAB_NAME_LABEL;
	}

	public void setCOMP_BRD1_TAB_NAME_LABEL(HtmlOutputLabel cOMP_BRD1_TAB_NAME_LABEL) {
		COMP_BRD1_TAB_NAME_LABEL = cOMP_BRD1_TAB_NAME_LABEL;
	}

	public HtmlInputText getCOMP_BRD1_TAB_NAME() {
		return COMP_BRD1_TAB_NAME;
	}

	public void setCOMP_BRD1_TAB_NAME(HtmlInputText cOMP_BRD1_TAB_NAME) {
		COMP_BRD1_TAB_NAME = cOMP_BRD1_TAB_NAME;
	}

	public HtmlOutputLabel getCOMP_BRD1_COL_NAME_LABEL() {
		return COMP_BRD1_COL_NAME_LABEL;
	}

	public void setCOMP_BRD1_COL_NAME_LABEL(HtmlOutputLabel cOMP_BRD1_COL_NAME_LABEL) {
		COMP_BRD1_COL_NAME_LABEL = cOMP_BRD1_COL_NAME_LABEL;
	}

	
	

	public HtmlOutputLabel getCOMP_BRD1_COL_FUNC_LABEL() {
		return COMP_BRD1_COL_FUNC_LABEL;
	}

	public void setCOMP_BRD1_COL_FUNC_LABEL(HtmlOutputLabel cOMP_BRD1_COL_FUNC_LABEL) {
		COMP_BRD1_COL_FUNC_LABEL = cOMP_BRD1_COL_FUNC_LABEL;
	}

	

	public HtmlOutputLabel getCOMP_BRD1_LINKED_TO_TAB_LABEL() {
		return COMP_BRD1_LINKED_TO_TAB_LABEL;
	}

	public void setCOMP_BRD1_LINKED_TO_TAB_LABEL(
			HtmlOutputLabel cOMP_BRD1_LINKED_TO_TAB_LABEL) {
		COMP_BRD1_LINKED_TO_TAB_LABEL = cOMP_BRD1_LINKED_TO_TAB_LABEL;
	}

	public HtmlInputText getCOMP_BRD1_LINKED_TO_TAB() {
		return COMP_BRD1_LINKED_TO_TAB;
	}

	public void setCOMP_BRD1_LINKED_TO_TAB(HtmlInputText cOMP_BRD1_LINKED_TO_TAB) {
		COMP_BRD1_LINKED_TO_TAB = cOMP_BRD1_LINKED_TO_TAB;
	}

	public HtmlOutputLabel getCOMP_BRD1_LINKED_BY_COL_LABEL() {
		return COMP_BRD1_LINKED_BY_COL_LABEL;
	}

	public void setCOMP_BRD1_LINKED_BY_COL_LABEL(
			HtmlOutputLabel cOMP_BRD1_LINKED_BY_COL_LABEL) {
		COMP_BRD1_LINKED_BY_COL_LABEL = cOMP_BRD1_LINKED_BY_COL_LABEL;
	}

	public HtmlInputText getCOMP_BRD1_LINKED_BY_COL() {
		return COMP_BRD1_LINKED_BY_COL;
	}

	public void setCOMP_BRD1_LINKED_BY_COL(HtmlInputText cOMP_BRD1_LINKED_BY_COL) {
		COMP_BRD1_LINKED_BY_COL = cOMP_BRD1_LINKED_BY_COL;
	}

	private HtmlInputText COMP_BRD1_DTL_SNO;
	private HtmlOutputLabel COMP_BRD1_TAB_NAME_LABEL;
	private HtmlInputText COMP_BRD1_TAB_NAME;
	private HtmlOutputLabel COMP_BRD1_COL_NAME_LABEL;
	private HtmlInputText COMP_BRD1_COL_NAME;
	public HtmlInputText getCOMP_BRD1_COL_NAME() {
		return COMP_BRD1_COL_NAME;
	}

	public void setCOMP_BRD1_COL_NAME(HtmlInputText cOMP_BRD1_COL_NAME) {
		COMP_BRD1_COL_NAME = cOMP_BRD1_COL_NAME;
	}

	public HtmlSelectOneMenu getCOMP_BRD1_COL_FUNC() {
		return COMP_BRD1_COL_FUNC;
	}

	public void setCOMP_BRD1_COL_FUNC(HtmlSelectOneMenu cOMP_BRD1_COL_FUNC) {
		COMP_BRD1_COL_FUNC = cOMP_BRD1_COL_FUNC;
	}

	private HtmlOutputLabel COMP_BRD1_COL_FUNC_LABEL;
	private HtmlSelectOneMenu COMP_BRD1_COL_FUNC;
	private HtmlOutputLabel COMP_BRD1_LINKED_TO_TAB_LABEL;
	private HtmlInputText COMP_BRD1_LINKED_TO_TAB;
	
	private HtmlOutputLabel COMP_BRD1_LINKED_BY_COL_LABEL;
	private HtmlInputText COMP_BRD1_LINKED_BY_COL;
	
	
	

	private PM_IL_COLUMN_LINK_HELPER helper;
	private PM_IL_COLUMN_LINK_DELEGATE delegate;
	private UIData dataTable;
	
	private List tablenameList;
	private List columnname;
	
	public PM_IL_COLUMN_LINK_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_COLUMN_LINK_HELPER helper) {
		this.helper = helper;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	

	public PM_IL_COLUMN_LINK_HELPER getHelpher() {
		return helper;
	}

	public void setHelpher(PM_IL_COLUMN_LINK_HELPER helper) {
		this.helper = helper;
	}

	public PM_IL_COLUMN_LINK_DELEGATE getDelegate() {
		return delegate;
	}

	public void setDelegate(PM_IL_COLUMN_LINK_DELEGATE delegate) {
		this.delegate = delegate;
	}

	public PM_IL_COLUMN_LINK_ACTION()
	{
		PM_IL_COLUMN_BEAN=new PM_IL_COLUMN_LINK_BEAN();
		
		dataList_COL_LINK_DEL = new ArrayList<PM_IL_COLUMN_LINK_BEAN>();
		helper=new PM_IL_COLUMN_LINK_HELPER();
		delegate=new PM_IL_COLUMN_LINK_DELEGATE();
		prepareDropDownList();	
		getItemListBRD1_COL_FUNC();
		ArrayList<String> list=new ArrayList<String>();
	
	}
	
	public void prepareDropDownList(){
		Connection connection;
		try{
			connection = CommonUtils.getConnection();
			itemListBRD1_COL_FUNC = ListItemUtil.getDropDownListValue(
					connection, "PILM086_APAC", "PM_BUS_RULE_DTL1",
					"PM_BUS_RULE_DTL1.BRD1_COL_FUNC", "COL_FUNC");
			
			
			
		}catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			System.out.println("indide of displayRecords++++++++++++++");
			
			resetSelectedRow();
			PM_IL_COLUMN_BEAN = (PM_IL_COLUMN_LINK_BEAN) dataTable.getRowData();
			PM_IL_COLUMN_BEAN.setRowSelected(true);
			System.out.println("getBRD1_TAB_NAME        "+PM_IL_COLUMN_BEAN.getBRD1_TAB_NAME());
			resetAllComponent();
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	private void resetSelectedRow() {
		System.out.println("indide of resetSelectedRow++++++++++++++");
		
		Iterator<PM_IL_COLUMN_LINK_BEAN> PM_IL_COM_LINK_ITR = dataList_COL_LINK_DEL.iterator();
		while (PM_IL_COM_LINK_ITR.hasNext()) {
			PM_IL_COM_LINK_ITR.next().setRowSelected(false);
		}
	}
	
	
	private void resetAllComponent() {
		COMP_BRD1_COL_FUNC.resetValue();
		COMP_BRD1_COL_NAME.resetValue();
		COMP_BRD1_DTL_SNO.resetValue();
		COMP_BRD1_LINKED_BY_COL.resetValue();
		COMP_BRD1_LINKED_TO_TAB.resetValue();
		COMP_BRD1_TAB_NAME.resetValue();
		
	}

	private List<PM_IL_COLUMN_LINK_BEAN> dataList_COL_LINK_DEL = new ArrayList<PM_IL_COLUMN_LINK_BEAN>();

	
	private List<SelectItem> itemListBRD1_COL_FUNC=new ArrayList<SelectItem>();
	
	
	

	
	public List<SelectItem> getItemListBRD1_COL_FUNC() {
		
		if (itemListBRD1_COL_FUNC.size() == 0) {
			itemListBRD1_COL_FUNC.clear();
			try {
				itemListBRD1_COL_FUNC = new ArrayList<SelectItem>();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return itemListBRD1_COL_FUNC;
		
		
	
	}

	public void setItemListBRD1_COL_FUNC(List<SelectItem> itemListBRD1_COL_FUNC) {
		this.itemListBRD1_COL_FUNC = itemListBRD1_COL_FUNC;
	}

	public List<PM_IL_COLUMN_LINK_BEAN> getDataList_COL_LINK_DEL() {
		return dataList_COL_LINK_DEL;
	}

	public void setDataList_COL_LINK_DEL(
			List<PM_IL_COLUMN_LINK_BEAN> dataList_COL_LINK_DEL) {
		this.dataList_COL_LINK_DEL = dataList_COL_LINK_DEL;
	}

	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				System.out.println("compositeAction      "+compositeAction);
				helper.executeQuery(compositeAction);
				/*if(PM_IL_COLUMN_BEAN.getROWID() != null){
					helper.whenCreateRecord(compositeAction);
				}*/
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
	



/*public ArrayList<String> prepareSuggestionList_BRD1_COL_NAME(Object object){
	
	
System.out.println(" enter into suggestion list");
	
	ArrayList<String> lovList = new ArrayList<String>();
	//lovList.add("raja");
	Connection connection = null;
	ResultSet resultSet = null;
	CRUDHandler handler = null;
	String Query="SELECT TABLE_NAME FROM USER_TABLES";
	
	ListItemUtil itemUtil = new ListItemUtil();
	String currentValue = (String) object;
	String moduleName = "PILM086_APAC";
	String blockName = "PM_BUS_RULE_DTL1";
	String fieldName = "PBEN_BANK_CODE";
	

	try {
		
		connection = CommonUtils.getConnection();
		handler = new CRUDHandler();
		resultSet = handler.executeSelectStatement(Query, connection);
		while(resultSet.next()){	
			
	
			lovList.add(resultSet.getString("TABLE_NAME"));
		
	
	}
		
		compositeAction.getPM_IL_COLUMN_LINK_ACTION_BEAN().getPM_IL_COLUMN_BEAN().setBRD1_TAB_NAME(lovList.get(0));
	}catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("SUGGETION", e.getMessage());
	}
	return lovList;
}*/

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				
				System.out.println("insert add row");

				PM_IL_COLUMN_BEAN = new PM_IL_COLUMN_LINK_BEAN();
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
			System.out.println("insert delete rew");
			
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_COLUMN_BEAN,
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
				dataList_COL_LINK_DEL.remove(PM_IL_COLUMN_BEAN);
				if (dataList_COL_LINK_DEL.size() > 0) {

					PM_IL_COLUMN_BEAN = dataList_COL_LINK_DEL.get(0);
				} else if (dataList_COL_LINK_DEL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_COLUMN_BEAN.setRowSelected(true);
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
    	getErrorMap().clear();
		getWarningMap().clear();
	try {
		if (PM_IL_COLUMN_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
			//helper.preInsert(PM_IL_COLUMN_BEAN, compositeAction);
			
			
					PM_IL_COLUMN_BEAN.setBRD1_BRH_SYS_ID(compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());
		
			
			new CRUDHandler().executeInsert(PM_IL_COLUMN_BEAN,
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
			dataList_COL_LINK_DEL.add(PM_IL_COLUMN_BEAN);
		} else if (PM_IL_COLUMN_BEAN.getROWID() != null
				&& isUPDATE_ALLOWED()) {
			//helper.preUpdate(compositeAction);
			new CRUDHandler().executeUpdate(PM_IL_COLUMN_BEAN,
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

		PM_IL_COLUMN_BEAN.setRowSelected(true);
	} catch (Exception exc) {
		String temp=extractDBErrorMessage(exc.getMessage());
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Record not Inserted/Updated :: " + temp);
		getErrorMap().put("postRecord",
				"Record not Inserted/Updated :: " + temp);
	}
}
	
	
	
	public static String extractDBErrorMessage(String dbErrorMessage){
		if ((dbErrorMessage != null) ){
			if ((dbErrorMessage.indexOf(":")!=-1) && (dbErrorMessage.indexOf("ORA")!=-1)){
				int index = dbErrorMessage.indexOf(":");
				dbErrorMessage = dbErrorMessage.substring(index+1);
				dbErrorMessage = dbErrorMessage.replaceAll("\\*~#", "<br/>");
				return dbErrorMessage;
			}else{
				dbErrorMessage = dbErrorMessage.replaceAll("\\*~#", "<br/>");
				return dbErrorMessage;
			}
		}
		return dbErrorMessage;
	}
	
public void saveRecord() {

	System.out.println("INSIDE saveRecord");


	String message = null;
	CommonUtils.clearMaps(this);
	//PM_IL_CURRENCY_ACTION actionBean = (PM_IL_CURRENCY_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_CURRENCY_ACTION");

	try {
		if (getPM_IL_COLUMN_BEAN().getROWID() != null && this.isINSERT_ALLOWED() == true) {

			System.out.println("NOT isUPDATE_ALLOWED");

			/*String qry = "SELECT PM_RBH_SYS_ID.NEXTVAL FROM DUAL";
			ResultSet rs = null;
			if (getErrorMap().size() == 0) {
				rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection());
				if (rs.next()) {
					PM_IL_COLUMN_BEAN.setBRD1_BRH_SYS_ID(Long.parseLong(rs.getString(1)));
				}
			}*/
			
			new CRUDHandler().executeInsert(PM_IL_COLUMN_BEAN,
					CommonUtils.getConnection());
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					"current",
					Messages.getString("messageProperties",
							"errorPanel$message$save"));
			getWarningMap().put(
					"save",
					Messages.getString("messageProperties",
							"errorPanel$message$save"));	


		}else
		{

			System.out.println("ROW ID !=NULL");

			System.out.println("isUPDATE_ALLOWED");
			
			/*Added by Raja on 28-4-2016 for TISB POC*/
			PM_IL_COLUMN_BEAN.setBRD1_BRH_SYS_ID(compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());
			/*End*/
			new CRUDHandler().executeUpdate(PM_IL_COLUMN_BEAN,
					CommonUtils.getConnection());
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


	}catch (Exception e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("SAVE", e.getMessage());
	}


}


/*public void saveRecord() {
	String message = null;
	try {
		if (getPM_IL_PLAN_BEAN().getROWID() != null) {
			if(isUPDATE_ALLOWED()){
			helper.PRE_UPDATE(PM_IL_PLAN_BEAN);
			new CRUDHandler().executeUpdate(getPM_IL_PLAN_BEAN(),
					CommonUtils.getConnection());
			getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
			getWarningMap().put("togle", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
			}
		} else {
			if(isINSERT_ALLOWED()){
			helper.PRE_INSERT(PM_IL_PLAN_BEAN);
			new CRUDHandler().executeInsert(getPM_IL_PLAN_BEAN(),
					CommonUtils.getConnection());
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
				PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put("togle",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			message = Messages.getString("messageProperties","errorPanel$message$save");

			}
		}
		CommonUtils.getConnection().commit();
	} catch (Exception e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("SAVE", e.getMessage());
	}
}*/



/*commented by raja on 27.3.2016*/


/*public List prepareSuggestionList_BRD1_TAB_NAME(Object event) {
	System.out.println("inside DeptCode");
	String DeptCode = (String) event;
	System.out.println("DeptCode eeeeeeeeeeeeeeeeee :"+DeptCode);
	Connection connection = null;
	try {
		connection = CommonUtils.getConnection();
		tablenameList =new PILM086_APAC_COMPOSITE_ACTION()
				.prepareDivisionList(connection, DeptCode, tablenameList);
		setSubmitValue(tablenameList);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return tablenameList;
}


public List prepareSuggestionList_BRD1_COL_NAME(Object event) {
	System.out.println("inside col name");
	String column_name = (String) event;
	System.out.println("col name eeeeeeeeeeeeeeeeee :"+column_name);
	Connection connection = null;
	try {
		connection = CommonUtils.getConnection();
		columnname =new PILM086_APAC_COMPOSITE_ACTION()
				.preparecolnameList(connection, column_name, columnname);
		setcolnameList(columnname);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return columnname;
}*/


/*end*/

public void setSubmitValue(List divnCode){
	if(!divnCode.isEmpty()){
		System.out.println("divnCodeList.size() ==================>>>>>"+divnCode.size());
		PM_IL_COLUMN_LINK_BEAN bean =(PM_IL_COLUMN_LINK_BEAN)divnCode.get(0);
		System.out.println("pm010_a_company_bean.getCOMP_DFLT_DIVN()"+bean.getBRD1_TAB_NAME());
		COMP_BRD1_TAB_NAME.setSubmittedValue(bean.getBRD1_TAB_NAME());
	//	System.out.println("COMP_DEFAULT_BRANCH_CODE_INPUT"+COMP_BRD1_TAB_NAME.setSubmittedValue());
	}
}



public void setcolnameList(List columnname){
	if(!columnname.isEmpty()){
		System.out.println("divnCodeList.size() ==================>>>>>"+columnname.size());
		PM_IL_COLUMN_LINK_BEAN bean =(PM_IL_COLUMN_LINK_BEAN)columnname.get(0);
		System.out.println("pm010_a_company_bean.getCOMP_DFLT_DIVN()"+bean.getBRD1_COL_NAME());
		COMP_BRD1_COL_NAME.setSubmittedValue(bean.getBRD1_COL_NAME());
	//	System.out.println("COMP_DEFAULT_BRANCH_CODE_INPUT"+COMP_BRD1_TAB_NAME.setSubmittedValue());
	}
}


/*added by raja on 27.3.2016*/

public void validateBRD1_TAB_NAME(FacesContext context ,UIComponent component,Object 

object){
		try{
			PM_IL_COLUMN_BEAN.setBRD1_TAB_NAME((String)object);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}




public ArrayList<LovBean> prepareSuggestionList_BRD1_TAB_NAME(Object object){
	
	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
	ListItemUtil itemUtil = new ListItemUtil();
	String currentValue = (String) object;
	String moduleName = "PILM086_APAC";
	String blockName = "PM_BUS_RULE_DTL1";
	String fieldName = "BRD1_TAB_NAME";
	Object param1 = "TABLE_NAME";

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



public ArrayList<LovBean> prepareSuggestionList_BRD1_COL_NAME(Object object){
	
	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
	ListItemUtil itemUtil = new ListItemUtil();
	String currentValue = (String) object;
	String moduleName = "PILM086_APAC";
	String blockName = "PM_BUS_RULE_DTL1";
	String fieldName = "BRD1_COL_NAME";
	Object param1 = PM_IL_COLUMN_BEAN.getBRD1_TAB_NAME();
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

/*end*/

}
