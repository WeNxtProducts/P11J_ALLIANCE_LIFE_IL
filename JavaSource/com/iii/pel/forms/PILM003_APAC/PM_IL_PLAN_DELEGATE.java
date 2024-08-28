package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PLAN_DELEGATE {
	public void executeSelectStatement(
			PILM003_APAC_COMPOSITE_ACTION PILM003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_IL_PLAN.* FROM PM_IL_PLAN WHERE ROWID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{
							PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_ACTION_BEAN()
							.getPM_IL_PLAN_BEAN().getROWID()});
			PM_IL_PLAN PM_IL_PLAN_BEAN = new PM_IL_PLAN();
			while (resultSet.next()) {
				PM_IL_PLAN_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_PLAN_BEAN.setPLAN_CODE(resultSet.getString("PLAN_CODE"));
				PM_IL_PLAN_BEAN.setPLAN_TYPE(resultSet.getString("PLAN_TYPE"));
				PM_IL_PLAN_BEAN.setPLAN_PERIOD_FROM(resultSet
						.getInt("PLAN_PERIOD_FROM"));
				PM_IL_PLAN_BEAN.setPLAN_PERIOD_TO(resultSet
						.getInt("PLAN_PERIOD_TO"));
				PM_IL_PLAN_BEAN.setPLAN_AGE_FROM(resultSet
						.getInt("PLAN_AGE_FROM"));
				PM_IL_PLAN_BEAN.setPLAN_AGE_TO(resultSet
						.getInt("PLAN_AGE_TO"));
				PM_IL_PLAN_BEAN.setPLAN_LOAN_YN(resultSet
						.getString("PLAN_LOAN_YN"));
				PM_IL_PLAN_BEAN.setPLAN_FACIN_YN(resultSet
						.getString("PLAN_FACIN_YN"));
				PM_IL_PLAN_BEAN.setPLAN_PYMT_ON_MAT_YN(resultSet
						.getString("PLAN_PYMT_ON_MAT_YN"));
				PM_IL_PLAN_BEAN.setPLAN_SA_INST_PYMT_YN(resultSet
						.getString("PLAN_SA_INST_PYMT_YN"));
				PM_IL_PLAN_BEAN.setPLAN_REBATE_YN(resultSet
						.getString("PLAN_REBATE_YN"));
				PM_IL_PLAN_BEAN.setPLAN_SURR_YN(resultSet
						.getString("PLAN_SURR_YN"));
				PM_IL_PLAN_BEAN.setPLAN_SURR_YRS(resultSet
						.getInt("PLAN_SURR_YRS"));
				PM_IL_PLAN_BEAN.setPLAN_RED_SA_BASIS(resultSet
						.getString("PLAN_RED_SA_BASIS"));
				PM_IL_PLAN_BEAN.setPLAN_FRZ_FLAG(resultSet
						.getString("PLAN_FRZ_FLAG"));
				PM_IL_PLAN_BEAN.setPLAN_CR_DT(resultSet.getDate("PLAN_CR_DT"));
				PM_IL_PLAN_BEAN.setPLAN_CR_UID(resultSet
						.getString("PLAN_CR_UID"));
				PM_IL_PLAN_BEAN
						.setPLAN_UPD_DT(resultSet.getDate("PLAN_UPD_DT"));
				PM_IL_PLAN_BEAN.setPLAN_UPD_UID(resultSet
						.getString("PLAN_UPD_UID"));
				PM_IL_PLAN_BEAN.setPLAN_CREDIT_YN(resultSet
						.getString("PLAN_CREDIT_YN"));
				PM_IL_PLAN_BEAN.setPLAN_MAX_AGE_ON_MAT(resultSet
						.getInt("PLAN_MAX_AGE_ON_MAT"));
				PM_IL_PLAN_BEAN.setPLAN_MIN_SA(resultSet
						.getDouble("PLAN_MIN_SA"));
				PM_IL_PLAN_BEAN.setPLAN_MAX_SA(resultSet
						.getDouble("PLAN_MAX_SA"));
				PM_IL_PLAN_BEAN.setPLAN_REVIVAL_YN(resultSet
						.getString("PLAN_REVIVAL_YN"));
				PM_IL_PLAN_BEAN.setPLAN_REVIVAL_YRS(resultSet
						.getInt("PLAN_REVIVAL_YRS"));
				PM_IL_PLAN_BEAN.setPLAN_SPL_REVIVAL_YN(resultSet
						.getString("PLAN_SPL_REVIVAL_YN"));
				PM_IL_PLAN_BEAN.setPLAN_SPL_REVIVAL_YRS(resultSet
						.getInt("PLAN_SPL_REVIVAL_YRS"));
				PM_IL_PLAN_BEAN.setPLAN_POL_VALID_AFTER_MAT_YN(resultSet
						.getString("PLAN_POL_VALID_AFTER_MAT_YN"));
				PM_IL_PLAN_BEAN.setPLAN_AGE_TERM_FLAG(resultSet
						.getString("PLAN_AGE_TERM_FLAG"));
				PM_IL_PLAN_BEAN.setPLAN_MIN_AGE_ON_MAT(resultSet
						.getInt("PLAN_MIN_AGE_ON_MAT"));
				PM_IL_PLAN_BEAN.setPLAN_CALC_TYPE(resultSet
						.getString("PLAN_CALC_TYPE"));
			//Committed by dhinesh for SSP call FALCONQC-1714734 
				PM_IL_PLAN_BEAN.setPLAN_LOAN_PER(resultSet
						.getInt("PLAN_LOAN_PER"));
				
           //end FALCONQC-1714734
				
				/*Added by saritha on 07-Jan-2017 for RM018T - DEV_IL_ZB Life_012b_Claim waiting period*/ 
				PM_IL_PLAN_BEAN.setPLAN_CONT_PERIOD(resultSet
						.getInt("PLAN_CONT_PERIOD"));
				
				/*End*/
				
				
				/*added by raja on 18-04-2017*/
				PM_IL_PLAN_BEAN.setPLAN_MAX_DEP_COUNT(resultSet.getInt("PLAN_MAX_DEP_COUNT"));
				/*end*/
				
				/*added by raja on 18-04-2017 fro ZBILQC-1730358*/
				PM_IL_PLAN_BEAN.setPLAN_PROP_AGE_FM(resultSet.getInt("PLAN_PROP_AGE_FM"));
				PM_IL_PLAN_BEAN.setPLAN_PROP_AGE_TO(resultSet.getInt("PLAN_PROP_AGE_TO"));
				/*end*/
				
				
			}
			PILM003_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PLAN_ACTION_BEAN()
					.setPM_IL_PLAN_BEAN(PM_IL_PLAN_BEAN);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
