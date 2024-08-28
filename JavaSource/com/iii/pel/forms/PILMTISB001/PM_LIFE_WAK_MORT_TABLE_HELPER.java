package com.iii.pel.forms.PILMTISB001;

import com.iii.premia.common.utils.CommonUtils;

public class PM_LIFE_WAK_MORT_TABLE_HELPER {

	PILMTISB001_PROCS_HELPER pilmtisb001_helper = new PILMTISB001_PROCS_HELPER();

	public void WAKM_ANLY_CODE_1_WHEN_VALIDATE_ITEM(
			PILMTISB001_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = compositeAction
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();
		try {
			String desc = null;
			if (currValue != null)
				desc = pilmtisb001_helper.L_GET_ANLY1_DESC((String) currValue);

			pm_life_wak_mort_table_bean.setUI_M_WAKM_ANLY_CODE_1_DESC(desc);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	/**
	 * 
	 * @param compositeAction
	 * @param currValue
	 * @throws Exception
	 */
	public void WAKM_ANLY_CODE_2_WHEN_VALIDATE_ITEM(
			PILMTISB001_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = compositeAction
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();
		String desc = null;
		try {

			if (currValue != null) {
				desc = pilmtisb001_helper.L_GET_ANLY2_DESC((String) currValue);
			}
			pm_life_wak_mort_table_bean.setUI_M_WAKM_ANLY_CODE_2_DESC(desc);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WAKM_COVER_CODE_WHEN_VALIDATE_ITEM(
			PILMTISB001_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = compositeAction
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();
		String desc = null;
		try {
			if (currValue != null) {
				desc = pilmtisb001_helper.L_GET_COVER_DESC((String) currValue);
			}
			pm_life_wak_mort_table_bean.setUI_M_COVER_DESC(desc);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WAKM_PROD_CODE_WHEN_VALIDATE_ITEM(
			PILMTISB001_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = compositeAction
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();
		String desc = null;
		try {
			if (currValue != null) {
				desc = pilmtisb001_helper.L_GET_PROD_DESC((String) currValue);
				pm_life_wak_mort_table_bean.setUI_M_WAKM_PROD_DESC(desc);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WAKM_EXP_CODE_WHEN_VALIDATE_ITEM(
			PILMTISB001_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = compositeAction
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();
		String desc = null;
		try {
			if (currValue != null) {
				desc = pilmtisb001_helper
						.L_GET_EXP_CODE_DESC((String) currValue);
			}
			pm_life_wak_mort_table_bean.setUI_M_EXP_CODE_DESC(desc);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void POST_QUERY(PILMTISB001_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = compositeAction
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();
		String cover_desc = null;
		String mort_code_desc = null;
		String anly_code_1 = null;
		String anly_code_2 = null;
		String exp_code_desc = null;
		String prod_desc = null;
		try {
			cover_desc = pilmtisb001_helper.L_GET_COVER_DESC(pm_life_wak_mort_table_bean
					.getWAKM_COVER_CODE());
			pm_life_wak_mort_table_bean.setUI_M_COVER_DESC(cover_desc);
			mort_code_desc = pilmtisb001_helper.L_GET_MORT_CODE_DESC(pm_life_wak_mort_table_bean
					.getWAKM_MORT_CODE());
			pm_life_wak_mort_table_bean.setUI_M_MORT_CODE_DESC(mort_code_desc);
			if(pm_life_wak_mort_table_bean.getWAKM_ANLY_CODE_1()!=null)
				anly_code_1 = pilmtisb001_helper.L_GET_ANLY1_DESC(pm_life_wak_mort_table_bean
					.getWAKM_ANLY_CODE_1());
			pm_life_wak_mort_table_bean.setUI_M_WAKM_ANLY_CODE_1_DESC(anly_code_1);
			if(pm_life_wak_mort_table_bean.getWAKM_ANLY_CODE_2()!=null)
			anly_code_2=pilmtisb001_helper.L_GET_ANLY2_DESC(pm_life_wak_mort_table_bean
					.getWAKM_ANLY_CODE_2());
			pm_life_wak_mort_table_bean.setUI_M_WAKM_ANLY_CODE_2_DESC(anly_code_2);
			exp_code_desc = pilmtisb001_helper.L_GET_EXP_CODE_DESC(pm_life_wak_mort_table_bean
					.getWAKM_EXP_CODE());
			pm_life_wak_mort_table_bean.setUI_M_EXP_CODE_DESC(exp_code_desc);
			prod_desc = pilmtisb001_helper.L_GET_PROD_DESC(pm_life_wak_mort_table_bean
					.getWAKM_PROD_CODE());
			pm_life_wak_mort_table_bean.setUI_M_WAKM_PROD_DESC(prod_desc);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_INSERT(PILMTISB001_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = compositeAction
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();

		try {
			pm_life_wak_mort_table_bean.setWAKM_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			pm_life_wak_mort_table_bean.setWAKM_CR_DATE(new CommonUtils()
					.getCurrentDate());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_UPDATE(PILMTISB001_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = compositeAction
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();
		try {
			pm_life_wak_mort_table_bean.setWAKM_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			pm_life_wak_mort_table_bean.setWAKM_UPD_DATE(new CommonUtils()
					.getCurrentDate());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WHEN_CREATE_RECORD(PILMTISB001_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = compositeAction
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();
		try {
			pm_life_wak_mort_table_bean.setWAKM_SUBSEQ_YN("N");
			pm_life_wak_mort_table_bean.setWAKM_COVER_PERC(Double.parseDouble("0.0"));
			pm_life_wak_mort_table_bean.setWAKM_SURPRO_PER(Double.parseDouble("0.0"));

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WAKM_MORT_CODE_WHEN_VALIDATE_ITEM(
			PILMTISB001_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_LIFE_WAK_MORT_TABLE pm_life_wak_mort_table_bean = compositeAction
				.getPM_LIFE_WAK_MORT_TABLE_ACTION_BEAN()
				.getPM_LIFE_WAK_MORT_TABLE_BEAN();
		String desc = null;
		try {

			if (currValue != null) {
				desc = pilmtisb001_helper
						.L_GET_MORT_CODE_DESC((String) currValue);
			}
			pm_life_wak_mort_table_bean.setUI_M_MORT_CODE_DESC(desc);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILMTISB001_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_LIFE_WAK_MORT_TABLE_DELEGATE()
				.executeSelectStatement(compositeAction);
	}

}
