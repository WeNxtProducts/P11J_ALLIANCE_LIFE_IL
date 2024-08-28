package com.iii.pel.forms.PILM043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_SETUP_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_RPS_BL_DESC_LABEL;
	private HtmlOutputLabel COMP_RPS_BL_SHORT_DESC_LABEL;
	private HtmlOutputLabel COMP_RPS_BL_LONG_DESC_LABEL;
	private HtmlOutputLabel COMP_RPS_CODE_LABEL;
	private HtmlOutputLabel COMP_RPS_DESC_LABEL;
	private HtmlOutputLabel COMP_RPS_SHORT_DESC_LABEL;
	private HtmlOutputLabel COMP_RPS_LONG_DESC_LABEL;
	private HtmlOutputLabel COMP_RPS_EFF_FM_DT_LABEL;
	private HtmlOutputLabel COMP_RPS_EFF_TO_DT_LABEL;

	private HtmlInputText COMP_RPS_BL_DESC;
	private HtmlInputText COMP_RPS_BL_SHORT_DESC;
	private HtmlInputText COMP_RPS_BL_LONG_DESC;
	private HtmlInputText COMP_RPS_CODE;
	private HtmlInputText COMP_RPS_DESC;
	private HtmlInputText COMP_RPS_SHORT_DESC;
	private HtmlInputText COMP_RPS_LONG_DESC;

	private HtmlCalendar COMP_RPS_EFF_FM_DT;
	private HtmlCalendar COMP_RPS_EFF_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_BILINGUAL;
	private HtmlCommandButton COMP_EDITOR;

	private PM_IL_RI_POOL_SETUP PM_IL_RI_POOL_SETUP_BEAN;
	
	private List<PM_IL_RI_POOL_SETUP> fetchList = new ArrayList<PM_IL_RI_POOL_SETUP>();
	
	private int rowIndex ;
	

	public PM_IL_RI_POOL_SETUP_ACTION() {
		PM_IL_RI_POOL_SETUP_BEAN = new PM_IL_RI_POOL_SETUP();
		helper = new PM_IL_RI_POOL_SETUP_HELPER();
	
	}

	public HtmlOutputLabel getCOMP_RPS_BL_DESC_LABEL() {
		return COMP_RPS_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RPS_BL_DESC() {
		return COMP_RPS_BL_DESC;
	}

	public void setCOMP_RPS_BL_DESC_LABEL(HtmlOutputLabel COMP_RPS_BL_DESC_LABEL) {
		this.COMP_RPS_BL_DESC_LABEL = COMP_RPS_BL_DESC_LABEL;
	}

	public void setCOMP_RPS_BL_DESC(HtmlInputText COMP_RPS_BL_DESC) {
		this.COMP_RPS_BL_DESC = COMP_RPS_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_RPS_BL_SHORT_DESC_LABEL() {
		return COMP_RPS_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RPS_BL_SHORT_DESC() {
		return COMP_RPS_BL_SHORT_DESC;
	}

	public void setCOMP_RPS_BL_SHORT_DESC_LABEL(HtmlOutputLabel COMP_RPS_BL_SHORT_DESC_LABEL) {
		this.COMP_RPS_BL_SHORT_DESC_LABEL = COMP_RPS_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_RPS_BL_SHORT_DESC(HtmlInputText COMP_RPS_BL_SHORT_DESC) {
		this.COMP_RPS_BL_SHORT_DESC = COMP_RPS_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_RPS_BL_LONG_DESC_LABEL() {
		return COMP_RPS_BL_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RPS_BL_LONG_DESC() {
		return COMP_RPS_BL_LONG_DESC;
	}

	public void setCOMP_RPS_BL_LONG_DESC_LABEL(HtmlOutputLabel COMP_RPS_BL_LONG_DESC_LABEL) {
		this.COMP_RPS_BL_LONG_DESC_LABEL = COMP_RPS_BL_LONG_DESC_LABEL;
	}

	public void setCOMP_RPS_BL_LONG_DESC(HtmlInputText COMP_RPS_BL_LONG_DESC) {
		this.COMP_RPS_BL_LONG_DESC = COMP_RPS_BL_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_RPS_CODE_LABEL() {
		return COMP_RPS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_RPS_CODE() {
		return COMP_RPS_CODE;
	}

	public void setCOMP_RPS_CODE_LABEL(HtmlOutputLabel COMP_RPS_CODE_LABEL) {
		this.COMP_RPS_CODE_LABEL = COMP_RPS_CODE_LABEL;
	}

	public void setCOMP_RPS_CODE(HtmlInputText COMP_RPS_CODE) {
		this.COMP_RPS_CODE = COMP_RPS_CODE;
	}

	public HtmlOutputLabel getCOMP_RPS_DESC_LABEL() {
		return COMP_RPS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RPS_DESC() {
		return COMP_RPS_DESC;
	}

	public void setCOMP_RPS_DESC_LABEL(HtmlOutputLabel COMP_RPS_DESC_LABEL) {
		this.COMP_RPS_DESC_LABEL = COMP_RPS_DESC_LABEL;
	}

	public void setCOMP_RPS_DESC(HtmlInputText COMP_RPS_DESC) {
		this.COMP_RPS_DESC = COMP_RPS_DESC;
	}

	public HtmlOutputLabel getCOMP_RPS_SHORT_DESC_LABEL() {
		return COMP_RPS_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RPS_SHORT_DESC() {
		return COMP_RPS_SHORT_DESC;
	}

	public void setCOMP_RPS_SHORT_DESC_LABEL(HtmlOutputLabel COMP_RPS_SHORT_DESC_LABEL) {
		this.COMP_RPS_SHORT_DESC_LABEL = COMP_RPS_SHORT_DESC_LABEL;
	}

	public void setCOMP_RPS_SHORT_DESC(HtmlInputText COMP_RPS_SHORT_DESC) {
		this.COMP_RPS_SHORT_DESC = COMP_RPS_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_RPS_LONG_DESC_LABEL() {
		return COMP_RPS_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_RPS_LONG_DESC() {
		return COMP_RPS_LONG_DESC;
	}

	public void setCOMP_RPS_LONG_DESC_LABEL(HtmlOutputLabel COMP_RPS_LONG_DESC_LABEL) {
		this.COMP_RPS_LONG_DESC_LABEL = COMP_RPS_LONG_DESC_LABEL;
	}

	public void setCOMP_RPS_LONG_DESC(HtmlInputText COMP_RPS_LONG_DESC) {
		this.COMP_RPS_LONG_DESC = COMP_RPS_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_RPS_EFF_FM_DT_LABEL() {
		return COMP_RPS_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RPS_EFF_FM_DT() {
		return COMP_RPS_EFF_FM_DT;
	}

	public void setCOMP_RPS_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_RPS_EFF_FM_DT_LABEL) {
		this.COMP_RPS_EFF_FM_DT_LABEL = COMP_RPS_EFF_FM_DT_LABEL;
	}

	public void setCOMP_RPS_EFF_FM_DT(HtmlCalendar COMP_RPS_EFF_FM_DT) {
		this.COMP_RPS_EFF_FM_DT = COMP_RPS_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_RPS_EFF_TO_DT_LABEL() {
		return COMP_RPS_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RPS_EFF_TO_DT() {
		return COMP_RPS_EFF_TO_DT;
	}

	public void setCOMP_RPS_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_RPS_EFF_TO_DT_LABEL) {
		this.COMP_RPS_EFF_TO_DT_LABEL = COMP_RPS_EFF_TO_DT_LABEL;
	}

	public void setCOMP_RPS_EFF_TO_DT(HtmlCalendar COMP_RPS_EFF_TO_DT) {
		this.COMP_RPS_EFF_TO_DT = COMP_RPS_EFF_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BILINGUAL() {
		return COMP_UI_M_BUT_BILINGUAL;
	}

	public void setCOMP_UI_M_BUT_BILINGUAL(HtmlCommandButton COMP_UI_M_BUT_BILINGUAL) {
		this.COMP_UI_M_BUT_BILINGUAL = COMP_UI_M_BUT_BILINGUAL;
	}

	public HtmlCommandButton getCOMP_EDITOR() {
		return COMP_EDITOR;
	}

	public void setCOMP_EDITOR(HtmlCommandButton COMP_EDITOR) {
		this.COMP_EDITOR = COMP_EDITOR;
	}

	public PM_IL_RI_POOL_SETUP getPM_IL_RI_POOL_SETUP_BEAN() {
		return PM_IL_RI_POOL_SETUP_BEAN;
	}

	public void setPM_IL_RI_POOL_SETUP_BEAN(PM_IL_RI_POOL_SETUP PM_IL_RI_POOL_SETUP_BEAN) {
		this.PM_IL_RI_POOL_SETUP_BEAN = PM_IL_RI_POOL_SETUP_BEAN;
	}
	
	public List<PM_IL_RI_POOL_SETUP> getFetchList() {
		return fetchList;
	}

	public void setFetchList(List<PM_IL_RI_POOL_SETUP> fetchList) {
		this.fetchList = fetchList;
	}
	
	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	/*
	public String Save(){
		CommonUtils.clearMaps(this);
		try{
			if (PM_IL_RI_POOL_SETUP_BEAN.getROWID() ==  null) {
				helper.preInsert(PM_IL_RI_POOL_SETUP_BEAN) ;
				new CRUDHandler().executeInsert(PM_IL_RI_POOL_SETUP_BEAN, CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Saved Successfully");
				getWarningMap().put("SAVE", "Records Saved Successfully");
			}else if (PM_IL_RI_POOL_SETUP_BEAN.getROWID() != null) {
				helper.preUpdate(PM_IL_RI_POOL_SETUP_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_RI_POOL_SETUP_BEAN, CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Updated Successfully");
				getWarningMap().put("SAVE", "Records Updated Successfully");
			}
			CommonUtils.getConnection().commit();
		}catch(Exception er){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, er.getMessage());
			getErrorMap().put("SAVE", er.getMessage());
		}
		return "";
	}
		*/
	public void saveRecord(){
		String message = "";
		try{
			CommonUtils.clearMaps(this);
		if(PM_IL_RI_POOL_SETUP_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()){
				helper.preInsert(PM_IL_RI_POOL_SETUP_BEAN);
				new CRUDHandler().executeInsert(PM_IL_RI_POOL_SETUP_BEAN,CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties","errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("detail", message);
			}else{
				message = Messages.getString("messageProperties","errorPanel$message$insertnotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getErrorMap().put("SAVE", message);
			}
		}else{
				if(isUPDATE_ALLOWED()){
					helper.preUpdate(PM_IL_RI_POOL_SETUP_BEAN);
				new CRUDHandler().executeInsert(PM_IL_RI_POOL_SETUP_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
				getWarningMap()
						.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
				getWarningMap().put("UPDATE", message);
			} else{
				message = Messages.getString("messageProperties",
				"errorPanel$message$updatenotallowed");
		getErrorMap()
				.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
		getErrorMap().put("UPDATE", message);
			}
		}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}finally{
			try{
				new CommonUtils().doComitt();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}

	
	//Fetch the Date
	
	public void fetch(){
		ResultSet result=null;
		CRUDHandler handler=new CRUDHandler();
		String selectQuery="SELECT ROWID,PM_IL_RI_POOL_SETUP.* FROM PM_IL_RI_POOL_SETUP"; 
		
		try {
			result=handler.executeSelectStatement(selectQuery,CommonUtils.getConnection());
			if(result.next()){
			PM_IL_RI_POOL_SETUP_BEAN.setROWID(result.getString(1));
			PM_IL_RI_POOL_SETUP_BEAN.setRPS_CODE(result.getString(2));
			PM_IL_RI_POOL_SETUP_BEAN.setRPS_DESC(result.getString(3));
			PM_IL_RI_POOL_SETUP_BEAN.setRPS_SHORT_DESC(result.getString(4));
			PM_IL_RI_POOL_SETUP_BEAN.setRPS_LONG_DESC(result.getString(5));
			PM_IL_RI_POOL_SETUP_BEAN.setRPS_EFF_FM_DT(result.getDate("RPS_EFF_FM_DT"));
			PM_IL_RI_POOL_SETUP_BEAN.setRPS_EFF_TO_DT(result.getDate("RPS_EFF_TO_DT"));
			}								
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public String Delete(){
		try {

			new CRUDHandler().executeDelete(PM_IL_RI_POOL_SETUP_BEAN, CommonUtils.getConnection());
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record Deleted Successfully");
			CommonUtils.getConnection().commit();
			PM_IL_RI_POOL_SETUP_BEAN=new PM_IL_RI_POOL_SETUP();
		} catch (Exception e) {
			e.printStackTrace();					
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
		
	return "";	
	}
	
	
	
		
	/*public String nextPageSelecting()throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, DBException{
		FacesContext context = FacesContext.getCurrentInstance();
		CRUDHandler handler = new CRUDHandler();
		String RPS_CODE = getCOMP_RPS_CODE().getValue().toString();
		System.out.println("PM_IL_RI_POOL_SETUP_ACTION.nextPageSelecting()-RPS_CODE"+RPS_CODE);
		String selectQuery = "SELECT PM_IL_RI_POOL_COVER.ROWID,PM_IL_RI_POOL_COVER.* FROM PM_IL_RI_POOL_COVER where RPCVR_RPS_CODE ='"+RPS_CODE+"'";
		System.out.println("selectQuery========"+selectQuery);
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PILM043.PM_IL_RI_POOL_COVER",CommonUtils.getConnection());
		System.out.println("list  ++++" +list.size());
		
		PM_IL_RI_POOL_COVER_ACTION actionBean= (PM_IL_RI_POOL_COVER_ACTION)resolver.getValue(context.getELContext(), null, "PILM043_PM_IL_RI_POOL_COVER_ACTION");
		//PM_IL_FUND_PRICE_DTL valueBean = actionBean.getPM_IL_FUND_PRICE_DTL_BEAN();
        
		for(Iterator<PM_IL_FUND_PRICE_DTL>i=list.iterator();i.hasNext();){
			
			PM_IL_FUND_PRICE_DTL listValue = i.next();
			//String productCodeDesc=getProductCodeDesc( listValue.getABNFAP_PROD_CODE(),listValue.getABNFAP_MODULE_ID());
			//listValue.setUI_M_ABNFAP_PROD_CODE_DESC(productCodeDesc);
			listValue.setFPD_FS_CODE(FS_CODE);
			newList.add(listValue);
		}
		//
		
		
//		actionBean.setFetchList(list);
		
		//actionBean.setBeanList(newList);
		
		Save();
		
			String resultClick="PM_IL_RI_POOL_COVER_NAVIGATOR";
		return resultClick;
	}*/
	
	public void setErrorMessagesInMap(ActionEvent event){
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}
	
	/*
	 * Conversion of Triggers.
	 */
	
	/*
	 * Pool Code Trigger.
	 */
	
	private PM_IL_RI_POOL_SETUP_HELPER helper;
	
	public void validateRPS_CODE(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		UIInput input = (UIInput) component;
		String RPS_CODE_STRING = (String)input.getSubmittedValue();
		try {
			if(PM_IL_RI_POOL_SETUP_BEAN.getROWID() == null){
				helper.RPS_CODE_WHEN_VALIDATE_ITEM(PM_IL_RI_POOL_SETUP_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*
	 * Effective From Date
	 */
	public void validateRPS_EFF_FM_DT(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		Date fromDate =(Date) value;
		getPM_IL_RI_POOL_SETUP_BEAN().setRPS_EFF_FM_DT(fromDate);
		try {
			helper.RPS_EFF_FM_DT_WHEN_VALIDATE_ITEM(fromDate, this);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*
	 * Effective To Date 
	 */
	public void validateRPS_EFF_TO_DT(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		Date toDate =(Date) value;
		getPM_IL_RI_POOL_SETUP_BEAN().setRPS_EFF_TO_DT(toDate);
		System.out.println("To Date :"+PM_IL_RI_POOL_SETUP_BEAN.getRPS_EFF_TO_DT());
		try {
			helper.RPS_EFF_TO_DT_WHEN_VALIDATE_ITEM(toDate, this);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*
	 * Description Field
	 */
	
	public void validateRPS_DESC(FacesContext fc, UIComponent component,Object value)throws ValidatorException{
		PM_IL_RI_POOL_SETUP_BEAN.setRPS_DESC((String)value);
			try {
				if(PM_IL_RI_POOL_SETUP_BEAN.getRPS_DESC()!=null )
				{
					if(PM_IL_RI_POOL_SETUP_BEAN.getRPS_SHORT_DESC() == null) {
						PM_IL_RI_POOL_SETUP_BEAN.setRPS_SHORT_DESC(CommonUtils.SUBSTR(PM_IL_RI_POOL_SETUP_BEAN.getRPS_DESC(), 1, 30));
					} else {
						PM_IL_RI_POOL_SETUP_BEAN.setRPS_SHORT_DESC(PM_IL_RI_POOL_SETUP_BEAN.getRPS_DESC());
					}
				}
				COMP_RPS_SHORT_DESC.resetValue();
			} catch (RuntimeException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	}
	
	public void validateRPS_SHORT_DESC(ActionEvent actionEvent){
		HtmlInputText htmlInputText = (HtmlInputText) actionEvent.getComponent().getParent();
		if(htmlInputText.getSubmittedValue() == ""){
			if(PM_IL_RI_POOL_SETUP_BEAN.getRPS_DESC()!=null && PM_IL_RI_POOL_SETUP_BEAN.getRPS_DESC().length()>30)
			{
				System.out.println("Max Length" +PM_IL_RI_POOL_SETUP_BEAN.getRPS_DESC().substring(0, 30));
				COMP_RPS_SHORT_DESC.setSubmittedValue(PM_IL_RI_POOL_SETUP_BEAN.getRPS_DESC().substring(0, 30));
			}
		}
		
	}
	
	/*public String PRE_DELETE(){
		int rowsDeleted = new PM_IL_RI_POOL_SETUP_DELEGATE().preDelete();
		if(rowsDeleted>0){
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			"Record Deleted Successfully");
	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
			"Record Deleted Successfully");
//			getWarningMap().put("current", "Record Deleted Successfully");
		}else{
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			"No  Deleted Successfully");
	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
			"Record Deleted Successfully");
		 }
		return "";
	}
		*/
	public String DELETE() {
		getErrorMap().clear();
		CRUDHandler handler = new CRUDHandler();
		try {
			handler.executeDelete(PM_IL_RI_POOL_SETUP_BEAN,
					CommonUtils.getConnection());
			CommonUtils.getConnection().commit();
			PM_IL_RI_POOL_SETUP_BEAN= new PM_IL_RI_POOL_SETUP();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			"Record Deleted Successfully");
	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
			"Record Deleted Successfully");
//			getWarningMap().put("current", "Record Deleted Successfully");
		} catch (Exception er) {
			er.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Implementation of Tool Bar Functionalities.
	 */
	public String saveNextAction()
	{
		saveRecord();
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String value  = pm_il_ri_pool_setup_composite_action.callCoverDetails();
		pm_il_ri_pool_setup_composite_action.getTabbedBar().gotoNextTab();
		pm_il_ri_pool_setup_composite_action.getTabbedBar().setTabClicked(2);
		return value;
	}
	
	
	public String  nextIconAction()
	{
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String value  = pm_il_ri_pool_setup_composite_action.callCoverDetails();
		pm_il_ri_pool_setup_composite_action.getTabbedBar().gotoNextTab();
		pm_il_ri_pool_setup_composite_action.getTabbedBar().setTabClicked(2);
		return value;
	}
	
	public String  lastIconAction()
	{
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String value  = pm_il_ri_pool_setup_composite_action.callCoverDetails();
		pm_il_ri_pool_setup_composite_action.getTabbedBar().gotoLastTab();
		pm_il_ri_pool_setup_composite_action.getTabbedBar().setTabClicked(2);
		return value;
	}
	
	public String  firstIconAction()
	{
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String value  = pm_il_ri_pool_setup_composite_action.callRIPoolSetup();
		pm_il_ri_pool_setup_composite_action.getTabbedBar().gotoFirstTab();
		pm_il_ri_pool_setup_composite_action.getTabbedBar().setTabClicked(1);
		return value;
	}
	
	public String  previousIconAction()
	{
		PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
		String value  = pm_il_ri_pool_setup_composite_action.callRIPoolSetup();
		pm_il_ri_pool_setup_composite_action.getTabbedBar().gotoPrevTab();
		pm_il_ri_pool_setup_composite_action.getTabbedBar().setTabClicked(1);
		return value;
	}
	
	
	
	public void fetchRIPoolSetupDetails() throws Exception {


		
		try {
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			Connection connection = null;

			String query = "SELECT PM_IL_RI_POOL_SETUP.*,PM_IL_RI_POOL_SETUP.ROWID FROM PM_IL_RI_POOL_SETUP WHERE ROWID = ? "; 
			
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, new Object[]{PM_IL_RI_POOL_SETUP_BEAN.getROWID()});
			while (resultSet.next()) {
				
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_CODE(resultSet.getString("RPS_CODE"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_DESC(resultSet.getString("RPS_DESC"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_SHORT_DESC(resultSet.getString("RPS_SHORT_DESC"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_LONG_DESC(resultSet.getString("RPS_LONG_DESC"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_BL_DESC(resultSet.getString("RPS_BL_DESC"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_BL_SHORT_DESC(resultSet.getString("RPS_BL_SHORT_DESC"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_BL_LONG_DESC(resultSet.getString("RPS_BL_LONG_DESC"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_EFF_FM_DT(resultSet.getDate("RPS_EFF_FM_DT"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_EFF_TO_DT(resultSet.getDate("RPS_EFF_TO_DT"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_CR_DT(resultSet.getDate("RPS_CR_DT"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_CR_UID(resultSet.getString("RPS_CR_UID"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_UPD_DT(resultSet.getDate("RPS_UPD_DT"));
				PM_IL_RI_POOL_SETUP_BEAN.setRPS_UPD_UID(resultSet.getString("RPS_UPD_UID"));
				PM_IL_RI_POOL_SETUP_BEAN.setROWID(resultSet.getString("ROWID"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
		
	}

	
	public void onLoad(PhaseEvent event){
		try {
			if (isBlockFlag()) {
				fetchRIPoolSetupDetails();
			}
			setBlockFlag(false);
			
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}
	
	public void RPS_BL_DESC_validator(FacesContext context,
			UIComponent component, Object value){
		try {
			PM_IL_RI_POOL_SETUP_BEAN.setRPS_BL_DESC((String) value);
			if(PM_IL_RI_POOL_SETUP_BEAN.getRPS_BL_DESC() != null){
				if(PM_IL_RI_POOL_SETUP_BEAN.getRPS_BL_SHORT_DESC() == null){
			     PM_IL_RI_POOL_SETUP_BEAN.setRPS_BL_SHORT_DESC(CommonUtils.SUBSTR(PM_IL_RI_POOL_SETUP_BEAN.getRPS_BL_DESC(),1,30));
				}
			}
			COMP_RPS_BL_SHORT_DESC.resetValue();
		}  catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	
	public void RPS_BL_SHORT_DESC_validator(FacesContext context,
			UIComponent component, Object value){
		try {
			PM_IL_RI_POOL_SETUP_BEAN.setRPS_BL_SHORT_DESC((String) value);
		}  catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
}
