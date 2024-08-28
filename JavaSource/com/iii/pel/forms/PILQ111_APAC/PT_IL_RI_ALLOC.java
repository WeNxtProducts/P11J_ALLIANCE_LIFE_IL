package com.iii.pel.forms.PILQ111_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_RI_ALLOC")
public class PT_IL_RI_ALLOC extends BaseValueBean {

	@Column(name="RIA_DIVN_CODE")
	private String RIA_DIVN_CODE;
	
	private Double RIA_SYS_ID;
	
	private String RIA_SRC_OF_BUS;
	
	private String RIA_CLASS_CODE;
	
	private Integer RIA_UW_YEAR;
	
	private String RIA_APPRV_STATUS;
	
	private String RIA_NB_REN_FLAG;
	
	private Double RIA_SRNO;
	
	private String RIA_TTY_CODE;

	private Date RIA_APPRV_DT;
	
	private String UI_M_DIVN_DESC;

	@Column(name="RIA_DEPT_CODE")
	private String RIA_DEPT_CODE;

	private String UI_M_DEPT_DESC;

	@Column(name="RIA_PROD_CODE")
	private String RIA_PROD_CODE;

	private String UI_M_PROD_DESC;

	@Column(name="RIA_COVER_CODE")
	private String RIA_COVER_CODE;

	private String UI_M_COVER_DESC;

	@Column(name="RIA_TTY_TYPE")
	private String RIA_TTY_TYPE;

	@Column(name="RIA_LC_PREMIUM")
	private Double RIA_LC_PREMIUM;

	@Column(name="RIA_FC_PREMIUM")
	private Double RIA_FC_PREMIUM;

	@Column(name="RIA_LC_COMMISSION")
	private Double RIA_LC_COMMISSION;

	@Column(name="RIA_FC_COMMISSION")
	private Double RIA_FC_COMMISSION;

	@Column(name="RIA_CLM_PAID")
	private Double RIA_CLM_PAID;

	@Column(name="RIA_CLAIMS_OS")
	private Double RIA_CLAIMS_OS;

	@Column(name="RIA_FM_DT")
	private Date RIA_FM_DT;

	@Column(name="RIA_TO_DT")
	private Date RIA_TO_DT;
	
	public String UI_FM_DT;
	
	public String UI_TO_DT;



	public String getRIA_DIVN_CODE() {
		return RIA_DIVN_CODE;
	}

	public void setRIA_DIVN_CODE(String RIA_DIVN_CODE) {
		this.RIA_DIVN_CODE = RIA_DIVN_CODE;
	}

	public String getUI_M_DIVN_DESC() {
		return UI_M_DIVN_DESC;
	}

	public void setUI_M_DIVN_DESC(String UI_M_DIVN_DESC) {
		this.UI_M_DIVN_DESC = UI_M_DIVN_DESC;
	}

	public String getRIA_DEPT_CODE() {
		return RIA_DEPT_CODE;
	}

	public void setRIA_DEPT_CODE(String RIA_DEPT_CODE) {
		this.RIA_DEPT_CODE = RIA_DEPT_CODE;
	}

	public String getUI_M_DEPT_DESC() {
		return UI_M_DEPT_DESC;
	}

	public void setUI_M_DEPT_DESC(String UI_M_DEPT_DESC) {
		this.UI_M_DEPT_DESC = UI_M_DEPT_DESC;
	}

	public String getRIA_PROD_CODE() {
		return RIA_PROD_CODE;
	}

	public void setRIA_PROD_CODE(String RIA_PROD_CODE) {
		this.RIA_PROD_CODE = RIA_PROD_CODE;
	}

	public String getUI_M_PROD_DESC() {
		return UI_M_PROD_DESC;
	}

	public void setUI_M_PROD_DESC(String UI_M_PROD_DESC) {
		this.UI_M_PROD_DESC = UI_M_PROD_DESC;
	}

	public String getRIA_COVER_CODE() {
		return RIA_COVER_CODE;
	}

	public void setRIA_COVER_CODE(String RIA_COVER_CODE) {
		this.RIA_COVER_CODE = RIA_COVER_CODE;
	}

	public String getUI_M_COVER_DESC() {
		return UI_M_COVER_DESC;
	}

	public void setUI_M_COVER_DESC(String UI_M_COVER_DESC) {
		this.UI_M_COVER_DESC = UI_M_COVER_DESC;
	}

	public String getRIA_TTY_TYPE() {
		return RIA_TTY_TYPE;
	}

	public void setRIA_TTY_TYPE(String RIA_TTY_TYPE) {
		this.RIA_TTY_TYPE = RIA_TTY_TYPE;
	}

	public Double getRIA_LC_PREMIUM() {
		return RIA_LC_PREMIUM;
	}

	public void setRIA_LC_PREMIUM(Double RIA_LC_PREMIUM) {
		this.RIA_LC_PREMIUM = RIA_LC_PREMIUM;
	}

	public Double getRIA_FC_PREMIUM() {
		return RIA_FC_PREMIUM;
	}

	public void setRIA_FC_PREMIUM(Double RIA_FC_PREMIUM) {
		this.RIA_FC_PREMIUM = RIA_FC_PREMIUM;
	}

	public Double getRIA_LC_COMMISSION() {
		return RIA_LC_COMMISSION;
	}

	public void setRIA_LC_COMMISSION(Double RIA_LC_COMMISSION) {
		this.RIA_LC_COMMISSION = RIA_LC_COMMISSION;
	}

	public Double getRIA_FC_COMMISSION() {
		return RIA_FC_COMMISSION;
	}

	public void setRIA_FC_COMMISSION(Double RIA_FC_COMMISSION) {
		this.RIA_FC_COMMISSION = RIA_FC_COMMISSION;
	}

	public Double getRIA_CLM_PAID() {
		return RIA_CLM_PAID;
	}

	public void setRIA_CLM_PAID(Double RIA_CLM_PAID) {
		this.RIA_CLM_PAID = RIA_CLM_PAID;
	}

	public Double getRIA_CLAIMS_OS() {
		return RIA_CLAIMS_OS;
	}

	public void setRIA_CLAIMS_OS(Double RIA_CLAIMS_OS) {
		this.RIA_CLAIMS_OS = RIA_CLAIMS_OS;
	}

	public Date getRIA_FM_DT() {
		 return RIA_FM_DT;
	}

	public void setRIA_FM_DT(Date RIA_FM_DT) {
		setUI_FM_DT(new CommonUtils().dateToStringFormat(RIA_FM_DT));
		this.RIA_FM_DT = RIA_FM_DT;
	}

	public Date getRIA_TO_DT() {
		 return RIA_TO_DT;
	}

	public void setRIA_TO_DT(Date RIA_TO_DT) {
		setUI_TO_DT(new CommonUtils().dateToStringFormat(RIA_TO_DT));
		this.RIA_TO_DT = RIA_TO_DT;
	}

	public Double getRIA_SYS_ID() {
		return RIA_SYS_ID;
	}

	public void setRIA_SYS_ID(Double ria_sys_id) {
		RIA_SYS_ID = ria_sys_id;
	}

	public String getRIA_TTY_CODE() {
		return RIA_TTY_CODE;
	}

	public void setRIA_TTY_CODE(String ria_tty_code) {
		RIA_TTY_CODE = ria_tty_code;
	}

	public Double getRIA_SRNO() {
		return RIA_SRNO;
	}

	public void setRIA_SRNO(Double ria_srno) {
		RIA_SRNO = ria_srno;
	}

	public Integer getRIA_UW_YEAR() {
		return RIA_UW_YEAR;
	}

	public void setRIA_UW_YEAR(Integer ria_uw_year) {
		RIA_UW_YEAR = ria_uw_year;
	}

	public Date getRIA_APPRV_DT() {
		return RIA_APPRV_DT;
	}

	public void setRIA_APPRV_DT(Date ria_apprv_dt) {
		RIA_APPRV_DT = ria_apprv_dt;
	}

	public String getRIA_APPRV_STATUS() {
		return RIA_APPRV_STATUS;
	}

	public void setRIA_APPRV_STATUS(String ria_apprv_status) {
		RIA_APPRV_STATUS = ria_apprv_status;
	}

	public String getRIA_NB_REN_FLAG() {
		return RIA_NB_REN_FLAG;
	}

	public void setRIA_NB_REN_FLAG(String ria_nb_ren_flag) {
		RIA_NB_REN_FLAG = ria_nb_ren_flag;
	}

	public String getRIA_CLASS_CODE() {
		return RIA_CLASS_CODE;
	}

	public void setRIA_CLASS_CODE(String ria_class_code) {
		RIA_CLASS_CODE = ria_class_code;
	}

	public String getRIA_SRC_OF_BUS() {
		return RIA_SRC_OF_BUS;
	}

	public void setRIA_SRC_OF_BUS(String ria_src_of_bus) {
		RIA_SRC_OF_BUS = ria_src_of_bus;
	}

	public String getUI_FM_DT() {
		return UI_FM_DT;
	}

	public void setUI_FM_DT(String ui_fm_dt) {
		UI_FM_DT = ui_fm_dt;
	}

	public String getUI_TO_DT() {
		return UI_TO_DT;
	}

	public void setUI_TO_DT(String ui_to_dt) {
		UI_TO_DT = ui_to_dt;
	}
}
