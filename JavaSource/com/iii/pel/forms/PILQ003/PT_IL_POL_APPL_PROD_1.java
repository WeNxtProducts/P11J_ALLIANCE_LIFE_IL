package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_APPL_PROD")
public class PT_IL_POL_APPL_PROD_1 extends BaseValueBean {

	@Column(name="PAPP_SYS_ID")
	private Long PAPP_SYS_ID;

	@Column(name="PAPP_POL_SYS_ID")
	private Long PAPP_POL_SYS_ID;

	@Column(name="PAPP_POAD_SYS_ID")
	private Long PAPP_POAD_SYS_ID;

	@Column(name="PAPP_PROD_CODE")
	private String PAPP_PROD_CODE;

	@Column(name="PAPP_PLAN_CODE")
	private String PAPP_PLAN_CODE;

	@Column(name="PAPP_PLAN_TYPE")
	private String PAPP_PLAN_TYPE;

	@Column(name="PAPP_MAIN_PROD_YN")
	private String PAPP_MAIN_PROD_YN;

	@Column(name="PAPP_STATUS")
	private String PAPP_STATUS;

	@Column(name="PAPP_FC_SA")
	private Double PAPP_FC_SA;

	@Column(name="PAPP_LC_SA")
	private Double PAPP_LC_SA;

	@Column(name="PAPP_BASIC_RATE")
	private Double PAPP_BASIC_RATE;

	@Column(name="PAPP_BASIC_RATE_PER")
	private Double PAPP_BASIC_RATE_PER;

	@Column(name="PAPP_FC_BASIC_PREM")
	private Double PAPP_FC_BASIC_PREM;

	@Column(name="PAPP_LC_BASIC_PREM")
	private Double PAPP_LC_BASIC_PREM;

	@Column(name="PAPP_FC_ADDL_PREM")
	private Double PAPP_FC_ADDL_PREM;

	@Column(name="PAPP_LC_ADDL_PREM")
	private Double PAPP_LC_ADDL_PREM;

	@Column(name="PAPP_ORG_FC_SA")
	private Double PAPP_ORG_FC_SA;

	@Column(name="PAPP_ORG_LC_SA")
	private Double PAPP_ORG_LC_SA;

	@Column(name="PAPP_ORG_FC_BASIC_PREM")
	private Double PAPP_ORG_FC_BASIC_PREM;

	@Column(name="PAPP_ORG_LC_BASIC_PREM")
	private Double PAPP_ORG_LC_BASIC_PREM;

	@Column(name="PAPP_ORG_FC_ADDL_PREM")
	private Double PAPP_ORG_FC_ADDL_PREM;

	@Column(name="PAPP_ORG_LC_ADDL_PREM")
	private Double PAPP_ORG_LC_ADDL_PREM;

	@Column(name="PAPP_CR_DT")
	private Date PAPP_CR_DT;

	@Column(name="PAPP_CR_UID")
	private String PAPP_CR_UID;

	@Column(name="PAPP_UPD_DT")
	private Date PAPP_UPD_DT;

	@Column(name="PAPP_UPD_UID")
	private String PAPP_UPD_UID;

	@Column(name="PAPP_PROD_STATUS")
	private String PAPP_PROD_STATUS;

	@Column(name="PPAP_DEL_FLAG")
	private String PPAP_DEL_FLAG;

	private String UI_M_PAPP_PROD_DESC;
	private String UI_M_PAPP_PLAN_DESC;
	public void setPAPP_UPD_DT(Date PAPP_UPD_DT) {
		this.PAPP_UPD_DT = PAPP_UPD_DT;
	}
	public Date getPAPP_UPD_DT() {
		 return PAPP_UPD_DT;
	}
	public void setPAPP_FC_SA(Double PAPP_FC_SA) {
		this.PAPP_FC_SA = PAPP_FC_SA;
	}
	public Double getPAPP_FC_SA() {
		 return PAPP_FC_SA;
	}
	public void setPPAP_DEL_FLAG(String PPAP_DEL_FLAG) {
		this.PPAP_DEL_FLAG = PPAP_DEL_FLAG;
	}
	public String getPPAP_DEL_FLAG() {
		 return PPAP_DEL_FLAG;
	}
	public void setPAPP_PLAN_CODE(String PAPP_PLAN_CODE) {
		this.PAPP_PLAN_CODE = PAPP_PLAN_CODE;
	}
	public String getPAPP_PLAN_CODE() {
		 return PAPP_PLAN_CODE;
	}
	public void setPAPP_BASIC_RATE_PER(Double PAPP_BASIC_RATE_PER) {
		this.PAPP_BASIC_RATE_PER = PAPP_BASIC_RATE_PER;
	}
	public Double getPAPP_BASIC_RATE_PER() {
		 return PAPP_BASIC_RATE_PER;
	}
	public void setPAPP_PROD_CODE(String PAPP_PROD_CODE) {
		this.PAPP_PROD_CODE = PAPP_PROD_CODE;
	}
	public String getPAPP_PROD_CODE() {
		 return PAPP_PROD_CODE;
	}
	public void setUI_M_PAPP_PROD_DESC(String UI_M_PAPP_PROD_DESC) {
		this.UI_M_PAPP_PROD_DESC = UI_M_PAPP_PROD_DESC;
	}
	public String getUI_M_PAPP_PROD_DESC() {
		 return UI_M_PAPP_PROD_DESC;
	}
	public void setPAPP_FC_ADDL_PREM(Double PAPP_FC_ADDL_PREM) {
		this.PAPP_FC_ADDL_PREM = PAPP_FC_ADDL_PREM;
	}
	public Double getPAPP_FC_ADDL_PREM() {
		 return PAPP_FC_ADDL_PREM;
	}
	public void setPAPP_ORG_FC_ADDL_PREM(Double PAPP_ORG_FC_ADDL_PREM) {
		this.PAPP_ORG_FC_ADDL_PREM = PAPP_ORG_FC_ADDL_PREM;
	}
	public Double getPAPP_ORG_FC_ADDL_PREM() {
		 return PAPP_ORG_FC_ADDL_PREM;
	}
	public void setPAPP_SYS_ID(Long PAPP_SYS_ID) {
		this.PAPP_SYS_ID = PAPP_SYS_ID;
	}
	public Long getPAPP_SYS_ID() {
		 return PAPP_SYS_ID;
	}
	public void setPAPP_POAD_SYS_ID(Long PAPP_POAD_SYS_ID) {
		this.PAPP_POAD_SYS_ID = PAPP_POAD_SYS_ID;
	}
	public Long getPAPP_POAD_SYS_ID() {
		 return PAPP_POAD_SYS_ID;
	}
	public void setPAPP_BASIC_RATE(Double PAPP_BASIC_RATE) {
		this.PAPP_BASIC_RATE = PAPP_BASIC_RATE;
	}
	public Double getPAPP_BASIC_RATE() {
		 return PAPP_BASIC_RATE;
	}
	public void setPAPP_POL_SYS_ID(Long PAPP_POL_SYS_ID) {
		this.PAPP_POL_SYS_ID = PAPP_POL_SYS_ID;
	}
	public Long getPAPP_POL_SYS_ID() {
		 return PAPP_POL_SYS_ID;
	}
	public void setPAPP_LC_SA(Double PAPP_LC_SA) {
		this.PAPP_LC_SA = PAPP_LC_SA;
	}
	public Double getPAPP_LC_SA() {
		 return PAPP_LC_SA;
	}
	public void setPAPP_ORG_LC_SA(Double PAPP_ORG_LC_SA) {
		this.PAPP_ORG_LC_SA = PAPP_ORG_LC_SA;
	}
	public Double getPAPP_ORG_LC_SA() {
		 return PAPP_ORG_LC_SA;
	}
	public void setPAPP_ORG_LC_BASIC_PREM(Double PAPP_ORG_LC_BASIC_PREM) {
		this.PAPP_ORG_LC_BASIC_PREM = PAPP_ORG_LC_BASIC_PREM;
	}
	public Double getPAPP_ORG_LC_BASIC_PREM() {
		 return PAPP_ORG_LC_BASIC_PREM;
	}
	public void setPAPP_ORG_LC_ADDL_PREM(Double PAPP_ORG_LC_ADDL_PREM) {
		this.PAPP_ORG_LC_ADDL_PREM = PAPP_ORG_LC_ADDL_PREM;
	}
	public Double getPAPP_ORG_LC_ADDL_PREM() {
		 return PAPP_ORG_LC_ADDL_PREM;
	}
	public void setPAPP_UPD_UID(String PAPP_UPD_UID) {
		this.PAPP_UPD_UID = PAPP_UPD_UID;
	}
	public String getPAPP_UPD_UID() {
		 return PAPP_UPD_UID;
	}
	public void setPAPP_MAIN_PROD_YN(String PAPP_MAIN_PROD_YN) {
		this.PAPP_MAIN_PROD_YN = PAPP_MAIN_PROD_YN;
	}
	public String getPAPP_MAIN_PROD_YN() {
		 return PAPP_MAIN_PROD_YN;
	}
	public void setPAPP_PLAN_TYPE(String PAPP_PLAN_TYPE) {
		this.PAPP_PLAN_TYPE = PAPP_PLAN_TYPE;
	}
	public String getPAPP_PLAN_TYPE() {
		 return PAPP_PLAN_TYPE;
	}
	public void setPAPP_PROD_STATUS(String PAPP_PROD_STATUS) {
		this.PAPP_PROD_STATUS = PAPP_PROD_STATUS;
	}
	public String getPAPP_PROD_STATUS() {
		 return PAPP_PROD_STATUS;
	}
	public void setUI_M_PAPP_PLAN_DESC(String UI_M_PAPP_PLAN_DESC) {
		this.UI_M_PAPP_PLAN_DESC = UI_M_PAPP_PLAN_DESC;
	}
	public String getUI_M_PAPP_PLAN_DESC() {
		 return UI_M_PAPP_PLAN_DESC;
	}
	public void setPAPP_STATUS(String PAPP_STATUS) {
		this.PAPP_STATUS = PAPP_STATUS;
	}
	public String getPAPP_STATUS() {
		 return PAPP_STATUS;
	}
	public void setPAPP_LC_BASIC_PREM(Double PAPP_LC_BASIC_PREM) {
		this.PAPP_LC_BASIC_PREM = PAPP_LC_BASIC_PREM;
	}
	public Double getPAPP_LC_BASIC_PREM() {
		 return PAPP_LC_BASIC_PREM;
	}
	public void setPAPP_FC_BASIC_PREM(Double PAPP_FC_BASIC_PREM) {
		this.PAPP_FC_BASIC_PREM = PAPP_FC_BASIC_PREM;
	}
	public Double getPAPP_FC_BASIC_PREM() {
		 return PAPP_FC_BASIC_PREM;
	}
	public void setPAPP_CR_DT(Date PAPP_CR_DT) {
		this.PAPP_CR_DT = PAPP_CR_DT;
	}
	public Date getPAPP_CR_DT() {
		 return PAPP_CR_DT;
	}
	public void setPAPP_ORG_FC_SA(Double PAPP_ORG_FC_SA) {
		this.PAPP_ORG_FC_SA = PAPP_ORG_FC_SA;
	}
	public Double getPAPP_ORG_FC_SA() {
		 return PAPP_ORG_FC_SA;
	}
	public void setPAPP_CR_UID(String PAPP_CR_UID) {
		this.PAPP_CR_UID = PAPP_CR_UID;
	}
	public String getPAPP_CR_UID() {
		 return PAPP_CR_UID;
	}
	public void setPAPP_LC_ADDL_PREM(Double PAPP_LC_ADDL_PREM) {
		this.PAPP_LC_ADDL_PREM = PAPP_LC_ADDL_PREM;
	}
	public Double getPAPP_LC_ADDL_PREM() {
		 return PAPP_LC_ADDL_PREM;
	}
	public void setPAPP_ORG_FC_BASIC_PREM(Double PAPP_ORG_FC_BASIC_PREM) {
		this.PAPP_ORG_FC_BASIC_PREM = PAPP_ORG_FC_BASIC_PREM;
	}
	public Double getPAPP_ORG_FC_BASIC_PREM() {
		 return PAPP_ORG_FC_BASIC_PREM;
	}

}
