package com.iii.pel.forms.PILM052_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;



import com.adventnet.swissql.b.a.h;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILP001_APAC.DB_PROCEDURES;
import com.iii.pel.forms.PILP002_APAC.DB_Procedures;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PM_DEPT_DRCR_LINK_HELPER {
	
	public void preInsert(PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN)throws Exception{
		try {
			L_UNIQUE_RANGE(PM_DEPT_DRCR_LINK_BEAN);
			PM_DEPT_DRCR_LINK_BEAN.setDDL_CR_DT(new CommonUtils().getCurrentDate());
			PM_DEPT_DRCR_LINK_BEAN.setDDL_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void L_UNIQUE_RANGE(PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN)throws Exception{
		Integer M_TEMP = null;
		String C1 = " SELECT 1" +
				" FROM   PM_DEPT_DRCR_LINK" +
				" WHERE  PM_DEPT_DRCR_LINK.DDL_TXN_TYPE_TO >= ? " +
				" AND    PM_DEPT_DRCR_LINK.DDL_TXN_TYPE_FM <= ? " +
				" AND    PM_DEPT_DRCR_LINK.DDL_TXN_TYPE_TO >= ? " +
				" AND    PM_DEPT_DRCR_LINK.DDL_TXN_TYPE_FM <= ? " +
				" AND    PM_DEPT_DRCR_LINK.DDL_DIVN_CODE = ? " +
				" AND    PM_DEPT_DRCR_LINK.DDL_DEPT_CODE = ? ";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{PM_DEPT_DRCR_LINK_BEAN.getDDL_TXN_TYPE_FM(), PM_DEPT_DRCR_LINK_BEAN.getDDL_TXN_TYPE_FM(), PM_DEPT_DRCR_LINK_BEAN.getDDL_TXN_TYPE_TO(),  PM_DEPT_DRCR_LINK_BEAN.getDDL_TXN_TYPE_TO(), PM_DEPT_DRCR_LINK_BEAN.getDDL_DIVN_CODE(), PM_DEPT_DRCR_LINK_BEAN.getDDL_DEPT_CODE()};
			resultSet = handler.executeSelectStatement(C1, connection,values);
			if(resultSet.next()){
				M_TEMP = resultSet.getInt(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "1033"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public void postQuery(PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN)throws Exception {
		Double M_FM_TXN_VAL = 0.0;
		Double M_TO_TXN_VAL = 0.0;
		Double M_PC_VALUE  = 0.0;
		ArrayList<String> pList = new ArrayList<String>();
		String txnName = null;
		try{
			pList = DBProcedures.callP_VAL_SYSTEM("TXNCD_TYPE",
		                       PM_DEPT_DRCR_LINK_BEAN.getDDL_TXN_TYPE_FM(),
		                       PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_FM_DESC(),
		                       "N",
		                       CommonUtils.getProcedureValue(M_FM_TXN_VAL));
			if(!pList.isEmpty() && pList.size() > 0){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_FM_DESC(pList.get(0));
			}
			pList.clear();
			
			
			pList = DBProcedures.callP_VAL_SYSTEM("TXNCD_TYPE",
		                 PM_DEPT_DRCR_LINK_BEAN.getDDL_TXN_TYPE_TO(),
		   	             PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_TO_DESC(),
		                 "N",
		                 CommonUtils.getProcedureValue(M_TO_TXN_VAL));
			if(!pList.isEmpty() && pList.size() > 0){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_TO_DESC(pList.get(0));
			}
			pList.clear();
			
			pList = new DBProcedures().callP_VAL_DIVN(PM_DEPT_DRCR_LINK_BEAN.getDDL_DIVN_CODE(),
										"N",
		              					"N");
			if(!pList.isEmpty() && pList.size() > 0){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_DIVN_NAME(pList.get(0));
			}
			pList.clear();
			
			pList = new DBProcedures().callP_VAL_DEPT(PM_DEPT_DRCR_LINK_BEAN.getDDL_DIVN_CODE(),
					PM_DEPT_DRCR_LINK_BEAN.getDDL_DEPT_CODE(),
					"N",
  					"N");
			if(!pList.isEmpty() && pList.size() > 0){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_DEPT_NAME(pList.get(0));
			}
			pList.clear();
			
			
			txnName =  DBProcedures.L_VAL_TXN(PM_DEPT_DRCR_LINK_BEAN.getDDL_DR_TXN_CODE(),
		             PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_DR_NAME(),
		             "N",
		             "N");			
			if(txnName != null){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_DR_NAME(txnName);
			}
			
			txnName =  DBProcedures.L_VAL_TXN(PM_DEPT_DRCR_LINK_BEAN.getDDL_CR_TXN_CODE(),
		             PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_CR_NAME(),
		             "N",
		             "N");			
			if(txnName != null){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_CR_NAME(txnName);
			}
			
			txnName =  DBProcedures.L_VAL_TXN(PM_DEPT_DRCR_LINK_BEAN.getDDL_RCT_TXN_CODE(),
		             PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_RCT_NAME(),
		             "N",
		             "N");			
			if(txnName != null){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_RCT_NAME(txnName);
			}
			
			
			txnName =  DBProcedures.L_VAL_TXN(PM_DEPT_DRCR_LINK_BEAN.getDDL_PAY_TXN_CODE(),
		             PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_PAY_NAME(),
		             "N",
		             "N");			
			if(txnName != null){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_PAY_NAME(txnName);
			}
			
			txnName =  DBProcedures.L_VAL_TXN(PM_DEPT_DRCR_LINK_BEAN.getDDL_JV_TXN_CODE(),
		             PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_JV_NAME(),
		             "N",
		             "N");			
			if(txnName != null){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_JV_NAME(txnName);
			}
			//commented by mohan
			/*pList = new DBProcedures().P_VAL_CODES("IL_PVOU_DTYP",
										PM_DEPT_DRCR_LINK_BEAN.getDDL_DEPT_CODE(),
										PM_DEPT_DRCR_LINK_BEAN.getUI_M_DEPT_NAME(),
										"L",
										"E",
										CommonUtils.getProcedureValue(M_PC_VALUE));
			if(!pList.isEmpty() && pList.size() > 0){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_DEPT_NAME(pList.get(0));
			}*/
			pList.clear();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void LOAD_FRZ_UNFRZ_LABEL(){
		//('DUMMY.M_BUT_FRZ','PM_DEPT_DRCR_LINK.DDL_FRZ_FLAG');
	}

	public void whenValidateDDL_DIVN_CODE(PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN)throws Exception{
		ArrayList<String> pList = new ArrayList<String>();
		try{
			pList = new DBProcedures().callP_VAL_DIVN(PM_DEPT_DRCR_LINK_BEAN.getDDL_DIVN_CODE(),
		                    "N",
		           			"E");
			if(!pList.isEmpty() && pList.size() > 0){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_DIVN_NAME(pList.get(0));
		}
			PM_DEPT_DRCR_LINK_BEAN.setDDL_DEPT_CODE(PM_DEPT_DRCR_LINK_BEAN.getDDL_DEPT_CODE());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateDDL_DEPT_CODE(PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN)throws Exception{
		ArrayList<String> pList = new ArrayList<String>();
		try{
			pList = new DBProcedures().callP_VAL_DEPT(PM_DEPT_DRCR_LINK_BEAN.getDDL_DIVN_CODE(),
							PM_DEPT_DRCR_LINK_BEAN.getDDL_DEPT_CODE(),
							"L",
							"E");
			if(!pList.isEmpty() && pList.size() > 0){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_DEPT_NAME(pList.get(0));
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidateDDL_DR_TXN_CODE(PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN)throws Exception{
		String txnName = null;
		try{
			txnName = DBProcedures.L_VAL_TXN(PM_DEPT_DRCR_LINK_BEAN.getDDL_DR_TXN_CODE(),
							PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_DR_NAME(),
							"L",
							"E");
			if(txnName != null){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_DR_NAME(txnName);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidateDDL_CR_TXN_CODE(PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN)throws Exception{
		String txnName = null;
		try{
			txnName =  DBProcedures.L_VAL_TXN(PM_DEPT_DRCR_LINK_BEAN.getDDL_CR_TXN_CODE(),
									PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_CR_NAME(),
									"N",
									"N");			
			if(txnName != null){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_CR_NAME(txnName);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenValidateDDL_RCT_TXN_CODE(PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN)throws Exception{
		String txnName = null;
		try{
			txnName =  DBProcedures.L_VAL_TXN(PM_DEPT_DRCR_LINK_BEAN.getDDL_RCT_TXN_CODE(),
									PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_CR_NAME(),
									"N",
									"N");			
			if(txnName != null){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_RCT_NAME(txnName);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidateDDL_PAY_TXN_CODE(PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN)throws Exception{
		String txnName = null;
		try{
			txnName =  DBProcedures.L_VAL_TXN(PM_DEPT_DRCR_LINK_BEAN.getDDL_PAY_TXN_CODE(),
									PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_PAY_NAME(),
									"L",
									"E");			
			if(txnName != null){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_PAY_NAME(txnName);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidateDDL_JV_TXN_CODE(PM_DEPT_DRCR_LINK PM_DEPT_DRCR_LINK_BEAN)throws Exception{
		String txnName = null;
		try{
			txnName =  DBProcedures.L_VAL_TXN(PM_DEPT_DRCR_LINK_BEAN.getDDL_JV_TXN_CODE(),
									PM_DEPT_DRCR_LINK_BEAN.getUI_M_TXN_JV_NAME(),
									"L",
									"E");			
			if(txnName != null){
				PM_DEPT_DRCR_LINK_BEAN.setUI_M_TXN_JV_NAME(txnName);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}



