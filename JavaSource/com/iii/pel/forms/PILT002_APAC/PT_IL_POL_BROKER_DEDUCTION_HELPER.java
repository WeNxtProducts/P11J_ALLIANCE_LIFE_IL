package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.utl_smtp.connection;

public class PT_IL_POL_BROKER_DEDUCTION_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try{
		new PT_IL_POL_BROKER_DEDUCTION_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_POL_BROKER_DEDUCTION> dataList = compositeAction
				.getPT_IL_POL_BROKER_DEDUCTION_ACTION_BEAN()
				.getDataList_PT_IL_POL_BROKER_DEDUCTION();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_BROKER_DEDUCTION PT_IL_POL_BROKER_DEDUCTION_BEAN = dataList.get(0);
			PT_IL_POL_BROKER_DEDUCTION_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_BROKER_DEDUCTION_ACTION_BEAN()
					.setPT_IL_POL_BROKER_DEDUCTION_BEAN(PT_IL_POL_BROKER_DEDUCTION_BEAN);
		}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
	}

	public void preInsert(PT_IL_POL_BROKER_HEAD brokerHeadBean,
			PT_IL_POL_BROKER_DEDUCTION brokerDeductionBean, CTRL ctrlBean)
			throws Exception {

		String CURSOR_C1 = " SELECT POBD_YEAR_FROM, POBD_YEAR_TO FROM PT_IL_POL_BROKER_DTL WHERE   POBD_POBH_SYS_ID  =  ? ";
		String CURSOR_C2 = " SELECT PIL_PBDED_SYS_ID.NEXTVAL FROM   DUAL ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection);
			if (resultSet.next()) {
				brokerDeductionBean.setPBDED_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			brokerDeductionBean.setPBDED_POBH_SYS_ID(brokerHeadBean.getPOBH_SYS_ID());
			
			brokerDeductionBean.setPBDED_CR_DT(new CommonUtils().getCurrentDate());
			brokerDeductionBean.setPBDED_CR_UID(ctrlBean.getUSER_ID());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void whenNewBlockInstance(PT_IL_POL_BROKER_DTL_ACTION brokerAction,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		String M_PROD_TRAN_RATE_YN = null;
		String CURSOR_C1 = "SELECT PROD_TRAN_RATE_YN FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		ResultSet resultSet = null;
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		Connection connection = null;
		PT_IL_POL_BROKER_DTL_DELEGATE delegate = new PT_IL_POL_BROKER_DTL_DELEGATE();
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { policyBean.getPOL_PROD_CODE() });
			if (resultSet.next()) {
				M_PROD_TRAN_RATE_YN = resultSet.getString(1);
			}
			if ("Y".equals(M_PROD_TRAN_RATE_YN)) {
				brokerAction.setINSERT_ALLOWED(true);
				brokerAction.setUPDATE_ALLOWED(true);
				brokerAction.setDELETE_ALLOWED(true);
			} else if ("N".equals(M_PROD_TRAN_RATE_YN)) {
				brokerAction.setINSERT_ALLOWED(false);
				brokerAction.setUPDATE_ALLOWED(false);
				brokerAction.setDELETE_ALLOWED(false);
			}
			delegate.executeSelectStatement(compositeAction);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void preUpdate(PT_IL_POL_BROKER_HEAD brokerHeadBean,
			PT_IL_POL_BROKER_DEDUCTION brokerDeductionBean, CTRL ctrlBean)
			throws Exception {

		
		try {
			
			brokerDeductionBean.setPBDED_UPD_DT(new CommonUtils().getCurrentDate());
			brokerDeductionBean.setPBDED_UPD_UID(ctrlBean.getUSER_ID());
				
			
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
		

	}
	public void setcodedesc(PT_IL_POL_BROKER_DEDUCTION brokerDeductionBean)throws Exception{
		try{
			ResultSet rs =null;
			String c1= "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_CODE=?";
			String desc =null;
		if(brokerDeductionBean.getPBDED_CODE()!=null){
			Connection con= CommonUtils.getConnection();
			CRUDHandler handler= new CRUDHandler();
			
			rs= handler.executeSelectStatement(c1, con, new Object[]{brokerDeductionBean.getPBDED_CODE()});
			while(rs.next()){
				desc=rs.getString(1);
				
			}
			brokerDeductionBean.setUI_M_PBDED_CODE_DESC(desc);
			
		}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	

	
}
