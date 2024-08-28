package com.iii.pel.forms.WORKFLOW;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PGIM_WF_WORKSTEP_MAPPING_DELEGATE {
	
	public void executeSelectStatement(
			WORKFLOW_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PGIM_WF_WORKSTEP_MAPPING.* FROM PGIM_WF_WORKSTEP_MAPPING "
				+ "WHERE PWWM_PWB_CODE = ? AND PWWM_WORKSTEP_ID= ? AND PWWM_PROCESS_ID= ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PGIM_WF_WORKSTEP_MAPPING PGIM_WF_WORKSTEP_MAPPING_BEAN = null;
		compositeAction.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().getDataTableList().clear();
		try {
			connection = CommonUtils.getConnection();
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {
							compositeAction
									.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN()
									.getPGIM_WORKFLOW_BUCKET_BEAN()
									.getPWB_CODE(),
							compositeAction
									.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN()
									.getPGIM_WORKFLOW_BUCKET_BEAN()
									.getPWB_WORKSTEP_ID(),
							compositeAction
									.getPGIM_WORKFLOW_BUCKET_ACTION_BEAN()
									.getPGIM_WORKFLOW_BUCKET_BEAN()
									.getPWB_MAIN_BUKT() });
			while (resultSet.next()) {
				PGIM_WF_WORKSTEP_MAPPING_BEAN = new PGIM_WF_WORKSTEP_MAPPING();
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setROWID(resultSet.getString("ROWID"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_PROCESS_ID(resultSet.getString("PWWM_PROCESS_ID"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_WORKSTEP_ID(resultSet.getString("PWWM_WORKSTEP_ID"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_RULE_ID(resultSet.getString("PWWM_RULE_ID"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_RULE_PARAM_ID(resultSet.getString("PWWM_RULE_PARAM_ID"));  
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_SQL_STMT(resultSet.getString("PWWM_SQL_STMT"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_TABLE_NAME(resultSet.getString("PWWM_TABLE_NAME"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_WHR_CLS1_FLD(resultSet.getString("PWWM_WHR_CLS1_FLD"));  
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_WHR_CLS2_FLD(resultSet.getString("PWWM_WHR_CLS2_FLD"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_WHR_CLS3_FLD(resultSet.getString("PWWM_WHR_CLS3_FLD"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_WHR_CLS4_FLD(resultSet.getString("PWWM_WHR_CLS4_FLD"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_WHR_CLS5_FLD(resultSet.getString("PWWM_WHR_CLS5_FLD"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_SQL_RETURN_TYPE(resultSet.getString("PWWM_SQL_RETURN_TYPE"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_CR_UID(resultSet.getString("PWWM_CR_UID"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_CR_DT(resultSet.getDate("PWWM_CR_DT"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_UPD_UID(resultSet.getString("PWWM_UPD_UID"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_UPD_DT(resultSet.getDate("PWWM_UPD_DT"));
				PGIM_WF_WORKSTEP_MAPPING_BEAN.setPWWM_PWB_CODE(resultSet.getString("PWWM_PWB_CODE"));  
				
				compositeAction.getPGIM_WF_WORKSTEP_MAPPING_ACTION_BEAN().getDataTableList().add(PGIM_WF_WORKSTEP_MAPPING_BEAN);
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
