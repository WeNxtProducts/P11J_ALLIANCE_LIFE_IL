package com.iii.pel.forms.PM092_A;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_CONTEST_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ACD_NO_OF_POL_FM_LABEL;

	private HtmlInputText COMP_ACD_NO_OF_POL_FM;

	private HtmlOutputLabel COMP_ACD_NO_OF_POL_TO_LABEL;

	private HtmlInputText COMP_ACD_NO_OF_POL_TO;

	private HtmlOutputLabel COMP_ACD_PROD_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_ACD_PROD_TYPE;

	private HtmlOutputLabel COMP_ACD_LC_FYC_FM_LABEL;

	private HtmlInputText COMP_ACD_LC_FYC_FM;

	private HtmlOutputLabel COMP_ACD_LC_FYC_TO_LABEL;

	private HtmlInputText COMP_ACD_LC_FYC_TO;

	private HtmlOutputLabel COMP_ACD_FYC_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_ACD_FYC_TYPE;

	private PM_AGENT_CONTEST_DTL PM_AGENT_CONTEST_DTL_BEAN;
	
	private List <SelectItem> ACD_FYC_TYPE_ITEMS;
	
	private List <SelectItem> ACD_PROD_TYPE_ITEMS;
	
	public PM092_A_COMPOSITE_ACTION compositeAction;
	
	public PM_AGENT_CONTEST_DTL_ACTION() {
		PM_AGENT_CONTEST_DTL_BEAN = new PM_AGENT_CONTEST_DTL();
		PM_AGENT_CONTEST_DTL_DELEGATE delegate=new PM_AGENT_CONTEST_DTL_DELEGATE();
		this.ACD_FYC_TYPE_ITEMS=delegate.getSelectItems("PM_AGENT_CONTEST_DTL.ACD_FYC_TYPE", "AGT_FYC_TYPE");
		this.ACD_PROD_TYPE_ITEMS=delegate.getSelectItems("PM_AGENT_CONTEST_DTL.ACD_PROD_TYPE", "PROD_TYPE");
	}
	
	public List<SelectItem> getACD_FYC_TYPE_ITEMS() {
		return ACD_FYC_TYPE_ITEMS;
	}

	public void setACD_FYC_TYPE_ITEMS(List<SelectItem> acd_fyc_type_items) {
		ACD_FYC_TYPE_ITEMS = acd_fyc_type_items;
	}

	public List<SelectItem> getACD_PROD_TYPE_ITEMS() {
		return ACD_PROD_TYPE_ITEMS;
	}

	public void setACD_PROD_TYPE_ITEMS(List<SelectItem> acd_prod_type_items) {
		ACD_PROD_TYPE_ITEMS = acd_prod_type_items;
	}
	
	public HtmlOutputLabel getCOMP_ACD_NO_OF_POL_FM_LABEL() {
		return COMP_ACD_NO_OF_POL_FM_LABEL;
	}

	public HtmlInputText getCOMP_ACD_NO_OF_POL_FM() {
		return COMP_ACD_NO_OF_POL_FM;
	}

	public void setCOMP_ACD_NO_OF_POL_FM_LABEL(HtmlOutputLabel COMP_ACD_NO_OF_POL_FM_LABEL) {
		this.COMP_ACD_NO_OF_POL_FM_LABEL = COMP_ACD_NO_OF_POL_FM_LABEL;
	}

	public void setCOMP_ACD_NO_OF_POL_FM(HtmlInputText COMP_ACD_NO_OF_POL_FM) {
		this.COMP_ACD_NO_OF_POL_FM = COMP_ACD_NO_OF_POL_FM;
	}

	public HtmlOutputLabel getCOMP_ACD_NO_OF_POL_TO_LABEL() {
		return COMP_ACD_NO_OF_POL_TO_LABEL;
	}

	public HtmlInputText getCOMP_ACD_NO_OF_POL_TO() {
		return COMP_ACD_NO_OF_POL_TO;
	}

	public void setCOMP_ACD_NO_OF_POL_TO_LABEL(HtmlOutputLabel COMP_ACD_NO_OF_POL_TO_LABEL) {
		this.COMP_ACD_NO_OF_POL_TO_LABEL = COMP_ACD_NO_OF_POL_TO_LABEL;
	}

	public void setCOMP_ACD_NO_OF_POL_TO(HtmlInputText COMP_ACD_NO_OF_POL_TO) {
		this.COMP_ACD_NO_OF_POL_TO = COMP_ACD_NO_OF_POL_TO;
	}

	public HtmlOutputLabel getCOMP_ACD_PROD_TYPE_LABEL() {
		return COMP_ACD_PROD_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACD_PROD_TYPE() {
		return COMP_ACD_PROD_TYPE;
	}

	public void setCOMP_ACD_PROD_TYPE_LABEL(HtmlOutputLabel COMP_ACD_PROD_TYPE_LABEL) {
		this.COMP_ACD_PROD_TYPE_LABEL = COMP_ACD_PROD_TYPE_LABEL;
	}

	public void setCOMP_ACD_PROD_TYPE(HtmlSelectOneMenu COMP_ACD_PROD_TYPE) {
		this.COMP_ACD_PROD_TYPE = COMP_ACD_PROD_TYPE;
	}

	public HtmlOutputLabel getCOMP_ACD_LC_FYC_FM_LABEL() {
		return COMP_ACD_LC_FYC_FM_LABEL;
	}

	public HtmlInputText getCOMP_ACD_LC_FYC_FM() {
		return COMP_ACD_LC_FYC_FM;
	}

	public void setCOMP_ACD_LC_FYC_FM_LABEL(HtmlOutputLabel COMP_ACD_LC_FYC_FM_LABEL) {
		this.COMP_ACD_LC_FYC_FM_LABEL = COMP_ACD_LC_FYC_FM_LABEL;
	}

	public void setCOMP_ACD_LC_FYC_FM(HtmlInputText COMP_ACD_LC_FYC_FM) {
		this.COMP_ACD_LC_FYC_FM = COMP_ACD_LC_FYC_FM;
	}

	public HtmlOutputLabel getCOMP_ACD_LC_FYC_TO_LABEL() {
		return COMP_ACD_LC_FYC_TO_LABEL;
	}

	public HtmlInputText getCOMP_ACD_LC_FYC_TO() {
		return COMP_ACD_LC_FYC_TO;
	}

	public void setCOMP_ACD_LC_FYC_TO_LABEL(HtmlOutputLabel COMP_ACD_LC_FYC_TO_LABEL) {
		this.COMP_ACD_LC_FYC_TO_LABEL = COMP_ACD_LC_FYC_TO_LABEL;
	}

	public void setCOMP_ACD_LC_FYC_TO(HtmlInputText COMP_ACD_LC_FYC_TO) {
		this.COMP_ACD_LC_FYC_TO = COMP_ACD_LC_FYC_TO;
	}

	public HtmlOutputLabel getCOMP_ACD_FYC_TYPE_LABEL() {
		return COMP_ACD_FYC_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACD_FYC_TYPE() {
		return COMP_ACD_FYC_TYPE;
	}

	public void setCOMP_ACD_FYC_TYPE_LABEL(HtmlOutputLabel COMP_ACD_FYC_TYPE_LABEL) {
		this.COMP_ACD_FYC_TYPE_LABEL = COMP_ACD_FYC_TYPE_LABEL;
	}

	public void setCOMP_ACD_FYC_TYPE(HtmlSelectOneMenu COMP_ACD_FYC_TYPE) {
		this.COMP_ACD_FYC_TYPE = COMP_ACD_FYC_TYPE;
	}

	public PM_AGENT_CONTEST_DTL getPM_AGENT_CONTEST_DTL_BEAN() {
		return PM_AGENT_CONTEST_DTL_BEAN;
	}

	public void setPM_AGENT_CONTEST_DTL_BEAN(PM_AGENT_CONTEST_DTL PM_AGENT_CONTEST_DTL_BEAN) {
		this.PM_AGENT_CONTEST_DTL_BEAN = PM_AGENT_CONTEST_DTL_BEAN;
	}
	
	public String saveButtonClick(){
		String returnString="";
		String message=null;
		PM_AGENT_CONTEST_DTL_DELEGATE delegate=new PM_AGENT_CONTEST_DTL_DELEGATE();
		if(PM_AGENT_CONTEST_DTL_BEAN.getROWID()==null){
			message=Messages.getString("messageProperties", "errorPanel$message$save");
		}else{
			message=Messages.getString("messageProperties", "errorPanel$message$update");
		}
		delegate.saveRecord(this.PM_AGENT_CONTEST_DTL_BEAN,true);
		if(message!=null){
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		}
		return returnString;
	}
	
	public String saveNextButtonClick(){
		String returnString="";
		String message=null;
		boolean result=false;
		PM_AGENT_CONTEST_DTL_DELEGATE delegate=new PM_AGENT_CONTEST_DTL_DELEGATE();
		if(PM_AGENT_CONTEST_DTL_BEAN.getROWID()==null){
			message=Messages.getString("messageProperties", "errorPanel$message$save");
		}else{
			message=Messages.getString("messageProperties", "errorPanel$message$update");
		}
		
		result=delegate.saveRecord(this.PM_AGENT_CONTEST_DTL_BEAN,true);
		
		if(message!=null){
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
			
		}
		
		populateBlockPM_AGENT_CONTEST_APPL_RANK();
		if(result){
			returnString="GO_TO_PM092_A_PM_AGENT_CONTEST_APPL_RANK";
		}
		return returnString;
	}
	
	public String deleteButtonClick(){
		String returnString="";
		String message=null;
		boolean recordDeletedFlag=false;
		PM_AGENT_CONTEST_DTL_DELEGATE delegate=new PM_AGENT_CONTEST_DTL_DELEGATE();
		
		recordDeletedFlag=delegate.deleteRecord(this.PM_AGENT_CONTEST_DTL_BEAN,true);
		if(recordDeletedFlag){
			message=Messages.getString("messageProperties", "errorPanel$message$delete");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		}
		
		return returnString;
	}
	
	public String nextPageButtonClick(){
		String returnString="";
		PM_AGENT_CONTEST_DTL_DELEGATE delegate=new PM_AGENT_CONTEST_DTL_DELEGATE();
		boolean result=delegate.saveRecord(this.PM_AGENT_CONTEST_DTL_BEAN,false);
		populateBlockPM_AGENT_CONTEST_APPL_RANK();
		returnString="GO_TO_PM092_A_PM_AGENT_CONTEST_APPL_RANK";
		return returnString;
	}
	

	public void populateBlockPM_AGENT_CONTEST_APPL_RANK(){
		//get details from database for the block
		PM_AGENT_CONTEST_DTL_DELEGATE delegate= new PM_AGENT_CONTEST_DTL_DELEGATE();
		List dataList=new ArrayList<PM_AGENT_CONTEST_APPL_RANK>();
		dataList=delegate.getBlockDataForPM_AGENT_CONTEST_APPL_RANK();
		System.out.println("size of list-------------"+dataList.size());
		//Populate the block
		String mappedBeanName="PM092_A_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PM092_A_COMPOSITE_ACTION compositeActionBean=
			(PM092_A_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		compositeActionBean.getPM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN().setRecordList(dataList);
	
	}

	/**
	 * Implementation of Tool Bar Functionalities.
	 */
	public String saveNextAction()
	{
		saveButtonClick();
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value  = pm092_a_composite_action.goToPM_AGENT_CONTEST_APPL_RANK();
		pm092_a_composite_action.getTabbedBar().gotoNextTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(3);
		return value;
	}
	
	
	public String  nextIconAction()
	{
		PM092_A_COMPOSITE_ACTION pm092_a_composite_action = (PM092_A_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PM092_A_COMPOSITE_ACTION");
		String value  = pm092_a_composite_action.goToPM_AGENT_CONTEST_APPL_RANK();
		pm092_a_composite_action.getTabbedBar().gotoNextTab();
		pm092_a_composite_action.getTabbedBar().setTabClicked(3);
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
		pm092_a_composite_action.getTabbedBar().setTabClicked(1);
		return value;
	}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
}
