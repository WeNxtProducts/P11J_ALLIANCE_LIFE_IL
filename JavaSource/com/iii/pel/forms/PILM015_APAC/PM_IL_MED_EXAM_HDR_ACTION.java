package com.iii.pel.forms.PILM015_APAC;

import java.sql.SQLException;
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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

/**
 * Class Contains all the actions performed and setter and getter methods of
 * components.
 * 
 * @author Rajesh Kundala,Id-50180
 * 
 */
public class PM_IL_MED_EXAM_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_MEH_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_MEH_FRZ_FLAG;

	private HtmlOutputLabel COMP_MEH_SUM_ASSURED_FM_LABEL;

	private HtmlInputText COMP_MEH_SUM_ASSURED_FM;

	private HtmlOutputLabel COMP_MEH_SUM_ASSURED_TO_LABEL;

	private HtmlInputText COMP_MEH_SUM_ASSURED_TO;

	private HtmlOutputLabel COMP_MEH_AGE_FM_LABEL;

	private HtmlInputText COMP_MEH_AGE_FM;

	private HtmlOutputLabel COMP_MEH_AGE_TO_LABEL;

	private HtmlInputText COMP_MEH_AGE_TO;

	private PM_IL_MED_EXAM_HDR PM_IL_MED_EXAM_HDR_BEAN;

	private UIData dataTable;

	private ArrayList<PM_IL_MED_EXAM_HDR> medicalExamList;

	private int prevRowIndex;

	private int currentpage;

	private int recordsperPage = 5;

	private int lastUpdateRowIndex;

	int currentRowIndex;

	List resultList;

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

	PM_IL_PROP_TREATY_DELEGATE pm_il_prop_treaty_delegate;
	boolean checkBoxStatus;

	PM_IL_MED_EXAM_HELPER pm_il_med_exam_helper;

	PM_IL_PROP_TREATY_HELPER pm_il_prop_treaty_helper;
	
	//filters
	private String filterBySUM_ASSURED_TO;
	
	private String filterBySUM_ASSURED_FM;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private HtmlAjaxCommandButton UI_M_BUT_FETCH;
	
	CommonUtils commonUtils =new CommonUtils() ;
	
	private int lastUpdatedRowIndex;
	
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;

	/**
	 * Constructor Used For Initialisation Of variables.
	 * 
	 */
	public PM_IL_MED_EXAM_HDR_ACTION() {
		PM_IL_MED_EXAM_HDR_BEAN = new PM_IL_MED_EXAM_HDR();
		medicalExamList = new ArrayList<PM_IL_MED_EXAM_HDR>();
		pm_il_prop_treaty_delegate = new PM_IL_PROP_TREATY_DELEGATE();
		pm_il_med_exam_helper = new PM_IL_MED_EXAM_HELPER();
		prevRowIndex = 0;
		currentpage = 1;
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
		PM_IL_MED_EXAM_HDR gridValueBean = null;
		System.out.println(lastUpdateRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdateRowIndex != -1) {
				if (lastUpdateRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");

						gridValueBean = (PM_IL_MED_EXAM_HDR) medicalExamList
								.get(prevRowIndex);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {
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
							gridValueBean.setMEH_PT_SYS_ID(PT_SYS_ID);
							rowUpdated = pm_il_prop_treaty_delegate
									.updateData(gridValueBean);
							getWarningMap().put("current", "Updated");
						} else {

							double sysId = pm_il_prop_treaty_delegate
									.preInsertValidation();
							System.out.println("New Sys Id :-" + sysId);
							gridValueBean.setMEH_SYS_ID(sysId);

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
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}

		return;
	}*/
	// Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]

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
		PM_IL_MED_EXAM_HDR gridValueBean = null;
		try {
			gridValueBean = (PM_IL_MED_EXAM_HDR) medicalExamList.get(currRowIndex);
			if (gridValueBean.getROWID() != null) {
				pm_il_med_exam_helper.medExamHeaderPreUpdate(compositeAction, gridValueBean);
				pm_il_prop_treaty_delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Updated");
			} else {
				pm_il_med_exam_helper.medExamHeaderPreInsert(compositeAction, gridValueBean);
				pm_il_prop_treaty_delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Inserted");
			}
			lastUpdateRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}

	/**
	 * Adds a new row in Grid/Table.
	 * 
	 * @return
	 */
/*	public String addNew() {

		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		int rowCount = 0;

		if (medicalExamList == null) {
			medicalExamList = new ArrayList<PM_IL_MED_EXAM_HDR>();
		}
		medicalExamList.add(new PM_IL_MED_EXAM_HDR());

		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currentpage = rowCount / recordsperPage;
		if (rowCount % recordsperPage > 0) {
			currentpage++;
		}

		return "newadded";
	}*/
	
	public void addNew(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){		
				PM_IL_MED_EXAM_HDR_BEAN = new PM_IL_MED_EXAM_HDR();
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
			if(PM_IL_MED_EXAM_HDR_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					pm_il_med_exam_helper.medExamHeaderPreUpdate(compositeAction, this.PM_IL_MED_EXAM_HDR_BEAN);
					new CRUDHandler().executeInsert(PM_IL_MED_EXAM_HDR_BEAN, commonUtils.getConnection());
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
					pm_il_med_exam_helper.medExamHeaderPreInsert(compositeAction, this.PM_IL_MED_EXAM_HDR_BEAN);
					new CRUDHandler().executeInsert(PM_IL_MED_EXAM_HDR_BEAN, commonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					medicalExamList.add(PM_IL_MED_EXAM_HDR_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_MED_EXAM_HDR_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	
	/*public String deleteRow() {

		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		System.out.println("-----hi------");
		PM_IL_MED_EXAM_HDR bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (medicalExamList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < medicalExamList.size();) {
				bean = medicalExamList.get(index);
				if (bean.isCheck()) {
					medicalExamList.remove(bean);
					deletedRecordIndex = pm_il_prop_treaty_delegate
					.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}

			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current",
						+deletedRecordList.size() + "Records Deleted");
			}
			lastUpdateRowIndex = -1;

		}

		return "";
	}*/
	
	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String deleteRow(ActionEvent ae) throws Exception {
		try{
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_MED_EXAM_HDR bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (medicalExamList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < medicalExamList.size();) {
				bean = medicalExamList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
					medicalExamList.remove(bean);
					deletedRecordIndex = pm_il_prop_treaty_delegate
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			if(medicalExamList.size() > 0) {
					setPM_IL_MED_EXAM_HDR_BEAN(medicalExamList.get(0));
					PM_IL_MED_EXAM_HDR_BEAN.setRowSelected(true);
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
		PM_IL_MED_EXAM_HDR_BEAN.setRowSelected(true);	
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
		return "";
	}

	/**
	 * Used To get Current Value
	 * 
	 * @param event
	 * @return
	 */
	private String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null && !input.equals("")) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	/**
	 * Used To fetch Details into Medical Exam Details
	 * 
	 * @return
	 */
	public String fetchDetailsButton() {
		int checkCount = 0;
		String returnValue = null;
		PM_IL_MED_EXAM_HDR selectedMedHeaderBean = null;
		CommonUtils commonUtils = new CommonUtils();
		for(PM_IL_MED_EXAM_HDR tempBean : medicalExamList) {
			if (tempBean != null) {
				selectedMedHeaderBean = tempBean;
				if("dataTableSelectedRow".equalsIgnoreCase(selectedMedHeaderBean.getRowSelected())){
					compositeAction.getPM_IL_MED_EXAM_DTL_ACTION().setHeaderBean(selectedMedHeaderBean);
					returnValue = "medicalDetail";
				}
			}
		}
		return returnValue;
	}
	public void saveData() {
		try {
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	/* Medical Examination Validations */

	public void setFreez(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		String currentValue = getCurrentValue(actionEvent);
		PM_IL_MED_EXAM_HDR hdrBean = this.PM_IL_MED_EXAM_HDR_BEAN;
		hdrBean.setMEH_FRZ_FLAG(currentValue);
	}

	public void saFromActionListener(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		this.PM_IL_MED_EXAM_HDR_BEAN.setMEH_SUM_ASSURED_FM(CommonUtils.parseToDouble(getCurrentValue(event)));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void saFromWhenValidate(FacesContext context, UIComponent component,
			Object value)  {
		PM_IL_MED_EXAM_HDR medHeadBean = this.PM_IL_MED_EXAM_HDR_BEAN;
		try {
			pm_il_med_exam_helper.SA_ASSURED_FROM(medHeadBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void ageFromActionListener(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		this.PM_IL_MED_EXAM_HDR_BEAN.setMEH_AGE_FM(CommonUtils.parseToInt(getCurrentValue(event)));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void ageFromValidation(FacesContext context, UIComponent component,
			Object value)  {
		PM_IL_MED_EXAM_HDR medHeadBean = this.PM_IL_MED_EXAM_HDR_BEAN;
		try {
			pm_il_med_exam_helper.AGE_FROM(medHeadBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void saToActionListener(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		this.PM_IL_MED_EXAM_HDR_BEAN.setMEH_SUM_ASSURED_TO(CommonUtils.parseToDouble(getCurrentValue(event)));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void saToWhenValidate(FacesContext context, UIComponent component,
			Object value){
		PM_IL_MED_EXAM_HDR medHeadBean = this.PM_IL_MED_EXAM_HDR_BEAN;
		try {
			pm_il_med_exam_helper.SA_ASSURED_TO_WHEN_VALIDATE(medHeadBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void ageToActionListener(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		this.PM_IL_MED_EXAM_HDR_BEAN.setMEH_AGE_TO(CommonUtils.parseToInt(getCurrentValue(event)));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void ageToWhenValidate(FacesContext context, UIComponent component,
			Object value) {
		PM_IL_MED_EXAM_HDR medHeadBean = this.PM_IL_MED_EXAM_HDR_BEAN;
		try {
			pm_il_med_exam_helper.AGE_TO_WHEN_VALIDATE_ITEM(medHeadBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void selectedCheckbox(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String currentValue = getCurrentValue(event);
		int rowIndex = dataTable.getRowIndex();
		PM_IL_MED_EXAM_HDR hdrBean = medicalExamList.get(rowIndex);
		hdrBean.setCheck(Boolean.parseBoolean(currentValue));
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PM_IL_MED_EXAM_HDR> getMedicalExamList() {
		return medicalExamList;
	}

	public void setMedicalExamList(ArrayList<PM_IL_MED_EXAM_HDR> medicalExamList) {
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

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public HtmlOutputLabel getCOMP_MEH_FRZ_FLAG_LABEL() {
		return COMP_MEH_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_MEH_FRZ_FLAG() {

		return COMP_MEH_FRZ_FLAG;
	}

	public void setCOMP_MEH_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_MEH_FRZ_FLAG_LABEL) {

		this.COMP_MEH_FRZ_FLAG_LABEL = COMP_MEH_FRZ_FLAG_LABEL;
	}

	public void setCOMP_MEH_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_MEH_FRZ_FLAG) {

		this.COMP_MEH_FRZ_FLAG = COMP_MEH_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_MEH_SUM_ASSURED_FM_LABEL() {
		return COMP_MEH_SUM_ASSURED_FM_LABEL;
	}

	public HtmlInputText getCOMP_MEH_SUM_ASSURED_FM() {
		return COMP_MEH_SUM_ASSURED_FM;
	}

	public void setCOMP_MEH_SUM_ASSURED_FM_LABEL(
			HtmlOutputLabel COMP_MEH_SUM_ASSURED_FM_LABEL) {
		this.COMP_MEH_SUM_ASSURED_FM_LABEL = COMP_MEH_SUM_ASSURED_FM_LABEL;
	}

	public void setCOMP_MEH_SUM_ASSURED_FM(HtmlInputText COMP_MEH_SUM_ASSURED_FM) {
		this.COMP_MEH_SUM_ASSURED_FM = COMP_MEH_SUM_ASSURED_FM;
	}

	public HtmlOutputLabel getCOMP_MEH_SUM_ASSURED_TO_LABEL() {
		return COMP_MEH_SUM_ASSURED_TO_LABEL;
	}

	public HtmlInputText getCOMP_MEH_SUM_ASSURED_TO() {
		return COMP_MEH_SUM_ASSURED_TO;
	}

	public void setCOMP_MEH_SUM_ASSURED_TO_LABEL(
			HtmlOutputLabel COMP_MEH_SUM_ASSURED_TO_LABEL) {
		this.COMP_MEH_SUM_ASSURED_TO_LABEL = COMP_MEH_SUM_ASSURED_TO_LABEL;
	}

	public void setCOMP_MEH_SUM_ASSURED_TO(HtmlInputText COMP_MEH_SUM_ASSURED_TO) {
		this.COMP_MEH_SUM_ASSURED_TO = COMP_MEH_SUM_ASSURED_TO;
	}

	public HtmlOutputLabel getCOMP_MEH_AGE_FM_LABEL() {
		return COMP_MEH_AGE_FM_LABEL;
	}

	public HtmlInputText getCOMP_MEH_AGE_FM() {
		return COMP_MEH_AGE_FM;
	}

	public void setCOMP_MEH_AGE_FM_LABEL(HtmlOutputLabel COMP_MEH_AGE_FM_LABEL) {
		this.COMP_MEH_AGE_FM_LABEL = COMP_MEH_AGE_FM_LABEL;
	}

	public void setCOMP_MEH_AGE_FM(HtmlInputText COMP_MEH_AGE_FM) {
		this.COMP_MEH_AGE_FM = COMP_MEH_AGE_FM;
	}

	public HtmlOutputLabel getCOMP_MEH_AGE_TO_LABEL() {
		return COMP_MEH_AGE_TO_LABEL;
	}

	public HtmlInputText getCOMP_MEH_AGE_TO() {
		return COMP_MEH_AGE_TO;
	}

	public void setCOMP_MEH_AGE_TO_LABEL(HtmlOutputLabel COMP_MEH_AGE_TO_LABEL) {
		this.COMP_MEH_AGE_TO_LABEL = COMP_MEH_AGE_TO_LABEL;
	}

	public void setCOMP_MEH_AGE_TO(HtmlInputText COMP_MEH_AGE_TO) {
		this.COMP_MEH_AGE_TO = COMP_MEH_AGE_TO;
	}

	public PM_IL_MED_EXAM_HDR getPM_IL_MED_EXAM_HDR_BEAN() {
		return PM_IL_MED_EXAM_HDR_BEAN;
	}

	public void setPM_IL_MED_EXAM_HDR_BEAN(
			PM_IL_MED_EXAM_HDR PM_IL_MED_EXAM_HDR_BEAN) {
		this.PM_IL_MED_EXAM_HDR_BEAN = PM_IL_MED_EXAM_HDR_BEAN;
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
			if (medicalExamList.size() != 0) {				
				PM_IL_MED_EXAM_HDR_BEAN = (PM_IL_MED_EXAM_HDR) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_MED_EXAM_HDR_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_MEH_AGE_FM.resetValue();
		COMP_MEH_AGE_TO.resetValue();
		COMP_MEH_SUM_ASSURED_FM.resetValue();
		COMP_MEH_SUM_ASSURED_TO.resetValue();
		COMP_MEH_FRZ_FLAG.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_MED_EXAM_HDR> iterator = medicalExamList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String onPageLoad() {
		PM_IL_MED_EXAM_DELEGATE delegate = new PM_IL_MED_EXAM_DELEGATE();

		setMedicalExamList(delegate.fetchMedExamHdrList(compositeAction));
		
		Iterator<PM_IL_MED_EXAM_HDR> iterator = medicalExamList.iterator();
		while(iterator.hasNext()){
			PM_IL_MED_EXAM_HDR_BEAN = iterator.next();
			PM_IL_MED_EXAM_HDR_BEAN.setRowSelected(false);
		}
		
		if (medicalExamList.size() !=0){					
			setPM_IL_MED_EXAM_HDR_BEAN(medicalExamList.get(0));
			getPM_IL_MED_EXAM_HDR_BEAN().setRowSelected(true);
		}
		
		return "MedicalExamHeader";
	}

	public String getFilterBySUM_ASSURED_TO() {
		return filterBySUM_ASSURED_TO;
	}

	public void setFilterBySUM_ASSURED_TO(String filterBySUM_ASSURED_TO) {
		this.filterBySUM_ASSURED_TO = filterBySUM_ASSURED_TO;
	}

	public String getFilterBySUM_ASSURED_FM() {
		return filterBySUM_ASSURED_FM;
	}

	public void setFilterBySUM_ASSURED_FM(String filterBySUM_ASSURED_FM) {
		this.filterBySUM_ASSURED_FM = filterBySUM_ASSURED_FM;
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

	public HtmlAjaxCommandButton getUI_M_BUT_FETCH() {
		return UI_M_BUT_FETCH;
	}

	public void setUI_M_BUT_FETCH(HtmlAjaxCommandButton ui_m_but_fetch) {
		UI_M_BUT_FETCH = ui_m_but_fetch;
	}


}
