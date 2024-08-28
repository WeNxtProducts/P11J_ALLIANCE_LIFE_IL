package com.iii.pel.forms.PILM041;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.login.exception.DatabaseException;
import com.iii.pel.login.servlet.ConnectionAgentServlet;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_DATA_UPLOAD_MAPPING_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DUM_MAP_CODE_LABEL;

	private HtmlInputText COMP_DUM_MAP_CODE;

	private HtmlOutputLabel COMP_DUM_MAP_CODE_DESC_LABEL;

	private HtmlInputText COMP_DUM_MAP_CODE_DESC;

	private HtmlOutputLabel COMP_DUM_DEF_CODE_LABEL;

	private HtmlInputText COMP_DUM_DEF_CODE;

	private HtmlOutputLabel COMP_UI_M_DEF_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEF_CODE_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_01_LABEL;

	private HtmlInputText COMP_DUM_FIELD_01;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_01_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_01_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_11_LABEL;

	private HtmlInputText COMP_DUM_FIELD_11;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_11_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_11_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_02_LABEL;

	private HtmlInputText COMP_DUM_FIELD_02;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_02_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_02_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_12_LABEL;

	private HtmlInputText COMP_DUM_FIELD_12;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_12_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_12_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_03_LABEL;

	private HtmlInputText COMP_DUM_FIELD_03;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_03_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_03_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_13_LABEL;

	private HtmlInputText COMP_DUM_FIELD_13;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_13_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_13_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_04_LABEL;

	private HtmlInputText COMP_DUM_FIELD_04;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_04_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_04_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_14_LABEL;

	private HtmlInputText COMP_DUM_FIELD_14;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_14_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_14_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_05_LABEL;

	private HtmlInputText COMP_DUM_FIELD_05;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_05_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_05_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_15_LABEL;

	private HtmlInputText COMP_DUM_FIELD_15;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_15_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_15_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_06_LABEL;

	private HtmlInputText COMP_DUM_FIELD_06;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_06_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_06_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_16_LABEL;

	private HtmlInputText COMP_DUM_FIELD_16;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_16_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_16_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_07_LABEL;

	private HtmlInputText COMP_DUM_FIELD_07;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_07_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_07_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_17_LABEL;

	private HtmlInputText COMP_DUM_FIELD_17;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_17_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_17_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_08_LABEL;

	private HtmlInputText COMP_DUM_FIELD_08;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_08_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_08_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_18_LABEL;

	private HtmlInputText COMP_DUM_FIELD_18;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_18_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_18_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_09_LABEL;

	private HtmlInputText COMP_DUM_FIELD_09;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_09_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_09_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_19_LABEL;

	private HtmlInputText COMP_DUM_FIELD_19;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_19_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_19_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_10_LABEL;

	private HtmlInputText COMP_DUM_FIELD_10;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_10_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_10_DESC;

	private HtmlOutputLabel COMP_DUM_FIELD_20_LABEL;

	private HtmlInputText COMP_DUM_FIELD_20;

	private HtmlOutputLabel COMP_UI_M_DUM_FIELD_20_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DUM_FIELD_20_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_01_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_02_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_03_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_05_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_06_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_07_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_08_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_09_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_10_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_11_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_12_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_13_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_14_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_15_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_16_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_17_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_18_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_19_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_20_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DUM_DEF_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_EDIT_MAP_CODE_DESC;

	private PM_IL_DATA_UPLOAD_MAPPING PM_IL_DATA_UPLOAD_MAPPING_BEAN;

	private Object codeDesc = null;

	private List<LovBean> suggesionList = null;

	private String lov_Description = null;

	Map<String, String> keyValue = new HashMap<String, String>();
	PM_IL_DATA_UPLOAD_MAPPING_Helper helper = null;

	public PM_IL_DATA_UPLOAD_MAPPING_ACTION() {
		PM_IL_DATA_UPLOAD_MAPPING_BEAN = new PM_IL_DATA_UPLOAD_MAPPING();
		helper = new PM_IL_DATA_UPLOAD_MAPPING_Helper();
		/*	added by raja on 06-03-2017 for ZBILQC-1719694 */
		setListItemValues();
		/*end*/
	}

	public HtmlOutputLabel getCOMP_DUM_MAP_CODE_LABEL() {
		return COMP_DUM_MAP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DUM_MAP_CODE() {
		return COMP_DUM_MAP_CODE;
	}

	public void setCOMP_DUM_MAP_CODE_LABEL(
			HtmlOutputLabel COMP_DUM_MAP_CODE_LABEL) {
		this.COMP_DUM_MAP_CODE_LABEL = COMP_DUM_MAP_CODE_LABEL;
	}

	public void setCOMP_DUM_MAP_CODE(HtmlInputText COMP_DUM_MAP_CODE) {
		this.COMP_DUM_MAP_CODE = COMP_DUM_MAP_CODE;
	}

	public HtmlOutputLabel getCOMP_DUM_MAP_CODE_DESC_LABEL() {
		return COMP_DUM_MAP_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DUM_MAP_CODE_DESC() {
		return COMP_DUM_MAP_CODE_DESC;
	}

	public void setCOMP_DUM_MAP_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_DUM_MAP_CODE_DESC_LABEL) {
		this.COMP_DUM_MAP_CODE_DESC_LABEL = COMP_DUM_MAP_CODE_DESC_LABEL;
	}

	public void setCOMP_DUM_MAP_CODE_DESC(HtmlInputText COMP_DUM_MAP_CODE_DESC) {
		this.COMP_DUM_MAP_CODE_DESC = COMP_DUM_MAP_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_DEF_CODE_LABEL() {
		return COMP_DUM_DEF_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DUM_DEF_CODE() {
		return COMP_DUM_DEF_CODE;
	}

	public void setCOMP_DUM_DEF_CODE_LABEL(
			HtmlOutputLabel COMP_DUM_DEF_CODE_LABEL) {
		this.COMP_DUM_DEF_CODE_LABEL = COMP_DUM_DEF_CODE_LABEL;
	}

	public void setCOMP_DUM_DEF_CODE(HtmlInputText COMP_DUM_DEF_CODE) {
		this.COMP_DUM_DEF_CODE = COMP_DUM_DEF_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEF_CODE_DESC_LABEL() {
		return COMP_UI_M_DEF_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEF_CODE_DESC() {
		return COMP_UI_M_DEF_CODE_DESC;
	}

	public void setCOMP_UI_M_DEF_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEF_CODE_DESC_LABEL) {
		this.COMP_UI_M_DEF_CODE_DESC_LABEL = COMP_UI_M_DEF_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEF_CODE_DESC(HtmlInputText COMP_UI_M_DEF_CODE_DESC) {
		this.COMP_UI_M_DEF_CODE_DESC = COMP_UI_M_DEF_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_01_LABEL() {
		return COMP_DUM_FIELD_01_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_01() {
		return COMP_DUM_FIELD_01;
	}

	public void setCOMP_DUM_FIELD_01_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_01_LABEL) {
		this.COMP_DUM_FIELD_01_LABEL = COMP_DUM_FIELD_01_LABEL;
	}

	public void setCOMP_DUM_FIELD_01(HtmlInputText COMP_DUM_FIELD_01) {
		this.COMP_DUM_FIELD_01 = COMP_DUM_FIELD_01;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_01_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_01_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_01_DESC() {
		return COMP_UI_M_DUM_FIELD_01_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_01_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_01_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_01_DESC_LABEL = COMP_UI_M_DUM_FIELD_01_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_01_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_01_DESC) {
		this.COMP_UI_M_DUM_FIELD_01_DESC = COMP_UI_M_DUM_FIELD_01_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_11_LABEL() {
		return COMP_DUM_FIELD_11_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_11() {
		return COMP_DUM_FIELD_11;
	}

	public void setCOMP_DUM_FIELD_11_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_11_LABEL) {
		this.COMP_DUM_FIELD_11_LABEL = COMP_DUM_FIELD_11_LABEL;
	}

	public void setCOMP_DUM_FIELD_11(HtmlInputText COMP_DUM_FIELD_11) {
		this.COMP_DUM_FIELD_11 = COMP_DUM_FIELD_11;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_11_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_11_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_11_DESC() {
		return COMP_UI_M_DUM_FIELD_11_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_11_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_11_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_11_DESC_LABEL = COMP_UI_M_DUM_FIELD_11_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_11_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_11_DESC) {
		this.COMP_UI_M_DUM_FIELD_11_DESC = COMP_UI_M_DUM_FIELD_11_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_02_LABEL() {
		return COMP_DUM_FIELD_02_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_02() {
		return COMP_DUM_FIELD_02;
	}

	public void setCOMP_DUM_FIELD_02_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_02_LABEL) {
		this.COMP_DUM_FIELD_02_LABEL = COMP_DUM_FIELD_02_LABEL;
	}

	public void setCOMP_DUM_FIELD_02(HtmlInputText COMP_DUM_FIELD_02) {
		this.COMP_DUM_FIELD_02 = COMP_DUM_FIELD_02;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_02_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_02_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_02_DESC() {
		return COMP_UI_M_DUM_FIELD_02_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_02_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_02_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_02_DESC_LABEL = COMP_UI_M_DUM_FIELD_02_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_02_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_02_DESC) {
		this.COMP_UI_M_DUM_FIELD_02_DESC = COMP_UI_M_DUM_FIELD_02_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_12_LABEL() {
		return COMP_DUM_FIELD_12_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_12() {
		return COMP_DUM_FIELD_12;
	}

	public void setCOMP_DUM_FIELD_12_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_12_LABEL) {
		this.COMP_DUM_FIELD_12_LABEL = COMP_DUM_FIELD_12_LABEL;
	}

	public void setCOMP_DUM_FIELD_12(HtmlInputText COMP_DUM_FIELD_12) {
		this.COMP_DUM_FIELD_12 = COMP_DUM_FIELD_12;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_12_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_12_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_12_DESC() {
		return COMP_UI_M_DUM_FIELD_12_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_12_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_12_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_12_DESC_LABEL = COMP_UI_M_DUM_FIELD_12_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_12_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_12_DESC) {
		this.COMP_UI_M_DUM_FIELD_12_DESC = COMP_UI_M_DUM_FIELD_12_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_03_LABEL() {
		return COMP_DUM_FIELD_03_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_03() {
		return COMP_DUM_FIELD_03;
	}

	public void setCOMP_DUM_FIELD_03_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_03_LABEL) {
		this.COMP_DUM_FIELD_03_LABEL = COMP_DUM_FIELD_03_LABEL;
	}

	public void setCOMP_DUM_FIELD_03(HtmlInputText COMP_DUM_FIELD_03) {
		this.COMP_DUM_FIELD_03 = COMP_DUM_FIELD_03;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_03_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_03_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_03_DESC() {
		return COMP_UI_M_DUM_FIELD_03_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_03_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_03_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_03_DESC_LABEL = COMP_UI_M_DUM_FIELD_03_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_03_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_03_DESC) {
		this.COMP_UI_M_DUM_FIELD_03_DESC = COMP_UI_M_DUM_FIELD_03_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_13_LABEL() {
		return COMP_DUM_FIELD_13_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_13() {
		return COMP_DUM_FIELD_13;
	}

	public void setCOMP_DUM_FIELD_13_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_13_LABEL) {
		this.COMP_DUM_FIELD_13_LABEL = COMP_DUM_FIELD_13_LABEL;
	}

	public void setCOMP_DUM_FIELD_13(HtmlInputText COMP_DUM_FIELD_13) {
		this.COMP_DUM_FIELD_13 = COMP_DUM_FIELD_13;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_13_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_13_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_13_DESC() {
		return COMP_UI_M_DUM_FIELD_13_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_13_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_13_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_13_DESC_LABEL = COMP_UI_M_DUM_FIELD_13_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_13_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_13_DESC) {
		this.COMP_UI_M_DUM_FIELD_13_DESC = COMP_UI_M_DUM_FIELD_13_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_04_LABEL() {
		return COMP_DUM_FIELD_04_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_04() {
		return COMP_DUM_FIELD_04;
	}

	public void setCOMP_DUM_FIELD_04_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_04_LABEL) {
		this.COMP_DUM_FIELD_04_LABEL = COMP_DUM_FIELD_04_LABEL;
	}

	public void setCOMP_DUM_FIELD_04(HtmlInputText COMP_DUM_FIELD_04) {
		this.COMP_DUM_FIELD_04 = COMP_DUM_FIELD_04;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_04_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_04_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_04_DESC() {
		return COMP_UI_M_DUM_FIELD_04_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_04_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_04_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_04_DESC_LABEL = COMP_UI_M_DUM_FIELD_04_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_04_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_04_DESC) {
		this.COMP_UI_M_DUM_FIELD_04_DESC = COMP_UI_M_DUM_FIELD_04_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_14_LABEL() {
		return COMP_DUM_FIELD_14_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_14() {
		return COMP_DUM_FIELD_14;
	}

	public void setCOMP_DUM_FIELD_14_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_14_LABEL) {
		this.COMP_DUM_FIELD_14_LABEL = COMP_DUM_FIELD_14_LABEL;
	}

	public void setCOMP_DUM_FIELD_14(HtmlInputText COMP_DUM_FIELD_14) {
		this.COMP_DUM_FIELD_14 = COMP_DUM_FIELD_14;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_14_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_14_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_14_DESC() {
		return COMP_UI_M_DUM_FIELD_14_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_14_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_14_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_14_DESC_LABEL = COMP_UI_M_DUM_FIELD_14_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_14_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_14_DESC) {
		this.COMP_UI_M_DUM_FIELD_14_DESC = COMP_UI_M_DUM_FIELD_14_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_05_LABEL() {
		return COMP_DUM_FIELD_05_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_05() {
		return COMP_DUM_FIELD_05;
	}

	public void setCOMP_DUM_FIELD_05_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_05_LABEL) {
		this.COMP_DUM_FIELD_05_LABEL = COMP_DUM_FIELD_05_LABEL;
	}

	public void setCOMP_DUM_FIELD_05(HtmlInputText COMP_DUM_FIELD_05) {
		this.COMP_DUM_FIELD_05 = COMP_DUM_FIELD_05;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_05_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_05_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_05_DESC() {
		return COMP_UI_M_DUM_FIELD_05_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_05_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_05_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_05_DESC_LABEL = COMP_UI_M_DUM_FIELD_05_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_05_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_05_DESC) {
		this.COMP_UI_M_DUM_FIELD_05_DESC = COMP_UI_M_DUM_FIELD_05_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_15_LABEL() {
		return COMP_DUM_FIELD_15_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_15() {
		return COMP_DUM_FIELD_15;
	}

	public void setCOMP_DUM_FIELD_15_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_15_LABEL) {
		this.COMP_DUM_FIELD_15_LABEL = COMP_DUM_FIELD_15_LABEL;
	}

	public void setCOMP_DUM_FIELD_15(HtmlInputText COMP_DUM_FIELD_15) {
		this.COMP_DUM_FIELD_15 = COMP_DUM_FIELD_15;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_15_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_15_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_15_DESC() {
		return COMP_UI_M_DUM_FIELD_15_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_15_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_15_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_15_DESC_LABEL = COMP_UI_M_DUM_FIELD_15_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_15_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_15_DESC) {
		this.COMP_UI_M_DUM_FIELD_15_DESC = COMP_UI_M_DUM_FIELD_15_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_06_LABEL() {
		return COMP_DUM_FIELD_06_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_06() {
		return COMP_DUM_FIELD_06;
	}

	public void setCOMP_DUM_FIELD_06_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_06_LABEL) {
		this.COMP_DUM_FIELD_06_LABEL = COMP_DUM_FIELD_06_LABEL;
	}

	public void setCOMP_DUM_FIELD_06(HtmlInputText COMP_DUM_FIELD_06) {
		this.COMP_DUM_FIELD_06 = COMP_DUM_FIELD_06;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_06_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_06_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_06_DESC() {
		return COMP_UI_M_DUM_FIELD_06_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_06_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_06_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_06_DESC_LABEL = COMP_UI_M_DUM_FIELD_06_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_06_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_06_DESC) {
		this.COMP_UI_M_DUM_FIELD_06_DESC = COMP_UI_M_DUM_FIELD_06_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_16_LABEL() {
		return COMP_DUM_FIELD_16_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_16() {
		return COMP_DUM_FIELD_16;
	}

	public void setCOMP_DUM_FIELD_16_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_16_LABEL) {
		this.COMP_DUM_FIELD_16_LABEL = COMP_DUM_FIELD_16_LABEL;
	}

	public void setCOMP_DUM_FIELD_16(HtmlInputText COMP_DUM_FIELD_16) {
		this.COMP_DUM_FIELD_16 = COMP_DUM_FIELD_16;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_16_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_16_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_16_DESC() {
		return COMP_UI_M_DUM_FIELD_16_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_16_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_16_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_16_DESC_LABEL = COMP_UI_M_DUM_FIELD_16_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_16_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_16_DESC) {
		this.COMP_UI_M_DUM_FIELD_16_DESC = COMP_UI_M_DUM_FIELD_16_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_07_LABEL() {
		return COMP_DUM_FIELD_07_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_07() {
		return COMP_DUM_FIELD_07;
	}

	public void setCOMP_DUM_FIELD_07_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_07_LABEL) {
		this.COMP_DUM_FIELD_07_LABEL = COMP_DUM_FIELD_07_LABEL;
	}

	public void setCOMP_DUM_FIELD_07(HtmlInputText COMP_DUM_FIELD_07) {
		this.COMP_DUM_FIELD_07 = COMP_DUM_FIELD_07;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_07_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_07_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_07_DESC() {
		return COMP_UI_M_DUM_FIELD_07_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_07_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_07_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_07_DESC_LABEL = COMP_UI_M_DUM_FIELD_07_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_07_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_07_DESC) {
		this.COMP_UI_M_DUM_FIELD_07_DESC = COMP_UI_M_DUM_FIELD_07_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_17_LABEL() {
		return COMP_DUM_FIELD_17_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_17() {
		return COMP_DUM_FIELD_17;
	}

	public void setCOMP_DUM_FIELD_17_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_17_LABEL) {
		this.COMP_DUM_FIELD_17_LABEL = COMP_DUM_FIELD_17_LABEL;
	}

	public void setCOMP_DUM_FIELD_17(HtmlInputText COMP_DUM_FIELD_17) {
		this.COMP_DUM_FIELD_17 = COMP_DUM_FIELD_17;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_17_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_17_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_17_DESC() {
		return COMP_UI_M_DUM_FIELD_17_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_17_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_17_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_17_DESC_LABEL = COMP_UI_M_DUM_FIELD_17_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_17_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_17_DESC) {
		this.COMP_UI_M_DUM_FIELD_17_DESC = COMP_UI_M_DUM_FIELD_17_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_08_LABEL() {
		return COMP_DUM_FIELD_08_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_08() {
		return COMP_DUM_FIELD_08;
	}

	public void setCOMP_DUM_FIELD_08_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_08_LABEL) {
		this.COMP_DUM_FIELD_08_LABEL = COMP_DUM_FIELD_08_LABEL;
	}

	public void setCOMP_DUM_FIELD_08(HtmlInputText COMP_DUM_FIELD_08) {
		this.COMP_DUM_FIELD_08 = COMP_DUM_FIELD_08;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_08_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_08_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_08_DESC() {
		return COMP_UI_M_DUM_FIELD_08_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_08_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_08_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_08_DESC_LABEL = COMP_UI_M_DUM_FIELD_08_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_08_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_08_DESC) {
		this.COMP_UI_M_DUM_FIELD_08_DESC = COMP_UI_M_DUM_FIELD_08_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_18_LABEL() {
		return COMP_DUM_FIELD_18_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_18() {
		return COMP_DUM_FIELD_18;
	}

	public void setCOMP_DUM_FIELD_18_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_18_LABEL) {
		this.COMP_DUM_FIELD_18_LABEL = COMP_DUM_FIELD_18_LABEL;
	}

	public void setCOMP_DUM_FIELD_18(HtmlInputText COMP_DUM_FIELD_18) {
		this.COMP_DUM_FIELD_18 = COMP_DUM_FIELD_18;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_18_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_18_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_18_DESC() {
		return COMP_UI_M_DUM_FIELD_18_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_18_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_18_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_18_DESC_LABEL = COMP_UI_M_DUM_FIELD_18_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_18_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_18_DESC) {
		this.COMP_UI_M_DUM_FIELD_18_DESC = COMP_UI_M_DUM_FIELD_18_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_09_LABEL() {
		return COMP_DUM_FIELD_09_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_09() {
		return COMP_DUM_FIELD_09;
	}

	public void setCOMP_DUM_FIELD_09_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_09_LABEL) {
		this.COMP_DUM_FIELD_09_LABEL = COMP_DUM_FIELD_09_LABEL;
	}

	public void setCOMP_DUM_FIELD_09(HtmlInputText COMP_DUM_FIELD_09) {
		this.COMP_DUM_FIELD_09 = COMP_DUM_FIELD_09;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_09_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_09_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_09_DESC() {
		return COMP_UI_M_DUM_FIELD_09_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_09_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_09_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_09_DESC_LABEL = COMP_UI_M_DUM_FIELD_09_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_09_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_09_DESC) {
		this.COMP_UI_M_DUM_FIELD_09_DESC = COMP_UI_M_DUM_FIELD_09_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_19_LABEL() {
		return COMP_DUM_FIELD_19_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_19() {
		return COMP_DUM_FIELD_19;
	}

	public void setCOMP_DUM_FIELD_19_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_19_LABEL) {
		this.COMP_DUM_FIELD_19_LABEL = COMP_DUM_FIELD_19_LABEL;
	}

	public void setCOMP_DUM_FIELD_19(HtmlInputText COMP_DUM_FIELD_19) {
		this.COMP_DUM_FIELD_19 = COMP_DUM_FIELD_19;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_19_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_19_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_19_DESC() {
		return COMP_UI_M_DUM_FIELD_19_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_19_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_19_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_19_DESC_LABEL = COMP_UI_M_DUM_FIELD_19_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_19_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_19_DESC) {
		this.COMP_UI_M_DUM_FIELD_19_DESC = COMP_UI_M_DUM_FIELD_19_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_10_LABEL() {
		return COMP_DUM_FIELD_10_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_10() {
		return COMP_DUM_FIELD_10;
	}

	public void setCOMP_DUM_FIELD_10_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_10_LABEL) {
		this.COMP_DUM_FIELD_10_LABEL = COMP_DUM_FIELD_10_LABEL;
	}

	public void setCOMP_DUM_FIELD_10(HtmlInputText COMP_DUM_FIELD_10) {
		this.COMP_DUM_FIELD_10 = COMP_DUM_FIELD_10;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_10_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_10_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_10_DESC() {
		return COMP_UI_M_DUM_FIELD_10_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_10_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_10_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_10_DESC_LABEL = COMP_UI_M_DUM_FIELD_10_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_10_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_10_DESC) {
		this.COMP_UI_M_DUM_FIELD_10_DESC = COMP_UI_M_DUM_FIELD_10_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_FIELD_20_LABEL() {
		return COMP_DUM_FIELD_20_LABEL;
	}

	public HtmlInputText getCOMP_DUM_FIELD_20() {
		return COMP_DUM_FIELD_20;
	}

	public void setCOMP_DUM_FIELD_20_LABEL(
			HtmlOutputLabel COMP_DUM_FIELD_20_LABEL) {
		this.COMP_DUM_FIELD_20_LABEL = COMP_DUM_FIELD_20_LABEL;
	}

	public void setCOMP_DUM_FIELD_20(HtmlInputText COMP_DUM_FIELD_20) {
		this.COMP_DUM_FIELD_20 = COMP_DUM_FIELD_20;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUM_FIELD_20_DESC_LABEL() {
		return COMP_UI_M_DUM_FIELD_20_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DUM_FIELD_20_DESC() {
		return COMP_UI_M_DUM_FIELD_20_DESC;
	}

	public void setCOMP_UI_M_DUM_FIELD_20_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DUM_FIELD_20_DESC_LABEL) {
		this.COMP_UI_M_DUM_FIELD_20_DESC_LABEL = COMP_UI_M_DUM_FIELD_20_DESC_LABEL;
	}

	public void setCOMP_UI_M_DUM_FIELD_20_DESC(
			HtmlInputText COMP_UI_M_DUM_FIELD_20_DESC) {
		this.COMP_UI_M_DUM_FIELD_20_DESC = COMP_UI_M_DUM_FIELD_20_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_01_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_01_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_01_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_01_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_01_LOV = COMP_UI_M_BUT_DUM_FIELD_01_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_02_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_02_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_02_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_02_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_02_LOV = COMP_UI_M_BUT_DUM_FIELD_02_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_03_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_03_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_03_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_03_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_03_LOV = COMP_UI_M_BUT_DUM_FIELD_03_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_05_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_05_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_05_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_05_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_05_LOV = COMP_UI_M_BUT_DUM_FIELD_05_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_06_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_06_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_06_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_06_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_06_LOV = COMP_UI_M_BUT_DUM_FIELD_06_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_07_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_07_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_07_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_07_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_07_LOV = COMP_UI_M_BUT_DUM_FIELD_07_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_08_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_08_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_08_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_08_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_08_LOV = COMP_UI_M_BUT_DUM_FIELD_08_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_09_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_09_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_09_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_09_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_09_LOV = COMP_UI_M_BUT_DUM_FIELD_09_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_10_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_10_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_10_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_10_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_10_LOV = COMP_UI_M_BUT_DUM_FIELD_10_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_11_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_11_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_11_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_11_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_11_LOV = COMP_UI_M_BUT_DUM_FIELD_11_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_12_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_12_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_12_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_12_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_12_LOV = COMP_UI_M_BUT_DUM_FIELD_12_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_13_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_13_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_13_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_13_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_13_LOV = COMP_UI_M_BUT_DUM_FIELD_13_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_14_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_14_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_14_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_14_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_14_LOV = COMP_UI_M_BUT_DUM_FIELD_14_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_15_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_15_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_15_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_15_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_15_LOV = COMP_UI_M_BUT_DUM_FIELD_15_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_16_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_16_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_16_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_16_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_16_LOV = COMP_UI_M_BUT_DUM_FIELD_16_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_17_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_17_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_17_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_17_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_17_LOV = COMP_UI_M_BUT_DUM_FIELD_17_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_18_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_18_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_18_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_18_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_18_LOV = COMP_UI_M_BUT_DUM_FIELD_18_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_19_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_19_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_19_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_19_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_19_LOV = COMP_UI_M_BUT_DUM_FIELD_19_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_FIELD_20_LOV() {
		return COMP_UI_M_BUT_DUM_FIELD_20_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_FIELD_20_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_FIELD_20_LOV) {
		this.COMP_UI_M_BUT_DUM_FIELD_20_LOV = COMP_UI_M_BUT_DUM_FIELD_20_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUM_DEF_CODE_LOV() {
		return COMP_UI_M_BUT_DUM_DEF_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_DUM_DEF_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DUM_DEF_CODE_LOV) {
		this.COMP_UI_M_BUT_DUM_DEF_CODE_LOV = COMP_UI_M_BUT_DUM_DEF_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_MAP_CODE_DESC() {
		return COMP_UI_M_EDIT_MAP_CODE_DESC;
	}

	public void setCOMP_UI_M_EDIT_MAP_CODE_DESC(
			HtmlCommandButton COMP_UI_M_EDIT_MAP_CODE_DESC) {
		this.COMP_UI_M_EDIT_MAP_CODE_DESC = COMP_UI_M_EDIT_MAP_CODE_DESC;
	}

	public PM_IL_DATA_UPLOAD_MAPPING getPM_IL_DATA_UPLOAD_MAPPING_BEAN() {
		return PM_IL_DATA_UPLOAD_MAPPING_BEAN;
	}

	public void setPM_IL_DATA_UPLOAD_MAPPING_BEAN(
			PM_IL_DATA_UPLOAD_MAPPING PM_IL_DATA_UPLOAD_MAPPING_BEAN) {
		this.PM_IL_DATA_UPLOAD_MAPPING_BEAN = PM_IL_DATA_UPLOAD_MAPPING_BEAN;
	}

	private PM_IL_DATA_UPLOAD_MAPPING newPP_LIFE_POL_SCH_PRN1 = null;

	/*
	 * Suggestion list for twenty Lov Fields starts here LOV Code and
	 * Description is selected from PM_Codes and inserted into a arraylist to
	 * show the suggestions Code and Description are added to a Hashmap to
	 * populate the values in the description field
	 * 
	 */

	public List suggestionList1(Object object) {
		System.out.println("The Value Entered is " + object.toString());
		codeDesc = object;
		// Connection connection = getConnection();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet LOVResultSet = null;
		String LOVQuery = null;
		try {
			connection = CommonUtils.getConnection();
			if (object.equals("*")) {
				LOVQuery = "select DUDH_DEF_CODE, DUDH_DESC from PM_IL_DATA_UPLOAD_DEFN_HDR ";
			} else {
				LOVQuery = "select DUDH_DEF_CODE, DUDH_DESC from PM_IL_DATA_UPLOAD_DEFN_HDR LIKE '"
						+ object.toString() + "%' AND ROWNUM  <25";
			}
			LOVResultSet = handler.executeSelectStatement(LOVQuery, connection);
			LOVResultSet.setFetchSize(25);

			while (LOVResultSet.next()) {
				newPP_LIFE_POL_SCH_PRN1 = new PM_IL_DATA_UPLOAD_MAPPING();
				newPP_LIFE_POL_SCH_PRN1.setUI_M_DUM_FIELD_01_DESC(LOVResultSet
						.getString(1));
				newPP_LIFE_POL_SCH_PRN1.setUI_M_DUM_FIELD_02_DESC(LOVResultSet
						.getString(2));
				// lov_Description =
				// newPP_LIFE_POL_SCH_PRN1.getUI_M_DUM_FIELD_02_DESC();
				keyValue.put(newPP_LIFE_POL_SCH_PRN1
						.getUI_M_DUM_FIELD_01_DESC(), newPP_LIFE_POL_SCH_PRN1
						.getUI_M_DUM_FIELD_02_DESC());
				// suggesionList.add(newPP_LIFE_POL_SCH_PRN1);
			}
			System.out.println("List Suggestion \t " + suggesionList.size());
			LOVResultSet.close();
			// connection.close();
		} catch (Exception er) {
			er.printStackTrace();
		}
		return suggesionList;
	}

	public void description1(ActionEvent event) throws Exception {
		System.out.println("The Value Entered is "
				+ getCOMP_DUM_DEF_CODE().getValue());
		String value = "";
		if (!"".equals(getCOMP_DUM_DEF_CODE().getSubmittedValue())) {
			value = keyValue.get(getCOMP_DUM_DEF_CODE().getValue());
			getCOMP_UI_M_DEF_CODE_DESC().setSubmittedValue(value);
		}
	}

	public List suggestionList2(Object object) {
		System.out.println("The Value Entered is " + object.toString());
		codeDesc = object;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet LOVResultSet = null;
		String LOVQuery = null;
		try {
			connection = CommonUtils.getConnection();
			if (object.equals("*")) {
				LOVQuery = "select DUDH_DEF_CODE, DUDH_DESC from PM_IL_DATA_UPLOAD_DEFN_HDR ";
			} else {
				LOVQuery = "select DUDH_DEF_CODE, DUDH_DESC from PM_IL_DATA_UPLOAD_DEFN_HDR LIKE '"
						+ object.toString() + "%' AND ROWNUM  <25";
			}
			LOVResultSet = handler.executeSelectStatement(LOVQuery, connection);
			LOVResultSet.setFetchSize(25);

			while (LOVResultSet.next()) {
				newPP_LIFE_POL_SCH_PRN1 = new PM_IL_DATA_UPLOAD_MAPPING();
				newPP_LIFE_POL_SCH_PRN1.setUI_M_DUM_FIELD_01_DESC(LOVResultSet
						.getString(1));
				newPP_LIFE_POL_SCH_PRN1.setUI_M_DUM_FIELD_02_DESC(LOVResultSet
						.getString(2));
				// lov_Description =
				// newPP_LIFE_POL_SCH_PRN1.getUI_M_DUM_FIELD_02_DESC();
				keyValue.put(newPP_LIFE_POL_SCH_PRN1
						.getUI_M_DUM_FIELD_01_DESC(), newPP_LIFE_POL_SCH_PRN1
						.getUI_M_DUM_FIELD_02_DESC());
				// suggesionList.add(newPP_LIFE_POL_SCH_PRN1);
			}
			System.out.println("List Suggestion \t " + suggesionList.size());
			LOVResultSet.close();
			// connection.close();
		} catch (Exception er) {
			er.printStackTrace();
		}
		return suggesionList;
	}

	public void description2(ActionEvent event) throws Exception {
		System.out.println("The Value Entered is "
				+ getCOMP_DUM_DEF_CODE().getValue());
		String value = "";
		if (!"".equals(getCOMP_DUM_DEF_CODE().getSubmittedValue())) {
			value = keyValue.get(getCOMP_DUM_DEF_CODE().getValue());
			getCOMP_UI_M_DEF_CODE_DESC().setSubmittedValue(value);
		}
	}

	// Database Operations

	public String commit_Save() throws DatabaseException {
		System.out.println("Ajax Call on Tab");
		CRUDHandler handler = new CRUDHandler();
		try {
			// [ Removed Hard coded user id: added by: Shankar bodduluri Dated:
			// 19-Mar-2009 ]
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_CR_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			// System.out.println("Inserting Query");
			handler.executeInsert(PM_IL_DATA_UPLOAD_MAPPING_BEAN, CommonUtils
					.getConnection());
			/*
			 * if(PM_IL_DATA_UPLOAD_MAPPING_BEAN== null){ //Insert Query
			 * System.out.println("Inserting Query");
			 * handler.executeInsert(PM_IL_DATA_UPLOAD_MAPPING_BEAN,
			 * getConnection()); }else{ //Update Query
			 * System.out.println("Updating Query");
			 * handler.executeUpdate(PM_IL_DATA_UPLOAD_MAPPING_BEAN,
			 * getConnection()); }
			 */
			// getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	// Delete Data from the data base
	public String commit_Delete() {
		System.out.println("Inside the Delete ");
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;

		int rowDeleted = 0;
		try {
			connection = CommonUtils.getConnection();
			System.out.println("ROWID \t"
					+ PM_IL_DATA_UPLOAD_MAPPING_BEAN.getROWID());
			rowDeleted = handler.executeDelete(PM_IL_DATA_UPLOAD_MAPPING_BEAN,
					connection);
			connection.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PM_IL_DATA_UPLOAD_MAPPING_BEAN = new PM_IL_DATA_UPLOAD_MAPPING();
		return "";
	}

	public void fetch() throws DatabaseException {

		System.out.println("In fetch record");
		ResultSet result = null;
		ConnectionAgentServlet agent = new ConnectionAgentServlet();
		CRUDHandler handler = new CRUDHandler();
		String selectQuery = "select ROWID,PM_IL_DATA_UPLOAD_MAPPING.* from PM_IL_DATA_UPLOAD_MAPPING";// where
		// ROWID='AAASdCAAGAAAAxFAAA'";

		System.out.println("Query \n" + selectQuery + "\n");
		// System.exit(1);
		try {
			result = handler.executeSelectStatement(selectQuery, CommonUtils
					.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		if (result == null) {
			System.out.println("Unable to fetch record");
		} else {
			try {
				if (result.next()) {
					System.out.println("Record Found \t"
							+ result.getString("rowid"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setROWID(result
							.getString("ROWID"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_DEF_CODE(result
							.getString("DUM_DEF_CODE"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_01(result
							.getInt("DUM_FIELD_01"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_02(result
							.getInt("DUM_FIELD_02"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_03(result
							.getInt("DUM_FIELD_03"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_04(result
							.getInt("DUM_FIELD_04"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_05(result
							.getInt("DUM_FIELD_05"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_06(result
							.getInt("DUM_FIELD_06"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_07(result
							.getInt("DUM_FIELD_07"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_08(result
							.getInt("DUM_FIELD_08"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_09(result
							.getInt("DUM_FIELD_09"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_10(result
							.getInt("DUM_FIELD_10"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_11(result
							.getInt("DUM_FIELD_11"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_12(result
							.getInt("DUM_FIELD_12"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_13(result
							.getInt("DUM_FIELD_13"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_14(result
							.getInt("DUM_FIELD_14"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_15(result
							.getInt("DUM_FIELD_15"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_16(result
							.getInt("DUM_FIELD_16"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_17(result
							.getInt("DUM_FIELD_17"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_18(result
							.getInt("DUM_FIELD_18"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_19(result
							.getInt("DUM_FIELD_19"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_20(result
							.getInt("DUM_FIELD_20"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_MAP_CODE(result
							.getString("DUM_MAP_CODE"));
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_MAP_CODE_DESC(result
							.getString("DUM_MAP_CODE_DESC"));
					System.out.println("Updated INthe Bean");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Save the current instance record.
	 */
	public String saveRecord() {
		CommonUtils.clearMaps(this);
		String message = null;

		try {
			if (PM_IL_DATA_UPLOAD_MAPPING_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.preUpdate(PM_IL_DATA_UPLOAD_MAPPING_BEAN);
					//helper.executeQuery(this);
					new CRUDHandler().executeInsert(
							PM_IL_DATA_UPLOAD_MAPPING_BEAN, CommonUtils
									.getConnection());
					CommonUtils.getConnection().commit();

					message = Messages.getString("messageProperties",
							"errorPanel$message$update");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("UPDATE", message);
				} else {
					message = Messages.getString("messageProperties",
							"errorPanel$message$updatenotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("UPDATE", message);
				}
			} else {
				if (isINSERT_ALLOWED()) {
					helper.preInsert(PM_IL_DATA_UPLOAD_MAPPING_BEAN);
					//helper.executeQuery(this);
					new CRUDHandler().executeInsert(
							PM_IL_DATA_UPLOAD_MAPPING_BEAN, CommonUtils
									.getConnection());
					CommonUtils.getConnection().commit();

					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("SAVE", message);
				} else {
					message = Messages.getString("messageProperties",
							"errorPanel$message$insertnotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("SAVE", message);
				}
			}
			chkFieldValues(PM_IL_DATA_UPLOAD_MAPPING_BEAN);

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		} finally {
			try {
				CommonUtils.getConnection().commit();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		return null;
	}

	public String deleteRecord() {
		String message = null;
		getErrorMap().clear();
		getWarningMap().clear();
		setErrorMessages(null);
		try {
			if (isDELETE_ALLOWED()) {
				if (PM_IL_DATA_UPLOAD_MAPPING_BEAN.getROWID() != null) {
					new CRUDHandler().executeDelete(
							PM_IL_DATA_UPLOAD_MAPPING_BEAN, CommonUtils
									.getConnection());
					CommonUtils.getConnection().commit();
					this.setPM_IL_DATA_UPLOAD_MAPPING_BEAN(new PM_IL_DATA_UPLOAD_MAPPING());
					message = Messages.getString("messageProperties",
							"errorPanel$message$delete");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("DELETE", message);
					resetAllComponent();
				}

			} /*
				 * else { message = Messages.getString("messageProperties",
				 * "errorPanel$message$deletenotallowed");
				 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				 * message); getErrorMap().put("DELETE", message); }
				 */

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}

		return null;
	}

	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {

			if (isFormFlag()) {
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				helper.executeQuery(this);
				if (PM_IL_DATA_UPLOAD_MAPPING_BEAN.getROWID() != null) {
					// helper.postQuery(PM_IL_IF_ACCNT_SETUP_DTL_BEAN,
					// compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				} else {
					// helper.whenCreateRecord(PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
					/*Added by Shankar on 13/04/2017*/
					PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_UPLOAD_TYPE("X");
					/*End*/
					
				}
				// whenNewRecordInstance(this,
				// compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorMapCode(FacesContext context, UIComponent component,
			Object value) {
		try {
			String curval=(String) value;
			//if(!(curval.equals(PM_IL_DATA_UPLOAD_MAPPING_BEAN.getDUM_MAP_CODE()))){
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_MAP_CODE((String) value);
				helper.whenValidateMapCode(PM_IL_DATA_UPLOAD_MAPPING_BEAN);
			//}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> defCodeSuggestion(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		suggesionList = new ArrayList<LovBean>();

		try {
			suggesionList = itemUtil.P_CALL_LOV("PILM041",
					"PM_IL_DATA_UPLOAD_MAPPING", "DUM_DEF_CODE", null, null,
					null, null, null, (String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggesionList;
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorDefCode(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_DEF_CODE((String) value);
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DEF_CODE_DESC(null);
			helper.whenValidateDefCode(PM_IL_DATA_UPLOAD_MAPPING_BEAN);
			COMP_UI_M_DEF_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String backToSearch() {
		CommonUtils.clearMaps(this);
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> field_LOV(Object event) {
		suggesionList = new ArrayList<LovBean>();

		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if (event != null && event.toString().equals("*")) {
				suggestQuery = "SELECT DUDD_SERIAL_NO,DUDD_PARA_NAME FROM PM_IL_DATA_UPLOAD_DEFN_DTL WHERE DUDD_PARA_TYPE ='P' AND DUDD_DUDH_DEF_CODE = ? AND ROWNUM < 20 ORDER BY 1 ASC";
			} else {
				suggestQuery = "SELECT DUDD_SERIAL_NO,DUDD_PARA_NAME FROM PM_IL_DATA_UPLOAD_DEFN_DTL WHERE DUDD_PARA_TYPE ='P' AND DUDD_DUDH_DEF_CODE = ? "
						+ " AND DUDD_SERIAL_NO LIKE '%"
						+ event.toString()
						+ "%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery,
					CommonUtils.getConnection(),
					new Object[] { PM_IL_DATA_UPLOAD_MAPPING_BEAN
							.getDUM_DEF_CODE() });
			while (rsSug1.next()) {
				LovBean lovBean = new LovBean();
				lovBean.setCode(rsSug1.getString(1));
				lovBean.setName(rsSug1.getString(2));
				suggesionList.add(lovBean);
			}
			CommonUtils.closeCursor(rsSug1);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggesionList;
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField1(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_01((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_01_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_01_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_01_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField2(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_02((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_02_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			}
			COMP_UI_M_DUM_FIELD_02_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_02_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField3(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_03((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_03_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_03_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_03_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField4(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_04((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_04_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_04_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_04_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField5(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_05((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_05_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_05_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_05_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField6(FacesContext context, UIComponent component,Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_06((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_06_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_06_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_06_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField7(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_07((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_07_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_07_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_07_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField8(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_08((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_08_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_08_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_08_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField9(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_09((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_09_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_09_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_09_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField10(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_10((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_10_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_10_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_10_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField11(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_11((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_11_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_10_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_11_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField12(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_12((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_12_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_12_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_12_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField13(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_13((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_13_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_13_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_13_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField14(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_14((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_14_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_14_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_14_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField15(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_15((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_15_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_15_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_15_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField16(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_16((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_16_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_16_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_16_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField17(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_17((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_17_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_17_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_17_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField18(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_18((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_18_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_18_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_18_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField19(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_19((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_19_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_19_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_19_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorField20(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_FIELD_20((Integer) value);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_20_DESC(helper
						.L_VALUE_CHECKING(value.toString(),
								PM_IL_DATA_UPLOAD_MAPPING_BEAN));
			} else {
				throw new Exception("Please Enter Legal values");
			}
			COMP_UI_M_DUM_FIELD_20_DESC.resetValue();
		} catch (Exception e) {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DUM_FIELD_20_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * Resets all components in PM_IL_DATA_UPLOAD_MAPPING_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_DUM_MAP_CODE.resetValue();
		COMP_DUM_MAP_CODE_DESC.resetValue();
		COMP_DUM_DEF_CODE.resetValue();
		COMP_UI_M_DEF_CODE_DESC.resetValue();
		COMP_DUM_FIELD_01.resetValue();
		COMP_UI_M_DUM_FIELD_01_DESC.resetValue();
		COMP_DUM_FIELD_11.resetValue();
		COMP_UI_M_DUM_FIELD_11_DESC.resetValue();
		COMP_DUM_FIELD_02.resetValue();
		COMP_UI_M_DUM_FIELD_02_DESC.resetValue();
		COMP_DUM_FIELD_12.resetValue();
		COMP_UI_M_DUM_FIELD_12_DESC.resetValue();
		COMP_DUM_FIELD_03.resetValue();
		COMP_UI_M_DUM_FIELD_03_DESC.resetValue();
		COMP_DUM_FIELD_13.resetValue();
		COMP_UI_M_DUM_FIELD_13_DESC.resetValue();
		COMP_DUM_FIELD_04.resetValue();
		COMP_UI_M_DUM_FIELD_04_DESC.resetValue();
		COMP_DUM_FIELD_14.resetValue();
		COMP_UI_M_DUM_FIELD_14_DESC.resetValue();
		COMP_DUM_FIELD_05.resetValue();
		COMP_UI_M_DUM_FIELD_05_DESC.resetValue();
		COMP_DUM_FIELD_15.resetValue();
		COMP_UI_M_DUM_FIELD_15_DESC.resetValue();
		COMP_DUM_FIELD_06.resetValue();
		COMP_UI_M_DUM_FIELD_06_DESC.resetValue();
		COMP_DUM_FIELD_16.resetValue();
		COMP_UI_M_DUM_FIELD_16_DESC.resetValue();
		COMP_DUM_FIELD_07.resetValue();
		COMP_UI_M_DUM_FIELD_07_DESC.resetValue();
		COMP_DUM_FIELD_17.resetValue();
		COMP_UI_M_DUM_FIELD_17_DESC.resetValue();
		COMP_DUM_FIELD_08.resetValue();
		COMP_UI_M_DUM_FIELD_08_DESC.resetValue();
		COMP_DUM_FIELD_18.resetValue();
		COMP_UI_M_DUM_FIELD_18_DESC.resetValue();
		COMP_DUM_FIELD_09.resetValue();
		COMP_UI_M_DUM_FIELD_09_DESC.resetValue();
		COMP_DUM_FIELD_19.resetValue();
		COMP_UI_M_DUM_FIELD_19_DESC.resetValue();
		COMP_DUM_FIELD_10.resetValue();
		COMP_UI_M_DUM_FIELD_10_DESC.resetValue();
		COMP_DUM_FIELD_20.resetValue();
		COMP_UI_M_DUM_FIELD_20_DESC.resetValue();
		
		/*	added by raja on 06-03-2017 for ZBILQC-1719694 */
		COMP_DUM_EMPLOYER_CODE.resetValue();
		COMP_DUM_EMPLOYER_CODE_DESC.resetValue();
		COMP_DUM_PAYMENT_MODE.resetValue();
		/*end*/
		
	}
	public void chkFieldValues(PM_IL_DATA_UPLOAD_MAPPING bean){
		bean
		.setDUM_FIELD_01(bean.getDUM_FIELD_01() == 0 ? null
				: bean.getDUM_FIELD_01());
bean
		.setDUM_FIELD_02(bean.getDUM_FIELD_02() == 0 ? null
				: bean.getDUM_FIELD_02());
bean
		.setDUM_FIELD_03(bean.getDUM_FIELD_03() == 0 ? null
				: bean.getDUM_FIELD_03());
bean
		.setDUM_FIELD_04(bean.getDUM_FIELD_04() == 0 ? null
				: bean.getDUM_FIELD_04());
bean
		.setDUM_FIELD_05(bean.getDUM_FIELD_05() == 0 ? null
				: bean.getDUM_FIELD_05());
bean
		.setDUM_FIELD_06(bean.getDUM_FIELD_06() == 0 ? null
				: bean.getDUM_FIELD_06());
bean
		.setDUM_FIELD_07(bean.getDUM_FIELD_07() == 0 ? null
				: bean.getDUM_FIELD_07());
bean
		.setDUM_FIELD_08(bean.getDUM_FIELD_08() == 0 ? null
				: bean.getDUM_FIELD_08());
bean
		.setDUM_FIELD_09(bean.getDUM_FIELD_09() == 0 ? null
				: bean.getDUM_FIELD_09());
bean
		.setDUM_FIELD_10(bean.getDUM_FIELD_10() == 0 ? null
				: bean.getDUM_FIELD_10());
bean
		.setDUM_FIELD_11(bean.getDUM_FIELD_11() == 0 ? null
				: bean.getDUM_FIELD_11());
bean
		.setDUM_FIELD_12(bean.getDUM_FIELD_12() == 0 ? null
				: bean.getDUM_FIELD_12());
bean
		.setDUM_FIELD_13(bean.getDUM_FIELD_13() == 0 ? null
				: bean.getDUM_FIELD_13());
bean
		.setDUM_FIELD_14(bean.getDUM_FIELD_14() == 0 ? null
				: bean.getDUM_FIELD_14());
bean
		.setDUM_FIELD_15(bean.getDUM_FIELD_15() == 0 ? null
				: bean.getDUM_FIELD_15());
bean
		.setDUM_FIELD_16(bean.getDUM_FIELD_16() == 0 ? null
				: bean.getDUM_FIELD_16());
bean
		.setDUM_FIELD_17(bean.getDUM_FIELD_17() == 0 ? null
				: bean.getDUM_FIELD_17());
bean
		.setDUM_FIELD_18(bean.getDUM_FIELD_18() == 0 ? null
				: bean.getDUM_FIELD_18());
bean
		.setDUM_FIELD_19(bean.getDUM_FIELD_19() == 0 ? null
				: bean.getDUM_FIELD_19());
bean
		.setDUM_FIELD_20(bean.getDUM_FIELD_20() == 0 ? null
				: bean.getDUM_FIELD_20());
	}
	
	
/*	added by raja on 06-03-2017 for ZBILQC-1719694 */
	private HtmlOutputLabel COMP_DUM_EMPLOYER_CODE_LABEL;

	private HtmlInputText COMP_DUM_EMPLOYER_CODE;
	
	private HtmlInputText COMP_DUM_EMPLOYER_CODE_DESC;
	
	private HtmlOutputLabel COMP_DUM_PAYMENT_MODE_LABEL;
	
	private HtmlSelectOneMenu COMP_DUM_PAYMENT_MODE;

	public HtmlOutputLabel getCOMP_DUM_EMPLOYER_CODE_LABEL() {
		return COMP_DUM_EMPLOYER_CODE_LABEL;
	}

	public void setCOMP_DUM_EMPLOYER_CODE_LABEL(
			HtmlOutputLabel cOMP_DUM_EMPLOYER_CODE_LABEL) {
		COMP_DUM_EMPLOYER_CODE_LABEL = cOMP_DUM_EMPLOYER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DUM_EMPLOYER_CODE() {
		return COMP_DUM_EMPLOYER_CODE;
	}

	public void setCOMP_DUM_EMPLOYER_CODE(HtmlInputText cOMP_DUM_EMPLOYER_CODE) {
		COMP_DUM_EMPLOYER_CODE = cOMP_DUM_EMPLOYER_CODE;
	}

	public HtmlInputText getCOMP_DUM_EMPLOYER_CODE_DESC() {
		return COMP_DUM_EMPLOYER_CODE_DESC;
	}

	public void setCOMP_DUM_EMPLOYER_CODE_DESC(
			HtmlInputText cOMP_DUM_EMPLOYER_CODE_DESC) {
		COMP_DUM_EMPLOYER_CODE_DESC = cOMP_DUM_EMPLOYER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DUM_PAYMENT_MODE_LABEL() {
		return COMP_DUM_PAYMENT_MODE_LABEL;
	}

	public void setCOMP_DUM_PAYMENT_MODE_LABEL(
			HtmlOutputLabel cOMP_DUM_PAYMENT_MODE_LABEL) {
		COMP_DUM_PAYMENT_MODE_LABEL = cOMP_DUM_PAYMENT_MODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DUM_PAYMENT_MODE() {
		return COMP_DUM_PAYMENT_MODE;
	}

	public void setCOMP_DUM_PAYMENT_MODE(HtmlSelectOneMenu cOMP_DUM_PAYMENT_MODE) {
		COMP_DUM_PAYMENT_MODE = cOMP_DUM_PAYMENT_MODE;
	}

	private List<SelectItem> listPaynemtMode = new ArrayList<SelectItem>();
	
	
	
	public List<SelectItem> getListPaynemtMode() {
		return listPaynemtMode;
	}

	public void setListPaynemtMode(List<SelectItem> listPaynemtMode) {
		this.listPaynemtMode = listPaynemtMode;
	}

	/*Modified by ganesh on 31-05-2017, ZBILQC-1724500 */
	/*public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_EMPLOYER_CODE(
			Object currValue) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//P_CALL_LOV('DUMMY.M_POL_EMPLOYER_CODE');
			suggestionList = listitemutil.P_CALL_LOV("PILP017",
					"DUMMY", "M_POL_EMPLOYER_CODE", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/
	
	public List<LovBean> lovPOL_EMPLOYER_CODE(Object obj) {
		List<LovBean> suggestionList = null;
		try {
		String empBankCode = (String) obj;		
		ListItemUtil listitemutil = new ListItemUtil();
		Object[] object = {};
		String query = null;
		if ("*".equals(empBankCode)) {
			object = new Object[] { PELConstants.suggetionRecordSize,PELConstants.suggetionRecordSize };
			query = PILM041_SQLQUERY_CONSTANTS.POL_EMPLOYER_CODE_LOV;
		} else {
			object = new Object[] { empBankCode + "%", empBankCode + "%",
					PELConstants.suggetionRecordSize, empBankCode + "%", empBankCode + "%",
					PELConstants.suggetionRecordSize };
			query = PILM041_SQLQUERY_CONSTANTS.POL_EMPLOYER_CODE_LOV_LIKE;
		}
		
			suggestionList = listitemutil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suggestionList;
	}
	/*end*/
	
	public void validatorDUM_EMPLOYER_CODE(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_EMPLOYER_CODE((String) value);
				
			} else {
				throw new Exception("Please Enter Legal values");
			}
			
		} catch (Exception e) {
			
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void validateDUM_PAYMENT_MODE(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_PAYMENT_MODE((String) value);
				
			} else {
				throw new Exception("Please Enter Legal values");
			}
			
		} catch (Exception e) {
			
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void setListItemValues() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			
			setListPaynemtMode(ListItemUtil.getDropDownListValue(
					connection, "PILP017", "DUMMY",
					"DUMMY.M_PAY_MODE", "IL_PAY_MODE"));
			
			
			/*Added BY SANKARA NARAYANAN FOR dIRECT dEBIT ON 13/04/2017*/
			setListFileType(ListItemUtil.getDropDownListValue(
					connection, "PILP017", "DUMMY",
					"DUMMY.M_FILE_TYPE", "IL_FILE_TYPE"));
			//END
			/*added by raja on 27-06-2017 for ZBILQC-1729595*/
			setListDUM_EMPLOYER_TYPE(ListItemUtil.getDropDownListValue(
					connection, "PILM041", "PM_IL_DATA_UPLOAD_MAPPING",
					"PM_IL_DATA_UPLOAD_MAPPING.DUM_EMPLOYER_TYPE", "DOW"));
			/*end*/

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	/*end*/
	
	/*Added BY SANKARA NARAYANAN FOR dIRECT dEBIT ON 13/04/2017*/
	private List<SelectItem> listFileType = new ArrayList<SelectItem>();
	private HtmlOutputLabel COMP_DUM_UPLOAD_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_DUM_UPLOAD_TYPE;
	
	
	public HtmlOutputLabel getCOMP_DUM_UPLOAD_TYPE_LABEL() {
		return COMP_DUM_UPLOAD_TYPE_LABEL;
	}

	public void setCOMP_DUM_UPLOAD_TYPE_LABEL(
			HtmlOutputLabel cOMP_DUM_UPLOAD_TYPE_LABEL) {
		COMP_DUM_UPLOAD_TYPE_LABEL = cOMP_DUM_UPLOAD_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DUM_UPLOAD_TYPE() {
		return COMP_DUM_UPLOAD_TYPE;
	}

	public void setCOMP_DUM_UPLOAD_TYPE(HtmlSelectOneMenu cOMP_DUM_UPLOAD_TYPE) {
		COMP_DUM_UPLOAD_TYPE = cOMP_DUM_UPLOAD_TYPE;
	}

	public List<SelectItem> getListFileType() {
		return listFileType;
	}

	public void setListFileType(List<SelectItem> listFileType) {
		this.listFileType = listFileType;
	}

	public void validateDUM_UPLOAD_TYPE(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_UPLOAD_TYPE((String) value);
				
			} 
			
		} catch (Exception e) {
			
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*end*/
	
	
	private HtmlOutputLabel COMP_DUM_DUE_DT_LABEL;
	private HtmlCalendar COMP_DUM_DUE_DT;

	private HtmlOutputLabel COMP_DUM_EFF_TO_DT_LABEL;
	private HtmlCalendar COMP_DUM_EFF_TO_DT;

	private HtmlOutputLabel COMP_DUM_EFF_FM_DT_LABEL;
	private HtmlCalendar COMP_DUM_EFF_FM_DT;

	public HtmlOutputLabel getCOMP_DUM_DUE_DT_LABEL() {
		return COMP_DUM_DUE_DT_LABEL;
	}

	public void setCOMP_DUM_DUE_DT_LABEL(HtmlOutputLabel cOMP_DUM_DUE_DT_LABEL) {
		COMP_DUM_DUE_DT_LABEL = cOMP_DUM_DUE_DT_LABEL;
	}

	

	public HtmlCalendar getCOMP_DUM_DUE_DT() {
		return COMP_DUM_DUE_DT;
	}

	public void setCOMP_DUM_DUE_DT(HtmlCalendar cOMP_DUM_DUE_DT) {
		COMP_DUM_DUE_DT = cOMP_DUM_DUE_DT;
	}

	public HtmlCalendar getCOMP_DUM_EFF_TO_DT() {
		return COMP_DUM_EFF_TO_DT;
	}

	public void setCOMP_DUM_EFF_TO_DT(HtmlCalendar cOMP_DUM_EFF_TO_DT) {
		COMP_DUM_EFF_TO_DT = cOMP_DUM_EFF_TO_DT;
	}

	public HtmlCalendar getCOMP_DUM_EFF_FM_DT() {
		return COMP_DUM_EFF_FM_DT;
	}

	public void setCOMP_DUM_EFF_FM_DT(HtmlCalendar cOMP_DUM_EFF_FM_DT) {
		COMP_DUM_EFF_FM_DT = cOMP_DUM_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_DUM_EFF_TO_DT_LABEL() {
		return COMP_DUM_EFF_TO_DT_LABEL;
	}

	public void setCOMP_DUM_EFF_TO_DT_LABEL(HtmlOutputLabel cOMP_DUM_EFF_TO_DT_LABEL) {
		COMP_DUM_EFF_TO_DT_LABEL = cOMP_DUM_EFF_TO_DT_LABEL;
	}

	

	public HtmlOutputLabel getCOMP_DUM_EFF_FM_DT_LABEL() {
		return COMP_DUM_EFF_FM_DT_LABEL;
	}

	public void setCOMP_DUM_EFF_FM_DT_LABEL(HtmlOutputLabel cOMP_DUM_EFF_FM_DT_LABEL) {
		COMP_DUM_EFF_FM_DT_LABEL = cOMP_DUM_EFF_FM_DT_LABEL;
	}

	
	
	public void validatorDUM_DUE_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_DUE_DT((Date) value);
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorDUM_EFF_TO_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_EFF_FM_DT((Date) value);
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validatorDUM_EFF_FM_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_EFF_TO_DT((Date) value);
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*added by raja on 27-06-2017 for ZBILQC-1729595*/
	
	private HtmlOutputLabel COMP_DUM_EMPLOYER_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_DUM_EMPLOYER_TYPE;

	public HtmlOutputLabel getCOMP_DUM_EMPLOYER_TYPE_LABEL() {
		return COMP_DUM_EMPLOYER_TYPE_LABEL;
	}

	public void setCOMP_DUM_EMPLOYER_TYPE_LABEL(
			HtmlOutputLabel cOMP_DUM_EMPLOYER_TYPE_LABEL) {
		COMP_DUM_EMPLOYER_TYPE_LABEL = cOMP_DUM_EMPLOYER_TYPE_LABEL;
	}

	
	
	public HtmlSelectOneMenu getCOMP_DUM_EMPLOYER_TYPE() {
		return COMP_DUM_EMPLOYER_TYPE;
	}

	public void setCOMP_DUM_EMPLOYER_TYPE(HtmlSelectOneMenu cOMP_DUM_EMPLOYER_TYPE) {
		COMP_DUM_EMPLOYER_TYPE = cOMP_DUM_EMPLOYER_TYPE;
	}

	public void validateDUM_EMPLOYER_TYPE(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value != null) {
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_EMPLOYER_TYPE((String) value);
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	private List<SelectItem> listDUM_EMPLOYER_TYPE = new ArrayList<SelectItem>();

	public List<SelectItem> getListDUM_EMPLOYER_TYPE() {
		return listDUM_EMPLOYER_TYPE;
	}

	public void setListDUM_EMPLOYER_TYPE(List<SelectItem> listDUM_EMPLOYER_TYPE) {
		this.listDUM_EMPLOYER_TYPE = listDUM_EMPLOYER_TYPE;
	}
	/*end*/
	
}
