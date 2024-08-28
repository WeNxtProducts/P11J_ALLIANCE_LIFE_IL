package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_DEDUCTIBLE")
public class PT_IL_POL_DEDUCTIBLE extends BaseValueBean {

	@Column(name="PD_SYS_ID")
	private Long PD_SYS_ID;

	@Column(name="PD_POL_SYS_ID")
	private Long PD_POL_SYS_ID;

	@Column(name="PD_POAD_SYS_ID")
	private Long PD_POAD_SYS_ID;

	@Column(name="PD_PAPP_SYS_ID")
	private Long PD_PAPP_SYS_ID;

	@Column(name="PD_PCG_SYS_ID")
	private Long PD_PCG_SYS_ID;

	@Column(name="PD_POAC_SYS_ID")
	private Long PD_POAC_SYS_ID;

	@Column(name="PD_PB_SYS_ID")
	private Long PD_PB_SYS_ID;

	@Column(name="PD_CODE")
	private String PD_CODE;

	@Column(name="PD_BNF_CODE")
	private String PD_BNF_CODE;

	@Column(name="PD_NO_OF_DAYS")
	private Double PD_NO_OF_DAYS;

	@Column(name="PD_PERC")
	private Double PD_PERC;

	@Column(name="PD_MIN_LC_VAL")
	private Double PD_MIN_LC_VAL;

	@Column(name="PD_DEL_FLAG")
	private String PD_DEL_FLAG;

	@Column(name="PD_CR_UID")
	private String PD_CR_UID;

	@Column(name="PD_CR_DT")
	private Date PD_CR_DT;

	@Column(name="PD_UPD_UID")
	private String PD_UPD_UID;

	@Column(name="PD_UPD_DT")
	private Date PD_UPD_DT;

	private String UI_M_PD_CODE_DESC;
	public void setPD_PB_SYS_ID(Long PD_PB_SYS_ID) {
		this.PD_PB_SYS_ID = PD_PB_SYS_ID;
	}
	public Long getPD_PB_SYS_ID() {
		 return PD_PB_SYS_ID;
	}
	public void setPD_POAD_SYS_ID(Long PD_POAD_SYS_ID) {
		this.PD_POAD_SYS_ID = PD_POAD_SYS_ID;
	}
	public Long getPD_POAD_SYS_ID() {
		 return PD_POAD_SYS_ID;
	}
	public void setPD_UPD_UID(String PD_UPD_UID) {
		this.PD_UPD_UID = PD_UPD_UID;
	}
	public String getPD_UPD_UID() {
		 return PD_UPD_UID;
	}
	public void setPD_UPD_DT(Date PD_UPD_DT) {
		this.PD_UPD_DT = PD_UPD_DT;
	}
	public Date getPD_UPD_DT() {
		 return PD_UPD_DT;
	}
	public void setPD_SYS_ID(Long PD_SYS_ID) {
		this.PD_SYS_ID = PD_SYS_ID;
	}
	public Long getPD_SYS_ID() {
		 return PD_SYS_ID;
	}
	public void setPD_CR_DT(Date PD_CR_DT) {
		this.PD_CR_DT = PD_CR_DT;
	}
	public Date getPD_CR_DT() {
		 return PD_CR_DT;
	}
	public void setPD_POAC_SYS_ID(Long PD_POAC_SYS_ID) {
		this.PD_POAC_SYS_ID = PD_POAC_SYS_ID;
	}
	public Long getPD_POAC_SYS_ID() {
		 return PD_POAC_SYS_ID;
	}
	public void setPD_NO_OF_DAYS(Double PD_NO_OF_DAYS) {
		this.PD_NO_OF_DAYS = PD_NO_OF_DAYS;
	}
	public Double getPD_NO_OF_DAYS() {
		 return PD_NO_OF_DAYS;
	}
	public void setPD_PERC(Double PD_PERC) {
		this.PD_PERC = PD_PERC;
	}
	public Double getPD_PERC() {
		 return PD_PERC;
	}
	public void setPD_CR_UID(String PD_CR_UID) {
		this.PD_CR_UID = PD_CR_UID;
	}
	public String getPD_CR_UID() {
		 return PD_CR_UID;
	}
	public void setPD_DEL_FLAG(String PD_DEL_FLAG) {
		this.PD_DEL_FLAG = PD_DEL_FLAG;
	}
	public String getPD_DEL_FLAG() {
		 return PD_DEL_FLAG;
	}
	public void setPD_MIN_LC_VAL(Double PD_MIN_LC_VAL) {
		this.PD_MIN_LC_VAL = PD_MIN_LC_VAL;
	}
	public Double getPD_MIN_LC_VAL() {
		 return PD_MIN_LC_VAL;
	}
	public void setPD_POL_SYS_ID(Long PD_POL_SYS_ID) {
		this.PD_POL_SYS_ID = PD_POL_SYS_ID;
	}
	public Long getPD_POL_SYS_ID() {
		 return PD_POL_SYS_ID;
	}
	public void setPD_PAPP_SYS_ID(Long PD_PAPP_SYS_ID) {
		this.PD_PAPP_SYS_ID = PD_PAPP_SYS_ID;
	}
	public Long getPD_PAPP_SYS_ID() {
		 return PD_PAPP_SYS_ID;
	}
	public void setPD_CODE(String PD_CODE) {
		this.PD_CODE = PD_CODE;
	}
	public String getPD_CODE() {
		 return PD_CODE;
	}
	public void setPD_BNF_CODE(String PD_BNF_CODE) {
		this.PD_BNF_CODE = PD_BNF_CODE;
	}
	public String getPD_BNF_CODE() {
		 return PD_BNF_CODE;
	}
	public void setPD_PCG_SYS_ID(Long PD_PCG_SYS_ID) {
		this.PD_PCG_SYS_ID = PD_PCG_SYS_ID;
	}
	public Long getPD_PCG_SYS_ID() {
		 return PD_PCG_SYS_ID;
	}
	public void setUI_M_PD_CODE_DESC(String UI_M_PD_CODE_DESC) {
		this.UI_M_PD_CODE_DESC = UI_M_PD_CODE_DESC;
	}
	public String getUI_M_PD_CODE_DESC() {
		 return UI_M_PD_CODE_DESC;
	}

}
