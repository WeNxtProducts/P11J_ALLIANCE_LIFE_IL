package com.iii.pel.forms.PM092_A;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_CONTEST_DTL_DELEGATE {

	public List <SelectItem> getSelectItems(String fieldName,String comboFieldId) {
		Connection connection=null;
		List selectItems=null;
		try {
			connection = CommonUtils.getConnection();
			selectItems=ListItemUtil.getDropDownListValue
			(connection,"PM092_A" ,"PM_AGENT_CONTEST_DTL", fieldName, comboFieldId);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectItems;
	}

	public boolean saveRecord(PM_AGENT_CONTEST_DTL PM_AGENT_CONTEST_DTL_BEAN,boolean doCommit)throws ValidatorException {
		Connection connection=null;
		boolean recordSaved=false;
		
		CRUDHandler handler=new CRUDHandler();
		try {
			connection=CommonUtils.getConnection();
			PM_AGENT_CONTEST_DTL_HELPER helper=new PM_AGENT_CONTEST_DTL_HELPER();
			if(PM_AGENT_CONTEST_DTL_BEAN.getROWID()==null){
				helper.pmAgentContestDtlPreInsert(PM_AGENT_CONTEST_DTL_BEAN);
			}else{
				helper.pmAgentContestDtlPreUpdate(PM_AGENT_CONTEST_DTL_BEAN);
			}
			handler.executeInsert(PM_AGENT_CONTEST_DTL_BEAN, connection);
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

	public boolean deleteRecord(PM_AGENT_CONTEST_DTL PM_AGENT_CONTEST_DTL_BEAN,boolean doCommit) {
		Connection connection=null;
		boolean recordDelete=false;
		
		CRUDHandler handler=new CRUDHandler();
		try {
			connection=CommonUtils.getConnection();
			handler.executeDelete(PM_AGENT_CONTEST_DTL_BEAN, connection);
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
		return recordDelete;
	}

	public List getBlockDataForPM_AGENT_CONTEST_APPL_RANK() {
		String queryString=PM092_A_SQLQUERY_CONSTANTS.SELECT_PM_AGENT_CONTEST_APPL_RANK_BY_ACH_CODE;
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		String mappedBeanName="PM092_A_COMPOSITE_ACTION";
		List <PM_AGENT_CONTEST_APPL_RANK> dataList=new ArrayList<PM_AGENT_CONTEST_APPL_RANK>();
		ResultSet result=null;
		try {
			Connection connection = CommonUtils.getConnection();
			
			PM092_A_COMPOSITE_ACTION compositeActionBean=
				(PM092_A_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			String id=compositeActionBean.getPM_AGENT_CONTEST_HDR_ACTION_BEAN().
					getPM_AGENT_CONTEST_HDR_BEAN().getACH_CODE();
			Object []values={id};
			result=handler.executeSelectStatement(queryString, connection, values);
			if(result!=null){
				while(result.next()){
					PM_AGENT_CONTEST_APPL_RANK bean=new PM_AGENT_CONTEST_APPL_RANK();
					bean.setACAR_RANK_CODE(result.getString("ACAR_RANK_CODE"));
					bean.setACAR_ACH_CODE(result.getString("ACAR_ACH_CODE"));
					bean.setROWID(result.getString("ROWID"));
					//bean.setUI_M_AWCVR_COVER_DESC(result.getString("UI_M_AWCVR_COVER_DESC"));
					PM_AGENT_CONTEST_APPL_RANK_HELPER helper=new PM_AGENT_CONTEST_APPL_RANK_HELPER();
					helper.pmAgentContestApplRankPostQuery(bean);
					dataList.add(bean);
				}
			}
			PM_AGENT_CONTEST_APPL_RANK PM_AGENT_CONTEST_APPL_RANK_BEAN = null;
			Iterator<PM_AGENT_CONTEST_APPL_RANK> it = dataList.iterator();
			while(it.hasNext()){
				PM_AGENT_CONTEST_APPL_RANK_BEAN = it.next();
				PM_AGENT_CONTEST_APPL_RANK_BEAN.setRowSelected(false);
 			}
			
			if (dataList.size()>0){					
				compositeActionBean.getPM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN().setPM_AGENT_CONTEST_APPL_RANK_BEAN(dataList.get(0));
				compositeActionBean.getPM_AGENT_CONTEST_APPL_RANK_ACTION_BEAN().getPM_AGENT_CONTEST_APPL_RANK_BEAN().setRowSelected(true);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
