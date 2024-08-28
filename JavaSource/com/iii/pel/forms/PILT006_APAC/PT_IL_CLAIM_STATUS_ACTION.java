package com.iii.pel.forms.PILT006_APAC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

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
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_CLAIM_STATUS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CS_STATUS_DT_LABEL;

	private HtmlCalendar COMP_CS_STATUS_DT;

	private HtmlOutputLabel COMP_CS_STATUS_CODE_LABEL;

	private HtmlInputText COMP_CS_STATUS_CODE;

	private HtmlOutputLabel COMP_UI_M_CS_STATUS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CS_STATUS_CODE_DESC;

	private HtmlOutputLabel COMP_CS_REASON_CODE_LABEL;

	private HtmlInputText COMP_CS_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_REASON_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_REASON_CODE_DESC;

	private HtmlOutputLabel COMP_CS_REMARKS_LABEL;

	private HtmlInputText COMP_CS_REMARKS;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_STATUS_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_OK;
	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private PT_IL_CLAIM_STATUS PT_IL_CLAIM_STATUS_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_CLAIM_STATUS_HELPER helper;
	
	//Added by ganesh on 16-03-2017, to set flag for check approval or not for mail purpose
		private boolean chkApproval;

		public boolean isChkApproval() {
			return chkApproval;
		}
		public void setChkApproval(boolean chkApproval) {
			this.chkApproval = chkApproval;
		}
		//end

	public PT_IL_CLAIM_STATUS_ACTION() {

		PT_IL_CLAIM_STATUS_BEAN = new PT_IL_CLAIM_STATUS();
		helper = new PT_IL_CLAIM_STATUS_HELPER();
		
		instantiateAllComponent();
	}

	public PT_IL_CLAIM_STATUS getPT_IL_CLAIM_STATUS_BEAN() {
		return PT_IL_CLAIM_STATUS_BEAN;
	}

	public void setPT_IL_CLAIM_STATUS_BEAN(
			PT_IL_CLAIM_STATUS PT_IL_CLAIM_STATUS_BEAN) {
		this.PT_IL_CLAIM_STATUS_BEAN = PT_IL_CLAIM_STATUS_BEAN;
	}

	public void saveRecord() {
		try {
			if (getPT_IL_CLAIM_STATUS_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getPT_IL_CLAIM_STATUS_BEAN(),
						CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getPT_IL_CLAIM_STATUS_BEAN(),
						CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlOutputLabel getCOMP_CS_STATUS_DT_LABEL() {
		return COMP_CS_STATUS_DT_LABEL;
	}

	public void setCOMP_CS_STATUS_DT_LABEL(HtmlOutputLabel comp_cs_status_dt_label) {
		COMP_CS_STATUS_DT_LABEL = comp_cs_status_dt_label;
	}

	public HtmlCalendar getCOMP_CS_STATUS_DT() {
		return COMP_CS_STATUS_DT;
	}

	public void setCOMP_CS_STATUS_DT(HtmlCalendar comp_cs_status_dt) {
		COMP_CS_STATUS_DT = comp_cs_status_dt;
	}

	public HtmlOutputLabel getCOMP_CS_STATUS_CODE_LABEL() {
		return COMP_CS_STATUS_CODE_LABEL;
	}

	public void setCOMP_CS_STATUS_CODE_LABEL(
			HtmlOutputLabel comp_cs_status_code_label) {
		COMP_CS_STATUS_CODE_LABEL = comp_cs_status_code_label;
	}

	public HtmlInputText getCOMP_CS_STATUS_CODE() {
		return COMP_CS_STATUS_CODE;
	}

	public void setCOMP_CS_STATUS_CODE(HtmlInputText comp_cs_status_code) {
		COMP_CS_STATUS_CODE = comp_cs_status_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_CS_STATUS_CODE_DESC_LABEL() {
		return COMP_UI_M_CS_STATUS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CS_STATUS_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_cs_status_code_desc_label) {
		COMP_UI_M_CS_STATUS_CODE_DESC_LABEL = comp_ui_m_cs_status_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_CS_STATUS_CODE_DESC() {
		return COMP_UI_M_CS_STATUS_CODE_DESC;
	}

	public void setCOMP_UI_M_CS_STATUS_CODE_DESC(
			HtmlInputText comp_ui_m_cs_status_code_desc) {
		COMP_UI_M_CS_STATUS_CODE_DESC = comp_ui_m_cs_status_code_desc;
	}

	public HtmlOutputLabel getCOMP_CS_REASON_CODE_LABEL() {
		return COMP_CS_REASON_CODE_LABEL;
	}

	public void setCOMP_CS_REASON_CODE_LABEL(
			HtmlOutputLabel comp_cs_reason_code_label) {
		COMP_CS_REASON_CODE_LABEL = comp_cs_reason_code_label;
	}

	public HtmlInputText getCOMP_CS_REASON_CODE() {
		return COMP_CS_REASON_CODE;
	}

	public void setCOMP_CS_REASON_CODE(HtmlInputText comp_cs_reason_code) {
		COMP_CS_REASON_CODE = comp_cs_reason_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_REASON_CODE_DESC_LABEL() {
		return COMP_UI_M_REASON_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_reason_code_desc_label) {
		COMP_UI_M_REASON_CODE_DESC_LABEL = comp_ui_m_reason_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_REASON_CODE_DESC() {
		return COMP_UI_M_REASON_CODE_DESC;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC(
			HtmlInputText comp_ui_m_reason_code_desc) {
		COMP_UI_M_REASON_CODE_DESC = comp_ui_m_reason_code_desc;
	}

	public HtmlOutputLabel getCOMP_CS_REMARKS_LABEL() {
		return COMP_CS_REMARKS_LABEL;
	}

	public void setCOMP_CS_REMARKS_LABEL(HtmlOutputLabel comp_cs_remarks_label) {
		COMP_CS_REMARKS_LABEL = comp_cs_remarks_label;
	}

	public HtmlInputText getCOMP_CS_REMARKS() {
		return COMP_CS_REMARKS;
	}

	public void setCOMP_CS_REMARKS(HtmlInputText comp_cs_remarks) {
		COMP_CS_REMARKS = comp_cs_remarks;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_STATUS_CODE() {
		return COMP_UI_M_BUT_LOV_STATUS_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_STATUS_CODE(
			HtmlCommandButton comp_ui_m_but_lov_status_code) {
		COMP_UI_M_BUT_LOV_STATUS_CODE = comp_ui_m_but_lov_status_code;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton comp_ui_m_but_ok) {
		COMP_UI_M_BUT_OK = comp_ui_m_but_ok;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton comp_ui_m_but_cancel) {
		COMP_UI_M_BUT_CANCEL = comp_ui_m_but_cancel;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				
				/*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1731636*/
				COMP_CONTEST_PERIOD_MODAL_PANEL.setShowWhenRendered(false);
				/*End*/
				
				//helper.executeQuery(compositeAction);
				//added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions
				PT_IL_CLAIM_STATUS_BEAN = new PT_IL_CLAIM_STATUS();
				instantiateAllComponent();
				PT_IL_CLAIM_STATUS_BEAN.setCS_STATUS_DT(new CommonUtils().getCurrentDate());
				System.out.println("*******date value**"+PT_IL_CLAIM_STATUS_BEAN.getCS_STATUS_DT());
				//end
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void validateCS_STATUS_CODE(FacesContext context, UIComponent component, Object value){
		
	/*Added by Janani for ZBILQC-1727297 on 25.05.2017*/
		
		String CCD_FRZ_FLAG = null;
		String CCD_CONFIRM_FLAG = null;
		
		/*End*/
		
		try {
			
			/*added by raja on 13-05-2017*/
			String status=(String) value;
			if(status!=null && status.equalsIgnoreCase("D05"))
					{
						accessValidation();
					}
			/*end*/
			
			/*added by raja on 05-07-2017 for */
			
			/*if(status!=null && status.equalsIgnoreCase("CL06"))
			{
				 String flag=null;
					flag=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().validate_asd_char_value_flag();
					if(!flag.equalsIgnoreCase("Y"))
					{
						throw new Exception("User not authorized to change teh Status CL06");
					}
					
			}*/
			
			/*end*/
			/*changed by raja on 10-07-2017 for ZBILQC-1730674*/
			String selectStatement = "SELECT CS_STATUS_CODE FROM PT_IL_CLAIM_STATUS WHERE " +
					"CS_TYPE = 'S' AND CS_CLM_SYS_ID = ?";

String previousStatus=null;
			Connection connection = null;
					ResultSet resultSet = null;

			connection = CommonUtils.getConnection();

			resultSet = new CRUDHandler().executeSelectStatement(
								selectStatement, connection,
								new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
					while(resultSet.next())
					{
						previousStatus=resultSet.getString("CS_STATUS_CODE");
						
					}
			
			if(previousStatus!=null && previousStatus.equalsIgnoreCase("CL06"))
			{
				if(value!=null && value.toString().equalsIgnoreCase("CL05"))
				{
					validate_asd_char_value_flag();
				}
			}
			
			/*end*/
			
			/*added by raja on 12-08-2017 for ZBILQC-1727297*/
			
			/*if(value!=null && value.toString().equalsIgnoreCase("CL05"))
			{
				if(CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG(), "N").equalsIgnoreCase("N") ||
						CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_CONFIRM_FLAG(), "N").equalsIgnoreCase("N"))
				{
					throw new Exception("Cannot approve the claim as before the claim is freeze and conform");
				}
				
			}*/
			/*end*/
			
			PT_IL_CLAIM_STATUS_BEAN.setCS_STATUS_CODE((String) value);
			helper.validateCS_STATUS_CODE(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(), 
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(), 
					PT_IL_CLAIM_STATUS_BEAN);
			
/*Added by Janani for ZBILQC-1727297 on 25.05.2017*/
			
			System.out.println("value           "+value);
			System.out.println("getCCD_FRZ_FLAG           "+compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG());
			System.out.println("getCCD_CONFIRM_FLAG           "+compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_CONFIRM_FLAG());
			
		
			
			CCD_FRZ_FLAG = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG();
			CCD_CONFIRM_FLAG = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_CONFIRM_FLAG();
			
		if(CCD_FRZ_FLAG != null && CCD_CONFIRM_FLAG != null){
			if(value.equals("CL05") && (CCD_FRZ_FLAG.equalsIgnoreCase("n") && CCD_CONFIRM_FLAG.equalsIgnoreCase("n")) ||
					value.equals("CL05") && (CCD_FRZ_FLAG.equalsIgnoreCase("y") && CCD_CONFIRM_FLAG.equalsIgnoreCase("n")) ||
							value.equals("CL05") && (CCD_FRZ_FLAG.equalsIgnoreCase("n") && CCD_CONFIRM_FLAG.equalsIgnoreCase("y")))
			{
				System.out.println("claim status is CL05");
				
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "2311"));
				
			}
		}
			
			
			/*End*/
			
			
			
			
			COMP_UI_M_CS_STATUS_CODE_DESC.setSubmittedValue(PT_IL_CLAIM_STATUS_BEAN.getUI_M_CS_STATUS_CODE_DESC());
			//added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions
			COMP_CS_STATUS_CODE.resetValue();
			COMP_UI_M_CS_STATUS_CODE_DESC.resetValue();
			//end
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCS_REASON_CODE(FacesContext context, UIComponent component, Object value){
		
		try {
			PT_IL_CLAIM_STATUS_BEAN.setCS_REASON_CODE((String) value);
			helper.validateCS_REASON_CODE(PT_IL_CLAIM_STATUS_BEAN);
			COMP_UI_M_REASON_CODE_DESC.setSubmittedValue(PT_IL_CLAIM_STATUS_BEAN.getUI_M_REASON_CODE_DESC());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public ArrayList<LovBean> CS_STATUS_CODEsuggestions(Object value){
		ArrayList<LovBean> suggestions = new ArrayList<LovBean>();
		
		try {
			suggestions =  new ListItemUtil().P_CALL_LOV("PILT006_APAC", 
					"PT_IL_CLAIM_STATUS", 
					"CS_STATUS_CODE", 
					"IL_ADDL_STAT", 
					"4", 
					null, 
					null, 
					null, 
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
		
		return suggestions;
	}
	
	public ArrayList<LovBean> CS_REASON_CODEsuggestions(Object value){
		ArrayList<LovBean> suggestions = new ArrayList<LovBean>();
		
		try {
			suggestions =  new ListItemUtil().P_CALL_LOV("PILT006_APAC", 
					"PT_IL_CLAIM_STATUS", 
					"CS_REASON_CODE", 
					"IL_REASON", 
					null, 
					null, 
					null, 
					null, 
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
		
		return suggestions;
	}
	
	/**
	 * Instantiates all components in PT_IL_CLAIM_STATUS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CS_STATUS_CODE				 = new HtmlInputText();
		COMP_UI_M_CS_STATUS_CODE_DESC			 = new HtmlInputText();
		COMP_CS_REASON_CODE				 = new HtmlInputText();
		COMP_UI_M_REASON_CODE_DESC			 = new HtmlInputText();
		COMP_CS_REMARKS					 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_CS_STATUS_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_LOV_STATUS_CODE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_OK				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CANCEL				 = new HtmlCommandButton();

	}

	/**
	 * Resets all components in PT_IL_CLAIM_STATUS_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_CS_STATUS_CODE.resetValue();
		COMP_UI_M_CS_STATUS_CODE_DESC.resetValue();
		COMP_CS_REASON_CODE.resetValue();
		COMP_UI_M_REASON_CODE_DESC.resetValue();
		COMP_CS_REMARKS.resetValue();

		// Reseting HtmlCalendar
		COMP_CS_STATUS_DT.resetValue();
	}

	/**
	 * Disables all components in PT_IL_CLAIM_STATUS_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_CS_STATUS_CODE.setDisabled(disabled);
		COMP_UI_M_CS_STATUS_CODE_DESC.setDisabled(disabled);
		COMP_CS_REASON_CODE.setDisabled(disabled);
		COMP_UI_M_REASON_CODE_DESC.setDisabled(disabled);
		COMP_CS_REMARKS.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_CS_STATUS_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		/*COMP_UI_M_BUT_LOV_STATUS_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_OK.setDisabled(disabled);
		COMP_UI_M_BUT_CANCEL.setDisabled(disabled);*/

	}
	
	public String WBP_UI_M_BUT_CANCEL(){
		String outcome = null;
		
		//PT_IL_CLAIM_STATUS_BEAN.setCS_STATUS_CODE(null);
		PT_IL_CLAIM_STATUS_BEAN = new PT_IL_CLAIM_STATUS();
		setBlockFlag(true);
		/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
		compositeAction.getPT_IL_CLAIM_ACTION_BEAN().setBlockFlag(true);
		COMP_CS_STATUS_CODE.resetValue();
		COMP_UI_M_CS_STATUS_CODE_DESC.resetValue();
		//end
		outcome = "claimsEntry";
		
		return outcome;
	}
	
	public String WBP_UI_M_BUT_OK(){
		String outcome = null;
		
		try {
			//Added by ganesh on 16-03-2017, to set flag for check approval or not for mail purpose
			setChkApproval(true);
			//end
			/*Added by saritha on 05-Mar-2017 for ssp call id ZBILQC-1719135*/
			System.out.println("enters into WBP_UI_M_BUT_OK");
			helper.PRE_UPDATE(compositeAction);
			/*End*/
			outcome = helper.WBP_UI_M_BUT_OK(compositeAction);
			
			/* Commented by gopi for claim report 
			//Added by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.
			compositeAction.getPILT006_APAC_PRINT_ACTION_BEAN().runAction();
			compositeAction.getPILT006_APAC_PRINT_ACTION_BEAN().runActionAfterValidate();
			
			String emailStatusMessage = sendPostRequest(compositeAction.getPILT006_APAC_PRINT_ACTION_BEAN().getRedirectUrl());					
				
			
			System.out.println("message ============>>>>>>>>>>" + emailStatusMessage);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					emailStatusMessage);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					emailStatusMessage);
			//end	
			end*/
			//Newly added by pidugu raj dt: 03-12-2020 as suggested by kuzhandaivel
			if(compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getPT_IL_CLAIM_STATUS_BEAN().getCS_STATUS_CODE().equalsIgnoreCase("CL05")){
				String polSysID = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID().toString();
				String prodCode = getProdCode(polSysID);
							
				String emailStatusMessage = null;
				emailStatusMessage = Email_Procedure_Call.emailStatusMsg(prodCode,
						"CLM", polSysID, "U", "");
				
				
				System.out.println("message ============>>>>>>>>>>" + emailStatusMessage);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						emailStatusMessage);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
						emailStatusMessage);
			}
			//End
			/*added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions*/
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().setBlockFlag(true);
			//end
			
			
			/* Newly Added By Dhinesh on 6-9-2017 for ssp : */
			
			if(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().checkwopCount(compositeAction)>=2 && "CL05".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getPT_IL_CLAIM_STATUS_BEAN().getCS_STATUS_CODE()))
			{
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().freezeButtonPressed_WOP();
			}
			/* End */
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("OKBUTTON", e.getMessage());
			
		}
		
		return outcome;
	}

	//Added by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.
	
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
				
				String polSysID = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID().toString();
				String prodCode = getProdCode(polSysID);
							
				String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(prodCode, "CSTS", polSysID, "C", outPutFileName.toString());
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
		
		
		//end
		
		/*added by raja on 25-04-2017*/
		public void accessValidation() throws Exception
		{
			try
			{
				int shareRatioSystemParam =0;	
				String flag=null;
			/*int shareRatioSystemParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("MED_EXAM_INS")).intValue();
			if(shareRatioSystemParam == 2){*/
			String query="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_CODE='MOD_EXCL_CLM'";
			ResultSet rs =new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
			while(rs.next())
			{
				shareRatioSystemParam=rs.getInt("PS_VALUE");
			}
			if(shareRatioSystemParam == 2){
				Map<String, Object> session = FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap();

				String userID=session.get("GLOBAL.M_USER_ID").toString();
				String queryUserApprSetup="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET TAB1 WHERE "
						+ "ASD_FLAG = '2' AND ASD_CODE='MOD_EXCL_CLM' AND "
						+ "ASD_USER_ID = ? AND ASD_FM_PROD_CODE = ? AND "
						+ "ASD_TO_PROD_CODE = ?";
				
				ResultSet UserApprSetup=new CRUDHandler().executeSelectStatement(queryUserApprSetup, CommonUtils.getConnection(), new Object[]{userID,
					getPROD_CODE(),
					getPROD_CODE()});
				
				while(UserApprSetup.next())
				{
					flag=UserApprSetup.getString("ASD_CHAR_VALUE");
				}
				
				if(flag!=null && flag.equalsIgnoreCase("N"))
				{
					throw new Exception("User not authorized");
				}
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		public String getPROD_CODE()
		{
			String plantype=null;
			try{
				
			String query="SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID="+compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()+"";
			ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
			while(resultset.next())
			{
				plantype=resultset.getString("POL_PROD_CODE");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return plantype;
			
		}
		
		/*end*/
		
		/*changed by raja on 10-07-2017 for ZBILQC-1730674*/
		 public void validate_asd_char_value_flag()
					throws Exception {
			  System.out.println("*******enter into validate_asd_char_value_flag***");
			
				String C1 ="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID =? "
						+ "AND ASD_CODE = 'CLM_EXGR_APR' AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
				ResultSet C1_REC = null;
				String CHECK_CODE=null;
				try {
					Connection connection = CommonUtils.getConnection();
					CRUDHandler handler = new CRUDHandler();
					String productCode=getprod_code();
					C1_REC = handler.executeSelectStatement(C1, connection,
							new Object[] {CommonUtils.getControlBean().getUSER_ID(),productCode});
					if (C1_REC.next()) {
						CHECK_CODE =C1_REC.getString(1);//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN()
						System.out.println("**************value of CHECK_CODE***"+CHECK_CODE);
					}
					if(CHECK_CODE!=null && CHECK_CODE.equalsIgnoreCase("N"))
					{
						throw new Exception("User is not authorized to Approve Claim Ex-Gratia");
					}
					
					} catch (SQLException e) {
					throw new Exception(e.getMessage());
				} 
				
				
				
			}
		 
		 public String getprod_code()
					throws Exception {
			  System.out.println("*******enter into getprod_code***");
			
				String C1 ="select pol_prod_code from pt_il_policy where pol_no=?";
				ResultSet C1_REC = null;
				String product_code=null;
				try {
					Connection connection = CommonUtils.getConnection();
					CRUDHandler handler = new CRUDHandler();
					C1_REC = handler.executeSelectStatement(C1, connection,
							new Object[] {compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()});
					if (C1_REC.next()) {
						product_code =C1_REC.getString(1);
					}
					} catch (SQLException e) {
					throw new Exception(e.getMessage());
				} 
				System.out.println("**************value of product_code***"+product_code);
				return product_code;
				
			}
		 
		 /*end*/
		 
		 
		 /*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1731636*/
		 private HtmlModalPanel COMP_CONTEST_PERIOD_MODAL_PANEL;

		 public HtmlModalPanel getCOMP_CONTEST_PERIOD_MODAL_PANEL() {
			 return COMP_CONTEST_PERIOD_MODAL_PANEL;
		 }
		 public void setCOMP_CONTEST_PERIOD_MODAL_PANEL(
				 HtmlModalPanel cOMP_CONTEST_PERIOD_MODAL_PANEL) {
			 COMP_CONTEST_PERIOD_MODAL_PANEL = cOMP_CONTEST_PERIOD_MODAL_PANEL;
		 }

		 public void OkModalPanel() throws Exception{
			 System.out.println("enter into the ok model panal");
			 getCOMP_CONTEST_PERIOD_MODAL_PANEL().setShowWhenRendered(false);

		 }
		 
		 public void fireFieldValidationClaimStatus(ActionEvent actionEvent) throws Exception {
			 UIInput input = (UIInput) actionEvent.getComponent().getParent();
			 String value = (String)input.getSubmittedValue();
			 if(value.equalsIgnoreCase("CL05")){

				 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().checkContestabilityPeriod(COMP_CONTEST_PERIOD_MODAL_PANEL);

			 }else{
				 COMP_CONTEST_PERIOD_MODAL_PANEL.setShowWhenRendered(false);
			 }

			 ErrorHelpUtil.validate(input, getErrorMap());
		 }
			
		 /*End*/
			 
}
