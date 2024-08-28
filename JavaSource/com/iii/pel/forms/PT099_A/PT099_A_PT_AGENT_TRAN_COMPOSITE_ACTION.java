package com.iii.pel.forms.PT099_A;

import java.util.HashMap;

import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION {
	
	private PT_AGENT_TRAN_HDR_ACTION PT_AGENT_TRAN_HDR_ACTION_BEAN;
	
	private PT_AGENT_PYMT_REVERSAL_DTLS_ACTION PT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN;
	
	private ControlBean CONTROL_BEAN;
	
	private TabbedBar tabbedBar;
	
	public static final int PT_AGENT_TRAN_HDR = 1;
	
	public static final int PT_AGENT_PYMT_REVERSAL_DTLS=2;
	
	public PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		String agentTranHdr=Messages.getString("messageProperties_PT099_A", "PT099_A$PT_AGENT_TRAN_HDR$displayCaption");
		
		String agentPymtReversalDtls=Messages.getString("messageProperties_PT099_A", "PT099_A$PT_AGENT_PYMT_REVERSAL_DTLS$displayCaption");
		
		try {
			CONTROL_BEAN = (ControlBean) CommonUtils.getControlBean().clone();
			tabbedBar.addTab(PT_AGENT_TRAN_HDR, "#{PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION.gotoPT_AGENT_TRAN_HDR}", agentTranHdr, false);
			tabbedBar.addTab(PT_AGENT_PYMT_REVERSAL_DTLS, "#{PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION.gotoPT_AGENT_PYMT_REVERSAL_DTLS}", agentPymtReversalDtls, false);
			
			PT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN= new PT_AGENT_PYMT_REVERSAL_DTLS_ACTION();
			
			PT_AGENT_TRAN_HDR_ACTION_BEAN =new PT_AGENT_TRAN_HDR_ACTION();
			
			PT_AGENT_TRAN_HDR_ACTION_BEAN.compositeAction = this;
			PT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN.compositeAction = this;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public PT_AGENT_TRAN_HDR_ACTION getPT_AGENT_TRAN_HDR_ACTION_BEAN() {
		return PT_AGENT_TRAN_HDR_ACTION_BEAN;
	}

	public void setPT_AGENT_TRAN_HDR_ACTION_BEAN(
			PT_AGENT_TRAN_HDR_ACTION pt_agent_tran_hdr_action_bean) {
		PT_AGENT_TRAN_HDR_ACTION_BEAN = pt_agent_tran_hdr_action_bean;
	}

	public PT_AGENT_PYMT_REVERSAL_DTLS_ACTION getPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN() {
		return PT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN;
	}

	public void setPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN(
			PT_AGENT_PYMT_REVERSAL_DTLS_ACTION pt_agent_pymt_reversal_dtls_action_bean) {
		PT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN = pt_agent_pymt_reversal_dtls_action_bean;
	}

	public ControlBean getCONTROL_BEAN() {
		return CONTROL_BEAN;
	}

	public void setCONTROL_BEAN(ControlBean control_bean) {
		CONTROL_BEAN = control_bean;
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}
	
	public String gotoPT_AGENT_TRAN_HDR(){
		String outcome = "agentTranHeader";
		
		// whenCreateRecord method is called in constructor of the Header-Action
		//PT_AGENT_TRAN_HDR_ACTION_BEAN.whenCreateRecord();
		
		return outcome;
	}
	public String gotoPT_AGENT_PYMT_REVERSAL_DTLS(){
		String outcome = "agentPymtReversalDtls";
		HashMap<String, String> errorMap = new HashMap<String, String>();
		PT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN.loadAgentPymtReversalDtls(errorMap);
		return outcome;
	}

	// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper 
	public void setRecordApproved(boolean approved){
		PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION compositeAction = (PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION");
		if(compositeAction != null){
			compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().setAllComponentsDisabled(approved);
			compositeAction.getPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN().setApproved(approved);
		}
	// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper ] 
	}
}
