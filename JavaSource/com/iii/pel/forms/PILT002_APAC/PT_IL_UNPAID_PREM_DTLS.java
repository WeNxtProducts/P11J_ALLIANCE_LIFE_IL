package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_UNPAID_PREM_DTLS")
public class PT_IL_UNPAID_PREM_DTLS extends BaseValueBean {

    @Column(name = "UPD_SYS_ID")
    private Double UPD_SYS_ID;

    @Column(name = "UPD_POL_SYS_ID")
    private Double UPD_POL_SYS_ID;

    @Column(name = "UPD_PAY_DT")
    private Date UPD_PAY_DT;

    @Column(name = "UPD_FC_UNPAID_PREM")
    private Double UPD_FC_UNPAID_PREM;

    @Column(name = "UPD_LC_UNPAID_PREM")
    private Double UPD_LC_UNPAID_PREM;

    @Column(name = "UPD_INT_CODE")
    private String UPD_INT_CODE;

    @Column(name = "UPD_INT_PERC")
    private Double UPD_INT_PERC;

    @Column(name = "UPD_FC_INTEREST")
    private Double UPD_FC_INTEREST;

    @Column(name = "UPD_LC_INTEREST")
    private Double UPD_LC_INTEREST;

    @Column(name = "UPD_CR_UID")
    private String UPD_CR_UID;

    @Column(name = "UPD_CR_DT")
    private Date UPD_CR_DT;

    @Column(name = "UPD_UPD_UID")
    private String UPD_UPD_UID;

    @Column(name = "UPD_UPD_DT")
    private Date UPD_UPD_DT;

    public void setUPD_PAY_DT(Date UPD_PAY_DT) {
	this.UPD_PAY_DT = UPD_PAY_DT;
    }

    public Date getUPD_PAY_DT() {
	return UPD_PAY_DT;
    }

    public void setUPD_CR_DT(Date UPD_CR_DT) {
	this.UPD_CR_DT = UPD_CR_DT;
    }

    public Date getUPD_CR_DT() {
	return UPD_CR_DT;
    }

    public void setUPD_INT_PERC(Double UPD_INT_PERC) {
	this.UPD_INT_PERC = UPD_INT_PERC;
    }

    public Double getUPD_INT_PERC() {
	return UPD_INT_PERC;
    }

    public void setUPD_UPD_DT(Date UPD_UPD_DT) {
	this.UPD_UPD_DT = UPD_UPD_DT;
    }

    public Date getUPD_UPD_DT() {
	return UPD_UPD_DT;
    }

    public void setUPD_CR_UID(String UPD_CR_UID) {
	this.UPD_CR_UID = UPD_CR_UID;
    }

    public String getUPD_CR_UID() {
	return UPD_CR_UID;
    }

    public void setUPD_LC_UNPAID_PREM(Double UPD_LC_UNPAID_PREM) {
	this.UPD_LC_UNPAID_PREM = UPD_LC_UNPAID_PREM;
    }

    public Double getUPD_LC_UNPAID_PREM() {
	return UPD_LC_UNPAID_PREM;
    }

    public void setUPD_FC_UNPAID_PREM(Double UPD_FC_UNPAID_PREM) {
	this.UPD_FC_UNPAID_PREM = UPD_FC_UNPAID_PREM;
    }

    public Double getUPD_FC_UNPAID_PREM() {
	return UPD_FC_UNPAID_PREM;
    }

    public void setUPD_LC_INTEREST(Double UPD_LC_INTEREST) {
	this.UPD_LC_INTEREST = UPD_LC_INTEREST;
    }

    public Double getUPD_LC_INTEREST() {
	return UPD_LC_INTEREST;
    }

    public void setUPD_SYS_ID(Double UPD_SYS_ID) {
	this.UPD_SYS_ID = UPD_SYS_ID;
    }

    public Double getUPD_SYS_ID() {
	return UPD_SYS_ID;
    }

    public void setUPD_POL_SYS_ID(Double UPD_POL_SYS_ID) {
	this.UPD_POL_SYS_ID = UPD_POL_SYS_ID;
    }

    public Double getUPD_POL_SYS_ID() {
	return UPD_POL_SYS_ID;
    }

    public void setUPD_FC_INTEREST(Double UPD_FC_INTEREST) {
	this.UPD_FC_INTEREST = UPD_FC_INTEREST;
    }

    public Double getUPD_FC_INTEREST() {
	return UPD_FC_INTEREST;
    }

    public void setUPD_UPD_UID(String UPD_UPD_UID) {
	this.UPD_UPD_UID = UPD_UPD_UID;
    }

    public String getUPD_UPD_UID() {
	return UPD_UPD_UID;
    }

    public void setUPD_INT_CODE(String UPD_INT_CODE) {
	this.UPD_INT_CODE = UPD_INT_CODE;
    }

    public String getUPD_INT_CODE() {
	return UPD_INT_CODE;
    }

}
