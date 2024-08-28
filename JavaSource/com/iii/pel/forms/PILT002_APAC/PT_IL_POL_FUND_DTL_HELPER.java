package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_FUND_DTL_HELPER {

	
public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
   try{
		new PT_IL_POL_FUND_DTL_DELEGATE().executeSelectStatement(compositeAction);
		List<PT_IL_POL_FUND_DTL> dataList = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
																	.getDataList_PT_IL_POL_FUND_DTL();

		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_FUND_DTL PT_IL_POL_FUND_DTL_BEAN = dataList.get(0);
			PT_IL_POL_FUND_DTL_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
			.setPT_IL_POL_FUND_DTL_BEAN(PT_IL_POL_FUND_DTL_BEAN);
		}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POST_QUERY(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		PT_IL_POL_FUND_DTL fundBean = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		ResultSet rs = null;
		Object[] values = {};
		Connection connection = null;
		
		String query1 = " SELECT FS_DESC FROM PM_IL_FUND_SETUP WHERE  FS_CODE =? ";
		
		try {

			connection = CommonUtils.getConnection();
			values = new Object[] { fundBean.getPOFD_FUND_CODE() };
			rs = new CRUDHandler().executeSelectStatement(query1, connection,values);
			if (rs.next()) {
				fundBean.setUI_M_FUND_DESC(rs.getString(1));
			}
			//TODO PENDING
			/*
	      P_GET_DEL_RECORD_PROPERTY('PT_IL_POL_FUND_DTL',
	      'PT_IL_POL_FUND_DTL.POFD_DEL_FLAG',
	      :PT_IL_POLICY.POL_END_NO_IDX);
			 */

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(rs);} catch (Exception e) {e.printStackTrace();}
		}
	}

	public void PRE_INSERT(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL fundBean = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		ResultSet rs = null;
		Connection connection = null;
		CommonUtils commonUtils = new CommonUtils();
		
		String query1 = "  SELECT PIL_POFD_SYS_ID.NEXTVAL FROM DUAL";
		
		try {
			connection = CommonUtils.getConnection();

			fundBean.setPOFD_POL_SYS_ID(pt_il_policy_bean.getPOL_SYS_ID());
			fundBean.setPOFD_CR_DT(commonUtils.getCurrentDate());
			fundBean.setPOFD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			fundBean.setPOFD_FUND_DIR_TYPE("P");
			
			rs = new CRUDHandler().executeSelectStatement(query1, connection);
			if (rs.next()) {
				fundBean.setPOFD_SYS_ID(rs.getLong(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(rs);} 
			catch (Exception e) {
				e.printStackTrace();
				}
		}
	}

	public void PRE_UPDATE(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		PT_IL_POL_FUND_DTL fundBean = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN();
		CommonUtils commonUtils = new CommonUtils();
		try {
			fundBean.setPOFD_UPD_DT(commonUtils.getCurrentDate());
			fundBean.setPOFD_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	

	public void PRE_QUERY(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL fundBean = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			fundBean.setPOFD_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			fundBean.setPOFD_FUND_DIR_TYPE("P");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	//PENDING
	public void WHEN_NEW_BLOCK_INSTANCE(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			executeQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL_ACTION fundAction = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN();
		PT_IL_POL_FUND_DTL fundBean = fundAction.getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		ResultSet rs = null;
		Object[] values = {};
		Connection connection = null;
		String M_PROD_FUND_ALLOWED = null;

		String query2 = " SELECT PROD_FUND_ALLOWED  FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { policyBean.getPOL_PROD_CODE() };
			rs = new CRUDHandler().executeSelectStatement(query2, connection,values);

			if (rs.next()) {
				M_PROD_FUND_ALLOWED = rs.getString(1);
			}
			
			if (fundBean.getPOFD_FUND_CODE() != null) {
				if ("M".equals(M_PROD_FUND_ALLOWED)) { 
					fundAction.getCOMP_POFD_FUND_PERC().setDisabled(false);
					fundAction.getCOMP_POFD_EFF_FM_DT().setDisabled(false);
					fundAction.getCOMP_POFD_EFF_TO_DT().setDisabled(false);
					fundAction.getCOMP_POFD_FUND_PERC().setRequired(true);
					fundAction.getCOMP_POFD_EFF_FM_DT().setRequired(true);
					fundAction.getCOMP_POFD_EFF_TO_DT().setRequired(true);
				} else if ("S".equals(M_PROD_FUND_ALLOWED)) {
					fundBean.setPOFD_FUND_PERC(100d);
					fundAction.getCOMP_POFD_FUND_PERC().setDisabled(true);
					fundAction.getCOMP_POFD_EFF_FM_DT().setDisabled(true);
					fundAction.getCOMP_POFD_EFF_TO_DT().setDisabled(true);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_CREATE_RECORD(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL pt_il_pol_fund_dtl_bean = compositeAction
		.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
		.getPT_IL_POL_FUND_DTL_BEAN();

		try {
			pt_il_pol_fund_dtl_bean.setPOFD_FUND_DIR_TYPE("P");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	// PENDING
	public void KEY_DELREC(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL pt_il_pol_fund_dtl_bean = compositeAction
			.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN();

		try {

			/*
			 * IF :PT_IL_POLICY.POL_END_TYPE = '001' AND
			 * NVL(:PT_IL_POLICY.POL_APPRV_STATUS,'N') <> 'A' THEN
			 * 
			 * P_SET_DEL_RECORD_PROPERTY('PT_IL_POL_FUND_DTL.POFD_DEL_FLAG',
			 * 'PT_IL_POL_FUND_DTL', :PT_IL_POLICY.POL_END_NO_IDX, 'D'); ELSE
			 * 
			 * IF (:PT_IL_POLICY.POL_END_TYPE IN ('000') OR
			 * :PT_IL_POLICY.POL_DS_TYPE = '1') AND
			 * NVL(:PT_IL_POLICY.POL_APPRV_STATUS,'N') <> 'A' THEN KEY_DELREC;
			 * END IF;
			 * 
			 * END IF;
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public PT_IL_POL_FUND_DTL POFD_FUND_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue) throws Exception {
		
		PT_IL_POL_FUND_DTL_ACTION fundAction = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN();
		PT_IL_POL_FUND_DTL fundBean = fundAction.getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		ResultSet rs = null;
		ResultSet rs1 = null;
		Object[] values = {};
		Object[] values1 = {};
		Connection connection = null;
		Connection connection1 = null;
		String M_PROD_FUND_ALLOWED = null;
		fundBean.setPOFD_FUND_CODE(currValue);
		
		String query1 = " SELECT FS_DESC FROM PM_IL_FUND_SETUP WHERE FS_CODE = ?";
		String query2 = " SELECT PROD_FUND_ALLOWED FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		String query3 = " SELECT MIN(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG, 'N') = 'N' AND PC_PAID_DT IS NULL";
		Date efftFromDate = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };
			rs = new CRUDHandler().executeSelectStatement(query2, connection,values);
			connection1 = CommonUtils.getConnection();
			values1 = new Object[] { compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() };
			rs1 = new CRUDHandler().executeSelectStatement(query3, connection1,values1);
			if (rs.next()) {
				M_PROD_FUND_ALLOWED = rs.getString(1);
			}
			
			if(rs1.next()){
				efftFromDate = rs1.getDate(1);
			}

			if (fundBean.getPOFD_FUND_CODE() != null) {
				if ("M".equals(M_PROD_FUND_ALLOWED)) {
					fundAction.getCOMP_POFD_FUND_PERC().setRequired(true);
					fundAction.getCOMP_POFD_EFF_FM_DT().setRequired(true);
					if(efftFromDate != null){
					fundBean.setPOFD_EFF_FM_DT(efftFromDate);
					fundAction.getCOMP_POFD_EFF_FM_DT().setDisabled(false);
					fundAction.getCOMP_POFD_EFF_FM_DT().resetValue();
					}
					fundAction.getCOMP_POFD_EFF_TO_DT().setRequired(true);
					fundBean.setPOFD_EFF_TO_DT(pt_il_policy_bean.getPOL_EXPIRY_DT());
					
					
					fundBean.setPOFD_FUND_PERC(null);
					
				} else if ("S".equals(M_PROD_FUND_ALLOWED)) {
					fundBean.setPOFD_FUND_PERC(100d);
					fundAction.getCOMP_POFD_FUND_PERC().setDisabled(true);
					fundBean.setPOFD_EFF_FM_DT(pt_il_policy_bean.getPOL_START_DT());
					fundAction.getCOMP_POFD_EFF_FM_DT().setDisabled(true);
					fundBean.setPOFD_EFF_TO_DT(pt_il_policy_bean.getPOL_EXPIRY_DT());
					fundAction.getCOMP_POFD_EFF_TO_DT().setDisabled(true);
				}
				values = new Object[] { fundBean.getPOFD_FUND_CODE() };
				rs = new CRUDHandler().executeSelectStatement(query1,connection, values);
				if (rs.next()) {
					fundBean.setUI_M_FUND_DESC(rs.getString(1));
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91423"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return fundBean;
	}

	public void POFD_FUND_PERC_WHEN_VALIDATE_ITEM(Double currValue,PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			
			/*Commentted &Modified by saritha on 10-05-2018 for KIC Allocation %:Percentage Should Be Greater Than Zero And Lesser Than Hundred !*/
			
			/*if (currValue <= 0 || currValue > 100) {*/
			
			if (currValue < 0 || currValue > 100) {
				
			/*End*/
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71070"));
			}
			/*Added by Ameen on 15-03-2018 to have overall total 100 as per Siva sugg.*/
			double fundTotal = 0.0;
			for(int i = 0;i<compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getDataList_PT_IL_POL_FUND_DTL().size();i++){
				PT_IL_POL_FUND_DTL PT_IL_POL_FUND_DTL_val = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getDataList_PT_IL_POL_FUND_DTL().get(i);
				fundTotal += PT_IL_POL_FUND_DTL_val.getPOFD_FUND_PERC();
				/*Added by pidugu raj dt: 27-08-2018 for KICLIFEQC-1762428*/
				compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN().setPOFD_POL_SYS_ID(PT_IL_POL_FUND_DTL_val.getPOFD_POL_SYS_ID());
				/*End added by pidugu raj dt: 27-08-2018 KICLIFEQC-1762428*/
				System.out.println(" fundTotal >>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + fundTotal);
				if(fundTotal == 0 || fundTotal>100)
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71070"));
			}
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POFD_EFF_FM_DT_WHEN_VALIDATE_ITEM(PILT002_APAC_COMPOSITE_ACTION compositeAction, 
			Date currValue) throws Exception {
		PT_IL_POL_FUND_DTL fundBean = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_FUND_DTL_ACTION fundAction = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN();
		ResultSet rs = null;
		Object[] values = {};
		Connection connection = null;
		String M_DUMMY = null;
		Date M_POFD_EFF_TO_DT = null;
		String query1 = " SELECT MAX(POFD_EFF_TO_DT) + 1 FROM PT_IL_POL_FUND_DTL WHERE POFD_FUND_CODE  =? AND" +
						" POFD_POL_SYS_ID = ? AND POFD_FUND_DIR_TYPE = 'P' AND POFD_SYS_ID != ? ";

		String query2 = " SELECT 'X' FROM PT_IL_POL_FUND_DTL WHERE POFD_FUND_CODE = ?  AND POFD_POL_SYS_ID = ? AND " +
				"POFD_FUND_DIR_TYPE = 'P'  AND POFD_EFF_TO_DT = ?  AND  POFD_SYS_ID != ?";
		fundBean.setPOFD_EFF_FM_DT(currValue);
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] {};
			//Date effToDate = (Date)compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getCOMP_POFD_EFF_TO_DT().getSubmittedValue();
			Date effToDate = fundBean.getPOFD_EFF_TO_DT();
			//added by gopi for toi on 15/06/18
			Date policy_fm_date =pt_il_policy_bean.getPOL_START_DT();
			DateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy");
			String polfmdate = dateformate.format(policy_fm_date);
			Date policy_fm_dt = dateformate.parse(polfmdate);
			
			
			Date policy_to_date =pt_il_policy_bean.getPOL_EXPIRY_DT();
			DateFormat dateformate2 = new SimpleDateFormat("dd/MM/yyyy");
			String poltodate = dateformate2.format(policy_to_date);
			Date policy_to_dt = dateformate2.parse(poltodate);
			//end
			
			
			/*
			if (currValue != null) {
			    	if(effToDate != null){
        			    	if (fundBean.getPOFD_EFF_FM_DT().after(effToDate)) {
        					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91010"));
        				} else if (currValue.before(pt_il_policy_bean.getPOL_START_DT())) {
        					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91439",
        												new Object[] {pt_il_policy_bean.getPOL_START_DT() }));
        				}
			    	}
			}*/

			if (currValue != null) {
			    	if(effToDate != null){
        			    	if (fundBean.getPOFD_EFF_FM_DT().after(effToDate)) {
        					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91010"));
        				} else if (currValue.before(policy_fm_dt)) {
        					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91439",
        												new Object[] {policy_fm_dt }));
        				}
			    	}
			}
			
			
			values = new Object[] {
									fundBean.getPOFD_FUND_CODE(),
									pt_il_policy_bean.getPOL_SYS_ID(),policy_to_dt
									/*pt_il_policy_bean.getPOL_EXPIRY_DT()*/,
									fundBean.getPOFD_SYS_ID() };

			rs = new CRUDHandler().executeSelectStatement(query2, connection, values);
			if (rs.next()) {
				M_DUMMY = rs.getString(1);
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
					"91438",new Object[] {fundBean.getPOFD_FUND_CODE() }));
			} else {
				values = new Object[] {
										fundBean.getPOFD_FUND_CODE(),
										pt_il_policy_bean.getPOL_SYS_ID(),
										fundBean.getPOFD_SYS_ID() };
				rs = new CRUDHandler().executeSelectStatement(query1,connection, values);
				if (rs.next()) {
					M_POFD_EFF_TO_DT = rs.getDate(1);
				}

				M_POFD_EFF_TO_DT = pt_il_policy_bean.getPOL_EXPIRY_DT();
				fundAction.getCOMP_POFD_EFF_TO_DT().setDisabled(false);
				fundAction.getCOMP_POFD_EFF_TO_DT().resetValue();
				/*if(M_POFD_EFF_TO_DT != null){
        				if (!M_POFD_EFF_TO_DT.equals(fundBean.getPOFD_EFF_FM_DT())) {
        					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91437"));
        				}
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void POFD_EFF_TO_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, Date currValue) throws Exception {
		PT_IL_POL_FUND_DTL fundBean = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		try {
			if (currValue != null) {
				if (currValue.before(fundBean.getPOFD_EFF_FM_DT())) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91001"));
				} else if (currValue.after(pt_il_policy_bean.getPOL_EXPIRY_DT())) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
						"71196",new Object[] {pt_il_policy_bean.getPOL_EXPIRY_DT() }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void percEnableDisable(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception
	{
		String query = "SELECT PROD_ALLOC_TYPE FROM PM_IL_PRODUCT WHERE PROD_CODE = (SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ? )";
		ResultSet resultset = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String M_NOTION = null;
		String query1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN  WHERE PLAN_CODE =?";
		ResultSet resultset1 = null;
		String planType = null;
		try {
			con = CommonUtils.getConnection();
			resultset = handler
					.executeSelectStatement(query, con,
							new Object[] { compositeAction
									.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
									.getPT_IL_POL_FUND_DTL_BEAN()
									.getPOFD_POL_SYS_ID() });
			if (resultset.next()) {
				M_NOTION = resultset.getString(1);
			}
			resultset1 = handler
					.executeSelectStatement(query1, con,
							new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()});
			if(resultset1.next()){
				planType = resultset1.getString("PLAN_TYPE");
			}
			
			
			if ("O".equalsIgnoreCase(M_NOTION)) {
				compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
						.getCOMP_POFD_FUND_PERC().setDisabled(false);
			} else {
				compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
						.getCOMP_POFD_FUND_PERC().setDisabled(true);

				/*Modified by pidugu raj dt:26-08-2018 to enable create delete post buttons for KICLIFEQC-1762428*/
				
				//if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().equalsIgnoreCase("G01") || compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				//.getPOL_PROD_CODE().equalsIgnoreCase("G02")){
				if(planType != null && "U".equalsIgnoreCase(planType)){
					compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getCOMP_ADD().setRendered(true);
					compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getCOMP_DEL().setRendered(true);
					compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getCOMP_POST().setRendered(true);
				/*Modified by pidugu raj dt:26-08-2018 to enable create delete post buttons for KICLIFEQC-1762428*/
				}else{
					compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getCOMP_ADD().setRendered(false);
					compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getCOMP_DEL().setRendered(false);
					compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getCOMP_POST().setRendered(false);
				}
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}
	
	public void fundPercentageCheck(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		String query = "SELECT PROD_ALLOC_TYPE FROM PM_IL_PRODUCT WHERE PROD_CODE = (SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ? )";
		String query2 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		/*Added by Sivarajan on 17/11/2019 for Sarwa IL*/
		String query3 = "SELECT PS_VALUE FROM PP_SYSTEM1  WHERE PS_TYPE = 'IL_FD_DTL_YN'";
		ResultSet resultset2 = null;
		Double value = 0.00;
		/*End*/
		ResultSet resultset = null;
		ResultSet resultset1 = null;
		Connection con = null;
		Connection con1 = null;
		CRUDHandler handler = new CRUDHandler();
		String M_NOTION = null;
		try {
			con = CommonUtils.getConnection();
			con1 = CommonUtils.getConnection();
			resultset = handler
					.executeSelectStatement(query, con,
							new Object[] { compositeAction
									.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
									.getPT_IL_POL_FUND_DTL_BEAN()
									.getPOFD_POL_SYS_ID() });
			
			resultset1 = handler
					.executeSelectStatement(query2, con,
							new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()});
			if (resultset.next()) {
				M_NOTION = resultset.getString(1);
			}
			String planType = null;
			if(resultset1.next()){
				planType = resultset1.getString(1);
			}
			Double UI_M_SUM_FUND_PERC = 0.0;
			PT_IL_POL_FUND_DTL fund_detail = compositeAction
					.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
					.getPT_IL_POL_FUND_DTL_BEAN();
			/*
			 * if (currValue <= 0 || currValue > 100) { throw new
			 * Exception(Messages.getString(PELConstants.pelErrorMessagePath,
			 * "71070")); }
			 */
			/*Modified by pidugu raj dt: 27-08-2018 for KICLIFEQC-1762428
			 * if ("O".equalsIgnoreCase(M_NOTION)) {*/
			
			/*Modified by pidugu raj dt: 03-09-2018 for KICLIFEQC-1763231*/
			String liqVariable = "liquidNotPresent";
			double liqAllocated = 0.00;
			/*End KICLIFEQC-1763231*/
			if ("N".equalsIgnoreCase(M_NOTION)) {
			/*End*/
				for (PT_IL_POL_FUND_DTL fund : compositeAction
						.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
						.getDataList_PT_IL_POL_FUND_DTL()) {
					UI_M_SUM_FUND_PERC = UI_M_SUM_FUND_PERC
							+ fund.getPOFD_FUND_PERC();
					/*Modified by pidugu raj dt: 03-09-2018 for KICLIFEQC-1763231*/
					if(fund.getPOFD_FUND_CODE().equalsIgnoreCase("LIQUID FUND") && planType.equalsIgnoreCase("U")){
						liqVariable = "liquidPresent";
						liqAllocated = fund.getPOFD_FUND_PERC();
						
					}
				}
				/*Modified by pidgu raj dt: 09-10-2018 for kic as suggested by vijay and sivaraman
				 * if(liqAllocated < 15 && liqAllocated > 0.00 && planType.equalsIgnoreCase("U")){
					throw new Exception("Liquid fund allocated percentage should not be less than 15%");
				}*/
				String IL_FUND_VAL = CommonUtils.getPPSystemParameterValue("IL_FUND_VAL").toString();
				int fundParameterValue = Integer.valueOf(IL_FUND_VAL);
				if(liqAllocated < fundParameterValue && liqAllocated > 0.00 && planType.equalsIgnoreCase("U")){
					throw new Exception("Liquid fund allocated percentage should not be less than "+fundParameterValue+"%");
				}
				/*End KICLIFEQC-1763231*/
				if (!compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
						.getDataList_PT_IL_POL_FUND_DTL().contains(fund_detail)) {
					UI_M_SUM_FUND_PERC = UI_M_SUM_FUND_PERC
							+ fund_detail.getPOFD_FUND_PERC();
				}
				//As discussed with siva sir below code commanted by gopi for kic 29/01/19
				/*if (UI_M_SUM_FUND_PERC != null) {
					if (UI_M_SUM_FUND_PERC > 100.00) {
						throw new Exception("Fund allocation percentage should not exceeds 100");
					}
					if(UI_M_SUM_FUND_PERC == 100.00){
						if(liqVariable.equalsIgnoreCase("liquidNotPresent") && planType.equalsIgnoreCase("U")){
							throw new Exception("Kindly add 15% for liquid fund in fund details");
						}
						}
				}*/
				/*Added by Sivarajan on 17/11/2019 for sarwa IL*/
				resultset2 = handler.executeSelectStatement(query3, con);
				if(resultset2.next()){
					value = resultset2.getDouble(1);
				}
				/*End*/
				/*Condition are added by Sivarajan on 17/11/2019 for sarwa IL*/
				if(value > 0){
					double fundAllocatedPercentageTotal = 0.00;
					for (PT_IL_POL_FUND_DTL fund : compositeAction
						.getPT_IL_POL_FUND_DTL_ACTION_BEAN()
						.getDataList_PT_IL_POL_FUND_DTL()) {
						fundAllocatedPercentageTotal = fundAllocatedPercentageTotal
							+ fund.getPOFD_FUND_PERC();
					
						if(fundAllocatedPercentageTotal == 100.00){
							if(liqVariable.equalsIgnoreCase("liquidNotPresent") && planType.equalsIgnoreCase("U")){
							/*Modified by pidgu raj dt: 09-10-2018 for kic as suggested by vijay and sivaraman
							 * throw new Exception("Kindly add 15% for liquid fund in fund details");*/
								throw new Exception("Kindly add "+fundParameterValue+"% for liquid fund in fund details");
							/*End*/
							}
						}
					
					
					}
				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
