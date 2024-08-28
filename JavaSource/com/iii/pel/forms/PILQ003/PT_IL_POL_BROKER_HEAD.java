package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_BROKER_HEAD")
public class PT_IL_POL_BROKER_HEAD extends BaseValueBean {

	@Column(name="POBH_SYS_ID")
	private Long POBH_SYS_ID;

	@Column(name="POBH_POL_SYS_ID")
	private Long POBH_POL_SYS_ID;

	@Column(name="POBH_BROKER_CODE")
	private String POBH_BROKER_CODE;

	@Column(name="POBH_COVER_CODE")
	private String POBH_COVER_CODE;

	@Column(name="POBH_BROKER_CURR_CODE")
	private String POBH_BROKER_CURR_CODE;

	@Column(name="POBH_REMARKS")
	private String POBH_REMARKS;

	@Column(name="POBH_DEL_FLAG")
	private String POBH_DEL_FLAG;

	@Column(name="POBH_CR_DT")
	private Date POBH_CR_DT;

	@Column(name="POBH_CR_UID")
	private String POBH_CR_UID;

	@Column(name="POBH_UPD_DT")
	private Date POBH_UPD_DT;

	@Column(name="POBH_UPD_UID")
	private String POBH_UPD_UID;

	@Column(name="POBH_COMM_CODE")
	private String POBH_COMM_CODE;

	@Column(name="POBH_SRNO")
	private Integer POBH_SRNO;

	@Column(name="POBH_APPLY_ON_SRNO")
	private Integer POBH_APPLY_ON_SRNO;

	@Column(name="POBH_ACTING_AGENT_YN")
	private String POBH_ACTING_AGENT_YN;

	@Column(name="POBH_AGENT_RANK_CODE")
	private String POBH_AGENT_RANK_CODE;

	@Column(name="POBH_AGENT_LEVEL")
	private Double POBH_AGENT_LEVEL;

	@Column(name="POBH_MKT_CODE")
	private String POBH_MKT_CODE;

	@Column(name="POBH_UNIT_CODE")
	private String POBH_UNIT_CODE;

	@Column(name="POBH_AGENCY_BRANCH_CODE")
	private String POBH_AGENCY_BRANCH_CODE;

	@Column(name="POBH_REGION_CODE")
	private String POBH_REGION_CODE;

	@Column(name="POBH_AGENCY_CODE")
	private String POBH_AGENCY_CODE;

	@Column(name="POBH_RECRUITER_CODE")
	private String POBH_RECRUITER_CODE;

	private String UI_M_POBH_BROKER_DESC;
	
	private String UI_M_POBH_COVER_DESC;
	
	private String UI_M_POBH_CURR_DESC;
	
	private String UI_M_PS_DESC;
	
	public void setPOBH_UNIT_CODE(String POBH_UNIT_CODE) {
		this.POBH_UNIT_CODE = POBH_UNIT_CODE;
	}
	public String getPOBH_UNIT_CODE() {
		 return POBH_UNIT_CODE;
	}
	public void setPOBH_COVER_CODE(String POBH_COVER_CODE) {
		this.POBH_COVER_CODE = POBH_COVER_CODE;
	}
	public String getPOBH_COVER_CODE() {
		 return POBH_COVER_CODE;
	}
	public void setUI_M_POBH_CURR_DESC(String UI_M_POBH_CURR_DESC) {
		this.UI_M_POBH_CURR_DESC = UI_M_POBH_CURR_DESC;
	}
	public String getUI_M_POBH_CURR_DESC() {
		 return UI_M_POBH_CURR_DESC;
	}
	public void setPOBH_UPD_DT(Date POBH_UPD_DT) {
		this.POBH_UPD_DT = POBH_UPD_DT;
	}
	public Date getPOBH_UPD_DT() {
		 return POBH_UPD_DT;
	}
	public void setPOBH_AGENCY_BRANCH_CODE(String POBH_AGENCY_BRANCH_CODE) {
		this.POBH_AGENCY_BRANCH_CODE = POBH_AGENCY_BRANCH_CODE;
	}
	public String getPOBH_AGENCY_BRANCH_CODE() {
		 return POBH_AGENCY_BRANCH_CODE;
	}
	public void setPOBH_SYS_ID(Long POBH_SYS_ID) {
		this.POBH_SYS_ID = POBH_SYS_ID;
	}
	public Long getPOBH_SYS_ID() {
		 return POBH_SYS_ID;
	}
	public void setUI_M_PS_DESC(String UI_M_PS_DESC) {
		this.UI_M_PS_DESC = UI_M_PS_DESC;
	}
	public String getUI_M_PS_DESC() {
		 return UI_M_PS_DESC;
	}
	public void setUI_M_POBH_BROKER_DESC(String UI_M_POBH_BROKER_DESC) {
		this.UI_M_POBH_BROKER_DESC = UI_M_POBH_BROKER_DESC;
	}
	public String getUI_M_POBH_BROKER_DESC() {
		 return UI_M_POBH_BROKER_DESC;
	}
	public void setUI_M_POBH_COVER_DESC(String UI_M_POBH_COVER_DESC) {
		this.UI_M_POBH_COVER_DESC = UI_M_POBH_COVER_DESC;
	}
	public String getUI_M_POBH_COVER_DESC() {
		 return UI_M_POBH_COVER_DESC;
	}
	public void setPOBH_MKT_CODE(String POBH_MKT_CODE) {
		this.POBH_MKT_CODE = POBH_MKT_CODE;
	}
	public String getPOBH_MKT_CODE() {
		 return POBH_MKT_CODE;
	}
	public void setPOBH_RECRUITER_CODE(String POBH_RECRUITER_CODE) {
		this.POBH_RECRUITER_CODE = POBH_RECRUITER_CODE;
	}
	public String getPOBH_RECRUITER_CODE() {
		 return POBH_RECRUITER_CODE;
	}
	public void setPOBH_POL_SYS_ID(Long POBH_POL_SYS_ID) {
		this.POBH_POL_SYS_ID = POBH_POL_SYS_ID;
	}
	public Long getPOBH_POL_SYS_ID() {
		 return POBH_POL_SYS_ID;
	}
	public void setPOBH_UPD_UID(String POBH_UPD_UID) {
		this.POBH_UPD_UID = POBH_UPD_UID;
	}
	public String getPOBH_UPD_UID() {
		 return POBH_UPD_UID;
	}
	public void setPOBH_BROKER_CURR_CODE(String POBH_BROKER_CURR_CODE) {
		this.POBH_BROKER_CURR_CODE = POBH_BROKER_CURR_CODE;
	}
	public String getPOBH_BROKER_CURR_CODE() {
		 return POBH_BROKER_CURR_CODE;
	}
	public void setPOBH_DEL_FLAG(String POBH_DEL_FLAG) {
		this.POBH_DEL_FLAG = POBH_DEL_FLAG;
	}
	public String getPOBH_DEL_FLAG() {
		 return POBH_DEL_FLAG;
	}
	public void setPOBH_ACTING_AGENT_YN(String POBH_ACTING_AGENT_YN) {
		this.POBH_ACTING_AGENT_YN = POBH_ACTING_AGENT_YN;
	}
	public String getPOBH_ACTING_AGENT_YN() {
		 return POBH_ACTING_AGENT_YN;
	}
	public void setPOBH_REMARKS(String POBH_REMARKS) {
		this.POBH_REMARKS = POBH_REMARKS;
	}
	public String getPOBH_REMARKS() {
		 return POBH_REMARKS;
	}
	public void setPOBH_AGENT_LEVEL(Double POBH_AGENT_LEVEL) {
		this.POBH_AGENT_LEVEL = POBH_AGENT_LEVEL;
	}
	public Double getPOBH_AGENT_LEVEL() {
		 return POBH_AGENT_LEVEL;
	}
	public void setPOBH_REGION_CODE(String POBH_REGION_CODE) {
		this.POBH_REGION_CODE = POBH_REGION_CODE;
	}
	public String getPOBH_REGION_CODE() {
		 return POBH_REGION_CODE;
	}
	public void setPOBH_AGENT_RANK_CODE(String POBH_AGENT_RANK_CODE) {
		this.POBH_AGENT_RANK_CODE = POBH_AGENT_RANK_CODE;
	}
	public String getPOBH_AGENT_RANK_CODE() {
		 return POBH_AGENT_RANK_CODE;
	}
	public void setPOBH_CR_UID(String POBH_CR_UID) {
		this.POBH_CR_UID = POBH_CR_UID;
	}
	public String getPOBH_CR_UID() {
		 return POBH_CR_UID;
	}
	public void setPOBH_COMM_CODE(String POBH_COMM_CODE) {
		this.POBH_COMM_CODE = POBH_COMM_CODE;
	}
	public String getPOBH_COMM_CODE() {
		 return POBH_COMM_CODE;
	}
	public void setPOBH_CR_DT(Date POBH_CR_DT) {
		this.POBH_CR_DT = POBH_CR_DT;
	}
	public Date getPOBH_CR_DT() {
		 return POBH_CR_DT;
	}
	public void setPOBH_BROKER_CODE(String POBH_BROKER_CODE) {
		this.POBH_BROKER_CODE = POBH_BROKER_CODE;
	}
	public String getPOBH_BROKER_CODE() {
		 return POBH_BROKER_CODE;
	}
	public void setPOBH_APPLY_ON_SRNO(Integer POBH_APPLY_ON_SRNO) {
		this.POBH_APPLY_ON_SRNO = POBH_APPLY_ON_SRNO;
	}
	public Integer getPOBH_APPLY_ON_SRNO() {
		 return POBH_APPLY_ON_SRNO;
	}
	public void setPOBH_AGENCY_CODE(String POBH_AGENCY_CODE) {
		this.POBH_AGENCY_CODE = POBH_AGENCY_CODE;
	}
	public String getPOBH_AGENCY_CODE() {
		 return POBH_AGENCY_CODE;
	}
	public void setPOBH_SRNO(Integer POBH_SRNO) {
		this.POBH_SRNO = POBH_SRNO;
	}
	public Integer getPOBH_SRNO() {
		 return POBH_SRNO;
	}

}
