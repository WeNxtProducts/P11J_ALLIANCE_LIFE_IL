package com.iii.pel.forms.PILT009;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_FAC_DETL")
public class PT_IL_FAC_DETL extends BaseValueBean {

	@Column(name="FD_SYS_ID")
	private Double FD_SYS_ID;
	
	@Column(name="FD_FO_SYS_ID")
	private Double FD_FO_SYS_ID;
	
	@Column(name="FD_SCHD_PYMT_DT")
	private Date FD_SCHD_PYMT_DT;
	
	@Column(name="FD_YEAR")
	private int FD_YEAR;

	@Column(name="FD_ASSURED_AGE")
	private int FD_ASSURED_AGE;

	@Column(name="FD_TAR_RATE")
	private Double FD_TAR_RATE;

	@Column(name="FD_FC_SA")
	private Double FD_FC_SA;

	@Column(name="FD_LC_SA")
	private Double FD_LC_SA;

	@Column(name="FD_FC_PREM")
	private Double FD_FC_PREM;

	@Column(name="FD_LC_PREM")
	private Double FD_LC_PREM;
	
	@Column(name="FD_FC_FAC_SA")
	private Double FD_FC_FAC_SA;

	@Column(name="FD_LC_FAC_SA")
	private Double FD_LC_FAC_SA;
	
	@Column(name="FD_FC_FAC_PREM")
	private Double FD_FC_FAC_PREM;
	
	@Column(name="FD_LC_FAC_PREM")
	private Double FD_LC_FAC_PREM;
	
	@Column(name="FD_FAC_CLOSE_YN")
	private String FD_FAC_CLOSE_YN;
	
	@Column(name="FD_DEL_FLAG")
	private String FD_DEL_FLAG;
	
	@Column(name="FD_CR_DT")
	private Date FD_CR_DT;
	
	@Column(name="FD_CR_UID")
	private String FD_CR_UID;
	
	@Column(name="FD_TAR_RATE_PER")
	private Double FD_TAR_RATE_PER;
	
	@Column(name="FD_PC_SYS_ID")
	private Double FD_PC_SYS_ID;
	
	@Column(name="FD_FC_EXTRA_PREM")
	private Double FD_FC_EXTRA_PREM;
	
	@Column(name="FD_LC_EXTRA_PREM")
	private Double FD_LC_EXTRA_PREM;
	
	@Column(name="FD_FC_FAC_GRS_PREM")
	private Double FD_FC_FAC_GRS_PREM;
	
	@Column(name="FD_LC_FAC_GRS_PREM")
	private Double FD_LC_FAC_GRS_PREM;
	
	@Column(name="FD_APPRV_UID")
	private String FD_APPRV_UID;
	
	@Column(name="FD_APPRV_DT")
	private Date FD_APPRV_DT;
	
	private boolean CHECK_BOX;
	
	
	private String UI_COVER_CODE;
	
	
	private String UI_M_COVER_DESC;

	public String getUI_COVER_CODE() {
		return UI_COVER_CODE;
	}

	public void setUI_COVER_CODE(String ui_cover_code) {
		UI_COVER_CODE = ui_cover_code;
	}

	public String getUI_M_COVER_DESC() {
		return UI_M_COVER_DESC;
	}

	public void setUI_M_COVER_DESC(String ui_m_cover_desc) {
		UI_M_COVER_DESC = ui_m_cover_desc;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getFD_SYS_ID() {
		return FD_SYS_ID;
	}

	public void setFD_SYS_ID(Double fd_sys_id) {
		FD_SYS_ID = fd_sys_id;
	}

	public Double getFD_FO_SYS_ID() {
		return FD_FO_SYS_ID;
	}

	public void setFD_FO_SYS_ID(Double fd_fo_sys_id) {
		FD_FO_SYS_ID = fd_fo_sys_id;
	}

	public Date getFD_SCHD_PYMT_DT() {
		return FD_SCHD_PYMT_DT;
	}

	public void setFD_SCHD_PYMT_DT(Date fd_schd_pymt_dt) {
		FD_SCHD_PYMT_DT = fd_schd_pymt_dt;
	}

	public int getFD_YEAR() {
		return FD_YEAR;
	}

	public void setFD_YEAR(int fd_year) {
		FD_YEAR = fd_year;
	}

	public int getFD_ASSURED_AGE() {
		return FD_ASSURED_AGE;
	}

	public void setFD_ASSURED_AGE(int fd_assured_age) {
		FD_ASSURED_AGE = fd_assured_age;
	}

	public Double getFD_TAR_RATE() {
		return FD_TAR_RATE;
	}

	public void setFD_TAR_RATE(Double fd_tar_rate) {
		FD_TAR_RATE = fd_tar_rate;
	}

	public Double getFD_FC_SA() {
		return FD_FC_SA;
	}

	public void setFD_FC_SA(Double fd_fc_sa) {
		FD_FC_SA = fd_fc_sa;
	}

	public Double getFD_LC_SA() {
		return FD_LC_SA;
	}

	public void setFD_LC_SA(Double fd_lc_sa) {
		FD_LC_SA = fd_lc_sa;
	}

	public Double getFD_FC_PREM() {
		return FD_FC_PREM;
	}

	public void setFD_FC_PREM(Double fd_fc_prem) {
		FD_FC_PREM = fd_fc_prem;
	}

	public Double getFD_LC_PREM() {
		return FD_LC_PREM;
	}

	public void setFD_LC_PREM(Double fd_lc_prem) {
		FD_LC_PREM = fd_lc_prem;
	}

	public Double getFD_FC_FAC_SA() {
		return FD_FC_FAC_SA;
	}

	public void setFD_FC_FAC_SA(Double fd_fc_fac_sa) {
		FD_FC_FAC_SA = fd_fc_fac_sa;
	}

	public Double getFD_LC_FAC_SA() {
		return FD_LC_FAC_SA;
	}

	public void setFD_LC_FAC_SA(Double fd_lc_fac_sa) {
		FD_LC_FAC_SA = fd_lc_fac_sa;
	}

	public Double getFD_FC_FAC_PREM() {
		return FD_FC_FAC_PREM;
	}

	public void setFD_FC_FAC_PREM(Double fd_fc_fac_prem) {
		FD_FC_FAC_PREM = fd_fc_fac_prem;
	}

	public Double getFD_LC_FAC_PREM() {
		return FD_LC_FAC_PREM;
	}

	public void setFD_LC_FAC_PREM(Double fd_lc_fac_prem) {
		FD_LC_FAC_PREM = fd_lc_fac_prem;
	}

	public String getFD_FAC_CLOSE_YN() {
		return FD_FAC_CLOSE_YN;
	}

	public void setFD_FAC_CLOSE_YN(String fd_fac_close_yn) {
		FD_FAC_CLOSE_YN = fd_fac_close_yn;
	}

	public String getFD_DEL_FLAG() {
		return FD_DEL_FLAG;
	}

	public void setFD_DEL_FLAG(String fd_del_flag) {
		FD_DEL_FLAG = fd_del_flag;
	}

	public Date getFD_CR_DT() {
		return FD_CR_DT;
	}

	public void setFD_CR_DT(Date fd_cr_dt) {
		FD_CR_DT = fd_cr_dt;
	}

	public String getFD_CR_UID() {
		return FD_CR_UID;
	}

	public void setFD_CR_UID(String fd_cr_uid) {
		FD_CR_UID = fd_cr_uid;
	}

	public Double getFD_TAR_RATE_PER() {
		return FD_TAR_RATE_PER;
	}

	public void setFD_TAR_RATE_PER(Double fd_tar_rate_per) {
		FD_TAR_RATE_PER = fd_tar_rate_per;
	}

	public Double getFD_PC_SYS_ID() {
		return FD_PC_SYS_ID;
	}

	public void setFD_PC_SYS_ID(Double fd_pc_sys_id) {
		FD_PC_SYS_ID = fd_pc_sys_id;
	}

	public Double getFD_FC_EXTRA_PREM() {
		return FD_FC_EXTRA_PREM;
	}

	public void setFD_FC_EXTRA_PREM(Double fd_fc_extra_prem) {
		FD_FC_EXTRA_PREM = fd_fc_extra_prem;
	}

	public Double getFD_LC_EXTRA_PREM() {
		return FD_LC_EXTRA_PREM;
	}

	public void setFD_LC_EXTRA_PREM(Double fd_lc_extra_prem) {
		FD_LC_EXTRA_PREM = fd_lc_extra_prem;
	}

	public Double getFD_FC_FAC_GRS_PREM() {
		return FD_FC_FAC_GRS_PREM;
	}

	public void setFD_FC_FAC_GRS_PREM(Double fd_fc_fac_grs_prem) {
		FD_FC_FAC_GRS_PREM = fd_fc_fac_grs_prem;
	}

	public Double getFD_LC_FAC_GRS_PREM() {
		return FD_LC_FAC_GRS_PREM;
	}

	public void setFD_LC_FAC_GRS_PREM(Double fd_lc_fac_grs_prem) {
		FD_LC_FAC_GRS_PREM = fd_lc_fac_grs_prem;
	}

	public String getFD_APPRV_UID() {
		return FD_APPRV_UID;
	}

	public void setFD_APPRV_UID(String fd_apprv_uid) {
		FD_APPRV_UID = fd_apprv_uid;
	}

	public Date getFD_APPRV_DT() {
		return FD_APPRV_DT;
	}

	public void setFD_APPRV_DT(Date fd_apprv_dt) {
		FD_APPRV_DT = fd_apprv_dt;
	}
	
}
