package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_POL_RED_SA")
public class PT_IL_POL_RED_SA extends BaseValueBean {

    @Column(name = "PRS_SYS_ID")
    private Double PRS_SYS_ID;

    @Column(name = "PRS_POL_SYS_ID")
    private Long PRS_POL_SYS_ID;

    @Column(name = "PRS_END_NO_IDX")
    private Double PRS_END_NO_IDX;

    @Column(name = "PRS_MONTH")
    private Double PRS_MONTH;

    @Column(name = "PRS_FC_SA")
    private Double PRS_FC_SA;

    @Column(name = "PRS_LC_SA")
    private Double PRS_LC_SA;

    @Column(name = "PRS_INCOR_FC_SA")
    private Double PRS_INCOR_FC_SA;

    @Column(name = "PRS_INCOR_LC_SA")
    private Double PRS_INCOR_LC_SA;

    @Column(name = "PRS_ORG_FC_SA")
    private Double PRS_ORG_FC_SA;

    @Column(name = "PRS_ORG_LC_SA")
    private Double PRS_ORG_LC_SA;

    @Column(name = "PRS_ORG_INCOR_FC_SA")
    private Double PRS_ORG_INCOR_FC_SA;

    @Column(name = "PRS_ORG_INCOR_LC_SA")
    private Double PRS_ORG_INCOR_LC_SA;

    @Column(name = "PRS_CR_DT")
    private Date PRS_CR_DT;

    @Column(name = "PRS_CR_UID")
    private String PRS_CR_UID;

    @Column(name = "PRS_UPD_DT")
    private Date PRS_UPD_DT;

    @Column(name = "PRS_UPD_UID")
    private String PRS_UPD_UID;

    @Column(name = "PRS_COVER_CODE")
    private String PRS_COVER_CODE;

    @Column(name = "PRS_LC_SURR_AMT")
    private Double PRS_LC_SURR_AMT;

    @Column(name = "PRS_FC_SURR_AMT")
    private Double PRS_FC_SURR_AMT;

    public void setPRS_UPD_UID(String PRS_UPD_UID) {
	this.PRS_UPD_UID = PRS_UPD_UID;
    }

    public String getPRS_UPD_UID() {
	return PRS_UPD_UID;
    }

    public void setPRS_CR_UID(String PRS_CR_UID) {
	this.PRS_CR_UID = PRS_CR_UID;
    }

    public String getPRS_CR_UID() {
	return PRS_CR_UID;
    }

    public void setPRS_END_NO_IDX(Double PRS_END_NO_IDX) {
	this.PRS_END_NO_IDX = PRS_END_NO_IDX;
    }

    public Double getPRS_END_NO_IDX() {
	return PRS_END_NO_IDX;
    }

    public void setPRS_CR_DT(Date PRS_CR_DT) {
	this.PRS_CR_DT = PRS_CR_DT;
    }

    public Date getPRS_CR_DT() {
	return PRS_CR_DT;
    }

    public void setPRS_INCOR_LC_SA(Double PRS_INCOR_LC_SA) {
	this.PRS_INCOR_LC_SA = PRS_INCOR_LC_SA;
    }

    public Double getPRS_INCOR_LC_SA() {
	return PRS_INCOR_LC_SA;
    }

    public void setPRS_FC_SURR_AMT(Double PRS_FC_SURR_AMT) {
	this.PRS_FC_SURR_AMT = PRS_FC_SURR_AMT;
    }

    public Double getPRS_FC_SURR_AMT() {
	return PRS_FC_SURR_AMT;
    }

    public void setPRS_ORG_INCOR_LC_SA(Double PRS_ORG_INCOR_LC_SA) {
	this.PRS_ORG_INCOR_LC_SA = PRS_ORG_INCOR_LC_SA;
    }

    public Double getPRS_ORG_INCOR_LC_SA() {
	return PRS_ORG_INCOR_LC_SA;
    }

    public void setPRS_UPD_DT(Date PRS_UPD_DT) {
	this.PRS_UPD_DT = PRS_UPD_DT;
    }

    public Date getPRS_UPD_DT() {
	return PRS_UPD_DT;
    }

    public void setPRS_ORG_FC_SA(Double PRS_ORG_FC_SA) {
	this.PRS_ORG_FC_SA = PRS_ORG_FC_SA;
    }

    public Double getPRS_ORG_FC_SA() {
	return PRS_ORG_FC_SA;
    }

    public void setPRS_ORG_INCOR_FC_SA(Double PRS_ORG_INCOR_FC_SA) {
	this.PRS_ORG_INCOR_FC_SA = PRS_ORG_INCOR_FC_SA;
    }

    public Double getPRS_ORG_INCOR_FC_SA() {
	return PRS_ORG_INCOR_FC_SA;
    }

    public void setPRS_POL_SYS_ID(Long PRS_POL_SYS_ID) {
	this.PRS_POL_SYS_ID = PRS_POL_SYS_ID;
    }

    public Long getPRS_POL_SYS_ID() {
	return PRS_POL_SYS_ID;
    }

    public void setPRS_INCOR_FC_SA(Double PRS_INCOR_FC_SA) {
	this.PRS_INCOR_FC_SA = PRS_INCOR_FC_SA;
    }

    public Double getPRS_INCOR_FC_SA() {
	return PRS_INCOR_FC_SA;
    }

    public void setPRS_MONTH(Double PRS_MONTH) {
	this.PRS_MONTH = PRS_MONTH;
    }

    public Double getPRS_MONTH() {
	return PRS_MONTH;
    }

    public void setPRS_LC_SURR_AMT(Double PRS_LC_SURR_AMT) {
	this.PRS_LC_SURR_AMT = PRS_LC_SURR_AMT;
    }

    public Double getPRS_LC_SURR_AMT() {
	return PRS_LC_SURR_AMT;
    }

    public void setPRS_ORG_LC_SA(Double PRS_ORG_LC_SA) {
	this.PRS_ORG_LC_SA = PRS_ORG_LC_SA;
    }

    public Double getPRS_ORG_LC_SA() {
	return PRS_ORG_LC_SA;
    }

    public void setPRS_SYS_ID(Double PRS_SYS_ID) {
	this.PRS_SYS_ID = PRS_SYS_ID;
    }

    public Double getPRS_SYS_ID() {
	return PRS_SYS_ID;
    }

    public void setPRS_COVER_CODE(String PRS_COVER_CODE) {
	this.PRS_COVER_CODE = PRS_COVER_CODE;
    }

    public String getPRS_COVER_CODE() {
	return PRS_COVER_CODE;
    }

    public void setPRS_LC_SA(Double PRS_LC_SA) {
	this.PRS_LC_SA = PRS_LC_SA;
    }

    public Double getPRS_LC_SA() {
	return PRS_LC_SA;
    }

    public void setPRS_FC_SA(Double PRS_FC_SA) {
	this.PRS_FC_SA = PRS_FC_SA;
    }

    public Double getPRS_FC_SA() {
	return PRS_FC_SA;
    }

}
