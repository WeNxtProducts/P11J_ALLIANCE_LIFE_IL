package com.iii.pel.forms.PILM201;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_CVR_GROUP_HDR")
public class PM_IL_CVR_GROUP_HDR extends BaseValueBean {

    @Column(name = "CGH_GROUP_CODE")
    private String CGH_GROUP_CODE;

    @Column(name = "CGH_DESC")
    private String CGH_DESC;

    @Column(name = "CGH_SHORT_DESC")
    private String CGH_SHORT_DESC;

    @Column(name = "CGH_LONG_DESC")
    private String CGH_LONG_DESC;

    @Column(name = "CGH_BL_DESC")
    private String CGH_BL_DESC;

    @Column(name = "CGH_BL_SHORT_DESC")
    private String CGH_BL_SHORT_DESC;

    @Column(name = "CGH_BL_LONG_DESC")
    private String CGH_BL_LONG_DESC;

    @Column(name = "CGH_GROUP_TYPE")
    private String CGH_GROUP_TYPE;

    @Column(name = "CGH_PREM_CALC_TYPE")
    private String CGH_PREM_CALC_TYPE;

    @Column(name = "CGH_FRZ_FLAG")
    private String CGH_FRZ_FLAG;

    @Column(name = "CGH_CR_DT")
    private Date CGH_CR_DT;

    @Column(name = "CGH_CR_UID")
    private String CGH_CR_UID;

    @Column(name = "CGH_UPD_DT")
    private Date CGH_UPD_DT;

    @Column(name = "CGH_UPD_UID")
    private String CGH_UPD_UID;

    @Column(name = "CGH_PREM_CALC_LVL")
    private String CGH_PREM_CALC_LVL;

    private boolean CHECK_CGH_FRZ_FLAG;

    
    public void setCGH_BL_SHORT_DESC(String CGH_BL_SHORT_DESC) {
	this.CGH_BL_SHORT_DESC = CGH_BL_SHORT_DESC;
    }

    public String getCGH_BL_SHORT_DESC() {
	return CGH_BL_SHORT_DESC;
    }

    public void setCGH_LONG_DESC(String CGH_LONG_DESC) {
	this.CGH_LONG_DESC = CGH_LONG_DESC;
    }

    public String getCGH_LONG_DESC() {
	return CGH_LONG_DESC;
    }

    public void setCGH_PREM_CALC_LVL(String CGH_PREM_CALC_LVL) {
	this.CGH_PREM_CALC_LVL = CGH_PREM_CALC_LVL;
    }

    public String getCGH_PREM_CALC_LVL() {
	return CGH_PREM_CALC_LVL;
    }

    public void setCGH_GROUP_CODE(String CGH_GROUP_CODE) {
	this.CGH_GROUP_CODE = CGH_GROUP_CODE;
    }

    public String getCGH_GROUP_CODE() {
	return CGH_GROUP_CODE;
    }

    public void setCGH_PREM_CALC_TYPE(String CGH_PREM_CALC_TYPE) {
	this.CGH_PREM_CALC_TYPE = CGH_PREM_CALC_TYPE;
    }

    public String getCGH_PREM_CALC_TYPE() {
	return CGH_PREM_CALC_TYPE;
    }

    public void setCGH_CR_DT(Date CGH_CR_DT) {
	this.CGH_CR_DT = CGH_CR_DT;
    }

    public Date getCGH_CR_DT() {
	return CGH_CR_DT;
    }

    public void setCGH_SHORT_DESC(String CGH_SHORT_DESC) {
	this.CGH_SHORT_DESC = CGH_SHORT_DESC;
    }

    public String getCGH_SHORT_DESC() {
	return CGH_SHORT_DESC;
    }

    public void setCGH_CR_UID(String CGH_CR_UID) {
	this.CGH_CR_UID = CGH_CR_UID;
    }

    public String getCGH_CR_UID() {
	return CGH_CR_UID;
    }

    public void setCGH_UPD_DT(Date CGH_UPD_DT) {
	this.CGH_UPD_DT = CGH_UPD_DT;
    }

    public Date getCGH_UPD_DT() {
	return CGH_UPD_DT;
    }

    public void setCGH_UPD_UID(String CGH_UPD_UID) {
	this.CGH_UPD_UID = CGH_UPD_UID;
    }

    public String getCGH_UPD_UID() {
	return CGH_UPD_UID;
    }

    public void setCGH_FRZ_FLAG(String CGH_FRZ_FLAG) {
	if("Y".equalsIgnoreCase(CGH_FRZ_FLAG)) {
		CHECK_CGH_FRZ_FLAG = true;
	} else {
		CHECK_CGH_FRZ_FLAG = false;
	}
	this.CGH_FRZ_FLAG = CGH_FRZ_FLAG;
    }

    public String getCGH_FRZ_FLAG() {
	if(isCHECK_CGH_FRZ_FLAG() == true) {
		setCGH_FRZ_FLAG("Y");
	} else {
		setCGH_FRZ_FLAG("N");
	}
	return CGH_FRZ_FLAG;
    }

    public void setCGH_BL_LONG_DESC(String CGH_BL_LONG_DESC) {
	this.CGH_BL_LONG_DESC = CGH_BL_LONG_DESC;
    }

    public String getCGH_BL_LONG_DESC() {
	return CGH_BL_LONG_DESC;
    }

    public void setCGH_GROUP_TYPE(String CGH_GROUP_TYPE) {
	this.CGH_GROUP_TYPE = CGH_GROUP_TYPE;
    }

    public String getCGH_GROUP_TYPE() {
	return CGH_GROUP_TYPE;
    }

    public void setCGH_DESC(String CGH_DESC) {
	this.CGH_DESC = CGH_DESC;
    }

    public String getCGH_DESC() {
	return CGH_DESC;
    }

    public void setCGH_BL_DESC(String CGH_BL_DESC) {
	this.CGH_BL_DESC = CGH_BL_DESC;
    }

    public String getCGH_BL_DESC() {
	return CGH_BL_DESC;
    }

    public boolean isCHECK_CGH_FRZ_FLAG() {
        return CHECK_CGH_FRZ_FLAG;
    }

    public void setCHECK_CGH_FRZ_FLAG(boolean check_cgh_frz_flag) {
        CHECK_CGH_FRZ_FLAG = check_cgh_frz_flag;
    }

}
