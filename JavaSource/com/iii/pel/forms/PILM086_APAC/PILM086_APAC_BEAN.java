package com.iii.pel.forms.PILM086_APAC;

import java.util.Date;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PM_BUS_RULE_HDR")
public class PILM086_APAC_BEAN extends BaseValueBean {
	
	/*Commentted by saritha on 08-07-2017 for Business Rule Master*/
	/*@Column(name="BRH_PROD_CODE")
	private String BRH_PROD_CODE;*/
	/*End*/
	@Column(name="BRH_GRP_ID")
	private String BRH_GRP_ID;
	@Column(name="BRH_COVER_CODE_FM")
	private String BRH_COVER_CODE_FM;
	private String BRH_COVER_CODE_FM_DESC;
	@Column(name="BRH_COVER_CODE_TO")
	private String BRH_COVER_CODE_TO;
	private String BRH_COVER_CODE_TO_DESC;
	private String BRH_GRP_ID_DESC;
	
	/*Commentted by saritha on 08-07-2017 for Business Rule Master*/
	/*private String BRH_PROD_CODE_DESC;*/
	/*End*/
	
	@Column(name="BRH_ASSR_TYPE")
	private String BRH_ASSR_TYPE;
	@Column(name="BRH_PDS_CODE_FM")
	private String BRH_PDS_CODE_FM;
	private String BRH_PDS_CODE_FM_DESC;
	@Column(name="BRH_PDS_CODE_TO")
	private String BRH_PDS_CODE_TO;
	private String BRH_PDS_CODE_TO_DESC;
	@Column(name="BRH_SRC_BUS_CODE_FM")
	private String BRH_SRC_BUS_CODE_FM;
	private String BRH_SRC_BUS_CODE_FM_DESC;
	@Column(name="BRH_SRC_BUS_CODE_TO")
	private String BRH_SRC_BUS_CODE_TO;
	private String BRH_SRC_BUS_CODE_TO_DESC;
	@Column(name="BRH_DATE_FM")
	private Date BRH_DATE_FM;
	@Column(name="BRH_DATE_TO")
	private Date BRH_DATE_TO;
	@Column(name="BRH_ERR_FLAG")
	private String BRH_ERR_FLAG;
	@Column(name="BRH_APPL_LEVEL")
	private String BRH_APPL_LEVEL;
	@Column(name="BRH_MOD_VALUE_YN")
	private String BRH_MOD_VALUE_YN;
	@Column(name="BRH_TXN_DISP_TYPE")
	private String BRH_TXN_DISP_TYPE;
	@Column(name="BRH_TXN_DISP_TEXT")
	private String BRH_TXN_DISP_TEXT;
	@Column(name="BRH_HINT")
	private String BRH_HINT;
	@Column(name="BRH_SYS_ID")
	private long BRH_SYS_ID;
	
	@Column(name="BRH_CR_DT")
	private Date BRH_CR_DT;
	
	@Column(name="BRH_UPD_DT")
	private Date BRH_UPD_DT;
	
	@Column(name="BRH_CR_UID")
	private String BRH_CR_UID;
	
	@Column(name="BRH_UPD_UID")
	private String BRH_UPD_UID;
	
	
	
	public Date getBRH_CR_DT() {
		return BRH_CR_DT;
	}
	public void setBRH_CR_DT(Date bRH_CR_DT) {
		BRH_CR_DT = bRH_CR_DT;
	}
	public Date getBRH_UPD_DT() {
		return BRH_UPD_DT;
	}
	public void setBRH_UPD_DT(Date bRH_UPD_DT) {
		BRH_UPD_DT = bRH_UPD_DT;
	}
	public String getBRH_CR_UID() {
		return BRH_CR_UID;
	}
	public void setBRH_CR_UID(String bRH_CR_UID) {
		BRH_CR_UID = bRH_CR_UID;
	}
	public String getBRH_UPD_UID() {
		return BRH_UPD_UID;
	}
	public void setBRH_UPD_UID(String bRH_UPD_UID) {
		BRH_UPD_UID = bRH_UPD_UID;
	}
	public long getBRH_SYS_ID() {
		return BRH_SYS_ID;
	}
	public void setBRH_SYS_ID(long bRH_SYS_ID) {
		BRH_SYS_ID = bRH_SYS_ID;
	}
	public String getBRH_TXN_DISP_TEXT() {
		return BRH_TXN_DISP_TEXT;
	}
	public void setBRH_TXN_DISP_TEXT(String bRH_TXN_DISP_TEXT) {
		BRH_TXN_DISP_TEXT = bRH_TXN_DISP_TEXT;
	}
	public String getBRH_HINT() {
		return BRH_HINT;
	}
	public void setBRH_HINT(String bRH_HINT) {
		BRH_HINT = bRH_HINT;
	}
	public String getBRH_MOD_VALUE_YN() {
		return BRH_MOD_VALUE_YN;
	}
	public void setBRH_MOD_VALUE_YN(String bRH_MOD_VALUE_YN) {
		BRH_MOD_VALUE_YN = bRH_MOD_VALUE_YN;
	}
	public String getBRH_TXN_DISP_TYPE() {
		return BRH_TXN_DISP_TYPE;
	}
	public void setBRH_TXN_DISP_TYPE(String bRH_TXN_DISP_TYPE) {
		BRH_TXN_DISP_TYPE = bRH_TXN_DISP_TYPE;
	}
	public String getBRH_ERR_FLAG() {
		return BRH_ERR_FLAG;
	}
	public void setBRH_ERR_FLAG(String bRH_ERR_FLAG) {
		BRH_ERR_FLAG = bRH_ERR_FLAG;
	}
	public String getBRH_APPL_LEVEL() {
		return BRH_APPL_LEVEL;
	}
	public void setBRH_APPL_LEVEL(String bRH_APPL_LEVEL) {
		BRH_APPL_LEVEL = bRH_APPL_LEVEL;
	}
	public Date getBRH_DATE_FM() {
		return BRH_DATE_FM;
	}
	public void setBRH_DATE_FM(Date bRH_DATE_FM) {
		BRH_DATE_FM = bRH_DATE_FM;
	}
	public Date getBRH_DATE_TO() {
		return BRH_DATE_TO;
	}
	public void setBRH_DATE_TO(Date bRH_DATE_TO) {
		BRH_DATE_TO = bRH_DATE_TO;
	}
	public String getBRH_COVER_CODE_FM_DESC() {
		return BRH_COVER_CODE_FM_DESC;
	}
	public void setBRH_COVER_CODE_FM_DESC(String bRH_COVER_CODE_FM_DESC) {
		BRH_COVER_CODE_FM_DESC = bRH_COVER_CODE_FM_DESC;
	}
	public String getBRH_COVER_CODE_TO_DESC() {
		return BRH_COVER_CODE_TO_DESC;
	}
	public void setBRH_COVER_CODE_TO_DESC(String bRH_COVER_CODE_TO_DESC) {
		BRH_COVER_CODE_TO_DESC = bRH_COVER_CODE_TO_DESC;
	}
	public String getBRH_PDS_CODE_TO() {
		return BRH_PDS_CODE_TO;
	}
	public void setBRH_PDS_CODE_TO(String bRH_PDS_CODE_TO) {
		BRH_PDS_CODE_TO = bRH_PDS_CODE_TO;
	}
	public String getBRH_PDS_CODE_TO_DESC() {
		return BRH_PDS_CODE_TO_DESC;
	}
	public void setBRH_PDS_CODE_TO_DESC(String bRH_PDS_CODE_TO_DESC) {
		BRH_PDS_CODE_TO_DESC = bRH_PDS_CODE_TO_DESC;
	}
	public String getBRH_SRC_BUS_CODE_FM() {
		return BRH_SRC_BUS_CODE_FM;
	}
	public void setBRH_SRC_BUS_CODE_FM(String bRH_SRC_BUS_CODE_FM) {
		BRH_SRC_BUS_CODE_FM = bRH_SRC_BUS_CODE_FM;
	}
	public String getBRH_SRC_BUS_CODE_FM_DESC() {
		return BRH_SRC_BUS_CODE_FM_DESC;
	}
	public void setBRH_SRC_BUS_CODE_FM_DESC(String bRH_SRC_BUS_CODE_FM_DESC) {
		BRH_SRC_BUS_CODE_FM_DESC = bRH_SRC_BUS_CODE_FM_DESC;
	}
	public String getBRH_SRC_BUS_CODE_TO() {
		return BRH_SRC_BUS_CODE_TO;
	}
	public void setBRH_SRC_BUS_CODE_TO(String bRH_SRC_BUS_CODE_TO) {
		BRH_SRC_BUS_CODE_TO = bRH_SRC_BUS_CODE_TO;
	}
	public String getBRH_SRC_BUS_CODE_TO_DESC() {
		return BRH_SRC_BUS_CODE_TO_DESC;
	}
	public void setBRH_SRC_BUS_CODE_TO_DESC(String bRH_SRC_BUS_CODE_TO_DESC) {
		BRH_SRC_BUS_CODE_TO_DESC = bRH_SRC_BUS_CODE_TO_DESC;
	}
	public String getBRH_PDS_CODE_FM() {
		return BRH_PDS_CODE_FM;
	}
	public void setBRH_PDS_CODE_FM(String bRH_PDS_CODE_FM) {
		BRH_PDS_CODE_FM = bRH_PDS_CODE_FM;
	}
	public String getBRH_PDS_CODE_FM_DESC() {
		return BRH_PDS_CODE_FM_DESC;
	}
	public void setBRH_PDS_CODE_FM_DESC(String bRH_PDS_CODE_FM_DESC) {
		BRH_PDS_CODE_FM_DESC = bRH_PDS_CODE_FM_DESC;
	}
	public String getBRH_ASSR_TYPE() {
		return BRH_ASSR_TYPE;
	}
	public void setBRH_ASSR_TYPE(String bRH_ASSR_TYPE) {
		BRH_ASSR_TYPE = bRH_ASSR_TYPE;
	}
	public String getBRH_GRP_ID_DESC() {
		return BRH_GRP_ID_DESC;
	}
	public void setBRH_GRP_ID_DESC(String bRH_GRP_ID_DESC) {
		BRH_GRP_ID_DESC = bRH_GRP_ID_DESC;
	}
	
	/*Commentted by saritha on 08-07-2017 for Business Rule Master*/
	/*public String getBRH_PROD_CODE_DESC() {
		return BRH_PROD_CODE_DESC;
	}
	public void setBRH_PROD_CODE_DESC(String bRH_PROD_CODE_DESC) {
		BRH_PROD_CODE_DESC = bRH_PROD_CODE_DESC;
	}
	public String getBRH_PROD_CODE() {
		return BRH_PROD_CODE;
	}
	public void setBRH_PROD_CODE(String bRH_PROD_CODE) {
		BRH_PROD_CODE = bRH_PROD_CODE;
	}*/
	
	/*End*/
	public String getBRH_GRP_ID() {
		return BRH_GRP_ID;
	}
	public void setBRH_GRP_ID(String bRH_GRP_ID) {
		BRH_GRP_ID = bRH_GRP_ID;
	}
	public String getBRH_COVER_CODE_FM() {
		return BRH_COVER_CODE_FM;
	}
	public void setBRH_COVER_CODE_FM(String bRH_COVER_CODE_FM) {
		BRH_COVER_CODE_FM = bRH_COVER_CODE_FM;
	}
	public String getBRH_COVER_CODE_TO() {
		return BRH_COVER_CODE_TO;
	}
	public void setBRH_COVER_CODE_TO(String bRH_COVER_CODE_TO) {
		BRH_COVER_CODE_TO = bRH_COVER_CODE_TO;
	}
	
	/*Added by saritha on 08-07-2017 for Business Rule Master*/
	@Column(name="BRH_PROD_CODE_FM")
	private String BRH_PROD_CODE_FM;

	public String getBRH_PROD_CODE_FM() {
		return BRH_PROD_CODE_FM;
	}
	public void setBRH_PROD_CODE_FM(String bRH_PROD_CODE_FM) {
		BRH_PROD_CODE_FM = bRH_PROD_CODE_FM;
	}

	@Column(name="BRH_PROD_CODE_TO")
	private String BRH_PROD_CODE_TO;

	public String getBRH_PROD_CODE_TO() {
		return BRH_PROD_CODE_TO;
	}
	public void setBRH_PROD_CODE_TO(String bRH_PROD_CODE_TO) {
		BRH_PROD_CODE_TO = bRH_PROD_CODE_TO;
	}
	
	private String BRH_PROD_CODE_FM_DESC;

	public String getBRH_PROD_CODE_FM_DESC() {
		return BRH_PROD_CODE_FM_DESC;
	}
	public void setBRH_PROD_CODE_FM_DESC(String bRH_PROD_CODE_FM_DESC) {
		BRH_PROD_CODE_FM_DESC = bRH_PROD_CODE_FM_DESC;
	}
	
	private String BRH_PROD_CODE_TO_DESC;

	public String getBRH_PROD_CODE_TO_DESC() {
		return BRH_PROD_CODE_TO_DESC;
	}
	public void setBRH_PROD_CODE_TO_DESC(String bRH_PROD_CODE_TO_DESC) {
		BRH_PROD_CODE_TO_DESC = bRH_PROD_CODE_TO_DESC;
	}
	
	/*End*/
	
	/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/ 
	@Column(name="BRH_APL_SCREEN")
	private String BRH_APL_SCREEN;

	public String getBRH_APL_SCREEN() {
		return BRH_APL_SCREEN;
	}
	public void setBRH_APL_SCREEN(String bRH_APL_SCREEN) {
		BRH_APL_SCREEN = bRH_APL_SCREEN;
	}
	/*End*/
}
