package com.iii.pel.forms.PILP004;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.premia.common.utils.ReportUtils;

public class MATURITY_ACTION extends CommonAction {

	private static final String String = null;

	private HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_FM;

	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_TO;

	private HtmlOutputLabel COMP_UI_M_POL_DT_FM_LABEL;

	private HtmlCalendar COMP_UI_M_POL_DT_FM;

	private HtmlOutputLabel COMP_UI_M_POL_DT_TO_LABEL;

	private HtmlCalendar COMP_UI_M_POL_DT_TO;

	private HtmlCommandButton COMP_UI_M_LOV_POL_TO;

	private HtmlCommandButton COMP_UI_M_COPY_CANCEL;

	private HtmlCommandButton COMP_UI_M_LOV_POL_FM;

	private HtmlCommandButton COMP_UI_M_COPY_OK;
	
	private HtmlCommandButton COMP_UI_M_PROCESS_LOG;

	private MATURITY MATURITY_BEAN;

	public PILP004_COMPOSITE_ACTION compositeAction;

	private MATURITY_HELPER helper;

	ArrayList<LovBean> lovList = new ArrayList<LovBean>();

	public MATURITY_ACTION() {

		MATURITY_BEAN = new MATURITY();
		helper = new MATURITY_HELPER();
		
		/*added by gopi for maturity notification letter on 11/04/17*/ 
		IP_REP_INFO_BEAN = new IP_REP_INFO();
		COMP_REPORT_MODAL_PANEL = new HtmlModalPanel();
		//end

		
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FM_LABEL() {
		return COMP_UI_M_POL_NO_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_FM() {
		return COMP_UI_M_POL_NO_FM;
	}

	public void setCOMP_UI_M_POL_NO_FM_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL) {
		this.COMP_UI_M_POL_NO_FM_LABEL = COMP_UI_M_POL_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_FM(HtmlInputText COMP_UI_M_POL_NO_FM) {
		this.COMP_UI_M_POL_NO_FM = COMP_UI_M_POL_NO_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}

	public void setCOMP_UI_M_POL_NO_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL) {
		this.COMP_UI_M_POL_NO_TO_LABEL = COMP_UI_M_POL_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText COMP_UI_M_POL_NO_TO) {
		this.COMP_UI_M_POL_NO_TO = COMP_UI_M_POL_NO_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_DT_FM_LABEL() {
		return COMP_UI_M_POL_DT_FM_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_POL_DT_FM() {
		return COMP_UI_M_POL_DT_FM;
	}

	public void setCOMP_UI_M_POL_DT_FM_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_DT_FM_LABEL) {
		this.COMP_UI_M_POL_DT_FM_LABEL = COMP_UI_M_POL_DT_FM_LABEL;
	}

	public void setCOMP_UI_M_POL_DT_FM(HtmlCalendar COMP_UI_M_POL_DT_FM) {
		this.COMP_UI_M_POL_DT_FM = COMP_UI_M_POL_DT_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_DT_TO_LABEL() {
		return COMP_UI_M_POL_DT_TO_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_POL_DT_TO() {
		return COMP_UI_M_POL_DT_TO;
	}

	public void setCOMP_UI_M_POL_DT_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_DT_TO_LABEL) {
		this.COMP_UI_M_POL_DT_TO_LABEL = COMP_UI_M_POL_DT_TO_LABEL;
	}

	public void setCOMP_UI_M_POL_DT_TO(HtmlCalendar COMP_UI_M_POL_DT_TO) {
		this.COMP_UI_M_POL_DT_TO = COMP_UI_M_POL_DT_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_COPY_OK() {
		return COMP_UI_M_COPY_OK;
	}

	public void setCOMP_UI_M_COPY_OK(HtmlCommandButton COMP_UI_M_COPY_OK) {
		this.COMP_UI_M_COPY_OK = COMP_UI_M_COPY_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_COPY_CANCEL() {
		return COMP_UI_M_COPY_CANCEL;
	}

	public void setCOMP_UI_M_COPY_CANCEL(HtmlCommandButton COMP_UI_M_COPY_CANCEL) {
		this.COMP_UI_M_COPY_CANCEL = COMP_UI_M_COPY_CANCEL;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_POL_FM() {
		return COMP_UI_M_LOV_POL_FM;
	}

	public void setCOMP_UI_M_LOV_POL_FM(HtmlCommandButton COMP_UI_M_LOV_POL_FM) {
		this.COMP_UI_M_LOV_POL_FM = COMP_UI_M_LOV_POL_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_POL_TO() {
		return COMP_UI_M_LOV_POL_TO;
	}

	public void setCOMP_UI_M_LOV_POL_TO(HtmlCommandButton COMP_UI_M_LOV_POL_TO) {
		this.COMP_UI_M_LOV_POL_TO = COMP_UI_M_LOV_POL_TO;
	}

	public MATURITY getMATURITY_BEAN() {
		return MATURITY_BEAN;
	}

	public void setMATURITY_BEAN(MATURITY MATURITY_BEAN) {
		this.MATURITY_BEAN = MATURITY_BEAN;
	}

	public void saveRecord() {
		try {
			if (getMATURITY_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getMATURITY_BEAN(), CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Saved SuccessFully");
			} else {
				new CRUDHandler().executeInsert(getMATURITY_BEAN(), CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Saved SuccessFully");
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

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.WHEN_CREATE_RECORD(this.getMATURITY_BEAN());
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void listenerM_POL_NO_FM(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			try {
				if (inputValue.isEmpty()) {
					COMP_UI_M_POL_NO_FM
							.setSubmittedValue(PELConstants.PROCESS_FROMVALUE);
					MATURITY_BEAN.setUI_M_POL_NO_FM(PELConstants.PROCESS_TOVALUE);
				} else {
					MATURITY_BEAN.setUI_M_POL_NO_FM(inputValue);
				}
			}
			
		 catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("M_POL_NO_FM", e.getMessage());
		}
	}

	public void listenerM_POL_NO_TO(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		// ErrorHelpUtil.validate(input, getErrorMap());HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString=(String)input.getSubmittedValue();
		try{
		if(inputTextString == "")
		{
			if(!PELConstants.PROCESS_FROMVALUE.equals(MATURITY_BEAN.getUI_M_POL_NO_FM()))
			{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(MATURITY_BEAN.getUI_M_POL_NO_FM());
				MATURITY_BEAN.setUI_M_POL_NO_TO(MATURITY_BEAN.getUI_M_POL_NO_FM());
			}else{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
				MATURITY_BEAN.setUI_M_POL_NO_TO(PELConstants.PROCESS_TOVALUE);
			}
		}else{
			MATURITY_BEAN.setUI_M_POL_NO_TO(inputTextString);
		}
		/*try {
			MATURITY_BEAN.setUI_M_POL_NO_TO((String) new CommonUtils()
					.SET_REP_SECOND_FIELD(MATURITY_BEAN.getUI_M_POL_NO_FM(),
							input.getSubmittedValue(), "String"));*/
			//input.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("M_POL_NO_FM", e.getMessage());
		}
	}

	public void ValidateM_POL_NO_FM(FacesContext context,UIComponent component, Object value) {
		try {
			String val = (String)value;
			if(!(val.equalsIgnoreCase(MATURITY_BEAN.getUI_M_POL_NO_FM()))){
				helper.chkpolNO((String) value);
				MATURITY_BEAN.setUI_M_POL_NO_FM((String) value);
				helper.WHEN_VALIDATE_M_POL_NO_FM((String) value, MATURITY_BEAN.getUI_M_POL_NO_TO());
				COMP_UI_M_POL_NO_FM.resetValue();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void ValidateM_POL_NO_TO(FacesContext context,
			UIComponent component, Object value) {
		try {
			String val = (String)value;
			if(!(val.equalsIgnoreCase(MATURITY_BEAN.getUI_M_POL_NO_TO()))){
				MATURITY_BEAN.setUI_M_POL_NO_TO((String) value);
				helper.WHEN_VALIDATE_M_POL_NO_TO(MATURITY_BEAN.getUI_M_POL_NO_FM(),
					(String) value);
				COMP_UI_M_POL_NO_TO.resetValue();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void ValidateM_POL_DT_TO(FacesContext context,
			UIComponent component, Object value) {
		try {
			MATURITY_BEAN.setUI_M_POL_DT_TO((Date) value);
			helper.WHEN_VALIDATE_M_POL_DT_TO(MATURITY_BEAN.getUI_M_POL_DT_FM(),
					MATURITY_BEAN.getUI_M_POL_DT_TO());
			COMP_UI_M_POL_DT_TO.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void ValidateM_POL_DT_FM(FacesContext context,
			UIComponent component, Object value) {
		try {
			MATURITY_BEAN.setUI_M_POL_DT_FM((Date) value);
			COMP_UI_M_POL_DT_FM.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public ArrayList<com.iii.premia.common.bean.LovBean> preparePOL_NO_FMLOV(Object value) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILP004", "MATURITY", "M_POL_NO_FM",
					null, null, null, null, null, (String) value);
		//lovList=getPolicyNumber((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	public ArrayList<com.iii.premia.common.bean.LovBean> preparePOL_NO_TOLOV(Object value) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			lovList = listitemutil.P_CALL_LOV("PILP004", "MATURITY", "M_POL_NO_TO",
					null, null, null, null, null, (String) value);
			//lovList=getPolicyNumber((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return lovList;
	}

	public String onClickOK() throws Exception {
		String outcome = null;
		MATURITY maturitybean = compositeAction.getMATURITY_ACTION_BEAN().getMATURITY_BEAN();
		DUMMY dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		
		try {
			Connection connection = null;
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			String product_code=null;
			Long pol_sys_id=null;
			String message = "";
			outcome = helper.WHEN_VALIDATE_ITEM_M_COPY_OK(dummy, this);
			/*Added by saritha on 06-Mar-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
			 email should be sent to finance user.*/
			
			System.out.println("pol no----------"+maturitybean.getUI_M_POL_NO_FM());
			String query ="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
			resultSet = handler.executeSelectStatement(query, connection,new Object[]{ maturitybean.getUI_M_POL_NO_FM()});
			while(resultSet.next()) {
				product_code =resultSet.getString("POL_PROD_CODE");
				pol_sys_id   =resultSet.getLong("POL_SYS_ID");
				System.out.println("product_code--------------"+product_code);
				System.out.println("pol_sys_id----------------"+pol_sys_id);
			}
			String P_CUST_TYPE=" ";
			
			
			/*COMMENTED BY RAJA ON 03-08-2017 FOR ZBILQC-1720015 */
			/*String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(product_code,"MAP",String.valueOf(pol_sys_id),"U","");
			message = message + emailStatusMessage;*/
			/*emailTriggerProcCall();*/
			
			/*END*/
			
			
			/*Commentted &Modified by saritha on 18-09-2017 for ssp call id ZBILQC-1727296*/
			/*getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
					Messages.getString(PELConstants.pelErrorMessagePath, "3206",new Object[]{"Maturity Process Completed"}));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getString(PELConstants.pelErrorMessagePath, "3206",
					new Object[]{"Maturity Process Completed"}));*/
			
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
					Messages.getString(PELConstants.pelErrorMessagePath, "3206",new Object[]{"Process Completed Successfully"}));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getString(PELConstants.pelErrorMessagePath, "3206",
					new Object[]{"Process Completed Successfully"}));
			
			/*End*/	
			
			/*added by gopi for maturity notification letter on 11/04/17*/
			compositeAction.getMATURITY_ACTION_BEAN().getCOMP_PRINT_COMMAND_LINK().setDisabled(false);
			compositeAction.getMATURITY_ACTION_BEAN().getCOMP_PRINT_BUTTON().setDisabled(false);
			//END 

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("COPY_OK", e.getMessage());
		}

		return outcome;
	}
	
	public String success() {
		return "PILP004_CTRL";
	}
	
	public ArrayList<LovBean> getPolicyNumber(String value){
		ArrayList<LovBean> list = new ArrayList<LovBean>();
		Connection connection =null;
		CRUDHandler handler = null;
		LovBean lovBean =null;
		String C1 = "SELECT POL_NO, POL_ASSURED_NAME FROM PT_IL_POLICY WHERE POL_DS_CODE IN (SELECT PLAN_CODE FROM PM_IL_PLAN WHERE PLAN_SA_INST_PYMT_YN='Y'OR PLAN_PYMT_ON_MAT_YN = 'Y')"
			+ "AND POL_DS_TYPE = '2' AND NVL(POL_STATUS, 'X') NOT IN ('S', 'M', 'N', 'D', 'C','L')"
			+ "AND POL_APPRV_STATUS = 'A' AND ROWNUM < 20";
	String C1_APPEND = "SELECT POL_NO,POL_ASSURED_NAME FROM PT_IL_POLICY WHERE POL_DS_CODE IN(SELECT PLAN_CODE FROM PM_IL_PLAN WHERE PLAN_SA_INST_PYMT_YN='Y'OR PLAN_PYMT_ON_MAT_YN = 'Y') AND (POL_NO LIKE ?) AND NVL(POL_STATUS, 'X') NOT IN ('S', 'M', 'N', 'D', 'C','L') AND POL_DS_TYPE = '2' AND POL_APPRV_STATUS = 'A' AND ROWNUM < 20";
		ResultSet C1_REC = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			if("*".equalsIgnoreCase(value)){
				System.out.println("C1"+C1);
				C1_REC = handler.executeSelectStatement(C1, connection);
			}else{
				System.out.println("C1_APPEND"+C1_APPEND);
				C1_REC = handler.executeSelectStatement(C1_APPEND, connection,new Object[]{value + "%"});
			}
			while(C1_REC.next()){
				lovBean = new LovBean();
				lovBean.setCode(C1_REC.getString(1));
				lovBean.setName(C1_REC.getString(2));
				list.add(lovBean);
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public HtmlCommandButton getCOMP_UI_M_PROCESS_LOG() {
		return COMP_UI_M_PROCESS_LOG;
	}

	public void setCOMP_UI_M_PROCESS_LOG(HtmlCommandButton comp_ui_m_process_log) {
		COMP_UI_M_PROCESS_LOG = comp_ui_m_process_log;
	}
	
	/*Added by saritha on 16-Feb-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
	 email should be sent to finance user.
	 *
	 */
	 /*public String emailTriggerProcCall() throws Exception{
		   	String subject="SELECT PMT_PROD_CODE,PMT_MAIL_SUB,PMT_MAIL_TEXT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE = 'MAP'";
		   	String tomail="SELECT USER_EMAIL_ID FROM MENU_USER WHERE USER_GROUP_ID='FINUSER'";
		   	String insert="INSERT INTO PW_LIFE_EMAIL_DATA (PLED_SRNO, PLED_TYPE, PLED_TO, PLED_SUB, PLED_BODY, PLED_STATUS) VALUES (PIL_MAIL_SYS_ID.NEXTVAL,?,?,?,?,?)";
		   	String out="N";
		   	ResultSet rs2=null;
		   	ResultSet rs3=null;
		   
		   	int seqno = 0;
		   	String productcode = null;
		   	String sub = null;
		   	String body = null;
		   	String mailid = null;
		   	Connection con=CommonUtils.getConnection();
		   	System.out.println("Connection :"+con);

		   	rs2=new CRUDHandler().executeSelectStatement(subject, con);
		   	rs3=new CRUDHandler().executeSelectStatement(tomail, con);
		  
		   	if(rs2.next()){
		   		productcode=rs2.getString("PMT_PROD_CODE");
		   		sub=rs2.getString("PMT_MAIL_SUB");
		   		body=rs2.getString("PMT_MAIL_TEXT");
		   	}
		   	if(rs3.next()){
		   		mailid=rs3.getString("USER_EMAIL_ID");
		   		if(mailid!=null){
		   			Object[] values1 = {"MAP",mailid,sub,body,"N" };
				   	new CRUDHandler().executeInsertStatement(insert, con, values1);
				   	con.commit();
		   			
		   		out="Y";
		   		}
		   	}
		   	System.out.println("seqno  :"+seqno);
		   	System.out.println("mailid  :"+mailid);
			System.out.println("sub  :"+sub);
			System.out.println("body  :"+body);
		   	
			return out;
			}*/
	 
	 		/*End*/
	
	/*added by gopi for maturity notification letter on 11/04/17*/ 
	private HtmlCommandLink COMP_PRINT_COMMAND_LINK;
	

	public HtmlCommandLink getCOMP_PRINT_COMMAND_LINK() {
		return COMP_PRINT_COMMAND_LINK;
	}

	public void setCOMP_PRINT_COMMAND_LINK(HtmlCommandLink cOMP_PRINT_COMMAND_LINK) {
		COMP_PRINT_COMMAND_LINK = cOMP_PRINT_COMMAND_LINK;
	}
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL;
	
	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
	}

	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_REPORT_MODAL_PANEL) {
		COMP_REPORT_MODAL_PANEL = cOMP_REPORT_MODAL_PANEL;
	}
	private String redirectUrl;
	
	
	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	private IP_REP_INFO IP_REP_INFO_BEAN;
	
	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO iP_REP_INFO_BEAN) {
		IP_REP_INFO_BEAN = iP_REP_INFO_BEAN;
	}

	private HtmlCommandButton COMP_PRINT_BUTTON;
	
	public HtmlCommandButton getCOMP_PRINT_BUTTON() {
		return COMP_PRINT_BUTTON;
	}

	public void setCOMP_PRINT_BUTTON(HtmlCommandButton cOMP_PRINT_BUTTON) {
		COMP_PRINT_BUTTON = cOMP_PRINT_BUTTON;
	}

	
	private HtmlAjaxCommandButton COMP_CANCEL_BUTTON;
	
	public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON() {
		return COMP_CANCEL_BUTTON;
	}

	public void setCOMP_CANCEL_BUTTON(HtmlAjaxCommandButton cOMP_CANCEL_BUTTON) {
		COMP_CANCEL_BUTTON = cOMP_CANCEL_BUTTON;
	}

	//end
	/*added by gopi for maturity notification letter on 11/04/17*/
	public String callReportModalPanel(){
		runAction();
		System.out.println("redirectURL           "+redirectUrl);
		if(redirectUrl!=null)
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
		else 
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return null;
	}

	public String runAction(){

		Connection runActionConnection = null;


		String url = null;
		String POL_SYS_ID=null;
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		url= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/XDocSchedule?";
		System.out.println("url   :  "+url);
		setRedirectUrl(url);

		try{
			runActionConnection = CommonUtils.getConnection();
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				System.out.println("ENTER IP_REP_INFO_BEAN");

				Connection connection = null;
				ResultSet resultSet = null;
				Object[] values = null;
				POL_SYS_ID =String.valueOf(getPolsysid());
				PRE_INSERT(this.IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setREP_VALUE_1(POL_SYS_ID);
				int recordCount = new CRUDHandler().executeInsert(IP_REP_INFO_BEAN,
						runActionConnection);
				runActionConnection.commit();
			}else {

				PRE_UPDATE(this.IP_REP_INFO_BEAN);
				//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
			}



		}catch(Exception e){
			e.printStackTrace();
		}
		return "";



	}
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session = request.getSession();
	public String runActionAfterValidate() {

		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		try {
			String rep_template_name=null;
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String moduleId = (String) sessionMap.get("GLOBAL.M_MODULE_ID");
			session.setAttribute("REP_IP_REP_INFO", IP_REP_INFO_BEAN);
			//rep_template_name = new CommonReport().template_name(moduleId,"A","PREMIREP127");
			//setRedirectUrl(new CommonReport().genReport(IP_REP_INFO_BEAN,null,null,"S",rep_template_name,null));

			//		rep_template_name="&REP_ID="+getUI_REPORT_TYPE()+"&REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&MODULE_ID="+moduleId+"&STATUS="+POL_APPRV_STATUS+"&REPORT_TYPE="+getUI_REPORT_TYPE();
			//System.out.println("request.getServerName()  :"+request.getServerName());
			setRedirectUrl(getRedirectUrl()+"REP_KEY_NO="+IP_REP_INFO_BEAN.getREP_KEY_NO()+"&REP_ID=PREMIREP128&REPORT_TYPE=PREMIREP128&STATUS=A&MODULE_ID="+moduleId);
			
			System.out.println("End");


			if (getRedirectUrl() != null) {
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
	
	private Long getPolsysid() throws Exception{
		
		MATURITY maturitybean = compositeAction.getMATURITY_ACTION_BEAN().getMATURITY_BEAN();
		String executeQuery = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Long pol_sys_id = null;
		
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(executeQuery, con,
					new Object[] {maturitybean.getUI_M_POL_NO_FM()});
			if (rs.next()) {
				pol_sys_id = rs.getLong("POL_SYS_ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return pol_sys_id;
		
	}

	
	public void PRE_INSERT(IP_REP_INFO iP_REP_INFO_BEAN) {

		try {

			iP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			iP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID"));
			iP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			iP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			iP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			iP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
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

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String cancelModalPanel(){
		getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return "";
	}
	
	
	//end

	
}
