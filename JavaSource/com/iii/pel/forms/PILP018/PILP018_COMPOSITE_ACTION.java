package com.iii.pel.forms.PILP018;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
public class PILP018_COMPOSITE_ACTION{
	public final static int TAB_PT_IL_CHEQUE_BOUNCE_HDR = 1;
	public final static int TAB_PT_IL_PYMT_DTLS = 2;
	public final static int TAB_PT_IL_LOAN_REPAYMENT = 3;
	public final static int TAB_PT_IL_PREM_COLL = 4;
	public final static int TAB_PT_IL_DEPOSIT = 5;
	public final static int TAB_CTRL = 6;
	public final static int TAB_BP = 7;
	private TabbedBar tabbedBar ;
	
	private PT_IL_CHEQUE_BOUNCE_HDR_ACTION PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN ;
	private PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN ;
	private PT_IL_LOAN_REPAYMENT_ACTION PT_IL_LOAN_REPAYMENT_ACTION_BEAN ;
	private PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN ;
	private PT_IL_DEPOSIT_ACTION PT_IL_DEPOSIT_ACTION_BEAN ;
	private DUMMY_ACTION DUMMY_ACTION_BEAN ;
	 
	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
	    return DUMMY_ACTION_BEAN;
	}
	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
	    DUMMY_ACTION_BEAN = dummy_action_bean;
	}
	public String callPT_IL_CHEQUE_BOUNCE_HDR(){
		preTabClick();
		return "PILP018_PT_IL_CHEQUE_BOUNCE_HDR";
		
	}
	public String callPT_IL_PYMT_DTLS(){
		preTabClick();
		return "PILP018_PT_IL_PYMT_DTLS";
		
	}
	public String callPT_IL_LOAN_REPAYMENT(){
		preTabClick();
		return "PILP018_PT_IL_LOAN_REPAYMENT";
		
	}
	public String callPT_IL_PREM_COLL(){
		preTabClick();
		return "PILP018_PT_IL_PREM_COLL";
		
	}
	public String callPT_IL_DEPOSIT(){
		preTabClick();
		return "PILP018_PT_IL_DEPOSIT";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILP018_CTRL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILP018_BP";
		
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
			case 1 :PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :PT_IL_PYMT_DTLS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :PT_IL_LOAN_REPAYMENT_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :PT_IL_PREM_COLL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 5 :PT_IL_DEPOSIT_ACTION_BEAN.setBlockFlag(true);
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
	public void setPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN(PT_IL_CHEQUE_BOUNCE_HDR_ACTION PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN){
		this.PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN=PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN;
		
	}
	public PT_IL_CHEQUE_BOUNCE_HDR_ACTION getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN(){
		return this.PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN;
		
	}
	public void setPT_IL_PYMT_DTLS_ACTION_BEAN(PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN){
		this.PT_IL_PYMT_DTLS_ACTION_BEAN=PT_IL_PYMT_DTLS_ACTION_BEAN;
		
	}
	public PT_IL_PYMT_DTLS_ACTION getPT_IL_PYMT_DTLS_ACTION_BEAN(){
		return this.PT_IL_PYMT_DTLS_ACTION_BEAN;
		
	}
	public void setPT_IL_LOAN_REPAYMENT_ACTION_BEAN(PT_IL_LOAN_REPAYMENT_ACTION PT_IL_LOAN_REPAYMENT_ACTION_BEAN){
		this.PT_IL_LOAN_REPAYMENT_ACTION_BEAN=PT_IL_LOAN_REPAYMENT_ACTION_BEAN;
		
	}
	public PT_IL_LOAN_REPAYMENT_ACTION getPT_IL_LOAN_REPAYMENT_ACTION_BEAN(){
		return this.PT_IL_LOAN_REPAYMENT_ACTION_BEAN;
		
	}
	public void setPT_IL_PREM_COLL_ACTION_BEAN(PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN){
		this.PT_IL_PREM_COLL_ACTION_BEAN=PT_IL_PREM_COLL_ACTION_BEAN;
		
	}
	public PT_IL_PREM_COLL_ACTION getPT_IL_PREM_COLL_ACTION_BEAN(){
		return this.PT_IL_PREM_COLL_ACTION_BEAN;
		
	}
	public void setPT_IL_DEPOSIT_ACTION_BEAN(PT_IL_DEPOSIT_ACTION PT_IL_DEPOSIT_ACTION_BEAN){
		this.PT_IL_DEPOSIT_ACTION_BEAN=PT_IL_DEPOSIT_ACTION_BEAN;
		
	}
	public PT_IL_DEPOSIT_ACTION getPT_IL_DEPOSIT_ACTION_BEAN(){
		return this.PT_IL_DEPOSIT_ACTION_BEAN;
		
	}
	 
	public PILP018_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		try {
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN = new PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
		    PT_IL_PYMT_DTLS_ACTION_BEAN = new PT_IL_PYMT_DTLS_ACTION();
		    PT_IL_LOAN_REPAYMENT_ACTION_BEAN = new PT_IL_LOAN_REPAYMENT_ACTION();
		    PT_IL_PREM_COLL_ACTION_BEAN = new PT_IL_PREM_COLL_ACTION();
		    PT_IL_DEPOSIT_ACTION_BEAN = new PT_IL_DEPOSIT_ACTION();
		    DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.compositeAction = this;
		    PT_IL_PYMT_DTLS_ACTION_BEAN.compositeAction = this;
		    PT_IL_LOAN_REPAYMENT_ACTION_BEAN.compositeAction = this;
		    PT_IL_PREM_COLL_ACTION_BEAN.compositeAction = this;
		    PT_IL_DEPOSIT_ACTION_BEAN.compositeAction = this;
		    DUMMY_ACTION_BEAN.compositeAction = this;
		} catch (RuntimeException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
	}
	
}
