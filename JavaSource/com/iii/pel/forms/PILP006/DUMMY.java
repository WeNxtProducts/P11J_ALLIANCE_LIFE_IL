package com.iii.pel.forms.PILP006;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {

	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	private String UI_M_POL_NO;

	private String UI_M_CLAIM_NO;
	
//	Added By Amit Gupta for OK Button Trigger
	private Long POL_SYS_ID;
	
//	Added By Amit Gupta for OK Button Trigger
	private Long CLAIM_SYS_ID;

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}

	public String getUI_M_CLAIM_NO() {
		return UI_M_CLAIM_NO;
	}

	public void setUI_M_CLAIM_NO(String UI_M_CLAIM_NO) {
		this.UI_M_CLAIM_NO = UI_M_CLAIM_NO;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public Long getPOL_SYS_ID() {
		return POL_SYS_ID;
	}

	public void setPOL_SYS_ID(Long pol_sys_id) {
		POL_SYS_ID = pol_sys_id;
	}

	public Long getCLAIM_SYS_ID() {
		return CLAIM_SYS_ID;
	}

	public void setCLAIM_SYS_ID(Long claim_sys_id) {
		CLAIM_SYS_ID = claim_sys_id;
	}
}
