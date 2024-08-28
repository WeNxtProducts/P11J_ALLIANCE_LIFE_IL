package com.iii.pel.forms.PILP078;

import java.util.List;

import com.iii.pel.forms.PILM035_APAC.PILM035_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM035_APAC.PM_IL_PRODUCT;
import com.iii.pel.forms.PILM035_APAC.PM_IL_PROD_CASHBACK;
import com.iii.pel.forms.PILM035_APAC.PM_IL_PROD_CASHBACK_DELEGATE;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD_DELEGATE;
import com.iii.premia.common.utils.CommonUtils;

public class INTERNAL_TRANSFER_HELPER {
	public void executeQuery(PILP078_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new INTERNAL_TRANSFER_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_ADJ_HEAD> dataList = compositeAction
				.getINTERNAL_TRANSFER_ACTION_BEAN()
				.getDataList_PT_IL_ADJ_HEAD();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_ADJ_HEAD PT_IL_ADJ_HEAD_BEAN = dataList.get(0);
			PT_IL_ADJ_HEAD_BEAN.setRowSelected(true);
			compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN()
					.setPT_IL_ADJ_HEAD_BEAN(PT_IL_ADJ_HEAD_BEAN);
		}
		List<PT_IL_ADJ_PROP_DEP> dataList1 = compositeAction
				.getINTERNAL_TRANSFER_ACTION_BEAN()
				.getDataList_PT_IL_ADJ_PROP_DEP();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_ADJ_HEAD PT_IL_ADJ_HEAD_BEAN = dataList.get(0);
			PT_IL_ADJ_HEAD_BEAN.setRowSelected(true);
			compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN()
					.setPT_IL_ADJ_HEAD_BEAN(PT_IL_ADJ_HEAD_BEAN);
		}
	}
	public void executeQuery1(PILP078_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new INTERNAL_TRANSFER_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_ADJ_PROP_DEP> dataList1 = compositeAction
				.getINTERNAL_TRANSFER_ACTION_BEAN()
				.getDataList_PT_IL_ADJ_PROP_DEP();
		if (dataList1 != null && dataList1.size() > 0) {
			PT_IL_ADJ_PROP_DEP PT_IL_ADJ_PROP_DEP_BEAN = dataList1.get(0);
			PT_IL_ADJ_PROP_DEP_BEAN.setRowSelected(true);
			compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN()
					.setPT_IL_ADJ_PROP_DEP_BEAN(PT_IL_ADJ_PROP_DEP_BEAN);
		}
	}
	public void executeQuery2(PILP078_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new INTERNAL_TRANSFER_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_ADJ_PREM_COLL> dataList2 = compositeAction
				.getINTERNAL_TRANSFER_ACTION_BEAN()
				.getDataList_PT_IL_ADJ_PREM_COLL();
		if (dataList2 != null && dataList2.size() > 0) {
			PT_IL_ADJ_PREM_COLL PT_IL_ADJ_PREM_COLL_BEAN = dataList2.get(0);
			PT_IL_ADJ_PREM_COLL_BEAN.setRowSelected(true);
			compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN()
					.setPT_IL_ADJ_PREM_COLL_BEAN(PT_IL_ADJ_PREM_COLL_BEAN);
		}
	}
	
	public void executeQuery3(PILP078_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new INTERNAL_TRANSFER_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_ADJ_LOAN> dataList3 = compositeAction
				.getINTERNAL_TRANSFER_ACTION_BEAN()
				.getDataList_PT_IL_ADJ_LOAN();
		if (dataList3 != null && dataList3.size() > 0) {
			PT_IL_ADJ_LOAN PT_IL_ADJ_LOAN_BEAN = dataList3.get(0);
			PT_IL_ADJ_LOAN_BEAN.setRowSelected(true);
			compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN()
					.setPT_IL_ADJ_LOAN_BEAN(PT_IL_ADJ_LOAN_BEAN);
		}
	}
	public void PRE_INSERT(PILP078_COMPOSITE_ACTION compositeAction)throws Exception {
		PT_IL_ADJ_HEAD PT_IL_ADJ_HEAD_BEAN=compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getPT_IL_ADJ_HEAD_BEAN();
		//PM_IL_PRODUCT pm_il_product_bean = compositeAction
				//.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
	
		try {
			/*PM_IL_PROD_CASHBACK_BEAN.setPCB_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());*/
			PT_IL_ADJ_HEAD_BEAN.setAH_CR_DT(new CommonUtils()
					.getCurrentDate());
			PT_IL_ADJ_HEAD_BEAN.setAH_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
			//L_UNIQUE_MODETERM(compositeAction);

		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}
	
	public void PRE_UPDATE(PILP078_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_ADJ_HEAD PT_IL_ADJ_HEAD_BEAN=compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getPT_IL_ADJ_HEAD_BEAN();
	/*	PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();*/
		try {
		  
			PT_IL_ADJ_HEAD_BEAN.setAH_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PT_IL_ADJ_HEAD_BEAN.setAH_CR_DT(new CommonUtils()
			.getCurrentDate());
			PT_IL_ADJ_HEAD_BEAN.setAH_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PT_IL_ADJ_HEAD_BEAN.setAH_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
			 //L_UNIQUE_MODETERM(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}
	public void PRE_UPDATE1(PILP078_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_ADJ_PROP_DEP PT_IL_ADJ_PROP_DEP_BEAN=compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getPT_IL_ADJ_PROP_DEP_BEAN();
	/*	PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();*/
		try {
		  
			PT_IL_ADJ_PROP_DEP_BEAN.setAPD_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PT_IL_ADJ_PROP_DEP_BEAN.setAPD_CR_DT(new CommonUtils()
			.getCurrentDate());
			PT_IL_ADJ_PROP_DEP_BEAN.setAPD_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PT_IL_ADJ_PROP_DEP_BEAN.setAPD_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
			 //L_UNIQUE_MODETERM(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}
	public void PRE_UPDATE2(PILP078_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_ADJ_PREM_COLL PT_IL_ADJ_PREM_COLL_BEAN=compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getPT_IL_ADJ_PREM_COLL_BEAN();
	/*	PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();*/
		try {
		  
			PT_IL_ADJ_PREM_COLL_BEAN.setAPC_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PT_IL_ADJ_PREM_COLL_BEAN.setAPC_CR_DT(new CommonUtils()
			.getCurrentDate());
			PT_IL_ADJ_PREM_COLL_BEAN.setAPC_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PT_IL_ADJ_PREM_COLL_BEAN.setAPC_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
			 //L_UNIQUE_MODETERM(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}
	public void PRE_UPDATE3(PILP078_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_ADJ_LOAN PT_IL_ADJ_LOAN_BEAN=compositeAction.getINTERNAL_TRANSFER_ACTION_BEAN().getPT_IL_ADJ_LOAN_BEAN();
	/*	PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();*/
		try {
		  
			PT_IL_ADJ_LOAN_BEAN.setAL_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PT_IL_ADJ_LOAN_BEAN.setAL_CR_DT(new CommonUtils()
			.getCurrentDate());
			PT_IL_ADJ_LOAN_BEAN.setAL_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PT_IL_ADJ_LOAN_BEAN.setAL_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
			 //L_UNIQUE_MODETERM(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}
}
