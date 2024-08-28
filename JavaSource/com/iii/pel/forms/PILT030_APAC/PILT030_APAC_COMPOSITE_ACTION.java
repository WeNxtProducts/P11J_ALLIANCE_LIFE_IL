package com.iii.pel.forms.PILT030_APAC;

import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;

public class PILT030_APAC_COMPOSITE_ACTION {
	
	private TabbedBar tabbedBar =null;
	private PT_IL_PAYVOU_HDR_ACTION PILT030_APAC_PT_IL_PAYVOU_HDR_ACTION;
	private PT_IL_PAYVOU_AMT_DTL_ACTION PILT030_APAC_PT_IL_PAYVOU_AMT_DTL_ACTION;
	private PT_IL_PAYVOU_DRCR_DTL_ACTION PILT030_APAC_PT_IL_PAYVOU_DRCR_DTL_ACTION;
	private PT_IL_PAYVOU_PAY_DTL_ACTION PILT030_APAC_PT_IL_PAYVOU_PAY_DTL_ACTION;
	private DUMMY_ACTION PILT030_APAC_DUMMY_ACTION;
	private DUMMY_BUTTON_ACTION PILT030_APAC_DUMMY_BUTTON_ACTION;
	private BUTTON_PALETTE_ACTION PILT030_APAC_BUTTON_PALETTE_ACTION;
	private CTRL_ACTION PILT030_APAC_CTRL_ACTION;
	private BP_ACTION PILT030_APAC_BP_ACTION;
	private ERROR_HELP_ACTION PILT030_APAC_ERROR_HELP_ACTION;
	
	public PILT030_APAC_COMPOSITE_ACTION(){
		PILT030_APAC_PT_IL_PAYVOU_HDR_ACTION = new PT_IL_PAYVOU_HDR_ACTION();
		PILT030_APAC_PT_IL_PAYVOU_AMT_DTL_ACTION = new PT_IL_PAYVOU_AMT_DTL_ACTION();
		PILT030_APAC_PT_IL_PAYVOU_DRCR_DTL_ACTION = new PT_IL_PAYVOU_DRCR_DTL_ACTION();
		PILT030_APAC_PT_IL_PAYVOU_PAY_DTL_ACTION = new PT_IL_PAYVOU_PAY_DTL_ACTION();
		PILT030_APAC_DUMMY_ACTION = new DUMMY_ACTION();
		PILT030_APAC_DUMMY_BUTTON_ACTION = new DUMMY_BUTTON_ACTION();
		PILT030_APAC_BUTTON_PALETTE_ACTION = new BUTTON_PALETTE_ACTION();
		PILT030_APAC_CTRL_ACTION = new CTRL_ACTION();
		PILT030_APAC_BP_ACTION = new BP_ACTION();
		PILT030_APAC_ERROR_HELP_ACTION = new ERROR_HELP_ACTION();
		tabbedBar = new TabbedBar();
		try {
			tabbedBar.addTab(1, "#{PILT030_APAC_COMPOSITE_ACTION.payVoucherHeader}", "Payment Voucher Header", false);
			tabbedBar.addTab(2, "#{PILT030_APAC_COMPOSITE_ACTION.payVoucherAmountDetails}", "Customer Amount Details", false);
			tabbedBar.addTab(3, "#{PILT030_APAC_COMPOSITE_ACTION.payVoucherTransactionDetails}", "DRCR Transaction Details", false);
			tabbedBar.addTab(4, "#{PILT030_APAC_COMPOSITE_ACTION.payVoucherDetails}", "Payment Voucher Details", false);
		} catch (Exception e) {
		}
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public PT_IL_PAYVOU_HDR_ACTION getPILT030_APAC_PT_IL_PAYVOU_HDR_ACTION() {
		return PILT030_APAC_PT_IL_PAYVOU_HDR_ACTION;
	}

	public void setPILT030_APAC_PT_IL_PAYVOU_HDR_ACTION(
			PT_IL_PAYVOU_HDR_ACTION pilt030_apac_pt_il_payvou_hdr_action) {
		PILT030_APAC_PT_IL_PAYVOU_HDR_ACTION = pilt030_apac_pt_il_payvou_hdr_action;
	}

	public PT_IL_PAYVOU_AMT_DTL_ACTION getPILT030_APAC_PT_IL_PAYVOU_AMT_DTL_ACTION() {
		return PILT030_APAC_PT_IL_PAYVOU_AMT_DTL_ACTION;
	}

	public void setPILT030_APAC_PT_IL_PAYVOU_AMT_DTL_ACTION(
			PT_IL_PAYVOU_AMT_DTL_ACTION pilt030_apac_pt_il_payvou_amt_dtl_action) {
		PILT030_APAC_PT_IL_PAYVOU_AMT_DTL_ACTION = pilt030_apac_pt_il_payvou_amt_dtl_action;
	}

	public PT_IL_PAYVOU_DRCR_DTL_ACTION getPILT030_APAC_PT_IL_PAYVOU_DRCR_DTL_ACTION() {
		return PILT030_APAC_PT_IL_PAYVOU_DRCR_DTL_ACTION;
	}

	public void setPILT030_APAC_PT_IL_PAYVOU_DRCR_DTL_ACTION(
			PT_IL_PAYVOU_DRCR_DTL_ACTION pilt030_apac_pt_il_payvou_drcr_dtl_action) {
		PILT030_APAC_PT_IL_PAYVOU_DRCR_DTL_ACTION = pilt030_apac_pt_il_payvou_drcr_dtl_action;
	}

	public PT_IL_PAYVOU_PAY_DTL_ACTION getPILT030_APAC_PT_IL_PAYVOU_PAY_DTL_ACTION() {
		return PILT030_APAC_PT_IL_PAYVOU_PAY_DTL_ACTION;
	}

	public void setPILT030_APAC_PT_IL_PAYVOU_PAY_DTL_ACTION(
			PT_IL_PAYVOU_PAY_DTL_ACTION pilt030_apac_pt_il_payvou_pay_dtl_action) {
		PILT030_APAC_PT_IL_PAYVOU_PAY_DTL_ACTION = pilt030_apac_pt_il_payvou_pay_dtl_action;
	}

	public DUMMY_ACTION getPILT030_APAC_DUMMY_ACTION() {
		return PILT030_APAC_DUMMY_ACTION;
	}

	public void setPILT030_APAC_DUMMY_ACTION(DUMMY_ACTION pilt030_apac_dummy_action) {
		PILT030_APAC_DUMMY_ACTION = pilt030_apac_dummy_action;
	}

	public DUMMY_BUTTON_ACTION getPILT030_APAC_DUMMY_BUTTON_ACTION() {
		return PILT030_APAC_DUMMY_BUTTON_ACTION;
	}

	public void setPILT030_APAC_DUMMY_BUTTON_ACTION(
			DUMMY_BUTTON_ACTION pilt030_apac_dummy_button_action) {
		PILT030_APAC_DUMMY_BUTTON_ACTION = pilt030_apac_dummy_button_action;
	}

	public BUTTON_PALETTE_ACTION getPILT030_APAC_BUTTON_PALETTE_ACTION() {
		return PILT030_APAC_BUTTON_PALETTE_ACTION;
	}

	public void setPILT030_APAC_BUTTON_PALETTE_ACTION(
			BUTTON_PALETTE_ACTION pilt030_apac_button_palette_action) {
		PILT030_APAC_BUTTON_PALETTE_ACTION = pilt030_apac_button_palette_action;
	}

	public CTRL_ACTION getPILT030_APAC_CTRL_ACTION() {
		return PILT030_APAC_CTRL_ACTION;
	}

	public void setPILT030_APAC_CTRL_ACTION(CTRL_ACTION pilt030_apac_ctrl_action) {
		PILT030_APAC_CTRL_ACTION = pilt030_apac_ctrl_action;
	}

	public BP_ACTION getPILT030_APAC_BP_ACTION() {
		return PILT030_APAC_BP_ACTION;
	}

	public void setPILT030_APAC_BP_ACTION(BP_ACTION pilt030_apac_bp_action) {
		PILT030_APAC_BP_ACTION = pilt030_apac_bp_action;
	}

	public ERROR_HELP_ACTION getPILT030_APAC_ERROR_HELP_ACTION() {
		return PILT030_APAC_ERROR_HELP_ACTION;
	}

	public void setPILT030_APAC_ERROR_HELP_ACTION(
			ERROR_HELP_ACTION pilt030_apac_error_help_action) {
		PILT030_APAC_ERROR_HELP_ACTION = pilt030_apac_error_help_action;
	}
	
	public String payVoucherHeader(){
		getPILT030_APAC_PT_IL_PAYVOU_HDR_ACTION().setOnLoadFlag(false);
		return PILT030_APAC_CONSTANTS.PAGE_PAYVOU_HDR;
	}
	
	public String payVoucherAmountDetails(){
		getPILT030_APAC_PT_IL_PAYVOU_AMT_DTL_ACTION().setOnLoadFlag(false);
		return PILT030_APAC_CONSTANTS.PAGE_PAYVOU_AMT_DTLS;
	}
	
	public String payVoucherTransactionDetails(){
		getPILT030_APAC_PT_IL_PAYVOU_DRCR_DTL_ACTION().setOnLoadFlag(false);
		return PILT030_APAC_CONSTANTS.PAGE_DRCR_DTLS;
	}
	
	public String payVoucherDetails(){
		getPILT030_APAC_PT_IL_PAYVOU_PAY_DTL_ACTION().setOnLoadFlag(false);
		return PILT030_APAC_CONSTANTS.PAGE_PAYMENT_DTLS;
	}

}
