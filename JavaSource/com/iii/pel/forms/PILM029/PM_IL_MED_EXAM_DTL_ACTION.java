package com.iii.pel.forms.PILM029;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_MED_EXAM_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_MED_EXAM_CODE_LABEL;

	private HtmlInputText COMP_MED_EXAM_CODE;

	private HtmlOutputLabel COMP_UI_M_MED_EXAM_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MED_EXAM_CODE_DESC;
	
	private HtmlCommandButton COMP_UI_M_MAIN;

	private PM_IL_MED_EXAM_DTL PM_IL_MED_EXAM_DTL_BEAN;

	private UIData dataTable;

	private List<PM_IL_MED_EXAM_DTL> medicalExamList;

	private List codeList = new ArrayList();

	private int prevRowIndex;

	private int currentpage;

	private int recordsperPage = 5;

	private int lastUpdateRowIndex;

	ArrayList deletedIndexList;

	List resultList;

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

	PM_IL_MED_EXAM_DELEGATE pm_il_med_exam_delegate;

	PM_IL_MED_EXAM_HELPER pm_il_med_exam_helper;
	
	private int currPage;
	
	public String main() {
		return "PILM029_PM_IL_MED_EXAM_HDR";
	}

	private PM_IL_MED_EXAM_HDR tempHeaderBean;
	
	PM_IL_MED_EXAM_COMPOSITE_ACTION compositeAction;
	
	String filterByMED_EXAM_CODE;
	String filterByMED_EXAM_CODE_DESC;
	ControlBean controlBean = CommonUtils.getControlBean();

	/**
	 * 
	 * Constructor For Medical Examination Details,Used For Initialisation
	 * 
	 */
	public PM_IL_MED_EXAM_DTL_ACTION() {

		PM_IL_MED_EXAM_DTL_BEAN = new PM_IL_MED_EXAM_DTL();
		pm_il_med_exam_helper = new PM_IL_MED_EXAM_HELPER();
		medicalExamList = new ArrayList<PM_IL_MED_EXAM_DTL>();
		deletedIndexList = new ArrayList();
		pm_il_med_exam_delegate = new PM_IL_MED_EXAM_DELEGATE();
		prevRowIndex = 0;
		currentpage = 1;

	}

	/**
	 * Grid Tab Listener is used to update Component Values.
	 */
	public void gridtabListener() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_MED_EXAM_DTL gridValueBean = null;
		System.out.println(lastUpdateRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdateRowIndex != -1) {
				if (lastUpdateRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PM_IL_MED_EXAM_DTL) medicalExamList
								.get(prevRowIndex);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {

							rowUpdated = pm_il_med_exam_delegate
									.updateData(gridValueBean);
							getWarningMap().put("current", "Record Updated");
						} else {

							rowUpdated = pm_il_med_exam_delegate
									.updateData(gridValueBean);
							getWarningMap().put("current", "Record Inserted");

						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		return;
	}

	/**
	 * Used For inserting & Updating Values after Tabbing out of last column
	 */
	public void lastColumnListener() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_MED_EXAM_DTL gridValueBean = null;
		CommonUtils commonUtils = new CommonUtils();
		ControlBean controlBean = CommonUtils.getControlBean();
		try {

			// Get the bean based on row index
			gridValueBean = (PM_IL_MED_EXAM_DTL) medicalExamList
					.get(currRowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {

				gridValueBean.setMED_UPD_DT(commonUtils.getCurrentDate());
				gridValueBean.setMED_UPD_UID(controlBean.getM_USER_ID());

				rowUpdated = pm_il_med_exam_delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Updated");
			} else {
				Map sessionmap = FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap();
				PM_IL_MED_EXAM_COMPOSITE_ACTION compAction = (PM_IL_MED_EXAM_COMPOSITE_ACTION) sessionmap
						.get("PM_IL_MED_EXAM_COMPOSITE_ACTION");
				PM_IL_MED_EXAM_HDR_ACTION hdrAction = compAction
						.getPM_IL_MED_EXAM_HDR_ACTION();
				PM_IL_MED_EXAM_HDR hdrBean = hdrAction
						.getPM_IL_MED_EXAM_HDR_BEAN();
				double sysid = hdrBean.getMEH_SYS_ID();
				gridValueBean.setMED_MEH_SYS_ID(sysid);
				gridValueBean.setMED_CR_DT(commonUtils.getCurrentDate());
				gridValueBean.setMED_CR_UID(controlBean.getM_USER_ID());;
				PM_IL_MED_EXAM_DTL_BEAN.setMED_EXAM_CODE(gridValueBean
						.getMED_EXAM_CODE());
				rowUpdated = pm_il_med_exam_delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Inserted");
			}
			lastUpdateRowIndex = currRowIndex;

		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}
		return;
	}

	/**
	 * Adds a new row in Grid/Table.
	 * 
	 * @return
	 */
	public String addNew() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		int rowCount = 0;
		if (medicalExamList == null) {
			medicalExamList = new ArrayList<PM_IL_MED_EXAM_DTL>();
		}

		medicalExamList.add(new PM_IL_MED_EXAM_DTL());
		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currentpage = rowCount / recordsperPage;
		if (rowCount % recordsperPage > 0) {
			currentpage++;
		}

		return "newadded";
	}

	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */
	public String deleteRow() {
		System.out.println("IN THE DELETE" + medicalExamList);
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_MED_EXAM_DTL bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (medicalExamList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < medicalExamList.size();) {
				bean = medicalExamList.get(index);
				System.out.println("bean selected:::");

				if (bean.isSelected()) {
					System.out.println("Inside Loop");
					medicalExamList.remove(bean);
					deletedRecordIndex = pm_il_med_exam_delegate
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}

			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current", "Record Deleted");
			}
			lastUpdateRowIndex = -1;

		}

		return "";
	}

	/**
	 * Used for getting list of values for Medical Exam Code
	 * 
	 * @param obj
	 * @return
	 */
	public List suggestionActionForMedDtl(Object obj) {
		System.out.println("IN THE LOV*****************");
		String code = (String) obj;

		codeList = new PM_IL_MED_EXAM_DELEGATE().suggestionActionForMedDet(
				code, codeList);
		return codeList;
	}

	/**
	 * Used for getting list of values for Medical Exam Description
	 * 
	 * @param event
	 */
	public void getCodeDesc(ActionEvent event) {
		CommonUtils.clearMaps(this);
		COMP_UI_M_MED_EXAM_CODE_DESC.setSubmittedValue(null);
		System.out.println("<--------hi----->");
		if (COMP_MED_EXAM_CODE.getSubmittedValue() != null) {
			String code = (String) COMP_MED_EXAM_CODE.getSubmittedValue();
			String codeDesc = pm_il_med_exam_delegate.getCodeDesc(code,
					codeList);
			COMP_UI_M_MED_EXAM_CODE_DESC.setSubmittedValue(codeDesc);

		}
	}

	/**
	 * Used for inserting Records into Database
	 */
	public void saveData() {
		getWarningMap().clear();
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
			getWarningMap().put("Save",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Gets Current Value which is present in the Grid Component
	 * 
	 * @param event
	 * @return
	 */

	public String getCurrentValue(ActionEvent event) {
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

	/*
	 * public String getCurrentValue(FacesContext context, UIComponent
	 * component, Object value) { String value1 = null; UIInput input = null;
	 * 
	 * if (event != null) { System.out.println("event>>>>>>>> " + event);
	 * System.out.println("event>>>>>>>> " + event.getComponent());
	 * System.out.println("Input class is >>>>>>>>> " +
	 * event.getComponent().getParent()); input = (UIInput)
	 * event.getComponent().getParent(); if (input != null) { value = (String)
	 * input.getSubmittedValue(); System.out.println("VALUE ************" +
	 * value); if (medicalExamList != null && medicalExamList.size() > 1) {
	 * 
	 * Iterator iterator = medicalExamList.iterator(); while
	 * (iterator.hasNext()) { PM_IL_MED_EXAM_DTL userBean = (PM_IL_MED_EXAM_DTL)
	 * iterator .next(); if (userBean.getMED_EXAM_CODE().equals(value)) {
	 * System.out.println("VALUE IS AVAILABLE"); //
	 * input.setSubmittedValue(null); } else { System.out.println("Value is not
	 * available"); } } } } } gridtabListener(); return value; }
	 */

	/**
	 * Used For Updating and Inserting the values in Medical Exam Code Field
	 * 
	 * @param actionEvent
	 */

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void codeValidations(FacesContext facesContext,
			UIComponent component, Object value){
		
		PM_IL_MED_EXAM_DTL_BEAN.setMED_EXAM_CODE((String)value);
		try{
			pm_il_med_exam_helper.codeWhenValidate(PM_IL_MED_EXAM_DTL_BEAN.getMED_EXAM_CODE());
			pm_il_med_exam_helper.L_VALIDATE_DTL_RANGE(PM_IL_MED_EXAM_DTL_BEAN.getMED_EXAM_CODE());
			COMP_UI_M_MED_EXAM_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(
						CommonUtils.getConnection(), 
						facesContext,component.getId(),
						getWarningMap());
			} catch (DBException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
	}

	
	public void codeDescValidation(FacesContext context,UIComponent component,Object value){
		
		if(COMP_UI_M_MED_EXAM_CODE_DESC.getSubmittedValue()!= null){
			
			String codeDesc = (String) COMP_UI_M_MED_EXAM_CODE_DESC.getSubmittedValue();
			int rowIndex = getDataTable().getRowIndex();
			PM_IL_MED_EXAM_DTL pm_il_med_exam_dtl = this.getMedicalExamList()
			.get(rowIndex);
			pm_il_med_exam_dtl.setUI_M_MED_EXAM_CODE_DESC(codeDesc);
		}
		
		
	}
	

	public void selectedCheckbox(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();

		String selected = (String) (input.getSubmittedValue());
		int row = dataTable.getRowIndex();
		Integer integer = new Integer(row);
		if ("true".equalsIgnoreCase(selected)) {
			if (!selectedList.contains(integer)) {
				selectedList.add(row);
			}
		} else {
			if (selectedList.contains(integer)) {
				selectedList.remove(integer);
			}
		}

		PM_IL_MED_EXAM_DTL pm_il_med_exam_dtl = medicalExamList.get(row);

		if (selected.equals("true"))
			pm_il_med_exam_dtl.setSelected(true);
		else
			pm_il_med_exam_dtl.setSelected(false);
		System.out.println("SELETED LIST" + selectedList);
	}

	public HtmlOutputLabel getCOMP_MED_EXAM_CODE_LABEL() {
		return COMP_MED_EXAM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MED_EXAM_CODE() {
		return COMP_MED_EXAM_CODE;
	}

	public void setCOMP_MED_EXAM_CODE_LABEL(
			HtmlOutputLabel COMP_MED_EXAM_CODE_LABEL) {
		this.COMP_MED_EXAM_CODE_LABEL = COMP_MED_EXAM_CODE_LABEL;
	}

	public void setCOMP_MED_EXAM_CODE(HtmlInputText COMP_MED_EXAM_CODE) {
		this.COMP_MED_EXAM_CODE = COMP_MED_EXAM_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_MED_EXAM_CODE_DESC_LABEL() {
		return COMP_UI_M_MED_EXAM_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MED_EXAM_CODE_DESC() {
		return COMP_UI_M_MED_EXAM_CODE_DESC;
	}

	public void setCOMP_UI_M_MED_EXAM_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_MED_EXAM_CODE_DESC_LABEL) {
		this.COMP_UI_M_MED_EXAM_CODE_DESC_LABEL = COMP_UI_M_MED_EXAM_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_MED_EXAM_CODE_DESC(
			HtmlInputText COMP_UI_M_MED_EXAM_CODE_DESC) {
		this.COMP_UI_M_MED_EXAM_CODE_DESC = COMP_UI_M_MED_EXAM_CODE_DESC;
	}

	public PM_IL_MED_EXAM_DTL getPM_IL_MED_EXAM_DTL_BEAN() {
		return PM_IL_MED_EXAM_DTL_BEAN;
	}

	public void setPM_IL_MED_EXAM_DTL_BEAN(
			PM_IL_MED_EXAM_DTL PM_IL_MED_EXAM_DTL_BEAN) {
		this.PM_IL_MED_EXAM_DTL_BEAN = PM_IL_MED_EXAM_DTL_BEAN;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<PM_IL_MED_EXAM_DTL> getMedicalExamList() {
		return medicalExamList;
	}

	public void setMedicalExamList(List<PM_IL_MED_EXAM_DTL> medicalExamList) {
		this.medicalExamList = medicalExamList;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getRecordsperPage() {
		return recordsperPage;
	}

	public void setRecordsperPage(int recordsperPage) {
		this.recordsperPage = recordsperPage;
	}

	public int getLastUpdateRowIndex() {
		return lastUpdateRowIndex;
	}

	public void setLastUpdateRowIndex(int lastUpdateRowIndex) {
		this.lastUpdateRowIndex = lastUpdateRowIndex;
	}

	public ArrayList getDeletedIndexList() {
		return deletedIndexList;
	}

	public void setDeletedIndexList(ArrayList deletedIndexList) {
		this.deletedIndexList = deletedIndexList;
	}

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public List getCodeList() {
		return codeList;
	}

	public void setCodeList(List codeList) {
		this.codeList = codeList;
	}

	public String backToHeader() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		return "MedicalHeader";
	}

	public String callDetails() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		PM_IL_MED_EXAM_COMPOSITE_ACTION composite = (PM_IL_MED_EXAM_COMPOSITE_ACTION) session
				.getAttribute("PM_IL_MED_EXAM_COMPOSITE_ACTION");
		double sysId = composite.getPM_IL_MED_EXAM_HDR_ACTION()
				.getPM_IL_MED_EXAM_HDR_BEAN().getMEH_SYS_ID();
		System.out.println("$$$$$$$$$$$$$$$$$$" + sysId);
		return "medicalDetail";
	}

	public void getDetails() {
		CommonUtils.clearMaps(this);
		try {
			if (medicalExamList.size() != 0) {				
				PM_IL_MED_EXAM_DTL_BEAN = (PM_IL_MED_EXAM_DTL) dataTable.getRowData();
			}	
			resetAllComponents();			
			resetSelectedRow();
			PM_IL_MED_EXAM_DTL_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PM_IL_MED_EXAM_HDR getTempHeaderBean() {
		return tempHeaderBean;
	}

	public void setTempHeaderBean(PM_IL_MED_EXAM_HDR tempHeaderBean) {
		this.tempHeaderBean = tempHeaderBean;
	}

	public ArrayList<Integer> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Integer> selectedList) {
		this.selectedList = selectedList;
	}
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 
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
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String getFilterByMED_EXAM_CODE() {
		return filterByMED_EXAM_CODE;
	}

	public void setFilterByMED_EXAM_CODE(String filterByMED_EXAM_CODE) {
		this.filterByMED_EXAM_CODE = filterByMED_EXAM_CODE;
	}

	public String getFilterByMED_EXAM_CODE_DESC() {
		return filterByMED_EXAM_CODE_DESC;
	}

	public void setFilterByMED_EXAM_CODE_DESC(String filterByMED_EXAM_CODE_DESC) {
		this.filterByMED_EXAM_CODE_DESC = filterByMED_EXAM_CODE_DESC;
	}
	
	public void addRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_IL_MED_EXAM_DTL_BEAN = new PM_IL_MED_EXAM_DTL();
				resetAllComponents();
				resetSelectedRow();
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
	
	public String post() {
		try{
			if(PM_IL_MED_EXAM_DTL_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					PRE_UPDATE();
					new CRUDHandler().executeInsert(PM_IL_MED_EXAM_DTL_BEAN, CommonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$Grid$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$Grid$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {

				if(isINSERT_ALLOWED()) {
					
					PRE_INSERT();
					new CRUDHandler().executeInsert(PM_IL_MED_EXAM_DTL_BEAN, CommonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					
					medicalExamList.add(PM_IL_MED_EXAM_DTL_BEAN);
					
					resetSelectedRow();
					PM_IL_MED_EXAM_DTL_BEAN.setRowSelected(true); 
					
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
		return null;
	}
	
	private void PRE_UPDATE() throws Exception {
		// TODO Auto-generated method stub
		PM_IL_MED_EXAM_DTL_BEAN.setMED_UPD_DT(new CommonUtils().getCurrentDate());
		PM_IL_MED_EXAM_DTL_BEAN.setMED_UPD_UID(controlBean.getM_USER_ID());
		
	}

	private void PRE_INSERT() throws Exception {
		// TODO Auto-generated method stub
		PM_IL_MED_EXAM_DTL_BEAN.setMED_CR_DT(new CommonUtils().getCurrentDate());
		PM_IL_MED_EXAM_DTL_BEAN.setMED_CR_UID(controlBean.getM_USER_ID());
		PM_IL_MED_EXAM_DTL_BEAN.setMED_MEH_SYS_ID(compositeAction.getPM_IL_MED_EXAM_HDR_ACTION().getPM_IL_MED_EXAM_HDR_BEAN().getMEH_SYS_ID());
		pm_il_med_exam_helper.L_VALIDATE_DTL_RANGE(PM_IL_MED_EXAM_DTL_BEAN.getMED_EXAM_CODE());
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_MED_EXAM_DTL> iterator = medicalExamList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	public String deleteRow(ActionEvent ae) {

		try {
			pm_il_med_exam_delegate.deleteData(PM_IL_MED_EXAM_DTL_BEAN);
			getWarningMap().put(
					"deleteRow",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
			medicalExamList.remove(PM_IL_MED_EXAM_DTL_BEAN);
			if (medicalExamList.size() > 0) {

				PM_IL_MED_EXAM_DTL_BEAN = medicalExamList.get(0);
			} else if (medicalExamList.size() == 0) {

				addRow(null);
			}
			resetAllComponents();
			PM_IL_MED_EXAM_DTL_BEAN.setRowSelected(true);

		} catch (Exception exception) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exception.getMessage());
			getErrorMap().put("deleteRow", exception.getMessage());
		}
		return "";
	}
	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				enableDisableBtnUsingSysParam("IL_MED_CALC");
				pm_il_med_exam_helper.executeQuery(compositeAction);
				if(compositeAction.getPM_IL_MED_EXAM_DTL_ACTION().getPM_IL_MED_EXAM_DTL_BEAN().getROWID()!=null){
					pm_il_med_exam_helper.postQuery(compositeAction);
				}
				setBlockFlag(false);
				PM_IL_MED_EXAM_DTL_BEAN.setRowSelected(true);
				
				/*ADDED BY RAJA ON 17-03-2017 FOR SSP CALL ID - ZBILQC-1717895*/
				resetAllComponents();
				
				/*end*/
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	private void resetAllComponents() {
		// TODO Auto-generated method stub
		COMP_MED_EXAM_CODE.resetValue();
		COMP_UI_M_MED_EXAM_CODE_DESC.resetValue();
		
		/*added by R. Raja on 15-12-2016 for RM018T - FSD_IL_ZB Life_017-Medical Report Validity Period*/ 
		
		COMP_MED_VAL_PERD.resetValue();
		COMP_MED_CON_MTH.resetValue();
		
		/*end*/
		/* Added by ganesh on 02-06-2017, ZBILQC-1719236 suggested by Arunkumar G */
		COMP_MEDL_SUM_ASSURED_FM.resetValue();
		COMP_MEDL_SUM_ASSURED_TO.resetValue();
		/*end*/
	}

	public HtmlCommandButton getCOMP_UI_M_MAIN() {
		return COMP_UI_M_MAIN;
	}

	public void setCOMP_UI_M_MAIN(HtmlCommandButton comp_ui_m_main) {
		COMP_UI_M_MAIN = comp_ui_m_main;
	}

	
	/*added by R. Raja on 15-12-2016 for RM018T - FSD_IL_ZB Life_017-Medical Report Validity Period*/ 
	
	private HtmlOutputLabel COMP_MED_VAL_PERD_LABEL;
	
	private HtmlInputText COMP_MED_VAL_PERD;
	
	private HtmlOutputLabel COMP_MED_CON_MTH_LABEL;
	
	public HtmlOutputLabel getCOMP_MED_VAL_PERD_LABEL() {
		return COMP_MED_VAL_PERD_LABEL;
	}

	public void setCOMP_MED_VAL_PERD_LABEL(HtmlOutputLabel cOMP_MED_VAL_PERD_LABEL) {
		COMP_MED_VAL_PERD_LABEL = cOMP_MED_VAL_PERD_LABEL;
	}

	public HtmlInputText getCOMP_MED_VAL_PERD() {
		return COMP_MED_VAL_PERD;
	}

	public void setCOMP_MED_VAL_PERD(HtmlInputText cOMP_MED_VAL_PERD) {
		COMP_MED_VAL_PERD = cOMP_MED_VAL_PERD;
	}

	public HtmlOutputLabel getCOMP_MED_CON_MTH_LABEL() {
		return COMP_MED_CON_MTH_LABEL;
	}

	public void setCOMP_MED_CON_MTH_LABEL(HtmlOutputLabel cOMP_MED_CON_MTH_LABEL) {
		COMP_MED_CON_MTH_LABEL = cOMP_MED_CON_MTH_LABEL;
	}

	public HtmlInputText getCOMP_MED_CON_MTH() {
		return COMP_MED_CON_MTH;
	}

	public void setCOMP_MED_CON_MTH(HtmlInputText cOMP_MED_CON_MTH) {
		COMP_MED_CON_MTH = cOMP_MED_CON_MTH;
	}

	private HtmlInputText COMP_MED_CON_MTH;
	
	/*end*/
	
	/* Added by ganesh on 02-06-2017, ZBILQC-1719236 suggested by Arunkumar G */
	private HtmlInputText COMP_MEDL_SUM_ASSURED_FM;
	private HtmlInputText COMP_MEDL_SUM_ASSURED_TO;
	
	public HtmlInputText getCOMP_MEDL_SUM_ASSURED_FM() {
		return COMP_MEDL_SUM_ASSURED_FM;
	}

	public void setCOMP_MEDL_SUM_ASSURED_FM(HtmlInputText cOMP_MEDL_SUM_ASSURED_FM) {
		COMP_MEDL_SUM_ASSURED_FM = cOMP_MEDL_SUM_ASSURED_FM;
	}

	public HtmlInputText getCOMP_MEDL_SUM_ASSURED_TO() {
		return COMP_MEDL_SUM_ASSURED_TO;
	}

	public void setCOMP_MEDL_SUM_ASSURED_TO(HtmlInputText cOMP_MEDL_SUM_ASSURED_TO) {
		COMP_MEDL_SUM_ASSURED_TO = cOMP_MEDL_SUM_ASSURED_TO;
	}

	
	
	/*end*/

	/*Added by ganesh on 20-06-2017, ZBILQC-1719236 */
	public void enableDisableBtnUsingSysParam(String sysParam){
		
		try {
			int sysParamValue = ((BigDecimal)CommonUtils.getPPSystemParameterValue(sysParam)).intValue();
			
			if(sysParam.equalsIgnoreCase("IL_MED_CALC")){
				
				if(sysParamValue == 1){					
								
					COMP_MEDL_SUM_ASSURED_FM_PANELGRP.setRendered(true);
					COMP_MEDL_SUM_ASSURED_TO_PANELGRP.setRendered(true);
				}else{
					COMP_MEDL_SUM_ASSURED_FM_PANELGRP.setRendered(false);
					COMP_MEDL_SUM_ASSURED_TO_PANELGRP.setRendered(false);
				}
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private HtmlPanelGroup COMP_MEDL_SUM_ASSURED_FM_PANELGRP;

	public HtmlPanelGroup getCOMP_MEDL_SUM_ASSURED_FM_PANELGRP() {
		return COMP_MEDL_SUM_ASSURED_FM_PANELGRP;
	}

	public void setCOMP_MEDL_SUM_ASSURED_FM_PANELGRP(
			HtmlPanelGroup cOMP_MEDL_SUM_ASSURED_FM_PANELGRP) {
		COMP_MEDL_SUM_ASSURED_FM_PANELGRP = cOMP_MEDL_SUM_ASSURED_FM_PANELGRP;
	}
	
	private HtmlPanelGroup COMP_MEDL_SUM_ASSURED_TO_PANELGRP;

	public HtmlPanelGroup getCOMP_MEDL_SUM_ASSURED_TO_PANELGRP() {
		return COMP_MEDL_SUM_ASSURED_TO_PANELGRP;
	}

	public void setCOMP_MEDL_SUM_ASSURED_TO_PANELGRP(
			HtmlPanelGroup cOMP_MEDL_SUM_ASSURED_TO_PANELGRP) {
		COMP_MEDL_SUM_ASSURED_TO_PANELGRP = cOMP_MEDL_SUM_ASSURED_TO_PANELGRP;
	}
	
	
	/*end*/
	
	
}
