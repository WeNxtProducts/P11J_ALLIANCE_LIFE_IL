package com.iii.pel.forms.PILT003_APAC;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name="PT_IL_BROKER_VALUES")
public class PT_IL_BROKER_VALUES extends BaseValueBean {

	@Column(name="BV_POL_SYS_ID")
	private Long BV_POL_SYS_ID;

	@Column(name="BV_PC_SYS_ID")
	private Long BV_PC_SYS_ID;

	@Column(name="BV_COVER_CODE")
	private String BV_COVER_CODE;

	@Column(name="BV_BROKER_CODE")
	private String BV_BROKER_CODE;

	@Column(name="BV_CURR_CODE")
	private String BV_CURR_CODE;

	@Column(name="BV_YEAR")
	private Double BV_YEAR;

	@Column(name="BV_FC_VALUE")
	private Double BV_FC_VALUE;

	@Column(name="BV_LC_VALUE")
	private Double BV_LC_VALUE;

	@Column(name="BV_CR_DT")
	private Date BV_CR_DT;

	@Column(name="BV_CR_UID")
	private String BV_CR_UID;

	@Column(name="BV_COMM_CODE")
	private String BV_COMM_CODE;

	@Column(name="BV_RATE")
	private Double BV_RATE;

	@Column(name="BV_RATE_PER")
	private Double BV_RATE_PER;

	private String UI_M_BROKER_DESC;
	private String UI_M_COVER_DESC;
	public void setBV_COVER_CODE(String BV_COVER_CODE) {
		this.BV_COVER_CODE = BV_COVER_CODE;
	}
	public String getBV_COVER_CODE() {
		 return BV_COVER_CODE;
	}
	public void setBV_BROKER_CODE(String BV_BROKER_CODE) {
		this.BV_BROKER_CODE = BV_BROKER_CODE;
	}
	public String getBV_BROKER_CODE() {
		 return BV_BROKER_CODE;
	}
	public void setBV_FC_VALUE(Double BV_FC_VALUE) {
		this.BV_FC_VALUE = BV_FC_VALUE;
	}
	public Double getBV_FC_VALUE() {
		 return BV_FC_VALUE;
	}
	public void setBV_CURR_CODE(String BV_CURR_CODE) {
		this.BV_CURR_CODE = BV_CURR_CODE;
	}
	public String getBV_CURR_CODE() {
		 return BV_CURR_CODE;
	}
	public void setBV_YEAR(Double BV_YEAR) {
		this.BV_YEAR = BV_YEAR;
	}
	public Double getBV_YEAR() {
		 return BV_YEAR;
	}
	public void setUI_M_COVER_DESC(String UI_M_COVER_DESC) {
		this.UI_M_COVER_DESC = UI_M_COVER_DESC;
	}
	public String getUI_M_COVER_DESC() {
		 return UI_M_COVER_DESC;
	}
	public void setBV_LC_VALUE(Double BV_LC_VALUE) {
		this.BV_LC_VALUE = BV_LC_VALUE;
	}
	public Double getBV_LC_VALUE() {
		 return BV_LC_VALUE;
	}
	public void setBV_CR_DT(Date BV_CR_DT) {
		this.BV_CR_DT = BV_CR_DT;
	}
	public Date getBV_CR_DT() {
		 return BV_CR_DT;
	}
	public void setBV_RATE_PER(Double BV_RATE_PER) {
		this.BV_RATE_PER = BV_RATE_PER;
	}
	public Double getBV_RATE_PER() {
		 return BV_RATE_PER;
	}
	public void setBV_RATE(Double BV_RATE) {
		this.BV_RATE = BV_RATE;
	}
	public Double getBV_RATE() {
		 return BV_RATE;
	}
	public void setUI_M_BROKER_DESC(String UI_M_BROKER_DESC) {
		this.UI_M_BROKER_DESC = UI_M_BROKER_DESC;
	}
	public String getUI_M_BROKER_DESC() {
		 return UI_M_BROKER_DESC;
	}
	public void setBV_POL_SYS_ID(Long BV_POL_SYS_ID) {
		this.BV_POL_SYS_ID = BV_POL_SYS_ID;
	}
	public Long getBV_POL_SYS_ID() {
		 return BV_POL_SYS_ID;
	}
	public void setBV_PC_SYS_ID(Long BV_PC_SYS_ID) {
		this.BV_PC_SYS_ID = BV_PC_SYS_ID;
	}
	public Long getBV_PC_SYS_ID() {
		 return BV_PC_SYS_ID;
	}
	public void setBV_CR_UID(String BV_CR_UID) {
		this.BV_CR_UID = BV_CR_UID;
	}
	public String getBV_CR_UID() {
		 return BV_CR_UID;
	}
	public void setBV_COMM_CODE(String BV_COMM_CODE) {
		this.BV_COMM_CODE = BV_COMM_CODE;
	}
	public String getBV_COMM_CODE() {
		 return BV_COMM_CODE;
	}

}