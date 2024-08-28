package com.iii.pel.forms.PQ124_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_WAKALAH_DAILY_DRIP_HELPER {

	public void executeQuery(PQ124_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_WAKALAH_DAILY_DRIP_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_WAKALAH_DAILY_DRIP> dataList = compositeAction
				.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN()
				.getDataList_PT_WAKALAH_DAILY_DRIP();
		if (dataList != null && dataList.size() > 0) {
			PT_WAKALAH_DAILY_DRIP PT_WAKALAH_DAILY_DRIP_BEAN = dataList.get(0);
			//PT_WAKALAH_DAILY_DRIP_BEAN.setRowSelected(true);
			compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN()
					.setPT_WAKALAH_DAILY_DRIP_BEAN(PT_WAKALAH_DAILY_DRIP_BEAN);
		}
	}
	/**
	 * 
	 * @param CTRL_BEAN
	 */
	public void preBlock(CTRL CTRL_BEAN){
		CTRL_BEAN.setUI_M_DELETE_MSG_FLAG("Y");
	}
	/**
	 * 
	 */
	public void whenCreateRecord(){
		//null;
	}
	
	/**
	 * 
	 * @param compositeAction
	 */
	public void postQuery(PQ124_A_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_PLAN_TYPE =null;
    	String M_PROD_LOAD_CHARGE_YN =null;
		String M_POL_END_TYPE =null;
		Double M_POL_END_NO_IDX =0.0;
		Double M_PCC_FC_CHARGE_AMT = 0.0;
		
		PT_WAKALAH_DAILY_DRIP PT_WAKALAH_DAILY_DRIP_BEAN = compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getPT_WAKALAH_DAILY_DRIP_BEAN();
		PT_WAKALAH_DAILY_DRIP_1 PT_WAKALAH_DAILY_DRIP_1_BEAN = compositeAction.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN().getPT_WAKALAH_DAILY_DRIP_1_BEAN();
		
		String C1 = "SELECT NVL(COVER_DESC, NULL) FROM   PM_IL_COVER WHERE COVER_CODE = ? ";
		String C2 = "SELECT NVL(COVER_DESC, NULL) FROM   PM_IL_COVER WHERE  COVER_CODE = ? ";
		
		String C3 = "SELECT  SUM(NVL(WAK_DA_PRIA_BAL_AFTER_SUR,0) + NVL(WAK_DA_POL_NET_PREMIUM,0) -  NVL(WAK_DA_POL_TOT_COMM,0) - NVL(WAK_DA_SPECIAL_FUND,0) - NVL(WAK_DA_RISK_FUND,0) + NVL(WAK_DA_PROFIT_INVEST,0)) "
				+ "FROM PT_LIFE_WAKALAH_DAILY_DRIP "
				+ "WHERE WAK_DA_POL_ANALYSIS_2 = ? AND WAK_DA_POL_NO = ? ";
		
		String C4 = "SELECT PLAN_TYPE,POL_END_TYPE,POL_END_NO_IDX FROM   PT_IL_POLICY , PM_IL_PLAN WHERE  POL_NO = ? "+
			"AND POL_PLAN_CODE = PLAN_CODE";
		String C5 = "SELECT PROD_LOAD_CHARGE_YN FROM PM_IL_PRODUCT,PT_IL_POLICY WHERE POL_PROD_CODE = PROD_CODE AND POL_NO = ?";
		
		String C6 = "SELECT SUM(NVL(PCCD_FC_RISK_DISC_AMT,0) + NVL(PCCD_FC_INV_DISC_AMT,0)) "+
        "FROM PT_IL_PREM_COLL_CVR_DTL "+
       "WHERE  PCCD_PC_SYS_ID = ? "+
        " AND  PCCD_COVER_CODE= ? ";
		
		String C7 = "SELECT SUM(PCC_FC_CHARGE_AMT) FROM PT_IL_PREM_COLL_CHARGE WHERE PCC_PC_SYS_ID = ? AND PCC_TYPE = 'T'";
		
		String C8 = "SELECT PC_APPRV_DT,PC_SCHD_PYMT_DT FROM   PT_IL_PREM_COLL WHERE  PC_SYS_ID =?";
		
		String C9 = "SELECT MIN(PC_SCHD_PYMT_DT) FROM   PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? "
				+ "AND    PC_SCHD_PYMT_DT > (SELECT PC_SCHD_PYMT_DT "
				+ "FROM   PT_IL_PREM_COLL " + "WHERE  PC_SYS_ID = ?)";
		Connection connection = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
		ResultSet C7_REC = null;
		ResultSet C8_REC = null;
		ResultSet C9_REC = null;
		
		Double M_PCCD_FC_INV_DISC_AMT = 0.0;
		try {
			connection = CommonUtils.getConnection();
			C7_REC = new CRUDHandler().executeSelectStatement(C7, connection,new Object[]{PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_PC_SYS_ID()});
			if(C7_REC.next()){
				M_PCC_FC_CHARGE_AMT = C7_REC.getDouble(1);
			}
			
			C4_REC = new CRUDHandler().executeSelectStatement(C4, connection,new Object[]{PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NO()});
			if(C4_REC.next()){
				M_PLAN_TYPE = C4_REC.getString("PLAN_TYPE");
				M_POL_END_TYPE = C4_REC.getString("POL_END_TYPE");
				M_POL_END_NO_IDX = C4_REC.getDouble("POL_END_NO_IDX");
			}
			
			if("009".equalsIgnoreCase(M_POL_END_TYPE) && M_POL_END_NO_IDX==PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_END_NO_IDX()){
				M_PCC_FC_CHARGE_AMT = M_PCC_FC_CHARGE_AMT * -1;				
			}
			
			if("GI".equals(CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_1_BEAN.getUI_M_WAK_DA_MODULE(), "X"))){
				C1_REC = new CRUDHandler().executeSelectStatement(C1, connection,new Object[]{PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_COVER_CODE()});
				if(C1_REC.next()){
					PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_WAK_DA_POL_COVER_CODE_DESC(C1_REC.getString(1));
				}
			}else{
				C2_REC = new CRUDHandler().executeSelectStatement(C2, connection,new Object[]{PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_COVER_CODE()});
				if(C2_REC.next()){
					PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_WAK_DA_POL_COVER_CODE_DESC(C2_REC.getString(1));
				}
			}	
		
			if("PRIA".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_ANALYSIS_2())){
				if(CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NET_PREMIUM(), 0) -
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_TOT_COMM(), 0) -
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_SPECIAL_FUND(), 0) - 
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_RISK_FUND(), 0) > 0){
					C3_REC = new CRUDHandler().executeSelectStatement(C3, connection,new Object[]{"PRIA",PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NO()});
					if(C3_REC.next()){
						PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_GROSS_PRIA(C3_REC.getDouble(1));
					}
				}
				
			}else{
				if(CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NET_PREMIUM(), 0) -
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_TOT_COMM(), 0) -
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_SPECIAL_FUND(), 0) - 
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_RISK_FUND(), 0) > 0){
					C3_REC = new CRUDHandler().executeSelectStatement(C3, connection,new Object[]{"PIAF",PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NO()});
					if(C3_REC.next()){
						PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_GROSS_PIAF(C3_REC.getDouble(1));
					}
				}
			}
			
			compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(false);
			//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_FALSE);
			
			C5_REC = new CRUDHandler().executeSelectStatement(C5, connection,new Object[]{PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NO()});
			if(C5_REC.next()){
				M_PROD_LOAD_CHARGE_YN = C5_REC.getString(1);
			}
			
			C6_REC = new CRUDHandler().executeSelectStatement(C6, connection,new Object[]{PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_PC_SYS_ID(),PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_COVER_CODE()});
			if(C6_REC.next()){
				M_PCCD_FC_INV_DISC_AMT = C6_REC.getDouble(1);
			}
			
			if("N".equalsIgnoreCase(M_PROD_LOAD_CHARGE_YN)){
				PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_ROW_TOTAL( CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NET_PREMIUM(), 0) + CommonUtils.nvl(M_PCC_FC_CHARGE_AMT, 0));
			}else{
				PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_ROW_TOTAL( CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NET_PREMIUM(), 0) + CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_LOAD_AMT(), 0) + CommonUtils.nvl(M_PCC_FC_CHARGE_AMT, 0));
			}
			
			if("N".equalsIgnoreCase(M_PROD_LOAD_CHARGE_YN)){
				PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_AVAL_BAL( 
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NET_PREMIUM(), 0) -
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_TOT_COMM(), 0)	-
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_RISK_FUND(), 0));
			}else{
				PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_AVAL_BAL( 
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NET_PREMIUM(), 0) -
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_TOT_COMM(), 0)	-
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_RISK_FUND(), 0) +
						CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_LOAD_AMT(), 0));
			}
			
			if("Y".equalsIgnoreCase(M_PROD_LOAD_CHARGE_YN) && PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_COUNT()==1){
				if("Lapse Drip".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUI_M_DRIP_STATUS())){
					if("U".equalsIgnoreCase(M_PLAN_TYPE)){
						compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(false);
						//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_TRUE);
					}
				}
			}else if("Y".equalsIgnoreCase(M_PROD_LOAD_CHARGE_YN) && PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_COUNT() > 1){
				if("Lapse Subsequent Drip".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUI_M_DRIP_STATUS())){
					if("U".equalsIgnoreCase(M_PLAN_TYPE)){
						compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(false);
						//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_TRUE);
					}
				}
			}
			
			if("N".equalsIgnoreCase(M_PROD_LOAD_CHARGE_YN) && PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_COUNT()==1){
				if("Dripping".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUI_M_DRIP_STATUS())){
					if("U".equalsIgnoreCase(M_PLAN_TYPE)){
						compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(false);
						//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_TRUE);
					}
				}
			}else if("N".equalsIgnoreCase(M_PROD_LOAD_CHARGE_YN) && PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_COUNT() > 1){
				if("Subsequent Dripping".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUI_M_DRIP_STATUS())){
					if("U".equalsIgnoreCase(M_PLAN_TYPE)){
						compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(false);
						//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_TRUE);
					}
				}
			}
			
			PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_WAK_DA_POL_NET_PREMIUM( 
					CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NET_PREMIUM(), 0) +
					CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_SH_COLL_AMT(), 0)	+
					CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_LOAD_AMT(), 0) );
			
			if("N".equalsIgnoreCase(M_PROD_LOAD_CHARGE_YN)){
				PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_WAK_DA_POL_NET_PREMIUM(  
						 CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NET_PREMIUM(), 0) +
						 CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_SH_COLL_AMT(), 0) +
						 CommonUtils.nvl(M_PCC_FC_CHARGE_AMT, 0));
			}else{
				
				PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_WAK_DA_POL_NET_PREMIUM(  
						 CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NET_PREMIUM(), 0) +
						 CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_SH_COLL_AMT(), 0) + 
						 CommonUtils.nvl(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_LOAD_AMT(), 0) +
						 CommonUtils.nvl(M_PCC_FC_CHARGE_AMT, 0) );
			}
			
			if(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_DUE_DATE()!=null){
				PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_CUR_RISK_DT( CommonUtils.addMonthsToDate(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_DUE_DATE(), -1) );
			}
			
			if("N".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_LAP_YN()) && 
					"IM50754".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUSER_ID())){
				PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_DRIP_STATUS("Adjustment");
				if("U".equalsIgnoreCase(M_PLAN_TYPE)){
					compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(true);
					//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_TRUE);
				}
			}
			
			//PT_WAKALAH_DAILY_DRIP_BEAN.setUI_M_SUM_ROW_TOTAL(34.0);
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);
			CommonUtils.closeCursor(C6_REC);
			CommonUtils.closeCursor(C7_REC);
			CommonUtils.closeCursor(C8_REC);
			CommonUtils.closeCursor(C9_REC);
		}
	}
	
	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void whenNewRecordInstance(PQ124_A_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_WAKALAH_DAILY_DRIP PT_WAKALAH_DAILY_DRIP_BEAN = compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getPT_WAKALAH_DAILY_DRIP_BEAN(); 
		String M_PLAN_TYPE = null;
		String C1 = "SELECT PLAN_TYPE FROM   PT_IL_POLICY , PM_IL_PLAN "
				+ "WHERE  POL_NO = ? AND    POL_PLAN_CODE = PLAN_CODE";
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_POL_NO()});
			if(C1_REC.next()){
				M_PLAN_TYPE = C1_REC.getString(1);
			}
			/*:BP.B_WAK_DA_PRIA_BAL_AFTER_TAP     := :PT_WAKALAH_DAILY_DRIP.WAK_DA_POL_ANALYSIS_2 || ' Bal After TAP';
			:BP.B_WAK_DA_PRIA_BAL_AFTER_SUR     := :PT_WAKALAH_DAILY_DRIP.WAK_DA_POL_ANALYSIS_2 || ' Bal After Surplus';
			:BP.B_WAK_DA_PRIA_SUR_CLF           := :PT_WAKALAH_DAILY_DRIP.WAK_DA_POL_ANALYSIS_2 || ' TAP Spl Fund C/F.';*/
			
			compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(true);
			//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_FALSE);
			if("Y".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_LAP_YN()) && PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_COUNT()==1){
				if("Lapse Drip".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUI_M_DRIP_STATUS())){
					if("U".equalsIgnoreCase(M_PLAN_TYPE)){
						compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(false);
						//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_FALSE);
					}
				}
			}else if("Y".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_LAP_YN()) && PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_COUNT()>1){
				if("Lapse Subsequent Drip".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUI_M_DRIP_STATUS())){
					if("U".equalsIgnoreCase(M_PLAN_TYPE)){
						compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(false);
						//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_FALSE);
					}
				}
			}
			
			if("N".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_LAP_YN()) && PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_COUNT()==1){
				if("Dripping".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUI_M_DRIP_STATUS())){
					if("U".equalsIgnoreCase(M_PLAN_TYPE)){
						compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(false);
						//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_FALSE);
					}
				}
			}else if("N".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_LAP_YN()) && PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_COUNT()>1){
				if("Subsequent Dripping".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUI_M_DRIP_STATUS())){
					if("U".equalsIgnoreCase(M_PLAN_TYPE)){
						compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(false);
						//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_FALSE);
					}
				}
			}
			
			if("N".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_LAP_YN()) 
					&& "IM50754".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUSER_ID())){
				if("Adjustment".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_BEAN.getUI_M_DRIP_STATUS())){
					if("U".equalsIgnoreCase(M_PLAN_TYPE)){
						compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getCOMP_WAK_DA_DRIP_DT().setRendered(false);
						//SET_ITEM_PROPERTY('BP.B_WAK_DA_DRIP_DT',VISIBLE, PROPERTY_FALSE);
					}
				}
			}
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}
	}

}
