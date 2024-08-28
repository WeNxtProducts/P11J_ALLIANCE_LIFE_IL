package com.iii.pel.forms.PILT020;



import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import com.iii.premia.common.action.CommonAction;

/**
 * @author 51128
 *
 */
/**
 * @author 51128
 *
 */
public class PT_IL_LOAN_INT_COLL_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_UI_M_LOAN_FC_AMOUNT_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_FC_AMOUNT;

	private HtmlOutputLabel COMP_UI_M_LOAN_LC_AMOUNT_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_LC_AMOUNT;

	private HtmlOutputLabel COMP_UI_M_FC_REPAID_AMT_LABEL;

	private HtmlInputText COMP_UI_M_FC_REPAID_AMT;

	private HtmlOutputLabel COMP_UI_M_LC_REPAID_AMT_LABEL;

	private HtmlInputText COMP_UI_M_LC_REPAID_AMT;

	private HtmlOutputLabel COMP_UI_M_FC_BAL_LOAN_AMT_LABEL;

	private HtmlInputText COMP_UI_M_FC_BAL_LOAN_AMT;

	private HtmlOutputLabel COMP_UI_M_LC_BAL_LOAN_AMT_LABEL;

	private HtmlInputText COMP_UI_M_LC_BAL_LOAN_AMT;

	private HtmlOutputLabel COMP_LIC_INT_RATE_LABEL;

	private HtmlInputText COMP_LIC_INT_RATE;

	private HtmlOutputLabel COMP_LIC_FC_INT_AMT_LABEL;

	private HtmlInputText COMP_LIC_FC_INT_AMT;

	private HtmlOutputLabel COMP_LIC_LC_INT_AMT_LABEL;

	private HtmlInputText COMP_LIC_LC_INT_AMT;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private PT_IL_LOAN_INT_COLL PT_IL_LOAN_INT_COLL_BEAN;
	
	public PILT020_COMPOSITE_ACTION compositeactiom;

	public PT_IL_LOAN_INT_COLL_ACTION()throws Exception {
		PT_IL_LOAN_INT_COLL_BEAN = new PT_IL_LOAN_INT_COLL();
		PT_IL_LOAN_INT_COLL_HELPER helper = new PT_IL_LOAN_INT_COLL_HELPER();
		//helper.trig_pre_query_pt_il_loan_coll();
		//helper.trig_post_query_pt_il_loan_coll();
		//helper.trig_when_new_block_instance_pt_il_loan_coll();
		//helper.trig_pre_update_pt_il_loan_coll();
		System.out.println("Constructor getting Called");
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_FC_AMOUNT_LABEL() {
		return COMP_UI_M_LOAN_FC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_FC_AMOUNT() {
		return COMP_UI_M_LOAN_FC_AMOUNT;
	}

	public void setCOMP_UI_M_LOAN_FC_AMOUNT_LABEL(HtmlOutputLabel COMP_UI_M_LOAN_FC_AMOUNT_LABEL) {
		this.COMP_UI_M_LOAN_FC_AMOUNT_LABEL = COMP_UI_M_LOAN_FC_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_LOAN_FC_AMOUNT(HtmlInputText COMP_UI_M_LOAN_FC_AMOUNT) {
		this.COMP_UI_M_LOAN_FC_AMOUNT = COMP_UI_M_LOAN_FC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_LC_AMOUNT_LABEL() {
		return COMP_UI_M_LOAN_LC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_LC_AMOUNT() {
		return COMP_UI_M_LOAN_LC_AMOUNT;
	}

	public void setCOMP_UI_M_LOAN_LC_AMOUNT_LABEL(HtmlOutputLabel COMP_UI_M_LOAN_LC_AMOUNT_LABEL) {
		this.COMP_UI_M_LOAN_LC_AMOUNT_LABEL = COMP_UI_M_LOAN_LC_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_LOAN_LC_AMOUNT(HtmlInputText COMP_UI_M_LOAN_LC_AMOUNT) {
		this.COMP_UI_M_LOAN_LC_AMOUNT = COMP_UI_M_LOAN_LC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_REPAID_AMT_LABEL() {
		return COMP_UI_M_FC_REPAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_REPAID_AMT() {
		return COMP_UI_M_FC_REPAID_AMT;
	}

	public void setCOMP_UI_M_FC_REPAID_AMT_LABEL(HtmlOutputLabel COMP_UI_M_FC_REPAID_AMT_LABEL) {
		this.COMP_UI_M_FC_REPAID_AMT_LABEL = COMP_UI_M_FC_REPAID_AMT_LABEL;
	}

	public void setCOMP_UI_M_FC_REPAID_AMT(HtmlInputText COMP_UI_M_FC_REPAID_AMT) {
		this.COMP_UI_M_FC_REPAID_AMT = COMP_UI_M_FC_REPAID_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_REPAID_AMT_LABEL() {
		return COMP_UI_M_LC_REPAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_REPAID_AMT() {
		return COMP_UI_M_LC_REPAID_AMT;
	}

	public void setCOMP_UI_M_LC_REPAID_AMT_LABEL(HtmlOutputLabel COMP_UI_M_LC_REPAID_AMT_LABEL) {
		this.COMP_UI_M_LC_REPAID_AMT_LABEL = COMP_UI_M_LC_REPAID_AMT_LABEL;
	}

	public void setCOMP_UI_M_LC_REPAID_AMT(HtmlInputText COMP_UI_M_LC_REPAID_AMT) {
		this.COMP_UI_M_LC_REPAID_AMT = COMP_UI_M_LC_REPAID_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_BAL_LOAN_AMT_LABEL() {
		return COMP_UI_M_FC_BAL_LOAN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_BAL_LOAN_AMT() {
		return COMP_UI_M_FC_BAL_LOAN_AMT;
	}

	public void setCOMP_UI_M_FC_BAL_LOAN_AMT_LABEL(HtmlOutputLabel COMP_UI_M_FC_BAL_LOAN_AMT_LABEL) {
		this.COMP_UI_M_FC_BAL_LOAN_AMT_LABEL = COMP_UI_M_FC_BAL_LOAN_AMT_LABEL;
	}

	public void setCOMP_UI_M_FC_BAL_LOAN_AMT(HtmlInputText COMP_UI_M_FC_BAL_LOAN_AMT) {
		this.COMP_UI_M_FC_BAL_LOAN_AMT = COMP_UI_M_FC_BAL_LOAN_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_BAL_LOAN_AMT_LABEL() {
		return COMP_UI_M_LC_BAL_LOAN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_BAL_LOAN_AMT() {
		return COMP_UI_M_LC_BAL_LOAN_AMT;
	}

	public void setCOMP_UI_M_LC_BAL_LOAN_AMT_LABEL(HtmlOutputLabel COMP_UI_M_LC_BAL_LOAN_AMT_LABEL) {
		this.COMP_UI_M_LC_BAL_LOAN_AMT_LABEL = COMP_UI_M_LC_BAL_LOAN_AMT_LABEL;
	}

	public void setCOMP_UI_M_LC_BAL_LOAN_AMT(HtmlInputText COMP_UI_M_LC_BAL_LOAN_AMT) {
		this.COMP_UI_M_LC_BAL_LOAN_AMT = COMP_UI_M_LC_BAL_LOAN_AMT;
	}

	public HtmlOutputLabel getCOMP_LIC_INT_RATE_LABEL() {
		return COMP_LIC_INT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_LIC_INT_RATE() {
		return COMP_LIC_INT_RATE;
	}

	public void setCOMP_LIC_INT_RATE_LABEL(HtmlOutputLabel COMP_LIC_INT_RATE_LABEL) {
		this.COMP_LIC_INT_RATE_LABEL = COMP_LIC_INT_RATE_LABEL;
	}

	public void setCOMP_LIC_INT_RATE(HtmlInputText COMP_LIC_INT_RATE) {
		this.COMP_LIC_INT_RATE = COMP_LIC_INT_RATE;
	}

	public HtmlOutputLabel getCOMP_LIC_FC_INT_AMT_LABEL() {
		return COMP_LIC_FC_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LIC_FC_INT_AMT() {
		return COMP_LIC_FC_INT_AMT;
	}

	public void setCOMP_LIC_FC_INT_AMT_LABEL(HtmlOutputLabel COMP_LIC_FC_INT_AMT_LABEL) {
		this.COMP_LIC_FC_INT_AMT_LABEL = COMP_LIC_FC_INT_AMT_LABEL;
	}

	public void setCOMP_LIC_FC_INT_AMT(HtmlInputText COMP_LIC_FC_INT_AMT) {
		this.COMP_LIC_FC_INT_AMT = COMP_LIC_FC_INT_AMT;
	}

	public HtmlOutputLabel getCOMP_LIC_LC_INT_AMT_LABEL() {
		return COMP_LIC_LC_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LIC_LC_INT_AMT() {
		return COMP_LIC_LC_INT_AMT;
	}

	public void setCOMP_LIC_LC_INT_AMT_LABEL(HtmlOutputLabel COMP_LIC_LC_INT_AMT_LABEL) {
		this.COMP_LIC_LC_INT_AMT_LABEL = COMP_LIC_LC_INT_AMT_LABEL;
	}

	public void setCOMP_LIC_LC_INT_AMT(HtmlInputText COMP_LIC_LC_INT_AMT) {
		this.COMP_LIC_LC_INT_AMT = COMP_LIC_LC_INT_AMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton COMP_UI_M_BUT_MAIN) {
		this.COMP_UI_M_BUT_MAIN = COMP_UI_M_BUT_MAIN;
	}

	public PT_IL_LOAN_INT_COLL getPT_IL_LOAN_INT_COLL_BEAN() {
		return PT_IL_LOAN_INT_COLL_BEAN;
	}

	public void setPT_IL_LOAN_INT_COLL_BEAN(PT_IL_LOAN_INT_COLL PT_IL_LOAN_INT_COLL_BEAN) {
		this.PT_IL_LOAN_INT_COLL_BEAN = PT_IL_LOAN_INT_COLL_BEAN;
	}

	//Methods for calling Block Level Triggers
	
	public void POST_QUERY_PT_IL_LOAN_COLL(ActionEvent event ) throws Exception{
		System.out.println("Calling PT_IL_LOAN_TRIGGER.......post query");
		PT_IL_LOAN_INT_COLL_HELPER helper = new PT_IL_LOAN_INT_COLL_HELPER();
		helper.trig_post_query_pt_il_loan_coll();
	}
	public void WHEN_NEW_BLOCK_INSTANCE_PT_IL_LOAN_COLL(ActionEvent event)throws Exception{
		System.out.println("Calling PT_IL_LOAN_TRIGGER.......when new block instance");
		PT_IL_LOAN_INT_COLL_HELPER helper = new PT_IL_LOAN_INT_COLL_HELPER();
		helper.trig_when_new_block_instance_pt_il_loan_coll();
	}
	public void PRE_UPDATE_PT_IL_LOAN_COLL(ActionEvent event)throws Exception{
		System.out.println("Calling PT_IL_LOAN_TRIGGER.......pre update ");
		PT_IL_LOAN_INT_COLL_HELPER helper = new PT_IL_LOAN_INT_COLL_HELPER();
		helper.trig_pre_update_pt_il_loan_coll();
	}
	public void PRE_QUERY_PT_IL_LOAN_COLL(ActionEvent event){
		System.out.println("Calling PT_IL_LOAN_TRIGGER.......pre update ");
		PT_IL_LOAN_INT_COLL_HELPER helper = new PT_IL_LOAN_INT_COLL_HELPER();
		helper.trig_pre_query_pt_il_loan_coll();
	}
	// Item level triggers
	public void WHEN_VALIDATE_LIC_FC_INT_AMT(ActionEvent event)throws Exception{
		System.out.println("Calling PT_IL_LOAN_TRIGGER.......LIC_FC_INT_AMT ");
		PT_IL_LOAN_INT_COLL_HELPER helper = new PT_IL_LOAN_INT_COLL_HELPER();
		helper.trig_when_validate_item_lic_fc_int_amt();
	}
	public void WHEN_VALIDATE_LIC_LC_INT_AMT(ActionEvent event)throws Exception{
		System.out.println("Calling PT_IL_LOAN_TRIGGER.......LIC_LC_INT_AMT ");
		PT_IL_LOAN_INT_COLL_HELPER helper = new PT_IL_LOAN_INT_COLL_HELPER();
		helper.trig_when_validate_item_lic_lc_int_amt();
	}
	public void WHEN_VALIDATE_LIC_INT_RATE(ActionEvent event)throws Exception{
		System.out.println("Calling PT_IL_LOAN_TRIGGER.......LIC_LC_INT_AMT ");
		PT_IL_LOAN_INT_COLL_HELPER helper = new PT_IL_LOAN_INT_COLL_HELPER();
		helper.trig_when_validate_item_lic_lc_int_amt();
	}
}
