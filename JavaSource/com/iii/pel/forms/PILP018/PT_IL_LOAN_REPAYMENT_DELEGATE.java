package com.iii.pel.forms.PILP018;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_REPAYMENT_DELEGATE {
    public void executeSelectStatement(
	    PILP018_COMPOSITE_ACTION PILP018_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PT_IL_LOAN_REPAYMENT.* FROM PT_IL_LOAN_REPAYMENT ";
	Connection connection = null;
	ResultSet resultSet = null;
	PILP018_COMPOSITE_ACTION_BEAN.getPT_IL_LOAN_REPAYMENT_ACTION_BEAN()
		.getBeanList().clear();
	PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT =PILP018_COMPOSITE_ACTION_BEAN.getPT_IL_LOAN_REPAYMENT_ACTION_BEAN().getPT_IL_LOAN_REPAYMENT_BEAN();
	try {
	    connection = CommonUtils.getConnection();
	    if(PT_IL_LOAN_REPAYMENT.getM_WHERE()!=null && !PT_IL_LOAN_REPAYMENT.getM_WHERE().isEmpty()){
		selectStatement = selectStatement + " WHERE "+ PT_IL_LOAN_REPAYMENT.getM_WHERE();
	    }
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection);
	    while (resultSet.next()) {
		PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN = new PT_IL_LOAN_REPAYMENT();
		PT_IL_LOAN_REPAYMENT_BEAN
			.setROWID(resultSet.getString("ROWID"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_SYS_ID(resultSet
			.getLong("LR_SYS_ID"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_LOAN_SYS_ID(resultSet
			.getLong("LR_LOAN_SYS_ID"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_PYMT_DT(resultSet
			.getDate("LR_PYMT_DT"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_LC_LOAN_AMT(resultSet
			.getDouble("LR_LC_LOAN_AMT"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_FC_LOAN_AMT(resultSet
			.getDouble("LR_FC_LOAN_AMT"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_STATUS(resultSet
			.getString("LR_STATUS"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_CR_DT(resultSet
			.getDate("LR_CR_DT"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_CR_UID(resultSet
			.getString("LR_CR_UID"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_UPD_DT(resultSet
			.getDate("LR_UPD_DT"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_UPD_UID(resultSet
			.getString("LR_UPD_UID"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_FLAG(resultSet
			.getString("LR_FLAG"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_PYMT_REF_NO(resultSet
			.getString("LR_PYMT_REF_NO"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_FC_INT_AMT(resultSet
			.getDouble("LR_FC_INT_AMT"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_LC_INT_AMT(resultSet
			.getDouble("LR_LC_INT_AMT"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_FC_PYMT_AMT(resultSet
			.getDouble("LR_FC_PYMT_AMT"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_LC_PYMT_AMT(resultSet
			.getDouble("LR_LC_PYMT_AMT"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_REVERSAL_FLAG(resultSet
			.getString("LR_REVERSAL_FLAG"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_DRCR_ACNT_YEAR(resultSet
			.getDouble("LR_DRCR_ACNT_YEAR"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_DRCR_TXN_CODE(resultSet
			.getString("LR_DRCR_TXN_CODE"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_DRCR_DOC_NO(resultSet
			.getDouble("LR_DRCR_DOC_NO"));
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_DRCR_DOC_DT(resultSet
			.getDate("LR_DRCR_DOC_DT"));

		PILP018_COMPOSITE_ACTION_BEAN
			.getPT_IL_LOAN_REPAYMENT_ACTION_BEAN().getBeanList()
			.add(PT_IL_LOAN_REPAYMENT_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}