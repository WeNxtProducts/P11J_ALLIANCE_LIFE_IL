package com.iii.pel.forms.PILM035_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD_ACTION;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PROD_CONTRI_CHARGE_HELPER {
	
	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {

		String query = "SELECT ROWID,PM_IL_PROD_CONTRI_CHARGE.* FROM PM_IL_PROD_CONTRI_CHARGE WHERE PCC_PROD_CODE = ?";

		Connection con = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getDataList_PM_IL_PROD_CONTRI_CHARGE().clear();
		
		try {
			
			/*added by raja on 19-04-2017*/
			ArrayList<String> list = null;
			/*end*/
			
			con = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, con,
					new Object[] { compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE()});
			while (resultSet.next()) {
				PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN = new PM_IL_PROD_CONTRI_CHARGE();
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_PROD_CODE(resultSet.getString("PCC_PROD_CODE"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CHRG_CODE(resultSet.getString("PCC_CHRG_CODE"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CON_LMT_FM(resultSet.getDouble("PCC_CON_LMT_FM"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CON_LMT_TO(resultSet.getDouble("PCC_CON_LMT_TO"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CHRG_TYPE(resultSet.getString("PCC_CHRG_TYPE"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_RATE(resultSet.getDouble("PCC_RATE"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_RATE_PER(resultSet.getDouble("PCC_RATE_PER"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FIXED_AMT(resultSet.getDouble("PCC_FIXED_AMT"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CR_DT(resultSet.getDate("PCC_CR_DT"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CR_UID(resultSet.getString("PCC_CR_UID"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_UPD_DT(resultSet.getDate("PCC_UPD_DT"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_UPD_UID(resultSet.getString("PCC_UPD_UID"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_01(resultSet.getString("PCC_FLEX_01"));
				/*PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_02(resultSet.getString("PCC_FLEX_02"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_03(resultSet.getString("PCC_FLEX_03"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_04(resultSet.getString("PCC_FLEX_04"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_05(resultSet.getString("PCC_FLEX_05"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_06(resultSet.getString("PCC_FLEX_06"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_07(resultSet.getString("PCC_FLEX_07"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_08(resultSet.getString("PCC_FLEX_08"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_09(resultSet.getString("PCC_FLEX_09"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_10(resultSet.getString("PCC_FLEX_10"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_11(resultSet.getString("PCC_FLEX_11"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_12(resultSet.getString("PCC_FLEX_12"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_13(resultSet.getString("PCC_FLEX_13"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_14(resultSet.getString("PCC_FLEX_14"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_15(resultSet.getString("PCC_FLEX_15"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_16(resultSet.getString("PCC_FLEX_16"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_17(resultSet.getString("PCC_FLEX_17"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_18(resultSet.getString("PCC_FLEX_18"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_19(resultSet.getString("PCC_FLEX_19"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_20(resultSet.getString("PCC_FLEX_20"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_21(resultSet.getString("PCC_FLEX_21"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_22(resultSet.getString("PCC_FLEX_22"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_23(resultSet.getString("PCC_FLEX_23"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_24(resultSet.getString("PCC_FLEX_24"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_25(resultSet.getString("PCC_FLEX_25"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_26(resultSet.getString("PCC_FLEX_26"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_27(resultSet.getString("PCC_FLEX_27"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_28(resultSet.getString("PCC_FLEX_28"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_29(resultSet.getString("PCC_FLEX_29"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_30(resultSet.getString("PCC_FLEX_30"));*/
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_PREM_TOPUP_FLAG(resultSet.getString("PCC_PREM_TOPUP_FLAG"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_POL_YR_FM(resultSet.getInt("PCC_POL_YR_FM"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_POL_YR_TO(resultSet.getInt("PCC_POL_YR_TO"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_MODE_OF_PYMT(resultSet.getString("PCC_MODE_OF_PYMT"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_EFF_FM_DT(resultSet.getDate("PCC_EFF_FM_DT"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_EFF_TO_DT(resultSet.getDate("PCC_EFF_TO_DT"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_SR_NO(resultSet.getInt("PCC_SR_NO"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_APPLIED_ON(resultSet.getString("PCC_APPLIED_ON"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_SRC_OF_BUS(resultSet.getString("PCC_SRC_OF_BUS"));
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_TYPE(resultSet.getString("PCC_TYPE"));
				
				
				/*added by raja on 19-04-2017*/
				if(PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CHRG_CODE()!=null)
				{
					list = new DBProcedures().P_VAL_CODES("IL_CHARGE",
							PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CHRG_CODE(), null,
							"N", "N", null);
					if (list != null && list.size() > 0) {
						PM_IL_PROD_CONTRI_CHARGE_BEAN.setUI_M_PCC_CHRG_CODE_DESC(list
								.get(0));
					}
				}
				/*end*/

				/*Added by Janani on 06.06.2017 for Fund allocation issue(204) as per Siva's suggestion*/
				
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CUST_SHARE_PERC(resultSet.getDouble("PCC_CUST_SHARE_PERC"));	
				
				/*End*/
				
				/*Added by saritha on 17.04.2018 for KIC Need to introduce policy fee for GOLDA. 0.2% of initial face amount with max cap of KD 200*/
				
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_APPLY_PERIOD(resultSet.getString("PCC_APPLY_PERIOD"));
				
				/*End*/
				
				compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().
				getDataList_PM_IL_PROD_CONTRI_CHARGE().add(
						PM_IL_PROD_CONTRI_CHARGE_BEAN);
			}
				List<PM_IL_PROD_CONTRI_CHARGE> dataList=compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getDataList_PM_IL_PROD_CONTRI_CHARGE();
				if (dataList != null && dataList.size() > 0) {
					PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN = dataList
							.get(0);
					PM_IL_PROD_CONTRI_CHARGE_BEAN.setRowSelected(true);
					compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN()
							.setPM_IL_PROD_CONTRI_CHARGE_BEAN(
									PM_IL_PROD_CONTRI_CHARGE_BEAN);
				}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

	}
	

	public void IL_UNIQUE_CONTRI_CHARGE_CODE(
			PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN)
			throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String M_CHARGE_CODE = null;
		String CURSOR_2 = "SELECT 'X'  FROM   PM_IL_PROD_CONTRI_CHARGE  WHERE  "
				+ " PCC_CHRG_CODE = ? "
				+ "      AND    PCC_PREM_TOPUP_FLAG = ? "
				+ "      AND    (   (?  BETWEEN PCC_CON_LMT_FM"
				+ "    AND PCC_CON_LMT_TO            ) "
				+ "        OR (?  BETWEEN PCC_CON_LMT_FM "
				+ "      AND PCC_CON_LMT_TO ) OR (PCC_CON_LMT_FM BETWEEN ?  "
				+ "        AND ?  ) "
				+ "  OR (PCC_CON_LMT_TO BETWEEN ? "
				+ "    AND ?  ) )"
				+ "  AND    (   (?  BETWEEN PCC_POL_YR_FM "
				+ " AND PCC_POL_YR_TO            )        "
				+ "  OR (? BETWEEN PCC_POL_YR_FM "
				+ "       AND PCC_POL_YR_TO   )       "
				+ "  OR (PCC_POL_YR_FM BETWEEN ?  "
				+ "  AND ?  )"
				+ " OR (PCC_POL_YR_TO BETWEEN ?  "
				+ "  AND ?       )   ) "
				+ "    AND    PCC_PROD_CODE = ? "
				+ "    AND    PCC_MODE_OF_PYMT = ?  "
				+ "      AND    ROWID           <> ? ";

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler()
					.executeSelectStatement(CURSOR_2, connection,
							new Object[] {
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_CHRG_CODE(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_PREM_TOPUP_FLAG(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_CON_LMT_FM(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_CON_LMT_TO(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_CON_LMT_FM(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_CON_LMT_TO(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_CON_LMT_FM(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_CON_LMT_TO(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_POL_YR_FM(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_POL_YR_TO(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_POL_YR_FM(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_POL_YR_TO(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_POL_YR_FM(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_POL_YR_TO(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_PROD_CODE(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN
											.getPCC_MODE_OF_PYMT(),
									PM_IL_PROD_CONTRI_CHARGE_BEAN.getROWID() });
			if (resultSet.next()) {
				M_CHARGE_CODE = resultSet.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60018"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void preInsert(PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN,PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			IL_UNIQUE_CONTRI_CHARGE_CODE(PM_IL_PROD_CONTRI_CHARGE_BEAN);
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void preUpdate(PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN)
			throws Exception {
		try {
			IL_UNIQUE_CONTRI_CHARGE_CODE(PM_IL_PROD_CONTRI_CHARGE_BEAN);
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_UPD_UID(CommonUtils
					.getControlBean().getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	

	public void whenCreateRecord(
			PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN) {
		PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CHRG_TYPE("P");
		PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_PREM_TOPUP_FLAG("P");
		PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_MODE_OF_PYMT("M");
	}

	public void postQuery(PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN)
			throws Exception {
		ArrayList<String> list = null;
		try {
			list = new DBProcedures().P_VAL_CODES("IL_CHARGE",
					PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CHRG_CODE(), null,
					"N", "N", null);
			if (list != null && list.size() > 0) {
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setUI_M_PCC_CHRG_CODE_DESC(list
						.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenNewRecordInstance(
			PM_IL_PROD_CONTRI_CHARGE_ACTION chargeAction) {
		PM_IL_PROD_CONTRI_CHARGE chargeBean = chargeAction
				.getPM_IL_PROD_CONTRI_CHARGE_BEAN();
		if ("F".equals(chargeBean.getPCC_CHRG_TYPE())) {
			//chargeAction.getCOMP_PCC_RATE().setDisabled(true);
			chargeBean.setPCC_RATE_PER(1.00);
			///chargeAction.getCOMP_PCC_RATE_PER().setDisabled(true);
			if (chargeAction.getCOMP_PCC_FIXED_AMT().isDisabled()) {
				chargeAction.getCOMP_PCC_FIXED_AMT().setDisabled(false);

			}
		}/* else {
			if (chargeAction.getCOMP_PCC_RATE().isDisabled()) {
				chargeAction.getCOMP_PCC_RATE().setDisabled(false);
			}
			chargeAction.getCOMP_PCC_FIXED_AMT().setDisabled(true);
		}
		if (!"F".equals(chargeBean.getPCC_CHRG_TYPE())
				&& chargeBean.getPCC_RATE_PER() == null) {
			if (chargeAction.getCOMP_PCC_RATE_PER().isDisabled()) {
				chargeAction.getCOMP_PCC_RATE_PER().setDisabled(false);
			}
		} else {
			//chargeAction.getCOMP_PCC_RATE_PER().setDisabled(true);
		}*/
	}

	public void whenValidatePCC_CHRG_CODE(String cahrgeCode,
			PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN)
			throws Exception {
		ArrayList<String> list = null;
		try {
			if (cahrgeCode != null) {
				list = new DBProcedures().P_VAL_CODES("IL_CHARGE",
						PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CHRG_CODE(), null,
						"N", "E", null);
				if (list != null && list.size() > 0) {
					PM_IL_PROD_CONTRI_CHARGE_BEAN
							.setUI_M_PCC_CHRG_CODE_DESC(list.get(0));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void whenValidatePCC_SRC_OF_BUS(String srcCode,
			PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN)
			throws Exception {
		ArrayList<String> list = null;
		try {
			if (srcCode != null) {
				list = new DBProcedures().P_VAL_CODES("SRC_BUS_TY",
						PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_SRC_OF_BUS(), null,
						"N", "E", null);
				if (list != null && list.size() > 0) {
					PM_IL_PROD_CONTRI_CHARGE_BEAN
							.setUI_M_PROD_SRC_OF_BUS_DESC((list.get(0)));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenValidateFormulaCode(String formulaCode,
			PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN)
	throws Exception {
		//ArrayList<String> list = null;
		String query = "SELECT FRM_DESC FROM PM_IL_FORMULA WHERE FRM_CODE LIKE ?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String frmCodeDesc=null;
		try {
			con=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(query, con,new Object[]{formulaCode});
			if(rs.next())
			{
		
				frmCodeDesc=rs.getString(1);
			}
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setUI_M_FORMULA_CODE_DESC(frmCodeDesc);
			/*if (formulaCode != null) {
				list = new DBProcedures().P_VAL_CODES("SRC_BUS_TY",
						PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_FLEX_01(), null,
						"N", "E", null);
				if (list != null && list.size() > 0) {
					PM_IL_PROD_CONTRI_CHARGE_BEAN
							.setUI_M_FORMULA_CODE_DESC((list.get(0)));
				}
			}*/

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public void whenValidateAPPLIED_ON(String appliedOn,PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		if("F".equalsIgnoreCase(compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getPM_IL_PROD_CONTRI_CHARGE_BEAN().getPCC_APPLIED_ON()))
		{
			compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getCOMP_PCC_FLEX_01().setDisabled(false);
			compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getPM_IL_PROD_CONTRI_CHARGE_BEAN().setPCC_RATE(1.0);
			compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getPM_IL_PROD_CONTRI_CHARGE_BEAN().setPCC_RATE_PER(1.0);
			compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getCOMP_PCC_RATE().setDisabled(true);
			compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getCOMP_PCC_RATE_PER().setDisabled(true);
			
		}
		else
		{
			compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getCOMP_PCC_RATE().setDisabled(false);
			compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getCOMP_PCC_RATE_PER().setDisabled(false);
			
			compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getCOMP_PCC_FLEX_01().setDisabled(true);
		}
		if("I".equalsIgnoreCase(compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getPM_IL_PROD_CONTRI_CHARGE_BEAN().getPCC_APPLIED_ON()))
		{
			compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getCOMP_PCC_FIXED_AMT().setDisabled(false);
		}
		else
		{
			compositeAction.getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN().getCOMP_PCC_FIXED_AMT().setDisabled(true);
		}
	}
	public void whenValidatePCC_CON_LMT_FM(Double PCC_CON_LMT_FM,
			PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN)
			throws Exception {
		try {
			if (PCC_CON_LMT_FM != null) {
				if (PCC_CON_LMT_FM < 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "46000005",
							new Object[] { "Withdrawal Limit From", ">= 0!" }));
				}
			}
			if (PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CON_LMT_TO() != null) {
				if (PCC_CON_LMT_FM > PM_IL_PROD_CONTRI_CHARGE_BEAN
						.getPCC_CON_LMT_TO()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "46000005",
							new Object[] { "Withdrawal Limit From",
									"<= Withdrawal Limit To amount!" }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenValidatePCC_CON_LMT_TO(Double PCC_CON_LMT_TO,
			PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN)
			throws Exception {
		try {
			if (PCC_CON_LMT_TO != null) {
				if (PCC_CON_LMT_TO < 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "46000005",
							new Object[] { "Withdrawal Limit To", ">= 0!" }));
				}
			}
			if (PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CON_LMT_FM() != null) {
				if (PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CON_LMT_FM() > PCC_CON_LMT_TO) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "46000005",
							new Object[] { "Withdrawal Limit From",
									">= Withdrawal Limit From amount!" }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenValidatePCC_CHRG_TYPE(
			PM_IL_PROD_CONTRI_CHARGE_ACTION chargeAction) {
		PM_IL_PROD_CONTRI_CHARGE chargeBean = chargeAction
				.getPM_IL_PROD_CONTRI_CHARGE_BEAN();
		if ("F".equals(chargeBean.getPCC_CHRG_TYPE())) {
			//chargeBean.setPCC_RATE(null);
			chargeBean.setPCC_RATE_PER(1.00);
			//chargeAction.getCOMP_PCC_RATE().setDisabled(true);
			//chargeAction.getCOMP_PCC_RATE_PER().setDisabled(true);
			chargeAction.getCOMP_PCC_FIXED_AMT().setDisabled(false);
			chargeAction.getCOMP_PCC_RATE_PER().resetValue();
		} else if ("P".equals(chargeBean.getPCC_CHRG_TYPE())) {
			//chargeBean.setPCC_FIXED_AMT(null);
			chargeAction.getCOMP_PCC_RATE_PER().setDisabled(false);
			//chargeBean.setPCC_RATE_PER(100.0);
			chargeAction.getCOMP_PCC_RATE().setDisabled(false);
			//chargeAction.getCOMP_PCC_RATE_PER().setDisabled(true);
		} else {
			//chargeBean.setPCC_FIXED_AMT(null);
			chargeAction.getCOMP_PCC_RATE_PER().setDisabled(false);
			//chargeBean.setPCC_RATE_PER(100.0);
			chargeAction.getCOMP_PCC_RATE().setDisabled(false);
			//chargeAction.getCOMP_PCC_RATE_PER().setDisabled(true);
		}
	}

	public void whenValidatePCC_RATE(
			PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN)
			throws Exception {
		try {
			if (PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_RATE() != null
					&& PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_RATE() < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "93120"));
			}
			if ("P".equals(PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CHRG_TYPE())
					&& PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_RATE() != null
					&& PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_RATE() > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Rate", "<=", "100" }));
			}
			if ("M".equals(PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CHRG_TYPE())
					&& PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_RATE() != null
					&& PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_RATE() > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Rate", "<=", "1000" }));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	
	/*Added by Janani on 06.06.2017 for Fund allocation issue(204) as per Siva's suggestion*/
	
	public void whenValidatePCC_CUST_SHARE_PERC(PM_IL_PROD_CONTRI_CHARGE_ACTION PM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN,
			PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN) throws Exception
	{
		System.out.println("Enters into whenValidatePCC_CUST_SHARE_PERC");
		
		
		Double UI_M_SUM_PCC_CUST_SHARE_PERC = 0.0 ;
		try
		{
			
			System.out.println("getPCC_CUST_SHARE_PERC in start              "+PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CUST_SHARE_PERC());
			
			
		if(PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CUST_SHARE_PERC()>100)
		{
			
			System.out.println("share % > 100");
			
			throw new Exception("Share percentage should be less than 100");
		}
		
	
		/*if (PM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN.getDataList_PM_IL_PROD_CONTRI_CHARGE().size()!= 0) {
			//Added to check share Ratio percentage during save
			for(PM_IL_PROD_CONTRI_CHARGE  obj: PM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN.getDataList_PM_IL_PROD_CONTRI_CHARGE()) {
				if(obj.getPCC_SR_NO()==1 && !(obj.getROWID().equalsIgnoreCase(PM_IL_PROD_CONTRI_CHARGE_BEAN.getROWID()))){
					Double value=CommonUtils.nvl(obj.getPCC_CUST_SHARE_PERC(), 0);
					
					System.out.println("value           :"+value);
					
					UI_M_SUM_PCC_CUST_SHARE_PERC = UI_M_SUM_PCC_CUST_SHARE_PERC +value;
				}
			}
			
			System.out.println("UI_M_SUM_PCC_CUST_SHARE_PERC           :"+UI_M_SUM_PCC_CUST_SHARE_PERC);
			
			if(UI_M_SUM_PCC_CUST_SHARE_PERC != null){
				
				
				if (UI_M_SUM_PCC_CUST_SHARE_PERC+PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CUST_SHARE_PERC()>100){
					throw new Exception("Total Share Ratio % Should be 100%");
				}
			}
		}*/
		
		if (PM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN.getDataList_PM_IL_PROD_CONTRI_CHARGE().size()!= 0) {
			
                if(PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CUST_SHARE_PERC() != null){
				
				
				if (PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CUST_SHARE_PERC()>100){
					throw new Exception("Total Share Ratio % Should be 100%");
				}
			}
			
		}
		
		
		System.out.println("getPCC_CUST_SHARE_PERC               "+PM_IL_PROD_CONTRI_CHARGE_BEAN.getPCC_CUST_SHARE_PERC());
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/*End*/
	
}
