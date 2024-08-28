package com.iii.pel.forms.PILM002_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_COVER_DELEGATE {

	public List <SelectItem> getSelectItems(String fieldName,String comboFieldId) {
		Connection connection=null;
		List selectItems=null;
		try {
			connection = CommonUtils.getConnection();
			selectItems=ListItemUtil.getDropDownListValue
			(connection,"PILM002_APAC" , "PM_IL_COVER", fieldName, comboFieldId);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return selectItems;
	}

	public int saveRecord(PM_IL_COVER PM_IL_COVER_BEAN,boolean doCommit) {
		Connection connection=null;
		boolean recordSaved=false;
		int insertRowCount=0;
		
		CRUDHandler handler=new CRUDHandler();
		try {
			connection=CommonUtils.getConnection();
			CommonUtils.objectSysout(PM_IL_COVER_BEAN);
			insertRowCount=handler.executeInsert(PM_IL_COVER_BEAN, connection);
			recordSaved=true;
			System.out.println("Insert/Update  successful");
				
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
		return insertRowCount;
	}

	public int deleteRecord(PM_IL_COVER PM_IL_COVER_BEAN,boolean doCommit) {
		Connection connection=null;
		boolean recordDelete=false;
		int count=0;
		CRUDHandler handler=new CRUDHandler();
		try {
			connection=CommonUtils.getConnection();
			count=handler.executeDelete(PM_IL_COVER_BEAN, connection);
			recordDelete=true;
			System.out.println("Delete successful");
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
		}catch (DBException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List getBlockDataForPM_IL_APPL_WOP_COVER(PILM002_APAC_COMPOSITE_ACTION compositeActionBean) {
		String queryString=PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_APPL_WOP_COVER_BY_COVER_CODE;
		CRUDHandler handler=new CRUDHandler();
		List <PM_IL_APPL_WOP_COVER> dataList=new ArrayList<PM_IL_APPL_WOP_COVER>();
		ResultSet result=null;
		String id=compositeActionBean.getPM_IL_COVER_ACTION_BEAN().getPM_IL_COVER_BEAN().getCOVER_CODE();
		Connection connection = null;
		try {
			 connection = CommonUtils.getConnection();
			Object []values={id};
			result=handler.executeSelectStatement(queryString, connection, values);
			
			if(result!=null){
				while(result.next()){
					PM_IL_APPL_WOP_COVER bean=new PM_IL_APPL_WOP_COVER();
					bean.setAWCVR_COVER_CODE(result.getString("AWCVR_COVER_CODE"));
					bean.setROWID(result.getString("ROWID"));
					bean.setAWCVR_CODE(result.getString("AWCVR_CODE"));
					bean.setAWCVR_CR_DT(result.getDate("AWCVR_CR_DT"));
					bean.setAWCVR_CR_UID(result.getString("AWCVR_CR_UID"));
					bean.setAWCVR_UPD_DT(result.getDate("AWCVR_UPD_DT"));
					bean.setAWCVR_UPD_UID(result.getString("AWCVR_UPD_UID"));
					//bean.setUI_M_AWCVR_COVER_DESC(result.getString("UI_M_AWCVR_COVER_DESC"));
					bean.setRowSelected(false);
					dataList.add(bean);
				}
				
				compositeActionBean.getPM_IL_APPL_WOP_COVER_ACTION_BEAN().setRecordList(dataList);
				if (dataList.size()>0){					
					compositeActionBean.getPM_IL_APPL_WOP_COVER_ACTION_BEAN().setPM_IL_APPL_WOP_COVER_BEAN(dataList.get(0));
					compositeActionBean.getPM_IL_APPL_WOP_COVER_ACTION_BEAN().getPM_IL_APPL_WOP_COVER_BEAN().setRowSelected(true);				}
				
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

	public boolean deleteRecordPM_IL_APPL_WOP_COVER(boolean doCommit) {
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		boolean isdeleted=false;
		String queryString=PILM002_APAC_SQLQUERY_CONSTANTS.DELETE_PM_IL_APPL_WOP_COVER_BY_COVER_CODE;
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		Connection con=null;
		try {
			PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
				(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			String coverCode=compositeActionBean.getPM_IL_COVER_ACTION_BEAN().
				getPM_IL_COVER_BEAN().getCOVER_CODE();
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
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return isdeleted;
	}

	public boolean deleteRecordPM_IL_CVR_WAITING_PRD(boolean doCommit) {
		
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		boolean isdeleted=false;
		String queryString=PILM002_APAC_SQLQUERY_CONSTANTS.DELETE_PM_IL_CVR_WAITING_PRD_BY_COVER_CODE;
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		Connection con=null;
		try {
			PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
				(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			String coverCode=compositeActionBean.getPM_IL_COVER_ACTION_BEAN().
				getPM_IL_COVER_BEAN().getCOVER_CODE();
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
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return isdeleted;
	}
	
	public void executeStatement(PM_IL_COVER_ACTION PM_IL_COVER_ACTION_BEAN){
		Connection connection = null;
		CRUDHandler handler=new CRUDHandler();
		
		String queryString = PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_ALL_PM_IL_COVER;
		String coverRowId = PM_IL_COVER_ACTION_BEAN.getPM_IL_COVER_BEAN().getROWID();
		PM_IL_COVER bean = null; 
		ResultSet result=null;
		
		try {
			connection = CommonUtils.getConnection();
			result=handler.executeSelectStatement(queryString,connection,new Object[]{coverRowId});
			bean = PM_IL_COVER_ACTION_BEAN.getPM_IL_COVER_BEAN();
			if(result!=null){
				while(result.next()){
					bean.setCOVER_APP_ON_BASIC_RATE(result.getString("COVER_APP_ON_BASIC_RATE"));
					bean.setCOVER_BL_DESC(result.getString("COVER_BL_DESC"));
					bean.setCOVER_BL_LONG_DESC(result.getString("COVER_BL_LONG_DESC"));
					bean.setCOVER_CLASS(result.getString("COVER_CLASS"));
					bean.setCOVER_CODE(result.getString("COVER_CODE"));
					bean.setCOVER_DESC(result.getString("COVER_DESC"));
					bean.setCOVER_DISC_AGE_YN(result.getString("COVER_DISC_AGE_YN"));
					bean.setCOVER_EFF_FM_DT(result.getDate("COVER_EFF_FM_DT"));
					bean.setCOVER_EFF_TO_DT(result.getDate("COVER_EFF_TO_DT"));
					bean.setCOVER_FRZ_FLAG(result.getString("COVER_FRZ_FLAG"));
					bean.setCOVER_FUND_MTHD(result.getString("COVER_FUND_MTHD"));
					bean.setCOVER_FUND_RISK(result.getString("COVER_FUND_RISK"));
					bean.setCOVER_FUND_TYPE(result.getString("COVER_FUND_TYPE"));
					bean.setCOVER_LONG_DESC(result.getString("COVER_LONG_DESC"));
					bean.setCOVER_MAX_SA(result.getDouble("COVER_MAX_SA"));
					bean.setCOVER_MAX_UNIT(result.getDouble("COVER_MAX_UNIT"));
					bean.setCOVER_MAX_UNIT(result.getDouble("COVER_MAX_UNIT"));
					bean.setCOVER_MIN_MAX_REQ(result.getString("COVER_MIN_MAX_REQ"));
					bean.setCOVER_MIN_SA(result.getDouble("COVER_MIN_SA"));
					bean.setCOVER_MIN_UNIT(result.getDouble("COVER_MIN_UNIT"));
					bean.setCOVER_PREM_TYPE(result.getString("COVER_PREM_TYPE"));
					bean.setCOVER_RATE_APPLIED_ON(result.getString("COVER_RATE_APPLIED_ON"));
					bean.setCOVER_SA_CALC(result.getString("COVER_SA_CALC"));
					bean.setCOVER_SA_MULTIPLE(result.getDouble("COVER_SA_MULTIPLE"));
					bean.setCOVER_SA_PERC(result.getDouble("COVER_SA_PERC"));
					bean.setCOVER_TYPE(result.getString("COVER_TYPE"));
					bean.setCOVER_VAR_VALUE(result.getDouble("COVER_VAR_VALUE"));
					bean.setROWID(result.getString("ROWID"));
					bean.setCOVER_MEDICAL_YN(result.getString("COVER_MEDICAL_YN"));
					//bean.setCOVER_SURGICAL_YN(result.getString("COVER_SURGICAL_YN"));
					bean.setCOVER_LIMIT_DAYS(result.getDouble("COVER_LIMIT_DAYS"));
					bean.setCOVER_LIMIT_TYPE(result.getString("COVER_LIMIT_TYPE"));
					bean.setCOVER_PER_DAY_LC_AMT(result.getDouble("COVER_PER_DAY_LC_AMT"));
					
					bean.setCOVER_SA_BY_PARTS_TARR(result.getString("COVER_SA_BY_PARTS_TARR"));
					bean.setCOVER_MIN_TYPE(result.getString("COVER_MIN_TYPE"));
					bean.setCOVER_MAX_TYPE(result.getString("COVER_MAX_TYPE"));
					bean.setCOVER_MIN_PERC(result.getDouble("COVER_MIN_PERC"));
					bean.setCOVER_MAX_PERC(result.getDouble("COVER_MAX_PERC"));
					/*Added by saritha on 15/12/2017*/
					bean.setCOVER_FUNERAL_CVR_YN(result.getString("COVER_FUNERAL_CVR_YN"));
					/*End*/
							
					/*Added by Janani on 24.04.2018 for Fidelity money tree cover validation*/
					bean.setCOVER_VALIDATE_YN(result.getString("COVER_VALIDATE_YN"));
					/*End*/
					
					/*added by gopi for  toi on 25/05/18*/
					
					bean.setCOVER_SA_FIXED(result.getDouble("COVER_SA_FIXED"));
					/*end*/
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
