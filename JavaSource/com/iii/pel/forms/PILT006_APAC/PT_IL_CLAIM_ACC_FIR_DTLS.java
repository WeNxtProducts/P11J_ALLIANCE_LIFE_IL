package com.iii.pel.forms.PILT006_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_CLAIM_ACC_FIR_DTLS")
public class PT_IL_CLAIM_ACC_FIR_DTLS extends BaseValueBean {

	@Column(name="CAFD_SYS_ID")
	private Double CAFD_SYS_ID;

	@Column(name="CAFD_CLAIM_SYS_ID")
	private Long CAFD_CLAIM_SYS_ID;

	@Column(name="CAFD_ACC_DATE")
	private Date CAFD_ACC_DATE;

	@Column(name="CAFD_ACC_TIME")
	private Date CAFD_ACC_TIME;

	@Column(name="CAFD_FIR_NO")
	private String CAFD_FIR_NO;

	@Column(name="CAFD_REG_DT")
	private Date CAFD_REG_DT;

	@Column(name="CAFD_ACC_PLACE")
	private String CAFD_ACC_PLACE;

	@Column(name="CAFD_STA_CODE")
	private String CAFD_STA_CODE;

	@Column(name="CAFD_ACC_TYPE")
	private String CAFD_ACC_TYPE;

	@Column(name="CAFD_INJ_TYPE")
	private String CAFD_INJ_TYPE;

	@Column(name="CAFD_CR_DT")
	private Date CAFD_CR_DT;

	@Column(name="CAFD_CR_UID")
	private String CAFD_CR_UID;

	@Column(name="CAFD_UPD_DT")
	private Date CAFD_UPD_DT;

	@Column(name="CAFD_UPD_UID")
	private String CAFD_UPD_UID;

	private String UI_M_CAFD_ACC_TYPE_DESC;
	private String UI_M_CAFD_STA_CODE_DESC;
	private String UI_M_CAFD_INJ_TYPE_DESC;

	
	public void setCAFD_STA_CODE(String CAFD_STA_CODE) {
		this.CAFD_STA_CODE = CAFD_STA_CODE;
	}
	public String getCAFD_STA_CODE() {
		 return CAFD_STA_CODE;
	}
	
	/**
	 * @return the cAFD_SYS_ID
	 */
	public Double getCAFD_SYS_ID() {
		return CAFD_SYS_ID;
	}
	/**
	 * @param cafd_sys_id the cAFD_SYS_ID to set
	 */
	public void setCAFD_SYS_ID(Double cafd_sys_id) {
		CAFD_SYS_ID = cafd_sys_id;
	}

	/**
	 * @return the cAFD_CLAIM_SYS_ID
	 */
	public Long getCAFD_CLAIM_SYS_ID() {
		return CAFD_CLAIM_SYS_ID;
	}
	/**
	 * @param cafd_claim_sys_id the cAFD_CLAIM_SYS_ID to set
	 */
	public void setCAFD_CLAIM_SYS_ID(Long cafd_claim_sys_id) {
		CAFD_CLAIM_SYS_ID = cafd_claim_sys_id;
	}
	public void setUI_M_CAFD_ACC_TYPE_DESC(String UI_M_CAFD_ACC_TYPE_DESC) {
		this.UI_M_CAFD_ACC_TYPE_DESC = UI_M_CAFD_ACC_TYPE_DESC;
	}
	public String getUI_M_CAFD_ACC_TYPE_DESC() {
		 return UI_M_CAFD_ACC_TYPE_DESC;
	}
	public void setCAFD_ACC_PLACE(String CAFD_ACC_PLACE) {
		this.CAFD_ACC_PLACE = CAFD_ACC_PLACE;
	}
	public String getCAFD_ACC_PLACE() {
		 return CAFD_ACC_PLACE;
	}
	public void setCAFD_ACC_DATE(Date CAFD_ACC_DATE) {
		this.CAFD_ACC_DATE = CAFD_ACC_DATE;
	}
	public Date getCAFD_ACC_DATE() {
		 return CAFD_ACC_DATE;
	}
	public void setCAFD_ACC_TYPE(String CAFD_ACC_TYPE) {
		this.CAFD_ACC_TYPE = CAFD_ACC_TYPE;
	}
	public String getCAFD_ACC_TYPE() {
		 return CAFD_ACC_TYPE;
	}
	public void setCAFD_CR_UID(String CAFD_CR_UID) {
		this.CAFD_CR_UID = CAFD_CR_UID;
	}
	public String getCAFD_CR_UID() {
		 return CAFD_CR_UID;
	}
	public void setCAFD_ACC_TIME(Date CAFD_ACC_TIME) {
		this.CAFD_ACC_TIME = CAFD_ACC_TIME;
	}
	public Date getCAFD_ACC_TIME() {
		 return CAFD_ACC_TIME;
	}
	public void setCAFD_UPD_UID(String CAFD_UPD_UID) {
		this.CAFD_UPD_UID = CAFD_UPD_UID;
	}
	public String getCAFD_UPD_UID() {
		 return CAFD_UPD_UID;
	}
	public void setUI_M_CAFD_INJ_TYPE_DESC(String UI_M_CAFD_INJ_TYPE_DESC) {
		this.UI_M_CAFD_INJ_TYPE_DESC = UI_M_CAFD_INJ_TYPE_DESC;
	}
	public String getUI_M_CAFD_INJ_TYPE_DESC() {
		 return UI_M_CAFD_INJ_TYPE_DESC;
	}
	public void setCAFD_CR_DT(Date CAFD_CR_DT) {
		this.CAFD_CR_DT = CAFD_CR_DT;
	}
	public Date getCAFD_CR_DT() {
		 return CAFD_CR_DT;
	}
	public void setCAFD_UPD_DT(Date CAFD_UPD_DT) {
		this.CAFD_UPD_DT = CAFD_UPD_DT;
	}
	public Date getCAFD_UPD_DT() {
		 return CAFD_UPD_DT;
	}
	public void setUI_M_CAFD_STA_CODE_DESC(String UI_M_CAFD_STA_CODE_DESC) {
		this.UI_M_CAFD_STA_CODE_DESC = UI_M_CAFD_STA_CODE_DESC;
	}
	public String getUI_M_CAFD_STA_CODE_DESC() {
		 return UI_M_CAFD_STA_CODE_DESC;
	}
	public void setCAFD_REG_DT(Date CAFD_REG_DT) {
		this.CAFD_REG_DT = CAFD_REG_DT;
	}
	public Date getCAFD_REG_DT() {
		 return CAFD_REG_DT;
	}
	public void setCAFD_FIR_NO(String CAFD_FIR_NO) {
		this.CAFD_FIR_NO = CAFD_FIR_NO;
	}
	public String getCAFD_FIR_NO() {
		 return CAFD_FIR_NO;
	}
	public void setCAFD_INJ_TYPE(String CAFD_INJ_TYPE) {
		this.CAFD_INJ_TYPE = CAFD_INJ_TYPE;
	}
	public String getCAFD_INJ_TYPE() {
		 return CAFD_INJ_TYPE;
	}

}
