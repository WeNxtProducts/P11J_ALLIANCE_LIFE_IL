package com.iii.pel.forms.PILQ003;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction{

	private DUMMY DUMMY_BEAN;
	private DUMMY_HELPER helper;
	public PILQ003_COMPOSITE_ACTION compositeAction;
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


	private HtmlCommandButton COMP_UI_M_BUT_ENDT;
	private HtmlCommandButton COMP_UI_M_BUT_COPY;
	private HtmlCommandButton COMP_UI_M_BUT_APPROVAL;
	private HtmlCommandButton COMP_UI_M_BUT_CUSTOMER;
	private HtmlCommandButton COMP_UI_M_BUT_CONTRACTOR;
	private HtmlCommandButton COMP_UI_M_BUT_HOLD;
	private HtmlCommandButton COMP_UI_M_BUT_FUND_DTL;
	private HtmlCommandButton COMP_UI_M_BUT_OCC_RATE_PAYOR;
	private HtmlCommandButton COMP_UI_M_BUT_OCC_RATE_PAYEE;
	private HtmlCommandButton COMP_UI_M_BUT_DOC_GEN_NO;
	private HtmlCommandButton COMP_UI_M_BUT_FUND_QUERY;
	private HtmlCommandButton COMP_UI_M_BUT_ADD_DETAILS;
	private HtmlCommandButton COMP_UI_M_BUT_MORE_COVER;
	private HtmlCommandButton COMP_UI_M_BUT_UDDATE_STAT;
	private HtmlCommandButton COMP_UI_M_BUT_PRMDTLS;
	private HtmlCommandButton COMP_UI_M_BUT_POL_AMDT;
	private HtmlCommandButton COMP_UI_M_BUT_CALC_DISC_LOAD;
	private HtmlCommandButton COMP_UI_M_BUT_ANN_DTLS;
	private HtmlCommandButton COMP_UI_M_BUT_CONVERT;
	private HtmlCommandButton COMP_UI_M_BUS_RUL;
	private HtmlCommandButton COMP_UI_M_BUT_PREM_ALLOC;
	private HtmlCommandButton COMP_UI_M_BUT_SURR_MAT;
	private HtmlCommandButton COMP_UI_M_BUT_UPI;
	private HtmlCommandButton COMP_UI_M_BUT_UPLOAD;
	private HtmlCommandButton COMP_UI_M_BUT_CLAIM;
	private HtmlCommandButton COMP_UI_M_BUT_REPLACE_POLICY;
	private HtmlCommandButton COMP_UI_M_BUT_ASSR_MORE_INFO;
	private HtmlCommandButton COMP_UI_M_ENDT_QUOT;
	private HtmlCommandButton COMP_UI_M_BUT_MATURITY;
	private HtmlCommandButton COMP_CONVERT_OK_BUT;


	private HtmlInputText COMP_UI_M_POL_DOC_CODE;
	private HtmlInputText COMP_UI_M_POL_DOC_DESC;
	private HtmlInputText COMP_UI_M_PS_STATUS;
	private HtmlInputText COMP_UI_M_PS_REASON_CODE;
	private HtmlInputText COMP_UI_M_REASON_DESC;
	private HtmlInputText COMP_UI_M_POL_ADDL_STATUS_DESC;
	private HtmlInputText COMP_UI_M_PS_REMARKS;
	private HtmlInputText COMP_UI_M_POL_MEDICAL_FLAG;
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
	
	private HtmlCommandButton COMP_UI_M_BUT_KEY_COMMIT;
	
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

	public HtmlCommandButton getCOMP_UI_M_ENDT_QUOT() {
		return COMP_UI_M_ENDT_QUOT;
	}

	public void setCOMP_UI_M_ENDT_QUOT(HtmlCommandButton COMP_UI_M_ENDT_QUOT) {
		this.COMP_UI_M_ENDT_QUOT = COMP_UI_M_ENDT_QUOT;
	}


	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVAL() {
		return COMP_UI_M_BUT_APPROVAL;
	}

	public void setCOMP_UI_M_BUT_APPROVAL(HtmlCommandButton comp_ui_m_but_approval) {
		COMP_UI_M_BUT_APPROVAL = comp_ui_m_but_approval;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUSTOMER() {
		return COMP_UI_M_BUT_CUSTOMER;
	}

	public void setCOMP_UI_M_BUT_CUSTOMER(HtmlCommandButton comp_ui_m_but_customer) {
		COMP_UI_M_BUT_CUSTOMER = comp_ui_m_but_customer;
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

	public HtmlCommandButton getCOMP_UI_M_BUT_FUND_DTL() {
		return COMP_UI_M_BUT_FUND_DTL;
	}

	public void setCOMP_UI_M_BUT_FUND_DTL(HtmlCommandButton comp_ui_m_but_fund_dtl) {
		COMP_UI_M_BUT_FUND_DTL = comp_ui_m_but_fund_dtl;
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

	public HtmlCommandButton getCOMP_UI_M_BUT_ENDT() {
		return COMP_UI_M_BUT_ENDT;
	}

	public void setCOMP_UI_M_BUT_ENDT(HtmlCommandButton comp_ui_m_but_endt) {
		COMP_UI_M_BUT_ENDT = comp_ui_m_but_endt;
	}

	public DUMMY_ACTION() {
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
		instantiateAllComponent();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DOC_GEN_NO() {
		return COMP_UI_M_BUT_DOC_GEN_NO;
	}

	public void setCOMP_UI_M_BUT_DOC_GEN_NO(
			HtmlCommandButton comp_ui_m_but_doc_gen_no) {
		COMP_UI_M_BUT_DOC_GEN_NO = comp_ui_m_but_doc_gen_no;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FUND_QUERY() {
		return COMP_UI_M_BUT_FUND_QUERY;
	}

	public void setCOMP_UI_M_BUT_FUND_QUERY(
			HtmlCommandButton comp_ui_m_but_fund_query) {
		COMP_UI_M_BUT_FUND_QUERY = comp_ui_m_but_fund_query;
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

	public HtmlCommandButton getCOMP_UI_M_BUT_UDDATE_STAT() {
		return COMP_UI_M_BUT_UDDATE_STAT;
	}

	public void setCOMP_UI_M_BUT_UDDATE_STAT(
			HtmlCommandButton comp_ui_m_but_uddate_stat) {
		COMP_UI_M_BUT_UDDATE_STAT = comp_ui_m_but_uddate_stat;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PRMDTLS() {
		return COMP_UI_M_BUT_PRMDTLS;
	}

	public void setCOMP_UI_M_BUT_PRMDTLS(HtmlCommandButton comp_ui_m_but_prmdtls) {
		COMP_UI_M_BUT_PRMDTLS = comp_ui_m_but_prmdtls;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_AMDT() {
		return COMP_UI_M_BUT_POL_AMDT;
	}

	public void setCOMP_UI_M_BUT_POL_AMDT(HtmlCommandButton comp_ui_m_but_pol_amdt) {
		COMP_UI_M_BUT_POL_AMDT = comp_ui_m_but_pol_amdt;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CALC_DISC_LOAD() {
		return COMP_UI_M_BUT_CALC_DISC_LOAD;
	}

	public void setCOMP_UI_M_BUT_CALC_DISC_LOAD(
			HtmlCommandButton comp_ui_m_but_calc_disc_load) {
		COMP_UI_M_BUT_CALC_DISC_LOAD = comp_ui_m_but_calc_disc_load;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ANN_DTLS() {
		return COMP_UI_M_BUT_ANN_DTLS;
	}

	public void setCOMP_UI_M_BUT_ANN_DTLS(HtmlCommandButton comp_ui_m_but_ann_dtls) {
		COMP_UI_M_BUT_ANN_DTLS = comp_ui_m_but_ann_dtls;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CONVERT() {
		return COMP_UI_M_BUT_CONVERT;
	}

	public void setCOMP_UI_M_BUT_CONVERT(HtmlCommandButton comp_ui_m_but_convert) {
		COMP_UI_M_BUT_CONVERT = comp_ui_m_but_convert;
	}

	public HtmlCommandButton getCOMP_UI_M_BUS_RUL() {
		return COMP_UI_M_BUS_RUL;
	}

	public void setCOMP_UI_M_BUS_RUL(HtmlCommandButton comp_ui_m_bus_rul) {
		COMP_UI_M_BUS_RUL = comp_ui_m_bus_rul;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SURR_MAT() {
		return COMP_UI_M_BUT_SURR_MAT;
	}

	public void setCOMP_UI_M_BUT_SURR_MAT(HtmlCommandButton comp_ui_m_but_surr_mat) {
		COMP_UI_M_BUT_SURR_MAT = comp_ui_m_but_surr_mat;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_UPI() {
		return COMP_UI_M_BUT_UPI;
	}

	public void setCOMP_UI_M_BUT_UPI(HtmlCommandButton comp_ui_m_but_upi) {
		COMP_UI_M_BUT_UPI = comp_ui_m_but_upi;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_UPLOAD() {
		return COMP_UI_M_BUT_UPLOAD;
	}

	public void setCOMP_UI_M_BUT_UPLOAD(HtmlCommandButton comp_ui_m_but_upload) {
		COMP_UI_M_BUT_UPLOAD = comp_ui_m_but_upload;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLAIM() {
		return COMP_UI_M_BUT_CLAIM;
	}

	public void setCOMP_UI_M_BUT_CLAIM(HtmlCommandButton comp_ui_m_but_claim) {
		COMP_UI_M_BUT_CLAIM = comp_ui_m_but_claim;
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
	public HtmlCommandButton getCOMP_UI_M_BUT_PREM_ALLOC() {
		return COMP_UI_M_BUT_PREM_ALLOC;
	}

	public void setCOMP_UI_M_BUT_PREM_ALLOC(HtmlCommandButton COMP_UI_M_BUT_PREM_ALLOC) {
		this.COMP_UI_M_BUT_PREM_ALLOC = COMP_UI_M_BUT_PREM_ALLOC;
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputLabel comp_ui_m_apprv_status) {
		COMP_UI_M_APPRV_STATUS = comp_ui_m_apprv_status;
	}
	
	public String convertButtonAction(){
		  DUMMY_HELPER dummy_helper = new DUMMY_HELPER();

		String outCome = "PILT002_APAC_PT_IL_CONVERT";
		try {
			 dummy_helper.UI_M_BUT_CONVERT_WHEN_BUTTON_PRESSED(compositeAction );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outCome;
	} 
	public String convertOKButtonAction(){
	    DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
	   String outCome=null;
	    try {
		outCome= dummy_helper.UI_M_BUT_OK_WHEN_BUTTON_PRESSED(compositeAction );
		COMP_UI_M_POL_NO.resetValue();
	    } catch (Exception e) {
		e.printStackTrace();
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put("CONVERT",e.getMessage());
		
		
	    }
	    return outCome;
	} 
	
	public String prmdtlsButtonAction(){
	    DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
	    
	    String outCome = "PILT002_APAC_PT_IL_POLICY";
	    try {
		dummy_helper.UI_M_BUT_PRMDTLS_WHEN_BUTTON_PRESSED(compositeAction );
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    return outCome;
	} 
	public String uddateStatButtonAction(){
	    DUMMY_HELPER dummy_helper = new DUMMY_HELPER();
	    
	    String outCome = "PILT002_APAC_PT_IL_POLICY";
	    try {
		dummy_helper.UI_M_BUT_UDDATE_STAT_WHEN_BUTTON_PRESSED(compositeAction );
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    return outCome;
	} 

	
	public String endtQuotButtonAction( ){
	  //  GO_BLOCK('PT_IL_POLICY2');
	    return "PILT002_APAC_PT_IL_POLICY2"; 

	 
	}
	 
	 public String  surrMatButtonAction( ){
		 
		   // GO_BLOCK('PT_IL_SURR_MAT_VALUES');
		 return "PILT002_APAC_PT_IL_SURR_MAT_VALUES";
	}
	 
	 public String  goToPolicy( ){
	     return "PILT002_APAC_PT_IL_POLICY";
	 }
	 
	 
	public String  premAllocButtonAction(  ){
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
		    CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",pt_il_policy_bean.getPOL_NO() );
		  //  CALL_FORM('PILT010',NO_HIDE,NO_REPLACE);
		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		}
		return "PILT010";
	}


	public String UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED( ){
		String outcome=null;
		try {
		 outcome=  new DUMMY_HELPER().UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED(compositeAction);
		//   outcome="PILT002_APAC_PT_IL_POLICY";
			//new DUMMY_HELPER().UI_M_PT_ENDT_OK_WHEN_BUTTON_PRESSED(compositeAction);
			outcome="backToPolicyFromEndorsement";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return outcome;
	    }
	
	public String holdButtonAction( ){
	    String outcome=null;
	    try {
		new DUMMY_HELPER().UI_M_BUT_HOLD_WHEN_BUTTON_PRESSED( compositeAction);
		outcome="PILT002_APAC_PT_IL_POL_STATUS";
	    } catch (Exception e) {
		// TODO: handle exception
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put("Hold",e.getMessage());
		e.printStackTrace();
	    }
	    return outcome;
	}
	
	
	public String polAmdtButtonAction( ){
	    String outcome=null;
	    try {
		new DUMMY_HELPER().UI_M_BUT_POL_AMDT_WHEN_BUTTON_PRESSED( compositeAction);
		outcome="PILT002_APAC_PT_IL_POLICY";
	    } catch (Exception e) {
		// TODO: handle exception
		 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put("polAmdt",e.getMessage());
		e.printStackTrace();
	    }
	    return outcome;
	}
	
	public String   calcDiscLoadButtonAction( ){
	    String outcome=null;
	    try {
		new DUMMY_HELPER().UI_M_BUT_CALC_DISC_LOAD_WHEN_BUTTON_PRESSED(compositeAction);
		outcome="PILT002_APAC_PT_IL_POL_DISC_LOAD";
		new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
	    } catch (Exception e) {
		// TODO: handle exception
		
		e.printStackTrace();
	    }
	    return outcome;
	}
	
	public String  fundQueryButtonAction( ){
	    PT_IL_POLICY pt_il_policy_bean = compositeAction
	    .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	    try {
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",pt_il_policy_bean.getPOL_NO() );
		//   CALL_FORM('PILQ106_APAC',NO_HIDE,NO_REPLACE);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	    }
	    return "PILQ106_APAC";
	}
	
	public String UI_M_BUT_FUND_QUERY_WHEN_BUTTON_PRESSED( ){
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",pt_il_policy_bean.getPOL_NO() );
			//   CALL_FORM('PILQ106_APAC',NO_HIDE,NO_REPLACE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "PILQ106_APAC";
	}
	 public String  uploadButtonAction( ){
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",pt_il_policy_bean.getPOL_SYS_ID().toString());
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_END_NO_IDX",pt_il_policy_bean.getPOL_END_NO_IDX().toString());

			//  CALL_FORM('PILT022',NO_HIDE,NO_REPLACE);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "PILT022";
	    }
	
	 public String  claimButtonAction(  ){
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {

			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",pt_il_policy_bean.getPOL_SYS_ID().toString());
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_END_NO_IDX",pt_il_policy_bean.getPOL_END_NO_IDX().toString());

			//  CALL_FORM('PILQ104_APAC',NO_HIDE,NO_REPLACE);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "PILQ104_APAC";
	    }
	 
	 public String  upiButtonAction( ){
		  //  GO_BLOCK('PT_IL_UNPAID_PREM_DTLS');
		 return "PILT002_APAC_PT_IL_UNPAID_PREM_DTLS";
	    }
	 
	 public String  fundDtlButtonAction( ){
	     return "PILT002_APAC_PT_IL_POL_FUND_DTL";
	 }
 
	 public String  customerButtonAction( ){
	     PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	     DUMMY_HELPER dummy_helper =new DUMMY_HELPER();
	     String outCome=null;
		try {
		    outCome = dummy_helper.UI_M_BUT_CUSTOMER_WHEN_BUTTON_PRESSED(pt_il_policy_bean);
		} catch (Exception e) {
			// TODO: handle exception
		    compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put("customer",e.getMessage());
			e.printStackTrace();
		}
		return outCome;
	 }
	 
	 public String  contractorButtonAction( ){
	     PT_IL_POLICY pt_il_policy_bean = compositeAction
	     .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	     DUMMY_HELPER dummy_helper =new DUMMY_HELPER();
	     String outCome=null;
	     try {
		 outCome = dummy_helper.UI_M_BUT_CONTRACTOR_WHEN_BUTTON_PRESSED(pt_il_policy_bean);
	     } catch (Exception e) {
		 // TODO: handle exception
		 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put("contractor",e.getMessage());
		 e.printStackTrace();
	     }
	     return outCome;
	 }
	 
	 public  String keycommitButtonAction() {
	    DUMMY_HELPER dummy_helper =new DUMMY_HELPER();
	    String outcome = null;
	    
	    try {
		//save the Policy details before calling key commit
		
		 saveRecord(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		 outcome = dummy_helper.keyCommit(compositeAction);
		 saveRecord(compositeAction.getPT_IL_POLICY_ACTION_BEAN());
		 new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
	    } catch (Exception e) {
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getErrorMap().put("KEY_COMMIT",e.getMessage());
			 //getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			//getErrorMap().put("SAVE", e.getMessage());
			e.printStackTrace();
	    }
	    
	    return outcome;
	}
	 
	 public void saveRecord(PT_IL_POLICY_ACTION pt_il_policy_action) {
	    	String message = null;
	    	PT_IL_POLICY_HELPER helper = new PT_IL_POLICY_HELPER();
		try {
		    if (pt_il_policy_action.getPT_IL_POLICY_BEAN().getROWID() != null) {
			if(isUPDATE_ALLOWED()){
			    	helper.PRE_UPDATE(compositeAction);
	        	    	new CRUDHandler().executeInsert(pt_il_policy_action.getPT_IL_POLICY_BEAN(),CommonUtils.getConnection());
	        	    	helper.POST_UPDATE(pt_il_policy_action.getPT_IL_POLICY_BEAN(), compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			}
		    } else {
			if(isINSERT_ALLOWED()){
	        	    	helper.PRE_INSERT(compositeAction);
	        	    	new CRUDHandler().executeInsert(pt_il_policy_action.getPT_IL_POLICY_BEAN(),CommonUtils.getConnection());
	        	    	helper.POST_INSERT(compositeAction);
			}
		    }
		    CommonUtils.getConnection().commit();
			 
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	    }

	 public String instPaymt1(){
		 return "PILT002_APAC_PT_IL_POL_SA_INST_PYMT_HEAD" ;
	 }
	 
	 public String instPaymt(){
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

	public void setCOMP_UI_M_POL_CONVERT_YN(HtmlOutputLabel comp_ui_m_pol_convert_yn) {
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

	public void setCOMP_UI_M_BUT_MATURITY(HtmlCommandButton comp_ui_m_but_maturity) {
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

	public void setCOMP_UI_M_PROP_NO_LABEL(HtmlOutputLabel comp_ui_m_prop_no_label) {
		COMP_UI_M_PROP_NO_LABEL = comp_ui_m_prop_no_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONV_DT_LABEL() {
		return COMP_UI_M_CONV_DT_LABEL;
	}

	public void setCOMP_UI_M_CONV_DT_LABEL(HtmlOutputLabel comp_ui_m_conv_dt_label) {
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

	public List<com.iii.premia.common.bean.LovBean> lovUI_M_POL_DOC_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"DUMMY", "M_POL_DOC_CODE", null, null, null, null,
					null, (String) currValue);
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
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_POL_DOC_CODE				 = new HtmlInputText();
		COMP_UI_M_POL_DOC_DESC				 = new HtmlInputText();
		COMP_UI_M_PS_STATUS				 = new HtmlInputText();
		COMP_UI_M_POL_NO				 = new HtmlInputText();
		COMP_UI_M_PROP_NO				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_FORM_CONVERT_CAPTION			 = new HtmlOutputLabel();
		COMP_UI_M_APPRV_STATUS				 = new HtmlOutputLabel();
		COMP_UI_M_ICON_HINT				 = new HtmlOutputLabel();
		COMP_UI_M_BUS_STATUS				 = new HtmlOutputLabel();
		COMP_UI_M_END_STATUS				 = new HtmlOutputLabel();
		COMP_UI_M_ADDL_STATUS_DESC			 = new HtmlOutputLabel();
		COMP_UI_M_END_IDX_TYPE_NO			 = new HtmlOutputLabel();
		COMP_UI_M_AMEND_IDX				 = new HtmlOutputLabel();
		COMP_UI_M_CLM_ADDL_STATUS			 = new HtmlOutputLabel();
		COMP_UI_M_CIC_STATUS				 = new HtmlOutputLabel();
		COMP_UI_M_WAI_STATUS				 = new HtmlOutputLabel();
		COMP_UI_M_HOLD_STATUS				 = new HtmlOutputLabel();
		COMP_POL_APPRV_UID				 = new HtmlOutputLabel();
		COMP_POL_TRAN_DT				 = new HtmlOutputLabel();
		COMP_UI_M_POL_CONVERT_YN			 = new HtmlOutputLabel();
		COMP_UI_M_PROP_NO_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_CONV_DT_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_POL_NO_LABEL				 = new HtmlOutputLabel();
		COMP_COMP_UI_M_POL_DOC_CODE_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POL_DOC_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POL_NO_LABEL				 = new HtmlOutputLabel();
		// Instantiating HtmlCalendar
		COMP_UI_M_PS_STATUS_DT				 = new HtmlCalendar();
		COMP_UI_M_CONV_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_ENDT				 = new HtmlCommandButton();
		COMP_UI_M_BUT_COPY				 = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVAL				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CUSTOMER				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CONTRACTOR			 = new HtmlCommandButton();
		COMP_UI_M_BUT_HOLD				 = new HtmlCommandButton();
		COMP_UI_M_BUT_FUND_DTL				 = new HtmlCommandButton();
		COMP_UI_M_BUT_OCC_RATE_PAYOR			 = new HtmlCommandButton();
		COMP_UI_M_BUT_OCC_RATE_PAYEE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_DOC_GEN_NO			 = new HtmlCommandButton();
		COMP_UI_M_BUT_FUND_QUERY			 = new HtmlCommandButton();
		COMP_UI_M_BUT_ADD_DETAILS			 = new HtmlCommandButton();
		COMP_UI_M_BUT_MORE_COVER			 = new HtmlCommandButton();
		COMP_UI_M_BUT_UDDATE_STAT			 = new HtmlCommandButton();
		COMP_UI_M_BUT_PRMDTLS				 = new HtmlCommandButton();
		COMP_UI_M_BUT_POL_AMDT				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CALC_DISC_LOAD			 = new HtmlCommandButton();
		COMP_UI_M_BUT_ANN_DTLS				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CONVERT				 = new HtmlCommandButton();
		COMP_UI_M_BUS_RUL				 = new HtmlCommandButton();
		COMP_UI_M_BUT_PREM_ALLOC			 = new HtmlCommandButton();
		COMP_UI_M_BUT_SURR_MAT				 = new HtmlCommandButton();
		COMP_UI_M_BUT_UPI				 = new HtmlCommandButton();
		COMP_UI_M_BUT_UPLOAD				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CLAIM				 = new HtmlCommandButton();
		COMP_UI_M_BUT_REPLACE_POLICY			 = new HtmlCommandButton();
		COMP_UI_M_BUT_ASSR_MORE_INFO			 = new HtmlCommandButton();
		COMP_UI_M_ENDT_QUOT				 = new HtmlCommandButton();
		COMP_UI_M_BUT_MATURITY				 = new HtmlCommandButton();

	}
	public String onBUT_MATURITYClicked() {
		String SIPH_NAV_TYPE = null;
		String outCome = null;
		SIPH_NAV_TYPE = compositeAction.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN()
			.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN().getSIPH_NAV_TYPE();
		if("I".equalsIgnoreCase(CommonUtils.nvl(SIPH_NAV_TYPE, "A"))){
			outCome = "PILT002_APAC_PT_IL_POL_SA_INST_PYMT";
		}else if("B".equalsIgnoreCase(CommonUtils.nvl(SIPH_NAV_TYPE, "A")) 
				|| "D".equalsIgnoreCase(CommonUtils.nvl(SIPH_NAV_TYPE, "A"))){
			outCome = "PILT002_APAC_PT_IL_POL_SA_INST_PYMT1";
		}else{
			outCome = "";
		}
		return outCome;
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

	public void setCOMP_UI_M_PS_REASON_CODE(HtmlInputText comp_ui_m_ps_reason_code) {
	    COMP_UI_M_PS_REASON_CODE = comp_ui_m_ps_reason_code;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_KEY_COMMIT() {
	    return COMP_UI_M_BUT_KEY_COMMIT;
	}

	public void setCOMP_UI_M_BUT_KEY_COMMIT(
		HtmlCommandButton comp_ui_m_but_key_commit) {
	    COMP_UI_M_BUT_KEY_COMMIT = comp_ui_m_but_key_commit;
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

	public void setCOMP_UI_M_COMPY_FC_CHARGE(HtmlInputText comp_ui_m_compy_fc_charge) {
	    COMP_UI_M_COMPY_FC_CHARGE = comp_ui_m_compy_fc_charge;
	}

	public HtmlInputText getCOMP_UI_M_COMPY_LC_CHARGE() {
	    return COMP_UI_M_COMPY_LC_CHARGE;
	}

	public void setCOMP_UI_M_COMPY_LC_CHARGE(HtmlInputText comp_ui_m_compy_lc_charge) {
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
			    	compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
			    	,(String)value);
		    
		} catch (Exception exception) {
		    exception.printStackTrace();
		    throw new ValidatorException(new FacesMessage(exception
			    .getMessage()));
		} finally {
		    try {
			ErrorHelpUtil.getWarningForProcedure(CommonUtils
				.getConnection(), "UI_M_POL_DOC_CODE",
				getWarningMap());
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

	public HtmlInputText getCOMP_UI_M_PS_REMARKS() {
	    return COMP_UI_M_PS_REMARKS;
	}

	public void setCOMP_UI_M_PS_REMARKS(HtmlInputText comp_ui_m_ps_remarks) {
	    COMP_UI_M_PS_REMARKS = comp_ui_m_ps_remarks;
	}

	public HtmlInputText getCOMP_UI_M_POL_MEDICAL_FLAG() {
	    return COMP_UI_M_POL_MEDICAL_FLAG;
	}

	public void setCOMP_UI_M_POL_MEDICAL_FLAG(
		HtmlInputText comp_ui_m_pol_medical_flag) {
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

}	
