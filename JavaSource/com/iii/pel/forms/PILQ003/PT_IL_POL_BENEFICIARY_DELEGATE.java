package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_BENEFICIARY_DELEGATE {
	public void executeSelectStatement(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_BENEFICIARY.* FROM PT_IL_POL_BENEFICIARY WHERE  PBEN_POL_SYS_ID  = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
				.getDataList_PT_IL_POL_BENEFICIARY().clear();
		try {
			connection = CommonUtils.getConnection();
			// Relation And Default Where is same
			// if(compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getDEFAULT_WHERE()
			// != null){
			// selectStatement = selectStatement +
			// compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getDEFAULT_WHERE();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_POL_BENEFICIARY PT_IL_POL_BENEFICIARY_BEAN = new PT_IL_POL_BENEFICIARY();
				PT_IL_POL_BENEFICIARY_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_SYS_ID(resultSet
						.getLong("PBEN_SYS_ID"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_POL_SYS_ID(resultSet
						.getLong("PBEN_POL_SYS_ID"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_SR_NO(resultSet
						.getInt("PBEN_SR_NO"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_TYPE(resultSet
						.getString("PBEN_BNF_TYPE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_NAME(resultSet
						.getString("PBEN_BNF_NAME"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_NAME_BL(resultSet
						.getString("PBEN_BNF_NAME_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_PERC(resultSet
						.getDouble("PBEN_PERC"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE(resultSet
						.getString("PBEN_RELATION_CODE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_1(resultSet
						.getString("PBEN_ADDRESS_1"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_2(resultSet
						.getString("PBEN_ADDRESS_2"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_3(resultSet
						.getString("PBEN_ADDRESS_3"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_4(resultSet
						.getString("PBEN_ADDRESS_4"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_5(resultSet
						.getString("PBEN_ADDRESS_5"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_1_BL(resultSet
						.getString("PBEN_ADDRESS_1_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_2_BL(resultSet
						.getString("PBEN_ADDRESS_2_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_3_BL(resultSet
						.getString("PBEN_ADDRESS_3_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_4_BL(resultSet
						.getString("PBEN_ADDRESS_4_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_5_BL(resultSet
						.getString("PBEN_ADDRESS_5_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REMARKS(resultSet
						.getString("PBEN_REMARKS"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REMARKS_BL(resultSet
						.getString("PBEN_REMARKS_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_CR_UID(resultSet
						.getString("PBEN_CR_UID"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_CR_DT(resultSet
						.getDate("PBEN_CR_DT"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_UPD_UID(resultSet
						.getString("PBEN_UPD_UID"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_UPD_DT(resultSet
						.getDate("PBEN_UPD_DT"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_CATG_CODE(resultSet
						.getString("PBEN_CATG_CODE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_AGE(resultSet
						.getInt("PBEN_AGE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_GUARDIAN_NAME(resultSet
						.getString("PBEN_GUARDIAN_NAME"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_DEL_FLAG(resultSet
						.getString("PBEN_DEL_FLAG"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REF_ID1(resultSet
						.getString("PBEN_REF_ID1"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REF_ID2(resultSet
						.getString("PBEN_REF_ID2"));
				/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee */
				
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_CODE(resultSet.getString("PBEN_BNF_CODE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_DOB(resultSet.getDate("PBEN_DOB"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_EFF_FM_DT(resultSet.getDate("PBEN_EFF_FM_DT"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_EFF_TO_DT(resultSet.getDate("PBEN_EFF_TO_DT"));
				/* End */

				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
						.getDataList_PT_IL_POL_BENEFICIARY().add(
								PT_IL_POL_BENEFICIARY_BEAN);
			}
			// }
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
