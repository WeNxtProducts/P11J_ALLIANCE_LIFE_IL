package com.iii.pel.forms.PILT006_APAC;
import com.iii.pel.commonimpl.summaryimpl.UISummary;
import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;
import com.iii.pel.forms.PILT002_APAC.PT_BUS_RULE_ERROR_MSG_ACTION;
import com.iii.pel.forms.PILT011.PILT011_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT013.PT_IL_POLICY_ACTION;
import com.iii.premia.common.utils.CommonUtils;
public class PILT006_APAC_COMPOSITE_ACTION{
	
/*	public final static int TAB_PT_IL_CLAIM = 1;
	public final static int TAB_PT_IL_CLAIM_COVER_DTLS = 2;
	public final static int TAB_PT_IL_CLAIM_ESTIMATE = 3;
	public final static int TAB_PT_IL_BONUS = 4;
	public final static int TAB_PT_IL_CLAIM_STATUS = 5;
	public final static int TAB_PT_IL_CLAIM_STATUS_1 = 6;
	public final static int TAB_PT_IL_CLAIM_STATUS_2 = 7;
	public final static int TAB_PM_IL_DOC_TODO_GROUP = 8;
	public final static int TAB_PT_IL_CLAIM_STATUS_3 = 9;
	public final static int TAB_PT_IL_DOC_TODO_LIST_STATUS = 10;
	public final static int TAB_PT_IL_FUND_TRAN_DTL = 11;
	public final static int TAB_PT_IL_CLAIM_ACC_FIR_DTLS = 12;
	public final static int TAB_PH_IL_CLAIM_COVER_DTLS = 13;*/

	private PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN ;
	private PT_IL_CLAIM_COVER_DTLS_ACTION PT_IL_CLAIM_COVER_DTLS_ACTION_BEAN ;
	private PT_IL_CLAIM_ESTIMATE_ACTION PT_IL_CLAIM_ESTIMATE_ACTION_BEAN ;
	private PT_IL_BONUS_ACTION PT_IL_BONUS_ACTION_BEAN ;
	private PT_IL_CLAIM_STATUS_ACTION PT_IL_CLAIM_STATUS_ACTION_BEAN ;
	private PT_IL_CLAIM_STATUS_1_ACTION PT_IL_CLAIM_STATUS_1_ACTION_BEAN ;
	private PT_IL_CLAIM_STATUS_2_ACTION PT_IL_CLAIM_STATUS_2_ACTION_BEAN ;
	private PM_IL_DOC_TODO_GROUP_ACTION PM_IL_DOC_TODO_GROUP_ACTION_BEAN ;
	private PT_IL_CLAIM_STATUS_3_ACTION PT_IL_CLAIM_STATUS_3_ACTION_BEAN ;
	private PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN ;
	private PT_IL_FUND_TRAN_DTL_ACTION PT_IL_FUND_TRAN_DTL_ACTION_BEAN ;
	private PT_IL_CLAIM_ACC_FIR_DTLS_ACTION PT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN ;
	private PH_IL_CLAIM_COVER_DTLS_ACTION PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN ;
	/*added by gopi for hands on feed back point serail no 16(Provision is required to enter deductibles) on 22/02/17*/
	private PT_IL_CLAIM_CHRG_ACTION PT_IL_CLAIM_CHRG_ACTION_BEAN;
	
	public PT_IL_CLAIM_CHRG_ACTION getPT_IL_CLAIM_CHRG_ACTION_BEAN() {
		return PT_IL_CLAIM_CHRG_ACTION_BEAN;
	}

	public void setPT_IL_CLAIM_CHRG_ACTION_BEAN(
			PT_IL_CLAIM_CHRG_ACTION pT_IL_CLAIM_CHRG_ACTION_BEAN) {
		PT_IL_CLAIM_CHRG_ACTION_BEAN = pT_IL_CLAIM_CHRG_ACTION_BEAN;
	}
	private PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN;
	
	public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION_BEAN() {
		return PT_IL_POLICY_ACTION_BEAN;
	}

	public void setPT_IL_POLICY_ACTION_BEAN(
			PT_IL_POLICY_ACTION pT_IL_POLICY_ACTION_BEAN) {
		PT_IL_POLICY_ACTION_BEAN = pT_IL_POLICY_ACTION_BEAN;
	}
	/*end*/
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	private CTRL_ACTION CTRL_ACTION_BEAN;
	
	private UIWizard wizard =null;
	private UISummary comp=null;
	
	
	/**
	 * @return the cTRL_ACTION_BEAN
	 */
	public CTRL_ACTION getCTRL_ACTION_BEAN() {
		return CTRL_ACTION_BEAN;
	}

	/**
	 * @param ctrl_action_bean the cTRL_ACTION_BEAN to set
	 */
	public void setCTRL_ACTION_BEAN(CTRL_ACTION ctrl_action_bean) {
		CTRL_ACTION_BEAN = ctrl_action_bean;
	}
	//Added by Ameen on 16-03-2017 as per Vinoth sugg. to have interface for claim rerports
	
		private PILT006_APAC_PRINT_ACTION PILT006_APAC_PRINT_ACTION_BEAN;

		public PILT006_APAC_PRINT_ACTION getPILT006_APAC_PRINT_ACTION_BEAN() {
			return PILT006_APAC_PRINT_ACTION_BEAN;
		}

		public void setPILT006_APAC_PRINT_ACTION_BEAN(
				PILT006_APAC_PRINT_ACTION pILT006_APAC_PRINT_ACTION_BEAN) {
			PILT006_APAC_PRINT_ACTION_BEAN = pILT006_APAC_PRINT_ACTION_BEAN;
		}
		
		private PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN;

		public PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION getPT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN() {
			return PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN;
		}

		public void setPT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN(
				PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION pT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN) {
			PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN = pT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN;
		}
		
		//end interface for claim rerports

	public PILT006_APAC_COMPOSITE_ACTION(){
	//	tabbedBar = new TabbedBar();
		PT_IL_CLAIM_ACTION_BEAN = new PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_COVER_DTLS_ACTION_BEAN = new PT_IL_CLAIM_COVER_DTLS_ACTION();
		PT_IL_CLAIM_ESTIMATE_ACTION_BEAN = new PT_IL_CLAIM_ESTIMATE_ACTION();
		PT_IL_BONUS_ACTION_BEAN = new PT_IL_BONUS_ACTION();
		PT_IL_CLAIM_STATUS_ACTION_BEAN = new PT_IL_CLAIM_STATUS_ACTION();
		PT_IL_CLAIM_STATUS_1_ACTION_BEAN = new PT_IL_CLAIM_STATUS_1_ACTION();
		PT_IL_CLAIM_STATUS_2_ACTION_BEAN = new PT_IL_CLAIM_STATUS_2_ACTION();
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN = new PM_IL_DOC_TODO_GROUP_ACTION();
		PT_IL_CLAIM_STATUS_3_ACTION_BEAN = new PT_IL_CLAIM_STATUS_3_ACTION();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN = new PT_IL_DOC_TODO_LIST_STATUS_ACTION();
		PT_IL_FUND_TRAN_DTL_ACTION_BEAN = new PT_IL_FUND_TRAN_DTL_ACTION();
		PT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN = new PT_IL_CLAIM_ACC_FIR_DTLS_ACTION();
		PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN = new PH_IL_CLAIM_COVER_DTLS_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		//Added by Ameen
				PILT006_APAC_PRINT_ACTION_BEAN = new PILT006_APAC_PRINT_ACTION();
				//end
		/*added by gopi for hands on feed back point serail no 16(Provision is required to enter deductibles) on 22/02/17*/
		PT_IL_CLAIM_CHRG_ACTION_BEAN = new PT_IL_CLAIM_CHRG_ACTION();
		PT_IL_POLICY_ACTION_BEAN = new PT_IL_POLICY_ACTION();
		/*end*/
		
		/*Added by saritha on 21-07-2017 for ssp call id ZBILQC-1732436*/
		PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN = new PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION();
		/*End*/
		
		try{
			/*tabbedBar.addTab(1, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_CLAIM}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_CLAIM$displayCaption"), false);
			tabbedBar.addTab(2, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_CLAIM_COVER_DTLS}", "Claim Cover Details", false);
			tabbedBar.addTab(3, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_CLAIM_ESTIMATE}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_CLAIM_ESTIMATE$displayCaption"), false);
			//tabbedBar.addTab(4, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_BONUS}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_BONUS$displayCaption"), false);
			tabbedBar.addTab(5, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_CLAIM_STATUS}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_CLAIM_STATUS$displayCaption"), false);
			//tabbedBar.addTab(6, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_CLAIM_STATUS_1}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_CLAIM_STATUS_1$displayCaption"), false);
			tabbedBar.addTab(7, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_CLAIM_STATUS_2}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_CLAIM_STATUS_2$displayCaption"), false);
			tabbedBar.addTab(8, "#{PILT006_APAC_COMPOSITE_ACTION.callPM_IL_DOC_TODO_GROUP}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PM_IL_DOC_TODO_GROUP$displayCaption"), false);
			tabbedBar.addTab(9, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_CLAIM_STATUS_3}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_CLAIM_STATUS_3$displayCaption"), false);
			//tabbedBar.addTab(10, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_DOC_TODO_LIST_STATUS}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_DOC_TODO_LIST_STATUS$displayCaption"), false);
			tabbedBar.addTab(11, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_FUND_TRAN_DTL}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_FUND_TRAN_DTL$displayCaption"), false);
			//tabbedBar.addTab(12, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_CLAIM_ACC_FIR_DTLS}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_CLAIM_ACC_FIR_DTLS$displayCaption"), false);
		//	tabbedBar.addTab(13, "#{PILT006_APAC_COMPOSITE_ACTION.callPH_IL_CLAIM_COVER_DTLS}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PH_IL_CLAIM_COVER_DTLS$displayCaption"), false);
			tabbedBar.addTab(14, "#{PILT006_APAC_COMPOSITE_ACTION.callPS_IL_CLAIM_LIMITS}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PS_IL_CLAIM_LIMITS$displayCaption"), false);
			tabbedBar.addTab(15, "#{PILT006_APAC_COMPOSITE_ACTION.callPT_IL_CLAIM_DEDUCTIBLE}", Messages.getString("messageProperties_PILT006_APAC", "PILT006_APAC$PT_IL_CLAIM_DEDUCTIBLE$displayCaption"), false);*/
			/* Modified by saranya for RI recovery details to be shown at Claim registration stage itself on 18/02/2017 */
			PT_IL_CLAIM_COVER_DTLS_ACTION_BEAN.PILT011compositeAction=new PILT011_COMPOSITE_ACTION();
			/*End*/
			PT_IL_CLAIM_ACTION_BEAN.compositeAction = this;
			PT_IL_CLAIM_COVER_DTLS_ACTION_BEAN.compositeAction = this;
			PT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN.compositeAction = this;
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.compositeAction = this;
			PT_IL_CLAIM_ESTIMATE_ACTION_BEAN.compositeAction = this;
			PT_IL_BONUS_ACTION_BEAN.compositeAction = this;
			PM_IL_DOC_TODO_GROUP_ACTION_BEAN.compositeAction = this;
			PT_IL_FUND_TRAN_DTL_ACTION_BEAN.compositeAction = this;
			PT_IL_CLAIM_STATUS_1_ACTION_BEAN.compositeAction = this;
			PT_IL_CLAIM_STATUS_3_ACTION_BEAN.compositeAction = this;
			PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN.compositeAction = this;
			PT_IL_CLAIM_STATUS_2_ACTION_BEAN.compositeAction = this;
			PT_IL_CLAIM_STATUS_ACTION_BEAN.compositeAction = this;
			DUMMY_ACTION_BEAN.compositeAction = this;
			//Added by Ameen
			PILT006_APAC_PRINT_ACTION_BEAN.compositeAction = this;
			//End
			/*added by gopi for hands on feed back point serail no 16(Provision is required to enter deductibles) on 22/02/17*/
			PT_IL_CLAIM_CHRG_ACTION_BEAN.compositeAction = this;
			//PT_IL_POLICY_ACTION_BEAN.compositeAction = this;
			/*end*/
			
			/*Added by saritha on 21-07-2017 for ssp call id ZBILQC-1732436*/
			PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN.compositeAction = this;
			/*End*/
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public String callPT_IL_CLAIM(){
		getPT_IL_CLAIM_ACTION_BEAN().setBlockFlag(true);
		preTabClick();
		return "claimsEntry";
		
		
	}
	public String callPT_IL_CLAIM_COVER_DTLS(){
		getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().setBlockFlag(true);
		/*Added by Ameen on 25-07-2017 for ZBILQC-1732254 */
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT006_APAC");
		/*END*/
		preTabClick();
		//return "PILT006_APAC_PT_IL_CLAIM_COVER_DTLS";
		return "claimCoverDetails";
		
	}
	/*added by gopi for hands on feed back point serail no 16(Provision is required to enter deductibles) on 22/02/17**/

	public String callPT_IL_CLAIM_CHARGES(){
		/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
		getPT_IL_CLAIM_CHRG_ACTION_BEAN().setBlockFlag(true);
		/*END*/
		preTabClick();
		return "claimCharge";
		
	}
	/*end*/
	public String callPT_IL_CLAIM_ESTIMATE(){
		getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().setBlockFlag(true);
		preTabClick();
		return "PILT006_APAC_PT_IL_CLAIM_ESTIMATE";
		
	}
	public String callPT_IL_BONUS(){
		getPT_IL_BONUS_ACTION_BEAN().setBlockFlag(true);
		preTabClick();
		return "PILT006_APAC_PT_IL_BONUS";
		
	}
	public String callPT_IL_CLAIM_STATUS(){
		getPT_IL_CLAIM_STATUS_ACTION_BEAN().setBlockFlag(true);
		preTabClick();
		return "PILT006_APAC_PT_IL_CLAIM_STATUS";
		
	}
	public String callPT_IL_CLAIM_STATUS_1(){
		getPT_IL_CLAIM_STATUS_1_ACTION_BEAN().setBlockFlag(true);
		preTabClick();
		return "PILT006_APAC_PT_IL_CLAIM_STATUS_1";
		
	}
	public String callPT_IL_CLAIM_STATUS_2(){
		getPT_IL_CLAIM_STATUS_2_ACTION_BEAN().setBlockFlag(true);
		preTabClick();
		return "reminders";
		//return "PILT006_APAC_PT_IL_CLAIM_STATUS_2";
		
	}
	public String callPM_IL_DOC_TODO_GROUP(){
		getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setBlockFlag(true);
		/* Modified by saranya for Avoidance of POST button required in all screens on 22-02-2017 */
		PM_IL_DOC_TODO_GROUP_ACTION_BEAN.setBlockFlag(true);
		getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().setBlockFlag(true);
		/*End*/
		preTabClick();
		//return "PILT006_APAC_PM_IL_DOC_TODO_GROUP";
		return "toDoGroup";
		
	}
	public String callPT_IL_CLAIM_STATUS_3(){
		getPT_IL_CLAIM_STATUS_3_ACTION_BEAN().setBlockFlag(true);
		preTabClick();
		return "PILT006_APAC_PT_IL_CLAIM_STATUS_3";
		
	}
	public String callPT_IL_DOC_TODO_LIST_STATUS(){
		preTabClick();
		return "toDoList";
		//return "PILT006_APAC_PT_IL_DOC_TODO_LIST_STATUS";
		
	}
	public String callPT_IL_FUND_TRAN_DTL(){
		preTabClick();
		return "PILT006_APAC_PT_IL_FUND_TRAN_DTL";
		
	}
	public String callPT_IL_CLAIM_ACC_FIR_DTLS(){
		preTabClick();
		return "claimAccFIRDtls";
		
	}
	public String callPH_IL_CLAIM_COVER_DTLS(){
		preTabClick();
		return "PILT006_APAC_PH_IL_CLAIM_COVER_DTLS";
		
	}
	public String callBP(){
		preTabClick();
		return "PILT006_APAC_BP";
		
	}
	public String navigationEnabled(){
		//added by gopi 22/11/2016 for RM018T - DEV_IL_ZB Life_012a_Claim Exclusions
		PT_IL_CLAIM_ACTION_BEAN.getErrorMap().clear();
		PT_IL_CLAIM_ACTION_BEAN.getWarningMap().clear();
		//end
		getWizard().setImmediate("true");
		 return "";
		
	}
	/*private void setImmediate(boolean flag){
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
			TabItem item = tabIterator.next();
			item.setImmediate(flag);
			
		}
		
	}*/
	private void preTabClick(){/*
		int currentTabId = tabbedBar.getCurrentTabId();
		switch(currentTabId){
			case 1 :PT_IL_CLAIM_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 ://PT_IL_CLAIM_COVER_DTLS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 ://PT_IL_CLAIM_ESTIMATE_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 ://PT_IL_BONUS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 5 ://PT_IL_CLAIM_STATUS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 6 ://PT_IL_CLAIM_STATUS_1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 7 ://PT_IL_CLAIM_STATUS_2_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 8 ://PM_IL_DOC_TODO_GROUP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 9 ://PT_IL_CLAIM_STATUS_3_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 10 ://PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 11 ://PT_IL_FUND_TRAN_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 12 ://PT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 13 :PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 14 ://BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			
			case 56 ://BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			
		}
		
	*/
		CommonUtils.clearMaps(PT_IL_CLAIM_ACTION_BEAN);
		CommonUtils.clearMaps(PT_IL_CLAIM_COVER_DTLS_ACTION_BEAN);
		CommonUtils.clearMaps(PT_IL_CLAIM_ESTIMATE_ACTION_BEAN);
		CommonUtils.clearMaps(PT_IL_BONUS_ACTION_BEAN);
		CommonUtils.clearMaps(PT_IL_CLAIM_STATUS_ACTION_BEAN);
		CommonUtils.clearMaps(PT_IL_CLAIM_STATUS_1_ACTION_BEAN);
		CommonUtils.clearMaps(PT_IL_CLAIM_STATUS_2_ACTION_BEAN);
		CommonUtils.clearMaps(PM_IL_DOC_TODO_GROUP_ACTION_BEAN);
		CommonUtils.clearMaps(PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN);
		CommonUtils.clearMaps(PT_IL_FUND_TRAN_DTL_ACTION_BEAN);
		CommonUtils.clearMaps(PT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN);
		CommonUtils.clearMaps(PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN);
		/*Added by saritha on 21-07-2017 for ssp call id ZBILQC-1732436*/
		CommonUtils.clearMaps(PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION_BEAN); 
		/*End*/
		}
	/*public void setTabbedBar(TabbedBar tabbedBar){
		this.tabbedBar=tabbedBar;
		
	}
	public TabbedBar getTabbedBar(){
		return this.tabbedBar;
		
	}*/
	
	public void setPT_IL_CLAIM_STATUS_1_ACTION_BEAN(PT_IL_CLAIM_STATUS_1_ACTION PT_IL_CLAIM_STATUS_1_ACTION_BEAN){
		this.PT_IL_CLAIM_STATUS_1_ACTION_BEAN=PT_IL_CLAIM_STATUS_1_ACTION_BEAN;
		
	}
	public PT_IL_CLAIM_STATUS_1_ACTION getPT_IL_CLAIM_STATUS_1_ACTION_BEAN(){
		return this.PT_IL_CLAIM_STATUS_1_ACTION_BEAN;
		
	}
	public void setPT_IL_CLAIM_STATUS_2_ACTION_BEAN(PT_IL_CLAIM_STATUS_2_ACTION PT_IL_CLAIM_STATUS_2_ACTION_BEAN){
		this.PT_IL_CLAIM_STATUS_2_ACTION_BEAN=PT_IL_CLAIM_STATUS_2_ACTION_BEAN;
		
	}
	public PT_IL_CLAIM_STATUS_2_ACTION getPT_IL_CLAIM_STATUS_2_ACTION_BEAN(){
		return this.PT_IL_CLAIM_STATUS_2_ACTION_BEAN;
		
	}
	public void setPM_IL_DOC_TODO_GROUP_ACTION_BEAN(PM_IL_DOC_TODO_GROUP_ACTION PM_IL_DOC_TODO_GROUP_ACTION_BEAN){
		this.PM_IL_DOC_TODO_GROUP_ACTION_BEAN=PM_IL_DOC_TODO_GROUP_ACTION_BEAN;
		
	}
	public PM_IL_DOC_TODO_GROUP_ACTION getPM_IL_DOC_TODO_GROUP_ACTION_BEAN(){
		return this.PM_IL_DOC_TODO_GROUP_ACTION_BEAN;
		
	}
	public void setPT_IL_CLAIM_STATUS_3_ACTION_BEAN(PT_IL_CLAIM_STATUS_3_ACTION PT_IL_CLAIM_STATUS_3_ACTION_BEAN){
		this.PT_IL_CLAIM_STATUS_3_ACTION_BEAN=PT_IL_CLAIM_STATUS_3_ACTION_BEAN;
		
	}
	public PT_IL_CLAIM_STATUS_3_ACTION getPT_IL_CLAIM_STATUS_3_ACTION_BEAN(){
		return this.PT_IL_CLAIM_STATUS_3_ACTION_BEAN;
		
	}
	public void setPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN(PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN){
		this.PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN=PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;
		
	}
	public PT_IL_DOC_TODO_LIST_STATUS_ACTION getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN(){
		return this.PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN;
		
	}
	public void setPT_IL_FUND_TRAN_DTL_ACTION_BEAN(PT_IL_FUND_TRAN_DTL_ACTION PT_IL_FUND_TRAN_DTL_ACTION_BEAN){
		this.PT_IL_FUND_TRAN_DTL_ACTION_BEAN=PT_IL_FUND_TRAN_DTL_ACTION_BEAN;
		
	}
	public PT_IL_FUND_TRAN_DTL_ACTION getPT_IL_FUND_TRAN_DTL_ACTION_BEAN(){
		return this.PT_IL_FUND_TRAN_DTL_ACTION_BEAN;
		
	}
	public void setPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN(PT_IL_CLAIM_ACC_FIR_DTLS_ACTION PT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN){
		this.PT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN=PT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN;
		
	}
	public PT_IL_CLAIM_ACC_FIR_DTLS_ACTION getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN(){
		return this.PT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN;
		
	}
	public void setPH_IL_CLAIM_COVER_DTLS_ACTION_BEAN(PH_IL_CLAIM_COVER_DTLS_ACTION PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN){
		this.PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN=PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN;
		
	}
	public PH_IL_CLAIM_COVER_DTLS_ACTION getPH_IL_CLAIM_COVER_DTLS_ACTION_BEAN(){
		return this.PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN;
		
	}

	
	/**
	 * @return the pT_IL_CLAIM_ACTION_BEAN
	 */
	public PT_IL_CLAIM_ACTION getPT_IL_CLAIM_ACTION_BEAN() {
		return PT_IL_CLAIM_ACTION_BEAN;
	}
	/**
	 * @param pt_il_claim_action_bean the pT_IL_CLAIM_ACTION_BEAN to set
	 */
	public void setPT_IL_CLAIM_ACTION_BEAN(
			PT_IL_CLAIM_ACTION pt_il_claim_action_bean) {
		PT_IL_CLAIM_ACTION_BEAN = pt_il_claim_action_bean;
	}
	/**
	 * @return the pT_IL_CLAIM_COVER_DTLS_ACTION_BEAN
	 */
	public PT_IL_CLAIM_COVER_DTLS_ACTION getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN() {
		return PT_IL_CLAIM_COVER_DTLS_ACTION_BEAN;
	}
	/**
	 * @param pt_il_claim_cover_dtls_action_bean the pT_IL_CLAIM_COVER_DTLS_ACTION_BEAN to set
	 */
	public void setPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN(
			PT_IL_CLAIM_COVER_DTLS_ACTION pt_il_claim_cover_dtls_action_bean) {
		PT_IL_CLAIM_COVER_DTLS_ACTION_BEAN = pt_il_claim_cover_dtls_action_bean;
	}
	/**
	 * @return the pT_IL_CLAIM_ESTIMATE_ACTION_BEAN
	 */
	public PT_IL_CLAIM_ESTIMATE_ACTION getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN() {
		return PT_IL_CLAIM_ESTIMATE_ACTION_BEAN;
	}
	/**
	 * @param pt_il_claim_estimate_action_bean the pT_IL_CLAIM_ESTIMATE_ACTION_BEAN to set
	 */
	public void setPT_IL_CLAIM_ESTIMATE_ACTION_BEAN(
			PT_IL_CLAIM_ESTIMATE_ACTION pt_il_claim_estimate_action_bean) {
		PT_IL_CLAIM_ESTIMATE_ACTION_BEAN = pt_il_claim_estimate_action_bean;
	}
	/**
	 * @return the pT_IL_BONUS_ACTION_BEAN
	 */
	public PT_IL_BONUS_ACTION getPT_IL_BONUS_ACTION_BEAN() {
		return PT_IL_BONUS_ACTION_BEAN;
	}
	/**
	 * @param pt_il_bonus_action_bean the pT_IL_BONUS_ACTION_BEAN to set
	 */
	public void setPT_IL_BONUS_ACTION_BEAN(
			PT_IL_BONUS_ACTION pt_il_bonus_action_bean) {
		PT_IL_BONUS_ACTION_BEAN = pt_il_bonus_action_bean;
	}
	/**
	 * @return the pT_IL_CLAIM_STATUS_ACTION_BEAN
	 */
	public PT_IL_CLAIM_STATUS_ACTION getPT_IL_CLAIM_STATUS_ACTION_BEAN() {
		return PT_IL_CLAIM_STATUS_ACTION_BEAN;
	}
	/**
	 * @param pt_il_claim_status_action_bean the pT_IL_CLAIM_STATUS_ACTION_BEAN to set
	 */
	public void setPT_IL_CLAIM_STATUS_ACTION_BEAN(
			PT_IL_CLAIM_STATUS_ACTION pt_il_claim_status_action_bean) {
		PT_IL_CLAIM_STATUS_ACTION_BEAN = pt_il_claim_status_action_bean;
	}

	/**
	 * @return the dUMMY_ACTION_BEAN
	 */
	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	/**
	 * @param dummy_action_bean the dUMMY_ACTION_BEAN to set
	 */
	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

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
	}

	/**
	 * @return the comp
	 */
	public UISummary getComp() {
		return comp;
	}

	/**
	 * @param comp the comp to set
	 */
	public void setComp(UISummary comp) {
		this.comp = comp;
	}
	
	/*Added by saritha on 21-07-2017 for ssp call id ZBILQC-1732436*/	
	private PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION PT_IL_CLAIM_BUS_RULE_ERROR_MSG_BEAN;

	public PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION getPT_IL_CLAIM_BUS_RULE_ERROR_MSG_BEAN() {
		return PT_IL_CLAIM_BUS_RULE_ERROR_MSG_BEAN;
	}

	public void setPT_IL_CLAIM_BUS_RULE_ERROR_MSG_BEAN(
			PT_IL_CLAIM_BUS_RULE_ERROR_MSG_ACTION pT_IL_CLAIM_BUS_RULE_ERROR_MSG_BEAN) {
		PT_IL_CLAIM_BUS_RULE_ERROR_MSG_BEAN = pT_IL_CLAIM_BUS_RULE_ERROR_MSG_BEAN;
	}
	/*End*/
	
}
