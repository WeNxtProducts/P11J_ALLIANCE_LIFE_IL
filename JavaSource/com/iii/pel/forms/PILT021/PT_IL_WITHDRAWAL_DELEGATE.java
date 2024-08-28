package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_WITHDRAWAL_DELEGATE {
	public void executeSelectStatement(
			PILT021_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_WITHDRAWAL pt_il_withdrawal = compositeAction
				.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN();
		String selectStatement = "SELECT ROWID, PT_IL_WITHDRAWAL.* FROM PT_IL_WITHDRAWAL WHERE ROWID= ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			/*Modified by Janani on 05.09.2017 for ZBILQC-1727639*/
			System.out.println("getDEFAULT_WHERE            "+compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getDEFAULT_WHERE());
			
			/*if(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getDEFAULT_WHERE() != null)*/
			
			if(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getDEFAULT_WHERE() != null  && 
					!compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getDEFAULT_WHERE().isEmpty())
				
			/*End of ZBILQC-1727639*/	
			{
				selectStatement = selectStatement +" AND "+
					compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getDEFAULT_WHERE();
			}
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { pt_il_withdrawal.getROWID() });
			PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN = new PT_IL_WITHDRAWAL();
			while (resultSet.next()) {
				PT_IL_WITHDRAWAL_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_WITHDRAWAL_BEAN.setWD_SYS_ID(resultSet
						.getLong("WD_SYS_ID"));
				PT_IL_WITHDRAWAL_BEAN.setWD_POL_SYS_ID(resultSet
						.getLong("WD_POL_SYS_ID"));
				PT_IL_WITHDRAWAL_BEAN.setWD_NUMBER(resultSet
						.getInt("WD_NUMBER"));
				PT_IL_WITHDRAWAL_BEAN.setWD_DATE(resultSet.getDate("WD_DATE"));
				PT_IL_WITHDRAWAL_BEAN
						.setWD_RATE(resultSet.getDouble("WD_RATE"));
				if(resultSet.getObject("WD_RATE_PER") != null){
					PT_IL_WITHDRAWAL_BEAN.setWD_RATE_PER(resultSet
							.getDouble("WD_RATE_PER"));
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_RATE_PER(null);
				}
				if(resultSet
						.getObject("WD_GROSS_LC_VALUE") != null){
					PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE(resultSet
							.getDouble("WD_GROSS_LC_VALUE"));
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE(null);
				}
				if(resultSet.getObject("WD_GROSS_FC_VALUE") != null){
					PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE(resultSet
							.getDouble("WD_GROSS_FC_VALUE"));
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE(null);
				}
				if(resultSet
						.getObject("WD_NET_LC_VALUE") != null){
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_LC_VALUE(resultSet
							.getDouble("WD_NET_LC_VALUE"));
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_LC_VALUE(null);
				}
				if(resultSet.getObject("WD_NET_FC_VALUE") != null){
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_FC_VALUE(resultSet
							.getDouble("WD_NET_FC_VALUE") == 0.0 ? null
									: resultSet
									.getDouble("WD_NET_FC_VALUE"));
				/*Added by saritha on 08-03-2018 for Withdrawal Charge Calc Net FC value to set Net LC value*/
						
						PT_IL_WITHDRAWAL_BEAN.setWD_NET_LC_VALUE(resultSet
								.getDouble("WD_NET_FC_VALUE"));
						
				/*End*/
				
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_FC_VALUE(null);
				}
				PT_IL_WITHDRAWAL_BEAN.setWD_APPRV_STATUS(resultSet
						.getString("WD_APPRV_STATUS"));
				PT_IL_WITHDRAWAL_BEAN
						.setWD_CR_DT(resultSet.getDate("WD_CR_DT"));
				PT_IL_WITHDRAWAL_BEAN.setWD_CR_UID(resultSet
						.getString("WD_CR_UID"));
				PT_IL_WITHDRAWAL_BEAN.setWD_UPD_DT(resultSet
						.getDate("WD_UPD_DT"));
				PT_IL_WITHDRAWAL_BEAN.setWD_UPD_UID(resultSet
						.getString("WD_UPD_UID"));
				if(resultSet.getObject("WD_TOPUP_LC_AMT") != null){
				PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_LC_AMT(resultSet
						.getDouble("WD_TOPUP_LC_AMT"));
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_LC_AMT(null);
				}
				if(resultSet.getObject("WD_TOPUP_FC_AMT") != null){
					PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_FC_AMT(resultSet
							.getDouble("WD_TOPUP_FC_AMT"));
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_FC_AMT(null);
				}
				if(resultSet.getObject("WD_TOPUP_INT_LC_AMT") != null){
				PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_INT_LC_AMT(resultSet
						.getDouble("WD_TOPUP_INT_LC_AMT"));
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_INT_LC_AMT(null);
				}
				if(resultSet.getObject("WD_TOPUP_INT_FC_AMT") != null){
				PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_INT_FC_AMT(resultSet
						.getDouble("WD_TOPUP_INT_FC_AMT"));
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_INT_FC_AMT(null);
				}
				PT_IL_WITHDRAWAL_BEAN.setWD_POL_NO(resultSet
						.getString("WD_POL_NO"));
				PT_IL_WITHDRAWAL_BEAN.setWD_AMOUNT_YN(resultSet
						.getString("WD_AMOUNT_YN"));
				PT_IL_WITHDRAWAL_BEAN
						.setWD_TYPE(resultSet.getString("WD_TYPE"));
				PT_IL_WITHDRAWAL_BEAN.setWD_STATUS_CODE(resultSet
						.getString("WD_STATUS_CODE"));
				PT_IL_WITHDRAWAL_BEAN.setWD_STATUS_DT(resultSet
						.getDate("WD_STATUS_DT"));
				PT_IL_WITHDRAWAL_BEAN.setWD_REASON_CODE(resultSet
						.getString("WD_REASON_CODE"));
				PT_IL_WITHDRAWAL_BEAN.setWD_REMARKS(resultSet
						.getString("WD_REMARKS"));
				PT_IL_WITHDRAWAL_BEAN.setWD_PREM_TXN_CODE(resultSet
						.getString("WD_PREM_TXN_CODE"));
				PT_IL_WITHDRAWAL_BEAN.setWD_PREM_DOC_NO(resultSet
						.getLong("WD_PREM_DOC_NO"));
				PT_IL_WITHDRAWAL_BEAN.setWD_TOP_UP_TXN_CODE(resultSet
						.getString("WD_TOP_UP_TXN_CODE"));
				PT_IL_WITHDRAWAL_BEAN.setWD_TOP_UP_DOC_NO(resultSet
						.getLong("WD_TOP_UP_DOC_NO"));
				PT_IL_WITHDRAWAL_BEAN.setWD_DOC_DT(resultSet
						.getDate("WD_DOC_DT"));
				if(resultSet.getObject("WD_NET_TOP_UP_FC_VALUE") != null){
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_TOP_UP_FC_VALUE(resultSet
							.getDouble("WD_NET_TOP_UP_FC_VALUE"));
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_TOP_UP_FC_VALUE(null);
				}
				if(resultSet.getObject("WD_NET_TOP_UP_LC_VALUE") != null){
				PT_IL_WITHDRAWAL_BEAN.setWD_NET_TOP_UP_LC_VALUE(resultSet
						.getDouble("WD_NET_TOP_UP_LC_VALUE"));
				}else{
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_TOP_UP_LC_VALUE(null);
				}
				PT_IL_WITHDRAWAL_BEAN.setWD_FULL_YN(resultSet
						.getString("WD_FULL_YN"));
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_01(resultSet
						.getString("WD_FLEX_01"));
				PT_IL_WITHDRAWAL_BEAN
						.setWD_AMT1(resultSet.getDouble("WD_AMT1"));
				PT_IL_WITHDRAWAL_BEAN.setWD_APPRV_UID(resultSet
						.getString("WD_APPRV_UID"));
				PT_IL_WITHDRAWAL_BEAN.setWD_APPRV_DT(resultSet
						.getDate("WD_APPRV_DT"));
				PT_IL_WITHDRAWAL_BEAN.setWD_DOC_NO(resultSet
						.getString("WD_DOC_NO"));
				PT_IL_WITHDRAWAL_BEAN.setWD_PAY_TO(resultSet
						.getString("WD_PAY_TO"));
				PT_IL_WITHDRAWAL_BEAN.setUI_M_POL_NO(resultSet
						.getString("WD_POL_NO"));
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_04(resultSet.getString("WD_FLEX_04"));
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_05(resultSet.getString("WD_FLEX_05"));
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_06(resultSet.getString("WD_FLEX_06"));
				/*Added by Ameen on 01-12-2017 for ZBLIFE-1458892*/
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_07(resultSet.getString("WD_FLEX_07"));
				if(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_07()!=null){
					String bankNameQry = "SELECT BANK_NAME FROM FM_BANK WHERE BANK_CODE=?";
					ResultSet bankNameRS = null;
					bankNameRS = new CRUDHandler().executeSelectStatement(bankNameQry, connection,new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_07()});
					if(bankNameRS.next()){
						PT_IL_WITHDRAWAL_BEAN.setUI_M_BANK_NAME(bankNameRS.getString("BANK_NAME"));
					}
				}
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_08(resultSet.getString("WD_FLEX_08"));
				if(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_08()!=null){
					String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
					ResultSet sortCodeRS = null;
					sortCodeRS = new CRUDHandler().executeSelectStatement(sortCodeQry, connection,new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_07(),PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_08()});
					if(sortCodeRS.next()){
						PT_IL_WITHDRAWAL_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
					}
				}
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_09(resultSet.getString("WD_FLEX_09"));
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_10(resultSet.getString("WD_FLEX_10"));
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_11(resultSet.getString("WD_FLEX_11"));
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_12(resultSet.getString("WD_FLEX_12"));
				/*End*/
				
				/*Newly Field Added by saritha on 25-Jan-2018*/  
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_03(resultSet.getString("WD_FLEX_03"));
				/*End*/	
				/*Added by ganesh on 09-04-2018 for freeze flag value*/
				PT_IL_WITHDRAWAL_BEAN.setWD_FRZ_FLAG(resultSet.getString("WD_FRZ_FLAG"));
				PT_IL_WITHDRAWAL_BEAN.setWD_APPR_DATE_STR(CommonUtils.dateToPELStringFormatter(resultSet.getDate("WD_APPRV_DT")));
				PT_IL_WITHDRAWAL_BEAN.setWD_CR_DATE_STR(CommonUtils.dateToPELStringFormatter(resultSet.getDate("WD_CR_DT")));
				/*end*/
			}
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
					.setPT_IL_WITHDRAWAL_BEAN(PT_IL_WITHDRAWAL_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public Date truncDate(Date date) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String selectStatement = null;
		try {
			selectStatement = "select TRUNC(?) from dual";
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { date });
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return date;
	}
}
