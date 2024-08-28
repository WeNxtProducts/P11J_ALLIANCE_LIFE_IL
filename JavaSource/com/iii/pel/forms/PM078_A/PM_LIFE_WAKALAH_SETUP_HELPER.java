package com.iii.pel.forms.PM078_A;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PM_LIFE_WAKALAH_SETUP_HELPER {
	CommonUtils commonUtils = new CommonUtils();
	PM078_A_Procedures procedures = new PM078_A_Procedures();
	public void executeQuery(PM078_A_COMPOSITE_ACTION compositeAction) throws Exception {
		new PM_LIFE_WAKALAH_SETUP_DELEGATE().executeSelectStatement(compositeAction);

		List<PM_LIFE_WAKALAH_SETUP> dataList = compositeAction.
		getPM_LIFE_WAKALAH_SETUP_ACTION_BEAN().getDataList_PM_LIFE_WAKALAH_SETUP();
		if(dataList!=null && dataList.size() > 0){
			PM_LIFE_WAKALAH_SETUP PM_LIFE_WAKALAH_SETUP_BEAN = dataList.get(0);
			PM_LIFE_WAKALAH_SETUP_BEAN.setRowSelected(true);
			compositeAction.getPM_LIFE_WAKALAH_SETUP_ACTION_BEAN()
			.setPM_LIFE_WAKALAH_SETUP_BEAN(PM_LIFE_WAKALAH_SETUP_BEAN);
		}
	}

	public void preInsert(PM_LIFE_WAKALAH_SETUP pm_life_wakalah_setup, 
			PM_LIFE_WAKALAH_HDR pm_life_wakalah_hdr) throws Exception{
		try {
			pm_life_wakalah_setup.setWAKS_CR_DT(commonUtils.getCurrentDate());
			pm_life_wakalah_setup.setWAKS_CR_UID(CommonUtils.getControlBean().getUSER_ID());
			pm_life_wakalah_setup.setWAKS_MODULE(pm_life_wakalah_hdr.getWAKS_MODULE());
			pm_life_wakalah_setup.setWAKS_PRODUCT_CODE(pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE());
			pm_life_wakalah_setup.setWAKS_FRZ_FLAG(pm_life_wakalah_hdr.getWAKS_FRZ_FLAG());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}

	public void preUpdate(PM_LIFE_WAKALAH_SETUP pm_life_wakalah_setup, 
			PM_LIFE_WAKALAH_HDR pm_life_wakalah_hdr) throws Exception{
		try {
			pm_life_wakalah_setup.setWAKS_UPD_DT(commonUtils.getCurrentDate());
			pm_life_wakalah_setup.setWAKS_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
			pm_life_wakalah_setup.setWAKS_MODULE(pm_life_wakalah_hdr.getWAKS_MODULE());
			pm_life_wakalah_setup.setWAKS_PRODUCT_CODE(pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE());
			pm_life_wakalah_setup.setWAKS_FRZ_FLAG(pm_life_wakalah_hdr.getWAKS_FRZ_FLAG());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}

	public void postQuery(PM_LIFE_WAKALAH_SETUP pm_life_wakalah_setup, 
			PM_LIFE_WAKALAH_HDR pm_life_wakalah_hdr) throws Exception{
		DBProcedures dbProcedures = null;
		ArrayList<String> prodDesc = null;
		PM078_A_Procedures procedures = null;
		String P_PROD_DESC = null;
		String P_COVER_DESC = null;
		String CODE = pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE();
		try{
			dbProcedures = new DBProcedures();
			procedures = new PM078_A_Procedures();
			prodDesc = new ArrayList<String>();
			if("GI".equals(pm_life_wakalah_hdr.getWAKS_MODULE())){
				prodDesc = dbProcedures.P_VAL_SC(CODE,
						pm_life_wakalah_hdr.getUI_M_WAKS_PRODUCT_CODE(), "N", "N");
				pm_life_wakalah_hdr.setUI_M_WAKS_PRODUCT_CODE(prodDesc.get(0));
				if(prodDesc != null){
					
				}
			}else if("IL".equals(pm_life_wakalah_hdr.getWAKS_MODULE())){
				P_PROD_DESC = procedures.L_VAL_PRODUCT(CODE, "N");
				pm_life_wakalah_hdr.setUI_M_WAKS_PRODUCT_CODE(P_PROD_DESC);
			}
			if(pm_life_wakalah_setup.getWAKS_COVER_CODE() != null){
				P_COVER_DESC = procedures.L_VAL_COVER(pm_life_wakalah_setup.getWAKS_COVER_CODE(), "E");
				if(P_COVER_DESC != null){
					pm_life_wakalah_setup.setUI_M_WAKS_COVER_CODE(P_COVER_DESC);
				}
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(PM_LIFE_WAKALAH_SETUP_ACTION pm_life_wakalah_setup_action){
		PM_LIFE_WAKALAH_SETUP pm_life_wakalah_setup = pm_life_wakalah_setup_action
			.getPM_LIFE_WAKALAH_SETUP_BEAN();
		String date = "31-DEC-2999";
		Date chkdate = CommonUtils.DBStringToDate(date);
		if(chkdate.equals(pm_life_wakalah_setup.getWAKS_EFF_TO_DT())){
			pm_life_wakalah_setup_action.getCOMP_WAKS_EFF_TO_DT().setRequired(true);
			pm_life_wakalah_setup_action.getCOMP_WAKS_EFF_TO_DT().setDisabled(false);
		}else{
			pm_life_wakalah_setup_action.getCOMP_WAKS_EFF_TO_DT().setRequired(false);
			pm_life_wakalah_setup_action.getCOMP_WAKS_EFF_TO_DT().setDisabled(true);
		}
		if("1".equals(pm_life_wakalah_setup.getWAKS_EXP_CALC_MTHD())){
			pm_life_wakalah_setup.setWAKS_EXPENSE_PERC(null);
			pm_life_wakalah_setup_action.getCOMP_WAKS_EXPENSE_PERC().setDisabled(true);
		}else{
			pm_life_wakalah_setup_action.getCOMP_WAKS_EXPENSE_PERC().setDisabled(false);
			pm_life_wakalah_setup_action.getCOMP_WAKS_EXPENSE_PERC().setRequired(true);
		}
	}
	public void WHEN_CREATE_RECORD(PM_LIFE_WAKALAH_SETUP pm_life_wakalah_setup,
			PM_LIFE_WAKALAH_HDR pm_life_wakalah_hdr){
		String toDate = "31-DEC-2999";
		Date todate = CommonUtils.DBStringToDate(toDate);
		pm_life_wakalah_setup.setWAKS_EFF_TO_DT(todate);
		pm_life_wakalah_setup.setWAKS_MODULE(pm_life_wakalah_hdr.getWAKS_MODULE());
		pm_life_wakalah_setup.setWAKS_PRODUCT_CODE(pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE());
		pm_life_wakalah_setup.setWAKS_FRZ_FLAG(pm_life_wakalah_hdr.getWAKS_FRZ_FLAG());
		pm_life_wakalah_setup.setWAKS_ZERO_PREM_YN("N");
		pm_life_wakalah_setup.setWAKS_CHARGE_MODE("N");
		pm_life_wakalah_setup.setWAKS_RISK_LOAD_YN("N");
		//For PM_LIFE_WAKALAH_HDR WHEN_CREATE_RECORD
		pm_life_wakalah_hdr.setWAKS_MODULE("IL");
	}
	public void WHEN_VALIDATE_ITEM_WAKS_PCODE(PM_LIFE_WAKALAH_HDR pm_life_wakalah_hdr) throws Exception{
		DBProcedures dbProcedures = null;
		String P_PROD_DESC = null;
		ArrayList<String> prodDesc = null;
		PM078_A_Procedures procedures = null;
		try{
			dbProcedures = new DBProcedures();
			procedures = new PM078_A_Procedures();
			if("GI".equals(pm_life_wakalah_hdr.getWAKS_MODULE())){
				prodDesc = new ArrayList<String>();
				prodDesc = dbProcedures.P_VAL_SC(pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE(), 
						P_PROD_DESC, "N", "E");
				P_PROD_DESC = prodDesc.get(0);
			}else if("IL".equals(pm_life_wakalah_hdr.getWAKS_MODULE())){
				P_PROD_DESC = procedures.L_VAL_PRODUCT(pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE(), "E");
			}
		}catch(SQLException e){
			throw new Exception(e.getMessage());
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	public void WHEN_VALIDATE_ITEM_WAKS_COVER_CODE(String WAKS_COVER_CODE, 
			PM_LIFE_WAKALAH_SETUP setupBean) throws Exception{
		String coverDesc = null;
		if(WAKS_COVER_CODE != null){
			try {
				coverDesc = procedures.L_VAL_COVER(WAKS_COVER_CODE, "E");
				setupBean.setUI_M_WAKS_COVER_CODE(coverDesc);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}
	public void WHEN_VALIDATE_ITEM_WAKS_EFF_FM_DT(PM_LIFE_WAKALAH_SETUP_ACTION setupAction,
			PM_LIFE_WAKALAH_HDR hdrBean) throws Exception{
		try{
			if(setupAction.getCOMP_WAKS_EFF_TO_DT().isDisabled() == false){

			}else{
				procedures.L_UPDATE_TO_DT("N", hdrBean, 
						setupAction.getPM_LIFE_WAKALAH_SETUP_BEAN());
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_WAKS_EFF_TO_DT(PM_LIFE_WAKALAH_SETUP_ACTION setupAction,
			PM_LIFE_WAKALAH_HDR hdrBean) throws Exception{
		try{
			if(setupAction.getCOMP_WAKS_EFF_TO_DT().isDisabled() == false){
			   if(setupAction.getPM_LIFE_WAKALAH_SETUP_BEAN().getWAKS_EFF_FM_DT() != null){
				   if(setupAction.getPM_LIFE_WAKALAH_SETUP_BEAN().
						   getWAKS_EFF_TO_DT().before(setupAction.
								   getPM_LIFE_WAKALAH_SETUP_BEAN().getWAKS_EFF_FM_DT())){
					   throw new Exception(Messages.getString(
							   PELConstants.pelErrorMessagePath, "3002"));
				   }
			   }
			  }
			procedures.L_UPDATE_TO_DT("N", hdrBean, 
					setupAction.getPM_LIFE_WAKALAH_SETUP_BEAN());
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_ITEM_WAKS_EXP_CALC_MTHD(
			PM_LIFE_WAKALAH_SETUP_ACTION setupAction){
		PM_LIFE_WAKALAH_SETUP setupBean = setupAction.getPM_LIFE_WAKALAH_SETUP_BEAN();
		if("1".equals(setupBean.getWAKS_EXP_CALC_MTHD())){
			setupBean.setWAKS_EXPENSE_PERC(null);
			setupAction.getCOMP_WAKS_EXPENSE_PERC().setDisabled(true);
		}else{
			setupAction.getCOMP_WAKS_EXPENSE_PERC().setDisabled(false);
			setupAction.getCOMP_WAKS_EXPENSE_PERC().setRequired(true);
			//setupBean.setWAKS_EXPENSE_PERC(null);
		}
	}

	public void WHEN_LIST_CHANGED(PM_LIFE_WAKALAH_SETUP_ACTION setupAction){
		PM_LIFE_WAKALAH_SETUP setupBean = setupAction.getPM_LIFE_WAKALAH_SETUP_BEAN();
		if("1".equals(setupBean.getWAKS_EXP_CALC_MTHD())){
			setupBean.setWAKS_EXPENSE_PERC(null);
			setupAction.getCOMP_WAKS_EXPENSE_PERC().setDisabled(true);
		}else{
			setupAction.getCOMP_WAKS_EXPENSE_PERC().setDisabled(false);
			setupAction.getCOMP_WAKS_EXPENSE_PERC().setRequired(true);
		}
	}
	public void preForm(){
		CommonUtils.setGlobalVariable("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
	}
}