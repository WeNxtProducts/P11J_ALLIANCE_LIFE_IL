package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_WITHDRAWAL_PROCESS;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_WITHDRAWAL_UNIT_HELPER {
	P9ILPK_WITHDRAWAL_PROCESS p9ilpk_withdrawal_process = new P9ILPK_WITHDRAWAL_PROCESS();

	public void executeQuery(PILT021_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_WITHDRAWAL_UNIT_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_WITHDRAWAL_UNIT> dataList = compositeAction.
		getPT_IL_WITHDRAWAL_UNIT_ACTION_BEAN().getDataList_PT_IL_WITHDRAWAL_UNIT();
		if(dataList!=null && dataList.size() > 0){
			PT_IL_WITHDRAWAL_UNIT PT_IL_WITHDRAWAL_UNIT_BEAN = dataList.get(0);
			PT_IL_WITHDRAWAL_UNIT_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_WITHDRAWAL_UNIT_ACTION_BEAN()
			.setPT_IL_WITHDRAWAL_UNIT_BEAN(PT_IL_WITHDRAWAL_UNIT_BEAN);
		}
	}
	public void postQuery(PT_IL_WITHDRAWAL_UNIT pt_il_withdrawal_unit) throws Exception{
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT POL_NO FROM PT_IL_POLICY WHERE POL_SYS_ID=?";
			resultSetC1 = handler.executeSelectStatement(C1, connection, 
					new Object[]{pt_il_withdrawal_unit.getWDU_POL_SYS_ID()});
			if (resultSetC1.next()) {
				pt_il_withdrawal_unit.setUI_M_WDU_POL_NO(resultSetC1.getString(1));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void WHEN_NEW_BLOCK_INSTANCE(PT_IL_WITHDRAWAL_UNIT_ACTION withdrawalUnitAction, 
			PT_IL_WITHDRAWAL withdrawalBean, CTRL ctrl) throws Exception{
		try {
			if("U".equals(withdrawalBean.getWD_TYPE())){
				p9ilpk_withdrawal_process.INS_WITHDRAW_UNIT_REC(
						CommonUtils.getProcedureValue(withdrawalBean.getWD_POL_SYS_ID()), 
						CommonUtils.getProcedureValue(withdrawalBean.getWD_SYS_ID()));
			}
			/*	IF :SYSTEM.FORM_STATUS = 'CHANGED' OR :SYSTEM.BLOCK_STATUS = 'CHANGED'THEN
		COPY('P','CTRL.M_COMM_DEL') ;
		COPY('20','SYSTEM.MESSAGE_LEVEL');
		POST;                  
		COPY('0','SYSTEM.MESSAGE_LEVEL');
		COPY('','CTRL.M_COMM_DEL') ;
		END IF;
		COPY('20','SYSTEM.MESSAGE_LEVEL');
		EXECUTE_QUERY; 
		COPY('0','SYSTEM.MESSAGE_LEVEL');*/

			withdrawalUnitAction.setINSERT_ALLOWED(false);
			withdrawalUnitAction.setDELETE_ALLOWED(false);
			if("A".equals(withdrawalBean.getWD_APPRV_STATUS())){
				withdrawalUnitAction.setINSERT_ALLOWED(false);
				withdrawalUnitAction.setDELETE_ALLOWED(false);
				withdrawalUnitAction.setUPDATE_ALLOWED(false);
			}
		} catch (ProcedureException e) {
			throw new Exception(e.getMessage());
		}
	}
	public void WHEN_NEW_RECORD_INSTANCE(PT_IL_WITHDRAWAL_UNIT_ACTION withdrawalUnitAction){
		PT_IL_WITHDRAWAL_UNIT pt_il_withdrawal_unit = withdrawalUnitAction.getPT_IL_WITHDRAWAL_UNIT_BEAN();
		if("U".equals(pt_il_withdrawal_unit.getWDU_TYPE())){
			withdrawalUnitAction.getCOMP_WDU_WD_FC_AMT().setDisabled(true);
			withdrawalUnitAction.getCOMP_WDU_WD_UNIT().setDisabled(false);
		}else if("A".equals(pt_il_withdrawal_unit.getWDU_TYPE())){
			withdrawalUnitAction.getCOMP_WDU_WD_UNIT().setDisabled(true);
			withdrawalUnitAction.getCOMP_WDU_WD_FC_AMT().setDisabled(false);
		}
	}
	public void WHEN_WDU_TYPE_LIST_CHANGED(PT_IL_WITHDRAWAL_UNIT_ACTION withdrawalUnitAction){
		PT_IL_WITHDRAWAL_UNIT pt_il_withdrawal_unit = withdrawalUnitAction.getPT_IL_WITHDRAWAL_UNIT_BEAN();
		if("U".equals(pt_il_withdrawal_unit.getWDU_TYPE())){
			withdrawalUnitAction.getCOMP_WDU_WD_FC_AMT().setDisabled(true);
			withdrawalUnitAction.getCOMP_WDU_WD_UNIT().setDisabled(false);
		}else if("A".equals(pt_il_withdrawal_unit.getWDU_TYPE())){
			withdrawalUnitAction.getCOMP_WDU_WD_UNIT().setDisabled(true);
			withdrawalUnitAction.getCOMP_WDU_WD_FC_AMT().setDisabled(false);
		}
	}
	public void WHEN_VALIDATE_WDU_WD_UNIT(PT_IL_WITHDRAWAL_UNIT pt_il_withdrawal_unit, 
			Double UI_M_POL_CUST_EXCH_RATE, Double WDU_WD_UNIT) throws Exception{
		Double MCOVER_VAR_VALUE = null;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT COVER_VAR_VALUE FROM PM_IL_COVER WHERE COVER_CODE=?";
			if("U".equals(pt_il_withdrawal_unit.getWDU_TYPE())){
				resultSetC1 = handler.executeSelectStatement(C1, connection, 
						new Object[]{pt_il_withdrawal_unit.getWDU_COVER_CODE()});
				if (resultSetC1.next()) {
					MCOVER_VAR_VALUE = resultSetC1.getDouble(1);
				}
				pt_il_withdrawal_unit.setWDU_WD_FC_AMT(WDU_WD_UNIT*MCOVER_VAR_VALUE);
				pt_il_withdrawal_unit.setWDU_WD_LC_AMT(
						pt_il_withdrawal_unit.getWDU_WD_FC_AMT()*UI_M_POL_CUST_EXCH_RATE);
				if(WDU_WD_UNIT > pt_il_withdrawal_unit.getWDU_AVBL_UNIT()){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91902", 
							new Object[]{"Units"}));
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void WHEN_VALIDATE_WDU_WD_FC_AMT(PT_IL_WITHDRAWAL_UNIT pt_il_withdrawal_unit, 
			Double UI_M_POL_CUST_EXCH_RATE, Double WDU_WD_FC_AMT) throws Exception{
		Double MCOVER_VAR_VALUE = null;
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT COVER_VAR_VALUE FROM PM_IL_COVER WHERE COVER_CODE=?";
			if("A".equals(pt_il_withdrawal_unit.getWDU_TYPE())){
				resultSetC1 = handler.executeSelectStatement(C1, connection, 
						new Object[]{pt_il_withdrawal_unit.getWDU_COVER_CODE()});
				if (resultSetC1.next()) {
					MCOVER_VAR_VALUE = resultSetC1.getDouble(1);
				}
				pt_il_withdrawal_unit.setWDU_WD_UNIT(WDU_WD_FC_AMT/MCOVER_VAR_VALUE);
				pt_il_withdrawal_unit.setWDU_WD_LC_AMT(
						WDU_WD_FC_AMT*UI_M_POL_CUST_EXCH_RATE);
				if(pt_il_withdrawal_unit.getWDU_WD_UNIT() > pt_il_withdrawal_unit.getWDU_AVBL_UNIT()){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91902", 
							new Object[]{"Amount"}));
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void preInsert(PT_IL_WITHDRAWAL_UNIT pt_il_withdrawal_unit_bean,
			PILT021_COMPOSITE_ACTION compositeAction) {
		Long sysID=compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_SYS_ID();
		Long polSysID=compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_POL_SYS_ID();
		pt_il_withdrawal_unit_bean.setWDU_WD_SYS_ID(sysID);
		pt_il_withdrawal_unit_bean.setWDU_SYS_ID(sysID);
		pt_il_withdrawal_unit_bean.setWDU_POL_SYS_ID(polSysID);
	}
}
