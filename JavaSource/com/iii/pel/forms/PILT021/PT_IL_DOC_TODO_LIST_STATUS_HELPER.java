package com.iii.pel.forms.PILT021;

import java.sql.ResultSet;
import java.text.ParseException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_DOC_TODO_LIST_STATUS_HELPER {
	CommonUtils commonUtils = new CommonUtils();

	public void executeQuery(PILT021_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_DOC_TODO_LIST_STATUS> dataList = compositeAction.
		getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getDataList_PT_IL_DOC_TODO_LIST_STATUS();
		if(dataList!=null && dataList.size() > 0){
			PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN = dataList.get(0);
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
			.setPT_IL_DOC_TODO_LIST_STATUS_BEAN(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
		}
	}
	public void WHEN_NEW_BLOCK_INSTANCE(){
//		IF :SYSTEM.FORM_STATUS = 'CHANGED' OR :SYSTEM.BLOCK_STATUS = 'CHANGED'THEN
//		COPY('P','CTRL.M_COMM_DEL') ;
//		COPY('20','SYSTEM.MESSAGE_LEVEL');
//		POST;                  
//		COPY('0','SYSTEM.MESSAGE_LEVEL');
//		COPY('','CTRL.M_COMM_DEL') ;
//		END IF;
//		COPY('20','SYSTEM.MESSAGE_LEVEL');
//		EXECUTE_QUERY; 
//		COPY('0','SYSTEM.MESSAGE_LEVEL');
	}
	/*modified by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
/*	public void KEY_DELREC(String DTLS_MANDATORY_YN) throws Exception{
		if("Y".equals(CommonUtils.nvl(DTLS_MANDATORY_YN, "N"))){*/
	public void KEY_DELREC(PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN,CTRL CTRL_BEAN) throws Exception{
		if("Y".equalsIgnoreCase(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_MANDATORY_YN())){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206", 
					new Object[]{"Mandatory Records cannot be deleted"}));
		}else{
			//KEY_DELREC;
		}
	}
	public void WHEN_VALIDATE_DTLS_APPR_STS(String DTLS_APPR_STS, 
			/*added by raja on 12-07-2017 for ZBILQC-1731237*/
			PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action,PILT021_COMPOSITE_ACTION compositeAction) throws Exception{
		/*end*/
		PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status = new PT_IL_DOC_TODO_LIST_STATUS();
		try {
			String pord_code=null;
			if("N".equals(DTLS_APPR_STS))
			{
				String Query="SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO=?";		
				ResultSet rst=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{
					compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getUI_M_POL_NO()
				});
				while(rst.next())
				
				{
					pord_code=rst.getString("POL_PROD_CODE");
				}
				
				/*Commentted by saritha on 27-07-2017 for as per gaurav suggestted*/ 
				/*if(pord_code!=null && (pord_code.equalsIgnoreCase("171") || pord_code.equalsIgnoreCase("205")))
				{
			if(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_FULL_YN()!=null &&
					compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_FULL_YN().equalsIgnoreCase("Y"))
			{
				throw new Exception("Full withdrawal is not applicable for non illness cases");
			}
			}*/

				/*End*/
				
			}
			if("Y".equals(DTLS_APPR_STS)){
				pt_il_doc_todo_list_status.setDTLS_DOC_REC_DT(commonUtils.getCurrentDate());
				pt_il_doc_todo_list_status_action.getCOMP_DTLS_DOC_REC_DT().setDisabled(false);
			}else if("N".equals(DTLS_APPR_STS)){
				pt_il_doc_todo_list_status.setDTLS_DOC_REC_DT(null);
				pt_il_doc_todo_list_status_action.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
			}else if("NA".equals(DTLS_APPR_STS)){
				pt_il_doc_todo_list_status.setDTLS_DOC_REC_DT(null);
				pt_il_doc_todo_list_status_action.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
			}
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}
	/*added by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/

	public void whenCreateRecord(PILT021_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS listStatusBean = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
															.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		try{
		listStatusBean.setDTLS_MANDATORY_YN("N");
		listStatusBean.setDTLS_APPR_STS("N");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	//end
		
}
