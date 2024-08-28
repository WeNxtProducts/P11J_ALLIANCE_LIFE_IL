package com.iii.pel.forms.PM091_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
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
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
public class PM_AGENT_BENEFIT_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ABD_RATE_LABEL;

	private HtmlInputText COMP_ABD_RATE;

	private HtmlOutputLabel COMP_ABD_RATE_PER_LABEL;

	private HtmlInputText COMP_ABD_RATE_PER;

	private HtmlOutputLabel COMP_ABD_LC_MIN_AMT_LABEL;

	private HtmlInputText COMP_ABD_LC_MIN_AMT;

	private HtmlOutputLabel COMP_ABD_LC_MAX_AMT_LABEL;

	private HtmlInputText COMP_ABD_LC_MAX_AMT;

	private HtmlOutputLabel COMP_ABD_LC_FYC_FM_LABEL;

	private HtmlInputText COMP_ABD_LC_FYC_FM;

	private HtmlOutputLabel COMP_ABD_LC_FYC_TO_LABEL;

	private HtmlInputText COMP_ABD_LC_FYC_TO;

	private HtmlOutputLabel COMP_ABD_NO_OF_POL_FM_LABEL;

	private HtmlInputText COMP_ABD_NO_OF_POL_FM;

	private HtmlOutputLabel COMP_ABD_NO_OF_POL_TO_LABEL;

	private HtmlInputText COMP_ABD_NO_OF_POL_TO;

	private HtmlOutputLabel COMP_ABD_BNF_FREQ_LABEL;

	private HtmlSelectOneMenu COMP_ABD_BNF_FREQ;

	private HtmlOutputLabel COMP_ABD_PROD_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_ABD_PROD_TYPE;

	private HtmlOutputLabel COMP_ABD_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_ABD_TYPE;
	
	private HtmlCommandButton addButton;

	private PM_AGENT_BENEFIT_DTL PM_AGENT_BENEFIT_DTL_BEAN;
	
	private String filterByABD_LC_FYC_FM;
	
	private String filterByABD_LC_FYC_TO;
	
	private String filterByABD_NO_OF_POL_FM;
	
	private String filterByABD_NO_OF_POL_TO;
	
	private String filterByABD_BNF_FREQ;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	

	
	
	
	//*******************DATATABLE***********************
	private List<PM_AGENT_BENEFIT_DTL> dtlTableList;
	
	private UIDataTable dtlTable;
	
	
	
	//****************************COMBOBOX***********************************
	Connection con = null;
	private List<SelectItem> LIST_ABD_BNF_FREQ = new ArrayList<SelectItem>();
	private List<SelectItem> LIST_ABD_PROD_TYPE = new ArrayList<SelectItem>();
	private List<SelectItem> LIST_ABD_TYPE = new ArrayList<SelectItem>();
	
	

	public PM091_A_COMPOSITE_ACTION compositeAction;
	
	public PM_AGENT_BENEFIT_DTL_ACTION() {
		 try {
			 PM_AGENT_BENEFIT_DTL_BEAN = new PM_AGENT_BENEFIT_DTL();
			 dtlTableList = new ArrayList<PM_AGENT_BENEFIT_DTL>();
			con= CommonUtils.getConnection();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	}

	public void onLoad(PhaseEvent event){
		try {
			if (isBlockFlag()) {
				fetchData();
				setBlockFlag(false);
			}
			if(PM_AGENT_BENEFIT_DTL_BEAN.getROWID() ==  null){
				whenCreateRecord();
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
		
	}
	
	public void whenCreateRecord(){
		getPM_AGENT_BENEFIT_DTL_BEAN().setABD_BNF_FREQ("M");
		getPM_AGENT_BENEFIT_DTL_BEAN().setABD_PROD_TYPE("P");
		getPM_AGENT_BENEFIT_DTL_BEAN().setABD_TYPE("F");
	}
	
	public void preInsert() throws Exception{
		try {
			PM_AGENT_BENEFIT_DTL_BEAN.setABD_CR_DT( new CommonUtils().getCurrentDate());
			PM_AGENT_BENEFIT_DTL_BEAN.setABD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			PM_AGENT_BENEFIT_DTL_BEAN.setABD_ABH_BNF_CODE(compositeAction.getPM_AGENT_BENEFIT_HDR_ACTION_BEAN().getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE());
			duplicateRangeCheck(PM_AGENT_BENEFIT_DTL_BEAN);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
			
	
	public void duplicateRangeCheck(PM_AGENT_BENEFIT_DTL valuebean)throws Exception{
		String TEMP = new PM_AGENT_BENEFIT_DTL_DataGridDelegate()
				.duplicateCheck(valuebean);
		if (new CommonUtils().isDuplicate(valuebean.getROWID(), TEMP)) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91049"));
		}
	}
	
	
	public void preUpdate() throws ParseException{
		PM_AGENT_BENEFIT_DTL_BEAN.setABD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		PM_AGENT_BENEFIT_DTL_BEAN.setABD_UPD_DT(new CommonUtils().getCurrentDate());
	}
	
	
	private void clearMaps(){
		getErrorMap().clear();
		getWarningMap().clear();
	}
	
	
	public void validateRecord(FacesContext fc,UIComponent component, Object value){
		try {
			getPM_AGENT_BENEFIT_DTL_BEAN().setABD_TYPE((String)value);
			preInsert();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	
	public void ABD_TYPE_validate(ActionEvent ae){
		CommonUtils.clearMaps(this);
		PM_AGENT_BENEFIT_DTL bean = (PM_AGENT_BENEFIT_DTL)getDtlTable().getRowData(); 
		UIInput input = (UIInput) ae.getComponent().getParent();
		String rateType = null;
		double ratePer = 1.0;
		rateType = (String) input.getSubmittedValue();
		System.out.println(">>>>>>>>>>>Rate type: "+rateType+", Bean: "+bean);
		bean.setABD_TYPE(rateType);
		try{
			clearMaps();
			
			if("F".equals(rateType)){
				bean.setABD_RATE_PER(ratePer);
				COMP_ABD_RATE_PER.resetValue();
			}
			ErrorHelpUtil.validate(input, getErrorMap());
			
		}catch(ValidatorException exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getFacesMessage().getDetail());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, exc.getFacesMessage().getDetail());
		}
	}
	

	
	
	
	
	
	
	

	
	public String deleteRow() {
		PM_AGENT_BENEFIT_DTL deleteBean = null;
		int deletedRecordIndex = 0;
		if(dtlTableList.size()!=0){
			PM_AGENT_BENEFIT_DTL_DataGridDelegate gridDelegate = new PM_AGENT_BENEFIT_DTL_DataGridDelegate();
			for(int i =0;i<dtlTableList.size();){
				deleteBean = (PM_AGENT_BENEFIT_DTL )dtlTableList.get(i);
				if(deleteBean.isSelected()){
					dtlTableList.remove(deleteBean);
					deletedRecordIndex = gridDelegate.deleteData(deleteBean);
				}else{
					i++;
				}
			}
			
		}
		
		return null;
	}
	
	
	public String combinedSave(){
		try {
			PM_AGENT_BENEFIT_DTL_DataGridDelegate gridDelegate = new PM_AGENT_BENEFIT_DTL_DataGridDelegate();
			gridDelegate.saveData(this);	
			CommonUtils.getConnection().commit();
			getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put("detail", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
			
		}	
		return null;
	}
	

/*public String fetch(){
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
	HttpSession session = request.getSession();
	PM_AGENT_BENEFIT_HDR_ACTION sessionBean = (PM_AGENT_BENEFIT_HDR_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
	String code = sessionBean.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
		List dataTableList = new ArrayList<PM_AGENT_BENEFIT_DTL>();
		PM_AGENT_BENEFIT_DTL_DataGridDelegate gridDelegate = new PM_AGENT_BENEFIT_DTL_DataGridDelegate();
		dataTableList =gridDelegate.fetchValues(code);
		dtlTableList.clear();
		System.out.println("PM_IL_WDS_CHARGES_SETUP_ACTION.fetch()---["+dataTableList.size()+"]---["+code+"]");
		if(dataTableList.size()!=0){
		for(int i=0;i<dataTableList.size();i++){
			//System.out.println("PM_IL_WDS_CHARGES_SETUP_ACTION.fetch()--["+i+"]");
			//System.out.println("PM_IL_WDS_CHARGES_SETUP_ACTION.fetch()-----["+((PM_IL_WDS_CHARGES_SETUP)gridValueList.get(i)).getWCS_SETUP_TYPE()+"]");
			PM_AGENT_BENEFIT_DTL_BEAN = (PM_AGENT_BENEFIT_DTL)dataTableList.get(i);
			//System.out.println("PM_IL_WDS_CHARGES_SETUP_ACTION.fetch()--1--["+PM_IL_WDS_CHARGES_SETUP_BEAN.getWCS_CHARGE_CODE()+"]----[");
			dtlTableList.add(PM_AGENT_BENEFIT_DTL_BEAN );
			
			
		}
			
		}
		return "";
	
	}*/
		
	
// [Bug id -PREMIAGDC-000137 : added new method for Production type the default value should be Personal Production. : added by: Shankar bodduluri Dated: 13-Mar-2009 ]
	public void WHEN_CREATE_RECORD_PM_AGENT_BENEFIT_DTL(PM_AGENT_BENEFIT_DTL PM_AGENT_BENEFIT_DTL_BEAN){
		PM_AGENT_BENEFIT_DTL_BEAN.setABD_BNF_FREQ("M");
		PM_AGENT_BENEFIT_DTL_BEAN.setABD_PROD_TYPE("P");
	}
	
	

	//**************************TRAVERSAL********************************************************
	
	
	
	
	public String goToMasterBlock(){
		return "MasterBlock";
	}
	public String trvrsToDtLBlock(){
		return null;
	}
	
	public String goToApplicableRankBlock(){
		System.out
				.println("PM_AGENT_BENEFIT_DTL_ACTION.goToApplicableRankBlock(+++++++++++++++++++++++++++==)");
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		String benefitCode = null;
		List newList = new ArrayList<PM_AGENT_BENEFIT_APPL_RANK>();
		PM_AGENT_BENEFIT_HDR_ACTION sessionBean =null;
		PM_AGENT_BENEFIT_APPL_RANK_ACTION actionBean =null;
		if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION") != null) {
			 sessionBean = (PM_AGENT_BENEFIT_HDR_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
			 benefitCode =sessionBean.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
		}
	
		if(sessionBean==null){
			System.out
					.println("PM_AGENT_BENEFIT_DTL_ACTION.goToApplicableRankBlock(--SESSIONBEAN NULL)");
		}
		
		try{
			String selectQuery = "select ROWID,PM_AGENT_BENEFIT_APPL_RANK.* from PM_AGENT_BENEFIT_APPL_RANK where ABAR_ABH_BNF_CODE ='"+benefitCode+"'";
			System.out.println("PM_AGENT_BENEFIT_HDR_ACTION.trvrsToDtLBlock()---SELCTQUERY--["+selectQuery+"]");
			List list = new CRUDHandler().fetch(selectQuery,"com.iii.pel.forms.PM091_A.PM_AGENT_BENEFIT_APPL_RANK",con);
			
			if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_RANK_ACTION") != null) {
				 actionBean = (PM_AGENT_BENEFIT_APPL_RANK_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_RANK_ACTION");
			}
		
			else{
				ELResolver resolver = context.getApplication().getELResolver();
				actionBean = (PM_AGENT_BENEFIT_APPL_RANK_ACTION)resolver.getValue(context.getELContext(), null, "PM091_A_PM_AGENT_BENEFIT_APPL_RANK_ACTION");
				
			}
			for(Iterator<PM_AGENT_BENEFIT_APPL_RANK>i=list.iterator();i.hasNext();){
				
				PM_AGENT_BENEFIT_APPL_RANK listValue = i.next();
				String rankCodeDesc=getRankCodeDesc( listValue.getABAR_RANK_CODE());
				listValue.setUI_M_ABAR_RANK_CODE_DESC(rankCodeDesc);
				newList.add(listValue);
			}
			actionBean.setRankTableList(list);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		return "ApplicableRankBlock";
	}
	
	
	
	
	public String trvrslToProductBlock(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		String benefitCode = null;
		List newList = new ArrayList<PM_AGENT_BENEFIT_APPL_PROD>();
		PM_AGENT_BENEFIT_HDR_ACTION sessionBean =null;
		PM_AGENT_BENEFIT_APPL_PROD_ACTION actionBean =null;
		if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION") != null) {
			 sessionBean = (PM_AGENT_BENEFIT_HDR_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
			 benefitCode =sessionBean.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
		}
	
		if(sessionBean==null){
			System.out
					.println("PM_AGENT_BENEFIT_DTL_ACTION.goToApplicableRankBlock(--SESSIONBEAN NULL)");
		}
		
		try{
			String selectQuery = "select ROWID,PM_AGENT_BENEFIT_APPL_PROD.* from PM_AGENT_BENEFIT_APPL_PROD where ABNFAP_ABH_BNF_CODE ='"+benefitCode+"'";
			System.out.println("PM_AGENT_BENEFIT_HDR_ACTION.trvrsToDtLBlock()---SELCTQUERY--["+selectQuery+"]");
			List list = new CRUDHandler().fetch(selectQuery,"com.iii.pel.forms.PM091_A.PM_AGENT_BENEFIT_APPL_PROD",con);
			
			if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_PROD_ACTION") != null) {
				 actionBean = (PM_AGENT_BENEFIT_APPL_PROD_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_PROD_ACTION");
			}
		
			else{
				ELResolver resolver = context.getApplication().getELResolver();
				actionBean = (PM_AGENT_BENEFIT_APPL_PROD_ACTION)resolver.getValue(context.getELContext(), null, "PM091_A_PM_AGENT_BENEFIT_APPL_PROD_ACTION");
				
			}
			for(Iterator<PM_AGENT_BENEFIT_APPL_PROD>i=list.iterator();i.hasNext();){
				
				PM_AGENT_BENEFIT_APPL_PROD listValue = i.next();
				String productCodeDesc=getProductCodeDesc( listValue.getABNFAP_PROD_CODE(),listValue.getABNFAP_MODULE_ID());
				listValue.setUI_M_ABNFAP_PROD_CODE_DESC(productCodeDesc);
				newList.add(listValue);
			}
			actionBean.setProdTableList(list);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		
		
		
		return "ProductBlock";
	}
	
	public String getProductCodeDesc(String productcode,String moduleid){
		ResultSet rs =null;
		String productDesc=null;
		String ModuleId = moduleid;
		String codeValue= productcode;
		if(!codeValue.equals("")|| codeValue!=null){
		String desc = "SELECT PROD_DESC FROM   PV_LIFE_PRODUCTS WHERE  MODULE_ID ='"+ModuleId+"' and  PROD_CODE ='"+codeValue+"'";
		
		System.out
				.println("PM_AGENT_BENEFIT_APPL_RANK_ACTION.getProductCodeDesc()--QQQQQUERY--["+desc+"]");
		try{		
		 rs = new CRUDHandler().executeSelectStatement(desc, con);
		if(rs.next()){
			productDesc = rs.getString(1);
		}else{
			
			//WHEN-VALIDATE-ITEM
			/*STD_MESSAGE_ROUTINE(80223,:CTRL.M_LANG_CODE);   
			RAISE FORM_TRIGGER_FAILURE;*/
		}
		
		
		
		
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		finally{
			try{
				rs.close();
			}catch(Exception ex){
				ex.printStackTrace();
				
			}
		}
		}
		return productDesc;
		
	}
	
	public String trvrslToDetailBlock(){
		FacesContext context = FacesContext.getCurrentInstance();
		String benefitCode = null;
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_AGENT_BENEFIT_HDR_ACTION hdrBean =null;
		PM_AGENT_BENEFIT_DTL_ACTION sessionBean = null;
		if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION") != null) {
			 hdrBean = (PM_AGENT_BENEFIT_HDR_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
			 benefitCode =hdrBean.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
		}
	
		if(sessionBean==null){
			System.out
					.println("PM_AGENT_BENEFIT_DTL_ACTION.goToApplicableRankBlock(--SESSIONBEAN NULL)");
		}
		
		if(sessionBean == null) {
			System.out.println("sessionbean null");
		}
		try{
		String selectQuery = "select ROWID,PM_AGENT_BENEFIT_DTL.* from PM_AGENT_BENEFIT_DTL where ABD_ABH_BNF_CODE ='"+benefitCode+"'";
		System.out.println("PM_AGENT_BENEFIT_HDR_ACTION.trvrsToDtLBlock()---SELCTQUERY--["+selectQuery+"]");
		List<PM_AGENT_BENEFIT_DTL> list = new CRUDHandler().fetch(selectQuery,"com.iii.pel.forms.PM091_A.PM_AGENT_BENEFIT_DTL",con);
		for(Iterator<PM_AGENT_BENEFIT_DTL> i =list.iterator();i.hasNext();){
			PM_AGENT_BENEFIT_DTL x = i.next();
			x.setRowSelected(false);
			System.out.println("PM_AGENT_BENEFIT_HDR_ACTION.trvrsToDtLBlock()---["+x.getABD_LC_FYC_FM()+"]");
		}
		
		
		
		if(session.getAttribute("PM091_A_PM_AGENT_BENEFIT_DTL_ACTION")!=null){
		sessionBean = (PM_AGENT_BENEFIT_DTL_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_DTL_ACTION");
		}
		else{
		ELResolver resolver = context.getApplication().getELResolver();
		sessionBean = (PM_AGENT_BENEFIT_DTL_ACTION )resolver.getValue(context.getELContext(), null, "PM091_A_PM_AGENT_BENEFIT_DTL_ACTION");
		}
		if(sessionBean  == null) {
			System.out.println("actionbean null");
		}
		sessionBean.setDtlTableList(list);
		if(list.size()>0){
			sessionBean.setPM_AGENT_BENEFIT_DTL_BEAN(list.get(0));
			sessionBean.getPM_AGENT_BENEFIT_DTL_BEAN().setRowSelected(true);
		}
			
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "DetailBlock";
	}
	

	public String getRankCodeDesc( String rankCode){
		ResultSet rs =null;
		String rankDesc=null;
		String codeValue=rankCode;
		if(!codeValue.equals("")|| codeValue!=null){
		String desc = "select PC_DESC from pm_codes where PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL and PC_CODE ='"+codeValue+"'";
		try{		
		 rs = new CRUDHandler().executeSelectStatement(desc, con);
		if(rs.next()){
			rankDesc = rs.getString(1);
			
		}else{
			
			//WHEN-VALIDATE-ITEM
			/*STD_MESSAGE_ROUTINE(80223,:CTRL.M_LANG_CODE);   
			RAISE FORM_TRIGGER_FAILURE;*/
		}
		
		
		
		
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		finally{
			try{
				rs.close();
			}catch(Exception ex){
				ex.printStackTrace();
				
			}
		}
		}
		return rankDesc;
	}
	
	//**************************VALIDATIONS****************************************************
	public void validateAmount(ActionEvent ae){
		// Clearing maps
		CommonUtils.clearMaps(this);
		//added by Varun on 16-feb-2009 for grid modifications
		UIInput input = (UIInput) ae.getComponent().getParent(); // input comp
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validatorFromAmount(FacesContext fc,UIComponent component, Object value)
	throws ValidatorException{
		Double fromAmount=(Double)value;
		/*int rowidx=dtlTable.getRowIndex();
		PM_AGENT_BENEFIT_DTL pm_agent_benefit_dtl=dtlTableList.get(rowidx);*/
		getPM_AGENT_BENEFIT_DTL_BEAN().setABD_LC_FYC_FM(fromAmount);
		Double toFieldAmt=PM_AGENT_BENEFIT_DTL_BEAN.getABD_LC_FYC_TO();
		
		// Set the value to bean
		getPM_AGENT_BENEFIT_DTL_BEAN().setABD_LC_FYC_FM(fromAmount);
		
		//System.out.println("Row idx: "+rowidx+"From Amt: "+fromAmount+", To Amt: "+toFieldAmt);
		if(fromAmount !=null && toFieldAmt!=null){
			//double toAmount = Double.parseDouble(toFieldAmount);
			//double frmAmt = Double.parseDouble(fromAmount);
			if(fromAmount<0){
				System.out
						.println("PM_AGENT_BENEFIT_DTL_ACTION.validatorFromAmount()-***");
				 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91052")); 
			}
			else if(toFieldAmt!=null){
				if(fromAmount>toFieldAmt){
				 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91054"));
				}
				
			}
		}
		
		
	}
	
	
	public void validatorToAmount(FacesContext fc,UIComponent component, Object value)
	throws ValidatorException{
		Double toFieldAmount = (Double)value;
		/*int rowIdx=dtlTable.getRowIndex();
		PM_AGENT_BENEFIT_DTL pm_agent_benefit_dtl=dtlTableList.get(rowIdx);*/
		getPM_AGENT_BENEFIT_DTL_BEAN().setABD_LC_FYC_TO(toFieldAmount);
		double frmAmt;

		Double  fmAmt=PM_AGENT_BENEFIT_DTL_BEAN.getABD_LC_FYC_FM();
		//System.out.println("Row idx: "+rowIdx+"From Amt: "+fmAmt+", To Amt: "+toFieldAmount);
		if(toFieldAmount !=null){
			
			if(toFieldAmount<0){
				 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91052")); 
			}
			else if(fmAmt!=null){
				
				if(fmAmt>toFieldAmount){
				 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91054"));
				}
				
			}
		}
		
	}
	public void validatorNoOfPolFrom(FacesContext fc,UIComponent component, Object value)
	throws ValidatorException{

		/*String fromField = value.toString();
		String toField = null;
		double toFieldNo = 0;
		System.out.println("To >>>>>>>>>"+getCOMP_ABD_NO_OF_POL_TO().getSubmittedValue());
		System.out.println("STATUS:::::::::"+(!("".equals(getCOMP_ABD_NO_OF_POL_TO().getSubmittedValue()))));
		if(!(""==getCOMP_ABD_NO_OF_POL_TO().getSubmittedValue()))
		{
			System.out.println("if>>>>>>>>>>>>>>>>>>>>>>");
			toField=(String)getCOMP_ABD_NO_OF_POL_TO().getSubmittedValue();
			if(toField==null){
				toFieldNo =(Double)getCOMP_ABD_NO_OF_POL_TO().getValue();
			}else{
			toFieldNo = Double.parseDouble(toField);
			}
		}
		if(fromField !=null){
			double fromFieldNo = Double.parseDouble(fromField);
			if(fromFieldNo<0){
				 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91052")); 
			}
			else if(toField!=null){
				if(fromFieldNo>toFieldNo){
				 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91054"));
				}else{
					rowChangeListener();
				}
				
			}else{
				rowChangeListener();
			}
		}else{
			rowChangeListener();
		}
		*/
		
		/*int rowIdx = dtlTable.getRowIndex();
		PM_AGENT_BENEFIT_DTL dtlBean = dtlTableList.get(rowIdx);*/
		Integer fromField = (Integer) value;
		Integer toField = PM_AGENT_BENEFIT_DTL_BEAN.getABD_NO_OF_POL_TO();
		getPM_AGENT_BENEFIT_DTL_BEAN().setABD_NO_OF_POL_FM(fromField);

		System.out.println("Num of Policies-From validator- From:"+fromField+", To: "+toField);
		if(fromField != null){
			if(fromField < 0){
				 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91052")); 
			} else if(toField != null){
				if(fromField > toField){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91054"));
				}
			}
			
		}
	}
	
	
	
	public void validatorNoOfPolTo(FacesContext fc,UIComponent component, Object value)
	throws ValidatorException{
		/*String toField = value.toString();
		double fromFieldNo;
		String fromField=(String)getCOMP_ABD_NO_OF_POL_FM().getSubmittedValue();
		if(fromField==null){
			fromFieldNo = (Double)getCOMP_ABD_NO_OF_POL_FM().getValue();
		}else{
		 fromFieldNo = Double.parseDouble(fromField);
		}
		
		if(toField !=null){
			double toFieldNo = Double.parseDouble(toField);
			if(toFieldNo<=0){
				 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91052")); 
			}
			else if(fromField!=null){
				if(fromFieldNo>toFieldNo){
				 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91054"));
				}else{
					rowChangeListener();
				}
				
			}else{
				rowChangeListener();
			}
		}else{
			rowChangeListener();
		}*/
		
		/*int rowIdx = dtlTable.getRowIndex();
		PM_AGENT_BENEFIT_DTL dtlBean = dtlTableList.get(rowIdx);*/
		Integer toField = (Integer)value;
		Integer fromField = PM_AGENT_BENEFIT_DTL_BEAN.getABD_NO_OF_POL_FM();
		getPM_AGENT_BENEFIT_DTL_BEAN().setABD_NO_OF_POL_TO(toField);
		
		System.out.println("Num of Policies-To validator- From:"+fromField+", To: "+toField);
		if(toField != null){
			if(toField <= 0){
				 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91052")); 
			} else if(fromField != null){
				if(fromField > toField){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91054"));
				}
			}
		}	
	}
	
	// [ validators are written to populate the value to bean
	public void validatorAbdBnfFreq(FacesContext fc,UIComponent component, Object value){
		/*int rowIdx = dtlTable.getRowIndex();
		PM_AGENT_BENEFIT_DTL dtlBean = dtlTableList.get(rowIdx);*/

		System.out.println("Validator ABD_BNF_FREQ value: "+(String)value);
		getPM_AGENT_BENEFIT_DTL_BEAN().setABD_BNF_FREQ((String)value);
	}
	public void validatorAbdProdType(FacesContext fc,UIComponent component, Object value){
		/*int rowIdx = dtlTable.getRowIndex();
		PM_AGENT_BENEFIT_DTL dtlBean = dtlTableList.get(rowIdx);*/

		System.out.println("Validator ABD_PROD_TYPE value: "+(String)value);
		getPM_AGENT_BENEFIT_DTL_BEAN().setABD_PROD_TYPE((String)value);
	}
	// validators are written to populate the value to bean ]

	public void validatorRatePer(FacesContext fc,UIComponent component, Object value) throws ValidatorException
	{
		if(value != null){ 
	           Double TEST_RATE_PER = (Double)value;
	    if(TEST_RATE_PER<=0)
         {
         	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91026"));
         	//getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "80001"));
         }
         getPM_AGENT_BENEFIT_DTL_BEAN().setABD_RATE_PER(TEST_RATE_PER); 
 }
	}
	
	
	
	public void validatorLCMaxAmt(FacesContext fc,UIComponent component, Object value) throws ValidatorException{
		String maxAmt= value.toString();
		double minAmtNo;
		try {
			if(maxAmt !=null){
				String minAmount=(String)getCOMP_ABD_LC_MIN_AMT().getSubmittedValue();
				if(minAmount==null){
					 minAmtNo= (Double)getCOMP_ABD_LC_MIN_AMT().getValue();
				}else{
				 minAmtNo = Double.parseDouble(minAmount);
				}
				double maxAmtNo = Double.parseDouble(maxAmt);
				if( maxAmtNo<0){
					 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91052")); 
				}
				else if(minAmount!=null){
					if(minAmtNo>maxAmtNo){
					 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91054"));
					}else{
						// [Commented for grid implementation change, Added by: Varun Dayal Mathur, Dated: 16-Feb-2009 
						//lastColumnListener();
						// Commented for grid implementation change, Added by: Varun Dayal Mathur, Dated: 16-Feb-2009 ]
					}
					
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	
	
	
	
	public HtmlOutputLabel getCOMP_ABD_RATE_LABEL() {
		return COMP_ABD_RATE_LABEL;
	}

	public HtmlInputText getCOMP_ABD_RATE() {
		return COMP_ABD_RATE;
	}

	public void setCOMP_ABD_RATE_LABEL(HtmlOutputLabel COMP_ABD_RATE_LABEL) {
		this.COMP_ABD_RATE_LABEL = COMP_ABD_RATE_LABEL;
	}

	public void setCOMP_ABD_RATE(HtmlInputText COMP_ABD_RATE) {
		this.COMP_ABD_RATE = COMP_ABD_RATE;
	}

	public HtmlOutputLabel getCOMP_ABD_RATE_PER_LABEL() {
		return COMP_ABD_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_ABD_RATE_PER() {
		return COMP_ABD_RATE_PER;
	}

	public void setCOMP_ABD_RATE_PER_LABEL(HtmlOutputLabel COMP_ABD_RATE_PER_LABEL) {
		this.COMP_ABD_RATE_PER_LABEL = COMP_ABD_RATE_PER_LABEL;
	}

	public void setCOMP_ABD_RATE_PER(HtmlInputText COMP_ABD_RATE_PER) {
		this.COMP_ABD_RATE_PER = COMP_ABD_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_ABD_LC_MIN_AMT_LABEL() {
		return COMP_ABD_LC_MIN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_ABD_LC_MIN_AMT() {
		return COMP_ABD_LC_MIN_AMT;
	}

	public void setCOMP_ABD_LC_MIN_AMT_LABEL(HtmlOutputLabel COMP_ABD_LC_MIN_AMT_LABEL) {
		this.COMP_ABD_LC_MIN_AMT_LABEL = COMP_ABD_LC_MIN_AMT_LABEL;
	}

	public void setCOMP_ABD_LC_MIN_AMT(HtmlInputText COMP_ABD_LC_MIN_AMT) {
		this.COMP_ABD_LC_MIN_AMT = COMP_ABD_LC_MIN_AMT;
	}

	public HtmlOutputLabel getCOMP_ABD_LC_MAX_AMT_LABEL() {
		return COMP_ABD_LC_MAX_AMT_LABEL;
	}

	public HtmlInputText getCOMP_ABD_LC_MAX_AMT() {
		return COMP_ABD_LC_MAX_AMT;
	}

	public void setCOMP_ABD_LC_MAX_AMT_LABEL(HtmlOutputLabel COMP_ABD_LC_MAX_AMT_LABEL) {
		this.COMP_ABD_LC_MAX_AMT_LABEL = COMP_ABD_LC_MAX_AMT_LABEL;
	}

	public void setCOMP_ABD_LC_MAX_AMT(HtmlInputText COMP_ABD_LC_MAX_AMT) {
		this.COMP_ABD_LC_MAX_AMT = COMP_ABD_LC_MAX_AMT;
	}

	public HtmlOutputLabel getCOMP_ABD_LC_FYC_FM_LABEL() {
		return COMP_ABD_LC_FYC_FM_LABEL;
	}

	public HtmlInputText getCOMP_ABD_LC_FYC_FM() {
		return COMP_ABD_LC_FYC_FM;
	}

	public void setCOMP_ABD_LC_FYC_FM_LABEL(HtmlOutputLabel COMP_ABD_LC_FYC_FM_LABEL) {
		this.COMP_ABD_LC_FYC_FM_LABEL = COMP_ABD_LC_FYC_FM_LABEL;
	}

	public void setCOMP_ABD_LC_FYC_FM(HtmlInputText COMP_ABD_LC_FYC_FM) {
		this.COMP_ABD_LC_FYC_FM = COMP_ABD_LC_FYC_FM;
	}

	public HtmlOutputLabel getCOMP_ABD_LC_FYC_TO_LABEL() {
		return COMP_ABD_LC_FYC_TO_LABEL;
	}

	public HtmlInputText getCOMP_ABD_LC_FYC_TO() {
		return COMP_ABD_LC_FYC_TO;
	}

	public void setCOMP_ABD_LC_FYC_TO_LABEL(HtmlOutputLabel COMP_ABD_LC_FYC_TO_LABEL) {
		this.COMP_ABD_LC_FYC_TO_LABEL = COMP_ABD_LC_FYC_TO_LABEL;
	}

	public void setCOMP_ABD_LC_FYC_TO(HtmlInputText COMP_ABD_LC_FYC_TO) {
		this.COMP_ABD_LC_FYC_TO = COMP_ABD_LC_FYC_TO;
	}

	public HtmlOutputLabel getCOMP_ABD_NO_OF_POL_FM_LABEL() {
		return COMP_ABD_NO_OF_POL_FM_LABEL;
	}

	public HtmlInputText getCOMP_ABD_NO_OF_POL_FM() {
		return COMP_ABD_NO_OF_POL_FM;
	}

	public void setCOMP_ABD_NO_OF_POL_FM_LABEL(HtmlOutputLabel COMP_ABD_NO_OF_POL_FM_LABEL) {
		this.COMP_ABD_NO_OF_POL_FM_LABEL = COMP_ABD_NO_OF_POL_FM_LABEL;
	}

	public void setCOMP_ABD_NO_OF_POL_FM(HtmlInputText COMP_ABD_NO_OF_POL_FM) {
		this.COMP_ABD_NO_OF_POL_FM = COMP_ABD_NO_OF_POL_FM;
	}

	public HtmlOutputLabel getCOMP_ABD_NO_OF_POL_TO_LABEL() {
		return COMP_ABD_NO_OF_POL_TO_LABEL;
	}

	public HtmlInputText getCOMP_ABD_NO_OF_POL_TO() {
		return COMP_ABD_NO_OF_POL_TO;
	}

	public void setCOMP_ABD_NO_OF_POL_TO_LABEL(HtmlOutputLabel COMP_ABD_NO_OF_POL_TO_LABEL) {
		this.COMP_ABD_NO_OF_POL_TO_LABEL = COMP_ABD_NO_OF_POL_TO_LABEL;
	}

	public void setCOMP_ABD_NO_OF_POL_TO(HtmlInputText COMP_ABD_NO_OF_POL_TO) {
		this.COMP_ABD_NO_OF_POL_TO = COMP_ABD_NO_OF_POL_TO;
	}

	public HtmlOutputLabel getCOMP_ABD_BNF_FREQ_LABEL() {
		return COMP_ABD_BNF_FREQ_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABD_BNF_FREQ() {
		return COMP_ABD_BNF_FREQ;
	}

	public void setCOMP_ABD_BNF_FREQ_LABEL(HtmlOutputLabel COMP_ABD_BNF_FREQ_LABEL) {
		this.COMP_ABD_BNF_FREQ_LABEL = COMP_ABD_BNF_FREQ_LABEL;
	}

	public void setCOMP_ABD_BNF_FREQ(HtmlSelectOneMenu COMP_ABD_BNF_FREQ) {
		this.COMP_ABD_BNF_FREQ = COMP_ABD_BNF_FREQ;
	}

	public HtmlOutputLabel getCOMP_ABD_PROD_TYPE_LABEL() {
		return COMP_ABD_PROD_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABD_PROD_TYPE() {
		return COMP_ABD_PROD_TYPE;
	}

	public void setCOMP_ABD_PROD_TYPE_LABEL(HtmlOutputLabel COMP_ABD_PROD_TYPE_LABEL) {
		this.COMP_ABD_PROD_TYPE_LABEL = COMP_ABD_PROD_TYPE_LABEL;
	}

	public void setCOMP_ABD_PROD_TYPE(HtmlSelectOneMenu COMP_ABD_PROD_TYPE) {
		this.COMP_ABD_PROD_TYPE = COMP_ABD_PROD_TYPE;
	}

	public HtmlOutputLabel getCOMP_ABD_TYPE_LABEL() {
		return COMP_ABD_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABD_TYPE() {
		return COMP_ABD_TYPE;
	}

	public void setCOMP_ABD_TYPE_LABEL(HtmlOutputLabel COMP_ABD_TYPE_LABEL) {
		this.COMP_ABD_TYPE_LABEL = COMP_ABD_TYPE_LABEL;
	}

	public void setCOMP_ABD_TYPE(HtmlSelectOneMenu COMP_ABD_TYPE) {
		this.COMP_ABD_TYPE = COMP_ABD_TYPE;
	}

	public PM_AGENT_BENEFIT_DTL getPM_AGENT_BENEFIT_DTL_BEAN() {
		return PM_AGENT_BENEFIT_DTL_BEAN;
	}

	public void setPM_AGENT_BENEFIT_DTL_BEAN(PM_AGENT_BENEFIT_DTL PM_AGENT_BENEFIT_DTL_BEAN) {
		this.PM_AGENT_BENEFIT_DTL_BEAN = PM_AGENT_BENEFIT_DTL_BEAN;
	}

	public List<SelectItem> getLIST_ABD_BNF_FREQ() {
		LIST_ABD_BNF_FREQ = ListItemUtil.getDropDownListValue(con, "PM091_A", "PM_AGENT_BENEFIT_DTL", "PM_AGENT_BENEFIT_DTL.ABD_BNF_FREQ", "PYMT_MODE");
		return LIST_ABD_BNF_FREQ;
	}

	public void setLIST_ABD_BNF_FREQ(List<SelectItem> list_abd_bnf_freq) {
		LIST_ABD_BNF_FREQ = list_abd_bnf_freq;
	}

	public List<SelectItem> getLIST_ABD_PROD_TYPE() {
		LIST_ABD_PROD_TYPE= ListItemUtil.getDropDownListValue(con, "PM091_A", "PM_AGENT_BENEFIT_DTL", "PM_AGENT_BENEFIT_DTL.ABD_PROD_TYPE", "PROD_TYPE");
		return LIST_ABD_PROD_TYPE;
	}

	public void setLIST_ABD_PROD_TYPE(List<SelectItem> list_abd_prod_type) {
		LIST_ABD_PROD_TYPE = list_abd_prod_type;
	}

	public List<SelectItem> getLIST_ABD_TYPE() {
		LIST_ABD_TYPE = ListItemUtil.getDropDownListValue(con, "PM091_A", "PM_AGENT_BENEFIT_DTL", "PM_AGENT_BENEFIT_DTL.ABD_TYPE", "BNF_VAL_TYP");
		return LIST_ABD_TYPE;
	}

	public void setLIST_ABD_TYPE(List<SelectItem> list_abd_type) {
		LIST_ABD_TYPE = list_abd_type;
	}
	
	
	

	public UIDataTable getDtlTable() {
		return dtlTable;
	}

	public void setDtlTable(UIDataTable dtlTable) {
		this.dtlTable = dtlTable;
	}

	public List<PM_AGENT_BENEFIT_DTL> getDtlTableList() {
		return dtlTableList;
	}

	public void setDtlTableList(List<PM_AGENT_BENEFIT_DTL> dtlTableList) {
		this.dtlTableList = dtlTableList;
	}





	public HtmlCommandButton getAddButton() {
		return addButton;
	}


	public void setAddButton(HtmlCommandButton addButton) {
		this.addButton = addButton;
	}


	
	
	public String setSelectStatus(ActionEvent event){
		int rowIndex = dtlTable.getRowIndex();
		String status = (String)((UIInput)event.getComponent().getParent()).getSubmittedValue();

		// Clearing maps
		clearMaps();
		
		dtlTableList.get(rowIndex).setSelected(Boolean.parseBoolean(status));
		
		return null;
	}


	
	// [ Added for grid implementation change, Added by: Varun Dayal Mathur, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dtlTable.getRowIndex();

		try{
			con.commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Saved SuccessFully");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, "Records Saved SuccessFully");
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	


	public String getFilterByABD_LC_FYC_FM() {
		return filterByABD_LC_FYC_FM;
	}


	public void setFilterByABD_LC_FYC_FM(String filterByABD_LC_FYC_FM) {
		this.filterByABD_LC_FYC_FM = filterByABD_LC_FYC_FM;
	}


	public String getFilterByABD_LC_FYC_TO() {
		return filterByABD_LC_FYC_TO;
	}


	public void setFilterByABD_LC_FYC_TO(String filterByABD_LC_FYC_TO) {
		this.filterByABD_LC_FYC_TO = filterByABD_LC_FYC_TO;
	}


	public String getFilterByABD_NO_OF_POL_FM() {
		return filterByABD_NO_OF_POL_FM;
	}


	public void setFilterByABD_NO_OF_POL_FM(String filterByABD_NO_OF_POL_FM) {
		this.filterByABD_NO_OF_POL_FM = filterByABD_NO_OF_POL_FM;
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


	public String getFilterByABD_NO_OF_POL_TO() {
		return filterByABD_NO_OF_POL_TO;
	}


	public void setFilterByABD_NO_OF_POL_TO(String filterByABD_NO_OF_POL_TO) {
		this.filterByABD_NO_OF_POL_TO = filterByABD_NO_OF_POL_TO;
	}


	public String getFilterByABD_BNF_FREQ() {
		return filterByABD_BNF_FREQ;
	}


	public void setFilterByABD_BNF_FREQ(String filterByABD_BNF_FREQ) {
		this.filterByABD_BNF_FREQ = filterByABD_BNF_FREQ;
	}
	
	public void getDetails() {
		try {
			if (dtlTableList.size() != 0) {				
				PM_AGENT_BENEFIT_DTL_BEAN = (PM_AGENT_BENEFIT_DTL) dtlTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_AGENT_BENEFIT_DTL_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_ABD_LC_FYC_FM.resetValue();
		COMP_ABD_LC_FYC_TO.resetValue();
		COMP_ABD_NO_OF_POL_FM.resetValue();
		COMP_ABD_NO_OF_POL_TO.resetValue();
		COMP_ABD_BNF_FREQ.resetValue();
		COMP_ABD_PROD_TYPE.resetValue();
		COMP_ABD_TYPE.resetValue();
		COMP_ABD_RATE.resetValue();
		COMP_ABD_RATE_PER.resetValue();
		COMP_ABD_LC_MIN_AMT.resetValue();
		COMP_ABD_LC_MAX_AMT.resetValue();
	}
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_AGENT_BENEFIT_DTL> iterator = dtlTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
public void deleteRow(ActionEvent ae) {
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();
			if(isDELETE_ALLOWED()) {
				if(PM_AGENT_BENEFIT_DTL_BEAN.getROWID() != null) {
					new CRUDHandler().executeDelete(PM_AGENT_BENEFIT_DTL_BEAN, CommonUtils.getConnection());
					dtlTableList.remove(PM_AGENT_BENEFIT_DTL_BEAN);
					resetAllComponent();
					getWarningMap().put("current","Record Deleted Sucessfully");
					getWarningMap().put("details","Record Deleted Sucessfully");
				}

				if(dtlTableList.size() > 0) {
				setPM_AGENT_BENEFIT_DTL_BEAN(dtlTableList.get(0));
				} else {
					addRow(ae);
				}
			} else {

				getErrorMap().clear();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}



	public void fetchData() throws Exception {
	
		String selectQuery = "SELECT  PM_AGENT_BENEFIT_DTL.*,PM_AGENT_BENEFIT_DTL.ROWID FROM PM_AGENT_BENEFIT_DTL WHERE ABD_ABH_BNF_CODE = ? ";
		ResultSet resultSet = null;
		try {
			resultSet = new CRUDHandler().executeSelectStatement(selectQuery, CommonUtils.getConnection(), 
					new Object[]{compositeAction.getPM_AGENT_BENEFIT_HDR_ACTION_BEAN().getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE()});
			PM_AGENT_BENEFIT_DTL PM_AGENT_BENEFIT_DTL_BEAN1 = null;
		
			getDtlTableList().clear();
			while (resultSet.next()){
				PM_AGENT_BENEFIT_DTL_BEAN1 = new PM_AGENT_BENEFIT_DTL();
				
				PM_AGENT_BENEFIT_DTL_BEAN1.setROWID(resultSet.getString("ROWID"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_ABH_BNF_CODE(resultSet.getString("ABD_ABH_BNF_CODE"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_BNF_FREQ(resultSet.getString("ABD_BNF_FREQ"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_PROD_TYPE(resultSet.getString("ABD_PROD_TYPE"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_LC_FYC_FM(resultSet.getDouble("ABD_LC_FYC_FM"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_LC_FYC_TO(resultSet.getDouble("ABD_LC_FYC_TO"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_NO_OF_POL_FM(resultSet.getInt("ABD_NO_OF_POL_FM"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_NO_OF_POL_TO(resultSet.getInt("ABD_NO_OF_POL_TO"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_TYPE(resultSet.getString("ABD_TYPE"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_RATE(resultSet.getDouble("ABD_RATE"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_RATE_PER(resultSet.getDouble("ABD_RATE_PER"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_LC_MIN_AMT(resultSet.getDouble("ABD_LC_MIN_AMT"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_LC_MAX_AMT(resultSet.getDouble("ABD_LC_MAX_AMT"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_CR_DT(resultSet.getDate("ABD_CR_DT"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_CR_UID(resultSet.getString("ABD_CR_UID"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_UPD_DT(resultSet.getDate("ABD_UPD_DT"));
				PM_AGENT_BENEFIT_DTL_BEAN1.setABD_UPD_UID(resultSet.getString("ABD_UPD_UID"));
				getDtlTableList().add(PM_AGENT_BENEFIT_DTL_BEAN1);
			}
		
		if (dtlTableList.size() > 0) {
			PM_AGENT_BENEFIT_DTL_BEAN = dtlTableList.get(0);
			PM_AGENT_BENEFIT_DTL_BEAN.setRowSelected(true);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
			
		finally{try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {e.printStackTrace();}}
	}

	
	public void post(ActionEvent event){
		try{
			if(PM_AGENT_BENEFIT_DTL_BEAN.getROWID()==null && isINSERT_ALLOWED()){
				preInsert();
				new CRUDHandler().executeInsert(PM_AGENT_BENEFIT_DTL_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"));
				getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"));
				dtlTableList.add(PM_AGENT_BENEFIT_DTL_BEAN);
			}else if(PM_AGENT_BENEFIT_DTL_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){
				preUpdate();
				new CRUDHandler().executeUpdate(PM_AGENT_BENEFIT_DTL_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
			}
			PM_AGENT_BENEFIT_DTL_BEAN.setRowSelected(true);
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: "+exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
		}
	}


	
	public void addRow(ActionEvent event){
		try{
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){
				PM_AGENT_BENEFIT_DTL_BEAN = new PM_AGENT_BENEFIT_DTL();
				whenCreateRecord();
				resetAllComponent();
				resetSelectedRow();
			}else{
				getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
			}

		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow",exc.getMessage());
		}
	}
	
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void validateABD_RATE(FacesContext context, UIComponent component,Object object) {
		Double value = (Double) object;
		try {
			PM_AGENT_BENEFIT_DTL_BEAN.setABD_RATE(value);
			whenvalidateABD_RATE();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
			
	}
			
 public void whenvalidateABD_RATE() throws Exception{
	
	 try {
		 if (PM_AGENT_BENEFIT_DTL_BEAN.getABD_RATE() != null) {
			 if (PM_AGENT_BENEFIT_DTL_BEAN.getABD_RATE() < 0) {
				 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91052"));
			 }
		 }
		 
		 if ("F".equals(PM_AGENT_BENEFIT_DTL_BEAN.getABD_TYPE()) ) {
			 PM_AGENT_BENEFIT_DTL_BEAN.setABD_LC_MIN_AMT(PM_AGENT_BENEFIT_DTL_BEAN.getABD_RATE());
			 PM_AGENT_BENEFIT_DTL_BEAN.setABD_LC_MAX_AMT(PM_AGENT_BENEFIT_DTL_BEAN.getABD_LC_MIN_AMT());
			 PM_AGENT_BENEFIT_DTL_BEAN.setABD_RATE_PER(1.00);
			 this.getCOMP_ABD_RATE_PER().setDisabled(true);
			 this.getCOMP_ABD_LC_MAX_AMT().setDisabled(true);
		 }else {
			 if (PM_AGENT_BENEFIT_DTL_BEAN.getABD_RATE() != null) {
				 if (PM_AGENT_BENEFIT_DTL_BEAN.getABD_RATE() > 100) {
					 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
				 }
			 }
			 PM_AGENT_BENEFIT_DTL_BEAN.setABD_LC_MIN_AMT(null);
			 PM_AGENT_BENEFIT_DTL_BEAN.setABD_LC_MAX_AMT(null);
			 this.getCOMP_ABD_RATE_PER().setDisabled(false);
			 this.getCOMP_ABD_LC_MAX_AMT().setDisabled(false);
		 }
		 
	 } catch (Exception e) {
		 e.printStackTrace();
		 throw new Exception(e.getMessage());
	 }
 } 
 
 
 
 public void validateABD_LC_MIN_AMT(FacesContext context, UIComponent component,Object object) {
		Double value = (Double) object;
		try {
			PM_AGENT_BENEFIT_DTL_BEAN.setABD_LC_MIN_AMT(value);
			whenvalidateABD_LC_MIN_AMT();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
			
	}
	 
	 public void whenvalidateABD_LC_MIN_AMT() throws Exception {
		 try {
			 if(PM_AGENT_BENEFIT_DTL_BEAN.getABD_LC_MIN_AMT() != null){
				 if(PM_AGENT_BENEFIT_DTL_BEAN.getABD_LC_MIN_AMT() < 0){
					 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91052"));

		   }
		 }
		
		 
		 if ("F".equals(PM_AGENT_BENEFIT_DTL_BEAN.getABD_TYPE())) {
			 PM_AGENT_BENEFIT_DTL_BEAN.setABD_LC_MAX_AMT(PM_AGENT_BENEFIT_DTL_BEAN.getABD_LC_MIN_AMT());
			 this.getCOMP_ABD_LC_MAX_AMT().setDisabled(false);
		}else {
			if(PM_AGENT_BENEFIT_DTL_BEAN.getABD_LC_MIN_AMT() != null){
				if(PM_AGENT_BENEFIT_DTL_BEAN.getABD_LC_MIN_AMT() > 100){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91052"));
				}
			}
		}
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new Exception(e.getMessage());
			 
		 }
 }
	
}
