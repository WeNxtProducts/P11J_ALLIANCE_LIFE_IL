package com.iii.pel.forms.PILP086_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_HIBAH_FEE_HDR")
public class DUMMY1 extends BaseValueBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="HFH_SYS_ID")
	private Long HFH_SYS_ID;

	@Column(name="HFH_POL_NO_FM")
	private String HFH_POL_NO_FM;
	
	@Column(name="HFH_POL_NO_TO")
	private String HFH_POL_NO_TO;

	@Column(name="HFH_DATE_FM")
	private Date HFH_DATE_FM;
	/**
	 * @return the hFH_POL_NO_FM
	 */
	public String getHFH_POL_NO_FM() {
		return HFH_POL_NO_FM;
	}
	/**
	 * @param hfh_pol_no_fm the hFH_POL_NO_FM to set
	 */
	public void setHFH_POL_NO_FM(String hfh_pol_no_fm) {
		HFH_POL_NO_FM = hfh_pol_no_fm;
	}
	/**
	 * @return the hFH_POL_NO_TO
	 */
	public String getHFH_POL_NO_TO() {
		return HFH_POL_NO_TO;
	}
	/**
	 * @param hfh_pol_no_to the hFH_POL_NO_TO to set
	 */
	public void setHFH_POL_NO_TO(String hfh_pol_no_to) {
		HFH_POL_NO_TO = hfh_pol_no_to;
	}
	/**
	 * @return the hFH_DATE_FM
	 */
	public Date getHFH_DATE_FM() {
		return HFH_DATE_FM;
	}
	/**
	 * @param hfh_date_fm the hFH_DATE_FM to set
	 */
	public void setHFH_DATE_FM(Date hfh_date_fm) {
		HFH_DATE_FM = hfh_date_fm;
	}
	/**
	 * @return the hFH_SYS_ID
	 */
	public Long getHFH_SYS_ID() {
		return HFH_SYS_ID;
	}
	/**
	 * @param hfh_sys_id the hFH_SYS_ID to set
	 */
	public void setHFH_SYS_ID(Long hfh_sys_id) {
		HFH_SYS_ID = hfh_sys_id;
	}
	
}

