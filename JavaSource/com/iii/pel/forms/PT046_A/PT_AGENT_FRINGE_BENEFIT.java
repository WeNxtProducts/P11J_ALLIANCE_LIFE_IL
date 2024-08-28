package com.iii.pel.forms.PT046_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_FRINGE_BENEFIT")
public class PT_AGENT_FRINGE_BENEFIT extends BaseValueBean {

	private boolean CHECK_BOX;

	private Double M_EXCH_RATE;

	private String UI_M_AGENT_FM_CODE;

	private String UI_M_AGENT_FM_CODE_DESC;

	private String UI_M_AGENT_TO_CODE;

	private String UI_M_AGENT_TO_CODE_DESC;
	
	private String UI_M_BEN_FM_CODE;

	private String UI_M_BEN_FM_CODE_DESC;

	private String UI_M_BEN_TO_CODE;

	private String UI_M_BEN_TO_CODE_DESC;

	private Date UI_M_PROCESS_FM_DT;

	private Date UI_M_PROCESS_TO_DT;

	@Column(name="AFB_AGENT_CODE")
	private String AFB_AGENT_CODE;

	@Column(name="AFB_PROCESS_DT")
	private Date AFB_PROCESS_DT;

	@Column(name="AFB_BNF_CODE")
	private String AFB_BNF_CODE;

	@Column(name="AFB_FREQ")
	private String AFB_FREQ;

	@Column(name="AFB_FC_VALUE")
	private Double AFB_FC_VALUE;

	@Column(name="AFB_LC_VALUE")
	private Double AFB_LC_VALUE;

	@Column(name="AFB_PAID_DT")
	private Date AFB_PAID_DT;

	@Column(name="AFB_FRZ_FLAG")
	private String AFB_FRZ_FLAG;

	private String UI_M_AGENT_NAME;

	@Column(name="AFB_PAID_FLAG")
	private String AFB_PAID_FLAG;

	@Column(name="AFB_CURR_CODE")
	private String AFB_CURR_CODE;
	
	
	
	
	private boolean disableFrzFlag;
	
	
	
	
	/*Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Screen as suggested by sivaraman*/
	private String FIELD1_ENABLE;
	private String FIELD2_ENABLE;

	public String getFIELD1_ENABLE() {
		return FIELD1_ENABLE;
	}
	public void setFIELD1_ENABLE(String fIELD1_ENABLE) {
		FIELD1_ENABLE = fIELD1_ENABLE;
	}
	public String getFIELD2_ENABLE() {
		return FIELD2_ENABLE;
	}
	public void setFIELD2_ENABLE(String fIELD2_ENABLE) {
		FIELD2_ENABLE = fIELD2_ENABLE;
	}
	
	
	/*End Newly Added by pidugu raj dt: 11-09-2018 for Benefit Details Screen as suggested by sivaraman*/
	
	


	public String getUI_M_AGENT_FM_CODE() {
		return UI_M_AGENT_FM_CODE;
	}

	public void setUI_M_AGENT_FM_CODE(String UI_M_AGENT_FM_CODE) {
		this.UI_M_AGENT_FM_CODE = UI_M_AGENT_FM_CODE;
	}

	public String getUI_M_AGENT_FM_CODE_DESC() {
		return UI_M_AGENT_FM_CODE_DESC;
	}

	public void setUI_M_AGENT_FM_CODE_DESC(String UI_M_AGENT_FM_CODE_DESC) {
		this.UI_M_AGENT_FM_CODE_DESC = UI_M_AGENT_FM_CODE_DESC;
	}

	public String getUI_M_AGENT_TO_CODE() {
		return UI_M_AGENT_TO_CODE;
	}

	public void setUI_M_AGENT_TO_CODE(String UI_M_AGENT_TO_CODE) {
		this.UI_M_AGENT_TO_CODE = UI_M_AGENT_TO_CODE;
	}

	public String getUI_M_AGENT_TO_CODE_DESC() {
		return UI_M_AGENT_TO_CODE_DESC;
	}

	public void setUI_M_AGENT_TO_CODE_DESC(String UI_M_AGENT_TO_CODE_DESC) {
		this.UI_M_AGENT_TO_CODE_DESC = UI_M_AGENT_TO_CODE_DESC;
	}

	public Date getUI_M_PROCESS_FM_DT() {
		return UI_M_PROCESS_FM_DT;
	}

	public void setUI_M_PROCESS_FM_DT(Date UI_M_PROCESS_FM_DT) {
		this.UI_M_PROCESS_FM_DT = UI_M_PROCESS_FM_DT;
	}

	public Date getUI_M_PROCESS_TO_DT() {
		return UI_M_PROCESS_TO_DT;
	}

	public void setUI_M_PROCESS_TO_DT(Date UI_M_PROCESS_TO_DT) {
		this.UI_M_PROCESS_TO_DT = UI_M_PROCESS_TO_DT;
	}

	public String getAFB_AGENT_CODE() {
		return AFB_AGENT_CODE;
	}

	public void setAFB_AGENT_CODE(String AFB_AGENT_CODE) {
		this.AFB_AGENT_CODE = AFB_AGENT_CODE;
	}

	public Date getAFB_PROCESS_DT() {
		return AFB_PROCESS_DT;
	}

	public void setAFB_PROCESS_DT(Date AFB_PROCESS_DT) {
		this.AFB_PROCESS_DT = AFB_PROCESS_DT;
	}

	public String getAFB_BNF_CODE() {
		return AFB_BNF_CODE;
	}

	public void setAFB_BNF_CODE(String AFB_BNF_CODE) {
		this.AFB_BNF_CODE = AFB_BNF_CODE;
	}

	public String getAFB_FREQ() {
		return AFB_FREQ;
	}

	public void setAFB_FREQ(String AFB_FREQ) {
		this.AFB_FREQ = AFB_FREQ;
	}

	public Double getAFB_FC_VALUE() {
		return AFB_FC_VALUE;
	}

	public void setAFB_FC_VALUE(Double AFB_FC_VALUE) {
		this.AFB_FC_VALUE = AFB_FC_VALUE;
	}

	public Double getAFB_LC_VALUE() {
		return AFB_LC_VALUE;
	}

	public void setAFB_LC_VALUE(Double AFB_LC_VALUE) {
		this.AFB_LC_VALUE = AFB_LC_VALUE;
	}

	public Date getAFB_PAID_DT() {
		return AFB_PAID_DT;
	}

	public void setAFB_PAID_DT(Date AFB_PAID_DT) {
		this.AFB_PAID_DT = AFB_PAID_DT;
	}

	public String getAFB_FRZ_FLAG() {
		return AFB_FRZ_FLAG;
	}

	public void setAFB_FRZ_FLAG(String AFB_FRZ_FLAG) {
		this.AFB_FRZ_FLAG = AFB_FRZ_FLAG;
	}

	public String getUI_M_AGENT_NAME() {
		return UI_M_AGENT_NAME;
	}

	public void setUI_M_AGENT_NAME(String UI_M_AGENT_NAME) {
		this.UI_M_AGENT_NAME = UI_M_AGENT_NAME;
	}

	public String getAFB_PAID_FLAG() {
		return AFB_PAID_FLAG;
	}

	public void setAFB_PAID_FLAG(String afb_paid_flag) {
		AFB_PAID_FLAG = afb_paid_flag;
	}

	public String getAFB_CURR_CODE() {
		return AFB_CURR_CODE;
	}

	public void setAFB_CURR_CODE(String afb_curr_code) {
		AFB_CURR_CODE = afb_curr_code;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getM_EXCH_RATE() {
		return M_EXCH_RATE;
	}

	public void setM_EXCH_RATE(Double m_exch_rate) {
		M_EXCH_RATE = m_exch_rate;
	}

	public boolean isDisableFrzFlag() {
		return disableFrzFlag;
	}

	public void setDisableFrzFlag(boolean disableFrzFlag) {
		this.disableFrzFlag = disableFrzFlag;
	}

	public String getUI_M_BEN_FM_CODE() {
		return UI_M_BEN_FM_CODE;
	}

	public void setUI_M_BEN_FM_CODE(String UI_M_BEN_FM_CODE) {
		this.UI_M_BEN_FM_CODE = UI_M_BEN_FM_CODE;
	}

	public String getUI_M_BEN_FM_CODE_DESC() {
		return UI_M_BEN_FM_CODE_DESC;
	}

	public void setUI_M_BEN_FM_CODE_DESC(String UI_M_BEN_FM_CODE_DESC) {
		this.UI_M_BEN_FM_CODE_DESC = UI_M_BEN_FM_CODE_DESC;
	}

	public String getUI_M_BEN_TO_CODE() {
		return UI_M_BEN_TO_CODE;
	}

	public void setUI_M_BEN_TO_CODE(String UI_M_BEN_TO_CODE) {
		this.UI_M_BEN_TO_CODE = UI_M_BEN_TO_CODE;
	}

	public String getUI_M_BEN_TO_CODE_DESC() {
		return UI_M_BEN_TO_CODE_DESC;
	}

	public void setUI_M_BEN_TO_CODE_DESC(String UI_M_BEN_TO_CODE_DESC) {
		this.UI_M_BEN_TO_CODE_DESC = UI_M_BEN_TO_CODE_DESC;
	}
	
	
	
}
