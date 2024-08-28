package com.iii.pel.forms.PILQ101;

import java.text.ParseException;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_POLICY")
public class PT_IL_POLICY extends BaseValueBean {
	
	
	public PT_IL_POLICY(){
		CommonUtils util=new CommonUtils();
			try {
					UI_M_REINSTMT_DT =util.getCurrentDate();
					System.out.println("date is "+UI_M_REINSTMT_DT);
				}catch (ParseException e) {
					e.printStackTrace();
				}
	}

	@Column(name="POL_NO")
	private String POL_NO;

	@Column(name="POL_CUST_CODE")
	private String POL_CUST_CODE;

	private String UI_M_POL_CUST_NAME;

	@Column(name="POL_CONT_CODE")
	private String POL_CONT_CODE;

	private String UI_M_POL_ASSURED_NAME;

	@Column(name="POL_ASSRD_REF_ID1")
	private String POL_ASSRD_REF_ID1;

	@Column(name="POL_ASSRD_REF_ID2")
	private String POL_ASSRD_REF_ID2;
	
	
	private String UI_M_REINST_CODE;
	
	private Double UI_M_DDCHG_RATE;
	
	private Double UI_M_DDCHG_CUST_SHARE_PERC;
	
	private Date UI_M_REINSTMT_DT;
	
	private Double UI_M_TOT_REINS_LC_CHARGE;
	
	private Double UI_M_REINST_CHARGE;
	
	private Double POL_CUST_EXCH_RATE;
	
	private Double Result_Lc_Charge;
	
	private Double UI_M_CONT_LC_POL_DEP_AMT;
	
	private Double UI_M_CONT_LC_POL_UTIL_AMT;
	
	private Double UI_M_AVAIL_LC_DEP_AMT;
	
	private Double UI_M_AVAIL_FC_DEP_AMT;
	
	private Date UI_M_MIN_PC_SCHD_PYMT_DT;
	
	private Date UI_M_MAX_PC_SCHD_PYMT_DT;
	
	private Integer UI_M_MONTHS_ACTL_DIFF;
	
	private Integer UI_M_MONTHS_DIFF;
	
	private Long POL_SYS_ID;
	
	private Double Lc_Extra_Amount;
	
	private Double Fc_Extra_Amount;
	
	private Double Lc_Extra_Charge;
	
	private Double Fc_Extra_Charge;

	private Double UI_M_NET_FC_PAID_AMT;
	
	private Double UI_M_NET_LC_PAID_AMT;
	
	private Double UI_M_REINS_FC_CHARGE;
	
	private Double UI_M_REINS_LC_CHARGE;
	
	private String UI_DATE_GRID;
	
	private Double UI_M_INTEREST; 
	/*Added By saranya For The ssp Call ID : FALCONQC-1715539 */
	private Double UI_M_PC_FC_GROSS_PREM_SUM;

	public Double getUI_M_PC_FC_GROSS_PREM_SUM() {
		return UI_M_PC_FC_GROSS_PREM_SUM;
	}

	public void setUI_M_PC_FC_GROSS_PREM_SUM(Double uI_M_PC_FC_GROSS_PREM_SUM) {
		UI_M_PC_FC_GROSS_PREM_SUM = uI_M_PC_FC_GROSS_PREM_SUM;
	}
	//end

	public Double getUI_M_INTEREST() {
		return UI_M_INTEREST;
	}

	public void setUI_M_INTEREST(Double ui_m_interest) {
		UI_M_INTEREST = ui_m_interest;
	}

	public String getUI_DATE_GRID() {
		return UI_DATE_GRID;
	}

	public void setUI_DATE_GRID(String ui_date_grid) {
		UI_DATE_GRID = ui_date_grid;
	}

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String pol_no) {
		POL_NO = pol_no;
	}

	public String getPOL_CUST_CODE() {
		return POL_CUST_CODE;
	}

	public void setPOL_CUST_CODE(String pol_cust_code) {
		POL_CUST_CODE = pol_cust_code;
	}

	public String getUI_M_POL_CUST_NAME() {
		return UI_M_POL_CUST_NAME;
	}

	public void setUI_M_POL_CUST_NAME(String ui_m_pol_cust_name) {
		UI_M_POL_CUST_NAME = ui_m_pol_cust_name;
	}

	public String getPOL_CONT_CODE() {
		return POL_CONT_CODE;
	}

	public void setPOL_CONT_CODE(String pol_cont_code) {
		POL_CONT_CODE = pol_cont_code;
	}

	public String getUI_M_POL_ASSURED_NAME() {
		return UI_M_POL_ASSURED_NAME;
	}

	public void setUI_M_POL_ASSURED_NAME(String ui_m_pol_assured_name) {
		UI_M_POL_ASSURED_NAME = ui_m_pol_assured_name;
	}

	public String getPOL_ASSRD_REF_ID1() {
		return POL_ASSRD_REF_ID1;
	}

	public void setPOL_ASSRD_REF_ID1(String pol_assrd_ref_id1) {
		POL_ASSRD_REF_ID1 = pol_assrd_ref_id1;
	}

	public String getPOL_ASSRD_REF_ID2() {
		return POL_ASSRD_REF_ID2;
	}

	public void setPOL_ASSRD_REF_ID2(String pol_assrd_ref_id2) {
		POL_ASSRD_REF_ID2 = pol_assrd_ref_id2;
	}

	public String getUI_M_REINST_CODE() {
		return UI_M_REINST_CODE;
	}

	public void setUI_M_REINST_CODE(String ui_m_reinst_code) {
		UI_M_REINST_CODE = ui_m_reinst_code;
	}

	public Double getUI_M_DDCHG_RATE() {
		return UI_M_DDCHG_RATE;
	}

	public void setUI_M_DDCHG_RATE(Double ui_m_ddchg_rate) {
		UI_M_DDCHG_RATE = ui_m_ddchg_rate;
	}

	public Double getUI_M_DDCHG_CUST_SHARE_PERC() {
		return UI_M_DDCHG_CUST_SHARE_PERC;
	}

	public void setUI_M_DDCHG_CUST_SHARE_PERC(Double ui_m_ddchg_cust_share_perc) {
		UI_M_DDCHG_CUST_SHARE_PERC = ui_m_ddchg_cust_share_perc;
	}

	public Date getUI_M_REINSTMT_DT() {
		return UI_M_REINSTMT_DT;
	}

	public void setUI_M_REINSTMT_DT(Date ui_m_reinstmt_dt) {
		UI_M_REINSTMT_DT = ui_m_reinstmt_dt;
	}

	public Double getUI_M_TOT_REINS_LC_CHARGE() {
		return UI_M_TOT_REINS_LC_CHARGE;
	}

	public void setUI_M_TOT_REINS_LC_CHARGE(Double ui_m_tot_reins_lc_charge) {
		UI_M_TOT_REINS_LC_CHARGE = ui_m_tot_reins_lc_charge;
	}

	public Double getUI_M_REINST_CHARGE() {
		return UI_M_REINST_CHARGE;
	}

	public void setUI_M_REINST_CHARGE(Double ui_m_reinst_charge) {
		UI_M_REINST_CHARGE = ui_m_reinst_charge;
	}

	public Double getPOL_CUST_EXCH_RATE() {
		return POL_CUST_EXCH_RATE;
	}

	public void setPOL_CUST_EXCH_RATE(Double pol_cust_exch_rate) {
		POL_CUST_EXCH_RATE = pol_cust_exch_rate;
	}

	public Double getResult_Lc_Charge() {
		return Result_Lc_Charge;
	}

	public void setResult_Lc_Charge(Double result_Lc_Charge) {
		Result_Lc_Charge = result_Lc_Charge;
	}

	public Double getUI_M_CONT_LC_POL_DEP_AMT() {
		return UI_M_CONT_LC_POL_DEP_AMT;
	}

	public void setUI_M_CONT_LC_POL_DEP_AMT(Double ui_m_cont_lc_pol_dep_amt) {
		UI_M_CONT_LC_POL_DEP_AMT = ui_m_cont_lc_pol_dep_amt;
	}

	public Double getUI_M_CONT_LC_POL_UTIL_AMT() {
		return UI_M_CONT_LC_POL_UTIL_AMT;
	}

	public void setUI_M_CONT_LC_POL_UTIL_AMT(Double ui_m_cont_lc_pol_util_amt) {
		UI_M_CONT_LC_POL_UTIL_AMT = ui_m_cont_lc_pol_util_amt;
	}

	public Double getUI_M_AVAIL_LC_DEP_AMT() {
		return UI_M_AVAIL_LC_DEP_AMT;
	}

	public void setUI_M_AVAIL_LC_DEP_AMT(Double ui_m_avail_lc_dep_amt) {
		UI_M_AVAIL_LC_DEP_AMT = ui_m_avail_lc_dep_amt;
	}

	public Double getUI_M_AVAIL_FC_DEP_AMT() {
		return UI_M_AVAIL_FC_DEP_AMT;
	}

	public void setUI_M_AVAIL_FC_DEP_AMT(Double ui_m_avail_fc_dep_amt) {
		UI_M_AVAIL_FC_DEP_AMT = ui_m_avail_fc_dep_amt;
	}

	public Date getUI_M_MIN_PC_SCHD_PYMT_DT() {
		return UI_M_MIN_PC_SCHD_PYMT_DT;
	}

	public void setUI_M_MIN_PC_SCHD_PYMT_DT(Date ui_m_min_pc_schd_pymt_dt) {
		UI_M_MIN_PC_SCHD_PYMT_DT = ui_m_min_pc_schd_pymt_dt;
	}

	public Date getUI_M_MAX_PC_SCHD_PYMT_DT() {
		return UI_M_MAX_PC_SCHD_PYMT_DT;
	}

	public void setUI_M_MAX_PC_SCHD_PYMT_DT(Date ui_m_max_pc_schd_pymt_dt) {
		UI_M_MAX_PC_SCHD_PYMT_DT = ui_m_max_pc_schd_pymt_dt;
	}

	public Integer getUI_M_MONTHS_ACTL_DIFF() {
		return UI_M_MONTHS_ACTL_DIFF;
	}

	public void setUI_M_MONTHS_ACTL_DIFF(Integer ui_m_months_actl_diff) {
		UI_M_MONTHS_ACTL_DIFF = ui_m_months_actl_diff;
	}

	public Integer getUI_M_MONTHS_DIFF() {
		return UI_M_MONTHS_DIFF;
	}

	public void setUI_M_MONTHS_DIFF(Integer ui_m_months_diff) {
		UI_M_MONTHS_DIFF = ui_m_months_diff;
	}

	public Long getPOL_SYS_ID() {
		return POL_SYS_ID;
	}

	public void setPOL_SYS_ID(Long pol_sys_id) {
		POL_SYS_ID = pol_sys_id;
	}

	public Double getLc_Extra_Amount() {
		return Lc_Extra_Amount;
	}

	public void setLc_Extra_Amount(Double lc_Extra_Amount) {
		Lc_Extra_Amount = lc_Extra_Amount;
	}

	public Double getFc_Extra_Amount() {
		return Fc_Extra_Amount;
	}

	public void setFc_Extra_Amount(Double fc_Extra_Amount) {
		Fc_Extra_Amount = fc_Extra_Amount;
	}

	public Double getLc_Extra_Charge() {
		return Lc_Extra_Charge;
	}

	public void setLc_Extra_Charge(Double lc_Extra_Charge) {
		Lc_Extra_Charge = lc_Extra_Charge;
	}

	public Double getFc_Extra_Charge() {
		return Fc_Extra_Charge;
	}

	public void setFc_Extra_Charge(Double fc_Extra_Charge) {
		Fc_Extra_Charge = fc_Extra_Charge;
	}

	public Double getUI_M_NET_FC_PAID_AMT() {
		return UI_M_NET_FC_PAID_AMT;
	}

	public void setUI_M_NET_FC_PAID_AMT(Double ui_m_net_fc_paid_amt) {
		UI_M_NET_FC_PAID_AMT = ui_m_net_fc_paid_amt;
	}

	public Double getUI_M_NET_LC_PAID_AMT() {
		return UI_M_NET_LC_PAID_AMT;
	}

	public void setUI_M_NET_LC_PAID_AMT(Double ui_m_net_lc_paid_amt) {
		UI_M_NET_LC_PAID_AMT = ui_m_net_lc_paid_amt;
	}

	public Double getUI_M_REINS_FC_CHARGE() {
		return UI_M_REINS_FC_CHARGE;
	}

	public void setUI_M_REINS_FC_CHARGE(Double ui_m_reins_fc_charge) {
		UI_M_REINS_FC_CHARGE = ui_m_reins_fc_charge;
	}

	public Double getUI_M_REINS_LC_CHARGE() {
		return UI_M_REINS_LC_CHARGE;
	}

	public void setUI_M_REINS_LC_CHARGE(Double ui_m_reins_lc_charge) {
		UI_M_REINS_LC_CHARGE = ui_m_reins_lc_charge;
	}
	
	@Column(name="POL_STATUS")
	private String POL_STATUS;

	public String getPOL_STATUS() {
		return POL_STATUS;
	}

	public void setPOL_STATUS(String pOL_STATUS) {
		POL_STATUS = pOL_STATUS;
	}
	
	/*Added by Janani on 25.01.2018 as per Gaurav suggestion */

	@Column(name="POL_ADDL_STATUS")
	private String POL_ADDL_STATUS;

	public String getPOL_ADDL_STATUS() {
		return POL_ADDL_STATUS;
	}

	public void setPOL_ADDL_STATUS(String pOL_ADDL_STATUS) {
		POL_ADDL_STATUS = pOL_ADDL_STATUS;
	}
	
	/*End */
	
}
