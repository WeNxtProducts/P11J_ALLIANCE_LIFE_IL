package com.iii.pel.forms.PILM013_APAC;

import javax.faces.validator.ValidatorException;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_NO_RANGE_HELPER extends CommonAction{

	CommonUtils commonUtils;
	String bundleName = PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH;
	
	public void DNR_CURR_NO_WHEN_VALIDATE_ITEM(int currNo,PM_IL_DOC_NO_RANGE_ACTION pm_il_doc_no_range_action,PM_IL_DOC_NO_RANGE pm_il_doc_no_range)
	{
		/*int rowIndex  = pm_il_doc_no_range_action.getDataTable().getRowIndex();
		PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE)pm_il_doc_no_range_action.getDataTableList().get(rowIndex);*/
		if(pm_il_doc_no_range.getDNR_FIRST_NO()!=-1 && pm_il_doc_no_range.getDNR_LAST_NO()!=-1)
		{
			int firstNo = pm_il_doc_no_range.getDNR_FIRST_NO();
			int lastNo = pm_il_doc_no_range.getDNR_LAST_NO();
		 if(!(currNo >=firstNo && currNo <= lastNo))
         {
			 throw new ValidatorException(Messages.getMessage(bundleName,"11907"));
         }
		}else{
			// [ Commented for grid implementation change, Added by: Varun Dayal Mathur, Dated: 13-Feb-2009 
			
			//pm_il_doc_no_range_action.gridtabListener();
			
			// Commented for grid implementation change, Added by: Varun Dayal Mathur, Dated: 13-Feb-2009 ]
		}
		pm_il_doc_no_range.setDNR_CURR_NO(currNo);
	}
	
	
	public void DNR_LAST_NO_WHEN_VALIDATE_ITEM(int lastNo,PM_IL_DOC_NO_RANGE_ACTION pm_il_doc_no_range_action, PM_IL_DOC_NO_RANGE pm_il_doc_no_range)
	{
		/*int rowIndex  = pm_il_doc_no_range_action.getDataTable().getRowIndex();
		PM_IL_DOC_NO_RANGE pm_il_doc_no_range = (PM_IL_DOC_NO_RANGE)pm_il_doc_no_range_action.getDataTableList().get(rowIndex);*/
		pm_il_doc_no_range.setDNR_LAST_NO(lastNo);
		if(pm_il_doc_no_range.getDNR_CURR_NO() != null){
			if(pm_il_doc_no_range.getDNR_CURR_NO()!=-1)
			{
				DNR_CURR_NO_WHEN_VALIDATE_ITEM(pm_il_doc_no_range.getDNR_CURR_NO(),pm_il_doc_no_range_action,pm_il_doc_no_range);
			}			
		}
		
		if(pm_il_doc_no_range.getDNR_FIRST_NO() != null){
			if(pm_il_doc_no_range.getDNR_FIRST_NO()!=-1)
			{
				if(lastNo<pm_il_doc_no_range.getDNR_FIRST_NO())
				{
					throw new ValidatorException(Messages.getMessage(bundleName,"11906"));
				}else{
					// [ Commented for grid implementation change, Added by: Varun Dayal Mathur, Dated: 13-Feb-2009 

					
					//pm_il_doc_no_range_action.gridtabListener();
					
					// Commented for grid implementation change, Added by: Varun Dayal Mathur, Dated: 13-Feb-2009 ]
				}
			}			
		}
	}
	
	public void L_CHECK_RANGE(PM_IL_DOC_NO_RANGE pm_il_doc_no_range)
	{
		
		PM_IL_DOC_NO_SETUP pm_il_doc_no_setup = (PM_IL_DOC_NO_SETUP) getSessionValue().getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getPM_IL_DOC_NO_SETUP_BEAN();
		if(!pm_il_doc_no_setup.getDNS_LEVEL_1().equals("001") && !pm_il_doc_no_setup.getDNS_L1_ATTACH_YN().equals("Y"))
		{
			if(pm_il_doc_no_range.getDNR_LEVEL_1()==null)
			{
				getErrorMap().put("current", Messages.getMessage(bundleName,"91025").getDetail());
				getErrorMap().put("some", Messages.getMessage(bundleName,"91025").getDetail());
				//throw new ValidatorException(Messages.getMessage(bundleName,"91025"));
			}
			
		}else if(!pm_il_doc_no_setup.getDNS_LEVEL_2().equals("001") && !pm_il_doc_no_setup.getDNS_L2_ATTACH_YN().equals("Y"))
		{
			if(pm_il_doc_no_range.getDNR_LEVEL_2()==null)
			{
				getErrorMap().put("current", Messages.getMessage(bundleName,"91025").getDetail());
				getErrorMap().put("some", Messages.getMessage(bundleName,"91025").getDetail());
				//throw new ValidatorException(Messages.getMessage(bundleName,"91025"));
			}
			
		}else if(!pm_il_doc_no_setup.getDNS_LEVEL_3().equals("001") && !pm_il_doc_no_setup.getDNS_L3_ATTACH_YN().equals("Y"))
		{
			if(pm_il_doc_no_range.getDNR_LEVEL_3()==null)
			{
				getErrorMap().put("current", Messages.getMessage(bundleName,"91025").getDetail());
				getErrorMap().put("some", Messages.getMessage(bundleName,"91025").getDetail());
				//throw new ValidatorException(Messages.getMessage(bundleName,"91025"));
			}
			
		}else if(!pm_il_doc_no_setup.getDNS_LEVEL_4().equals("001") && !pm_il_doc_no_setup.getDNS_L4_ATTACH_YN().equals("Y"))
		{
			if(pm_il_doc_no_range.getDNR_LEVEL_4()==null)
			{
				getErrorMap().put("current", Messages.getMessage(bundleName,"91025").getDetail());
				getErrorMap().put("some", Messages.getMessage(bundleName,"91025").getDetail());
				//throw new ValidatorException(Messages.getMessage(bundleName,"91025"));
			}
			
		}else if(!pm_il_doc_no_setup.getDNS_LEVEL_5().equals("001") && !pm_il_doc_no_setup.getDNS_L5_ATTACH_YN().equals("Y"))
		{
			if(pm_il_doc_no_range.getDNR_LEVEL_5()==null)
			{
				getErrorMap().put("current", Messages.getMessage(bundleName,"91025").getDetail());
				getErrorMap().put("some", Messages.getMessage(bundleName,"91025").getDetail());
				//throw new ValidatorException(Messages.getMessage(bundleName,"91025"));
			}
			
		}
		
	}
	
	
	 public PM_IL_DOC_SETUP_COMPOSITE_ACTION getSessionValue()
		{
			commonUtils = new CommonUtils();
			PM_IL_DOC_SETUP_COMPOSITE_ACTION actionBean = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
			if(actionBean == null)
			{
				return null;
			}else{
				PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION)commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
				return pm_il_doc_setup_composite_action;
				
			}
		}
}
