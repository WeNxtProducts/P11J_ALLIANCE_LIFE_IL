package com.iii.pel.forms.PILT009;

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

public class PT_IL_FAC_PART_CHRG_HELPER {

	public void fetchRecord(PT_IL_FAC_PART_CHRG_ACTION facpartChargeAction) throws Exception {
		facpartChargeAction.setDataListPT_IL_FAC_PART_CHRG(EXECUTE_QUERY(facpartChargeAction.getPT_IL_FAC_PART_CUST_DETL_BEAN()));
		
		if (facpartChargeAction.getDataListPT_IL_FAC_PART_CHRG().size()>0) {
			facpartChargeAction.setPT_IL_FAC_PART_CHRG_BEAN(facpartChargeAction.getDataListPT_IL_FAC_PART_CHRG().get(0));
			facpartChargeAction.getPT_IL_FAC_PART_CHRG_BEAN().setRowSelected(true);
		}
		
		
		for(PT_IL_FAC_PART_CHRG facPartChargeBean : facpartChargeAction.getDataListPT_IL_FAC_PART_CHRG()) {
			PT_IL_FAC_PART_CHRG_POST_QUERY(facPartChargeBean);
		}
	}

	public List<PT_IL_FAC_PART_CHRG> EXECUTE_QUERY(PT_IL_FAC_PART_CUST_DETL facPartCustDtlBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		
		PT_IL_FAC_PART_CHRG facPartCustBean = null;
		List<PT_IL_FAC_PART_CHRG> list = null;
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = facPartCustDtlBean.getFPCUD_SYS_ID();
			resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_FAC_PART_CHRG, connection, values);
			
			list = new ArrayList<PT_IL_FAC_PART_CHRG>();

			while(resultSet.next()) {
				facPartCustBean = new PT_IL_FAC_PART_CHRG();
				
				facPartCustBean.setROWID(resultSet.getString(1));
				facPartCustBean.setFPC_SYS_ID(resultSet.getDouble(2));
				facPartCustBean.setFPC_FPCUD_SYS_ID(resultSet.getDouble(3));
				facPartCustBean.setFPC_SRNO(resultSet.getDouble(4));
				facPartCustBean.setFPC_CHRG_TYPE(resultSet.getString(5));
				facPartCustBean.setFPC_CHRG_CODE(resultSet.getString(6));
				facPartCustBean.setFPC_RATE(resultSet.getDouble(7));
				facPartCustBean.setFPC_RATE_PER(resultSet.getDouble(8));
				facPartCustBean.setFPC_APPLY_PERIOD(resultSet.getString(9));
				facPartCustBean.setFPC_CUST_SHARE_PERC(resultSet.getDouble(10));
				facPartCustBean.setFPC_FC_VALUE(resultSet.getDouble(11));
				facPartCustBean.setFPC_LC_VALUE(resultSet.getDouble(12));
				facPartCustBean.setFPC_CR_DT(resultSet.getDate(13));
				facPartCustBean.setFPC_CR_UID(resultSet.getString(14));
				facPartCustBean.setFPC_UPD_DT(resultSet.getDate(15));
				facPartCustBean.setFPC_UPD_UID(resultSet.getString(16));
				facPartCustBean.setRowSelected(false);
				
				list.add(facPartCustBean);
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
	
	public void PT_IL_FAC_PART_CHRG_POST_QUERY(PT_IL_FAC_PART_CHRG facPartChargeBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = facPartChargeBean.getFPC_CHRG_CODE();
			
			resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PC_DESC, connection, values);
			
			if(resultSet.next()) {
				facPartChargeBean.setUI_M_FPC_CHRG_CODE_DESC(resultSet.getString(1));
			} else {
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "3206", new Object[]{"Charge Code Does not Exists"}));
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
	}
}
