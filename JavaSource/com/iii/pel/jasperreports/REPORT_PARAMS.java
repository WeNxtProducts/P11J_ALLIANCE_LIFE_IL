package com.iii.pel.jasperreports;


public class REPORT_PARAMS {
	
	private String loginCompCode;
	private String loginDivn;
	private String loginlang;
	private String loginuser;
	private String loginuserName;
	private String ctrlParm00;
	private String ctrlParm01;
	private String ctrlParm02;
	private String ctrlParm03;
	private String ctrlParm04;
	private String ctrlParm05;
	private String ctrlParm06;
	private String ctrlParm07;
	private String ctrlParm08;
	private String ctrlParm09;
	private String displayLogo;
	private String paraText01;
	private String paraText02;
	private String footerText01;
	private String footerText02;
	private String footerText03;
	private String dtlText01;
	private String dtlText02;
	private String displayParms;
	private String repID;
	private String repName;
	private String repTitle1;
	private String repTitle2;
	private String repTitle3;
	
	private String repRunTime;
	private String pageno;
	private String loginDept;
	private String langCode;
	private String baseCurrCode;
	
	
	public REPORT_PARAMS(){
		
		/*loginCompCode=CommonUtils.getControlBean().getM_COMP_CODE();
		loginlang=CommonUtils.getControlBean().getM_LANG_CODE();*/
		displayLogo="Y";
		repTitle1 = "Title 1";
		repTitle2 = "Title 2";
		repTitle3 = "Title 3";
	}
	public String getLoginCompCode() {
		return loginCompCode;
	}
	public void setLoginCompCode(String loginCompCode) {
		this.loginCompCode = loginCompCode;
	}
	public String getLoginDivn() {
		return loginDivn;
	}
	public void setLoginDivn(String loginDivn) {
		this.loginDivn = loginDivn;
	}
	public String getLoginlang() {
		return loginlang;
	}
	public void setLoginlang(String loginlang) {
		this.loginlang = loginlang;
	}
	public String getLoginuser() {
		return loginuser;
	}
	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}
	public String getLoginuserName() {
		return loginuserName;
	}
	public void setLoginuserName(String loginuserName) {
		this.loginuserName = loginuserName;
	}
	public String getCtrlParm00() {
		return ctrlParm00;
	}
	public void setCtrlParm00(String ctrlParm00) {
		this.ctrlParm00 = ctrlParm00;
	}
	public String getCtrlParm01() {
		return ctrlParm01;
	}
	public void setCtrlParm01(String ctrlParm01) {
		this.ctrlParm01 = ctrlParm01;
	}
	public String getCtrlParm02() {
		return ctrlParm02;
	}
	public void setCtrlParm02(String ctrlParm02) {
		this.ctrlParm02 = ctrlParm02;
	}
	public String getCtrlParm03() {
		return ctrlParm03;
	}
	public void setCtrlParm03(String ctrlParm03) {
		this.ctrlParm03 = ctrlParm03;
	}
	public String getCtrlParm04() {
		return ctrlParm04;
	}
	public void setCtrlParm04(String ctrlParm04) {
		this.ctrlParm04 = ctrlParm04;
	}
	public String getCtrlParm05() {
		return ctrlParm05;
	}
	public void setCtrlParm05(String ctrlParm05) {
		this.ctrlParm05 = ctrlParm05;
	}
	public String getCtrlParm06() {
		return ctrlParm06;
	}
	public void setCtrlParm06(String ctrlParm06) {
		this.ctrlParm06 = ctrlParm06;
	}
	public String getCtrlParm07() {
		return ctrlParm07;
	}
	public void setCtrlParm07(String ctrlParm07) {
		this.ctrlParm07 = ctrlParm07;
	}
	public String getCtrlParm08() {
		return ctrlParm08;
	}
	public void setCtrlParm08(String ctrlParm08) {
		this.ctrlParm08 = ctrlParm08;
	}
	public String getCtrlParm09() {
		return ctrlParm09;
	}
	public void setCtrlParm09(String ctrlParm09) {
		this.ctrlParm09 = ctrlParm09;
	}
	public String getDisplayLogo() {
		return displayLogo;
	}
	public void setDisplayLogo(String displayLogo) {
		this.displayLogo = displayLogo;
	}
	public String getParaText01() {
		return paraText01;
	}
	public void setParaText01(String paraText01) {
		this.paraText01 = paraText01;
	}
	public String getParaText02() {
		return paraText02;
	}
	public void setParaText02(String paraText02) {
		this.paraText02 = paraText02;
	}
	public String getFooterText01() {
		return footerText01;
	}
	public void setFooterText01(String footerText01) {
		this.footerText01 = footerText01;
	}
	public String getFooterText02() {
		return footerText02;
	}
	public void setFooterText02(String footerText02) {
		this.footerText02 = footerText02;
	}
	public String getFooterText03() {
		return footerText03;
	}
	public void setFooterText03(String footerText03) {
		this.footerText03 = footerText03;
	}
	public String getDtlText01() {
		return dtlText01;
	}
	public void setDtlText01(String dtlText01) {
		this.dtlText01 = dtlText01;
	}
	public String getDtlText02() {
		return dtlText02;
	}
	public void setDtlText02(String dtlText02) {
		this.dtlText02 = dtlText02;
	}
	public String getDisplayParms() {
		return displayParms;
	}
	public void setDisplayParms(String displayParms) {
		this.displayParms = displayParms;
	}
	public String getRepID() {
		return repID;
	}
	public void setRepID(String repID) {
		this.repID = repID;
	}
	public String getRepName() {
		return repName;
	}
	public void setRepName(String repName) {
		this.repName = repName;
	}
	public String getRepTitle1() {
		return repTitle1;
	}
	public void setRepTitle1(String repTitle1) {
		this.repTitle1 = repTitle1;
	}
	public String getRepTitle2() {
		return repTitle2;
	}
	public void setRepTitle2(String repTitle2) {
		this.repTitle2 = repTitle2;
	}
	public String getRepTitle3() {
		return repTitle3;
	}
	public void setRepTitle3(String repTitle3) {
		this.repTitle3 = repTitle3;
	}
	public String getRepRunTime() {
		return repRunTime;
	}
	public void setRepRunTime(String repRunTime) {
		this.repRunTime = repRunTime;
	}
	public String getPageno() {
		return pageno;
	}
	public void setPageno(String pageno) {
		this.pageno = pageno;
	}
	public String getLoginDept() {
		return loginDept;
	}
	public void setLoginDept(String loginDept) {
		this.loginDept = loginDept;
	}
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	public String getBaseCurrCode() {
		return baseCurrCode;
	}
	public void setBaseCurrCode(String baseCurrCode) {
		this.baseCurrCode = baseCurrCode;
	}

}
