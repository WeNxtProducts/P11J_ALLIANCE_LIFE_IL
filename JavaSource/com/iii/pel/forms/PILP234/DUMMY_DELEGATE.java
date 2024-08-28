package com.iii.pel.forms.PILP234;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_DELEGATE {

	public List<DUMMY> getListForFM_TO_PROD_CODE(String filterString) {
		
		ResultSet result=null;
		Connection connection=null;
		
		List<DUMMY> lovList=new ArrayList();
		StringBuffer queryString=new StringBuffer();
		CRUDHandler handler=new CRUDHandler();
		
		Object[] values={PILP234_SQLQUERY_CONSTANTS.FETCH_ROW_COUNT};
		queryString.append(PILP234_SQLQUERY_CONSTANTS.LOV_FM_TO_PROD_CODE);
		
		if(!filterString.equals("*")){
			queryString.append(" AND UPPER(PROD_CODE) LIKE"+
			"'"+filterString.toUpperCase()+"%'");
		}
		try {
			connection=CommonUtils.getConnection();
			result=handler.executeSelectStatement(queryString.toString(), connection,values);
				while(result.next()){
					DUMMY tempBean=new DUMMY();
					tempBean.setUI_M_FM_PROD_CODE(result.getString("PROD_CODE"));
					tempBean.setUI_M_TO_PROD_CODE(result.getString("PROD_CODE"));
					tempBean.setUI_M_FM_PROD_DESC(result.getString("PROD_DESC"));
					tempBean.setUI_M_TO_PROD_DESC(result.getString("PROD_DESC"));
					lovList.add(tempBean);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lovList;
	}
	
	public List<DUMMY> getListForFM_TO_PROP_NO(String filterString, DUMMY_ACTION actionBean) {
		
		ResultSet result=null;
		Connection connection=null;
		
		String mappedBeanName="PILP021_DUMMY_ACTION";
		List<DUMMY> lovList=new ArrayList();
		StringBuffer queryString=new StringBuffer();
		CRUDHandler handler=new CRUDHandler();
		
		queryString.append(PILP234_SQLQUERY_CONSTANTS.LOV_FM_TO_PROP_NO);
		
		if(!filterString.equals("*")){
			queryString.append(" AND UPPER(POL_NO) LIKE"+
			"'"+filterString.toUpperCase()+"%'");
		}
		try {
			//DUMMY_ACTION actionBean=(DUMMY_ACTION)new CommonUtils().getMappedBeanFromSession(mappedBeanName);
			Date fromDate =actionBean.getDUMMY_BEAN().getUI_M_FM_DT();
			Date toDate=actionBean.getDUMMY_BEAN().getUI_M_TO_DT();
			DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(" Formatted Date :"+format.format(fromDate));
			Object[] values={format.format(fromDate).toString(),format.format(toDate).toString(),PILP234_SQLQUERY_CONSTANTS.FETCH_ROW_COUNT};
		
			System.out.println(fromDate+"   "+toDate);
			connection=CommonUtils.getConnection();
			result=handler.executeSelectStatement(queryString.toString(), connection,values);
				while(result.next()){
					DUMMY tempBean=new DUMMY();
					tempBean.setUI_M_FM_PROP_NO(result.getString("POL_NO"));
					tempBean.setUI_M_TO_PROP_NO(result.getString("POL_NO"));
					tempBean.setPOL_ASSURED_NAME(result.getString("POL_ASSURED_NAME"));
					lovList.add(tempBean);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lovList;
	}
}
