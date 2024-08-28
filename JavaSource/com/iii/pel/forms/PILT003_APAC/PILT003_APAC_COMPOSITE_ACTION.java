package com.iii.pel.forms.PILT003_APAC;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
public class PILT003_APAC_COMPOSITE_ACTION{
	public final static int TAB_PT_IL_POLICY = 1;
	public final static int TAB_PT_IL_PREM_COLL = 2;
	public final static int TAB_PT_IL_PYMT_DTLS = 3;
	public final static int TAB_PT_IL_LOAN_INT_COLL = 4;
	public final static int TAB_PT_IL_BROKER_VALUES = 5;
	public final static int TAB_PT_AGENT_COMM_VALUES = 6;
	public final static int TAB_PT_IL_PREM_COLL_CVR_DTL = 7;
	public final static int TAB_PT_IL_PREM_COLL_CHARGE = 8;
	public final static int TAB_CTRL1 = 9;
	public final static int TAB_CTRL = 10;
	public final static int TAB_BP = 11;
	private TabbedBar tabbedBar ;
	private PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN ;
	private PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN ;
	private PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN ;
	private PT_IL_LOAN_INT_COLL_ACTION PT_IL_LOAN_INT_COLL_ACTION_BEAN ;
	private PT_IL_BROKER_VALUES_ACTION PT_IL_BROKER_VALUES_ACTION_BEAN ;
	private PT_AGENT_COMM_VALUES_ACTION PT_AGENT_COMM_VALUES_ACTION_BEAN ;
	private PT_IL_PREM_COLL_CVR_DTL_ACTION PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN ;
	private PT_IL_PREM_COLL_CHARGE_ACTION PT_IL_PREM_COLL_CHARGE_ACTION_BEAN ;
	private DUMMY_ACTION DUMMY_ACTION_BEAN ;
	private CTRL1_ACTION CTRL1_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	public String callPT_IL_POLICY(){
		preTabClick();
		return "PILT003_APAC_PT_IL_POLICY";
		
	}
	public String callPT_IL_PREM_COLL(){
		preTabClick();
		return "PILT003_APAC_PT_IL_PREM_COLL";
		
	}
	public String callPT_IL_PYMT_DTLS(){
		preTabClick();
		return "PILT003_APAC_PT_IL_PYMT_DTLS";
		
	}
	public String callPT_IL_LOAN_INT_COLL(){
		preTabClick();
		return "PILT003_APAC_PT_IL_LOAN_INT_COLL";
		
	}
	public String callPT_IL_BROKER_VALUES(){
		preTabClick();
		return "PILT003_APAC_PT_IL_BROKER_VALUES";
		
	}
	public String callPT_AGENT_COMM_VALUES(){
		preTabClick();
		return "PILT003_APAC_PT_AGENT_COMM_VALUES";
		
	}
	public String callPT_IL_PREM_COLL_CVR_DTL(){
		preTabClick();
		return "PILT003_APAC_PT_IL_PREM_COLL_CVR_DTL";
		
	}
	public String callPT_IL_PREM_COLL_CHARGE(){
		preTabClick();
		return "PILT003_APAC_PT_IL_PREM_COLL_CHARGE";
		
	}
	public String callCTRL1(){
		preTabClick();
		return "PILT003_APAC_CTRL1";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILT003_APAC_CTRL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILT003_APAC_BP";
		
	}
	public String navigationEnabled(){
		setImmediate(true);
		 return "";
		
	}
	private void setImmediate(boolean flag){
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
			TabItem item = tabIterator.next();
			item.setImmediate(flag);
			
		}
		
	}
	private void preTabClick(){
		int currentTabId = tabbedBar.getCurrentTabId();
		switch(currentTabId){
			case 1 :PT_IL_POLICY_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :PT_IL_PREM_COLL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :PT_IL_PYMT_DTLS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :PT_IL_LOAN_INT_COLL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 5 :PT_IL_BROKER_VALUES_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 6 :PT_AGENT_COMM_VALUES_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 7 :PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 8 :PT_IL_PREM_COLL_CHARGE_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 9 :CTRL1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			/*case 10 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 11 :BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;*/
			
		}
		
	}
	public void setTabbedBar(TabbedBar tabbedBar){
		this.tabbedBar=tabbedBar;
		
	}
	public TabbedBar getTabbedBar(){
		return this.tabbedBar;
		
	}
	public void setPT_IL_POLICY_ACTION_BEAN(PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN){
		this.PT_IL_POLICY_ACTION_BEAN=PT_IL_POLICY_ACTION_BEAN;
		
	}
	public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION_BEAN(){
		return this.PT_IL_POLICY_ACTION_BEAN;
		
	}
	public void setPT_IL_PREM_COLL_ACTION_BEAN(PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN){
		this.PT_IL_PREM_COLL_ACTION_BEAN=PT_IL_PREM_COLL_ACTION_BEAN;
		
	}
	public PT_IL_PREM_COLL_ACTION getPT_IL_PREM_COLL_ACTION_BEAN(){
		return this.PT_IL_PREM_COLL_ACTION_BEAN;
		
	}
	public void setPT_IL_PYMT_DTLS_ACTION_BEAN(PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN){
		this.PT_IL_PYMT_DTLS_ACTION_BEAN=PT_IL_PYMT_DTLS_ACTION_BEAN;
		
	}
	public PT_IL_PYMT_DTLS_ACTION getPT_IL_PYMT_DTLS_ACTION_BEAN(){
		return this.PT_IL_PYMT_DTLS_ACTION_BEAN;
		
	}
	public void setPT_IL_LOAN_INT_COLL_ACTION_BEAN(PT_IL_LOAN_INT_COLL_ACTION PT_IL_LOAN_INT_COLL_ACTION_BEAN){
		this.PT_IL_LOAN_INT_COLL_ACTION_BEAN=PT_IL_LOAN_INT_COLL_ACTION_BEAN;
		
	}
	public PT_IL_LOAN_INT_COLL_ACTION getPT_IL_LOAN_INT_COLL_ACTION_BEAN(){
		return this.PT_IL_LOAN_INT_COLL_ACTION_BEAN;
		
	}
	public void setPT_IL_BROKER_VALUES_ACTION_BEAN(PT_IL_BROKER_VALUES_ACTION PT_IL_BROKER_VALUES_ACTION_BEAN){
		this.PT_IL_BROKER_VALUES_ACTION_BEAN=PT_IL_BROKER_VALUES_ACTION_BEAN;
		
	}
	public PT_IL_BROKER_VALUES_ACTION getPT_IL_BROKER_VALUES_ACTION_BEAN(){
		return this.PT_IL_BROKER_VALUES_ACTION_BEAN;
		
	}
	public void setPT_AGENT_COMM_VALUES_ACTION_BEAN(PT_AGENT_COMM_VALUES_ACTION PT_AGENT_COMM_VALUES_ACTION_BEAN){
		this.PT_AGENT_COMM_VALUES_ACTION_BEAN=PT_AGENT_COMM_VALUES_ACTION_BEAN;
		
	}
	public PT_AGENT_COMM_VALUES_ACTION getPT_AGENT_COMM_VALUES_ACTION_BEAN(){
		return this.PT_AGENT_COMM_VALUES_ACTION_BEAN;
		
	}
	public void setPT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN(PT_IL_PREM_COLL_CVR_DTL_ACTION PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN){
		this.PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN=PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN;
		
	}
	public PT_IL_PREM_COLL_CVR_DTL_ACTION getPT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN(){
		return this.PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN;
		
	}
	public void setPT_IL_PREM_COLL_CHARGE_ACTION_BEAN(PT_IL_PREM_COLL_CHARGE_ACTION PT_IL_PREM_COLL_CHARGE_ACTION_BEAN){
		this.PT_IL_PREM_COLL_CHARGE_ACTION_BEAN=PT_IL_PREM_COLL_CHARGE_ACTION_BEAN;
		
	}
	public PT_IL_PREM_COLL_CHARGE_ACTION getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN(){
		return this.PT_IL_PREM_COLL_CHARGE_ACTION_BEAN;
		
	}
	public void setCTRL1_ACTION_BEAN(CTRL1_ACTION CTRL1_ACTION_BEAN){
		this.CTRL1_ACTION_BEAN=CTRL1_ACTION_BEAN;
		
	}
	public CTRL1_ACTION getCTRL1_ACTION_BEAN(){
		return this.CTRL1_ACTION_BEAN;
		
	}
	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN){
		this.CTRL_ACTION_BEAN=CTRL_ACTION_BEAN;
		
	}
	public CTRL_ACTION getCTRL_ACTION_BEAN(){
		return this.CTRL_ACTION_BEAN;
		
	}
	public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN){
		this.BP_ACTION_BEAN=BP_ACTION_BEAN;
		
	}
	public BP_ACTION getBP_ACTION_BEAN(){
		return this.BP_ACTION_BEAN;
		
	}
	//added by krithika for payment slip agent
	private PILT003_APAC_PRINTACTION PILT003_APAC_PRINTACTION_BEAN;
	public PILT003_APAC_PRINTACTION getPILT003_APAC_PRINTACTION_BEAN() {
		return PILT003_APAC_PRINTACTION_BEAN;
	}
	public void setPILT003_APAC_PRINTACTION_BEAN(
			PILT003_APAC_PRINTACTION pILT003_APAC_PRINTACTION_BEAN) {
		PILT003_APAC_PRINTACTION_BEAN = pILT003_APAC_PRINTACTION_BEAN;
	}
	//end
	public PILT003_APAC_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PT_IL_POLICY_ACTION_BEAN = new PT_IL_POLICY_ACTION();
		PT_IL_PREM_COLL_ACTION_BEAN = new PT_IL_PREM_COLL_ACTION();
		PT_IL_PYMT_DTLS_ACTION_BEAN = new PT_IL_PYMT_DTLS_ACTION();
		PT_IL_LOAN_INT_COLL_ACTION_BEAN = new PT_IL_LOAN_INT_COLL_ACTION();
		PT_IL_BROKER_VALUES_ACTION_BEAN = new PT_IL_BROKER_VALUES_ACTION();
		PT_AGENT_COMM_VALUES_ACTION_BEAN = new PT_AGENT_COMM_VALUES_ACTION();
		PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN = new PT_IL_PREM_COLL_CVR_DTL_ACTION();
		PT_IL_PREM_COLL_CHARGE_ACTION_BEAN = new PT_IL_PREM_COLL_CHARGE_ACTION();
		PILT003_APAC_PRINTACTION_BEAN = new PILT003_APAC_PRINTACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		CTRL1_ACTION_BEAN = new CTRL1_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PT_IL_POLICY_ACTION_BEAN.compositeAction = this;
		PT_IL_PREM_COLL_ACTION_BEAN.compositeAction = this;
		PT_IL_PYMT_DTLS_ACTION_BEAN.compositeAction = this;
		PT_IL_LOAN_INT_COLL_ACTION_BEAN.compositeAction = this;
		PT_IL_BROKER_VALUES_ACTION_BEAN.compositeAction = this;
		PT_AGENT_COMM_VALUES_ACTION_BEAN.compositeAction = this;
		PT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN.compositeAction = this;
		PT_IL_PREM_COLL_CHARGE_ACTION_BEAN.compositeAction = this;
		CTRL1_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		PILT003_APAC_PRINTACTION_BEAN.compositeAction = this;
		try{
			/*tabbedBar.addTab(TAB_PT_IL_POLICY, "#{PILT003_APAC_COMPOSITE_ACTION.callPT_IL_POLICY}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$PT_IL_POLICY$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_PREM_COLL, "#{PILT003_APAC_COMPOSITE_ACTION.callPT_IL_PREM_COLL}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$PT_IL_PREM_COLL$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_PYMT_DTLS, "#{PILT003_APAC_COMPOSITE_ACTION.callPT_IL_PYMT_DTLS}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$PT_IL_PYMT_DTLS$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_LOAN_INT_COLL, "#{PILT003_APAC_COMPOSITE_ACTION.callPT_IL_LOAN_INT_COLL}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$PT_IL_LOAN_INT_COLL$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_BROKER_VALUES, "#{PILT003_APAC_COMPOSITE_ACTION.callPT_IL_BROKER_VALUES}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$PT_IL_BROKER_VALUES$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_AGENT_COMM_VALUES, "#{PILT003_APAC_COMPOSITE_ACTION.callPT_AGENT_COMM_VALUES}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$PT_AGENT_COMM_VALUES$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_PREM_COLL_CVR_DTL, "#{PILT003_APAC_COMPOSITE_ACTION.callPT_IL_PREM_COLL_CVR_DTL}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$PT_IL_PREM_COLL_CVR_DTL$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_PREM_COLL_CHARGE, "#{PILT003_APAC_COMPOSITE_ACTION.callPT_IL_PREM_COLL_CHARGE}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$PT_IL_PREM_COLL_CHARGE$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL1, "#{PILT003_APAC_COMPOSITE_ACTION.callCTRL1}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$CTRL1$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILT003_APAC_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILT003_APAC_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILT003_APAC", "PILT003_APAC$BP$displayCaption"), false);*/
			
		}
		catch(Exception exc){
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
	
}
