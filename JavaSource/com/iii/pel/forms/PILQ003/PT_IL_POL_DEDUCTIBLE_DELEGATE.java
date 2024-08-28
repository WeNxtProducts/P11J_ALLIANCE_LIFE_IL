package com.iii.pel.forms.PILQ003;
 import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
public class PT_IL_POL_DEDUCTIBLE_DELEGATE { 
public void executeSelectStatement (PILQ003_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN) throws Exception { 
  String selectStatement="SELECT ROWID, PT_IL_POL_DEDUCTIBLE.* FROM PT_IL_POL_DEDUCTIBLE WHERE ";
 Connection connection=null;
 ResultSet resultSet=null;
PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_DEDUCTIBLE_ACTION_BEAN().getDataList_PT_IL_POL_DEDUCTIBLE().clear();
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
 while (resultSet.next()) {
 PT_IL_POL_DEDUCTIBLE PT_IL_POL_DEDUCTIBLE_BEAN = new PT_IL_POL_DEDUCTIBLE();
 PT_IL_POL_DEDUCTIBLE_BEAN.setROWID(resultSet.getString("ROWID"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_SYS_ID(resultSet.getLong("PD_SYS_ID"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_POL_SYS_ID(resultSet.getLong("PD_POL_SYS_ID"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_POAD_SYS_ID(resultSet.getLong("PD_POAD_SYS_ID"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_PAPP_SYS_ID(resultSet.getLong("PD_PAPP_SYS_ID"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_PCG_SYS_ID(resultSet.getLong("PD_PCG_SYS_ID"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_POAC_SYS_ID(resultSet.getLong("PD_POAC_SYS_ID"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_PB_SYS_ID(resultSet.getLong("PD_PB_SYS_ID"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_CODE(resultSet.getString("PD_CODE"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_BNF_CODE(resultSet.getString("PD_BNF_CODE"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_NO_OF_DAYS(resultSet.getDouble("PD_NO_OF_DAYS"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_PERC(resultSet.getDouble("PD_PERC"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_MIN_LC_VAL(resultSet.getDouble("PD_MIN_LC_VAL"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_DEL_FLAG(resultSet.getString("PD_DEL_FLAG"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_CR_UID(resultSet.getString("PD_CR_UID"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_CR_DT(resultSet.getDate("PD_CR_DT"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_UPD_UID(resultSet.getString("PD_UPD_UID"));
PT_IL_POL_DEDUCTIBLE_BEAN.setPD_UPD_DT(resultSet.getDate("PD_UPD_DT"));

PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_DEDUCTIBLE_ACTION_BEAN().getDataList_PT_IL_POL_DEDUCTIBLE().add(PT_IL_POL_DEDUCTIBLE_BEAN);
}
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 

}
