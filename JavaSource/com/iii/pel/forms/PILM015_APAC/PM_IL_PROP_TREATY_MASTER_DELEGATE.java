package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.model.SelectItem;

import com.adventnet.swissql.b.a.ac.r;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROP_TREATY_MASTER_DELEGATE {
	
	public String getTreatyCodeDesc(String treatyCode) throws Exception
	{
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		String description = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PILM015_APAC_TREATY_MASTER_TREATY_CODE_WHEN_VALIDATE_ITEM;
			Object[] params = {treatyCode};
			resultSet = handler.executeSelectStatement(query, connection, params);
			while(resultSet.next())
			{
				description = resultSet.getString(1);
			}
			
		}catch(Exception exception)
		{
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		}
		return description;
	}

	public String getCurrencyCodeDesc(String currencyCode) throws Exception
	{
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		String description = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String query = PM_IL_PROP_TREATY_QUERY_CONSTANTS.PIL015_APAC_PM_IL_PROP_TREATY_CURR_CODE_WHEN_VALIDATE_ITEM;
			Object[] params = {currencyCode};
			resultSet = handler.executeSelectStatement(query, connection, params);
			while(resultSet.next())
			{
				description = resultSet.getString(1);
			}
			
		}catch(Exception exception)
		{
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		}
		return description;
	}
	
	/**
	 * Gets List of SelectItem for TreatyMaster Select Items
	 * 
	 * @param itemName
	 *            ItemName String
	 * @param sysParam
	 *            SysParam String
	 * @return List of SelectItem
	 * @throws Exception 
	 */
	public List<SelectItem> getListTreatyMaster(String itemName, String sysParam) throws Exception {
		Connection connection;
		List<SelectItem> itemList = null;
		try {
			connection = CommonUtils.getConnection();
			itemList = ListItemUtil
					.getDropDownListValue(
							connection,
							PM_IL_PROP_TREATY_CONSTANTS.PILM105_APAC_TREATY_MASTER_MODULE_NAME_PILM015_APAC,
							PM_IL_PROP_TREATY_CONSTANTS.PILM105_APAC_TREATY_MASTER_BLOCK_NAME_PM_IL_PROP_TREATY,
							itemName, sysParam);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return itemList;
	}
	
	public int executeInsertForTreatyType(Object insertObject) throws Exception {
		Connection connection = null;
		int effectedRows = 0;
		try {
			CRUDHandler crudHandler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			/*Commented by janani on 31.01.2018 for ZBLIFE-1468859*/
			
			//effectedRows = crudHandler.executeInsert(insertObject, connection);
			
			effectedRows = crudHandler.executeUpdate(insertObject, connection);
			
			/*End of ZBLIFE-1468859*/
			//connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return effectedRows;
	}

	public void preDelete(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, 
			PM_IL_PROP_TREATY pm_il_prop_treaty) throws Exception {
		Connection connection = null;
		CRUDHandler handler = null;
		try {
			double syId = compositeAction.getPM_IL_PROP_TREATY_ACTION()
					.getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID();
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String treatyTypeDelete = "DELETE FROM PM_IL_PROP_TREATY_TYPE WHERE PTT_PT_SYS_ID ='"
					+ syId + "'";
			String medicalDelete = "DELETE FROM PM_IL_MED_EXAM_HDR WHERE MEH_PT_SYS_ID ='"
					+ syId + "'";
			String heightWeightDelete = "DELETE FROM PM_IL_HTWT_DTL WHERE HTWT_PT_SYS_ID='"
					+ syId + "'";
			handler.executeDeleteStatement(treatyTypeDelete, connection);
			handler.executeDeleteStatement(medicalDelete, connection);
			handler.executeDeleteStatement(heightWeightDelete, connection);
			handler.executeDelete(pm_il_prop_treaty, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void executeQuery(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) {
		Connection connection = null;
		ResultSet resultSet = null;
		PM_IL_PROP_TREATY pm_il_prop_treaty = null;
		/*Added PT_CORIDOR_LC_LIMIT this column in query by R Raja for get corrider limit on 17-12-2016*/
		
		String query = "SELECT ROWID,PT_SYS_ID,PT_TREATY_CODE,PT_TREATY_DESC,PT_CLASS_CODE," +
				" PT_UW_YEAR,PT_UW_YEAR_DESC,PT_START_DT,PT_END_DT,PT_CURR_CODE,PT_CURR_RATE,PT_CQS_YN," +
				" PT_CQS_PERC,PT_CASH_CALL_FC_LIMIT,PT_CASH_CALL_LC_LIMIT," +
				" PT_SURR_CLAIM_YN,PT_REALLC_ENDT_YN,PT_RIDER_RI_BASIS,PT_CORIDOR_LC_LIMIT FROM PM_IL_PROP_TREATY " +
				" WHERE ROWID =? ";
		try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { compositeAction.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN().getROWID()});
			pm_il_prop_treaty = compositeAction.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN();
			while (resultSet.next()) {
				pm_il_prop_treaty.setROWID(resultSet.getString("ROWID"));
				pm_il_prop_treaty
						.setPT_SYS_ID(resultSet.getDouble("PT_SYS_ID"));
				pm_il_prop_treaty.setPT_TREATY_CODE(resultSet.getString("PT_TREATY_CODE"));
				pm_il_prop_treaty.setPT_TREATY_DESC(resultSet
						.getString("PT_TREATY_DESC"));
				pm_il_prop_treaty.setPT_CLASS_CODE(resultSet
						.getString("PT_CLASS_CODE"));
				pm_il_prop_treaty.setPT_UW_YEAR(resultSet.getInt("PT_UW_YEAR"));
				pm_il_prop_treaty.setPT_UW_YEAR_DESC(resultSet
						.getString("PT_UW_YEAR_DESC"));
				pm_il_prop_treaty.setPT_START_DT(resultSet
						.getDate("PT_START_DT"));
				pm_il_prop_treaty.setPT_END_DT(resultSet.getDate("PT_END_DT"));
				pm_il_prop_treaty.setPT_CURR_CODE(resultSet
						.getString("PT_CURR_CODE"));
				pm_il_prop_treaty.setPT_CURR_RATE(resultSet
						.getDouble("PT_CURR_RATE"));
				pm_il_prop_treaty
						.setPT_CQS_YN(resultSet.getString("PT_CQS_YN"));
				pm_il_prop_treaty.setPT_CQS_PERC(resultSet
						.getDouble("PT_CQS_PERC"));
				pm_il_prop_treaty.setPT_CASH_CALL_FC_LIMIT(resultSet
						.getDouble("PT_CASH_CALL_FC_LIMIT"));
				pm_il_prop_treaty.setPT_CASH_CALL_LC_LIMIT(resultSet
						.getDouble("PT_CASH_CALL_LC_LIMIT"));
				pm_il_prop_treaty.setPT_SURR_CLAIM_YN(resultSet
						.getString("PT_SURR_CLAIM_YN"));
				pm_il_prop_treaty.setPT_REALLC_ENDT_YN(resultSet
						.getString("PT_REALLC_ENDT_YN"));
				pm_il_prop_treaty.setPT_RIDER_RI_BASIS(resultSet
						.getString("PT_RIDER_RI_BASIS"));
				
				
				/*added bu R. Raja for default corrider limit on 17-12-2016*/ 
				pm_il_prop_treaty.setPT_CORIDOR_LC_LIMIT(resultSet.getDouble("PT_CORIDOR_LC_LIMIT"));
				/*
				 * pm_il_prop_treaty.setPT_CORIDOR_LC_LIMIT(resultSet
				 * .getDouble("PT_CORIDOR_LC_LIMIT"));
				 */
				//POST_QUERY(pm_il_prop_treaty);

			}
			// pm020_a_tisb_pm_cust_class_post_query(pm_il_prop_treaty);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
