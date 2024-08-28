package com.iii.premia.common.notes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class NotesDelegate {

	public List<PCOM_NOTES_MASTER> getUploadedNotesData(String screenId, String transId) throws Exception {
		List<PCOM_NOTES_MASTER> recordList=new ArrayList<PCOM_NOTES_MASTER>();
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		ResultSet result=null;
		Object []queryValues=new Object [2];
		
		try {
			queryValues[0] = transId;
			queryValues[1] = screenId;
			result = handler.executeSelectStatement(
							Notes_QueryConstants.SELECT_PCOM_NOTES_MASTER_BY_TRANS_ID_AND_TRANS_TYP,
							utility.getConnection(), queryValues);
				while (result.next()) {
					PCOM_NOTES_MASTER bean = new PCOM_NOTES_MASTER();
					bean.setROWID(result.getString("ROWID"));
					bean.setPNM_SYS_ID(result.getLong("PNM_SYS_ID"));
					bean.setPNM_SCREEN_ID(result.getString("PNM_SCREEN_ID"));
					bean.setPNM_TRANSACTION_ID(result
							.getString("PNM_TRANSACTION_ID"));
					bean.setPNM_NOTES_CONTENT(result
							.getString("PNM_NOTES_CONTENT"));
					bean.setPNM_CR_UID(result.getString("PNM_CR_UID"));
					bean.setPNM_CR_TIMESTAMP(result.getTimestamp("PNM_CR_TIMESTAMP"));

					recordList.add(bean);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			if(result!=null){
				try {
					result.close();
					result=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recordList;
	}
	
	public void getTaggedUserDataList(PCOM_NOTES_MASTER notesBean) throws Exception {
		List<PCOM_NOTES_TAGGED_USERS> recordList=new ArrayList<PCOM_NOTES_TAGGED_USERS>();
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		ResultSet result=null;
		
		try {
			result = handler.executeSelectStatement(
					Notes_QueryConstants.SELECT_PCOM_NOTES_TAGGED_USERS,
					utility.getConnection(), new Object[]{notesBean.getPNM_SYS_ID()});
			while (result.next()) {
				PCOM_NOTES_TAGGED_USERS bean = new PCOM_NOTES_TAGGED_USERS();
				bean.setROWID(result.getString("ROWID"));
				bean.setPNTU_SYS_ID(result.getLong("PNTU_SYS_ID"));
				bean.setPNTU_SEQ_NO(result.getInt("PNTU_SEQ_NO"));
				bean.setPNTU_TAGGED_USER(result.getString("PNTU_TAGGED_USER"));

				notesBean.getTaggedUsersList().add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			if(result!=null){
				try {
					result.close();
					result=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void defaultDistinctTaggedUser(String screenId, String transactionId, NotesAction action) throws Exception{
		List<PCOM_NOTES_TAGGED_USERS> recordList=new ArrayList<PCOM_NOTES_TAGGED_USERS>();
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		ResultSet result=null;
		try {
			result = handler.executeSelectStatement(
					 Notes_QueryConstants.SELECT_DEFAULT_PCOM_NOTES_TAGGED_USERS,
					 utility.getConnection(), 
					 new Object[]{screenId, transactionId});
			while (result.next()) {
				PCOM_NOTES_TAGGED_USERS bean = new PCOM_NOTES_TAGGED_USERS();
				bean.setPNTU_TAGGED_USER(result.getString("PNTU_TAGGED_USER"));

				action.getNotes().getTaggedUsersList().add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			if(result!=null){
				try {
					result.close();
					result=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// General Method for LOV.
	public List<LovBean> prepareLovList(String query, Object[] obj) {
		
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while(resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));

				if(resultSet.getMetaData().getColumnCount() > 2) {
					bean.setLovName1(resultSet.getString(3));
				}
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
	
	public List<PCOM_NOTES_MASTER> getApplicableNotesData() throws Exception {
		List<PCOM_NOTES_MASTER> recordList=new ArrayList<PCOM_NOTES_MASTER>();
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		ResultSet result=null;
		String userId = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
		try {
			result = handler.executeSelectStatement(
							Notes_QueryConstants.SELECT_APPLICABLE_NOTES_DATA_FOR_LOGIN_USER,
							utility.getConnection(), new Object[]{userId});
				while (result.next()) {
					PCOM_NOTES_MASTER bean = new PCOM_NOTES_MASTER();
					bean.setPNM_SCREEN_ID(result.getString(1));
					bean.setPNM_TRANSACTION_ID(result.getString(2));
					bean.setPNM_SYS_ID(result.getLong(3));
					String content = result.getString(4);
					bean.setPNM_CR_UID(result.getString(5));
					bean.setPNM_CR_TIMESTAMP(result.getTimestamp(6));
					
					String notesContent = "The Remark is Added For Screen : "+result.getString(1)+" <br/>For Transaction No : "+result.getString(2)+" <br/>Notes Content : "+content+"";
					bean.setPNM_NOTES_CONTENT(notesContent);

					recordList.add(bean);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			if(result!=null){
				try {
					result.close();
					result=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recordList;
	}
}
