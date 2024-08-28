package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_WITHDRAWAL_CHARGE_DELEGATE {
	public void executeSelectStatement(PILT021_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_WITHDRAWAL_CHARGE.* FROM " +
				"PT_IL_WITHDRAWAL_CHARGE WHERE WDC_WD_SYS_ID = ?";
		Connection connection = null;
		ResultSet RST = null;
		CRUDHandler handler = new CRUDHandler();
		compositeAction.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN()
				.getDataList_PT_IL_WITHDRAWAL_CHARGE().clear();
		
		/*added by raja on 24-04-2017*/
		PT_IL_WITHDRAWAL_CHARGE_HELPER helper=new PT_IL_WITHDRAWAL_CHARGE_HELPER();
		
		/*end*/
		
		try {
			connection = CommonUtils.getConnection();
			if(compositeAction.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN().getDEFAULT_WHERE() != null){
				selectStatement = selectStatement + " AND " + 
					compositeAction.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN().getDEFAULT_WHERE();
			}
			RST = handler.executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_SYS_ID() });
			while (RST.next()) {
				PT_IL_WITHDRAWAL_CHARGE PT_IL_WITHDRAWAL_CHARGE_BEAN = new PT_IL_WITHDRAWAL_CHARGE();
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setROWID(RST
						.getString("ROWID"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_SYS_ID(RST
						.getLong("WDC_SYS_ID"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_WD_SYS_ID(RST
						.getLong("WDC_WD_SYS_ID"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_CHRG_CODE(RST
						.getString("WDC_CHRG_CODE"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_RATE(RST
						.getDouble("WDC_RATE"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_RATE_PER(RST
						.getDouble("WDC_RATE_PER"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_CUST_SHARE_PERC(RST
						.getDouble("WDC_CUST_SHARE_PERC"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_LC_VALUE(RST
						.getDouble("WDC_LC_VALUE"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_FC_VALUE(RST
						.getDouble("WDC_FC_VALUE"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_CR_DT(RST
						.getDate("WDC_CR_DT"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_CR_UID(RST
						.getString("WDC_CR_UID"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_UPD_DT(RST
						.getDate("WDC_UPD_DT"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_UPD_UID(RST
						.getString("WDC_UPD_UID"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_PREM_LC_VALUE(RST
						.getDouble("WDC_PREM_LC_VALUE"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_PREM_FC_VALUE(RST
						.getDouble("WDC_PREM_FC_VALUE"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_TOP_UP_LC_VALUE(RST
						.getDouble("WDC_TOP_UP_LC_VALUE"));
				PT_IL_WITHDRAWAL_CHARGE_BEAN.setWDC_TOP_UP_FC_VALUE(RST
						.getDouble("WDC_TOP_UP_FC_VALUE"));

				
				/*added by raja on 24-04-2017*/
				helper.postQuery(PT_IL_WITHDRAWAL_CHARGE_BEAN);
				/*end*/
				

				
				compositeAction.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN()
						.getDataList_PT_IL_WITHDRAWAL_CHARGE().add(
								PT_IL_WITHDRAWAL_CHARGE_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(RST);
		}
	}

}
