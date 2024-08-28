package com.iii.pel.forms.PILT032_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_RECEIPT_TRANS_HDR_HELPER {

	public void executeQuery(PILT032_APAC_COMPOSITE_ACTION compositeAction) throws Exception
			 {
		try {
			new PT_IL_RECEIPT_TRANS_HDR_DELEGATE()
					.executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_NEW_RECORD_INSTSNCE(
			PILT032_APAC_COMPOSITE_ACTION compositeAction,
			PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN) throws Exception {

		if ("N".equalsIgnoreCase(CommonUtils.nvl(PT_IL_RECEIPT_TRANS_HDR_BEAN
				.getRTH_APPRV_STATUS(), "N"))) {
			PT_IL_RECEIPT_TRANS_HDR_BEAN.setUI_M_RTH_APPRV_DT(null);
			PT_IL_RECEIPT_TRANS_HDR_BEAN.setUI_M_STATUS("");
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().setUPDATE_ALLOWED(true);
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().setDELETE_ALLOWED(true);
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().setUPDATE_ALLOWED(true);
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().setUPDATE_ALLOWED(true);

			/*compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getCOMP_RTH_APPRV_USER().set',VISIBLE,PROPERTY_FALSE);
			SET_ITEM_PROPERTY('PT_IL_RECEIPT_TRANS_HDR.M_RTH_APPRV_DT'  ,VISIBLE,PROPERTY_FALSE);*/
			
			if (PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_PROCESS_DT() != null) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setUI_M_STATUS("Not Approved");
			} else if (PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_PROCESS_DT() == null) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setUI_M_STATUS("");
			}
		}

		else if ("Y".equalsIgnoreCase(CommonUtils.nvl(
				PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_APPRV_STATUS(), "N"))) {

			PT_IL_RECEIPT_TRANS_HDR_BEAN.setUI_M_STATUS("Approved");
			PT_IL_RECEIPT_TRANS_HDR_BEAN
					.setUI_M_RTH_APPRV_DT(PT_IL_RECEIPT_TRANS_HDR_BEAN
							.getRTH_APPRV_DT());

			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().setUPDATE_ALLOWED(false);
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().setDELETE_ALLOWED(false);
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().setUPDATE_ALLOWED(false);
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().setUPDATE_ALLOWED(false);
			/*SET_ITEM_PROPERTY('PT_IL_RECEIPT_TRANS_HDR.RTH_APPRV_USER',VISIBLE,PROPERTY_TRUE);
			SET_ITEM_PROPERTY('PT_IL_RECEIPT_TRANS_HDR.M_RTH_APPRV_DT'  ,VISIBLE,PROPERTY_TRUE);*/
		}
	}
	
	public void PRE_UPDATE(PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN)throws Exception{
		try {
			PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
			PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_UPD_DT(new CommonUtils().getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void PRE_DELETE(PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN)throws Exception{
		 String deleteQuery = "DELETE FROM PT_IL_RECEIPT_TRANS_DTL P " +
		 		"WHERE P.RTD_RTH_SYS_ID = ? ";
		 CRUDHandler handler = new CRUDHandler();
		 Integer resultSet = null;
		 Connection connection = null;
		 try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeDeleteStatement(deleteQuery, connection,new Object[]
			               {PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SYS_ID()});
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		}
	
	public void keyNextItem(PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN,
			PILT032_APAC_COMPOSITE_ACTION compositeAction)throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			
			
			String C1 ="SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_NO IN " +
					"(SELECT DEP_REF_NO FROM   PT_IL_DEPOSIT WHERE  NVL(DEP_REC_REV_YN,'N') =  ?) " +
					"AND  ((POL_DS_TYPE  =  '1' AND  NVL(POL_CONVERT_YN,'N')  = ? )  " +
					"OR   (POL_DS_TYPE   =  '2' AND   POL_APPRV_STATUS = ?)) " +
					"AND  POL_NO         =   ?"; 
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{"N","N","A",
					PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_NO()});
			if(resultSet.next()){
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SRC_POL_SYS_ID(resultSet.getLong(1));
			}
			else{
				throw new Exception(
					    Messages
						    .getString(
							    PELConstants.pelErrorMessagePath,
							    "71153",
							    new Object[] {CommonUtils.getControlBean().getM_LANG_CODE()}));
			}
			/*if(compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PROCESS().setDisabled("false")){  		
			  		  GO_ITEM('DUMMY.M_BUT_PROCESS');	
			}
			else{
					  GO_ITEM('PT_IL_RECEIPT_TRANS_DTL.RTD_DES_POL_NO');	
			}*/
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void PRE_QUERY(PILT032_APAC_COMPOSITE_ACTION compositeAction){
		if(CommonUtils.getGlobalObject("GLOBAL.M_RTH_SYS_ID") != null){
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().
			   //setDEFAULT_WHERE(" AND RTH_SYS_ID = ? " + CommonUtils.getGlobalObject("GLOBAL.M_RTH_SYS_ID"));
			setDEFAULT_WHERE(" AND RTH_SYS_ID =  "+ CommonUtils.getGlobalObject("GLOBAL.M_RTH_SYS_ID") );
			
			CommonUtils.setGlobalObject("GLOBAL.M_RTH_SYS_ID",null);
		}
		else{
	      compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().setDEFAULT_WHERE("");
		}
	}
	
}
