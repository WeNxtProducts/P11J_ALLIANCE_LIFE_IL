package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_CLM_REPAY_DTL_HELPER {
	PILM007_PROCS_HELPER pilm007_procs_helper = new PILM007_PROCS_HELPER();
	DBProcedures dbProcedure = new DBProcedures();

	public void executeQuery(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_CLM_REPAY_DTL_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_CLM_REPAY_DTL> dataList = compositeAction
				.getPM_IL_CLM_REPAY_DTL_ACTION_BEAN()
				.getDataList_PM_IL_CLM_REPAY_DTL();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_CLM_REPAY_DTL PM_IL_CLM_REPAY_DTL_BEAN = dataList.get(0);
			PM_IL_CLM_REPAY_DTL_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_CLM_REPAY_DTL_ACTION_BEAN()
					.setPM_IL_CLM_REPAY_DTL_BEAN(PM_IL_CLM_REPAY_DTL_BEAN);
		}
	}

	public void CRD_COVER_CODE_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		
		try {
			PM_IL_CLM_REPAY_DTL pm_il_clm_repay_dtl_bean = compositeAction
					.getPM_IL_CLM_REPAY_DTL_ACTION_BEAN()
					.getPM_IL_CLM_REPAY_DTL_BEAN();
			PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
					.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();

			ArrayList<String> outtList = dbProcedure.callP_VAL_COVER_PROC(
					pm_il_clm_repay_dtl_bean.getCRD_COVER_CODE(), pm_il_clm_repay_dtl_bean
							.getUI_M_COVER_DESC_1(),null, "N", "E");
			if (outtList != null && outtList.size() > 0)
				pm_il_clm_repay_dtl_bean.setUI_M_COVER_DESC_1(outtList.get(0));

//			pm_il_clm_repay_dtl_bean.setCRD_DISABLE_TYPE(pm_il_clm_repay_dtl_bean
//					.getCRD_DISABLE_TYPE());

			if (pm_il_clm_repay_bean.getCR_COVER_CODE().equals(pm_il_clm_repay_dtl_bean.getCRD_COVER_CODE()))
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",new Object[]{"Same Cover Should not be added",pm_il_clm_repay_dtl_bean.getCRD_COVER_CODE()}));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void CRD_LOSS_TYPE_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Connection con = null;
		ArrayList<String> pList = new ArrayList<String>();
		try {
		con = CommonUtils.getConnection();
		PM_IL_CLM_REPAY_DTL pm_il_clm_repay_dtl_bean = compositeAction
				.getPM_IL_CLM_REPAY_DTL_ACTION_BEAN()
				.getPM_IL_CLM_REPAY_DTL_BEAN();
		pList = dbProcedure.P_VAL_CODES(
								"IL_LOS_TYP",
								pm_il_clm_repay_dtl_bean.getCRD_LOSS_TYPE(), 
								pm_il_clm_repay_dtl_bean.getUI_M_LOSS_DESC_1(),
								"N",
								"E",
								null);
		if(!pList.isEmpty() && pList.size() != 0){
			pm_il_clm_repay_dtl_bean.setUI_M_LOSS_DESC_1(pList.get(0));
		}
//		pm_il_clm_repay_dtl_bean.setCRD_DISABLE_TYPE(pm_il_clm_repay_dtl_bean
//										.getCRD_DISABLE_TYPE());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void CRD_DISABLE_TYPE_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Connection con = null;
		PM_IL_CLM_REPAY_DTL pm_il_clm_repay_dtl_bean = compositeAction
				.getPM_IL_CLM_REPAY_DTL_ACTION_BEAN()
				.getPM_IL_CLM_REPAY_DTL_BEAN();
		ArrayList<String> pList = new ArrayList<String>();
		try {
			con = CommonUtils.getConnection();
			pList = dbProcedure.P_VAL_CODES("IL_DIS_TYP",
					pm_il_clm_repay_dtl_bean.getCRD_DISABLE_TYPE(),"N",
					 "E", null);
			if(!pList.isEmpty() && pList.size() != 0){
			pm_il_clm_repay_dtl_bean.setUI_M_DISABLE_DESC_1(pList.get(0));
			}
			pm_il_clm_repay_dtl_bean
					.setCRD_DISABLE_TYPE(pm_il_clm_repay_dtl_bean
							.getCRD_DISABLE_TYPE());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Connection con = null;
		PM_IL_CLM_REPAY_DTL pm_il_clm_repay_dtl_bean = null;
		Iterator<PM_IL_CLM_REPAY_DTL> iterator = compositeAction
				.getPM_IL_CLM_REPAY_DTL_ACTION_BEAN()
				.getDataList_PM_IL_CLM_REPAY_DTL().iterator();
		try {
			con = CommonUtils.getConnection();
			while(iterator.hasNext()){
				pm_il_clm_repay_dtl_bean =(PM_IL_CLM_REPAY_DTL) iterator.next();
			
			ArrayList<String> outtList = dbProcedure.callP_VAL_COVER_PROC(
					pm_il_clm_repay_dtl_bean.getCRD_COVER_CODE(),
					pm_il_clm_repay_dtl_bean.getUI_M_COVER_DESC_1(), "", "N",
					"N");
			if (outtList != null && outtList.size() > 0)
				pm_il_clm_repay_dtl_bean.setUI_M_COVER_DESC_1(outtList.get(0));

			String desc = pilm007_procs_helper.P_VAL_CODES(con, "IL_LOS_TYP",
					pm_il_clm_repay_dtl_bean.getCRD_LOSS_TYPE(),
					pm_il_clm_repay_dtl_bean.getUI_M_LOSS_DESC_1(), "N", "N",
					"");
			pm_il_clm_repay_dtl_bean.setUI_M_LOSS_DESC_1(desc);
			String desc1 = pilm007_procs_helper.P_VAL_CODES(con, "IL_DIS_TYP",
					pm_il_clm_repay_dtl_bean.getCRD_DISABLE_TYPE(),
					pm_il_clm_repay_dtl_bean.getUI_M_DISABLE_DESC_1(), "N",
					"N", "");
			pm_il_clm_repay_dtl_bean.setUI_M_DISABLE_DESC_1(desc1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_INSERT(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_CLM_REPAY_DTL pm_il_clm_repay_dtl_bean = compositeAction
				.getPM_IL_CLM_REPAY_DTL_ACTION_BEAN()
				.getPM_IL_CLM_REPAY_DTL_BEAN();
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		pm_il_clm_repay_dtl_bean.setCRD_COVER_CR_DT(new CommonUtils()
				.getCurrentDate());
		pm_il_clm_repay_dtl_bean.setCRD_COVER_CR_UID(CommonUtils
				.getGlobalVariable("GLOBAL.M_USER_ID"));
		pm_il_clm_repay_dtl_bean.setCRD_CR_COVER_CODE(pm_il_clm_repay_bean
				.getCR_COVER_CODE());
		pm_il_clm_repay_dtl_bean.setCRD_CR_LOSS_TYPE(pm_il_clm_repay_bean
				.getCR_LOSS_TYPE());
		pm_il_clm_repay_dtl_bean.setCRD_CR_DISABLE_TYPE(pm_il_clm_repay_bean
				.getCR_DISABLE_TYPE());

		pilm007_procs_helper.L_UNIQUE_PAY_SETUP(pm_il_clm_repay_dtl_bean);
	}

	public void PRE_UPDATE(PM_IL_CLM_REPAY_DTL pm_il_clm_repay_dtl_bean)
			throws Exception {
		pm_il_clm_repay_dtl_bean.setCRD_COVER_UPD_DT(new CommonUtils()
				.getCurrentDate());
		pm_il_clm_repay_dtl_bean.setCRD_COVER_UPD_UID(CommonUtils
				.getGlobalVariable("GLOBAL.M_USER_ID"));
		pilm007_procs_helper.L_UNIQUE_PAY_SETUP(pm_il_clm_repay_dtl_bean);
	}
}
