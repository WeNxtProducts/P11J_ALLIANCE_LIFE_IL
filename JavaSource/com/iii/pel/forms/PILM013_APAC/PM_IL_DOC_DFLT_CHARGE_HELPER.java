package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.faces.component.UIInput;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_DOC_DFLT_CHARGE_HELPER extends CommonAction {
	private PM_IL_DOC_DFLT_CHARGE_DELEGATE pm_il_doc_dflt_charge_delegate = null;
	String bundleName = PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH;

	/**
	 * Charge Code When Validate Item
	 * @param chargeCode
	 * @param pm_il_doc_dflt_charge_action
	 * @throws Exception 
	 */
	public void DDCHG_CODE_WHEN_VALIDATE_ITEM(String chargeCode,
			PM_IL_DOC_DFLT_CHARGE_ACTION pm_il_doc_dflt_charge_action,
			PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge) throws Exception {
		pm_il_doc_dflt_charge_delegate = new PM_IL_DOC_DFLT_CHARGE_DELEGATE();
		try {
			/* P_VAL_CODES procedure calling */
			pm_il_doc_dflt_charge.setUI_M_DDCHG_CODE_DESC((DBProcedures.callP_VAL_CODES("IL_CHARGE", chargeCode, null, "E", null)).get(0));

			if (chargeCode != null) {
				pm_il_doc_dflt_charge_delegate.chargeCodeValidation(chargeCode,
						pm_il_doc_dflt_charge_action, pm_il_doc_dflt_charge);
			}
			pm_il_doc_dflt_charge.setDDCHG_CODE(chargeCode);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Share % When Validate Item
	 * 
	 * @param sharePerc
	 * @param pm_il_doc_dflt_charge_action
	 * @throws Exception 
	 */
	public void DDCHG_CUST_SHARE_PERC_WHEN_VALIDATE_ITEM(String sharePerc,
			PM_IL_DOC_DFLT_CHARGE_ACTION pm_il_doc_dflt_charge_action,
			PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge) throws Exception {
		if (sharePerc != null) {
			double sharePercentage = Double.parseDouble(sharePerc.toString());
			if (sharePercentage < 0 || sharePercentage > 100) {
				throw new Exception(Messages.getString(bundleName, "91014", 
						new Object[]{"Share %",">= 0","and <= 100"}));
			} else {
				System.out.println("Share percentage:::::::::"
						+ sharePercentage);
				pm_il_doc_dflt_charge.setDDCHG_CUST_SHARE_PERC(sharePercentage);
			}
		}
	}

	public void DDCHG_CUST_RATE_PERC_WHEN_VALIDATE_ITEM(Object ratePerc,
			PM_IL_DOC_DFLT_CHARGE_ACTION pm_il_doc_dflt_charge_action,
			PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge) throws Exception {
		if (ratePerc != null) {
			double ratePercentage = Double.parseDouble(ratePerc.toString());
			if (ratePercentage <= 0) {
				throw new Exception(Messages.getString(bundleName,
						"91014", new Object[]{"RATE PER",">","0"}));
			} else {
				pm_il_doc_dflt_charge.setDDCHG_RATE_PER(ratePercentage);
			}
		}
	}

	public void DDCHG_CUST_RATE_WHEN_VALIDATE_ITEM(Object rateObj,
			PM_IL_DOC_DFLT_CHARGE_ACTION pm_il_doc_dflt_charge_action)
			throws Exception {
		if (rateObj != null) {
			double rate = Double.parseDouble(rateObj.toString());
			
			/*Commentted &Modified by saritha on 24-04-2018 for KIC Rate greater than or equal to 0*/
			
			/*if (rate <= 0) {*/
			if (rate < 0) {
				/*throw new Exception(Messages
						.getString(bundleName, "91014", new Object[]{"RATE ",">","0"}));*/
				
				throw new Exception(Messages
						.getString(bundleName, "91014", new Object[]{"RATE ",">=","0"}));
				
			/*End*/
				
			} else {
				int rowIndex = pm_il_doc_dflt_charge_action.getDataTable()
						.getRowIndex();
				if (rowIndex >= 0) {
					PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge = (PM_IL_DOC_DFLT_CHARGE) pm_il_doc_dflt_charge_action
							.getDataTableList().get(rowIndex);
					pm_il_doc_dflt_charge.setDDCHG_RATE(rate);
				}
			}
		}
	}

	public void DDCHG_SR_NO_WHEN_VALIDATE_ITEM(PM_IL_DOC_DFLT_CHARGE PM_IL_DOC_DFLT_CHARGE_BEAN) throws Exception {
		try{
		if (PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_SR_NO() != null) {
			if (PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_SR_NO() <= 0) {
				throw new Exception(Messages.getString(bundleName, "91003"));
			} else {
				//delegate.L_DUP_SRLNO(blockName, rowIndex);
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	public void DDCHG_EFF_FM_DT_WHEN_VALIDATE_ITEM(Date fromdate, Date toDate,
			PM_IL_DOC_DFLT_CHARGE_ACTION pm_il_doc_dflt_charge_action,
			PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge) throws Exception {

		if (fromdate != null && toDate != null) {
			if (fromdate.after(toDate)) {
				throw new Exception(Messages.getString(bundleName, "91001"));
			} else {
				pm_il_doc_dflt_charge.setDDCHG_EFF_FM_DT(fromdate);
			}
		}

	}

	public void DDCHG_EFF_TO_DT_WHEN_VALIDATE_ITEM(Date fromdate, Date toDate,
			PM_IL_DOC_DFLT_CHARGE_ACTION pm_il_doc_dflt_charge_action,
			PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge) throws Exception {
		if (fromdate != null && toDate != null) {
			if (fromdate.after(toDate)) {
				throw new Exception(Messages.getString(bundleName, "91001"));
			} else {
				pm_il_doc_dflt_charge.setDDCHG_EFF_TO_DT(toDate);

			}
		}

		pm_il_doc_dflt_charge.setDDCHG_EFF_TO_DT(toDate);
	}

	public void callErrorMap(UIInput input) {
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	/*added by nathiya for disabling tariffcode*/
	
	
	public void WHEN_VALIDATE_ITEM_DDCHG_APPLIED_ON(
			PM_IL_DOC_DFLT_CHARGE_ACTION pm_il_doc_dflt_charge_action){
		PM_IL_DOC_DFLT_CHARGE pm_il_doc_dflt_charge = pm_il_doc_dflt_charge_action.getPM_IL_DOC_DFLT_CHARGE_BEAN();
		if("5".equals(pm_il_doc_dflt_charge.getDDCHG_APPLIED_ON())){
			System.out.println("tariff value ***********************"+pm_il_doc_dflt_charge.getDDCHG_APPLIED_ON());
			pm_il_doc_dflt_charge_action.getCOMP_DDCHG_DS_CHG_TAR_CODE().setDisabled(false);
			pm_il_doc_dflt_charge_action.getCOMP_DDCHG_DS_CHG_TAR_CODE().setRequired(true);

	
}else{
	
	pm_il_doc_dflt_charge_action.getCOMP_DDCHG_DS_CHG_TAR_CODE().setDisabled(true);
	pm_il_doc_dflt_charge_action.getCOMP_DDCHG_DS_CHG_TAR_CODE().setRequired(false);
	
}
		
		/*end*/
		
	}
	
	/*Added by Raja on 18-3-2016 for Product Code From and To field addtion*/
	
	public void DDCHG_PROD_CODE_FM_WHEN_VALIDATE_ITEM(
			PM_IL_DOC_DFLT_CHARGE PM_IL_DOC_DFLT_CHARGE_BEAN) throws Exception {
	String CURSOR_C3 = "select PROD_CODE,PROD_DESC from PM_IL_PRODUCT";
	String M_FLAG = null;
	ResultSet resultSet = null;
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	try {
		connection = CommonUtils.getConnection();
		resultSet = handler.executeSelectStatement(CURSOR_C3, connection);
		while (resultSet.next()) {
			if (PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_PROD_CODE_FM().equals(
					resultSet.getString(1))) {
				PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_PROD_CODE_FM_DESC(resultSet
						.getString(2));
				M_FLAG = "Y";
				break;
			} else {
				M_FLAG = "N";
			}
			

		}

		if ("N".equals(M_FLAG)
				&& PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_PROD_CODE_FM()!= "S") {
			throw new Exception((Messages.getString(
					PELConstants.pelErrorMessagePath, "71254")));
		}

	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (DBException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
}
	
	
	
	

	
	
		public void DDCHG_PROD_CODE_TO_WHEN_VALIDATE_ITEM(
				PM_IL_DOC_DFLT_CHARGE PM_IL_DOC_DFLT_CHARGE_BEAN) throws 

Exception {
			System.out.println("sankar DDCHG_PROD_CODE_TO_WHEN_VALIDATE_ITEM ");
		String CURSOR_C3 = "select PROD_CODE,PROD_DESC from PM_IL_PRODUCT";
		String M_FLAG = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection);
			while (resultSet.next()) {
				if (PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_PROD_CODE_TO().equals(
						resultSet.getString(1))) {
					

PM_IL_DOC_DFLT_CHARGE_BEAN.setDDCHG_PROD_CODE_TO_DESC(resultSet
							.getString(2));
					M_FLAG = "Y";
					break;
				} else {
					M_FLAG = "N";
				}
			}

			if ("N".equals(M_FLAG)
					&& PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_PROD_CODE_TO()!= 

"S") {
				throw new Exception((Messages.getString(
						PELConstants.pelDateAndTimeFormat, "71254")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		

System.out.println("sankar"+PM_IL_DOC_DFLT_CHARGE_BEAN.getDDCHG_PROD_CODE_TO_DESC());
	}
		
		/*End*/
		
}
