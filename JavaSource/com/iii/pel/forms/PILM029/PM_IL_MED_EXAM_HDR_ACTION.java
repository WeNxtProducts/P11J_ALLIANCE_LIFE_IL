package com.iii.pel.forms.PILM029;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_MED_EXAM_HDR_ACTION extends CommonAction {
	
	private static Log LOG = LogFactory.getLog(PM_IL_MED_EXAM_HDR_ACTION.class);  
	
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
	
	private HtmlOutputLabel COMP_MEH_PROD_CODE_FM_LABEL; 
	
	private HtmlInputText COMP_MEH_PROD_CODE_FM;
	
	private HtmlOutputLabel COMP_MEH_PROD_CODE_TO_LABEL;
	
	private HtmlInputText COMP_MEH_PROD_CODE_TO;
	
	

	private PM_IL_MED_EXAM_HDR PM_IL_MED_EXAM_HDR_BEAN;
	
	CommonUtils commonUtils =new CommonUtils() ;
	private UIData dataTable;

	private ArrayList<PM_IL_MED_EXAM_HDR> medicalExamList;

	private int prevRowIndex;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private int currentpage;

	private int recordsperPage = 10;

	private int lastUpdateRowIndex;

	ArrayList deletedIndexList;

	int currentRowIndex;
	
	PM_IL_MED_EXAM_COMPOSITE_ACTION compositeAction;
	
	//filters
	private String filterBySUBASSURED_FROM;
	private String filterBySUBASSURED_TO;
	private String filterByAGE_FROM;
	private String filterByAGE_TO;
	private String filterByPROD_CODE_FM;
	private String filterByPROD_CODE_TO;

	List resultList;

	PM_IL_MED_EXAM_DELEGATE pm_il_med_exam_delegate;

	PM_IL_MED_EXAM_HELPER pm_il_med_exam_helper;

	private boolean INSERT_ALLOWED = true;

	private boolean UPDATE_ALLOWED = true;

	private boolean DELETE_ALLOWED = true;
	
	ControlBean controlBean = CommonUtils.getControlBean();

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

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

	/**
	 * Constructor Used For Initialisation Of variables.
	 * 
	 */
	public PM_IL_MED_EXAM_HDR_ACTION() {
		
		PM_IL_MED_EXAM_HDR_BEAN = new PM_IL_MED_EXAM_HDR();
		deletedIndexList = new ArrayList();
		medicalExamList = new ArrayList<PM_IL_MED_EXAM_HDR>();
		pm_il_med_exam_delegate = new PM_IL_MED_EXAM_DELEGATE();
		pm_il_med_exam_helper = new PM_IL_MED_EXAM_HELPER();
		resultList = new ArrayList();
		/*try {
			resultList = pm_il_med_exam_delegate.getValuesForHeader();
			for (int index = 0; index < resultList.size(); index++) {
				PM_IL_MED_EXAM_HDR gridValueBean = (PM_IL_MED_EXAM_HDR) resultList
						.get(index);
				medicalExamList.add(gridValueBean);
			}
	
			Iterator<PM_IL_MED_EXAM_HDR> iterator = medicalExamList.iterator();
			while(iterator.hasNext()){
				PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr = iterator.next();
				pm_il_med_exam_hdr.setRowSelected(false);
			}
			

			if (medicalExamList.size() > 0) {
				PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr = (PM_IL_MED_EXAM_HDR)medicalExamList.get(0);
				pm_il_med_exam_hdr.setRowSelected(true);
				setPM_IL_MED_EXAM_HDR_BEAN(pm_il_med_exam_hdr);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		prevRowIndex = 0;
		currentpage = 1;
	}
	
	/**
	 * Used For inserting & Updating Values after Tabbing out of last column
	 */
	public void lastColumnListener()  {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_MED_EXAM_HDR gridValueBean = null;
		ControlBean controlBean = CommonUtils.getControlBean();
		try {
			// Get the bean based on row index
			gridValueBean = (PM_IL_MED_EXAM_HDR) medicalExamList
					.get(currRowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {
//				pm_il_med_exam_helper.L_VALIDATE_RANGE(gridValueBean);
				gridValueBean.setMEH_UPD_DT(new CommonUtils().getCurrentDate());
				gridValueBean.setMEH_UPD_UID(controlBean.getM_USER_ID());
				rowUpdated = pm_il_med_exam_delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Updated Successfully");
			} else {
				gridValueBean.setMEH_CR_DT(new CommonUtils().getCurrentDate());
				gridValueBean.setMEH_CR_UID(controlBean.getM_USER_ID());
				Long sysId = pm_il_med_exam_delegate.preInsertValidation();
				gridValueBean.setMEH_SYS_ID(sysId);
				System.out.println("New SysId------>" + sysId);
//				pm_il_med_exam_helper.L_VALIDATE_RANGE(gridValueBean);
				rowUpdated = pm_il_med_exam_delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Inserted Successfully");
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
	public String addNew() {
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
		PM_IL_MED_EXAM_HDR bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		
		if (medicalExamList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < medicalExamList.size();) {
				bean = medicalExamList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
					medicalExamList.remove(bean);
					deletedRecordIndex = pm_il_med_exam_delegate
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}
			if(medicalExamList.size() > 0) {
				   PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr = medicalExamList.get(0);
				   pm_il_med_exam_hdr.setRowSelected(true);
   			 	   setPM_IL_MED_EXAM_HDR_BEAN(pm_il_med_exam_hdr);
			} else {
				AddRow(ae);
			}
			if (deletedRecordList.size() > 0) {
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$Grid$delete"));
				
				

			}
			lastUpdateRowIndex = -1;

		}
		resetAllComponent();
		}catch(Exception exception){
		}
		return "";
	}

	/**
	 * Inserts Values Into DataBase
	 */
	public void insertValues() {

		pm_il_med_exam_delegate = new PM_IL_MED_EXAM_DELEGATE();
		pm_il_med_exam_delegate.insertValuesForMedHeader(this);
		getWarningMap().put("current", "Record Inserted");

	}

	/**
	 * Used To get Current Value
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

	/**
	 * Used To fetch Details into Medical Exam Details
	 * 
	 * @return
	 */
	public String fetchDetailsButton() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		String name = "";
		for (int i = 0; i < medicalExamList.size(); i++) {

			PM_IL_MED_EXAM_HDR tempName = new PM_IL_MED_EXAM_HDR();
			tempName = medicalExamList.get(i);
			System.out.println("Element Selected----->" + tempName);
			if (tempName != null && tempName.isSelected()) {
				PM_IL_MED_EXAM_HDR_BEAN = medicalExamList.get(i);

				CommonUtils commonUtils = new CommonUtils();

				CRUDHandler handler = new CRUDHandler();
				String selectQuery = "SELECT PC.*, ROWID AS PC_ROWID "
						+ " FROM PM_IL_MED_EXAM_DTL PC "
						+ "WHERE PC.MED_MEH_SYS_ID ='"
						+ PM_IL_MED_EXAM_HDR_BEAN.getMEH_SYS_ID() + "'";

				try {
					/*
					 * Map sessionmap = FacesContext.getCurrentInstance()
					 * .getExternalContext().getSessionMap();
					 * PM_IL_MED_EXAM_COMPOSITE_ACTION compAction =
					 * (PM_IL_MED_EXAM_COMPOSITE_ACTION) sessionmap
					 * .get("PM_IL_MED_EXAM_COMPOSITE_ACTION");
					 */
					PM_IL_MED_EXAM_COMPOSITE_ACTION compAction = (PM_IL_MED_EXAM_COMPOSITE_ACTION) new CommonUtils()
							.getMappedBeanFromSession("PM_IL_MED_EXAM_COMPOSITE_ACTION");
					compAction.getPM_IL_MED_EXAM_DTL_ACTION()
							.setTempHeaderBean(PM_IL_MED_EXAM_HDR_BEAN);
					compAction.getPM_IL_MED_EXAM_DTL_ACTION()
							.setMedicalExamList(getList(selectQuery));
					pm_il_med_exam_helper.postQuery(compAction);

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Selected Item is -------->   " + i);
				name = "medicalDetail";
				return name;

			} else {
				name = "";
			}
		}
		return name;

	}

	/**
	 * Gets the List of Records Related to a particular parent record
	 * 
	 * @param query
	 * @return
	 */
	public List<PM_IL_MED_EXAM_DTL> getList(String query) {
		List<PM_IL_MED_EXAM_DTL> arrayList = new ArrayList<PM_IL_MED_EXAM_DTL>();
		try {
			CommonUtils commonUtils = new CommonUtils();
			Connection connection = commonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PM_IL_MED_EXAM_DTL pm_il_med_exam_dtl = new PM_IL_MED_EXAM_DTL();
				pm_il_med_exam_dtl.setMED_EXAM_CODE(resultSet
						.getString("MED_EXAM_CODE"));
				pm_il_med_exam_dtl.setROWID(resultSet.getString("PC_ROWID"));
				pm_il_med_exam_dtl.setMED_CR_DT(resultSet.getDate("MED_CR_DT"));
				pm_il_med_exam_dtl.setMED_CR_UID(resultSet
						.getString("MED_CR_UID"));
				pm_il_med_exam_dtl.setMED_UPD_DT(resultSet
						.getDate("MED_UPD_DT"));
				pm_il_med_exam_dtl.setMED_UPD_UID(resultSet
						.getString("MED_UPD_UID"));
				pm_il_med_exam_dtl.setMED_MEH_SYS_ID(resultSet
						.getDouble("MED_MEH_SYS_ID"));
				arrayList.add(pm_il_med_exam_dtl);

			}
			/*
			 * arrayList = handler.fetch(query,
			 * "com.iii.pel.forms.PILM029.PM_IL_MED_EXAM_DTL", connection);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	public void saveData() {
		getWarningMap().clear();
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
			getWarningMap().put("Save",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public void post(ActionEvent ae) {
	try {

	    if (PM_IL_MED_EXAM_HDR_BEAN.getROWID() != null) {
		if (isUPDATE_ALLOWED()) {
		    PRE_UPDATE();
		    new CRUDHandler().executeInsert(PM_IL_MED_EXAM_HDR_BEAN,
			    commonUtils.getConnection());
		    getWarningMap().put(
			    PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			    Messages.getString(
				    PELConstants.pelMessagePropertiesPath,
				    "errorPanel$message$Grid$update"));
		    getWarningMap().put(
			    "post",
			    Messages.getString(
				    PELConstants.pelMessagePropertiesPath,
				    "errorPanel$message$Grid$update"));
		} else {
		    getErrorMap().clear();
		    getWarningMap().put(
			    PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			    Messages.getString(
				    PELConstants.pelMessagePropertiesPath,
				    "errorPanel$message$updatenotallowed"));
		    getWarningMap().put(
			    "post",
			    Messages.getString(
				    PELConstants.pelMessagePropertiesPath,
				    "errorPanel$message$updatenotallowed"));
		}
	    } else {

		if (isINSERT_ALLOWED()) {
		    PRE_INSERT();
		    new CRUDHandler().executeInsert(PM_IL_MED_EXAM_HDR_BEAN,
			    commonUtils.getConnection());
		    getWarningMap().put(
			    PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			    Messages.getString(
				    PELConstants.pelMessagePropertiesPath,
				    "errorPanel$message$insert"));
		    getWarningMap().put(
			    "post",
			    Messages.getString(
				    PELConstants.pelMessagePropertiesPath,
				    "errorPanel$message$insert"));

		    medicalExamList.add(PM_IL_MED_EXAM_HDR_BEAN);

		    resetSelectedRow();
		    PM_IL_MED_EXAM_HDR_BEAN.setRowSelected(true);

		} else {
		    getErrorMap().clear();
		    getWarningMap().put(
			    PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			    Messages.getString(
				    PELConstants.pelMessagePropertiesPath,
				    "errorPanel$message$insertnotallowed"));
		    getWarningMap().put(
			    "post",
			    Messages.getString(
				    PELConstants.pelMessagePropertiesPath,
				    "errorPanel$message$insertnotallowed"));
		}
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("post", e.getMessage());
	}
    }

	/* Medical Examination Validations */

	private void PRE_UPDATE()throws Exception {
			// TODO Auto-generated method stub
		if(PM_IL_MED_EXAM_HDR_BEAN.getMEH_PROD_CODE_FM()==null ||
				"".equals(PM_IL_MED_EXAM_HDR_BEAN.getMEH_PROD_CODE_FM()))
			PM_IL_MED_EXAM_HDR_BEAN.setMEH_PROD_CODE_FM("0");
		
		if(PM_IL_MED_EXAM_HDR_BEAN.getMEH_PROD_CODE_TO()==null ||
				"".equals(PM_IL_MED_EXAM_HDR_BEAN.getMEH_PROD_CODE_TO()))
			PM_IL_MED_EXAM_HDR_BEAN.setMEH_PROD_CODE_TO("zzzzzzzzzzzz");
		
		PM_IL_MED_EXAM_HDR_BEAN.setMEH_UPD_DT(new CommonUtils().getCurrentDate());
		PM_IL_MED_EXAM_HDR_BEAN.setMEH_UPD_UID(controlBean.getM_USER_ID());
		
	}
	
	private void PRE_INSERT()throws Exception {
	pm_il_med_exam_delegate = new PM_IL_MED_EXAM_DELEGATE();
	Long sysId = pm_il_med_exam_delegate.preInsertValidationHdr(PM_IL_MED_EXAM_HDR_BEAN);
	if(PM_IL_MED_EXAM_HDR_BEAN.getMEH_PROD_CODE_FM()==null ||
			"".equals(PM_IL_MED_EXAM_HDR_BEAN.getMEH_PROD_CODE_FM()))
		PM_IL_MED_EXAM_HDR_BEAN.setMEH_PROD_CODE_FM("0");
	
	if(PM_IL_MED_EXAM_HDR_BEAN.getMEH_PROD_CODE_TO()==null ||
			"".equals(PM_IL_MED_EXAM_HDR_BEAN.getMEH_PROD_CODE_TO()))
		PM_IL_MED_EXAM_HDR_BEAN.setMEH_PROD_CODE_TO("zzzzzzzzzzzz");
	
	PM_IL_MED_EXAM_HDR_BEAN.setMEH_CR_DT(new CommonUtils().getCurrentDate());
	PM_IL_MED_EXAM_HDR_BEAN.setMEH_CR_UID(controlBean.getM_USER_ID());
	PM_IL_MED_EXAM_HDR_BEAN.setMEH_SYS_ID(sysId);
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void productCode_FM_ActionListener(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();

		try {
			String value = (String)input.getSubmittedValue();

			if(value==null || value.equals("")){
				getPM_IL_MED_EXAM_HDR_BEAN().setMEH_PROD_CODE_FM("0");
				COMP_MEH_PROD_CODE_FM.resetValue();
			}
//			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception e) {
			getWarningMap().put("CUST_CLASS", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void productCode_To_ActionListener(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();

		try {
			String value = (String)input.getSubmittedValue();

			if(value==null || value.equals("")){
				getPM_IL_MED_EXAM_HDR_BEAN().setMEH_PROD_CODE_TO("zzzzzzzzzzzz");
				COMP_MEH_PROD_CODE_TO.resetValue();
			}
//			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception e) {
			getWarningMap().put("CUST_CLASS", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			e.printStackTrace();
		}
	}


	public void setFreez(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		String currentValue = getCurrentValue(actionEvent);
		int rowIndex = dataTable.getRowIndex();
		PM_IL_MED_EXAM_HDR hdrBean = medicalExamList.get(rowIndex);
		hdrBean.setCheck(Boolean.parseBoolean(currentValue));
	}

	public void saFromWhenValidate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException ,SQLException,Exception{
		
			PM_IL_MED_EXAM_HDR_BEAN.setMEH_SUM_ASSURED_FM((Double)value);
			if ((COMP_MEH_SUM_ASSURED_FM.getSubmittedValue() != null)) {
		
				String sumValue = (String) COMP_MEH_SUM_ASSURED_FM
						.getSubmittedValue();
				System.out.println("Sum value in string is :" + sumValue);
				if (sumValue.startsWith("-")) {
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "333000"));
				}
			}
		}


	public void ageFromValidation(FacesContext context, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {

		PM_IL_MED_EXAM_HDR_BEAN.setMEH_AGE_FM((Integer)value);
		if ((COMP_MEH_AGE_FM.getSubmittedValue() != null)) {
			String sumValue = (String) COMP_MEH_AGE_FM.getSubmittedValue();
			if (sumValue.startsWith("-")) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "333000"));
			}
		}
	}

	public void saToWhenValidate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException,SQLException,Exception {

			PM_IL_MED_EXAM_HDR_BEAN.setMEH_SUM_ASSURED_TO((Double)value);
			if ((COMP_MEH_SUM_ASSURED_FM.getSubmittedValue() != null)
					&& (COMP_MEH_SUM_ASSURED_TO.getSubmittedValue() != null)) {
				String sumValue = (String) COMP_MEH_SUM_ASSURED_TO
						.getSubmittedValue();
				if (sumValue.startsWith("-")) {
					throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "333000"));
				}
			}
			
			pm_il_med_exam_helper.SA_ASSURED_TO_WHEN_VALIDATE(PM_IL_MED_EXAM_HDR_BEAN.getMEH_SUM_ASSURED_FM(),
					PM_IL_MED_EXAM_HDR_BEAN.getMEH_SUM_ASSURED_TO(), this);
			
	}

	public void ageToWhenValidate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {

		PM_IL_MED_EXAM_HDR_BEAN.setMEH_AGE_TO((Integer)value);
		if ((COMP_MEH_AGE_TO.getSubmittedValue() != null)
				&& (COMP_MEH_AGE_FM.getSubmittedValue() != null)) {
			String sumValue = (String) COMP_MEH_AGE_TO.getSubmittedValue();
			if (sumValue.startsWith("-")) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "333000"));
				} 
			}
		pm_il_med_exam_helper.AGE_TO_WHEN_VALIDATE_ITEM(PM_IL_MED_EXAM_HDR_BEAN.getMEH_AGE_FM(), PM_IL_MED_EXAM_HDR_BEAN.getMEH_AGE_TO(),
				this);
		}

	public void freezeValidation(FacesContext context, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception {
		String value1 = null;

		if (COMP_MEH_FRZ_FLAG.isSelected()) {
			value1 = "Y";
		} else {
			value1 = "N";
		}

		int rowIndex = getDataTable().getRowIndex();
		PM_IL_MED_EXAM_HDR pm_il_med_exam_hdr = getMedicalExamList().get(
				rowIndex);
		pm_il_med_exam_hdr.setMEH_FRZ_FLAG(value1);
		//gridtabListener();
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
		PM_IL_MED_EXAM_HDR custBean = medicalExamList.get(row);
		if (selected.equals("true"))
			custBean.setSelected(true);
		else
			custBean.setSelected(false);
		System.out.println("SELETED LIST" + selectedList);
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

	public ArrayList getDeletedIndexList() {
		return deletedIndexList;
	}

	public void getDetails() {
		CommonUtils.clearMaps(this);
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
	
	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
		COMP_MEH_SUM_ASSURED_FM.resetValue();
		COMP_MEH_SUM_ASSURED_TO.resetValue();
		COMP_MEH_AGE_FM.resetValue();
		COMP_MEH_AGE_TO.resetValue();
		COMP_MEH_PROD_CODE_FM.resetValue();
		COMP_MEH_PROD_CODE_TO.resetValue();
		COMP_MEH_FRZ_FLAG.resetValue();
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_MED_EXAM_HDR> iterator = medicalExamList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
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

	public PM_IL_MED_EXAM_DELEGATE getPm_il_med_exam_delegate() {
		return pm_il_med_exam_delegate;
	}

	public void setPm_il_med_exam_delegate(
			PM_IL_MED_EXAM_DELEGATE pm_il_med_exam_delegate) {
		this.pm_il_med_exam_delegate = pm_il_med_exam_delegate;
	}

	public PM_IL_MED_EXAM_HELPER getPm_il_med_exam_helper() {
		return pm_il_med_exam_helper;
	}

	public void setPm_il_med_exam_helper(
			PM_IL_MED_EXAM_HELPER pm_il_med_exam_helper) {
		this.pm_il_med_exam_helper = pm_il_med_exam_helper;
	}

	/*
	 * public String fetchDetailsButtonPressed() { if (checkBoxStatus == true) {
	 * PM_IL_MED_EXAM_HDR_BEAN = medicalExamList.get(currentRowIndex);
	 * System.out.println("getSMV_SYS_ID() " +
	 * PM_IL_MED_EXAM_HDR_BEAN.getMEH_SYS_ID()); return "medicalDetail"; } else {
	 * return null; } }
	 */

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

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}
	
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_IL_MED_EXAM_HDR_BEAN = new PM_IL_MED_EXAM_HDR();
				PM_IL_MED_EXAM_HDR_BEAN.setMEH_FRZ_FLAG("N");
				resetAllComponent();
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

	public String getFilterBySUBASSURED_FROM() {
		return filterBySUBASSURED_FROM;
	}

	public void setFilterBySUBASSURED_FROM(String filterBySUBASSURED_FROM) {
		this.filterBySUBASSURED_FROM = filterBySUBASSURED_FROM;
	}

	public String getFilterBySUBASSURED_TO() {
		return filterBySUBASSURED_TO;
	}

	public void setFilterBySUBASSURED_TO(String filterBySUBASSURED_TO) {
		this.filterBySUBASSURED_TO = filterBySUBASSURED_TO;
	}

	public String getFilterByAGE_FROM() {
		return filterByAGE_FROM;
	}

	public void setFilterByAGE_FROM(String filterByAGE_FROM) {
		this.filterByAGE_FROM = filterByAGE_FROM;
	}

	public String getFilterByAGE_TO() {
		return filterByAGE_TO;
	}

	public void setFilterByAGE_TO(String filterByAGE_TO) {
		this.filterByAGE_TO = filterByAGE_TO;
	}

	public String getFilterByPROD_CODE_FM() {
		return filterByPROD_CODE_FM;
	}

	public void setFilterByPROD_CODE_FM(String filterByPROD_CODE_FM) {
		this.filterByPROD_CODE_FM = filterByPROD_CODE_FM;
	}

	public String getFilterByPROD_CODE_TO() {
		return filterByPROD_CODE_TO;
	}

	public void setFilterByPROD_CODE_TO(String filterByPROD_CODE_TO) {
		this.filterByPROD_CODE_TO = filterByPROD_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_MEH_PROD_CODE_FM_LABEL() {
		return COMP_MEH_PROD_CODE_FM_LABEL;
	}

	public void setCOMP_MEH_PROD_CODE_FM_LABEL(
			HtmlOutputLabel comp_meh_prod_code_fm_label) {
		COMP_MEH_PROD_CODE_FM_LABEL = comp_meh_prod_code_fm_label;
	}

	public HtmlInputText getCOMP_MEH_PROD_CODE_FM() {
		return COMP_MEH_PROD_CODE_FM;
	}

	public void setCOMP_MEH_PROD_CODE_FM(HtmlInputText comp_meh_prod_code_fm) {
		COMP_MEH_PROD_CODE_FM = comp_meh_prod_code_fm;
	}

	public HtmlOutputLabel getCOMP_MEH_PROD_CODE_TO_LABEL() {
		return COMP_MEH_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_MEH_PROD_CODE_TO_LABEL(
			HtmlOutputLabel comp_meh_prod_code_to_label) {
		COMP_MEH_PROD_CODE_TO_LABEL = comp_meh_prod_code_to_label;
	}

	public HtmlInputText getCOMP_MEH_PROD_CODE_TO() {
		return COMP_MEH_PROD_CODE_TO;
	}

	public void setCOMP_MEH_PROD_CODE_TO(HtmlInputText comp_meh_prod_code_to) {
		COMP_MEH_PROD_CODE_TO = comp_meh_prod_code_to;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				pm_il_med_exam_helper.executeHdrQuery(compositeAction);
				setBlockFlag(false);
			}
			PM_IL_MED_EXAM_HDR_BEAN.setRowSelected(true);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public List<LovBean> lovProdCode(Object obj) throws Exception {
			String prodCode = (String) obj;
			String PROD_CODE_LOV_QUERY = "SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE ROWNUM<=? ORDER BY 1";
			String PROD_CODE_LOV_QUERY_LIKE= "SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE (PROD_CODE LIKE ? OR PROD_DESC LIKE ?) ORDER BY 1";
			List<LovBean> suggestionList = null;
			Object[] object = {};
			String query = null;
			if ("*".equals(prodCode)) {
				object = new Object[] { PELConstants.suggetionRecordSize};
				query = PROD_CODE_LOV_QUERY;
			} else {
				object = new Object[] {
						"%"+prodCode + "%","%"+prodCode+"%" };
				query = PROD_CODE_LOV_QUERY_LIKE;
			}
			suggestionList = callLov(query,object);
			return suggestionList;
	}
	public List<LovBean> callLov(String query, Object[] obj) {
		List<LovBean> suggestionList = null;
		suggestionList = prepareLovList(query, obj);
		return suggestionList;
	}
	public List<LovBean> prepareLovList(String query, Object[] obj) {

		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
}
