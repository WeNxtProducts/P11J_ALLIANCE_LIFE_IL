package com.iii.pel.forms.PM079_A;

import java.sql.Connection;
import java.util.ArrayList;
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
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_WAKALAH_DAILY_ACC_SETUP_ACTION extends CommonAction {

	private PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN;

	public PM079_A_COMPOSITE_ACTION compositeAction;

	private PM_WAKALAH_DAILY_ACC_SETUP_HELPER helper;
	
	private HtmlOutputLabel COMP_WAKD_ACC_FRZ_FLAG_LABEL;
	
	private HtmlSelectBooleanCheckbox COMP_WAKD_ACC_FRZ_FLAG;
	

	private HtmlOutputLabel COMP_WAKD_ACC_DIVN_FM_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_DIVN_FM_CODE;
	
	private HtmlOutputLabel COMP_WAKD_ACC_DIVN_TO_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_DIVN_TO_CODE;
	
	private HtmlOutputLabel COMP_WAKD_ACC_DEPT_FM_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_DEPT_FM_CODE;
	
	private HtmlOutputLabel COMP_WAKD_ACC_DEPT_TO_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_DEPT_TO_CODE;

	private HtmlOutputLabel	COMP_WAKD_ACC_CLASS_FM_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_CLASS_FM_CODE;
	
	private HtmlOutputLabel	COMP_WAKD_ACC_CLASS_TO_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_CLASS_TO_CODE;
	
	private HtmlOutputLabel COMP_WAKD_ACC_SC_FM_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_SC_FM_CODE;
	
	private HtmlOutputLabel COMP_WAKD_ACC_SC_TO_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_SC_TO_CODE;
	
	private HtmlOutputLabel COMP_WAKD_ACC_COVER_FM_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_COVER_FM_CODE;
	
	private HtmlOutputLabel COMP_WAKD_ACC_COVER_TO_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_COVER_TO_CODE;
	
	private HtmlOutputLabel COMP_WAKD_ACC_SRC_BUS_FM_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_SRC_BUS_FM;
	 
	private HtmlOutputLabel COMP_WAKD_ACC_SRC_BUS_TO_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_SRC_BUS_TO;
	 
	private HtmlOutputLabel COMP_WAKD_ACC_DOC_FM_TYPE_LABEL;
	 
	private HtmlInputText COMP_WAKD_ACC_DOC_FM_TYPE;
	
	private HtmlOutputLabel COMP_WAKD_ACC_DOC_TO_TYPE_LABEL;
	 
	private HtmlInputText COMP_WAKD_ACC_DOC_TO_TYPE;
	
	private HtmlOutputLabel COMP_WAKD_COVER_YRS_FM_LABEL;
	
	private HtmlInputText COMP_WAKD_COVER_YRS_FM;
	
	private HtmlOutputLabel COMP_WAKD_COVER_YRS_TO_LABEL;
	
	private HtmlInputText COMP_WAKD_COVER_YRS_TO;
	
	private HtmlOutputLabel COMP_WAKD_ACC_ALY_FM_1_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_ALY_FM_1;
	
	private HtmlOutputLabel COMP_WAKD_ACC_ALY_TO_1_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_ALY_TO_1;
	
	private HtmlOutputLabel COMP_WAKD_ACC_ALY_FM_2_LABEL; 
	
	private HtmlInputText COMP_WAKD_ACC_ALY_FM_2;
	
	private HtmlOutputLabel COMP_WAKD_ACC_ALY_TO_2_LABEL; 
	
	private HtmlInputText COMP_WAKD_ACC_ALY_TO_2;
	
	private HtmlOutputLabel COMP_WAKD_ACC_SETUP_LABEL;
	
	private HtmlSelectOneMenu COMP_WAKD_ACC_SETUP;
	
	private HtmlOutputLabel COMP_WAKD_ACC_FORCE_DIVN_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_WAKD_ACC_FORCE_DIVN_YN;
	
	private HtmlOutputLabel COMP_WAKD_ACC_FORCE_DEPT_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_WAKD_ACC_FORCE_DEPT_YN;
	
	private HtmlOutputLabel COMP_WAKD_ACC_DA_MO_DRIP_LABEL;
	
	private HtmlSelectOneMenu COMP_WAKD_ACC_DA_MO_DRIP;
	
	private HtmlOutputLabel COMP_WAKD_ACC_SEQ_NO_LABEL;

	private HtmlSelectOneMenu COMP_WAKD_ACC_SEQ_NO;

	private HtmlOutputLabel COMP_WAKD_ACC_MODULE_LABEL;
	
	private HtmlSelectOneMenu COMP_WAKD_ACC_MODULE;
	
	private HtmlOutputLabel COMP_WAKD_ACC_MAIN_ACNT_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_MAIN_ACNT_CODE;
	
	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;
	
	private HtmlOutputLabel COMP_WAKD_ACC_SUB_ACNT_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_SUB_ACNT_CODE;
	
	private HtmlInputText COMP_UI_M_SUB_ACNT_NAME;
	
	private HtmlOutputLabel COMP_WAKD_ACC_DIVN_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_DIVN_CODE;
	
	private HtmlInputText COMP_UI_M_DIVN_NAME;
	
	private HtmlOutputLabel COMP_WAKD_ACC_DEPT_CODE_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_DEPT_CODE;
	
	private HtmlInputText COMP_UI_M_DEPT_NAME;
	
	private HtmlOutputLabel COMP_WAKD_ACC_ANLY_CODE_1_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_ANLY_CODE_1;
	
	private HtmlInputText COMP_UI_M_ANLY_NAME;
	
	private HtmlOutputLabel COMP_WAKD_ACC_ANLY_CODE_2_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_ANLY_CODE_2;
	
	private HtmlInputText COMP_UI_M_ANLY_NAME_1;
	
	private HtmlOutputLabel COMP_WAKD_ACC_ACTY_CODE_1_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_ACTY_CODE_1;
	
	private HtmlInputText COMP_UI_M_ACTY_NAME;
	
	private HtmlOutputLabel COMP_WAKD_ACC_ACTY_CODE_2_LABEL;
	
	private HtmlInputText COMP_WAKD_ACC_ACTY_CODE_2;
	
	private HtmlInputText COMP_UI_M_ACTY_NAME_1;
	
	
	private List<SelectItem> listWAKD_ACC_SEQ_NO = new ArrayList<SelectItem>(); 
	
	private List<SelectItem> listWAKD_ACC_MODULE = new ArrayList<SelectItem>();
	
	private List<SelectItem> listWAKD_ACC_SETUP	 = new ArrayList<SelectItem>();
	
	private List<SelectItem> listWAKD_ACC_FORCE_DIVN_YN = new ArrayList<SelectItem>();
	
	private List<SelectItem> listWAKD_ACC_FORCE_DEPT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listWAKD_ACC_DA_MO_DRIP = new ArrayList<SelectItem>();


	public static final String z_Constant = "zzzzzzzzzz";
	public static final Integer int_Constant = 9999;
	
	
	public HtmlSelectOneMenu getCOMP_WAKD_ACC_SEQ_NO() {
		return COMP_WAKD_ACC_SEQ_NO;
	}

	public void setCOMP_WAKD_ACC_SEQ_NO(HtmlSelectOneMenu comp_wakd_acc_seq_no) {
		COMP_WAKD_ACC_SEQ_NO = comp_wakd_acc_seq_no;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_FRZ_FLAG_LABEL() {
		return COMP_WAKD_ACC_FRZ_FLAG_LABEL;
	}

	public void setCOMP_WAKD_ACC_FRZ_FLAG_LABEL(
			HtmlOutputLabel comp_wakd_acc_frz_flag_label) {
		COMP_WAKD_ACC_FRZ_FLAG_LABEL = comp_wakd_acc_frz_flag_label;
	}

	public HtmlSelectBooleanCheckbox getCOMP_WAKD_ACC_FRZ_FLAG() {
		return COMP_WAKD_ACC_FRZ_FLAG;
	}

	public void setCOMP_WAKD_ACC_FRZ_FLAG(
			HtmlSelectBooleanCheckbox comp_wakd_acc_frz_flag) {
		COMP_WAKD_ACC_FRZ_FLAG = comp_wakd_acc_frz_flag;
	}

	public HtmlSelectOneMenu getCOMP_WAKD_ACC_MODULE() {
		return COMP_WAKD_ACC_MODULE;
	}

	public void setCOMP_WAKD_ACC_MODULE(HtmlSelectOneMenu comp_wakd_acc_module) {
		COMP_WAKD_ACC_MODULE = comp_wakd_acc_module;
	}

	public PM_WAKALAH_DAILY_ACC_SETUP_ACTION() {
		
		PM_WAKALAH_DAILY_ACC_SETUP_BEAN = new PM_WAKALAH_DAILY_ACC_SETUP();
		helper = new PM_WAKALAH_DAILY_ACC_SETUP_HELPER();
		prepareDropDowns();
	}

	public void prepareDropDowns(){
		try {
			Connection connection = CommonUtils.getConnection();
			setListWAKD_ACC_MODULE(ListItemUtil.getDropDownListValue_1(
					connection, "PM079_A", "PM_WAKALAH_DAILY_ACC_SETUP",
					"PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_MODULE", null));
			setListWAKD_ACC_SEQ_NO(ListItemUtil.getDropDownListValue_1(
					connection, "PM079_A", "PM_WAKALAH_DAILY_ACC_SETUP",
					"PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_SEQ_NO", null));
			setListWAKD_ACC_SETUP(ListItemUtil.getDropDownListValue_1(
					connection, "PM079_A", "PM_WAKALAH_DAILY_ACC_SETUP",
					"PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_SETUP", null));
			setListWAKD_ACC_FORCE_DIVN_YN(ListItemUtil.getDropDownListValue_1(
					connection, "PM079_A", "PM_WAKALAH_DAILY_ACC_SETUP",
					"PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_FORCE_DIVN_YN", null));
			setListWAKD_ACC_FORCE_DEPT_YN(ListItemUtil.getDropDownListValue_1(
					connection, "PM079_A", "PM_WAKALAH_DAILY_ACC_SETUP",
					"PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_FORCE_DEPT_YN", null));
			setListWAKD_ACC_DA_MO_DRIP(ListItemUtil.getDropDownListValue_1(
					connection, "PM079_A", "PM_WAKALAH_DAILY_ACC_SETUP",
					"PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_DA_MO_DRIP", null));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PM_WAKALAH_DAILY_ACC_SETUP getPM_WAKALAH_DAILY_ACC_SETUP_BEAN() {
		return PM_WAKALAH_DAILY_ACC_SETUP_BEAN;
	}

	public void setPM_WAKALAH_DAILY_ACC_SETUP_BEAN(
			PM_WAKALAH_DAILY_ACC_SETUP PM_WAKALAH_DAILY_ACC_SETUP_BEAN) {
		this.PM_WAKALAH_DAILY_ACC_SETUP_BEAN = PM_WAKALAH_DAILY_ACC_SETUP_BEAN;
	}

	public PM079_A_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PM079_A_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PM_WAKALAH_DAILY_ACC_SETUP_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_WAKALAH_DAILY_ACC_SETUP_HELPER helper) {
		this.helper = helper;
	}

	public List<SelectItem> getListWAKD_ACC_SEQ_NO() {
		return listWAKD_ACC_SEQ_NO;
	}

	public void setListWAKD_ACC_SEQ_NO(List<SelectItem> listWAKD_ACC_SEQ_NO) {
		this.listWAKD_ACC_SEQ_NO = listWAKD_ACC_SEQ_NO;
	}

	public List<SelectItem> getListWAKD_ACC_MODULE() {
		return listWAKD_ACC_MODULE;
	}

	public void setListWAKD_ACC_MODULE(List<SelectItem> listWAKD_ACC_MODULE) {
		this.listWAKD_ACC_MODULE = listWAKD_ACC_MODULE;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_SEQ_NO_LABEL() {
		return COMP_WAKD_ACC_SEQ_NO_LABEL;
	}

	public void setCOMP_WAKD_ACC_SEQ_NO_LABEL(
			HtmlOutputLabel comp_wakd_acc_seq_no_label) {
		COMP_WAKD_ACC_SEQ_NO_LABEL = comp_wakd_acc_seq_no_label;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_MODULE_LABEL() {
		return COMP_WAKD_ACC_MODULE_LABEL;
	}

	public void setCOMP_WAKD_ACC_MODULE_LABEL(
			HtmlOutputLabel comp_wakd_acc_module_label) {
		COMP_WAKD_ACC_MODULE_LABEL = comp_wakd_acc_module_label;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_DIVN_FM_CODE_LABEL() {
		return COMP_WAKD_ACC_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_DIVN_FM_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_divn_fm_code_label) {
		COMP_WAKD_ACC_DIVN_FM_CODE_LABEL = comp_wakd_acc_divn_fm_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_DIVN_FM_CODE() {
		return COMP_WAKD_ACC_DIVN_FM_CODE;
	}

	public void setCOMP_WAKD_ACC_DIVN_FM_CODE(
			HtmlInputText comp_wakd_acc_divn_fm_code) {
		COMP_WAKD_ACC_DIVN_FM_CODE = comp_wakd_acc_divn_fm_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_DIVN_TO_CODE_LABEL() {
		return COMP_WAKD_ACC_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_DIVN_TO_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_divn_to_code_label) {
		COMP_WAKD_ACC_DIVN_TO_CODE_LABEL = comp_wakd_acc_divn_to_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_DIVN_TO_CODE() {
		return COMP_WAKD_ACC_DIVN_TO_CODE;
	}

	public void setCOMP_WAKD_ACC_DIVN_TO_CODE(
			HtmlInputText comp_wakd_acc_divn_to_code) {
		COMP_WAKD_ACC_DIVN_TO_CODE = comp_wakd_acc_divn_to_code;
	}

	
	public HtmlOutputLabel getCOMP_WAKD_ACC_DEPT_FM_CODE_LABEL() {
		return COMP_WAKD_ACC_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_DEPT_FM_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_dept_fm_code_label) {
		COMP_WAKD_ACC_DEPT_FM_CODE_LABEL = comp_wakd_acc_dept_fm_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_DEPT_FM_CODE() {
		return COMP_WAKD_ACC_DEPT_FM_CODE;
	}

	public void setCOMP_WAKD_ACC_DEPT_FM_CODE(
			HtmlInputText comp_wakd_acc_dept_fm_code) {
		COMP_WAKD_ACC_DEPT_FM_CODE = comp_wakd_acc_dept_fm_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_DEPT_TO_CODE_LABEL() {
		return COMP_WAKD_ACC_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_DEPT_TO_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_dept_to_code_label) {
		COMP_WAKD_ACC_DEPT_TO_CODE_LABEL = comp_wakd_acc_dept_to_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_DEPT_TO_CODE() {
		return COMP_WAKD_ACC_DEPT_TO_CODE;
	}

	public void setCOMP_WAKD_ACC_DEPT_TO_CODE(
			HtmlInputText comp_wakd_acc_dept_to_code) {
		COMP_WAKD_ACC_DEPT_TO_CODE = comp_wakd_acc_dept_to_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_CLASS_FM_CODE_LABEL() {
		return COMP_WAKD_ACC_CLASS_FM_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_CLASS_FM_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_class_fm_code_label) {
		COMP_WAKD_ACC_CLASS_FM_CODE_LABEL = comp_wakd_acc_class_fm_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_CLASS_FM_CODE() {
		return COMP_WAKD_ACC_CLASS_FM_CODE;
	}

	public void setCOMP_WAKD_ACC_CLASS_FM_CODE(
			HtmlInputText comp_wakd_acc_class_fm_code) {
		COMP_WAKD_ACC_CLASS_FM_CODE = comp_wakd_acc_class_fm_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_CLASS_TO_CODE_LABEL() {
		return COMP_WAKD_ACC_CLASS_TO_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_CLASS_TO_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_class_to_code_label) {
		COMP_WAKD_ACC_CLASS_TO_CODE_LABEL = comp_wakd_acc_class_to_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_CLASS_TO_CODE() {
		return COMP_WAKD_ACC_CLASS_TO_CODE;
	}

	public void setCOMP_WAKD_ACC_CLASS_TO_CODE(
			HtmlInputText comp_wakd_acc_class_to_code) {
		COMP_WAKD_ACC_CLASS_TO_CODE = comp_wakd_acc_class_to_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_SC_FM_CODE_LABEL() {
		return COMP_WAKD_ACC_SC_FM_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_SC_FM_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_sc_fm_code_label) {
		COMP_WAKD_ACC_SC_FM_CODE_LABEL = comp_wakd_acc_sc_fm_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_SC_FM_CODE() {
		return COMP_WAKD_ACC_SC_FM_CODE;
	}

	public void setCOMP_WAKD_ACC_SC_FM_CODE(HtmlInputText comp_wakd_acc_sc_fm_code) {
		COMP_WAKD_ACC_SC_FM_CODE = comp_wakd_acc_sc_fm_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_SC_TO_CODE_LABEL() {
		return COMP_WAKD_ACC_SC_TO_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_SC_TO_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_sc_to_code_label) {
		COMP_WAKD_ACC_SC_TO_CODE_LABEL = comp_wakd_acc_sc_to_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_SC_TO_CODE() {
		return COMP_WAKD_ACC_SC_TO_CODE;
	}

	public void setCOMP_WAKD_ACC_SC_TO_CODE(HtmlInputText comp_wakd_acc_sc_to_code) {
		COMP_WAKD_ACC_SC_TO_CODE = comp_wakd_acc_sc_to_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_COVER_FM_CODE_LABEL() {
		return COMP_WAKD_ACC_COVER_FM_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_COVER_FM_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_cover_fm_code_label) {
		COMP_WAKD_ACC_COVER_FM_CODE_LABEL = comp_wakd_acc_cover_fm_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_COVER_FM_CODE() {
		return COMP_WAKD_ACC_COVER_FM_CODE;
	}

	public void setCOMP_WAKD_ACC_COVER_FM_CODE(
			HtmlInputText comp_wakd_acc_cover_fm_code) {
		COMP_WAKD_ACC_COVER_FM_CODE = comp_wakd_acc_cover_fm_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_COVER_TO_CODE_LABEL() {
		return COMP_WAKD_ACC_COVER_TO_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_COVER_TO_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_cover_to_code_label) {
		COMP_WAKD_ACC_COVER_TO_CODE_LABEL = comp_wakd_acc_cover_to_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_COVER_TO_CODE() {
		return COMP_WAKD_ACC_COVER_TO_CODE;
	}

	public void setCOMP_WAKD_ACC_COVER_TO_CODE(
			HtmlInputText comp_wakd_acc_cover_to_code) {
		COMP_WAKD_ACC_COVER_TO_CODE = comp_wakd_acc_cover_to_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_SRC_BUS_FM_LABEL() {
		return COMP_WAKD_ACC_SRC_BUS_FM_LABEL;
	}

	public void setCOMP_WAKD_ACC_SRC_BUS_FM_LABEL(
			HtmlOutputLabel comp_wakd_acc_src_bus_fm_label) {
		COMP_WAKD_ACC_SRC_BUS_FM_LABEL = comp_wakd_acc_src_bus_fm_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_SRC_BUS_FM() {
		return COMP_WAKD_ACC_SRC_BUS_FM;
	}

	public void setCOMP_WAKD_ACC_SRC_BUS_FM(HtmlInputText comp_wakd_acc_src_bus_fm) {
		COMP_WAKD_ACC_SRC_BUS_FM = comp_wakd_acc_src_bus_fm;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_SRC_BUS_TO_LABEL() {
		return COMP_WAKD_ACC_SRC_BUS_TO_LABEL;
	}

	public void setCOMP_WAKD_ACC_SRC_BUS_TO_LABEL(
			HtmlOutputLabel comp_wakd_acc_src_bus_to_label) {
		COMP_WAKD_ACC_SRC_BUS_TO_LABEL = comp_wakd_acc_src_bus_to_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_SRC_BUS_TO() {
		return COMP_WAKD_ACC_SRC_BUS_TO;
	}

	public void setCOMP_WAKD_ACC_SRC_BUS_TO(HtmlInputText comp_wakd_acc_src_bus_to) {
		COMP_WAKD_ACC_SRC_BUS_TO = comp_wakd_acc_src_bus_to;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_DOC_FM_TYPE_LABEL() {
		return COMP_WAKD_ACC_DOC_FM_TYPE_LABEL;
	}

	public void setCOMP_WAKD_ACC_DOC_FM_TYPE_LABEL(
			HtmlOutputLabel comp_wakd_acc_doc_fm_type_label) {
		COMP_WAKD_ACC_DOC_FM_TYPE_LABEL = comp_wakd_acc_doc_fm_type_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_DOC_FM_TYPE() {
		return COMP_WAKD_ACC_DOC_FM_TYPE;
	}

	public void setCOMP_WAKD_ACC_DOC_FM_TYPE(HtmlInputText comp_wakd_acc_doc_fm_type) {
		COMP_WAKD_ACC_DOC_FM_TYPE = comp_wakd_acc_doc_fm_type;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_DOC_TO_TYPE_LABEL() {
		return COMP_WAKD_ACC_DOC_TO_TYPE_LABEL;
	}

	public void setCOMP_WAKD_ACC_DOC_TO_TYPE_LABEL(
			HtmlOutputLabel comp_wakd_acc_doc_to_type_label) {
		COMP_WAKD_ACC_DOC_TO_TYPE_LABEL = comp_wakd_acc_doc_to_type_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_DOC_TO_TYPE() {
		return COMP_WAKD_ACC_DOC_TO_TYPE;
	}

	public void setCOMP_WAKD_ACC_DOC_TO_TYPE(HtmlInputText comp_wakd_acc_doc_to_type) {
		COMP_WAKD_ACC_DOC_TO_TYPE = comp_wakd_acc_doc_to_type;
	}

	public HtmlOutputLabel getCOMP_WAKD_COVER_YRS_FM_LABEL() {
		return COMP_WAKD_COVER_YRS_FM_LABEL;
	}

	public void setCOMP_WAKD_COVER_YRS_FM_LABEL(
			HtmlOutputLabel comp_wakd_cover_yrs_fm_label) {
		COMP_WAKD_COVER_YRS_FM_LABEL = comp_wakd_cover_yrs_fm_label;
	}

	public HtmlInputText getCOMP_WAKD_COVER_YRS_FM() {
		return COMP_WAKD_COVER_YRS_FM;
	}

	public void setCOMP_WAKD_COVER_YRS_FM(HtmlInputText comp_wakd_cover_yrs_fm) {
		COMP_WAKD_COVER_YRS_FM = comp_wakd_cover_yrs_fm;
	}

	public HtmlOutputLabel getCOMP_WAKD_COVER_YRS_TO_LABEL() {
		return COMP_WAKD_COVER_YRS_TO_LABEL;
	}

	public void setCOMP_WAKD_COVER_YRS_TO_LABEL(
			HtmlOutputLabel comp_wakd_cover_yrs_to_label) {
		COMP_WAKD_COVER_YRS_TO_LABEL = comp_wakd_cover_yrs_to_label;
	}

	public HtmlInputText getCOMP_WAKD_COVER_YRS_TO() {
		return COMP_WAKD_COVER_YRS_TO;
	}

	public void setCOMP_WAKD_COVER_YRS_TO(HtmlInputText comp_wakd_cover_yrs_to) {
		COMP_WAKD_COVER_YRS_TO = comp_wakd_cover_yrs_to;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_ALY_FM_1_LABEL() {
		return COMP_WAKD_ACC_ALY_FM_1_LABEL;
	}

	public void setCOMP_WAKD_ACC_ALY_FM_1_LABEL(
			HtmlOutputLabel comp_wakd_acc_aly_fm_1_label) {
		COMP_WAKD_ACC_ALY_FM_1_LABEL = comp_wakd_acc_aly_fm_1_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_ALY_FM_1() {
		return COMP_WAKD_ACC_ALY_FM_1;
	}

	public void setCOMP_WAKD_ACC_ALY_FM_1(HtmlInputText comp_wakd_acc_aly_fm_1) {
		COMP_WAKD_ACC_ALY_FM_1 = comp_wakd_acc_aly_fm_1;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_ALY_TO_1_LABEL() {
		return COMP_WAKD_ACC_ALY_TO_1_LABEL;
	}

	public void setCOMP_WAKD_ACC_ALY_TO_1_LABEL(
			HtmlOutputLabel comp_wakd_acc_aly_to_1_label) {
		COMP_WAKD_ACC_ALY_TO_1_LABEL = comp_wakd_acc_aly_to_1_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_ALY_TO_1() {
		return COMP_WAKD_ACC_ALY_TO_1;
	}

	public void setCOMP_WAKD_ACC_ALY_TO_1(HtmlInputText comp_wakd_acc_aly_to_1) {
		COMP_WAKD_ACC_ALY_TO_1 = comp_wakd_acc_aly_to_1;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_ALY_FM_2_LABEL() {
		return COMP_WAKD_ACC_ALY_FM_2_LABEL;
	}

	public void setCOMP_WAKD_ACC_ALY_FM_2_LABEL(
			HtmlOutputLabel comp_wakd_acc_aly_fm_2_label) {
		COMP_WAKD_ACC_ALY_FM_2_LABEL = comp_wakd_acc_aly_fm_2_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_ALY_FM_2() {
		return COMP_WAKD_ACC_ALY_FM_2;
	}

	public void setCOMP_WAKD_ACC_ALY_FM_2(HtmlInputText comp_wakd_acc_aly_fm_2) {
		COMP_WAKD_ACC_ALY_FM_2 = comp_wakd_acc_aly_fm_2;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_ALY_TO_2_LABEL() {
		return COMP_WAKD_ACC_ALY_TO_2_LABEL;
	}

	public void setCOMP_WAKD_ACC_ALY_TO_2_LABEL(
			HtmlOutputLabel comp_wakd_acc_aly_to_2_label) {
		COMP_WAKD_ACC_ALY_TO_2_LABEL = comp_wakd_acc_aly_to_2_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_ALY_TO_2() {
		return COMP_WAKD_ACC_ALY_TO_2;
	}

	public void setCOMP_WAKD_ACC_ALY_TO_2(HtmlInputText comp_wakd_acc_aly_to_2) {
		COMP_WAKD_ACC_ALY_TO_2 = comp_wakd_acc_aly_to_2;
	}


	public HtmlOutputLabel getCOMP_WAKD_ACC_SETUP_LABEL() {
		return COMP_WAKD_ACC_SETUP_LABEL;
	}

	public void setCOMP_WAKD_ACC_SETUP_LABEL(
			HtmlOutputLabel comp_wakd_acc_setup_label) {
		COMP_WAKD_ACC_SETUP_LABEL = comp_wakd_acc_setup_label;
	}

	public HtmlSelectOneMenu getCOMP_WAKD_ACC_SETUP() {
		return COMP_WAKD_ACC_SETUP;
	}

	public void setCOMP_WAKD_ACC_SETUP(HtmlSelectOneMenu comp_wakd_acc_setup) {
		COMP_WAKD_ACC_SETUP = comp_wakd_acc_setup;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_FORCE_DIVN_YN_LABEL() {
		return COMP_WAKD_ACC_FORCE_DIVN_YN_LABEL;
	}

	public void setCOMP_WAKD_ACC_FORCE_DIVN_YN_LABEL(
			HtmlOutputLabel comp_wakd_acc_force_divn_yn_label) {
		COMP_WAKD_ACC_FORCE_DIVN_YN_LABEL = comp_wakd_acc_force_divn_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_WAKD_ACC_FORCE_DIVN_YN() {
		return COMP_WAKD_ACC_FORCE_DIVN_YN;
	}

	public void setCOMP_WAKD_ACC_FORCE_DIVN_YN(
			HtmlSelectOneMenu comp_wakd_acc_force_divn_yn) {
		COMP_WAKD_ACC_FORCE_DIVN_YN = comp_wakd_acc_force_divn_yn;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_FORCE_DEPT_YN_LABEL() {
		return COMP_WAKD_ACC_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_WAKD_ACC_FORCE_DEPT_YN_LABEL(
			HtmlOutputLabel comp_wakd_acc_force_dept_yn_label) {
		COMP_WAKD_ACC_FORCE_DEPT_YN_LABEL = comp_wakd_acc_force_dept_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_WAKD_ACC_FORCE_DEPT_YN() {
		return COMP_WAKD_ACC_FORCE_DEPT_YN;
	}

	public void setCOMP_WAKD_ACC_FORCE_DEPT_YN(
			HtmlSelectOneMenu comp_wakd_acc_force_dept_yn) {
		COMP_WAKD_ACC_FORCE_DEPT_YN = comp_wakd_acc_force_dept_yn;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_DA_MO_DRIP_LABEL() {
		return COMP_WAKD_ACC_DA_MO_DRIP_LABEL;
	}

	public void setCOMP_WAKD_ACC_DA_MO_DRIP_LABEL(
			HtmlOutputLabel comp_wakd_acc_da_mo_drip_label) {
		COMP_WAKD_ACC_DA_MO_DRIP_LABEL = comp_wakd_acc_da_mo_drip_label;
	}

	public HtmlSelectOneMenu getCOMP_WAKD_ACC_DA_MO_DRIP() {
		return COMP_WAKD_ACC_DA_MO_DRIP;
	}

	public void setCOMP_WAKD_ACC_DA_MO_DRIP(
			HtmlSelectOneMenu comp_wakd_acc_da_mo_drip) {
		COMP_WAKD_ACC_DA_MO_DRIP = comp_wakd_acc_da_mo_drip;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_MAIN_ACNT_CODE_LABEL() {
		return COMP_WAKD_ACC_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_MAIN_ACNT_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_main_acnt_code_label) {
		COMP_WAKD_ACC_MAIN_ACNT_CODE_LABEL = comp_wakd_acc_main_acnt_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_MAIN_ACNT_CODE() {
		return COMP_WAKD_ACC_MAIN_ACNT_CODE;
	}

	public void setCOMP_WAKD_ACC_MAIN_ACNT_CODE(
			HtmlInputText comp_wakd_acc_main_acnt_code) {
		COMP_WAKD_ACC_MAIN_ACNT_CODE = comp_wakd_acc_main_acnt_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_SUB_ACNT_CODE_LABEL() {
		return COMP_WAKD_ACC_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_SUB_ACNT_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_sub_acnt_code_label) {
		COMP_WAKD_ACC_SUB_ACNT_CODE_LABEL = comp_wakd_acc_sub_acnt_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_SUB_ACNT_CODE() {
		return COMP_WAKD_ACC_SUB_ACNT_CODE;
	}

	public void setCOMP_WAKD_ACC_SUB_ACNT_CODE(
			HtmlInputText comp_wakd_acc_sub_acnt_code) {
		COMP_WAKD_ACC_SUB_ACNT_CODE = comp_wakd_acc_sub_acnt_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_DIVN_CODE_LABEL() {
		return COMP_WAKD_ACC_DIVN_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_DIVN_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_divn_code_label) {
		COMP_WAKD_ACC_DIVN_CODE_LABEL = comp_wakd_acc_divn_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_DIVN_CODE() {
		return COMP_WAKD_ACC_DIVN_CODE;
	}

	public void setCOMP_WAKD_ACC_DIVN_CODE(HtmlInputText comp_wakd_acc_divn_code) {
		COMP_WAKD_ACC_DIVN_CODE = comp_wakd_acc_divn_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_DEPT_CODE_LABEL() {
		return COMP_WAKD_ACC_DEPT_CODE_LABEL;
	}

	public void setCOMP_WAKD_ACC_DEPT_CODE_LABEL(
			HtmlOutputLabel comp_wakd_acc_dept_code_label) {
		COMP_WAKD_ACC_DEPT_CODE_LABEL = comp_wakd_acc_dept_code_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_DEPT_CODE() {
		return COMP_WAKD_ACC_DEPT_CODE;
	}

	public void setCOMP_WAKD_ACC_DEPT_CODE(HtmlInputText comp_wakd_acc_dept_code) {
		COMP_WAKD_ACC_DEPT_CODE = comp_wakd_acc_dept_code;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_ANLY_CODE_1_LABEL() {
		return COMP_WAKD_ACC_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_WAKD_ACC_ANLY_CODE_1_LABEL(
			HtmlOutputLabel comp_wakd_acc_anly_code_1_label) {
		COMP_WAKD_ACC_ANLY_CODE_1_LABEL = comp_wakd_acc_anly_code_1_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_ANLY_CODE_1() {
		return COMP_WAKD_ACC_ANLY_CODE_1;
	}

	public void setCOMP_WAKD_ACC_ANLY_CODE_1(HtmlInputText comp_wakd_acc_anly_code_1) {
		COMP_WAKD_ACC_ANLY_CODE_1 = comp_wakd_acc_anly_code_1;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_ANLY_CODE_2_LABEL() {
		return COMP_WAKD_ACC_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_WAKD_ACC_ANLY_CODE_2_LABEL(
			HtmlOutputLabel comp_wakd_acc_anly_code_2_label) {
		COMP_WAKD_ACC_ANLY_CODE_2_LABEL = comp_wakd_acc_anly_code_2_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_ANLY_CODE_2() {
		return COMP_WAKD_ACC_ANLY_CODE_2;
	}

	public void setCOMP_WAKD_ACC_ANLY_CODE_2(HtmlInputText comp_wakd_acc_anly_code_2) {
		COMP_WAKD_ACC_ANLY_CODE_2 = comp_wakd_acc_anly_code_2;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_ACTY_CODE_1_LABEL() {
		return COMP_WAKD_ACC_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_WAKD_ACC_ACTY_CODE_1_LABEL(
			HtmlOutputLabel comp_wakd_acc_acty_code_1_label) {
		COMP_WAKD_ACC_ACTY_CODE_1_LABEL = comp_wakd_acc_acty_code_1_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_ACTY_CODE_1() {
		return COMP_WAKD_ACC_ACTY_CODE_1;
	}

	public void setCOMP_WAKD_ACC_ACTY_CODE_1(HtmlInputText comp_wakd_acc_acty_code_1) {
		COMP_WAKD_ACC_ACTY_CODE_1 = comp_wakd_acc_acty_code_1;
	}

	public HtmlOutputLabel getCOMP_WAKD_ACC_ACTY_CODE_2_LABEL() {
		return COMP_WAKD_ACC_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_WAKD_ACC_ACTY_CODE_2_LABEL(
			HtmlOutputLabel comp_wakd_acc_acty_code_2_label) {
		COMP_WAKD_ACC_ACTY_CODE_2_LABEL = comp_wakd_acc_acty_code_2_label;
	}

	public HtmlInputText getCOMP_WAKD_ACC_ACTY_CODE_2() {
		return COMP_WAKD_ACC_ACTY_CODE_2;
	}

	public void setCOMP_WAKD_ACC_ACTY_CODE_2(HtmlInputText comp_wakd_acc_acty_code_2) {
		COMP_WAKD_ACC_ACTY_CODE_2 = comp_wakd_acc_acty_code_2;
	}
	
	

	public List<SelectItem> getListWAKD_ACC_SETUP() {
		return listWAKD_ACC_SETUP;
	}

	public void setListWAKD_ACC_SETUP(List<SelectItem> listWAKD_ACC_SETUP) {
		this.listWAKD_ACC_SETUP = listWAKD_ACC_SETUP;
	}

	public List<SelectItem> getListWAKD_ACC_FORCE_DIVN_YN() {
		return listWAKD_ACC_FORCE_DIVN_YN;
	}

	public void setListWAKD_ACC_FORCE_DIVN_YN(
			List<SelectItem> listWAKD_ACC_FORCE_DIVN_YN) {
		this.listWAKD_ACC_FORCE_DIVN_YN = listWAKD_ACC_FORCE_DIVN_YN;
	}

	public List<SelectItem> getListWAKD_ACC_FORCE_DEPT_YN() {
		return listWAKD_ACC_FORCE_DEPT_YN;
	}

	public void setListWAKD_ACC_FORCE_DEPT_YN(
			List<SelectItem> listWAKD_ACC_FORCE_DEPT_YN) {
		this.listWAKD_ACC_FORCE_DEPT_YN = listWAKD_ACC_FORCE_DEPT_YN;
	}

	public List<SelectItem> getListWAKD_ACC_DA_MO_DRIP() {
		return listWAKD_ACC_DA_MO_DRIP;
	}

	public void setListWAKD_ACC_DA_MO_DRIP(List<SelectItem> listWAKD_ACC_DA_MO_DRIP) {
		this.listWAKD_ACC_DA_MO_DRIP = listWAKD_ACC_DA_MO_DRIP;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_NAME() {
		return COMP_UI_M_MAIN_ACNT_NAME;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME(HtmlInputText comp_ui_m_main_acnt_name) {
		COMP_UI_M_MAIN_ACNT_NAME = comp_ui_m_main_acnt_name;
	}

	public HtmlInputText getCOMP_UI_M_SUB_ACNT_NAME() {
		return COMP_UI_M_SUB_ACNT_NAME;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME(HtmlInputText comp_ui_m_sub_acnt_name) {
		COMP_UI_M_SUB_ACNT_NAME = comp_ui_m_sub_acnt_name;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_NAME() {
		return COMP_UI_M_DIVN_NAME;
	}

	public void setCOMP_UI_M_DIVN_NAME(HtmlInputText comp_ui_m_divn_name) {
		COMP_UI_M_DIVN_NAME = comp_ui_m_divn_name;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_NAME() {
		return COMP_UI_M_DEPT_NAME;
	}

	public void setCOMP_UI_M_DEPT_NAME(HtmlInputText comp_ui_m_dept_name) {
		COMP_UI_M_DEPT_NAME = comp_ui_m_dept_name;
	}

	

	public HtmlInputText getCOMP_UI_M_ANLY_NAME() {
		return COMP_UI_M_ANLY_NAME;
	}

	public void setCOMP_UI_M_ANLY_NAME(HtmlInputText comp_ui_m_anly_name) {
		COMP_UI_M_ANLY_NAME = comp_ui_m_anly_name;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME_1() {
		return COMP_UI_M_ANLY_NAME_1;
	}

	public void setCOMP_UI_M_ANLY_NAME_1(HtmlInputText comp_ui_m_anly_name_1) {
		COMP_UI_M_ANLY_NAME_1 = comp_ui_m_anly_name_1;
	}

	
	public static String getZ_Constant() {
		return z_Constant;
	}

	public static Integer getInt_Constant() {
		return int_Constant;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME() {
		return COMP_UI_M_ACTY_NAME;
	}

	public void setCOMP_UI_M_ACTY_NAME(HtmlInputText comp_ui_m_acty_name) {
		COMP_UI_M_ACTY_NAME = comp_ui_m_acty_name;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME_1() {
		return COMP_UI_M_ACTY_NAME_1;
	}

	public void setCOMP_UI_M_ACTY_NAME_1(HtmlInputText comp_ui_m_acty_name_1) {
		COMP_UI_M_ACTY_NAME_1 = comp_ui_m_acty_name_1;
		
	}

	
	public void delete(){
			getErrorMap().clear();
			CRUDHandler handler = new CRUDHandler();
			try {
				Integer deleteRecord = handler.executeDelete(PM_WAKALAH_DAILY_ACC_SETUP_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN = new PM_WAKALAH_DAILY_ACC_SETUP();

				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Record Deleted Successfully");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
				"Record Deleted Successfully");
			} catch (Exception er) {
				er.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"er");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,"er");
			}
			
		}
	
	public void saveRecord(){
		String message = "";
		try{
			CommonUtils.clearMaps(this);
		if(getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().getROWID() == null){
				if(isINSERT_ALLOWED()){
					helper.PRE_INSERT(this);
				
				if(getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().isWAKD_ACC_FRZ_FLAG_VALUE()==false)
				{
					getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().setWAKD_ACC_FRZ_FLAG("N");
				}else{
					getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().setWAKD_ACC_FRZ_FLAG("Y");
				}
				new CRUDHandler().executeInsert(getPM_WAKALAH_DAILY_ACC_SETUP_BEAN(),CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties","errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("SAVE", message);
			}else{
				message = Messages.getString("messageProperties","errorPanel$message$insertnotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getErrorMap().put("SAVE", message);
			}
		}else{
				if(isUPDATE_ALLOWED()){
					helper.preUpdate(this);
					if(getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().isWAKD_ACC_FRZ_FLAG_VALUE()==false)
					{
						getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().setWAKD_ACC_FRZ_FLAG("N");
					}else{
						getPM_WAKALAH_DAILY_ACC_SETUP_BEAN().setWAKD_ACC_FRZ_FLAG("Y");
					}
				new CRUDHandler().executeInsert(getPM_WAKALAH_DAILY_ACC_SETUP_BEAN(),
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
				getWarningMap()
						.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
				getWarningMap().put("UPDATE", message);
			} else{
				message = Messages.getString("messageProperties",
				"errorPanel$message$updatenotallowed");
		getErrorMap()
				.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
		getErrorMap().put("UPDATE", message);
			}
		}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}finally{
			try{
				CommonUtils utils = new CommonUtils();
				utils.doComitt();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}

	
	public String backToSearch() {
    	return SearchConstants.BACK_TO_SEARCH_PAGE;
    }
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		
		PM_WAKALAH_DAILY_ACC_SETUP_DELEGATE delegate = new PM_WAKALAH_DAILY_ACC_SETUP_DELEGATE();
		try {
			if (isBlockFlag()) {
				delegate.executeSelectStatement(compositeAction);
				if(PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getROWID() != null){
					helper.postQuery(this);
				}else{
					helper.WhenCreateRecord(this);
				}
				helper.whenNewRecordInstance(this);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
	public void validateWAKD_ACC_MODULE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_MODULE((String)value);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}

	public void actionListenerWAKD_ACC_MODULE(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			helper.whenValidateWAKD_ACC_MODULE(this);
			COMP_WAKD_ACC_DIVN_FM_CODE.resetValue();
			COMP_WAKD_ACC_DIVN_TO_CODE.resetValue();
			COMP_WAKD_ACC_DEPT_FM_CODE.resetValue();
			COMP_WAKD_ACC_DEPT_TO_CODE.resetValue();
			COMP_WAKD_ACC_CLASS_FM_CODE.resetValue();
			COMP_WAKD_ACC_CLASS_TO_CODE.resetValue();
			COMP_WAKD_ACC_SC_FM_CODE.resetValue();
			COMP_WAKD_ACC_SC_TO_CODE.resetValue();
			COMP_WAKD_ACC_COVER_FM_CODE.resetValue();
			COMP_WAKD_ACC_COVER_TO_CODE.resetValue();
			COMP_WAKD_ACC_SRC_BUS_FM.resetValue();
			COMP_WAKD_ACC_SRC_BUS_TO.resetValue();
			COMP_WAKD_ACC_DOC_FM_TYPE.resetValue();
			COMP_WAKD_ACC_DOC_TO_TYPE.resetValue();
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_ACC_DIVN_FM_CODE(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_WAKD_ACC_DIVN_FM_CODE().setSubmittedValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_FM_CODE("0");
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_FM_CODE(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void actionListenerWAKD_ACC_DIVN_TO_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String divnFmCode = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DIVN_FM_CODE();
				if (!divnFmCode.trim().equals("0")) {
					getCOMP_WAKD_ACC_DIVN_TO_CODE().setSubmittedValue(divnFmCode);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_TO_CODE(divnFmCode);
				} else {
					getCOMP_WAKD_ACC_DIVN_TO_CODE().setSubmittedValue(z_Constant);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_TO_CODE(z_Constant);
				}
			} else {
				getCOMP_WAKD_ACC_DIVN_TO_CODE().setSubmittedValue(inputValue);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_TO_CODE(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_DIVN_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_TO_CODE((String) value);
		String P_FROM_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DIVN_FM_CODE();
		String P_TO_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DIVN_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
			
			COMP_WAKD_ACC_DIVN_TO_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	public void actionListenerWAKD_ACC_DEPT_FM_CODE(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_WAKD_ACC_DEPT_FM_CODE().setSubmittedValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_FM_CODE("0");
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_FM_CODE(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_ACC_DEPT_TO_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String deptFmCode = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DEPT_FM_CODE();
				if (!deptFmCode.trim().equals("0")) {
					getCOMP_WAKD_ACC_DEPT_TO_CODE().setSubmittedValue(deptFmCode);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_TO_CODE(deptFmCode);
				} else {
					getCOMP_WAKD_ACC_DEPT_TO_CODE().setSubmittedValue(z_Constant);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_TO_CODE(z_Constant);
				}
			} else {
				getCOMP_WAKD_ACC_DEPT_TO_CODE().setSubmittedValue(inputValue);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_TO_CODE(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_DEPT_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_TO_CODE((String) value);
		String P_FROM_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DEPT_FM_CODE();
		String P_TO_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DEPT_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
			
			COMP_WAKD_ACC_DEPT_TO_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void actionListenerWAKD_ACC_CLASS_FM_CODE(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_WAKD_ACC_CLASS_FM_CODE().setSubmittedValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CLASS_FM_CODE("0");
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CLASS_FM_CODE(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_ACC_CLASS_TO_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String classFmCode = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_CLASS_FM_CODE();
				if (!classFmCode.trim().equals("0")) {
					getCOMP_WAKD_ACC_CLASS_TO_CODE().setSubmittedValue(classFmCode);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CLASS_TO_CODE(classFmCode);
				} else {
					getCOMP_WAKD_ACC_CLASS_TO_CODE().setSubmittedValue(z_Constant);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CLASS_TO_CODE(z_Constant);
				}
			} else {
				getCOMP_WAKD_ACC_CLASS_TO_CODE().setSubmittedValue(inputValue);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CLASS_TO_CODE(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_CLASS_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_CLASS_TO_CODE(((String) value));
		String P_FROM_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_CLASS_FM_CODE();
		String P_TO_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_CLASS_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
			
			COMP_WAKD_ACC_CLASS_TO_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void actionListenerWAKD_ACC_SC_FM_CODE(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_WAKD_ACC_SC_FM_CODE().setSubmittedValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SC_FM_CODE("0");
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SC_FM_CODE(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_ACC_SC_TO_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String subClassFmCode = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SC_FM_CODE();
				if (!subClassFmCode.trim().equals("0")) {
					getCOMP_WAKD_ACC_SC_TO_CODE().setSubmittedValue(subClassFmCode);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SC_TO_CODE(subClassFmCode);
				} else {
					getCOMP_WAKD_ACC_SC_TO_CODE().setSubmittedValue(z_Constant);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SC_TO_CODE(z_Constant);
				}
			} else {
				getCOMP_WAKD_ACC_SC_TO_CODE().setSubmittedValue(inputValue);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SC_TO_CODE(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_SC_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SC_TO_CODE(((String) value));
		String P_FROM_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SC_FM_CODE();
		String P_TO_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SC_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
			
			COMP_WAKD_ACC_SC_TO_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void actionListenerWAKD_ACC_COVER_FM_CODE(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_WAKD_ACC_COVER_FM_CODE().setSubmittedValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_COVER_FM_CODE("0");
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_COVER_FM_CODE(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_ACC_COVER_TO_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String coverFmCode = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_COVER_FM_CODE();
				if (!coverFmCode.trim().equals("0")) {
					getCOMP_WAKD_ACC_COVER_TO_CODE().setSubmittedValue(coverFmCode);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_COVER_TO_CODE(coverFmCode);
				} else {
					getCOMP_WAKD_ACC_COVER_TO_CODE().setSubmittedValue(z_Constant);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_COVER_TO_CODE(z_Constant);
				}
			} else {
				getCOMP_WAKD_ACC_COVER_TO_CODE().setSubmittedValue(inputValue);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_COVER_TO_CODE(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_COVER_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_COVER_TO_CODE(((String) value));
		String P_FROM_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_COVER_FM_CODE();
		String P_TO_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_COVER_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
			
			COMP_WAKD_ACC_COVER_TO_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
		
	public void actionListenerWAKD_ACC_SRC_BUS_FM(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_WAKD_ACC_SRC_BUS_FM().setSubmittedValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SRC_BUS_FM("0");
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SRC_BUS_FM(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_ACC_SRC_BUS_TO(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String srcBusFm = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SRC_BUS_FM();
				if (!srcBusFm.trim().equals("0")) {
					getCOMP_WAKD_ACC_SRC_BUS_TO().setSubmittedValue(srcBusFm);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SRC_BUS_TO(srcBusFm);
				} else {
					getCOMP_WAKD_ACC_SRC_BUS_TO().setSubmittedValue(z_Constant);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SRC_BUS_TO(z_Constant);
				}
			} else {
				getCOMP_WAKD_ACC_SRC_BUS_TO().setSubmittedValue(inputValue);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SRC_BUS_TO(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_SRC_BUS_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SRC_BUS_TO((String) value);
		String P_FROM_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SRC_BUS_FM();
		String P_TO_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_SRC_BUS_TO();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
			
			COMP_WAKD_ACC_SRC_BUS_TO.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void actionListenerWAKD_ACC_DOC_FM_TYPE(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_WAKD_ACC_DOC_FM_TYPE().setSubmittedValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DOC_FM_TYPE("0");
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DOC_FM_TYPE(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_ACC_DOC_TO_TYPE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String docFmType = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DOC_FM_TYPE();
				if (!docFmType.trim().equals("0")) {
					getCOMP_WAKD_ACC_DOC_TO_TYPE().setSubmittedValue(docFmType);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DOC_TO_TYPE(docFmType);
				} else {
					getCOMP_WAKD_ACC_DOC_TO_TYPE().setSubmittedValue(z_Constant);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DOC_TO_TYPE(z_Constant);
				}
			} else {
				getCOMP_WAKD_ACC_DOC_TO_TYPE().setSubmittedValue(inputValue);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DOC_TO_TYPE(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_DOC_TO_TYPE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DOC_TO_TYPE((String) value);
		String P_FROM_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DOC_FM_TYPE();
		String P_TO_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DOC_TO_TYPE();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
			
			COMP_WAKD_ACC_DOC_TO_TYPE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_COVER_YRS_FM(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();

			if (inputValue.isEmpty()) {
				getCOMP_WAKD_COVER_YRS_FM().setSubmittedValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_COVER_YRS_FM(0);
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_COVER_YRS_FM(Integer
						.parseInt(inputValue));
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateWAKD_COVER_YRS_FM(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_COVER_YRS_FM((Integer) value);
			if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_COVER_YRS_FM() < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91018"));
			}
			if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_COVER_YRS_FM() > PM_WAKALAH_DAILY_ACC_SETUP_BEAN
					.getWAKD_COVER_YRS_TO()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91031"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_COVER_YRS_TO(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()|| inputValue==null) {
				Integer misYrsFm = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_COVER_YRS_FM();
				if (misYrsFm != 0) {
					getCOMP_WAKD_COVER_YRS_TO().setSubmittedValue(misYrsFm.toString());
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_COVER_YRS_TO(misYrsFm);
				} else {
					getCOMP_WAKD_COVER_YRS_TO().setSubmittedValue(int_Constant.toString());
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_COVER_YRS_TO(int_Constant);
				}
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_COVER_YRS_TO(Integer.parseInt(inputValue));
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ValidatorException(new FacesMessage(exc.getMessage()));

		}
	}

	public void validateWAKD_COVER_YRS_TO(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_COVER_YRS_TO((Integer)value);
		try {
			if (!int_Constant.equals(value)) {
				if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_COVER_YRS_TO() < 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91018"));
				}
				if (PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_COVER_YRS_TO() < 
						PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_COVER_YRS_FM()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91032"));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	

	public void actionListenerWAKD_ACC_ALY_FM_1(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_WAKD_ACC_ALY_FM_1().setSubmittedValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_FM_1("0");
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_FM_1(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_ACC_ALY_TO_1(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String anyly1Fm = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_FM_1();
				if (!anyly1Fm.trim().equals("0")) {
					getCOMP_WAKD_ACC_ALY_TO_1().setSubmittedValue(anyly1Fm);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_TO_1(anyly1Fm);
				} else {
					getCOMP_WAKD_ACC_ALY_TO_1().setSubmittedValue(z_Constant);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_TO_1(z_Constant);
				}
			} else {
				getCOMP_WAKD_ACC_ALY_TO_1().setSubmittedValue(inputValue);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_TO_1(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_ALY_TO_1(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_TO_1((String) value);
		String P_FROM_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_FM_1();
		String P_TO_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_TO_1();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
			
			COMP_WAKD_ACC_ALY_TO_1.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}	

	public void actionListenerWAKD_ACC_ALY_FM_2(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_WAKD_ACC_ALY_FM_2().setSubmittedValue("0");
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_FM_2("0");
			} else {
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_FM_2(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerWAKD_ACC_ALY_TO_2(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String anyly2Fm = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_FM_2();
				if (!anyly2Fm.trim().equals("0")) {
					getCOMP_WAKD_ACC_ALY_TO_2().setSubmittedValue(anyly2Fm);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_TO_2(anyly2Fm);
				} else {
					getCOMP_WAKD_ACC_ALY_TO_2().setSubmittedValue(z_Constant);
					PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_TO_2(z_Constant);
				}
			} else {
				getCOMP_WAKD_ACC_ALY_TO_2().setSubmittedValue(inputValue);
				PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_TO_2(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_ALY_TO_2(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ALY_TO_2((String) value);
		String P_FROM_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_FM_2();
		String P_TO_CODE = PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_ALY_TO_2();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
			
			COMP_WAKD_ACC_ALY_TO_2.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}	

	
	public void validateWAKD_ACC_SETUP(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SETUP((String) value);
		try {
			helper.whenValidateWAKD_ACC_SETUP(this);
			COMP_WAKD_ACC_DIVN_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_FORCE_DIVN_YN(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_FORCE_DIVN_YN((String) value);
		try {
			helper.whenValidateWAKD_ACC_FORCE_DIVN_YN(this);
			COMP_WAKD_ACC_DIVN_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_FORCE_DEPT_YN(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_FORCE_DEPT_YN((String) value);
		try {
			helper.whenValidateWAKD_ACC_FORCE_DEPT_YN(this);
			COMP_WAKD_ACC_DEPT_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validateWAKD_ACC_MAIN_ACNT_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_MAIN_ACNT_CODE((String)value);
			helper.whenValidateWAKD_ACC_MAIN_ACNT_CODE(this);
			/*COMP_UI_M_MAIN_ACNT_NAME.resetValue();
			COMP_WAKD_ACC_SUB_ACNT_CODE.resetValue();
			COMP_UI_M_SUB_ACNT_NAME.resetValue();
			COMP_UI_M_ACTY_NAME.resetValue();
			COMP_UI_M_ACTY_NAME_1.resetValue();*/
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateWAKD_ACC_SUB_ACNT_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_SUB_ACNT_CODE((String)value);
			helper.whenValidateWAKD_ACC_SUB_ACNT_CODE(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateWAKD_ACC_DIVN_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DIVN_CODE((String)value);
			helper.whenValidateWAKD_ACC_DIVN_CODE(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateWAKD_ACC_DEPT_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_DEPT_CODE((String)value);
			helper.whenValidateWAKD_ACC_DEPT_CODE(this);
			helper.whenNewItemInstanceWAKD_ACC_DEPT_CODE(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateWAKD_ACC_ANLY_CODE_1(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ANLY_CODE_1((String)value);
			helper.whenValidateWAKD_ACC_ANLY_CODE_1(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}	
	public void ValidateWAKD_ACC_ANLY_CODE_2(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ANLY_CODE_2((String)value);
			helper.whenValidateWAKD_ACC_ANLY_CODE_2(this);
		    helper.whenNewItemInstanceWAKD_ACC_ANLY_CODE_2(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateWAKD_ACC_ACTY_CODE_1(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ACTY_CODE_1((String)value);
			helper.whenValidateWAKD_ACC_ACTY_CODE_1(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}	
	public void ValidateWAKD_ACC_ACTY_CODE_2(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_WAKALAH_DAILY_ACC_SETUP_BEAN.setWAKD_ACC_ACTY_CODE_2((String)value);
			helper.whenValidateWAKD_ACC_ACTY_CODE_2(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}


	public List<LovBean> lovWAKD_ACC_DIVN_FM_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_DIVN_FM_CODE",
					CommonUtils.getControlBean().getM_COMP_CODE(),CommonUtils.getControlBean().getM_USER_ID(),
					null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovWAKD_ACC_DIVN_TO_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_DIVN_TO_CODE",
					CommonUtils.getControlBean().getM_COMP_CODE(),CommonUtils.getControlBean().getM_USER_ID(),
					null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovWAKD_ACC_DEPT_FM_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_DEPT_FM_CODE",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovWAKD_ACC_DEPT_TO_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_DEPT_TO_CODE",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovWAKD_ACC_CLASS_FM_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_CLASS_FM_CODE",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	
	
	public List<LovBean> lovWAKD_ACC_CLASS_TO_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_CLASS_TO_CODE",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovWAKD_ACC_SC_FM_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_SC_FM_CODE",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovWAKD_ACC_SC_TO_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_SC_FM_CODE",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovWAKD_ACC_COVER_FM_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_COVER_FM_CODE",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovWAKD_ACC_COVER_TO_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_COVER_TO_CODE",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovWAKD_ACC_SRC_BUS_FM(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_SRC_BUS_FM",
					"SRC_BUS_TY",null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovWAKD_ACC_SRC_BUS_TO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_SRC_BUS_TO",
					"SRC_BUS_TY",null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovWAKD_ACC_DOC_FM_TYPE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_DOC_FM_TYPE",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovWAKD_ACC_DOC_TO_TYPE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_DOC_TO_TYPE",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	/*public List<LovBean> lovWAKD_ACC_ALY_FM_1(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_ALY_FM_1",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovWAKD_ACC_ALY_TO_1(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_ALY_TO_1",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovWAKD_ACC_ALY_FM_2(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_ALY_FM_2",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovWAKD_ACC_ALY_TO_2(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PM079_A",
					"PM_WAKALAH_DAILY_ACC_SETUP", "WAKD_ACC_ALY_TO_2",
					null,null,null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	*/
	
	public ArrayList<LovBean> lovWAKD_ACC_ALY_FM_1(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS  WHERE ANLY_HEAD_NO = '1' AND FM_ANALYSIS.ANLY_FRZ_FLAG = 'N'"
				+ " AND (ANLY_CODE  LIKE ? OR ANLY_NAME LIKE ?) AND ROWNUM < ?";
		 
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	public ArrayList<LovBean> lovWAKD_ACC_ALY_TO_1(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS  WHERE ANLY_HEAD_NO = '1' AND FM_ANALYSIS.ANLY_FRZ_FLAG = 'N'"
				+ " AND (ANLY_CODE  LIKE ? OR ANLY_NAME LIKE ?) AND ROWNUM < ?";
		 
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	public ArrayList<LovBean> lovWAKD_ACC_ALY_FM_2(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS  WHERE ANLY_HEAD_NO = '2' " +
				" AND FM_ANALYSIS.ANLY_FRZ_FLAG = 'N'"
				+ " AND (ANLY_CODE  LIKE ? OR ANLY_NAME LIKE ?) AND ROWNUM < ?";
		 
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	

	public ArrayList<LovBean> lovWAKD_ACC_ALY_TO_2(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS  WHERE ANLY_HEAD_NO = '2' AND FM_ANALYSIS.ANLY_FRZ_FLAG = 'N'"
				+ " AND (ANLY_CODE  LIKE ? OR ANLY_NAME LIKE ?) AND ROWNUM < ?";
		 
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	public ArrayList<LovBean> lovWAKD_ACC_MAIN_ACNT_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT MAIN_ACNT_CODE,MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE FM_MAIN_ACCOUNT.MAIN_FRZ_FLAG = 'N'"
				+ "AND (MAIN_ACNT_CODE  LIKE ? OR MAIN_ACNT_NAME LIKE ?) AND ROWNUM < ?";
		 
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	
	/*public List<LovBean> lovWAKD_ACC_MAIN_ACNT_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//STD_CALL_LOV('PH015','PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_MAIN_ACNT_CODE');
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/
	
	public ArrayList<LovBean> lovWAKD_ACC_SUB_ACNT_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT SUB_ACNT_CODE,SUB_ACNT_NAME FROM FM_SUB_ACCOUNT" +
				" WHERE SUB_ACNT_CODE IN ( SELECT MS_SUB_ACNT_CODE FROM FM_MAIN_SUB WHERE" +
				" MS_MAIN_ACNT_CODE = ?) AND FM_SUB_ACCOUNT.SUB_FRZ_FLAG = 'N' "+
				" AND (SUB_ACNT_CODE  LIKE ? OR SUB_ACNT_NAME LIKE ?) AND ROWNUM < ?";
		 
		
		
		
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] {PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_MAIN_ACNT_CODE(),
					currentValue, currentValue,PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	
	/*public List<LovBean> lovWAKD_ACC_SUB_ACNT_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//STD_CALL_LOV('PH016','PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_SUB_ACNT_CODE',
              //      :PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_MAIN_ACNT_CODE)
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/
	
	public ArrayList<LovBean> lovWAKD_ACC_DIVN_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT DIVN_CODE,DIVN_NAME FROM FM_DIVISION WHERE FM_DIVISION.DIVN_FRZ_FLAG = 'N'" +
				" AND (DIVN_CODE  LIKE ? OR DIVN_NAME LIKE ?) AND ROWNUM < ?";
		 
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] {currentValue, currentValue,PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	/*public List<LovBean> lovWAKD_ACC_DIVN_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//STD_CALL_LOV('PH020','PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_DIVN_CODE');
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/
	
	
	public ArrayList<LovBean> lovWAKD_ACC_DEPT_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT DEPT_CODE,DEPT_NAME FROM FM_DEPARTMENT" +
				" WHERE DEPT_DIVN_CODE = ? AND FM_DEPARTMENT.DEPT_FRZ_FLAG = 'N'" +
				" AND (DEPT_CODE  LIKE ? OR DEPT_NAME LIKE ?) AND ROWNUM < ?";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] {PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getWAKD_ACC_DIVN_CODE(),
					currentValue, currentValue,PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	/*
	public List<LovBean> lovWAKD_ACC_DEPT_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//STD_CALL_LOV('PH021','PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_DEPT_CODE',
              //      :PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_DIVN_CODE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/
	
	
	public ArrayList<LovBean> lovWAKD_ACC_ANLY_CODE_1(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE " +
				" ANLY_HEAD_NO LIKE '1' AND " +
				" FM_ANALYSIS.ANLY_FRZ_FLAG = 'N'" +
				" AND (ANLY_CODE  LIKE ? OR ANLY_NAME LIKE ?) AND ROWNUM < ?";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] {
					//PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_HEAD_1(),
					currentValue, currentValue,PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	/*public List<LovBean> lovWAKD_ACC_ANLY_CODE_1(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//STD_CALL_LOV('PH017','PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_ANLY_CODE_1','1');
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
*/
	
	
	public ArrayList<LovBean> lovWAKD_ACC_ANLY_CODE_2(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE " +
				" ANLY_HEAD_NO LIKE '2' AND" +
				" FM_ANALYSIS.ANLY_FRZ_FLAG = 'N'" +
				" AND (ANLY_CODE  LIKE ? OR ANLY_NAME LIKE ?) AND ROWNUM < ?";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] {
					//PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_1(),
					currentValue, currentValue,PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	/*public List<LovBean> lovWAKD_ACC_ANLY_CODE_2(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
		//	STD_CALL_LOV('PH017','PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_ANLY_CODE_2','2');
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/
	

	public ArrayList<LovBean> lovWAKD_ACC_ACTY_CODE_1(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE " +
				" AVAL_ACTY_CODE = ? AND FM_ACTY_VALUE.AVAL_FRZ_FLAG = 'N'" +
				" AND (AVAL_CODE  LIKE ? OR AVAL_VALUE_NAME LIKE ?) AND ROWNUM < ?";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] {PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_1(),
					currentValue, currentValue,PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	
	/*public List<LovBean> lovWAKD_ACC_ACTY_CODE_1(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//STD_CALL_LOV('PH018','PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_ACTY_CODE_1',:DUMMY.M_ACTY_1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/
	
	

	public ArrayList<LovBean> lovWAKD_ACC_ACTY_CODE_2(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE " +
				" AVAL_ACTY_CODE = ? AND FM_ACTY_VALUE.AVAL_FRZ_FLAG = 'N'" +
				" AND (AVAL_CODE  LIKE ? OR AVAL_VALUE_NAME LIKE ?) AND ROWNUM < ?";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] {PM_WAKALAH_DAILY_ACC_SETUP_BEAN.getUI_M_ACTY_2(),
					currentValue, currentValue,PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	/*public List<LovBean> lovWAKD_ACC_ACTY_CODE_2(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//STD_CALL_LOV('PH018','PM_WAKALAH_DAILY_ACC_SETUP.WAKD_ACC_ACTY_CODE_2',:DUMMY.M_ACTY_2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
*/
	

	
}
