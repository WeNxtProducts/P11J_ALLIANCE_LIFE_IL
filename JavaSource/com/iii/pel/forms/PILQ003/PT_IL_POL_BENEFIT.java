package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_BENEFIT")
public class PT_IL_POL_BENEFIT extends BaseValueBean {

	@Column(name="PB_SYS_ID")
	private Long PB_SYS_ID;

	@Column(name="PB_POL_SYS_ID")
	private Long PB_POL_SYS_ID;

	@Column(name="PB_POAD_SYS_ID")
	private Long PB_POAD_SYS_ID;

	@Column(name="PB_PAPP_SYS_ID")
	private Long PB_PAPP_SYS_ID;

	@Column(name="PB_PCG_SYS_ID")
	private Long PB_PCG_SYS_ID;

	@Column(name="PB_POAC_SYS_ID")
	private Long PB_POAC_SYS_ID;

	@Column(name="PB_BNF_CODE")
	private String PB_BNF_CODE;

	@Column(name="PB_LIMIT_TYPE")
	private String PB_LIMIT_TYPE;

	@Column(name="PB_PER_DAY_LC_AMT")
	private Double PB_PER_DAY_LC_AMT;

	@Column(name="PB_LIMIT_DAYS")
	private Double PB_LIMIT_DAYS;

	@Column(name="PB_LC_LIMIT")
	private Double PB_LC_LIMIT;

	@Column(name="PB_ORG_LC_LIMIT")
	private Double PB_ORG_LC_LIMIT;

	@Column(name="PB_DEL_FLAG")
	private String PB_DEL_FLAG;

	@Column(name="PB_CR_UID")
	private String PB_CR_UID;

	@Column(name="PB_CR_DT")
	private Date PB_CR_DT;

	@Column(name="PB_UPD_UID")
	private String PB_UPD_UID;

	@Column(name="PB_UPD_DT")
	private Date PB_UPD_DT;

	private String UI_M_PB_BNF_CODE_DESC;
	public void setUI_M_PB_BNF_CODE_DESC(String UI_M_PB_BNF_CODE_DESC) {
		this.UI_M_PB_BNF_CODE_DESC = UI_M_PB_BNF_CODE_DESC;
	}
	public String getUI_M_PB_BNF_CODE_DESC() {
		 return UI_M_PB_BNF_CODE_DESC;
	}
	public void setPB_UPD_UID(String PB_UPD_UID) {
		this.PB_UPD_UID = PB_UPD_UID;
	}
	public String getPB_UPD_UID() {
		 return PB_UPD_UID;
	}
	public void setPB_POL_SYS_ID(Long PB_POL_SYS_ID) {
		this.PB_POL_SYS_ID = PB_POL_SYS_ID;
	}
	public Long getPB_POL_SYS_ID() {
		 return PB_POL_SYS_ID;
	}
	public void setPB_LIMIT_TYPE(String PB_LIMIT_TYPE) {
		this.PB_LIMIT_TYPE = PB_LIMIT_TYPE;
	}
	public String getPB_LIMIT_TYPE() {
		 return PB_LIMIT_TYPE;
	}
	public void setPB_DEL_FLAG(String PB_DEL_FLAG) {
		this.PB_DEL_FLAG = PB_DEL_FLAG;
	}
	public String getPB_DEL_FLAG() {
		 return PB_DEL_FLAG;
	}
	public void setPB_SYS_ID(Long PB_SYS_ID) {
		this.PB_SYS_ID = PB_SYS_ID;
	}
	public Long getPB_SYS_ID() {
		 return PB_SYS_ID;
	}
	public void setPB_ORG_LC_LIMIT(Double PB_ORG_LC_LIMIT) {
		this.PB_ORG_LC_LIMIT = PB_ORG_LC_LIMIT;
	}
	public Double getPB_ORG_LC_LIMIT() {
		 return PB_ORG_LC_LIMIT;
	}
	public void setPB_LIMIT_DAYS(Double PB_LIMIT_DAYS) {
		this.PB_LIMIT_DAYS = PB_LIMIT_DAYS;
	}
	public Double getPB_LIMIT_DAYS() {
		 return PB_LIMIT_DAYS;
	}
	public void setPB_LC_LIMIT(Double PB_LC_LIMIT) {
		this.PB_LC_LIMIT = PB_LC_LIMIT;
	}
	public Double getPB_LC_LIMIT() {
		 return PB_LC_LIMIT;
	}
	public void setPB_PAPP_SYS_ID(Long PB_PAPP_SYS_ID) {
		this.PB_PAPP_SYS_ID = PB_PAPP_SYS_ID;
	}
	public Long getPB_PAPP_SYS_ID() {
		 return PB_PAPP_SYS_ID;
	}
	public void setPB_PCG_SYS_ID(Long PB_PCG_SYS_ID) {
		this.PB_PCG_SYS_ID = PB_PCG_SYS_ID;
	}
	public Long getPB_PCG_SYS_ID() {
		 return PB_PCG_SYS_ID;
	}
	public void setPB_BNF_CODE(String PB_BNF_CODE) {
		this.PB_BNF_CODE = PB_BNF_CODE;
	}
	public String getPB_BNF_CODE() {
		 return PB_BNF_CODE;
	}
	public void setPB_UPD_DT(Date PB_UPD_DT) {
		this.PB_UPD_DT = PB_UPD_DT;
	}
	public Date getPB_UPD_DT() {
		 return PB_UPD_DT;
	}
	public void setPB_CR_UID(String PB_CR_UID) {
		this.PB_CR_UID = PB_CR_UID;
	}
	public String getPB_CR_UID() {
		 return PB_CR_UID;
	}
	public void setPB_POAD_SYS_ID(Long PB_POAD_SYS_ID) {
		this.PB_POAD_SYS_ID = PB_POAD_SYS_ID;
	}
	public Long getPB_POAD_SYS_ID() {
		 return PB_POAD_SYS_ID;
	}
	public void setPB_POAC_SYS_ID(Long PB_POAC_SYS_ID) {
		this.PB_POAC_SYS_ID = PB_POAC_SYS_ID;
	}
	public Long getPB_POAC_SYS_ID() {
		 return PB_POAC_SYS_ID;
	}
	public void setPB_CR_DT(Date PB_CR_DT) {
		this.PB_CR_DT = PB_CR_DT;
	}
	public Date getPB_CR_DT() {
		 return PB_CR_DT;
	}
	public void setPB_PER_DAY_LC_AMT(Double PB_PER_DAY_LC_AMT) {
		this.PB_PER_DAY_LC_AMT = PB_PER_DAY_LC_AMT;
	}
	public Double getPB_PER_DAY_LC_AMT() {
		 return PB_PER_DAY_LC_AMT;
	}

}
