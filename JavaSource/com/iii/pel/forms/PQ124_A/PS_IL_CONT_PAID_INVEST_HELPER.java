package com.iii.pel.forms.PQ124_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;


public class PS_IL_CONT_PAID_INVEST_HELPER {


	public void executeQuery(PQ124_A_COMPOSITE_ACTION compositeAction) throws Exception {
		new PS_IL_CONT_PAID_INVEST_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PS_IL_CONT_PAID_INVEST> dataList = compositeAction.
	getPS_IL_CONT_PAID_INVEST_ACTION_BEAN().getDataList_PS_IL_CONT_PAID_INVEST();
	 if(dataList!=null && dataList.size() > 0){
		PS_IL_CONT_PAID_INVEST PS_IL_CONT_PAID_INVEST_BEAN = dataList.get(0);
		PS_IL_CONT_PAID_INVEST_BEAN.setRowSelected(true);
				compositeAction.getPS_IL_CONT_PAID_INVEST_ACTION_BEAN()
		.setPS_IL_CONT_PAID_INVEST_BEAN(PS_IL_CONT_PAID_INVEST_BEAN);
	}
	}
	/**
	 * 
	 */
	public void whenNewBlockInstance(){
		//Execute.
	}
	
	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void postQuery(PQ124_A_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_PROD_LOAD_CHARGE_YN = null;
		Connection connection = null;
		CRUDHandler handler = null;
		
		PS_IL_CONT_PAID_INVEST PS_IL_CONT_PAID_INVEST_BEAN = compositeAction.getPS_IL_CONT_PAID_INVEST_ACTION_BEAN().getPS_IL_CONT_PAID_INVEST_BEAN();
		
		String C0 = "SELECT PROD_LOAD_CHARGE_YN FROM PM_IL_PRODUCT WHERE PROD_CODE = (SELECT POL_PROD_CODE "+
	                 "FROM PT_IL_POLICY WHERE POL_SYS_ID = ? )";
		
		String C1 = "SELECT ADD_MONTHS(WAK_DA_DUE_DATE,-1) FROM PT_LIFE_WAKALAH_DAILY_DRIP "
				+ "WHERE WAK_DA_SYS_ID = ?  AND WAK_DA_POL_SYS_ID = ? "; 
		
		String C2 = "SELECT SUM(NVL(CPI_PA_PROFIT,0)),SUM(NVL(CPI_RISK_FUND,0)) FROM PS_IL_CONT_PAID_INVEST "
				+ "WHERE CPI_POL_SYS_ID = ? AND CPI_TXN_DT = ?";
		
		String C3 = "	SELECT SUM (NVL (wak_da_pol_net_premium, 0) + DECODE(?,'Y',"
				+ "NVL (wak_da_load_amt, 0),0) - NVL (wak_da_pol_tot_comm, 0)- NVL (wak_da_risk_fund, 0)) "
				+ "FROM PT_LIFE_WAKALAH_DAILY_DRIP P,pt_il_policy "
				+ "WHERE wak_da_pol_sys_id =  ? "
				+ "AND wak_da_module = 'IL' "
				+ "AND pol_no = wak_da_pol_no "
				+ "and wak_da_sys_id = ? ";
		
		String C4 = "SELECT SUM(NVL(CPI_PA_PROFIT,0)) + SUM(NVL(CPI_TOT_PROFIT,0)) + SUM(NVL(CPI_PROFIT,0)) "
				+ "FROM   PS_IL_CONT_PAID_INVEST "
				+ "WHERE  CPI_POL_SYS_ID = ? "
				+ "AND    CPI_ACNT_YEAR  = ? ";
		String C5 = "SELECT CAY_TO_DT FROM   FM_COMP_ACNT_YEAR WHERE  " +
				"CAY_ACNT_YEAR = ? ";
		String C6A = "SELECT MAX(CPI_TXN_DT) FROM   PS_IL_CONT_PAID_INVEST WHERE  " +
				"CPI_POL_SYS_ID = ? AND " +
				"CPI_ACNT_YEAR  = ?";
		String C6 = "SELECT DISTINCT CPI_PA_BAL FROM   PS_IL_CONT_PAID_INVEST "
				+ "WHERE  CPI_POL_SYS_ID = ? AND    CPI_ACNT_YEAR  = ? "
				+ "AND    CPI_TXN_DT     = ? ";
		
		ResultSet C0_REC = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6A_REC = null;
		ResultSet C6_REC = null;
		Date M_MAX_CPI_TXN_DT = null;
		Double M_ACC_CPI_PA_BAL = 0.0;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			C2_REC = handler.executeSelectStatement(C2, connection,new Object[]{PS_IL_CONT_PAID_INVEST_BEAN.getCPI_POL_SYS_ID(),PS_IL_CONT_PAID_INVEST_BEAN.getCPI_TXN_DT()});
			if(C2_REC.next()){
				PS_IL_CONT_PAID_INVEST_BEAN.setUI_M_PA_PROFIT_COVERWISE( C2_REC.getDouble(1));
				PS_IL_CONT_PAID_INVEST_BEAN.setUI_M_RISK_FUND( C2_REC.getDouble(2));
			}
			
			C0_REC = handler.executeSelectStatement(C0, connection,new Object[]{PS_IL_CONT_PAID_INVEST_BEAN.getCPI_POL_SYS_ID()});
			if(C0_REC.next()){
				M_PROD_LOAD_CHARGE_YN = C0_REC.getString(1);
			}
			C3_REC = handler.executeSelectStatement(C3, connection,new Object[]{
					M_PROD_LOAD_CHARGE_YN,
					PS_IL_CONT_PAID_INVEST_BEAN.getCPI_POL_SYS_ID(),
					PS_IL_CONT_PAID_INVEST_BEAN.getCPI_WAK_DA_SYS_ID()});
			if(C3_REC.next()){
				PS_IL_CONT_PAID_INVEST_BEAN.setUI_M_PA_PROFIT(C3_REC.getDouble(1));
			}
			
			C4_REC = handler.executeSelectStatement(C4, connection,new Object[]{
					PS_IL_CONT_PAID_INVEST_BEAN.getCPI_POL_SYS_ID(),
					PS_IL_CONT_PAID_INVEST_BEAN.getCPI_ACNT_YEAR()});
			if(C4_REC.next()){
				PS_IL_CONT_PAID_INVEST_BEAN.setUI_M_ACC_PA_PRFT(C4_REC.getDouble(1));
			}
			
			C5_REC = handler.executeSelectStatement(C5, connection,new Object[]{
					PS_IL_CONT_PAID_INVEST_BEAN.getCPI_ACNT_YEAR()});
			if(C5_REC.next()){
				PS_IL_CONT_PAID_INVEST_BEAN.setUI_M_YR_END_DT(C5_REC.getDate(1));
			}
			
			C6A_REC = handler.executeSelectStatement(C6A, connection,new Object[]{
					PS_IL_CONT_PAID_INVEST_BEAN.getCPI_POL_SYS_ID(),
					PS_IL_CONT_PAID_INVEST_BEAN.getCPI_ACNT_YEAR()});
			if(C6A_REC.next()){
				M_MAX_CPI_TXN_DT = C6A_REC.getDate(1);
			}
			
			C6_REC = handler.executeSelectStatement(C6, connection,new Object[]{
					PS_IL_CONT_PAID_INVEST_BEAN.getCPI_POL_SYS_ID(),
					PS_IL_CONT_PAID_INVEST_BEAN.getCPI_ACNT_YEAR(),M_MAX_CPI_TXN_DT
					});
			if(C6_REC.next()){
				M_ACC_CPI_PA_BAL = C6_REC.getDouble(1);
			}
			
			PS_IL_CONT_PAID_INVEST_BEAN.setUI_M_ACC_PA_END_BAL( CommonUtils.nvl(M_ACC_CPI_PA_BAL, 0) + CommonUtils.nvl(PS_IL_CONT_PAID_INVEST_BEAN.getUI_M_ACC_PA_PRFT(), 0));
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C0_REC);
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);
			CommonUtils.closeCursor(C6_REC);
			CommonUtils.closeCursor(C6A_REC);
		}
	}

}
