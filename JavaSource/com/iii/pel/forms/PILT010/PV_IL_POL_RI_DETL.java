package com.iii.pel.forms.PILT010;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PV_IL_POL_RI_DETL")
public class PV_IL_POL_RI_DETL extends BaseValueBean {

		private String UI_RI_CLOSE;
	
	@Column(name="RD_POL_NO")
	private String RD_POL_NO;

	@Column(name="RD_END_NO")
	private String RD_END_NO;

	@Column(name="RD_YEAR")
	private Integer RD_YEAR;

	@Column(name="POL_CLASS_CODE")
	private String POL_CLASS_CODE;

	@Column(name="POL_PROD_CODE")
	private String POL_PROD_CODE;

	@Column(name="RD_UW_YEAR")
	private Integer RD_UW_YEAR;

	@Column(name="POL_PERIOD")
	private Integer POL_PERIOD;

	@Column(name="POL_CONT_CODE")
	private String POL_CONT_CODE;

	@Column(name="POL_START_DT")
	private Date POL_START_DT;

	@Column(name="POL_EXPIRY_DT")
	private Date POL_EXPIRY_DT;

	private String UI_M_PT_IL_RI_DETL_CF;
	
	private String UI_M_PT_IL_RI_PREM_ALLOC_CF;
	
    private String UI_M_PV_IL_POL_RI_DETL_CF;
    
    @Column(name="RD_POL_SYS_ID")
    private Long RD_POL_SYS_ID;
    
    @Column(name="RD_END_NO_IDX")
    private Integer RD_END_NO_IDX;
    
    private String UI_M_USER_CALC_YN;
    
    private Integer UI_M_PC_SYS_ID;
    
    private String UI_M_ERR_FLAG;
    
    private Integer UI_M_PT_CURR_RATE;
    
    private String UI_M_PT_CURR_CODE;
    
    private int DB_POL_COUNT;

	public String getRD_POL_NO() {
		return RD_POL_NO;
	}

	public void setRD_POL_NO(String RD_POL_NO) {
		this.RD_POL_NO = RD_POL_NO;
	}

	public String getRD_END_NO() {
		return RD_END_NO;
	}

	public void setRD_END_NO(String RD_END_NO) {
		this.RD_END_NO = RD_END_NO;
	}

	public Integer getRD_YEAR() {
		return RD_YEAR;
	}

	public void setRD_YEAR(Integer RD_YEAR) {
		this.RD_YEAR = RD_YEAR;
	}

	public String getPOL_CLASS_CODE() {
		return POL_CLASS_CODE;
	}

	public void setPOL_CLASS_CODE(String POL_CLASS_CODE) {
		this.POL_CLASS_CODE = POL_CLASS_CODE;
	}

	public String getPOL_PROD_CODE() {
		return POL_PROD_CODE;
	}

	public void setPOL_PROD_CODE(String POL_PROD_CODE) {
		this.POL_PROD_CODE = POL_PROD_CODE;
	}

	public Integer getRD_UW_YEAR() {
		return RD_UW_YEAR;
	}

	public void setRD_UW_YEAR(Integer RD_UW_YEAR) {
		this.RD_UW_YEAR = RD_UW_YEAR;
	}

	public Integer getPOL_PERIOD() {
		return POL_PERIOD;
	}

	public void setPOL_PERIOD(Integer POL_PERIOD) {
		this.POL_PERIOD = POL_PERIOD;
	}

	public String getPOL_CONT_CODE() {
		return POL_CONT_CODE;
	}

	public void setPOL_CONT_CODE(String POL_CONT_CODE) {
		this.POL_CONT_CODE = POL_CONT_CODE;
	}

	public Date getPOL_START_DT() {
		 return POL_START_DT;
	}

	public void setPOL_START_DT(Date POL_START_DT) {
		this.POL_START_DT = POL_START_DT;
	}

	public Date getPOL_EXPIRY_DT() {
		 return POL_EXPIRY_DT;
	}

	public void setPOL_EXPIRY_DT(Date POL_EXPIRY_DT) {
		this.POL_EXPIRY_DT = POL_EXPIRY_DT;
	}

	public String getUI_M_PT_IL_RI_DETL_CF() {
		return UI_M_PT_IL_RI_DETL_CF;
	}

	public void setUI_M_PT_IL_RI_DETL_CF(String ui_m_pt_il_ri_detl_cf) {
		UI_M_PT_IL_RI_DETL_CF = ui_m_pt_il_ri_detl_cf;
	}

	public String getUI_M_PT_IL_RI_PREM_ALLOC_CF() {
		return UI_M_PT_IL_RI_PREM_ALLOC_CF;
	}

	public void setUI_M_PT_IL_RI_PREM_ALLOC_CF(String ui_m_pt_il_ri_prem_alloc_cf) {
		UI_M_PT_IL_RI_PREM_ALLOC_CF = ui_m_pt_il_ri_prem_alloc_cf;
	}

	public String getUI_M_PV_IL_POL_RI_DETL_CF() {
		return UI_M_PV_IL_POL_RI_DETL_CF;
	}

	public void setUI_M_PV_IL_POL_RI_DETL_CF(String ui_m_pv_il_pol_ri_detl_cf) {
		UI_M_PV_IL_POL_RI_DETL_CF = ui_m_pv_il_pol_ri_detl_cf;
	}

	
	public Long getRD_POL_SYS_ID() {
		return RD_POL_SYS_ID;
	}

	public void setRD_POL_SYS_ID(Long rd_pol_sys_id) {
		RD_POL_SYS_ID = rd_pol_sys_id;
	}

	public Integer getRD_END_NO_IDX() {
		return RD_END_NO_IDX;
	}

	public void setRD_END_NO_IDX(Integer rd_end_no_idx) {
		RD_END_NO_IDX = rd_end_no_idx;
	}

	public String getUI_M_USER_CALC_YN() {
		return UI_M_USER_CALC_YN;
	}

	public void setUI_M_USER_CALC_YN(String ui_m_user_calc_yn) {
		UI_M_USER_CALC_YN = ui_m_user_calc_yn;
	}

	public Integer getUI_M_PC_SYS_ID() {
		return UI_M_PC_SYS_ID;
	}

	public void setUI_M_PC_SYS_ID(Integer ui_m_pc_sys_id) {
		UI_M_PC_SYS_ID = ui_m_pc_sys_id;
	}

	public String getUI_M_ERR_FLAG() {
		return UI_M_ERR_FLAG;
	}

	public void setUI_M_ERR_FLAG(String ui_m_err_flag) {
		UI_M_ERR_FLAG = ui_m_err_flag;
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

	public int getDB_POL_COUNT() {
		return DB_POL_COUNT;
	}

	public void setDB_POL_COUNT(int db_pol_count) {
		DB_POL_COUNT = db_pol_count;
	}



	public String getUI_RI_CLOSE() {
		return UI_RI_CLOSE;
	}

	public void setUI_RI_CLOSE(String ui_ri_close) {
		UI_RI_CLOSE = ui_ri_close;
	}
}
