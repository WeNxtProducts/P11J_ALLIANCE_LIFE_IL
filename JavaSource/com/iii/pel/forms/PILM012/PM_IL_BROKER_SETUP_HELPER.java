package com.iii.pel.forms.PILM012;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_BROKER_SETUP_HELPER {

	public void postQuery(
			PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN) throws Exception {
		PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN=PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN(); 
		ResultSet resultSet = null;
		Connection connection = null;
		Object[] values = null;
		ArrayList<String> list=new ArrayList<String>();
		CRUDHandler handler = new CRUDHandler();
		String C1="SELECT DECODE(?,'ENG',CCLAS_CLASS_DESC,CCLAS_BL_CLASS_DESC)" + 
		" FROM PM_CUST_CLASS WHERE CCLAS_CODE = ?" +
		" AND CCLAS_FRZ_FLAG = 'N'";
		
		try {
			connection=CommonUtils.getConnection();
			values = new Object[]{CommonUtils.getControlBean().getM_LANG_CODE(),PM_IL_BROKER_SETUP_BEAN.getBS_CUST_CLASS()};
			resultSet = handler.executeSelectStatement(C1, connection,values);
			if(resultSet.next()){
				
			PM_IL_BROKER_SETUP_BEAN.setUI_M_CUST_CLASS_DESC(resultSet.getString(1));
		
			}
			list=DBProcedures.helperP_VAL_COVER(PM_IL_BROKER_SETUP_BEAN.getBS_COVER_CODE(),"","N","N");
			if(list !=null && !(list.isEmpty())){
				
				PM_IL_BROKER_SETUP_BEAN.setUI_M_COVER_DESC(list.get(0));
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		}

	}

	public void pre_Insert(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN) throws Exception  {
		
		try {
			PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();
			L_VALIDATE_RANGE(PM_IL_BROKER_SETUP_ACTION_BEAN); 
			PM_IL_BROKER_SETUP_BEAN.setBS_CR_DT( new CommonUtils().getCurrentDate());
			PM_IL_BROKER_SETUP_BEAN.setBS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	
	}

	public void L_VALIDATE_RANGE(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN ) throws Exception{
		
		String  C1=" SELECT 'X' FROM  PM_IL_BROKER_SETUP WHERE BS_COVER_CODE = :PM_IL_BROKER_SETUP.BS_COVER_CODE" +
				" AND   BS_CUST_CLASS = :PM_IL_BROKER_SETUP.BS_CUST_CLASS" +
				" AND   BS_COMM_CODE  = :PM_IL_BROKER_SETUP.BS_COMM_CODE" +
				" AND   BS_APPLY_ON	 = :PM_IL_BROKER_SETUP.BS_APPLY_ON" +
				" AND (((:PM_IL_BROKER_SETUP.BS_YEARS_FROM BETWEEN BS_YEARS_FROM AND BS_YEARS_TO) OR " +
				" (:PM_IL_BROKER_SETUP.BS_YEARS_TO BETWEEN BS_YEARS_FROM AND BS_YEARS_TO)) OR" +
				" ((BS_YEARS_FROM BETWEEN :PM_IL_BROKER_SETUP.BS_YEARS_FROM AND :PM_IL_BROKER_SETUP.BS_YEARS_TO) " +
				" OR (BS_YEARS_TO BETWEEN :PM_IL_BROKER_SETUP.BS_YEARS_FROM AND :PM_IL_BROKER_SETUP.BS_YEARS_TO)))" +
				" AND (((:PM_IL_BROKER_SETUP.BS_TERM_FM BETWEEN BS_TERM_FM  AND BS_TERM_TO) OR " +
				" (:PM_IL_BROKER_SETUP.BS_TERM_TO BETWEEN BS_TERM_FM  AND BS_TERM_TO)) OR" +
				" ((BS_TERM_FM  BETWEEN :PM_IL_BROKER_SETUP.BS_TERM_FM  AND :PM_IL_BROKER_SETUP.BS_TERM_TO) OR " +
				" (BS_TERM_TO BETWEEN :PM_IL_BROKER_SETUP.BS_TERM_FM AND " +
				 " :PM_IL_BROKER_SETUP.BS_TERM_TO))) AND" +
				 " (((:PM_IL_BROKER_SETUP.BS_SA_FM BETWEEN BS_SA_FM  AND BS_SA_TO) OR " +
				 " (:PM_IL_BROKER_SETUP.BS_SA_TO BETWEEN BS_SA_FM  AND BS_SA_TO)) OR" +
				 " ((BS_SA_FM  BETWEEN :PM_IL_BROKER_SETUP.BS_SA_FM  AND :PM_IL_BROKER_SETUP.BS_SA_TO) " +
				 " OR (BS_SA_TO BETWEEN :PM_IL_BROKER_SETUP.BS_SA_FM AND :PM_IL_BROKER_SETUP.BS_SA_TO)))" +
				 " AND (((NVL(:PM_IL_BROKER_SETUP.BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) " +
				 " BETWEEN NVL(BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND " +
				 " NVL(BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')))" +
				 " OR  (NVL(:PM_IL_BROKER_SETUP.BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) " +
				 " BETWEEN NVL(BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND" +
				 " NVL(BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')))) OR" +
				 " ((NVL(BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN" +
				 "  NVL(:PM_IL_BROKER_SETUP.BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND " +
				 " NVL(:PM_IL_BROKER_SETUP.BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')))" +
				 " OR (NVL(BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN " +
				 " NVL(:PM_IL_BROKER_SETUP.BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND " +
				 " NVL(:PM_IL_BROKER_SETUP.BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')))))";

	String C2 =" SELECT 'X' FROM  PM_IL_BROKER_SETUP WHERE BS_COVER_CODE = :PM_IL_BROKER_SETUP.BS_COVER_CODE" +
			" AND   BS_CUST_CLASS = :PM_IL_BROKER_SETUP.BS_CUST_CLASS AND   " +
			" BS_COMM_CODE  = :PM_IL_BROKER_SETUP.BS_COMM_CODE AND BS_APPLY_ON = :PM_IL_BROKER_SETUP.BS_APPLY_ON" +
			" AND (((:PM_IL_BROKER_SETUP.BS_YEARS_FROM BETWEEN BS_YEARS_FROM AND BS_YEARS_TO) " +
			" OR (:PM_IL_BROKER_SETUP.BS_YEARS_TO BETWEEN BS_YEARS_FROM AND BS_YEARS_TO)) OR " +
			" ((BS_YEARS_FROM BETWEEN :PM_IL_BROKER_SETUP.BS_YEARS_FROM AND :PM_IL_BROKER_SETUP.BS_YEARS_TO) OR " +
			" (BS_YEARS_TO BETWEEN :PM_IL_BROKER_SETUP.BS_YEARS_FROM AND :PM_IL_BROKER_SETUP.BS_YEARS_TO)))" +
			" AND (((:PM_IL_BROKER_SETUP.BS_TERM_FM BETWEEN BS_TERM_FM  AND BS_TERM_TO) OR " +
			" (:PM_IL_BROKER_SETUP.BS_TERM_TO BETWEEN BS_TERM_FM  AND BS_TERM_TO)) OR" +
			" ((BS_TERM_FM  BETWEEN :PM_IL_BROKER_SETUP.BS_TERM_FM  AND :PM_IL_BROKER_SETUP.BS_TERM_TO) " +
			" OR (BS_TERM_TO BETWEEN :PM_IL_BROKER_SETUP.BS_TERM_FM AND :PM_IL_BROKER_SETUP.BS_TERM_TO)))" +
			" AND (((:PM_IL_BROKER_SETUP.BS_SA_FM BETWEEN BS_SA_FM  AND BS_SA_TO) OR " +
			" (:PM_IL_BROKER_SETUP.BS_SA_TO BETWEEN BS_SA_FM  AND BS_SA_TO)) OR" +
			"  ((BS_SA_FM  BETWEEN :PM_IL_BROKER_SETUP.BS_SA_FM  AND :PM_IL_BROKER_SETUP.BS_SA_TO) OR " +
			" (BS_SA_TO BETWEEN :PM_IL_BROKER_SETUP.BS_SA_FM AND :PM_IL_BROKER_SETUP.BS_SA_TO)))" +
			" AND (((NVL(:PM_IL_BROKER_SETUP.BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR'))" +
			" BETWEEN NVL(BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND " +
			" NVL(BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))) OR" +
			" (NVL(:PM_IL_BROKER_SETUP.BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN " +
			" NVL(BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND " +
			" NVL(BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')))) OR" +
			" ((NVL(BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN" +
			"  NVL(:PM_IL_BROKER_SETUP.BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND " +
			" NVL(:PM_IL_BROKER_SETUP.BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))) OR" +
			" (NVL(BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN " +
			" NVL(:PM_IL_BROKER_SETUP.BS_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND " +
			" NVL(:PM_IL_BROKER_SETUP.BS_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')))))" +
			" AND ROWID  != :PM_IL_BROKER_SETUP.ROWID" ;
	ResultSet resultSet1=null;
	ResultSet resultSet2=null;
	Connection connection=null;
	CRUDHandler handler=null;
	try {
	   /*if(SYSTEM.RECORD_STATUS = 'INSERT' THEN
	      FOR IREC IN C1
		       LOOP
		          IF C1%FOUND THEN
		             STD_MESSAGE_ROUTINE(91049,:CTRL.M_LANG_CODE);
		             RAISE FORM_TRIGGER_FAILURE;
		          END IF;
		       END LOOP;
	   ELSIF :SYSTEM.RECORD_STATUS = 'CHANGED' THEN
	      FOR UREC IN C2
		       LOOP
		          IF C2%FOUND THEN
		             STD_MESSAGE_ROUTINE(91049,:CTRL.M_LANG_CODE);
		             RAISE FORM_TRIGGER_FAILURE;
		          END IF;
	         END LOOP;
	   END IF;
	END;*/
	
	
	
	
	}catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	}
	

	public void pre_Update(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN) throws Exception {
		try{
		PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();		
		  L_VALIDATE_RANGE(PM_IL_BROKER_SETUP_ACTION_BEAN);
		  PM_IL_BROKER_SETUP_BEAN.setBS_UPD_DT(new CommonUtils().getCurrentDate());
		 PM_IL_BROKER_SETUP_BEAN.setBS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	}catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
		}
	}

	public void when_Create_Record(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN) throws Exception {
		try{
		PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();
		 PM_IL_BROKER_SETUP_BEAN.setBS_COMM_CODE("1006");
		 PM_IL_BROKER_SETUP_BEAN.setBS_APPLY_ON("1");
	}catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
		}
	}

	public void when_Validate_Cust_Class(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
			throws Exception {

		PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN
				.getPM_IL_BROKER_SETUP_BEAN();

		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<String> list = new ArrayList<String>();
		String C1 = "SELECT DECODE(?,'ENG',CCLAS_CLASS_DESC,CCLAS_BL_CLASS_DESC)"
				+ " FROM   PM_CUST_CLASS WHERE  CCLAS_CODE = ?"
				+ " AND    CCLAS_FRZ_FLAG = 'N'";
		try {
			connection=CommonUtils.getConnection();
			if (PM_IL_BROKER_SETUP_BEAN.getBS_CUST_CLASS() != null) {

				resultSet = handler.executeSelectStatement(C1, connection,
						new Object[] {CommonUtils.getControlBean().getM_LANG_CODE(),
						PM_IL_BROKER_SETUP_BEAN.getBS_CUST_CLASS()});
				if (resultSet.next()) {
					 PM_IL_BROKER_SETUP_BEAN.setUI_M_CUST_CLASS_DESC(resultSet.getString(1));
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71029"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

	}

	
	 public void when_Validate_Cover_Code(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN) 
	 throws Exception{
	  
	  PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN=PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();
	  
	  
	  ResultSet resultSet=null;
	  Connection connection=null; 
	  CRUDHandler handler = new CRUDHandler();
	  ArrayList<String> list = new ArrayList<String>();
	  Integer M_BS_YEARS_TO =null; 
	  Integer M_BS_YEARS_TO_1=null; 
	  String C1="SELECT MAX(BS_YEARS_TO) FROM PM_IL_BROKER_SETUP" +
	  " WHERE BS_CUST_CLASS = ?" + 
	  " AND BS_COVER_CODE = ?"; 
	  try{
		  connection=CommonUtils.getConnection();
	  list= DBProcedures.helperP_VAL_COVER(PM_IL_BROKER_SETUP_BEAN.getBS_COVER_CODE(),"","N","E");
	  if(!(list.isEmpty())&&list!=null){
		  PM_IL_BROKER_SETUP_BEAN.setUI_M_COVER_DESC(list.get(0));
	  } 
	 
	  resultSet=handler.executeSelectStatement(C1, connection,
			  new Object[]{PM_IL_BROKER_SETUP_BEAN.getBS_CUST_CLASS(),PM_IL_BROKER_SETUP_BEAN.getBS_COVER_CODE()});
	  if(resultSet.next()){
		  M_BS_YEARS_TO= resultSet.getInt(1);
	  }
	  M_BS_YEARS_TO_1 = M_BS_YEARS_TO + 1; 
	  if((CommonUtils.nvl(M_BS_YEARS_TO_1,0) >=4)){ 
		  throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91051"));
		  } 
	  else{
		  PM_IL_BROKER_SETUP_BEAN.setBS_YEARS_FROM(M_BS_YEARS_TO_1); 
	  }
	  
	  }
	  catch (Exception e) { 
		  e.printStackTrace(); 
		  throw new Exception(e.getMessage());
		  }
	  finally {
		  try {
			  CommonUtils.closeCursor(resultSet); 
			  } catch (Exception e) {
				  
			  } 
			  }
	  }
	 

	 
	 public void when_Validate_BS_TERM_FM(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
		throws Exception {

		try{
			PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();
			if (PM_IL_BROKER_SETUP_BEAN.getBS_TERM_FM() != null) {
			if (PM_IL_BROKER_SETUP_BEAN.getBS_TERM_FM() < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91052"));
			}
		}
		if (PM_IL_BROKER_SETUP_BEAN.getBS_TERM_FM() != null
				&& PM_IL_BROKER_SETUP_BEAN.getBS_TERM_TO() != null) {
			if (PM_IL_BROKER_SETUP_BEAN.getBS_TERM_FM() > PM_IL_BROKER_SETUP_BEAN
					.getBS_TERM_TO()) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91054"));
			}
		}
	}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void when_Validate_BS_TERM_TO(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
			throws Exception {

		try {
			PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();
			if (PM_IL_BROKER_SETUP_BEAN.getBS_TERM_TO() != null) {
				if (PM_IL_BROKER_SETUP_BEAN.getBS_TERM_TO() <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91026"));
			}
		}
			if (PM_IL_BROKER_SETUP_BEAN.getBS_TERM_FM() != null
			&& PM_IL_BROKER_SETUP_BEAN.getBS_TERM_TO() != null) {
			if (PM_IL_BROKER_SETUP_BEAN.getBS_TERM_FM() > PM_IL_BROKER_SETUP_BEAN
					.getBS_TERM_TO()) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91046"));
			}
			if (PM_IL_BROKER_SETUP_BEAN.getBS_TERM_TO() != null
					&& PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_TO() != null) {
				if (PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_TO() > PM_IL_BROKER_SETUP_BEAN
						.getBS_TERM_TO()) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91048"));
				}
			}
		}
	}	catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
}

	public void when_Validate_BS_SA_FM(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
			throws Exception {

		try {
			PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();
			if (PM_IL_BROKER_SETUP_BEAN.getBS_SA_FM() != null) {
				if (PM_IL_BROKER_SETUP_BEAN.getBS_SA_FM() < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91052"));
			}
			if (PM_IL_BROKER_SETUP_BEAN.getBS_SA_FM() != null
					&& PM_IL_BROKER_SETUP_BEAN.getBS_SA_TO() != null) {
				if (PM_IL_BROKER_SETUP_BEAN.getBS_SA_FM() > PM_IL_BROKER_SETUP_BEAN
						.getBS_SA_TO()) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91054"));
				}
			}
		}
	}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void when_Validate_BS_SA_TO(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
			throws Exception {
		try{
			PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();
		if (PM_IL_BROKER_SETUP_BEAN.getBS_SA_TO() != null) {
			if (PM_IL_BROKER_SETUP_BEAN.getBS_SA_TO() <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91026"));
			}
			if (PM_IL_BROKER_SETUP_BEAN.getBS_SA_FM() != null
					&& PM_IL_BROKER_SETUP_BEAN.getBS_SA_TO() != null) {
				if (PM_IL_BROKER_SETUP_BEAN.getBS_SA_FM() > PM_IL_BROKER_SETUP_BEAN
						.getBS_SA_TO()) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91046"));
				}
			}
		}
	}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void when_Validate_BS_YEARS_FROM(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
			throws Exception {
		
		try{
			PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();
		if (PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_FROM() != null) {
			if (PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_FROM() < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91052"));
			}
		}
		if (PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_FROM() != null
				&& PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_TO() != null) {
			if (PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_FROM() > PM_IL_BROKER_SETUP_BEAN
					.getBS_YEARS_TO()) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91054"));
			}
		}
	}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}	

	public void when_Validate_BS_YEARS_TO(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
			throws Exception {

		PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();
		try {
			if (PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_TO() != null) {

				if (PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_TO() <= 0) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91026"));
				}
			}

			if (PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_FROM() != null
					&& PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_TO() != null) {
				if (PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_FROM() > PM_IL_BROKER_SETUP_BEAN
						.getBS_YEARS_TO()) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91046"));
				}
			}
			if (PM_IL_BROKER_SETUP_BEAN.getBS_TERM_TO() != null
					&& PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_TO() != null) {
				if (PM_IL_BROKER_SETUP_BEAN.getBS_YEARS_TO() > PM_IL_BROKER_SETUP_BEAN
						.getBS_TERM_TO()) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91047"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void when_Validate_BS_PERC(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
			throws Exception {

		try {
			PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();
			if (PM_IL_BROKER_SETUP_BEAN.getBS_PERC() != null) {
				if (PM_IL_BROKER_SETUP_BEAN.getBS_PERC() < 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91052"));
			}
		}
		if (PM_IL_BROKER_SETUP_BEAN.getBS_PERC() != null) {
			if (PM_IL_BROKER_SETUP_BEAN.getBS_PERC() > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71017"));
			}
		}
	}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void when_Validate_BS_RATE_PER(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
			throws Exception {

		PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();

		if (PM_IL_BROKER_SETUP_BEAN.getBS_PERC() != null) {
				
			if (PM_IL_BROKER_SETUP_BEAN.getBS_PERC() <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91026"));
			}
		}

	}
	public void when_Validate_BS_EFF_FM_DT(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
			throws Exception {

		PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();

		if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_FM_DT() != null && PM_IL_BROKER_SETUP_BEAN.getBS_EFF_TO_DT() != null) {

			if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_FM_DT().after(PM_IL_BROKER_SETUP_BEAN.getBS_EFF_TO_DT())) {

				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91054"));
			}
		}
		if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_FM_DT() == null) {

			if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_TO_DT().after(CommonUtils.stringToDate("01/01/1900", "dd/MM/yyyy"))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91063"));
			}
		}
		if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_TO_DT() == null) {

			if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_FM_DT().after(CommonUtils.stringToDate("31/12/2999", "dd/MM/yyyy"))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91063"));
			}
		}

	}
	
	public void when_Validate_BS_EFF_TO_DT(PM_IL_BROKER_SETUP_ACTION PM_IL_BROKER_SETUP_ACTION_BEAN)
			throws Exception {

		PM_IL_BROKER_SETUP PM_IL_BROKER_SETUP_BEAN = PM_IL_BROKER_SETUP_ACTION_BEAN.getPM_IL_BROKER_SETUP_BEAN();

		if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_FM_DT() != null
				&& PM_IL_BROKER_SETUP_BEAN.getBS_EFF_TO_DT() != null) {

			if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_FM_DT().after(PM_IL_BROKER_SETUP_BEAN.getBS_EFF_TO_DT())) {

				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91046"));
			}
		}
		if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_FM_DT() == null) {

			if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_TO_DT().after(CommonUtils.stringToDate("01/01/1900", "DD/MM/RRRR"))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91063"));
			}
		}
		if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_TO_DT() == null) {

			if (PM_IL_BROKER_SETUP_BEAN.getBS_EFF_FM_DT().after(CommonUtils.stringToDate("31/12/2999", "DD/MM/RRRR"))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91063"));
			}
		}

	}
}