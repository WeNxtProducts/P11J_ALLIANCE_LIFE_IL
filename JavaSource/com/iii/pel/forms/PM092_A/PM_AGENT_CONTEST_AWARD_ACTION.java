package com.iii.pel.forms.PM092_A;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;


public class PM_AGENT_CONTEST_AWARD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ACA_AWARD_CODE_LABEL;

	private HtmlInputText COMP_ACA_AWARD_CODE;

	private HtmlOutputLabel COMP_UI_M_ACA_AWARD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACA_AWARD_CODE_DESC;

	private HtmlOutputLabel COMP_ACA_REMARKS_LABEL;

	private HtmlInputText COMP_ACA_REMARKS;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
    private String filterByACA_AWARD_CODE;
		
	private String filterByUI_M_ACA_AWARD_CODE_DESC;
	
	

	private PM_AGENT_CONTEST_AWARD PM_AGENT_CONTEST_AWARD_BEAN;
	
	//manually added
	private List <PM_AGENT_CONTEST_AWARD> recordList;
	private HtmlAjaxCommandButton COMP_ADD_ROW;
	private HtmlCommandButton COMP_REMOVE_ROW;
	private UIDataTable COMP_PM_AGENT_CONTEST_AWARD_TABLE;
	private List <PM_AGENT_CONTEST_AWARD> suggestionList;
	
	public PM092_A_COMPOSITE_ACTION compositeAction;
	
	public PM_AGENT_CONTEST_AWARD_ACTION() {
		PM_AGENT_CONTEST_AWARD_BEAN = new PM_AGENT_CONTEST_AWARD();
		if(this.recordList==null){
			this.recordList=new ArrayList<PM_AGENT_CONTEST_AWARD>();
		}
	}
	
	public List<PM_AGENT_CONTEST_AWARD> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<PM_AGENT_CONTEST_AWARD> suggestionList) {
		this.suggestionList = suggestionList;
	}

	
	
	public HtmlAjaxCommandButton getCOMP_ADD_ROW() {
		return COMP_ADD_ROW;
	}

	public void setCOMP_ADD_ROW(HtmlAjaxCommandButton comp_add_row) {
		COMP_ADD_ROW = comp_add_row;
	}


	public HtmlCommandButton getCOMP_REMOVE_ROW() {
		return COMP_REMOVE_ROW;
	}


	public void setCOMP_REMOVE_ROW(HtmlCommandButton comp_remove_row) {
		COMP_REMOVE_ROW = comp_remove_row;
	}


	

	public UIDataTable getCOMP_PM_AGENT_CONTEST_AWARD_TABLE() {
		return COMP_PM_AGENT_CONTEST_AWARD_TABLE;
	}

	public void setCOMP_PM_AGENT_CONTEST_AWARD_TABLE(
			UIDataTable comp_pm_agent_contest_award_table) {
		COMP_PM_AGENT_CONTEST_AWARD_TABLE = comp_pm_agent_contest_award_table;
	}

	public List<PM_AGENT_CONTEST_AWARD> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<PM_AGENT_CONTEST_AWARD> recordList) {
		this.recordList = recordList;
	}

	public HtmlOutputLabel getCOMP_ACA_AWARD_CODE_LABEL() {
		return COMP_ACA_AWARD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACA_AWARD_CODE() {
		return COMP_ACA_AWARD_CODE;
	}

	public void setCOMP_ACA_AWARD_CODE_LABEL(HtmlOutputLabel COMP_ACA_AWARD_CODE_LABEL) {
		this.COMP_ACA_AWARD_CODE_LABEL = COMP_ACA_AWARD_CODE_LABEL;
	}

	public void setCOMP_ACA_AWARD_CODE(HtmlInputText COMP_ACA_AWARD_CODE) {
		this.COMP_ACA_AWARD_CODE = COMP_ACA_AWARD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACA_AWARD_CODE_DESC_LABEL() {
		return COMP_UI_M_ACA_AWARD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACA_AWARD_CODE_DESC() {
		return COMP_UI_M_ACA_AWARD_CODE_DESC;
	}

	public void setCOMP_UI_M_ACA_AWARD_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ACA_AWARD_CODE_DESC_LABEL) {
		this.COMP_UI_M_ACA_AWARD_CODE_DESC_LABEL = COMP_UI_M_ACA_AWARD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACA_AWARD_CODE_DESC(HtmlInputText COMP_UI_M_ACA_AWARD_CODE_DESC) {
		this.COMP_UI_M_ACA_AWARD_CODE_DESC = COMP_UI_M_ACA_AWARD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_ACA_REMARKS_LABEL() {
		return COMP_ACA_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_ACA_REMARKS() {
		return COMP_ACA_REMARKS;
	}

	public void setCOMP_ACA_REMARKS_LABEL(HtmlOutputLabel COMP_ACA_REMARKS_LABEL) {
		this.COMP_ACA_REMARKS_LABEL = COMP_ACA_REMARKS_LABEL;
	}

	public void setCOMP_ACA_REMARKS(HtmlInputText COMP_ACA_REMARKS) {
		this.COMP_ACA_REMARKS = COMP_ACA_REMARKS;
	}

	public PM_AGENT_CONTEST_AWARD getPM_AGENT_CONTEST_AWARD_BEAN() {
		return PM_AGENT_CONTEST_AWARD_BEAN;
	}

	public void setPM_AGENT_CONTEST_AWARD_BEAN(PM_AGENT_CONTEST_AWARD PM_AGENT_CONTEST_AWARD_BEAN) {
		this.PM_AGENT_CONTEST_AWARD_BEAN = PM_AGENT_CONTEST_AWARD_BEAN;
	}
	
	public void addRowButtonClickAction(ActionEvent event){
		PM_AGENT_CONTEST_AWARD bean=new PM_AGENT_CONTEST_AWARD();
		setACA_ACH_CODE(bean);
		this.recordList.add(bean);
		System.out.println(recordList.size());
	}
	
	public List <PM_AGENT_CONTEST_AWARD> getLovForACA_AWARD_CODE (Object obj){
		String filterString=obj.toString().trim();
		PM_AGENT_CONTEST_AWARD_DELEGATE delegate=new PM_AGENT_CONTEST_AWARD_DELEGATE();
		System.out.println("Fetching List");
		this.suggestionList=delegate.getListForACA_AWARD_CODE(filterString);
		return suggestionList;
	}
	
	/*public void setFieldUI_M_ACA_AWARD_CODE_DESC(ActionEvent event){
		String selectedCoverCode=(String)((UIInput)(event.getComponent().getParent().getParent())).getSubmittedValue();
		boolean keepLooking=true;
		Iterator <PM_AGENT_CONTEST_AWARD> iterator=suggestionList.iterator();
		while(iterator.hasNext()&& keepLooking){
			PM_AGENT_CONTEST_AWARD suggestionListBean=(PM_AGENT_CONTEST_AWARD)iterator.next();
			String coverCode=(String)suggestionListBean.getACA_AWARD_CODE();
			if(selectedCoverCode.equals(coverCode)){
				System.out.println(selectedCoverCode+">>>>>>>>>"+coverCode);
//				int currentIndex=this.COMP_PM_AGENT_CONTEST_AWARD_TABLE.getRowIndex();
//				System.out.println("********"+currentIndex);
//				PM_AGENT_CONTEST_AWARD recordListBean=(PM_AGENT_CONTEST_AWARD)this.recordList.get(currentIndex);
//				PM_AGENT_CONTEST_AWARD_BEAN.setACA_AWARD_CODE(selectedCoverCode);
				PM_AGENT_CONTEST_AWARD_BEAN.setUI_M_ACA_AWARD_CODE_DESC(PM_AGENT_CONTEST_AWARD_BEAN.getUI_M_ACA_AWARD_CODE_DESC());
//				recordList.set(currentIndex, recordListBean);
				keepLooking=false;
			}
		}
	}*/
	
	/*public void setFieldUI_M_ACA_AWARD_CODE_DESC(ActionEvent event){
		System.out.println("PM_AGENT_CONTEST_AWARD_ACTION.setFieldUI_M_ACA_AWARD_CODE_DESC()");
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());	
	}*/
		
	/*[ BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	 * METHOD THROWS ValidatorException*/
	
	public void lastColumnListener()throws ValidatorException{
	
	/*BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	 * METHOD THROWS ValidatorException]*/
		boolean isNull=validateAWCVR_COVER_CODE();
		String message=null;
		System.out.println("Validating field isNull----->"+isNull);
		if(!isNull){
			System.out.println("saving Row Number--->"+this.COMP_PM_AGENT_CONTEST_AWARD_TABLE.getRowIndex());
			int currentIndex=this.COMP_PM_AGENT_CONTEST_AWARD_TABLE.getRowIndex();
			PM_AGENT_CONTEST_AWARD recordListBean=(PM_AGENT_CONTEST_AWARD)this.recordList.get(currentIndex);
			PM_AGENT_CONTEST_AWARD_DELEGATE delegate=new PM_AGENT_CONTEST_AWARD_DELEGATE();
			PM_AGENT_CONTEST_AWARD_HELPER helper=new PM_AGENT_CONTEST_AWARD_HELPER();
			
			if(recordListBean.getROWID()==null){
				helper.pmAgentContestAwardPreInsert(recordListBean);
				message=Messages.getString("messageProperties", "errorPanel$message$insert");
			}else{
				helper.pmAgentContestAwardPreUpdate(recordListBean);
				message=Messages.getString("messageProperties", "errorPanel$message$update");
			}
			
			delegate.saveRecord(recordListBean,false);
			if(message!=null){
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			}
			System.out.println("Row Saved");
		}
	}
	
	/*[ BugId:PREMIAGDC-INTERNALFIX-0022 VARUN DM 03-FEB-09 
	 *  UNECESSARY PART OF CODE REMOVED*/
	public void setACA_ACH_CODE(PM_AGENT_CONTEST_AWARD bean){
		CommonUtils utility=new CommonUtils();
		String mappedBeanName="PM092_A_COMPOSITE_ACTION";
		//get the selected code from session
		PM092_A_COMPOSITE_ACTION compositeActionBean=
			(PM092_A_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		String contestCode=compositeActionBean.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().getPM_AGENT_CONTEST_HDR_BEAN().getACH_CODE();
		
		//set it in the record to be inserted
		bean.setACA_ACH_CODE(contestCode);
		
	}
	/* BugId:PREMIAGDC-INTERNALFIX-0022 VARUN DM 03-FEB-09 
	 *  UNECESSARY PART OF CODE REMOVED]*/

	private boolean validateAWCVR_COVER_CODE() {
		boolean isNull=true;
		/*int currentIndex=this.COMP_PM_AGENT_CONTEST_AWARD_TABLE.getRowIndex();
		PM_AGENT_CONTEST_AWARD recordListBean=(PM_AGENT_CONTEST_AWARD)this.recordList.get(currentIndex);
		if(!(recordListBean.getACA_AWARD_CODE()==null) && 
				!(recordListBean.getACA_AWARD_CODE().trim()).equals(""))
		 isNull=false;*/
		return isNull;
	}
	
	public void checkBoxClickAction(ActionEvent event){
		
		int currentIndex=this.getCOMP_PM_AGENT_CONTEST_AWARD_TABLE().getRowIndex();
		String componentValue=
		(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		boolean isChecked=Boolean.parseBoolean(componentValue);
		PM_AGENT_CONTEST_AWARD recordListBean=(PM_AGENT_CONTEST_AWARD)this.recordList.get(currentIndex);
		recordListBean.setRowCheckBox(isChecked);
		System.out.println("record "+currentIndex+" check box value set to ---->"+isChecked);
		recordList.set(currentIndex, recordListBean);
		int iCount=0;
		for(iCount=0;iCount<recordList.size();iCount++){
			PM_AGENT_CONTEST_AWARD recordListBean1=(PM_AGENT_CONTEST_AWARD)this.recordList.get(iCount);
			System.out.println("Row "+iCount+" check value "+ recordListBean1.isRowCheckBox());
		}
	}
	// TODO prev button implementation
	
	public void deleteButtonClickAction(ActionEvent event){
		String message=null;
		PM_AGENT_CONTEST_AWARD_DELEGATE delegate=new PM_AGENT_CONTEST_AWARD_DELEGATE();
		delegate.deleteSelectedRows(this.recordList,true);	
		message=Messages.getString("messageProperties", "errorPanel$message$delete");
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
	}
	/* [BugId:PREMIAGDC-INTERNALFIX-0022 VARUN DM 03-FEB-09 
	 * VALIDATOR EXCEPTION THROWN BY lastColumnListener()  PUT IN errorMap*/
	public void validateACA_REMARKS(ActionEvent event){
		String remarks=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		System.out.println("remark vallue"+ remarks);
		this.PM_AGENT_CONTEST_AWARD_BEAN.setACA_REMARKS(remarks);
		try{
//			lastColumnListener(); Commented during Grid Standardisation
		}catch(ValidatorException e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}
	/* BugId:PREMIAGDC-INTERNALFIX-0022 VARUN DM 03-FEB-09 
	 * VALIDATOR EXCEPTION THROWN BY lastColumnListener()  PUT IN errorMap]*/
	
	
	/*[ BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	* CLEARING ERROR AND WARNING MAPS*/
	public String saveButtonClickAction(){
		clearMaps();
	/*BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	* CLEARING ERROR AND WARNING MAPS]*/
		String returnString="";
		String message=null;
		PM_AGENT_CONTEST_AWARD_DELEGATE delegate=new PM_AGENT_CONTEST_AWARD_DELEGATE();
		boolean status=delegate.commitData();
		if(status){
			message=Messages.getString("messageProperties", "errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		}
		return returnString;
	}
	
	/**
	 * Implementation of Tool Bar Functionalities.
	 */
	public String saveNextAction()
	{
		saveButtonClickAction();
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value  = pm092_a_composite_action.goToPM_AGENT_CONTEST_AWARD();
		pm092_a_composite_action.getTabbedBar().gotoNextTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(4);
		return value;
	}
	
	
	public String  nextIconAction()
	{
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value  = pm092_a_composite_action.goToPM_AGENT_CONTEST_AWARD();
		pm092_a_composite_action.getTabbedBar().gotoNextTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(4);
		return value;
	}
	
	public String  lastIconAction()
	{
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value  = pm092_a_composite_action.goToPM_AGENT_CONTEST_AWARD();
		pm092_a_composite_action.getTabbedBar().gotoLastTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(4);
		return value;
	}
	
	public String  firstIconAction()
	{
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value  = pm092_a_composite_action.goToPM_AGENT_CONTEST_HDR();
		pm092_a_composite_action.getTabbedBar().gotoFirstTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(1);
		return value;
	}
	
	public String  previousIconAction()
	{
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value  = pm092_a_composite_action.goToPM_AGENT_CONTEST_APPL_RANK();
		pm092_a_composite_action.getTabbedBar().gotoPrevTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(3);
		return value;
	}

	public String delete(){
		return "";
	}
	
	
	public void whenValidateAwardCode(FacesContext facesContext,UIComponent component,Object value){
	
		//String UI_M_ACA_AWARD_CODE_DESC = (String) value;
		
		//PM_AGENT_CONTEST_AWARD_BEAN.setUI_M_ACA_AWARD_CODE_DESC(UI_M_ACA_AWARD_CODE_DESC);
		Connection con= null;
		try {
			PM_AGENT_CONTEST_AWARD_HELPER helper = new PM_AGENT_CONTEST_AWARD_HELPER();
			String ACA_AWARD_CODE = (String) value;		
			con = CommonUtils.getConnection();
			PM_AGENT_CONTEST_AWARD_BEAN.setACA_AWARD_CODE(ACA_AWARD_CODE);
			helper.whenValidateAwardCode(getPM_AGENT_CONTEST_AWARD_BEAN());
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}  finally {
			ErrorHelpUtil.getWarningForProcedure(con, "ACA_AWARD_CODE", getWarningMap());
		}

		COMP_UI_M_ACA_AWARD_CODE_DESC.resetValue();
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		clearMaps();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
						
		if(input.isValid()){
//			lastColumnListener(); Commented During Grid implementation
		}
	}
	
	private void clearMaps(){
		getWarningMap().clear();
		getErrorMap().clear();
	}
	
	// [ Added for grid implementation change, Added by: Rajesh Kundala, Dated: 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = COMP_PM_AGENT_CONTEST_AWARD_TABLE.getRowIndex();

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
	
public void resetAllComponent(){
		
		
		// Reseting HtmlInputText
	COMP_ACA_AWARD_CODE.resetValue();
	COMP_UI_M_ACA_AWARD_CODE_DESC.resetValue();
	COMP_ACA_REMARKS.resetValue();
	
	}
// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_AGENT_CONTEST_AWARD> iterator = recordList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void getDetails() {
		try {
			if (recordList.size() != 0) {				
				PM_AGENT_CONTEST_AWARD_BEAN = (PM_AGENT_CONTEST_AWARD) COMP_PM_AGENT_CONTEST_AWARD_TABLE.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_AGENT_CONTEST_AWARD_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_AGENT_CONTEST_AWARD_BEAN = new PM_AGENT_CONTEST_AWARD();
				setACA_ACH_CODE(PM_AGENT_CONTEST_AWARD_BEAN);
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
				if(PM_AGENT_CONTEST_AWARD_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_AGENT_CONTEST_AWARD_BEAN, CommonUtils.getConnection());
					recordList.remove(PM_AGENT_CONTEST_AWARD_BEAN);
				}
				
				if(recordList.size() > 0) {
					setPM_AGENT_CONTEST_AWARD_BEAN(recordList.get(0));
					PM_AGENT_CONTEST_AWARD_BEAN.setRowSelected(true);
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
	PM_AGENT_CONTEST_AWARD_DELEGATE delegate=new PM_AGENT_CONTEST_AWARD_DELEGATE();
	PM_AGENT_CONTEST_AWARD_HELPER helper=new PM_AGENT_CONTEST_AWARD_HELPER();
	try{
		if(PM_AGENT_CONTEST_AWARD_BEAN.getROWID() != null) {
			if(isUPDATE_ALLOWED()) {
				helper.pmAgentContestAwardPreUpdate(PM_AGENT_CONTEST_AWARD_BEAN);
			    new CRUDHandler().executeInsert(PM_AGENT_CONTEST_AWARD_BEAN, CommonUtils.getConnection());
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
				helper.pmAgentContestAwardPreInsert(PM_AGENT_CONTEST_AWARD_BEAN);
				new CRUDHandler().executeInsert(PM_AGENT_CONTEST_AWARD_BEAN, CommonUtils.getConnection());					
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				getWarningMap().put("post",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				recordList.add(PM_AGENT_CONTEST_AWARD_BEAN);
			} else {
				getErrorMap().clear();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
			}
		}
		resetAllComponent();
		resetSelectedRow();
		PM_AGENT_CONTEST_AWARD_BEAN.setRowSelected(true);

	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("post", e.getMessage());
	}
}





	
	// Added for grid implementation change, Added by: Rajesh Kundala, Dated: 17-Feb-2009 ]

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

	public String getFilterByACA_AWARD_CODE() {
		return filterByACA_AWARD_CODE;
	}

	public void setFilterByACA_AWARD_CODE(String filterByACA_AWARD_CODE) {
		this.filterByACA_AWARD_CODE = filterByACA_AWARD_CODE;
	}

	public String getFilterByUI_M_ACA_AWARD_CODE_DESC() {
		return filterByUI_M_ACA_AWARD_CODE_DESC;
	}

	public void setFilterByUI_M_ACA_AWARD_CODE_DESC(
			String filterByUI_M_ACA_AWARD_CODE_DESC) {
		this.filterByUI_M_ACA_AWARD_CODE_DESC = filterByUI_M_ACA_AWARD_CODE_DESC;
	}
	
	/* BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	* CHANGE IN LOGIC FOR WHENVALIDATE OF AWARD CODE AND ITS AJAX CALL 
	* METHOD AND ADDED A METHOD clearMaps() FOR CLEARING ERROR AND WARNING MAPS]*/
}
