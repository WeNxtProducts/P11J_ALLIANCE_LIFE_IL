package com.iii.pel.forms.PILM043;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_CUST_CHRG_ACTION extends CommonAction{

	
	private HtmlOutputLabel COMP_RCC_RPCVR_CODE_LABEL;
	private HtmlOutputLabel COMP_RCC_RPCUST_CODE_LABEL;
	private HtmlOutputLabel COMP_RCC_SRNO_LABEL;
	private HtmlOutputLabel COMP_RCC_CHRG_TYPE_LABEL;
	private HtmlOutputLabel COMP_RCC_CHRG_CODE_LABEL;
	private HtmlOutputLabel COMP_RCC_RATE_LABEL;
	private HtmlOutputLabel COMP_RCC_RATE_PER_LABEL;
	private HtmlOutputLabel COMP_RCC_CUST_SHARE_PERC_LABEL;
	private HtmlOutputLabel COMP_RCC_APPLY_PERIOD_LABEL;

	private HtmlInputText COMP_RCC_RPCVR_CODE;
	private HtmlInputText COMP_RCC_RPCUST_CODE;
	private HtmlInputText COMP_RCC_SRNO;
	private HtmlInputText COMP_RCC_CHRG_CODE;
	private HtmlInputText COMP_RCC_RATE;
	private HtmlInputText COMP_RCC_RATE_PER;
	private HtmlInputText COMP_RCC_CUST_SHARE_PERC;

	private HtmlSelectOneMenu COMP_RCC_CHRG_TYPE;
	private HtmlSelectOneMenu COMP_RCC_APPLY_PERIOD;

	private PM_IL_RI_CUST_CHRG PM_IL_RI_CUST_CHRG_BEAN;

	private int recordPerPage = 5;
	
	private int lastUpdatedRowIndex;
	
	private ArrayList<PM_IL_RI_CUST_CHRG> dataTableList;
	private UIData dataTable;
	
	
	private List<SelectItem> applyChargePeriodList = new ArrayList<SelectItem>();
	private List<SelectItem> chargeTypeList= new ArrayList<SelectItem>();
	
	List RI_POOL_SETUP_LIST = null;
	
	private String filterByRCC_CHRG_CODE;
	
	private String filterByRCC_CHRG_TYPE;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private Map<String, String> errorMap = new HashMap<String, String>();

//	private HtmlCommandButton COMP_UI_M_BUT_MAIN;
//
//	private HtmlCommandButton COMP_UI_M_BUT_CHG_TYP_LOV;

	private PM_IL_RI_CUST_CHRG_HELPER helper;
	private PM_IL_RI_CUST_CHRG_DELEGATE delegate;
	public PM_IL_RI_CUST_CHRG_ACTION() throws DBException {
		PM_IL_RI_CUST_CHRG_BEAN = new PM_IL_RI_CUST_CHRG();
		dataTableList = new ArrayList();
		 delegate = new PM_IL_RI_CUST_CHRG_DELEGATE();
		helper = new PM_IL_RI_CUST_CHRG_HELPER();
		applyChargePeriodList = delegate.comboBoxValue(
				Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_CUST_CHRG$FORM_NAME"),
				Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_CUST_CHRG$BLOCK_NAME$PM_IL_RI_CUST_CHRG"),
				Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_CUST_CHRG$FIELD_NAME$RCC_APPLY_PERIOD"),
				Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_CUST_CHRG$SYSTEM_PARAM$RCC_APPLY_PERIOD"));
		
		chargeTypeList = delegate.comboBoxValue(
				Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_CUST_CHRG$FORM_NAME"),
				Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_CUST_CHRG$BLOCK_NAME$PM_IL_RI_CUST_CHRG"),
				Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_CUST_CHRG$FIELD_NAME$RCC_CHRG_TYPE"),
				Messages.getString("messageProperties_PILM043", "PILM043$PM_IL_RI_CUST_CHRG$SYSTEM_PARAM$RCC_CHRG_TYPE"));
	
		
	}
	
	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public ArrayList<PM_IL_RI_CUST_CHRG> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(ArrayList<PM_IL_RI_CUST_CHRG> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}



	public HtmlOutputLabel getCOMP_RCC_RPCVR_CODE_LABEL() {
		return COMP_RCC_RPCVR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RCC_RPCVR_CODE() {
		return COMP_RCC_RPCVR_CODE;
	}

	public void setCOMP_RCC_RPCVR_CODE_LABEL(HtmlOutputLabel COMP_RCC_RPCVR_CODE_LABEL) {
		this.COMP_RCC_RPCVR_CODE_LABEL = COMP_RCC_RPCVR_CODE_LABEL;
	}

	public void setCOMP_RCC_RPCVR_CODE(HtmlInputText COMP_RCC_RPCVR_CODE) {
		this.COMP_RCC_RPCVR_CODE = COMP_RCC_RPCVR_CODE;
	}

	public HtmlOutputLabel getCOMP_RCC_RPCUST_CODE_LABEL() {
		return COMP_RCC_RPCUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RCC_RPCUST_CODE() {
		return COMP_RCC_RPCUST_CODE;
	}

	public void setCOMP_RCC_RPCUST_CODE_LABEL(HtmlOutputLabel COMP_RCC_RPCUST_CODE_LABEL) {
		this.COMP_RCC_RPCUST_CODE_LABEL = COMP_RCC_RPCUST_CODE_LABEL;
	}

	public void setCOMP_RCC_RPCUST_CODE(HtmlInputText COMP_RCC_RPCUST_CODE) {
		this.COMP_RCC_RPCUST_CODE = COMP_RCC_RPCUST_CODE;
	}

	public HtmlOutputLabel getCOMP_RCC_SRNO_LABEL() {
		return COMP_RCC_SRNO_LABEL;
	}

	public HtmlInputText getCOMP_RCC_SRNO() {
		return COMP_RCC_SRNO;
	}

	public void setCOMP_RCC_SRNO_LABEL(HtmlOutputLabel COMP_RCC_SRNO_LABEL) {
		this.COMP_RCC_SRNO_LABEL = COMP_RCC_SRNO_LABEL;
	}

	public void setCOMP_RCC_SRNO(HtmlInputText COMP_RCC_SRNO) {
		this.COMP_RCC_SRNO = COMP_RCC_SRNO;
	}

	public HtmlOutputLabel getCOMP_RCC_CHRG_TYPE_LABEL() {
		return COMP_RCC_CHRG_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_RCC_CHRG_TYPE() {
		return COMP_RCC_CHRG_TYPE;
	}

	public void setCOMP_RCC_CHRG_TYPE_LABEL(HtmlOutputLabel COMP_RCC_CHRG_TYPE_LABEL) {
		this.COMP_RCC_CHRG_TYPE_LABEL = COMP_RCC_CHRG_TYPE_LABEL;
	}

	public void setCOMP_RCC_CHRG_TYPE(HtmlSelectOneMenu COMP_RCC_CHRG_TYPE) {
		this.COMP_RCC_CHRG_TYPE = COMP_RCC_CHRG_TYPE;
	}

	public HtmlOutputLabel getCOMP_RCC_CHRG_CODE_LABEL() {
		return COMP_RCC_CHRG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RCC_CHRG_CODE() {
		return COMP_RCC_CHRG_CODE;
	}

	public void setCOMP_RCC_CHRG_CODE_LABEL(HtmlOutputLabel COMP_RCC_CHRG_CODE_LABEL) {
		this.COMP_RCC_CHRG_CODE_LABEL = COMP_RCC_CHRG_CODE_LABEL;
	}

	public void setCOMP_RCC_CHRG_CODE(HtmlInputText COMP_RCC_CHRG_CODE) {
		this.COMP_RCC_CHRG_CODE = COMP_RCC_CHRG_CODE;
	}

	public HtmlOutputLabel getCOMP_RCC_RATE_LABEL() {
		return COMP_RCC_RATE_LABEL;
	}

	public HtmlInputText getCOMP_RCC_RATE() {
		return COMP_RCC_RATE;
	}

	public void setCOMP_RCC_RATE_LABEL(HtmlOutputLabel COMP_RCC_RATE_LABEL) {
		this.COMP_RCC_RATE_LABEL = COMP_RCC_RATE_LABEL;
	}

	public void setCOMP_RCC_RATE(HtmlInputText COMP_RCC_RATE) {
		this.COMP_RCC_RATE = COMP_RCC_RATE;
	}

	public HtmlOutputLabel getCOMP_RCC_RATE_PER_LABEL() {
		return COMP_RCC_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_RCC_RATE_PER() {
		return COMP_RCC_RATE_PER;
	}

	public void setCOMP_RCC_RATE_PER_LABEL(HtmlOutputLabel COMP_RCC_RATE_PER_LABEL) {
		this.COMP_RCC_RATE_PER_LABEL = COMP_RCC_RATE_PER_LABEL;
	}

	public void setCOMP_RCC_RATE_PER(HtmlInputText COMP_RCC_RATE_PER) {
		this.COMP_RCC_RATE_PER = COMP_RCC_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_RCC_APPLY_PERIOD_LABEL() {
		return COMP_RCC_APPLY_PERIOD_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_RCC_APPLY_PERIOD() {
		return COMP_RCC_APPLY_PERIOD;
	}

	public void setCOMP_RCC_APPLY_PERIOD_LABEL(HtmlOutputLabel COMP_RCC_APPLY_PERIOD_LABEL) {
		this.COMP_RCC_APPLY_PERIOD_LABEL = COMP_RCC_APPLY_PERIOD_LABEL;
	}

	public void setCOMP_RCC_APPLY_PERIOD(HtmlSelectOneMenu COMP_RCC_APPLY_PERIOD) {
		this.COMP_RCC_APPLY_PERIOD = COMP_RCC_APPLY_PERIOD;
	}

	public HtmlOutputLabel getCOMP_RCC_CUST_SHARE_PERC_LABEL() {
		return COMP_RCC_CUST_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_RCC_CUST_SHARE_PERC() {
		return COMP_RCC_CUST_SHARE_PERC;
	}

	public void setCOMP_RCC_CUST_SHARE_PERC_LABEL(HtmlOutputLabel COMP_RCC_CUST_SHARE_PERC_LABEL) {
		this.COMP_RCC_CUST_SHARE_PERC_LABEL = COMP_RCC_CUST_SHARE_PERC_LABEL;
	}

	public void setCOMP_RCC_CUST_SHARE_PERC(HtmlInputText COMP_RCC_CUST_SHARE_PERC) {
		this.COMP_RCC_CUST_SHARE_PERC = COMP_RCC_CUST_SHARE_PERC;
	}

/*	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton COMP_UI_M_BUT_MAIN) {
		this.COMP_UI_M_BUT_MAIN = COMP_UI_M_BUT_MAIN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CHG_TYP_LOV() {
		return COMP_UI_M_BUT_CHG_TYP_LOV;
	}

	public void setCOMP_UI_M_BUT_CHG_TYP_LOV(HtmlCommandButton COMP_UI_M_BUT_CHG_TYP_LOV) {
		this.COMP_UI_M_BUT_CHG_TYP_LOV = COMP_UI_M_BUT_CHG_TYP_LOV;
	}*/

	public PM_IL_RI_CUST_CHRG getPM_IL_RI_CUST_CHRG_BEAN() {
		return PM_IL_RI_CUST_CHRG_BEAN;
	}

	public void setPM_IL_RI_CUST_CHRG_BEAN(PM_IL_RI_CUST_CHRG PM_IL_RI_CUST_CHRG_BEAN) {
		this.PM_IL_RI_CUST_CHRG_BEAN = PM_IL_RI_CUST_CHRG_BEAN;
	}
	
		
	public String addRow(){
		int rowCount = 0;
		if(dataTableList == null){
			dataTableList = new ArrayList();
		}
		
//		PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group = new PM_IL_DOC_TODO_GROUP();
//		PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = new PM_IL_RI_POOL_COVER();
		PM_IL_RI_CUST_CHRG pm_il_ri_cust_chrg = new PM_IL_RI_CUST_CHRG();
		dataTableList.add(pm_il_ri_cust_chrg);
		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
	
	
		return "newadded";
	}
	
/*	public String deleteRow(){
		System.out.println("You are here....");
		PM_IL_RI_CUST_CHRG bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;

		

		
		if(dataTableList!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<dataTableList.size();)
			{
				bean = (PM_IL_RI_CUST_CHRG) dataTableList.get(index);

				if("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())){
					System.out.println("HI inside the check....");
					dataTableList.remove(bean);
					deletedRecordIndex = delegate.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
					
				}else
				{
					index++;
				}
			}
			if(dataTableList.isEmpty()){
				PM_IL_RI_CUST_CHRG_BEAN = new PM_IL_RI_CUST_CHRG();
				setPM_IL_RI_CUST_CHRG_BEAN(PM_IL_RI_CUST_CHRG_BEAN);
				resetAllComponent();
			}
			if(deletedRecordList.size()>0)
			{
				errorMap.put("somekey", deletedRecordList.size()+" records deleted.");
				errorMap.put("current", deletedRecordList.size()+" records deleted.");
			}

		}
		return "";
	}*/
	
	
	public String deleteRow(ActionEvent ae) throws Exception {
		try{
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		/*commented by raja on 19-04-2017*/
		//PM_IL_RI_CUST_CHRG_BEAN = null;
		/*end*/
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataTableList != null) {
			/*Added by raja on 19-04-2017*/
			new CRUDHandler().executeDelete(PM_IL_RI_CUST_CHRG_BEAN,
					CommonUtils.getConnection());
			/*end*/

			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataTableList.size();) {
				PM_IL_RI_CUST_CHRG_BEAN = dataTableList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(PM_IL_RI_CUST_CHRG_BEAN.getRowSelected())) {
					dataTableList.remove(PM_IL_RI_CUST_CHRG_BEAN);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if(dataTableList.size() > 0) {
					setPM_IL_RI_CUST_CHRG_BEAN(dataTableList.get(0));
					PM_IL_RI_CUST_CHRG_BEAN.setRowSelected(true);
			} else {
				addNew(ae);
			}
			if (deletedRecordList.size() > 0) {
				getWarningMap().put("DELETE",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
			}
			lastUpdatedRowIndex = -1;
		}
		resetAllComponent();
		resetSelectedRow();
		PM_IL_RI_CUST_CHRG_BEAN.setRowSelected(true);	
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
		return "";
	}
	
	
	public void addNew(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){		
				PM_IL_RI_CUST_CHRG_BEAN = new PM_IL_RI_CUST_CHRG();
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
	
	public void setErrorMessagesInMap(ActionEvent event){
		CommonUtils.clearMaps(this);
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		CommonUtils.clearMaps(this);
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}

	public List<SelectItem> getApplyChargePeriodList() {
		return applyChargePeriodList;
	}

	public void setApplyChargePeriodList(List<SelectItem> applyChargePeriodList) {
		this.applyChargePeriodList = applyChargePeriodList;
	}

	public List<SelectItem> getChargeTypeList() {
		return chargeTypeList;
	}

	public void setChargeTypeList(List<SelectItem> chargeTypeList) {
		this.chargeTypeList = chargeTypeList;
	}


	/*
	 * Suggestion Box for Charge Code.
	 */
	public List chargeCodeSuggestionAction(Object event) throws DBException {
		
		String chargeCode = (String) event;
		RI_POOL_SETUP_LIST = delegate.prepareChargeCodeList(chargeCode, RI_POOL_SETUP_LIST);
		
		return RI_POOL_SETUP_LIST;
	}
	

	public List getRI_POOL_SETUP_LIST() {
		return RI_POOL_SETUP_LIST;
	}

	public void setRI_POOL_SETUP_LIST(List ri_pool_setup_list) {
		RI_POOL_SETUP_LIST = ri_pool_setup_list;
	}
	
	
	
	public void validateRCC_SRNO(FacesContext fc, UIComponent component,Object value) throws ValidatorException{

		try {
			Double RCC_SRNO_DOUBLE = (Double) value;
			PM_IL_RI_CUST_CHRG_BEAN.setRCC_SRNO(RCC_SRNO_DOUBLE);
			helper.RCC_SRNO_WHEN_VALIDATE_ITEM(RCC_SRNO_DOUBLE, this);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void validateRCC_RATE_PER(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try {
			Double RCC_RATE_PER_DOUBLE = (Double) value;
			PM_IL_RI_CUST_CHRG_BEAN.setRCC_RATE_PER(RCC_RATE_PER_DOUBLE);
			helper.RCC_RATE_PER_WHEN_VALIDATE_ITEM(RCC_RATE_PER_DOUBLE, this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validateRCC_CUST_SHARE_PERC(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try {
			Double RCC_CUST_SHARE_PERC_DOUBLE = (Double) value;
			PM_IL_RI_CUST_CHRG_BEAN.setRCC_CUST_SHARE_PERC(RCC_CUST_SHARE_PERC_DOUBLE);
			helper.RCC_CUST_SHARE_PERC_WHEN_VALIDATE_ITEM(RCC_CUST_SHARE_PERC_DOUBLE, this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
			

	public void validateRCC_CHRG_TYPE(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try {
			String RCC_CHRG_TYPE_STRING = (String) value;
			PM_IL_RI_CUST_CHRG_BEAN.setRCC_CHRG_TYPE(RCC_CHRG_TYPE_STRING);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
		
		

	
	public void validateRCC_CHRG_CODE(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try {
			String RCC_CHRG_CODE_STRING = (String) value;
			RI_POOL_SETUP_LIST = chargeCodeSuggestionAction(RCC_CHRG_CODE_STRING);
			if (RI_POOL_SETUP_LIST == null || RI_POOL_SETUP_LIST.isEmpty()) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
			PM_IL_RI_CUST_CHRG_BEAN.setRCC_CHRG_CODE(RCC_CHRG_CODE_STRING);
			
			
			/*added by raja on 19-04-2017*/
			if(PM_IL_RI_CUST_CHRG_BEAN.getRCC_CHRG_CODE()!=null)
			{
			String query="SELECT PC_CODE FROM PM_CODES WHERE PC_TYPE ='IL_CHARGE' AND PC_RI_APPL_YN='Y' AND PC_CODE=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{PM_IL_RI_CUST_CHRG_BEAN.getRCC_CHRG_CODE()});
			while(rs.next()){
				PM_IL_RI_CUST_CHRG_BEAN.setUI_M_RCC_CHRG_CODE_DESC(rs.getString(1));
			}
			}
			/*end*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
			
		
		
	public void validateRCC_APPLY_PERIOD(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try {
			String RCC_APPLY_PERIOD_STRING = (String) value;
			PM_IL_RI_CUST_CHRG_BEAN.setRCC_APPLY_PERIOD(RCC_APPLY_PERIOD_STRING);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}		
	}
	
	public void validateRCC_RATE(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try {
			Double RCC_RATE_DOUBLE = (Double) value;
			PM_IL_RI_CUST_CHRG_BEAN.setRCC_RATE(RCC_RATE_DOUBLE);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

		
		
	
	public String back(){
		PM_IL_RI_CUST_CHRG_BEAN  = new PM_IL_RI_CUST_CHRG();
		this.setPM_IL_RI_CUST_CHRG_BEAN(PM_IL_RI_CUST_CHRG_BEAN);
		resetAllComponent();
		return "PILM043_PM_IL_RI_POOL_CUST";
	}
	
	public void checkBoxValidation(ActionEvent event){
		CommonUtils.clearMaps(this);
		Boolean value = Boolean.parseBoolean(getCurrentValue(event));
		System.out.println("Boolean Value......  " +value);
		int rowIndex = dataTable.getRowIndex();
		PM_IL_RI_CUST_CHRG pm_il_ri_cust_chrg  = (PM_IL_RI_CUST_CHRG) dataTableList.get(rowIndex);
		pm_il_ri_cust_chrg.setCHECKBOX(value);
	}
	
	public String checkBoxStatus(ActionEvent actionEvent){
		CommonUtils.clearMaps(this);
		Boolean value = Boolean.parseBoolean(getCurrentValue(actionEvent));
		System.out.println("Boolean Value......  " +value);
		int rowIndex = dataTable.getRowIndex();
		PM_IL_RI_CUST_CHRG pm_il_ri_cust_chrg  = (PM_IL_RI_CUST_CHRG) dataTableList.get(rowIndex);
		pm_il_ri_cust_chrg.setCHECKBOX(value);
		
		
		return "";
	}
	/*
	 * Saving of records.
	 */
	
	public String combinedSave(){
		delegate.saveData(this);
		return ""; 
	}
	
	
	// [ Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 13-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;

		try{
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	// [ Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 13-Feb-2009

	/**
	 * @return the filterByRCC_CHRG_CODE
	 */
	public String getFilterByRCC_CHRG_CODE() {
		return filterByRCC_CHRG_CODE;
	}

	/**
	 * @param filterByRCC_CHRG_CODE the filterByRCC_CHRG_CODE to set
	 */
	public void setFilterByRCC_CHRG_CODE(String filterByRCC_CHRG_CODE) {
		this.filterByRCC_CHRG_CODE = filterByRCC_CHRG_CODE;
	}

	/**
	 * @return the filterByRCC_CHRG_TYPE
	 */
	public String getFilterByRCC_CHRG_TYPE() {
		return filterByRCC_CHRG_TYPE;
	}

	/**
	 * @param filterByRCC_CHRG_TYPE the filterByRCC_CHRG_TYPE to set
	 */
	public void setFilterByRCC_CHRG_TYPE(String filterByRCC_CHRG_TYPE) {
		this.filterByRCC_CHRG_TYPE = filterByRCC_CHRG_TYPE;
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
	
	private void resetAllComponent(){
		COMP_RCC_CHRG_TYPE.resetValue();
		COMP_RCC_CHRG_CODE.resetValue();
		COMP_RCC_RATE.resetValue();
		COMP_RCC_RATE_PER.resetValue();
		COMP_RCC_APPLY_PERIOD.resetValue();
		COMP_RCC_CUST_SHARE_PERC.resetValue();
		
	}
	/**
	 * Add New component
	 * @param event
	 */
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_IL_RI_CUST_CHRG_BEAN = new PM_IL_RI_CUST_CHRG();
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
	
	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */
	/*public String deleteRow(ActionEvent ae) {

		try {
	
			if (getErrorMap().containsKey("current")
					|| getWarningMap().containsKey("current")) {
				getErrorMap().remove("current");
				getWarningMap().remove("current");
			}
			if (dataTableList != null) {
				deleteRow();
			}
			resetAllComponent();
		}catch(Exception exception){
		}
		return "";
	}*/
	
	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {				
				PM_IL_RI_CUST_CHRG_BEAN = (PM_IL_RI_CUST_CHRG) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_RI_CUST_CHRG_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_RI_CUST_CHRG> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void save(ActionEvent actionEvent){
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			String insertMessage = Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, insertMessage);
			getWarningMap().put("current", insertMessage);
			getWarningMap().put("detail", insertMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "";
	}

	public void post(ActionEvent ae) {
		try{
			setBeanValues();
			
			if(PM_IL_RI_CUST_CHRG_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					PM_IL_RI_CUST_CHRG_BEAN.setRCC_CR_DT(new Date(Calendar.getInstance()
							.getTimeInMillis()));
					PM_IL_RI_CUST_CHRG_BEAN.setRCC_CR_UID(CommonUtils.getControlBean()
							.getM_USER_ID());
					new CRUDHandler().executeInsert(PM_IL_RI_CUST_CHRG_BEAN, new CommonUtils().getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$updatenotallowed"));
					getWarningMap().put("post" ,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$updatenotallowed" ));
				}
	
			} else {

				if(isINSERT_ALLOWED()) {
					new CRUDHandler().executeInsert(PM_IL_RI_CUST_CHRG_BEAN, new CommonUtils().getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"));
					dataTableList.add(PM_IL_RI_CUST_CHRG_BEAN);
					if(dataTableList.size()>0){
						for(int i=0;i<dataTableList.size();i++){
							PM_IL_RI_CUST_CHRG pm_il_ri_pool_cover = dataTableList.get(i);
							if(i==0){
								pm_il_ri_pool_cover.setRowSelected(true);
								setPM_IL_RI_CUST_CHRG_BEAN(pm_il_ri_pool_cover);
							}else{
								pm_il_ri_pool_cover.setRowSelected(false);
							}
						}
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
	 * 
	 */
	private void setBeanValues() {
		String customerCode = null;
		String coverCode = null;
		
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String poolCode = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_SETUP_ACTION().getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
		
		PM_IL_RI_CUST_CHRG_BEAN.setRCC_RPS_CODE(poolCode);
		int custRowCount = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_CUST_ACTION().getDataTable().getRowCount();
		for(int index = 0;index<custRowCount; index++)
		{
			PM_IL_RI_POOL_CUST  pm_il_ri_pool_cust = (PM_IL_RI_POOL_CUST) pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_CUST_ACTION().getDataTableList().get(index);
			//if(pm_il_ri_pool_cust.isCHECKBOX())
			if("dataTableSelectedRow".equalsIgnoreCase(pm_il_ri_pool_cust.getRowSelected())){
				customerCode = pm_il_ri_pool_cust.getRPCUST_CODE();
			}
		}
		
		int chrgRowCount = pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_COVER_ACTION().getDataTable().getRowCount();
		for(int index = 0;index<chrgRowCount; index++)
		{
			PM_IL_RI_POOL_COVER  pm_il_ri_pool_cover = (PM_IL_RI_POOL_COVER) pm_il_ri_pool_setup_composite_action.getPM_IL_RI_POOL_COVER_ACTION().getDataTableList().get(index);
			//if(pm_il_ri_pool_cover.isCHECKBOX())
			if("dataTableSelectedRow".equalsIgnoreCase(pm_il_ri_pool_cover.getRowSelected()))
			{
				coverCode = pm_il_ri_pool_cover.getRPCVR_CODE();
			}
		}
		PM_IL_RI_CUST_CHRG_BEAN.setRCC_RPCVR_CODE(coverCode);
		PM_IL_RI_CUST_CHRG_BEAN.setRCC_RPCUST_CODE(customerCode);
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}
}
