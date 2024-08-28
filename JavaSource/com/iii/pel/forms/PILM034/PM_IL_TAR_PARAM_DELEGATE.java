package com.iii.pel.forms.PILM034;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ConnectionAgent;
public class PM_IL_TAR_PARAM_DELEGATE { 
	public void executeSelectStatement (PILM034_COMPOSITE_ACTION PILM034_COMPOSITE_ACTION_BEAN)
	throws Exception { 
		String selectStatement="SELECT ROWID, PM_IL_TAR_PARAM.* FROM PM_IL_TAR_PARAM";
		Connection connection=null;
		ResultSet resultSet=null;
		PILM034_COMPOSITE_ACTION_BEAN.getPM_IL_TAR_PARAM_ACTION_BEAN().getDataList_PM_IL_TAR_PARAM().clear();
		try {
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
			while (resultSet.next()) {
				PM_IL_TAR_PARAM PM_IL_TAR_PARAM_BEAN = new PM_IL_TAR_PARAM();
				PM_IL_TAR_PARAM_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_TAR_PARAM_BEAN.setTP_SRNO(resultSet.getInt("TP_SRNO"));
				PM_IL_TAR_PARAM_BEAN.setTP_CAPTION(resultSet.getString("TP_CAPTION"));
				PM_IL_TAR_PARAM_BEAN.setTP_BL_CAPTION(resultSet.getString("TP_BL_CAPTION"));
				PM_IL_TAR_PARAM_BEAN.setTP_COL_NAME(resultSet.getString("TP_COL_NAME"));
				PM_IL_TAR_PARAM_BEAN.setTP_DATA_TYPE(resultSet.getString("TP_DATA_TYPE"));
				PM_IL_TAR_PARAM_BEAN.setTP_TABLE_NAME(resultSet.getString("TP_TABLE_NAME"));
				PM_IL_TAR_PARAM_BEAN.setTP_WHERE_CLAUSE(resultSet.getString("TP_WHERE_CLAUSE"));
				PM_IL_TAR_PARAM_BEAN.setTP_CR_DT(resultSet.getDate("tp_cr_dt"));
				PM_IL_TAR_PARAM_BEAN.setTP_CR_UID(resultSet.getString("tp_cr_uid"));
				PM_IL_TAR_PARAM_BEAN.setTP_UPD_DT(resultSet.getDate("tp_upd_dt"));
				PM_IL_TAR_PARAM_BEAN.setTP_UPD_UID(resultSet.getString("tp_upd_uid"));
				
				PILM034_COMPOSITE_ACTION_BEAN.getPM_IL_TAR_PARAM_ACTION_BEAN().
				getDataList_PM_IL_TAR_PARAM().add(PM_IL_TAR_PARAM_BEAN);
			}
		} 
		finally { 
			CommonUtils.closeCursor(resultSet);
		} 
	} 
	public ArrayList<SelectItem> selectValueForComboBox(String formName, String blockName, String fieldName) {
		Connection con = null;
		ConnectionAgent agent = null;
		ResultSet resultSet=null;
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;
		Object value[]={}; 
		try {
			agent = new ConnectionAgent();
			con = agent.getConnection();
			CRUDHandler handler = new CRUDHandler();
			
			queryString = PILM034_QUERYCONSTANTS.PM_IL_TAR_PARAM_SelectDrpDwnValues;
			queryString = queryString.replace("{0}", formName);
			queryString = queryString.replace("{1}", blockName);
			queryString = queryString.replace("{2}", fieldName);
			
			resultSet = handler.executeSelectStatement(queryString, con, value);
			
			drpDwn = new ArrayList<SelectItem>();
			while(resultSet.next()){
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;		
	} 
	public int fetchSRNO(){
		int srno = 0;
		String selectStatement="SELECT MAX(TP_SRNO) FROM PM_IL_TAR_PARAM";
		Connection connection=null;
		ResultSet resultSet=null;
		try{
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
			while (resultSet.next()) {
				srno = resultSet.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return srno;
	}
}
