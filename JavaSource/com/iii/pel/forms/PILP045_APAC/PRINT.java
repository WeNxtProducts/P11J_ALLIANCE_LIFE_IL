package com.iii.pel.forms.PILP045_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="")
public class PRINT {

	private String UI_M_POL_NO;

	@Column(name="UI_M_WD_PROD_TYPE")
	private String UI_M_WD_PROD_TYPE;

	@Column(name="UI_M_WD_STATUS_CODE")
	private String UI_M_WD_STATUS_CODE;

	@Column(name="UI_M_PRINTYPE1")
	private String UI_M_PRINTYPE1;
	
	private String M_POL_NO;
	private String M_WD_PROD_TYPE;
	private String M_WD_STATUS_CODE;
	private String M_PRINTYPE1;
	
	
	public String getM_WD_STATUS_CODE() {
		return M_WD_STATUS_CODE;
	}

	public void setM_WD_STATUS_CODE(String m_wd_status_code) {
		M_WD_STATUS_CODE = m_wd_status_code;
	}

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}

	public String getUI_M_WD_PROD_TYPE() {
		return UI_M_WD_PROD_TYPE;
	}

	public void setUI_M_WD_PROD_TYPE(String UI_M_WD_PROD_TYPE) {
		this.UI_M_WD_PROD_TYPE = UI_M_WD_PROD_TYPE;
	}

	public String getUI_M_WD_STATUS_CODE() {
		return UI_M_WD_STATUS_CODE;
	}

	public void setUI_M_WD_STATUS_CODE(String UI_M_WD_STATUS_CODE) {
		this.UI_M_WD_STATUS_CODE = UI_M_WD_STATUS_CODE;
	}

	public String getUI_M_PRINTYPE1() {
		return UI_M_PRINTYPE1;
	}

	public void setUI_M_PRINTYPE1(String UI_M_PRINTYPE1) {
		this.UI_M_PRINTYPE1 = UI_M_PRINTYPE1;
	}

	public String getM_POL_NO() {
		return M_POL_NO;
	}

	public void setM_POL_NO(String m_pol_no) {
		M_POL_NO = m_pol_no;
	}

	public String getM_WD_PROD_TYPE() {
		return M_WD_PROD_TYPE;
	}

	public void setM_WD_PROD_TYPE(String m_wd_prod_type) {
		M_WD_PROD_TYPE = m_wd_prod_type;
	}

	public String getM_PRINTYPE1() {
		return M_PRINTYPE1;
	}

	public void setM_PRINTYPE1(String m_printype1) {
		M_PRINTYPE1 = m_printype1;
	}
	
}
