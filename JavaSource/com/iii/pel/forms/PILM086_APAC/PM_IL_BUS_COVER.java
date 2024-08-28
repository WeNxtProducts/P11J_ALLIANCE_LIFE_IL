package com.iii.pel.forms.PILM086_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_BUS_RULE_COVER_SETUP")
public class PM_IL_BUS_COVER extends BaseValueBean {
	
	@Column(name="BRCS_COVER_CODE")
	private String BRCS_COVER_CODE;
	
	@Column(name="BRCS_CR_DT")
	private Date BRCS_CR_DT;
	
	@Column(name="BRCS_CR_UID")
	private String BRCS_CR_UID;
	
	@Column(name="BRCS_UPD_DT")
	private Date BRCS_UPD_DT;
	
	@Column(name="BRCS_UPD_UID")
	private String BRCS_UPD_UID;
	
	private String BRCS_COVER_CODE_DESC;

	
	
	
	
	public Date getBRCS_CR_DT() {
		return BRCS_CR_DT;
	}

	public void setBRCS_CR_DT(Date bRCS_CR_DT) {
		BRCS_CR_DT = bRCS_CR_DT;
	}

	public String getBRCS_CR_UID() {
		return BRCS_CR_UID;
	}

	public void setBRCS_CR_UID(String bRCS_CR_UID) {
		BRCS_CR_UID = bRCS_CR_UID;
	}

	public Date getBRCS_UPD_DT() {
		return BRCS_UPD_DT;
	}

	public void setBRCS_UPD_DT(Date bRCS_UPD_DT) {
		BRCS_UPD_DT = bRCS_UPD_DT;
	}

	

	public String getBRCS_UPD_UID() {
		return BRCS_UPD_UID;
	}

	public void setBRCS_UPD_UID(String bRCS_UPD_UID) {
		BRCS_UPD_UID = bRCS_UPD_UID;
	}

	public String getBRCS_COVER_CODE() {
		return BRCS_COVER_CODE;
	}

	public void setBRCS_COVER_CODE(String bRCS_COVER_CODE) {
		BRCS_COVER_CODE = bRCS_COVER_CODE;
	}

	public String getBRCS_COVER_CODE_DESC() {
		return BRCS_COVER_CODE_DESC;
	}

	public void setBRCS_COVER_CODE_DESC(String bRCS_COVER_CODE_DESC) {
		BRCS_COVER_CODE_DESC = bRCS_COVER_CODE_DESC;
	}
	
	@Column(name="BRCS_SYS_ID")
	private Long  BRCS_SYS_ID;

	@Column(name="BRCS_BRH_SYS_ID")
	private Long  BRCS_BRH_SYS_ID;

	
	
	public Long getBRCS_BRH_SYS_ID() {
		return BRCS_BRH_SYS_ID;
	}

	public void setBRCS_BRH_SYS_ID(Long bRCS_BRH_SYS_ID) {
		BRCS_BRH_SYS_ID = bRCS_BRH_SYS_ID;
	}

	public Long getBRCS_SYS_ID() {
		return BRCS_SYS_ID;
	}

	public void setBRCS_SYS_ID(Long bRCS_SYS_ID) {
		BRCS_SYS_ID = bRCS_SYS_ID;
	}



	

}
