package com.iii.pel.forms.PILM029;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;


public class PM_IL_MED_EXAM_ACTION {

	private HtmlOutputLabel COMP_MEH_SUM_ASSURED_FM_LABEL;

	private HtmlInputText COMP_MEH_SUM_ASSURED_FM;

	private HtmlOutputLabel COMP_MEH_SUM_ASSURED_TO_LABEL;

	private HtmlInputText COMP_MEH_SUM_ASSURED_TO;

	private HtmlOutputLabel COMP_MEH_AGE_FM_LABEL;

	private HtmlInputText COMP_MEH_AGE_FM;

	private HtmlOutputLabel COMP_MEH_AGE_TO_LABEL;

	private HtmlInputText COMP_MEH_AGE_TO;

	private HtmlOutputLabel COMP_MEH_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_MEH_FRZ_FLAG;

	private HtmlOutputLabel COMP_MED_EXAM_CODE_LABEL;

	private HtmlInputText COMP_MED_EXAM_CODE;

	private HtmlInputText COMP_UI_M_MED_EXAM_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_EXAM_CODE_LOV;

	private PM_IL_MED_EXAM PM_IL_MED_EXAM_BEAN;

	public PM_IL_MED_EXAM_ACTION() {
		PM_IL_MED_EXAM_BEAN = new PM_IL_MED_EXAM();
	}

	public HtmlOutputLabel getCOMP_MEH_SUM_ASSURED_FM_LABEL() {
		return COMP_MEH_SUM_ASSURED_FM_LABEL;
	}

	public HtmlInputText getCOMP_MEH_SUM_ASSURED_FM() {
		return COMP_MEH_SUM_ASSURED_FM;
	}

	public void setCOMP_MEH_SUM_ASSURED_FM_LABEL(HtmlOutputLabel COMP_MEH_SUM_ASSURED_FM_LABEL) {
		this.COMP_MEH_SUM_ASSURED_FM_LABEL = COMP_MEH_SUM_ASSURED_FM_LABEL;
	}

	public void setCOMP_MEH_SUM_ASSURED_FM(HtmlInputText COMP_MEH_SUM_ASSURED_FM) {
		this.COMP_MEH_SUM_ASSURED_FM = COMP_MEH_SUM_ASSURED_FM;
	}

	public HtmlOutputLabel getCOMP_MEH_SUM_ASSURED_TO_LABEL() {
		return COMP_MEH_SUM_ASSURED_TO_LABEL;
	}

	public HtmlInputText getCOMP_MEH_SUM_ASSURED_TO() {
		return COMP_MEH_SUM_ASSURED_TO;
	}

	public void setCOMP_MEH_SUM_ASSURED_TO_LABEL(HtmlOutputLabel COMP_MEH_SUM_ASSURED_TO_LABEL) {
		this.COMP_MEH_SUM_ASSURED_TO_LABEL = COMP_MEH_SUM_ASSURED_TO_LABEL;
	}

	public void setCOMP_MEH_SUM_ASSURED_TO(HtmlInputText COMP_MEH_SUM_ASSURED_TO) {
		this.COMP_MEH_SUM_ASSURED_TO = COMP_MEH_SUM_ASSURED_TO;
	}

	public HtmlOutputLabel getCOMP_MEH_AGE_FM_LABEL() {
		return COMP_MEH_AGE_FM_LABEL;
	}

	public HtmlInputText getCOMP_MEH_AGE_FM() {
		return COMP_MEH_AGE_FM;
	}

	public void setCOMP_MEH_AGE_FM_LABEL(HtmlOutputLabel COMP_MEH_AGE_FM_LABEL) {
		this.COMP_MEH_AGE_FM_LABEL = COMP_MEH_AGE_FM_LABEL;
	}

	public void setCOMP_MEH_AGE_FM(HtmlInputText COMP_MEH_AGE_FM) {
		this.COMP_MEH_AGE_FM = COMP_MEH_AGE_FM;
	}

	public HtmlOutputLabel getCOMP_MEH_AGE_TO_LABEL() {
		return COMP_MEH_AGE_TO_LABEL;
	}

	public HtmlInputText getCOMP_MEH_AGE_TO() {
		return COMP_MEH_AGE_TO;
	}

	public void setCOMP_MEH_AGE_TO_LABEL(HtmlOutputLabel COMP_MEH_AGE_TO_LABEL) {
		this.COMP_MEH_AGE_TO_LABEL = COMP_MEH_AGE_TO_LABEL;
	}

	public void setCOMP_MEH_AGE_TO(HtmlInputText COMP_MEH_AGE_TO) {
		this.COMP_MEH_AGE_TO = COMP_MEH_AGE_TO;
	}

	public HtmlOutputLabel getCOMP_MEH_FRZ_FLAG_LABEL() {
		return COMP_MEH_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_MEH_FRZ_FLAG() {
		return COMP_MEH_FRZ_FLAG;
	}

	public void setCOMP_MEH_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_MEH_FRZ_FLAG_LABEL) {
		this.COMP_MEH_FRZ_FLAG_LABEL = COMP_MEH_FRZ_FLAG_LABEL;
	}

	public void setCOMP_MEH_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_MEH_FRZ_FLAG) {
		this.COMP_MEH_FRZ_FLAG = COMP_MEH_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_MED_EXAM_CODE_LABEL() {
		return COMP_MED_EXAM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MED_EXAM_CODE() {
		return COMP_MED_EXAM_CODE;
	}

	public void setCOMP_MED_EXAM_CODE_LABEL(HtmlOutputLabel COMP_MED_EXAM_CODE_LABEL) {
		this.COMP_MED_EXAM_CODE_LABEL = COMP_MED_EXAM_CODE_LABEL;
	}

	public void setCOMP_MED_EXAM_CODE(HtmlInputText COMP_MED_EXAM_CODE) {
		this.COMP_MED_EXAM_CODE = COMP_MED_EXAM_CODE;
	}

	public HtmlInputText getCOMP_UI_M_MED_EXAM_CODE_DESC() {
		return COMP_UI_M_MED_EXAM_CODE_DESC;
	}

	public void setCOMP_UI_M_MED_EXAM_CODE_DESC(HtmlInputText COMP_UI_M_MED_EXAM_CODE_DESC) {
		this.COMP_UI_M_MED_EXAM_CODE_DESC = COMP_UI_M_MED_EXAM_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EXAM_CODE_LOV() {
		return COMP_UI_M_BUT_EXAM_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_EXAM_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_EXAM_CODE_LOV) {
		this.COMP_UI_M_BUT_EXAM_CODE_LOV = COMP_UI_M_BUT_EXAM_CODE_LOV;
	}

	public PM_IL_MED_EXAM getPM_IL_MED_EXAM_BEAN() {
		return PM_IL_MED_EXAM_BEAN;
	}

	public void setPM_IL_MED_EXAM_BEAN(PM_IL_MED_EXAM PM_IL_MED_EXAM_BEAN) {
		this.PM_IL_MED_EXAM_BEAN = PM_IL_MED_EXAM_BEAN;
	}
}
