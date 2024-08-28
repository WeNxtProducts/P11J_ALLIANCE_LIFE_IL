package com.iii.pel.forms.PT044_A;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {

	private static final long serialVersionUID = 1L;
	
	private String PT_AGENT_TRAN_HDR_CF = null;
	private String PT_AGENT_TRAN_DTLS_CF = null;
	private String PT_AGENT_POL_DTLS_CF = null;
	private String PT_AGENT_CHKLST_STATUS_CF = null;
	
	public String getPT_AGENT_TRAN_HDR_CF() {
		return PT_AGENT_TRAN_HDR_CF;
	}
	public void setPT_AGENT_TRAN_HDR_CF(String pt_agent_tran_hdr_cf) {
		PT_AGENT_TRAN_HDR_CF = pt_agent_tran_hdr_cf;
	}
	public String getPT_AGENT_TRAN_DTLS_CF() {
		return PT_AGENT_TRAN_DTLS_CF;
	}
	public void setPT_AGENT_TRAN_DTLS_CF(String pt_agent_tran_dtls_cf) {
		PT_AGENT_TRAN_DTLS_CF = pt_agent_tran_dtls_cf;
	}
	public String getPT_AGENT_POL_DTLS_CF() {
		return PT_AGENT_POL_DTLS_CF;
	}
	public void setPT_AGENT_POL_DTLS_CF(String pt_agent_pol_dtls_cf) {
		PT_AGENT_POL_DTLS_CF = pt_agent_pol_dtls_cf;
	}
	public String getPT_AGENT_CHKLST_STATUS_CF() {
		return PT_AGENT_CHKLST_STATUS_CF;
	}
	public void setPT_AGENT_CHKLST_STATUS_CF(String pt_agent_chklst_status_cf) {
		PT_AGENT_CHKLST_STATUS_CF = pt_agent_chklst_status_cf;
	}

}
