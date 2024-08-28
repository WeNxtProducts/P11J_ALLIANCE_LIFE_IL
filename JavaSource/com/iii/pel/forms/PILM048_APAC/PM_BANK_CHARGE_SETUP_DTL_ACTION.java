package com.iii.pel.forms.PILM048_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM039.PILM039_DELIGATE;
import com.iii.pel.forms.PILM039.PM_IL_APPR_DEPT_SETUP;
import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_BANK_CHARGE_SETUP_DTL_ACTION extends CommonAction{
	
	private static final Log log = LogFactory.getLog(PM_BANK_CHARGE_SETUP_DTL_ACTION.class);

	private HtmlOutputLabel COMP_BCSD_AMT_LC_FM_LABEL;

	private HtmlInputText COMP_BCSD_AMT_LC_FM;

	private HtmlOutputLabel COMP_BCSD_AMT_LC_TO_LABEL;

	private HtmlInputText COMP_BCSD_AMT_LC_TO;

	private HtmlOutputLabel COMP_BCSD_RATE_LABEL;

	private HtmlInputText COMP_BCSD_RATE;

	private HtmlOutputLabel COMP_BCSD_RATE_PER_LABEL;

	private HtmlInputText COMP_BCSD_RATE_PER;

	private HtmlOutputLabel COMP_BCSD_MIN_CHG_LC_LABEL;

	private HtmlInputText COMP_BCSD_MIN_CHG_LC;

	private HtmlOutputLabel COMP_BCSD_MAX_CHG_LC_LABEL;

	private HtmlInputText COMP_BCSD_MAX_CHG_LC;

	private HtmlOutputLabel COMP_BCSD_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_BCSD_EFF_FM_DT;

	private HtmlOutputLabel COMP_BCSD_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_BCSD_EFF_TO_DT;

	//private UIData dataGrid;

	private HtmlInputHidden BCSD_BCSH_SYS_ID;
	
	private HtmlInputHidden BCSD_SYS_ID;
	
	private PM_BANK_CHARGE_SETUP_DTL PM_BANK_CHARGE_SETUP_DTL_BEAN;
	
	private String filterByBCSD_RATE;
	private String filterByBCSD_AMT_LC_FM;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private UIDataTable dataTable = null;
	
	
	Map<String, Object> session = null;
	ArrayList<PM_BANK_CHARGE_SETUP_DTL> dataList = new ArrayList<PM_BANK_CHARGE_SETUP_DTL>();
	private int lastRowIdx;
	private int prevRowIdx; 
	private int currPage;
	private int recordsPerPage = 5;
	ArrayList deletedIndexList;
	List<PM_BANK_CHARGE_SETUP_DTL> resultList ;// new ArrayList<PM_BANK_CHARGE_SETUP_DTL>();

	DataTableHelper helper = null;
	PM_BANK_CHARGE_SETUP_DTL firstBean = null;
	
	private TabbedBar tabbedBar;
	
	public PM_BANK_CHARGE_SETUP_DTL_ACTION() {
		PM_BANK_CHARGE_SETUP_DTL_BEAN = new PM_BANK_CHARGE_SETUP_DTL();
		this.tabbedBar = new TabbedBar();
		try{
			this.tabbedBar.addTab(1, "#{PILM048_APAC_PM_BANK_CHARGE_SETUP_DTL_ACTION.goHDRBlock}", "Bank Charge Setup", false);
			this.tabbedBar.addTab(2, "#{PILM048_APAC_PM_BANK_CHARGE_SETUP_DTL_ACTION.PM_BANK_CHARGE_SETUP_DTLInsert}", "Rate Setup", false);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		/*FacesContext ctx = FacesContext.getCurrentInstance();
		session = ctx.getExternalContext().getSessionMap();
		helper = new DataTableHelper();
		String status = (String)getSession().get("modestatus");
		if(!status.equals("executeInsert")){
			System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.PM_BANK_CHARGE_SETUP_DTL_ACTION()");
			try{
				resultList = helper.getValues();
			}catch (Exception e) {
				getErrorMap().put("current", e.getMessage());
				e.printStackTrace();
			}
		}
		if(resultList == null){
			firstBean = new PM_BANK_CHARGE_SETUP_DTL();
			try {
				whenCreateRecord();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dataList.add(firstBean);
		}else{
			for(int idx=0;idx<resultList.size();idx++){
				PM_BANK_CHARGE_SETUP_DTL value =  resultList.get(idx);
				dataList.add(value);
			}
		}
		prevRowIdx = 0;
		currPage = 1;*/
	}

	public int getLastRowIdx() {
		return lastRowIdx;
	}

	public void setLastRowIdx(int lastRowIdx) {
		this.lastRowIdx = lastRowIdx;
	}

	public int getPrevRowIdx() {
		return prevRowIdx;
	}

	public void setPrevRowIdx(int prevRowIdx) {
		this.prevRowIdx = prevRowIdx;
	}

	public HtmlOutputLabel getCOMP_BCSD_AMT_LC_FM_LABEL() {
		return COMP_BCSD_AMT_LC_FM_LABEL;
	}

	public HtmlInputText getCOMP_BCSD_AMT_LC_FM() {
		return COMP_BCSD_AMT_LC_FM;
	}

	public void setCOMP_BCSD_AMT_LC_FM_LABEL(HtmlOutputLabel COMP_BCSD_AMT_LC_FM_LABEL) {
		this.COMP_BCSD_AMT_LC_FM_LABEL = COMP_BCSD_AMT_LC_FM_LABEL;
	}

	public void setCOMP_BCSD_AMT_LC_FM(HtmlInputText COMP_BCSD_AMT_LC_FM) {
		this.COMP_BCSD_AMT_LC_FM = COMP_BCSD_AMT_LC_FM;
	}

	public HtmlOutputLabel getCOMP_BCSD_AMT_LC_TO_LABEL() {
		return COMP_BCSD_AMT_LC_TO_LABEL;
	}

	public HtmlInputText getCOMP_BCSD_AMT_LC_TO() {
		return COMP_BCSD_AMT_LC_TO;
	}

	public void setCOMP_BCSD_AMT_LC_TO_LABEL(HtmlOutputLabel COMP_BCSD_AMT_LC_TO_LABEL) {
		this.COMP_BCSD_AMT_LC_TO_LABEL = COMP_BCSD_AMT_LC_TO_LABEL;
	}

	public void setCOMP_BCSD_AMT_LC_TO(HtmlInputText COMP_BCSD_AMT_LC_TO) {
		this.COMP_BCSD_AMT_LC_TO = COMP_BCSD_AMT_LC_TO;
	}

	public HtmlOutputLabel getCOMP_BCSD_RATE_LABEL() {
		return COMP_BCSD_RATE_LABEL;
	}

	public HtmlInputText getCOMP_BCSD_RATE() {
		return COMP_BCSD_RATE;
	}

	public void setCOMP_BCSD_RATE_LABEL(HtmlOutputLabel COMP_BCSD_RATE_LABEL) {
		this.COMP_BCSD_RATE_LABEL = COMP_BCSD_RATE_LABEL;
	}

	public void setCOMP_BCSD_RATE(HtmlInputText COMP_BCSD_RATE) {
		this.COMP_BCSD_RATE = COMP_BCSD_RATE;
	}

	public HtmlOutputLabel getCOMP_BCSD_RATE_PER_LABEL() {
		return COMP_BCSD_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_BCSD_RATE_PER() {
		return COMP_BCSD_RATE_PER;
	}

	public void setCOMP_BCSD_RATE_PER_LABEL(HtmlOutputLabel COMP_BCSD_RATE_PER_LABEL) {
		this.COMP_BCSD_RATE_PER_LABEL = COMP_BCSD_RATE_PER_LABEL;
	}

	public void setCOMP_BCSD_RATE_PER(HtmlInputText COMP_BCSD_RATE_PER) {
		this.COMP_BCSD_RATE_PER = COMP_BCSD_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_BCSD_MIN_CHG_LC_LABEL() {
		return COMP_BCSD_MIN_CHG_LC_LABEL;
	}

	public HtmlInputText getCOMP_BCSD_MIN_CHG_LC() {
		return COMP_BCSD_MIN_CHG_LC;
	}

	public void setCOMP_BCSD_MIN_CHG_LC_LABEL(HtmlOutputLabel COMP_BCSD_MIN_CHG_LC_LABEL) {
		this.COMP_BCSD_MIN_CHG_LC_LABEL = COMP_BCSD_MIN_CHG_LC_LABEL;
	}

	public void setCOMP_BCSD_MIN_CHG_LC(HtmlInputText COMP_BCSD_MIN_CHG_LC) {
		this.COMP_BCSD_MIN_CHG_LC = COMP_BCSD_MIN_CHG_LC;
	}

	public HtmlOutputLabel getCOMP_BCSD_MAX_CHG_LC_LABEL() {
		return COMP_BCSD_MAX_CHG_LC_LABEL;
	}

	public HtmlInputText getCOMP_BCSD_MAX_CHG_LC() {
		return COMP_BCSD_MAX_CHG_LC;
	}

	public void setCOMP_BCSD_MAX_CHG_LC_LABEL(HtmlOutputLabel COMP_BCSD_MAX_CHG_LC_LABEL) {
		this.COMP_BCSD_MAX_CHG_LC_LABEL = COMP_BCSD_MAX_CHG_LC_LABEL;
	}

	public void setCOMP_BCSD_MAX_CHG_LC(HtmlInputText COMP_BCSD_MAX_CHG_LC) {
		this.COMP_BCSD_MAX_CHG_LC = COMP_BCSD_MAX_CHG_LC;
	}

	public HtmlOutputLabel getCOMP_BCSD_EFF_FM_DT_LABEL() {
		return COMP_BCSD_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_BCSD_EFF_FM_DT() {
		return COMP_BCSD_EFF_FM_DT;
	}

	public void setCOMP_BCSD_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_BCSD_EFF_FM_DT_LABEL) {
		this.COMP_BCSD_EFF_FM_DT_LABEL = COMP_BCSD_EFF_FM_DT_LABEL;
	}

	public void setCOMP_BCSD_EFF_FM_DT(HtmlCalendar COMP_BCSD_EFF_FM_DT) {
		this.COMP_BCSD_EFF_FM_DT = COMP_BCSD_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_BCSD_EFF_TO_DT_LABEL() {
		return COMP_BCSD_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_BCSD_EFF_TO_DT() {
		return COMP_BCSD_EFF_TO_DT;
	}

	public void setCOMP_BCSD_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_BCSD_EFF_TO_DT_LABEL) {
		this.COMP_BCSD_EFF_TO_DT_LABEL = COMP_BCSD_EFF_TO_DT_LABEL;
	}

	public void setCOMP_BCSD_EFF_TO_DT(HtmlCalendar COMP_BCSD_EFF_TO_DT) {
		this.COMP_BCSD_EFF_TO_DT = COMP_BCSD_EFF_TO_DT;
	}

	public PM_BANK_CHARGE_SETUP_DTL getPM_BANK_CHARGE_SETUP_DTL_BEAN() {
		return PM_BANK_CHARGE_SETUP_DTL_BEAN;
	}

	public void setPM_BANK_CHARGE_SETUP_DTL_BEAN(PM_BANK_CHARGE_SETUP_DTL PM_BANK_CHARGE_SETUP_DTL_BEAN) {
		this.PM_BANK_CHARGE_SETUP_DTL_BEAN = PM_BANK_CHARGE_SETUP_DTL_BEAN;
	}

	public void insertRow(){
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.insertRow()");
		PM_BANK_CHARGE_SETUP_HDR action = (PM_BANK_CHARGE_SETUP_HDR) session.get("PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION");

	}
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
	/*public void dataColoumListener(){
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.dataColoumListener()");
		int curRowIdx = getDataGrid().getRowIndex();
		int updatedRow = 0;
		PM_BANK_CHARGE_SETUP_DTL dtlBean = null; 
		try{
			if(lastRowIdx!=-1){
				if(lastRowIdx!=prevRowIdx){
					if(prevRowIdx!=lastRowIdx){
						dtlBean = (PM_BANK_CHARGE_SETUP_DTL)dataList.get(prevRowIdx);
						if(dtlBean.getROWID()!=null){
							
							updatedRow = helper.updateData(dtlBean);
							getErrorMap().put("somekey", updatedRow+" record updated.");
							getErrorMap().put("current", updatedRow+" record updated.");
						}else{
//							dtlBean.setBCSD_AMT_LC_FM(Double.valueOf("0"));
							updatedRow = helper.updateData(dtlBean);
							getErrorMap().put("somekey", updatedRow+" record updated.");
							getErrorMap().put("current", updatedRow+" record updated.");
						}
						prevRowIdx = curRowIdx;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
	public void lastColomnListener(){
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.lastColomnListener()");
		int curRowIdx = 0;//getDataGrid().getRowIndex();
		int updatedRow = 0;
		PM_BANK_CHARGE_SETUP_DTL dtlBean = null; 
		try{
			dtlBean = (PM_BANK_CHARGE_SETUP_DTL)dataList.get(curRowIdx);

			if(dtlBean.getROWID()!=null){
				System.out.println("iffffffflastColomnListener()");
				preUpdate();
				updatedRow = helper.updateData(dtlBean);
				getWarningMap().put("current", Messages.getString("messageProperties.properties", "errorPanel$message$update"));
				getWarningMap().put("detail", Messages.getString("messageProperties.properties", "errorPanel$message$update"));
			}else{
				preInsert(dtlBean);
				System.out.println("elseeeeee.lastColomnListener()");
//				dtlBean.setBCSD_AMT_LC_FM(Double.valueOf("0"));
				updatedRow = helper.updateData(dtlBean);
				getWarningMap().put("current", Messages.getString("messageProperties.properties", "errorPanel$message$insert"));
				getWarningMap().put("deatil", Messages.getString("messageProperties.properties", "errorPanel$message$insert"));
			}
			lastRowIdx = curRowIdx;

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String checkBoxStatus(ActionEvent actionEvent)
	{
		CommonUtils.clearMaps(this);
		getCurrentValue(actionEvent);
		System.out.println("Comming to check box status");
		return "";
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
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009
	/*public void checkBoxValidation(ActionEvent event){
		 
		//dataColoumListener();
		
	}*/
	// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
	public ArrayList<PM_BANK_CHARGE_SETUP_DTL> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<PM_BANK_CHARGE_SETUP_DTL> dataList) {
		this.dataList = dataList;
	}
	public void column1(ActionEvent ae){
		CommonUtils.clearMaps(this);
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column1()");
		HtmlInputText input =  (HtmlInputText) ae.getComponent().getParent();
		String value = input.getSubmittedValue().toString();
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column1() -- > "+value);
		PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_AMT_LC_FM(value==null||value.isEmpty()?0.0:Double.valueOf(value));
		COMP_BCSD_AMT_LC_FM.setSubmittedValue( (value==null||value.isEmpty()) ?0.0:Double.valueOf(value));
		COMP_BCSD_AMT_LC_FM.resetValue();
	}
	public void column2(ActionEvent ae){
		CommonUtils.clearMaps(this);
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column2()");
		HtmlInputText input =  (HtmlInputText) ae.getComponent().getParent();
		String value = input.getSubmittedValue().toString();
//		String value = "999999999.99";
	//	int rowIdx = getDataGrid().getRowIndex();
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column2()--> "+value);
		//dataList.get(rowIdx).setBCSD_AMT_LC_TO(value==null||value.isEmpty()?null:Double.valueOf(value));
		this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_AMT_LC_TO(value==null||value.isEmpty()?null:Double.valueOf(value));
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
		//dataColoumListener();
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
	}
	public void column3(ActionEvent ae){
		CommonUtils.clearMaps(this);
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column3()");
		HtmlInputText input =  (HtmlInputText) ae.getComponent().getParent();
		String value = input.getSubmittedValue().toString();
		//int rowIdx = getDataGrid().getRowIndex();
		//System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column3()"+rowIdx+ "\t" +value);
	//	dataList.get(rowIdx).setBCSD_RATE(value==null||value.isEmpty()?null:Double.valueOf(value));
		this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_RATE(value==null||value.isEmpty()?null:Double.valueOf(value));
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
		//dataColoumListener();
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
	}
	public void column4(ActionEvent ae){
		CommonUtils.clearMaps(this);
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column4()");
		HtmlInputText input =  (HtmlInputText) ae.getComponent().getParent();
		String value = input.getSubmittedValue().toString();
		//int rowIdx = getDataGrid().getRowIndex();
		//System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column4()"+rowIdx+ "\t" +value);
		//dataList.get(rowIdx).setBCSD_RATE_PER(value==null||value.isEmpty()?null:Double.valueOf(value));
		this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_RATE_PER(value==null||value.isEmpty()?null:Double.valueOf(value));
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
		//dataColoumListener();
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
	}
	public void column5(ActionEvent ae){
		CommonUtils.clearMaps(this);
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column5()");
		HtmlInputText input =  (HtmlInputText) ae.getComponent().getParent();
		if(input.getSubmittedValue()!=null){
			this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_MIN_CHG_LC(Double.parseDouble(input.getSubmittedValue().toString()));
		}else{
			this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_MIN_CHG_LC(0.0);
		}
		//String value = input.getSubmittedValue().toString();
		//this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_MIN_CHG_LC(value==null||value.isEmpty()?null:Double.valueOf(value));
		COMP_BCSD_MIN_CHG_LC.setSubmittedValue(input.getSubmittedValue()!=null ? Double.parseDouble(input.getSubmittedValue().toString()) :0.0);
		COMP_BCSD_MIN_CHG_LC.resetValue();
	}
	
	
	public void validateMaxCharge(FacesContext context,
			UIComponent component, Object value){
		CommonUtils.clearMaps(this);
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.BCSD_AMT_LC_TOValidate()");
		this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_MAX_CHG_LC(value!=null ? Double.parseDouble(value.toString()) : 0.0);
		try{
			if(PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_MAX_CHG_LC()!=null &&
					PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_MIN_CHG_LC() > PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_MAX_CHG_LC()){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80132",
						new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
			}
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	public void column7(ActionEvent ae){
		CommonUtils.clearMaps(this);
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column1()");
		HtmlInputText input =  (HtmlInputText) ae.getComponent().getParent();
		String value = input.getSubmittedValue().toString();
		this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_EFF_FM_DT(CommonUtils.stringToDate(value));

		
		//int rowIdx = getDataGrid().getRowIndex();
//		dataList.get(rowIdx).setBCSD_EFF_FM_DT(value);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
		//dataColoumListener();
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
	}
	
	public void validateEff_FROM_DATE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException, ParseException
      {
		HtmlCalendar htmlCalendar = (HtmlCalendar) component;
		
		System.out.println("SUBMITTED VALUE:"+value);
		Date fromDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue()); 
		System.out.println("FROM DATE ::::::::::"+fromDate);
		CommonUtils  commonUtils=new CommonUtils();
		Date sysDate=commonUtils.getCurrentDate();
		
		DateFormat dateFormat=new SimpleDateFormat("dd/MMM/yyyy");
		String formattedSysDate=dateFormat.format(sysDate);
		System.out.println("Fromatted Sys Date :"+formattedSysDate);
		
		this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_EFF_FM_DT(fromDate);
		//Date issueDate=PM_IL_MASTER_POLICY_BEAN.getMP_ISSUE_DT();
	/*	String formattedIssueDate=dateFormat.format(issueDate);
		System.out.println("SYS DATE :"+sysDate+"<From Date : "+fromDate+">"+"***** :"+issueDate);*/
		if(fromDate!=null)
		{
			if(fromDate.after(sysDate))
			{
				//Object[] object={"Policy From Date","<=",formattedSysDate};
				Object[] object={"Eff From Date","<=",sysDate};
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
			}
		}
     }
	
	public void validateEff_To_DATE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException, ParseException
      {
		HtmlCalendar htmlCalendar = (HtmlCalendar) component;
		
		System.out.println("SUBMITTED VALUE:"+value);
		Date toDate = htmlCalendar.getAsDate(htmlCalendar.getSubmittedValue()); 
		System.out.println("FROM DATE ::::::::::"+toDate);
		CommonUtils  commonUtils=new CommonUtils();
		Date sysDate=commonUtils.getCurrentDate();
		
		DateFormat dateFormat=new SimpleDateFormat("dd/MMM/yyyy");
		String formattedSysDate=dateFormat.format(sysDate);
		System.out.println("Fromatted Sys Date :"+formattedSysDate);
		
		this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_EFF_TO_DT(toDate);
		//Date issueDate=PM_IL_MASTER_POLICY_BEAN.getMP_ISSUE_DT();
	/*	String formattedIssueDate=dateFormat.format(issueDate);
		System.out.println("SYS DATE :"+sysDate+"<From Date : "+fromDate+">"+"***** :"+issueDate);*/
		if(toDate!=null)
		{
			if(toDate.before(PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_EFF_FM_DT()))
			{
				//Object[] object={"Policy From Date","<=",formattedSysDate};
				Object[] object={"Eff To Date","<=",PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_EFF_FM_DT()};
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"91014",object));
			}
		}
     }
	public void column8(ActionEvent ae){
		CommonUtils.clearMaps(this);
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.column1()");
		HtmlInputText input =  (HtmlInputText) ae.getComponent().getParent();
		String value = input.getSubmittedValue().toString();
		this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_EFF_TO_DT(CommonUtils.stringToDate(value));
		//int rowIdx = getDataGrid().getRowIndex();
	//	this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_EFF_TO_DT(value);
//		dataList.get(rowIdx).setBCSD_EFF_TO_DT(value);
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
		//lastColomnListener();
		// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
	}
	public String deleteRow()
	{
		try{
			PM_BANK_CHARGE_SETUP_DTL bean = null;
			ArrayList deletedRecordList = null;
			int deletedRecordIndex = 0;
			if(dataList!=null)
			{
				deletedRecordList = new ArrayList();
				for(int index =0; index<dataList.size();)
				{
					bean = dataList.get(index);
				// if(bean.isCHECK_BOX()){
				if("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())){
					dataList.remove(bean);
					deletedRecordIndex = helper.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				}else
				{
					index++;
				}
			}

			if(deletedRecordList.size()>0)
			{
				getWarningMap().put("DELETE",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
			}
			lastRowIdx = -1;
		}
		}
		catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}return "";
	}
	public String addNew(){
		int rowCount = 0;
		if(dataList == null){
			dataList = new ArrayList<PM_BANK_CHARGE_SETUP_DTL>();
		}
		firstBean = new PM_BANK_CHARGE_SETUP_DTL();
		try {
			whenCreateRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.addNew() "+getSession().get("modestatus"));
		//if(!getSession().get("modestatus").equals("executequery")){
			System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.addNew(sss)");
			dataList.add(firstBean);
		//}
		// Settings to navigate to last page
	//	rowCount = getDataGrid().getRowCount();
		currPage = rowCount/recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}
	
		
		return "newadded";
	}
	
	/*public void validateBCSD_AMT_LC_TO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, SQLException, Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.validateBCSD_AMT_LC_TO()");
		UIInput inputText = (UIInput)component;
		if(inputText.getSubmittedValue()!=null)	{
			String inputValue = (String) inputText.getSubmittedValue();
			if(inputValue == null){
				int rowIndex = getDataGrid().getRowIndex();
				System.out.println("validateBCSD_AMT_LC_TO()");
				column2(null);
//				dataList.get(rowIndex).setBCSD_AMT_LC_TO(Double.parseDouble("999999999.99"));
			}else{
				column2(component);
			}
		}
//		IF :PM_BANK_CHARGE_SETUP_DTL.BCSD_AMT_LC_FM > :PM_BANK_CHARGE_SETUP_DTL.BCSD_AMT_LC_TO  THEN
//		  STD_MESSAGE_ROUTINE(80015,:CTRL.M_LANG_CODE);
//		  --DISP_ALERT('FM_AMT CANNOT BE GREATER THAN TO_AMT');
//		  RAISE FORM_TRIGGER_FAILURE;
//	END IF;
//		dataColoumListener();
	}*/
	
	public void BCSD_AMT_LC_TOValidate(FacesContext context, UIComponent component,
			Object obj) throws ValidatorException{
		CommonUtils.clearMaps(this);
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.BCSD_AMT_LC_TOValidate()");
		this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_AMT_LC_TO(obj!=null ? Double.parseDouble(obj.toString()) : 0.0);
		try{
			if(PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_AMT_LC_FM()!=null &&
					PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_AMT_LC_FM() > PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_AMT_LC_TO()){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80015",
						new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
			}
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param ae
	 */
	public void validateMaxCharge(ActionEvent ae){
		CommonUtils.clearMaps(this);
		Object submittedValue = ((UIInput)ae.getComponent().getParent()).getSubmittedValue();
		Double value = 0.0;
		
		try{
			
			if(submittedValue!=null){
				/*value = submittedValue==null?0.0:Double.parseDouble(submittedValue.toString());
				COMP_BCSD_MAX_CHG_LC.setSubmittedValue(value);*/
				this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_MAX_CHG_LC(Double.parseDouble(submittedValue.toString()));
			}else{
				this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_MAX_CHG_LC(999999999.99);
			}
			
			fireFieldValidation(ae);
			COMP_BCSD_MAX_CHG_LC.resetValue();
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param ae
	 */
	public void BCSD_AMT_LC_TOValidate(ActionEvent ae){
		CommonUtils.clearMaps(this);
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.BCSD_AMT_LC_TOValidate()");
		Object submittedValue = ((UIInput)ae.getComponent().getParent()).getSubmittedValue();
		Double value = 0.0;
		
		try{
			
			if(submittedValue!=null){
				//COMP_BCSD_AMT_LC_FM.setSubmittedValue(Double.parseDouble(submittedValue.toString()));
				this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_AMT_LC_TO(Double.parseDouble(submittedValue.toString()));
			}else{
				this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_AMT_LC_TO(999999999.99);
			}
			
			fireFieldValidation(ae);
			COMP_BCSD_AMT_LC_FM.resetValue();
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void whenCreateRecord() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.whenCreateRecord()");
//		PM_BANK_CHARGE_SETUP_DTL bean = getPM_BANK_CHARGE_SETUP_DTL_BEAN();
		CRUDHandler handler = new CRUDHandler();
		String query = "select sysdate from dual";
		ResultSet rs = handler.executeSelectStatement(query, getConnection());
		if(rs.next()){
		java.sql.Date date = rs.getDate(1);
			this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_EFF_FM_DT(date);
			this.PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_EFF_TO_DT(date);
		}
		CommonUtils.closeCursor(rs);
	}
	public Connection getConnection() throws Exception{
		Connection connection = CommonUtils.getConnection();
		return connection;
	}
	public Map<String, Object> getSession(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}
	public void preInsert(PM_BANK_CHARGE_SETUP_DTL bean) throws SQLException, Exception{
		Double M_BCSD_SYS_ID = null;
		String M_DUP_CHECK = null;
		String query=" SELECT P_BCSD_SYS_ID.NEXTVAL FROM DUAL";
		String query1 = " SELECT 'X' " +
		" FROM PM_BANK_CHARGE_SETUP_DTL" +
		" WHERE (? BETWEEN BCSD_EFF_FM_DT  AND BCSD_EFF_TO_DT" +
		" OR  ? BETWEEN BCSD_EFF_FM_DT  AND BCSD_EFF_TO_DT" +
		" OR BCSD_EFF_FM_DT BETWEEN ?  AND ?" +
		" OR BCSD_EFF_TO_DT BETWEEN ? AND ?)" +
		" AND BCSD_BCSH_SYS_ID    = ? AND (? BETWEEN BCSD_AMT_LC_FM  AND BCSD_AMT_LC_TO" +
		" OR  ? BETWEEN BCSD_AMT_LC_FM  AND BCSD_AMT_LC_TO" +
		" OR BCSD_AMT_LC_FM BETWEEN ?  AND ?" +
		" OR BCSD_AMT_LC_TO BETWEEN ?" +
		" AND ?)";
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		ResultSet rs2 = null;
		ResultSet rs1 = null;
		Connection connection = null;
		
		try{
			connection = CommonUtils.getConnection();
		 rs1 = handler.executeSelectStatement(query, connection);
		if(rs1.next()){
			M_BCSD_SYS_ID = rs1.getDouble(1);
		}
		System.out.println("... "+bean.getBCSD_AMT_LC_FM());
		PM_BANK_CHARGE_SETUP_HDR_ACTION action = (PM_BANK_CHARGE_SETUP_HDR_ACTION) getSession().get("PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION");
		bean.setBCSD_SYS_ID(M_BCSD_SYS_ID);
		System.out.println("M_BCSD_SYS_ID :"+ bean.getBCSD_SYS_ID());
		bean.setBCSD_BCSH_SYS_ID(action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_SYS_ID());
		System.out.println("BCSD_BCSH_SYS_ID: " + bean.getBCSD_BCSH_SYS_ID());
		
		values  = new Object[]{PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_EFF_FM_DT(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_EFF_TO_DT(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_EFF_FM_DT(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_EFF_TO_DT(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_EFF_FM_DT(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_EFF_TO_DT(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_BCSH_SYS_ID(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_AMT_LC_FM(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_AMT_LC_TO(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_AMT_LC_FM(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_AMT_LC_TO(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_AMT_LC_FM(),
							   PM_BANK_CHARGE_SETUP_DTL_BEAN.getBCSD_AMT_LC_TO()};
		 rs2 = handler.executeSelectStatement(query1, connection,values);
		if(rs2.next()){
			M_DUP_CHECK = rs2.getString(1);
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91369"));
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally{
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(rs2);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}

	public void preUpdate() throws  Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.preUpdate()");
		//PM_BANK_CHARGE_SETUP_DTL bean = (PM_BANK_CHARGE_SETUP_DTL) getDataTable().getRowData();
		PM_BANK_CHARGE_SETUP_DTL bean = this.PM_BANK_CHARGE_SETUP_DTL_BEAN;
		String M_DUP_CHECK =null;
		String updQry = "SELECT 'X' FROM PM_BANK_CHARGE_SETUP_DTL" +
				" WHERE ('"+CommonUtils.dateToStringFormatter(bean.getBCSD_EFF_FM_DT())+"' BETWEEN BCSD_EFF_FM_DT  AND BCSD_EFF_TO_DT" +
				" OR  '"+CommonUtils.dateToStringFormatter(bean.getBCSD_EFF_TO_DT())+"'  BETWEEN BCSD_EFF_FM_DT  AND BCSD_EFF_TO_DT" +
				" OR BCSD_EFF_FM_DT BETWEEN '"+CommonUtils.dateToStringFormatter(bean.getBCSD_EFF_FM_DT())+"'  AND '"+CommonUtils.dateToStringFormatter(bean.getBCSD_EFF_TO_DT())+"'"+
				" OR BCSD_EFF_TO_DT BETWEEN '"+CommonUtils.dateToStringFormatter(bean.getBCSD_EFF_FM_DT())+"'"+
				" AND '"+CommonUtils.dateToStringFormatter(bean.getBCSD_EFF_TO_DT())+"')" +
				" AND BCSD_BCSH_SYS_ID    = "+bean.getBCSD_BCSH_SYS_ID()+
				" AND ("+bean.getBCSD_AMT_LC_FM()+" BETWEEN BCSD_AMT_LC_FM  AND BCSD_AMT_LC_TO" +
				" OR  "+bean.getBCSD_AMT_LC_TO()+" BETWEEN BCSD_AMT_LC_FM  AND BCSD_AMT_LC_TO" +
				" OR BCSD_AMT_LC_FM BETWEEN "+bean.getBCSD_AMT_LC_FM()+"  AND "+bean.getBCSD_AMT_LC_TO()+
				" OR BCSD_AMT_LC_TO BETWEEN "+bean.getBCSD_AMT_LC_FM()+
				" AND "+bean.getBCSD_AMT_LC_TO()+")" +
				" AND BCSD_SYS_ID <> "+bean.getBCSD_SYS_ID();
		System.out.println("update : - "+updQry);
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = handler.executeSelectStatement(updQry, getConnection());
		if(rs.next()){
			M_DUP_CHECK = rs.getString(1);
		}else{
//			 STD_MESSAGE_ROUTINE(91369,:CTRL.M_LANG_CODE);
		}
		CommonUtils.closeCursor(rs);
	}
	public HtmlInputHidden getBCSD_BCSH_SYS_ID() {
		return BCSD_BCSH_SYS_ID;
	}

	public void setBCSD_BCSH_SYS_ID(HtmlInputHidden bcsd_bcsh_sys_id) {
		BCSD_BCSH_SYS_ID = bcsd_bcsh_sys_id;
	}

	public HtmlInputHidden getBCSD_SYS_ID() {
		return BCSD_SYS_ID;
	}

	public void setBCSD_SYS_ID(HtmlInputHidden bcsd_sys_id) {
		BCSD_SYS_ID = bcsd_sys_id;
	}
	
	public String goHDRBlock(){
		System.out.println("PM_BANK_CHARGE_SETUP_DTL_ACTION.goHDRBlock()");
		PM_BANK_CHARGE_SETUP_HDR_ACTION HDR_ACTION = (PM_BANK_CHARGE_SETUP_HDR_ACTION) getSession().get("PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION");
		if(HDR_ACTION!=null){
			HDR_ACTION.setFormFlag(true);
			HDR_ACTION.setBlockFlag(true);
		}
		//PM_BANK_CHARGE_SETUP_DTL_BEAN = new PM_BANK_CHARGE_SETUP_DTL();
		return "header";
	}
	
	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = 0;//dataGrid.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColomnListener();
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
	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009

	/*public UIData getDataGrid() {
		return dataGrid;
	}

	public void setDataGrid(UIData dataGrid) {
		this.dataGrid = dataGrid;
	}*/
	
	public String saveRecord(){
		try {
			String message = null;
			Connection connection = null;
			connection = CommonUtils.getConnection();
			CommonUtils utils = new CommonUtils();
			utils.doComitt();
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		return "";
	}

	/**
	 * @return the filterByBCSD_RATE
	 */
	public String getFilterByBCSD_RATE() {
		return filterByBCSD_RATE;
	}

	/**
	 * @param filterByBCSD_RATE the filterByBCSD_RATE to set
	 */
	public void setFilterByBCSD_RATE(String filterByBCSD_RATE) {
		this.filterByBCSD_RATE = filterByBCSD_RATE;
	}

	/**
	 * @return the filterByBCSD_AMT_LC_FM
	 */
	public String getFilterByBCSD_AMT_LC_FM() {
		return filterByBCSD_AMT_LC_FM;
	}

	/**
	 * @param filterByBCSD_AMT_LC_FM the filterByBCSD_AMT_LC_FM to set
	 */
	public void setFilterByBCSD_AMT_LC_FM(String filterByBCSD_AMT_LC_FM) {
		this.filterByBCSD_AMT_LC_FM = filterByBCSD_AMT_LC_FM;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DEL
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	/**
	 * @param ui_m_but_del the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
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
	
	/**
	 * Add New component
	 * @param event
	 */
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PM_BANK_CHARGE_SETUP_DTL_BEAN = new PM_BANK_CHARGE_SETUP_DTL();
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
	
	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isDELETE_ALLOWED()) {
				if (PM_BANK_CHARGE_SETUP_DTL_BEAN.getROWID() != null) {
					new CRUDHandler().executeDelete(PM_BANK_CHARGE_SETUP_DTL_BEAN, CommonUtils
																.getConnection());
					dataList.remove(PM_BANK_CHARGE_SETUP_DTL_BEAN);
				}

				if (dataList.size() > 0) {
					setPM_BANK_CHARGE_SETUP_DTL_BEAN(dataList.get(0));
				} else {
					AddRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllComponent();
				PM_BANK_CHARGE_SETUP_DTL_BEAN.setRowSelected(true);
			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}

	}
	/**
	 * Reset All the compent value
	 */
	private void resetAllComponent(){
		COMP_BCSD_AMT_LC_FM.resetValue();
		COMP_BCSD_AMT_LC_TO.resetValue();
		COMP_BCSD_MIN_CHG_LC.resetValue();
		COMP_BCSD_MAX_CHG_LC.resetValue();
		COMP_BCSD_EFF_FM_DT.resetValue();
		COMP_BCSD_EFF_TO_DT.resetValue();
		COMP_BCSD_RATE_PER.resetValue();
		COMP_BCSD_RATE.resetValue();
	}

		/*
	 * Post the Value.
	 */
	public void post(ActionEvent ae) {
		PM006_A_APAC_HELPER helper = new PM006_A_APAC_HELPER();
		try{
			ControlBean controlBean = CommonUtils.getControlBean();
			if(PM_BANK_CHARGE_SETUP_DTL_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					preUpdate();
					new CRUDHandler().executeInsert(PM_BANK_CHARGE_SETUP_DTL_BEAN, new CommonUtils().getConnection());
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
					preInsert(PM_BANK_CHARGE_SETUP_DTL_BEAN);
					PILM039_DELIGATE deligate = new PILM039_DELIGATE();
					PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_CR_DT(new CommonUtils().getCurrentDate());
					PM_BANK_CHARGE_SETUP_DTL_BEAN.setBCSD_CR_UID(controlBean.getM_USER_ID());
					
					new CRUDHandler().executeInsert(PM_BANK_CHARGE_SETUP_DTL_BEAN, new CommonUtils().getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					dataList.add(PM_BANK_CHARGE_SETUP_DTL_BEAN);
					
					/*for(int i=0;i<dataList.size();i++){
						PM_BANK_CHARGE_SETUP_DTL pm_bank_charge_setup_dtl = dataList.get(i);
						if(i==0){
							pm_bank_charge_setup_dtl.setRowSelected(true);
							setPM_BANK_CHARGE_SETUP_DTL_BEAN(pm_bank_charge_setup_dtl);
						}else{
							pm_bank_charge_setup_dtl.setRowSelected(false);
						}
					}*/
					
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			//resetAllComponent();
			resetSelectedRow();
			PM_BANK_CHARGE_SETUP_DTL_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	public void getDetails() {
		try {
			if (dataList.size() != 0) {				
				PM_BANK_CHARGE_SETUP_DTL_BEAN = (PM_BANK_CHARGE_SETUP_DTL) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_BANK_CHARGE_SETUP_DTL_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_BANK_CHARGE_SETUP_DTL> iterator = dataList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/**
	 * @return the dataTable
	 */
	public UIDataTable getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the resultList
	 */
	public List<PM_BANK_CHARGE_SETUP_DTL> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List<PM_BANK_CHARGE_SETUP_DTL> resultList) {
		this.resultList = resultList;
	}

	/**
	 * @return the tabbedBar
	 */
	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	/**
	 * @param tabbedBar the tabbedBar to set
	 */
	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}


}
