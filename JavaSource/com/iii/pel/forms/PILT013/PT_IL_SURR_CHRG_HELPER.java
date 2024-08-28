package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_SURR_CHRG_HELPER {

	PILT013_PROCS_HELPER pilt013_procs_helper = new PILT013_PROCS_HELPER();
	PCOPK_GENERAL pcopk_general = new PCOPK_GENERAL();
	CRUDHandler handler = new CRUDHandler();

	
	/*Added  by Janani on 14.07.2017 for ZBILQC-1724475*/
	Double UI_M_SUM_FC_CHG = 0.0 ;
	/*End*/
	
	
	public void SRC_RATE_PER_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		PT_IL_SURR_CHRG pt_il_surr_chrg_bean = compositeAction
				.getPT_IL_SURR_CHRG_ACTION_BEAN().getPT_IL_SURR_CHRG_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		Double M_WCS_MIN_VALUE = null;
		Double M_WCS_MAX_VALUE = null;
		Connection con = null;
		ResultSet rs1 = null;
		
		
		try {
			con = CommonUtils.getConnection();
			if (pt_il_surr_chrg_bean.getSRC_RATE_PER() <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}

			Object[] rsObj1 = new Object[2];
			rsObj1[0] = pt_il_surr_chrg_bean.getSRC_CHRG_CODE();
			rsObj1[1] = pt_il_policy_bean.getPOL_PROD_CODE();

			rs1 = handler
					.executeSelectStatement(
							PILT013_QUERYCONSTANTS.SRC_RATE_PER$WHEN_VALIDATE_ITEM_CURSOR_QRY_1,
							con, rsObj1);
			while (rs1.next()) {
				M_WCS_MIN_VALUE = rs1.getDouble(1);
				M_WCS_MAX_VALUE = rs1.getDouble(2);
			}

			pt_il_surr_chrg_bean
					.setSRC_SMV_LC_VALUE((pt_il_surr_mat_values_bean
							.getSMV_FC_GROSS_VALUE() * CommonUtils.nvl(
							pt_il_surr_chrg_bean.getSRC_RATE(), 1))
							/ CommonUtils.nvl(pt_il_surr_chrg_bean
									.getSRC_RATE_PER(), 1));
			pt_il_surr_chrg_bean.setSRC_SMV_FC_VALUE(pt_il_surr_chrg_bean
					.getSRC_SMV_LC_VALUE()
					/ CommonUtils.nvl(
							pt_il_policy_bean.getPOL_CUST_EXCH_RATE(), 1));
			
			
			
/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/
			
			/*ArrayList<OracleParameter> outList = pcopk_general.P_VAL_ROUND_AMT(
					pt_il_policy_bean.getPOL_SA_CURR_CODE(),"",
					"R", null, null);*/
			
			
			ArrayList<OracleParameter> outList = pcopk_general.P_VAL_ROUND_AMT(
					pt_il_policy_bean.getPOL_SA_CURR_CODE(), Double.toString(pt_il_surr_chrg_bean.getSRC_SMV_FC_VALUE()),
					"R", null, null);
			
			/*End*/
			
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_chrg_bean.setSRC_SMV_FC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}
			outList.clear();

			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/
			
			/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), "", "R", null, null);*/
			
			outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), Double.toString(pt_il_surr_chrg_bean.getSRC_SMV_LC_VALUE()), "R", null, null);
			
			/*End*/
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_chrg_bean.setSRC_SMV_LC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}
			outList.clear();
			pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(((pt_il_surr_chrg_bean.getSRC_SMV_LC_VALUE() * CommonUtils.nvl(
					pt_il_surr_chrg_bean.getSRC_CUST_SHARE_PERC(), 1)) / 100));
			if (pt_il_surr_chrg_bean.getSRC_CHG_LC_VALUE() < CommonUtils.nvl(M_WCS_MIN_VALUE,0)) {
				pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(M_WCS_MIN_VALUE);
			}
			if (pt_il_surr_chrg_bean.getSRC_CHG_LC_VALUE() > CommonUtils.nvl(M_WCS_MAX_VALUE,0)) {
				pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(M_WCS_MAX_VALUE);
			}
			pt_il_surr_chrg_bean.setSRC_CHG_FC_VALUE(pt_il_surr_chrg_bean
					.getSRC_CHG_LC_VALUE()
					/ CommonUtils.nvl(
							pt_il_policy_bean.getPOL_CUST_EXCH_RATE(), 1));
			
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), "", "R", null, null);*/
			
			outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), Double.toString(pt_il_surr_chrg_bean.getSRC_CHG_FC_VALUE()), "R", null, null);
			
			
			/*End*/
			
			
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_chrg_bean.setSRC_CHG_FC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}
			outList.clear();
			
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), "", "R", null, null);*/
			
			outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), Double.toString(pt_il_surr_chrg_bean.getSRC_CHG_LC_VALUE()), "R", null, null);
			
			
			/*End*/
			
			
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}
			outList.clear();
			
			
			System.out.println("getSRC_CHG_SUM_FC             "+pt_il_surr_chrg_bean.getSRC_CHG_SUM_FC());
			

			pt_il_surr_mat_values_bean
					.setSMV_LC_CHARGE_AMT(pt_il_surr_chrg_bean.getSRC_SUM_CHG());
			pt_il_surr_mat_values_bean
					.setSMV_FC_CHARGE_AMT(pt_il_surr_chrg_bean
							.getSRC_CHG_SUM_FC());
			
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(),
					"", "R", null, null);*/
			
			outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(),
					Double.toString(pt_il_surr_mat_values_bean.getSMV_FC_CHARGE_AMT()), "R", null, null);
			
			
			/*End*/

			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_mat_values_bean.setSMV_FC_CHARGE_AMT(s!=null?Double.parseDouble(s):0.0);
			}
			outList.clear();
			
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(),
					"", "R", null, null);*/
			
			
			outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(),
					Double.toString(pt_il_surr_mat_values_bean.getSMV_LC_CHARGE_AMT()), "R", null, null);
			
			/*End*/
			
			
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_mat_values_bean.setSMV_LC_CHARGE_AMT(s!=null?Double.parseDouble(s):0.0);
			}
			outList.clear();
			pilt013_procs_helper.L_POP_SMV_PAID_AMT(compositeAction, currValue);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}
	
	
	public void preInsert(PT_IL_SURR_MAT_VALUES maturityBean,PT_IL_SURR_CHRG chargesBean) throws Exception {
		String SEQUENCE_QUERY = "SELECT P_SRC_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet resultSet = null;
		try {
			resultSet = new CRUDHandler().executeSelectStatement(SEQUENCE_QUERY, CommonUtils.getConnection());
			if (resultSet.next()) {
				chargesBean.setSRC_SYS_ID(resultSet.getLong(1));
			}
			chargesBean.setSRC_SMV_SYS_ID(maturityBean.getSMV_SYS_ID());
			chargesBean.setSRC_CR_DT(new CommonUtils().getCurrentDate());
			chargesBean.setSRC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage()); 
		}finally {try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}};
	}

	public void SRC_RATE_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		PT_IL_SURR_CHRG pt_il_surr_chrg_bean = compositeAction
				.getPT_IL_SURR_CHRG_ACTION_BEAN().getPT_IL_SURR_CHRG_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection con = null;
		Double M_WCS_MIN_VALUE = null;
		Double M_WCS_MAX_VALUE = null;
		ResultSet rs1 = null;
		try {
			con = CommonUtils.getConnection();
			
			if (pt_il_surr_chrg_bean.getSRC_RATE_PER() != null && pt_il_surr_chrg_bean.getSRC_RATE_PER() <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}

			Object[] rsObj1 = new Object[2];
			rsObj1[0] = pt_il_surr_chrg_bean.getSRC_CHRG_CODE();
			rsObj1[1] = pt_il_policy_bean.getPOL_PROD_CODE();

			rs1 = handler
					.executeSelectStatement(
							PILT013_QUERYCONSTANTS.SRC_RATE$WHEN_VALIDATE_ITEM_CURSOR_QRY_1,
							con, rsObj1);
			while (rs1.next()) {
				M_WCS_MIN_VALUE = rs1.getDouble(1);
				M_WCS_MAX_VALUE = rs1.getDouble(2);
			}

			pt_il_surr_chrg_bean
					.setSRC_SMV_LC_VALUE((pt_il_surr_mat_values_bean
							.getSMV_FC_GROSS_VALUE() * CommonUtils.nvl(
							(Double) currValue, 1))
							/ CommonUtils.nvl(pt_il_surr_chrg_bean
									.getSRC_RATE_PER(), 1));
			pt_il_surr_chrg_bean.setSRC_SMV_FC_VALUE(pt_il_surr_chrg_bean
					.getSRC_SMV_LC_VALUE()
					/ CommonUtils.nvl(
							pt_il_policy_bean.getPOL_CUST_EXCH_RATE(), 1));

			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/
			
			/*ArrayList<OracleParameter> outList = pcopk_general.P_VAL_ROUND_AMT(
					pt_il_policy_bean.getPOL_SA_CURR_CODE(),"",
					"R", null, null);*/
			
			
			ArrayList<OracleParameter> outList = pcopk_general.P_VAL_ROUND_AMT(
					pt_il_policy_bean.getPOL_SA_CURR_CODE(),Double.toString(pt_il_surr_chrg_bean.getSRC_SMV_FC_VALUE()),
					"R", null, null);
			
			/*eND*/
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_chrg_bean.setSRC_SMV_FC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/
			
			/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), "", "R", null, null);*/
			
			outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), Double.toString(pt_il_surr_chrg_bean.getSRC_SMV_LC_VALUE()) , "R", null, null);
			
			/*End*/
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_chrg_bean.setSRC_SMV_LC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();

			pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(((pt_il_surr_chrg_bean
					.getSRC_SMV_LC_VALUE() * CommonUtils.nvl(
					pt_il_surr_chrg_bean.getSRC_CUST_SHARE_PERC(), 1)) / 100));
			
			if (pt_il_surr_chrg_bean.getSRC_CHG_LC_VALUE() < CommonUtils.nvl(M_WCS_MIN_VALUE,0)) {
				pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(M_WCS_MIN_VALUE);
			}
			if (pt_il_surr_chrg_bean.getSRC_CHG_LC_VALUE() > CommonUtils.nvl(M_WCS_MAX_VALUE,0)) {
				pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(M_WCS_MAX_VALUE);
			}
			pt_il_surr_chrg_bean.setSRC_CHG_FC_VALUE(pt_il_surr_chrg_bean
					.getSRC_CHG_LC_VALUE()
					/ CommonUtils.nvl(
							pt_il_policy_bean.getPOL_CUST_EXCH_RATE(), 1));
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/
			
			
			/*outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), "", "R", null, null);*/
			
			outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), Double.toString(pt_il_surr_chrg_bean.getSRC_CHG_FC_VALUE()), "R", null, null);
			
			/*End*/
			
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				System.out.println("round value            "+s);
				pt_il_surr_chrg_bean.setSRC_CHG_FC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();
			
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), "", "R", null, null);*/
			
			outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), Double.toString(pt_il_surr_chrg_bean.getSRC_CHG_LC_VALUE()), "R", null, null);
			
			/*End*/
			
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();

			
			
			pt_il_surr_mat_values_bean
			.setSMV_LC_CHARGE_AMT(pt_il_surr_chrg_bean.getSRC_SUM_CHG());
			pt_il_surr_mat_values_bean
			.setSMV_FC_CHARGE_AMT(pt_il_surr_chrg_bean
					.getSRC_CHG_SUM_FC());

			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
			.getPOL_SA_CURR_CODE(),
			"", "R", null, null);*/

			outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), Double.toString(pt_il_surr_mat_values_bean.getSMV_FC_CHARGE_AMT()), "R", null, null);
			/*End*/

			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();

				System.out.println("round value  3          "+s);
				pt_il_surr_mat_values_bean.setSMV_FC_CHARGE_AMT(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();


			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
			.getUI_M_BASE_CURR(),
			"", "R", null, null);*/


			outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), Double.toString(pt_il_surr_mat_values_bean.getSMV_LC_CHARGE_AMT()), "R", null, null);


			/*End*/

			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();

				System.out.println("round value 4           "+s);

				pt_il_surr_mat_values_bean.setSMV_LC_CHARGE_AMT(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();
			
			pilt013_procs_helper.L_POP_SMV_PAID_AMT(compositeAction, currValue);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void SRC_CUST_SHARE_PERC_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		PT_IL_SURR_CHRG pt_il_surr_chrg_bean = compositeAction
				.getPT_IL_SURR_CHRG_ACTION_BEAN().getPT_IL_SURR_CHRG_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Double M_WCS_MIN_VALUE = null;
		Double M_WCS_MAX_VALUE = null;
		ResultSet rs1 = null;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			if (pt_il_surr_chrg_bean.getSRC_RATE_PER() <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}

			Object[] rsObj1 = new Object[2];
			rsObj1[0] = pt_il_surr_chrg_bean.getSRC_CHRG_CODE();
			rsObj1[1] = pt_il_policy_bean.getPOL_PROD_CODE();

			rs1 = handler
					.executeSelectStatement(
							PILT013_QUERYCONSTANTS.SRC_CUST_SHARE_PERC$WHEN_VALIDATE_ITEM_CURSOR_QRY_1,
							con, rsObj1);
			while (rs1.next()) {
				M_WCS_MIN_VALUE = rs1.getDouble(1);
				M_WCS_MAX_VALUE = rs1.getDouble(2);
			}

			pt_il_surr_chrg_bean
					.setSRC_SMV_LC_VALUE((pt_il_surr_mat_values_bean
							.getSMV_FC_GROSS_VALUE() * CommonUtils.nvl(
							pt_il_surr_chrg_bean.getSRC_RATE(), 1))
							/ CommonUtils.nvl(pt_il_surr_chrg_bean
									.getSRC_RATE_PER(), 1));
			pt_il_surr_chrg_bean.setSRC_SMV_FC_VALUE(pt_il_surr_chrg_bean
					.getSRC_SMV_LC_VALUE()
					/ CommonUtils.nvl(
							pt_il_policy_bean.getPOL_CUST_EXCH_RATE(), 1));
		
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*ArrayList<OracleParameter> outList = pcopk_general.P_VAL_ROUND_AMT(
					pt_il_policy_bean.getPOL_SA_CURR_CODE(),"",
					"R", null, null);*/
			
		
			ArrayList<OracleParameter> outList = pcopk_general.P_VAL_ROUND_AMT(
					pt_il_policy_bean.getPOL_SA_CURR_CODE(), Double.toString(pt_il_surr_chrg_bean.getSRC_SMV_FC_VALUE()),
					"R", null, null);
			
			
			/*End*/
			
			
			
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_chrg_bean.setSRC_SMV_FC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();

			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), "", "R", null, null);*/
			
			
			outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), Double.toString(pt_il_surr_chrg_bean.getSRC_SMV_LC_VALUE()), "R", null, null);
		
			
			/*End*/
			
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_chrg_bean.setSRC_SMV_LC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();

			pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(((pt_il_surr_chrg_bean
					.getSRC_SMV_LC_VALUE() * CommonUtils.nvl(
					pt_il_surr_chrg_bean.getSRC_CUST_SHARE_PERC(), 1)) / 100));
			if (pt_il_surr_chrg_bean.getSRC_CHG_LC_VALUE() < CommonUtils.nvl(M_WCS_MIN_VALUE,0)) {
				pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(M_WCS_MIN_VALUE);
			}
			if (pt_il_surr_chrg_bean.getSRC_CHG_LC_VALUE() > CommonUtils.nvl(M_WCS_MAX_VALUE,0)) {
				pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(M_WCS_MAX_VALUE);
			}
			pt_il_surr_chrg_bean.setSRC_CHG_FC_VALUE(pt_il_surr_chrg_bean
					.getSRC_CHG_LC_VALUE()
					/ CommonUtils.nvl(
							pt_il_policy_bean.getPOL_CUST_EXCH_RATE(), 1));
			
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), "", "R", null, null);*/
			
		
			outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), Double.toString(pt_il_surr_chrg_bean.getSRC_CHG_FC_VALUE()), "R", null, null);
			
			
			/*End*/
			
			
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_chrg_bean.setSRC_CHG_FC_VALUE(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();
			outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), "", "R", null, null);
			
			pt_il_surr_mat_values_bean
					.setSMV_LC_CHARGE_AMT(pt_il_surr_chrg_bean.getSRC_SUM_CHG());
			pt_il_surr_mat_values_bean
					.setSMV_FC_CHARGE_AMT(pt_il_surr_chrg_bean
							.getSRC_CHG_SUM_FC());
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(),"", "R", null, null);*/
			
			
			outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
					.getPOL_SA_CURR_CODE(), Double.toString(pt_il_surr_mat_values_bean.getSMV_FC_CHARGE_AMT()), "R", null, null);
			
			/*End*/
			
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_mat_values_bean.setSMV_FC_CHARGE_AMT(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();

			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

			/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(),"", "R", null, null);*/
			
			
			outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
					.getUI_M_BASE_CURR(), Double.toString(pt_il_surr_mat_values_bean.getSMV_LC_CHARGE_AMT()), "R", null, null);
			
			
			/*End*/
			
			if (outList != null && outList.size() > 0) {
				String s =outList.get(0).getValue();
				pt_il_surr_mat_values_bean.setSMV_LC_CHARGE_AMT(s!=null?Double.parseDouble(s):0.0);
			}

			outList.clear();

			pilt013_procs_helper.L_POP_SMV_PAID_AMT(compositeAction, currValue);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		PT_IL_SURR_CHRG pt_il_surr_chrg_bean = compositeAction
				.getPT_IL_SURR_CHRG_ACTION_BEAN().getPT_IL_SURR_CHRG_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			if (!CommonUtils.nvl(
					pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(), "N")
					.equals("A")
					&& "S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) {
				pt_il_surr_mat_values_bean
						.setSMV_LC_CHARGE_AMT(pt_il_surr_chrg_bean
								.getSRC_SUM_CHG());
				pt_il_surr_mat_values_bean
						.setSMV_FC_CHARGE_AMT(pt_il_surr_chrg_bean
								.getSRC_CHG_SUM_FC());
			}

		
			/*Modified  by Janani on 17.07.2017 for ZBILQC-1724475*/
			
			/*if (CommonUtils.nvl(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(),
					"N").equals("A")
					&& "S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) */
			
			if (!CommonUtils.nvl(pt_il_surr_mat_values_bean.getSMV_APPRV_FLAG(),
					"N").equals("A")
					&& "S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())) 
			
				/*End*/
				
			{
				pilt013_procs_helper.L_POP_SMV_PAID_AMT(compositeAction,
						pt_il_surr_mat_values_bean.getSMV_FC_NET_PAID_AMT());

				
				/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

				/*ArrayList<OracleParameter> outList = pcopk_general
						.P_VAL_ROUND_AMT(pt_il_policy_bean
								.getPOL_SA_CURR_CODE(), "", "R", null,
								null);*/
				
				ArrayList<OracleParameter> outList = pcopk_general
						.P_VAL_ROUND_AMT(pt_il_policy_bean
								.getPOL_SA_CURR_CODE(), Double.toString(pt_il_surr_chrg_bean.getSRC_SMV_FC_VALUE()), "R", null,
								null);
				
				/*End*/
				
				
				if (outList != null && outList.size() > 0) {
					String s =outList.get(0).getValue();
					pt_il_surr_chrg_bean.setSRC_SMV_FC_VALUE(s!=null?Double.parseDouble(s):0.0);
				}

				outList.clear();
				
				/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

				/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), "",
						"R", null, null);*/
				
				outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), Double.toString(pt_il_surr_chrg_bean.getSRC_SMV_LC_VALUE()),
						"R", null, null);
			
				
				/*End*/
				
				
				
				if (outList != null && outList.size() > 0) {
					String s =outList.get(0).getValue();
					pt_il_surr_chrg_bean.setSRC_SMV_LC_VALUE(s!=null?Double.parseDouble(s):0.0);
				}
				outList.clear();

				

				/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

				/*	outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
						.getPOL_SA_CURR_CODE(), "",
						"R", null, null);*/
				
				
				outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
						.getPOL_SA_CURR_CODE(), Double.toString(pt_il_surr_chrg_bean.getSRC_CHG_FC_VALUE()),
						"R", null, null);
			
				
				/*End*/
				
			
				if (outList != null && outList.size() > 0) {
					String s =outList.get(0).getValue();
					pt_il_surr_chrg_bean.setSRC_CHG_FC_VALUE(s!=null?Double.parseDouble(s):0.0);
				}
				outList.clear();

				
				/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

				/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), "",
						"R", null, null);*/
				
				
				outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), Double.toString(pt_il_surr_chrg_bean.getSRC_CHG_LC_VALUE()),
						"R", null, null);
				
				
				/*End*/
				
				if (outList != null && outList.size() > 0) {
					String s =outList.get(0).getValue();
					pt_il_surr_chrg_bean.setSRC_CHG_LC_VALUE(s!=null?Double.parseDouble(s):0.0);
				}
				outList.clear();
				pt_il_surr_mat_values_bean
						.setSMV_LC_CHARGE_AMT(pt_il_surr_chrg_bean
								.getSRC_SUM_CHG());
				pt_il_surr_mat_values_bean
						.setSMV_FC_CHARGE_AMT(pt_il_surr_chrg_bean
								.getSRC_CHG_SUM_FC());

				
				/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

				/*outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
						.getPOL_SA_CURR_CODE(), "", "R", null, null);*/
				
				
				outList = pcopk_general.P_VAL_ROUND_AMT(pt_il_policy_bean
						.getPOL_SA_CURR_CODE(), Double.toString(pt_il_surr_mat_values_bean.getSMV_FC_CHARGE_AMT()), "R", null, null);
				
				
				/*End*/
				
				
				if (outList != null && outList.size() > 0) {
					String s =outList.get(0).getValue();
					pt_il_surr_mat_values_bean.setSMV_FC_CHARGE_AMT(s!=null?Double.parseDouble(s):0.0);
				}
				outList.clear();
				
				/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/

				/*outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), "", "R", null, null);*/
				
				outList = pcopk_general.P_VAL_ROUND_AMT(dummy_bean
						.getUI_M_BASE_CURR(), Double.toString(pt_il_surr_mat_values_bean.getSMV_LC_CHARGE_AMT()), "R", null, null);
				
				/*End*/
				
				
				
				if (outList != null && outList.size() > 0) {
					String s =outList.get(0).getValue();
					pt_il_surr_mat_values_bean.setSMV_LC_CHARGE_AMT(s!=null?Double.parseDouble(s):0.0);
				}

				outList.clear();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void POST_QUERY(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Connection con = null;
		try {
			compositeAction.getPT_IL_SURR_CHRG_ACTION_BEAN()
					.getCOMP_SRC_CHG_LC_VALUE().setDisabled(true);
			compositeAction.getPT_IL_SURR_CHRG_ACTION_BEAN()
					.getCOMP_SRC_CHG_FC_VALUE().setDisabled(true);
			compositeAction.getPT_IL_SURR_CHRG_ACTION_BEAN()
					.getCOMP_SRC_SMV_LC_VALUE().setDisabled(true);
			compositeAction.getPT_IL_SURR_CHRG_ACTION_BEAN()
					.getCOMP_SRC_SMV_FC_VALUE().setDisabled(true);
			/*Commented by Janani on 13.02.2018 for ZB as per Sivaram's suggs.*/
			
			/*compositeAction.getPT_IL_SURR_CHRG_ACTION_BEAN()
					.getCOMP_SRC_CHRG_CODE().setDisabled(true);*/
			
			/*End*/
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_SURR_CHRG_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_SURR_CHRG> dataList = compositeAction
				.getPT_IL_SURR_CHRG_ACTION_BEAN().getDataList_PT_IL_SURR_CHRG();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_SURR_CHRG PT_IL_SURR_CHRG_BEAN = dataList.get(0);
			PT_IL_SURR_CHRG_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_SURR_CHRG_ACTION_BEAN()
					.setPT_IL_SURR_CHRG_BEAN(PT_IL_SURR_CHRG_BEAN);
		}
	}

}
