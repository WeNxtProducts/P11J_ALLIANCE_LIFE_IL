package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_PA_BENEFIT_HELPER {

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_PA_BENEFIT_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_PROD_PA_BENEFIT> dataList = compositeAction
					.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
					.getDataList_PM_IL_PROD_PA_BENEFIT();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_PA_BENEFIT PM_IL_PROD_PA_BENEFIT_BEAN = dataList
						.get(0);
				PM_IL_PROD_PA_BENEFIT_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
						.setPM_IL_PROD_PA_BENEFIT_BEAN(
								PM_IL_PROD_PA_BENEFIT_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_CREATE_RECORD(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_IL_PROD_PA_BENEFIT pm_il_prod_pa_benefit_bean = compositeAction
					.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
					.getPM_IL_PROD_PA_BENEFIT_BEAN();
			pm_il_prod_pa_benefit_bean.setPPB_BUSN_TYPE("PA");
			pm_il_prod_pa_benefit_bean.setPPB_BEN_CALC_YN("Y");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_PA_BENEFIT pm_il_prod_pa_benefit_bean = compositeAction
				.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
				.getPM_IL_PROD_PA_BENEFIT_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			pm_il_prod_pa_benefit_bean.setPPB_PROD_CODE(pm_il_product_bean.getPROD_CODE());
			pm_il_prod_pa_benefit_bean.setPPB_CR_DATE(new CommonUtils().getCurrentDate());
			pm_il_prod_pa_benefit_bean.setPPB_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_PA_BENEFIT pm_il_prod_pa_benefit_bean = compositeAction
				.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
				.getPM_IL_PROD_PA_BENEFIT_BEAN();
		try {
			pm_il_prod_pa_benefit_bean.setPPB_UPD_DATE(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_pa_benefit_bean.setPPB_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void WHEN_VALIDATE_ITEM_PPB_COVER_CODE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PM_IL_PROD_PA_BENEFIT pm_il_prod_pa_benefit_bean = compositeAction
				.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
				.getPM_IL_PROD_PA_BENEFIT_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String M_C1FOUND = null;
		String M_C1AFOUND = null;
		String C1 = "SELECT 'X'  FROM PM_IL_PROD_APPL_COVER "
				+ "WHERE PAC_PROD_CODE = ? AND PAC_COVER_CODE = ?";
		String C1A = "SELECT 'X' FROM PM_IL_PRODUCT "
				+ "WHERE PROD_CODE = ? AND PROD_PLAN_CODE= ?";
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		CRUDHandler hander = new CRUDHandler();
		Object[] c1Values = null;
		Object[] c2Values = null;
		try {
			con = CommonUtils.getConnection();
			if (pm_il_prod_pa_benefit_bean.getPPB_COVER_CODE() != null) {
				c1Values = new Object[] { pm_il_product_bean.getPROD_CODE(),
						pm_il_prod_pa_benefit_bean.getPPB_COVER_CODE() };
				rs1 = hander.executeSelectStatement(C1, con, c1Values);
				while (rs1.next()) {

					M_C1FOUND = rs1.getString(1);
				}
				if (M_C1FOUND == null) {
					c2Values = new Object[] {
							pm_il_product_bean.getPROD_CODE(),
							pm_il_prod_pa_benefit_bean.getPPB_COVER_CODE() };
					rs2 = hander.executeSelectStatement(C1A, con, c2Values);
					while (rs2.next()) {
						M_C1AFOUND = rs2.getString(1);
					}
					if (M_C1AFOUND == null) {
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "Invalid cover code" }));
					}
				}
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

	public void WHEN_VALIDATE_ITEM_PPB_ACNT_YEAR(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PM_IL_PROD_PA_BENEFIT pm_il_prod_pa_benefit_bean = compositeAction
				.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
				.getPM_IL_PROD_PA_BENEFIT_BEAN();

		String C1 = "SELECT ROWID  FROM PM_IL_PROD_PA_BENEFIT  WHERE PPB_ACNT_YEAR = ?  AND PPB_COVER_CODE =? "
				+ "AND PPB_BUSN_TYPE = ?  AND PPB_PROD_CODE =  ?";

		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler hander = new CRUDHandler();
		Object[] c1Values = null;
		String dbRowId = null;
		String beanRowId = null;
		try {
			con = CommonUtils.getConnection();
			if (pm_il_prod_pa_benefit_bean.getPPB_ACNT_YEAR() != null) {
				c1Values = new Object[] {
						pm_il_prod_pa_benefit_bean.getPPB_ACNT_YEAR(),
						pm_il_prod_pa_benefit_bean.getPPB_COVER_CODE(),
						pm_il_prod_pa_benefit_bean.getPPB_BUSN_TYPE(),
						pm_il_prod_pa_benefit_bean.getPPB_PROD_CODE() };
				rs1 = hander.executeSelectStatement(C1, con, c1Values);
				if (rs1.next()){
					dbRowId = rs1.getString(1);
				}
				beanRowId = pm_il_prod_pa_benefit_bean.getROWID();
				if(CommonUtils.isDuplicate(beanRowId, dbRowId)){
					throw new ValidatorException(
						Messages.getMessage(PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Account Year cannot be same for the cover code" }));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PPB_MORT_CODE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PM_IL_PROD_PA_BENEFIT pm_il_prod_pa_benefit_bean = compositeAction
				.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
				.getPM_IL_PROD_PA_BENEFIT_BEAN();

		String C1 = "SELECT 'X' FROM PM_CODES "
				+ "WHERE PC_TYPE = 'IL_MORT_CODE' AND PC_CODE = ?";
		String M_C1FOUND = null;
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler hander = new CRUDHandler();
		Object[] c1Values = null;
		try {
			con = CommonUtils.getConnection();
			if (pm_il_prod_pa_benefit_bean.getPPB_MORT_CODE() != null) {
				c1Values = new Object[] { pm_il_prod_pa_benefit_bean
						.getPPB_MORT_CODE() };
				rs1 = hander.executeSelectStatement(C1, con, c1Values);
				while (rs1.next()) {
					M_C1FOUND = rs1.getString(1);
				}
				if (M_C1FOUND == null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "Invalid mort code" }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PPB_BEN_CALC_YN(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PM_IL_PROD_PA_BENEFIT pm_il_prod_pa_benefit_bean = compositeAction
				.getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN()
				.getPM_IL_PROD_PA_BENEFIT_BEAN();

		String C1 = "SELECT 'X' " + "FROM PM_CODES "
				+ "WHERE PC_TYPE = 'IL_MORT_CODE' " + "AND PC_CODE = ?";
		String M_C1FOUND = null;
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler hander = new CRUDHandler();
		Object[] c1Values = null;
		try {
			con = CommonUtils.getConnection();
			if (pm_il_prod_pa_benefit_bean.getPPB_MORT_CODE() != null) {
				c1Values = new Object[] { pm_il_prod_pa_benefit_bean
						.getPPB_MORT_CODE() };
				rs1 = hander.executeSelectStatement(C1, con, c1Values);
				while (rs1.next()) {
					M_C1FOUND = rs1.getString(1);
				}
				if (M_C1FOUND == null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "Invalid mort code" }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
