package com.iii.pel.forms.PILT010;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_RI_PREM_ALLOC")
public class PT_IL_RI_PREM_ALLOC extends BaseValueBean {

	private String UI_M_LAYER_CODE;

	private String UI_M_LAYER_CODE_DESC;

	private String UI_M_COVER_CODE;

	@Column(name="RPA_TREATY_TYPE")
	private String RPA_TREATY_TYPE;

	@Column(name="RPA_RI_FC_SA")
	private Double RPA_RI_FC_SA;

	@Column(name="RPA_RI_FC_PREM")
	private Double RPA_RI_FC_PREM;

	@Column(name="RPA_RI_LC_PRD_PREM")
	private Double RPA_RI_LC_PRD_PREM;

	@Column(name="RPA_RET_FC_SA")
	private Double RPA_RET_FC_SA;

	@Column(name="RPA_RET_FC_PREM")
	private Double RPA_RET_FC_PREM;

	@Column(name="RPA_RET_LC_PRD_PREM")
	private Double RPA_RET_LC_PRD_PREM;

	@Column(name="RPA_REINS_COMM_PERC")
	private Double RPA_REINS_COMM_PERC;

	@Column(name="RPA_REINS_FC_COMM")
	private Double RPA_REINS_FC_COMM;

	@Column(name="RPA_REINS_PRD_FC_COMM")
	private Double RPA_REINS_PRD_FC_COMM;

	@Column(name="RPA_RI_FC_POL_SA")
	private Double RPA_RI_FC_POL_SA;

	@Column(name="RPA_RI_FC_POL_PREM")
	private Double RPA_RI_FC_POL_PREM;

	@Column(name="RPA_RET_FC_POL_SA")
	private Double RPA_RET_FC_POL_SA;

	@Column(name="RPA_RET_FC_POL_PREM")
	private Double RPA_RET_FC_POL_PREM;

	@Column(name="RPA_FC_EXTRA_PREM")
	private Double RPA_FC_EXTRA_PREM;

	@Column(name="RPA_RI_LC_POL_SA")
	private Double RPA_RI_LC_POL_SA;

	@Column(name="RPA_RI_LC_POL_PREM")
	private Double RPA_RI_LC_POL_PREM;

	@Column(name="RPA_RET_LC_POL_SA")
	private Double RPA_RET_LC_POL_SA;

	@Column(name="RPA_RET_LC_POL_PREM")
	private Double RPA_RET_LC_POL_PREM;

	@Column(name="RPA_RI_GROSS_FC_PREM")
	private Double RPA_RI_GROSS_FC_PREM;

	private String UI_M_TTY_DESC;

	@Column(name="RPA_CR_UID")
	private String RPA_CR_UID;
	
	@Column(name="RPA_CR_DT")
	private Date RPA_CR_DT;
	
	@Column(name="RPA_POL_SYS_ID")
	private Long RPA_POL_SYS_ID;
	
	@Column(name="RPA_CLASS_CODE")
	private String RPA_CLASS_CODE;
	
	@Column(name="RPA_POL_NO")
	private String RPA_POL_NO;
	
	@Column(name="RPA_END_NO")
	private String RPA_END_NO;
	
	@Column(name="RPA_UW_YEAR")
	private Integer RPA_UW_YEAR;
	
	@Column(name="RPA_YEAR")
	private Integer RPA_YEAR;
	
	@Column(name="RPA_COVER_CODE")
	private String RPA_COVER_CODE;
	
	@Column(name="RPA_COVER_TYPE")
	private String RPA_COVER_TYPE;
	
	@Column(name="RPA_COVER_SYS_ID")
	private Integer RPA_COVER_SYS_ID;
	
	@Column(name="RPA_TREATY_CODE")
	private String RPA_TREATY_CODE;
	
	@Column(name="RPA_DT")
	private Date RPA_DT;
	
	@Column(name="RPA_RI_CLOSE_FLAG")
	private String RPA_RI_CLOSE_FLAG;
	
	@Column(name="RPA_END_NO_IDX")
	private Integer RPA_END_NO_IDX;
	
	@Column(name="RPA_DIVN_CODE")
	private String RPA_DIVN_CODE;
	
	@Column(name="RPA_RD_SYS_ID")
	private Integer RPA_RD_SYS_ID;
	
	private boolean selected;
	
	@Column(name="RPA_SRNO")
	private Integer RPA_SRNO;

	public String getUI_M_LAYER_CODE() {
		return UI_M_LAYER_CODE;
	}

	public void setUI_M_LAYER_CODE(String UI_M_LAYER_CODE) {
		this.UI_M_LAYER_CODE = UI_M_LAYER_CODE;
	}

	public String getUI_M_LAYER_CODE_DESC() {
		return UI_M_LAYER_CODE_DESC;
	}

	public void setUI_M_LAYER_CODE_DESC(String UI_M_LAYER_CODE_DESC) {
		this.UI_M_LAYER_CODE_DESC = UI_M_LAYER_CODE_DESC;
	}

	public String getUI_M_COVER_CODE() {
		return UI_M_COVER_CODE;
	}

	public void setUI_M_COVER_CODE(String UI_M_COVER_CODE) {
		this.UI_M_COVER_CODE = UI_M_COVER_CODE;
	}

	public String getRPA_TREATY_TYPE() {
		return RPA_TREATY_TYPE;
	}

	public void setRPA_TREATY_TYPE(String RPA_TREATY_TYPE) {
		this.RPA_TREATY_TYPE = RPA_TREATY_TYPE;
	}

	public Double getRPA_RI_FC_SA() {
		return RPA_RI_FC_SA;
	}

	public void setRPA_RI_FC_SA(Double RPA_RI_FC_SA) {
		this.RPA_RI_FC_SA = RPA_RI_FC_SA;
	}

	public Double getRPA_RI_FC_PREM() {
		return RPA_RI_FC_PREM;
	}

	public void setRPA_RI_FC_PREM(Double RPA_RI_FC_PREM) {
		this.RPA_RI_FC_PREM = RPA_RI_FC_PREM;
	}

	public Double getRPA_RI_LC_PRD_PREM() {
		return RPA_RI_LC_PRD_PREM;
	}

	public void setRPA_RI_LC_PRD_PREM(Double RPA_RI_LC_PRD_PREM) {
		this.RPA_RI_LC_PRD_PREM = RPA_RI_LC_PRD_PREM;
	}

	public Double getRPA_RET_FC_SA() {
		return RPA_RET_FC_SA;
	}

	public void setRPA_RET_FC_SA(Double RPA_RET_FC_SA) {
		this.RPA_RET_FC_SA = RPA_RET_FC_SA;
	}

	public Double getRPA_RET_FC_PREM() {
		return RPA_RET_FC_PREM;
	}

	public void setRPA_RET_FC_PREM(Double RPA_RET_FC_PREM) {
		this.RPA_RET_FC_PREM = RPA_RET_FC_PREM;
	}

	public Double getRPA_RET_LC_PRD_PREM() {
		return RPA_RET_LC_PRD_PREM;
	}

	public void setRPA_RET_LC_PRD_PREM(Double RPA_RET_LC_PRD_PREM) {
		this.RPA_RET_LC_PRD_PREM = RPA_RET_LC_PRD_PREM;
	}

	public Double getRPA_REINS_COMM_PERC() {
		return RPA_REINS_COMM_PERC;
	}

	public void setRPA_REINS_COMM_PERC(Double RPA_REINS_COMM_PERC) {
		this.RPA_REINS_COMM_PERC = RPA_REINS_COMM_PERC;
	}

	public Double getRPA_REINS_FC_COMM() {
		return RPA_REINS_FC_COMM;
	}

	public void setRPA_REINS_FC_COMM(Double RPA_REINS_FC_COMM) {
		this.RPA_REINS_FC_COMM = RPA_REINS_FC_COMM;
	}

	public Double getRPA_REINS_PRD_FC_COMM() {
		return RPA_REINS_PRD_FC_COMM;
	}

	public void setRPA_REINS_PRD_FC_COMM(Double RPA_REINS_PRD_FC_COMM) {
		this.RPA_REINS_PRD_FC_COMM = RPA_REINS_PRD_FC_COMM;
	}

	public Double getRPA_RI_FC_POL_SA() {
		return RPA_RI_FC_POL_SA;
	}

	public void setRPA_RI_FC_POL_SA(Double RPA_RI_FC_POL_SA) {
		this.RPA_RI_FC_POL_SA = RPA_RI_FC_POL_SA;
	}

	public Double getRPA_RI_FC_POL_PREM() {
		return RPA_RI_FC_POL_PREM;
	}

	public void setRPA_RI_FC_POL_PREM(Double RPA_RI_FC_POL_PREM) {
		this.RPA_RI_FC_POL_PREM = RPA_RI_FC_POL_PREM;
	}

	public Double getRPA_RET_FC_POL_SA() {
		return RPA_RET_FC_POL_SA;
	}

	public void setRPA_RET_FC_POL_SA(Double RPA_RET_FC_POL_SA) {
		this.RPA_RET_FC_POL_SA = RPA_RET_FC_POL_SA;
	}

	public Double getRPA_RET_FC_POL_PREM() {
		return RPA_RET_FC_POL_PREM;
	}

	public void setRPA_RET_FC_POL_PREM(Double RPA_RET_FC_POL_PREM) {
		this.RPA_RET_FC_POL_PREM = RPA_RET_FC_POL_PREM;
	}

	public Double getRPA_FC_EXTRA_PREM() {
		return RPA_FC_EXTRA_PREM;
	}

	public void setRPA_FC_EXTRA_PREM(Double RPA_FC_EXTRA_PREM) {
		this.RPA_FC_EXTRA_PREM = RPA_FC_EXTRA_PREM;
	}

	public Double getRPA_RI_LC_POL_SA() {
		return RPA_RI_LC_POL_SA;
	}

	public void setRPA_RI_LC_POL_SA(Double RPA_RI_LC_POL_SA) {
		this.RPA_RI_LC_POL_SA = RPA_RI_LC_POL_SA;
	}

	public Double getRPA_RI_LC_POL_PREM() {
		return RPA_RI_LC_POL_PREM;
	}

	public void setRPA_RI_LC_POL_PREM(Double RPA_RI_LC_POL_PREM) {
		this.RPA_RI_LC_POL_PREM = RPA_RI_LC_POL_PREM;
	}

	public Double getRPA_RET_LC_POL_SA() {
		return RPA_RET_LC_POL_SA;
	}

	public void setRPA_RET_LC_POL_SA(Double RPA_RET_LC_POL_SA) {
		this.RPA_RET_LC_POL_SA = RPA_RET_LC_POL_SA;
	}

	public Double getRPA_RET_LC_POL_PREM() {
		return RPA_RET_LC_POL_PREM;
	}

	public void setRPA_RET_LC_POL_PREM(Double RPA_RET_LC_POL_PREM) {
		this.RPA_RET_LC_POL_PREM = RPA_RET_LC_POL_PREM;
	}

	public Double getRPA_RI_GROSS_FC_PREM() {
		return RPA_RI_GROSS_FC_PREM;
	}

	public void setRPA_RI_GROSS_FC_PREM(Double RPA_RI_GROSS_FC_PREM) {
		this.RPA_RI_GROSS_FC_PREM = RPA_RI_GROSS_FC_PREM;
	}

	public String getUI_M_TTY_DESC() {
		return UI_M_TTY_DESC;
	}

	public void setUI_M_TTY_DESC(String UI_M_TTY_DESC) {
		this.UI_M_TTY_DESC = UI_M_TTY_DESC;
	}

	public String getRPA_CR_UID() {
		return RPA_CR_UID;
	}

	public void setRPA_CR_UID(String rpa_cr_uid) {
		RPA_CR_UID = rpa_cr_uid;
	}

	public Date getRPA_CR_DT() {
		return RPA_CR_DT;
	}

	public void setRPA_CR_DT(Date rpa_cr_dt) {
		RPA_CR_DT = rpa_cr_dt;
	}

	

	public Long getRPA_POL_SYS_ID() {
		return RPA_POL_SYS_ID;
	}

	public void setRPA_POL_SYS_ID(Long rpa_pol_sys_id) {
		RPA_POL_SYS_ID = rpa_pol_sys_id;
	}

	public String getRPA_CLASS_CODE() {
		return RPA_CLASS_CODE;
	}

	public void setRPA_CLASS_CODE(String rpa_class_code) {
		RPA_CLASS_CODE = rpa_class_code;
	}

	public String getRPA_POL_NO() {
		return RPA_POL_NO;
	}

	public void setRPA_POL_NO(String rpa_pol_no) {
		RPA_POL_NO = rpa_pol_no;
	}

	public String getRPA_END_NO() {
		return RPA_END_NO;
	}

	public void setRPA_END_NO(String rpa_end_no) {
		RPA_END_NO = rpa_end_no;
	}

	public Integer getRPA_UW_YEAR() {
		return RPA_UW_YEAR;
	}

	public void setRPA_UW_YEAR(Integer rpa_uw_year) {
		RPA_UW_YEAR = rpa_uw_year;
	}

	public Integer getRPA_YEAR() {
		return RPA_YEAR;
	}

	public void setRPA_YEAR(Integer rpa_year) {
		RPA_YEAR = rpa_year;
	}

	public String getRPA_COVER_CODE() {
		return RPA_COVER_CODE;
	}

	public void setRPA_COVER_CODE(String rpa_cover_code) {
		RPA_COVER_CODE = rpa_cover_code;
	}

	public String getRPA_COVER_TYPE() {
		return RPA_COVER_TYPE;
	}

	public void setRPA_COVER_TYPE(String rpa_cover_type) {
		RPA_COVER_TYPE = rpa_cover_type;
	}

	public Integer getRPA_COVER_SYS_ID() {
		return RPA_COVER_SYS_ID;
	}

	public void setRPA_COVER_SYS_ID(Integer rpa_cover_sys_id) {
		RPA_COVER_SYS_ID = rpa_cover_sys_id;
	}

	public String getRPA_TREATY_CODE() {
		return RPA_TREATY_CODE;
	}

	public void setRPA_TREATY_CODE(String rpa_treaty_code) {
		RPA_TREATY_CODE = rpa_treaty_code;
	}

	public Date getRPA_DT() {
		return RPA_DT;
	}

	public void setRPA_DT(Date rpa_dt) {
		RPA_DT = rpa_dt;
	}

	public String getRPA_RI_CLOSE_FLAG() {
		return RPA_RI_CLOSE_FLAG;
	}

	public void setRPA_RI_CLOSE_FLAG(String rpa_ri_close_flag) {
		RPA_RI_CLOSE_FLAG = rpa_ri_close_flag;
	}

	public Integer getRPA_END_NO_IDX() {
		return RPA_END_NO_IDX;
	}

	public void setRPA_END_NO_IDX(Integer rpa_end_no_idx) {
		RPA_END_NO_IDX = rpa_end_no_idx;
	}

	public String getRPA_DIVN_CODE() {
		return RPA_DIVN_CODE;
	}

	public void setRPA_DIVN_CODE(String rpa_divn_code) {
		RPA_DIVN_CODE = rpa_divn_code;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Integer getRPA_RD_SYS_ID() {
		return RPA_RD_SYS_ID;
	}

	public void setRPA_RD_SYS_ID(Integer rpa_rd_sys_id) {
		RPA_RD_SYS_ID = rpa_rd_sys_id;
	}

	public Integer getRPA_SRNO() {
		return RPA_SRNO;
	}

	public void setRPA_SRNO(Integer rpa_srno) {
		RPA_SRNO = rpa_srno;
	}
	//
	
	@Column(name="RPA_RI_CUST_CODE")
	private String RPA_RI_CUST_CODE;
	@Column(name="RPA_RI_CUST_PERC")
	private Double RPA_RI_CUST_PERC;

	public String getRPA_RI_CUST_CODE() {
		return RPA_RI_CUST_CODE;
	}

	public void setRPA_RI_CUST_CODE(String rPA_RI_CUST_CODE) {
		RPA_RI_CUST_CODE = rPA_RI_CUST_CODE;
	}

	public Double getRPA_RI_CUST_PERC() {
		return RPA_RI_CUST_PERC;
	}

	public void setRPA_RI_CUST_PERC(Double rPA_RI_CUST_PERC) {
		RPA_RI_CUST_PERC = rPA_RI_CUST_PERC;
	}
	
	public String getUI_M_CUST_CODE_DESC() {
		return UI_M_CUST_CODE_DESC;
	}

	public void setUI_M_CUST_CODE_DESC(String uI_M_CUST_CODE_DESC) {
		UI_M_CUST_CODE_DESC = uI_M_CUST_CODE_DESC;
	}

	private String UI_M_CUST_CODE_DESC;
	
	@Column(name="RPA_CQS_YN")
	private String RPA_CQS_YN;

	public String getRPA_CQS_YN() {
		return RPA_CQS_YN;
	}

	public void setRPA_CQS_YN(String rPA_CQS_YN) {
		RPA_CQS_YN = rPA_CQS_YN;
	}
	
}
