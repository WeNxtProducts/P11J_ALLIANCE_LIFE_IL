package com.iii.pel.forms.PILM204;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ConnectionAgent;
public class PM_IL_FORMULA_PARAM_DELEGATE { 
	public void executeSelectStatement (PM_IL_FORMULA_COMPOSITEBEAN compositeAction)
	throws Exception { 
		String selectStatement="SELECT ROWID, PM_IL_FORMULA_PARAM.* FROM PM_IL_FORMULA_PARAM";
		Connection connection=null;
		ResultSet resultSet=null;
		compositeAction.getPM_IL_FORMULA_PARAM_ACTION_BEAN().getDataList_PM_IL_FORMULA_PARAM().clear();
		try {
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
			while (resultSet.next()) {
				PM_IL_FORMULA_PARAM PM_IL_FORMULA_PARAM_BEAN = new PM_IL_FORMULA_PARAM();
				PM_IL_FORMULA_PARAM_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_SRNO(resultSet.getInt("FP_SRNO"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_CAPTION(resultSet.getString("FP_CAPTION"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_BL_CAPTION(resultSet.getString("FP_BL_CAPTION"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_COL_NAME(resultSet.getString("FP_COL_NAME"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_DATA_TYPE(resultSet.getString("FP_DATA_TYPE"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_TABLE_NAME(resultSet.getString("FP_TABLE_NAME"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_WHERE_CLAUSE(resultSet.getString("FP_WHERE_CLAUSE"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_CR_DT(resultSet.getDate("FP_cr_dt"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_CR_UID(resultSet.getString("FP_cr_uid"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_UPD_DT(resultSet.getDate("FP_upd_dt"));
				PM_IL_FORMULA_PARAM_BEAN.setFP_UPD_UID(resultSet.getString("FP_upd_uid"));
				
				compositeAction.getPM_IL_FORMULA_PARAM_ACTION_BEAN().
				getDataList_PM_IL_FORMULA_PARAM().add(PM_IL_FORMULA_PARAM_BEAN);
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
			
			queryString = "SELECT  LIV_CODE,LIV_CODE_DESC " +
			"FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM " +
			"AND LI_MODULE_NAME = '{0}' AND LI_BLOCK_NAME = '{1}' AND LI_ITEM_NAME = '{2}'";
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
		String selectStatement="SELECT MAX(FP_SRNO) FROM PM_IL_FORMULA_PARAM";
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
