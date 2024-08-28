package com.iii.pel.forms.PILP023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PREM_COLL_HELPER {

	@SuppressWarnings("unchecked")
	public void prem_coll_query(PILP023_COMPOSITE_ACTION compositeAction)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		//PILP023_COMPOSITE_ACTION compositeAction = (PILP023_COMPOSITE_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILP023_COMPOSITE_ACTION");
		PT_IL_PREM_COLL_ACTION collAction = compositeAction.getPILP023_PT_IL_PREM_COLL_ACTION();
		PT_IL_CHEQUE_BOUNCE_HDR chequeHdr = compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
//		PT_IL_PREM_COLL premiumColl = compositeAction.getPILP023_PT_IL_PREM_COLL_ACTION().getPT_IL_PREM_COLL_BEAN();
//		List<PT_IL_PREM_COLL> collList = compositeAction.getPILP023_PT_IL_PREM_COLL_ACTION().getTableList();
		ArrayList<PT_IL_PREM_COLL> collList = null;
		
		String query = "SELECT PC_SCHD_PYMT_DT, PC_FC_GROSS_PREM, PC_LC_GROSS_PREM," +
						 " PC_PAID_DT, PC_FC_PAID_AMT, PC_LC_PAID_AMT," +
						 	" PC_FC_AVLB_BAL_AMT, PC_LC_AVLB_BAL_AMT" +
						 		" FROM PT_IL_PREM_COLL" +
						 			" WHERE PC_SYS_ID = NVL(?,0)" +
						 				" AND PC_POL_SYS_ID = NVL(?,0)";
		System.out.println("QUERY   :  "+query);
		try {
			connection = CommonUtils.getConnection();
			System.out.println("chequeHdr.getCBH_PC_SYS_ID()"+chequeHdr.getCBH_PC_SYS_ID()+"chequeHdr.getCBH_POL_SYS_ID()"+chequeHdr.getCBH_POL_SYS_ID());
			if(chequeHdr.getCBH_PC_SYS_ID()!=null && chequeHdr.getCBH_POL_SYS_ID()!=null)
			{
			ResultSet rst = handler.executeSelectStatement(query, connection, new Object[]{chequeHdr.getCBH_PC_SYS_ID(), chequeHdr.getCBH_POL_SYS_ID()});
			collList = new ArrayList<PT_IL_PREM_COLL>();
			while(rst.next())
			{
				PT_IL_PREM_COLL premiumColl = new PT_IL_PREM_COLL();
				premiumColl.setPC_SCHD_PYMT_DT(rst.getDate("PC_SCHD_PYMT_DT"));
				premiumColl.setPC_FC_GROSS_PREM(rst.getDouble("PC_FC_GROSS_PREM"));
				premiumColl.setPC_LC_GROSS_PREM(rst.getDouble("PC_LC_GROSS_PREM"));
				premiumColl.setPC_PAID_DT(rst.getDate("PC_PAID_DT"));
				premiumColl.setPC_FC_PAID_AMT(rst.getDouble("PC_FC_PAID_AMT"));
				premiumColl.setPC_LC_PAID_AMT(rst.getDouble("PC_LC_PAID_AMT"));
				premiumColl.setPC_FC_AVLB_BAL_AMT(rst.getDouble("PC_FC_AVLB_BAL_AMT"));
				premiumColl.setPC_LC_AVLB_BAL_AMT(rst.getDouble("PC_LC_AVLB_BAL_AMT"));
				collList.add(premiumColl);
			}
			collAction.setTableList(collList);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param compositeAction
	 */
	public void whenNewBlockInstance(PILP023_COMPOSITE_ACTION compositeAction){
		String query=" PC_SYS_ID ='"+CommonUtils.nvl(compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().getCBH_PC_SYS_ID(),0)
			+"' AND PC_POL_SYS_ID = '"+CommonUtils.nvl(compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().getCBH_POL_SYS_ID(),0)+"'";
		CommonUtils.setGlobalVariable("PREMIUM_COL_WHERE", query);
	}
}
