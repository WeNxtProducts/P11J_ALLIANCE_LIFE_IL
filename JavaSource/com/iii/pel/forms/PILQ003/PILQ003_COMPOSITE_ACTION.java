package com.iii.pel.forms.PILQ003;

import com.iii.pel.commonimpl.summaryimpl.UISummary;
import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;

public class PILQ003_COMPOSITE_ACTION {

    public final static int TAB_PT_IL_POLICY = 1;
    public final static int TAB_PT_IL_POL_ASSURED_DTLS = 2;
    public final static int TAB_PT_IL_POL_ASSURED_DTLS_1 = 3;
    //public final static int TAB_PT_IL_POL_PAYEE_DTLS = 3;
    public final static int TAB_PT_IL_POL_BENEFICIARY = 4;
    public final static int TAB_PT_IL_POL_ASSR_MED_HIST = 5;
    public final static int TAB_PT_IL_POL_ASSR_ILLNESS_DTLS = 6;
    public final static int TAB_PT_IL_POL_MED_EXAM_DTL = 7;
    public final static int TAB_PT_IL_POL_MED_EXAM_DTL_1 = 8;
    public final static int TAB_PT_IL_POL_CHARGE = 9;
    public final static int TAB_PT_IL_POL_BROKER_HEAD = 10;
    
    public final static int TAB_PM_IL_DOC_TODO_GROUP = 11;
    public final static int TAB_PT_IL_POL_DISC_LOAD = 12;
    public final static int TAB_PT_IL_POL_CONDITION = 13;
    public final static int TAB_PREMIUM_DETAILS = 14;
    
    public final static int TAB_TAKAFUL_PREMIUM = 15;
    public final static int TAB_TAKAFUL_DTLS = 26;
    public final static int TAB_PT_IL_SURR_MAT_VALUES = 16;
    public final static int TAB_PT_IL_POL_STATUS = 17;
    public final static int TAB_PT_IL_POL_STATUS_1 = 18;
    public final static int TAB_PT_IL_POL_STATUS_2 = 19;
    public final static int TAB_PT_IL_POL_SA_INST_PYMT_HEAD = 20;
 //   public final static int TAB_PT_IL_DOC_TODO_LIST_STATUS = 21;
    public final static int TAB_PT_IL_POL_MATURITY = 22;
    public final static int TAB_PT_IL_POL_STAT = 23;
    public final static int TAB_PT_IL_POL_FUND_DTL = 24;
    public final static int TAB_PT_IL_POL_FUND_DTL_1 = 25;
    
   /*// public final static int TAB_PT_IL_POL_APPL_PROD = 4;
//    public final static int TAB_PT_IL_POL_APPL_PROD_1 = 6;
    public final static int TAB_PT_IL_POL_ADDL_COVER = 7;
    
    public final static int TAB_PT_IL_POL_COVER_GROUP = 9;
  //  public final static int TAB_PT_IL_POL_ASSR_MED_HIST_1 = 10;
 //   public final static int TAB_PT_IL_POL_ADDL_COVER_1 = 11;
   // public final static int TAB_PT_IL_POL_BENEFIT = 12;
  //  public final static int TAB_PT_IL_POL_SUB_BENEFIT = 14;
    public final static int TAB_PT_IL_POL_DEDUCTIBLE = 16;
  
   public final static int TAB_PT_IL_POL_BROKER_DTL = 22;
    public final static int TAB_PT_IL_POL_COVER_GROUP_1 = 21;
    
    //public final static int TAB_PT_IL_UNPAID_PREM_DTLS = 28;
    public final static int TAB_PT_IL_POL_RED_SA = 32;
    public final static int TAB_PT_BUS_RULE_ERROR_MSG = 35;
   // public final static int TAB_PT_IL_POLICY2 = 37;
    public final static int TAB_PT_IL_POL_SA_INST_PYMT1 = 42;
    public final static int TAB_PT_IL_POL_SA_INST_PYMT = 43;
    public final static int TAB_PT_IL_POL_MATURITY = 44;
 //   
    
*/
  //  private TabbedBar tabbedBar;
    private PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN;
    private PT_IL_POLICY_1_ACTION PT_IL_POLICY_1_ACTION_BEAN;
    private PT_IL_POL_ASSURED_DTLS_ACTION PT_IL_POL_ASSURED_DTLS_ACTION_BEAN;
    private PT_IL_POL_APPL_PROD_ACTION PT_IL_POL_APPL_PROD_ACTION_BEAN;
    private PT_IL_POL_ASSR_MED_HIST_ACTION PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN;
    private PT_IL_POL_APPL_PROD_1_ACTION PT_IL_POL_APPL_PROD_1_ACTION_BEAN;
    private PT_IL_POL_ADDL_COVER_ACTION PT_IL_POL_ADDL_COVER_ACTION_BEAN;
    private PT_IL_POL_ASSURED_DTLS_1_ACTION PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN;
    private PT_IL_POL_COVER_GROUP_ACTION PT_IL_POL_COVER_GROUP_ACTION_BEAN;
    private PT_IL_POL_ASSR_MED_HIST_1_ACTION PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN;
    private PT_IL_POL_ADDL_COVER_1_ACTION PT_IL_POL_ADDL_COVER_1_ACTION_BEAN;
    private PT_IL_POL_BENEFIT_ACTION PT_IL_POL_BENEFIT_ACTION_BEAN;
    private PT_IL_POL_BENEFICIARY_ACTION PT_IL_POL_BENEFICIARY_ACTION_BEAN;
    private PT_IL_POL_SUB_BENEFIT_ACTION PT_IL_POL_SUB_BENEFIT_ACTION_BEAN;
    private PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN;
    private PT_IL_POL_DEDUCTIBLE_ACTION PT_IL_POL_DEDUCTIBLE_ACTION_BEAN;
    private PT_IL_POL_MED_EXAM_DTL_ACTION PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN;
    private PT_IL_POL_MED_EXAM_DTL_1_ACTION PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN;
    private PT_IL_POL_CHARGE_ACTION PT_IL_POL_CHARGE_ACTION_BEAN;
    private PT_IL_POL_BROKER_HEAD_ACTION PT_IL_POL_BROKER_HEAD_ACTION_BEAN;
    private PT_IL_POL_COVER_GROUP_1_ACTION PT_IL_POL_COVER_GROUP_1_ACTION_BEAN;
    private PT_IL_POL_BROKER_DTL_ACTION PT_IL_POL_BROKER_DTL_ACTION_BEAN;
    private PM_IL_DOC_TODO_GROUP_ACTION PM_IL_DOC_TODO_GROUP_ACTION_BEAN;
    private PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;
    private PT_IL_POL_DISC_LOAD_ACTION PT_IL_POL_DISC_LOAD_ACTION_BEAN;
    private PT_IL_POL_CONDITION_ACTION PT_IL_POL_CONDITION_ACTION_BEAN;
    private PT_IL_SURR_MAT_VALUES_ACTION PT_IL_SURR_MAT_VALUES_ACTION_BEAN;
    private PT_IL_UNPAID_PREM_DTLS_ACTION PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN;
    private PT_IL_POL_STATUS_ACTION PT_IL_POL_STATUS_ACTION_BEAN;
    private PT_IL_POL_STATUS_1_ACTION PT_IL_POL_STATUS_1_ACTION_BEAN;
    private PT_IL_POL_STATUS_2_ACTION PT_IL_POL_STATUS_2_ACTION_BEAN;
    private PT_IL_POL_RED_SA_ACTION PT_IL_POL_RED_SA_ACTION_BEAN;
    private PT_IL_POL_FUND_DTL_ACTION PT_IL_POL_FUND_DTL_ACTION_BEAN;
    private PT_IL_POL_FUND_DTL_1_ACTION PT_IL_POL_FUND_DTL_1_ACTION_BEAN;
    private PT_BUS_RULE_ERROR_MSG_ACTION PT_BUS_RULE_ERROR_MSG_ACTION_BEAN;
    private DUMMY_OCC_ACTION DUMMY_OCC_ACTION_BEAN;
    private DUMMY_ACTION DUMMY_ACTION_BEAN;
    private PT_IL_POLICY2_ACTION PT_IL_POLICY2_ACTION_BEAN;
    private CTRL_ACTION CTRL_ACTION_BEAN;
    private BP_ACTION BP_ACTION_BEAN;
    private COPY_ACTION COPY_ACTION_BEAN;
    private PT_IL_POL_SA_INST_PYMT_HEAD_ACTION PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN;
    private PT_IL_POL_SA_INST_PYMT1_ACTION PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN;
    private PT_IL_POL_SA_INST_PYMT_ACTION PT_IL_POL_SA_INST_PYMT_ACTION_BEAN;
    
    
	private UISummary comp;
	private UIWizard wizard=null;


    public String callPT_IL_POLICY() {
	preTabClick();
	return "PILQ003_PT_IL_POLICY";

    }

    public String callPT_IL_POLICY_1() {
	preTabClick();
	return "PILQ003_PT_IL_POLICY_1";

    }

    public String callPT_IL_POL_ASSURED_DTLS() {
	preTabClick();
	return "PILQ003_PT_IL_POL_ASSURED_DTLS";

    }

    public String callPT_IL_POL_ASSURED_DTLS_1() {
	preTabClick();
	return "PILQ003_PT_IL_POL_ASSURED_DTLS_1";

    }

    public String callPT_IL_POL_APPL_PROD() {
	preTabClick();
	return "PILQ003_PT_IL_POL_APPL_PROD";

    }

    public String callPT_IL_POL_ASSR_MED_HIST() {
	preTabClick();
	return "PILQ003_PT_IL_POL_ASSR_MED_HIST";

    }

    public String callPT_IL_POL_APPL_PROD_1() {
	preTabClick();
	return "PILQ003_PT_IL_POL_APPL_PROD_1";

    }

    public String callPT_IL_POL_ADDL_COVER() {
	preTabClick();
	return "PILQ003_PT_IL_POL_ADDL_COVER";

    }

    public String callPT_IL_POL_COVER_GROUP() {
	preTabClick();
	return "PILQ003_PT_IL_POL_COVER_GROUP";

    }

    public String callPT_IL_POL_ASSR_MED_HIST_1() {
	preTabClick();
	return "PILQ003_PT_IL_POL_ASSR_MED_HIST_1";

    }

    public String callPT_IL_POL_ADDL_COVER_1() {
	preTabClick();
	return "PILQ003_PT_IL_POL_ADDL_COVER_1";

    }

    public String callPT_IL_POL_BENEFIT() {
	preTabClick();
	return "PILQ003_PT_IL_POL_BENEFIT";

    }

    public String callPT_IL_POL_BENEFICIARY() {
	preTabClick();
	return "PILQ003_PT_IL_POL_BENEFICIARY";

    }

    public String callPT_IL_POL_SUB_BENEFIT() {
	preTabClick();
	return "PILQ003_PT_IL_POL_SUB_BENEFIT";

    }

    public String callPT_IL_POL_ASSR_ILLNESS_DTLS() {
	preTabClick();
	return "PILQ003_PT_IL_POL_ASSR_ILLNESS_DTLS";

    }

    public String callPT_IL_POL_DEDUCTIBLE() {
	preTabClick();
	return "PILQ003_PT_IL_POL_DEDUCTIBLE";

    }

    public String callPT_IL_POL_MED_EXAM_DTL() {
	preTabClick();
	return "PILQ003_PT_IL_POL_MED_EXAM_DTL";

    }

    public String callPT_IL_POL_MED_EXAM_DTL_1() {
	preTabClick();
	return "PILQ003_PT_IL_POL_MED_EXAM_DTL_1";

    }

    public String callPT_IL_POL_CHARGE() {
	preTabClick();
	return "PILQ003_PT_IL_POL_CHARGE";

    }

    public String callPT_IL_POL_BROKER_HEAD() {
	preTabClick();
	return "PILQ003_PT_IL_POL_BROKER_HEAD";

    }

    public String callPT_IL_POL_COVER_GROUP_1() {
	preTabClick();
	return "PILQ003_PT_IL_POL_COVER_GROUP_1";

    }

    public String callPT_IL_POL_BROKER_DTL() {
	preTabClick();
	return "PILQ003_PT_IL_POL_BROKER_DTL";

    }

    public String callPM_IL_DOC_TODO_GROUP() {
	preTabClick();
	return "PILQ003_PM_IL_DOC_TODO_GROUP";

    }

    public String callPT_IL_DOC_TODO_LIST_STATUS() {
	preTabClick();
	return "PILQ003_PT_IL_DOC_TODO_LIST_STATUS";

    }

    public String callPT_IL_POL_DISC_LOAD() {
	preTabClick();
	return "PILQ003_PT_IL_POL_DISC_LOAD";

    }

    public String callPT_IL_POL_CONDITION() {
	preTabClick();
	return "PILQ003_PT_IL_POL_CONDITION";

    }

    public String callPT_IL_SURR_MAT_VALUES() {
	preTabClick();
	return "PILQ003_PT_IL_SURR_MAT_VALUES";

    }

    public String callPT_IL_UNPAID_PREM_DTLS() {
	preTabClick();
	return "PILQ003_PT_IL_UNPAID_PREM_DTLS";

    }

    public String callPT_IL_POL_STATUS() {
	preTabClick();
	return "PILQ003_PT_IL_POL_STATUS";

    }

    public String callPT_IL_POL_STATUS_1() {
	preTabClick();
	return "PILQ003_PT_IL_POL_STATUS_1";

    }

    public String callPT_IL_POL_STATUS_2() {
	preTabClick();
	return "PILQ003_PT_IL_POL_STATUS_2";

    }

    public String callPT_IL_POL_RED_SA() {
	preTabClick();
	return "PILQ003_PT_IL_POL_RED_SA";

    }

    public String callPT_IL_POL_FUND_DTL() {
	preTabClick();
	return "PILQ003_PT_IL_POL_FUND_DTL";

    }

    public String callPT_IL_POL_FUND_DTL_1() {
	preTabClick();
	return "PILQ003_PT_IL_POL_FUND_DTL_1";

    }

    public String callPT_BUS_RULE_ERROR_MSG() {
	preTabClick();
	return "PILQ003_PT_BUS_RULE_ERROR_MSG";

    }

    public String callDUMMY_OCC() {
	preTabClick();
	return "PILQ003_DUMMY_OCC";

    }

    public String callPT_IL_POLICY2() {
	preTabClick();
	return "PILQ003_PT_IL_POLICY2";

    }

    public String callCTRL() {
	preTabClick();
	return "PILQ003_CTRL";

    }

    public String callBP() {
	preTabClick();
	return "PILQ003_BP";

    }

    public String callCOPY() {
	preTabClick();
	return "PILQ003_COPY";

    }

    public String callPT_IL_POL_SA_INST_PYMT_HEAD() {
	preTabClick();
	return "PILQ003_PT_IL_POL_SA_INST_PYMT_HEAD";

    }

    public String callPT_IL_POL_SA_INST_PYMT1() {
	preTabClick();
	return "PILQ003_PT_IL_POL_SA_INST_PYMT1";

    }

    public String callPT_IL_POL_SA_INST_PYMT() {
	preTabClick();
	return "PILQ003_PT_IL_POL_SA_INST_PYMT";

    }
    
    public String callPT_IL_PREM_DTLS() {
	preTabClick();
	return "PILQ003_PT_IL_PREM_DTLS";
	
    }
    
    public String callPT_IL_TAKAFUL_PREM_DTLS() {
	preTabClick();
	return "PILQ003_PT_IL_TAKAFUL_PREM_DTLS";
	
    }

    public String navigationEnabled() {
	//setImmediate(true);
    	getWizard().setImmediate("true");
	return "";

    }

    private void setImmediate(boolean flag) {
    
	/*ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
	Iterator<TabItem> tabIterator = tabItemList.iterator();
	while (tabIterator.hasNext()) {
	    TabItem item = tabIterator.next();
	    item.setImmediate(flag);

	}*/

    }

    private void preTabClick() {/*
	int currentTabId = tabbedBar.getCurrentTabId();
	switch (currentTabId) {
	case 1:
	    PT_IL_POLICY_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 2:
	    PT_IL_POLICY_1_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 3:
	    PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 4:
	    PT_IL_POL_APPL_PROD_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 5:
	    PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 6:
	    PT_IL_POL_APPL_PROD_1_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 7:
	    PT_IL_POL_ADDL_COVER_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 8:
	    PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 9:
	    PT_IL_POL_COVER_GROUP_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 10:
	    PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 11:
	    PT_IL_POL_ADDL_COVER_1_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 12:
	    PT_IL_POL_BENEFIT_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 13:
	    PT_IL_POL_BENEFICIARY_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 14:
	    PT_IL_POL_SUB_BENEFIT_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 15:
	    PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 16:
	    PT_IL_POL_DEDUCTIBLE_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 17:
	    PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 18:
	    PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 19:
	    PT_IL_POL_CHARGE_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 20:
	    PT_IL_POL_BROKER_HEAD_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 21:
	    PT_IL_POL_COVER_GROUP_1_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 22:
	    PT_IL_POL_BROKER_DTL_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 23:
	    PM_IL_DOC_TODO_GROUP_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 24:
	    PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 25:
	    PT_IL_POL_DISC_LOAD_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 26:
	    PT_IL_POL_CONDITION_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 27:
	    PT_IL_SURR_MAT_VALUES_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 28:
	    PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 29:
	    PT_IL_POL_STATUS_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 30:// PT_IL_POL_STATUS_1_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 31:
	    PT_IL_POL_STATUS_2_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 32:
	    PT_IL_POL_RED_SA_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 33:
	    PT_IL_POL_FUND_DTL_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 34:
	    PT_IL_POL_FUND_DTL_1_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 35:
	    PT_BUS_RULE_ERROR_MSG_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 36:
	    DUMMY_OCC_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 37:
	    PT_IL_POLICY2_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 38:
	    CTRL_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 39:
	    BP_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 40:
	    COPY_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 41:
	    PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 42:
	    PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;
	case 43:
	    PT_IL_POL_SA_INST_PYMT_ACTION_BEAN.setBlockFlag(true);
	    setImmediate(false);
	    break;

	}

    */}

   /* public void setTabbedBar(TabbedBar tabbedBar) {
	this.tabbedBar = tabbedBar;

    }

    public TabbedBar getTabbedBar() {
	return this.tabbedBar;

    }*/

    public void setPT_IL_POLICY_ACTION_BEAN(
	    PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN) {
	this.PT_IL_POLICY_ACTION_BEAN = PT_IL_POLICY_ACTION_BEAN;

    }

    public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION_BEAN() {
	return this.PT_IL_POLICY_ACTION_BEAN;

    }

    public void setPT_IL_POLICY_1_ACTION_BEAN(
	    PT_IL_POLICY_1_ACTION PT_IL_POLICY_1_ACTION_BEAN) {
	this.PT_IL_POLICY_1_ACTION_BEAN = PT_IL_POLICY_1_ACTION_BEAN;

    }

    public PT_IL_POLICY_1_ACTION getPT_IL_POLICY_1_ACTION_BEAN() {
	return this.PT_IL_POLICY_1_ACTION_BEAN;

    }

    public void setPT_IL_POL_ASSURED_DTLS_ACTION_BEAN(
	    PT_IL_POL_ASSURED_DTLS_ACTION PT_IL_POL_ASSURED_DTLS_ACTION_BEAN) {
	this.PT_IL_POL_ASSURED_DTLS_ACTION_BEAN = PT_IL_POL_ASSURED_DTLS_ACTION_BEAN;

    }

    public PT_IL_POL_ASSURED_DTLS_ACTION getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN() {
	return this.PT_IL_POL_ASSURED_DTLS_ACTION_BEAN;

    }

    public void setPT_IL_POL_APPL_PROD_ACTION_BEAN(
	    PT_IL_POL_APPL_PROD_ACTION PT_IL_POL_APPL_PROD_ACTION_BEAN) {
	this.PT_IL_POL_APPL_PROD_ACTION_BEAN = PT_IL_POL_APPL_PROD_ACTION_BEAN;

    }

    public PT_IL_POL_APPL_PROD_ACTION getPT_IL_POL_APPL_PROD_ACTION_BEAN() {
	return this.PT_IL_POL_APPL_PROD_ACTION_BEAN;

    }

    public void setPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN(
	    PT_IL_POL_ASSR_MED_HIST_ACTION PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN) {
	this.PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN = PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN;

    }

    public PT_IL_POL_ASSR_MED_HIST_ACTION getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN() {
	return this.PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN;

    }

    public void setPT_IL_POL_APPL_PROD_1_ACTION_BEAN(
	    PT_IL_POL_APPL_PROD_1_ACTION PT_IL_POL_APPL_PROD_1_ACTION_BEAN) {
	this.PT_IL_POL_APPL_PROD_1_ACTION_BEAN = PT_IL_POL_APPL_PROD_1_ACTION_BEAN;

    }

    public PT_IL_POL_APPL_PROD_1_ACTION getPT_IL_POL_APPL_PROD_1_ACTION_BEAN() {
	return this.PT_IL_POL_APPL_PROD_1_ACTION_BEAN;

    }

    public void setPT_IL_POL_ADDL_COVER_ACTION_BEAN(
	    PT_IL_POL_ADDL_COVER_ACTION PT_IL_POL_ADDL_COVER_ACTION_BEAN) {
	this.PT_IL_POL_ADDL_COVER_ACTION_BEAN = PT_IL_POL_ADDL_COVER_ACTION_BEAN;

    }

    public PT_IL_POL_ADDL_COVER_ACTION getPT_IL_POL_ADDL_COVER_ACTION_BEAN() {
	return this.PT_IL_POL_ADDL_COVER_ACTION_BEAN;

    }

    public void setPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN(
	    PT_IL_POL_ASSURED_DTLS_1_ACTION PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN) {
	this.PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN = PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN;

    }

    public PT_IL_POL_ASSURED_DTLS_1_ACTION getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN() {
	return this.PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN;

    }

    public void setPT_IL_POL_COVER_GROUP_ACTION_BEAN(
	    PT_IL_POL_COVER_GROUP_ACTION PT_IL_POL_COVER_GROUP_ACTION_BEAN) {
	this.PT_IL_POL_COVER_GROUP_ACTION_BEAN = PT_IL_POL_COVER_GROUP_ACTION_BEAN;

    }

    public PT_IL_POL_COVER_GROUP_ACTION getPT_IL_POL_COVER_GROUP_ACTION_BEAN() {
	return this.PT_IL_POL_COVER_GROUP_ACTION_BEAN;

    }

    public void setPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN(
	    PT_IL_POL_ASSR_MED_HIST_1_ACTION PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN) {
	this.PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN = PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN;

    }

    public PT_IL_POL_ASSR_MED_HIST_1_ACTION getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN() {
	return this.PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN;

    }

    public void setPT_IL_POL_ADDL_COVER_1_ACTION_BEAN(
	    PT_IL_POL_ADDL_COVER_1_ACTION PT_IL_POL_ADDL_COVER_1_ACTION_BEAN) {
	this.PT_IL_POL_ADDL_COVER_1_ACTION_BEAN = PT_IL_POL_ADDL_COVER_1_ACTION_BEAN;

    }

    public PT_IL_POL_ADDL_COVER_1_ACTION getPT_IL_POL_ADDL_COVER_1_ACTION_BEAN() {
	return this.PT_IL_POL_ADDL_COVER_1_ACTION_BEAN;

    }

    public void setPT_IL_POL_BENEFIT_ACTION_BEAN(
	    PT_IL_POL_BENEFIT_ACTION PT_IL_POL_BENEFIT_ACTION_BEAN) {
	this.PT_IL_POL_BENEFIT_ACTION_BEAN = PT_IL_POL_BENEFIT_ACTION_BEAN;

    }

    public PT_IL_POL_BENEFIT_ACTION getPT_IL_POL_BENEFIT_ACTION_BEAN() {
	return this.PT_IL_POL_BENEFIT_ACTION_BEAN;

    }

    public void setPT_IL_POL_BENEFICIARY_ACTION_BEAN(
	    PT_IL_POL_BENEFICIARY_ACTION PT_IL_POL_BENEFICIARY_ACTION_BEAN) {
	this.PT_IL_POL_BENEFICIARY_ACTION_BEAN = PT_IL_POL_BENEFICIARY_ACTION_BEAN;

    }

    public PT_IL_POL_BENEFICIARY_ACTION getPT_IL_POL_BENEFICIARY_ACTION_BEAN() {
	return this.PT_IL_POL_BENEFICIARY_ACTION_BEAN;

    }

    public void setPT_IL_POL_SUB_BENEFIT_ACTION_BEAN(
	    PT_IL_POL_SUB_BENEFIT_ACTION PT_IL_POL_SUB_BENEFIT_ACTION_BEAN) {
	this.PT_IL_POL_SUB_BENEFIT_ACTION_BEAN = PT_IL_POL_SUB_BENEFIT_ACTION_BEAN;

    }

    public PT_IL_POL_SUB_BENEFIT_ACTION getPT_IL_POL_SUB_BENEFIT_ACTION_BEAN() {
	return this.PT_IL_POL_SUB_BENEFIT_ACTION_BEAN;

    }

    public void setPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN(
	    PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN) {
	this.PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN = PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN;

    }

    public PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION getPT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN() {
	return this.PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN;

    }

    public void setPT_IL_POL_DEDUCTIBLE_ACTION_BEAN(
	    PT_IL_POL_DEDUCTIBLE_ACTION PT_IL_POL_DEDUCTIBLE_ACTION_BEAN) {
	this.PT_IL_POL_DEDUCTIBLE_ACTION_BEAN = PT_IL_POL_DEDUCTIBLE_ACTION_BEAN;

    }

    public PT_IL_POL_DEDUCTIBLE_ACTION getPT_IL_POL_DEDUCTIBLE_ACTION_BEAN() {
	return this.PT_IL_POL_DEDUCTIBLE_ACTION_BEAN;

    }

    public void setPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN(
	    PT_IL_POL_MED_EXAM_DTL_ACTION PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN) {
	this.PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN = PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN;

    }

    public PT_IL_POL_MED_EXAM_DTL_ACTION getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN() {
	return this.PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN;

    }

    public void setPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN(
	    PT_IL_POL_MED_EXAM_DTL_1_ACTION PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN) {
	this.PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN = PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN;

    }

    public PT_IL_POL_MED_EXAM_DTL_1_ACTION getPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN() {
	return this.PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN;

    }

    public void setPT_IL_POL_CHARGE_ACTION_BEAN(
	    PT_IL_POL_CHARGE_ACTION PT_IL_POL_CHARGE_ACTION_BEAN) {
	this.PT_IL_POL_CHARGE_ACTION_BEAN = PT_IL_POL_CHARGE_ACTION_BEAN;

    }

    public PT_IL_POL_CHARGE_ACTION getPT_IL_POL_CHARGE_ACTION_BEAN() {
	return this.PT_IL_POL_CHARGE_ACTION_BEAN;

    }

    public void setPT_IL_POL_BROKER_HEAD_ACTION_BEAN(
	    PT_IL_POL_BROKER_HEAD_ACTION PT_IL_POL_BROKER_HEAD_ACTION_BEAN) {
	this.PT_IL_POL_BROKER_HEAD_ACTION_BEAN = PT_IL_POL_BROKER_HEAD_ACTION_BEAN;

    }

    public PT_IL_POL_BROKER_HEAD_ACTION getPT_IL_POL_BROKER_HEAD_ACTION_BEAN() {
	return this.PT_IL_POL_BROKER_HEAD_ACTION_BEAN;

    }

    public void setPT_IL_POL_COVER_GROUP_1_ACTION_BEAN(
	    PT_IL_POL_COVER_GROUP_1_ACTION PT_IL_POL_COVER_GROUP_1_ACTION_BEAN) {
	this.PT_IL_POL_COVER_GROUP_1_ACTION_BEAN = PT_IL_POL_COVER_GROUP_1_ACTION_BEAN;

    }

    public PT_IL_POL_COVER_GROUP_1_ACTION getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN() {
	return this.PT_IL_POL_COVER_GROUP_1_ACTION_BEAN;

    }

    public void setPT_IL_POL_BROKER_DTL_ACTION_BEAN(
	    PT_IL_POL_BROKER_DTL_ACTION PT_IL_POL_BROKER_DTL_ACTION_BEAN) {
	this.PT_IL_POL_BROKER_DTL_ACTION_BEAN = PT_IL_POL_BROKER_DTL_ACTION_BEAN;

    }

    public PT_IL_POL_BROKER_DTL_ACTION getPT_IL_POL_BROKER_DTL_ACTION_BEAN() {
	return this.PT_IL_POL_BROKER_DTL_ACTION_BEAN;

    }

    public void setPM_IL_DOC_TODO_GROUP_ACTION_BEAN(
	    PM_IL_DOC_TODO_GROUP_ACTION PM_IL_DOC_TODO_GROUP_ACTION_BEAN) {
	this.PM_IL_DOC_TODO_GROUP_ACTION_BEAN = PM_IL_DOC_TODO_GROUP_ACTION_BEAN;

    }

    public PM_IL_DOC_TODO_GROUP_ACTION getPM_IL_DOC_TODO_GROUP_ACTION_BEAN() {
	return this.PM_IL_DOC_TODO_GROUP_ACTION_BEAN;

    }

    public void setPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN(
	    PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN) {
	this.PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN = PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;

    }

    public PT_IL_DOC_TODO_LIST_STATUS_ACTION getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN() {
	return this.PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;

    }

    public void setPT_IL_POL_DISC_LOAD_ACTION_BEAN(
	    PT_IL_POL_DISC_LOAD_ACTION PT_IL_POL_DISC_LOAD_ACTION_BEAN) {
	this.PT_IL_POL_DISC_LOAD_ACTION_BEAN = PT_IL_POL_DISC_LOAD_ACTION_BEAN;

    }

    public PT_IL_POL_DISC_LOAD_ACTION getPT_IL_POL_DISC_LOAD_ACTION_BEAN() {
	return this.PT_IL_POL_DISC_LOAD_ACTION_BEAN;

    }

    public void setPT_IL_POL_CONDITION_ACTION_BEAN(
	    PT_IL_POL_CONDITION_ACTION PT_IL_POL_CONDITION_ACTION_BEAN) {
	this.PT_IL_POL_CONDITION_ACTION_BEAN = PT_IL_POL_CONDITION_ACTION_BEAN;

    }

    public PT_IL_POL_CONDITION_ACTION getPT_IL_POL_CONDITION_ACTION_BEAN() {
	return this.PT_IL_POL_CONDITION_ACTION_BEAN;

    }

    public void setPT_IL_SURR_MAT_VALUES_ACTION_BEAN(
	    PT_IL_SURR_MAT_VALUES_ACTION PT_IL_SURR_MAT_VALUES_ACTION_BEAN) {
	this.PT_IL_SURR_MAT_VALUES_ACTION_BEAN = PT_IL_SURR_MAT_VALUES_ACTION_BEAN;

    }

    public PT_IL_SURR_MAT_VALUES_ACTION getPT_IL_SURR_MAT_VALUES_ACTION_BEAN() {
	return this.PT_IL_SURR_MAT_VALUES_ACTION_BEAN;

    }

    public void setPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN(
	    PT_IL_UNPAID_PREM_DTLS_ACTION PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN) {
	this.PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN = PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN;

    }

    public PT_IL_UNPAID_PREM_DTLS_ACTION getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN() {
	return this.PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN;

    }

    public void setPT_IL_POL_STATUS_ACTION_BEAN(
	    PT_IL_POL_STATUS_ACTION PT_IL_POL_STATUS_ACTION_BEAN) {
	this.PT_IL_POL_STATUS_ACTION_BEAN = PT_IL_POL_STATUS_ACTION_BEAN;

    }

    public PT_IL_POL_STATUS_ACTION getPT_IL_POL_STATUS_ACTION_BEAN() {
	return this.PT_IL_POL_STATUS_ACTION_BEAN;

    }

    public void setPT_IL_POL_STATUS_1_ACTION_BEAN(
	    PT_IL_POL_STATUS_1_ACTION PT_IL_POL_STATUS_1_ACTION_BEAN) {
	this.PT_IL_POL_STATUS_1_ACTION_BEAN = PT_IL_POL_STATUS_1_ACTION_BEAN;

    }

    public PT_IL_POL_STATUS_1_ACTION getPT_IL_POL_STATUS_1_ACTION_BEAN() {
	return this.PT_IL_POL_STATUS_1_ACTION_BEAN;

    }

    public void setPT_IL_POL_STATUS_2_ACTION_BEAN(
	    PT_IL_POL_STATUS_2_ACTION PT_IL_POL_STATUS_2_ACTION_BEAN) {
	this.PT_IL_POL_STATUS_2_ACTION_BEAN = PT_IL_POL_STATUS_2_ACTION_BEAN;

    }

    public PT_IL_POL_STATUS_2_ACTION getPT_IL_POL_STATUS_2_ACTION_BEAN() {
	return this.PT_IL_POL_STATUS_2_ACTION_BEAN;

    }

    public void setPT_IL_POL_RED_SA_ACTION_BEAN(
	    PT_IL_POL_RED_SA_ACTION PT_IL_POL_RED_SA_ACTION_BEAN) {
	this.PT_IL_POL_RED_SA_ACTION_BEAN = PT_IL_POL_RED_SA_ACTION_BEAN;

    }

    public PT_IL_POL_RED_SA_ACTION getPT_IL_POL_RED_SA_ACTION_BEAN() {
	return this.PT_IL_POL_RED_SA_ACTION_BEAN;

    }

    public void setPT_IL_POL_FUND_DTL_ACTION_BEAN(
	    PT_IL_POL_FUND_DTL_ACTION PT_IL_POL_FUND_DTL_ACTION_BEAN) {
	this.PT_IL_POL_FUND_DTL_ACTION_BEAN = PT_IL_POL_FUND_DTL_ACTION_BEAN;

    }

    public PT_IL_POL_FUND_DTL_ACTION getPT_IL_POL_FUND_DTL_ACTION_BEAN() {
	return this.PT_IL_POL_FUND_DTL_ACTION_BEAN;

    }

    public void setPT_IL_POL_FUND_DTL_1_ACTION_BEAN(
	    PT_IL_POL_FUND_DTL_1_ACTION PT_IL_POL_FUND_DTL_1_ACTION_BEAN) {
	this.PT_IL_POL_FUND_DTL_1_ACTION_BEAN = PT_IL_POL_FUND_DTL_1_ACTION_BEAN;

    }

    public PT_IL_POL_FUND_DTL_1_ACTION getPT_IL_POL_FUND_DTL_1_ACTION_BEAN() {
	return this.PT_IL_POL_FUND_DTL_1_ACTION_BEAN;

    }

    public void setPT_BUS_RULE_ERROR_MSG_ACTION_BEAN(
	    PT_BUS_RULE_ERROR_MSG_ACTION PT_BUS_RULE_ERROR_MSG_ACTION_BEAN) {
	this.PT_BUS_RULE_ERROR_MSG_ACTION_BEAN = PT_BUS_RULE_ERROR_MSG_ACTION_BEAN;

    }

    public PT_BUS_RULE_ERROR_MSG_ACTION getPT_BUS_RULE_ERROR_MSG_ACTION_BEAN() {
	return this.PT_BUS_RULE_ERROR_MSG_ACTION_BEAN;

    }

    public void setDUMMY_OCC_ACTION_BEAN(DUMMY_OCC_ACTION DUMMY_OCC_ACTION_BEAN) {
	this.DUMMY_OCC_ACTION_BEAN = DUMMY_OCC_ACTION_BEAN;

    }

    public DUMMY_OCC_ACTION getDUMMY_OCC_ACTION_BEAN() {
	return this.DUMMY_OCC_ACTION_BEAN;

    }

    public void setPT_IL_POLICY2_ACTION_BEAN(
	    PT_IL_POLICY2_ACTION PT_IL_POLICY2_ACTION_BEAN) {
	this.PT_IL_POLICY2_ACTION_BEAN = PT_IL_POLICY2_ACTION_BEAN;

    }

    public PT_IL_POLICY2_ACTION getPT_IL_POLICY2_ACTION_BEAN() {
	return this.PT_IL_POLICY2_ACTION_BEAN;

    }

    public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN) {
	this.CTRL_ACTION_BEAN = CTRL_ACTION_BEAN;

    }

    public CTRL_ACTION getCTRL_ACTION_BEAN() {
	return this.CTRL_ACTION_BEAN;

    }

    public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN) {
	this.BP_ACTION_BEAN = BP_ACTION_BEAN;

    }

    public BP_ACTION getBP_ACTION_BEAN() {
	return this.BP_ACTION_BEAN;

    }

    public void setCOPY_ACTION_BEAN(COPY_ACTION COPY_ACTION_BEAN) {
	this.COPY_ACTION_BEAN = COPY_ACTION_BEAN;

    }

    public COPY_ACTION getCOPY_ACTION_BEAN() {
	return this.COPY_ACTION_BEAN;

    }

    public void setPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN(
	    PT_IL_POL_SA_INST_PYMT_HEAD_ACTION PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN) {
	this.PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN = PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN;

    }

    public PT_IL_POL_SA_INST_PYMT_HEAD_ACTION getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN() {
	return this.PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN;

    }

    public void setPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN(
	    PT_IL_POL_SA_INST_PYMT1_ACTION PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN) {
	this.PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN = PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN;

    }

    public PT_IL_POL_SA_INST_PYMT1_ACTION getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN() {
	return this.PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN;

    }

    public void setPT_IL_POL_SA_INST_PYMT_ACTION_BEAN(
	    PT_IL_POL_SA_INST_PYMT_ACTION PT_IL_POL_SA_INST_PYMT_ACTION_BEAN) {
	this.PT_IL_POL_SA_INST_PYMT_ACTION_BEAN = PT_IL_POL_SA_INST_PYMT_ACTION_BEAN;

    }

    public PT_IL_POL_SA_INST_PYMT_ACTION getPT_IL_POL_SA_INST_PYMT_ACTION_BEAN() {
	return this.PT_IL_POL_SA_INST_PYMT_ACTION_BEAN;

    }

    public PILQ003_COMPOSITE_ACTION() {
	//tabbedBar = new TabbedBar();
	PT_IL_POLICY_ACTION_BEAN = new PT_IL_POLICY_ACTION();
	PT_IL_POLICY_1_ACTION_BEAN = new PT_IL_POLICY_1_ACTION();
	PT_IL_POL_ASSURED_DTLS_ACTION_BEAN = new PT_IL_POL_ASSURED_DTLS_ACTION();
	PT_IL_POL_APPL_PROD_ACTION_BEAN = new PT_IL_POL_APPL_PROD_ACTION();
	PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN = new PT_IL_POL_ASSR_MED_HIST_ACTION();
	PT_IL_POL_APPL_PROD_1_ACTION_BEAN = new PT_IL_POL_APPL_PROD_1_ACTION();
	PT_IL_POL_ADDL_COVER_ACTION_BEAN = new PT_IL_POL_ADDL_COVER_ACTION();
	PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN = new PT_IL_POL_ASSURED_DTLS_1_ACTION();
	PT_IL_POL_COVER_GROUP_ACTION_BEAN = new PT_IL_POL_COVER_GROUP_ACTION();
	PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN = new PT_IL_POL_ASSR_MED_HIST_1_ACTION();
	PT_IL_POL_ADDL_COVER_1_ACTION_BEAN = new PT_IL_POL_ADDL_COVER_1_ACTION();
	PT_IL_POL_BENEFIT_ACTION_BEAN = new PT_IL_POL_BENEFIT_ACTION();
	PT_IL_POL_BENEFICIARY_ACTION_BEAN = new PT_IL_POL_BENEFICIARY_ACTION();
	PT_IL_POL_SUB_BENEFIT_ACTION_BEAN = new PT_IL_POL_SUB_BENEFIT_ACTION();
	PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN = new PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION();
	PT_IL_POL_DEDUCTIBLE_ACTION_BEAN = new PT_IL_POL_DEDUCTIBLE_ACTION();
	PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN = new PT_IL_POL_MED_EXAM_DTL_ACTION();
	PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN = new PT_IL_POL_MED_EXAM_DTL_1_ACTION();
	PT_IL_POL_CHARGE_ACTION_BEAN = new PT_IL_POL_CHARGE_ACTION();
	PT_IL_POL_BROKER_HEAD_ACTION_BEAN = new PT_IL_POL_BROKER_HEAD_ACTION();
	PT_IL_POL_COVER_GROUP_1_ACTION_BEAN = new PT_IL_POL_COVER_GROUP_1_ACTION();
	PT_IL_POL_BROKER_DTL_ACTION_BEAN = new PT_IL_POL_BROKER_DTL_ACTION();
	PM_IL_DOC_TODO_GROUP_ACTION_BEAN = new PM_IL_DOC_TODO_GROUP_ACTION();
	PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN = new PT_IL_DOC_TODO_LIST_STATUS_ACTION();
	PT_IL_POL_DISC_LOAD_ACTION_BEAN = new PT_IL_POL_DISC_LOAD_ACTION();
	PT_IL_POL_CONDITION_ACTION_BEAN = new PT_IL_POL_CONDITION_ACTION();
	PT_IL_SURR_MAT_VALUES_ACTION_BEAN = new PT_IL_SURR_MAT_VALUES_ACTION();
	PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN = new PT_IL_UNPAID_PREM_DTLS_ACTION();
	PT_IL_POL_STATUS_ACTION_BEAN = new PT_IL_POL_STATUS_ACTION();
	PT_IL_POL_STATUS_1_ACTION_BEAN = new PT_IL_POL_STATUS_1_ACTION();
	PT_IL_POL_STATUS_2_ACTION_BEAN = new PT_IL_POL_STATUS_2_ACTION();
	PT_IL_POL_RED_SA_ACTION_BEAN = new PT_IL_POL_RED_SA_ACTION();
	PT_IL_POL_FUND_DTL_ACTION_BEAN = new PT_IL_POL_FUND_DTL_ACTION();
	PT_IL_POL_FUND_DTL_1_ACTION_BEAN = new PT_IL_POL_FUND_DTL_1_ACTION();
	PT_BUS_RULE_ERROR_MSG_ACTION_BEAN = new PT_BUS_RULE_ERROR_MSG_ACTION();
	DUMMY_OCC_ACTION_BEAN = new DUMMY_OCC_ACTION();
	DUMMY_ACTION_BEAN = new DUMMY_ACTION();
	PT_IL_POLICY2_ACTION_BEAN = new PT_IL_POLICY2_ACTION();
	CTRL_ACTION_BEAN = new CTRL_ACTION();
	BP_ACTION_BEAN = new BP_ACTION();
	COPY_ACTION_BEAN = new COPY_ACTION();
	PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN = new PT_IL_POL_SA_INST_PYMT_HEAD_ACTION();
	PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN = new PT_IL_POL_SA_INST_PYMT1_ACTION();
	PT_IL_POL_SA_INST_PYMT_ACTION_BEAN = new PT_IL_POL_SA_INST_PYMT_ACTION();
	PT_IL_POLICY_ACTION_BEAN.compositeAction = this;
	PT_IL_POLICY_1_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_APPL_PROD_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_APPL_PROD_1_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_ADDL_COVER_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_COVER_GROUP_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_ADDL_COVER_1_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_BENEFIT_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_BENEFICIARY_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_SUB_BENEFIT_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_DEDUCTIBLE_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_CHARGE_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_BROKER_HEAD_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_COVER_GROUP_1_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_BROKER_DTL_ACTION_BEAN.compositeAction = this;
	PM_IL_DOC_TODO_GROUP_ACTION_BEAN.compositeAction = this;
	PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_DISC_LOAD_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_CONDITION_ACTION_BEAN.compositeAction = this;
	PT_IL_SURR_MAT_VALUES_ACTION_BEAN.compositeAction = this;
	PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_STATUS_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_STATUS_1_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_STATUS_2_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_RED_SA_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_FUND_DTL_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_FUND_DTL_1_ACTION_BEAN.compositeAction = this;
	PT_BUS_RULE_ERROR_MSG_ACTION_BEAN.compositeAction = this;
	DUMMY_OCC_ACTION_BEAN.compositeAction = this;
	DUMMY_ACTION_BEAN.compositeAction = this;
	PT_IL_POLICY2_ACTION_BEAN.compositeAction = this;
	CTRL_ACTION_BEAN.compositeAction = this;
	BP_ACTION_BEAN.compositeAction = this;
	COPY_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN.compositeAction = this;
	PT_IL_POL_SA_INST_PYMT_ACTION_BEAN.compositeAction = this;
	try {/*
	     tabbedBar.addTab(TAB_PT_IL_POLICY,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POLICY}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POLICY$FORM_NAME_1$Caption"), false);
	     

	    tabbedBar.addTab(TAB_PT_IL_POLICY,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POLICY}",
		    PT_IL_POLICY_ACTION_BEAN.getCOMP_FORM_CAPTION().getValue().toString(), false);
	    
	    
	    
	    tabbedBar.addTab(TAB_PT_IL_POLICY_1,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POLICY_1}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POLICY_1$displayCaption"),
		    false);
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_ASSURED_DTLS,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_ASSURED_DTLS}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_ASSURED_DTLS$displayCaption"),
			    false);
	    tabbedBar.addTab(TAB_PT_IL_POL_APPL_PROD,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_APPL_PROD}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POL_APPL_PROD$displayCaption"),
		    false);
	   
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_APPL_PROD_1,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_APPL_PROD_1}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_APPL_PROD_1$displayCaption"),
			    false); 
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_ADDL_COVER,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_ADDL_COVER}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_ADDL_COVER$displayCaption"),
			    false);
	 
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_COVER_GROUP,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_COVER_GROUP}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_COVER_GROUP$displayCaption"),
			    false);
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_ASSR_MED_HIST_1,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_ASSR_MED_HIST_1}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_ASSR_MED_HIST_1$displayCaption"),
			    false); 
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_ADDL_COVER_1,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_ADDL_COVER_1}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_ADDL_COVER_1$displayCaption"),
			    false);
	  tabbedBar.addTab(TAB_PT_IL_POL_BENEFIT,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_BENEFIT}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POL_BENEFIT$displayCaption"),
		    false);
	    tabbedBar
	    .addTab(
		    TAB_PT_IL_POL_ASSURED_DTLS_1,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_ASSURED_DTLS_1}",
		    Messages
			    .getString(
				    "messageProperties_PILQ003",
				    "PILQ003$PT_IL_POL_ASSURED_DTLS_1$displayCaption"),
		    false);
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_BENEFICIARY,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_BENEFICIARY}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_BENEFICIARY$displayCaption"),
			    false);
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_SUB_BENEFIT,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_SUB_BENEFIT}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_SUB_BENEFIT$displayCaption"),
			    false);
	    tabbedBar
	    .addTab(
		    TAB_PT_IL_POL_ASSR_MED_HIST,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_ASSR_MED_HIST}",
		    Messages
			    .getString(
				    "messageProperties_PILQ003",
				    "PILQ003$PT_IL_POL_ASSR_MED_HIST$displayCaption"),
		    false);
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_ASSR_ILLNESS_DTLS,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_ASSR_ILLNESS_DTLS}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_ASSR_ILLNESS_DTLS$displayCaption"),
			    false);
	   
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_MED_EXAM_DTL,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_MED_EXAM_DTL}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_MED_EXAM_DTL$displayCaption"),
			    false);
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_MED_EXAM_DTL_1,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_MED_EXAM_DTL_1}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_MED_EXAM_DTL_1$displayCaption"),
			    false);
	    tabbedBar.addTab(TAB_PT_IL_POL_CHARGE,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_CHARGE}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POL_CHARGE$displayCaption"),
		    false);
	    
	    tabbedBar.addTab(
		    TAB_PT_IL_POL_DEDUCTIBLE,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_DEDUCTIBLE}",
		    Messages
			    .getString(
				    "messageProperties_PILQ003",
				    "PILQ003$PT_IL_POL_DEDUCTIBLE$displayCaption"),
		    false);
	   
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_COVER_GROUP_1,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_COVER_GROUP_1}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_COVER_GROUP_1$displayCaption"),
			    false); 
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_BROKER_DTL,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_BROKER_DTL}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_BROKER_DTL$displayCaption"),
			    false);
	    
	    tabbedBar
	    .addTab(
		    TAB_PT_IL_POL_BROKER_HEAD,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_BROKER_HEAD}",
		    Messages
			    .getString(
				    "messageProperties_PILQ003",
				    "PILQ003$PT_IL_POL_BROKER_HEAD$displayCaption"),
		    false);
	    tabbedBar
		    .addTab(
			    TAB_PM_IL_DOC_TODO_GROUP,
			    "#{PILQ003_COMPOSITE_ACTION.callPM_IL_DOC_TODO_GROUP}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PM_IL_DOC_TODO_GROUP$displayCaption"),
			    false);
	   
	    tabbedBar.addTab(  TAB_PT_IL_DOC_TODO_LIST_STATUS,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_DOC_TODO_LIST_STATUS}",
		    Messages.getString(
				    "messageProperties_PILQ003",
				    "PILQ003$PT_IL_DOC_TODO_LIST_STATUS$displayCaption"),
		    false);
	    
	    tabbedBar.addTab(TAB_PT_IL_POL_DISC_LOAD,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_DISC_LOAD}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POL_DISC_LOAD$displayCaption"),
		    false);
	    tabbedBar.addTab(TAB_PT_IL_POL_CONDITION,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_CONDITION}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POL_CONDITION$displayCaption"),
		    false);
	    
	    tabbedBar.addTab(TAB_PREMIUM_DETAILS,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_PREM_DTLS}",
		    Messages.getString("messageProperties_PILQ003",
		    "PILQ003$PT_IL_PREM_DTLS$displayCaption"),
		    false);
	    
	    tabbedBar.addTab(TAB_TAKAFUL_PREMIUM,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_TAKAFUL_PREM_DTLS}",
		    Messages.getString("messageProperties_PILQ003",
		    "PILQ003$PT_IL_TAKAFUL_PREM_DTLS$displayCaption"),
		    false);
	    
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_SURR_MAT_VALUES,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_SURR_MAT_VALUES}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_SURR_MAT_VALUES$displayCaption"),
			    false);
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_UNPAID_PREM_DTLS,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_UNPAID_PREM_DTLS}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_UNPAID_PREM_DTLS$displayCaption"),
			    false);
	    tabbedBar.addTab(TAB_PT_IL_POL_STATUS,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_STATUS}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POL_STATUS$displayCaption"),
		    false);
	    tabbedBar.addTab(TAB_PT_IL_POL_STATUS_1,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_STATUS_1}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POL_STATUS_1$displayCaption"),
		    false);
	    tabbedBar.addTab(TAB_PT_IL_POL_STATUS_2,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_STATUS_2}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POL_STATUS_2$displayCaption"),
		    false);
	  
	    tabbedBar.addTab(TAB_PT_IL_POL_RED_SA,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_RED_SA}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POL_RED_SA$displayCaption"),
		    false);
	    tabbedBar.addTab(TAB_PT_IL_POL_FUND_DTL,
		    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_FUND_DTL}",
		    Messages.getString("messageProperties_PILQ003",
			    "PILQ003$PT_IL_POL_FUND_DTL$displayCaption"),
		    false);
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_FUND_DTL_1,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_FUND_DTL_1}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_FUND_DTL_1$displayCaption"),
			    false);
	    
	    tabbedBar
		    .addTab(
			    TAB_PT_BUS_RULE_ERROR_MSG,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_BUS_RULE_ERROR_MSG}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_BUS_RULE_ERROR_MSG$displayCaption"),
			    false);

	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POLICY2,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POLICY2}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POLICY2$displayCaption"),
			    false);

	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_SA_INST_PYMT_HEAD,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_SA_INST_PYMT_HEAD}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_SA_INST_PYMT_HEAD$displayCaption"),
			    false);
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_SA_INST_PYMT1,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_SA_INST_PYMT1}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_SA_INST_PYMT1$displayCaption"),
			    false);
	    tabbedBar
		    .addTab(
			    TAB_PT_IL_POL_SA_INST_PYMT,
			    "#{PILQ003_COMPOSITE_ACTION.callPT_IL_POL_SA_INST_PYMT}",
			    Messages
				    .getString(
					    "messageProperties_PILQ003",
					    "PILQ003$PT_IL_POL_SA_INST_PYMT$displayCaption"),
			    false);

	*/} catch (Exception exc) {
	    // TODO Auto generated catch block;
	    exc.printStackTrace();

	}

    }

    public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
	return DUMMY_ACTION_BEAN;
    }

    public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
	DUMMY_ACTION_BEAN = dummy_action_bean;
    }

    public String callPolicyEntry() {
	String returnValue = null;
	try {
	    saveCurrentTab();
	    // this.getPT_IL_POLICY_ACTION_BEAN().loadingBaseValues();
	    returnValue = "PILQ003_PT_IL_POLICY";
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return returnValue;
    }

    private void saveCurrentTab() throws Exception {/*

	int activeTab = this.tabbedBar.getCurrentTabId();
	try {
	    if (activeTab != 0) {
		switch (activeTab) {
		case PILQ003_COMPOSITE_ACTION.TAB_PT_IL_POLICY:
		    // Save Policy
		    // PT_IL_POLICY_ACTION_BEAN.();
		    break;

		case PILQ003_COMPOSITE_ACTION.TAB_PT_IL_POL_ASSURED_DTLS:
		    // Save Assured
		    PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.saveRecord();
		    break;

		case PILQ003_COMPOSITE_ACTION.TAB_PT_IL_POL_BENEFICIARY:
		    // Save beneficiary
		    // PT_IL_POL_BENEFICIARY_ACTION_BEAN.postRecord(event);
		    break;
		default:
		    System.out
			    .println("-----------> Save not configured for current tabid: "
				    + activeTab);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    // setErrorMessageToCorrespondingErrorMap(e);
	    throw e;
	}
    */}
    
    
	

	/**
	 * @return the wizard
	 */
	public UIWizard getWizard() {
		return wizard;
	}

	/**
	 * @param wizard the wizard to set
	 */
	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
		/*UIWizard wizard2 = wizard;
		if(wizard2!=null){
			wizard = wizard2;
		}*/
	}

	public UISummary getComp() {
		return comp;
	}

	public void setComp(UISummary comp) {
		this.comp = comp;
	}
	
	public void disableCreatePostDelete(boolean disabled) {
		PT_IL_POLICY_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POLICY_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POLICY_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POLICY_1_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POLICY_1_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POLICY_1_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_ASSURED_DTLS_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_APPL_PROD_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_APPL_PROD_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_APPL_PROD_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_ASSR_MED_HIST_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_APPL_PROD_1_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_APPL_PROD_1_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_APPL_PROD_1_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_ADDL_COVER_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_ADDL_COVER_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_ADDL_COVER_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_COVER_GROUP_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_COVER_GROUP_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_COVER_GROUP_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_ADDL_COVER_1_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_ADDL_COVER_1_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_ADDL_COVER_1_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_BENEFIT_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_BENEFIT_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_BENEFIT_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_BENEFICIARY_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_BENEFICIARY_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_BENEFICIARY_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_SUB_BENEFIT_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_SUB_BENEFIT_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_SUB_BENEFIT_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_ASSR_ILLNESS_DTLS_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_DEDUCTIBLE_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_DEDUCTIBLE_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_DEDUCTIBLE_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_CHARGE_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_CHARGE_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_CHARGE_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_BROKER_HEAD_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_BROKER_HEAD_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_BROKER_HEAD_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_COVER_GROUP_1_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_COVER_GROUP_1_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_COVER_GROUP_1_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_BROKER_DTL_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_BROKER_DTL_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_BROKER_DTL_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_DISC_LOAD_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_DISC_LOAD_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_DISC_LOAD_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_CONDITION_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_CONDITION_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_CONDITION_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_SURR_MAT_VALUES_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_SURR_MAT_VALUES_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_SURR_MAT_VALUES_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_UNPAID_PREM_DTLS_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_STATUS_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_STATUS_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_STATUS_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_STATUS_1_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_STATUS_1_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_STATUS_1_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_STATUS_2_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_STATUS_2_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_STATUS_2_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_RED_SA_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_RED_SA_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_RED_SA_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_FUND_DTL_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_FUND_DTL_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_FUND_DTL_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_FUND_DTL_1_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_FUND_DTL_1_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_FUND_DTL_1_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_BUS_RULE_ERROR_MSG_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_BUS_RULE_ERROR_MSG_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_BUS_RULE_ERROR_MSG_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		DUMMY_OCC_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		DUMMY_OCC_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		DUMMY_OCC_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		DUMMY_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		DUMMY_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		DUMMY_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POLICY2_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POLICY2_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POLICY2_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		CTRL_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		CTRL_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		CTRL_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		BP_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		BP_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		BP_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		COPY_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		COPY_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		COPY_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_SA_INST_PYMT1_ACTION_BEAN.setDELETE_ALLOWED(disabled);
		PT_IL_POL_SA_INST_PYMT_ACTION_BEAN.setINSERT_ALLOWED(disabled);
		PT_IL_POL_SA_INST_PYMT_ACTION_BEAN.setUPDATE_ALLOWED(disabled);
		PT_IL_POL_SA_INST_PYMT_ACTION_BEAN.setDELETE_ALLOWED(disabled);
	}

    

}
