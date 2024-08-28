package com.iii.pel.forms.PILM002_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;



public class PM_IL_CVR_WAITING_PRD_ACTION extends CommonAction{

	
	private String filterByILLNESS_TYP;
	private String filterByWAITING_PRD;
	
	private HtmlOutputLabel COMP_CWP_ILLNESS_TYP_LABEL;

	private HtmlInputText COMP_CWP_ILLNESS_TYP;

	private HtmlOutputLabel COMP_CWP_WAITING_PRD_LABEL;

	private HtmlInputText COMP_CWP_WAITING_PRD;

	private HtmlOutputLabel COMP_CWP_FREEZE_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_CWP_FREEZE_FLAG;

	private PM_IL_CVR_WAITING_PRD PM_IL_CVR_WAITING_PRD_BEAN;
	
	//manually added
	private List <PM_IL_CVR_WAITING_PRD> recordList;
	private HtmlAjaxCommandButton COMP_ADD_ROW;
	//private HtmlCommandButton COMP_ADD_ROW;
	private HtmlAjaxCommandButton COMP_REMOVE_ROW;
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	private UIDataTable COMP_PM_IL_CVR_WAITING_PRD_TABLE;
	private List <PM_IL_CVR_WAITING_PRD> suggestionList;
	private int recordsPerPage=5;
	private int currPage;
	
	public PM_IL_CVR_WAITING_PRD_ACTION() {
		PM_IL_CVR_WAITING_PRD_BEAN = new PM_IL_CVR_WAITING_PRD();
		if(this.recordList==null){
			this.recordList=new ArrayList<PM_IL_CVR_WAITING_PRD>();
			currPage = 1;
		}
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


	public HtmlOutputLabel getCOMP_CWP_ILLNESS_TYP_LABEL() {
		return COMP_CWP_ILLNESS_TYP_LABEL;
	}

	public HtmlInputText getCOMP_CWP_ILLNESS_TYP() {
		return COMP_CWP_ILLNESS_TYP;
	}

	public void setCOMP_CWP_ILLNESS_TYP_LABEL(HtmlOutputLabel COMP_CWP_ILLNESS_TYP_LABEL) {
		this.COMP_CWP_ILLNESS_TYP_LABEL = COMP_CWP_ILLNESS_TYP_LABEL;
	}

	public void setCOMP_CWP_ILLNESS_TYP(HtmlInputText COMP_CWP_ILLNESS_TYP) {
		this.COMP_CWP_ILLNESS_TYP = COMP_CWP_ILLNESS_TYP;
	}

	public HtmlOutputLabel getCOMP_CWP_WAITING_PRD_LABEL() {
		return COMP_CWP_WAITING_PRD_LABEL;
	}

	public HtmlInputText getCOMP_CWP_WAITING_PRD() {
		return COMP_CWP_WAITING_PRD;
	}

	public void setCOMP_CWP_WAITING_PRD_LABEL(HtmlOutputLabel COMP_CWP_WAITING_PRD_LABEL) {
		this.COMP_CWP_WAITING_PRD_LABEL = COMP_CWP_WAITING_PRD_LABEL;
	}

	public void setCOMP_CWP_WAITING_PRD(HtmlInputText COMP_CWP_WAITING_PRD) {
		this.COMP_CWP_WAITING_PRD = COMP_CWP_WAITING_PRD;
	}

	public HtmlOutputLabel getCOMP_CWP_FREEZE_FLAG_LABEL() {
		return COMP_CWP_FREEZE_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_CWP_FREEZE_FLAG() {
		return COMP_CWP_FREEZE_FLAG;
	}

	public void setCOMP_CWP_FREEZE_FLAG_LABEL(HtmlOutputLabel COMP_CWP_FREEZE_FLAG_LABEL) {
		this.COMP_CWP_FREEZE_FLAG_LABEL = COMP_CWP_FREEZE_FLAG_LABEL;
	}

	public void setCOMP_CWP_FREEZE_FLAG(HtmlSelectBooleanCheckbox COMP_CWP_FREEZE_FLAG) {
		this.COMP_CWP_FREEZE_FLAG = COMP_CWP_FREEZE_FLAG;
	}

	public PM_IL_CVR_WAITING_PRD getPM_IL_CVR_WAITING_PRD_BEAN() {
		return PM_IL_CVR_WAITING_PRD_BEAN;
	}

	public void setPM_IL_CVR_WAITING_PRD_BEAN(PM_IL_CVR_WAITING_PRD PM_IL_CVR_WAITING_PRD_BEAN) {
		this.PM_IL_CVR_WAITING_PRD_BEAN = PM_IL_CVR_WAITING_PRD_BEAN;
	}

	public List<PM_IL_CVR_WAITING_PRD> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<PM_IL_CVR_WAITING_PRD> recordList) {
		this.recordList = recordList;
	}

	public HtmlAjaxCommandButton getCOMP_ADD_ROW() {
		return COMP_ADD_ROW;
	}

	public void setCOMP_ADD_ROW(HtmlAjaxCommandButton comp_add_row) {
		COMP_ADD_ROW = comp_add_row;
	}

	public UIDataTable getCOMP_PM_IL_CVR_WAITING_PRD_TABLE() {
		return COMP_PM_IL_CVR_WAITING_PRD_TABLE;
	}

	public void setCOMP_PM_IL_CVR_WAITING_PRD_TABLE(
			UIDataTable comp_pm_il_cvr_waiting_prd_table) {
		COMP_PM_IL_CVR_WAITING_PRD_TABLE = comp_pm_il_cvr_waiting_prd_table;
	}

	public List<PM_IL_CVR_WAITING_PRD> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<PM_IL_CVR_WAITING_PRD> suggestionList) {
		this.suggestionList = suggestionList;
	}
	
	public void addRowButtonClickAction(ActionEvent event){
		CommonUtils.clearMaps(this);
		PM_IL_CVR_WAITING_PRD bean=new PM_IL_CVR_WAITING_PRD();
		bean.setUI_CWP_FREEZE_FLAG(false);
		this.recordList.add(bean);
		int rowCount=this.COMP_PM_IL_CVR_WAITING_PRD_TABLE.getRowCount();
		currPage=rowCount/recordsPerPage;
		if(rowCount%recordsPerPage > 0){
			currPage++;
		}
		System.out.println(recordList.size());
	}
	
	public List <PM_IL_CVR_WAITING_PRD> getLovForCWP_ILLNESS_TYP(Object obj){
		String filterString=obj.toString().trim();
		PM_IL_CVR_WAITING_PRD_DELEGATE delegate=new PM_IL_CVR_WAITING_PRD_DELEGATE();
		System.out.println("Fetching List in WAITING_PRD");
		suggestionList=delegate.getListForCWP_ILLNESS_TYP(filterString);
		return suggestionList;
	}
	
	public void setFieldUI_CWP_ILLNESS_TYP_DESC(ActionEvent event){
		CommonUtils.clearMaps(this);
		String selectedCode=(String)((UIInput)(event.getComponent().getParent().getParent().findComponent("CWP_ILLNESS_TYP"))).getSubmittedValue();
		boolean keepLooking=true;
		Iterator <PM_IL_CVR_WAITING_PRD> iterator=suggestionList.iterator();
		while(iterator.hasNext()&& keepLooking){
			PM_IL_CVR_WAITING_PRD suggestionListBean=(PM_IL_CVR_WAITING_PRD)iterator.next();
			String illnessCode=(String)suggestionListBean.getCWP_ILLNESS_TYP();
			if(selectedCode.equals(illnessCode)){
				System.out.println(selectedCode+">>>>>>>>>"+illnessCode);
				int currentIndex=this.COMP_PM_IL_CVR_WAITING_PRD_TABLE.getRowIndex();
				System.out.println("********"+currentIndex);
				PM_IL_CVR_WAITING_PRD recordListBean=(PM_IL_CVR_WAITING_PRD)this.recordList.get(currentIndex);
				recordListBean.setUI_CWP_ILLNESS_TYP_DESC(suggestionListBean.getUI_CWP_ILLNESS_TYP_DESC());
				recordListBean.setCWP_ILLNESS_TYP(suggestionListBean.getCWP_ILLNESS_TYP());
				recordList.set(currentIndex, recordListBean);
				keepLooking=false;
			}
		}
	}
	


	public void freezeFlagWhenValidate(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		
	}
	
	public void lastColumnListener(ActionEvent event){
		CommonUtils.clearMaps(this);
		boolean isNull=isNullCWP_ILLNESS_TYP();
		System.out.println("Validating field isNull----->"+isNull);
		int currentIndex=this.COMP_PM_IL_CVR_WAITING_PRD_TABLE.getRowIndex();
		PM_IL_CVR_WAITING_PRD recordListBean=(PM_IL_CVR_WAITING_PRD)this.recordList.get(currentIndex);
		PM_IL_CVR_WAITING_PRD_HELPER helper=new PM_IL_CVR_WAITING_PRD_HELPER();
		PM_IL_CVR_WAITING_PRD_DELEGATE delegate=new PM_IL_CVR_WAITING_PRD_DELEGATE();
		if(!isNull){
			/*String flagValue=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			recordListBean.setUI_CWP_FREEZE_FLAG(Boolean.parseBoolean(flagValue));
			this.getPM_IL_CVR_WAITING_PRD_BEAN().setUI_CWP_FREEZE_FLAG(Boolean.parseBoolean(flagValue));*/
			System.out.println("saving Row Number--->"+this.COMP_PM_IL_CVR_WAITING_PRD_TABLE.getRowIndex());
			System.out.println("value  "+recordListBean.getCWP_WAITING_PRD());
			//setting the current value of the flag in the value bean
			
			
			if(recordListBean.getROWID()==null){
				if(this.isINSERT_ALLOWED()){
					//setting the CWP_COVER code field in the record to be inserted 
					setCWP_COVER_CODE();
					//call PRE-INSERT-TRIGGER
					helper.preInsert(PM_IL_CVR_WAITING_PRD_BEAN);
					//save but do not commit
					int count=delegate.saveRecord(recordListBean,false);
					this.getWarningMap().clear();
					//this.getWarningMap().put("key1", count+" row Inserted");
					this.getWarningMap().put("current", count+" row Inserted");
					System.out.println("Row Saved");
				}
			}else{
				if(this.isUPDATE_ALLOWED()){
					//call PRE-UPDATE-TRIGGER
					//helper.preUpdate();
					//save but do not commit
					int count=delegate.saveRecord(recordListBean,false);
					this.getWarningMap().clear();
					//this.getWarningMap().put("key1", count+" row Updated");
					this.getWarningMap().put("current", count+" row Updated");
					System.out.println("Row updated");
				}
			}
		}
	}
	
	public void setCWP_COVER_CODE(){
		CommonUtils utility=new CommonUtils();
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		//get the selected code from session
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		String coverCode=compositeActionBean.getPM_IL_COVER_ACTION_BEAN().getPM_IL_COVER_BEAN().getCOVER_CODE();
		//get action bean
		PM_IL_CVR_WAITING_PRD_ACTION actionBean=compositeActionBean.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN();
		//set it in the record to be inserted
		//int currentIndex=this.COMP_PM_IL_CVR_WAITING_PRD_TABLE.getRowIndex();
//		List recordList=compositeActionBean.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN().getRecordList();
//		((PM_IL_CVR_WAITING_PRD)recordList.get(currentIndex)).setCWP_COVER_CODE(coverCode);
		this.PM_IL_CVR_WAITING_PRD_BEAN.setCWP_COVER_CODE(coverCode);
	}

	private boolean isNullCWP_ILLNESS_TYP() {
		boolean isNull=true;
		//int currentIndex=this.COMP_PM_IL_CVR_WAITING_PRD_TABLE.getRowIndex();
		//PM_IL_CVR_WAITING_PRD recordListBean=(PM_IL_CVR_WAITING_PRD)this.recordList.get(currentIndex);
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
					(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_CVR_WAITING_PRD_ACTION actionBean=compositeActionBean.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN();
		PM_IL_CVR_WAITING_PRD recordListBean=(PM_IL_CVR_WAITING_PRD)actionBean.getPM_IL_CVR_WAITING_PRD_BEAN();
		if(!(recordListBean.getCWP_ILLNESS_TYP()==null) && 
				!(recordListBean.getCWP_ILLNESS_TYP().trim()).equals(""))
		 isNull=false;
		return isNull;
	}
	
	public void checkBoxClickAction(ActionEvent event){
		
		int currentIndex=this.getCOMP_PM_IL_CVR_WAITING_PRD_TABLE().getRowIndex();
		String componentValue=
		(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();;
		boolean isChecked=Boolean.parseBoolean(componentValue);
		PM_IL_CVR_WAITING_PRD recordListBean=(PM_IL_CVR_WAITING_PRD)this.recordList.get(currentIndex);
		recordListBean.setRowCheckBox(isChecked);
		System.out.println("record "+currentIndex+" check box value set to ---->"+isChecked);
		recordList.set(currentIndex, recordListBean);
		int iCount=0;
		for(iCount=0;iCount<recordList.size();iCount++){
			PM_IL_CVR_WAITING_PRD recordListBean1=(PM_IL_CVR_WAITING_PRD)this.recordList.get(iCount);
			System.out.println("Row "+iCount+" check value "+ recordListBean1.isRowCheckBox());
		}
	}

	public String deleteButtonClickAction(){
		String returnString="";
		if(this.isDELETE_ALLOWED()){
			PM_IL_CVR_WAITING_PRD_DELEGATE delegate=new PM_IL_CVR_WAITING_PRD_DELEGATE();
			int count=delegate.deleteSelectedRows(this.recordList,false);
			this.getWarningMap().clear();
			//this.getWarningMap().put("key1", count+" row Deleted");
			this.getWarningMap().put("current", count+" row Deleted");
			System.out.println("Deleted");
		}
		return returnString;
	}
	
	
	public String saveButtonClickAction(){
		String returnString="";
		PM_IL_CVR_WAITING_PRD_DELEGATE delegate=new PM_IL_CVR_WAITING_PRD_DELEGATE();
		boolean status=delegate.commitData();
		getWarningMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_UPDATE_MESSAGE"));
		getWarningMap().put("somekey", Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_UPDATE_MESSAGE"));

		return returnString;
	}
	
	public String previousPageButtonAction(){
		String returnString="GO_TO_PILM002_APAC_PM_IL_APPL_WOP_COVER";
		return returnString;
	}
	/**
	 * This method is called on blur. This method will call the validate method 
	 * in ErrorHelpUtil class which internally calls validator method applied on 
	 * CWP_ILLNESS_TYP field  
	 * @param event
	 * @return
	 * @throws 
	 */
	public void whenValidateItemCWP_ILLNESS_TYP(ActionEvent event){
		CommonUtils.clearMaps(this);
		System.out.println("*******calling validator for CWP_ILLNESS_TYP on blur************");
		UIInput component=(UIInput)(event.getComponent().getParent());
		ErrorHelpUtil.validate(component, getErrorMap());
		System.out.println("*******calling validator for CWP_ILLNESS_TYP on blur ends************");
	}
	/**
	 * Validator method for validating field CWP_ILLNESS_TYP 
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws 
	 */
	public void validateCWP_ILLNESS_TYP(FacesContext context, UIComponent component,
			Object value){
		System.out.println("*******Validator method for validating CWP_ILLNESS_TYP ************");
		PM_IL_CVR_WAITING_PRD_HELPER helper=new PM_IL_CVR_WAITING_PRD_HELPER();
		try {
			//calling WHEN-VALIDATE-ITEM trigger in helper
			helper.whenValidateItemCWP_ILLNESS_TYP(component,value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		System.out.println("*******Validator method for validating CWP_ILLNESS_TYP end************");
	}
	
	/**
	 * This method is called on blur. This method will call the validate method 
	 * in ErrorHelpUtil class which internally calls validator method applied on 
	 * CWP_WAITING_PRD field  
	 * @param event
	 * @return
	 * @throws 
	 */
	public void whenValidateItemCWP_WAITING_PRD(ActionEvent event){
		CommonUtils.clearMaps(this);
		System.out.println("*******calling validator for CWP_WAITING_PRD on blur************");
		UIInput component=(UIInput)(event.getComponent().getParent());
		ErrorHelpUtil.validate(component, getErrorMap());
		System.out.println("*******calling validator for CWP_WAITING_PRD on blur ends************");
	}
	/**
	 * Validator method for validating field CWP_WAITING_PRD 
	 * @param FacesContext context
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws 
	 */
	public void validateCWP_WAITING_PRD(FacesContext context, UIComponent component,
			Object value){
		System.out.println("*******Validator method for validating CWP_WAITING_PRD ************");
		PM_IL_CVR_WAITING_PRD_HELPER helper=new PM_IL_CVR_WAITING_PRD_HELPER();
		try {
			//calling WHEN-VALIDATE-ITEM trigger in helper
			helper.whenValidateItemCWP_WAITING_PRD(component,value);
			//setting value in the bean
			//int currentIndex=this.COMP_PM_IL_CVR_WAITING_PRD_TABLE.getRowIndex();
			//PM_IL_CVR_WAITING_PRD recordListBean=(PM_IL_CVR_WAITING_PRD)this.recordList.get(currentIndex);
			PM_IL_CVR_WAITING_PRD recordListBean=this.getPM_IL_CVR_WAITING_PRD_BEAN();
			recordListBean.setCWP_WAITING_PRD((Double)value);
			//recordList.set(currentIndex, recordListBean);
			//System.out.println("setting value in record --->"+ currentIndex);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		System.out.println("*******Validator method for validating CWP_WAITING_PRD end************");
	}
	
	// [ Added for grid implementation change, Added by: Rajesh Kundala, Dated: 13-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(ActionEvent event) {
		String outcome = null;
		int rowIndex = COMP_PM_IL_CVR_WAITING_PRD_TABLE.getRowIndex();
		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				lastColumnListener(event);

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
	// Added for grid implementation change, Added by: Rajesh Kundala, Dated: 13-Feb-2009 ]

	/**
	 * @return the filterByILLNESS_TYP
	 */
	public String getFilterByILLNESS_TYP() {
		return filterByILLNESS_TYP;
	}

	/**
	 * @param filterByILLNESS_TYP the filterByILLNESS_TYP to set
	 */
	public void setFilterByILLNESS_TYP(String filterByILLNESS_TYP) {
		this.filterByILLNESS_TYP = filterByILLNESS_TYP;
	}

	/**
	 * @return the filterByWAITING_PRD
	 */
	public String getFilterByWAITING_PRD() {
		return filterByWAITING_PRD;
	}

	/**
	 * @param filterByWAITING_PRD the filterByWAITING_PRD to set
	 */
	public void setFilterByWAITING_PRD(String filterByWAITING_PRD) {
		this.filterByWAITING_PRD = filterByWAITING_PRD;
	}

	/**
	 * @return the cOMP_REMOVE_ROW
	 */
	public HtmlAjaxCommandButton getCOMP_REMOVE_ROW() {
		return COMP_REMOVE_ROW;
	}

	/**
	 * @param comp_remove_row the cOMP_REMOVE_ROW to set
	 */
	public void setCOMP_REMOVE_ROW(HtmlAjaxCommandButton comp_remove_row) {
		COMP_REMOVE_ROW = comp_remove_row;
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
	
	public void getDetails() {
		try {
			if (recordList.size() != 0) {				
				PM_IL_CVR_WAITING_PRD_BEAN = (PM_IL_CVR_WAITING_PRD) COMP_PM_IL_CVR_WAITING_PRD_TABLE.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_CVR_WAITING_PRD_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent(){
		
		COMP_CWP_ILLNESS_TYP.resetValue();
		COMP_CWP_WAITING_PRD.resetValue();
		COMP_CWP_FREEZE_FLAG.resetValue();
	}
	
	private void resetSelectedRow() {
		Iterator<PM_IL_CVR_WAITING_PRD> iterator = recordList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_IL_CVR_WAITING_PRD_BEAN = new PM_IL_CVR_WAITING_PRD();
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
	
	public void deleteRow(ActionEvent ae) {
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();

			if(isDELETE_ALLOWED()) {
				if(PM_IL_CVR_WAITING_PRD_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_IL_CVR_WAITING_PRD_BEAN, CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					recordList.remove(PM_IL_CVR_WAITING_PRD_BEAN);
				}
				
				if(recordList.size() > 0) {
					setPM_IL_CVR_WAITING_PRD_BEAN(recordList.get(0));
					PM_IL_CVR_WAITING_PRD_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				getWarningMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}

	public void post(ActionEvent ae) {
		
		boolean isNull=isNullCWP_ILLNESS_TYP();
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
					(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_CVR_WAITING_PRD_ACTION actionBean=compositeActionBean.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN();
		PM_IL_CVR_WAITING_PRD PM_IL_CVR_WAITING_PRD_BEAN=(PM_IL_CVR_WAITING_PRD)actionBean.getPM_IL_CVR_WAITING_PRD_BEAN();
		
		PM_IL_CVR_WAITING_PRD_HELPER helper = new PM_IL_CVR_WAITING_PRD_HELPER();
		PM_IL_CVR_WAITING_PRD_DELEGATE delegate=new PM_IL_CVR_WAITING_PRD_DELEGATE();
		
		if(!isNull){
		try {

			ControlBean controlBean = CommonUtils.getControlBean();
			if (PM_IL_CVR_WAITING_PRD_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.preUpdate(PM_IL_CVR_WAITING_PRD_BEAN);
					new CRUDHandler().executeInsert(PM_IL_CVR_WAITING_PRD_BEAN,
							new CommonUtils().getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
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
					//setting the CWP_COVER code field in the record to be inserted 
					setCWP_COVER_CODE();
					helper.preInsert(PM_IL_CVR_WAITING_PRD_BEAN);
					new CRUDHandler().executeInsert(PM_IL_CVR_WAITING_PRD_BEAN,
							new CommonUtils().getConnection());
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

					recordList.add(PM_IL_CVR_WAITING_PRD_BEAN);
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
			resetAllComponent();
			resetSelectedRow();
			PM_IL_CVR_WAITING_PRD_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
		}
	}
	
}
