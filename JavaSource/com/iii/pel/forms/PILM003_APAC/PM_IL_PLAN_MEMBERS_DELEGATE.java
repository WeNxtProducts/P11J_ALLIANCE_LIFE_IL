package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PLAN_MEMBERS_DELEGATE {
	public void executeSelectStatement(
			PILM003_APAC_COMPOSITE_ACTION PILM003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PLAN_MEMB.* FROM PM_IL_PLAN_MEMB WHERE PM_IL_PLAN_MEMB.PMEM_PLAN_CODE = ? ORDER BY PMEM_RELATION_TYPE";
		Connection connection = null;
		ResultSet resultSet = null;
		PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_MEMBERS_ACTION_BEAN().getDataList_PM_IL_PLAN_MEMBERS().clear();
		String depDescQry = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_DEP_TYP' AND PC_CODE = ?";
		ResultSet depDescRS = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{
							PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_ACTION_BEAN()
							.getPM_IL_PLAN_BEAN().getPLAN_CODE()});
			while (resultSet.next()) {
				PM_IL_PLAN_MEMBERS PM_IL_PLAN_MEMBERS_BEAN = new PM_IL_PLAN_MEMBERS();
				PM_IL_PLAN_MEMBERS_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_PLAN_CODE(resultSet
						.getString("PMEM_PLAN_CODE"));
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_NO_OF_LIFE(resultSet
						.getInt("PMEM_NO_OF_LIFE"));
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_MIN_SA(resultSet
						.getDouble("PMEM_MIN_SA"));
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_MAX_SA(resultSet
						.getDouble("PMEM_MAX_SA"));
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_MAX_AGE_ENTRY(resultSet
						.getInt("PMEM_MAX_AGE_ENTRY"));
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_CR_DT(resultSet.getDate("PMEM_CR_DT"));
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_CR_UID(resultSet
						.getString("PMEM_CR_UID"));
				PM_IL_PLAN_MEMBERS_BEAN
						.setPMEM_UPD_DT(resultSet.getDate("PMEM_UPD_DT"));
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_UPD_UID(resultSet
						.getString("PMEM_UPD_UID"));
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_RELATION_TYPE(resultSet
						.getString("PMEM_RELATION_TYPE"));
				/*Added by sankara narayanan on 21/04/2017 for hospital cash plan*/
				PM_IL_PLAN_MEMBERS_BEAN.setPMEN_NO_OF_DAYS(resultSet
						.getInt("PMEN_NO_OF_DAYS"));
			/*	end*/
				/*Added by Ameen on 11-07-2017 for ZBILQC-1731204 */
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_DEP_TYPE(resultSet
						.getString("PMEM_DEP_TYPE"));
				depDescRS =  new CRUDHandler().executeSelectStatement(depDescQry, connection, 
							new Object[]{PM_IL_PLAN_MEMBERS_BEAN.getPMEM_DEP_TYPE()});
				if(depDescRS.next()){
					PM_IL_PLAN_MEMBERS_BEAN.setPMEM_DEP_TYPE_DESC(depDescRS
							.getString("PC_DESC"));
				}
				/*end*/
				
				/*added by raja on 18-07-2017 for ZBILQC-1731514*/
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_MIN_COVER_AGE(resultSet
						.getInt("PMEM_MIN_COVER_AGE"));
				
				/*end*/
				
				/*added by raja on 24-07-2017 for  ZBILQC-1732855*/
				
				PM_IL_PLAN_MEMBERS_BEAN.setPMEM_MIN_AGE_ENTRY(resultSet
						.getInt("PMEM_MIN_AGE_ENTRY"));
				/*end*/
				
				PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_MEMBERS_ACTION_BEAN().getDataList_PM_IL_PLAN_MEMBERS()
				.add(PM_IL_PLAN_MEMBERS_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	
}
