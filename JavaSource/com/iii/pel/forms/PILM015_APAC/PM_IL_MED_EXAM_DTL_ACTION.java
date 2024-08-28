package com.iii.pel.forms.PILM015_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author Rajesh Kundala Id-50180
 */

public class PM_IL_MED_EXAM_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_MED_EXAM_CODE_LABEL;

	private HtmlInputText COMP_MED_EXAM_CODE;

	private HtmlOutputLabel COMP_UI_M_MED_EXAM_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MED_EXAM_CODE_DESC;

	private UIData dataTable;

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

	private ArrayList<PM_IL_MED_EXAM_DTL> medicalExamDtlsList;

	private List codeList = new ArrayList();

	private int prevRowIndex;

	private int currentpage;

	private int recordsperPage = 5;

	private int lastUpdateRowIndex;

	ArrayList deletedIndexList;

	PM_IL_PROP_TREATY_DELEGATE pm_il_prop_treaty_delegate;

	private PM_IL_MED_EXAM_HDR headerBean;
	
	private PM_IL_MED_EXAM_DTL PM_IL_MED_EXAM_DTL_BEAN;
	
	private PM_IL_MED_EXAM_HELPER helper;
	
	private int lastUpdatedRowIndex;
	
	//filters
	private String filterByMED_EXAM_CODE_DESC;
	
	private String filterByMED_EXAM_CODE;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	CommonUtils commonUtils =new CommonUtils() ;
	
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;

	/**
	 * 
	 * Constructor For Medical Examination Details,Used For Initialisation
	 * 
	 */
	public PM_IL_MED_EXAM_DTL_ACTION() {
		deletedIndexList = new ArrayList();
		pm_il_prop_treaty_delegate = new PM_IL_PROP_TREATY_DELEGATE();
		PM_IL_MED_EXAM_DTL_BEAN = new PM_IL_MED_EXAM_DTL();
		helper = new PM_IL_MED_EXAM_HELPER();
		prevRowIndex = 0;
		currentpage = 1;
	}

	public Map<String, Object> getSessionMap() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	// [ Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
	/**
	 * Grid Tab Listener is used to update Component Values.
	 */
	/*public void gridtabListener() {
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
							rowUpdated = pm_il_prop_treaty_delegate
									.updateData(gridValueBean);
							getWarningMap().put("current", "Updated");
						} else {

							rowUpdated = pm_il_prop_treaty_delegate
									.updateData(gridValueBean);
							getWarningMap().put("current", "Inserted");

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
	}*/
	// Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]

	/**
	 * Used For inserting & Updating Values after Tabbing out of last column
	 * @throws Exception 
	 */
	public void lastColumnListener() throws Exception {
		int currRowIndex = getDataTable().getRowIndex();
		PM_IL_MED_EXAM_DTL gridValueBean = null;
		PM_IL_MED_EXAM_HELPER helper = new PM_IL_MED_EXAM_HELPER();
		try {
			gridValueBean = (PM_IL_MED_EXAM_DTL) medicalExamDtlsList
					.get(currRowIndex);
			if (gridValueBean.getROWID() != null) {
				helper.medExamDtlPreUpdate(gridValueBean);
				pm_il_prop_treaty_delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Updated");
			} else {
				helper.medExamDtlPreInsert(compositeAction.getPM_IL_MED_EXAM_HDR_ACTION().getPM_IL_MED_EXAM_HDR_BEAN(), 
						gridValueBean);
				pm_il_prop_treaty_delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Inserted");

			}
			lastUpdateRowIndex = currRowIndex;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return;
	}

	/**
	 * Adds a new row in Grid/Table.
	 * 
	 * @return
	 */
	/*public String addNew() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		int rowCount = 0;
		if (medicalExamDtlsList == null) {
			medicalExamDtlsList = new ArrayList<PM_IL_MED_EXAM_DTL>();
		}

		medicalExamDtlsList.add(new PM_IL_MED_EXAM_DTL());

		rowCount = getDataTable().getRowCount();
		currentpage = rowCount / recordsperPage;
		if (rowCount % recordsperPage > 0) {
			currentpage++;
		}

		return "newadded";
	}
*/
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
		PM_IL_MED_EXAM_DTL bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (medicalExamDtlsList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < medicalExamDtlsList.size();) {
				bean = medicalExamDtlsList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
					medicalExamDtlsList.remove(bean);
					deletedRecordIndex = pm_il_prop_treaty_delegate
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if(medicalExamDtlsList.size() > 0) {
					setPM_IL_MED_EXAM_DTL_BEAN(medicalExamDtlsList.get(0));
					PM_IL_MED_EXAM_DTL_BEAN.setRowSelected(true);
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
		PM_IL_MED_EXAM_DTL_BEAN.setRowSelected(true);	
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
		return "";
	}

	/**
	 * Used for getting list of values for Medical Exam Code
	 * 
	 * @param obj
	 * @return
	 * @throws Exception 
	 */
	public List suggestionActionForMedDtl(Object obj) throws Exception {
		try {
			String code = (String) obj;
			codeList = new PM_IL_PROP_TREATY_DELEGATE().suggestionActionForMedDet(code);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return codeList;
	}

	/**
	 * Used for getting list of values for Medical Exam Description
	 * 
	 * @param event
	 */
	public void getCodeDesc(ActionEvent event) {
		COMP_UI_M_MED_EXAM_CODE_DESC.setSubmittedValue(null);
		PM_IL_PROP_TREATY_DELEGATE pm_il_prop_treaty_delegate = new PM_IL_PROP_TREATY_DELEGATE();
		if (COMP_MED_EXAM_CODE.getSubmittedValue() != null) {
			String code = (String) COMP_MED_EXAM_CODE.getSubmittedValue();
			String codeDesc = pm_il_prop_treaty_delegate.getCodeDesc(code,
					codeList);
			COMP_UI_M_MED_EXAM_CODE_DESC.setSubmittedValue(codeDesc);
		}
	}

	public void saveData() {
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put("current", "Record Saved");
			getWarningMap().put("CURRENT", "Record Saved");
		} catch (Exception e) {
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
			}
		}
		return value;
	}

	public void medExamCodeActionListener(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		this.PM_IL_MED_EXAM_DTL_BEAN.setMED_EXAM_CODE(getCurrentValue(event));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void codeValidations(FacesContext facesContext,
			UIComponent component, Object value)  {
		PM_IL_MED_EXAM_HELPER helper = new PM_IL_MED_EXAM_HELPER();
		try {
			PM_IL_MED_EXAM_DTL_BEAN.setMED_EXAM_CODE((String)value);
			helper.medExamCodeWhenValidateItem(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void selectedCheckbox(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		int index = getDataTable().getRowIndex();
		medicalExamDtlsList.get(index).setCheck(Boolean.parseBoolean(getCurrentValue(event)));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * Used For Updating and Inserting the values in Medical Exam Code Field
	 * 
	 * @param actionEvent
	 */
	public void codeValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent()
				.getParent();
		String value = (String) inputText.getSubmittedValue();
		if (value == null || value.trim().isEmpty()) {
		} else {
			this.PM_IL_MED_EXAM_DTL_BEAN.setMED_EXAM_CODE((value));
		}
	}

	public void codeDescValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		getCurrentValue(actionEvent);
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent()
				.getParent();
		String value = (String) inputText.getSubmittedValue();
		if (value == null || value.trim().isEmpty()) {
		} else {
			this.PM_IL_MED_EXAM_DTL_BEAN.setUI_M_MED_EXAM_CODE_DESC((value));
		}
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

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PM_IL_MED_EXAM_DTL> getMedicalExamDtlsList() {
		return medicalExamDtlsList;
	}

	public void setMedicalExamDtlsList(ArrayList<PM_IL_MED_EXAM_DTL> medicalExamDtlsList) {
		this.medicalExamDtlsList = medicalExamDtlsList;
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

	public PM_IL_PROP_TREATY_DELEGATE getPm_il_prop_treaty_delegate() {
		return pm_il_prop_treaty_delegate;
	}

	public void setPm_il_prop_treaty_delegate(
			PM_IL_PROP_TREATY_DELEGATE pm_il_prop_treaty_delegate) {
		this.pm_il_prop_treaty_delegate = pm_il_prop_treaty_delegate;
	}

	public List getCodeList() {
		return codeList;
	}

	public void setCodeList(List codeList) {
		this.codeList = codeList;
	}

	public String backToHeader() {

		return "medicalHeader";
	}

	public PM_IL_MED_EXAM_HDR getHeaderBean() {
		return headerBean;
	}

	public void setHeaderBean(PM_IL_MED_EXAM_HDR headerBean) {
		this.headerBean = headerBean;
	}

	public ArrayList<Integer> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Integer> selectedList) {
		this.selectedList = selectedList;
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
	
	private void executeQuery() {
		PM_IL_MED_EXAM_DELEGATE delegate = new PM_IL_MED_EXAM_DELEGATE();
		PM_IL_MED_EXAM_HELPER helper = new PM_IL_MED_EXAM_HELPER();
		setMedicalExamDtlsList(delegate.fetchMedExamDtlsList(getHeaderBean()));
		Iterator<PM_IL_MED_EXAM_DTL> iterator = medicalExamDtlsList.iterator();
		while(iterator.hasNext()){
			PM_IL_MED_EXAM_DTL_BEAN = iterator.next();
			PM_IL_MED_EXAM_DTL_BEAN.setRowSelected(false);
		}
		if (medicalExamDtlsList.size() !=0){					
			setPM_IL_MED_EXAM_DTL_BEAN(medicalExamDtlsList.get(0));
			getPM_IL_MED_EXAM_DTL_BEAN().setRowSelected(true);
		}
		for(PM_IL_MED_EXAM_DTL dtlsBean : getMedicalExamDtlsList()) {
			try {
				helper.medExamDtlsPostQuery(this, dtlsBean);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current", e.getMessage());
				getErrorMap().put("detail", e.getMessage());
			}
		}
	}
	
	public void onLoad(PhaseEvent event) {
		if(isBlockFlag()){
			executeQuery();
			setBlockFlag(false);
		}
		
	}
	
	public void addNew(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){		
				PM_IL_MED_EXAM_DTL_BEAN = new PM_IL_MED_EXAM_DTL();
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
	
	public void post(ActionEvent ae) {
		try{
			if(PM_IL_MED_EXAM_DTL_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {

					helper.medExamDtlPreInsert(compositeAction.getPM_IL_MED_EXAM_HDR_ACTION().getPM_IL_MED_EXAM_HDR_BEAN(),
							this.PM_IL_MED_EXAM_DTL_BEAN);
					new CRUDHandler().executeInsert(PM_IL_MED_EXAM_DTL_BEAN, commonUtils.getConnection());
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
					helper.medExamDtlPreInsert(compositeAction.getPM_IL_MED_EXAM_HDR_ACTION().getPM_IL_MED_EXAM_HDR_BEAN(),
							this.PM_IL_MED_EXAM_DTL_BEAN);
					new CRUDHandler().executeInsert(PM_IL_MED_EXAM_DTL_BEAN, commonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					medicalExamDtlsList.add(PM_IL_MED_EXAM_DTL_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_MED_EXAM_DTL_BEAN.setRowSelected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	public void getDetails() {
		try {
			if (medicalExamDtlsList.size() != 0) {				
				PM_IL_MED_EXAM_DTL_BEAN = (PM_IL_MED_EXAM_DTL) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_MED_EXAM_DTL_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_MED_EXAM_CODE.resetValue();
		COMP_UI_M_MED_EXAM_CODE_DESC.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_MED_EXAM_DTL> iterator = medicalExamDtlsList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public String preBack()
	{
		String actionClass = "PM_IL_MED_EXAM_HDR_ACTION";
		String actionMethod = "onPageLoad";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
		System.out.println("** Return String :*"+"medicalHeader");
		return "medicalHeader";
	}

	public String getFilterByMED_EXAM_CODE_DESC() {
		return filterByMED_EXAM_CODE_DESC;
	}

	public void setFilterByMED_EXAM_CODE_DESC(String filterByMED_EXAM_CODE_DESC) {
		this.filterByMED_EXAM_CODE_DESC = filterByMED_EXAM_CODE_DESC;
	}

	public String getFilterByMED_EXAM_CODE() {
		return filterByMED_EXAM_CODE;
	}

	public void setFilterByMED_EXAM_CODE(String filterByMED_EXAM_CODE) {
		this.filterByMED_EXAM_CODE = filterByMED_EXAM_CODE;
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

	public PM_IL_MED_EXAM_DTL getPM_IL_MED_EXAM_DTL_BEAN() {
		return PM_IL_MED_EXAM_DTL_BEAN;
	}

	public void setPM_IL_MED_EXAM_DTL_BEAN(
			PM_IL_MED_EXAM_DTL pm_il_med_exam_dtl_bean) {
		PM_IL_MED_EXAM_DTL_BEAN = pm_il_med_exam_dtl_bean;
	}
}
