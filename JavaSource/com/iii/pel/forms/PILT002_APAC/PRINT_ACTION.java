package com.iii.pel.forms.PILT002_APAC;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectManyListbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.pel.jasperreports.PremiaJasperSave;
import com.iii.pel.util.Email_Procedure_Call;
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
	/*Added By dhinesh 11.3.2016*/
	

	/*private PT_IL_POLICY_DELEGATE delegate=null;*/
	private HtmlOutputLabel COMP_UI_SCHEDULE_TYPE_LABEL;
	private HtmlSelectManyListbox  COMP_UI_SCHEDULE_TYPE;
	private HtmlOutputLabel COMP_UI_QUESTIONNAIRE_TYPE_LABEL;
	private HtmlSelectOneMenu  COMP_UI_QUESTIONNAIRE_TYPE;
	
	/*Added by saritha on 22-08-17 for ssp call id ZBILQC-1735415*/ 
	private  final static ResourceBundle resourceBundle=ResourceBundle.getBundle("FalconReports");
	/*End*/
	
	public HtmlSelectOneMenu getCOMP_UI_QUESTIONNAIRE_TYPE() {
		return COMP_UI_QUESTIONNAIRE_TYPE;
	}

	public void setCOMP_UI_QUESTIONNAIRE_TYPE(
			HtmlSelectOneMenu cOMP_UI_QUESTIONNAIRE_TYPE) {
		COMP_UI_QUESTIONNAIRE_TYPE = cOMP_UI_QUESTIONNAIRE_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_QUESTIONNAIRE_TYPE_LABEL() {
		return COMP_UI_QUESTIONNAIRE_TYPE_LABEL;
	}

	public void setCOMP_UI_QUESTIONNAIRE_TYPE_LABEL(
			HtmlOutputLabel cOMP_UI_QUESTIONNAIRE_TYPE_LABEL) {
		COMP_UI_QUESTIONNAIRE_TYPE_LABEL = cOMP_UI_QUESTIONNAIRE_TYPE_LABEL;
	}

	private PRINT_HELPER helper;
	public PILT002_APAC_COMPOSITE_ACTION compositeAction;
	
		

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/*Added by dhinesh 12.3.2016*/
	private List<String> UI_M_SCHEDULE_TYPE;
	private String UI_M_QUESTIONNAIRE_TYPE;
	private PremiaJasperSave saveBean;

	public String getUI_M_QUESTIONNAIRE_TYPE() {
		return UI_M_QUESTIONNAIRE_TYPE;
	}

	public void setUI_M_QUESTIONNAIRE_TYPE(String uI_M_QUESTIONNAIRE_TYPE) {
		UI_M_QUESTIONNAIRE_TYPE = uI_M_QUESTIONNAIRE_TYPE;
	}

	StringBuffer url=null;


	public List<String> getUI_M_SCHEDULE_TYPE() {
		return UI_M_SCHEDULE_TYPE;
	}

	public void setUI_M_SCHEDULE_TYPE(List<String> uI_M_SCHEDULE_TYPE) {
		UI_M_SCHEDULE_TYPE = uI_M_SCHEDULE_TYPE;
	}

	/*end*/

	private List<SelectItem> listUI_M_SCHEDULE_TYPE = new ArrayList<SelectItem>();
	/*Added by saritha on 22-08-17 for ssp call id ZBILQC-1735415*/ 
	private List<SelectItem> listUI_M_FINANCIAL_TYPE = new ArrayList<SelectItem>();

	public List<SelectItem> getListUI_M_FINANCIAL_TYPE() {
		return listUI_M_FINANCIAL_TYPE;
	}

	public void setListUI_M_FINANCIAL_TYPE(List<SelectItem> listUI_M_FINANCIAL_TYPE) {
		this.listUI_M_FINANCIAL_TYPE = listUI_M_FINANCIAL_TYPE;
	}
	
	private List<SelectItem> listUI_M_QUESTIONNAIRE_TYPE = new ArrayList<SelectItem>();
	
	private IP_REP_INFO IP_REP_INFO_BEAN;
	
	
	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO iP_REP_INFO_BEAN) {
		IP_REP_INFO_BEAN = iP_REP_INFO_BEAN;
	}
	/*End*/
	public PRINT_ACTION() throws Exception {
		
		System.out.println(" PILT002_APAC Enter the PRINT_ACTION Constructor");
		helper=new PRINT_HELPER();
		IP_REP_INFO_BEAN = new IP_REP_INFO();  
		saveBean = new PremiaJasperSave();
		/*Commentted by saritha on 22-08-17 for ssp call id ZBILQC-1735415*/ 
		//getListUI_M_QUESTIONNAIRE_TYPE();
		//getListUI_M_SCHEDULE_TYPE();
		//prepareDropDowns();
		/*End*/
	}



	public List<SelectItem> getListUI_M_QUESTIONNAIRE_TYPE() {
		
		listUI_M_QUESTIONNAIRE_TYPE=UI_M_QUESTIONNAIRE_TYPELIST();
		return listUI_M_QUESTIONNAIRE_TYPE;
	}

	public void setListUI_M_QUESTIONNAIRE_TYPE(
			List<SelectItem> listUI_M_QUESTIONNAIRE_TYPE) {
		this.listUI_M_QUESTIONNAIRE_TYPE = listUI_M_QUESTIONNAIRE_TYPE;
	}

	public List<SelectItem> getListUI_M_SCHEDULE_TYPE() 
	{
		//listUI_M_SCHEDULE_TYPE=UI_M_SCHEDULE_TYPELIST();		

		System.out.println("listUI_M_SCHEDULE_TYPE   88888 : "+listUI_M_SCHEDULE_TYPE.size());

		return listUI_M_SCHEDULE_TYPE;
	}

	public void setListUI_M_SCHEDULE_TYPE(List<SelectItem> listUI_M_SCHEDULE_TYPE) {
		this.listUI_M_SCHEDULE_TYPE = listUI_M_SCHEDULE_TYPE;
	}



	public HtmlOutputLabel getCOMP_UI_SCHEDULE_TYPE_LABEL() {
		return COMP_UI_SCHEDULE_TYPE_LABEL;
	}

	public void setCOMP_UI_SCHEDULE_TYPE_LABEL(
			HtmlOutputLabel cOMP_UI_SCHEDULE_TYPE_LABEL) {
		COMP_UI_SCHEDULE_TYPE_LABEL = cOMP_UI_SCHEDULE_TYPE_LABEL;
	}

	

	public HtmlSelectManyListbox getCOMP_UI_SCHEDULE_TYPE() {
		return COMP_UI_SCHEDULE_TYPE;
	}

	public void setCOMP_UI_SCHEDULE_TYPE(HtmlSelectManyListbox cOMP_UI_SCHEDULE_TYPE) {
		COMP_UI_SCHEDULE_TYPE = cOMP_UI_SCHEDULE_TYPE;
	}
	
	

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}


	public void validatorSCHEDULE_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			setUI_M_SCHEDULE_TYPE((List<String>)value);
			System.out.println("getUI_M_SCHEDULE_TYPE()   : "+getUI_M_SCHEDULE_TYPE());


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validatorQUESTIONNAIRE_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("*********** Enter the validatorQUESTIONNAIRE_TYPE *************");
			setUI_M_QUESTIONNAIRE_TYPE(value.toString());
			System.out.println("getUI_M_QUESTIONNAIRE_TYPE : "+getUI_M_QUESTIONNAIRE_TYPE());
			/*Commentted by saritha on 22-08-17 for ssp call id ZBILQC-1735415*/ 
			//setListUI_M_SCHEDULE_TYPE(UI_M_SCHEDULE_TYPELIST(getUI_M_QUESTIONNAIRE_TYPE()));
			/*End*/
			System.out.println("ListUI_M_SCHEDULE_TYPE Size : "+getListUI_M_SCHEDULE_TYPE().size());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*Commentted &Modified by saritha on 17-08-2017 for ssp call id ZBILQC-1735415 as per Thiag sir sugg*/
	/*public ArrayList<SelectItem> UI_M_QUESTIONNAIRE_TYPELIST(){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			System.out.println("****************  UI_M_QUESTIONNAIRE_TYPELIST   *****************");
			
			selectItem = new SelectItem();
			selectItem.setLabel("OCCUPATION");
			selectItem.setValue("OCCUPATION");
			list.add(selectItem);
		
			selectItem = new SelectItem();
			selectItem.setLabel("MEDICAL");
			selectItem.setValue("MEDICAL");
			list.add(selectItem);
			
			selectItem = new SelectItem();
			selectItem.setLabel("FINANCIAL");
			selectItem.setValue("FINANCIAL");
			list.add(selectItem);
			
			selectItem = new SelectItem();
			selectItem.setLabel("BMI");
			selectItem.setValue("BMI");
			list.add(selectItem);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}return list;
		}*/
	
	public ArrayList<SelectItem> UI_M_QUESTIONNAIRE_TYPELIST(){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			System.out.println("****************  UI_M_QUESTIONNAIRE_TYPELIST   *****************");
			selectItem = new SelectItem();
			selectItem.setLabel("FINANCIAL");
			selectItem.setValue("FINANCIAL");
			list.add(selectItem);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}return list;
		}
	
	

	/*public ArrayList<SelectItem> UI_M_SCHEDULE_TYPELIST(String questionnaire){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			System.out.println("****************  UI_M_SCHEDULE_TYPELIST   *****************");
			
			if(questionnaire.equalsIgnoreCase("MEDICAL"))
			{
						
				//aDDED BY SARITHA
				System.out.println("MEDICAL  Block  ");
				
				selectItem = new SelectItem();
				selectItem.setLabel("SICKLE CELL DISEASE");
				selectItem.setValue("SICKLE CELL DISEASE");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("PEPTICULCER QUESTIONNAIRE");
				selectItem.setValue("PEPTICULCER QUESTIONNAIRE");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("BLOODPRESSURE");
				selectItem.setValue("BLOODPRESSURE");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("CARDIAC SURGERY CARDIOLOGIST");
				selectItem.setValue("CARDIAC SURGERY CARDIOLOGIST");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("CORONARY ARTERY DISEASE QUESTIONNAIRE");
				selectItem.setValue("CORONARY ARTERY DISEASE QUESTIONNAIRE");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("DIABETES MELLITUS");
				selectItem.setValue("DIABETES MELLITUS");
				list.add(selectItem);
							
				selectItem = new SelectItem();
				selectItem.setLabel("STROKE QUESTIONNAIRE");
				selectItem.setValue("STROKE QUESTIONNAIRE");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("THYROID QUESTIONNAIRE");
				selectItem.setValue("THYROID QUESTIONNAIRE");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("TUMOUR QUESTIONNAIRE");
				selectItem.setValue("TUMOUR QUESTIONNAIRE");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("MEDICALEXAMINATION FORM ");
				selectItem.setValue("MEDICALEXAMINATION FORM ");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("HEALTH DECLARATION ARABICGL");
				selectItem.setValue("HEALTH DECLARATION ARABICGL");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("ASTHMA RESPIRATORY DISORDERS");
				selectItem.setValue("ASTHMA RESPIRATORY DISORDERS");
				list.add(selectItem);
				
			}else if(questionnaire.equalsIgnoreCase("FINANCIAL"))
			{
				System.out.println("FINANCIAL  Block  ");
				

				selectItem = new SelectItem();
				selectItem.setLabel("FINANCIALQUESTIONAIRE SWISS");
				selectItem.setValue("FINANCIALQUESTIONAIRE SWISS");
				list.add(selectItem);
		
				selectItem = new SelectItem();
				selectItem.setLabel("FINANCIALQUESTIONNAIRE BANKLOAN SWISS");
				selectItem.setValue("FINANCIALQUESTIONNAIRE BANKLOAN SWISS");
				list.add(selectItem);
			
				selectItem = new SelectItem();
				selectItem.setLabel("FINANCIALQUESTIONNAIRE SHORTFORM");
				selectItem.setValue("FINANCIALQUESTIONNAIRE SHORTFORM");
				list.add(selectItem);
			
				
				
				selectItem = new SelectItem();
				selectItem.setLabel("FINANCIALQUESTIONNAIRE LETTER");
				selectItem.setValue("FINANCIALQUESTIONNAIRE LETTER");
				list.add(selectItem);
			
			}else if(questionnaire.equalsIgnoreCase("OCCUPATION"))
			{
				System.out.println("******* OCCUPATION  Block *****");
				
				selectItem = new SelectItem();
				selectItem.setLabel("OCCUPATION QUESTIONNAIRE_1");
				selectItem.setValue("OCCUPATION QUESTIONNAIRE_1");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("OCCUPATION QUESTIONNAIRE_2");
				selectItem.setValue("OCCUPATION QUESTIONNAIRE_2");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				selectItem.setLabel("DIVING QUESTIONNAIRE");
				selectItem.setValue("DIVING QUESTIONNAIRE");
				list.add(selectItem);
				//ADDED BY SARITHA
				selectItem = new SelectItem();
				selectItem.setLabel("KEYMANINSURANCE QUESTIONNAIRE");
				selectItem.setValue("KEYMANINSURANCE QUESTIONNAIRE");
				list.add(selectItem);
				
				//Added by saritha
				
				selectItem = new SelectItem();
				selectItem.setLabel("MILITARY AVIATION");
				selectItem.setValue("MILITARY AVIATION");
				list.add(selectItem);
				
			}
			
			
			
			
			System.out.println("SELECITEM   : "+selectItem.getValue());


			System.out.println("schedule_type  Size   : "+list.size());


		} catch (Exception e) {
			// TODO: handle exception
		}


		return list;

	}*/
	
	/*Added by saritha on 22/08/17 for ssp call id ZBILQC-1735415*/
	private void prepareDropDowns(){
		try{
			Connection connection = CommonUtils.getConnection();
			System.out.println("ENTERS INTO prepareDropDowns");
			setListUI_M_FINANCIAL_TYPE(ListItemUtil.getDropDownListValue_1(connection, 
					"PILT002_APAC","DUMMY", 
					"DUMMY.M_FINANCIAL", 
					null));
			listUI_M_SCHEDULE_TYPE=getDropDownListValue(connection,"N","PRO",getUI_M_QUESTIONNAIRE_TYPE());	
			System.out.println("<****************LIST_VALUE******"+getUI_M_QUESTIONNAIRE_TYPE());

		}catch (Exception e) {
		}

	}
	/*End*/
	
	public ArrayList<SelectItem> UI_M_SCHEDULE_TYPELIST(String questionnaire){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			System.out.println("****************  UI_M_SCHEDULE_TYPELIST   *****************");
			
			
			if(questionnaire.equalsIgnoreCase("FINANCIAL"))
			{
				System.out.println("FINANCIAL  Block  ");
			
				selectItem = new SelectItem();
				selectItem.setLabel("FINANCIALQUESTIONNAIRE LETTER");
				selectItem.setValue("FINANCIALQUESTIONNAIRE LETTER");
				list.add(selectItem);
			
			}
			System.out.println("SELECITEM   : "+selectItem.getValue());
			System.out.println("schedule_type  Size   : "+list.size());

		} catch (Exception e) {
			// TODO: handle exception
		}


		return list;

	}
	
	/*public void onLoad(PhaseEvent event){
		try{
			System.out.println("*********** PILT002_APAC   Print Action onLoad *************");
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				listUI_M_SCHEDULE_TYPE=UI_M_SCHEDULE_TYPELIST("OCCUPATION");	
				setBlockFlag(false);
			}	
		
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}*/
	
	public void onLoad(PhaseEvent event){
		try{
			System.out.println("*********** PILT002_APAC   Print Action onLoad *************");
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				/*Commentted & Modified by saritha on 22-08-17 for ssp call id ZBILQC-1735415*/ 
				//listUI_M_SCHEDULE_TYPE=UI_M_SCHEDULE_TYPELIST("FINANCIAL");
				compositeAction.getPRINT_ACTION_BEAN().setUI_M_QUESTIONNAIRE_TYPE("F");		
				COMP_UI_SCHEDULE_TYPE.setSelectedValues(listUI_M_SCHEDULE_TYPE.toArray());
				COMP_UI_QUESTIONNAIRE_TYPE.setDisabled(true);
				setBlockFlag(false);
				
				
			}	
			prepareDropDowns();
			/*End*/
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	/*End*/
	
	
	public String backButton(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		String pathContext = request.getContextPath();
		String requestUrl = request.getRequestURL().toString();
		System.out.println("Context path----/"+pathContext);
		System.out.println("Request Url---/"+requestUrl);
		//Added by saritha on 22-08-2017
		setBlockFlag(true);
		/*end*/
		return "PILT002_APAC_PT_IL_POLICY";
	}
	
	
	public String runAction(){
		try {
			System.out.println("******** Enter the RunAction Method ********");
			System.out.println("POL_NO  253    : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO());
			System.out.println("getPOL_SYS_ID  253    : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			//runActionAfterValidate();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}
	
	
	
	
	public String questionnaireButtonAction() {
		String outcome = null;
		try {
			outcome = "PILT002_PRINT";
		} catch (Exception exception) {
			exception.getMessage();
			getErrorMap().put("current", exception.getMessage());
		}
		return outcome;
	}
	
	
	/*Commentted & Modified by saritha on 22-08-17 for ssp call id ZBILQC-1735415*/ 
	/*public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		
		try {
			
			 Long POL_SYS_ID=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
			System.out.println("Pol_Sys_id---------->"+POL_SYS_ID);
			url=new StringBuffer(getRedirectUrl());
			url.append("QuestionnaireReportName="+getUI_M_SCHEDULE_TYPE().get(0)+"&POL_SYS_ID="+POL_SYS_ID);
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
	}*/
	
	public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		HttpServletRequest request = null;
		try {

			url=new StringBuffer(getRedirectUrl());
			String report_id =compositeAction.getPRINT_ACTION_BEAN().getUI_M_SCHEDULE_TYPE().get(0);
			IP_REP_INFO repInfo = new IP_REP_INFO();
			String REP_KEY_NO = new ReportUtils().getRepKeyNo();
			Long POL_SYS_ID=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
			System.out.println("Pol_Sys_Id          :"+POL_SYS_ID);
			System.out.println("REP_KEY_NO          :"+REP_KEY_NO);
			repInfo.setREP_KEY_NO(REP_KEY_NO);
			repInfo.setREP_VALUE_1("2");
			if(POL_SYS_ID != null)
			{
				repInfo.setREP_VALUE_2("POL_SYS_ID"+"&&&"+POL_SYS_ID);
			}

			Connection conn = CommonUtils.getConnection();
			int ins = new CRUDHandler().executeInsert(repInfo, conn);
			conn.commit();
			url.append("REP_KEY_NO="+REP_KEY_NO+"&REP_ID="+report_id+"&POL_SYS_ID="+POL_SYS_ID);
			setRedirectUrl(url.toString());
			if (getRedirectUrl() != null && !reportViewFlag){
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				response.sendRedirect(getRedirectUrl());
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	/*End*/
	
	public void chkQuestionnaireType(){
		CommonUtils.clearMaps(this);
		setReportViewFlag(false);
		if(getUI_M_SCHEDULE_TYPE().size()>1){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Not allowed to view more than one report");
			
		}
		else if(getUI_M_SCHEDULE_TYPE().size()<1)
		{
			getErrorMap().put("current", "Select Anyone Questionnaire Report To Print");
			
		}
		else{
			
			callReportModalPanel();
		}
		
		
		
	}
	
	//added for mail functionality
	
		/*Commentted & Modified by saritha on 22-08-2017 for ssp call id ZBILQC-1735415*/
	
		/*public void callEmailFunction() {		
			if(getUI_M_SCHEDULE_TYPE().size()>=1)
			{
			try {
				CommonUtils.clearMaps(this);
				saveBean.saveJasperPDFQuestionaries(this,compositeAction);
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Mail Sent Successfully" );
				
			} catch(Exception e1){
				e1.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e1.getMessage());
				
			}
		
		}
	else
	{
		getErrorMap().put("current", "Select Anyone Questionnaire Report To Sent Mail");
	}
		}*/
	
	public String callEmailFunction() throws Exception {
		HttpServletRequest request= null;
		try {
			setReportViewFlag(true);
			request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			String Url = null;
			compositeAction.getPRINT_ACTION_BEAN().runAction();
			compositeAction.getPRINT_ACTION_BEAN().runActionAfterValidate();
			Url = "http://"+request.getServerName() +":"+request.getServerPort()+"/"+compositeAction.getPRINT_ACTION_BEAN().getRedirectUrl();
			String emailStatusMessage = sendPostRequest(Url);					
			System.out.println("message ============>>>>>>>>>>" + emailStatusMessage);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					emailStatusMessage);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					emailStatusMessage);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public String sendPostRequest(String finalURL) throws Exception{
		finalURL = finalURL+"&viewtype=email";
		System.out.println("Post URL-->"+finalURL);
		
		
		URL obj = new URL(finalURL.split("\\?")[0]);
		String POST_PARAMS = finalURL.split("\\?")[1];
		System.out.println("POST_PARAMS --"+POST_PARAMS);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		StringBuffer response = new StringBuffer();
		StringBuffer outPutFileName = new StringBuffer();
		System.out.println("POST Response Code :: " + responseCode);
		
		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				outPutFileName.append(inputLine);
			}
			in.close();
			
			
			System.out.println("Received Attachment File names---->[" + outPutFileName+"]");	
			String polSysID = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString();
			String prodCode = getProdCode(polSysID);
			String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(prodCode, "FQN", polSysID, "C", outPutFileName.toString());
			System.out.println("Email Response message in post request--->"+emailStatusMessage);
			response.append(outPutFileName.toString().equals("")?"Unable to send attachment for this approval":emailStatusMessage);
			
		} else {
			System.out.println("POST request not worked");
			response.append("Unable to send the email");
		}
		
		return (response!=null?response.toString():"");
	}	
	
	
	public String getProdCode(String polSysID) throws Exception {
		 Connection connection = null;
		 ResultSet resultSet = null;
		 String prodCode = null;
		 String query = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		 try {
			 connection = CommonUtils.getConnection();
			 resultSet = new CRUDHandler().executeSelectStatement(query,
					 connection, new Object[] { polSysID });
			 if (resultSet.next()) {
				 prodCode = resultSet.getString(1);
			 }
		 } catch (DBException e) {
			 e.printStackTrace();
			 throw e;
		 } catch (SQLException e) {
			 e.printStackTrace();
			 throw e;
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw e;
		 } finally {
			 CommonUtils.closeCursor(resultSet);
		 }
		 return prodCode;
	 }
	/*End*/
		
		/*Added by Ram on 03/12/2016 for Business Rule master Report Design*/
		public String WHEN_BUTTON_PRESSED_M_BUT_OK()
		{
			System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
			String url = null;
				
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			url = request.getContextPath() + "/PREMIASchedule?";
			System.out.println("url   :  "+url);
		return url;	
		}
		/*End*/
		
		
		/*Added by saritha on 22-08-17 for ssp call id ZBILQC-1735415*/ 
		public static List<SelectItem> getDropDownListValue(Connection connection,String pol_status, String report_type, String typevalue/*,String Product_code*/){
		
		System.out.println("enters inside getDropDownListValue in commonREport action");
		
		
		List<SelectItem> listValues = null;
		String query = null;
		System.out.println("pol_status          :"+pol_status        +
				"report_type        :"+report_type        +"typevalue          :"+typevalue);
		
		
		
	/*	query = "SELECT PMLIT_KEY, PMLIT_VALUE " +
				  "FROM pm_rep_tab_dtl " +
				 " WHERE SYS_PARAM = ? " +
				   " AND ITEM_NAME = ? " +
				   " AND PMLIT_FLAG = ? "+
				   " AND PMILT_ADDL_STS like ?" ;*/
		query = "SELECT PMLIT_KEY, PMLIT_VALUE " +
				  "FROM pm_rep_tab_dtl " +
				 " WHERE SYS_PARAM = ? " +
				   " AND ITEM_NAME = ? " +
				   " AND PMLIT_FLAG = ? ";
			
			CRUDHandler handler = null;
			Object[] values = {pol_status , report_type ,typevalue/*,"%"+ Product_code+"%"*/};
			try {
				handler = new CRUDHandler();
				System.out.println("query            :"+query);
				System.out.println("connection            :"+connection);
				System.out.println("values            :"+values);
				
				/*Added by Ram on 08/09/2016*/
				int resultCount = 0;
				/*End*/
				
				ResultSet rst = handler.executeSelectStatement(query, connection, values);
				listValues = new ArrayList<SelectItem>();
				while(rst.next()){
					
					System.out.println("INSIDE WHILE LOOP");
					
					listValues.add(new SelectItem(rst.getString("PMLIT_KEY"),rst.getString("PMLIT_VALUE")));
					resultCount++;
				}
				rst.close();
				rst.getStatement().close();
				/*Added by Ram on 08/09/2016*/
				if(resultCount == 0)
				{
					listValues.add(new SelectItem("0","--Select--"));
				}
				/*End*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return listValues;
	}
	
		/*Added by saritha on 22-08-2017 for ssp call id ZBILQC-1735415*/
		private boolean reportViewFlag = false;

		public boolean isReportViewFlag() {
			return reportViewFlag;
		}

		public void setReportViewFlag(boolean reportViewFlag) {
			this.reportViewFlag = reportViewFlag;
		}
		/*End*/	
}