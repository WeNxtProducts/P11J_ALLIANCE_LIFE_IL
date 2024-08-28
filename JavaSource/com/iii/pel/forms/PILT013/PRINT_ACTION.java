package com.iii.pel.forms.PILT013;

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
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class PRINT_ACTION extends CommonReportAction{
	/*Added By dhinesh 11.3.2016*/
	

	private PT_IL_POLICY_DELEGATE delegate=null;
	private HtmlOutputLabel COMP_UI_SCHEDULE_TYPE_LABEL;
	private HtmlOutputLabel COMP_UI_POLICY_NO_LABEL;
	private HtmlOutputText COMP_UI_POLICY_NO;
	private HtmlSelectOneMenu  COMP_UI_SCHEDULE_TYPE;
	private PT_IL_POLICY PT_IL_POLICY_BEAN;
	private PRINT_HELPER helper;
	public PILT013_COMPOSITE_ACTION compositeAction;
	/*added by dhinesh 0n 5-7-16 for FALCONQC-1714897*/
	private PT_IL_SURR_MAT_VALUES_ACTION PT_IL_SURR_MAT_VALUES_ACTION_BEAN;
	
	
	public PT_IL_SURR_MAT_VALUES_ACTION getPT_IL_SURR_MAT_VALUES_ACTION_BEAN() {
		return PT_IL_SURR_MAT_VALUES_ACTION_BEAN;
	}

	public void setPT_IL_SURR_MAT_VALUES_ACTION_BEAN(
			PT_IL_SURR_MAT_VALUES_ACTION pT_IL_SURR_MAT_VALUES_ACTION_BEAN) {
		PT_IL_SURR_MAT_VALUES_ACTION_BEAN = pT_IL_SURR_MAT_VALUES_ACTION_BEAN;
	}
	/*end*/

	public PILT013_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT013_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/*Added by dhinesh 12.3.2016*/
	private String UI_M_SCHEDULE_TYPE;
	

	StringBuffer url=null;


	public String getUI_M_SCHEDULE_TYPE() {
		return UI_M_SCHEDULE_TYPE;
	}

	public void setUI_M_SCHEDULE_TYPE(String uI_M_SCHEDULE_TYPE) {
		UI_M_SCHEDULE_TYPE = uI_M_SCHEDULE_TYPE;
	}

	/*end*/

	private List<SelectItem> listUI_M_SCHEDULE_TYPE = new ArrayList<SelectItem>();
	
	
	
	
	
	
	

	public PRINT_ACTION() throws Exception {
		
		System.out.println("Enter the PRINT_ACTION Constructor");
		helper=new PRINT_HELPER();
		PT_IL_POLICY_BEAN=new PT_IL_POLICY();
		
		/*added by gopi for dynamic report config on 03/04/2017*/
		IP_REP_INFO_BEAN=new IP_REP_INFO();
		getScheduleReportType();
		/*end*/

		
		/*added by Dhinesh on 5-7-16 for FALCONQC-1714897*/
		PT_IL_SURR_MAT_VALUES_ACTION_BEAN=new PT_IL_SURR_MAT_VALUES_ACTION();
	/*	end*/
		delegate=new PT_IL_POLICY_DELEGATE();
		
		/*
		 * Commented by Janani on 12.9.2016 for dynamic report config
		 * 
		 * getListUI_M_SCHEDULE_TYPE();*/
	
	System.out.println("Policy Number   : "+PT_IL_POLICY_BEAN.getPOL_NO());
	
	}



	public List<SelectItem> getListUI_M_SCHEDULE_TYPE() 
	{
		/*
		 * Commented by Janani on 12.9.2016 for dynamic report config
		 * 
		 * listUI_M_SCHEDULE_TYPE=UI_M_SCHEDULE_TYPELIST();	*/	

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

	public HtmlOutputLabel getCOMP_UI_POLICY_NO_LABEL() {
		return COMP_UI_POLICY_NO_LABEL;
	}

	public void setCOMP_UI_POLICY_NO_LABEL(HtmlOutputLabel cOMP_UI_POLICY_NO_LABEL) {
		COMP_UI_POLICY_NO_LABEL = cOMP_UI_POLICY_NO_LABEL;
	}

	public HtmlOutputText getCOMP_UI_POLICY_NO() {
		return COMP_UI_POLICY_NO;
	}

	public void setCOMP_UI_POLICY_NO(HtmlOutputText cOMP_UI_POLICY_NO) {
		COMP_UI_POLICY_NO = cOMP_UI_POLICY_NO;
	}

	public HtmlSelectOneMenu getCOMP_UI_SCHEDULE_TYPE() {
		return COMP_UI_SCHEDULE_TYPE;
	}

	public void setCOMP_UI_SCHEDULE_TYPE(HtmlSelectOneMenu cOMP_UI_SCHEDULE_TYPE) {
		COMP_UI_SCHEDULE_TYPE = cOMP_UI_SCHEDULE_TYPE;
	}


	public void validatorSCHEDULE_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			PT_IL_POLICY_BEAN.setUI_M_SCHEDULE_TYPE((String)value);
			/*added by Dhinesh on 5-7-16 for FALCONQC-1714897*/
			System.out.println("PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE()   : "+getUI_M_SCHEDULE_TYPE());
		String listvalue=PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE();
String appr_status=compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_APPRV_FLAG();
System.out.println("appr_status--------->"+appr_status);



			/*
			 * 
			 * Commented by Janani on 12.9.2016 for dynamic report config
			 * 
			 * helper.WHEN_REPORT_TYPE_VALUE_CHANGE(listvalue,appr_status);*/
			/*end*/

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*
	 * Commented by Janani on 12.9.2016 for dynamic report config
 * 
	 * 
	 * 
	 * public ArrayList<SelectItem> UI_M_SCHEDULE_TYPELIST(){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			System.out.println("****************  UI_M_SCHEDULE_TYPELIST   *****************");
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS().equals("S")){
				selectItem = new SelectItem();

				selectItem.setLabel("Payment");
				selectItem.setValue("Payment");
				list.add(selectItem);
				
				selectItem = new SelectItem();
				
				selectItem.setLabel("SurrenderReviewsheet");
				selectItem.setValue("SurrenderReviewsheet");
				list.add(selectItem);
				selectItem = new SelectItem();
				
				selectItem.setLabel("PaidUpReviewSheet");
				selectItem.setValue("PaidUpReviewSheet");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("SurrenderDischargeForm");
				selectItem.setValue("SurrenderDischargeForm");
				list.add(selectItem);
				
			}else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS().equals("M")){
				selectItem = new SelectItem();
					selectItem.setLabel("SurrenderValue");
					selectItem.setValue("SurrenderValue");
					list.add(selectItem);
					selectItem = new SelectItem();

					selectItem.setLabel("MaturityNotice");
					selectItem.setValue("MaturityNotice");
					list.add(selectItem);
					
					selectItem = new SelectItem();

					selectItem.setLabel("MaturityDischargeForm");
					selectItem.setValue("MaturityDischargeForm");
					list.add(selectItem);
					//added by krithika for FALCONQC-1714897
					selectItem = new SelectItem();

					selectItem.setLabel("MaturityPayoutReviewSheet");
					selectItem.setValue("MaturityPayoutReviewSheet");
					list.add(selectItem);
					//end
			}
			
			

			System.out.println("SELECITEM   : "+selectItem.getValue());


			ArrayList<String> schedule_type = new ArrayList<String>();

				schedule_type.add("Payment");
				schedule_type.add("SurrenderValue");
				schedule_type.add("MaturityNotice");
				schedule_type.add("LifeAssrSurrDischarge");
				schedule_type.add("LifeAssMatuyDischarge");
			 
			System.out.println("schedule_type  Size   : "+list.size());


		} catch (Exception e) {
			// TODO: handle exception
		}


		return list;

	}*/
	
	public void onLoad(PhaseEvent event){
		try{
		/*Added by Ram on 10/11/2016 for Auto popup Reopen*/
			if(isBlockFlag())
			{
			System.out.println("CommonUtils.getGlobalObject  : "+CommonUtils.getGlobalObject("PILT013_COMPOSITE_ACTION"));
			
			/*Added by Janani on 12.9.2016 for dynamic report config*/
			
			//prepareDropDowns();
			setBlockFlag(false);
			/*end*/
			}
			prepareDropDowns();
		/*End*/
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String backButton(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		String pathContext = request.getContextPath();
		String requestUrl = request.getRequestURL().toString();
		System.out.println("Context path----/"+pathContext);
		System.out.println("Request Url---/"+requestUrl);
		//return "PILT013_PT_IL_POLICY";
		return "PILT013_PT_IL_SURR_MAT_VALUES";
	}
	
/*added by gopi on 03/04/2017 for dynamic report config*/
	
	/*public String runAction(){
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
	*/
	
	/*public String callReportModalPanel()
	{

		System.out.println(" ************ callReportModalPanel ************");


		System.out.println("PT_IL_POLICY_BEAN.getPOL_NO()    : "+PT_IL_POLICY_BEAN.getPOL_NO());
		System.out.println("PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE()   : "+PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE());

		String ReportName=PT_IL_POLICY_BEAN.getPOL_NO();
		String PolSysId=PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE();

		String urlStr ="http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/FalconIL/ReportServlet?JasperReportName="+ReportName+"&JasperPolSysId="+PolSysId;
		System.out.println("urlStr   : "+urlStr);

	Desktop desktop =Desktop.getDesktop();
		try {
			desktop.browse(new URI(urlStr));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		java.awt.Desktop.getDesktop().browse(new URI("http://stackoverflow.com"));

		String line;

		URL url=null;
		try {
			System.out.println("Connecting to Servlet");

			url = new URL(urlStr);

			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);

			BufferedWriter out = 
			new BufferedWriter( new OutputStreamWriter( conn.getOutputStream() ) );
			out.write("username=name\r\n");
			out.flush();
			out.close();
			BufferedReader in = 
			new BufferedReader( new InputStreamReader( conn.getInputStream() ) );

			String response;
			while ( (response = in.readLine()) != null ) {
			System.out.println( response );
			}
			in.close();
			}
			catch ( MalformedURLException ex ) {
			System.out.println("########"+ex);
			ex.printStackTrace();
			}
			catch ( IOException ex ) {
			System.out.println("@@@@@@@@@@@@@@"+ex); 
			ex.printStackTrace();
			}catch(Exception e){
			System.out.println("$$$$$$$$$$$$$$"+e);
			e.printStackTrace();
			}

		return null;
	}
*/


	public void validatorM_POL_NO(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			PT_IL_POLICY_BEAN.getPOL_NO();
			System.out.println("PT_IL_POLICY_BEAN.getPOL_NO()    : "+PT_IL_POLICY_BEAN.getPOL_NO());

		setUI_M_SCHEDULE_TYPE((String)value);
			System.out.println("PT_IL_POLICY_BEAN.getUI_M_SCHEDULE_TYPE()   : "+getUI_M_SCHEDULE_TYPE());


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*
	 * Commented by Janani on 12.9.2016 for dynamic report config
	 * 
	 * 
	 * public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		
		try {
			
			System.out.println("getUI_M_SCHEDULE_TYPE()    : "+getUI_M_SCHEDULE_TYPE());

			System.out.println("runActionAfterValidate ----  POL_SYS_ID    : ----- "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
		
			String polsysid=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString();
			
			url=new StringBuffer(getRedirectUrl());
			url.append("&JasperReportName="+getUI_M_SCHEDULE_TYPE()+"&JasperPolSysId="+polsysid);
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
	*/
	
	
	/*Added by Janani on 12.9.2016 for dynamic report config*/
	
	public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		
		try {
			/*added by gopi on 03/04/2017 for dynamic report config*/
			if(ScheduleReportType != null && ScheduleReportType.equals("1"))
			{	
			System.out.println("ScheduleReportType is 1");
			 String POL_SYS_ID=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString();
			System.out.println("Pol_Sys_id---------->"+POL_SYS_ID);
			
			IP_REP_INFO repInfo = new IP_REP_INFO();
			String REP_KEY_NO = new ReportUtils().getRepKeyNo();
			
			System.out.println("REP_KEY_NO          :"+REP_KEY_NO);
			repInfo.setREP_KEY_NO(REP_KEY_NO);
			repInfo.setREP_VALUE_1("3");
			repInfo.setREP_VALUE_2("POL_SYS_ID"+"&&&"+POL_SYS_ID);
			repInfo.setREP_VALUE_3("Pol_Sys_id"+"&&&"+POL_SYS_ID);
			
			Connection conn = CommonUtils.getConnection();
			int ins = new CRUDHandler().executeInsert(repInfo, conn);
			conn.commit();
			
			
			url=new StringBuffer(getRedirectUrl());
			url.append("REP_KEY_NO="+REP_KEY_NO+"&REP_ID="+getUI_M_SCHEDULE_TYPE());
			
			setRedirectUrl(url.toString());
				if (getRedirectUrl() != null) {
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
				response.sendRedirect(getRedirectUrl());
			}
			}	
			/*added by gopi on 03/04/2017 for dynamic report config*/
			if(ScheduleReportType != null && ScheduleReportType.equals("2"))
			{


				System.out.println("ScheduleReportType is 2 (Mdocs)");

				System.out.println("******************ENTERING INTO runActionAfterValidate *******************");

				POL_SYS_ID=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
				System.out.println("polsysid in runActionAfterValidate"+POL_SYS_ID);
				//String PolicyScheduleReport=typevalue;
				//String SCHEDULE_REPORT_TYPE=compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE();
				String SCHEDULE_REPORT_TYPE=compositeAction.getPRINT_ACTION_BEAN().getUI_M_SCHEDULE_TYPE();
				//String Flag_Status=SrrenderFlag_stus();
				//System.out.println("Flag_Status--------->"+Flag_Status);

				Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap();
				String moduleId = (String) sessionMap.get("GLOBAL.M_MODULE_ID");
				//String  moduleId ="PILT002_APAC";

				String rep_template_name= null;
				//aDDED BY SANKARA NARAYANAN FOR REPORT
				 //PT_IL_POLICY PT_IL_POLICY_BEAN = PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
				String POL_APPRV_STATUS=compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_APPRV_FLAG();
				
				//POL_APPRV_STATUS=PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS();
				//END
				//String polDStype = session.getAttribute("POL_DS_TYPE").toString();
				//session.setAttribute("REP_IP_REP_INFO", IP_REP_INFO_BEAN);
				/*ReportGeneration repGenBean = new ReportGeneration();*/

				System.out.println("POL_APPRV_STATUS        "+POL_APPRV_STATUS+"  typevalue       "+SCHEDULE_REPORT_TYPE);
			/*	if(polDStype != null)
				{
					if(polDStype.equals("1"))
					{
						System.out.println("Enter the proposal block screen ");

							//rep_template_name = new CommonReport().template_name(moduleId,POL_APPRV_STATUS,getUI_REPORT_TYPE());
						setRedirectUrl(new CommonReport().genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null));

						//rep_template_name="&REP_ID="+getUI_REPORT_TYPE()+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+getUI_REPORT_TYPE();
						System.out.println("request.getServerName()  :"+request.getServerName());
						setRedirectUrl(getRedirectUrl()+rep_template_name);
						System.out.println("End");
					}*/
					/*else if(polDStype.equals("2"))
					{
						System.out.println("Enter the Policy block screen ");*/

						rep_template_name="&REP_ID="+SCHEDULE_REPORT_TYPE+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+SCHEDULE_REPORT_TYPE;
						System.out.println("request.getServerName()  :"+request.getServerName());
						setRedirectUrl(getRedirectUrl()+rep_template_name);
						System.out.println("End");
/*
					}
				}*/

				System.out.println("getRedirectUrl()   : "+getRedirectUrl());
				System.out.println("rep_template_name          "+rep_template_name);


				if(rep_template_name == null)
				{
					throw new Exception((Messages.getString(
							PELConstants.pelErrorMessagePath, "77775",
							new Object[]{"Not a valid report"})));
				}
			
					if (getRedirectUrl() != null) {
						response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();






						System.out.println("getRedirectUrl FOR mdocs "+getRedirectUrl());

						response.sendRedirect(getRedirectUrl());


				}

			}
			
			
			
			
				
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	
	
	
	private void prepareDropDowns(){
		try{
			System.out.println("****Enter_into_prepareDropDowns***");
			Connection connection = CommonUtils.getConnection();
			String	smvtype=Validatesmvtype(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
					.getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_POL_SYS_ID(),compositeAction.
					getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID());
			listUI_M_SCHEDULE_TYPE=(CommonReportAction.getDropDownListValue(connection,/* 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()*/
					"A", 
					/*"SUR"*/smvtype,compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_APPRV_FLAG()));
		System.out.println("*****polstatus/smvtype/smvapprv***" + 
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()
		+ smvtype + compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
		.getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_APPRV_FLAG());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/*end*/
	
	 public String Validatesmvtype(Object smv_Pol_sys_id,Object smv_sys_id) {
			
		 String smv_type=null;
			try {	
				String query="SELECT SMV_TYPE FROM PT_IL_SURR_MAT_VALUES WHERE SMV_POL_SYS_ID = ? AND SMV_SYS_ID = ? AND SMV_TYPE IN ('S', 'R', 'M', 'P')";
				ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), 
						new Object[]{smv_Pol_sys_id,smv_sys_id});
				System.out.println("****smvpolsysid****" + smv_Pol_sys_id + "****smvsysid*****" + smv_sys_id);
						String Custcode=null;
						while(resultset.next())
						{
						smv_type=resultset.getString("SMV_TYPE");
					    }
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
			return smv_type;
	}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	/*Added by gopi on 03.04.2017 for dynamic report config*/
	private IP_REP_INFO IP_REP_INFO_BEAN;
	public String POL_SYS_ID;
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	/*END*/
	
	public String runAction(){
		//added by krithika on 29-04-2016
		String smvsysid=null;
		try {

			Connection runActionConnection = null;
			System.out.println("INSIDE RUNACTION REVIVAL");
			runActionConnection = CommonUtils.getConnection();
			POL_SYS_ID =CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
			smvsysid=compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID().toString().trim();
			//endo_number= compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue(); 
			//System.out.println("inside runaction validation"+typevalue);
			//String PolicyScheduleReport=typevalue;
			//String SCHEDULE_REPORT_TYPE=compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE();
			//System.out.println("SCHEDULE_TYPE              : "+PolicyScheduleReport);
			//System.out.println("SCHEDULE_REPORT_TYPE       : "+SCHEDULE_REPORT_TYPE);
			//System.out.println("getUI_REPORT_TYPE   : "+getUI_REPORT_TYPE());
			
			
			System.out.println("ScheduleReportType                    :"+ScheduleReportType);
			
			
			/*Added by Janani on 17.03.2017 for dynamic report config for base product*/
			
			if(ScheduleReportType.equalsIgnoreCase("2"))

			{
				
			/*End*/
				
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK(this));

			if (IP_REP_INFO_BEAN.getROWID() == null) {
				System.out.println("ENTER IP_REP_INFO_BEAN");

				Connection connection = null;
				ResultSet resultSet = null;
				Object[] values = null;

				POL_SYS_ID =CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID").toString().trim();
				
				//endo_number= compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue(); 
				PRE_INSERT(this.IP_REP_INFO_BEAN);
				//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
				/*if ("E".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {

					System.out.println("idx no"+ endo_number);
					IP_REP_INFO_BEAN.setREP_VALUE_2(endo_number);

				}else if("Q".equals(PRINT_BEAN.getUI_M_POL_ENDT())){
					IP_REP_INFO_BEAN.setREP_VALUE_2(session.getAttribute("POL_DS_TYPE").toString().trim());
				}
*/


				IP_REP_INFO_BEAN.setREP_VALUE_1(POL_SYS_ID);
				IP_REP_INFO_BEAN.setREP_VALUE_2(smvsysid);

				int recordCount = new CRUDHandler().executeInsert(IP_REP_INFO_BEAN,
						runActionConnection);
				System.out.println("IP_REP_TABLE insert count -- ["+recordCount+"]");
				runActionConnection.commit();
			}else {
				System.out.println("****Entering_into_Updating****");
				PRE_UPDATE(this.IP_REP_INFO_BEAN);
				//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
				IP_REP_INFO_BEAN.setREP_VALUE_2(smvsysid);
				System.out.println("****Updatingsmvsysid****" + IP_REP_INFO_BEAN.getREP_VALUE_2());
				int recordCount = new CRUDHandler().executeUpdate(IP_REP_INFO_BEAN,
						runActionConnection);
				runActionConnection.commit();
			}
			
			}
			
			/*Added by Janani on 17.03.2017 for dynamic report config for base product*/
			
			else
			{
				
				
				System.out.println("in runaction ScheduleReportType is 1(Jasper)");
				
				
				setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK(this));
				
			}

			/*End*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}
	
	
String ScheduleReportType = null;
	
	public  String getScheduleReportType()throws Exception{

		System.out.println("inside selectpolstatus method");
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();	
		
		String query = "select ps_value from pp_system1 where ps_type like 'SCHDREPTYPE%'";
		System.out.println("schedule type query "+query);	     
		resultSet = new CRUDHandler().executeSelectStatement(query, connection);
		System.out.println("value for insert"+	handler.executeSelectStatement(query, connection));
		while (resultSet.next()) {
			ScheduleReportType=resultSet.getString("ps_value");

		}
		
		
		System.out.println("ScheduleReportType                    :"+ScheduleReportType);
		
		return ScheduleReportType;
	}
	
	

	
	
	
	
	//end
	

	/*added by gopi on 03/04/2017 for dynamic report config*/

	public void PRE_INSERT(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {
			IP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID")); //GL-010013
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID"));
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	//END
	
	
}
