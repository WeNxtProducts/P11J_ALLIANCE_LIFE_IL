package com.iii.pel.forms.PILP091_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_CONT_PAID_HDR_DELEGATE {
	public void executeSelectStatement(PILP091_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PS_IL_CONT_PAID_HDR.* FROM PS_IL_CONT_PAID_HDR " ;
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPS_IL_CONT_PAID_HDR_ACTION_BEAN().getDataList_PS_IL_CONT_PAID_HDR().clear();
		
		try {
			connection = CommonUtils.getConnection();
			
			if(compositeAction.getPS_IL_CONT_PAID_HDR_ACTION_BEAN().getDEFAULT_WHERE() != null){
				selectStatement = selectStatement 
					+ " WHERE " 
					+ compositeAction.getPS_IL_CONT_PAID_HDR_ACTION_BEAN().getDEFAULT_WHERE();
			}
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection/* ,
					new Object[] { ps_il_cont_paid_hdr_bean.getCPH_SYS_ID() }*/);
			while (resultSet.next()) {
				PS_IL_CONT_PAID_HDR PS_IL_CONT_PAID_HDR_BEAN = new PS_IL_CONT_PAID_HDR();
				PS_IL_CONT_PAID_HDR_BEAN.setROWID(resultSet.getString("ROWID"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_SYS_ID(resultSet
						.getInt("CPH_SYS_ID"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_POL_SYS_ID(resultSet
						.getInt("CPH_POL_SYS_ID"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_POL_NO(resultSet
						.getString("CPH_POL_NO"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_PRO_DT(resultSet
						.getDate("CPH_PRO_DT"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_ACNT_YEAR(resultSet
						.getDouble("CPH_ACNT_YEAR"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_SUSP_PROFIT(resultSet
						.getDouble("CPH_SUSP_PROFIT"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_PSA_AMT(resultSet
						.getDouble("CPH_PSA_AMT"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_GFTA_AMT(resultSet
						.getDouble("CPH_GFTA_AMT"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_PA_PROFIT(resultSet
						.getDouble("CPH_PA_PROFIT"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_FREEZE_FLAG(resultSet
						.getString("CPH_FREEZE_FLAG"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_GFTA_PROFIT(resultSet
						.getDouble("CPH_GFTA_PROFIT"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_CONFIRM_FLAG(resultSet
						.getString("CPH_CONFIRM_FLAG"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_PROD_CODE(resultSet
						.getString("CPH_PROD_CODE"));
				PS_IL_CONT_PAID_HDR_BEAN.setCPH_APPROVE_YN(resultSet
						.getString("CPH_APPROVE_YN"));

				compositeAction
						.getPS_IL_CONT_PAID_HDR_ACTION_BEAN()
						.getDataList_PS_IL_CONT_PAID_HDR().add(
								PS_IL_CONT_PAID_HDR_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
