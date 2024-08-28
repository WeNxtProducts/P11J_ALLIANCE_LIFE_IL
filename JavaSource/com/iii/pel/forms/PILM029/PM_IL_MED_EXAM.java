package com.iii.pel.forms.PILM029;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class PM_IL_MED_EXAM extends BaseValueBean {

	@Column(name="MEH_SUM_ASSURED_FM")
	private Double MEH_SUM_ASSURED_FM;

	@Column(name="MEH_SUM_ASSURED_TO")
	private Double MEH_SUM_ASSURED_TO;

	@Column(name="MEH_AGE_FM")
	private Integer MEH_AGE_FM;

	@Column(name="MEH_AGE_TO")
	private Integer MEH_AGE_TO;

	@Column(name="MEH_FRZ_FLAG")
	private String MEH_FRZ_FLAG;

	@Column(name="MED_EXAM_CODE")
	private String MED_EXAM_CODE;

	private String UI_M_MED_EXAM_CODE_DESC;



	public Double getMEH_SUM_ASSURED_FM() {
		return MEH_SUM_ASSURED_FM;
	}

	public void setMEH_SUM_ASSURED_FM(Double MEH_SUM_ASSURED_FM) {
		this.MEH_SUM_ASSURED_FM = MEH_SUM_ASSURED_FM;
	}

	public Double getMEH_SUM_ASSURED_TO() {
		return MEH_SUM_ASSURED_TO;
	}

	public void setMEH_SUM_ASSURED_TO(Double MEH_SUM_ASSURED_TO) {
		this.MEH_SUM_ASSURED_TO = MEH_SUM_ASSURED_TO;
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

	public String getMEH_FRZ_FLAG() {
		return MEH_FRZ_FLAG;
	}

	public void setMEH_FRZ_FLAG(String MEH_FRZ_FLAG) {
		this.MEH_FRZ_FLAG = MEH_FRZ_FLAG;
	}

	public String getMED_EXAM_CODE() {
		return MED_EXAM_CODE;
	}

	public void setMED_EXAM_CODE(String MED_EXAM_CODE) {
		this.MED_EXAM_CODE = MED_EXAM_CODE;
	}

	public String getUI_M_MED_EXAM_CODE_DESC() {
		return UI_M_MED_EXAM_CODE_DESC;
	}

	public void setUI_M_MED_EXAM_CODE_DESC(String UI_M_MED_EXAM_CODE_DESC) {
		this.UI_M_MED_EXAM_CODE_DESC = UI_M_MED_EXAM_CODE_DESC;
	}
}
