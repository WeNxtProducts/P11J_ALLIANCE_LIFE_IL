package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_STATUS_2_HELPER {
	public void postInsert() {
	}

	/**
	 * 
	 */
	public void preInsert(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM_STATUS_2 PT_IL_CLAIM_STATUS_2_BEAN = compositeAction.getPT_IL_CLAIM_STATUS_2_ACTION_BEAN().getPT_IL_CLAIM_STATUS_2_BEAN();
		
		PT_IL_CLAIM_STATUS_2_BEAN.setCS_CR_UID(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID());
		PT_IL_CLAIM_STATUS_2_BEAN.setCS_CR_DT(new CommonUtils().getCurrentDate());
		PT_IL_CLAIM_STATUS_2_BEAN.setCS_TYPE("R");
		PT_IL_CLAIM_STATUS_2_BEAN.setCS_CLM_SYS_ID(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
	
		String C1 = "SELECT PIL_CS_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet C1_REC = null;
		try{
			CRUDHandler handler = new CRUDHandler();
			Connection connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection);
			if(C1_REC.next()){
				PT_IL_CLAIM_STATUS_2_BEAN.setCS_SYS_ID(C1_REC.getLong(1));
			}
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}

	public void preUpdate() {
	}

	public void preBlock() {
	}

	public void whenCreateRecord() {
	}

	public void whenNewRecordInstance() {
	}

	public void postQuery() {
	}

	public void preDelete() {
	}

	public void whenNewBlockInstance() {
	}

	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_CLAIM_STATUS_2_DELEGATE()
				.executeSelectStatement(compositeAction);

		java.util.List<PT_IL_CLAIM_STATUS_2> dataList = compositeAction
				.getPT_IL_CLAIM_STATUS_2_ACTION_BEAN()
				.getDataList_PT_IL_CLAIM_STATUS_2();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_CLAIM_STATUS_2 PT_IL_CLAIM_STATUS_2_BEAN = dataList.get(0);
			PT_IL_CLAIM_STATUS_2_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_CLAIM_STATUS_2_ACTION_BEAN()
					.setPT_IL_CLAIM_STATUS_2_BEAN(PT_IL_CLAIM_STATUS_2_BEAN);
		}
	}

}
