package com.iii.pel.forms.PILM036;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_BONUS_DAO {
	
		// [BugId:Fix122 MMuthu 31-Dec-08 getting connection from CommonUtil class getConnection()	
			public Connection getConnection() throws Exception{
//				Connection connection = null;
//				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					connection = DriverManager.getConnection("jdbc:oracle:thin:@10.44.0.138:1521:ORCL", "PEL_LIFE", "PEL_LIFE");
//					connection.setAutoCommit(false);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				return CommonUtils.getConnection();
		}
		// BugId:Fix122 MMuthu 31-Dec-08 getting connection from CommonUtil class getConnection() ]
	
	public boolean isBonusCodeExisting(String bonusCode){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String queryString = "SELECT * FROM PM_IL_BONUS WHERE BONUS_CODE=?";
		Object[] values = {bonusCode};
		try {
			connection = getConnection();
			ResultSet rst = handler.executeSelectStatement(queryString, connection, values);
			if(rst!=null){
				while(rst.next()){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
	/*public void executeProcedure(){
		Connection connection = null;
		CallableStatement callable = null;
		try {
			connection = getConnection();
			callable = connection.prepareCall("call PCOPK_SYS_VARS.P_SET_PARA_VALUES(?,?,?,?,?,?,?,?,?)");
			callable.setString(1, "ENG");
			callable.setString(2, "");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}*/
	
	//[ removed commented PCOPK_SYS_VARS procedure calling : added by: Shankar bodduluri Dated: 19-Mar-2009 ]
	public boolean saveBonusMaster(Connection connection ){
		PM_IL_BONUS_ACTION bonusAction = (PM_IL_BONUS_ACTION)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILM036_PM_IL_BONUS_ACTION");
		PM_IL_BONUS bonusBean = bonusAction.getPM_IL_BONUS_BEAN();
		boolean isExecuted = false;
		CRUDHandler handler = new CRUDHandler();
		String query = "INSERT INTO PM_IL_BONUS(" +
				"BONUS_CODE," +
				"BONUS_DESC," +
				"BONUS_SHORT_DESC," +
				"BONUS_BL_DESC," +
				"BONUS_BL_SHORT_DESC," +
				"BONUS_YRS," +
				"BONUS_TYPE," +
				"BONUS_CR_DT," +
				"BONUS_CR_UID) VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] values = {bonusBean.getBONUS_CODE(),
				bonusBean.getBONUS_DESC(),
				bonusBean.getBONUS_SHORT_DESC(),
				bonusBean.getBONUS_BL_DESC(),
				bonusBean.getBONUS_BL_SHORT_DESC(),
				bonusBean.getBONUS_YRS(),
				bonusBean.getBONUS_TYPE(),
				bonusBean.getBONUS_CR_DT(),
				bonusBean.getBONUS_CR_UID()};
		try {
//			int result = handler.executeInsertStatement(query, connection, values);
			int result = handler.executeInsert(bonusBean, connection);
			if(result>0)
				isExecuted = true;
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		return isExecuted;
	}
	
	public void deleteBonusMaster(String bonusCode){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String deleteQuery = "DELETE FROM PM_IL_BONUS WHERE BONUS_CODE=?";
		Object[] values = {bonusCode};
		try {
			connection = getConnection();
			int result = handler.executeDeleteStatement(deleteQuery, connection, values);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBonusMaster(PM_IL_BONUS bonusBean) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String updateQuery = "UPDATE PM_IL_BONUS SET " +
				"BONUS_DESC=?, " +
				"BONUS_SHORT_DESC=?, " +
				"BONUS_BL_DESC=?, " +
				"BONUS_BL_SHORT_DESC=?, " +
				"BONUS_YRS=?, " +
				"BONUS_TYPE=?, " +
				"BONUS_UPD_DT=?, " +
				"BONUS_UPD_UID=? " +
						"WHERE BONUS_CODE=?";
		Object[] values = {bonusBean.getBONUS_DESC(), bonusBean.getBONUS_SHORT_DESC(), bonusBean.getBONUS_BL_DESC(), 
				bonusBean.getBONUS_BL_SHORT_DESC(), bonusBean.getBONUS_YRS(), bonusBean.getBONUS_TYPE(), 
				bonusBean.getBONUS_UPD_DT(), bonusBean.getBONUS_UPD_UID(), bonusBean.getBONUS_CODE()};
		try {
			connection = getConnection();
			int result = handler.executeUpdateStatement(updateQuery, connection, values);
			connection.commit();
		} catch (Exception e) {
			throw new Exception(e);
		} 
	}
	
	public List<PM_IL_BONUS> retreiveTableData(PM_IL_BONUS_QUERY bonusQueryBean){
		// [BugId:Fix122 MMuthu 31-Dec-08 getting connection from CommonUtil class getConnection()		
		Connection connection = null;
		try {
			connection = getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
// BugId:Fix122 MMuthu 31-Dec-08 getting connection from CommonUtil class getConnection() ]
		CRUDHandler handler = new CRUDHandler();
		String bonusCode = bonusQueryBean.getBONUS_CODE();
		String bonusTerm = bonusQueryBean.getBONUS_YRS();
		String bonusTypeDescription = bonusQueryBean.getBONUS_TYPE();
		String bonusType = new String();
		if(bonusCode!=null)
			bonusCode += "%";
		if(bonusTerm!=null)
			bonusTerm += "%";
		if(bonusType!=null)
				bonusType += "%";
		String selectQuery = "SELECT BONUS_CODE,BONUS_DESC,BONUS_SHORT_DESC," +
				"BONUS_BL_DESC,BONUS_BL_SHORT_DESC,BONUS_YRS,BONUS_CR_DT,BONUS_CR_UID,BONUS_TYPE,ROWID AS COLUMNROWID " +
				"FROM PM_IL_BONUS " +
				"WHERE BONUS_CODE LIKE NVL(?,BONUS_CODE) " +
				"AND BONUS_YRS LIKE NVL(?,BONUS_YRS) " +
				"AND BONUS_TYPE LIKE NVL(?,BONUS_TYPE)";
		System.out.println(selectQuery);
		System.out.println("bonusCode, , "+ bonusCode + "bonusTerm:" + bonusTerm+"bonusType:"+ bonusType);
		Object[] values = {bonusCode, bonusTerm, bonusType};
		List<PM_IL_BONUS> bonusList = null;
		try {
			ResultSet rst = handler.executeSelectStatement(selectQuery, connection, values);
			bonusList = new ArrayList<PM_IL_BONUS>();
			PM_IL_BONUS bonusBean = null;
			while(rst.next()){
				bonusBean = new PM_IL_BONUS();
				bonusBean.setBONUS_CODE(rst.getString("BONUS_CODE"));
				bonusBean.setBONUS_DESC(rst.getString("BONUS_DESC"));
				bonusBean.setBONUS_SHORT_DESC(rst.getString("BONUS_SHORT_DESC"));
				bonusBean.setBONUS_BL_DESC(rst.getString("BONUS_BL_DESC"));
				bonusBean.setBONUS_BL_SHORT_DESC(rst.getString("BONUS_BL_SHORT_DESC"));
				bonusBean.setBONUS_YRS(rst.getInt("BONUS_YRS"));
				bonusBean.setROWID(rst.getString("COLUMNROWID"));
				bonusBean.setBONUS_CR_DT(rst.getDate("BONUS_CR_DT"));
				bonusBean.setBONUS_CR_UID(rst.getString("BONUS_CR_UID"));
				
				String bonusTypeDesc = ListItemUtil.getListItemDescription(connection, "PILM036", "PM_IL_BONUS", "PM_IL_BONUS.BONUS_TYPE", "IL_BON_TYP", rst.getString("BONUS_TYPE"));
				System.out.println("BonusTypeDesc: ------------ "+bonusTypeDesc);
				//bonusBean.setBONUS_TYPE(bonusTypeDesc);
				bonusBean.setBONUS_TYPE(rst.getString("BONUS_TYPE"));
				bonusList.add(bonusBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return bonusList;
	}
	
	public PM_IL_BONUS getBonusCodeInfo(String bonusCode){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String selectQuery = "SELECT BONUS_CODE,BONUS_DESC,BONUS_SHORT_DESC," +
				"BONUS_BL_DESC,BONUS_BL_SHORT_DESC,BONUS_YRS,BONUS_TYPE " +
				"FROM PM_IL_BONUS " +
				"WHERE BONUS_CODE = ?";
		Object[] values = {bonusCode};
		PM_IL_BONUS bonusBean = null;
		try {
			connection = getConnection();
			ResultSet rst = handler.executeSelectStatement(selectQuery, connection, values);
			
			while(rst.next()){
				bonusBean = new PM_IL_BONUS();
				bonusBean.setBONUS_CODE(rst.getString("BONUS_CODE"));
				bonusBean.setBONUS_DESC(rst.getString("BONUS_DESC"));
				bonusBean.setBONUS_SHORT_DESC(rst.getString("BONUS_SHORT_DESC"));
				bonusBean.setBONUS_BL_DESC(rst.getString("BONUS_BL_DESC"));
				bonusBean.setBONUS_BL_SHORT_DESC(rst.getString("BONUS_BL_SHORT_DESC"));
				bonusBean.setBONUS_YRS(rst.getInt("BONUS_YRS"));
				/** [ BugId:PREMIAGDC-0119 Mallika 11-Mar-09 Bonus Type value assigned to bean*/
				bonusBean.setBONUS_TYPE(rst.getString("BONUS_TYPE"));
				/**  BugId:PREMIAGDC-0119 Mallika 11-Mar-09 bean Changed ]*/
				String bonusTypeDesc = ListItemUtil.getListItemDescription(connection, "PILM036", "PM_IL_BONUS", "PM_IL_BONUS.BONUS_TYPE", "IL_BON_TYP", rst.getString("BONUS_TYPE"));
				bonusBean.setBONUS_TYPE_DESC(bonusTypeDesc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bonusBean;
	}
	
	/**
	 * 
	 * @param userId
	 * @param bonusCode
	 * @return
	 */
	public boolean lDupCheck(String userId,String bonusCode){
		boolean isDup = false;
		String selectQuery = "SELECT * FROM  PM_IL_BONUS  WHERE  BONUS_CODE  = ?";
		Object[] values = {bonusCode};
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(selectQuery, connection, values);
			while(rst.next()){
				isDup = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return isDup;
	}
	
}
