package com.iii.pel.common.workflow;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PGIW_WF_TRAN_HDR")
public class PGIW_WF_TRAN_HDR extends BaseValueBean {
	private long PWTH_SYS_ID;                                                                                                                                                                             
	private String PWTH_PROCESS_ID;                                                                                                                                                                                  
	private String PWTH_WORKSTEP_ID;                                                                                                                                                                                  
	private String PWTH_TRAN_USER_GROUP_ID;                                                                                                                                                                                  
	private String PWTH_TRAN_USER_ID;                                                                                                                                                                                  
	private String PWTH_TRAN_PROG_CODE;                                                                                                                                                                                  
	private String PWTH_TRAN_INST_CODE;                                                                                                                                                                                  
	private String PWTH_TRAN_MENU_ID;                                                                                                                                                                                  
	private long PWTH_TRAN_SYS_ID;                                                                                                                                                                                     
	private String PWTH_WF_CHK_YN;                                                                                                                                                                                   
	private String PWTH_DOC_NO;                                                                                                                                                                                  
	private String PWTH_TARGET_PROG_CODE;                                                                                                                                                                                  
	private String PWTH_TARGET_INST_CODE;                                                                                                                                                                                  
	private String PWTH_TARGET_MENU_ID;                                                                                                                                                                                  
	private long PWTH_TARGET_SYS_ID;                                                                                                                                                                                     
	private String PWTH_TARGET_DOC_NO;                                                                                                                                                                                  
	private String PWTH_CR_UID;                                                                                                                                                                                  
	private Date PWTH_CR_DT ;                                                                                                                                                                                          
	private String PWTH_UPD_UID;                                                                                                                                                                                  
	private Date PWTH_UPD_DT;                                                                                                                                                                                          
	private String PWTH_FWD_REV;                                                                                                                                                                                   
	private long PWTH_INIT_TRAN_SYS_ID;                                                                                                                                                                                     
	private long PWTH_INIT_TRAN_IDX;                                                                                                                                                                                     
	private String PWTH_INIT_TRAN_DOC_NO;                                                                                                                                                                                  
	private String PWTH_TRANS_STATUS;                                                                                                                                                                                   
	private String PWTH_FLEX_01;                                                                                                                                                                                 
	private String PWTH_FLEX_02;                                                                                                                                                                                 
	private String PWTH_FLEX_03;                                                                                                                                                                                 
	private String PWTH_FLEX_04;                                                                                                                                                                                 
	private String PWTH_FLEX_05;                                                                                                                                                                                 
	private String PWTH_PWB_CODE;                                                                                                                                                                                 
	private String PWTH_APPR_STS;                                                                                                                                                                                  
	private String PWTH_WF_STS;                                                                                                                                                                                  
	private String PWTH_TARGET_USGRP;                                                                                                                                                                                 
	private String PWTH_DOC_PATH;                                                                                                                                                                                 
	private String PWTH_FLEX_06;                                                                                                                                                                                 
	private String PWTH_FLEX_07;                                                                                                                                                                                 
	private String PWTH_FLEX_08;                                                                                                                                                                                 
	private String PWTH_FLEX_09;                                                                                                                                                                                 
	private String PWTH_FLEX_10;                                                                                                                                                                                 
	private String PWTH_ESC_LVL_DONE;                                                                                                                                                                                   
	private Date PWTH_ESC_MAIL_DT;                                                                                                                                                                                          
	private String PWTH_SMS_SENT_YN;                                                                                                                                                                                   
	private String PWTH_EMAIL_SENT_YN;                                                                                                                                                                                   
	private String PWTH_DEPT_CODE;
	public long getPWTH_SYS_ID() {
		return PWTH_SYS_ID;
	}
	public void setPWTH_SYS_ID(long pWTH_SYS_ID) {
		PWTH_SYS_ID = pWTH_SYS_ID;
	}
	public String getPWTH_PROCESS_ID() {
		return PWTH_PROCESS_ID;
	}
	public void setPWTH_PROCESS_ID(String pWTH_PROCESS_ID) {
		PWTH_PROCESS_ID = pWTH_PROCESS_ID;
	}
	public String getPWTH_WORKSTEP_ID() {
		return PWTH_WORKSTEP_ID;
	}
	public void setPWTH_WORKSTEP_ID(String pWTH_WORKSTEP_ID) {
		PWTH_WORKSTEP_ID = pWTH_WORKSTEP_ID;
	}
	public String getPWTH_TRAN_USER_GROUP_ID() {
		return PWTH_TRAN_USER_GROUP_ID;
	}
	public void setPWTH_TRAN_USER_GROUP_ID(String pWTH_TRAN_USER_GROUP_ID) {
		PWTH_TRAN_USER_GROUP_ID = pWTH_TRAN_USER_GROUP_ID;
	}
	public String getPWTH_TRAN_USER_ID() {
		return PWTH_TRAN_USER_ID;
	}
	public void setPWTH_TRAN_USER_ID(String pWTH_TRAN_USER_ID) {
		PWTH_TRAN_USER_ID = pWTH_TRAN_USER_ID;
	}
	public String getPWTH_TRAN_PROG_CODE() {
		return PWTH_TRAN_PROG_CODE;
	}
	public void setPWTH_TRAN_PROG_CODE(String pWTH_TRAN_PROG_CODE) {
		PWTH_TRAN_PROG_CODE = pWTH_TRAN_PROG_CODE;
	}
	public String getPWTH_TRAN_INST_CODE() {
		return PWTH_TRAN_INST_CODE;
	}
	public void setPWTH_TRAN_INST_CODE(String pWTH_TRAN_INST_CODE) {
		PWTH_TRAN_INST_CODE = pWTH_TRAN_INST_CODE;
	}
	public String getPWTH_TRAN_MENU_ID() {
		return PWTH_TRAN_MENU_ID;
	}
	public void setPWTH_TRAN_MENU_ID(String pWTH_TRAN_MENU_ID) {
		PWTH_TRAN_MENU_ID = pWTH_TRAN_MENU_ID;
	}
	public long getPWTH_TRAN_SYS_ID() {
		return PWTH_TRAN_SYS_ID;
	}
	public void setPWTH_TRAN_SYS_ID(long pWTH_TRAN_SYS_ID) {
		PWTH_TRAN_SYS_ID = pWTH_TRAN_SYS_ID;
	}
	public String getPWTH_WF_CHK_YN() {
		return PWTH_WF_CHK_YN;
	}
	public void setPWTH_WF_CHK_YN(String pWTH_WF_CHK_YN) {
		PWTH_WF_CHK_YN = pWTH_WF_CHK_YN;
	}
	public String getPWTH_DOC_NO() {
		return PWTH_DOC_NO;
	}
	public void setPWTH_DOC_NO(String pWTH_DOC_NO) {
		PWTH_DOC_NO = pWTH_DOC_NO;
	}
	public String getPWTH_TARGET_PROG_CODE() {
		return PWTH_TARGET_PROG_CODE;
	}
	public void setPWTH_TARGET_PROG_CODE(String pWTH_TARGET_PROG_CODE) {
		PWTH_TARGET_PROG_CODE = pWTH_TARGET_PROG_CODE;
	}
	public String getPWTH_TARGET_INST_CODE() {
		return PWTH_TARGET_INST_CODE;
	}
	public void setPWTH_TARGET_INST_CODE(String pWTH_TARGET_INST_CODE) {
		PWTH_TARGET_INST_CODE = pWTH_TARGET_INST_CODE;
	}
	public String getPWTH_TARGET_MENU_ID() {
		return PWTH_TARGET_MENU_ID;
	}
	public void setPWTH_TARGET_MENU_ID(String pWTH_TARGET_MENU_ID) {
		PWTH_TARGET_MENU_ID = pWTH_TARGET_MENU_ID;
	}
	public long getPWTH_TARGET_SYS_ID() {
		return PWTH_TARGET_SYS_ID;
	}
	public void setPWTH_TARGET_SYS_ID(long pWTH_TARGET_SYS_ID) {
		PWTH_TARGET_SYS_ID = pWTH_TARGET_SYS_ID;
	}
	public String getPWTH_TARGET_DOC_NO() {
		return PWTH_TARGET_DOC_NO;
	}
	public void setPWTH_TARGET_DOC_NO(String pWTH_TARGET_DOC_NO) {
		PWTH_TARGET_DOC_NO = pWTH_TARGET_DOC_NO;
	}
	public String getPWTH_CR_UID() {
		return PWTH_CR_UID;
	}
	public void setPWTH_CR_UID(String pWTH_CR_UID) {
		PWTH_CR_UID = pWTH_CR_UID;
	}
	public Date getPWTH_CR_DT() {
		return PWTH_CR_DT;
	}
	public void setPWTH_CR_DT(Date pWTH_CR_DT) {
		PWTH_CR_DT = pWTH_CR_DT;
	}
	public String getPWTH_UPD_UID() {
		return PWTH_UPD_UID;
	}
	public void setPWTH_UPD_UID(String pWTH_UPD_UID) {
		PWTH_UPD_UID = pWTH_UPD_UID;
	}
	public Date getPWTH_UPD_DT() {
		return PWTH_UPD_DT;
	}
	public void setPWTH_UPD_DT(Date pWTH_UPD_DT) {
		PWTH_UPD_DT = pWTH_UPD_DT;
	}
	public String getPWTH_FWD_REV() {
		return PWTH_FWD_REV;
	}
	public void setPWTH_FWD_REV(String pWTH_FWD_REV) {
		PWTH_FWD_REV = pWTH_FWD_REV;
	}
	public long getPWTH_INIT_TRAN_SYS_ID() {
		return PWTH_INIT_TRAN_SYS_ID;
	}
	public void setPWTH_INIT_TRAN_SYS_ID(long pWTH_INIT_TRAN_SYS_ID) {
		PWTH_INIT_TRAN_SYS_ID = pWTH_INIT_TRAN_SYS_ID;
	}
	public long getPWTH_INIT_TRAN_IDX() {
		return PWTH_INIT_TRAN_IDX;
	}
	public void setPWTH_INIT_TRAN_IDX(long pWTH_INIT_TRAN_IDX) {
		PWTH_INIT_TRAN_IDX = pWTH_INIT_TRAN_IDX;
	}
	public String getPWTH_INIT_TRAN_DOC_NO() {
		return PWTH_INIT_TRAN_DOC_NO;
	}
	public void setPWTH_INIT_TRAN_DOC_NO(String pWTH_INIT_TRAN_DOC_NO) {
		PWTH_INIT_TRAN_DOC_NO = pWTH_INIT_TRAN_DOC_NO;
	}
	public String getPWTH_TRANS_STATUS() {
		return PWTH_TRANS_STATUS;
	}
	public void setPWTH_TRANS_STATUS(String pWTH_TRANS_STATUS) {
		PWTH_TRANS_STATUS = pWTH_TRANS_STATUS;
	}
	public String getPWTH_FLEX_01() {
		return PWTH_FLEX_01;
	}
	public void setPWTH_FLEX_01(String pWTH_FLEX_01) {
		PWTH_FLEX_01 = pWTH_FLEX_01;
	}
	public String getPWTH_FLEX_02() {
		return PWTH_FLEX_02;
	}
	public void setPWTH_FLEX_02(String pWTH_FLEX_02) {
		PWTH_FLEX_02 = pWTH_FLEX_02;
	}
	public String getPWTH_FLEX_03() {
		return PWTH_FLEX_03;
	}
	public void setPWTH_FLEX_03(String pWTH_FLEX_03) {
		PWTH_FLEX_03 = pWTH_FLEX_03;
	}
	public String getPWTH_FLEX_04() {
		return PWTH_FLEX_04;
	}
	public void setPWTH_FLEX_04(String pWTH_FLEX_04) {
		PWTH_FLEX_04 = pWTH_FLEX_04;
	}
	public String getPWTH_FLEX_05() {
		return PWTH_FLEX_05;
	}
	public void setPWTH_FLEX_05(String pWTH_FLEX_05) {
		PWTH_FLEX_05 = pWTH_FLEX_05;
	}
	public String getPWTH_PWB_CODE() {
		return PWTH_PWB_CODE;
	}
	public void setPWTH_PWB_CODE(String pWTH_PWB_CODE) {
		PWTH_PWB_CODE = pWTH_PWB_CODE;
	}
	public String getPWTH_APPR_STS() {
		return PWTH_APPR_STS;
	}
	public void setPWTH_APPR_STS(String pWTH_APPR_STS) {
		PWTH_APPR_STS = pWTH_APPR_STS;
	}
	public String getPWTH_WF_STS() {
		return PWTH_WF_STS;
	}
	public void setPWTH_WF_STS(String pWTH_WF_STS) {
		PWTH_WF_STS = pWTH_WF_STS;
	}
	public String getPWTH_TARGET_USGRP() {
		return PWTH_TARGET_USGRP;
	}
	public void setPWTH_TARGET_USGRP(String pWTH_TARGET_USGRP) {
		PWTH_TARGET_USGRP = pWTH_TARGET_USGRP;
	}
	public String getPWTH_DOC_PATH() {
		return PWTH_DOC_PATH;
	}
	public void setPWTH_DOC_PATH(String pWTH_DOC_PATH) {
		PWTH_DOC_PATH = pWTH_DOC_PATH;
	}
	public String getPWTH_FLEX_06() {
		return PWTH_FLEX_06;
	}
	public void setPWTH_FLEX_06(String pWTH_FLEX_06) {
		PWTH_FLEX_06 = pWTH_FLEX_06;
	}
	public String getPWTH_FLEX_07() {
		return PWTH_FLEX_07;
	}
	public void setPWTH_FLEX_07(String pWTH_FLEX_07) {
		PWTH_FLEX_07 = pWTH_FLEX_07;
	}
	public String getPWTH_FLEX_08() {
		return PWTH_FLEX_08;
	}
	public void setPWTH_FLEX_08(String pWTH_FLEX_08) {
		PWTH_FLEX_08 = pWTH_FLEX_08;
	}
	public String getPWTH_FLEX_09() {
		return PWTH_FLEX_09;
	}
	public void setPWTH_FLEX_09(String pWTH_FLEX_09) {
		PWTH_FLEX_09 = pWTH_FLEX_09;
	}
	public String getPWTH_FLEX_10() {
		return PWTH_FLEX_10;
	}
	public void setPWTH_FLEX_10(String pWTH_FLEX_10) {
		PWTH_FLEX_10 = pWTH_FLEX_10;
	}
	public String getPWTH_ESC_LVL_DONE() {
		return PWTH_ESC_LVL_DONE;
	}
	public void setPWTH_ESC_LVL_DONE(String pWTH_ESC_LVL_DONE) {
		PWTH_ESC_LVL_DONE = pWTH_ESC_LVL_DONE;
	}
	public Date getPWTH_ESC_MAIL_DT() {
		return PWTH_ESC_MAIL_DT;
	}
	public void setPWTH_ESC_MAIL_DT(Date pWTH_ESC_MAIL_DT) {
		PWTH_ESC_MAIL_DT = pWTH_ESC_MAIL_DT;
	}
	public String getPWTH_SMS_SENT_YN() {
		return PWTH_SMS_SENT_YN;
	}
	public void setPWTH_SMS_SENT_YN(String pWTH_SMS_SENT_YN) {
		PWTH_SMS_SENT_YN = pWTH_SMS_SENT_YN;
	}
	public String getPWTH_EMAIL_SENT_YN() {
		return PWTH_EMAIL_SENT_YN;
	}
	public void setPWTH_EMAIL_SENT_YN(String pWTH_EMAIL_SENT_YN) {
		PWTH_EMAIL_SENT_YN = pWTH_EMAIL_SENT_YN;
	}
	public String getPWTH_DEPT_CODE() {
		return PWTH_DEPT_CODE;
	}
	public void setPWTH_DEPT_CODE(String pWTH_DEPT_CODE) {
		PWTH_DEPT_CODE = pWTH_DEPT_CODE;
	}
	
}
