package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_HELPER {
	public void preInsert() {
	}

	public void postInsert() {
	}

	public void preUpdate() {
	}

	public void preBlock() {
	}

	public void whenCreateRecord() {
	}

	public void whenNewRecordInstance() {
	}
	
	/**
	 * 
	 * @param PM_IL_DOC_TODO_GROUP_BEAN
	 */
	public void postQuery(PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN) throws Exception{
		String C1 = "	SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE ='IL_TODO_GRP' AND PS_CODE = ? ";
		ResultSet C1_REC = null;
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{PM_IL_DOC_TODO_GROUP_BEAN.getDTG_GROUP_TYPE()});
			if(C1_REC.next()){
				PM_IL_DOC_TODO_GROUP_BEAN.setUI_M_DTG_GROUP_CODE_DESC(C1_REC.getString(1));
			}
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}
	
	/**
	 * 
	 */
	public void onPopulateDetails(){
		
	}

	public void preDelete(String DTG_GROUP_CODE) throws Exception{
		String C1 = "DELETE FROM PT_IL_DOC_TODO_LIST_STATUS WHERE P.DTLS_GROUP_CODE = ?";
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			int deleteFlag = handler.executeDeleteStatement(C1, connection,new Object[]{DTG_GROUP_CODE});
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}
	}
	
	/**
	 * 
	 */
	public void whenNewBlockInstance(PILT006_APAC_COMPOSITE_ACTION compositeAction) {
		if(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()!=null){
			/*IF :SYSTEM.FORM_STATUS = 'CHANGED' OR :SYSTEM.BLOCK_STATUS = 'CHANGED' THEN
			 COPY('P','CTRL.M_COMM_DEL') ;
		   COPY('20','SYSTEM.MESSAGE_LEVEL');
		   POST;                   
		   COPY('','CTRL.M_COMM_DEL') ;
		   :PT_IL_CLAIM.CLAIM_REMARKS := :PT_IL_CLAIM.CLAIM_REMARKS;   
		   COPY('0','SYSTEM.MESSAGE_LEVEL');  
		END IF;
		EXECUTE_QUERY;
		END IF;*/
			compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().setUI_M_COMM_DEL("P");
		}
		
	}

	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_DOC_TODO_GROUP_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_DOC_TODO_GROUP> dataList = compositeAction
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getDataList_PM_IL_DOC_TODO_GROUP();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN = dataList.get(0);
			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
					.setPM_IL_DOC_TODO_GROUP_BEAN(PM_IL_DOC_TODO_GROUP_BEAN);
		}
	}
}
