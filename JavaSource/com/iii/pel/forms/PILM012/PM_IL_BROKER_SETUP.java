package com.iii.pel.forms.PILM012;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_BROKER_SETUP")
public class PM_IL_BROKER_SETUP extends BaseValueBean {

	@Column(name="BS_CUST_CLASS")
	private String BS_CUST_CLASS;

	@Column(name="BS_COVER_CODE")
	private String BS_COVER_CODE;
	
	private String UI_M_CUST_CLASS_DESC;
	
	private String UI_M_COVER_DESC;

	@Column(name="BS_YEARS_FROM")
	private Integer BS_YEARS_FROM;

	@Column(name="BS_YEARS_TO")
	private Integer BS_YEARS_TO;

	@Column(name="BS_PERC")
	private Double BS_PERC;

	@Column(name="BS_CR_DT")
	private Date BS_CR_DT;

	@Column(name="BS_CR_UID")
	private String BS_CR_UID;

	@Column(name="BS_UPD_DT")
	private Date BS_UPD_DT;

	@Column(name="BS_UPD_UID")
	private String BS_UPD_UID;

	@Column(name="BS_COMM_CODE")
	private String BS_COMM_CODE;

	@Column(name="BS_TERM_FM")
	private Integer BS_TERM_FM;

	@Column(name="BS_TERM_TO")
	private Integer BS_TERM_TO;

	@Column(name="BS_SA_FM")
	private Double BS_SA_FM;

	@Column(name="BS_SA_TO")
	private Double BS_SA_TO;

	@Column(name="BS_RATE_PER")
	private Double BS_RATE_PER;
	

	@Column(name="BS_APPLY_ON")
	private String BS_APPLY_ON;

	@Column(name="BS_EFF_FM_DT")
	private Date BS_EFF_FM_DT;

	@Column(name="BS_EFF_TO_DT")
	private Date BS_EFF_TO_DT;

	public void setBS_PERC(Double BS_PERC) {
		this.BS_PERC = BS_PERC;
	}
	public Double getBS_PERC() {
		 return BS_PERC;
	}
	public void setBS_SA_TO(Double BS_SA_TO) {
		this.BS_SA_TO = BS_SA_TO;
	}
	public Double getBS_SA_TO() {
		 return BS_SA_TO;
	}
	
	public void setBS_CR_DT(Date BS_CR_DT) {
		this.BS_CR_DT = BS_CR_DT;
	}
	public Date getBS_CR_DT() {
		 return BS_CR_DT;
	}
	public void setBS_APPLY_ON(String BS_APPLY_ON) {
		this.BS_APPLY_ON = BS_APPLY_ON;
	}
	public String getBS_APPLY_ON() {
		 return BS_APPLY_ON;
	}
	public void setBS_RATE_PER(Double BS_RATE_PER) {
		this.BS_RATE_PER = BS_RATE_PER;
	}
	public Double getBS_RATE_PER() {
		 return BS_RATE_PER;
	}
	public void setBS_CR_UID(String BS_CR_UID) {
		this.BS_CR_UID = BS_CR_UID;
	}
	public String getBS_CR_UID() {
		 return BS_CR_UID;
	}
	public void setBS_EFF_FM_DT(Date BS_EFF_FM_DT) {
		this.BS_EFF_FM_DT = BS_EFF_FM_DT;
	}
	public Date getBS_EFF_FM_DT() {
		 return BS_EFF_FM_DT;
	}
	public void setBS_CUST_CLASS(String BS_CUST_CLASS) {
		this.BS_CUST_CLASS = BS_CUST_CLASS;
	}
	public String getBS_CUST_CLASS() {
		 return BS_CUST_CLASS;
	}
	public void setBS_COVER_CODE(String BS_COVER_CODE) {
		this.BS_COVER_CODE = BS_COVER_CODE;
	}
	public String getBS_COVER_CODE() {
		 return BS_COVER_CODE;
	}
	public void setBS_COMM_CODE(String BS_COMM_CODE) {
		this.BS_COMM_CODE = BS_COMM_CODE;
	}
	public String getBS_COMM_CODE() {
		 return BS_COMM_CODE;
	}
	public void setBS_UPD_UID(String BS_UPD_UID) {
		this.BS_UPD_UID = BS_UPD_UID;
	}
	public String getBS_UPD_UID() {
		 return BS_UPD_UID;
	}
	public void setBS_EFF_TO_DT(Date BS_EFF_TO_DT) {
		this.BS_EFF_TO_DT = BS_EFF_TO_DT;
	}
	public Date getBS_EFF_TO_DT() {
		 return BS_EFF_TO_DT;
	}
	
	public void setBS_UPD_DT(Date BS_UPD_DT) {
		this.BS_UPD_DT = BS_UPD_DT;
	}
	public Date getBS_UPD_DT() {
		 return BS_UPD_DT;
	}
	public void setBS_SA_FM(Double BS_SA_FM) {
		this.BS_SA_FM = BS_SA_FM;
	}
	public Double getBS_SA_FM() {
		 return BS_SA_FM;
	}
	
	public Integer getBS_YEARS_FROM() {
		return BS_YEARS_FROM;
	}
	public void setBS_YEARS_FROM(Integer bs_years_from) {
		BS_YEARS_FROM = bs_years_from;
	}
	public Integer getBS_YEARS_TO() {
		return BS_YEARS_TO;
	}
	public void setBS_YEARS_TO(Integer bs_years_to) {
		BS_YEARS_TO = bs_years_to;
	}
	public Integer getBS_TERM_FM() {
		return BS_TERM_FM;
	}
	public void setBS_TERM_FM(Integer bs_term_fm) {
		BS_TERM_FM = bs_term_fm;
	}
	public Integer getBS_TERM_TO() {
		return BS_TERM_TO;
	}
	public void setBS_TERM_TO(Integer bs_term_to) {
		BS_TERM_TO = bs_term_to;
	}
	public String getUI_M_CUST_CLASS_DESC() {
		return UI_M_CUST_CLASS_DESC;
	}
	public void setUI_M_CUST_CLASS_DESC(String ui_m_cust_class_desc) {
		UI_M_CUST_CLASS_DESC = ui_m_cust_class_desc;
	}
	public String getUI_M_COVER_DESC() {
		return UI_M_COVER_DESC;
	}
	public void setUI_M_COVER_DESC(String ui_m_cover_desc) {
		UI_M_COVER_DESC = ui_m_cover_desc;
	}

}