package com.iii.pel.forms.PILP080;
 import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;
public class PT_IL_MED_VOUC_LOG_DELEGATE { 
public void executeSelectStatement (PILP080_COMPOSITE_ACTION PILP080_COMPOSITE_ACTION_BEAN) throws Exception { 
  String selectStatement="SELECT ROWID, PT_IL_MED_VOUC_LOG.* FROM PT_IL_MED_VOUC_LOG WHERE ";
 Connection connection=null;
 ResultSet resultSet=null;
PILP080_COMPOSITE_ACTION_BEAN.getPT_IL_MED_VOUC_LOG_ACTION_BEAN().getDataList_PT_IL_MED_VOUC_LOG().clear();
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
 while (resultSet.next()) {
 PT_IL_MED_VOUC_LOG PT_IL_MED_VOUC_LOG_BEAN = new PT_IL_MED_VOUC_LOG();
 PT_IL_MED_VOUC_LOG_BEAN.setROWID(resultSet.getString("ROWID"));

PILP080_COMPOSITE_ACTION_BEAN.getPT_IL_MED_VOUC_LOG_ACTION_BEAN().getDataList_PT_IL_MED_VOUC_LOG().add(PT_IL_MED_VOUC_LOG_BEAN);
}
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 

}