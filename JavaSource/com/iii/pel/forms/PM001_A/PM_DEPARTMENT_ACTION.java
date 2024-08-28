package com.iii.pel.forms.PM001_A;

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
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;


public class PM_DEPARTMENT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DEPT_BL_NAME_LABEL;

	private HtmlInputText COMP_DEPT_BL_NAME;

	private HtmlOutputLabel COMP_DEPT_BL_SHORT_NAME_LABEL;

	private HtmlInputText COMP_DEPT_BL_SHORT_NAME;

	private HtmlOutputLabel COMP_DEPT_BL_MGR_NAME_LABEL;

	private HtmlInputText COMP_DEPT_BL_MGR_NAME;

	private HtmlOutputLabel COMP_DEPT_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_DEPT_FRZ_FLAG;

	private HtmlOutputLabel COMP_DEPT_CODE_LABEL;

	private HtmlInputText COMP_DEPT_CODE;

	private HtmlOutputLabel COMP_DEPT_NAME_LABEL;

	private HtmlInputText COMP_DEPT_NAME;

	private HtmlOutputLabel COMP_DEPT_SHORT_NAME_LABEL;

	private HtmlInputText COMP_DEPT_SHORT_NAME;

	private HtmlOutputLabel COMP_DEPT_MGR_NAME_LABEL;

	private HtmlInputText COMP_DEPT_MGR_NAME;

	private PM_DEPARTMENT PM_DEPARTMENT_BEAN;

	public PM001_A_COMPOSITE_ACTION compositeAction;

	private PM_DEPARTMENT_HELPER helper;

	private List<PM_DEPARTMENT> dataList_PM_DEPARTMENT = new ArrayList<PM_DEPARTMENT>();
	
	PM_DIVISION_ACTION pm_division_action;

	private UIData dataTable;

	public PM_DEPARTMENT_ACTION() {

		PM_DEPARTMENT_BEAN = new PM_DEPARTMENT();
		helper = new PM_DEPARTMENT_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_DEPT_BL_NAME_LABEL() {
		return COMP_DEPT_BL_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DEPT_BL_NAME() {
		return COMP_DEPT_BL_NAME;
	}

	public void setCOMP_DEPT_BL_NAME_LABEL(
			HtmlOutputLabel COMP_DEPT_BL_NAME_LABEL) {
		this.COMP_DEPT_BL_NAME_LABEL = COMP_DEPT_BL_NAME_LABEL;
	}

	public void setCOMP_DEPT_BL_NAME(HtmlInputText COMP_DEPT_BL_NAME) {
		this.COMP_DEPT_BL_NAME = COMP_DEPT_BL_NAME;
	}

	public HtmlOutputLabel getCOMP_DEPT_BL_SHORT_NAME_LABEL() {
		return COMP_DEPT_BL_SHORT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DEPT_BL_SHORT_NAME() {
		return COMP_DEPT_BL_SHORT_NAME;
	}

	public void setCOMP_DEPT_BL_SHORT_NAME_LABEL(
			HtmlOutputLabel COMP_DEPT_BL_SHORT_NAME_LABEL) {
		this.COMP_DEPT_BL_SHORT_NAME_LABEL = COMP_DEPT_BL_SHORT_NAME_LABEL;
	}

	public void setCOMP_DEPT_BL_SHORT_NAME(HtmlInputText COMP_DEPT_BL_SHORT_NAME) {
		this.COMP_DEPT_BL_SHORT_NAME = COMP_DEPT_BL_SHORT_NAME;
	}

	public HtmlOutputLabel getCOMP_DEPT_BL_MGR_NAME_LABEL() {
		return COMP_DEPT_BL_MGR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DEPT_BL_MGR_NAME() {
		return COMP_DEPT_BL_MGR_NAME;
	}

	public void setCOMP_DEPT_BL_MGR_NAME_LABEL(
			HtmlOutputLabel COMP_DEPT_BL_MGR_NAME_LABEL) {
		this.COMP_DEPT_BL_MGR_NAME_LABEL = COMP_DEPT_BL_MGR_NAME_LABEL;
	}

	public void setCOMP_DEPT_BL_MGR_NAME(HtmlInputText COMP_DEPT_BL_MGR_NAME) {
		this.COMP_DEPT_BL_MGR_NAME = COMP_DEPT_BL_MGR_NAME;
	}

	public HtmlOutputLabel getCOMP_DEPT_FRZ_FLAG_LABEL() {
		return COMP_DEPT_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_DEPT_FRZ_FLAG() {
		return COMP_DEPT_FRZ_FLAG;
	}

	public void setCOMP_DEPT_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_DEPT_FRZ_FLAG_LABEL) {
		this.COMP_DEPT_FRZ_FLAG_LABEL = COMP_DEPT_FRZ_FLAG_LABEL;
	}

	public void setCOMP_DEPT_FRZ_FLAG(
			HtmlSelectBooleanCheckbox COMP_DEPT_FRZ_FLAG) {
		this.COMP_DEPT_FRZ_FLAG = COMP_DEPT_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_DEPT_CODE_LABEL() {
		return COMP_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DEPT_CODE() {
		return COMP_DEPT_CODE;
	}

	public void setCOMP_DEPT_CODE_LABEL(HtmlOutputLabel COMP_DEPT_CODE_LABEL) {
		this.COMP_DEPT_CODE_LABEL = COMP_DEPT_CODE_LABEL;
	}

	public void setCOMP_DEPT_CODE(HtmlInputText COMP_DEPT_CODE) {
		this.COMP_DEPT_CODE = COMP_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_DEPT_NAME_LABEL() {
		return COMP_DEPT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DEPT_NAME() {
		return COMP_DEPT_NAME;
	}

	public void setCOMP_DEPT_NAME_LABEL(HtmlOutputLabel COMP_DEPT_NAME_LABEL) {
		this.COMP_DEPT_NAME_LABEL = COMP_DEPT_NAME_LABEL;
	}

	public void setCOMP_DEPT_NAME(HtmlInputText COMP_DEPT_NAME) {
		this.COMP_DEPT_NAME = COMP_DEPT_NAME;
	}

	public HtmlOutputLabel getCOMP_DEPT_SHORT_NAME_LABEL() {
		return COMP_DEPT_SHORT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DEPT_SHORT_NAME() {
		return COMP_DEPT_SHORT_NAME;
	}

	public void setCOMP_DEPT_SHORT_NAME_LABEL(
			HtmlOutputLabel COMP_DEPT_SHORT_NAME_LABEL) {
		this.COMP_DEPT_SHORT_NAME_LABEL = COMP_DEPT_SHORT_NAME_LABEL;
	}

	public void setCOMP_DEPT_SHORT_NAME(HtmlInputText COMP_DEPT_SHORT_NAME) {
		this.COMP_DEPT_SHORT_NAME = COMP_DEPT_SHORT_NAME;
	}

	public HtmlOutputLabel getCOMP_DEPT_MGR_NAME_LABEL() {
		return COMP_DEPT_MGR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_DEPT_MGR_NAME() {
		return COMP_DEPT_MGR_NAME;
	}

	public void setCOMP_DEPT_MGR_NAME_LABEL(
			HtmlOutputLabel COMP_DEPT_MGR_NAME_LABEL) {
		this.COMP_DEPT_MGR_NAME_LABEL = COMP_DEPT_MGR_NAME_LABEL;
	}

	public void setCOMP_DEPT_MGR_NAME(HtmlInputText COMP_DEPT_MGR_NAME) {
		this.COMP_DEPT_MGR_NAME = COMP_DEPT_MGR_NAME;
	}

	public PM_DEPARTMENT getPM_DEPARTMENT_BEAN() {
		return PM_DEPARTMENT_BEAN;
	}

	public void setPM_DEPARTMENT_BEAN(PM_DEPARTMENT PM_DEPARTMENT_BEAN) {
		this.PM_DEPARTMENT_BEAN = PM_DEPARTMENT_BEAN;
	}

	public void validateDEPT_FRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				PM_DEPARTMENT_BEAN
						.setDEPT_FRZ_FLAG(PELConstants.CHECKBOX_CHECKED);
			} else {
				PM_DEPARTMENT_BEAN
						.setDEPT_FRZ_FLAG(PELConstants.CHECKBOX_UNCHECKED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<PM_DEPARTMENT> getDataList_PM_DEPARTMENT() {
		return dataList_PM_DEPARTMENT;
	}

	public void setDataListPM_DEPARTMENT(
			List<PM_DEPARTMENT> dataList_PM_DEPARTMENT) {
		this.dataList_PM_DEPARTMENT = dataList_PM_DEPARTMENT;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PM_DEPARTMENT_BEAN = new PM_DEPARTMENT();
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

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(PM_DEPARTMENT_BEAN, CommonUtils
						.getConnection());
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PM_DEPARTMENT.remove(PM_DEPARTMENT_BEAN);
				if (dataList_PM_DEPARTMENT.size() > 0) {
					PM_DEPARTMENT_BEAN = dataList_PM_DEPARTMENT.get(0);
				} else if (dataList_PM_DEPARTMENT.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PM_DEPARTMENT_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		try {
			if (PM_DEPARTMENT_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.preInsert(compositeAction);
				new CRUDHandler().executeInsert(PM_DEPARTMENT_BEAN, CommonUtils
						.getConnection());
				/*compositeAction.getPM_DIVISION_ACTION_BEAN().*/getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				/*compositeAction.getPM_DIVISION_ACTION_BEAN().*/getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_PM_DEPARTMENT.add(PM_DEPARTMENT_BEAN);
			} else if (PM_DEPARTMENT_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PM_DEPARTMENT_BEAN, CommonUtils
						.getConnection());
				/*compositeAction.getPM_DIVISION_ACTION_BEAN().*/getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				/*compositeAction.getPM_DIVISION_ACTION_BEAN().*/getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PM_DEPARTMENT_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			/*compositeAction.getPM_DIVISION_ACTION_BEAN().*/getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			/*compositeAction.getPM_DIVISION_ACTION_BEAN().*/getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_DEPARTMENT_BEAN = (PM_DEPARTMENT) dataTable.getRowData();
			PM_DEPARTMENT_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	public void resetSelectedRow() {
		Iterator<PM_DEPARTMENT> PM_DEPARTMENT_ITR = dataList_PM_DEPARTMENT
				.iterator();
		while (PM_DEPARTMENT_ITR.hasNext()) {
			PM_DEPARTMENT_ITR.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_DEPT_BL_NAME.resetValue();
		COMP_DEPT_BL_SHORT_NAME.resetValue();
		COMP_DEPT_BL_MGR_NAME.resetValue();
		//COMP_DEPT_FRZ_FLAG.resetValue();
		COMP_DEPT_CODE.resetValue();
		COMP_DEPT_NAME.resetValue();
		COMP_DEPT_SHORT_NAME.resetValue();
		COMP_DEPT_MGR_NAME.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			if (getPM_DEPARTMENT_BEAN().getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.PRE_UPDATE(compositeAction);
				
				new CRUDHandler().executeUpdate(getPM_DEPARTMENT_BEAN(), CommonUtils.getConnection());
			} else {
				helper.preInsert(compositeAction);
				new CRUDHandler().executeInsert(getPM_DEPARTMENT_BEAN(), CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
		}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void validateDEPT_CODE1(FacesContext context, UIComponent component,
			Object value) {
		String currValue = (String) value;
		String beanValue = PM_DEPARTMENT_BEAN.getDEPT_CODE();
		try {
			if(!(currValue.equalsIgnoreCase(beanValue))){
			PM_DEPARTMENT_BEAN.setDEPT_CODE((String) value);
			helper.L_UNIQUE_DEPT_CODE(compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validateDEPT_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		String currValue = (String) value;
		String beanValue = PM_DEPARTMENT_BEAN.getDEPT_CODE();
		try {
			if(!(currValue.equalsIgnoreCase(beanValue))){
				PM_DEPARTMENT_BEAN.setDEPT_CODE((String) value);
				helper.L_UNIQUE_DEPT_CODE(compositeAction);
				}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_DEPT_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void validateDEPT_NAME(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_DEPARTMENT_BEAN.setDEPT_NAME((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	public void validateDEPT_SHORT_NAME(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_DEPARTMENT_BEAN.setDEPT_SHORT_NAME((String) value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	public void validateDEPT_MGR_NAME(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_DEPARTMENT_BEAN.setDEPT_MGR_NAME((String) value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	public void validateDEPT_BL_NAME(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_DEPARTMENT_BEAN.setDEPT_BL_NAME((String) value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateDEPT_BL_SHORT_NAME(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_DEPARTMENT_BEAN.setDEPT_BL_SHORT_NAME((String) value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateDEPT_BL_MGR_NAME(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_DEPARTMENT_BEAN.setDEPT_BL_MGR_NAME((String) value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateDEPT_DIVN_CODE(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_DEPARTMENT_BEAN.setDEPT_DIVN_CODE((String) value);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateDEPT_COMP_CODE(FacesContext context, UIComponent component,
			Object value) {
		try {
			/*Commented by Janani 17.8.2016
			 * 
			 * PM_DEPARTMENT_BEAN.setDEPT_COMP_CODE((String) value);*/
			
			/*added by janani on 17.8.2016 for dept code issue*/
			
			PM_DEPARTMENT_BEAN.setDEPT_CODE((String) value);
			System.out.println("div comp code  :"+compositeAction.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN().getDIVN_COMP_CODE());
			PM_DEPARTMENT_BEAN.setDEPT_COMP_CODE(compositeAction.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN().getDIVN_COMP_CODE());

/*end*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * Instantiates all components in PM_DEPARTMENT_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_DEPT_BL_NAME				 = new HtmlInputText();
		COMP_DEPT_BL_SHORT_NAME				 = new HtmlInputText();
		COMP_DEPT_BL_MGR_NAME				 = new HtmlInputText();
		COMP_DEPT_CODE					 = new HtmlInputText();
		COMP_DEPT_NAME					 = new HtmlInputText();
		COMP_DEPT_SHORT_NAME				 = new HtmlInputText();
		COMP_DEPT_MGR_NAME				 = new HtmlInputText();
		//COMP_DEPT_FRZ_FLAG          = new HtmlSelectBooleanCheckbox();
	}
	
	/*Added by Ameen on 21-06-2017 for ZBILQC-1717934*/
	
	public ArrayList<LovBean> deptCodeLov(Object object) {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		Object[] values = null;
		String currentValue = (String) object;

		String mainQry = "SELECT DEPT_CODE,DEPT_NAME,DEPT_SHORT_NAME FROM PM_DEPARTMENT WHERE NVL(DEPT_FRZ_FLAG,'N') = 'N' "
				+ "AND UPPER(DEPT_CODE) LIKE UPPER(?) OR UPPER(DEPT_NAME) LIKE UPPER(?)";
		System.out.println(mainQry);
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] {currentValue,currentValue};
			suggestionList = ListItemUtil
					.prepareSuggestionList(mainQry, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	/*End*/
 
}