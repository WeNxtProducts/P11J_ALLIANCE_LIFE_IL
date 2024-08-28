package com.iii.pel.forms.PILQ111_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ111_APAC_COMPOSITE_ACTION extends CommonAction{
	
	private PT_IL_RI_ALLOC_ACTION PT_IL_RI_ALLOC_ACTION_BEAN;
	
	private PT_IL_RI_PART_CUST_ALLOC_ACTION PT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN;
	
	private PILQ111_APAC_SEARCH_ACTION PILQ111_APAC_SEARCH_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	
	private ControlBean controlBean;

	public PT_IL_RI_ALLOC_ACTION getPT_IL_RI_ALLOC_ACTION_BEAN() {
		return PT_IL_RI_ALLOC_ACTION_BEAN;
	}

	public void setPT_IL_RI_ALLOC_ACTION_BEAN(
			PT_IL_RI_ALLOC_ACTION pt_il_ri_alloc_action_bean) {
		PT_IL_RI_ALLOC_ACTION_BEAN = pt_il_ri_alloc_action_bean;
	}

	public PT_IL_RI_PART_CUST_ALLOC_ACTION getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN() {
		return PT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN;
	}

	public void setPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN(
			PT_IL_RI_PART_CUST_ALLOC_ACTION pt_il_ri_part_cust_alloc_action_bean) {
		PT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN = pt_il_ri_part_cust_alloc_action_bean;
	}

	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}

	public PILQ111_APAC_COMPOSITE_ACTION(){
		
		PT_IL_RI_ALLOC_ACTION_BEAN = new PT_IL_RI_ALLOC_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		PT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN = new PT_IL_RI_PART_CUST_ALLOC_ACTION();
		controlBean = (ControlBean) CommonUtils.getControlBean().clone();
		PILQ111_APAC_SEARCH_ACTION_BEAN = new PILQ111_APAC_SEARCH_ACTION();
		try {
		    PT_IL_RI_ALLOC_ACTION_BEAN.compositeAction =this;
		    PT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN.compositeAction =this;
		    DUMMY_ACTION_BEAN.compositeAction =this;
		    
		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		}
		
	}

	public PILQ111_APAC_SEARCH_ACTION getPILQ111_APAC_SEARCH_ACTION_BEAN() {
		return PILQ111_APAC_SEARCH_ACTION_BEAN;
	}

	public void setPILQ111_APAC_SEARCH_ACTION_BEAN(
			PILQ111_APAC_SEARCH_ACTION pilq111_apac_search_action_bean) {
		PILQ111_APAC_SEARCH_ACTION_BEAN = pilq111_apac_search_action_bean;
	}
	
}
