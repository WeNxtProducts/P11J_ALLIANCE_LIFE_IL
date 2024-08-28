package com.iii.pel.forms.PILQ106_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_UNIT_FUND_CHARGE_DELEGATE {
	
	public void executeStatement(PILQ106_APAC_COMPOSITE_ACTION compAction){
		/*
		 * modified by Ameen on 14-05-2018 as per Vaithi sugg.
		 * String qry = " SELECT UNFC_CHRG_DESC,UNFC_CHRG_VAL  FROM PT_IL_UNIT_FND_CHARGE WHERE UNFC_POL_SYS_ID = ?";*/
		/*
		 * 
		 * commented by Dhinesh on 07-06-2018 suggested by Vaithi
		 * 
		 * String qry = "SELECT UNFC_CHRG_DESC,UNFC_CHRG_VAL FROM PT_IL_UNIT_FND_CHARGE WHERE UNFC_POL_SYS_ID = ? "
				+ "AND UNFC_SYS_ID = (SELECT MAX(UNFC_SYS_ID) FROM PT_IL_UNIT_FND_CHARGE WHERE UNFC_POL_SYS_ID = ?)";*/
		
		
		String qry = "SELECT UNFC_CHRG_DESC, UNFC_CHRG_VAL  FROM PT_IL_UNIT_FND_CHARGE  where UNFC_UFRH_SYS_ID = ? ";
		
		ResultSet rs = null;
		Connection conn = null;
		if(!compAction.getPT_IL_UNIT_FUND_CHARGE_ACTION_BEAN().getDataList_PT_IL_UNIT_FUND_CHARGE().isEmpty()){
			compAction.getPT_IL_UNIT_FUND_CHARGE_ACTION_BEAN().getDataList_PT_IL_UNIT_FUND_CHARGE().clear();
		}
		try {
			conn = CommonUtils.getConnection();
			/*
			 * 
			 * commented by dhinesh on 07-06-2018 for 
			 * 
			 * rs = new CRUDHandler().executeSelectStatement(qry, conn,
						new Object[]{compAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getPOL_SYS_ID(),compAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getPOL_SYS_ID()});*/
			
			rs = new CRUDHandler().executeSelectStatement(qry, conn,
					new Object[]{compAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN().getPT_IL_UNIT_FUND_REG_HDR_BEAN().getUFRH_SYS_ID()});
			
			PT_IL_UNIT_FUND_CHARGE pt_il_unit_fund_charge_bean = null;
			while(rs.next()){
				pt_il_unit_fund_charge_bean = new PT_IL_UNIT_FUND_CHARGE();
				pt_il_unit_fund_charge_bean.setUNFC_CHRG_DES(rs.getString("UNFC_CHRG_DESC"));
				pt_il_unit_fund_charge_bean.setUNFC_CHRG_VAL(rs.getString("UNFC_CHRG_VAL"));
				
				compAction.getPT_IL_UNIT_FUND_CHARGE_ACTION_BEAN().getDataList_PT_IL_UNIT_FUND_CHARGE().add(pt_il_unit_fund_charge_bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
