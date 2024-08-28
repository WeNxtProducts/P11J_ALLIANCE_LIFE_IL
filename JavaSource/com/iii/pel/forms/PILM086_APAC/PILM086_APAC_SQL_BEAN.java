package com.iii.pel.forms.PILM086_APAC;


import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_BUS_RULE_HDR")
public class PILM086_APAC_SQL_BEAN extends BaseValueBean{
	@Column(name="BRH_WHERE_CLAUSE")
	private String BRH_WHERE_CLAUSE;
	
	@Column(name="BRH_COVER_CODE_TO")
	private String BRH_COVER_CODE_TO;
	
	/*Commentted by saritha on 17-07-2017 for ssp call id ZBILQC-1729014*/
	/*@Column(name="BRH_PROD_CODE")
	private String BRH_PROD_CODE;*/
	
	/*public String getBRH_PROD_CODE() {
		return BRH_PROD_CODE;
	}

	public void setBRH_PROD_CODE(String bRH_PROD_CODE) {
		BRH_PROD_CODE = bRH_PROD_CODE;
	}*/

	/*End*/
	
	public String getBRH_COVER_CODE_TO() {
		return BRH_COVER_CODE_TO;
	}

	public void setBRH_COVER_CODE_TO(String bRH_COVER_CODE_TO) {
		BRH_COVER_CODE_TO = bRH_COVER_CODE_TO;
	}

	@Column(name="BRH_SYS_ID")
	private String BRH_SYS_ID;
	public String getBRH_SYS_ID() {
		return BRH_SYS_ID;
	}

	public void setBRH_SYS_ID(String bRH_SYS_ID) {
		BRH_SYS_ID = bRH_SYS_ID;
	}

	public String getBRH_WHERE_CLAUSE() {
		return BRH_WHERE_CLAUSE;
	}

	public void setBRH_WHERE_CLAUSE(String bRH_WHERE_CLAUSE) {
		BRH_WHERE_CLAUSE = bRH_WHERE_CLAUSE;
	}
	
	/*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1729014*/
	@Column(name="BRH_PROD_CODE_TO")
	private String BRH_PROD_CODE_TO;

	public String getBRH_PROD_CODE_TO() {
		return BRH_PROD_CODE_TO;
	}

	public void setBRH_PROD_CODE_TO(String bRH_PROD_CODE_TO) {
		BRH_PROD_CODE_TO = bRH_PROD_CODE_TO;
	}	
	/*End*/
	
}
