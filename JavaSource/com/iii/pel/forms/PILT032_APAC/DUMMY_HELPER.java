package com.iii.pel.forms.PILT032_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P9ILPK_RECEIPT_TRANSFER;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

 

public class DUMMY_HELPER {

	/*Modified by Ganesh on 11.07.2017 for ZBILQC-1719675*/
	
	/*public void WHEN_VALIDATE_M_BUT_PROCESS(
			PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN,
			PILT032_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			new P9ILPK_RECEIPT_TRANSFER().INS_PT_IL_RECEIPT_TRANS_DTL(
					PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_SYS_ID(),
					PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_NO(),
					CommonUtils.getGlobalVariable("GLOBAL.M_RTH_SYS_ID"));
			if (CommonUtils.getGlobalVariable("GLOBAL.M_RTH_SYS_ID") == null) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206", new Object[] {
								CommonUtils.getControlBean().getM_LANG_CODE(),
								"No Records are found ..... !" }));

				//GO_ITEM('PT_IL_RECEIPT_TRANS_HDR.RTH_SRC_POL_NO');
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206", new Object[] {
								CommonUtils.getControlBean().getM_LANG_CODE(),
								"Processed records successfully ..... !" }));
				new PT_IL_RECEIPT_TRANS_DTL_HELPER().executeQuery(compositeAction);
			}
			//  EXECUTE_QUERY(NO_VALIDATE);
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}*/
	
	
	public void WHEN_VALIDATE_M_BUT_PROCESS(
			PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN,
			PILT032_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			ArrayList<OracleParameter> arrayList = new P9ILPK_RECEIPT_TRANSFER().INS_PT_IL_RECEIPT_TRANS_DTL(
					PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_SYS_ID(),
					PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SRC_POL_NO(),
					"");
			CommonUtils.setGlobalVariable("GLOBAL.M_RTH_SYS_ID", arrayList.get(0).getValueObject()!=null?arrayList.get(0).getValueObject().toString():null);
			if(CommonUtils.getGlobalVariable("GLOBAL.M_RTH_SYS_ID")!=null){
					PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SYS_ID(Long.valueOf(CommonUtils.getGlobalVariable("GLOBAL.M_RTH_SYS_ID")));
			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_RTH_SYS_ID") == null)
		
			 {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206", new Object[] {
								CommonUtils.getControlBean().getM_LANG_CODE(),
								"No Records are found ..... !" }));

				//GO_ITEM('PT_IL_RECEIPT_TRANS_HDR.RTH_SRC_POL_NO');
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
				/*throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206", new Object[] {
								CommonUtils.getControlBean().getM_LANG_CODE(),
								"Processed records successfully ..... !" }));*/
				compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN();
				new PT_IL_RECEIPT_TRANS_DTL_HELPER().executeQuery(compositeAction);
				
			}
			//  EXECUTE_QUERY(NO_VALIDATE);
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/*End*/
	public void WHEN_VALIDATE_M_BUT_APPROVE(PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN,
			PILT032_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			 String C1 ="SELECT  'X'  FROM    PT_IL_RECEIPT_TRANS_DTL " +
			 		" WHERE   RTD_RTH_SYS_ID = ?  " +
			 		"AND     NVL( RTD_TRNS_YN,'N') ='Y' AND    (RTD_DES_POL_NO  IS  NULL" +
			 		" OR     RTD_DES_POL_SYS_ID  IS  NULL " +
			 		"OR   RTD_REASON_CODE IS  NULL  OR  RTD_REV_REMARKS IS  NULL )"; 

						  	
			String	M_DUMMY_X = null;
				
				/*IF :SYSTEM.FORM_STATUS='CHANGED' THEN
					   STD_MESSAGE_ROUTINE(71048,:CTRL.M_LANG_CODE);
				     RAISE FORM_TRIGGER_FAILURE;
				END IF;*/
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]
			                   {PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SYS_ID()});
			  
				if(resultSet.next()){
					M_DUMMY_X = resultSet.getString(1);
				}
				
			     /*IF C1%FOUND THEN
				       	  STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,'Enter the required fields');
						      RAISE FORM_TRIGGER_FAILURE;*/
			    /* ELSE
				     			:BP.B_PROCESSING_MSG    := 'Approval  Processing  Wait ... '; 
							    SET_ITEM_PROPERTY('BP.B_PROCESSING_MSG',VISIBLE,PROPERTY_TRUE);
						      SYNCHRONIZE;
						      SET_APPLICATION_PROPERTY(CURSOR_STYLE,'BUSY') ;
						      	
			   				 BEGIN*/
				new P9ILPK_RECEIPT_TRANSFER().APPROVE_RECEIPT_TRANS(PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SYS_ID());
				           //GO_ITEM('PT_IL_RECEIPT_TRANS_HDR.RTH_SRC_POL_NO');
					CommonUtils.setGlobalObject("GLOBAL.M_RTH_SYS_ID",PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_SYS_ID()) ;
					new PT_IL_RECEIPT_TRANS_DTL_HELPER().executeQuery(compositeAction);
					
								 //  STD_MESSAGE_ROUTINE(91071,:CTRL.M_LANG_CODE);
					PT_IL_RECEIPT_TRANS_HDR_BEAN.setUI_M_STATUS("Approved");
					compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().setUPDATE_ALLOWED(false);
					compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().setDELETE_ALLOWED(false);
					compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().setUPDATE_ALLOWED(false);
					compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().setDELETE_ALLOWED(false);
				           /*SET_BLOCK_PROPERTY('PT_IL_RECEIPT_TRANS_HDR',UPDATE_ALLOWED,PROPERTY_FALSE);
									 SET_BLOCK_PROPERTY('PT_IL_RECEIPT_TRANS_HDR',DELETE_ALLOWED,PROPERTY_FALSE);
								   SET_BLOCK_PROPERTY('PT_IL_RECEIPT_TRANS_DTL',UPDATE_ALLOWED,PROPERTY_FALSE);
									 SET_BLOCK_PROPERTY('PT_IL_RECEIPT_TRANS_DTL',DELETE_ALLOWED,PROPERTY_FALSE);*/
							   		  
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
				       

	}
}
