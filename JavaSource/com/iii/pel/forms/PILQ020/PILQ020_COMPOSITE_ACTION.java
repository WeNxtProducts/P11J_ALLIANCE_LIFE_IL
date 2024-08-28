package com.iii.pel.forms.PILQ020;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PILQ020_COMPOSITE_ACTION{
	public final static int TAB_PT_IL_POLICY = 1;
	public final static int TAB_PT_IL_POLICY1 = 2;
	public final static int TAB_PT_IL_DEPOSIT = 3;
	public final static int TAB_PT_IL_PYMT_DTLS = 4;
	public final static int TAB_PT_IL_PREM_COLL = 5;
	public final static int TAB_PT_IL_PYMT_DTLS1 = 6;
	public final static int TAB_PT_IL_DEPOSIT1 = 7;
	public final static int TAB_PT_IL_PYMT_DTLS2 = 8;
	public final static int TAB_PM_IL_CONTRACTOR = 9;
	public final static int TAB_CTRL = 10;
	public final static int TAB_BP = 11;
	private TabbedBar tabbedBar ;
	private PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN ;
	private PT_IL_POLICY1_ACTION PT_IL_POLICY1_ACTION_BEAN ;
	private PT_IL_DEPOSIT_ACTION PT_IL_DEPOSIT_ACTION_BEAN ;
	private PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN ;
	private PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN ;
	private PT_IL_PYMT_DTLS1_ACTION PT_IL_PYMT_DTLS1_ACTION_BEAN ;
	private PT_IL_DEPOSIT1_ACTION PT_IL_DEPOSIT1_ACTION_BEAN ;
	private PT_IL_PYMT_DTLS2_ACTION PT_IL_PYMT_DTLS2_ACTION_BEAN ;
	private PM_IL_CONTRACTOR_ACTION PM_IL_CONTRACTOR_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	public String callPT_IL_POLICY(){
		preTabClick();
		return "PILQ020_PT_IL_POLICY";
		
	}
	public String callPT_IL_POLICY1(){
		preTabClick();
		return "PILQ020_PT_IL_POLICY1";
		
	}
	public String callPT_IL_DEPOSIT(){
		preTabClick();
		return "PILQ020_PT_IL_DEPOSIT";
		
	}
	public String callPT_IL_PYMT_DTLS(){
		preTabClick();
		return "PILQ020_PT_IL_PYMT_DTLS";
		
	}
	public String callPT_IL_PREM_COLL(){
		preTabClick();
		return "PILQ020_PT_IL_PREM_COLL";
		
	}
	public String callPT_IL_PYMT_DTLS1(){
		preTabClick();
		return "PILQ020_PT_IL_PYMT_DTLS1";
		
	}
	public String callPT_IL_DEPOSIT1(){
		preTabClick();
		return "PILQ020_PT_IL_DEPOSIT1";
		
	}
	public String callPT_IL_PYMT_DTLS2(){
		preTabClick();
		return "PILQ020_PT_IL_PYMT_DTLS2";
		
	}
	public String callPM_IL_CONTRACTOR(){
		preTabClick();
		return "PILQ020_PM_IL_CONTRACTOR";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILQ020_CTRL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILQ020_BP";
		
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
			case 2 :PT_IL_POLICY1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :PT_IL_DEPOSIT_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :PT_IL_PYMT_DTLS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 5 :PT_IL_PREM_COLL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 6 :PT_IL_PYMT_DTLS1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 7 :PT_IL_DEPOSIT1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 8 :PT_IL_PYMT_DTLS2_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 9 :PM_IL_CONTRACTOR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 10 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 11 :BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			
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
	public void setPT_IL_POLICY1_ACTION_BEAN(PT_IL_POLICY1_ACTION PT_IL_POLICY1_ACTION_BEAN){
		this.PT_IL_POLICY1_ACTION_BEAN=PT_IL_POLICY1_ACTION_BEAN;
		
	}
	public PT_IL_POLICY1_ACTION getPT_IL_POLICY1_ACTION_BEAN(){
		return this.PT_IL_POLICY1_ACTION_BEAN;
		
	}
	public void setPT_IL_DEPOSIT_ACTION_BEAN(PT_IL_DEPOSIT_ACTION PT_IL_DEPOSIT_ACTION_BEAN){
		this.PT_IL_DEPOSIT_ACTION_BEAN=PT_IL_DEPOSIT_ACTION_BEAN;
		
	}
	public PT_IL_DEPOSIT_ACTION getPT_IL_DEPOSIT_ACTION_BEAN(){
		return this.PT_IL_DEPOSIT_ACTION_BEAN;
		
	}
	public void setPT_IL_PYMT_DTLS_ACTION_BEAN(PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN){
		this.PT_IL_PYMT_DTLS_ACTION_BEAN=PT_IL_PYMT_DTLS_ACTION_BEAN;
		
	}
	public PT_IL_PYMT_DTLS_ACTION getPT_IL_PYMT_DTLS_ACTION_BEAN(){
		return this.PT_IL_PYMT_DTLS_ACTION_BEAN;
		
	}
	public void setPT_IL_PREM_COLL_ACTION_BEAN(PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN){
		this.PT_IL_PREM_COLL_ACTION_BEAN=PT_IL_PREM_COLL_ACTION_BEAN;
		
	}
	public PT_IL_PREM_COLL_ACTION getPT_IL_PREM_COLL_ACTION_BEAN(){
		return this.PT_IL_PREM_COLL_ACTION_BEAN;
		
	}
	public void setPT_IL_PYMT_DTLS1_ACTION_BEAN(PT_IL_PYMT_DTLS1_ACTION PT_IL_PYMT_DTLS1_ACTION_BEAN){
		this.PT_IL_PYMT_DTLS1_ACTION_BEAN=PT_IL_PYMT_DTLS1_ACTION_BEAN;
		
	}
	public PT_IL_PYMT_DTLS1_ACTION getPT_IL_PYMT_DTLS1_ACTION_BEAN(){
		return this.PT_IL_PYMT_DTLS1_ACTION_BEAN;
		
	}
	public void setPT_IL_DEPOSIT1_ACTION_BEAN(PT_IL_DEPOSIT1_ACTION PT_IL_DEPOSIT1_ACTION_BEAN){
		this.PT_IL_DEPOSIT1_ACTION_BEAN=PT_IL_DEPOSIT1_ACTION_BEAN;
		
	}
	public PT_IL_DEPOSIT1_ACTION getPT_IL_DEPOSIT1_ACTION_BEAN(){
		return this.PT_IL_DEPOSIT1_ACTION_BEAN;
		
	}
	public void setPT_IL_PYMT_DTLS2_ACTION_BEAN(PT_IL_PYMT_DTLS2_ACTION PT_IL_PYMT_DTLS2_ACTION_BEAN){
		this.PT_IL_PYMT_DTLS2_ACTION_BEAN=PT_IL_PYMT_DTLS2_ACTION_BEAN;
		
	}
	public PT_IL_PYMT_DTLS2_ACTION getPT_IL_PYMT_DTLS2_ACTION_BEAN(){
		return this.PT_IL_PYMT_DTLS2_ACTION_BEAN;
		
	}
	public void setPM_IL_CONTRACTOR_ACTION_BEAN(PM_IL_CONTRACTOR_ACTION PM_IL_CONTRACTOR_ACTION_BEAN){
		this.PM_IL_CONTRACTOR_ACTION_BEAN=PM_IL_CONTRACTOR_ACTION_BEAN;
		
	}
	public PM_IL_CONTRACTOR_ACTION getPM_IL_CONTRACTOR_ACTION_BEAN(){
		return this.PM_IL_CONTRACTOR_ACTION_BEAN;
		
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
	public PILQ020_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PT_IL_POLICY_ACTION_BEAN = new PT_IL_POLICY_ACTION();
		PT_IL_POLICY1_ACTION_BEAN = new PT_IL_POLICY1_ACTION();
		PT_IL_DEPOSIT_ACTION_BEAN = new PT_IL_DEPOSIT_ACTION();
		PT_IL_PYMT_DTLS_ACTION_BEAN = new PT_IL_PYMT_DTLS_ACTION();
		PT_IL_PREM_COLL_ACTION_BEAN = new PT_IL_PREM_COLL_ACTION();
		PT_IL_PYMT_DTLS1_ACTION_BEAN = new PT_IL_PYMT_DTLS1_ACTION();
		PT_IL_DEPOSIT1_ACTION_BEAN = new PT_IL_DEPOSIT1_ACTION();
		PT_IL_PYMT_DTLS2_ACTION_BEAN = new PT_IL_PYMT_DTLS2_ACTION();
		PM_IL_CONTRACTOR_ACTION_BEAN = new PM_IL_CONTRACTOR_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PT_IL_POLICY_ACTION_BEAN.compositeAction = this;
		PT_IL_POLICY1_ACTION_BEAN.compositeAction = this;
		PT_IL_DEPOSIT_ACTION_BEAN.compositeAction = this;
		PT_IL_PYMT_DTLS_ACTION_BEAN.compositeAction = this;
		PT_IL_PREM_COLL_ACTION_BEAN.compositeAction = this;
		PT_IL_PYMT_DTLS1_ACTION_BEAN.compositeAction = this;
		PT_IL_DEPOSIT1_ACTION_BEAN.compositeAction = this;
		PT_IL_PYMT_DTLS2_ACTION_BEAN.compositeAction = this;
		PM_IL_CONTRACTOR_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_PT_IL_POLICY, "#{PILQ020_COMPOSITE_ACTION.callPT_IL_POLICY}", Messages.getString("messageProperties_PILQ020", "PILQ020$PT_IL_POLICY$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_POLICY1, "#{PILQ020_COMPOSITE_ACTION.callPT_IL_POLICY1}", Messages.getString("messageProperties_PILQ020", "PILQ020$PT_IL_POLICY1$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_DEPOSIT, "#{PILQ020_COMPOSITE_ACTION.callPT_IL_DEPOSIT}", Messages.getString("messageProperties_PILQ020", "PILQ020$PT_IL_DEPOSIT$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_PYMT_DTLS, "#{PILQ020_COMPOSITE_ACTION.callPT_IL_PYMT_DTLS}", Messages.getString("messageProperties_PILQ020", "PILQ020$PT_IL_PYMT_DTLS$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_PREM_COLL, "#{PILQ020_COMPOSITE_ACTION.callPT_IL_PREM_COLL}", Messages.getString("messageProperties_PILQ020", "PILQ020$PT_IL_PREM_COLL$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_PYMT_DTLS1, "#{PILQ020_COMPOSITE_ACTION.callPT_IL_PYMT_DTLS1}", Messages.getString("messageProperties_PILQ020", "PILQ020$PT_IL_PYMT_DTLS1$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_DEPOSIT1, "#{PILQ020_COMPOSITE_ACTION.callPT_IL_DEPOSIT1}", Messages.getString("messageProperties_PILQ020", "PILQ020$PT_IL_DEPOSIT1$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_PYMT_DTLS2, "#{PILQ020_COMPOSITE_ACTION.callPT_IL_PYMT_DTLS2}", Messages.getString("messageProperties_PILQ020", "PILQ020$PT_IL_PYMT_DTLS2$displayCaption"), false);
			tabbedBar.addTab(TAB_PM_IL_CONTRACTOR, "#{PILQ020_COMPOSITE_ACTION.callPM_IL_CONTRACTOR}", Messages.getString("messageProperties_PILQ020", "PILQ020$PM_IL_CONTRACTOR$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILQ020_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILQ020", "PILQ020$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILQ020_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILQ020", "PILQ020$BP$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	
}
