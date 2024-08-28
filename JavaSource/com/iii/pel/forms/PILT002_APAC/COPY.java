package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "")
public class COPY extends BaseValueBean {

    @Column(name = "UI_M_POL_NEW_YN")
    private String UI_M_POL_NEW_YN;

    private Date UI_M_COPY_POL_ISSUE_DT;

    private String UI_M_COPY_POL_NO;

    @Column(name = "UI_M_COPY_PT_IL_POL_ASS_DTL")
    private String UI_M_COPY_PT_IL_POL_ASS_DTL;

    @Column(name = "UI_M_COPY_PT_IL_POL_BENEF_DTL")
    private String UI_M_COPY_PT_IL_POL_BENEF_DTL;

    @Column(name = "UI_M_COPY_PT_IL_POL_ADDL_COVER")
    private String UI_M_COPY_PT_IL_POL_ADDL_COVER;

    @Column(name = "UI_M_COPY_PT_IL_POL_DISC_LOAD")
    private String UI_M_COPY_PT_IL_POL_DISC_LOAD;

    @Column(name = "UI_M_COPY_PT_IL_POL_CHARGE")
    private String UI_M_COPY_PT_IL_POL_CHARGE;

    @Column(name = "UI_M_COPY_PT_IL_POL_BROKER")
    private String UI_M_COPY_PT_IL_POL_BROKER;

    @Column(name = "UI_M_COPY_PT_IL_CHECK_LIST")
    private String UI_M_COPY_PT_IL_CHECK_LIST;

    @Column(name = "UI_M_COPY_PT_IL_POL_COND")
    private String UI_M_COPY_PT_IL_POL_COND;

    @Column(name = "UI_M_COPY_PT_IL_MED_HIST")
    private String UI_M_COPY_PT_IL_MED_HIST;

    @Column(name = "UI_M_COPY_PT_IL_APPL_PROD")
    private String UI_M_COPY_PT_IL_APPL_PROD;
    
    private Integer UI_M_COPY_UW_YEAR;
    
    private String UI_SEL_ALL;

  

	public String getUI_SEL_ALL() {
		return UI_SEL_ALL;
	}

	public void setUI_SEL_ALL(String ui_sel_all) {
		UI_SEL_ALL = ui_sel_all;
	}

	public Integer getUI_M_COPY_UW_YEAR() {
        return UI_M_COPY_UW_YEAR;
    }

    public void setUI_M_COPY_UW_YEAR(Integer ui_m_copy_uw_year) {
        UI_M_COPY_UW_YEAR = ui_m_copy_uw_year;
    }

    public String getUI_M_POL_NEW_YN() {
	return UI_M_POL_NEW_YN;
    }

    public void setUI_M_POL_NEW_YN(String ui_m_pol_new_yn) {
	UI_M_POL_NEW_YN = ui_m_pol_new_yn;
    }

    public Date getUI_M_COPY_POL_ISSUE_DT() {
	return UI_M_COPY_POL_ISSUE_DT;
    }

    public void setUI_M_COPY_POL_ISSUE_DT(Date ui_m_copy_pol_issue_dt) {
	UI_M_COPY_POL_ISSUE_DT = ui_m_copy_pol_issue_dt;
    }

    public String getUI_M_COPY_POL_NO() {
	return UI_M_COPY_POL_NO;
    }

    public void setUI_M_COPY_POL_NO(String ui_m_copy_pol_no) {
	UI_M_COPY_POL_NO = ui_m_copy_pol_no;
    }

    public String getUI_M_COPY_PT_IL_POL_ASS_DTL() {
	return UI_M_COPY_PT_IL_POL_ASS_DTL;
    }

    public void setUI_M_COPY_PT_IL_POL_ASS_DTL(
	    String ui_m_copy_pt_il_pol_ass_dtl) {
	UI_M_COPY_PT_IL_POL_ASS_DTL = ui_m_copy_pt_il_pol_ass_dtl;
    }

    public String getUI_M_COPY_PT_IL_POL_BENEF_DTL() {
	return UI_M_COPY_PT_IL_POL_BENEF_DTL;
    }

    public void setUI_M_COPY_PT_IL_POL_BENEF_DTL(
	    String ui_m_copy_pt_il_pol_benef_dtl) {
	UI_M_COPY_PT_IL_POL_BENEF_DTL = ui_m_copy_pt_il_pol_benef_dtl;
    }

    public String getUI_M_COPY_PT_IL_POL_ADDL_COVER() {
	return UI_M_COPY_PT_IL_POL_ADDL_COVER;
    }

    public void setUI_M_COPY_PT_IL_POL_ADDL_COVER(
	    String ui_m_copy_pt_il_pol_addl_cover) {
	UI_M_COPY_PT_IL_POL_ADDL_COVER = ui_m_copy_pt_il_pol_addl_cover;
    }

    public String getUI_M_COPY_PT_IL_POL_DISC_LOAD() {
	return UI_M_COPY_PT_IL_POL_DISC_LOAD;
    }

    public void setUI_M_COPY_PT_IL_POL_DISC_LOAD(
	    String ui_m_copy_pt_il_pol_disc_load) {
	UI_M_COPY_PT_IL_POL_DISC_LOAD = ui_m_copy_pt_il_pol_disc_load;
    }

    public String getUI_M_COPY_PT_IL_POL_CHARGE() {
	return UI_M_COPY_PT_IL_POL_CHARGE;
    }

    public void setUI_M_COPY_PT_IL_POL_CHARGE(String ui_m_copy_pt_il_pol_charge) {
	UI_M_COPY_PT_IL_POL_CHARGE = ui_m_copy_pt_il_pol_charge;
    }

    public String getUI_M_COPY_PT_IL_POL_BROKER() {
	return UI_M_COPY_PT_IL_POL_BROKER;
    }

    public void setUI_M_COPY_PT_IL_POL_BROKER(String ui_m_copy_pt_il_pol_broker) {
	UI_M_COPY_PT_IL_POL_BROKER = ui_m_copy_pt_il_pol_broker;
    }

    public String getUI_M_COPY_PT_IL_CHECK_LIST() {
	return UI_M_COPY_PT_IL_CHECK_LIST;
    }

    public void setUI_M_COPY_PT_IL_CHECK_LIST(String ui_m_copy_pt_il_check_list) {
	UI_M_COPY_PT_IL_CHECK_LIST = ui_m_copy_pt_il_check_list;
    }

    public String getUI_M_COPY_PT_IL_POL_COND() {
	return UI_M_COPY_PT_IL_POL_COND;
    }

    public void setUI_M_COPY_PT_IL_POL_COND(String ui_m_copy_pt_il_pol_cond) {
	UI_M_COPY_PT_IL_POL_COND = ui_m_copy_pt_il_pol_cond;
    }

    public String getUI_M_COPY_PT_IL_MED_HIST() {
	return UI_M_COPY_PT_IL_MED_HIST;
    }

    public void setUI_M_COPY_PT_IL_MED_HIST(String ui_m_copy_pt_il_med_hist) {
	UI_M_COPY_PT_IL_MED_HIST = ui_m_copy_pt_il_med_hist;
    }

    public String getUI_M_COPY_PT_IL_APPL_PROD() {
	return UI_M_COPY_PT_IL_APPL_PROD;
    }

    public void setUI_M_COPY_PT_IL_APPL_PROD(String ui_m_copy_pt_il_appl_prod) {
	UI_M_COPY_PT_IL_APPL_PROD = ui_m_copy_pt_il_appl_prod;
    }

}
