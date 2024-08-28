package com.iii.pel.forms.PILM042;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;


public class PM_IL_DATA_UPLOAD_DEFN_DTL_DELEGATE {
	
//	  public boolean saveRecord(PM_IL_DATA_UPLOAD_DEFN_DTL PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN,boolean doCommit) {
//			CommonUtils utility=new CommonUtils();
//			Connection connection=null;
//			boolean recordSaved=false;
//			
//			CRUDHandler handler=new CRUDHandler();
//			try {
//				connection=utility.getConnection();
//				handler.executeInsert(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN, connection);
//				recordSaved=true;
//				System.out.println("Insert/Update  successful");
//				if(doCommit){
//					connection.commit();
//				}	
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchMethodException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InstantiationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return recordSaved;
//		}

	
	public PM_IL_DATA_UPLOAD_DEFN_DTL executeQuery(PILM042_COMPOSITE_ACTION compositeAction){
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		PM_IL_DATA_UPLOAD_DEFN_DTL detailBean = null;
		String selectQuery = PILM042_QUERY_CONSTANTS.PILM042_DETAIL_QUERY;
		String rowId = compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN().getROWID();
		compositeAction.getPM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN()
		.getDataList_PM_IL_DATA_UPLOAD_DEFN_DTL().clear();
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
					compositeAction.getPM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN()
					.getDataList_PM_IL_DATA_UPLOAD_DEFN_DTL().add(detailBean);
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

}
