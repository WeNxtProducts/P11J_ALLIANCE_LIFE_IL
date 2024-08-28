package com.iii.pel.forms.PILM012;
 import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;
public class CTRL1_DELEGATE { 
public void executeSelectStatement (PILM012_COMPOSITE_ACTION PILM012_COMPOSITE_ACTION_BEAN) throws Exception { 
  String selectStatement="SELECT ROWID, CTRL1.* FROM CTRL1 WHERE ";
 Connection connection=null;
 ResultSet resultSet=null;
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
 CTRL1 CTRL1_BEAN = new CTRL1();
 while (resultSet.next()) {
CTRL1_BEAN.setROWID(resultSet.getString("ROWID"));

}
PILM012_COMPOSITE_ACTION_BEAN.getCTRL1_ACTION_BEAN().setCTRL1_BEAN(CTRL1_BEAN);
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 

}