package com.iii.pel.forms.PILT083;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="SRST_SWITCHING")
public class SWITCHING extends BaseValueBean {

	
	@Column(name="SW_HDR_SYS_ID")
	 private  Long SW_HDR_SYS_ID ;
	 
	 @Column(name="SW_FM_FUND_NAME")
	 private String	SW_FM_FUND_NAME;   
	 
	 @Column(name="SW_TO_FUND_NAME")
	 private String	SW_TO_FUND_NAME;    
	 
	 @Column(name="SW_FM_FUND_PERC")
	 private Double	SW_FM_FUND_PERC;
	 
	 @Column(name="SW_TO_FUND_PERC")
	 private Double	SW_TO_FUND_PERC;

	public Long getSW_HDR_SYS_ID() {
		return SW_HDR_SYS_ID;
	}

	public void setSW_HDR_SYS_ID(Long sw_hdr_sys_id) {
		SW_HDR_SYS_ID = sw_hdr_sys_id;
	}

	public String getSW_FM_FUND_NAME() {
		return SW_FM_FUND_NAME;
	}

	public void setSW_FM_FUND_NAME(String sw_fm_fund_name) {
		SW_FM_FUND_NAME = sw_fm_fund_name;
	}

	public String getSW_TO_FUND_NAME() {
		return SW_TO_FUND_NAME;
	}

	public void setSW_TO_FUND_NAME(String sw_to_fund_name) {
		SW_TO_FUND_NAME = sw_to_fund_name;
	}

	public Double getSW_FM_FUND_PERC() {
		return SW_FM_FUND_PERC;
	}

	public void setSW_FM_FUND_PERC(Double sw_fm_fund_perc) {
		SW_FM_FUND_PERC = sw_fm_fund_perc;
	}

	public Double getSW_TO_FUND_PERC() {
		return SW_TO_FUND_PERC;
	}

	public void setSW_TO_FUND_PERC(Double sw_to_fund_perc) {
		SW_TO_FUND_PERC = sw_to_fund_perc;
	}

	
}
