package com.iii.pel.forms.PILT003_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.pel.util.RUPEE_TO_WORD;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PILT003_APAC_PRINTACTION extends CommonReportAction{
	public PILT003_APAC_COMPOSITE_ACTION compositeAction;
	public PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN;
	
	
	private PT_IL_POLICY PT_IL_POLICY_BEAN;
	
	
	
	
	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY pT_IL_POLICY_BEAN) {
		PT_IL_POLICY_BEAN = pT_IL_POLICY_BEAN;
	}

	public PT_IL_PREM_COLL_ACTION getPT_IL_PREM_COLL_ACTION_BEAN() {
		return PT_IL_PREM_COLL_ACTION_BEAN;
	}

	public void setPT_IL_PREM_COLL_ACTION_BEAN(
			PT_IL_PREM_COLL_ACTION pT_IL_PREM_COLL_ACTION_BEAN) {
		PT_IL_PREM_COLL_ACTION_BEAN = pT_IL_PREM_COLL_ACTION_BEAN;
	}


	public PILT003_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT003_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	public PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN ;
	PILT003_APAC_HELPER helper;
	public StringBuffer url;
	public PILT003_APAC_PRINTACTION()
	{
		/*
		 * Commented by Janani on 12.9.2016 for dynamic report config
		 * 
		 * getListUI_M_SCHEDULE_TYPE();*/
    

		helper=new PILT003_APAC_HELPER();
		PT_IL_PREM_COLL_ACTION_BEAN=new PT_IL_PREM_COLL_ACTION();
		PT_IL_POLICY_ACTION_BEAN=new PT_IL_POLICY_ACTION();
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();

		/*Added by Janani on 12.9.2016 for dynamic report config*/

		prepareDropDowns();

		/*END*/


	}

	public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION_BEAN() {
		return PT_IL_POLICY_ACTION_BEAN;
	}

	public void setPT_IL_POLICY_ACTION_BEAN(
			PT_IL_POLICY_ACTION pT_IL_POLICY_ACTION_BEAN) {
		PT_IL_POLICY_ACTION_BEAN = pT_IL_POLICY_ACTION_BEAN;
	}

	public PILT003_APAC_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PILT003_APAC_HELPER helper) {
		this.helper = helper;
	}


	private List<SelectItem> listUI_M_SCHEDULE_TYPE = new ArrayList<SelectItem>();
	public List<SelectItem> getListUI_M_SCHEDULE_TYPE() {

		/*
		 * Commented by Janani on 12.9.2016 for dynamic report config
		 * 
		 * listUI_M_SCHEDULE_TYPE=UI_M_SCHEDULE_TYPELIST();*/

		return listUI_M_SCHEDULE_TYPE;
	}
	public void setListUI_M_SCHEDULE_TYPE(List<SelectItem> listUI_M_SCHEDULE_TYPE) {
		this.listUI_M_SCHEDULE_TYPE = listUI_M_SCHEDULE_TYPE;
	}
	//commented by agalya
	/*private HtmlCommandButton COMP_UI_PRINT_BUTTON;
	public HtmlCommandButton getCOMP_UI_PRINT_BUTTON() {
		return COMP_UI_PRINT_BUTTON;
	}

	public void setCOMP_UI_PRINT_BUTTON(HtmlCommandButton cOMP_UI_PRINT_BUTTON) {
		COMP_UI_PRINT_BUTTON = cOMP_UI_PRINT_BUTTON;
	}
	 */
	private HtmlOutputLabel COMP_UI_SCHEDULE_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_UI_SCHEDULE_TYPE;
	public HtmlOutputLabel getCOMP_UI_SCHEDULE_TYPE_LABEL() {
		return COMP_UI_SCHEDULE_TYPE_LABEL;
	}

	public void setCOMP_UI_SCHEDULE_TYPE_LABEL(
			HtmlOutputLabel cOMP_UI_SCHEDULE_TYPE_LABEL) {
		COMP_UI_SCHEDULE_TYPE_LABEL = cOMP_UI_SCHEDULE_TYPE_LABEL;
	}
	public String backToSearch() {
		return "PILT003_APAC_PT_IL_PREM_COLL";
	}


	public HtmlSelectOneMenu getCOMP_UI_SCHEDULE_TYPE() {
		return COMP_UI_SCHEDULE_TYPE;
	}

	public void setCOMP_UI_SCHEDULE_TYPE(HtmlSelectOneMenu cOMP_UI_SCHEDULE_TYPE) {
		COMP_UI_SCHEDULE_TYPE = cOMP_UI_SCHEDULE_TYPE;
	}
	private String UI_M_SCHEDULE_TYPE;

	public String getUI_M_SCHEDULE_TYPE() {

		return UI_M_SCHEDULE_TYPE;
	}
	public void setUI_M_SCHEDULE_TYPE(String uI_M_SCHEDULE_TYPE) {
		UI_M_SCHEDULE_TYPE = uI_M_SCHEDULE_TYPE;
	}
	int PC_DRCR_DOC_NO=0;
	String PC_REF_NO=null;
	Date PC_DRCR_DOC_DT_NEW;
	String PC_DRCR_DOC_DT=null;
	String POL_SYS_ID=null;

	public void onLoad(PhaseEvent event){

		try
		{
			if(isBlockFlag()){
				POL_SYS_ID=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString();
				System.out.println("POL_SYS_ID   "+POL_SYS_ID);
			}

			setBlockFlag(false);
			//System.out.println("value of doc no->"+compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_DOC_NO());			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
	}

	public void validatorSCHEDULE_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			setUI_M_SCHEDULE_TYPE((String)value);
			System.out.println("getUI_M_SCHEDULE_TYPE()   : "+getUI_M_SCHEDULE_TYPE());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public ArrayList<SelectItem> UI_M_SCHEDULE_TYPELIST(){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			System.out.println("****************  UI_M_SCHEDULE_TYPELIST   *****************");

			selectItem = new SelectItem();
			selectItem.setLabel("Renewal Premium");
			selectItem.setValue("Renewal Premium");
			list.add(selectItem);

		}catch(Exception e)
		{
			e.printStackTrace();
		}return list;
	}
	public String runAction(){
		//added by krithika on 29-04-2016
		try {

			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK(this));


		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}
	String POL_NO=null;
	//String PC_REF_NO=compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_REF_NO();
	//int PC_DRCR_DOC_NO=compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_DRCR_DOC_NO();
	public  String selectapprovalstatus()throws Exception{

		System.out.println("inside insert method");
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		String sys_id=null;
		CRUDHandler handler = new CRUDHandler();	
		POL_NO=CommonUtils.getGlobalVariable("GLOBAL.M_POL_NUMBER");

		System.out.println("value of pol_number"+POL_NO);
		String query = "SELECT POL_SYS_ID FROM PT_IL_POLICY where POL_NO='"+POL_NO+"'";
		System.out.println("query exe sucess"+query);	     
		resultSet = new CRUDHandler().executeSelectStatement(query, connection);
		System.out.println("value for insert"+	handler.executeSelectStatement(query, connection));
		while (resultSet.next()) {
			sys_id=resultSet.getString("POL_SYS_ID");
		}
		return sys_id;
	}

	//String PC_REF_NO=PT_IL_PREM_COLL_ACTION_BEAN.getPT_IL_PREM_COLL_BEAN().getPC_REF_NO();/*CommonUtils.getGlobalVariable("PC_REF_NO");*/
	//int PC_DRCR_DOC_NO=PT_IL_PREM_COLL_ACTION_BEAN.getPT_IL_PREM_COLL_BEAN().getPC_DRCR_DOC_NO();/*CommonUtils.getGlobalVariable("PC_DRCR_DOC_NO");*/

	/*FacesContext context = FacesContext.getCurrentInstance();
HttpServletRequest request = (HttpServletRequest) context
		.getExternalContext().getRequest();
HttpSession session = request.getSession();

String PC_REF_NO= session.getAttribute("PC_REF_NO").toString();
String PC_DRCR_DOC_NO= session.getAttribute("PC_DRCR_DOC_NO").toString();*/
	
	
	/*Added by Janani on 12.9.2016 for dynamic report config*/
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session = request.getSession();
	
	
	/*END*/
	
	
	@Override
	
	/*
	 * 
	 * Commented by Janani on 12.9.2016 for dynamic report config
	 * 
	 * public String runActionAfterValidate() {CommonUtils.clearMaps(this);
	HttpServletResponse response = null;

	//added by krithika for report binding on 290416
	try {

		System.out.println("PC_REF_NO------->"+PC_REF_NO);
		System.out.println("PC_REF_NO-------->"+PC_REF_NO);
		String POL_SYS_ID=selectapprovalstatus();
		String reportvalue=getUI_M_SCHEDULE_TYPE();
		url=new StringBuffer(getRedirectUrl());
		System.out.println("this is url"+url.toString());
		url.append("RenewalPremium="+reportvalue+"&PC_REF_NO="+PC_REF_NO+"&PC_DRCR_DOC_NO="+PC_DRCR_DOC_NO+"&PC_DRCR_DOC_DT="+PC_DRCR_DOC_DT);
		System.out.println("after append"+url.toString());
		setRedirectUrl(url.toString());	

		if (getRedirectUrl() != null) {
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
			response.sendRedirect(getRedirectUrl());
		}
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("runAction", e.getMessage());
	}
	return null;
	}
	
	*
	*END
	*
	*/

	
	
	
	

	
	public String runActionAfterValidate() {CommonUtils.clearMaps(this);
	HttpServletResponse response = null;

	try {
		System.out.println("POL_SYS_ID-------->"+POL_SYS_ID);
		String USER_ID = (String) session.getAttribute("GLOBAL.M_USER_ID");
		String reportvalue=getUI_M_SCHEDULE_TYPE();
		String REP_KEY_NO = new ReportUtils().getRepKeyNo();
		System.out.println("REP_KEY_NO          :"+REP_KEY_NO);
		IP_REP_INFO repInfo = new IP_REP_INFO();
		repInfo.setREP_KEY_NO(REP_KEY_NO);
		repInfo.setREP_VALUE_1("7");
		repInfo.setREP_VALUE_2("POL_SYS_ID"+"&&&"+POL_SYS_ID);
		Connection conn = CommonUtils.getConnection();
		int ins = new CRUDHandler().executeInsert(repInfo, conn);
		conn.commit();
		url=new StringBuffer(getRedirectUrl());
		url.append("REP_KEY_NO="+REP_KEY_NO+"&REP_ID="+reportvalue);
		String reportViewType = CommonUtils.getGlobalVariable("reporttype");
		if(reportViewType!=null){
			url.append("&viewtype="+reportViewType);
		}
		/*end*/
		setRedirectUrl(url.toString());	

		if (getRedirectUrl() != null) {
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
			response.sendRedirect(getRedirectUrl());
		}
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("runAction", e.getMessage());
	}
	return null;
	}
	
	
	
	
	/*Added by Janani on 17.03.2017 for dynamic report config for base product*/
	
	
	//String prod_value=session.getAttribute("POL_PROD_CODE").toString();
	
	
	/*End*/
	
	
	public  String selectpol_prod_code()throws Exception{

		System.out.println("inside selectpol_prod_code method");
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		String prod_value=null;
	
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		System.out.println("compositeAction          "+compositeAction);
		System.out.println("getPT_IL_POLICY_ACTION_BEAN          "+compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		System.out.println("getPT_IL_POLICY_BEAN          "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
		
		CRUDHandler handler = new CRUDHandler();	
		Long pol_sys_is=PT_IL_POLICY_BEAN.getPOL_SYS_ID();
		String query = "SELECT POL_PROD_CODE FROM PT_IL_POLICY where POL_SYS_ID='"+pol_sys_is+"'";
		System.out.println("query exe sucess"+query);	     
		resultSet = new CRUDHandler().executeSelectStatement(query, connection);
		System.out.println("value for insert"+	handler.executeSelectStatement(query, connection));
		while (resultSet.next()) {
			prod_value=resultSet.getString("POL_PROD_CODE");

		}
		return prod_value;
	}
	
	
	
	/*Added by Janani on 12.9.2016 for dynamic report config*/
	
	private void prepareDropDowns(){
		try{

		/*
		 * Commented by Janani on 17.03.2017 for dynamic report config for base product
		 * 
		 * 
		 * 	listUI_M_SCHEDULE_TYPE=(CommonReportAction.getDropDownListValue( CommonUtils.getConnection(),"N", 
					"PREC","N"));*/
			
			listUI_M_SCHEDULE_TYPE=(CommonReportAction.getDropDownListValue( CommonUtils.getConnection(),"N", 
					"PREC","N"));
			
			//String prod_value = selectpol_prod_code();

			
			//System.out.println("prod_value in Renewal prem collection               :"+prod_value);
			
			/*listUI_M_SCHEDULE_TYPE=(CommonReportAction.getDropDownListValue_1( CommonUtils.getConnection(),"N", 
					"PREC","N","",null));*/
			
			

		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public String Decimal_Convert(String Value)
	{
		if(Value != null)
		{
			int decimalPlaces=3;
			/*System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
		 decimalPlaces=(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");*/
			System.out.println("decimalPlaces   : "+decimalPlaces);


			BigDecimal bd = new BigDecimal(Value);
			bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);

			return bd.toString();
		}
		else
		{
			return "0.000";
		}
	}
	
	
	
	/*END*/

}
