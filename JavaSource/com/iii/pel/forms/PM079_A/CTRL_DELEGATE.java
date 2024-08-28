package com.iii.pel.forms.PM079_A;
 import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;
public class CTRL_DELEGATE { 
public void executeSelectStatement (PM079_A_COMPOSITE_ACTION PM079_A_COMPOSITE_ACTION_BEAN) throws Exception { 
  String selectStatement="SELECT ROWID, CTRL.* FROM CTRL WHERE ";
 Connection connection=null;
 ResultSet resultSet=null;
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
 CTRL CTRL_BEAN = new CTRL();
 while (resultSet.next()) {
CTRL_BEAN.setROWID(resultSet.getString("ROWID"));

}
PM079_A_COMPOSITE_ACTION_BEAN.getCTRL_ACTION_BEAN().setCTRL_BEAN(CTRL_BEAN);
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 

}