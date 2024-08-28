package com.iii.pel.forms.PILQ003;
 import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
public class PT_IL_POL_COVER_GROUP_1_DELEGATE { 
public void executeSelectStatement (PILQ003_COMPOSITE_ACTION compositeAction) throws Exception { 
  String selectStatement="SELECT ROWID, PT_IL_POL_COVER_GROUP.* FROM PT_IL_POL_COVER_GROUP" +
  		" WHERE PCG_POL_SYS_ID = ?  AND PCG_POAD_SYS_ID = ? AND PCG_PAPP_SYS_ID = ?  ";
 Connection connection=null;
 ResultSet resultSet=null;
 compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN().getDataList_PT_IL_POL_COVER_GROUP_1().clear();
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection,
		 new Object[]{compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN().getPT_IL_POL_APPL_PROD_1_BEAN().getPAPP_POL_SYS_ID(),
		 compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN().getPT_IL_POL_APPL_PROD_1_BEAN().getPAPP_POAD_SYS_ID(),
		 compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN().getPT_IL_POL_APPL_PROD_1_BEAN().getPAPP_SYS_ID()});
 while (resultSet.next()) {
		 PT_IL_POL_COVER_GROUP_1 PT_IL_POL_COVER_GROUP_1_BEAN = new PT_IL_POL_COVER_GROUP_1();
		 PT_IL_POL_COVER_GROUP_1_BEAN.setROWID(resultSet.getString("ROWID"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_SYS_ID(resultSet.getLong("PCG_SYS_ID"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_POL_SYS_ID(resultSet.getLong("PCG_POL_SYS_ID"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_POAD_SYS_ID(resultSet.getLong("PCG_POAD_SYS_ID"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_PAPP_SYS_ID(resultSet.getLong("PCG_PAPP_SYS_ID"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_CODE(resultSet.getString("PCG_CODE"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_RATE(resultSet.getDouble("PCG_RATE"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_RATE_PER(resultSet.getDouble("PCG_RATE_PER"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_FC_PREM(resultSet.getDouble("PCG_FC_PREM"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_LC_PREM(resultSet.getDouble("PCG_LC_PREM"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_ORG_FC_PREM(resultSet.getDouble("PCG_ORG_FC_PREM"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_ORG_LC_PREM(resultSet.getDouble("PCG_ORG_LC_PREM"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_DEL_FLAG(resultSet.getString("PCG_DEL_FLAG"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_CR_DT(resultSet.getDate("PCG_CR_DT"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_CR_UID(resultSet.getString("PCG_CR_UID"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_UPD_DT(resultSet.getDate("PCG_UPD_DT"));
		 PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_UPD_UID(resultSet.getString("PCG_UPD_UID"));

		 compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN().getDataList_PT_IL_POL_COVER_GROUP_1().add(PT_IL_POL_COVER_GROUP_1_BEAN);
}
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 

}
