package com.iii.pel.forms.PILT002_APAC;
 import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
public class PT_IL_POL_SUB_BENEFIT_DELEGATE { 
public void executeSelectStatement (PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN) throws Exception { 
  String selectStatement="SELECT ROWID, PT_IL_POL_SUB_BENEFIT.* FROM PT_IL_POL_SUB_BENEFIT WHERE ";
 Connection connection=null;
 ResultSet resultSet=null;
PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_SUB_BENEFIT_ACTION_BEAN().getDataList_PT_IL_POL_SUB_BENEFIT().clear();
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
 while (resultSet.next()) {
 PT_IL_POL_SUB_BENEFIT PT_IL_POL_SUB_BENEFIT_BEAN = new PT_IL_POL_SUB_BENEFIT();
 PT_IL_POL_SUB_BENEFIT_BEAN.setROWID(resultSet.getString("ROWID"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_SYS_ID(resultSet.getLong("PSB_SYS_ID"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_POL_SYS_ID(resultSet.getLong("PSB_POL_SYS_ID"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_POAD_SYS_ID(resultSet.getLong("PSB_POAD_SYS_ID"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_PAPP_SYS_ID(resultSet.getLong("PSB_PAPP_SYS_ID"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_PCG_SYS_ID(resultSet.getLong("PSB_PCG_SYS_ID"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_POAC_SYS_ID(resultSet.getLong("PSB_POAC_SYS_ID"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_PB_SYS_ID(resultSet.getLong("PSB_PB_SYS_ID"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_CODE(resultSet.getString("PSB_CODE"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_BNF_CODE(resultSet.getString("PSB_BNF_CODE"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_LIMIT_TYPE(resultSet.getString("PSB_LIMIT_TYPE"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_PER_DAY_LC_AMT(resultSet.getDouble("PSB_PER_DAY_LC_AMT"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_LIMIT_DAYS(resultSet.getDouble("PSB_LIMIT_DAYS"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_LC_LIMIT(resultSet.getDouble("PSB_LC_LIMIT"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_ORG_LC_LIMIT(resultSet.getDouble("PSB_ORG_LC_LIMIT"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_DEL_FLAG(resultSet.getString("PSB_DEL_FLAG"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_CR_UID(resultSet.getString("PSB_CR_UID"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_CR_DT(resultSet.getDate("PSB_CR_DT"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_UPD_UID(resultSet.getString("PSB_UPD_UID"));
PT_IL_POL_SUB_BENEFIT_BEAN.setPSB_UPD_DT(resultSet.getDate("PSB_UPD_DT"));

PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_SUB_BENEFIT_ACTION_BEAN().getDataList_PT_IL_POL_SUB_BENEFIT().add(PT_IL_POL_SUB_BENEFIT_BEAN);
}
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 

}
