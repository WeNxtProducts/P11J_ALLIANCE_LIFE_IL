package com.iii.pel.forms.PILM085_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
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
import com.iii.pel.forms.PILM054_APAC.DB_PROCEDURES;
import com.iii.pel.forms.PILM065_APAC.PM_IL_ACCRUAL_SETUP;
import com.iii.pel.forms.PILM072_APAC.PM_IL_IF_ACCNT_SETUP_HDR;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_ANNUITY_PYMT_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_APS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_APS_FRZ_FLAG;

	private HtmlOutputLabel COMP_APS_SRC_BUS_FM_LABEL;

	private HtmlInputText COMP_APS_SRC_BUS_FM;

	private HtmlOutputLabel COMP_APS_SRC_BUS_TO_LABEL;

	private HtmlInputText COMP_APS_SRC_BUS_TO;

	private HtmlOutputLabel COMP_APS_DIVN_FM_CODE_LABEL;

	private HtmlInputText COMP_APS_DIVN_FM_CODE;

	private HtmlOutputLabel COMP_APS_DIVN_TO_CODE_LABEL;

	private HtmlInputText COMP_APS_DIVN_TO_CODE;

	private HtmlOutputLabel COMP_APS_DEPT_FM_CODE_LABEL;

	private HtmlInputText COMP_APS_DEPT_FM_CODE;

	private HtmlOutputLabel COMP_APS_DEPT_TO_CODE_LABEL;

	private HtmlInputText COMP_APS_DEPT_TO_CODE;

	private HtmlOutputLabel COMP_APS_DOC_FM_TYPE_LABEL;

	private HtmlInputText COMP_APS_DOC_FM_TYPE;

	private HtmlOutputLabel COMP_APS_DOC_TO_TYPE_LABEL;

	private HtmlInputText COMP_APS_DOC_TO_TYPE;

	private HtmlOutputLabel COMP_APS_PROD_CODE_FM_LABEL;

	private HtmlInputText COMP_APS_PROD_CODE_FM;

	private HtmlOutputLabel COMP_APS_PROD_CODE_TO_LABEL;

	private HtmlInputText COMP_APS_PROD_CODE_TO;

	private HtmlOutputLabel COMP_APS_POL_YR_FM_LABEL;

	private HtmlInputText COMP_APS_POL_YR_FM;

	private HtmlOutputLabel COMP_APS_POL_YR_TO_LABEL;

	private HtmlInputText COMP_APS_POL_YR_TO;

	private HtmlOutputLabel COMP_APS_SETUP_FOR_LABEL;

	private HtmlSelectOneMenu COMP_APS_SETUP_FOR;

	private HtmlOutputLabel COMP_APS_DRCR_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_APS_DRCR_FLAG;

	private HtmlOutputLabel COMP_APS_COVER_CODE_FM_LABEL;

	private HtmlInputText COMP_APS_COVER_CODE_FM;

	private HtmlOutputLabel COMP_APS_COVER_CODE_TO_LABEL;

	private HtmlInputText COMP_APS_COVER_CODE_TO;

	private HtmlOutputLabel COMP_APS_SEQ_NO_LABEL;

	private HtmlInputText COMP_APS_SEQ_NO;

	private HtmlOutputLabel COMP_APS_NARRATION_CODE_LABEL;

	private HtmlInputText COMP_APS_NARRATION_CODE;

	private HtmlOutputLabel COMP_APS_FORCE_DIVN_YN_LABEL;

	private HtmlSelectOneMenu COMP_APS_FORCE_DIVN_YN;

	private HtmlOutputLabel COMP_APS_FORCE_DEPT_YN_LABEL;

	private HtmlSelectOneMenu COMP_APS_FORCE_DEPT_YN;

	private HtmlOutputLabel COMP_APS_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_APS_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;

	private HtmlOutputLabel COMP_APS_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_APS_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_NAME;

	private HtmlOutputLabel COMP_APS_DIVN_CODE_LABEL;

	private HtmlInputText COMP_APS_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_NAME;

	private HtmlOutputLabel COMP_APS_DEPT_CODE_LABEL;

	private HtmlInputText COMP_APS_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_NAME;

	private HtmlOutputLabel COMP_APS_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_APS_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME;

	private HtmlOutputLabel COMP_APS_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_APS_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME_1;

	private HtmlOutputLabel COMP_APS_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_APS_ACTY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME;

	private HtmlOutputLabel COMP_APS_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_APS_ACTY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME_1;

	private HtmlCommandButton COMP_UI_M_APS_PROD_CODE_FM_LOV;

	private HtmlCommandButton COMP_UI_M_APS_PROD_CODE_TO_LOV;

	private HtmlCommandButton COMP_UI_M_APS_COVER_CODE_FM_LOV;

	private HtmlCommandButton COMP_UI_M_APS_COVER_CODE_TO_LOV;

	private HtmlCommandButton COMP_UI_M_APS_MAIN_ACNT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_APS_SUB_ACNT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_APS_DIVN_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_APS_DEPT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_APS_ANLY_CODE_1_LOV;

	private HtmlCommandButton COMP_UI_M_APS_ANLY_CODE_2_LOV;

	private HtmlCommandButton COMP_UI_M_APS_ACTY_CODE_1_LOV;

	private HtmlCommandButton COMP_UI_M_APS_ACTY_CODE_2_LOV;

	private HtmlCommandButton COMP_UI_M_APS_NARRATION_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_SRC_BUS_FM_LOV;

	private HtmlCommandButton COMP_UI_M_SRC_BUS_TO_LOV;

	private HtmlCommandButton COMP_UI_M_APS_DIVN_FM_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_APS_DIVN_TO_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_APS_DEPT_FM_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_APS_DEPT_TO_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_APS_DOC_FM_TYPE_LOV;

	private HtmlCommandButton COMP_UI_M_APS_DOC_TO_TYPE_LOV;

	private PM_IL_ANNUITY_PYMT_SETUP PM_IL_ANNUITY_PYMT_SETUP_BEAN;

	public PILM085_APAC_COMPOSITE_ACTION compositeAction;

	private CTRL CTRA_BEAN;

	private PM_IL_ANNUITY_PYMT_SETUP_HELPER helper;

	private List<SelectItem> listAPS_SETUP_FOR = new ArrayList<SelectItem>();

	private List<SelectItem> listAPS_DRCR_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listAPS_FORCE_DIVN_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listAPS_FORCE_DEPT_YN = new ArrayList<SelectItem>();

	public PM_IL_ANNUITY_PYMT_SETUP_ACTION() {
		PM_IL_ANNUITY_PYMT_SETUP_BEAN = new PM_IL_ANNUITY_PYMT_SETUP();
		helper = new PM_IL_ANNUITY_PYMT_SETUP_HELPER();
		// whenCreateRecord();
		instantiateAllComponent();
		getListAPS_SETUP_FOR();
		getListAPS_DRCR_FLAG();
		getListAPS_FORCE_DIVN_YN();
		getListAPS_FORCE_DEPT_YN();

		// loadValues();
	}

	public List<SelectItem> getListAPS_FORCE_DIVN_YN() {

		if (listAPS_FORCE_DIVN_YN.size() == 0) {
			listAPS_FORCE_DIVN_YN.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listAPS_FORCE_DIVN_YN = ListItemUtil.getDropDownListValue(con,
						"PILM085_APAC", "PM_IL_ANNUITY_PYMT_SETUP",
						"PM_IL_ANNUITY_PYMT_SETUP.APS_FORCE_DIVN_YN", "YESNO");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listAPS_FORCE_DIVN_YN;
	}

	public void setListAPS_FORCE_DIVN_YN(List<SelectItem> listAPS_FORCE_DIVN_YN) {
		this.listAPS_FORCE_DIVN_YN = listAPS_FORCE_DIVN_YN;
	}

	public List<SelectItem> getListAPS_FORCE_DEPT_YN() {
		if (listAPS_FORCE_DEPT_YN.size() == 0) {
			listAPS_FORCE_DEPT_YN.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listAPS_FORCE_DEPT_YN = ListItemUtil.getDropDownListValue(con,
						"PILM085_APAC", "PM_IL_ANNUITY_PYMT_SETUP",
						"PM_IL_ANNUITY_PYMT_SETUP.APS_FORCE_DEPT_YN", "YESNO");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listAPS_FORCE_DEPT_YN;
	}

	public void setListAPS_FORCE_DEPT_YN(List<SelectItem> listAPS_FORCE_DEPT_YN) {
		this.listAPS_FORCE_DEPT_YN = listAPS_FORCE_DEPT_YN;
	}

	public List<SelectItem> getListAPS_DRCR_FLAG() {

		if (listAPS_DRCR_FLAG.size() == 0) {
			listAPS_DRCR_FLAG.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listAPS_DRCR_FLAG = ListItemUtil.getDropDownListValue(con,
						"PILM085_APAC", "PM_IL_ANNUITY_PYMT_SETUP",
						"PM_IL_ANNUITY_PYMT_SETUP.APS_DRCR_FLAG", "DEB_CRE");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listAPS_DRCR_FLAG;
	}

	public void setListAPS_DRCR_FLAG(List<SelectItem> listAPS_DRCR_FLAG) {
		this.listAPS_DRCR_FLAG = listAPS_DRCR_FLAG;
	}

	public List<SelectItem> getListAPS_SETUP_FOR() {

		if (listAPS_SETUP_FOR.size() == 0) {
			listAPS_SETUP_FOR.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listAPS_SETUP_FOR = ListItemUtil.getDropDownListValue_1(con,
						"PILM085_APAC", "PM_IL_ANNUITY_PYMT_SETUP",
						"PM_IL_ANNUITY_PYMT_SETUP.APS_SETUP_FOR", null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listAPS_SETUP_FOR;
	}

	public void setListAPS_SETUP_FOR(List<SelectItem> listAPS_SETUP_FOR) {
		this.listAPS_SETUP_FOR = listAPS_SETUP_FOR;
	}

	private boolean update = false;

	public HtmlOutputLabel getCOMP_APS_FRZ_FLAG_LABEL() {
		return COMP_APS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_APS_FRZ_FLAG() {
		return COMP_APS_FRZ_FLAG;
	}

	public void setCOMP_APS_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_APS_FRZ_FLAG_LABEL) {
		this.COMP_APS_FRZ_FLAG_LABEL = COMP_APS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_APS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_APS_FRZ_FLAG) {
		this.COMP_APS_FRZ_FLAG = COMP_APS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_APS_SRC_BUS_FM_LABEL() {
		return COMP_APS_SRC_BUS_FM_LABEL;
	}

	public HtmlInputText getCOMP_APS_SRC_BUS_FM() {
		return COMP_APS_SRC_BUS_FM;
	}

	public void setCOMP_APS_SRC_BUS_FM_LABEL(
			HtmlOutputLabel COMP_APS_SRC_BUS_FM_LABEL) {
		this.COMP_APS_SRC_BUS_FM_LABEL = COMP_APS_SRC_BUS_FM_LABEL;
	}

	public void setCOMP_APS_SRC_BUS_FM(HtmlInputText COMP_APS_SRC_BUS_FM) {
		this.COMP_APS_SRC_BUS_FM = COMP_APS_SRC_BUS_FM;
	}

	public HtmlOutputLabel getCOMP_APS_SRC_BUS_TO_LABEL() {
		return COMP_APS_SRC_BUS_TO_LABEL;
	}

	public HtmlInputText getCOMP_APS_SRC_BUS_TO() {
		return COMP_APS_SRC_BUS_TO;
	}

	public void setCOMP_APS_SRC_BUS_TO_LABEL(
			HtmlOutputLabel COMP_APS_SRC_BUS_TO_LABEL) {
		this.COMP_APS_SRC_BUS_TO_LABEL = COMP_APS_SRC_BUS_TO_LABEL;
	}

	public void setCOMP_APS_SRC_BUS_TO(HtmlInputText COMP_APS_SRC_BUS_TO) {
		this.COMP_APS_SRC_BUS_TO = COMP_APS_SRC_BUS_TO;
	}

	public HtmlOutputLabel getCOMP_APS_DIVN_FM_CODE_LABEL() {
		return COMP_APS_DIVN_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_DIVN_FM_CODE() {
		return COMP_APS_DIVN_FM_CODE;
	}

	public void setCOMP_APS_DIVN_FM_CODE_LABEL(
			HtmlOutputLabel COMP_APS_DIVN_FM_CODE_LABEL) {
		this.COMP_APS_DIVN_FM_CODE_LABEL = COMP_APS_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_APS_DIVN_FM_CODE(HtmlInputText COMP_APS_DIVN_FM_CODE) {
		this.COMP_APS_DIVN_FM_CODE = COMP_APS_DIVN_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_APS_DIVN_TO_CODE_LABEL() {
		return COMP_APS_DIVN_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_DIVN_TO_CODE() {
		return COMP_APS_DIVN_TO_CODE;
	}

	public void setCOMP_APS_DIVN_TO_CODE_LABEL(
			HtmlOutputLabel COMP_APS_DIVN_TO_CODE_LABEL) {
		this.COMP_APS_DIVN_TO_CODE_LABEL = COMP_APS_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_APS_DIVN_TO_CODE(HtmlInputText COMP_APS_DIVN_TO_CODE) {
		this.COMP_APS_DIVN_TO_CODE = COMP_APS_DIVN_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_APS_DEPT_FM_CODE_LABEL() {
		return COMP_APS_DEPT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_DEPT_FM_CODE() {
		return COMP_APS_DEPT_FM_CODE;
	}

	public void setCOMP_APS_DEPT_FM_CODE_LABEL(
			HtmlOutputLabel COMP_APS_DEPT_FM_CODE_LABEL) {
		this.COMP_APS_DEPT_FM_CODE_LABEL = COMP_APS_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_APS_DEPT_FM_CODE(HtmlInputText COMP_APS_DEPT_FM_CODE) {
		this.COMP_APS_DEPT_FM_CODE = COMP_APS_DEPT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_APS_DEPT_TO_CODE_LABEL() {
		return COMP_APS_DEPT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_DEPT_TO_CODE() {
		return COMP_APS_DEPT_TO_CODE;
	}

	public void setCOMP_APS_DEPT_TO_CODE_LABEL(
			HtmlOutputLabel COMP_APS_DEPT_TO_CODE_LABEL) {
		this.COMP_APS_DEPT_TO_CODE_LABEL = COMP_APS_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_APS_DEPT_TO_CODE(HtmlInputText COMP_APS_DEPT_TO_CODE) {
		this.COMP_APS_DEPT_TO_CODE = COMP_APS_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_APS_DOC_FM_TYPE_LABEL() {
		return COMP_APS_DOC_FM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_APS_DOC_FM_TYPE() {
		return COMP_APS_DOC_FM_TYPE;
	}

	public void setCOMP_APS_DOC_FM_TYPE_LABEL(
			HtmlOutputLabel COMP_APS_DOC_FM_TYPE_LABEL) {
		this.COMP_APS_DOC_FM_TYPE_LABEL = COMP_APS_DOC_FM_TYPE_LABEL;
	}

	public void setCOMP_APS_DOC_FM_TYPE(HtmlInputText COMP_APS_DOC_FM_TYPE) {
		this.COMP_APS_DOC_FM_TYPE = COMP_APS_DOC_FM_TYPE;
	}

	public HtmlOutputLabel getCOMP_APS_DOC_TO_TYPE_LABEL() {
		return COMP_APS_DOC_TO_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_APS_DOC_TO_TYPE() {
		return COMP_APS_DOC_TO_TYPE;
	}

	public void setCOMP_APS_DOC_TO_TYPE_LABEL(
			HtmlOutputLabel COMP_APS_DOC_TO_TYPE_LABEL) {
		this.COMP_APS_DOC_TO_TYPE_LABEL = COMP_APS_DOC_TO_TYPE_LABEL;
	}

	public void setCOMP_APS_DOC_TO_TYPE(HtmlInputText COMP_APS_DOC_TO_TYPE) {
		this.COMP_APS_DOC_TO_TYPE = COMP_APS_DOC_TO_TYPE;
	}

	public HtmlOutputLabel getCOMP_APS_PROD_CODE_FM_LABEL() {
		return COMP_APS_PROD_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_APS_PROD_CODE_FM() {
		return COMP_APS_PROD_CODE_FM;
	}

	public void setCOMP_APS_PROD_CODE_FM_LABEL(
			HtmlOutputLabel COMP_APS_PROD_CODE_FM_LABEL) {
		this.COMP_APS_PROD_CODE_FM_LABEL = COMP_APS_PROD_CODE_FM_LABEL;
	}

	public void setCOMP_APS_PROD_CODE_FM(HtmlInputText COMP_APS_PROD_CODE_FM) {
		this.COMP_APS_PROD_CODE_FM = COMP_APS_PROD_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_APS_PROD_CODE_TO_LABEL() {
		return COMP_APS_PROD_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_APS_PROD_CODE_TO() {
		return COMP_APS_PROD_CODE_TO;
	}

	public void setCOMP_APS_PROD_CODE_TO_LABEL(
			HtmlOutputLabel COMP_APS_PROD_CODE_TO_LABEL) {
		this.COMP_APS_PROD_CODE_TO_LABEL = COMP_APS_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_APS_PROD_CODE_TO(HtmlInputText COMP_APS_PROD_CODE_TO) {
		this.COMP_APS_PROD_CODE_TO = COMP_APS_PROD_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_APS_POL_YR_FM_LABEL() {
		return COMP_APS_POL_YR_FM_LABEL;
	}

	public HtmlInputText getCOMP_APS_POL_YR_FM() {
		return COMP_APS_POL_YR_FM;
	}

	public void setCOMP_APS_POL_YR_FM_LABEL(
			HtmlOutputLabel COMP_APS_POL_YR_FM_LABEL) {
		this.COMP_APS_POL_YR_FM_LABEL = COMP_APS_POL_YR_FM_LABEL;
	}

	public void setCOMP_APS_POL_YR_FM(HtmlInputText COMP_APS_POL_YR_FM) {
		this.COMP_APS_POL_YR_FM = COMP_APS_POL_YR_FM;
	}

	public HtmlOutputLabel getCOMP_APS_POL_YR_TO_LABEL() {
		return COMP_APS_POL_YR_TO_LABEL;
	}

	public HtmlInputText getCOMP_APS_POL_YR_TO() {
		return COMP_APS_POL_YR_TO;
	}

	public void setCOMP_APS_POL_YR_TO_LABEL(
			HtmlOutputLabel COMP_APS_POL_YR_TO_LABEL) {
		this.COMP_APS_POL_YR_TO_LABEL = COMP_APS_POL_YR_TO_LABEL;
	}

	public void setCOMP_APS_POL_YR_TO(HtmlInputText COMP_APS_POL_YR_TO) {
		this.COMP_APS_POL_YR_TO = COMP_APS_POL_YR_TO;
	}

	public HtmlOutputLabel getCOMP_APS_SETUP_FOR_LABEL() {
		return COMP_APS_SETUP_FOR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APS_SETUP_FOR() {
		return COMP_APS_SETUP_FOR;
	}

	public void setCOMP_APS_SETUP_FOR_LABEL(
			HtmlOutputLabel COMP_APS_SETUP_FOR_LABEL) {
		this.COMP_APS_SETUP_FOR_LABEL = COMP_APS_SETUP_FOR_LABEL;
	}

	public void setCOMP_APS_SETUP_FOR(HtmlSelectOneMenu COMP_APS_SETUP_FOR) {
		this.COMP_APS_SETUP_FOR = COMP_APS_SETUP_FOR;
	}

	public HtmlOutputLabel getCOMP_APS_DRCR_FLAG_LABEL() {
		return COMP_APS_DRCR_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APS_DRCR_FLAG() {
		return COMP_APS_DRCR_FLAG;
	}

	public void setCOMP_APS_DRCR_FLAG_LABEL(
			HtmlOutputLabel COMP_APS_DRCR_FLAG_LABEL) {
		this.COMP_APS_DRCR_FLAG_LABEL = COMP_APS_DRCR_FLAG_LABEL;
	}

	public void setCOMP_APS_DRCR_FLAG(HtmlSelectOneMenu COMP_APS_DRCR_FLAG) {
		this.COMP_APS_DRCR_FLAG = COMP_APS_DRCR_FLAG;
	}

	public HtmlOutputLabel getCOMP_APS_COVER_CODE_FM_LABEL() {
		return COMP_APS_COVER_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_APS_COVER_CODE_FM() {
		return COMP_APS_COVER_CODE_FM;
	}

	public void setCOMP_APS_COVER_CODE_FM_LABEL(
			HtmlOutputLabel COMP_APS_COVER_CODE_FM_LABEL) {
		this.COMP_APS_COVER_CODE_FM_LABEL = COMP_APS_COVER_CODE_FM_LABEL;
	}

	public void setCOMP_APS_COVER_CODE_FM(HtmlInputText COMP_APS_COVER_CODE_FM) {
		this.COMP_APS_COVER_CODE_FM = COMP_APS_COVER_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_APS_COVER_CODE_TO_LABEL() {
		return COMP_APS_COVER_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_APS_COVER_CODE_TO() {
		return COMP_APS_COVER_CODE_TO;
	}

	public void setCOMP_APS_COVER_CODE_TO_LABEL(
			HtmlOutputLabel COMP_APS_COVER_CODE_TO_LABEL) {
		this.COMP_APS_COVER_CODE_TO_LABEL = COMP_APS_COVER_CODE_TO_LABEL;
	}

	public void setCOMP_APS_COVER_CODE_TO(HtmlInputText COMP_APS_COVER_CODE_TO) {
		this.COMP_APS_COVER_CODE_TO = COMP_APS_COVER_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_APS_SEQ_NO_LABEL() {
		return COMP_APS_SEQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_APS_SEQ_NO() {
		return COMP_APS_SEQ_NO;
	}

	public void setCOMP_APS_SEQ_NO_LABEL(HtmlOutputLabel COMP_APS_SEQ_NO_LABEL) {
		this.COMP_APS_SEQ_NO_LABEL = COMP_APS_SEQ_NO_LABEL;
	}

	public void setCOMP_APS_SEQ_NO(HtmlInputText COMP_APS_SEQ_NO) {
		this.COMP_APS_SEQ_NO = COMP_APS_SEQ_NO;
	}

	public HtmlOutputLabel getCOMP_APS_NARRATION_CODE_LABEL() {
		return COMP_APS_NARRATION_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_NARRATION_CODE() {
		return COMP_APS_NARRATION_CODE;
	}

	public void setCOMP_APS_NARRATION_CODE_LABEL(
			HtmlOutputLabel COMP_APS_NARRATION_CODE_LABEL) {
		this.COMP_APS_NARRATION_CODE_LABEL = COMP_APS_NARRATION_CODE_LABEL;
	}

	public void setCOMP_APS_NARRATION_CODE(HtmlInputText COMP_APS_NARRATION_CODE) {
		this.COMP_APS_NARRATION_CODE = COMP_APS_NARRATION_CODE;
	}

	public HtmlOutputLabel getCOMP_APS_FORCE_DIVN_YN_LABEL() {
		return COMP_APS_FORCE_DIVN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APS_FORCE_DIVN_YN() {
		return COMP_APS_FORCE_DIVN_YN;
	}

	public void setCOMP_APS_FORCE_DIVN_YN_LABEL(
			HtmlOutputLabel COMP_APS_FORCE_DIVN_YN_LABEL) {
		this.COMP_APS_FORCE_DIVN_YN_LABEL = COMP_APS_FORCE_DIVN_YN_LABEL;
	}

	public void setCOMP_APS_FORCE_DIVN_YN(
			HtmlSelectOneMenu COMP_APS_FORCE_DIVN_YN) {
		this.COMP_APS_FORCE_DIVN_YN = COMP_APS_FORCE_DIVN_YN;
	}

	public HtmlOutputLabel getCOMP_APS_FORCE_DEPT_YN_LABEL() {
		return COMP_APS_FORCE_DEPT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APS_FORCE_DEPT_YN() {
		return COMP_APS_FORCE_DEPT_YN;
	}

	public void setCOMP_APS_FORCE_DEPT_YN_LABEL(
			HtmlOutputLabel COMP_APS_FORCE_DEPT_YN_LABEL) {
		this.COMP_APS_FORCE_DEPT_YN_LABEL = COMP_APS_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_APS_FORCE_DEPT_YN(
			HtmlSelectOneMenu COMP_APS_FORCE_DEPT_YN) {
		this.COMP_APS_FORCE_DEPT_YN = COMP_APS_FORCE_DEPT_YN;
	}

	public HtmlOutputLabel getCOMP_APS_MAIN_ACNT_CODE_LABEL() {
		return COMP_APS_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_MAIN_ACNT_CODE() {
		return COMP_APS_MAIN_ACNT_CODE;
	}

	public void setCOMP_APS_MAIN_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_APS_MAIN_ACNT_CODE_LABEL) {
		this.COMP_APS_MAIN_ACNT_CODE_LABEL = COMP_APS_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_APS_MAIN_ACNT_CODE(HtmlInputText COMP_APS_MAIN_ACNT_CODE) {
		this.COMP_APS_MAIN_ACNT_CODE = COMP_APS_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAIN_ACNT_NAME_LABEL() {
		return COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_NAME() {
		return COMP_UI_M_MAIN_ACNT_NAME;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL) {
		this.COMP_UI_M_MAIN_ACNT_NAME_LABEL = COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME(
			HtmlInputText COMP_UI_M_MAIN_ACNT_NAME) {
		this.COMP_UI_M_MAIN_ACNT_NAME = COMP_UI_M_MAIN_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_APS_SUB_ACNT_CODE_LABEL() {
		return COMP_APS_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_SUB_ACNT_CODE() {
		return COMP_APS_SUB_ACNT_CODE;
	}

	public void setCOMP_APS_SUB_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_APS_SUB_ACNT_CODE_LABEL) {
		this.COMP_APS_SUB_ACNT_CODE_LABEL = COMP_APS_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_APS_SUB_ACNT_CODE(HtmlInputText COMP_APS_SUB_ACNT_CODE) {
		this.COMP_APS_SUB_ACNT_CODE = COMP_APS_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUB_ACNT_NAME_LABEL() {
		return COMP_UI_M_SUB_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUB_ACNT_NAME() {
		return COMP_UI_M_SUB_ACNT_NAME;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL) {
		this.COMP_UI_M_SUB_ACNT_NAME_LABEL = COMP_UI_M_SUB_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME(HtmlInputText COMP_UI_M_SUB_ACNT_NAME) {
		this.COMP_UI_M_SUB_ACNT_NAME = COMP_UI_M_SUB_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_APS_DIVN_CODE_LABEL() {
		return COMP_APS_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_DIVN_CODE() {
		return COMP_APS_DIVN_CODE;
	}

	public void setCOMP_APS_DIVN_CODE_LABEL(
			HtmlOutputLabel COMP_APS_DIVN_CODE_LABEL) {
		this.COMP_APS_DIVN_CODE_LABEL = COMP_APS_DIVN_CODE_LABEL;
	}

	public void setCOMP_APS_DIVN_CODE(HtmlInputText COMP_APS_DIVN_CODE) {
		this.COMP_APS_DIVN_CODE = COMP_APS_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_NAME_LABEL() {
		return COMP_UI_M_DIVN_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_NAME() {
		return COMP_UI_M_DIVN_NAME;
	}

	public void setCOMP_UI_M_DIVN_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL) {
		this.COMP_UI_M_DIVN_NAME_LABEL = COMP_UI_M_DIVN_NAME_LABEL;
	}

	public void setCOMP_UI_M_DIVN_NAME(HtmlInputText COMP_UI_M_DIVN_NAME) {
		this.COMP_UI_M_DIVN_NAME = COMP_UI_M_DIVN_NAME;
	}

	public HtmlOutputLabel getCOMP_APS_DEPT_CODE_LABEL() {
		return COMP_APS_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_DEPT_CODE() {
		return COMP_APS_DEPT_CODE;
	}

	public void setCOMP_APS_DEPT_CODE_LABEL(
			HtmlOutputLabel COMP_APS_DEPT_CODE_LABEL) {
		this.COMP_APS_DEPT_CODE_LABEL = COMP_APS_DEPT_CODE_LABEL;
	}

	public void setCOMP_APS_DEPT_CODE(HtmlInputText COMP_APS_DEPT_CODE) {
		this.COMP_APS_DEPT_CODE = COMP_APS_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_NAME_LABEL() {
		return COMP_UI_M_DEPT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_NAME() {
		return COMP_UI_M_DEPT_NAME;
	}

	public void setCOMP_UI_M_DEPT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL) {
		this.COMP_UI_M_DEPT_NAME_LABEL = COMP_UI_M_DEPT_NAME_LABEL;
	}

	public void setCOMP_UI_M_DEPT_NAME(HtmlInputText COMP_UI_M_DEPT_NAME) {
		this.COMP_UI_M_DEPT_NAME = COMP_UI_M_DEPT_NAME;
	}

	public HtmlOutputLabel getCOMP_APS_ANLY_CODE_1_LABEL() {
		return COMP_APS_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_APS_ANLY_CODE_1() {
		return COMP_APS_ANLY_CODE_1;
	}

	public void setCOMP_APS_ANLY_CODE_1_LABEL(
			HtmlOutputLabel COMP_APS_ANLY_CODE_1_LABEL) {
		this.COMP_APS_ANLY_CODE_1_LABEL = COMP_APS_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_APS_ANLY_CODE_1(HtmlInputText COMP_APS_ANLY_CODE_1) {
		this.COMP_APS_ANLY_CODE_1 = COMP_APS_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_NAME_LABEL() {
		return COMP_UI_M_ANLY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME() {
		return COMP_UI_M_ANLY_NAME;
	}

	public void setCOMP_UI_M_ANLY_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL) {
		this.COMP_UI_M_ANLY_NAME_LABEL = COMP_UI_M_ANLY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ANLY_NAME(HtmlInputText COMP_UI_M_ANLY_NAME) {
		this.COMP_UI_M_ANLY_NAME = COMP_UI_M_ANLY_NAME;
	}

	public HtmlOutputLabel getCOMP_APS_ANLY_CODE_2_LABEL() {
		return COMP_APS_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_APS_ANLY_CODE_2() {
		return COMP_APS_ANLY_CODE_2;
	}

	public void setCOMP_APS_ANLY_CODE_2_LABEL(
			HtmlOutputLabel COMP_APS_ANLY_CODE_2_LABEL) {
		this.COMP_APS_ANLY_CODE_2_LABEL = COMP_APS_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_APS_ANLY_CODE_2(HtmlInputText COMP_APS_ANLY_CODE_2) {
		this.COMP_APS_ANLY_CODE_2 = COMP_APS_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_NAME_1_LABEL() {
		return COMP_UI_M_ANLY_NAME_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME_1() {
		return COMP_UI_M_ANLY_NAME_1;
	}

	public void setCOMP_UI_M_ANLY_NAME_1_LABEL(
			HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL) {
		this.COMP_UI_M_ANLY_NAME_1_LABEL = COMP_UI_M_ANLY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ANLY_NAME_1(HtmlInputText COMP_UI_M_ANLY_NAME_1) {
		this.COMP_UI_M_ANLY_NAME_1 = COMP_UI_M_ANLY_NAME_1;
	}

	public HtmlOutputLabel getCOMP_APS_ACTY_CODE_1_LABEL() {
		return COMP_APS_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_APS_ACTY_CODE_1() {
		return COMP_APS_ACTY_CODE_1;
	}

	public void setCOMP_APS_ACTY_CODE_1_LABEL(
			HtmlOutputLabel COMP_APS_ACTY_CODE_1_LABEL) {
		this.COMP_APS_ACTY_CODE_1_LABEL = COMP_APS_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_APS_ACTY_CODE_1(HtmlInputText COMP_APS_ACTY_CODE_1) {
		this.COMP_APS_ACTY_CODE_1 = COMP_APS_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_NAME_LABEL() {
		return COMP_UI_M_ACTY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME() {
		return COMP_UI_M_ACTY_NAME;
	}

	public void setCOMP_UI_M_ACTY_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL) {
		this.COMP_UI_M_ACTY_NAME_LABEL = COMP_UI_M_ACTY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME(HtmlInputText COMP_UI_M_ACTY_NAME) {
		this.COMP_UI_M_ACTY_NAME = COMP_UI_M_ACTY_NAME;
	}

	public HtmlOutputLabel getCOMP_APS_ACTY_CODE_2_LABEL() {
		return COMP_APS_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_APS_ACTY_CODE_2() {
		return COMP_APS_ACTY_CODE_2;
	}

	public void setCOMP_APS_ACTY_CODE_2_LABEL(
			HtmlOutputLabel COMP_APS_ACTY_CODE_2_LABEL) {
		this.COMP_APS_ACTY_CODE_2_LABEL = COMP_APS_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_APS_ACTY_CODE_2(HtmlInputText COMP_APS_ACTY_CODE_2) {
		this.COMP_APS_ACTY_CODE_2 = COMP_APS_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_NAME_1_LABEL() {
		return COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME_1() {
		return COMP_UI_M_ACTY_NAME_1;
	}

	public void setCOMP_UI_M_ACTY_NAME_1_LABEL(
			HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL) {
		this.COMP_UI_M_ACTY_NAME_1_LABEL = COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME_1(HtmlInputText COMP_UI_M_ACTY_NAME_1) {
		this.COMP_UI_M_ACTY_NAME_1 = COMP_UI_M_ACTY_NAME_1;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_PROD_CODE_FM_LOV() {
		return COMP_UI_M_APS_PROD_CODE_FM_LOV;
	}

	public void setCOMP_UI_M_APS_PROD_CODE_FM_LOV(
			HtmlCommandButton COMP_UI_M_APS_PROD_CODE_FM_LOV) {
		this.COMP_UI_M_APS_PROD_CODE_FM_LOV = COMP_UI_M_APS_PROD_CODE_FM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_PROD_CODE_TO_LOV() {
		return COMP_UI_M_APS_PROD_CODE_TO_LOV;
	}

	public void setCOMP_UI_M_APS_PROD_CODE_TO_LOV(
			HtmlCommandButton COMP_UI_M_APS_PROD_CODE_TO_LOV) {
		this.COMP_UI_M_APS_PROD_CODE_TO_LOV = COMP_UI_M_APS_PROD_CODE_TO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_COVER_CODE_FM_LOV() {
		return COMP_UI_M_APS_COVER_CODE_FM_LOV;
	}

	public void setCOMP_UI_M_APS_COVER_CODE_FM_LOV(
			HtmlCommandButton COMP_UI_M_APS_COVER_CODE_FM_LOV) {
		this.COMP_UI_M_APS_COVER_CODE_FM_LOV = COMP_UI_M_APS_COVER_CODE_FM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_COVER_CODE_TO_LOV() {
		return COMP_UI_M_APS_COVER_CODE_TO_LOV;
	}

	public void setCOMP_UI_M_APS_COVER_CODE_TO_LOV(
			HtmlCommandButton COMP_UI_M_APS_COVER_CODE_TO_LOV) {
		this.COMP_UI_M_APS_COVER_CODE_TO_LOV = COMP_UI_M_APS_COVER_CODE_TO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_MAIN_ACNT_CODE_LOV() {
		return COMP_UI_M_APS_MAIN_ACNT_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_MAIN_ACNT_CODE_LOV(
			HtmlCommandButton COMP_UI_M_APS_MAIN_ACNT_CODE_LOV) {
		this.COMP_UI_M_APS_MAIN_ACNT_CODE_LOV = COMP_UI_M_APS_MAIN_ACNT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_SUB_ACNT_CODE_LOV() {
		return COMP_UI_M_APS_SUB_ACNT_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_SUB_ACNT_CODE_LOV(
			HtmlCommandButton COMP_UI_M_APS_SUB_ACNT_CODE_LOV) {
		this.COMP_UI_M_APS_SUB_ACNT_CODE_LOV = COMP_UI_M_APS_SUB_ACNT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_DIVN_CODE_LOV() {
		return COMP_UI_M_APS_DIVN_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_DIVN_CODE_LOV(
			HtmlCommandButton COMP_UI_M_APS_DIVN_CODE_LOV) {
		this.COMP_UI_M_APS_DIVN_CODE_LOV = COMP_UI_M_APS_DIVN_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_DEPT_CODE_LOV() {
		return COMP_UI_M_APS_DEPT_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_DEPT_CODE_LOV(
			HtmlCommandButton COMP_UI_M_APS_DEPT_CODE_LOV) {
		this.COMP_UI_M_APS_DEPT_CODE_LOV = COMP_UI_M_APS_DEPT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_ANLY_CODE_1_LOV() {
		return COMP_UI_M_APS_ANLY_CODE_1_LOV;
	}

	public void setCOMP_UI_M_APS_ANLY_CODE_1_LOV(
			HtmlCommandButton COMP_UI_M_APS_ANLY_CODE_1_LOV) {
		this.COMP_UI_M_APS_ANLY_CODE_1_LOV = COMP_UI_M_APS_ANLY_CODE_1_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_ANLY_CODE_2_LOV() {
		return COMP_UI_M_APS_ANLY_CODE_2_LOV;
	}

	public void setCOMP_UI_M_APS_ANLY_CODE_2_LOV(
			HtmlCommandButton COMP_UI_M_APS_ANLY_CODE_2_LOV) {
		this.COMP_UI_M_APS_ANLY_CODE_2_LOV = COMP_UI_M_APS_ANLY_CODE_2_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_ACTY_CODE_1_LOV() {
		return COMP_UI_M_APS_ACTY_CODE_1_LOV;
	}

	public void setCOMP_UI_M_APS_ACTY_CODE_1_LOV(
			HtmlCommandButton COMP_UI_M_APS_ACTY_CODE_1_LOV) {
		this.COMP_UI_M_APS_ACTY_CODE_1_LOV = COMP_UI_M_APS_ACTY_CODE_1_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_ACTY_CODE_2_LOV() {
		return COMP_UI_M_APS_ACTY_CODE_2_LOV;
	}

	public void setCOMP_UI_M_APS_ACTY_CODE_2_LOV(
			HtmlCommandButton COMP_UI_M_APS_ACTY_CODE_2_LOV) {
		this.COMP_UI_M_APS_ACTY_CODE_2_LOV = COMP_UI_M_APS_ACTY_CODE_2_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_NARRATION_CODE_LOV() {
		return COMP_UI_M_APS_NARRATION_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_NARRATION_CODE_LOV(
			HtmlCommandButton COMP_UI_M_APS_NARRATION_CODE_LOV) {
		this.COMP_UI_M_APS_NARRATION_CODE_LOV = COMP_UI_M_APS_NARRATION_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_SRC_BUS_FM_LOV() {
		return COMP_UI_M_SRC_BUS_FM_LOV;
	}

	public void setCOMP_UI_M_SRC_BUS_FM_LOV(
			HtmlCommandButton COMP_UI_M_SRC_BUS_FM_LOV) {
		this.COMP_UI_M_SRC_BUS_FM_LOV = COMP_UI_M_SRC_BUS_FM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_SRC_BUS_TO_LOV() {
		return COMP_UI_M_SRC_BUS_TO_LOV;
	}

	public void setCOMP_UI_M_SRC_BUS_TO_LOV(
			HtmlCommandButton COMP_UI_M_SRC_BUS_TO_LOV) {
		this.COMP_UI_M_SRC_BUS_TO_LOV = COMP_UI_M_SRC_BUS_TO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_DIVN_FM_CODE_LOV() {
		return COMP_UI_M_APS_DIVN_FM_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_DIVN_FM_CODE_LOV(
			HtmlCommandButton COMP_UI_M_APS_DIVN_FM_CODE_LOV) {
		this.COMP_UI_M_APS_DIVN_FM_CODE_LOV = COMP_UI_M_APS_DIVN_FM_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_DIVN_TO_CODE_LOV() {
		return COMP_UI_M_APS_DIVN_TO_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_DIVN_TO_CODE_LOV(
			HtmlCommandButton COMP_UI_M_APS_DIVN_TO_CODE_LOV) {
		this.COMP_UI_M_APS_DIVN_TO_CODE_LOV = COMP_UI_M_APS_DIVN_TO_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_DEPT_FM_CODE_LOV() {
		return COMP_UI_M_APS_DEPT_FM_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_DEPT_FM_CODE_LOV(
			HtmlCommandButton COMP_UI_M_APS_DEPT_FM_CODE_LOV) {
		this.COMP_UI_M_APS_DEPT_FM_CODE_LOV = COMP_UI_M_APS_DEPT_FM_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_DEPT_TO_CODE_LOV() {
		return COMP_UI_M_APS_DEPT_TO_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_DEPT_TO_CODE_LOV(
			HtmlCommandButton COMP_UI_M_APS_DEPT_TO_CODE_LOV) {
		this.COMP_UI_M_APS_DEPT_TO_CODE_LOV = COMP_UI_M_APS_DEPT_TO_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_DOC_FM_TYPE_LOV() {
		return COMP_UI_M_APS_DOC_FM_TYPE_LOV;
	}

	public void setCOMP_UI_M_APS_DOC_FM_TYPE_LOV(
			HtmlCommandButton COMP_UI_M_APS_DOC_FM_TYPE_LOV) {
		this.COMP_UI_M_APS_DOC_FM_TYPE_LOV = COMP_UI_M_APS_DOC_FM_TYPE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_DOC_TO_TYPE_LOV() {
		return COMP_UI_M_APS_DOC_TO_TYPE_LOV;
	}

	public void setCOMP_UI_M_APS_DOC_TO_TYPE_LOV(
			HtmlCommandButton COMP_UI_M_APS_DOC_TO_TYPE_LOV) {
		this.COMP_UI_M_APS_DOC_TO_TYPE_LOV = COMP_UI_M_APS_DOC_TO_TYPE_LOV;
	}

	public PM_IL_ANNUITY_PYMT_SETUP getPM_IL_ANNUITY_PYMT_SETUP_BEAN() {
		return PM_IL_ANNUITY_PYMT_SETUP_BEAN;
	}

	public void setPM_IL_ANNUITY_PYMT_SETUP_BEAN(
			PM_IL_ANNUITY_PYMT_SETUP PM_IL_ANNUITY_PYMT_SETUP_BEAN) {
		this.PM_IL_ANNUITY_PYMT_SETUP_BEAN = PM_IL_ANNUITY_PYMT_SETUP_BEAN;
	}

	public void validateAPS_FRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN
						.setAPS_FRZ_FLAG(PELConstants.CHECKBOX_CHECKED);
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN
						.setAPS_FRZ_FLAG(PELConstants.CHECKBOX_UNCHECKED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void saveRecord() {
		String message = "";
		try {
			if (getPM_IL_ANNUITY_PYMT_SETUP_BEAN().getROWID() != null) {
				preUpdate();
				new CRUDHandler().executeUpdate(
						getPM_IL_ANNUITY_PYMT_SETUP_BEAN(), CommonUtils
								.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
			} else {
				preInsert();
				new CRUDHandler().executeInsert(
						getPM_IL_ANNUITY_PYMT_SETUP_BEAN(), CommonUtils
								.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save");
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	private void preInsert() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String userName = (String) sessionMap.get("GLOBAL.M_USER_ID");
		PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_CR_UID(userName);
		PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_CR_DT(new java.util.Date());
		try {
			L_CHECK_SEQ_NO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String deleteRecord() {
		Connection conn = null;
		try {
			conn = getConnection();
			getHandler().executeDelete(PM_IL_ANNUITY_PYMT_SETUP_BEAN, conn);
			conn.commit();
			PM_IL_ANNUITY_PYMT_SETUP_BEAN = new PM_IL_ANNUITY_PYMT_SETUP();
			resetAllComponent();
			getWarningMap().put(
					"deleteRow",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
		return "";
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_APS_SRC_BUS_FM.resetValue();
		COMP_APS_SRC_BUS_TO.resetValue();
		COMP_APS_DIVN_FM_CODE.resetValue();
		COMP_APS_DIVN_TO_CODE.resetValue();
		COMP_APS_DEPT_FM_CODE.resetValue();
		COMP_APS_DEPT_TO_CODE.resetValue();
		COMP_APS_DOC_FM_TYPE.resetValue();
		COMP_APS_DOC_TO_TYPE.resetValue();
		COMP_APS_PROD_CODE_FM.resetValue();
		COMP_APS_PROD_CODE_TO.resetValue();
		COMP_APS_POL_YR_FM.resetValue();
		COMP_APS_POL_YR_TO.resetValue();
		COMP_APS_COVER_CODE_FM.resetValue();
		COMP_APS_COVER_CODE_TO.resetValue();
		COMP_APS_SEQ_NO.resetValue();
		COMP_APS_NARRATION_CODE.resetValue();
		COMP_APS_MAIN_ACNT_CODE.resetValue();
		COMP_UI_M_MAIN_ACNT_NAME.resetValue();
		COMP_APS_SUB_ACNT_CODE.resetValue();
		COMP_UI_M_SUB_ACNT_NAME.resetValue();
		COMP_APS_DIVN_CODE.resetValue();
		COMP_UI_M_DIVN_NAME.resetValue();
		COMP_APS_DEPT_CODE.resetValue();
		COMP_UI_M_DEPT_NAME.resetValue();
		COMP_APS_ANLY_CODE_1.resetValue();
		COMP_UI_M_ANLY_NAME.resetValue();
		COMP_APS_ANLY_CODE_2.resetValue();
		COMP_UI_M_ANLY_NAME_1.resetValue();
		COMP_APS_ACTY_CODE_1.resetValue();
		COMP_UI_M_ACTY_NAME.resetValue();
		COMP_APS_ACTY_CODE_2.resetValue();
		COMP_UI_M_ACTY_NAME_1.resetValue();
		COMP_APS_SETUP_FOR.resetValue();
		COMP_APS_DRCR_FLAG.resetValue();
		COMP_APS_FORCE_DIVN_YN.resetValue();
		COMP_APS_FORCE_DEPT_YN.resetValue();

	}

	public void checkBoxAPS_FRZ_FLAG(ActionEvent event) {
		String checkValue = (String) ((UIInput) event.getComponent()
				.getParent()).getSubmittedValue();
		if ("true".equals(checkValue)) {
			PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_FRZ_FLAG("Y");
		} else {
			PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_FRZ_FLAG("N");
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				if (PM_IL_ANNUITY_PYMT_SETUP_BEAN.getROWID() != null) {
					executeSelectStatement(PM_IL_ANNUITY_PYMT_SETUP_BEAN
							.getROWID());
					postQuery(PM_IL_ANNUITY_PYMT_SETUP_BEAN);
					getCOMP_APS_FORCE_DEPT_YN().setDisabled(true);
				} else {
					whenNewRecordInstance(this);
					whenCreateRecord();
				}
			}
			setBlockFlag(false);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ON LOAD", e.getMessage());
		}
	}

	public void executeSelectStatement(String rowId) throws Exception {
		String selectQuery = "SELECT ROWID, PM_IL_ANNUITY_PYMT_SETUP.* FROM PM_IL_ANNUITY_PYMT_SETUP WHERE ROWID='"
				+ rowId + "'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_ANNUITY_PYMT_SETUP> list = null;

		try {
			con = CommonUtils.getConnection();
			list = handler.fetch(selectQuery,
					"com.iii.pel.forms.PILM085_APAC.PM_IL_ANNUITY_PYMT_SETUP",
					con);
			setPM_IL_ANNUITY_PYMT_SETUP_BEAN(list.get(0));
			setUpdate(true);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public Connection getConnection() throws Exception {
		Connection con = CommonUtils.getConnection();
		return con;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	public List<LovBean> lovAPS_SRC_BUS_FM(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_SRC_BUS_FM", "SRC_BUS_TY",
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_NARRATION_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_NARRATION_CODE",
					"IL_ACCDESC", null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_SRC_BUS_TO(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_SRC_BUS_TO", "SRC_BUS_TY",
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_DIVN_FM_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {

			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_DIVN_FM_CODE", CommonUtils
							.getControlBean().getM_COMP_CODE(), null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_DIVN_TO_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_DIVN_TO_CODE", CommonUtils
							.getControlBean().getM_COMP_CODE(), null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_DEPT_FM_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_DEPT_FM_CODE", CommonUtils
							.getControlBean().getM_COMP_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_FM_CODE(), null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_DEPT_TO_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_DEPT_TO_CODE", CommonUtils
							.getControlBean().getM_COMP_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_TO_CODE(), null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_DOC_FM_TYPE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_DOC_FM_TYPE", "2", null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_DOC_TO_TYPE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_DOC_TO_TYPE", "2", null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_PROD_CODE_FM(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_PROD_CODE_FM", null, null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_PROD_CODE_TO(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_PROD_CODE_TO", null, null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_COVER_CODE_FM(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_COVER_CODE_FM", "A", "S",
					"B", null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_COVER_CODE_TO(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_COVER_CODE_TO", "A", "S",
					"B", null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_MAIN_ACNT_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_MAIN_ACNT_CODE", null,
					null, null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List lovAPS_SUB_ACNT_CODE(Object obj) throws Exception {
		ArrayList suggesionList = new ArrayList();
		String APS_MAIN_ACNT_CODE = (String) getCOMP_APS_MAIN_ACNT_CODE()
				.getValue();
		String query = "";
		if (obj.toString().equals("*")) {
			query = "SELECT SUB_ACNT_CODE,SUB_ACNT_NAME FROM FM_SUB_ACCOUNT "
					+ "WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE FROM FM_MAIN_SUB "
					+ "WHERE MS_MAIN_ACNT_CODE = '"
					+ APS_MAIN_ACNT_CODE
					+ "') AND NVL(SUB_FRZ_FLAG,'N') = 'N' AND rownum < 25 ORDER BY 1 ASC";
		} else {
			query = "SELECT SUB_ACNT_CODE,SUB_ACNT_NAME FROM FM_SUB_ACCOUNT "
					+ "WHERE SUB_ACNT_CODE LIKE '"
					+ obj
					+ "%' AND SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE FROM FM_MAIN_SUB "
					+ "WHERE MS_MAIN_ACNT_CODE = '"
					+ APS_MAIN_ACNT_CODE
					+ "') AND NVL(SUB_FRZ_FLAG,'N') = 'N' AND rownum < 25 ORDER BY 1 ASC";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,
				getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("SUB_ACNT_CODE"));
			bean.setName(rs.getString("SUB_ACNT_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}

	public List<LovBean> lovAPS_DIVN_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_DIVN_CODE", CommonUtils
							.getControlBean().getM_COMP_CODE(), null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_DEPT_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_DEPT_CODE", CommonUtils
							.getControlBean().getM_COMP_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_CODE(), null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_ANLY_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_ANLY_CODE_1", "1", null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_ANLY_CODE_2(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM085_APAC",
					"PM_IL_ANNUITY_PYMT_SETUP", "APS_ANLY_CODE_2", "2", null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public List<LovBean> lovAPS_ACTY_CODE(Object currValue)
			throws SQLException, Exception {
		ArrayList suggesionList = new ArrayList();
		String APS_MAIN_ACNT_CODE = (String) getCOMP_APS_MAIN_ACNT_CODE()
				.getValue();

		String query = "";
		if (currValue.toString().equals("*")) {
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE rownum < 25 ORDER BY 1 ASC";
		} else {
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE AVAL_CODE = '"
					+ currValue + "%' AND  rownum < 25 ORDER BY 1 ASC";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,
				getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("AVAL_CODE"));
			bean.setName(rs.getString("AVAL_VALUE_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}

	public List lovAPS_ACTY_CODE_2(Object obj) throws Exception {
		ArrayList suggesionList = new ArrayList();
		String APS_MAIN_ACNT_CODE = (String) getCOMP_APS_MAIN_ACNT_CODE()
				.getValue();

		// SELECT * FROM FM_ACTY_VALUE
		// AVAL_ACTY_CODE='&M_PARA_1'

		String query = "";
		if (obj.toString().equals("*")) {
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE rownum < 25 ORDER BY 1 ASC";
		} else {
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE AVAL_CODE = '"
					+ obj + "%' AND  rownum < 25 ORDER BY 1 ASC";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,
				getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("AVAL_CODE"));
			bean.setName(rs.getString("AVAL_VALUE_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}

	public void postQuery(PM_IL_ANNUITY_PYMT_SETUP PM_IL_ANNUITY_PYMT_SETUP_BEAN) {

		CTRL CTRL_BEAN = null;
		ArrayList<String> list = new ArrayList<String>();
		try {

			list = new DBProcedures().P_VAL_MAIN_ACNT(
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_MAIN_ACNT_CODE(), "N",
					"N");
			if (list != null && !(list.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(list
						.get(0));
				list.clear();
			}
			list = new DBProcedures().P_VAL_SUB_ACNT(
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_MAIN_ACNT_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SUB_ACNT_CODE(), "N",
					"N");
			if (list != null && !(list.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN
						.setUI_M_SUB_ACNT_NAME(list.get(0));
				list.clear();
			}

			L_GET_ACTY_DETAILS();

			list = new DBProcedures().P_VAL_ANLY("1",
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_ANLY_CODE_1(), "N",
					"N");
			if (list != null && !(list.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setUI_M_ANLY_NAME(list.get(0));
				list.clear();
			}
			list = new DBProcedures().P_VAL_ANLY("2",
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_ANLY_CODE_2(), "N",
					"N");
			if (list != null && !(list.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setUI_M_ANLY_NAME_1(list.get(0));
				// :PM_IL_ANNUITY_PYMT_SETUP.M_ANLY_NAME_1,
				list.clear();
			}

			String deptName = new DBProcedures().P_VAL_DEPT(
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_CODE(), "N", "N");

			if (deptName != null) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setUI_M_DEPT_NAME(deptName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void L_GET_ACTY_DETAILS() {
		String C1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM FM_MAIN_ACCOUNT WHERE MAIN_ACNT_CODE = ? ";
		CTRL CTRL_BEAN = null;
		String M_ACTY_HEAD_1 = null;// FM_MAIN_APSOUNT.MAIN_ACTY_CODE_1%TYPE;
		String M_ACTY_HEAD_2 = null; // FM_MAIN_APSOUNT.MAIN_ACTY_CODE_2%TYPE;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_MAIN_ACNT_CODE()});
			if (resultSet.next()) {

				M_ACTY_HEAD_1 = resultSet.getString(1);
				M_ACTY_HEAD_2 = resultSet.getString(2);
			}
			CTRL_BEAN.setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
			CTRL_BEAN.setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void whenCreateRecord() {
		PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_FORCE_DIVN_YN("N");
		PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_FORCE_DEPT_YN("N");
		PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SETUP_FOR("A");
		PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DRCR_FLAG("C");
		PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_FRZ_FLAG("N");

		this.getCOMP_APS_DIVN_CODE().setRequired(true);
		this.getCOMP_APS_DEPT_CODE().setRequired(true);
		this.getCOMP_APS_FORCE_DEPT_YN().setDisabled(true);

	}

	public void whenNewRecordInstance(PM_IL_ANNUITY_PYMT_SETUP_ACTION action)
			throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		Object[] values = null;
		String M_FLAG = null;

		try {
			String C1 = " SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM FM_MAIN_ACCOUNT "
					+ " WHERE  MAIN_ACNT_CODE = ? ";
			String C2 = " SELECT ACTY_NAME FROM FM_ACTIVITY WHERE ACTY_CODE = ? ";
			String C3 = " SELECT ACTY_NAME FROM FM_ACTIVITY WHERE ACTY_CODE = ? ";
			String M_TEMP1 = null;
			String M_TEMP2 = null;
			connection = CommonUtils.getConnection();
			values = new Object[] { PM_IL_ANNUITY_PYMT_SETUP_BEAN
					.getAPS_MAIN_ACNT_CODE() };
			resultSet1 = handler.executeSelectStatement(C1, connection, values);
			values = new Object[] { PM_IL_ANNUITY_PYMT_SETUP_BEAN
					.getUI_M_ACTY_1() };
			resultSet2 = handler.executeSelectStatement(C2, connection, values);
			values = new Object[] { PM_IL_ANNUITY_PYMT_SETUP_BEAN
					.getUI_M_ACTY_2() };
			resultSet3 = handler.executeSelectStatement(C1, connection, values);

			if (resultSet1.next()) {
				M_TEMP1 = resultSet1.getString(1);
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setUI_M_ACTY_1(M_TEMP1);
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setUI_M_ACTY_2(M_TEMP1);
				if (PM_IL_ANNUITY_PYMT_SETUP_BEAN.getUI_M_ACTY_1() != null) {
					if (resultSet2.next())
						M_TEMP1 = resultSet2.getString(1);
					action.getCOMP_APS_ACTY_CODE_1_LABEL().setValue(M_TEMP1);
				} else {
					action.getCOMP_APS_ACTY_CODE_1().setValue("Activity code1");
				}
				if (PM_IL_ANNUITY_PYMT_SETUP_BEAN.getUI_M_ACTY_2() != null) {
					if (resultSet3.next())
						M_TEMP2 = resultSet3.getString(1);
					action.getCOMP_APS_ACTY_CODE_2().setValue(M_TEMP2);
				} else {
					action.getCOMP_APS_ACTY_CODE_2().setValue("Activity code2");
				}

				action.getCOMP_APS_FORCE_DEPT_YN().setDisabled(true);

				if ("Y".equals(CommonUtils.nvl(PM_IL_ANNUITY_PYMT_SETUP_BEAN
						.getAPS_FORCE_DIVN_YN(), "N"))) {
					action.getCOMP_APS_DIVN_CODE().setDisabled(true);
					action.getCOMP_APS_DIVN_CODE().setRequired(false);
				}
				if ("N".equals(CommonUtils.nvl(PM_IL_ANNUITY_PYMT_SETUP_BEAN
						.getAPS_FORCE_DIVN_YN(), "N"))) {
					action.getCOMP_APS_DIVN_CODE().setDisabled(false);
					action.getCOMP_APS_DIVN_CODE().setRequired(true);
				}
				if ("Y".equals(CommonUtils.nvl(PM_IL_ANNUITY_PYMT_SETUP_BEAN
						.getAPS_FORCE_DEPT_YN(), "N"))) {
					action.getCOMP_APS_DEPT_CODE().setDisabled(true);
					action.getCOMP_APS_DEPT_CODE().setRequired(false);
				}
				if ("N".equals(CommonUtils.nvl(PM_IL_ANNUITY_PYMT_SETUP_BEAN
						.getAPS_FORCE_DEPT_YN(), "N"))) {
					action.getCOMP_APS_DEPT_CODE().setDisabled(false);
					action.getCOMP_APS_DEPT_CODE().setRequired(true);
				}
			}
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
			}
		}
	}

	public void whenValidateAPS_SRC_BUS_FM(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				COMP_APS_SRC_BUS_FM.setSubmittedValue(currentValue);
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SRC_BUS_FM(currentValue);
			} else {
				COMP_APS_SRC_BUS_FM.setSubmittedValue("0");
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SRC_BUS_FM("0");
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SRC BUS FM", e.getMessage());
		}
	}

	public void whenValidateAPS_SRC_BUS_TO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SRC_BUS_TO(currentValue);

			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SRC_BUS_TO("ZZZZZZ");
			}
			COMP_APS_SRC_BUS_TO.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SRC BUS TO ", e.getMessage());
		}
	}

	/*
	 * public List<LovBean> lovAPS_DIVN_FM_CODE(Object currValue) { ArrayList<LovBean>
	 * suggestionList = new ArrayList<LovBean>(); ListItemUtil listitemutil =
	 * new ListItemUtil(); try { suggestionList =
	 * listitemutil.P_CALL_LOV("PILM085_APAC", "PM_IL_ANNUITY_PYMT_SETUP",
	 * "APS_DIVN_FM_CODE", CommonUtils .getControlBean().getM_COMP_CODE(), null,
	 * null, null, null, (String) currValue); } catch (Exception e) {
	 * e.printStackTrace(); } return suggestionList; }
	 */
	/*
	 * public List<LovBean> lovAPS_DIVN_TO_CODE(Object currValue) { ArrayList<LovBean>
	 * suggestionList = new ArrayList<LovBean>(); ListItemUtil listitemutil =
	 * new ListItemUtil(); try { suggestionList =
	 * listitemutil.P_CALL_LOV("PILM085_APAC", "PM_IL_ANNUITY_PYMT_SETUP",
	 * "APS_DIVN_TO_CODE", CommonUtils .getControlBean().getM_COMP_CODE(), null,
	 * null, null, null, (String) currValue); } catch (Exception e) {
	 * e.printStackTrace(); } return suggestionList; }
	 */

	public void whenValidateDIV_FM(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DIVN_FM_CODE(currentValue);
				COMP_APS_DIVN_FM_CODE.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DIVN_FM_CODE("0");
				COMP_APS_DIVN_FM_CODE.resetValue();
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DIVN CODE FM ", e.getMessage());
		}
	}

	public void whenValidateDIV_TO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DIVN_TO_CODE(currentValue);
				COMP_APS_DIVN_TO_CODE.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DIVN_TO_CODE("ZZZZZZ");
				COMP_APS_DIVN_TO_CODE.resetValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DIVN CODE TO ", e.getMessage());
		}
	}

	public void whenValidateDEPT_FM(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DEPT_FM_CODE(currentValue);
				COMP_APS_DEPT_FM_CODE.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DEPT_FM_CODE("0");
				COMP_APS_DEPT_FM_CODE.resetValue();
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DEPT CODE FM ", e.getMessage());
		}
	}

	public void whenValidateDEPT_TO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DEPT_TO_CODE(currentValue);
				COMP_APS_DEPT_TO_CODE.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DEPT_TO_CODE("ZZZZZZ");
				COMP_APS_DEPT_TO_CODE.resetValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DEPT CODE TO ", e.getMessage());
		}
	}

	public void whenValidateDOC_FM(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DOC_FM_TYPE(currentValue);
				COMP_APS_DOC_FM_TYPE.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DOC_FM_TYPE("0");
				COMP_APS_DOC_FM_TYPE.resetValue();
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DOC CODE FM ", e.getMessage());
		}
	}

	public void whenValidateDOC_TO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DOC_TO_TYPE(currentValue);
				COMP_APS_DOC_TO_TYPE.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_DOC_TO_TYPE("ZZZZZZ");
				COMP_APS_DOC_TO_TYPE.resetValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DOC CODE TO ", e.getMessage());
		}
	}

	public void whenValidatePROD_FM(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_PROD_CODE_FM(currentValue);
				COMP_APS_PROD_CODE_FM.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_PROD_CODE_FM("0");
				COMP_APS_PROD_CODE_FM.resetValue();
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PROD CODE FM ", e.getMessage());
		}
	}

	public void whenValidatePROD_TO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_PROD_CODE_TO(currentValue);
				COMP_APS_PROD_CODE_TO.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_PROD_CODE_TO("ZZZZZZ");
				COMP_APS_PROD_CODE_TO.resetValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PROD CODE TO ", e.getMessage());
		}
	}
	
	public void whenValidatePOL_YR_FM(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
		if (currentValue.isEmpty()) {
			getCOMP_APS_POL_YR_FM().setSubmittedValue("0");
			PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_POL_YR_FM(0);
		} else {
			PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_POL_YR_FM(Integer
					.parseInt(currentValue));

		}

		if (currentValue != null && !currentValue.isEmpty()) {
			Integer yrsFm = PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_FM();
			Integer yrsTo = PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_TO();
			if (yrsFm < 0) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91018"));
			}
			if (yrsTo != null) {
				if (yrsFm > yrsTo) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91031"));
				}
			}
			if ((!"".equals(currentValue)) && (!(currentValue == null))) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_POL_YR_FM(Integer
						.parseInt(currentValue));
				COMP_APS_POL_YR_FM.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_POL_YR_FM(0);
				COMP_APS_POL_YR_FM.resetValue();
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POLICY YEARS FM ", e.getMessage());
		}
	}

	public void whenValidatePOL_YR_TO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if (currentValue.isEmpty()) {
				getCOMP_APS_POL_YR_TO().setSubmittedValue("99");
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_POL_YR_TO(99);
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_POL_YR_TO(Integer
						.parseInt(currentValue));

			}

			if (currentValue != null && !currentValue.isEmpty()) {
				Integer yrsFm = PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_FM();
				Integer yrsTo = PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_TO();
				if (yrsTo < 0) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91018"));
				}
				if (yrsFm != null) {
					if (yrsFm > yrsTo) {
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "91031"));
					}
				}
				if ((!"".equals(currentValue)) && (!(currentValue == null))) {
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_POL_YR_TO(Integer
							.parseInt(currentValue));
					COMP_APS_POL_YR_TO.resetValue();
				} else {
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_POL_YR_TO(99);
					COMP_APS_POL_YR_FM.resetValue();
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("POLICY YEARS TO ", e.getMessage());
			}
		}
	public void whenValidateCOVER_FM(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN
						.setAPS_COVER_CODE_FM(currentValue);
				COMP_APS_COVER_CODE_FM.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_COVER_CODE_FM("0");
				COMP_APS_COVER_CODE_FM.resetValue();
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("COVER CODE FM ", e.getMessage());
		}
	}

	public void whenValidateCOVER_TO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if ((!"".equals(currentValue)) && (!currentValue.isEmpty())) {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN
						.setAPS_COVER_CODE_TO(currentValue);
				COMP_APS_COVER_CODE_TO.resetValue();
			} else {
				PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_COVER_CODE_TO("ZZZZZZ");
				COMP_APS_COVER_CODE_TO.resetValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("COVER CODE TO ", e.getMessage());
		}
	}

	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_APS_SRC_BUS_FM = new HtmlInputText();
		COMP_APS_SRC_BUS_TO = new HtmlInputText();
		COMP_APS_DIVN_FM_CODE = new HtmlInputText();
		COMP_APS_DIVN_TO_CODE = new HtmlInputText();
		COMP_APS_DEPT_FM_CODE = new HtmlInputText();
		COMP_APS_DEPT_TO_CODE = new HtmlInputText();
		COMP_APS_DOC_FM_TYPE = new HtmlInputText();
		COMP_APS_DOC_TO_TYPE = new HtmlInputText();
		COMP_APS_PROD_CODE_FM = new HtmlInputText();
		COMP_APS_PROD_CODE_TO = new HtmlInputText();
		COMP_APS_POL_YR_FM = new HtmlInputText();
		COMP_APS_POL_YR_TO = new HtmlInputText();
		COMP_APS_COVER_CODE_FM = new HtmlInputText();
		COMP_APS_COVER_CODE_TO = new HtmlInputText();
		COMP_APS_SEQ_NO = new HtmlInputText();
		COMP_APS_NARRATION_CODE = new HtmlInputText();
		COMP_APS_MAIN_ACNT_CODE = new HtmlInputText();
		COMP_UI_M_MAIN_ACNT_NAME = new HtmlInputText();
		COMP_APS_SUB_ACNT_CODE = new HtmlInputText();
		COMP_UI_M_SUB_ACNT_NAME = new HtmlInputText();
		COMP_APS_DIVN_CODE = new HtmlInputText();
		COMP_UI_M_DIVN_NAME = new HtmlInputText();
		COMP_APS_DEPT_CODE = new HtmlInputText();
		COMP_UI_M_DEPT_NAME = new HtmlInputText();
		COMP_APS_ANLY_CODE_1 = new HtmlInputText();
		COMP_UI_M_ANLY_NAME = new HtmlInputText();
		COMP_APS_ANLY_CODE_2 = new HtmlInputText();
		COMP_UI_M_ANLY_NAME_1 = new HtmlInputText();
		COMP_APS_ACTY_CODE_1 = new HtmlInputText();
		COMP_UI_M_ACTY_NAME = new HtmlInputText();
		COMP_APS_ACTY_CODE_2 = new HtmlInputText();
		COMP_UI_M_ACTY_NAME_1 = new HtmlInputText();

		COMP_APS_SETUP_FOR = new HtmlSelectOneMenu();
		COMP_APS_DRCR_FLAG = new HtmlSelectOneMenu();
		COMP_APS_FORCE_DIVN_YN = new HtmlSelectOneMenu();
		COMP_APS_FORCE_DEPT_YN = new HtmlSelectOneMenu();
	}

	public void L_CHECK_SEQ_NO() throws Exception {
		String C1 = "SELECT MAX(APS_SEQ_NO)+1 FROM PM_IL_ANNUITY_PYMT_SETUP " +
					" WHERE(? BETWEEN APS_SRC_BUS_FM AND APS_SRC_BUS_TO OR ? " +
					" BETWEEN APS_SRC_BUS_FM AND APS_SRC_BUS_TO OR " +
					" APS_SRC_BUS_FM BETWEEN ? AND ? OR APS_SRC_BUS_TO BETWEEN ?  AND ?)" +
					" AND (? BETWEEN APS_DIVN_FM_CODE AND APS_DIVN_TO_CODE OR ? " +
					" BETWEEN APS_DIVN_FM_CODE AND APS_DIVN_TO_CODE OR APS_DIVN_FM_CODE " +
					" BETWEEN ? AND ? OR APS_DIVN_TO_CODE BETWEEN ? AND ?) " +
					" AND (? BETWEEN APS_DEPT_FM_CODE AND APS_DEPT_TO_CODE OR ? " +
					" BETWEEN APS_DEPT_FM_CODE AND APS_DEPT_TO_CODE OR " +
					" APS_DEPT_FM_CODE BETWEEN ? AND ? OR APS_DEPT_TO_CODE " +
					" BETWEEN ? AND ?) AND (NVL(LPAD(?,12,'0'),'0') " +
					" BETWEEN NVL(LPAD(APS_DOC_FM_TYPE,12,'0'),'0') " +
					" AND NVL(LPAD(APS_DOC_TO_TYPE,12,'Z'),'Z') OR NVL(LPAD(?,12,'Z'),'Z') " +
					" BETWEEN NVL(LPAD(APS_DOC_FM_TYPE,12,'0'),'0') AND NVL(LPAD(APS_DOC_TO_TYPE,12,'Z'),'Z') " +
					" OR NVL(LPAD(APS_DOC_FM_TYPE,12,'0'),'0') BETWEEN NVL(LPAD(?,12,'0'),'0') " +
					" AND NVL(LPAD(?,12,'Z'),'Z') OR NVL(LPAD(APS_DOC_TO_TYPE,12,'Z'),'Z') " +
					" BETWEEN NVL(LPAD(?,12,'0'),'0') AND NVL(LPAD(?,12,'Z'),'Z')) " +
					" AND (? = APS_SETUP_FOR) AND (NVL(?,'0') BETWEEN NVL(APS_PROD_CODE_FM,'0') " +
					" AND NVL(APS_PROD_CODE_TO,'0') OR NVL(?,'0') BETWEEN NVL(APS_PROD_CODE_FM,'0') " +
					" AND NVL(APS_PROD_CODE_TO,'0') OR NVL(APS_PROD_CODE_FM,'0') BETWEEN NVL(?,'0') " +
					" AND NVL(?,'0') OR NVL(APS_PROD_CODE_TO,'0') BETWEEN NVL(?,'0') AND NVL(?,'0')) " +
					" AND (NVL(?,'0') BETWEEN NVL(APS_COVER_CODE_FM,'0') AND NVL(APS_COVER_CODE_TO,'0') " +
					" OR NVL(?,'0') BETWEEN NVL(APS_COVER_CODE_FM,'0') AND NVL(APS_COVER_CODE_TO,'0') " +
					" OR NVL(APS_COVER_CODE_FM,'0') BETWEEN NVL(?,'0') AND NVL(?,'0') OR NVL(APS_COVER_CODE_TO,'0') " +
					" BETWEEN NVL(?,'0') AND NVL(?,'0')) AND (NVL(?,0) BETWEEN NVL(APS_POL_YR_FM,0) " +
					" AND NVL(APS_POL_YR_TO,9999) OR NVL(?,9999) BETWEEN NVL(APS_POL_YR_FM,0) " +
					" AND NVL(APS_POL_YR_TO,9999) OR NVL(APS_POL_YR_FM,0) BETWEEN NVL(?,0) " +
					" AND NVL(?,9999) OR NVL(APS_POL_YR_TO,9999) BETWEEN NVL(?,0) AND NVL(?,9999))";

		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		Integer M_APS_SEQ_NO = null;
		Object[] values = null;
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			values = new Object[]{
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_FM(), 
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_FM_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_TO_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_FM_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_TO_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_FM_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_TO_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_FM_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_TO_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_FM_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_TO_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_FM_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_TO_CODE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_FM_TYPE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_TO_TYPE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_FM_TYPE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_TO_TYPE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_FM_TYPE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_TO_TYPE(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SETUP_FOR(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_TO(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_FM(),
					PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_TO()};
		
			if (PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SEQ_NO() != null) {
				C1_REC = handler.executeSelectStatement(C1, conn, values);
				if (C1_REC.next()) {
					M_APS_SEQ_NO = C1_REC.getInt(1);
				}
				if (!CommonUtils.nvl(M_APS_SEQ_NO, 1).equals(PM_IL_ANNUITY_PYMT_SETUP_BEAN
						.getAPS_SEQ_NO())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91460"));
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}

		}
	}

	private void preRecord(CTRL_ACTION bean) throws Exception {
		String C1 = " SELECT MAIN_CTL_ACNT_FLAG,MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM FM_MAIN_ACCOUNT "
				+ " WHERE  MAIN_ACNT_CODE  = ? ";
		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		Integer M_APS_SEQ_NO = null;

		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if (PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SEQ_NO() != null) {
				C1_REC = handler.executeSelectStatement(C1, conn,
						new Object[] { PM_IL_ANNUITY_PYMT_SETUP_BEAN
								.getAPS_MAIN_ACNT_CODE() });
				String M_FLAG = null;
				String M_ACTY_HEAD_1 = null;
				String M_ACTY_HEAD_2 = null;
				{
					if (C1_REC.next()) {
						M_ACTY_HEAD_1 = C1_REC.getString(1);
						M_ACTY_HEAD_2 = C1_REC.getString(1);
						M_FLAG = C1_REC.getString(1);
					} else {
						M_FLAG = "X";
					}
					if (M_FLAG != "C") {
						COMP_APS_SUB_ACNT_CODE.setRequired(false);
						COMP_APS_SUB_ACNT_CODE.setDisabled(true);
					} else {
						COMP_APS_SUB_ACNT_CODE.setDisabled(false);
						COMP_APS_SUB_ACNT_CODE.setRequired(true);
					}
				}
				if (M_ACTY_HEAD_1 == null) {
					COMP_APS_ACTY_CODE_1.setRequired(false);
					COMP_APS_ACTY_CODE_1.setDisabled(true);
				} else {
					COMP_APS_ACTY_CODE_1.setRequired(true);
					COMP_APS_ACTY_CODE_1.setDisabled(false);
				}
				if (M_ACTY_HEAD_2 == null) {
					COMP_APS_ACTY_CODE_1.setRequired(false);
					COMP_APS_ACTY_CODE_1.setDisabled(true);
				} else {
					COMP_APS_ACTY_CODE_1.setRequired(true);
					COMP_APS_ACTY_CODE_1.setDisabled(false);
				}

				bean.setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
				bean.setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
		}
	}

	private void preUpdate() throws Exception {
		/*
		 * String C1 = " SELECT 'X' FROM PM_IL_ANNUITY_PYMT_SETUP " + " WHERE
		 * APS_DRCR_FLAG= ? AND " + " (BETWEEN APS_SRC_BUS_FM AND APS_SRC_BUS_TO
		 * OR ? BETWEEN APS_SRC_BUS_FM AND APS_SRC_BUS_TO " + " OR
		 * APS_SRC_BUS_FM BETWEEN ? AND ? OR APS_SRC_BUS_TO BETWEEN ? AND ? )" + "
		 * AND (? BETWEEN APS_DIVN_FM_CODE AND APS_DIVN_TO_CODE " + " OR ?
		 * BETWEEN APS_DIVN_FM_CODE AND APS_DIVN_TO_CODE " + " OR
		 * APS_DIVN_FM_CODE BETWEEN ? AND ? " + " OR APS_DIVN_TO_CODE BETWEEN ? " + " ?
		 * AND ?) AND (? BETWEEN APS_DEPT_FM_CODE AND APS_DEPT_TO_CODE" + " OR ?
		 * BETWEEN APS_DEPT_FM_CODE AND APS_DEPT_TO_CODE OR APS_DEPT_FM_CODE " + "
		 * BETWEEN ? AND ?" + " OR APS_DEPT_TO_CODE BETWEEN ? AND ? ) AND " + "
		 * (NVL(LPAD(?,12,'0'),'0') BETWEEN
		 * NVL(LPAD(APS_DOC_FM_TYPE,12,'0'),'0') " + " AND
		 * NVL(LPAD(APS_DOC_TO_TYPE,12,'Z'),'Z') OR NVL(LPAD(? ,12,'Z'),'Z') " + "
		 * BETWEEN NVL(LPAD(APS_DOC_FM_TYPE,12,'0'),'0') AND
		 * NVL(LPAD(APS_DOC_TO_TYPE,12,'Z'),'Z')" + " OR
		 * NVL(LPAD(APS_DOC_FM_TYPE,12,'0'),'0') BETWEEN NVL(LPAD(?,12,'0'),'0')
		 * AND NVL(LPAD(?,12,'Z'),'Z') " + " OR
		 * NVL(LPAD(APS_DOC_TO_TYPE,12,'Z'),'Z') BETWEEN NVL(LPAD(?,12,'0'),'0')
		 * AND NVL(LPAD(?,12,'Z'),'Z')) " + " AND(? = APS_SETUP_FOR) AND(NVL(?
		 * ,'0') BETWEEN NVL(APS_PROD_CODE_FM,'0') AND NVL(APS_PROD_CODE_TO,'0') " + "
		 * OR NVL(? ,'0') BETWEEN NVL(APS_PROD_CODE_FM,'0') AND
		 * NVL(APS_PROD_CODE_TO,'0') OR NVL(APS_PROD_CODE_FM,'0') " + " BETWEEN
		 * NVL(?,'0') AND NVL(?,'0') OR NVL(APS_PROD_CODE_TO,'0') BETWEEN
		 * NVL(?,'0') AND NVL(?,'0')) " + " AND (NVL(? ,'0') BETWEEN
		 * NVL(APS_COVER_CODE_FM,'0') AND NVL(APS_COVER_CODE_TO,'0')OR
		 * NVL(?,'0') BETWEEN NVL(APS_COVER_CODE_FM,'0') " + " AND
		 * NVL(APS_COVER_CODE_TO,'0') OR NVL(APS_COVER_CODE_FM,'0') BETWEEN
		 * NVL(?,'0') AND " + " NVL(?,'0') OR NVL(APS_COVER_CODE_TO,'0') BETWEEN
		 * NVL(?,'0') AND NVL(?,'0')) " + " AND (NVL(?,0) BETWEEN
		 * NVL(APS_POL_YR_FM,0) AND NVL(APS_POL_YR_TO,9999) " + " OR NVL(?,9999)
		 * BETWEEN NVL(APS_POL_YR_FM,0) AND NVL(APS_POL_YR_TO,9999) " + " OR
		 * NVL(APS_POL_YR_FM,0) BETWEEN NVL(?,0) AND NVL(?,9999) " + " OR
		 * NVL(APS_POL_YR_TO,9999) BETWEEN NVL(?,0) " + " AND NVL(?,9999)) AND
		 * PM_IL_ANNUITY_PYMT_SETUP.APS_NARRATION_CODE = ? " + " AND
		 * PM_IL_ANNUITY_PYMT_SETUP.APS_SEQ_NO = ? AND
		 * PM_IL_ANNUITY_PYMT_SETUP.ROWID <> ? "; Connection conn = null;
		 * CRUDHandler handler = null; ResultSet C1_REC = null; Integer
		 * M_APS_SEQ_NO = null;
		 * 
		 * try { handler = new CRUDHandler(); conn =
		 * CommonUtils.getConnection(); if
		 * (PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SEQ_NO() != null) { C1_REC =
		 * handler.executeSelectStatement(C1, conn,new Object[] {
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DRCR_FLAG(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SRC_BUS_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_FM_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_TO_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_FM_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_TO_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_FM_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DIVN_TO_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_FM_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_TO_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_FM_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_TO_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_FM_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DEPT_TO_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_FM_TYPE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_TO_TYPE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_FM_TYPE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_TO_TYPE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_FM_TYPE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_DOC_TO_TYPE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SETUP_FOR(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_PROD_CODE_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_COVER_CODE_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_FM(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_POL_YR_TO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_NARRATION_CODE(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getAPS_SEQ_NO(),
		 * PM_IL_ANNUITY_PYMT_SETUP_BEAN.getROWID()});
		 * 
		 * String M_DUMMY = null; if (C1_REC.next()) { M_DUMMY =
		 * C1_REC.getString(1); throw new Exception(Messages.getString(
		 * PELConstants.pelErrorMessagePath, "80031")); } } } finally { try {
		 * CommonUtils.closeCursor(C1_REC); } catch (Exception exception2) { } }
		 */
	}
	
	public void whenValidateAPS_SEQ_NO(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String currentValue = (String) input.getSubmittedValue();
		try {
			if (!currentValue.isEmpty()) {
			getCOMP_APS_SEQ_NO().setSubmittedValue(Integer.valueOf(currentValue));
			PM_IL_ANNUITY_PYMT_SETUP_BEAN.setAPS_SEQ_NO(Integer.valueOf(currentValue));
			L_CHECK_SEQ_NO();
			}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Sequence No. ", e.getMessage());
			
		}
	}
	
}