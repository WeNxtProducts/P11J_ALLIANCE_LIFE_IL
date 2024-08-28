package com.iii.pel.forms.PILM015_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROP_TREATY_PERIOD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PPTP_PT_TREATY_CODE_LABEL;

	private HtmlInputText COMP_PPTP_PT_TREATY_CODE;

	private HtmlOutputLabel COMP_PPTP_MON_FM_LABEL;

	private HtmlInputText COMP_PPTP_MON_FM;

	private HtmlOutputLabel COMP_PPTP_MON_TO_LABEL;

	private HtmlInputText COMP_PPTP_MON_TO;

	private HtmlOutputLabel COMP_PPTP_SUB_NO_LABEL;

	private HtmlInputText COMP_PPTP_SUB_NO;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN1;

	private PM_IL_PROP_TREATY_PERIOD PM_IL_PROP_TREATY_PERIOD_BEAN;

	private int currentPage;

	private int recordsPerPage = 5;

	private int prevRowInd;

	private int lastUpdateRowIndex;

	private ArrayList<PM_IL_PROP_TREATY_PERIOD> dataTableList;

	List resultList;
	private UIData dataTable;
	
	///filters
	private String filterByPPTP_PT_TREATY_CODE;
	private String filterByPPTP_MON_FM;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	private HtmlAjaxCommandButton UI_M_BUT_POST;

	PM_IL_PROP_TREATY_PERIOD_DELEGATE pm_il_prop_treaty_period_delegate;
	
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;

	public PM_IL_PROP_TREATY_PERIOD_ACTION() {
		PM_IL_PROP_TREATY_PERIOD_BEAN = new PM_IL_PROP_TREATY_PERIOD();
		pm_il_prop_treaty_period_delegate = new PM_IL_PROP_TREATY_PERIOD_DELEGATE();
		dataTableList = new ArrayList<PM_IL_PROP_TREATY_PERIOD>();

		/*
		 * resultList = new ArrayList();
		 * 
		 * try { resultList =
		 * pm_il_prop_treaty_period_delegate.getValuesForHeader(); for (int
		 * index = 0; index < resultList.size(); index++) {
		 * PM_IL_PROP_TREATY_PERIOD gridValueBean = (PM_IL_PROP_TREATY_PERIOD)
		 * resultList .get(index); dataTableList.add(gridValueBean); } } catch
		 * (Exception e) { e.printStackTrace(); }
		 */

	}

	public HtmlOutputLabel getCOMP_PPTP_PT_TREATY_CODE_LABEL() {
		return COMP_PPTP_PT_TREATY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PPTP_PT_TREATY_CODE() {
		return COMP_PPTP_PT_TREATY_CODE;
	}

	public void setCOMP_PPTP_PT_TREATY_CODE_LABEL(
			HtmlOutputLabel COMP_PPTP_PT_TREATY_CODE_LABEL) {
		this.COMP_PPTP_PT_TREATY_CODE_LABEL = COMP_PPTP_PT_TREATY_CODE_LABEL;
	}

	public void setCOMP_PPTP_PT_TREATY_CODE(
			HtmlInputText COMP_PPTP_PT_TREATY_CODE) {
		this.COMP_PPTP_PT_TREATY_CODE = COMP_PPTP_PT_TREATY_CODE;
	}

	public HtmlOutputLabel getCOMP_PPTP_MON_FM_LABEL() {
		return COMP_PPTP_MON_FM_LABEL;
	}

	public HtmlInputText getCOMP_PPTP_MON_FM() {
		return COMP_PPTP_MON_FM;
	}

	public void setCOMP_PPTP_MON_FM_LABEL(HtmlOutputLabel COMP_PPTP_MON_FM_LABEL) {
		this.COMP_PPTP_MON_FM_LABEL = COMP_PPTP_MON_FM_LABEL;
	}

	public void setCOMP_PPTP_MON_FM(HtmlInputText COMP_PPTP_MON_FM) {
		this.COMP_PPTP_MON_FM = COMP_PPTP_MON_FM;
	}

	public HtmlOutputLabel getCOMP_PPTP_MON_TO_LABEL() {
		return COMP_PPTP_MON_TO_LABEL;
	}

	public HtmlInputText getCOMP_PPTP_MON_TO() {
		return COMP_PPTP_MON_TO;
	}

	public void setCOMP_PPTP_MON_TO_LABEL(HtmlOutputLabel COMP_PPTP_MON_TO_LABEL) {
		this.COMP_PPTP_MON_TO_LABEL = COMP_PPTP_MON_TO_LABEL;
	}

	public void setCOMP_PPTP_MON_TO(HtmlInputText COMP_PPTP_MON_TO) {
		this.COMP_PPTP_MON_TO = COMP_PPTP_MON_TO;
	}

	public HtmlOutputLabel getCOMP_PPTP_SUB_NO_LABEL() {
		return COMP_PPTP_SUB_NO_LABEL;
	}

	public HtmlInputText getCOMP_PPTP_SUB_NO() {
		return COMP_PPTP_SUB_NO;
	}

	public void setCOMP_PPTP_SUB_NO_LABEL(HtmlOutputLabel COMP_PPTP_SUB_NO_LABEL) {
		this.COMP_PPTP_SUB_NO_LABEL = COMP_PPTP_SUB_NO_LABEL;
	}

	public void setCOMP_PPTP_SUB_NO(HtmlInputText COMP_PPTP_SUB_NO) {
		this.COMP_PPTP_SUB_NO = COMP_PPTP_SUB_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN1() {
		return COMP_UI_M_BUT_MAIN1;
	}

	public void setCOMP_UI_M_BUT_MAIN1(HtmlCommandButton COMP_UI_M_BUT_MAIN1) {
		this.COMP_UI_M_BUT_MAIN1 = COMP_UI_M_BUT_MAIN1;
	}

	public PM_IL_PROP_TREATY_PERIOD getPM_IL_PROP_TREATY_PERIOD_BEAN() {
		return PM_IL_PROP_TREATY_PERIOD_BEAN;
	}

	public void setPM_IL_PROP_TREATY_PERIOD_BEAN(
			PM_IL_PROP_TREATY_PERIOD PM_IL_PROP_TREATY_PERIOD_BEAN) {
		this.PM_IL_PROP_TREATY_PERIOD_BEAN = PM_IL_PROP_TREATY_PERIOD_BEAN;
	}

	public String AddRow() {
		int rowCount = 0;

		if (dataTableList == null) {
			dataTableList = new ArrayList<PM_IL_PROP_TREATY_PERIOD>();
		}
		dataTableList.add(new PM_IL_PROP_TREATY_PERIOD());

		PM_IL_PROP_TREATY_PERIOD_HELPER treatyPeriodHelper = new PM_IL_PROP_TREATY_PERIOD_HELPER();
		treatyPeriodHelper
				.pilm015_apac_pm_il_prop_treaty_period__when_create_record(compositeAction);// WHEN-NEW-RECORD

		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currentPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currentPage++;
		}

		return "newadded";
	}
	// [BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied
	public void selectValues() throws Exception{
		try {
			dataTableList = (ArrayList<PM_IL_PROP_TREATY_PERIOD>) 
				new PM_IL_PROP_TREATY_PERIOD_DELEGATE().getValuesForHeader(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
//	BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied ]	

	public String deleteRow() throws Exception {

		PM_IL_PROP_TREATY_PERIOD bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataTableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataTableList.size();) {
				bean = dataTableList.get(index);
				if (bean.isSelected()) {
					dataTableList.remove(bean);
					deletedRecordIndex = pm_il_prop_treaty_period_delegate
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}

			if (deletedRecordList.size() > 0) {
				getErrorMap().put("somekey",
						deletedRecordList.size() + " records deleted.");
				getErrorMap().put("current",
						deletedRecordList.size() + " records deleted.");
			}
			lastUpdateRowIndex = -1;
		}

		return "";
	}

	// [ Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
	/*public void gridtabListener() {

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TREATY_PERIOD gridValueBean = null;
		System.out.println(lastUpdateRowIndex + "   " + currRowIndex + "  "
				+ prevRowInd);
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction = (PM_IL_PROP_TREATY_COMPOSITE_ACTION) (commonUtils
				.getMappedBeanFromSession("PM_IL_PROP_TREATY_COMPOSITE_ACTION"));
		String treatyCode = compositeAction.getPM_IL_PROP_TREATY_ACTION()
				.getPM_IL_PROP_TREATY_BEAN().getPT_TREATY_CODE();
		try {
			if (lastUpdateRowIndex != -1) {
				if (lastUpdateRowIndex != prevRowInd) {
					if (currRowIndex != prevRowInd) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PM_IL_PROP_TREATY_PERIOD) dataTableList
								.get(prevRowInd);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {
							gridValueBean.setPPTP_PT_TREATY_CODE(treatyCode);
							rowUpdated = pm_il_prop_treaty_period_delegate
									.update(gridValueBean);
							getErrorMap().put("somekey",
									rowUpdated + " record updated.");
							getErrorMap().put("current",
									rowUpdated + " record updated.");
						} else {
							gridValueBean.setPPTP_PT_TREATY_CODE(treatyCode);
							rowUpdated = pm_il_prop_treaty_period_delegate
									.update(gridValueBean);
							getErrorMap().put("somekey",
									rowUpdated + " record inserted.");
							getErrorMap().put("current",
									rowUpdated + " record inserted.");

						}

						// Update previous row index
						prevRowInd = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}

		return;
	}*/
	// Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]

	public void lastColumnListener() {
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TREATY_PERIOD gridValueBean = null;
		String treatyCode = compositeAction.getPM_IL_PROP_TREATY_ACTION()
				.getPM_IL_PROP_TREATY_BEAN().getPT_TREATY_CODE();
		try {

			// Get the bean based on row index
			gridValueBean = (PM_IL_PROP_TREATY_PERIOD) dataTableList
					.get(currRowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				gridValueBean.setPPTP_PT_TREATY_CODE(treatyCode);
				rowUpdated = pm_il_prop_treaty_period_delegate
						.update(gridValueBean);
				getErrorMap().put("somekey", rowUpdated + " record updated.");
				getErrorMap().put("current", rowUpdated + " record updated.");
			} else {
				gridValueBean.setPPTP_PT_TREATY_CODE(treatyCode);
				rowUpdated = pm_il_prop_treaty_period_delegate
						.update(gridValueBean);
				getErrorMap().put("somekey", rowUpdated + " record inserted.");
				getErrorMap().put("current", rowUpdated + " record inserted.");
			}
			lastUpdateRowIndex = currRowIndex;

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}

	public String backtoTreatyType() {

		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		return "TreatyType";
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void treatyCodeWhenValidate(FacesContext facesContext,
			UIComponent component, Object value) {

		if (COMP_PPTP_PT_TREATY_CODE.getSubmittedValue() != null) {

			String treatyCode = (String) COMP_PPTP_PT_TREATY_CODE
					.getSubmittedValue();
			this.PM_IL_PROP_TREATY_PERIOD_BEAN.setPPTP_PT_TREATY_CODE(treatyCode);
		}

	}

	public void monthFromWhenValidate(FacesContext facesContext,
			UIComponent component, Object value) {

		if (COMP_PPTP_MON_FM.getSubmittedValue() != null) {

			Integer monthFrom = Integer.parseInt((String) COMP_PPTP_MON_FM
					.getSubmittedValue());
			this.PM_IL_PROP_TREATY_PERIOD_BEAN.setPPTP_MON_FM(monthFrom);

		}
	}

	public void monthToWhenValidate(FacesContext facesContext,
			UIComponent component, Object value) {

		if (COMP_PPTP_MON_TO.getSubmittedValue() != null) {

			Integer monthTo = Integer.parseInt((String) COMP_PPTP_MON_TO
					.getSubmittedValue());
			this.PM_IL_PROP_TREATY_PERIOD_BEAN.setPPTP_MON_TO(monthTo);
		}

	}

	public void subNumberWhenValidate(FacesContext facesContext,
			UIComponent component, Object value) {

		if (COMP_PPTP_SUB_NO.getSubmittedValue() != null) {

			Integer subNo = Integer.parseInt((String) COMP_PPTP_SUB_NO
					.getSubmittedValue());
			this.PM_IL_PROP_TREATY_PERIOD_BEAN.setPPTP_SUB_NO(subNo);
		}

	}

	public void saveData() {

		try {
			CommonUtils.doComitt();
			getWarningMap().put("current", "Records Saved");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getPrevRowInd() {
		return prevRowInd;
	}

	public void setPrevRowInd(int prevRowInd) {
		this.prevRowInd = prevRowInd;
	}

	public int getLastUpdateRowIndex() {
		return lastUpdateRowIndex;
	}

	public void setLastUpdateRowIndex(int lastUpdateRowIndex) {
		this.lastUpdateRowIndex = lastUpdateRowIndex;
	}

	public ArrayList<PM_IL_PROP_TREATY_PERIOD> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(
			ArrayList<PM_IL_PROP_TREATY_PERIOD> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	// [ Added for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
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
	// Added for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]
	
	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {				
				PM_IL_PROP_TREATY_PERIOD_BEAN = (PM_IL_PROP_TREATY_PERIOD) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_PROP_TREATY_PERIOD_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PPTP_MON_FM.resetValue();
		COMP_PPTP_MON_TO.resetValue();
		COMP_PPTP_PT_TREATY_CODE.resetValue();
		COMP_PPTP_SUB_NO.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_PROP_TREATY_PERIOD> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String getFilterByPPTP_PT_TREATY_CODE() {
		return filterByPPTP_PT_TREATY_CODE;
	}

	public void setFilterByPPTP_PT_TREATY_CODE(String filterByPPTP_PT_TREATY_CODE) {
		this.filterByPPTP_PT_TREATY_CODE = filterByPPTP_PT_TREATY_CODE;
	}

	public String getFilterByPPTP_MON_FM() {
		return filterByPPTP_MON_FM;
	}

	public void setFilterByPPTP_MON_FM(String filterByPPTP_MON_FM) {
		this.filterByPPTP_MON_FM = filterByPPTP_MON_FM;
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
}
