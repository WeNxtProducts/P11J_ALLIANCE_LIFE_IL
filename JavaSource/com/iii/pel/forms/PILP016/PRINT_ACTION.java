package com.iii.pel.forms.PILP016;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.org.mozilla.javascript.internal.ObjArray;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.pel.jasperreports.PremiaJasperSave;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.pel.util.RUPEE_TO_WORD;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class PRINT_ACTION extends CommonReportAction{

	static ResourceBundle resoursebundle=ResourceBundle.getBundle("Application");

	/*Added by Ram on 19/08/2016 for Dynamic Report Configuration*/
	private  final static ResourceBundle resourceBundle=ResourceBundle.getBundle("FalconReports");
	//String ScheduleReportType = resourceBundle.getString("ScheduleReportType");
	/*End*/
	PILT002_APAC_COMPOSITE_ACTION PILT002_compositeAction ;   /*Added by sankaraNarayanan on 16/02/2016 for print */

	private HtmlOutputLabel COMP_UI_M_POL_ENDT_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_POL_ENDT;

	private HtmlOutputLabel COMP_UI_M_POL_END_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_END_NO;

	private HtmlOutputLabel COMP_UI_M_SCHEDULE_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_SCHEDULE;

	private HtmlOutputLabel COMP_UI_M_PRINTYPE_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_PRINTYPE;

	private HtmlOutputLabel COMP_UI_M_OTHERS_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_OTHERS;

	private HtmlOutputLabel COMP_UI_M_OTH_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_OTH_TYPE;

	private HtmlOutputLabel COMP_UI_M_PRINTYPE1_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_PRINTYPE1;

	private HtmlCommandButton COMP_UI_M_BUT_OK;
	private HtmlCommandButton COMP_UI_M_BUT_OK1;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_UI_M_BUT_LETTER;

	private HtmlCommandButton COMP_UI_M_BUT_POL_END_NO_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_CHQ_DETL;

	private HtmlCommandButton COMP_UI_M_BUT_NARRATION;

	private PRINT PRINT_BEAN;

	private CTRL CTRL_BEAN;

	public PILP016_COMPOSITE_ACTION compositeAction;

	private PRINT_HELPER helper;

	private PremiaJasperSave saveBean;

	private List<SelectItem> listUI_M_POL_ENDT = new ArrayList<SelectItem>();

	private List<SelectItem> listUI_M_SCHEDULE = new ArrayList<SelectItem>();

	private List<SelectItem> listUI_M_PRINTYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listUI_M_OTHERS = new ArrayList<SelectItem>();

	private List<SelectItem> listUI_M_OTH_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listUI_M_PRINTYPE1 = new ArrayList<SelectItem>();

	//added by krithika on 25-03-2016

	/*Added by janani on 19.8.2016 for dynamic report config*/

	private IP_REP_INFO IP_REP_INFO_BEAN;
	/*END*/


	public List<SelectItem> getListEndosement() {

		try {
			PS_GL_DRCR_DELEGATE delegate = new PS_GL_DRCR_DELEGATE();
			listEndosement= delegate.TYPE_ITEM(CommonUtils
					.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString());
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("listPMOP_TOLL_RENEWAL_TYP",e.getMessage());
		}
		return listEndosement;


	}
	public void setListEndosement(List<SelectItem> listEndosement) {
		this.listEndosement = listEndosement;
	}
	private List<SelectItem> listEndosement = new ArrayList<SelectItem>();

	public String POL_STATUS;
	public String POL_SYS_ID;
	public StringBuffer url;
	String type;
	String endo_number;
	String typevalue=null;
	private HtmlSelectOneMenu COMP_UI_M_ENLIST;

	public HtmlSelectOneMenu getCOMP_UI_M_ENLIST() {
		return COMP_UI_M_ENLIST;
	}

	public void setCOMP_UI_M_ENLIST(HtmlSelectOneMenu cOMP_UI_M_ENLIST) {
		COMP_UI_M_ENLIST = cOMP_UI_M_ENLIST;
	}
	private HtmlSelectOneMenu  COMP_UI_SCHEDULE_TYPE;

	public HtmlSelectOneMenu getCOMP_UI_SCHEDULE_TYPE() {
		return COMP_UI_SCHEDULE_TYPE;
	}

	public void setCOMP_UI_SCHEDULE_TYPE(HtmlSelectOneMenu cOMP_UI_SCHEDULE_TYPE) {
		COMP_UI_SCHEDULE_TYPE = cOMP_UI_SCHEDULE_TYPE;
	}

	private List<SelectItem> listUI_REPORT_TYPE = new ArrayList<SelectItem>();
	public List<SelectItem> getListUI_REPORT_TYPE() {
		//listUI_REPORT_TYPE=UI_REPORT_TYPELIST(getUI_M_POL_ENDT());
		//listUI_REPORT_TYPE=UI_REPORT_TYPELIST();


		return listUI_REPORT_TYPE;
	}
	public void setListUI_REPORT_TYPE(List<SelectItem> listUI_REPORT_TYPE) {
		this.listUI_REPORT_TYPE = listUI_REPORT_TYPE;
	}

	private String UI_REPORT_TYPE;

	public String getUI_REPORT_TYPE() {
		return UI_REPORT_TYPE;
	}
	public void setUI_REPORT_TYPE(String uI_REPORT_TYPE) {
		UI_REPORT_TYPE = uI_REPORT_TYPE;
	}


	//end



	/*Added By Krithika 5.4.2016*/
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session = request.getSession();

	String val= session.getAttribute("POL_DS_TYPE").toString();
	String prod_value=session.getAttribute("POL_PROD_CODE").toString();
	/*Emd*/

	/*Added By Krithika 5.4.2016*/
	private List<SelectItem> list_UI_M_Doc_TYPE = new ArrayList<SelectItem>();
	public List<SelectItem> getList_UI_M_Doc_TYPE() {
		//list_UI_M_Doc_TYPE=SCHEDULE_TYPE_LIST();
		return list_UI_M_Doc_TYPE;
	}
	public void setList_UI_M_Doc_TYPE(List<SelectItem> list_UI_M_Doc_TYPE) {
		this.list_UI_M_Doc_TYPE = list_UI_M_Doc_TYPE;
	}
	private String UI_M_POL_ENDT;
	public String getUI_M_POL_ENDT() {
		return UI_M_POL_ENDT;
	}
	public void setUI_M_POL_ENDT(String uI_M_POL_ENDT) {
		UI_M_POL_ENDT = uI_M_POL_ENDT;
	}
	/*private String UI_M_SCHEDULE_TYPE;*/

	/*End*/

	/*public PRINT_ACTION() {

		PRINT_BEAN = new PRINT();
		CTRL_BEAN = new CTRL();
		helper = new PRINT_HELPER();
		saveBean = new PremiaJasperSave();
		prepareDropDowns();
		 getList_UI_M_Doc_TYPE();

		//added by krithika on 25-03-2016
		 getListUI_REPORT_TYPE();
		getListEndosement();
	}*/

	/*added by gopi on 01/05/2018*/
private String list_vaue;
	
	public String getList_vaue() {
		return list_vaue;
	}
	public void setList_vaue(String list_vaue) {
		this.list_vaue = list_vaue;
	}
	
	
	
	public PRINT_ACTION() {
		try {
		PILT002_compositeAction = (PILT002_APAC_COMPOSITE_ACTION)CommonUtils.getGlobalObject("PILT002_APAC_COMPOSITE_ACTION");  /*Added by sankaraNarayanan on 16/02/2016 for print Button*/
		PRINT_BEAN = new PRINT();
		CTRL_BEAN = new CTRL();
		helper = new PRINT_HELPER();
		saveBean = new PremiaJasperSave();
		/*added by gopi for ssp call id ZBILQC-1732718 on 24/07/17*/
		COMP_UI_M_POL_ENDT = new HtmlSelectOneMenu();
		COMP_UI_M_ENLIST = new HtmlSelectOneMenu();
//end
		/*added by janani on 1.8.2016*/
		IP_REP_INFO_BEAN = new IP_REP_INFO();
		
			getScheduleReportType();
		
		prepareDropDowns();
		getListEndosement();
		setListItemValues();
		/*End*/
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




	//added by krithika on 25-03-2016

	public void validatorREPORT_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {

			setUI_REPORT_TYPE((String)value);
			System.out.println("getUI_M_SCHEDULE_TYPE()   : "+getUI_REPORT_TYPE());
			String firstlist=typevalue;
			String secondlist=compositeAction.getPRINT_ACTION_BEAN().UI_REPORT_TYPE;
			System.out.println("value of 1st list"+firstlist);
			/*	
			 * Commented by Janani on 12.9.2016 for dynamic report config
			 * 
			 * 
			 * helper.WHEN_REPORT_TYPE_VALUE_CHANGE(firstlist,secondlist,POL_APPRV_STATUS);*/


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	//added for mail functionality
	public void callEmailFunction() {		
			Connection conn = null;
		try {
			CommonUtils.clearMaps(this);
			/*Modified by Ganesh on 02/03/2017 for Mail attachment
			 * 
			 * saveBean.saveJasperAsPDF(this);*/
			CommonUtils.setGlobalVariable("reporttype","email");
			runAction();
			runActionAfterValidate();			
			System.out.println("getRedirectUrl()   : "+getRedirectUrl());
			
			sendGet(getRedirectUrl());
			System.out.println("Temporary Path       "+System.getProperty("java.io.tmpdir"));
			
			/*End*/
			/*Added by Ameen on 07-02-2018 for KIC as per Vaitheesvaran sugg.*/			
			/*if ("PREMIREP578".equalsIgnoreCase(compositeAction
					.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE())) {
				String autoUW = "N";
				String prod_value = session.getAttribute("POL_PROD_CODE")
						.toString();
				ResultSet rs = new CRUDHandler()
						.executeSelectStatement(
								"SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT A WHERE PROD_CODE = ?",
								CommonUtils.getConnection(),
								new Object[] { prod_value });
				if (rs.next()) {
					autoUW = rs.getString("PROD_AUTO_UW");
				}
				if ("Y".equalsIgnoreCase(autoUW)) {

					String pol_sys_id = CommonUtils
							.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
					new CRUDHandler()
							.executeUpdateStatement(
									"UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = '005' WHERE POL_SYS_ID = ?",
									CommonUtils.getConnection(),
									new Object[] { pol_sys_id });

					CommonUtils.getConnection().commit();
					System.out.println("Report Successsfully Printed.....");

				}
			}*/
			
				conn = CommonUtils.getConnection();
				String autoUW = "N";
				String prod_value = session.getAttribute("POL_PROD_CODE")
						.toString();
				ResultSet rs = new CRUDHandler()
						.executeSelectStatement(
								"SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT A WHERE PROD_CODE = ?",
								conn,
								new Object[] { prod_value });
				if (rs.next()) {
					autoUW = rs.getString("PROD_AUTO_UW");
				}
				if ("Y".equalsIgnoreCase(autoUW)) {
					String repIds="";
					String repQry = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'POL_SCH_RPT'";
					ResultSet repRS = new CRUDHandler().executeSelectStatement(repQry, conn);
					if(repRS.next()){
						repIds = repRS.getString("PS_CODE_DESC");
					}
					if (CommonUtils.isIN(compositeAction
							.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE(), repIds.split(","))) {

					String pol_sys_id = CommonUtils
							.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
					new CRUDHandler()
							.executeUpdateStatement(
									"UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = '005' WHERE POL_SYS_ID = ?",
									conn,
									new Object[] { pol_sys_id });

					conn.commit();
					System.out.println("Report Successsfully Printed.....");

				}
					
			}
			/*End*/
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Mail Sent Successfully" );

		} catch(Exception e1){
			e1.printStackTrace();		 
			getErrorMap().put("emailError", e1.getMessage());

			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e1.getMessage());
			if(conn!= null){
				try {
					conn.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	/*added by krithika on 15-4-15*/
	String POL_APPRV_STATUS=null;
	public  String selectapprovalstatus()throws Exception{

		System.out.println("inside insert method");
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		/*Added by sankaraNarayanan on 16/02/2016 for print Button*/
		 PT_IL_POLICY PT_IL_POLICY_BEAN = PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		 /*end*/
		CRUDHandler handler = new CRUDHandler();	
		Long pol_sys_is=PT_IL_POLICY_BEAN.getPOL_SYS_ID();
		String query = "SELECT POL_APPRV_STATUS FROM PT_IL_POLICY where POL_SYS_ID='"+pol_sys_is+"'";
		System.out.println("query exe sucess"+query);	     
		resultSet = new CRUDHandler().executeSelectStatement(query, connection);
		System.out.println("value for insert"+	handler.executeSelectStatement(query, connection));
		while (resultSet.next()) {
			POL_APPRV_STATUS=resultSet.getString("POL_APPRV_STATUS");

		}
		return POL_APPRV_STATUS;
	}

	

	/*added by agalya on 24-05-2016 for policy schedule report*/


	ArrayList<String> list1 = new ArrayList<String>();

	public ArrayList<String> fun()throws Exception
	{
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		String POL_APPRV_STATUS=null;
		String Prod_code=null;
		CRUDHandler handler = new CRUDHandler();	
		String pol_sys_is=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");


		String query ="SELECT POL_SYS_ID, POL_NO, POL_PROD_CODE, PROD_DESC,POAC_COVER_CODE, COVER_LONG_DESC FROM PT_IL_POLICY, PT_IL_POL_ADDL_COVER, PM_IL_PRODUCT, PM_IL_COVER WHERE POAC_POL_SYS_ID=POL_SYS_ID AND POL_PROD_CODE=PROD_CODE AND POAC_COVER_CODE=COVER_CODE AND POL_SYS_ID='"+pol_sys_is+"'";



		resultSet = new CRUDHandler().executeSelectStatement(query, connection);

		while (resultSet.next()) {

			POL_APPRV_STATUS=resultSet.getString("POAC_COVER_CODE");
			Prod_code=resultSet.getString("POL_PROD_CODE");
			list1.add(POL_APPRV_STATUS);
			list1.add(Prod_code);
			System.out.println("list size"+list1.size()); 

		}	


		return list1;
	}

	/*end*/

	/*public ArrayList<SelectItem> UI_REPORT_TYPELIST(){


		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			selectItem = new SelectItem();
			System.out.println("pol value:"+val);
			//String prod_value=compositeaction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE();
			System.out.println("prod_value--------->"+prod_value);

			String appValue=selectapprovalstatus();
			if((val.startsWith("2"))&&(appValue.equals("A")))
				//if(val.startsWith("PL"))


			{
				//added by krithika for mortage product 
				if(prod_value.equals("131"))
				{
					selectItem.setLabel("Policy documents");
					selectItem.setValue("Policy documents");
					list.add(selectItem);
					selectItem = new SelectItem();

					selectItem.setLabel("DSA Print");
					selectItem.setValue("DSA Print");
					list.add(selectItem);
					selectItem = new SelectItem();
					selectItem.setLabel("Policy review sheet");
					selectItem.setValue("Policy review sheet");
					list.add(selectItem);
					selectItem = new SelectItem();


					selectItem.setLabel("General Provision For Arabic");
					selectItem.setValue("General Provision For Arabic");
					list.add(selectItem);
					selectItem = new SelectItem();

					selectItem.setLabel("Endorment slip");
					selectItem.setValue("Endorment slip");
					list.add(selectItem);
					selectItem = new SelectItem();

					selectItem.setLabel("Revival report");
					selectItem.setValue("Revival report");
					list.add(selectItem);
					selectItem = new SelectItem();
				}
				else
				{

				selectItem.setLabel("Policy documents");
				selectItem.setValue("Policy documents");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Quotation review sheet");
				selectItem.setValue("Quotation review sheet");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Policy review sheet");
				selectItem.setValue("Policy review sheet");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Payment Slip");
				selectItem.setValue("Payment Slip");
				list.add(selectItem);
				selectItem = new SelectItem();	


				selectItem.setLabel("General Provision For Arabic");
				selectItem.setValue("General Provision For Arabic");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Endorment slip");
				selectItem.setValue("Endorment slip");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Revival report");
				selectItem.setValue("Revival report");
				list.add(selectItem);
				selectItem = new SelectItem();
				System.out.println("SELECITEM   : "+selectItem.getValue());
			}
			}
			else if((val.startsWith("2"))&&(appValue.equals("N")))
			{
				if(prod_value.equals("131"))
				{


					selectItem.setLabel("Policy review sheet");
					selectItem.setValue("Policy review sheet");
					list.add(selectItem);
					selectItem = new SelectItem();

					selectItem.setLabel("Policy documents");
					selectItem.setValue("Policy documents");
					list.add(selectItem);
					selectItem = new SelectItem();

					selectItem.setLabel("DSA Print");
					selectItem.setValue("DSA Print");
					list.add(selectItem);
					selectItem = new SelectItem();

					selectItem.setLabel("Payment Slip");
					selectItem.setValue("Payment Slip");
					list.add(selectItem);
					selectItem = new SelectItem();	

					selectItem.setLabel("General Provision For Arabic");
					selectItem.setValue("General Provision For Arabic");
					list.add(selectItem);
					selectItem = new SelectItem();

					selectItem.setLabel("Endorment slip");
					selectItem.setValue("Endorment slip");
					list.add(selectItem);
					selectItem = new SelectItem();

					selectItem.setLabel("General Endorment slip");
					selectItem.setValue("General Endorment slip");
					list.add(selectItem);
					selectItem = new SelectItem();

					selectItem.setLabel("Revival report");
					selectItem.setValue("Revival report");
					list.add(selectItem);
					selectItem = new SelectItem();
				}
				else
				{
				selectItem.setLabel("Policy review sheet");
				selectItem.setValue("Policy review sheet");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Policy documents");
				selectItem.setValue("Policy documents");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("General Provision For Arabic");
				selectItem.setValue("General Provision For Arabic");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Payment Slip");
				selectItem.setValue("Payment Slip");
				list.add(selectItem);
				selectItem = new SelectItem();	

				selectItem.setLabel("Endorment slip");
				selectItem.setValue("Endorment slip");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Revival report");
				selectItem.setValue("Revival report");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Quotation review sheet");
				selectItem.setValue("Quotation review sheet");
				list.add(selectItem);
				selectItem = new SelectItem();

			}
			}
			else{
				if(prod_value.equals("131"))
				{

					selectItem.setLabel("Proposal Review Sheet");
					selectItem.setValue("Quotation review sheet");
					list.add(selectItem);
					selectItem = new SelectItem();	

					selectItem.setLabel("DSA Print");
					selectItem.setValue("DSA Print");
					list.add(selectItem);
					selectItem = new SelectItem();


					selectItem.setLabel("Payment Slip");
					selectItem.setValue("Payment Slip");
					list.add(selectItem);
					selectItem = new SelectItem();

					//ADDED BY AMEEN 17-8-2016 FOR QUOTATION LETTER IN PROPOSAL LEVEL FALCONQC-1716555 

					selectItem.setLabel("Proposal Letter");
					selectItem.setValue("Quotation Letter");
					list.add(selectItem);
					selectItem = new SelectItem();	

					if((appValue.equals("A"))){
					selectItem.setLabel("Acceptance Letter");
					selectItem.setValue("Acceptance Letter");
					list.add(selectItem);
					selectItem = new SelectItem();
					}

					//END QUOTATION LETTER
				}
				else
				{
				selectItem.setLabel("Proposal Review Sheet");
				selectItem.setValue("Quotation review sheet");
				list.add(selectItem);
				selectItem = new SelectItem();	


				selectItem.setLabel("Payment Slip");
				selectItem.setValue("Payment Slip");
				list.add(selectItem);
				selectItem = new SelectItem();

				//ADDED BY AMEEN 17-8-2016 FOR QUOTATION LETTER IN PROPOSAL LEVEL FALCONQC-1716555 

				selectItem.setLabel("Proposal Letter");
				selectItem.setValue("Quotation Letter");
				list.add(selectItem);
				selectItem = new SelectItem();	

				if((appValue.equals("A"))){
				selectItem.setLabel("Acceptance Letter");
				selectItem.setValue("Acceptance Letter");
				list.add(selectItem);
				selectItem = new SelectItem();
				}

				//END QUOTATION LETTER
				}
				//end



				selectItem.setLabel("Policy review sheet");
				selectItem.setValue("Policy review sheet");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Policy documents");
				selectItem.setValue("Policy documents");
				list.add(selectItem);
				selectItem = new SelectItem();


				selectItem.setLabel("DSA Print");
				selectItem.setValue("DSA Print");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("General Provision For Arabic");
				selectItem.setValue("General Provision For Arabic");
				list.add(selectItem);
				selectItem = new SelectItem();



				selectItem.setLabel("Endorment slip");
				selectItem.setValue("Endorment slip");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("General Endorment slip");
				selectItem.setValue("General Endorment slip");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Revival report");
				selectItem.setValue("Revival report");
				list.add(selectItem);
				selectItem = new SelectItem();
				System.out.println("SELECITEM   : "+selectItem.getValue());
			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	//end
	 */	/*public ArrayList<SelectItem> UI_M_SCHEDULE_TYPELIST(){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			selectItem = new SelectItem();
			System.out.println("pol value:"+val);
			if(val.startsWith("PL"))


			{

				selectItem.setLabel("Policy documents");
				selectItem.setValue("Policy documents");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Quotation review sheet");
				selectItem.setValue("Quotation review sheet");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Policy review sheet");
				selectItem.setValue("Policy review sheet");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Endorment slip");
				selectItem.setValue("Endorment slip");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("General Endorment slip");
				selectItem.setValue("General Endorment slip");
				list.add(selectItem);
				selectItem = new SelectItem();

				selectItem.setLabel("Revival report");
				selectItem.setValue("Revival report");
				list.add(selectItem);
				selectItem = new SelectItem();
				System.out.println("SELECITEM   : "+selectItem.getValue());
			}

			else{	
				selectItem.setLabel("Quotation review sheet");
				selectItem.setValue("Quotation review sheet");
				list.add(selectItem);
				selectItem = new SelectItem();		

		     selectItem.setLabel("Policy review sheet");
		     selectItem.setValue("Policy review sheet");
		     list.add(selectItem);
		    selectItem = new SelectItem();

			selectItem.setLabel("Policy documents");
			selectItem.setValue("Policy documents");
			list.add(selectItem);
			selectItem = new SelectItem();



			selectItem.setLabel("Endorment slip");
			selectItem.setValue("Endorment slip");
			list.add(selectItem);
			selectItem = new SelectItem();

			selectItem.setLabel("General Endorment slip");
			selectItem.setValue("General Endorment slip");
			list.add(selectItem);
			selectItem = new SelectItem();

			selectItem.setLabel("Revival report");
			selectItem.setValue("Revival report");
			list.add(selectItem);
			selectItem = new SelectItem();
			System.out.println("SELECITEM   : "+selectItem.getValue());
		}
		}

		catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}*/
	public void endotype(ActionEvent actionEvent) {
		System.out.println("inside the firfield validation method");
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		PRINT_BEAN.setList_vaue((String)input.getSubmittedValue());

		/*Added by Ram on 05/11/2016 for FALCONLIFE-1351395*/
		setEndorseChange(true);
		/*End*/
		System.out.println(" bean value    "+PRINT_BEAN.getList_vaue());
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public String preRunAction(PILP016_COMPOSITE_ACTION compositeAction)
	{
		System.out.println("preRunAction compositeAction        "+compositeAction);
		this.compositeAction = compositeAction;
		String returnValue  = callReportModalPanel();
		System.out.println("returnValue in preRunAction        "+returnValue);
		return returnValue;
	}




	//end
	/*private void prepareDropDowns(){
		try{
			Connection connection = CommonUtils.getConnection();


			setListUI_M_POL_ENDT(ListItemUtil.getDropDownListValue(
					connection, "PGLP016", "PRINT",
					"PRINT.M_POL_ENDT", null));

			setListUI_M_POL_ENDT(ListItemUtil.getDropDownListValue_1(connection, 
														"PGLP016",
														"PRINT", 
														"PRINT.M_POL_ENDT", 
														null));



			setListUI_M_SCHEDULE(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP016", "PRINT",
					"PRINT.M_SCHEDULE", null));
			setListUI_M_PRINTYPE(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP016", "PRINT",
					"PRINT.M_PRINTYPE", null));
			setListUI_M_OTHERS(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP016", "PRINT",
					"PRINT.M_OTHERS", null));
			setListUI_M_OTH_TYPE(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP016", "PRINT",
					"PRINT.M_OTH_TYPE", null));
			setListUI_M_PRINTYPE1(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP016", "PRINT",
					"PRINT.M_PRINTYPE1", null));
		}catch (Exception e) {
		}

	}*/
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
		}
		return connection;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_ENDT_LABEL() {
		return COMP_UI_M_POL_ENDT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_POL_ENDT() {
		return COMP_UI_M_POL_ENDT;
	}

	public void setCOMP_UI_M_POL_ENDT_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_ENDT_LABEL) {
		this.COMP_UI_M_POL_ENDT_LABEL = COMP_UI_M_POL_ENDT_LABEL;
	}

	public void setCOMP_UI_M_POL_ENDT(HtmlSelectOneMenu COMP_UI_M_POL_ENDT) {
		this.COMP_UI_M_POL_ENDT = COMP_UI_M_POL_ENDT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_END_NO_LABEL() {
		return COMP_UI_M_POL_END_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_END_NO() {
		return COMP_UI_M_POL_END_NO;
	}

	public void setCOMP_UI_M_POL_END_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_END_NO_LABEL) {
		this.COMP_UI_M_POL_END_NO_LABEL = COMP_UI_M_POL_END_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_END_NO(HtmlInputText COMP_UI_M_POL_END_NO) {
		this.COMP_UI_M_POL_END_NO = COMP_UI_M_POL_END_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_SCHEDULE_LABEL() {
		return COMP_UI_M_SCHEDULE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_SCHEDULE() {
		return COMP_UI_M_SCHEDULE;
	}

	public void setCOMP_UI_M_SCHEDULE_LABEL(
			HtmlOutputLabel COMP_UI_M_SCHEDULE_LABEL) {
		this.COMP_UI_M_SCHEDULE_LABEL = COMP_UI_M_SCHEDULE_LABEL;
	}

	public void setCOMP_UI_M_SCHEDULE(HtmlSelectOneMenu COMP_UI_M_SCHEDULE) {
		this.COMP_UI_M_SCHEDULE = COMP_UI_M_SCHEDULE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PRINTYPE_LABEL() {
		return COMP_UI_M_PRINTYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINTYPE() {
		return COMP_UI_M_PRINTYPE;
	}

	public void setCOMP_UI_M_PRINTYPE_LABEL(
			HtmlOutputLabel COMP_UI_M_PRINTYPE_LABEL) {
		this.COMP_UI_M_PRINTYPE_LABEL = COMP_UI_M_PRINTYPE_LABEL;
	}

	public void setCOMP_UI_M_PRINTYPE(HtmlSelectOneMenu COMP_UI_M_PRINTYPE) {
		this.COMP_UI_M_PRINTYPE = COMP_UI_M_PRINTYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_OTHERS_LABEL() {
		return COMP_UI_M_OTHERS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_OTHERS() {
		return COMP_UI_M_OTHERS;
	}

	public void setCOMP_UI_M_OTHERS_LABEL(HtmlOutputLabel COMP_UI_M_OTHERS_LABEL) {
		this.COMP_UI_M_OTHERS_LABEL = COMP_UI_M_OTHERS_LABEL;
	}

	public void setCOMP_UI_M_OTHERS(HtmlSelectOneMenu COMP_UI_M_OTHERS) {
		this.COMP_UI_M_OTHERS = COMP_UI_M_OTHERS;
	}

	public HtmlOutputLabel getCOMP_UI_M_OTH_TYPE_LABEL() {
		return COMP_UI_M_OTH_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_OTH_TYPE() {
		return COMP_UI_M_OTH_TYPE;
	}

	public void setCOMP_UI_M_OTH_TYPE_LABEL(
			HtmlOutputLabel COMP_UI_M_OTH_TYPE_LABEL) {
		this.COMP_UI_M_OTH_TYPE_LABEL = COMP_UI_M_OTH_TYPE_LABEL;
	}

	public void setCOMP_UI_M_OTH_TYPE(HtmlSelectOneMenu COMP_UI_M_OTH_TYPE) {
		this.COMP_UI_M_OTH_TYPE = COMP_UI_M_OTH_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PRINTYPE1_LABEL() {
		return COMP_UI_M_PRINTYPE1_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PRINTYPE1() {
		return COMP_UI_M_PRINTYPE1;
	}

	public void setCOMP_UI_M_PRINTYPE1_LABEL(
			HtmlOutputLabel COMP_UI_M_PRINTYPE1_LABEL) {
		this.COMP_UI_M_PRINTYPE1_LABEL = COMP_UI_M_PRINTYPE1_LABEL;
	}

	public void setCOMP_UI_M_PRINTYPE1(HtmlSelectOneMenu COMP_UI_M_PRINTYPE1) {
		this.COMP_UI_M_PRINTYPE1 = COMP_UI_M_PRINTYPE1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LETTER() {
		return COMP_UI_M_BUT_LETTER;
	}

	public void setCOMP_UI_M_BUT_LETTER(HtmlCommandButton COMP_UI_M_BUT_LETTER) {
		this.COMP_UI_M_BUT_LETTER = COMP_UI_M_BUT_LETTER;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_END_NO_LOV() {
		return COMP_UI_M_BUT_POL_END_NO_LOV;
	}

	public void setCOMP_UI_M_BUT_POL_END_NO_LOV(
			HtmlCommandButton COMP_UI_M_BUT_POL_END_NO_LOV) {
		this.COMP_UI_M_BUT_POL_END_NO_LOV = COMP_UI_M_BUT_POL_END_NO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CHQ_DETL() {
		return COMP_UI_M_BUT_CHQ_DETL;
	}

	public void setCOMP_UI_M_BUT_CHQ_DETL(
			HtmlCommandButton COMP_UI_M_BUT_CHQ_DETL) {
		this.COMP_UI_M_BUT_CHQ_DETL = COMP_UI_M_BUT_CHQ_DETL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_NARRATION() {
		return COMP_UI_M_BUT_NARRATION;
	}

	public void setCOMP_UI_M_BUT_NARRATION(
			HtmlCommandButton COMP_UI_M_BUT_NARRATION) {
		this.COMP_UI_M_BUT_NARRATION = COMP_UI_M_BUT_NARRATION;
	}

	public PRINT getPRINT_BEAN() {
		return PRINT_BEAN;
	}

	public void setPRINT_BEAN(PRINT PRINT_BEAN) {
		this.PRINT_BEAN = PRINT_BEAN;
	}

	public void saveRecord() {
		try {
			if (getPRINT_BEAN().getROWID() != null) {
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<SelectItem> getListUI_M_POL_ENDT() {
		if (listUI_M_POL_ENDT.size() == 0) {
			listUI_M_POL_ENDT.clear();
			try {
				listUI_M_POL_ENDT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listUI_M_POL_ENDT;
	}

	public void setListUI_M_POL_ENDT(List<SelectItem> listUI_M_POL_ENDT) {
		this.listUI_M_POL_ENDT = listUI_M_POL_ENDT;
	}

	public List<SelectItem> getListUI_M_SCHEDULE() {
		if (listUI_M_SCHEDULE.size() == 0) {
			listUI_M_SCHEDULE.clear();
			try {
				listUI_M_SCHEDULE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listUI_M_SCHEDULE;
	}

	public void setListUI_M_SCHEDULE(List<SelectItem> listUI_M_SCHEDULE) {
		this.listUI_M_SCHEDULE = listUI_M_SCHEDULE;
	}

	public List<SelectItem> getListUI_M_PRINTYPE() {
		if (listUI_M_PRINTYPE.size() == 0) {
			listUI_M_PRINTYPE.clear();
			try {
				listUI_M_PRINTYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listUI_M_PRINTYPE;
	}

	public void setListUI_M_PRINTYPE(List<SelectItem> listUI_M_PRINTYPE) {
		this.listUI_M_PRINTYPE = listUI_M_PRINTYPE;
	}

	public List<SelectItem> getListUI_M_OTHERS() {
		if (listUI_M_OTHERS.size() == 0) {
			listUI_M_OTHERS.clear();
			try {
				listUI_M_OTHERS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listUI_M_OTHERS;
	}

	public void setListUI_M_OTHERS(List<SelectItem> listUI_M_OTHERS) {
		this.listUI_M_OTHERS = listUI_M_OTHERS;
	}

	public List<SelectItem> getListUI_M_OTH_TYPE() {
		if (listUI_M_OTH_TYPE.size() == 0) {
			listUI_M_OTH_TYPE.clear();
			try {
				listUI_M_OTH_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listUI_M_OTH_TYPE;
	}

	public void setListUI_M_OTH_TYPE(List<SelectItem> listUI_M_OTH_TYPE) {
		this.listUI_M_OTH_TYPE = listUI_M_OTH_TYPE;
	}

	public List<SelectItem> getListUI_M_PRINTYPE1() {
		if (listUI_M_PRINTYPE1.size() == 0) {
			listUI_M_PRINTYPE1.clear();
			try {
				listUI_M_PRINTYPE1 = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listUI_M_PRINTYPE1;
	}

	public void setListUI_M_PRINTYPE1(List<SelectItem> listUI_M_PRINTYPE1) {
		this.listUI_M_PRINTYPE1 = listUI_M_PRINTYPE1;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		System.out.println("inside fire vield validation");
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String chequeDetail() {
		String outcome = null;
		outcome = "PGLP016_PS_GL_DRCR";
		return outcome;
	}

	public String main(){
		setFormFlag(true);
		return "policyEntry";
	}
	public String narration() {
		String PARAM_NAME = null;
		Map<String, String> PARAM_ID = null;
		if (!PARAM_ID.isEmpty()) {
			PARAM_ID.clear();
		}
		if ("P".equalsIgnoreCase(PRINT_BEAN.getUI_M_POL_ENDT())) {
			CTRL_BEAN.setUI_M_POL_END_NO_IDX(0);
		}
		CommonUtils.setGlobalVariable(CommonUtils
				.getGlobalVariable("GLOBAL.M_POLGM_SYS_ID"), CommonUtils
				.getGlobalVariable("GLOBAL.M_POL_SYS_ID"));
		CommonUtils.setGlobalVariable(CommonUtils
				.getGlobalVariable("GLOBAL.M_POLGM_END_NO"), PRINT_BEAN
				.getUI_M_POL_END_NO());

		// CALL_FORM('PQM003',NO_HIDE,NO_REPLACE,NO_QUERY_ONLY,PARAM_ID);
		return null;
	}

	public String precallReportModalPanel(){

		setEndorseChange(true);
		System.out.println("welcome to precallReportModalPanel "+isEndorseChange());
		String returnValue = callReportModalPanel();
		System.out.println("returnValue "+returnValue);
		return returnValue;
	}
	/*public void onLoad(PhaseEvent event){
		try{

			if(isFormFlag()){
				helper.when_new_from_instance(this);

				Added by Janani on 31.8.2016 for dynamic report config

				String reportType = (session.getAttribute("POL_DS_TYPE").toString().equals("1") ? "PRO" : "POL");

				if(listUI_M_POL_ENDT.size() >= 0)
				{
					System.out.println("inside listUI_M_POL_ENDT.size() > 0");

					if(reportType.equalsIgnoreCase("pol"))
					{
						this.setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(1).getValue().toString().trim());
					}
					else
					{
						this.setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(0).getValue().toString().trim());
					}

				}

				end

				setFormFlag(false);
			}
			if(isBlockFlag()){
				System.out.println("Enter into Body");
				Added by Ram for FALCONLIFE-1351395
				setEndorseChange(false);
				End

			//}
			helper.WHEN_LIST_CHANGED_M_POL_ENDT(this);
			commentted by ram on 2-11-2016 fort Endosment slip report issue
			Added by Nathiya on 18/3/2016 for Quotation Letter patch
			if(CommonUtils.getGlobalVariable("GLOBAL.M_POL_PROP_NO") == null)
			{
				System.out.println("PROPOSAL");
				//setCOMP_UI_M_POL_ENDT("Q");
			PRINT_BEAN.setUI_M_POL_ENDT("Q");

			}
			Added By Ramkumar on 21-Jun-2016
			PILT002_APAC_COMPOSITE_ACTION mainCompositeAction = (PILT002_APAC_COMPOSITE_ACTION)CommonUtils.getGlobalObject("PILT002_APAC_COMPOSITE_ACTION");
			System.out.println("POL_DS_TYPE       "+mainCompositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE());
			setBlockFlag(false);


			if(mainCompositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX()!=0)
			{
				getCOMP_UI_M_POL_ENDT().setValue("Endrosement");
				 if( listEndosement != null && listEndosement.size() > 0)
					{ 
						getPRINT_BEAN().setList_vaue((String)listEndosement.get((listEndosement.size() - 1)).getValue());	
						COMP_UI_M_ENLIST.setDisabled(false);
						setUI_REPORT_TYPE("Endorment slip");
						COMP_UI_M_ENLIST.resetValue();
						COMP_UI_SCHEDULE_TYPE.resetValue();
					}
			}


			if(mainCompositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE() != null)
			{
				if(mainCompositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE().equals("1"))
				{
					getCOMP_UI_M_POL_END_NO_LABEL().setValue("Propsal No");
					Added by Ram on 01/11/2011 for Endorsement Date field Enable issue
					PRINT_BEAN.setUI_M_POL_ENDT("Q");
					End
				}
				else if(mainCompositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE().equals("2"))
				{
					getCOMP_UI_M_POL_END_NO_LABEL().setValue("Policy No");
				}

			}
			End
			Added by Ram on 01/11/2011 for Endorsement Date field Enable issue
			getCOMP_UI_M_POL_END_NO().setDisabled(true);

			if ("Endrosement".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {

				getCOMP_UI_M_ENLIST().setDisabled(false);

			}else if("Quotation".equals(PRINT_BEAN.getUI_M_POL_ENDT()))
			{
				getCOMP_UI_M_ENLIST().setDisabled(true);

			}

			End




			//ADDED by agalya on 03-06-2016 for policy schedule
		UIComponent component = null;
			 Object value = null;
			validatorM_POL_END(context,component, value);
                       validatorREPORT_TYPE(context,component, value);
			}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}*/
	public void onLoad(PhaseEvent event){
		try{
			/*added by gopi for ssp call id ZBILQC-1732718 on 24/07/17*/
			 PT_IL_POLICY PT_IL_POLICY_BEAN = PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			//end
			 if(isFormFlag()){

				helper.when_new_from_instance(this);


				/*Added by Janani on 31.8.2016 for dynamic report config*/

				String reportType = (session.getAttribute("POL_DS_TYPE").toString().equals("1") ? "PRO" : "POL");

				if(listUI_M_POL_ENDT.size() >= 0)
				{
					System.out.println("inside listUI_M_POL_ENDT.size() > 0");

					if(reportType.equalsIgnoreCase("pol"))
					{
						/*added by gopi for ssp call id ZBILQC-1732718 on 24/07/17*/
						if(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX()!=0){
							
							this.setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(0).getValue().toString().trim());
														
						}else{
						this.setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(1).getValue().toString().trim());
						}	
						//end
						}
					else
					{
						this.setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(0).getValue().toString().trim());
					}

				}

				
				
				/*end*/

				setFormFlag(false);
			}
			if(isBlockFlag()){

			}


			/*Added by Janani on 31.8.2016 for dynamic report config*/


			String C1 = " SELECT POL_NO FROM PT_IL_POLICY"
					+ "     WHERE POL_SYS_ID= ?";
			Connection connection = null;
			ResultSet resultSet = null;
			Object[] values = null;
			CRUDHandler handler = new CRUDHandler();

			connection = CommonUtils.getConnection();

			values = new Object[] { CommonUtils
					.getGlobalObject("GLOBAL.M_POL_SYS_ID") };
			resultSet = handler.executeSelectStatement(C1, connection,
					values);
			if (resultSet.next()) {
				PRINT_BEAN.setUI_M_POL_END_NO(resultSet.getString(1));
			}

			System.out.println("pol_no in onload              :"+PRINT_BEAN.getUI_M_POL_END_NO());
			/*end*/

			helper.WHEN_LIST_CHANGED_M_POL_ENDT(this);

			/*Added by Nathiya on 18/3/2016 for Quotation Letter patch*/
			/*if(CommonUtils.getGlobalVariable("GLOBAL.M_POL_PROP_NO") == null)
			{
				System.out.println("PROPOSAL");
				//setCOMP_UI_M_POL_ENDT("Q");
				PRINT_BEAN.setUI_M_POL_ENDT("Q");

			}
			 */

			/*Added By Ramkumar on 21-Jun-2016*/
			PILT002_APAC_COMPOSITE_ACTION mainCompositeAction = (PILT002_APAC_COMPOSITE_ACTION)CommonUtils.getGlobalObject("PILT002_APAC_COMPOSITE_ACTION");
			System.out.println("POL_DS_TYPE       "+mainCompositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE());
			if(mainCompositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE() != null)
			{
				if(mainCompositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE().equals("1"))
				{
					/*added by gopi for toi on 26/06/2018*/
					String Benef_cust_flag =getBeneficiary_as_customer();
					 if(Benef_cust_flag!=null && "Y".equalsIgnoreCase(Benef_cust_flag)){
						 getCOMP_UI_M_POL_END_NO_LABEL().setValue("Invoice No");
					 }else{
						 getCOMP_UI_M_POL_END_NO_LABEL().setValue("Propsal No");
					 }
					/*end*/
					//getCOMP_UI_M_POL_END_NO_LABEL().setValue("Propsal No");
				}
				else if(mainCompositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE().equals("2"))
				{
					getCOMP_UI_M_POL_END_NO_LABEL().setValue("Policy No");
				}

			}
			/*End*/

		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/*public void validatorM_POL_END(FacesContext context,
			UIComponent component, Object value) {
		try {
			String data=((String) value);
			if(data.equalsIgnoreCase("Policy"))
			{
			data="P";
			}
			PRINT_BEAN.setUI_M_POL_ENDT(data);
			typevalue=PRINT_BEAN.getUI_M_POL_ENDT();
			helper.WHEN_LIST_CHANGED_M_POL_ENDT(this);
Added by Ram on 01/10/2016 for Endorsement Report Issue

			System.out.println("PRINT_BEAN.getUI_M_POL_ENDT()        "+PRINT_BEAN.getUI_M_POL_ENDT());
			 if(PRINT_BEAN.getUI_M_POL_ENDT() != null && PRINT_BEAN.getUI_M_POL_ENDT().equals("P"))
			 {
				 getPRINT_BEAN().setList_vaue((String)listEndosement.get(0).getValue());
			 }
			 else
			 {
				 Modified by Ram on 05/11/2016 for FALCONLIFE-1351395
			if(getPRINT_BEAN().getList_vaue() == null && listEndosement != null && listEndosement.size() > 0)
			{
				System.out.println("isRunActionclick       "+isEndorseChange());
			 if(!isEndorseChange())
			 {
				 getPRINT_BEAN().setList_vaue((String)listEndosement.get((listEndosement.size() - 1)).getValue()); 
			 }

			}
			End
			 }
			 COMP_UI_M_ENLIST.resetValue();	
			System.out.println("getPRINT_BEAN().getList_vaue() in validatorM_pol_end      "+getPRINT_BEAN().getList_vaue());
			End

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}*/
	
	 /*Added by Janani on 20.03.2017 for Dynamic report config for Base product*/
	
	
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
	
	
	/*End*/
	
	
	
	/*Modified by Sankar on 30.8.2016 for dynamic report config*/
	public void validatorM_POL_END(FacesContext context,
			UIComponent component, Object value) {
		
		
		
		/*Added by sankaraNarayanan on 16/02/2016 for print Button*/
		 PT_IL_POLICY PT_IL_POLICY_BEAN = PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		 //end
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			System.out.println("*********** Enter the validatorQUESTIONNAIRE_TYPE *************");
			setUI_M_POL_ENDT(value.toString());
			System.out.println("getUI_M_POL_ENDT IN validatorM_POL_END : "+getUI_M_POL_ENDT());


			String reportType = (session.getAttribute("POL_DS_TYPE").toString().equals("1") ? "PRO" : "POL");

			String prod_value=session.getAttribute("POL_PROD_CODE").toString();

			System.out.println("ScheduleReportType             :"+ScheduleReportType);
			
			System.out.println("POL_APPRV_STATUS    "+PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS() +"    reportType      "+reportType+ "    UI_M_POL_ENDT      "+getUI_M_POL_ENDT()+"       prod_value        " +
					prod_value+"    POL_ADDL_STATUS        "+PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS()+"    selectpolstatus       "+selectpolstatus());
			
			if(ScheduleReportType.equalsIgnoreCase("2"))   /*ScheduleReportType = 2 is MDOCS  ,ScheduleReportType = 1 is Jasper*/
			{
				/*modified by gopi for ssp call id ZBILQC-1731299 on 13/07/17*/
				/*Added by sankaraNarayanan on 16/02/2016 for print Button*/
				
					String Cover_code=Get_cover_code();
				
					setListUI_REPORT_TYPE(getDropDownListValue_1(
							CommonUtils.getConnection(),
							PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(),
							reportType,getUI_M_POL_ENDT(),prod_value,PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS(),Cover_code,PT_IL_POLICY_BEAN.getPOL_END_CODE()));
					
				/*end*/
			}else{
				
				System.out.println("ScheduleReportType is 1 (jasper)");
				
				/*
				 * Commented by Janani on 16.03.2017 for Dynamic report config for Base product
				 * 
				 * 
				 * setListUI_REPORT_TYPE(getDropDownListValue_1(
						CommonUtils.getConnection(),
						selectpolstatus(),
						reportType,value.toString(),prod_value,null));*/
				
				/*modified(null added for cover code) by gopi for ssp call id ZBILQC-1731299 on 13/07/17*/
				/*Modified by Janani on 16.03.2017 for Dynamic report config for Base product*/
				
				setListUI_REPORT_TYPE(getDropDownListValue_1(
						CommonUtils.getConnection(),
						PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(),
						reportType,value.toString(),prod_value,null,null,null));
				
				
				/*ENd*/
				
				
				
			}/*added by gopi for ssp call id ZBILQC-1732718 on 24/07/17*/
			if(getUI_M_POL_ENDT().equalsIgnoreCase("P"))
			{
				PRINT_BEAN.setList_vaue("0");
				COMP_UI_M_ENLIST.resetValue();
				 String policy_aaprove=getPolicyApprove();
				 if(policy_aaprove!=null && "O".equalsIgnoreCase(policy_aaprove)){
				String chk_pol_avl=checkingPolicyisAvialable();	
				if(!"X".equalsIgnoreCase(chk_pol_avl)){
					throw new Exception("Invalid Type for this Quotation");
				}
				 }
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	/*end*/

	public ArrayList<LovBean> lovM_POL_END_NO(Object obj) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String pol_end_no = (String) obj;
		Object[] values = {};
		String query = null;
		String M_POL_NO = null;
		String C1 = " SELECT POL_NO" +
				"	FROM PT_GL_POLICY" +
				"	WHERE POL_SYS_ID= ?";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID")};
			resultSet = handler.executeSelectStatement(C1, connection,values);
			if(resultSet.next()){
				M_POL_NO = resultSet.getString(1);
			}
			if ("*".equals(pol_end_no)) {
				query = "  SELECT POLH_END_NO,POLH_APPRV_DT FROM PH_GL_POLICY " +
						" WHERE POLH_NO= ? AND POLH_END_NO IS NOT NULL AND ROWNUM < ?";
				values = new Object[] {M_POL_NO,PELConstants.suggetionRecordSize };
			} else {
				query =  " SELECT POLH_END_NO,POLH_APPRV_DT FROM PH_GL_POLICY WHERE POLH_NO = ? " +
						" AND POLH_END_NO LIKE ? AND POLH_END_NO IS NOT NULL AND ROWNUM < ?";
				values = new Object[] {M_POL_NO,pol_end_no,PELConstants.suggetionRecordSize };
			}
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (RuntimeException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	public void validatorM_POL_END_NO(FacesContext context,
			UIComponent component, Object value) {
		try {
			PRINT_BEAN.setUI_M_POL_END_NO((String) value);
			helper.WHEN_VALIDATE_ITEM_M_POL_END_NO(PRINT_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*public String runAction() {
		setRedirectUrl(null);

		CommonUtils.clearMaps(this);
		String redirectUrl = null;
		HttpServletResponse response = null;
		String moduleCode = CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_NAME");
		try {
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				redirectUrl = ReportUtils.getReportRedirectString("PGLR002_012", moduleCode, REPORT_UTIL_CONSTANTS.reportPDFFormat, parameterMap);
				//response.sendRedirect(redirectUrl);
				//ReportUtils.sendRedirect(redirectUrl);
				setRedirectUrl(redirectUrl);

				System.out.println("URL is "+redirectUrl);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}*/

	/*public String runAction(){
		//added by krithika on 29-04-2016
		Connection runActionConnection = null;
		try {
			runActionConnection = CommonUtils.getConnection();
			if("J".equalsIgnoreCase(ScheduleReportType)){
			System.out.println("INSIDE RUNACTION REVIVAL");

			POL_SYS_ID =CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
			endo_number= compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue(); 
			System.out.println("inside runaction validation"+typevalue);


			String PolicyScheduleReport=typevalue;
			String SCHEDULE_REPORT_TYPE=compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE();

			System.out.println("SCHEDULE_TYPE              : "+PolicyScheduleReport);
			System.out.println("SCHEDULE_REPORT_TYPE       : "+SCHEDULE_REPORT_TYPE);



			if((PolicyScheduleReport.equalsIgnoreCase("Endrosement"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Revival report"))) 
			 {
				 System.out.println("inside if part");
				 System.out.println("Inside my revival helper");
				 setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			 }
			ADDED BY KRITHIKA ON 17-4-15
			else if((PolicyScheduleReport.equalsIgnoreCase("Endrosement"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Endorment slip")))
			 {
				 setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			 }			
			//END
			//added by agalya for policy DSA task on 03-06-2016
			else if((PolicyScheduleReport.equalsIgnoreCase("P"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("DSA Print")))
			 {
				 setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			 }
			//end
			else if((PolicyScheduleReport.equalsIgnoreCase("P"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Policy documents")))
			 {
				 setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			 }
			else if((PolicyScheduleReport.equalsIgnoreCase("P"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Policy review sheet")))
			 {
				 setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			 }
			else if(((PolicyScheduleReport.equalsIgnoreCase("Quotation"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Quotation review sheet"))) )
			{
				 setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			}
			else if(((PolicyScheduleReport.equalsIgnoreCase("P"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("PAYMENT SLIP"))&&(POL_APPRV_STATUS.equalsIgnoreCase("N"))) )
			{
				setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			}
			else if(((PolicyScheduleReport.equalsIgnoreCase("Endrosement"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("PAYMENT SLIP"))&&(POL_APPRV_STATUS.equalsIgnoreCase("N"))) )
			{
				setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			}
			else if(((PolicyScheduleReport.equalsIgnoreCase("Quotation"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("PAYMENT SLIP"))) )
			{
				 setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			}
			else if(((PolicyScheduleReport.equalsIgnoreCase("Endrosement"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("General Endorment slip"))) )
			{
				setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			}
			else if(((PolicyScheduleReport.equalsIgnoreCase("P"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("General Provision For Arabic"))) )
			{
				setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			}
			//added by krithika for mortage product 
			else if(((PolicyScheduleReport.equalsIgnoreCase("Quotation"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("DSA Print"))) )
			{
				setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			}
			//end
			//ADDED BY AMEEN 17-8-2016 FOR QUOTATION LETTER IN PROPOSAL LEVEL FALCONQC-1716555 
			else if(((PolicyScheduleReport.equalsIgnoreCase("Quotation"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Quotation Letter"))) )
			{
				setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());

			}
			else if(((PolicyScheduleReport.equalsIgnoreCase("Quotation"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Acceptance Letter"))) )
			{
				setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			}
			//END QUOTATION LETTER
			 else
			 {
				 System.out.println("inside else part");
				 //setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
		setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK(this));
			 }



		}else{


			if (IP_REP_INFO_BEAN.getROWID() == null) {




				Connection connection = null;
				ResultSet resultSet = null;
				Object[] values = null;

				POL_SYS_ID =CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID").toString().trim();
				endo_number= compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue(); 

					if ("E".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {

							System.out.println("idx no"+ endo_number);
							IP_REP_INFO_BEAN.setREP_VALUE_2(endo_number);

					}else if("Q".equals(PRINT_BEAN.getUI_M_POL_ENDT())){
						IP_REP_INFO_BEAN.setREP_VALUE_2(session.getAttribute("POL_DS_TYPE").toString().trim());
					}



				IP_REP_INFO_BEAN.setREP_VALUE_1(POL_SYS_ID);

				PRE_INSERT(this.IP_REP_INFO_BEAN);
				int recordCount = new CRUDHandler().executeInsert(IP_REP_INFO_BEAN,
						runActionConnection);
				System.out.println("IP_REP_TABLE insert count -- ["+recordCount+"]");
				runActionConnection.commit();

			} else {

				PRE_UPDATE(this.IP_REP_INFO_BEAN);
			}
			//setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_DOC_REPORT());
			//AfterValidate();

		}


	}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}

		return getRedirectUrl();


	}
	 */


	public void okButton_Other(){
		try {
			helper.WHEN_BUTTON_PRESSED_M_BUT_OK_OTHER(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	HashMap<String, String> parameterMap = new HashMap<String, String>();

	public HtmlCommandButton getCOMP_UI_M_BUT_OK1() {
		return COMP_UI_M_BUT_OK1;
	}

	public void setCOMP_UI_M_BUT_OK1(HtmlCommandButton comp_ui_m_but_ok1) {
		COMP_UI_M_BUT_OK1 = comp_ui_m_but_ok1;
	}

	public String backButton(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		//HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		String pathContext = request.getContextPath();
		String requestUrl = request.getRequestURL().toString();
		System.out.println("Context path----/"+pathContext);
		System.out.println("Request Url---/"+requestUrl);
		/*Added by Ameen on 08-02-2018 by Ameen for KIC addl_status change*/
		PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
		/*End*/
		return "PILT002_APAC_PT_IL_POLICY";
	}
	/*added by saranya for retrive pol_status*/
	public  String selectpolstatus()throws Exception{

		System.out.println("inside selectpolstatus method");
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		String POL_STATUS=null;
		 PT_IL_POLICY PT_IL_POLICY_BEAN = PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		CRUDHandler handler = new CRUDHandler();	
		Long pol_sys_is=PT_IL_POLICY_BEAN.getPOL_SYS_ID();
		String query = "SELECT POL_STATUS FROM PT_IL_POLICY where POL_SYS_ID='"+pol_sys_is+"'";
		System.out.println("query exe sucess"+query);	     
		resultSet = new CRUDHandler().executeSelectStatement(query, connection);
		System.out.println("value for insert"+	handler.executeSelectStatement(query, connection));
		while (resultSet.next()) {
			POL_STATUS=resultSet.getString("POL_STATUS");

		}
		return POL_STATUS;
	}

	public String SrrenderFlag_stus()throws Exception
	{
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		String PLAN_SURR_YN=null;

		CRUDHandler handler = new CRUDHandler();	
		String pol_sys_id=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");


		/*Changed by Ram on 19/11/2016 for Surrender DSA table Print
		 * 
		 * String query ="SELECT PLAN_SURR_YN FROM PM_IL_PLAN, PT_IL_POLICY WHERE PLAN_CODE = POL_PLAN_CODE AND POL_SYS_ID='"+pol_sys_id+"'";



	resultSet = new CRUDHandler().executeSelectStatement(query, connection);

	while (resultSet.next()) {

		PLAN_SURR_YN=resultSet.getString("PLAN_SURR_YN");
	}	*/
		String query = "SELECT COUNT(*) FROM PM_IL_TAR_DTL WHERE TD_TH_CODE =(SELECT POL_PLAN_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?) "
				+ "AND TD_PARAM_TYPE  ='S' ORDER BY TO_NUMBER(TD_PARA_01_FM)";
		resultSet = new CRUDHandler().executeSelectStatement(query, connection,new Object[]{pol_sys_id});
		int count = 0;
		while (resultSet.next()) {

			count = resultSet.getInt(1);
		}
		System.out.println("surrender count     "+count);
		if(count == 0)
		{
			PLAN_SURR_YN = "N";
		}
		else if(count > 0)
		{
			PLAN_SURR_YN = "Y";
		}

		/*End*/
		return PLAN_SURR_YN;
	}


	/*end*/


	public String runAction(){
		//added by krithika on 29-04-2016
		try {

			Connection runActionConnection = null;
			System.out.println("INSIDE RUNACTION REVIVAL");
			runActionConnection = CommonUtils.getConnection();
			POL_SYS_ID =CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
			endo_number= compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue(); 
			System.out.println("inside runaction validation"+typevalue);
			String PolicyScheduleReport=typevalue;
			String SCHEDULE_REPORT_TYPE=compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE();
			System.out.println("SCHEDULE_TYPE              : "+PolicyScheduleReport);
			System.out.println("SCHEDULE_REPORT_TYPE       : "+SCHEDULE_REPORT_TYPE);
			System.out.println("getUI_REPORT_TYPE   : "+getUI_REPORT_TYPE());
			
			
			System.out.println("ScheduleReportType                    :"+ScheduleReportType);
			
			
			/*Added by Janani on 17.03.2017 for dynamic report config for base product*/
			
			
			
			/*added by gopi on 25/07/17*/
			String REPORT_CATG = null;
			String reportQuery1 = "select pmrth_report_catg from pm_rep_tab_hdr where pmrth_rep_id=?";
			ResultSet reportRSSS = new CRUDHandler().executeSelectStatement(reportQuery1, CommonUtils.getConnection(),new Object[]{SCHEDULE_REPORT_TYPE});
			while(reportRSSS.next())
			{
				REPORT_CATG = reportRSSS.getString("pmrth_report_catg");
			}
			

			if(PRINT_BEAN.getUI_M_POL_ENDT().equalsIgnoreCase("E"))
			{
				if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("SE")){
					ScheduleReportType = "2";	
				}else{
					ScheduleReportType = "1";
				}
				//end
			}	
			
			//added by gopi for mapping quotation letter on 07/02/18

			if(PRINT_BEAN.getUI_M_POL_ENDT().equalsIgnoreCase("P"))
			{
				if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("S")){
					ScheduleReportType = "1";	
				}else{
					ScheduleReportType = "2";
				}
				//end
			
			}else if(PRINT_BEAN.getUI_M_POL_ENDT().equalsIgnoreCase("Q")){
				if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("S")){
					ScheduleReportType = "1";	
				}else{
					ScheduleReportType = "2";
				}
			}
			if(ScheduleReportType.equalsIgnoreCase("2"))

			{
				
			/*End*/
				
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT(this));

			if (IP_REP_INFO_BEAN.getROWID() == null) {
				System.out.println("ENTER IP_REP_INFO_BEAN");

				Connection connection = null;
				ResultSet resultSet = null;
				Object[] values = null;

				POL_SYS_ID =CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID").toString().trim();
				endo_number= compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue(); 
				PRE_INSERT(this.IP_REP_INFO_BEAN);
				//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
				if ("E".equals(PRINT_BEAN.getUI_M_POL_ENDT())) {

					System.out.println("idx no"+ endo_number);
					IP_REP_INFO_BEAN.setREP_VALUE_2(endo_number);

				}else if("Q".equals(PRINT_BEAN.getUI_M_POL_ENDT())){
					IP_REP_INFO_BEAN.setREP_VALUE_2(session.getAttribute("POL_DS_TYPE").toString().trim());
				}



				IP_REP_INFO_BEAN.setREP_VALUE_1(POL_SYS_ID);


				int recordCount = new CRUDHandler().executeInsert(IP_REP_INFO_BEAN,
						runActionConnection);
				System.out.println("IP_REP_TABLE insert count -- ["+recordCount+"]");
				runActionConnection.commit();
			}else {

				PRE_UPDATE(this.IP_REP_INFO_BEAN);
				//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
			}
			
			}
			
			/*Added by Janani on 17.03.2017 for dynamic report config for base product*/
			
			else
			{
				
				System.out.println("in runaction ScheduleReportType is 1(Jasper)");
				setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT(this));
				
			}

			/*End*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}
	@Override
	/*	public String runActionAfterValidate() {CommonUtils.clearMaps(this);
	HttpServletResponse response = null;
	Connection con = null;
	ResultSet resultSet= null;
	ResultSet MOPRS = null;
	ResultSet MED_FLAGRS = null;
	String PTDACover=null;
	String PTDSCover=null;
	String PPDCover=null;
	String PWRCover=null;
	String POL_MOP=null;
	String MED_FLAG=null;

	//added by krithika for report binding on 290416
	try {
		//added by saranya
		String POL_STATUS=selectpolstatus();
		//end
		added by agalya on 24-05-2016 for policy schedule

		fun();

		String url1="";
		int i =0;

		while (i<list1.size()) 
			{

				url1=url1+"&param"+i+"="+list1.get(i);
				System.out.println("url1"+url1);
				i++;

			}


		end

		if(ScheduleReportType != null && ScheduleReportType.equals("J"))
		{	
		POL_SYS_ID=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
		System.out.println("polsysid in runActionAfterValidate"+POL_SYS_ID);
		String PolicyScheduleReport=typevalue;
		String SCHEDULE_REPORT_TYPE=compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE();
		System.out.println("PolicyScheduleReport ==>>"+PolicyScheduleReport+"::SCHEDULE_REPORT_TYPE ==>>"+SCHEDULE_REPORT_TYPE+"::prod_value ==>>"+prod_value);
		String Flag_Status=SrrenderFlag_stus();
		System.out.println("Flag_Status--------->"+Flag_Status);

		if(PolicyScheduleReport.equalsIgnoreCase("P")&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Policy documents")))
		{

			System.out.println("******************  PolicyScheduleReport *******************   ");

			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());

			//below line modified by agalya 
			//url.append("PolicyScheduleReport="+PolicyScheduleReport+"&SCHEDULE_REPORT_TYPE=Policydocuments"+"&POL_SYS_ID="+POL_SYS_ID+url1);
			url.append("PolicyScheduleReport="+PolicyScheduleReport+"&SCHEDULE_REPORT_TYPE=Policydocuments"+"&POL_SYS_ID="+POL_SYS_ID+"&Flag_Status="+Flag_Status);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	

		}
		ADDED BY KRITHIKA ON 17-4-15
		else if((PolicyScheduleReport.equalsIgnoreCase("Endrosement"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Endorment slip"))){
            System.out.println("******************  Endorment slip *******************   ");

			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			url.append("EndormentScheduleReport="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID+"&endo_number="+endo_number);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	

		}

		Added BY Ameen for ssp call id :  FALCONQC-1714579   ---- Start ----

			else if((PolicyScheduleReport.equalsIgnoreCase("Endrosement"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Endorment slip"))){
	            System.out.println("******************  Endorment slip *******************   ");
	            PILT002_APAC_COMPOSITE_ACTION mainCompositeAction = (PILT002_APAC_COMPOSITE_ACTION)CommonUtils.getGlobalObject("PILT002_APAC_COMPOSITE_ACTION");
	            String END_IDX_NO=PRINT_BEAN.getList_vaue();

	            Added by Ra on 02/11/2016 for Endorsement Slip Issue
	            int endorsementnumber = 0;
	            if(END_IDX_NO != null)
	            {
	            	endorsementnumber = Integer.parseInt(END_IDX_NO);
	            	endorsementnumber--;
		            END_IDX_NO = String.valueOf(endorsementnumber);
	            }
	            End
	            System.out.println(" =============>>>END_IDX_NO<<<=========== :"+END_IDX_NO);
	            String End_Code_Query="SELECT POLH_N_END_CODE FROM PH_IL_POLICY WHERE POLH_SYS_ID="+POL_SYS_ID +" AND  POLH_END_NO_IDX ="+END_IDX_NO;
	            ResultSet End_Code_rs=null;
	            String END_CODE=null;
	            End_Code_rs=new CRUDHandler().executeSelectStatement(End_Code_Query, CommonUtils.getConnection());
	            while(End_Code_rs.next()){
	            	END_CODE=End_Code_rs.getString("POLH_N_END_CODE");
	            }
	            System.out.println(" =============>>>END_CODE<<<=========== :"+END_CODE);
				url=new StringBuffer(getRedirectUrl());
				System.out.println("this is url"+url.toString());
				//String query = "SELECT DS_DESC,DS_END_TYPE FROM PM_IL_DOC_SETUP WHERE DS_CODE = ?";
				String query = "SELECT DS_DESC FROM PM_IL_DOC_SETUP WHERE DS_CODE = ?";
				ResultSet rs = null;
				String END_DESC=null;
				rs=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{END_CODE});
				while(rs.next()){
					 END_DESC = rs.getString("DS_DESC");
					 System.out.println(" =============>>>END_DESC<<<=========== :"+END_DESC);
				}
				url.append("EndormentScheduleReport="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID+"&endo_number="+endo_number+"&END_DESC="+END_DESC+"&END_CODE="+END_CODE+"&END_TYPE="+END_CODE);
				System.out.println("after append"+url.toString());
				setRedirectUrl(url.toString());	

			}

		  ----    End ----- 

		else if(((PolicyScheduleReport.equalsIgnoreCase("P"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("General Provision For Arabic"))) )
		{
			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			url.append("PolicyScheduleArabic="+SCHEDULE_REPORT_TYPE);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	

		}

		else if((((PolicyScheduleReport.equalsIgnoreCase("P"))||(PolicyScheduleReport.equalsIgnoreCase("Quotation"))))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("PAYMENT SLIP")) )
		{
			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			url.append("Paymentslipagent="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());
		}
		else if(((PolicyScheduleReport.equalsIgnoreCase("Endrosement"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("PAYMENT SLIP"))&&(POL_APPRV_STATUS.equalsIgnoreCase("N"))) )
		{
			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			url.append("Paymentslipagent="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());
		}

                //END
		//added by agalya for DSA print on 03-06-2016
		else if(((PolicyScheduleReport.equalsIgnoreCase("P"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("DSA Print"))) )
		{
			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			url.append("PolicyScheduleSubReport="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID+"&DS_TYPE="+val);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	

		}
		//added by krithika for mortage product 
		else if(((PolicyScheduleReport.equalsIgnoreCase("Quotation"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("DSA Print"))) )
		{
			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			url.append("PolicyScheduleSubReport="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID+"&DS_TYPE="+val);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	

		}
		//end
		else if((PolicyScheduleReport.equalsIgnoreCase("P"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Policy review sheet"))){
            System.out.println("******************  Policy review sheet *******************   ");

			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			url.append("ReviewsheetScheduleReport="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	

		}
		else if(((PolicyScheduleReport.equalsIgnoreCase("Quotation"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Quotation review sheet"))) )
		{

			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			url.append("QuotationReviewsheetReport="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	
		}
		else if(((PolicyScheduleReport.equalsIgnoreCase("Endrosement"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("General Endorment slip"))) )
		{
			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is url"+url.toString());
			url.append("GeneralEndromentReport="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	
		}
		//ADDED BY AMEEN 17-8-2016 FOR QUOTATION LETTER IN PROPOSAL LEVEL FALCONQC-1716555 


		else if(((PolicyScheduleReport.equalsIgnoreCase("Quotation"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Quotation Letter"))) )
		{

			//COVER AND MOP details
			con=CommonUtils.getConnection();
			//String coversQuery = "SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ?";
			String coversQuery = "SELECT POL_PLAN_CODE  COVER_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ? "
								+ "UNION SELECT POAC_COVER_CODE  COVER_CODE FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ?  ";
			resultSet = new CRUDHandler().executeSelectStatement(coversQuery, con,new Object[]{POL_SYS_ID,POL_SYS_ID});
			while(resultSet.next()){
				System.out.println("coverssssss ==>>"+resultSet.getString("COVER_CODE"));

				if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDA") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDA_122")){
					PTDACover="PTDA";
					System.out.println("INSIDE PTDCover ::==>>"+PTDACover);
				}
				if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDS") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDS_122")){
					PTDSCover="PTDS";
					System.out.println("INSIDE PTDCover ::==>>"+PTDSCover);
				}
				if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDA") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDS") || 
						resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDA_122") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDS_122")){
					PPDCover="PPD";
					System.out.println("INSIDE PPDCover ::==>>"+PPDCover);
				}
				if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PWR")){
					PWRCover="PWR";
					System.out.println("INSIDE PWRCover ::==>>"+PWRCover);
				}
			}
			String MOPQuery="SELECT POL_MODE_OF_PYMT  FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
			MOPRS = new CRUDHandler().executeSelectStatement(MOPQuery, con,new Object[]{POL_SYS_ID});
			while(MOPRS.next()){
				POL_MOP = MOPRS.getString("POL_MODE_OF_PYMT");
				System.out.println("INSIDE POL_MOP ::==>>"+POL_MOP);
			}
			String MED_FLAGQuery = "SELECT PMED_EXAM_CODE FROM PT_IL_POLICY,PT_IL_POL_MED_EXAM_DTL "
									+ "WHERE PMED_POL_SYS_ID = POL_SYS_ID AND PMED_POL_SYS_ID = ?";
			MED_FLAGRS = new CRUDHandler().executeSelectStatement(MED_FLAGQuery, con,new Object[]{POL_SYS_ID});
			while(MED_FLAGRS.next()){
				MED_FLAG = MED_FLAGRS.getString("PMED_EXAM_CODE");
				System.out.println("INSIDE MED_FLAG ::==>>"+MED_FLAG);
			}

			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is Quotation Letter url"+url.toString());
			url.append("Quotation_Letter="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID+"&PROD_CODE="+prod_value+"&PTDACover="+PTDACover+"&PPDCover="+PPDCover+"&POL_MOP="+POL_MOP+"&PWRCover="+PWRCover+"&MED_FLAG="+MED_FLAG+"&PTDSCover="+PTDSCover);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	

		}
		else if(((PolicyScheduleReport.equalsIgnoreCase("Quotation"))&&(SCHEDULE_REPORT_TYPE.equalsIgnoreCase("Acceptance Letter"))) )
		{
			url=new StringBuffer(getRedirectUrl());
			System.out.println("this is Acceptance Letter url"+url.toString());
			url.append("Quotation_Letter="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID+"&PROD_CODE="+prod_value);
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());	

		}

		//END QUOTATION LETTER
		else
		{
			//added by saranya on 25-04-2016 for revival
			url=new StringBuffer(getRedirectUrl());
			url.append("RevivalReportName="+getUI_REPORT_TYPE()+"&POL_STATUS="+POL_STATUS+"&POL_SYS_ID="+POL_SYS_ID);			
			System.out.println("this is url"+url.toString());
			System.out.println("after append"+url.toString());
			setRedirectUrl(url.toString());
			//end
		}



			String M_FLEX05 = null;
			String C6="SELECT NVL(POL_FLEX_05,'N') FROM PT_IL_POLICY WHERE POL_SYS_ID=?";
			ResultSet  C6_REC = null;
			String updateQry="UPDATE PT_IL_POLICY SET POL_FLEX_05 ='Y' WHERE POL_SYS_ID=?";

		CRUDHandler	handler =new CRUDHandler();
		Connection connection =CommonUtils.getConnection();
		C6_REC = handler.executeSelectStatement(C6, connection,new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID")});
		if (C6_REC.next()) {
			M_FLEX05 = C6_REC.getString(1);
		}
			if("N".equalsIgnoreCase(M_FLEX05)){
				handler.executeUpdateStatement(updateQry, connection, new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID")});
				connection.commit();
			}

		if (getRedirectUrl() != null) {
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
			response.sendRedirect(getRedirectUrl());
		}

		}else if(ScheduleReportType != null && ScheduleReportType.equals("M"))
		{



			System.out.println("ScheduleReportType is M");

			System.out.println("******************ENTERING INTO runActionAfterValidate *******************");
				String type=this.getPRINT_BEAN().getUI_M_POL_ENDT();
			String reporttype=this.getPRINT_BEAN().getUI_M_OTHERS();
			String Endorsement_number =PRINT_BEAN.getUI_M_POL_END_NO();

			System.out.println("value of reporttype------>"+reporttype);
			String	POL_SYS_ID=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
			System.out.println("value of POL_SYS_ID------>"+POL_SYS_ID);
			System.out.println("value of Endorsement_number------>"+Endorsement_number);



			POL_SYS_ID=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
			System.out.println("polsysid in runActionAfterValidate"+POL_SYS_ID);
			String PolicyScheduleReport=typevalue;
			String SCHEDULE_REPORT_TYPE=compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE();

			String Flag_Status=SrrenderFlag_stus();
			System.out.println("Flag_Status--------->"+Flag_Status);

			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String moduleId = (String) sessionMap.get("GLOBAL.M_MODULE_ID");


			String rep_template_name= null;
			String polDStype = session.getAttribute("POL_DS_TYPE").toString();
			ReportGeneration repGenBean = new ReportGeneration();
			session.setAttribute("REP_IP_REP_INFO", IP_REP_INFO_BEAN);
			System.out.println("POL_APPRV_STATUS        "+POL_APPRV_STATUS+"         polDStype         "+polDStype+"      typevalue       "+getUI_REPORT_TYPE());
			if(polDStype != null)
			{
				if(polDStype.equals("1"))
				{
					rep_template_name = new CommonReport().template_name(moduleId,POL_APPRV_STATUS,getUI_REPORT_TYPE());
					setRedirectUrl(CommonReport.genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null));
				}
				else if(polDStype.equals("2"))
				{
					//rep_template_name = new CommonReport().template_name(moduleId,POL_APPRV_STATUS,getUI_REPORT_TYPE());
					rep_template_name="REP_ID=PREMIREP080&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID=PILT002_APAC";
					//setRedirectUrl(CommonReport.genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null));
					System.out.println("request.getServerName()  :"+request.getServerName());
					setRedirectUrl("http://10.44.10.244:8082/P11JZBIndLife/XDocSchedule?"+rep_template_name+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE=PDOC");
				}
			}

			System.out.println("rep_template_name          "+rep_template_name);


			if(rep_template_name == null)
			{
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "77775",
						new Object[]{"Not a valid report"})));
			}
			else
			{

				if (getRedirectUrl() != null) {
					response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
					System.out.println("getRedirectUrl FOR mdocs "+getRedirectUrl());

					response.sendRedirect(getRedirectUrl());


				} 
			}






		}


	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("runAction", e.getMessage());
	}
	return null;
	}
	 */


	public String runActionAfterValidate() {CommonUtils.clearMaps(this);
	HttpServletResponse response = null;

	//added by krithika for report binding on 290416
	try {
		/*Added by Ganesh on 16-05-2017, to avoid popup when email button click */
		getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		/*end*/
		//added by saranya
		String POL_STATUS=selectpolstatus();
		//end
		Connection con = null;
		ResultSet resultSet= null;

		System.out.println("");
		/*Added by Sankar for Quotation letter report on 01.09.2016*/
		String Product_Code=session.getAttribute("POL_PROD_CODE").toString();

		/*Added by Ram on 19/08/2016 for Dynamic Report Configuration*/
		//String ScheduleReportType = resourceBundle.getString("ScheduleReportType");

		//IP_REP_INFO IP_REP_INFO_BEAN = new IP_REP_INFO();
		/*String REP_KEY_NO = new ReportUtils().getRepKeyNo();
		IP_REP_INFO_BEAN.setREP_KEY_NO(REP_KEY_NO);
		 */
		
		/*Added by Janani on 17.03.2017 for dynamic report config for base product*/
		
		
		/*ADDED BY GOPI ON 25/07/17 */
		/*MODIFIED BY GOPI FOR SSP CALL ID ZBILQC-1732857 ON 16/08/17*/
		String REPORT_CATG = null,REPORT_INTERNAL_TYPE=null;
		String reportQuery1 = "select pmrth_report_catg,pmrth_rep_type from pm_rep_tab_hdr where pmrth_rep_id=?";
		String SCHEDULE_REPORT_TYPE_TWEO=compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE();
		ResultSet reportRSSS = new CRUDHandler().executeSelectStatement(reportQuery1, CommonUtils.getConnection(),new Object[]{SCHEDULE_REPORT_TYPE_TWEO});
		while(reportRSSS.next())
		{
			REPORT_CATG = reportRSSS.getString("pmrth_report_catg");
			REPORT_INTERNAL_TYPE = reportRSSS.getString("pmrth_rep_type");
		}
		
		/*END FOR SSP CALL ID ZBILQC-1732857 ON 16/08/17*/
	//END
		
		
		
		
		
		
		
		
		
		if(PRINT_BEAN.getUI_M_POL_ENDT().equalsIgnoreCase("E"))
		{
			if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("SE")){
				ScheduleReportType = "2";
			}else{
				ScheduleReportType = "1";	
			}
			
		}	
		//added by gopi for mapping quotation letter on 07/02/18

		if(PRINT_BEAN.getUI_M_POL_ENDT().equalsIgnoreCase("P"))
		{
			if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("S")){
				ScheduleReportType = "1";	
			}else{
				ScheduleReportType = "2";
			}
		}else if(PRINT_BEAN.getUI_M_POL_ENDT().equalsIgnoreCase("Q")){
			if(REPORT_CATG!=null && REPORT_CATG.equalsIgnoreCase("S")){
				ScheduleReportType = "1";	
			}else{
				ScheduleReportType = "2";
			}
		}
		
		
		
			//end
		System.out.println("ScheduleReportType IN runActionAfterValidate "+ScheduleReportType);
		if(ScheduleReportType != null && ScheduleReportType.equals("1"))
		{	
System.out.println("ScheduleReportType is 1");
		String polDStype = session.getAttribute("POL_DS_TYPE").toString();

		POL_SYS_ID=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
		System.out.println("polsysid in runActionAfterValidate"+POL_SYS_ID);
		String PolicyScheduleReport=typevalue;
		String SCHEDULE_REPORT_TYPE=compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE();



		System.out.println("Enter into PolicyScheduleReport ");

		String Flag_Status=SrrenderFlag_stus();
		System.out.println("Flag_Status--------->"+Flag_Status);
		String pol_sys_is=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");

		resultSet = null;
		CRUDHandler handler = new CRUDHandler();	
		Connection conn = CommonUtils.getConnection();

		IP_REP_INFO repInfo = new IP_REP_INFO();
		String REP_KEY_NO = new ReportUtils().getRepKeyNo();
		repInfo.setREP_KEY_NO(REP_KEY_NO);
		System.out.println("SCHEDULE_REPORT_TYPE         "+SCHEDULE_REPORT_TYPE);
		//Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
/*		if(SCHEDULE_REPORT_TYPE != null && (SCHEDULE_REPORT_TYPE.equals("PREMIREP065") || SCHEDULE_REPORT_TYPE.equals("PREMIREP116")))
		{*/
		//end
			String reportNames = null;
			String reportQuery = "SELECT PMRTH_MULTIPLE_REPORT_NAMES FROM pm_rep_tab_hdr WHERE pmrth_rep_id = ?";
			ResultSet reportRS = new CRUDHandler().executeSelectStatement(reportQuery, CommonUtils.getConnection(),new Object[]{SCHEDULE_REPORT_TYPE});
			while(reportRS.next())
			{
				reportNames = reportRS.getString(1);
			}
			
			repInfo.setREP_VALUE_1("20");
			repInfo.setREP_VALUE_2("POL_SYS_ID&&&"+pol_sys_is);
			/*MODIFIED BY GOPI FOR SSP CALL ID ZBILQC-1732857 ON 16/08/17*/
			endo_number= compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue();
			if(REPORT_INTERNAL_TYPE.equalsIgnoreCase("ESL"))
			{
			repInfo.setREP_VALUE_3("end_idx_no&&&"+endo_number);
			}else{
				repInfo.setREP_VALUE_3("Flag_Status&&&"+Flag_Status);
			}
			//END
			repInfo.setREP_VALUE_4("Intermediary&&&Intermediary");
			
			if(reportNames != null)
			{
				repInfo.setREP_VALUE_59(reportNames);	
			}
			
			String POAC_COVER_CODE=null;
			String Prod_code=null;

			System.out.println("pol_sys_is       "+pol_sys_is);

			String query ="SELECT POL_SYS_ID, POL_NO, POL_PROD_CODE, PROD_DESC,POAC_COVER_CODE, COVER_LONG_DESC FROM PT_IL_POLICY, PT_IL_POL_ADDL_COVER, PM_IL_PRODUCT,"
					+ " PM_IL_COVER WHERE POAC_POL_SYS_ID=POL_SYS_ID AND POL_PROD_CODE=PROD_CODE AND POAC_COVER_CODE=COVER_CODE AND POL_SYS_ID='"+pol_sys_is+"'";



			resultSet = new CRUDHandler().executeSelectStatement(query, conn);
			int repInfoLoop = 5,paramCount = 0;
			while (resultSet.next()) {

				POAC_COVER_CODE=resultSet.getString("POAC_COVER_CODE");
				Prod_code=resultSet.getString("POL_PROD_CODE");
				System.out.println("POAC_COVER_CODE       "+POAC_COVER_CODE+"     Prod_code       "+Prod_code);

				setvaluesintoRepInfoBean(repInfo,("param"+paramCount+"&&&"+POAC_COVER_CODE),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;
				paramCount++;
				setvaluesintoRepInfoBean(repInfo,("param"+paramCount+"&&&"+Prod_code),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;
				paramCount++;

			}	

			/*//Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
			 * 
			 * if(repInfoLoop < 18)
			{
				for(int start = repInfoLoop;start <= 18;start++)
				{
					setvaluesintoRepInfoBean(repInfo,("param"+repInfoLoop+"&&&"+null),"REP_VALUE_"+start);
				}
			}*/

/*		}//end*/
		
		/*Added by Sankar for Quotation letter report on 01.09.2016*/
	
			//Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
	/*else if(SCHEDULE_REPORT_TYPE != null && "PREMIREP073".equalsIgnoreCase(SCHEDULE_REPORT_TYPE)){   //QUOTATION LETTER
		*/
		//end
					
					
					String PTDACover=null;
					String PTDSCover=null;
					String PPDCover=null;
					String PWRCover=null;
					con=CommonUtils.getConnection();
					//String coversQuery = "SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ?";
					String coversQuery = "SELECT POL_PLAN_CODE  COVER_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ? "
							+ "UNION SELECT POAC_COVER_CODE  COVER_CODE FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ?  ";
					resultSet = new CRUDHandler().executeSelectStatement(coversQuery, con,new Object[]{POL_SYS_ID,POL_SYS_ID});
					while(resultSet.next()){
						System.out.println("coverssssss ==>>"+resultSet.getString("COVER_CODE"));

						if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDA") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDA_122")){
							PTDACover="PTDA";
							System.out.println("INSIDE PTDCover ::==>>"+PTDACover);
						}
						if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDS") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDS_122")){
							PTDSCover="PTDS";
							System.out.println("INSIDE PTDCover ::==>>"+PTDSCover);
						}
						if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDA") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDS") || 
								resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDA_122") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDS_122")){
							PPDCover="PPD";
							System.out.println("INSIDE PPDCover ::==>>"+PPDCover);
						}
						if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PWR")){
							PWRCover="PWR";
							System.out.println("INSIDE PWRCover ::==>>"+PWRCover);
						}
					}
					
					//Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
					/*if("122".equalsIgnoreCase(Product_Code)){ */ //quotation_letter_munichre
						/*Added by Janani for Quotation letter report on 30.8.2016*/
					
						
						/*repInfo.setREP_VALUE_1("6");
						repInfo.setREP_VALUE_2("POL_SYS_ID&&&"+pol_sys_is);
						repInfo.setREP_VALUE_3("PTDA_COVER&&&"+PTDACover);
						repInfo.setREP_VALUE_4("PTDS_COVER&&&"+PTDSCover);
						repInfo.setREP_VALUE_5("PPD_COVER&&&"+PPDCover);
						repInfo.setREP_VALUE_6("PWR_COVER&&&"+PWRCover);*/
						
						
					 
						
						
						 
						
						/*SCHEDULE_REPORT_TYPE=resourceBundle.getString("QUOTATIONLETTERMUN");*/
				
					/*}else{  */  //quotation_letter_swissre
					/*end*/
						/*Added by Janani for Quotation letter report on 30.8.2016*/
						endo_number= compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue(); 
						System.out.println("endo_number        "+endo_number);
						Prod_code();
						ResultSet MOPRS = null;
						ResultSet MED_FLAGRS = null;
						String POL_MOP=null;
						String MED_FLAG=null;

						con=CommonUtils.getConnection();
						//String coversQuery = "SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ?";
						
						String MOPQuery="SELECT POL_MODE_OF_PYMT  FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
						MOPRS = new CRUDHandler().executeSelectStatement(MOPQuery, con,new Object[]{POL_SYS_ID});
						while(MOPRS.next()){
							POL_MOP = MOPRS.getString("POL_MODE_OF_PYMT");
							System.out.println("INSIDE POL_MOP ::==>>"+POL_MOP);
						}
						String MED_FLAGQuery = "SELECT PMED_EXAM_CODE FROM PT_IL_POLICY,PT_IL_POL_MED_EXAM_DTL "
								+ "WHERE PMED_POL_SYS_ID = POL_SYS_ID AND PMED_POL_SYS_ID = ?";
						MED_FLAGRS = new CRUDHandler().executeSelectStatement(MED_FLAGQuery, con,new Object[]{POL_SYS_ID});
						while(MED_FLAGRS.next()){
							MED_FLAG = MED_FLAGRS.getString("PMED_EXAM_CODE");
							System.out.println("INSIDE MED_FLAG ::==>>"+MED_FLAG);
						}

						//Added by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
						setvaluesintoRepInfoBean(repInfo,("PTDA_COVER&&&"+PTDACover),"setREP_VALUE_"+repInfoLoop);
						repInfoLoop++;
						setvaluesintoRepInfoBean(repInfo,("PTDS_COVER&&&"+PTDSCover),"setREP_VALUE_"+repInfoLoop);
						repInfoLoop++;
						setvaluesintoRepInfoBean(repInfo,("PPD_COVER&&&"+PPDCover),"setREP_VALUE_"+repInfoLoop);
						repInfoLoop++;
						setvaluesintoRepInfoBean(repInfo,("PWR_COVER&&&"+PWRCover),"setREP_VALUE_"+repInfoLoop);
						repInfoLoop++;
						setvaluesintoRepInfoBean(repInfo,("MOP_FREQ&&&"+POL_MOP),"setREP_VALUE_"+repInfoLoop);
						repInfoLoop++;
						setvaluesintoRepInfoBean(repInfo,("PROD_CODE&&&"+Product_Code),"setREP_VALUE_"+repInfoLoop);
						repInfoLoop++;
						setvaluesintoRepInfoBean(repInfo,("MED_FLAG&&&"+MED_FLAG),"setREP_VALUE_"+repInfoLoop);
						repInfoLoop++;
						//end
						
						//Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
						/*repInfo.setREP_VALUE_1("8");
						repInfo.setREP_VALUE_2("POL_SYS_ID&&&"+pol_sys_is);
						repInfo.setREP_VALUE_3("PTDA_COVER&&&"+PTDACover);
						repInfo.setREP_VALUE_4("PPD_COVER&&&"+PPDCover);
						repInfo.setREP_VALUE_5("MOP_FREQ&&&"+POL_MOP);
						repInfo.setREP_VALUE_6("PROD_CODE&&&"+Product_Code);
						repInfo.setREP_VALUE_7("MED_FLAG&&&"+MED_FLAG);
						repInfo.setREP_VALUE_8("PTDS_COVER&&&"+PTDSCover);*/
					//	repInfo.setREP_VALUE_9("PWRCover&&&"+PWRCover);    NOT REQUIE FOR  quotation_letter_swissre REF BY AMMENN COMMENTED BY SANKAR
				/*}*/
						//end
					
				/*
				 * //Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
				 * }else if(SCHEDULE_REPORT_TYPE != null && "PREMIREP075".equalsIgnoreCase(SCHEDULE_REPORT_TYPE)) {*/   //ACCEPTANCE LETTER
				
					/*if("122".equalsIgnoreCase(Product_Code)){           //acceptance_letter_munichre
						repInfo.setREP_VALUE_1("2");
						repInfo.setREP_VALUE_2("POL_SYS_ID&&&"+pol_sys_is);
						SCHEDULE_REPORT_TYPE=resourceBundle.getString("ACEPTACELETTERMUN");
					}else{//acceptance_letter_swissre
						repInfo.setREP_VALUE_1("2");
						repInfo.setREP_VALUE_2("POL_SYS_ID&&&"+pol_sys_is);
						
					}
					
					*/

				/*}*/
						//end
				/*End*/
					//Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper	
		/* Newly Added By Dhinesh on 20.3.2017 */
				/*else if(SCHEDULE_REPORT_TYPE != null && "PREMIREP212".equalsIgnoreCase(SCHEDULE_REPORT_TYPE)) {*/   //ACCEPTANCE LETTER
					//end
					endo_number= compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue(); 
					/*
					 * Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
					 * repInfo.setREP_VALUE_1("3");
					repInfo.setREP_VALUE_2("POL_SYS_ID&&&"+pol_sys_is);
					repInfo.setREP_VALUE_3("POL_END_NO_IDX&&&"+endo_number);
					
					//end
					*/
					//Added by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
					setvaluesintoRepInfoBean(repInfo,("POL_END_NO_IDX&&&"+endo_number),"setREP_VALUE_"+repInfoLoop);
					repInfoLoop++;
					//end

				/*}*/
		/* End */
		/*else
		{*/

			/*Added by Janani for Quotation letter report on 30.8.2016*/
			endo_number= compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue(); 
			System.out.println("endo_number        "+endo_number);
			Prod_code();


			/*
			 * Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
			 * ResultSet MOPRS = null;
			ResultSet MED_FLAGRS = null;*/
			/*String PTDACover=null;
			String PTDSCover=null;
			String PPDCover=null;
			String PWRCover=null;*/
			/*String POL_MOP=null;
			String MED_FLAG=null;*/
			//end
			
			con=CommonUtils.getConnection();
			/*Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper*/
			//String coversQuery = "SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ?";
			/*String coversQuery = "SELECT POL_PLAN_CODE  COVER_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ? "
					+ "UNION SELECT POAC_COVER_CODE  COVER_CODE FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ?  ";*/
			/*end*/
			resultSet = new CRUDHandler().executeSelectStatement(coversQuery, con,new Object[]{POL_SYS_ID,POL_SYS_ID});
			while(resultSet.next()){
				System.out.println("coverssssss ==>>"+resultSet.getString("COVER_CODE"));

				if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDA") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDA_122")){
					PTDACover="PTDA";
					System.out.println("INSIDE PTDCover ::==>>"+PTDACover);
				}
				if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDS") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PTDS_122")){
					PTDSCover="PTDS";
					System.out.println("INSIDE PTDCover ::==>>"+PTDSCover);
				}
				if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDA") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDS") || 
						resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDA_122") || resultSet.getString("COVER_CODE").equalsIgnoreCase("PPDS_122")){
					PPDCover="PPD";
					System.out.println("INSIDE PPDCover ::==>>"+PPDCover);
				}
				if(resultSet.getString("COVER_CODE").equalsIgnoreCase("PWR")){
					PWRCover="PWR";
					System.out.println("INSIDE PWRCover ::==>>"+PWRCover);
				}
			}
			/*Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper*/
			/*String MOPQuery="SELECT POL_MODE_OF_PYMT  FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";*/
			//end
			MOPRS = new CRUDHandler().executeSelectStatement(MOPQuery, con,new Object[]{POL_SYS_ID});
			while(MOPRS.next()){
				POL_MOP = MOPRS.getString("POL_MODE_OF_PYMT");
				System.out.println("INSIDE POL_MOP ::==>>"+POL_MOP);
			}
			/*Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper*/
			/*String MED_FLAGQuery = "SELECT PMED_EXAM_CODE FROM PT_IL_POLICY,PT_IL_POL_MED_EXAM_DTL "
					+ "WHERE PMED_POL_SYS_ID = POL_SYS_ID AND PMED_POL_SYS_ID = ?";*/
			/* end */
			MED_FLAGRS = new CRUDHandler().executeSelectStatement(MED_FLAGQuery, con,new Object[]{POL_SYS_ID});
			while(MED_FLAGRS.next()){
				MED_FLAG = MED_FLAGRS.getString("PMED_EXAM_CODE");
				System.out.println("INSIDE MED_FLAG ::==>>"+MED_FLAG);
			}

			/*	url.append("Quotation_Letter="+SCHEDULE_REPORT_TYPE+"&POL_SYS_ID="+POL_SYS_ID+"&PROD_CODE="+prod_value+
						"&PTDACover="+PTDACover+"&PPDCover="+PPDCover+
						"&POL_MOP="+POL_MOP+"&PWRCover="+PWRCover+
						"&MED_FLAG="+MED_FLAG+"&PTDSCover="+PTDSCover);		*/

			//System.out.println("PROD_CODE              :"+list1.get(1));

			/*end*/

			/*
			 * Commented by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper
			 * repInfo.setREP_VALUE_1("14");
			repInfo.setREP_VALUE_2("POL_SYS_ID&&&"+pol_sys_is);
			repInfo.setREP_VALUE_3("POLH_SYS_ID&&&"+pol_sys_is);
			repInfo.setREP_VALUE_4("END_NO_IDX"+"&&&"+endo_number);
			repInfo.setREP_VALUE_5("POL_STATUS&&&"+POL_STATUS);
			repInfo.setREP_VALUE_6("endo_number"+"&&&"+endo_number);
			repInfo.setREP_VALUE_7("DS_TYPE&&&"+polDStype);
			repInfo.setREP_VALUE_8("PROD_CODE&&&"+Prod_code);
			repInfo.setREP_VALUE_9("PTDACover&&&"+PTDACover);
			repInfo.setREP_VALUE_10("PPDCover&&&"+PPDCover);
			repInfo.setREP_VALUE_11("POL_MOP&&&"+POL_MOP);
			repInfo.setREP_VALUE_12("PWRCover&&&"+PWRCover);
			repInfo.setREP_VALUE_13("MED_FLAG&&&"+MED_FLAG);
			repInfo.setREP_VALUE_14("PTDSCover&&&"+PTDSCover);*/
			
			/*end*/
			/*Added by Ram on 27/03/2017 To maintain repvalues common for all reports in jasper*/
			setvaluesintoRepInfoBean(repInfo,("DS_TYPE&&&"+polDStype),"setREP_VALUE_"+repInfoLoop);
			repInfoLoop++;
			//end
			/* Added by Ameen on 27/03/2017 for credit note parameters
			 */
			if(endo_number == null)
			{
				endo_number = "0";
			}
			setvaluesintoRepInfoBean(repInfo,("endo_number&&&"+endo_number),"setREP_VALUE_"+repInfoLoop);
			repInfoLoop++;			
			
			/*end*/
			
			//Added by Ameen on 28-03-2017 for Endorsement Slip
			/* String END_IDX_NO=PRINT_BEAN.getList_vaue();*/
			 String END_IDX_NO=CommonUtils.nvl(PRINT_BEAN.getList_vaue(), "0");
			 
			 /*Added by Ra on 02/11/2016 for Endorsement Slip Issue*/
				int endorsementnumber = 0;
				if(END_IDX_NO != null)
				{
					endorsementnumber = Integer.parseInt(END_IDX_NO);
					endorsementnumber--;
					END_IDX_NO = String.valueOf(endorsementnumber);
				}
				/*End*/
				
	            String end_query = null;
				ResultSet end_rs = null;
	            String OLD_VALUE1 = null;
				String NEW_VALUE1 = null;
				String OLD_VALUE2 = null;
				String NEW_VALUE2 = null;
				String OLD_VALUE3 = null;
				String NEW_VALUE3 = null;
				String OLD_VALUE4 = null;
				String NEW_VALUE4 = null;
				String OLD_VALUE5 = null;
				String NEW_VALUE5 = null;
				String OLD_VALUE6 = null;
				String NEW_VALUE6 = null;
				String OLD_VALUE7 = null;
				String NEW_VALUE7 = null;
			
				System.out.println(" =============>>>END_IDX_NO<<<=========== :"+END_IDX_NO);
	            String End_Code_Query="SELECT POLH_N_END_CODE FROM PH_IL_POLICY WHERE POLH_SYS_ID="+POL_SYS_ID +" AND  POLH_END_NO_IDX ="+END_IDX_NO;
	            ResultSet End_Code_rs=null;
	            String END_CODE="";
	            End_Code_rs=new CRUDHandler().executeSelectStatement(End_Code_Query, CommonUtils.getConnection());
	            while(End_Code_rs.next()){
	            	END_CODE=End_Code_rs.getString("POLH_N_END_CODE");
	            }
	            System.out.println(" =============>>>END_CODE<<<=========== :"+END_CODE);	           
	            
	            if(END_CODE.equalsIgnoreCase("GEN001")){
	            	System.out.println("************* INSIDE THE GEN001 **************");
	            	end_query = "SELECT POLH_O_ASSURED_NAME,POLH_N_ASSURED_NAME FROM PH_IL_POLICY WHERE POLH_SYS_ID ="+POL_SYS_ID+" AND POLH_END_NO_IDX ="+END_IDX_NO;
					end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
					while(end_rs.next()){
						OLD_VALUE1 = end_rs.getString("POLH_O_ASSURED_NAME");
						NEW_VALUE1 = end_rs.getString("POLH_N_ASSURED_NAME");
					}
					System.out.println(" ASSR_NAME_OLD_VALUE1 =="+OLD_VALUE1+"ASSR_NAME_NEW_VALUE1 =="+NEW_VALUE1);
				}
				else if(END_CODE.equalsIgnoreCase("GEN002")){
					System.out.println("************* INSIDE THE GEN002 **************");
					end_query = "SELECT PBENH_O_REF_ID1,PBENH_N_REF_ID1,PBENH_O_CATG_CODE,PBENH_N_CATG_CODE,PBENH_O_AGE,PBENH_N_AGE,PBENH_O_RELATION_CODE,"
							+"PBENH_N_RELATION_CODE,PBENH_O_PERC,PBENH_N_PERC FROM PH_IL_POL_BENEFICIARY WHERE PBENH_POL_SYS_ID ="+POL_SYS_ID+" AND PBENH_END_NO_IDX ="+END_IDX_NO;
					end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
					while(end_rs.next()){
					OLD_VALUE1 = end_rs.getString("PBENH_O_REF_ID1");
					NEW_VALUE1 = end_rs.getString("PBENH_N_REF_ID1");
					OLD_VALUE2 = end_rs.getString("PBENH_O_CATG_CODE");
					NEW_VALUE2 = end_rs.getString("PBENH_N_CATG_CODE");
					OLD_VALUE3 = end_rs.getString("PBENH_O_AGE");
					NEW_VALUE3 = end_rs.getString("PBENH_N_AGE");
					OLD_VALUE4 = end_rs.getString("PBENH_O_RELATION_CODE");
					NEW_VALUE4 = end_rs.getString("PBENH_N_RELATION_CODE");
					OLD_VALUE5 = end_rs.getString("PBENH_O_PERC");
					NEW_VALUE5 = end_rs.getString("PBENH_N_PERC");
					}
				}
				else if(END_CODE.equalsIgnoreCase("GEN003")){
					System.out.println("************* INSIDE THE GEN003 **************");
					end_query = "SELECT PBENH_O_AGE,PBENH_N_AGE,PBENH_O_PERC,PBENH_N_PERC,PBENH_O_BNF_NAME,PBENH_N_BNF_NAME,"
							+ "PBENH_O_BANK_CODE,PBENH_N_BANK_CODE,PBENH_O_DIVISION,PBENH_N_DIVISION,PBENH_O_ACNT_NO,PBENH_N_ACNT_NO "
							+ "FROM PH_IL_POL_BENEFICIARY WHERE PBENH_POL_SYS_ID ="+POL_SYS_ID+" AND PBENH_END_NO_IDX ="+END_IDX_NO;
					end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
					while(end_rs.next()){
						OLD_VALUE1 = end_rs.getString("PBENH_O_AGE");
						NEW_VALUE1 = end_rs.getString("PBENH_N_AGE");
						OLD_VALUE2 = end_rs.getString("PBENH_O_PERC");
						NEW_VALUE2 = end_rs.getString("PBENH_N_PERC");
						OLD_VALUE3 = end_rs.getString("PBENH_O_BNF_NAME");
						NEW_VALUE3 = end_rs.getString("PBENH_N_BNF_NAME");
						OLD_VALUE4 = end_rs.getString("PBENH_O_BANK_CODE");
						NEW_VALUE4 = end_rs.getString("PBENH_N_BANK_CODE");
						OLD_VALUE5 = end_rs.getString("PBENH_O_DIVISION");
						OLD_VALUE5 = end_rs.getString("PBENH_N_DIVISION");
						NEW_VALUE6 = end_rs.getString("PBENH_O_ACNT_NO");
						NEW_VALUE6 = end_rs.getString("PBENH_N_ACNT_NO");
					}
					System.out.println("OLD_VALUE1=="+OLD_VALUE1+"OLD_VALUE2 =="+OLD_VALUE2+"OLD_VALUE3 =="+OLD_VALUE3+"OLD_VALUE4 =="+OLD_VALUE4+"OLD_VALUE5 =="+OLD_VALUE5+"OLD_VALUE6 =="+OLD_VALUE6+
							"NEW_VALUE1 =="+NEW_VALUE1+"NEW_VALUE2 =="+NEW_VALUE2+"NEW_VALUE3 =="+NEW_VALUE3+"NEW_VALUE4 =="+NEW_VALUE4+"NEW_VALUE5 =="+NEW_VALUE5+"NEW_VALUE6 =="+NEW_VALUE6);

				}else if(END_CODE.equalsIgnoreCase("GEN005")){
					System.out.println("************* INSIDE THE GEN005 **************");
					end_query = "SELECT POLH_O_RES_ADDRESS_1,POLH_N_RES_ADDRESS_1,POLH_O_RES_ADDRESS_2,POLH_N_RES_ADDRESS_2,POLH_O_RES_ADDRESS_3,POLH_N_RES_ADDRESS_3,POLH_O_RES_AREA_CODE,"
								+ "POLH_N_RES_AREA_CODE,POLH_O_CITY_CODE,POLH_N_CITY_CODE,POLH_O_STATE_CODE,POLH_N_STATE_CODE,POLH_O_COUNT_CODE,POLH_N_COUNT_CODE FROM PH_IL_POLICY "
								+ "WHERE POLH_SYS_ID ="+POL_SYS_ID+" AND POLH_END_NO_IDX ="+END_IDX_NO;

					end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
					while(end_rs.next()){
						OLD_VALUE1 = end_rs.getString("POLH_O_RES_ADDRESS_1");
						NEW_VALUE1 = end_rs.getString("POLH_N_RES_ADDRESS_1");
						OLD_VALUE2 = end_rs.getString("POLH_O_RES_ADDRESS_2");
						NEW_VALUE2 = end_rs.getString("POLH_N_RES_ADDRESS_2");
						OLD_VALUE3 = end_rs.getString("POLH_O_RES_ADDRESS_3");
						NEW_VALUE3 = end_rs.getString("POLH_N_RES_ADDRESS_3");
						OLD_VALUE4 = end_rs.getString("POLH_O_RES_AREA_CODE");
						NEW_VALUE4 = end_rs.getString("POLH_N_RES_AREA_CODE");
						OLD_VALUE5 = end_rs.getString("POLH_O_CITY_CODE");
						NEW_VALUE5 = end_rs.getString("POLH_N_CITY_CODE");
						OLD_VALUE6 = end_rs.getString("POLH_O_STATE_CODE");
						NEW_VALUE6 = end_rs.getString("POLH_N_STATE_CODE");
						OLD_VALUE7 = end_rs.getString("POLH_O_COUNT_CODE");
						NEW_VALUE7 = end_rs.getString("POLH_N_COUNT_CODE");
					}
					System.out.println("OLD_VALUE1 =="+OLD_VALUE1+"OLD_VALUE2 =="+OLD_VALUE2+"OLD_VALUE3 =="+OLD_VALUE3+
							"NEW_VALUE1 =="+NEW_VALUE1+"NEW_VALUE2 =="+NEW_VALUE2+"NEW_VALUE3 =="+NEW_VALUE3);

				}else if(END_CODE.equalsIgnoreCase("GEN006")){
					System.out.println("************* INSIDE THE GEN006 **************");
					end_query = "SELECT POLH_O_RES_PHONE_NO,POLH_N_RES_PHONE_NO,POLH_O_MOBILE_NO,POLH_N_MOBILE_NO FROM PH_IL_POLICY WHERE POLH_SYS_ID ="+POL_SYS_ID+" AND POLH_END_NO_IDX ="+END_IDX_NO;
					end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
					while(end_rs.next()){
						OLD_VALUE1 = end_rs.getString("POLH_O_RES_PHONE_NO");
						NEW_VALUE1 = end_rs.getString("POLH_N_RES_PHONE_NO");
						OLD_VALUE2 = end_rs.getString("POLH_O_MOBILE_NO");
						NEW_VALUE2 = end_rs.getString("POLH_N_MOBILE_NO");
					}
					System.out.println("OLD_VALUE1            "+OLD_VALUE1+"OLD_VALUE2      "+OLD_VALUE2+"OLD_VALUE3      "+OLD_VALUE3+
							"NEW_VALUE1       "+NEW_VALUE1+"NEW_VALUE2        "+NEW_VALUE2+"NEW_VALUE3            "+NEW_VALUE3);

				}else if(END_CODE.equalsIgnoreCase("GEN007")){
					System.out.println("************* INSIDE THE GEN007 **************");
					end_query = "SELECT POLH_O_FLEX_26,POLH_N_FLEX_26 FROM PH_IL_POLICY WHERE POLH_SYS_ID ="+POL_SYS_ID+" AND POLH_END_NO_IDX ="+END_IDX_NO;
					end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
					while(end_rs.next()){
						OLD_VALUE1 = end_rs.getString("POLH_O_FLEX_26");
						NEW_VALUE1 = end_rs.getString("POLH_N_FLEX_26");
					}
				}else if(END_CODE.equalsIgnoreCase("MOP")){
					System.out.println("************* INSIDE THE MOP **************");
					end_query = "SELECT POLH_O_MODE_OF_PYMT, POLH_N_MODE_OF_PYMT, POLH_O_LC_BASIC_PREM, POLH_N_LC_BASIC_PREM FROM PH_IL_POLICY "
							+ "WHERE POLH_SYS_ID = "+POL_SYS_ID+"AND POLH_END_NO_IDX ="+END_IDX_NO;
					end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
					while(end_rs.next()){
						if(end_rs.getString("POLH_O_MODE_OF_PYMT").equalsIgnoreCase("Y")){
							OLD_VALUE1 = "YEARLY";
						}
						if(end_rs.getString("POLH_O_MODE_OF_PYMT").equalsIgnoreCase("H")){
							OLD_VALUE1 = "HALF YEARLY";
						}
						if(end_rs.getString("POLH_O_MODE_OF_PYMT").equalsIgnoreCase("Q")){
							OLD_VALUE1 = "QUARTERLY";
						}
						if(end_rs.getString("POLH_O_MODE_OF_PYMT").equalsIgnoreCase("M")){
							OLD_VALUE1 = "MONTHLY";
						}
					    if(end_rs.getString("POLH_O_MODE_OF_PYMT").equalsIgnoreCase("S")){
							OLD_VALUE1 = "SINGLE";
						}
					    if(end_rs.getString("POLH_N_MODE_OF_PYMT").equalsIgnoreCase("Y")){
					    	NEW_VALUE1 = "YEARLY";
					    }
					    if(end_rs.getString("POLH_N_MODE_OF_PYMT").equalsIgnoreCase("H")){
					    	NEW_VALUE1 = "HALF YEARLY";
					    }
					    if(end_rs.getString("POLH_N_MODE_OF_PYMT").equalsIgnoreCase("Q")){
					    	NEW_VALUE1 = "QUARTERLY";
					    }
					    if(end_rs.getString("POLH_N_MODE_OF_PYMT").equalsIgnoreCase("M")){
					    	NEW_VALUE1 = "MONTHLY";
					    }
					    if(end_rs.getString("POLH_N_MODE_OF_PYMT").equalsIgnoreCase("S")){
					    	NEW_VALUE1 = "SINGLE";
					    }
						OLD_VALUE2 = end_rs.getString("POLH_O_LC_BASIC_PREM");
						NEW_VALUE2 = end_rs.getString("POLH_N_LC_BASIC_PREM");
					}
				}

				if(OLD_VALUE1 !=null)
				{
					if(NEW_VALUE1==null || NEW_VALUE1.equals(""))
					{
						NEW_VALUE1="---";

					}
				}else if(OLD_VALUE1 == null || OLD_VALUE1.equals(""))
				{
					if(NEW_VALUE1!=null)
					{
						OLD_VALUE1="---";

					}
				}
				
				if(OLD_VALUE2!=null)
				{
					if(NEW_VALUE2==null || NEW_VALUE2.equals(""))
					{
						NEW_VALUE2="---";

					}
				}else if(OLD_VALUE2 == null || OLD_VALUE2.equals(""))
				{
					if(NEW_VALUE2!=null )
					{
						OLD_VALUE2="---";

					}
				}
				
				if(OLD_VALUE3!=null)
				{
					if(NEW_VALUE3==null || NEW_VALUE3.equals(""))
					{
						NEW_VALUE3="---";

					}
				}else if(OLD_VALUE3 == null || OLD_VALUE3.equals(""))
				{
					if(NEW_VALUE3!=null)
					{
						OLD_VALUE3="---";

					}
				}
				if(OLD_VALUE4!=null)
				{
					if(NEW_VALUE4==null || NEW_VALUE4.equals(""))
					{
						NEW_VALUE4="---";

					}
				}else if(OLD_VALUE4 == null || OLD_VALUE4.equals(""))
				{
					if(NEW_VALUE4!=null)
					{
						OLD_VALUE4="---";

					}
				}
				
				if(OLD_VALUE5!=null)
				{
					if(NEW_VALUE5==null || NEW_VALUE5.equals(""))
					{
						NEW_VALUE5="---";

					}
				}else if(OLD_VALUE5 == null || OLD_VALUE5.equals(""))
				{
					if(NEW_VALUE5!=null)
					{
						OLD_VALUE5="---";

					}
				}
				
				if(OLD_VALUE6!=null)
				{
					if(NEW_VALUE6==null || NEW_VALUE6.equals(""))
					{
						NEW_VALUE6="---";

					}
				}else if(OLD_VALUE6 == null || OLD_VALUE6.equals(""))
				{
					if(NEW_VALUE6!=null)
					{
						OLD_VALUE6="---";

					}
				}
				
				if(OLD_VALUE7!=null)
				{
					if(NEW_VALUE7==null || NEW_VALUE7.equals(""))
					{
						NEW_VALUE7="---";

					}
				}else if(OLD_VALUE7 == null || OLD_VALUE7.equals(""))
				{
					if(NEW_VALUE7!=null)
					{
						OLD_VALUE7="---";

					}
				}
				
				System.out.println("End_Code_Type =="+END_CODE+" END_NO_IDX =="+END_IDX_NO+" OLD_VALUE1=="+OLD_VALUE1+" OLD_VALUE2 =="+OLD_VALUE2+" OLD_VALUE3 =="+OLD_VALUE3+" OLD_VALUE4 =="+OLD_VALUE4+" OLD_VALUE5 =="+OLD_VALUE5+" OLD_VALUE6 =="+OLD_VALUE6+
						" NEW_VALUE1 =="+NEW_VALUE1+" NEW_VALUE2 =="+NEW_VALUE2+" NEW_VALUE3 =="+NEW_VALUE3+" NEW_VALUE4 =="+NEW_VALUE4+" NEW_VALUE5 =="+NEW_VALUE5+" NEW_VALUE6 =="+NEW_VALUE6);
	            
				String queryDocSetup = "SELECT DS_DESC FROM PM_IL_DOC_SETUP WHERE DS_CODE = ?";
				ResultSet rs = null;
				String END_DESC=null;
				rs=new CRUDHandler().executeSelectStatement(queryDocSetup, CommonUtils.getConnection(),new Object[]{END_CODE});
				while(rs.next()){
					 END_DESC = rs.getString("DS_DESC");
					 System.out.println(" =============>>>END_DESC<<<=========== :"+END_DESC);
				}
			
				
				
				 /*Added by Ram on 02/11/2016 for Endorsement Slip Issue*/
				 
				if(END_IDX_NO != null)
				{
					endorsementnumber = Integer.parseInt(END_IDX_NO);
					endorsementnumber++;
					END_IDX_NO = String.valueOf(endorsementnumber);
				}
				System.out.println("END_IDX_NO AT SECOND       "+END_IDX_NO);
				/*End*/
				

				
				setvaluesintoRepInfoBean(repInfo,("POLH_SYS_ID&&&"+pol_sys_is),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("END_NO_IDX&&&"+END_IDX_NO),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("END_TITLE&&&"+END_DESC),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("END_TYPE&&&"+END_CODE),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("OLD_VALUE1&&&"+OLD_VALUE1),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("NEW_VALUE1&&&"+NEW_VALUE1),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				
				setvaluesintoRepInfoBean(repInfo,("OLD_VALUE2&&&"+OLD_VALUE2),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("NEW_VALUE2&&&"+NEW_VALUE2),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("OLD_VALUE3&&&"+OLD_VALUE3),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("NEW_VALUE3&&&"+NEW_VALUE3),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("OLD_VALUE4&&&"+OLD_VALUE4),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				
				setvaluesintoRepInfoBean(repInfo,("NEW_VALUE4&&&"+NEW_VALUE4),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("OLD_VALUE5&&&"+OLD_VALUE5),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("NEW_VALUE5&&&"+NEW_VALUE5),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("OLD_VALUE6&&&"+OLD_VALUE6),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("NEW_VALUE6&&&"+NEW_VALUE6),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;
				setvaluesintoRepInfoBean(repInfo,("OLD_VALUE7&&&"+OLD_VALUE7),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;	
				setvaluesintoRepInfoBean(repInfo,("NEW_VALUE7&&&"+NEW_VALUE7),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;

			//end endorsment slip code
				
			//Added by ameen 28-03-2017 for debit note
				
				/*String queryDebit ="  SELECT F_DEBIT_NOTE_AMOUNT('"+pol_sys_is+"' ) FROM DUAL";*/
				/*String queryDebit ="  SELECT F_DEBIT_NOTE_AMOUNT('"+pol_sys_is+"','"+END_IDX_NO+"' ) FROM DUAL";
				String totalAmount = "1";
				 ResultSet debitRS = handler.executeSelectStatement(queryDebit, CommonUtils.getConnection());
				while (debitRS.next()) {
					totalAmount = debitRS.getString(1);
				}
				System.out.println("totalAmount     "+totalAmount);
				String convertedValue = Decimal_Convert(totalAmount);
				System.out.println("convertedValue     "+convertedValue);
				String debitAmountinWords =new RUPEE_TO_WORD().getRupeeinword(convertedValue,CommonUtils.getConnection());
								
				setvaluesintoRepInfoBean(repInfo,("debitAmountinWords&&&"+debitAmountinWords),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;*/
			//end	

/*		}*/
				
				/*Added by Ram on 28/03/2017*/
				/*added by gopi for toi on 29/06/2018*/
				/*String PolicyLogopath1=System.getProperty("user.home")+"\\TOI_LOGO\\TOI_LOGO1.jpg";
				String PolicyLogopath2=System.getProperty("user.home")+"\\TOI_LOGO\\TOI_LOGO2.jpg";
				String PolicyLogopath3=System.getProperty("user.home")+"\\TOI_LOGO\\TOI_LOGO3.jpg";
				setvaluesintoRepInfoBean(repInfo,("LOGO1&&&"+PolicyLogopath1),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;
				setvaluesintoRepInfoBean(repInfo,("LOGO2&&&"+PolicyLogopath2),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;
				setvaluesintoRepInfoBean(repInfo,("LOGO3&&&"+PolicyLogopath3),"setREP_VALUE_"+repInfoLoop);
				repInfoLoop++;*/
				
				
				/**/
				
				
				/*Modified by Sivarajan on 07/02/2020 for Orient IL*/
				/*String Logoquery="SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE='IL_REP_LOGO'"; 
				 ResultSet RESULT = null;
				 int psvalue=0;
					try {
					 RESULT = new CRUDHandler().executeSelectStatement(Logoquery, con);
					 if(RESULT.next()) {
						 psvalue = RESULT.getInt("PS_VALUE");
					 }
					
					} catch (Exception e) {
					 e.printStackTrace();
				 } 
				String LogoPath=System.getProperty("user.home")+"/TOI_LOGO/";
				
						for(int i=1;i<=psvalue;i++){
						setvaluesintoRepInfoBean(repInfo,("LOGO"+i+"&&&"+LogoPath+SCHEDULE_REPORT_TYPE+"_"+i+".jpg"),"setREP_VALUE_"+repInfoLoop);
										repInfoLoop++;
						}*/
				
				/*End*/
				
				
				
				
				repInfo.setREP_VALUE_1(Integer.toString(repInfoLoop));
				//end
				/*End*/
		
		/*Added by Janani for POlicy doc merging on 17.03.2017*/
		
		String menuAction = (String)CommonUtils.getGlobalObject("MENU_ACTION");
		
		
		
		
		
		/*End*/
		
		
		int ins = handler.executeInsert(repInfo, conn);
		conn.commit();


		url=new StringBuffer(getRedirectUrl());
		System.out.println("this is url"+url.toString());
		//url.append("PolicyScheduleArabic="+SCHEDULE_REPORT_TYPE);
		System.out.println("SCHEDULE_REPORT_TYPE       "+SCHEDULE_REPORT_TYPE);
		url.append("REP_ID="+SCHEDULE_REPORT_TYPE+"&REP_KEY_NO="+REP_KEY_NO);
		
		/*Added by saritha on 09-04-2018 for KIC Once policy doc is printed status is not getting updated as pending delivery,
		Additional status to change when user selects print or email document*/ 
		String reportViewType = CommonUtils.getGlobalVariable("reporttype");
		if(reportViewType!=null){
			url.append("&viewtype="+reportViewType);
		}
		
		/*End*/
		System.out.println("after append"+url.toString());
		setRedirectUrl(url.toString());

		/*Modified by saritha on 09-04-2018 for KIC Once policy doc is printed status is not getting updated as pending delivery,
		Additional status to change when user selects print or email document*/ 
		if (getRedirectUrl() != null && CommonUtils.getGlobalVariable("reporttype").equals("view")) {
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
			response.sendRedirect(getRedirectUrl());
		}
	/*End*/
		
	}
		
		if(ScheduleReportType != null && ScheduleReportType.equals("2"))
		{


			System.out.println("ScheduleReportType is 2 (Mdocs)");

			System.out.println("******************ENTERING INTO runActionAfterValidate *******************");

			POL_SYS_ID=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
			System.out.println("polsysid in runActionAfterValidate"+POL_SYS_ID);
			String PolicyScheduleReport=typevalue;
			String SCHEDULE_REPORT_TYPE=compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE();

			String Flag_Status=SrrenderFlag_stus();
			System.out.println("Flag_Status--------->"+Flag_Status);

			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String moduleId = (String) sessionMap.get("GLOBAL.M_MODULE_ID");
			//String  moduleId ="PILT002_APAC";

			String rep_template_name= null;
			//aDDED BY SANKARA NARAYANAN FOR REPORT
			 PT_IL_POLICY PT_IL_POLICY_BEAN = PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			POL_APPRV_STATUS=PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS();
			//END
			String polDStype = session.getAttribute("POL_DS_TYPE").toString();
			session.setAttribute("REP_IP_REP_INFO", IP_REP_INFO_BEAN);
			/*ReportGeneration repGenBean = new ReportGeneration();*/

			System.out.println("POL_APPRV_STATUS        "+POL_APPRV_STATUS+"         polDStype         "+polDStype+"      typevalue       "+getUI_REPORT_TYPE());
			if(polDStype != null)
			{
				if(polDStype.equals("1"))
				{
					System.out.println("Enter the proposal block screen ");

					/*	rep_template_name = new CommonReport().template_name(moduleId,POL_APPRV_STATUS,getUI_REPORT_TYPE());
					setRedirectUrl(new CommonReport().genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null));*/

					rep_template_name="&REP_ID="+getUI_REPORT_TYPE()+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+getUI_REPORT_TYPE();
					System.out.println("request.getServerName()  :"+request.getServerName());
					setRedirectUrl(getRedirectUrl()+rep_template_name);
					System.out.println("End");
				}
				else if(polDStype.equals("2"))
				{
					/*Commented by saranya on 12-05-2017,for multiple report display 
					 * 
					 * System.out.println("Enter the Policy block screen ");

					rep_template_name="&REP_ID="+getUI_REPORT_TYPE()+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+getUI_REPORT_TYPE();
					System.out.println("request.getServerName()  :"+request.getServerName());
					setRedirectUrl(getRedirectUrl()+rep_template_name);
					System.out.println("End");*/

					/*Added by saranya for hands on points on 26-04-2017*/
					System.out.println("Enter the Policy block screen ");
					
					String Report_Type=null;
					Alternate_Rep_ID();
					System.out.println(CommonUtils.getGlobalVariable("reporttype")+"--ALTTYPE-->"+getAlternate_Rep_ID()+" Multiple Rep ID"+getMultiple_Rep_ID());
					if(CommonUtils.getGlobalVariable("reporttype").equals("view")/*&&(getAlternate_Rep_ID()!=null)*/){
						if(getAlternate_Rep_ID()!=null){
						Report_Type=getAlternate_Rep_ID();
						if(getMultiple_Rep_ID()!=null){
						String ALT_REP_KEY_NO=IP_REP_INFO_BEAN.getREP_KEY_NO()+",";
						String[] Split_Rep_ID = getMultiple_Rep_ID().split(",");
						int length=Split_Rep_ID.length;
						System.out.println("Length  :"+length);
						for(int i=0;i<length-1;i++){
							IP_REP_INFO_BEAN=new IP_REP_INFO();
							runAction();							
							ALT_REP_KEY_NO=ALT_REP_KEY_NO+IP_REP_INFO_BEAN.getREP_KEY_NO()+",";
							System.out.println("ALT_REP_KEY_NO   :"+ALT_REP_KEY_NO);
						}
						ALT_REP_KEY_NO=ALT_REP_KEY_NO.substring(0,ALT_REP_KEY_NO.length()-1);
						System.out.println("ALT_REP_KEY_NO  substring :"+ALT_REP_KEY_NO);
						rep_template_name="&REP_ID="+Report_Type+"&REP_KEY_NO="+ALT_REP_KEY_NO+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+Report_Type+"&Type="+'M'+"&viewtype="+"view";
						}else{
						
							rep_template_name="&REP_ID="+Report_Type+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+Report_Type+"&Type="+'S'+"&viewtype="+"view";

						}
						}else{
							Report_Type=getUI_REPORT_TYPE();
							rep_template_name="&REP_ID="+Report_Type+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+Report_Type+"&Type="+'S'+"&viewtype="+"view";

						}
					}else{
						attachReq();
						Report_Type=getUI_REPORT_TYPE();
						if(CommonUtils.getGlobalVariable("reporttype").equals("email")/*&&(getMailAttachReq()!=null)*/){
							if(getMailAttachReq()!=null){
								String mulMailAttachReq=getMailAttachReq();
								String ALT_REP_KEY_NO=IP_REP_INFO_BEAN.getREP_KEY_NO()+",";
								String[] splitMailAttach = getMailAttachReq().split(",");
								int length=splitMailAttach.length;
								System.out.println("Length of splitMailAttach :"+length);
								for(int i=0;i<length-1;i++){
									IP_REP_INFO_BEAN=new IP_REP_INFO();
									runAction();							
									ALT_REP_KEY_NO=ALT_REP_KEY_NO+IP_REP_INFO_BEAN.getREP_KEY_NO()+",";
									System.out.println("ALT_REP_KEY_NO   :"+ALT_REP_KEY_NO);
								}
								ALT_REP_KEY_NO=ALT_REP_KEY_NO.substring(0,ALT_REP_KEY_NO.length()-1);
								System.out.println("ALT_REP_KEY_NO  substring :"+ALT_REP_KEY_NO);
								rep_template_name="&REP_ID="+Report_Type+"&REP_KEY_NO="+ALT_REP_KEY_NO+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+Report_Type+"&Type="+'M'+"&viewtype=email";
							}else{
								Report_Type=getUI_REPORT_TYPE();
								rep_template_name="&REP_ID="+Report_Type+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+Report_Type+"&Type="+'S'+"&viewtype=email";

							}
						}
					}
					/*rep_template_name="&REP_ID="+getUI_REPORT_TYPE();+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+getUI_REPORT_TYPE();*/
					/*End*/
					System.out.println("request.getServerName()  :"+request.getServerName());
					setRedirectUrl(getRedirectUrl()+rep_template_name);
					System.out.println("End");

				//end
					
				}
			}

			System.out.println("getRedirectUrl()   : "+getRedirectUrl());
			System.out.println("rep_template_name          "+rep_template_name);


			if(rep_template_name == null)
			{
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "77775",
						new Object[]{"Not a valid report"})));
			}
			else if(CommonUtils.getGlobalVariable("reporttype")!=null && CommonUtils.getGlobalVariable("reporttype").equals("view"))
			{

				if (getRedirectUrl() != null) {
					response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();






					System.out.println("getRedirectUrl FOR mdocs "+getRedirectUrl());

					response.sendRedirect(getRedirectUrl());


				}
			}

		}
		
		/*Added by saritha on 28-03-2018 for KIC Pending delivery - Once policy document is printed, additional status to be changed as Pending Deliver*/
		
		
		/*if("PREMIREP578".equalsIgnoreCase(compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE())){
			String autoUW = "N";
			String prod_value=session.getAttribute("POL_PROD_CODE").toString();
			ResultSet rs = new CRUDHandler().executeSelectStatement("SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT A WHERE PROD_CODE = ?", CommonUtils.getConnection(),
					new Object[]{prod_value});
			if(rs.next()){
				autoUW = rs.getString("PROD_AUTO_UW");
			}
			if("Y".equalsIgnoreCase(autoUW)){				
					String pol_sys_id=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
					new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = '005' WHERE POL_SYS_ID = ?", 
							CommonUtils.getConnection(),new Object[]{pol_sys_id});
	
					CommonUtils.getConnection().commit();
					System.out.println("Report Successsfully Printed.....");
				}	

		}*/
	/*	commented by gopi on 10/02/2018 as discussed with ajoy*/
		/*	String autoUW = "N";
			String prod_value=session.getAttribute("POL_PROD_CODE").toString();
			ResultSet rs = new CRUDHandler().executeSelectStatement("SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT A WHERE PROD_CODE = ?", CommonUtils.getConnection(),
					new Object[]{prod_value});
			if(rs.next()){
				autoUW = rs.getString("PROD_AUTO_UW");
			}
			if("Y".equalsIgnoreCase(autoUW)){
				String repIds="";
				String repQry = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'POL_SCH_RPT'";
				String pol_sys_id=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
				ResultSet repRS = new CRUDHandler().executeSelectStatement(repQry, CommonUtils.getConnection());
				if(repRS.next()){
					repIds = repRS.getString("PS_CODE_DESC");
				}
				if (CommonUtils.isIN(compositeAction
						.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE(), repIds.split(","))) {

					//pol_sys_id=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");
					new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = '005' WHERE POL_SYS_ID = ?", 
							CommonUtils.getConnection(),new Object[]{pol_sys_id});
	
					//CommonUtils.getConnection().commit();
					int disp = new CRUDHandler().executeInsertStatement("INSERT INTO PT_IL_POL_DISPATCH_DTLS (PDD_POL_SYS_ID,PDD_DATE,PDD_STATUS,PDD_REMARKS,"
							+ "PDD_CR_DT,PDD_CR_UID)VALUES(?,?,?,?,?,?)", CommonUtils.getConnection(),
							new Object[]{pol_sys_id,new CommonUtils().getCurrentDate(),"DP01","Policy Schedule Report",
								new CommonUtils().getCurrentDate(),CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")});
					System.out.println("KIC schedule Printed..... AND dispatch update qry =" + disp);
				}	
				
				CommonUtils.getConnection().commit();
		}*/
		
		/*End*/
		

	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("runAction", e.getMessage());
	}
	return null;
	}
	
	/*Added by Ganesh on 02/03/2017 for Mail attachment*/
	private String sendGet(String redirectURL) throws DBException, Exception {
		
		System.out.println("Redirect URL--->"+redirectURL);
		URL obj = new URL(redirectURL);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		StringBuffer response = new StringBuffer();
				StringBuffer outPutFileName = new StringBuffer();
				System.out.println("POST Response Code :: " + responseCode);
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			//Comented by ganesh on 12-05-2017 for multireport display 
			/*String outPutFileName = System.getProperty("java.io.tmpdir")+IP_REP_INFO_BEAN.getREP_KEY_NO()+".pdf";
			System.out.println("Attachment file path---->"+outPutFileName);
			Email_Procedure_Call.emailTriggerProcCall(prod_value,"POL",CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString(),"C",outPutFileName,CommonUtils.getConnection());*/

			//Added by ganesh on 12-05-2017 for multireport display
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				outPutFileName.append(inputLine);
			}
			in.close();

			//Added by saritha on 09-04-2018
			attachReq();
			System.out.println("Attachment file path---->"+outPutFileName+" getEmailTemplateType()--> "+getEmailTemplateType());
			Email_Procedure_Call.emailTriggerProcCall(prod_value,getEmailTemplateType(),CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString(),"C",outPutFileName.toString(),CommonUtils.getConnection());
/*end*/
		

		} else {
			System.out.println("GET request not worked");
		}

		return response!=null?response.toString():"";
	}
	/*End*/
	
	
	
	public ArrayList<SelectItem> SCHEDULE_TYPE_LIST(){

		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;
		try {
			list = new ArrayList<SelectItem>();

			selectItem = new SelectItem();
			System.out.println("pol value:"+val);
			if(val.startsWith("2"))
			{
				System.out.println("enter into if statements");

				selectItem.setLabel("Policy");
				selectItem.setValue("Policy");
				list.add(selectItem);
				selectItem = new SelectItem();

				/*selectItem.setLabel("Quotation");
			selectItem.setValue("Quotation");
			list.add(selectItem);
			selectItem = new SelectItem();*/

				selectItem.setLabel("Endrosement");
				selectItem.setValue("Endrosement");
				list.add(selectItem);
				selectItem = new SelectItem(); 

				System.out.println("SELECITEM   : "+selectItem.getValue());
			}

			else if(val.startsWith("1")){	
				System.out.println("enter in elseif statements");
				selectItem.setLabel("Proposal");
				selectItem.setValue("Quotation");
				list.add(selectItem);
				selectItem = new SelectItem();		

				/*selectItem.setLabel("Policy");
			selectItem.setValue("Policy");
			list.add(selectItem);
			selectItem = new SelectItem();
			selectItem.setLabel("Endrosement");
			selectItem.setValue("Endrosement");
			list.add(selectItem);
			selectItem = new SelectItem();*/

				System.out.println("SELECITEM   : "+selectItem.getValue());
			}
			else{
				System.out.println("enter into else statement");
				selectItem.setLabel("Endrosement");
				selectItem.setValue("Endrosement");
				list.add(selectItem);
				/*selectItem = new SelectItem();
			selectItem.setLabel("Quotation");
			selectItem.setValue("Quotation");
			list.add(selectItem);*/
				selectItem = new SelectItem();		

				selectItem.setLabel("Policy");
				selectItem.setValue("Policy");
				list.add(selectItem);

			}

		}

		catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	/*Added by Ram on 05/11/2016 for FALCONLIFE-1351395*/
	private boolean endorseChange;

	public boolean isEndorseChange() {
		return endorseChange;
	}
	public void setEndorseChange(boolean endorseChange) {
		this.endorseChange = endorseChange;
	}
	/*End*/






	/*Dynamic print action copied from mhc*/


	private void prepareDropDowns(){
		try{
			Connection connection = CommonUtils.getConnection();
			/*Added by Janani for Dynamic report config on 24.8.2016*/
			System.out.println("ENTERS INTO prepareDropDowns");

			System.out.println("prepareDropDowns val              :"+session.getAttribute("POL_DS_TYPE").toString());
			String DS_TYPE=session.getAttribute("POL_DS_TYPE").toString();
			if(DS_TYPE.equals("1"))
			{
				
				/*added by gopi for toi on 16/06/18*/
				 String policy_aaprove=getPolicyApprove();
				 if(policy_aaprove!=null && "O".equalsIgnoreCase(policy_aaprove)){
					 setListUI_M_POL_ENDT(getDropDownListValue_2(connection));
						System.out.println("DSD"+getListUI_M_POL_ENDT().size()); 
						
					 
				 }else{
					 System.out.println("inside prepareDropDowns val 1");
						setListUI_M_POL_ENDT(ListItemUtil.getDropDownListValue_1(connection, 
								"PILP016","PRINT", 
								"PRINT.M_PRO_ENDT", 
								null));
				 }
				
				
				//end
				
				
/*
				System.out.println("inside prepareDropDowns val 1");
				setListUI_M_POL_ENDT(ListItemUtil.getDropDownListValue_1(connection, 
						"PILP016","PRINT", 
						"PRINT.M_PRO_ENDT", 
						null));*/
			}
			else if(DS_TYPE.equals("2"))
			{
				System.out.println("inside prepareDropDowns val 2");
				
				/*added by gopi for toi on 16/06/18
				 String policy_aaprove=getPolicyApprove();
				 if(policy_aaprove!=null && "O".equalsIgnoreCase(policy_aaprove)){
					 setListUI_M_POL_ENDT(getDropDownListValue_2(connection));
						System.out.println("DSD"+getListUI_M_POL_ENDT().size()); 
						
					 
				 }else{
					 setListUI_M_POL_ENDT(ListItemUtil.getDropDownListValue_1(connection, 
								"PILP016","PRINT", 
								"PRINT.M_POL_ENDT", 
								null));
						System.out.println("DSD"+getListUI_M_POL_ENDT().size()); 
				 }
				
				*/
				//end
				setListUI_M_POL_ENDT(ListItemUtil.getDropDownListValue_1(connection, 
						"PILP016","PRINT", 
						"PRINT.M_POL_ENDT", 
						null));
				System.out.println("DSD"+getListUI_M_POL_ENDT().size()); 
				
				
			}

			/*END*/
			setListUI_M_SCHEDULE(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP016", "PRINT",
					"PRINT.M_SCHEDULE", null));
			setListUI_M_PRINTYPE(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP016", "PRINT",
					"PRINT.M_PRINTYPE", null));
			setListUI_M_OTHERS(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP016", "PRINT",
					"PRINT.M_OTHERS", null));
			setListUI_M_OTH_TYPE(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP016", "PRINT",
					"PRINT.M_OTH_TYPE", null));
			setListUI_M_PRINTYPE1(ListItemUtil.getDropDownListValue_1(
					connection, "PGLP016", "PRINT",
					"PRINT.M_PRINTYPE1", null));
		}catch (Exception e) {
		}

	}


	/*added by janani on 1.8.2016*/

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


	/*public void setListItemValues() {
	Connection connection = null;

	System.out.println("enters into setListItemValues ");
	try {
		connection = CommonUtils.getConnection();
		selectapprovalstatus();
		selectpolstatus();

		String reportType = (session.getAttribute("POL_DS_TYPE").toString().equals("1") ? "PRO" : "POL");
		System.out.println(" reportType        "+reportType);


		if(PRINT_BEAN.getUI_M_POL_ENDT()==null)
		{
			if(listUI_M_POL_ENDT.size()>=0){
				if(listUI_M_POL_ENDT.get(0).getValue()!=null){
					System.out.println("ilistUI_M_POL_ENDT.get(0).getValue()"+listUI_M_POL_ENDT.get(0).getValue());



					PRINT_BEAN.setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(0).getValue().toString().trim());
				}
			}

		}
		typevalue=PRINT_BEAN.getUI_M_POL_ENDT();





		if(listUI_M_POL_ENDT.size() > 0)
		{
			System.out.println("inside listUI_M_POL_ENDT.size() > 0");

			if(reportType.equalsIgnoreCase("pol"))
			{
			setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(1).getValue().toString().trim());
			}
			else
			{
				setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(0).getValue().toString().trim());
			}

		}


		added by sankar for list based on product_code on 31-08-2016
		String prod_value=session.getAttribute("POL_PROD_CODE").toString();
		end

		if(ScheduleReportType.equalsIgnoreCase("J"))
		{
				setListUI_REPORT_TYPE(CommonReportAction.getDropDownListValue_1(
					connection,	selectapprovalstatus(),
					reportType,getUI_M_POL_ENDT(),prod_value));


		}else{
			setListUI_REPORT_TYPE(CommonReportAction.getDropDownListValue_1(
					connection, 
					selectapprovalstatus(),
					reportType,getUI_M_POL_ENDT(),prod_value));
		}
		if(getUI_REPORT_TYPE()==null){
			setUI_REPORT_TYPE("IPL");
		}



	}

	catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
}
	 */


	/*ADDED BY SANKAR  ON 29/08/2016*/

	public void setListItemValues() {
		Connection connection = null;

		System.out.println("enters into setListItemValues ");
		try {
			connection = CommonUtils.getConnection();
			/*commented by sankaraNarayanan on 16/02/2016 for print Button*/
			//selectapprovalstatus();
			//selectpolstatus();
			/*end*/
			 PT_IL_POLICY PT_IL_POLICY_BEAN = PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			String reportType = (session.getAttribute("POL_DS_TYPE").toString().equals("1") ? "PRO" : "POL");
			System.out.println(" reportType        "+reportType);


			if(reportType.equals("POL"))
			{

				if(PRINT_BEAN.getUI_M_POL_ENDT()==null)
				{
					if(listUI_M_POL_ENDT.size()>=0){
						if(listUI_M_POL_ENDT.get(0).getValue()!=null){
							System.out.println("ilistUI_M_POL_ENDT.get(0).getValue()"+listUI_M_POL_ENDT.get(0).getValue());
							/*added by gopi for ssp call id ZBILQC-1732718 on 24/07/17*/
							if(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX()!=0){
								PRINT_BEAN.setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(0).getValue().toString().trim());
								PRINT_BEAN.setList_vaue(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX().toString());
								COMP_UI_M_ENLIST.setDisabled(false);
							}else{
								PRINT_BEAN.setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(1).getValue().toString().trim());
								
							}
							//end
						}
					}

				}
			}
			else
			{

				System.out.println("enters into setListItemValues PRO");

				if(PRINT_BEAN.getUI_M_POL_ENDT()==null)
				{
					if(listUI_M_POL_ENDT.size()>=0){
						if(listUI_M_POL_ENDT.get(0).getValue()!=null){
							System.out.println("ilistUI_M_POL_ENDT.get(0).getValue()"+listUI_M_POL_ENDT.get(0).getValue());
							PRINT_BEAN.setUI_M_POL_ENDT(listUI_M_POL_ENDT.get(0).getValue().toString().trim());
						}
					}

				}
			}

			
			typevalue=PRINT_BEAN.getUI_M_POL_ENDT();


			/*added by sankar for list based on product_code on 31-08-2016*/
			String prod_value=session.getAttribute("POL_PROD_CODE").toString();
			/*end*/

			if(ScheduleReportType.equalsIgnoreCase("2")) /* 2-Mdocs*/
			{
				/*modified by gopi for ssp call id ZBILQC-1731299 on 13/07/17*/
				/*Added by sankaraNarayanan on 16/02/2016 for print Button*/
							
				String Cover_code=Get_cover_code();
				
				
				
					setListUI_REPORT_TYPE(CommonReportAction.getDropDownListValue_1(
							connection,
							PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(),
							reportType,PRINT_BEAN.getUI_M_POL_ENDT(),prod_value,PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS(),Cover_code,PT_IL_POLICY_BEAN.getPOL_END_CODE()));
				
				/*end*/

			}else{
				
				
				
				/*
				 * Commented by Janani on 17.03.2017 for dynamic report config for base product
				 * 
				 * 
				 * setListUI_REPORT_TYPE(CommonReportAction.getDropDownListValue_1(
						connection,
						PT_IL_POLICY_BEAN.getPOL_STATUS(),
						reportType,PRINT_BEAN.getUI_M_POL_ENDT(),prod_value,null));*/
				
				
				/*modified(null added for cover code) by gopi for ssp call id ZBILQC-1731299 on 13/07/17*/
				/*Added by Janani on 17.03.2017 for dynamic report config for base product*/
				
				System.out.println("PT_IL_POLICY_BEAN.getPOL_STATUS()               :"+PT_IL_POLICY_BEAN.getPOL_STATUS());
				
				if(!PT_IL_POLICY_BEAN.getPOL_STATUS().equalsIgnoreCase("r"))
				
				{
				setListUI_REPORT_TYPE(CommonReportAction.getDropDownListValue_1(
						connection,
						PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(),
						reportType,PRINT_BEAN.getUI_M_POL_ENDT(),prod_value,null,null,null));
				}
				else
				{
					setListUI_REPORT_TYPE(CommonReportAction.getDropDownListValue_1(
							connection,
							PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(),
							reportType,PT_IL_POLICY_BEAN.getPOL_STATUS(),prod_value,null,null,null));
				}
				
				
				/*End*/
				
			}
			/*commented by gopi for ssp call id ZBILQC-1732718 on 24/07/17*/
			/*if(getUI_REPORT_TYPE()==null){
				setUI_REPORT_TYPE("IPL");
			}*/
			//end


		}

		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	/*end*/

	/*Added by Janani for dynamic report config on 30.8.2016*/

	String Prod_code=null;
	public String Prod_code() throws Exception
	{

		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		String POL_APPRV_STATUS=null;

		CRUDHandler handler = new CRUDHandler();	
		String pol_sys_is=CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID");


		String query ="SELECT POL_SYS_ID, POL_NO, POL_PROD_CODE, PROD_DESC,POAC_COVER_CODE, COVER_LONG_DESC FROM PT_IL_POLICY, PT_IL_POL_ADDL_COVER, PM_IL_PRODUCT, PM_IL_COVER WHERE POAC_POL_SYS_ID=POL_SYS_ID AND POL_PROD_CODE=PROD_CODE AND POAC_COVER_CODE=COVER_CODE AND POL_SYS_ID='"+pol_sys_is+"'";



		resultSet = new CRUDHandler().executeSelectStatement(query, connection);

		while (resultSet.next()) {

			Prod_code=resultSet.getString("POL_PROD_CODE");

			list1.add(Prod_code);
			System.out.println("list size"+list1.size()); 

		}
		return Prod_code;	
	}


	/*end*/


	/*added by Ram on 30.8.2016 for dynamic report config*/

	public static Object setvaluesintoRepInfoBean(
			IP_REP_INFO ob, String value,
			String methodName) throws Exception {

		Class cls = ob.getClass();

		for (Method method : cls.getMethods()) {
			if ((method.getName()) != null) {
				String setMethodName = methodName;

				if ((method.getName().equals(setMethodName))) {


					try {
						System.out.println("setMethodName       "+setMethodName);
						method.setAccessible(true);

						method.invoke(ob, value);

					} catch (Exception e) {
						System.err.println("Error Occured in setvaluesintoBean "+e.getMessage());
					}

				}
			}
		}

		return ob;
	}

	/*end*/
	
	/*Added by Ganesh on 02/03/2017 for other than mail we need to set "view"*/
	public String callReportModalPanel(){
		
		CommonUtils.setGlobalVariable("reporttype","view");
		
		return super.callReportModalPanel();
		
	}
	//end

	public String Decimal_Convert(String Value)
	{
		
		System.out.println(" Decimal_Convert  value  :  "+Value);
		if(Value != null && Double.parseDouble(Value)>0)
		{
			 
			int decimalPlaces=3;
			 

			
			BigDecimal bd = new BigDecimal(Value);
			bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);

			return bd.toString();
		}
		else
		{
			
			return "0.000";
		}
		
	}
	
	//Added by ganesh on 12-05-2017 for multiple report display
	
	/*Added by saranya on 26-04-2017 for Hands on point*/
	public String Alternate_Rep_ID;
	
	public String Multiple_Rep_ID;
	
	public String mailAttachReq;
	
	public String getMailAttachReq() {
		return mailAttachReq;
	}
	public void setMailAttachReq(String mailAttachReq) {
		this.mailAttachReq = mailAttachReq;
	}
	public String getMultiple_Rep_ID() {
		return Multiple_Rep_ID;
	}
	public void setMultiple_Rep_ID(String multiple_Rep_ID) {
		Multiple_Rep_ID = multiple_Rep_ID;
	}
	public String getAlternate_Rep_ID() {
		return Alternate_Rep_ID;
	}
	
	public void setAlternate_Rep_ID(String alternate_Rep_ID) {
		Alternate_Rep_ID = alternate_Rep_ID;
	}
	
	public void Alternate_Rep_ID() throws SQLException{
		Connection connection = null;
		String Alt_Rep_ID=null;
		String Multi_Rep_ID=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String Query="SELECT PMRTH_PRNT_ALT_REP_ID FROM pm_rep_tab_hdr WHERE PMRTH_REP_ID = ?";
			String Query1="SELECT PMRTH_MULTIPLE_REPORT_NAMES FROM pm_rep_tab_hdr WHERE PMRTH_REP_ID = ?";
			
			System.out.println("UI_REPORT_TYPE()  :"+compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE());
			ResultSet rs2 = new CRUDHandler().executeSelectStatement(Query, connection,new Object[]{compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE()});
			while(rs2.next())
			{
				Alt_Rep_ID=rs2.getString("PMRTH_PRNT_ALT_REP_ID");
			}
			setAlternate_Rep_ID(Alt_Rep_ID);
			ResultSet rs = new CRUDHandler().executeSelectStatement(Query1, connection,new Object[]{getAlternate_Rep_ID()});
			while(rs.next())
			{
				Multi_Rep_ID=rs.getString("PMRTH_MULTIPLE_REPORT_NAMES");
			}
			setMultiple_Rep_ID(Multi_Rep_ID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void attachReq() throws SQLException{
		Connection connection = null;
		String mailAttach=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			String Query="SELECT PMRTH_MAIL_ATTACH_REQD,pmrth_mail_template_type FROM PM_REP_TAB_HDR WHERE PMRTH_REP_ID = ?";
			System.out.println("UI_REPORT_TYPE()  :"+compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE());
			ResultSet rs2 = new CRUDHandler().executeSelectStatement(Query, 
					connection,new Object[]{compositeAction.getPRINT_ACTION_BEAN().getUI_REPORT_TYPE()});
			while(rs2.next())
			{
				mailAttach=rs2.getString("PMRTH_MAIL_ATTACH_REQD");
				setEmailTemplateType(rs2.getString("pmrth_mail_template_type"));
			}
			setMailAttachReq(mailAttach);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	private String emailTemplateType;


	public String getEmailTemplateType() {
		return emailTemplateType;
	}
	public void setEmailTemplateType(String emailTemplateType) {
		this.emailTemplateType = emailTemplateType;
	}

	/*End*/

	/*added by gopi for ssp call id ZBILQC-1731299 on 13/07/17*/
	 public String Get_cover_code()
			 throws Exception {
		 /*added by gopi for ssp call id ZBILQC-1732718 on 24/07/17*/
		 Connection connection = null;	
		 //end
		 ResultSet resultSet = null;
		 String Cover_code = null;
		 String query ="SELECT COVER_CODE FROM PT_IL_POL_ADDL_COVER,PM_IL_COVER WHERE COVER_CLASS ='W'"
		 		+ "AND POAC_COVER_CODE = COVER_CODE AND POAC_POL_SYS_ID =?";
		 try {
			 connection = CommonUtils.getConnection();
			 resultSet = new CRUDHandler().executeSelectStatement(query,
					 connection, new Object[] {PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			 if (resultSet.next()) {
				 Cover_code = resultSet.getString("COVER_CODE");
			 }
		 }  catch (Exception e) {
			 e.printStackTrace();
			 throw e;
		 } 
		 return Cover_code;
	 }
	
	/*end*/	
	 
	 /*added by gopi for lisitng report type based on endorsement no on 17/04/2018*/
	 public String Get_End_code() throws Exception {
		 /*added by gopi for ssp call id ZBILQC-1732718 on 24/07/17*/
		 Connection connection = null;	
		 //end
		 ResultSet resultSet = null;
		 String end_code = null;
		 String query ="SELECT POLH_O_END_CODE AS END_CODE FROM PH_IL_POLICY WHERE POLH_SYS_ID =? AND POLH_END_NO_IDX =? "
		 		+ "UNION SELECT POL_END_CODE AS END_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID =? AND POL_END_NO_IDX = ?";
		 try {
			 connection = CommonUtils.getConnection();
			 resultSet = new CRUDHandler().executeSelectStatement(query,
					 connection, new Object[] {PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
					 compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue(),PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
					 compositeAction.getPRINT_ACTION_BEAN().PRINT_BEAN.getList_vaue()});
			 if (resultSet.next()) {
				 end_code = resultSet.getString("END_CODE");
			 }
		 }  catch (Exception e) {
			 e.printStackTrace();
			 throw e;
		 } 
		 return end_code;
	 }
	
	 
	 public void validator_Alteration(FacesContext context,
				UIComponent component, Object value) {
			 PT_IL_POLICY PT_IL_POLICY_BEAN = PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			try {
				System.out.println("*********** Enter the validatorQUESTIONNAIRE_TYPE *************");
				
				setList_vaue((String)value);
				System.out.println("getUI_M_POL_ENDT IN validatorM_POL_END : "+getUI_M_POL_ENDT());


				String reportType = (session.getAttribute("POL_DS_TYPE").toString().equals("1") ? "PRO" : "POL");

				String prod_value=session.getAttribute("POL_PROD_CODE").toString();

				System.out.println("ScheduleReportType             :"+ScheduleReportType);
				
				System.out.println("POL_APPRV_STATUS    "+PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS() +"    reportType      "+reportType+ "    UI_M_POL_ENDT      "+getUI_M_POL_ENDT()+"       prod_value        " +
						prod_value+"    POL_ADDL_STATUS        "+PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS()+"    selectpolstatus       "+selectpolstatus());
				
			/*	if(ScheduleReportType.equalsIgnoreCase("2"))
				{*/
						String Cover_code=Get_cover_code();
						
						String Get_End_code= Get_End_code();
						
						setListUI_REPORT_TYPE(getDropDownListValue_1(
								CommonUtils.getConnection(),
								PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(),
								reportType,getUI_M_POL_ENDT(),prod_value,PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS(),Cover_code,Get_End_code));
					//	COMP_UI_SCHEDULE_TYPE.resetValue();
		
				/*}else{
					System.out.println("ScheduleReportType is 1 (jasper)");
					setListUI_REPORT_TYPE(getDropDownListValue_1(
							CommonUtils.getConnection(),
							PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(),
							reportType,value.toString(),prod_value,null,null,null));	
				}*/
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	/*end*/	
	 
	 /*added by gopi for toi on 26/05/2018*/
		public String getPolicyApprove() {

			 String Policy_approve = null;
			 Connection connection = null;
			 ResultSet rs = null;
			String query="SELECT PROD_POL_APPROVAL_YN FROM PM_IL_PRODUCT WHERE PROD_CODE=? ";	
				try {
				String prod_value=session.getAttribute("POL_PROD_CODE").toString();
				 connection = CommonUtils.getConnection();
				 rs = new CRUDHandler().executeSelectStatement(query, connection,
						 new Object[] { prod_value});
				 if(rs.next()) {
					 Policy_approve = rs.getString(1);
				 }
				
				} catch (Exception e) {
				 e.printStackTrace();
			 } 
			 return Policy_approve;
		 }
		
		
		
		public static List<SelectItem> getDropDownListValue_2(Connection connection)
		{
			
			List<SelectItem> listValues = null;
			String query = "SELECT LIV_CODE,LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = 'QUOT_POL' ORDER BY LIV_CODE DESC" ;
			CRUDHandler handler = null;
				try {
					handler = new CRUDHandler();
					ResultSet rst = handler.executeSelectStatement(query, connection);
					listValues = new ArrayList<SelectItem>();
					while(rst.next()){
						listValues.add(new SelectItem(rst.getString("LIV_CODE"),rst.getString("LIV_CODE_DESC")));
					}
					rst.close();
					rst.getStatement().close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			return listValues;
		}
		
		//end
		
		
		/*added by gopinfor toi on 26/05/2018*/
		public String getBeneficiary_as_customer() {

			 String Benef_cust_flag = null;
			 Connection connection = null;
			 ResultSet rs = null;
			String query="SELECT PROD_BENF_AS_CUST_YN FROM PM_IL_PRODUCT WHERE PROD_CODE=? ";	
				try {
			
				 connection = CommonUtils.getConnection();
				 rs = new CRUDHandler().executeSelectStatement(query, connection,
						 new Object[] { PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()});
				 if(rs.next()) {
					 Benef_cust_flag = rs.getString(1);
				 }
				
				} catch (Exception e) {
				 e.printStackTrace();
			 } 
			 return Benef_cust_flag;
		 }
		
		
		
		public String checkingPolicyisAvialable() {

			 String VALUE = null;
			 Connection connection = null;
			 ResultSet rs = null;
			 Long pol_sys_id=null;
			String query="SELECT 'X' FROM PT_IL_POLICY WHERE POL_STATUS = 'A' AND POL_ADDL_STATUS = 'I00' AND POL_SYS_ID =?";	
				try {
			
				 connection = CommonUtils.getConnection();
				 String pol_addl_status=PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ADDL_STATUS();
				 String pol_status=PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS();
				 if(pol_addl_status!=null && "001".equalsIgnoreCase(pol_addl_status)){
					 if(pol_status!=null &&"N".equalsIgnoreCase(pol_status)){
					 pol_sys_id=PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
					 }
				 }else if(pol_addl_status!=null && "C01".equalsIgnoreCase(pol_addl_status)){
					 if(pol_status!=null &&"A".equalsIgnoreCase(pol_status)){
					 pol_sys_id=getPolicynumber();
					 }
				 }else if(pol_addl_status!=null && "I00".equalsIgnoreCase(pol_addl_status)){
					 if(pol_status!=null &&"A".equalsIgnoreCase(pol_status)){
						 pol_sys_id=PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
						 } 
				 }
				 rs = new CRUDHandler().executeSelectStatement(query, connection,
						 new Object[] {pol_sys_id});
				 if(rs.next()) {
					 VALUE = rs.getString(1);
				 }
				
				} catch (Exception e) {
				 e.printStackTrace();
			 } 
			 return VALUE;
		 }
		
		
		public Long getPolicynumber() {

			 Long Policy_sysid = null;
			 Connection connection = null;
			 ResultSet rs = null;
			String query="SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_PROP_NO=?";	
				try {
			
				 connection = CommonUtils.getConnection();
				 rs = new CRUDHandler().executeSelectStatement(query, connection,
						 new Object[] { PILT002_compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
				 if(rs.next()) {
					 Policy_sysid = rs.getLong("POL_SYS_ID");
				 }
				
				} catch (Exception e) {
				 e.printStackTrace();
			 } 
			 return Policy_sysid;
		 }
			
		//end
	}
		
	
	 
	 

