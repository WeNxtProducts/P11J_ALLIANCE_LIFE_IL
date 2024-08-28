package com.iii.pel.forms.PM094_A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION {
	
	private PM_AGENT_BONUS_SETUP_ACTION PM_AGENT_BONUS_SETUP_ACTION_BEAN;
	
	private PM_AGENT_BONUS_APPL_PROD_ACTION PM_AGENT_BONUS_APPL_PROD_ACTION_BEAN;
	
	private PM_AGENT_BONUS_APPL_RANKS_ACTION PM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN;
	
	private PM_AGENT_BONUS_RATES_ACTION PM_AGENT_BONUS_RATES_ACTION_BEAN;
	
	private TabbedBar tabbedBar;
	
	public static final int PM_AGENT_BONUS_SETUP = 1;
	
	public static final int PM_AGENT_BONUS_APPL_PROD=2;
	
	public static final int PM_AGENT_BONUS_APPL_RANKS=3;
	
	public static final int PM_AGENT_BONUS_RATES=4;
	/*Added by Ameen on 01-08-2018 for KICLIFEQC-1760174 as per Ajay*/
	public static final int PM_AGENT_PERC_RANGE=5;
	/*end*/
	
	
	private ControlBean CONTROL_BEAN;
	
	public PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION(){
		
		tabbedBar = new TabbedBar();
		try {
			CONTROL_BEAN = (ControlBean) CommonUtils.getControlBean().clone();
			
			String bonusSetup=Messages.getString("messageProperties_PM094_A", "PM094_A$PM_AGENT_BONUS_SETUP$displayCaption");
			
			String applProd=Messages.getString("messageProperties_PM094_A", "PM094_A$PM_AGENT_BONUS_APPL_PROD$displayCaption");
			
			String applRanks=Messages.getString("messageProperties_PM094_A", "PM094_A$PM_AGENT_BONUS_APPL_RANKS$displayCaption");
			
			String bonusRates=Messages.getString("messageProperties_PM094_A", "PM094_A$PM_AGENT_BONUS_RATES$displayCaption");
			
			/*Added by Ameen on 01-08-2018 for KICLIFEQC-1760174 as per Ajay*/
			String percentageRange=Messages.getString("messageProperties_PM094_A", "PM094_A$PM_AGENT_PERC_RANGE$displayCaption");
			/*end*/
			
			tabbedBar.addTab(PM_AGENT_BONUS_SETUP, "#{PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION.gotoPM_AGENT_BONUS_SETUP}", bonusSetup, false);
			
			tabbedBar.addTab(PM_AGENT_BONUS_APPL_PROD, "#{PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION.gotoPM_AGENT_BONUS_APPL_PROD}", applProd, false);
			
			tabbedBar.addTab(PM_AGENT_BONUS_APPL_RANKS, "#{PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION.gotoPM_AGENT_BONUS_APPL_RANKS}", applRanks, false);
			
			tabbedBar.addTab(PM_AGENT_BONUS_RATES, "#{PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION.gotoPM_AGENT_BONUS_RATES}", bonusRates, false);
			
			/*Added by Ameen on 01-08-2018 for KICLIFEQC-1760174 as per Ajay*/
			tabbedBar.addTab(PM_AGENT_PERC_RANGE, "#{PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION.gotoPM_AGENT_PERC_RANGE}", percentageRange, false);
			/*end*/
			
			PM_AGENT_BONUS_SETUP_ACTION_BEAN=new PM_AGENT_BONUS_SETUP_ACTION();
			
			PM_AGENT_BONUS_APPL_PROD_ACTION_BEAN=new PM_AGENT_BONUS_APPL_PROD_ACTION();
			
			PM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN=new PM_AGENT_BONUS_APPL_RANKS_ACTION();
			
			PM_AGENT_BONUS_RATES_ACTION_BEAN=new PM_AGENT_BONUS_RATES_ACTION();
			
			PM_AGENT_BONUS_SETUP_ACTION_BEAN.compositeAction = this;
			PM_AGENT_BONUS_APPL_PROD_ACTION_BEAN.compositeAction =this;
			PM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN.compositeAction =this;
			PM_AGENT_BONUS_RATES_ACTION_BEAN.compositeAction =this;
			/*Added by Ameen on 01-08-2018 for KICLIFEQC-1760174 as per Ajay*/
			PM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN = new PM_AGENT_BONUS_PERC_RANGE_ACTION();
			PM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN.compositeAction = this;
			/*end*/
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}


	public PM_AGENT_BONUS_SETUP_ACTION getPM_AGENT_BONUS_SETUP_ACTION_BEAN() {
		return PM_AGENT_BONUS_SETUP_ACTION_BEAN;
	}


	public void setPM_AGENT_BONUS_SETUP_ACTION_BEAN(
			PM_AGENT_BONUS_SETUP_ACTION pm_agent_bonus_setup_action_bean) {
		PM_AGENT_BONUS_SETUP_ACTION_BEAN = pm_agent_bonus_setup_action_bean;
	}


	public PM_AGENT_BONUS_APPL_PROD_ACTION getPM_AGENT_BONUS_APPL_PROD_ACTION_BEAN() {
		return PM_AGENT_BONUS_APPL_PROD_ACTION_BEAN;
	}


	public void setPM_AGENT_BONUS_APPL_PROD_ACTION_BEAN(
			PM_AGENT_BONUS_APPL_PROD_ACTION pm_agent_bonus_appl_prod_action_bean) {
		PM_AGENT_BONUS_APPL_PROD_ACTION_BEAN = pm_agent_bonus_appl_prod_action_bean;
	}


	public PM_AGENT_BONUS_APPL_RANKS_ACTION getPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN() {
		return PM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN;
	}


	public void setPM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN(
			PM_AGENT_BONUS_APPL_RANKS_ACTION pm_agent_bonus_appl_ranks_action_bean) {
		PM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN = pm_agent_bonus_appl_ranks_action_bean;
	}


	public PM_AGENT_BONUS_RATES_ACTION getPM_AGENT_BONUS_RATES_ACTION_BEAN() {
		return PM_AGENT_BONUS_RATES_ACTION_BEAN;
	}


	public void setPM_AGENT_BONUS_RATES_ACTION_BEAN(
			PM_AGENT_BONUS_RATES_ACTION pm_agent_bonus_rates_action_bean) {
		PM_AGENT_BONUS_RATES_ACTION_BEAN = pm_agent_bonus_rates_action_bean;
	}
	
	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}
	
	public String gotoPM_AGENT_BONUS_SETUP(){
		String outcome = "agentbonussetup";
		
		saveCurrentTab();
		
		return outcome;
	}
	
	public String gotoPM_AGENT_BONUS_APPL_PROD(){
		String outcome = "agentbonusapplprod";
		HashMap<String, String> errorMap = new HashMap<String, String>();
		PM_AGENT_BONUS_APPL_PROD_ACTION_BEAN.loadBonusApplProd(errorMap);
		saveCurrentTab();
		
		return outcome;
	}
	public String gotoPM_AGENT_BONUS_APPL_RANKS(){
		String outcome = "agentbonusapplranks";
		HashMap<String, String> errorMap = new HashMap<String, String>();
		PM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN.loadBonusApplRanks(errorMap);
		saveCurrentTab();
		/*Added by Ameen on 23-04-2018 for KIC*/
		PM_AGENT_BONUS_RATES_ACTION_BEAN.setBlockFlag(true);
		/*end*/
		
		return outcome;
	}
	public String gotoPM_AGENT_BONUS_RATES(){
		String outcome = "agentbonusrates";
		HashMap<String, String> errorMap = new HashMap<String, String>();
		saveCurrentTab();
		String absCode=null;
		String rankCode=null;
		int selectedItems=0;
		Iterator<PM_AGENT_BONUS_APPL_RANKS> applRanksItr=PM_AGENT_BONUS_APPL_RANKS_ACTION_BEAN.getDataList_PM_AGENT_BONUS_APPL_RANKS().iterator();
		while(applRanksItr.hasNext()){
			PM_AGENT_BONUS_APPL_RANKS applRanksBean=applRanksItr.next();
			if(applRanksBean.isSelected()){
				absCode=applRanksBean.getABAR_ABS_CODE();
				rankCode=applRanksBean.getABAR_RANK_CODE();
				System.out.println("ABS CODE IN COMPOSITE aCTION :"+absCode);
				System.out.println("Rank code in composite Action :"+rankCode);
				PM_AGENT_BONUS_RATES_ACTION_BEAN.loadBonusRates(errorMap,applRanksBean);
				selectedItems++;
			}
		}
		
		return outcome;
	}
	
	public void saveCurrentTab(){
		
	}


	public ControlBean getCONTROL_BEAN() {
		return CONTROL_BEAN;
	}


	public void setCONTROL_BEAN(ControlBean control_bean) {
		CONTROL_BEAN = control_bean;
	}

	/*Added by Janani on 16.06.2018 for KIC as suggested by Sivaram's
*/	public String navigationEnabled() {
		setImmediate(true);
		return "";

	}
	
	private void setImmediate(boolean flag) {
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
			TabItem item = tabIterator.next();
			item.setImmediate(flag);

		}

	}
	/*End*/
	
	/*Added by Ameen on 01-08-2018 for KICLIFEQC-1760174 as per Ajay*/
	public String gotoPM_AGENT_PERC_RANGE(){
		String outcome = "agentPercRange";
		
		saveCurrentTab();
		
		return outcome;
	}
	
	private PM_AGENT_BONUS_PERC_RANGE_ACTION PM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN;

	public PM_AGENT_BONUS_PERC_RANGE_ACTION getPM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN() {
		return PM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN;
	}


	public void setPM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN(
			PM_AGENT_BONUS_PERC_RANGE_ACTION pM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN) {
		PM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN = pM_AGENT_BONUS_PERC_RANGE_ACTION_BEAN;
	}
	
	/*End*/
}
