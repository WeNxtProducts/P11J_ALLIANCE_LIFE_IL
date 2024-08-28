package com.iii.pel.forms.PILM070_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PP_LIFE_POL_SCH_PRN")
public class PP_LIFE_POL_SCH_PRN extends BaseValueBean {

    @Id
    @Column(name = "ROWID")
    private String ROWID;

    @Column(name = "PLSP_DS_TYPE")
    private String PLSP_DS_TYPE;

    @Column(name = "PLSP_DS_CODE")
    private String PLSP_DS_CODE;

    @Column(name = "PLSP_MODULE_ID")
    private String PLSP_MODULE_ID;

    private String UI_M_PLSP_DS_TYPE_DESC;

    private String UI_M_PLSP_PROD_CODE_DESC;

    @Column(name = "PLSP_PROD_CODE")
    private String PLSP_PROD_CODE;

    // private String UI_M_PLSP_MODULE_ID;

    @Column(name = "PLSP_REPORT_ID")
    private String PLSP_REPORT_ID;

    // private String UI_M_PLSP_MODULE_ID_DESC;

    private String UI_M_PLSP_DS_CODE_DESC;

    @Column(name = "PLSP_REPORT_NAME")
    private String PLSP_REPORT_NAME;

    @Column(name = "PLSP_TYPE")
    private String PLSP_TYPE;

    @Column(name = "PLSP_CR_UID")
    private String PLSP_CR_UID;

    @Column(name = "PLSP_CR_DT")
    private Date PLSP_CR_DT;

    @Column(name = "PLSP_MODULE_NAME")
    private String PLSP_MODULE_NAME;

    @Column(name = "PLSP_SRNO")
    private Integer PLSP_SRNO;

    private boolean CHECK_BOX;

    private String DS_TYPE_SEARCH;

    private String DS_CODE_SEARCH;

    private String PROD_CODE_SEARCH;

    private String REPORT_ID_SEARCH;

    private String REPORT_NAME_SEARCH;

    public PP_LIFE_POL_SCH_PRN() {
    }

    public PP_LIFE_POL_SCH_PRN(String PLSP_DS_TYPE, String PLSP_DS_CODE,
	    String PLSP_MODULE_ID, String UI_M_PLSP_DS_TYPE_DESC,
	    String UI_M_PLSP_PROD_CODE_DESC, String PLSP_PROD_CODE,
	    String UI_M_PLSP_MODULE_ID, String PLSP_REPORT_ID,
	    String UI_M_PLSP_MODULE_ID_DESC, String UI_M_PLSP_DS_CODE_DESC,
	    String PLSP_REPORT_NAME, String PLSP_TYPE) {
	this.PLSP_DS_TYPE = PLSP_DS_TYPE;
	this.PLSP_DS_CODE = PLSP_DS_CODE;
	this.PLSP_MODULE_ID = PLSP_MODULE_ID;
	this.UI_M_PLSP_DS_TYPE_DESC = UI_M_PLSP_DS_TYPE_DESC;
	this.UI_M_PLSP_PROD_CODE_DESC = UI_M_PLSP_PROD_CODE_DESC;
	this.PLSP_PROD_CODE = PLSP_PROD_CODE;
	// this.UI_M_PLSP_MODULE_ID = UI_M_PLSP_MODULE_ID;
	this.PLSP_REPORT_ID = PLSP_REPORT_ID;
	// this.UI_M_PLSP_MODULE_ID_DESC = UI_M_PLSP_MODULE_ID_DESC;
	this.UI_M_PLSP_DS_CODE_DESC = UI_M_PLSP_DS_CODE_DESC;
	this.PLSP_REPORT_NAME = PLSP_REPORT_NAME;
	this.PLSP_TYPE = PLSP_TYPE;
    }

    public String getPLSP_DS_TYPE() {
	return PLSP_DS_TYPE;
    }

    public void setPLSP_DS_TYPE(String PLSP_DS_TYPE) {
	this.PLSP_DS_TYPE = PLSP_DS_TYPE;
    }

    public String getPLSP_DS_CODE() {
	return PLSP_DS_CODE;
    }

    public void setPLSP_DS_CODE(String PLSP_DS_CODE) {
	this.PLSP_DS_CODE = PLSP_DS_CODE;
    }

    public String getUI_M_PLSP_DS_TYPE_DESC() {
	return UI_M_PLSP_DS_TYPE_DESC;
    }

    public void setUI_M_PLSP_DS_TYPE_DESC(String UI_M_PLSP_DS_TYPE_DESC) {
	this.UI_M_PLSP_DS_TYPE_DESC = UI_M_PLSP_DS_TYPE_DESC;
    }

    public String getUI_M_PLSP_PROD_CODE_DESC() {
	return UI_M_PLSP_PROD_CODE_DESC;
    }

    public void setUI_M_PLSP_PROD_CODE_DESC(String UI_M_PLSP_PROD_CODE_DESC) {
	this.UI_M_PLSP_PROD_CODE_DESC = UI_M_PLSP_PROD_CODE_DESC;
    }

    public String getPLSP_PROD_CODE() {
	return PLSP_PROD_CODE;
    }

    public void setPLSP_PROD_CODE(String PLSP_PROD_CODE) {
	this.PLSP_PROD_CODE = PLSP_PROD_CODE;
    }

    /*
     * public String getUI_M_PLSP_MODULE_ID() { return UI_M_PLSP_MODULE_ID; }
     * 
     * public void setUI_M_PLSP_MODULE_ID(String UI_M_PLSP_MODULE_ID) {
     * this.UI_M_PLSP_MODULE_ID = UI_M_PLSP_MODULE_ID; }
     */

    public String getPLSP_REPORT_ID() {
	return PLSP_REPORT_ID;
    }

    public void setPLSP_REPORT_ID(String PLSP_REPORT_ID) {
	this.PLSP_REPORT_ID = PLSP_REPORT_ID;
    }

    /*
     * public String getUI_M_PLSP_MODULE_ID_DESC() { return
     * UI_M_PLSP_MODULE_ID_DESC; }
     * 
     * public void setUI_M_PLSP_MODULE_ID_DESC(String UI_M_PLSP_MODULE_ID_DESC) {
     * this.UI_M_PLSP_MODULE_ID_DESC = UI_M_PLSP_MODULE_ID_DESC; }
     */
    public String getUI_M_PLSP_DS_CODE_DESC() {
	return UI_M_PLSP_DS_CODE_DESC;
    }

    public void setUI_M_PLSP_DS_CODE_DESC(String UI_M_PLSP_DS_CODE_DESC) {
	this.UI_M_PLSP_DS_CODE_DESC = UI_M_PLSP_DS_CODE_DESC;
    }

    public String getPLSP_REPORT_NAME() {
	return PLSP_REPORT_NAME;
    }

    public void setPLSP_REPORT_NAME(String PLSP_REPORT_NAME) {
	this.PLSP_REPORT_NAME = PLSP_REPORT_NAME;
    }

    public String getPLSP_TYPE() {
	return PLSP_TYPE;
    }

    public void setPLSP_TYPE(String PLSP_TYPE) {
	this.PLSP_TYPE = PLSP_TYPE;
    }

    public String getPLSP_MODULE_ID() {
	return PLSP_MODULE_ID;
    }

    public void setPLSP_MODULE_ID(String plsp_module_id) {
	PLSP_MODULE_ID = plsp_module_id;
    }

    public String getROWID() {
	return ROWID;
    }

    public void setROWID(String rowid) {
	ROWID = rowid;
    }

    public String getPLSP_CR_UID() {
	return PLSP_CR_UID;
    }

    public void setPLSP_CR_UID(String plsp_cr_uid) {
	PLSP_CR_UID = plsp_cr_uid;
    }

    public Date getPLSP_CR_DT() {
	return PLSP_CR_DT;
    }

    public void setPLSP_CR_DT(Date plsp_cr_dt) {
	PLSP_CR_DT = plsp_cr_dt;
    }

    public boolean isCHECK_BOX() {
	return CHECK_BOX;
    }

    public void setCHECK_BOX(boolean check_box) {
	CHECK_BOX = check_box;
    }

    public String getDS_TYPE_SEARCH() {
	return DS_TYPE_SEARCH;
    }

    public void setDS_TYPE_SEARCH(String ds_type_search) {
	DS_TYPE_SEARCH = ds_type_search;
    }

    public String getDS_CODE_SEARCH() {
	return DS_CODE_SEARCH;
    }

    public void setDS_CODE_SEARCH(String ds_code_search) {
	DS_CODE_SEARCH = ds_code_search;
    }

    public String getPROD_CODE_SEARCH() {
	return PROD_CODE_SEARCH;
    }

    public void setPROD_CODE_SEARCH(String prod_code_search) {
	PROD_CODE_SEARCH = prod_code_search;
    }

    public String getREPORT_ID_SEARCH() {
	return REPORT_ID_SEARCH;
    }

    public void setREPORT_ID_SEARCH(String report_id_search) {
	REPORT_ID_SEARCH = report_id_search;
    }

    public String getREPORT_NAME_SEARCH() {
	return REPORT_NAME_SEARCH;
    }

    public void setREPORT_NAME_SEARCH(String report_name_search) {
	REPORT_NAME_SEARCH = report_name_search;
    }

    public String getPLSP_MODULE_NAME() {
	return PLSP_MODULE_NAME;
    }

    public void setPLSP_MODULE_NAME(String plsp_module_name) {
	PLSP_MODULE_NAME = plsp_module_name;
    }

    public Integer getPLSP_SRNO() {
	return PLSP_SRNO;
    }

    public void setPLSP_SRNO(Integer plsp_srno) {
	PLSP_SRNO = plsp_srno;
    }

}
