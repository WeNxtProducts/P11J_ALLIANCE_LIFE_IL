package com.iii.pel.forms.PILP080;
 import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;
public class PT_IL_MEDEX_FEE_DTL_DELEGATE { 
public void executeSelectStatement (PILP080_COMPOSITE_ACTION PILP080_COMPOSITE_ACTION_BEAN) throws Exception { 
  String selectStatement="SELECT ROWID, PT_IL_MEDEX_FEE_DTL.* FROM PT_IL_MEDEX_FEE_DTL WHERE ";
 Connection connection=null;
 ResultSet resultSet=null;
PILP080_COMPOSITE_ACTION_BEAN.getPT_IL_MEDEX_FEE_DTL_ACTION_BEAN().getDataList_PT_IL_MEDEX_FEE_DTL().clear();
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
 while (resultSet.next()) {
 PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_BEAN = new PT_IL_MEDEX_FEE_DTL();
 PT_IL_MEDEX_FEE_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_SYS_ID(resultSet.getLong("MFD_SYS_ID"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POL_SYS_ID(resultSet.getLong("MFD_POL_SYS_ID"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POAD_SYS_ID(resultSet.getLong("MFD_POAD_SYS_ID"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CLINIC_CODE(resultSet.getString("MFD_CLINIC_CODE"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CUST_CODE(resultSet.getString("MFD_CUST_CODE"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POL_NO(resultSet.getString("MFD_POL_NO"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_PROP_NO(resultSet.getString("MFD_PROP_NO"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_POL_CONT_CODE(resultSet.getString("MFD_POL_CONT_CODE"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_EXAM_CODE(resultSet.getString("MFD_EXAM_CODE"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_EXAM_DT(resultSet.getDate("MFD_EXAM_DT"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CURR_CODE(resultSet.getString("MFD_CURR_CODE"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FC_VALUE(resultSet.getDouble("MFD_FC_VALUE"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_LC_VALUE(resultSet.getDouble("MFD_LC_VALUE"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_PYMT_TO(resultSet.getString("MFD_PYMT_TO"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_INV_REF_NO(resultSet.getString("MFD_INV_REF_NO"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_PAID_FLAG(resultSet.getString("MFD_PAID_FLAG"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_FRZ_FLAG(resultSet.getString("MFD_FRZ_FLAG"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_REMARKS(resultSet.getString("MFD_REMARKS"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_ACNT_TXN_CODE(resultSet.getString("MFD_ACNT_TXN_CODE"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_ACNT_DOC_NO(resultSet.getDouble("MFD_ACNT_DOC_NO"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_ACNT_DOC_DT(resultSet.getDate("MFD_ACNT_DOC_DT"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_DT(resultSet.getDate("MFD_CR_DT"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_CR_UID(resultSet.getString("MFD_CR_UID"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_UPD_DT(resultSet.getDate("MFD_UPD_DT"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_UPD_UID(resultSet.getString("MFD_UPD_UID"));
PT_IL_MEDEX_FEE_DTL_BEAN.setMFD_END_NO_IDX(resultSet.getDouble("MFD_END_NO_IDX"));

PILP080_COMPOSITE_ACTION_BEAN.getPT_IL_MEDEX_FEE_DTL_ACTION_BEAN().getDataList_PT_IL_MEDEX_FEE_DTL().add(PT_IL_MEDEX_FEE_DTL_BEAN);
}
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 

}