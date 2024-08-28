package com.iii.pel.forms.PQ123;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PV_POL_QUERY_DELEGATE {

	public List getCustomerCodeValues(String customerCode) {
		String selectQuery = null;
		List<DUMMY> customerList = new ArrayList<DUMMY>();
		Connection connection = null;
		if ("*".equalsIgnoreCase(customerCode)) {
			selectQuery = "SELECT CUST_CODE,CUST_NAME " + " FROM  PM_CUSTOMER "
					+ " WHERE  CUST_CLASS IN "
					+ "(SELECT CCLAS_CODE FROM PM_CUST_CLASS)"
					+ " AND CUST_FRZ_FLAG = 'N' ";
		} else {

			selectQuery = " SELECT CUST_CODE, CUST_NAME" + " FROM PM_CUSTOMER "
					+ " WHERE  CUST_CLASS IN "
					+ " (SELECT CCLAS_CODE FROM PM_CUST_CLASS)"
					+ " AND CUST_FRZ_FLAG = 'N' "
					+ " AND UPPER(CUST_CODE) LIKE '"
					+ customerCode.toUpperCase() + "%'";

		}

		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection);
			while (resultSet.next()) {
				DUMMY dummy = new DUMMY();
//				PV_POL_QUERY pv_pol_query = new PV_POL_QUERY();
				dummy.setCUST_CODE(resultSet.getString(1));
				dummy.setCUST_DESC(resultSet.getString(2));
				customerList.add(dummy);
			}

		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return customerList;
	}
	
		

	
	public String getDescription(String customerCode,List list){
		Iterator iterator = list.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			DUMMY  pv_pol_query = (DUMMY) iterator
					.next();
			if (customerCode.equalsIgnoreCase(pv_pol_query.getCUST_CODE())) {
				codedesc = pv_pol_query.getCUST_DESC();
			}
		}
		return codedesc;
		
		
		
	}
	/**
	 * 
	 * @param custCode
	 * @return
	 * @throws Exception
	 */
	public List<PV_POL_QUERY> fetchPolicyDetails(String custCode) throws Exception{
		List<PV_POL_QUERY> policyList = new ArrayList<PV_POL_QUERY>();
		Connection connection=null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler(); 
		System.out.println("cust code is : "+custCode);
		String query ="SELECT PC.* " +
				" FROM PV_POL_QUERY PC " +
				" WHERE PC.POL_CUST_CODE = '"+custCode+"'";
		try{
		connection=CommonUtils.getConnection();
		System.out.println(query);
		resultSet = handler.executeSelectStatement(query, connection);
		
		while(resultSet.next()){
			
			PV_POL_QUERY pv_pol_query = new PV_POL_QUERY();
			
			pv_pol_query.setPOL_NO(resultSet.getString("POL_NO"));
			pv_pol_query.setPOL_ISSUE_DT(resultSet.getDate("POL_ISSUE_DT"));
			pv_pol_query.setPOL_LC_SUM_ASSURED(resultSet.getDouble("POL_LC_SUM_ASSURED"));
			pv_pol_query.setPOL_LC_PREM(resultSet.getString("POL_LC_PREM"));
			pv_pol_query.setPOL_EXPIRY_DT(resultSet.getDate("POL_EXPIRY_DT"));
			pv_pol_query.setPOL_APPRV_STATUS(resultSet.getString("POL_APPRV_STATUS"));
			pv_pol_query.setPOL_SYS_ID(resultSet.getDouble("POL_SYS_ID"));
			pv_pol_query.setPOL_MODULE(resultSet.getString("POL_MODULE"));
			policyList.add(pv_pol_query);
		}
		
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		
		return policyList;
	}
	
	/**
	 * 
	 * @param compositeAction
	 * @param pv_pol_query
	 * @return
	 */
	public PM_CUSTOMER customerDetails(PV_POL_QUERY_COMPOSITE compositeAction,PV_POL_QUERY pv_pol_query) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		System.out.println("CUST CODE IS :"+compositeAction.getDUMMY_ACTION().getDUMMY_BEAN().getCUST_CODE());
		String query = "SELECT ROWID,CUST_CLASS,CUST_NAME,CUST_ADDR1,CUST_PHONE,CUST_ADDR2,CUST_FAX,CUST_ADDR3" +
				" FROM PM_CUSTOMER WHERE CUST_CODE ='"+ compositeAction.getDUMMY_ACTION().getDUMMY_BEAN().getCUST_CODE()+ "'";
		PM_CUSTOMER pm_customer = new PM_CUSTOMER();
			try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				pm_customer.setROWID(resultSet.getString("ROWID"));
				pm_customer.setCUST_CLASS(resultSet.getString("CUST_CLASS"));
				pm_customer.setCUST_NAME(resultSet.getString("CUST_NAME"));
				pm_customer.setCUST_ADDR1(resultSet.getString("CUST_ADDR1"));
				pm_customer.setCUST_PHONE(resultSet.getDouble("CUST_PHONE"));
				pm_customer.setCUST_ADDR2(resultSet.getString("CUST_ADDR2"));
				pm_customer.setCUST_FAX(resultSet.getDouble("CUST_FAX"));
				pm_customer.setCUST_ADDR3(resultSet.getString("CUST_ADDR3"));
				/*pm_customer.setTOTAL_LC_SI(resultSet.getDouble("TOTAL_LC_SI"));
				pm_customer.setTOTAL_CLAIM_EST(resultSet
						.getDouble("TOTAL_CLAIM_EST"));
				pm_customer.setTOTAL_LC_PREM(resultSet
						.getDouble("TOTAL_LC_PREM"));
				pm_customer.setTOTAL_CLAIM_PAID(resultSet
						.getDouble("TOTAL_CLAIM_PAID"));*/
//				pm_customer.setLOSS_RATIO(resultSet.getString("LOSS_RATIO"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pm_customer;
	}
	
	public Object facInDetails(PV_POL_QUERY pv_pol_query) {
		Connection connection = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM PV_FAC_IN_QUERY  WHERE FI_POL_SYS_ID =? ";
		PV_FAC_IN_QUERY pv_fac_in_query = new PV_FAC_IN_QUERY();
		System.out.println("fAC POLICY SYS ID :"+pv_pol_query.getPOL_SYS_ID());
		try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Object value[] = { pv_pol_query.getPOL_SYS_ID() };
			resultSet = handler
					.executeSelectStatement(query, connection, value);
			while (resultSet.next()) {
				System.out.println("Fac in Details");
//				pv_fac_in_query.setROWID(resultSet.getString("ROWID"));
				pv_fac_in_query
						.setORGI_LC_SI(resultSet.getDouble("ORGI_LC_SI"));
				pv_fac_in_query
						.setORGI_FC_SI(resultSet.getDouble("ORGI_FC_SI"));
				pv_fac_in_query.setORGI_LC_PREMIUM(resultSet
						.getDouble("ORGI_LC_PREMIUM"));
				pv_fac_in_query.setORGI_FC_PREMIUM(resultSet
						.getDouble("ORGI_FC_PREMIUM"));
				pv_fac_in_query.setOUR_SHARE_PER(resultSet
						.getDouble("OUR_SHARE_PER"));
				pv_fac_in_query.setOUR_SHARE_LC_SI(resultSet
						.getDouble("OUR_SHARE_LC_SI"));
				pv_fac_in_query.setOUR_SHARE_FC_SI(resultSet
						.getDouble("OUR_SHARE_FC_SI"));
				pv_fac_in_query.setOUR_SHARE_PREM_LC(resultSet
						.getDouble("OUR_SHARE_PREM_LC"));
				pv_fac_in_query.setOUR_SHARE_PREM_FC(resultSet
						.getDouble("OUR_SHARE_PREM_FC"));
				pv_fac_in_query.setCOMMISSION_PAID_LC(resultSet
						.getDouble("COMMISSION_PAID_LC"));
				pv_fac_in_query.setCOMMISSION_PAID_FC(resultSet
						.getDouble("COMMISSION_PAID_FC"));
				pv_fac_in_query.setTAX_PAID_LC(resultSet
						.getDouble("TAX_PAID_LC"));
				pv_fac_in_query.setTAX_PAID_FC(resultSet
						.getDouble("TAX_PAID_FC"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pv_fac_in_query;

	}
	
	/**
	 * 
	 * @param pv_pol_query
	 * @return
	 * @throws Exception
	 */
	public List claimDetails(PV_POL_QUERY  pv_pol_query) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		List<PV_CLM_QUERY> list = new ArrayList<PV_CLM_QUERY>();
		System.out.println("CLAIMS POLICY SYS ID :"+pv_pol_query.getPOL_SYS_ID());
		String query = "SELECT CLM_NO,CLM_EST_AMT,CLM_PAID_AMT  FROM PV_CLM_QUERY  WHERE CLM_POL_SYS_ID =? ";
		try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Object value[]={pv_pol_query.getPOL_SYS_ID()};
			resultSet = handler.executeSelectStatement(query, connection,value);
			while (resultSet.next()) {
				PV_CLM_QUERY  pv_clm_query = new PV_CLM_QUERY();
//				pv_clm_query.setROWID(resultSet.getString("ROWID"));
				pv_clm_query.setCLM_NO(resultSet.getString("CLM_NO"));
				pv_clm_query.setCLM_EST_AMT(resultSet.getDouble("CLM_EST_AMT"));
//				pv_clm_query.setCLM_OS_AMT(resultSet.getDouble("CLM_OS_AMT"));
				pv_clm_query.setCLM_PAID_AMT(resultSet.getDouble("CLM_PAID_AMT"));
				list.add(pv_clm_query);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	
	
}
