package com.iii.pel.forms.PILT006_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.DBProcedures;



public class PT_IL_CLAIM_STATUS_1_DELEGATE {
	public void whenNewBlockInstance(PT_IL_CLAIM_STATUS_1_ACTION claimStatus1Action){
		// Execute Query will be performed separately
	}
	
	public void preQuery(PT_IL_CLAIM_STATUS_1_ACTION claimStatus1Action){
		// Will be considered directly in execute query
		//:PT_IL_CLAIM_STATUS_1.CS_CLM_SYS_ID := :PT_IL_CLAIM.CLAIM_SYS_ID;
	}
	
	public void postQuery(PT_IL_CLAIM_STATUS_1_ACTION status1Action) throws Exception{
		PT_IL_CLAIM_STATUS_1 status1Bean = null;
		Iterator<PT_IL_CLAIM_STATUS_1> iterator = null;
		ArrayList<String> resultList = null;
		String M_VALUE = null;
		
		try {
			iterator = status1Action.getDataList_PT_IL_CLAIM_STATUS_1().iterator();
			while(iterator.hasNext()){
				status1Bean = iterator.next();
				if(status1Bean.getCS_STATUS_CODE() != null){
					resultList = DBProcedures.P_VAL_SYSTEM("IL_ADDL_STAT", 
							status1Bean.getCS_STATUS_CODE(),status1Bean.getUI_M_CS_STATUS_CODE_DESC(), "N",
							M_VALUE);
					if(resultList.size() > 0){
						status1Bean.setUI_M_CS_STATUS_CODE_DESC(resultList.get(0));
						M_VALUE = resultList.get(1);
					}
				}
				
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		}
	}
}
