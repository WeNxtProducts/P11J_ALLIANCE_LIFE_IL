package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_CLAIM_COVER_DTLS_DELEGATE {
	
	private static final Log log = LogFactory.getLog(PT_IL_CLAIM_COVER_DTLS_DELEGATE.class);
	
	/**
	 * 
	 * @param PILT006_APAC_COMPOSITE_ACTION_BEAN
	 * @throws Exception
	 */
	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION PILT006_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_CLAIM_COVER_DTLS.* FROM PT_IL_CLAIM_COVER_DTLS WHERE " +
				"CCD_CLAIM_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		
		/*Added by Saranya on 24/04/2017*/
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> pList = new ArrayList<String>();
		/*End*/
		
		List<PT_IL_CLAIM_COVER_DTLS> list = new ArrayList<PT_IL_CLAIM_COVER_DTLS>();
		Long CCD_CLAIM_SYS_ID=PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
		log.info("CCD_CLAIM_SYS_ID: "+CCD_CLAIM_SYS_ID);
		try {
			connection = com.iii.premia.common.utils.CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{CCD_CLAIM_SYS_ID});
			while (resultSet.next()) {
				PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN = new PT_IL_CLAIM_COVER_DTLS();
				PT_IL_CLAIM_COVER_DTLS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_SYS_ID(resultSet
						.getLong("CCD_SYS_ID"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CLAIM_SYS_ID(resultSet
						.getLong("CCD_CLAIM_SYS_ID"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_COVER_CODE(resultSet
						.getString("CCD_COVER_CODE"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_LOSS_TYPE(resultSet
						.getString("CCD_LOSS_TYPE"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_DISAB_TYPE(resultSet
						.getString("CCD_DISAB_TYPE"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_FC_EST_AMT(resultSet
						.getDouble("CCD_FC_EST_AMT"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_LC_EST_AMT(resultSet
						.getDouble("CCD_LC_EST_AMT"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_FRZ_FLAG(resultSet
						.getString("CCD_FRZ_FLAG"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CR_UID(resultSet
						.getString("CCD_CR_UID"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CR_DT(resultSet
						.getDate("CCD_CR_DT"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_UPD_UID(resultSet
						.getString("CCD_UPD_UID"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_UPD_DT(resultSet
						.getDate("CCD_UPD_DT"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CLOSE_FLAG(resultSet
						.getString("CCD_CLOSE_FLAG"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CLOSE_DT(resultSet
						.getDate("CCD_CLOSE_DT"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_PERIOD_UNIT(resultSet
						.getString("CCD_PERIOD_UNIT"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_PERIOD(resultSet
						.getInt("CCD_PERIOD"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_RATE(resultSet
						.getDouble("CCD_RATE"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_RATE_PER(resultSet
						.getDouble("CCD_RATE_PER"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CONFIRM_FLAG(resultSet
						.getString("CCD_CONFIRM_FLAG"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_RESERVE_GEN_FLAG(resultSet
						.getString("CCD_RESERVE_GEN_FLAG"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_SET_FLAG(resultSet
						.getString("CCD_SET_FLAG"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_FITR_YN(resultSet
						.getString("CCD_FITR_YN"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_NO_OF_DAYS(resultSet
						.getInt("CCD_NO_OF_DAYS"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_RESERVE_DT(resultSet
						.getDate("CCD_RESERVE_DT"));
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CLAIM_PAY_TO(resultSet
						.getString("CCD_CLAIM_PAY_TO"));
				//ADDED BY AMEEN ON 15-03-2017 AS PER VINOTH SUGG.
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_EMAIL(resultSet
						.getString("CCD_EMAIL"));
				//end
				
				
				
				/*Added by saranya on 24-04-2017*/
				pList = procedures.callP_VAL_COVER_PROC(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(), 
						PT_IL_CLAIM_COVER_DTLS_BEAN.getUI_M_CCD_COVER_CODE_DESC(), 
						null, "N", "N");
				if(!pList.isEmpty() && pList.size() > 0){
					PT_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCD_COVER_CODE_DESC(pList.get(0));
				}
				
				pList = procedures.P_VAL_CODES_PROC_CALL("IL_DIS_TYP",
						PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_DISAB_TYPE(),
						"N", 
						"N");
				if(!pList.isEmpty() && pList.size() > 0){
					PT_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCD_DISAB_TYPE_DESC(pList.get(0));
				}
				pList = procedures.P_VAL_CODES_PROC_CALL("IL_LOS_TYP",
						PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LOSS_TYPE(), 
						"N", 
						"N");
				if(!pList.isEmpty() && pList.size() > 0){
					PT_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCD_LOSS_TYPE_DESC(pList.get(0));
				}
				
				pList.clear();
				/*End*/

				
				list.add(PT_IL_CLAIM_COVER_DTLS_BEAN);
			}
			
			PILT006_APAC_COMPOSITE_ACTION compositeAction = PILT006_APAC_ACTION_INSTANCE.getCompositeActionInstance();
			compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().setDataList_PT_IL_CLAIM_COVER_DTLS(list);
			
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
