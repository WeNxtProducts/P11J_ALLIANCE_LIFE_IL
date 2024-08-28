package com.iii.pel.forms.PILP060_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		
		Object[] values={PILP060_APAC_SQLQUERY_CONSTANTS.FETCH_ROW_COUNT};
		queryString.append(PILP060_APAC_SQLQUERY_CONSTANTS.LOV_FM_TO_PROD_CODE);
		
		if(!filterString.equals("*")){
			queryString.append(" AND UPPER(PROD_CODE) LIKE"+
			"'"+filterString.toUpperCase()+"%' ORDER BY PROD_CODE");
		}else{
			queryString.append("ORDER BY PROD_CODE");
		}
		try {
			connection=utility.getConnection();
			result=handler.executeSelectStatement(queryString.toString(), connection,values);
			if(result==null){
				System.out.println("No result found for the query"+queryString);
			}else{
				while(result.next()){
					DUMMY tempBean=new DUMMY();
					tempBean.setUI_M_PROD_CODE_FM(result.getString("PROD_CODE"));
					tempBean.setUI_M_PROD_CODE_TO(result.getString("PROD_CODE"));
					tempBean.setUI_M_PROD_FM_DESC(result.getString("PROD_DESC"));
					tempBean.setUI_M_PROD_TO_DESC(result.getString("PROD_DESC"));
					lovList.add(tempBean);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(result !=null){
				try {
					result.close();
					result=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return lovList;
	}
	
	public List<DUMMY> getListForFM_TO_POL_NO(String filterString) {
		
		ResultSet result=null;
		Connection connection=null;
		
		List<DUMMY> lovList=new ArrayList();
		StringBuffer queryString=new StringBuffer();
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		
		Object[] values={PILP060_APAC_SQLQUERY_CONSTANTS.FETCH_ROW_COUNT};
		queryString.append(PILP060_APAC_SQLQUERY_CONSTANTS.LOV_FM_TO_POL_NO);
		
		if(!filterString.equals("*")){
			queryString.append(" AND UPPER(POL_NO) LIKE"+
			"'"+filterString.toUpperCase()+"%' ORDER BY POL_NO");
		}else{
			queryString.append("ORDER BY POL_NO");
		}
		try {
			connection=utility.getConnection();
			result=handler.executeSelectStatement(queryString.toString(), connection,values);
			if(result==null){
				System.out.println("No result found for the query"+queryString);
			}else{
				while(result.next()){
					DUMMY tempBean=new DUMMY();
					tempBean.setUI_M_POL_NO_FM(result.getString("POL_NO"));
					tempBean.setUI_M_POL_NO_TO(result.getString("POL_NO"));
					tempBean.setPolAssuredName(result.getString("POL_ASSURED_NAME"));
					lovList.add(tempBean);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(result !=null){
				try {
					result.close();
					result=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return lovList;
	}
	
	public List<DUMMY> getListForFM_TO_BON_CODE(String filterString) {
		
		ResultSet result=null;
		Connection connection=null;
		
		List<DUMMY> lovList=new ArrayList();
		StringBuffer queryString=new StringBuffer();
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		
		Object[] values={PILP060_APAC_SQLQUERY_CONSTANTS.FETCH_ROW_COUNT};
		queryString.append(PILP060_APAC_SQLQUERY_CONSTANTS.LOV_FM_TO_BON_CODE);
		
		if(!filterString.equals("*")){
			queryString.append(" AND UPPER(BONUS_CODE) LIKE"+
			"'"+filterString.toUpperCase()+"%' ORDER BY BONUS_CODE");
		}else{
			queryString.append("ORDER BY BONUS_CODE");
		}
		try {
			connection=utility.getConnection();
			result=handler.executeSelectStatement(queryString.toString(), connection,values);
			if(result==null){
				System.out.println("No result found for the query"+queryString);
			}else{
				while(result.next()){
					DUMMY tempBean=new DUMMY();
					tempBean.setUI_M_BON_CODE_FM(result.getString("BONUS_CODE"));
					tempBean.setUI_M_BON_CODE_TO(result.getString("BONUS_CODE"));
					tempBean.setUI_M_BON_FM_DESC(result.getString("BONUS_DESC"));
					tempBean.setUI_M_BON_TO_DESC(result.getString("BONUS_DESC"));
					lovList.add(tempBean);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(result !=null){
				try {
					result.close();
					result=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return lovList;
	}
}
