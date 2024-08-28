package com.iii.pel.forms.PILT002_APAC_QE;

import java.util.Date;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PW_IL_QQUOT_ASSURED_DTLS")
public class PW_IL_QQUOT_BROK_DTL extends BaseValueBean {
	
	
	
	@Column(name="QQBD_SYS_ID")
	private Long QQBD_SYS_ID;
	
	@Column(name="QQBD_QQBH_SYS_ID")
	private Long QQBD_QQBH_SYS_ID;
	
	@Column(name="QQBD_CR_DT")
	private Date QQBD_CR_DT;
	
	@Column(name="QQBD_UPD_DT")
	private Date QQBD_UPD_DT;
	
	
	@Column(name="QQBD_DEL_FLAG")
	private String QQBD_DEL_FLAG;
	
	@Column(name="QQBD_CR_UID")
	private String QQBD_CR_UID;
	
	@Column(name="QQBD_UPD_UID")
	private String QQBD_UPD_UID;
	
	
	@Column(name="QQBD_RATE_PER")
	private Double QQBD_RATE_PER;
	
	
	@Column(name="QQBD_RATE")
	private Double QQBD_RATE;
	
	@Column(name="QQBD_YEAR_TO")
	private int QQBD_YEAR_TO;
	
	@Column(name="QQBD_YEAR_FROM")
	private int QQBD_YEAR_FROM;

	public Long getQQBD_SYS_ID() {
		return QQBD_SYS_ID;
	}

	public void setQQBD_SYS_ID(Long qQBD_SYS_ID) {
		QQBD_SYS_ID = qQBD_SYS_ID;
	}

	public Long getQQBD_QQBH_SYS_ID() {
		return QQBD_QQBH_SYS_ID;
	}

	public void setQQBD_QQBH_SYS_ID(Long qQBD_QQBH_SYS_ID) {
		QQBD_QQBH_SYS_ID = qQBD_QQBH_SYS_ID;
	}

	public Date getQQBD_CR_DT() {
		return QQBD_CR_DT;
	}

	public void setQQBD_CR_DT(Date qQBD_CR_DT) {
		QQBD_CR_DT = qQBD_CR_DT;
	}

	public Date getQQBD_UPD_DT() {
		return QQBD_UPD_DT;
	}

	public void setQQBD_UPD_DT(Date qQBD_UPD_DT) {
		QQBD_UPD_DT = qQBD_UPD_DT;
	}

	public String getQQBD_DEL_FLAG() {
		return QQBD_DEL_FLAG;
	}

	public void setQQBD_DEL_FLAG(String qQBD_DEL_FLAG) {
		QQBD_DEL_FLAG = qQBD_DEL_FLAG;
	}

	public String getQQBD_CR_UID() {
		return QQBD_CR_UID;
	}

	public void setQQBD_CR_UID(String qQBD_CR_UID) {
		QQBD_CR_UID = qQBD_CR_UID;
	}

	public String getQQBD_UPD_UID() {
		return QQBD_UPD_UID;
	}

	public void setQQBD_UPD_UID(String qQBD_UPD_UID) {
		QQBD_UPD_UID = qQBD_UPD_UID;
	}

	public Double getQQBD_RATE_PER() {
		return QQBD_RATE_PER;
	}

	public void setQQBD_RATE_PER(Double qQBD_RATE_PER) {
		QQBD_RATE_PER = qQBD_RATE_PER;
	}

	public Double getQQBD_RATE() {
		return QQBD_RATE;
	}

	public void setQQBD_RATE(Double qQBD_RATE) {
		QQBD_RATE = qQBD_RATE;
	}

	public int getQQBD_YEAR_TO() {
		return QQBD_YEAR_TO;
	}

	public void setQQBD_YEAR_TO(int qQBD_YEAR_TO) {
		QQBD_YEAR_TO = qQBD_YEAR_TO;
	}

	public int getQQBD_YEAR_FROM() {
		return QQBD_YEAR_FROM;
	}

	public void setQQBD_YEAR_FROM(int qQBD_YEAR_FROM) {
		QQBD_YEAR_FROM = qQBD_YEAR_FROM;
	}
	
	
	
	

}
