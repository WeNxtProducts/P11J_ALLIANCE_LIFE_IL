package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_FUND_DTL_HELPER {

	
public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction)throws Exception {
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

	public void POST_QUERY(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		
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

	public void PRE_INSERT(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
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

	public void PRE_UPDATE(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		
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

	public void PRE_BLOCK(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			/*
			 * IF FORM_FAILURE THEN :GLOBAL.M_FAILURE := 'TRUE'; END IF;
			 * :CTRL.M_DELETE_MSG_FLAG := 'N';
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PRE_QUERY(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL fundBean = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			fundBean.setPOFD_POL_SYS_ID(pt_il_policy_bean.getPOL_SYS_ID());
			fundBean.setPOFD_FUND_DIR_TYPE("P");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	//PENDING
	public void WHEN_NEW_BLOCK_INSTANCE(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			executeQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		
		PT_IL_POL_FUND_DTL_ACTION fundAction = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN();
		PT_IL_POL_FUND_DTL fundBean = fundAction.getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		ResultSet rs = null;
		Object[] values = {};
		Connection connection = null;
		String M_PROD_FUND_ALLOWED = null;

		String query2 = " SELECT PROD_FUND_ALLOWED  FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };
			rs = new CRUDHandler().executeSelectStatement(query2, connection,values);

			if (rs.next()) {
				M_PROD_FUND_ALLOWED = rs.getString(1);
			}
			
			if (fundBean.getPOFD_FUND_CODE() != null) {
				if ("M".equals(M_PROD_FUND_ALLOWED)) { 
					fundAction.getCOMP_POFD_FUND_PERC().setRequired(true);
					fundAction.getCOMP_POFD_EFF_FM_DT().setRequired(true);
					fundAction.getCOMP_POFD_EFF_TO_DT().setRequired(true);
				} else if ("S".equals(M_PROD_FUND_ALLOWED)) {
					fundBean.setPOFD_FUND_PERC(100d);
					fundAction.getCOMP_POFD_FUND_PERC().setDisabled(true);
					fundAction.getCOMP_POFD_FUND_PERC().setDisabled(true);
					fundAction.getCOMP_POFD_EFF_FM_DT().setDisabled(true);
					fundAction.getCOMP_POFD_EFF_FM_DT().setDisabled(true);
					fundAction.getCOMP_POFD_EFF_TO_DT().setDisabled(true);
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

	public void WHEN_CREATE_RECORD(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
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
	public void KEY_DELREC(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
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

	public void POFD_FUND_CODE_WHEN_VALIDATE_ITEM(
			PILQ003_COMPOSITE_ACTION compositeAction, String currValue) throws Exception {
		
		PT_IL_POL_FUND_DTL_ACTION fundAction = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN();
		PT_IL_POL_FUND_DTL fundBean = fundAction.getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		ResultSet rs = null;
		Object[] values = {};
		Connection connection = null;
		String M_PROD_FUND_ALLOWED = null;
		fundBean.setPOFD_FUND_CODE(currValue);
		
		String query1 = " SELECT FS_DESC FROM PM_IL_FUND_SETUP WHERE FS_CODE = ?";
		String query2 = " SELECT PROD_FUND_ALLOWED FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { pt_il_policy_bean.getPOL_PROD_CODE() };
			rs = new CRUDHandler().executeSelectStatement(query2, connection,values);
			if (rs.next()) {
				M_PROD_FUND_ALLOWED = rs.getString(1);
			}

			if (fundBean.getPOFD_FUND_CODE() != null) {
				if ("M".equals(M_PROD_FUND_ALLOWED)) {
					fundAction.getCOMP_POFD_FUND_PERC().setRequired(true);
					fundAction.getCOMP_POFD_EFF_FM_DT().setRequired(true);
					fundBean.setPOFD_EFF_FM_DT(null);
					fundAction.getCOMP_POFD_EFF_TO_DT().setRequired(true);
					fundBean.setPOFD_EFF_TO_DT(null);
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
	}

	public void POFD_FUND_PERC_WHEN_VALIDATE_ITEM(Double currValue) throws Exception {
		try {
			if (currValue <= 0 || currValue > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71070"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POFD_EFF_FM_DT_WHEN_VALIDATE_ITEM(PILQ003_COMPOSITE_ACTION compositeAction, 
			Date currValue) throws Exception {
		PT_IL_POL_FUND_DTL fundBean = compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getPT_IL_POL_FUND_DTL_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
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
			if (currValue != null) {
			    	if(effToDate != null){
        			    	if (fundBean.getPOFD_EFF_FM_DT().after(effToDate)) {
        					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91010"));
        				} else if (currValue.before(pt_il_policy_bean.getPOL_START_DT())) {
        					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91439",
        												new Object[] {pt_il_policy_bean.getPOL_START_DT() }));
        				}
			    	}
			}
			values = new Object[] {
									fundBean.getPOFD_FUND_CODE(),
									pt_il_policy_bean.getPOL_SYS_ID(),
									pt_il_policy_bean.getPOL_EXPIRY_DT(),
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
				if(M_POFD_EFF_TO_DT != null){
        				if (!M_POFD_EFF_TO_DT.equals(fundBean.getPOFD_EFF_FM_DT())) {
        					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91437"));
        				}
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
	}

	public void POFD_EFF_TO_DT_WHEN_VALIDATE_ITEM(
			PILQ003_COMPOSITE_ACTION compositeAction, Date currValue) throws Exception {
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
}
