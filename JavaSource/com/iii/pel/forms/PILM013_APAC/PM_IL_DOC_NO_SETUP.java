package com.iii.pel.forms.PILM013_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DOC_NO_SETUP")
public class PM_IL_DOC_NO_SETUP extends BaseValueBean {
	
	@Column(name="DNS_FRZ_FLAG")
	private String DNS_FRZ_FLAG;

	@Column(name="DNS_FS")
	private String DNS_FS;

	@Column(name="DNS_LEVEL_1")
	private String DNS_LEVEL_1;

	@Column(name="DNS_LEVEL_2")
	private String DNS_LEVEL_2;

	@Column(name="DNS_LEVEL_3")
	private String DNS_LEVEL_3;

	@Column(name="DNS_LEVEL_4")
	private String DNS_LEVEL_4;

	@Column(name="DNS_LEVEL_5")
	private String DNS_LEVEL_5;

	@Column(name="DNS_L1_ATTACH_YN")
	private String DNS_L1_ATTACH_YN;

	@Column(name="DNS_L2_ATTACH_YN")
	private String DNS_L2_ATTACH_YN;

	@Column(name="DNS_L3_ATTACH_YN")
	private String DNS_L3_ATTACH_YN;

	@Column(name="DNS_L4_ATTACH_YN")
	private String DNS_L4_ATTACH_YN;

	@Column(name="DNS_L5_ATTACH_YN")
	private String DNS_L5_ATTACH_YN;

	@Column(name="DNS_PREFIX_YN")
	private String DNS_PREFIX_YN;

	@Column(name="DNS_PREFIX")
	private String DNS_PREFIX;

	@Column(name="DNS_PAD_YN")
	private String DNS_PAD_YN;

	@Column(name="DNS_PAD_LENGTH")
	private Integer DNS_PAD_LENGTH;

	@Column(name="DNS_CHK_DIGIT_YN")
	private String DNS_CHK_DIGIT_YN;

	@Column(name="DNS_YEAR_NUM")
	private String DNS_YEAR_NUM;

	@Column(name="DNS_ATTACH_SEQ_LEVEL")
	private String DNS_ATTACH_SEQ_LEVEL;

	@Column(name="DNS_TYPE")
	private String DNS_TYPE;
	
	@Column(name="DNS_CODE")
	private String DNS_CODE;
	
	@Column(name="DNS_CR_DT")
	private Date DNS_CR_DT;
	
	@Column(name="DNS_CR_UID")
	private String DNS_CR_UID;
	
	private boolean deletedStatus;
	

	public String getDNS_FRZ_FLAG() {
		return DNS_FRZ_FLAG;
	}

	public void setDNS_FRZ_FLAG(String DNS_FRZ_FLAG) {
		this.DNS_FRZ_FLAG = DNS_FRZ_FLAG;
	}

	public String getDNS_FS() {
		return DNS_FS;
	}

	public void setDNS_FS(String DNS_FS) {
		this.DNS_FS = DNS_FS;
	}

	public String getDNS_LEVEL_1() {
		return DNS_LEVEL_1;
	}

	public void setDNS_LEVEL_1(String DNS_LEVEL_1) {
		this.DNS_LEVEL_1 = DNS_LEVEL_1;
	}

	public String getDNS_LEVEL_2() {
		return DNS_LEVEL_2;
	}

	public void setDNS_LEVEL_2(String DNS_LEVEL_2) {
		this.DNS_LEVEL_2 = DNS_LEVEL_2;
	}

	public String getDNS_LEVEL_3() {
		return DNS_LEVEL_3;
	}

	public void setDNS_LEVEL_3(String DNS_LEVEL_3) {
		this.DNS_LEVEL_3 = DNS_LEVEL_3;
	}

	public String getDNS_LEVEL_4() {
		return DNS_LEVEL_4;
	}

	public void setDNS_LEVEL_4(String DNS_LEVEL_4) {
		this.DNS_LEVEL_4 = DNS_LEVEL_4;
	}

	public String getDNS_LEVEL_5() {
		return DNS_LEVEL_5;
	}

	public void setDNS_LEVEL_5(String DNS_LEVEL_5) {
		this.DNS_LEVEL_5 = DNS_LEVEL_5;
	}

	public String getDNS_L1_ATTACH_YN() {
		return DNS_L1_ATTACH_YN;
	}

	public void setDNS_L1_ATTACH_YN(String DNS_L1_ATTACH_YN) {
		this.DNS_L1_ATTACH_YN = DNS_L1_ATTACH_YN;
	}

	public String getDNS_L2_ATTACH_YN() {
		return DNS_L2_ATTACH_YN;
	}

	public void setDNS_L2_ATTACH_YN(String DNS_L2_ATTACH_YN) {
		this.DNS_L2_ATTACH_YN = DNS_L2_ATTACH_YN;
	}

	public String getDNS_L3_ATTACH_YN() {
		return DNS_L3_ATTACH_YN;
	}

	public void setDNS_L3_ATTACH_YN(String DNS_L3_ATTACH_YN) {
		this.DNS_L3_ATTACH_YN = DNS_L3_ATTACH_YN;
	}

	public String getDNS_L4_ATTACH_YN() {
		return DNS_L4_ATTACH_YN;
	}

	public void setDNS_L4_ATTACH_YN(String DNS_L4_ATTACH_YN) {
		this.DNS_L4_ATTACH_YN = DNS_L4_ATTACH_YN;
	}

	public String getDNS_L5_ATTACH_YN() {
		return DNS_L5_ATTACH_YN;
	}

	public void setDNS_L5_ATTACH_YN(String DNS_L5_ATTACH_YN) {
		this.DNS_L5_ATTACH_YN = DNS_L5_ATTACH_YN;
	}

	public String getDNS_PREFIX_YN() {
		return DNS_PREFIX_YN;
	}

	public void setDNS_PREFIX_YN(String DNS_PREFIX_YN) {
		this.DNS_PREFIX_YN = DNS_PREFIX_YN;
	}

	public String getDNS_PREFIX() {
		return DNS_PREFIX;
	}

	public void setDNS_PREFIX(String DNS_PREFIX) {
		this.DNS_PREFIX = DNS_PREFIX;
	}

	public String getDNS_PAD_YN() {
		return DNS_PAD_YN;
	}

	public void setDNS_PAD_YN(String DNS_PAD_YN) {
		this.DNS_PAD_YN = DNS_PAD_YN;
	}

	
	public Integer getDNS_PAD_LENGTH() {
		return DNS_PAD_LENGTH;
	}

	public void setDNS_PAD_LENGTH(Integer dns_pad_length) {
		DNS_PAD_LENGTH = dns_pad_length;
	}

	public String getDNS_CHK_DIGIT_YN() {
		return DNS_CHK_DIGIT_YN;
	}

	public void setDNS_CHK_DIGIT_YN(String DNS_CHK_DIGIT_YN) {
		this.DNS_CHK_DIGIT_YN = DNS_CHK_DIGIT_YN;
	}

	public String getDNS_YEAR_NUM() {
		return DNS_YEAR_NUM;
	}

	public void setDNS_YEAR_NUM(String DNS_YEAR_NUM) {
		this.DNS_YEAR_NUM = DNS_YEAR_NUM;
	}

	public String getDNS_ATTACH_SEQ_LEVEL() {
		return DNS_ATTACH_SEQ_LEVEL;
	}

	public void setDNS_ATTACH_SEQ_LEVEL(String DNS_ATTACH_SEQ_LEVEL) {
		this.DNS_ATTACH_SEQ_LEVEL = DNS_ATTACH_SEQ_LEVEL;
	}

	public String getDNS_TYPE() {
		return DNS_TYPE;
	}

	public void setDNS_TYPE(String dns_type) {
		DNS_TYPE = dns_type;
	}

	public String getDNS_CODE() {
		return DNS_CODE;
	}

	public void setDNS_CODE(String dns_code) {
		DNS_CODE = dns_code;
	}

	public Date getDNS_CR_DT() {
		return DNS_CR_DT;
	}

	public void setDNS_CR_DT(Date dns_cr_dt) {
		DNS_CR_DT = dns_cr_dt;
	}

	public String getDNS_CR_UID() {
		return DNS_CR_UID;
	}

	public void setDNS_CR_UID(String dns_cr_uid) {
		DNS_CR_UID = dns_cr_uid;
	}

	public boolean isDeletedStatus() {
		return deletedStatus;
	}

	public void setDeletedStatus(boolean deletedStatus) {
		this.deletedStatus = deletedStatus;
	}
}
