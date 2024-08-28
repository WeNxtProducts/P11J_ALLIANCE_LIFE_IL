package com.iii.pel.forms.PM_FLEX;

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
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM034.PILM034_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_FLEX_CONFIG_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_IFD_PROG_CODE_LABEL;
	private HtmlInputText COMP_IFD_PROG_CODE;
	
	private HtmlOutputLabel COMP_IFD_BLOCK_CODE_LABEL;
	private HtmlInputText COMP_IFD_BLOCK_CODE;
	
	private HtmlOutputLabel COMP_PFD_FLD_NAME_LABEL;
	private HtmlInputText COMP_PFD_FLD_NAME;
	
	private HtmlOutputLabel COMP_PFD_DATA_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_PFD_DATA_TYPE;
		
	private HtmlOutputLabel COMP_IFD_PROMPT_LABEL;
	private HtmlInputText COMP_IFD_PROMPT;
	
	private HtmlOutputLabel COMP_PFD_ENTERABLE_YN_NUM_LABEL;
	private HtmlSelectBooleanCheckbox COMP_PFD_ENTERABLE_YN_NUM;
	
	private HtmlOutputLabel COMP_PFD_UPDATEABLE_YN_NUM_LABEL;
	private HtmlSelectBooleanCheckbox COMP_PFD_UPDATEABLE_YN_NUM;
	
	private HtmlOutputLabel COMP_PFD_MANDATORY_YN_NUM_LABEL;
	private HtmlSelectBooleanCheckbox COMP_PFD_MANDATORY_YN_NUM;
	
	private HtmlOutputLabel COMP_PFD_HIDE_YN_NUM_LABEL;
	private HtmlSelectBooleanCheckbox COMP_PFD_HIDE_YN_NUM;
	
	private HtmlOutputLabel COMP_PFD_DFLT_VALUE_LABEL;
	private HtmlInputText COMP_PFD_DFLT_VALUE;
	
	private ArrayList<PM_FLEX_CONFIG> dataList_PM_FLEX_CONFIG = new ArrayList<PM_FLEX_CONFIG>();
	private UIData dataTable;
	
	private String progCode = null;
	private String blockCode = null;
	
	private List<SelectItem> listDataType = new ArrayList<SelectItem>();
	
	private PM_FLEX_CONFIG PM_FLEX_CONFIG_BEAN;
	
	private PM_FLEX_CONFIG_HELPER helper;

	
	public PM_FLEX_CONFIG_ACTION() {
		PM_FLEX_CONFIG_BEAN = new PM_FLEX_CONFIG();
		helper = new PM_FLEX_CONFIG_HELPER();
		List<SelectItem> itemList = new ArrayList<SelectItem>();
		itemList.add(new SelectItem("C","String"));
		itemList.add(new SelectItem("N","Number"));
		itemList.add(new SelectItem("L","List Item"));
		itemList.add(new SelectItem("D","Date"));
		setListDataType(itemList);
	}
	
	
	public List<SelectItem> getListDataType() {
		return listDataType;
	}


	public void setListDataType(List<SelectItem> listDataType) {
		this.listDataType = listDataType;
	}


	public List<LovBean> lovProgCode(Object value){
		String code = (String) value;
		List<LovBean> suggestionList = null;
		Object[] object={};
		String query=null;
		if("*".equals(code)){
			object=new Object[]{PELConstants.suggetionRecordSize};
			query=" SELECT PROG_CODE FROM  IM_PROGRAM WHERE ROWNUM < ? "; 
		}else{
			object=new Object[]{code+"%",PELConstants.suggetionRecordSize};
			query="SELECT PROG_CODE FROM  IM_PROGRAM WHERE PROG_CODE LIKE  ? AND ROWNUM < ?";
		}
		suggestionList = prepareLovListCode(query, object);
		return suggestionList;
	}
	
	
	public List<LovBean> lovBlockCode(Object value){
		String code = (String) value;
		List<LovBean> suggestionList = null;
		Object[] object={};
		String query=null;
		if("*".equals(code)){
			object=new Object[]{PM_FLEX_CONFIG_BEAN.getIFD_PROG_CODE(),PELConstants.suggetionRecordSize};
			query="SELECT PB_BLK_NAME FROM  IM_PROG_BLOCK WHERE PB_PROG_CODE= ? AND ROWNUM < ?"; 
		}else{
			object=new Object[]{code+"%", PM_FLEX_CONFIG_BEAN.getUI_IFD_PROG_CODE(),
					PELConstants.suggetionRecordSize};
			query="SELECT PB_BLK_NAME FROM  IM_PROG_BLOCK WHERE PB_BLK_NAME LIKE ? AND " +
					" PB_PROG_CODE=?   AND ROWNUM < ?";
		}
		suggestionList = prepareLovListCode(query, object);
		return suggestionList;
	}
	
	public List<LovBean> prepareLovListCode(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}

	public void validate_IFD_PBF_FLD_NAME(FacesContext context,UIComponent component,Object value){
		try{
			PM_FLEX_CONFIG_BEAN.setIFD_PBF_FLD_NAME((String)value);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validate_IFD_PROG_CODE(FacesContext context,UIComponent component ,Object value){
		try{
			PM_FLEX_CONFIG_BEAN.setUI_IFD_PROG_CODE((String)value);
			progCode = (String)value;
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void validate_IFD_BLOCK_CODE(FacesContext context,UIComponent component,Object value){
		try{
			PM_FLEX_CONFIG_BEAN.setUI_IFD_PB_BLK_NAME((String)value);
			blockCode = (String)value;
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void Validate_PFD_DATA_TYPE(FacesContext context,UIComponent component,Object value){
		try{
			PM_FLEX_CONFIG_BEAN.setIFD_DATA_TYPE((String)value);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validate_IFD_PROMPT(FacesContext context,UIComponent component ,Object value){
		try{
			PM_FLEX_CONFIG_BEAN.setIFD_PROMPT((String)value);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void Validate_PFD_DFLT_VALUE(FacesContext context,UIComponent component ,Object value){
		try{
			PM_FLEX_CONFIG_BEAN.setIFD_DFLT_VALUE((String)value);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validate_UI_PFD_ENTERABLE_YN_NUM(FacesContext context ,UIComponent component, Object value){
		try{
			Boolean value_1 = (Boolean)value;
			PM_FLEX_CONFIG_BEAN.setUI_PFD_ENTERABLE_YN_NUM(value_1);
			if("true".equalsIgnoreCase(value_1.toString())){
				PM_FLEX_CONFIG_BEAN.setPFD_ENTERABLE_YN_NUM(1);
			}else{
				PM_FLEX_CONFIG_BEAN.setPFD_ENTERABLE_YN_NUM(2);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validate_PFD_UPDATEABLE_YN_NUM(FacesContext context,UIComponent component, Object value){
		try{
			Boolean value_1 = (Boolean)value;
			PM_FLEX_CONFIG_BEAN.setUI_PFD_UPDATEABLE_YN_NUM(value_1);
			if("true".equalsIgnoreCase(value_1.toString())){
				PM_FLEX_CONFIG_BEAN.setPFD_UPDATEABLE_YN_NUM(1);
			}else{
				PM_FLEX_CONFIG_BEAN.setPFD_UPDATEABLE_YN_NUM(2);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validate_PFD_MANDATORY_YN_NUM(FacesContext context ,UIComponent component ,Object value){
		try{
			Boolean value_1 = (Boolean)value;
			PM_FLEX_CONFIG_BEAN.setUI_IFD_MANDATORY_YN_NUM(value_1);
			if("true".equalsIgnoreCase(value_1.toString())){
				PM_FLEX_CONFIG_BEAN.setIFD_MANDATORY_YN_NUM(1);
			}else{
				PM_FLEX_CONFIG_BEAN.setIFD_MANDATORY_YN_NUM(2);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validate_PFD_HIDE_YN_NUM(FacesContext context,UIComponent component,Object value){
		try{
			Boolean value_1 = (Boolean)value;
			PM_FLEX_CONFIG_BEAN.setUI_IFD_HIDE_YN_NUM(value_1);
			if("true".equalsIgnoreCase(value_1.toString())){
				PM_FLEX_CONFIG_BEAN.setIFD_HIDE_YN_NUM(1);
			}else{
				PM_FLEX_CONFIG_BEAN.setIFD_HIDE_YN_NUM(2);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void fetchDetails(ActionEvent event){
		try{
			helper.fetchDeatilsCloumn(this);
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_FLEX_CONFIG_BEAN = (PM_FLEX_CONFIG) dataTable.getRowData();
			PM_FLEX_CONFIG_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	
	private void resetAllComponent(){
		COMP_PFD_FLD_NAME.resetValue();
		COMP_PFD_DATA_TYPE.resetValue();
		COMP_IFD_PROMPT.resetValue();
		COMP_PFD_ENTERABLE_YN_NUM.resetValue();
		COMP_PFD_UPDATEABLE_YN_NUM.resetValue();
		COMP_PFD_MANDATORY_YN_NUM.resetValue();
		COMP_PFD_DFLT_VALUE.resetValue();
		COMP_PFD_HIDE_YN_NUM.resetValue();
	}
	
	
	private void resetSelectedRow() {
		Iterator<PM_FLEX_CONFIG> PM_FLEX_CONFIG_ITR = dataList_PM_FLEX_CONFIG.iterator();
		while (PM_FLEX_CONFIG_ITR.hasNext()) {
			PM_FLEX_CONFIG_ITR.next().setRowSelected(false);
		}
	}

	
	public void saveRecord() {
		try {
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			getWarningMap().put("saveRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	// Newly added for delete button
	
	public String deleteRow(){
		try{
						if (isDELETE_ALLOWED()){
				
				new CRUDHandler().executeDelete(PM_FLEX_CONFIG_BEAN,CommonUtils.getConnection());
				dataList_PM_FLEX_CONFIG.remove(PM_FLEX_CONFIG_BEAN);
				
				if(dataList_PM_FLEX_CONFIG.size()>0){
					PM_FLEX_CONFIG_BEAN=dataList_PM_FLEX_CONFIG.get(0);
				}else if(dataList_PM_FLEX_CONFIG.size()== 0){
					PM_FLEX_CONFIG_BEAN = new PM_FLEX_CONFIG();
				}
				
				resetAllComponent();
				// Assigning message to new action class
				getWarningMap().put(
						"deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
			}else{
				getErrorMap().put("deleteRow",Messages.getString(PELConstants.
						pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
			}
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}
		return "";
	}


	
	public void postRecord(ActionEvent event) {
		try {
			if (PM_FLEX_CONFIG_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PM_FLEX_CONFIG_BEAN);
				new CRUDHandler().executeUpdate(PM_FLEX_CONFIG_BEAN,
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
			} else if (PM_FLEX_CONFIG_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PM_FLEX_CONFIG_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert"));
				dataList_PM_FLEX_CONFIG.add(PM_FLEX_CONFIG_BEAN);
			} 

			PM_FLEX_CONFIG_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("postRecord",exc.getMessage());
		}

	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {

				PM_FLEX_CONFIG_BEAN = new PM_FLEX_CONFIG();
				PM_FLEX_CONFIG_BEAN.setIFD_PROG_CODE(progCode);
				PM_FLEX_CONFIG_BEAN.setIFD_PB_BLK_NAME(blockCode);
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

	
	
	
	public HtmlOutputLabel getCOMP_IFD_PROG_CODE_LABEL() {
		return COMP_IFD_PROG_CODE_LABEL;
	}


	public void setCOMP_IFD_PROG_CODE_LABEL(HtmlOutputLabel comp_ifd_prog_code_label) {
		COMP_IFD_PROG_CODE_LABEL = comp_ifd_prog_code_label;
	}


	public HtmlInputText getCOMP_IFD_PROG_CODE() {
		return COMP_IFD_PROG_CODE;
	}


	public void setCOMP_IFD_PROG_CODE(HtmlInputText comp_ifd_prog_code) {
		COMP_IFD_PROG_CODE = comp_ifd_prog_code;
	}


	public HtmlOutputLabel getCOMP_IFD_BLOCK_CODE_LABEL() {
		return COMP_IFD_BLOCK_CODE_LABEL;
	}


	public void setCOMP_IFD_BLOCK_CODE_LABEL(
			HtmlOutputLabel comp_ifd_block_code_label) {
		COMP_IFD_BLOCK_CODE_LABEL = comp_ifd_block_code_label;
	}


	public HtmlInputText getCOMP_IFD_BLOCK_CODE() {
		return COMP_IFD_BLOCK_CODE;
	}


	public void setCOMP_IFD_BLOCK_CODE(HtmlInputText comp_ifd_block_code) {
		COMP_IFD_BLOCK_CODE = comp_ifd_block_code;
	}


	public PM_FLEX_CONFIG getPM_FLEX_CONFIG_BEAN() {
		return PM_FLEX_CONFIG_BEAN;
	}


	public void setPM_FLEX_CONFIG_BEAN(PM_FLEX_CONFIG pm_flex_config_bean) {
		PM_FLEX_CONFIG_BEAN = pm_flex_config_bean;
	}


	public PM_FLEX_CONFIG_HELPER getHelper() {
		return helper;
	}


	public void setHelper(PM_FLEX_CONFIG_HELPER helper) {
		this.helper = helper;
	}


	public ArrayList<PM_FLEX_CONFIG> getDataList_PM_FLEX_CONFIG() {
		return dataList_PM_FLEX_CONFIG;
	}


	public void setDataList_PM_FLEX_CONFIG(
			ArrayList<PM_FLEX_CONFIG> dataList_PM_FLEX_CONFIG) {
		this.dataList_PM_FLEX_CONFIG = dataList_PM_FLEX_CONFIG;
	}


	public UIData getDataTable() {
		return dataTable;
	}


	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}


	public HtmlOutputLabel getCOMP_PFD_DATA_TYPE_LABEL() {
		return COMP_PFD_DATA_TYPE_LABEL;
	}


	public void setCOMP_PFD_DATA_TYPE_LABEL(HtmlOutputLabel comp_pfd_data_type_label) {
		COMP_PFD_DATA_TYPE_LABEL = comp_pfd_data_type_label;
	}


	


	public HtmlSelectOneMenu getCOMP_PFD_DATA_TYPE() {
		return COMP_PFD_DATA_TYPE;
	}


	public void setCOMP_PFD_DATA_TYPE(HtmlSelectOneMenu comp_pfd_data_type) {
		COMP_PFD_DATA_TYPE = comp_pfd_data_type;
	}


	public HtmlOutputLabel getCOMP_IFD_PROMPT_LABEL() {
		return COMP_IFD_PROMPT_LABEL;
	}


	public void setCOMP_IFD_PROMPT_LABEL(HtmlOutputLabel comp_ifd_prompt_label) {
		COMP_IFD_PROMPT_LABEL = comp_ifd_prompt_label;
	}


	public HtmlInputText getCOMP_IFD_PROMPT() {
		return COMP_IFD_PROMPT;
	}


	public void setCOMP_IFD_PROMPT(HtmlInputText comp_ifd_prompt) {
		COMP_IFD_PROMPT = comp_ifd_prompt;
	}


	public HtmlOutputLabel getCOMP_PFD_ENTERABLE_YN_NUM_LABEL() {
		return COMP_PFD_ENTERABLE_YN_NUM_LABEL;
	}


	public void setCOMP_PFD_ENTERABLE_YN_NUM_LABEL(
			HtmlOutputLabel comp_pfd_enterable_yn_num_label) {
		COMP_PFD_ENTERABLE_YN_NUM_LABEL = comp_pfd_enterable_yn_num_label;
	}


	public HtmlSelectBooleanCheckbox getCOMP_PFD_ENTERABLE_YN_NUM() {
		return COMP_PFD_ENTERABLE_YN_NUM;
	}


	public void setCOMP_PFD_ENTERABLE_YN_NUM(
			HtmlSelectBooleanCheckbox comp_pfd_enterable_yn_num) {
		COMP_PFD_ENTERABLE_YN_NUM = comp_pfd_enterable_yn_num;
	}


	public HtmlOutputLabel getCOMP_PFD_UPDATEABLE_YN_NUM_LABEL() {
		return COMP_PFD_UPDATEABLE_YN_NUM_LABEL;
	}


	public void setCOMP_PFD_UPDATEABLE_YN_NUM_LABEL(
			HtmlOutputLabel comp_pfd_updateable_yn_num_label) {
		COMP_PFD_UPDATEABLE_YN_NUM_LABEL = comp_pfd_updateable_yn_num_label;
	}


	public HtmlSelectBooleanCheckbox getCOMP_PFD_UPDATEABLE_YN_NUM() {
		return COMP_PFD_UPDATEABLE_YN_NUM;
	}


	public void setCOMP_PFD_UPDATEABLE_YN_NUM(
			HtmlSelectBooleanCheckbox comp_pfd_updateable_yn_num) {
		COMP_PFD_UPDATEABLE_YN_NUM = comp_pfd_updateable_yn_num;
	}


	public HtmlOutputLabel getCOMP_PFD_MANDATORY_YN_NUM_LABEL() {
		return COMP_PFD_MANDATORY_YN_NUM_LABEL;
	}


	public void setCOMP_PFD_MANDATORY_YN_NUM_LABEL(
			HtmlOutputLabel comp_pfd_mandatory_yn_num_label) {
		COMP_PFD_MANDATORY_YN_NUM_LABEL = comp_pfd_mandatory_yn_num_label;
	}


	public HtmlSelectBooleanCheckbox getCOMP_PFD_MANDATORY_YN_NUM() {
		return COMP_PFD_MANDATORY_YN_NUM;
	}


	public void setCOMP_PFD_MANDATORY_YN_NUM(
			HtmlSelectBooleanCheckbox comp_pfd_mandatory_yn_num) {
		COMP_PFD_MANDATORY_YN_NUM = comp_pfd_mandatory_yn_num;
	}


	public HtmlOutputLabel getCOMP_PFD_DFLT_VALUE_LABEL() {
		return COMP_PFD_DFLT_VALUE_LABEL;
	}


	public void setCOMP_PFD_DFLT_VALUE_LABEL(
			HtmlOutputLabel comp_pfd_dflt_value_label) {
		COMP_PFD_DFLT_VALUE_LABEL = comp_pfd_dflt_value_label;
	}


	public HtmlInputText getCOMP_PFD_DFLT_VALUE() {
		return COMP_PFD_DFLT_VALUE;
	}


	public void setCOMP_PFD_DFLT_VALUE(HtmlInputText comp_pfd_dflt_value) {
		COMP_PFD_DFLT_VALUE = comp_pfd_dflt_value;
	}


	public HtmlOutputLabel getCOMP_PFD_FLD_NAME_LABEL() {
		return COMP_PFD_FLD_NAME_LABEL;
	}


	public void setCOMP_PFD_FLD_NAME_LABEL(HtmlOutputLabel comp_pfd_fld_name_label) {
		COMP_PFD_FLD_NAME_LABEL = comp_pfd_fld_name_label;
	}


	public HtmlInputText getCOMP_PFD_FLD_NAME() {
		return COMP_PFD_FLD_NAME;
	}


	public void setCOMP_PFD_FLD_NAME(HtmlInputText comp_pfd_fld_name) {
		COMP_PFD_FLD_NAME = comp_pfd_fld_name;
	}


	public HtmlOutputLabel getCOMP_PFD_HIDE_YN_NUM_LABEL() {
		return COMP_PFD_HIDE_YN_NUM_LABEL;
	}


	public void setCOMP_PFD_HIDE_YN_NUM_LABEL(
			HtmlOutputLabel comp_pfd_hide_yn_num_label) {
		COMP_PFD_HIDE_YN_NUM_LABEL = comp_pfd_hide_yn_num_label;
	}


	public HtmlSelectBooleanCheckbox getCOMP_PFD_HIDE_YN_NUM() {
		return COMP_PFD_HIDE_YN_NUM;
	}


	public void setCOMP_PFD_HIDE_YN_NUM(
			HtmlSelectBooleanCheckbox comp_pfd_hide_yn_num) {
		COMP_PFD_HIDE_YN_NUM = comp_pfd_hide_yn_num;
	}
	
	
}
