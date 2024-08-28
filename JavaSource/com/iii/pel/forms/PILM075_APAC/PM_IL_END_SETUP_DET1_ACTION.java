package com.iii.pel.forms.PILM075_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_END_SETUP_DET1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ESD_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_ESD_CODE_DESC_LABEL;
	private HtmlOutputLabel COMP_ESD_CHAR_VALUE_LABEL;
	private HtmlInputText COMP_ESD_CODE;
	private HtmlInputText COMP_UI_M_ESD_CODE_DESC;
	private PM_IL_END_SETUP_DET1 PM_IL_END_SETUP_DET1_BEAN;
	private HtmlSelectOneMenu COMP_ESD_CHAR_VALUE;
	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private List<PM_IL_END_SETUP_DET1> dataList_PM_IL_END_SETUP_DET1 = new ArrayList<PM_IL_END_SETUP_DET1>();

	private int recordPerPage = 10;
	private UIDataTable dataTable;
	private int currentPage;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;
	
	private String filterByESD_CODE;
	private String filterByUI_M_ESD_CODE_DESC;
	PM_IL_END_SETUP_DET_HELPER helper = null;
	
	private List<SelectItem> esdCharValueList = new ArrayList<SelectItem>();
	
	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	

	public void setDataList_PM_IL_END_SETUP_DET1(
			List<PM_IL_END_SETUP_DET1> dataList_PM_IL_END_SETUP_DET1) {
		this.dataList_PM_IL_END_SETUP_DET1 = dataList_PM_IL_END_SETUP_DET1;
	}

	public PM_IL_END_SETUP_DET1_ACTION() {
		dataList_PM_IL_END_SETUP_DET1 = new ArrayList<PM_IL_END_SETUP_DET1>();
		helper = new PM_IL_END_SETUP_DET_HELPER();
	}

	public HtmlOutputLabel getCOMP_ESD_CODE_LABEL() {
		return COMP_ESD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ESD_CODE() {
		return COMP_ESD_CODE;
	}

	public void setCOMP_ESD_CODE_LABEL(HtmlOutputLabel COMP_ESD_CODE_LABEL) {
		this.COMP_ESD_CODE_LABEL = COMP_ESD_CODE_LABEL;
	}

	public void setCOMP_ESD_CODE(HtmlInputText COMP_ESD_CODE) {
		this.COMP_ESD_CODE = COMP_ESD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ESD_CODE_DESC_LABEL() {
		return COMP_UI_M_ESD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ESD_CODE_DESC() {
		return COMP_UI_M_ESD_CODE_DESC;
	}

	public void setCOMP_UI_M_ESD_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ESD_CODE_DESC_LABEL) {
		this.COMP_UI_M_ESD_CODE_DESC_LABEL = COMP_UI_M_ESD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_ESD_CODE_DESC(HtmlInputText COMP_UI_M_ESD_CODE_DESC) {
		this.COMP_UI_M_ESD_CODE_DESC = COMP_UI_M_ESD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_ESD_CHAR_VALUE_LABEL() {
		return COMP_ESD_CHAR_VALUE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ESD_CHAR_VALUE() {
		return COMP_ESD_CHAR_VALUE;
	}

	public void setCOMP_ESD_CHAR_VALUE_LABEL(HtmlOutputLabel COMP_ESD_CHAR_VALUE_LABEL) {
		this.COMP_ESD_CHAR_VALUE_LABEL = COMP_ESD_CHAR_VALUE_LABEL;
	}

	public void setCOMP_ESD_CHAR_VALUE(HtmlSelectOneMenu COMP_ESD_CHAR_VALUE) {
		this.COMP_ESD_CHAR_VALUE = COMP_ESD_CHAR_VALUE;
	}

	public List<PM_IL_END_SETUP_DET1> getDataList_PM_IL_END_SETUP_DET1() {
		return dataList_PM_IL_END_SETUP_DET1;
	}

	public void setDataListPM_IL_END_SETUP_DET1(List<PM_IL_END_SETUP_DET1> dataList_PM_IL_END_SETUP_DET1) {
		this.dataList_PM_IL_END_SETUP_DET1 = dataList_PM_IL_END_SETUP_DET1;
	}
	
	
	//method change for implement old grid to save time in posting records by Akash dated 20-MAR-2012 
	public void lastColumnListener(PM_IL_END_SETUP_DET1 pm_il_end_setup_det1){
		PM_IL_END_SETUP_DET_DELEGATE1 pm_il_end_setup_det1_delegate = new PM_IL_END_SETUP_DET_DELEGATE1();
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		try {
			  if(pm_il_end_setup_det1.getROWID()!=null){
				PRE_UPDATE(pm_il_end_setup_det1);
				rowUpdated = pm_il_end_setup_det1_delegate.updateData(pm_il_end_setup_det1);
				if(rowUpdated>0){
				  getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						  	"Record Updated Successfully.Please Save it.");
				  getWarningMap().put("CURRENT",
				  						"Record Updated Successfully.Please Save it.");
				}
			  } else {
						rowUpdated = pm_il_end_setup_det1_delegate.updateData(pm_il_end_setup_det1);
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

	public void PRE_UPDATE(PM_IL_END_SETUP_DET1 pm_il_end_setup_det1){
		pm_il_end_setup_det1.setESD_UPD_DT(new Date(Calendar.getInstance().getTimeInMillis()));
		pm_il_end_setup_det1.setESD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		 COMP_ESD_CHAR_VALUE.resetValue();
		 COMP_ESD_CODE.resetValue();
		 COMP_UI_M_ESD_CODE_DESC.resetValue();
	}

	public void setErrorMessagesInMap(ActionEvent event){
		CommonUtils.clearMaps(this);
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String getCurrentValue(ActionEvent event){
		CommonUtils.clearMaps(this);
		String value = null;
		UIInput input = null;
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	public void checkBoxValidation(ActionEvent event){
		CommonUtils.clearMaps(this);
	}
	
	public String checkBoxStatus(ActionEvent actionEvent){
		CommonUtils.clearMaps(this);
		Boolean value = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = dataTable.getRowIndex();
		PM_IL_END_SETUP_DET1 pm_il_end_setup_det1  = (PM_IL_END_SETUP_DET1) dataList_PM_IL_END_SETUP_DET1.get(rowIndex);
		pm_il_end_setup_det1.setCHECKBOX(value);
		return "";
	}
	private PM_IL_END_APPR_SETUP getPM_IL_END_APPR_SETUP_BEAN(){
		Map session= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PM_IL_END_APPR_SETUP_ACTION action = (PM_IL_END_APPR_SETUP_ACTION) session.get("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION");
		PM_IL_END_APPR_SETUP PM_IL_END_APPR_SETUP_BEAN = action.getPM_IL_END_APPR_SETUP_BEAN();
		return PM_IL_END_APPR_SETUP_BEAN;		
	}

	public List<SelectItem> getEsdCharValueList() {
		if (esdCharValueList.size() ==0){
			esdCharValueList.clear();				
			Connection con;
			try {
				con = CommonUtils.getConnection();
				esdCharValueList = ListItemUtil.getDropDownListValue(con, "PILM075_APAC", "PM_IL_END_SETUP_DET1", "PM_IL_END_SETUP_DET1.ESD_CHAR_VALUE", "YESNO");
			} catch (Exception e) {
				
			}
		}		
		return esdCharValueList;
	}

	public void setEsdCharValueList(List<SelectItem> esdCharValueList) {
		this.esdCharValueList = esdCharValueList;
	}
	public String save(){
		try {
			
		//	CommonUtils.clearMaps(this);
			
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put("current",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		return "";
	}
	
	
	public void onBlurESD_CHAR_VALUE(ActionEvent event) {
		PM_IL_END_SETUP_DET1 endrosmentBean = (PM_IL_END_SETUP_DET1) dataTable.getRowData();
		String ESD_CHAR_VALUE = (String) ((UIInput)event.getComponent().getParent()).getSubmittedValue();
		endrosmentBean.setESD_CHAR_VALUE(ESD_CHAR_VALUE);
		lastColumnListener(endrosmentBean);
	}
	
	

	public PM_IL_END_SETUP_DET1 getPM_IL_END_SETUP_DET1_BEAN() {
		return PM_IL_END_SETUP_DET1_BEAN;
	}

	public void setPM_IL_END_SETUP_DET1_BEAN(
			PM_IL_END_SETUP_DET1 pm_il_end_setup_det1_bean) {
		PM_IL_END_SETUP_DET1_BEAN = pm_il_end_setup_det1_bean;
	}

	public String getFilterByESD_CODE() {
		return filterByESD_CODE;
	}

	public void setFilterByESD_CODE(String filterByESD_CODE) {
		this.filterByESD_CODE = filterByESD_CODE;
	}

	public String getFilterByUI_M_ESD_CODE_DESC() {
		return filterByUI_M_ESD_CODE_DESC;
	}

	public void setFilterByUI_M_ESD_CODE_DESC(String filterByUI_M_ESD_CODE_DESC) {
		this.filterByUI_M_ESD_CODE_DESC = filterByUI_M_ESD_CODE_DESC;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}
	
	// to set the values in the bean
	public void  loadDatalist() throws Exception {
		PM_IL_END_SETUP_DET1_BEAN= new PM_IL_END_SETUP_DET1();
		//if (dataList_PM_IL_END_SETUP_DET1.size() == 0){
			ResultSet rs = null;
			dataList_PM_IL_END_SETUP_DET1.clear();
			try{
				
				PM_IL_END_APPR_SETUP bean= getPM_IL_END_APPR_SETUP_BEAN();
				CRUDHandler handler = new CRUDHandler();
				rs = handler.executeSelectStatement(PILM075_APAC_SQL_CONSTANTS.PM_IL_END_SETUP_DET1$getData, 
						CommonUtils.getConnection(),
						new Object[]{bean.getEAS_AS_USER_ID(),bean.getEAS_AS_FM_PROD_CODE(),bean.getEAS_AS_TO_PROD_CODE()});
				while (rs.next()){
					PM_IL_END_SETUP_DET1 PM_IL_END_SETUP_DET1_BEAN= new PM_IL_END_SETUP_DET1();
					PM_IL_END_SETUP_DET1_BEAN.setESD_CODE(rs.getString("ESD_CODE"));
					PM_IL_END_SETUP_DET1_BEAN.setROWID(rs.getString("ROWID"));
					PM_IL_END_SETUP_DET1_BEAN.setESD_CHAR_VALUE(rs.getString("ESD_CHAR_VALUE"));
					PM_IL_END_SETUP_DET_HELPER helper = new PM_IL_END_SETUP_DET_HELPER();
					PM_IL_END_SETUP_DET1_BEAN.setUI_M_ESD_CODE_DESC(helper.POST_QUERY(rs.getString("ESD_CODE")));
					dataList_PM_IL_END_SETUP_DET1.add(PM_IL_END_SETUP_DET1_BEAN);
				}
				PM_IL_END_SETUP_DET1 PM_IL_END_SETUP_DET1_BEAN = null;
				Iterator<PM_IL_END_SETUP_DET1> it = dataList_PM_IL_END_SETUP_DET1.iterator();
				while(it.hasNext()){
					PM_IL_END_SETUP_DET1_BEAN = it.next();
					PM_IL_END_SETUP_DET1_BEAN.setRowSelected(false);
				}
				if(dataList_PM_IL_END_SETUP_DET1.size()!=0)
				{
					 this.setPM_IL_END_SETUP_DET1_BEAN(dataList_PM_IL_END_SETUP_DET1.get(0));
					 this.getPM_IL_END_SETUP_DET1_BEAN().setRowSelected(true);
				}
			}catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}finally{
				try {
					CommonUtils.closeCursor(rs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//}

	}
	
	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				//getErrorMap().clear();
				//getWarningMap().clear();
				loadDatalist();
				//setBlockFlag(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
}
