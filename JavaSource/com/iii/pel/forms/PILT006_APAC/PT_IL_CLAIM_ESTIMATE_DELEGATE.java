package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_CLAIM_ESTIMATE_DELEGATE {
	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION PILT006_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_CLAIM_ESTIMATE.* FROM PT_IL_CLAIM_ESTIMATE WHERE CE_CLAIM_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[]{PILT006_APAC_COMPOSITE_ACTION_BEAN
							.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
			PT_IL_CLAIM_ESTIMATE PT_IL_CLAIM_ESTIMATE_BEAN = new PT_IL_CLAIM_ESTIMATE();
			while (resultSet.next()) {
				PT_IL_CLAIM_ESTIMATE_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_SYS_ID(resultSet
						.getLong("CE_SYS_ID"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_CLAIM_SYS_ID(resultSet
						.getLong("CE_CLAIM_SYS_ID"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_EST_SETL_UNIT(resultSet
						.getString("CE_EST_SETL_UNIT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_EST_NO_OF_UNITS(resultSet
						.getDouble("CE_EST_NO_OF_UNITS"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_EST_AMT(resultSet
						.getDouble("CE_LC_EST_AMT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_EST_AMT(resultSet
						.getDouble("CE_FC_EST_AMT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_PREM_OS(resultSet
						.getDouble("CE_LC_PREM_OS"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_PREM_OS(resultSet
						.getDouble("CE_FC_PREM_OS"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_LOAN_OS(resultSet
						.getDouble("CE_LC_LOAN_OS"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_LOAN_OS(resultSet
						.getDouble("CE_FC_LOAN_OS"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_LOAN_INT(resultSet
						.getDouble("CE_LC_LOAN_INT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_LOAN_INT(resultSet
						.getDouble("CE_FC_LOAN_INT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_ACC_PROFIT(resultSet
						.getDouble("CE_LC_ACC_PROFIT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_ACC_PROFIT(resultSet
						.getDouble("CE_FC_ACC_PROFIT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_NET_EST_AMT(resultSet
						.getDouble("CE_LC_NET_EST_AMT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_NET_EST_AMT(resultSet
						.getDouble("CE_FC_NET_EST_AMT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_ACT_SETL_UNIT(resultSet
						.getString("CE_ACT_SETL_UNIT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_ACT_NO_OF_UNITS(resultSet
						.getDouble("CE_ACT_NO_OF_UNITS"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_SETL_START_DT(resultSet
						.getDate("CE_SETL_START_DT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_PAID_AMT(resultSet
						.getDouble("CE_LC_PAID_AMT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_PAID_AMT(resultSet
						.getDouble("CE_FC_PAID_AMT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_REF_NO(resultSet
						.getString("CE_REF_NO"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_REMARKS(resultSet
						.getString("CE_REMARKS"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FRZ_FLAG(resultSet
						.getString("CE_FRZ_FLAG"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_CLOSE_FLAG(resultSet
						.getString("CE_CLOSE_FLAG"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_CR_UID(resultSet
						.getString("CE_CR_UID"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_CR_DT(resultSet
						.getDate("CE_CR_DT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_UPD_UID(resultSet
						.getString("CE_UPD_UID"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_UPD_DT(resultSet
						.getDate("CE_UPD_DT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_PREM_OS_INT(resultSet
						.getDouble("CE_LC_PREM_OS_INT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_PREM_OS_INT(resultSet
						.getDouble("CE_FC_PREM_OS_INT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_UNIT_LC_AMT(resultSet
						.getDouble("CE_UNIT_LC_AMT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_UNIT_FC_AMT(resultSet
						.getDouble("CE_UNIT_FC_AMT"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_UNPAID_PREM_FLAG(resultSet
						.getString("CE_UNPAID_PREM_FLAG"));
/*
				Added by saranya for Hands on point num 23 on 14/02/2014
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_CLM_PROC_FEE(resultSet
						.getDouble("CE_LC_CLM_PROC_FEE"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_CLM_PROC_FEE(resultSet
						.getDouble("CE_FC_CLM_PROC_FEE"));
				End
				Added by gopi for Hands on feed back point num 16 in ZB on 15/02/2017 
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_FC_FEE_PAID_HOSP(resultSet
						.getDouble("CE_FC_FEE_PAID_HOSP"));
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_LC_FEE_PAID_HOSP(resultSet
						.getDouble("CE_LC_FEE_PAID_HOSP"));
				end*/
				
				/*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017 */
				PT_IL_CLAIM_ESTIMATE_BEAN.setCE_TOTAL_CHRG_AMT(resultSet
						.getDouble("CE_TOTAL_CHRG_AMT"));
				/*end*/
				
				
				
			}
			PILT006_APAC_COMPOSITE_ACTION_BEAN
					.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
					.setPT_IL_CLAIM_ESTIMATE_BEAN(PT_IL_CLAIM_ESTIMATE_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
