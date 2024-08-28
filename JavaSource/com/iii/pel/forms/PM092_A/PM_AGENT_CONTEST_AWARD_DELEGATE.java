package com.iii.pel.forms.PM092_A;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_CONTEST_AWARD_DELEGATE {

	public List<PM_AGENT_CONTEST_AWARD> getListForACA_AWARD_CODE(
			String filterString) {
		
		ResultSet result=null;
		List<PM_AGENT_CONTEST_AWARD> lovList=new ArrayList();
		StringBuffer queryString=new StringBuffer();
		queryString.append(PM092_A_SQLQUERY_CONSTANTS.LOV_ACA_AWARD_CODE);
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
					PM_AGENT_CONTEST_AWARD tempBean=new PM_AGENT_CONTEST_AWARD();
					tempBean.setACA_AWARD_CODE(result.getString("PC_CODE"));
					//tempBean.setFAS_DOC_TO_TYPE(result.getString("DS_CODE"));
					tempBean.setUI_M_ACA_AWARD_CODE_DESC(result.getString("PC_SHORT_DESC"));
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

	public boolean saveRecord(PM_AGENT_CONTEST_AWARD PM_AGENT_CONTEST_AWARD_BEAN, boolean doCommit) {
		Connection connection=null;
		boolean isRecordSaved=false;
		
		CRUDHandler handler=new CRUDHandler();
		try {
			connection=CommonUtils.getConnection();
			handler.executeInsert(PM_AGENT_CONTEST_AWARD_BEAN, connection);
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
		return isRecordSaved;
	}

	public void deleteSelectedRows(List<PM_AGENT_CONTEST_AWARD> recordList,boolean doCommit) {
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		int iCount=0;
		while(iCount<recordList.size()){
			PM_AGENT_CONTEST_AWARD recordListBean=(PM_AGENT_CONTEST_AWARD)recordList.get(iCount);
			if(recordListBean.isRowCheckBox()){
				try {
					recordList.remove(iCount);
					if(!(recordListBean.getACA_AWARD_CODE()==null) && 
							!(recordListBean.getACA_AWARD_CODE().trim().equals(""))){
						
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
	
	public List getBlockDataForPM_AGENT_CONTEST_AWARD() {
		String queryString=PM092_A_SQLQUERY_CONSTANTS.SELECT_PM_AGENT_CONTEST_AWARD_BY_ACH_CODE;
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		String mappedBeanName="PM092_A_COMPOSITE_ACTION";
		List <PM_AGENT_CONTEST_AWARD> dataList=new ArrayList<PM_AGENT_CONTEST_AWARD>();
		ResultSet result=null;
		try {
			Connection connection = utility.getConnection();
			
			PM092_A_COMPOSITE_ACTION compositeActionBean=
				(PM092_A_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			String id=compositeActionBean.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().
					getPM_AGENT_CONTEST_HDR_BEAN().getACH_CODE();
			Object []values={id};
			result=handler.executeSelectStatement(queryString, connection, values);
			if(result!=null){
				while(result.next()){
					PM_AGENT_CONTEST_AWARD bean=new PM_AGENT_CONTEST_AWARD();
					bean.setACA_AWARD_CODE(result.getString("ACA_AWARD_CODE"));
					bean.setACA_REMARKS(result.getString("ACA_REMARKS"));
					bean.setROWID(result.getString("ROWID"));
					//bean.setUI_M_AWCVR_COVER_DESC(result.getString("UI_M_AWCVR_COVER_DESC"));
					PM_AGENT_CONTEST_AWARD_HELPER helper=new PM_AGENT_CONTEST_AWARD_HELPER();
					helper.pmAgentContestAwardPostQuery(bean);
					dataList.add(bean);
				}
			}
			PM_AGENT_CONTEST_AWARD  PM_AGENT_CONTEST_AWARD_BEAN= null;
			Iterator<PM_AGENT_CONTEST_AWARD> it = dataList.iterator();
			while(it.hasNext()){
				PM_AGENT_CONTEST_AWARD_BEAN = it.next();
				PM_AGENT_CONTEST_AWARD_BEAN.setRowSelected(false);
 			}
			
			if (dataList.size()>0){					
				compositeActionBean.getPM_AGENT_CONTEST_AWARD_ACTION_BEAN().setPM_AGENT_CONTEST_AWARD_BEAN(dataList.get(0));
				compositeActionBean.getPM_AGENT_CONTEST_AWARD_ACTION_BEAN().getPM_AGENT_CONTEST_AWARD_BEAN().setRowSelected(true);
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dataList;
	}
	

}
