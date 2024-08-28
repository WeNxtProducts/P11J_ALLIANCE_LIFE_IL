package com.iii.pel.forms.PILP018;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {

    private String UI_M_CHQ_NO;
    private String UI_M_BANK_CODE;
    private String UI_M_BANK_DESC;
    private String UI_M_CBH_REASON_CODE;
    private String UI_M_REASON_CODE_DESC;
    private String UI_M_CBH_REMARKS;
    
    public String getUI_M_CHQ_NO() {
        return UI_M_CHQ_NO;
    }
    public void setUI_M_CHQ_NO(String ui_m_chq_no) {
        UI_M_CHQ_NO = ui_m_chq_no;
    }
    public String getUI_M_BANK_CODE() {
        return UI_M_BANK_CODE;
    }
    public void setUI_M_BANK_CODE(String ui_m_bank_code) {
        UI_M_BANK_CODE = ui_m_bank_code;
    }
    public String getUI_M_CBH_REASON_CODE() {
        return UI_M_CBH_REASON_CODE;
    }
    public void setUI_M_CBH_REASON_CODE(String ui_m_cbh_reason_code) {
        UI_M_CBH_REASON_CODE = ui_m_cbh_reason_code;
    }
    public String getUI_M_CBH_REMARKS() {
        return UI_M_CBH_REMARKS;
    }
    public void setUI_M_CBH_REMARKS(String ui_m_cbh_remarks) {
        UI_M_CBH_REMARKS = ui_m_cbh_remarks;
    }
    public String getUI_M_BANK_DESC() {
        return UI_M_BANK_DESC;
    }
    public void setUI_M_BANK_DESC(String ui_m_bank_desc) {
        UI_M_BANK_DESC = ui_m_bank_desc;
    }
    public String getUI_M_REASON_CODE_DESC() {
        return UI_M_REASON_CODE_DESC;
    }
    public void setUI_M_REASON_CODE_DESC(String ui_m_reason_code_desc) {
        UI_M_REASON_CODE_DESC = ui_m_reason_code_desc;
    }

}
