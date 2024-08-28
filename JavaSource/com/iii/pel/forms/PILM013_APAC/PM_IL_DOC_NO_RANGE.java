package com.iii.pel.forms.PILM013_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DOC_NO_RANGE")
public class PM_IL_DOC_NO_RANGE extends BaseValueBean {

	@Column(name="DNR_FRZ_FLAG")
	private String DNR_FRZ_FLAG;

	@Column(name="DNR_LEVEL_1")
	private String DNR_LEVEL_1;

	@Column(name="DNR_LEVEL_2")
	private String DNR_LEVEL_2;

	@Column(name="DNR_LEVEL_3")
	private String DNR_LEVEL_3;

	@Column(name="DNR_LEVEL_4")
	private String DNR_LEVEL_4;

	@Column(name="DNR_LEVEL_5")
	private String DNR_LEVEL_5;

	@Column(name="DNR_FIRST_NO")
	private Integer DNR_FIRST_NO ;

	@Column(name="DNR_LAST_NO")
	private Integer DNR_LAST_NO ;

	@Column(name="DNR_CURR_NO")
	private Integer DNR_CURR_NO ;

	private int UI_M_DNR_CURR_NO;
	
	@Column(name="DNR_DISABLE_YN")
	private String DNR_DISABLE_YN;

	private String UI_M_DNR_LEVEL_1_DESC;

	private String UI_M_DNR_LEVEL_2_DESC;

	private String UI_M_DNR_LEVEL_3_DESC;

	private String UI_M_DNR_LEVEL_4_DESC;
	
	private String UI_M_NUM_VALUE;

	@Column(name="DNR_SEQ_NAME")
	private String DNR_SEQ_NAME;
	
	@Column(name="DNR_TYPE")
	private String DNR_TYPE;
	
	@Column(name="DNR_CODE")
	private String DNR_CODE;
	
	@Column(name="DNR_CR_DT")
	private Date DNR_CR_DT;
	
	@Column(name="DNR_CR_UID")
	private String DNR_CR_UID;

	private String UI_M_DNR_LEVEL_5_DESC;

	private boolean CHECKBOX;
	
	private boolean currNodisabled;
	
	private boolean segNameDisabled;

	private String level1_caption;
	
	private String level2_caption;
	
	private String level3_caption;
	
	private String level4_caption;
	
	private String level5_caption;

	public String getDNR_FRZ_FLAG() {
		return DNR_FRZ_FLAG;
	}

	public void setDNR_FRZ_FLAG(String DNR_FRZ_FLAG) {
		this.DNR_FRZ_FLAG = DNR_FRZ_FLAG;
	}

	public String getDNR_LEVEL_1() {
		return DNR_LEVEL_1;
	}

	public void setDNR_LEVEL_1(String DNR_LEVEL_1) {
		this.DNR_LEVEL_1 = DNR_LEVEL_1;
	}

	public String getDNR_LEVEL_2() {
		return DNR_LEVEL_2;
	}

	public void setDNR_LEVEL_2(String DNR_LEVEL_2) {
		this.DNR_LEVEL_2 = DNR_LEVEL_2;
	}

	public String getDNR_LEVEL_3() {
		return DNR_LEVEL_3;
	}

	public void setDNR_LEVEL_3(String DNR_LEVEL_3) {
		this.DNR_LEVEL_3 = DNR_LEVEL_3;
	}

	public String getDNR_LEVEL_4() {
		return DNR_LEVEL_4;
	}

	public void setDNR_LEVEL_4(String DNR_LEVEL_4) {
		this.DNR_LEVEL_4 = DNR_LEVEL_4;
	}

	public String getDNR_LEVEL_5() {
		return DNR_LEVEL_5;
	}

	public void setDNR_LEVEL_5(String DNR_LEVEL_5) {
		this.DNR_LEVEL_5 = DNR_LEVEL_5;
	}

	public Integer getDNR_FIRST_NO() {
		return DNR_FIRST_NO;
	}

	public void setDNR_FIRST_NO(Integer dnr_first_no) {
		DNR_FIRST_NO = dnr_first_no;
	}

	public Integer getDNR_LAST_NO() {
		return DNR_LAST_NO;
	}

	public void setDNR_LAST_NO(Integer dnr_last_no) {
		DNR_LAST_NO = dnr_last_no;
	}

	public Integer getDNR_CURR_NO() {
		return DNR_CURR_NO;
	}

	public void setDNR_CURR_NO(Integer dnr_curr_no) {
		DNR_CURR_NO = dnr_curr_no;
	}

	public int getUI_M_DNR_CURR_NO() {
		return UI_M_DNR_CURR_NO;
	}

	public void setUI_M_DNR_CURR_NO(int ui_m_dnr_curr_no) {
		UI_M_DNR_CURR_NO = ui_m_dnr_curr_no;
	}

	public String getDNR_DISABLE_YN() {
		return DNR_DISABLE_YN;
	}

	public void setDNR_DISABLE_YN(String DNR_DISABLE_YN) {
		this.DNR_DISABLE_YN = DNR_DISABLE_YN;
	}

	public String getUI_M_DNR_LEVEL_1_DESC() {
		return UI_M_DNR_LEVEL_1_DESC;
	}

	public void setUI_M_DNR_LEVEL_1_DESC(String UI_M_DNR_LEVEL_1_DESC) {
		this.UI_M_DNR_LEVEL_1_DESC = UI_M_DNR_LEVEL_1_DESC;
	}

	public String getUI_M_DNR_LEVEL_2_DESC() {
		return UI_M_DNR_LEVEL_2_DESC;
	}

	public void setUI_M_DNR_LEVEL_2_DESC(String UI_M_DNR_LEVEL_2_DESC) {
		this.UI_M_DNR_LEVEL_2_DESC = UI_M_DNR_LEVEL_2_DESC;
	}

	public String getUI_M_DNR_LEVEL_3_DESC() {
		return UI_M_DNR_LEVEL_3_DESC;
	}

	public void setUI_M_DNR_LEVEL_3_DESC(String UI_M_DNR_LEVEL_3_DESC) {
		this.UI_M_DNR_LEVEL_3_DESC = UI_M_DNR_LEVEL_3_DESC;
	}

	public String getUI_M_DNR_LEVEL_4_DESC() {
		return UI_M_DNR_LEVEL_4_DESC;
	}

	public void setUI_M_DNR_LEVEL_4_DESC(String UI_M_DNR_LEVEL_4_DESC) {
		this.UI_M_DNR_LEVEL_4_DESC = UI_M_DNR_LEVEL_4_DESC;
	}

	public String getDNR_SEQ_NAME() {
		return DNR_SEQ_NAME;
	}

	public void setDNR_SEQ_NAME(String DNR_SEQ_NAME) {
		this.DNR_SEQ_NAME = DNR_SEQ_NAME;
	}

	public String getUI_M_DNR_LEVEL_5_DESC() {
		return UI_M_DNR_LEVEL_5_DESC;
	}

	public void setUI_M_DNR_LEVEL_5_DESC(String UI_M_DNR_LEVEL_5_DESC) {
		this.UI_M_DNR_LEVEL_5_DESC = UI_M_DNR_LEVEL_5_DESC;
	}

	public boolean isCHECKBOX() {
		return CHECKBOX;
	}

	public void setCHECKBOX(boolean checkbox) {
		CHECKBOX = checkbox;
	}

	public String getDNR_TYPE() {
		return DNR_TYPE;
	}

	public void setDNR_TYPE(String dnr_type) {
		DNR_TYPE = dnr_type;
	}

	public String getDNR_CODE() {
		return DNR_CODE;
	}

	public void setDNR_CODE(String dnr_code) {
		DNR_CODE = dnr_code;
	}

	public Date getDNR_CR_DT() {
		return DNR_CR_DT;
	}

	public void setDNR_CR_DT(Date dnr_cr_dt) {
		DNR_CR_DT = dnr_cr_dt;
	}

	public String getDNR_CR_UID() {
		return DNR_CR_UID;
	}

	public void setDNR_CR_UID(String dnr_cr_uid) {
		DNR_CR_UID = dnr_cr_uid;
	}


	public boolean isCurrNodisabled() {
		return currNodisabled;
	}

	public void setCurrNodisabled(boolean currNodisabled) {
		this.currNodisabled = currNodisabled;
	}

	
	public boolean isSegNameDisabled() {
		return segNameDisabled;
	}

	public void setSegNameDisabled(boolean segNameDisabled) {
		this.segNameDisabled = segNameDisabled;
	}

	public String getUI_M_NUM_VALUE() {
		return UI_M_NUM_VALUE;
	}

	public void setUI_M_NUM_VALUE(String ui_m_num_value) {
		UI_M_NUM_VALUE = ui_m_num_value;
	}

	public String getLevel1_caption() {
		return level1_caption;
	}

	public void setLevel1_caption(String level1_caption) {
		this.level1_caption = level1_caption;
	}

	public String getLevel2_caption() {
		return level2_caption;
	}

	public void setLevel2_caption(String level2_caption) {
		this.level2_caption = level2_caption;
	}

	public String getLevel3_caption() {
		return level3_caption;
	}

	public void setLevel3_caption(String level3_caption) {
		this.level3_caption = level3_caption;
	}

	public String getLevel4_caption() {
		return level4_caption;
	}

	public void setLevel4_caption(String level4_caption) {
		this.level4_caption = level4_caption;
	}

	public String getLevel5_caption() {
		return level5_caption;
	}

	public void setLevel5_caption(String level5_caption) {
		this.level5_caption = level5_caption;
	}
}
