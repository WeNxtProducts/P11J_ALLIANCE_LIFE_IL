package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_ASSR_ILLNESS_DTLS")
public class PT_IL_POL_ASSR_ILLNESS_DTLS extends BaseValueBean {

	@Column(name="PAID_SYS_ID")
	private Long PAID_SYS_ID;

	@Column(name="PAID_POL_SYS_ID")
	private Long PAID_POL_SYS_ID;

	@Column(name="PAID_POAD_SYS_ID")
	private Long PAID_POAD_SYS_ID;

	@Column(name="PAID_CR_DT")
	private Date PAID_CR_DT;

	@Column(name="PAID_CR_UID")
	private String PAID_CR_UID;

	@Column(name="PAID_UPD_DT")
	private Date PAID_UPD_DT;

	@Column(name="PAID_UPD_UID")
	private String PAID_UPD_UID;

	@Column(name="PAID_ILLNESS_CODE")
	private String PAID_ILLNESS_CODE;

	private String UI_M_PAID_ILL_CODE_DESC;
	
	public void setPAID_SYS_ID(Long PAID_SYS_ID) {
		this.PAID_SYS_ID = PAID_SYS_ID;
	}
	public Long getPAID_SYS_ID() {
		 return PAID_SYS_ID;
	}
	public void setPAID_POAD_SYS_ID(Long PAID_POAD_SYS_ID) {
		this.PAID_POAD_SYS_ID = PAID_POAD_SYS_ID;
	}
	public Long getPAID_POAD_SYS_ID() {
		 return PAID_POAD_SYS_ID;
	}
	public void setUI_M_PAID_ILL_CODE_DESC(String UI_M_PAID_ILL_CODE_DESC) {
		this.UI_M_PAID_ILL_CODE_DESC = UI_M_PAID_ILL_CODE_DESC;
	}
	public String getUI_M_PAID_ILL_CODE_DESC() {
		 return UI_M_PAID_ILL_CODE_DESC;
	}
	public void setPAID_CR_UID(String PAID_CR_UID) {
		this.PAID_CR_UID = PAID_CR_UID;
	}
	public String getPAID_CR_UID() {
		 return PAID_CR_UID;
	}
	public void setPAID_UPD_UID(String PAID_UPD_UID) {
		this.PAID_UPD_UID = PAID_UPD_UID;
	}
	public String getPAID_UPD_UID() {
		 return PAID_UPD_UID;
	}
	public void setPAID_CR_DT(Date PAID_CR_DT) {
		this.PAID_CR_DT = PAID_CR_DT;
	}
	public Date getPAID_CR_DT() {
		 return PAID_CR_DT;
	}
	public void setPAID_POL_SYS_ID(Long PAID_POL_SYS_ID) {
		this.PAID_POL_SYS_ID = PAID_POL_SYS_ID;
	}
	public Long getPAID_POL_SYS_ID() {
		 return PAID_POL_SYS_ID;
	}
	public void setPAID_ILLNESS_CODE(String PAID_ILLNESS_CODE) {
		this.PAID_ILLNESS_CODE = PAID_ILLNESS_CODE;
	}
	public String getPAID_ILLNESS_CODE() {
		 return PAID_ILLNESS_CODE;
	}
	public void setPAID_UPD_DT(Date PAID_UPD_DT) {
		this.PAID_UPD_DT = PAID_UPD_DT;
	}
	public Date getPAID_UPD_DT() {
		 return PAID_UPD_DT;
	}

}
