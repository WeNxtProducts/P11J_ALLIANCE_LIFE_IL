package com.iii.pel.forms.PILM204;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_FORMULA_DTL_ACTION extends CommonAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HtmlOutputLabel COMP_FMD_COMP_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_FMD_COMP_TYPE;

	private HtmlOutputLabel COMP_FMD_COMPONENT_LABEL;

	private HtmlInputText COMP_FMD_COMPONENT;

	private HtmlOutputLabel COMP_UI_M_FORMULA_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FORMULA_DESC;

	private HtmlOutputLabel COMP_FMD_SR_NO_LABEL;

	private HtmlInputText COMP_FMD_SR_NO;

	private PM_IL_FORMULA_DTL PM_IL_FORMULA_DTL_BEAN;

	PM_IL_FORMULA_DELEGATE delegate = new PM_IL_FORMULA_DELEGATE();
	public PM_IL_FORMULA_COMPOSITEBEAN compositeAction;

	private UIDataTable datatable;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private String filterByFMD_SR_NO;
	
	private String filterByFMD_COMPONENT;

	private int prevRowIndex;

	private int currentpage;

	private int recordsperPage = 10;

	private int lastUpdateRowIndex;

	private List<SelectItem> componentTypeList = new ArrayList<SelectItem>();

	private List<PM_IL_FORMULA_DTL> dataList_PM_IL_FORMULA_DTL = new ArrayList<PM_IL_FORMULA_DTL>();

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

	private List componentList = new ArrayList();

	public PM_IL_FORMULA_DTL_ACTION() {
		PM_IL_FORMULA_DTL_BEAN = new PM_IL_FORMULA_DTL();
		prevRowIndex = 0;
		currentpage = 1;
		/*componentTypeList = delegate.comboBoxValues("PILM204",
				"PM_IL_FORMULA_DTL", "PM_IL_FORMULA_DTL.FMD_COMP_TYPE",
				"IL_FOR_COMP");*/
		prepareDropDowns();
	}
	
	public void prepareDropDowns(){
		try {
			Connection connection = CommonUtils.getConnection();
			setComponentTypeList(ListItemUtil.getDropDownListValue(
					connection, "PILM204", "PM_IL_FORMULA_DTL",
					"PM_IL_FORMULA_DTL.FMD_COMP_TYPE", "IL_FOR_COMP"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_FMD_COMP_TYPE_LABEL() {
		return COMP_FMD_COMP_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FMD_COMP_TYPE() {
		return COMP_FMD_COMP_TYPE;
	}

	public void setCOMP_FMD_COMP_TYPE_LABEL(
			HtmlOutputLabel COMP_FMD_COMP_TYPE_LABEL) {
		this.COMP_FMD_COMP_TYPE_LABEL = COMP_FMD_COMP_TYPE_LABEL;
	}

	public void setCOMP_FMD_COMP_TYPE(HtmlSelectOneMenu COMP_FMD_COMP_TYPE) {
		this.COMP_FMD_COMP_TYPE = COMP_FMD_COMP_TYPE;
	}

	public HtmlOutputLabel getCOMP_FMD_COMPONENT_LABEL() {
		return COMP_FMD_COMPONENT_LABEL;
	}

	public HtmlInputText getCOMP_FMD_COMPONENT() {
		return COMP_FMD_COMPONENT;
	}

	public void setCOMP_FMD_COMPONENT_LABEL(
			HtmlOutputLabel COMP_FMD_COMPONENT_LABEL) {
		this.COMP_FMD_COMPONENT_LABEL = COMP_FMD_COMPONENT_LABEL;
	}

	public void setCOMP_FMD_COMPONENT(HtmlInputText COMP_FMD_COMPONENT) {
		this.COMP_FMD_COMPONENT = COMP_FMD_COMPONENT;
	}

	public HtmlOutputLabel getCOMP_UI_M_FORMULA_DESC_LABEL() {
		return COMP_UI_M_FORMULA_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FORMULA_DESC() {
		return COMP_UI_M_FORMULA_DESC;
	}

	public void setCOMP_UI_M_FORMULA_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_FORMULA_DESC_LABEL) {
		this.COMP_UI_M_FORMULA_DESC_LABEL = COMP_UI_M_FORMULA_DESC_LABEL;
	}

	public void setCOMP_UI_M_FORMULA_DESC(HtmlInputText COMP_UI_M_FORMULA_DESC) {
		this.COMP_UI_M_FORMULA_DESC = COMP_UI_M_FORMULA_DESC;
	}

	public HtmlOutputLabel getCOMP_FMD_SR_NO_LABEL() {
		return COMP_FMD_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_FMD_SR_NO() {
		return COMP_FMD_SR_NO;
	}

	public void setCOMP_FMD_SR_NO_LABEL(HtmlOutputLabel COMP_FMD_SR_NO_LABEL) {
		this.COMP_FMD_SR_NO_LABEL = COMP_FMD_SR_NO_LABEL;
	}

	public void setCOMP_FMD_SR_NO(HtmlInputText COMP_FMD_SR_NO) {
		this.COMP_FMD_SR_NO = COMP_FMD_SR_NO;
	}

	public PM_IL_FORMULA_DTL getPM_IL_FORMULA_DTL_BEAN() {
		return PM_IL_FORMULA_DTL_BEAN;
	}

	public void setPM_IL_FORMULA_DTL_BEAN(
			PM_IL_FORMULA_DTL PM_IL_FORMULA_DTL_BEAN) {
		this.PM_IL_FORMULA_DTL_BEAN = PM_IL_FORMULA_DTL_BEAN;
	}

	public List<PM_IL_FORMULA_DTL> getDataList_PM_IL_FORMULA_DTL() {
		return dataList_PM_IL_FORMULA_DTL;
	}

	public void setDataListPM_IL_FORMULA_DTL(
			List<PM_IL_FORMULA_DTL> dataList_PM_IL_FORMULA_DTL) {
		this.dataList_PM_IL_FORMULA_DTL = dataList_PM_IL_FORMULA_DTL;
	}

	public UIDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(UIDataTable datatable) {
		this.datatable = datatable;
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

	public void setDataList_PM_IL_FORMULA_DTL(
			List<PM_IL_FORMULA_DTL> dataList_PM_IL_FORMULA_DTL) {
		this.dataList_PM_IL_FORMULA_DTL = dataList_PM_IL_FORMULA_DTL;
	}

	public void getDetails() {
		try {
			if ( dataList_PM_IL_FORMULA_DTL.size() != 0) {				
				PM_IL_FORMULA_DTL_BEAN = (PM_IL_FORMULA_DTL) datatable.getRowData();
				getCodeDesc( );
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_FORMULA_DTL_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_FMD_COMP_TYPE.resetValue();
		COMP_FMD_COMPONENT.resetValue();
		COMP_FMD_SR_NO.resetValue();
		COMP_UI_M_FORMULA_DESC.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_FORMULA_DTL> iterator = dataList_PM_IL_FORMULA_DTL.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void lastColumnListener() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_FORMULA_COMPOSITEBEAN compositeAction = (PM_IL_FORMULA_COMPOSITEBEAN) (commonUtils
				.getMappedBeanFromSession("PM_IL_FORMULA_COMPOSITEBEAN"));
		String formulaCode = compositeAction.getPM_IL_FORMULA_ACTION()
				.getPM_IL_FORMULA_BEAN().getFRM_CODE();
		int currRowIndex = getDatatable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_FORMULA_DTL gridValueBean = null;

		try {

			// Get the bean based on row index
			gridValueBean = (PM_IL_FORMULA_DTL) dataList_PM_IL_FORMULA_DTL
					.get(currRowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				gridValueBean.setFMD_FM_CODE(formulaCode);
				gridValueBean.setFMD_UPD_DATE(new CommonUtils().getCurrentDate());
				gridValueBean.setFMD_UPD_ID(CommonUtils.getControlBean().getM_USER_ID());
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Updated");
			} else {
				gridValueBean.setFMD_FM_CODE(formulaCode);
				System.out.println(gridValueBean.getFMD_FM_CODE());
				//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]

				gridValueBean.setFMD_CR_DATE(new CommonUtils().getCurrentDate());
				gridValueBean.setFMD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Inserted");
			}
			lastUpdateRowIndex = currRowIndex;

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return;
	}
	

	public void addNew(ActionEvent event) {
		try {
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()) {
				PM_IL_FORMULA_DTL_BEAN = new PM_IL_FORMULA_DTL();
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
				new CRUDHandler().executeDelete(PM_IL_FORMULA_DTL_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
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
				dataList_PM_IL_FORMULA_DTL.remove(PM_IL_FORMULA_DTL_BEAN);
				if (dataList_PM_IL_FORMULA_DTL.size() > 0) {

					PM_IL_FORMULA_DTL_BEAN = dataList_PM_IL_FORMULA_DTL
							.get(0);
				} else if (dataList_PM_IL_FORMULA_DTL.size() == 0) {
					addNew(null);
				}

				resetAllComponent();
				PM_IL_FORMULA_DTL_BEAN.setRowSelected(true);
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

	public void post(ActionEvent event) {
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			String formulaCode = compositeAction.getPM_IL_FORMULA_ACTION().getPM_IL_FORMULA_BEAN().getFRM_CODE();
			if (PM_IL_FORMULA_DTL_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()) {
					PM_IL_FORMULA_DTL_BEAN.setFMD_FM_CODE(formulaCode);
					PM_IL_FORMULA_DTL_BEAN.setFMD_CR_DATE(new CommonUtils().getCurrentDate());
					PM_IL_FORMULA_DTL_BEAN.setFMD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				new CRUDHandler().executeInsert(PM_IL_FORMULA_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				dataList_PM_IL_FORMULA_DTL.add(PM_IL_FORMULA_DTL_BEAN);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PM_IL_FORMULA_DTL_BEAN.getROWID() != null){
					if(isUPDATE_ALLOWED()) {
						PM_IL_FORMULA_DTL_BEAN.setFMD_FM_CODE(formulaCode);
						PM_IL_FORMULA_DTL_BEAN.setFMD_UPD_DATE(new CommonUtils().getCurrentDate());
						PM_IL_FORMULA_DTL_BEAN.setFMD_UPD_ID(CommonUtils.getControlBean().getM_USER_ID());
				new CRUDHandler().executeUpdate(PM_IL_FORMULA_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
			}else{
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$updatenotallowed"));
			}
			}
			PM_IL_FORMULA_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}
	
	public void selectedCheckbox(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();

		String selected = (String) (input.getSubmittedValue());
		int row = datatable.getRowIndex();
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

		PM_IL_FORMULA_DTL pm_il_med_exam_dtl = dataList_PM_IL_FORMULA_DTL
				.get(row);

		if (selected.equals("true"))
			pm_il_med_exam_dtl.setSelected(true);
		else
			pm_il_med_exam_dtl.setSelected(false);

	}

	public List suggestionActionComponent(Object obj) {
		String code = (String) obj;
		componentList = delegate.suggestionActionComponent(code, componentList,
				PM_IL_FORMULA_DTL_BEAN);
		return componentList;
	}

	public List getComponentList() {
		return componentList;
	}

	public void setComponentList(List componentList) {
		this.componentList = componentList;
	}

	public void getCodeDesc( ) {
		COMP_UI_M_FORMULA_DESC.setSubmittedValue(null);

		if (COMP_FMD_COMPONENT.getSubmittedValue() != null) {
			String code = (String) COMP_FMD_COMPONENT.getSubmittedValue();
			String codeDesc = delegate.getCodeDesc(code, componentList);
			 
//			COMP_UI_M_FORMULA_DESC.setSubmittedValue(codeDesc);
			PM_IL_FORMULA_DTL_BEAN.setUI_M_FORMULA_DESC(codeDesc);

		}
	}

	public List<SelectItem> getComponentTypeList() {
		if (componentTypeList.size() == 0) {
			componentTypeList.clear();
			try {
				componentTypeList = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return componentTypeList;
	}

	public void setComponentTypeList(List<SelectItem> componentTypeList) {
		this.componentTypeList = componentTypeList;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void componentTypeWhenValidate(FacesContext facesContext,
			UIComponent component, Object value) {

		if (COMP_FMD_COMP_TYPE.getSubmittedValue() != null) {
			String componentType = (String) COMP_FMD_COMP_TYPE.getSubmittedValue();
			PM_IL_FORMULA_DTL_BEAN.setFMD_COMP_TYPE(componentType);
			//gridtabListener();
		}
	}

	public void formulaComponentWhenValidate(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		try {
			if (COMP_FMD_COMPONENT.getSubmittedValue() != null) {

				String formulaComponent = (String) value;
				int rowIndex = getDatatable().getRowIndex();
				delegate.componentWhenValidate(formulaComponent, PM_IL_FORMULA_DTL_BEAN);
				PM_IL_FORMULA_DTL_BEAN.setFMD_COMPONENT(formulaComponent);
//			lastColumnListener();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "FMD_COMPONENT",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	// [ Added for grid implementation change, Added by: Rajesh Kundala, Dated: 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = datatable.getRowIndex();

		try{
			if(rowIndex > -1){
			
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

	public String fetchDetailsList() {

		try{
		List<PM_IL_FORMULA_DTL> dataList = null; 
		dataList = compositeAction
		.getPM_IL_FORMULA_DTL_ACTION()
		.getDataList_PM_IL_FORMULA_DTL();
		if(dataList != null && dataList.size()>0){
			dataList.clear();
		}
		delegate.prepareDetailsList(compositeAction);
		dataList = compositeAction
						.getPM_IL_FORMULA_DTL_ACTION()
							.getDataList_PM_IL_FORMULA_DTL();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_FORMULA_DTL PM_IL_FORMULA_DTL_BEAN = dataList.get(0);
			PM_IL_FORMULA_DTL_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_FORMULA_DTL_ACTION()
					.setPM_IL_FORMULA_DTL_BEAN(PM_IL_FORMULA_DTL_BEAN);
		}
					delegate.postQuery();
		 } catch (Exception e) {
			e.printStackTrace();
		 } 

		return "formulaDetails";
	}

	public String backToHeader() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_FORMULA_COMPOSITEBEAN compositeAction = (PM_IL_FORMULA_COMPOSITEBEAN) (commonUtils
				.getMappedBeanFromSession("PM_IL_FORMULA_COMPOSITEBEAN"));
		PM_IL_FORMULA bean = compositeAction.getPM_IL_FORMULA_ACTION()
				.getPM_IL_FORMULA_BEAN();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();

		if (dataList_PM_IL_FORMULA_DTL != null
				&& dataList_PM_IL_FORMULA_DTL.size() > 0) {
			bean.setFRM_FORMULA("");
			Iterator<PM_IL_FORMULA_DTL> iterator = dataList_PM_IL_FORMULA_DTL
					.iterator();
			while (iterator.hasNext()) {
				PM_IL_FORMULA_DTL pm_il_formula_dtl = iterator.next();
				if (bean.getFRM_FORMULA() != null) {
					String formulaString = pm_il_formula_dtl.getFMD_COMPONENT();
					formulaString = formulaString == null ? "" : formulaString;
					bean.setFRM_FORMULA(bean.getFRM_FORMULA()+ formulaString);
				}

			}
		}
		return "goToHeader";

	}

	public void saveRecord() {
		CommonUtils.clearMaps(this);
		String message = null;
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			message = Messages.getString(
					PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	
	}
	
	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				delegate.prepareDetailsList(compositeAction);
				setBlockFlag(false);
			}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String back(){
		return "PILM204_PM_IL_FORMULA_NEW";
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

	public String getFilterByFMD_SR_NO() {
		return filterByFMD_SR_NO;
	}

	public void setFilterByFMD_SR_NO(String filterByFMD_SR_NO) {
		this.filterByFMD_SR_NO = filterByFMD_SR_NO;
	}

	public String getFilterByFMD_COMPONENT() {
		return filterByFMD_COMPONENT;
	}

	public void setFilterByFMD_COMPONENT(String filterByFMD_COMPONENT) {
		this.filterByFMD_COMPONENT = filterByFMD_COMPONENT;
	}
}
