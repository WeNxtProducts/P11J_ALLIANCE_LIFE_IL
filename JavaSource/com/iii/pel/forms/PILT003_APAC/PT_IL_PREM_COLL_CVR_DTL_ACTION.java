package com.iii.pel.forms.PILT003_APAC;

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

public class PT_IL_PREM_COLL_CVR_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PCCD_COVER_CODE_LABEL;

	private HtmlInputText COMP_PCCD_COVER_CODE;

	private HtmlOutputLabel COMP_PCCD_FC_RISK_PREM_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_RISK_PREM_AMT;

	private HtmlOutputLabel COMP_PCCD_FC_INV_PREM_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_INV_PREM_AMT;

	private HtmlOutputLabel COMP_PCCD_FC_RISK_DISC_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_RISK_DISC_AMT;

	private HtmlOutputLabel COMP_PCCD_FC_INV_DISC_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_INV_DISC_AMT;

	private HtmlOutputLabel COMP_PCCD_FC_RISK_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_RISK_LOAD_AMT;

	private HtmlOutputLabel COMP_PCCD_FC_INV_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_INV_LOAD_AMT;

	private HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK_LABEL;

	private HtmlInputText COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK;

	private HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV_LABEL;

	private HtmlInputText COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV;

	private HtmlOutputLabel COMP_PCCD_LC_RISK_PREM_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_RISK_PREM_AMT;

	private HtmlOutputLabel COMP_PCCD_LC_INV_PREM_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_INV_PREM_AMT;

	private HtmlOutputLabel COMP_PCCD_LC_RISK_DISC_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_RISK_DISC_AMT;

	private HtmlOutputLabel COMP_PCCD_LC_INV_DISC_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_INV_DISC_AMT;

	private HtmlOutputLabel COMP_PCCD_LC_RISK_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_RISK_LOAD_AMT;

	private HtmlOutputLabel COMP_PCCD_LC_INV_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_INV_LOAD_AMT;

	private HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK_LABEL;

	private HtmlInputText COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK;

	private HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV_LABEL;

	private HtmlInputText COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV;

	private HtmlOutputLabel COMP_UI_M_PCCD_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PCCD_COVER_DESC;
	
	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private PT_IL_PREM_COLL_CVR_DTL PT_IL_PREM_COLL_CVR_DTL_BEAN;

	public PILT003_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_PREM_COLL_CVR_DTL_HELPER helper;

	private List<PT_IL_PREM_COLL_CVR_DTL> dataList_PT_IL_PREM_COLL_CVR_DTL = new ArrayList<PT_IL_PREM_COLL_CVR_DTL>();

	 private UIData dataTable;



	public PT_IL_PREM_COLL_CVR_DTL_ACTION() {

		PT_IL_PREM_COLL_CVR_DTL_BEAN = new PT_IL_PREM_COLL_CVR_DTL();
		helper = new PT_IL_PREM_COLL_CVR_DTL_HELPER();
		COMP_UI_M_BUT_MAIN = new HtmlCommandButton();
	}

	public HtmlOutputLabel getCOMP_PCCD_COVER_CODE_LABEL() {
		return COMP_PCCD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_COVER_CODE() {
		return COMP_PCCD_COVER_CODE;
	}

	public void setCOMP_PCCD_COVER_CODE_LABEL(HtmlOutputLabel COMP_PCCD_COVER_CODE_LABEL) {
		this.COMP_PCCD_COVER_CODE_LABEL = COMP_PCCD_COVER_CODE_LABEL;
	}

	public void setCOMP_PCCD_COVER_CODE(HtmlInputText COMP_PCCD_COVER_CODE) {
		this.COMP_PCCD_COVER_CODE = COMP_PCCD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_RISK_PREM_AMT_LABEL() {
		return COMP_PCCD_FC_RISK_PREM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_RISK_PREM_AMT() {
		return COMP_PCCD_FC_RISK_PREM_AMT;
	}

	public void setCOMP_PCCD_FC_RISK_PREM_AMT_LABEL(HtmlOutputLabel COMP_PCCD_FC_RISK_PREM_AMT_LABEL) {
		this.COMP_PCCD_FC_RISK_PREM_AMT_LABEL = COMP_PCCD_FC_RISK_PREM_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_RISK_PREM_AMT(HtmlInputText COMP_PCCD_FC_RISK_PREM_AMT) {
		this.COMP_PCCD_FC_RISK_PREM_AMT = COMP_PCCD_FC_RISK_PREM_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_INV_PREM_AMT_LABEL() {
		return COMP_PCCD_FC_INV_PREM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_INV_PREM_AMT() {
		return COMP_PCCD_FC_INV_PREM_AMT;
	}

	public void setCOMP_PCCD_FC_INV_PREM_AMT_LABEL(HtmlOutputLabel COMP_PCCD_FC_INV_PREM_AMT_LABEL) {
		this.COMP_PCCD_FC_INV_PREM_AMT_LABEL = COMP_PCCD_FC_INV_PREM_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_INV_PREM_AMT(HtmlInputText COMP_PCCD_FC_INV_PREM_AMT) {
		this.COMP_PCCD_FC_INV_PREM_AMT = COMP_PCCD_FC_INV_PREM_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_RISK_DISC_AMT_LABEL() {
		return COMP_PCCD_FC_RISK_DISC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_RISK_DISC_AMT() {
		return COMP_PCCD_FC_RISK_DISC_AMT;
	}

	public void setCOMP_PCCD_FC_RISK_DISC_AMT_LABEL(HtmlOutputLabel COMP_PCCD_FC_RISK_DISC_AMT_LABEL) {
		this.COMP_PCCD_FC_RISK_DISC_AMT_LABEL = COMP_PCCD_FC_RISK_DISC_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_RISK_DISC_AMT(HtmlInputText COMP_PCCD_FC_RISK_DISC_AMT) {
		this.COMP_PCCD_FC_RISK_DISC_AMT = COMP_PCCD_FC_RISK_DISC_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_INV_DISC_AMT_LABEL() {
		return COMP_PCCD_FC_INV_DISC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_INV_DISC_AMT() {
		return COMP_PCCD_FC_INV_DISC_AMT;
	}

	public void setCOMP_PCCD_FC_INV_DISC_AMT_LABEL(HtmlOutputLabel COMP_PCCD_FC_INV_DISC_AMT_LABEL) {
		this.COMP_PCCD_FC_INV_DISC_AMT_LABEL = COMP_PCCD_FC_INV_DISC_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_INV_DISC_AMT(HtmlInputText COMP_PCCD_FC_INV_DISC_AMT) {
		this.COMP_PCCD_FC_INV_DISC_AMT = COMP_PCCD_FC_INV_DISC_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_RISK_LOAD_AMT_LABEL() {
		return COMP_PCCD_FC_RISK_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_RISK_LOAD_AMT() {
		return COMP_PCCD_FC_RISK_LOAD_AMT;
	}

	public void setCOMP_PCCD_FC_RISK_LOAD_AMT_LABEL(HtmlOutputLabel COMP_PCCD_FC_RISK_LOAD_AMT_LABEL) {
		this.COMP_PCCD_FC_RISK_LOAD_AMT_LABEL = COMP_PCCD_FC_RISK_LOAD_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_RISK_LOAD_AMT(HtmlInputText COMP_PCCD_FC_RISK_LOAD_AMT) {
		this.COMP_PCCD_FC_RISK_LOAD_AMT = COMP_PCCD_FC_RISK_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_INV_LOAD_AMT_LABEL() {
		return COMP_PCCD_FC_INV_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_INV_LOAD_AMT() {
		return COMP_PCCD_FC_INV_LOAD_AMT;
	}

	public void setCOMP_PCCD_FC_INV_LOAD_AMT_LABEL(HtmlOutputLabel COMP_PCCD_FC_INV_LOAD_AMT_LABEL) {
		this.COMP_PCCD_FC_INV_LOAD_AMT_LABEL = COMP_PCCD_FC_INV_LOAD_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_INV_LOAD_AMT(HtmlInputText COMP_PCCD_FC_INV_LOAD_AMT) {
		this.COMP_PCCD_FC_INV_LOAD_AMT = COMP_PCCD_FC_INV_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK_LABEL() {
		return COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK() {
		return COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK_LABEL(HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK_LABEL) {
		this.COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK_LABEL = COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK_LABEL;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK(HtmlInputText COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK) {
		this.COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK = COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV_LABEL() {
		return COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV() {
		return COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV_LABEL(HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV_LABEL) {
		this.COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV_LABEL = COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV_LABEL;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV(HtmlInputText COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV) {
		this.COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV = COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_RISK_PREM_AMT_LABEL() {
		return COMP_PCCD_LC_RISK_PREM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_RISK_PREM_AMT() {
		return COMP_PCCD_LC_RISK_PREM_AMT;
	}

	public void setCOMP_PCCD_LC_RISK_PREM_AMT_LABEL(HtmlOutputLabel COMP_PCCD_LC_RISK_PREM_AMT_LABEL) {
		this.COMP_PCCD_LC_RISK_PREM_AMT_LABEL = COMP_PCCD_LC_RISK_PREM_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_RISK_PREM_AMT(HtmlInputText COMP_PCCD_LC_RISK_PREM_AMT) {
		this.COMP_PCCD_LC_RISK_PREM_AMT = COMP_PCCD_LC_RISK_PREM_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_INV_PREM_AMT_LABEL() {
		return COMP_PCCD_LC_INV_PREM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_INV_PREM_AMT() {
		return COMP_PCCD_LC_INV_PREM_AMT;
	}

	public void setCOMP_PCCD_LC_INV_PREM_AMT_LABEL(HtmlOutputLabel COMP_PCCD_LC_INV_PREM_AMT_LABEL) {
		this.COMP_PCCD_LC_INV_PREM_AMT_LABEL = COMP_PCCD_LC_INV_PREM_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_INV_PREM_AMT(HtmlInputText COMP_PCCD_LC_INV_PREM_AMT) {
		this.COMP_PCCD_LC_INV_PREM_AMT = COMP_PCCD_LC_INV_PREM_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_RISK_DISC_AMT_LABEL() {
		return COMP_PCCD_LC_RISK_DISC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_RISK_DISC_AMT() {
		return COMP_PCCD_LC_RISK_DISC_AMT;
	}

	public void setCOMP_PCCD_LC_RISK_DISC_AMT_LABEL(HtmlOutputLabel COMP_PCCD_LC_RISK_DISC_AMT_LABEL) {
		this.COMP_PCCD_LC_RISK_DISC_AMT_LABEL = COMP_PCCD_LC_RISK_DISC_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_RISK_DISC_AMT(HtmlInputText COMP_PCCD_LC_RISK_DISC_AMT) {
		this.COMP_PCCD_LC_RISK_DISC_AMT = COMP_PCCD_LC_RISK_DISC_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_INV_DISC_AMT_LABEL() {
		return COMP_PCCD_LC_INV_DISC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_INV_DISC_AMT() {
		return COMP_PCCD_LC_INV_DISC_AMT;
	}

	public void setCOMP_PCCD_LC_INV_DISC_AMT_LABEL(HtmlOutputLabel COMP_PCCD_LC_INV_DISC_AMT_LABEL) {
		this.COMP_PCCD_LC_INV_DISC_AMT_LABEL = COMP_PCCD_LC_INV_DISC_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_INV_DISC_AMT(HtmlInputText COMP_PCCD_LC_INV_DISC_AMT) {
		this.COMP_PCCD_LC_INV_DISC_AMT = COMP_PCCD_LC_INV_DISC_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_RISK_LOAD_AMT_LABEL() {
		return COMP_PCCD_LC_RISK_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_RISK_LOAD_AMT() {
		return COMP_PCCD_LC_RISK_LOAD_AMT;
	}

	public void setCOMP_PCCD_LC_RISK_LOAD_AMT_LABEL(HtmlOutputLabel COMP_PCCD_LC_RISK_LOAD_AMT_LABEL) {
		this.COMP_PCCD_LC_RISK_LOAD_AMT_LABEL = COMP_PCCD_LC_RISK_LOAD_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_RISK_LOAD_AMT(HtmlInputText COMP_PCCD_LC_RISK_LOAD_AMT) {
		this.COMP_PCCD_LC_RISK_LOAD_AMT = COMP_PCCD_LC_RISK_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_INV_LOAD_AMT_LABEL() {
		return COMP_PCCD_LC_INV_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_INV_LOAD_AMT() {
		return COMP_PCCD_LC_INV_LOAD_AMT;
	}

	public void setCOMP_PCCD_LC_INV_LOAD_AMT_LABEL(HtmlOutputLabel COMP_PCCD_LC_INV_LOAD_AMT_LABEL) {
		this.COMP_PCCD_LC_INV_LOAD_AMT_LABEL = COMP_PCCD_LC_INV_LOAD_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_INV_LOAD_AMT(HtmlInputText COMP_PCCD_LC_INV_LOAD_AMT) {
		this.COMP_PCCD_LC_INV_LOAD_AMT = COMP_PCCD_LC_INV_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK_LABEL() {
		return COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK() {
		return COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK_LABEL(HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK_LABEL) {
		this.COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK_LABEL = COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK_LABEL;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK(HtmlInputText COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK) {
		this.COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK = COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV_LABEL() {
		return COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV() {
		return COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV_LABEL(HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV_LABEL) {
		this.COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV_LABEL = COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV_LABEL;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV(HtmlInputText COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV) {
		this.COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV = COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCCD_COVER_DESC_LABEL() {
		return COMP_UI_M_PCCD_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCCD_COVER_DESC() {
		return COMP_UI_M_PCCD_COVER_DESC;
	}

	public void setCOMP_UI_M_PCCD_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PCCD_COVER_DESC_LABEL) {
		this.COMP_UI_M_PCCD_COVER_DESC_LABEL = COMP_UI_M_PCCD_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_PCCD_COVER_DESC(HtmlInputText COMP_UI_M_PCCD_COVER_DESC) {
		this.COMP_UI_M_PCCD_COVER_DESC = COMP_UI_M_PCCD_COVER_DESC;
	}

	public PT_IL_PREM_COLL_CVR_DTL getPT_IL_PREM_COLL_CVR_DTL_BEAN() {
		return PT_IL_PREM_COLL_CVR_DTL_BEAN;
	}

	public void setPT_IL_PREM_COLL_CVR_DTL_BEAN(PT_IL_PREM_COLL_CVR_DTL PT_IL_PREM_COLL_CVR_DTL_BEAN) {
		this.PT_IL_PREM_COLL_CVR_DTL_BEAN = PT_IL_PREM_COLL_CVR_DTL_BEAN;
	}

	public List<PT_IL_PREM_COLL_CVR_DTL> getDataList_PT_IL_PREM_COLL_CVR_DTL() {
		return dataList_PT_IL_PREM_COLL_CVR_DTL;
	}

	public void setDataListPT_IL_PREM_COLL_CVR_DTL(List<PT_IL_PREM_COLL_CVR_DTL> dataList_PT_IL_PREM_COLL_CVR_DTL) {
		this.dataList_PT_IL_PREM_COLL_CVR_DTL = dataList_PT_IL_PREM_COLL_CVR_DTL;
	}

	public void addRow(ActionEvent event){
	try{
	if (isINSERT_ALLOWED()){
	PT_IL_PREM_COLL_CVR_DTL_BEAN = new PT_IL_PREM_COLL_CVR_DTL();
	//resetAllComponent();
	resetSelectedRow();
	}else{
	
	getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
	getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
	}
	
	}catch(Exception exc){
	getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
	getErrorMap().put("addRow",exc.getMessage());
	}
	
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_PREM_COLL_CVR_DTL_BEAN = (PT_IL_PREM_COLL_CVR_DTL) dataTable.getRowData();
			 helper.POST_QUERY(PT_IL_PREM_COLL_CVR_DTL_BEAN);
			 resetAllComponent();
			// Reset selection for other beans
			resetSelectedRow();
			PT_IL_PREM_COLL_CVR_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	public void resetAllComponent(){
		   COMP_PCCD_COVER_CODE.resetValue();
		   COMP_PCCD_FC_RISK_PREM_AMT.resetValue();
		   COMP_PCCD_FC_INV_PREM_AMT.resetValue();
		   COMP_PCCD_FC_RISK_DISC_AMT.resetValue();
		   COMP_PCCD_FC_INV_DISC_AMT.resetValue();
		   COMP_PCCD_FC_RISK_LOAD_AMT.resetValue();
		   COMP_PCCD_FC_INV_LOAD_AMT.resetValue();
		   //COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_RISK.resetValue();
		   COMP_UI_M_PCCD_TOTAL_FC_CVR_PREM_INV.resetValue();
		   COMP_PCCD_LC_RISK_PREM_AMT.resetValue();
		   COMP_PCCD_LC_INV_PREM_AMT.resetValue();
		   COMP_PCCD_LC_RISK_DISC_AMT.resetValue();
		   COMP_PCCD_LC_INV_DISC_AMT.resetValue();
		   COMP_PCCD_LC_RISK_LOAD_AMT.resetValue();
		   COMP_PCCD_LC_INV_LOAD_AMT.resetValue();
		   COMP_UI_M_PCCD_TOTAL_LC_CR_PREM_RISK.resetValue();
		   COMP_UI_M_PCCD_TOTAL_LC_CVR_PREM_INV.resetValue();
		   COMP_UI_M_PCCD_COVER_DESC.resetValue();
		   
	   }
	
	private void resetSelectedRow() {
		Iterator<PT_IL_PREM_COLL_CVR_DTL> PT_IL_PREM_COLL_CVR_ITR = dataList_PT_IL_PREM_COLL_CVR_DTL
				.iterator();
		while (PT_IL_PREM_COLL_CVR_ITR.hasNext()) {
			PT_IL_PREM_COLL_CVR_ITR.next().setRowSelected(false);
		}
	}
	
	
	public void onLoad(PhaseEvent event){
		 try {
				if (isBlockFlag()) {
					if(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getROWID() != null){
					  helper.executeQuery(compositeAction);
					  helper.POST_QUERY(PT_IL_PREM_COLL_CVR_DTL_BEAN);
					}
				}
		       setBlockFlag(false);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			} 
	 }


	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	 public void validatePCCD_COVER_CODE(FacesContext facesContext,
			    UIComponent component, Object value) throws ValidatorException {
			CommonUtils.clearMaps(this);
			try {
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_COVER_CODE((String)value);
			    //helper.WHEN_VALIDATE_PCCD_COVER_CODE(PT_IL_PREM_COLL_CVR_DTL_BEAN);
			    } catch (Exception exception) {
			    exception.printStackTrace();
			    throw new ValidatorException(new FacesMessage(exception
				    .getMessage()));
			} finally {
			    try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
					.getConnection(), "PCCD_COVER_CODE",
					getWarningMap());
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			}
		    }
	 
	 public String mainBtnAction(){
		 setBlockFlag(true);
		 return "PILT003_APAC_PT_IL_PREM_COLL";
	 }

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton comp_ui_m_but_main) {
		COMP_UI_M_BUT_MAIN = comp_ui_m_but_main;
	}
}