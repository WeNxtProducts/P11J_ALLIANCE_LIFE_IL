package com.iii.pel.forms.PM092_A;

import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;



public class PM092_A_COMPOSITE_ACTION {

	private PM_AGENT_CONTEST_APPL_RANK_ACTION PM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN;
	
	private PM_AGENT_CONTEST_AWARD_ACTION PM_AGENT_CONTEST_AWARD_ACTION_BEAN;
	
	private PM_AGENT_CONTEST_DTL_ACTION PM_AGENT_CONTEST_DTL_ACTION_BEAN;
	
	private PM_AGENT_CONTEST_HDR_ACTION PM_AGENT_CONTEST_HDR_ACTION_BEAN;
	
	private TabbedBar tabbedBar;

	public PM092_A_COMPOSITE_ACTION() {
		this.tabbedBar=new TabbedBar();
		this.PM_AGENT_CONTEST_AWARD_ACTION_BEAN=new PM_AGENT_CONTEST_AWARD_ACTION();
		this.PM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN=new PM_AGENT_CONTEST_APPL_RANK_ACTION();
		this.PM_AGENT_CONTEST_DTL_ACTION_BEAN=new PM_AGENT_CONTEST_DTL_ACTION();
		this.PM_AGENT_CONTEST_HDR_ACTION_BEAN=new PM_AGENT_CONTEST_HDR_ACTION();
		
		this.PM_AGENT_CONTEST_AWARD_ACTION_BEAN.compositeAction = this;
		this.PM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN.compositeAction = this;
		this.PM_AGENT_CONTEST_DTL_ACTION_BEAN.compositeAction = this;
		this.PM_AGENT_CONTEST_HDR_ACTION_BEAN.compositeAction = this;
		try {
			this.tabbedBar.addTab(1, "#{PM092_A_COMPOSITE_ACTION.goToPM_AGENT_CONTEST_HDR}", "Contests", false);
			this.tabbedBar.addTab(2, "#{PM092_A_COMPOSITE_ACTION.goToPM_AGENT_CONTEST_DTL}", "Contest Requirements", false);
			this.tabbedBar.addTab(3, "#{PM092_A_COMPOSITE_ACTION.goToPM_AGENT_CONTEST_APPL_RANK}", "Applicable Ranks", false);
			this.tabbedBar.addTab(4, "#{PM092_A_COMPOSITE_ACTION.goToPM_AGENT_CONTEST_AWARD}", "Applicable Awards", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PM_AGENT_CONTEST_APPL_RANK_ACTION getPM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN() {
		return PM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN;
	}

	public void setPM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN(
			PM_AGENT_CONTEST_APPL_RANK_ACTION pm_agent_contest_appl_rank_action_bean) {
		PM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN = pm_agent_contest_appl_rank_action_bean;
	}

	public PM_AGENT_CONTEST_AWARD_ACTION getPM_AGENT_CONTEST_AWARD_ACTION_BEAN() {
		return PM_AGENT_CONTEST_AWARD_ACTION_BEAN;
	}

	public void setPM_AGENT_CONTEST_AWARD_ACTION_BEAN(
			PM_AGENT_CONTEST_AWARD_ACTION pm_agent_contest_award_action_bean) {
		PM_AGENT_CONTEST_AWARD_ACTION_BEAN = pm_agent_contest_award_action_bean;
	}

	public PM_AGENT_CONTEST_DTL_ACTION getPM_AGENT_CONTEST_DTL_ACTION_BEAN() {
		return PM_AGENT_CONTEST_DTL_ACTION_BEAN;
	}

	public void setPM_AGENT_CONTEST_DTL_ACTION_BEAN(
			PM_AGENT_CONTEST_DTL_ACTION pm_agent_contest_dtl_action_bean) {
		PM_AGENT_CONTEST_DTL_ACTION_BEAN = pm_agent_contest_dtl_action_bean;
	}

	public PM_AGENT_CONTEST_HDR_ACTION getPM_AGENT_CONTEST_HDR_ACTION_BEAN() {
		return PM_AGENT_CONTEST_HDR_ACTION_BEAN;
	}

	public void setPM_AGENT_CONTEST_HDR_ACTION_BEAN(
			PM_AGENT_CONTEST_HDR_ACTION pm_agent_contest_hdr_action_bean) {
		PM_AGENT_CONTEST_HDR_ACTION_BEAN = pm_agent_contest_hdr_action_bean;
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}
	
	public String goToPM_AGENT_CONTEST_DTL(){
		String returnString="GO_TO_PM092_A_PM_AGENT_CONTEST_DTL";
		//When Create Record Code--Varun[50663]
		this.PM_AGENT_CONTEST_DTL_ACTION_BEAN.getPM_AGENT_CONTEST_DTL_BEAN().setACD_PROD_TYPE("P");
		this.PM_AGENT_CONTEST_DTL_ACTION_BEAN.getPM_AGENT_CONTEST_DTL_BEAN().setACD_FYC_TYPE("PK");
		//-**//
		this.PM_AGENT_CONTEST_HDR_ACTION_BEAN.populateBlockPM_AGENT_CONTEST_DTL();
		return returnString;
	}
	
	public String goToPM_AGENT_CONTEST_AWARD(){
		String returnString="GO_TO_PM092_A_PM_AGENT_CONTEST_AWARD";
		this.PM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN.populateBlockPM_AGENT_CONTEST_AWARD();
		return returnString;
	}
	
	public String goToPM_AGENT_CONTEST_APPL_RANK(){
		String returnString="GO_TO_PM092_A_PM_AGENT_CONTEST_APPL_RANK";
		
		this.PM_AGENT_CONTEST_DTL_ACTION_BEAN.populateBlockPM_AGENT_CONTEST_APPL_RANK();
		return returnString;
	}
	
	public String goToPM_AGENT_CONTEST_HDR(){
		String returnString="GO_TO_PM092_A_PM_AGENT_CONTEST_HDR";
		return returnString;
	}
}
