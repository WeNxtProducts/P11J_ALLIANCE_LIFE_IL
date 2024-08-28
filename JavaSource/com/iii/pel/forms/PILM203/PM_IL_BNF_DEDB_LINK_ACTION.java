package com.iii.pel.forms.PILM203;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.el.ELResolver;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_BNF_DEDB_LINK_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_BDL_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_BDL_FRZ_FLAG;

	private HtmlOutputLabel COMP_BDEL_DEDB_CODE_LABEL;

	private HtmlInputText COMP_BDEL_DEDB_CODE;

	private HtmlOutputLabel COMP_UI_M_BDEL_BNF_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BDEL_BNF_DESC;

	private HtmlOutputLabel COMP_BDL_DEDB_NO_OF_DAYS_LABEL;

	private HtmlInputText COMP_BDL_DEDB_NO_OF_DAYS;

	private HtmlOutputLabel COMP_BDL_DEDB_PERC_LABEL;

	private HtmlInputText COMP_BDL_DEDB_PERC;

	private HtmlOutputLabel COMP_BDL_DEDB_MIN_AMT_LABEL;

	private HtmlInputText COMP_BDL_DEDB_MIN_AMT;

	private HtmlOutputLabel COMP_BDL_DEDB_DFLT_YN_LABEL;

	private HtmlSelectOneMenu COMP_BDL_DEDB_DFLT_YN;

	private PM_IL_BNF_DEDB_LINK PM_IL_BNF_DEDB_LINK_BEAN;

	private UIData dataTablePM_IL_BNF_DEDB_LINK;
	
	private int lastUpdatedRowIndex;
	
	private int prevRowIndex;
	
	private int currPage;
	
	private int recordsPerPage = 5;
	
	public DataGridDelegate dataGridDelegate;
	
	private PM_IL_CVR_BNF_LINK tempBean;

	private List<SelectItem> listBDL_DEDB_DFLT_YN = new ArrayList<SelectItem>();

	private List<PM_IL_BNF_DEDB_LINK> listdataTablePM_IL_BNF_DEDB_LINK = new ArrayList<PM_IL_BNF_DEDB_LINK>();

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
// For Filter by
	
	private String filterByBDEL_DEDB_CODE;
	
	private String filterByBDL_DEDB_PERC;
	
	public PM_IL_COVER_ACTION coverAction;
	
	public PM_IL_BNF_DEDB_LINK_ACTION() {
		PM_IL_BNF_DEDB_LINK_BEAN = new PM_IL_BNF_DEDB_LINK();
		dataGridDelegate = new DataGridDelegate();
	}

	public HtmlOutputLabel getCOMP_BDL_FRZ_FLAG_LABEL() {
		return COMP_BDL_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_BDL_FRZ_FLAG() {
		return COMP_BDL_FRZ_FLAG;
	}

	public void setCOMP_BDL_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_BDL_FRZ_FLAG_LABEL) {
		this.COMP_BDL_FRZ_FLAG_LABEL = COMP_BDL_FRZ_FLAG_LABEL;
	}

	public void setCOMP_BDL_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_BDL_FRZ_FLAG) {
		this.COMP_BDL_FRZ_FLAG = COMP_BDL_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_BDEL_DEDB_CODE_LABEL() {
		return COMP_BDEL_DEDB_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BDEL_DEDB_CODE() {
		return COMP_BDEL_DEDB_CODE;
	}

	public void setCOMP_BDEL_DEDB_CODE_LABEL(HtmlOutputLabel COMP_BDEL_DEDB_CODE_LABEL) {
		this.COMP_BDEL_DEDB_CODE_LABEL = COMP_BDEL_DEDB_CODE_LABEL;
	}

	public void setCOMP_BDEL_DEDB_CODE(HtmlInputText COMP_BDEL_DEDB_CODE) {
		this.COMP_BDEL_DEDB_CODE = COMP_BDEL_DEDB_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BDEL_BNF_DESC_LABEL() {
		return COMP_UI_M_BDEL_BNF_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BDEL_BNF_DESC() {
		return COMP_UI_M_BDEL_BNF_DESC;
	}

	public void setCOMP_UI_M_BDEL_BNF_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BDEL_BNF_DESC_LABEL) {
		this.COMP_UI_M_BDEL_BNF_DESC_LABEL = COMP_UI_M_BDEL_BNF_DESC_LABEL;
	}

	public void setCOMP_UI_M_BDEL_BNF_DESC(HtmlInputText COMP_UI_M_BDEL_BNF_DESC) {
		this.COMP_UI_M_BDEL_BNF_DESC = COMP_UI_M_BDEL_BNF_DESC;
	}

	public HtmlOutputLabel getCOMP_BDL_DEDB_NO_OF_DAYS_LABEL() {
		return COMP_BDL_DEDB_NO_OF_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_BDL_DEDB_NO_OF_DAYS() {
		return COMP_BDL_DEDB_NO_OF_DAYS;
	}

	public void setCOMP_BDL_DEDB_NO_OF_DAYS_LABEL(HtmlOutputLabel COMP_BDL_DEDB_NO_OF_DAYS_LABEL) {
		this.COMP_BDL_DEDB_NO_OF_DAYS_LABEL = COMP_BDL_DEDB_NO_OF_DAYS_LABEL;
	}

	public void setCOMP_BDL_DEDB_NO_OF_DAYS(HtmlInputText COMP_BDL_DEDB_NO_OF_DAYS) {
		this.COMP_BDL_DEDB_NO_OF_DAYS = COMP_BDL_DEDB_NO_OF_DAYS;
	}

	public HtmlOutputLabel getCOMP_BDL_DEDB_PERC_LABEL() {
		return COMP_BDL_DEDB_PERC_LABEL;
	}

	public HtmlInputText getCOMP_BDL_DEDB_PERC() {
		return COMP_BDL_DEDB_PERC;
	}

	public void setCOMP_BDL_DEDB_PERC_LABEL(HtmlOutputLabel COMP_BDL_DEDB_PERC_LABEL) {
		this.COMP_BDL_DEDB_PERC_LABEL = COMP_BDL_DEDB_PERC_LABEL;
	}

	public void setCOMP_BDL_DEDB_PERC(HtmlInputText COMP_BDL_DEDB_PERC) {
		this.COMP_BDL_DEDB_PERC = COMP_BDL_DEDB_PERC;
	}

	public HtmlOutputLabel getCOMP_BDL_DEDB_MIN_AMT_LABEL() {
		return COMP_BDL_DEDB_MIN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BDL_DEDB_MIN_AMT() {
		return COMP_BDL_DEDB_MIN_AMT;
	}

	public void setCOMP_BDL_DEDB_MIN_AMT_LABEL(HtmlOutputLabel COMP_BDL_DEDB_MIN_AMT_LABEL) {
		this.COMP_BDL_DEDB_MIN_AMT_LABEL = COMP_BDL_DEDB_MIN_AMT_LABEL;
	}

	public void setCOMP_BDL_DEDB_MIN_AMT(HtmlInputText COMP_BDL_DEDB_MIN_AMT) {
		this.COMP_BDL_DEDB_MIN_AMT = COMP_BDL_DEDB_MIN_AMT;
	}

	public HtmlOutputLabel getCOMP_BDL_DEDB_DFLT_YN_LABEL() {
		return COMP_BDL_DEDB_DFLT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BDL_DEDB_DFLT_YN() {
		return COMP_BDL_DEDB_DFLT_YN;
	}

	public void setCOMP_BDL_DEDB_DFLT_YN_LABEL(HtmlOutputLabel COMP_BDL_DEDB_DFLT_YN_LABEL) {
		this.COMP_BDL_DEDB_DFLT_YN_LABEL = COMP_BDL_DEDB_DFLT_YN_LABEL;
	}

	public void setCOMP_BDL_DEDB_DFLT_YN(HtmlSelectOneMenu COMP_BDL_DEDB_DFLT_YN) {
		this.COMP_BDL_DEDB_DFLT_YN = COMP_BDL_DEDB_DFLT_YN;
	}

	public PM_IL_BNF_DEDB_LINK getPM_IL_BNF_DEDB_LINK_BEAN() {
		return PM_IL_BNF_DEDB_LINK_BEAN;
	}

	public void setPM_IL_BNF_DEDB_LINK_BEAN(PM_IL_BNF_DEDB_LINK PM_IL_BNF_DEDB_LINK_BEAN) {
		this.PM_IL_BNF_DEDB_LINK_BEAN = PM_IL_BNF_DEDB_LINK_BEAN;
	}

	public UIData getDataTablePM_IL_BNF_DEDB_LINK() {
		return dataTablePM_IL_BNF_DEDB_LINK;
	}

	public void setDataTablePM_IL_BNF_DEDB_LINK(UIData dataTablePM_IL_BNF_DEDB_LINK) {
		this.dataTablePM_IL_BNF_DEDB_LINK = dataTablePM_IL_BNF_DEDB_LINK;
	}
	
	
	public String addNew(ActionEvent ae){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PM_IL_BNF_DEDB_LINK_BEAN=null;
			if (isINSERT_ALLOWED()){
				PM_IL_BNF_DEDB_LINK_BEAN = new PM_IL_BNF_DEDB_LINK();

				if("D".equals(tempBean.getCBL_LIMIT_TYP())) {
					PM_IL_BNF_DEDB_LINK_BEAN.setDaysDisabled(false);
					PM_IL_BNF_DEDB_LINK_BEAN.setPercDisabled(true);
				} else {
					PM_IL_BNF_DEDB_LINK_BEAN.setDaysDisabled(true);
					PM_IL_BNF_DEDB_LINK_BEAN.setPercDisabled(false);
				}
				
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
		 
		 
		return "newadded";
	}

	public void getDetails() {
		try {
			if ( listdataTablePM_IL_BNF_DEDB_LINK.size() != 0) {				
				 this.PM_IL_BNF_DEDB_LINK_BEAN = (PM_IL_BNF_DEDB_LINK) dataTablePM_IL_BNF_DEDB_LINK.getRowData();
			}
			 
			if("D".equals(tempBean.getCBL_LIMIT_TYP())) {
				PM_IL_BNF_DEDB_LINK_BEAN.setDaysDisabled(false);
				PM_IL_BNF_DEDB_LINK_BEAN.setPercDisabled(true);
			} else {
				PM_IL_BNF_DEDB_LINK_BEAN.setDaysDisabled(true);
				PM_IL_BNF_DEDB_LINK_BEAN.setPercDisabled(false);
			}
			resetAllComponent();			
			resetSelectedRow();
			this.PM_IL_BNF_DEDB_LINK_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
		 COMP_BDEL_DEDB_CODE.resetValue();
		 COMP_BDL_DEDB_DFLT_YN.resetValue();
		 COMP_BDL_DEDB_MIN_AMT.resetValue();
		 COMP_BDL_DEDB_NO_OF_DAYS.resetValue();
		 COMP_BDL_DEDB_PERC.resetValue();
		 COMP_BDL_FRZ_FLAG.resetValue();
		 COMP_UI_M_BDEL_BNF_DESC.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_BNF_DEDB_LINK>  iterator = listdataTablePM_IL_BNF_DEDB_LINK.iterator();
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	/*public String deleteRow(ActionEvent ae) {
		PM_IL_BNF_DEDB_LINK bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if(listdataTablePM_IL_BNF_DEDB_LINK!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<listdataTablePM_IL_BNF_DEDB_LINK.size();)
			{
				bean = listdataTablePM_IL_BNF_DEDB_LINK.get(index);
				if("dataTableSelectedRow".equalsIgnoreCase(PM_IL_BNF_DEDB_LINK_BEAN.getRowSelected())){
					listdataTablePM_IL_BNF_DEDB_LINK.remove(bean);
					deletedRecordIndex = dataGridDelegate.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				}else {
					index++;
				}
			}
			if(deletedRecordList.size()>0)
			{
				getErrorMap().put("somekey", deletedRecordList.size()+" records deleted.");
				getErrorMap().put("current", deletedRecordList.size()+" records deleted.");
			} else {
				throwMessage("");
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}*/
	
	public void deleteRow(ActionEvent ae) {
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();

			if(isDELETE_ALLOWED()) {
				if(PM_IL_BNF_DEDB_LINK_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_IL_BNF_DEDB_LINK_BEAN, CommonUtils.getConnection());
					listdataTablePM_IL_BNF_DEDB_LINK.remove(PM_IL_BNF_DEDB_LINK_BEAN);
				}
				
				if(listdataTablePM_IL_BNF_DEDB_LINK.size() > 0) {
					setPM_IL_BNF_DEDB_LINK_BEAN(listdataTablePM_IL_BNF_DEDB_LINK.get(0));
				} else {
					addNew(ae);
				}
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				getWarningMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}
	
	public void checkBoxValidation(ActionEvent event) {
//		gridtabListener();
	}
	
	public String checkBoxStatus(ActionEvent actionEvent)
	{
		CommonUtils.clearMaps(this);
		getCurrentValue(actionEvent);
		System.out.println("Comming to check box status");
		return "";
	}
	
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;

		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}

	public List<SelectItem> getListBDL_DEDB_DFLT_YN() {
		if (listBDL_DEDB_DFLT_YN.size() == 0) {
			listBDL_DEDB_DFLT_YN.clear();
			FacesContext fc = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) fc.getExternalContext().getContext();
			SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent) context.getAttribute("connectionAgent");
			Connection con;
			try {
				con = connectionAgent.getConnection("123");
				listBDL_DEDB_DFLT_YN = ListItemUtil.getDropDownListValue(con,
						"PILM203", "PM_IL_BNF_DEDB_LINK", "PM_IL_BNF_DEDB_LINK.BDL_DEDB_DFLT_YN",
				"YESNO");
				//listBDL_DEDB_DFLT_YN.add(0,new SelectItem("",""));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBDL_DEDB_DFLT_YN;
	}

	public void setListBDL_DEDB_DFLT_YN(List<SelectItem> listBDL_DEDB_DFLT_YN) {
		this.listBDL_DEDB_DFLT_YN = listBDL_DEDB_DFLT_YN;
	}

	public List<PM_IL_BNF_DEDB_LINK> getListdataTablePM_IL_BNF_DEDB_LINK() {
		return listdataTablePM_IL_BNF_DEDB_LINK;
	}

	public void setListdataTablePM_IL_BNF_DEDB_LINK(
			List<PM_IL_BNF_DEDB_LINK> listdataTablePM_IL_BNF_DEDB_LINK) {
		this.listdataTablePM_IL_BNF_DEDB_LINK = listdataTablePM_IL_BNF_DEDB_LINK;
	}


	public List lovBDEL_DEDB_CODE(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String query = "";
		ResultSet rs = null;
		if(obj.toString().equals("*")){
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_DEDB_CODE' AND ROWNUM < 25";
		}else{
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_CODE LIKE '%"+obj+"%' AND PC_TYPE = 'IL_DEDB_CODE' AND ROWNUM < 25";		
		}
		System.out.println("PM_IL_CVR_SBNF_LINK_ACTION.lovBSBL_SBNF_CODE() query: "+query);
		 try {
			rs = getHandler().executeSelectStatement(query, getConnection());
			rs.setFetchSize(25);
			while (rs.next()) {
				LovBean bean = new LovBean();
				bean.setCode(rs.getString("PC_CODE"));
				bean.setName(rs.getString("PC_DESC"));
				suggesionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggesionList;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public Connection getConnection() throws Exception{
		return CommonUtils.getConnection();
	}

	public void whenValidateBDEL_DEDB_CODE(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput component = (UIInput) event.getComponent().getParent();
		String BDEL_DEDB_CODE = (String) component.getSubmittedValue();
	//	int currRowIndex = getDataTablePM_IL_BNF_DEDB_LINK().getRowIndex();
	//	PM_IL_BNF_DEDB_LINK gridValueBean = listdataTablePM_IL_BNF_DEDB_LINK.get(currRowIndex) ;
		PM_IL_BNF_DEDB_LINK_BEAN.setBDEL_DEDB_CODE(BDEL_DEDB_CODE);
		if("".equals(BDEL_DEDB_CODE)){
			getCOMP_UI_M_BDEL_BNF_DESC().setSubmittedValue("");
			getPM_IL_BNF_DEDB_LINK_BEAN().setUI_M_BDEL_BNF_DESC("");
		}else{
//		L_VAL_DED_UNIQUE;
			
//		P_VAL_CODES('IL_DEDB_CODE',
//		:PM_IL_BNF_DEDB_LINK.BDEL_DEDB_CODE,
//		:PM_IL_BNF_DEDB_LINK.M_BDEL_BNF_DESC,
//		'N',
//		'E',NULL);
			
			
			L_VAL_DED_UNIQUE(BDEL_DEDB_CODE);
			String UI_M_BDEL_BNF_DESC = "";
			
			try{
				CallableStatement cs = CommonUtils.getConnection().prepareCall("{call P_VAL_CODES(?,?,?,?,?,?)}");
				cs.setString(1, "IL_DEDB_CODE");
				cs.setString(2, BDEL_DEDB_CODE);
				cs.registerOutParameter(3, java.sql.Types.VARCHAR);
				cs.setString(4, "N");
				cs.setString(5, "E");
				cs.setNull(6, java.sql.Types.NULL);
				boolean flag = cs.execute();
				UI_M_BDEL_BNF_DESC = cs.getString(3);
				System.out.println("PM_IL_BNF_DEDB_LINK_ACTION.whenValidateBDEL_DEDB_CODE() UI_M_BDEL_BNF_DESC: "+UI_M_BDEL_BNF_DESC);
				getCOMP_UI_M_BDEL_BNF_DESC().setSubmittedValue(UI_M_BDEL_BNF_DESC);
				getErrorMap().clear();
			} catch(Exception e) {
				String errorMessage = e.getLocalizedMessage();
				throwMessage(errorMessage);
			}
			
			
		}
	}
	
	public void whenValidateBDL_FRZ_FLAG(ActionEvent event) {
		CommonUtils.clearMaps(this);
	//	int currRowIndex = getDataTablePM_IL_BNF_DEDB_LINK().getRowIndex();
		UIInput component = (UIInput) event.getComponent().getParent();
		String freeze = (String) component.getSubmittedValue();
	//	PM_IL_BNF_DEDB_LINK gridValueBean = listdataTablePM_IL_BNF_DEDB_LINK.get(currRowIndex) ;

		if("true".equals(freeze)) {
			PM_IL_BNF_DEDB_LINK_BEAN.setFreezSelect(true);
		} else {
			PM_IL_BNF_DEDB_LINK_BEAN.setFreezSelect(false);
		}
		//lastColumnListener();
	}

	void throwMessage(String error) throws ValidatorException {
		getErrorMap().put("current",error);
	}
	
	private void L_VAL_DED_UNIQUE(String BDEL_DEDB_CODE) {

		PM_IL_CVR_BNF_LINK PM_IL_CVR_BNF_LINK_BEAN = getPM_IL_CVR_BNF_LINK_ACTION().getPM_IL_CVR_BNF_LINK_BEAN();
		String CBL_BNF_CODE = PM_IL_CVR_BNF_LINK_BEAN.getCBL_BNF_CODE();

		PM_IL_COVER PM_IL_COVER_BEAN = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN();
		String COVER_CODE = PM_IL_COVER_BEAN.getCOVER_CODE();

		String query1 = "SELECT 'X' FROM   PM_IL_BNF_DEDB_LINK " +
		"WHERE  BDEL_DEDB_CODE = '"+BDEL_DEDB_CODE+"' " +
		"AND    BDL_BNF_CODE   = '"+CBL_BNF_CODE+"' " +
		"AND    BDL_COVER_CODE = '"+COVER_CODE+"'";

//		at the time of updating
		String query2 = "SELECT 'X' FROM   PM_IL_BNF_DEDB_LINK " +
		"WHERE  BDEL_DEDB_CODE = '"+BDEL_DEDB_CODE+"' " +
		"AND    BDL_COVER_CODE = '"+COVER_CODE+"' " +
		"AND    BDL_BNF_CODE   = '"+CBL_BNF_CODE+"' " +
		"AND    ROWID      <>  '"+PM_IL_BNF_DEDB_LINK_BEAN.getROWID()+"'";

	}

	public void whenValidateBDL_DEDB_NO_OF_DAYS(ActionEvent event) {
		CommonUtils.clearMaps(this);
		System.out.println("PM_IL_BNF_DEDB_LINK_ACTION.whenValidateBDL_DEDB_NO_OF_DAYS()");
		Double BDL_DEDB_PERC = 0.0;
		
		UIInput component = (UIInput) event.getComponent().getParent();
		String BDL_DEDB_NO_OF_DAYS = (String) component.getSubmittedValue();
		BDL_DEDB_NO_OF_DAYS = "".equals(BDL_DEDB_NO_OF_DAYS)?"0":BDL_DEDB_NO_OF_DAYS;
		
	//	int currRowIndex = getDataTablePM_IL_BNF_DEDB_LINK().getRowIndex();
	//	PM_IL_BNF_DEDB_LINK gridValueBean = listdataTablePM_IL_BNF_DEDB_LINK.get(currRowIndex) ;
		PM_IL_BNF_DEDB_LINK_BEAN.setBDL_DEDB_NO_OF_DAYS(Double.valueOf(BDL_DEDB_NO_OF_DAYS));


		if(Double.valueOf(BDL_DEDB_NO_OF_DAYS) < 0 || Double.valueOf(BDL_DEDB_NO_OF_DAYS) > getTempBean().getCBL_LIMIT_DAYS()  ) {
			getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath,"91997").getSummary());
		} else{
			getErrorMap().clear();
		}
		
		/*String BDL_DEDB_PERC = (String) getCOMP_BDL_DEDB_PERC().getSubmittedValue();
		BDL_DEDB_PERC = "".equals(BDL_DEDB_PERC)?"0":BDL_DEDB_PERC;
		if(gridValueBean.getBDL_DEDB_PERC()>=0)
		{
			BDL_DEDB_PERC = gridValueBean.getBDL_DEDB_PERC();
		}*/

		//getCOMP_BDL_DEDB_MIN_AMT().setSubmittedValue(String.valueOf(Double.valueOf(BDL_DEDB_NO_OF_DAYS) * BDL_DEDB_PERC));
		
		//lastColumnListener();

	}

	public void whenValidateBDL_DEDB_PERC(ActionEvent event) {
		CommonUtils.clearMaps(this);
//		IF :PM_IL_BNF_DEDB_LINK.BDL_DEDB_PERC < 0 OR :PM_IL_BNF_DEDB_LINK.BDL_DEDB_PERC > 100 THEN
//		   STD_MESSAGE_ROUTINE(91125,NAME_IN('GLOBAL.M_LANG_CODE'));	
//			 RAISE FORM_TRIGGER_FAILURE;
//		END IF;
//		:BDL_DEDB_MIN_AMT := NVL(:BDL_DEDB_PERC,0) * NVL(:BDL_DEDB_NO_OF_DAYS,0);
		
		UIInput component = (UIInput) event.getComponent().getParent();
		String BDL_DEDB_PERC = (String) component.getSubmittedValue();
		BDL_DEDB_PERC = "".equals(BDL_DEDB_PERC)?"0":BDL_DEDB_PERC;
		
		//int currRowIndex = getDataTablePM_IL_BNF_DEDB_LINK().getRowIndex();
	//	PM_IL_BNF_DEDB_LINK gridValueBean = listdataTablePM_IL_BNF_DEDB_LINK.get(currRowIndex) ;
		PM_IL_BNF_DEDB_LINK_BEAN.setBDL_DEDB_PERC(Double.valueOf(BDL_DEDB_PERC));

		
		if(Double.valueOf(BDL_DEDB_PERC) < 0 || Double.valueOf(BDL_DEDB_PERC) > 100 ) {
			getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath,"91125").getSummary());
		}  else{
			getErrorMap().clear();
		}
		
		/*String BDL_DEDB_NO_OF_DAYS = (String) getCOMP_BDL_DEDB_NO_OF_DAYS().getSubmittedValue();
		BDL_DEDB_NO_OF_DAYS = "".equals(BDL_DEDB_NO_OF_DAYS)?"0":BDL_DEDB_NO_OF_DAYS;*/
		//Double BDL_DEDB_NO_OF_DAYS = gridValueBean.getBDL_DEDB_NO_OF_DAYS();

		
		//getCOMP_BDL_DEDB_MIN_AMT().setSubmittedValue(String.valueOf(Double.valueOf(BDL_DEDB_PERC) * BDL_DEDB_NO_OF_DAYS));
		
	}

	public void whenValidateBDL_DEDB_MIN_AMT(ActionEvent event) {
		CommonUtils.clearMaps(this);
		System.out.println("PM_IL_BNF_DEDB_LINK_ACTION.whenValidateBDL_DEDB_MIN_AMT()");	
		UIInput component = (UIInput) event.getComponent().getParent();
		String BDL_DEDB_MIN_AMT = (String) component.getSubmittedValue();
		BDL_DEDB_MIN_AMT = "".equals(BDL_DEDB_MIN_AMT)?"0":BDL_DEDB_MIN_AMT;
		
		//int currRowIndex = getDataTablePM_IL_BNF_DEDB_LINK().getRowIndex();
	//	PM_IL_BNF_DEDB_LINK gridValueBean = listdataTablePM_IL_BNF_DEDB_LINK.get(currRowIndex) ;
		PM_IL_BNF_DEDB_LINK_BEAN.setBDL_DEDB_MIN_AMT(Double.valueOf(BDL_DEDB_MIN_AMT));
		
		if(Double.valueOf(BDL_DEDB_MIN_AMT) < 0) {
			getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath,"59005").getSummary());
		}else if(Double.valueOf(BDL_DEDB_MIN_AMT) > getTempBean().getCBL_LIMIT_LC_AMT()){
			getErrorMap().put("current", "Minimum deductible amount cannot be greater than Benefit Limit");
		}else{
			System.out.println("getError map:::"+getErrorMap().size());
			if(getErrorMap().size()<=0)
			{
				getErrorMap().clear();
			}
		}
		
		
	}
	
	public void preInsertPM_IL_BNF_DEDB_LINK(PM_IL_BNF_DEDB_LINK gridBean) throws ParseException {
		//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]

//		:PM_IL_BNF_DEDB_LINK.BDL_CR_DT  := SYSDATE; 
//		:PM_IL_BNF_DEDB_LINK.BDL_CR_UID := :CTRL.M_USER_ID;
		gridBean.setBDL_CR_DT(new CommonUtils().getCurrentDate());
		gridBean.setBDL_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
	
	public void preUpdatePM_IL_BNF_DEDB_LINK(PM_IL_BNF_DEDB_LINK PM_IL_BNF_DEDB_LINK_BEAN) throws ParseException { 
//		:PM_IL_CVR_SBNF_LINK.BSBL_UPD_DT  := SYSDATE;
//		:PM_IL_CVR_SBNF_LINK.BSBL_UPD_UID := :CTRL.M_USER_ID;
		//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]

		PM_IL_BNF_DEDB_LINK_BEAN.setBDL_UPD_DT(new CommonUtils().getCurrentDate());
		PM_IL_BNF_DEDB_LINK_BEAN.setBDL_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
	
	//save or update the record
	public void post(ActionEvent ae) {
		int rowUpdated=0;
		try{
			
			if(PM_IL_BNF_DEDB_LINK_BEAN.getROWID()!=null){
				if(isUPDATE_ALLOWED()) {
					preUpdatePM_IL_BNF_DEDB_LINK(PM_IL_BNF_DEDB_LINK_BEAN);
					rowUpdated = dataGridDelegate.updateData(PM_IL_BNF_DEDB_LINK_BEAN);
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
					 
					preInsertPM_IL_BNF_DEDB_LINK(PM_IL_BNF_DEDB_LINK_BEAN);
					PM_IL_COVER_ACTION pm_il_cover_action = (PM_IL_COVER_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_COVER_ACTION");
					PM_IL_BNF_DEDB_LINK_BEAN.setBDL_BNF_CODE(tempBean.getCBL_BNF_CODE());
					PM_IL_BNF_DEDB_LINK_BEAN.setBDL_COVER_CODE(pm_il_cover_action.getPM_IL_COVER_BEAN().getCOVER_CODE());
					
					rowUpdated = dataGridDelegate.updateData(PM_IL_BNF_DEDB_LINK_BEAN);
					if(rowUpdated>0)
					{
						listdataTablePM_IL_BNF_DEDB_LINK.add(PM_IL_BNF_DEDB_LINK_BEAN);
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
			PM_IL_BNF_DEDB_LINK_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	
	public void lastColumnListener() {
		int currRowIndex = getDataTablePM_IL_BNF_DEDB_LINK().getRowIndex();
		int rowUpdated = 0;
		PM_IL_BNF_DEDB_LINK gridValueBean = null;
		try {
			gridValueBean = (PM_IL_BNF_DEDB_LINK)listdataTablePM_IL_BNF_DEDB_LINK.get(currRowIndex);
			String bdl_cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
			gridValueBean.setBDL_COVER_CODE(bdl_cover_code);
			if(gridValueBean.getROWID()!=null) {
				preUpdatePM_IL_BNF_DEDB_LINK(gridValueBean);
				rowUpdated = dataGridDelegate.updateData(gridValueBean);
				if(rowUpdated>0)
				{
					getErrorMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "UPDATE_MESSAGE"));
					//getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "UPDATE_MESSAGE"));
					
				}
			} else {
				preInsertPM_IL_BNF_DEDB_LINK(gridValueBean);
				PM_IL_COVER_ACTION pm_il_cover_action = (PM_IL_COVER_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_COVER_ACTION");
				//PM_IL_CVR_SBNF_LINK_ACTION pm_il_cvr_sbnf_link_action = (PM_IL_CVR_SBNF_LINK_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_CVR_SBNF_LINK_ACTION");
				//System.out.println("SUB BENEFIT CODE::::::::"+pm_il_cvr_sbnf_link_action.getPM_IL_CVR_SBNF_LINK_BEAN().getSelectedSubBenefitCode());
				gridValueBean.setBDL_BNF_CODE(tempBean.getCBL_BNF_CODE());
				gridValueBean.setBDL_COVER_CODE(pm_il_cover_action.getPM_IL_COVER_BEAN().getCOVER_CODE());
				
				rowUpdated = dataGridDelegate.updateData(gridValueBean);
				if(rowUpdated>0)
				{
					getErrorMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
					//getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
				}
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}

	
	public void postQueryPM_IL_BNF_DEDB_LINK(PM_IL_BNF_DEDB_LINK gridBean) {
//		  P_VAL_CODES('IL_DEDB_CODE',
//	               :PM_IL_BNF_DEDB_LINK.BDEL_DEDB_CODE,
//	               :PM_IL_BNF_DEDB_LINK.M_BDEL_BNF_DESC,
//	               'N',
//	               'N',NULL);
		
//		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
//		OracleParameter param1 = new OracleParameter("in1","STRING","IN","'IL_DEDB_CODE'" );
//		OracleParameter param2 = new OracleParameter("in2","STRING","IN",gridBean.getBDEL_DEDB_CODE());
//		OracleParameter param3 = new OracleParameter("in3","STRING","IN OUT",gridBean.getUI_M_BDEL_BNF_DESC());
//		OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
//		OracleParameter param5 = new OracleParameter("in5","STRING","IN","'N'");
//		OracleParameter param6 = new OracleParameter("in6","STRING","IN",null);
//		paramList.add(param1);
//		paramList.add(param2);
//		paramList.add(param3);
//		paramList.add(param4);
//		paramList.add(param5);
//		paramList.add(param6);
//		OracleProcedureHandler procHandler = new OracleProcedureHandler();
//		List<OracleParameter> list = null;
//		Connection conn = null;
//		try {
//			conn = getConnection();
//			list = procHandler.execute(paramList, getConnection(), "P_VAL_CODES");
//			gridBean.setUI_M_BDEL_BNF_DESC(list.get(0).getValue());
//			throwMessage("");
//		} catch (Exception e) {
//			String errorMessage = e.getLocalizedMessage();
//			throwMessage(errorMessage);
//		}
		
		String UI_M_BDEL_BNF_DESC = "";

		try{
			CallableStatement cs = CommonUtils.getConnection().prepareCall("{call P_VAL_CODES(?,?,?,?,?,?)}");
			cs.setString(1, "IL_DEDB_CODE");
			cs.setString(2, gridBean.getBDEL_DEDB_CODE());
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.setString(4, "N");
			cs.setString(5, "N");
			cs.setNull(6, java.sql.Types.NULL);
			boolean flag = cs.execute();
			UI_M_BDEL_BNF_DESC = cs.getString(3);
			System.out.println("PM_IL_BNF_DEDB_LINK_ACTION.postQueryPM_IL_BNF_DEDB_LINK() desc: "+UI_M_BDEL_BNF_DESC);
			gridBean.setUI_M_BDEL_BNF_DESC(UI_M_BDEL_BNF_DESC);
			getErrorMap().clear();
		} catch(Exception e) {
			String errorMessage = e.getLocalizedMessage();
			throwMessage(errorMessage);
			e.printStackTrace();
		}
	}	

	public void whenValidateBDL_DEDB_DFLT_YN(ActionEvent event) {
		CommonUtils.clearMaps(this);
		System.out.println("PM_IL_BNF_DEDB_LINK_ACTION.whenValidateBDL_DEDB_DFLT_YN()");
		
		UIInput component = (UIInput) event.getComponent().getParent();
		String BDL_DEDB_DFLT_YN = (String) component.getSubmittedValue();

	//	int currRowIndex = getDataTablePM_IL_BNF_DEDB_LINK().getRowIndex();
	//	PM_IL_BNF_DEDB_LINK gridValueBean = listdataTablePM_IL_BNF_DEDB_LINK.get(currRowIndex) ;
		PM_IL_BNF_DEDB_LINK_BEAN.setBDL_DEDB_DFLT_YN(BDL_DEDB_DFLT_YN);
		System.out.println("ERROR MAP:::::::::"+getErrorMap().size());
		 
	}

	private PM_IL_CVR_BNF_LINK_ACTION getPM_IL_CVR_BNF_LINK_ACTION() {
		return (PM_IL_CVR_BNF_LINK_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILM203_PM_IL_CVR_BNF_LINK_ACTION");
	} 

	private PM_IL_COVER_ACTION getPM_IL_COVER_ACTION() {
		return (PM_IL_COVER_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILM203_PM_IL_COVER_ACTION");
	}
	
	
	public void nextBlock_PM_IL_BNF_AGE_SETUP() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		PM_IL_BNF_AGE_SETUP_ACTION ageSetupAction = (PM_IL_BNF_AGE_SETUP_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_BNF_AGE_SETUP_ACTION");
		
		String bas_cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
		
		String queryForageSetupAction = "SELECT ROWID,PM_IL_BNF_AGE_SETUP.* FROM PM_IL_BNF_AGE_SETUP WHERE BAS_COVER_CODE = '"+bas_cover_code+"'";
		System.out.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_BNF_AGE_SETUP() query "+queryForageSetupAction);
		
		CRUDHandler handler = new CRUDHandler();
		try {
			List<PM_IL_BNF_AGE_SETUP> list = handler.fetch(queryForageSetupAction, "com.iii.pel.forms.PILM203.PM_IL_BNF_AGE_SETUP", CommonUtils.getConnection());
			System.out.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_CVR_BNF_LINK() list size "+list.size());
			for(int i=0 ; i < list.size() ; i++) {
				PM_IL_BNF_AGE_SETUP valueBean = list.get(i);
				ageSetupAction.postQueryPM_IL_BNF_AGE_SETUP(valueBean);
				ageSetupAction.setPM_IL_BNF_AGE_SETUP_BEAN(valueBean);
			}
			ageSetupAction.setListdataTablePM_IL_BNF_AGE_SETUP(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String goToParentBlock(){
		
		return "CVR_BNF";
	}
	
	public String saveNext() {
		save();
		nextBlock_PM_IL_BNF_AGE_SETUP();
		return "nextpage";
	}

	public String next() {
		nextBlock_PM_IL_BNF_AGE_SETUP();
		return "nextpage";
	}

	public String last() {
		return "lastpage";
	}
	public String prevPage() {
		return "prevpage";
	}
	
	
	public void save() {
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
	}

	
	public void setTempBean(PM_IL_CVR_BNF_LINK tempBean) {
		this.tempBean = tempBean;
	}

	public PM_IL_CVR_BNF_LINK getTempBean() {
		return tempBean;
	}

	
	public void callCommitAction(ActionEvent event)
	{
		try {
			new CommonUtils().doComitt();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTablePM_IL_BNF_DEDB_LINK.getRowIndex();

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
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
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

	public String getFilterByBDEL_DEDB_CODE() {
		return filterByBDEL_DEDB_CODE;
	}

	public void setFilterByBDEL_DEDB_CODE(String filterByBDEL_DEDB_CODE) {
		this.filterByBDEL_DEDB_CODE = filterByBDEL_DEDB_CODE;
	}

	public String getFilterByBDL_DEDB_PERC() {
		return filterByBDL_DEDB_PERC;
	}

	public void setFilterByBDL_DEDB_PERC(String filterByBDL_DEDB_PERC) {
		this.filterByBDL_DEDB_PERC = filterByBDL_DEDB_PERC;
	}
	

}