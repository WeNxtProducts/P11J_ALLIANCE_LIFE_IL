package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_POL_SA_INST_PYMT")
public class PT_IL_POL_SA_INST_PYMT extends BaseValueBean {

    @Column(name = "SIPD_SYS_ID")
    private Long SIPD_SYS_ID;

    @Column(name = "SIPD_POL_SYS_ID")
    private Long SIPD_POL_SYS_ID;

    @Column(name = "SIPD_PLAN_CODE")
    private String SIPD_PLAN_CODE;

    @Column(name = "SIPD_PROD_CODE")
    private String SIPD_PROD_CODE;

    @Column(name = "SIPD_PROD_MAT_AMT_TYPE")
    private String SIPD_PROD_MAT_AMT_TYPE;

    @Column(name = "SIPD_NAV_TYPE")
    private String SIPD_NAV_TYPE;

    @Column(name = "SIPD_PERC")
    private Double SIPD_PERC;

    @Column(name = "SIPD_NUMR_PERIOD")
    private Double SIPD_NUMR_PERIOD;

    @Column(name = "SIPD_DEMR_PERIOD")
    private Double SIPD_DEMR_PERIOD;

    @Column(name = "SIPD_REMARKS")
    private String SIPD_REMARKS;

    @Column(name = "SIPD_BL_REMARKS")
    private String SIPD_BL_REMARKS;

    @Column(name = "SIPD_CR_DT")
    private Date SIPD_CR_DT;

    @Column(name = "SIPD_CR_UID")
    private String SIPD_CR_UID;

    @Column(name = "SIPD_UPD_DT")
    private Date SIPD_UPD_DT;

    @Column(name = "SIPD_UPD_UID")
    private String SIPD_UPD_UID;

    @Column(name = "SIPD_SIPH_SYS_ID")
    private Long SIPD_SIPH_SYS_ID;

    @Column(name = "SIPD_PROD_SURR_PLUS_FACTOR")
    private String SIPD_PROD_SURR_PLUS_FACTOR;

    public void setSIPD_REMARKS(String SIPD_REMARKS) {
	this.SIPD_REMARKS = SIPD_REMARKS;
    }

    public String getSIPD_REMARKS() {
	return SIPD_REMARKS;
    }

    public void setSIPD_CR_DT(Date SIPD_CR_DT) {
	this.SIPD_CR_DT = SIPD_CR_DT;
    }

    public Date getSIPD_CR_DT() {
	return SIPD_CR_DT;
    }

    public void setSIPD_UPD_UID(String SIPD_UPD_UID) {
	this.SIPD_UPD_UID = SIPD_UPD_UID;
    }

    public String getSIPD_UPD_UID() {
	return SIPD_UPD_UID;
    }

    public void setSIPD_PROD_CODE(String SIPD_PROD_CODE) {
	this.SIPD_PROD_CODE = SIPD_PROD_CODE;
    }

    public String getSIPD_PROD_CODE() {
	return SIPD_PROD_CODE;
    }

    public void setSIPD_PROD_SURR_PLUS_FACTOR(String SIPD_PROD_SURR_PLUS_FACTOR) {
	this.SIPD_PROD_SURR_PLUS_FACTOR = SIPD_PROD_SURR_PLUS_FACTOR;
    }

    public String getSIPD_PROD_SURR_PLUS_FACTOR() {
	return SIPD_PROD_SURR_PLUS_FACTOR;
    }

    public void setSIPD_SYS_ID(Long SIPD_SYS_ID) {
	this.SIPD_SYS_ID = SIPD_SYS_ID;
    }

    public Long getSIPD_SYS_ID() {
	return SIPD_SYS_ID;
    }

    public void setSIPD_POL_SYS_ID(Long SIPD_POL_SYS_ID) {
	this.SIPD_POL_SYS_ID = SIPD_POL_SYS_ID;
    }

    public Long getSIPD_POL_SYS_ID() {
	return SIPD_POL_SYS_ID;
    }

    public void setSIPD_PLAN_CODE(String SIPD_PLAN_CODE) {
	this.SIPD_PLAN_CODE = SIPD_PLAN_CODE;
    }

    public String getSIPD_PLAN_CODE() {
	return SIPD_PLAN_CODE;
    }

    public void setSIPD_PROD_MAT_AMT_TYPE(String SIPD_PROD_MAT_AMT_TYPE) {
	this.SIPD_PROD_MAT_AMT_TYPE = SIPD_PROD_MAT_AMT_TYPE;
    }

    public String getSIPD_PROD_MAT_AMT_TYPE() {
	return SIPD_PROD_MAT_AMT_TYPE;
    }

    public void setSIPD_NUMR_PERIOD(Double SIPD_NUMR_PERIOD) {
	this.SIPD_NUMR_PERIOD = SIPD_NUMR_PERIOD;
    }

    public Double getSIPD_NUMR_PERIOD() {
	return SIPD_NUMR_PERIOD;
    }

    public void setSIPD_UPD_DT(Date SIPD_UPD_DT) {
	this.SIPD_UPD_DT = SIPD_UPD_DT;
    }

    public Date getSIPD_UPD_DT() {
	return SIPD_UPD_DT;
    }

    public void setSIPD_PERC(Double SIPD_PERC) {
	this.SIPD_PERC = SIPD_PERC;
    }

    public Double getSIPD_PERC() {
	return SIPD_PERC;
    }

    public void setSIPD_CR_UID(String SIPD_CR_UID) {
	this.SIPD_CR_UID = SIPD_CR_UID;
    }

    public String getSIPD_CR_UID() {
	return SIPD_CR_UID;
    }

    public void setSIPD_BL_REMARKS(String SIPD_BL_REMARKS) {
	this.SIPD_BL_REMARKS = SIPD_BL_REMARKS;
    }

    public String getSIPD_BL_REMARKS() {
	return SIPD_BL_REMARKS;
    }

    public void setSIPD_SIPH_SYS_ID(Long SIPD_SIPH_SYS_ID) {
	this.SIPD_SIPH_SYS_ID = SIPD_SIPH_SYS_ID;
    }

    public Long getSIPD_SIPH_SYS_ID() {
	return SIPD_SIPH_SYS_ID;
    }

    public void setSIPD_DEMR_PERIOD(Double SIPD_DEMR_PERIOD) {
	this.SIPD_DEMR_PERIOD = SIPD_DEMR_PERIOD;
    }

    public Double getSIPD_DEMR_PERIOD() {
	return SIPD_DEMR_PERIOD;
    }

    public void setSIPD_NAV_TYPE(String SIPD_NAV_TYPE) {
	this.SIPD_NAV_TYPE = SIPD_NAV_TYPE;
    }

    public String getSIPD_NAV_TYPE() {
	return SIPD_NAV_TYPE;
    }

}
