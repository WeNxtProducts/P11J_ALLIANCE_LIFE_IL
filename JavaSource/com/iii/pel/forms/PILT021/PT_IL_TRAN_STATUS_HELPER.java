package com.iii.pel.forms.PILT021;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_TRAN_STATUS_HELPER {
	DBProcedures procedures = new DBProcedures();

	public void executeQuery(PILT021_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_TRAN_STATUS_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_TRAN_STATUS> dataList = compositeAction.
		getPT_IL_TRAN_STATUS_ACTION_BEAN().getDataList_PT_IL_TRAN_STATUS();
		if(dataList!=null && dataList.size() > 0){
			PT_IL_TRAN_STATUS PT_IL_TRAN_STATUS_BEAN = dataList.get(0);
			PT_IL_TRAN_STATUS_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_TRAN_STATUS_ACTION_BEAN()
			.setPT_IL_TRAN_STATUS_BEAN(PT_IL_TRAN_STATUS_BEAN);
		}
	}
	public void postQuery(PT_IL_TRAN_STATUS pt_il_tran_status) throws Exception{
		String M_PS_VALUE = null;
		ArrayList<String> outList = null;
		try {
			outList = new ArrayList<String>();
			outList = DBProcedures.P_VAL_SYSTEM("IL_TRAN_STAT", pt_il_tran_status.getTS_STATUS_CODE(), 
					null, "N", M_PS_VALUE);
			pt_il_tran_status.setUI_M_WD_STATUS_CODE_DESC(outList.get(0));
			if(pt_il_tran_status.getTS_REASON_CODE() != null){
				outList = procedures.helperP_VAL_CODES("IL_REASON", 
						pt_il_tran_status.getTS_REASON_CODE(), "N", "N", null);
				pt_il_tran_status.setUI_M_TS_REASON_CODE_DESC(outList.get(0));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void preQuery(PT_IL_TRAN_STATUS pt_il_tran_status, PT_IL_WITHDRAWAL pt_il_withdrawal){
		pt_il_tran_status.setTS_TRAN_SYS_ID(pt_il_withdrawal.getWD_SYS_ID());
		pt_il_tran_status.setTS_POL_SYS_ID(pt_il_withdrawal.getWD_POL_SYS_ID());
		pt_il_tran_status.setTS_TRAN_TYPE("W");
	}
	
	public void preInsert(PT_IL_TRAN_STATUS pt_il_tran_status_bean,
			PT_IL_WITHDRAWAL pt_il_withdrawal_bean) { 
		
		pt_il_tran_status_bean.setTS_TRAN_SYS_ID(pt_il_withdrawal_bean.getWD_SYS_ID());
		pt_il_tran_status_bean.setTS_POL_SYS_ID(pt_il_withdrawal_bean.getWD_POL_SYS_ID());
	}
}
