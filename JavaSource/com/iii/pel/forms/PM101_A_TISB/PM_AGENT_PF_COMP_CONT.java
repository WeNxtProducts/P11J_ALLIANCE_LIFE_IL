package com.iii.pel.forms.PM101_A_TISB;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_PF_COMP_CONT")
public class PM_AGENT_PF_COMP_CONT extends BaseValueBean {

	@Column(name="APCC_MKT_CODE")
	private String APCC_MKT_CODE;

	private String UI_M_APCC_MKT_CODE_DESC;

	@Column(name="APCC_RANK_CODE")
	private String APCC_RANK_CODE;

	private String UI_M_APCC_RANK_CODE_DESC;

	@Column(name="APCC_PROD_TYPE")
	private String APCC_PROD_TYPE;

	@Column(name="APCC_CONT_TYPE")
	private String APCC_CONT_TYPE;

	@Column(name="APCC_CONT_FM")
	private Double APCC_CONT_FM;

	@Column(name="APCC_CONT_TO")
	private Double APCC_CONT_TO;

	@Column(name="APCC_RATE")
	private Double APCC_RATE;

	@Column(name="APCC_RATE_PER")
	private Double APCC_RATE_PER;

	@Column(name="APCC_EFF_FM_DT")
	private Date APCC_EFF_FM_DT;

	@Column(name="APCC_EFF_TO_DT")
	private Date APCC_EFF_TO_DT;
	
	@Column(name="APCC_CR_UID")
	private String APCC_CR_UID;
	
	@Column(name="APCC_CR_DT")
	private Date APCC_CR_DT;
	
	@Column(name="APCC_UPD_UID")
	private String APCC_UPD_UID;
	
	@Column(name="APCC_UPD_DT")
	private Date APCC_UPD_DT;

	private boolean selected;
	
	private String searchText;


	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getAPCC_MKT_CODE() {
		return APCC_MKT_CODE;
	}

	public void setAPCC_MKT_CODE(String APCC_MKT_CODE) {
		this.APCC_MKT_CODE = APCC_MKT_CODE;
	}

	public String getUI_M_APCC_MKT_CODE_DESC() {
		return UI_M_APCC_MKT_CODE_DESC;
	}

	public void setUI_M_APCC_MKT_CODE_DESC(String UI_M_APCC_MKT_CODE_DESC) {
		this.UI_M_APCC_MKT_CODE_DESC = UI_M_APCC_MKT_CODE_DESC;
	}

	public String getAPCC_RANK_CODE() {
		return APCC_RANK_CODE;
	}

	public void setAPCC_RANK_CODE(String APCC_RANK_CODE) {
		this.APCC_RANK_CODE = APCC_RANK_CODE;
	}

	public String getUI_M_APCC_RANK_CODE_DESC() {
		return UI_M_APCC_RANK_CODE_DESC;
	}

	public void setUI_M_APCC_RANK_CODE_DESC(String UI_M_APCC_RANK_CODE_DESC) {
		this.UI_M_APCC_RANK_CODE_DESC = UI_M_APCC_RANK_CODE_DESC;
	}

	public String getAPCC_PROD_TYPE() {
		return APCC_PROD_TYPE;
	}

	public void setAPCC_PROD_TYPE(String APCC_PROD_TYPE) {
		this.APCC_PROD_TYPE = APCC_PROD_TYPE;
	}

	public String getAPCC_CONT_TYPE() {
		return APCC_CONT_TYPE;
	}

	public void setAPCC_CONT_TYPE(String APCC_CONT_TYPE) {
		this.APCC_CONT_TYPE = APCC_CONT_TYPE;
	}

	public Double getAPCC_CONT_FM() {
		return APCC_CONT_FM;
	}

	public void setAPCC_CONT_FM(Double APCC_CONT_FM) {
		this.APCC_CONT_FM = APCC_CONT_FM;
	}

	public Double getAPCC_CONT_TO() {
		return APCC_CONT_TO;
	}

	public void setAPCC_CONT_TO(Double APCC_CONT_TO) {
		this.APCC_CONT_TO = APCC_CONT_TO;
	}

	public Double getAPCC_RATE() {
		return APCC_RATE;
	}

	public void setAPCC_RATE(Double APCC_RATE) {
		this.APCC_RATE = APCC_RATE;
	}

	public Double getAPCC_RATE_PER() {
		return APCC_RATE_PER;
	}

	public void setAPCC_RATE_PER(Double APCC_RATE_PER) {
		this.APCC_RATE_PER = APCC_RATE_PER;
	}

	public Date getAPCC_EFF_FM_DT() {
		 return APCC_EFF_FM_DT;
	}

	public void setAPCC_EFF_FM_DT(Date APCC_EFF_FM_DT) {
		this.APCC_EFF_FM_DT = APCC_EFF_FM_DT;
	}

	public Date getAPCC_EFF_TO_DT() {
		 return APCC_EFF_TO_DT;
	}

	public void setAPCC_EFF_TO_DT(Date APCC_EFF_TO_DT) {
		this.APCC_EFF_TO_DT = APCC_EFF_TO_DT;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getAPCC_CR_UID() {
		return APCC_CR_UID;
	}

	public void setAPCC_CR_UID(String apcc_cr_uid) {
		APCC_CR_UID = apcc_cr_uid;
	}

	public Date getAPCC_CR_DT() {
		return APCC_CR_DT;
	}

	public void setAPCC_CR_DT(Date apcc_cr_dt) {
		APCC_CR_DT = apcc_cr_dt;
	}

	public String getAPCC_UPD_UID() {
	    return APCC_UPD_UID;
	}

	public void setAPCC_UPD_UID(String apcc_upd_uid) {
	    APCC_UPD_UID = apcc_upd_uid;
	}

	public Date getAPCC_UPD_DT() {
	    return APCC_UPD_DT;
	}

	public void setAPCC_UPD_DT(Date apcc_upd_dt) {
	    APCC_UPD_DT = apcc_upd_dt;
	}
}
