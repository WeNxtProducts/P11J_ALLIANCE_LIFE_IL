package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PLAN_AGE_SETUP_HELPER {

	public void executeQuery(PILM003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_PLAN_AGE_SETUP_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_PLAN_AGE_SETUP> dataList = compositeAction
				.getPM_IL_PLAN_AGE_SETUP_ACTION_BEAN()
				.getDataList_PM_IL_PLAN_AGE_SETUP();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_PLAN_AGE_SETUP PM_IL_PLAN_AGE_SETUP_BEAN = dataList.get(0);
			PM_IL_PLAN_AGE_SETUP_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_PLAN_AGE_SETUP_ACTION_BEAN()
					.setPM_IL_PLAN_AGE_SETUP_BEAN(PM_IL_PLAN_AGE_SETUP_BEAN);
		}
	}
	
	public void whenNewBlockInstance(PILM003_APAC_COMPOSITE_ACTION compositeAction){
		PM_IL_PLAN planBean = null;
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		if(planBean.getPLAN_AGE_TERM_FLAG().equals("S")){
			//compositeAction.getTabbedBar().setTabEnabled(5);
			compositeAction.getWizard().enableWizardItemForId("4");
		}else if(planBean.getPLAN_AGE_TERM_FLAG().equals("H")){
			//compositeAction.getTabbedBar().setTabDisabled(5);
			compositeAction.getWizard().disableWizardItemForId("4");
		}		
	}
	
	public void L_UNIQUE_PLAN_AGE_SETUP(PM_IL_PLAN_AGE_SETUP ageSetupBean,
			PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_DUMMY = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		PM_IL_PLAN planBean = null;
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		String C1 = "SELECT 'X' FROM   PM_IL_PLAN_AGE_SETUP  WHERE  PAS_PLAN_CODE  = ? " +
					" AND    PAS_JOINT_LIFE_YN   = ? AND ( ?  BETWEEN PAS_CATG_FM_CODE AND  PAS_CATG_TO_CODE " +
					"   OR   ?    BETWEEN PAS_CATG_FM_CODE    " +
					"AND  PAS_CATG_TO_CODE)    AND    (  ?   " +
					" BETWEEN PAS_ASSRD_AGE_FM    AND  PAS_ASSRD_AGE_TO         " +
					"    OR  ?    BETWEEN PAS_ASSRD_AGE_FM   " +
					" AND  PAS_ASSRD_AGE_TO)";
		String C2 = " SELECT 'X'  FROM   PM_IL_PLAN_AGE_SETUP  WHERE  PAS_PLAN_CODE  = ? " +
					" AND    PAS_JOINT_LIFE_YN   = ? AND    " +
					"( ?   BETWEEN PAS_CATG_FM_CODE    " +
					"AND  PAS_CATG_TO_CODE        OR     ? " +
					"BETWEEN PAS_CATG_FM_CODE    AND  PAS_CATG_TO_CODE)   AND    (    ?   " +
					" BETWEEN PAS_ASSRD_AGE_FM    AND  PAS_ASSRD_AGE_TO OR  ?   " +
					" BETWEEN PAS_ASSRD_AGE_FM    AND  PAS_ASSRD_AGE_TO)  AND    ROWID  <> ?";
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			if(ageSetupBean.getROWID() == null){
				resultSet = handler.executeSelectStatement(C1, connection, new Object[]{planBean.getPLAN_CODE(),
						ageSetupBean.getPAS_JOINT_LIFE_YN(),
						ageSetupBean.getPAS_CATG_FM_CODE(),
						ageSetupBean.getPAS_CATG_TO_CODE(),
						ageSetupBean.getPAS_ASSRD_AGE_FM(),
						ageSetupBean.getPAS_ASSRD_AGE_TO()});
				if(resultSet.next()){
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1033"));
				}
			}else{
					resultSet = handler.executeSelectStatement(C2 , connection,  new Object[]{planBean.getPLAN_CODE(),
							ageSetupBean.getPAS_JOINT_LIFE_YN(),
							ageSetupBean.getPAS_CATG_FM_CODE(),
							ageSetupBean.getPAS_CATG_TO_CODE(),
							ageSetupBean.getPAS_ASSRD_AGE_FM(),
							ageSetupBean.getPAS_ASSRD_AGE_TO(),
							ageSetupBean.getROWID()});
					if(resultSet.next()){
						M_DUMMY = resultSet.getString(1);
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1033"));
					}
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
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				
			}
		}
	}
	
	public void L_UNQ_CHK_FOR_JOINT_LIFE(PM_IL_PLAN_AGE_SETUP ageSetupBean,
			PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_DUMMY = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		PM_IL_PLAN planBean = null;
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		String C1 = " SELECT  'X' FROM  PM_IL_PLAN_AGE_SETUP WHERE  " +
				" PAS_PLAN_CODE = ?  AND PAS_JOINT_LIFE_YN = 'Y' " +
				" AND  PAS_AGE_BASIS = DECODE( ? ,'R','E','E','R')";
		String C2 = "SELECT  'X' FROM PM_IL_PLAN_AGE_SETUP " +
				" WHERE   PAS_PLAN_CODE = ?  AND  PAS_JOINT_LIFE_YN = 'Y' " +
				" AND  PAS_AGE_BASIS = DECODE( ?,'R','E','E','R') " +
				" AND     ROWID <> ?";
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(ageSetupBean.getROWID() == null){
				resultSet = handler.executeSelectStatement(C1, connection, new Object[]{planBean.getPLAN_CODE(),
							ageSetupBean.getPAS_AGE_BASIS()});
				if(resultSet.next()){
					M_DUMMY = resultSet.getString(1);
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "For a Joint Life only Payer or Payee is possible" }));
				}
			}else{
				resultSet = handler.executeSelectStatement(C2, connection, new Object[]{planBean.getPLAN_CODE(),
							ageSetupBean.getPAS_AGE_BASIS(),
							ageSetupBean.getROWID()});
				if(resultSet.next()){
					M_DUMMY = resultSet.getString(1);
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "For a Joint Life only Payer or Payee is possible" }));
				}
				
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
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void preInsert(PM_IL_PLAN_AGE_SETUP ageSetupBean,
			PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		try {
			L_UNIQUE_PLAN_AGE_SETUP(ageSetupBean, compositeAction);
			if(ageSetupBean.getPAS_JOINT_LIFE_YN().equals("Y")){
				L_UNQ_CHK_FOR_JOINT_LIFE(ageSetupBean, compositeAction);
			}
			ageSetupBean.setPAS_CR_DT(new CommonUtils().getCurrentDate());
			ageSetupBean.setPAS_CR_UID(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID());
			ageSetupBean.setPAS_PLAN_CODE(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE());
		}
		 catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void preUpdate(PM_IL_PLAN_AGE_SETUP ageSetupBean,
			PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		try {
			L_UNIQUE_PLAN_AGE_SETUP(ageSetupBean, compositeAction);
			if(ageSetupBean.getPAS_JOINT_LIFE_YN().equals("Y")){
				L_UNQ_CHK_FOR_JOINT_LIFE(ageSetupBean, compositeAction);
			}
			ageSetupBean.setPAS_UPD_DT(new CommonUtils().getCurrentDate());
			ageSetupBean.setPAS_UPD_UID(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID());
			ageSetupBean.setPAS_PLAN_CODE(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE());
		}
		 catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenCreateRecord(PM_IL_PLAN_AGE_SETUP ageSetupBean){
		ageSetupBean.setPAS_JOINT_LIFE_YN("N");
		ageSetupBean.setPAS_AGE_BASIS("R");
		ageSetupBean.setPAS_ASSRD_AGE_FM(1);
		ageSetupBean.setPAS_ASSRD_AGE_TO(99);
	}
	
	public void whenValidate_PAS_JOINT_LIFE_YN(PM_IL_PLAN_AGE_SETUP_ACTION PM_IL_PLAN_AGE_SETUP_ACTION_BEAN , String PAS_JOINT_LIFE_YN){
		if(PAS_JOINT_LIFE_YN.equals("N")){
			PM_IL_PLAN_AGE_SETUP_ACTION_BEAN.getPM_IL_PLAN_AGE_SETUP_BEAN().setPAS_AGE_BASIS("R");
			PM_IL_PLAN_AGE_SETUP_ACTION_BEAN.getCOMP_PAS_AGE_BASIS().setDisabled(true);
		}else{
			PM_IL_PLAN_AGE_SETUP_ACTION_BEAN.getCOMP_PAS_AGE_BASIS().setDisabled(false);
		}
	}
	
	public void whenValidate_PAS_AGE_BASIS( PILM003_APAC_COMPOSITE_ACTION compositeAction ,String PAS_AGE_BASIS){
		PM_IL_PLAN_AGE_SETUP ageSetupBean = compositeAction.getPM_IL_PLAN_AGE_SETUP_ACTION_BEAN()
														.getPM_IL_PLAN_AGE_SETUP_BEAN();
		if(ageSetupBean.getPAS_JOINT_LIFE_YN().equals("N") && PAS_AGE_BASIS.equals("E")){
			compositeAction.getPM_IL_PLAN_AGE_SETUP_ACTION_BEAN().getWarningMap().
						put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								Messages.getString(PELConstants.pelErrorMessagePath, "3206", 
										new Object[]{"Age Basis should be Payer only"}));	
			ageSetupBean.setPAS_AGE_BASIS("R");
		}
	}
	
	public void whenValidate_PAS_CATG_FM_CODE(PM_IL_PLAN_AGE_SETUP ageSetupBean, String PAS_CATG_FM_CODE ) throws Exception{
		ArrayList<String> list = null;
		Integer M_VALUE = 0;
		if(ageSetupBean.getPAS_CATG_TO_CODE() != null){
			try {
				list = new DBProcedures().P_VAL_SYSTEM("CATG", PAS_CATG_FM_CODE, null, "E", CommonUtils.getProcedureValue(M_VALUE));
				if(list.size() > 0 && list.get(0) != null){
					ageSetupBean.setUI_M_PAS_CATG_FM_CODE_DESC(list.get(0));
				}
				if(list.size() > 0 && list.get(1) != null){
					M_VALUE = Integer.parseInt(list.get(1));
				}
				if(PAS_CATG_FM_CODE.compareToIgnoreCase(ageSetupBean.getPAS_CATG_TO_CODE()) > 0){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}
	
	public void whenValidatePAS_CATG_TO_CODE(PM_IL_PLAN_AGE_SETUP ageSetupBean, String PAS_CATG_TO_CODE ) throws Exception{
		ArrayList<String> list = null;
		Integer M_VALUE = 0;
		if(ageSetupBean.getPAS_CATG_FM_CODE() != null){
			try {
				list = new DBProcedures().P_VAL_SYSTEM("CATG", PAS_CATG_TO_CODE, null, "E", CommonUtils.getProcedureValue(M_VALUE));
				if(list.size() > 0 && list.get(0) != null){
					ageSetupBean.setUI_M_PAS_CATG_TO_CODE_DESC(list.get(0));
				}
				if(list.size() > 0 && list.get(1) != null){
					M_VALUE = Integer.parseInt(list.get(1));
				}
				if(ageSetupBean.getPAS_CATG_FM_CODE().compareTo(PAS_CATG_TO_CODE) > 0 ){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}
	
	public void whenValiadate_PAS_ASSRD_AGE_FM(PM_IL_PLAN_AGE_SETUP ageSetupBean, Integer PAS_ASSRD_AGE_FM) throws Exception{
		if(ageSetupBean.getPAS_ASSRD_AGE_TO() != null){
			if(PAS_ASSRD_AGE_FM > ageSetupBean.getPAS_ASSRD_AGE_TO()){
				try {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
			}
		}
	}
	
	
	public void whenValiadate_PAS_ASSRD_AGE_TO(PM_IL_PLAN_AGE_SETUP ageSetupBean, Integer PAS_ASSRD_AGE_TO) throws Exception{
		if(ageSetupBean.getPAS_ASSRD_AGE_FM() != null){
			if(ageSetupBean.getPAS_ASSRD_AGE_FM() > PAS_ASSRD_AGE_TO){
				try {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
			}
		}
	}
	
	
	public void whenValiadate_PAS_MIN_AGE(PM_IL_PLAN_AGE_SETUP ageSetupBean, Integer PAS_MIN_AGE) throws Exception{
		try {
		if(PAS_MIN_AGE != null && ageSetupBean.getPAS_MAX_AGE() != null){
			if(PAS_MIN_AGE > ageSetupBean.getPAS_MAX_AGE()){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				
			}
		}
		if(ageSetupBean.getPAS_MIN_PERIOD() != null){
		ageSetupBean.setPAS_MIN_AGE_ON_MAT(PAS_MIN_AGE + ageSetupBean.getPAS_MIN_PERIOD());
		} 
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void whenValiadate_PAS_MAX_AGE(PM_IL_PLAN_AGE_SETUP ageSetupBean, Integer PAS_MAX_AGE) throws Exception{
		try {
		if(PAS_MAX_AGE != null && ageSetupBean.getPAS_MIN_AGE() != null){
			if(ageSetupBean.getPAS_MIN_AGE() > PAS_MAX_AGE){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				
			}
		}
		if(ageSetupBean.getPAS_MIN_PERIOD() != null){
		ageSetupBean.setPAS_MAX_AGE_ON_MAT(PAS_MAX_AGE + ageSetupBean.getPAS_MIN_PERIOD());
		} 
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidate_PAS_MIN_PERIOD(PM_IL_PLAN_AGE_SETUP ageSetupBean, Integer PAS_MIN_PERIOD) throws Exception{
		try{
			if(ageSetupBean.getPAS_MAX_PERIOD() != null){
				if(PAS_MIN_PERIOD > ageSetupBean.getPAS_MAX_PERIOD()){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
			}
		}
			if(ageSetupBean.getPAS_MAX_AGE() != null){
			ageSetupBean.setPAS_MAX_AGE_ON_MAT(ageSetupBean.getPAS_MAX_AGE() + PAS_MIN_PERIOD);
			}
			if(ageSetupBean.getPAS_MIN_AGE() != null){
				ageSetupBean.setPAS_MIN_AGE_ON_MAT(ageSetupBean.getPAS_MIN_AGE() + PAS_MIN_PERIOD);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void whenValidate_PAS_MAX_PERIOD(PM_IL_PLAN_AGE_SETUP ageSetupBean, Integer PAS_MAX_PERIOD) throws Exception{
		if(ageSetupBean.getPAS_MIN_PERIOD() != null){
			if(ageSetupBean.getPAS_MIN_PERIOD() > PAS_MAX_PERIOD){
				try {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
			}
		}
	}
	
	public void whenValidate_PAS_MIN_AGE_ON_MAT(PM_IL_PLAN_AGE_SETUP ageSetupBean, Integer PAS_MIN_AGE_ON_MAT) throws Exception{
		try{
			if(PAS_MIN_AGE_ON_MAT != null){
				if(PAS_MIN_AGE_ON_MAT < 0 ){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91026"));
				}
				if(ageSetupBean.getPAS_MIN_AGE() != null && ageSetupBean.getPAS_MIN_PERIOD() != null){
				if(PAS_MIN_AGE_ON_MAT < (ageSetupBean.getPAS_MIN_AGE() + ageSetupBean.getPAS_MIN_PERIOD() )){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",
											new Object[]{"Minimum Age','>=','(Minimum period + Minimum Age)"}));
				}
				}
				if(ageSetupBean.getPAS_MAX_AGE_ON_MAT() != null){
				if(PAS_MIN_AGE_ON_MAT  > ageSetupBean.getPAS_MAX_AGE_ON_MAT() ){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void whenValidate_PAS_MAX_AGE_ON_MAT(PM_IL_PLAN_AGE_SETUP ageSetupBean, Integer PAS_MAX_AGE_ON_MAT) throws Exception{
		try{
			if(PAS_MAX_AGE_ON_MAT != null){
				if(PAS_MAX_AGE_ON_MAT <= 0 ){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91026"));
				}
				if(ageSetupBean.getPAS_MAX_AGE() != null && ageSetupBean.getPAS_MIN_PERIOD() != null){
				if(PAS_MAX_AGE_ON_MAT < (ageSetupBean.getPAS_MAX_AGE() + ageSetupBean.getPAS_MIN_PERIOD() )){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",
											new Object[]{"Maximum Age','>=','(Minimum period + Maximum Age)"}));
				}
				}
				if(ageSetupBean.getPAS_MIN_AGE_ON_MAT() != null){
				if(ageSetupBean.getPAS_MIN_AGE_ON_MAT()  > PAS_MAX_AGE_ON_MAT){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	
}
