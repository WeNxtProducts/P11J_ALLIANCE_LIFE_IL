package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT027.PILT027_COMPOSITE_ACTION;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_WITHDRAWAL_CHARGE_HELPER {
	CommonUtils commonUtils = new CommonUtils();
	PKG_PILT021 pkg_pilt021 = new PKG_PILT021();
	DBProcedures procedures = new DBProcedures();
	public void executeQuery(PILT021_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_WITHDRAWAL_CHARGE_DELEGATE().executeSelectStatement(compositeAction);
      
		List<PT_IL_WITHDRAWAL_CHARGE> dataList = compositeAction.
		getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN().getDataList_PT_IL_WITHDRAWAL_CHARGE();
		if(dataList!=null && dataList.size() > 0){
			PT_IL_WITHDRAWAL_CHARGE PT_IL_WITHDRAWAL_CHARGE_BEAN = dataList.get(0);
			PT_IL_WITHDRAWAL_CHARGE_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_WITHDRAWAL_CHARGE_ACTION_BEAN()
			.setPT_IL_WITHDRAWAL_CHARGE_BEAN(PT_IL_WITHDRAWAL_CHARGE_BEAN);
		}
	}
	public void preUpdate(PT_IL_WITHDRAWAL_CHARGE pt_il_withdrawal_charge) throws Exception{
		try {
			pt_il_withdrawal_charge.setWDC_UPD_DT(commonUtils.getCurrentDate());
			pt_il_withdrawal_charge.setWDC_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}
	public void preInsert(PT_IL_WITHDRAWAL_CHARGE pt_il_withdrawal_charge) throws Exception{
		String C1 = null;
		Connection connection = null;
		ResultSet resultSetC1 = null;
		CRUDHandler handler = null;
		String mappedBeanName="PILT021_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		try {
			
			PILT021_COMPOSITE_ACTION compositeActionBean=
				(PILT021_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			
			Long id=compositeActionBean.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_SYS_ID(); 
			
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			C1 = "SELECT PIL_WDC_SYS_ID.NEXTVAL FROM DUAL";
			pkg_pilt021.IL_UNIQUE_CHARGE_CODE(pt_il_withdrawal_charge.getWDC_CHRG_CODE(), 
					CommonUtils.getProcedureValue(pt_il_withdrawal_charge.getWDC_WD_SYS_ID()), 
					pt_il_withdrawal_charge.getROWID());
			resultSetC1 = handler.executeSelectStatement(C1, connection);
			if (resultSetC1.next()) {
				
				pt_il_withdrawal_charge.setWDC_SYS_ID(resultSetC1.getLong(1));		
				
			}
			
			if(null!=id){
			  pt_il_withdrawal_charge.setWDC_WD_SYS_ID(id);
			}
			
			pt_il_withdrawal_charge.setWDC_CR_DT(commonUtils.getCurrentDate());
			pt_il_withdrawal_charge.setWDC_CR_UID(CommonUtils.getControlBean().getUSER_ID());
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}finally {
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
		}
	}
	public void WHEN_CREATE_RECORD(PT_IL_WITHDRAWAL_CHARGE pt_il_withdrawal_charge) {
		pt_il_withdrawal_charge.setWDC_CUST_SHARE_PERC(100.00);
	}
	public void postQuery(PT_IL_WITHDRAWAL_CHARGE pt_il_withdrawal_charge) throws Exception{
		String P_CLASS_CODE = null;
		ArrayList<String> outList = null;
		try {
			outList = new ArrayList<String>();
			if(pt_il_withdrawal_charge.getWDC_CHRG_CODE() != null){
				outList = procedures.helperP_VAL_CODES("IL_CHARGE", pt_il_withdrawal_charge.getWDC_CHRG_CODE(), 
						"N", "E", P_CLASS_CODE);
				pt_il_withdrawal_charge.setUI_M_WDC_CHARGE_DESC(outList.get(0));
			}
		} catch (SQLException e) {
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			//throw new Exception(e.getMessage());
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			//throw new Exception(e.getMessage());
		}
	}
	
	/*Commentted &Modified by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
	/*public void WHEN_NEW_BLOCK_INSTANCE(DUMMY dummy, PT_IL_WITHDRAWAL pt_il_withdrawal, 
			PT_IL_WITHDRAWAL_CHARGE_ACTION pt_il_withdrawal_charge_action,PILT021_COMPOSITE_ACTION compositeAction) throws Exception{
		try {
			executeQuery(compositeAction);
			if(pt_il_withdrawal.getUI_M_POL_NO() != null){
				PT_IL_WITHDRAWAL_CHARGE pt_il_withdrawal_charge = pt_il_withdrawal_charge_action.getPT_IL_WITHDRAWAL_CHARGE_BEAN();
				if(pt_il_withdrawal_charge.getROWID() == null){
					pkg_pilt021.L_POP_WITHDRAWAL_CHARGE(dummy.getUI_M_POL_PROD_CODE(), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_PREM_PAY_YRS()), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_START_DT()), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_SYS_ID()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_SYS_ID()), 
							pt_il_withdrawal.getWD_AMOUNT_YN(), 
							pt_il_withdrawal.getWD_TYPE(), 
							CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"), 
							CommonUtils.getProcedureValue(dummy.getUI_M_POL_CUST_EXCH_RATE()), 
							dummy.getUI_M_BASE_CURR(), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_GROSS_FC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NET_FC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_TOPUP_FC_AMT()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NET_TOP_UP_FC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_GROSS_LC_VALUE()), 
							CommonUtils.getProcedureValue(pt_il_withdrawal.getWD_NET_LC_VALUE()));
					pt_il_withdrawal_charge_action.setDEFAULT_WHERE(" WDC_WD_SYS_ID = "+pt_il_withdrawal.getWD_SYS_ID());
					if("N".equals(pt_il_withdrawal.getWD_APPRV_STATUS())){
						
					}
				}
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}}*/
		 
	    /*End*/
	
		/* IF (:PT_IL_WITHDRAWAL.WD_APPRV_STATUS) = 'N' THEN
		    SET_ITEM_PROPERTY('M_BUT_APPROVE', ENABLED, PROPERTY_TRUE); 
		    
		    IF NVL(:PT_IL_WITHDRAWAL.WD_NET_FC_VALUE,0)=0 OR NVL(:PT_IL_WITHDRAWAL.WD_NET_LC_VALUE,0)=0 THEN
		       SET_ITEM_PROPERTY('M_BUT_PROCESS', ENABLED, PROPERTY_TRUE);
		       SET_ITEM_PROPERTY('M_BUT_APPROVE', ENABLED, PROPERTY_FALSE);
		    ELSE
			    SET_ITEM_PROPERTY('M_BUT_PROCESS', ENABLED, PROPERTY_FALSE);
			    SET_ITEM_PROPERTY('M_BUT_APPROVE', ENABLED, PROPERTY_TRUE);
		    END IF;
		 
		 ELSIF NVL(:PT_IL_WITHDRAWAL.WD_APPRV_STATUS,'N') = 'A' THEN
		    SET_ITEM_PROPERTY('M_BUT_APPROVE', ENABLED, PROPERTY_FALSE);
		    SET_ITEM_PROPERTY('M_BUT_PROCESS', ENABLED, PROPERTY_FALSE);
		 END IF;
		 END IF;
		 
		 
		END;*/
	//}
	public void WHEN_VALIDATE_WDC_CHRG_CODE(String WDC_CHRG_CODE, Long WDC_WD_SYS_ID, String ROWID, 
			PT_IL_WITHDRAWAL_CHARGE pt_il_withdrawal_charge) throws Exception{
		String P_CLASS_CODE = null;
		ArrayList<String> outList = null;
		try {
			outList = new ArrayList<String>();
			if(WDC_WD_SYS_ID != null && ROWID != null){
				pkg_pilt021.IL_UNIQUE_CHARGE_CODE(WDC_CHRG_CODE, 
						CommonUtils.getProcedureValue(WDC_WD_SYS_ID), ROWID);
			}
			if(WDC_CHRG_CODE != null){
				outList = procedures.helperP_VAL_CODES("IL_CHARGE", WDC_CHRG_CODE, 
						"N", "E", P_CLASS_CODE);
				pt_il_withdrawal_charge.setUI_M_WDC_CHARGE_DESC(outList.get(0));
			}
		} catch (ProcedureException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void WHEN_VALIDATE_WDC_RATE(Double WDC_RATE) throws Exception{
		if(WDC_RATE < 0 ){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71043"));
		}
	}
	public void WHEN_VALIDATE_WDC_RATE_PER(Double WDC_RATE_PER) throws Exception{
		if(WDC_RATE_PER < 0 ){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71043"));
		}
	}
	
	/*MOdified by Janani on 23.02.2018 for withdrawal charges calculation as per Thiags sugges.*/
	
	/*public void WHEN_VALIDATE_WDC_CUST_SHARE_PERC(Double WDC_CUST_SHARE_PERC)*/
	
	public void WHEN_VALIDATE_WDC_CUST_SHARE_PERC(Double WDC_CUST_SHARE_PERC,DUMMY dummy, PT_IL_WITHDRAWAL pt_il_withdrawal, 
			PT_IL_WITHDRAWAL_CHARGE PT_IL_WITHDRAWAL_CHARGE_BEAN) 
		  throws Exception{
		
		ArrayList<OracleParameter> pOrclValList = new ArrayList<OracleParameter>();
		pOrclValList = new ArrayList<OracleParameter>();
		
		/*End*/		
		if(WDC_CUST_SHARE_PERC < 0.0 ){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71043"));
		}else if(WDC_CUST_SHARE_PERC > 100.0){
			throw new Exception("The percentage must be less then or equal to 100.");
		}
		
		/*Added by Janani on 23.02.2018 for withdrawal charges calculation as per Thiags sugges.*/
		else
		{

			
			Double rate = PT_IL_WITHDRAWAL_CHARGE_BEAN.getWDC_RATE();
			Double rate_per = PT_IL_WITHDRAWAL_CHARGE_BEAN.getWDC_RATE_PER();
			String chrg_code = PT_IL_WITHDRAWAL_CHARGE_BEAN.getWDC_CHRG_CODE();
			
			
			
			pOrclValList = pkg_pilt021.L_POP_WT_CHRG_ADD_DEL( 
					dummy.getUI_M_POL_SYS_ID(), 
					CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"), 
					dummy.getUI_M_POL_CUST_EXCH_RATE(), 
					//dummy.getUI_M_BASE_CURR(),
					CommonUtils.getControlBean().getM_BASE_CURR(),
					pt_il_withdrawal.getWD_SYS_ID(), 
					commonUtils.nvl(rate,0.0),
					commonUtils.nvl(rate_per,0.0),
					chrg_code,
					commonUtils.nvl(pt_il_withdrawal.getWD_GROSS_FC_VALUE(),0.0), 
					commonUtils.nvl(pt_il_withdrawal.getWD_NET_FC_VALUE(),0.0), 
					commonUtils.nvl(pt_il_withdrawal.getWD_TOPUP_FC_AMT(), 0.0), 
					commonUtils.nvl(pt_il_withdrawal.getWD_NET_TOP_UP_FC_VALUE(),0.0), 
					commonUtils.nvl(pt_il_withdrawal.getWD_GROSS_LC_VALUE(),0.0), 
					commonUtils.nvl(pt_il_withdrawal.getWD_NET_LC_VALUE(),0.0)
					);
			
			if (!pOrclValList.isEmpty() && pOrclValList != null) {
				
				PT_IL_WITHDRAWAL_CHARGE_BEAN
				.setWDC_PREM_FC_VALUE((Double) (commonUtils.nvl((Double) pOrclValList
						.get(7).getValueObject(),0.0)));
				PT_IL_WITHDRAWAL_CHARGE_BEAN
				.setWDC_PREM_LC_VALUE((Double) (commonUtils.nvl((Double) pOrclValList
						.get(6).getValueObject(),0.0)));
				PT_IL_WITHDRAWAL_CHARGE_BEAN
				.setWDC_TOP_UP_FC_VALUE((Double) (commonUtils.nvl((Double) pOrclValList
						.get(9).getValueObject(),0.0)));
				PT_IL_WITHDRAWAL_CHARGE_BEAN
				.setWDC_TOP_UP_LC_VALUE((Double) (commonUtils.nvl((Double) pOrclValList
						.get(8).getValueObject(),0.0)));
				PT_IL_WITHDRAWAL_CHARGE_BEAN
				.setWDC_FC_VALUE((Double) (commonUtils.nvl((Double) pOrclValList
						.get(11).getValueObject(),0.0)));
				PT_IL_WITHDRAWAL_CHARGE_BEAN
				.setWDC_LC_VALUE((Double) (commonUtils.nvl((Double) pOrclValList
						.get(10).getValueObject(),0.0)));
			}
			        
			/*End*/
		}
	}
	public void WHEN_VALIDATE_WDC_FC_VALUE(Double WDC_FC_VALUE,PILT021_COMPOSITE_ACTION compositeAction) throws Exception{
		
		/*Commentted &Modified by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
		
		/*if(WDC_FC_VALUE <= 0 ){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71043"));
		}*/
		
		if(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE()!=null && "T".equalsIgnoreCase(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())){
			System.out.println("Inside Contribution FC Value");
			
		}else if(WDC_FC_VALUE <= 0 ) {	
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71043"));
			
		}
		
		/*End*/
		
	}
	public void WHEN_VALIDATE_WDC_LC_VALUE(Double WDC_LC_VALUE,PILT021_COMPOSITE_ACTION compositeAction) throws Exception{
		
		/*Commentted &Modified by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
		
		/*if(WDC_LC_VALUE <= 0 ){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71043"));
		}*/
		
		if(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE()!=null && "T".equalsIgnoreCase(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())){
			System.out.println("Inside Contribution LC Value");
			
		}else if(WDC_LC_VALUE <= 0 ) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71043"));
			
		}
		
		/*End*/
	}
}
