package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TREATY_CONSTANTS;
import com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TREATY_QUERY_CONSTANTS;
import com.iii.pel.forms.PILP002_APAC.COMPOSITE_ACTION_BEAN;
import com.iii.pel.forms.PILQ106_APAC.PILQ106_APAC_COMPOSITE_ACTION;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private DUMMY DUMMY_BEAN;
	private DUMMY_HELPER helper;
	public PILT002_APAC_COMPOSITE_ACTION compositeAction;
	private HtmlOutputLabel COMP_FORM_CONVERT_CAPTION;
	private HtmlOutputLabel COMP_UI_M_APPRV_STATUS;
	private HtmlOutputLabel COMP_UI_M_ICON_HINT;
	private HtmlOutputLabel COMP_UI_M_BUS_STATUS;
	private HtmlOutputLabel COMP_UI_M_END_STATUS;
	private HtmlOutputLabel COMP_UI_M_ADDL_STATUS_DESC;
	private HtmlOutputLabel COMP_UI_M_END_IDX_TYPE_NO;
	private HtmlOutputLabel COMP_UI_M_AMEND_IDX;
	private HtmlOutputLabel COMP_UI_M_CLM_ADDL_STATUS;
	private HtmlOutputLabel COMP_UI_M_CIC_STATUS;
	private HtmlOutputLabel COMP_UI_M_WAI_STATUS;
	private HtmlOutputLabel COMP_UI_M_HOLD_STATUS;
	private HtmlOutputLabel COMP_POL_APPRV_UID;
	private HtmlOutputLabel COMP_POL_TRAN_DT;
	private HtmlOutputLabel COMP_UI_M_POL_CONVERT_YN;
	private HtmlOutputLabel COMP_UI_M_POL_DOC_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_COMPY_FC_CHARGE_LABEL;

	private HtmlCommandLink COMP_UI_M_BUT_ENDT;
	private HtmlCommandButton COMP_UI_M_BUT_COPY;
	//private HtmlCommandButton COMP_UI_M_BUT_APPROVAL;
	private HtmlCommandLink COMP_UI_M_BUT_APPROVAL;
	private HtmlCommandLink COMP_UI_M_BUT_CUSTOMER;
	private HtmlCommandButton COMP_UI_M_BUT_CONTRACTOR;
	private HtmlCommandButton COMP_UI_M_BUT_HOLD;
	private HtmlCommandLink COMP_UI_M_BUT_FUND_DTL;
	private HtmlCommandButton COMP_UI_M_BUT_OCC_RATE_PAYOR;
	private HtmlCommandButton COMP_UI_M_BUT_OCC_RATE_PAYEE;
	private HtmlCommandLink COMP_UI_M_BUT_DOC_GEN_NO;
	private HtmlCommandLink COMP_UI_M_BUT_FUND_QUERY;
	private HtmlCommandButton COMP_UI_M_BUT_ADD_DETAILS;
	private HtmlCommandButton COMP_UI_M_BUT_MORE_COVER;
	private HtmlCommandLink COMP_UI_M_BUT_UDDATE_STAT;
	private HtmlCommandLink COMP_UI_M_BUT_PRMDTLS;
	private HtmlCommandButton COMP_UI_M_BUT_POL_AMDT;
	private HtmlCommandButton COMP_UI_M_BUT_CALC_DISC_LOAD;
	private HtmlCommandLink COMP_UI_M_BUT_ANN_DTLS;
	private HtmlCommandLink COMP_UI_M_BUT_CONVERT;
	private HtmlCommandLink COMP_UI_M_BUS_RUL;
	private HtmlCommandLink COMP_UI_M_BUT_PREM_ALLOC;
	private HtmlCommandLink COMP_UI_M_BUT_SURR_MAT;
	private HtmlCommandLink COMP_UI_M_BUT_UPI;
	private HtmlCommandButton COMP_UI_M_BUT_UPLOAD;
	private HtmlCommandLink COMP_UI_M_BUT_CLAIM;
	private HtmlCommandButton COMP_UI_M_BUT_REPLACE_POLICY;
	private HtmlCommandButton COMP_UI_M_BUT_ASSR_MORE_INFO;
	private HtmlCommandLink COMP_UI_M_ENDT_QUOT;
	private HtmlCommandButton COMP_UI_M_BUT_MATURITY;
	private HtmlCommandButton COMP_CONVERT_OK_BUT;

	private HtmlInputText COMP_UI_M_POL_DOC_CODE;
	private HtmlInputText COMP_UI_M_POL_DOC_DESC;
	private HtmlInputText COMP_UI_M_PS_STATUS;
	private HtmlInputText COMP_UI_M_PS_REASON_CODE;
	private HtmlInputText COMP_UI_M_REASON_DESC;
	private HtmlInputText COMP_UI_M_POL_ADDL_STATUS_DESC;
	/*private HtmlInputText COMP_UI_M_PS_REMARKS;*/
	private HtmlSelectOneMenu COMP_UI_M_POL_MEDICAL_FLAG;
	private HtmlInputText COMP_UI_M_POL_NO;
	private HtmlInputText COMP_UI_M_PROP_NO;
	private HtmlInputText COMP_UI_M_COMPY_FC_CHARGE;
	private HtmlInputText COMP_UI_M_COMPY_LC_CHARGE;

	private HtmlCalendar COMP_UI_M_PS_STATUS_DT;
	private HtmlCalendar COMP_UI_M_CONV_DT;

	private HtmlOutputLabel COMP_M_COMPY_FC_CHARGE_LABEL;
	private HtmlOutputLabel COMP_UI_M_PROP_NO_LABEL;
	private HtmlOutputLabel COMP_UI_M_CONV_DT_LABEL;
	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;
	private HtmlOutputLabel COMP_COMP_UI_M_POL_DOC_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_PS_STATUS_DT_LABEL;
	private HtmlOutputLabel COMP_UI_M_PS_STATUS_LABEL;
	private HtmlOutputLabel COMP_UI_M_PS_REASON_CODE_LABEL;
	private HtmlOutputLabel COMP_UI_M_PS_REMARKS_LABEL;
	private HtmlOutputLabel COMP_UI_M_POL_MEDICAL_FLAG_LABEL;
	private List<SelectItem> listUI_M_POL_MEDICAL_FLAG = new ArrayList<SelectItem>();
	/*Added by saranya on 07-12-2016 for RM018T - FSD_IL_ZB Life_013_Underwriting changes*/
			public HtmlAjaxCommandButton COMP_CANCEL_BUTTON;
			
			public HtmlModalPanel COMP_REPORT_MODAL_PANEL;
			
			public HtmlOutputText COMP_ISS_DT;

			public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON() {
				return COMP_CANCEL_BUTTON;
			}

			public void setCOMP_CANCEL_BUTTON(HtmlAjaxCommandButton cOMP_CANCEL_BUTTON) {
				COMP_CANCEL_BUTTON = cOMP_CANCEL_BUTTON;
			}

			public HtmlOutputText getCOMP_ISS_DT() {
				return COMP_ISS_DT;
			}

			public void setCOMP_ISS_DT(HtmlOutputText cOMP_ISS_DT) {
				COMP_ISS_DT = cOMP_ISS_DT;
			}

			public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
				return COMP_REPORT_MODAL_PANEL;
			}

			public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_REPORT_MODAL_PANEL) {
				COMP_REPORT_MODAL_PANEL = cOMP_REPORT_MODAL_PANEL;
			}

			/*End*/
	public PT_IL_POL_ASSURED_DTLS_ACTION actionBean;
	private PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN;

	private HtmlCommandLink COMP_UI_M_BUT_KEY_COMMIT;

	public HtmlInputText getCOMP_UI_M_POL_DOC_CODE() {
		return COMP_UI_M_POL_DOC_CODE;
	}

	public void setCOMP_UI_M_POL_DOC_CODE(HtmlInputText comp_ui_m_pol_doc_code) {
		COMP_UI_M_POL_DOC_CODE = comp_ui_m_pol_doc_code;
	}

	public HtmlInputText getCOMP_UI_M_PS_STATUS() {
		return COMP_UI_M_PS_STATUS;

	}

	public void setCOMP_UI_M_PS_STATUS(HtmlInputText comp_ui_m_ps_status) {
		COMP_UI_M_PS_STATUS = comp_ui_m_ps_status;
	}

	

	public HtmlCommandLink getCOMP_UI_M_BUT_APPROVAL() {
		return COMP_UI_M_BUT_APPROVAL;
	}

	public void setCOMP_UI_M_BUT_APPROVAL(
			HtmlCommandLink comp_ui_m_but_approval) {
		COMP_UI_M_BUT_APPROVAL = comp_ui_m_but_approval;
	}

	

	public HtmlCommandButton getCOMP_UI_M_BUT_CONTRACTOR() {
		return COMP_UI_M_BUT_CONTRACTOR;
	}

	public void setCOMP_UI_M_BUT_CONTRACTOR(
			HtmlCommandButton comp_ui_m_but_contractor) {
		COMP_UI_M_BUT_CONTRACTOR = comp_ui_m_but_contractor;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_HOLD() {
		return COMP_UI_M_BUT_HOLD;
	}

	public void setCOMP_UI_M_BUT_HOLD(HtmlCommandButton comp_ui_m_but_hold) {
		COMP_UI_M_BUT_HOLD = comp_ui_m_but_hold;
	}

	

	public HtmlCommandButton getCOMP_UI_M_BUT_OCC_RATE_PAYOR() {
		return COMP_UI_M_BUT_OCC_RATE_PAYOR;
	}

	public void setCOMP_UI_M_BUT_OCC_RATE_PAYOR(
			HtmlCommandButton comp_ui_m_but_occ_rate_payor) {
		COMP_UI_M_BUT_OCC_RATE_PAYOR = comp_ui_m_but_occ_rate_payor;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OCC_RATE_PAYEE() {
		return COMP_UI_M_BUT_OCC_RATE_PAYEE;
	}

	public void setCOMP_UI_M_BUT_OCC_RATE_PAYEE(
			HtmlCommandButton comp_ui_m_but_occ_rate_payee) {
		COMP_UI_M_BUT_OCC_RATE_PAYEE = comp_ui_m_but_occ_rate_payee;
	}

	

	public DUMMY_ACTION() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			DUMMY_BEAN = new DUMMY();
			helper = new DUMMY_HELPER();
			/*		COMP_UI_M_ICON_HINT =new HtmlOutputLabel();
			 COMP_UI_M_PS_STATUS=new HtmlInputText();
			 COMP_UI_M_PS_STATUS_DT = new HtmlCalendar();
			 COMP_UI_M_BUT_DOC_GEN_NO = new HtmlCommandButton();
			 COMP_UI_M_BUT_MORE_COVER = new HtmlCommandButton();
			 COMP_UI_M_BUT_ADD_DETAILS = new HtmlCommandButton();
			 COMP_UI_M_BUS_RUL = new HtmlCommandButton();
			 */

			setListUI_M_POL_MEDICAL_FLAG((ListItemUtil.getDropDownListValue_1(
					connection, "PILT002_APAC", "DUMMY",
					"DUMMY.M_POL_MEDICAL_FLAG", null)));
			instantiateAllComponent();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	

	public HtmlCommandButton getCOMP_UI_M_BUT_ADD_DETAILS() {
		return COMP_UI_M_BUT_ADD_DETAILS;
	}

	public void setCOMP_UI_M_BUT_ADD_DETAILS(
			HtmlCommandButton comp_ui_m_but_add_details) {
		COMP_UI_M_BUT_ADD_DETAILS = comp_ui_m_but_add_details;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MORE_COVER() {
		return COMP_UI_M_BUT_MORE_COVER;
	}

	public void setCOMP_UI_M_BUT_MORE_COVER(
			HtmlCommandButton comp_ui_m_but_more_cover) {
		COMP_UI_M_BUT_MORE_COVER = comp_ui_m_but_more_cover;
	}

	

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_AMDT() {
		return COMP_UI_M_BUT_POL_AMDT;
	}

	public void setCOMP_UI_M_BUT_POL_AMDT(
			HtmlCommandButton comp_ui_m_but_pol_amdt) {
		COMP_UI_M_BUT_POL_AMDT = comp_ui_m_but_pol_amdt;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CALC_DISC_LOAD() {
		return COMP_UI_M_BUT_CALC_DISC_LOAD;
	}

	public void setCOMP_UI_M_BUT_CALC_DISC_LOAD(
			HtmlCommandButton comp_ui_m_but_calc_disc_load) {
		COMP_UI_M_BUT_CALC_DISC_LOAD = comp_ui_m_but_calc_disc_load;
	}

	

	public HtmlCommandButton getCOMP_UI_M_BUT_UPLOAD() {
		return COMP_UI_M_BUT_UPLOAD;
	}

	public void setCOMP_UI_M_BUT_UPLOAD(HtmlCommandButton comp_ui_m_but_upload) {
		COMP_UI_M_BUT_UPLOAD = comp_ui_m_but_upload;
	}

	

	public HtmlCommandButton getCOMP_UI_M_BUT_REPLACE_POLICY() {
		return COMP_UI_M_BUT_REPLACE_POLICY;
	}

	public void setCOMP_UI_M_BUT_REPLACE_POLICY(
			HtmlCommandButton comp_ui_m_but_replace_policy) {
		COMP_UI_M_BUT_REPLACE_POLICY = comp_ui_m_but_replace_policy;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ASSR_MORE_INFO() {
		return COMP_UI_M_BUT_ASSR_MORE_INFO;
	}

	public void setCOMP_UI_M_BUT_ASSR_MORE_INFO(
			HtmlCommandButton comp_ui_m_but_assr_more_info) {
		COMP_UI_M_BUT_ASSR_MORE_INFO = comp_ui_m_but_assr_more_info;
	}

	

	public HtmlOutputLabel getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputLabel comp_ui_m_apprv_status) {
		COMP_UI_M_APPRV_STATUS = comp_ui_m_apprv_status;
	}

	public String convertButtonAction() {
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();

		String outCome = "PILT002_APAC_PT_IL_CONVERT";
		try {
			dummy_helper.UI_M_BUT_CONVERT_WHEN_BUTTON_PRESSED(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outCome;
	}

	public String convertOKButtonAction() {
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
		String outCome = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			outCome = dummy_helper
					.UI_M_BUT_OK_WHEN_BUTTON_PRESSED(compositeAction);
			COMP_UI_M_POL_NO.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			/*
			 * MODIFIED BY AMEEN ON 05-04-2018  FOR kic PARTIAL PAYMENT
			 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());*/
			
			String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			
			getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, error);
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, error);
		} finally {
			ErrorHelpUtil.getWarningsforProcedureAction(connection,
					FacesContext.getCurrentInstance(), "convertOKButtonAction",
					getWarningMap());
		}
		return outCome;
	}

	public String prmdtlsButtonAction() {
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();

		String outCome = "PILT002_APAC_PT_IL_POLICY";
		try {
			dummy_helper.UI_M_BUT_PRMDTLS_WHEN_BUTTON_PRESSED(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outCome;
	}

	public String uddateStatButtonAction() {
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();

		String outCome = "PILT002_APAC_PT_IL_POLICY";
		try {
			dummy_helper
					.UI_M_BUT_UDDATE_STAT_WHEN_BUTTON_PRESSED(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outCome;
	}

	public String endtQuotButtonAction() {
		//  GO_BLOCK('PT_IL_POLICY2');
		return "PILT002_APAC_PT_IL_POLICY2";

	}

	public String surrMatButtonAction() {

		// GO_BLOCK('PT_IL_SURR_MAT_VALUES');
		return "PILT002_APAC_PT_IL_SURR_MAT_VALUES";
	}

	public String goToPolicy() {
		CommonUtils.setGlobalVariable("CALLING_FORM", null);
		return "PILT002_APAC_PT_IL_POLICY";
	}

	public String premAllocButtonAction() {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			
			/*Added by Janani on 17-08-2017 for ZBILQC-1732439*/
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(false);
			/*end*/
			
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", pt_il_policy_bean
					.getPOL_NO());
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT002_APAC");
			CommonUtils.setGlobalVariable("PILP010_BACK_FLAG","Y");
			//  CALL_FORM('PILT010',NO_HIDE,NO_REPLACE);
			
			/*Added by saranya for for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 22-03-2017*/
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
			/*End*/

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "PILT010";
	}

	public String UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED() {
		String outcome = null;
		try {
			outcome = new DUMMY_HELPER()
					.UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED(compositeAction);
			//   outcome="PILT002_APAC_PT_IL_POLICY";
			//new DUMMY_HELPER().UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED(compositeAction);
			outcome = "backToPolicyFromEndorsement";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return outcome;
	}

	public String holdButtonAction() {
		String outcome = null;
		try {
			new DUMMY_HELPER()
					.UI_M_BUT_HOLD_WHEN_BUTTON_PRESSED(compositeAction);
			outcome = "PILT002_APAC_DUMMY";
		} catch (Exception e) {
			// TODO: handle exception
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
					"Hold", e.getMessage());
			e.printStackTrace();
		}
		return outcome;
	}

	public String polAmdtButtonAction() {
		String outcome = null;
		try {
			new DUMMY_HELPER()
					.UI_M_BUT_POL_AMDT_WHEN_BUTTON_PRESSED(compositeAction);
			
			/*Added and modified by ganesh on 14-04-2017, to display messge and close the amendment popup screen */
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_REPORT_MODAL_PANEL_AMENDMENT().setShowWhenRendered(false);			
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Amendment passed successfully for this proposal");
			//outcome = "PILT002_APAC_PT_IL_POLICY";
			/*end*/
			
			outcome = "PILT002_APAC_PT_IL_POLICY";
		} catch (Exception e) {
			// TODO: handle exception
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
					"polAmdt", e.getMessage());
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
					"polAmdt", e.getMessage());
			e.printStackTrace();
		}
		return outcome;
	}

	public String calcDiscLoadButtonAction() {
		String outcome = null;
		try {
			new DUMMY_HELPER()
					.UI_M_BUT_CALC_DISC_LOAD_WHEN_BUTTON_PRESSED(compositeAction);
			outcome = "PILT002_APAC_PT_IL_POL_DISC_LOAD";
			new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
		return outcome;
	}

	public String fundQueryButtonAction() {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		String outCome = null;
		try {
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", pt_il_policy_bean
					.getPOL_NO());
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT002_APAC");
			CommonUtils.setGlobalVariable("GLOBAL.BLACK_FLAG", "Y");
             new PILQ106_APAC_COMPOSITE_ACTION();
			outCome = "PILQ106_APAC";
			//   CALL_FORM('PILQ106_APAC',NO_HIDE,NO_REPLACE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return outCome;
	}

	public String UI_M_BUT_FUND_QUERY_WHEN_BUTTON_PRESSED() {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", pt_il_policy_bean
					.getPOL_NO());
			//   CALL_FORM('PILQ106_APAC',NO_HIDE,NO_REPLACE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "PILQ106_APAC";
	}

	public String uploadButtonAction() {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		try {
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
					pt_il_policy_bean.getPOL_SYS_ID().toString());
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_END_NO_IDX",
					pt_il_policy_bean.getPOL_END_NO_IDX().toString());

			//  CALL_FORM('PILT022',NO_HIDE,NO_REPLACE);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "PILT022";
	}

	public String claimButtonAction() {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		try {
			String CLAIM_CALLING_FORM = CommonUtils.getGlobalVariable("CLAIM_CALLING_FORM");
			CommonUtils.setGlobalVariable("CALLING_FORM","PILT002_APAC");
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_CLM_POL_SERCH",
					"FALSE");
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_CLM_POL_NO",
					pt_il_policy_bean.getPOL_NO());
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_END_NO_IDX",
					pt_il_policy_bean.getPOL_END_NO_IDX().toString());
			if(CLAIM_CALLING_FORM!=null && !CLAIM_CALLING_FORM.isEmpty() && CLAIM_CALLING_FORM.equalsIgnoreCase("PILT002_APAC")){
				CommonUtils.setGlobalVariable("CLAIM_CALLING_FORM","PILT006_APAC");
			}else if (CLAIM_CALLING_FORM!=null && !CLAIM_CALLING_FORM.isEmpty() && CLAIM_CALLING_FORM.equalsIgnoreCase("PILT006_APAC")){
				//CommonUtils.setGlobalVariable("CLAIM_CALLING_FORM","PILT006_APAC");
			}
			//  CALL_FORM('PILQ104_APAC',NO_HIDE,NO_REPLACE);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//return "PILQ104_APAC";
		return "PILT006_POL_CLM_APAC";
	}

	public String upiButtonAction() {
		//  GO_BLOCK('PT_IL_UNPAID_PREM_DTLS');
		return "PILT002_APAC_PT_IL_UNPAID_PREM_DTLS";
	}

	public String fundDtlButtonAction() {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		/*Added by saranya fro Unit Link product as per the Girish Suggestion on 13/02/2017*/
		try {
			P9ILPK_POLICY.P_INS_POL_FUND_DTL(pt_il_policy_bean.getPOL_SYS_ID().toString());
		} catch (ProcedureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*End*/
		return "PILT002_APAC_PT_IL_POL_FUND_DTL";
	}

	public String customerButtonAction() {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		String outCome = null;
		try {
			outCome = dummy_helper
					.UI_M_BUT_CUSTOMER_WHEN_BUTTON_PRESSED(pt_il_policy_bean);
		} catch (Exception e) {
			// TODO: handle exception
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
					"customer", e.getMessage());
			e.printStackTrace();
		}
		return outCome;
	}

	public String statusOkButtonAction()throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		String outCome = "PILT002_APAC_PT_IL_POLICY";
		String message = null;
		try {
			Long POL_SYS_ID1=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
			if(!(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_PS_STATUS().equalsIgnoreCase("B08"))){
				if("".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_PS_REASON_CODE())|| compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_PS_REASON_CODE()==null){
					outCome="";
					throw new ValidatorException(new FacesMessage("Reason Code:Validation Error: Value is required"));
				}
			}
			dummy_helper
					.UI_M_BUT_STATUS_OK_WHEN_BUTTON_PRESSED(compositeAction);
			//[Added by akash ..Updated value in bean must be Update on table.
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().saveRecord();
			
			String pro=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE();
			System.out.println("value of product code->"+pro);
			Long POL_SYS_ID=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
			System.out.println("value of POL_SYS_ID->"+POL_SYS_ID);
			
			
			/*Modified  by ganesh on 20-06-2017, ZBILQC-1725314 */
			System.out.println("Selected status ["+DUMMY_BEAN.getUI_M_PS_STATUS()+"]");
			/*ZBILQC-1731915 
			 * If we chose B25 status we need to send email to RI Customer so that 
			 * we are setting flag as C other than B25 we are setting and sending mail flag based on the
			 * source of business.
			 * suggested by Siva 
			 */
			/*Commented  by ganesh on 03-08-2017, ZBILQC-1731915  */
			/*String setMailType = null;
			if(DUMMY_BEAN.getUI_M_PS_STATUS().equalsIgnoreCase("B06")){ //Declined
				setMailType = "PRD";
			}else if(DUMMY_BEAN.getUI_M_PS_STATUS().equalsIgnoreCase("B07")){ //Postponed
				setMailType = "PRP";
			}else{
				setMailType = "PRS";
			}*/
			/*end*/
			/*Added  by ganesh on 03-08-2017,  ZBILQC-1731915 */
			String setCustType = "C";
			if(DUMMY_BEAN.getPS_RI_CODE()!=null && !DUMMY_BEAN.getPS_RI_CODE().equalsIgnoreCase("")){
				setCustType = "C";
			}else{
				setCustType = (CommonUtils.nvl(pt_il_policy_bean.getPOL_SRC_OF_BUS(),"001")).equalsIgnoreCase("075")?"B":"C";
			}
			/*end*/
			
			/*Newly added by pidugu raj dt: 22-11-2018 as suggested by sivaraman for redirecting to proposal page if B08 selected and clicked on ok button*/
			
			if(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_PS_STATUS().equalsIgnoreCase("B08")){
				FacesContext.getCurrentInstance().getExternalContext().redirect("PILT002_APAC_PT_IL_POLICY.jsf");
			}
			/*End Newly added by pidugu raj dt: 22-11-2018 as suggested by sivaraman for redirecting to proposal page if B08 selected and clicked on ok button*/
			message = emailStatusMsg(pro, CommonUtils.nvl(DUMMY_BEAN.getUI_M_PS_STATUS(),"PRS"), POL_SYS_ID.toString(), setCustType, "");
			
			/*String procoutput=emailTriggerProcCall(pro, setMailType ,POL_SYS_ID.toString(),"C","");
			System.out.println("procoutput------->"+procoutput);
		    if("Y".equalsIgnoreCase(procoutput)){
		    	System.out.println("inside the if condition");
						message=" Your Proposal Status Mail sent su	cessfully";		
					}else{
						if("T".equalsIgnoreCase(procoutput))
						{
							message=", Email template is unavailable in master setup for Proposal Pending";
						}
						else
						{
						System.out.println("Customer type-->");
					
							//message="Unable to send mail to Customer due to emailId is not available";
							message = ", Unable to send the email due to the unavailability of Customer email id";
						}
				}*/
			/*end*/
			//Added by akash ..Updated value in bean must be Update on table.]
			message ="Status updated successfully"+message;
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
					"OK", message);
			//newly added to change status to cancelled
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ADDL_STATUS().equalsIgnoreCase("B05")){
				Connection connection = CommonUtils.getConnection();
				String query2= "UPDATE PT_IL_POLICY SET POL_APPRV_STATUS ='C' WHERE POL_SYS_ID=? AND  POL_ADDL_STATUS IN ('B05')";
				new CRUDHandler().executeUpdateStatement(query2,connection, new Object[] { pt_il_policy_bean.getPOL_SYS_ID()});
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
				//compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_APPRV_STATUS("C");
			}
			
			COMP_UI_M_PS_STATUS.setSubmittedValue("");
			COMP_UI_M_POL_ADDL_STATUS_DESC.setSubmittedValue("");
			
			/*Added by Ram on 06/12/2016 for displaying Status details in Datagrid*/
			fetchStatusDatas();
			/*End*/
			
			/*Newly Added By Dhinesh on for ssp call id : ZBILQC-1731626*/
			if(CommonUtils.isIN(CommonUtils.nvl(DUMMY_BEAN.getUI_M_PS_STATUS(), "X"),"B04"))
			{
			PR_IL_INS_SUB_STD_REG_01(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_CUST_CODE());
			}
			/* End */
			
			/*Added by saranya on 07-12-2016 for RM018T - FSD_IL_ZB Life_013_Underwriting changes*/
			ArrayList<String> returnList = new ArrayList<String>();
			returnList=dummy_helper.callProcP_POL_ISSUE_DT(POL_SYS_ID1);
			if(returnList!=null){
			String P_START_DT_OLD = returnList.get(0);
			String P_START_DT_NEW = returnList.get(1);
			int POL_END_NO_IDX=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX();
			if((compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_PS_STATUS().equalsIgnoreCase("B08"))&&(0==POL_END_NO_IDX))
			{
				System.out.println("POL_START_DT_OLD  :"+P_START_DT_OLD);
				System.out.println("POL_START_DT_NEW  :"+P_START_DT_NEW);
				
				/*Commentted &Modified by saritha on 20-11-2017 for ssp call id : ZBLIFE-1455330*/
				
				/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String  POL_START_DT_OLD = simpleDateFormat.format(P_START_DT_OLD);
				String POL_START_DT_NEW = simpleDateFormat.format(P_START_DT_NEW);*/
				//if(!P_START_DT_OLD=(POL_START_DT_NEW))
				
				DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd");
				Date POL_START_DT_OLD = srcDf.parse(P_START_DT_OLD);
				Date POL_START_DT_NEW = srcDf.parse(P_START_DT_NEW);

				DateFormat destDf = new SimpleDateFormat("dd/MM/yyyy");
				String P_START_OLD_DT = destDf.format(POL_START_DT_OLD);
				String P_START_NEW_DT = destDf.format(POL_START_DT_NEW);
				
				/*Newly added By Dhinesh on 27/3/2018 for Date of Commencement issue*/ 
				String IL_POL_STDT = CommonUtils.getPPSystemParameterValue("IL_POL_STDT").toString();
				System.out.println("IL_POL_STDT    : "+IL_POL_STDT);
				if("1".equalsIgnoreCase(IL_POL_STDT))
				{
					if(!P_START_OLD_DT.equals(P_START_NEW_DT))
					{

						/*End*/
						changeTerm(pt_il_policy_bean,compositeAction);
						System.out.println("POL_START_DT  :"+POL_START_DT);
						System.out.println("POL_EXPIRY_DT  :"+POL_EXPIRY_DT);
						//Date STATUS_DT=compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_PS_STATUS_DT();
						SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
						String POL_START_DATE = simpleDateFormat1.format(POL_START_DT);
						String POL_EXPIRY_DATE = simpleDateFormat1.format(POL_EXPIRY_DT);
						getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
						getCOMP_ISS_DT().setValue("As there is no change in Premium, Policy start and end dates are changed to"+" "+ POL_START_DATE +" "+"and "+" "+POL_EXPIRY_DATE+" "+" correspondingly.");
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_POP_UP_MSG("As there is no change in Premium, Policy start and end dates are changed to"+ POL_START_DATE +"and "+POL_EXPIRY_DATE+" correspondingly.");
						outCome = "PILT002_APAC_PT_IL_POLICY";
					}
				}
				
			}
			}
			/*End*/
			
		} catch (Exception e) {
			outCome = null;
			e.printStackTrace();
			getErrorMap().put(
					"customer", e.getMessage());
			getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
		return outCome;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String contractorButtonAction() {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
		String outCome = null;
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		try {
			outCome = dummy_helper
					.UI_M_BUT_CONTRACTOR_WHEN_BUTTON_PRESSED(pt_il_policy_bean);
		} catch (Exception e) {
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
					"contractor", e.getMessage());
			e.printStackTrace();
		}
		return outCome;
	}

	public String keycommitButtonAction() {
		
		/*CommonUtils.setGlobalVariable("GLOBAL.ISPRMCALC", "TRUE");*/
		DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
		String outcome = null;
		String message = null;
		CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		
		//added code to hide the rate field when click edit option in premium breakup details screen.
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_PDL_RATE().setRendered(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate_LOD_LABEL().setRendered(false);
		
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate().setRendered(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate_DIS_LABEL().setRendered(false);
		
		
		
		try {
			//ADDED BY SARANYA FOR BMI & SM
			Double bmi=compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_BMI();
			Double sal=compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FC_SALARY();
			Double sum_ass=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FC_SUM_ASSURED();
			String sys_value=PT_IL_POLICY_ACTION_BEAN.getsysparameter();
			int sys_SA=Integer.parseInt( sys_value);
			String b =actionBean.getsysparameter();
			int getbmi=Integer.parseInt( b);
			System.out.println("param sum Assured value:"+sys_SA);
			System.out.println("param bmi value:"+getbmi);
			CommonUtils.clearMaps(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
			String message1=null;
			String message2=null;
			String message3=null;
			//String message4=null;
			/*
			 * Added By Dhinesh for Quick quote - after converting into proposal while calculation of premium medical is not getting defaulted due to occupation code.*/
			
			/*    ADDED BY DHINESH FOR SSP CALL ID  : FALCONQC-1716975     */
			
			/*
			 * 
			 * Commented by sankara narayanan for Business Rule issue same validation was done in Key Commit Procedure on 04-03-2017
			 * 
			 * PT_IL_POLICY_ACTION_BEAN.COVER_SUM_SA_Validation(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().toString(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_TYPE(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());*/
			
			
			/* END */
			
			String occupation_Code=null;
			
			occupation_Code=PT_IL_POLICY_ACTION_BEAN.getoccupation_Code(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString());
			System.out.println("occupation_Code   Value   :  "+occupation_Code);
			
/*	Modiifed by Shankar on 27/03/2017		
 * if(occupation_Code != null)
			{*/
			
			
			/*Added by sankara narayanan on 03/04/2017*/
			/*
			 * Commented by sankara narayanan on 25/04/2017
			 * 
			 * if("L".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE())){*/
			/*changed by sankara narayanan for hospital cash plan on 25/04/2017*/
			if("L".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE()) || "H".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE())){
				//end
				if(CommonUtils.nvl(sum_ass,0.0)>sys_SA)
				{
					message2 = "Sum assured exceeded the defined value of "+sys_SA+" - Required Financial questionnaire";
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
							"TOGGLE2", message2);
				}
				if((CommonUtils.nvl(sum_ass,0.0)<=sys_SA)&&(bmi<=getbmi))
				{
					//message4="Premium Calculated Successfully";
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Premium Calculated Successfully ");

					compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Premium Calculated Successfully ");
				}

				saveRecord(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
				outcome = dummy_helper.keyCommit(compositeAction);
				//COMMENTED BY SUJATA FOR Data has been updated by another user. Re-query to see change ISSUE FIXING
				//saveRecord(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
				System.out.println("Policy Bean upd dt after prem calc"+	
						CommonUtils.dateToPELStringFormatterWithTimeStamp(compositeAction.
								getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_UPD_DT()));

				if ("Y".equalsIgnoreCase(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_JOINT_LIFE_YN())) {
					Connection con = CommonUtils.getConnection();
					String updateQuery = "UPDATE PT_IL_POLICY SET POL_JOINT_LIFE_AGE =? WHERE POL_SYS_ID =?";
					new CRUDHandler()
					.executeUpdateStatement(updateQuery, con,
							new Object[] {
							compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN()
							.getPOL_JOINT_LIFE_AGE(),
							compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN()
							.getPOL_SYS_ID() });
					CommonUtils.getConnection().commit();
				}
				new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
				new PT_IL_POLICY_HELPER().POST_QUERY(compositeAction);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().setPOL_FLEX_20("Y");
				helper.autoUnderwritingValidate(compositeAction);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getHelper().executeQuery(compositeAction);

			}else if("U".equalsIgnoreCase(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE())){

				if(("Y".equalsIgnoreCase(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPROD_RISK_FLG()))|| (new PILT002_APAC_LOCAL_PROCEDURES().L_RIDER_CHECK(compositeAction
								.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
								.getPOL_SYS_ID()))){



					if(occupation_Code != null)
					{

						if(CommonUtils.nvl(sum_ass,0.0)>sys_SA)
						{
							message2 = "Sum assured exceeded the defined value of "+sys_SA+" - Required Financial questionnaire";
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
									"TOGGLE2", message2);
						}


						if(bmi>getbmi){

							message3="BMI should not exceed "+getbmi;
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
									"TOGGLE3", message3);
						}


						if((CommonUtils.nvl(sum_ass,0.0)>sys_SA)||(bmi>getbmi)){


							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
									PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "WARNING MESSAGE");

						}


						if((CommonUtils.nvl(sum_ass,0.0)<=sys_SA)&&(bmi<=getbmi))
						{
							//message4="Premium Calculated Successfully";
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
									PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Premium Calculated Successfully ");

							compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getWarningMap().put(
									PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Premium Calculated Successfully ");
						}



						saveRecord(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
						outcome = dummy_helper.keyCommit(compositeAction);

						System.out.println("Policy Bean upd dt after prem calc"+	
								CommonUtils.dateToPELStringFormatterWithTimeStamp(compositeAction.
										getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_UPD_DT()));

						if ("Y".equalsIgnoreCase(compositeAction
								.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
								.getPOL_JOINT_LIFE_YN())) {
							Connection con = CommonUtils.getConnection();
							String updateQuery = "UPDATE PT_IL_POLICY SET POL_JOINT_LIFE_AGE =? WHERE POL_SYS_ID =?";
							new CRUDHandler()
							.executeUpdateStatement(updateQuery, con,
									new Object[] {
									compositeAction
									.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN()
									.getPOL_JOINT_LIFE_AGE(),
									compositeAction
									.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN()
									.getPOL_SYS_ID() });
							CommonUtils.getConnection().commit();
						}
						new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
						new PT_IL_POLICY_HELPER().POST_QUERY(compositeAction);

						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().setPOL_FLEX_20("Y");
						helper.autoUnderwritingValidate(compositeAction);

						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getHelper().executeQuery(compositeAction);

					}
					else
					{
						/*
						 * modified by Ameen as per Thiag Sir sugg. on 10-05-2017
						 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Please Enter Occupation Code before Calculating  Premium ");

						compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getErrorMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Please Enter Occupation Code before Calculating  Premium ");*/
						
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Please enter the Assured Details to calculate premium ");

						compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Please enter the Assured Details to calculate premium ");
					}


				}else{
					if(CommonUtils.nvl(sum_ass,0.0)>sys_SA)
					{
						message2 = "Sum assured exceeded the defined value of "+sys_SA+" - Required Financial questionnaire";
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
								"TOGGLE2", message2);
					}

					
					if((CommonUtils.nvl(sum_ass,0.0)<=sys_SA))
					{
						//message4="Premium Calculated Successfully";
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Premium Calculated Successfully ");

						compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Premium Calculated Successfully ");
					}

					saveRecord(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
					outcome = dummy_helper.keyCommit(compositeAction);
					//COMMENTED BY SUJATA FOR Data has been updated by another user. Re-query to see change ISSUE FIXING
					//saveRecord(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
					

					if ("Y".equalsIgnoreCase(compositeAction
							.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
							.getPOL_JOINT_LIFE_YN())) {
						Connection con = CommonUtils.getConnection();
						String updateQuery = "UPDATE PT_IL_POLICY SET POL_JOINT_LIFE_AGE =? WHERE POL_SYS_ID =?";
						new CRUDHandler()
						.executeUpdateStatement(updateQuery, con,
								new Object[] {
								compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN()
								.getPOL_JOINT_LIFE_AGE(),
								compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN()
								.getPOL_SYS_ID() });
						CommonUtils.getConnection().commit();
					}
					new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
					new PT_IL_POLICY_HELPER().POST_QUERY(compositeAction);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().setPOL_FLEX_20("Y");
					helper.autoUnderwritingValidate(compositeAction);
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getHelper().executeQuery(compositeAction);

				}

			}
			else{
			System.out.println("compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE()"+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE());
			if(occupation_Code != null||"L".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE()))
			{
				/*
				 * COMMENTED BY AMEEN ON 03-02-2017 AS PER HANDS ON FEEDBACK POINT :
				 * financial underwriting message reoccurring even after providing Salary details (6 times of salary)
				 * if((sal*6)<sum_ass)
				{

					  message1="Sum assured should not exceed than annual income of 6 times";
					  compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
								"TOGGLE1", message1);
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				}
				END
				*/
				/*modified by saranya on 24-03-2017 */
				if(CommonUtils.nvl(sum_ass,0.0)>sys_SA)
				{
					message2 = "Sum assured exceeded the defined value of "+sys_SA+" - Required Financial questionnaire";
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
							"TOGGLE2", message2);
				}

				/*Added by Shankar on 27/03/2017*/		
				if(!("L".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE()))){
					/*End*/
					
					/*Added by Janani on 27.04.2018 for null check*/
					System.out.println("bmi              "+bmi+"   getbmi     "+getbmi);
					if((bmi != null && getbmi != 0) && bmi>getbmi){

						/*if(bmi>getbmi){*/

						/*End*/
						
					message3="BMI should not exceed "+getbmi;
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
							"TOGGLE3", message3);
				}
				
				
				/*
				 * COMMENTED BY AMEEN ON 03-02-2017 AS PER HANDS ON FEEDBACK POINT :
				 * financial underwriting message reoccurring even after providing Salary details (6 times of salary)
				 * 
				 * 
				 * if(((sal*6)<sum_ass)||(sum_ass>sys_SA)||(bmi>getbmi)){*/
				
				/*Modified by Saranya on 28/03/2017
				 * 
				 * if((sum_ass>sys_SA)||(bmi>getbmi)){*/
				if((CommonUtils.nvl(sum_ass,0.0)>sys_SA)||(CommonUtils.nvl(bmi, 0.0) > CommonUtils.nvl(getbmi, 0))){
				
				
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "WARNING MESSAGE");
				
				}

				
				/*
				 * COMMENTED BY AMEEN ON 03-02-2017 AS PER HANDS ON FEEDBACK POINT :
				 * financial underwriting message reoccurring even after providing Salary details (6 times of salary)
				 * 
				 * 
				 * if(((sal*6)>=sum_ass)&&(sum_ass<=sys_SA)&&(bmi<=getbmi))*/
				
				/*modified by saranya on 24-03-2017 */
				/*if((CommonUtils.nvl(sum_ass,0.0)<=sys_SA)&&(bmi<=getbmi))*/
				if((CommonUtils.nvl(sum_ass,0.0)<=sys_SA)&&(CommonUtils.nvl(bmi, 0.0) <= CommonUtils.nvl(getbmi, 0)))
				{
					//message4="Premium Calculated Successfully";
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Premium Calculated Successfully ");
			
					compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Premium Calculated Successfully ");
				}
				//end
				
				//save the Policy details before calling key commit
				
			//	minAgeonMaturity(compositeAction);

				}
				
				saveRecord(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
				outcome = dummy_helper.keyCommit(compositeAction);
				//COMMENTED BY SUJATA FOR Data has been updated by another user. Re-query to see change ISSUE FIXING
				//saveRecord(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
				System.out.println("Policy Bean upd dt after prem calc"+	
						CommonUtils.dateToPELStringFormatterWithTimeStamp(compositeAction.
								getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_UPD_DT()));
				
				if ("Y".equalsIgnoreCase(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_JOINT_LIFE_YN())) {
					Connection con = CommonUtils.getConnection();
					String updateQuery = "UPDATE PT_IL_POLICY SET POL_JOINT_LIFE_AGE =? WHERE POL_SYS_ID =?";
					new CRUDHandler()
							.executeUpdateStatement(updateQuery, con,
									new Object[] {
											compositeAction
													.getPT_IL_POLICY_ACTION_BEAN()
													.getPT_IL_POLICY_BEAN()
													.getPOL_JOINT_LIFE_AGE(),
											compositeAction
													.getPT_IL_POLICY_ACTION_BEAN()
													.getPT_IL_POLICY_BEAN()
													.getPOL_SYS_ID() });
	                    CommonUtils.getConnection().commit();
				}
				new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
				new PT_IL_POLICY_HELPER().POST_QUERY(compositeAction);
				/*compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put(
						"KEY_COMMIT", message);
				
				compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getWarningMap().put(
						"KEY_COMMIT", message);*/
				
				
				/*commented by Janani on 11.07.2018 for FLALIFEQC-1756799 
				 * 
				 * compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().setPOL_FLEX_20("Y");*/
				
				
				helper.autoUnderwritingValidate(compositeAction);
				//added for threshold limit refresh problem
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getHelper().executeQuery(compositeAction);
			
			}
			else
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Please Enter Occupation Code before Calculating  Premium ");
				
				/*ADDED BY DHINESH ON 7.10.2016*/

				compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Please Enter Occupation Code before Calculating  Premium ");

				/*END*/

			}
			
			}
			
			/*Added by saranya for for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 22-03-2017*/
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
			
			
			/*Added by Janani as per Sivaram suggestion*/
			System.out.println("getPOL_UL_PREM_CALC  in prem calc function                     "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_UL_PREM_CALC());
			
			
			
			
			/* Added By Saritha on 10.8.2017 */
			if("D".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_UL_PREM_CALC()) && ("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())))
			{
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPremium_Amt();
			
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_FC_SUM_ASSURED(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPREM_AMT());
			/*Added by saritha on 23-08-2017 for Education & Endowment Product Issues*/ 
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_LC_SUM_ASSURED(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FC_SUM_ASSURED());
			/*End*/
			
			System.out.println("last of prem calc function         "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FC_SUM_ASSURED());
			}
			
			/*End*/
			
			/*added by raja on 01-06-2017 for ZBILQC-1730166*/
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX()>0)
			{
				//compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_FRZ_FLAG().setDisabled(false);
				CommonUtils.setGlobalVariable("GLOBAL.FRZ_FLAG","Y");
			}
			
			/*end*/
			/*End*/
			
			
			/*Added by Janani on 11.07.2018 for FLALIFEQC-1756799*/
			if(!compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE().equalsIgnoreCase("i"))
			{
				validateSA_range();
			}
			/*End of FLALIFEQC-1756799*/
			
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			
			compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(
					"KEY_COMMIT", e.getMessage());
			compositeAction.getPT_IL_POLICY2_ACTION_BEAN().getErrorMap().put(
					"KEY_COMMIT", e.getMessage());
			
			
		
		
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "KEY_COMMIT", compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getWarningMap());
			
				ErrorHelpUtil.getWarningForProcedure(
				          CommonUtils.getConnection(), "KEY_COMMIT", this.compositeAction
				          .getPT_IL_POLICY2_ACTION_BEAN().getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}

		return outcome;
	}
	public void saveRecord(PT_IL_POLICY_ACTION pt_il_policy_action) throws Exception{
		String message = null;
		PT_IL_POLICY_HELPER helper = new PT_IL_POLICY_HELPER();
		try {
			if (pt_il_policy_action.getPT_IL_POLICY_BEAN().getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.PRE_UPDATE(compositeAction);
					new CRUDHandler().executeUpdate(pt_il_policy_action
							.getPT_IL_POLICY_BEAN(), CommonUtils
							.getConnection());
					helper.POST_UPDATE(pt_il_policy_action
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),compositeAction);
				}
			} else {
				if (isINSERT_ALLOWED()) {
					helper.PRE_INSERT(compositeAction);
					new CRUDHandler().executeInsert(pt_il_policy_action
							.getPT_IL_POLICY_BEAN(), CommonUtils
							.getConnection());
					helper.POST_INSERT(compositeAction);
				}
			}
			CommonUtils.getConnection().commit();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			
			throw new Exception(e.getMessage());
		}
	}

	public String instPaymt1() {
		return "PILT002_APAC_PT_IL_POL_SA_INST_PYMT_HEAD";
	}

	public String instPaymt() {
		return "PILT002_APAC_PT_IL_POL_SA_INST_PYMT_HEAD";
	}

	public HtmlOutputLabel getCOMP_UI_M_BUS_STATUS() {
		return COMP_UI_M_BUS_STATUS;
	}

	public void setCOMP_UI_M_BUS_STATUS(HtmlOutputLabel comp_ui_m_bus_status) {
		COMP_UI_M_BUS_STATUS = comp_ui_m_bus_status;
	}

	public HtmlOutputLabel getCOMP_UI_M_END_STATUS() {
		return COMP_UI_M_END_STATUS;
	}

	public void setCOMP_UI_M_END_STATUS(HtmlOutputLabel comp_ui_m_end_status) {
		COMP_UI_M_END_STATUS = comp_ui_m_end_status;
	}

	public HtmlOutputLabel getCOMP_UI_M_ADDL_STATUS_DESC() {
		return COMP_UI_M_ADDL_STATUS_DESC;
	}

	public void setCOMP_UI_M_ADDL_STATUS_DESC(
			HtmlOutputLabel comp_ui_m_addl_status_desc) {
		COMP_UI_M_ADDL_STATUS_DESC = comp_ui_m_addl_status_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_END_IDX_TYPE_NO() {
		return COMP_UI_M_END_IDX_TYPE_NO;
	}

	public void setCOMP_UI_M_END_IDX_TYPE_NO(
			HtmlOutputLabel comp_ui_m_end_idx_type_no) {
		COMP_UI_M_END_IDX_TYPE_NO = comp_ui_m_end_idx_type_no;
	}

	public HtmlOutputLabel getCOMP_UI_M_AMEND_IDX() {
		return COMP_UI_M_AMEND_IDX;
	}

	public void setCOMP_UI_M_AMEND_IDX(HtmlOutputLabel comp_ui_m_amend_idx) {
		COMP_UI_M_AMEND_IDX = comp_ui_m_amend_idx;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLM_ADDL_STATUS() {
		return COMP_UI_M_CLM_ADDL_STATUS;
	}

	public void setCOMP_UI_M_CLM_ADDL_STATUS(
			HtmlOutputLabel comp_ui_m_clm_addl_status) {
		COMP_UI_M_CLM_ADDL_STATUS = comp_ui_m_clm_addl_status;
	}

	public HtmlOutputLabel getCOMP_UI_M_CIC_STATUS() {
		return COMP_UI_M_CIC_STATUS;
	}

	public void setCOMP_UI_M_CIC_STATUS(HtmlOutputLabel comp_ui_m_cic_status) {
		COMP_UI_M_CIC_STATUS = comp_ui_m_cic_status;
	}

	public HtmlOutputLabel getCOMP_UI_M_WAI_STATUS() {
		return COMP_UI_M_WAI_STATUS;
	}

	public void setCOMP_UI_M_WAI_STATUS(HtmlOutputLabel comp_ui_m_wai_status) {
		COMP_UI_M_WAI_STATUS = comp_ui_m_wai_status;
	}

	public HtmlOutputLabel getCOMP_UI_M_HOLD_STATUS() {
		return COMP_UI_M_HOLD_STATUS;
	}

	public void setCOMP_UI_M_HOLD_STATUS(HtmlOutputLabel comp_ui_m_hold_status) {
		COMP_UI_M_HOLD_STATUS = comp_ui_m_hold_status;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CONVERT_YN() {
		return COMP_UI_M_POL_CONVERT_YN;
	}

	public void setCOMP_UI_M_POL_CONVERT_YN(
			HtmlOutputLabel comp_ui_m_pol_convert_yn) {
		COMP_UI_M_POL_CONVERT_YN = comp_ui_m_pol_convert_yn;
	}

	public HtmlOutputLabel getCOMP_POL_APPRV_UID() {
		return COMP_POL_APPRV_UID;
	}

	public void setCOMP_POL_APPRV_UID(HtmlOutputLabel comp_pol_apprv_uid) {
		COMP_POL_APPRV_UID = comp_pol_apprv_uid;
	}

	public HtmlOutputLabel getCOMP_POL_TRAN_DT() {
		return COMP_POL_TRAN_DT;
	}

	public void setCOMP_POL_TRAN_DT(HtmlOutputLabel comp_pol_tran_dt) {
		COMP_POL_TRAN_DT = comp_pol_tran_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_ICON_HINT() {
		return COMP_UI_M_ICON_HINT;
	}

	public void setCOMP_UI_M_ICON_HINT(HtmlOutputLabel comp_ui_m_icon_hint) {
		COMP_UI_M_ICON_HINT = comp_ui_m_icon_hint;
	}

	public HtmlCalendar getCOMP_UI_M_PS_STATUS_DT() {
		return COMP_UI_M_PS_STATUS_DT;
	}

	public void setCOMP_UI_M_PS_STATUS_DT(HtmlCalendar comp_ui_m_ps_status_dt) {
		COMP_UI_M_PS_STATUS_DT = comp_ui_m_ps_status_dt;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MATURITY() {
		return COMP_UI_M_BUT_MATURITY;
	}

	public void setCOMP_UI_M_BUT_MATURITY(
			HtmlCommandButton comp_ui_m_but_maturity) {
		COMP_UI_M_BUT_MATURITY = comp_ui_m_but_maturity;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText comp_ui_m_pol_no) {
		COMP_UI_M_POL_NO = comp_ui_m_pol_no;
	}

	public HtmlInputText getCOMP_UI_M_PROP_NO() {
		return COMP_UI_M_PROP_NO;
	}

	public void setCOMP_UI_M_PROP_NO(HtmlInputText comp_ui_m_prop_no) {
		COMP_UI_M_PROP_NO = comp_ui_m_prop_no;
	}

	public HtmlCalendar getCOMP_UI_M_CONV_DT() {
		return COMP_UI_M_CONV_DT;
	}

	public void setCOMP_UI_M_CONV_DT(HtmlCalendar comp_ui_m_conv_dt) {
		COMP_UI_M_CONV_DT = comp_ui_m_conv_dt;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_COPY() {
		return COMP_UI_M_BUT_COPY;
	}

	public void setCOMP_UI_M_BUT_COPY(HtmlCommandButton comp_ui_m_but_copy) {
		COMP_UI_M_BUT_COPY = comp_ui_m_but_copy;
	}

	public HtmlInputText getCOMP_UI_M_POL_DOC_DESC() {
		return COMP_UI_M_POL_DOC_DESC;
	}

	public void setCOMP_UI_M_POL_DOC_DESC(HtmlInputText comp_ui_m_pol_doc_desc) {
		COMP_UI_M_POL_DOC_DESC = comp_ui_m_pol_doc_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROP_NO_LABEL() {
		return COMP_UI_M_PROP_NO_LABEL;
	}

	public void setCOMP_UI_M_PROP_NO_LABEL(
			HtmlOutputLabel comp_ui_m_prop_no_label) {
		COMP_UI_M_PROP_NO_LABEL = comp_ui_m_prop_no_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONV_DT_LABEL() {
		return COMP_UI_M_CONV_DT_LABEL;
	}

	public void setCOMP_UI_M_CONV_DT_LABEL(
			HtmlOutputLabel comp_ui_m_conv_dt_label) {
		COMP_UI_M_CONV_DT_LABEL = comp_ui_m_conv_dt_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel comp_ui_m_pol_no_label) {
		COMP_UI_M_POL_NO_LABEL = comp_ui_m_pol_no_label;
	}

	public HtmlOutputLabel getCOMP_COMP_UI_M_POL_DOC_CODE_LABEL() {
		return COMP_COMP_UI_M_POL_DOC_CODE_LABEL;
	}

	public void setCOMP_COMP_UI_M_POL_DOC_CODE_LABEL(
			HtmlOutputLabel comp_comp_ui_m_pol_doc_code_label) {
		COMP_COMP_UI_M_POL_DOC_CODE_LABEL = comp_comp_ui_m_pol_doc_code_label;
	}

	public List<com.iii.premia.common.bean.LovBean> lovUI_M_POL_DOC_CODE(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "DUMMY",
					"M_POL_DOC_CODE", null, null, null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public HtmlOutputLabel getCOMP_FORM_CONVERT_CAPTION() {
		return COMP_FORM_CONVERT_CAPTION;
	}

	public void setCOMP_FORM_CONVERT_CAPTION(
			HtmlOutputLabel comp_form_convert_caption) {
		COMP_FORM_CONVERT_CAPTION = comp_form_convert_caption;
	}

	/**
	 * Instantiates all components in DUMMY_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_UI_M_POL_DOC_CODE = new HtmlInputText();
		COMP_UI_M_POL_DOC_DESC = new HtmlInputText();
		COMP_UI_M_PS_STATUS = new HtmlInputText();
		COMP_UI_M_POL_NO = new HtmlInputText();
		COMP_UI_M_PROP_NO = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_FORM_CONVERT_CAPTION = new HtmlOutputLabel();
		COMP_UI_M_APPRV_STATUS = new HtmlOutputLabel();
		COMP_UI_M_ICON_HINT = new HtmlOutputLabel();
		COMP_UI_M_BUS_STATUS = new HtmlOutputLabel();
		COMP_UI_M_END_STATUS = new HtmlOutputLabel();
		COMP_UI_M_ADDL_STATUS_DESC = new HtmlOutputLabel();
		COMP_UI_M_END_IDX_TYPE_NO = new HtmlOutputLabel();
		COMP_UI_M_AMEND_IDX = new HtmlOutputLabel();
		COMP_UI_M_CLM_ADDL_STATUS = new HtmlOutputLabel();
		COMP_UI_M_CIC_STATUS = new HtmlOutputLabel();
		COMP_UI_M_WAI_STATUS = new HtmlOutputLabel();
		COMP_UI_M_HOLD_STATUS = new HtmlOutputLabel();
		COMP_POL_APPRV_UID = new HtmlOutputLabel();
		COMP_POL_TRAN_DT = new HtmlOutputLabel();
		COMP_UI_M_POL_CONVERT_YN = new HtmlOutputLabel();
		COMP_UI_M_PROP_NO_LABEL = new HtmlOutputLabel();
		COMP_UI_M_CONV_DT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_NO_LABEL = new HtmlOutputLabel();
		COMP_COMP_UI_M_POL_DOC_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_DOC_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_NO_LABEL = new HtmlOutputLabel();
		// Instantiating HtmlCalendar
		COMP_UI_M_PS_STATUS_DT = new HtmlCalendar();
		COMP_UI_M_CONV_DT = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_ENDT = new HtmlCommandLink();
		COMP_UI_M_BUT_COPY = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVAL = new HtmlCommandLink();
		COMP_UI_M_BUT_CUSTOMER = new HtmlCommandLink();
		COMP_UI_M_BUT_CONTRACTOR = new HtmlCommandButton();
		COMP_UI_M_BUT_HOLD = new HtmlCommandButton();
		COMP_UI_M_BUT_FUND_DTL = new HtmlCommandLink();
		COMP_UI_M_BUT_OCC_RATE_PAYOR = new HtmlCommandButton();
		COMP_UI_M_BUT_OCC_RATE_PAYEE = new HtmlCommandButton();
		COMP_UI_M_BUT_DOC_GEN_NO = new HtmlCommandLink();
		COMP_UI_M_BUT_FUND_QUERY = new HtmlCommandLink();
		COMP_UI_M_BUT_ADD_DETAILS = new HtmlCommandButton();
		COMP_UI_M_BUT_MORE_COVER = new HtmlCommandButton();
		COMP_UI_M_BUT_UDDATE_STAT = new HtmlCommandLink();
		COMP_UI_M_BUT_PRMDTLS = new HtmlCommandLink();
		COMP_UI_M_BUT_POL_AMDT = new HtmlCommandButton();
		COMP_UI_M_BUT_CALC_DISC_LOAD = new HtmlCommandButton();
		COMP_UI_M_BUT_ANN_DTLS = new HtmlCommandLink();
		COMP_UI_M_BUT_CONVERT = new HtmlCommandLink();
		COMP_UI_M_BUS_RUL = new HtmlCommandLink();
		COMP_UI_M_BUT_PREM_ALLOC = new HtmlCommandLink();
		COMP_UI_M_BUT_SURR_MAT = new HtmlCommandLink();
		COMP_UI_M_BUT_UPI = new HtmlCommandLink();
		COMP_UI_M_BUT_UPLOAD = new HtmlCommandButton();
		COMP_UI_M_BUT_CLAIM = new HtmlCommandLink();
		COMP_UI_M_BUT_REPLACE_POLICY = new HtmlCommandButton();
		COMP_UI_M_BUT_ASSR_MORE_INFO = new HtmlCommandButton();
		COMP_UI_M_ENDT_QUOT = new HtmlCommandLink();
		COMP_UI_M_BUT_MATURITY = new HtmlCommandButton();

		 /*added by raja on 02-08-2017 for ZBILQC-1731915 */
		COMP_PS_RI_CODE=new HtmlInputText();
		COMP_PS_RI_CODE_DESC=new HtmlInputText();
		/*end*/
	}

	public String onBUT_MATURITYClicked() {
		String SIPH_NAV_TYPE = null;
		String outCome = null;
		SIPH_NAV_TYPE = compositeAction
				.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN()
				.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN().getSIPH_NAV_TYPE();
		if ("I".equalsIgnoreCase(CommonUtils.nvl(SIPH_NAV_TYPE, "A"))) {
			outCome = "PILT002_APAC_PT_IL_POL_SA_INST_PYMT";
		} else if ("B".equalsIgnoreCase(CommonUtils.nvl(SIPH_NAV_TYPE, "A"))
				|| "D".equalsIgnoreCase(CommonUtils.nvl(SIPH_NAV_TYPE, "A"))) {
			outCome = "PILT002_APAC_PT_IL_POL_SA_INST_PYMT1";
		} else {
			outCome = "";
		}
		return outCome;
	}

	public String buttonPressUI_M_BUT_STATUS_CANCEL() {
		return "PILT002_APAC_PT_IL_POLICY";
	}

	public HtmlCommandButton getCOMP_CONVERT_OK_BUT() {
		return COMP_CONVERT_OK_BUT;
	}

	public void setCOMP_CONVERT_OK_BUT(HtmlCommandButton comp_convert_ok_but) {
		COMP_CONVERT_OK_BUT = comp_convert_ok_but;
	}

	public HtmlInputText getCOMP_UI_M_PS_REASON_CODE() {
		return COMP_UI_M_PS_REASON_CODE;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_ENDT() {
		return COMP_UI_M_BUT_ENDT;
	}

	public void setCOMP_UI_M_BUT_ENDT(HtmlCommandLink comp_ui_m_but_endt) {
		COMP_UI_M_BUT_ENDT = comp_ui_m_but_endt;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_CUSTOMER() {
		return COMP_UI_M_BUT_CUSTOMER;
	}

	public void setCOMP_UI_M_BUT_CUSTOMER(HtmlCommandLink comp_ui_m_but_customer) {
		COMP_UI_M_BUT_CUSTOMER = comp_ui_m_but_customer;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_FUND_DTL() {
		return COMP_UI_M_BUT_FUND_DTL;
	}

	public void setCOMP_UI_M_BUT_FUND_DTL(HtmlCommandLink comp_ui_m_but_fund_dtl) {
		COMP_UI_M_BUT_FUND_DTL = comp_ui_m_but_fund_dtl;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_DOC_GEN_NO() {
		return COMP_UI_M_BUT_DOC_GEN_NO;
	}

	public void setCOMP_UI_M_BUT_DOC_GEN_NO(HtmlCommandLink comp_ui_m_but_doc_gen_no) {
		COMP_UI_M_BUT_DOC_GEN_NO = comp_ui_m_but_doc_gen_no;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_FUND_QUERY() {
		return COMP_UI_M_BUT_FUND_QUERY;
	}

	public void setCOMP_UI_M_BUT_FUND_QUERY(HtmlCommandLink comp_ui_m_but_fund_query) {
		COMP_UI_M_BUT_FUND_QUERY = comp_ui_m_but_fund_query;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_UDDATE_STAT() {
		return COMP_UI_M_BUT_UDDATE_STAT;
	}

	public void setCOMP_UI_M_BUT_UDDATE_STAT(
			HtmlCommandLink comp_ui_m_but_uddate_stat) {
		COMP_UI_M_BUT_UDDATE_STAT = comp_ui_m_but_uddate_stat;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_PRMDTLS() {
		return COMP_UI_M_BUT_PRMDTLS;
	}

	public void setCOMP_UI_M_BUT_PRMDTLS(HtmlCommandLink comp_ui_m_but_prmdtls) {
		COMP_UI_M_BUT_PRMDTLS = comp_ui_m_but_prmdtls;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_ANN_DTLS() {
		return COMP_UI_M_BUT_ANN_DTLS;
	}

	public void setCOMP_UI_M_BUT_ANN_DTLS(HtmlCommandLink comp_ui_m_but_ann_dtls) {
		COMP_UI_M_BUT_ANN_DTLS = comp_ui_m_but_ann_dtls;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_CONVERT() {
		return COMP_UI_M_BUT_CONVERT;
	}

	public void setCOMP_UI_M_BUT_CONVERT(HtmlCommandLink comp_ui_m_but_convert) {
		COMP_UI_M_BUT_CONVERT = comp_ui_m_but_convert;
	}

	public HtmlCommandLink getCOMP_UI_M_BUS_RUL() {
		return COMP_UI_M_BUS_RUL;
	}

	public void setCOMP_UI_M_BUS_RUL(HtmlCommandLink comp_ui_m_bus_rul) {
		COMP_UI_M_BUS_RUL = comp_ui_m_bus_rul;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_PREM_ALLOC() {
		return COMP_UI_M_BUT_PREM_ALLOC;
	}

	public void setCOMP_UI_M_BUT_PREM_ALLOC(HtmlCommandLink comp_ui_m_but_prem_alloc) {
		COMP_UI_M_BUT_PREM_ALLOC = comp_ui_m_but_prem_alloc;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_SURR_MAT() {
		return COMP_UI_M_BUT_SURR_MAT;
	}

	public void setCOMP_UI_M_BUT_SURR_MAT(HtmlCommandLink comp_ui_m_but_surr_mat) {
		COMP_UI_M_BUT_SURR_MAT = comp_ui_m_but_surr_mat;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_UPI() {
		return COMP_UI_M_BUT_UPI;
	}

	public void setCOMP_UI_M_BUT_UPI(HtmlCommandLink comp_ui_m_but_upi) {
		COMP_UI_M_BUT_UPI = comp_ui_m_but_upi;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_CLAIM() {
		return COMP_UI_M_BUT_CLAIM;
	}

	public void setCOMP_UI_M_BUT_CLAIM(HtmlCommandLink comp_ui_m_but_claim) {
		COMP_UI_M_BUT_CLAIM = comp_ui_m_but_claim;
	}

	public HtmlCommandLink getCOMP_UI_M_ENDT_QUOT() {
		return COMP_UI_M_ENDT_QUOT;
	}

	public void setCOMP_UI_M_ENDT_QUOT(HtmlCommandLink comp_ui_m_endt_quot) {
		COMP_UI_M_ENDT_QUOT = comp_ui_m_endt_quot;
	}

	public HtmlCommandLink getCOMP_UI_M_BUT_KEY_COMMIT() {
		return COMP_UI_M_BUT_KEY_COMMIT;
	}

	public void setCOMP_UI_M_BUT_KEY_COMMIT(HtmlCommandLink comp_ui_m_but_key_commit) {
		COMP_UI_M_BUT_KEY_COMMIT = comp_ui_m_but_key_commit;
	}

	public void setCOMP_UI_M_PS_REASON_CODE(
			HtmlInputText comp_ui_m_ps_reason_code) {
		COMP_UI_M_PS_REASON_CODE = comp_ui_m_ps_reason_code;
	}

	

	public HtmlOutputLabel getCOMP_UI_M_COMPY_FC_CHARGE_LABEL() {
		return COMP_UI_M_COMPY_FC_CHARGE_LABEL;
	}

	public void setCOMP_UI_M_COMPY_FC_CHARGE_LABEL(
			HtmlOutputLabel comp_ui_m_compy_fc_charge_label) {
		COMP_UI_M_COMPY_FC_CHARGE_LABEL = comp_ui_m_compy_fc_charge_label;
	}

	public HtmlInputText getCOMP_UI_M_COMPY_FC_CHARGE() {
		return COMP_UI_M_COMPY_FC_CHARGE;
	}

	public void setCOMP_UI_M_COMPY_FC_CHARGE(
			HtmlInputText comp_ui_m_compy_fc_charge) {
		COMP_UI_M_COMPY_FC_CHARGE = comp_ui_m_compy_fc_charge;
	}

	public HtmlInputText getCOMP_UI_M_COMPY_LC_CHARGE() {
		return COMP_UI_M_COMPY_LC_CHARGE;
	}

	public void setCOMP_UI_M_COMPY_LC_CHARGE(
			HtmlInputText comp_ui_m_compy_lc_charge) {
		COMP_UI_M_COMPY_LC_CHARGE = comp_ui_m_compy_lc_charge;
	}

	public HtmlOutputLabel getCOMP_M_COMPY_FC_CHARGE_LABEL() {
		return COMP_M_COMPY_FC_CHARGE_LABEL;
	}

	public void setCOMP_M_COMPY_FC_CHARGE_LABEL(
			HtmlOutputLabel comp_m_compy_fc_charge_label) {
		COMP_M_COMPY_FC_CHARGE_LABEL = comp_m_compy_fc_charge_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_DOC_CODE_LABEL() {
		return COMP_UI_M_POL_DOC_CODE_LABEL;
	}

	public void setCOMP_UI_M_POL_DOC_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_pol_doc_code_label) {
		COMP_UI_M_POL_DOC_CODE_LABEL = comp_ui_m_pol_doc_code_label;
	}

	public void validateUI_M_POL_DOC_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		try {
			helper.UI_M_POL_DOC_CODE_WHEN_VALIDATE_ITEM(DUMMY_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), (String) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_POL_DOC_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void validateSTATUSCODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		/*Added by Janani on 13.06.2017 for ZBILQC-1725182*/
		
		COMP_UI_M_POL_MEDICAL_FLAG.resetValue();
		
		/*eND*/
		
		try {
			String status = (String)value;
			DUMMY_BEAN.setUI_M_PS_STATUS((String) value);
			if(!(status.equalsIgnoreCase("B08"))){
				COMP_UI_M_PS_REASON_CODE.setValue("*");
				COMP_UI_M_PS_REASON_CODE.setRequired(true);
				COMP_UI_M_PS_REASON_CODE.resetValue();
				/*added by gopi for SSP call ZBILQC_02-JAN-2017_Disabling of fields on 04/01/17*/
				COMP_UI_M_PS_REASON_CODE.setDisabled(false);
				/*end*/
				//throw new ValidatorException(new FacesMessage("Enter Reason Code"));
			}
			else{	
				/*added by gopi SSP call ZBILQC_02-JAN-2017_Disabling of fields on 04/01/17*/
				/*changed by raja on 23-06-2017 for ZBILQC-1729814*/
				//COMP_UI_M_PS_REASON_CODE.setDisabled(true);
				//DUMMY_BEAN.setUI_M_PS_REASON_CODE(null);
				//DUMMY_BEAN.setUI_M_REASON_DESC(null);
				COMP_UI_M_PS_REASON_CODE.resetValue();
				//COMP_UI_M_PS_REASON_CODE.setValue(null);
				COMP_UI_M_PS_REASON_CODE.setRequired(false);
				COMP_UI_M_PS_REASON_CODE.resetValue();
				/*end*/
			}
			
			/*Added by Janani on 13.06.2017 for ZBILQC-1725182*/
			
			
			System.out.println("getUI_M_PS_STATUS                  :"+DUMMY_BEAN.getUI_M_PS_STATUS());
			
			
			/*
			 *  Below code modified by Dhinesh on 12-8-2017 for ssp call id ZBILQC-1725182
			 *   
			 *   if(DUMMY_BEAN.getUI_M_PS_STATUS().equalsIgnoreCase("B06") || DUMMY_BEAN.getUI_M_PS_STATUS().equalsIgnoreCase("B07")) */
			
			/*if(CommonUtils.isIN(CommonUtils.nvl(DUMMY_BEAN.getUI_M_PS_STATUS(), "X"),"B07"))
			{
				DUMMY_BEAN.setUI_M_POL_MEDICAL_FLAG("N");
				COMP_UI_M_POL_MEDICAL_FLAG.setDisabled(true);
				
				
				
			}
			else
			{
				DUMMY_BEAN.setUI_M_POL_MEDICAL_FLAG("Y");
				COMP_UI_M_POL_MEDICAL_FLAG.setDisabled(false);
			}*/
			
			/* Below code modified by Dhinesh on 30-8-2017 for ssp call id ZBILQC-1725182*/
			if(CommonUtils.isIN(CommonUtils.nvl(DUMMY_BEAN.getUI_M_PS_STATUS(), "X"),"B06","B16"))
			{
				
				/*
				 * commented by Ameen on 10-04-2018 as per siva sugg.
				 * DUMMY_BEAN.setUI_M_POL_MEDICAL_FLAG("Y");
				COMP_UI_M_POL_MEDICAL_FLAG.setDisabled(false);*/
			}
			else
			{
				DUMMY_BEAN.setUI_M_POL_MEDICAL_FLAG("N");
				COMP_UI_M_POL_MEDICAL_FLAG.setDisabled(true);
			}
			
			/* End */
			System.out.println("getUI_M_POL_MEDICAL_FLAG                  :"+DUMMY_BEAN.getUI_M_POL_MEDICAL_FLAG());
			
			/*End*/
			
			 /*added by raja on 02-08-2017 for ZBILQC-1731915 */
			if((status.equalsIgnoreCase("B25"))){
				COMP_PS_RI_CODE.setDisabled(false);
			}
			else
			{
				COMP_PS_RI_CODE.setDisabled(true);
				DUMMY_BEAN.setPS_RI_CODE(null);
				DUMMY_BEAN.setPS_RI_CODE_DESC(null);
				COMP_PS_RI_CODE.resetValue();
				COMP_PS_RI_CODE_DESC.resetValue();
				
			}
			/*end*/
			
			
			} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "ReasonCode", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	public HtmlInputText getCOMP_UI_M_REASON_DESC() {
		return COMP_UI_M_REASON_DESC;
	}

	public void setCOMP_UI_M_REASON_DESC(HtmlInputText comp_ui_m_reason_desc) {
		COMP_UI_M_REASON_DESC = comp_ui_m_reason_desc;
	}

	public HtmlInputText getCOMP_UI_M_POL_ADDL_STATUS_DESC() {
		return COMP_UI_M_POL_ADDL_STATUS_DESC;
	}

	public void setCOMP_UI_M_POL_ADDL_STATUS_DESC(
			HtmlInputText comp_ui_m_pol_addl_status_desc) {
		COMP_UI_M_POL_ADDL_STATUS_DESC = comp_ui_m_pol_addl_status_desc;
	}

	/*public HtmlInputText getCOMP_UI_M_PS_REMARKS() {
		return COMP_UI_M_PS_REMARKS;
	}

	public void setCOMP_UI_M_PS_REMARKS(HtmlInputText comp_ui_m_ps_remarks) {
		COMP_UI_M_PS_REMARKS = comp_ui_m_ps_remarks;
	}*/

	public HtmlSelectOneMenu getCOMP_UI_M_POL_MEDICAL_FLAG() {
		return COMP_UI_M_POL_MEDICAL_FLAG;
	}

	public void setCOMP_UI_M_POL_MEDICAL_FLAG(
			HtmlSelectOneMenu comp_ui_m_pol_medical_flag) {
		COMP_UI_M_POL_MEDICAL_FLAG = comp_ui_m_pol_medical_flag;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_STATUS_DT_LABEL() {
		return COMP_UI_M_PS_STATUS_DT_LABEL;
	}

	public void setCOMP_UI_M_PS_STATUS_DT_LABEL(
			HtmlOutputLabel comp_ui_m_ps_status_dt_label) {
		COMP_UI_M_PS_STATUS_DT_LABEL = comp_ui_m_ps_status_dt_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_STATUS_LABEL() {
		return COMP_UI_M_PS_STATUS_LABEL;
	}

	public void setCOMP_UI_M_PS_STATUS_LABEL(
			HtmlOutputLabel comp_ui_m_ps_status_label) {
		COMP_UI_M_PS_STATUS_LABEL = comp_ui_m_ps_status_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_REASON_CODE_LABEL() {
		return COMP_UI_M_PS_REASON_CODE_LABEL;
	}

	public void setCOMP_UI_M_PS_REASON_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_ps_reason_code_label) {
		COMP_UI_M_PS_REASON_CODE_LABEL = comp_ui_m_ps_reason_code_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_REMARKS_LABEL() {
		return COMP_UI_M_PS_REMARKS_LABEL;
	}

	public void setCOMP_UI_M_PS_REMARKS_LABEL(
			HtmlOutputLabel comp_ui_m_ps_remarks_label) {
		COMP_UI_M_PS_REMARKS_LABEL = comp_ui_m_ps_remarks_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_MEDICAL_FLAG_LABEL() {
		return COMP_UI_M_POL_MEDICAL_FLAG_LABEL;
	}

	public void setCOMP_UI_M_POL_MEDICAL_FLAG_LABEL(
			HtmlOutputLabel comp_ui_m_pol_medical_flag_label) {
		COMP_UI_M_POL_MEDICAL_FLAG_LABEL = comp_ui_m_pol_medical_flag_label;
	}

	public List<SelectItem> getListUI_M_POL_MEDICAL_FLAG() {
		return listUI_M_POL_MEDICAL_FLAG;
	}

	public void setListUI_M_POL_MEDICAL_FLAG(
			List<SelectItem> listUI_M_POL_MEDICAL_FLAG) {
		this.listUI_M_POL_MEDICAL_FLAG = listUI_M_POL_MEDICAL_FLAG;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovUI_M_PS_STATUS(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//P_CALL_LOV('DUMMY.M_PS_STATUS','IL_ADDL_STAT',M_VALUE);
			String DS_TYPE = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_DS_TYPE();
			String POL_PROP_QUOT_FLAG = compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
					.getPOL_PROP_QUOT_FLAG();
			int M_VALUE = 0;
			if ("1".equalsIgnoreCase(DS_TYPE) && "P".equals(POL_PROP_QUOT_FLAG)) {
				M_VALUE = 1;
			} else if ("1".equalsIgnoreCase(DS_TYPE)
					&& "Q".equals(POL_PROP_QUOT_FLAG)) {
				M_VALUE = 5;
			} else if ("2".equalsIgnoreCase(DS_TYPE)) {
				M_VALUE = 2;
				if (compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX() > 0) {
					M_VALUE = 3;
				}
			}
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "DUMMY",
					"M_PS_STATUS", "IL_ADDL_STAT", M_VALUE, null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovM_UI_M_PS_REASON_CODE(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('DUMMY.M_PS_REASON_CODE','IL_REASON');

			/*changed by raja on 23-06-2017 for 23-06-2017*/
			/*suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "DUMMY",
					"M_PS_REASON_CODE", "IL_REASON", null, null, null, null,
					(String) currValue);*/
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "DUMMY",
					"M_PS_REASON_CODE_1", "IL_REASON", DUMMY_BEAN.getUI_M_PS_STATUS(), null, null, null,
					(String) currValue);
			
			/*end*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void validatePS_STATUS_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		try {
			DUMMY_BEAN.setUI_M_PS_STATUS_DT((Date) value);
			helper.PS_STATUS_DT_WHEN_VALIDATE_ITEM(compositeAction);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PS_STATUS", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void validateUI_M_PS_REASON_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		
		try {
			DUMMY_BEAN.setUI_M_PS_REASON_CODE((String) value);
			} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "REASON_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void minAgeonMaturity(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String Query = "SELECT PLAN_MIN_AGE_ON_MAT FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		Integer MIN_AGE_ON_MAT = 0;
		Integer POL_MAT_AGE = 0;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(Query, connection,
					new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE() });
			if (resultSet.next()) {
				MIN_AGE_ON_MAT = resultSet.getInt(1);
			}
			if (MIN_AGE_ON_MAT != null) {
				POL_MAT_AGE = (compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_PERIOD() + compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_AGE());
				if (POL_MAT_AGE < MIN_AGE_ON_MAT) {
					throw new Exception("Age does not Fall in Minimum Age on Maturity");
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
public String emailTriggerProcCall(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH) throws Exception{
		
		Connection con=CommonUtils.getConnection();
		System.out.println("P_MAIL_TYPE-->"+P_MAIL_TYPE);
		String out="";
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
		  parameterList.add(param1); 
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_MAIL_TYPE);
		  parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
		  parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CUST_TYPE);
		  parameterList.add(param4);
		  OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_MAIL_PATH);
		  parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("OUT1", "STRING", "OUT",out);
	    parameterList.add(param6);
	    OracleProcedureHandler procHandler = new OracleProcedureHandler();
	    outputList = procHandler.execute(parameterList, con,
	            "P_MAIL_TEMP");
	    CommonUtils.doComitt();
	    Iterator<OracleParameter> iterator = outputList.iterator();
	    while (iterator.hasNext()) {
	        OracleParameter oracleParameter = iterator.next();
	        System.out.println("Output value:::" + oracleParameter.getValue());
			out=(String)oracleParameter.getValue();
	    }
		return out;
		}

	/*Added by Ram on 06/12/2016 for Display status in Datagrid*/
public void onLoad(PhaseEvent event) {
	if(isBlockFlag())
	{
		fetchStatusDatas();
		setBlockFlag(false);
	}
	
}

private void fetchStatusDatas()
{

	dataList_PT_IL_POL_STATUS.clear();
Connection conn = null;
ResultSet rs = null;
 String selectStatement = "SELECT TO_CHAR(PS_STATUS_DT,'dd/MM/rrrr')PS_STATUS_DT,PS_CODE_DESC,PC_DESC,PS_REMARKS,PS_STATUS_UID,PS_RI_CODE FROM PP_SYSTEM1,PT_IL_POL_STATUS LEFT JOIN PM_CODES "
 		+ "ON PC_CODE = PS_REASON_CODE AND PC_TYPE = 'IL_REASON'  WHERE PS_POL_SYS_ID = ? AND PS_TYPE = 'IL_ADDL_STAT' AND PS_CODE = PS_STATUS";
 Object[] queryObject = (Object[])null;
try {
	System.out.println("Welcome to body onload in status page");
	 conn = CommonUtils.getConnection();
	 queryObject = new Object[] { compositeAction
	          .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
	          .getPOL_SYS_ID() };
	 rs = new CRUDHandler().executeSelectStatement(
		        selectStatement, conn, queryObject);
	 while (rs.next()) {
		 PT_IL_POL_STATUS PT_IL_POL_STATUS_BEAN = new PT_IL_POL_STATUS();
		 PT_IL_POL_STATUS_BEAN.setUI_M_PC_DESC(rs.getString("PS_STATUS_DT"));
		 
		 PT_IL_POL_STATUS_BEAN.setUI_M_PS_STATUS(rs.getString("PS_CODE_DESC"));
		 PT_IL_POL_STATUS_BEAN.setUI_M_PS_REASON_CODE(rs.getString("PC_DESC"));
		 if(rs.getString("PS_REMARKS") != null && rs.getString("PS_REMARKS").length() > 50)
		 {
			 PT_IL_POL_STATUS_BEAN.setUI_M_PS_REMARKS(rs.getString("PS_REMARKS").substring(0,50)+"...");
		 }
		 else
		 {
			 PT_IL_POL_STATUS_BEAN.setUI_M_PS_REMARKS(rs.getString("PS_REMARKS"));
			 
		 }
		 /*
		  * commented by Ameen on 10-04-2018 for KIC as per siva sugg.
		  * PT_IL_POL_STATUS_BEAN.setUI_M_POL_MEDICAL_FLAG(rs.getString("PS_REMARKS"));*/
		 PT_IL_POL_STATUS_BEAN.setPS_STATUS_UID(rs.getString("PS_STATUS_UID"));
		 /*added by raja on 02-08-2017 for ZBILQC-1731915 */
		 PT_IL_POL_STATUS_BEAN.setPS_RI_CODE(rs.getString("PS_RI_CODE"));
		 
		 if(PT_IL_POL_STATUS_BEAN.getPS_RI_CODE()!=null)
		 {
			 String query="SELECT CUST_NAME FROM PM_CUSTOMER  WHERE CUST_CODE=?";
			 ResultSet rs1=new CRUDHandler().executeSelectStatement(query, conn, new Object[]{PT_IL_POL_STATUS_BEAN.getPS_RI_CODE()});
			 while(rs1.next())
			 {
				 PT_IL_POL_STATUS_BEAN.setPS_RI_CODE_DESC(rs1.getString("CUST_NAME"));
			 }
		 }
		 /*end*/
		 dataList_PT_IL_POL_STATUS.add(PT_IL_POL_STATUS_BEAN);
	 }
}
catch(Exception e)
{
	e.printStackTrace();
}

}
private UIData dataTable;

private List<PT_IL_POL_STATUS> dataList_PT_IL_POL_STATUS = new ArrayList<PT_IL_POL_STATUS>();

public UIData getDataTable() {
	return dataTable;
}

public void setDataTable(UIData dataTable) {
	this.dataTable = dataTable;
}

public List<PT_IL_POL_STATUS> getDataList_PT_IL_POL_STATUS() {
	return dataList_PT_IL_POL_STATUS;
}

public void setDataList_PT_IL_POL_STATUS(
		List<PT_IL_POL_STATUS> dataList_PT_IL_POL_STATUS) {
	this.dataList_PT_IL_POL_STATUS = dataList_PT_IL_POL_STATUS;
}

private HtmlInputTextarea COMP_UI_M_PS_REMARKS;

public HtmlInputTextarea getCOMP_UI_M_PS_REMARKS() {
	return COMP_UI_M_PS_REMARKS;
}

public void setCOMP_UI_M_PS_REMARKS(HtmlInputTextarea cOMP_UI_M_PS_REMARKS) {
	COMP_UI_M_PS_REMARKS = cOMP_UI_M_PS_REMARKS;
}
 /*End*/
/*Added by saranya on 07-12-2016 for RM018T - FSD_IL_ZB Life_013_Underwriting changes */
public String onClickOk()throws Exception {
	//onclickCancel();
	String outCome = "PILT002_APAC_PT_IL_POLICY";
	compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
	getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
	return outCome;
}
/*End*/
/*Added by saranya on 07-12-2016 for RM018T - FSD_IL_ZB Life_013_Underwriting changes */

public String onclickCancel(){
	getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
	return "";
}
/*End*/
/*Added by saranya on 19-12-2016 for RM018T - FSD_IL_ZB Life_013_Underwriting changes*/ 
Date POL_START_DT=null;
Date POL_EXPIRY_DT=null;
public void changeTerm(PT_IL_POLICY pt_il_policy_bean,
		PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	ResultSet resultSet1 = null;
	CRUDHandler handler = new CRUDHandler();
	Connection connection = null;
	try {

		String query = "SELECT POL_START_DT,POL_EXPIRY_DT FROM PT_IL_POLICY WHERE POL_SYS_ID=?";

		connection = CommonUtils.getConnection();
		resultSet1 = handler.executeSelectStatement(query, connection,
				new Object[] { pt_il_policy_bean.getPOL_SYS_ID() });
		if (resultSet1.next()) {
			POL_START_DT = resultSet1.getDate(1);
			POL_EXPIRY_DT= resultSet1.getDate(2);
			System.out.println("POL_START_DT  :"+POL_START_DT);
			System.out.println("POL_EXPIRY_DT  :"+POL_EXPIRY_DT);
		}
	} catch (Exception e) {
		e.printStackTrace();
		// compositeAction.getWizard().setImmediate("true");
		throw new Exception(e.getMessage());
	}

}
/*End*/
/*Modified  by ganesh on 20-06-2017, ZBILQC-1725314 */
public static String emailStatusMsg(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH) throws Exception

{
	StringBuilder statusMessge =  new StringBuilder(" - ");
	/*Modified by Saranya RM018T - FSD_IL_ZB Life_016-Queried Proposals v1 on 27-12-2016*/

      String mailFlag = Email_Procedure_Call.emailTriggerProcCall(P_PROD_CODE, P_MAIL_TYPE, P_POL_SYS_ID, P_CUST_TYPE, P_MAIL_PATH,CommonUtils.getConnection());
	
	/*End*/
	System.out.println("Mail status Flag--->["+mailFlag+"]--- P_CUST_TYPE ["+P_CUST_TYPE+"]");
	
	if((P_CUST_TYPE.equalsIgnoreCase("B"))){
		
		if(mailFlag.equals("YY")){
			
			statusMessge.append("Your Proposal Status Mail sent sucessfully");
			
		}else if(mailFlag.equals("T")){
			
			statusMessge.append("Email template is unavailable in master setup "+Email_Procedure_Call.templateDescription(P_MAIL_TYPE));
		    			
		}else if(mailFlag.equalsIgnoreCase("NN")){
			
			statusMessge.append("Unable to send the email due to the unavailability of both Customer and Agent email id");
				
		}else if(mailFlag.equalsIgnoreCase("NY")){
			
			statusMessge.append("Unable to send the email due to the unavailability of Customer email id");
				
		}else if(mailFlag.equalsIgnoreCase("YN")){
			
			statusMessge.append("Unable to send the email due to the unavailability of Agent email id");
				
		}
		//Added by ganesh on 21-06-2017, rare case if procedure not handled dualFlag it will use
		else if(mailFlag.equalsIgnoreCase("Y")){   
			
			statusMessge.append("Your Proposal Status Mail sent sucessfully");
		}else{
			statusMessge.append("Unable to send the email due to the unavailability of both Customer and Agent email id");
		}
		/*end*/
	}else{
		
		if(mailFlag.equals("Y")){
			
			statusMessge.append("Your Proposal Status Mail sent sucessfully");
			
		}else if(mailFlag.equals("T")){
			
			statusMessge.append("Email template is unavailable in master setup "+Email_Procedure_Call.templateDescription(P_MAIL_TYPE));
		    			
		}else {
			
			if(P_CUST_TYPE.equalsIgnoreCase("C")){
				statusMessge.append("Unable to send the email due to the unavailability of Customer email id");
			}else if(P_CUST_TYPE.equalsIgnoreCase("A")){
				statusMessge.append("Unable to send the email due to the unavailability of Agent email id");
			}
			
		}
		
		
	}
	
	
	return statusMessge.toString();   
	
	
	
}
/*end*/

/*added by raja on 02-08-2017 for ZBILQC-1731915 */

private HtmlOutputLabel COMP_PS_RI_CODE_LABEL;
private HtmlInputText COMP_PS_RI_CODE;
public HtmlInputText COMP_PS_RI_CODE_DESC;

public HtmlOutputLabel getCOMP_PS_RI_CODE_LABEL() {
	return COMP_PS_RI_CODE_LABEL;
}

public void setCOMP_PS_RI_CODE_LABEL(HtmlOutputLabel cOMP_PS_RI_CODE_LABEL) {
	COMP_PS_RI_CODE_LABEL = cOMP_PS_RI_CODE_LABEL;
}

public HtmlInputText getCOMP_PS_RI_CODE() {
	return COMP_PS_RI_CODE;
}

public void setCOMP_PS_RI_CODE(HtmlInputText cOMP_PS_RI_CODE) {
	COMP_PS_RI_CODE = cOMP_PS_RI_CODE;
}



public HtmlInputText getCOMP_PS_RI_CODE_DESC() {
	return COMP_PS_RI_CODE_DESC;
}

public void setCOMP_PS_RI_CODE_DESC(HtmlInputText cOMP_PS_RI_CODE_DESC) {
	COMP_PS_RI_CODE_DESC = cOMP_PS_RI_CODE_DESC;
}

public ArrayList<LovBean> lovPS_RI_CODE(Object object) {

	ArrayList<LovBean> suggestionList = null;
	ListItemUtil listitemutil = new ListItemUtil();
	
	String PILM015_APAC_PL_IL_PROP_TREATY_TYPE_CUST_PTPC_CUST_CODE=
			 "SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER	WHERE CUST_CLASS IN"
	       + " (SELECT CCLAS_CODE" 
	       + " FROM PM_CUST_CLASS, PP_SYSTEM" 
	       + " WHERE INSTR(PS_CODE_DESC," 
	                   + " '''' || DECODE(PS_VALUE, 2, CCLAS_CODE, CCLAS_TYPE) || '''') <> 0" 
	         + " AND PS_CODE = 'REINS'" 
	         + " AND PS_TYPE = 'LOV_CUST')" 
	  + " AND CUST_FRZ_FLAG = 'N'" 
	  + " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE" 
	                       + " FROM PM_CUST_DIVN" 
	                       + " WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)" 
	                       + " AND NVL(CUST_APPL_ALL_BRAN_YN,'N') = 'N')) OR" 
	     + " (NVL(CUST_APPL_ALL_BRAN_YN,'N') = 'Y')) AND ROWNUM<25";
		
		String PILM015_APAC_PL_IL_PROP_TREATY_TYPE_CUST_PTPC_CUST_CODE_LIKE=
			 "SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER	WHERE CUST_CLASS IN"
	       + " (SELECT CCLAS_CODE" 
	       + " FROM PM_CUST_CLASS, PP_SYSTEM" 
	       + " WHERE INSTR(PS_CODE_DESC," 
	                   + " '''' || DECODE(PS_VALUE, 2, CCLAS_CODE, CCLAS_TYPE) || '''') <> 0" 
	         + " AND PS_CODE = 'REINS'" 
	         + " AND PS_TYPE = 'LOV_CUST')" 
	  + " AND CUST_FRZ_FLAG = 'N'" 
	  + " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE" 
	                       + " FROM PM_CUST_DIVN" 
	                       + " WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)" 
	                       + " AND NVL(CUST_APPL_ALL_BRAN_YN,'N') = 'N')) OR" 
	     + " (NVL(CUST_APPL_ALL_BRAN_YN,'N') = 'Y')) AND CUST_CODE LIKE ? AND ROWNUM<25";
	ResultSet rs = null;
	Connection connection = null;

	try {

		connection = CommonUtils.getConnection();
		

	
		String currentValue = (String) object;
		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		if ("*".equalsIgnoreCase(currentValue)) {
			
			Object[] value={CommonUtils.getControlBean().getM_DIVN_CODE()};
			suggestionList = ListItemUtil.prepareSuggestionList(PILM015_APAC_PL_IL_PROP_TREATY_TYPE_CUST_PTPC_CUST_CODE,value);
		} else {
			
			Object[] value={CommonUtils.getControlBean().getM_DIVN_CODE(), currentValue};
			
			suggestionList = ListItemUtil.prepareSuggestionList(PILM015_APAC_PL_IL_PROP_TREATY_TYPE_CUST_PTPC_CUST_CODE_LIKE,value);
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			CommonUtils.closeCursor(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return suggestionList;
}


public void validatePS_RI_CODE(FacesContext facesContext,
		UIComponent component, Object value) throws ValidatorException {

	try {
		DUMMY_BEAN.setPS_RI_CODE((String)value);

	} catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
				.getMessage()));
	} 
}

/*end*/

/*Newly Added By Dhinesh on for ssp call id : ZBILQC-1731626*/
public void PR_IL_INS_SUB_STD_REG_01(String Cust_code) throws ProcedureException
{
	 Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
       OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",Cust_code);
       parameterList.add(param1);
       OracleProcedureHandler procHandler = new OracleProcedureHandler();
       outputList = procHandler.execute(parameterList, connection,
              "P9ILPK_POLICY_NR.PR_IL_INS_SUB_STD_REG_01");
       CommonUtils.getConnection().commit();
    /*   Iterator<OracleParameter> iterator = outputList.iterator();
       while (iterator.hasNext()) {
           OracleParameter oracleParameter = iterator.next();
           System.out.println("Output value:::" + oracleParameter.getValue());
       } */  	
    } catch(Exception e) {
    	ErrorHelpUtil.getErrorForProcedure(connection);
           throw new ProcedureException(e.getMessage());
    }
   //return outputList;
}
/* End */

/*Added by AMeen on 23-03-2018 for KIC onsite issue list*/
public void validateUI_M_PS_REMARKS(FacesContext facesContext,
		UIComponent component, Object value) throws ValidatorException {

	try {
		DUMMY_BEAN.setUI_M_PS_REMARKS((String)value);

	} catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
				.getMessage()));
	} 
}
/*End*/


/*Added by Janani on 11.07.2018 for FLALIFEQC-1756799*/
public void validateSA_range() throws Exception {
	String agnt_prem_type=null;
	Connection connection = null;
	ResultSet rs = null;
	Object[] values = {};
	String query1_PGC = "SELECT  PLAN_MIN_SA ,PLAN_MAX_SA  FROM    PM_IL_PLAN"
			+ " WHERE   PLAN_CODE = ?";

	Double M_PLAN_MIN_SA = 0.0;
	Double M_PLAN_MAX_SA = 0.0;
	String query = "UPDATE PT_IL_POLICY SET POL_FLEX_20=? WHERE POL_SYS_ID=?";

	CRUDHandler handler = new CRUDHandler();
	PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

	try {

		connection = CommonUtils.getConnection();
		values = new Object[] { compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.getPOL_PROD_CODE() };
		rs = handler.executeSelectStatement(query1_PGC, connection,
				values);

		while (rs.next()) {
			M_PLAN_MIN_SA = rs.getDouble(1);
			M_PLAN_MAX_SA = rs.getDouble(2);
		}


		System.out.println("M_PLAN_MIN_SA  :"+M_PLAN_MIN_SA +"      M_PLAN_MAX_SA       "+M_PLAN_MAX_SA);

		System.out.println("getPOL_FC_SUM_ASSURED  :"+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
				getPOL_FC_SUM_ASSURED());

		if ((CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
				getPOL_FC_SUM_ASSURED(), 0.0) + CommonUtils.nvl(
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
						getPOL_ORG_FC_SUM_ASSURED(), 0.0)) <= 0.0   && !"L".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
								getPOL_PLAN_CODE())) {
			

			System.out.println("query executed "+query);

			new CRUDHandler().executeUpdateStatement(query, connection,new Object[] {"N",compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
					getPOL_SYS_ID()});
			connection.commit();
			
			
			throw new Exception("Fc Sum Assured : "
					+ Messages.getString(
							PELConstants.pelErrorMessagePath, "71043"));
		} else if ((CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
					getPOL_FC_SUM_ASSURED(), 0.0) < CommonUtils
					.nvl(M_PLAN_MIN_SA, 0.0))
					|| (CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
							getPOL_FC_SUM_ASSURED(), 0.0) > CommonUtils
							.nvl(M_PLAN_MAX_SA, 0))) {

				String plan_max_sa = (BigDecimal.valueOf(M_PLAN_MAX_SA)
						.toPlainString());
				
				
				new CRUDHandler().executeUpdateStatement(query, connection,new Object[] {"N",compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
						getPOL_SYS_ID()});
				connection.commit();
				
				/*Committed by pidugu raj since for FC sum assured no need to show validation,
				 *  but not commented full else if block because no idea of impact since commit operation is there before
				 * throw new Exception(
						Messages
						.getString(
								PELConstants.pelErrorMessagePath,
								"3206",
								new Object[] { " Sum Assured Should be between "
										+ M_PLAN_MIN_SA
										+ " and " + plan_max_sa }));*/
			}
		else
		{
			new CRUDHandler().executeUpdateStatement(query, connection,new Object[] {"Y",compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().
					getPOL_SYS_ID()});
			connection.commit();
		}
		
		


	} catch (Exception e) {
		throw new Exception(e.getMessage());
	}
}

/*End of FLALIFEQC-1756799*/

}
