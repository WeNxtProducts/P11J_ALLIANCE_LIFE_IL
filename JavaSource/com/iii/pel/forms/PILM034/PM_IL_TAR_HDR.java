package com.iii.pel.forms.PILM034;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_TAR_HDR")
public class PM_IL_TAR_HDR extends BaseValueBean{


	@Column(name="ROWID")
	private String ROWID;

	@Column(name="TH_CODE")
	private String TH_CODE;

	@Column(name="TH_PARAM_TYPE")
	private String TH_PARAM_TYPE;

	@Column(name="TH_DESC")
	private String TH_DESC;

	@Column(name="TH_BL_DESC")
	private String TH_BL_DESC;

	@Column(name="TH_PARA_01")
	private int TH_PARA_01;

	@Column(name="TH_PARA_02")
	private Integer TH_PARA_02;

	@Column(name="TH_PARA_03")
	private Integer TH_PARA_03;

	@Column(name="TH_PARA_04")
	private Integer TH_PARA_04;

	@Column(name="TH_PARA_05")
	private Integer TH_PARA_05;

	@Column(name="TH_PARA_06")
	private Integer TH_PARA_06;

	@Column(name="TH_PARA_07")
	private Integer TH_PARA_07;

	@Column(name="TH_PARA_08")
	private Integer TH_PARA_08;

	@Column(name="TH_PARA_09")
	private Integer TH_PARA_09;

	@Column(name="TH_PARA_10")
	private Integer TH_PARA_10;

	@Column(name="TH_RATE_PER")
	private Integer TH_RATE_PER;

	@Column(name="TH_EFF_FM_DT")
	private Date TH_EFF_FM_DT;

	@Column(name="TH_EFF_TO_DT")
	private Date TH_EFF_TO_DT;

	@Column(name="TH_CR_DT")
	private Date TH_CR_DT;

	@Column(name="TH_CR_UID")
	private String TH_CR_UID;

	@Column(name="TH_UPD_DT")
	private Date TH_UPD_DT;

	@Column(name="TH_UPD_UID")
	private String TH_UPD_UID;

	private String UI_M_TH_CODE;


	private int M_COUNT = 0;



	public int getM_COUNT() {
		return M_COUNT;
	}

	public void setM_COUNT(int m_count) {
		M_COUNT = m_count;
	}

	public int getTH_PARA_01() {
		return TH_PARA_01;
	}

	public void setTH_PARA_01(int th_para_01) {
		TH_PARA_01 = th_para_01;
	}

	public Integer getTH_PARA_02() {
		return TH_PARA_02;
	}

	public void setTH_PARA_02(Integer th_para_02) {
		TH_PARA_02 = th_para_02;
	}

	public Integer getTH_PARA_03() {
		return TH_PARA_03;
	}

	public void setTH_PARA_03(Integer th_para_03) {
		TH_PARA_03 = th_para_03;
	}

	public Integer getTH_PARA_04() {
		return TH_PARA_04;
	}

	public void setTH_PARA_04(Integer th_para_04) {
		TH_PARA_04 = th_para_04;
	}

	public Integer getTH_PARA_05() {
		return TH_PARA_05;
	}

	public void setTH_PARA_05(Integer th_para_05) {
		TH_PARA_05 = th_para_05;
	}

	public Integer getTH_PARA_06() {
		return TH_PARA_06;
	}

	public void setTH_PARA_06(Integer th_para_06) {
		TH_PARA_06 = th_para_06;
	}

	public Integer getTH_PARA_07() {
		return TH_PARA_07;
	}

	public void setTH_PARA_07(Integer th_para_07) {
		TH_PARA_07 = th_para_07;
	}

	public Integer getTH_PARA_08() {
		return TH_PARA_08;
	}

	public void setTH_PARA_08(Integer th_para_08) {
		TH_PARA_08 = th_para_08;
	}

	public Integer getTH_PARA_09() {
		return TH_PARA_09;
	}

	public void setTH_PARA_09(Integer th_para_09) {
		TH_PARA_09 = th_para_09;
	}

	public Integer getTH_PARA_10() {
		return TH_PARA_10;
	}

	public void setTH_PARA_10(Integer th_para_10) {
		TH_PARA_10 = th_para_10;
	}

	public String getTH_CODE() {
		return TH_CODE;
	}

	public void setTH_CODE(String th_code) {
		TH_CODE = th_code;
	}

	public Date getTH_EFF_FM_DT() {
		return TH_EFF_FM_DT;
	}

	public void setTH_EFF_FM_DT(Date th_eff_fm_dt) {
		TH_EFF_FM_DT = th_eff_fm_dt;
	}

	public String getUI_M_TH_CODE() {
		return UI_M_TH_CODE;
	}

	public void setUI_M_TH_CODE(String ui_m_th_code) {
		UI_M_TH_CODE = ui_m_th_code;
	}

	public String getTH_DESC() {
		return TH_DESC;
	}

	public void setTH_DESC(String th_desc) {
		TH_DESC = th_desc;
	}

	public Date getTH_EFF_TO_DT() {
		return TH_EFF_TO_DT;
	}

	public void setTH_EFF_TO_DT(Date th_eff_to_dt) {
		TH_EFF_TO_DT = th_eff_to_dt;
	}

	public String getTH_BL_DESC() {
		return TH_BL_DESC;
	}

	public void setTH_BL_DESC(String th_bl_desc) {
		TH_BL_DESC = th_bl_desc;
	}

	public Integer getTH_RATE_PER() {
		return TH_RATE_PER;
	}

	public void setTH_RATE_PER(Integer th_rate_per) {
		TH_RATE_PER = th_rate_per;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public Date getTH_CR_DT() {
		return TH_CR_DT;
	}

	public void setTH_CR_DT(Date th_cr_dt) {
		TH_CR_DT = th_cr_dt;
	}

	public String getTH_CR_UID() {
		return TH_CR_UID;
	}

	public void setTH_CR_UID(String th_cr_uid) {
		TH_CR_UID = th_cr_uid;
	}

	public Date getTH_UPD_DT() {
		return TH_UPD_DT;
	}

	public void setTH_UPD_DT(Date th_upd_dt) {
		TH_UPD_DT = th_upd_dt;
	}

	public String getTH_UPD_UID() {
		return TH_UPD_UID;
	}

	public void setTH_UPD_UID(String th_upd_uid) {
		TH_UPD_UID = th_upd_uid;
	}

	public String getTH_PARAM_TYPE() {
		return TH_PARAM_TYPE;
	}

	public void setTH_PARAM_TYPE(String th_param_type) {
		TH_PARAM_TYPE = th_param_type;
	}
}
