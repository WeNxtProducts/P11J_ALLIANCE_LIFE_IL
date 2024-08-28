package com.iii.pel.forms.PILP022;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
/**
 * 
 * @author 52017
 * New Bean Created For PREMIAGDC-327842
 *
 */
@Table(name="PS_AGENT_COMM_VALUES")
public class PS_AGENT_COMM_VALUES {
	
	@Column(name="PS_DATE")
	private Date PS_DATE;
	
	@Column(name="PS_POL_NO")
	private String PS_POL_NO;
	
	@Column(name="PS_END_NO_IDX")
	private Long  PS_END_NO_IDX;
	
	@Column(name="PS_POL_END_CODE")
	private String  PS_POL_END_CODE;
	
	@Column(name="PS_POL_COVER_CODE")
	private  String  PS_POL_COVER_CODE;
	
	@Column(name="PS_POL_COVER_DESC")
	private String PS_POL_COVER_DESC;
	
	@Column(name="PS_POL_ASSURED_NAME")
	private String PS_POL_ASSURED_NAME; 
	
	@Column(name="PS_POL_COMM_PREM_LC_AMT")
	private Double PS_POL_COMM_PREM_LC_AMT;
	
	@Column(name="PS_AGENT_CODE")
	private String  PS_AGENT_CODE;
	
	@Column(name="PS_AGENT_RANK_CODE")
	private String PS_AGENT_RANK_CODE;
	
	@Column(name="PS_POL_COMM_TYPE")
	private String PS_POL_COMM_TYPE;
	
	@Column(name="PS_LC_AMT")
	private Double PS_LC_AMT;

	public Date getPS_DATE() {
		return PS_DATE;
	}

	public void setPS_DATE(Date ps_date) {
		PS_DATE = ps_date;
	}

	public String getPS_POL_NO() {
		return PS_POL_NO;
	}

	public void setPS_POL_NO(String ps_pol_no) {
		PS_POL_NO = ps_pol_no;
	}

	public Long getPS_END_NO_IDX() {
		return PS_END_NO_IDX;
	}

	public void setPS_END_NO_IDX(Long ps_end_no_idx) {
		PS_END_NO_IDX = ps_end_no_idx;
	}

	public String getPS_POL_END_CODE() {
		return PS_POL_END_CODE;
	}

	public void setPS_POL_END_CODE(String ps_pol_end_code) {
		PS_POL_END_CODE = ps_pol_end_code;
	}

	public String getPS_POL_COVER_DESC() {
		return PS_POL_COVER_DESC;
	}

	public void setPS_POL_COVER_DESC(String ps_pol_cover_desc) {
		PS_POL_COVER_DESC = ps_pol_cover_desc;
	}

	public String getPS_POL_ASSURED_NAME() {
		return PS_POL_ASSURED_NAME;
	}

	public void setPS_POL_ASSURED_NAME(String ps_pol_assured_name) {
		PS_POL_ASSURED_NAME = ps_pol_assured_name;
	}

	public Double getPS_POL_COMM_PREM_LC_AMT() {
		return PS_POL_COMM_PREM_LC_AMT;
	}

	public void setPS_POL_COMM_PREM_LC_AMT(Double ps_pol_comm_prem_lc_amt) {
		PS_POL_COMM_PREM_LC_AMT = ps_pol_comm_prem_lc_amt;
	}

	public String getPS_AGENT_CODE() {
		return PS_AGENT_CODE;
	}

	public void setPS_AGENT_CODE(String ps_agent_code) {
		PS_AGENT_CODE = ps_agent_code;
	}

	public String getPS_AGENT_RANK_CODE() {
		return PS_AGENT_RANK_CODE;
	}

	public void setPS_AGENT_RANK_CODE(String ps_agent_rank_code) {
		PS_AGENT_RANK_CODE = ps_agent_rank_code;
	}

	public String getPS_POL_COMM_TYPE() {
		return PS_POL_COMM_TYPE;
	}

	public void setPS_POL_COMM_TYPE(String ps_pol_comm_type) {
		PS_POL_COMM_TYPE = ps_pol_comm_type;
	}

	public Double getPS_LC_AMT() {
		return PS_LC_AMT;
	}

	public void setPS_LC_AMT(Double ps_lc_amt) {
		PS_LC_AMT = ps_lc_amt;
	}

	public String getPS_POL_COVER_CODE() {
		return PS_POL_COVER_CODE;
	}

	public void setPS_POL_COVER_CODE(String ps_pol_cover_code) {
		PS_POL_COVER_CODE = ps_pol_cover_code;
	} 
	
	
	

}
