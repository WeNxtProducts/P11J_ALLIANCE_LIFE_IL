package com.iii.pel.forms.WORKFLOW;

import java.util.List;

import com.iii.premia.common.utils.CommonUtils;

public class PGIM_WF_MAIL_USGRP_HELPER {

	public void executeQuery(WORKFLOW_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PGIM_WF_MAIL_USGRP_DELEGATE()
		.executeSelectStatement(compositeAction);

		List<PGIM_WF_MAIL_USGRP> dataList = compositeAction
				.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().getDataTableList();
		if (dataList != null && dataList.size() > 0) {
			PGIM_WF_MAIL_USGRP PGIM_WF_MAIL_USGRP_BEAN = dataList.get(0);
			PGIM_WF_MAIL_USGRP_BEAN.setRowSelected(true);
			compositeAction.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().setPGIM_WF_MAIL_USGRP_BEAN(PGIM_WF_MAIL_USGRP_BEAN);
			compositeAction.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().resetAllComponent();
			
		}else
		{
			//compositeAction.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().setPGIM_WF_MAIL_USGRP_BEAN(null);
			compositeAction.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().resetAllComponent();
			compositeAction.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().getPGIM_WF_MAIL_USGRP_BEAN().setPWMU_PWB_BUKT_CODE(compositeAction
					.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN()
					.getPGIM_WORKFLOW_BUCKET_BEAN()
					.getPWB_CODE());
			System.out.println(" BUCKET CODE"+compositeAction
					.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN()
					.getPGIM_WORKFLOW_BUCKET_BEAN()
					.getPWB_CODE());
			
		}
	}
	
	public void whenNewCreateInstance(WORKFLOW_COMPOSITE_ACTION compositeAction)throws Exception{
		
		compositeAction.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().getPGIM_WF_MAIL_USGRP_BEAN().setPWMU_CR_DT(new CommonUtils().getCurrentDate());	
		compositeAction.getPGIM_WF_MAIL_USGRP_ACTION_BEAN().getPGIM_WF_MAIL_USGRP_BEAN().setPWMU_PWB_BUKT_CODE(compositeAction
				.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN()
				.getPGIM_WORKFLOW_BUCKET_BEAN()
				.getPWB_CODE());	
		
	}
	
}
