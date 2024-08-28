package com.iii.pel.forms.PILP086_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_HIBAH_FEE_PRCSS")
public class PT_IL_HIBAH_FEE_PRCSS extends BaseValueBean {

	@Column(name="HFP_SYS_ID")
	private Long HFP_SYS_ID;

	@Column(name="HFP_PRCSS_YN")
	private String HFP_PRCSS_YN;
	
	@Column(name="HFP_AGE")
	private int HFP_AGE;
	
	@Column(name="HFP_CR_UID")
	private String HFP_CR_UID;
	
	@Column(name="HFP_POL_NO")
	private String HFP_POL_NO;
	
	@Column(name="HFP_CR_DT")
	private Date HFP_CR_DT;

	/**
	 * @return the hFP_PRCSS_YN
	 */
	public String getHFP_PRCSS_YN() {
		return HFP_PRCSS_YN;
	}

	/**
	 * @param hfp_prcss_yn the hFP_PRCSS_YN to set
	 */
	public void setHFP_PRCSS_YN(String hfp_prcss_yn) {
		HFP_PRCSS_YN = hfp_prcss_yn;
	}

	/**
	 * @return the hFP_SYS_ID
	 */
	public Long getHFP_SYS_ID() {
		return HFP_SYS_ID;
	}

	/**
	 * @param hfp_sys_id the hFP_SYS_ID to set
	 */
	public void setHFP_SYS_ID(Long hfp_sys_id) {
		HFP_SYS_ID = hfp_sys_id;
	}

	/**
	 * @return the hFP_CR_UID
	 */
	public String getHFP_CR_UID() {
		return HFP_CR_UID;
	}

	/**
	 * @param hfp_cr_uid the hFP_CR_UID to set
	 */
	public void setHFP_CR_UID(String hfp_cr_uid) {
		HFP_CR_UID = hfp_cr_uid;
	}

	/**
	 * @return the hFP_CR_DT
	 */
	public Date getHFP_CR_DT() {
		return HFP_CR_DT;
	}

	/**
	 * @param hfp_cr_dt the hFP_CR_DT to set
	 */
	public void setHFP_CR_DT(Date hfp_cr_dt) {
		HFP_CR_DT = hfp_cr_dt;
	}

	/**
	 * @return the hFP_POL_NO
	 */
	public String getHFP_POL_NO() {
		return HFP_POL_NO;
	}

	/**
	 * @param hfp_pol_no the hFP_POL_NO to set
	 */
	public void setHFP_POL_NO(String hfp_pol_no) {
		HFP_POL_NO = hfp_pol_no;
	}

	/**
	 * @return the hFP_AGE
	 */
	public int getHFP_AGE() {
		return HFP_AGE;
	}

	/**
	 * @param hfp_age the hFP_AGE to set
	 */
	public void setHFP_AGE(int hfp_age) {
		HFP_AGE = hfp_age;
	}

	
}

