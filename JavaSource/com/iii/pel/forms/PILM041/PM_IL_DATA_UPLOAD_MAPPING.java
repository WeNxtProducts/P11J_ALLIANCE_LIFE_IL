package com.iii.pel.forms.PILM041;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DATA_UPLOAD_MAPPING")
public class PM_IL_DATA_UPLOAD_MAPPING extends BaseValueBean {

	@Column(name="ROWID")
	private String ROWID;

	@Column(name="DUM_MAP_CODE")
	private String DUM_MAP_CODE;

	@Column(name="DUM_MAP_CODE_DESC")
	private String DUM_MAP_CODE_DESC;

	@Column(name="DUM_DEF_CODE")
	private String DUM_DEF_CODE;

	private String UI_M_DEF_CODE_DESC;

	@Column(name="DUM_FIELD_01")
	private Integer DUM_FIELD_01;

	private String UI_M_DUM_FIELD_01_DESC;

	@Column(name="DUM_FIELD_11")
	private Integer DUM_FIELD_11;

	private String UI_M_DUM_FIELD_11_DESC;

	@Column(name="DUM_FIELD_02")
	private Integer DUM_FIELD_02;

	private String UI_M_DUM_FIELD_02_DESC;

	@Column(name="DUM_FIELD_12")
	private Integer DUM_FIELD_12;

	private String UI_M_DUM_FIELD_12_DESC;

	@Column(name="DUM_FIELD_03")
	private Integer DUM_FIELD_03;

	private String UI_M_DUM_FIELD_03_DESC;

	@Column(name="DUM_FIELD_13")
	private Integer DUM_FIELD_13;

	private String UI_M_DUM_FIELD_13_DESC;

	@Column(name="DUM_FIELD_04")
	private Integer DUM_FIELD_04;

	private String UI_M_DUM_FIELD_04_DESC;

	@Column(name="DUM_FIELD_14")
	private Integer DUM_FIELD_14;

	private String UI_M_DUM_FIELD_14_DESC;

	@Column(name="DUM_FIELD_05")
	private Integer DUM_FIELD_05;

	private String UI_M_DUM_FIELD_05_DESC;

	@Column(name="DUM_FIELD_15")
	private Integer DUM_FIELD_15;

	private String UI_M_DUM_FIELD_15_DESC;

	@Column(name="DUM_FIELD_06")
	private Integer DUM_FIELD_06;

	private String UI_M_DUM_FIELD_06_DESC;

	@Column(name="DUM_FIELD_16")
	private Integer DUM_FIELD_16;

	private String UI_M_DUM_FIELD_16_DESC;

	@Column(name="DUM_FIELD_07")
	private Integer DUM_FIELD_07;

	private String UI_M_DUM_FIELD_07_DESC;

	@Column(name="DUM_FIELD_17")
	private Integer DUM_FIELD_17;

	private String UI_M_DUM_FIELD_17_DESC;

	@Column(name="DUM_FIELD_08")
	private Integer DUM_FIELD_08;

	private String UI_M_DUM_FIELD_08_DESC;

	@Column(name="DUM_FIELD_18")
	private Integer DUM_FIELD_18;

	private String UI_M_DUM_FIELD_18_DESC;

	@Column(name="DUM_FIELD_09")
	private Integer DUM_FIELD_09;

	private String UI_M_DUM_FIELD_09_DESC;

	@Column(name="DUM_FIELD_19")
	private Integer DUM_FIELD_19;

	private String UI_M_DUM_FIELD_19_DESC;

	@Column(name="DUM_FIELD_10")
	private Integer DUM_FIELD_10;

	private String UI_M_DUM_FIELD_10_DESC;

	@Column(name="DUM_FIELD_20")
	private Integer DUM_FIELD_20;

	private String UI_M_DUM_FIELD_20_DESC;
	
	
	
	@Column(name="DUM_CR_DT")
	private Date DUM_CR_DT;
	
	@Column(name="DUM_CR_UID")
	private String DUM_CR_UID;

	@Column(name="DUM_UPD_DT")
	private Date DUM_UPD_DT;
	
	@Column(name="DUM_UPD_UID")
	private String DUM_UPD_UID;

	/**
	 * @return the rOWID
	 */
	public String getROWID() {
		return ROWID;
	}

	/**
	 * @param rowid the rOWID to set
	 */
	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	/**
	 * @return the dUM_MAP_CODE
	 */
	public String getDUM_MAP_CODE() {
		return DUM_MAP_CODE;
	}

	/**
	 * @param dum_map_code the dUM_MAP_CODE to set
	 */
	public void setDUM_MAP_CODE(String dum_map_code) {
		DUM_MAP_CODE = dum_map_code;
	}

	/**
	 * @return the dUM_MAP_CODE_DESC
	 */
	public String getDUM_MAP_CODE_DESC() {
		return DUM_MAP_CODE_DESC;
	}

	/**
	 * @param dum_map_code_desc the dUM_MAP_CODE_DESC to set
	 */
	public void setDUM_MAP_CODE_DESC(String dum_map_code_desc) {
		DUM_MAP_CODE_DESC = dum_map_code_desc;
	}

	/**
	 * @return the dUM_DEF_CODE
	 */
	public String getDUM_DEF_CODE() {
		return DUM_DEF_CODE;
	}

	/**
	 * @param dum_def_code the dUM_DEF_CODE to set
	 */
	public void setDUM_DEF_CODE(String dum_def_code) {
		DUM_DEF_CODE = dum_def_code;
	}

	/**
	 * @return the uI_M_DEF_CODE_DESC
	 */
	public String getUI_M_DEF_CODE_DESC() {
		return UI_M_DEF_CODE_DESC;
	}

	/**
	 * @param ui_m_def_code_desc the uI_M_DEF_CODE_DESC to set
	 */
	public void setUI_M_DEF_CODE_DESC(String ui_m_def_code_desc) {
		UI_M_DEF_CODE_DESC = ui_m_def_code_desc;
	}

	/**
	 * @return the dUM_FIELD_01
	 */
	public Integer getDUM_FIELD_01() {
		return DUM_FIELD_01;
	}

	/**
	 * @param dum_field_01 the dUM_FIELD_01 to set
	 */
	public void setDUM_FIELD_01(Integer dum_field_01) {
		DUM_FIELD_01 = dum_field_01;
	}

	/**
	 * @return the uI_M_DUM_FIELD_01_DESC
	 */
	public String getUI_M_DUM_FIELD_01_DESC() {
		return UI_M_DUM_FIELD_01_DESC;
	}

	/**
	 * @param ui_m_dum_field_01_desc the uI_M_DUM_FIELD_01_DESC to set
	 */
	public void setUI_M_DUM_FIELD_01_DESC(String ui_m_dum_field_01_desc) {
		UI_M_DUM_FIELD_01_DESC = ui_m_dum_field_01_desc;
	}

	/**
	 * @return the dUM_FIELD_11
	 */
	public Integer getDUM_FIELD_11() {
		return DUM_FIELD_11;
	}

	/**
	 * @param dum_field_11 the dUM_FIELD_11 to set
	 */
	public void setDUM_FIELD_11(Integer dum_field_11) {
		DUM_FIELD_11 = dum_field_11;
	}

	/**
	 * @return the uI_M_DUM_FIELD_11_DESC
	 */
	public String getUI_M_DUM_FIELD_11_DESC() {
		return UI_M_DUM_FIELD_11_DESC;
	}

	/**
	 * @param ui_m_dum_field_11_desc the uI_M_DUM_FIELD_11_DESC to set
	 */
	public void setUI_M_DUM_FIELD_11_DESC(String ui_m_dum_field_11_desc) {
		UI_M_DUM_FIELD_11_DESC = ui_m_dum_field_11_desc;
	}

	/**
	 * @return the dUM_FIELD_02
	 */
	public Integer getDUM_FIELD_02() {
		return DUM_FIELD_02;
	}

	/**
	 * @param dum_field_02 the dUM_FIELD_02 to set
	 */
	public void setDUM_FIELD_02(Integer dum_field_02) {
		DUM_FIELD_02 = dum_field_02;
	}

	/**
	 * @return the uI_M_DUM_FIELD_02_DESC
	 */
	public String getUI_M_DUM_FIELD_02_DESC() {
		return UI_M_DUM_FIELD_02_DESC;
	}

	/**
	 * @param ui_m_dum_field_02_desc the uI_M_DUM_FIELD_02_DESC to set
	 */
	public void setUI_M_DUM_FIELD_02_DESC(String ui_m_dum_field_02_desc) {
		UI_M_DUM_FIELD_02_DESC = ui_m_dum_field_02_desc;
	}

	/**
	 * @return the dUM_FIELD_12
	 */
	public Integer getDUM_FIELD_12() {
		return DUM_FIELD_12;
	}

	/**
	 * @param dum_field_12 the dUM_FIELD_12 to set
	 */
	public void setDUM_FIELD_12(Integer dum_field_12) {
		DUM_FIELD_12 = dum_field_12;
	}

	/**
	 * @return the uI_M_DUM_FIELD_12_DESC
	 */
	public String getUI_M_DUM_FIELD_12_DESC() {
		return UI_M_DUM_FIELD_12_DESC;
	}

	/**
	 * @param ui_m_dum_field_12_desc the uI_M_DUM_FIELD_12_DESC to set
	 */
	public void setUI_M_DUM_FIELD_12_DESC(String ui_m_dum_field_12_desc) {
		UI_M_DUM_FIELD_12_DESC = ui_m_dum_field_12_desc;
	}

	/**
	 * @return the dUM_FIELD_03
	 */
	public Integer getDUM_FIELD_03() {
		return DUM_FIELD_03;
	}

	/**
	 * @param dum_field_03 the dUM_FIELD_03 to set
	 */
	public void setDUM_FIELD_03(Integer dum_field_03) {
		DUM_FIELD_03 = dum_field_03;
	}

	/**
	 * @return the uI_M_DUM_FIELD_03_DESC
	 */
	public String getUI_M_DUM_FIELD_03_DESC() {
		return UI_M_DUM_FIELD_03_DESC;
	}

	/**
	 * @param ui_m_dum_field_03_desc the uI_M_DUM_FIELD_03_DESC to set
	 */
	public void setUI_M_DUM_FIELD_03_DESC(String ui_m_dum_field_03_desc) {
		UI_M_DUM_FIELD_03_DESC = ui_m_dum_field_03_desc;
	}

	/**
	 * @return the dUM_FIELD_13
	 */
	public Integer getDUM_FIELD_13() {
		return DUM_FIELD_13;
	}

	/**
	 * @param dum_field_13 the dUM_FIELD_13 to set
	 */
	public void setDUM_FIELD_13(Integer dum_field_13) {
		DUM_FIELD_13 = dum_field_13;
	}

	/**
	 * @return the uI_M_DUM_FIELD_13_DESC
	 */
	public String getUI_M_DUM_FIELD_13_DESC() {
		return UI_M_DUM_FIELD_13_DESC;
	}

	/**
	 * @param ui_m_dum_field_13_desc the uI_M_DUM_FIELD_13_DESC to set
	 */
	public void setUI_M_DUM_FIELD_13_DESC(String ui_m_dum_field_13_desc) {
		UI_M_DUM_FIELD_13_DESC = ui_m_dum_field_13_desc;
	}

	/**
	 * @return the dUM_FIELD_04
	 */
	public Integer getDUM_FIELD_04() {
		return DUM_FIELD_04;
	}

	/**
	 * @param dum_field_04 the dUM_FIELD_04 to set
	 */
	public void setDUM_FIELD_04(Integer dum_field_04) {
		DUM_FIELD_04 = dum_field_04;
	}

	/**
	 * @return the uI_M_DUM_FIELD_04_DESC
	 */
	public String getUI_M_DUM_FIELD_04_DESC() {
		return UI_M_DUM_FIELD_04_DESC;
	}

	/**
	 * @param ui_m_dum_field_04_desc the uI_M_DUM_FIELD_04_DESC to set
	 */
	public void setUI_M_DUM_FIELD_04_DESC(String ui_m_dum_field_04_desc) {
		UI_M_DUM_FIELD_04_DESC = ui_m_dum_field_04_desc;
	}

	/**
	 * @return the dUM_FIELD_14
	 */
	public Integer getDUM_FIELD_14() {
		return DUM_FIELD_14;
	}

	/**
	 * @param dum_field_14 the dUM_FIELD_14 to set
	 */
	public void setDUM_FIELD_14(Integer dum_field_14) {
		DUM_FIELD_14 = dum_field_14;
	}

	/**
	 * @return the uI_M_DUM_FIELD_14_DESC
	 */
	public String getUI_M_DUM_FIELD_14_DESC() {
		return UI_M_DUM_FIELD_14_DESC;
	}

	/**
	 * @param ui_m_dum_field_14_desc the uI_M_DUM_FIELD_14_DESC to set
	 */
	public void setUI_M_DUM_FIELD_14_DESC(String ui_m_dum_field_14_desc) {
		UI_M_DUM_FIELD_14_DESC = ui_m_dum_field_14_desc;
	}

	/**
	 * @return the dUM_FIELD_05
	 */
	public Integer getDUM_FIELD_05() {
		return DUM_FIELD_05;
	}

	/**
	 * @param dum_field_05 the dUM_FIELD_05 to set
	 */
	public void setDUM_FIELD_05(Integer dum_field_05) {
		DUM_FIELD_05 = dum_field_05;
	}

	/**
	 * @return the uI_M_DUM_FIELD_05_DESC
	 */
	public String getUI_M_DUM_FIELD_05_DESC() {
		return UI_M_DUM_FIELD_05_DESC;
	}

	/**
	 * @param ui_m_dum_field_05_desc the uI_M_DUM_FIELD_05_DESC to set
	 */
	public void setUI_M_DUM_FIELD_05_DESC(String ui_m_dum_field_05_desc) {
		UI_M_DUM_FIELD_05_DESC = ui_m_dum_field_05_desc;
	}

	/**
	 * @return the dUM_FIELD_15
	 */
	public Integer getDUM_FIELD_15() {
		return DUM_FIELD_15;
	}

	/**
	 * @param dum_field_15 the dUM_FIELD_15 to set
	 */
	public void setDUM_FIELD_15(Integer dum_field_15) {
		DUM_FIELD_15 = dum_field_15;
	}

	/**
	 * @return the uI_M_DUM_FIELD_15_DESC
	 */
	public String getUI_M_DUM_FIELD_15_DESC() {
		return UI_M_DUM_FIELD_15_DESC;
	}

	/**
	 * @param ui_m_dum_field_15_desc the uI_M_DUM_FIELD_15_DESC to set
	 */
	public void setUI_M_DUM_FIELD_15_DESC(String ui_m_dum_field_15_desc) {
		UI_M_DUM_FIELD_15_DESC = ui_m_dum_field_15_desc;
	}

	/**
	 * @return the dUM_FIELD_06
	 */
	public Integer getDUM_FIELD_06() {
		return DUM_FIELD_06;
	}

	/**
	 * @param dum_field_06 the dUM_FIELD_06 to set
	 */
	public void setDUM_FIELD_06(Integer dum_field_06) {
		DUM_FIELD_06 = dum_field_06;
	}

	/**
	 * @return the uI_M_DUM_FIELD_06_DESC
	 */
	public String getUI_M_DUM_FIELD_06_DESC() {
		return UI_M_DUM_FIELD_06_DESC;
	}

	/**
	 * @param ui_m_dum_field_06_desc the uI_M_DUM_FIELD_06_DESC to set
	 */
	public void setUI_M_DUM_FIELD_06_DESC(String ui_m_dum_field_06_desc) {
		UI_M_DUM_FIELD_06_DESC = ui_m_dum_field_06_desc;
	}

	/**
	 * @return the dUM_FIELD_16
	 */
	public Integer getDUM_FIELD_16() {
		return DUM_FIELD_16;
	}

	/**
	 * @param dum_field_16 the dUM_FIELD_16 to set
	 */
	public void setDUM_FIELD_16(Integer dum_field_16) {
		DUM_FIELD_16 = dum_field_16;
	}

	/**
	 * @return the uI_M_DUM_FIELD_16_DESC
	 */
	public String getUI_M_DUM_FIELD_16_DESC() {
		return UI_M_DUM_FIELD_16_DESC;
	}

	/**
	 * @param ui_m_dum_field_16_desc the uI_M_DUM_FIELD_16_DESC to set
	 */
	public void setUI_M_DUM_FIELD_16_DESC(String ui_m_dum_field_16_desc) {
		UI_M_DUM_FIELD_16_DESC = ui_m_dum_field_16_desc;
	}

	/**
	 * @return the dUM_FIELD_07
	 */
	public Integer getDUM_FIELD_07() {
		return DUM_FIELD_07;
	}

	/**
	 * @param dum_field_07 the dUM_FIELD_07 to set
	 */
	public void setDUM_FIELD_07(Integer dum_field_07) {
		DUM_FIELD_07 = dum_field_07;
	}

	/**
	 * @return the uI_M_DUM_FIELD_07_DESC
	 */
	public String getUI_M_DUM_FIELD_07_DESC() {
		return UI_M_DUM_FIELD_07_DESC;
	}

	/**
	 * @param ui_m_dum_field_07_desc the uI_M_DUM_FIELD_07_DESC to set
	 */
	public void setUI_M_DUM_FIELD_07_DESC(String ui_m_dum_field_07_desc) {
		UI_M_DUM_FIELD_07_DESC = ui_m_dum_field_07_desc;
	}

	/**
	 * @return the dUM_FIELD_17
	 */
	public Integer getDUM_FIELD_17() {
		return DUM_FIELD_17;
	}

	/**
	 * @param dum_field_17 the dUM_FIELD_17 to set
	 */
	public void setDUM_FIELD_17(Integer dum_field_17) {
		DUM_FIELD_17 = dum_field_17;
	}

	/**
	 * @return the uI_M_DUM_FIELD_17_DESC
	 */
	public String getUI_M_DUM_FIELD_17_DESC() {
		return UI_M_DUM_FIELD_17_DESC;
	}

	/**
	 * @param ui_m_dum_field_17_desc the uI_M_DUM_FIELD_17_DESC to set
	 */
	public void setUI_M_DUM_FIELD_17_DESC(String ui_m_dum_field_17_desc) {
		UI_M_DUM_FIELD_17_DESC = ui_m_dum_field_17_desc;
	}

	/**
	 * @return the dUM_FIELD_08
	 */
	public Integer getDUM_FIELD_08() {
		return DUM_FIELD_08;
	}

	/**
	 * @param dum_field_08 the dUM_FIELD_08 to set
	 */
	public void setDUM_FIELD_08(Integer dum_field_08) {
		DUM_FIELD_08 = dum_field_08;
	}

	/**
	 * @return the uI_M_DUM_FIELD_08_DESC
	 */
	public String getUI_M_DUM_FIELD_08_DESC() {
		return UI_M_DUM_FIELD_08_DESC;
	}

	/**
	 * @param ui_m_dum_field_08_desc the uI_M_DUM_FIELD_08_DESC to set
	 */
	public void setUI_M_DUM_FIELD_08_DESC(String ui_m_dum_field_08_desc) {
		UI_M_DUM_FIELD_08_DESC = ui_m_dum_field_08_desc;
	}

	/**
	 * @return the dUM_FIELD_18
	 */
	public Integer getDUM_FIELD_18() {
		return DUM_FIELD_18;
	}

	/**
	 * @param dum_field_18 the dUM_FIELD_18 to set
	 */
	public void setDUM_FIELD_18(Integer dum_field_18) {
		DUM_FIELD_18 = dum_field_18;
	}

	/**
	 * @return the uI_M_DUM_FIELD_18_DESC
	 */
	public String getUI_M_DUM_FIELD_18_DESC() {
		return UI_M_DUM_FIELD_18_DESC;
	}

	/**
	 * @param ui_m_dum_field_18_desc the uI_M_DUM_FIELD_18_DESC to set
	 */
	public void setUI_M_DUM_FIELD_18_DESC(String ui_m_dum_field_18_desc) {
		UI_M_DUM_FIELD_18_DESC = ui_m_dum_field_18_desc;
	}

	/**
	 * @return the dUM_FIELD_09
	 */
	public Integer getDUM_FIELD_09() {
		return DUM_FIELD_09;
	}

	/**
	 * @param dum_field_09 the dUM_FIELD_09 to set
	 */
	public void setDUM_FIELD_09(Integer dum_field_09) {
		DUM_FIELD_09 = dum_field_09;
	}

	/**
	 * @return the uI_M_DUM_FIELD_09_DESC
	 */
	public String getUI_M_DUM_FIELD_09_DESC() {
		return UI_M_DUM_FIELD_09_DESC;
	}

	/**
	 * @param ui_m_dum_field_09_desc the uI_M_DUM_FIELD_09_DESC to set
	 */
	public void setUI_M_DUM_FIELD_09_DESC(String ui_m_dum_field_09_desc) {
		UI_M_DUM_FIELD_09_DESC = ui_m_dum_field_09_desc;
	}

	/**
	 * @return the dUM_FIELD_19
	 */
	public Integer getDUM_FIELD_19() {
		return DUM_FIELD_19;
	}

	/**
	 * @param dum_field_19 the dUM_FIELD_19 to set
	 */
	public void setDUM_FIELD_19(Integer dum_field_19) {
		DUM_FIELD_19 = dum_field_19;
	}

	/**
	 * @return the uI_M_DUM_FIELD_19_DESC
	 */
	public String getUI_M_DUM_FIELD_19_DESC() {
		return UI_M_DUM_FIELD_19_DESC;
	}

	/**
	 * @param ui_m_dum_field_19_desc the uI_M_DUM_FIELD_19_DESC to set
	 */
	public void setUI_M_DUM_FIELD_19_DESC(String ui_m_dum_field_19_desc) {
		UI_M_DUM_FIELD_19_DESC = ui_m_dum_field_19_desc;
	}

	/**
	 * @return the dUM_FIELD_10
	 */
	public Integer getDUM_FIELD_10() {
		return DUM_FIELD_10;
	}

	/**
	 * @param dum_field_10 the dUM_FIELD_10 to set
	 */
	public void setDUM_FIELD_10(Integer dum_field_10) {
		DUM_FIELD_10 = dum_field_10;
	}

	/**
	 * @return the uI_M_DUM_FIELD_10_DESC
	 */
	public String getUI_M_DUM_FIELD_10_DESC() {
		return UI_M_DUM_FIELD_10_DESC;
	}

	/**
	 * @param ui_m_dum_field_10_desc the uI_M_DUM_FIELD_10_DESC to set
	 */
	public void setUI_M_DUM_FIELD_10_DESC(String ui_m_dum_field_10_desc) {
		UI_M_DUM_FIELD_10_DESC = ui_m_dum_field_10_desc;
	}

	/**
	 * @return the dUM_FIELD_20
	 */
	public Integer getDUM_FIELD_20() {
		return DUM_FIELD_20;
	}

	/**
	 * @param dum_field_20 the dUM_FIELD_20 to set
	 */
	public void setDUM_FIELD_20(Integer dum_field_20) {
		DUM_FIELD_20 = dum_field_20;
	}

	/**
	 * @return the uI_M_DUM_FIELD_20_DESC
	 */
	public String getUI_M_DUM_FIELD_20_DESC() {
		return UI_M_DUM_FIELD_20_DESC;
	}

	/**
	 * @param ui_m_dum_field_20_desc the uI_M_DUM_FIELD_20_DESC to set
	 */
	public void setUI_M_DUM_FIELD_20_DESC(String ui_m_dum_field_20_desc) {
		UI_M_DUM_FIELD_20_DESC = ui_m_dum_field_20_desc;
	}

	/**
	 * @return the dUM_CR_DT
	 */
	public Date getDUM_CR_DT() {
		return DUM_CR_DT;
	}

	/**
	 * @param dum_cr_dt the dUM_CR_DT to set
	 */
	public void setDUM_CR_DT(Date dum_cr_dt) {
		DUM_CR_DT = dum_cr_dt;
	}

	/**
	 * @return the dUM_CR_UID
	 */
	public String getDUM_CR_UID() {
		return DUM_CR_UID;
	}

	/**
	 * @param dum_cr_uid the dUM_CR_UID to set
	 */
	public void setDUM_CR_UID(String dum_cr_uid) {
		DUM_CR_UID = dum_cr_uid;
	}

	/**
	 * @return the dUM_UPD_DT
	 */
	public Date getDUM_UPD_DT() {
		return DUM_UPD_DT;
	}

	/**
	 * @param dum_upd_dt the dUM_UPD_DT to set
	 */
	public void setDUM_UPD_DT(Date dum_upd_dt) {
		DUM_UPD_DT = dum_upd_dt;
	}

	/**
	 * @return the dUM_UPD_UID
	 */
	public String getDUM_UPD_UID() {
		return DUM_UPD_UID;
	}

	/**
	 * @param dum_upd_uid the dUM_UPD_UID to set
	 */
	public void setDUM_UPD_UID(String dum_upd_uid) {
		DUM_UPD_UID = dum_upd_uid;
	}


	/*	added by raja on 06-03-2017 for ZBILQC-1719694 */
	@Column(name="DUM_EMPLOYER_CODE")
	private String DUM_EMPLOYER_CODE;
	
	private String DUM_EMPLOYER_CODE_DESC;
	

	@Column(name="DUM_PAYMENT_MODE")
	private String DUM_PAYMENT_MODE;

	public String getDUM_EMPLOYER_CODE() {
		return DUM_EMPLOYER_CODE;
	}

	public void setDUM_EMPLOYER_CODE(String dUM_EMPLOYER_CODE) {
		DUM_EMPLOYER_CODE = dUM_EMPLOYER_CODE;
	}

	public String getDUM_EMPLOYER_CODE_DESC() {
		return DUM_EMPLOYER_CODE_DESC;
	}

	public void setDUM_EMPLOYER_CODE_DESC(String dUM_EMPLOYER_CODE_DESC) {
		DUM_EMPLOYER_CODE_DESC = dUM_EMPLOYER_CODE_DESC;
	}

	public String getDUM_PAYMENT_MODE() {
		return DUM_PAYMENT_MODE;
	}

	public void setDUM_PAYMENT_MODE(String dUM_PAYMENT_MODE) {
		DUM_PAYMENT_MODE = dUM_PAYMENT_MODE;
	}
/*end*/

/*Added by sankara narayanan on 03/04/2017*/
	
	@Column(name="DUM_UPLOAD_TYPE")
	private String DUM_UPLOAD_TYPE;

	public String getDUM_UPLOAD_TYPE() {
		return DUM_UPLOAD_TYPE;
	}

	public void setDUM_UPLOAD_TYPE(String dUM_UPLOAD_TYPE) {
		DUM_UPLOAD_TYPE = dUM_UPLOAD_TYPE;
	}
	/*end*/
	
	@Column(name="DUM_DUE_DT")
	private Date DUM_DUE_DT;
	
	@Column(name="DUM_EFF_FM_DT")
	private Date DUM_EFF_FM_DT;
	
	@Column(name="DUM_EFF_TO_DT")
	private Date DUM_EFF_TO_DT;

	public Date getDUM_DUE_DT() {
		return DUM_DUE_DT;
	}

	public void setDUM_DUE_DT(Date dUM_DUE_DT) {
		DUM_DUE_DT = dUM_DUE_DT;
	}

	public Date getDUM_EFF_FM_DT() {
		return DUM_EFF_FM_DT;
	}

	public void setDUM_EFF_FM_DT(Date dUM_EFF_FM_DT) {
		DUM_EFF_FM_DT = dUM_EFF_FM_DT;
	}

	public Date getDUM_EFF_TO_DT() {
		return DUM_EFF_TO_DT;
	}

	public void setDUM_EFF_TO_DT(Date dUM_EFF_TO_DT) {
		DUM_EFF_TO_DT = dUM_EFF_TO_DT;
	}
	
	
	/*added by raja on 27-06-2017 for ZBILQC-1729595*/
	@Column(name="DUM_EMPLOYER_TYPE")
	private String DUM_EMPLOYER_TYPE;

	public String getDUM_EMPLOYER_TYPE() {
		return DUM_EMPLOYER_TYPE;
	}

	public void setDUM_EMPLOYER_TYPE(String dUM_EMPLOYER_TYPE) {
		DUM_EMPLOYER_TYPE = dUM_EMPLOYER_TYPE;
	}

	/*end*/
}
