package com.iii.pel.forms.PILQ116_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PAYVOU_DRCR_DTL_DELEGATE {
	public void executeSelectStatement(
			PILQ116_APAC_COMPOSITE_ACTION PILQ116_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_PAYVOU_DRCR_DTL.* FROM PT_IL_PAYVOU_DRCR_DTL WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILQ116_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN()
				.getDataList_PT_IL_PAYVOU_DRCR_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PT_IL_PAYVOU_DRCR_DTL PT_IL_PAYVOU_DRCR_DTL_BEAN = new PT_IL_PAYVOU_DRCR_DTL();
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_SYS_ID(resultSet
						.getLong("PADD_SYS_ID"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_PAH_SYS_ID(resultSet
						.getLong("PADD_PAH_SYS_ID"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_TXN_CODE(resultSet
						.getString("PADD_TXN_CODE"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_DOC_NO(resultSet
						.getDouble("PADD_DOC_NO"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_SEQ_NO(resultSet
						.getDouble("PADD_SEQ_NO"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_DOC_DT(resultSet
						.getDate("PADD_DOC_DT"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_POL_SYS_ID(resultSet
						.getLong("PADD_POL_SYS_ID"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_POL_NO(resultSet
						.getString("PADD_POL_NO"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_CLAIM_NO(resultSet
						.getString("PADD_CLAIM_NO"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_CLM_SYS_ID(resultSet
						.getLong("PADD_CLM_SYS_ID"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_CUST_CODE(resultSet
						.getString("PADD_CUST_CODE"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_CURR_CODE(resultSet
						.getString("PADD_CURR_CODE"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_MAIN_ACNT_CODE(resultSet
						.getString("PADD_MAIN_ACNT_CODE"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_SUB_ACNT_CODE(resultSet
						.getString("PADD_SUB_ACNT_CODE"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_ANLY_CODE_1(resultSet
						.getString("PADD_ANLY_CODE_1"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_ANLY_CODE_2(resultSet
						.getString("PADD_ANLY_CODE_2"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_DRCR_FLAG(resultSet
						.getString("PADD_DRCR_FLAG"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_POST_YN(resultSet
						.getString("PADD_POST_YN"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_FC_AMT(resultSet
						.getDouble("PADD_FC_AMT"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_LC_AMT(resultSet
						.getDouble("PADD_LC_AMT"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_DOC_TYPE(resultSet
						.getString("PADD_DOC_TYPE"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_ACNT_YEAR(resultSet
						.getDouble("PADD_ACNT_YEAR"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_SELECTED_YN(resultSet
						.getString("PADD_SELECTED_YN"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_CR_UID(resultSet
						.getString("PADD_CR_UID"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_CR_DT(resultSet
						.getDate("PADD_CR_DT"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_UPD_UID(resultSet
						.getString("PADD_UPD_UID"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_UPD_DT(resultSet
						.getDate("PADD_UPD_DT"));
				PT_IL_PAYVOU_DRCR_DTL_BEAN.setPADD_TYPE(resultSet
						.getString("PADD_TYPE"));

				PILQ116_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_PAYVOU_DRCR_DTL_ACTION_BEAN()
						.getDataList_PT_IL_PAYVOU_DRCR_DTL().add(
								PT_IL_PAYVOU_DRCR_DTL_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}