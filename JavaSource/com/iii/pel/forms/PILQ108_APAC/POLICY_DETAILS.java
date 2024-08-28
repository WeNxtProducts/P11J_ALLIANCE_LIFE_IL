package com.iii.pel.forms.PILQ108_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_POLICY")
public class POLICY_DETAILS extends BaseValueBean {
	
	@Column(name="POL_STATUS")
	private String POL_STATUS;
	
	private String POL_STATUS_DESC;
	
	@Column(name="POL_ADDL_STATUS")
	private String POL_ADDL_STATUS;
	
	private String UI_M_POL_ADDL_STATUS_DESC;
	
	private String POL_NO;
	
	private String POL_PROP_NO;
	
	private Date POL_START_DT;
	
	private Date POL_EXPIRY_DT;
	
	private String UI_POL_START_DT;
	
	private String UI_POL_EXPIRY_DT;
	
	/**
	 * @return the pOL_NO
	 */
	public String getPOL_NO() {
		return POL_NO;
	}

	/**
	 * @param pol_no the pOL_NO to set
	 */
	public void setPOL_NO(String pol_no) {
		POL_NO = pol_no;
	}

	/**
	 * @return the pOL_PROP_NO
	 */
	public String getPOL_PROP_NO() {
		return POL_PROP_NO;
	}

	/**
	 * @param pol_prop_no the pOL_PROP_NO to set
	 */
	public void setPOL_PROP_NO(String pol_prop_no) {
		POL_PROP_NO = pol_prop_no;
	}

	/**
	 * @return the pOL_START_DT
	 */
	public Date getPOL_START_DT() {
		return POL_START_DT;
	}

	/**
	 * @param pol_start_dt the pOL_START_DT to set
	 */
	public void setPOL_START_DT(Date pol_start_dt) {
		POL_START_DT = pol_start_dt;
		UI_POL_START_DT = CommonUtils.dateToPELStringFormatter(POL_START_DT);
	}
	
	public String getUI_POL_START_DT() {
		return UI_POL_START_DT;
	}	
	
	public void setUI_POL_START_DT(String ui_pol_start_dt) {
		UI_POL_START_DT = ui_pol_start_dt;
	}


	/**
	 * @return the pOL_EXPIRY_DT
	 */
	public Date getPOL_EXPIRY_DT() {
		return POL_EXPIRY_DT;
	}

	/**
	 * @param pol_expiry_dt the pOL_EXPIRY_DT to set
	 */
	public void setPOL_EXPIRY_DT(Date pol_expiry_dt) {
		POL_EXPIRY_DT = pol_expiry_dt;
		UI_POL_EXPIRY_DT = CommonUtils.dateToPELStringFormatter(POL_EXPIRY_DT);
	}
	
	public String getUI_POL_EXPIRY_DT() {
		return UI_POL_EXPIRY_DT;
	}
	
	public void setUI_POL_EXPIRY_DT(String ui_pol_expiry_dt) {
		UI_POL_EXPIRY_DT = ui_pol_expiry_dt;
	}

	/**
	 * @return the uI_M_POL_ADDL_STATUS_DESC
	 */
	public String getUI_M_POL_ADDL_STATUS_DESC() {
		return UI_M_POL_ADDL_STATUS_DESC;
	}

	/**
	 * @param ui_m_pol_addl_status_desc the uI_M_POL_ADDL_STATUS_DESC to set
	 */
	public void setUI_M_POL_ADDL_STATUS_DESC(String ui_m_pol_addl_status_desc) {
		UI_M_POL_ADDL_STATUS_DESC = ui_m_pol_addl_status_desc;
	}

	/**
	 * @return the pOL_STATUS_DESC
	 */
	public String getPOL_STATUS_DESC() {
		return POL_STATUS_DESC;
	}

	/**
	 * @param pol_status_desc the pOL_STATUS_DESC to set
	 */
	public void setPOL_STATUS_DESC(String pol_status_desc) {
		POL_STATUS_DESC = pol_status_desc;
	}

	/**
	 * @return the pOL_STATUS
	 */
	public String getPOL_STATUS() {
		return POL_STATUS;
	}

	/**
	 * @param pol_status the pOL_STATUS to set
	 */
	public void setPOL_STATUS(String pol_status) {
		POL_STATUS = pol_status;
	}

	/**
	 * @return the pOL_ADDL_STATUS
	 */
	public String getPOL_ADDL_STATUS() {
		return POL_ADDL_STATUS;
	}

	/**
	 * @param pol_addl_status the pOL_ADDL_STATUS to set
	 */
	public void setPOL_ADDL_STATUS(String pol_addl_status) {
		POL_ADDL_STATUS = pol_addl_status;
	}


	

}
