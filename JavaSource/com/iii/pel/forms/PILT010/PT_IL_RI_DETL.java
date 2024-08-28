package com.iii.pel.forms.PILT010;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_RI_DETL")
public class PT_IL_RI_DETL extends BaseValueBean {

	@Column(name="RD_COVER_CODE")
	private String RD_COVER_CODE;

	@Column(name="RD_ASSR_CODE")
	private String RD_ASSR_CODE;

	@Column(name="RD_SCHD_DT")
	private Date RD_SCHD_DT;

	@Column(name="RD_TAR_RATE")
	private Double RD_TAR_RATE;

	@Column(name="RD_TAR_RATE_PER")
	private Integer RD_TAR_RATE_PER;

	@Column(name="RD_FC_SA")
	private Double RD_FC_SA;

	@Column(name="RD_FC_PREM")
	private Double RD_FC_PREM;

	@Column(name="RD_LC_PRD_PREM")
	private Double RD_LC_PRD_PREM;

	@Column(name="RD_PRD_FM_DT")
	private Date RD_PRD_FM_DT;

	@Column(name="RD_PRD_TO_DT")
	private Date RD_PRD_TO_DT;

	@Column(name="RD_FRZ_FLAG")
	private String RD_FRZ_FLAG;

	@Column(name="RD_TREATY_CODE")
	private String RD_TREATY_CODE;

	private String UI_M_TTY_CODE_DESC;

	@Column(name="RD_REMARKS")
	private String RD_REMARKS;
	
	private boolean RD_REMARKS_DIS;

	@Column(name="RD_END_NO_IDX")
	private Integer RD_END_NO_IDX;
	
	@Column(name="RD_CR_UID")
	private String RD_CR_UID;
	
	@Column(name="RD_CR_DT")
	private Date RD_CR_DT;
	
	@Column(name="RD_POL_NO")
	private String RD_POL_NO;
	
	private Integer UI_M_PT_CURR_RATE;
	
	private String UI_M_PT_CURR_CODE;
	
	private Double UI_M_ORG_SA;
	
	@Column(name="RD_POL_SYS_ID")
	private Long RD_POL_SYS_ID;

	@Column(name="RD_COVER_SYS_ID")
	private Integer RD_COVER_SYS_ID;
	
	@Column(name="RD_YEAR")
	private Integer RD_YEAR;
	
	private String UI_M_ASSR_NAME;
	
	private Date UI_M_PERIOD_FM;
	
	private Date UI_M_PERIOD_TO;
	
	private String UI_M_SPL_RETN_PREM;
	
	private String UI_M_PC_FAC_CLOSE_FLAG;
	
	private String RD_POL_SA_CURR_CODE;
	
	private String UI_M_POL_SA_CURR_DESC;
	
	private String RD_CUST_PREM_CURR_CODE;
	
	private String UI_M_CUST_CURR_DESC;
	
	private String RD_TREATY_CURR_CODE;
	
	private String UI_M_TTY_CURR_DESC;
	
	private String UI_RD_PRD_FM_DT;
	
	private String UI_RD_PRD_TO_DT;
	
	@Column(name="RD_END_NO")
	private String RD_END_NO;

	@Column(name="RD_UW_YEAR")
	private Integer RD_UW_YEAR;
	
	@Column(name="RD_COVER_TYPE")
	private String RD_COVER_TYPE;
	
	@Column(name="RD_SYS_ID")
	private Integer RD_SYS_ID;
	
	@Column(name="RD_FC_POL_PREM")
	private Double RD_FC_POL_PREM;
	
	@Column(name="RD_FC_POL_SA")
	private Double RD_FC_POL_SA;
	
	private Integer RD_ASSURED_AGE;
	
	private Integer RD_POL_EXCH_RATE;
	
	private Integer RD_CUST_PREM_EXCH_RATE;
	
	private String UI_M_CLOSEFLAG;
	
	
	
	public String getUI_RD_PRD_FM_DT() {
		return UI_RD_PRD_FM_DT;
	}

	public void setUI_RD_PRD_FM_DT(String uI_RD_PRD_FM_DT) {
		UI_RD_PRD_FM_DT = uI_RD_PRD_FM_DT;
	}

	public String getUI_RD_PRD_TO_DT() {
		return UI_RD_PRD_TO_DT;
	}

	public void setUI_RD_PRD_TO_DT(String uI_RD_PRD_TO_DT) {
		UI_RD_PRD_TO_DT = uI_RD_PRD_TO_DT;
	}

	public String getUI_M_CLOSEFLAG() {
		return UI_M_CLOSEFLAG;
	}

	public void setUI_M_CLOSEFLAG(String ui_m_closeflag) {
		UI_M_CLOSEFLAG = ui_m_closeflag;
	}

	public String getRD_COVER_CODE() {
		return RD_COVER_CODE;
	}

	public void setRD_COVER_CODE(String RD_COVER_CODE) {
		this.RD_COVER_CODE = RD_COVER_CODE;
	}

	public String getRD_ASSR_CODE() {
		return RD_ASSR_CODE;
	}

	public void setRD_ASSR_CODE(String RD_ASSR_CODE) {
		this.RD_ASSR_CODE = RD_ASSR_CODE;
	}

	public Date getRD_SCHD_DT() {
		 return RD_SCHD_DT;
	}

	public void setRD_SCHD_DT(Date RD_SCHD_DT) {
		this.RD_SCHD_DT = RD_SCHD_DT;
	}

	

	public Double getRD_TAR_RATE() {
		return RD_TAR_RATE;
	}

	public void setRD_TAR_RATE(Double rd_tar_rate) {
		RD_TAR_RATE = rd_tar_rate;
	}

	public Integer getRD_TAR_RATE_PER() {
		return RD_TAR_RATE_PER;
	}

	public void setRD_TAR_RATE_PER(Integer RD_TAR_RATE_PER) {
		this.RD_TAR_RATE_PER = RD_TAR_RATE_PER;
	}

	public Double getRD_FC_SA() {
		return RD_FC_SA;
	}

	public void setRD_FC_SA(Double RD_FC_SA) {
		this.RD_FC_SA = RD_FC_SA;
	}

	public Double getRD_FC_PREM() {
		return RD_FC_PREM;
	}

	public void setRD_FC_PREM(Double RD_FC_PREM) {
		this.RD_FC_PREM = RD_FC_PREM;
	}

	public Double getRD_LC_PRD_PREM() {
		return RD_LC_PRD_PREM;
	}

	public void setRD_LC_PRD_PREM(Double RD_LC_PRD_PREM) {
		this.RD_LC_PRD_PREM = RD_LC_PRD_PREM;
	}

	public Date getRD_PRD_FM_DT() {
		 return RD_PRD_FM_DT;
	}

	public void setRD_PRD_FM_DT(Date RD_PRD_FM_DT) {
		this.RD_PRD_FM_DT = RD_PRD_FM_DT;
	}

	public Date getRD_PRD_TO_DT() {
		 return RD_PRD_TO_DT;
	}

	public void setRD_PRD_TO_DT(Date RD_PRD_TO_DT) {
		this.RD_PRD_TO_DT = RD_PRD_TO_DT;
	}

	public String getRD_FRZ_FLAG() {
		return RD_FRZ_FLAG;
	}

	public void setRD_FRZ_FLAG(String RD_FRZ_FLAG) {
		this.RD_FRZ_FLAG = RD_FRZ_FLAG;
	}

	public String getRD_TREATY_CODE() {
		return RD_TREATY_CODE;
	}

	public void setRD_TREATY_CODE(String RD_TREATY_CODE) {
		this.RD_TREATY_CODE = RD_TREATY_CODE;
	}

	public String getUI_M_TTY_CODE_DESC() {
		return UI_M_TTY_CODE_DESC;
	}

	public void setUI_M_TTY_CODE_DESC(String UI_M_TTY_CODE_DESC) {
		this.UI_M_TTY_CODE_DESC = UI_M_TTY_CODE_DESC;
	}

	public String getRD_REMARKS() {
		return RD_REMARKS;
	}

	public void setRD_REMARKS(String RD_REMARKS) {
		this.RD_REMARKS = RD_REMARKS;
	}

	public Integer getRD_END_NO_IDX() {
		return RD_END_NO_IDX;
	}

	public void setRD_END_NO_IDX(Integer rd_end_no_idx) {
		RD_END_NO_IDX = rd_end_no_idx;
	}

	public String getRD_CR_UID() {
		return RD_CR_UID;
	}

	public void setRD_CR_UID(String rd_cr_uid) {
		RD_CR_UID = rd_cr_uid;
	}

	public Date getRD_CR_DT() {
		return RD_CR_DT;
	}

	public void setRD_CR_DT(Date rd_cr_dt) {
		RD_CR_DT = rd_cr_dt;
	}

	public String getRD_POL_NO() {
		return RD_POL_NO;
	}

	public void setRD_POL_NO(String rd_pol_no) {
		RD_POL_NO = rd_pol_no;
	}

	public Integer getUI_M_PT_CURR_RATE() {
		return UI_M_PT_CURR_RATE;
	}

	public void setUI_M_PT_CURR_RATE(Integer ui_m_pt_curr_rate) {
		UI_M_PT_CURR_RATE = ui_m_pt_curr_rate;
	}

	public String getUI_M_PT_CURR_CODE() {
		return UI_M_PT_CURR_CODE;
	}

	public void setUI_M_PT_CURR_CODE(String ui_m_pt_curr_code) {
		UI_M_PT_CURR_CODE = ui_m_pt_curr_code;
	}

	public Double getUI_M_ORG_SA() {
		return UI_M_ORG_SA;
	}

	public void setUI_M_ORG_SA(Double ui_m_org_sa) {
		UI_M_ORG_SA = ui_m_org_sa;
	}

	

	public Long getRD_POL_SYS_ID() {
		return RD_POL_SYS_ID;
	}

	public void setRD_POL_SYS_ID(Long rd_pol_sys_id) {
		RD_POL_SYS_ID = rd_pol_sys_id;
	}

	public Integer getRD_COVER_SYS_ID() {
		return RD_COVER_SYS_ID;
	}

	public void setRD_COVER_SYS_ID(Integer rd_cover_sys_id) {
		RD_COVER_SYS_ID = rd_cover_sys_id;
	}

	public Integer getRD_YEAR() {
		return RD_YEAR;
	}

	public void setRD_YEAR(Integer rd_year) {
		RD_YEAR = rd_year;
	}

	public String getUI_M_ASSR_NAME() {
		return UI_M_ASSR_NAME;
	}

	public void setUI_M_ASSR_NAME(String ui_m_assr_name) {
		UI_M_ASSR_NAME = ui_m_assr_name;
	}

	public Date getUI_M_PERIOD_FM() {
		return UI_M_PERIOD_FM;
	}

	public void setUI_M_PERIOD_FM(Date ui_m_period_fm) {
		UI_M_PERIOD_FM = ui_m_period_fm;
	}

	public Date getUI_M_PERIOD_TO() {
		return UI_M_PERIOD_TO;
	}

	public void setUI_M_PERIOD_TO(Date ui_m_period_to) {
		UI_M_PERIOD_TO = ui_m_period_to;
	}

	public String getUI_M_SPL_RETN_PREM() {
		return UI_M_SPL_RETN_PREM;
	}

	public void setUI_M_SPL_RETN_PREM(String ui_m_spl_retn_prem) {
		UI_M_SPL_RETN_PREM = ui_m_spl_retn_prem;
	}

	public String getUI_M_PC_FAC_CLOSE_FLAG() {
		return UI_M_PC_FAC_CLOSE_FLAG;
	}

	public void setUI_M_PC_FAC_CLOSE_FLAG(String ui_m_pc_fac_close_flag) {
		UI_M_PC_FAC_CLOSE_FLAG = ui_m_pc_fac_close_flag;
	}

	public String getRD_POL_SA_CURR_CODE() {
		return RD_POL_SA_CURR_CODE;
	}

	public void setRD_POL_SA_CURR_CODE(String rd_pol_sa_curr_code) {
		RD_POL_SA_CURR_CODE = rd_pol_sa_curr_code;
	}

	public String getUI_M_POL_SA_CURR_DESC() {
		return UI_M_POL_SA_CURR_DESC;
	}

	public void setUI_M_POL_SA_CURR_DESC(String ui_m_pol_sa_curr_desc) {
		UI_M_POL_SA_CURR_DESC = ui_m_pol_sa_curr_desc;
	}

	public String getRD_CUST_PREM_CURR_CODE() {
		return RD_CUST_PREM_CURR_CODE;
	}

	public void setRD_CUST_PREM_CURR_CODE(String rd_cust_prem_curr_code) {
		RD_CUST_PREM_CURR_CODE = rd_cust_prem_curr_code;
	}

	public String getUI_M_CUST_CURR_DESC() {
		return UI_M_CUST_CURR_DESC;
	}

	public void setUI_M_CUST_CURR_DESC(String ui_m_cust_curr_desc) {
		UI_M_CUST_CURR_DESC = ui_m_cust_curr_desc;
	}

	public String getRD_TREATY_CURR_CODE() {
		return RD_TREATY_CURR_CODE;
	}

	public void setRD_TREATY_CURR_CODE(String rd_treaty_curr_code) {
		RD_TREATY_CURR_CODE = rd_treaty_curr_code;
	}

	public String getUI_M_TTY_CURR_DESC() {
		return UI_M_TTY_CURR_DESC;
	}

	public void setUI_M_TTY_CURR_DESC(String ui_m_tty_curr_desc) {
		UI_M_TTY_CURR_DESC = ui_m_tty_curr_desc;
	}

	public boolean isRD_REMARKS_DIS() {
		return RD_REMARKS_DIS;
	}

	public void setRD_REMARKS_DIS(boolean rd_remarks_dis) {
		RD_REMARKS_DIS = rd_remarks_dis;
	}

	public String getRD_END_NO() {
		return RD_END_NO;
	}

	public void setRD_END_NO(String rd_end_no) {
		RD_END_NO = rd_end_no;
	}

	public Integer getRD_UW_YEAR() {
		return RD_UW_YEAR;
	}

	public void setRD_UW_YEAR(Integer rd_uw_year) {
		RD_UW_YEAR = rd_uw_year;
	}

	public String getRD_COVER_TYPE() {
		return RD_COVER_TYPE;
	}

	public void setRD_COVER_TYPE(String rd_cover_type) {
		RD_COVER_TYPE = rd_cover_type;
	}

	public Integer getRD_SYS_ID() {
		return RD_SYS_ID;
	}

	public void setRD_SYS_ID(Integer rd_sys_id) {
		RD_SYS_ID = rd_sys_id;
	}

	public Double getRD_FC_POL_PREM() {
		return RD_FC_POL_PREM;
	}

	public void setRD_FC_POL_PREM(Double rd_fc_pol_prem) {
		RD_FC_POL_PREM = rd_fc_pol_prem;
	}

	public Double getRD_FC_POL_SA() {
		return RD_FC_POL_SA;
	}

	public void setRD_FC_POL_SA(Double rd_fc_pol_sa) {
		RD_FC_POL_SA = rd_fc_pol_sa;
	}

	public Integer getRD_ASSURED_AGE() {
		return RD_ASSURED_AGE;
	}

	public void setRD_ASSURED_AGE(Integer rd_assured_age) {
		RD_ASSURED_AGE = rd_assured_age;
	}

	public Integer getRD_POL_EXCH_RATE() {
		return RD_POL_EXCH_RATE;
	}

	public void setRD_POL_EXCH_RATE(Integer rd_pol_exch_rate) {
		RD_POL_EXCH_RATE = rd_pol_exch_rate;
	}

	public Integer getRD_CUST_PREM_EXCH_RATE() {
		return RD_CUST_PREM_EXCH_RATE;
	}

	public void setRD_CUST_PREM_EXCH_RATE(Integer rd_cust_prem_exch_rate) {
		RD_CUST_PREM_EXCH_RATE = rd_cust_prem_exch_rate;
	}

}
