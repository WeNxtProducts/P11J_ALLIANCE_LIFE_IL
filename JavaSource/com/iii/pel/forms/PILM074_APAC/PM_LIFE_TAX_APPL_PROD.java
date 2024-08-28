package com.iii.pel.forms.PILM074_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_LIFE_TAX_APPL_PROD")
public class PM_LIFE_TAX_APPL_PROD extends BaseValueBean {

	@Column(name="TAP_PROD_CODE")
	private String TAP_PROD_CODE;

	private String TAP_PROD_CODE_DESC;

	@Column(name="TAP_EFF_FM_DT")
	private Date TAP_EFF_FM_DT;

	@Column(name="TAP_EFF_TO_DT")
	private Date TAP_EFF_TO_DT;

	private boolean checkBoxValue;
	
	@Column(name="TAP_TH_TAX_TYPE")
	private String TAP_TH_TAX_TYPE;
	
	@Column(name="TAP_CR_DT")
	private Date TAP_CR_DT;
	
	@Column(name="TAP_CR_UID")
	private String TAP_CR_UID;
	
	@Column(name="TAP_UPD_DT")
	private Date TAP_UPD_DT;
	
	@Column(name="TAP_UPD_UID")
	private String TAP_UPD_UID;
	
	public String getTAP_TH_TAX_TYPE() {
		return TAP_TH_TAX_TYPE;
	}

	public void setTAP_TH_TAX_TYPE(String tap_th_tax_type) {
		TAP_TH_TAX_TYPE = tap_th_tax_type;
	}

	public boolean isCheckBoxValue() {
		return checkBoxValue;
	}

	public void setCheckBoxValue(boolean checkBoxValue) {
		this.checkBoxValue = checkBoxValue;
	}

	public String getTAP_PROD_CODE() {
		return TAP_PROD_CODE;
	}

	public void setTAP_PROD_CODE(String TAP_PROD_CODE) {
		this.TAP_PROD_CODE = TAP_PROD_CODE;
	}

	public String getTAP_PROD_CODE_DESC() {
		return TAP_PROD_CODE_DESC;
	}

	public void setTAP_PROD_CODE_DESC(String TAP_PROD_CODE_DESC) {
		this.TAP_PROD_CODE_DESC = TAP_PROD_CODE_DESC;
	}

	public Date getTAP_EFF_FM_DT() {
		 return TAP_EFF_FM_DT;
	}

	public void setTAP_EFF_FM_DT(Date TAP_EFF_FM_DT) {
		this.TAP_EFF_FM_DT = TAP_EFF_FM_DT;
	}

	public Date getTAP_EFF_TO_DT() {
		 return TAP_EFF_TO_DT;
	}

	public void setTAP_EFF_TO_DT(Date TAP_EFF_TO_DT) {
		this.TAP_EFF_TO_DT = TAP_EFF_TO_DT;
	}

	public Date getTAP_CR_DT() {
		return TAP_CR_DT;
	}

	public void setTAP_CR_DT(Date tap_cr_dt) {
		TAP_CR_DT = tap_cr_dt;
	}

	public String getTAP_CR_UID() {
		return TAP_CR_UID;
	}

	public void setTAP_CR_UID(String tap_cr_uid) {
		TAP_CR_UID = tap_cr_uid;
	}

	public Date getTAP_UPD_DT() {
		return TAP_UPD_DT;
	}

	public void setTAP_UPD_DT(Date tap_upd_dt) {
		TAP_UPD_DT = tap_upd_dt;
	}

	public String getTAP_UPD_UID() {
		return TAP_UPD_UID;
	}

	public void setTAP_UPD_UID(String tap_upd_uid) {
		TAP_UPD_UID = tap_upd_uid;
	}
	//Added by kavitha on 04.10.2019 for orient
	@Column(name="TAP_PROD_CODE_TO")
	private String TAP_PROD_CODE_TO;
	
	@Column(name="TAP_RIDER_FM")
	private String TAP_RIDER_FM;
	
	@Column(name="TAP_RIDER_TO")
	private String TAP_RIDER_TO;
	
	private String TAP_PROD_CODE_TO_DESC;
	
	private String TAP_RIDER_FM_DESC;
	
	private String TAP_RIDER_TO_DESC;

	public String getTAP_PROD_CODE_TO() {
		return TAP_PROD_CODE_TO;
	}

	public void setTAP_PROD_CODE_TO(String tAP_PROD_CODE_TO) {
		TAP_PROD_CODE_TO = tAP_PROD_CODE_TO;
	}

	public String getTAP_PROD_CODE_TO_DESC() {
		return TAP_PROD_CODE_TO_DESC;
	}

	public void setTAP_PROD_CODE_TO_DESC(String tAP_PROD_CODE_TO_DESC) {
		TAP_PROD_CODE_TO_DESC = tAP_PROD_CODE_TO_DESC;
	}

	public String getTAP_RIDER_FM() {
		return TAP_RIDER_FM;
	}

	public void setTAP_RIDER_FM(String tAP_RIDER_FM) {
		TAP_RIDER_FM = tAP_RIDER_FM;
	}

	public String getTAP_RIDER_TO() {
		return TAP_RIDER_TO;
	}

	public void setTAP_RIDER_TO(String tAP_RIDER_TO) {
		TAP_RIDER_TO = tAP_RIDER_TO;
	}

	public String getTAP_RIDER_FM_DESC() {
		return TAP_RIDER_FM_DESC;
	}

	public void setTAP_RIDER_FM_DESC(String tAP_RIDER_FM_DESC) {
		TAP_RIDER_FM_DESC = tAP_RIDER_FM_DESC;
	}

	public String getTAP_RIDER_TO_DESC() {
		return TAP_RIDER_TO_DESC;
	}

	public void setTAP_RIDER_TO_DESC(String tAP_RIDER_TO_DESC) {
		TAP_RIDER_TO_DESC = tAP_RIDER_TO_DESC;
	}
    /*Added  by senthilnathan for Orient Suggested by girish*/
	@Column(name="TAP_CHANNEL_FM")
	private String TAP_CHANNEL_FM;
	
	@Column(name="TAP_CHANNEL_TO")
	private String TAP_CHANNEL_TO;

	public String getTAP_CHANNEL_FM() {
		return TAP_CHANNEL_FM;
	}

	public void setTAP_CHANNEL_FM(String tAP_CHANNEL_FM) {
		TAP_CHANNEL_FM = tAP_CHANNEL_FM;
	}

	public String getTAP_CHANNEL_TO() {
		return TAP_CHANNEL_TO;
	}

	public void setTAP_CHANNEL_TO(String tAP_CHANNEL_TO) {
		TAP_CHANNEL_TO = tAP_CHANNEL_TO;
	}
	private String TAP_CHANNEL_FM_DESC;
	private String TAP_CHANNEL_TO_DESC;

	public String getTAP_CHANNEL_FM_DESC() {
		return TAP_CHANNEL_FM_DESC;
	}

	public void setTAP_CHANNEL_FM_DESC(String tAP_CHANNEL_FM_DESC) {
		TAP_CHANNEL_FM_DESC = tAP_CHANNEL_FM_DESC;
	}

	public String getTAP_CHANNEL_TO_DESC() {
		return TAP_CHANNEL_TO_DESC;
	}

	public void setTAP_CHANNEL_TO_DESC(String tAP_CHANNEL_TO_DESC) {
		TAP_CHANNEL_TO_DESC = tAP_CHANNEL_TO_DESC;
	}
	
	
			
	/*end*/
	
}
