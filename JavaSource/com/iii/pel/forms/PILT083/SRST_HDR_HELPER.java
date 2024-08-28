package com.iii.pel.forms.PILT083;

import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class SRST_HDR_HELPER {

	private SRST_HDR_DELEGATE delegate;
	public SRST_HDR_HELPER(){
	delegate=new SRST_HDR_DELEGATE();	
	}
	
	public void executeSelectStatement(PILT083_COMPOSITE_ACTION compositeAction) throws Exception{

		delegate.executeSelectStatement(compositeAction);
	 	 List<SRST_HDR> dataList = compositeAction.
		getSRST_HDR_ACTION_BEAN().getBeanList();
		 if(dataList!=null && dataList.size() > 0){
			SRST_HDR SRST_HDR_BEAN = dataList.get(0);
			SRST_HDR_BEAN.setRowSelected(true);
			compositeAction.getSRST_HDR_ACTION_BEAN().setSRST_HDR_BEAN(SRST_HDR_BEAN);
		} 
		
	}

	public void PRE_INSERT(PILT083_COMPOSITE_ACTION compositeAction) throws Exception{
		ResultSet resultSet=null;
		try{
		String query="Select P_SRST_SYS_ID.nextval from dual";
		resultSet=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
		if(resultSet.next()){
			compositeAction.getSRST_HDR_ACTION_BEAN().getSRST_HDR_BEAN().setSRST_SYS_ID(resultSet.getLong(1));
		}
		}catch (Exception e) {
		e.printStackTrace();
		throw e ;
		}finally{
		CommonUtils.closeCursor(resultSet);	
		}
		
	}

	public void WhenValidateSRST_POL_NO(PILT083_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet resultSet=null;
		try{
		String query="select A.pol_cust_code , B.cust_name ,c.prod_desc from pt_il_policy A ," +
				" pm_customer B, pm_il_product C where A.POL_NO=?" +
				" and  a.pol_prod_code=c.prod_code and a.pol_cust_code=b.cust_code";
		resultSet=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
				new Object[]{compositeAction.getSRST_HDR_ACTION_BEAN()
			.getSRST_HDR_BEAN().getSRST_POL_NO()});
		if(resultSet.next()){
			compositeAction.getSRST_HDR_ACTION_BEAN().getSRST_HDR_BEAN().setSRST_POL_CUST_CODE(resultSet.getString(1));
			compositeAction.getSRST_HDR_ACTION_BEAN().getSRST_HDR_BEAN().setSRST_POL_CUST_NAME(resultSet.getString(2));
			compositeAction.getSRST_HDR_ACTION_BEAN().getSRST_HDR_BEAN().setSRST_POL_PROD_NAME(resultSet.getString(3));
		}else{
			throw new Exception("Invalid Policy Code .Please Re-Enter "); 
		}
		}catch (Exception e) {
		e.printStackTrace();
		throw e ;
		}finally{
		CommonUtils.closeCursor(resultSet);	
		}
		
	}

}
