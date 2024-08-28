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



public class PM_AGENT_CONTEST_APPL_RANK_ACTION  extends CommonAction{

	private HtmlOutputLabel COMP_ACAR_RANK_CODE_LABEL;

	private HtmlInputText COMP_ACAR_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_ACAR_RANK_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACAR_RANK_CODE_DESC;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
    private String filterByACAR_RANK_CODE;
		
	private String filterByUI_M_ACAR_RANK_CODE_DESC;
	
	public PM092_A_COMPOSITE_ACTION compositeAction;

	private PM_AGENT_CONTEST_APPL_RANK PM_AGENT_CONTEST_APPL_RANK_BEAN;

	
	//manually added
	private List <PM_AGENT_CONTEST_APPL_RANK> recordList;
	private HtmlAjaxCommandButton COMP_ADD_ROW;
	private HtmlCommandButton COMP_REMOVE_ROW;
	private UIDataTable COMP_PM_AGENT_CONTEST_APPL_RANK_TABLE;
	private List <PM_AGENT_CONTEST_APPL_RANK> suggestionList;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;
	
	private int currentpage;
	private int recordsperPage = 5;
	

	public PM_AGENT_CONTEST_APPL_RANK_ACTION() {
		PM_AGENT_CONTEST_APPL_RANK_BEAN = new PM_AGENT_CONTEST_APPL_RANK();
		if(this.recordList==null){
			this.recordList=new ArrayList<PM_AGENT_CONTEST_APPL_RANK>();
		}
	}
	
	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public List<PM_AGENT_CONTEST_APPL_RANK> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<PM_AGENT_CONTEST_APPL_RANK> suggestionList) {
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

	public UIDataTable getCOMP_PM_AGENT_CONTEST_APPL_RANK_TABLE() {
		return COMP_PM_AGENT_CONTEST_APPL_RANK_TABLE;
	}

	public void setCOMP_PM_AGENT_CONTEST_APPL_RANK_TABLE(
			UIDataTable comp_pm_agent_contest_appl_rank_table) {
		COMP_PM_AGENT_CONTEST_APPL_RANK_TABLE = comp_pm_agent_contest_appl_rank_table;
	}


	public HtmlOutputLabel getCOMP_ACAR_RANK_CODE_LABEL() {
		return COMP_ACAR_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACAR_RANK_CODE() {
		return COMP_ACAR_RANK_CODE;
	}

	public void setCOMP_ACAR_RANK_CODE_LABEL(HtmlOutputLabel COMP_ACAR_RANK_CODE_LABEL) {
		this.COMP_ACAR_RANK_CODE_LABEL = COMP_ACAR_RANK_CODE_LABEL;
	}

	public void setCOMP_ACAR_RANK_CODE(HtmlInputText COMP_ACAR_RANK_CODE) {
		this.COMP_ACAR_RANK_CODE = COMP_ACAR_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACAR_RANK_CODE_DESC_LABEL() {
		return COMP_UI_M_ACAR_RANK_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACAR_RANK_CODE_DESC() {
		return COMP_UI_M_ACAR_RANK_CODE_DESC;
	}

	public void setCOMP_UI_M_ACAR_RANK_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ACAR_RANK_CODE_DESC_LABEL) {
		this.COMP_UI_M_ACAR_RANK_CODE_DESC_LABEL = COMP_UI_M_ACAR_RANK_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACAR_RANK_CODE_DESC(HtmlInputText COMP_UI_M_ACAR_RANK_CODE_DESC) {
		this.COMP_UI_M_ACAR_RANK_CODE_DESC = COMP_UI_M_ACAR_RANK_CODE_DESC;
	}

	public PM_AGENT_CONTEST_APPL_RANK getPM_AGENT_CONTEST_APPL_RANK_BEAN() {
		return PM_AGENT_CONTEST_APPL_RANK_BEAN;
	}

	public void setPM_AGENT_CONTEST_APPL_RANK_BEAN(PM_AGENT_CONTEST_APPL_RANK PM_AGENT_CONTEST_APPL_RANK_BEAN) {
		this.PM_AGENT_CONTEST_APPL_RANK_BEAN = PM_AGENT_CONTEST_APPL_RANK_BEAN;
	}

	public List<PM_AGENT_CONTEST_APPL_RANK> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<PM_AGENT_CONTEST_APPL_RANK> recordList) {
		this.recordList = recordList;
	}
	
	public List <PM_AGENT_CONTEST_APPL_RANK> getLovForACAR_RANK_CODE(Object obj){
		String filterString=obj.toString().trim();
		PM_AGENT_CONTEST_APPL_RANK_DELEGATE delegate=new PM_AGENT_CONTEST_APPL_RANK_DELEGATE();
		System.out.println("Fetching List");
		suggestionList=delegate.getListForACAR_RANK_CODE(filterString);
		return suggestionList;
	}
	
/*	public void setFieldUI_M_ACAR_RANK_CODE_DESC(ActionEvent event){
		String selectedCoverCode=(String)((UIInput)(event.getComponent().getParent().getParent())).getSubmittedValue();
		boolean keepLooking=true;
		Iterator <PM_AGENT_CONTEST_APPL_RANK> iterator=suggestionList.iterator();
		while(iterator.hasNext()&& keepLooking){
			PM_AGENT_CONTEST_APPL_RANK suggestionListBean=(PM_AGENT_CONTEST_APPL_RANK)iterator.next();
			String rankCode=(String)suggestionListBean.getACAR_RANK_CODE();
			if(selectedCoverCode.equals(rankCode)){
				System.out.println(selectedCoverCode+">>>>>>>>>"+rankCode);
//				int currentIndex=this.COMP_PM_AGENT_CONTEST_APPL_RANK_TABLE.getRowIndex();
//				System.out.println("********"+currentIndex);
//				PM_AGENT_CONTEST_APPL_RANK recordListBean=(PM_AGENT_CONTEST_APPL_RANK)this.recordList.get(currentIndex);
				PM_AGENT_CONTEST_APPL_RANK_BEAN.setACAR_RANK_CODE(selectedCoverCode);
				PM_AGENT_CONTEST_APPL_RANK_BEAN.setUI_M_ACAR_RANK_CODE_DESC(suggestionListBean.getUI_M_ACAR_RANK_CODE_DESC());
//				recordList.set(currentIndex, recordListBean);
				keepLooking=false;
			}
		}
	}*/
				
			
		
	
	/*public void addRowButtonClickAction(ActionEvent event){
		PM_AGENT_CONTEST_APPL_RANK bean=new PM_AGENT_CONTEST_APPL_RANK();
		setACAR_ACH_CODE(bean);
		this.recordList.add(bean);
		System.out.println(recordList.size());
	}
	*/
	
	/*public String addNew() {
	
		int rowCount = 0;
		if (recordList == null) {
			recordList = new ArrayList<PM_AGENT_CONTEST_APPL_RANK>();
		}
		
		PM_AGENT_CONTEST_APPL_RANK applRankBean=new PM_AGENT_CONTEST_APPL_RANK();
		setACAR_ACH_CODE(applRankBean);
		recordList.add(applRankBean);
		// Settings to navigate to last page
		rowCount = getCOMP_PM_AGENT_CONTEST_APPL_RANK_TABLE().getRowCount();
		currentpage = rowCount / recordsperPage;
		if (rowCount % recordsperPage > 0) {
			currentpage++;
		}

		return "";
	}*/
	
/*	public void gridtabListener(){
		
		int currRowIndex = this.COMP_PM_AGENT_CONTEST_APPL_RANK_TABLE.getRowIndex();
		int rowUpdated = 0;
		PM_AGENT_CONTEST_APPL_RANK recordListValueBean = null;
		System.out.println(lastUpdatedRowIndex+"   "+currRowIndex+"  "+prevRowIndex);
		try {
			if(lastUpdatedRowIndex!=-1)
			{
				if(lastUpdatedRowIndex!=prevRowIndex)
				{
					if(currRowIndex != prevRowIndex){
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						recordListValueBean = (PM_AGENT_CONTEST_APPL_RANK)recordList.get(prevRowIndex);
						// Update the record to database
						if(recordListValueBean.getROWID()==null){
								setACAR_ACH_CODE();	
						}
						PM_AGENT_CONTEST_APPL_RANK_DELEGATE delegate=new PM_AGENT_CONTEST_APPL_RANK_DELEGATE();
						delegate.saveRecord(recordListValueBean,false);
						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
		}
		
		return ;
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
			System.out.println("saving Row Number--->"+this.COMP_PM_AGENT_CONTEST_APPL_RANK_TABLE.getRowIndex());
			int currentIndex=this.COMP_PM_AGENT_CONTEST_APPL_RANK_TABLE.getRowIndex();
			PM_AGENT_CONTEST_APPL_RANK recordListBean=(PM_AGENT_CONTEST_APPL_RANK)this.recordList.get(currentIndex);
			PM_AGENT_CONTEST_APPL_RANK_DELEGATE delegate=new PM_AGENT_CONTEST_APPL_RANK_DELEGATE();
			PM_AGENT_CONTEST_APPL_RANK_HELPER helper=new PM_AGENT_CONTEST_APPL_RANK_HELPER();
			if(recordListBean.getROWID()==null){
				helper.pmAgentContestApplRankPreInsert(recordListBean);
				message=Messages.getString("messageProperties", "errorPanel$message$insert");
			}else{
				helper.pmAgentContestApplRankPreUpdate(recordListBean);
				message=Messages.getString("messageProperties", "errorPanel$message$update");
			}
			delegate.saveRecord(recordListBean,false);
			
			if(message!=null){
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			}
			System.out.println("Row Saved");
			lastUpdatedRowIndex = currentIndex;
		}
	}
	
	public void setACAR_ACH_CODE(PM_AGENT_CONTEST_APPL_RANK applRankBean){
		CommonUtils utility=new CommonUtils();
		String mappedBeanName="PM092_A_COMPOSITE_ACTION";
		//get the selected code from session
		PM092_A_COMPOSITE_ACTION compositeActionBean=
			(PM092_A_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		String contestCode=compositeActionBean.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().getPM_AGENT_CONTEST_HDR_BEAN().getACH_CODE();
		applRankBean.setACAR_ACH_CODE(contestCode);
	}
	
	private boolean validateAWCVR_COVER_CODE() {
		
	boolean isNull=true;
		/*int currentIndex=this.COMP_PM_AGENT_CONTEST_APPL_RANK_TABLE.getRowIndex();
		PM_AGENT_CONTEST_APPL_RANK recordListBean=(PM_AGENT_CONTEST_APPL_RANK)this.recordList.get(currentIndex);
		if(!(recordListBean.getACAR_RANK_CODE()==null) && 
				!(recordListBean.getACAR_RANK_CODE().trim()).equals(""))
		 isNull=false;*/
		return isNull;
	}
	
	
	public void checkBoxClickAction(ActionEvent event){
		
		int currentIndex=this.getCOMP_PM_AGENT_CONTEST_APPL_RANK_TABLE().getRowIndex();
		String componentValue=
		(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();;
		boolean isChecked=Boolean.parseBoolean(componentValue);
		PM_AGENT_CONTEST_APPL_RANK recordListBean=(PM_AGENT_CONTEST_APPL_RANK)this.recordList.get(currentIndex);
		recordListBean.setRowCheckBox(isChecked);
		System.out.println("record "+currentIndex+" check box value set to ---->"+isChecked);
		recordList.set(currentIndex, recordListBean);
		int iCount=0;
		for(iCount=0;iCount<recordList.size();iCount++){
			PM_AGENT_CONTEST_APPL_RANK recordListBean1=(PM_AGENT_CONTEST_APPL_RANK)this.recordList.get(iCount);
			System.out.println("Row "+iCount+" check value "+ recordListBean1.isRowCheckBox());
		}
	}
	// TODO prev button implementation

	
	public String deleteButtonClickAction(){
		String returnString="";
		String message=null;
		PM_AGENT_CONTEST_APPL_RANK_DELEGATE delegate=new PM_AGENT_CONTEST_APPL_RANK_DELEGATE();
		delegate.deleteSelectedRows(this.recordList,false);	
		lastUpdatedRowIndex = -1;
		message=Messages.getString("messageProperties", "errorPanel$message$delete");
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
		return returnString;
	}
	
	/*[ BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	* CALLING clearMaps() TO CLEAR ERRORS AND WARNINGS*/
	public String saveButtonClickAction(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString("messageProperties", "errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,Messages.getString("messageProperties", "errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("commkey", "Error on commit, cause: "+e.getMessage());
			getErrorMap().put("current", "Error on commit");
		}
		return null;
	}
	public String saveNextButtonClickAction(){
		String returnString="GO_TO_PM092_A_PM_AGENT_CONTEST_AWARD";
		String message=null;
		PM_AGENT_CONTEST_APPL_RANK_DELEGATE delegate=new PM_AGENT_CONTEST_APPL_RANK_DELEGATE();
		boolean status=delegate.commitData();
		if(status){
			message=Messages.getString("messageProperties", "errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		}
		populateBlockPM_AGENT_CONTEST_AWARD();
		return returnString;
	}
	
	public String nextPageButtonClickAction(){
		String returnString="GO_TO_PM092_A_PM_AGENT_CONTEST_AWARD";
		populateBlockPM_AGENT_CONTEST_AWARD();
		return returnString;
	}
	
	public void populateBlockPM_AGENT_CONTEST_AWARD(){
		//get details from database for the block
		PM_AGENT_CONTEST_AWARD_DELEGATE delegate= new PM_AGENT_CONTEST_AWARD_DELEGATE();
		List dataList=new ArrayList<PM_AGENT_CONTEST_APPL_RANK>();
		dataList=delegate.getBlockDataForPM_AGENT_CONTEST_AWARD();
		System.out.println("size of list-------------"+dataList.size());
		//Populate the block
		String mappedBeanName="PM092_A_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PM092_A_COMPOSITE_ACTION compositeActionBean=
			(PM092_A_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		compositeActionBean.getPM_AGENT_CONTEST_AWARD_ACTION_BEAN().setRecordList(dataList);
	}
	
	/**
	 * Implementation of Tool Bar Functionalities.
	 */
	public String saveNextAction()
	{
		saveButtonClickAction();
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value  = pm092_a_composite_action.goToPM_AGENT_CONTEST_DTL();
		pm092_a_composite_action.getTabbedBar().gotoNextTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(4);
		return value;
	}
	
	
	public String  nextIconAction()
	{
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value  = pm092_a_composite_action.goToPM_AGENT_CONTEST_DTL();
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
		String value  = pm092_a_composite_action.goToPM_AGENT_CONTEST_HDR();
		pm092_a_composite_action.getTabbedBar().gotoPrevTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(2);
		return value;
	}
	
	/*[BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	* MODIFICATIONS IN LOGIC OF METHODS CALLED AT rankCode Validator
	* AND ITS AJAX CALL METHOD*/
	
	public void whenValidateAcarRankCode(FacesContext facesContext,UIComponent component, Object value) throws ValidatorException {
		Connection con= null;
		try {
			
			PM_AGENT_CONTEST_APPL_RANK_HELPER helper = new PM_AGENT_CONTEST_APPL_RANK_HELPER();
			String ACAR_RANK_CODE = (String) value;
			con = CommonUtils.getConnection();

			PM_AGENT_CONTEST_APPL_RANK_BEAN.setACAR_RANK_CODE(ACAR_RANK_CODE);
			helper.whenValidateAcarRankCode(getPM_AGENT_CONTEST_APPL_RANK_BEAN());
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}  finally {
			ErrorHelpUtil.getWarningForProcedure(con, "ACAR_RANK_CODE", getWarningMap());
		}

		COMP_UI_M_ACAR_RANK_CODE_DESC.resetValue();
	}

		
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		try{
			
			if(input.isValid()){
//				lastColumnListener();Commented During Grid Standardisation
			}
		}catch(ValidatorException exception){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exception.getMessage());
		}
	}

		/*BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
		* MODIFICATIONS IN LOGIC OF METHODS CALLED AT rankCode Validator
		* AND ITS AJAX CALL METHOD]*/
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
	/*[ BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	* NEW METHOD ADDED clearMaps() YO CLEAR ERROR AND WARNING MAPS*/
	private void clearMaps(){
		getWarningMap().clear();
		getErrorMap().clear();
	}
	/*BugId:PREMIAGDC-INTERNALFIX-0027 VARUN DM 04-FEB-09 
	* NEW METHOD ADDED clearMaps() YO CLEAR ERROR AND WARNING MAPS]*/
	
	// [ Added for grid implementation change, Added by: Rajesh Kundala, Dated: 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = COMP_PM_AGENT_CONTEST_APPL_RANK_TABLE.getRowIndex();

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
	COMP_ACAR_RANK_CODE.resetValue();
	COMP_UI_M_ACAR_RANK_CODE_DESC.resetValue();
	COMP_ACAR_RANK_CODE.resetValue();
	 
	}
// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_AGENT_CONTEST_APPL_RANK> iterator = recordList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void getDetails() {
		try {
			if (recordList.size() != 0) {				
				PM_AGENT_CONTEST_APPL_RANK_BEAN = (PM_AGENT_CONTEST_APPL_RANK) COMP_PM_AGENT_CONTEST_APPL_RANK_TABLE.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_AGENT_CONTEST_APPL_RANK_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PM_AGENT_CONTEST_APPL_RANK_BEAN=null;
			if (isINSERT_ALLOWED()){		
				PM_AGENT_CONTEST_APPL_RANK_BEAN = new PM_AGENT_CONTEST_APPL_RANK();
				setACAR_ACH_CODE(PM_AGENT_CONTEST_APPL_RANK_BEAN);
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
				if(PM_AGENT_CONTEST_APPL_RANK_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_AGENT_CONTEST_APPL_RANK_BEAN, CommonUtils.getConnection());
					recordList.remove(PM_AGENT_CONTEST_APPL_RANK_BEAN);
				}
				
				if(recordList.size() > 0) {
					setPM_AGENT_CONTEST_APPL_RANK_BEAN(recordList.get(0));
					PM_AGENT_CONTEST_APPL_RANK_BEAN.setRowSelected(true);
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
	PM_AGENT_CONTEST_APPL_RANK_DELEGATE delegate=new PM_AGENT_CONTEST_APPL_RANK_DELEGATE();
	PM_AGENT_CONTEST_APPL_RANK_HELPER helper=new PM_AGENT_CONTEST_APPL_RANK_HELPER();
	try{
		if(PM_AGENT_CONTEST_APPL_RANK_BEAN.getROWID() != null) {
			if(isUPDATE_ALLOWED()) {
				helper.pmAgentContestApplRankPreUpdate(PM_AGENT_CONTEST_APPL_RANK_BEAN);
			    new CRUDHandler().executeInsert(PM_AGENT_CONTEST_APPL_RANK_BEAN, CommonUtils.getConnection());
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
				helper.pmAgentContestApplRankPreInsert(PM_AGENT_CONTEST_APPL_RANK_BEAN);
				new CRUDHandler().executeInsert(PM_AGENT_CONTEST_APPL_RANK_BEAN, CommonUtils.getConnection());					
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				getWarningMap().put("post",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				recordList.add(PM_AGENT_CONTEST_APPL_RANK_BEAN);
				
			} else {
				getErrorMap().clear();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
			}
		}
		resetAllComponent();
		resetSelectedRow();
		PM_AGENT_CONTEST_APPL_RANK_BEAN.setRowSelected(true);

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

	public String getFilterByACAR_RANK_CODE() {
		return filterByACAR_RANK_CODE;
	}

	public void setFilterByACAR_RANK_CODE(String filterByACAR_RANK_CODE) {
		this.filterByACAR_RANK_CODE = filterByACAR_RANK_CODE;
	}

	public String getFilterByUI_M_ACAR_RANK_CODE_DESC() {
		return filterByUI_M_ACAR_RANK_CODE_DESC;
	}

	public void setFilterByUI_M_ACAR_RANK_CODE_DESC(
			String filterByUI_M_ACAR_RANK_CODE_DESC) {
		this.filterByUI_M_ACAR_RANK_CODE_DESC = filterByUI_M_ACAR_RANK_CODE_DESC;
	}
}
