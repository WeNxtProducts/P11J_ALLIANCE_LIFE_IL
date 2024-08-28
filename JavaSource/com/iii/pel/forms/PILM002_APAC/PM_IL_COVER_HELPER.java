package com.iii.pel.forms.PILM002_APAC;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_COVER_HELPER {

	public void whenNewRecordInstanceForPM_IL_COVER(PILM002_APAC_COMPOSITE_ACTION compositeActionBean) {

		PM_IL_COVER_ACTION actionBean=compositeActionBean.getPM_IL_COVER_ACTION_BEAN();
		try {
			/*if(!(actionBean.isInsertmode())){
				actionBean.getCOMP_COVER_CODE().setDisabled(true);
			}*/

			if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE()&&actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE().equals("B")){
				actionBean.getCOMP_COVER_APP_ON_BASIC_RATE().setDisabled(true);
				System.out.println(actionBean.getCOMP_COVER_APP_ON_BASIC_RATE().isDisabled());
			}else{
				actionBean.getCOMP_COVER_APP_ON_BASIC_RATE().setDisabled(false);
				//actionBean.getCOMP_COVER_APP_ON_BASIC_RATE().setRequired(true);
			}
			if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE()&&actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE().equals("A") || 
					(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE()&&actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE().equals("S"))){
				actionBean.getCOMP_COVER_RATE_APPLIED_ON().setDisabled(false);
				//actionBean.getCOMP_COVER_RATE_APPLIED_ON().setRequired(true);

				actionBean.getCOMP_COVER_SA_PERC().setDisabled(false);
				actionBean.getCOMP_COVER_SA_PERC().setRequired(true);

				actionBean.getCOMP_COVER_SA_CALC().setDisabled(false);

				if(actionBean.getCOMP_COVER_CLASS().isDisabled()){
					actionBean.getCOMP_COVER_CLASS().setDisabled(false);
				}
			}else if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE()&&actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE().equals("B")){
				actionBean.getCOMP_COVER_CLASS().setDisabled(true);
				actionBean.getCOMP_COVER_RATE_APPLIED_ON().setDisabled(true);
				actionBean.getCOMP_COVER_SA_PERC().setDisabled(true);
			}

			if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_FUND_TYPE()&&actionBean.getPM_IL_COVER_BEAN().getCOVER_FUND_TYPE().equals("B")){
				actionBean.getCOMP_COVER_FUND_RISK().setDisabled(false);
				actionBean.getCOMP_COVER_FUND_MTHD().setDisabled(true);
			}else{
				actionBean.getCOMP_COVER_FUND_RISK().setDisabled(true);
			}

			if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC()&&actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC().equals("V") ||
					(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC()&&actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC().equals("U"))||(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC()&&actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC().equals("E"))){
				actionBean.getCOMP_COVER_VAR_VALUE().setDisabled(false);
			}else{
				actionBean.getCOMP_COVER_VAR_VALUE().setDisabled(true);
			}
			if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC()&&"U".equals(actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC())){
				actionBean.getCOMP_COVER_MIN_UNIT().setDisabled(false);
				actionBean.getCOMP_COVER_MAX_UNIT().setDisabled(false);
			}else{
				actionBean.getCOMP_COVER_MIN_UNIT().setDisabled(true);
				actionBean.getCOMP_COVER_MAX_UNIT().setDisabled(true);
			}
			String coverType=actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE();
			if(null!=coverType&&"B".equals(coverType)|| CommonUtils.isIN(actionBean.getPM_IL_COVER_BEAN().getCOVER_CLASS(),"C","M","N")){
				compositeActionBean.getTabbedBar().setTabDisabled(PILM002_APAC_COMPOSITE_ACTION.PM_IL_APPL_WOP_COVER);	
			}else{
				compositeActionBean.getTabbedBar().setTabEnabled(PILM002_APAC_COMPOSITE_ACTION.PM_IL_APPL_WOP_COVER);
			}
			if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_MEDICAL_YN()&&"N".equals(actionBean.getPM_IL_COVER_BEAN().getCOVER_MEDICAL_YN())){

				compositeActionBean.getTabbedBar().setTabDisabled
				(PILM002_APAC_COMPOSITE_ACTION.PM_IL_CVR_WAITING_PRD);
			}else{
				compositeActionBean.getTabbedBar().setTabEnabled
				(PILM002_APAC_COMPOSITE_ACTION.PM_IL_CVR_WAITING_PRD);
			}

			if(actionBean.isInsertmode()) {

				disableCREATE_BASIC_COVER(actionBean);
			} else {
				actionBean.getCOMP_CREATE_BASIC_COVER().setDisabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//**End**//

	}
	/**
	 * This trigger is fired just before updating a record. It is used to set 
	 * some values in the bean to be updated before updating the record
	 * 
	 * @param event
	 * @return
	 * @throws 
	 */
	public void preUpdatePM_IL_COVER(PM_IL_COVER_ACTION actionBean)throws Exception {
		String deleteQuery=PILM002_APAC_SQLQUERY_CONSTANTS.DELETE_PM_IL_APPL_WOP_COVER_BY_COVER_CODE;
		Object []deleteQueryValues=new Object[1];
		CRUDHandler handler=new CRUDHandler();
		CommonUtils utility=new CommonUtils();
		try {
			actionBean.getPM_IL_COVER_BEAN().setCOVER_UPD_DT(utility.getCurrentDate());

			actionBean.getPM_IL_COVER_BEAN().setCOVER_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
			updateSystemParameterPP_SYSTEM(actionBean.getPM_IL_COVER_BEAN());
			//if cover code is equal to B OR not equal to W OR not equal to S
			if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE()&&actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE().equals("B")|| 
					!(actionBean.getPM_IL_COVER_BEAN().getCOVER_CLASS().equals("W"))
					|| !(actionBean.getPM_IL_COVER_BEAN().getCOVER_CLASS().equals("S"))){
				deleteQueryValues[0]=actionBean.getPM_IL_COVER_BEAN().getCOVER_CODE();
				System.out.println("before line   executeDeleteStatement------>");
				handler.executeDeleteStatement(deleteQuery, utility.getConnection(), deleteQueryValues);	
				System.out.println("after line   executeDeleteStatement------>");
			}
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateSystemParameterPP_SYSTEM(PM_IL_COVER valueBean)throws Exception{
		CommonUtils utility=new CommonUtils();
		String rowCountQuery=PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PP_SYSTEM_BY_COVER_CODE;
		String insertQuery=PILM002_APAC_SQLQUERY_CONSTANTS.INSERT_PP_SYSTEM;
		String deleteQuery=PILM002_APAC_SQLQUERY_CONSTANTS.DELETE_PP_SYSTEM_BY_PS_CODE;
		CRUDHandler handler=new CRUDHandler();
		Object []rowCountQueryValues={valueBean.getCOVER_CODE()};
		Object []insertQueryValues=new Object[5];
		Object []deleteQueryValues=new Object[1];
		ResultSet result=null;

		try {

			result=handler.executeSelectStatement
			(rowCountQuery, utility.getConnection(),rowCountQueryValues);
			if(result!= null && result.next()){
				int rowCount=result.getInt(1);
				if(rowCount==0 && null!=valueBean.getCOVER_CLASS()&& valueBean.getCOVER_CLASS().equals("C")){
					insertQueryValues [0]=valueBean.getCOVER_CODE();
					insertQueryValues[1]=valueBean.getCOVER_DESC();
					insertQueryValues[2]=valueBean.getCOVER_DESC();
					insertQueryValues[3]=utility.getCurrentDate();
					insertQueryValues[4]=CommonUtils.getControlBean().getM_USER_ID();
					handler.executeInsertStatement
					(insertQuery, utility.getConnection(), insertQueryValues);
				}else if(rowCount!=0 && null!=valueBean.getCOVER_CLASS()&&!(valueBean.getCOVER_CLASS().equals("C"))){
					deleteQueryValues[0]=valueBean.getCOVER_CODE();
					handler.executeDeleteStatement(deleteQuery, utility.getConnection(), deleteQueryValues);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(result);
//				result.close();
//				result=null;
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

	}

	public void whenNewBlockInstanceForPM_IL_COVER(PM_IL_COVER_ACTION actionBean){
		actionBean.getCOMP_COVER_FUND_RISK().setDisabled(true);
	}
		

	
	public void preInsertPM_IL_COVER(PM_IL_COVER coverBean) throws Exception{
					coverBean.setCOVER_CR_DT(new CommonUtils().getCurrentDate());
					coverBean.setCOVER_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
					coverBean.setCOVER_FRZ_FLAG("N");
					if(null!=coverBean.getCOVER_TYPE()&&coverBean.getCOVER_TYPE().equals("B")){
						coverBean.setCOVER_APP_ON_BASIC_RATE("N");
					}
					//updates the system parameter table
					updateSystemParameterPP_SYSTEM(coverBean);
	}


	public void postInsertPM_IL_COVER(PM_IL_COVER coverBean) throws Exception {

		DBProcedures procedures = new DBProcedures();
		
		try {
			if(null!=coverBean.getCREATE_BASIC_COVER()&&"Y".equals(coverBean.getCREATE_BASIC_COVER())
					&&null!=coverBean.getCOVER_TYPE()&& "D".equals(coverBean.getCOVER_TYPE())) {
				procedures.callPKG_PILM002_P_INS_BASIC_CVR(coverBean.getCOVER_CODE());
				//procedures.callPKG_PILM002_P_INS_PLAN(actionBean.getPM_IL_COVER_BEAN().getCOVER_CODE());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method checks if any record exist for given cover code in PM_IL_APPL_WOP_COVER
	 * if no record exits it will check if  any record exist for given cover code in 
	 * PM_IL_CVR_WAITING_PRD. If record exists in either one it will break the flow and
	 * throw exception
	 * @param event
	 * @return
	 * @throws Exception
	 */
	public void onCheckDeleteMasterPM_IL_COVER(PM_IL_COVER coverBean) throws Exception {
		
		String WOP_COVER=
			PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_APPL_WOP_COVER_BY_COVER_CODE;
		String WAITING_PRD=
			PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_CVR_WAITING_PRD_BY_COVER_CODE;
		CRUDHandler handler=new CRUDHandler();
		ResultSet result=null;
		ResultSet resultSet=null;
		try {
		
			result=handler.executeSelectStatement(WOP_COVER, CommonUtils.getConnection(),new Object[]{coverBean.getCOVER_CODE()});
			if(result != null && result.next()){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91050"));
			}
			resultSet=handler.executeSelectStatement(WAITING_PRD, CommonUtils.getConnection(),new Object[]{coverBean.getCOVER_CODE()});
			if(resultSet != null && resultSet.next()){
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "91050");
				throw new Exception(message);
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(result);
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * This trigger is fired after fetching details of the next block. It is used to 
	 * set any description fields for the next block and also set flags which
	 * decides if insert/update/delete is to be enabled disabled on the next block
	 * 
	 * @param event
	 * @return
	 * @throws 
	 */

	public void postQueryPM_IL_COVER(PM_IL_COVER_ACTION actionBean) {
		
		if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_CLASS()&&(actionBean.getPM_IL_COVER_BEAN().getCOVER_CLASS().equals("W")||
				actionBean.getPM_IL_COVER_BEAN().getCOVER_CLASS().equals("S"))){
			actionBean.setINSERT_ALLOWED(true);
			actionBean.setUPDATE_ALLOWED(true);
			actionBean.setDELETE_ALLOWED(true);
		}else{
			actionBean.setINSERT_ALLOWED(false);
			actionBean.setUPDATE_ALLOWED(false);
			actionBean.setDELETE_ALLOWED(false);
		}

		try {
			disableCREATE_BASIC_COVER(actionBean);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	//its validator checks cover code already exists or not
	public void whenValidateItemCOVER_CODE(PM_IL_COVER pm_il_cover) throws Exception {
		
		String queryString="SELECT ROWID,COVER_CODE FROM PM_IL_COVER WHERE COVER_CODE=?";
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		String dbRowId = null;
		String beanRowid = null;
		
		ResultSet result=null;
		try {
				/*result=handler.executeSelectStatement(queryString,connection,
						new Object[]{pm_il_cover.getCOVER_CODE()});
				if(result.next()){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71002"));
				}*/
				if(pm_il_cover.getCOVER_CODE() != null){
					beanRowid = pm_il_cover.getROWID();
					result = handler.executeSelectStatement(queryString, connection,
							new Object[]{pm_il_cover.getCOVER_CODE()});
					if(result.next()){
						dbRowId = result.getString("ROWID");
					}
				  if(CommonUtils.isDuplicate(beanRowid, dbRowId)){
					  throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71002"));
				   }
				}
				 else{   
					 throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71103"));
				 }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
		finally{
			try {CommonUtils.closeCursor(result);} catch (Exception e) {e.printStackTrace();}
		}
	
		


		
		

	}
	/**
	 * Method will set the COVER_LONG_DESC value in the backing bean to the 
	 * value present in COVER_DESC in the backing bean 
	 * @param event
	 * @return
	 * @throws 
	 */
	public void preTextItemCOVER_LONG_DESC(PM_IL_COVER_ACTION actionBean) {
		actionBean.getPM_IL_COVER_BEAN().setCOVER_LONG_DESC
		(actionBean.getPM_IL_COVER_BEAN().getCOVER_DESC());
		actionBean.getCOMP_COVER_LONG_DESC().setSubmittedValue(null);
	}
	/**
	 * This WHEN-LIST-CHANGED trigger is fired for when a new value is selected for COVER_TYPE 
	 * from Drop down. 
	 * @param 
	 * @param 
	 * @return
	 * @throws Exception 
	 */
	public void whenListChangedCOVER_TYPE(PILM002_APAC_COMPOSITE_ACTION compositeActionBean) throws Exception {

		PM_IL_COVER_ACTION actionBean=compositeActionBean.getPM_IL_COVER_ACTION_BEAN();
		String coverType= actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE();
		try {
			if(null!=coverType&&coverType.equals("B")){
				actionBean.getPM_IL_COVER_BEAN().setCOVER_APP_ON_BASIC_RATE("N");
				actionBean.getPM_IL_COVER_BEAN().setCOVER_CLASS("N");
				actionBean.getCOMP_COVER_CLASS().setSubmittedValue(null);
				actionBean.getCOMP_COVER_APP_ON_BASIC_RATE().setSubmittedValue(null);
				actionBean.getCOMP_COVER_APP_ON_BASIC_RATE().setDisabled(true);

				compositeActionBean.getTabbedBar().setTabDisabled
				(PILM002_APAC_COMPOSITE_ACTION.PM_IL_APPL_WOP_COVER);

				actionBean.getPM_IL_COVER_BEAN().setCOVER_CLASS("N");
				actionBean.getCOMP_COVER_CLASS().resetValue();
				//actionBean.getCOMP_COVER_CLASS().setSubmittedValue(null);


				actionBean.getPM_IL_COVER_BEAN().setCOVER_SA_CALC("N");
				actionBean.getCOMP_COVER_SA_CALC().setSubmittedValue(null);
			}else{
				actionBean.getCOMP_COVER_APP_ON_BASIC_RATE().setDisabled(false);
				actionBean.getCOMP_COVER_APP_ON_BASIC_RATE().setRequired(true);

			}
			if(null!=coverType&&(coverType.equals("A")||coverType.equals("S"))){
				actionBean.getCOMP_COVER_RATE_APPLIED_ON().setDisabled(false);
				actionBean.getCOMP_COVER_RATE_APPLIED_ON().setRequired(true);

				actionBean.getCOMP_COVER_SA_PERC().setDisabled(false);
				actionBean.getCOMP_COVER_SA_PERC().setRequired(true);

				actionBean.getCOMP_COVER_SA_CALC().setDisabled(false);
				actionBean.getCOMP_COVER_SA_CALC().setRequired(true);

				actionBean.getCOMP_COVER_CLASS().setDisabled(false);
			}else if(null!=coverType&&coverType.equals("B")){
				actionBean.getPM_IL_COVER_BEAN().setCOVER_RATE_APPLIED_ON("S");
				actionBean.getPM_IL_COVER_BEAN().setCOVER_CLASS("N");
				actionBean.getCOMP_COVER_CLASS().resetValue();
				//actionBean.getCOMP_COVER_CLASS().setSubmittedValue(null);
				actionBean.getCOMP_COVER_RATE_APPLIED_ON().setSubmittedValue(null);

				actionBean.getPM_IL_COVER_BEAN().setCOVER_SA_PERC(Double.parseDouble("100.0"));
				actionBean.getCOMP_COVER_SA_PERC().setSubmittedValue(null);

				actionBean.getCOMP_COVER_CLASS().setDisabled(true);
				actionBean.getCOMP_COVER_RATE_APPLIED_ON().setDisabled(true);
				actionBean.getCOMP_COVER_SA_PERC().setDisabled(true);

			}

			disableCREATE_BASIC_COVER(actionBean);
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * This WHEN-LIST-CHANGED trigger is fired for when a new value is selected 
	 * for COVER_CLASS from Drop down. 
	 * @param 
	 * @param 
	 * @return
	 * @throws Exception 
	 * @throws 
	 */
	public void whenListChangedCOVER_CLASS(PILM002_APAC_COMPOSITE_ACTION compositeActionBean) throws Exception {
		PM_IL_COVER_ACTION actionBean=compositeActionBean.getPM_IL_COVER_ACTION_BEAN();
		Map <String,String> errMap=actionBean.getErrorMap();
		String coverClass=(String)actionBean.getCOMP_COVER_CLASS().getSubmittedValue();
		if(null!=coverClass&&("W".equalsIgnoreCase(coverClass) || "S".equalsIgnoreCase(coverClass) || "T".equalsIgnoreCase(coverClass))){
			compositeActionBean.getTabbedBar().setTabEnabled(2);
			actionBean.getCOMP_COVER_SA_CALC().setDisabled(false);
			//making writable
			actionBean.getCOMP_COVER_SA_CALC().setReadonly(false);
		}else if(null!=coverClass&&("C".equalsIgnoreCase(coverClass) || "M".equalsIgnoreCase(coverClass))){
			compositeActionBean.getTabbedBar().setTabDisabled(2);
		}else{
			compositeActionBean.getTabbedBar().setTabDisabled(2);
		}
		//cover type not B AND (cover class not W OR S)
		if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE()&&!(actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE().equals("B"))
				&& (null!=coverClass&&!("WS".contains(coverClass)))){
			try {
				if(actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC().equals("C")){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206")+
							"Since Cover Class is not WOP. Calculation type is not applicable.");
					
				}else{
					errMap.clear();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}
	/**
	 * This trigger is fired for validating COVER_CLASS field.Method checks if 
	 * COVER_TYPE is not B AND (COVER_CLASS not W OR S). if the above condition
	 * is true it checks if COVER_SA_CALC equals C
	 * 
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception
	 */
	public void whenValidateItemCOVER_CLASS(PM_IL_COVER_ACTION actionBean) throws Exception {
		
		String coverClass=actionBean.getPM_IL_COVER_BEAN().getCOVER_CLASS();
		try {
			if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE()&&!(actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE().equals("B"))
					&& (!("WS".contains(coverClass)))){
				if(null!=actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC()&&actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC().equals("C")){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "3206");
					throw new Exception(message+"Since Cover Class is not WOP. Calculation type is not applicable.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This WHEN-LIST-CHANGED trigger is fired for when a new value is selected
	 *  for COVER_SA_CALC from Drop down. 
	 * @param 
	 * @param 
	 * @return
	 * @throws 
	 */
	public void whenListChangedCOVER_SA_CALC(PM_IL_COVER_ACTION actionBean){
		String coverSACalc=actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC();
		if(null!=coverSACalc&&(coverSACalc.equals("V") || coverSACalc.equals("U"))){
			actionBean.getCOMP_COVER_VAR_VALUE().setDisabled(false);
		}else{
			actionBean.getCOMP_COVER_VAR_VALUE().setDisabled(true);
			actionBean.getPM_IL_COVER_BEAN().setCOVER_VAR_VALUE(0.0);
		}
				actionBean.getCOMP_COVER_VAR_VALUE().resetValue();
	}

	/**
	 * This trigger is fired for validating COVER_CLASS field.Method checks if 
	 * COVER_TYPE is not B AND (COVER_CLASS not W OR S). if the above condition
	 * is true it checks if COVER_SA_CALC equals C
	 * 
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception 
	 */
	public void whenValidateItemCOVER_SA_CALC(PM_IL_COVER_ACTION actionBean) throws Exception {
		String coverClass=actionBean.getPM_IL_COVER_BEAN().getCOVER_CLASS();
		String coverSACalc= actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC();
		String coverType=actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE();
		PM_IL_COVER PM_IL_COVER_BEAN=actionBean.getPM_IL_COVER_BEAN();
		
		if("E".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_SA_CALC())){
			PM_IL_COVER_BEAN.setCOVER_PREM_TYPE("E");
			PM_IL_COVER_BEAN.setCOVER_MAX_TYPE("F");
			PM_IL_COVER_BEAN.setCOVER_MIN_TYPE("F");
			actionBean.getCOMP_COVER_SA_BY_PARTS_TARR().setDisabled(false);
			actionBean.getCOMP_COVER_MAX_SA().setRequired(true);
			actionBean.getCOMP_COVER_MIN_SA().setRequired(true);
			actionBean.getCOMP_COVER_VAR_VALUE().setDisabled(false);
			actionBean.getCOMP_COVER_VAR_VALUE().setRequired(true);
		}else if("A".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_SA_CALC())){
			PM_IL_COVER_BEAN.setCOVER_PREM_TYPE("C");
		}else{
			actionBean.getCOMP_COVER_MAX_SA().setRequired(false);
			actionBean.getCOMP_COVER_MIN_SA().setRequired(false);
			actionBean.getCOMP_COVER_VAR_VALUE().setRequired(false);
		}
		if(null!=coverType&&!(coverType.equals("B")) && (null!=coverClass&& !("WS".contains(coverClass)))){
			if(actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC().equals("C")){
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "3206");
				throw new Exception(message+"Since Cover Class is not WOP. Calculation type is not applicable.");
			}
		}
		//if (COVER_TYPE != B AND COVER_SA_CALC = 'P') OR 
		//(COVER_TYPE = 'B' AND COVER_SA_CALC NOT IN('P','N','V','D','U','A'))
		//if((null!=coverType&&!(coverType.equals("B")) && null!=coverSACalc&&coverSACalc.equals("P")) ||
		//		(null!=coverType&&coverType.equals("B") && !("PNVDUA".contains(coverSACalc)))){
		//	String message=Messages.getString(PELConstants.pelErrorMessagePath, "91418");
		//	throw new Exception(message);
		//}
		if((null!=coverSACalc&&"VU".contains(coverSACalc))||((null!=coverSACalc&&"E".contains(coverSACalc)))){
			actionBean.getCOMP_COVER_VAR_VALUE().setDisabled(false);
		}else{
			actionBean.getCOMP_COVER_VAR_VALUE().setDisabled(true);
			actionBean.getPM_IL_COVER_BEAN().setCOVER_VAR_VALUE(0.0);
		}
		actionBean.getCOMP_COVER_VAR_VALUE().resetValue();
		if(null!=coverSACalc&&coverSACalc.equals("U")){
			actionBean.getCOMP_COVER_MIN_UNIT().setRequired(true);
			actionBean.getCOMP_COVER_MAX_UNIT().setRequired(true);
			actionBean.getCOMP_COVER_MIN_UNIT().setDisabled(false);
			actionBean.getCOMP_COVER_MAX_UNIT().setDisabled(false);
		}else{
			actionBean.getCOMP_COVER_MIN_UNIT().setRequired(false);
			actionBean.getCOMP_COVER_MAX_UNIT().setRequired(false);
			actionBean.getCOMP_COVER_MIN_UNIT().setDisabled(true);
			actionBean.getCOMP_COVER_MAX_UNIT().setDisabled(true);
		}
	}

	/**
	 * This trigger is fired for validating COVER_SA_PERC field.
	 * Method checks if percentage value is 0 and throws exception if it is 0
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception 
	 */
	public void whenValidateItemCOVER_SA_PERC(PM_IL_COVER_ACTION actionBean) throws Exception {
		Double coverSAPercent=actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_PERC();
		if(coverSAPercent == 0d ||coverSAPercent<0){
			String message=Messages.getString(PELConstants.pelErrorMessagePath, "60111");
			throw new Exception(message);
		}
	}

	/**
	 * This trigger is fired for validating COVER_VAR_VALUE field.  
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception 
	 */
	public void whenValidateItemCOVER_VAR_VALUE(PM_IL_COVER_ACTION actionBean) throws Exception {
		Double coverVarValue=actionBean.getPM_IL_COVER_BEAN().getCOVER_VAR_VALUE();
		String coverSACalc=actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC();
		if("VU".contains(coverSACalc) && coverVarValue==null){
			String message=Messages.getString(PELConstants.pelErrorMessagePath, "80001");
			throw new Exception(message);
		}

		if(coverSACalc.equals("U")){
			actionBean.getCOMP_COVER_MIN_UNIT().setRequired(true);
			actionBean.getCOMP_COVER_MAX_UNIT().setRequired(true);
		}else{
			actionBean.getCOMP_COVER_MIN_UNIT().setRequired(false);
			actionBean.getCOMP_COVER_MAX_UNIT().setRequired(false);
		}
	}
	/**
	 * This WHEN-LIST-CHANGED trigger is fired for when a new value is selected
	 *  for COVER_MEDICAL_YN from Drop down. 
	 * @param 
	 * @param 
	 * @return
	 * @throws 
	 */
	public void whenListChangedCOVER_MEDICAL_YN(PILM002_APAC_COMPOSITE_ACTION compositeActionBean) {
		
		PM_IL_COVER_ACTION actionBean=compositeActionBean.getPM_IL_COVER_ACTION_BEAN();
		String coverMedicalYN=(String)actionBean.getCOMP_COVER_MEDICAL_YN().getSubmittedValue();
		if("N".equalsIgnoreCase(actionBean.getPM_IL_COVER_BEAN().getCOVER_MEDICAL_YN())){
			compositeActionBean.getTabbedBar().setTabDisabled
			(PILM002_APAC_COMPOSITE_ACTION.PM_IL_CVR_WAITING_PRD);
		}else{
			compositeActionBean.getTabbedBar().setTabEnabled
			(PILM002_APAC_COMPOSITE_ACTION.PM_IL_CVR_WAITING_PRD);
		}
		//** End**//
	}

	/**
	 * This trigger is fired for validating COVER_MIN_SA field. If value in COVER_MIN_SA
	 * and COVER_MAX_SA  is not null it will check if COVER_MIN_SA is greater than
	 * COVER_MAX_SA. If it is greater it will throw exception and alert the user 
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception 
	 */
	public void whenValidateItemCOVER_MIN_SA(PM_IL_COVER_ACTION actionBean) throws Exception {
		Double coverMinSA=actionBean.getPM_IL_COVER_BEAN().getCOVER_MIN_SA();
		Double coverMaxSA=actionBean.getPM_IL_COVER_BEAN().getCOVER_MAX_SA();
		if(coverMinSA != null){
			if(coverMinSA < 0d || coverMinSA== 0 ){
				String message=Messages.getMessage(PELConstants.pelErrorMessagePath,"71043").getSummary();
				throw new Exception(message);
			}
		}
		if (coverMaxSA != null && coverMinSA != null){

			if(coverMinSA > coverMaxSA){
				String message=Messages.getMessage(PELConstants.pelErrorMessagePath,"91038").getSummary();
				throw new Exception(message);
			}
		}
	}
	/**
	 * This trigger is fired for validating COVER_MAX_SA field. If value in COVER_MIN_SA
	 * and COVER_MAX_SA  is not null it will check if COVER_MIN_SA is greater than
	 * COVER_MAX_SA. If it is greater it will throw exception and alert the user 
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception 
	 */
	public void whenValidateItemCOVER_MAX_SA(PM_IL_COVER_ACTION actionBean) throws Exception {
		Double coverMaxSA=actionBean.getPM_IL_COVER_BEAN().getCOVER_MAX_SA();
		Double coverMinSA=actionBean.getPM_IL_COVER_BEAN().getCOVER_MIN_SA();
		if(coverMaxSA != null){
			if(coverMaxSA < 0d || coverMaxSA== 0 ){
				String message=Messages.getMessage(PELConstants.pelErrorMessagePath,"71043").getSummary();
				throw new Exception(message);
			}
		}
		if (coverMaxSA != null && coverMinSA != null){

			if(coverMinSA > coverMaxSA){
				String message=Messages.getMessage(PELConstants.pelErrorMessagePath,"91038").getSummary();
				throw new Exception(message);
			}
		}
	}

	/**
	 * This trigger is fired for validating COVER_FUND_TYPE field. Based upon the 
	 * value selected in COVER_FUND_TYPE it will enable or disable COVER_FUND_RISK,
	 * COVER_FUND_MTHD fields
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception 
	 */
	public void whenValidateItemCOVER_FUND_TYPE(PM_IL_COVER_ACTION actionBean) {
		String coverFundType =actionBean.getPM_IL_COVER_BEAN().getCOVER_FUND_TYPE();
		if("B".equals(coverFundType)){
			actionBean.getCOMP_COVER_FUND_MTHD().setDisabled(false);
			actionBean.getCOMP_COVER_FUND_RISK().setDisabled(false);
		}else{
			actionBean.getCOMP_COVER_FUND_MTHD().setDisabled(true);
			actionBean.getCOMP_COVER_FUND_RISK().setDisabled(true);

		}
	}

	/**
	 * This trigger is fired for validating COVER_FUND_MTHD field. Based upon the 
	 * value selected in COVER_FUND_MTHD it will enable or disable COVER_FUND_RISK,
	 * field
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception 
	 */
	public void whenValidateItemCOVER_FUND_MTHD(PM_IL_COVER_ACTION actionBean) {
		String coverFundMthd =actionBean.getPM_IL_COVER_BEAN().getCOVER_FUND_MTHD();
		if("T".equals(coverFundMthd)){
			actionBean.getCOMP_COVER_FUND_RISK().setDisabled(true);
		}else{
			actionBean.getCOMP_COVER_FUND_RISK().setDisabled(false);
		}
	}


	// its checks only FROM date not bigger than TO date
	public void whenValidateItemCOVER_EFF_FM_DT(PM_IL_COVER coverBean) throws Exception {
		Date effFromDate =coverBean.getCOVER_EFF_FM_DT();
		Date effToDate=coverBean.getCOVER_EFF_TO_DT();
		if(effFromDate != null){
			if (effToDate != null) {
				if(effFromDate.after(effToDate)){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
				}
			}				
		}
	}
		
		
		
			
				
	public void whenValidateItemCOVER_EFF_TO_DT(PM_IL_COVER coverBean) throws Exception {
		Date effToDate = coverBean.getCOVER_EFF_TO_DT();
		Date effFromDate= coverBean.getCOVER_EFF_FM_DT();
		if(effToDate != null && effFromDate != null){
			if(effFromDate.after(effToDate)){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
			}
		}
	}
			
		
	public void whenValidateItemCOVER_MIN_UNIT(PM_IL_COVER_ACTION actionBean) throws Exception {
		Double coverMinUnit=actionBean.getPM_IL_COVER_BEAN().getCOVER_MIN_UNIT();
		Double coverMaxUnit=actionBean.getPM_IL_COVER_BEAN().getCOVER_MAX_UNIT();
		if("U".equals(actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC())){
			if(coverMaxUnit != null && coverMinUnit != null){
				if(coverMinUnit > coverMaxUnit){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "91898");
					throw new Exception(message);
				}
			}
		}else{
		}
	}
	/**
	 * This trigger is fired for validating COVER_MAX_UNIT field. 
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception 
	 */
	public void whenValidateItemCOVER_MAX_UNIT(PM_IL_COVER_ACTION actionBean) throws Exception {
		Double coverMaxUnit=actionBean.getPM_IL_COVER_BEAN().getCOVER_MAX_UNIT();
		Double coverMinUnit=actionBean.getPM_IL_COVER_BEAN().getCOVER_MIN_UNIT();
		if("U".equals(actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC())){
			if(coverMaxUnit != null && coverMinUnit != null){
				if(coverMinUnit > coverMaxUnit){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "91898");
					throw new Exception(message);
				}
			}
		}else{
		}
	}

	/**
	 * This trigger is fired for validating COVER_SA_MULTIPLE field. 
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception 
	 * @throws Exception 
	 */
	public void whenValidateItemCOVER_SA_MULTIPLE(PM_IL_COVER_ACTION actionBean) throws Exception {
		Double coverSAMultiple=actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_MULTIPLE();
		try {
			if (coverSAMultiple < 0){
				throw new Exception(
						Messages
								.getString(PELConstants.pelErrorMessagePath, "91341"));
				//String message=Messages.getString(PELConstants.pelErrorMessagePath, "91341");
				
			}
			if(coverSAMultiple > 0 && isAFraction(coverSAMultiple)){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91929"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	public boolean isAFraction(Double value){
		boolean isFraction=false;
		if(value != null){
			if(value%1 != 0){
				isFraction=true;
			}
		}
		return isFraction;
	}

	private void disableCREATE_BASIC_COVER(PM_IL_COVER_ACTION actionBean) throws Exception {

		Connection connection = null;
		ResultSet resultSet = null;
		int CRE_BAS_CVR = 0;
		CRUDHandler handler = new CRUDHandler();
		
		String coverType = null;
		
		if(actionBean.getCOMP_COVER_TYPE() != null) {
			coverType = (String) CommonUtils.getCurrentValue(actionBean.getCOMP_COVER_TYPE());
		} else {
			coverType = actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE();
		}

		try {
			if("D".equals(coverType) && actionBean.isInsertmode()) {

				connection = CommonUtils.getConnection();

				resultSet = handler.executeSelectStatement(PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PS_VALUE, connection);

				if(resultSet.next()) {
					CRE_BAS_CVR = resultSet.getInt(1);
				}

				if(CRE_BAS_CVR == 1) {
					actionBean.getPM_IL_COVER_BEAN().setCREATE_BASIC_COVER("Y");
					actionBean.getCOMP_CREATE_BASIC_COVER().setDisabled(false);
					actionBean.getCOMP_CREATE_BASIC_COVER().resetValue();
				} else {
					actionBean.getPM_IL_COVER_BEAN().setCREATE_BASIC_COVER("N");
					actionBean.getCOMP_CREATE_BASIC_COVER().setDisabled(true);
					actionBean.getCOMP_CREATE_BASIC_COVER().resetValue();
				}
			} else {
				actionBean.getPM_IL_COVER_BEAN().setCREATE_BASIC_COVER("N");
				actionBean.getCOMP_CREATE_BASIC_COVER().setDisabled(true);
				actionBean.getCOMP_CREATE_BASIC_COVER().resetValue();
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void when_create_record(PM_IL_COVER PM_IL_COVER_BEAN)throws Exception{
		try{
			PM_IL_COVER_BEAN.setCOVER_FRZ_FLAG("N");
			PM_IL_COVER_BEAN.setCOVER_TYPE("B");
			PM_IL_COVER_BEAN.setCOVER_APP_ON_BASIC_RATE("N");
			PM_IL_COVER_BEAN.setCOVER_DISC_AGE_YN("N");
			PM_IL_COVER_BEAN.setCOVER_RATE_APPLIED_ON("S");
			PM_IL_COVER_BEAN.setCOVER_SA_PERC(100.0);
			PM_IL_COVER_BEAN.setCOVER_FUND_TYPE("R");
			PM_IL_COVER_BEAN.setCOVER_FUND_RISK("R");
			PM_IL_COVER_BEAN.setCOVER_CLASS("N");
			PM_IL_COVER_BEAN.setCOVER_SA_CALC("N");
			PM_IL_COVER_BEAN.setCOVER_PREM_TYPE("C");
			PM_IL_COVER_BEAN.setCOVER_FUND_MTHD("T");
			PM_IL_COVER_BEAN.setCOVER_MIN_MAX_REQ("N");
			PM_IL_COVER_BEAN.setCOVER_UNIT_SA_BASIS("N");
			PM_IL_COVER_BEAN.setCOVER_MAX_TYPE("N");
			PM_IL_COVER_BEAN.setCOVER_MIN_TYPE("N");
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void validateCOVER_MAX_TYPE(PM_IL_COVER_ACTION coverAction) throws Exception {
		PM_IL_COVER coverBean = coverAction.getPM_IL_COVER_BEAN();
		try {
			if ("B".equals(coverBean.getCOVER_TYPE())) {
				if (!("N".equals(coverBean.getCOVER_MAX_TYPE()) || "F".equals(coverBean.getCOVER_MAX_TYPE()))) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91933" , new Object[] {"Maximum Type"}));
				}
			}
			if ("S".equals(coverBean.getCOVER_MAX_TYPE())) {
				coverAction.getCOMP_COVER_MAX_PERC().setDisabled(false);
				coverAction.getCOMP_COVER_MAX_PERC().setRequired(true);
				coverBean.setCOVER_MAX_SA(null);
				coverAction.getCOMP_COVER_MAX_SA().resetValue();
				coverAction.getCOMP_COVER_MAX_SA().setDisabled(true);
			}else {
				coverAction.getCOMP_COVER_MAX_PERC().setDisabled(true);
				coverAction.getCOMP_COVER_MAX_PERC().setRequired(false);
				coverAction.getCOMP_COVER_MAX_SA().setDisabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void validateCOVER_MIN_TYPE(PM_IL_COVER_ACTION coverAction) throws Exception {
	
		PM_IL_COVER coverBean  =  coverAction.getPM_IL_COVER_BEAN();
		try {
			if ("B".equals(coverBean.getCOVER_TYPE())) {
				if (!("N".equals(coverBean.getCOVER_MIN_TYPE()) || "F".equals(coverBean.getCOVER_MIN_TYPE()))) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91933" , new Object[] {"Minimum Type"}));
				}
			}
			
			if ("S".equals(coverBean.getCOVER_MIN_TYPE())) {
				coverAction.getCOMP_COVER_MIN_PERC().setDisabled(false);
				coverAction.getCOMP_COVER_MIN_PERC().setRequired(true);
				coverBean.setCOVER_MIN_SA(null);
				coverAction.getCOMP_COVER_MIN_SA().resetValue();
				coverAction.getCOMP_COVER_MIN_SA().setDisabled(true);
			}else {
				coverAction.getCOMP_COVER_MIN_SA().setDisabled(false);
				coverBean.setCOVER_MIN_PERC(null);
				coverAction.getCOMP_COVER_MIN_PERC().setDisabled(true);
				coverAction.getCOMP_COVER_MIN_PERC().setRequired(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void validateCOVER_MAX_PERC(PM_IL_COVER coverBean) throws Exception {
		try {
			if ("S".equals(coverBean.getCOVER_MIN_TYPE())) {
				if (coverBean.getCOVER_MAX_PERC() > 100 || coverBean.getCOVER_MAX_PERC() < 0) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91125"));
				}
				
				if (coverBean.getCOVER_MAX_PERC() != null &&   coverBean.getCOVER_MIN_PERC() != null) {
					if (coverBean.getCOVER_MAX_PERC() < coverBean.getCOVER_MIN_PERC()) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90008" , 
								new Object[] {"Max%" ,"Min%"}));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		 
	}
	public void validateCOVER_MIN_PERC(PM_IL_COVER coverBean) throws Exception {
	     
		try {
			if ("S".equals(coverBean.getCOVER_MIN_TYPE())) {
				if (coverBean.getCOVER_MIN_PERC() >= 100 || coverBean.getCOVER_MIN_PERC() < 0) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"3206",
						new Object[] {"Min% should be less than 100"}));
				}
				
				if (coverBean.getCOVER_MAX_PERC() != null && coverBean.getCOVER_MIN_PERC() != null) {
					if (coverBean.getCOVER_MIN_PERC() >= coverBean.getCOVER_MAX_PERC()) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014", 
								new Object[] {"Min%" ,"less than ", "Max%"}));
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
		
		
	public void validateFundrisk(PM_IL_COVER_ACTION coverAction)
			throws Exception {
		String query = " SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_CALC_MTHD'";
		ResultSet rs = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String M_VALUE = null;

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, con);
			if (rs.next()) {
				M_VALUE = rs.getString(1);
			}
			if ("1".equalsIgnoreCase(M_VALUE)) {
				coverAction.getCOMP_COVER_FUND_RISK().setDisabled(false);
			} else {
				coverAction.getPM_IL_COVER_BEAN().setCOVER_FUND_RISK("R");
				coverAction.getCOMP_COVER_FUND_RISK().setDisabled(true);
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	//added by saranya for cover SA %  ssp call id is FALCONQC-1716238	
	public void whenValidateItem(PM_IL_COVER_ACTION actionBean) throws Exception
	{
		String coverSACalc= actionBean.getPM_IL_COVER_BEAN().getCOVER_SA_CALC();
		String coverType=actionBean.getPM_IL_COVER_BEAN().getCOVER_TYPE();
		System.out.println("value of cove SA------->"+coverSACalc);
		if("N".equalsIgnoreCase(coverSACalc))
		{
			System.out.println("entered into  valif condition");
			actionBean.getCOMP_COVER_SA_PERC().setDisabled(true);
			actionBean.getPM_IL_COVER_BEAN().setCOVER_SA_PERC(null);
			actionBean.getCOMP_COVER_SA_PERC().resetValue();
			//actionBean.getCOMP_COVER_SA_PERC().setSubmittedValue(null);
			actionBean.getCOMP_COVER_SA_PERC().setRequired(false);
		}
		else if("S".equalsIgnoreCase(coverSACalc)&&("A".equalsIgnoreCase(coverType)))
		{
			System.out.println("entered into valelse condition");
			actionBean.getCOMP_COVER_SA_PERC().setDisabled(false);
			actionBean.getCOMP_COVER_SA_PERC().setRequired(true);
		}
		/*added by gopi for toi 25/05/18*/
		else if("I".equalsIgnoreCase(coverSACalc)){
			actionBean.getCOMP_COVER_SA_FIXED().setRequired(true);
			actionBean.getCOMP_COVER_SA_FIXED().setDisabled(false);
			
		}else{
			actionBean.getCOMP_COVER_SA_FIXED().setRequired(false);	
			actionBean.getCOMP_COVER_SA_FIXED().setDisabled(true);
			actionBean.getCOMP_COVER_SA_FIXED().setSubmittedValue(null);
			actionBean.getCOMP_COVER_SA_FIXED().setValue(null);
			actionBean.getPM_IL_COVER_BEAN().setCOVER_SA_FIXED(null);
		}
		/*end*/
		//end
	}			
}
