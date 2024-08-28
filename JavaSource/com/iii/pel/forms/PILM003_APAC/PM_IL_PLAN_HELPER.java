package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.PKG_PILM003;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PM_IL_PLAN_HELPER {

	public void executeQuery(PILM003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_PLAN_DELEGATE().executeSelectStatement(compositeAction);
	}
	
	/* WHEN NEW BLOCK INSTANCE */
	public void WHEN_NEW_BLOCK_INSTANCE(PILM003_APAC_COMPOSITE_ACTION compositeAction)
	{
		PM_IL_PLAN planBean = null;
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		if(CommonUtils.nvl(planBean.getPLAN_SURR_YN(), "N").equals("N")){
			//compositeAction.getTabbedBar().setTabDisabled(3);
			compositeAction.getWizard().disableWizardItemForId("2");
		}
		else{
			compositeAction.getWizard().enableWizardItemForId("2");
			//compositeAction.getTabbedBar().setTabEnabled(3);
		}
	}
	
	public void PRE_DELETE(String planCode) throws Exception{
		int deleted = 0;
		Connection connection = null;
		CRUDHandler handler = null;
		String C1 = "DELETE FROM PM_IL_SURR_PAID_FACTOR  WHERE SPF_PLAN_CODE = ? " ;
		String C2 = "DELETE FROM PM_IL_RED_SA WHERE RSA_PLAN_CODE = ? " ;
		String C3 = "DELETE FROM PM_IL_PLAN_MOP P WHERE P.PMOP_PLAN_CODE = ? " ;
		String C4 = "DELETE FROM PM_IL_PLAN_MAT_AGESETUP P WHERE P.PMA_PLAN_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			deleted = handler.executeDeleteStatement(C1, connection, new Object[]{planCode});
			deleted = handler.executeDeleteStatement(C2, connection, new Object[]{planCode});
			deleted = handler.executeDeleteStatement(C3, connection, new Object[]{planCode});
			deleted = handler.executeDeleteStatement(C4, connection, new Object[]{planCode});
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void PRE_INSERT(PM_IL_PLAN planBean) throws Exception{
		planBean.setPLAN_FRZ_FLAG("N");
		planBean.setPLAN_CR_DT(new CommonUtils().getCurrentDate());
		planBean.setPLAN_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		L_UNIQUE_PLAN_CODE(planBean.getPLAN_CODE(), planBean.getROWID());
	}
	
	public void L_UNIQUE_PLAN_CODE(String planCode,String beanRowId) throws Exception
	{
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String query = "SELECT ROWID FROM  PM_IL_PLAN  WHERE  PLAN_CODE = ?";
		String M_TEMP = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			Object[] values={planCode.trim()};
			resultSet = handler.executeSelectStatement(query, connection, values);
			if(resultSet.next())
			{
				M_TEMP = resultSet.getString(1);
				if(CommonUtils.isDuplicate(beanRowId, M_TEMP)){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71012"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}
	
	public void PRE_UPDATE(PM_IL_PLAN planBean) throws Exception{
		planBean.setPLAN_UPD_DT(new CommonUtils().getCurrentDate());
		planBean.setPLAN_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
	
	public void POST_QUERY(PILM003_APAC_COMPOSITE_ACTION compositeAction ) throws Exception{
		String planTypeDesc = null;
		ArrayList<String> list = null;
		ArrayList<OracleParameter> list1 = null;
		PM_IL_PLAN planBean = null;
		String value = null;
		
		Integer A = 0;
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
	    try {
			list = DBProcedures.P_VAL_SYSTEM("ILPLANTYPE", planBean.getPLAN_TYPE(), null, "N",CommonUtils.getProcedureValue(A));
			if(list.size()> 0 && list.get(0) != null){
				planTypeDesc = list.get(0);
				planBean.setUI_M_PLAN_TYPE_DESC(planTypeDesc);
				A= Integer.parseInt(list.get(1));
			}
			list1 = new PKG_PILM003().L_VAL_PLAN_CODE(planBean.getPLAN_CODE(), null, "B", "N", "N");
			if(list1.size()> 0 && list1.get(0).getValueObject() != null){
				planBean.setUI_M_PLAN_DESC((String)list1.get(0).getValueObject());
			}
			/*if(planBean.getPLAN_AGE_TERM_FLAG().equals("S")){
				//compositeAction.getTabbedBar().setTabEnabled(5);
				compositeAction.getWizard().enableWizardItemForId("4");
			}
			else if(planBean.getPLAN_AGE_TERM_FLAG().equals("H")){
				compositeAction.getWizard().disableWizardItemForId("4");
				//compositeAction.getTabbedBar().setTabDisabled(5);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void WHEN_NEW_RECORD_INSTANCE(PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		PM_IL_PLAN_ACTION planAction = null;
		PM_IL_PLAN planBean = null;
		String C2 = "SELECT 'X' FROM PM_IL_SURR_PAID_FACTOR WHERE  SPF_PLAN_CODE = ? ";
		String M_TEMP1 = null;
		String M_TEMP2 = null;
		try {
			planAction = compositeAction.getPM_IL_PLAN_ACTION_BEAN();
			planBean = planAction.getPM_IL_PLAN_BEAN();
			connection =CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C2, connection, new Object[]{planBean.getPLAN_CODE()});
			if(resultSet.next()){
				M_TEMP2 = resultSet.getString(1);
				planAction.getCOMP_PLAN_SURR_YRS().setDisabled(true);
			}else{
				planAction.getCOMP_PLAN_SURR_YN().setDisabled(false);
				planAction.getCOMP_PLAN_SURR_YRS().setDisabled(false);
			}
			if(CommonUtils.nvl(planBean.getPLAN_RED_SA_BASIS(), "T").equals("T")){
				compositeAction.getWizard().enableWizardItemForId("1");
				//compositeAction.getTabbedBar().setTabEnabled(2);
			}else{
				compositeAction.getWizard().disableWizardItemForId("1");
				//compositeAction.getTabbedBar().setTabDisabled(2);
			}
			if(planBean.getPLAN_SURR_YN().equals("Y")){
				planAction.getCOMP_PLAN_SURR_YRS().setDisabled(false);
				compositeAction.getWizard().enableWizardItemForId("2");
				//compositeAction.getTabbedBar().setTabEnabled(3);
			}else{
				planAction.getCOMP_PLAN_SURR_YRS().setDisabled(true);
				compositeAction.getWizard().disableWizardItemForId("2");
				//compositeAction.getTabbedBar().setTabDisabled(3);
			}
			
			//Commented as this code moved to updateaction by adaboina on 14/02/2012
			if(planBean.getPLAN_REVIVAL_YN().equals("Y")){
				planAction.getCOMP_PLAN_REVIVAL_YRS().setDisabled(false);
			}else{
				planAction.getCOMP_PLAN_REVIVAL_YRS().setDisabled(true);
			}
			if(planBean.getPLAN_SPL_REVIVAL_YN().equals("Y")){
				planAction.getCOMP_PLAN_SPL_REVIVAL_YRS().setDisabled(false);
			}else{
				planAction.getCOMP_PLAN_SPL_REVIVAL_YRS().setDisabled(true);
			}
			if(null!=planBean.getPLAN_AGE_TERM_FLAG()&&!planBean.getPLAN_AGE_TERM_FLAG().isEmpty()
					&&planBean.getPLAN_AGE_TERM_FLAG().equals("H")){
				compositeAction.getWizard().disableWizardItemForId("5");
			}else if(null!=planBean.getPLAN_AGE_TERM_FLAG()&&!planBean.getPLAN_AGE_TERM_FLAG().isEmpty()
					&&planBean.getPLAN_AGE_TERM_FLAG().equals("S")){
				compositeAction.getWizard().enableWizardItemForId("5");
			}
			
			if(null!=planBean.getPLAN_AGE_TERM_FLAG()&&!planBean.getPLAN_AGE_TERM_FLAG().isEmpty()
					&&planBean.getPLAN_AGE_TERM_FLAG().equals("H")){
				compositeAction.getWizard().disableWizardItemForId("4");
			}else if(null!=planBean.getPLAN_AGE_TERM_FLAG()&&!planBean.getPLAN_AGE_TERM_FLAG().isEmpty()
					&&planBean.getPLAN_AGE_TERM_FLAG().equals("S")){
				compositeAction.getWizard().enableWizardItemForId("4");
			}
			
			
			String compPlan_Term_Flag=compositeAction.getPM_IL_PLAN_ACTION_BEAN().getCOMP_PLAN_AGE_TERM_FLAG().getValue().toString();
			if((null==planBean.getPLAN_AGE_TERM_FLAG()||planBean.getPLAN_AGE_TERM_FLAG().isEmpty())
					&&(null!=compPlan_Term_Flag&&!compPlan_Term_Flag.isEmpty()&&compPlan_Term_Flag.equalsIgnoreCase("H"))){
				compositeAction.getWizard().disableWizardItemForId("5");
			}else if((null==planBean.getPLAN_AGE_TERM_FLAG()||planBean.getPLAN_AGE_TERM_FLAG().isEmpty())
					&&(null!=compPlan_Term_Flag&&!compPlan_Term_Flag.isEmpty()&&compPlan_Term_Flag.equalsIgnoreCase("S"))){
				compositeAction.getWizard().enableWizardItemForId("5");
			}
			
			if((null==planBean.getPLAN_AGE_TERM_FLAG()||planBean.getPLAN_AGE_TERM_FLAG().isEmpty())
					&&(null!=compPlan_Term_Flag&&!compPlan_Term_Flag.isEmpty()&&compPlan_Term_Flag.equalsIgnoreCase("H"))){
				compositeAction.getWizard().disableWizardItemForId("4");
			}else if((null==planBean.getPLAN_AGE_TERM_FLAG()||planBean.getPLAN_AGE_TERM_FLAG().isEmpty())
					&&(null!=compPlan_Term_Flag&&!compPlan_Term_Flag.isEmpty()&&compPlan_Term_Flag.equalsIgnoreCase("S"))){
				compositeAction.getWizard().enableWizardItemForId("4");
			}
			
			
	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void WHEN_CREATE_RECORD(PM_IL_PLAN planBean){
		planBean.setPLAN_PYMT_ON_MAT_YN("Y") ;
		planBean.setPLAN_SA_INST_PYMT_YN("N") ;
		planBean.setPLAN_SURR_YN("Y") ;
		//planBean.setPLAN_LOAN_YN("Y");
		planBean.setPLAN_SURR_YN("Y");
		planBean.setPLAN_REBATE_YN("Y") ;
		planBean.setPLAN_FACIN_YN("N"); 	 
		planBean.setPLAN_RED_SA_BASIS("T"); 	           
		planBean.setPLAN_REVIVAL_YN("N"); 	             
		planBean.setPLAN_SPL_REVIVAL_YN("N"); 	         
		planBean.setPLAN_POL_VALID_AFTER_MAT_YN("N"); 	 
		planBean.setPLAN_AGE_TERM_FLAG("H");               
	}
	
	public void ON_CHECK_DELETE_MASTER(PM_IL_PLAN planBean) throws Exception{
		String value = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		String C1 = "SELECT 1 FROM PM_IL_PLAN_AGE_SETUP P WHERE P.PAS_PLAN_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{planBean.getPLAN_CODE()});
			if(resultSet.next()){
				value = resultSet.getString(1);
				throw new Exception("Cannot delete master record when matching detail records exist.");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {	}
		}
	}
	
	public void PRE_QUERY(PM_IL_PLAN planBean,COPY_PLAN copyPlanBean){
		if(copyPlanBean.getUI_M_NEW_PLAN_CODE() != null){
			planBean.setPLAN_CODE(copyPlanBean.getUI_M_NEW_PLAN_CODE());
		}
	}
	
	
	
	public void whenValidate_PLAN_CODE(PM_IL_PLAN planBean, DUMMY dummyBean) throws Exception{
		Double M_MIN_SA = 0.0;
		Double M_MAX_SA = 0.0;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		ArrayList<OracleParameter> list = null;
		String C1 = " SELECT COVER_MIN_SA,COVER_MAX_SA,COVER_SA_CALC FROM PM_IL_COVER WHERE  COVER_CODE = ? ";
		try {
			L_UNIQUE_PLAN_CODE(planBean.getPLAN_CODE(),planBean.getROWID());
			list = new PKG_PILM003().L_VAL_PLAN_CODE(planBean.getPLAN_CODE(), null, "B", "N", "E");
			if(list.size() > 0 && list.get(0).getValue() != null){
				planBean.setUI_M_PLAN_DESC(list.get(0).getValue());
			}
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{planBean.getPLAN_CODE()});
			if(resultSet.next()){
				M_MIN_SA = resultSet.getDouble(1);
				M_MAX_SA = resultSet.getDouble(2);
				if(dummyBean != null){
				dummyBean.setUI_M_COVER_SA_CALC(resultSet.getString(3));
			
				}
			}
			planBean.setPLAN_MIN_SA(M_MIN_SA);
			planBean.setPLAN_MAX_SA(M_MAX_SA);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidate_PLAN_TYPE(PM_IL_PLAN planBean, DUMMY dummyBean) throws Exception{
		ArrayList<String> list = null;
		String planTypeDesc = null;
		Integer A = 0;
		try {
			list = DBProcedures.P_VAL_SYSTEM("ILPLANTYPE", planBean.getPLAN_TYPE(), null, "E", CommonUtils.getProcedureValue(A));
				planTypeDesc = list.get(0);
				planBean.setUI_M_PLAN_TYPE_DESC(planTypeDesc);
				A = Integer.parseInt(list.get(1));
			if(dummyBean  != null){
			if("P".equals(dummyBean.getUI_M_COVER_SA_CALC()) && "M".equals(planBean.getPLAN_TYPE())){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91421"));
			}
			
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidate_PLAN_AGE_TERM_FLAG(PILM003_APAC_COMPOSITE_ACTION compositeAction){
		PM_IL_PLAN planBean = null;
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		if(planBean.getPLAN_AGE_TERM_FLAG().equals("H")){
			compositeAction.getWizard().disableWizardItemForId("4");
			
			//compositeAction.getTabbedBar().setTabDisabled(5);
		}else if(planBean.getPLAN_AGE_TERM_FLAG().equals("S")){
			compositeAction.getWizard().enableWizardItemForId("4");
			//compositeAction.getTabbedBar().setTabEnabled(5);
		}
		if(planBean.getPLAN_AGE_TERM_FLAG().equals("H")){
			compositeAction.getWizard().disableWizardItemForId("5");
			
			//compositeAction.getTabbedBar().setTabDisabled(6);
		}else if(planBean.getPLAN_AGE_TERM_FLAG().equals("S")){
			//compositeAction.getTabbedBar().setTabEnabled(6);
			compositeAction.getWizard().enableWizardItemForId("5");
			
		}
	}
	
	public void whenValidate_PLAN_PERIOD_FROM(PM_IL_PLAN planBean,Integer PLAN_PERIOD_FROM ){
		/*:PM_IL_PLAN.PLAN_PERIOD_TO := :PM_IL_PLAN.PLAN_PERIOD_TO;
		:PM_IL_PLAN.PLAN_SURR_YRS  := :PM_IL_PLAN.PLAN_SURR_YRS;*/
		if(planBean.getPLAN_AGE_TO() != null){
		planBean.setPLAN_MAX_AGE_ON_MAT(PLAN_PERIOD_FROM + planBean.getPLAN_AGE_TO());
		if(planBean.getPLAN_AGE_FROM() != null){
		planBean.setPLAN_MIN_AGE_ON_MAT(PLAN_PERIOD_FROM + planBean.getPLAN_AGE_FROM());
		}
		}
	}
	
	public void whenValiadate_PLAN_PERIOD_TO(PM_IL_PLAN planBean,Integer PLAN_PERIOD_TO) throws Exception{
		if(PLAN_PERIOD_TO < planBean.getPLAN_PERIOD_FROM()){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71014"));
		}
	}
	
	public void whenValidate_PLAN_AGE_FROM(PM_IL_PLAN planBean,Integer PLAN_AGE_FROM){
		//:PM_IL_PLAN.PLAN_AGE_TO := :PM_IL_PLAN.PLAN_AGE_TO;
		planBean.setPLAN_MIN_AGE_ON_MAT(planBean.getPLAN_PERIOD_FROM() + PLAN_AGE_FROM);
	}
	
	public void whenValidate_PLAN_AGE_TO(PM_IL_PLAN planBean,Integer PLAN_AGE_TO) throws Exception{
		if(PLAN_AGE_TO < planBean.getPLAN_AGE_FROM()){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71013"));
		}
		//:PM_IL_PLAN.PLAN_MAX_AGE_ON_MAT := :PM_IL_PLAN.PLAN_PERIOD_FROM + :PM_IL_PLAN.PLAN_AGE_TO;
	}
	
	public void whenValidate_PLAN_MIN_SA(PM_IL_PLAN planBean,Double PLAN_MIN_SA) throws Exception{
		if(PLAN_MIN_SA != null){
			if(PLAN_MIN_SA < 0 ){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91018"));
			}
			if(planBean.getPLAN_MAX_SA() > 0.0){
			if(PLAN_MIN_SA > planBean.getPLAN_MAX_SA()){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91020"));
			}
			}
		}
	}
	
	public void whenValidate_PLAN_MAX_SA(PM_IL_PLAN planBean,Double PLAN_MAX_SA) throws Exception{
		if(PLAN_MAX_SA != null){
			if(PLAN_MAX_SA < 0 ){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91018"));
			}
			if(PLAN_MAX_SA < planBean.getPLAN_MIN_SA()){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91020"));
			}
		}
	}
	
	public void whenValidate_PLAN_PYMT_ON_MAT_YN(PM_IL_PLAN_ACTION planAction,
					String PLAN_PYMT_ON_MAT_YN){
		PM_IL_PLAN planBean = null;
		planBean = planAction.getPM_IL_PLAN_BEAN();
		if(PLAN_PYMT_ON_MAT_YN.equals("Y")){
			planAction.getCOMP_PLAN_SA_INST_PYMT_YN().setDisabled(false);
		}else{
			planAction.getCOMP_PLAN_SA_INST_PYMT_YN().setDisabled(true);
		}
		if(planBean.getPLAN_SA_INST_PYMT_YN() != null){
		if(planBean.getPLAN_SA_INST_PYMT_YN().equals("Y") && PLAN_PYMT_ON_MAT_YN.equals("N")){
			planBean.setPLAN_SA_INST_PYMT_YN("N");
		}
		}
	}
	
	public void whenValidate_PLAN_SURR_YN(PILM003_APAC_COMPOSITE_ACTION compositeAction, String PLAN_SURR_YN){
		PM_IL_PLAN_ACTION planAction = null;
		PM_IL_PLAN planBean = null;
		planAction = compositeAction.getPM_IL_PLAN_ACTION_BEAN();
		planBean = planAction.getPM_IL_PLAN_BEAN();
		if(PLAN_SURR_YN.equals("Y")){
			planAction.getCOMP_PLAN_SURR_YRS().setDisabled(false);
			// :PM_IL_PLAN.PLAN_SURR_YRS := :PM_IL_PLAN.PLAN_SURR_YRS;
			planAction.getCOMP_PLAN_SURR_YRS().setRequired(true);
			//compositeAction.getTabbedBar().setTabEnabled(3);
			compositeAction.getWizard().enableWizardItemForId("2");
		}
		else{
			planAction.getCOMP_PLAN_SURR_YRS().setDisabled(true);
			// :PM_IL_PLAN.PLAN_SURR_YRS := :PM_IL_PLAN.PLAN_SURR_YRS;
			planAction.getCOMP_PLAN_SURR_YRS().setRequired(false);
			//compositeAction.getTabbedBar().setTabDisabled(3);
			compositeAction.getWizard().disableWizardItem("2");
		}
		if(planBean.getPLAN_SURR_YRS() != null && PLAN_SURR_YN.equals("N")){
			planBean.setPLAN_SURR_YRS(null);
		}
	}
	
	public void whenValidate_PLAN_SURR_YRS(PM_IL_PLAN planBean ,Integer PLAN_SURR_YRS) throws Exception{
		if(null!=PLAN_SURR_YRS&&PLAN_SURR_YRS<0){
			throw new Exception(" Surrender Years Value Should be Greater than Zero");
		}
		if(PLAN_SURR_YRS > planBean.getPLAN_PERIOD_FROM()){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",
					new Object[]{"Surrender Years","<=","Minimum Period In Years"}));
		}
		//:PM_IL_PLAN.PLAN_PERIOD_TO := :PM_IL_PLAN.PLAN_PERIOD_TO;
	}
	
	
	public void whenValidate_PLAN_MIN_AGE_ON_MAT(PM_IL_PLAN planBean ,Integer PLAN_MIN_AGE_ON_MAT) throws Exception{
		if(planBean.getPLAN_MAX_AGE_ON_MAT() != null){
			if(PLAN_MIN_AGE_ON_MAT <= 0){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91026"));
			}
			if (PLAN_MIN_AGE_ON_MAT < (planBean.getPLAN_AGE_FROM() + planBean
					.getPLAN_PERIOD_FROM())) {
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"91014",
										new Object[] { "Minimum Age','>=','(Minimum period + Minimum Age)" }));
			}
			if (PLAN_MIN_AGE_ON_MAT > planBean.getPLAN_MAX_AGE_ON_MAT()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71158",
						new Object[] { planBean.getPLAN_MAX_AGE_ON_MAT() }));
			}
		}
		
	}
	
	public void whenValidate_PLAN_MAX_AGE_ON_MAT(PM_IL_PLAN planBean ,Integer PLAN_MAX_AGE_ON_MAT) throws Exception{
		if(PLAN_MAX_AGE_ON_MAT != null){
			if(PLAN_MAX_AGE_ON_MAT <= 0 ){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91026"));
			}
			if(PLAN_MAX_AGE_ON_MAT < (planBean.getPLAN_AGE_TO() + planBean.getPLAN_PERIOD_FROM())){
				throw new Exception(
						Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"91014",
										new Object[] { "Maximum Age','>=','(Minimum period + Maximum Age)" }));
			}
			if(PLAN_MAX_AGE_ON_MAT < planBean.getPLAN_MIN_AGE_ON_MAT()){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71158",
						new Object[] { planBean.getPLAN_MIN_AGE_ON_MAT() }));
			}
		}
	}
	
	public void whenValidate_PLAN_REVIVAL_YN(PM_IL_PLAN_ACTION planAction ,String PLAN_REVIVAL_YN){
		PM_IL_PLAN planBean = null;
		planBean = planAction.getPM_IL_PLAN_BEAN();
		if(PLAN_REVIVAL_YN.equals("Y")){
			planAction.getCOMP_PLAN_REVIVAL_YRS().setDisabled(false);
		}else{
			planAction.getCOMP_PLAN_REVIVAL_YRS().setDisabled(true);
			planAction.getCOMP_PLAN_REVIVAL_YRS().setSubmittedValue("0"); 
		}
		if(planBean.getPLAN_REVIVAL_YRS() != null && PLAN_REVIVAL_YN.equals("N")){
			planBean.setPLAN_REVIVAL_YRS(0);
		}	
	}
	
	public void whenValidate_PLAN_REVIVAL_YRS(Integer PLAN_REVIVAL_YRS) throws Exception{
		if(PLAN_REVIVAL_YRS != null){
			if(PLAN_REVIVAL_YRS < 0 ){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91018"));
			}
			
		}
	}
	
	public void whenValidate_PLAN_SPL_REVIVAL_YN(PM_IL_PLAN_ACTION planAction ,String PLAN_SPL_REVIVAL_YN){
		PM_IL_PLAN planBean = null;
		planBean = planAction.getPM_IL_PLAN_BEAN();
		if(PLAN_SPL_REVIVAL_YN.equals("Y")){
			planAction.getCOMP_PLAN_SPL_REVIVAL_YRS().setDisabled(false);
		}else{
			planAction.getCOMP_PLAN_SPL_REVIVAL_YRS().setDisabled(true);
			planAction.getCOMP_PLAN_SPL_REVIVAL_YRS().setSubmittedValue("0"); 
		}
		if(planBean.getPLAN_SPL_REVIVAL_YRS() != null && PLAN_SPL_REVIVAL_YN.equals("N")){
			planBean.setPLAN_SPL_REVIVAL_YRS(0);
		}
	}
	
	public void whenValidate_PLAN_SPL_REVIVAL_YRS(Integer PLAN_SPL_REVIVAL_YRS) throws Exception{
		if(PLAN_SPL_REVIVAL_YRS != null){
			if(PLAN_SPL_REVIVAL_YRS < 0){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91018"));
			}
		}
	}
	
	
}
