package com.iii.pel.forms.PILT009;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_OUT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_FDL_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FDL_COVER_DESC;

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_UI_M_DOC_NO_LABEL;

	private HtmlInputText COMP_UI_M_DOC_NO;

	private HtmlOutputLabel COMP_FO_COVER_CODE_LABEL;

	private HtmlInputText COMP_FO_COVER_CODE;

	private HtmlOutputLabel COMP_FO_ASSR_CODE_LABEL;

	private HtmlInputText COMP_FO_ASSR_CODE;

	private HtmlOutputLabel COMP_FO_SA_CURR_CODE_LABEL;

	private HtmlInputText COMP_FO_SA_CURR_CODE;

	private HtmlOutputLabel COMP_FO_FC_FAC_SI_LABEL;

	private HtmlInputText COMP_FO_FC_FAC_SI;

	private HtmlOutputLabel COMP_FO_LC_FAC_SI_LABEL;

	private HtmlInputText COMP_FO_LC_FAC_SI;

	private HtmlOutputLabel COMP_FO_FAC_PERC_LABEL;

	private HtmlInputText COMP_FO_FAC_PERC;

	private HtmlOutputLabel COMP_UI_M_ASSR_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ASSR_NAME;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_UI_M_SI_CURR_DESC_LABEL;

	private HtmlInputText COMP_UI_M_SI_CURR_DESC;

	private HtmlOutputLabel COMP_UI_M_FPC_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FPC_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_FPC_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FPC_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_FPCUD_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FPCUD_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_FPCUD_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FPCUD_COVER_DESC;

	private HtmlOutputLabel COMP_UI_M_FCRD_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FCRD_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_FCRD_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FCRD_COVER_DESC;

	private HtmlOutputLabel COMP_UI_M_FPCU_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FPCU_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_FPCU_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FPCU_COVER_DESC;

	private HtmlOutputLabel COMP_UI_M_FCR_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FCR_COVER_DESC;

	private HtmlOutputLabel COMP_UI_M_FCR_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FCR_COVER_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_APPRV;

	private HtmlCommandButton COMP_UI_M_BUT_DUPLICATE;

	private HtmlCommandButton COMP_UI_M_BUT_DETL;

	private HtmlCommandButton COMP_UI_M_BUT_PART_CUST;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_RETRO;

	private List<PT_IL_FAC_OUT> dataListPT_IL_FAC_OUT;
	
	private PT_IL_FAC_OUT PT_IL_FAC_OUT_BEAN;

	private UIData dataTable;

	private DUMMY DUMMY_BEAN;

	private int currPage;

	private int recordsPerPage = 5;

	private int lastUpdatedRowIndex;

	private int prevRowIndex;

	private boolean onLoadFlag = false;
	
	PILT009_COMPOSITE_ACTION compositeAction;

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public PT_IL_FAC_OUT_ACTION() {
		DUMMY_BEAN = new DUMMY();
		dataListPT_IL_FAC_OUT = new ArrayList<PT_IL_FAC_OUT>();
		PT_IL_FAC_OUT_BEAN = new PT_IL_FAC_OUT();
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_CODE_LABEL() {
		return COMP_UI_M_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_CODE() {
		return COMP_UI_M_COVER_CODE;
	}

	public void setCOMP_UI_M_COVER_CODE_LABEL(HtmlOutputLabel COMP_UI_M_COVER_CODE_LABEL) {
		this.COMP_UI_M_COVER_CODE_LABEL = COMP_UI_M_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_COVER_CODE(HtmlInputText COMP_UI_M_COVER_CODE) {
		this.COMP_UI_M_COVER_CODE = COMP_UI_M_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FDL_COVER_DESC_LABEL() {
		return COMP_UI_M_FDL_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FDL_COVER_DESC() {
		return COMP_UI_M_FDL_COVER_DESC;
	}

	public void setCOMP_UI_M_FDL_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_FDL_COVER_DESC_LABEL) {
		this.COMP_UI_M_FDL_COVER_DESC_LABEL = COMP_UI_M_FDL_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_FDL_COVER_DESC(HtmlInputText COMP_UI_M_FDL_COVER_DESC) {
		this.COMP_UI_M_FDL_COVER_DESC = COMP_UI_M_FDL_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_LABEL) {
		this.COMP_UI_M_POL_NO_LABEL = COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText COMP_UI_M_POL_NO) {
		this.COMP_UI_M_POL_NO = COMP_UI_M_POL_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DOC_NO_LABEL() {
		return COMP_UI_M_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DOC_NO() {
		return COMP_UI_M_DOC_NO;
	}

	public void setCOMP_UI_M_DOC_NO_LABEL(HtmlOutputLabel COMP_UI_M_DOC_NO_LABEL) {
		this.COMP_UI_M_DOC_NO_LABEL = COMP_UI_M_DOC_NO_LABEL;
	}

	public void setCOMP_UI_M_DOC_NO(HtmlInputText COMP_UI_M_DOC_NO) {
		this.COMP_UI_M_DOC_NO = COMP_UI_M_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_FO_COVER_CODE_LABEL() {
		return COMP_FO_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FO_COVER_CODE() {
		return COMP_FO_COVER_CODE;
	}

	public void setCOMP_FO_COVER_CODE_LABEL(HtmlOutputLabel COMP_FO_COVER_CODE_LABEL) {
		this.COMP_FO_COVER_CODE_LABEL = COMP_FO_COVER_CODE_LABEL;
	}

	public void setCOMP_FO_COVER_CODE(HtmlInputText COMP_FO_COVER_CODE) {
		this.COMP_FO_COVER_CODE = COMP_FO_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_FO_ASSR_CODE_LABEL() {
		return COMP_FO_ASSR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FO_ASSR_CODE() {
		return COMP_FO_ASSR_CODE;
	}

	public void setCOMP_FO_ASSR_CODE_LABEL(HtmlOutputLabel COMP_FO_ASSR_CODE_LABEL) {
		this.COMP_FO_ASSR_CODE_LABEL = COMP_FO_ASSR_CODE_LABEL;
	}

	public void setCOMP_FO_ASSR_CODE(HtmlInputText COMP_FO_ASSR_CODE) {
		this.COMP_FO_ASSR_CODE = COMP_FO_ASSR_CODE;
	}

	public HtmlOutputLabel getCOMP_FO_SA_CURR_CODE_LABEL() {
		return COMP_FO_SA_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FO_SA_CURR_CODE() {
		return COMP_FO_SA_CURR_CODE;
	}

	public void setCOMP_FO_SA_CURR_CODE_LABEL(HtmlOutputLabel COMP_FO_SA_CURR_CODE_LABEL) {
		this.COMP_FO_SA_CURR_CODE_LABEL = COMP_FO_SA_CURR_CODE_LABEL;
	}

	public void setCOMP_FO_SA_CURR_CODE(HtmlInputText COMP_FO_SA_CURR_CODE) {
		this.COMP_FO_SA_CURR_CODE = COMP_FO_SA_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_FO_FC_FAC_SI_LABEL() {
		return COMP_FO_FC_FAC_SI_LABEL;
	}

	public HtmlInputText getCOMP_FO_FC_FAC_SI() {
		return COMP_FO_FC_FAC_SI;
	}

	public void setCOMP_FO_FC_FAC_SI_LABEL(HtmlOutputLabel COMP_FO_FC_FAC_SI_LABEL) {
		this.COMP_FO_FC_FAC_SI_LABEL = COMP_FO_FC_FAC_SI_LABEL;
	}

	public void setCOMP_FO_FC_FAC_SI(HtmlInputText COMP_FO_FC_FAC_SI) {
		this.COMP_FO_FC_FAC_SI = COMP_FO_FC_FAC_SI;
	}

	public HtmlOutputLabel getCOMP_FO_LC_FAC_SI_LABEL() {
		return COMP_FO_LC_FAC_SI_LABEL;
	}

	public HtmlInputText getCOMP_FO_LC_FAC_SI() {
		return COMP_FO_LC_FAC_SI;
	}

	public void setCOMP_FO_LC_FAC_SI_LABEL(HtmlOutputLabel COMP_FO_LC_FAC_SI_LABEL) {
		this.COMP_FO_LC_FAC_SI_LABEL = COMP_FO_LC_FAC_SI_LABEL;
	}

	public void setCOMP_FO_LC_FAC_SI(HtmlInputText COMP_FO_LC_FAC_SI) {
		this.COMP_FO_LC_FAC_SI = COMP_FO_LC_FAC_SI;
	}

	public HtmlOutputLabel getCOMP_FO_FAC_PERC_LABEL() {
		return COMP_FO_FAC_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FO_FAC_PERC() {
		return COMP_FO_FAC_PERC;
	}

	public void setCOMP_FO_FAC_PERC_LABEL(HtmlOutputLabel COMP_FO_FAC_PERC_LABEL) {
		this.COMP_FO_FAC_PERC_LABEL = COMP_FO_FAC_PERC_LABEL;
	}

	public void setCOMP_FO_FAC_PERC(HtmlInputText COMP_FO_FAC_PERC) {
		this.COMP_FO_FAC_PERC = COMP_FO_FAC_PERC;
	}

	public HtmlOutputLabel getCOMP_UI_M_ASSR_NAME_LABEL() {
		return COMP_UI_M_ASSR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ASSR_NAME() {
		return COMP_UI_M_ASSR_NAME;
	}

	public void setCOMP_UI_M_ASSR_NAME_LABEL(HtmlOutputLabel COMP_UI_M_ASSR_NAME_LABEL) {
		this.COMP_UI_M_ASSR_NAME_LABEL = COMP_UI_M_ASSR_NAME_LABEL;
	}

	public void setCOMP_UI_M_ASSR_NAME(HtmlInputText COMP_UI_M_ASSR_NAME) {
		this.COMP_UI_M_ASSR_NAME = COMP_UI_M_ASSR_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_LABEL() {
		return COMP_UI_M_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL) {
		this.COMP_UI_M_COVER_DESC_LABEL = COMP_UI_M_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText COMP_UI_M_COVER_DESC) {
		this.COMP_UI_M_COVER_DESC = COMP_UI_M_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_SI_CURR_DESC_LABEL() {
		return COMP_UI_M_SI_CURR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SI_CURR_DESC() {
		return COMP_UI_M_SI_CURR_DESC;
	}

	public void setCOMP_UI_M_SI_CURR_DESC_LABEL(HtmlOutputLabel COMP_UI_M_SI_CURR_DESC_LABEL) {
		this.COMP_UI_M_SI_CURR_DESC_LABEL = COMP_UI_M_SI_CURR_DESC_LABEL;
	}

	public void setCOMP_UI_M_SI_CURR_DESC(HtmlInputText COMP_UI_M_SI_CURR_DESC) {
		this.COMP_UI_M_SI_CURR_DESC = COMP_UI_M_SI_CURR_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPC_COVER_CODE_LABEL() {
		return COMP_UI_M_FPC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPC_COVER_CODE() {
		return COMP_UI_M_FPC_COVER_CODE;
	}

	public void setCOMP_UI_M_FPC_COVER_CODE_LABEL(HtmlOutputLabel COMP_UI_M_FPC_COVER_CODE_LABEL) {
		this.COMP_UI_M_FPC_COVER_CODE_LABEL = COMP_UI_M_FPC_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FPC_COVER_CODE(HtmlInputText COMP_UI_M_FPC_COVER_CODE) {
		this.COMP_UI_M_FPC_COVER_CODE = COMP_UI_M_FPC_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPC_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_FPC_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPC_COVER_CODE_DESC() {
		return COMP_UI_M_FPC_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_FPC_COVER_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_FPC_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_FPC_COVER_CODE_DESC_LABEL = COMP_UI_M_FPC_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_FPC_COVER_CODE_DESC(HtmlInputText COMP_UI_M_FPC_COVER_CODE_DESC) {
		this.COMP_UI_M_FPC_COVER_CODE_DESC = COMP_UI_M_FPC_COVER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPCUD_COVER_CODE_LABEL() {
		return COMP_UI_M_FPCUD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPCUD_COVER_CODE() {
		return COMP_UI_M_FPCUD_COVER_CODE;
	}

	public void setCOMP_UI_M_FPCUD_COVER_CODE_LABEL(HtmlOutputLabel COMP_UI_M_FPCUD_COVER_CODE_LABEL) {
		this.COMP_UI_M_FPCUD_COVER_CODE_LABEL = COMP_UI_M_FPCUD_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FPCUD_COVER_CODE(HtmlInputText COMP_UI_M_FPCUD_COVER_CODE) {
		this.COMP_UI_M_FPCUD_COVER_CODE = COMP_UI_M_FPCUD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPCUD_COVER_DESC_LABEL() {
		return COMP_UI_M_FPCUD_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPCUD_COVER_DESC() {
		return COMP_UI_M_FPCUD_COVER_DESC;
	}

	public void setCOMP_UI_M_FPCUD_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_FPCUD_COVER_DESC_LABEL) {
		this.COMP_UI_M_FPCUD_COVER_DESC_LABEL = COMP_UI_M_FPCUD_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_FPCUD_COVER_DESC(HtmlInputText COMP_UI_M_FPCUD_COVER_DESC) {
		this.COMP_UI_M_FPCUD_COVER_DESC = COMP_UI_M_FPCUD_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_FCRD_COVER_CODE_LABEL() {
		return COMP_UI_M_FCRD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FCRD_COVER_CODE() {
		return COMP_UI_M_FCRD_COVER_CODE;
	}

	public void setCOMP_UI_M_FCRD_COVER_CODE_LABEL(HtmlOutputLabel COMP_UI_M_FCRD_COVER_CODE_LABEL) {
		this.COMP_UI_M_FCRD_COVER_CODE_LABEL = COMP_UI_M_FCRD_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FCRD_COVER_CODE(HtmlInputText COMP_UI_M_FCRD_COVER_CODE) {
		this.COMP_UI_M_FCRD_COVER_CODE = COMP_UI_M_FCRD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FCRD_COVER_DESC_LABEL() {
		return COMP_UI_M_FCRD_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FCRD_COVER_DESC() {
		return COMP_UI_M_FCRD_COVER_DESC;
	}

	public void setCOMP_UI_M_FCRD_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_FCRD_COVER_DESC_LABEL) {
		this.COMP_UI_M_FCRD_COVER_DESC_LABEL = COMP_UI_M_FCRD_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_FCRD_COVER_DESC(HtmlInputText COMP_UI_M_FCRD_COVER_DESC) {
		this.COMP_UI_M_FCRD_COVER_DESC = COMP_UI_M_FCRD_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPCU_COVER_CODE_LABEL() {
		return COMP_UI_M_FPCU_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPCU_COVER_CODE() {
		return COMP_UI_M_FPCU_COVER_CODE;
	}

	public void setCOMP_UI_M_FPCU_COVER_CODE_LABEL(HtmlOutputLabel COMP_UI_M_FPCU_COVER_CODE_LABEL) {
		this.COMP_UI_M_FPCU_COVER_CODE_LABEL = COMP_UI_M_FPCU_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FPCU_COVER_CODE(HtmlInputText COMP_UI_M_FPCU_COVER_CODE) {
		this.COMP_UI_M_FPCU_COVER_CODE = COMP_UI_M_FPCU_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPCU_COVER_DESC_LABEL() {
		return COMP_UI_M_FPCU_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPCU_COVER_DESC() {
		return COMP_UI_M_FPCU_COVER_DESC;
	}

	public void setCOMP_UI_M_FPCU_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_FPCU_COVER_DESC_LABEL) {
		this.COMP_UI_M_FPCU_COVER_DESC_LABEL = COMP_UI_M_FPCU_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_FPCU_COVER_DESC(HtmlInputText COMP_UI_M_FPCU_COVER_DESC) {
		this.COMP_UI_M_FPCU_COVER_DESC = COMP_UI_M_FPCU_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_FCR_COVER_DESC_LABEL() {
		return COMP_UI_M_FCR_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FCR_COVER_DESC() {
		return COMP_UI_M_FCR_COVER_DESC;
	}

	public void setCOMP_UI_M_FCR_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_FCR_COVER_DESC_LABEL) {
		this.COMP_UI_M_FCR_COVER_DESC_LABEL = COMP_UI_M_FCR_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_FCR_COVER_DESC(HtmlInputText COMP_UI_M_FCR_COVER_DESC) {
		this.COMP_UI_M_FCR_COVER_DESC = COMP_UI_M_FCR_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_FCR_COVER_CODE_LABEL() {
		return COMP_UI_M_FCR_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FCR_COVER_CODE() {
		return COMP_UI_M_FCR_COVER_CODE;
	}

	public void setCOMP_UI_M_FCR_COVER_CODE_LABEL(HtmlOutputLabel COMP_UI_M_FCR_COVER_CODE_LABEL) {
		this.COMP_UI_M_FCR_COVER_CODE_LABEL = COMP_UI_M_FCR_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FCR_COVER_CODE(HtmlInputText COMP_UI_M_FCR_COVER_CODE) {
		this.COMP_UI_M_FCR_COVER_CODE = COMP_UI_M_FCR_COVER_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPRV() {
		return COMP_UI_M_BUT_APPRV;
	}

	public void setCOMP_UI_M_BUT_APPRV(HtmlCommandButton COMP_UI_M_BUT_APPRV) {
		this.COMP_UI_M_BUT_APPRV = COMP_UI_M_BUT_APPRV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DUPLICATE() {
		return COMP_UI_M_BUT_DUPLICATE;
	}

	public void setCOMP_UI_M_BUT_DUPLICATE(HtmlCommandButton COMP_UI_M_BUT_DUPLICATE) {
		this.COMP_UI_M_BUT_DUPLICATE = COMP_UI_M_BUT_DUPLICATE;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public List<PT_IL_FAC_OUT> getDataListPT_IL_FAC_OUT() {
		return dataListPT_IL_FAC_OUT;
	}

	public void setDataListPT_IL_FAC_OUT(List<PT_IL_FAC_OUT> dataListPT_IL_FAC_OUT) {
		this.dataListPT_IL_FAC_OUT = dataListPT_IL_FAC_OUT;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}


	public HtmlCommandButton getCOMP_UI_M_BUT_DETL() {
		return COMP_UI_M_BUT_DETL;
	}

	public void setCOMP_UI_M_BUT_DETL(HtmlCommandButton comp_ui_m_but_detl) {
		COMP_UI_M_BUT_DETL = comp_ui_m_but_detl;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_RETRO() {
		return COMP_UI_M_BUT_CUST_RETRO;
	}

	public void setCOMP_UI_M_BUT_CUST_RETRO(
			HtmlCommandButton comp_ui_m_but_cust_retro) {
		COMP_UI_M_BUT_CUST_RETRO = comp_ui_m_but_cust_retro;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PART_CUST() {
		return COMP_UI_M_BUT_PART_CUST;
	}

	public void setCOMP_UI_M_BUT_PART_CUST(HtmlCommandButton comp_ui_m_but_part_cust) {
		COMP_UI_M_BUT_PART_CUST = comp_ui_m_but_part_cust;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}
	
	private boolean preFormFlag = false;

	public boolean isPreFormFlag() {
		return preFormFlag;
	}

	public void setPreFormFlag(boolean preFormFlag) {
		this.preFormFlag = preFormFlag;
	}

	public void onPageLoad(PhaseEvent event) {
		try {
			if (!isOnLoadFlag()) {
				PT_IL_FAC_OUT_HELPER helper = new PT_IL_FAC_OUT_HELPER();
				try {
					if(!isPreFormFlag()){
						helper.PILT009_PRE_FORM(compositeAction);
						helper.PILT009_WHEN_NEW_FORM_INSTANCE(this);
					}
					helper.PT_IL_FAC_OUT_WHEN_NEW_BLOCK_INSTANCE(this);
					helper.PT_IL_FAC_OUT_WHEN_NEW_RECORD_INSTANCE(this.getPT_IL_FAC_OUT_BEAN());
					
				} catch (Exception e) {
					e.printStackTrace();
					getErrorMap().put("current",e.getMessage());
					getErrorMap().put("detail",e.getMessage());
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}
				setPreFormFlag(true);
				setOnLoadFlag(true);
				
			}
//			getErrorMap().clear();
//			getWarningMap().clear();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}

	// [ Added for grid implementation change, Added by: Rajesh Kundala, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	/*public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	*/
	public void saveCurrentRecord(ActionEvent event) {
		String outcome = null;
		// int rowIndex = dataTable.getRowIndex();

		try {
			// Calling last Column listener
			lastColumnListener();
			if (!dataListPT_IL_FAC_OUT.contains(getPT_IL_FAC_OUT_BEAN())) {
				dataListPT_IL_FAC_OUT.add(getPT_IL_FAC_OUT_BEAN());
				
			}
			PT_IL_FAC_OUT_BEAN.setRowSelected(true);

		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}
		}

	// Added for grid implementation change, Added by: Rajesh Kundala, Dated: 16-Feb-2009 ]
	
	public void checkBoxStatus(ActionEvent actionEvent)	{

		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		getDataListPT_IL_FAC_OUT().get(rowIndex).setCHECK_BOX(check);
	}

	public void FO_FAC_PERC_WHEN_VALIDATE_ITEM(ActionEvent event) {

		//int rowIndex = getDataTable().getRowIndex();
		String value = getCurrentValue(event);
		value = value == "" ? null : value;

	
		getPT_IL_FAC_OUT_BEAN().setFO_FAC_PERC(CommonUtils.parseToDouble(value));

		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

//		lastColumnListener();
	}

	public void validateFO_FAC_PERC(FacesContext fc, UIComponent component,
			Object value) {

		//int rowIndex = getDataTable().getRowIndex();
		PT_IL_FAC_OUT_HELPER helper = new PT_IL_FAC_OUT_HELPER();
		try {
			helper.FO_FAC_PERC_WHEN_VALIDATE_ITEM(getPT_IL_FAC_OUT_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	private String getCurrentValue(ActionEvent event) {
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

	private void lastColumnListener() {

		

		PT_IL_FAC_OUT PT_IL_FAC_OUT_BEAN = null;
		PT_IL_FAC_OUT_HELPER helper = new PT_IL_FAC_OUT_HELPER();

		try {
			// Get the bean based on row index
		
				PT_IL_FAC_OUT_BEAN =  getPT_IL_FAC_OUT_BEAN();

				// Update the record to database
				if (PT_IL_FAC_OUT_BEAN.getROWID() != null) {

					helper.PT_IL_FAC_OUT_PRE_UPDATE(PT_IL_FAC_OUT_BEAN);
					helper.updateData(PT_IL_FAC_OUT_BEAN);

					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				} else {

					helper.PT_IL_FAC_OUT_PRE_INSERT(PT_IL_FAC_OUT_BEAN);
					helper.updateData(PT_IL_FAC_OUT_BEAN);

					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				}
				
			}

		 catch (Exception e1) {
			e1.printStackTrace();
			getErrorMap().put("current", e1.getMessage());
			getErrorMap().put("detail", e1.getMessage());
		}
		return;
	}

	public void save() {
		try {
			new PT_IL_FAC_OUT_HELPER().keyCommit();
			getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
	}

	/*private PT_IL_FAC_OUT getSelectedBean() throws Exception {

		PT_IL_FAC_OUT facOutBean = null;
		int clickCount = 0;

		for(PT_IL_FAC_OUT tempBean : getDataListPT_IL_FAC_OUT()) {

			if(tempBean.isCHECK_BOX()) {
				facOutBean = tempBean;
				clickCount++;
			}
		}

		if(clickCount < 1) {
			throw new Exception("Please select one row");
		} else if(clickCount > 1) {
			throw new Exception("Please select only one row");
		}

		return facOutBean;
	}*/

	public String callFacDtls() {

		String returnValue = null;
		CommonUtils commonUtils = new CommonUtils();

		try {

			PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils
			.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
			PT_IL_FAC_OUT facOutBean =getPT_IL_FAC_OUT_BEAN();
			compositeAction.getPILT009_PT_IL_FAC_DETL_ACTION().setPT_IL_FAC_OUT_BEAN(facOutBean);
			compositeAction.getPILT009_PT_IL_FAC_DETL_ACTION().setBlockFlag(true);
			
			returnValue = "gotoFacDtls";

		} catch (Exception e) {
			getWarningMap().put("current", e.getMessage());
			getWarningMap().put("detail", e.getMessage());
		}
		return returnValue;
	}

	public String callFacPartCust() {

		String returnValue = null;
		CommonUtils commonUtils = new CommonUtils();

		try {

			/*PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils
			.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");*/
			PT_IL_FAC_OUT facOutBean = getPT_IL_FAC_OUT_BEAN();
			compositeAction.getPILT009_PT_IL_FAC_PART_CUST_ACTION().setPT_IL_FAC_OUT_BEAN(facOutBean);
			compositeAction.getPILT009_PT_IL_FAC_PART_CUST_ACTION().setBlockFlag(true);
			returnValue = "gotoFacPartCust";

		} catch (Exception e) {
			getWarningMap().put("current", e.getMessage());
			getWarningMap().put("detail", e.getMessage());
		}

		return returnValue;
	}


	public String callCustRetro() {
		String returnValue = null;
		CommonUtils commonUtils = new CommonUtils();

		try {

			PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils
			.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
			
			PT_IL_FAC_OUT facOutBean = getPT_IL_FAC_OUT_BEAN();
			compositeAction.getPILT009_PT_IL_FAC_CUST_RETRO_ACTION().setPT_IL_FAC_OUT_BEAN(facOutBean);
			returnValue = "gotoCustRetro";

		} catch (Exception e) {
			getWarningMap().put("current", e.getMessage());
			getWarningMap().put("detail", e.getMessage());
		}

		return returnValue;
	}

	public String backToCallingForm() {
		String returnValue = null;; 
		CommonUtils commonUtils = new CommonUtils();
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");

		returnValue = compositeAction.getCALLING_FORM();
		
		commonUtils.clearMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		
		/*CHANGED BY RAJA ON 16-08-2017 FOR ZBILQC-1735417*/
		if("PILT003".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM"))/*||"PILT009".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM"))*/){
			/*END*/
			returnValue = "PILT003_APAC_PT_IL_PREM_COLL";
		}else{
			returnValue="PILT010";
		}
		
		return returnValue;
	}
	
	public String approveButton(){
		String returnValue = null;
		try {
			returnValue = new PT_IL_FAC_OUT_HELPER().approveButton();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
			return null;
		}
		return returnValue;
	}

	public PT_IL_FAC_OUT getPT_IL_FAC_OUT_BEAN() {
		return PT_IL_FAC_OUT_BEAN;
	}

	public void setPT_IL_FAC_OUT_BEAN(PT_IL_FAC_OUT pt_il_fac_out_bean) {
		PT_IL_FAC_OUT_BEAN = pt_il_fac_out_bean;
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_FAC_OUT_BEAN = (PT_IL_FAC_OUT) dataTable.getRowData();
			new PT_IL_FAC_OUT_HELPER().EXECUTE_QUERY(DUMMY_BEAN);
			resetSelectedRow();
			PT_IL_FAC_OUT_BEAN.setRowSelected(true);
			resetAllComponent();
			
		} catch (Exception e) {
			getErrorMap()
					.put(
							com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			getErrorMap().put("displayRecords", e.getMessage());
		}
	}

	public void resetSelectedRow() {
		Iterator<PT_IL_FAC_OUT> iterator = dataListPT_IL_FAC_OUT.iterator();

		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		//COMP_UI_M_COVER_CODE.resetValue();
		//COMP_UI_M_FDL_COVER_DESC.resetValue();
		//COMP_UI_M_POL_NO.resetValue();
		//COMP_UI_M_DOC_NO.resetValue();
		//COMP_FO_COVER_CODE.resetValue();
		COMP_FO_ASSR_CODE.resetValue();
		COMP_FO_SA_CURR_CODE.resetValue();
		COMP_FO_FC_FAC_SI.resetValue();
		COMP_FO_LC_FAC_SI.resetValue();
		COMP_FO_FAC_PERC.resetValue();
		COMP_UI_M_ASSR_NAME.resetValue();
		COMP_UI_M_COVER_DESC.resetValue();
		COMP_FO_COVER_CODE.resetValue();
		COMP_UI_M_SI_CURR_DESC.resetValue();
		//COMP_UI_M_FPC_COVER_CODE.resetValue();
		//COMP_UI_M_FPC_COVER_CODE_DESC.resetValue();
		//COMP_UI_M_FPCUD_COVER_CODE.resetValue();
		//COMP_UI_M_FPCUD_COVER_DESC.resetValue();
		//COMP_UI_M_FCRD_COVER_CODE.resetValue();
		//COMP_UI_M_FCRD_COVER_DESC.resetValue();
		//COMP_UI_M_FPCU_COVER_CODE.resetValue();
		//COMP_UI_M_FPCU_COVER_DESC.resetValue();
		//COMP_UI_M_FCR_COVER_DESC.resetValue();
		//COMP_UI_M_FCR_COVER_CODE.resetValue();


	}
	
	
}
