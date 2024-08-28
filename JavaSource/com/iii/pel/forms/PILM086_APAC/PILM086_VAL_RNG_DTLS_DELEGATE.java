package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILM086_VAL_RNG_DTLS_DELEGATE {
	public void executeSelectStatement(
			PILM086_APAC_COMPOSITE_ACTION PILM086_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		
		
		System.out.println("DELEGATE CLASS CALLED IN  PILM086_VAL_RNG_DTLS_DELEGATE");
		String selectStatement = "SELECT ROWID,PM_BUS_RULE_DTL3.* FROM PM_BUS_RULE_DTL3 WHERE BRD3_BRH_SYS_ID=?";
		System.out.println("QUERY"+selectStatement);
		Connection connection = null;
		ResultSet resultSet = null;
		//PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_VAL_ACTION_BEAN().getDataList_PILM086_VAL_RNG_DTLS_BEAN().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection, new Object[]{PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID()});
			while (resultSet.next()) {
				PILM086_VAL_RNG_DTLS_BEAN VAL_BEAN = new PILM086_VAL_RNG_DTLS_BEAN();
				VAL_BEAN.setROWID(resultSet.getString("ROWID"));
				System.out.println("ROWID===================="+resultSet.getString("ROWID"));
				VAL_BEAN.setBRD3_DTL_SNO(resultSet.getInt("BRD3_DTL_SNO"));
				VAL_BEAN.setBRD3_VALUE_FM(resultSet.getString("BRD3_VALUE_FM"));
				VAL_BEAN.setBRD3_VALUE_TO(resultSet.getString("BRD3_VALUE_TO"));
				VAL_BEAN.setBRD3_DATE_FM(resultSet.getDate("BRD3_DATE_FM"));
				VAL_BEAN.setBRD3_DATE_TO(resultSet.getDate("BRD3_DATE_TO"));
		
				//addded  by raja
				
				VAL_BEAN.setBRD3_CR_DT(resultSet.getDate("BRD3_CR_DT"));
			VAL_BEAN.setBRD3_CR_UID(resultSet.getString("BRD3_CR_UID"));
			VAL_BEAN.setBRD3_UPD_DT(resultSet.getDate("BRD3_UPD_DT"));
			VAL_BEAN.setBRD3_UPD_UID(resultSet.getString("BRD3_UPD_UID"));
			
			//added by raja
			
				PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_VAL_ACTION_BEAN().getDataList_PILM086_VAL_RNG_DTLS_BEAN().add(VAL_BEAN);						
			}
			System.out.println("size"+PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_VAL_ACTION_BEAN().getDataList_PILM086_VAL_RNG_DTLS_BEAN().size());
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
