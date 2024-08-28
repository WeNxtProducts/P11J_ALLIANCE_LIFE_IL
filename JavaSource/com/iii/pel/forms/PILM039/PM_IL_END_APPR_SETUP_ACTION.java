package com.iii.pel.forms.PILM039;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_END_APPR_SETUP_ACTION extends CommonAction {

	private UIData dataTable;

	private int currPage;

	private int prevRowIndex;

	private int recordsPerPage = 5;

	private int lastUpdatedRowIndex;

	private HtmlOutputLabel COMP_EAS_FM_END_CODE_LABEL;

	private HtmlInputText COMP_EAS_FM_END_CODE;

	private HtmlOutputLabel COMP_EAS_FM_END_CODE_DESC_LABEL;

	private HtmlInputText COMP_EAS_FM_END_CODE_DESC;

	private HtmlOutputLabel COMP_EAS_TO_END_CODE_LABEL;

	private HtmlInputText COMP_EAS_TO_END_CODE;

	private HtmlOutputLabel COMP_EAS_TO_END_CODE_DESC_LABEL;

	private HtmlInputText COMP_EAS_TO_END_CODE_DESC;

	private HtmlOutputLabel COMP_EAS_END_PROC_YN_LABEL;

	private HtmlSelectOneMenu COMP_EAS_END_PROC_YN;

	private HtmlOutputLabel COMP_EAS_END_APPR_YN_LABEL;

	private HtmlSelectOneMenu COMP_EAS_END_APPR_YN;

	private PM_IL_END_APPR_SETUP PM_IL_END_APPR_SETUP_BEAN;
	
	private PILM039_HELPER helper;
	
	public PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction;

	//private ArrayList<SelectItem> EAS_END_APPR_YN;
	
	//private ArrayList<SelectItem> EAS_END_PROC_YN;
	
	List<SelectItem> EAS_END_APPR_YN = new ArrayList<SelectItem>();
	
	List<SelectItem> EAS_END_PROC_YN = new ArrayList<SelectItem>();

	private ArrayList<PM_IL_END_APPR_SETUP> list = new ArrayList<PM_IL_END_APPR_SETUP>();

	PILM039_DELIGATE deligate = new PILM039_DELIGATE();
	
	private List<PM_IL_END_APPR_SETUP> suggestionList ;
	
	private List<PM_IL_END_APPR_SETUP> fromEndosmentList;
	
	private String filterByEAS_FM_END_CODE;
	
	private String filterByEAS_FM_END_CODE_DESC;
	
	private String filterByEAS_TO_END_CODE;

//	private List<PM_IL_END_APPR_SETUP> endApplication = null;

	public String getFilterByEAS_FM_END_CODE() {
		return filterByEAS_FM_END_CODE;
	}

	public void setFilterByEAS_FM_END_CODE(String filterByEAS_FM_END_CODE) {
		this.filterByEAS_FM_END_CODE = filterByEAS_FM_END_CODE;
	}

	public PM_IL_END_APPR_SETUP_ACTION() {
		PM_IL_END_APPR_SETUP_BEAN = new PM_IL_END_APPR_SETUP();
		helper = new PILM039_HELPER();
		instantiateAllComponent();
		prepareDropDowns();
	}

	public HtmlOutputLabel getCOMP_EAS_FM_END_CODE_LABEL() {
		return COMP_EAS_FM_END_CODE_LABEL;
	}

	public HtmlInputText getCOMP_EAS_FM_END_CODE() {
		return COMP_EAS_FM_END_CODE;
	}

	public void setCOMP_EAS_FM_END_CODE_LABEL(
			HtmlOutputLabel COMP_EAS_FM_END_CODE_LABEL) {
		this.COMP_EAS_FM_END_CODE_LABEL = COMP_EAS_FM_END_CODE_LABEL;
	}

	public void setCOMP_EAS_FM_END_CODE(HtmlInputText AS_FM_COMP_EAS_FM_END_CODEEND_CODE) {
		this.COMP_EAS_FM_END_CODE = AS_FM_COMP_EAS_FM_END_CODEEND_CODE;
	}

	public HtmlOutputLabel getCOMP_EAS_FM_END_CODE_DESC_LABEL() {
		return COMP_EAS_FM_END_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_EAS_FM_END_CODE_DESC() {
		return COMP_EAS_FM_END_CODE_DESC;
	}

	public void setCOMP_EAS_FM_END_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_EAS_FM_END_CODE_DESC_LABEL) {
		this.COMP_EAS_FM_END_CODE_DESC_LABEL = COMP_EAS_FM_END_CODE_DESC_LABEL;
	}

	public void setCOMP_EAS_FM_END_CODE_DESC(
			HtmlInputText COMP_EAS_FM_END_CODE_DESC) {
		this.COMP_EAS_FM_END_CODE_DESC = COMP_EAS_FM_END_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_EAS_TO_END_CODE_LABEL() {
		return COMP_EAS_TO_END_CODE_LABEL;
	}

	public HtmlInputText getCOMP_EAS_TO_END_CODE() {
		return COMP_EAS_TO_END_CODE;
	}

	public void setCOMP_EAS_TO_END_CODE_LABEL(
			HtmlOutputLabel COMP_EAS_TO_END_CODE_LABEL) {
		this.COMP_EAS_TO_END_CODE_LABEL = COMP_EAS_TO_END_CODE_LABEL;
	}

	public void setCOMP_EAS_TO_END_CODE(HtmlInputText COMP_EAS_TO_END_CODE) {
		this.COMP_EAS_TO_END_CODE = COMP_EAS_TO_END_CODE;
	}

	public HtmlOutputLabel getCOMP_EAS_TO_END_CODE_DESC_LABEL() {
		return COMP_EAS_TO_END_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_EAS_TO_END_CODE_DESC() {
		return COMP_EAS_TO_END_CODE_DESC;
	}

	public void setCOMP_EAS_TO_END_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_EAS_TO_END_CODE_DESC_LABEL) {
		this.COMP_EAS_TO_END_CODE_DESC_LABEL = COMP_EAS_TO_END_CODE_DESC_LABEL;
	}

	public void setCOMP_EAS_TO_END_CODE_DESC(
			HtmlInputText COMP_EAS_TO_END_CODE_DESC) {
		this.COMP_EAS_TO_END_CODE_DESC = COMP_EAS_TO_END_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_EAS_END_PROC_YN_LABEL() {
		return COMP_EAS_END_PROC_YN_LABEL;
	}

	public void setCOMP_EAS_END_PROC_YN_LABEL(
			HtmlOutputLabel COMP_EAS_END_PROC_YN_LABEL) {
		this.COMP_EAS_END_PROC_YN_LABEL = COMP_EAS_END_PROC_YN_LABEL;
	}

	
	public HtmlOutputLabel getCOMP_EAS_END_APPR_YN_LABEL() {
		return COMP_EAS_END_APPR_YN_LABEL;
	}

	
	public void setCOMP_EAS_END_APPR_YN_LABEL(
			HtmlOutputLabel COMP_EAS_END_APPR_YN_LABEL) {
		this.COMP_EAS_END_APPR_YN_LABEL = COMP_EAS_END_APPR_YN_LABEL;
	}

	
	public PM_IL_END_APPR_SETUP getPM_IL_END_APPR_SETUP_BEAN() {
		return PM_IL_END_APPR_SETUP_BEAN;
	}

	public void setPM_IL_END_APPR_SETUP_BEAN(
			PM_IL_END_APPR_SETUP PM_IL_END_APPR_SETUP_BEAN) {
		this.PM_IL_END_APPR_SETUP_BEAN = PM_IL_END_APPR_SETUP_BEAN;
	}
	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}
	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
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
	
	public List<PM_IL_END_APPR_SETUP> getSuggestionList() {
		return suggestionList;
	}
	public void setSuggestionList(List<PM_IL_END_APPR_SETUP> suggestionList) {
		this.suggestionList = suggestionList;
	}
	
	public ArrayList<PM_IL_END_APPR_SETUP> getList() {
		return list;
	}

	
	public void setList(ArrayList<PM_IL_END_APPR_SETUP> list) {
		this.list = list;
	}

	
	/*public ArrayList<SelectItem> getEAS_END_APPR_YN() {
		return EAS_END_APPR_YN;
	}*/

	
	public void setEAS_END_APPR_YN(ArrayList<SelectItem> eas_end_appr_yn) {
		EAS_END_APPR_YN = eas_end_appr_yn;
	}

	
	/*public ArrayList<SelectItem> getEAS_END_PROC_YN() {
		return EAS_END_PROC_YN;
	}
*/
	
	public void setEAS_END_PROC_YN(ArrayList<SelectItem> eas_end_proc_yn) {
		EAS_END_PROC_YN = eas_end_proc_yn;
	}

	

	// suggestionActionEAS_FM_END_CODE

	/**
	 * Called on SuggestionBox for From Endowment
	 * 
	 * @param event
	 * @return
	 */
	public List<PM_IL_END_APPR_SETUP> suggestionActionEAS_FM_END_CODE(Object event) {
		String endosmentCode = (String) event;
		
		fromEndosmentList = deligate.prepareEndowmentList(endosmentCode,fromEndosmentList);
		
		return fromEndosmentList;
	}

	/**
	 * @return the fromEndosmentList
	 */
	public List<PM_IL_END_APPR_SETUP> getFromEndosmentList() {
		return fromEndosmentList;
	}

	/**
	 * @param fromEndosmentList
	 *            the fromEndosmentList to set
	 */
	public void setFromEndosmentList(List<PM_IL_END_APPR_SETUP> fromEndosmentList) {
		this.fromEndosmentList = fromEndosmentList;
	}

	/**
	 * Called on City SuggestionBox Column to display description to a code
	 * 
	 * @param event
	 */
	public void getCityCodeDesc(ActionEvent event) {
		CommonUtils.clearMaps(this);
		COMP_EAS_FM_END_CODE.setSubmittedValue(null);
		
		if (COMP_EAS_FM_END_CODE.getSubmittedValue() != null) {
			
			String endowmentCode = (String) COMP_EAS_FM_END_CODE.getSubmittedValue();
			
			String cityDesc = deligate.getCityDescforCode(endowmentCode,fromEndosmentList);
			COMP_EAS_FM_END_CODE_DESC.setSubmittedValue(cityDesc);
		}
	}
	
	
	
	/*******************************************/
	/**
	 * Action method for add row button
	 * @return
	 */
	/*checked*/
	public String addNew() {
		CommonUtils.clearMaps(this);
		int rowCount = 0;
		PILM039_HELPER helper=new PILM039_HELPER();
		if (list == null) {
			list = new ArrayList<PM_IL_END_APPR_SETUP>();
		}
		/*list.add(compositeAction.getPM_IL_END_APPR_SETUP_ACTION_BEAN()
				.getPM_IL_END_APPR_SETUP_BEAN());*/
		PM_IL_END_APPR_SETUP bean=new PM_IL_END_APPR_SETUP();
		helper.whenCreateRecord(bean);
		list.add(bean);
		rowCount = getDataTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return null;
	}
	/**
	 * Action method for delete row action
	 * @return
	 */
	/*checked*/
	/*public String deleteRow() {
		CommonUtils.clearMaps(this);
		PM_IL_END_APPR_SETUP bean = null;
		if (list != null) {
			for (int index = 0; index < list.size();) {
				bean = list.get(index);
				if (bean.isCHECK_BOX() && bean.getROWID() != null) {
					int delCount= deligate.deleteData(bean);
					list.remove(index);
					String message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete");
					getWarningMap().put("somekey",message);
					getWarningMap().put("current", message);
				} else {
					index++;
				}
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}*/

	/**
	 * Listener method for check box click
	 * @param actionEvent
	 * @return
	 */
	/*checked*/
	public String checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		boolean check=Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex =getDataTable().getRowIndex();
		list.get(rowIndex).setCHECK_BOX(check);
		return "";
	}
	/**
	 * Util method to get current value of a component
	 * @param event
	 * @return
	 */
	/*checked*/
	public String getCurrentValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
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
/*	public String getCurrentToValue(ActionEvent event) {
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
	
	public String getCurrentSelectedValue(ActionEvent event) {
		String value = null;
		UISelectOne input = null;
		if (event != null) {
			input = (UISelectOne) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}*/
	
	/*public void checkBoxValidation(ActionEvent event) {
		gridtabListener();
	}
	public void newMeth(ActionEvent event){
	}
	public String newMeth1(){
		return null;
	}
	
	public String insetrValue() 
	{
		PM_IL_END_APPR_SETUP record =(PM_IL_END_APPR_SETUP) getDataTable().getRowData();	
		deligate.insertEndowmentValues();
		return null;
	}
	
		public void yearsFromValidation(ActionEvent actionEvent)
	{
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		String insertedValue=getCurrentValue(actionEvent);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		int rowIndex = getDataTable().getRowIndex();
		if(!"".equalsIgnoreCase(insertedValue) && !insertedValue.isEmpty()){
			list.get(rowIndex).setEAS_FM_END_CODE(insertedValue);
			String assignFromEndoDesc =deligate.L_VAL_ENDT(insertedValue);
			getCOMP_EAS_FM_END_CODE_DESC().setSubmittedValue(assignFromEndoDesc);
		}
		else{
			getCOMP_EAS_FM_END_CODE_DESC().setSubmittedValue(" ");
			throw new ValidatorException(new FacesMessage("Invalid User Id"));
		}
		gridtabListener();
	}
	
	public void toValidation(ActionEvent actionEvent)
	{
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		
		String insertedValue=getCurrentValue(actionEvent);
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		int rowIndex = getDataTable().getRowIndex();
		if(!"".equalsIgnoreCase(insertedValue) && !insertedValue.isEmpty()){
			list.get(rowIndex).setEAS_TO_END_CODE(insertedValue);
			String assignToEndoDesc =deligate.L_VAL_ENDT(insertedValue);
			getCOMP_EAS_TO_END_CODE_DESC().setSubmittedValue(assignToEndoDesc);
		}else{
			getCOMP_EAS_TO_END_CODE_DESC().setSubmittedValue("");
			throw new ValidatorException(new FacesMessage("Invalid User Id"));
		}
		gridtabListener();
	}
	*/
	/*checked*/
	public void lastColumnListener(){
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_END_APPR_SETUP gridValueBean = null;
		PILM039_HELPER helper = new PILM039_HELPER();
		
		try {
				// Get the bean based on row index
				gridValueBean = (PM_IL_END_APPR_SETUP)list.get(currRowIndex);
				if (gridValueBean.getROWID() == null) {
					helper.PM_IL_END_APPR_SETUP_pre_insert(gridValueBean);
					String insertMessage = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
					getWarningMap().put("somekey", insertMessage);
					getWarningMap().put("current", insertMessage);
				} else {
					helper.PM_IL_END_APPR_SETUP_pre_update(gridValueBean);
					String updateMessage = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update");
					getWarningMap().put("somekey", updateMessage);
					getWarningMap().put("current", updateMessage);
				}
				rowUpdated = deligate.updateData(gridValueBean);
				lastUpdatedRowIndex = currRowIndex;
				getErrorMap().clear();
		} catch (ValidatorException e) {
			getErrorMap().put("details", e.getFacesMessage().getDetail());
			getErrorMap().put("current", e.getFacesMessage().getSummary());
		} catch (Exception e) {
			getErrorMap().put("details", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
		return ;
	}
	
	// [ Commented for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009
	/**
	 * Grid tab listener
	 */
	/*checked*/
	/*public void gridtabListener() {
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PILM039_HELPER helper=new PILM039_HELPER();
		PM_IL_END_APPR_SETUP detailsBean = null;
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if(currRowIndex != 0){
						if (currRowIndex != prevRowIndex) {
							detailsBean = (PM_IL_END_APPR_SETUP) list.get(prevRowIndex);
							getWarningMap().clear();
							if (detailsBean.getROWID() == null) {
								helper.PM_IL_END_APPR_SETUP_pre_insert(detailsBean);
								String insertMessage = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
								getWarningMap().put("somekey", insertMessage);
								getWarningMap().put("current", insertMessage);
							} else {
								helper.PM_IL_END_APPR_SETUP_pre_update(detailsBean);
								String updateMessage = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update");
								getWarningMap().put("somekey", updateMessage);
								getWarningMap().put("current", updateMessage);
							}
							rowUpdated = deligate.updateData(detailsBean);
							prevRowIndex = currRowIndex;
						}
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}*/
	/*checked*/
	// Commented for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009 ]
	
	/*public String saveButtonAction(){
		PILM039_DELIGATE delegate=new PILM039_DELIGATE();
		try {
			delegate.doCommit();
			getErrorMap().clear();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("details", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
		return"";
	}*/
	public void saveCurrentRecord() {
		CommonUtils.clearMaps(this);
		try {
			if (getPM_IL_END_APPR_SETUP_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getPM_IL_END_APPR_SETUP_BEAN(),
						CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getPM_IL_END_APPR_SETUP_BEAN(),
						CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
			String message = "";
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE", message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	/*code shifted to whenvalidateItemEAS_END_PROC_YN method
	  
	  public void onselectMethode(ActionEvent event){
		String onSelectedValue=getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex();
		list.get(rowIndex).setEAS_END_PROC_YN(onSelectedValue);
		gridtabListener();
	}*/
	
	public void onselectMethodeLast(ActionEvent event){
		CommonUtils.clearMaps(this);
		String onSelectedValue=getCurrentValue(event);
		int rowIndex = getDataTable().getRowIndex();
		PM_IL_END_APPR_SETUP_BEAN.setEAS_END_APPR_YN(onSelectedValue);
		//list.get(rowIndex).setEAS_END_APPR_YN(onSelectedValue);
		//lastColumnListener();
	}
	
	

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	//navigation methods not needed now
	/*
	public String mainPage() {
		return "mainpage";
	}

	public String divisionPage() {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanAction.calldivisionPage();
		return "divisionpage";
	}

	public String rightPage() {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanAction.callRightPage();
		return "rightpage";
	}

	public String headerPage() {
		return "headerpage";
	}

	public String limitsPage() {
		PM_IL_APPR_SETUP_COMPOSITE_ACTION linkBeanAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		linkBeanAction.callLimitsPage();
		return "limitspage";
	}
	
	public ArrayList<PM_IL_END_APPR_SETUP> getEndLovList(Object string){
		PILM039_DELIGATE delegate = new PILM039_DELIGATE();
		try {
			endApplication = delegate.getEndApplLov((String)string);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("somekey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		} 
		return endApplication;
	}
	*/
	/*checked*/
	
	public List<PM_IL_END_APPR_SETUP> getLovForEAS_FM_TO_END_CODE(Object obj) {
		String currCode = (String)obj;
		PILM039_DELIGATE delegate = new PILM039_DELIGATE();
		suggestionList = delegate.getEndApplLov(currCode);
		return suggestionList;
	}
	
	/*checked*/
	public void setFieldEAS_FM_END_CODE_DESC(ActionEvent event){
		CommonUtils.clearMaps(this);
		Iterator<PM_IL_END_APPR_SETUP> iterator = null;
		PM_IL_END_APPR_SETUP bean = null;
		boolean keepLooking = true;
		String divnCode = null;
		int rowIndex = dataTable.getRowIndex();
		PM_IL_END_APPR_SETUP listBean = list.get(rowIndex);
		divnCode = ((UIInput)(event.getComponent().getParent().getParent())).getSubmittedValue().toString();
		if(divnCode != null && !divnCode.trim().isEmpty()){
			if(suggestionList != null){
				iterator = suggestionList.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					if(bean.getEAS_FM_END_CODE().equalsIgnoreCase(divnCode)){
						listBean.setEAS_FM_END_CODE(bean.getEAS_FM_END_CODE());
						listBean.setEAS_FM_END_CODE_DESC(bean.getEAS_FM_END_CODE_DESC());
						keepLooking = false;
						//TODO to be moved to when validate item
						//gridtabListener();
					}
				}
			}
		}
	}
	//FROM TO fields no need to have separate method calls
	/*public List getToLovList(Object obj) {
		String currCode = (String)obj;
		PILM039_DELIGATE delegate = new PILM039_DELIGATE();
		suggestionList = delegate.getToApplLov(currCode);
		return suggestionList;
	}*/
	/**
	 * set description for EAS_TO_END_CODE_DESC field
	 */
	/*checked*/
	public void setFieldEAS_TO_END_CODE_DESC(ActionEvent event){
		CommonUtils.clearMaps(this);
		Iterator<PM_IL_END_APPR_SETUP> iterator = null;
		PM_IL_END_APPR_SETUP bean = null;
		boolean keepLooking = true;
		String divnCode = null;
		int rowIndex = dataTable.getRowIndex();
		PM_IL_END_APPR_SETUP listBean = list.get(rowIndex);
		
		divnCode = ((UIInput)(event.getComponent().getParent().getParent())).getSubmittedValue().toString();
		if(divnCode != null && !divnCode.trim().isEmpty()){
			if(suggestionList != null){
				iterator = suggestionList.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					if(bean.getEAS_TO_END_CODE().equalsIgnoreCase(divnCode)){
						listBean.setEAS_TO_END_CODE(bean.getEAS_TO_END_CODE());
						listBean.setEAS_TO_END_CODE_DESC(bean.getEAS_TO_END_CODE_DESC());
						keepLooking = false;
						//gridtabListener();
					}
				}
			}
		}
	}
	
	public PM_IL_END_APPR_SETUP populateBlockPM_IL_END_APPR_SETUP(){
		
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		PM_IL_END_APPR_SETUP setupBean = null;
		try {
			if(isBlockFlag()){
			list = deligate.loadProcessEndosmentValues();
			if(list.size() > 0 && list.get(0) != null){
			setupBean = list.get(0);
			}else{
				setupBean = new PM_IL_END_APPR_SETUP();
			}
			setupBean.setRowSelected(true);
			setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("populateBlock", e.getMessage());
		}
		return setupBean;
		}
		

	public void preBlockPM_IL_END_APPR_SETUP() {
		
		PILM039_HELPER helper= new PILM039_HELPER();
		helper.preBlockPM_IL_END_APPR_SETUP();
	}

	public void postQueryPM_IL_END_APPR_SETUP() {
		PILM039_HELPER helper= new PILM039_HELPER();
		try {
			helper.postQueryPM_IL_END_APPR_SETUP(list);
			getErrorMap().clear();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("postQuery", e.getMessage());
		}
	}
	public void validateEAS_FM_END_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_END_APPR_SETUP_BEAN().setEAS_FM_END_CODE((String) value);
			helper.validateEAS_FM_END_CODE(PM_IL_END_APPR_SETUP_BEAN);
			COMP_EAS_FM_END_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	
	public void actionListenerEAS_FM_END_CODE(ActionEvent actionEvent) 
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue.isEmpty()){
			COMP_EAS_FM_END_CODE.setSubmittedValue(PELConstants.PROCESS_FROMVALUE);
			PM_IL_END_APPR_SETUP_BEAN.setEAS_FM_END_CODE(PELConstants.PROCESS_FROMVALUE);
		}
		else{
			PM_IL_END_APPR_SETUP_BEAN.setEAS_FM_END_CODE(inputValue);
		}
		COMP_EAS_FM_END_CODE.resetValue();
	}

	public void actionListenerEAS_TO_END_CODE(ActionEvent actionEvent)
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue.isEmpty())
		{
			if(!PELConstants.PROCESS_FROMVALUE.equals(PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE()))
			{
				COMP_EAS_TO_END_CODE.setSubmittedValue(PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE());
				PM_IL_END_APPR_SETUP_BEAN.setEAS_TO_END_CODE(PM_IL_END_APPR_SETUP_BEAN.getEAS_FM_END_CODE());
			}else{
				COMP_EAS_TO_END_CODE.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
				PM_IL_END_APPR_SETUP_BEAN.setEAS_TO_END_CODE(PELConstants.PROCESS_TOVALUE);
			}
		}else{
			PM_IL_END_APPR_SETUP_BEAN.setEAS_TO_END_CODE(inputValue);
		}
	}

	public void validateEAS_TO_END_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_END_APPR_SETUP_BEAN().setEAS_TO_END_CODE((String) value);
			helper.validateEAS_TO_END_CODE(PM_IL_END_APPR_SETUP_BEAN);
			COMP_EAS_TO_END_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void whenListChangedEAS_END_PROC_YN(ActionEvent event){
		CommonUtils.clearMaps(this);
		int currIndex=dataTable.getRowIndex();
		PILM039_HELPER helper= new PILM039_HELPER();
		PM_IL_END_APPR_SETUP valueBean=list.get(currIndex);
		String currentValue=(String)((UIInput)event.getComponent().getParent()).getSubmittedValue();
		try {
			helper.whenListChangedEAS_END_PROC_YN(valueBean, currentValue);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("key", e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void validateEAS_END_PROC_YN(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			 PM_IL_END_APPR_SETUP_BEAN.setEAS_END_PROC_YN((String) value);
			helper.whenListChangedEAS_END_PROC_YN(PM_IL_END_APPR_SETUP_BEAN,(String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	public void validateEAS_END_APPR_YN(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_END_APPR_SETUP_BEAN().setEAS_END_APPR_YN((String) value);
			helper.whenListChangedEAS_END_APPR_YN(PM_IL_END_APPR_SETUP_BEAN, (String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void whenListChangedEAS_END_APPR_YN(ActionEvent event){
		CommonUtils.clearMaps(this);
		int currIndex=dataTable.getRowIndex();
		PILM039_HELPER helper= new PILM039_HELPER();
		PM_IL_END_APPR_SETUP valueBean=list.get(currIndex);
		String currentValue=(String)((UIInput)event.getComponent().getParent()).getSubmittedValue();
		
		
	}
	

	/**
	 * Resets all components in PM_IL_END_APPR_SETUP_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_EAS_FM_END_CODE.resetValue();
		COMP_EAS_FM_END_CODE_DESC.resetValue();
		COMP_EAS_TO_END_CODE.resetValue();
		COMP_EAS_TO_END_CODE_DESC.resetValue();

	}
	

	/**
	 * Instantiates all components in PM_IL_END_APPR_SETUP_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_EAS_FM_END_CODE				 = new HtmlInputText();
		COMP_EAS_FM_END_CODE_DESC			 = new HtmlInputText();
		COMP_EAS_TO_END_CODE				 = new HtmlInputText();
		COMP_EAS_TO_END_CODE_DESC			 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_EAS_END_PROC_YN				 = new HtmlSelectOneMenu();
		COMP_EAS_END_APPR_YN				 = new HtmlSelectOneMenu();

	}


	private void resetSelectedRow() {
		Iterator<PM_IL_END_APPR_SETUP> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	
	public void getDetails() {
		try {
			resetSelectedRow();
			PM_IL_END_APPR_SETUP_BEAN = (PM_IL_END_APPR_SETUP) dataTable
			.getRowData();
			PM_IL_END_APPR_SETUP_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("getDetails", e.getMessage());
		}
	}
	
	
	
	// [ Added for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	/*public String saveCurrentRecord(){
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
	}*/
	
	public String AddRow(){
		CommonUtils.clearMaps(this);
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_IL_END_APPR_SETUP_BEAN = new PM_IL_END_APPR_SETUP();
				resetSelectedRow();
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
		return "";
	}
	public String deleteRow() {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_END_APPR_SETUP_BEAN,
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
				list.remove(PM_IL_END_APPR_SETUP_BEAN);
				if (list.size() > 0) {
					PM_IL_END_APPR_SETUP_BEAN = list.get(0);
				} else if (list.size() == 0) {

					AddRow();
				}

				resetAllComponent();
				PM_IL_END_APPR_SETUP_BEAN.setRowSelected(true);
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
		return "";

	}
	public String postRecord() {
		String message = null;
		CommonUtils.clearMaps(this);
		PILM039_DELIGATE delegate = new PILM039_DELIGATE();
		try {
			if (PM_IL_END_APPR_SETUP_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				delegate.preInsertEndorsment(PM_IL_END_APPR_SETUP_BEAN);
				new CRUDHandler().executeInsert(PM_IL_END_APPR_SETUP_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				list.add(PM_IL_END_APPR_SETUP_BEAN);
			} else if (PM_IL_END_APPR_SETUP_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				delegate.preUpdateEndorsment(PM_IL_END_APPR_SETUP_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_END_APPR_SETUP_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
				
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord", message);
			PM_IL_END_APPR_SETUP_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
		return "";

	}
	// Added for grid implementation change, Added by: S.Mallika, Dated: 13-Feb-2009 ]

	public String getFilterByEAS_FM_END_CODE_DESC() {
		return filterByEAS_FM_END_CODE_DESC;
	}

	public void setFilterByEAS_FM_END_CODE_DESC(String filterByEAS_FM_END_CODE_DESC) {
		this.filterByEAS_FM_END_CODE_DESC = filterByEAS_FM_END_CODE_DESC;
	}

	public String getFilterByEAS_TO_END_CODE() {
		return filterByEAS_TO_END_CODE;
	}

	public void setFilterByEAS_TO_END_CODE(String filterByEAS_TO_END_CODE) {
		this.filterByEAS_TO_END_CODE = filterByEAS_TO_END_CODE;
	}

	public HtmlSelectOneMenu getCOMP_EAS_END_PROC_YN() {
		return COMP_EAS_END_PROC_YN;
	}

	public void setCOMP_EAS_END_PROC_YN(HtmlSelectOneMenu comp_eas_end_proc_yn) {
		COMP_EAS_END_PROC_YN = comp_eas_end_proc_yn;
	}

	public HtmlSelectOneMenu getCOMP_EAS_END_APPR_YN() {
		return COMP_EAS_END_APPR_YN;
	}

	public void setCOMP_EAS_END_APPR_YN(HtmlSelectOneMenu comp_eas_end_appr_yn) {
		COMP_EAS_END_APPR_YN = comp_eas_end_appr_yn;
	}

	private void prepareDropDowns(){
		try {
			setEAS_END_APPR_YN(ListItemUtil.getDropDownListValue(
					com.iii.premia.common.utils.CommonUtils.getConnection(), "PILM039",
					"PM_IL_END_APPR_SETUP",
					"PM_IL_END_APPR_SETUP.EAS_END_APPR_YN", "YESNO"));
			setEAS_END_PROC_YN(ListItemUtil.getDropDownListValue(
					com.iii.premia.common.utils.CommonUtils.getConnection(), "PILM039",
					"PM_IL_END_APPR_SETUP", "PM_IL_END_APPR_SETUP.EAS_END_PROC_YN", "YESNO"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setEAS_END_APPR_YN(List<SelectItem> eas_end_appr_yn) {
		EAS_END_APPR_YN = eas_end_appr_yn;
	}

	

	public void setEAS_END_PROC_YN(List<SelectItem> eas_end_proc_yn) {
		EAS_END_PROC_YN = eas_end_proc_yn;
	}

	public List<SelectItem> getEAS_END_APPR_YN() {
		return EAS_END_APPR_YN;
	}

	public List<SelectItem> getEAS_END_PROC_YN() {
		return EAS_END_PROC_YN;
	}

	public PILM039_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PILM039_HELPER helper) {
		this.helper = helper;
	}

	public PM_IL_APPR_SETUP_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PILM039_DELIGATE getDeligate() {
		return deligate;
	}

	public void setDeligate(PILM039_DELIGATE deligate) {
		this.deligate = deligate;
	}
}
