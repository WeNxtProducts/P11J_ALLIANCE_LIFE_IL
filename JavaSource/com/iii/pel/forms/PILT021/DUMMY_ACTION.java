package com.iii.pel.forms.PILT021;

import java.sql.ResultSet;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputText;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION extends CommonAction {

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlCommandButton COMP_UI_M_WITHDRAWAL_STATUS;

	private HtmlCommandButton COMP_UI_M_BUT_REP_POLICY;

	private HtmlCommandButton COMP_UI_M_BUT_FUND_ALLOC;

	private HtmlCommandButton COMP_UI_M_BUT_POL_HIST;
	
	/* Newly Added By Dhinesh on 20-03-2018 */
	private HtmlCommandButton COMP_UI_M_BUT_REJECT;

	public HtmlCommandButton getCOMP_UI_M_BUT_REJECT() {
		return COMP_UI_M_BUT_REJECT;
	}

	public void setCOMP_UI_M_BUT_REJECT(HtmlCommandButton cOMP_UI_M_BUT_REJECT) {
		COMP_UI_M_BUT_REJECT = cOMP_UI_M_BUT_REJECT;
	}

	
	
	/*End*/
	
	

	private HtmlOutputText COMP_UI_M_APPRV_STATUS;

	private HtmlCalendar COMP_UI_M_APPRV_DT;

	private DUMMY DUMMY_BEAN;

	private DUMMY_HELPER helper;

	public PILT021_COMPOSITE_ACTION compositeAction;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
		instantiateAllComponent();
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton comp_ui_m_but_process) {
		COMP_UI_M_BUT_PROCESS = comp_ui_m_but_process;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton comp_ui_m_but_approve) {
		COMP_UI_M_BUT_APPROVE = comp_ui_m_but_approve;
	}

	public HtmlCommandButton getCOMP_UI_M_WITHDRAWAL_STATUS() {
		return COMP_UI_M_WITHDRAWAL_STATUS;
	}

	public void setCOMP_UI_M_WITHDRAWAL_STATUS(
			HtmlCommandButton comp_ui_m_withdrawal_status) {
		COMP_UI_M_WITHDRAWAL_STATUS = comp_ui_m_withdrawal_status;
	}

	public HtmlOutputText getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputText comp_ui_m_apprv_status) {
		COMP_UI_M_APPRV_STATUS = comp_ui_m_apprv_status;
	}

	public HtmlCalendar getCOMP_UI_M_APPRV_DT() {
		return COMP_UI_M_APPRV_DT;
	}

	public void setCOMP_UI_M_APPRV_DT(HtmlCalendar comp_ui_m_apprv_dt) {
		COMP_UI_M_APPRV_DT = comp_ui_m_apprv_dt;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REP_POLICY() {
		return COMP_UI_M_BUT_REP_POLICY;
	}

	public void setCOMP_UI_M_BUT_REP_POLICY(
			HtmlCommandButton comp_ui_m_but_rep_policy) {
		COMP_UI_M_BUT_REP_POLICY = comp_ui_m_but_rep_policy;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FUND_ALLOC() {
		return COMP_UI_M_BUT_FUND_ALLOC;
	}

	public void setCOMP_UI_M_BUT_FUND_ALLOC(
			HtmlCommandButton comp_ui_m_but_fund_alloc) {
		COMP_UI_M_BUT_FUND_ALLOC = comp_ui_m_but_fund_alloc;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_HIST() {
		return COMP_UI_M_BUT_POL_HIST;
	}

	public void setCOMP_UI_M_BUT_POL_HIST(
			HtmlCommandButton comp_ui_m_but_pol_hist) {
		COMP_UI_M_BUT_POL_HIST = comp_ui_m_but_pol_hist;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public String onClickApproveButton() {
		String output = null;
		try {
			output = helper
					.WHEN_BUTTON_PRESSED_M_BUTTON_APPROVE(compositeAction);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,	"Withdrawl Approved successfully");
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, "Withdrawl Approved successfully");
		} catch (Exception e) {
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getErrorMap()
					.put("onClickApproveButton", e.getMessage());
		}
		return output;
	}

	public String onClickNewApproveButton() {
		String output = null;
		try {
			helper.WHEN_BUTTON_PRESSED_NEW_M_BUTTON_APPROVE(compositeAction);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,	"Withdrawl Approved successfully");
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, "Withdrawl Approved successfully");
			/*Added by Ameen on 24-12-2018 for FSD_IL_10_Surrender/Partial withdrawal*/
			String M_WD_APPRV_STATUS = null;
			ResultSet aprvRs = new CRUDHandler().executeSelectStatement("SELECT WD_APPRV_STATUS FROM PT_IL_WITHDRAWAL WHERE WD_POL_NO = ?", 
										CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getUI_M_POL_NO()});
			if(aprvRs.next()){
				M_WD_APPRV_STATUS = aprvRs.getString("WD_APPRV_STATUS");
			}
			if(null != M_WD_APPRV_STATUS && "A".equalsIgnoreCase(M_WD_APPRV_STATUS))
				compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().setWD_APPRV_STATUS(M_WD_APPRV_STATUS);
			/*end*/
		} catch (Exception e) {
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getErrorMap()
					.put("onClickApproveButton", e.getMessage());
		}
		return output;
	}
	
	public String onClickRep_Policy() {
		String output = null;
		DUMMY dummy = null;
		PT_IL_WITHDRAWAL pt_il_withdrawal = null;
		try {
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			pt_il_withdrawal = compositeAction
					.getPT_IL_WITHDRAWAL_ACTION_BEAN()
					.getPT_IL_WITHDRAWAL_BEAN();
			output = helper.WHEN_BUTTON_PRESSED_M_BUT_REP_POLICY(dummy,
					pt_il_withdrawal);
			//Added by akash set as a calling form.
			CommonUtils.setGlobalVariable("PILT021", "PILT021");
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onClickRep_Policy", e.getMessage());
		}
		return output;
	}

	public String onClickWithdrawal_Status() {
		String output = null;
		DUMMY dummy = null;
		try {
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_BUTTON_PRESSED_M_WITHDRAWAL_STATUS(dummy);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onClickWithdrawal_Status", e.getMessage());
		}
		return output;
	}

	public String onClickFund_Alloc() {
		String output = null;
		PT_IL_WITHDRAWAL pt_il_withdrawal = null;
		pt_il_withdrawal = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
				.getPT_IL_WITHDRAWAL_BEAN();
		output = helper.WHEN_BUTTON_PRESSED_M_BUT_FUND_ALLOC(pt_il_withdrawal);
		return output;
	}

	public String onClickProcess() {
		String output = null;
		try {
			helper.checkFreeze(compositeAction);
			output = helper.WHEN_BUTTON_PRESSED_M_BUT_PROCESS(compositeAction);			
			//added by gopi for call id ZBLIFE-1457793 on 11/12/17
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,	"Withdrawl calculated successfully");
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, "Withdrawl calculated successfully");
		//end
		} catch (Exception e) {
			
			/*Commentted &Modified by saritha on 06-12-2017 for Error msg display*/
			
			/*getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onClickProcess", e.getMessage());*/
			
			String error =ErrorHelpUtil.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,error);
			e.printStackTrace();
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getErrorMap().put("onClickProcess", e.getMessage());
			
			/*End*/
			
		}
		return output;
	}

	public String onClickPol_History() {
		String output = null;
		PT_IL_WITHDRAWAL pt_il_withdrawal = null;
		pt_il_withdrawal = compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
				.getPT_IL_WITHDRAWAL_BEAN();
		output = helper.WHEN_BUTTON_PRESSED_M_BUT_POL_HIST(pt_il_withdrawal);
		return output;
	}
	
	public void instantiateAllComponent(){
		 COMP_UI_M_BUT_PROCESS =  new HtmlCommandButton();

		 COMP_UI_M_BUT_APPROVE = new HtmlCommandButton();

		 COMP_UI_M_WITHDRAWAL_STATUS = new HtmlCommandButton();

		 COMP_UI_M_BUT_REP_POLICY = new HtmlCommandButton();

		 COMP_UI_M_BUT_FUND_ALLOC = new HtmlCommandButton();

		 COMP_UI_M_BUT_POL_HIST = new HtmlCommandButton();

		 COMP_UI_M_APPRV_STATUS = new HtmlOutputText();

		 COMP_UI_M_APPRV_DT = new HtmlCalendar();
		 
		 /*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
		 COMP_UI_M_BUS_RUL = new HtmlCommandButton();
		 /*End*/
		 
		 /*Added By Dhinesh on 20-03-2018*/
		 COMP_UI_M_BUT_REJECT = new HtmlCommandButton();
		 /*End*/
		 
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
	
	
	/*Newly Added By Dhinesh on 20-03-2018*/
	
	public void onClickReject() {
		String output = null;
		try {
			helper.PAYOUT_REJECTION(compositeAction);
			/*Added by ganesh on 26-04-2018 suggested by ajoy to clearing existing values after clicking rejection button */
			/*compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,	"Withdrawal Rejected Successfully");
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, "Withdrawal Rejected Successfully");*/
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().setPT_IL_WITHDRAWAL_BEAN(new PT_IL_WITHDRAWAL());
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().resetAllComponent();
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,	"Withdrawal Rejected Successfully");
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, "Withdrawal Rejected Successfully");
			/*end*/
			
		} catch (Exception e) {
			
			String error =ErrorHelpUtil.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,error);
			e.printStackTrace();
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getErrorMap().put("onClickReject", e.getMessage());
			
		}
	}
	
	/*End*/
	
}
