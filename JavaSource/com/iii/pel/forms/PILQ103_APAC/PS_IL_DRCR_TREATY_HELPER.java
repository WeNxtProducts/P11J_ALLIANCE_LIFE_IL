package com.iii.pel.forms.PILQ103_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_DRCR_TREATY_HELPER {
	
	/**
	 * @author 53058
	 * Feb 7, 2009 12:01:59 PM
	 * @throws Exception 
	 *
	 *
	 * @throws ValidatorException
	 */
	public void preForm() throws Exception  {
		try {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String callingForm = (String) sessionMap.get("CALLING_FORM");
			if(callingForm==null){
				sessionMap.put("GLOBAL.M_PRIVILEGE","YYY");
				sessionMap.put("GLOBAL.M_FAILURE","FALSE");
			}
//		STD_PRE_FORM
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * @author 53058
	 * Feb 7, 2009 12:02:07 PM
	 * @throws Exception 
	 *
	 *
	 * @throws ValidatorException
	 */
	public void whenNewFormInstance(PS_IL_DRCR_TREATY_ACTION PS_IL_DRCR_TREATY_ACTION_BEAN) throws Exception  {
		try {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String callingForm = (String) sessionMap.get("CALLING_FORM");
			PS_IL_DRCR_TREATY_ACTION treatyAction = PILQ103_APAC_ACTION_INSTANCE.getPS_IL_DRCR_TREATY_ACTION_INSTANCE();
			if(callingForm!=null && callingForm.startsWith("PILQ")){
				String M_CUST_CODE = (String) sessionMap.get("GLOBAL.M_CUST_CODE");
				treatyAction.getPS_IL_DRCR_TREATY_BEAN().setUI_M_CUST_CODE(M_CUST_CODE);
				M_CUST_CODEWhenValidateItem(PS_IL_DRCR_TREATY_ACTION_BEAN);
				PS_IL_DRCR_TREATY_ACTION_BEAN.getCOMP_BUT_FETCH().setRendered(false);
				PS_IL_DRCR_TREATY_ACTION_BEAN.getCOMP_UI_M_CUST_CODE().setReadonly(true);
			}else{
				treatyAction.getPS_IL_DRCR_TREATY_BEAN().setUI_M_CUST_CODE(null);
				PS_IL_DRCR_TREATY_ACTION_BEAN.getCOMP_BUT_GOBACK().setRendered(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * @author 53058
	 * Feb 7, 2009 12:03:08 PM
	 * @throws Exception 
	 * @throws Exception 
	 *
	 *
	 * @throws ValidatorException
	 */
	public void postQuery(PS_IL_DRCR_TREATY drcrTreatyBean) throws Exception  {
		try {
			String DRCR_DRCR_FLAG = drcrTreatyBean.getDRCR_DRCR_FLAG();
			String DRCR_TXN_CODE = drcrTreatyBean.getDRCR_TXN_CODE();
			PS_IL_DRCR_TREATY_ACTION drcrTreatyAction = PILQ103_APAC_ACTION_INSTANCE.getPS_IL_DRCR_TREATY_ACTION_INSTANCE();
			Double M_DRCR_TOT_DR = drcrTreatyAction.getPS_IL_DRCR_TREATY_BEAN().getUI_M_DRCR_TOT_DR();
			Double M_DRCR_TOT_CR = drcrTreatyAction.getPS_IL_DRCR_TREATY_BEAN().getUI_M_DRCR_TOT_CR();
			Double DRCR_LC_AMT = drcrTreatyBean.getDRCR_LC_AMT();
			if(DRCR_DRCR_FLAG!=null && ("D").equalsIgnoreCase(DRCR_DRCR_FLAG) && ("DN").equalsIgnoreCase(DRCR_TXN_CODE)){//DRCR_TXN_CODE,DRCR_DRCR_FLAG
				M_DRCR_TOT_DR = (M_DRCR_TOT_DR==null?0.0:M_DRCR_TOT_DR)+(DRCR_LC_AMT==null?0.0:DRCR_LC_AMT);
				if(M_DRCR_TOT_DR != 0){
				drcrTreatyAction.getPS_IL_DRCR_TREATY_BEAN().setUI_M_DRCR_TOT_DR(M_DRCR_TOT_DR);
				}
			}else if(DRCR_DRCR_FLAG!=null && ("C").equalsIgnoreCase(DRCR_DRCR_FLAG) && ("CN").equalsIgnoreCase(DRCR_TXN_CODE)){
				M_DRCR_TOT_CR = (M_DRCR_TOT_CR==null?0.0:M_DRCR_TOT_CR)+(DRCR_LC_AMT==null?0.0:DRCR_LC_AMT);
				if(M_DRCR_TOT_CR != 0){
				drcrTreatyAction.getPS_IL_DRCR_TREATY_BEAN().setUI_M_DRCR_TOT_CR(M_DRCR_TOT_CR);
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * @author 53058
	 * Feb 7, 2009 12:11:18 PM
	 * @throws Exception 
	 *
	 *
	 * @throws ValidatorException
	 */
	public void whenNewBlockInstance(PS_IL_DRCR_TREATY_ACTION PS_IL_DRCR_TREATY_ACTION_BEAN) throws Exception  {
		try {
			//executeQuery(PS_IL_DRCR_TREATY_ACTION_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * @author 53058
	 * Feb 7, 2009 12:11:56 PM
	 * @throws Exception 
	 * @throws Exception 
	 *
	 *
	 * @throws ValidatorException
	 */
	public void executeQuery(PS_IL_DRCR_TREATY_ACTION treatyAction) throws Exception   {
		String sql_query = "SELECT DRCR_TXN_CODE,DRCR_DOC_NO,DRCR_SEQ_NO,DRCR_DOC_DT,DRCR_INT_DOC_NO," +
				"DRCR_POL_SYS_ID,DRCR_CLM_SYS_ID,DRCR_POL_NO,DRCR_END_NO_IDX,DRCR_END_NO,DRCR_CUST_CODE," +
				"DRCR_MAIN_ACNT_CODE,DRCR_SUB_ACNT_CODE,DRCR_DIVN_CODE,DRCR_DEPT_CODE,DRCR_ANLY_CODE_1," +
				"DRCR_ANLY_CODE_2,DRCR_ACTY_CODE_1,DRCR_ACTY_CODE_2,DRCR_INT_ENT_YN,DRCR_DRCR_FLAG," +
				"DRCR_CURR_CODE,DRCR_FC_AMT,DRCR_LC_AMT,DRCR_NARRATION,DRCR_BL_NARRATION,DRCR_PRINT_YN," +
				"DRCR_POST_YN,DRCR_CR_UID,DRCR_CR_DT,DRCR_DOC_TYPE,DRCR_REMARKS,DRCR_ACNT_YEAR,DRCR_CLAIM_NO " +
				"FROM PS_IL_DRCR_TREATY " +
				"WHERE DRCR_CUST_CODE = ? ";
		
		String M_CUST_CODE = treatyAction.getPS_IL_DRCR_TREATY_BEAN().getUI_M_CUST_CODE();
		treatyAction.getDataList_PS_IL_DRCR_TREATY().clear();
		//treatyAction.getPS_IL_DRCR_TREATY_BEAN().setUI_M_DRCR_TOT_CR(0.0);
		//treatyAction.getPS_IL_DRCR_TREATY_BEAN().setUI_M_DRCR_TOT_DR(0.0);
		/*treatyAction.getCOMP_UI_M_DRCR_TOT_CR().setSubmittedValue(null);
		treatyAction.getCOMP_UI_M_DRCR_TOT_DR().setSubmittedValue(null);*/
		if (M_CUST_CODE!=null) {
			Connection connection = PILQ103_APAC_ACTION_INSTANCE
					.getConnection();
			ResultSet rst = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				rst = handler.executeSelectStatement(sql_query, connection,
						new Object[] { M_CUST_CODE });
				while (rst.next()) {
					PS_IL_DRCR_TREATY drcrTreatyBean = new PS_IL_DRCR_TREATY();
					drcrTreatyBean.setDRCR_TXN_CODE(rst
							.getString("DRCR_TXN_CODE"));
					drcrTreatyBean.setDRCR_DOC_NO(rst.getDouble("DRCR_DOC_NO"));
					drcrTreatyBean.setDRCR_SEQ_NO(rst.getInt("DRCR_SEQ_NO"));
					drcrTreatyBean.setDRCR_DOC_DT(rst.getDate("DRCR_DOC_DT"));
					//			drcrTreatyBean.setDRCR_INT_DOC_NO(rst.getDouble("DRCR_INT_DOC_NO"));                               
					//			drcrTreatyBean.setDRCR_POL_SYS_ID(rst.getDouble("DRCR_POL_SYS_ID"));                               
					//			drcrTreatyBean.setDRCR_CLM_SYS_ID(rst.getDouble("DRCR_CLM_SYS_ID"));                               
					//			drcrTreatyBean.setDRCR_POL_NO(rst.getString("DRCR_POL_NO"));                                       
					//			drcrTreatyBean.setDRCR_END_NO_IDX(rst.getDouble("DRCR_END_NO_IDX"));                               
					drcrTreatyBean.setDRCR_END_NO(rst.getString("DRCR_END_NO"));
					drcrTreatyBean.setDRCR_CUST_CODE(rst
							.getString("DRCR_CUST_CODE"));
					drcrTreatyBean.setDRCR_MAIN_ACNT_CODE(rst
							.getString("DRCR_MAIN_ACNT_CODE"));
					drcrTreatyBean.setDRCR_SUB_ACNT_CODE(rst
							.getString("DRCR_SUB_ACNT_CODE"));
					drcrTreatyBean.setDRCR_DIVN_CODE(rst
							.getString("DRCR_DIVN_CODE"));
					drcrTreatyBean.setDRCR_DEPT_CODE(rst
							.getString("DRCR_DEPT_CODE"));
					drcrTreatyBean.setDRCR_ANLY_CODE_1(rst
							.getString("DRCR_ANLY_CODE_1"));
					drcrTreatyBean.setDRCR_ANLY_CODE_2(rst
							.getString("DRCR_ANLY_CODE_2"));
					drcrTreatyBean.setDRCR_ACTY_CODE_1(rst
							.getString("DRCR_ACTY_CODE_1"));
					drcrTreatyBean.setDRCR_ACTY_CODE_2(rst
							.getString("DRCR_ACTY_CODE_2"));
					//			drcrTreatyBean.setDRCR_INT_ENT_YN(rst.getString("DRCR_INT_ENT_YN"));                               
					drcrTreatyBean.setDRCR_DRCR_FLAG(rst
							.getString("DRCR_DRCR_FLAG"));
					//			drcrTreatyBean.setDRCR_CURR_CODE(rst.getString("DRCR_CURR_CODE"));                                 
					//			drcrTreatyBean.setDRCR_FC_AMT(rst.getDouble("DRCR_FC_AMT"));                                       
					drcrTreatyBean.setDRCR_LC_AMT(rst.getDouble("DRCR_LC_AMT"));
					drcrTreatyBean.setDRCR_NARRATION(rst
							.getString("DRCR_NARRATION"));
					//			drcrTreatyBean.setDRCR_BL_NARRATION(rst.getString("DRCR_BL_NARRATION"));                           
					//			drcrTreatyBean.setDRCR_PRINT_YN(rst.getString("DRCR_PRINT_YN"));                                   
					drcrTreatyBean.setDRCR_POST_YN(rst
							.getString("DRCR_POST_YN"));
					//			drcrTreatyBean.setDRCR_CR_UID(rst.getString("DRCR_CR_UID"));                                       
					//			drcrTreatyBean.setDRCR_CR_DT(rst.getDate("DRCR_CR_DT"));                                           
					//			drcrTreatyBean.setDRCR_DOC_TYPE(rst.getString("DRCR_DOC_TYPE"));                                   
					//			drcrTreatyBean.setDRCR_REMARKS(rst.getString("DRCR_REMARKS"));                                     
					//			drcrTreatyBean.setDRCR_ACNT_YEAR(rst.getDouble("DRCR_ACNT_YEAR"));                                 
					drcrTreatyBean.setDRCR_CLAIM_NO(rst
							.getString("DRCR_CLAIM_NO"));
					postQuery(drcrTreatyBean);
					treatyAction.getDataList_PS_IL_DRCR_TREATY().add(
							drcrTreatyBean);
				}
				/*treatyAction.getCOMP_UI_M_DRCR_TOT_CR().resetValue();
				treatyAction.getCOMP_UI_M_DRCR_TOT_DR().resetValue();*/
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} finally {
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
				}
			}
		}
	}
	
	public List<PS_IL_DRCR_TREATY> M_CUST_CODELov(String value) throws Exception {
		/*
		 * 
		 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105
		 * 
		 * String sql_C1 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME " +
				"FROM PM_CUSTOMER " +
				"WHERE CUST_CLASS IN (" +
				"SELECT CCLAS_CODE " +
				"FROM PM_CUST_CLASS, PP_SYSTEM " +
				"WHERE INSTR(PS_CODE_DESC,'''' || DECODE(PS_VALUE, 2, CCLAS_CODE, CCLAS_TYPE) || '''') <> 0 " +
				"AND PS_CODE = 'REINS' " +
				"AND PS_TYPE = 'LOV_CUST') " +
				"AND CUST_FRZ_FLAG = 'N' " +
				"AND ((CUST_CODE IN (" +
				"SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN " +
				"WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE) " +
				"AND NVL(CUST_APPL_ALL_BRAN_YN,'N') = 'N')) " +
				"OR (NVL(CUST_APPL_ALL_BRAN_YN,'N') = 'Y')) AND CUST_CODE LIKE NVL(?, CUST_CODE)";*/
		
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105*/
		String sql_C1 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME " +
				"FROM PM_CUSTOMER " +
				"WHERE CUST_CLASS IN (" +
				"SELECT CCLAS_CODE " +
				"FROM PM_CUST_CLASS, PP_SYSTEM " +
				"WHERE INSTR(PS_CODE_DESC,'''' || DECODE(PS_VALUE, 2, CCLAS_CODE, CCLAS_TYPE) || '''') <> 0 " +
				"AND PS_CODE = 'REINS' " +
				"AND PS_TYPE = 'LOV_CUST') " +
				"AND CUST_FRZ_FLAG = 'N' " +
				"AND ((CUST_CODE IN (" +
				"SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN " +
				"WHERE UPPER(CDIV_DIVN_CODE) = NVL (UPPER(?), CDIV_DIVN_CODE) " +
				"AND NVL(CUST_APPL_ALL_BRAN_YN,'N') = 'N')) " +
				"OR (NVL(CUST_APPL_ALL_BRAN_YN,'N') = 'Y')) AND UPPER(CUST_CODE) LIKE NVL(UPPER(?), CUST_CODE)";
		/*end*/
		String M_CUST_CODE = null;
		ResultSet rst = null;
		List<PS_IL_DRCR_TREATY> treatyList = null;
		if(value!=null && !(value.isEmpty())){
			if(value.equals("*")){
				M_CUST_CODE = "%";
			}else{
				M_CUST_CODE =value + "%";
			}
		}
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String M_DIVN_CODE = (String) sessionMap.get("GLOBAL.M_DIVN_CODE");
		Connection connection = PILQ103_APAC_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		try {
			rst = handler.executeSelectStatement(sql_C1, connection, new Object[]{M_DIVN_CODE, M_CUST_CODE});
			treatyList = new ArrayList<PS_IL_DRCR_TREATY>();
			while(rst.next()){
				PS_IL_DRCR_TREATY treatyBean = new PS_IL_DRCR_TREATY();
				treatyBean.setUI_M_CUST_CODE(rst.getString(1));
				treatyBean.setUI_M_CUST_NAME(rst.getString(2));
				treatyList.add(treatyBean);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try{
				CommonUtils.closeCursor(rst);
			}catch(Exception e){
			}
		}
		return treatyList;
	}
	
	public void M_CUST_CODEWhenValidateItem(PS_IL_DRCR_TREATY_ACTION PS_IL_DRCR_TREATY_ACTION_BEAN) throws Exception {
		String sql_C1 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE=?";
		Connection connection = null;
		PS_IL_DRCR_TREATY_ACTION treatyAction = null;
		String M_CUST_CODE = null;
		ResultSet rst = null;
		String M_CUST_NAME = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = PILQ103_APAC_ACTION_INSTANCE.getConnection();
			treatyAction = PILQ103_APAC_ACTION_INSTANCE.getPS_IL_DRCR_TREATY_ACTION_INSTANCE();
			M_CUST_CODE = treatyAction.getPS_IL_DRCR_TREATY_BEAN().getUI_M_CUST_CODE();
			rst = handler.executeSelectStatement(sql_C1, connection, new Object[]{M_CUST_CODE});
			while(rst.next()){
				M_CUST_NAME = rst.getString(1);
			}
			treatyAction.getPS_IL_DRCR_TREATY_BEAN().setUI_M_CUST_NAME(M_CUST_NAME);
			treatyAction.getCOMP_UI_M_CUST_NAME().setSubmittedValue(M_CUST_NAME);
			executeQuery(PS_IL_DRCR_TREATY_ACTION_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try{
				CommonUtils.closeCursor(rst);
			}catch(Exception e){
			}
		}
	}

}
