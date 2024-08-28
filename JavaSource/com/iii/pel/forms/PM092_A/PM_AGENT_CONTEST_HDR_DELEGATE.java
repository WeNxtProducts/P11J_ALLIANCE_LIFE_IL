package com.iii.pel.forms.PM092_A;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_CONTEST_HDR_DELEGATE {

	public boolean saveRecord(PM_AGENT_CONTEST_HDR PM_AGENT_CONTEST_HDR_BEAN,
			boolean doCommit) {
		Connection connection=null;
		boolean recordSaved=false;
		CRUDHandler handler=new CRUDHandler();
		try {
			connection=CommonUtils.getConnection();
			PM_AGENT_CONTEST_HDR_HELPER helper=new PM_AGENT_CONTEST_HDR_HELPER();
			if(PM_AGENT_CONTEST_HDR_BEAN.getROWID()==null){
				
				helper.pmAgentContestHdrPreInsert(PM_AGENT_CONTEST_HDR_BEAN);
				handler.executeInsert(PM_AGENT_CONTEST_HDR_BEAN, connection);
			}else{
				helper.pmAgentContestHdrPreUpdate(PM_AGENT_CONTEST_HDR_BEAN);
				handler.executeUpdate(PM_AGENT_CONTEST_HDR_BEAN, connection);
			}
			recordSaved=true;
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
		return recordSaved;
	}


	public boolean deleteRecord(PM_AGENT_CONTEST_HDR PM_AGENT_CONTEST_HDR_BEAN,
			boolean doCommit) {
		Connection connection=null;
		boolean recordDelete=false;
		
		CRUDHandler handler=new CRUDHandler();
		try {
			connection=CommonUtils.getConnection();
			handler.executeDelete(PM_AGENT_CONTEST_HDR_BEAN, connection);
			recordDelete=true;
			System.out.println("Delete successful");
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
		}catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recordDelete;
		
	}

	public PM_AGENT_CONTEST_DTL getBlockDataForPM_AGENT_CONTEST_DTL() {
		
		String queryString=PM092_A_SQLQUERY_CONSTANTS.SELECT_PM_AGENT_CONTEST_DTL_BY_ACH_CODE;
		String mappedBeanName="PM092_A_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		PM_AGENT_CONTEST_DTL bean=new PM_AGENT_CONTEST_DTL();
		ResultSet result=null;
		try {
			PM092_A_COMPOSITE_ACTION compositeActionBean=
				(PM092_A_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			String id=compositeActionBean.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().
					getPM_AGENT_CONTEST_HDR_BEAN().getACH_CODE();
			Connection connection = utility.getConnection();
			Object []values={id};
			result=handler.executeSelectStatement(queryString, connection, values);
			if(result!=null && result.next()){
					bean.setACD_FYC_TYPE(result.getString("ACD_FYC_TYPE"));
					bean.setACD_LC_FYC_FM(result.getDouble("ACD_LC_FYC_FM"));
					bean.setACD_LC_FYC_TO(result.getDouble("ACD_LC_FYC_TO"));
					bean.setACD_NO_OF_POL_FM(result.getInt("ACD_NO_OF_POL_FM"));
					bean.setACD_NO_OF_POL_TO(result.getInt("ACD_NO_OF_POL_TO"));
					bean.setACD_PROD_TYPE(result.getString("ACD_PROD_TYPE"));
					bean.setROWID(result.getString("ROWID"));
					bean.setACD_CR_DT(result.getDate("ACD_CR_DT"));
					bean.setACD_CR_UID(result.getString("ACD_CR_UID"));
					bean.setACD_UPD_DT(result.getDate("ACD_UPD_DT"));
					bean.setACD_UPD_UID(result.getString("ACD_UPD_UID"));
					bean.setACD_ACH_CODE(result.getString("ACD_ACH_CODE"));
			}else{
				//In case of insert when no records are returned this
				//block will execute
				//TODO remove the else block when pre insert trigger is handled
				bean=new PM_AGENT_CONTEST_DTL();
				bean.setACD_ACH_CODE(id);
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return bean;
	}


	public boolean deleteRecordPM_AGENT_CONTEST_DTL(boolean doCommit) {
		String mappedBeanName="PM092_A_COMPOSITE_ACTION";
		boolean isdeleted=false;
		String queryString=PM092_A_SQLQUERY_CONSTANTS.DELETE_PM_AGENT_CONTEST_DTL_BY_ACH_CODE;
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		Connection con=null;
		try {
			PM092_A_COMPOSITE_ACTION compositeActionBean=
				(PM092_A_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			String coverCode=compositeActionBean.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().
				getPM_AGENT_CONTEST_HDR_BEAN().getACH_CODE();
			if(coverCode != null && coverCode.trim().length() >0){
				con=utility.getConnection();
				Object []values={coverCode};
				handler.executeDeleteStatement(queryString,con,values);
				isdeleted=true;
				if(doCommit){
					con.commit();
					System.out.println("commit 1");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isdeleted;
	}


	public boolean deleteRecordPM_AGENT_CONTEST_APPL_RANK(boolean doCommit) {
		String mappedBeanName="PM092_A_COMPOSITE_ACTION";
		boolean isdeleted=false;
		String queryString=PM092_A_SQLQUERY_CONSTANTS.DELETE_PM_AGENT_CONTEST_APPL_RANK_BY_ACH_CODE;
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		Connection con=null;
		try {
			PM092_A_COMPOSITE_ACTION compositeActionBean=
				(PM092_A_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			String coverCode=compositeActionBean.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().
				getPM_AGENT_CONTEST_HDR_BEAN().getACH_CODE();
			if(coverCode != null && coverCode.trim().length() >0){
				con=CommonUtils.getConnection();
				Object []values={coverCode};
				handler.executeDeleteStatement(queryString,con,values);
				isdeleted=true;
				if(doCommit){
					con.commit();
					System.out.println("commit 2");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isdeleted;
	}


	public boolean deleteRecordPM_AGENT_CONTEST_AWARD(boolean doCommit) {
		String mappedBeanName="PM092_A_COMPOSITE_ACTION";
		boolean isdeleted=false;
		String queryString=PM092_A_SQLQUERY_CONSTANTS.DELETE_PM_AGENT_CONTEST_AWARD_BY_ACH_CODE;
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		Connection con=null;
		try {
			PM092_A_COMPOSITE_ACTION compositeActionBean=
				(PM092_A_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			String coverCode=compositeActionBean.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().
				getPM_AGENT_CONTEST_HDR_BEAN().getACH_CODE();
			if(coverCode != null && coverCode.trim().length() >0){
				con=CommonUtils.getConnection();
				Object []values={coverCode};
				handler.executeDeleteStatement(queryString,con,values);
				isdeleted=true;
				if(doCommit){
					con.commit();
					System.out.println("commit 3");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isdeleted;

	}
	
	public void executeSelectStatement(PM092_A_COMPOSITE_ACTION compositeAction) throws Exception{
		ResultSet resultSet = null;
		String selectQuery = "SELECT PM_AGENT_CONTEST_HDR.*,ROWID FROM PM_AGENT_CONTEST_HDR WHERE ROWID = ? ";
		try{
		resultSet = new CRUDHandler().executeSelectStatement(selectQuery,CommonUtils.getConnection(),
		                                                     new Object[]{compositeAction.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().getPM_AGENT_CONTEST_HDR_BEAN().getROWID()} );
		PM_AGENT_CONTEST_HDR bean=new PM_AGENT_CONTEST_HDR();
			while(resultSet.next()){
				bean.setACH_BL_DESC(resultSet.getString("ACH_BL_DESC"));
				bean.setACH_BL_LONG_DESC(resultSet.getString("ACH_BL_LONG_DESC"));
				bean.setACH_BL_SHORT_DESC(resultSet.getString("ACH_BL_SHORT_DESC"));
				bean.setACH_CODE(resultSet.getString("ACH_CODE"));
				bean.setACH_DESC(resultSet.getString("ACH_DESC"));
				bean.setACH_EFF_FM_DT(resultSet.getDate("ACH_EFF_FM_DT"));
				bean.setACH_EFF_TO_DT(resultSet.getDate("ACH_EFF_TO_DT"));
				bean.setACH_LEVEL(resultSet.getDouble("ACH_LEVEL"));
				bean.setACH_LONG_DESC(resultSet.getString("ACH_LONG_DESC"));
				bean.setACH_SHORT_DESC(resultSet.getString("ACH_SHORT_DESC"));
				bean.setACH_CR_DT(resultSet.getDate("ACH_CR_DT"));
				bean.setACH_CR_UID(resultSet.getString("ACH_CR_UID"));
				bean.setACH_UPD_DT(resultSet.getDate("ACH_UPD_DT"));
				bean.setACH_UPD_UID(resultSet.getString("ACH_UPD_UID"));
				bean.setROWID(resultSet.getString("ROWID"));
			}
		compositeAction.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().setPM_AGENT_CONTEST_HDR_BEAN(bean);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}


