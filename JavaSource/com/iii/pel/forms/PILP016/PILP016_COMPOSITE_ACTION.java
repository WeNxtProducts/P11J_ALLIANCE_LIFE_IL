package com.iii.pel.forms.PILP016;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PILP016_COMPOSITE_ACTION{
	public final static int TAB_PRINT = 1;
	public final static int TAB_CTRL = 2;
	public final static int TAB_PS_GL_DRCR = 3;
	public final static int TAB_BP = 4;
	private TabbedBar tabbedBar ;
	private PRINT_ACTION PRINT_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private PS_GL_DRCR_ACTION PS_GL_DRCR_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	public String callPRINT(){
		preTabClick();
		return "PGLP016_PRINT";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PGLP016_CTRL";
		
	}
	public String callPS_GL_DRCR(){
		preTabClick();
		return "PGLP016_PS_GL_DRCR";
		
	}
	public String callBP(){
		preTabClick();
		return "PGLP016_BP";
		
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
			case 1 :PRINT_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :PS_GL_DRCR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :BP_ACTION_BEAN.setBlockFlag(true);
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
	public void setPRINT_ACTION_BEAN(PRINT_ACTION PRINT_ACTION_BEAN){
		this.PRINT_ACTION_BEAN=PRINT_ACTION_BEAN;
		
	}
	public PRINT_ACTION getPRINT_ACTION_BEAN(){
		return this.PRINT_ACTION_BEAN;
		
	}
	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN){
		this.CTRL_ACTION_BEAN=CTRL_ACTION_BEAN;
		
	}
	public CTRL_ACTION getCTRL_ACTION_BEAN(){
		return this.CTRL_ACTION_BEAN;
		
	}
	public void setPS_GL_DRCR_ACTION_BEAN(PS_GL_DRCR_ACTION PS_GL_DRCR_ACTION_BEAN){
		this.PS_GL_DRCR_ACTION_BEAN=PS_GL_DRCR_ACTION_BEAN;
		
	}
	public PS_GL_DRCR_ACTION getPS_GL_DRCR_ACTION_BEAN(){
		return this.PS_GL_DRCR_ACTION_BEAN;
		
	}
	public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN){
		this.BP_ACTION_BEAN=BP_ACTION_BEAN;
		
	}
	public BP_ACTION getBP_ACTION_BEAN(){
		return this.BP_ACTION_BEAN;
		
	}
	public PILP016_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PRINT_ACTION_BEAN = new PRINT_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		PS_GL_DRCR_ACTION_BEAN = new PS_GL_DRCR_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		PRINT_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		PS_GL_DRCR_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try{
			//tabbedBar.addTab(TAB_PRINT, "#{PGLP016_COMPOSITE_ACTION.callPRINT}", Messages.getString("messageProperties_PGLP016", "PGLP016$PRINT$displayCaption"), false);
			//tabbedBar.addTab(TAB_CTRL, "#{PGLP016_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PGLP016", "PGLP016$CTRL$displayCaption"), false);
			//tabbedBar.addTab(TAB_PS_GL_DRCR, "#{PGLP016_COMPOSITE_ACTION.callPS_GL_DRCR}", Messages.getString("messageProperties_PGLP016", "PGLP016$PS_GL_DRCR$displayCaption"), false);
			//tabbedBar.addTab(TAB_BP, "#{PGLP016_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PGLP016", "PGLP016$BP$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	
}
