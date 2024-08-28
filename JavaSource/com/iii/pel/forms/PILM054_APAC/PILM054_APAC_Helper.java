package com.iii.pel.forms.PILM054_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILM054_APAC_Helper {

	Map<String, Object> session =   FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	FacesContext context= FacesContext.getCurrentInstance();
	
	
	public void preForm() {
		Map<String, Object> session =   FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("GLOBAL.M_FAILURE", "FALSE");
		STD_PRE_FORM();
	}
	
	
	private void STD_PRE_FORM(){
//		P_GET_LOGO;
//		COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');

		FacesContext ctx = FacesContext.getCurrentInstance();
		ControlBean controlBean = CommonUtils.getControlBean();
		Map<String, Object> session = ctx.getExternalContext().getSessionMap();
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()\n---------->\n"+session.toString()+"\n----------");
//		bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		controlBean.setM_PROG_NAME("PM0100_A");
//		COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM(------)" +(String)session.get("GLOBAL.M_NAME"));
//		COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		controlBean.setM_GOFLD_NAME("NULL");
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()--- \n "+controlBean.getM_LANG_CODE()+"\t"+controlBean.getM_COMP_CODE()+"\t"+controlBean.getM_PARA_1());
		/** GLOBAL.M_MODULE_NAME IS ADDED IN ORDER TO QUERY HINT DETAILS IN RECORD GROUP **/
		/* M_MODULE_NAME := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME) ;
   COPY(M_MODULE_NAME,'GLOBAL.M_MODULE_NAME') ;
   M_TITLE:= NAME_IN('CTRL.M_USER_ID') ||'                 '||NAME_IN('CTRL.M_SCR_NAME')||'          '||TO_CHAR(SYSDATE,'DD/MM/YY');
   SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
   HIDE_VIEW('ABOUT');
   M_FIRST_BLOCK := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(
                         CURRENT_FORM_NAME), FIRSTBLOCK) ;

   LOOP
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),1,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),3,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      M_FIRST_BLOCK := GET_BLOCK_PROPERTY(M_FIRST_BLOCK, NEXTBLOCK) ;
      IF M_FIRST_BLOCK IN ('DUAL','CTRL','BUTTON_PALETTE') THEN
         EXIT ;
      END IF ;
   END LOOP ;

   RG_ID	:= FIND_GROUP('RG_HINT') ;
   IF ID_NULL(RG_ID) THEN
      NULL ;
   ELSE
      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
   END IF ;
   RG_ID	:= FIND_GROUP('RG_ALERT_MSG') ;
   IF ID_NULL(RG_ID) THEN
      NULL ;
   ELSE
      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
   END IF ;
   LOAD_BP;
   ENABLE_BUTTONS ;
   IF M_MODULE_NAME NOT LIKE 'GNMNF001%' THEN
      LOAD_BALOON_LABEL;
   END IF;
END;*/
		session.put("controlBean", controlBean);
	}
	
	public void pilm054_apac_pm_il_ri_account_setup_post_query(PILM054_APAC_COMPOSITE_ACTION compositeAction) throws SQLException,Exception {
		PM_IL_RI_ACCOUNT_SETUP PM_IL_RI_ACCOUNT_SETUP_BEAN = compositeAction.getActionBean().getPM_IL_RI_ACCOUNT_SETUP_BEAN();
		/*PILM054_APAC_COMPOSITE_ACTION compositeAction = new PM_IL_RI_ACCOUNT_SETUP_HELPER().getManagedBeanActionInstance();
		PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();*/
		String RAS_MAIN_ACNT_CODE = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_MAIN_ACNT_CODE();
		String RAS_MAIN_ACNT_CODE_DESC = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_MAIN_ACNT_CODE_DESC();
		String RAS_SUB_ACNT_CODE = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_SUB_ACNT_CODE();
		String RAS_ANLY_CODE_1 = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_ANLY_CODE_1();
		String RAS_ANLY_CODE_2 = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_ANLY_CODE_2();
		String RAS_ACTY_CODE_1 = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_ACTY_CODE_1();
		String RAS_ACTY_CODE_2 = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_ACTY_CODE_2();
		String RAS_DIVN_CODE = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_DIVN_CODE();
		String RAS_DEPT_CODE = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_DEPT_CODE();
		/*String M_ACTY_1 = PM_IL_RI_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_1();
		String M_ACTY_2 = PM_IL_RI_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_2();*/
		String M_ACTY_1 = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_ACTY_1();
		String M_ACTY_2 = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_ACTY_2();
		
		String RAS_SUB_ACNT_CODE_DESC = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_SUB_ACNT_CODE_DESC();
		String RAS_ANLY_CODE_1_DESC = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_ANLY_CODE_1_DESC();
		String RAS_ANLY_CODE_2_DESC = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_ANLY_CODE_2_DESC();
		String RAS_ACTY_CODE_1_DESC = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_ACTY_CODE_1_DESC();
		String RAS_ACTY_CODE_2_DESC = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_ACTY_CODE_2_DESC();
		String RAS_DIVN_CODE_DESC = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_DIVN_CODE_DESC();
		String RAS_DEPT_CODE_DESC = PM_IL_RI_ACCOUNT_SETUP_BEAN.getRAS_DEPT_CODE_DESC();
		try {
			RAS_MAIN_ACNT_CODE_DESC = DB_PROCEDURES.L_VAL_MAIN_ACNT(RAS_MAIN_ACNT_CODE, RAS_MAIN_ACNT_CODE_DESC, "N", "N");
			ArrayList<String> subAcntList = DB_PROCEDURES.P_VAL_SUB_ACNT(RAS_MAIN_ACNT_CODE, RAS_SUB_ACNT_CODE, "N", "N");
			if(subAcntList!=null && subAcntList.size()>0)
				RAS_SUB_ACNT_CODE_DESC = subAcntList.get(0);
            DB_PROCEDURES.L_GET_ACTY_DETAILS();
			ArrayList<String> anlyList = DB_PROCEDURES.P_VAL_ANLY("1", RAS_ANLY_CODE_1, "N", "N");
			if(anlyList!=null && anlyList.size()>0)
				RAS_ANLY_CODE_1_DESC = anlyList.get(0);
			anlyList = DB_PROCEDURES.P_VAL_ANLY("2", RAS_ANLY_CODE_2, "N", "N");
			if(anlyList!=null && anlyList.size()>0)
				RAS_ANLY_CODE_2_DESC = anlyList.get(0);
			ArrayList<String> actyList = DB_PROCEDURES.P_VAL_ACTY(M_ACTY_1, RAS_ACTY_CODE_1, "N", "N");
			if(actyList!=null && actyList.size()>0)
				RAS_ACTY_CODE_1_DESC = actyList.get(0);
			actyList = DB_PROCEDURES.P_VAL_ACTY(M_ACTY_2, RAS_ACTY_CODE_2, "N", "N");
			if(actyList!=null && actyList.size()>0)
				RAS_ACTY_CODE_2_DESC = actyList.get(0);
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00163  : Modified method for calling dept desc instated of calling F_VAL_DEPT to P_VAL_DEPT . : Added by : Mallika.S 30-Mar-2009
			ArrayList<String> divnList = DB_PROCEDURES.F_VAL_DIVN(RAS_DIVN_CODE, "N", "N");
			if(divnList!=null && divnList.size()>0){
				RAS_DIVN_CODE_DESC = divnList.get(0);
			}
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00163  : Modified method for calling dept desc instated of calling F_VAL_DEPT to P_VAL_DEPT . : Added by : Mallika.S 30-Mar-2009
			ArrayList<String> deptList = DB_PROCEDURES.F_VAL_DEPT(RAS_DIVN_CODE, RAS_DEPT_CODE, "N", "N");
			if(deptList!=null && deptList.size()>0){
				RAS_DEPT_CODE_DESC = deptList.get(0);
			}
			PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_MAIN_ACNT_CODE_DESC(RAS_MAIN_ACNT_CODE_DESC);
			PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_SUB_ACNT_CODE_DESC(RAS_SUB_ACNT_CODE_DESC);
			PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_ANLY_CODE_1_DESC(RAS_ANLY_CODE_1_DESC);
			PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_ANLY_CODE_2_DESC(RAS_ANLY_CODE_2_DESC);
			PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_ACTY_CODE_1_DESC(RAS_ACTY_CODE_1_DESC);
			PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_ACTY_CODE_2_DESC(RAS_ACTY_CODE_2_DESC);
			PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_DIVN_CODE_DESC(RAS_DIVN_CODE_DESC);
			PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_DEPT_CODE_DESC(RAS_DEPT_CODE_DESC);
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
	
	public void whenNewRecordInstance() throws ValidatorException {
		String sql_C1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 " +
				"FROM   FM_MAIN_ACCOUNT " +
				"WHERE  MAIN_ACNT_CODE = ?";
		 String sql_C2 = "SELECT ACTY_NAME FROM   FM_ACTIVITY WHERE  ACTY_CODE = ?";
		 String sql_C3 = "SELECT ACTY_NAME FROM   FM_ACTIVITY WHERE  ACTY_CODE = ?";
		 String M_TEMP1 = null;
		 String M_TEMP2 = null;
		 String M_ACTY_1 = null;
		 String M_ACTY_2 = null;
		 ResultSet rst_C1 = null;
		 ResultSet rst_C2 = null;
		 ResultSet rst_C3 = null;
		 Connection connection = null;
		 CRUDHandler handler = new CRUDHandler();
		 PILM054_APAC_COMPOSITE_ACTION compositeAction = (PILM054_APAC_COMPOSITE_ACTION) new PM_IL_RI_ACCOUNT_SETUP_HELPER().getManagedBeanActionInstance();
		 PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();
		 String RAS_MAIN_ACNT_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_MAIN_ACNT_CODE();
		 String RAS_FORCE_DEPT_YN = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_FORCE_DEPT_YN();
		 try {
			connection = CommonUtils.getConnection();
			 rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{RAS_MAIN_ACNT_CODE});
			 while(rst_C1.next()){
				 M_ACTY_1 = rst_C1.getString(1);
				 M_ACTY_2 = rst_C1.getString(2);
			 }
			 riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_M_ACTY_1(M_ACTY_1);
			 riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_M_ACTY_2(M_ACTY_2);
			 
			 compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_ACTY_1(M_ACTY_1);
			 compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_ACTY_2(M_ACTY_2);
			 
			 if(M_ACTY_1!=null){
				 rst_C2 = handler.executeSelectStatement(sql_C2, connection, new Object[]{M_ACTY_1});
				 while(rst_C2.next()){
					 M_TEMP1 = rst_C2.getString(1);
				 }
				 riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_B_RAS_ACTY_CODE_1(CommonUtils.initCap(M_TEMP1));
				 riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1_LABEL().setValue(CommonUtils.initCap(M_TEMP1));
			 } else {
				 riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_B_RAS_ACTY_CODE_1("Activity Code1");
				 riAccountSetupAction.getCOMP_RAS_ACTY_CODE_1_LABEL().setValue("Activity Code1");
			 }
			 if(M_ACTY_2!=null){
				 rst_C3 = handler.executeSelectStatement(sql_C3, connection, new Object[]{M_ACTY_2});
				 while(rst_C3.next()){
					 M_TEMP2 = rst_C3.getString(1);
				 }
				 riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_B_RAS_ACTY_CODE_2(CommonUtils.initCap(M_TEMP2));
				 riAccountSetupAction.getCOMP_RAS_ACTY_CODE_2_LABEL().setValue(CommonUtils.initCap(M_TEMP2));
			 } else {
				 riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setUI_B_RAS_ACTY_CODE_2("Activity Code2");
				 riAccountSetupAction.getCOMP_RAS_ACTY_CODE_2_LABEL().setValue("Activity Code2");
			 }
			 if((RAS_FORCE_DEPT_YN==null?"N":RAS_FORCE_DEPT_YN).equals("Y")){
				 riAccountSetupAction.getCOMP_RAS_DEPT_CODE().setReadonly(true);
			 }else{
				 riAccountSetupAction.getCOMP_RAS_DEPT_CODE().setReadonly(false);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst_C1);
				CommonUtils.closeCursor(rst_C2);
				CommonUtils.closeCursor(rst_C3);
			}catch(Exception e){
			}
		}
	}
	
	public void whenNewBlockInstance(PM_IL_RI_ACCOUNT_SETUP PM_IL_RI_ACCOUNT_SETUP_BEAN) throws ValidatorException {
		/*PILM054_APAC_COMPOSITE_ACTION compositeAction = (PILM054_APAC_COMPOSITE_ACTION) new PM_IL_RI_ACCOUNT_SETUP_HELPER().getManagedBeanActionInstance();
		PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();*/
		//PM_IL_RI_ACCOUNT_SETUP PM_IL_RI_ACCOUNT_SETUP_BEAN = PM_IL_RI_ACCOUNT_ACTION.getPM_IL_RI_ACCOUNT_SETUP_BEAN();
		PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_FORCE_DEPT_YN("N");
		PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_FORCE_DIVN_YN("N");
		PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_NB_REN_TYPE("N");
		PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_SETUP_TYPE("RP");
		PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_FRZ_FLAG("N");
	}
	
	public void whenCreateRecord(PM_IL_RI_ACCOUNT_SETUP_ACTION PM_IL_RI_ACCOUNT_ACTION) throws ValidatorException {
		/*PILM054_APAC_COMPOSITE_ACTION compositeAction = (PILM054_APAC_COMPOSITE_ACTION) new PM_IL_RI_ACCOUNT_SETUP_HELPER().getManagedBeanActionInstance();
		PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();*/
		PM_IL_RI_ACCOUNT_SETUP PM_IL_RI_ACCOUNT_SETUP_BEAN = PM_IL_RI_ACCOUNT_ACTION.getPM_IL_RI_ACCOUNT_SETUP_BEAN();
		PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_FORCE_DEPT_YN("N");
		PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_FORCE_DIVN_YN("N");
		PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_NB_REN_TYPE("N");
		PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_SETUP_TYPE("RP");
		PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_FRZ_FLAG("N");
		PM_IL_RI_ACCOUNT_ACTION.getCOMP_RAS_DIVN_CODE().setRequired(true);
		PM_IL_RI_ACCOUNT_ACTION.getCOMP_RAS_DEPT_CODE().setRequired(true);
	}
	
	public void executeQuery(PM_IL_RI_ACCOUNT_SETUP PM_IL_RI_ACCOUNT_SETUP_BEAN) throws ValidatorException {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		//PM_IL_RI_ACCOUNT_SETUP_HELPER helper = new PM_IL_RI_ACCOUNT_SETUP_HELPER();
		//PILM054_APAC_COMPOSITE_ACTION compositeAction = helper.getManagedBeanActionInstance();
		//PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();
		//PM_IL_RI_ACCOUNT_SETUP valueBean = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN();
		//PM_IL_RI_ACCOUNT_SETUP valueBean =null;
		try{
			connection = CommonUtils.getConnection();
			query = PILM054_APAC_SQL_CONSTANTS.PM_IL_RI_ACNT_FETCH_FORM_VALUES;
			query = "SELECT TAB.ROWID,TAB.* FROM PM_IL_RI_ACCOUNT_SETUP TAB WHERE ROWID=?";
//			Object[] value={mnAcctCode, subAcctCode, divnCode};
			Object[] value={PM_IL_RI_ACCOUNT_SETUP_BEAN.getROWID()};
			resultSet = handler.executeSelectStatement(query, connection,value);
			while(resultSet.next()){
				//valueBean = new PM_IL_RI_ACCOUNT_SETUP();
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setROWID(resultSet.getString(1));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_FRZ_FLAG(resultSet.getString("RAS_FRZ_FLAG"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_DIVN_FM_CODE(resultSet.getString("RAS_DIVN_FM_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_DIVN_TO_CODE(resultSet.getString("RAS_DIVN_TO_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_DEPT_FM_CODE(resultSet.getString("RAS_DEPT_FM_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_DEPT_TO_CODE(resultSet.getString("RAS_DEPT_TO_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_CLASS_FM_CODE(resultSet.getString("RAS_CLASS_FM_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_CLASS_TO_CODE(resultSet.getString("RAS_CLASS_TO_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_SRC_BUS_FM(resultSet.getString("RAS_SRC_BUS_FM"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_SRC_BUS_TO(resultSet.getString("RAS_SRC_BUS_TO"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_PROD_FM_CODE(resultSet.getString("RAS_PROD_FM_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_PROD_TO_CODE(resultSet.getString("RAS_PROD_TO_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_COVER_FM_CODE(resultSet.getString("RAS_COVER_FM_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_COVER_TO_CODE(resultSet.getString("RAS_COVER_TO_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_CUST_CLS_FM_CODE(resultSet.getString("RAS_CUST_CLS_FM_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_CUST_CLS_TO_CODE(resultSet.getString("RAS_CUST_CLS_TO_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_NB_REN_TYPE(resultSet.getString("RAS_NB_REN_TYPE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_FORCE_DIVN_YN(resultSet.getString("RAS_FORCE_DIVN_YN"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_SETUP_TYPE(resultSet.getString("RAS_SETUP_TYPE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_FORCE_DEPT_YN(resultSet.getString("RAS_FORCE_DEPT_YN"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_TREATY_TYPE(resultSet.getString("RAS_TREATY_TYPE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_MAIN_ACNT_CODE(resultSet.getString("RAS_MAIN_ACNT_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_SUB_ACNT_CODE(resultSet.getString("RAS_SUB_ACNT_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_DIVN_CODE(resultSet.getString("RAS_DIVN_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_DEPT_CODE(resultSet.getString("RAS_DEPT_CODE"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_ANLY_CODE_1(resultSet.getString("RAS_ANLY_CODE_1"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_ANLY_CODE_2(resultSet.getString("RAS_ANLY_CODE_2"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_ACTY_CODE_1(resultSet.getString("RAS_ACTY_CODE_1"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_ACTY_CODE_2(resultSet.getString("RAS_ACTY_CODE_2"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_CR_DT(resultSet.getDate("RAS_CR_DT"));
				PM_IL_RI_ACCOUNT_SETUP_BEAN.setRAS_CR_UID(resultSet.getString("RAS_CR_UID"));

			}
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void preInsert() throws ValidatorException {
		PILM054_APAC_COMPOSITE_ACTION compositeAction = (PILM054_APAC_COMPOSITE_ACTION) new PM_IL_RI_ACCOUNT_SETUP_HELPER().getManagedBeanActionInstance();
		PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();
		ControlBean ctrlBean = CommonUtils.getControlBean();
		try {
			riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_CR_UID(ctrlBean.getM_USER_ID());
			riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().setRAS_CR_DT(Calendar.getInstance().getTime());
			new DB_PROCEDURES().L_OVERLAP_CHECK();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * @author 53058
	 * Feb 6, 2009 4:31:55 PM
	 *
	 *
	 * @throws ValidatorException
	 */
	public void preUpdate() throws ValidatorException {
		String sql_C1 = "SELECT 'X' FROM   PM_IL_RI_ACCOUNT_SETUP "+
				  "WHERE  (NVL(?,'0') BETWEEN NVL(RAS_SRC_BUS_FM,'0') AND NVL(RAS_SRC_BUS_TO,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_SRC_BUS_FM,'0') AND NVL(RAS_SRC_BUS_TO,'ZZZZZZ') "+
				         "OR NVL(RAS_SRC_BUS_FM,'0') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_SRC_BUS_TO,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ')) "+
				  
				  "AND    (NVL(?,'0') BETWEEN NVL(RAS_DIVN_FM_CODE,'0') AND NVL(RAS_DIVN_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_DIVN_FM_CODE,'0') AND NVL(RAS_DIVN_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(RAS_DIVN_FM_CODE,'0') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_DIVN_TO_CODE,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ')) "+
				  
				  "AND    (NVL(?,'0') BETWEEN NVL(RAS_DEPT_FM_CODE,'0') AND NVL(RAS_DEPT_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_DEPT_FM_CODE,'0') AND NVL(RAS_DEPT_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(RAS_DEPT_FM_CODE,'0') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_DEPT_TO_CODE,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ')) "+
				  
				  "AND    (NVL(?,'0') BETWEEN NVL(RAS_PROD_FM_CODE,'0') AND NVL(RAS_PROD_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_PROD_FM_CODE,'0') AND NVL(RAS_PROD_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(RAS_PROD_FM_CODE,'0') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_PROD_TO_CODE,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ')) "+
				         
				  "AND    (NVL(?,'0') BETWEEN NVL(RAS_SRC_BUS_FM,'0') AND NVL(RAS_SRC_BUS_TO,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_SRC_BUS_FM,'0') AND NVL(RAS_SRC_BUS_TO,'ZZZZZZ') "+
				         "OR NVL(RAS_SRC_BUS_FM,'0') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_SRC_BUS_TO,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ'))  "+
				         
				  "AND    (NVL(?,'0') BETWEEN NVL(RAS_CUST_CLS_FM_CODE,'0') AND NVL(RAS_CUST_CLS_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(?,'ZZZZZZ') BETWEEN NVL(RAS_CUST_CLS_FM_CODE,'0') AND NVL(RAS_CUST_CLS_TO_CODE,'ZZZZZZ') "+
				         "OR NVL(RAS_CUST_CLS_FM_CODE,'0') BETWEEN NVL(?,'ZZZZZZ') AND NVL(?,'ZZZZZZ') "+
				         "OR NVL(RAS_CUST_CLS_TO_CODE,'ZZZZZZ') BETWEEN NVL(?,'0') AND NVL(?,'ZZZZZZ')) "+
				  "AND    RAS_SETUP_TYPE = ? "+
				  "AND    RAS_NB_REN_TYPE= ? "+
				  "AND    RAS_TREATY_TYPE= ? " +
				  "AND    ROWID != ?";
		String M_DUMMY = null;
		Connection connection = null;
		ResultSet rst_C1 = null;
		CRUDHandler handler = new CRUDHandler();
		PILM054_APAC_COMPOSITE_ACTION compositeAction = (PILM054_APAC_COMPOSITE_ACTION) new PM_IL_RI_ACCOUNT_SETUP_HELPER().getManagedBeanActionInstance();
		PM_IL_RI_ACCOUNT_SETUP_ACTION riAccountSetupAction = compositeAction.getActionBean();
		String RAS_SRC_BUS_FM = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_SRC_BUS_FM();
		String RAS_SRC_BUS_TO = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_SRC_BUS_TO();
		String RAS_DIVN_FM_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_FM_CODE();
		String RAS_DIVN_TO_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DIVN_TO_CODE();
		String RAS_DEPT_FM_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DEPT_FM_CODE();
		String RAS_DEPT_TO_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_DEPT_TO_CODE();
		String RAS_PROD_FM_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_PROD_FM_CODE();
		String RAS_PROD_TO_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_PROD_TO_CODE();
		String RAS_CUST_CLS_FM_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_CUST_CLS_FM_CODE();
		String RAS_CUST_CLS_TO_CODE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_CUST_CLS_TO_CODE();
		String RAS_SETUP_TYPE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_SETUP_TYPE();
		String RAS_NB_REN_TYPE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_NB_REN_TYPE();
		String RAS_TREATY_TYPE = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getRAS_TREATY_TYPE();
		String ROWID = riAccountSetupAction.getPM_IL_RI_ACCOUNT_SETUP_BEAN().getROWID();
		try {
			connection = CommonUtils.getConnection();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{RAS_SRC_BUS_FM,
																	RAS_SRC_BUS_TO,
																	RAS_SRC_BUS_FM,RAS_SRC_BUS_TO,
																	RAS_SRC_BUS_FM,RAS_SRC_BUS_TO,
																	RAS_DIVN_FM_CODE,
																	RAS_DIVN_TO_CODE,
																	RAS_DIVN_FM_CODE,RAS_DIVN_TO_CODE,
																	RAS_DIVN_FM_CODE,RAS_DIVN_TO_CODE,
																	RAS_DEPT_FM_CODE,
																	RAS_DEPT_TO_CODE,
																	RAS_DEPT_FM_CODE,RAS_DEPT_TO_CODE,
																	RAS_DEPT_FM_CODE,RAS_DEPT_TO_CODE,
																	RAS_PROD_FM_CODE,
																	RAS_PROD_TO_CODE,
																	RAS_PROD_FM_CODE,RAS_PROD_TO_CODE,
																	RAS_PROD_FM_CODE,RAS_PROD_TO_CODE,
																	RAS_SRC_BUS_FM,
																	RAS_SRC_BUS_TO,
																	RAS_SRC_BUS_FM,RAS_SRC_BUS_TO,
																	RAS_SRC_BUS_FM,RAS_SRC_BUS_TO,
																	RAS_CUST_CLS_FM_CODE,
																	RAS_CUST_CLS_TO_CODE,
																	RAS_CUST_CLS_FM_CODE,RAS_CUST_CLS_TO_CODE,
																	RAS_CUST_CLS_FM_CODE,RAS_CUST_CLS_TO_CODE,
																	RAS_SETUP_TYPE, RAS_NB_REN_TYPE, 
																	RAS_TREATY_TYPE, ROWID});
			while(rst_C1.next()){
				M_DUMMY = rst_C1.getString(1);
			}
			if(M_DUMMY!=null){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "80031"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst_C1);
			}catch(Exception e){
			}
		}
	}

}
