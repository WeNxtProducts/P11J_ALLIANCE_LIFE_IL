package com.iii.pel.forms.PILT084;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_OCD_DOC_TODO_LIST_DELEGATE {
    public void executeSelectStatement(
	    PILT084_COMPOSITE_ACTION_BEAN compositeAction) throws Exception {

	/*String selectStatement = " SELECT ROWID,PT_IL_OCD_DOC_TODO_LIST.* FROM PT_IL_OCD_DOC_TODO_LIST "
		+ " WHERE PT_IL_OCD_DOC_TODO_LIST.OCD_DTL_POL_SYS_ID = ?  "
		+ " AND  PT_IL_OCD_DOC_TODO_LIST.OCD_DTL_END_NO_IDX =?  AND DTL_GROUP_CODE = ?  ORDER BY DTL_SR_NO ASC ";*/
    	String selectStatement = " SELECT ROWID,PT_IL_OCD_DOC_TODO_LIST.* FROM PT_IL_OCD_DOC_TODO_LIST "
    			+ " WHERE PT_IL_OCD_DOC_TODO_LIST.OCD_DTL_POL_SYS_ID = ?  "
    			+ " AND OCD_DTL_GROUP_CODE = ?  ORDER BY OCD_DTL_SR_NO ASC ";
	Connection connection = null;
	ResultSet resultSet = null;
	compositeAction.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN()
		.getDataList_PT_IL_OCD_DOC_TODO_LIST().clear();

	PT_IL_PAYOUT_PROCESS pt_il_payout_process_bean = compositeAction
		.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN();
	PM_IL_DOC_TODO_GROUP groupBean = compositeAction
		.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.getPM_IL_DOC_TODO_GROUP_BEAN();

	try {
	    connection = CommonUtils.getConnection();
	    PT_IL_OCD_DOC_TODO_LIST PT_IL_OCD_DOC_TODO_LIST_BEAN = null;
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection, new Object[] {
		    		CommonUtils.getGlobalObject("OCD_POL_SYS_ID").toString(),
		    		CommonUtils.getGlobalObject("OCD_TRANS_SYS_ID").toString(),
			    groupBean.getDTG_GROUP_CODE() });
	    while (resultSet.next()) {
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN = new PT_IL_OCD_DOC_TODO_LIST();
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setROWID(resultSet
			.getString("ROWID"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_SYS_ID(resultSet
			.getLong("OCD_DTL_SYS_ID"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_POL_SYS_ID(resultSet
			.getLong("OCD_DTL_POL_SYS_ID"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_END_NO_IDX(resultSet
			.getInt("OCD_DTL_END_NO_IDX"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_CLM_SYS_ID(resultSet
			.getLong("OCD_DTL_CLM_SYS_ID"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_SR_NO(resultSet
			.getDouble("OCD_DTL_SR_NO"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN
			.setOCD_DTL_TODO_LIST_ITEM(resultSet
				.getString("OCD_DTL_TODO_LIST_ITEM"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_MANDATORY_YN(resultSet
			.getString("OCD_DTL_MANDATORY_YN"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_APPR_STS(resultSet
			.getString("OCD_DTL_APPR_STS"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_REMARKS(resultSet
			.getString("OCD_DTL_REMARKS"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_CR_DT(resultSet
			.getDate("OCD_DTL_CR_DT"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_CR_UID(resultSet
			.getString("OCD_DTL_CR_UID"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_UPD_DT(resultSet
			.getDate("OCD_DTL_UPD_DT"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_UPD_UID(resultSet
			.getString("OCD_DTL_UPD_UID"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_GROUP_CODE(resultSet
			.getString("OCD_DTL_GROUP_CODE"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_DOC_REC_DT(resultSet
			.getDate("OCD_DTL_DOC_REC_DT"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_SMV_SYS_ID(resultSet
			.getLong("OCD_DTL_SMV_SYS_ID"));
	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_WD_SYS_ID(resultSet
			.getLong("OCD_DTL_WD_SYS_ID"));

		compositeAction.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN()
			.getDataList_PT_IL_OCD_DOC_TODO_LIST().add(
					PT_IL_OCD_DOC_TODO_LIST_BEAN);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }
    
  //added by saran
  	public void updatemandatoryflag(PILT084_COMPOSITE_ACTION_BEAN compositeAction,String flag,String Todo ) throws Exception{

  		Connection connection = null;
  		connection = CommonUtils.getConnection();
  		CRUDHandler handler = new CRUDHandler();	
  		compositeAction.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN();
  		PT_IL_PAYOUT_PROCESS pt_il_payout_process_bean = compositeAction
		.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN();
  		PM_IL_DOC_TODO_GROUP groupBean = compositeAction
  				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
  				.getPM_IL_DOC_TODO_GROUP_BEAN();

  		/*String query = "UPDATE PT_IL_OCD_DOC_TODO_LIST SET DTL_MANDATORY_YN='"+flag+"' WHERE OCD_DTL_POL_SYS_ID= ? AND  DTL_END_NO_IDX= ?  AND DTL_TODO_LIST_ITEM = ? ";*/
  		String query = "UPDATE PT_IL_OCD_DOC_TODO_LIST SET DTL_MANDATORY_YN='"+flag+"' WHERE OCD_DTL_POL_SYS_ID= ?  AND OCD_DTL_TODO_LIST_ITEM = ? ";

  		new CRUDHandler().executeUpdateStatement(query, connection,new Object[] {
  				pt_il_payout_process_bean.getPP_POL_SYS_ID(),
  				pt_il_payout_process_bean.getPP_TRANS_SYS_ID(),Todo});
  		connection.commit();
  	}

  	public  String selectbmivalue(String query,String code)throws Exception{

  		Connection connection = null;
  		connection = CommonUtils.getConnection();
  		ResultSet resultSet = null;
  		String Psvalue=null;
  		CRUDHandler handler = new CRUDHandler();			 
       
  		resultSet = new CRUDHandler().executeSelectStatement(query, connection,new Object[] {code});
  		while (resultSet.next()) {
  			Psvalue=resultSet.getString("PS_VALUE");
  		}
  		return Psvalue;
  	}
  	//end
  	
  	public  String selectassuredvalue(String query,String pol_sys_id,String AssuredCode)throws Exception{

  		Connection connection = null;
  		connection = CommonUtils.getConnection();
  		ResultSet resultSet = null;
  		String Assuredvalue=null;
  		CRUDHandler handler = new CRUDHandler();			 
       
  		resultSet = new CRUDHandler().executeSelectStatement(query, connection,new Object[] {pol_sys_id,AssuredCode});
  		while (resultSet.next()) {
  			Assuredvalue=resultSet.getString("poad_assured_name");
  		}
  		return Assuredvalue;
  	}
  	

}
