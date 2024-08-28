package com.iii.pel.forms.WORKFLOW;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PGIM_WORKFLOW_BUCKET_DELEGATE {
	
	public void executeSelectStatement(
			WORKFLOW_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PGIM_WORKFLOW_BUCKET.* FROM PGIM_WORKFLOW_BUCKET";
		Connection connection = null;
		ResultSet resultSet = null;
		PGIM_WORKFLOW_BUCKET PGIM_WORKFLOW_BUCKET_BEAN = null;
		compositeAction.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN().getDataTableList().clear();
		try {
			connection = CommonUtils.getConnection();
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PGIM_WORKFLOW_BUCKET_BEAN = new PGIM_WORKFLOW_BUCKET();
				/* Added by kavitha for RoadMap*/
				PGIM_WORKFLOW_BUCKET_BEAN.setROWID(resultSet.getString("ROWID"));
				/*End*/
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_CODE(resultSet.getString("PWB_CODE"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_MAIN_BUKT(resultSet.getString("PWB_MAIN_BUKT"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_WORKSTEP_ID(resultSet.getString("PWB_WORKSTEP_ID"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_DESC(resultSet.getString("PWB_DESC"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_SR_NO(resultSet.getLong("PWB_SR_NO"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_ENABLE_YN(resultSet.getString("PWB_ENABLE_YN"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_CR_UID(resultSet.getString("PWB_CR_UID"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_CR_DT(resultSet.getDate("PWB_CR_DT"));  
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_MAIL_ONLY_YN(resultSet.getString("PWB_MAIL_ONLY_YN"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_SMS_YN(resultSet.getString("PWB_SMS_YN"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_OUTCOME_DET(resultSet.getString("PWB_OUTCOME_DET"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_LIMIT_FROM(resultSet.getLong("PWB_LIMIT_FROM"));
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_LIMIT_TO(resultSet.getLong("PWB_LIMIT_TO"));
				//Added by kavitha on 01.11.2019 for Roadmap
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_TOBE_OUTCOME(resultSet.getString("PWB_TOBE_OUTCOME"));
				//Added by kavitha on 21.11.2019 for Roadmap
				PGIM_WORKFLOW_BUCKET_BEAN.setPWB_STATUS_CODE(resultSet.getString("PWB_STATUS_CODE"));
				 if(PGIM_WORKFLOW_BUCKET_BEAN.getPWB_STATUS_CODE()!=null)	{
	 				 String query = "SELECT PS_CODE_DESC FROM PP_SYSTEM1 WHERE PS_TYPE='IL_ADDL_STAT' AND PS_CODE= ? ";
	 				 ResultSet rs1 = new CRUDHandler().executeSelectStatement(
	 						 query, connection, new Object[] {PGIM_WORKFLOW_BUCKET_BEAN.getPWB_STATUS_CODE()});
	 				 if(rs1.next()){
	 					PGIM_WORKFLOW_BUCKET_BEAN.setUI_M_PWB_STATUS_CODE_DESC(rs1.getString("PS_CODE_DESC"));
	 				 }
	 			 }
				
				compositeAction.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN().getDataTableList().add(PGIM_WORKFLOW_BUCKET_BEAN);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
