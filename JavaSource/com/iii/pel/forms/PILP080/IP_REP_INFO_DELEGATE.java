package com.iii.pel.forms.PILP080;
 import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;
public class IP_REP_INFO_DELEGATE { 
public void executeSelectStatement (PILP080_COMPOSITE_ACTION PILP080_COMPOSITE_ACTION_BEAN) throws Exception { 
  String selectStatement="SELECT ROWID, IP_REP_INFO.* FROM IP_REP_INFO WHERE ";
 Connection connection=null;
 ResultSet resultSet=null;
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
 IP_REP_INFO IP_REP_INFO_BEAN = new IP_REP_INFO();
 while (resultSet.next()) {
IP_REP_INFO_BEAN.setROWID(resultSet.getString("ROWID"));

}
PILP080_COMPOSITE_ACTION_BEAN.getIP_REP_INFO_ACTION_BEAN().setIP_REP_INFO_BEAN(IP_REP_INFO_BEAN);
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 

}