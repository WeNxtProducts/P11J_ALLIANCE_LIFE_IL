package com.iii.pel.forms.PW_PAYING_SLIP_DTLS;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.ReportUtils;
@Table(name= "PW_PAYING_SLIP_DTLS")
public class PW_PAYING_SLIP_DTLS_BEAN extends BaseValueBean{
	
	@Column(name = "ROWID")
	private String ROWID;
	
	@Column(name = "PSL_HDR_SYS_ID")
	private Long PSL_HDR_SYS_ID;
	
	@Column(name = "PSL_SYS_ID")
	private Long PSL_SYS_ID;
	
	@Column(name="PSL_CHK_NO")
	private Long PSL_CHK_NO;
	
	@Column(name= "PSL_CHK_DATE")
	private Date PSL_CHK_DATE;
	
	@Column(name="PSL_CHK_AMT")
	private Double PSL_CHK_AMT;
	
	@Column(name="PSL_BANK_NAME")
	private String PSL_BANK_NAME;
	
	@Column(name="PSL_BANK_LOC")
	private String PSL_BANK_LOC;
	
	@Column(name="PSL_CHK_TYPE")
	private String PSL_CHK_TYPE;
	
	@Column(name="PSL_BANK_CITY")
	private String PSL_BANK_CITY;

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public Long getPSL_SYS_ID() {
		return PSL_SYS_ID;
	}

	public void setPSL_SYS_ID(Long psl_sys_id) {
		PSL_SYS_ID = psl_sys_id;
	}

	public Long getPSL_CHK_NO() {
		return PSL_CHK_NO;
	}

	public void setPSL_CHK_NO(Long psl_chk_no) {
		PSL_CHK_NO = psl_chk_no;
	}

	public Date getPSL_CHK_DATE() {
		return PSL_CHK_DATE;
	}

	public void setPSL_CHK_DATE(Date psl_chk_date) {
		PSL_CHK_DATE = psl_chk_date;
	}

	public Double getPSL_CHK_AMT() {
		return PSL_CHK_AMT;
	}

	public void setPSL_CHK_AMT(Double psl_chk_amt) {
		PSL_CHK_AMT = psl_chk_amt;
	}

	public String getPSL_BANK_NAME() {
		return PSL_BANK_NAME;
	}

	public void setPSL_BANK_NAME(String psl_bank_name) {
		PSL_BANK_NAME = psl_bank_name;
	}

	public String getPSL_BANK_LOC() {
		return PSL_BANK_LOC;
	}

	public void setPSL_BANK_LOC(String psl_bank_loc) {
		PSL_BANK_LOC = psl_bank_loc;
	}

	public String getPSL_CHK_TYPE() {
		return PSL_CHK_TYPE;
	}

	public void setPSL_CHK_TYPE(String psl_chk_type) {
		PSL_CHK_TYPE = psl_chk_type;
	}

	public Long getPSL_HDR_SYS_ID() {
		return PSL_HDR_SYS_ID;
	}

	public void setPSL_HDR_SYS_ID(Long psl_hdr_sys_id) {
		PSL_HDR_SYS_ID = psl_hdr_sys_id;
	}

	public String getPSL_BANK_CITY() {
		return PSL_BANK_CITY;
	}

	public void setPSL_BANK_CITY(String psl_bank_city) {
		PSL_BANK_CITY = psl_bank_city;
	}
	
	
	

}
