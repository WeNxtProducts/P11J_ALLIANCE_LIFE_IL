package com.iii.pel.forms.PILP023;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.exception.DBException;

public class PILP023_COMPOSITE_ACTION {

	private BP_ACTION PILP023_BP_ACTION;
	private BUTTON_PALETTE_ACTION PILP023_BUTTON_PALETTE_ACTION;
	private CTRL_ACTION PILP023_CTRL_ACTION;
	private DUMMY_ACTION PILP023_DUMMY_ACTION;
	private ERROR_HELP_ACTION PILP023_ERROR_HELP_ACTION;
	private PT_IL_CHEQUE_BOUNCE_HDR_ACTION PILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION;
	private PT_IL_DEPOSIT_ACTION PILP023_PT_IL_DEPOSIT_ACTION;
	private PT_IL_LOAN_REPAYMENT_ACTION PILP023_PT_IL_LOAN_REPAYMENT_ACTION;
	private PT_IL_PREM_COLL_ACTION PILP023_PT_IL_PREM_COLL_ACTION;
	private PT_IL_PYMT_DTLS_ACTION PILP023_PT_IL_PYMT_DTLS_ACTION;
	private PILP023_SEARCH_ACTION SEARCH_ACTION_BEAN;
	
	
	Map<String, Object> session = null;
	//ControlBean ctrlBean = null;
	FacesContext ctx = null;
	
	/*public void createCtrlBean() {
		ControlBean bean = new ControlBean();
		session = ctx.getExternalContext().getSessionMap();
		session.put("ctrlbean", bean);
	}*/
	
	public PILP023_COMPOSITE_ACTION() throws DBException
	{
//		Connection connection = CommonUtils.getConnection();
		ctx = FacesContext.getCurrentInstance();
		//createCtrlBean();
		PILP023_BP_ACTION = new BP_ACTION();
		PILP023_BUTTON_PALETTE_ACTION = new BUTTON_PALETTE_ACTION();
		PILP023_CTRL_ACTION = new CTRL_ACTION();
		PILP023_DUMMY_ACTION = new DUMMY_ACTION();
		PILP023_ERROR_HELP_ACTION = new ERROR_HELP_ACTION();
		PILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION = new PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
		PILP023_PT_IL_DEPOSIT_ACTION = new PT_IL_DEPOSIT_ACTION();
		PILP023_PT_IL_LOAN_REPAYMENT_ACTION = new PT_IL_LOAN_REPAYMENT_ACTION();
		PILP023_PT_IL_PREM_COLL_ACTION = new PT_IL_PREM_COLL_ACTION();
		PILP023_PT_IL_PYMT_DTLS_ACTION = new PT_IL_PYMT_DTLS_ACTION();
		SEARCH_ACTION_BEAN = new PILP023_SEARCH_ACTION();
		
		PILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION.compositeAction = this;
		PILP023_PT_IL_LOAN_REPAYMENT_ACTION.compositeAction=this;
		PILP023_PT_IL_PYMT_DTLS_ACTION.compositeAction = this;
		PILP023_PT_IL_PREM_COLL_ACTION.compositeAction = this;
		PILP023_PT_IL_DEPOSIT_ACTION.compositeAction = this;
		
	}
	/*public void getConnection(){
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		Connection conn = null;
		String clientId = "LIFEALL"+Calendar.getInstance().getTimeInMillis();
		try {
			 conn = ((SimpleConnectionAgent) context.getAttribute("connectionAgent")).getConnection(clientId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("CLIENT_ID", clientId);
		sessionMap.put(clientId, conn);
	}*/

	public BP_ACTION getPILP023_BP_ACTION() {
		return PILP023_BP_ACTION;
	}

	public void setPILP023_BP_ACTION(BP_ACTION pilp023_bp_action) {
		PILP023_BP_ACTION = pilp023_bp_action;
	}

	public BUTTON_PALETTE_ACTION getPILP023_BUTTON_PALETTE_ACTION() {
		return PILP023_BUTTON_PALETTE_ACTION;
	}

	public void setPILP023_BUTTON_PALETTE_ACTION(
			BUTTON_PALETTE_ACTION pilp023_button_palette_action) {
		PILP023_BUTTON_PALETTE_ACTION = pilp023_button_palette_action;
	}

	public CTRL_ACTION getPILP023_CTRL_ACTION() {
		return PILP023_CTRL_ACTION;
	}

	public void setPILP023_CTRL_ACTION(CTRL_ACTION pilp023_ctrl_action) {
		PILP023_CTRL_ACTION = pilp023_ctrl_action;
	}

	public DUMMY_ACTION getPILP023_DUMMY_ACTION() {
		return PILP023_DUMMY_ACTION;
	}

	public void setPILP023_DUMMY_ACTION(DUMMY_ACTION pilp023_dummy_action) {
		PILP023_DUMMY_ACTION = pilp023_dummy_action;
	}

	public ERROR_HELP_ACTION getPILP023_ERROR_HELP_ACTION() {
		return PILP023_ERROR_HELP_ACTION;
	}

	public void setPILP023_ERROR_HELP_ACTION(
			ERROR_HELP_ACTION pilp023_error_help_action) {
		PILP023_ERROR_HELP_ACTION = pilp023_error_help_action;
	}

	public PT_IL_CHEQUE_BOUNCE_HDR_ACTION getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION() {
		return PILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION;
	}

	public void setPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION(
			PT_IL_CHEQUE_BOUNCE_HDR_ACTION pilp023_pt_il_cheque_bounce_hdr_action) {
		PILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION = pilp023_pt_il_cheque_bounce_hdr_action;
	}

	public PT_IL_DEPOSIT_ACTION getPILP023_PT_IL_DEPOSIT_ACTION() {
		return PILP023_PT_IL_DEPOSIT_ACTION;
	}

	public void setPILP023_PT_IL_DEPOSIT_ACTION(
			PT_IL_DEPOSIT_ACTION pilp023_pt_il_deposit_action) {
		PILP023_PT_IL_DEPOSIT_ACTION = pilp023_pt_il_deposit_action;
	}

	public PT_IL_LOAN_REPAYMENT_ACTION getPILP023_PT_IL_LOAN_REPAYMENT_ACTION() {
		return PILP023_PT_IL_LOAN_REPAYMENT_ACTION;
	}

	public void setPILP023_PT_IL_LOAN_REPAYMENT_ACTION(
			PT_IL_LOAN_REPAYMENT_ACTION pilp023_pt_il_loan_repayment_action) {
		PILP023_PT_IL_LOAN_REPAYMENT_ACTION = pilp023_pt_il_loan_repayment_action;
	}

	public PT_IL_PREM_COLL_ACTION getPILP023_PT_IL_PREM_COLL_ACTION() {
		return PILP023_PT_IL_PREM_COLL_ACTION;
	}

	public void setPILP023_PT_IL_PREM_COLL_ACTION(
			PT_IL_PREM_COLL_ACTION pilp023_pt_il_prem_coll_action) {
		PILP023_PT_IL_PREM_COLL_ACTION = pilp023_pt_il_prem_coll_action;
	}

	public PT_IL_PYMT_DTLS_ACTION getPILP023_PT_IL_PYMT_DTLS_ACTION() {
		return PILP023_PT_IL_PYMT_DTLS_ACTION;
	}

	public void setPILP023_PT_IL_PYMT_DTLS_ACTION(
			PT_IL_PYMT_DTLS_ACTION pilp023_pt_il_pymt_dtls_action) {
		PILP023_PT_IL_PYMT_DTLS_ACTION = pilp023_pt_il_pymt_dtls_action;
	}

	public PILP023_SEARCH_ACTION getSEARCH_ACTION_BEAN() {
		return SEARCH_ACTION_BEAN;
	}

	public void setSEARCH_ACTION_BEAN(PILP023_SEARCH_ACTION search_action_bean) {
		SEARCH_ACTION_BEAN = search_action_bean;
	}
	public String loanRepay()
	{
		getPILP023_PT_IL_LOAN_REPAYMENT_ACTION().loanQuery();
		return "loanRepay";
	}
	public String premColl()
	{
		getPILP023_PT_IL_PREM_COLL_ACTION().prem_coll_query();
		return "premColl";
	}
	public String deposit()
	{
		getPILP023_PT_IL_DEPOSIT_ACTION().depositDtls();
		return "depositDetails";
	}
}
