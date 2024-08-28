package com.iii.pel.forms.PILP080;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_MED_VOUC_LOG")
public class PT_IL_MED_VOUC_LOG extends BaseValueBean {
	@Column(name="PMV_CLINIC_CODE")
	private String PMV_CLINIC_CODE ;
	@Column(name="PMV_PROD_CODE")
	private  String PMV_PROD_CODE  ;
	@Column(name="PMV_PROC_DT")
	private  Date PMV_PROC_DT ; 
	@Column(name="PMV_PMH_SYS_ID")
	private  Long PMV_PMH_SYS_ID;
	@Column(name="PMV_ERR_DESC")
	private String PMV_ERR_DESC;
	public String getPMV_CLINIC_CODE() {
		return PMV_CLINIC_CODE;
	}
	public void setPMV_CLINIC_CODE(String pmv_clinic_code) {
		PMV_CLINIC_CODE = pmv_clinic_code;
	}
	public String getPMV_PROD_CODE() {
		return PMV_PROD_CODE;
	}
	public void setPMV_PROD_CODE(String pmv_prod_code) {
		PMV_PROD_CODE = pmv_prod_code;
	}
	public Date getPMV_PROC_DT() {
		return PMV_PROC_DT;
	}
	public void setPMV_PROC_DT(Date pmv_proc_dt) {
		PMV_PROC_DT = pmv_proc_dt;
	}
	public Long getPMV_PMH_SYS_ID() {
		return PMV_PMH_SYS_ID;
	}
	public void setPMV_PMH_SYS_ID(Long pmv_pmh_sys_id) {
		PMV_PMH_SYS_ID = pmv_pmh_sys_id;
	}
	public String getPMV_ERR_DESC() {
		return PMV_ERR_DESC;
	}
	public void setPMV_ERR_DESC(String pmv_err_desc) {
		PMV_ERR_DESC = pmv_err_desc;
	}   
}

