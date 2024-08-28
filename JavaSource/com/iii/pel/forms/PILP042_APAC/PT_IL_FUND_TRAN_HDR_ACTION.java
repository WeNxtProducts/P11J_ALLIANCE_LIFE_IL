package com.iii.pel.forms.PILP042_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;

import com.iii.pel.forms.PILT016A_APAC.IP_REP_INFO;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PT_IL_FUND_TRAN_HDR_ACTION extends CommonReportAction {

	private HtmlOutputLabel COMP_UI_M_APPRV_STATUS;

	private HtmlOutputLabel COMP_UI_M_APPRV_DT_LABEL;

	private HtmlCalendar COMP_UI_M_APPRV_DT;

	private HtmlOutputLabel COMP_UI_M_FTH_APPRV_USER_ID;

	private HtmlOutputLabel COMP_FTH_POL_NO_LABEL;

	private HtmlInputText COMP_FTH_POL_NO;

	private HtmlOutputLabel COMP_UI_M_FTH_CUST_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FTH_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_FTH_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_FTH_CUST_NAME;

	private HtmlOutputLabel COMP_UI_M_FTH_PROD_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FTH_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_FTH_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FTH_PROD_DESC;

	private HtmlOutputLabel COMP_FTH_SWITCH_DT_LABEL;

	private HtmlCalendar COMP_FTH_SWITCH_DT;

	private HtmlOutputLabel COMP_FTH_FEE_LC_AMT_LABEL;

	private HtmlInputText COMP_FTH_FEE_LC_AMT;

	private HtmlOutputLabel COMP_FTH_SEQ_NO_LABEL;

	private HtmlInputText COMP_FTH_SEQ_NO;

	private HtmlOutputLabel COMP_FTH_REMARKS_LABEL;

	private HtmlInputText COMP_FTH_REMARKS;

	/*private  HtmlAjaxCommandButton COMP_UI_M_GET_FUND;*/
	private  HtmlCommandButton COMP_UI_M_GET_FUND;
	

	private HtmlCommandButton COMP_B_LOV_POL_BUT;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlCommandButton COMP_UI_M_STATUS_BUT;

	private HtmlCommandButton COMP_UI_M_FUND_DESC_BUT_1;

	private PT_IL_FUND_TRAN_HDR PT_IL_FUND_TRAN_HDR_BEAN;
	
	public PILP042_APAC_COMPOSITE_ACTION compositeAction ;

	private boolean DELETE_ALLOWED = true;

	private boolean UPDATE_ALLOWED = true;

	private boolean INSERT_ALLOWED = true;

	
	private IP_REP_INFO IP_REP_INFO_BEAN;
 	
	private HtmlCommandButton COMP_UI_M_BUT_REPORT;
	 
	private List<PT_IL_FUND_TRAN_HDR> policyNoList;

	public List<PT_IL_FUND_TRAN_HDR> getPolicyNoList() {
		return policyNoList;
	}

	public void setPolicyNoList(List<PT_IL_FUND_TRAN_HDR> policyNoList) {
		this.policyNoList = policyNoList;
	}

	public PT_IL_FUND_TRAN_HDR_ACTION() {
		CommonUtils utils = new CommonUtils();
		PT_IL_FUND_TRAN_HDR_BEAN = new PT_IL_FUND_TRAN_HDR();
		IP_REP_INFO_BEAN = new  IP_REP_INFO();
		
		// onPageLoad();
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputLabel COMP_UI_M_APPRV_STATUS) {
		this.COMP_UI_M_APPRV_STATUS = COMP_UI_M_APPRV_STATUS;
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_DT_LABEL() {
		return COMP_UI_M_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_APPRV_DT() {
		return COMP_UI_M_APPRV_DT;
	}

	public void setCOMP_UI_M_APPRV_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_APPRV_DT_LABEL) {
		this.COMP_UI_M_APPRV_DT_LABEL = COMP_UI_M_APPRV_DT_LABEL;
	}

	public void setCOMP_UI_M_APPRV_DT(HtmlCalendar COMP_UI_M_APPRV_DT) {
		this.COMP_UI_M_APPRV_DT = COMP_UI_M_APPRV_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_FTH_APPRV_USER_ID() {
		return COMP_UI_M_FTH_APPRV_USER_ID;
	}

	public void setCOMP_UI_M_FTH_APPRV_USER_ID(
			HtmlOutputLabel COMP_UI_M_FTH_APPRV_USER_ID) {
		this.COMP_UI_M_FTH_APPRV_USER_ID = COMP_UI_M_FTH_APPRV_USER_ID;
	}

	public HtmlOutputLabel getCOMP_FTH_POL_NO_LABEL() {
		return COMP_FTH_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_FTH_POL_NO() {
		return COMP_FTH_POL_NO;
	}

	public void setCOMP_FTH_POL_NO_LABEL(HtmlOutputLabel COMP_FTH_POL_NO_LABEL) {
		this.COMP_FTH_POL_NO_LABEL = COMP_FTH_POL_NO_LABEL;
	}

	public void setCOMP_FTH_POL_NO(HtmlInputText COMP_FTH_POL_NO) {
		this.COMP_FTH_POL_NO = COMP_FTH_POL_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_FTH_CUST_CODE_LABEL() {
		return COMP_UI_M_FTH_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FTH_CUST_CODE() {
		return COMP_UI_M_FTH_CUST_CODE;
	}

	public void setCOMP_UI_M_FTH_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_FTH_CUST_CODE_LABEL) {
		this.COMP_UI_M_FTH_CUST_CODE_LABEL = COMP_UI_M_FTH_CUST_CODE_LABEL;
	}

	public void setCOMP_UI_M_FTH_CUST_CODE(HtmlInputText COMP_UI_M_FTH_CUST_CODE) {
		this.COMP_UI_M_FTH_CUST_CODE = COMP_UI_M_FTH_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FTH_CUST_NAME_LABEL() {
		return COMP_UI_M_FTH_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FTH_CUST_NAME() {
		return COMP_UI_M_FTH_CUST_NAME;
	}

	public void setCOMP_UI_M_FTH_CUST_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_FTH_CUST_NAME_LABEL) {
		this.COMP_UI_M_FTH_CUST_NAME_LABEL = COMP_UI_M_FTH_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_FTH_CUST_NAME(HtmlInputText COMP_UI_M_FTH_CUST_NAME) {
		this.COMP_UI_M_FTH_CUST_NAME = COMP_UI_M_FTH_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_FTH_PROD_CODE_LABEL() {
		return COMP_UI_M_FTH_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FTH_PROD_CODE() {
		return COMP_UI_M_FTH_PROD_CODE;
	}

	public void setCOMP_UI_M_FTH_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_FTH_PROD_CODE_LABEL) {
		this.COMP_UI_M_FTH_PROD_CODE_LABEL = COMP_UI_M_FTH_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_FTH_PROD_CODE(HtmlInputText COMP_UI_M_FTH_PROD_CODE) {
		this.COMP_UI_M_FTH_PROD_CODE = COMP_UI_M_FTH_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FTH_PROD_DESC_LABEL() {
		return COMP_UI_M_FTH_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FTH_PROD_DESC() {
		return COMP_UI_M_FTH_PROD_DESC;
	}

	public void setCOMP_UI_M_FTH_PROD_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_FTH_PROD_DESC_LABEL) {
		this.COMP_UI_M_FTH_PROD_DESC_LABEL = COMP_UI_M_FTH_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_FTH_PROD_DESC(HtmlInputText COMP_UI_M_FTH_PROD_DESC) {
		this.COMP_UI_M_FTH_PROD_DESC = COMP_UI_M_FTH_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_FTH_SWITCH_DT_LABEL() {
		return COMP_FTH_SWITCH_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FTH_SWITCH_DT() {
		return COMP_FTH_SWITCH_DT;
	}

	public void setCOMP_FTH_SWITCH_DT_LABEL(
			HtmlOutputLabel COMP_FTH_SWITCH_DT_LABEL) {
		this.COMP_FTH_SWITCH_DT_LABEL = COMP_FTH_SWITCH_DT_LABEL;
	}

	public void setCOMP_FTH_SWITCH_DT(HtmlCalendar COMP_FTH_SWITCH_DT) {
		this.COMP_FTH_SWITCH_DT = COMP_FTH_SWITCH_DT;
	}

	public HtmlOutputLabel getCOMP_FTH_FEE_LC_AMT_LABEL() {
		return COMP_FTH_FEE_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_FTH_FEE_LC_AMT() {
		return COMP_FTH_FEE_LC_AMT;
	}

	public void setCOMP_FTH_FEE_LC_AMT_LABEL(
			HtmlOutputLabel COMP_FTH_FEE_LC_AMT_LABEL) {
		this.COMP_FTH_FEE_LC_AMT_LABEL = COMP_FTH_FEE_LC_AMT_LABEL;
	}

	public void setCOMP_FTH_FEE_LC_AMT(HtmlInputText COMP_FTH_FEE_LC_AMT) {
		this.COMP_FTH_FEE_LC_AMT = COMP_FTH_FEE_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_FTH_SEQ_NO_LABEL() {
		return COMP_FTH_SEQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_FTH_SEQ_NO() {
		return COMP_FTH_SEQ_NO;
	}

	public void setCOMP_FTH_SEQ_NO_LABEL(HtmlOutputLabel COMP_FTH_SEQ_NO_LABEL) {
		this.COMP_FTH_SEQ_NO_LABEL = COMP_FTH_SEQ_NO_LABEL;
	}

	public void setCOMP_FTH_SEQ_NO(HtmlInputText COMP_FTH_SEQ_NO) {
		this.COMP_FTH_SEQ_NO = COMP_FTH_SEQ_NO;
	}

	public HtmlOutputLabel getCOMP_FTH_REMARKS_LABEL() {
		return COMP_FTH_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_FTH_REMARKS() {
		return COMP_FTH_REMARKS;
	}

	public void setCOMP_FTH_REMARKS_LABEL(HtmlOutputLabel COMP_FTH_REMARKS_LABEL) {
		this.COMP_FTH_REMARKS_LABEL = COMP_FTH_REMARKS_LABEL;
	}

	public void setCOMP_FTH_REMARKS(HtmlInputText COMP_FTH_REMARKS) {
		this.COMP_FTH_REMARKS = COMP_FTH_REMARKS;
	}

	public HtmlCommandButton getCOMP_B_LOV_POL_BUT() {
		return COMP_B_LOV_POL_BUT;
	}

	public void setCOMP_B_LOV_POL_BUT(HtmlCommandButton COMP_B_LOV_POL_BUT) {
		this.COMP_B_LOV_POL_BUT = COMP_B_LOV_POL_BUT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public HtmlCommandButton getCOMP_UI_M_STATUS_BUT() {
		return COMP_UI_M_STATUS_BUT;
	}

	public void setCOMP_UI_M_STATUS_BUT(HtmlCommandButton COMP_UI_M_STATUS_BUT) {
		this.COMP_UI_M_STATUS_BUT = COMP_UI_M_STATUS_BUT;
	}

	public HtmlCommandButton getCOMP_UI_M_FUND_DESC_BUT_1() {
		return COMP_UI_M_FUND_DESC_BUT_1;
	}

	public void setCOMP_UI_M_FUND_DESC_BUT_1(
			HtmlCommandButton COMP_UI_M_FUND_DESC_BUT_1) {
		this.COMP_UI_M_FUND_DESC_BUT_1 = COMP_UI_M_FUND_DESC_BUT_1;
	}

	public PT_IL_FUND_TRAN_HDR getPT_IL_FUND_TRAN_HDR_BEAN() {
		return PT_IL_FUND_TRAN_HDR_BEAN;
	}

	public void setPT_IL_FUND_TRAN_HDR_BEAN(
			PT_IL_FUND_TRAN_HDR PT_IL_FUND_TRAN_HDR_BEAN) {
		this.PT_IL_FUND_TRAN_HDR_BEAN = PT_IL_FUND_TRAN_HDR_BEAN;
	}

	public boolean isDELETE_ALLOWED() {
		return DELETE_ALLOWED;
	}

	public void setDELETE_ALLOWED(boolean delete_allowed) {
		DELETE_ALLOWED = delete_allowed;
	}

	public boolean isUPDATE_ALLOWED() {
		return UPDATE_ALLOWED;
	}

	public void setUPDATE_ALLOWED(boolean update_allowed) {
		UPDATE_ALLOWED = update_allowed;
	}

	public boolean isINSERT_ALLOWED() {
		return INSERT_ALLOWED;
	}

	public void setINSERT_ALLOWED(boolean insert_allowed) {
		INSERT_ALLOWED = insert_allowed;
	}

	private boolean preFormFlag = true;

	public void onPageLoad(PhaseEvent event) {
		PILP042_APAC_HELPER helper = new PILP042_APAC_HELPER();
			try {
				if (preFormFlag) {
				helper.pilp042_apac_pre_form();
				helper.pilp042_apac_when_new_form_instance();
				compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().resetAllComponent();
				preFormFlag = false;
				
				}
				if(isBlockFlag()){
					if(PT_IL_FUND_TRAN_HDR_BEAN.getROWID() != null){
						getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
					}else{
						helper.pilp042_apac_pt_il_fund_tran_hdr_when_create_record();
					}
					helper.pilp042_apac_pt_il_fund_tran_hdr_when_new_record_instance();
					setBlockFlag(false);
				}
				if(CommonUtils.nvl(compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getDataTableList1().size(), 0) > 0)
				{
					compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_GET_FUND().setDisabled(true);
				}
				if("A".equalsIgnoreCase(CommonUtils.nvl(compositeAction.getPT_IL_TRAN_STATUS_ACTION().getPT_IL_TRAN_STATUS_BEAN().getTS_STATUS_CODE(),"N")))
						{
					boolean disabled = true; 
					compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().disableAllComponent(disabled);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().DisabledAllComponent(disabled);
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_UNIT_TYPE_1().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().setDELETE_ALLOWED(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().setINSERT_ALLOWED(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().setUPDATE_ALLOWED(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_SELECT_YN().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_SWITCH_BASED_ON().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_FTH_POL_NO().setDisabled(true);
						}
				
				if("Approved".equalsIgnoreCase(CommonUtils.nvl(compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_APPRV_STATUS(),"N")))
				{
					boolean disabled = true; 
					compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().disableAllComponent(disabled);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().DisabledAllComponent(disabled);
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_UNIT_TYPE_1().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_NO_ALLOC_LC_AMT_1().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_FUND_PERC().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_SWITCH_BASED_ON().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().setDELETE_ALLOWED(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().setINSERT_ALLOWED(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().setUPDATE_ALLOWED(false);
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_SELECT_YN().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getCOMP_FTD_SWITCH_BASED_ON().setDisabled(true);
					compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_FTH_POL_NO().setDisabled(true);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	/*
	 * POLICY_NO_LOV_CALL
	 */
	public List<PT_IL_FUND_TRAN_HDR> lovForPolicyNo(Object event) {
		String policyNo = (String) event;
		policyNoList = new PILP042_APAC_DELEGATE().preparepolicyNoList(
				policyNo, policyNoList);
		return policyNoList;

	}

	/*
	 * Validator Call For Pol_no
	 */
	public void pilp042_apac_fth_pol_no_validator(FacesContext context,
			UIComponent component, Object object) {
		PILP042_APAC_HELPER helper = new PILP042_APAC_HELPER();
		String exceptionMessage = null;
		try {
			helper.pilp042_apac_fth_pol_no_when_validate_item();
			PT_IL_FUND_TRAN_HDR_BEAN.setFTH_POL_NO((String) object);

		} catch (ValidatorException valExc) {
			exceptionMessage = valExc.getFacesMessage().getSummary();
			getErrorMap().put("current", exceptionMessage);
			getErrorMap().put("details", exceptionMessage);
			throw new ValidatorException(new FacesMessage(valExc.getMessage()));
		} catch (Exception e) {
			exceptionMessage = e.getMessage();
			getErrorMap().put("current", exceptionMessage);
			getErrorMap().put("details", exceptionMessage);
			throw new ValidatorException(new FacesMessage(exceptionMessage));
		}
	}

	public void pilp042_apac_pol_no(ActionEvent event) {
		UIInput input = null;

		clearMaps();
		input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*
	 * Clear Notifification Area
	 */
	private void clearMaps() {
		getErrorMap().clear();
		getWarningMap().clear();
	}

	/*
	 * Validator Call For SWITCH_DATE
	 */
	public void pilp042_apac_fth_switch_dt_validator(FacesContext context,
			UIComponent component, Object object) {
		PILP042_APAC_HELPER helper = new PILP042_APAC_HELPER();
		String exceptionMessage = null;
		try {
			helper
					.pilp042_apac_pt_il_fund_tran_hdr_fth_switch_dt_when_validate_item();
			HtmlCalendar htmlCalendar = (HtmlCalendar) component;
			Date switchDate = htmlCalendar.getAsDate(htmlCalendar
					.getSubmittedValue());
			PT_IL_FUND_TRAN_HDR_BEAN.setFTH_SWITCH_DT(switchDate);

		} catch (ValidatorException valExc) {
			exceptionMessage = valExc.getFacesMessage().getSummary();
			getErrorMap().put("current", exceptionMessage);
			getErrorMap().put("details", exceptionMessage);
			throw valExc;
		} catch (Exception e) {
			exceptionMessage = e.getMessage();
			getErrorMap().put("current", exceptionMessage);
			getErrorMap().put("details", exceptionMessage);
			throw new ValidatorException(new FacesMessage(exceptionMessage));
		}
	}

	public void pilp042_apac_switch_dt(ActionEvent event) {
		UIInput input = null;

		clearMaps();
		input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*
	 * Validator Call For SWITCH_FEE
	 */
	public void pilp042_apac_fth_switch_fee_validator(FacesContext context,
			UIComponent component, Object object) {
		PILP042_APAC_HELPER helper = new PILP042_APAC_HELPER();
		String exceptionMessage = null;
		try {
			helper
					.pilp042_apac_pt_il_fund_tran_hdr_fth_fee_lc_amt_when_validate_item();
			double switchFeeLCAmount = Double
					.parseDouble((String) COMP_FTH_FEE_LC_AMT
							.getSubmittedValue());
			System.out.println("switchFeeLCAmount :" + switchFeeLCAmount);
			PT_IL_FUND_TRAN_HDR_BEAN.setFTH_FEE_LC_AMT(switchFeeLCAmount);

		} catch (ValidatorException valExc) {
			PT_IL_FUND_TRAN_HDR_BEAN.setFTH_FEE_LC_AMT(null);
			exceptionMessage = valExc.getFacesMessage().getSummary();
			compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exceptionMessage);
			compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().getErrorMap().put("details", exceptionMessage);
			throw new ValidatorException(new FacesMessage(exceptionMessage));
		} catch (Exception e) {
			exceptionMessage = e.getMessage();
			compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().getErrorMap().put("current", exceptionMessage);
			compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().getErrorMap().put("details", exceptionMessage);
			throw new ValidatorException(new FacesMessage(exceptionMessage));
		}

	}

	public void pilp042_apac_switch_fee(ActionEvent event) {
		UIInput input = null;
		clearMaps();
		input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void sequenceNoGeneration(FacesContext facesContext,UIComponent component,Object value){
		
		
		if(COMP_FTH_SEQ_NO.getSubmittedValue()!=null){
			Integer sequenceNumber = Integer.parseInt((String)(COMP_FTH_SEQ_NO.getSubmittedValue()));
			PT_IL_FUND_TRAN_HDR_BEAN.setFTH_SEQ_NO(sequenceNumber);
						
		}
	}
	public void fireFieldValidation(ActionEvent event) {
		UIInput input =(UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * This method is used to fetch details in the bean PT_IL_FUND_TRAN_DTL_1
	 * 
	 * @param event
	 */
	public void fundButtonActionListener(ActionEvent event) {
		PILP042_APAC_HELPER helper = new PILP042_APAC_HELPER();
		PT_IL_FUND_TRAN_DTL_DELEGATE delegate = new PT_IL_FUND_TRAN_DTL_DELEGATE();
		String rowID=null;
		try {
			
			rowID=checkRowID(PT_IL_FUND_TRAN_HDR_BEAN);
			if(rowID!=null&&!rowID.isEmpty()){
				PT_IL_FUND_TRAN_HDR_BEAN.setROWID(rowID);
				new CRUDHandler().executeInsert(PT_IL_FUND_TRAN_HDR_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
			}else{
				Long fth_sys_id = helper.preInsertValidation();
				PT_IL_FUND_TRAN_HDR_BEAN.setFTH_SYS_ID(fth_sys_id);
				PT_IL_FUND_TRAN_HDR_BEAN.setFTH_CR_DT(new CommonUtils().getCurrentDate());
				PT_IL_FUND_TRAN_HDR_BEAN.setFTH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				new CRUDHandler().executeInsert(PT_IL_FUND_TRAN_HDR_BEAN, CommonUtils.getConnection());
				helper.pilp042_apac_pt_il_fund_tran_hdr_m_get_fund_when_button_pressed();
				CommonUtils.getConnection().commit();
			}

			
			PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
					.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
			compAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getPT_IL_FUND_TRAN_DTL_1_BEAN().setFTD_TRAN_TYPE("H");
			compAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getPT_IL_FUND_TRAN_DTL_1_BEAN().setFTD_TRAN_FLAG("S");
			delegate.getFundValues();
			//compAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().setDataTableList1(
		//			delegate.getFundValues());
			compAction.getPT_IL_TRAN_STATUS_ACTION().setDataTableList(
					delegate.getStatusDetails());
			compAction.getPT_IL_FUND_TRAN_DTL_ACTION().setDataTableList(delegate.getNewAllo());
			PILP042_APAC_DELEGATE PILP042_APAC_DELEGATE = new PILP042_APAC_DELEGATE();
			compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_GET_FUND().setDisabled(true);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	private String checkRowID(PT_IL_FUND_TRAN_HDR pt_il_fund_tran_hdr_bean2) {
        ResultSet resultSet=null;
        String queryString=null;
        Connection connection=null;
        CRUDHandler handler =new CRUDHandler();
        String rowID=null;
        try {
        	connection=CommonUtils.getConnection();
			queryString="select rowID,FTH_SYS_ID from PT_IL_FUND_TRAN_HDR where FTH_POL_SYS_ID='"+pt_il_fund_tran_hdr_bean2.getFTH_POL_SYS_ID()+"' and FTH_STATUS_CODE is null ";
        	resultSet=handler.executeSelectStatement(queryString,connection);
        	while (resultSet.next()) {
        		rowID=resultSet.getString(1);
        		pt_il_fund_tran_hdr_bean2.setFTH_SYS_ID(resultSet.getLong(2)); 
			}
 		} catch (Exception e) {
			// TODO: handle exception
		}
         
		
		return rowID;
	}

	//ADDED BY AKASH TO CHECK PERCENTAGE OF FUND TO BE SWITCH SHOULD BE 100%.
	
	public void chkAllocationPerc() throws Exception{
		try{
			PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
			.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
			Double sumPerc = 0.0;
			ArrayList<PT_IL_FUND_TRAN_DTL> dataListFund = (ArrayList<PT_IL_FUND_TRAN_DTL>) compAction.getPT_IL_FUND_TRAN_DTL_ACTION().getDataTableList();
			for(PT_IL_FUND_TRAN_DTL dtlBean : dataListFund){
				sumPerc = sumPerc + dtlBean.getFTD_FUND_PERC();
			}
			if(sumPerc != 100){
				throw new Exception("The Allocated Percentage Of Fund must be 100.");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e ;
		}
	}
	
	
	public String statusButtonActionListener() {
		String outcome = null;
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
		.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		try{
			chkAllocationPerc();
			outcome = "StatusCheck"; 
		}catch (Exception e) {
			outcome = "";
			e.printStackTrace();
			compAction.getPT_IL_FUND_TRAN_DTL_ACTION().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			compAction.getPT_IL_FUND_TRAN_DTL_ACTION().getErrorMap().put("CURRENT", e.getMessage());
		}
		/*FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		 */
		
		return outcome;
	}

	public String approveButtonPressed() {
		System.out.println("INSIDE APPROVE.");
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		try {
			
			PILP042_APAC_HELPER helper = new PILP042_APAC_HELPER();
			helper
					.pilp042_apac_pt_il_fund_tran_hdr_m_but_approve_when_button_pressed();
			compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_GET_FUND().setDisabled(true);
			compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_STATUS_BUT().setDisabled(true);
			compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
			
		} catch (ValidatorException ve) {
			compAction.getPT_IL_FUND_TRAN_DTL_ACTION().getErrorMap().put(
					"current", ve.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/*public HtmlAjaxCommandButton getCOMP_UI_M_GET_FUND() {
		return COMP_UI_M_GET_FUND;
	}

	public void setCOMP_UI_M_GET_FUND(HtmlAjaxCommandButton comp_ui_m_get_fund) {
		COMP_UI_M_GET_FUND = comp_ui_m_get_fund;
	}*/

	public HtmlCommandButton getCOMP_UI_M_GET_FUND() {
		return COMP_UI_M_GET_FUND;
	}

	public void setCOMP_UI_M_GET_FUND(HtmlCommandButton cOMP_UI_M_GET_FUND) {
		COMP_UI_M_GET_FUND = cOMP_UI_M_GET_FUND;
	}
	
//added by akash for report ...
	
	
	
	@Override
	public String runAction() {
		String redirectUrl=null;
		CommonUtils.clearMaps(this);
 		setRedirectUrl(null);
		HttpServletResponse response=null;
		Connection connection=null;
		String repid=null;
		//IP_REP_INFO_BEAN.setREP_ID("PILR_LET_FN");
		Map<String, String> map = new HashMap<String, String>();
		try {
			
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				PRE_INSERT(IP_REP_INFO_BEAN);
			} else {
				PRE_UPDATE(this.IP_REP_INFO_BEAN);
			}

			//delegate.executeSaveAction(this.IP_REP_INFO_BEAN);
			connection=CommonUtils.getConnection();
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
																				.getResponse();
			System.out.println("0---->"+PT_IL_FUND_TRAN_HDR_BEAN.getFTH_POL_NO());
			map.put("P_POL_SYS_ID",String.valueOf(getSysId(PT_IL_FUND_TRAN_HDR_BEAN.getFTH_POL_NO())));
			/*redirectUrl = ReportUtils.getReportRedirectString(
					IP_REP_INFO_BEAN.getREP_KEY_NO(),"PILR_REC001",
					repid,IP_REP_INFO_BEAN.getSelectedFileTyp(), map);*/
			redirectUrl = ReportUtils.getReportRedirectString(
					IP_REP_INFO_BEAN.getREP_KEY_NO(), IP_REP_INFO_BEAN.getREP_ID(), 
					IP_REP_INFO_BEAN.getREP_ID(),
					IP_REP_INFO_BEAN.getSelectedFileTyp(),map);
			// response.sendRedirect(redirectUrl);
			
			setRedirectUrl(redirectUrl);
			
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("RunAction", e.getMessage());
	}
	return redirectUrl;
 }
	
	

	public Long getSysId(String polNo){
		Connection connection = null;
		ResultSet resultSet = null;
		Long polsysId = null;
		String query = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try {
			connection =  CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection,new Object[]{polNo});
			if(resultSet.next()){
				polsysId = resultSet.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return polsysId;
		
	}
	
	
	public void PRE_INSERT(IP_REP_INFO iP_REP_INFO_BEAN) {

		try {

			iP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			iP_REP_INFO_BEAN.setREP_ID("PILR_LET_ST");
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
			IP_REP_INFO_BEAN.setREP_ID("PILR_LET_ST");
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

	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO ip_rep_info_bean) {
		IP_REP_INFO_BEAN = ip_rep_info_bean;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REPORT() {
		return COMP_UI_M_BUT_REPORT;
	}

	public void setCOMP_UI_M_BUT_REPORT(HtmlCommandButton comp_ui_m_but_report) {
		COMP_UI_M_BUT_REPORT = comp_ui_m_but_report;
	}

	 
	public void disableAllComponent(boolean disabled) 
	 {
		COMP_UI_M_STATUS_BUT.setDisabled(disabled);	
		COMP_UI_M_GET_FUND.setDisabled(disabled);
		COMP_FTH_REMARKS.setDisabled(disabled);
		
	 
	 }

	
	
	public void fundButtonAction() {
		PILP042_APAC_HELPER helper = new PILP042_APAC_HELPER();
		PT_IL_FUND_TRAN_DTL_DELEGATE delegate = new PT_IL_FUND_TRAN_DTL_DELEGATE();
		String rowID=null;
		try {
			
			rowID=checkRowID(PT_IL_FUND_TRAN_HDR_BEAN);
			if(rowID!=null&&!rowID.isEmpty()){
				PT_IL_FUND_TRAN_HDR_BEAN.setROWID(rowID);
				new CRUDHandler().executeInsert(PT_IL_FUND_TRAN_HDR_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
			}else{
				Long fth_sys_id = helper.preInsertValidation();
				PT_IL_FUND_TRAN_HDR_BEAN.setFTH_SYS_ID(fth_sys_id);
				PT_IL_FUND_TRAN_HDR_BEAN.setFTH_CR_DT(new CommonUtils().getCurrentDate());
				PT_IL_FUND_TRAN_HDR_BEAN.setFTH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				new CRUDHandler().executeInsert(PT_IL_FUND_TRAN_HDR_BEAN, CommonUtils.getConnection());
				helper.pilp042_apac_pt_il_fund_tran_hdr_m_get_fund_when_button_pressed();
				CommonUtils.getConnection().commit();
			}

			
			PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
					.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
			compAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getPT_IL_FUND_TRAN_DTL_1_BEAN().setFTD_TRAN_TYPE("H");
			compAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getPT_IL_FUND_TRAN_DTL_1_BEAN().setFTD_TRAN_FLAG("S");
			delegate.getFundValues();
			//compAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().setDataTableList1(
		//			delegate.getFundValues());
			compAction.getPT_IL_TRAN_STATUS_ACTION().setDataTableList(
					delegate.getStatusDetails());
			compAction.getPT_IL_FUND_TRAN_DTL_ACTION().setDataTableList(delegate.getNewAllo());
			PILP042_APAC_DELEGATE PILP042_APAC_DELEGATE = new PILP042_APAC_DELEGATE();
			compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_GET_FUND().setDisabled(true);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
}
