package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="PT_IL_POL_PRE_ILLNESS_DTLS")
public class PT_IL_POL_PRE_ILLNESS_DTLS extends BaseValueBean {
	
	@Column(name="PPID_SYS_ID")
	private Long PPID_SYS_ID;	
	@Column(name="PPID_POL_SYS_ID")
	private Long PPID_POL_SYS_ID;		
	@Column(name="PPID_PFMD_SYS_ID")
	private Long PPID_PFMD_SYS_ID;		
	@Column(name="PPID_PRE_ILNS_CODE")
	private String PPID_PRE_ILNS_CODE;		
	@Column(name="PPID_PRE_ILNS_DT")
	private Date PPID_PRE_ILNS_DT;	
	@Column(name="PPID_CR_DT")
	private Date PPID_CR_DT	;			
	@Column(name="PPID_CR_UID")
	private String PPID_CR_UID;		
	@Column(name="PPID_UPD_DT")
	private Date PPID_UPD_DT;
	@Column(name="PPID_UPD_UID")
	private String PPID_UPD_UID;
	private String UI_PPID_PRE_ILNS_DES;	
	private String UI_PPID_MEMBER;
	
	
	public Long getPPID_SYS_ID() {
		return PPID_SYS_ID;
	}
	public void setPPID_SYS_ID(Long pPID_SYS_ID) {
		PPID_SYS_ID = pPID_SYS_ID;
	}
	public Long getPPID_POL_SYS_ID() {
		return PPID_POL_SYS_ID;
	}
	public void setPPID_POL_SYS_ID(Long pPID_POL_SYS_ID) {
		PPID_POL_SYS_ID = pPID_POL_SYS_ID;
	}
	public Long getPPID_PFMD_SYS_ID() {
		return PPID_PFMD_SYS_ID;
	}
	public void setPPID_PFMD_SYS_ID(Long pPID_PFMD_SYS_ID) {
		PPID_PFMD_SYS_ID = pPID_PFMD_SYS_ID;
	}
	public String getPPID_PRE_ILNS_CODE() {
		return PPID_PRE_ILNS_CODE;
	}
	public void setPPID_PRE_ILNS_CODE(String pPID_PRE_ILNS_CODE) {
		PPID_PRE_ILNS_CODE = pPID_PRE_ILNS_CODE;
	}
	public Date getPPID_PRE_ILNS_DT() {
		return PPID_PRE_ILNS_DT;
	}
	public void setPPID_PRE_ILNS_DT(Date pPID_PRE_ILNS_DT) {
		PPID_PRE_ILNS_DT = pPID_PRE_ILNS_DT;
	}
	public Date getPPID_CR_DT() {
		return PPID_CR_DT;
	}
	public void setPPID_CR_DT(Date pPID_CR_DT) {
		PPID_CR_DT = pPID_CR_DT;
	}
	public String getPPID_CR_UID() {
		return PPID_CR_UID;
	}
	public void setPPID_CR_UID(String pPID_CR_UID) {
		PPID_CR_UID = pPID_CR_UID;
	}
	
	public Date getPPID_UPD_DT() {
		return PPID_UPD_DT;
	}
	public void setPPID_UPD_DT(Date pPID_UPD_DT) {
		PPID_UPD_DT = pPID_UPD_DT;
	}
	public String getPPID_UPD_UID() {
		return PPID_UPD_UID;
	}
	public void setPPID_UPD_UID(String pPID_UPD_UID) {
		PPID_UPD_UID = pPID_UPD_UID;
	}
	public String getUI_PPID_PRE_ILNS_DES() {
		return UI_PPID_PRE_ILNS_DES;
	}
	public void setUI_PPID_PRE_ILNS_DES(String uI_PPID_PRE_ILNS_DES) {
		UI_PPID_PRE_ILNS_DES = uI_PPID_PRE_ILNS_DES;
	}
	public String getUI_PPID_MEMBER() {
		return UI_PPID_MEMBER;
	}
	public void setUI_PPID_MEMBER(String uI_PPID_MEMBER) {
		UI_PPID_MEMBER = uI_PPID_MEMBER;
	}	

	
	
	

}
