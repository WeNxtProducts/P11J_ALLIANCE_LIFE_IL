package com.iii.pel.forms.PILT013;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_BONUS_DELEGATE {
	public void executeSelectStatement(
			PILT013_COMPOSITE_ACTION PILT013_COMPOSITE_ACTION_BEAN)
			throws Exception {
		//PT_IL_POLICY pt_il_policy_bean = PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		/*String selectStatement = "SELECT ROWID, PT_IL_BONUS.* FROM PT_IL_BONUS WHERE BON_POL_SYS_ID = ? AND  NVL(BON_PAID_YN,'N') IN ('N','P')";*/
		String selectStatement = " SELECT ROWID, PT_IL_BONUS.* FROM PT_IL_BONUS WHERE BON_REF_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_BONUS_ACTION_BEAN()
				.getDataList_PT_IL_BONUS().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILT013_COMPOSITE_ACTION_BEAN.
							getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID()
							});
			while (resultSet.next()) {
				PT_IL_BONUS PT_IL_BONUS_BEAN = new PT_IL_BONUS();
				PT_IL_BONUS_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_BONUS_BEAN.setBON_SYS_ID(resultSet.getLong("BON_SYS_ID"));
				PT_IL_BONUS_BEAN.setBON_POL_SYS_ID(resultSet
						.getLong("BON_POL_SYS_ID"));
				PT_IL_BONUS_BEAN.setBON_REF_TYPE(resultSet
						.getString("BON_REF_TYPE"));
				PT_IL_BONUS_BEAN.setBON_REF_SYS_ID(resultSet
						.getLong("BON_REF_SYS_ID"));
				PT_IL_BONUS_BEAN.setBON_BONUS_CODE(resultSet
						.getString("BON_BONUS_CODE"));
				/*******************   Newly added by dhinesh on 2.3.2017 ***********************/
				PT_IL_BONUS_BEAN.setUI_BON_BONUS_DESC(getBONUS_DESC(resultSet
						.getString("BON_BONUS_CODE")));
				/************************* End *********************************/
				PT_IL_BONUS_BEAN.setBON_FC_BONUS_AMT(resultSet
						.getDouble("BON_FC_BONUS_AMT"));
				PT_IL_BONUS_BEAN.setBON_LC_BONUS_AMT(resultSet
						.getDouble("BON_LC_BONUS_AMT"));
				/*Added By Jagadeesh for the ssp Call ID: FALCONQC-1715538*/
				String BON_FC_BONUS_AMT=PT_IL_BONUS_BEAN.getBON_FC_BONUS_AMT().toString();
				String BON_LC_BONUS_AMT=PT_IL_BONUS_BEAN.getBON_LC_BONUS_AMT().toString();
				PT_IL_BONUS_BEAN.setUI_BON_FC_BONUS_AMT(CommonUtils.Decimal_Convert(BON_FC_BONUS_AMT));
				PT_IL_BONUS_BEAN.setUI_BON_LC_BONUS_AMT(CommonUtils.Decimal_Convert(BON_LC_BONUS_AMT));
				/*End*/
				PT_IL_BONUS_BEAN.setBON_CR_DT(resultSet.getDate("BON_CR_DT"));
				PT_IL_BONUS_BEAN.setBON_CR_UID(resultSet
						.getString("BON_CR_UID"));
				PT_IL_BONUS_BEAN.setBON_UPD_DT(resultSet.getDate("BON_UPD_DT"));
				PT_IL_BONUS_BEAN.setBON_UPD_UID(resultSet
						.getString("BON_UPD_UID"));
				PT_IL_BONUS_BEAN.setBON_PAID_YN(resultSet
						.getString("BON_PAID_YN"));
				PT_IL_BONUS_BEAN.setBON_YEAR(resultSet.getDouble("BON_YEAR"));
				PT_IL_BONUS_BEAN.setBON_POST_YN(resultSet
						.getString("BON_POST_YN"));
				PT_IL_BONUS_BEAN.setBON_TXN_CODE(resultSet
						.getString("BON_TXN_CODE"));
				PT_IL_BONUS_BEAN.setBON_DOC_NO(resultSet
						.getDouble("BON_DOC_NO"));
				PT_IL_BONUS_BEAN.setBON_ACNT_YEAR(resultSet
						.getDouble("BON_ACNT_YEAR"));
				PT_IL_BONUS_BEAN.setBON_CN_YN(resultSet.getString("BON_CN_YN"));
				PT_IL_BONUS_BEAN.setBON_PV_YN(resultSet.getString("BON_PV_YN"));
				PT_IL_BONUS_BEAN.setBON_PAY_TO(resultSet
						.getString("BON_PAY_TO"));

				PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_BONUS_ACTION_BEAN()
						.getDataList_PT_IL_BONUS().add(PT_IL_BONUS_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	/*Added By Jagadeesh for the ssp Call ID: FALCONQC-1715538*/
	public String Decimal_Convert(String Value)
	{
		if(Value != null)
		{
		int decimalPlaces=0;
		System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
		 decimalPlaces=Integer.parseInt(CommonUtils.getGlobalObject("CURRENCY").toString());//(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
		System.out.println("decimalPlaces   : "+decimalPlaces);
		
		
		BigDecimal bd = new BigDecimal(Value);
	    bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);
	    
	    return bd.toString();
		}
		else
		{
			return "0.000";
		}
	}
	/*End*/
	
/*******************   Newly added by dhinesh on 2.3.2017 ***********************/
	
	public String getBONUS_DESC(String CODE)
			throws Exception {
		ResultSet resultSet = null;
		String BONUS_DESC="";
		
		try {
			
			String C1 =" SELECT BONUS_DESC FROM PM_IL_BONUS WHERE BONUS_CODE = ?";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection(),new Object[] { CODE });
			if (resultSet.next()) {
				BONUS_DESC=resultSet.getString("BONUS_DESC");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return BONUS_DESC;

	}

	/************************* End *********************************/

}
