package com.iii.pel.forms.PILP075;

import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_CANC_REFN_DELEGATE 
{

	public void executeQuery(PILP075_COMPOSITE_ACTION compositeAction) throws Exception 
	{
		ResultSet resultSet = null;
		try {
			
			 PT_IL_POL_CANC_REFN PT_IL_POL_CANC_REFN_BEAN  = new PT_IL_POL_CANC_REFN();
			String FETCH_QUERY = "SELECT PT_IL_POL_CANC_REFN.*,PT_IL_POL_CANC_REFN.ROWID FROM PT_IL_POL_CANC_REFN WHERE ROWID = ? ";	
		
			System.out.println("ROWID   : "+compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().getPT_IL_POL_CANC_REFN_BEAN().getROWID());
			
			resultSet = new CRUDHandler().executeSelectStatement(FETCH_QUERY, CommonUtils.getConnection(),
					new Object[] {
				compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().getPT_IL_POL_CANC_REFN_BEAN().getROWID()
				});
			if (resultSet.next()) {
	
			PT_IL_POL_CANC_REFN_BEAN.setPCF_POL_NO(resultSet.getString("PCF_POL_NO"));
			
			/*Modified  by Ram on 27/11/2016 for Displaying values in 3 decimal point
			 * 
			 * PT_IL_POL_CANC_REFN_BEAN.setPCF_DOC_FEE_LC(resultSet.getDouble("PCF_DOC_FEE_LC"));*/
			PT_IL_POL_CANC_REFN_BEAN.setPCF_DOC_FEE_LC(resultSet.getString("PCF_DOC_FEE_LC"));
			/*End*/
			PT_IL_POL_CANC_REFN_BEAN.setPCF_MED_FEE_LC(resultSet.getDouble("PCF_MED_FEE_LC"));
			
			/*PT_IL_POL_CANC_REFN_BEAN.setPCF_MEI_REF_FC(resultSet.getDouble("PCF_MEI_REF_FC"));*/
			PT_IL_POL_CANC_REFN_BEAN.setPCF_MEI_REF_FC(resultSet.getString("PCF_MEI_REF_FC"));
			
			PT_IL_POL_CANC_REFN_BEAN.setPCF_MONT_ELAP(resultSet.getInt("PCF_MONT_ELAP"));
			/*Modified  by Ram on 27/11/2016 for Displaying values in 3 decimal point
			 * 
			 * PT_IL_POL_CANC_REFN_BEAN.setPCF_PAID_PREM_LC(resultSet.getDouble("PCF_PAID_PREM_LC"));*/
			
			PT_IL_POL_CANC_REFN_BEAN.setPCF_PAID_PREM_LC(resultSet.getString("PCF_PAID_PREM_LC"));
			
			/*End*/
			PT_IL_POL_CANC_REFN_BEAN.setPCF_POL_CONT_CODE(resultSet.getString("PCF_POL_CONT_CODE"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_POL_ISSUE_DT(resultSet.getDate("PCF_POL_ISSUE_DT"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_POL_SYS_ID(resultSet.getInt("PCF_POL_SYS_ID"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_REFUND_DATE(resultSet.getDate("PCF_REFUND_DATE"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_07(resultSet.getString("pCF_FLEX_07"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_08(resultSet.getString("pCF_FLEX_08"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_09(resultSet.getString("pCF_FLEX_09"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_11(resultSet.getDouble("PCF_FLEX_11"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_12(resultSet.getString("pCF_FLEX_12"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_SYS_ID(resultSet.getInt("PCF_SYS_ID"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_CR_UID(resultSet.getString("PCF_CR_UID"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_CR_DT(resultSet.getDate("PCF_CR_DT"));
			System.out.println("ROWID   : "+resultSet.getString("ROWID"));
			PT_IL_POL_CANC_REFN_BEAN.setROWID(resultSet.getString("ROWID"));
			PT_IL_POL_CANC_REFN_BEAN.setPCF_FLEX_01(resultSet.getString("PCF_FLEX_01"));
			
			/*Newly added below code on 1.3.2017 by Dhinesh*/
			PT_IL_POL_CANC_REFN_BEAN.setPCF_COMM_LC_RFND(Double.parseDouble(CommonUtils.Decimal_Convert(resultSet.getString("PCF_COMM_LC_RFND"))));
			/*End*/
			
			CommonUtils.setGlobalVariable("GLOBAL:ROWID", resultSet.getString("ROWID"));
			compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().setPT_IL_POL_CANC_REFN_BEAN(PT_IL_POL_CANC_REFN_BEAN);
			}
			//compositeAction.getPT_IL_POL_CANC_REFN_ACTION_BEAN().setPT_IL_POL_CANC_REFN_BEAN(PT_IL_POL_CANC_REFN_BEAN);
			} catch (Exception e) 
		{

		e.printStackTrace();
		}
		
	}
}
