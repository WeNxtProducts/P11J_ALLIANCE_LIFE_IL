package com.iii.pel.forms.PILP060_APAC;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {
	
	public void pilp060_apac_dummy_ui_m_prod_code_fm_when_validate_item(String fromProductCode) throws Exception {
		System.out
				.println("PILP021_DUMMY_HELPER.pilp060_apac_dummy_ui_m_fm_prod_code_when_validate_item()");
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		DUMMY_ACTION actionBean=compositeActionBean.getDUMMY_ACTION_BEAN();
		
		if(fromProductCode==null|| fromProductCode.trim().length()==0){
			
			System.out.println("product code value is "+fromProductCode+" Setting from product code value to 0");
			
			actionBean.getDUMMY_BEAN().setUI_M_PROD_CODE_FM("0");
			actionBean.getDUMMY_BEAN().setUI_M_PROD_FM_DESC("");
			
			actionBean.getCOMP_UI_M_PROD_CODE_FM().setSubmittedValue(null);
			actionBean.getCOMP_UI_M_PROD_FM_DESC().setValue(null);
			
			actionBean.getCOMP_UI_M_PROD_CODE_FM().setSubmittedValue(null);
			actionBean.getCOMP_UI_M_PROD_FM_DESC().setSubmittedValue(null);
			
			/*if(fromProductCode.equals("0")){
				actionBean.getDUMMY_BEAN().setUI_M_PROD_CODE_TO("zzzzzzzzzz");					
				actionBean.getDUMMY_BEAN().setUI_M_PROD_TO_DESC("");
			}else{
				actionBean.getDUMMY_BEAN().setUI_M_PROD_CODE_TO(fromProductCode);
				actionBean.getDUMMY_BEAN().setUI_M_PROD_TO_DESC
					((String)actionBean.getCOMP_UI_M_PROD_FM_DESC().getSubmittedValue());
				
			}
			
			actionBean.getCOMP_UI_M_PROD_CODE_TO().setSubmittedValue(null);
			actionBean.getCOMP_UI_M_PROD_TO_DESC().setSubmittedValue(null);*/
		
			
			
			
			
			
			
		}else{
			if(!"0".equals(fromProductCode)){
				boolean isValid=checkProductCode(fromProductCode);
				if(!isValid){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "91074");
					actionBean.getErrorMap().put("current",message);
					actionBean.getErrorMap().put("toProdCode",message);
					throw new Exception(message);
				}else{
					actionBean.getDUMMY_BEAN().setUI_M_PROD_CODE_FM(fromProductCode);
					actionBean.getErrorMap().clear();
				}
			}
		}
	}
	
	public boolean checkProductCode(String selectedProductCode) throws Exception{
		System.out.println("DUMMY_HELPER.checkProductCode()");
		ResultSet result=null;
		Connection connection=null;

		StringBuffer queryString=new StringBuffer();
		CRUDHandler handler=new CRUDHandler();
		
		queryString.append(PILP060_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_PRODUCT);
		Object [] values=new Object[1];
		
		boolean isValid=true;
		try {
			connection=CommonUtils.getConnection();
			values[0]=selectedProductCode;
			result=handler.executeSelectStatement(queryString.toString(), connection,values);
			if(!result.next()){
				isValid=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			if(result !=null){
				try {
					result.close();
					result=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isValid;
	}
	/**
	 * Called for validating field UI_M_TO_PROD_CODE.Method checks if UI_M_TO_PROD_CODE
	 * is null if it is null it sets the value according to value in field  
	 * UI_M_FM_PROD_CODE. if value in FM_CODE is 0 then TO_CODE is set to zzzzzzz
	 * else it is set to the value contained in FM_CODE
	 * If value in UI_M_TO_PROD_CODE is not null then the method checks
	 * if it is greater than value in UI_M_FM_PROD_CODE . if not it displays error  
	 * @param toProductCode 
	 * 
	 * @param
	 * @return
	 * @throws Exception 
	 */
	
	public void pilp060_apac_dummy_ui_m_prod_code_to_when_validate_item(String toProductCode) throws Exception  {
		System.out
				.println("PILP021_DUMMY_HELPER.pilp021_dummy_ui_m_to_prod_code_when_validate_item()");
		
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		DUMMY_ACTION actionBean=compositeActionBean.getDUMMY_ACTION_BEAN();
		
		Map<String, String> errMap = actionBean.getErrorMap(); 
		String fromProductCode=actionBean.getDUMMY_BEAN().getUI_M_PROD_CODE_FM();
		List<OracleParameter> resultList=null;
		
		if(toProductCode==null || toProductCode.trim().length()==0){
			
			if(fromProductCode.equals("0")){
				actionBean.getDUMMY_BEAN().setUI_M_PROD_CODE_TO("zzzzzzzzzz");					
				actionBean.getDUMMY_BEAN().setUI_M_PROD_TO_DESC("");
			}else{
				actionBean.getDUMMY_BEAN().setUI_M_PROD_CODE_TO(fromProductCode);
				actionBean.getDUMMY_BEAN().setUI_M_PROD_TO_DESC
					((String)actionBean.getCOMP_UI_M_PROD_FM_DESC().getSubmittedValue());
				
			}
			
			actionBean.getCOMP_UI_M_PROD_CODE_TO().setSubmittedValue(null);
			actionBean.getCOMP_UI_M_PROD_TO_DESC().setSubmittedValue(null);
		}else{
			//procedure call to compare fromCode and toCode
			List<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",fromProductCode);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",toProductCode);
			OracleParameter param3 = new OracleParameter("in3","STRING","OUT","");
			paramList.add(param1);
			paramList.add(param2);	
			paramList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				resultList = procHandler.execute((ArrayList)paramList, utility.getConnection(), "PR_VALIDATE_FM_TO");
				System.out.println("PILP060.to_prod_code action \n--------------- OUTPUTPARAM -------------------\n"+((OracleParameter)resultList.get(0)).getValue()+"\n----------------");
				if(Integer.parseInt(((OracleParameter)resultList.get(0)).getValue())==1){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "10064");
					errMap.put("current",message);
					errMap.put("toProdCode",message);
					throw new Exception(message);
				}else{
					errMap.clear();
				}
				if(!"zzzzzzzzzz".equals(toProductCode)){
					boolean isValid=checkProductCode(toProductCode);
					if(!isValid){
						String message=Messages.getString(PELConstants.pelErrorMessagePath, "91074");
						actionBean.getErrorMap().put("current",message);
						actionBean.getErrorMap().put("toProdCode",message);
						throw new Exception(message);
					}else{
						actionBean.getErrorMap().clear();
						actionBean.getDUMMY_BEAN().setUI_M_PROD_CODE_TO(toProductCode);
					}
				}
			} catch (DBException e1) {
				e1.printStackTrace();
				throw new Exception(e1.getMessage());
			}catch(SQLException e2){
				throw new Exception(e2.getMessage());
				
			}finally{
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),
						FacesContext.getCurrentInstance() , PILP060_APAC_CONSTANTS.FORM_ID, 
						compositeActionBean.getDUMMY_ACTION_BEAN().getWarningMap());
			}
		}
		
	}
	
	public boolean checkPolicyNo(String selectedPolicyNo) throws Exception{
		System.out.println("DUMMY_HELPER.checkPolicyNo()");
		ResultSet result=null;
		Connection connection=null;

		StringBuffer queryString=new StringBuffer();
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		
		queryString.append(PILP060_APAC_SQLQUERY_CONSTANTS.SELECT_PT_IL_POLICY);
		Object [] values=new Object[1];
		
		boolean isValid=true;
		try {
			connection=utility.getConnection();
			values[0]=selectedPolicyNo;
			result=handler.executeSelectStatement(queryString.toString(), connection,values);
			if(!result.next()){
				isValid=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			if(result !=null){
				try {
					result.close();
					result=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isValid;
	}
	
	public void pilp060_apac_dummy_ui_m_pol_no_fm_when_validate_item(String fromPolicyNo) throws Exception {
		System.out
				.println("PILP021_DUMMY_HELPER.pilp021_dummy_ui_m_fm_prop_no_when_validate_item()");
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		DUMMY_ACTION actionBean=compositeActionBean.getDUMMY_ACTION_BEAN();
		
		
		if(fromPolicyNo==null||fromPolicyNo.trim().length()==0){
			
			System.out.println("Pol no value is "+fromPolicyNo+" Setting from pol no value to 0");
			actionBean.getDUMMY_BEAN().setUI_M_POL_NO_FM("0");
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_UI_M_POL_NO_FM().setSubmittedValue(null);
		}else{
			if(!"0".equals(fromPolicyNo)){
				boolean isValid=checkPolicyNo(fromPolicyNo);
				if(!isValid){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "2411");
					actionBean.getErrorMap().put("current",message);
					actionBean.getErrorMap().put("toProdCode",message);
					throw new Exception(message);
				}else{
					actionBean.getErrorMap().clear();
					actionBean.getDUMMY_BEAN().setUI_M_POL_NO_FM(fromPolicyNo);
				}
			}
		}
	}
	
	/**
	 * Called for validating field UI_M_TO_PROP_NO.Method checks if UI_M_TO_PROP_NO
	 * is null if it is null it sets the value according to value in field  
	 * UI_M_FM_PROP_NO. if value in FM_NO is 0 then TO_CODE is set to zzzzzzz
	 * else it is set to the value contained in FM_NO
	 * If value in UI_M_TO_PROP_NO is not null then the method checks
	 * if it is greater than value in UI_M_FM_PROP_NO . if not it displays error  
	 * @param toPolicyNo 
	 * 
	 * @param
	 * @return
	 * @throws Exception  
	 */
	
	public void pilp060_apac_dummy_ui_m_pol_no_to_when_validate_item(String toPolicyNo) throws Exception  {
		
		System.out
				.println("DUMMY_HELPER.pilp060_apac_dummy_ui_m_pol_no_to_when_validate_item()");
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		DUMMY_ACTION actionBean=compositeActionBean.getDUMMY_ACTION_BEAN();
		List resultList=null;
		
		String fromPolicyNo=actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM();
		Map<String, String> errMap = actionBean.getErrorMap(); 
		
		if(toPolicyNo==null || toPolicyNo.trim().length()==0){
			
			if(fromPolicyNo.equals("0")){
				actionBean.getDUMMY_BEAN().setUI_M_POL_NO_TO("zzzzzzzzzz");
				
			}else{
				actionBean.getDUMMY_BEAN().setUI_M_POL_NO_TO(fromPolicyNo);
			}
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_UI_M_POL_NO_TO().setSubmittedValue(null);
			
		}else{
			//procedure call to compare fromCode and toCode
			List<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",fromPolicyNo);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",toPolicyNo);
			OracleParameter param3 = new OracleParameter("in3","STRING","OUT","");
			paramList.add(param1);
			paramList.add(param2);	
			paramList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			
				try {
					resultList = procHandler.execute((ArrayList)paramList, utility.getConnection(), "PR_VALIDATE_FM_TO");
					System.out.println("--------------- OUTPUTPARAM -------------------\n"+((OracleParameter)resultList.get(0)).getValue()+"\n----------------");
					if(Integer.parseInt(((OracleParameter)resultList.get(0)).getValue())==1){
						String message=Messages.getString(PELConstants.pelErrorMessagePath, "10064");
						errMap.put("current",message);
						errMap.put("toPropNo",message);
						throw new Exception(message);
					}else{
						errMap.clear();
					}
					if(!"zzzzzzzzzz".equals(toPolicyNo)){
						boolean isValid=checkPolicyNo(toPolicyNo);
						if(!isValid){
							String message=Messages.getString(PELConstants.pelErrorMessagePath, "2411");
							actionBean.getErrorMap().put("current",message);
							actionBean.getErrorMap().put("toProdCode",message);
							throw new Exception(message);
						}else{
							actionBean.getDUMMY_BEAN().setUI_M_POL_NO_TO(toPolicyNo);
							actionBean.getErrorMap().clear();
						}
					} 
				} catch (DBException e) {
					e.printStackTrace();
				}finally{
					ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),
							FacesContext.getCurrentInstance() , PILP060_APAC_CONSTANTS.FORM_ID, 
							compositeActionBean.getDUMMY_ACTION_BEAN().getWarningMap());
				}
		}	
	}

	
	public void pilp060_apac_dummy_ui_m_bon_code_fm_when_validate_item(String fromBonusCode) throws Exception {
		System.out
				.println("DUMMY_HELPER.pilp060_apac_dummy_ui_m_bon_code_fm_when_validate_item()");
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		DUMMY_ACTION actionBean=compositeActionBean.getDUMMY_ACTION_BEAN();
		if(fromBonusCode==null|| fromBonusCode.trim().length()==0){
			System.out.println("product code value is "+fromBonusCode+" Setting from product code value to 0");
			actionBean.getDUMMY_BEAN().setUI_M_BON_CODE_FM("0");
			actionBean.getDUMMY_BEAN().setUI_M_BON_FM_DESC("");
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_UI_M_BON_CODE_FM().setSubmittedValue(null);
			actionBean.getCOMP_UI_M_BON_FM_DESC().setSubmittedValue(null);
		}else{
			if(!"0".equals(fromBonusCode)){
				boolean isValid=checkBonusCode(fromBonusCode);
				if(!isValid){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "91055");
					actionBean.getErrorMap().put("current",message);
					actionBean.getErrorMap().put("toProdCode",message);
					throw new Exception(message);
				}else{
					actionBean.getDUMMY_BEAN().setUI_M_BON_CODE_FM(fromBonusCode);
					actionBean.getErrorMap().clear();
				}
			}
		}
	}
	
	public boolean checkBonusCode(String selectedBonusCode) throws Exception{
		System.out.println("DUMMY_HELPER.checkBonusCode()");
		ResultSet result=null;
		Connection connection=null;

		StringBuffer queryString=new StringBuffer();
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		
		queryString.append(PILP060_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_BONUS);
		Object [] values=new Object[1];
		
		boolean isValid=true;
		try {
			connection=utility.getConnection();
			values[0]=selectedBonusCode;
			result=handler.executeSelectStatement(queryString.toString(), connection,values);
			if(!result.next()){
				isValid=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			if(result !=null){
				try {
					result.close();
					result=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isValid;
	}
	/**
	 * Called for validating field UI_M_TO_PROD_CODE.Method checks if UI_M_TO_PROD_CODE
	 * is null if it is null it sets the value according to value in field  
	 * UI_M_FM_PROD_CODE. if value in FM_CODE is 0 then TO_CODE is set to zzzzzzz
	 * else it is set to the value contained in FM_CODE
	 * If value in UI_M_TO_PROD_CODE is not null then the method checks
	 * if it is greater than value in UI_M_FM_PROD_CODE . if not it displays error  
	 * @param toBonusCode 
	 * 
	 * @param
	 * @return
	 * @throws Exception 
	 */
	
	public void pilp060_apac_dummy_ui_m_bon_code_to_when_validate_item(String toBonusCode) throws Exception {
		System.out
				.println("PILP021_DUMMY_HELPER.pilp021_dummy_ui_m_to_prod_code_when_validate_item()");
		
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		DUMMY_ACTION actionBean=compositeActionBean.getDUMMY_ACTION_BEAN();
		
		Map<String, String> errMap = actionBean.getErrorMap(); 
		String fromBonusCode=actionBean.getDUMMY_BEAN().getUI_M_BON_CODE_FM();
		List<OracleParameter> resultList=null;
		
		if(toBonusCode==null || toBonusCode.trim().length()==0){
			
			if(fromBonusCode.equals("0")){
				actionBean.getDUMMY_BEAN().setUI_M_BON_CODE_TO("zzzzzzzzzz");					
				actionBean.getDUMMY_BEAN().setUI_M_BON_TO_DESC("");
			}else{
				actionBean.getDUMMY_BEAN().setUI_M_BON_CODE_TO(fromBonusCode);
				actionBean.getDUMMY_BEAN().setUI_M_BON_TO_DESC
					((String)actionBean.getCOMP_UI_M_BON_FM_DESC().getSubmittedValue());
				
			}
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_UI_M_BON_CODE_TO().setSubmittedValue(null);
			actionBean.getCOMP_UI_M_BON_TO_DESC().setSubmittedValue(null);
		}else{
			//procedure call to compare fromCode and toCode
			List<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",fromBonusCode);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",toBonusCode);
			OracleParameter param3 = new OracleParameter("in3","STRING","OUT","");
			paramList.add(param1);
			paramList.add(param2);	
			paramList.add(param3);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				resultList = procHandler.execute((ArrayList)paramList, utility.getConnection(), "PR_VALIDATE_FM_TO");
				System.out.println("PILP060.to_prod_code action \n--------------- OUTPUTPARAM -------------------\n"+((OracleParameter)resultList.get(0)).getValue()+"\n----------------");
				if(Integer.parseInt(((OracleParameter)resultList.get(0)).getValue())==1){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "10064");
					errMap.put("current",message);
					errMap.put("toProdCode",message);
					throw new Exception(message);
				}else{
					errMap.clear();
				}
				if(!"zzzzzzzzzz".equals(toBonusCode)){
					boolean isValid=checkBonusCode(toBonusCode);
					if(!isValid){
						String message=Messages.getString(PELConstants.pelErrorMessagePath, "91055");
						actionBean.getErrorMap().put("current",message);
						actionBean.getErrorMap().put("toProdCode",message);
						throw new Exception(message);
					}else{
						actionBean.getDUMMY_BEAN().setUI_M_BON_CODE_TO(toBonusCode);	
						actionBean.getErrorMap().clear();
					}
				}
			} catch (DBException e1) {
				e1.printStackTrace();
				throw new Exception(e1.getMessage());
			}finally{
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),
						FacesContext.getCurrentInstance() , PILP060_APAC_CONSTANTS.FORM_ID, 
						compositeActionBean.getDUMMY_ACTION_BEAN().getWarningMap());
			}
		}
		
	}
	
	public void pilp060_apac_dummy_ui_m_process_dt_when_validate_item() throws Exception {
		System.out
				.println("DUMMY_HELPER.pilp060_apac_dummy_ui_m_process_dt_when_validate_item()");

		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();

		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		DUMMY_ACTION actionBean=compositeActionBean.getDUMMY_ACTION_BEAN();
		
		Map<String, String> errMap = actionBean.getErrorMap(); 
		Date processDate=actionBean.getCOMP_UI_M_PROCESS_DATE().getAsDate
			(actionBean.getCOMP_UI_M_PROCESS_DATE().getSubmittedValue());
		try {
			Date currentDate=utility.getCurrentDate();
			System.out.println(processDate+"**"+currentDate);
			if(processDate.after(currentDate)){
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "2181");
				errMap.put("current",message);
				errMap.put("toDate2",message);
				throw new Exception(message);
			}else{
				actionBean.getDUMMY_BEAN().setUI_M_PROCESS_DATE(processDate);
				errMap.clear();
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	public void processBonus() {
		
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
//		String selectQuery=PILP060_APAC_SQLQUERY_CONSTANTS.PROCESS_BUTTON_ACTION_CURSOR_C1;
		String selectQuery="SELECT POL_SYS_ID,POL_SA_EXCH_RATE FROM   PT_IL_POLICY" +
				"  WHERE POL_NO  BETWEEN ? AND ? " +
				"  AND POL_PROD_CODE  BETWEEN ? AND ? " +
				"  AND NVL(POL_STATUS,'N') IN ('A','E','P','R')" +
				"  AND POL_DS_TYPE = '2' AND NVL(POL_END_TYPE,'000') NOT IN ('003','009')";
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		Object []queryValues=new Object[4];
		SimpleDateFormat formatter=new SimpleDateFormat(PELConstants.dbDateFormat);
		
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		DUMMY_ACTION actionBean=compositeActionBean.getDUMMY_ACTION_BEAN();
		
		List <DUMMY> resultList=new ArrayList<DUMMY>();
		List<String> procResultList=new ArrayList<String>();
		ResultSet result=null;
		
		try {
			queryValues[0]=actionBean.getDUMMY_BEAN().getUI_M_POL_NO_FM();
			queryValues[1]=actionBean.getDUMMY_BEAN().getUI_M_POL_NO_TO();
			queryValues[2]=actionBean.getDUMMY_BEAN().getUI_M_PROD_CODE_FM();
			queryValues[3]=actionBean.getDUMMY_BEAN().getUI_M_PROD_CODE_TO();
			result=handler.executeSelectStatement(selectQuery, CommonUtils.getConnection(), queryValues);
			if(result != null){
				while(result.next()){
					DUMMY bean=new DUMMY();
					bean.setPolSysId(result.getDouble("POL_SYS_ID"));
//					bean.setPapProdCode(result.getString("POL_PROD_CODE"));
					bean.setSumAssuredExchngRate(result.getDouble("POL_SA_EXCH_RATE"));
					resultList.add(bean);
				}
			}
			Iterator<DUMMY> iterator=resultList.iterator();
			while(iterator.hasNext()){
				DUMMY tempBean=(DUMMY)iterator.next();
				
				procResultList=helperP9ILPK_BONUS_CALC_BONUS_CALC(CommonUtils.getProcedureValue(tempBean.getPolSysId()),
						formatter.format(actionBean.getDUMMY_BEAN().getUI_M_PROCESS_DATE()),
						"E","0",CommonUtils.getProcedureValue(tempBean.getSumAssuredExchngRate()),
						actionBean.getControlBean().getM_BASE_CURR(),"","",
						actionBean.getDUMMY_BEAN().getUI_M_BON_CODE_FM(),
						actionBean.getDUMMY_BEAN().getUI_M_BON_CODE_TO(),
						tempBean.getPapProdCode());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(result);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<String> helperP9ILPK_BONUS_CALC_BONUS_CALC(String P_POL_SYS_ID,
        String P_BONUS_DATE,String P_REF_TYPE,String P_REF_SYS_ID,String P_EXHG_RATE,
		String P_FC_CURR_CODE,String P_FC_BONUS_AMT,String P_LC_BONUS_AMT,
		String P_BON_CODE_FM,String P_BON_CODE_TO,String P_PROD_CODE){
        
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
        
		CommonUtils utility=new CommonUtils();
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		
		try {
        	 OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_SYS_ID);
        	 parameterList.add(param1);
        	 OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_BONUS_DATE);
        	 parameterList.add(param2);
        	 OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_REF_TYPE);
        	 parameterList.add(param3);
        	 OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_REF_SYS_ID);
        	 parameterList.add(param4);
        	 OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_EXHG_RATE);
        	 parameterList.add(param5);
        	 OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_FC_CURR_CODE);
        	 parameterList.add(param6);
        	 OracleParameter param7 = new OracleParameter("OUT7", "STRING", "OUT","");
        	 parameterList.add(param7);
        	 OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
        	 parameterList.add(param8);
        	 OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_BON_CODE_FM);
        	 parameterList.add(param9);
        	 OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_BON_CODE_TO);
        	 parameterList.add(param10);
//        	 OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_PROD_CODE);
//        	 parameterList.add(param11);
        	 
        	 OracleProcedureHandler procHandler = new OracleProcedureHandler();
        	 connection = CommonUtils.getConnection();
        	 outputList = procHandler.execute(parameterList, connection,
        	 "P9ILPK_BONUS_CALC.BONUS_CALC");
        	 Iterator<OracleParameter> iterator = outputList.iterator();
        	 while (iterator.hasNext()) {
        		 OracleParameter oracleParameter = iterator.next();
        		 System.out.println("Output value:::" + oracleParameter.getValue());
        		 returnList.add(oracleParameter.getValue());
        	 }
		} catch (DBException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), 
					PILP060_APAC_CONSTANTS.FORM_ID, compositeActionBean.getDUMMY_ACTION_BEAN().getErrorMap(),
					compositeActionBean.getDUMMY_ACTION_BEAN().getWarningMap());
		}

        return returnList;
    }

	public void generatePaymentVoucher() throws Exception {
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		SimpleDateFormat formatter=new SimpleDateFormat(PELConstants.dbDateFormat);
		
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		DUMMY_ACTION actionBean=compositeActionBean.getDUMMY_ACTION_BEAN();
		
		List<String> procResultList=new ArrayList<String>();
		
		actionBean.getControlBean().setM_COMM_DEL("P");
	
		procResultList=helperP9ILPK_BONUS_CALC_Gen_Bon_Acnt_Entry
			(formatter.format(actionBean.getDUMMY_BEAN().getUI_M_PROCESS_DATE()));

	}
	
	public ArrayList<String> helperP9ILPK_BONUS_CALC_Gen_Bon_Acnt_Entry(String P_BONUS_DATE) throws Exception{
	        
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			ArrayList<String> returnList = new ArrayList<String>();
	        
			CommonUtils utility=new CommonUtils();
			String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
			PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
				(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			
			try {
	        	 OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_BONUS_DATE);
	        	 parameterList.add(param2);
	     
	        	 OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        	 connection = CommonUtils.getConnection();
	        	 outputList = procHandler.execute(parameterList, connection,
	        	 "P9ILPK_BONUS_CALC.Gen_Bon_Acnt_Entry");
	        	 Iterator<OracleParameter> iterator = outputList.iterator();
	        	 while (iterator.hasNext()) {
	        		 OracleParameter oracleParameter = iterator.next();
	        		 System.out.println("Output value:::" + oracleParameter.getValue());
	        		 returnList.add(oracleParameter.getValue());
	        	 }
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} finally{
				ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), 
						PILP060_APAC_CONSTANTS.FORM_ID, compositeActionBean.getDUMMY_ACTION_BEAN().getErrorMap(),
						compositeActionBean.getDUMMY_ACTION_BEAN().getWarningMap());
			}

	        return returnList;
	    }

	public boolean isErrorGenerated() throws Exception{
		System.out.println("DUMMY_HELPER.isErrorGenerated()");
		
		String selectQuery=PILP060_APAC_SQLQUERY_CONSTANTS.GEN_PV_ACTION_CURSOR_C2;
		CRUDHandler handler =new CRUDHandler();
		
		ResultSet result=null;
		boolean isErrorGenerated=false;
		try {
			result=handler.executeSelectStatement(selectQuery, CommonUtils.getConnection());
			if(result!= null){
				if(result.next()){
					isErrorGenerated=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return isErrorGenerated;
	}
}
