package com.iii.pel.forms.PILT013;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_SURR_CHRG")
public class PT_IL_SURR_CHRG extends BaseValueBean {

	@Column(name = "SRC_SYS_ID")
	private Long SRC_SYS_ID;

	@Column(name = "SRC_SMV_SYS_ID")
	private Long SRC_SMV_SYS_ID;

	@Column(name = "SRC_CHRG_CODE")
	private String SRC_CHRG_CODE;

	@Column(name = "SRC_RATE")
	private Double SRC_RATE;

	@Column(name = "SRC_RATE_PER")
	private Double SRC_RATE_PER;

	@Column(name = "SRC_CUST_SHARE_PERC")
	private Double SRC_CUST_SHARE_PERC;

	@Column(name = "SRC_CHG_LC_VALUE")
	private Double SRC_CHG_LC_VALUE;

	@Column(name = "SRC_CHG_FC_VALUE")
	private Double SRC_CHG_FC_VALUE;

	@Column(name = "SRC_SMV_LC_VALUE")
	private Double SRC_SMV_LC_VALUE;

	@Column(name = "SRC_SMV_FC_VALUE")
	private Double SRC_SMV_FC_VALUE;

	@Column(name = "SRC_CR_DT")
	private Date SRC_CR_DT;

	@Column(name = "SRC_CR_UID")
	private String SRC_CR_UID;

	@Column(name = "SRC_UPD_DT")
	private Date SRC_UPD_DT;

	@Column(name = "SRC_UPD_UID")
	private String SRC_UPD_UID;
	
	private Double SRC_SUM_CHG;
	private Double SRC_CHG_SUM_FC;

	public void setSRC_RATE(Double SRC_RATE) {
		this.SRC_RATE = SRC_RATE;
	}

	public Double getSRC_RATE() {
		return SRC_RATE;
	}

	public void setSRC_SYS_ID(Long SRC_SYS_ID) {
		this.SRC_SYS_ID = SRC_SYS_ID;
	}

	public Long getSRC_SYS_ID() {
		return SRC_SYS_ID;
	}

	public void setSRC_SMV_FC_VALUE(Double SRC_SMV_FC_VALUE) {
		this.SRC_SMV_FC_VALUE = SRC_SMV_FC_VALUE;
	}

	public Double getSRC_SMV_FC_VALUE() {
		return SRC_SMV_FC_VALUE;
	}

	public void setSRC_CHG_FC_VALUE(Double SRC_CHG_FC_VALUE) {
		this.SRC_CHG_FC_VALUE = SRC_CHG_FC_VALUE;
	}

	public Double getSRC_CHG_FC_VALUE() {
		return SRC_CHG_FC_VALUE;
	}

	public void setSRC_CHRG_CODE(String SRC_CHRG_CODE) {
		this.SRC_CHRG_CODE = SRC_CHRG_CODE;
	}

	public String getSRC_CHRG_CODE() {
		return SRC_CHRG_CODE;
	}

	public void setSRC_SMV_SYS_ID(Long SRC_SMV_SYS_ID) {
		this.SRC_SMV_SYS_ID = SRC_SMV_SYS_ID;
	}

	public Long getSRC_SMV_SYS_ID() {
		return SRC_SMV_SYS_ID;
	}

	public void setSRC_UPD_UID(String SRC_UPD_UID) {
		this.SRC_UPD_UID = SRC_UPD_UID;
	}

	public String getSRC_UPD_UID() {
		return SRC_UPD_UID;
	}

	public void setSRC_UPD_DT(Date SRC_UPD_DT) {
		this.SRC_UPD_DT = SRC_UPD_DT;
	}

	public Date getSRC_UPD_DT() {
		return SRC_UPD_DT;
	}

	public void setSRC_CR_UID(String SRC_CR_UID) {
		this.SRC_CR_UID = SRC_CR_UID;
	}

	public String getSRC_CR_UID() {
		return SRC_CR_UID;
	}

	public void setSRC_CHG_LC_VALUE(Double SRC_CHG_LC_VALUE) {
		this.SRC_CHG_LC_VALUE = SRC_CHG_LC_VALUE;
	}

	public Double getSRC_CHG_LC_VALUE() {
		return SRC_CHG_LC_VALUE;
	}

	public void setSRC_CUST_SHARE_PERC(Double SRC_CUST_SHARE_PERC) {
		this.SRC_CUST_SHARE_PERC = SRC_CUST_SHARE_PERC;
	}

	public Double getSRC_CUST_SHARE_PERC() {
		return SRC_CUST_SHARE_PERC;
	}

	public void setSRC_SMV_LC_VALUE(Double SRC_SMV_LC_VALUE) {
		this.SRC_SMV_LC_VALUE = SRC_SMV_LC_VALUE;
	}

	public Double getSRC_SMV_LC_VALUE() {
		return SRC_SMV_LC_VALUE;
	}

	public void setSRC_RATE_PER(Double SRC_RATE_PER) {
		this.SRC_RATE_PER = SRC_RATE_PER;
	}

	public Double getSRC_RATE_PER() {
		return SRC_RATE_PER;
	}

	public void setSRC_CR_DT(Date SRC_CR_DT) {
		this.SRC_CR_DT = SRC_CR_DT;
	}

	public Date getSRC_CR_DT() {
		return SRC_CR_DT;
	}

	public Double getSRC_SUM_CHG() {
		return SRC_SUM_CHG;
	}

	public void setSRC_SUM_CHG(Double src_sum_chg) {
		SRC_SUM_CHG = src_sum_chg;
	}

	public Double getSRC_CHG_SUM_FC() {
		return SRC_CHG_SUM_FC;
	}

	public void setSRC_CHG_SUM_FC(Double src_chg_sum_fc) {
		SRC_CHG_SUM_FC = src_chg_sum_fc;
	}

	
	/*added by raja on 20-04-2017*/
	private String UI_M_SRC_CHRG_DESC;

	public String getUI_M_SRC_CHRG_DESC() {
		return UI_M_SRC_CHRG_DESC;
	}

	public void setUI_M_SRC_CHRG_DESC(String uI_M_SRC_CHRG_DESC) {
		UI_M_SRC_CHRG_DESC = uI_M_SRC_CHRG_DESC;
	}

	
	
	/*end*/
	
	/*Added by Janani on 13.02.2018 for ZB as per Sivaram's suggs.*/	
	
	private String UI_M_SRC_CHRG_CODE_DESC;

	public String getUI_M_SRC_CHRG_CODE_DESC() {
		return UI_M_SRC_CHRG_CODE_DESC;
	}

	public void setUI_M_SRC_CHRG_CODE_DESC(String uI_M_SRC_CHRG_CODE_DESC) {
		UI_M_SRC_CHRG_CODE_DESC = uI_M_SRC_CHRG_CODE_DESC;
	}

	/*End*/
}
