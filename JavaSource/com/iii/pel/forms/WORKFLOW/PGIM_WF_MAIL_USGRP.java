package com.iii.pel.forms.WORKFLOW;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PGIM_WF_MAIL_USGRP")
public class PGIM_WF_MAIL_USGRP extends BaseValueBean {
	
	@Column(name="PWMU_PWB_BUKT_CODE")
	private String PWMU_PWB_BUKT_CODE;
	
	@Column(name="PWMU_APPR_STS")
	private String PWMU_APPR_STS;
	
	@Column(name="PWMU_POL_WF_STS")
	private String PWMU_POL_WF_STS;
	
	@Column(name="PWMU_MAIL_USGRP")
	private String PWMU_MAIL_USGRP;
	
	@Column(name="PWMU_CR_UID")
	private String PWMU_CR_UID;
	
	@Column(name="PWMU_CR_DT")
	private Date PWMU_CR_DT;
	
	@Column(name="PWMU_ESC_USGRP_1")
	private String PWMU_ESC_USGRP_1;
	
	@Column(name="PWMU_ESC_USGRP_2")
	private String PWMU_ESC_USGRP_2;
	
	@Column(name="PWMU_USGRP_TO_MODIFY")
	private String PWMU_USGRP_TO_MODIFY;
	
	@Column(name="PWMU_MAIL_MESSAGE")
	private String PWMU_MAIL_MESSAGE;
	
	@Column(name="PWMU_MAIL_SUBJECT")
	private String PWMU_MAIL_SUBJECT;
	
	@Column(name="PWMU_LIMIT_FROM")
	private String PWMU_LIMIT_FROM;
	
	@Column(name="PWMU_LIMIT_TO")
	private String PWMU_LIMIT_TO;
	/* Added by kavitha for RoadMap on 20.11.2018*/
	/*@Column(name="PWMU_ESC_DAYS")
	private int PWMU_ESC_DAYS;*/
	
	@Column(name="PWMU_MAIL_ESC_MESSAGE")
	private String PWMU_MAIL_ESC_MESSAGE;
	
	@Column(name="PWMU_MAIL_ESC_SUBJECT")
	private String PWMU_MAIL_ESC_SUBJECT;
	
	
	@Column(name="PWMU_ESC_LIMIT")
	private int PWMU_ESC_LIMIT;
	
	@Column(name="PWMU_ESC_LMT_TYP")
	private String PWMU_ESC_LMT_TYP;
	
	/*End*/
	
	
	public String getPWMU_PWB_BUKT_CODE() {
		return PWMU_PWB_BUKT_CODE;
	}

	public void setPWMU_PWB_BUKT_CODE(String pWMU_PWB_BUKT_CODE) {
		PWMU_PWB_BUKT_CODE = pWMU_PWB_BUKT_CODE;
	}

	public String getPWMU_APPR_STS() {
		return PWMU_APPR_STS;
	}

	public void setPWMU_APPR_STS(String pWMU_APPR_STS) {
		PWMU_APPR_STS = pWMU_APPR_STS;
	}

	public String getPWMU_POL_WF_STS() {
		return PWMU_POL_WF_STS;
	}

	public void setPWMU_POL_WF_STS(String pWMU_POL_WF_STS) {
		PWMU_POL_WF_STS = pWMU_POL_WF_STS;
	}

	public String getPWMU_MAIL_USGRP() {
		return PWMU_MAIL_USGRP;
	}

	public void setPWMU_MAIL_USGRP(String pWMU_MAIL_USGRP) {
		PWMU_MAIL_USGRP = pWMU_MAIL_USGRP;
	}

	public String getPWMU_CR_UID() {
		return PWMU_CR_UID;
	}

	public void setPWMU_CR_UID(String pWMU_CR_UID) {
		PWMU_CR_UID = pWMU_CR_UID;
	}

	public Date getPWMU_CR_DT() {
		return PWMU_CR_DT;
	}

	public void setPWMU_CR_DT(Date pWMU_CR_DT) {
		PWMU_CR_DT = pWMU_CR_DT;
	}

	public String getPWMU_ESC_USGRP_1() {
		return PWMU_ESC_USGRP_1;
	}

	public void setPWMU_ESC_USGRP_1(String pWMU_ESC_USGRP_1) {
		PWMU_ESC_USGRP_1 = pWMU_ESC_USGRP_1;
	}

	public String getPWMU_ESC_USGRP_2() {
		return PWMU_ESC_USGRP_2;
	}

	public void setPWMU_ESC_USGRP_2(String pWMU_ESC_USGRP_2) {
		PWMU_ESC_USGRP_2 = pWMU_ESC_USGRP_2;
	}

	public String getPWMU_USGRP_TO_MODIFY() {
		return PWMU_USGRP_TO_MODIFY;
	}

	public void setPWMU_USGRP_TO_MODIFY(String pWMU_USGRP_TO_MODIFY) {
		PWMU_USGRP_TO_MODIFY = pWMU_USGRP_TO_MODIFY;
	}

	public String getPWMU_MAIL_MESSAGE() {
		return PWMU_MAIL_MESSAGE;
	}

	public void setPWMU_MAIL_MESSAGE(String pWMU_MAIL_MESSAGE) {
		PWMU_MAIL_MESSAGE = pWMU_MAIL_MESSAGE;
	}

	public String getPWMU_MAIL_SUBJECT() {
		return PWMU_MAIL_SUBJECT;
	}

	public void setPWMU_MAIL_SUBJECT(String pWMU_MAIL_SUBJECT) {
		PWMU_MAIL_SUBJECT = pWMU_MAIL_SUBJECT;
	}

	public String getPWMU_LIMIT_FROM() {
		return PWMU_LIMIT_FROM;
	}

	public void setPWMU_LIMIT_FROM(String pWMU_LIMIT_FROM) {
		PWMU_LIMIT_FROM = pWMU_LIMIT_FROM;
	}

	public String getPWMU_LIMIT_TO() {
		return PWMU_LIMIT_TO;
	}

	public void setPWMU_LIMIT_TO(String pWMU_LIMIT_TO) {
		PWMU_LIMIT_TO = pWMU_LIMIT_TO;
	}
	/* Added by kavitha for RoadMap on 20.11.2018*/
	/*public int getPWMU_ESC_DAYS() {
		return PWMU_ESC_DAYS;
	}

	public void setPWMU_ESC_DAYS(int pWMU_ESC_DAYS) {
		PWMU_ESC_DAYS = pWMU_ESC_DAYS;
	}*/

	public String getPWMU_MAIL_ESC_MESSAGE() {
		return PWMU_MAIL_ESC_MESSAGE;
	}

	public void setPWMU_MAIL_ESC_MESSAGE(String pWMU_MAIL_ESC_MESSAGE) {
		PWMU_MAIL_ESC_MESSAGE = pWMU_MAIL_ESC_MESSAGE;
	}

	public String getPWMU_MAIL_ESC_SUBJECT() {
		return PWMU_MAIL_ESC_SUBJECT;
	}

	public void setPWMU_MAIL_ESC_SUBJECT(String pWMU_MAIL_ESC_SUBJECT) {
		PWMU_MAIL_ESC_SUBJECT = pWMU_MAIL_ESC_SUBJECT;
	}

	public int getPWMU_ESC_LIMIT() {
		return PWMU_ESC_LIMIT;
	}

	public void setPWMU_ESC_LIMIT(int pWMU_ESC_LIMIT) {
		PWMU_ESC_LIMIT = pWMU_ESC_LIMIT;
	}

	public String getPWMU_ESC_LMT_TYP() {
		return PWMU_ESC_LMT_TYP;
	}

	public void setPWMU_ESC_LMT_TYP(String pWMU_ESC_LMT_TYP) {
		PWMU_ESC_LMT_TYP = pWMU_ESC_LMT_TYP;
	}

	
	
	
   /*End*/
	
}
