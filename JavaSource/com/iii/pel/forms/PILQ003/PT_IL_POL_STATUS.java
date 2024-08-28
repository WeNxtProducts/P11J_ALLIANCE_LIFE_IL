package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_POL_STATUS")
public class PT_IL_POL_STATUS extends BaseValueBean {

    @Column(name = "PS_POL_SYS_ID")
    private Double PS_POL_SYS_ID;

    @Column(name = "PS_END_NO_IDX")
    private Double PS_END_NO_IDX;
 
    @Column(name = "PS_STATUS_DT")
    private Date PS_STATUS_DT;

    @Column(name = "PS_STATUS")
    private String PS_STATUS;

    @Column(name = "PS_REASON_CODE")
    private String PS_REASON_CODE;

    @Column(name = "PS_REMARKS")
    private String PS_REMARKS;

    @Column(name = "PS_STATUS_UID")
    private String PS_STATUS_UID;

    @Column(name = "PS_CR_UID")
    private String PS_CR_UID;

    @Column(name = "PS_CR_DT")
    private Date PS_CR_DT;

    @Column(name = "PS_STATUS_TYPE")
    private String PS_STATUS_TYPE;

    @Column(name = "PS_REMINDER_NO")
    private Double PS_REMINDER_NO;

    private Date UI_M_PS_STATUS_DT;
    private String UI_M_PS_STATUS;
    private String UI_M_PS_REASON_CODE;
    private String UI_M_REASON_DESC;
    private String UI_M_PS_REMARKS;
    private String UI_M_POL_MEDICAL_FLAG;
    private Double UI_M_POL_POSTPONE_DAYS;
    private String UI_M_STAT_DESC;
    private String UI_M_PC_DESC;

    public void setPS_CR_UID(String PS_CR_UID) {
	this.PS_CR_UID = PS_CR_UID;
    }

    public String getPS_CR_UID() {
	return PS_CR_UID;
    }

    public void setPS_REASON_CODE(String PS_REASON_CODE) {
	this.PS_REASON_CODE = PS_REASON_CODE;
    }

    public String getPS_REASON_CODE() {
	return PS_REASON_CODE;
    }

    public void setPS_CR_DT(Date PS_CR_DT) {
	this.PS_CR_DT = PS_CR_DT;
    }

    public Date getPS_CR_DT() {
	return PS_CR_DT;
    }

    public void setPS_STATUS(String PS_STATUS) {
	this.PS_STATUS = PS_STATUS;
    }

    public String getPS_STATUS() {
	return PS_STATUS;
    }

    public void setUI_M_POL_POSTPONE_DAYS(Double UI_M_POL_POSTPONE_DAYS) {
	this.UI_M_POL_POSTPONE_DAYS = UI_M_POL_POSTPONE_DAYS;
    }

    public Double getUI_M_POL_POSTPONE_DAYS() {
	return UI_M_POL_POSTPONE_DAYS;
    }

    public void setUI_M_POL_MEDICAL_FLAG(String UI_M_POL_MEDICAL_FLAG) {
	this.UI_M_POL_MEDICAL_FLAG = UI_M_POL_MEDICAL_FLAG;
    }

    public String getUI_M_POL_MEDICAL_FLAG() {
	return UI_M_POL_MEDICAL_FLAG;
    }

    public void setUI_M_PS_REASON_CODE(String UI_M_PS_REASON_CODE) {
	this.UI_M_PS_REASON_CODE = UI_M_PS_REASON_CODE;
    }

    public String getUI_M_PS_REASON_CODE() {
	return UI_M_PS_REASON_CODE;
    }

    public void setPS_POL_SYS_ID(Double PS_POL_SYS_ID) {
	this.PS_POL_SYS_ID = PS_POL_SYS_ID;
    }

    public Double getPS_POL_SYS_ID() {
	return PS_POL_SYS_ID;
    }

    public void setPS_END_NO_IDX(Double PS_END_NO_IDX) {
	this.PS_END_NO_IDX = PS_END_NO_IDX;
    }

    public Double getPS_END_NO_IDX() {
	return PS_END_NO_IDX;
    }

    public void setUI_M_PS_REMARKS(String UI_M_PS_REMARKS) {
	this.UI_M_PS_REMARKS = UI_M_PS_REMARKS;
    }

    public String getUI_M_PS_REMARKS() {
	return UI_M_PS_REMARKS;
    }

    public void setUI_M_REASON_DESC(String UI_M_REASON_DESC) {
	this.UI_M_REASON_DESC = UI_M_REASON_DESC;
    }

    public String getUI_M_REASON_DESC() {
	return UI_M_REASON_DESC;
    }

    public void setUI_M_STAT_DESC(String UI_M_STAT_DESC) {
	this.UI_M_STAT_DESC = UI_M_STAT_DESC;
    }

    public String getUI_M_STAT_DESC() {
	return UI_M_STAT_DESC;
    }

    public void setPS_REMARKS(String PS_REMARKS) {
	this.PS_REMARKS = PS_REMARKS;
    }

    public String getPS_REMARKS() {
	return PS_REMARKS;
    }

    public void setPS_REMINDER_NO(Double PS_REMINDER_NO) {
	this.PS_REMINDER_NO = PS_REMINDER_NO;
    }

    public Double getPS_REMINDER_NO() {
	return PS_REMINDER_NO;
    }

    public void setUI_M_PC_DESC(String UI_M_PC_DESC) {
	this.UI_M_PC_DESC = UI_M_PC_DESC;
    }

    public String getUI_M_PC_DESC() {
	return UI_M_PC_DESC;
    }

    public void setPS_STATUS_TYPE(String PS_STATUS_TYPE) {
	this.PS_STATUS_TYPE = PS_STATUS_TYPE;
    }

    public String getPS_STATUS_TYPE() {
	return PS_STATUS_TYPE;
    }

    public void setPS_STATUS_DT(Date PS_STATUS_DT) {
	this.PS_STATUS_DT = PS_STATUS_DT;
    }

    public Date getPS_STATUS_DT() {
	return PS_STATUS_DT;
    }

    public void setUI_M_PS_STATUS_DT(Date UI_M_PS_STATUS_DT) {
	this.UI_M_PS_STATUS_DT = UI_M_PS_STATUS_DT;
    }

    public Date getUI_M_PS_STATUS_DT() {
	return UI_M_PS_STATUS_DT;
    }

    public void setPS_STATUS_UID(String PS_STATUS_UID) {
	this.PS_STATUS_UID = PS_STATUS_UID;
    }

    public String getPS_STATUS_UID() {
	return PS_STATUS_UID;
    }

    public void setUI_M_PS_STATUS(String UI_M_PS_STATUS) {
	this.UI_M_PS_STATUS = UI_M_PS_STATUS;
    }

    public String getUI_M_PS_STATUS() {
	return UI_M_PS_STATUS;
    }

}
