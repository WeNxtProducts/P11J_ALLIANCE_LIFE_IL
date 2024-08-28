package com.iii.pel.forms.PILT002_APAC_QE;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PW_IL_QQUOT_APPL_COVER")
public class PW_IL_QQUOT_APPL_COVER extends BaseValueBean{

	

	@Column(name="QQAC_SYS_ID")
	private Long QQAC_SYS_ID;
	
	@Column(name="QQAC_QUOT_SYS_ID")
	private Long QQAC_QUOT_SYS_ID;
	
	public Long getQQAC_QUOT_SYS_ID() {
		return QQAC_QUOT_SYS_ID;
	}

	public void setQQAC_QUOT_SYS_ID(Long qQAC_QUOT_SYS_ID) {
		QQAC_QUOT_SYS_ID = qQAC_QUOT_SYS_ID;
	}

	@Column(name="QQAC_QQAD_SYS_ID")
	private Long QQAC_QQAD_SYS_ID;
	
	@Column(name="QQAC_COVER_CODE")
	private String QQAC_COVER_CODE;
	
	@Column(name="QQAC_PREM_CALC_TYPE")
	private String QQAC_PREM_CALC_TYPE;
	
	@Column(name="QQAC_FC_SA")
	private Double QQAC_FC_SA;
	
	@Column(name="QQAC_LC_SA")
	private Double QQAC_LC_SA;
	
	@Column(name="QQAC_PREM_FC")
	private Double QQAC_PREM_FC;
	
	@Column(name="QQAC_PREM_LC")
	private Double QQAC_PREM_LC;
	
	@Column(name="QQAC_PERIOD")
	private Integer QQAC_PERIOD;
	
	@Column(name="QQAC_PREM_PAY_YRS")
	private Integer QQAC_PREM_PAY_YRS;
	
	@Column(name="QQAC_CR_UID")
	private String QQAC_CR_UID;
	
	@Column(name="QQAC_CR_DT")
	private Date QQAC_CR_DT;
	
	@Column(name="QQAC_UPD_UID")
	private String QQAC_UPD_UID;
	
	@Column(name="QQAC_UPD_DT")
	private Date QQAC_UPD_DT;
	
	@Column(name="QQAC_EFF_FM_DT")
	private Date QQAC_EFF_FM_DT;
	
	private String UI_EFF_FM_DT;
	private String UI_EFF_TO_DT;
	
	
	private String UI_M_QQAT_COVER_DESC;
	
	private String UI_M_QQAT_MAND_YN;
	
	
	
	public String getUI_M_QQAT_MAND_YN() {
		return UI_M_QQAT_MAND_YN;
	}

	public void setUI_M_QQAT_MAND_YN(String uI_M_QQAT_MAND_YN) {
		UI_M_QQAT_MAND_YN = uI_M_QQAT_MAND_YN;
	}

	public String getUI_M_QQAT_COVER_DESC() {
		return UI_M_QQAT_COVER_DESC;
	}

	public void setUI_M_QQAT_COVER_DESC(String uI_M_QQAT_COVER_DESC) {
		UI_M_QQAT_COVER_DESC = uI_M_QQAT_COVER_DESC;
	}

	public Date getQQAC_EFF_FM_DT() {
		return QQAC_EFF_FM_DT;
	}

	public void setQQAC_EFF_FM_DT(Date qQAC_EFF_FM_DT) {
		QQAC_EFF_FM_DT = qQAC_EFF_FM_DT;
	}

	public String getUI_EFF_FM_DT() {
		return UI_EFF_FM_DT;
	}

	public void setUI_EFF_FM_DT(String uI_EFF_FM_DT) {
		UI_EFF_FM_DT = uI_EFF_FM_DT;
	}

	public String getUI_EFF_TO_DT() {
		return UI_EFF_TO_DT;
	}

	public void setUI_EFF_TO_DT(String uI_EFF_TO_DT) {
		UI_EFF_TO_DT = uI_EFF_TO_DT;
	}

	public Date getQQAC_EFF_TO_DT() {
		return QQAC_EFF_TO_DT;
	}

	public void setQQAC_EFF_TO_DT(Date qQAC_EFF_TO_DT) {
		QQAC_EFF_TO_DT = qQAC_EFF_TO_DT;
	}

	public Double getQQAC_RATE() {
		return QQAC_RATE;
	}

	public void setQQAC_RATE(Double qQAC_RATE) {
		QQAC_RATE = qQAC_RATE;
	}

	
	public int getQQAC_RATE_PER() {
		return QQAC_RATE_PER;
	}

	public void setQQAC_RATE_PER(int qQAC_RATE_PER) {
		QQAC_RATE_PER = qQAC_RATE_PER;
	}

	@Column(name="QQAC_EFF_TO_DT")
	private Date QQAC_EFF_TO_DT;
	
	@Column(name="QQAC_RATE")
	private Double QQAC_RATE;
	
	@Column(name="QQAC_RATE_PER")
	private int QQAC_RATE_PER;
	
	
	private String UI_QQAC_PREM_LC;
	private String  UI_QQAC_FC_SA;

	
	
	
	

	public String getUI_QQAC_FC_SA() {
		return UI_QQAC_FC_SA;
	}

	public void setUI_QQAC_FC_SA(String uI_QQAC_FC_SA) {
		UI_QQAC_FC_SA = uI_QQAC_FC_SA;
	}

	public String getUI_QQAC_PREM_LC() {
		return UI_QQAC_PREM_LC;
	}

	public void setUI_QQAC_PREM_LC(String uI_QQAC_PREM_LC) {
		UI_QQAC_PREM_LC = uI_QQAC_PREM_LC;
	}

	public Long getQQAC_SYS_ID() {
		return QQAC_SYS_ID;
	}

	public void setQQAC_SYS_ID(Long qqac_sys_id) {
		QQAC_SYS_ID = qqac_sys_id;
	}

	public Long getQQAC_QQAD_SYS_ID() {
		return QQAC_QQAD_SYS_ID;
	}

	public void setQQAC_QQAD_SYS_ID(Long qqac_qqad_sys_id) {
		QQAC_QQAD_SYS_ID = qqac_qqad_sys_id;
	}

	public String getQQAC_COVER_CODE() {
		return QQAC_COVER_CODE;
	}

	public void setQQAC_COVER_CODE(String qqac_cover_code) {
		QQAC_COVER_CODE = qqac_cover_code;
	}

	public String getQQAC_PREM_CALC_TYPE() {
		return QQAC_PREM_CALC_TYPE;
	}

	public void setQQAC_PREM_CALC_TYPE(String qqac_prem_calc_type) {
		QQAC_PREM_CALC_TYPE = qqac_prem_calc_type;
	}

	
	public Double getQQAC_FC_SA() {
		return QQAC_FC_SA;
	}

	public void setQQAC_FC_SA(Double qQAC_FC_SA) {
		QQAC_FC_SA = qQAC_FC_SA;
	}

	public Double getQQAC_LC_SA() {
		return QQAC_LC_SA;
	}

	public void setQQAC_LC_SA(Double qQAC_LC_SA) {
		QQAC_LC_SA = qQAC_LC_SA;
	}

	public Double getQQAC_PREM_FC() {
		return QQAC_PREM_FC;
	}

	public void setQQAC_PREM_FC(Double qqac_prem_fc) {
		QQAC_PREM_FC = qqac_prem_fc;
	}

	public Double getQQAC_PREM_LC() {
		return QQAC_PREM_LC;
	}

	public void setQQAC_PREM_LC(Double qqac_prem_lc) {
		QQAC_PREM_LC = qqac_prem_lc;
	}

	public Integer getQQAC_PERIOD() {
		return QQAC_PERIOD;
	}

	public void setQQAC_PERIOD(Integer qqac_period) {
		QQAC_PERIOD = qqac_period;
	}

	public Integer getQQAC_PREM_PAY_YRS() {
		return QQAC_PREM_PAY_YRS;
	}

	public void setQQAC_PREM_PAY_YRS(Integer qqac_prem_pay_yrs) {
		QQAC_PREM_PAY_YRS = qqac_prem_pay_yrs;
	}

	public String getQQAC_CR_UID() {
		return QQAC_CR_UID;
	}

	public void setQQAC_CR_UID(String qqac_cr_uid) {
		QQAC_CR_UID = qqac_cr_uid;
	}

	public Date getQQAC_CR_DT() {
		return QQAC_CR_DT;
	}

	public void setQQAC_CR_DT(Date qqac_cr_dt) {
		QQAC_CR_DT = qqac_cr_dt;
	}

	public String getQQAC_UPD_UID() {
		return QQAC_UPD_UID;
	}

	public void setQQAC_UPD_UID(String qqac_upd_uid) {
		QQAC_UPD_UID = qqac_upd_uid;
	}

	public Date getQQAC_UPD_DT() {
		return QQAC_UPD_DT;
	}

	public void setQQAC_UPD_DT(Date qqac_upd_dt) {
		QQAC_UPD_DT = qqac_upd_dt;
	}
	
	
	private String  UI_QQAC_RATE;

	public String getUI_QQAC_RATE() {
		return UI_QQAC_RATE;
	}

	public void setUI_QQAC_RATE(String uI_QQAC_RATE) {
		UI_QQAC_RATE = uI_QQAC_RATE;
	}

	private String  UI_QQAC_RATE_PER;
	
	public String getUI_QQAC_RATE_PER() {
		return UI_QQAC_RATE_PER;
	}

	public void setUI_QQAC_RATE_PER(String uI_QQAC_RATE_PER) {
		UI_QQAC_RATE_PER = uI_QQAC_RATE_PER;
	}
	
	/*Added By jagadeesh For the Field EMR Rate*/
	
	private String UI_QQAC_EMR_RATE;
	
	@Column(name="QQAC_EMR_RATE")
	private Double QQAC_EMR_RATE;

	public String getUI_QQAC_EMR_RATE() {
		return UI_QQAC_EMR_RATE;
	}

	public void setUI_QQAC_EMR_RATE(String uI_QQAC_EMR_RATE) {
		UI_QQAC_EMR_RATE = uI_QQAC_EMR_RATE;
	}

	public Double getQQAC_EMR_RATE() {
		return QQAC_EMR_RATE;
	}

	public void setQQAC_EMR_RATE(Double qQAC_EMR_RATE) {
		QQAC_EMR_RATE = qQAC_EMR_RATE;
	}
	
	private String COVER_DESC;

	public String getCOVER_DESC() {
		return COVER_DESC;
	}

	public void setCOVER_DESC(String cOVER_DESC) {
		COVER_DESC = cOVER_DESC;
	}
	
	/*Added by sankaraNarayanan for additional cover premium calculation*/
	
	@Column(name="QQAC_RATE_APPLIED_ON")
	public String QQAC_RATE_APPLIED_ON;

	public String getQQAC_RATE_APPLIED_ON() {
		return QQAC_RATE_APPLIED_ON;
	}

	public void setQQAC_RATE_APPLIED_ON(String qQAC_RATE_APPLIED_ON) {
		QQAC_RATE_APPLIED_ON = qQAC_RATE_APPLIED_ON;
	}
	
	/*END*/
	
	/*Added by Ram on 05/11/2016 for term validation in Post entry level*/
	private Integer QQAC_PERIOD_COPY;

	public Integer getQQAC_PERIOD_COPY() {
		return QQAC_PERIOD_COPY;
	}

	public void setQQAC_PERIOD_COPY(Integer qQAC_PERIOD_COPY) {
		QQAC_PERIOD_COPY = qQAC_PERIOD_COPY;
	}
	/*End*/
}
