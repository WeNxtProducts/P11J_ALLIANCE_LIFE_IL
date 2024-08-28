package com.iii.pel.forms.PILT010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY_ACTION;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {
	
	public void sysCalcButton() throws ValidatorException {
		try {
			String M_POL_FAC_YN=null;
			Date M_POL_APPRV_DT=null;
			String M_PC_PREM_TYPE=null;
			Long M_POL_SYS_ID=null;
			Date M_POL_START_DT=null;
			String M_DUMMY=null;
			ResultSet vembu_C1=null;
			ResultSet vembu_C2=null;
			ResultSet vembu_C3=null;
			String sql_C1="SELECT PC_PREM_TYPE FROM  PT_IL_PREM_COLL  " +
					"WHERE  PC_POL_SYS_ID  = ?  " +
					"AND PC_SYS_ID  = ? ";
			String sql_C2="SELECT    POL_FAC_YN,    POL_APPRV_DT,    POL_START_DT " +
					"FROM  PT_IL_POLICY  " +
					"WHERE  POL_SYS_ID  = ? ";
			String sql_C3="SELECT 'X' FROM  PT_IL_RI_DETL  " +
					"WHERE  RD_POL_SYS_ID  = ?  " +
					"AND RD_END_NO_IDX  = ?  " +
					"AND ?  BETWEEN RD_PRD_FM_DT  " +
					"AND  RD_PRD_TO_DT  AND RD_FRZ_FLAG  = 'N' ";
			Connection connection = PILT010_ACTION_INSTANCE.getConnection();
			PV_IL_POL_RI_DETL_ACTION pvRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			CRUDHandler handler = new CRUDHandler();
			Long RD_POL_SYS_ID = pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID();
//			String M_PC_SYS_ID = (String) sessionMap.get("DUMMY.M_PC_SYS_ID");
			Integer M_PC_SYS_ID = pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getUI_M_PC_SYS_ID();
			Integer RD_END_NO_IDX = pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX();
			String RD_POL_NO = pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO();
			M_POL_SYS_ID = pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID();
			String M_USER_CALC_YN = (String) sessionMap.get("DUMMY.M_USER_CALC_YN");
			if((M_USER_CALC_YN==null?"":M_USER_CALC_YN).equals("Y")) {
			    throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71048"));
			}
			pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_USER_CALC_YN("N");
			vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RD_POL_SYS_ID, M_PC_SYS_ID});
			if(vembu_C1.next()) {
			    M_PC_PREM_TYPE=vembu_C1.getString(1);
			}
			vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{RD_POL_SYS_ID});
			if(vembu_C2.next()) {
			    M_POL_FAC_YN=vembu_C2.getString(1);
			    M_POL_APPRV_DT=vembu_C2.getDate(2);
			    M_POL_START_DT=vembu_C2.getDate(3);
			}
			vembu_C3=handler.executeSelectStatement(sql_C3, connection, new Object[]{RD_POL_SYS_ID, RD_END_NO_IDX, M_POL_START_DT});
			if(vembu_C3.next()) {
			    M_DUMMY=vembu_C3.getString(1);
			}
			vembu_C3.close();
			if(!(M_DUMMY==null?"Y":M_DUMMY).equals("X")) {
			    throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "71169"));
			}
			sessionMap.put("GLOBAL.M_POL_NO",null);
			int ROWCOUNT = 0;
			if("N".equals(M_PC_PREM_TYPE) && RD_END_NO_IDX==0 && CommonUtils.nvl(M_DUMMY, "Y").equals("X")) {
			    sessionMap.put("GLOBAL.M_POL_NO",RD_POL_NO);
			    String sql_vembu1="DELETE FROM   PT_IL_RI_DETL    " +
			    		"WHERE  RD_POL_SYS_ID  = ?  " +
			    		"AND RD_END_NO_IDX  = ?  " +
			    		"AND RD_FRZ_FLAG  = ?  ";
			    ROWCOUNT += handler.executeDeleteStatement(sql_vembu1, connection, new Object[]{RD_POL_SYS_ID, RD_END_NO_IDX,"N"});
			    String sql_vembu2="DELETE FROM   PT_IL_RI_PREM_ALLOC    " +
			    		"WHERE  RPA_POL_SYS_ID  = ?  " +
			    		"AND RPA_END_NO_IDX  = ?  " +
			    		"AND RPA_FRZ_FLAG  = ?  ";
			    ROWCOUNT += handler.executeDeleteStatement(sql_vembu2, connection, new Object[]{RD_POL_SYS_ID, RD_END_NO_IDX,"N"});
			    String sql_vembu3="DELETE FROM   PS_IL_POL_RETN    " +
			    		"WHERE  PRET_POL_SYS_ID  = ?  " +
			    		"AND PRET_END_NO_IDX  = ? " +
			    		"AND PRET_FRZ_FLAG  = ? ";
			    ROWCOUNT += handler.executeDeleteStatement(sql_vembu3, connection, new Object[]{RD_POL_SYS_ID, RD_END_NO_IDX,"N"});
			    String sql_vembu4="UPDATE   PT_IL_FAC_DETL    SET FD_FAC_CLOSE_YN = ?  " +
			    		"WHERE  FD_FO_SYS_ID  IN  (   " +
			    		"SELECT FO_SYS_ID  FROM  PT_IL_FAC_OUT   " +
			    		"WHERE  FO_POL_SYS_ID  = ?  )  ";
			    ROWCOUNT += handler.executeUpdateStatement(sql_vembu4, connection, new Object[]{"N", RD_POL_SYS_ID});
			    /*COPY.COPY("P","CTRL.M_COMM_DEL");
			    COPY.COPY("20","SYSTEM.MESSAGE_LEVEL");
			    POST.POST();
			    COPY.COPY("0","SYSTEM.MESSAGE_LEVEL");
			    COPY.COPY("","CTRL.M_COMM_DEL");*/
			    String M_POL_APPRV_STR = CommonUtils.dateToStringFormatter(M_POL_APPRV_DT);
			    new PILT010_PROCEDURE().P9ILPK_RI_ALLOC_P_APPRV_FAC(connection, M_POL_SYS_ID+"", M_PC_SYS_ID!=null?String.valueOf(M_PC_SYS_ID):"", M_POL_APPRV_STR, M_POL_FAC_YN, "P");
			    connection.commit();
//			    pvRiDetlAction.getWarningMap().put("current", "3206: PROCESS COMPLETED SUCCESSFULLY");
			    String message = Messages.getString(PELConstants.pelErrorMessagePath,
			    										"3206",new Object[]{"Process Completed successfully"});
			    pvRiDetlAction.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			    new PV_IL_POL_RI_DETL_HELPER().executeForm();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void userCalcButton() throws ValidatorException {
		String M_RD_USER_UPD_YN=null;
        String M_PC_PREM_TYPE=null;
        String M_ASD_CHAR_VALUE=null;
        String M_POL_PROD_CODE=null;
        String M_DUMMY=null;
        String M_DUMMY_1=null;
        Date M_POL_START_DT=null;
        String M_POL_APPRV_STATUS=null;
        ResultSet vembu_C1=null;
        ResultSet vembu_C2=null;
        ResultSet vembu_C3=null;
        ResultSet vembu_C4=null;
        ResultSet vembu_C5=null;
        ResultSet vembu_C6=null;
        try {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			Connection connection = PILT010_ACTION_INSTANCE.getConnection();
			ControlBean ctrlBean = CommonUtils.getControlBean();
			PV_IL_POL_RI_DETL_ACTION polRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
			PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
			Long RD_POL_SYS_ID = polRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID();
			Integer RD_END_NO_IDX = polRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX();
			String RD_POL_NO = polRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO();
			Integer RD_SYS_ID = ptRiDetlAction.getPT_IL_RI_DETL_BEAN().getRD_SYS_ID();
			Integer M_PC_SYS_ID = polRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getUI_M_PC_SYS_ID();
			String M_USER_CALC_YN = polRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getUI_M_USER_CALC_YN();
			String M_USER_ID = ctrlBean.getM_USER_ID();
			CRUDHandler handler = new CRUDHandler();
			String sql_C1="SELECT RD_USER_UPD_YN FROM  PT_IL_RI_DETL  " +
					"WHERE  RD_SYS_ID  = ?  " +
					"AND RD_FRZ_FLAG  = ? ";
			String sql_C2="SELECT PC_PREM_TYPE FROM  PT_IL_PREM_COLL  " +
					"WHERE  PC_POL_SYS_ID  = ?  " +
					"AND PC_SYS_ID  = ? ";
			String sql_C3="SELECT ASD_CHAR_VALUE FROM  PM_IL_APPR_SETUP_DET  " +
					"WHERE  ASD_USER_ID  = ?  " +
					"AND ASD_CODE  = ?  " +
					"AND ?  BETWEEN NVL(ASD_FM_PROD_CODE, '0')  " +
							"AND  NVL(ASD_TO_PROD_CODE, 'ZZZZZZZZZZZZ') ";
			String sql_C4="SELECT    POL_PROD_CODE,    POL_START_DT,    POL_APPRV_STATUS " +
					"FROM  PT_IL_POLICY  " +
					"WHERE  POL_SYS_ID  = ? ";
			String sql_C5="SELECT 'X' FROM  PT_IL_RI_SYS_DETL  " +
					"WHERE  RSD_POL_SYS_ID  = ? " +
					"AND RSD_END_NO_IDX  = ? ";
			String sql_C6="SELECT 'X' FROM  PT_IL_RI_DETL  " +
					"WHERE  RD_POL_SYS_ID  = ?  " +
					"AND RD_END_NO_IDX  = ?  " +
					"AND ?  BETWEEN RD_PRD_FM_DT  AND  RD_PRD_TO_DT  " +
							"AND RD_FRZ_FLAG  = ? ";
			if(!(M_USER_CALC_YN==null?"N":M_USER_CALC_YN).equals("Y")) {
			    vembu_C4=handler.executeSelectStatement(sql_C4, connection, new Object[]{RD_POL_SYS_ID});
			    if(vembu_C4.next()) {
			        M_POL_PROD_CODE=vembu_C4.getString(1);
			        M_POL_START_DT=vembu_C4.getDate(2);
			        M_POL_APPRV_STATUS=vembu_C4.getString(3);
			    }
			    vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{RD_POL_SYS_ID, M_PC_SYS_ID});
			    if(vembu_C2.next()) {
			        M_PC_PREM_TYPE=vembu_C2.getString(1);
			    }
			    vembu_C6=handler.executeSelectStatement(sql_C6, connection, new Object[]{RD_POL_SYS_ID, RD_END_NO_IDX, CommonUtils.dateToStringFormatter(M_POL_START_DT), "N"});
			    if(vembu_C6.next()) {
			        M_DUMMY_1=vembu_C6.getString(1);
			    }
			    if(!(M_DUMMY_1==null?"Y":M_DUMMY_1).equals("X")) {
			    	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71169"));
			    }
			    vembu_C3=handler.executeSelectStatement(sql_C3, connection, new Object[]{M_USER_ID, "RI_CALC_YN", M_POL_PROD_CODE});
			    if(vembu_C3.next()) {
			        M_ASD_CHAR_VALUE=vembu_C3.getString(1);
			    }
			    if((M_ASD_CHAR_VALUE==null?"N":M_ASD_CHAR_VALUE).equals("N")) {
			    	throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91498", new Object[]{"CHANGE THE RETENTION LIMIT"}));
			    }
			    sessionMap.put("GLOBAL.M_POL_NO",null);
			    if(RD_END_NO_IDX==0 && "N".equals(M_PC_PREM_TYPE) && "Y".equals(M_ASD_CHAR_VALUE) && CommonUtils.nvl(M_DUMMY_1,"Y").equals("X") && "A".equals(M_POL_APPRV_STATUS)) {
			    	polRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_USER_CALC_YN("Y");
			    	polRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_ERR_FLAG(null);
			        sessionMap.put("GLOBAL.M_POL_NO",RD_POL_NO);
			        vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RD_SYS_ID, "N"});
			        if(vembu_C1.next()) {
			            M_RD_USER_UPD_YN=vembu_C1.getString(1);
			        }
			        vembu_C5=handler.executeSelectStatement(sql_C5, connection, new Object[]{RD_POL_SYS_ID, RD_END_NO_IDX});
			        if(vembu_C5.next()) {
			            M_DUMMY=vembu_C5.getString(1);
			        }
			        int rowCount = 0;
			        if((M_RD_USER_UPD_YN==null?"N":M_RD_USER_UPD_YN).equals("N") && !(M_DUMMY==null?"Y":M_DUMMY).equals("X")) {
			            String sql_vembu1="INSERT INTO  PT_IL_RI_SYS_DETL      ( " +
			            		"RSD_SYS_ID ,    RSD_POL_SYS_ID ,    RSD_POL_NO ,    RSD_END_NO_IDX ,    " +
			            		"RSD_END_NO ,    RSD_UW_YEAR ,    RSD_COVER_CODE ,    RSD_COVER_SYS_ID ,    " +
			            		"RSD_COVER_TYPE ,    RSD_TREATY_CODE ,    RSD_SCHD_DT ,    RSD_YEAR ,    " +
			            		"RSD_ASSURED_AGE ,    RSD_TAR_RATE ,    RSD_FC_SA ,    RSD_FC_PREM ,    " +
			            		"RSD_CR_UID ,    RSD_CR_DT ,    RSD_FC_SUM_CEDED ,    RSD_FC_POL_SA ,    " +
			            		"RSD_LC_POL_SA ,    RSD_FC_POL_PREM ,    RSD_LC_POL_PREM ,    " +
			            		"RSD_POL_EXCH_RATE ,    RSD_POL_SA_CURR_CODE ,    RSD_TREATY_CURR_CODE ,    " +
			            		"RSD_CUST_PREM_CURR_CODE ,    RSD_CUST_PREM_EXCH_RATE ,    RSD_TAR_RATE_PER ,    " +
			            		"RSD_ASSR_CODE ,    RSD_FRZ_FLAG ,    RSD_PRD_FM_DT ,    RSD_PRD_TO_DT ,    " +
			            		"RSD_LC_PRD_PREM ,    RSD_PRD_YEAR ,    RSD_PRD_NO )   " +
			            		"SELECT    RD_SYS_ID,    RD_POL_SYS_ID,    RD_POL_NO,    RD_END_NO_IDX,    " +
			            		"RD_END_NO,    RD_UW_YEAR,    RD_COVER_CODE,    RD_COVER_SYS_ID,    " +
			            		"RD_COVER_TYPE,    RD_TREATY_CODE,    RD_SCHD_DT,    RD_YEAR,    " +
			            		"RD_ASSURED_AGE,    RD_TAR_RATE,    RD_FC_SA,    RD_FC_PREM,    " +
			            		"RD_CR_UID,    RD_CR_DT,    RD_FC_SUM_CEDED,    RD_FC_POL_SA,    " +
			            		"RD_LC_POL_SA,    RD_FC_POL_PREM,    RD_LC_POL_PREM,    RD_POL_EXCH_RATE,    " +
			            		"RD_POL_SA_CURR_CODE,    RD_TREATY_CURR_CODE,    RD_CUST_PREM_CURR_CODE,    " +
			            		"RD_CUST_PREM_EXCH_RATE,    RD_TAR_RATE_PER,    RD_ASSR_CODE,    " +
			            		"RD_FRZ_FLAG,    RD_PRD_FM_DT,    RD_PRD_TO_DT,    RD_LC_PRD_PREM,    " +
			            		"RD_PRD_YEAR,    RD_PRD_NO " +
			            		"FROM  PT_IL_RI_DETL  " +
			            		"WHERE  RD_POL_SYS_ID  = ?  " +
			            		"AND RD_END_NO_IDX  = ?  " +
			            		"AND RD_FRZ_FLAG  = ? ";
			            rowCount += handler.executeInsertStatement(sql_vembu1, connection, new Object[]{RD_POL_SYS_ID, RD_END_NO_IDX, "N"});
			            String sql_vembu2="INSERT INTO  PT_IL_RI_PREM_SYS_ALLOC      ( " +
			            		"RPSA_DIVN_CODE ,    RPSA_CLASS_CODE ,    RPSA_RD_SYS_ID ,    RPSA_POL_SYS_ID ,  " +
			            		"RPSA_POL_NO ,    RPSA_END_NO_IDX ,    RPSA_END_NO ,    RPSA_UW_YEAR ,  " +
			            		"RPSA_YEAR ,    RPSA_COVER_CODE ,    RPSA_COVER_SYS_ID ,    RPSA_COVER_TYPE , " +
			            		"RPSA_TREATY_CODE ,    RPSA_TREATY_TYPE ,    RPSA_SRNO ,    RPSA_DT ,    " +
			            		"RPSA_RET_FC_SA ,    RPSA_RET_FC_PREM ,    RPSA_RI_FC_SA ,    RPSA_RI_FC_PREM ," +
			            		"RPSA_RI_CLOSE_FLAG ,    RPSA_REINS_COMM_PERC ,    RPSA_REINS_FC_COMM ,  " +
			            		"RPSA_CR_UID ,    RPSA_CR_DT ,    RPSA_RI_FC_POL_SA ,    RPSA_RI_FC_POL_PREM , " +
			            		"RPSA_RET_FC_POL_SA ,    RPSA_RET_FC_POL_PREM ,    RPSA_RI_LC_POL_SA ,  " +
			            		"RPSA_RI_LC_POL_PREM ,    RPSA_RET_LC_POL_SA ,    RPSA_RET_LC_POL_PREM , " +
			            		"RPSA_FC_EXTRA_PREM ,    RPSA_RET_FC_SUM_CEDED ,    RPSA_RI_FC_SUM_CEDED , " +
			            		"RPSA_ASSURED_CODE ,    RPSA_ASSR_REF_ID1 ,    RPSA_ASSR_REF_ID2 , " +
			            		"RPSA_FRZ_FLAG ,    RPSA_PRD_FM_DT ,    RPSA_PRD_TO_DT ,    RPSA_PERIOD_NO ," +
			            		"RPSA_RET_LC_PRD_PREM ,    RPSA_RI_LC_PRD_PREM ,    RPSA_REINS_PRD_FC_COMM ) " +
			            		"SELECT    RPA_DIVN_CODE,    RPA_CLASS_CODE,    RPA_RD_SYS_ID,    RPA_POL_SYS_ID," +
			            		"RPA_POL_NO,    RPA_END_NO_IDX,    RPA_END_NO,    RPA_UW_YEAR,    RPA_YEAR," +
			            		"RPA_COVER_CODE,    RPA_COVER_SYS_ID,    RPA_COVER_TYPE,    RPA_TREATY_CODE, " +
			            		"RPA_TREATY_TYPE,    RPA_SRNO,    RPA_DT,    RPA_RET_FC_SA,    RPA_RET_FC_PREM," +
			            		"RPA_RI_FC_SA,    RPA_RI_FC_PREM,    RPA_RI_CLOSE_FLAG,    RPA_REINS_COMM_PERC," +
			            		"RPA_REINS_FC_COMM,    RPA_CR_UID,    RPA_CR_DT,    RPA_RI_FC_POL_SA,  " +
			            		"RPA_RI_FC_POL_PREM,    RPA_RET_FC_POL_SA,    RPA_RET_FC_POL_PREM,    " +
			            		"RPA_RI_LC_POL_SA,    RPA_RI_LC_POL_PREM,    RPA_RET_LC_POL_SA,    " +
			            		"RPA_RET_LC_POL_PREM,    RPA_FC_EXTRA_PREM,    RPA_RET_FC_SUM_CEDED,  " +
			            		"RPA_RI_FC_SUM_CEDED,    RPA_ASSURED_CODE,    RPA_ASSR_REF_ID1,    " +
			            		"RPA_ASSR_REF_ID2,    RPA_FRZ_FLAG,    RPA_PRD_FM_DT,   " +
			            		"RPA_PRD_TO_DT,    RPA_PERIOD_NO,    RPA_RET_LC_PRD_PREM,  " +
			            		"RPA_RI_LC_PRD_PREM,    RPA_REINS_PRD_FC_COMM " +
			            		"FROM  PT_IL_RI_PREM_ALLOC  " +
			            		"WHERE  RPA_POL_SYS_ID  = ? " +
			            		"AND RPA_END_NO_IDX  = ?  " +
			            		"AND RPA_FRZ_FLAG  = ? ";
			            rowCount += handler.executeInsertStatement(sql_vembu2, connection, new Object[]{RD_POL_SYS_ID,RD_END_NO_IDX, "N"});
			            String sql_vembu3="INSERT INTO  PS_IL_POL_SYS_RETN      ( " +
			            		"PRST_ASSR_CODE ,    PRST_POL_SYS_ID ,    PRST_PLAN_CODE ,    " +
			            		"PRST_LC_RETN_AMT ,    PRST_POL_STATUS ,    PRST_POL_ACTIVE_YN ,    " +
			            		"PRST_CR_UID ,    PRST_CR_DT ,    PRST_UPD_UID ,    PRST_UPD_DT ,    " +
			            		"PRST_ASSR_REF_ID1 ,    PRST_ASSR_REF_ID2 ,    PRST_SR_NO ,    " +
			            		"PRST_CLASS_CODE ,    PRST_END_NO_IDX ,    PRST_FRZ_FLAG ,    " +
			            		"PRST_PRD_FM_DT ,    PRST_PRD_TO_DT ,    PRST_PROD_CODE ,    PRST_PG_CODE )" +
			            		" SELECT    PRET_ASSR_CODE,    PRET_POL_SYS_ID,    PRET_PLAN_CODE,    " +
			            		"PRET_LC_RETN_AMT,    PRET_POL_STATUS,    PRET_POL_ACTIVE_YN,    " +
			            		"PRET_CR_UID,    PRET_CR_DT,    PRET_UPD_UID,    PRET_UPD_DT,    " +
			            		"PRET_ASSR_REF_ID1,    PRET_ASSR_REF_ID2,    PRET_SR_NO,    PRET_CLASS_CODE," +
			            		"PRET_END_NO_IDX,    PRET_FRZ_FLAG,    PRET_PRD_FM_DT,    PRET_PRD_TO_DT,  " +
			            		"PRET_PROD_CODE,    PRET_PG_CODE FROM  PS_IL_POL_RETN  " +
			            		"WHERE  PRET_POL_SYS_ID  = ?  " +
			            		"AND PRET_FRZ_FLAG  = ? ";
			            rowCount += handler.executeInsertStatement(sql_vembu3, connection, new Object[]{RD_POL_SYS_ID, "N"});
			        }
			        String sql_vembu4="UPDATE   PT_IL_RI_DETL    SET RD_FRZ_FLAG = ?  " +
			        		"WHERE  RD_POL_SYS_ID  = ?  " +
			        		"AND RD_END_NO_IDX  = ?  " +
			        		"AND RD_FRZ_FLAG  = ?  ";
			        rowCount += handler.executeUpdateStatement(sql_vembu4, connection, new Object[]{"U", RD_POL_SYS_ID, RD_END_NO_IDX, "N"});
			        String sql_vembu5="UPDATE   PT_IL_RI_PREM_ALLOC    SET RPA_FRZ_FLAG = ?  " +
			        		"WHERE  RPA_POL_SYS_ID  = ?  " +
			        		"AND RPA_END_NO_IDX  = ? " +
			        		"AND RPA_FRZ_FLAG  = ? ";
			        rowCount += handler.executeUpdateStatement(sql_vembu5, connection, new Object[]{"U", RD_POL_SYS_ID, RD_END_NO_IDX, "N"});
			        String sql_vembu6="UPDATE   PS_IL_POL_RETN    SET PRET_FRZ_FLAG = ?  " +
			        		"WHERE  PRET_POL_SYS_ID  = ?  " +
			        		"AND PRET_END_NO_IDX  = ? " +
			        		"AND PRET_FRZ_FLAG  = ?  ";
			        rowCount += handler.executeUpdateStatement(sql_vembu6, connection, new Object[]{"U", RD_POL_SYS_ID, RD_END_NO_IDX, "N"});
			        String sql_vembu7="UPDATE   PT_IL_FAC_DETL    SET FD_FAC_CLOSE_YN = ? " +
			        		"WHERE  FD_FO_SYS_ID  IN  (   " +
			        		"SELECT FO_SYS_ID  FROM  PT_IL_FAC_OUT   " +
			        		"WHERE  FO_POL_SYS_ID  = ?  )  ";
			        rowCount += handler.executeUpdateStatement(sql_vembu7, connection, new Object[]{"N", RD_POL_SYS_ID});
			        /*COPY.COPY("P","CTRL.M_COMM_DEL");
			        COPY.COPY("20","SYSTEM.MESSAGE_LEVEL");
			        POST.POST();
			        COPY.COPY("0","SYSTEM.MESSAGE_LEVEL");
			        COPY.COPY("","CTRL.M_COMM_DEL");*/
			        polRiDetlAction.getWarningMap().put("current", rowCount+" records updated. Press Save to confirm changes.");
			        polRiDetlAction.setWarningMessages(rowCount+" records updated. Press Save to confirm changes.");
			        new PV_IL_POL_RI_DETL_HELPER().executeForm();
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(vembu_C1);
				CommonUtils.closeCursor(vembu_C2);
				CommonUtils.closeCursor(vembu_C3);
				CommonUtils.closeCursor(vembu_C4);
				CommonUtils.closeCursor(vembu_C5);
				CommonUtils.closeCursor(vembu_C6);
			}catch(Exception e){
			}
		}
	}
	
	public String policyButton() throws ValidatorException {
		String sql_C1="SELECT    POL_DS_CODE,POL_DS_TYPE, POL_CLASS_CODE FROM  PT_IL_POLICY  " +
				"WHERE  POL_SYS_ID  = ? ";
        ResultSet vembu_C1=null;
        String M_POL_DS_CODE=null;
        String M_POL_CLASS_CODE=null;
        String M_POL_DS_TYPE = null;
        Connection connection = PILT010_ACTION_INSTANCE.getConnection();
      PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
        PT_IL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
        Long RD_POL_SYS_ID = riDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_POL_SYS_ID();
        Long PV_POL_SYS_ID = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID();
        CRUDHandler handler = new CRUDHandler();
        try {
			vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{PV_POL_SYS_ID});
			if(vembu_C1.next()) {
			    M_POL_DS_CODE=vembu_C1.getString(1);
			    M_POL_DS_TYPE = vembu_C1.getString(2);
			    M_POL_CLASS_CODE=vembu_C1.getString(3);
			}
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("GLOBAL.M_PARAM_1",M_POL_DS_CODE);
			sessionMap.put("GLOBAL.M_PARAM_2",M_POL_CLASS_CODE);
			//sessionMap.put("GLOBAL.M_POL_SYS_ID",String.valueOf(RD_POL_SYS_ID));
			CommonUtils.setGlobalObject("GLOBAL.M_POL_SYS_ID", (long)PV_POL_SYS_ID);
			//sessionMap.put("CALLING_FORM", "PILT010");
			//newly 
			CommonUtils.setGlobalVariable("GLOBAL.M_PARAM_11", M_POL_DS_TYPE);
			//new ends 
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT010");
			//sessionMap.put("PILT002_APAC_BACK_BUTTON","PILT010");
			sessionMap.put("PILT002_APAC_COMPOSITE_ACTION", new PILT002_APAC_COMPOSITE_ACTION());
			PT_IL_POLICY_ACTION policyAction = ((PILT002_APAC_COMPOSITE_ACTION) sessionMap.get("PILT002_APAC_COMPOSITE_ACTION")).getPT_IL_POLICY_ACTION_BEAN();
			//policyAction.loadingBaseValues();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(vembu_C1);
			}catch(Exception e){
			}
		}
        return "PILT002_APAC";
	}
	
	public String facButton() throws Exception {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String RD_POL_NO = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE().getPT_IL_RI_DETL_BEAN().getRD_POL_NO();
		String RD_POL_NO_1 = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_1_ACTION_INSTANCE().getPT_IL_RI_DETL_1_BEAN().getRD_POL_NO();
		sessionMap.put("GLOBAL.M_POL_NO", (RD_POL_NO==null?RD_POL_NO_1:RD_POL_NO));
		Integer M_PC_SYS_ID = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE().getPV_IL_POL_RI_DETL_BEAN().getUI_M_PC_SYS_ID();
		String pol_no= PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE().getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 ="SELECT PC_SYS_ID FROM   PT_IL_PREM_COLL WHERE  " +
					" PC_POL_SYS_ID  = (SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ? ) AND    NVL(PC_PREM_TYPE, 'N')  " +
					" IN ('R', 'N','A') AND    NVL(PC_PAID_FLAG, 'N') = 'A' " +
					" AND    NVL(PC_FAC_CLOSE_FLAG,'N') = 'N'";
			
			  Object[] c1values = { pol_no };
			  resultSet = handler.executeSelectStatement(C1, connection,c1values);
			  if(resultSet.next()){
				  CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID",resultSet.getString(1));
			  }
			 /* else{
				  throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71173"));
			  }*/
			
		//CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID", M_PC_SYS_ID);	
		//CommonUtils.setGlobalVariable("CALLING_FORM", "PILT010");
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
    	return "PILT009";
	}
	
	public void discLoadMainButton() throws ValidatorException {
		String sql_C1="SELECT 'X' FROM  PT_IL_RI_DISC_LOAD  " +
				"WHERE  RDL_COVER_CODE  = ? " +
				"AND RDL_RPA_SRNO  = ? ";
        ResultSet vembu_C1=null;
        String M_RCRD_CHK=null;
        try {
			PT_IL_RI_PREM_ALLOC_ACTION riPremAllocAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_PREM_ALLOC_ACTION_INSTANCE();
			String RPA_COVER_CODE = riPremAllocAction.getPT_IL_RI_PREM_ALLOC_BEAN().getRPA_COVER_CODE();
			Integer RPA_SRNO = riPremAllocAction.getPT_IL_RI_PREM_ALLOC_BEAN().getRPA_SRNO();
			Connection connection = PILT010_ACTION_INSTANCE.getConnection();
			CRUDHandler handler = new CRUDHandler();
			vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RPA_COVER_CODE, RPA_SRNO});
			if(vembu_C1.next()) {
			    M_RCRD_CHK=vembu_C1.getString(1);
			}
			if(M_RCRD_CHK!="X") {
//            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_RI_DISC_LOAD.RDL_SRNO",REQUIRED,PROPERTY_FALSE);
//            GO_BLOCK.GO_BLOCK("PT_IL_RI_PREM_ALLOC");
			} else {
//            GO_BLOCK.GO_BLOCK("PT_IL_RI_PREM_ALLOC");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(vembu_C1);
			}catch(Exception e){
			}
		}
	}
	
	public void historyButton() throws ValidatorException {
		PT_IL_RI_DETL_1_HELPER helper = new PT_IL_RI_DETL_1_HELPER();
		helper.executeHistoryDetails();
	}
	
	public void nextRecordButton() throws ValidatorException {
		PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		Integer RD_END_NO_IDX = riDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX();
		Integer maxIdxNo = getEndorsementNoIdx();
		PV_IL_POL_RI_DETL_HELPER helper = new PV_IL_POL_RI_DETL_HELPER();
		if(maxIdxNo.equals(RD_END_NO_IDX)){
			String RD_POL_NO = riDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO();
			if(riDetlAction.getPolicyRowIdList()!=null && riDetlAction.getPolicyRowIdList().size()>0){
				int indexNo = riDetlAction.getPolicyRowIdList().indexOf(RD_POL_NO);
				String policyNo = riDetlAction.getPolicyRowIdList().get(indexNo+1);
				riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_END_NO_IDX(0);
				riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_POL_NO(policyNo);
				new PV_IL_POL_RI_DETL_HELPER().executeForm();
			}
		}else{
			riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_END_NO_IDX(RD_END_NO_IDX+1);
			helper.executeForm();
		}
	}
	
	public Integer getEndorsementNoIdx() throws ValidatorException {
		PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		String polNo = riDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO();
		String query = "SELECT MAX(RD_END_NO_IDX) FROM PV_IL_POL_RI_DETL WHERE RD_POL_NO = ?";
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		Integer endNoIdx = null;
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{polNo});
			while(rst.next()){
				endNoIdx = rst.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst);
			}catch(Exception e){
			}
		}
		return endNoIdx;
	}
	
	public void keyCommit() throws ValidatorException {
		String M_FIELD_NAME=null;
        double M_CHOICE=-1;
        String M_MESSAGE=null;
        String M_POL_FAC_YN=null;
        Date M_POL_APPRV_DT=null;
        ResultSet vembu_C1=null;
        Connection connection = PILT010_ACTION_INSTANCE.getConnection();
        CRUDHandler handler = new CRUDHandler();
        String sql_C1="SELECT    POL_FAC_YN,    POL_APPRV_DT " +
        		"FROM  PT_IL_POLICY  " +
        		"WHERE  POL_SYS_ID  = ? ";
        PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
        PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
        Long RD_POL_SYS_ID = ptRiDetlAction.getPT_IL_RI_DETL_BEAN().getRD_POL_SYS_ID();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        String M_ERR_FLAG = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getUI_M_ERR_FLAG();
        String M_USER_CALC_YN = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getUI_M_USER_CALC_YN();
        Integer M_PC_SYS_ID = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getUI_M_PC_SYS_ID();
        try {
			if((M_ERR_FLAG==null?"":M_ERR_FLAG).equals("Y")){
			    throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "2130"));
			} else if(M_ERR_FLAG==null) {
//            GO_ITEM.GO_ITEM("PT_IL_RI_PREM_ALLOC.RPA_TREATY_TYPE");
			} else if(!(M_ERR_FLAG==null?"":M_ERR_FLAG).equals("Y")) {
				pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_ERR_FLAG(null);
			    /*GET_FIRST_FIELD.GET_FIRST_FIELD(M_FIELD_NAME);
			    if(NAME_IN.NAME_IN(M_FIELD_NAME)== null)
			    {
			        CLEAR_RECORD.CLEAR_RECORD();
			        CHK_PKG_FAILURE.CHK_PKG_FAILURE();
			    }
			    GET_ALERT_MSG.GET_ALERT_MSG("10",M_MESSAGE);
			    SET_ALERT_PROPERTY.SET_ALERT_PROPERTY("SAVE_BOX",ALERT_MESSAGE_TEXT,M_MESSAGE);
			    M_CHOICE=SHOW_ALERT.SHOW_ALERT("SAVE_BOX");*/
			    vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RD_POL_SYS_ID});
			    if(vembu_C1.next()) {
			        M_POL_FAC_YN=vembu_C1.getString(1);
			        M_POL_APPRV_DT=vembu_C1.getDate(2);
			    }
			    /*COPY.COPY("P","CTRL.M_COMM_DEL");
			    COPY.COPY("20","SYSTEM.MESSAGE_LEVEL");
			    POST.POST();
			    COPY.COPY("0","SYSTEM.MESSAGE_LEVEL");
			    COPY.COPY("","CTRL.M_COMM_DEL");*/
			    int ROWCOUNT = 0;
			    if((M_USER_CALC_YN==null?"N":M_USER_CALC_YN).equals("Y")) {
			    	String M_POL_APPRV_STR = CommonUtils.dateToStringFormatter(M_POL_APPRV_DT);
			    	new PILT010_PROCEDURE().P9ILPK_RI_ALLOC_P_APPRV_FAC(connection, RD_POL_SYS_ID+"", M_PC_SYS_ID+"", M_POL_APPRV_STR, M_POL_FAC_YN, "P");
			        String sql_vembu1="UPDATE   PT_IL_RI_DETL    SET RD_USER_UPD_YN = ?  " +
			        		"WHERE  RD_POL_SYS_ID  = ?  " +
			        		"AND RD_USER_UPD_YN  = ? ";
			        ROWCOUNT += handler.executeUpdateStatement(sql_vembu1, connection, new Object[]{"Y", RD_POL_SYS_ID, "N"});
			        String sql_vembu2="DELETE FROM   PT_IL_RI_DETL    " +
			        		"WHERE  RD_POL_SYS_ID  = ? " +
			        		"AND RD_FRZ_FLAG  = ? ";
			        ROWCOUNT += handler.executeUpdateStatement(sql_vembu2, connection, new Object[]{RD_POL_SYS_ID, "U"});
			        String sql_vembu3="DELETE FROM   PT_IL_RI_PREM_ALLOC    " +
			        		"WHERE  RPA_POL_SYS_ID  = ? " +
			        		"AND RPA_FRZ_FLAG  = ? ";
			        ROWCOUNT += handler.executeUpdateStatement(sql_vembu3, connection, new Object[]{RD_POL_SYS_ID, "U"});
			        String sql_vembu4="DELETE FROM   PS_IL_POL_RETN    " +
			        		"WHERE  PRET_POL_SYS_ID  = :PV_IL_POL_RI_DETL.RD_POL_SYS_ID  " +
			        		"AND PRET_FRZ_FLAG  = 'U'  ";
			        ROWCOUNT += handler.executeUpdateStatement(sql_vembu4, connection, new Object[]{RD_POL_SYS_ID, "U"});
			    }
			    if((M_USER_CALC_YN==null?"":M_USER_CALC_YN).equals("N")) {
			        new PILT010_PROCEDURE().L_CHECK_RI_PREM_ALLOC();
			        new PILT010_PROCEDURE().L_CHECK_POL_SA_PREM();
			    }
			    pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_USER_CALC_YN("N");
			    sessionMap.put("GLOBAL.M_POL_NO",null);
			    connection.commit();
			    /*SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"BUSY");
			    COPY.COPY("0","SYSTEM.MESSAGE_LEVEL");
			    COPY.COPY("C","CTRL.M_COMM_DEL");
			    COMMIT_FORM.COMMIT_FORM();
			    COPY.COPY("","CTRL.M_COMM_DEL");
			    COPY.COPY("","CTRL.M_COMMIT_FLAG");
			    COPY.COPY("10","SYSTEM.MESSAGE_LEVEL");
			    SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"DEFAULT");
			    CHK_PKG_FAILURE.CHK_PKG_FAILURE();
			    GO_BLOCK.GO_BLOCK(GET_FORM_PROPERTY.GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FIRSTBLOCK));
			    GO_BLOCK.GO_BLOCK("PT_IL_RI_DETL");
			    GO_ITEM.GO_ITEM("PT_IL_RI_DETL.RD_COVER_CODE");*/
			    PV_IL_POL_RI_DETL_HELPER pvRiDetlHelper = new PV_IL_POL_RI_DETL_HELPER();
			    pvRiDetlHelper.executeForm();
			}
			/*GO_BLOCK.GO_BLOCK("PV_IL_POL_RI_DETL");
			GO_ITEM.GO_ITEM("PV_IL_POL_RI_DETL.RD_POL_SYS_ID");*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(vembu_C1);
			}catch(Exception e){
			}
		}
	}
	
	public void getPvPolicyNoList(){
		String query = "SELECT DISTINCT(RD_POL_NO) FROM PV_IL_POL_RI_DETL";
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		PV_IL_POL_RI_DETL_ACTION polRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		polRiDetlAction.getPolicyRowIdList().clear();
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{});
			while(rst.next()){
				polRiDetlAction.getPolicyRowIdList().add(rst.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst);
			}catch(Exception e){
			}
		}
	}

	public void executeRiTransDetails() throws ValidatorException {
		try {
			PT_IL_RI_DETL_HELPER helper = new PT_IL_RI_DETL_HELPER();
			helper.executeQuery();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}


	}
	
	public void WHEN_M_BUT_RI_CLOSE()throws Exception{
		
			String CUR_C1="SELECT NVL(RPA_RI_CLOSE_FLAG,'N') FROM   PT_IL_RI_PREM_ALLOC WHERE  " +
									" RPA_POL_SYS_ID 	 = ?  AND  " +
									" RPA_RD_SYS_ID		 =?   AND  " +
									" RPA_END_NO_IDX     =?  AND  " +
									"  RPA_COVER_CODE      =? AND " +
									"   RPA_YEAR     		=? ";		
		
			String CUR_C2=" SELECT 1 FROM  PT_IL_RI_PREM_ALLOC"+
					       " WHERE  RPA_POL_SYS_ID      = ? "+
					       " AND    RPA_COVER_CODE      = ? "+
					       " AND    NVL(RPA_END_NO_IDX,0) < NVL(?,0) "+
					       " AND    NVL(RPA_RI_CLOSE_FLAG,'N') = 'N'  ";
		
			String CUR_C3="SELECT  POL_FAC_YN "+
							     " FROM    PT_IL_POLICY "+
							      " WHERE   POL_SYS_ID       = ? "+
							      " AND     POL_END_NO_IDX   = ? ";
		
			String CUR_C4="UPDATE PT_IL_PREM_COLL "+
			     " SET    PC_RI_CLOSE_FLAG = 'Y' "+
			     " WHERE  PC_POL_SYS_ID = ? " +
			     " AND    TO_NUMBER(TO_CHAR(PC_SCHD_PYMT_DT,'YYYY')) = TO_NUMBER(TO_CHAR(?,'YYYY')) ";
			
			String CUR_C5="UPDATE  PT_IL_POLICY  SET    POL_RI_CLOSE_FLAG = 'Y' WHERE  POL_SYS_ID = ?";
			
			
			
		
			ResultSet rs1=null;
			ResultSet rs2=null;
			ResultSet rs3=null;
			Connection con=null;
			
			String M_CLOSE_FLAG=null;
			String M_FAC_YN=null;
			CRUDHandler handler = new CRUDHandler();
			 con = PILT010_ACTION_INSTANCE.getConnection();
			PV_IL_POL_RI_DETL_ACTION pvRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();

		 PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
	        Long RD_POL_SYS_ID = ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_POL_SYS_ID();
		
	        try{
	        	CommonUtils.clearMaps(pvRiDetlAction);
	        	
		        if(RD_POL_SYS_ID!= null){
					
					/*CHK_PKG_FAILURE ;
				     :M_COMM_DEL := 'P';
				     --POST;
				     :M_COMM_DEL := NULL;
				     CHK_PKG_FAILURE ;*/
					 new PILT010_PROCEDURE().L_CHECK_RI_PREM_ALLOC();
					 
					 rs2=handler.executeSelectStatement(CUR_C2, con, new Object[]{RD_POL_SYS_ID,ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_COVER_CODE(),ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_END_NO_IDX()});
					 if(rs2.next()){
						 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71168"));
					 }
					 rs1=handler.executeSelectStatement(CUR_C1, con,new Object[]{RD_POL_SYS_ID,ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_SYS_ID(),ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_END_NO_IDX(),ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_COVER_CODE(),ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_YEAR()});
					if(rs1.next()){
						M_CLOSE_FLAG=rs1.getString(1);
					}
					if(M_CLOSE_FLAG != null){
						if(M_CLOSE_FLAG.equalsIgnoreCase("Y")){
							
							 //throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71167"));
							 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "50002"));
						}
					}
					rs3=handler.executeSelectStatement(CUR_C3, con,new Object[]{RD_POL_SYS_ID,ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_END_NO_IDX()});
					if(rs3.next()){
						M_FAC_YN=rs3.getString(1);
					}
					if(M_FAC_YN != null){
						if("Y".equalsIgnoreCase(M_FAC_YN)){
							
							if("N".equalsIgnoreCase(ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getUI_M_PC_FAC_CLOSE_FLAG())){
							
							 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71166"));
							
							}
						}
					}
					//SET_APPLICATION_PROPERTY(CURSOR_STYLE,'BUSY');  \par
				    // SET_BLOCK_PROPERTY('PT_IL_RI_PREM_ALLOC',UPDATE_ALLOWED,PROPERTY_truE);commented by devi on 03/Jan/2006 for REV 1.2\par
				   //  SET_BLOCK_PROPERTY('PT_IL_RI_PREM_ALLOC',INSERT_ALLOWED,PROPERTY_TRUE);commented by devi on 03/Jan/2006 for REV 1.2\par
				   //  SET_BLOCK_PROPERTY('PT_IL_RI_PREM_ALLOC',DELETE_ALLOWED,PROPERTY_TRUE);
					//L_RI_APPRV;
					
					
					//P10ILPK_RI_CLOSE.P_RI_CLOSE(:PV_IL_POL_RI_DETL.RD_POL_SYS_ID,:PV_IL_POL_RI_DETL.RD_END_NO_IDX, :PT_IL_RI_DETL.RD_YEAR);
					new PILT010_PROCEDURE().P10ilpk_Ri_Close(
							CommonUtils.getProcedureValue(pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID()), 
							CommonUtils.getProcedureValue(pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX()),
									CommonUtils.getProcedureValue(ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_YEAR()));
								
					handler.executeUpdateStatement(CUR_C4, con, new Object[]{RD_POL_SYS_ID,ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_SCHD_DT()});
					handler.executeUpdateStatement(CUR_C5, con, new Object[]{RD_POL_SYS_ID}) ;
					
					con.commit();
					
					/*String message = Messages.getString(PELConstants.pelErrorMessagePath,
							"71169",new Object[]{"RI CLOSED"});
					pvRiDetlAction.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					pvRiDetlAction.getCOMP_B_RI_CLOSE().setValue("RI CLOSED");*/
					
					 rs1=handler.executeSelectStatement(CUR_C1, con,new Object[]{RD_POL_SYS_ID,ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_SYS_ID(),ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_END_NO_IDX(),ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_COVER_CODE(),ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_YEAR()});
						if(rs1.next()){
							M_CLOSE_FLAG=rs1.getString(1);
						}
						if(M_CLOSE_FLAG != null){
							if(M_CLOSE_FLAG.equalsIgnoreCase("Y")){
								
								pvRiDetlAction.getCOMP_B_RI_CLOSE().setValue("RI CLOSED");
								//pvRiDetlAction.getCOMP_RI_BUT_CLOSE().setDisabled(true);
							}else{
								pvRiDetlAction.getCOMP_B_RI_CLOSE().setValue("RI NOT CLOSED");
								//pvRiDetlAction.getCOMP_RI_BUT_CLOSE().setDisabled(false);
							}
						}else{
							pvRiDetlAction.getCOMP_B_RI_CLOSE().setValue("RI NOT CLOSED");
						}
						
						// SET_BLOCK_PROPERTY('PT_IL_RI_PREM_ALLOC',UPDATE_ALLOWED,PROPERTY_FALSE);\par
					     //SET_BLOCK_PROPERTY('PT_IL_RI_PREM_ALLOC',INSERT_ALLOWED,PROPERTY_FALSE);\par
					     //SET_BLOCK_PROPERTY('PT_IL_RI_PREM_ALLOC',DELETE_ALLOWED,PROPERTY_FALSE);\par
						
						//CHK_PKG_FAILURE ;
						
						//P_DISPLAY_ERROR_MESSAGE;
				}
				
				
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try{
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
			}catch(Exception e){
			}
		
		
	
		}
	}
}

