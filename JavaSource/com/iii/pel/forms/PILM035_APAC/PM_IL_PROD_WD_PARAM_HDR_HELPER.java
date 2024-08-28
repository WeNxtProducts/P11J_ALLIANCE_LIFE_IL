package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_WD_PARAM_HDR_HELPER {

	public void PRE_BLOCK(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws ParseException, SQLException, DBException {
		PM_IL_PROD_WD_PARAM_HDR pm_il_prod_wd_param_hdr_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_HDR_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String c1 = "SELECT P9IL_PWPH_SYS_ID.NEXTVAL FROM   DUAL";
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(c1, con);
			while (rs.next()) {
				pm_il_prod_wd_param_hdr_bean.setPWPH_SYS_ID(rs.getInt(1));

			}
			pm_il_prod_wd_param_hdr_bean.setPWPH_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_wd_param_hdr_bean.setPWPH_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
			pm_il_prod_wd_param_hdr_bean.setPWPH_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
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

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_IL_PROD_WD_PARAM_HDR pm_il_prod_wd_param_hdr_bean = compositeAction
					.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
					.getPM_IL_PROD_WD_PARAM_HDR_BEAN();
			pm_il_prod_wd_param_hdr_bean.setPWPH_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_wd_param_hdr_bean.setPWPH_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.USER_ID"));
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_WD_PARAM_HDR_DELEGATE()
					.executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PWPH_WITHDRAW_MIN_YRS(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_WD_PARAM_HDR pm_il_prod_wd_param_hdr_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_HDR_BEAN();
		Integer PWPH_WITHDRAW_MIN_YRS = (Integer) currValue;
		try {
			if (pm_il_prod_wd_param_hdr_bean.getPWPH_TOPUP_MIN_YRS() != null) {
				if ((pm_il_prod_wd_param_hdr_bean.getPWPH_TOPUP_MIN_YRS()) > PWPH_WITHDRAW_MIN_YRS) {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void WHEN_VALIDATE_ITEM_PWPH_TOPUP_MIN_YRS(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_WD_PARAM_HDR pm_il_prod_wd_param_hdr_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_HDR_BEAN();
		Integer PWPH_TOPUP_MIN_YRS = (Integer) currValue;
		try {
			if (pm_il_prod_wd_param_hdr_bean.getPWPH_WITHDRAW_MIN_YRS() != null) {
				if (PWPH_TOPUP_MIN_YRS > (pm_il_prod_wd_param_hdr_bean
						.getPWPH_WITHDRAW_MIN_YRS())) {
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"90008", new Object[] { "Withdraw Min Yrs",
											"Topup Min Yrs" }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}
}
