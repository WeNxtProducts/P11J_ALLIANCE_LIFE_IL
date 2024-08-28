package com.iii.pel.forms.PILM003_APAC;
import java.awt.Composite;

import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;
import com.iii.pel.forms.PILM055_APAC.CompositeAction;
public class PILM003_APAC_COMPOSITE_ACTION{
	public final static int TAB_PM_IL_PLAN = 1;
	public final static int TAB_PM_IL_RED_SA = 2;
	public final static int TAB_PM_IL_SURR_PAID_FACTOR = 3;
	public final static int TAB_PM_IL_PLAN_MOP = 4;
	public final static int TAB_PM_IL_PLAN_AGE_SETUP = 5;
	public final static int TAB_PM_IL_PLAN_MAT_AGESETUP = 6;
	public final static int TAB_COPY_PLAN = 7;
	public final static int TAB_CTRL = 8;
	public final static int TAB_BP = 9;
	public final static int TAB_BP_BL = 10;
	//private TabbedBar tabbedBar ;
	private PM_IL_PLAN_ACTION PM_IL_PLAN_ACTION_BEAN ;
	private PM_IL_RED_SA_ACTION PM_IL_RED_SA_ACTION_BEAN ;
	private PM_IL_SURR_PAID_FACTOR_ACTION PM_IL_SURR_PAID_FACTOR_ACTION_BEAN ;
	private PM_IL_PLAN_MOP_ACTION PM_IL_PLAN_MOP_ACTION_BEAN ;
	/*added by gopi for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit COMMENTS on 30/12/16*/
	private PM_IL_PLAN_MEMBERS_ACTION PM_IL_PLAN_MEMBERS_ACTION_BEAN ;
	
	public PM_IL_PLAN_MEMBERS_ACTION getPM_IL_PLAN_MEMBERS_ACTION_BEAN() {
		return PM_IL_PLAN_MEMBERS_ACTION_BEAN;
	}
	public void setPM_IL_PLAN_MEMBERS_ACTION_BEAN(
			PM_IL_PLAN_MEMBERS_ACTION pM_IL_PLAN_MEMBERS_ACTION_BEAN) {
		PM_IL_PLAN_MEMBERS_ACTION_BEAN = pM_IL_PLAN_MEMBERS_ACTION_BEAN;
	}
	/*end*/
	private PM_IL_PLAN_AGE_SETUP_ACTION PM_IL_PLAN_AGE_SETUP_ACTION_BEAN ;
	private PM_IL_PLAN_MAT_AGESETUP_ACTION PM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN ;
	private COPY_PLAN_ACTION COPY_PLAN_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private BP_ACTION BP_ACTION_BEAN ;
	private BP_BL_ACTION BP_BL_ACTION_BEAN ;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	UIWizard wizard ;
	public UIWizard getWizard() {
		return wizard;
	}
	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
	}
	public String callPM_IL_PLAN(){
		//preTabClick();
		return "PILM003_APAC_PM_IL_PLAN";
		
	}
	public String callPM_IL_RED_SA(){
		//preTabClick();
		return "PILM003_APAC_PM_IL_RED_SA";
		
	}
	public String callPM_IL_SURR_PAID_FACTOR(){
		//preTabClick();
		return "PILM003_APAC_PM_IL_SURR_PAID_FACTOR";
		
	}
	public String callPM_IL_PLAN_MOP(){
		//preTabClick();
		return "PILM003_APAC_PM_IL_PLAN_MOP";
		
	}
	/*added by gopi for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit COMMENTS on 30/12/16*/
	public String callPM_IL_PLAN_MEMBERS(){
		//preTabClick();
		getPM_IL_PLAN_MEMBERS_ACTION_BEAN().setBlockFlag(true);
		return "PILM003_APAC_PM_IL_PLAN_MEMBERS";
		}
	/*END*/
	
	public String callPM_IL_PLAN_AGE_SETUP(){
		//preTabClick();
		return "PILM003_APAC_PM_IL_PLAN_AGE_SETUP";
		
	}
	public String callPM_IL_PLAN_MAT_AGESETUP(){
		//preTabClick();
		return "PILM003_APAC_PM_IL_PLAN_MAT_AGESETUP";
		
	}
	public String callCOPY_PLAN(){
		//preTabClick();
		return "PILM003_APAC_COPY_PLAN";
		
	}
	
	public String navigationEnabled(){
		//setImmediate(true);
		/*added by gopi on 04/01/16*/
		PM_IL_PLAN_MEMBERS_ACTION_BEAN.setBlockFlag(true);
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
	/*private void preTabClick(){
		int currentTabId = tabbedBar.getCurrentTabId();
		switch(currentTabId){
			case 1 :PM_IL_PLAN_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :PM_IL_RED_SA_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :PM_IL_SURR_PAID_FACTOR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :PM_IL_PLAN_MOP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 5 :PM_IL_PLAN_AGE_SETUP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 6 :PM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			
			
		}
		
	}*/
	/*public void setTabbedBar(TabbedBar tabbedBar){
		this.tabbedBar=tabbedBar;
		
	}
	public TabbedBar getTabbedBar(){
		return this.tabbedBar;
		
	}*/
	public void setPM_IL_PLAN_ACTION_BEAN(PM_IL_PLAN_ACTION PM_IL_PLAN_ACTION_BEAN){
		this.PM_IL_PLAN_ACTION_BEAN=PM_IL_PLAN_ACTION_BEAN;
		
	}
	public PM_IL_PLAN_ACTION getPM_IL_PLAN_ACTION_BEAN(){
		return this.PM_IL_PLAN_ACTION_BEAN;
		
	}
	public void setPM_IL_RED_SA_ACTION_BEAN(PM_IL_RED_SA_ACTION PM_IL_RED_SA_ACTION_BEAN){
		this.PM_IL_RED_SA_ACTION_BEAN=PM_IL_RED_SA_ACTION_BEAN;
		
	}
	public PM_IL_RED_SA_ACTION getPM_IL_RED_SA_ACTION_BEAN(){
		return this.PM_IL_RED_SA_ACTION_BEAN;
		
	}
	public void setPM_IL_SURR_PAID_FACTOR_ACTION_BEAN(PM_IL_SURR_PAID_FACTOR_ACTION PM_IL_SURR_PAID_FACTOR_ACTION_BEAN){
		this.PM_IL_SURR_PAID_FACTOR_ACTION_BEAN=PM_IL_SURR_PAID_FACTOR_ACTION_BEAN;
		
	}
	public PM_IL_SURR_PAID_FACTOR_ACTION getPM_IL_SURR_PAID_FACTOR_ACTION_BEAN(){
		return this.PM_IL_SURR_PAID_FACTOR_ACTION_BEAN;
		
	}
	public void setPM_IL_PLAN_MOP_ACTION_BEAN(PM_IL_PLAN_MOP_ACTION PM_IL_PLAN_MOP_ACTION_BEAN){
		this.PM_IL_PLAN_MOP_ACTION_BEAN=PM_IL_PLAN_MOP_ACTION_BEAN;
		
	}
	public PM_IL_PLAN_MOP_ACTION getPM_IL_PLAN_MOP_ACTION_BEAN(){
		return this.PM_IL_PLAN_MOP_ACTION_BEAN;
		
	}
	public void setPM_IL_PLAN_AGE_SETUP_ACTION_BEAN(PM_IL_PLAN_AGE_SETUP_ACTION PM_IL_PLAN_AGE_SETUP_ACTION_BEAN){
		this.PM_IL_PLAN_AGE_SETUP_ACTION_BEAN=PM_IL_PLAN_AGE_SETUP_ACTION_BEAN;
		
	}
	public PM_IL_PLAN_AGE_SETUP_ACTION getPM_IL_PLAN_AGE_SETUP_ACTION_BEAN(){
		return this.PM_IL_PLAN_AGE_SETUP_ACTION_BEAN;
		
	}
	public void setPM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN(PM_IL_PLAN_MAT_AGESETUP_ACTION PM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN){
		this.PM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN=PM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN;
		
	}
	public PM_IL_PLAN_MAT_AGESETUP_ACTION getPM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN(){
		return this.PM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN;
		
	}
	public void setCOPY_PLAN_ACTION_BEAN(COPY_PLAN_ACTION COPY_PLAN_ACTION_BEAN){
		this.COPY_PLAN_ACTION_BEAN=COPY_PLAN_ACTION_BEAN;
		
	}
	public COPY_PLAN_ACTION getCOPY_PLAN_ACTION_BEAN(){
		return this.COPY_PLAN_ACTION_BEAN;
		
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
	public void setBP_BL_ACTION_BEAN(BP_BL_ACTION BP_BL_ACTION_BEAN){
		this.BP_BL_ACTION_BEAN=BP_BL_ACTION_BEAN;
		
	}
	public BP_BL_ACTION getBP_BL_ACTION_BEAN(){
		return this.BP_BL_ACTION_BEAN;
		
	}
	public PILM003_APAC_COMPOSITE_ACTION(){
	//	tabbedBar = new TabbedBar();
		PM_IL_PLAN_ACTION_BEAN = new PM_IL_PLAN_ACTION();
		PM_IL_RED_SA_ACTION_BEAN = new PM_IL_RED_SA_ACTION();
		PM_IL_SURR_PAID_FACTOR_ACTION_BEAN = new PM_IL_SURR_PAID_FACTOR_ACTION();
		PM_IL_PLAN_MOP_ACTION_BEAN = new PM_IL_PLAN_MOP_ACTION();
		/*added by gopi for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit COMMENTS on 30/12/16*/
		PM_IL_PLAN_MEMBERS_ACTION_BEAN = new PM_IL_PLAN_MEMBERS_ACTION();
		/*end*/
		PM_IL_PLAN_AGE_SETUP_ACTION_BEAN = new PM_IL_PLAN_AGE_SETUP_ACTION();
		PM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN = new PM_IL_PLAN_MAT_AGESETUP_ACTION();
		COPY_PLAN_ACTION_BEAN = new COPY_PLAN_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		BP_ACTION_BEAN = new BP_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		BP_BL_ACTION_BEAN = new BP_BL_ACTION();
		PM_IL_PLAN_ACTION_BEAN.compositeAction = this;
		PM_IL_RED_SA_ACTION_BEAN.compositeAction = this;
		PM_IL_SURR_PAID_FACTOR_ACTION_BEAN.compositeAction = this;
		PM_IL_PLAN_MOP_ACTION_BEAN.compositeAction = this;
		/*added by gopi for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit COMMENTS on 30/12/16*/
		PM_IL_PLAN_MEMBERS_ACTION_BEAN.compositeAction = this;
		/*end*/
		PM_IL_PLAN_AGE_SETUP_ACTION_BEAN.compositeAction = this;
		PM_IL_PLAN_MAT_AGESETUP_ACTION_BEAN.compositeAction = this;
		COPY_PLAN_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		BP_BL_ACTION_BEAN.compositeAction = this;
		/*try{
			tabbedBar.addTab(TAB_PM_IL_PLAN, "#{PILM003_APAC_COMPOSITE_ACTION.callPM_IL_PLAN}", Messages.getString("messageProperties_PILM003_APAC", "PILM003_APAC$PM_IL_PLAN$displayCaption"), false);
			tabbedBar.addTab(TAB_PM_IL_RED_SA, "#{PILM003_APAC_COMPOSITE_ACTION.callPM_IL_RED_SA}", Messages.getString("messageProperties_PILM003_APAC", "PILM003_APAC$PM_IL_RED_SA$displayCaption"), false);
			tabbedBar.addTab(TAB_PM_IL_SURR_PAID_FACTOR, "#{PILM003_APAC_COMPOSITE_ACTION.callPM_IL_SURR_PAID_FACTOR}", Messages.getString("messageProperties_PILM003_APAC", "PILM003_APAC$PM_IL_SURR_PAID_FACTOR$displayCaption"), false);
			tabbedBar.addTab(TAB_PM_IL_PLAN_MOP, "#{PILM003_APAC_COMPOSITE_ACTION.callPM_IL_PLAN_MOP}", Messages.getString("messageProperties_PILM003_APAC", "PILM003_APAC$PM_IL_PLAN_MOP$displayCaption"), false);
			tabbedBar.addTab(TAB_PM_IL_PLAN_AGE_SETUP, "#{PILM003_APAC_COMPOSITE_ACTION.callPM_IL_PLAN_AGE_SETUP}", Messages.getString("messageProperties_PILM003_APAC", "PILM003_APAC$PM_IL_PLAN_AGE_SETUP$displayCaption"), false);
			tabbedBar.addTab(TAB_PM_IL_PLAN_MAT_AGESETUP, "#{PILM003_APAC_COMPOSITE_ACTION.callPM_IL_PLAN_MAT_AGESETUP}", Messages.getString("messageProperties_PILM003_APAC", "PILM003_APAC$PM_IL_PLAN_MAT_AGESETUP$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}*/
		
	}
	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}
	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}
	
}
