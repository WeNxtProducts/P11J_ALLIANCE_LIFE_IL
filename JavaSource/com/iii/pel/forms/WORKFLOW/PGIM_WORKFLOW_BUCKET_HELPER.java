package com.iii.pel.forms.WORKFLOW;

import java.util.List;

import com.iii.premia.common.utils.CommonUtils;

public class PGIM_WORKFLOW_BUCKET_HELPER{
	
	public void executeQuery(WORKFLOW_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PGIM_WORKFLOW_BUCKET_DELEGATE()
		.executeSelectStatement(compositeAction);

		List<PGIM_WORKFLOW_BUCKET> dataList = compositeAction
				.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN().getDataTableList();
		if (dataList != null && dataList.size() > 0) {
			PGIM_WORKFLOW_BUCKET PGIM_WORKFLOW_BUCKET_BEAN = dataList.get(0);
			PGIM_WORKFLOW_BUCKET_BEAN.setRowSelected(true);
			compositeAction.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN().setPGIM_WORKFLOW_BUCKET_BEAN(PGIM_WORKFLOW_BUCKET_BEAN);
			
		}
	}


	/*public void preinsert(PGIM_WORKFLOW_BUCKET_ACTION PM_BANK_ACTION_BEAN,PGIM_WORKFLOW_BUCKET PM_BANK_BEAN)
	{
		try
		{
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			System.out.println("Company Code  == > "+(session.get("GLOBAL.M_COMP_CODE")).toString());
			PM_BANK_BEAN.setBANK_CLIENT_ID((session.get("GLOBAL.M_COMP_CODE")).toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	
	
	/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
	public void whenNewCreateInstance(WORKFLOW_COMPOSITE_ACTION compositeAction)throws Exception{
		
		compositeAction.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN().getPGIM_WORKFLOW_BUCKET_BEAN().setPWB_CR_DT(new CommonUtils().getCurrentDate());		
		
	}	
	/*end*/
	
}
