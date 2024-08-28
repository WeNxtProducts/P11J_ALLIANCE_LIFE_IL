package com.iii.pel.forms.PILM015_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROP_TREATY_PART_CUST")
public class PM_IL_PROP_TREATY_PART_CUST extends BaseValueBean {

	@Column(name="PTPC_CUST_CODE")
	private String PTPC_CUST_CODE;

	private String UI_M_COMP_DESC;

	@Column(name="PTPC_SHARE_PERC")
	private Double PTPC_SHARE_PERC;

	@Column(name="PTPC_LEADER_YN")
	private String PTPC_LEADER_YN;
	
	private boolean CHECK_BOX;
	
	@Column(name="PTPC_SYS_ID")
	private Double PTPC_SYS_ID;
	
	@Column(name="PTPC_PTT_SYS_ID")
	private Double PTPC_PTT_SYS_ID;
	
	@Column(name="PTPC_CR_DT")
	private Date  PTPC_CR_DT ;
	
	@Column(name="PTPC_CR_UID")
	private String PTPC_CR_UID;
	
	@Column(name="PTPC_UPD_DT")
	private Date PTPC_UPD_DT;
	
	@Column(name="PTPC_UPD_UID")
	private String PTPC_UPD_UID;
	
	@Column(name="PTPC_PTC_SYS_ID")
	private Double PTPC_PTC_SYS_ID;
	
	


	public Double getPTPC_PTC_SYS_ID() {
		return PTPC_PTC_SYS_ID;
	}

	public void setPTPC_PTC_SYS_ID(Double pTPC_PTC_SYS_ID) {
		PTPC_PTC_SYS_ID = pTPC_PTC_SYS_ID;
	}

	public String getPTPC_CUST_CODE() {
		return PTPC_CUST_CODE;
	}

	public void setPTPC_CUST_CODE(String PTPC_CUST_CODE) {
		this.PTPC_CUST_CODE = PTPC_CUST_CODE;
	}

	public String getUI_M_COMP_DESC() {
		return UI_M_COMP_DESC;
	}

	public void setUI_M_COMP_DESC(String UI_M_COMP_DESC) {
		this.UI_M_COMP_DESC = UI_M_COMP_DESC;
	}

	public Double getPTPC_SHARE_PERC() {
		return PTPC_SHARE_PERC;
	}

	public void setPTPC_SHARE_PERC(Double PTPC_SHARE_PERC) {
		this.PTPC_SHARE_PERC = PTPC_SHARE_PERC;
	}

	public String getPTPC_LEADER_YN() {
		return PTPC_LEADER_YN;
	}

	public void setPTPC_LEADER_YN(String PTPC_LEADER_YN) {
		this.PTPC_LEADER_YN = PTPC_LEADER_YN;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	

	public Date getPTPC_CR_DT() {
		return PTPC_CR_DT;
	}

	public void setPTPC_CR_DT(Date ptpc_cr_dt) {
		PTPC_CR_DT = ptpc_cr_dt;
	}

	public String getPTPC_CR_UID() {
		return PTPC_CR_UID;
	}

	public void setPTPC_CR_UID(String ptpc_cr_uid) {
		PTPC_CR_UID = ptpc_cr_uid;
	}

	public Date getPTPC_UPD_DT() {
		return PTPC_UPD_DT;
	}

	public void setPTPC_UPD_DT(Date ptpc_upd_dt) {
		PTPC_UPD_DT = ptpc_upd_dt;
	}

	public String getPTPC_UPD_UID() {
		return PTPC_UPD_UID;
	}

	public void setPTPC_UPD_UID(String ptpc_upd_uid) {
		PTPC_UPD_UID = ptpc_upd_uid;
	}

	public Double getPTPC_SYS_ID() {
		return PTPC_SYS_ID;
	}

	public void setPTPC_SYS_ID(Double ptpc_sys_id) {
		PTPC_SYS_ID = ptpc_sys_id;
	}

	public Double getPTPC_PTT_SYS_ID() {
		return PTPC_PTT_SYS_ID;
	}

	public void setPTPC_PTT_SYS_ID(Double ptpc_ptt_sys_id) {
		PTPC_PTT_SYS_ID = ptpc_ptt_sys_id;
	}
}
