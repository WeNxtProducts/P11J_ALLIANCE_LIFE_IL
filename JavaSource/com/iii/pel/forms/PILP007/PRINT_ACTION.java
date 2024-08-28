package com.iii.pel.forms.PILP007;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.constants.REPORT_UTIL_CONSTANTS;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class PRINT_ACTION extends CommonReportAction{

	private HtmlOutputLabel COMP_UI_SCHEDULE_TYPE_LABEL;
	private HtmlSelectOneMenu  COMP_UI_SCHEDULE_TYPE;
	
	public DUMMY_ACTION action;
	public DUMMY_ACTION getAction() {
		return action;
	}
	public void setAction(DUMMY_ACTION action) {
		this.action = action;
	}
	public HtmlOutputLabel getCOMP_UI_SCHEDULE_TYPE_LABEL() {
		return COMP_UI_SCHEDULE_TYPE_LABEL;
	}
	public void setCOMP_UI_SCHEDULE_TYPE_LABEL(
			HtmlOutputLabel cOMP_UI_SCHEDULE_TYPE_LABEL) {
		COMP_UI_SCHEDULE_TYPE_LABEL = cOMP_UI_SCHEDULE_TYPE_LABEL;
	}
	public HtmlSelectOneMenu getCOMP_UI_SCHEDULE_TYPE() {
		return COMP_UI_SCHEDULE_TYPE;
	}
	public void setCOMP_UI_SCHEDULE_TYPE(HtmlSelectOneMenu cOMP_UI_SCHEDULE_TYPE) {
		COMP_UI_SCHEDULE_TYPE = cOMP_UI_SCHEDULE_TYPE;
	}
	public List<SelectItem> getListUI_M_SCHEDULE_TYPE() {
		
		/*
		 * Commented by Janani on 12.9.2016 for dynamic report config
		 * 
		 * listUI_M_SCHEDULE_TYPE=UI_M_SCHEDULE_TYPELIST();
		 * 
		 * End
		 * 
		 * */
		
		return listUI_M_SCHEDULE_TYPE;
	}
	public void setListUI_M_SCHEDULE_TYPE(List<SelectItem> listUI_M_SCHEDULE_TYPE) {
		this.listUI_M_SCHEDULE_TYPE = listUI_M_SCHEDULE_TYPE;
	}
	private PRINT_HELPER helper;
	
	//private DUMMY_ACTION dummy_action;
	
/*	public DUMMY_ACTION getDummy_action() {
		return dummy_action;
	}
	public void setDummy_action(DUMMY_ACTION dummy_action) {
		this.dummy_action = dummy_action;
	}*/
	public PRINT_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PRINT_HELPER helper) {
		this.helper = helper;
	}
	
	private List<SelectItem> listUI_M_SCHEDULE_TYPE = new ArrayList<SelectItem>();
	private String UI_M_SCHEDULE_TYPE;
	
	public String getUI_M_SCHEDULE_TYPE() {
			
		return UI_M_SCHEDULE_TYPE;
	}
	public void setUI_M_SCHEDULE_TYPE(String uI_M_SCHEDULE_TYPE) {
		UI_M_SCHEDULE_TYPE = uI_M_SCHEDULE_TYPE;
	}
	public PRINT_ACTION() {
		helper=new PRINT_HELPER();
		//action=new DUMMY_ACTION();
		getListUI_M_SCHEDULE_TYPE();
	}
	
	//added by krithika surrent quotation on 24-05-2016
	
	
	public void onLoad(PhaseEvent event){
		getErrorMap().clear();
		getWarningMap().clear();
		if(isBlockFlag()){
			CommonUtils.clearMaps(this);
			setBlockFlag(false);
			
			/*Added by Janani on 12.9.2016 for dynamic report config*/
		
			prepareDropDowns();
			
			/*End*/
		}
	}
	
	String Surrendertype=null;
	String listvalue=null;
	//end
	public void validatorSCHEDULE_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			setUI_M_SCHEDULE_TYPE((String)value);
			System.out.println("getUI_M_SCHEDULE_TYPE()   : "+getUI_M_SCHEDULE_TYPE());
			Surrendertype=action.getDUMMY_BEAN().getUI_M_SURR_TYPE();
			listvalue=getUI_M_SCHEDULE_TYPE();
			System.out.println("listvalue---->"+listvalue);
			System.out.println("Surrendertype-------->"+Surrendertype);
			/*
			 * Commented by Janani on 12.9.2016 for dynamic report config

			 * 
			 * 
			 * WHEN_REPORT_TYPE_VALUE_CHANGE();*/
					

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	//edited by krithika for surrender quotation on 24-05-2016
	public String printButtonAction()
	{
		
		String outcome = null;
		try {
			outcome = "PILP007_PRINT";
			
			/*Added by Janani on 12.9.2016 for dynamic report config*/
			
			action.getPRINT_ACTION_BEAN().setBlockFlag(true);
			
			/*End*/
			
		} catch (Exception exception) {
			exception.getMessage();
			getErrorMap().put("current", exception.getMessage());
		}
		return outcome;
		
	}

	public ArrayList<SelectItem> UI_M_SCHEDULE_TYPELIST(){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			System.out.println("****************  UI_M_SCHEDULE_TYPELIST   *****************");
			
			selectItem = new SelectItem();
			selectItem.setLabel("PAIDUP REVIEWSHEET");
			selectItem.setValue("PAIDUP REVIEWSHEET");
			list.add(selectItem);
			
			selectItem = new SelectItem();
			selectItem.setLabel("SURRENDER REVIEWSHEET");
			selectItem.setValue("SURRENDER REVIEWSHEET");
			list.add(selectItem);
			
			selectItem = new SelectItem();
			selectItem.setLabel("SURRENDER VALUE INTIMATION");
			selectItem.setValue("SURRENDER VALUE INTIMATION");
			list.add(selectItem);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}return list;
		}
	public String runAction(){
		try {
			System.out.println("******** Enter the RunAction Method ********");
			/*System.out.println("POL_NO  253    : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO());
			System.out.println("getPOL_SYS_ID  253    : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			*/System.out.println("action.getDUMMY_BEAN().getUI_M_SURR_TYPE()   : "+action.getDUMMY_BEAN().getUI_M_SURR_TYPE());
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			//runActionAfterValidate();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}

	StringBuffer url=null;

	public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		String SurrenderPaid=null;
		String reportvalue=getUI_M_SCHEDULE_TYPE();
		try {
			//action.getDUMMY_BEAN().getUI_M_SURR_TYPE();
			System.out.println("action.getDUMMY_BEAN().getUI_M_SURR_TYPE()   : "+action.getDUMMY_BEAN().getUI_M_SURR_TYPE());
			SurrenderPaid=action.getDUMMY_BEAN().getUI_M_SURR_TYPE();
			
			/*
			 * commendted by saritha
			 * if(SurrenderPaid.equalsIgnoreCase("S"))
			{
				SurrenderPaid="SURRENDER";	
			}
			else
			{
				SurrenderPaid="PAIDUP";
			}*/
			
			/*
			 * 
			 * Commented by Janani on 12.9.2016 for dynamic report config
			 * 
			 * if(reportvalue.equalsIgnoreCase("SURRENDER VALUE INTIMATION"))
			{
				url=new StringBuffer(getRedirectUrl());
				url.append("SURRENDERREPORT="+reportvalue+"&SMV_POL_NO="+action.getDUMMY_BEAN().getUI_M_POL_NO_FROM());
				setRedirectUrl(url.toString());
			}else if(reportvalue.equalsIgnoreCase("SURRENDER REVIEWSHEET"))
			{


				url=new StringBuffer(getRedirectUrl());
				url.append("SURRENDERREVIWSHEET="+reportvalue+"&SMV_POL_NO="+action.getDUMMY_BEAN().getUI_M_POL_NO_FROM());
				setRedirectUrl(url.toString());
			}


			else if(reportvalue.equalsIgnoreCase("PAIDUP REVIEWSHEET"))
			{
				url=new StringBuffer(getRedirectUrl());
				url.append("PAIDUPREVIWSHEET="+reportvalue+"&SMV_POL_NO="+action.getDUMMY_BEAN().getUI_M_POL_NO_FROM());
				setRedirectUrl(url.toString());
			}
			
			*
			*End
			*/
			
			
			

/*Added by Janani on 12.9.2016 for dynamic report config*/
			
			
			CRUDHandler handler = new CRUDHandler();
			String POL_Num=null;
			Connection conn = CommonUtils.getConnection();
			String query = "SELECT pol_sys_id FROM PT_IL_POLICY where pol_no='"+action.getDUMMY_BEAN().getUI_M_POL_NO_FROM()+"'";
			System.out.println("query exe sucess"+query);	     
			ResultSet resultSet = new CRUDHandler().executeSelectStatement(query, conn);
			System.out.println("value for insert"+	handler.executeSelectStatement(query, conn));
			while (resultSet.next()) {
				POL_Num=resultSet.getString("pol_sys_id");

			}
			
			IP_REP_INFO repInfo = new IP_REP_INFO();
			String REP_KEY_NO = new ReportUtils().getRepKeyNo();
			repInfo.setREP_KEY_NO(REP_KEY_NO);
			repInfo.setREP_VALUE_1("4");
			repInfo.setREP_VALUE_2("SMV_POL_NO"+"&&&"+POL_Num);
			repInfo.setREP_VALUE_3("Pol_Sys_id"+"&&&"+POL_Num);
			repInfo.setREP_VALUE_4("POL_Num"+"&&&"+POL_Num);
			
			int ins = handler.executeInsert(repInfo, conn);
			conn.commit();
			
			url=new StringBuffer(getRedirectUrl());
		url.append("REP_ID="+reportvalue+"&REP_KEY_NO="+REP_KEY_NO);
			setRedirectUrl(url.toString());
			
			/*end*/
			
			
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
	
	public String backButton()
	{
	String outcome=null;
  outcome="PILP007_PT_IL_SURR_MAT_VALUES";
	return outcome;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	
	public void WHEN_REPORT_TYPE_VALUE_CHANGE() throws Exception
	{
		
			System.out.println(" Surrendertype    :::"+Surrendertype);
			System.out.println("listvalue  :::"+listvalue);
		if((listvalue.equalsIgnoreCase("PAIDUP REVIEWSHEET"))&&(Surrendertype.equalsIgnoreCase("P"))) 
		{
			callReportModalPanel();
		}
		else if((listvalue.equalsIgnoreCase("SURRENDER REVIEWSHEET"))&&(Surrendertype.equalsIgnoreCase("S"))) 
		{
			callReportModalPanel();
		}
		else if((listvalue.equalsIgnoreCase("SURRENDER VALUE INTIMATION"))) 
		{
			callReportModalPanel();
		}
		else
		{
				throw new Exception("Not a valid report");
			} 
		}
	
	
	
	/*Added by Janani on 12.9.2016 for dynamic report config*/
	private void prepareDropDowns(){
		try{
		
			listUI_M_SCHEDULE_TYPE=(CommonReportAction.getDropDownListValue( CommonUtils.getConnection(),"N", 
					"SUR_PAID",action.getDUMMY_BEAN().getUI_M_SURR_TYPE()));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/*end*/
	
	
}
