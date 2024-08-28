package com.iii.pel.forms.WORKFLOW;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PGIM_WORKFLOW_BUCKET")
public class PGIM_WORKFLOW_BUCKET extends BaseValueBean{

	
	@Column(name="PWB_CODE")
	private String PWB_CODE;
	@Column(name="PWB_MAIN_BUKT")
	private String PWB_MAIN_BUKT;
	@Column(name="PWB_WORKSTEP_ID")
	private String PWB_WORKSTEP_ID;
	@Column(name="PWB_DESC")
	private String PWB_DESC;
	@Column(name="PWB_SR_NO")
	private Long PWB_SR_NO;
	@Column(name="PWB_ENABLE_YN")
	private String PWB_ENABLE_YN;
	@Column(name="PWB_CR_UID")
	private String PWB_CR_UID;
	@Column(name="PWB_CR_DT")
	private Date PWB_CR_DT; 
	@Column(name="PWB_MAIL_ONLY_YN")
	private String PWB_MAIL_ONLY_YN;
	@Column(name="PWB_SMS_YN")
	private String PWB_SMS_YN;
	@Column(name="PWB_OUTCOME_DET")
	private String PWB_OUTCOME_DET;
	@Column(name="PWB_LIMIT_FROM")
	private Long PWB_LIMIT_FROM;
	@Column(name="PWB_LIMIT_TO")
	private Long PWB_LIMIT_TO;
	
	/*Added by kavitha on 01.11.2019 for Roadmap*/
	@Column(name="PWB_TOBE_OUTCOME")
	private String PWB_TOBE_OUTCOME;
	//Added by kavitha on 21.11.2019 for Roadmap
	@Column(name="PWB_STATUS_CODE")
	private String PWB_STATUS_CODE;
	
	private String UI_M_PWB_STATUS_CODE_DESC;
	
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
	public Long getPWB_SR_NO() {
		return PWB_SR_NO;
	}
	public void setPWB_SR_NO(Long pWB_SR_NO) {
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
	public Date getPWB_CR_DT() {
		return PWB_CR_DT;
	}
	public void setPWB_CR_DT(Date pWB_CR_DT) {
		PWB_CR_DT = pWB_CR_DT;
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
	public String getPWB_OUTCOME_DET() {
		return PWB_OUTCOME_DET;
	}
	public void setPWB_OUTCOME_DET(String pWB_OUTCOME_DET) {
		PWB_OUTCOME_DET = pWB_OUTCOME_DET;
	}
	public Long getPWB_LIMIT_FROM() {
		return PWB_LIMIT_FROM;
	}
	public void setPWB_LIMIT_FROM(Long pWB_LIMIT_FROM) {
		PWB_LIMIT_FROM = pWB_LIMIT_FROM;
	}
	public Long getPWB_LIMIT_TO() {
		return PWB_LIMIT_TO;
	}
	public void setPWB_LIMIT_TO(Long pWB_LIMIT_TO) {
		PWB_LIMIT_TO = pWB_LIMIT_TO;
	}
	public String getPWB_TOBE_OUTCOME() {
		return PWB_TOBE_OUTCOME;
	}
	public void setPWB_TOBE_OUTCOME(String pWB_TOBE_OUTCOME) {
		PWB_TOBE_OUTCOME = pWB_TOBE_OUTCOME;
	}
	public String getPWB_STATUS_CODE() {
		return PWB_STATUS_CODE;
	}
	public void setPWB_STATUS_CODE(String pWB_STATUS_CODE) {
		PWB_STATUS_CODE = pWB_STATUS_CODE;
	}
	public String getUI_M_PWB_STATUS_CODE_DESC() {
		return UI_M_PWB_STATUS_CODE_DESC;
	}
	public void setUI_M_PWB_STATUS_CODE_DESC(String uI_M_PWB_STATUS_CODE_DESC) {
		UI_M_PWB_STATUS_CODE_DESC = uI_M_PWB_STATUS_CODE_DESC;
	}
	
	
}
