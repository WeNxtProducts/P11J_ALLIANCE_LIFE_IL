package com.iii.pel.forms.PILT006_APAC;

import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;

public class PS_IL_CLAIM_LIMITS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CL_POL_YEAR_LABEL;

	private HtmlInputText COMP_CL_POL_YEAR;

	private HtmlOutputLabel COMP_CL_PROD_CODE_LABEL;

	private HtmlInputText COMP_CL_PROD_CODE;

	private HtmlOutputLabel COMP_CL_COVER_GROUP_CODE_LABEL;

	private HtmlInputText COMP_CL_COVER_GROUP_CODE;

	private HtmlOutputLabel COMP_CL_COVER_CODE_LABEL;

	private HtmlInputText COMP_CL_COVER_CODE;

	private HtmlOutputLabel COMP_CL_BNF_CODE_LABEL;

	private HtmlInputText COMP_CL_BNF_CODE;

	private HtmlOutputLabel COMP_CL_SBNF_CODE_LABEL;

	private HtmlInputText COMP_CL_SBNF_CODE;

	private HtmlOutputLabel COMP_CL_LC_CLAIM_AMT_LABEL;

	private HtmlInputText COMP_CL_LC_CLAIM_AMT;

	private HtmlOutputLabel COMP_CL_LC_PAID_AMT_LABEL;

	private HtmlInputText COMP_CL_LC_PAID_AMT;
	
	private HtmlOutputLabel COMP_CL_ORG_LC_CLAIM_AMT_LABEL;
	
	private HtmlInputText COMP_CL_ORG_LC_CLAIM_AMT;
	
	private UIData dataTable;
	
	private List<PS_IL_CLAIM_LIMITS> dataTableList;

	private PS_IL_CLAIM_LIMITS PS_IL_CLAIM_LIMITS_BEAN;

	public PS_IL_CLAIM_LIMITS_ACTION() {
		PS_IL_CLAIM_LIMITS_BEAN = new PS_IL_CLAIM_LIMITS();
	}

	public HtmlOutputLabel getCOMP_CL_POL_YEAR_LABEL() {
		return COMP_CL_POL_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_CL_POL_YEAR() {
		return COMP_CL_POL_YEAR;
	}

	public void setCOMP_CL_POL_YEAR_LABEL(HtmlOutputLabel COMP_CL_POL_YEAR_LABEL) {
		this.COMP_CL_POL_YEAR_LABEL = COMP_CL_POL_YEAR_LABEL;
	}

	public void setCOMP_CL_POL_YEAR(HtmlInputText COMP_CL_POL_YEAR) {
		this.COMP_CL_POL_YEAR = COMP_CL_POL_YEAR;
	}

	public HtmlOutputLabel getCOMP_CL_PROD_CODE_LABEL() {
		return COMP_CL_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CL_PROD_CODE() {
		return COMP_CL_PROD_CODE;
	}

	public void setCOMP_CL_PROD_CODE_LABEL(HtmlOutputLabel COMP_CL_PROD_CODE_LABEL) {
		this.COMP_CL_PROD_CODE_LABEL = COMP_CL_PROD_CODE_LABEL;
	}

	public void setCOMP_CL_PROD_CODE(HtmlInputText COMP_CL_PROD_CODE) {
		this.COMP_CL_PROD_CODE = COMP_CL_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_CL_COVER_GROUP_CODE_LABEL() {
		return COMP_CL_COVER_GROUP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CL_COVER_GROUP_CODE() {
		return COMP_CL_COVER_GROUP_CODE;
	}

	public void setCOMP_CL_COVER_GROUP_CODE_LABEL(HtmlOutputLabel COMP_CL_COVER_GROUP_CODE_LABEL) {
		this.COMP_CL_COVER_GROUP_CODE_LABEL = COMP_CL_COVER_GROUP_CODE_LABEL;
	}

	public void setCOMP_CL_COVER_GROUP_CODE(HtmlInputText COMP_CL_COVER_GROUP_CODE) {
		this.COMP_CL_COVER_GROUP_CODE = COMP_CL_COVER_GROUP_CODE;
	}

	public HtmlOutputLabel getCOMP_CL_COVER_CODE_LABEL() {
		return COMP_CL_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CL_COVER_CODE() {
		return COMP_CL_COVER_CODE;
	}

	public void setCOMP_CL_COVER_CODE_LABEL(HtmlOutputLabel COMP_CL_COVER_CODE_LABEL) {
		this.COMP_CL_COVER_CODE_LABEL = COMP_CL_COVER_CODE_LABEL;
	}

	public void setCOMP_CL_COVER_CODE(HtmlInputText COMP_CL_COVER_CODE) {
		this.COMP_CL_COVER_CODE = COMP_CL_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_CL_BNF_CODE_LABEL() {
		return COMP_CL_BNF_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CL_BNF_CODE() {
		return COMP_CL_BNF_CODE;
	}

	public void setCOMP_CL_BNF_CODE_LABEL(HtmlOutputLabel COMP_CL_BNF_CODE_LABEL) {
		this.COMP_CL_BNF_CODE_LABEL = COMP_CL_BNF_CODE_LABEL;
	}

	public void setCOMP_CL_BNF_CODE(HtmlInputText COMP_CL_BNF_CODE) {
		this.COMP_CL_BNF_CODE = COMP_CL_BNF_CODE;
	}

	public HtmlOutputLabel getCOMP_CL_SBNF_CODE_LABEL() {
		return COMP_CL_SBNF_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CL_SBNF_CODE() {
		return COMP_CL_SBNF_CODE;
	}

	public void setCOMP_CL_SBNF_CODE_LABEL(HtmlOutputLabel COMP_CL_SBNF_CODE_LABEL) {
		this.COMP_CL_SBNF_CODE_LABEL = COMP_CL_SBNF_CODE_LABEL;
	}

	public void setCOMP_CL_SBNF_CODE(HtmlInputText COMP_CL_SBNF_CODE) {
		this.COMP_CL_SBNF_CODE = COMP_CL_SBNF_CODE;
	}

	public HtmlOutputLabel getCOMP_CL_LC_CLAIM_AMT_LABEL() {
		return COMP_CL_LC_CLAIM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CL_LC_CLAIM_AMT() {
		return COMP_CL_LC_CLAIM_AMT;
	}

	public void setCOMP_CL_LC_CLAIM_AMT_LABEL(HtmlOutputLabel COMP_CL_LC_CLAIM_AMT_LABEL) {
		this.COMP_CL_LC_CLAIM_AMT_LABEL = COMP_CL_LC_CLAIM_AMT_LABEL;
	}

	public void setCOMP_CL_LC_CLAIM_AMT(HtmlInputText COMP_CL_LC_CLAIM_AMT) {
		this.COMP_CL_LC_CLAIM_AMT = COMP_CL_LC_CLAIM_AMT;
	}

	public HtmlOutputLabel getCOMP_CL_LC_PAID_AMT_LABEL() {
		return COMP_CL_LC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CL_LC_PAID_AMT() {
		return COMP_CL_LC_PAID_AMT;
	}

	public void setCOMP_CL_LC_PAID_AMT_LABEL(HtmlOutputLabel COMP_CL_LC_PAID_AMT_LABEL) {
		this.COMP_CL_LC_PAID_AMT_LABEL = COMP_CL_LC_PAID_AMT_LABEL;
	}

	public void setCOMP_CL_LC_PAID_AMT(HtmlInputText COMP_CL_LC_PAID_AMT) {
		this.COMP_CL_LC_PAID_AMT = COMP_CL_LC_PAID_AMT;
	}

	public PS_IL_CLAIM_LIMITS getPS_IL_CLAIM_LIMITS_BEAN() {
		return PS_IL_CLAIM_LIMITS_BEAN;
	}

	public void setPS_IL_CLAIM_LIMITS_BEAN(PS_IL_CLAIM_LIMITS PS_IL_CLAIM_LIMITS_BEAN) {
		this.PS_IL_CLAIM_LIMITS_BEAN = PS_IL_CLAIM_LIMITS_BEAN;
	}

	public HtmlOutputLabel getCOMP_CL_ORG_LC_CLAIM_AMT_LABEL() {
		return COMP_CL_ORG_LC_CLAIM_AMT_LABEL;
	}

	public void setCOMP_CL_ORG_LC_CLAIM_AMT_LABEL(
			HtmlOutputLabel comp_cl_org_lc_claim_amt_label) {
		COMP_CL_ORG_LC_CLAIM_AMT_LABEL = comp_cl_org_lc_claim_amt_label;
	}

	public HtmlInputText getCOMP_CL_ORG_LC_CLAIM_AMT() {
		return COMP_CL_ORG_LC_CLAIM_AMT;
	}

	public void setCOMP_CL_ORG_LC_CLAIM_AMT(HtmlInputText comp_cl_org_lc_claim_amt) {
		COMP_CL_ORG_LC_CLAIM_AMT = comp_cl_org_lc_claim_amt;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<PS_IL_CLAIM_LIMITS> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PS_IL_CLAIM_LIMITS> dataTableList) {
		this.dataTableList = dataTableList;
	}
	
	public void onLoad(PhaseEvent event){
		/*PS_IL_CLAIM_LIMITS_HELPER helper = new PS_IL_CLAIM_LIMITS_HELPER();
		helper.when_new_block_instance();*/
	}
}
