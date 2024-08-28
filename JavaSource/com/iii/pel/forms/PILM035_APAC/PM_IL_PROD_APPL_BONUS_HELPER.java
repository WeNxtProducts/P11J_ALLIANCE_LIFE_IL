package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_BONUS_HELPER {

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_PROD_APPL_BONUS pm_il_prod_appl_bonus_bean = compositeAction
				.getPM_IL_PROD_APPL_BONUS_ACTION_BEAN()
				.getPM_IL_PROD_APPL_BONUS_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
		.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			pm_il_prod_appl_bonus_bean.setPAB_PROD_CODE(pm_il_product_bean.getPROD_CODE());
			L_VAL_BONUS_UNIQUE(compositeAction);
			pm_il_prod_appl_bonus_bean.setPAB_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_appl_bonus_bean.setPAB_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_PROD_APPL_BONUS pm_il_prod_appl_bonus_bean = compositeAction
				.getPM_IL_PROD_APPL_BONUS_ACTION_BEAN()
				.getPM_IL_PROD_APPL_BONUS_BEAN();
		try {
			L_VAL_BONUS_UNIQUE(compositeAction);
			pm_il_prod_appl_bonus_bean.setPAB_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_appl_bonus_bean.setPAB_UPD_UID(CommonUtils
					.getControlBean().getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void POST_QUERY(PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PM_IL_PROD_APPL_BONUS pm_il_prod_appl_bonus_bean = compositeAction
				.getPM_IL_PROD_APPL_BONUS_ACTION_BEAN()
				.getPM_IL_PROD_APPL_BONUS_BEAN();
		String desc = null;
		try {
			desc = L_VAL_BONUS(pm_il_prod_appl_bonus_bean.getPAB_BONUS_CODE(),
						pm_il_prod_appl_bonus_bean.getPAB_BONUS_CODE_DESC());
			if(desc != null){
				pm_il_prod_appl_bonus_bean.setPAB_BONUS_CODE_DESC(desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String L_VAL_BONUS(String M_BONUS_CODE, String M_BONUS_DESC) throws Exception {
		ResultSet rs = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String M_TEMP = null;
		
		String c1 = " SELECT  BONUS_DESC FROM  PM_IL_BONUS WHERE   BONUS_CODE = ?";
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = {M_BONUS_CODE };
			rs = handler.executeSelectStatement(c1, con, c1values);
			while (rs.next()) {
				M_TEMP = rs.getString(1);
			}
			if (M_TEMP == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91055"));
			} else {
				M_BONUS_DESC = M_TEMP;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return M_BONUS_DESC;
	}

	public void L_VAL_BONUS_UNIQUE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String M_DUMMY = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_BONUS pm_il_prod_appl_bonus_bean = compositeAction
				.getPM_IL_PROD_APPL_BONUS_ACTION_BEAN()
				.getPM_IL_PROD_APPL_BONUS_BEAN();
		String C1 = " SELECT 'X'  FROM   PM_IL_PROD_APPL_BONUS WHERE  PAB_PROD_CODE  = ? AND "
				+ "PAB_BONUS_CODE = ? ";
		String C2 = "SELECT 'X' FROM   PM_IL_PROD_APPL_BONUS WHERE  PAB_PROD_CODE = ? AND "
				+ "PAB_BONUS_CODE = ? AND ROWID <> ? ";
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = { pm_il_product_bean.getPROD_CODE(),
					pm_il_prod_appl_bonus_bean.getPAB_BONUS_CODE() };
			rs1 = handler.executeSelectStatement(C1, con, c1values);
			if (pm_il_prod_appl_bonus_bean.getROWID() == null) {
				while (rs1.next()) {
					M_DUMMY = rs1.getString(1);
				}
			}
			if (M_DUMMY != null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91056"));
			}
			Object[] c2values = { pm_il_product_bean.getPROD_CODE(),
					pm_il_prod_appl_bonus_bean.getPAB_BONUS_CODE(),
					pm_il_prod_appl_bonus_bean.getROWID() };
			rs2 = handler.executeSelectStatement(C2, con, c2values);
			while (rs2.next()) {
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
				}
			}
			if (M_DUMMY != null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91056"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PAB_BONUS_CODE(PILM035_APAC_COMPOSITE_ACTION compositeAction,
								Object currValue) throws Exception{
		PM_IL_PROD_APPL_BONUS pm_il_prod_appl_bonus_bean = compositeAction
				.getPM_IL_PROD_APPL_BONUS_ACTION_BEAN()
				.getPM_IL_PROD_APPL_BONUS_BEAN();
		String PAB_BONUS_CODE = (String) currValue;
		try {
			L_VAL_BONUS_UNIQUE(compositeAction);
			L_VAL_BONUS(PAB_BONUS_CODE, pm_il_prod_appl_bonus_bean
					.getPAB_BONUS_CODE_DESC());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_APPL_BONUS_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_PROD_APPL_BONUS> dataList = compositeAction
					.getPM_IL_PROD_APPL_BONUS_ACTION_BEAN()
					.getDataList_PM_IL_PROD_APPL_BONUS();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_APPL_BONUS PM_IL_PROD_APPL_BONUS_BEAN = dataList
						.get(0);
				PM_IL_PROD_APPL_BONUS_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_APPL_BONUS_ACTION_BEAN()
						.setPM_IL_PROD_APPL_BONUS_BEAN(
								PM_IL_PROD_APPL_BONUS_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
