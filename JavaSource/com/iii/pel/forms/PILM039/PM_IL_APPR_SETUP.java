package com.iii.pel.forms.PILM039;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_APPR_SETUP")
public class PM_IL_APPR_SETUP extends BaseValueBean{

	
	@Column(name = "AS_USER_ID")
	private String AS_USER_ID;

	private String UI_M_USER_DESC;

	@Column(name = "AS_FM_PROD_CODE")
	private String AS_FM_PROD_CODE;

	@Column(name = "AS_TO_PROD_CODE")
	private String AS_TO_PROD_CODE;

	private String AS_FM_PROD_CODE_DESC;

	private String AS_TO_PROD_CODE_DESC;

	private String USER_GROUP_ID;

	private String ACMD_PROD_TYPE;

	@Column(name = "AS_UPD_DT")
	private Date AS_UPD_DT;
	
	@Column(name = "AS_CLM_REOPEN_YN")
	private String AS_CLM_REOPEN_YN;
	
	@Column(name = "AS_NO_OF_CLAIMS")
	private Double AS_NO_OF_CLAIMS;
	
	
	@Column(name = "AS_RENEWAL_YN")
	private String AS_RENEWAL_YN;
	
	
	@Column(name = "AS_UPD_UID")
	private String AS_UPD_UID;
	
	@Column(name = "AS_CR_DT")
	private Date AS_CR_DT;
	
	@Column(name = "AS_CR_UID")
	private String AS_CR_UID;
	
	@Column(name = "AS_APPR_YN")
	private String AS_APPR_YN;
	
	@Column(name = "AS_FAC_ENTER_YN")
	private String AS_FAC_ENTER_YN;
	
	@Column(name = "AS_APPR_MAX_DISC_PERC")
	private double AS_APPR_MAX_DISC_PERC;
	
	@Column(name = "AS_APPR_MAX_LC_DISC_AMT")
	private double AS_APPR_MAX_LC_DISC_AMT;
	
	@Column(name = "AS_APPR_ONE_DISC_PERC")
	private double AS_APPR_ONE_DISC_PERC;
	
	@Column(name = "AS_APPR_ONE_LC_DISC_AMT")
	private double AS_APPR_ONE_LC_DISC_AMT;
	
	@Column(name = "AS_APPR_MAX_LC_SI")
	private double AS_APPR_MAX_LC_SI;
	
	@Column(name = "AS_APPR_MAX_LC_CLAIM")
	private double AS_APPR_MAX_LC_CLAIM;
	
	@Column(name = "AS_APPR_BRK_PERC")
	private double AS_APPR_BRK_PERC;
	
	@Column(name = "AS_FRZ_FLAG")
	private String AS_FRZ_FLAG;
	
	@Column(name = "AS_REINST_POL_YN")
	private String  AS_REINST_POL_YN;
	
	@Column(name = "AS_MOD_ACC_FLAG_YN")
	private String AS_MOD_ACC_FLAG_YN;
	
	@Column(name = "AS_ISS_DT_BACK_DATED_YN")
	private String AS_ISS_DT_BACK_DATED_YN;
	
	@Column(name = "AS_BACK_DATED_UPTO_NO_OF_DAYS")
	private Double AS_BACK_DATED_UPTO_NO_OF_DAYS;
	
	@Column(name = "AS_POL_DEL_YN")
	private String AS_POL_DEL_YN;
	
	@Column(name = "AS_PROP_APPR_YN")
	private String AS_PROP_APPR_YN;
	@Column(name = "AS_REPRINT_YN")
	private String AS_REPRINT_YN;	
	

	public String getAS_USER_ID() {
		return AS_USER_ID;
	}

	public void setAS_USER_ID(String AS_USER_ID) {
		this.AS_USER_ID = AS_USER_ID;
	}

	public String getUI_M_USER_DESC() {
		return UI_M_USER_DESC;
	}

	public void setUI_M_USER_DESC(String UI_M_USER_DESC) {
		this.UI_M_USER_DESC = UI_M_USER_DESC;
	}

	public String getAS_FM_PROD_CODE() {
		return AS_FM_PROD_CODE;
	}

	public void setAS_FM_PROD_CODE(String AS_FM_PROD_CODE) {
		this.AS_FM_PROD_CODE = AS_FM_PROD_CODE;
	}

	public String getAS_TO_PROD_CODE() {
		return AS_TO_PROD_CODE;
	}

	public void setAS_TO_PROD_CODE(String AS_TO_PROD_CODE) {
		this.AS_TO_PROD_CODE = AS_TO_PROD_CODE;
	}

	public String getAS_FM_PROD_CODE_DESC() {
		return AS_FM_PROD_CODE_DESC;
	}

	public void setAS_FM_PROD_CODE_DESC(String AS_FM_PROD_CODE_DESC) {
		this.AS_FM_PROD_CODE_DESC = AS_FM_PROD_CODE_DESC;
	}

	public String getAS_TO_PROD_CODE_DESC() {
		return AS_TO_PROD_CODE_DESC;
	}

	public void setAS_TO_PROD_CODE_DESC(String AS_TO_PROD_CODE_DESC) {
		this.AS_TO_PROD_CODE_DESC = AS_TO_PROD_CODE_DESC;
	}

	public String getUSER_GROUP_ID() {
		return USER_GROUP_ID;
	}

	public void setUSER_GROUP_ID(String USER_GROUP_ID) {
		this.USER_GROUP_ID = USER_GROUP_ID;
	}

	public String getACMD_PROD_TYPE() {
		return ACMD_PROD_TYPE;
	}

	public void setACMD_PROD_TYPE(String acmd_prod_type) {
		ACMD_PROD_TYPE = acmd_prod_type;
	}

	public Date getAS_CR_DT() {
		return AS_CR_DT;
	}

	public void setAS_CR_DT(Date as_cr_dt) {
		AS_CR_DT = as_cr_dt;
	}

	public String getAS_CR_UID() {
		return AS_CR_UID;
	}

	public void setAS_CR_UID(String as_cr_uid) {
		AS_CR_UID = as_cr_uid;
	}

	public String getAS_APPR_YN() {
		return AS_APPR_YN;
	}

	public void setAS_APPR_YN(String as_appr_yn) {
		AS_APPR_YN = as_appr_yn;
	}

	public String getAS_FAC_ENTER_YN() {
		return AS_FAC_ENTER_YN;
	}

	public void setAS_FAC_ENTER_YN(String as_fac_enter_yn) {
		AS_FAC_ENTER_YN = as_fac_enter_yn;
	}

	public double getAS_APPR_MAX_DISC_PERC() {
		return AS_APPR_MAX_DISC_PERC;
	}

	public void setAS_APPR_MAX_DISC_PERC(double as_appr_max_disc_perc) {
		AS_APPR_MAX_DISC_PERC = as_appr_max_disc_perc;
	}

	public double getAS_APPR_MAX_LC_DISC_AMT() {
		return AS_APPR_MAX_LC_DISC_AMT;
	}

	public void setAS_APPR_MAX_LC_DISC_AMT(double as_appr_max_lc_disc_amt) {
		AS_APPR_MAX_LC_DISC_AMT = as_appr_max_lc_disc_amt;
	}

	public double getAS_APPR_ONE_DISC_PERC() {
		return AS_APPR_ONE_DISC_PERC;
	}

	public void setAS_APPR_ONE_DISC_PERC(double as_appr_one_disc_perc) {
		AS_APPR_ONE_DISC_PERC = as_appr_one_disc_perc;
	}

	public double getAS_APPR_ONE_LC_DISC_AMT() {
		return AS_APPR_ONE_LC_DISC_AMT;
	}

	public void setAS_APPR_ONE_LC_DISC_AMT(double as_appr_one_lc_disc_amt) {
		AS_APPR_ONE_LC_DISC_AMT = as_appr_one_lc_disc_amt;
	}

	public double getAS_APPR_MAX_LC_SI() {
		return AS_APPR_MAX_LC_SI;
	}

	public void setAS_APPR_MAX_LC_SI(double as_appr_max_lc_si) {
		AS_APPR_MAX_LC_SI = as_appr_max_lc_si;
	}

	public double getAS_APPR_MAX_LC_CLAIM() {
		return AS_APPR_MAX_LC_CLAIM;
	}

	public void setAS_APPR_MAX_LC_CLAIM(double as_appr_max_lc_claim) {
		AS_APPR_MAX_LC_CLAIM = as_appr_max_lc_claim;
	}

	public double getAS_APPR_BRK_PERC() {
		return AS_APPR_BRK_PERC;
	}

	public void setAS_APPR_BRK_PERC(double as_appr_brk_perc) {
		AS_APPR_BRK_PERC = as_appr_brk_perc;
	}

	public String getAS_FRZ_FLAG() {
		return AS_FRZ_FLAG;
	}

	public void setAS_FRZ_FLAG(String as_frz_flag) {
		AS_FRZ_FLAG = as_frz_flag;
	}

	public Date getAS_UPD_DT() {
		return AS_UPD_DT;
	}

	public void setAS_UPD_DT(Date as_upd_dt) {
		AS_UPD_DT = as_upd_dt;
	}

	public String getAS_UPD_UID() {
		return AS_UPD_UID;
	}

	public void setAS_UPD_UID(String as_upd_uid) {
		AS_UPD_UID = as_upd_uid;
	}

	public String getAS_CLM_REOPEN_YN() {
		return AS_CLM_REOPEN_YN;
	}

	public void setAS_CLM_REOPEN_YN(String as_clm_reopen_yn) {
		AS_CLM_REOPEN_YN = as_clm_reopen_yn;
	}

	public String getAS_RENEWAL_YN() {
		return AS_RENEWAL_YN;
	}

	public void setAS_RENEWAL_YN(String as_renewal_yn) {
		AS_RENEWAL_YN = as_renewal_yn;
	}

	public Double getAS_NO_OF_CLAIMS() {
		return AS_NO_OF_CLAIMS;
	}

	public void setAS_NO_OF_CLAIMS(Double as_no_of_claims) {
		AS_NO_OF_CLAIMS = as_no_of_claims;
	}

	public String getAS_REINST_POL_YN() {
		return AS_REINST_POL_YN;
	}

	public void setAS_REINST_POL_YN(String as_reinst_pol_yn) {
		AS_REINST_POL_YN = as_reinst_pol_yn;
	}

	public String getAS_MOD_ACC_FLAG_YN() {
		return AS_MOD_ACC_FLAG_YN;
	}

	public void setAS_MOD_ACC_FLAG_YN(String as_mod_acc_flag_yn) {
		AS_MOD_ACC_FLAG_YN = as_mod_acc_flag_yn;
	}

	public String getAS_ISS_DT_BACK_DATED_YN() {
		return AS_ISS_DT_BACK_DATED_YN;
	}

	public void setAS_ISS_DT_BACK_DATED_YN(String as_iss_dt_back_dated_yn) {
		AS_ISS_DT_BACK_DATED_YN = as_iss_dt_back_dated_yn;
	}

	public Double getAS_BACK_DATED_UPTO_NO_OF_DAYS() {
		return AS_BACK_DATED_UPTO_NO_OF_DAYS;
	}

	public void setAS_BACK_DATED_UPTO_NO_OF_DAYS(
			Double as_back_dated_upto_no_of_days) {
		AS_BACK_DATED_UPTO_NO_OF_DAYS = as_back_dated_upto_no_of_days;
	}

	public String getAS_POL_DEL_YN() {
		return AS_POL_DEL_YN;
	}

	public void setAS_POL_DEL_YN(String as_pol_del_yn) {
		AS_POL_DEL_YN = as_pol_del_yn;
	}

	public String getAS_PROP_APPR_YN() {
		return AS_PROP_APPR_YN;
	}

	public void setAS_PROP_APPR_YN(String as_prop_appr_yn) {
		AS_PROP_APPR_YN = as_prop_appr_yn;
	}

	public String getAS_REPRINT_YN() {
		return AS_REPRINT_YN;
	}

	public void setAS_REPRINT_YN(String as_reprint_yn) {
		AS_REPRINT_YN = as_reprint_yn;
	}

}
