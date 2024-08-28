package com.iii.pel.forms.PILT027;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_TOPUP_FUND_DTL")
public class PT_IL_FUND_DETAIL extends BaseValueBean {

	@Column(name = "TOFD_POL_SYS_ID")
	private Integer TOFD_POL_SYS_ID;

	@Column(name = "TOFD_FUND_CODE")
	private String TOFD_FUND_CODE;

	@Column(name = "TOFD_FUND_PERC")
	private Integer TOFD_FUND_PERC;

	@Column(name = "TOFD_CR_DT")
	private Date TOFD_CR_DT;

	@Column(name = "TOFD_CR_UID")
	private String TOFD_CR_UID;

	@Column(name = "TOFD_UPD_DT")
	private Date TOFD_UPD_DT;

	@Column(name = "TOFD_UPD_UID")
	private String TOFD_UPD_UID;

	@Column(name = "TOFD_SYS_ID")
	private Integer TOFD_SYS_ID;

	@Column(name = "TOFD_TU_SYS_ID")
	private Long TOFD_TU_SYS_ID;

	@Column(name = "TOFD_FUND_DIR_TYPE")
	private String TOFD_FUND_DIR_TYPE;

	@Column(name = "TOFD_EFF_FM_DT")
	private Date TOFD_EFF_FM_DT;

	@Column(name = "TOFD_EFF_TO_DT")
	private Date TOFD_EFF_TO_DT;

	private String M_FUND_DESC;

	private String UI_M_FUND_DESC;
	
	
	private Date M_POL_START_DT;

	private Date M_POL_EXPIRY_DT;
	
	private String M_POL_PROD_CODE;
	
	

	public Integer getTOFD_POL_SYS_ID() {
		return TOFD_POL_SYS_ID;
	}

	public void setTOFD_POL_SYS_ID(Integer tofd_pol_sys_id) {
		TOFD_POL_SYS_ID = tofd_pol_sys_id;
	}

	public String getTOFD_FUND_CODE() {
		return TOFD_FUND_CODE;
	}

	public void setTOFD_FUND_CODE(String tofd_fund_code) {
		TOFD_FUND_CODE = tofd_fund_code;
	}

	public Integer getTOFD_FUND_PERC() {
		return TOFD_FUND_PERC;
	}

	public void setTOFD_FUND_PERC(Integer tofd_fund_perc) {
		TOFD_FUND_PERC = tofd_fund_perc;
	}

	public Date getTOFD_CR_DT() {
		return TOFD_CR_DT;
	}

	public void setTOFD_CR_DT(Date tofd_cr_dt) {
		TOFD_CR_DT = tofd_cr_dt;
	}

	public String getTOFD_CR_UID() {
		return TOFD_CR_UID;
	}

	public void setTOFD_CR_UID(String tofd_cr_uid) {
		TOFD_CR_UID = tofd_cr_uid;
	}

	public Date getTOFD_UPD_DT() {
		return TOFD_UPD_DT;
	}

	public void setTOFD_UPD_DT(Date tofd_upd_dt) {
		TOFD_UPD_DT = tofd_upd_dt;
	}

	public String getTOFD_UPD_UID() {
		return TOFD_UPD_UID;
	}

	public void setTOFD_UPD_UID(String tofd_upd_uid) {
		TOFD_UPD_UID = tofd_upd_uid;
	}

	public Integer getTOFD_SYS_ID() {
		return TOFD_SYS_ID;
	}

	public void setTOFD_SYS_ID(Integer tofd_sys_id) {
		TOFD_SYS_ID = tofd_sys_id;
	}

	public Long getTOFD_TU_SYS_ID() {
		return TOFD_TU_SYS_ID;
	}

	public void setTOFD_TU_SYS_ID(Long tofd_tu_sys_id) {
		TOFD_TU_SYS_ID = tofd_tu_sys_id;
	}

	public String getTOFD_FUND_DIR_TYPE() {
		return TOFD_FUND_DIR_TYPE;
	}

	public void setTOFD_FUND_DIR_TYPE(String tofd_fund_dir_type) {
		TOFD_FUND_DIR_TYPE = tofd_fund_dir_type;
	}

	public Date getTOFD_EFF_FM_DT() {
		return TOFD_EFF_FM_DT;
	}

	public void setTOFD_EFF_FM_DT(Date tofd_eff_fm_dt) {
		TOFD_EFF_FM_DT = tofd_eff_fm_dt;
	}

	public Date getTOFD_EFF_TO_DT() {
		return TOFD_EFF_TO_DT;
	}

	public void setTOFD_EFF_TO_DT(Date tofd_eff_to_dt) {
		TOFD_EFF_TO_DT = tofd_eff_to_dt;
	}

	public String getM_FUND_DESC() {
		return M_FUND_DESC;
	}

	public void setM_FUND_DESC(String m_fund_desc) {
		M_FUND_DESC = m_fund_desc;
	}

	public String getUI_M_FUND_DESC() {
		return UI_M_FUND_DESC;
	}

	public void setUI_M_FUND_DESC(String ui_m_fund_desc) {
		UI_M_FUND_DESC = ui_m_fund_desc;
	}

	public Date getM_POL_START_DT() {
		return M_POL_START_DT;
	}

	public void setM_POL_START_DT(Date m_pol_start_dt) {
		M_POL_START_DT = m_pol_start_dt;
	}

	public Date getM_POL_EXPIRY_DT() {
		return M_POL_EXPIRY_DT;
	}

	public void setM_POL_EXPIRY_DT(Date m_pol_expiry_dt) {
		M_POL_EXPIRY_DT = m_pol_expiry_dt;
	}

	public String getM_POL_PROD_CODE() {
		return M_POL_PROD_CODE;
	}

	public void setM_POL_PROD_CODE(String m_pol_prod_code) {
		M_POL_PROD_CODE = m_pol_prod_code;
	}

}
