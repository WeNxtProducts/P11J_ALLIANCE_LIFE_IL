package com.iii.pel.forms.PILT007;

import java.io.Serializable;
import java.util.Date;

import javax.faces.component.html.HtmlInputText;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_CLAIM_BENEFICIARY")
public class PT_IL_CLAIM_BENEFICIARY extends BaseValueBean implements Serializable, Cloneable {
	
	@Column(name="CBEN_BNF_NAME")
	private String CBEN_BNF_NAME;
	
	private boolean CBEN_BNF_NAME_DIS = false;

	@Column(name="CBEN_BANK_CODE")
	private String CBEN_BANK_CODE;
	
	private boolean CBEN_BANK_CODE_DIS = false;

	@Column(name="CBEN_ADDRESS1")
	private String CBEN_ADDRESS1;
	
	private boolean CBEN_ADDRESS1_DIS = false;

	@Column(name="CBEN_ADDRESS2")
	private String CBEN_ADDRESS2;
	
	private boolean CBEN_ADDRESS2_DIS = false;

	@Column(name="CBEN_ADDRESS3")
	private String CBEN_ADDRESS3;
	
	private boolean CBEN_ADDRESS3_DIS = false;

	@Column(name="CBEN_STAT_CODE")
	private String CBEN_STAT_CODE;
	
	private boolean CBEN_STAT_CODE_DIS = false;

	@Column(name="CBEN_CITY_CODE")
	private String CBEN_CITY_CODE;
	
	private boolean CBEN_CITY_CODE_DIS = false;

	@Column(name="CBEN_REF_ID1")
	private String CBEN_REF_ID1;
	
	private boolean CBEN_REF_ID1_DIS = false;

	private String UI_M_CBEN_BANK_CODE_DESC;
	
	private boolean UI_M_CBEN_BANK_CODE_DESC_DIS = false;

	private String UI_M_CBEN_STAT_CODE_DESC;
	
	private boolean UI_M_CBEN_STAT_CODE_DESC_DIS = false;

	private String UI_M_CBEN_CITY_DESC;
	
	private boolean UI_M_CBEN_CITY_DESC_DIS = false;

	@Column(name="CBEN_REF_ID2")
	private String CBEN_REF_ID2;
	
	private boolean CBEN_REF_ID2_DIS = false;

	@Column(name="CBEN_RELATION_CODE")
	private String CBEN_RELATION_CODE;
	
	private boolean CBEN_RELATION_CODE_DIS = false;

	@Column(name="CBEN_BNF_TYPE")
	private String CBEN_BNF_TYPE;
	
	private boolean CBEN_BNF_TYPE_DIS = false;

	@Column(name="CBEN_PERC")
	private Double CBEN_PERC;
	
	private boolean CBEN_PERC_DIS = false;

	@Column(name="CBEN_ACCT_CODE")
	private String CBEN_ACCT_CODE;
	
	private boolean CBEN_ACCT_CODE_DIS = false;

	private String UI_M_BNF_DESC;
	
	private boolean UI_M_BNF_DESC_DIS = false;

	private String UI_M_CBEN_RELATION_DESC;
	
	private boolean UI_M_CBEN_RELATION_DESC_DIS = false;

	@Column(name="CBEN_POSTAL_CODE")
	private String CBEN_POSTAL_CODE;
	
	private boolean CBEN_POSTAL_CODE_DIS = false;

	@Column(name="CBEN_FC_PAID_AMT")
	private Double CBEN_FC_PAID_AMT;
	
	private boolean CBEN_FC_PAID_AMT_DIS = false;

	private String UI_M_CBEN_POSTAL_CODE_DESC;
	
	private boolean UI_M_CBEN_POSTAL_CODE_DESC_DIS = false;

	@Column(name="CBEN_LC_PAID_AMT")
	private Double CBEN_LC_PAID_AMT;
	
	private boolean CBEN_LC_PAID_AMT_DIS = false;

	@Column(name="CBEN_SYS_ID")
	private Long CBEN_SYS_ID;
	
	@Column(name="CBEN_CLAIM_SYS_ID")
	private Long CBEN_CLAIM_SYS_ID;
	
	@Column(name="CBEN_CP_SYS_ID")
	private Long CBEN_CP_SYS_ID;
	
	@Column(name="CBEN_PBEN_SYS_ID")
	private Long CBEN_PBEN_SYS_ID;
	
	@Column(name="CBEN_CR_UID")
	private String CBEN_CR_UID;
	
	@Column(name="CBEN_CR_DT")
	private Date CBEN_CR_DT;
	
	@Column(name="CBEN_UPD_UID")
	private String CBEN_UPD_UID;
	
	@Column(name="CBEN_UPD_DT")
	private Date CBEN_UPD_DT;
	@Column(name="CBEN_ADDRESS4")
	private String CBEN_ADDRESS4 ;
	@Column(name="CBEN_ADDRESS5")
	private String CBEN_ADDRESS5 ;
	@Column(name="CBEN_REMARKS")
	private String  CBEN_REMARKS  ;
	@Column(name="CBEN_CATG_CODE")
	private String CBEN_CATG_CODE ;
	@Column(name="CBEN_AGE")
	private Integer CBEN_AGE ;
	@Column(name="CBEN_GUARDIAN_NAME")
	private String CBEN_GUARDIAN_NAME;
	@Column(name="CBEN_MICR_CODE")
	private Long CBEN_MICR_CODE;
	@Column(name="CBEN_DIVN_CODE")
	private String CBEN_DIVN_CODE;
	private String UI_M_CBEN_DIVN_CODE;
	private String UI_M_CATG_DESC;
	private boolean selected;
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getCBEN_CR_UID() {
		return CBEN_CR_UID;
	}

	public void setCBEN_CR_UID(String cben_cr_uid) {
		CBEN_CR_UID = cben_cr_uid;
	}

	public Date getCBEN_CR_DT() {
		return CBEN_CR_DT;
	}

	public void setCBEN_CR_DT(Date cben_cr_dt) {
		CBEN_CR_DT = cben_cr_dt;
	}

	public String getCBEN_UPD_UID() {
		return CBEN_UPD_UID;
	}

	public void setCBEN_UPD_UID(String cben_upd_uid) {
		CBEN_UPD_UID = cben_upd_uid;
	}

	public Date getCBEN_UPD_DT() {
		return CBEN_UPD_DT;
	}

	public void setCBEN_UPD_DT(Date cben_upd_dt) {
		CBEN_UPD_DT = cben_upd_dt;
	}

	

	public Long getCBEN_SYS_ID() {
		return CBEN_SYS_ID;
	}

	public void setCBEN_SYS_ID(Long cben_sys_id) {
		CBEN_SYS_ID = cben_sys_id;
	}

	public Long getCBEN_CLAIM_SYS_ID() {
		return CBEN_CLAIM_SYS_ID;
	}

	public void setCBEN_CLAIM_SYS_ID(Long cben_claim_sys_id) {
		CBEN_CLAIM_SYS_ID = cben_claim_sys_id;
	}

	public Long getCBEN_CP_SYS_ID() {
		return CBEN_CP_SYS_ID;
	}

	public void setCBEN_CP_SYS_ID(Long cben_cp_sys_id) {
		CBEN_CP_SYS_ID = cben_cp_sys_id;
	}

	public Long getCBEN_PBEN_SYS_ID() {
		return CBEN_PBEN_SYS_ID;
	}

	public void setCBEN_PBEN_SYS_ID(Long cben_pben_sys_id) {
		CBEN_PBEN_SYS_ID = cben_pben_sys_id;
	}

	public String getCBEN_BNF_NAME() {
		return CBEN_BNF_NAME;
	}

	public void setCBEN_BNF_NAME(String CBEN_BNF_NAME) {
		this.CBEN_BNF_NAME = CBEN_BNF_NAME;
	}

	public String getCBEN_BANK_CODE() {
		return CBEN_BANK_CODE;
	}

	public void setCBEN_BANK_CODE(String CBEN_BANK_CODE) {
		this.CBEN_BANK_CODE = CBEN_BANK_CODE;
	}

	public String getCBEN_ADDRESS1() {
		return CBEN_ADDRESS1;
	}

	public void setCBEN_ADDRESS1(String CBEN_ADDRESS1) {
		this.CBEN_ADDRESS1 = CBEN_ADDRESS1;
	}

	public String getCBEN_ADDRESS2() {
		return CBEN_ADDRESS2;
	}

	public void setCBEN_ADDRESS2(String CBEN_ADDRESS2) {
		this.CBEN_ADDRESS2 = CBEN_ADDRESS2;
	}

	public String getCBEN_ADDRESS3() {
		return CBEN_ADDRESS3;
	}

	public void setCBEN_ADDRESS3(String CBEN_ADDRESS3) {
		this.CBEN_ADDRESS3 = CBEN_ADDRESS3;
	}

	public String getCBEN_STAT_CODE() {
		return CBEN_STAT_CODE;
	}

	public void setCBEN_STAT_CODE(String CBEN_STAT_CODE) {
		this.CBEN_STAT_CODE = CBEN_STAT_CODE;
	}

	public String getCBEN_CITY_CODE() {
		return CBEN_CITY_CODE;
	}

	public void setCBEN_CITY_CODE(String CBEN_CITY_CODE) {
		this.CBEN_CITY_CODE = CBEN_CITY_CODE;
	}

	public String getCBEN_REF_ID1() {
		return CBEN_REF_ID1;
	}

	public void setCBEN_REF_ID1(String CBEN_REF_ID1) {
		this.CBEN_REF_ID1 = CBEN_REF_ID1;
	}

	public String getUI_M_CBEN_BANK_CODE_DESC() {
		return UI_M_CBEN_BANK_CODE_DESC;
	}

	public void setUI_M_CBEN_BANK_CODE_DESC(String UI_M_CBEN_BANK_CODE_DESC) {
		this.UI_M_CBEN_BANK_CODE_DESC = UI_M_CBEN_BANK_CODE_DESC;
	}

	public String getUI_M_CBEN_STAT_CODE_DESC() {
		return UI_M_CBEN_STAT_CODE_DESC;
	}

	public void setUI_M_CBEN_STAT_CODE_DESC(String UI_M_CBEN_STAT_CODE_DESC) {
		this.UI_M_CBEN_STAT_CODE_DESC = UI_M_CBEN_STAT_CODE_DESC;
	}

	public String getUI_M_CBEN_CITY_DESC() {
		return UI_M_CBEN_CITY_DESC;
	}

	public void setUI_M_CBEN_CITY_DESC(String UI_M_CBEN_CITY_DESC) {
		this.UI_M_CBEN_CITY_DESC = UI_M_CBEN_CITY_DESC;
	}

	public String getCBEN_REF_ID2() {
		return CBEN_REF_ID2;
	}

	public void setCBEN_REF_ID2(String CBEN_REF_ID2) {
		this.CBEN_REF_ID2 = CBEN_REF_ID2;
	}

	public String getCBEN_RELATION_CODE() {
		return CBEN_RELATION_CODE;
	}

	public void setCBEN_RELATION_CODE(String CBEN_RELATION_CODE) {
		this.CBEN_RELATION_CODE = CBEN_RELATION_CODE;
	}

	public String getCBEN_BNF_TYPE() {
		return CBEN_BNF_TYPE;
	}

	public void setCBEN_BNF_TYPE(String CBEN_BNF_TYPE) {
		this.CBEN_BNF_TYPE = CBEN_BNF_TYPE;
	}

	public Double getCBEN_PERC() {
		return CBEN_PERC;
	}

	public void setCBEN_PERC(Double CBEN_PERC) {
		this.CBEN_PERC = CBEN_PERC;
	}

	public String getCBEN_ACCT_CODE() {
		return CBEN_ACCT_CODE;
	}

	public void setCBEN_ACCT_CODE(String CBEN_ACCT_CODE) {
		this.CBEN_ACCT_CODE = CBEN_ACCT_CODE;
	}

	public String getUI_M_BNF_DESC() {
		return UI_M_BNF_DESC;
	}

	public void setUI_M_BNF_DESC(String UI_M_BNF_DESC) {
		this.UI_M_BNF_DESC = UI_M_BNF_DESC;
	}

	public String getUI_M_CBEN_RELATION_DESC() {
		return UI_M_CBEN_RELATION_DESC;
	}

	public void setUI_M_CBEN_RELATION_DESC(String UI_M_CBEN_RELATION_DESC) {
		this.UI_M_CBEN_RELATION_DESC = UI_M_CBEN_RELATION_DESC;
	}

	public String getCBEN_POSTAL_CODE() {
		return CBEN_POSTAL_CODE;
	}

	public void setCBEN_POSTAL_CODE(String CBEN_POSTAL_CODE) {
		this.CBEN_POSTAL_CODE = CBEN_POSTAL_CODE;
	}

	public Double getCBEN_FC_PAID_AMT() {
		return CBEN_FC_PAID_AMT;
	}

	public void setCBEN_FC_PAID_AMT(Double CBEN_FC_PAID_AMT) {
		this.CBEN_FC_PAID_AMT = CBEN_FC_PAID_AMT;
	}

	public String getUI_M_CBEN_POSTAL_CODE_DESC() {
		return UI_M_CBEN_POSTAL_CODE_DESC;
	}

	public void setUI_M_CBEN_POSTAL_CODE_DESC(String UI_M_CBEN_POSTAL_CODE_DESC) {
		this.UI_M_CBEN_POSTAL_CODE_DESC = UI_M_CBEN_POSTAL_CODE_DESC;
	}

	public Double getCBEN_LC_PAID_AMT() {
		return CBEN_LC_PAID_AMT;
	}

	public void setCBEN_LC_PAID_AMT(Double CBEN_LC_PAID_AMT) {
		this.CBEN_LC_PAID_AMT = CBEN_LC_PAID_AMT;
	}

	public boolean isCBEN_BNF_NAME_DIS() {
		return CBEN_BNF_NAME_DIS;
	}

	public void setCBEN_BNF_NAME_DIS(boolean cben_bnf_name_dis) {
		CBEN_BNF_NAME_DIS = cben_bnf_name_dis;
	}

	public boolean isCBEN_BANK_CODE_DIS() {
		return CBEN_BANK_CODE_DIS;
	}

	public void setCBEN_BANK_CODE_DIS(boolean cben_bank_code_dis) {
		CBEN_BANK_CODE_DIS = cben_bank_code_dis;
	}

	public boolean isCBEN_ADDRESS1_DIS() {
		return CBEN_ADDRESS1_DIS;
	}

	public void setCBEN_ADDRESS1_DIS(boolean cben_address1_dis) {
		CBEN_ADDRESS1_DIS = cben_address1_dis;
	}

	public boolean isCBEN_ADDRESS2_DIS() {
		return CBEN_ADDRESS2_DIS;
	}

	public void setCBEN_ADDRESS2_DIS(boolean cben_address2_dis) {
		CBEN_ADDRESS2_DIS = cben_address2_dis;
	}

	public boolean isCBEN_ADDRESS3_DIS() {
		return CBEN_ADDRESS3_DIS;
	}

	public void setCBEN_ADDRESS3_DIS(boolean cben_address3_dis) {
		CBEN_ADDRESS3_DIS = cben_address3_dis;
	}

	public boolean isCBEN_STAT_CODE_DIS() {
		return CBEN_STAT_CODE_DIS;
	}

	public void setCBEN_STAT_CODE_DIS(boolean cben_stat_code_dis) {
		CBEN_STAT_CODE_DIS = cben_stat_code_dis;
	}

	public boolean isCBEN_CITY_CODE_DIS() {
		return CBEN_CITY_CODE_DIS;
	}

	public void setCBEN_CITY_CODE_DIS(boolean cben_city_code_dis) {
		CBEN_CITY_CODE_DIS = cben_city_code_dis;
	}

	public boolean isCBEN_REF_ID1_DIS() {
		return CBEN_REF_ID1_DIS;
	}

	public void setCBEN_REF_ID1_DIS(boolean cben_ref_id1_dis) {
		CBEN_REF_ID1_DIS = cben_ref_id1_dis;
	}

	public boolean isUI_M_CBEN_BANK_CODE_DESC_DIS() {
		return UI_M_CBEN_BANK_CODE_DESC_DIS;
	}

	public void setUI_M_CBEN_BANK_CODE_DESC_DIS(boolean ui_m_cben_bank_code_desc_dis) {
		UI_M_CBEN_BANK_CODE_DESC_DIS = ui_m_cben_bank_code_desc_dis;
	}

	public boolean isUI_M_CBEN_STAT_CODE_DESC_DIS() {
		return UI_M_CBEN_STAT_CODE_DESC_DIS;
	}

	public void setUI_M_CBEN_STAT_CODE_DESC_DIS(boolean ui_m_cben_stat_code_desc_dis) {
		UI_M_CBEN_STAT_CODE_DESC_DIS = ui_m_cben_stat_code_desc_dis;
	}

	public boolean isUI_M_CBEN_CITY_DESC_DIS() {
		return UI_M_CBEN_CITY_DESC_DIS;
	}

	public void setUI_M_CBEN_CITY_DESC_DIS(boolean ui_m_cben_city_desc_dis) {
		UI_M_CBEN_CITY_DESC_DIS = ui_m_cben_city_desc_dis;
	}

	public boolean isCBEN_REF_ID2_DIS() {
		return CBEN_REF_ID2_DIS;
	}

	public void setCBEN_REF_ID2_DIS(boolean cben_ref_id2_dis) {
		CBEN_REF_ID2_DIS = cben_ref_id2_dis;
	}

	public boolean isCBEN_RELATION_CODE_DIS() {
		return CBEN_RELATION_CODE_DIS;
	}

	public void setCBEN_RELATION_CODE_DIS(boolean cben_relation_code_dis) {
		CBEN_RELATION_CODE_DIS = cben_relation_code_dis;
	}

	public boolean isCBEN_BNF_TYPE_DIS() {
		return CBEN_BNF_TYPE_DIS;
	}

	public void setCBEN_BNF_TYPE_DIS(boolean cben_bnf_type_dis) {
		CBEN_BNF_TYPE_DIS = cben_bnf_type_dis;
	}

	public boolean isCBEN_PERC_DIS() {
		return CBEN_PERC_DIS;
	}

	public void setCBEN_PERC_DIS(boolean cben_perc_dis) {
		CBEN_PERC_DIS = cben_perc_dis;
	}

	public boolean isCBEN_ACCT_CODE_DIS() {
		return CBEN_ACCT_CODE_DIS;
	}

	public void setCBEN_ACCT_CODE_DIS(boolean cben_acct_code_dis) {
		CBEN_ACCT_CODE_DIS = cben_acct_code_dis;
	}

	public boolean isUI_M_BNF_DESC_DIS() {
		return UI_M_BNF_DESC_DIS;
	}

	public void setUI_M_BNF_DESC_DIS(boolean ui_m_bnf_desc_dis) {
		UI_M_BNF_DESC_DIS = ui_m_bnf_desc_dis;
	}

	public boolean isUI_M_CBEN_RELATION_DESC_DIS() {
		return UI_M_CBEN_RELATION_DESC_DIS;
	}

	public void setUI_M_CBEN_RELATION_DESC_DIS(boolean ui_m_cben_relation_desc_dis) {
		UI_M_CBEN_RELATION_DESC_DIS = ui_m_cben_relation_desc_dis;
	}

	public boolean isCBEN_POSTAL_CODE_DIS() {
		return CBEN_POSTAL_CODE_DIS;
	}

	public void setCBEN_POSTAL_CODE_DIS(boolean cben_postal_code_dis) {
		CBEN_POSTAL_CODE_DIS = cben_postal_code_dis;
	}

	public boolean isCBEN_FC_PAID_AMT_DIS() {
		return CBEN_FC_PAID_AMT_DIS;
	}

	public void setCBEN_FC_PAID_AMT_DIS(boolean cben_fc_paid_amt_dis) {
		CBEN_FC_PAID_AMT_DIS = cben_fc_paid_amt_dis;
	}

	public boolean isUI_M_CBEN_POSTAL_CODE_DESC_DIS() {
		return UI_M_CBEN_POSTAL_CODE_DESC_DIS;
	}

	public void setUI_M_CBEN_POSTAL_CODE_DESC_DIS(
			boolean ui_m_cben_postal_code_desc_dis) {
		UI_M_CBEN_POSTAL_CODE_DESC_DIS = ui_m_cben_postal_code_desc_dis;
	}

	public boolean isCBEN_LC_PAID_AMT_DIS() {
		return CBEN_LC_PAID_AMT_DIS;
	}

	public void setCBEN_LC_PAID_AMT_DIS(boolean cben_lc_paid_amt_dis) {
		CBEN_LC_PAID_AMT_DIS = cben_lc_paid_amt_dis;
	}

	public String getCBEN_ADDRESS4() {
		return CBEN_ADDRESS4;
	}

	public void setCBEN_ADDRESS4(String cben_address4) {
		CBEN_ADDRESS4 = cben_address4;
	}

	public String getCBEN_ADDRESS5() {
		return CBEN_ADDRESS5;
	}

	public void setCBEN_ADDRESS5(String cben_address5) {
		CBEN_ADDRESS5 = cben_address5;
	}

	public String getCBEN_REMARKS() {
		return CBEN_REMARKS;
	}

	public void setCBEN_REMARKS(String cben_remarks) {
		CBEN_REMARKS = cben_remarks;
	}

	public String getCBEN_CATG_CODE() {
		return CBEN_CATG_CODE;
	}

	public void setCBEN_CATG_CODE(String cben_catg_code) {
		CBEN_CATG_CODE = cben_catg_code;
	}

	public Integer getCBEN_AGE() {
		return CBEN_AGE;
	}

	public void setCBEN_AGE(Integer cben_age) {
		CBEN_AGE = cben_age;
	}

	public String getCBEN_GUARDIAN_NAME() {
		return CBEN_GUARDIAN_NAME;
	}

	public void setCBEN_GUARDIAN_NAME(String cben_guardian_name) {
		CBEN_GUARDIAN_NAME = cben_guardian_name;
	}

	public Long getCBEN_MICR_CODE() {
		return CBEN_MICR_CODE;
	}

	public void setCBEN_MICR_CODE(Long cben_micr_code) {
		CBEN_MICR_CODE = cben_micr_code;
	}

	public String getUI_M_CATG_DESC() {
		return UI_M_CATG_DESC;
	}

	public void setUI_M_CATG_DESC(String ui_m_catg_desc) {
		UI_M_CATG_DESC = ui_m_catg_desc;
	}

	public String getCBEN_DIVN_CODE() {
		return CBEN_DIVN_CODE;
	}

	public void setCBEN_DIVN_CODE(String cben_divn_code) {
		CBEN_DIVN_CODE = cben_divn_code;
	}

	public String getUI_M_CBEN_DIVN_CODE() {
		return UI_M_CBEN_DIVN_CODE;
	}

	public void setUI_M_CBEN_DIVN_CODE(String ui_m_cben_divn_code) {
		UI_M_CBEN_DIVN_CODE = ui_m_cben_divn_code;
	}
	/*added by gopi for hands on feed back points,serial no 12 in zb on 02/02/17*/
	
	@Column(name="CBEN_SR_NO")
	private Integer CBEN_SR_NO;

	public Integer getCBEN_SR_NO() {
		return CBEN_SR_NO;
	}

	public void setCBEN_SR_NO(Integer cBEN_SR_NO) {
		CBEN_SR_NO = cBEN_SR_NO;
	}
	@Column(name="CBEN_DOB")
	private Date CBEN_DOB;

	public Date getCBEN_DOB() {
		return CBEN_DOB;
	}

	public void setCBEN_DOB(Date cBEN_DOB) {
		CBEN_DOB = cBEN_DOB;
	}
	@Column(name="CBEN_BNF_CODE")
	private String CBEN_BNF_CODE;

	public String getCBEN_BNF_CODE() {
		return CBEN_BNF_CODE;
	}

	public void setCBEN_BNF_CODE(String cBEN_BNF_CODE) {
		CBEN_BNF_CODE = cBEN_BNF_CODE;
	}
	
	/*END*/
	
	/*Added by Ameen as per Ajay sugg. to display bank dtls fields*/
	@Column(name="CBEN_FLEX_01")
	private String CBEN_FLEX_01;
	
	@Column(name="CBEN_FLEX_02")
	private String CBEN_FLEX_02;
	
	@Column(name="CBEN_FLEX_03")
	private String CBEN_FLEX_03;
	
	@Column(name="CBEN_FLEX_04")
	private String CBEN_FLEX_04;

	public String getCBEN_FLEX_01() {
		return CBEN_FLEX_01;
	}

	public void setCBEN_FLEX_01(String cBEN_FLEX_01) {
		CBEN_FLEX_01 = cBEN_FLEX_01;
	}

	public String getCBEN_FLEX_02() {
		return CBEN_FLEX_02;
	}

	public void setCBEN_FLEX_02(String cBEN_FLEX_02) {
		CBEN_FLEX_02 = cBEN_FLEX_02;
	}

	public String getCBEN_FLEX_03() {
		return CBEN_FLEX_03;
	}

	public void setCBEN_FLEX_03(String cBEN_FLEX_03) {
		CBEN_FLEX_03 = cBEN_FLEX_03;
	}

	public String getCBEN_FLEX_04() {
		return CBEN_FLEX_04;
	}

	public void setCBEN_FLEX_04(String cBEN_FLEX_04) {
		CBEN_FLEX_04 = cBEN_FLEX_04;
	}
	
	

}
