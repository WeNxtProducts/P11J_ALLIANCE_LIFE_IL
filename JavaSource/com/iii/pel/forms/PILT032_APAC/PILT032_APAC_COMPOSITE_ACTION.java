package com.iii.pel.forms.PILT032_APAC;
import java.util.Iterator;
import com.iii.pel.forms.PILT032_APAC.PT_IL_RECEIPT_TRANS_HDR_ACTION;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.pel.forms.PILT032_APAC.PT_IL_RECEIPT_TRANS_DTL_ACTION;
import java.util.ArrayList;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;

public class PILT032_APAC_COMPOSITE_ACTION{
	public final static int TAB_PT_IL_RECEIPT_TRANS_HDR = 1;
	public final static int TAB_PT_IL_RECEIPT_TRANS_DTL = 2;
	public final static int TAB_BP = 3;
	public final static int TAB_CTRL = 4;
	private TabbedBar tabbedBar ;
	private PT_IL_RECEIPT_TRANS_HDR_ACTION PT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN ;
	private PT_IL_RECEIPT_TRANS_DTL_ACTION PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN ;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}
	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}
	public String callPT_IL_RECEIPT_TRANS_HDR(){
		getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().setBlockFlag(true);
		preTabClick();
		return "PILT032_APAC_PT_IL_RECEIPT_TRANS_HDR";
		
	}
	public String callPT_IL_RECEIPT_TRANS_DTL(){
		getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().setBlockFlag(true);
		preTabClick();
		return "PILT032_APAC_PT_IL_RECEIPT_TRANS_DTL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILT032_APAC_BP";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILT032_APAC_CTRL";
		
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
			case 1 :PT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN.setBlockFlag(true);
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
	public void setPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN(PT_IL_RECEIPT_TRANS_HDR_ACTION PT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN){
		this.PT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN=PT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN;
		
	}
	public PT_IL_RECEIPT_TRANS_HDR_ACTION getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN(){
		return this.PT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN;
		
	}
	public void setPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN(PT_IL_RECEIPT_TRANS_DTL_ACTION PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN){
		this.PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN=PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN;
		
	}
	public PT_IL_RECEIPT_TRANS_DTL_ACTION getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN(){
		return this.PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN;
		
	}
	 
	public PILT032_APAC_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN = new PT_IL_RECEIPT_TRANS_HDR_ACTION();
		PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN = new PT_IL_RECEIPT_TRANS_DTL_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		PT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN.compositeAction = this;
		PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		try{
			
			
			/*
			 * Commented by Janani on 11.07.2017 for ZBILQC-1719675
			 * 
			 * tabbedBar.addTab(TAB_PT_IL_RECEIPT_TRANS_HDR, "#{PILT032_APAC_COMPOSITE_ACTION.callPT_IL_RECEIPT_TRANS_HDR}", Messages.getString("messageProperties_PILT032_APAC", "PILT032_APAC$PT_IL_RECEIPT_TRANS_HDR$displayCaption"), false);
			tabbedBar.addTab(TAB_PT_IL_RECEIPT_TRANS_DTL, "#{PILT032_APAC_COMPOSITE_ACTION.callPT_IL_RECEIPT_TRANS_DTL}", Messages.getString("messageProperties_PILT032_APAC", "PILT032_APAC$PT_IL_RECEIPT_TRANS_DTL$displayCaption"), false);*/

			//tabbedBar.addTab(TAB_BP, "#{PILT032_APAC_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILT032_APAC", "PILT032_APAC$BP$displayCaption"), false);
			//tabbedBar.addTab(TAB_CTRL, "#{PILT032_APAC_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILT032_APAC", "PILT032_APAC$CTRL$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	
}
