package com.iii.pel.forms.PILT006_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_CLAIM_CHARGES")
public class PT_IL_CLAIM_CHRG extends BaseValueBean {

	@Column(name = "CC_SYS_ID")
	private Long CC_SYS_ID;

	public Long getCC_SYS_ID() {
		return CC_SYS_ID;
	}

	public void setCC_SYS_ID(Long cC_SYS_ID) {
		CC_SYS_ID = cC_SYS_ID;
	}

	@Column(name ="CC_CLM_SYS_ID")
	private Long CC_CLM_SYS_ID;

	
	public Long getCC_CLM_SYS_ID() {
		return CC_CLM_SYS_ID;
	}

	public void setCC_CLM_SYS_ID(Long cC_CLM_SYS_ID) {
		CC_CLM_SYS_ID = cC_CLM_SYS_ID;
	}

	@Column(name = "CC_CHRG_CODE")
	private String CC_CHRG_CODE;
	
	public String getCC_CHRG_CODE() {
		return CC_CHRG_CODE;
	}

	public void setCC_CHRG_CODE(String cC_CHRG_CODE) {
		CC_CHRG_CODE = cC_CHRG_CODE;
	}
	
	@Column(name = "CC_RATE")
	private Double CC_RATE;

	public Double getCC_RATE() {
		return CC_RATE;
	}

	public void setCC_RATE(Double cC_RATE) {
		CC_RATE = cC_RATE;
	}

	@Column(name = "CC_RATE_PER")
	private Double CC_RATE_PER;

	@Column(name = "CC_CHRG_LC_VALUE")
	private Double CC_CHRG_LC_VALUE;

	@Column(name = "CC_CHRG_FC_VALUE")
	private Double CC_CHRG_FC_VALUE;

	public Double getCC_CHRG_LC_VALUE() {
		return CC_CHRG_LC_VALUE;
	}

	public void setCC_CHRG_LC_VALUE(Double cC_CHRG_LC_VALUE) {
		CC_CHRG_LC_VALUE = cC_CHRG_LC_VALUE;
	}

	@Column(name = "CC_REMARKS")
	private String CC_REMARKS;

	

	public String getCC_REMARKS() {
		return CC_REMARKS;
	}

	public void setCC_REMARKS(String cC_REMARKS) {
		CC_REMARKS = cC_REMARKS;
	}

	

	public Double getCC_RATE_PER() {
		return CC_RATE_PER;
	}

	public void setCC_RATE_PER(Double cC_RATE_PER) {
		CC_RATE_PER = cC_RATE_PER;
	}

	public Double getCC_CHRG_FC_VALUE() {
		return CC_CHRG_FC_VALUE;
	}

	public void setCC_CHRG_FC_VALUE(Double cC_CHRG_FC_VALUE) {
		CC_CHRG_FC_VALUE = cC_CHRG_FC_VALUE;
	}
	private String UI_M_CC_CHRG_CODE_DESC;

	public String getUI_M_CC_CHRG_CODE_DESC() {
		return UI_M_CC_CHRG_CODE_DESC;
	}

	public void setUI_M_CC_CHRG_CODE_DESC(String uI_M_CC_CHRG_CODE_DESC) {
		UI_M_CC_CHRG_CODE_DESC = uI_M_CC_CHRG_CODE_DESC;
	}
	
	
/*added by raja on 25-04-2017*/
	
	@Column(name = "CC_PAID_TO")
	private String CC_PAID_TO;
	
	@Column(name = "CC_BENF_CODE")
	private String CC_BENF_CODE;

	private String CC_BENF_CODE_DESC;
	
	public String getCC_BENF_CODE_DESC() {
		return CC_BENF_CODE_DESC;
	}

	public void setCC_BENF_CODE_DESC(String cC_BENF_CODE_DESC) {
		CC_BENF_CODE_DESC = cC_BENF_CODE_DESC;
	}

	public String getCC_PAID_TO() {
		return CC_PAID_TO;
	}

	public void setCC_PAID_TO(String cC_PAID_TO) {
		CC_PAID_TO = cC_PAID_TO;
	}

	public String getCC_BENF_CODE() {
		return CC_BENF_CODE;
	}

	public void setCC_BENF_CODE(String cC_BENF_CODE) {
		CC_BENF_CODE = cC_BENF_CODE;
	}
	
	/*end*/
	
	
}
