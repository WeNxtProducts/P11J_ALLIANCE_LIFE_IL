package com.iii.pel.forms.PP100_1APAC;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PP100_1APAC_COMPOSITE_ACTION{
	public final static int TAB_PP_UPLOAD_FILE_DTLS = 1;
	public final static int TAB_BP = 2;
	public final static int TAB_CTRL = 3;
	private TabbedBar tabbedBar ;
	private PP_UPLOAD_FILE_DTLS_ACTION PP_UPLOAD_FILE_DTLS_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	public String callPP_UPLOAD_FILE_DTLS(){
		preTabClick();
		return "PP100_1APAC_PP_UPLOAD_FILE_DTLS";
		
	}
	public String callBP(){
		preTabClick();
		return "PP100_1APAC_BP";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PP100_1APAC_CTRL";
		
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
			case 1 :PP_UPLOAD_FILE_DTLS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :CTRL_ACTION_BEAN.setBlockFlag(true);
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
	public void setPP_UPLOAD_FILE_DTLS_ACTION_BEAN(PP_UPLOAD_FILE_DTLS_ACTION PP_UPLOAD_FILE_DTLS_ACTION_BEAN){
		this.PP_UPLOAD_FILE_DTLS_ACTION_BEAN=PP_UPLOAD_FILE_DTLS_ACTION_BEAN;
		
	}
	public PP_UPLOAD_FILE_DTLS_ACTION getPP_UPLOAD_FILE_DTLS_ACTION_BEAN(){
		return this.PP_UPLOAD_FILE_DTLS_ACTION_BEAN;
		
	}
	public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN){
		this.BP_ACTION_BEAN=BP_ACTION_BEAN;
		
	}
	public BP_ACTION getBP_ACTION_BEAN(){
		return this.BP_ACTION_BEAN;
		
	}
	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN){
		this.CTRL_ACTION_BEAN=CTRL_ACTION_BEAN;
		
	}
	public CTRL_ACTION getCTRL_ACTION_BEAN(){
		return this.CTRL_ACTION_BEAN;
		
	}
	public PP100_1APAC_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PP_UPLOAD_FILE_DTLS_ACTION_BEAN = new PP_UPLOAD_FILE_DTLS_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		PP_UPLOAD_FILE_DTLS_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_PP_UPLOAD_FILE_DTLS, "#{PP100_1APAC_COMPOSITE_ACTION.callPP_UPLOAD_FILE_DTLS}", Messages.getString("messageProperties_PP100_1APAC", "PP100_1APAC$PP_UPLOAD_FILE_DTLS$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PP100_1APAC_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PP100_1APAC", "PP100_1APAC$BP$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PP100_1APAC_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PP100_1APAC", "PP100_1APAC$CTRL$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	
}
