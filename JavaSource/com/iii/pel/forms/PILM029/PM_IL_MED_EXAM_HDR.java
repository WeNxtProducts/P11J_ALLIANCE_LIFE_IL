package com.iii.pel.forms.PILM029;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name = "PM_IL_MED_EXAM_HDR")
public class PM_IL_MED_EXAM_HDR extends BaseValueBean {
	@Column(name = "MEH_FRZ_FLAG")
	private String MEH_FRZ_FLAG;

	@Column(name = "MEH_SUM_ASSURED_FM")
	private Double MEH_SUM_ASSURED_FM;

	@Column(name = "MEH_SUM_ASSURED_TO")
	private Double MEH_SUM_ASSURED_TO;

	@Column(name = "MEH_AGE_FM")
	private Integer MEH_AGE_FM;

	@Column(name = "MEH_AGE_TO")
	private Integer MEH_AGE_TO;

	@Column(name = "MEH_SYS_ID")
	private Long MEH_SYS_ID;

	@Column(name = "MEH_CR_DT")
	private Date MEH_CR_DT;

	@Column(name = "MEH_CR_UID")
	private String MEH_CR_UID;
	
	@Column(name = "MEH_UPD_DT")
	private Date MEH_UPD_DT;

	@Column(name = "MEH_UPD_UID")
	private String MEH_UPD_UID;
	
	@Column(name = "MEH_PROD_CODE_FM")
	private String MEH_PROD_CODE_FM;
	
	@Column(name = "MEH_PROD_CODE_TO")
	private String MEH_PROD_CODE_TO;
	

	private boolean selected;

	private boolean check;
	
	private boolean CHECK_MEH_FRZ_FLAG;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getMEH_FRZ_FLAG() {
		return MEH_FRZ_FLAG;
	}

	public void setMEH_FRZ_FLAG(String MEH_FRZ_FLAG) {
		this.MEH_FRZ_FLAG = MEH_FRZ_FLAG;
		if(MEH_FRZ_FLAG!=null && MEH_FRZ_FLAG.equals("Y"))
			CHECK_MEH_FRZ_FLAG = true;
		else 
			CHECK_MEH_FRZ_FLAG = false;
		
		
	}


	public Integer getMEH_AGE_FM() {
		return MEH_AGE_FM;
	}

	public void setMEH_AGE_FM(Integer meh_age_fm) {
		MEH_AGE_FM = meh_age_fm;
	}

	public Integer getMEH_AGE_TO() {
		return MEH_AGE_TO;
	}

	public void setMEH_AGE_TO(Integer meh_age_to) {
		MEH_AGE_TO = meh_age_to;
	}

	public Long getMEH_SYS_ID() {
		System.out.println("********>" + MEH_SYS_ID);
		return MEH_SYS_ID;
	}

	public void setMEH_SYS_ID(Long meh_sys_id) {

		MEH_SYS_ID = meh_sys_id;

	}

	public Date getMEH_CR_DT() {
		return MEH_CR_DT;
	}

	public void setMEH_CR_DT(Date meh_cr_dt) {
		MEH_CR_DT = meh_cr_dt;
	}

	public String getMEH_CR_UID() {
		return MEH_CR_UID;
	}

	

	public void setMEH_CR_UID(String meh_cr_uid) {
		MEH_CR_UID = meh_cr_uid;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		CommonUtils commonUtils = new CommonUtils();
		this.check = check;
	}

	public Double getMEH_SUM_ASSURED_FM() {
		return MEH_SUM_ASSURED_FM;
	}

	public void setMEH_SUM_ASSURED_FM(Double meh_sum_assured_fm) {
		MEH_SUM_ASSURED_FM = meh_sum_assured_fm;
	}

	public Double getMEH_SUM_ASSURED_TO() {
		return MEH_SUM_ASSURED_TO;
	}

	public void setMEH_SUM_ASSURED_TO(Double meh_sum_assured_to) {
		MEH_SUM_ASSURED_TO = meh_sum_assured_to;
	}

	public Date getMEH_UPD_DT() {
		return MEH_UPD_DT;
	}

	public void setMEH_UPD_DT(Date meh_upd_dt) {
		MEH_UPD_DT = meh_upd_dt;
	}

	public String getMEH_UPD_UID() {
		return MEH_UPD_UID;
	}

	public void setMEH_UPD_UID(String meh_upd_uid) {
		MEH_UPD_UID = meh_upd_uid;
	}

	public boolean isCHECK_MEH_FRZ_FLAG() {
		return CHECK_MEH_FRZ_FLAG;
	}

	public void setCHECK_MEH_FRZ_FLAG(boolean check_meh_frz_flag) {
		CHECK_MEH_FRZ_FLAG = check_meh_frz_flag;
		if(CHECK_MEH_FRZ_FLAG)
			MEH_FRZ_FLAG ="Y";
		else 
			MEH_FRZ_FLAG ="N";
	}

	public String getMEH_PROD_CODE_FM() {
		return MEH_PROD_CODE_FM;
	}

	public void setMEH_PROD_CODE_FM(String meh_prod_code_fm) {
		MEH_PROD_CODE_FM = meh_prod_code_fm;
	}

	public String getMEH_PROD_CODE_TO() {
		return MEH_PROD_CODE_TO;
	}

	public void setMEH_PROD_CODE_TO(String meh_prod_code_to) {
		MEH_PROD_CODE_TO = meh_prod_code_to;
	}

	
}
