package com.iii.pel.forms.PILT020;

import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.utils.CommonUtils;

public class PILT020_COMPOSITE_ACTION extends CommonAction{
	
	
	DUMMY_ACTION DUMMY_ACTION_BEAN; 
	DUMMY1_ACTION DUMMY1_ACTION_BEAN ;
	PT_IL_BROKER_VALUES_ACTION PT_IL_BROKER_VALUES_ACTION_BEAN;
	PT_IL_LOAN_INT_COLL_ACTION PT_IL_LOAN_INT_COLL_ACTION_BEAN;
	PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN;
	PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN;
	PT_IL_PREM_COLL_CHARGE_ACTION PT_IL_PREM_COLL_CHARGE_ACTION_BEAN;
	PT_IL_PYMT_DTLS_ACTION PT_IL_PYMT_DTLS_ACTION_BEAN;
	
	private TabbedBar tabbedBar;
	
	public PILT020_COMPOSITE_ACTION()throws Exception  //PILT020_COMPOSITE_ACTION.PT_IL_PREM_COLL_CHARGE_ACTION
	{
		this.tabbedBar=new TabbedBar();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		DUMMY1_ACTION_BEAN= new DUMMY1_ACTION();
		PT_IL_BROKER_VALUES_ACTION_BEAN = new PT_IL_BROKER_VALUES_ACTION();
		PT_IL_LOAN_INT_COLL_ACTION_BEAN = new PT_IL_LOAN_INT_COLL_ACTION();
		PT_IL_POLICY_ACTION_BEAN = new PT_IL_POLICY_ACTION();
		PT_IL_PREM_COLL_ACTION_BEAN  = new PT_IL_PREM_COLL_ACTION();
		PT_IL_PREM_COLL_CHARGE_ACTION_BEAN = new PT_IL_PREM_COLL_CHARGE_ACTION();
		PT_IL_PYMT_DTLS_ACTION_BEAN = new PT_IL_PYMT_DTLS_ACTION();
		PT_IL_LOAN_INT_COLL_ACTION_BEAN.compositeactiom=this;
		DUMMY1_ACTION_BEAN.COMPOSITE_BEAN=this;
		
		
		
		try {
			this.tabbedBar.addTab(1, "PILT020_DUMMY1_NAVIGATOR", "Payment Details", false);
			this.tabbedBar.addTab(2, "PT_TL_PREM_COLL", "PT_IL_PREM_COLL", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}	
public String page_PT_IL_LOAN_INT_COLL_NAVIGATOR() {
	try{	
		
		PT_IL_LOAN_INT_COLL_HELPER helper = new PT_IL_LOAN_INT_COLL_HELPER();
		//helper.trig_when_new_block_instance_pt_il_loan_coll();
		DUMMY_ACTION_BEAN.pt_il_loan_populate_details();
	}catch (Exception e) {
		e.printStackTrace();
	}
	return "PT_IL_LOAN_INT_COLL_NAVIGATOR";
	}
	//PILT020_DUMMY1_NAVIGATOR
   public String page_PILT020_DUMMY1_NAVIGATOR() {
		return "PILT020_DUMMY1_NAVIGATOR";
	}
   //PT_IL_BROKER_VALUES_NAVIGATOR
   public String page_PILT020_PT_IL_BROKER_VALUES_NAVIGATOR() {
		PT_IL_BROKER_VALUES_HELPER helper = new PT_IL_BROKER_VALUES_HELPER();
		String test = DUMMY1_ACTION_BEAN.navigate_to_Broker_Values();
		helper.trig_pre_query_pt_il_broker_values();
		return test;
	}
   //PT_TL_CHARGE_SETUP
   public String page_PT_TL_CHARGE_SETUP()throws Exception {
		PT_IL_PREM_COLL_CHARGE_HELPER helper = new PT_IL_PREM_COLL_CHARGE_HELPER();
		String PT_TL_CHARGE_SETUP = DUMMY1_ACTION_BEAN.navigate_to_Charges(); 
		//helper.trig_post_query_pt_il_prem_coll_charge();
		return PT_TL_CHARGE_SETUP;
	}
 //PT_TL_PREM_COLL
   public String page_PT_TL_PREM_COLL() {
		return "PT_TL_PREM_COLL";
	}
   //Details
   public String page_Navigate_to_Details() {
		return "Details";
	}
   //REINSTATEMENT_NAVIGATOR
   public String page_REINSTATEMENT_NAVIGATOR() {
		return "REINSTATEMENT_NAVIGATOR";
	}
   // WHEN_FACOUT_BUT_PRESSED
   public String whenFACButtonPressed()throws Exception{
		CRUDHandler handler = new CRUDHandler();
		//Map<String, Object> map = getSessionMap();
		//map.put("GLOBAL.M_PC_SYS_ID", (String)map.get("DUMMY.M_PC_SYS_ID"));	
		ResultSet rs=null;
		PT_IL_PREM_COLL premBean = DUMMY_ACTION_BEAN.getPT_IL_PREM_COLL_BEAN();
		String C1 = "select POL_SYS_ID from pt_il_policy where POL_NO = '"+premBean.getUI_M_PC_POL_NO()+"'"; 
		rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
		while(rs.next()){
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", rs.getInt("POL_SYS_ID")+"");
		}
		//CommonUtils.setGlobalVariable("GLOBAL.M_PC_SYS_ID", "1190");
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", premBean.getUI_M_PC_POL_NO());
		//map.put("GLOBAL.M_POL_NO", (String)getCOMP_RD_POL_NO().getSubmittedValue());
		//System.out.println("PT_IL_RI_DETL_ACTION.whenFACButtonPressed() ------------------\n SESSION [ "+map.toString() +"\n] -------------");
//		:GLOBAL.M_POL_NO  := NVL(:PT_IL_RI_DETL.RD_POL_NO,:PT_IL_RI_DETL_1.RD_POL_NO);
//		CALL_FORM('PILT009',NO_HIDE,NO_REPLACE); 
		
		return "fac";
	}
 // End of WHEN_FACOUT_BUT_PRESSED
public TabbedBar getTabbedBar() {
	return tabbedBar;
}
public void setTabbedBar(TabbedBar tabbedBar) {
	this.tabbedBar = tabbedBar;
}
public DUMMY1_ACTION getDUMMY1_ACTION_BEAN() {
	return DUMMY1_ACTION_BEAN;
}
public void setDUMMY1_ACTION_BEAN(DUMMY1_ACTION dummy1_action_bean) {
	DUMMY1_ACTION_BEAN = dummy1_action_bean;
}
public PT_IL_BROKER_VALUES_ACTION getPT_IL_BROKER_VALUES_ACTION_BEAN() {
	return PT_IL_BROKER_VALUES_ACTION_BEAN;
}
public void setPT_IL_BROKER_VALUES_ACTION_BEAN(
		PT_IL_BROKER_VALUES_ACTION pt_il_broker_values_action_bean) {
	PT_IL_BROKER_VALUES_ACTION_BEAN = pt_il_broker_values_action_bean;
}
public PT_IL_LOAN_INT_COLL_ACTION getPT_IL_LOAN_INT_COLL_ACTION_BEAN() {
	return PT_IL_LOAN_INT_COLL_ACTION_BEAN;
}
public void setPT_IL_LOAN_INT_COLL_ACTION_BEAN(
		PT_IL_LOAN_INT_COLL_ACTION pt_il_loan_int_coll_action_bean) {
	PT_IL_LOAN_INT_COLL_ACTION_BEAN = pt_il_loan_int_coll_action_bean;
}
public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION_BEAN() {
	return PT_IL_POLICY_ACTION_BEAN;
}
public void setPT_IL_POLICY_ACTION_BEAN(
		PT_IL_POLICY_ACTION pt_il_policy_action_bean) {
	PT_IL_POLICY_ACTION_BEAN = pt_il_policy_action_bean;
}
public PT_IL_PREM_COLL_ACTION getPT_IL_PREM_COLL_ACTION_BEAN() {
	return PT_IL_PREM_COLL_ACTION_BEAN;
}
public void setPT_IL_PREM_COLL_ACTION_BEAN(
		PT_IL_PREM_COLL_ACTION pt_il_prem_coll_action_bean) {
	PT_IL_PREM_COLL_ACTION_BEAN = pt_il_prem_coll_action_bean;
}
public PT_IL_PREM_COLL_CHARGE_ACTION getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN() {
	return PT_IL_PREM_COLL_CHARGE_ACTION_BEAN;
}
public void setPT_IL_PREM_COLL_CHARGE_ACTION_BEAN(
		PT_IL_PREM_COLL_CHARGE_ACTION pt_il_prem_coll_charge_action_bean) {
	PT_IL_PREM_COLL_CHARGE_ACTION_BEAN = pt_il_prem_coll_charge_action_bean;
}
public PT_IL_PYMT_DTLS_ACTION getPT_IL_PYMT_DTLS_ACTION_BEAN() {
	return PT_IL_PYMT_DTLS_ACTION_BEAN;
}
public void setPT_IL_PYMT_DTLS_ACTION_BEAN(
		PT_IL_PYMT_DTLS_ACTION pt_il_pymt_dtls_action_bean) {
	PT_IL_PYMT_DTLS_ACTION_BEAN = pt_il_pymt_dtls_action_bean;
}
public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
	return DUMMY_ACTION_BEAN;
}
public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
	DUMMY_ACTION_BEAN = dummy_action_bean;
}
}
