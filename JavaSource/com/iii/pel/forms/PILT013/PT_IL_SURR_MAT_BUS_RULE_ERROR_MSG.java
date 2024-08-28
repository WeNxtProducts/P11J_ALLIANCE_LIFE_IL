package com.iii.pel.forms.PILT013;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
@Table(name="PT_BUS_RULE_ERROR_MSG")
public class PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG extends BaseValueBean {
	
	@Column(name="BREM_POL_SYS_ID")
	private Long BREM_POL_SYS_ID;
	
	@Column(name="BREM_BRH_SYS_ID")
	private Long BREM_BRH_SYS_ID;

	@Column(name="BREM_MSG")
	private String BREM_MSG;

	@Column(name="BREM_ERR_FLAG")
	private String BREM_ERR_FLAG;

	@Column(name="BREM_CR_UID")
	private String BREM_CR_UID;

	@Column(name="BREM_CR_DT")
	private Date BREM_CR_DT;

	@Column(name="BREM_OVERRIDE_YN")
	private String BREM_OVERRIDE_YN;

	@Column(name="BREM_GRP_ID")
	private String BREM_GRP_ID;

	@Column(name="BREM_APPLY_LEVEL")
	private String BREM_APPLY_LEVEL;

	public Long getBREM_POL_SYS_ID() {
		return BREM_POL_SYS_ID;
	}

	public void setBREM_POL_SYS_ID(Long bREM_POL_SYS_ID) {
		BREM_POL_SYS_ID = bREM_POL_SYS_ID;
	}

	public Long getBREM_BRH_SYS_ID() {
		return BREM_BRH_SYS_ID;
	}

	public void setBREM_BRH_SYS_ID(Long bREM_BRH_SYS_ID) {
		BREM_BRH_SYS_ID = bREM_BRH_SYS_ID;
	}

	public String getBREM_MSG() {
		return BREM_MSG;
	}

	public void setBREM_MSG(String bREM_MSG) {
		BREM_MSG = bREM_MSG;
	}

	public String getBREM_ERR_FLAG() {
		return BREM_ERR_FLAG;
	}

	public void setBREM_ERR_FLAG(String bREM_ERR_FLAG) {
		BREM_ERR_FLAG = bREM_ERR_FLAG;
	}

	public String getBREM_CR_UID() {
		return BREM_CR_UID;
	}

	public void setBREM_CR_UID(String bREM_CR_UID) {
		BREM_CR_UID = bREM_CR_UID;
	}

	public Date getBREM_CR_DT() {
		return BREM_CR_DT;
	}

	public void setBREM_CR_DT(Date bREM_CR_DT) {
		BREM_CR_DT = bREM_CR_DT;
	}

	public String getBREM_OVERRIDE_YN() {
		return BREM_OVERRIDE_YN;
	}

	public void setBREM_OVERRIDE_YN(String bREM_OVERRIDE_YN) {
		BREM_OVERRIDE_YN = bREM_OVERRIDE_YN;
	}

	public String getBREM_GRP_ID() {
		return BREM_GRP_ID;
	}

	public void setBREM_GRP_ID(String bREM_GRP_ID) {
		BREM_GRP_ID = bREM_GRP_ID;
	}

	public String getBREM_APPLY_LEVEL() {
		return BREM_APPLY_LEVEL;
	}

	public void setBREM_APPLY_LEVEL(String bREM_APPLY_LEVEL) {
		BREM_APPLY_LEVEL = bREM_APPLY_LEVEL;
	}

  }

/*End*/
 