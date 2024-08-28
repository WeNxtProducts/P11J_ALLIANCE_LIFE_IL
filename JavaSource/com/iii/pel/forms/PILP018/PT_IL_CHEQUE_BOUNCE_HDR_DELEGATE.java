package com.iii.pel.forms.PILP018;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CHEQUE_BOUNCE_HDR_DELEGATE {
    public void executeSelectStatement(
	    PILP018_COMPOSITE_ACTION PILP018_COMPOSITE_ACTION_BEAN)
	    throws Exception {
	String selectStatement = "SELECT ROWID, PT_IL_CHEQUE_BOUNCE_HDR.* FROM PT_IL_CHEQUE_BOUNCE_HDR  ";
	Connection connection = null;
	ResultSet resultSet = null;
	PILP018_COMPOSITE_ACTION_BEAN.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN()
		.getBeanList().clear();
	try {
	    connection = CommonUtils.getConnection();
	    
	    if(PILP018_COMPOSITE_ACTION_BEAN.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().getM_WHERE()!=null){
		selectStatement = selectStatement + "  WHERE  " +PILP018_COMPOSITE_ACTION_BEAN.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().getM_WHERE();
	    }
	    
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection);
	    while (resultSet.next()) {
		PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN = new PT_IL_CHEQUE_BOUNCE_HDR();
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setROWID(resultSet
			.getString("ROWID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_SYS_ID(resultSet
			.getLong("CBH_SYS_ID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LR_SYS_ID(resultSet
			.getLong("CBH_LR_SYS_ID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_PD_SYS_ID(resultSet
			.getLong("CBH_PD_SYS_ID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_DEP_SYS_ID(resultSet
			.getLong("CBH_DEP_SYS_ID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_PC_SYS_ID(resultSet
			.getLong("CBH_PC_SYS_ID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_SYS_ID(resultSet
			.getLong("CBH_POL_SYS_ID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_TXN_SYS_ID(resultSet
			.getLong("CBH_TXN_SYS_ID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_TXN_TYPE(resultSet
			.getString("CBH_TXN_TYPE"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_NO(resultSet
			.getString("CBH_POL_NO"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_CONT_NAME(resultSet
			.getString("CBH_POL_CONT_NAME"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_ISSUE_DT(resultSet
			.getDate("CBH_POL_ISSUE_DT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_START_DT(resultSet
			.getDate("CBH_POL_START_DT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_EXPIRY_DT(resultSet
			.getDate("CBH_POL_EXPIRY_DT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_POL_PROD_CODE(resultSet
			.getString("CBH_POL_PROD_CODE"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_PC_SCHD_PYMT_DT(resultSet
			.getDate("CBH_PC_SCHD_PYMT_DT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN
			.setCBH_PC_FC_AVLB_BAL_AMT(resultSet
				.getDouble("CBH_PC_FC_AVLB_BAL_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN
			.setCBH_PC_LC_AVLB_BAL_AMT(resultSet
				.getDouble("CBH_PC_LC_AVLB_BAL_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_PC_FC_PAID_AMT(resultSet
			.getDouble("CBH_PC_FC_PAID_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_PC_LC_PAID_AMT(resultSet
			.getDouble("CBH_PC_LC_PAID_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_FC_NET_PREM(resultSet
			.getDouble("CBH_FC_NET_PREM"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LC_NET_PREM(resultSet
			.getDouble("CBH_LC_NET_PREM"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LOAN_REF_NO(resultSet
			.getString("CBH_LOAN_REF_NO"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LOAN_DT(resultSet
			.getDate("CBH_LOAN_DT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LR_PYMT_DT(resultSet
			.getDate("CBH_LR_PYMT_DT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LR_FC_PYMT_AMT(resultSet
			.getDouble("CBH_LR_FC_PYMT_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LR_LC_PYMT_AMT(resultSet
			.getDouble("CBH_LR_LC_PYMT_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LR_LC_LOAN_AMT(resultSet
			.getDouble("CBH_LR_LC_LOAN_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LR_FC_LOAN_AMT(resultSet
			.getDouble("CBH_LR_FC_LOAN_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LR_LC_INT_AMT(resultSet
			.getDouble("CBH_LR_LC_INT_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_LR_FC_INT_AMT(resultSet
			.getDouble("CBH_LR_FC_INT_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_DEP_REF_ID(resultSet
			.getString("CBH_DEP_REF_ID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_DEP_FC_AMT(resultSet
			.getDouble("CBH_DEP_FC_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_DEP_LC_AMT(resultSet
			.getDouble("CBH_DEP_LC_AMT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_REASON_CODE(resultSet
			.getString("CBH_REASON_CODE"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_REMARKS(resultSet
			.getString("CBH_REMARKS"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_DRCR_ACNT_YEAR(resultSet
			.getDouble("CBH_DRCR_ACNT_YEAR"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_DRCR_TXN_CODE(resultSet
			.getString("CBH_DRCR_TXN_CODE"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_DRCR_DOC_NO(resultSet
			.getDouble("CBH_DRCR_DOC_NO"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_DRCR_DOC_DT(resultSet
			.getDate("CBH_DRCR_DOC_DT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_REVERSE_YN(resultSet
			.getString("CBH_REVERSE_YN"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_CR_DT(resultSet
			.getDate("CBH_CR_DT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_CR_UID(resultSet
			.getString("CBH_CR_UID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_UPD_DT(resultSet
			.getDate("CBH_UPD_DT"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_UPD_UID(resultSet
			.getString("CBH_UPD_UID"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_CHQ_NO(resultSet
			.getString("CBH_CHQ_NO"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_BANK_CODE(resultSet
			.getString("CBH_BANK_CODE"));
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setCBH_RH_CONTROL_NO(resultSet
			.getString("CBH_RH_CONTROL_NO"));

		PILP018_COMPOSITE_ACTION_BEAN
			.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN()
			.getBeanList().add(
				PT_IL_CHEQUE_BOUNCE_HDR_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }

}