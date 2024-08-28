package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ASSURED_DTLS_1_DELEGATE {
	public void executeSelectStatement(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_ASSURED_DTLS.* FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? AND POAD_TYPE = 'E'";

		Connection connection = null;
		ResultSet resultSet = null;
		PT_IL_POL_ASSURED_DTLS_1_ACTION PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		try {
			connection = CommonUtils.getConnection();
			// default where and relation is the same
			// if(PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getDEFAULT_WHERE() !=
			// null){
			// selectStatement = selectStatement +
			// PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getDEFAULT_WHERE();
			resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection, 
					new Object[] { compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = new PT_IL_POL_ASSURED_DTLS_1();
			while (resultSet.next()) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_SYS_ID(resultSet.getLong("POAD_SYS_ID"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_POL_SYS_ID(resultSet.getLong("POAD_POL_SYS_ID"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_SERIAL_NO(resultSet.getDouble("POAD_SERIAL_NO"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_ASSR_CODE(resultSet.getString("POAD_ASSR_CODE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_ASSURED_NAME(resultSet.getString("POAD_ASSURED_NAME"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BIRTH_PLACE(resultSet.getString("POAD_BIRTH_PLACE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DOB(resultSet.getDate("POAD_DOB"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE(resultSet.getInt("POAD_AGE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_NATIONALITY(resultSet.getString("POAD_NATIONALITY"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_MAR_STATUS(resultSet.getString("POAD_MAR_STATUS"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_OCC_CODE(resultSet.getString("POAD_OCC_CODE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_NATURE_OF_WORK(resultSet.getString("POAD_NATURE_OF_WORK"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEALTH_CODE(resultSet.getString("POAD_HEALTH_CODE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REMARKS(resultSet.getString("POAD_REMARKS"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_CR_DT(resultSet.getDate("POAD_CR_DT"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_CR_UID(resultSet.getString("POAD_CR_UID"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_UPD_DT(resultSet.getDate("POAD_UPD_DT"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_UPD_UID(resultSet.getString("POAD_UPD_UID"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_SUM_ASSURED(resultSet.getDouble("POAD_FC_SUM_ASSURED"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_SUM_ASSURED(resultSet.getDouble("POAD_LC_SUM_ASSURED"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_AMAN_PREM(resultSet.getDouble("POAD_FC_AMAN_PREM"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_AMAN_PREM(resultSet.getDouble("POAD_LC_AMAN_PREM"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_SENABEL_PREM(resultSet.getDouble("POAD_FC_SENABEL_PREM"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_SENABEL_PREM(resultSet.getDouble("POAD_LC_SENABEL_PREM"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_AMAN_LOAD_PREM(resultSet.getDouble("POAD_FC_AMAN_LOAD_PREM"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_AMAN_LOAD_PREM(resultSet.getDouble("POAD_LC_AMAN_LOAD_PREM"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_CATG_CODE(resultSet.getString("POAD_CATG_CODE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEALTH_RATE(resultSet.getDouble("POAD_HEALTH_RATE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEIGHT(resultSet.getDouble("POAD_HEIGHT"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_WEIGHT(resultSet.getDouble("POAD_WEIGHT"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DISC_AGE(resultSet.getInt("POAD_DISC_AGE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_ADDL_RISK_CODE(resultSet.getString("POAD_ADDL_RISK_CODE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE_PROOF_FLAG(resultSet.getString("POAD_AGE_PROOF_FLAG"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE_PROOF_OTHERS(resultSet.getString("POAD_AGE_PROOF_OTHERS"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REF_ID1(resultSet.getString("POAD_REF_ID1"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_REF_ID2(resultSet.getString("POAD_REF_ID2"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_OCC_CLASS(resultSet.getString("POAD_OCC_CLASS"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI(resultSet.getDouble("POAD_BMI"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_RACE(resultSet.getString("POAD_RACE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_THRESHOLD_LMT(resultSet.getDouble("POAD_LC_THRESHOLD_LMT"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_ORG_LC_THRESHOLD_LMT(resultSet.getDouble("POAD_ORG_LC_THRESHOLD_LMT"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_RELIGION_CODE(resultSet.getString("POAD_RELIGION_CODE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_TYPE(resultSet.getString("POAD_TYPE"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEIGHT_UNIT(resultSet.getString("POAD_HEIGHT_UNIT"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_WEIGHT_UNIT(resultSet.getString("POAD_WEIGHT_UNIT"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_SALARY(resultSet.getDouble("POAD_FC_SALARY"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_SALARY(resultSet.getDouble("POAD_LC_SALARY"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_SMOKE_YN(resultSet.getString("POAD_SMOKE_YN"));
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_NO_OF_CIGAR(resultSet.getInt("POAD_NO_OF_CIGAR"));

			}

			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN
					.setPT_IL_POL_ASSURED_DTLS_1_BEAN(PT_IL_POL_ASSURED_DTLS_1_BEAN);
			// }
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
