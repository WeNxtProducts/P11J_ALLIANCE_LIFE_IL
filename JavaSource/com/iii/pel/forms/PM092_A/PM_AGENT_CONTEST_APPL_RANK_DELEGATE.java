package com.iii.pel.forms.PM092_A;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_CONTEST_APPL_RANK_DELEGATE {

	public List<PM_AGENT_CONTEST_APPL_RANK> getListForACAR_RANK_CODE(
			String filterString) {
		
		ResultSet result=null;
		List<PM_AGENT_CONTEST_APPL_RANK> lovList=new ArrayList();
		StringBuffer queryString=new StringBuffer();
		queryString.append(PM092_A_SQLQUERY_CONSTANTS.LOV_ACAR_RANK_CODE);
		if(!filterString.equals("*")){
			queryString.append(" AND UPPER(PC_CODE) LIKE"+
			"'"+filterString.toUpperCase()+"%'");
		}
		CommonUtils utility=new CommonUtils();
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		try {
			String fetchCount=PM092_A_SQLQUERY_CONSTANTS.FETCH_ROW_COUNT;
			Object[] values={fetchCount};
			connection=utility.getConnection();
			result=handler.executeSelectStatement(queryString.toString(), connection,values);
			if(result==null){
				System.out.println("No result found for the query"+queryString);
			}else{
				while(result.next()){
					PM_AGENT_CONTEST_APPL_RANK tempBean=new PM_AGENT_CONTEST_APPL_RANK();
					tempBean.setACAR_RANK_CODE(result.getString("PC_CODE"));
					//tempBean.setFAS_DOC_TO_TYPE(result.getString("DS_CODE"));
					tempBean.setUI_M_ACAR_RANK_CODE_DESC(result.getString("PC_DESC"));
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

			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;
	}

	public boolean saveRecord(PM_AGENT_CONTEST_APPL_RANK PM_AGENT_CONTEST_APPL_RANK_BEAN, boolean doCommit) {
		Connection connection=null;
		boolean isRecordSaved=false;
		
		CRUDHandler handler=new CRUDHandler();
		try {
			connection=CommonUtils.getConnection();
			handler.executeInsert(PM_AGENT_CONTEST_APPL_RANK_BEAN, connection);
			isRecordSaved=true;
			System.out.println("Insert/Update  successful");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRecordSaved;
	}

	public void deleteSelectedRows(List<PM_AGENT_CONTEST_APPL_RANK> recordList,boolean doCommit) {
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		int iCount=0;
		while(iCount<recordList.size()){
			PM_AGENT_CONTEST_APPL_RANK recordListBean=(PM_AGENT_CONTEST_APPL_RANK)recordList.get(iCount);
			if(recordListBean.isRowCheckBox()){
				try {
					recordList.remove(iCount);
					if(!(recordListBean.getACAR_RANK_CODE()==null) && 
							!(recordListBean.getACAR_RANK_CODE().trim().equals(""))){
						
						connection=CommonUtils.getConnection();
						handler.executeDelete(recordListBean, connection);
						System.out.println("Delete  successful--------->"+iCount+" row no deleted");
						if(doCommit){
							connection.commit();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				iCount++;
			}
		}
		
	}

	public boolean commitData() {
		boolean isCommited=false;
		try {
			Connection connection=CommonUtils.getConnection();
			if(connection!=null){
				connection.commit();
				isCommited=true;
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isCommited;
	}
}
