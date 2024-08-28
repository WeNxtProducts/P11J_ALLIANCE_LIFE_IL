package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_SA_INST_PYMT_HEAD")
public class PT_IL_POL_SA_INST_PYMT_HEAD extends BaseValueBean {
	
	@Column(name="SIPH_MAT_AGE")
	private Integer SIPH_MAT_AGE;
	
	@Column(name="SIPH_SYS_ID")
	private Long SIPH_SYS_ID;
	
	@Column(name="SIPH_POL_SYS_ID")
	private Long SIPH_POL_SYS_ID;
	
	@Column(name="SIPH_PLAN_CODE")
	private String SIPH_PLAN_CODE;
	
	@Column(name="SIPH_PROD_CODE")
	private String SIPH_PROD_CODE;
	
	@Column(name="SIPH_PROD_MAT_AMT_TYPE")
	private String SIPH_PROD_MAT_AMT_TYPE;                                                                                                                                                                                    
	                                                                                                                                                                               
	@Column(name="SIPH_NAV_TYPE")
	private String SIPH_NAV_TYPE;                                                                                                                                                                                    
	                                                                                                                                                                              
	@Column(name="SIPH_PROD_MAT_RATE")
	private Double SIPH_PROD_MAT_RATE;                                                                                                                                                                                 
	                                                                                                                                                                                   
	@Column(name="SIPH_PROD_MAT_RATE_PER")
	private Double SIPH_PROD_MAT_RATE_PER;                                                                                                                                                                                    
	                                                                                                                                                                                   
	@Column(name="SIPH_PROD_SURR_PLUS_FACTOR")
	private String SIPH_PROD_SURR_PLUS_FACTOR;    

	@Column(name="SIPH_PERC")
	private Double SIPH_PERC;                                                                                                                                                                                    
	                                                                                                                                                                                                                          
	@Column(name="SIPH_NUMR_PERIOD")
	private Double SIPH_NUMR_PERIOD;                                                                                                                                                                                      
	     
	@Column(name="SIPH_DEMR_PERIOD")
	private Double SIPH_DEMR_PERIOD; 
	
	@Column(name="SIPH_REMARKS")
	private String SIPH_REMARKS;    
	 
	@Column(name="SIPH_BL_REMARKS")
	private String SIPH_BL_REMARKS;    
	
	@Column(name="SIPH_CR_UID")
	private String SIPH_CR_UID;   
	
	@Column(name="SIPH_UPD_UID")
	private String SIPH_UPD_UID; 
	
	@Column(name="SIPH_CR_DT")
	private Date SIPH_CR_DT;
	
	@Column(name="SIPH_UPD_DT")
	private Date SIPH_UPD_DT;

	
	private String UI_M_PT_SID_FACTOR_DESC;
	
	public String getUI_M_PT_SID_FACTOR_DESC() {
		return UI_M_PT_SID_FACTOR_DESC;
	}

	public void setUI_M_PT_SID_FACTOR_DESC(String ui_m_pt_sid_factor_desc) {
		UI_M_PT_SID_FACTOR_DESC = ui_m_pt_sid_factor_desc;
	}

	public Integer getSIPH_MAT_AGE() {
		return SIPH_MAT_AGE;
	}

	public void setSIPH_MAT_AGE(Integer siph_mat_age) {
		SIPH_MAT_AGE = siph_mat_age;
	}

	public Long getSIPH_SYS_ID() {
		return SIPH_SYS_ID;
	}

	public void setSIPH_SYS_ID(Long siph_sys_id) {
		SIPH_SYS_ID = siph_sys_id;
	}

	public Long getSIPH_POL_SYS_ID() {
		return SIPH_POL_SYS_ID;
	}

	public void setSIPH_POL_SYS_ID(Long siph_pol_sys_id) {
		SIPH_POL_SYS_ID = siph_pol_sys_id;
	}

	public String getSIPH_PLAN_CODE() {
		return SIPH_PLAN_CODE;
	}

	public void setSIPH_PLAN_CODE(String siph_plan_code) {
		SIPH_PLAN_CODE = siph_plan_code;
	}

	public String getSIPH_PROD_CODE() {
		return SIPH_PROD_CODE;
	}

	public void setSIPH_PROD_CODE(String siph_prod_code) {
		SIPH_PROD_CODE = siph_prod_code;
	}

	public String getSIPH_PROD_MAT_AMT_TYPE() {
		return SIPH_PROD_MAT_AMT_TYPE;
	}

	public void setSIPH_PROD_MAT_AMT_TYPE(String siph_prod_mat_amt_type) {
		SIPH_PROD_MAT_AMT_TYPE = siph_prod_mat_amt_type;
	}

	public String getSIPH_NAV_TYPE() {
		return SIPH_NAV_TYPE;
	}

	public void setSIPH_NAV_TYPE(String siph_nav_type) {
		SIPH_NAV_TYPE = siph_nav_type;
	}

	public Double getSIPH_PROD_MAT_RATE() {
		return SIPH_PROD_MAT_RATE;
	}

	public void setSIPH_PROD_MAT_RATE(Double siph_prod_mat_rate) {
		SIPH_PROD_MAT_RATE = siph_prod_mat_rate;
	}

	public Double getSIPH_PROD_MAT_RATE_PER() {
		return SIPH_PROD_MAT_RATE_PER;
	}

	public void setSIPH_PROD_MAT_RATE_PER(Double siph_prod_mat_rate_per) {
		SIPH_PROD_MAT_RATE_PER = siph_prod_mat_rate_per;
	}

	public String getSIPH_PROD_SURR_PLUS_FACTOR() {
		return SIPH_PROD_SURR_PLUS_FACTOR;
	}

	public void setSIPH_PROD_SURR_PLUS_FACTOR(String siph_prod_surr_plus_factor) {
		SIPH_PROD_SURR_PLUS_FACTOR = siph_prod_surr_plus_factor;
	}

	public Double getSIPH_PERC() {
		return SIPH_PERC;
	}

	public void setSIPH_PERC(Double siph_perc) {
		SIPH_PERC = siph_perc;
	}

	public Double getSIPH_NUMR_PERIOD() {
		return SIPH_NUMR_PERIOD;
	}

	public void setSIPH_NUMR_PERIOD(Double siph_numr_period) {
		SIPH_NUMR_PERIOD = siph_numr_period;
	}

	public Double getSIPH_DEMR_PERIOD() {
		return SIPH_DEMR_PERIOD;
	}

	public void setSIPH_DEMR_PERIOD(Double siph_demr_period) {
		SIPH_DEMR_PERIOD = siph_demr_period;
	}

	public String getSIPH_REMARKS() {
		return SIPH_REMARKS;
	}

	public void setSIPH_REMARKS(String siph_remarks) {
		SIPH_REMARKS = siph_remarks;
	}

	public String getSIPH_BL_REMARKS() {
		return SIPH_BL_REMARKS;
	}

	public void setSIPH_BL_REMARKS(String siph_bl_remarks) {
		SIPH_BL_REMARKS = siph_bl_remarks;
	}

	public String getSIPH_CR_UID() {
		return SIPH_CR_UID;
	}

	public void setSIPH_CR_UID(String siph_cr_uid) {
		SIPH_CR_UID = siph_cr_uid;
	}

	public String getSIPH_UPD_UID() {
		return SIPH_UPD_UID;
	}

	public void setSIPH_UPD_UID(String siph_upd_uid) {
		SIPH_UPD_UID = siph_upd_uid;
	}

	public Date getSIPH_CR_DT() {
		return SIPH_CR_DT;
	}

	public void setSIPH_CR_DT(Date siph_cr_dt) {
		SIPH_CR_DT = siph_cr_dt;
	}

	public Date getSIPH_UPD_DT() {
		return SIPH_UPD_DT;
	}

	public void setSIPH_UPD_DT(Date siph_upd_dt) {
		SIPH_UPD_DT = siph_upd_dt;
	}
	
}
