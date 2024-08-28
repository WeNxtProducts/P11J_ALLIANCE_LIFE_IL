package com.iii.pel.forms.PILM015_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROP_TREATY")
public class PM_IL_PROP_TREATY extends BaseValueBean {

	@Column(name="PT_FRZ_FLAG")
	private String PT_FRZ_FLAG;

	@Column(name="PT_TREATY_CODE")
	private String PT_TREATY_CODE;

	@Column(name="PT_TREATY_DESC")
	private String PT_TREATY_DESC;

	@Column(name="PT_CLASS_CODE")
	private String PT_CLASS_CODE;

	private String UI_M_CLASS_CODE_DESC;

	@Column(name="PT_UW_YEAR")
	private Integer PT_UW_YEAR;

	@Column(name="PT_UW_YEAR_DESC")
	private String PT_UW_YEAR_DESC;

	@Column(name="PT_START_DT")
	private Date PT_START_DT;

	@Column(name="PT_END_DT")
	private Date PT_END_DT;

	@Column(name="PT_CURR_CODE")
	private String PT_CURR_CODE;

	private String UI_M_CURR_DESC;

	@Column(name="PT_CURR_RATE")
	private Double PT_CURR_RATE;

	@Column(name="PT_CASH_CALL_LC_LIMIT")
	private Double PT_CASH_CALL_LC_LIMIT;

	@Column(name="PT_CQS_YN")
	private String PT_CQS_YN;

	@Column(name="PT_CASH_CALL_FC_LIMIT")
	private Double PT_CASH_CALL_FC_LIMIT;

	@Column(name="PT_RIDER_RI_BASIS")
	private String PT_RIDER_RI_BASIS;

	@Column(name="PT_CQS_PERC")
	private Double PT_CQS_PERC;

	@Column(name="PT_SURR_CLAIM_YN")
	private String PT_SURR_CLAIM_YN;

	@Column(name="PT_CORIDOR_LC_LIMIT")
	private Double PT_CORIDOR_LC_LIMIT;

	@Column(name="PT_REALLC_ENDT_YN")
	private String PT_REALLC_ENDT_YN;
	
	@Column(name="PT_CR_DT")
	private Date PT_CR_DT;
	
	@Column(name="PT_CR_UID")
	private String PT_CR_UID;
	
	@Column(name="PT_SYS_ID")
	private Double PT_SYS_ID;

	private boolean FRZ_FLAG;
	
	@Column(name="PT_UPD_DT")
	private Date PT_UPD_DT;
	
	@Column(name="PT_UPD_UID")
	private String PT_UPD_UID;
	
	private String UI_M_CP_DEST_TREATY_CODE;
	
	private Integer UI_M_CP_DEST_UW_YEAR;
	
	private String fmdate;
	private String todate;


	public String getFmdate() {
		return fmdate;
	}

	public void setFmdate(String fmdate) {
		this.fmdate = fmdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getPT_TREATY_CODE() {
		System.out.println(" GET BEAN TREATY CODE"+PT_TREATY_CODE);
		return PT_TREATY_CODE;
	}

	public void setPT_TREATY_CODE(String PT_TREATY_CODE) {
		System.out.println(" SET BEAN TREATY CODE"+PT_TREATY_CODE);
		this.PT_TREATY_CODE = PT_TREATY_CODE;
	}

	public String getPT_TREATY_DESC() {
		return PT_TREATY_DESC;
	}

	public void setPT_TREATY_DESC(String PT_TREATY_DESC) {
		this.PT_TREATY_DESC = PT_TREATY_DESC;
	}

	public String getPT_CLASS_CODE() {
		return PT_CLASS_CODE;
	}

	public void setPT_CLASS_CODE(String PT_CLASS_CODE) {
		this.PT_CLASS_CODE = PT_CLASS_CODE;
	}

	public String getUI_M_CLASS_CODE_DESC() {
		return UI_M_CLASS_CODE_DESC;
	}

	public void setUI_M_CLASS_CODE_DESC(String UI_M_CLASS_CODE_DESC) {
		this.UI_M_CLASS_CODE_DESC = UI_M_CLASS_CODE_DESC;
	}


	public String getPT_UW_YEAR_DESC() {
		return PT_UW_YEAR_DESC;
	}

	public void setPT_UW_YEAR_DESC(String PT_UW_YEAR_DESC) {
		this.PT_UW_YEAR_DESC = PT_UW_YEAR_DESC;
	}

	public Date getPT_START_DT() {
		 return PT_START_DT;
	}

	public void setPT_START_DT(Date PT_START_DT) {
		this.PT_START_DT = PT_START_DT;
	}

	public Date getPT_END_DT() {
		 return PT_END_DT;
	}

	public void setPT_END_DT(Date PT_END_DT) {
		this.PT_END_DT = PT_END_DT;
	}

	public String getPT_CURR_CODE() {
		return PT_CURR_CODE;
	}

	public void setPT_CURR_CODE(String PT_CURR_CODE) {
		this.PT_CURR_CODE = PT_CURR_CODE;
	}

	public String getUI_M_CURR_DESC() {
		return UI_M_CURR_DESC;
	}

	public void setUI_M_CURR_DESC(String UI_M_CURR_DESC) {
		this.UI_M_CURR_DESC = UI_M_CURR_DESC;
	}

	public Double getPT_CURR_RATE() {
		return PT_CURR_RATE;
	}

	public void setPT_CURR_RATE(Double PT_CURR_RATE) {
		this.PT_CURR_RATE = PT_CURR_RATE;
	}

	public Double getPT_CASH_CALL_LC_LIMIT() {
		return PT_CASH_CALL_LC_LIMIT;
	}

	public void setPT_CASH_CALL_LC_LIMIT(Double PT_CASH_CALL_LC_LIMIT) {
		this.PT_CASH_CALL_LC_LIMIT = PT_CASH_CALL_LC_LIMIT;
	}

	public String getPT_CQS_YN() {
		return PT_CQS_YN;
	}

	public void setPT_CQS_YN(String PT_CQS_YN) {
		this.PT_CQS_YN = PT_CQS_YN;
	}

	public Double getPT_CASH_CALL_FC_LIMIT() {
		return PT_CASH_CALL_FC_LIMIT;
	}

	public void setPT_CASH_CALL_FC_LIMIT(Double PT_CASH_CALL_FC_LIMIT) {
		this.PT_CASH_CALL_FC_LIMIT = PT_CASH_CALL_FC_LIMIT;
	}

	public String getPT_RIDER_RI_BASIS() {
		return PT_RIDER_RI_BASIS;
	}

	public void setPT_RIDER_RI_BASIS(String PT_RIDER_RI_BASIS) {
		this.PT_RIDER_RI_BASIS = PT_RIDER_RI_BASIS;
	}

	public Double getPT_CQS_PERC() {
		return PT_CQS_PERC;
	}

	public void setPT_CQS_PERC(Double PT_CQS_PERC) {
		this.PT_CQS_PERC = PT_CQS_PERC;
	}

	public String getPT_SURR_CLAIM_YN() {
		return PT_SURR_CLAIM_YN;
	}

	public void setPT_SURR_CLAIM_YN(String PT_SURR_CLAIM_YN) {
		this.PT_SURR_CLAIM_YN = PT_SURR_CLAIM_YN;
	}

	public Double getPT_CORIDOR_LC_LIMIT() {
		return PT_CORIDOR_LC_LIMIT;
	}

	public void setPT_CORIDOR_LC_LIMIT(Double PT_CORIDOR_LC_LIMIT) {
		this.PT_CORIDOR_LC_LIMIT = PT_CORIDOR_LC_LIMIT;
	}

	public String getPT_REALLC_ENDT_YN() {
		return PT_REALLC_ENDT_YN;
	}

	public void setPT_REALLC_ENDT_YN(String PT_REALLC_ENDT_YN) {
		this.PT_REALLC_ENDT_YN = PT_REALLC_ENDT_YN;
	}

	public Date getPT_CR_DT() {
		return PT_CR_DT;
	}

	public void setPT_CR_DT(Date pt_cr_dt) {
		PT_CR_DT = pt_cr_dt;
	}

	public String getPT_CR_UID() {
		return PT_CR_UID;
	}

	public void setPT_CR_UID(String pt_cr_uid) {
		PT_CR_UID = pt_cr_uid;
	}

	public Double getPT_SYS_ID() {
		return PT_SYS_ID;
	}

	public void setPT_SYS_ID(Double pt_sys_id) {
	
		PT_SYS_ID = pt_sys_id;
	}

	public String getPT_FRZ_FLAG() {
		return PT_FRZ_FLAG;
	}

	public void setPT_FRZ_FLAG(String pt_frz_flag) {
		
		PT_FRZ_FLAG = pt_frz_flag;
	}

	public boolean isFRZ_FLAG() {
		return FRZ_FLAG;
	}

	public void setFRZ_FLAG(boolean frz_flag) {
				FRZ_FLAG = frz_flag;
	}

	public Date getPT_UPD_DT() {
		return PT_UPD_DT;
	}

	public void setPT_UPD_DT(Date pt_upd_dt) {
		PT_UPD_DT = pt_upd_dt;
	}

	public String getPT_UPD_UID() {
		return PT_UPD_UID;
	}

	public void setPT_UPD_UID(String pt_upd_uid) {
		PT_UPD_UID = pt_upd_uid;
	}

	public String getUI_M_CP_DEST_TREATY_CODE() {
		return UI_M_CP_DEST_TREATY_CODE;
	}

	public void setUI_M_CP_DEST_TREATY_CODE(String ui_m_cp_dest_treaty_code) {
		UI_M_CP_DEST_TREATY_CODE = ui_m_cp_dest_treaty_code;
	}

	public Integer getPT_UW_YEAR() {
		return PT_UW_YEAR;
	}

	public void setPT_UW_YEAR(Integer pt_uw_year) {
		PT_UW_YEAR = pt_uw_year;
	}

	public Integer getUI_M_CP_DEST_UW_YEAR() {
		return UI_M_CP_DEST_UW_YEAR;
	}

	public void setUI_M_CP_DEST_UW_YEAR(Integer ui_m_cp_dest_uw_year) {
		UI_M_CP_DEST_UW_YEAR = ui_m_cp_dest_uw_year;
	}

	
	

	
}
