package com.iii.pel.forms.PILT010;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_RI_DISC_LOAD")
public class PT_IL_RI_DISC_LOAD extends BaseValueBean {

	@Column(name="RDL_COVER_CODE")
	private String RDL_COVER_CODE;

	@Column(name="RDL_SRNO")
	private Integer RDL_SRNO;

	@Column(name="RDL_DISC_LOAD_TYPE")
	private String RDL_DISC_LOAD_TYPE;

	@Column(name="RDL_DISC_LOAD_CODE")
	private String RDL_DISC_LOAD_CODE;

	@Column(name="RDL_RATE")
	private Double RDL_RATE;

	@Column(name="RDL_RATE_PER")
	private Integer RDL_RATE_PER;

	@Column(name="RDL_APPL_PERC")
	private Integer RDL_APPL_PERC;

	@Column(name="RDL_FC_DISC_LOAD_VALUE")
	private Double RDL_FC_DISC_LOAD_VALUE;

	@Column(name="RDL_LC_DISC_LOAD_VALUE")
	private Double RDL_LC_DISC_LOAD_VALUE;

	private String UI_M_COVER_CODE_DESC;

	private String UI_M_DISC_LOAD_CODE_DESC;

	@Column(name="RDL_CR_UID")
	private String RDL_CR_UID;
	
	@Column(name="RDL_CR_DT")
	private Date RDL_CR_DT;
	
	@Column(name="RDL_RD_SYS_ID")
	private Integer RDL_RD_SYS_ID;

	@Column(name="RDL_RPA_SRNO")
	private Integer RDL_RPA_SRNO;
	
	@Column(name="RDL_SYS_ID")
	private Integer RDL_SYS_ID;
	
	@Column(name="RDL_COVER_SYS_ID")
	private String RDL_COVER_SYS_ID;
	
	public String getRDL_COVER_CODE() {
		return RDL_COVER_CODE;
	}

	public void setRDL_COVER_CODE(String RDL_COVER_CODE) {
		this.RDL_COVER_CODE = RDL_COVER_CODE;
	}

	public Integer getRDL_SRNO() {
		return RDL_SRNO;
	}

	public void setRDL_SRNO(Integer RDL_SRNO) {
		this.RDL_SRNO = RDL_SRNO;
	}

	public String getRDL_DISC_LOAD_TYPE() {
		return RDL_DISC_LOAD_TYPE;
	}

	public void setRDL_DISC_LOAD_TYPE(String RDL_DISC_LOAD_TYPE) {
		this.RDL_DISC_LOAD_TYPE = RDL_DISC_LOAD_TYPE;
	}

	public String getRDL_DISC_LOAD_CODE() {
		return RDL_DISC_LOAD_CODE;
	}

	public void setRDL_DISC_LOAD_CODE(String RDL_DISC_LOAD_CODE) {
		this.RDL_DISC_LOAD_CODE = RDL_DISC_LOAD_CODE;
	}

	public Double getRDL_RATE() {
		return RDL_RATE;
	}

	public void setRDL_RATE(Double RDL_RATE) {
		this.RDL_RATE = RDL_RATE;
	}

	public Integer getRDL_RATE_PER() {
		return RDL_RATE_PER;
	}

	public void setRDL_RATE_PER(Integer RDL_RATE_PER) {
		this.RDL_RATE_PER = RDL_RATE_PER;
	}

	public Integer getRDL_APPL_PERC() {
		return RDL_APPL_PERC;
	}

	public void setRDL_APPL_PERC(Integer RDL_APPL_PERC) {
		this.RDL_APPL_PERC = RDL_APPL_PERC;
	}

	public Double getRDL_FC_DISC_LOAD_VALUE() {
		return RDL_FC_DISC_LOAD_VALUE;
	}

	public void setRDL_FC_DISC_LOAD_VALUE(Double RDL_FC_DISC_LOAD_VALUE) {
		this.RDL_FC_DISC_LOAD_VALUE = RDL_FC_DISC_LOAD_VALUE;
	}

	public Double getRDL_LC_DISC_LOAD_VALUE() {
		return RDL_LC_DISC_LOAD_VALUE;
	}

	public void setRDL_LC_DISC_LOAD_VALUE(Double RDL_LC_DISC_LOAD_VALUE) {
		this.RDL_LC_DISC_LOAD_VALUE = RDL_LC_DISC_LOAD_VALUE;
	}

	public String getUI_M_COVER_CODE_DESC() {
		return UI_M_COVER_CODE_DESC;
	}

	public void setUI_M_COVER_CODE_DESC(String UI_M_COVER_CODE_DESC) {
		this.UI_M_COVER_CODE_DESC = UI_M_COVER_CODE_DESC;
	}

	public String getUI_M_DISC_LOAD_CODE_DESC() {
		return UI_M_DISC_LOAD_CODE_DESC;
	}

	public void setUI_M_DISC_LOAD_CODE_DESC(String UI_M_DISC_LOAD_CODE_DESC) {
		this.UI_M_DISC_LOAD_CODE_DESC = UI_M_DISC_LOAD_CODE_DESC;
	}

	public String getRDL_CR_UID() {
		return RDL_CR_UID;
	}

	public void setRDL_CR_UID(String rdl_cr_uid) {
		RDL_CR_UID = rdl_cr_uid;
	}

	public Date getRDL_CR_DT() {
		return RDL_CR_DT;
	}

	public void setRDL_CR_DT(Date rdl_cr_dt) {
		RDL_CR_DT = rdl_cr_dt;
	}

	public Integer getRDL_RD_SYS_ID() {
		return RDL_RD_SYS_ID;
	}

	public void setRDL_RD_SYS_ID(Integer rdl_rd_sys_id) {
		RDL_RD_SYS_ID = rdl_rd_sys_id;
	}

	public Integer getRDL_RPA_SRNO() {
		return RDL_RPA_SRNO;
	}

	public void setRDL_RPA_SRNO(Integer rdl_rpa_srno) {
		RDL_RPA_SRNO = rdl_rpa_srno;
	}

	public Integer getRDL_SYS_ID() {
		return RDL_SYS_ID;
	}

	public void setRDL_SYS_ID(Integer rdl_sys_id) {
		RDL_SYS_ID = rdl_sys_id;
	}

	public String getRDL_COVER_SYS_ID() {
		return RDL_COVER_SYS_ID;
	}

	public void setRDL_COVER_SYS_ID(String rdl_cover_sys_id) {
		RDL_COVER_SYS_ID = rdl_cover_sys_id;
	}
}
