package com.iii.pel.forms.PP0100;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POLICY")
public class PT_IL_POLICY extends BaseValueBean {
	
	@Column(name="POL_SYS_ID")
	private Long POL_SYS_ID;
	
	@Column(name="POL_NO")
	private String POL_NO;
	
	@Column(name="POL_CR_DT")
	private Date POL_CR_DT;
	
	@Column(name="POL_CR_UID")
	private String POL_CR_UID;
	
	@Column(name="POL_DISPATCH_DT")
	private Date POL_DISPATCH_DT;

	@Column(name="POL_DOC_ACK_DT")
	private Date POL_DOC_ACK_DT;

	public Long getPOL_SYS_ID() {
		return POL_SYS_ID;
	}

	public void setPOL_SYS_ID(Long pOL_SYS_ID) {
		POL_SYS_ID = pOL_SYS_ID;
	}

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String pOL_NO) {
		POL_NO = pOL_NO;
	}

	public Date getPOL_CR_DT() {
		return POL_CR_DT;
	}

	public void setPOL_CR_DT(Date pOL_CR_DT) {
		POL_CR_DT = pOL_CR_DT;
	}

	public String getPOL_CR_UID() {
		return POL_CR_UID;
	}

	public void setPOL_CR_UID(String pOL_CR_UID) {
		POL_CR_UID = pOL_CR_UID;
	}

	public Date getPOL_DISPATCH_DT() {
		return POL_DISPATCH_DT;
	}

	public void setPOL_DISPATCH_DT(Date pOL_DISPATCH_DT) {
		POL_DISPATCH_DT = pOL_DISPATCH_DT;
	}

	public Date getPOL_DOC_ACK_DT() {
		return POL_DOC_ACK_DT;
	}

	public void setPOL_DOC_ACK_DT(Date pOL_DOC_ACK_DT) {
		POL_DOC_ACK_DT = pOL_DOC_ACK_DT;
	}
	
}
