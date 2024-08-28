package com.iii.pel.forms.PILP080;
 import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT018.CompositeAction;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;
public class PT_IL_POL_MED_EXAM_DTL_DELEGATE { 
public void executeSelectStatement (PILP080_COMPOSITE_ACTION PILP080_COMPOSITE_ACTION_BEAN) throws Exception { 
	 String M_WHERE=PILP080_COMPOSITE_ACTION_BEAN.getDUMMY_ACTION_BEAN().getM_WHERE1();
		String selectStatement="SELECT ROWID, PT_IL_POL_MED_EXAM_DTL.* FROM PT_IL_POL_MED_EXAM_DTL WHERE "+ M_WHERE;
	 
	//String selectStatement="SELECT ROWID, PT_IL_POL_MED_EXAM_DTL.* FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID=?";
 Connection connection=null;
 ResultSet resultSet=null;
PILP080_COMPOSITE_ACTION_BEAN.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().getDataList_PT_IL_POL_MED_EXAM_DTL().clear();
 try {
connection=CommonUtils.getConnection();
 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
 while (resultSet.next()) {
 PT_IL_POL_MED_EXAM_DTL PT_IL_POL_MED_EXAM_DTL_BEAN = new PT_IL_POL_MED_EXAM_DTL();
 PT_IL_POL_MED_EXAM_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_SYS_ID(resultSet.getLong("PMED_SYS_ID"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_POL_SYS_ID(resultSet.getLong("PMED_POL_SYS_ID"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_END_NO_IDX(resultSet.getDouble("PMED_END_NO_IDX"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_POAD_SYS_ID(resultSet.getLong("PMED_POAD_SYS_ID"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_EXAM_CODE(resultSet.getString("PMED_EXAM_CODE"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_STATUS(resultSet.getString("PMED_STATUS"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CR_DT(resultSet.getDate("PMED_CR_DT"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CR_UID(resultSet.getString("PMED_CR_UID"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_UPD_DT(resultSet.getDate("PMED_UPD_DT"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_UPD_UID(resultSet.getString("PMED_UPD_UID"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CLINIC_CODE(resultSet.getString("PMED_CLINIC_CODE"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_PVT_LC_AMT(resultSet.getDouble("PMED_PVT_LC_AMT"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_GOVT_LC_AMT(resultSet.getDouble("PMED_GOVT_LC_AMT"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_REP_REC_DT(resultSet.getDate("PMED_REP_REC_DT"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_DEL_FLAG(resultSet.getString("PMED_DEL_FLAG"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_INVOICE_NO(resultSet.getString("PMED_INVOICE_NO"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_FLEX_03(resultSet.getString("PMED_FLEX_03"));
//PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_MEDICAL_FEES(resultSet.getDouble("PMED_MEDICAL_FEES"));
PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_EXAM_DT(resultSet.getDate("PMED_EXAM_DT"));
setMedicalFees(PT_IL_POL_MED_EXAM_DTL_BEAN);
PILP080_COMPOSITE_ACTION_BEAN.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().getDataList_PT_IL_POL_MED_EXAM_DTL().add(PT_IL_POL_MED_EXAM_DTL_BEAN);
}
 } 
 finally { 
 CommonUtils.closeCursor(resultSet);
} 
} 
public void setMedicalFees(PT_IL_POL_MED_EXAM_DTL PT_IL_POL_MED_EXAM_DTL_BEAN){

	if(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_GOVT_LC_AMT()>0){
		PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_MEDICAL_FEES(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_GOVT_LC_AMT());
		
	}else{
		PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_MEDICAL_FEES(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_PVT_LC_AMT());

	}
		
	
}
}