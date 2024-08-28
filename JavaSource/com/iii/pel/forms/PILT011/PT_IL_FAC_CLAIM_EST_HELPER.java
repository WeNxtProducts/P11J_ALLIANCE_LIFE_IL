package com.iii.pel.forms.PILT011;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILQ003.PILQ003_COMPOSITE_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_DISC_LOAD;
import com.iii.pel.forms.PILQ003.PT_IL_POL_DISC_LOAD_DELEGATE;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_CLAIM_EST_HELPER {

	
	public void pre_form(DUMMY DUMMY_BEAN)throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		String C1 = " SELECT CLAIM_POL_NO,CLAIM_NO" +
				"	      FROM   PT_IL_CLAIM" +
				"	      WHERE  CLAIM_POL_SYS_ID = ?" +
				"	      AND    CLAIM_SYS_ID     = ?";
		Long POL_SYS_ID = null;
		Long CLM_SYS_ID = null;
		try{
			if(!"".equals(CommonUtils.getGlobalObject("GLOBAL.POL_SYS_ID").toString())){
			POL_SYS_ID = Long.valueOf(CommonUtils.getGlobalObject("GLOBAL.POL_SYS_ID").toString());
			}
			if(!"".equals(CommonUtils.getGlobalObject("GLOBAL.CLM_SYS_ID").toString())){
			CLM_SYS_ID = Long.valueOf(CommonUtils.getGlobalObject("GLOBAL.CLM_SYS_ID").toString());
			}
			connection = CommonUtils.getConnection();
			DUMMY_BEAN.setPT_IL_FAC_CLAIM_EST_CF("P");
			DUMMY_BEAN.setPT_IL_FAC_CLAIM_PAID_CF("P");
			DUMMY_BEAN.setPT_IL_FAC_CLAIM_PART_CUST_ES("N");
			DUMMY_BEAN.setPT_IL_FAC_CLAIM_PART_CUST_PA("N");
			if(POL_SYS_ID != null && CLM_SYS_ID != null){
			DUMMY_BEAN.setUI_M_POL_SYS_ID(POL_SYS_ID);
			DUMMY_BEAN.setUI_M_CLM_SYS_ID(CLM_SYS_ID);
			}
			if(CommonUtils.getGlobalObject("GLOBAL.COVER_CODE") != null){
			DUMMY_BEAN.setUI_M_COVER_CODE(CommonUtils.getGlobalObject("GLOBAL.COVER_CODE").toString());
			}
			values = new Object[]{DUMMY_BEAN.getUI_M_POL_SYS_ID(),DUMMY_BEAN.getUI_M_CLM_SYS_ID()};
			resultSet = handler.executeSelectStatement(C1, connection,values);
			if(resultSet.next()){
				DUMMY_BEAN.setUI_M_POL_NO_1(resultSet.getString(1));
				DUMMY_BEAN.setUI_M_CLM_NO_1(resultSet.getString(2));
				DUMMY_BEAN.setUI_M_POL_NO_2(DUMMY_BEAN.getUI_M_POL_NO_1());
				DUMMY_BEAN.setUI_M_CLM_NO_2(DUMMY_BEAN.getUI_M_CLM_NO_1());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}
	
	public void WHEN_NEW_FORM_INSTANCE(PILT011_COMPOSITE_ACTION compositeAction) {
		PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN = compositeAction.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN()
		.getPT_IL_FAC_CLAIM_EST_BEAN();
		DUMMY_ACTION DUMMY_ACTION_BEAN = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY DUMMY_BEAN = DUMMY_ACTION_BEAN.getDUMMY_BEAN();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Object[] values = null;
		String M_WHERE = null;
		PT_IL_FAC_CLAIM_EST_DELEGATE pt_il_fac_claim_est_delegate = new PT_IL_FAC_CLAIM_EST_DELEGATE();
		CRUDHandler handler = new CRUDHandler();
		String query = "SELECT 'X',FCE_SYS_ID FROM PT_IL_FAC_CLAIM_EST WHERE FCE_CLAIM_SYS_ID = ?";
		String query1 = "SELECT 'X' FROM PT_IL_TTY_CLAIM_EST WHERE TCE_CLAIM_SYS_ID = ?";
		try {
			connection = CommonUtils.getConnection(); 
			values = new Object[]{DUMMY_BEAN.getUI_M_CLM_SYS_ID()};
			resultSet = handler.executeSelectStatement(query, connection,values);
			if(resultSet.next()) {
				PT_IL_FAC_CLAIM_EST_BEAN.setUI_M_FAC_REC(resultSet.getString(1));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_SYS_ID(resultSet.getLong(2));
			}
		
		String callingForm = (String) CommonUtils.getGlobalVariable("CALLING_FORM");
		if ((callingForm == null ? "" : callingForm).equals("PILT006_APAC")) {
			String facRI = (String) CommonUtils.getGlobalVariable("GLOBAL.FAC_RI_BUT");
			if ((facRI == null ? "" : facRI).equals("F")) {
				//				SET_TAB_PAGE_PROPERTY("TREATY",VISIBLE,PROPERTY_FALSE);
				
				
				/*Modified by Janani on 22.06.2017 for ZBILQC-1721216*/
				
				/*if (!PT_IL_FAC_CLAIM_EST_BEAN.getM_COVER_CODE().equals("")
						|| PT_IL_FAC_CLAIM_EST_BEAN.getM_COVER_CODE() != null) */
				
				
				System.out.println("PT_IL_FAC_CLAIM_EST_BEAN                    "+PT_IL_FAC_CLAIM_EST_BEAN);
				System.out.println("getM_COVER_CODE                    "+PT_IL_FAC_CLAIM_EST_BEAN.getM_COVER_CODE());
				
				if (PT_IL_FAC_CLAIM_EST_BEAN.getM_COVER_CODE() != null && !PT_IL_FAC_CLAIM_EST_BEAN.getM_COVER_CODE().equals("")) 
				
				/*End*/
				
				{
					M_WHERE = "FCE_CLAIM_SYS_ID = "
							+ PT_IL_FAC_CLAIM_EST_BEAN.getM_CLM_SYS_ID()
							+ " AND FCE_CCD_COVER_CODE = '"
							+ PT_IL_FAC_CLAIM_EST_BEAN.getM_COVER_CODE() + "'";
				} else {
					M_WHERE = "FCE_CLAIM_SYS_ID = "
							+ PT_IL_FAC_CLAIM_EST_BEAN.getM_CLM_SYS_ID();
				}
				CommonUtils.setGlobalVariable("PT_IL_FAC_CLAIM_EST.DEFAULT_WHERE", M_WHERE);
				//				GO_BLOCK('PT_IL_FAC_CLAIM_EST');
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_ESTIMATE().setDisabled(false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
				CommonUtils.setGlobalVariable("M_BUT_SETTLEMENT.ENABLED", "FALSE");
				//				EXECUTE_QUERY;
			} else if ((facRI == null ? "" : facRI).equals("R")) {
				//				SET_TAB_PAGE_PROPERTY('FAC',VISIBLE,PROPERTY_FALSE);
				//				GO_BLOCK('PT_IL_FAC_CLAIM_EST');
			}
		} else if ((callingForm == null ? "" : callingForm).equals("PILT007")) {
			DUMMY_ACTION_BEAN.getDUMMY_BEAN().setUI_M_CP_SYS_ID(CommonUtils.getGlobalObject(
			"GLOBAL.M_CP_SYS_ID").toString());
			PT_IL_FAC_CLAIM_EST_BEAN.setM_CP_SYS_ID(CommonUtils.getGlobalObject(
					"GLOBAL.M_CP_SYS_ID").toString());
			M_WHERE = "FCP_CP_SYS_ID = "
					+ PT_IL_FAC_CLAIM_EST_BEAN.getM_CP_SYS_ID();
		
			 	DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
			    DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_ESTIMATE().setDisabled(true);
			   DUMMY_ACTION_BEAN.getUI_M_BUT_FAC_ESTIMATE().setDisabled(true);
			 //  pt_il_fac_claim_est_delegate.executeSelectStatement(compositeAction,M_WHERE);
		} else if ((callingForm == null ? "" : callingForm).equals("PILT012")) {
			M_WHERE = "FCE_CLAIM_SYS_ID = "
					+ PT_IL_FAC_CLAIM_EST_BEAN.getM_CLM_SYS_ID()
					+ "  AND FCE_CCD_COVER_CODE = '"
					+ CommonUtils.getGlobalVariable("GLOBAL.CLM_COVER_CODE") + "'";
			   DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_ESTIMATE().setDisabled(false);
			   DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
			 } else {
			//			SET_TAB_PAGE_PROPERTY('FAC',VISIBLE,PROPERTY_FALSE);
		}
			values = new Object[]{DUMMY_BEAN.getUI_M_CLM_SYS_ID()};
			resultSet1 = handler.executeSelectStatement(query1, connection,values);
			if (resultSet1 != null) {
				while (resultSet1.next())
					PT_IL_FAC_CLAIM_EST_BEAN.setUI_M_RI_REC(resultSet1.getString(1));
			} else {
				//				SET_TAB_PAGE_PROPERTY('TREATY',VISIBLE,PROPERTY_FALSE);
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}try {
					resultSet1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	public void when_new_record_instance(PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN,DUMMY_ACTION DUMMY_ACTION_BEAN)throws Exception{
		String C1 = " SELECT 'X'" +
				"      FROM  PT_IL_FAC_CLAIM_PAID" +
				"      WHERE FCP_FCE_SYS_ID = ?";
		String C2 = " SELECT FCE_CCD_COVER_CODE " +
				"   FROM   PT_IL_FAC_CLAIM_EST" +
				"   WHERE  FCE_CLAIM_SYS_ID IN" +
				"   (SELECT CLAIM_SYS_ID" +
				"    FROM   PT_IL_CLAIM  WHERE  CLAIM_NO = ?)";
		String M_DUMMY = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		Object[] values = null;
		try{
			connection = CommonUtils.getConnection();
			values = new Object[]{PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID()};
			resultSet = handler.executeSelectStatement(C1, connection,values);
			if(resultSet.next()){
				M_DUMMY = resultSet.getString(1);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_FAC_SETTLEMENT().setDisabled(false);
			}else{
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_FAC_SETTLEMENT().setDisabled(true);
			}
			values = new Object[]{DUMMY_ACTION_BEAN.getDUMMY_BEAN().getUI_M_CLM_NO_1()};
			resultSet2 = handler.executeSelectStatement(C2, connection,values);
			if(resultSet2.next()){
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CCD_COVER_CODE(resultSet2.getString(1));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
			}
		}
	}
	
	public void PT_IL_FAC_CLAIM_EST_PRE_INSERT(PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN) {
		try {
			PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CR_DT(new CommonUtils().getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void PT_IL_FAC_CLAIM_EST_POST_QUERY(PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN) {
		P_VAL_COVER(PT_IL_FAC_CLAIM_EST_BEAN);
		P_VAL_CURR(PT_IL_FAC_CLAIM_EST_BEAN);
	}
	


	public void P_VAL_COVER(PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN) {
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		paramList.clear();
		try {
		Connection connection = CommonUtils.getConnection();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				PT_IL_FAC_CLAIM_EST_BEAN.getFCE_CCD_COVER_CODE());
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN OUT",
				"");
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				null);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN", "N");
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				CommonUtils.getControlBean().getM_LANG_CODE());
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();

		List outParamList;
		
			outParamList = procHandler.execute(paramList, connection,
					"P_VAL_COVER");
			OracleParameter planDescPar = (OracleParameter) outParamList.get(0);
			PT_IL_FAC_CLAIM_EST_BEAN.setUI_M_COVER_DESC_1(planDescPar
					.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void P_VAL_CURR(PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN) {
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		paramList.clear();
		try {
			Connection connection = CommonUtils.getConnection();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				PT_IL_FAC_CLAIM_EST_BEAN.getFCE_CLAIM_CURR_CODE());
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN OUT",
				"");
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN", "N");
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				CommonUtils.getControlBean().getM_LANG_CODE());
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		List outParamList;
			outParamList = procHandler.execute(paramList, connection,
					"P_VAL_CURR");
			OracleParameter planDescPar = (OracleParameter) outParamList.get(0);
			PT_IL_FAC_CLAIM_EST_BEAN
					.setUI_M_CURR_DESC_1(planDescPar.getValue());
			//PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CLAIM_CURR_CODE(planDescPar
					//.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void PT_IL_FAC_CLAIM_EST_PRE_DELETE(PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN) {
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			String query = "DELETE FROM PT_IL_FAC_CLAIM_PART_CUST_EST WHERE FCPCE_FCE_SYS_ID = '"
					+ PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID() + "'";
			
			handler.executeDelete(query, connection);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void executeQuery(PILT011_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_FAC_CLAIM_EST_DELEGATE().executeSelectStatement(compositeAction);
		DUMMY DUMMY_BEAN= compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN= compositeAction.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN().getPT_IL_FAC_CLAIM_EST_BEAN();
		PT_IL_FAC_CLAIM_EST_BEAN.setUI_M_POL_NO_1(DUMMY_BEAN.getUI_M_POL_NO_1());
		PT_IL_FAC_CLAIM_EST_BEAN.setUI_M_CLM_NO_1(DUMMY_BEAN.getUI_M_CLM_NO_1());
		//postQuery(DUMMY_BEAN);

		List<PT_IL_FAC_CLAIM_PART_CUST_EST> dataList = compositeAction
				.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN()
				.getClaimPartCustList();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_FAC_CLAIM_PART_CUST_EST PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN = dataList.get(0);
			//PT_IL_POL_DISC_LOAD_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_EST_ACTION_BEAN().
			setPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN(PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN);
		}
	}
	
	public void fetch(PILT011_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_FAC_CLAIM_PART_CUST_EST PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN = compositeAction.
		getPT_IL_FAC_CLAIM_PART_CUST_EST_ACTION_BEAN().getPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN();
		PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN = compositeAction.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN().getPT_IL_FAC_CLAIM_EST_BEAN();
		String C1 = "SELECT * FROM PT_IL_FAC_CLAIM_PART_CUST_EST WHERE FCPCE_FCE_SYS_ID = ?";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID()});
			while(resultSet.next()){
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN =new PT_IL_FAC_CLAIM_PART_CUST_EST();
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_CUST_CODE(resultSet.getString("FCPCE_CUST_CODE"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_FAC_PERC(resultSet.getDouble("FCPCE_FAC_PERC"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_FC_CLM_EST(resultSet.getDouble("FCPCE_FC_CLM_EST"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_LC_CLM_EST(resultSet.getDouble("FCPCE_LC_CLM_EST"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_RETRO_FC_CLM_EST(resultSet.getDouble("FCPCE_RETRO_FC_CLM_EST"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_RETRO_LC_CLM_EST(resultSet.getDouble("FCPCE_RETRO_LC_CLM_EST"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_RETRO_PERC(resultSet.getDouble("FCPCE_RETRO_PERC"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_FCE_SYS_ID(resultSet.getDouble("FCPCE_FCE_SYS_ID"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_SYS_ID(resultSet.getDouble("FCPCE_SYS_ID"));
			compositeAction.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN()
			.getClaimPartCustList().add(
					PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	
}
