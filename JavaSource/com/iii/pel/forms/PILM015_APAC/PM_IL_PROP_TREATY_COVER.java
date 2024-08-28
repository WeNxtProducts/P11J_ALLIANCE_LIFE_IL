package com.iii.pel.forms.PILM015_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PROP_TREATY_COVER")
public class PM_IL_PROP_TREATY_COVER extends BaseValueBean {

	@Column(name = "PTC_COVER_CODE")
	private String PTC_COVER_CODE;
	
	@Column(name = "PTC_STD_TREATY_LIMIT")
	private Double PTC_STD_TREATY_LIMIT;

	@Column(name = "PTC_SUB_STD_TREATY_LIMIT")
	private Double PTC_SUB_STD_TREATY_LIMIT;

	@Column(name = "PTC_RETN_PERC")
	private Double PTC_RETN_PERC;

	@Column(name = "PTC_STD_MAX_RETN")
	private Double PTC_STD_MAX_RETN;

	@Column(name = "PTC_SSTD_MAX_RETN")
	private Double PTC_SSTD_MAX_RETN;

	@Column(name = "PTC_COMM_PERC_1ST_YR")
	private Double PTC_COMM_PERC_1ST_YR;

	@Column(name = "PTC_COMM_PERC_SUB_YRS")
	private Double PTC_COMM_PERC_SUB_YRS;

	@Column(name = "PTC_SSTD_COMM_PERC_1ST_YR")
	private Double PTC_SSTD_COMM_PERC_1ST_YR;

	@Column(name = "PTC_SSTD_COMM_PERC_SUB_YRS")
	private Double PTC_SSTD_COMM_PERC_SUB_YRS;

	@Column(name = "PTC_SUB_STD_TARIFF")
	private String PTC_SUB_STD_TARIFF;

	private String UI_M_PTC_SUB_STD_TARIFF_DESC;

	@Column(name = "PTC_GROUP_COVER_YN")
	private String PTC_GROUP_COVER_YN;

	@Column(name = "PTC_CVR_GRP_CODE")
	private String PTC_CVR_GRP_CODE;

	private String UI_M_COVER_DESC;

	private String UI_M_PTC_CVR_GRP_CODE_DESC;

	@Column(name = "PTC_SYS_ID")
	private Double PTC_SYS_ID;

	@Column(name = "PTC_PTT_SYS_ID")
	private Double PTC_PTT_SYS_ID;

	@Column(name = "PTC_UPD_UID")
	private String PTC_UPD_UID;

	@Column(name = "PTC_UPD_DT")
	private Date PTC_UPD_DT;

	private boolean selected;
	
	private boolean PTC_COVER_CODE_DIS;
	
	private boolean PTC_STD_TREATY_LIMIT_DIS;

	private boolean PTC_SUB_STD_TREATY_LIMIT_DIS;

	private boolean PTC_RETN_PERC_DIS;

	private boolean PTC_STD_MAX_RETN_DIS;

	private boolean PTC_SSTD_MAX_RETN_DIS;

	private boolean PTC_COMM_PERC_1ST_YR_DIS;

	private boolean PTC_COMM_PERC_SUB_YRS_DIS;

	private boolean PTC_SSTD_COMM_PERC_1ST_YR_DIS;

	private boolean PTC_SSTD_COMM_PERC_SUB_YRS_DIS;

	private boolean PTC_SUB_STD_TARIFF_DIS;

	private boolean UI_M_PTC_SUB_STD_TARIFF_DESC_DIS;

	private boolean PTC_GROUP_COVER_YN_DIS;

	private boolean PTC_CVR_GRP_CODE_DIS;

	private boolean UI_M_COVER_DESC_DIS;

	private boolean UI_M_PTC_CVR_GRP_CODE_DESC_DIS;
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Double getPTC_PTT_SYS_ID() {
		return PTC_PTT_SYS_ID;
	}

	public void setPTC_PTT_SYS_ID(Double ptc_ptt_sys_id) {
		PTC_PTT_SYS_ID = ptc_ptt_sys_id;
	}

	public String getPTC_COVER_CODE() {
		return PTC_COVER_CODE;
	}

	public void setPTC_COVER_CODE(String PTC_COVER_CODE) {
		this.PTC_COVER_CODE = PTC_COVER_CODE;
	}

	public Double getPTC_STD_TREATY_LIMIT() {
		return PTC_STD_TREATY_LIMIT;
	}

	public void setPTC_STD_TREATY_LIMIT(Double PTC_STD_TREATY_LIMIT) {
		this.PTC_STD_TREATY_LIMIT = PTC_STD_TREATY_LIMIT;
	}

	public Double getPTC_SUB_STD_TREATY_LIMIT() {
		return PTC_SUB_STD_TREATY_LIMIT;
	}

	public void setPTC_SUB_STD_TREATY_LIMIT(Double PTC_SUB_STD_TREATY_LIMIT) {
		this.PTC_SUB_STD_TREATY_LIMIT = PTC_SUB_STD_TREATY_LIMIT;
	}

	public Double getPTC_RETN_PERC() {
		return PTC_RETN_PERC;
	}

	public void setPTC_RETN_PERC(Double PTC_RETN_PERC) {
		this.PTC_RETN_PERC = PTC_RETN_PERC;
	}

	public Double getPTC_STD_MAX_RETN() {
		return PTC_STD_MAX_RETN;
	}

	public void setPTC_STD_MAX_RETN(Double PTC_STD_MAX_RETN) {
		this.PTC_STD_MAX_RETN = PTC_STD_MAX_RETN;
	}

	public Double getPTC_SSTD_MAX_RETN() {
		return PTC_SSTD_MAX_RETN;
	}

	public void setPTC_SSTD_MAX_RETN(Double PTC_SSTD_MAX_RETN) {
		this.PTC_SSTD_MAX_RETN = PTC_SSTD_MAX_RETN;
	}

	public Double getPTC_COMM_PERC_1ST_YR() {
		return PTC_COMM_PERC_1ST_YR;
	}

	public void setPTC_COMM_PERC_1ST_YR(Double PTC_COMM_PERC_1ST_YR) {
		this.PTC_COMM_PERC_1ST_YR = PTC_COMM_PERC_1ST_YR;
	}

	public Double getPTC_COMM_PERC_SUB_YRS() {
		return PTC_COMM_PERC_SUB_YRS;
	}

	public void setPTC_COMM_PERC_SUB_YRS(Double PTC_COMM_PERC_SUB_YRS) {
		this.PTC_COMM_PERC_SUB_YRS = PTC_COMM_PERC_SUB_YRS;
	}

	public Double getPTC_SSTD_COMM_PERC_1ST_YR() {
		return PTC_SSTD_COMM_PERC_1ST_YR;
	}

	public void setPTC_SSTD_COMM_PERC_1ST_YR(Double PTC_SSTD_COMM_PERC_1ST_YR) {
		this.PTC_SSTD_COMM_PERC_1ST_YR = PTC_SSTD_COMM_PERC_1ST_YR;
	}

	public Double getPTC_SSTD_COMM_PERC_SUB_YRS() {
		return PTC_SSTD_COMM_PERC_SUB_YRS;
	}

	public void setPTC_SSTD_COMM_PERC_SUB_YRS(Double PTC_SSTD_COMM_PERC_SUB_YRS) {
		this.PTC_SSTD_COMM_PERC_SUB_YRS = PTC_SSTD_COMM_PERC_SUB_YRS;
	}

	public String getPTC_SUB_STD_TARIFF() {
		return PTC_SUB_STD_TARIFF;
	}

	public void setPTC_SUB_STD_TARIFF(String PTC_SUB_STD_TARIFF) {
		this.PTC_SUB_STD_TARIFF = PTC_SUB_STD_TARIFF;
	}

	public String getUI_M_PTC_SUB_STD_TARIFF_DESC() {
		return UI_M_PTC_SUB_STD_TARIFF_DESC;
	}

	public void setUI_M_PTC_SUB_STD_TARIFF_DESC(
			String UI_M_PTC_SUB_STD_TARIFF_DESC) {
		this.UI_M_PTC_SUB_STD_TARIFF_DESC = UI_M_PTC_SUB_STD_TARIFF_DESC;
	}

	public String getPTC_GROUP_COVER_YN() {
		return PTC_GROUP_COVER_YN;
	}

	public void setPTC_GROUP_COVER_YN(String PTC_GROUP_COVER_YN) {
		this.PTC_GROUP_COVER_YN = PTC_GROUP_COVER_YN;
	}

	public String getPTC_CVR_GRP_CODE() {
		return PTC_CVR_GRP_CODE;
	}

	public void setPTC_CVR_GRP_CODE(String PTC_CVR_GRP_CODE) {
		this.PTC_CVR_GRP_CODE = PTC_CVR_GRP_CODE;
	}

	public String getUI_M_COVER_DESC() {
		return UI_M_COVER_DESC;
	}

	public void setUI_M_COVER_DESC(String UI_M_COVER_DESC) {
		this.UI_M_COVER_DESC = UI_M_COVER_DESC;
	}

	public String getUI_M_PTC_CVR_GRP_CODE_DESC() {
		return UI_M_PTC_CVR_GRP_CODE_DESC;
	}

	public void setUI_M_PTC_CVR_GRP_CODE_DESC(String UI_M_PTC_CVR_GRP_CODE_DESC) {
		this.UI_M_PTC_CVR_GRP_CODE_DESC = UI_M_PTC_CVR_GRP_CODE_DESC;
	}

	public Double getPTC_SYS_ID() {
		return PTC_SYS_ID;
	}

	public void setPTC_SYS_ID(Double ptc_sys_id) {
		PTC_SYS_ID = ptc_sys_id;
	}

	public String getPTC_UPD_UID() {
		return PTC_UPD_UID;
	}

	public void setPTC_UPD_UID(String ptc_upd_uid) {
		PTC_UPD_UID = ptc_upd_uid;
	}

	public Date getPTC_UPD_DT() {
		return PTC_UPD_DT;
	}

	public void setPTC_UPD_DT(Date ptc_upd_dt) {
		PTC_UPD_DT = ptc_upd_dt;
	}

	public boolean isPTC_COVER_CODE_DIS() {
		return PTC_COVER_CODE_DIS;
	}

	public void setPTC_COVER_CODE_DIS(boolean ptc_cover_code_dis) {
		PTC_COVER_CODE_DIS = ptc_cover_code_dis;
	}

	public boolean isPTC_STD_TREATY_LIMIT_DIS() {
		return PTC_STD_TREATY_LIMIT_DIS;
	}

	public void setPTC_STD_TREATY_LIMIT_DIS(boolean ptc_std_treaty_limit_dis) {
		PTC_STD_TREATY_LIMIT_DIS = ptc_std_treaty_limit_dis;
	}

	public boolean isPTC_SUB_STD_TREATY_LIMIT_DIS() {
		return PTC_SUB_STD_TREATY_LIMIT_DIS;
	}

	public void setPTC_SUB_STD_TREATY_LIMIT_DIS(boolean ptc_sub_std_treaty_limit_dis) {
		PTC_SUB_STD_TREATY_LIMIT_DIS = ptc_sub_std_treaty_limit_dis;
	}

	public boolean isPTC_RETN_PERC_DIS() {
		return PTC_RETN_PERC_DIS;
	}

	public void setPTC_RETN_PERC_DIS(boolean ptc_retn_perc_dis) {
		PTC_RETN_PERC_DIS = ptc_retn_perc_dis;
	}

	public boolean isPTC_STD_MAX_RETN_DIS() {
		return PTC_STD_MAX_RETN_DIS;
	}

	public void setPTC_STD_MAX_RETN_DIS(boolean ptc_std_max_retn_dis) {
		PTC_STD_MAX_RETN_DIS = ptc_std_max_retn_dis;
	}

	public boolean isPTC_SSTD_MAX_RETN_DIS() {
		return PTC_SSTD_MAX_RETN_DIS;
	}

	public void setPTC_SSTD_MAX_RETN_DIS(boolean ptc_sstd_max_retn_dis) {
		PTC_SSTD_MAX_RETN_DIS = ptc_sstd_max_retn_dis;
	}

	public boolean isPTC_COMM_PERC_1ST_YR_DIS() {
		return PTC_COMM_PERC_1ST_YR_DIS;
	}

	public void setPTC_COMM_PERC_1ST_YR_DIS(boolean ptc_comm_perc_1st_yr_dis) {
		PTC_COMM_PERC_1ST_YR_DIS = ptc_comm_perc_1st_yr_dis;
	}

	public boolean isPTC_COMM_PERC_SUB_YRS_DIS() {
		return PTC_COMM_PERC_SUB_YRS_DIS;
	}

	public void setPTC_COMM_PERC_SUB_YRS_DIS(boolean ptc_comm_perc_sub_yrs_dis) {
		PTC_COMM_PERC_SUB_YRS_DIS = ptc_comm_perc_sub_yrs_dis;
	}

	public boolean isPTC_SSTD_COMM_PERC_1ST_YR_DIS() {
		return PTC_SSTD_COMM_PERC_1ST_YR_DIS;
	}

	public void setPTC_SSTD_COMM_PERC_1ST_YR_DIS(
			boolean ptc_sstd_comm_perc_1st_yr_dis) {
		PTC_SSTD_COMM_PERC_1ST_YR_DIS = ptc_sstd_comm_perc_1st_yr_dis;
	}

	public boolean isPTC_SSTD_COMM_PERC_SUB_YRS_DIS() {
		return PTC_SSTD_COMM_PERC_SUB_YRS_DIS;
	}

	public void setPTC_SSTD_COMM_PERC_SUB_YRS_DIS(
			boolean ptc_sstd_comm_perc_sub_yrs_dis) {
		PTC_SSTD_COMM_PERC_SUB_YRS_DIS = ptc_sstd_comm_perc_sub_yrs_dis;
	}

	public boolean isPTC_SUB_STD_TARIFF_DIS() {
		return PTC_SUB_STD_TARIFF_DIS;
	}

	public void setPTC_SUB_STD_TARIFF_DIS(boolean ptc_sub_std_tariff_dis) {
		PTC_SUB_STD_TARIFF_DIS = ptc_sub_std_tariff_dis;
	}

	public boolean isUI_M_PTC_SUB_STD_TARIFF_DESC_DIS() {
		return UI_M_PTC_SUB_STD_TARIFF_DESC_DIS;
	}

	public void setUI_M_PTC_SUB_STD_TARIFF_DESC_DIS(
			boolean ui_m_ptc_sub_std_tariff_desc_dis) {
		UI_M_PTC_SUB_STD_TARIFF_DESC_DIS = ui_m_ptc_sub_std_tariff_desc_dis;
	}

	public boolean isPTC_GROUP_COVER_YN_DIS() {
		return PTC_GROUP_COVER_YN_DIS;
	}

	public void setPTC_GROUP_COVER_YN_DIS(boolean ptc_group_cover_yn_dis) {
		PTC_GROUP_COVER_YN_DIS = ptc_group_cover_yn_dis;
	}

	public boolean isPTC_CVR_GRP_CODE_DIS() {
		return PTC_CVR_GRP_CODE_DIS;
	}

	public void setPTC_CVR_GRP_CODE_DIS(boolean ptc_cvr_grp_code_dis) {
		PTC_CVR_GRP_CODE_DIS = ptc_cvr_grp_code_dis;
	}

	public boolean isUI_M_COVER_DESC_DIS() {
		return UI_M_COVER_DESC_DIS;
	}

	public void setUI_M_COVER_DESC_DIS(boolean ui_m_cover_desc_dis) {
		UI_M_COVER_DESC_DIS = ui_m_cover_desc_dis;
	}

	public boolean isUI_M_PTC_CVR_GRP_CODE_DESC_DIS() {
		return UI_M_PTC_CVR_GRP_CODE_DESC_DIS;
	}

	public void setUI_M_PTC_CVR_GRP_CODE_DESC_DIS(
			boolean ui_m_ptc_cvr_grp_code_desc_dis) {
		UI_M_PTC_CVR_GRP_CODE_DESC_DIS = ui_m_ptc_cvr_grp_code_desc_dis;
	}
	
	/*Added by Janani on 25.01.2018 for ZBLIFE-1468859*/
	
	private String coverType;

	public String getCoverType() {
		return coverType;
	}

	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}
	
	/*End of ZBLIFE-1468859*/
	
}
