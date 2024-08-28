package com.iii.pel.forms.PILM013_APAC;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_NO_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DNS_FRZ_FLAG_LABEL;
	private HtmlOutputLabel COMP_DNS_FS_LABEL;
	private HtmlOutputLabel COMP_DNS_LEVEL_1_LABEL;
	private HtmlOutputLabel COMP_DNS_LEVEL_2_LABEL;
	private HtmlOutputLabel COMP_DNS_LEVEL_3_LABEL;
	private HtmlOutputLabel COMP_DNS_LEVEL_4_LABEL;
	private HtmlOutputLabel COMP_DNS_LEVEL_5_LABEL;
	private HtmlOutputLabel COMP_DNS_L1_ATTACH_YN_LABEL;
	private HtmlOutputLabel COMP_DNS_L2_ATTACH_YN_LABEL;
	private HtmlOutputLabel COMP_DNS_L3_ATTACH_YN_LABEL;
	private HtmlOutputLabel COMP_DNS_L4_ATTACH_YN_LABEL;
	private HtmlOutputLabel COMP_DNS_L5_ATTACH_YN_LABEL;
	private HtmlOutputLabel COMP_DNS_PREFIX_YN_LABEL;
	private HtmlOutputLabel COMP_DNS_PREFIX_LABEL;
	private HtmlOutputLabel COMP_DNS_PAD_YN_LABEL;
	private HtmlOutputLabel COMP_DNS_PAD_LENGTH_LABEL;
	private HtmlOutputLabel COMP_DNS_CHK_DIGIT_YN_LABEL;
	private HtmlOutputLabel COMP_DNS_YEAR_NUM_LABEL;
	private HtmlOutputLabel COMP_DNS_ATTACH_SEQ_LEVEL_LABEL;

	private HtmlSelectBooleanCheckbox COMP_DNS_FRZ_FLAG;

	private HtmlInputText COMP_DNS_FS;
	private HtmlInputText COMP_DNS_PREFIX;
	private HtmlInputText COMP_DNS_PAD_LENGTH;

	private HtmlSelectOneMenu COMP_DNS_LEVEL_1;
	private HtmlSelectOneMenu COMP_DNS_LEVEL_2;
	private HtmlSelectOneMenu COMP_DNS_LEVEL_3;
	private HtmlSelectOneMenu COMP_DNS_LEVEL_4;
	private HtmlSelectOneMenu COMP_DNS_LEVEL_5;
	private HtmlSelectOneMenu COMP_DNS_L1_ATTACH_YN;
	private HtmlSelectOneMenu COMP_DNS_L2_ATTACH_YN;
	private HtmlSelectOneMenu COMP_DNS_L3_ATTACH_YN;
	private HtmlSelectOneMenu COMP_DNS_L4_ATTACH_YN;
	private HtmlSelectOneMenu COMP_DNS_L5_ATTACH_YN;
	private HtmlSelectOneMenu COMP_DNS_PREFIX_YN;
	private HtmlSelectOneMenu COMP_DNS_PAD_YN;
	private HtmlSelectOneMenu COMP_DNS_CHK_DIGIT_YN;
	private HtmlSelectOneMenu COMP_DNS_YEAR_NUM;
	private HtmlSelectOneMenu COMP_DNS_ATTACH_SEQ_LEVEL;

	private PM_IL_DOC_NO_SETUP PM_IL_DOC_NO_SETUP_BEAN;

	private ArrayList<SelectItem> DNS_LEVEL_1_ARRAYLIST;
	private ArrayList<SelectItem> DNS_LEVEL_2_ARRAYLIST;
	private ArrayList<SelectItem> DNS_LEVEL_3_ARRAYLIST;
	private ArrayList<SelectItem> DNS_LEVEL_4_ARRAYLIST;
	private ArrayList<SelectItem> DNS_LEVEL_5_ARRAYLIST;
	private ArrayList<SelectItem> DNS_L1_ATTACH_YN_ARRAYLIST;
	private ArrayList<SelectItem> DNS_L2_ATTACH_YN_ARRAYLIST;
	private ArrayList<SelectItem> DNS_L3_ATTACH_YN_ARRAYLIST;
	private ArrayList<SelectItem> DNS_L4_ATTACH_YN_ARRAYLIST;
	private ArrayList<SelectItem> DNS_L5_ATTACH_YN_ARRAYLIST;
	private ArrayList<SelectItem> DNS_PREFIX_YN_ARRAYLIST;
	private ArrayList<SelectItem> DNS_PAD_YN_ARRAYLIST;
	private ArrayList<SelectItem> DNS_CHK_DIGIT_YN_ARRAYLIST;
	private ArrayList<SelectItem> DNS_YEAR_NUM_ARRAYLIST;
	private ArrayList<SelectItem> DNS_ATTACH_SEQ_LEVEL_ARRAYLIST;

	private String errorMessages;
	// private Map<String, String> errorMap = new HashMap<String, String>();

	private List level1CodeList;

	private PM_IL_DOC_NO_SETUP_DELEGATE pm_il_doc_no_setup_delegate;

	private CommonUtils commonUtils;

	private PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper;

	private ControlBean controlBean;
	
	public PM_IL_DOC_SETUP_COMPOSITE_ACTION compositeAction;
	
	public PM_IL_DOC_NO_SETUP_ACTION() {
		controlBean = new ControlBean();
		PM_IL_DOC_NO_SETUP_BEAN = new PM_IL_DOC_NO_SETUP();
		pm_il_doc_no_setup_delegate = new PM_IL_DOC_NO_SETUP_DELEGATE();
		pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		WHEN_CREATE_RECORD(PM_IL_DOC_NO_SETUP_BEAN);

		/* ComboBox Items */
		DNS_LEVEL_1_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_LEVEL_1);

		DNS_LEVEL_2_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_LEVEL_2);

		DNS_LEVEL_3_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_LEVEL_3);

		DNS_LEVEL_4_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_LEVEL_4);

		DNS_LEVEL_5_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_LEVEL_5);

		DNS_L1_ATTACH_YN_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_L1_ATTACH_YN);

		DNS_L2_ATTACH_YN_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_L2_ATTACH_YN);

		DNS_L3_ATTACH_YN_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_L3_ATTACH_YN);

		DNS_L4_ATTACH_YN_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_L4_ATTACH_YN);

		DNS_L5_ATTACH_YN_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_L5_ATTACH_YN);

		DNS_PREFIX_YN_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_PREFIX_YN);

		DNS_PAD_YN_ARRAYLIST = pm_il_doc_no_setup_delegate.fetchComboBoxValues(
				PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
				PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
				PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_PAD_YN);

		DNS_CHK_DIGIT_YN_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_CHK_DIGIT_YN);

		DNS_YEAR_NUM_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_YEAR_NUM);

		DNS_ATTACH_SEQ_LEVEL_ARRAYLIST = pm_il_doc_no_setup_delegate
				.fetchComboBoxValues(
						PM_IL_DOC_SETUP_CONSTANTS.FORM_PILM013_APAC,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DOC_NO,
						PM_IL_DOC_SETUP_CONSTANTS.PILM013_APAC$PM_IL_DOC_NO$DNS_ATTACH_SEQ_LEVEL);

	}

	public HtmlOutputLabel getCOMP_DNS_FRZ_FLAG_LABEL() {
		return COMP_DNS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_DNS_FRZ_FLAG() {
		return COMP_DNS_FRZ_FLAG;
	}

	public void setCOMP_DNS_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_DNS_FRZ_FLAG_LABEL) {
		this.COMP_DNS_FRZ_FLAG_LABEL = COMP_DNS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_DNS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_DNS_FRZ_FLAG) {
		this.COMP_DNS_FRZ_FLAG = COMP_DNS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_DNS_FS_LABEL() {
		return COMP_DNS_FS_LABEL;
	}

	public HtmlInputText getCOMP_DNS_FS() {
		return COMP_DNS_FS;
	}

	public void setCOMP_DNS_FS_LABEL(HtmlOutputLabel COMP_DNS_FS_LABEL) {
		this.COMP_DNS_FS_LABEL = COMP_DNS_FS_LABEL;
	}

	public void setCOMP_DNS_FS(HtmlInputText COMP_DNS_FS) {
		this.COMP_DNS_FS = COMP_DNS_FS;
	}

	public HtmlOutputLabel getCOMP_DNS_LEVEL_1_LABEL() {
		return COMP_DNS_LEVEL_1_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_LEVEL_1() {
		return COMP_DNS_LEVEL_1;
	}

	public void setCOMP_DNS_LEVEL_1_LABEL(HtmlOutputLabel COMP_DNS_LEVEL_1_LABEL) {
		this.COMP_DNS_LEVEL_1_LABEL = COMP_DNS_LEVEL_1_LABEL;
	}

	public void setCOMP_DNS_LEVEL_1(HtmlSelectOneMenu COMP_DNS_LEVEL_1) {
		this.COMP_DNS_LEVEL_1 = COMP_DNS_LEVEL_1;
	}

	public HtmlOutputLabel getCOMP_DNS_LEVEL_2_LABEL() {
		return COMP_DNS_LEVEL_2_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_LEVEL_2() {
		return COMP_DNS_LEVEL_2;
	}

	public void setCOMP_DNS_LEVEL_2_LABEL(HtmlOutputLabel COMP_DNS_LEVEL_2_LABEL) {
		this.COMP_DNS_LEVEL_2_LABEL = COMP_DNS_LEVEL_2_LABEL;
	}

	public void setCOMP_DNS_LEVEL_2(HtmlSelectOneMenu COMP_DNS_LEVEL_2) {
		this.COMP_DNS_LEVEL_2 = COMP_DNS_LEVEL_2;
	}

	public HtmlOutputLabel getCOMP_DNS_LEVEL_3_LABEL() {
		return COMP_DNS_LEVEL_3_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_LEVEL_3() {
		return COMP_DNS_LEVEL_3;
	}

	public void setCOMP_DNS_LEVEL_3_LABEL(HtmlOutputLabel COMP_DNS_LEVEL_3_LABEL) {
		this.COMP_DNS_LEVEL_3_LABEL = COMP_DNS_LEVEL_3_LABEL;
	}

	public void setCOMP_DNS_LEVEL_3(HtmlSelectOneMenu COMP_DNS_LEVEL_3) {
		this.COMP_DNS_LEVEL_3 = COMP_DNS_LEVEL_3;
	}

	public HtmlOutputLabel getCOMP_DNS_LEVEL_4_LABEL() {
		return COMP_DNS_LEVEL_4_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_LEVEL_4() {
		return COMP_DNS_LEVEL_4;
	}

	public void setCOMP_DNS_LEVEL_4_LABEL(HtmlOutputLabel COMP_DNS_LEVEL_4_LABEL) {
		this.COMP_DNS_LEVEL_4_LABEL = COMP_DNS_LEVEL_4_LABEL;
	}

	public void setCOMP_DNS_LEVEL_4(HtmlSelectOneMenu COMP_DNS_LEVEL_4) {
		this.COMP_DNS_LEVEL_4 = COMP_DNS_LEVEL_4;
	}

	public HtmlOutputLabel getCOMP_DNS_LEVEL_5_LABEL() {
		return COMP_DNS_LEVEL_5_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_LEVEL_5() {
		return COMP_DNS_LEVEL_5;
	}

	public void setCOMP_DNS_LEVEL_5_LABEL(HtmlOutputLabel COMP_DNS_LEVEL_5_LABEL) {
		this.COMP_DNS_LEVEL_5_LABEL = COMP_DNS_LEVEL_5_LABEL;
	}

	public void setCOMP_DNS_LEVEL_5(HtmlSelectOneMenu COMP_DNS_LEVEL_5) {
		this.COMP_DNS_LEVEL_5 = COMP_DNS_LEVEL_5;
	}

	public HtmlOutputLabel getCOMP_DNS_L1_ATTACH_YN_LABEL() {
		return COMP_DNS_L1_ATTACH_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_L1_ATTACH_YN() {
		return COMP_DNS_L1_ATTACH_YN;
	}

	public void setCOMP_DNS_L1_ATTACH_YN_LABEL(
			HtmlOutputLabel COMP_DNS_L1_ATTACH_YN_LABEL) {
		this.COMP_DNS_L1_ATTACH_YN_LABEL = COMP_DNS_L1_ATTACH_YN_LABEL;
	}

	public void setCOMP_DNS_L1_ATTACH_YN(HtmlSelectOneMenu COMP_DNS_L1_ATTACH_YN) {
		this.COMP_DNS_L1_ATTACH_YN = COMP_DNS_L1_ATTACH_YN;
	}

	public HtmlOutputLabel getCOMP_DNS_L2_ATTACH_YN_LABEL() {
		return COMP_DNS_L2_ATTACH_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_L2_ATTACH_YN() {
		return COMP_DNS_L2_ATTACH_YN;
	}

	public void setCOMP_DNS_L2_ATTACH_YN_LABEL(
			HtmlOutputLabel COMP_DNS_L2_ATTACH_YN_LABEL) {
		this.COMP_DNS_L2_ATTACH_YN_LABEL = COMP_DNS_L2_ATTACH_YN_LABEL;
	}

	public void setCOMP_DNS_L2_ATTACH_YN(HtmlSelectOneMenu COMP_DNS_L2_ATTACH_YN) {
		this.COMP_DNS_L2_ATTACH_YN = COMP_DNS_L2_ATTACH_YN;
	}

	public HtmlOutputLabel getCOMP_DNS_L3_ATTACH_YN_LABEL() {
		return COMP_DNS_L3_ATTACH_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_L3_ATTACH_YN() {
		return COMP_DNS_L3_ATTACH_YN;
	}

	public void setCOMP_DNS_L3_ATTACH_YN_LABEL(
			HtmlOutputLabel COMP_DNS_L3_ATTACH_YN_LABEL) {
		this.COMP_DNS_L3_ATTACH_YN_LABEL = COMP_DNS_L3_ATTACH_YN_LABEL;
	}

	public void setCOMP_DNS_L3_ATTACH_YN(HtmlSelectOneMenu COMP_DNS_L3_ATTACH_YN) {
		this.COMP_DNS_L3_ATTACH_YN = COMP_DNS_L3_ATTACH_YN;
	}

	public HtmlOutputLabel getCOMP_DNS_L4_ATTACH_YN_LABEL() {
		return COMP_DNS_L4_ATTACH_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_L4_ATTACH_YN() {
		return COMP_DNS_L4_ATTACH_YN;
	}

	public void setCOMP_DNS_L4_ATTACH_YN_LABEL(
			HtmlOutputLabel COMP_DNS_L4_ATTACH_YN_LABEL) {
		this.COMP_DNS_L4_ATTACH_YN_LABEL = COMP_DNS_L4_ATTACH_YN_LABEL;
	}

	public void setCOMP_DNS_L4_ATTACH_YN(HtmlSelectOneMenu COMP_DNS_L4_ATTACH_YN) {
		this.COMP_DNS_L4_ATTACH_YN = COMP_DNS_L4_ATTACH_YN;
	}

	public HtmlOutputLabel getCOMP_DNS_L5_ATTACH_YN_LABEL() {
		return COMP_DNS_L5_ATTACH_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_L5_ATTACH_YN() {
		return COMP_DNS_L5_ATTACH_YN;
	}

	public void setCOMP_DNS_L5_ATTACH_YN_LABEL(
			HtmlOutputLabel COMP_DNS_L5_ATTACH_YN_LABEL) {
		this.COMP_DNS_L5_ATTACH_YN_LABEL = COMP_DNS_L5_ATTACH_YN_LABEL;
	}

	public void setCOMP_DNS_L5_ATTACH_YN(HtmlSelectOneMenu COMP_DNS_L5_ATTACH_YN) {
		this.COMP_DNS_L5_ATTACH_YN = COMP_DNS_L5_ATTACH_YN;
	}

	public HtmlOutputLabel getCOMP_DNS_PREFIX_YN_LABEL() {
		return COMP_DNS_PREFIX_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_PREFIX_YN() {
		return COMP_DNS_PREFIX_YN;
	}

	public void setCOMP_DNS_PREFIX_YN_LABEL(
			HtmlOutputLabel COMP_DNS_PREFIX_YN_LABEL) {
		this.COMP_DNS_PREFIX_YN_LABEL = COMP_DNS_PREFIX_YN_LABEL;
	}

	public void setCOMP_DNS_PREFIX_YN(HtmlSelectOneMenu COMP_DNS_PREFIX_YN) {
		this.COMP_DNS_PREFIX_YN = COMP_DNS_PREFIX_YN;
	}

	public HtmlOutputLabel getCOMP_DNS_PREFIX_LABEL() {
		return COMP_DNS_PREFIX_LABEL;
	}

	public HtmlInputText getCOMP_DNS_PREFIX() {
		return COMP_DNS_PREFIX;
	}

	public void setCOMP_DNS_PREFIX_LABEL(HtmlOutputLabel COMP_DNS_PREFIX_LABEL) {
		this.COMP_DNS_PREFIX_LABEL = COMP_DNS_PREFIX_LABEL;
	}

	public void setCOMP_DNS_PREFIX(HtmlInputText COMP_DNS_PREFIX) {
		this.COMP_DNS_PREFIX = COMP_DNS_PREFIX;
	}

	public HtmlOutputLabel getCOMP_DNS_PAD_YN_LABEL() {
		return COMP_DNS_PAD_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_PAD_YN() {
		return COMP_DNS_PAD_YN;
	}

	public void setCOMP_DNS_PAD_YN_LABEL(HtmlOutputLabel COMP_DNS_PAD_YN_LABEL) {
		this.COMP_DNS_PAD_YN_LABEL = COMP_DNS_PAD_YN_LABEL;
	}

	public void setCOMP_DNS_PAD_YN(HtmlSelectOneMenu COMP_DNS_PAD_YN) {
		this.COMP_DNS_PAD_YN = COMP_DNS_PAD_YN;
	}

	public HtmlOutputLabel getCOMP_DNS_PAD_LENGTH_LABEL() {
		return COMP_DNS_PAD_LENGTH_LABEL;
	}

	public HtmlInputText getCOMP_DNS_PAD_LENGTH() {
		return COMP_DNS_PAD_LENGTH;
	}

	public void setCOMP_DNS_PAD_LENGTH_LABEL(
			HtmlOutputLabel COMP_DNS_PAD_LENGTH_LABEL) {
		this.COMP_DNS_PAD_LENGTH_LABEL = COMP_DNS_PAD_LENGTH_LABEL;
	}

	public void setCOMP_DNS_PAD_LENGTH(HtmlInputText COMP_DNS_PAD_LENGTH) {

		this.COMP_DNS_PAD_LENGTH = COMP_DNS_PAD_LENGTH;
	}

	public HtmlOutputLabel getCOMP_DNS_CHK_DIGIT_YN_LABEL() {
		return COMP_DNS_CHK_DIGIT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_CHK_DIGIT_YN() {
		return COMP_DNS_CHK_DIGIT_YN;
	}

	public void setCOMP_DNS_CHK_DIGIT_YN_LABEL(
			HtmlOutputLabel COMP_DNS_CHK_DIGIT_YN_LABEL) {
		this.COMP_DNS_CHK_DIGIT_YN_LABEL = COMP_DNS_CHK_DIGIT_YN_LABEL;
	}

	public void setCOMP_DNS_CHK_DIGIT_YN(HtmlSelectOneMenu COMP_DNS_CHK_DIGIT_YN) {
		this.COMP_DNS_CHK_DIGIT_YN = COMP_DNS_CHK_DIGIT_YN;
	}

	public HtmlOutputLabel getCOMP_DNS_YEAR_NUM_LABEL() {
		return COMP_DNS_YEAR_NUM_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_YEAR_NUM() {
		return COMP_DNS_YEAR_NUM;
	}

	public void setCOMP_DNS_YEAR_NUM_LABEL(
			HtmlOutputLabel COMP_DNS_YEAR_NUM_LABEL) {
		this.COMP_DNS_YEAR_NUM_LABEL = COMP_DNS_YEAR_NUM_LABEL;
	}

	public void setCOMP_DNS_YEAR_NUM(HtmlSelectOneMenu COMP_DNS_YEAR_NUM) {
		this.COMP_DNS_YEAR_NUM = COMP_DNS_YEAR_NUM;
	}

	public HtmlOutputLabel getCOMP_DNS_ATTACH_SEQ_LEVEL_LABEL() {
		return COMP_DNS_ATTACH_SEQ_LEVEL_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DNS_ATTACH_SEQ_LEVEL() {
		return COMP_DNS_ATTACH_SEQ_LEVEL;
	}

	public void setCOMP_DNS_ATTACH_SEQ_LEVEL_LABEL(
			HtmlOutputLabel COMP_DNS_ATTACH_SEQ_LEVEL_LABEL) {
		this.COMP_DNS_ATTACH_SEQ_LEVEL_LABEL = COMP_DNS_ATTACH_SEQ_LEVEL_LABEL;
	}

	public void setCOMP_DNS_ATTACH_SEQ_LEVEL(
			HtmlSelectOneMenu COMP_DNS_ATTACH_SEQ_LEVEL) {
		this.COMP_DNS_ATTACH_SEQ_LEVEL = COMP_DNS_ATTACH_SEQ_LEVEL;
	}

	public PM_IL_DOC_NO_SETUP getPM_IL_DOC_NO_SETUP_BEAN() {
		return PM_IL_DOC_NO_SETUP_BEAN;
	}

	public void setPM_IL_DOC_NO_SETUP_BEAN(
			PM_IL_DOC_NO_SETUP PM_IL_DOC_NO_SETUP_BEAN) {
		this.PM_IL_DOC_NO_SETUP_BEAN = PM_IL_DOC_NO_SETUP_BEAN;
	}

	public ArrayList<SelectItem> getDNS_LEVEL_1_ARRAYLIST() {
		return DNS_LEVEL_1_ARRAYLIST;
	}

	public void setDNS_LEVEL_1_ARRAYLIST(
			ArrayList<SelectItem> dns_level_1_arraylist) {
		DNS_LEVEL_1_ARRAYLIST = dns_level_1_arraylist;
	}

	public ArrayList<SelectItem> getDNS_LEVEL_2_ARRAYLIST() {
		return DNS_LEVEL_2_ARRAYLIST;
	}

	public void setDNS_LEVEL_2_ARRAYLIST(
			ArrayList<SelectItem> dns_level_2_arraylist) {
		DNS_LEVEL_2_ARRAYLIST = dns_level_2_arraylist;
	}

	public ArrayList<SelectItem> getDNS_LEVEL_3_ARRAYLIST() {
		return DNS_LEVEL_3_ARRAYLIST;
	}

	public void setDNS_LEVEL_3_ARRAYLIST(
			ArrayList<SelectItem> dns_level_3_arraylist) {
		DNS_LEVEL_3_ARRAYLIST = dns_level_3_arraylist;
	}

	public ArrayList<SelectItem> getDNS_LEVEL_4_ARRAYLIST() {
		return DNS_LEVEL_4_ARRAYLIST;
	}

	public void setDNS_LEVEL_4_ARRAYLIST(
			ArrayList<SelectItem> dns_level_4_arraylist) {
		DNS_LEVEL_4_ARRAYLIST = dns_level_4_arraylist;
	}

	public ArrayList<SelectItem> getDNS_LEVEL_5_ARRAYLIST() {
		return DNS_LEVEL_5_ARRAYLIST;
	}

	public void setDNS_LEVEL_5_ARRAYLIST(
			ArrayList<SelectItem> dns_level_5_arraylist) {
		DNS_LEVEL_5_ARRAYLIST = dns_level_5_arraylist;
	}

	public ArrayList<SelectItem> getDNS_L1_ATTACH_YN_ARRAYLIST() {
		return DNS_L1_ATTACH_YN_ARRAYLIST;
	}

	public void setDNS_L1_ATTACH_YN_ARRAYLIST(
			ArrayList<SelectItem> dns_l1_attach_yn_arraylist) {
		DNS_L1_ATTACH_YN_ARRAYLIST = dns_l1_attach_yn_arraylist;
	}

	public ArrayList<SelectItem> getDNS_L2_ATTACH_YN_ARRAYLIST() {
		return DNS_L2_ATTACH_YN_ARRAYLIST;
	}

	public void setDNS_L2_ATTACH_YN_ARRAYLIST(
			ArrayList<SelectItem> dns_l2_attach_yn_arraylist) {
		DNS_L2_ATTACH_YN_ARRAYLIST = dns_l2_attach_yn_arraylist;
	}

	public ArrayList<SelectItem> getDNS_L3_ATTACH_YN_ARRAYLIST() {
		return DNS_L3_ATTACH_YN_ARRAYLIST;
	}

	public void setDNS_L3_ATTACH_YN_ARRAYLIST(
			ArrayList<SelectItem> dns_l3_attach_yn_arraylist) {
		DNS_L3_ATTACH_YN_ARRAYLIST = dns_l3_attach_yn_arraylist;
	}

	public ArrayList<SelectItem> getDNS_L4_ATTACH_YN_ARRAYLIST() {
		return DNS_L4_ATTACH_YN_ARRAYLIST;
	}

	public void setDNS_L4_ATTACH_YN_ARRAYLIST(
			ArrayList<SelectItem> dns_l4_attach_yn_arraylist) {
		DNS_L4_ATTACH_YN_ARRAYLIST = dns_l4_attach_yn_arraylist;
	}

	public ArrayList<SelectItem> getDNS_L5_ATTACH_YN_ARRAYLIST() {
		return DNS_L5_ATTACH_YN_ARRAYLIST;
	}

	public void setDNS_L5_ATTACH_YN_ARRAYLIST(
			ArrayList<SelectItem> dns_l5_attach_yn_arraylist) {
		DNS_L5_ATTACH_YN_ARRAYLIST = dns_l5_attach_yn_arraylist;
	}

	public ArrayList<SelectItem> getDNS_PREFIX_YN_ARRAYLIST() {
		return DNS_PREFIX_YN_ARRAYLIST;
	}

	public void setDNS_PREFIX_YN_ARRAYLIST(
			ArrayList<SelectItem> dns_prefix_yn_arraylist) {
		DNS_PREFIX_YN_ARRAYLIST = dns_prefix_yn_arraylist;
	}

	public ArrayList<SelectItem> getDNS_PAD_YN_ARRAYLIST() {
		return DNS_PAD_YN_ARRAYLIST;
	}

	public void setDNS_PAD_YN_ARRAYLIST(
			ArrayList<SelectItem> dns_pad_yn_arraylist) {
		DNS_PAD_YN_ARRAYLIST = dns_pad_yn_arraylist;
	}

	public ArrayList<SelectItem> getDNS_CHK_DIGIT_YN_ARRAYLIST() {
		return DNS_CHK_DIGIT_YN_ARRAYLIST;
	}

	public void setDNS_CHK_DIGIT_YN_ARRAYLIST(
			ArrayList<SelectItem> dns_chk_digit_yn_arraylist) {
		DNS_CHK_DIGIT_YN_ARRAYLIST = dns_chk_digit_yn_arraylist;
	}

	public ArrayList<SelectItem> getDNS_YEAR_NUM_ARRAYLIST() {
		return DNS_YEAR_NUM_ARRAYLIST;
	}

	public void setDNS_YEAR_NUM_ARRAYLIST(
			ArrayList<SelectItem> dns_year_num_arraylist) {
		DNS_YEAR_NUM_ARRAYLIST = dns_year_num_arraylist;
	}

	public ArrayList<SelectItem> getDNS_ATTACH_SEQ_LEVEL_ARRAYLIST() {
		return DNS_ATTACH_SEQ_LEVEL_ARRAYLIST;
	}

	public void setDNS_ATTACH_SEQ_LEVEL_ARRAYLIST(
			ArrayList<SelectItem> dns_attach_seq_level_arraylist) {
		DNS_ATTACH_SEQ_LEVEL_ARRAYLIST = dns_attach_seq_level_arraylist;
	}

	/* Insert Action */

	public void insertData() {
		commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION compAction = null;
		compAction = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		PM_IL_DOC_SETUP pm_il_doc_setup = (PM_IL_DOC_SETUP) compAction
				.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN();
		int rowsUpdated = 0;
		try {
			PM_IL_DOC_NO_SETUP_BEAN.setDNS_CODE(pm_il_doc_setup.getDS_CODE());
			PM_IL_DOC_NO_SETUP_BEAN.setDNS_FRZ_FLAG("N");
			PM_IL_DOC_NO_SETUP_BEAN.setDNS_TYPE(pm_il_doc_setup.getDS_TYPE());
			if (PM_IL_DOC_NO_SETUP_BEAN.getROWID() == null) {
				PRE_INSERT(PM_IL_DOC_NO_SETUP_BEAN);
				rowsUpdated = pm_il_doc_no_setup_delegate
						.updateData(PM_IL_DOC_NO_SETUP_BEAN);
				if (rowsUpdated > 0) {
					//compAction.getTabbedBar().setTabEnabled(3);
					compAction.getWizard().enableWizardItemForId("2");
					/* Setting session values */
					FacesContext facesContext = FacesContext
							.getCurrentInstance();
					HttpServletRequest request = (HttpServletRequest) facesContext
							.getExternalContext().getRequest();
					HttpSession session = request.getSession();
					session.setAttribute("PM_IL_DOC_NO_SETUP_ACTION", this);

					if (rowsUpdated > 0) {
						/*
						 * getWarningMap().put("somekey", rowsUpdated+" record
						 * inserted."); getWarningMap().put("current",
						 * rowsUpdated+" record inserted.");
						 */
						getWarningMap().put(
								"current",
								Messages.getString(
										PELConstants.pelErrorMessagePath,
										"SAVE_MESSAGE"));
						getWarningMap().put(
								"somekey",
								Messages.getString(
										PELConstants.pelErrorMessagePath,
										"SAVE_MESSAGE"));
						// setFieldDisableProperty(true);
						PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
								.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
						/*pm_il_doc_setup_composite_action.getTabbedBar()
								.setTabEnabled(3);
								*/
						pm_il_doc_setup_composite_action.getWizard().enableWizardItemForId("2");
					}

				}
			} else {
				PRE_UPDATE(PM_IL_DOC_NO_SETUP_BEAN);
				rowsUpdated = pm_il_doc_no_setup_delegate
						.updateData(PM_IL_DOC_NO_SETUP_BEAN);
				if (rowsUpdated > 0) {
					getWarningMap().put("somekey",
							rowsUpdated + " record updated.");
					getWarningMap().put("current",
							rowsUpdated + " record updated.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			getWarningMap().put("update", rowsUpdated + " record NOT updated.");
			getWarningMap()
					.put("current", rowsUpdated + " record NOT updated.");
		}
	}

	public void setFieldDisableProperty(boolean flag) {
		COMP_DNS_ATTACH_SEQ_LEVEL.setDisabled(flag);
		COMP_DNS_CHK_DIGIT_YN.setDisabled(flag);
		COMP_DNS_FRZ_FLAG.setDisabled(flag);
		COMP_DNS_FS.setDisabled(flag);
		COMP_DNS_L1_ATTACH_YN.setDisabled(flag);
		COMP_DNS_L2_ATTACH_YN.setDisabled(flag);
		COMP_DNS_L3_ATTACH_YN.setDisabled(flag);
		COMP_DNS_L4_ATTACH_YN.setDisabled(flag);
		COMP_DNS_L5_ATTACH_YN.setDisabled(flag);
		COMP_DNS_LEVEL_1.setDisabled(flag);
		COMP_DNS_LEVEL_2.setDisabled(flag);
		COMP_DNS_LEVEL_3.setDisabled(flag);
		COMP_DNS_LEVEL_4.setDisabled(flag);
		COMP_DNS_LEVEL_5.setDisabled(flag);
		COMP_DNS_PAD_LENGTH.setDisabled(flag);
		COMP_DNS_PAD_YN.setDisabled(flag);
		COMP_DNS_PREFIX.setDisabled(flag);
		COMP_DNS_PREFIX_YN.setDisabled(flag);
		COMP_DNS_YEAR_NUM.setDisabled(flag);
	}

	public void setFieldProperty() {
		HtmlSelectOneMenu DNS_ATTACH_SEQ_LEVEL = new HtmlSelectOneMenu();
		//DNS_ATTACH_SEQ_LEVEL.setDisabled(true);
		setCOMP_DNS_ATTACH_SEQ_LEVEL(DNS_ATTACH_SEQ_LEVEL);

		HtmlSelectOneMenu DNS_CHK_DIGIT_YN = new HtmlSelectOneMenu();
		//DNS_CHK_DIGIT_YN.setDisabled(true);
		setCOMP_DNS_CHK_DIGIT_YN(DNS_CHK_DIGIT_YN);

		HtmlSelectBooleanCheckbox DNS_FRZ_FLAG = new HtmlSelectBooleanCheckbox();
		//DNS_FRZ_FLAG.setDisabled(true);
		setCOMP_DNS_FRZ_FLAG(DNS_FRZ_FLAG);

		HtmlSelectOneMenu DNS_L1_ATTACH_YN = new HtmlSelectOneMenu();
		//DNS_L1_ATTACH_YN.setDisabled(true);
		setCOMP_DNS_L1_ATTACH_YN(DNS_L1_ATTACH_YN);

		HtmlSelectOneMenu DNS_L2_ATTACH_YN = new HtmlSelectOneMenu();
		//DNS_L2_ATTACH_YN.setDisabled(true);
		setCOMP_DNS_L2_ATTACH_YN(DNS_L2_ATTACH_YN);

		HtmlSelectOneMenu DNS_L3_ATTACH_YN = new HtmlSelectOneMenu();
		//DNS_L3_ATTACH_YN.setDisabled(true);
		setCOMP_DNS_L3_ATTACH_YN(DNS_L3_ATTACH_YN);

		HtmlSelectOneMenu DNS_L4_ATTACH_YN = new HtmlSelectOneMenu();
		//DNS_L4_ATTACH_YN.setDisabled(true);
		setCOMP_DNS_L4_ATTACH_YN(DNS_L4_ATTACH_YN);

		HtmlSelectOneMenu DNS_L5_ATTACH_YN = new HtmlSelectOneMenu();
		//DNS_L5_ATTACH_YN.setDisabled(true);
		setCOMP_DNS_L5_ATTACH_YN(DNS_L5_ATTACH_YN);

		HtmlSelectOneMenu DNS_LEVEL_1 = new HtmlSelectOneMenu();
		//DNS_LEVEL_1.setDisabled(true);
		setCOMP_DNS_LEVEL_1(DNS_LEVEL_1);

		HtmlSelectOneMenu DNS_LEVEL_2 = new HtmlSelectOneMenu();
		//DNS_LEVEL_2.setDisabled(true);
		setCOMP_DNS_LEVEL_2(DNS_LEVEL_2);

		HtmlSelectOneMenu DNS_LEVEL_3 = new HtmlSelectOneMenu();
		//DNS_LEVEL_3.setDisabled(true);
		setCOMP_DNS_LEVEL_3(DNS_LEVEL_3);

		HtmlSelectOneMenu DNS_LEVEL_4 = new HtmlSelectOneMenu();
		//DNS_LEVEL_4.setDisabled(true);
		setCOMP_DNS_LEVEL_4(DNS_LEVEL_4);

		HtmlSelectOneMenu DNS_LEVEL_5 = new HtmlSelectOneMenu();
		//DNS_LEVEL_5.setDisabled(true);
		setCOMP_DNS_LEVEL_5(DNS_LEVEL_5);

		HtmlSelectOneMenu DNS_PAD_YN = new HtmlSelectOneMenu();
		//DNS_PAD_YN.setDisabled(true);
		setCOMP_DNS_PAD_YN(DNS_PAD_YN);

		HtmlSelectOneMenu DNS_PREFIX_YN = new HtmlSelectOneMenu();
		//DNS_PREFIX_YN.setDisabled(true);
		setCOMP_DNS_PREFIX_YN(DNS_PREFIX_YN);

		HtmlInputText DNS_PAD_LENGTH = new HtmlInputText();
		//DNS_PAD_LENGTH.setDisabled(true);
		setCOMP_DNS_PAD_LENGTH(DNS_PAD_LENGTH);

		HtmlInputText DNS_PREFIX = new HtmlInputText();
		//DNS_PREFIX.setDisabled(true);
		setCOMP_DNS_PREFIX(DNS_PREFIX);

		HtmlSelectOneMenu DNS_YEAR_NUM = new HtmlSelectOneMenu();
		//DNS_YEAR_NUM.setDisabled(true);
		setCOMP_DNS_YEAR_NUM(DNS_YEAR_NUM);

		HtmlInputText DNS_FS = new HtmlInputText();
		//DNS_FS.setDisabled(true);
		setCOMP_DNS_FS(DNS_FS);
	}

	public void deleteData() {
		int deletedRows = pm_il_doc_no_setup_delegate
				.deleteData(PM_IL_DOC_NO_SETUP_BEAN);
		if (deletedRows > 0) {
			getWarningMap().put("update", deletedRows + " record deleted.");
			getWarningMap().put("current", deletedRows + " record deleted.");
			clearRecord();
			PM_IL_DOC_NO_SETUP_BEAN.setDeletedStatus(true);
		} else {
			PM_IL_DOC_NO_SETUP_BEAN.setDeletedStatus(false);
		}
	}

	public void clearRecord() {
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_1("000");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_2("000");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_3("000");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_4("000");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_5("000");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_PREFIX("");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_PAD_LENGTH(0);
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_FS("");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_L1_ATTACH_YN("N");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_L2_ATTACH_YN("N");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_L3_ATTACH_YN("N");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_L4_ATTACH_YN("N");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_L5_ATTACH_YN("N");
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_ATTACH_SEQ_LEVEL("000");

	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	/*
	 * public Map<String, String> getErrorMap() { return errorMap; }
	 * 
	 * public void setErrorMap(Map<String, String> errorMap) { this.errorMap =
	 * errorMap; }
	 * 
	 * public String getErrorMessages() { String messageList; if ((errorMap ==
	 * null) || (errorMap.size() == 0)) { messageList = ""; } else { Map<String,
	 * String> error = new HashMap<String, String>(); error.putAll(errorMap);
	 * error.remove("current"); messageList = "<FONT SIZE=2><UL>\n"; for
	 * (String message : error.values()) {
	 * 
	 * messageList = messageList + "<LI>" + message + "\n"; } messageList =
	 * messageList + "</UL></FONT>\n"; }
	 * 
	 * return messageList; }
	 */

	
	/* Commented and Modified by Janani on 03.05.2018 as suggested by Sivaram for endorsement setup issue*/
	
/*	public void validateDNS_LEVEL_1(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_LEVEL_1_STRING = (String) inputText.getSubmittedValue();
		System.out.println("LEVEL 1 VALUES: " + DNS_LEVEL_1_STRING);
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_1(DNS_LEVEL_1_STRING);
		pm_il_doc_no_setup_helper.DNS_LEVEL_1_WHEN_LIST_CHANGED(
				DNS_LEVEL_1_STRING, this);
		pm_il_doc_no_setup_helper.DNS_LEVEL_1_WHEN_VALIDATE_ITEM(
				DNS_LEVEL_1_STRING, this);
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		// pm_il_doc_setup_composite_action.getTabbedBar().setTabEnabled(3);

	}*/
	
	public void validateDNS_LEVEL_1(FacesContext fc, UIComponent component,
			Object value) {
	
		try
		{
			
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_LEVEL_1_STRING = (String) inputText.getSubmittedValue();
		System.out.println("LEVEL 1 VALUES: " + DNS_LEVEL_1_STRING);
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_1(DNS_LEVEL_1_STRING);
		pm_il_doc_no_setup_helper.DNS_LEVEL_1_WHEN_LIST_CHANGED(
				DNS_LEVEL_1_STRING, this);
		pm_il_doc_no_setup_helper.DNS_LEVEL_1_WHEN_VALIDATE_ITEM(
				DNS_LEVEL_1_STRING, this);
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		
		System.out.println("getDNS_TYPE              "+PM_IL_DOC_NO_SETUP_BEAN.getDNS_TYPE()+"     getDNS_LEVEL_1       "+PM_IL_DOC_NO_SETUP_BEAN.getDNS_LEVEL_1());
		/*  Commented by Janani on 16.05.2018 as suggested SIvaram for Fidelity
		if(!PM_IL_DOC_NO_SETUP_BEAN.getDNS_TYPE().equalsIgnoreCase("3") && PM_IL_DOC_NO_SETUP_BEAN.getDNS_LEVEL_1().equalsIgnoreCase("012"))
		{
			throw new Exception("Endorsement code is valid only for Type Endorsement");
		}*/
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	
	/*End*/

	public void validateDNS_LEVEL_2(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_LEVEL_2_STRING = (String) inputText.getSubmittedValue();
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_2(DNS_LEVEL_2_STRING);
		pm_il_doc_no_setup_helper.DNS_LEVEL_2_WHEN_LIST_CHANGED(
				DNS_LEVEL_2_STRING, this);
		pm_il_doc_no_setup_helper.DNS_LEVEL_2_WHEN_VALIDATE_ITEM(
				DNS_LEVEL_2_STRING, this);

	}

	public void validateDNS_LEVEL_3(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_LEVEL_3_STRING = (String) inputText.getSubmittedValue();
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_3(DNS_LEVEL_3_STRING);
		pm_il_doc_no_setup_helper.DNS_LEVEL_3_WHEN_LIST_CHANGED(
				DNS_LEVEL_3_STRING, this);
		pm_il_doc_no_setup_helper.DNS_LEVEL_3_WHEN_VALIDATE_ITEM(
				DNS_LEVEL_3_STRING, this);
	}

	public void validateDNS_LEVEL_4(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_LEVEL_4_STRING = (String) inputText.getSubmittedValue();
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_4(DNS_LEVEL_4_STRING);
		pm_il_doc_no_setup_helper.DNS_LEVEL_4_WHEN_LIST_CHANGED(
				DNS_LEVEL_4_STRING, this);
		pm_il_doc_no_setup_helper.DNS_LEVEL_4_WHEN_VALIDATE_ITEM(
				DNS_LEVEL_4_STRING, this);
	}

	public void validateDNS_LEVEL_5(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_LEVEL_5_STRING = (String) inputText.getSubmittedValue();
		PM_IL_DOC_NO_SETUP_BEAN.setDNS_LEVEL_5(DNS_LEVEL_5_STRING);
		pm_il_doc_no_setup_helper.DNS_LEVEL_5_WHEN_LIST_CHANGED(
				DNS_LEVEL_5_STRING, this);
		pm_il_doc_no_setup_helper.DNS_LEVEL_5_WHEN_VALIDATE_ITEM(
				DNS_LEVEL_5_STRING, this);
	}

	public void validateDNS_L1_ATTACH_YN(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		pm_il_doc_no_setup_helper.DNS_L1_ATTACH_YN_WHEN_LIST_CHANGED(this);

	}

	public void validateDNS_L2_ATTACH_YN(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_L2_ATTACH_YN_STRING = (String) inputText.getSubmittedValue();
		pm_il_doc_no_setup_helper.DNS_L2_ATTACH_YN_WHEN_LIST_CHANGED(
				DNS_L2_ATTACH_YN_STRING, this);
	}

	public void validateDNS_L3_ATTACH_YN(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_L3_ATTACH_YN_STRING = (String) inputText.getSubmittedValue();
		pm_il_doc_no_setup_helper.DNS_L3_ATTACH_YN_WHEN_LIST_CHANGED(
				DNS_L3_ATTACH_YN_STRING, this);
	}

	public void validateDNS_PREFIX_YN(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_PREFIX_YN_STRING = (String) inputText.getSubmittedValue();
		System.out.println(DNS_PREFIX_YN_STRING);
		pm_il_doc_no_setup_helper.DNS_PREFIX_YN_WHEN_VALIDATE_ITEM(
				DNS_PREFIX_YN_STRING, this);
		// pm_il_doc_no_setup_helper.DNS_PREFIX_YN_WHEN_LIST_CHANGE(DNS_PREFIX_YN_STRING,
		// this);
	}

	public void validateDNS_PAD_YN(ActionEvent actionEvent) {
		PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) actionEvent.getComponent().getParent();
		String DNS_PAD_YN_STRING = (String) inputText.getSubmittedValue();
		System.out.println(DNS_PAD_YN_STRING);
		pm_il_doc_no_setup_helper.DNS_PAD_YN_WHEN_VALIDATE_ITEM(
				DNS_PAD_YN_STRING, this);
		// pm_il_doc_no_setup_helper.DNS_PAD_YN_WHEN_LIST_CHANGE(DNS_PAD_YN_STRING,
		// this);
	}

	public void validateDNS_PAD_LENGTH(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		// PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper = new
		// PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_PAD_LENGTH_STRING = (String) inputText.getSubmittedValue();
		System.out.println(DNS_PAD_LENGTH_STRING);
		Double DNS_PAD_LENGTH_DOUBLE = Double
				.parseDouble(DNS_PAD_LENGTH_STRING);
		if ("Y".equalsIgnoreCase(PM_IL_DOC_NO_SETUP_BEAN.getDNS_PAD_YN())) {
			if (DNS_PAD_LENGTH_DOUBLE < 1 || DNS_PAD_LENGTH_DOUBLE > 99) {
				throw new ValidatorException(Messages.getMessage(
						"messageProperties_PILM013_APAC",
						"PILM013_APAC$PM_IL_DOC_SETUP$VALUE_NOT_IN_RANGE"));
			}
		}

		// pm_il_doc_no_setup_helper.DNS_PAD_YN_WHEN_VALIDATE_ITEM(DNS_PAD_YN_STRING,
		// this);
		// pm_il_doc_no_setup_helper.DNS_PAD_YN_WHEN_LIST_CHANGE(DNS_PAD_YN_STRING,
		// this);
	}

	
	 /*Commented and modified by Janani on 16.05.2018 for validating seq level */
	
/*	public void validateDNS_ATTACH_SEQ_LEVEL(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException {
		pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_ATTACH_SEQ_LEVEL_STRING = (String) inputText
				.getSubmittedValue();
		// pm_il_doc_no_setup_helper.DNS_ATTACH_SEQ_LEVEL_WHEN_NEW_ITEM_INSTANCE(DNS_ATTACH_SEQ_LEVEL_STRING,
		// this);
		pm_il_doc_no_setup_helper.DNS_ATTACH_SEQ_LEVEL_WHEN_LIST_CHANGED(
				DNS_ATTACH_SEQ_LEVEL_STRING, this);
	}*/
	
	
	public void validateDNS_ATTACH_SEQ_LEVEL(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			System.out.println("inside validateDNS_ATTACH_SEQ_LEVEL");
		pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		UIInput inputText = (UIInput) component;
		String DNS_ATTACH_SEQ_LEVEL_STRING = (String) inputText
				.getSubmittedValue();
		// pm_il_doc_no_setup_helper.DNS_ATTACH_SEQ_LEVEL_WHEN_NEW_ITEM_INSTANCE(DNS_ATTACH_SEQ_LEVEL_STRING,
		// this);
		pm_il_doc_no_setup_helper.DNS_ATTACH_SEQ_LEVEL_WHEN_LIST_CHANGED(
				DNS_ATTACH_SEQ_LEVEL_STRING, this);
		
		
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
	}
	}
	
/*End*/

	public void validateDNS_ATTACH_SEQ_LEVEL_WHEN_NEW_ITEM_INSTANCE(
			ActionEvent actionEvent) {
		pm_il_doc_no_setup_helper = new PM_IL_DOC_NO_SETUP_HELPER();
		pm_il_doc_no_setup_helper
				.DNS_ATTACH_SEQ_LEVEL_WHEN_NEW_ITEM_INSTANCE(this);
	}

	public void setErrorMessagesInMap(ActionEvent event) {
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}

	public PM_IL_DOC_NO_SETUP_DELEGATE getPm_il_doc_no_setup_delegate() {
		return pm_il_doc_no_setup_delegate;
	}

	public void setPm_il_doc_no_setup_delegate(
			PM_IL_DOC_NO_SETUP_DELEGATE pm_il_doc_no_setup_delegate) {
		this.pm_il_doc_no_setup_delegate = pm_il_doc_no_setup_delegate;
	}

	public PM_IL_DOC_NO_SETUP_HELPER getPm_il_doc_no_setup_helper() {
		return pm_il_doc_no_setup_helper;
	}

	public void setPm_il_doc_no_setup_helper(
			PM_IL_DOC_NO_SETUP_HELPER pm_il_doc_no_setup_helper) {
		this.pm_il_doc_no_setup_helper = pm_il_doc_no_setup_helper;
	}

	public void PRE_BLOCK() {
		controlBean.setM_DELETE_MSG_FLAG("N");
	}

	public void POST_BLOCK(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup,
			PM_IL_DOC_NO_RANGE pm_il_doc_no_range) {
		if (pm_il_doc_no_setup.getDNS_LEVEL_1().trim() != "000"
				&& pm_il_doc_no_setup.getDNS_L1_ATTACH_YN().trim() != "Y") {
			/*
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_1",ENABLED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_1",UPDATE_ALLOWED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_1",INSERT_ALLOWED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_1",NAVIGABLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.M_LOV_DNR_LEVEL_1",ENABLED,PROPERTY_TRUE);
			 */
		}
		if (pm_il_doc_no_setup.getDNS_LEVEL_2().trim() != "000"
				&& pm_il_doc_no_setup.getDNS_L2_ATTACH_YN().trim() != "Y") {
			/*
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_2",ENABLED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_2",UPDATE_ALLOWED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_2",INSERT_ALLOWED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_2",NAVIGABLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.M_LOV_DNR_LEVEL_2",ENABLED,PROPERTY_TRUE);
			 */
		}
		if (pm_il_doc_no_setup.getDNS_LEVEL_3().trim() != "000"
				&& pm_il_doc_no_setup.getDNS_L3_ATTACH_YN().trim() != "Y") {
			/*
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_3",ENABLED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_3",UPDATE_ALLOWED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_3",INSERT_ALLOWED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_3",NAVIGABLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.M_LOV_DNR_LEVEL_3",ENABLED,PROPERTY_TRUE);
			 */
		}
		if (pm_il_doc_no_setup.getDNS_LEVEL_4().trim() != "000"
				&& pm_il_doc_no_setup.getDNS_L4_ATTACH_YN().trim() != "Y") {
			/*
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_4",ENABLED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_4",UPDATE_ALLOWED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_4",INSERT_ALLOWED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_4",NAVIGABLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.M_LOV_DNR_LEVEL_4",ENABLED,PROPERTY_TRUE);
			 */
		}
		if (pm_il_doc_no_setup.getDNS_LEVEL_5().trim() != "000"
				&& pm_il_doc_no_setup.getDNS_L5_ATTACH_YN().trim() != "Y") {
			/*
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_5",ENABLED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_5",UPDATE_ALLOWED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_5",INSERT_ALLOWED,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.DNR_LEVEL_5",NAVIGABLE,PROPERTY_TRUE);
			 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_DOC_NO_RANGE.M_LOV_DNR_LEVEL_5",ENABLED,PROPERTY_TRUE);
			 */
		}
	}

	public void PRE_INSERT(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup) {

		pm_il_doc_no_setup.setDNS_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		// TODO needs to get from control bean
		pm_il_doc_no_setup.setDNS_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		if (pm_il_doc_no_setup.getDNS_PAD_YN().equals("N")) {
			pm_il_doc_no_setup.setDNS_PAD_LENGTH(0);
		}
	}

	public void PRE_UPDATE(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup) {
		pm_il_doc_no_setup.setDNS_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		// TODO needs to get from control bean
		pm_il_doc_no_setup.setDNS_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		if (pm_il_doc_no_setup.getDNS_PAD_YN().equals("N")) {
			pm_il_doc_no_setup.setDNS_PAD_LENGTH(0);
		}
	}

	public void WHEN_CREATE_RECORD(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup) {
		pm_il_doc_no_setup.setDNS_ATTACH_SEQ_LEVEL("N");
		pm_il_doc_no_setup.setDNS_LEVEL_1("000");
		pm_il_doc_no_setup.setDNS_LEVEL_2("000");
		pm_il_doc_no_setup.setDNS_LEVEL_3("000");
		pm_il_doc_no_setup.setDNS_LEVEL_4("000");
		pm_il_doc_no_setup.setDNS_LEVEL_5("000");
		pm_il_doc_no_setup.setDNS_L1_ATTACH_YN("N");
		if (COMP_DNS_L1_ATTACH_YN == null) {
			COMP_DNS_L1_ATTACH_YN = new HtmlSelectOneMenu();
		}
		COMP_DNS_L1_ATTACH_YN.setDisabled(true);
		pm_il_doc_no_setup.setDNS_L2_ATTACH_YN("N");
		pm_il_doc_no_setup.setDNS_L3_ATTACH_YN("N");
		pm_il_doc_no_setup.setDNS_L4_ATTACH_YN("N");
		pm_il_doc_no_setup.setDNS_L5_ATTACH_YN("N");
		pm_il_doc_no_setup.setDNS_PREFIX_YN("N");
		pm_il_doc_no_setup.setDNS_PAD_YN("N");
		pm_il_doc_no_setup.setDNS_CHK_DIGIT_YN("N");
		pm_il_doc_no_setup.setDNS_YEAR_NUM("4");
		pm_il_doc_no_setup.setDNS_ATTACH_SEQ_LEVEL("005");
		HtmlInputText PREFIX = new HtmlInputText();
		PREFIX.setDisabled(true);
		setCOMP_DNS_PREFIX(PREFIX);

		HtmlInputText PADDING_LENGTH = new HtmlInputText();
		PADDING_LENGTH.setSubmittedValue(null);
		PADDING_LENGTH.setDisabled(true);
		setCOMP_DNS_PAD_LENGTH(PADDING_LENGTH);

	}

	public void WHEN_NEW_BLOCK_INSTANCE() {
		new CommonUtils().getControlBean().setM_COMM_DEL("P");
	}

	public void WHEN_NEW_RECORD_INSTANCE(PM_IL_DOC_NO_SETUP pm_il_doc_no_setup) {

		/*
		 * :GLOBAL.DNS_LEVEL_1=:PM_IL_DOC_NO_SETUP.DNS_LEVEL_1;
		 * :GLOBAL.DNS_LEVEL_2=:PM_IL_DOC_NO_SETUP.DNS_LEVEL_2;
		 * :GLOBAL.DNS_LEVEL_3=:PM_IL_DOC_NO_SETUP.DNS_LEVEL_3;
		 * :GLOBAL.DNS_LEVEL_4=:PM_IL_DOC_NO_SETUP.DNS_LEVEL_4;
		 * :GLOBAL.DNS_LEVEL_5=:PM_IL_DOC_NO_SETUP.DNS_LEVEL_5;
		 */
		if (pm_il_doc_no_setup.getROWID() == null) {
			pm_il_doc_no_setup.setDNS_LEVEL_1("000");
			pm_il_doc_no_setup.setDNS_LEVEL_2("000");
			pm_il_doc_no_setup.setDNS_LEVEL_3("000");
			pm_il_doc_no_setup.setDNS_LEVEL_4("000");
			pm_il_doc_no_setup.setDNS_LEVEL_5("000");
			pm_il_doc_no_setup.setDNS_L1_ATTACH_YN("N");
			pm_il_doc_no_setup.setDNS_L2_ATTACH_YN("N");
			pm_il_doc_no_setup.setDNS_L3_ATTACH_YN("N");
			pm_il_doc_no_setup.setDNS_L4_ATTACH_YN("N");
			pm_il_doc_no_setup.setDNS_L5_ATTACH_YN("N");
		} else {
			// L_SELECT_BP_VALUES.L_SELECT_BP_VALUES();
		}
	}

	/**
	 * Implementation of Tool Bar Functionalities.
	 */
	/*public String saveNextAction() {
		insertData();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String value = pm_il_doc_setup_composite_action
				.callDocumentNumberRange();
		pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
		pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(3);
		return value;
	}

	public String nextIconAction() {
		if (getPM_IL_DOC_NO_SETUP_BEAN().getROWID() == null
				&& !getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()
						.equalsIgnoreCase("000")) {
			insertData();
		}
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String value = pm_il_doc_setup_composite_action
				.callDocumentNumberRange();
		pm_il_doc_setup_composite_action.getTabbedBar().gotoNextTab();
		pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(3);
		return value;
	}

	public String lastIconAction() {
		if (getPM_IL_DOC_NO_SETUP_BEAN().getROWID() == null
				&& !getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()
						.equalsIgnoreCase("000")) {
			insertData();
		}
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String value = pm_il_doc_setup_composite_action.callDocumentReminder();
		pm_il_doc_setup_composite_action.getTabbedBar().gotoLastTab();
		pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(7);
		return value;
	}

	public String firstIconAction() {
		if (getPM_IL_DOC_NO_SETUP_BEAN().getROWID() == null
				&& !getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()
						.equalsIgnoreCase("000")) {
			insertData();
		}
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String value = pm_il_doc_setup_composite_action.callDocumentSetup();
		pm_il_doc_setup_composite_action.getTabbedBar().gotoFirstTab();
		pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(1);
		return value;
	}

	public String previousIconAction() {
		if (getPM_IL_DOC_NO_SETUP_BEAN().getROWID() == null
				&& !getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()
						.equalsIgnoreCase("000")) {
			insertData();
		}
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String value = pm_il_doc_setup_composite_action.callDocumentSetup();
		pm_il_doc_setup_composite_action.getTabbedBar().gotoPrevTab();
		pm_il_doc_setup_composite_action.getTabbedBar().setTabClicked(1);
		return value;
	}*/
	
	public void disableDocumentLevels() {

		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		PM_IL_DOC_NO_RANGE_ACTION pm_il_doc_no_range_action = pm_il_doc_setup_composite_action
				.getPM_IL_DOC_NO_RANGE_ACTION_BEAN();

		if (!PM_IL_DOC_NO_SETUP_BEAN.getDNS_LEVEL_1().equalsIgnoreCase("000")
				&& PM_IL_DOC_NO_SETUP_BEAN.getDNS_L1_ATTACH_YN()
						.equalsIgnoreCase("Y")) {
            System.out.println("level 1");
			HtmlInputText COMP_DNR_LEVEL_1 = new HtmlInputText();
			COMP_DNR_LEVEL_1.setDisabled(true);
			pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_1(COMP_DNR_LEVEL_1);
		} else if (!PM_IL_DOC_NO_SETUP_BEAN.getDNS_LEVEL_2().equalsIgnoreCase(
				"000")
				&& PM_IL_DOC_NO_SETUP_BEAN.getDNS_L2_ATTACH_YN()
						.equalsIgnoreCase("Y")) {
			HtmlInputText COMP_DNR_LEVEL_2 = new HtmlInputText();
			COMP_DNR_LEVEL_2.setDisabled(true);
			pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_2(COMP_DNR_LEVEL_2);
			System.out.println("level 2");
			
		} else if (!PM_IL_DOC_NO_SETUP_BEAN.getDNS_LEVEL_3().equalsIgnoreCase(
				"000")
				&& PM_IL_DOC_NO_SETUP_BEAN.getDNS_L3_ATTACH_YN()
						.equalsIgnoreCase("Y")) {
			HtmlInputText COMP_DNR_LEVEL_3 = new HtmlInputText();
			COMP_DNR_LEVEL_3.setDisabled(true);
			pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_3(COMP_DNR_LEVEL_3);
			System.out.println("level 3");
		} else if (!PM_IL_DOC_NO_SETUP_BEAN.getDNS_LEVEL_4().equalsIgnoreCase(
				"000")
				&& PM_IL_DOC_NO_SETUP_BEAN.getDNS_L4_ATTACH_YN()
						.equalsIgnoreCase("Y")) {
			HtmlInputText COMP_DNR_LEVEL_4 = new HtmlInputText();
			COMP_DNR_LEVEL_4.setDisabled(true);
			pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_4(COMP_DNR_LEVEL_4);
			System.out.println("level 4");
		} else if (!PM_IL_DOC_NO_SETUP_BEAN.getDNS_LEVEL_5().equalsIgnoreCase(
				"000")
				&& PM_IL_DOC_NO_SETUP_BEAN.getDNS_L5_ATTACH_YN()
						.equalsIgnoreCase("Y")) {
			HtmlInputText COMP_DNR_LEVEL_5 = new HtmlInputText();
			COMP_DNR_LEVEL_5.setDisabled(true);
			pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_1(COMP_DNR_LEVEL_5);
			System.out.println("level 5");
		}
		/*else{
			HtmlInputText COMP_DNR_LEVEL_1 = new HtmlInputText();
			COMP_DNR_LEVEL_1.setDisabled(false);
			pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_1(COMP_DNR_LEVEL_1);
			
			HtmlInputText COMP_DNR_LEVEL_2 = new HtmlInputText();
			COMP_DNR_LEVEL_2.setDisabled(false);
			pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_2(COMP_DNR_LEVEL_2);
		
			HtmlInputText COMP_DNR_LEVEL_3 = new HtmlInputText();
			COMP_DNR_LEVEL_3.setDisabled(false);
			pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_3(COMP_DNR_LEVEL_3);
		
			HtmlInputText COMP_DNR_LEVEL_4 = new HtmlInputText();
			COMP_DNR_LEVEL_4.setDisabled(false);
			pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_4(COMP_DNR_LEVEL_4);
			
			HtmlInputText COMP_DNR_LEVEL_5 = new HtmlInputText();
			COMP_DNR_LEVEL_5.setDisabled(false);
			pm_il_doc_no_range_action.setCOMP_DNR_LEVEL_1(COMP_DNR_LEVEL_5);
		}*/
	}
}
