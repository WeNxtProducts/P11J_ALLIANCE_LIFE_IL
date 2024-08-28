package com.iii.pel.forms.PILM015_APAC;

import java.sql.SQLException;
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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlScrollableDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_HTWT_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_HTWT_HEIGHT_FM_LABEL;

	private HtmlInputText COMP_HTWT_HEIGHT_FM;

	private HtmlOutputLabel COMP_HTWT_HEIGHT_TO_LABEL;

	private HtmlInputText COMP_HTWT_HEIGHT_TO;

	private HtmlOutputLabel COMP_HTWT_WEIGHT_FM_LABEL;

	private HtmlInputText COMP_HTWT_WEIGHT_FM;

	private HtmlOutputLabel COMP_HTWT_WEIGHT_TO_LABEL;

	private HtmlInputText COMP_HTWT_WEIGHT_TO;

	private HtmlOutputLabel COMP_HTWT_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_HTWT_EFF_FM_DT;

	private HtmlOutputLabel COMP_HTWT_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_HTWT_EFF_TO_DT;

	private ArrayList<PM_IL_HTWT_DTL> dataTableList;

	private HtmlScrollableDataTable scrollableDataTable;

	private boolean INSERT_ALLOWED = true;

	private boolean UPDATE_ALLOWED = true;

	private boolean DELETE_ALLOWED = true;

	/*
	 * Below attributes are used for the rendering and managing of grid
	 */

	private List resultList;
	private UIData dataTable;

	private int recordsPerPage = 5;

	private int currPage;

	private int prevRowIndex;

	private int lastUpdatedRowIndex;

	/* Helper and delegate */
	private PM_IL_HTWT_DTL_HELPER pm_il_htwt_dtl_helper;

	private PM_IL_HTWT_DTL_DELEGATE pm_il_htwt_dtl_delegate;
	private PM_IL_HTWT_DTL PM_IL_HTWT_DTL_BEAN;
	
	private boolean onPageLoad;

	//filters
	private String filterByHTWT_HEIGHT_FM;
	
	private String filterByHTWT_HEIGHT_TO;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	CommonUtils commonUtils =new CommonUtils() ;
	
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;

	public boolean isOnPageLoad() {
		return onPageLoad;
	}

	public void setOnPageLoad(boolean onPageLoad) {
		this.onPageLoad = onPageLoad;
	}

	public PM_IL_HTWT_DTL_ACTION() {
		PM_IL_HTWT_DTL_BEAN = new PM_IL_HTWT_DTL();
		dataTableList = new ArrayList<PM_IL_HTWT_DTL>();
		prevRowIndex = 0;
		currPage = 1;
		pm_il_htwt_dtl_delegate = new PM_IL_HTWT_DTL_DELEGATE();
		pm_il_htwt_dtl_helper = new PM_IL_HTWT_DTL_HELPER();

	}

	public HtmlOutputLabel getCOMP_HTWT_HEIGHT_FM_LABEL() {
		return COMP_HTWT_HEIGHT_FM_LABEL;
	}

	public HtmlInputText getCOMP_HTWT_HEIGHT_FM() {
		return COMP_HTWT_HEIGHT_FM;
	}

	public void setCOMP_HTWT_HEIGHT_FM_LABEL(
			HtmlOutputLabel COMP_HTWT_HEIGHT_FM_LABEL) {
		this.COMP_HTWT_HEIGHT_FM_LABEL = COMP_HTWT_HEIGHT_FM_LABEL;
	}

	public void setCOMP_HTWT_HEIGHT_FM(HtmlInputText COMP_HTWT_HEIGHT_FM) {
		this.COMP_HTWT_HEIGHT_FM = COMP_HTWT_HEIGHT_FM;
	}

	public HtmlOutputLabel getCOMP_HTWT_HEIGHT_TO_LABEL() {
		return COMP_HTWT_HEIGHT_TO_LABEL;
	}

	public HtmlInputText getCOMP_HTWT_HEIGHT_TO() {
		return COMP_HTWT_HEIGHT_TO;
	}

	public void setCOMP_HTWT_HEIGHT_TO_LABEL(
			HtmlOutputLabel COMP_HTWT_HEIGHT_TO_LABEL) {
		this.COMP_HTWT_HEIGHT_TO_LABEL = COMP_HTWT_HEIGHT_TO_LABEL;
	}

	public void setCOMP_HTWT_HEIGHT_TO(HtmlInputText COMP_HTWT_HEIGHT_TO) {
		this.COMP_HTWT_HEIGHT_TO = COMP_HTWT_HEIGHT_TO;
	}

	public HtmlOutputLabel getCOMP_HTWT_WEIGHT_FM_LABEL() {
		return COMP_HTWT_WEIGHT_FM_LABEL;
	}

	public HtmlInputText getCOMP_HTWT_WEIGHT_FM() {
		return COMP_HTWT_WEIGHT_FM;
	}

	public void setCOMP_HTWT_WEIGHT_FM_LABEL(
			HtmlOutputLabel COMP_HTWT_WEIGHT_FM_LABEL) {
		this.COMP_HTWT_WEIGHT_FM_LABEL = COMP_HTWT_WEIGHT_FM_LABEL;
	}

	public void setCOMP_HTWT_WEIGHT_FM(HtmlInputText COMP_HTWT_WEIGHT_FM) {
		this.COMP_HTWT_WEIGHT_FM = COMP_HTWT_WEIGHT_FM;
	}

	public HtmlOutputLabel getCOMP_HTWT_WEIGHT_TO_LABEL() {
		return COMP_HTWT_WEIGHT_TO_LABEL;
	}

	public HtmlInputText getCOMP_HTWT_WEIGHT_TO() {
		return COMP_HTWT_WEIGHT_TO;
	}

	public void setCOMP_HTWT_WEIGHT_TO_LABEL(
			HtmlOutputLabel COMP_HTWT_WEIGHT_TO_LABEL) {
		this.COMP_HTWT_WEIGHT_TO_LABEL = COMP_HTWT_WEIGHT_TO_LABEL;
	}

	public void setCOMP_HTWT_WEIGHT_TO(HtmlInputText COMP_HTWT_WEIGHT_TO) {
		this.COMP_HTWT_WEIGHT_TO = COMP_HTWT_WEIGHT_TO;
	}

	public HtmlOutputLabel getCOMP_HTWT_EFF_FM_DT_LABEL() {
		return COMP_HTWT_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_HTWT_EFF_FM_DT() {
		return COMP_HTWT_EFF_FM_DT;
	}

	public void setCOMP_HTWT_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_HTWT_EFF_FM_DT_LABEL) {
		this.COMP_HTWT_EFF_FM_DT_LABEL = COMP_HTWT_EFF_FM_DT_LABEL;
	}

	public void setCOMP_HTWT_EFF_FM_DT(HtmlCalendar COMP_HTWT_EFF_FM_DT) {
		this.COMP_HTWT_EFF_FM_DT = COMP_HTWT_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_HTWT_EFF_TO_DT_LABEL() {
		return COMP_HTWT_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_HTWT_EFF_TO_DT() {
		return COMP_HTWT_EFF_TO_DT;
	}

	public void setCOMP_HTWT_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_HTWT_EFF_TO_DT_LABEL) {
		this.COMP_HTWT_EFF_TO_DT_LABEL = COMP_HTWT_EFF_TO_DT_LABEL;
	}

	public void setCOMP_HTWT_EFF_TO_DT(HtmlCalendar COMP_HTWT_EFF_TO_DT) {
		this.COMP_HTWT_EFF_TO_DT = COMP_HTWT_EFF_TO_DT;
	}

	public ArrayList<PM_IL_HTWT_DTL> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(ArrayList<PM_IL_HTWT_DTL> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public HtmlScrollableDataTable getScrollableDataTable() {
		return scrollableDataTable;
	}

	public void setScrollableDataTable(
			HtmlScrollableDataTable scrollableDataTable) {
		this.scrollableDataTable = scrollableDataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
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

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public PM_IL_HTWT_DTL_HELPER getPm_il_htwt_dtl_helper() {
		return pm_il_htwt_dtl_helper;
	}

	public void setPm_il_htwt_dtl_helper(
			PM_IL_HTWT_DTL_HELPER pm_il_htwt_dtl_helper) {
		this.pm_il_htwt_dtl_helper = pm_il_htwt_dtl_helper;
	}

	public PM_IL_HTWT_DTL_DELEGATE getPm_il_htwt_dtl_delegate() {
		return pm_il_htwt_dtl_delegate;
	}

	public void setPm_il_htwt_dtl_delegate(
			PM_IL_HTWT_DTL_DELEGATE pm_il_htwt_dtl_delegate) {
		this.pm_il_htwt_dtl_delegate = pm_il_htwt_dtl_delegate;
	}



	public void addRow(ActionEvent ae) {
		dataTableList.add(new PM_IL_HTWT_DTL());
	}

	public String addNew() {
		int rowCount = 0;
		if (dataTableList == null) {
			dataTableList = new ArrayList<PM_IL_HTWT_DTL>();
		}
		dataTableList.add(new PM_IL_HTWT_DTL());
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return "newadded";
	}

	// [ Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
	/*public void gridtabListener() {

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_HTWT_DTL pm_il_htwt_dtl = new PM_IL_HTWT_DTL();
		System.out.println("gridtabListener --- last curr prev "
				+ lastUpdatedRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdatedRowIndex != -1) {
				System.out.println("gridtabListener - lastupdrowindes <> -1");
				if (lastUpdatedRowIndex != prevRowIndex) {
					System.out
					.println("gridtabListener - lastUpdatedRowIndex != prevRowIndex");
					if (currRowIndex != prevRowIndex) {
						System.out
						.println("gridtabListener - currRowIndex != prevRowIndex");
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						pm_il_htwt_dtl = (PM_IL_HTWT_DTL) dataTableList
						.get(prevRowIndex);

						// Update the record to database
						if (pm_il_htwt_dtl.getROWID() != null) {
							Map getmap = FacesContext.getCurrentInstance()
							.getExternalContext().getSessionMap();
							PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction = (PM_IL_PROP_TREATY_COMPOSITE_ACTION) getmap
							.get("PM_IL_PROP_TREATY_COMPOSITE_ACTION");
							PM_IL_PROP_TREATY_ACTION treatyAction = compositeAction
							.getPM_IL_PROP_TREATY_ACTION();
							PM_IL_PROP_TREATY treatyBean = treatyAction
							.getPM_IL_PROP_TREATY_BEAN();
							Double PT_SYS_ID = treatyBean.getPT_SYS_ID();
							System.out.println("PT_SYS_ID IS:" + PT_SYS_ID);
							pm_il_htwt_dtl.setHTWT_PT_SYS_ID(PT_SYS_ID);

							pm_il_htwt_dtl.setHTWT_UPD_DT(new Date());
							pm_il_htwt_dtl.setHTWT_UPD_UID("PEL_LIFE");
							// pm_il_htwt_dtl_helper.preUpdateTrigger(this);
							rowUpdated = pm_il_htwt_dtl_delegate
							.updateData(pm_il_htwt_dtl);
							getWarningMap().put("current", "Record Updated");


						} else {
							// gridValueBean.setMEH_SUM_ASSURED_FM(1.0);
							
							 * pm_il_htwt_dtl_delegate.L_VALIDATE_HTWT_RANGE(
							 * pm_il_htwt_dtl, this);
							 

							rowUpdated = pm_il_htwt_dtl_delegate
							.updateData(pm_il_htwt_dtl);
							getWarningMap().put("current", "Record Inserted");

						}

						// Update previous row index
						prevRowIndex = currRowIndex;
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

	private void lastColumnListener() {
		int currRowIndex = getDataTable().getRowIndex();
		PM_IL_HTWT_DTL pm_il_htwt_dtl = null;
		try {
			pm_il_htwt_dtl = (PM_IL_HTWT_DTL) dataTableList.get(currRowIndex);
			if (pm_il_htwt_dtl.getROWID() != null) {
				pm_il_htwt_dtl_helper.preUpdateTrigger(pm_il_htwt_dtl);
				pm_il_htwt_dtl_delegate.updateData(pm_il_htwt_dtl);
				getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
			} else {
				pm_il_htwt_dtl_helper.PILM015_APAC_PM_IL_HTWT_DTL_PRE_INSERT(compositeAction);
				pm_il_htwt_dtl_delegate.updateData(pm_il_htwt_dtl);
				getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
			getErrorMap().put("current", e1.getMessage());
			getErrorMap().put("detail", e1.getMessage());
		}
		return;
	}

	public void checkBoxValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//gridtabListener();
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		getDataTableList().get(rowIndex).setCHECK_BOX(check);
		return "";
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				if(value.equals("")) {
					value = null;
				}
			}
		}
		return value;
	}

	/*public String deleteRow() {

		PM_IL_HTWT_DTL pm_il_htwt_dtl = null;
		int deletedRecordCount = 0;

		if (dataTableList != null) {

			for (int index = dataTableList.size(); index > 0; index--) {
				pm_il_htwt_dtl = dataTableList.get(index - 1);
				if (pm_il_htwt_dtl.isCHECK_BOX()) {

					dataTableList.remove(pm_il_htwt_dtl);
					pm_il_htwt_dtl_delegate.deleteData(pm_il_htwt_dtl);
					deletedRecordCount++;
				}
			}

			if (deletedRecordCount > 0) {
				getWarningMap().put("current", + deletedRecordCount +"Records Deleted");
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}*/

	/* Validator methods for the grid table */

	public void HTWT_EFF_FM_DT_WHEN_VALIDATE_ITEM(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		Date value = getCOMP_HTWT_EFF_FM_DT().getAsDate(CommonUtils.getCurrentValue(input));
		this.PM_IL_HTWT_DTL_BEAN.setHTWT_EFF_FM_DT(value);
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateEFF_FM_DT(FacesContext fc, UIComponent component,
			Object value) {
		PM_IL_HTWT_DTL htwtBean = this.PM_IL_HTWT_DTL_BEAN;
		try {
			pm_il_htwt_dtl_helper.EFF_FM_DT_WHEN_VALIDATE_ITEM(htwtBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void HTWT_EFF_TO_DT_WHEN_VALIDATE_ITEM(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		Date value = getCOMP_HTWT_EFF_TO_DT().getAsDate(CommonUtils.getCurrentValue(input));
		this.PM_IL_HTWT_DTL_BEAN.setHTWT_EFF_TO_DT(value);
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateEFF_TO_DT(FacesContext fc, UIComponent component,
			Object value) {
		PM_IL_HTWT_DTL htwtBean = this.PM_IL_HTWT_DTL_BEAN;
		try {
			pm_il_htwt_dtl_helper.EFF_TO_DT_WHEN_VALIDATE_ITEM(htwtBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void HTWT_HEIGHT_FM_WHEN_VALIDATE_ITEM(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		this.PM_IL_HTWT_DTL_BEAN.setHTWT_HEIGHT_FM(CommonUtils.parseToDouble(getCurrentValue(actionEvent)));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void heightFromWhenValidate(FacesContext context,
			UIComponent component, Object value) {
		PM_IL_HTWT_DTL htwtBean = this.PM_IL_HTWT_DTL_BEAN;
		try {
			pm_il_htwt_dtl_helper.HEIGHT_FROM_WHEN_VALIDATE_ITEM(htwtBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void HTWT_HEIGHT_TO_WHEN_VALIDATE_ITEM(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		this.PM_IL_HTWT_DTL_BEAN.setHTWT_HEIGHT_TO(CommonUtils.parseToDouble(getCurrentValue(actionEvent)));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void heightToWhenValidate(FacesContext context,
			UIComponent component, Object value) {
		PM_IL_HTWT_DTL htwtBean = this.PM_IL_HTWT_DTL_BEAN;
		try {
			pm_il_htwt_dtl_helper.HEIGHT_TO_WHEN_VALIDATE_ITEM(htwtBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void HTWT_WEIGHT_FM_WHEN_VALIDATE_ITEM(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		this.PM_IL_HTWT_DTL_BEAN.setHTWT_WEIGHT_FM(CommonUtils.parseToDouble(getCurrentValue(actionEvent)));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void weightFromWhenValidate(FacesContext context,
			UIComponent component, Object value) {
		PM_IL_HTWT_DTL htwtBean = this.PM_IL_HTWT_DTL_BEAN;
		try {
			pm_il_htwt_dtl_helper.WEIGHT_FROM_WHEN_VALIDATE_ITEM(htwtBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void HTWT_WEIGHT_TO_WHEN_VALIDATE_ITEM(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		this.PM_IL_HTWT_DTL_BEAN.setHTWT_WEIGHT_TO(CommonUtils.parseToDouble(getCurrentValue(actionEvent)));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void weightToWhenValidate(FacesContext context,
			UIComponent component, Object value) {
		PM_IL_HTWT_DTL htwtBean = this.PM_IL_HTWT_DTL_BEAN;
		try {
			pm_il_htwt_dtl_helper.WEIGHT_TO_WHEN_VALIDATE_ITEM(htwtBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String fetchHeightWeightList() throws Exception {
		try {
			dataTableList = (ArrayList<PM_IL_HTWT_DTL>) new PM_IL_HTWT_DTL_DELEGATE()
			.prepareHeightWeightDetails(compositeAction);
			PM_IL_HTWT_DTL PM_IL_HTWT_DTL_BEAN = null;
			Iterator<PM_IL_HTWT_DTL> iterator = dataTableList.iterator();
			while(iterator.hasNext()){
				PM_IL_HTWT_DTL_BEAN = iterator.next();
				PM_IL_HTWT_DTL_BEAN.setRowSelected(false);
			}
			if (dataTableList.size() !=0){					
				setPM_IL_HTWT_DTL_BEAN(dataTableList.get(0));
				getPM_IL_HTWT_DTL_BEAN().setRowSelected(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return "MedicalExamDetails";
	}

	public boolean isINSERT_ALLOWED() {
		return INSERT_ALLOWED;
	}

	public void setINSERT_ALLOWED(boolean insert_allowed) {
		INSERT_ALLOWED = insert_allowed;
	}

	public boolean isUPDATE_ALLOWED() {
		return UPDATE_ALLOWED;
	}

	public void setUPDATE_ALLOWED(boolean update_allowed) {
		UPDATE_ALLOWED = update_allowed;
	}

	public boolean isDELETE_ALLOWED() {
		return DELETE_ALLOWED;
	}

	public void setDELETE_ALLOWED(boolean delete_allowed) {
		DELETE_ALLOWED = delete_allowed;
	}

	public String nextIconAction() {
		String value = compositeAction.callMedicalExamDetails();
		compositeAction.getTabbedBar().gotoNextTab();
		compositeAction.getTabbedBar().setTabClicked(4);
		return value;
	}

	public String lastIconAction() {
		String value = compositeAction.callMedicalExamDetails();
		compositeAction.getTabbedBar().gotoLastTab();
		compositeAction.getTabbedBar().setTabClicked(4);
		return value;
	}

	public String firstIconAction() {
		String value = compositeAction.callTreatyMaster();
		compositeAction.getTabbedBar().gotoFirstTab();
		compositeAction.getTabbedBar().setTabClicked(1);
		return value;
	}

	public String previousIconAction() {
		String value = compositeAction.callTreatyType();
		compositeAction.getTabbedBar().gotoPrevTab();
		compositeAction.getTabbedBar().setTabClicked(2);
		return value;
	}

	public void save() {
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record Saved Successfully!");
			getWarningMap().put("current", "Record Saved Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
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
	
	public void onPageLoad(PhaseEvent event) {
		try{
			if(!onPageLoad) {
				fetchHeightWeightList();
				setOnPageLoad(true);
			}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	public void AddRow(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){		
				PM_IL_HTWT_DTL_BEAN = new PM_IL_HTWT_DTL();
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
	public String deleteRow(ActionEvent ae) {
		try{
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_HTWT_DTL bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataTableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataTableList.size();) {
				bean = dataTableList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
					dataTableList.remove(bean);
					deletedRecordIndex = pm_il_htwt_dtl_delegate
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if(dataTableList.size() > 0) {
					setPM_IL_HTWT_DTL_BEAN(dataTableList.get(0));
					PM_IL_HTWT_DTL_BEAN.setRowSelected(true);
			} else {
				AddRow(ae);
			}
			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current",
						+deletedRecordList.size() + "Record Deleted ");
			}
			lastUpdatedRowIndex = -1;
		}
		resetAllComponent();
		resetSelectedRow();
		PM_IL_HTWT_DTL_BEAN.setRowSelected(true);	
		}catch(Exception exception){
		}
		return "";
	}
	
	public void post(ActionEvent ae) {
		try{
			if(PM_IL_HTWT_DTL_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					pm_il_htwt_dtl_helper.preUpdateTrigger(this.PM_IL_HTWT_DTL_BEAN);
					new CRUDHandler().executeInsert(PM_IL_HTWT_DTL_BEAN, commonUtils.getConnection());
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
					pm_il_htwt_dtl_helper.PILM015_APAC_PM_IL_HTWT_DTL_PRE_INSERT(compositeAction);
					new CRUDHandler().executeInsert(PM_IL_HTWT_DTL_BEAN, commonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					dataTableList.add(PM_IL_HTWT_DTL_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_HTWT_DTL_BEAN.setRowSelected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {				
				PM_IL_HTWT_DTL_BEAN = (PM_IL_HTWT_DTL) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_HTWT_DTL_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_HTWT_EFF_FM_DT.resetValue();
		COMP_HTWT_EFF_TO_DT.resetValue();
		COMP_HTWT_HEIGHT_FM.resetValue();
		COMP_HTWT_HEIGHT_TO.resetValue();
		COMP_HTWT_WEIGHT_FM.resetValue();
		COMP_HTWT_WEIGHT_TO.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_HTWT_DTL> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public String getFilterByHTWT_HEIGHT_FM() {
		return filterByHTWT_HEIGHT_FM;
	}

	public void setFilterByHTWT_HEIGHT_FM(String filterByHTWT_HEIGHT_FM) {
		this.filterByHTWT_HEIGHT_FM = filterByHTWT_HEIGHT_FM;
	}

	public String getFilterByHTWT_HEIGHT_TO() {
		return filterByHTWT_HEIGHT_TO;
	}

	public void setFilterByHTWT_HEIGHT_TO(String filterByHTWT_HEIGHT_TO) {
		this.filterByHTWT_HEIGHT_TO = filterByHTWT_HEIGHT_TO;
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

	public PM_IL_HTWT_DTL getPM_IL_HTWT_DTL_BEAN() {
		return PM_IL_HTWT_DTL_BEAN;
	}

	public void setPM_IL_HTWT_DTL_BEAN(PM_IL_HTWT_DTL pm_il_htwt_dtl_bean) {
		PM_IL_HTWT_DTL_BEAN = pm_il_htwt_dtl_bean;
	}
}
