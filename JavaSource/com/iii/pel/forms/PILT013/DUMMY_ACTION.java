package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.util.ArrayList;
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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {
	private DUMMY DUMMY_BEAN;
	private HtmlInputText COMP_UI_M_ACNT_CODE;
	private HtmlCommandButton COMP_M_BUT_APPROVE;
	private HtmlCommandButton COMP_M_BUT_RESERVE;
	private HtmlCommandButton COMP_M_STATUS;
	public PILT013_COMPOSITE_ACTION compositeAction;
	private HtmlOutputLabel COMP_UI_M_CUST_CODE_LABEL;
	private HtmlInputText COMP_UI_M_CUST_CODE;
	private HtmlInputText COMP_UI_M_CUST_CODE_DESC;
	private HtmlSelectOneMenu COMP_UI_M_USE_POL_CUST_CODE_YN;
	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;
	private HtmlInputText COMP_UI_M_POL_NO;
	private HtmlOutputLabel COMP_UI_M_APPROVAL_DT_LABEL;
	private HtmlCalendar COMP_UI_M_APPROVAL_DT;
	private HtmlOutputLabel COMP_UI_M_USE_POL_CUST_CODE_YN_LABEL;
	private HtmlOutputLabel COMP_UI_M_PREM_GEN_YN_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_PREM_GEN_YN;
	private HtmlOutputLabel COMP_UI_M_BROK_GEN_YN_LABEL;
	private HtmlOutputLabel COMP_UI_M_SMV_STATUS_CODE_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_SMV_STATUS_CODE;
	private HtmlSelectOneMenu COMP_SMV_APPRV_FLAG;
	private HtmlOutputLabel COMP_UI_M_REASON_CODE_LABEL;
	private HtmlInputText COMP_UI_M_REASON_CODE;
	private HtmlInputText COMP_UI_M_REASON_DESC;
	private HtmlOutputLabel COMP_UI_M_REMARK_LABEL;
	private HtmlInputText COMP_UI_M_REMARK;
	private HtmlCommandButton COMP_UI_M_BUT_SURR_OK;
	private HtmlCommandButton COMP_UI_M_BUT_SURR_CANCEL;
	private HtmlSelectOneMenu COMP_UI_M_BROK_GEN_YN;
	private HtmlCommandButton COMP_UI_M_BUT_OK;
	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;
	private HtmlCommandButton COMP_UI_M_LOV_CUST_CODE;
	/*Newly Added By Dhinesh on 21-03-2018*/
	
	private HtmlCommandButton COMP_UI_M_BUT_REJECT;

	public HtmlCommandButton getCOMP_UI_M_BUT_REJECT() {
		return COMP_UI_M_BUT_REJECT;
	}

	public void setCOMP_UI_M_BUT_REJECT(HtmlCommandButton cOMP_UI_M_BUT_REJECT) {
		COMP_UI_M_BUT_REJECT = cOMP_UI_M_BUT_REJECT;
	}
	
	/*End*/
	

	private List<SelectItem> listUI_M_USE_POL_CUST_CODE_YN;
	private List<SelectItem> listUI_M_PREM_GEN_YN;
	private List<SelectItem> listUI_M_BROK_GEN_YN;
	private List<SelectItem> SMV_STATUS_CODE_LIST;
	private DUMMY_HELPER helper;
	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
		COMP_UI_M_ACNT_CODE = new HtmlInputText();
		COMP_M_BUT_APPROVE = new HtmlCommandButton();
		COMP_UI_M_ACNT_CODE = new HtmlInputText();
		COMP_M_BUT_RESERVE = new HtmlCommandButton();
		COMP_M_STATUS= new HtmlCommandButton();
		COMP_UI_M_CUST_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_CUST_CODE = new HtmlInputText();
		COMP_UI_M_CUST_CODE_DESC = new HtmlInputText();
		COMP_UI_M_USE_POL_CUST_CODE_YN = new HtmlSelectOneMenu();
		/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
	    COMP_UI_M_BUS_RUL = new HtmlCommandButton();
	    /*End*/
	    
	    /*Added By Dhinesh on 20-03-2018*/
		 COMP_UI_M_BUT_REJECT = new HtmlCommandButton();
		 /*End*/
		 
		prepareListItemValues();
	}
	
	public void saveRecord() {
		try {
			//new CRUDHandler().executeInsert(obj, con)
			changeStatus(compositeAction);
			CommonUtils.getConnection().commit();
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
	}
	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}
	public HtmlInputText getCOMP_UI_M_ACNT_CODE() {
		return COMP_UI_M_ACNT_CODE;
	}
	public void setCOMP_UI_M_ACNT_CODE(HtmlInputText comp_ui_m_acnt_code) {
		COMP_UI_M_ACNT_CODE = comp_ui_m_acnt_code;
	}
	public HtmlCommandButton getCOMP_M_BUT_APPROVE() {
		return COMP_M_BUT_APPROVE;
	}
	public void setCOMP_M_BUT_APPROVE(HtmlCommandButton comp_ui_m_but_approve) {
		COMP_M_BUT_APPROVE = comp_ui_m_but_approve;
	}
	public HtmlCommandButton getCOMP_M_BUT_RESERVE() {
		return COMP_M_BUT_RESERVE;
	}
	public void setCOMP_UI_BUT_RESERVE(HtmlCommandButton comp_ui_m_but_reserve) {
		COMP_M_BUT_RESERVE = comp_ui_m_but_reserve;
	}
	public HtmlCommandButton getCOMP_M_STATUS() {
		return COMP_M_STATUS;
	}
	public void setCOMP_M_STATUS(HtmlCommandButton comp_ui_m_status) {
		COMP_M_STATUS = comp_ui_m_status;
	}
	public HtmlOutputLabel getCOMP_UI_M_CUST_CODE_LABEL() {
		return COMP_UI_M_CUST_CODE_LABEL;
	}
	public void setCOMP_UI_M_CUST_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_cust_code_label) {
		COMP_UI_M_CUST_CODE_LABEL = comp_ui_m_cust_code_label;
	}
	public HtmlInputText getCOMP_UI_M_CUST_CODE() {
		return COMP_UI_M_CUST_CODE;
	}
	public void setCOMP_UI_M_CUST_CODE(HtmlInputText comp_ui_m_cust_code) {
		COMP_UI_M_CUST_CODE = comp_ui_m_cust_code;
	}
	public HtmlInputText getCOMP_UI_M_CUST_CODE_DESC() {
		return COMP_UI_M_CUST_CODE_DESC;
	}
	public void setCOMP_UI_M_CUST_CODE_DESC(HtmlInputText comp_ui_m_cust_code_desc) {
		COMP_UI_M_CUST_CODE_DESC = comp_ui_m_cust_code_desc;
	}
	public HtmlSelectOneMenu getCOMP_UI_M_USE_POL_CUST_CODE_YN() {
		return COMP_UI_M_USE_POL_CUST_CODE_YN;
	}
	public void setCOMP_UI_M_USE_POL_CUST_CODE_YN(
			HtmlSelectOneMenu comp_ui_m_use_pol_cust_code_yn) {
		COMP_UI_M_USE_POL_CUST_CODE_YN = comp_ui_m_use_pol_cust_code_yn;
	}
	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}
	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel comp_ui_m_pol_no_label) {
		COMP_UI_M_POL_NO_LABEL = comp_ui_m_pol_no_label;
	}
	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}
	public void setCOMP_UI_M_POL_NO(HtmlInputText comp_ui_m_pol_no) {
		COMP_UI_M_POL_NO = comp_ui_m_pol_no;
	}
	public HtmlOutputLabel getCOMP_UI_M_USE_POL_CUST_CODE_YN_LABEL() {
		return COMP_UI_M_USE_POL_CUST_CODE_YN_LABEL;
	}
	public void setCOMP_UI_M_USE_POL_CUST_CODE_YN_LABEL(
			HtmlOutputLabel comp_ui_m_use_pol_cust_code_yn_label) {
		COMP_UI_M_USE_POL_CUST_CODE_YN_LABEL = comp_ui_m_use_pol_cust_code_yn_label;
	}
	public HtmlOutputLabel getCOMP_UI_M_PREM_GEN_YN_LABEL() {
		return COMP_UI_M_PREM_GEN_YN_LABEL;
	}
	public void setCOMP_UI_M_PREM_GEN_YN_LABEL(
			HtmlOutputLabel comp_ui_m_prem_gen_yn_label) {
		COMP_UI_M_PREM_GEN_YN_LABEL = comp_ui_m_prem_gen_yn_label;
	}
	public HtmlSelectOneMenu getCOMP_UI_M_PREM_GEN_YN() {
		return COMP_UI_M_PREM_GEN_YN;
	}
	public void setCOMP_UI_M_PREM_GEN_YN(HtmlSelectOneMenu comp_ui_m_prem_gen_yn) {
		COMP_UI_M_PREM_GEN_YN = comp_ui_m_prem_gen_yn;
	}
	public HtmlOutputLabel getCOMP_UI_M_BROK_GEN_YN_LABEL() {
		return COMP_UI_M_BROK_GEN_YN_LABEL;
	}
	public void setCOMP_UI_M_BROK_GEN_YN_LABEL(
			HtmlOutputLabel comp_ui_m_brok_gen_yn_label) {
		COMP_UI_M_BROK_GEN_YN_LABEL = comp_ui_m_brok_gen_yn_label;
	}
	public HtmlSelectOneMenu getCOMP_UI_M_BROK_GEN_YN() {
		return COMP_UI_M_BROK_GEN_YN;
	}
	public void setCOMP_UI_M_BROK_GEN_YN(HtmlSelectOneMenu comp_ui_m_brok_gen_yn) {
		COMP_UI_M_BROK_GEN_YN = comp_ui_m_brok_gen_yn;
	}
	public HtmlOutputLabel getCOMP_UI_M_APPROVAL_DT_LABEL() {
		return COMP_UI_M_APPROVAL_DT_LABEL;
	}
	public void setCOMP_UI_M_APPROVAL_DT_LABEL(
			HtmlOutputLabel comp_ui_m_approval_dt_label) {
		COMP_UI_M_APPROVAL_DT_LABEL = comp_ui_m_approval_dt_label;
	}
	public HtmlCalendar getCOMP_UI_M_APPROVAL_DT() {
		return COMP_UI_M_APPROVAL_DT;
	}
	public void setCOMP_UI_M_APPROVAL_DT(HtmlCalendar comp_ui_m_approval_dt) {
		COMP_UI_M_APPROVAL_DT = comp_ui_m_approval_dt;
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
	public HtmlCommandButton getCOMP_UI_M_LOV_CUST_CODE() {
		return COMP_UI_M_LOV_CUST_CODE;
	}
	public void setCOMP_UI_M_LOV_CUST_CODE(HtmlCommandButton comp_ui_m_lov_cust_code) {
		COMP_UI_M_LOV_CUST_CODE = comp_ui_m_lov_cust_code;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent ae){
		
		if(isBlockFlag()){
			CommonUtils.clearMaps(this);
			helper.executeQuery(compositeAction);
			setBlockFlag(false);
		}
		
	}

	private void prepareListItemValues(){
		Connection connection = null;
		
		try {
			connection = CommonUtils.getConnection();
			listUI_M_BROK_GEN_YN = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "DUMMY", "DUMMY.M_BROK_GEN_YN", null);
			listUI_M_PREM_GEN_YN = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "DUMMY", "DUMMY.M_PREM_GEN_YN", null);
			listUI_M_USE_POL_CUST_CODE_YN = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "DUMMY", "DUMMY.M_USE_POL_CUST_CODE_YN", null);
			
			SMV_STATUS_CODE_LIST = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "DUMMY", "DUMMY.M_SMV_STATUS_CODE", null);

		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("ERROR", e.getMessage());
			
		}
		
	}
	public List<SelectItem> getListUI_M_USE_POL_CUST_CODE_YN() {
		return listUI_M_USE_POL_CUST_CODE_YN;
	}
	public void setListUI_M_USE_POL_CUST_CODE_YN(
			List<SelectItem> listUI_M_USE_POL_CUST_CODE_YN) {
		this.listUI_M_USE_POL_CUST_CODE_YN = listUI_M_USE_POL_CUST_CODE_YN;
	}
	public List<SelectItem> getListUI_M_PREM_GEN_YN() {
		return listUI_M_PREM_GEN_YN;
	}
	public void setListUI_M_PREM_GEN_YN(List<SelectItem> listUI_M_PREM_GEN_YN) {
		this.listUI_M_PREM_GEN_YN = listUI_M_PREM_GEN_YN;
	}
	public List<SelectItem> getListUI_M_BROK_GEN_YN() {
		return listUI_M_BROK_GEN_YN;
	}
	public void setListUI_M_BROK_GEN_YN(List<SelectItem> listUI_M_BROK_GEN_YN) {
		this.listUI_M_BROK_GEN_YN = listUI_M_BROK_GEN_YN;
	}

	public void UI_M_APPROVAL_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.M_APPROVAL_DT_WHEN_VALIDATE_ITEM(compositeAction, value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void UI_M_USE_POL_CUST_CODE_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.M_USE_POL_CUST_CODE_YN_WHEN_LIST_CHANGED(compositeAction, value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void UI_M_CUST_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.M_CUST_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_UI_M_CUST_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public ArrayList<LovBean> Cust_Code_Lov(Object obj)throws Exception{
		ArrayList<com.iii.premia.common.bean.LovBean> lovList = null;
		try{
		ListItemUtil itemUtil = new ListItemUtil();
		// P_CALL_LOV('PT_IL_POLICY.POL_PLAN_CODE','B');
		lovList = itemUtil.P_CALL_LOV("PILT013", "PT_IL_POLICY",
				"POL_PLAN_CODE", "B", null, null, null, null,
				(String) obj);
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("custCodeLOV", e.getMessage());
			
		}
		return lovList;
	}
	
	
	public void validateSMV_APPRV_FLAG(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setSMV_APPRV_FLAG((String)value);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	public ArrayList<LovBean> REASON_CODE_Lov(Object obj)throws Exception{
		ArrayList<com.iii.premia.common.bean.LovBean> lovList = null;
		try{
		ListItemUtil itemUtil = new ListItemUtil();
		// P_CALL_LOV('PT_IL_POLICY.POL_PLAN_CODE','B');
		lovList = itemUtil.P_CALL_LOV("PILT013", "DUMMY",
				"M_REASON_CODE", "IL_REASON", "6", null, null, null,
				(String) obj);
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("custCodeLOV", e.getMessage());
			
		}
		return lovList;
	}
	
	public String action_M_BUT_OK(){
		try{
		String callForm = helper.OK_BUTTON_PRESSED(compositeAction);
		//added by gopi for ssp call id ZBLIFE-1465513
		compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().setBlockFlag(true);
		//end
		String message = Messages.getString(
				PELConstants.pelErrorMessagePath,"3083");
		
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				message);
		//return callForm;
		
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("custCodeLOV", e.getMessage());
			
		}
		
		
        /*Modified by Janani on 19.07.2017 for ZBILQC-1731896*/		
		return "PILT013_PT_IL_POLICY";
		
//		return "PILT013_PT_IL_SURR_MAT_VALUES";
		
		/*End*/
	}
	
	public void changeStatus(PILT013_COMPOSITE_ACTION compositeAction){
		String update = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_APPRV_FLAG = ? WHERE SMV_SYS_ID = ?";
		try{
			Connection connection = CommonUtils.getConnection();
			new CRUDHandler().executeUpdateStatement(update, connection, new Object[]{DUMMY_BEAN.getSMV_APPRV_FLAG(),compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID()});
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public String actionM_BUT_SURR_OK()throws Exception{
		try{
			helper.SURR_OK_BUTTON_PRESSED(compositeAction);
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().setBlockFlag(true);
			return "PILT013_PT_IL_SURR_MAT_VALUES";
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("custCodeLOV", e.getMessage());
		}
		return null;
	}
	public PILT013_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILT013_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	public HtmlOutputLabel getCOMP_UI_M_SMV_STATUS_CODE_LABEL() {
		return COMP_UI_M_SMV_STATUS_CODE_LABEL;
	}
	public void setCOMP_UI_M_SMV_STATUS_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_smv_status_code_label) {
		COMP_UI_M_SMV_STATUS_CODE_LABEL = comp_ui_m_smv_status_code_label;
	}
	public HtmlSelectOneMenu getCOMP_UI_M_SMV_STATUS_CODE() {
		return COMP_UI_M_SMV_STATUS_CODE;
	}
	public void setCOMP_UI_M_SMV_STATUS_CODE(HtmlSelectOneMenu comp_ui_m_smv_status_code) {
		COMP_UI_M_SMV_STATUS_CODE = comp_ui_m_smv_status_code;
	}
	public HtmlOutputLabel getCOMP_UI_M_REASON_CODE_LABEL() {
		return COMP_UI_M_REASON_CODE_LABEL;
	}
	public void setCOMP_UI_M_REASON_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_reason_code_label) {
		COMP_UI_M_REASON_CODE_LABEL = comp_ui_m_reason_code_label;
	}
	public HtmlInputText getCOMP_UI_M_REASON_CODE() {
		return COMP_UI_M_REASON_CODE;
	}
	public void setCOMP_UI_M_REASON_CODE(HtmlInputText comp_ui_m_reason_code) {
		COMP_UI_M_REASON_CODE = comp_ui_m_reason_code;
	}
	public HtmlInputText getCOMP_UI_M_REASON_DESC() {
		return COMP_UI_M_REASON_DESC;
	}
	public void setCOMP_UI_M_REASON_DESC(HtmlInputText comp_ui_m_reason_desc) {
		COMP_UI_M_REASON_DESC = comp_ui_m_reason_desc;
	}
	public HtmlOutputLabel getCOMP_UI_M_REMARK_LABEL() {
		return COMP_UI_M_REMARK_LABEL;
	}
	public void setCOMP_UI_M_REMARK_LABEL(HtmlOutputLabel comp_ui_m_remark_label) {
		COMP_UI_M_REMARK_LABEL = comp_ui_m_remark_label;
	}
	public HtmlInputText getCOMP_UI_M_REMARK() {
		return COMP_UI_M_REMARK;
	}
	public void setCOMP_UI_M_REMARK(HtmlInputText comp_ui_m_remark) {
		COMP_UI_M_REMARK = comp_ui_m_remark;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_SURR_OK() {
		return COMP_UI_M_BUT_SURR_OK;
	}
	public void setCOMP_UI_M_BUT_SURR_OK(HtmlCommandButton comp_ui_m_but_surr_ok) {
		COMP_UI_M_BUT_SURR_OK = comp_ui_m_but_surr_ok;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_SURR_CANCEL() {
		return COMP_UI_M_BUT_SURR_CANCEL;
	}
	public void setCOMP_UI_M_BUT_SURR_CANCEL(
			HtmlCommandButton comp_ui_m_but_surr_cancel) {
		COMP_UI_M_BUT_SURR_CANCEL = comp_ui_m_but_surr_cancel;
	}
	public List<SelectItem> getSMV_STATUS_CODE_LIST() {
		return SMV_STATUS_CODE_LIST;
	}
	public void setSMV_STATUS_CODE_LIST(List<SelectItem> smv_status_code_list) {
		SMV_STATUS_CODE_LIST = smv_status_code_list;
	}
	public DUMMY_HELPER getHelper() {
		return helper;
	}
	public void setHelper(DUMMY_HELPER helper) {
		this.helper = helper;
	}
	public void setCOMP_M_BUT_RESERVE(HtmlCommandButton comp_m_but_reserve) {
		COMP_M_BUT_RESERVE = comp_m_but_reserve;
	}

	public HtmlSelectOneMenu getCOMP_SMV_APPRV_FLAG() {
		return COMP_SMV_APPRV_FLAG;
	}

	public void setCOMP_SMV_APPRV_FLAG(HtmlSelectOneMenu comp_smv_apprv_flag) {
		COMP_SMV_APPRV_FLAG = comp_smv_apprv_flag;
	}
	
	/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
	private HtmlCommandButton COMP_UI_M_BUS_RUL;
	public HtmlCommandButton getCOMP_UI_M_BUS_RUL() {
		return COMP_UI_M_BUS_RUL;
	}

	public void setCOMP_UI_M_BUS_RUL(HtmlCommandButton cOMP_UI_M_BUS_RUL) {
		COMP_UI_M_BUS_RUL = cOMP_UI_M_BUS_RUL;
	}
	/*End*/

}
