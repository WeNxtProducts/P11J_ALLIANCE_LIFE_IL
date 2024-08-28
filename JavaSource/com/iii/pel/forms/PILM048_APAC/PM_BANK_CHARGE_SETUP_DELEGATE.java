package com.iii.pel.forms.PILM048_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_BANK_CHARGE_SETUP_DELEGATE {

	public ArrayList<PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN> fetchSearchValue(
			PM_BANK_CHARGE_SETUP_HDRSEARCHACTION action) {

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String bankCode = "";
		String chargeCode = "";
		ArrayList<PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN> listItem = null;
		PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN listItemBean = null;

		
		try {
			Connection connection = CommonUtils.getConnection();
			if(action.getCOMP_BCSH_BANK_CODE().getSubmittedValue() != null && action.getCOMP_BCSH_CHG_CODE().getSubmittedValue() != null){
				bankCode =  action.getCOMP_BCSH_BANK_CODE().getSubmittedValue().toString()+"%";
				chargeCode =  action.getCOMP_BCSH_CHG_CODE().getSubmittedValue().toString()+"%";
			}
			String query = PM_BANK_CHARGE_SETUP_QUERY_CONSTANT.FETCH_SERCH_LIST ;
			Object[] values = {bankCode,chargeCode};
			resultSet = handler.executeSelectStatement(query, connection,values);

			if(resultSet != null) {
				listItem = new ArrayList<PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN>();
				
				while(resultSet.next()){
					listItemBean = new PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN();
					listItemBean.setBCSH_BANK_CODE(resultSet.getString(1));
					listItemBean.setBCSH_CHG_CODE(resultSet.getString(2));
					listItemBean.setBCSH_MAIN_ACNT_CODE(resultSet.getString(3));
					listItemBean.setBCSH_SUB_ACNT_CODE(resultSet.getString(4));
					listItemBean.setBCSH_DIVN_CODE(resultSet.getString(5));
					listItemBean.setBCSH_DEPT_CODE(resultSet.getString(6));
					listItemBean.setRowId(resultSet.getString(7));
					listItem.add(listItemBean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listItem;
	}
	
	/**
	 * 
	 * @param rowId
	 * @return
	 */
	public PM_BANK_CHARGE_SETUP_HDR loadBankChargesDts(PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN) {

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String bankCode = "";
		String chargeCode = "";
		
		try {
			Connection connection = CommonUtils.getConnection();
		
			String query = "SELECT ROWID,PM_BANK_CHARGE_SETUP_HDR.* FROM PM_BANK_CHARGE_SETUP_HDR WHERE ROWID=? " ;
			resultSet = handler.executeSelectStatement(query, connection,new Object[]{PM_BANK_CHARGE_SETUP_HDR_BEAN.getROWID()});

			if(resultSet != null) {
				while(resultSet.next()){
					//PM_BANK_CHARGE_SETUP_HDR_BEAN = new PM_BANK_CHARGE_SETUP_HDR();
					
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setROWID(resultSet.getString("ROWID"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_BANK_CODE(resultSet.getString("BCSH_BANK_CODE"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_PAY_MODE(resultSet.getString("BCSH_PAY_MODE"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_PAY_FOR(resultSet.getString("BCSH_PAY_FOR"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CHG_CODE(resultSet.getString("BCSH_CHG_CODE"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CHG_APPLIED_ON(resultSet.getString("BCSH_CHG_APPLIED_ON"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CHG_AC_DOC_MODE(resultSet.getString("BCSH_CHG_AC_DOC_MODE"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_PROD_CODE_FM(resultSet.getString("BCSH_PROD_CODE_FM"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_PROD_CODE_TO(resultSet.getString("BCSH_PROD_CODE_TO"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_MAIN_ACNT_CODE(resultSet.getString("BCSH_MAIN_ACNT_CODE"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_SUB_ACNT_CODE(resultSet.getString("BCSH_SUB_ACNT_CODE"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_DIVN_CODE(resultSet.getString("BCSH_DIVN_CODE"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_DEPT_CODE(resultSet.getString("BCSH_DEPT_CODE"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_ANLY_CODE_1(resultSet.getString("BCSH_ANLY_CODE_1"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_ANLY_CODE_2(resultSet.getString("BCSH_ANLY_CODE_2"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_ACTY_CODE_1(resultSet.getString("BCSH_ACTY_CODE_1"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_ACTY_CODE_2(resultSet.getString("BCSH_ACTY_CODE_2"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_TRAN_TYPE(resultSet.getString("BCSH_TRAN_TYPE"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CUST_SHARE_PERC(resultSet.getInt("BCSH_CUST_SHARE_PERC"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_SYS_ID(resultSet.getDouble("BCSH_SYS_ID"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_FRZ_FLAG(resultSet.getString("BCSH_FRZ_FLAG"));
					/*PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CUST_SHARE_PERC(resultSet.getString("BCSH_CUST_SHARE_PERC"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CUST_SHARE_PERC(resultSet.getString("BCSH_CUST_SHARE_PERC"));
					PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CUST_SHARE_PERC(resultSet.getString("BCSH_CUST_SHARE_PERC"));*/
					
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return PM_BANK_CHARGE_SETUP_HDR_BEAN;
	}

}
