package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_SUB_BENEFIT")
public class PT_IL_POL_SUB_BENEFIT extends BaseValueBean {

	@Column(name="PSB_SYS_ID")
	private Long PSB_SYS_ID;

	@Column(name="PSB_POL_SYS_ID")
	private Long PSB_POL_SYS_ID;

	@Column(name="PSB_POAD_SYS_ID")
	private Long PSB_POAD_SYS_ID;

	@Column(name="PSB_PAPP_SYS_ID")
	private Long PSB_PAPP_SYS_ID;

	@Column(name="PSB_PCG_SYS_ID")
	private Long PSB_PCG_SYS_ID;

	@Column(name="PSB_POAC_SYS_ID")
	private Long PSB_POAC_SYS_ID;

	@Column(name="PSB_PB_SYS_ID")
	private Long PSB_PB_SYS_ID;

	@Column(name="PSB_CODE")
	private String PSB_CODE;

	@Column(name="PSB_BNF_CODE")
	private String PSB_BNF_CODE;

	@Column(name="PSB_LIMIT_TYPE")
	private String PSB_LIMIT_TYPE;

	@Column(name="PSB_PER_DAY_LC_AMT")
	private Double PSB_PER_DAY_LC_AMT;

	@Column(name="PSB_LIMIT_DAYS")
	private Double PSB_LIMIT_DAYS;

	@Column(name="PSB_LC_LIMIT")
	private Double PSB_LC_LIMIT;

	@Column(name="PSB_ORG_LC_LIMIT")
	private Double PSB_ORG_LC_LIMIT;

	@Column(name="PSB_DEL_FLAG")
	private String PSB_DEL_FLAG;

	@Column(name="PSB_CR_UID")
	private String PSB_CR_UID;

	@Column(name="PSB_CR_DT")
	private Date PSB_CR_DT;

	@Column(name="PSB_UPD_UID")
	private String PSB_UPD_UID;

	@Column(name="PSB_UPD_DT")
	private Date PSB_UPD_DT;

	private String UI_M_PSB_CODE_DESC;
	public void setPSB_LIMIT_TYPE(String PSB_LIMIT_TYPE) {
		this.PSB_LIMIT_TYPE = PSB_LIMIT_TYPE;
	}
	public String getPSB_LIMIT_TYPE() {
		 return PSB_LIMIT_TYPE;
	}
	public void setPSB_BNF_CODE(String PSB_BNF_CODE) {
		this.PSB_BNF_CODE = PSB_BNF_CODE;
	}
	public String getPSB_BNF_CODE() {
		 return PSB_BNF_CODE;
	}
	public void setPSB_LC_LIMIT(Double PSB_LC_LIMIT) {
		this.PSB_LC_LIMIT = PSB_LC_LIMIT;
	}
	public Double getPSB_LC_LIMIT() {
		 return PSB_LC_LIMIT;
	}
	public void setPSB_POL_SYS_ID(Long PSB_POL_SYS_ID) {
		this.PSB_POL_SYS_ID = PSB_POL_SYS_ID;
	}
	public Long getPSB_POL_SYS_ID() {
		 return PSB_POL_SYS_ID;
	}
	public void setPSB_UPD_DT(Date PSB_UPD_DT) {
		this.PSB_UPD_DT = PSB_UPD_DT;
	}
	public Date getPSB_UPD_DT() {
		 return PSB_UPD_DT;
	}
	public void setPSB_POAC_SYS_ID(Long PSB_POAC_SYS_ID) {
		this.PSB_POAC_SYS_ID = PSB_POAC_SYS_ID;
	}
	public Long getPSB_POAC_SYS_ID() {
		 return PSB_POAC_SYS_ID;
	}
	public void setUI_M_PSB_CODE_DESC(String UI_M_PSB_CODE_DESC) {
		this.UI_M_PSB_CODE_DESC = UI_M_PSB_CODE_DESC;
	}
	public String getUI_M_PSB_CODE_DESC() {
		 return UI_M_PSB_CODE_DESC;
	}
	public void setPSB_CR_DT(Date PSB_CR_DT) {
		this.PSB_CR_DT = PSB_CR_DT;
	}
	public Date getPSB_CR_DT() {
		 return PSB_CR_DT;
	}
	public void setPSB_DEL_FLAG(String PSB_DEL_FLAG) {
		this.PSB_DEL_FLAG = PSB_DEL_FLAG;
	}
	public String getPSB_DEL_FLAG() {
		 return PSB_DEL_FLAG;
	}
	public void setPSB_PCG_SYS_ID(Long PSB_PCG_SYS_ID) {
		this.PSB_PCG_SYS_ID = PSB_PCG_SYS_ID;
	}
	public Long getPSB_PCG_SYS_ID() {
		 return PSB_PCG_SYS_ID;
	}
	public void setPSB_PER_DAY_LC_AMT(Double PSB_PER_DAY_LC_AMT) {
		this.PSB_PER_DAY_LC_AMT = PSB_PER_DAY_LC_AMT;
	}
	public Double getPSB_PER_DAY_LC_AMT() {
		 return PSB_PER_DAY_LC_AMT;
	}
	public void setPSB_PAPP_SYS_ID(Long PSB_PAPP_SYS_ID) {
		this.PSB_PAPP_SYS_ID = PSB_PAPP_SYS_ID;
	}
	public Long getPSB_PAPP_SYS_ID() {
		 return PSB_PAPP_SYS_ID;
	}
	public void setPSB_POAD_SYS_ID(Long PSB_POAD_SYS_ID) {
		this.PSB_POAD_SYS_ID = PSB_POAD_SYS_ID;
	}
	public Long getPSB_POAD_SYS_ID() {
		 return PSB_POAD_SYS_ID;
	}
	public void setPSB_ORG_LC_LIMIT(Double PSB_ORG_LC_LIMIT) {
		this.PSB_ORG_LC_LIMIT = PSB_ORG_LC_LIMIT;
	}
	public Double getPSB_ORG_LC_LIMIT() {
		 return PSB_ORG_LC_LIMIT;
	}
	public void setPSB_CODE(String PSB_CODE) {
		this.PSB_CODE = PSB_CODE;
	}
	public String getPSB_CODE() {
		 return PSB_CODE;
	}
	public void setPSB_PB_SYS_ID(Long PSB_PB_SYS_ID) {
		this.PSB_PB_SYS_ID = PSB_PB_SYS_ID;
	}
	public Long getPSB_PB_SYS_ID() {
		 return PSB_PB_SYS_ID;
	}
	public void setPSB_LIMIT_DAYS(Double PSB_LIMIT_DAYS) {
		this.PSB_LIMIT_DAYS = PSB_LIMIT_DAYS;
	}
	public Double getPSB_LIMIT_DAYS() {
		 return PSB_LIMIT_DAYS;
	}
	public void setPSB_UPD_UID(String PSB_UPD_UID) {
		this.PSB_UPD_UID = PSB_UPD_UID;
	}
	public String getPSB_UPD_UID() {
		 return PSB_UPD_UID;
	}
	public void setPSB_CR_UID(String PSB_CR_UID) {
		this.PSB_CR_UID = PSB_CR_UID;
	}
	public String getPSB_CR_UID() {
		 return PSB_CR_UID;
	}
	public void setPSB_SYS_ID(Long PSB_SYS_ID) {
		this.PSB_SYS_ID = PSB_SYS_ID;
	}
	public Long getPSB_SYS_ID() {
		 return PSB_SYS_ID;
	}

}
