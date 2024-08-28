package com.iii.pel.forms.PILP_STS_PRO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_CAN_PERC_ACTION  extends CommonAction{

	private HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL;
	
	private HtmlInputText COMP_UI_M_POL_NO_FM;
	
	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;
	
	private HtmlInputText COMP_UI_M_POL_NO_TO;
	
	private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;
	
	private HtmlCalendar COMP_UI_M_PROCESS_DT;
	
	private HtmlOutputLabel COMP_CP_POL_NO_LABEL;
	
	private HtmlInputText COMP_CP_POL_NO;
	
	private HtmlOutputLabel COMP_CP_STATUS_DT_LABEL;
	
	private HtmlCalendar COMP_CP_STATUS_DT;
	
	private HtmlOutputLabel COMP_CP_NO_OF_DAYS_LABEL;
	
	private HtmlInputText COMP_CP_NO_OF_DAYS;
	
	private HtmlOutputLabel COMP_UI_PERC_YES_LABEL;
	
	private HtmlSelectOneMenu COMP_UI_PERC_YES;
	
	private List<PT_CAN_PERC> dataList_PT_CAN_PERC = new ArrayList<PT_CAN_PERC>();

	 private UIData dataTable;
	
	private HtmlOutputLabel COMP_UI_YES_ALL_LABEL;
	
	private HtmlSelectBooleanCheckbox COMP_UI_YES_ALL;
	
	private List<SelectItem> listCP_FLEX_03 = new ArrayList<SelectItem>();

	private int lastUpdatedRowIndex;
	
	private Boolean isSelectOrRetain = false ;
	
	private PT_CAN_PERC PT_CAN_PERC_BEAN;

	private PT_CAN_PERC_HELPER helper;
	
	public PT_CAN_PERC_ACTION() {
		PT_CAN_PERC_BEAN = new PT_CAN_PERC();
		helper = new PT_CAN_PERC_HELPER();
		prepareDropDownList();
	}
	
	
	public void prepareDropDownList() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			listCP_FLEX_03 = ListItemUtil
					.getDropDownListValue(connection, "PILP_STS_PRO",
							"PT_CAN_PRC",
							"PT_CAN_PRC.SELECT_YN",
							"YESNO");
			
			
		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DropDownList", e.getMessage());
		}
	}
	
	

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FM_LABEL() {
		return COMP_UI_M_POL_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_FM_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_fm_label) {
		COMP_UI_M_POL_NO_FM_LABEL = comp_ui_m_pol_no_fm_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_FM() {
		return COMP_UI_M_POL_NO_FM;
	}

	public void setCOMP_UI_M_POL_NO_FM(HtmlInputText comp_ui_m_pol_no_fm) {
		COMP_UI_M_POL_NO_FM = comp_ui_m_pol_no_fm;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_TO_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_to_label) {
		COMP_UI_M_POL_NO_TO_LABEL = comp_ui_m_pol_no_to_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}

	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText comp_ui_m_pol_no_to) {
		COMP_UI_M_POL_NO_TO = comp_ui_m_pol_no_to;
	}

	public HtmlOutputLabel getCOMP_CP_POL_NO_LABEL() {
		return COMP_CP_POL_NO_LABEL;
	}

	public void setCOMP_CP_POL_NO_LABEL(HtmlOutputLabel comp_cp_pol_no_label) {
		COMP_CP_POL_NO_LABEL = comp_cp_pol_no_label;
	}

	public HtmlInputText getCOMP_CP_POL_NO() {
		return COMP_CP_POL_NO;
	}

	public void setCOMP_CP_POL_NO(HtmlInputText comp_cp_pol_no) {
		COMP_CP_POL_NO = comp_cp_pol_no;
	}

	public HtmlOutputLabel getCOMP_CP_STATUS_DT_LABEL() {
		return COMP_CP_STATUS_DT_LABEL;
	}

	public void setCOMP_CP_STATUS_DT_LABEL(HtmlOutputLabel comp_cp_status_dt_label) {
		COMP_CP_STATUS_DT_LABEL = comp_cp_status_dt_label;
	}

	

	public HtmlCalendar getCOMP_CP_STATUS_DT() {
		return COMP_CP_STATUS_DT;
	}

	public HtmlOutputLabel getCOMP_CP_NO_OF_DAYS_LABEL() {
		return COMP_CP_NO_OF_DAYS_LABEL;
	}

	public void setCOMP_CP_NO_OF_DAYS_LABEL(HtmlOutputLabel comp_cp_no_of_days_label) {
		COMP_CP_NO_OF_DAYS_LABEL = comp_cp_no_of_days_label;
	}

	public HtmlInputText getCOMP_CP_NO_OF_DAYS() {
		return COMP_CP_NO_OF_DAYS;
	}

	public void setCOMP_CP_NO_OF_DAYS(HtmlInputText comp_cp_no_of_days) {
		COMP_CP_NO_OF_DAYS = comp_cp_no_of_days;
	}

	public HtmlOutputLabel getCOMP_UI_PERC_YES_LABEL() {
		return COMP_UI_PERC_YES_LABEL;
	}

	public void setCOMP_UI_PERC_YES_LABEL(HtmlOutputLabel comp_ui_perc_yes_label) {
		COMP_UI_PERC_YES_LABEL = comp_ui_perc_yes_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_PERC_YES() {
		return COMP_UI_PERC_YES;
	}

	public void setCOMP_UI_PERC_YES(HtmlSelectOneMenu comp_ui_perc_yes) {
		COMP_UI_PERC_YES = comp_ui_perc_yes;
	}

	public PT_CAN_PERC getPT_CAN_PERC_BEAN() {
		return PT_CAN_PERC_BEAN;
	}

	public void setPT_CAN_PERC_BEAN(PT_CAN_PERC pt_can_perc_bean) {
		PT_CAN_PERC_BEAN = pt_can_perc_bean;
	}

	public PT_CAN_PERC_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_CAN_PERC_HELPER helper) {
		this.helper = helper;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DT_LABEL(
			HtmlOutputLabel comp_ui_m_process_dt_label) {
		COMP_UI_M_PROCESS_DT_LABEL = comp_ui_m_process_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}

	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar comp_ui_m_process_dt) {
		COMP_UI_M_PROCESS_DT = comp_ui_m_process_dt;
	}

	public void setCOMP_CP_STATUS_DT(HtmlCalendar comp_cp_status_dt) {
		COMP_CP_STATUS_DT = comp_cp_status_dt;
	}

	public HtmlOutputLabel getCOMP_UI_YES_ALL_LABEL() {
		return COMP_UI_YES_ALL_LABEL;
	}

	public void setCOMP_UI_YES_ALL_LABEL(HtmlOutputLabel comp_ui_yes_all_label) {
		COMP_UI_YES_ALL_LABEL = comp_ui_yes_all_label;
	}

	

	

	public void setCOMP_UI_YES_ALL(HtmlSelectBooleanCheckbox comp_ui_yes_all) {
		COMP_UI_YES_ALL = comp_ui_yes_all;
	}
	
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void fireFiledUI_M_POL_NO_FM(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		String custValue  = (String) input.getSubmittedValue();
		if("".equals(custValue.trim()) || custValue.trim().isEmpty()){
			COMP_UI_M_POL_NO_FM.setSubmittedValue("0");
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void fireFiledUI_M_POL_NO_TO(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		String custValue = (String) input.getSubmittedValue();
		if(getCOMP_UI_M_POL_NO_FM().getSubmittedValue().equals("0")){
			getCOMP_UI_M_POL_NO_TO().setSubmittedValue("ZZZZZZZZZZZZ");
		}else{
			getCOMP_UI_M_POL_NO_TO().setSubmittedValue(getCOMP_UI_M_POL_NO_FM().getSubmittedValue());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void onBlurSelectYN(ActionEvent event) {
		PT_CAN_PERC percBean = (PT_CAN_PERC) dataTable.getRowData();
		String selectYN = (String) ((UIInput)event.getComponent().getParent()).getSubmittedValue();
		percBean.setCP_FLEX_03(selectYN);
		lastColumnListener(percBean);
	}
	
	

	public void lastColumnListener(PT_CAN_PERC PT_CAN_PERC_BEAN){
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		try {
			  if(PT_CAN_PERC_BEAN.getROWID()!=null){
				rowUpdated = new CRUDHandler().executeUpdate(PT_CAN_PERC_BEAN, CommonUtils.getConnection());
				if(rowUpdated>0){
				  getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						  	"Record Updated Successfully.Please Save it.");
				  getWarningMap().put("CURRENT",
				  						"Record Updated Successfully.Please Save it.");
				}
			  } else {
				  rowUpdated = new CRUDHandler().executeInsert(PT_CAN_PERC_BEAN, CommonUtils.getConnection());
						if(rowUpdated>0){
							getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						  				"Record Inserted Successfully.Please Save it.");
							getWarningMap().put("CURRENT",
				  						"Record Inserted Successfully.Please Save it.");
						}
				}
			  lastUpdatedRowIndex = currRowIndex;	
		} catch (Exception e1) {
			e1.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e1.getMessage());
			getErrorMap().put("CURRENT", e1.getMessage());
		}
	}
	
	public void fireField_SEL(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		checkValueSEL(value);
		isSelectOrRetain = true ;
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	private void checkValueSEL(String chkValue){
		String strValue = null;
		if(chkValue.equals(null)){
			strValue = "N";
		}else if(chkValue.equalsIgnoreCase("false")){
			strValue = "N";
		}else{
			strValue = "Y";
		}
		Iterator<PT_CAN_PERC> PT_CAN_PERC_ITR = dataList_PT_CAN_PERC.iterator();
		while(PT_CAN_PERC_ITR.hasNext()){
			setPT_CAN_PERC_BEAN(PT_CAN_PERC_ITR.next());
			PT_CAN_PERC_BEAN.setCP_FLEX_03(strValue);
		}
	}
	
	
	public void saveRecord() {
		try {
			if(isSelectOrRetain == true ){
				Iterator<PT_CAN_PERC> itr = dataList_PT_CAN_PERC.iterator();
				while(itr.hasNext()){
					setPT_CAN_PERC_BEAN(itr.next());
					new CRUDHandler().executeUpdate(PT_CAN_PERC_BEAN, CommonUtils.getConnection());
				}
				isSelectOrRetain = false; 
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Save Successfully");
			getWarningMap().put("CURRENT", "Records Save Successfully");
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<PT_CAN_PERC> getDataList_PT_CAN_PERC() {
		return dataList_PT_CAN_PERC;
	}

	public void setDataList_PT_CAN_PERC(List<PT_CAN_PERC> dataList_PT_CAN_PERC) {
		this.dataList_PT_CAN_PERC = dataList_PT_CAN_PERC;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlSelectBooleanCheckbox getCOMP_UI_YES_ALL() {
		return COMP_UI_YES_ALL;
	}
	
	public void validateCheckPolNo(String polNo) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		String query = "SELECT POL_NO FROM PT_IL_POLICY WHERE POL_NO = ? ";
		CRUDHandler handler = new CRUDHandler();
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, new Object[]{polNo});
			if(resultSet.next()){
			}else{
				throw new Exception("Policy number does Exist");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	
	public List<SelectItem> getListCP_FLEX_03() {
		return listCP_FLEX_03;
	}


	public void setListCP_FLEX_03(List<SelectItem> listCP_FLEX_03) {
		this.listCP_FLEX_03 = listCP_FLEX_03;
	}


	public String fetchButton(){
		ArrayList<OracleParameter> list = null; 
		String outcome = null;
		
		try {
			list = new P9ILPK_POLICY_CANCELLATION().P_INS_PT_CAN_PRC_IL(
					PT_CAN_PERC_BEAN.getUI_M_POL_NO_FM(), PT_CAN_PERC_BEAN.getUI_M_POL_NO_TO() , PT_CAN_PERC_BEAN.getUI_M_PROCESS_DT());
			helper.executeQuery(this);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return "";
		 
	}
	
	
	public String processButton(){
		ArrayList<OracleParameter> list = null;
		Double rstl = 0.0;
		try {
			list =  new P9ILPK_POLICY_CANCELLATION().P_POL_CAN_PROCESS_IL(rstl);
			if(list.size()>0 ){
				rstl = (Double)list.get(0).getValueObject();
				if(rstl > 0.0){
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process Completed Successfully");
					getWarningMap().put("CURRENT", "Process Completed Successfully");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return "";
	}
	
	
	public ArrayList<LovBean> lovUI_M_POL_NO_FM(Object object) {
    	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
    	String query = " SELECT POL_NO FROM PT_IL_POLICY WHERE  POL_NO LIKE ? AND  ROWNUM < ? ";
		Object[] values = null;
		String currentValue = (String) object;
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			values = new Object[] { currentValue, PELConstants.suggetionRecordSize };
			lovList = prepareSuggestionListForSingleValue(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
    }
	
	
	public static ArrayList<LovBean> prepareSuggestionListForSingleValue(final String query, 
			final Object[] values) throws Exception{
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		LovBean lovBean = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		int columnCount = -1;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, values);
			columnCount = resultSet.getMetaData().getColumnCount();
			while(resultSet.next()){
				lovBean = new LovBean();
				lovBean.setCode(resultSet.getString(1));
				//lovBean.setName(resultSet.getString(2));
				if(columnCount > 2){
					lovBean.setName1(resultSet.getString(3));
				}
				suggestionList.add(lovBean);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
		
		return suggestionList;
	}
	
}
