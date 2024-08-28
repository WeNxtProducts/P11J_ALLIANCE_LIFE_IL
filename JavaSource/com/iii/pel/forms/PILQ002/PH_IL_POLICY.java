package com.iii.pel.forms.PILQ002;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PH_IL_POLICY")
public class PH_IL_POLICY  extends BaseValueBean{
	
	
	@Column(name="ROWID")
	private String ROWID;

	@Column(name="POLH_N_END_NO_IDX")
	private Long POLH_N_END_NO_IDX;

	@Column(name="POLH_N_END_CODE")
	private String POLH_N_END_CODE;

	@Column(name="POLH_N_END_DESC")
	private String POLH_N_END_DESC;

	private String UI_M_POLH_N_END_CODE_DESC;

	@Column(name="POLH_N_END_NO")
	private String POLH_N_END_NO;

	@Column(name="POLH_N_END_EFF_FROM_DT")
	private Date POLH_N_END_EFF_FROM_DT;

	@Column(name="POLH_N_END_EFF_TO_DT")
	private Date POLH_N_END_EFF_TO_DT;
	
	@Column(name="POLH_DS_TYPE")
	private String POLH_DS_TYPE;

	@Column(name="POLH_DS_CODE")
	private String POLH_DS_CODE;
	
//	[Muthu Added
	@Column(name="POLH_END_NO_IDX")
	private Double POLH_END_NO_IDX;
	
	@Column(name="POLH_SYS_ID")
	private Long POLH_SYS_ID;
	
	private String UI_POLH_N_END_EFF_FROM_DT;
	
	private String UI_POLH_N_END_EFF_TO_DT;
	
	/*added by Ameen on 03-07-2018 for KIC as per Ajay sugg.*/
	@Column(name="POLH_N_END_DT")
	private Date POLH_N_END_DT;
	
	private String UI_M_POLH_N_END_DT;
	
	public String getUI_M_POLH_N_END_DT() {
		return UI_M_POLH_N_END_DT;
	}

	public void setUI_M_POLH_N_END_DT(String uI_M_POLH_N_END_DT) {
		UI_M_POLH_N_END_DT = uI_M_POLH_N_END_DT;
	}

	public Date getPOLH_N_END_DT() {
		return POLH_N_END_DT;
	}

	public void setPOLH_N_END_DT(Date pOLH_N_END_DT) {
		POLH_N_END_DT = pOLH_N_END_DT;
		UI_M_POLH_N_END_DT = CommonUtils.dateToPELStringFormatter(POLH_N_END_DT);
	}
	/*End*/

	public Double getPOLH_END_NO_IDX() {
		return POLH_END_NO_IDX;
	}

	public void setPOLH_END_NO_IDX(Double polh_end_no_idx) {
		POLH_END_NO_IDX = polh_end_no_idx;
	}

	public Long getPOLH_SYS_ID() {
		return POLH_SYS_ID;
	}

	public void setPOLH_SYS_ID(Long polh_sys_id) {
		POLH_SYS_ID = polh_sys_id;
	}
//	Muthu Added]

	public Long getPOLH_N_END_NO_IDX() {
		return POLH_N_END_NO_IDX;
	}

	public void setPOLH_N_END_NO_IDX(Long POLH_N_END_NO_IDX) {
		this.POLH_N_END_NO_IDX = POLH_N_END_NO_IDX;
	}

	public String getPOLH_N_END_CODE() {
		return POLH_N_END_CODE;
	}

	public void setPOLH_N_END_CODE(String POLH_N_END_CODE) {
		this.POLH_N_END_CODE = POLH_N_END_CODE;
	}

	public String getPOLH_N_END_DESC() {
		return POLH_N_END_DESC;
	}

	public void setPOLH_N_END_DESC(String POLH_N_END_DESC) {
		this.POLH_N_END_DESC = POLH_N_END_DESC;
	}

	public String getUI_M_POLH_N_END_CODE_DESC() {
		return UI_M_POLH_N_END_CODE_DESC;
	}

	public void setUI_M_POLH_N_END_CODE_DESC(String UI_M_POLH_N_END_CODE_DESC) {
		this.UI_M_POLH_N_END_CODE_DESC = UI_M_POLH_N_END_CODE_DESC;
	}

	public String getPOLH_N_END_NO() {
		return POLH_N_END_NO;
	}

	public void setPOLH_N_END_NO(String POLH_N_END_NO) {
		this.POLH_N_END_NO = POLH_N_END_NO;
	}

	public Date getPOLH_N_END_EFF_FROM_DT() {
		 return POLH_N_END_EFF_FROM_DT;
	}

	public void setPOLH_N_END_EFF_FROM_DT(Date POLH_N_END_EFF_FROM_DT) {
		this.POLH_N_END_EFF_FROM_DT = POLH_N_END_EFF_FROM_DT;
		UI_POLH_N_END_EFF_FROM_DT = CommonUtils.dateToPELStringFormatter(POLH_N_END_EFF_FROM_DT);
	}

	public Date getPOLH_N_END_EFF_TO_DT() {
		 return POLH_N_END_EFF_TO_DT;
	}

	public void setPOLH_N_END_EFF_TO_DT(Date POLH_N_END_EFF_TO_DT) {
		this.POLH_N_END_EFF_TO_DT = POLH_N_END_EFF_TO_DT;
		UI_POLH_N_END_EFF_TO_DT = CommonUtils.dateToPELStringFormatter(POLH_N_END_EFF_TO_DT);
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getUI_POLH_N_END_EFF_FROM_DT() {
		return UI_POLH_N_END_EFF_FROM_DT;
	}

	public void setUI_POLH_N_END_EFF_FROM_DT(String ui_polh_n_end_eff_from_dt) {
		UI_POLH_N_END_EFF_FROM_DT = ui_polh_n_end_eff_from_dt;
	}

	public String getUI_POLH_N_END_EFF_TO_DT() {
		return UI_POLH_N_END_EFF_TO_DT;
	}

	public void setUI_POLH_N_END_EFF_TO_DT(String ui_polh_n_end_eff_to_dt) {
		UI_POLH_N_END_EFF_TO_DT = ui_polh_n_end_eff_to_dt;
	}

	public String getPOLH_DS_TYPE() {
		return POLH_DS_TYPE;
	}

	public void setPOLH_DS_TYPE(String polh_ds_type) {
		POLH_DS_TYPE = polh_ds_type;
	}

	public String getPOLH_DS_CODE() {
		return POLH_DS_CODE;
	}

	public void setPOLH_DS_CODE(String polh_ds_code) {
		POLH_DS_CODE = polh_ds_code;
	}

}
