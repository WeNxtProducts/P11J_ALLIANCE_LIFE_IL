package com.iii.pel.forms.PILQ003;
 import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
public class PT_IL_POL_BENEFIT_DELEGATE { 
public void executeSelectStatement (PILQ003_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN) throws Exception { 
  String selectStatement="SELECT ROWID, PT_IL_POL_BENEFIT.* FROM PT_IL_POL_BENEFIT WHERE ";
 Connection connection=null;
 ResultSet resultSet=null;
PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_BENEFIT_ACTION_BEAN().getDataList_PT_IL_POL_BENEFIT().clear();
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
 while (resultSet.next()) {
 PT_IL_POL_BENEFIT PT_IL_POL_BENEFIT_BEAN = new PT_IL_POL_BENEFIT();
 PT_IL_POL_BENEFIT_BEAN.setROWID(resultSet.getString("ROWID"));
PT_IL_POL_BENEFIT_BEAN.setPB_SYS_ID(resultSet.getLong("PB_SYS_ID"));
PT_IL_POL_BENEFIT_BEAN.setPB_POL_SYS_ID(resultSet.getLong("PB_POL_SYS_ID"));
PT_IL_POL_BENEFIT_BEAN.setPB_POAD_SYS_ID(resultSet.getLong("PB_POAD_SYS_ID"));
PT_IL_POL_BENEFIT_BEAN.setPB_PAPP_SYS_ID(resultSet.getLong("PB_PAPP_SYS_ID"));
PT_IL_POL_BENEFIT_BEAN.setPB_PCG_SYS_ID(resultSet.getLong("PB_PCG_SYS_ID"));
PT_IL_POL_BENEFIT_BEAN.setPB_POAC_SYS_ID(resultSet.getLong("PB_POAC_SYS_ID"));
PT_IL_POL_BENEFIT_BEAN.setPB_BNF_CODE(resultSet.getString("PB_BNF_CODE"));
PT_IL_POL_BENEFIT_BEAN.setPB_LIMIT_TYPE(resultSet.getString("PB_LIMIT_TYPE"));
PT_IL_POL_BENEFIT_BEAN.setPB_PER_DAY_LC_AMT(resultSet.getDouble("PB_PER_DAY_LC_AMT"));
PT_IL_POL_BENEFIT_BEAN.setPB_LIMIT_DAYS(resultSet.getDouble("PB_LIMIT_DAYS"));
PT_IL_POL_BENEFIT_BEAN.setPB_LC_LIMIT(resultSet.getDouble("PB_LC_LIMIT"));
PT_IL_POL_BENEFIT_BEAN.setPB_ORG_LC_LIMIT(resultSet.getDouble("PB_ORG_LC_LIMIT"));
PT_IL_POL_BENEFIT_BEAN.setPB_DEL_FLAG(resultSet.getString("PB_DEL_FLAG"));
PT_IL_POL_BENEFIT_BEAN.setPB_CR_UID(resultSet.getString("PB_CR_UID"));
PT_IL_POL_BENEFIT_BEAN.setPB_CR_DT(resultSet.getDate("PB_CR_DT"));
PT_IL_POL_BENEFIT_BEAN.setPB_UPD_UID(resultSet.getString("PB_UPD_UID"));
PT_IL_POL_BENEFIT_BEAN.setPB_UPD_DT(resultSet.getDate("PB_UPD_DT"));

PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_BENEFIT_ACTION_BEAN().getDataList_PT_IL_POL_BENEFIT().add(PT_IL_POL_BENEFIT_BEAN);
}
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 

}
