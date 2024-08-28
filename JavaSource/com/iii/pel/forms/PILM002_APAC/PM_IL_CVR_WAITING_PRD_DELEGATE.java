package com.iii.pel.forms.PILM002_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CVR_WAITING_PRD_DELEGATE {
	
	public List<PM_IL_CVR_WAITING_PRD> getListForCWP_ILLNESS_TYP(
			String filterString) {
		
		ResultSet result=null;
		List<PM_IL_CVR_WAITING_PRD> lovList=new ArrayList();
		StringBuilder queryString=new StringBuilder();
		Object[] values={PILM002_APAC_SQLQUERY_CONSTANTS.FETCH_ROW_COUNT};
		CommonUtils utility=new CommonUtils();
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		
		queryString.append(PILM002_APAC_SQLQUERY_CONSTANTS.LOV_CWP_ILLNESS_TYP);
		if(!filterString.equals("*")){
			System.out.println("in else");
			queryString.append(" AND UPPER(PC_CODE) LIKE ?");
			values = new Object[2];
			values[0] = PILM002_APAC_SQLQUERY_CONSTANTS.FETCH_ROW_COUNT;
			values[1] = filterString+"%";
		}
		try {
			connection=utility.getConnection();
			result=handler.executeSelectStatement(queryString.toString(), connection, values);
			if(result==null){
				System.out.println("No result found for the query"+queryString);
			}else{
				while(result.next()){
					PM_IL_CVR_WAITING_PRD tempBean=new PM_IL_CVR_WAITING_PRD();
					tempBean.setCWP_ILLNESS_TYP(result.getString("PC_CODE"));
					//tempBean.setFAS_DOC_TO_TYPE(result.getString("DS_CODE"));
					tempBean.setUI_CWP_ILLNESS_TYP_DESC(result.getString("PC_DESC"));
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
//				result.close();
//				result=null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;
	}

	public int saveRecord(PM_IL_CVR_WAITING_PRD PM_IL_CVR_WAITING_PRD_BEAN, boolean doCommit) {
		CommonUtils utility=new CommonUtils();
		Connection connection=null;
		boolean isRecordSaved=false;
		int rowCount=0;
		CRUDHandler handler=new CRUDHandler();
		
		try {
			connection=CommonUtils.getConnection();
			//CommonUtils.objectSysout(PM_IL_CVR_WAITING_PRD_BEAN);
			rowCount=handler.executeInsert(PM_IL_CVR_WAITING_PRD_BEAN, connection);
			isRecordSaved=true;
			System.out.println("Insert/Update  successful");
			if(doCommit){
				connection.commit();
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
		return rowCount;
	}

	public int deleteSelectedRows(List<PM_IL_CVR_WAITING_PRD> recordList,boolean doCommit) {
		CommonUtils utility=new CommonUtils();
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		int iCount=0;
		int rowCount=0;
		while(iCount<recordList.size()){
			PM_IL_CVR_WAITING_PRD recordListBean=(PM_IL_CVR_WAITING_PRD)recordList.get(iCount);
			if(recordListBean.isRowCheckBox()){
				try {
					recordList.remove(iCount);
					if(!(recordListBean.getCWP_ILLNESS_TYP()==null) && 
							!(recordListBean.getCWP_ILLNESS_TYP().trim().equals(""))){
						
						connection=utility.getConnection();
						int temp=handler.executeDelete(recordListBean, connection);
						System.out.println("Delete  successful--------->"+iCount+" row no deleted");
						if(doCommit){
							connection.commit();
						}
						rowCount=rowCount+temp;
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
		return rowCount;
	}

	public boolean commitData() {
		boolean isCommited=false;
		CommonUtils utility=new CommonUtils();
		try {
			Connection connection=utility.getConnection();
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
