package com.iii.pel.forms.PILP084_APAC;
 import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;
public class JOBS_SCHD_DELEGATE { 
public void executeSelectStatement (PILP084_APAC_COMPOSITE_ACTION PILP084_APAC_COMPOSITE_ACTION_BEAN) throws Exception { 
  String selectStatement="SELECT ROWID, JOBS_SCHD.* FROM JOBS_SCHD WHERE ";
 Connection connection=null;
 ResultSet resultSet=null;
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
 JOBS_SCHD JOBS_SCHD_BEAN = new JOBS_SCHD();
 while (resultSet.next()) {
JOBS_SCHD_BEAN.setROWID(resultSet.getString("ROWID"));

}
PILP084_APAC_COMPOSITE_ACTION_BEAN.getJOBS_SCHD_ACTION_BEAN().setJOBS_SCHD_BEAN(JOBS_SCHD_BEAN);
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 

}