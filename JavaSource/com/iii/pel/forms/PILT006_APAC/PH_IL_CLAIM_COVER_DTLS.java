package com.iii.pel.forms.PILT006_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PH_IL_CLAIM_COVER_DTLS")
public class PH_IL_CLAIM_COVER_DTLS extends BaseValueBean {

	@Column(name="CCDH_SYS_ID")
	private Long CCDH_SYS_ID;

	@Column(name="CCDH_CLAIM_SYS_ID")
	private Long CCDH_CLAIM_SYS_ID;

	@Column(name="CCDH_REF_NO")
	private Double CCDH_REF_NO;

	@Column(name="CCDH_COVER_CODE")
	private String CCDH_COVER_CODE;

	@Column(name="CCDH_LOSS_TYPE")
	private String CCDH_LOSS_TYPE;

	@Column(name="CCDH_DISAB_TYPE")
	private String CCDH_DISAB_TYPE;

	@Column(name="CCDH_PERIOD_UNIT")
	private String CCDH_PERIOD_UNIT;

	@Column(name="CCDH_PERIOD")
	private Double CCDH_PERIOD;

	@Column(name="CCDH_RATE")
	private Double CCDH_RATE;

	@Column(name="CCDH_RATE_PER")
	private Double CCDH_RATE_PER;

	@Column(name="CCDH_O_FC_EST_AMT")
	private Double CCDH_O_FC_EST_AMT;

	@Column(name="CCDH_O_LC_EST_AMT")
	private Double CCDH_O_LC_EST_AMT;

	@Column(name="CCDH_N_FC_EST_AMT")
	private Double CCDH_N_FC_EST_AMT;

	@Column(name="CCDH_N_LC_EST_AMT")
	private Double CCDH_N_LC_EST_AMT;

	@Column(name="CCDH_FRZ_FLAG")
	private String CCDH_FRZ_FLAG;

	@Column(name="CCDH_CLOSE_FLAG")
	private String CCDH_CLOSE_FLAG;

	@Column(name="CCDH_CLOSE_DT")
	private Date CCDH_CLOSE_DT;

	@Column(name="CCDH_CONFIRM_FLAG")
	private String CCDH_CONFIRM_FLAG;

	@Column(name="CCDH_RESERVE_GEN_FLAG")
	private String CCDH_RESERVE_GEN_FLAG;

	@Column(name="CCDH_CR_UID")
	private String CCDH_CR_UID;

	@Column(name="CCDH_CR_DT")
	private Date CCDH_CR_DT;

	@Column(name="CCDH_UPD_UID")
	private String CCDH_UPD_UID;

	@Column(name="CCDH_UPD_DT")
	private Date CCDH_UPD_DT;

	@Column(name="CCDH_SET_FLAG")
	private String CCDH_SET_FLAG;

	@Column(name="CCDH_O_RESERVE_DT")
	private Date CCDH_O_RESERVE_DT;

	@Column(name="CCDH_N_RESERVE_DT")
	private Date CCDH_N_RESERVE_DT;

	@Column(name="CCDH_PROD_CODE")
	private String CCDH_PROD_CODE;

	@Column(name="CCDH_COVER_GROUP_CODE")
	private String CCDH_COVER_GROUP_CODE;

	private String UI_M_CCDH_COVER_CODE_DESC;
	private String UI_M_CCDH_LOSS_TYPE_DESC;
	private String UI_M_CCDH_DISAB_TYPE_DESC;
	public void setCCDH_CONFIRM_FLAG(String CCDH_CONFIRM_FLAG) {
		this.CCDH_CONFIRM_FLAG = CCDH_CONFIRM_FLAG;
	}
	public String getCCDH_CONFIRM_FLAG() {
		 return CCDH_CONFIRM_FLAG;
	}
	public void setCCDH_PERIOD_UNIT(String CCDH_PERIOD_UNIT) {
		this.CCDH_PERIOD_UNIT = CCDH_PERIOD_UNIT;
	}
	public String getCCDH_PERIOD_UNIT() {
		 return CCDH_PERIOD_UNIT;
	}
	public void setCCDH_RATE_PER(Double CCDH_RATE_PER) {
		this.CCDH_RATE_PER = CCDH_RATE_PER;
	}
	public Double getCCDH_RATE_PER() {
		 return CCDH_RATE_PER;
	}
	public void setCCDH_N_RESERVE_DT(Date CCDH_N_RESERVE_DT) {
		this.CCDH_N_RESERVE_DT = CCDH_N_RESERVE_DT;
	}
	public Date getCCDH_N_RESERVE_DT() {
		 return CCDH_N_RESERVE_DT;
	}
	public void setCCDH_CLOSE_DT(Date CCDH_CLOSE_DT) {
		this.CCDH_CLOSE_DT = CCDH_CLOSE_DT;
	}
	public Date getCCDH_CLOSE_DT() {
		 return CCDH_CLOSE_DT;
	}
	public void setCCDH_CLAIM_SYS_ID(Long CCDH_CLAIM_SYS_ID) {
		this.CCDH_CLAIM_SYS_ID = CCDH_CLAIM_SYS_ID;
	}
	public Long getCCDH_CLAIM_SYS_ID() {
		 return CCDH_CLAIM_SYS_ID;
	}
	public void setUI_M_CCDH_LOSS_TYPE_DESC(String UI_M_CCDH_LOSS_TYPE_DESC) {
		this.UI_M_CCDH_LOSS_TYPE_DESC = UI_M_CCDH_LOSS_TYPE_DESC;
	}
	public String getUI_M_CCDH_LOSS_TYPE_DESC() {
		 return UI_M_CCDH_LOSS_TYPE_DESC;
	}
	public void setCCDH_LOSS_TYPE(String CCDH_LOSS_TYPE) {
		this.CCDH_LOSS_TYPE = CCDH_LOSS_TYPE;
	}
	public String getCCDH_LOSS_TYPE() {
		 return CCDH_LOSS_TYPE;
	}
	public void setCCDH_REF_NO(Double CCDH_REF_NO) {
		this.CCDH_REF_NO = CCDH_REF_NO;
	}
	public Double getCCDH_REF_NO() {
		 return CCDH_REF_NO;
	}
	public void setUI_M_CCDH_COVER_CODE_DESC(String UI_M_CCDH_COVER_CODE_DESC) {
		this.UI_M_CCDH_COVER_CODE_DESC = UI_M_CCDH_COVER_CODE_DESC;
	}
	public String getUI_M_CCDH_COVER_CODE_DESC() {
		 return UI_M_CCDH_COVER_CODE_DESC;
	}
	public void setCCDH_CR_UID(String CCDH_CR_UID) {
		this.CCDH_CR_UID = CCDH_CR_UID;
	}
	public String getCCDH_CR_UID() {
		 return CCDH_CR_UID;
	}
	public void setCCDH_COVER_CODE(String CCDH_COVER_CODE) {
		this.CCDH_COVER_CODE = CCDH_COVER_CODE;
	}
	public String getCCDH_COVER_CODE() {
		 return CCDH_COVER_CODE;
	}
	public void setUI_M_CCDH_DISAB_TYPE_DESC(String UI_M_CCDH_DISAB_TYPE_DESC) {
		this.UI_M_CCDH_DISAB_TYPE_DESC = UI_M_CCDH_DISAB_TYPE_DESC;
	}
	public String getUI_M_CCDH_DISAB_TYPE_DESC() {
		 return UI_M_CCDH_DISAB_TYPE_DESC;
	}
	public void setCCDH_N_FC_EST_AMT(Double CCDH_N_FC_EST_AMT) {
		this.CCDH_N_FC_EST_AMT = CCDH_N_FC_EST_AMT;
	}
	public Double getCCDH_N_FC_EST_AMT() {
		 return CCDH_N_FC_EST_AMT;
	}
	public void setCCDH_SYS_ID(Long CCDH_SYS_ID) {
		this.CCDH_SYS_ID = CCDH_SYS_ID;
	}
	public Long getCCDH_SYS_ID() {
		 return CCDH_SYS_ID;
	}
	public void setCCDH_N_LC_EST_AMT(Double CCDH_N_LC_EST_AMT) {
		this.CCDH_N_LC_EST_AMT = CCDH_N_LC_EST_AMT;
	}
	public Double getCCDH_N_LC_EST_AMT() {
		 return CCDH_N_LC_EST_AMT;
	}
	public void setCCDH_DISAB_TYPE(String CCDH_DISAB_TYPE) {
		this.CCDH_DISAB_TYPE = CCDH_DISAB_TYPE;
	}
	public String getCCDH_DISAB_TYPE() {
		 return CCDH_DISAB_TYPE;
	}
	public void setCCDH_FRZ_FLAG(String CCDH_FRZ_FLAG) {
		this.CCDH_FRZ_FLAG = CCDH_FRZ_FLAG;
	}
	public String getCCDH_FRZ_FLAG() {
		 return CCDH_FRZ_FLAG;
	}
	public void setCCDH_UPD_UID(String CCDH_UPD_UID) {
		this.CCDH_UPD_UID = CCDH_UPD_UID;
	}
	public String getCCDH_UPD_UID() {
		 return CCDH_UPD_UID;
	}
	public void setCCDH_O_LC_EST_AMT(Double CCDH_O_LC_EST_AMT) {
		this.CCDH_O_LC_EST_AMT = CCDH_O_LC_EST_AMT;
	}
	public Double getCCDH_O_LC_EST_AMT() {
		 return CCDH_O_LC_EST_AMT;
	}
	public void setCCDH_COVER_GROUP_CODE(String CCDH_COVER_GROUP_CODE) {
		this.CCDH_COVER_GROUP_CODE = CCDH_COVER_GROUP_CODE;
	}
	public String getCCDH_COVER_GROUP_CODE() {
		 return CCDH_COVER_GROUP_CODE;
	}
	public void setCCDH_RATE(Double CCDH_RATE) {
		this.CCDH_RATE = CCDH_RATE;
	}
	public Double getCCDH_RATE() {
		 return CCDH_RATE;
	}
	public void setCCDH_SET_FLAG(String CCDH_SET_FLAG) {
		this.CCDH_SET_FLAG = CCDH_SET_FLAG;
	}
	public String getCCDH_SET_FLAG() {
		 return CCDH_SET_FLAG;
	}
	public void setCCDH_CLOSE_FLAG(String CCDH_CLOSE_FLAG) {
		this.CCDH_CLOSE_FLAG = CCDH_CLOSE_FLAG;
	}
	public String getCCDH_CLOSE_FLAG() {
		 return CCDH_CLOSE_FLAG;
	}
	public void setCCDH_RESERVE_GEN_FLAG(String CCDH_RESERVE_GEN_FLAG) {
		this.CCDH_RESERVE_GEN_FLAG = CCDH_RESERVE_GEN_FLAG;
	}
	public String getCCDH_RESERVE_GEN_FLAG() {
		 return CCDH_RESERVE_GEN_FLAG;
	}
	public void setCCDH_O_FC_EST_AMT(Double CCDH_O_FC_EST_AMT) {
		this.CCDH_O_FC_EST_AMT = CCDH_O_FC_EST_AMT;
	}
	public Double getCCDH_O_FC_EST_AMT() {
		 return CCDH_O_FC_EST_AMT;
	}
	public void setCCDH_PERIOD(Double CCDH_PERIOD) {
		this.CCDH_PERIOD = CCDH_PERIOD;
	}
	public Double getCCDH_PERIOD() {
		 return CCDH_PERIOD;
	}
	public void setCCDH_UPD_DT(Date CCDH_UPD_DT) {
		this.CCDH_UPD_DT = CCDH_UPD_DT;
	}
	public Date getCCDH_UPD_DT() {
		 return CCDH_UPD_DT;
	}
	public void setCCDH_CR_DT(Date CCDH_CR_DT) {
		this.CCDH_CR_DT = CCDH_CR_DT;
	}
	public Date getCCDH_CR_DT() {
		 return CCDH_CR_DT;
	}
	public void setCCDH_O_RESERVE_DT(Date CCDH_O_RESERVE_DT) {
		this.CCDH_O_RESERVE_DT = CCDH_O_RESERVE_DT;
	}
	public Date getCCDH_O_RESERVE_DT() {
		 return CCDH_O_RESERVE_DT;
	}
	public void setCCDH_PROD_CODE(String CCDH_PROD_CODE) {
		this.CCDH_PROD_CODE = CCDH_PROD_CODE;
	}
	public String getCCDH_PROD_CODE() {
		 return CCDH_PROD_CODE;
	}

}
