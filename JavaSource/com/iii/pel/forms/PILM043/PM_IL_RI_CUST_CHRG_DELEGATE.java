package com.iii.pel.forms.PILM043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_RI_CUST_CHRG_DELEGATE {

	public int updateData(PM_IL_RI_CUST_CHRG pm_il_ri_cust_chrg) throws Exception{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_ri_cust_chrg, connection);
//			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw exc;
		} 
		return rowUpdated;
	}
	
	public int deleteData(PM_IL_RI_CUST_CHRG pm_il_ri_cust_chrg){


		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_ri_cust_chrg, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return deletedRows;
	}
	public List<SelectItem> comboBoxValue(String formName, String blockName, String comboFieldName, String comboFieldId){
		List<SelectItem> comboList = null;
		try{
			Connection connection=CommonUtils.getConnection();
			comboList = new ListItemUtil().getDropDownListValue(connection, formName, blockName, comboFieldName, comboFieldId);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return comboList;
	}

	
	/*
	 * Suggestion Box for Charge Code.
	 */
	public List prepareChargeCodeList(String chargeCode, List RI_POOL_SETUP_LIST) throws DBException{
		String query = null;
		Connection connection = CommonUtils.getConnection();
		if ("*".equalsIgnoreCase(chargeCode)) {
			query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$COMP_RCC_CHRG_CODE$LOV1;
			Object[] object={};
			RI_POOL_SETUP_LIST = chargeCodeLOV(connection, query, object);

		} else {
			chargeCode = chargeCode + "%";
			Object[] object={chargeCode.toUpperCase()};
			query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$COMP_RCC_CHRG_CODE$LOV2;
			RI_POOL_SETUP_LIST = chargeCodeLOV(connection, query, object);
		}
		return RI_POOL_SETUP_LIST;
	}
	
	 public List chargeCodeLOV(Connection connection, String query, Object[] object){
		 	List RI_POOL_SETUP_LIST = new ArrayList();
		 	CRUDHandler handler = new CRUDHandler();
		 	ResultSet resultSet = null;
			try{
				resultSet=handler.executeSelectStatement(query, connection, object);
				while(resultSet.next()){
					PM_IL_RI_CUST_CHRG pm_il_ri_cust_chrg = new PM_IL_RI_CUST_CHRG();
					pm_il_ri_cust_chrg.setRCC_CHRG_CODE(resultSet.getString(1));
					pm_il_ri_cust_chrg.setUI_M_RCC_CHRG_CODE_DESC(resultSet.getString(2));
					RI_POOL_SETUP_LIST.add(pm_il_ri_cust_chrg);
				}
			}
			catch (Exception e) {
			e.printStackTrace();
		}finally{try {new CommonUtils().closeCursor(resultSet);} catch (Exception e) {}}
		return RI_POOL_SETUP_LIST;
	}
	 
	 public List getChargeDetailsValues(String poolCode, String coverCode, String customerCode){
			ResultSet resultSet = null;
			List<PM_IL_RI_CUST_CHRG> result = null;
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				connection = CommonUtils.getConnection();
				result = new ArrayList<PM_IL_RI_CUST_CHRG>();
				String queryString = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$FETCH_CHARGE_DETAILS;
				PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
				Object[] values = {poolCode, coverCode, customerCode};

				resultSet = handler.executeSelectStatement(queryString, connection, values);
				while (resultSet.next()) {
					PM_IL_RI_CUST_CHRG pm_il_ri_cust_chrg = new PM_IL_RI_CUST_CHRG();
//					pm_il_ri_cust_chrg.setRCC_RPS_CODE(resultSet.getString("RCC_RPS_CODE"));
					pm_il_ri_cust_chrg.setRCC_RPCVR_CODE(resultSet.getString("RCC_RPCVR_CODE"));
					pm_il_ri_cust_chrg.setRCC_RPCUST_CODE(resultSet.getString("RCC_RPCUST_CODE"));
					pm_il_ri_cust_chrg.setRCC_SRNO(resultSet.getDouble("RCC_SRNO"));
					pm_il_ri_cust_chrg.setRCC_CHRG_TYPE(resultSet.getString("RCC_CHRG_TYPE"));
					pm_il_ri_cust_chrg.setRCC_CHRG_CODE(resultSet.getString("RCC_CHRG_CODE"));
					pm_il_ri_cust_chrg.setRCC_RATE(resultSet.getDouble("RCC_RATE"));
					pm_il_ri_cust_chrg.setRCC_RATE_PER(resultSet.getDouble("RCC_RATE_PER"));
					pm_il_ri_cust_chrg.setRCC_APPLY_PERIOD(resultSet.getString("RCC_APPLY_PERIOD"));
					pm_il_ri_cust_chrg.setRCC_CUST_SHARE_PERC(resultSet.getDouble("RCC_CUST_SHARE_PERC"));
					pm_il_ri_cust_chrg.setRCC_CR_DT(resultSet.getDate("RCC_CR_DT"));
					pm_il_ri_cust_chrg.setRCC_CR_UID(resultSet.getString("RCC_CR_UID"));
//					pm_il_ri_cust_chrg.setRCC_UPD_DT(resultSet.getDate("RCC_UPD_DT"));
//					pm_il_ri_cust_chrg.setRCC_UPD_UID(resultSet.getString("RCC_UPD_UID"));
					pm_il_ri_cust_chrg.setROWID(resultSet.getString("ROWID"));
					
					/*added by raja on 19-04-2017*/
					if(pm_il_ri_cust_chrg.getRCC_CHRG_CODE()!=null)
					{
					String query="SELECT PC_CODE FROM PM_CODES WHERE PC_TYPE ='IL_CHARGE' AND PC_RI_APPL_YN='Y' AND PC_CODE=?";
					ResultSet rs=handler.executeSelectStatement(query, connection,new Object[]{pm_il_ri_cust_chrg.getRCC_CHRG_CODE()});
					while(rs.next()){
						pm_il_ri_cust_chrg.setUI_M_RCC_CHRG_CODE_DESC(rs.getString(1));
					}
					}
					/*end*/
					
					result.add(pm_il_ri_cust_chrg);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (DBException e) {
				e.printStackTrace();
			}
			finally{try {new CommonUtils().closeCursor(resultSet);} catch (Exception e) {}}
			return result;
		}
	
	 /*
	  * Save functionlity
	  */
	public String saveData(PM_IL_RI_CUST_CHRG_ACTION pm_il_ri_cust_chrg_action){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();	
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	}

}
