package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PT_IL_POL_CHARGE_HELPER {


	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_POL_CHARGE_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_POL_CHARGE> dataList = compositeAction.
		getPT_IL_POL_CHARGE_ACTION_BEAN().getDataList_PT_IL_POL_CHARGE();
		if(dataList!=null && dataList.size() > 0){
			PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN = dataList.get(0);
			PT_IL_POL_CHARGE_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN()
			.setPT_IL_POL_CHARGE_BEAN(PT_IL_POL_CHARGE_BEAN);
		}
	}
	public void postQuery(PT_IL_POL_CHARGE chargeBean,PT_IL_POLICY policyBean) throws Exception{
		ArrayList<String> list = null;
		DBProcedures procedures = new  DBProcedures();
		try {
			list = procedures.P_VAL_CODES("IL_CHARGE",chargeBean.getPOC_CHRG_CODE(),
					chargeBean.getUI_M_POC_CHARGE_DESC(),"N","N",null);
			if (list != null && !list.isEmpty()) {
				if (list.get(0)!= null) {
					chargeBean.setUI_M_POC_CHARGE_DESC(list.get(0));
				}
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenCreateRecord(PT_IL_POL_CHARGE chargeBean){
		chargeBean.setPOC_APPLIED_ON("1"); 
		chargeBean.setPOC_APPLY_PERIOD("P");
		chargeBean.setPOC_CUST_SHARE_PERC(100.00);
		chargeBean.setPOC_TYPE("C");
		
	}


	public void whenNewBlockInstance(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_CHARGE_ACTION chargeAction = compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN();
		PT_IL_POL_CHARGE_DELEGATE delegate = new PT_IL_POL_CHARGE_DELEGATE();
		try {
			if ("012".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000")) ||
					"007".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000")) 
					&& policyBean.getPOL_STATUS() != "A" && policyBean.getPOL_APPRV_STATUS() != "A" 
						&& "N".equals(policyBean.getPOL_FRZ_FLAG())) {
				chargeAction.setINSERT_ALLOWED(false);
				chargeAction.setUPDATE_ALLOWED(true);
				chargeAction.setDELETE_ALLOWED(false);
			}
			delegate.executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}   


	}

	public void keyDelRec(PT_IL_POL_CHARGE chargeBean,PT_IL_POLICY policyBean){
		if (policyBean.getPOL_END_TYPE() !=  null) {
			chargeBean.setPOC_FC_VALUE(0.00);
			chargeBean.setPOC_LC_VALUE(0.00);
		}
	}

	public void preUpdate(PT_IL_POL_CHARGE chargeBean,CTRL ctrlBean) throws Exception{
		try {
			chargeBean.setPOC_UPD_DT(new CommonUtils().getCurrentDate());
			chargeBean.setPOC_UPD_UID(ctrlBean.getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void preInsert(PT_IL_POL_CHARGE chargeBean,CTRL ctrlBean,PT_IL_POLICY policyBean) throws Exception{

		String  CURSOR_C1 = "SELECT PIL_POC_SYS_ID.NEXTVAL FROM DUAL ";
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			localProcedure.IL_UNIQUE_CHARGE_CODE(chargeBean.getPOC_CHRG_CODE(), 
					chargeBean.getPOC_POL_SYS_ID(),chargeBean.getROWID());
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				chargeBean.setPOC_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			chargeBean.setPOC_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			chargeBean.setPOC_CR_DT(new CommonUtils().getCurrentDate());
			chargeBean.setPOC_CR_UID(ctrlBean.getUSER_ID());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void POC_CHRG_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE chargeBean) throws Exception{
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			localProcedure.IL_UNIQUE_CHARGE_CODE(chargeBean.getPOC_CHRG_CODE(),
					chargeBean.getPOC_POL_SYS_ID(),
					chargeBean.getROWID());
			if (chargeBean.getPOC_CHRG_CODE() !=  null) {
				list =  procedures.P_VAL_CODES("IL_CHARGE",chargeBean.getPOC_CHRG_CODE() ,
						chargeBean.getUI_M_POC_CHARGE_DESC(),"N","E",null);
				chargeBean.setUI_M_POC_CHARGE_DESC(list.get(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POC_RATE_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE chargeBean){
		if (chargeBean.getPOC_RATE() <= 0) {
			throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "71043")));
		}
	}
	public void POC_RATE_PER_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE chargeBean){
		
		if (chargeBean.getPOC_RATE_PER() <= 0) {
			throw new ValidatorException(new FacesMessage(Messages.getString(PELConstants.pelErrorMessagePath, "71043")));
		}
	}

	public void POC_APPLIED_ON_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE chargeBean,
			PT_IL_POLICY policyBean,DUMMY dummyBean) throws Exception{
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;


		try {
			if ("3".equals(chargeBean.getPOC_APPLIED_ON())) {
				/*Added condition by ganeshn on  25-07-2017, as suggested by siva ZBILQC-1732654*/
				if(!chargeBean.getPOC_APPLY_PERIOD().equalsIgnoreCase("F")){
				chargeBean.setPOC_FC_VALUE(CommonUtils.nvl(chargeBean.getPOC_RATE(),0) / CommonUtils.nvl(chargeBean.getPOC_RATE_PER(),0));
				}
				/*end*/
				list =  procedures.P_VAL_ROUND_AMT(policyBean.getPOL_CUST_CURR_CODE(),chargeBean.getPOC_FC_VALUE().toString(),"R");
				if(list.get(0) !=null)
				    chargeBean.setPOC_FC_VALUE(Double.parseDouble(list.get(0)));
				chargeBean.setPOC_LC_VALUE(chargeBean.getPOC_FC_VALUE() * policyBean.getPOL_CUST_EXCH_RATE());
				list1 = procedures.P_VAL_ROUND_AMT(dummyBean.getUI_M_BASE_CURR(),chargeBean.getPOC_LC_VALUE().toString(), "R");
				if(list1.get(0)!=null)
				    chargeBean.setPOC_LC_VALUE(Double.parseDouble(list1.get(0)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POC_CUST_SHARE_PERC_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE chargeBean){
		
		/*MOdified by Janani on 12.07.2017 for ZBILQC-1731616*/
		/*if (chargeBean.getPOC_CUST_SHARE_PERC() <= 0) {*/
		
		if (chargeBean.getPOC_CUST_SHARE_PERC() < 0) {
			
		/*ENd*/
			throw new ValidatorException(new FacesMessage (Messages.getString(PELConstants.pelErrorMessagePath, "71043")));
		}
		if (chargeBean.getPOC_CUST_SHARE_PERC() > 100) {
			throw new ValidatorException(new FacesMessage (Messages.getString(PELConstants.pelErrorMessagePath, "71017")));
		}
	}
}
