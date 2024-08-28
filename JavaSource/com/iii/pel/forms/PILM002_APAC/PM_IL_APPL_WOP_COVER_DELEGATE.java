package com.iii.pel.forms.PILM002_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.sun.mail.handlers.message_rfc822;

public class PM_IL_APPL_WOP_COVER_DELEGATE {

	public List<PM_IL_APPL_WOP_COVER> getListForAWCVR_COVER_CODE(
			String filterString) throws Exception {
		
		ResultSet result=null;
		List<PM_IL_APPL_WOP_COVER> lovList=new ArrayList();
		StringBuffer queryString=new StringBuffer();
		queryString.append(PILM002_APAC_SQLQUERY_CONSTANTS.LOV_AWCVR_COVER_CODE);
		if(!filterString.equals("*")){
			queryString.append(" AND UPPER(COVER_CODE) LIKE"+
			"'"+filterString.toUpperCase()+"%'");
		}
		
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		try {
			String fetchCount=PILM002_APAC_SQLQUERY_CONSTANTS.FETCH_ROW_COUNT;
			Object[] values={fetchCount};
			connection=CommonUtils.getConnection();
			result=handler.executeSelectStatement(queryString.toString(), connection,values);
			if(result==null){
				System.out.println("No result found for the query"+queryString);
			}else{
				while(result.next()){
					PM_IL_APPL_WOP_COVER tempBean=new PM_IL_APPL_WOP_COVER();
					tempBean.setAWCVR_COVER_CODE(result.getString("COVER_CODE"));
					//tempBean.setFAS_DOC_TO_TYPE(result.getString("DS_CODE"));
					tempBean.setUI_M_AWCVR_COVER_DESC(result.getString("COVER_DESC"));
					lovList.add(tempBean);
				}
				if(lovList == null || lovList.size() ==0){
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "1010"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;
	}

	public int saveRecord(PM_IL_APPL_WOP_COVER PM_IL_APPL_WOP_COVER_BEAN, boolean doCommit) {
		
		Connection connection=null;
		int count=0;
		CRUDHandler handler=new CRUDHandler();
		try {
			connection=CommonUtils.getConnection();
			count=handler.executeInsert(PM_IL_APPL_WOP_COVER_BEAN, connection);
			System.out.println("Insert/Update  successful");
			if(doCommit){
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (DBException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteSelectedRows(List<PM_IL_APPL_WOP_COVER> recordList,boolean doCommit) {
		
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		int iCount=0;
		int rowCount=0;
		while(iCount<recordList.size()){
			PM_IL_APPL_WOP_COVER recordListBean=(PM_IL_APPL_WOP_COVER)recordList.get(iCount);
			if ("dataTableSelectedRow".equalsIgnoreCase(recordListBean.getRowSelected())){ 
				try {
					recordList.remove(iCount);
					if(!(recordListBean.getAWCVR_COVER_CODE()==null) && 
							!(recordListBean.getAWCVR_COVER_CODE().trim().equals(""))){
						
						connection=CommonUtils.getConnection();
						int temp=handler.executeDelete(recordListBean, connection);
						System.out.println("Delete  successful--------->"+iCount+" row no deleted");
						if(doCommit){
							connection.commit();
						}
						rowCount=rowCount+temp;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (DBException e) {
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
		
		try {
			Connection connection=CommonUtils.getConnection();
			if(connection!=null){
				connection.commit();
				isCommited=true;
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCommited;
	}

	public List getBlockDataForPM_IL_CVR_WAITING_PRD() {
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		String queryString=PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_CVR_WAITING_PRD_BY_COVER_CODE;
		
		CRUDHandler handler=new CRUDHandler();
		List <PM_IL_CVR_WAITING_PRD> dataList=new ArrayList<PM_IL_CVR_WAITING_PRD>();
		ResultSet result=null;
		try {
			PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
				(PILM002_APAC_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession(mappedBeanName);
			String id=compositeActionBean.getPM_IL_COVER_ACTION_BEAN().getPM_IL_COVER_BEAN().getCOVER_CODE();
			Connection connection = CommonUtils.getConnection();
			Object []values={id};
			 result=handler.executeSelectStatement(queryString, connection, values);
			
			if(result!=null){
				while(result.next()){
					PM_IL_CVR_WAITING_PRD bean=new PM_IL_CVR_WAITING_PRD();
					bean.setCWP_FREEZE_FLAG(result.getString("CWP_FREEZE_FLAG"));
					bean.setCWP_ILLNESS_TYP(result.getString("CWP_ILLNESS_TYP"));
					bean.setCWP_WAITING_PRD(result.getDouble("CWP_WAITING_PRD"));
					bean.setCWP_COVER_CODE(result.getString("CWP_COVER_CODE"));
					bean.setCWP_CR_DT(result.getDate("CWP_CR_DT"));
					bean.setCWP_UPD_DT(result.getDate("CWP_UPD_DT"));
					bean.setCWP_CR_UID(result.getString("CWP_CR_UID"));
					bean.setCWP_UPD_UID(result.getString("CWP_UPD_UID"));
					bean.setROWID(result.getString("ROWID"));
					//bean.setUI_M_AWCVR_COVER_DESC(result.getString("UI_M_AWCVR_COVER_DESC"));
					dataList.add(bean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
