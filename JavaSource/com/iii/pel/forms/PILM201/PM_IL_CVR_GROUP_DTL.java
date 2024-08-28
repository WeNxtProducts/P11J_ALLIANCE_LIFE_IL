package com.iii.pel.forms.PILM201;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_CVR_GROUP_DTL")
public class PM_IL_CVR_GROUP_DTL extends BaseValueBean {

    @Column(name = "CGD_GROUP_CODE")
    private String CGD_GROUP_CODE;

    @Column(name = "CGD_COVER_CODE")
    private String CGD_COVER_CODE;

    @Column(name = "CGD_FRZ_FLAG")
    private String CGD_FRZ_FLAG;

    @Column(name = "CGD_CR_DT")
    private Date CGD_CR_DT;

    @Column(name = "CGD_CR_UID")
    private String CGD_CR_UID;

    @Column(name = "CGD_UPD_DT")
    private Date CGD_UPD_DT;

    @Column(name = "CGD_UPD_UID")
    private String CGD_UPD_UID;

    @Column(name = "CGD_DEFAULT_YN")
    private String CGD_DEFAULT_YN;

    private String UI_M_CVR_DESC;
    
    private boolean CHECK_CGD_FRZ_FLAG;

    public boolean isCHECK_CGD_FRZ_FLAG() {
        return CHECK_CGD_FRZ_FLAG;
    }

    public void setCHECK_CGD_FRZ_FLAG(boolean check_cgd_frz_flag) {
        CHECK_CGD_FRZ_FLAG = check_cgd_frz_flag;
    }

    public void setCGD_FRZ_FLAG(String CGD_FRZ_FLAG) {
	if("Y".equalsIgnoreCase(CGD_FRZ_FLAG)){
	     CHECK_CGD_FRZ_FLAG = true;
	}
	else{
	    CHECK_CGD_FRZ_FLAG= false;
	}
	this.CGD_FRZ_FLAG = CGD_FRZ_FLAG;
    }

    public String getCGD_FRZ_FLAG() {
	if(isCHECK_CGD_FRZ_FLAG()==true){
	    setCGD_FRZ_FLAG("Y");
	}
	else{
	    setCGD_FRZ_FLAG("N");
	}
	return CGD_FRZ_FLAG;
    }

    public void setCGD_GROUP_CODE(String CGD_GROUP_CODE) {
	this.CGD_GROUP_CODE = CGD_GROUP_CODE;
    }

    public String getCGD_GROUP_CODE() {
	return CGD_GROUP_CODE;
    }

    public void setCGD_COVER_CODE(String CGD_COVER_CODE) {
	this.CGD_COVER_CODE = CGD_COVER_CODE;
    }

    public String getCGD_COVER_CODE() {
	return CGD_COVER_CODE;
    }

    public void setUI_M_CVR_DESC(String UI_M_CVR_DESC) {
	this.UI_M_CVR_DESC = UI_M_CVR_DESC;
    }

    public String getUI_M_CVR_DESC() {
	return UI_M_CVR_DESC;
    }

    public void setCGD_DEFAULT_YN(String CGD_DEFAULT_YN) {
	this.CGD_DEFAULT_YN = CGD_DEFAULT_YN;
    }

    public String getCGD_DEFAULT_YN() {
	return CGD_DEFAULT_YN;
    }

    public void setCGD_UPD_UID(String CGD_UPD_UID) {
	this.CGD_UPD_UID = CGD_UPD_UID;
    }

    public String getCGD_UPD_UID() {
	return CGD_UPD_UID;
    }

    public void setCGD_CR_UID(String CGD_CR_UID) {
	this.CGD_CR_UID = CGD_CR_UID;
    }

    public String getCGD_CR_UID() {
	return CGD_CR_UID;
    }

    public void setCGD_CR_DT(Date CGD_CR_DT) {
	this.CGD_CR_DT = CGD_CR_DT;
    }

    public Date getCGD_CR_DT() {
	return CGD_CR_DT;
    }

    public void setCGD_UPD_DT(Date CGD_UPD_DT) {
	this.CGD_UPD_DT = CGD_UPD_DT;
    }

    public Date getCGD_UPD_DT() {
	return CGD_UPD_DT;
    }

}
