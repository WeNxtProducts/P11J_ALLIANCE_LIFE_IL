package com.iii.pel.forms.PILM071_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_LIFE_ENDT_NUMBER_SETUP")
public class PM_LIFE_ENDT_NUMBER_SETUP extends BaseValueBean {

	@Column(name="ENS_PREFIX")
	private String ENS_PREFIX;

	@Column(name="ENS_SUFFIX")
	private String ENS_SUFFIX;

	@Column(name="ENS_SEPARATOR")
	private String ENS_SEPARATOR;

	@Column(name="ENS_ZERO_PAD")
	private int ENS_ZERO_PAD;
	
	@Column(name="ENS_CR_DT")
	private Date ENS_CR_DT;
	
	@Column(name="ENS_CR_UID")
	private String ENS_CR_UID;
	
	@Column(name="ENS_ENDT_TYPE")
	private String ENS_ENDT_TYPE;
	
	@Column(name="ENS_UPD_DT")
	private Date ENS_UPD_DT;
	
	@Column(name="ENS_UPD_UID")
	private String ENS_UPD_UID;


	public String getENS_PREFIX() {
		return ENS_PREFIX;
	}

	public void setENS_PREFIX(String ENS_PREFIX) {
		this.ENS_PREFIX = ENS_PREFIX;
	}

	public String getENS_SUFFIX() {
		return ENS_SUFFIX;
	}

	public void setENS_SUFFIX(String ENS_SUFFIX) {
		this.ENS_SUFFIX = ENS_SUFFIX;
	}

	public String getENS_SEPARATOR() {
		return ENS_SEPARATOR;
	}

	public void setENS_SEPARATOR(String ENS_SEPARATOR) {
		this.ENS_SEPARATOR = ENS_SEPARATOR;
	}

	public int getENS_ZERO_PAD() {
		return ENS_ZERO_PAD;
	}

	public void setENS_ZERO_PAD(int ENS_ZERO_PAD) {
		this.ENS_ZERO_PAD = ENS_ZERO_PAD;
	}

	public Date getENS_CR_DT() {
		return ENS_CR_DT;
	}

	public void setENS_CR_DT(Date ens_cr_dt) {
		ENS_CR_DT = ens_cr_dt;
	}

	public String getENS_CR_UID() {
		return ENS_CR_UID;
	}

	public void setENS_CR_UID(String ens_cr_uid) {
		ENS_CR_UID = ens_cr_uid;
	}

	public String getENS_ENDT_TYPE() {
		return ENS_ENDT_TYPE;
	}

	public void setENS_ENDT_TYPE(String ens_endt_type) {
		ENS_ENDT_TYPE = ens_endt_type;
	}

	public Date getENS_UPD_DT() {
		return ENS_UPD_DT;
	}

	public void setENS_UPD_DT(Date ens_upd_dt) {
		ENS_UPD_DT = ens_upd_dt;
	}

	public String getENS_UPD_UID() {
		return ENS_UPD_UID;
	}

	public void setENS_UPD_UID(String ens_upd_uid) {
		ENS_UPD_UID = ens_upd_uid;
	}

}
