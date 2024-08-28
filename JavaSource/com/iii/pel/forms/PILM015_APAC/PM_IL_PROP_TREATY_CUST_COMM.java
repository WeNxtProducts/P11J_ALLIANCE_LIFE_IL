package com.iii.pel.forms.PILM015_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PROP_TREATY_CUST_COMM")
public class PM_IL_PROP_TREATY_CUST_COMM  extends BaseValueBean{
	
	@Column(name = "PTCC_YEAR_FM")
	private int PTCC_YEAR_FM;
	
	@Column(name = "PTCC_YEAR_TO")
	private int PTCC_YEAR_TO;
	
	
	@Column(name = "PTCC_STD_PERC")
	private Double PTCC_STD_PERC;
	
	@Column(name = "PTCC_SSTD_PERC")
	private Double PTCC_SSTD_PERC;

	@Column(name = "PTCC_SYS_ID")
	private Long PTCC_SYS_ID;
	
	

	@Column(name = "PTCC_PTPC_SYS_ID")
	private double PTCC_PTPC_SYS_ID;
	
	@Column(name = "PTCC_CR_DT")
	private Date PTCC_CR_DT;
	
	@Column(name = "PTCC_CR_UID")
	private String PTCC_CR_UID;
	
	@Column(name = "PTCC_UPD_DT")
	private Date PTCC_UPD_DT;
	
	
	@Column(name = "PTCC_UPD_UID")
	private String PTCC_UPD_UID;
	
	public int getPTCC_YEAR_FM() {
		return PTCC_YEAR_FM;
	}

	public void setPTCC_YEAR_FM(int pTCC_YEAR_FM) {
		PTCC_YEAR_FM = pTCC_YEAR_FM;
	}

	public int getPTCC_YEAR_TO() {
		return PTCC_YEAR_TO;
	}

	public void setPTCC_YEAR_TO(int pTCC_YEAR_TO) {
		PTCC_YEAR_TO = pTCC_YEAR_TO;
	}

	public Double getPTCC_STD_PERC() {
		return PTCC_STD_PERC;
	}

	public void setPTCC_STD_PERC(Double pTCC_STD_PERC) {
		PTCC_STD_PERC = pTCC_STD_PERC;
	}

	public Long getPTCC_SYS_ID() {
		return PTCC_SYS_ID;
	}

	public void setPTCC_SYS_ID(Long pTCC_SYS_ID) {
		PTCC_SYS_ID = pTCC_SYS_ID;
	}

	

	public double getPTCC_PTPC_SYS_ID() {
		return PTCC_PTPC_SYS_ID;
	}

	public void setPTCC_PTPC_SYS_ID(double pTCC_PTPC_SYS_ID) {
		PTCC_PTPC_SYS_ID = pTCC_PTPC_SYS_ID;
	}

	public Date getPTCC_CR_DT() {
		return PTCC_CR_DT;
	}

	public void setPTCC_CR_DT(Date pTCC_CR_DT) {
		PTCC_CR_DT = pTCC_CR_DT;
	}

	public String getPTCC_CR_UID() {
		return PTCC_CR_UID;
	}

	public void setPTCC_CR_UID(String pTCC_CR_UID) {
		PTCC_CR_UID = pTCC_CR_UID;
	}

	public Date getPTCC_UPD_DT() {
		return PTCC_UPD_DT;
	}

	public void setPTCC_UPD_DT(Date pTCC_UPD_DT) {
		PTCC_UPD_DT = pTCC_UPD_DT;
	}

	public String getPTCC_UPD_UID() {
		return PTCC_UPD_UID;
	}

	public void setPTCC_UPD_UID(String pTCC_UPD_UID) {
		PTCC_UPD_UID = pTCC_UPD_UID;
	}

	public Double getPTCC_SSTD_PERC() {
		return PTCC_SSTD_PERC;
	}

	public void setPTCC_SSTD_PERC(Double pTCC_SSTD_PERC) {
		PTCC_SSTD_PERC = pTCC_SSTD_PERC;
	}

		
	
}
