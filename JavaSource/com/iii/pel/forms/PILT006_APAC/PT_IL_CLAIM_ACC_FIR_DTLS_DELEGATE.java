package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_ACC_FIR_DTLS_DELEGATE {
	
	private static final Log log = LogFactory.getLog(PT_IL_CLAIM_ACC_FIR_DTLS_DELEGATE.class);
	/**
	 * 
	 * @param PILT006_APAC_COMPOSITE_ACTION_BEAN
	 * @throws Exception
	 */
	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION PILT006_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_CLAIM_ACC_FIR_DTLS.* FROM PT_IL_CLAIM_ACC_FIR_DTLS " +
				"WHERE CAFD_CLAIM_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		List<PT_IL_CLAIM_ACC_FIR_DTLS> list = new ArrayList<PT_IL_CLAIM_ACC_FIR_DTLS>();
		if(PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN().getDataList_PT_IL_CLAIM_ACC_FIR_DTLS()!=null 
				&& PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN().getDataList_PT_IL_CLAIM_ACC_FIR_DTLS().size()>0){
			PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN().getDataList_PT_IL_CLAIM_ACC_FIR_DTLS().clear();
		}
		
		try {
			log.info("==========ID=====>"+PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
			Object[] obj = new Object[]{PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()};
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,obj);
			while (resultSet.next()) {
				PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN = new PT_IL_CLAIM_ACC_FIR_DTLS();
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_SYS_ID(resultSet
						.getDouble("CAFD_SYS_ID"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_CLAIM_SYS_ID(resultSet
						.getLong("CAFD_CLAIM_SYS_ID"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_ACC_DATE(resultSet
						.getDate("CAFD_ACC_DATE"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_ACC_TIME(resultSet
						.getDate("CAFD_ACC_TIME"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_FIR_NO(resultSet
						.getString("CAFD_FIR_NO"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_REG_DT(resultSet
						.getDate("CAFD_REG_DT"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_ACC_PLACE(resultSet
						.getString("CAFD_ACC_PLACE"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_STA_CODE(resultSet
						.getString("CAFD_STA_CODE"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_ACC_TYPE(resultSet
						.getString("CAFD_ACC_TYPE"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_INJ_TYPE(resultSet
						.getString("CAFD_INJ_TYPE"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_CR_DT(resultSet
						.getDate("CAFD_CR_DT"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_CR_UID(resultSet
						.getString("CAFD_CR_UID"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_UPD_DT(resultSet
						.getDate("CAFD_UPD_DT"));
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_UPD_UID(resultSet
						.getString("CAFD_UPD_UID"));

				list.add(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN);
			}
			
			PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN().setDataListPT_IL_CLAIM_ACC_FIR_DTLS(list);
			
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
