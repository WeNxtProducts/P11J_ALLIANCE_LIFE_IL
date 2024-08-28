package com.iii.pel.forms.PILM039;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.print.DocFlavor.STRING;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_APPR_DEPT_SETUP_ACTION extends CommonAction{
	
	private static Log LOG = LogFactory.getLog(PM_IL_APPR_DEPT_SETUP_ACTION.class); 

	private UIData dataTable;
	private int currPage;

	private int prevRowIndex;

	private int recordsPerPage = 5;

	private int lastUpdatedRowIndex;
	
	private HtmlOutputLabel COMP_ADS_DIVN_CODE_LABEL;

	private HtmlInputText COMP_ADS_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;
	
	private HtmlInputText COMP_UI_M_DIVN_NAME;

	private HtmlOutputLabel COMP_ADS_DEPT_CODE_LABEL;

	private HtmlInputText COMP_ADS_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_NAME;

	private HtmlOutputLabel COMP_ADS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_ADS_FRZ_FLAG;

	private PM_IL_APPR_DEPT_SETUP PM_IL_APPR_DEPT_SETUP_BEAN;
	
	private String filterByADS_DIVN_CODE;
	
	private String filterByUI_M_DIVN_NAME;
	
	private String filterByADS_DEPT_CODE;
	
	private String filterByUI_M_DEPT_NAME;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private int lastUpdateRowIndex;

	private ArrayList<PM_IL_APPR_DEPT_SETUP> list = new ArrayList<PM_IL_APPR_DEPT_SETUP>();
	
	public PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction;

	private String showfocus;
	PM_IL_APPR_SETUP PM_IL_APPR_SETUP_BEAN;
	
	public PM_IL_APPR_DEPT_SETUP_ACTION() {
		PM_IL_APPR_DEPT_SETUP_BEAN = new PM_IL_APPR_DEPT_SETUP();
		PM_IL_APPR_SETUP_BEAN = new PM_IL_APPR_SETUP();
		
		prevRowIndex = 0;
		currPage = 1;
	}

	public HtmlOutputLabel getCOMP_ADS_DIVN_CODE_LABEL() {
		return COMP_ADS_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ADS_DIVN_CODE() {
		return COMP_ADS_DIVN_CODE;
	}

	public void setCOMP_ADS_DIVN_CODE_LABEL(
			HtmlOutputLabel COMP_ADS_DIVN_CODE_LABEL) {
		this.COMP_ADS_DIVN_CODE_LABEL = COMP_ADS_DIVN_CODE_LABEL;
	}

	public void setCOMP_ADS_DIVN_CODE(HtmlInputText COMP_ADS_DIVN_CODE) {
		this.COMP_ADS_DIVN_CODE = COMP_ADS_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_NAME_LABEL() {
		return COMP_UI_M_DIVN_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_NAME() {
		return COMP_UI_M_DIVN_NAME;
	}

	public void setCOMP_UI_M_DIVN_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL) {
		this.COMP_UI_M_DIVN_NAME_LABEL = COMP_UI_M_DIVN_NAME_LABEL;
	}

	public void setCOMP_UI_M_DIVN_NAME(HtmlInputText COMP_UI_M_DIVN_NAME) {
		this.COMP_UI_M_DIVN_NAME = COMP_UI_M_DIVN_NAME;
	}

	public HtmlOutputLabel getCOMP_ADS_DEPT_CODE_LABEL() {
		return COMP_ADS_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ADS_DEPT_CODE() {
		return COMP_ADS_DEPT_CODE;
	}

	public void setCOMP_ADS_DEPT_CODE_LABEL(
			HtmlOutputLabel COMP_ADS_DEPT_CODE_LABEL) {
		this.COMP_ADS_DEPT_CODE_LABEL = COMP_ADS_DEPT_CODE_LABEL;
	}

	public void setCOMP_ADS_DEPT_CODE(HtmlInputText COMP_ADS_DEPT_CODE) {
		this.COMP_ADS_DEPT_CODE = COMP_ADS_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_NAME_LABEL() {
		return COMP_UI_M_DEPT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_NAME() {
		return COMP_UI_M_DEPT_NAME;
	}

	public void setCOMP_UI_M_DEPT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL) {
		this.COMP_UI_M_DEPT_NAME_LABEL = COMP_UI_M_DEPT_NAME_LABEL;
	}

	public void setCOMP_UI_M_DEPT_NAME(HtmlInputText COMP_UI_M_DEPT_NAME) {
		this.COMP_UI_M_DEPT_NAME = COMP_UI_M_DEPT_NAME;
	}

	public HtmlOutputLabel getCOMP_ADS_FRZ_FLAG_LABEL() {
		return COMP_ADS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_ADS_FRZ_FLAG() {
		return COMP_ADS_FRZ_FLAG;
	}

	public void setCOMP_ADS_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_ADS_FRZ_FLAG_LABEL) {
		this.COMP_ADS_FRZ_FLAG_LABEL = COMP_ADS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_ADS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_ADS_FRZ_FLAG) {
		this.COMP_ADS_FRZ_FLAG = COMP_ADS_FRZ_FLAG;
	}

	public PM_IL_APPR_DEPT_SETUP getPM_IL_APPR_DEPT_SETUP_BEAN() {
		return PM_IL_APPR_DEPT_SETUP_BEAN;
	}

	public void setPM_IL_APPR_DEPT_SETUP_BEAN(
			PM_IL_APPR_DEPT_SETUP PM_IL_APPR_DEPT_SETUP_BEAN) {
		this.PM_IL_APPR_DEPT_SETUP_BEAN = PM_IL_APPR_DEPT_SETUP_BEAN;
	}

	public void fetchDivValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String divn_code = getCOMP_ADS_DIVN_CODE().getSubmittedValue()
				.toString();
		String compCode = "101";
		if (divn_code.length() > 0 && divn_code != null) {
			PILM039_DELIGATE deligate = new PILM039_DELIGATE();
			Object obj = deligate.fetchDIVDESC(divn_code, compCode);
			setPM_IL_APPR_DEPT_SETUP_BEAN((PM_IL_APPR_DEPT_SETUP) obj);
			getCOMP_UI_M_DIVN_NAME().setSubmittedValue(
					getPM_IL_APPR_DEPT_SETUP_BEAN().getUI_M_DIVN_NAME());
			showfocus = "UI_M_DIVN_NAME";
		} else {
			showfocus = "ADS_DIVN_CODE";
		}
	}

	public void fetchDeptValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String divCode = getCOMP_ADS_DIVN_CODE().getSubmittedValue().toString();
		String compCode = "001";
		String deptCode = getCOMP_ADS_DEPT_CODE().getSubmittedValue()
				.toString();
		if (divCode.length() > 0 && deptCode.length() > 0
				&& compCode.length() > 0) {
			PILM039_DELIGATE deligate = new PILM039_DELIGATE();
			Object objBean = deligate
					.fetchDEPTDESC(divCode, compCode, deptCode);
			setPM_IL_APPR_DEPT_SETUP_BEAN((PM_IL_APPR_DEPT_SETUP) objBean);
			getCOMP_UI_M_DEPT_NAME().setSubmittedValue(
					getPM_IL_APPR_DEPT_SETUP_BEAN().getUI_M_DEPT_NAME());
		} else {
			showfocus = "UI_M_DEPT_NAME";
		}
	}

	public String showPrevPage() {

		return "success1";
	}

	public String getShowfocus() {
		return showfocus;
	}

	public void setShowfocus(String showfocus) {
		this.showfocus = showfocus;
	}

	public void asignAllDefaultValues(ActionEvent event) {
		CommonUtils.clearMaps(this);
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		Object valueBean = deligate.assignAllValues();
		setPM_IL_APPR_DEPT_SETUP_BEAN((PM_IL_APPR_DEPT_SETUP) valueBean);
		getCOMP_ADS_DIVN_CODE().setSubmittedValue(
				getPM_IL_APPR_DEPT_SETUP_BEAN().getADS_DIVN_CODE());
		getCOMP_UI_M_DIVN_NAME().setSubmittedValue(
				getPM_IL_APPR_DEPT_SETUP_BEAN().getUI_M_DIVN_NAME());
		getCOMP_ADS_DEPT_CODE().setSubmittedValue(
				getPM_IL_APPR_DEPT_SETUP_BEAN().getADS_DEPT_CODE());
		getCOMP_UI_M_DEPT_NAME().setSubmittedValue(
				getPM_IL_APPR_DEPT_SETUP_BEAN().getUI_M_DEPT_NAME());
	}

	public ArrayList<PM_IL_APPR_DEPT_SETUP> getList() {
		return list;
	}

	public void setList(ArrayList<PM_IL_APPR_DEPT_SETUP> list) {
		this.list = list;
	}

	public PM_IL_APPR_SETUP getPM_IL_APPR_SETUP_BEAN() {
		return PM_IL_APPR_SETUP_BEAN;
	}

	public void setPM_IL_APPR_SETUP_BEAN(PM_IL_APPR_SETUP pm_il_appr_setup_bean) {
		PM_IL_APPR_SETUP_BEAN = pm_il_appr_setup_bean;
	}
	public String headerPage()
	{
		return "header";
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		boolean check=Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setCHECK_BOX(check);
		
		System.out.println("Comming to check box status: " +list.get(rowIndex).isCHECK_BOX());
		return "";
	}
	public String getCurrentValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			System.out.println("CheckBox Checking check");
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}
	
	public String getCurrentDeptValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}
	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//gridtabListener();
	}
	
	// [ Commented for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009 
	
	/*public void gridtabListener() {
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_APPR_DEPT_SETUP detailsBean = null;
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						detailsBean =new PM_IL_APPR_DEPT_SETUP();
						detailsBean = (PM_IL_APPR_DEPT_SETUP) list.get(prevRowIndex);
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return;
	}*/
	// Commented for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009 ]

	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPrevRowIndex() {
		return prevRowIndex;
	}
	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
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
	public String addNew() {
		CommonUtils.clearMaps(this);
		int rowCount = 0;
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
		if (list == null) {
			list = new ArrayList<PM_IL_APPR_DEPT_SETUP>();
		}
		compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		list.add(compositeAction.getPM_IL_APPR_DEPT_SETUP_ACTION_BEAN().getPM_IL_APPR_DEPT_SETUP_BEAN());
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return null;
	}

	/*public String deleteRow() {
		CommonUtils.clearMaps(this);
		PM_IL_APPR_DEPT_SETUP bean = null;
		ArrayList deletedRecordList = null;
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		int deletedRecordIndex = 0;
		if (list != null) {
			deletedRecordList = new ArrayList();
			for (int index = 0; index < list.size();) {
				bean = list.get(index);
				if (bean.isCHECK_BOX()) {
					list.remove(bean);
					deletedRecordIndex = deligate.deleteDataDEPT(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if (deletedRecordList.size() > 0) {
				getErrorMap().put("somekey", deletedRecordList.size()+ " records deleted.");
				getErrorMap().put("current", deletedRecordList.size()+ " records deleted.");
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}*/
	
	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */
	/*public String deleteRow(ActionEvent ae) {

		try {
			LOG.info("Inside Delete Method");
			PILM039_DELIGATE deligate = new PILM039_DELIGATE();
			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			PM_IL_APPR_DEPT_SETUP bean = null;
			ArrayList<Integer> deletedRecordList = null;
			int deletedRecordIndex = 0;

			if (list != null) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < list.size();) {
					bean = list.get(index);
					if ("dataTableSelectedRow".equalsIgnoreCase(bean
							.getRowSelected())) {
						list.remove(bean);
						deletedRecordIndex = deligate.deleteDataDEPT(bean);
						deletedRecordList.add(deletedRecordIndex);

					} else {
						index++;
					}
				}
				for(int i=0;i<list.size();i++){
					PM_IL_APPR_DEPT_SETUP pm_il_appr_dept_setup = list.get(i);
					if(i==0){
						pm_il_appr_dept_setup.setRowSelected(true);
						setPM_IL_APPR_DEPT_SETUP_BEAN(pm_il_appr_dept_setup);
					}else{
						pm_il_appr_dept_setup.setRowSelected(false);
					}
				}
				if(list.isEmpty()){
					PM_IL_APPR_DEPT_SETUP_BEAN = new PM_IL_APPR_DEPT_SETUP();
					setPM_IL_APPR_DEPT_SETUP_BEAN(PM_IL_APPR_DEPT_SETUP_BEAN);
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current",
							+deletedRecordList.size() + "Record Deleted ");

				}
				lastUpdateRowIndex = -1;

			}
			resetAllComponent();
		}catch(Exception exception){
		}
		return "";
	}*/
	public void deleteRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			String message=null;
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_APPR_DEPT_SETUP_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message=Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,message);
				list.remove(PM_IL_APPR_DEPT_SETUP_BEAN);
				if (list.size() > 0) {
					PM_IL_APPR_DEPT_SETUP_BEAN = list.get(0);
				} else if (list.size() == 0) {

					AddRow(null);
				}
				resetAllComponent();
				PM_IL_APPR_DEPT_SETUP_BEAN.setRowSelected(true);
			} else {
				message=Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,message);
		} 
		}catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					exc.getMessage());
		}

	}

	//public void branchCode(ActionEvent actionEvent){
	public void branchCode(FacesContext fc, UIComponent component,Object value) {
		UIInput inputText = (UIInput)component;
		//String insertedValue=getCurrentValue(actionEvent);
		String insertedValue=(String) inputText.getSubmittedValue();
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		//UIInput input = (UIInput) actionEvent.getComponent().getParent();
		//ErrorHelpUtil.validate(inputText, getErrorMap());
		//int rowIndex = getDataTable().getRowIndex();
		
		if(!"".equalsIgnoreCase(insertedValue) && !insertedValue.isEmpty()){
			//list.get(rowIndex).setADS_DIVN_CODE(insertedValue);
			String descField = deligate.ON_VALIDATE_DIVN_CODE(insertedValue);
			getCOMP_UI_M_DIVN_NAME().setSubmittedValue(descField);
			//gridtabListener();
		}else{
			getCOMP_UI_M_DIVN_NAME().setSubmittedValue("");
			throw new ValidatorException(new FacesMessage("Invalid Division code"));
		}
		
	}
	public void deptCode(ActionEvent actionEvent){
		CommonUtils.clearMaps(this);
		System.out.println("Calling 1 : ");
		String departmentValue=getCurrentDeptValue(actionEvent);
		CommonUtils commonUtils =new CommonUtils();
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		//ErrorHelpUtil.validate(input, getErrorMap());
		boolean flag=false;
		removeErrorPanelMessages();
		Date currDate =new Date();
		int rowIndex = getDataTable().getRowIndex();
		int errorcode=-1;
		if(!"".equalsIgnoreCase(departmentValue) && !departmentValue.isEmpty()){
			//String divName = list.get(rowIndex).getADS_DIVN_CODE();
			String divName = "";
			if(COMP_ADS_DIVN_CODE.getSubmittedValue()!=null){
				divName = COMP_ADS_DIVN_CODE.getSubmittedValue().toString();
			}
			String descField = deligate.ON_VALIDATE_DEPT_CODE(divName,departmentValue);
			getCOMP_UI_M_DEPT_NAME().setSubmittedValue(descField);
			//list.get(rowIndex).setADS_DEPT_CODE(departmentValue);
			//added by Varun(50663)
			PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction=null;
			compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
			
			PM_IL_APPR_SETUP valueBean =compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();
			//changed
			PM_IL_APPR_DEPT_SETUP gridValueBean = null;
			String divnCode = "";
			String deptCode = "";
			String fmProdCode = "";
			String toProdCode = "";
			for(int i=0;i<list.size();i++){
				gridValueBean = list.get(i);	
				if("dataTableSelectedRow".equalsIgnoreCase(gridValueBean.getRowSelected())){
					divnCode= gridValueBean.getADS_DIVN_CODE();
					deptCode = gridValueBean.getADS_DEPT_CODE();
					fmProdCode= gridValueBean.getADS_FM_PROD_CODE();
					toProdCode = gridValueBean.getADS_TO_PROD_CODE();
				}
			}
			//PM_IL_APPR_DEPT_SETUP gridValueBean = (PM_IL_APPR_DEPT_SETUP)list.get(rowIndex);
			
			try {
				new PILM039_HELPER().L_UNIQUE_ADS_DEPT_CODE(valueBean.getAS_USER_ID(),
									divnCode,
									deptCode,
									fmProdCode,
									toProdCode);
			} catch (SQLException e) {
				errorcode=e.getErrorCode();
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if (errorcode == 20100) {
					try {
						System.out.println("Error : is there");
						flag=true;
						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), FacesContext.getCurrentInstance(),getCOMP_ADS_DEPT_CODE()
								.getClientId(FacesContext.getCurrentInstance()), getWarningMap());
						
					} catch (ValidatorException e) {
						getErrorMap().put("current", e.getMessage());
						e.printStackTrace();
					} catch (DBException e) {
						e.printStackTrace();
					}
				}
			}
			//ErrorHelpUtil.validate(input, getErrorMap());
			//End
			if(!flag){
				//lastColumnListener();
			}
		}else{
			getCOMP_UI_M_DEPT_NAME().setSubmittedValue("");
			throw new ValidatorException(new FacesMessage("Invalid User Id"));
		}
		
		
	}
	
	public void whenValidateADS_DIVN_CODE() throws Exception{
		try {
			ArrayList<OracleParameter> list =   new DBProcedures().P_VAL_DIVN(PM_IL_APPR_DEPT_SETUP_BEAN.getADS_DIVN_CODE(),
			             PM_IL_APPR_DEPT_SETUP_BEAN.getUI_M_DIVN_NAME(),
			             "N","E");
			if(!list.isEmpty()){
				PM_IL_APPR_DEPT_SETUP_BEAN.setUI_M_DIVN_NAME(list.get(0).getValue());
			}
		} catch (ProcedureException e) {
			PM_IL_APPR_DEPT_SETUP_BEAN.setUI_M_DIVN_NAME("");
			throw new Exception(e.getMessage());
		}
	}
	
	public void validateADS_DIVN_CODE(FacesContext facesContext,
    		UIComponent component, Object value) throws ValidatorException {
    	CommonUtils.clearMaps(this);
    	try {
    		PM_IL_APPR_DEPT_SETUP_BEAN.setADS_DIVN_CODE((String) value);
    		whenValidateADS_DIVN_CODE();
    	} catch (Exception exception) {
    		exception.printStackTrace();
    		throw new ValidatorException(new FacesMessage(exception
    				.getMessage()));
    	} finally {
    		try {
    			ErrorHelpUtil.getWarningForProcedure(CommonUtils
    					.getConnection(), "ADS_DIVN_CODE",
    					getWarningMap());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
	
	public void whenValidateADS_DEPT_CODE() throws Exception{
		try {
			ArrayList<String> list = new DBProcedures().callP_VAL_DEPT(PM_IL_APPR_DEPT_SETUP_BEAN.getADS_DIVN_CODE(),
			             PM_IL_APPR_DEPT_SETUP_BEAN.getADS_DEPT_CODE(),
			             "N","E");
			if(!list.isEmpty()){
				 PM_IL_APPR_DEPT_SETUP_BEAN.setUI_M_DEPT_NAME(list.get(0));
			}
			L_UNIQUE_ADS_DEPT_CODE();
		} catch (Exception e) {
			 PM_IL_APPR_DEPT_SETUP_BEAN.setUI_M_DEPT_NAME("");
			throw new Exception(e.getMessage());
		}
	}
	
	public void validateADS_DEPT_CODE(FacesContext facesContext,
    		UIComponent component, Object value) throws ValidatorException {
    	CommonUtils.clearMaps(this);
    	try {
    		PM_IL_APPR_DEPT_SETUP_BEAN.setADS_DEPT_CODE((String) value);
    		whenValidateADS_DEPT_CODE();
    	} catch (Exception exception) {
    		exception.printStackTrace();
    		throw new ValidatorException(new FacesMessage(exception
    				.getMessage()));
    	} finally {
    		try {
    			ErrorHelpUtil.getWarningForProcedure(CommonUtils
    					.getConnection(), "ADS_DEPT_CODE",
    					getWarningMap());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
	
	public void L_UNIQUE_ADS_DEPT_CODE() throws Exception{
		String M_TEMP = null;   
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			
			
			if(null!=PM_IL_APPR_DEPT_SETUP_BEAN.getADS_DIVN_CODE()&&null!=PM_IL_APPR_DEPT_SETUP_BEAN.getADS_DEPT_CODE()&&
					null!=PM_IL_APPR_DEPT_SETUP_BEAN.getADS_FM_PROD_CODE()&&null!=
						PM_IL_APPR_DEPT_SETUP_BEAN.getADS_TO_PROD_CODE()){
				
				connection = CommonUtils.getConnection();
				
				String C1 = "SELECT ROWID FROM   PM_IL_APPR_DEPT_SETUP WHERE  ADS_USER_ID   = ? " +
						"AND    ADS_DIVN_CODE = ? AND    " +
						"ADS_DEPT_CODE = ?  AND   " +
						" ADS_FM_PROD_CODE = ? AND    " +
						"ADS_TO_PROD_CODE = ?";
				Object[] c1values = {compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN().getAS_USER_ID(),
						PM_IL_APPR_DEPT_SETUP_BEAN.getADS_DIVN_CODE(),PM_IL_APPR_DEPT_SETUP_BEAN.getADS_DEPT_CODE(),
						PM_IL_APPR_DEPT_SETUP_BEAN.getADS_FM_PROD_CODE(),
						PM_IL_APPR_DEPT_SETUP_BEAN.getADS_TO_PROD_CODE()};
				resultSet = handler.executeSelectStatement(C1, connection,c1values);
				if(resultSet.next()){
				    M_TEMP = resultSet.getString(1);
				    if(CommonUtils.isDuplicate(PM_IL_APPR_DEPT_SETUP_BEAN.getROWID(), M_TEMP)){
				    throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "11304",
							new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				    }
				}
				}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void lastColumnListener(){
		CommonUtils commonUtils = new CommonUtils();
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_APPR_DEPT_SETUP gridValueBean = null;
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		PILM039_HELPER helper = new PILM039_HELPER();
		String rowId = null;
		
		try {
			PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction=null;
			compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
			
			PM_IL_APPR_SETUP valueBean =compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();
				gridValueBean = (PM_IL_APPR_DEPT_SETUP)list.get(currRowIndex);
				rowId = gridValueBean.getROWID();
				
				String UserId=valueBean.getAS_USER_ID();
				String FromProd=valueBean.getAS_FM_PROD_CODE();
				String ToProd=valueBean.getAS_TO_PROD_CODE();
				gridValueBean.setADS_FM_PROD_CODE(FromProd);
				gridValueBean.setADS_TO_PROD_CODE(ToProd);
				gridValueBean.setADS_USER_ID(UserId);
				
				if(rowId== null){
					helper.PILM039_PM_IL_APPR_DEPT_PRE_INSERT(gridValueBean);
				}else{
					helper.PILM039_PM_IL_APPR_DEPT_PRE_UPDATE(gridValueBean);
				}
				rowUpdated = deligate.updateDataDEPT(gridValueBean);
				
				if (rowId == null){
					String insertMessage = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$insert");
					getWarningMap().put("current", rowUpdated+" "+insertMessage);
				}else{
					String updateMessage = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$update");
					getWarningMap().put("current", rowUpdated+" "+updateMessage);
				}
				lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}
	public void validatePILM039User(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public List divisionSuggestion(Object userLOVObject) throws SQLException, UserApprovalException{
		List list = new ArrayList();
		PILM039_DELIGATE delgate =new PILM039_DELIGATE();
		String value = userLOVObject.toString();
		
		String query = null ;
		if(value.equalsIgnoreCase("*")){
			query = PILM039_QUERY_CONSTANT.PILM039_LOV_DIVISION_CODE;
			Object[] values={};
			list = delgate.divisionCodeList(query,values);
		}else{
			query =PILM039_QUERY_CONSTANT.PILM039_LOV_DIVISION_CODE_LIKE;
			Object[] values={value+"%"};
			list = delgate.divisionCodeList(query,values);
		}
		return list;
	}
	
	public List deptSuggestion(Object userLOVObject) throws SQLException, UserApprovalException{
		List list = new ArrayList();
		PILM039_DELIGATE delgate =new PILM039_DELIGATE();
		String value = userLOVObject.toString();
		
		String query = null ;
		if(value.equalsIgnoreCase("*")){
			query = PILM039_QUERY_CONSTANT.PILM039_LOV_DEPT_CODE;
			Object[] values={};
			list = delgate.deptCodeList(query,values);
		}else{
			query =PILM039_QUERY_CONSTANT.PILM039_LOV_DEPT_CODE_LIKE;
			Object[] values={value+"%"};
			list = delgate.deptCodeList(query,values);
		}
		return list;
	}
	
	public void divisionAutoPopulate(ActionEvent ae) throws UserApprovalException{
		CommonUtils.clearMaps(this);
		PILM039_DELIGATE newDeligate = new PILM039_DELIGATE();
		String insertedValue=getCurrentValue(ae);
		
		if (insertedValue != null) {
			int rowIndex = getDataTable().getRowIndex();
			
			String descField = newDeligate.ON_VALIDATE_DIVN_CODE(insertedValue);
			if (descField != null && descField.length() > 0) {
				list.get(rowIndex).setADS_DIVN_CODE(insertedValue);
				PM_IL_APPR_DEPT_SETUP_BEAN.setUI_M_DIVN_NAME(descField); 
				getCOMP_UI_M_DIVN_NAME().setSubmittedValue(null);
				//gridtabListener();
			} else {
				getCOMP_UI_M_DIVN_NAME().setSubmittedValue("kjdfhkjhf");
				throw new ValidatorException(new FacesMessage("From product code not available"));
			}
		}
		else{
			getCOMP_UI_M_DIVN_NAME().setSubmittedValue("");
		}
		
	}
	
	public void deptCodeAutoComplete(ActionEvent actionEvent)
	{
		CommonUtils.clearMaps(this);
		System.out.println("Calling 1 : ");
		String departmentValue=getCurrentDeptValue(actionEvent);
		CommonUtils commonUtils =new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction=null;
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		
		compositeAction =new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		
		PM_IL_APPR_SETUP valueBean =compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();
		
		
		String UserId=valueBean.getAS_USER_ID();
		String FromProd=valueBean.getAS_FM_PROD_CODE();
		String ToProd=valueBean.getAS_TO_PROD_CODE();
		
		int rowIndex = getDataTable().getRowIndex();
		
		if(!"".equalsIgnoreCase(departmentValue) && !departmentValue.isEmpty()){
			String divName = list.get(rowIndex).getADS_DIVN_CODE();
			String descField = deligate.ON_VALIDATE_DEPT_CODE(divName,departmentValue);
			getCOMP_UI_M_DEPT_NAME().setSubmittedValue(descField);

			list.get(rowIndex).setADS_DEPT_CODE(departmentValue);
			list.get(rowIndex).setADS_USER_ID(UserId);
			list.get(rowIndex).setADS_FM_PROD_CODE(FromProd);
			list.get(rowIndex).setADS_TO_PROD_CODE(ToProd);
			list.get(rowIndex).setADS_FRZ_FLAG("N");
			
			//lastColumnListener();
		}else{
			getCOMP_UI_M_DEPT_NAME().setSubmittedValue("");
			throw new ValidatorException(new FacesMessage("Invalid User Id"));
		}
		
		
	}
	
	private ArrayList<PM_IL_APPR_DEPT_SETUP> divnLovList;
	public ArrayList<PM_IL_APPR_DEPT_SETUP> getDivnLovList(Object string){
		PILM039_DELIGATE delegate = new PILM039_DELIGATE();

		try {
			divnLovList = delegate.getDivnLov((String)string);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    				e.getMessage());
    		getErrorMap().put("divnLov", e.getMessage());
		} 
		
		return divnLovList;
	}
	public void rerenderOnDivnCodeSelect(ActionEvent event){
		CommonUtils.clearMaps(this);
		Iterator<PM_IL_APPR_DEPT_SETUP> iterator = null;
		PM_IL_APPR_DEPT_SETUP bean = null;
		boolean keepLooking = true;
		String divnCode = null;
		int rowIndex = dataTable.getRowIndex();
		String divnName = null;
		
		divnCode = ((UIInput)(event.getComponent().getParent().getParent())).getSubmittedValue().toString();
		System.out.println("Submitted value is: "+divnCode);
		if(divnCode != null && !divnCode.trim().isEmpty()){
			if(divnLovList != null){
				iterator = divnLovList.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					if(bean.getADS_DIVN_CODE().equalsIgnoreCase(divnCode)){
						divnName = bean.getUI_M_DIVN_NAME();
						System.out.println("Description is: "+divnName);
						list.get(rowIndex).setADS_DIVN_CODE(divnCode);
						list.get(rowIndex).setUI_M_DIVN_NAME(divnName);
						divnLovList = null;
						keepLooking = false;
					}
				}
			}
		}
	}
	
	private ArrayList<PM_IL_APPR_DEPT_SETUP> deptLovList;
	public ArrayList<PM_IL_APPR_DEPT_SETUP> getDeptLovList(Object string){
		PILM039_DELIGATE delegate = new PILM039_DELIGATE();

		try {
			deptLovList = delegate.getDeptLov((String)string, PM_IL_APPR_DEPT_SETUP_BEAN.getADS_DIVN_CODE());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    				e.getMessage());
    		getErrorMap().put("deptLov", e.getMessage());
		} 
		
		return deptLovList;
	}
	public void rerenderOnDeptCodeSelect(ActionEvent event){
		CommonUtils.clearMaps(this);
		Iterator<PM_IL_APPR_DEPT_SETUP> iterator = null;
		PM_IL_APPR_DEPT_SETUP bean = null;
		boolean keepLooking = true;
		String deptCode = null;
		int rowIndex = dataTable.getRowIndex();
		String deptName = null;
		
		deptCode = ((UIInput)(event.getComponent().getParent().getParent())).getSubmittedValue().toString();
		System.out.println("Submitted value is: "+deptCode);
		if(deptCode != null && !deptCode.trim().isEmpty()){
			if(deptLovList != null){
				iterator = deptLovList.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					if(bean.getADS_DEPT_CODE().equalsIgnoreCase(deptCode)){
						deptName = bean.getUI_M_DEPT_NAME();
						System.out.println("Description is: "+deptName);
						list.get(rowIndex).setADS_DEPT_CODE(deptCode);
						list.get(rowIndex).setUI_M_DEPT_NAME(deptName);
						deptLovList = null;
						keepLooking = false;
						//lastColumnListener();
					}
				}
			}
		}
	}
	
	public String rightPage() {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanACtion = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanACtion.callRightPage();
		return "rights";
	}
	public String limitsPage() {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanACtion = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanACtion.callLimitsPage();
		return "limits";
	}
	public String processPage() {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanACtion = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanACtion.callProcessPage();
		return "process";
	}
	public String divisionmainPage() {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanACtion = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanACtion.calldivisionPage();
		return "divisonSearchPage";
	}
	public String saveAndCommit(){
		CommonUtils commonUtils = new CommonUtils();
		String message=null;
		try {
			commonUtils.doComitt();
			message=Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
			getWarningMap().put("current", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public String checkBoxFlagStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		String checkValue=getCurrentValue(actionEvent);
		String assignCheckValue ="";
		if("true".equalsIgnoreCase(checkValue)){
			assignCheckValue="Y";
		}else{
			assignCheckValue="N";
		}

		int rowIndex =getDataTable().getRowIndex();
		list.get(rowIndex).setADS_FRZ_FLAG(assignCheckValue);
		
		return "";
	}
	public void checkBoxFlagValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//lastColumnListener();
	}
	public void removeErrorPanelMessages(){
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");

		}
	}
	
	// [ Added for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009
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
	// Added for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009 ]
	
	public void getDetails() {
		CommonUtils.clearMaps(this);
		try {
			if (list.size() != 0) {				
				PM_IL_APPR_DEPT_SETUP_BEAN = (PM_IL_APPR_DEPT_SETUP) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_APPR_DEPT_SETUP_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reset the Grid Values.
	 */
	public void resetAllComponent(){
		COMP_UI_M_DIVN_NAME.resetValue();
		COMP_ADS_DIVN_CODE.resetValue();
		COMP_UI_M_DEPT_NAME.resetValue();
		COMP_ADS_DEPT_CODE.resetValue();
	}


	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_APPR_DEPT_SETUP> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void post(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		try{
			LOG.info("=============>Branch Code========>"+PM_IL_APPR_DEPT_SETUP_BEAN.getADS_DIVN_CODE());
			LOG.info("=============>Dept Code========>"+PM_IL_APPR_DEPT_SETUP_BEAN.getADS_DIVN_CODE());
			
			ControlBean controlBean = CommonUtils.getControlBean();
			if(PM_IL_APPR_DEPT_SETUP_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					setBeanValue();
					preUpdate();
					new CRUDHandler().executeInsert(PM_IL_APPR_DEPT_SETUP_BEAN, new CommonUtils().getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {

				if(isINSERT_ALLOWED()) {
					PILM039_DELIGATE deligate = new PILM039_DELIGATE();
					setBeanValue();
					preInsert();
					new CRUDHandler().executeInsert(PM_IL_APPR_DEPT_SETUP_BEAN, new CommonUtils().getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					
					list.add(0,PM_IL_APPR_DEPT_SETUP_BEAN);
					
					for(int i=0;i<list.size();i++){
						PM_IL_APPR_DEPT_SETUP pm_il_appr_dept_setup = list.get(i);
						if(i==0){
							pm_il_appr_dept_setup.setRowSelected(true);
							setPM_IL_APPR_DEPT_SETUP_BEAN(pm_il_appr_dept_setup);
						}else{
							pm_il_appr_dept_setup.setRowSelected(false);
						}
					}
					if(list.isEmpty()){
						PM_IL_APPR_DEPT_SETUP_BEAN = new PM_IL_APPR_DEPT_SETUP();
						setPM_IL_APPR_DEPT_SETUP_BEAN(PM_IL_APPR_DEPT_SETUP_BEAN);
					}
					
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	/**
	 * Sets the Bean value.
	 * @param branchCode
	 * @param deptCode
	 */
	private void setBeanValue() {
		if(compositeAction
				.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN() != null){
		PM_IL_APPR_SETUP valueBean = compositeAction
				.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();

		String userId = valueBean.getAS_USER_ID();
		String fromProd = valueBean.getAS_FM_PROD_CODE();
		String toProd = valueBean.getAS_TO_PROD_CODE();

		PM_IL_APPR_DEPT_SETUP_BEAN.setADS_USER_ID(userId);
		PM_IL_APPR_DEPT_SETUP_BEAN.setADS_FM_PROD_CODE(fromProd);
		PM_IL_APPR_DEPT_SETUP_BEAN.setADS_TO_PROD_CODE(toProd);
	}
	}	
	public void saveData(){
		CommonUtils.clearMaps(this);
		try {
			if (getPM_IL_APPR_DEPT_SETUP_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getPM_IL_APPR_DEPT_SETUP_BEAN(),
						CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getPM_IL_APPR_DEPT_SETUP_BEAN(),
						CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
			String message = "";
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	}
	
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_IL_APPR_DEPT_SETUP_BEAN = new PM_IL_APPR_DEPT_SETUP();
				resetAllComponent();
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
	
	public void preInsert() throws Exception{
	   try {
			L_UNIQUE_ADS_DEPT_CODE();
			PM_IL_APPR_DEPT_SETUP_BEAN.setADS_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_APPR_DEPT_SETUP_BEAN.setADS_CR_UID(CommonUtils
					.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	}
	
	public void preUpdate() throws Exception{
		   try {
			PM_IL_APPR_DEPT_SETUP_BEAN.setADS_UPD_DT(new CommonUtils().getCurrentDate());
			   PM_IL_APPR_DEPT_SETUP_BEAN.setADS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			if (PM_IL_APPR_DEPT_SETUP_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				preInsert();
				new CRUDHandler().executeInsert(PM_IL_APPR_DEPT_SETUP_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");
				list.add(PM_IL_APPR_DEPT_SETUP_BEAN);
			} else if (PM_IL_APPR_DEPT_SETUP_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				preUpdate();
				new CRUDHandler().executeUpdate(PM_IL_APPR_DEPT_SETUP_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");

			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("postRecord", message);
			PM_IL_APPR_DEPT_SETUP_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}
	
	

	/**
	 * @return the filterByADS_DIVN_CODE
	 */
	public String getFilterByADS_DIVN_CODE() {
		return filterByADS_DIVN_CODE;
	}

	/**
	 * @param filterByADS_DIVN_CODE the filterByADS_DIVN_CODE to set
	 */
	public void setFilterByADS_DIVN_CODE(String filterByADS_DIVN_CODE) {
		this.filterByADS_DIVN_CODE = filterByADS_DIVN_CODE;
	}

	/**
	 * @return the filterByUI_M_DIVN_NAME
	 */
	public String getFilterByUI_M_DIVN_NAME() {
		return filterByUI_M_DIVN_NAME;
	}

	/**
	 * @param filterByUI_M_DIVN_NAME the filterByUI_M_DIVN_NAME to set
	 */
	public void setFilterByUI_M_DIVN_NAME(String filterByUI_M_DIVN_NAME) {
		this.filterByUI_M_DIVN_NAME = filterByUI_M_DIVN_NAME;
	}

	/**
	 * @return the filterByADS_DEPT_CODE
	 */
	public String getFilterByADS_DEPT_CODE() {
		return filterByADS_DEPT_CODE;
	}

	/**
	 * @param filterByADS_DEPT_CODE the filterByADS_DEPT_CODE to set
	 */
	public void setFilterByADS_DEPT_CODE(String filterByADS_DEPT_CODE) {
		this.filterByADS_DEPT_CODE = filterByADS_DEPT_CODE;
	}

	/**
	 * @return the filterByUI_M_DEPT_NAME
	 */
	public String getFilterByUI_M_DEPT_NAME() {
		return filterByUI_M_DEPT_NAME;
	}

	/**
	 * @param filterByUI_M_DEPT_NAME the filterByUI_M_DEPT_NAME to set
	 */
	public void setFilterByUI_M_DEPT_NAME(String filterByUI_M_DEPT_NAME) {
		this.filterByUI_M_DEPT_NAME = filterByUI_M_DEPT_NAME;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DEL
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	/**
	 * @param ui_m_but_del the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	/**
	 * @return the lastUpdateRowIndex
	 */
	public int getLastUpdateRowIndex() {
		return lastUpdateRowIndex;
	}

	/**
	 * @param lastUpdateRowIndex the lastUpdateRowIndex to set
	 */
	public void setLastUpdateRowIndex(int lastUpdateRowIndex) {
		this.lastUpdateRowIndex = lastUpdateRowIndex;
	}
}
