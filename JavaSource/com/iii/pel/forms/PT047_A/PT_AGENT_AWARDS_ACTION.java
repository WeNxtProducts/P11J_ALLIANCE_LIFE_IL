package com.iii.pel.forms.PT047_A;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_AGENT_AWARDS_ACTION extends CommonAction {
	private HtmlOutputLabel COMP_UI_AAWRD_PROCESS_DT_LABEL;
	private HtmlCalendar COMP_UI_AAWRD_PROCESS_DT_;

	private HtmlOutputLabel COMP_UI_AAWRD_ACH_CODE_LABEL;
	private HtmlInputText COMP_UI_AAWRD_ACH_CODE;

	private HtmlOutputLabel COMP_UI_AAWRD_AWARD_CODE_LABEL;
	private HtmlInputText COMP_UI_AAWRD_AWARD_CODE;

	private HtmlOutputLabel COMP_UI_AAWRD_REMARKS_LABEL;
	private HtmlInputText COMP_UI_AAWRD_REMARKS;

	private HtmlOutputLabel COMP_UI_AAWRD_STATUSLABEL;
	private HtmlSelectOneMenu COMP_UI_AAWRD_STATUS;

	private HtmlInputText COMP_UI_M_AAWRD_ACH_CODE_DESC;

	private HtmlInputText COMP_UI_M_AAWRD_AWARD_CODE_DESC;

	private PT_AGENT_AWARDS PT_AGENT_AWARDS_BEAN = null;

	private List<PT_AGENT_AWARDS> dataList;

	private UIData uiDataTable;

	private List<SelectItem> statusFlagList;
	
	private String filterBYAAWRD_AWARD_CODE;
	
	private String filterBYAAWRD_AWARD_CODE_DESC;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;

	public PT_AGENT_AWARDS_ACTION() {
		PT_AGENT_AWARDS_BEAN = new PT_AGENT_AWARDS();
		getDropDownValues();
	}

	public HtmlOutputLabel getCOMP_UI_AAWRD_PROCESS_DT_LABEL() {
		return COMP_UI_AAWRD_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_AAWRD_PROCESS_DT_LABEL(
			HtmlOutputLabel comp_ui_aawrd_process_dt_label) {
		COMP_UI_AAWRD_PROCESS_DT_LABEL = comp_ui_aawrd_process_dt_label;
	}

	public HtmlCalendar getCOMP_UI_AAWRD_PROCESS_DT_() {
		return COMP_UI_AAWRD_PROCESS_DT_;
	}

	public void setCOMP_UI_AAWRD_PROCESS_DT_(
			HtmlCalendar comp_ui_aawrd_process_dt_) {
		COMP_UI_AAWRD_PROCESS_DT_ = comp_ui_aawrd_process_dt_;
	}

	public HtmlOutputLabel getCOMP_UI_AAWRD_ACH_CODE_LABEL() {
		return COMP_UI_AAWRD_ACH_CODE_LABEL;
	}

	public void setCOMP_UI_AAWRD_ACH_CODE_LABEL(
			HtmlOutputLabel comp_ui_aawrd_ach_code_label) {
		COMP_UI_AAWRD_ACH_CODE_LABEL = comp_ui_aawrd_ach_code_label;
	}

	public HtmlInputText getCOMP_UI_AAWRD_ACH_CODE() {
		return COMP_UI_AAWRD_ACH_CODE;
	}

	public void setCOMP_UI_AAWRD_ACH_CODE(HtmlInputText comp_ui_aawrd_ach_code) {
		COMP_UI_AAWRD_ACH_CODE = comp_ui_aawrd_ach_code;
	}

	public HtmlOutputLabel getCOMP_UI_AAWRD_AWARD_CODE_LABEL() {
		return COMP_UI_AAWRD_AWARD_CODE_LABEL;
	}

	public void setCOMP_UI_AAWRD_AWARD_CODE_LABEL(
			HtmlOutputLabel comp_ui_aawrd_award_code_label) {
		COMP_UI_AAWRD_AWARD_CODE_LABEL = comp_ui_aawrd_award_code_label;
	}

	public HtmlInputText getCOMP_UI_AAWRD_AWARD_CODE() {
		return COMP_UI_AAWRD_AWARD_CODE;
	}

	public void setCOMP_UI_AAWRD_AWARD_CODE(
			HtmlInputText comp_ui_aawrd_award_code) {
		COMP_UI_AAWRD_AWARD_CODE = comp_ui_aawrd_award_code;
	}

	public HtmlOutputLabel getCOMP_UI_AAWRD_REMARKS_LABEL() {
		return COMP_UI_AAWRD_REMARKS_LABEL;
	}

	public void setCOMP_UI_AAWRD_REMARKS_LABEL(
			HtmlOutputLabel comp_ui_aawrd_remarks_label) {
		COMP_UI_AAWRD_REMARKS_LABEL = comp_ui_aawrd_remarks_label;
	}

	public HtmlInputText getCOMP_UI_AAWRD_REMARKS() {
		return COMP_UI_AAWRD_REMARKS;
	}

	public void setCOMP_UI_AAWRD_REMARKS(HtmlInputText comp_ui_aawrd_remarks) {
		COMP_UI_AAWRD_REMARKS = comp_ui_aawrd_remarks;
	}

	public HtmlOutputLabel getCOMP_UI_AAWRD_STATUSLABEL() {
		return COMP_UI_AAWRD_STATUSLABEL;
	}

	public void setCOMP_UI_AAWRD_STATUSLABEL(
			HtmlOutputLabel comp_ui_aawrd_statuslabel) {
		COMP_UI_AAWRD_STATUSLABEL = comp_ui_aawrd_statuslabel;
	}

	public HtmlSelectOneMenu getCOMP_UI_AAWRD_STATUS() {
		return COMP_UI_AAWRD_STATUS;
	}

	public void setCOMP_UI_AAWRD_STATUS(HtmlSelectOneMenu comp_ui_aawrd_status) {
		COMP_UI_AAWRD_STATUS = comp_ui_aawrd_status;
	}

	public HtmlInputText getCOMP_UI_M_AAWRD_ACH_CODE_DESC() {
		return COMP_UI_M_AAWRD_ACH_CODE_DESC;
	}

	public void setCOMP_UI_M_AAWRD_ACH_CODE_DESC(
			HtmlInputText comp_ui_m_aawrd_ach_code_desc) {
		COMP_UI_M_AAWRD_ACH_CODE_DESC = comp_ui_m_aawrd_ach_code_desc;
	}

	public HtmlInputText getCOMP_UI_M_AAWRD_AWARD_CODE_DESC() {
		return COMP_UI_M_AAWRD_AWARD_CODE_DESC;
	}

	public void setCOMP_UI_M_AAWRD_AWARD_CODE_DESC(
			HtmlInputText comp_ui_m_aawrd_award_code_desc) {
		COMP_UI_M_AAWRD_AWARD_CODE_DESC = comp_ui_m_aawrd_award_code_desc;
	}

	public PT_AGENT_AWARDS getPT_AGENT_AWARDS_BEAN() {
		return PT_AGENT_AWARDS_BEAN;
	}

	public void setPT_AGENT_AWARDS_BEAN(PT_AGENT_AWARDS pt_agent_awards_bean) {
		PT_AGENT_AWARDS_BEAN = pt_agent_awards_bean;
	}

	public List<PT_AGENT_AWARDS> getDataList() {
		return dataList;
	}

	public void setDataList(List<PT_AGENT_AWARDS> dataList) {
		this.dataList = dataList;
	}

	public UIData getUiDataTable() {
		return uiDataTable;
	}

	public void setUiDataTable(UIData uiDataTable) {
		this.uiDataTable = uiDataTable;
	}

	private void getDropDownValues() {
		try {
			Connection connection = CommonUtils.getConnection();
			statusFlagList = new ListItemUtil().getDropDownListValue(
					connection, "PT047_A", "PT_AGENT_AWARDS",
					"PT_AGENT_AWARDS.AAWRD_STATUS", "YESNO");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SelectItem> getStatusFlagList() {
		return statusFlagList;
	}

	public void setStatusFlagList(List<SelectItem> statusFlagList) {
		this.statusFlagList = statusFlagList;
	}

	public void statusEvent(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String selectedValue = (String) input.getSubmittedValue();
//		int tableIdx = uiDataTable.getRowIndex();
	//	PT_AGENT_AWARDS pt_agent_awards = dataList.get(tableIdx);
		this.PT_AGENT_AWARDS_BEAN.setAAWRD_STATUS(selectedValue);
		// lastColumnListener();
	}

	public void lastColumnListener() {
		int tableIdx = uiDataTable.getRowIndex();
		PT_AGENT_AWARDS pt_agent_awards = dataList.get(tableIdx);
		new PT047_A_DELEGATE().executeUpdate(pt_agent_awards);
		String errorMessage = Messages.getString("messageProperties",
				"errorPanel$message$update");
		getWarningMap().put("current", errorMessage);
	}

	public String commitChanges() {
		try {

			new CommonUtils().doComitt();
			getWarningMap().put(
					"current",
					Messages.getString(PELConstants.pelErrorMessagePath,
							"SAVE_UPDATE_MESSAGE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// [ Added for grid implementation change, Added by: Rajesh Kundala,
	// Dated: 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = uiDataTable.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				lastColumnListener();
			} else {
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}

		return outcome;
	}
	// Added for grid implementation change, Added by: Rajesh Kundala, Dated:
	// 17-Feb-2009 ]

	/**
	 * 
	 */
	public void getDetails() {
		try {
			if (dataList!=null && dataList.size() != 0) {				
				PT_AGENT_AWARDS_BEAN = (PT_AGENT_AWARDS) uiDataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_AGENT_AWARDS_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
		COMP_UI_AAWRD_PROCESS_DT_.resetValue();
		COMP_UI_AAWRD_AWARD_CODE.resetValue();
		COMP_UI_M_AAWRD_AWARD_CODE_DESC.resetValue();
		COMP_UI_AAWRD_ACH_CODE.resetValue();
		COMP_UI_M_AAWRD_ACH_CODE_DESC.resetValue();
		COMP_UI_AAWRD_REMARKS.resetValue();
		COMP_UI_AAWRD_STATUS.resetValue();
	}
	
	private void resetSelectedRow() {
		Iterator<PT_AGENT_AWARDS> iterator = dataList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void post(ActionEvent ae) {
		try{
			ControlBean controlBean = CommonUtils.getControlBean();
			CommonUtils commonUtils = new CommonUtils();
			
			if(PT_AGENT_AWARDS_BEAN.getROWID() != null) {
				PT_AGENT_AWARDS_BEAN.setAAWRD_UPD_DT(new CommonUtils().getCurrentDate());
				PT_AGENT_AWARDS_BEAN.setAAWRD_UPD_UID(controlBean.getM_USER_ID());
				if(isUPDATE_ALLOWED()) {
					new CRUDHandler().executeInsert(PT_AGENT_AWARDS_BEAN, commonUtils.getConnection());
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
					PT_AGENT_AWARDS_BEAN.setAAWRD_CR_DT(new CommonUtils().getCurrentDate());
					PT_AGENT_AWARDS_BEAN.setAAWRD_CR_UID(controlBean.getM_USER_ID());
					new CRUDHandler().executeInsert(PT_AGENT_AWARDS_BEAN, commonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					
					dataList.add(PT_AGENT_AWARDS_BEAN);
					
					for(int i=0;i<dataList.size();i++){
						PT_AGENT_AWARDS_BEAN = (PT_AGENT_AWARDS) dataList.get(i);
						if(i==0){
							setPT_AGENT_AWARDS_BEAN(PT_AGENT_AWARDS_BEAN);
							PT_AGENT_AWARDS_BEAN.setRowSelected(true);
						}else{
							PT_AGENT_AWARDS_BEAN.setRowSelected(false);
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
	 * @return the filterBYAAWRD_AWARD_CODE
	 */
	public String getFilterBYAAWRD_AWARD_CODE() {
		return filterBYAAWRD_AWARD_CODE;
	}

	/**
	 * @param filterBYAAWRD_AWARD_CODE the filterBYAAWRD_AWARD_CODE to set
	 */
	public void setFilterBYAAWRD_AWARD_CODE(String filterBYAAWRD_AWARD_CODE) {
		this.filterBYAAWRD_AWARD_CODE = filterBYAAWRD_AWARD_CODE;
	}

	/**
	 * @return the filterBYAAWRD_AWARD_CODE_DESC
	 */
	public String getFilterBYAAWRD_AWARD_CODE_DESC() {
		return filterBYAAWRD_AWARD_CODE_DESC;
	}

	/**
	 * @param filterBYAAWRD_AWARD_CODE_DESC the filterBYAAWRD_AWARD_CODE_DESC to set
	 */
	public void setFilterBYAAWRD_AWARD_CODE_DESC(
			String filterBYAAWRD_AWARD_CODE_DESC) {
		this.filterBYAAWRD_AWARD_CODE_DESC = filterBYAAWRD_AWARD_CODE_DESC;
	}

	
}
