package com.iii.pel.common.workflow;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PGIM_WORKFLOW_BUCKET")
public class PGIM_WORKFLOW_BUCKET extends BaseValueBean {
private String PWB_CODE;
private String PWB_MAIN_BUKT;
private String PWB_WORKSTEP_ID;
private String 	PWB_DESC;
private long PWB_SR_NO;
private String 	PWB_ENABLE_YN;
private String 	PWB_CR_UID;
private Date 	PWB_CR_DT;
private String 	PWB_MAIL_ONLY_YN;
private String 	PWB_SMS_YN;
private String transactionCount;
/* Added by kavitha for RoadMap*/
private String assignedTo;
private long SYS_ID;
/*End*/
public String getTransactionCount() {
	return transactionCount;
}
public void setTransactionCount(String transactionCount) {
	this.transactionCount = transactionCount;
}
public String getPWB_CODE() {
	return PWB_CODE;
}
public void setPWB_CODE(String pWB_CODE) {
	PWB_CODE = pWB_CODE;
}
public String getPWB_MAIN_BUKT() {
	return PWB_MAIN_BUKT;
}
public void setPWB_MAIN_BUKT(String pWB_MAIN_BUKT) {
	PWB_MAIN_BUKT = pWB_MAIN_BUKT;
}
public String getPWB_WORKSTEP_ID() {
	return PWB_WORKSTEP_ID;
}
public void setPWB_WORKSTEP_ID(String pWB_WORKSTEP_ID) {
	PWB_WORKSTEP_ID = pWB_WORKSTEP_ID;
}
public String getPWB_DESC() {
	return PWB_DESC;
}
public void setPWB_DESC(String pWB_DESC) {
	PWB_DESC = pWB_DESC;
}
public long getPWB_SR_NO() {
	return PWB_SR_NO;
}
public void setPWB_SR_NO(long pWB_SR_NO) {
	PWB_SR_NO = pWB_SR_NO;
}
public String getPWB_ENABLE_YN() {
	return PWB_ENABLE_YN;
}
public void setPWB_ENABLE_YN(String pWB_ENABLE_YN) {
	PWB_ENABLE_YN = pWB_ENABLE_YN;
}
public String getPWB_CR_UID() {
	return PWB_CR_UID;
}
public void setPWB_CR_UID(String pWB_CR_UID) {
	PWB_CR_UID = pWB_CR_UID;
}

public String getPWB_MAIL_ONLY_YN() {
	return PWB_MAIL_ONLY_YN;
}
public void setPWB_MAIL_ONLY_YN(String pWB_MAIL_ONLY_YN) {
	PWB_MAIL_ONLY_YN = pWB_MAIL_ONLY_YN;
}
public String getPWB_SMS_YN() {
	return PWB_SMS_YN;
}
public void setPWB_SMS_YN(String pWB_SMS_YN) {
	PWB_SMS_YN = pWB_SMS_YN;
}
public Date getPWB_CR_DT() {
	return PWB_CR_DT;
}
public void setPWB_CR_DT(Date pWB_CR_DT) {
	PWB_CR_DT = pWB_CR_DT;
}
/* Added by kavitha for RoadMap*/
public String getAssignedTo() {
	return assignedTo;
}
public void setAssignedTo(String assignedTo) {
	this.assignedTo = assignedTo;
}
/*End*/
public long getSYS_ID() {
	return SYS_ID;
}
public void setSYS_ID(long sYS_ID) {
	SYS_ID = sYS_ID;
}

}
