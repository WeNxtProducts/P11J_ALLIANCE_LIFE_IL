package com.iii.pel.forms.WORKFLOW;

import java.util.List;

import com.iii.premia.common.utils.CommonUtils;

public class PGIM_WF_WORKSTEP_MAPPING_HELPER{
	
	public void executeQuery(WORKFLOW_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PGIM_WF_WORKSTEP_MAPPING_DELEGATE()
		.executeSelectStatement(compositeAction);

		List<PGIM_WF_WORKSTEP_MAPPING> dataList = compositeAction
				.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().getDataTableList();
		if (dataList != null && dataList.size() > 0) {
			PGIM_WF_WORKSTEP_MAPPING PGIM_WF_WORKSTEP_MAPPING_BEAN = dataList.get(0);
			PGIM_WF_WORKSTEP_MAPPING_BEAN.setRowSelected(true);
			compositeAction.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().setPGIM_WF_WORKSTEP_MAPPING_BEAN(PGIM_WF_WORKSTEP_MAPPING_BEAN);
			compositeAction.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().resetAllComponent();
		}
	}


	
	
	
	/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
	public void whenNewCreateInstance(WORKFLOW_COMPOSITE_ACTION compositeAction)throws Exception{
		
		compositeAction.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().getPGIM_WF_WORKSTEP_MAPPING_BEAN().setPWWM_CR_DT(new CommonUtils().getCurrentDate());	
		compositeAction.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().getPGIM_WF_WORKSTEP_MAPPING_BEAN().setPWWM_PWB_CODE(compositeAction
				.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN()
				.getPGIM_WORKFLOW_BUCKET_BEAN()
				.getPWB_CODE());
		compositeAction.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().getPGIM_WF_WORKSTEP_MAPPING_BEAN().setPWWM_WORKSTEP_ID(compositeAction
				.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN()
				.getPGIM_WORKFLOW_BUCKET_BEAN()
				.getPWB_WORKSTEP_ID());
		compositeAction.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().getPGIM_WF_WORKSTEP_MAPPING_BEAN().setPWWM_PROCESS_ID(compositeAction
				.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN()
				.getPGIM_WORKFLOW_BUCKET_BEAN()
				.getPWB_MAIN_BUKT());


	}	
	/*end*/
	
}
