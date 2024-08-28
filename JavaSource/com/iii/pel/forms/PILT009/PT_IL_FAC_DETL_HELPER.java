package com.iii.pel.forms.PILT009;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_DETL_HELPER {

	public void PT_IL_FAC_DETL_WHEN_NEW_BLOCK_INSTANCE(PT_IL_FAC_DETL_ACTION facDtlAction) throws Exception {
		
		String M_PROD_CODE = null;
		String M_ASD_CHAR_VALUE = null;
		
		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2= null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION().getDUMMY_BEAN().getUI_M_POL_NO();
			
			resultSet1 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_POL_PROD_CODE, connection, values);
			
			if(resultSet1.next()) {
				M_PROD_CODE = resultSet1.getString(1);
			}
			
			/*values = new Object[1];
			values[0] = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			values[0] = M_PROD_CODE;*/
			values=new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),M_PROD_CODE};
			resultSet2 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_ASD_CHAR_VALUE, connection, values);
			
			if(resultSet2.next()) {
				M_ASD_CHAR_VALUE = resultSet2.getString(1);
			}
			
			if("N".equals(M_ASD_CHAR_VALUE)) {
				//facDtlAction.setFcFacSAreadOnly(true);
				facDtlAction.getCOMP_FD_FC_FAC_SA().setDisabled(true);
				
			} else {
				//facDtlAction.setFcFacSAreadOnly(false);
				facDtlAction.getCOMP_FD_FC_FAC_SA().setDisabled(false);
				
				 /*Added by Ameen on 14-09-2017 as per Gaurav sugg. for ZBILQC-1736379*/
				 System.out.println("UI_M_FAC_CLOSE_FLAG :::::::" + compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION().getDUMMY_BEAN().getUI_M_FAC_CLOSE_FLAG());
				 if(CommonUtils.nvl(compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION().getDUMMY_BEAN().getUI_M_FAC_CLOSE_FLAG(),"N").equals("Y")){
					   compositeAction.getPILT009_PT_IL_FAC_DETL_ACTION().getCOMP_FD_FC_FAC_SA().setDisabled(true);
				 }
				 /*End*/
			}
			
			//TODO L_FAC_INS_LOAD proc call
			
			fetchRecord(compositeAction);
			
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
		}
		
	}
	
	public void fetchRecord(PILT009_COMPOSITE_ACTION compositeAction) throws Exception {
		
		PT_IL_FAC_DETL_ACTION facDtlAction = compositeAction.getPILT009_PT_IL_FAC_DETL_ACTION();
		
		facDtlAction.setDataListPT_IL_FAC_DETL(EXECUTE_QUERY(facDtlAction.getPT_IL_FAC_OUT_BEAN()));
		if (facDtlAction.getDataListPT_IL_FAC_DETL().size() > 0) {
			facDtlAction.setPT_IL_FAC_DETL_BEAN(facDtlAction.getDataListPT_IL_FAC_DETL().get(0));
			facDtlAction.getPT_IL_FAC_DETL_BEAN().setRowSelected(true);
		}
	           
	}
	
	private ArrayList<PT_IL_FAC_DETL> EXECUTE_QUERY(PT_IL_FAC_OUT facOutBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		
		PT_IL_FAC_DETL facDtlBean = null;
		ArrayList<PT_IL_FAC_DETL> list = null;
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = facOutBean.getFO_SYS_ID();
			
			resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_FAC_DETL2, connection, values);
			
			list = new ArrayList <PT_IL_FAC_DETL>();
			while(resultSet.next()) {
				
				facDtlBean = new PT_IL_FAC_DETL();
				
				facDtlBean.setROWID(resultSet.getString(1));
				facDtlBean.setFD_SYS_ID(resultSet.getDouble(2));
				facDtlBean.setFD_FO_SYS_ID(resultSet.getDouble(3));
				facDtlBean.setFD_SCHD_PYMT_DT(resultSet.getDate(4));
				facDtlBean.setFD_YEAR(resultSet.getInt(5));
				facDtlBean.setFD_ASSURED_AGE(resultSet.getInt(6));
				facDtlBean.setFD_TAR_RATE(resultSet.getDouble(7));
				facDtlBean.setFD_FC_SA(resultSet.getDouble(8));
				facDtlBean.setFD_LC_SA(resultSet.getDouble(9));
				facDtlBean.setFD_FC_PREM(resultSet.getDouble(10));
				facDtlBean.setFD_LC_PREM(resultSet.getDouble(11));
				facDtlBean.setFD_FC_FAC_SA(resultSet.getDouble(12));
				facDtlBean.setFD_LC_FAC_SA(resultSet.getDouble(13));
				facDtlBean.setFD_FC_FAC_PREM(resultSet.getDouble(14));
				facDtlBean.setFD_LC_FAC_PREM(resultSet.getDouble(15));
				facDtlBean.setFD_FAC_CLOSE_YN(resultSet.getString(16));
				facDtlBean.setFD_DEL_FLAG(resultSet.getString(17));
				facDtlBean.setFD_CR_DT(resultSet.getDate(18));
				facDtlBean.setFD_CR_UID(resultSet.getString(19));
				facDtlBean.setFD_TAR_RATE_PER(resultSet.getDouble(20));
				facDtlBean.setFD_PC_SYS_ID(resultSet.getDouble(21));
				facDtlBean.setFD_FC_EXTRA_PREM(resultSet.getDouble(22));
				facDtlBean.setFD_LC_EXTRA_PREM(resultSet.getDouble(23));
				facDtlBean.setFD_FC_FAC_GRS_PREM(resultSet.getDouble(24));
				facDtlBean.setFD_LC_FAC_GRS_PREM(resultSet.getDouble(25));
				facDtlBean.setFD_APPRV_UID(resultSet.getString(26));
				facDtlBean.setFD_APPRV_DT(resultSet.getDate(27));
				facDtlBean.setRowSelected(false);
				
				list.add(facDtlBean);
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		
		return list;
	}
}
