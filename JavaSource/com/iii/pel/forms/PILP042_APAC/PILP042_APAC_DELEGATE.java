package com.iii.pel.forms.PILP042_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILP042_APAC_DELEGATE {
	
	public List<PT_IL_FUND_TRAN_HDR> preparepolicyNoList(String policyNo, List<PT_IL_FUND_TRAN_HDR> policyNoList){
		Connection connection = null;
		String policyNoLovSelectQuery = null;
		try {
			connection = CommonUtils.getConnection();
			if ("*".equalsIgnoreCase(policyNo)) {
				policyNoLovSelectQuery = PILP042_APAC_SQL_QUERY_CONSTANTS.RETRIEVE_POLICY_NO_LOV;
				Object[] object={PILP042_APAC_CONSTANTS.ROW_NUM};
				policyNoList = policyNoLOV(connection, policyNoLovSelectQuery,object);

			} else {
				policyNo = policyNo.toUpperCase() + PILP042_APAC_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
				Object[] object={policyNo,PILP042_APAC_CONSTANTS.ROW_NUM};
				policyNoLovSelectQuery = PILP042_APAC_SQL_QUERY_CONSTANTS.RETRIEVE_POLICY_NO_LOV_LIST_LIKE;
				policyNoList = policyNoLOV(connection, policyNoLovSelectQuery,object);
			}
		} catch (DBException e) {
			e.printStackTrace();
		}

		return policyNoList;
	}

	/**
	 * List returning PolicyNo LOV containing code and its description
	 * 
	 * @param connection
	 * @param query
	 * @return
	 */
	private List<PT_IL_FUND_TRAN_HDR> policyNoLOV(Connection connection,String query,Object[] object)
	{
		List<PT_IL_FUND_TRAN_HDR> policyNoList = new ArrayList<PT_IL_FUND_TRAN_HDR>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try
		{
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PT_IL_FUND_TRAN_HDR pt_il_fund_tran_hdr = new PT_IL_FUND_TRAN_HDR();
				pt_il_fund_tran_hdr.setFTH_POL_NO(resultSet.getString(1));
				policyNoList.add(pt_il_fund_tran_hdr);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return policyNoList;
	}

	public int executeInsert(Object insertObject) {
		Connection connection = null;
		int effectedRows = 0;
		try {
			CRUDHandler crudHandler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			effectedRows = crudHandler.executeInsert(insertObject, connection);
			if (effectedRows > 0) {
				System.out.println("Inserted Rows!.....");
				connection.commit();
			} else {
				System.out.println("Not Inserted!...");
			}
		} catch (Exception e) {
			/*try {
				connection.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}*/
			e.printStackTrace();
		}

		return effectedRows;
	}
	
}
