package com.iii.pel.forms.PILM042;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM041.PM_IL_DATA_UPLOAD_MAPPING;
import com.iii.pel.forms.PILM041.PM_IL_DATA_UPLOAD_MAPPING_ACTION;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DATA_UPLOAD_DEFN_HDR_DELEGATE {

	/**
	 * @51128
	 */
	public boolean saveRecord(PM_IL_DATA_UPLOAD_DEFN_HDR PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN,	boolean doCommit) {
		CommonUtils utility = new CommonUtils();
		Connection connection = null;
		boolean recordSaved = false;

		CRUDHandler handler = new CRUDHandler();
		try {
			connection = utility.getConnection();
			PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_CR_DT(new CommonUtils().getCurrentDate());
			PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			handler.executeInsert(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN, connection);
			recordSaved = true;

			if (doCommit) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recordSaved;
	}

	
	public int delete(PM_IL_DATA_UPLOAD_DEFN_HDR PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN,
			PM_IL_DATA_UPLOAD_DEFN_DTL PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN) throws Exception{
		CRUDHandler handler = new CRUDHandler();
		String delQuery = "Delete from PM_IL_DATA_UPLOAD_DEFN_HDR where DUDH_DEF_CODE = '"+PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.getDUDH_DEF_CODE()+"'"; 
		String delDTLQuery = "Delete from PM_IL_DATA_UPLOAD_DEFN_DTL where DUDD_DUDH_DEF_CODE = '"+PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.getDUDH_DEF_CODE()+"'";
		int rowDeleted = 0;
		int rowDeleted1 = 0;
		try {
			rowDeleted = handler.executeDeleteStatement(delDTLQuery, CommonUtils.getConnection());
			rowDeleted1 = handler.executeDeleteStatement(delQuery, CommonUtils.getConnection());
		} catch (Exception e) {
			e.printStackTrace();					
		}finally{
			try {
				CommonUtils.getConnection().commit();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
		return rowDeleted1;	
	}
	
	public int updateRecord(PM_IL_DATA_UPLOAD_DEFN_HDR headerBean){
		Connection con = null;
		CRUDHandler handler = null;
		CommonUtils commonUtils = new CommonUtils();
		int rowCount = 0;
		try {
			con = CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				rowCount = handler.executeInsert(headerBean, con);
				if (rowCount != 0) {
					commonUtils.doComitt();
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	/**
	 * 
	 * @param PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN
	 */
	public void executeQuery(
			PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN) {
		CRUDHandler handler = null;
		Connection connection = null;
		String queryString = "SELECT ROWID,PM_IL_DATA_UPLOAD_DEFN_HDR.* FROM PM_IL_DATA_UPLOAD_DEFN_HDR WHERE ROWID = ? ";
		ResultSet result = null;

		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			result = handler.executeSelectStatement(queryString.toString(),
					connection,
					new Object[] { PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN
							.getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN().getROWID() });
			PM_IL_DATA_UPLOAD_DEFN_HDR PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN = PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN
			.getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN();
			if (result != null) {
				while (result.next()) {
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_DEF_CODE(result.getString("DUDH_DEF_CODE"));
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_DESC(result.getString("DUDH_DESC"));
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_SHORT_DESC(result.getString("DUDH_SHORT_DESC"));
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_LONG_DESC(result.getString("DUDH_LONG_DESC"));
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_EFF_FM_DT(result.getDate("DUDH_EFF_FM_DT"));
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_EFF_TO_DT(result.getDate("DUDH_EFF_TO_DT"));
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_BL_DESC(result.getString("DUDH_BL_DESC"));
                    PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_BL_LONG_DESC(result.getString("DUDH_BL_LONG_DESC")); 					
                    PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_BL_SHORT_DESC(result.getString("DUDH_BL_SHORT_DESC"));
                    PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_CR_DT(result.getDate("DUDH_CR_DT"));
                    PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_CR_UID(result.getString("DUDH_CR_UID"));
                    PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setROWID(result.getString("ROWID"));
					
                    PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN
							.setPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException exception) {
			exception.printStackTrace();
		}
		// return recordList;
	}
	
	public PM_IL_DATA_UPLOAD_DEFN_DTL populateDetailValues(PILM042_COMPOSITE_ACTION compositeAction){
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		PM_IL_DATA_UPLOAD_DEFN_DTL detailBean = null;
		String selectQuery = PILM042_QUERY_CONSTANTS.PILM042_DETAIL_QUERY;
		String rowId = compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN().getROWID();
		try {
			con = CommonUtils.getConnection();
			
			if(con != null){
				handler = new CRUDHandler();
				Object[] values={rowId};
				System.out.println("Values ROWID "+rowId);
				rst = handler.executeSelectStatement(selectQuery, con, values);
				while(rst.next()){
					detailBean = new PM_IL_DATA_UPLOAD_DEFN_DTL();
					detailBean.setROWID(rst.getString(1));
					detailBean.setDUDD_DUDH_DEF_CODE(rst.getString("DUDD_DUDH_DEF_CODE"));                         
					detailBean.setDUDD_SERIAL_NO(rst.getInt("DUDD_SERIAL_NO"));                                 
					detailBean.setDUDD_PARA_NAME(rst.getString("DUDD_PARA_NAME"));                                 
					detailBean.setDUDD_PARA_TYPE(rst.getString("DUDD_PARA_TYPE"));                                 
					detailBean.setDUDD_INPUT_DATA_TYPE(rst.getString("DUDD_INPUT_DATA_TYPE"));                     
					detailBean.setDUDD_FORMAT(rst.getString("DUDD_FORMAT"));                                       
					detailBean.setDUDD_TABLE_NAME(rst.getString("DUDD_TABLE_NAME"));                               
					detailBean.setDUDD_FIELD_NAME(rst.getString("DUDD_FIELD_NAME"));                               
					detailBean.setDUDD_LINK_COLUMN(rst.getString("DUDD_LINK_COLUMN"));                             
					detailBean.setDUDD_RET_PARA(rst.getString("DUDD_RET_PARA"));                                   
					detailBean.setDUDD_STORAGE_YN(rst.getString("DUDD_STORAGE_YN"));                               
					detailBean.setDUDD_LINK_SERIAL_NO(rst.getInt("DUDD_LINK_SERIAL_NO"));                       
					detailBean.setDUDD_CR_DT(rst.getDate("DUDD_CR_DT"));                                           
					detailBean.setDUDD_CR_UID(rst.getString("DUDD_CR_UID"));                                       
					detailBean.setDUDD_UPD_DT(rst.getDate("DUDD_UPD_DT"));                                         
					detailBean.setDUDD_UPD_UID(rst.getString("DUDD_UPD_UID"));
					System.out.println("sssssssssssssssssss "+rst.getFetchSize());
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return detailBean;
	}

	public int updateDetail(PM_IL_DATA_UPLOAD_DEFN_DTL detailBean) {
		Connection con = null;
		CRUDHandler handler = null;
		int rowCount = 0;
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				rowCount = handler.executeInsert(detailBean, con);
				if (rowCount != 0) {
					con.commit();
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
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
		}
		
		return rowCount;
	}
}
