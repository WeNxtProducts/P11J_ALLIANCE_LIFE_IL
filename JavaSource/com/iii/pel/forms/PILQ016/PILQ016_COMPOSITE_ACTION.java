package com.iii.pel.forms.PILQ016;

public class PILQ016_COMPOSITE_ACTION{
	private PT_AGENT_BUDGET_ACTION PT_AGENT_BUDGET_ACTION_BEAN ;
	private PS_AGENT_MON_BUDGET_ACTION PS_AGENT_MON_BUDGET_ACTION_BEAN ;
	private PS_AGENT_CUR_MON_BUDGET_ACTION PS_AGENT_CUR_MON_BUDGET_ACTION_BEAN ;
	
	/*public String callPT_AGENT_BUDGET(){
		preTabClick();
		return "PILQ016_PT_AGENT_BUDGET";
		
	}
	public String callPS_AGENT_MON_BUDGET(){
		preTabClick();
		return "PILQ016_PS_AGENT_MON_BUDGET";
		
	}
	public String callPS_AGENT_CUR_MON_BUDGET(){
		preTabClick();
		return "PILQ016_PS_AGENT_CUR_MON_BUDGET";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILQ016_CTRL";
		
	}
	public String callBP(){
		preTabClick();
		return "PILQ016_BP";
		
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
			case 1 :PT_AGENT_BUDGET_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :PS_AGENT_MON_BUDGET_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :PS_AGENT_CUR_MON_BUDGET_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 5 :BP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			
		}
		
	}*/
	
	public void setPT_AGENT_BUDGET_ACTION_BEAN(PT_AGENT_BUDGET_ACTION PT_AGENT_BUDGET_ACTION_BEAN){
		this.PT_AGENT_BUDGET_ACTION_BEAN=PT_AGENT_BUDGET_ACTION_BEAN;
		
	}
	public PT_AGENT_BUDGET_ACTION getPT_AGENT_BUDGET_ACTION_BEAN(){
		return this.PT_AGENT_BUDGET_ACTION_BEAN;
		
	}
	public void setPS_AGENT_MON_BUDGET_ACTION_BEAN(PS_AGENT_MON_BUDGET_ACTION PS_AGENT_MON_BUDGET_ACTION_BEAN){
		this.PS_AGENT_MON_BUDGET_ACTION_BEAN=PS_AGENT_MON_BUDGET_ACTION_BEAN;
		
	}
	public PS_AGENT_MON_BUDGET_ACTION getPS_AGENT_MON_BUDGET_ACTION_BEAN(){
		return this.PS_AGENT_MON_BUDGET_ACTION_BEAN;
		
	}
	public void setPS_AGENT_CUR_MON_BUDGET_ACTION_BEAN(PS_AGENT_CUR_MON_BUDGET_ACTION PS_AGENT_CUR_MON_BUDGET_ACTION_BEAN){
		this.PS_AGENT_CUR_MON_BUDGET_ACTION_BEAN=PS_AGENT_CUR_MON_BUDGET_ACTION_BEAN;
		
	}
	public PS_AGENT_CUR_MON_BUDGET_ACTION getPS_AGENT_CUR_MON_BUDGET_ACTION_BEAN(){
		return this.PS_AGENT_CUR_MON_BUDGET_ACTION_BEAN;
		
	}
	public PILQ016_COMPOSITE_ACTION(){
		PT_AGENT_BUDGET_ACTION_BEAN = new PT_AGENT_BUDGET_ACTION();
		PS_AGENT_MON_BUDGET_ACTION_BEAN = new PS_AGENT_MON_BUDGET_ACTION();
		PS_AGENT_CUR_MON_BUDGET_ACTION_BEAN = new PS_AGENT_CUR_MON_BUDGET_ACTION();
		
		PT_AGENT_BUDGET_ACTION_BEAN.compositeAction = this;
		PS_AGENT_MON_BUDGET_ACTION_BEAN.compositeAction = this;
		PS_AGENT_CUR_MON_BUDGET_ACTION_BEAN.compositeAction = this;

		/*try{
			tabbedBar.addTab(TAB_PT_AGENT_BUDGET, "#{PILQ016_COMPOSITE_ACTION.callPT_AGENT_BUDGET}", Messages.getString("messageProperties_PILQ016", "PILQ016$PT_AGENT_BUDGET$displayCaption"), false);
			tabbedBar.addTab(TAB_PS_AGENT_MON_BUDGET, "#{PILQ016_COMPOSITE_ACTION.callPS_AGENT_MON_BUDGET}", Messages.getString("messageProperties_PILQ016", "PILQ016$PS_AGENT_MON_BUDGET$displayCaption"), false);
			tabbedBar.addTab(TAB_PS_AGENT_CUR_MON_BUDGET, "#{PILQ016_COMPOSITE_ACTION.callPS_AGENT_CUR_MON_BUDGET}", Messages.getString("messageProperties_PILQ016", "PILQ016$PS_AGENT_CUR_MON_BUDGET$displayCaption"), false);
			tabbedBar.addTab(TAB_CTRL, "#{PILQ016_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILQ016", "PILQ016$CTRL$displayCaption"), false);
			tabbedBar.addTab(TAB_BP, "#{PILQ016_COMPOSITE_ACTION.callBP}", Messages.getString("messageProperties_PILQ016", "PILQ016$BP$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}*/
	}
}
