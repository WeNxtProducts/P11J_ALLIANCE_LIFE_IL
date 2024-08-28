package com.iii.pel.forms.PILM106;

import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PM_LIFE_MAIL_TEMPLATE")

public class PILM106_EMAIL_BEAN extends BaseValueBean{
	
	@Column(name="PMT_PROD_CODE")
	private String PMT_PROD_CODE;
	@Column(name="PMT_MAIL_FM")
	private String PMT_MAIL_FM;
	@Column(name="PMT_MAIL_TEXT")
	private String PMT_MAIL_TEXT;
	@Column(name="PMT_MAIL_SUB")
	private String PMT_MAIL_SUB;
	@Column(name="PMT_MAIL_TYPE")
	private String PMT_MAIL_TYPE;
	@Column(name="PMT_EFF_FM_DT")
	private Date PMT_EFF_FM_DT;
	@Column(name="PMT_EFF_TO_DT")
	private Date  PMT_EFF_TO_DT;
	@Column(name="PMT_FRZ_FLAG")
	private String PMT_FRZ_FLAG;
	@Column(name="PMT_ATTACH_YN")
	private String PMT_ATTACH_YN;
	private boolean ATTACHMENT_FLAG;
	private boolean FRZ_FLAG;
	private String Selected;
	public String getSelected() {
		return Selected;
	}
	public void setSelected(String selected) {
		Selected = selected;
	}
	public String getPMT_PROD_CODE() {
		return PMT_PROD_CODE;
	}
	public void setPMT_PROD_CODE(String pMT_PROD_CODE) {
		PMT_PROD_CODE = pMT_PROD_CODE;
	}
	public String getPMT_ATTACH_YN() {
		return PMT_ATTACH_YN;
	}
	public void setPMT_ATTACH_YN(String pMT_ATTACH_YN) {
		PMT_ATTACH_YN = pMT_ATTACH_YN;
	}
	
	public boolean isATTACHMENT_FLAG() {
		return ATTACHMENT_FLAG;
	}
	public void setATTACHMENT_FLAG(boolean aTTACHMENT_FLAG) {
		ATTACHMENT_FLAG = aTTACHMENT_FLAG;
	}
	public String getPMT_FRZ_FLAG() {
		return PMT_FRZ_FLAG;
	}
	public void setPMT_FRZ_FLAG(String pMT_FRZ_FLAG) {
		PMT_FRZ_FLAG = pMT_FRZ_FLAG;
	}
	public boolean isFRZ_FLAG() {
		return FRZ_FLAG;
	}
	public void setFRZ_FLAG(boolean fRZ_FLAG) {
		FRZ_FLAG = fRZ_FLAG;
	}
	
	public String getPMT_MAIL_FM() {
		return PMT_MAIL_FM;
	}
	public void setPMT_MAIL_FM(String pMT_MAIL_FM) {
		PMT_MAIL_FM = pMT_MAIL_FM;
	}
	public String getPMT_MAIL_TEXT() {
		return PMT_MAIL_TEXT;
	}
	public void setPMT_MAIL_TEXT(String pMT_MAIL_TEXT) {
		PMT_MAIL_TEXT = pMT_MAIL_TEXT;
	}
	public String getPMT_MAIL_SUB() {
		return PMT_MAIL_SUB;
	}
	public void setPMT_MAIL_SUB(String pMT_MAIL_SUB) {
		PMT_MAIL_SUB = pMT_MAIL_SUB;
	}
	public String getPMT_MAIL_TYPE() {
		return PMT_MAIL_TYPE;
	}
	public void setPMT_MAIL_TYPE(String pMT_MAIL_TYPE) {
		PMT_MAIL_TYPE = pMT_MAIL_TYPE;
	}
	public Date getPMT_EFF_FM_DT() {
		return PMT_EFF_FM_DT;
	}
	public void setPMT_EFF_FM_DT(Date pMT_EFF_FM_DT) {
		PMT_EFF_FM_DT = pMT_EFF_FM_DT;
	}
	public Date getPMT_EFF_TO_DT() {
		return PMT_EFF_TO_DT;
	}
	public void setPMT_EFF_TO_DT(Date pMT_EFF_TO_DT) {
		PMT_EFF_TO_DT = pMT_EFF_TO_DT;
	}
	/*added by krithika for call id FALCONQC-1716214  */
	 private String listvalue;
	public String getListvalue() {
		return listvalue;
	}
	public void setListvalue(String listvalue) {
		this.listvalue = listvalue;
	}

	 private String FRM_HIDE;
	 private String FRM_HIDE_TO;
	public String getFRM_HIDE() {
		return FRM_HIDE;
	}
	public void setFRM_HIDE(String fRM_HIDE) {
		FRM_HIDE = fRM_HIDE;
	}
	public String getFRM_HIDE_TO() {
		return FRM_HIDE_TO;
	}
	public void setFRM_HIDE_TO(String fRM_HIDE_TO) {
		FRM_HIDE_TO = fRM_HIDE_TO;
	}
	//end
	
	
	/*Added by Janani on 20.06.2017 for ZBILQC-1721257*/
	
	private String PROD_CODE_DESC;
	public String getPROD_CODE_DESC() {
		return PROD_CODE_DESC;
	}
	public void setPROD_CODE_DESC(String pROD_CODE_DESC) {
		PROD_CODE_DESC = pROD_CODE_DESC;
	}
	
	
	/*End*/
	
	

	/*Added by Ganesh on 28.06.2017 for ZBILQC-1725181*/
	@Column(name="PMT_KEY_MAIL_TO")
	private String PMT_KEY_MAIL_TO;
	@Column(name="PMT_KEY_MAIL_CC")
	private String PMT_KEY_MAIL_CC;
	
	public String getPMT_KEY_MAIL_TO() {
		return PMT_KEY_MAIL_TO;
	}
	public void setPMT_KEY_MAIL_TO(String pMT_KEY_MAIL_TO) {
		PMT_KEY_MAIL_TO = pMT_KEY_MAIL_TO;
	}
	public String getPMT_KEY_MAIL_CC() {
		return PMT_KEY_MAIL_CC;
	}
	public void setPMT_KEY_MAIL_CC(String pMT_KEY_MAIL_CC) {
		PMT_KEY_MAIL_CC = pMT_KEY_MAIL_CC;
	}
	
	private List<String> UI_KEY_MAIL_TO;
	public List<String> getUI_KEY_MAIL_TO() {
		return UI_KEY_MAIL_TO;
	}
	public void setUI_KEY_MAIL_TO(List<String> uI_KEY_MAIL_TO) {
		UI_KEY_MAIL_TO = uI_KEY_MAIL_TO;
	}
	
	private List<String> UI_KEY_MAIL_CC;

	public List<String> getUI_KEY_MAIL_CC() {
		return UI_KEY_MAIL_CC;
	}
	public void setUI_KEY_MAIL_CC(List<String> uI_KEY_MAIL_CC) {
		UI_KEY_MAIL_CC = uI_KEY_MAIL_CC;
	}
	
	
	/*end*/
	
	/*Added by janani on 23.02.2018 for SMS as discussed with Girirsh*/
	
	@Column(name="PMT_TYPE")
	private String PMT_TYPE;
	
	public String getPMT_TYPE() {
		return PMT_TYPE;
	}
	public void setPMT_TYPE(String pMT_TYPE) {
		PMT_TYPE = pMT_TYPE;
	}
	
	
	/*End*/
}
