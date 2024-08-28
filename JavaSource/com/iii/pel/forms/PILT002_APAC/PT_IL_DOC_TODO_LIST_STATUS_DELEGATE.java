package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DOC_TODO_LIST_STATUS_DELEGATE {
    public void executeSelectStatement(
	    PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	/*
	 * String selectStatement = " SELECT ROWID, PT_IL_DOC_TODO_LIST_STATUS.*
	 * FROM PT_IL_DOC_TODO_LIST_STATUS " + "WHERE DTLS_GROUP_CODE = ?";
	 */
    	/*
    	 * COMMENTED BY DHINESH ON 18-9-2017 CALL ID  : ZBILQC-1737294 POINT NO : 5
    	 * 
    	 * String selectStatement = " SELECT ROWID,PT_IL_DOC_TODO_LIST_STATUS.* FROM PT_IL_DOC_TODO_LIST_STATUS "
    			+ " WHERE PT_IL_DOC_TODO_LIST_STATUS.DTLS_POL_SYS_ID = ?  "
    			+ " AND  PT_IL_DOC_TODO_LIST_STATUS.DTLS_END_NO_IDX =?  AND DTLS_GROUP_CODE = ";
    	 *		
    	 */
	String selectStatement = " SELECT ROWID,PT_IL_DOC_TODO_LIST_STATUS.* FROM PT_IL_DOC_TODO_LIST_STATUS "
		+ " WHERE PT_IL_DOC_TODO_LIST_STATUS.DTLS_POL_SYS_ID = ?  "
		+ " AND  PT_IL_DOC_TODO_LIST_STATUS.DTLS_END_NO_IDX =?  AND DTLS_GROUP_CODE = ?  ORDER BY DTLS_SR_NO ASC ";
	Connection connection = null;
	ResultSet resultSet = null;
	compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
		.getDataList_PT_IL_DOC_TODO_LIST_STATUS().clear();

	PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	PM_IL_DOC_TODO_GROUP groupBean = compositeAction
		.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.getPM_IL_DOC_TODO_GROUP_BEAN();

	try {
	    connection = CommonUtils.getConnection();
	    PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN = null;
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection, new Object[] {
			    pt_il_policy_bean.getPOL_SYS_ID(),
			    pt_il_policy_bean.getPOL_END_NO_IDX(),
			    groupBean.getDTG_GROUP_CODE() });
	    while (resultSet.next()) {
		PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setROWID(resultSet
			.getString("ROWID"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SYS_ID(resultSet
			.getLong("DTLS_SYS_ID"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_POL_SYS_ID(resultSet
			.getLong("DTLS_POL_SYS_ID"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_END_NO_IDX(resultSet
			.getInt("DTLS_END_NO_IDX"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CLM_SYS_ID(resultSet
			.getLong("DTLS_CLM_SYS_ID"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SR_NO(resultSet
			.getDouble("DTLS_SR_NO"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN
			.setDTLS_TODO_LIST_ITEM(resultSet
				.getString("DTLS_TODO_LIST_ITEM"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_MANDATORY_YN(resultSet
			.getString("DTLS_MANDATORY_YN"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS(resultSet
			.getString("DTLS_APPR_STS"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_REMARKS(resultSet
			.getString("DTLS_REMARKS"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CR_DT(resultSet
			.getDate("DTLS_CR_DT"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CR_UID(resultSet
			.getString("DTLS_CR_UID"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_UPD_DT(resultSet
			.getDate("DTLS_UPD_DT"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_UPD_UID(resultSet
			.getString("DTLS_UPD_UID"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_GROUP_CODE(resultSet
			.getString("DTLS_GROUP_CODE"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_DOC_REC_DT(resultSet
			.getDate("DTLS_DOC_REC_DT"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SMV_SYS_ID(resultSet
			.getLong("DTLS_SMV_SYS_ID"));
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_WD_SYS_ID(resultSet
			.getLong("DTLS_WD_SYS_ID"));

		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
			.getDataList_PT_IL_DOC_TODO_LIST_STATUS().add(
				PT_IL_DOC_TODO_LIST_STATUS_BEAN);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }
    
  //added by saran
  	public void updatemandatoryflag(PILT002_APAC_COMPOSITE_ACTION compositeAction,String flag,String Todo ) throws Exception{

  		Connection connection = null;
  		connection = CommonUtils.getConnection();
  		CRUDHandler handler = new CRUDHandler();	
  		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
  		.getDataList_PT_IL_DOC_TODO_LIST_STATUS().clear();
  		PT_IL_POLICY pt_il_policy_bean = compositeAction
  				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
  		PM_IL_DOC_TODO_GROUP groupBean = compositeAction
  				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
  				.getPM_IL_DOC_TODO_GROUP_BEAN();

  	System.out.println("updatemandatoryflag   updatemandatoryflag   updatemandatoryflag   updatemandatoryflag");
  		
  		String query = "UPDATE PT_IL_DOC_TODO_LIST_STATUS SET DTLS_MANDATORY_YN='"+flag+"' WHERE DTLS_POL_SYS_ID= ? AND  DTLS_END_NO_IDX= ?  AND DTLS_TODO_LIST_ITEM = ? "; 

  		System.out.println();
  		System.out.println("pt_il_policy_bean.getPOL_SYS_ID()        :  "+pt_il_policy_bean.getPOL_SYS_ID());
  		System.out.println("pt_il_policy_bean.getPOL_END_NO_IDX()    :  "+pt_il_policy_bean.getPOL_END_NO_IDX());
  		System.out.println("                                Todo     :  "+Todo);
  		
  		new CRUDHandler().executeUpdateStatement(query, connection,new Object[] {
  				pt_il_policy_bean.getPOL_SYS_ID(),
  				pt_il_policy_bean.getPOL_END_NO_IDX(),Todo});
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
