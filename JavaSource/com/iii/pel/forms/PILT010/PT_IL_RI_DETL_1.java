package com.iii.pel.forms.PILT010;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_RI_DETL")
public class PT_IL_RI_DETL_1 extends BaseValueBean {

	@Column(name="RD_COVER_CODE")
	private String RD_COVER_CODE;

	@Column(name="RD_ASSR_CODE")
	private String RD_ASSR_CODE;

	@Column(name="RD_SCHD_DT")
	private Date RD_SCHD_DT;

	@Column(name="RD_TAR_RATE")
	private Integer RD_TAR_RATE;

	@Column(name="RD_TAR_RATE_PER")
	private Integer RD_TAR_RATE_PER;

	@Column(name="RD_FC_SA")
	private Double RD_FC_SA;

	@Column(name="RD_FC_PREM")
	private Double RD_FC_PREM;

	@Column(name="RD_LC_PRD_PREM")
	private Double RD_LC_PRD_PREM;

	@Column(name="RD_PRD_FM_DT")
	private Date RD_PRD_FM_DT;

	@Column(name="RD_PRD_TO_DT")
	private Date RD_PRD_TO_DT;

	@Column(name="RD_FRZ_FLAG")
	private String RD_FRZ_FLAG;

	@Column(name="RD_TREATY_CODE")
	private String RD_TREATY_CODE;

	private String UI_M_TREATY_CODE_DESC;

	@Column(name="RD_REMARKS")
	private String RD_REMARKS;

	@Column(name="RD_POL_NO")
	private String RD_POL_NO;
	
	@Column(name="RD_SYS_ID")
	private Integer RD_SYS_ID;
	
	@Column(name="RD_POL_SYS_ID")
	private Double RD_POL_SYS_ID;
	
	@Column(name="RD_END_NO_IDX")
	private Integer RD_END_NO_IDX;
	
	@Column(name="RD_END_NO")
	private String RD_END_NO;
	
	@Column(name="RD_UW_YEAR")
	private Integer RD_UW_YEAR;
	
	@Column(name="RD_COVER_SYS_ID")
	private String RD_COVER_SYS_ID;
	
	@Column(name="RD_COVER_TYPE")
	private String RD_COVER_TYPE;
	
	@Column(name="RD_YEAR")
	private Integer RD_YEAR;

	public String getRD_COVER_CODE() {
		return RD_COVER_CODE;
	}

	public void setRD_COVER_CODE(String RD_COVER_CODE) {
		this.RD_COVER_CODE = RD_COVER_CODE;
	}

	public String getRD_ASSR_CODE() {
		return RD_ASSR_CODE;
	}

	public void setRD_ASSR_CODE(String RD_ASSR_CODE) {
		this.RD_ASSR_CODE = RD_ASSR_CODE;
	}

	public Date getRD_SCHD_DT() {
		 return RD_SCHD_DT;
	}

	public void setRD_SCHD_DT(Date RD_SCHD_DT) {
		this.RD_SCHD_DT = RD_SCHD_DT;
	}

	public Integer getRD_TAR_RATE() {
		return RD_TAR_RATE;
	}

	public void setRD_TAR_RATE(Integer RD_TAR_RATE) {
		this.RD_TAR_RATE = RD_TAR_RATE;
	}

	public Integer getRD_TAR_RATE_PER() {
		return RD_TAR_RATE_PER;
	}

	public void setRD_TAR_RATE_PER(Integer RD_TAR_RATE_PER) {
		this.RD_TAR_RATE_PER = RD_TAR_RATE_PER;
	}

	public Double getRD_FC_SA() {
		return RD_FC_SA;
	}

	public void setRD_FC_SA(Double RD_FC_SA) {
		this.RD_FC_SA = RD_FC_SA;
	}

	public Double getRD_FC_PREM() {
		return RD_FC_PREM;
	}

	public void setRD_FC_PREM(Double RD_FC_PREM) {
		this.RD_FC_PREM = RD_FC_PREM;
	}

	public Double getRD_LC_PRD_PREM() {
		return RD_LC_PRD_PREM;
	}

	public void setRD_LC_PRD_PREM(Double RD_LC_PRD_PREM) {
		this.RD_LC_PRD_PREM = RD_LC_PRD_PREM;
	}

	public Date getRD_PRD_FM_DT() {
		 return RD_PRD_FM_DT;
	}

	public void setRD_PRD_FM_DT(Date RD_PRD_FM_DT) {
		this.RD_PRD_FM_DT = RD_PRD_FM_DT;
	}

	public Date getRD_PRD_TO_DT() {
		 return RD_PRD_TO_DT;
	}

	public void setRD_PRD_TO_DT(Date RD_PRD_TO_DT) {
		this.RD_PRD_TO_DT = RD_PRD_TO_DT;
	}

	public String getRD_FRZ_FLAG() {
		return RD_FRZ_FLAG;
	}

	public void setRD_FRZ_FLAG(String RD_FRZ_FLAG) {
		this.RD_FRZ_FLAG = RD_FRZ_FLAG;
	}

	public String getRD_TREATY_CODE() {
		return RD_TREATY_CODE;
	}

	public void setRD_TREATY_CODE(String RD_TREATY_CODE) {
		this.RD_TREATY_CODE = RD_TREATY_CODE;
	}

	public String getUI_M_TREATY_CODE_DESC() {
		return UI_M_TREATY_CODE_DESC;
	}

	public void setUI_M_TREATY_CODE_DESC(String UI_M_TREATY_CODE_DESC) {
		this.UI_M_TREATY_CODE_DESC = UI_M_TREATY_CODE_DESC;
	}

	public String getRD_REMARKS() {
		return RD_REMARKS;
	}

	public void setRD_REMARKS(String RD_REMARKS) {
		this.RD_REMARKS = RD_REMARKS;
	}

	public String getRD_POL_NO() {
		return RD_POL_NO;
	}

	public void setRD_POL_NO(String rd_pol_no) {
		RD_POL_NO = rd_pol_no;
	}

	public Integer getRD_SYS_ID() {
		return RD_SYS_ID;
	}

	public void setRD_SYS_ID(Integer rd_sys_id) {
		RD_SYS_ID = rd_sys_id;
	}

	public Double getRD_POL_SYS_ID() {
		return RD_POL_SYS_ID;
	}

	public void setRD_POL_SYS_ID(Double rd_pol_sys_id) {
		RD_POL_SYS_ID = rd_pol_sys_id;
	}

	public Integer getRD_END_NO_IDX() {
		return RD_END_NO_IDX;
	}

	public void setRD_END_NO_IDX(Integer rd_end_no_idx) {
		RD_END_NO_IDX = rd_end_no_idx;
	}

	public String getRD_END_NO() {
		return RD_END_NO;
	}

	public void setRD_END_NO(String rd_end_no) {
		RD_END_NO = rd_end_no;
	}

	public Integer getRD_UW_YEAR() {
		return RD_UW_YEAR;
	}

	public void setRD_UW_YEAR(Integer rd_uw_year) {
		RD_UW_YEAR = rd_uw_year;
	}

	public String getRD_COVER_SYS_ID() {
		return RD_COVER_SYS_ID;
	}

	public void setRD_COVER_SYS_ID(String rd_cover_sys_id) {
		RD_COVER_SYS_ID = rd_cover_sys_id;
	}

	public String getRD_COVER_TYPE() {
		return RD_COVER_TYPE;
	}

	public void setRD_COVER_TYPE(String rd_cover_type) {
		RD_COVER_TYPE = rd_cover_type;
	}

	public Integer getRD_YEAR() {
		return RD_YEAR;
	}

	public void setRD_YEAR(Integer rd_year) {
		RD_YEAR = rd_year;
	}
}
