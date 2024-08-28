package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;



@Table(name="PT_IL_POL_ASSR_FAMILY_DTLS")
public class PT_IL_POL_ASSR_FAMILY_DTLS extends BaseValueBean {

	@Column(name="PAFD_SYS_ID")
	private Long PAFD_SYS_ID;

	@Column(name="PAFD_POL_SYS_ID")
	private Long PAFD_POL_SYS_ID;

	@Column(name="PAFD_POAD_SYS_ID")
	private Long PAFD_POAD_SYS_ID;

	@Column(name="PAFD_REL_TYPE")
	private String PAFD_REL_TYPE;

	@Column(name="PAFD_AGE")
	private Integer PAFD_AGE;

	@Column(name="PAFD_STATUS")
	private String PAFD_STATUS;

	@Column(name="PAFD_CR_DT")
	private Date PAFD_CR_DT;

	@Column(name="PAFD_REASON")
	private String PAFD_REASON;

	@Column(name="PAFD_HEALTH_YN")
	private String PAFD_HEALTH_YN;

	@Column(name="PAFD_ADVERSITY")
	private String PAFD_ADVERSITY;

	@Column(name="PAFD_CR_UID")
	private String PAFD_CR_UID;

	@Column(name="PAFD_UPD_UID")
	private String PAFD_UPD_UID;

	@Column(name="PAFD_UPD_DT")
	private Date PAFD_UPD_DT;

	public Long getPAFD_SYS_ID() {
		return PAFD_SYS_ID;
	}

	public void setPAFD_SYS_ID(Long pAFD_SYS_ID) {
		PAFD_SYS_ID = pAFD_SYS_ID;
	}

	public Long getPAFD_POL_SYS_ID() {
		return PAFD_POL_SYS_ID;
	}

	public void setPAFD_POL_SYS_ID(Long pAFD_POL_SYS_ID) {
		PAFD_POL_SYS_ID = pAFD_POL_SYS_ID;
	}


	public String getPAFD_REL_TYPE() {
		return PAFD_REL_TYPE;
	}

	public void setPAFD_REL_TYPE(String pAFD_REL_TYPE) {
		PAFD_REL_TYPE = pAFD_REL_TYPE;
	}

	public Integer getPAFD_AGE() {
		return PAFD_AGE;
	}

	public void setPAFD_AGE(Integer pAFD_AGE) {
		PAFD_AGE = pAFD_AGE;
	}

	public String getPAFD_STATUS() {
		return PAFD_STATUS;
	}

	public void setPAFD_STATUS(String pAFD_STATUS) {
		PAFD_STATUS = pAFD_STATUS;
	}

	public Date getPAFD_CR_DT() {
		return PAFD_CR_DT;
	}

	public void setPAFD_CR_DT(Date pAFD_CR_DT) {
		PAFD_CR_DT = pAFD_CR_DT;
	}

	public String getPAFD_REASON() {
		return PAFD_REASON;
	}

	public void setPAFD_REASON(String pAFD_REASON) {
		PAFD_REASON = pAFD_REASON;
	}

	public String getPAFD_HEALTH_YN() {
		return PAFD_HEALTH_YN;
	}

	public void setPAFD_HEALTH_YN(String pAFD_HEALTH_YN) {
		PAFD_HEALTH_YN = pAFD_HEALTH_YN;
	}

	public String getPAFD_ADVERSITY() {
		return PAFD_ADVERSITY;
	}

	public void setPAFD_ADVERSITY(String pAFD_ADVERSITY) {
		PAFD_ADVERSITY = pAFD_ADVERSITY;
	}

	public String getPAFD_CR_UID() {
		return PAFD_CR_UID;
	}

	public void setPAFD_CR_UID(String pAFD_CR_UID) {
		PAFD_CR_UID = pAFD_CR_UID;
	}

	public String getPAFD_UPD_UID() {
		return PAFD_UPD_UID;
	}

	public void setPAFD_UPD_UID(String pAFD_UPD_UID) {
		PAFD_UPD_UID = pAFD_UPD_UID;
	}

	public Date getPAFD_UPD_DT() {
		return PAFD_UPD_DT;
	}

	public void setPAFD_UPD_DT(Date pAFD_UPD_DT) {
		PAFD_UPD_DT = pAFD_UPD_DT;
	}

	public Long getPAFD_POAD_SYS_ID() {
		return PAFD_POAD_SYS_ID;
	}

	public void setPAFD_POAD_SYS_ID(Long pAFD_POAD_SYS_ID) {
		PAFD_POAD_SYS_ID = pAFD_POAD_SYS_ID;
	}
	
	

}