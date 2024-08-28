package com.iii.pel.forms.PILM203;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
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

public class PM_IL_BNF_AGE_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_BAS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_BAS_FRZ_FLAG;

	private HtmlOutputLabel COMP_BAS_AS_CODE_LABEL;

	private HtmlInputText COMP_BAS_AS_CODE;

	private HtmlOutputLabel COMP_UI_M_AS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_AS_DESC;

	private HtmlOutputLabel COMP_BAS_CATG_CODE_LABEL;

	private HtmlSelectOneMenu COMP_BAS_CATG_CODE;
	
	private UIData dataTablePM_IL_BNF_AGE_SETUP;
	
	private List<SelectItem> listBAS_CATG_CODE = new ArrayList<SelectItem>();

	private PM_IL_BNF_AGE_SETUP PM_IL_BNF_AGE_SETUP_BEAN;
	
	private int lastUpdatedRowIndex;
	
	private int prevRowIndex;
	
	private int currPage;
	
	private int recordsPerPage = 5;
	
	private List<PM_IL_BNF_AGE_SETUP> listdataTablePM_IL_BNF_AGE_SETUP = new ArrayList<PM_IL_BNF_AGE_SETUP>();
	
	public DataGridDelegate dataGridDelegate;
	
	private PM_IL_CVR_BNF_LINK tempBean;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
// For Filter by
	
	private String filterByBAS_AS_CODE;
	
	private String filterByBAS_CATG_CODE;
	
	public PM_IL_COVER_ACTION coverAction;
	

	public PM_IL_BNF_AGE_SETUP_ACTION() {
		PM_IL_BNF_AGE_SETUP_BEAN = new PM_IL_BNF_AGE_SETUP();
		dataGridDelegate = new DataGridDelegate();
	}

	public HtmlOutputLabel getCOMP_BAS_FRZ_FLAG_LABEL() {
		return COMP_BAS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_BAS_FRZ_FLAG() {
		return COMP_BAS_FRZ_FLAG;
	}

	public void setCOMP_BAS_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_BAS_FRZ_FLAG_LABEL) {
		this.COMP_BAS_FRZ_FLAG_LABEL = COMP_BAS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_BAS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_BAS_FRZ_FLAG) {
		this.COMP_BAS_FRZ_FLAG = COMP_BAS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_BAS_AS_CODE_LABEL() {
		return COMP_BAS_AS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_AS_CODE() {
		return COMP_BAS_AS_CODE;
	}

	public void setCOMP_BAS_AS_CODE_LABEL(HtmlOutputLabel COMP_BAS_AS_CODE_LABEL) {
		this.COMP_BAS_AS_CODE_LABEL = COMP_BAS_AS_CODE_LABEL;
	}

	public void setCOMP_BAS_AS_CODE(HtmlInputText COMP_BAS_AS_CODE) {
		this.COMP_BAS_AS_CODE = COMP_BAS_AS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AS_DESC_LABEL() {
		return COMP_UI_M_AS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AS_DESC() {
		return COMP_UI_M_AS_DESC;
	}

	public void setCOMP_UI_M_AS_DESC_LABEL(HtmlOutputLabel COMP_UI_M_AS_DESC_LABEL) {
		this.COMP_UI_M_AS_DESC_LABEL = COMP_UI_M_AS_DESC_LABEL;
	}

	public void setCOMP_UI_M_AS_DESC(HtmlInputText COMP_UI_M_AS_DESC) {
		this.COMP_UI_M_AS_DESC = COMP_UI_M_AS_DESC;
	}

	public HtmlOutputLabel getCOMP_BAS_CATG_CODE_LABEL() {
		return COMP_BAS_CATG_CODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAS_CATG_CODE() {
		return COMP_BAS_CATG_CODE;
	}

	public void setCOMP_BAS_CATG_CODE_LABEL(HtmlOutputLabel COMP_BAS_CATG_CODE_LABEL) {
		this.COMP_BAS_CATG_CODE_LABEL = COMP_BAS_CATG_CODE_LABEL;
	}

	public void setCOMP_BAS_CATG_CODE(HtmlSelectOneMenu COMP_BAS_CATG_CODE) {
		this.COMP_BAS_CATG_CODE = COMP_BAS_CATG_CODE;
	}

	public PM_IL_BNF_AGE_SETUP getPM_IL_BNF_AGE_SETUP_BEAN() {
		return PM_IL_BNF_AGE_SETUP_BEAN;
	}

	public void setPM_IL_BNF_AGE_SETUP_BEAN(PM_IL_BNF_AGE_SETUP PM_IL_BNF_AGE_SETUP_BEAN) {
		this.PM_IL_BNF_AGE_SETUP_BEAN = PM_IL_BNF_AGE_SETUP_BEAN;
	}

	public UIData getDataTablePM_IL_BNF_AGE_SETUP() {
		return dataTablePM_IL_BNF_AGE_SETUP;
	}

	public void setDataTablePM_IL_BNF_AGE_SETUP(UIData dataTablePM_IL_BNF_AGE_SETUP) {
		this.dataTablePM_IL_BNF_AGE_SETUP = dataTablePM_IL_BNF_AGE_SETUP;
	}
	
	void throwMessage(String error) throws ValidatorException {
		getErrorMap().put("current",error);
	}

	public void getDetails() {
		try {
			if ( listdataTablePM_IL_BNF_AGE_SETUP.size() != 0) {				
				 this.PM_IL_BNF_AGE_SETUP_BEAN = (PM_IL_BNF_AGE_SETUP) dataTablePM_IL_BNF_AGE_SETUP.getRowData();
			}
			resetAllComponent();			
			resetSelectedRow();
			this.PM_IL_BNF_AGE_SETUP_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
		 COMP_BAS_AS_CODE.resetValue();
		 COMP_BAS_CATG_CODE.resetValue();
		 COMP_BAS_FRZ_FLAG.resetValue();
		 COMP_UI_M_AS_DESC.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_BNF_AGE_SETUP>  iterator = listdataTablePM_IL_BNF_AGE_SETUP.iterator();
		
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
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


	public List<SelectItem> getListBAS_CATG_CODE() {
		if (listBAS_CATG_CODE.size() == 0) {
			listBAS_CATG_CODE.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listBAS_CATG_CODE = ListItemUtil.getDropDownListValue(con,
						"PILM203", "PM_IL_BNF_AGE_SETUP", "PM_IL_BNF_AGE_SETUP.BAS_CATG_CODE",
				"CTGCODE");
				//listBAS_CATG_CODE.add(0,new SelectItem("",""));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBAS_CATG_CODE;
	}
	
	
	public String addNew(ActionEvent ae){
		
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PM_IL_BNF_AGE_SETUP_BEAN=null;
			if (isINSERT_ALLOWED()){
				PM_IL_BNF_AGE_SETUP_BEAN = new PM_IL_BNF_AGE_SETUP();
				PM_IL_BNF_AGE_SETUP_BEAN.setBAS_CATG_CODE("M");
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
	
public void deleteRow(ActionEvent ae) {
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();

			if(isDELETE_ALLOWED()) {
				if(PM_IL_BNF_AGE_SETUP_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_IL_BNF_AGE_SETUP_BEAN, CommonUtils.getConnection());
					listdataTablePM_IL_BNF_AGE_SETUP.remove(PM_IL_BNF_AGE_SETUP_BEAN);
				}
				
				if(listdataTablePM_IL_BNF_AGE_SETUP.size() > 0) {
					setPM_IL_BNF_AGE_SETUP_BEAN(listdataTablePM_IL_BNF_AGE_SETUP.get(0));
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

		
	
	/*public String deleteRow( ActionEvent ae) {
		PM_IL_BNF_AGE_SETUP bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if(listdataTablePM_IL_BNF_AGE_SETUP!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<listdataTablePM_IL_BNF_AGE_SETUP.size();)
			{
				bean = listdataTablePM_IL_BNF_AGE_SETUP.get(index);
				if("dataTableSelectedRow".equalsIgnoreCase(PM_IL_BNF_AGE_SETUP_BEAN.getRowSelected())){
					listdataTablePM_IL_BNF_AGE_SETUP.remove(bean);
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
	
	public void whenValidateBAS_FRZ_FLAG(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput component = (UIInput) event.getComponent().getParent();
		String freeze = (String) component.getSubmittedValue();
		System.out.println("PM_IL_BNF_AGE_SETUP_ACTION.whenValidateBAS_FRZ_FLAG() freeze: "+freeze);		
	//	int currRowIndex = getDataTablePM_IL_BNF_AGE_SETUP().getRowIndex();
	//	PM_IL_BNF_AGE_SETUP gridValueBean = listdataTablePM_IL_BNF_AGE_SETUP.get(currRowIndex) ;

		if("true".equals(freeze)) {
			PM_IL_BNF_AGE_SETUP_BEAN.setFreezSelect(true);
		} else {
			PM_IL_BNF_AGE_SETUP_BEAN.setFreezSelect(false);
		}
		//lastColumnListener();
	}
	
	public void checkBoxValidation(ActionEvent event) {
//		gridtabListener();
	}
	
	public String checkBoxStatus(ActionEvent actionEvent)
	{
		getCurrentValue(actionEvent);
		System.out.println("Comming to check box status");
		return "";
	}
	

	public void setListBAS_CATG_CODE(List<SelectItem> listBAS_CATG_CODE) {
		this.listBAS_CATG_CODE = listBAS_CATG_CODE;
	}

	public List<PM_IL_BNF_AGE_SETUP> getListdataTablePM_IL_BNF_AGE_SETUP() {
		return listdataTablePM_IL_BNF_AGE_SETUP;
	}

	public void setListdataTablePM_IL_BNF_AGE_SETUP(
			List<PM_IL_BNF_AGE_SETUP> listdataTablePM_IL_BNF_AGE_SETUP) {
		this.listdataTablePM_IL_BNF_AGE_SETUP = listdataTablePM_IL_BNF_AGE_SETUP;
	}
	public void whenValidateBAS_CATG_CODE(ActionEvent event) {
		UIInput component = (UIInput) event.getComponent().getParent();
		String BAS_CATG_CODE = (String) component.getSubmittedValue();
	//	int currRowIndex = getDataTablePM_IL_BNF_AGE_SETUP().getRowIndex();
	//	PM_IL_BNF_AGE_SETUP gridValueBean = listdataTablePM_IL_BNF_AGE_SETUP.get(currRowIndex) ;
		PM_IL_BNF_AGE_SETUP_BEAN.setBAS_CATG_CODE(BAS_CATG_CODE);		
	}
	
	
	public void whenValidateBAS_AS_CODE(ActionEvent event) {
//		L_VAL_AGE_UNIQUE;
//		P_VAL_AGE(:PM_IL_BNF_AGE_SETUP.BAS_AS_CODE,:PM_IL_BNF_AGE_SETUP.M_AS_DESC,'N','E');

//		To be implemented
		
//		L_VAL_AGE_UNIQUE(gridBean);
		
		UIInput component = (UIInput) event.getComponent().getParent();
		String BAS_AS_CODE = (String) component.getSubmittedValue();
		//int currRowIndex = getDataTablePM_IL_BNF_AGE_SETUP().getRowIndex();
		//PM_IL_BNF_AGE_SETUP gridValueBean = listdataTablePM_IL_BNF_AGE_SETUP.get(currRowIndex) ;
		PM_IL_BNF_AGE_SETUP_BEAN.setBAS_AS_CODE(BAS_AS_CODE);		

		System.out.println("PM_IL_BNF_AGE_SETUP_ACTION.whenValidateBAS_AS_CODE() BAS_AS_CODE: "+BAS_AS_CODE);

		String UI_M_AS_DESC = (String) getCOMP_UI_M_AS_DESC().getSubmittedValue();
		
//		PROCEDURE P_VAL_AGE(   P_AGE_CODE IN     VARCHAR2,
//                P_AGE_DESC IN OUT VARCHAR2,
//                P_NAME_FLAG  IN     VARCHAR2,
//                P_ERR_FLAG   IN     VARCHAR2)
		UI_M_AS_DESC = P_VAL_AGE(BAS_AS_CODE,UI_M_AS_DESC,"N","E");
		System.out.println("PM_IL_BNF_AGE_SETUP_ACTION.whenValidateBAS_AS_CODE() UI_M_AS_DESC: "+UI_M_AS_DESC);		
		getCOMP_UI_M_AS_DESC().setSubmittedValue(UI_M_AS_DESC);
	}
	
	
	
	
	private String P_VAL_AGE(String...strings) {
		String P_AGE_CODE = strings[0];
		String P_AGE_DESC = strings[1];
		String P_NAME_FLAG = strings[2];
		String P_ERR_FLAG = strings[3];
		String M_NAME = null;
		String M_BL_NAME = null;
		
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		/*String query = "SELECT DECODE('"+strings[2]+"', 'N', AS_DESC, AS_LONG_DESC) M_NAME, " +
				"DECODE('"+strings[2]+"','N',AS_BL_DESC,AS_BL_LONG_DESC)M_BL_NAME  " +
				"FROM   PM_IL_AGE_SLAB WHERE  AS_CODE = '"+strings[0]+"'";*/
		
		String query = "SELECT DECODE(?, 'N', AS_DESC, AS_LONG_DESC), DECODE(?,'N',AS_BL_DESC,AS_BL_LONG_DESC) FROM PM_IL_AGE_SLAB WHERE AS_CODE = ?";
		Object[] values = {P_NAME_FLAG, P_NAME_FLAG, P_AGE_CODE};
		try {
			connection = CommonUtils.getConnection();
			
			resultSet = handler.executeSelectStatement(query, connection, values);
			if(resultSet.next()) {
				M_NAME = resultSet.getString(1);
				M_BL_NAME = resultSet.getString(1); 
			} else {
				
				if("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)) {
					getErrorMap().put("current", Messages.getMessage("com.iii.pel.errorUtil.PELErrorMessages","92015").getSummary());
				}
			}
			
			String foreignLangCode = CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");
			if(foreignLangCode != null && ((foreignLangCode.length() > 4 && "1".equals(foreignLangCode.substring(4, 5)))
					|| "ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")))) {
				P_AGE_DESC = M_NAME;
			} else {
				P_AGE_DESC = M_BL_NAME;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return P_AGE_DESC;
	}
	
	private void L_VAL_AGE_UNIQUE(PM_IL_BNF_AGE_SETUP gridBean) {
		String BAS_AS_CODE = (String) getCOMP_BAS_AS_CODE().getSubmittedValue();
		String CBL_BNF_CODE = getPM_IL_CVR_BNF_LINK_ACTION().getPM_IL_CVR_BNF_LINK_BEAN().getCBL_BNF_CODE();
		String COVER_CODE = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
		String ROWID = (String) gridBean.getROWID();
		
		String query1 = "  SELECT 'X' FROM   PM_IL_BNF_AGE_SETUP " +
				"WHERE  BAS_AS_CODE    = '"+BAS_AS_CODE+"' " +
				"AND    BAS_BNF_CODE   = '"+CBL_BNF_CODE+"' " +
				"AND    BAS_COVER_CODE = '"+COVER_CODE+"' ";
		
		String query2 = " SELECT 'X' FROM   PM_IL_BNF_AGE_SETUP " +
				"WHERE  BAS_AS_CODE =  '"+BAS_AS_CODE+"' " +
				"AND    BAS_BNF_CODE   = '"+CBL_BNF_CODE+"' " +
				"AND    BAS_COVER_CODE = '"+COVER_CODE+"' " +
				"AND    ROWID      <>  '"+COVER_CODE+"'";
	}
	
	//save or update the record
	public void post(ActionEvent ae) {
		int rowUpdated=0;
		CRUDHandler handler = new CRUDHandler(); 
		try{
			Connection con = CommonUtils.getConnection();
			String cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
			PM_IL_BNF_AGE_SETUP_BEAN.setBAS_COVER_CODE(cover_code);
			
			if(PM_IL_BNF_AGE_SETUP_BEAN.getROWID()!=null){
				if(isUPDATE_ALLOWED()) {
					preUpdatePM_IL_CVR_SBNF_LINK(PM_IL_BNF_AGE_SETUP_BEAN);
					//rowUpdated = dataGridDelegate.updateData(PM_IL_BNF_AGE_SETUP_BEAN);
					rowUpdated = handler.executeUpdate(PM_IL_BNF_AGE_SETUP_BEAN, con);
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
					preInsertPM_IL_BNF_AGE_SETUP(PM_IL_BNF_AGE_SETUP_BEAN);
					//PM_IL_BNF_AGE_SETUP_BEAN.setBAS_BNF_CODE(tempBean.getCBL_BNF_CODE());
					rowUpdated = handler.executeInsert(PM_IL_BNF_AGE_SETUP_BEAN, con);
					//rowUpdated = dataGridDelegate.updateData(PM_IL_BNF_AGE_SETUP_BEAN);
					if(rowUpdated>0)
					{
						listdataTablePM_IL_BNF_AGE_SETUP.add(PM_IL_BNF_AGE_SETUP_BEAN);
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
			PM_IL_BNF_AGE_SETUP_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	public void lastColumnListener() {
		System.out.println("LAST COLUMN LISTENER...............");
		int currRowIndex = getDataTablePM_IL_BNF_AGE_SETUP().getRowIndex();
		int rowUpdated = 0;
		PM_IL_BNF_AGE_SETUP gridValueBean = null;
		try {
			// Get the bean based on row index
			gridValueBean = (PM_IL_BNF_AGE_SETUP)listdataTablePM_IL_BNF_AGE_SETUP.get(currRowIndex);
			String cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
			gridValueBean.setBAS_COVER_CODE(cover_code);
			// Update the record to database
			if(gridValueBean.getROWID()!=null) {
				preUpdatePM_IL_CVR_SBNF_LINK(gridValueBean);
				rowUpdated = dataGridDelegate.updateData(gridValueBean);
				getErrorMap().put("somekey", rowUpdated+" record updated.");
				getErrorMap().put("current", rowUpdated+" record updated.");
			} else {
				preInsertPM_IL_BNF_AGE_SETUP(gridValueBean);
				/*PM_IL_CVR_BNF_LINK_ACTION pm_il_cvr_bnf_link_action = (PM_IL_CVR_BNF_LINK_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_CVR_BNF_LINK_ACTION");
				System.out.println("BENEFIT CODE:::::::"+pm_il_cvr_bnf_link_action.getPM_IL_CVR_BNF_LINK_BEAN().getSelectedBenefitCode());*/
				gridValueBean.setBAS_BNF_CODE(tempBean.getCBL_BNF_CODE());
				
				rowUpdated = dataGridDelegate.updateData(gridValueBean);
				getErrorMap().put("somekey", rowUpdated+" record inserted.");
				getErrorMap().put("current", rowUpdated+" record inserted.");
			}

			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
		}
		return ;
	}
	
	public List lovBAS_AS_CODE(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String query = "";
		ResultSet rs = null;
		if(obj.toString().equals("*")){
			query = "SELECT AS_CODE,AS_DESC FROM PM_IL_AGE_SLAB WHERE ROWNUM < 25";
		}else{
			query = "SELECT AS_CODE,AS_DESC FROM PM_IL_AGE_SLAB WHERE AS_CODE LIKE '%"+obj+"%' AND ROWNUM < 25";		
		}
		try {
			rs = getHandler().executeSelectStatement(query,
					CommonUtils.getConnection());
			rs.setFetchSize(25);
			while (rs.next()) {
				LovBean bean = new LovBean();
				bean.setCode(rs.getString("AS_CODE"));
				bean.setName(rs.getString("AS_DESC"));
				suggesionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			CommonUtils.closeCursor(rs);
		}
		return suggesionList;
	}
	
	public void preInsertPM_IL_BNF_AGE_SETUP(PM_IL_BNF_AGE_SETUP gridBean) {
		gridBean.setBAS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		gridBean.setBAS_CR_DT(new Date());

//		:PM_IL_BNF_AGE_SETUP.BAS_CR_DT  := SYSDATE;
//		:PM_IL_BNF_AGE_SETUP.BAS_CR_DT := :CTRL.M_USER_ID; 
	}
	
	public void preUpdatePM_IL_CVR_SBNF_LINK(PM_IL_BNF_AGE_SETUP gridBean) {

//		:PM_IL_CVR_SBNF_LINK.BSBL_UPD_DT  := SYSDATE;
//		:PM_IL_CVR_SBNF_LINK.BSBL_UPD_UID := :CTRL.M_USER_ID; 
		gridBean.setBAS_UPD_DT(new Date());
		gridBean.setBAS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
	
	public void postQueryPM_IL_BNF_AGE_SETUP(PM_IL_BNF_AGE_SETUP gridBean) {
		String UI_M_AS_DESC = P_VAL_AGE(gridBean.getBAS_AS_CODE(),gridBean.getUI_M_AS_DESC(),"N","E");
		gridBean.setUI_M_AS_DESC(UI_M_AS_DESC);
	}
	
	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	private PM_IL_CVR_BNF_LINK_ACTION getPM_IL_CVR_BNF_LINK_ACTION() {
		return (PM_IL_CVR_BNF_LINK_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILM203_PM_IL_CVR_BNF_LINK_ACTION");
	} 

	private PM_IL_COVER_ACTION getPM_IL_COVER_ACTION() {
		return (PM_IL_COVER_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILM203_PM_IL_COVER_ACTION");
	}
	 
	
	public String saveNext() {
		save();
		return "nextpage";
	}

	public String next() {
		return "nextpage";
	}
	
	public String first() {
		return "firstpage";
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

	public void setTempBean(PM_IL_CVR_BNF_LINK tempBean) {
		this.tempBean = tempBean;
	}
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTablePM_IL_BNF_AGE_SETUP.getRowIndex();

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

	public String getFilterByBAS_AS_CODE() {
		return filterByBAS_AS_CODE;
	}

	public void setFilterByBAS_AS_CODE(String filterByBAS_AS_CODE) {
		this.filterByBAS_AS_CODE = filterByBAS_AS_CODE;
	}

	public String getFilterByBAS_CATG_CODE() {
		return filterByBAS_CATG_CODE;
	}

	public void setFilterByBAS_CATG_CODE(String filterByBAS_CATG_CODE) {
		this.filterByBAS_CATG_CODE = filterByBAS_CATG_CODE;
	}
}
