package com.iii.pel.forms.PILQ106_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_UNIT_FUND_REG_DELEGATE {
	public void executeSelectStatement(
			PILQ106_APAC_COMPOSITE_ACTION PILQ106_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		Object[] values = null;
		String selectStatement = "SELECT ROWID, PS_IL_UNIT_FUND_REG.* FROM " +
				" PS_IL_UNIT_FUND_REG WHERE UFR_POL_SYS_ID=?";
		Connection connection = null;
		ResultSet resultSet = null;
		PILQ106_APAC_COMPOSITE_ACTION_BEAN.getPS_IL_UNIT_FUND_REG_ACTION_BEAN()
				.getDataList_PS_IL_UNIT_FUND_REG().clear();
		try {
			connection = CommonUtils.getConnection();
			//Comment and Modified by rakesh on 16-11-2019 for orient fund allocation query issue
			/*values = new Object[]{PILQ106_APAC_COMPOSITE_ACTION_BEAN
					.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN()
					.getPT_IL_UNIT_FUND_REG_HDR_BEAN().getUFRH_POL_SYS_ID()};*/
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{CommonUtils.getGlobalObject("FUND_ALLOC_REG_POL_SYS_ID").toString()});
			while (resultSet.next()) {
				PS_IL_UNIT_FUND_REG PS_IL_UNIT_FUND_REG_BEAN = new PS_IL_UNIT_FUND_REG();
				PS_IL_UNIT_FUND_REG_BEAN.setROWID(resultSet.getString("ROWID"));
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_POL_NO(resultSet
						.getString("UFR_POL_NO"));
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_POL_SYS_ID(resultSet
						.getLong("UFR_POL_SYS_ID"));
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_FUND_CODE(resultSet
						.getString("UFR_FUND_CODE"));
				/*
				 * modified BY AMEEN ON 15-07-2017 FOR ZBILQC-1727874
				 * PS_IL_UNIT_FUND_REG_BEAN.setUFR_NO_OF_UNITS(CommonUtils.ROUND(resultSet
						.getDouble("UFR_NO_OF_UNITS"),2));*/
				/*if condition handled by Ameen on 20-06-2018 for KIC to display negative value based on PROD_NGTV_SUS_YN from product master*/
				/*PS_IL_UNIT_FUND_REG_BEAN.setUFR_NO_OF_UNITS(Decimal_Convert(resultSet
						.getDouble("UFR_NO_OF_UNITS"),3));*/
				ResultSet rs = new CRUDHandler().executeSelectStatement("SELECT PROD_NGTV_SUS_YN FROM PM_IL_PRODUCT WHERE PROD_CODE = ?", CommonUtils.getConnection(),
						new Object[]{PILQ106_APAC_COMPOSITE_ACTION_BEAN.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getPROD_CODE()});
				String negSuspense = "";
				if(rs.next()){
					negSuspense = rs.getString("PROD_NGTV_SUS_YN");
				}
				if("Y".equalsIgnoreCase(negSuspense)){
					PS_IL_UNIT_FUND_REG_BEAN.setUFR_NO_OF_UNITS(negDecimal_Convert(resultSet
							.getDouble("UFR_NO_OF_UNITS"),3));
				}else{
					PS_IL_UNIT_FUND_REG_BEAN.setUFR_NO_OF_UNITS(Decimal_Convert(resultSet
							.getDouble("UFR_NO_OF_UNITS"),3));
				}
				/*End*/
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_UPD_TRAN(resultSet
						.getString("UFR_UPD_TRAN"));
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_CR_UID(resultSet
						.getString("UFR_CR_UID"));
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_CR_DT(resultSet
						.getDate("UFR_CR_DT"));
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_UPD_UID(resultSet
						.getString("UFR_UPD_UID"));
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_UPD_DT(resultSet
						.getDate("UFR_UPD_DT"));
				/*
				 * modified BY AMEEN ON 15-07-2017 FOR ZBILQC-1727874
				 * PS_IL_UNIT_FUND_REG_BEAN.setUFR_TOP_UP_UNITS(resultSet
						.getDouble("UFR_TOP_UP_UNITS"));
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_PREM_UNITS(CommonUtils.ROUND(resultSet
						.getDouble("UFR_PREM_UNITS"),2));*/
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_TOP_UP_UNITS(Decimal_Convert(resultSet
						.getDouble("UFR_TOP_UP_UNITS"),3));
				PS_IL_UNIT_FUND_REG_BEAN.setUFR_PREM_UNITS(Decimal_Convert(resultSet
						.getDouble("UFR_PREM_UNITS"),3));
				/*Added by Sivarajan on 17/11/2019 for sarwa IL*/
				new PS_IL_UNIT_FUND_REG_HELPER().postQuery(PS_IL_UNIT_FUND_REG_BEAN,PILQ106_APAC_COMPOSITE_ACTION_BEAN);
				/*End*/
				PILQ106_APAC_COMPOSITE_ACTION_BEAN
						.getPS_IL_UNIT_FUND_REG_ACTION_BEAN()
						.getDataList_PS_IL_UNIT_FUND_REG().add(
								PS_IL_UNIT_FUND_REG_BEAN);
			}
		}
		catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		    throw new Exception(e.getMessage());
		}finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	 /*added BY AMEEN ON 15-07-2017 FOR ZBILQC-1727874*/
	public Double Decimal_Convert(Double Value, int customDeciamlValue)
			throws DBException, Exception {

		System.out.println(" Decimal_Convert  value  :  " + Value);
		if (Value != null && Value > 0) {

			System.out.println("decimalPlaces   : " + customDeciamlValue);

			BigDecimal bd = new BigDecimal(Value);
			bd = bd.setScale(customDeciamlValue, BigDecimal.ROUND_HALF_UP);

			return bd.doubleValue();
		} else {

			return 0.0;
		}
	}
	/*End*/
	
	/*Added by Ameen on 20-06-2018 for KIC to display negative*/
	public Double negDecimal_Convert(Double Value, int customDeciamlValue)
			throws DBException, Exception {

		System.out.println(" Decimal_Convert  value  :  " + Value);
		if (Value != null) {

			System.out.println("decimalPlaces   : " + customDeciamlValue);

			BigDecimal bd = new BigDecimal(Value);
			bd = bd.setScale(customDeciamlValue, BigDecimal.ROUND_HALF_UP);

			return bd.doubleValue();
		} else {

			return 0.0;
		}
	}
	/*End*/
	
}
