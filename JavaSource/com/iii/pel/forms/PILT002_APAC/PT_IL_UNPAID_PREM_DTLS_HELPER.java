package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_UNPAID_PREM_DTLS_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	throws Exception {
		new PT_IL_UNPAID_PREM_DTLS_DELEGATE()
		.executeSelectStatement(compositeAction);
	}

	public  void WHEN_CREATE_RECORD() {
		/* IF :SYSTEM.CURSOR_RECORD != '1' THEN
	      PREVIOUS_RECORD;
	   END IF;*/
	}

	public  void WHEN_NEW_RECORD_INSTANCE(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY pt_il_policy_bean = compositeAction
			.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_UNPAID_PREM_DTLS_ACTION pt_il_unpaid_prem_dtls_action = 
			compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN();
		try {

			if(CommonUtils.nvl(pt_il_policy_bean.getPOL_APPRV_STATUS(),"N").equals("N") && 
					pt_il_unpaid_prem_dtls_action.isUPDATE_ALLOWED()==true ){
				if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(1,2))){

					pt_il_unpaid_prem_dtls_action.getCOMP_UPD_INT_CODE().setDisabled( false); 
					pt_il_unpaid_prem_dtls_action.getCOMP_UPD_INT_PERC().setDisabled( false);  
					pt_il_unpaid_prem_dtls_action.getCOMP_UPD_FC_INTEREST().setDisabled( false);  
					pt_il_unpaid_prem_dtls_action.getCOMP_UPD_LC_INTEREST().setDisabled( false);  
				}
				pt_il_unpaid_prem_dtls_action.getCOMP_UPD_PAY_DT().setDisabled(true ); 
				pt_il_unpaid_prem_dtls_action.getCOMP_UPD_FC_UNPAID_PREM().setDisabled( true); 
				pt_il_unpaid_prem_dtls_action.getCOMP_UPD_LC_UNPAID_PREM().setDisabled(true); 
			}

			/*  IF :SYSTEM.CURSOR_RECORD != '1' THEN
		      PREVIOUS_RECORD;
		   END IF;*/

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public  void PRE_BLOCK() {
		//:CTRL.M_DELETE_MSG_FLAG := 'N';
	}

	public void POST_QUERY(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
			.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();

		PT_IL_UNPAID_PREM_DTLS  pt_il_unpaid_prem_dtls_bean = 
			compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN().getPT_IL_UNPAID_PREM_DTLS_BEAN();

		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		try {
			pValList = pkg_pilt002_apac.P_VAL_CODES(  "IL_PRM_INT",
					pt_il_unpaid_prem_dtls_bean.getUPD_INT_CODE(),
					dummy_bean.getUI_M_UPD_INT_CODE_DESC(),
					"N",
					"N",
					null); 
			dummy_bean.setUI_M_UPD_INT_CODE_DESC(pValList.get( 0).getValue());

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public  void PRE_INSERT(PT_IL_UNPAID_PREM_DTLS pt_il_unpaid_prem_dtls_bean ) throws Exception {
		String query1 = "SELECT PIL_UPD_SYS_ID.NEXTVAL  FROM   DUAL ";
		Connection connection = null;
		ResultSet rs = null;

		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(  query1, connection );
			if(rs.next())
				pt_il_unpaid_prem_dtls_bean.setUPD_SYS_ID( rs.getDouble( 1)) ;

			pt_il_unpaid_prem_dtls_bean.setUPD_CR_DT(new CommonUtils().getCurrentDate());
			pt_il_unpaid_prem_dtls_bean.setUPD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public  void PRE_UPDATE(PT_IL_UNPAID_PREM_DTLS pt_il_unpaid_prem_dtls_bean ) throws Exception {

		try {
			pt_il_unpaid_prem_dtls_bean.setUPD_UPD_DT(new CommonUtils().getCurrentDate());
			pt_il_unpaid_prem_dtls_bean.setUPD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void UPD_INT_CODE_WHEN_VALIDATE_ITEM(PILT002_APAC_COMPOSITE_ACTION compositeAction,String currValue) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();

		PT_IL_UNPAID_PREM_DTLS  pt_il_unpaid_prem_dtls_bean = compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN().getPT_IL_UNPAID_PREM_DTLS_BEAN();

		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		try {
			if(currValue !=null){
				pValList = pkg_pilt002_apac.P_VAL_CODES(  "IL_PRM_INT",
						pt_il_unpaid_prem_dtls_bean.getUPD_INT_CODE(),
						dummy_bean.getUI_M_UPD_INT_CODE_DESC(),
						"N",
						"E",
						null); 
				dummy_bean.setUI_M_UPD_INT_CODE_DESC(pValList.get(0).getValue());
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void UPD_INT_PERC_WHEN_VALIDATE_ITEM(PILT002_APAC_COMPOSITE_ACTION compositeAction,
			Double currValue) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		PT_IL_UNPAID_PREM_DTLS  pt_il_unpaid_prem_dtls_bean = compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN().getPT_IL_UNPAID_PREM_DTLS_BEAN();

		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		try {
			if( currValue <= 0  &&  currValue > 100 ){
				throw new Exception(
						Messages.getString(
								PELConstants.pelErrorMessagePath,
								"71070",
								new Object[] {
										CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")  }));
			}
			if(currValue> 0){ 
				pt_il_unpaid_prem_dtls_bean.setUPD_FC_INTEREST( ( currValue  *
						pt_il_unpaid_prem_dtls_bean.getUPD_FC_UNPAID_PREM() )/ 100); 
				pValList = new ArrayList<String>();
				pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean.getPOL_CUST_CURR_CODE(),  
						pt_il_unpaid_prem_dtls_bean.getUPD_FC_INTEREST().toString(), "R",
						pt_il_policy_bean.getPOL_PROD_CODE());

				pt_il_unpaid_prem_dtls_bean.setUPD_FC_INTEREST(Double.parseDouble(pValList
						.get(0)));

				pt_il_unpaid_prem_dtls_bean.setUPD_LC_INTEREST( ( currValue *
						pt_il_unpaid_prem_dtls_bean.getUPD_LC_UNPAID_PREM()) / 100); 
				pValList = new ArrayList<String>();
				pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean.getUI_M_BASE_CURR(),
						pt_il_unpaid_prem_dtls_bean.getUPD_LC_UNPAID_PREM().toString(),
						"R",  pt_il_policy_bean.getPOL_PROD_CODE() );
				pt_il_unpaid_prem_dtls_bean.setUPD_LC_UNPAID_PREM(Double.parseDouble(pValList
						.get(0)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void UPD_FC_INTEREST_WHEN_VALIDATE_ITEM(PILT002_APAC_COMPOSITE_ACTION compositeAction,
			Double currValue) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		PT_IL_UNPAID_PREM_DTLS  pt_il_unpaid_prem_dtls_bean = compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN().getPT_IL_UNPAID_PREM_DTLS_BEAN();
		pt_il_unpaid_prem_dtls_bean.setUPD_FC_INTEREST(currValue);
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		LIFELIB lifelib = new LIFELIB();
		try {

			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean.getPOL_CUST_CURR_CODE(),
					currValue.toString(),
					"V",pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_unpaid_prem_dtls_bean.setUPD_FC_INTEREST(Double.parseDouble(pValList
					.get(0)));

			lifelib.P_VAL_PERC_VALUE_TOLERANCE(pt_il_policy_bean.getUI_M_POL_FC_GR_ANN_PREM().toString(),
					pt_il_unpaid_prem_dtls_bean.getUPD_INT_PERC().toString(),
					pt_il_unpaid_prem_dtls_bean.getUPD_FC_INTEREST().toString(),
					"E");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void UPD_LC_INTEREST_WHEN_VALIDATE_ITEM(PILT002_APAC_COMPOSITE_ACTION compositeAction,
			Double currValue) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		ArrayList<String> pValList = new ArrayList<String>();
		PT_IL_UNPAID_PREM_DTLS  pt_il_unpaid_prem_dtls_bean = compositeAction.getPT_IL_UNPAID_PREM_DTLS_ACTION_BEAN().getPT_IL_UNPAID_PREM_DTLS_BEAN();
		pt_il_unpaid_prem_dtls_bean.setUPD_LC_INTEREST(currValue);
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		LIFELIB lifelib = new LIFELIB();
		try {
			pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean.getUI_M_BASE_CURR(),
					currValue.toString(),
					"V",pt_il_policy_bean.getPOL_PROD_CODE());

			pt_il_unpaid_prem_dtls_bean.setUPD_LC_INTEREST(Double.parseDouble(pValList
					.get(0)));
			lifelib.P_VAL_FC_LC_TOLERANCE(pt_il_unpaid_prem_dtls_bean.getUPD_LC_INTEREST().toString(),
					pt_il_unpaid_prem_dtls_bean.getUPD_LC_INTEREST().toString() ,
					pt_il_policy_bean.getPOL_CUST_EXCH_RATE().toString(),
					"E");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
