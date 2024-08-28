package com.iii.pel.forms.PILM035_APAC;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_INVEST_PREM_DEDC")
public class PM_IL_PROD_INVEST_PREM_DEDC extends BaseValueBean{

	@Column(name = "PIPD_PROD_CODE")
	private String PIPD_PROD_CODE;
	
	@Column(name = "PIPD_SRNO")
	private Integer PIPD_SRNO;
	
	@Column(name = "PIPD_TYPE")
	private String PIPD_TYPE;
	
	@Column(name = "PIPD_CODE")
	private String PIPD_CODE;
	
	@Column(name = "PIPD_INCL_PREM_YN")
	private String PIPD_INCL_PREM_YN;
	
	@Column(name = "PIPD_CR_DT")
	private Date PIPD_CR_DT;
	
	@Column(name = "PIPD_CR_UID")
	private String PIPD_CR_UID;
	
	@Column(name = "PIPD_DEDC_YN")
	private String PIPD_DEDC_YN;
	
	private String UI_M_PIPD_CODE_DESC;
	
	
	
	

	public String getUI_M_PIPD_CODE_DESC() {
		return UI_M_PIPD_CODE_DESC;
	}

	public void setUI_M_PIPD_CODE_DESC(String ui_m_pipd_code_desc) {
		UI_M_PIPD_CODE_DESC = ui_m_pipd_code_desc;
	}

	public String getPIPD_PROD_CODE() {
		return PIPD_PROD_CODE;
	}

	public void setPIPD_PROD_CODE(String pipd_prod_code) {
		PIPD_PROD_CODE = pipd_prod_code;
	}

	public Integer getPIPD_SRNO() {
		return PIPD_SRNO;
	}

	public void setPIPD_SRNO(Integer pipd_srno) {
		PIPD_SRNO = pipd_srno;
	}

	public String getPIPD_TYPE() {
		return PIPD_TYPE;
	}

	public void setPIPD_TYPE(String pipd_type) {
		PIPD_TYPE = pipd_type;
	}

	public String getPIPD_CODE() {
		return PIPD_CODE;
	}

	public void setPIPD_CODE(String pipd_code) {
		PIPD_CODE = pipd_code;
	}

	public String getPIPD_INCL_PREM_YN() {
		return PIPD_INCL_PREM_YN;
	}

	public void setPIPD_INCL_PREM_YN(String pipd_incl_prem_yn) {
		PIPD_INCL_PREM_YN = pipd_incl_prem_yn;
	}

	public String getPIPD_DEDC_YN() {
		return PIPD_DEDC_YN;
	}

	public void setPIPD_DEDC_YN(String pipd_dedc_yn) {
		PIPD_DEDC_YN = pipd_dedc_yn;
	}

	public Date getPIPD_CR_DT() {
		return PIPD_CR_DT;
	}

	public void setPIPD_CR_DT(Date pipd_cr_dt) {
		PIPD_CR_DT = pipd_cr_dt;
	}

	public String getPIPD_CR_UID() {
		return PIPD_CR_UID;
	}

	public void setPIPD_CR_UID(String pipd_cr_uid) {
		PIPD_CR_UID = pipd_cr_uid;
	}
	
	
	
	/*NEWLY ADDED BY DHINESH ON 12-06-2017 */
	
	private String UI_M_PIPD_TYPE_DESC;

	public String getUI_M_PIPD_TYPE_DESC() {
		return UI_M_PIPD_TYPE_DESC;
	}

	public void setUI_M_PIPD_TYPE_DESC(String uI_M_PIPD_TYPE_DESC) {
		UI_M_PIPD_TYPE_DESC = uI_M_PIPD_TYPE_DESC;
	}
	
	/* END */
	
	
	
}
