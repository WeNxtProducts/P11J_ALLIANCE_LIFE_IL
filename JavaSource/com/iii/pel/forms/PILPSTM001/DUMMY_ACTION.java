package com.iii.pel.forms.PILPSTM001;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.pel.utils.P9ILPK_END_OF_DAY_PROC;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {
	
	private static final Log log = LogFactory.getLog(DUMMY_ACTION.class);

	private HtmlOutputLabel COMP_ULP_POL_NO_FM_LABEL;

	private HtmlInputText COMP_ULP_POL_NO_FM;

	private HtmlOutputLabel COMP_ULP_POL_NO_TO_LABEL;

	private HtmlInputText COMP_ULP_POL_NO_TO;

	private HtmlOutputLabel COMP_ULP_DATE_FM_LABEL;

	private HtmlCalendar COMP_ULP_DATE_FM;
	
	private HtmlCommandButton UI_PRESS_OK;
	
	private HtmlCommandButton UI_PRESS_CANCEL;
	
	private HtmlSelectOneMenu UI_PROC_FOR;
	
	private HtmlOutputLabel UI_PROC_FOR_LABEL;

	private DUMMY DUMMY_BEAN;

	public PILPSTM001_COMPOSITE_ACTION compositeAction;

	private DUMMY_HELPER helper;
	
	private List<LovBean> suggestionLOV = null;
	
	private List<SelectItem> processFor = new ArrayList<SelectItem>();

	/**
	 * 
	 */
	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
		setProcessFor(ListItemUtil.getDropDownListValue(getConnection(), "PILPSTM001", "DUMMY", "DUMMY.M_PRO_FOR", "ILP_PRO_FOR"));
	}
	
	/**
	 * @return the compositeAction
	 */
	public PILPSTM001_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PILPSTM001_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the suggestionLOV
	 */
	public List<LovBean> getSuggestionLOV() {
		return suggestionLOV;
	}

	/**
	 * @param suggestionLOV the suggestionLOV to set
	 */
	public void setSuggestionLOV(List<LovBean> suggestionLOV) {
		this.suggestionLOV = suggestionLOV;
	}

	/**
	 * @return the dUMMY_BEAN
	 */
	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	/**
	 * @param dummy_bean the dUMMY_BEAN to set
	 */
	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public void saveRecord() {
		try {
			if (getDUMMY_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getDUMMY_BEAN(), CommonUtils
						.getConnection());
			} else {
				new CRUDHandler().executeInsert(getDUMMY_BEAN(), CommonUtils
						.getConnection());
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
	
	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {
			if(isFormFlag()){
				helper.preForm(compositeAction);
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				helper.whenCreateRecord(compositeAction);
				helper.whenNewRecordInstance(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/**
	 * @return the helper
	 */
	public DUMMY_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(DUMMY_HELPER helper) {
		this.helper = helper;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<LovBean> policyFromLov(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILPSTM001", "DUMMY", "M_POLICY_FM", 
					null, null, 
					null, null, null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<LovBean> policyToLov(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILPSTM001", "DUMMY", "M_POLICY_TO", 
					null, null, 
					null, null, null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @return the processFor
	 */
	public List<SelectItem> getProcessFor() {
		return processFor;
	}

	/**
	 * @param processFor the processFor to set
	 */
	public void setProcessFor(List<SelectItem> processFor) {
		this.processFor = processFor;
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	public void buttonPress() throws Exception{
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		log.info("POLICY NUMBER FROM"+DUMMY_BEAN.getUI_M_POLICY_FM());
		log.info("POLICY NUMBER TO"+DUMMY_BEAN.getUI_M_POLICY_TO());
		log.info("PRO FOR"+DUMMY_BEAN.getUI_M_PRO_FOR());
		log.info("M TO DATE"+DUMMY_BEAN.getUI_M_TO_DT());
		try{
			Connection connection = null;
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			String product_code=null;
			Long pol_sys_id=null;
			String message = "";
			
	//added based on shakti reqirement.
			
			new P9ILPK_POLICY().P_UPD_DATE_GLOBAL();
			
			P9ILPK_END_OF_DAY_PROC.END_OF_DAY_PROC(DUMMY_BEAN.getUI_M_PRO_FOR(), 
					DUMMY_BEAN.getUI_M_POLICY_FM(),
					DUMMY_BEAN.getUI_M_POLICY_TO(), 
					CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_TO_DT()));
			log.info("PROCESSING COMPLETED");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			"Processing Completed Successfully");
			getWarningMap().put("OK",
			"Processing Completed Successfully");
			
			/*Added by saritha on 06-Mar-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
			 email should be sent to finance user.*/
			if("W".equalsIgnoreCase(getDUMMY_BEAN().getUI_M_PRO_FOR())){
				System.out.println("process for:::"+DUMMY_BEAN.getUI_M_PRO_FOR());
				
				System.out.println("pol no::::"+DUMMY_BEAN.getUI_M_POLICY_FM());
				String C1 ="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
				resultSet = handler.executeSelectStatement(C1, connection,
						new Object[] {DUMMY_BEAN.getUI_M_POLICY_FM()});
				while(resultSet.next()) {
					product_code =resultSet.getString("POL_PROD_CODE");
					pol_sys_id   =resultSet.getLong("POL_SYS_ID");
					System.out.println("product_code--------------"+product_code);
					System.out.println("pol_sys_id----------------"+pol_sys_id);
				}
				String P_CUST_TYPE=" ";
				String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(product_code,"WID",String.valueOf(pol_sys_id),"U","");
				message = message + emailStatusMessage;
				/*emailTriggerProcCall();*/

			}

			/*End*/	
		
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
	}

	/**
	 * @return the cOMP_ULP_POL_NO_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_ULP_POL_NO_FM_LABEL() {
		return COMP_ULP_POL_NO_FM_LABEL;
	}

	/**
	 * @param comp_ulp_pol_no_fm_label the cOMP_ULP_POL_NO_FM_LABEL to set
	 */
	public void setCOMP_ULP_POL_NO_FM_LABEL(HtmlOutputLabel comp_ulp_pol_no_fm_label) {
		COMP_ULP_POL_NO_FM_LABEL = comp_ulp_pol_no_fm_label;
	}

	/**
	 * @return the cOMP_ULP_POL_NO_FM
	 */
	public HtmlInputText getCOMP_ULP_POL_NO_FM() {
		return COMP_ULP_POL_NO_FM;
	}

	/**
	 * @param comp_ulp_pol_no_fm the cOMP_ULP_POL_NO_FM to set
	 */
	public void setCOMP_ULP_POL_NO_FM(HtmlInputText comp_ulp_pol_no_fm) {
		COMP_ULP_POL_NO_FM = comp_ulp_pol_no_fm;
	}

	/**
	 * @return the cOMP_ULP_POL_NO_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_ULP_POL_NO_TO_LABEL() {
		return COMP_ULP_POL_NO_TO_LABEL;
	}

	/**
	 * @param comp_ulp_pol_no_to_label the cOMP_ULP_POL_NO_TO_LABEL to set
	 */
	public void setCOMP_ULP_POL_NO_TO_LABEL(HtmlOutputLabel comp_ulp_pol_no_to_label) {
		COMP_ULP_POL_NO_TO_LABEL = comp_ulp_pol_no_to_label;
	}

	/**
	 * @return the cOMP_ULP_POL_NO_TO
	 */
	public HtmlInputText getCOMP_ULP_POL_NO_TO() {
		return COMP_ULP_POL_NO_TO;
	}

	/**
	 * @param comp_ulp_pol_no_to the cOMP_ULP_POL_NO_TO to set
	 */
	public void setCOMP_ULP_POL_NO_TO(HtmlInputText comp_ulp_pol_no_to) {
		COMP_ULP_POL_NO_TO = comp_ulp_pol_no_to;
	}

	/**
	 * @return the cOMP_ULP_DATE_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_ULP_DATE_FM_LABEL() {
		return COMP_ULP_DATE_FM_LABEL;
	}

	/**
	 * @param comp_ulp_date_fm_label the cOMP_ULP_DATE_FM_LABEL to set
	 */
	public void setCOMP_ULP_DATE_FM_LABEL(HtmlOutputLabel comp_ulp_date_fm_label) {
		COMP_ULP_DATE_FM_LABEL = comp_ulp_date_fm_label;
	}

	/**
	 * @return the cOMP_ULP_DATE_FM
	 */
	public HtmlCalendar getCOMP_ULP_DATE_FM() {
		return COMP_ULP_DATE_FM;
	}

	/**
	 * @param comp_ulp_date_fm the cOMP_ULP_DATE_FM to set
	 */
	public void setCOMP_ULP_DATE_FM(HtmlCalendar comp_ulp_date_fm) {
		COMP_ULP_DATE_FM = comp_ulp_date_fm;
	}

	/**
	 * @return the uI_PRESS_OK
	 */
	public HtmlCommandButton getUI_PRESS_OK() {
		return UI_PRESS_OK;
	}

	/**
	 * @param ui_press_ok the uI_PRESS_OK to set
	 */
	public void setUI_PRESS_OK(HtmlCommandButton ui_press_ok) {
		UI_PRESS_OK = ui_press_ok;
	}

	/**
	 * @return the uI_PROC_FOR
	 */
	public HtmlSelectOneMenu getUI_PROC_FOR() {
		return UI_PROC_FOR;
	}

	/**
	 * @param ui_proc_for the uI_PROC_FOR to set
	 */
	public void setUI_PROC_FOR(HtmlSelectOneMenu ui_proc_for) {
		UI_PROC_FOR = ui_proc_for;
	}

	/**
	 * @return the log
	 */
	public static Log getLog() {
		return log;
	}
	/*
	 * 
	 */
	public void whenValidatorAsDate(FacesContext context, UIComponent component, Object value){
		try {
			getErrorMap().clear();
			this.DUMMY_BEAN.setUI_M_TO_DT((Date)value);
			
			helper.whenValidateDate(DUMMY_BEAN);
		} catch (Exception e) {
			
			log.debug("=========>Exception========>"+e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));		
		}
	}
	/**
	 * 
	 * @param event
	 *//*
	public void whenValidatorAsDateOnChange(ActionEvent event){
		try {
			getErrorMap().clear();
			UIInput input = (UIInput) event.getComponent().getParent();
			this.DUMMY_BEAN.setUI_M_TO_DT((Date)input.getValue());
			
			helper.whenValidateDate(DUMMY_BEAN);
		} catch (Exception e) {
			log.debug("=========>Exception========>"+e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));		
		}
	}*/
	
	/*
	 * 
	 */
	public void whenValidatorFromPol(FacesContext context, UIComponent component, Object value){
		try {
			String polNoFrom = (String)value;
			DUMMY_BEAN.setUI_M_POLICY_FM(polNoFrom);
			helper.whenValidatePolicyFrom(DUMMY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));		
		}
	}
	
	/*
	 * 
	 */
	public void whenValidatorToPol(FacesContext context, UIComponent component, Object value){
		try {
			String polNoTo = (String)value;
			DUMMY_BEAN.setUI_M_POLICY_TO(polNoTo);
			helper.whenValidatePolicyTO(DUMMY_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));		
		}
	}
	
	public void listenerULP_POL_NO_FM(ActionEvent event) {
		String currentValue = (String) COMP_ULP_POL_NO_FM.getSubmittedValue();

		try {
			DUMMY_BEAN.setUI_M_POLICY_FM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(currentValue, "String"));
			COMP_ULP_POL_NO_FM.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ULP_POL_NO_FM", e.getMessage());
		}
	}

	public void listenerULP_POL_NO_TO(ActionEvent event) {
		String currentValue = (String) COMP_ULP_POL_NO_TO.getSubmittedValue();
		try {
			DUMMY_BEAN.setUI_M_POLICY_TO((String) new CommonUtils()
					.SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_POLICY_FM(),
							currentValue, "String"));
			COMP_ULP_POL_NO_TO.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ULP_POL_NO_TO", e.getMessage());
		}
	}

	/**
	 * @return the uI_PRESS_CANCEL
	 */
	public HtmlCommandButton getUI_PRESS_CANCEL() {
		return UI_PRESS_CANCEL;
	}

	/**
	 * @param ui_press_cancel the uI_PRESS_CANCEL to set
	 */
	public void setUI_PRESS_CANCEL(HtmlCommandButton ui_press_cancel) {
		UI_PRESS_CANCEL = ui_press_cancel;
	}

	/**
	 * @return the uI_PROC_FOR_LABEL
	 */
	public HtmlOutputLabel getUI_PROC_FOR_LABEL() {
		return UI_PROC_FOR_LABEL;
	}

	/**
	 * @param ui_proc_for_label the uI_PROC_FOR_LABEL to set
	 */
	public void setUI_PROC_FOR_LABEL(HtmlOutputLabel ui_proc_for_label) {
		UI_PROC_FOR_LABEL = ui_proc_for_label;
	}
	
	
	/*Added by saritha on 16-Feb-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
	 email should be sent to finance user.
	 *
	 */
	 /*public String emailTriggerProcCall() throws Exception{
		   	String subject="SELECT PMT_PROD_CODE,PMT_MAIL_SUB,PMT_MAIL_TEXT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE = 'WID'";
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
		   	while(rs3.next()){
		   		mailid=rs3.getString("USER_EMAIL_ID");
		   		if(mailid!=null){
		   			Object[] values1 = {"WID",mailid,sub,body,"N" };
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
			}
	  	*/
	 
	 public void validatorprocess(FacesContext context, UIComponent component, Object value){
			try {
				DUMMY_BEAN.setUI_M_PRO_FOR((String)value);
				System.out.println("process for"+DUMMY_BEAN.getUI_M_PRO_FOR());
			
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));		
			}
		}
	 
	 /*End*/
}
