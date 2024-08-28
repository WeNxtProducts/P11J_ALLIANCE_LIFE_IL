package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PH_IL_CLAIM_COVER_DTLS_DELEGATE {
	
	/**
	 * 
	 * @param PILT006_APAC_COMPOSITE_ACTION_BEAN
	 * @throws Exception
	 */
	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION PILT006_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		DBProcedures dbProcedure = new DBProcedures();
		List<PH_IL_CLAIM_COVER_DTLS> list = new ArrayList<PH_IL_CLAIM_COVER_DTLS>();
		String selectStatement = "SELECT ROWID, PH_IL_CLAIM_COVER_DTLS.* FROM PH_IL_CLAIM_COVER_DTLS WHERE CCDH_CLAIM_SYS_ID= ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_CLAIM_SYS_ID()});
			while (resultSet.next()) {
				PH_IL_CLAIM_COVER_DTLS PH_IL_CLAIM_COVER_DTLS_BEAN = new PH_IL_CLAIM_COVER_DTLS();
				PH_IL_CLAIM_COVER_DTLS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_SYS_ID(resultSet
						.getLong("CCDH_SYS_ID"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_CLAIM_SYS_ID(resultSet
						.getLong("CCDH_CLAIM_SYS_ID"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_REF_NO(resultSet
						.getDouble("CCDH_REF_NO"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_COVER_CODE(resultSet
						.getString("CCDH_COVER_CODE"));
				
				List<String> coverList = dbProcedure.callP_VAL_COVER_PROC(PH_IL_CLAIM_COVER_DTLS_BEAN
						.getCCDH_COVER_CODE(), PH_IL_CLAIM_COVER_DTLS_BEAN
						.getUI_M_CCDH_COVER_CODE_DESC(), null, "N", "N");
				if(coverList!=null){
					PH_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCDH_COVER_CODE_DESC(coverList.get(0));
				}
				
				
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_LOSS_TYPE(resultSet
						.getString("CCDH_LOSS_TYPE"));
				
				List<String> losTypeList = dbProcedure.P_VAL_CODES_PROC_CALL("IL_LOS_TYP", PH_IL_CLAIM_COVER_DTLS_BEAN.getCCDH_LOSS_TYPE(),
						"N", "N");
				if(losTypeList!=null){
					PH_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCDH_LOSS_TYPE_DESC(losTypeList.get(0));
				}
				
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_DISAB_TYPE(resultSet
						.getString("CCDH_DISAB_TYPE"));
				
				List<String> disableList = dbProcedure.P_VAL_CODES_PROC_CALL("IL_DIS_TYP", PH_IL_CLAIM_COVER_DTLS_BEAN.getCCDH_DISAB_TYPE(),
						"N", "N");
				if(disableList!=null){
					PH_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCDH_DISAB_TYPE_DESC(disableList.get(0));
				}
				
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_PERIOD_UNIT(resultSet
						.getString("CCDH_PERIOD_UNIT"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_PERIOD(resultSet
						.getDouble("CCDH_PERIOD"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_RATE(resultSet
						.getDouble("CCDH_RATE"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_RATE_PER(resultSet
						.getDouble("CCDH_RATE_PER"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_O_FC_EST_AMT(resultSet
						.getDouble("CCDH_O_FC_EST_AMT"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_O_LC_EST_AMT(resultSet
						.getDouble("CCDH_O_LC_EST_AMT"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_N_FC_EST_AMT(resultSet
						.getDouble("CCDH_N_FC_EST_AMT"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_N_LC_EST_AMT(resultSet
						.getDouble("CCDH_N_LC_EST_AMT"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_FRZ_FLAG(resultSet
						.getString("CCDH_FRZ_FLAG"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_CLOSE_FLAG(resultSet
						.getString("CCDH_CLOSE_FLAG"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_CLOSE_DT(resultSet
						.getDate("CCDH_CLOSE_DT"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_CONFIRM_FLAG(resultSet
						.getString("CCDH_CONFIRM_FLAG"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_RESERVE_GEN_FLAG(resultSet
						.getString("CCDH_RESERVE_GEN_FLAG"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_CR_UID(resultSet
						.getString("CCDH_CR_UID"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_CR_DT(resultSet
						.getDate("CCDH_CR_DT"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_UPD_UID(resultSet
						.getString("CCDH_UPD_UID"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_UPD_DT(resultSet
						.getDate("CCDH_UPD_DT"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_SET_FLAG(resultSet
						.getString("CCDH_SET_FLAG"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_O_RESERVE_DT(resultSet
						.getDate("CCDH_O_RESERVE_DT"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_N_RESERVE_DT(resultSet
						.getDate("CCDH_N_RESERVE_DT"));
				/*PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_PROD_CODE(resultSet
						.getString("CCDH_PROD_CODE"));
				PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_COVER_GROUP_CODE(resultSet
						.getString("CCDH_COVER_GROUP_CODE"));*/
				
				list.add(PH_IL_CLAIM_COVER_DTLS_BEAN);
			}
			PILT006_APAC_COMPOSITE_ACTION_BEAN.getPH_IL_CLAIM_COVER_DTLS_ACTION_BEAN().setDataList_PH_IL_CLAIM_COVER_DTLS(list);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
