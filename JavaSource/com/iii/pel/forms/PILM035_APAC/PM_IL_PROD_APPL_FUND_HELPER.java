package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_FUND_HELPER {
	public void PRE_BLOCK(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
		
	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_APPL_FUND_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_PROD_APPL_FUND> dataList = compositeAction
					.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
					.getDataList_PM_IL_PROD_APPL_FUND();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_APPL_FUND PM_IL_PROD_APPL_FUND_BEAN = dataList
						.get(0);
				PM_IL_PROD_APPL_FUND_BEAN.setRowSelected(true);
				compositeAction
						.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
						.setPM_IL_PROD_APPL_FUND_BEAN(PM_IL_PROD_APPL_FUND_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		PM_IL_PROD_APPL_FUND pm_il_prod_appl_fund_bean = compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_FUND_BEAN();
		String C1 = "SELECT FS_DESC " + "FROM   PM_IL_FUND_SETUP "
				+ "WHERE  FS_CODE = ? ";
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = { pm_il_prod_appl_fund_bean.getPAF_FUND_CODE() };
			rs1 = handler.executeSelectStatement(C1, con, c1values);
			if (pm_il_prod_appl_fund_bean.getPAF_FUND_CODE() != null) {
				while (rs1.next()) {
					pm_il_prod_appl_fund_bean.setUI_M_FUND_DESC(rs1
							.getString(1));
				}
			}
			if ("Y".equalsIgnoreCase(pm_il_prod_appl_fund_bean
					.getPAF_DEFAULT_YN())) {
				pm_il_prod_appl_fund_bean
						.setUI_M_ALLOC_PERC(pm_il_prod_appl_fund_bean
								.getPAF_FUND_PERC());
			} else {
				pm_il_prod_appl_fund_bean.setUI_M_ALLOC_PERC(0.0);
			}
		} catch (SQLException e) {
			e.printStackTrace();throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_CREATE_RECORD(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_PROD_APPL_FUND pm_il_prod_appl_fund_bean = compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_FUND_BEAN();
		try {
			if("S".equalsIgnoreCase(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_FUND_ALLOWED())){
				pm_il_prod_appl_fund_bean.setPAF_DEFAULT_YN("Y");
				pm_il_prod_appl_fund_bean.setPAF_FUND_PERC(100.0);
			}else{
			pm_il_prod_appl_fund_bean.setPAF_DEFAULT_YN("N");
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void WHEN_NEW_RECORD_INSTANACE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		String M_DUMMY = null;
		PM_IL_PROD_APPL_FUND pm_il_prod_appl_fund_bean = compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_FUND_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String C1 = "SELECT 'X' " + "FROM   PM_IL_PROD_APPL_FUND "
				+ "WHERE  PAF_PROD_CODE = ? " + "AND    PAF_DEFAULT_YN = 'Y' "
				+ "AND    PAF_FUND_DIR_TYPE  = 'P' " + "AND    ROWID != ?";
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = { pm_il_product_bean.getPROD_CODE(),
					pm_il_prod_appl_fund_bean.getROWID() };
			rs = handler.executeSelectStatement(C1, con, c1values);
			// IF :SYSTEM.FORM_STATUS IN ('CHANGED','NEW')
			if (("S"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_FUND_ALLOWED()))
					&& ("Y".equalsIgnoreCase(pm_il_prod_appl_fund_bean
							.getPAF_DEFAULT_YN()))) {
				while (rs.next()) {
					M_DUMMY = rs.getString(1);
					if (M_DUMMY != null) {
						pm_il_prod_appl_fund_bean.setPAF_DEFAULT_YN("N");
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91967"));
					}
				}
			}
			if ("S".equalsIgnoreCase(pm_il_product_bean.getPROD_FUND_ALLOWED())) {
				pm_il_prod_appl_fund_bean.setPAF_FUND_PERC(100.0);
			}
		} catch (SQLException e) {
			e.printStackTrace();throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PAF_FUND_CODE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		ResultSet rs = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String M_CHAR = null;
		String M_FUND_DESC = null;
		String PAF_FUND_CODE = (String) currValue;
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_FUND pm_il_prod_appl_fund_bean = compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_FUND_BEAN();
		String C1 = "SELECT FS_DESC FROM   PM_IL_FUND_SETUP "
				+ "WHERE  FS_CODE = ? ";
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = {PAF_FUND_CODE  };
			rs = handler.executeSelectStatement(C1, con, c1values);
			if (PAF_FUND_CODE != null) {
				while (rs.next()) {
					M_FUND_DESC = rs.getString(1);
					pm_il_prod_appl_fund_bean
							.setUI_M_FUND_DESC(M_FUND_DESC);
				}
				if (M_FUND_DESC == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91423"));
				}
			}
			if ("S".equalsIgnoreCase(pm_il_product_bean.getPROD_FUND_ALLOWED())) {
				pm_il_prod_appl_fund_bean.setPAF_FUND_PERC(100.0);
				pm_il_prod_appl_fund_bean.setPAF_DEFAULT_YN("Y");
				compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN().getCOMP_PAF_DEFAULT_YN().setDisabled(true);
				
				compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN().getCOMP_PAF_FUND_PERC().setDisabled(true);
			}else{
				compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN().getCOMP_PAF_DEFAULT_YN().setDisabled(false);
				
				compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN().getCOMP_PAF_FUND_PERC().setDisabled(false);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PAF_FUND_PERC(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_APPL_FUND pm_il_prod_appl_fund_bean = compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_FUND_BEAN();
		Double PAF_FUND_PERC = (Double) currValue;
		try {
			if (PAF_FUND_PERC != null) {
				if ((CommonUtils.nvl(pm_il_prod_appl_fund_bean
						.getPAF_FUND_PERC(), 0)) <= 0
						|| (CommonUtils.nvl(pm_il_prod_appl_fund_bean
								.getPAF_FUND_PERC(), 0) > 100)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71070"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void WHEN_VALIDATE_ITEM_PAF_DEFAULT_YN(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		String M_DUMMY = null;
		ResultSet rs = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_FUND pm_il_prod_appl_fund_bean = compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_FUND_BEAN();
		String C1 = " SELECT PAF_FUND_CODE " + "FROM   PM_IL_PROD_APPL_FUND "
				+ "WHERE  PAF_PROD_CODE = ? " + "AND    PAF_DEFAULT_YN = 'Y' "
				+ "AND    PAF_FUND_DIR_TYPE  = 'P' " + "AND    ROWID != ? ";
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = { pm_il_product_bean.getPROD_CODE(),
					pm_il_prod_appl_fund_bean.getROWID() };
			rs = handler.executeSelectStatement(C1, con, c1values);
			// IF :SYSTEM.FORM_STATUS IN ('CHANGED','NEW') THEN
			if (("S"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_FUND_ALLOWED()))
					&& ("Y".equalsIgnoreCase(pm_il_prod_appl_fund_bean
							.getPAF_DEFAULT_YN()))) {
				while (rs.next()) {
					M_DUMMY = rs.getString(1);
				}
				if (M_DUMMY != null) {
					pm_il_prod_appl_fund_bean.setPAF_DEFAULT_YN("N");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_LIST_CHANGED_PAF_DEFAULT_YN(
			PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception{
		ResultSet rs = null;
		Connection con = null;
		int M_COUNT = 0;
		String M_DUMMY = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_FUND pm_il_prod_appl_fund_bean = compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_FUND_BEAN();
		String C1 = " SELECT 'X' " + "FROM   PM_IL_PROD_APPL_FUND "
				+ "WHERE  PAF_PROD_CODE = :PM_IL_PRODUCT.PROD_CODE "
				+ "AND    PAF_DEFAULT_YN = ' Y' "
				+ "AND    PAF_FUND_DIR_TYPE  = 'P' "
				+ "AND    ROWID != :PM_IL_PROD_APPL_FUND.ROWID ";
		try {
			con = CommonUtils.getConnection();
			if ("Y".equalsIgnoreCase(pm_il_prod_appl_fund_bean
					.getPAF_DEFAULT_YN())) {
				pm_il_prod_appl_fund_bean
						.setUI_M_ALLOC_PERC(pm_il_prod_appl_fund_bean
								.getPAF_FUND_PERC());
			} else {
				pm_il_prod_appl_fund_bean.setUI_M_ALLOC_PERC(0.0);
			}
			Object[] c1values = { pm_il_product_bean.getPROD_CODE(),
					pm_il_prod_appl_fund_bean.getROWID() };
			rs = handler.executeSelectStatement(C1, con, c1values);

			// IF :SYSTEM.FORM_STATUS IN ('CHANGED','NEW') THEN
			if (("S"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_FUND_ALLOWED()))
					&& ("Y".equalsIgnoreCase(pm_il_prod_appl_fund_bean
							.getPAF_DEFAULT_YN()))) {
				while (rs.next()) {
					M_DUMMY = rs.getString(1);
				}
				if (M_DUMMY != null) {
					pm_il_prod_appl_fund_bean.setPAF_DEFAULT_YN("N");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_PROD_APPL_FUND pm_il_prod_appl_fund_bean = compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_FUND_BEAN();
		try {
			pm_il_prod_appl_fund_bean.setPAF_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_appl_fund_bean.setPAF_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.USER_id"));
			pm_il_prod_appl_fund_bean.setPAF_FUND_DIR_TYPE("P");
			pm_il_prod_appl_fund_bean.setPAF_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());
			L_VAL_UNIQUE_FUND_CODE(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_PROD_APPL_FUND pm_il_prod_appl_fund_bean = compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_FUND_BEAN();
		try {
			pm_il_prod_appl_fund_bean.setPAF_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_appl_fund_bean.setPAF_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.USER_ID"));
			L_VAL_UNIQUE_FUND_CODE(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void L_VAL_UNIQUE_FUND_CODE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		PM_IL_PROD_APPL_FUND pm_il_prod_appl_fund_bean = compositeAction
				.getPM_IL_PROD_APPL_FUND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_FUND_BEAN();

		String C1 = "SELECT 'X'  FROM   PM_IL_PROD_APPL_FUND WHERE  PAF_FUND_CODE = ?  AND    PAF_PROD_CODE = ?  "
				+ "AND    PAF_FUND_DIR_TYPE  = 'P' ";

		String C2 = " SELECT 'X'  FROM   PM_IL_PROD_APPL_FUND WHERE  PAF_FUND_CODE = ? " + "AND    PAF_PROD_CODE = ? "
				+ "AND    PAF_FUND_DIR_TYPE  = 'P' AND    ROWID <> ? ";
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = { pm_il_prod_appl_fund_bean.getPAF_FUND_CODE(),
					pm_il_prod_appl_fund_bean.getPAF_PROD_CODE() };
			Object[] c2values = { pm_il_prod_appl_fund_bean.getPAF_FUND_CODE(),
					pm_il_prod_appl_fund_bean.getPAF_PROD_CODE(),
					pm_il_prod_appl_fund_bean.getROWID() };
			if(pm_il_prod_appl_fund_bean.getROWID()== null){
				rs1 = handler.executeSelectStatement(C1, con, c1values);
			while (rs1.next()) {
				M_DUMMY = rs1.getString(1);
			}
			if (M_DUMMY != null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71026"));
			} 
			}else {
				rs2 = handler.executeSelectStatement(C2, con, c2values);
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
				}
				if (M_DUMMY != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71026"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
