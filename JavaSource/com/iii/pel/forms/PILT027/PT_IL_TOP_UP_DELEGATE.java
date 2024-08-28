package com.iii.pel.forms.PILT027;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_TOP_UP_DELEGATE {
	
	
	public int executeInsert(PT_IL_TOP_UP pt_il_top_u) throws Exception {
		int status=0;
			Connection connection=CommonUtils.getConnection();
			status=new CRUDHandler().executeInsert(pt_il_top_u,connection); 
			connection.commit();
		return status;
	} 
	
	
	
	
	public int executeUpdate(PT_IL_TOP_UP pt_il_top_u) {
		int status = 0;
		try {
			Connection connection=CommonUtils.getConnection();
			new CRUDHandler().executeUpdate(pt_il_top_u,connection); 
			connection.commit();
		} 
		catch(Exception e){ 
			e.printStackTrace();} 
		return status;
	} 
	
	
	public boolean saveRecord(PT_IL_TOP_UP pt_il_top_up, 
		boolean doCommit) {
	Connection connection=null;
	boolean recordSaved=false;
	CRUDHandler handler=new CRUDHandler();
	try {
		connection=CommonUtils.getConnection();
		
		if(pt_il_top_up.getROWID()==null){
			
			handler.executeInsert(pt_il_top_up, connection);
		}else{
			handler.executeUpdate(pt_il_top_up, connection);
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

	public void preInsert(PT_IL_TOP_UP pt_il_top_up_bean) {
		
		String query = "SELECT PIL_TU_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet rs = null;
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		try {
			connection=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(query, connection);
			while(rs.next()){
				pt_il_top_up_bean.setTU_SYS_ID(rs.getLong(1)); 
			}
		} catch (Exception e) {
			throw new ValidatorException(Messages.getMessage("TOP_UP_SYS_ID",e.getMessage()));
		}
		
	}

	public void executeSelectStatement(
			PILT027_COMPOSITE_ACTION pilt027_composite_action) throws Exception {
		ResultSet resultSet = null;
		String selectQuery1 = "SELECT PT_IL_TOP_UP.*,ROWID FROM PT_IL_TOP_UP WHERE ROWID = ? ";
		String selectQuery2 = "SELECT PT_IL_TOP_UP.*,ROWID FROM PT_IL_TOP_UP WHERE TU_SYS_ID = ? ";
		try {
			if (pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN()
					.getPT_IL_TOP_UP_BEAN().getTU_SYS_ID() != null) {
				resultSet = new CRUDHandler().executeSelectStatement(selectQuery2,
						CommonUtils.getConnection(),
						new Object[] { pilt027_composite_action
								.getPT_IL_TOP_UP_ACTION_BEAN()
								.getPT_IL_TOP_UP_BEAN().getTU_SYS_ID() });

			}
			else{
			resultSet = new CRUDHandler().executeSelectStatement(selectQuery1,
					CommonUtils.getConnection(),
					new Object[] { pilt027_composite_action
							.getPT_IL_TOP_UP_ACTION_BEAN()
							.getPT_IL_TOP_UP_BEAN().getROWID() });
			}
			PT_IL_TOP_UP bean = new PT_IL_TOP_UP();
			while (resultSet.next()) {
				bean.setTU_CUST_REF_ID1(resultSet.getString("TU_CUST_REF_ID1"));
				bean.setTU_CUST_REF_ID2(resultSet.getString("TU_CUST_REF_ID2"));
				bean.setTU_CUST_CODE(resultSet.getString("TU_CUST_CODE"));
				bean.setTU_POL_SYS_ID(resultSet.getInt("TU_POL_SYS_ID"));
				bean.setTU_POL_NO(resultSet.getString("TU_POL_NO"));
				bean.setTU_CONTROL_NO(resultSet.getString("TU_CONTROL_NO"));
				bean.setTU_TXN_CODE(resultSet.getString("TU_TXN_CODE"));
				bean.setTU_LC_TOPUP_DEP_AMT(resultSet
						.getDouble("TU_LC_TOPUP_DEP_AMT"));
				bean.setTU_DOC_NO(resultSet.getInt("TU_DOC_NO"));
				bean.setTU_DATE(resultSet.getDate("TU_DATE"));
				bean.setTU_DOC_DT(resultSet.getDate("TU_DOC_DT"));
				bean.setTU_LC_TOPUP_CHRG_AMT(resultSet
						.getDouble("TU_LC_TOPUP_CHRG_AMT"));
				bean.setTU_LC_TOPUP_NET_AMT(resultSet
						.getDouble("TU_LC_TOPUP_NET_AMT"));
				bean.setTU_BANK_CODE(resultSet.getString("TU_BANK_CODE"));
				bean.setTU_REASON_CODE(resultSet.getString("TU_REASON_CODE"));
				bean.setTU_REVERSE_FLAG(resultSet.getString("TU_REVERSE_FLAG"));
				bean.setTU_APPRV_STATUS(resultSet.getString("TU_APPRV_STATUS"));

				bean.setTU_APPRV_DT(resultSet.getDate("TU_APPRV_DT"));
				bean.setTU_APPRV_UID(resultSet.getString("TU_APPRV_UID"));
				bean.setTU_CR_DT(resultSet.getDate("TU_CR_DT"));
				bean.setTU_CR_UID(resultSet.getString("TU_CR_UID"));
				bean.setTU_UPD_DT(resultSet.getDate("TU_UPD_DT"));
				bean.setTU_UPD_UID(resultSet.getString("TU_UPD_UID"));
				bean.setTU_REVERSE_FLAG(resultSet.getString("TU_REMARKS"));
				bean
						.setTU_APPRV_STATUS(resultSet
								.getString("TU_CHRG_TXN_CODE"));
				bean.setTU_APPRV_STATUS(resultSet.getString("TU_CHRG_DOC_NO"));
				bean.setTU_APPRV_STATUS(resultSet.getString("TU_CONTROL_NO"));
				bean.setTU_APPRV_STATUS(resultSet.getString("TU_PAID_FOR"));
				bean
						.setTU_APPRV_STATUS(resultSet
								.getString("TU_PD_DPD_REF_ID"));
				bean.setTU_APPRV_STATUS(resultSet.getString("TU_UNIT_YN"));
				bean.setTU_APPRV_STATUS(resultSet.getString("TU_CHRG_FLAG"));
				bean.setTU_COMM_FLAG(resultSet.getString("TU_COMM_FLAG"));
				bean.setTU_WAK_FEE(resultSet.getInt("TU_WAK_FEE"));
				bean.setTU_SYS_ID(resultSet.getLong("TU_SYS_ID"));
				bean.setROWID(resultSet.getString("ROWID"));
			}

			if (bean != null && bean.getTU_CUST_CODE() != null
					&& !bean.getTU_CUST_CODE().isEmpty()) {
				String desc = getcustDesc(bean.getTU_CUST_CODE());
				bean.setUI_M_TU_CUST_NAME(desc);

			}

			if (bean != null && bean.getTU_BANK_CODE() != null
					&& !bean.getTU_BANK_CODE().isEmpty()) {
				String desc = getTU_BANK_CODE(bean.getTU_BANK_CODE());
				bean.setUI_M_TU_BANK_NAME(desc);
			}

			if (bean != null && bean.getTU_REASON_CODE() != null
					&& !bean.getTU_REASON_CODE().isEmpty()) {
				String desc = getReasonCode(bean.getTU_REASON_CODE());
				bean.setUI_M_REASON_DESC(desc);
			}

			pilt027_composite_action.getPT_IL_TOP_UP_ACTION_BEAN()
					.setPT_IL_TOP_UP_BEAN(bean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	

	
	private String getTU_BANK_CODE(String tu_bank_code) {
		
		String query = " SELECT BANK_NAME FROM FM_BANK WHERE BANK_CODE ='"+tu_bank_code+"'";
		ResultSet rs = null;
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		String tubankcode="";
		try {
			connection=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(query, connection);
			while(rs.next()){
				tubankcode=rs.getString(1); 
			}
		} catch (Exception e) {
			throw new ValidatorException(Messages.getMessage("tubankcode",e.getMessage()));
		}
		return tubankcode;
	}
 



	private String getcustDesc(String tu_cust_code) {
		
		String query = " SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE ='"+tu_cust_code+"'";
		ResultSet rs = null;
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		String custname="";
		try {
			connection=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(query, connection);
			while(rs.next()){
				custname=rs.getString(1); 
			}
		} catch (Exception e) {
			throw new ValidatorException(Messages.getMessage("CUST_NAME",e.getMessage()));
		}
		return custname;
	}




	public int executeDelete(PT_IL_TOP_UP pt_il_top_up_bean) { 
		int status = 0;
		try {
			Connection connection=CommonUtils.getConnection();
			new CRUDHandler().executeDelete(pt_il_top_up_bean,connection);
			connection.commit();
		} 
		catch(Exception e){ 
			e.printStackTrace();} 
		return status;
	} 
	
	
	public String getReasonCode(String reasonCode)
			
	throws Exception {
		//ArrayList<String> list = null;
		String query = "  SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE LIKE 'IL_REASON'  ";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String reasonCodeDesc=null;
		try {
			con=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(query, con);
			if(rs.next())
			{
				reasonCodeDesc=rs.getString(1);
			}
			} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(Messages.getMessage("CUST_NAME",e.getMessage()));
			
		}
			return reasonCodeDesc;
	}
}
