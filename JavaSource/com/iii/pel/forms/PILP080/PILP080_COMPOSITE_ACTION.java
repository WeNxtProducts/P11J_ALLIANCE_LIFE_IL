package com.iii.pel.forms.PILP080;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;
public class PILP080_COMPOSITE_ACTION{
	public final static int TAB_PT_IL_PV_MED_HDR = 1;
	//public final static int TAB_PT_IL_POL_MED_EXAM_DTL = 2;
	//public final static int TAB_PT_IL_MEDEX_FEE_DTL = 3;
	//public final static int TAB_PT_IL_MED_VOUC_LOG = 4;
	//public final static int TAB_REPORT = 5;
	//public final static int TAB_IP_REP_INFO = 6;
	//public final static int TAB_CTRL = 7;
	//public final static int TAB_CONTROL = 8;
	//public final static int TAB_BP1 = 9;
	private TabbedBar tabbedBar ;
	private PT_IL_PV_MED_HDR_ACTION PT_IL_PV_MED_HDR_ACTION_BEAN ;
	private PT_IL_POL_MED_EXAM_DTL_ACTION PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN ;
	private PT_IL_MEDEX_FEE_DTL_ACTION PT_IL_MEDEX_FEE_DTL_ACTION_BEAN ;
	private PT_IL_MED_VOUC_LOG_ACTION PT_IL_MED_VOUC_LOG_ACTION_BEAN ;
	private REPORT_ACTION REPORT_ACTION_BEAN ;
	private IP_REP_INFO_ACTION IP_REP_INFO_ACTION_BEAN ;
	private CTRL_ACTION CTRL_ACTION_BEAN ;
	private CONTROL_ACTION CONTROL_ACTION_BEAN ;
	private BP1_ACTION BP1_ACTION_BEAN ;
	private DUMMY_ACTION DUMMY_ACTION_BEAN; 
	public String callPT_IL_PV_MED_HDR(){
		preTabClick();
		return "PILP080_PT_IL_PV_MED_HDR";
		
	}
	public String callPT_IL_POL_MED_EXAM_DTL(){
		preTabClick();
		return "PILP080_PT_IL_POL_MED_EXAM_DTL";
		
	}
	public String callDUMMY(){
		preTabClick();
		return "DUMMY";
		
	}
	public String callPT_IL_MEDEX_FEE_DTL(){
		preTabClick();
		return "PILP080_PT_IL_MEDEX_FEE_DTL";
		
	}
	public String callPT_IL_MED_VOUC_LOG(){
		preTabClick();
		return "PILP080_PT_IL_MED_VOUC_LOG";
		
	}
	public String callREPORT(){
		preTabClick();
		return "PILP080_REPORT";
		
	}
	public String callIP_REP_INFO(){
		preTabClick();
		return "PILP080_IP_REP_INFO";
		
	}
	public String callCTRL(){
		preTabClick();
		return "PILP080_CTRL";
		
	}
	public String callCONTROL(){
		preTabClick();
		return "PILP080_CONTROL";
		
	}
	public String callBP1(){
		preTabClick();
		return "PILP080_BP1";
		
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
			case 1 :PT_IL_PV_MED_HDR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 2 :PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 3 :PT_IL_MEDEX_FEE_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 4 :PT_IL_MED_VOUC_LOG_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 5 :REPORT_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 6 :IP_REP_INFO_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 7 :CTRL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 8 :CONTROL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
			case 9 :BP1_ACTION_BEAN.setBlockFlag(true);
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
	public void setPT_IL_PV_MED_HDR_ACTION_BEAN(PT_IL_PV_MED_HDR_ACTION PT_IL_PV_MED_HDR_ACTION_BEAN){
		this.PT_IL_PV_MED_HDR_ACTION_BEAN=PT_IL_PV_MED_HDR_ACTION_BEAN;
		
	}
	public PT_IL_PV_MED_HDR_ACTION getPT_IL_PV_MED_HDR_ACTION_BEAN(){
		return this.PT_IL_PV_MED_HDR_ACTION_BEAN;
		
	}
	public void setPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN(PT_IL_POL_MED_EXAM_DTL_ACTION PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN){
		this.PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN=PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN;
		
	}
	public PT_IL_POL_MED_EXAM_DTL_ACTION getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN(){
		return this.PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN;
		
	}
	public void setPT_IL_MEDEX_FEE_DTL_ACTION_BEAN(PT_IL_MEDEX_FEE_DTL_ACTION PT_IL_MEDEX_FEE_DTL_ACTION_BEAN){
		this.PT_IL_MEDEX_FEE_DTL_ACTION_BEAN=PT_IL_MEDEX_FEE_DTL_ACTION_BEAN;
		
	}
	public PT_IL_MEDEX_FEE_DTL_ACTION getPT_IL_MEDEX_FEE_DTL_ACTION_BEAN(){
		return this.PT_IL_MEDEX_FEE_DTL_ACTION_BEAN;
		
	}
	public void setPT_IL_MED_VOUC_LOG_ACTION_BEAN(PT_IL_MED_VOUC_LOG_ACTION PT_IL_MED_VOUC_LOG_ACTION_BEAN){
		this.PT_IL_MED_VOUC_LOG_ACTION_BEAN=PT_IL_MED_VOUC_LOG_ACTION_BEAN;
		
	}
	public PT_IL_MED_VOUC_LOG_ACTION getPT_IL_MED_VOUC_LOG_ACTION_BEAN(){
		return this.PT_IL_MED_VOUC_LOG_ACTION_BEAN;
		
	}
	public void setREPORT_ACTION_BEAN(REPORT_ACTION REPORT_ACTION_BEAN){
		this.REPORT_ACTION_BEAN=REPORT_ACTION_BEAN;
		
	}
	public REPORT_ACTION getREPORT_ACTION_BEAN(){
		return this.REPORT_ACTION_BEAN;
		
	}
	public void setIP_REP_INFO_ACTION_BEAN(IP_REP_INFO_ACTION IP_REP_INFO_ACTION_BEAN){
		this.IP_REP_INFO_ACTION_BEAN=IP_REP_INFO_ACTION_BEAN;
		
	}
	public IP_REP_INFO_ACTION getIP_REP_INFO_ACTION_BEAN(){
		return this.IP_REP_INFO_ACTION_BEAN;
		
	}
	public void setCTRL_ACTION_BEAN(CTRL_ACTION CTRL_ACTION_BEAN){
		this.CTRL_ACTION_BEAN=CTRL_ACTION_BEAN;
		
	}
	public CTRL_ACTION getCTRL_ACTION_BEAN(){
		return this.CTRL_ACTION_BEAN;
		
	}
	public void setCONTROL_ACTION_BEAN(CONTROL_ACTION CONTROL_ACTION_BEAN){
		this.CONTROL_ACTION_BEAN=CONTROL_ACTION_BEAN;
		
	}
	public CONTROL_ACTION getCONTROL_ACTION_BEAN(){
		return this.CONTROL_ACTION_BEAN;
		
	}
	public void setBP1_ACTION_BEAN(BP1_ACTION BP1_ACTION_BEAN){
		this.BP1_ACTION_BEAN=BP1_ACTION_BEAN;
		
	}
	public BP1_ACTION getBP1_ACTION_BEAN(){
		return this.BP1_ACTION_BEAN;
		
	}
	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return this.DUMMY_ACTION_BEAN;
	}
	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}
	
	public PILP080_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PT_IL_PV_MED_HDR_ACTION_BEAN = new PT_IL_PV_MED_HDR_ACTION();
		PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN = new PT_IL_POL_MED_EXAM_DTL_ACTION();
		PT_IL_MEDEX_FEE_DTL_ACTION_BEAN = new PT_IL_MEDEX_FEE_DTL_ACTION();
		PT_IL_MED_VOUC_LOG_ACTION_BEAN = new PT_IL_MED_VOUC_LOG_ACTION();
		REPORT_ACTION_BEAN = new REPORT_ACTION();
		IP_REP_INFO_ACTION_BEAN = new IP_REP_INFO_ACTION();
		CTRL_ACTION_BEAN = new CTRL_ACTION();
		CONTROL_ACTION_BEAN = new CONTROL_ACTION();
		BP1_ACTION_BEAN = new BP1_ACTION();
		DUMMY_ACTION_BEAN=new DUMMY_ACTION();
		PT_IL_PV_MED_HDR_ACTION_BEAN.compositeAction = this;
		PT_IL_POL_MED_EXAM_DTL_ACTION_BEAN.compositeAction = this;
		PT_IL_MEDEX_FEE_DTL_ACTION_BEAN.compositeAction = this;
		PT_IL_MED_VOUC_LOG_ACTION_BEAN.compositeAction = this;
		REPORT_ACTION_BEAN.compositeAction = this;
		IP_REP_INFO_ACTION_BEAN.compositeAction = this;
		CTRL_ACTION_BEAN.compositeAction = this;
		CONTROL_ACTION_BEAN.compositeAction = this;
		BP1_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction=this;
		try{
			tabbedBar.addTab(TAB_PT_IL_PV_MED_HDR, "#{PILP080_COMPOSITE_ACTION.callPT_IL_PV_MED_HDR}", Messages.getString("messageProperties_PILP080", "PILP080$PT_IL_PV_MED_HDR$displayCaption"), false);
		//	tabbedBar.addTab(TAB_PT_IL_MEDEX_FEE_DTL, "#{PILP080_COMPOSITE_ACTION.callPT_IL_MEDEX_FEE_DTL}", Messages.getString("messageProperties_PILP080", "PILP080$PT_IL_MEDEX_FEE_DTL$displayCaption"), false);
		//	tabbedBar.addTab(TAB_PT_IL_MED_VOUC_LOG, "#{PILP080_COMPOSITE_ACTION.callPT_IL_MED_VOUC_LOG}", Messages.getString("messageProperties_PILP080", "PILP080$PT_IL_MED_VOUC_LOG$displayCaption"), false);
			//tabbedBar.addTab(TAB_REPORT, "#{PILP080_COMPOSITE_ACTION.callREPORT}", Messages.getString("messageProperties_PILP080", "PILP080$REPORT$displayCaption"), false);
		//	tabbedBar.addTab(TAB_IP_REP_INFO, "#{PILP080_COMPOSITE_ACTION.callIP_REP_INFO}", Messages.getString("messageProperties_PILP080", "PILP080$IP_REP_INFO$displayCaption"), false);
		//	tabbedBar.addTab(TAB_CTRL, "#{PILP080_COMPOSITE_ACTION.callCTRL}", Messages.getString("messageProperties_PILP080", "PILP080$CTRL$displayCaption"), false);
		//	tabbedBar.addTab(TAB_CONTROL, "#{PILP080_COMPOSITE_ACTION.callCONTROL}", Messages.getString("messageProperties_PILP080", "PILP080$CONTROL$displayCaption"), false);
		//	tabbedBar.addTab(TAB_BP1, "#{PILP080_COMPOSITE_ACTION.callBP1}", Messages.getString("messageProperties_PILP080", "PILP080$BP1$displayCaption"), false);
			
		}
		catch(Exception exc){
			// TODO Auto generated catch block;
			exc.printStackTrace();
			
		}
		
	}
	
}
