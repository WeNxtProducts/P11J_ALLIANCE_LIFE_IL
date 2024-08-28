package com.iii.pel.forms.PILP039_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.adventnet.swissql.b.a.ac;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.tahoe.gui.thick.d2k.SmartTrigger;
import com.iii.pel.utils.PKG_PILP039_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class RI_CLOSING_ACTION_HELPER {
	public void pilp039_apac_ri_closing_when_create_record(RI_CLOSING closingBean) {
		CommonUtils commonUtils = new CommonUtils();
		java.sql.Date currentSQLDate = commonUtils.getCurrentSQLDate();
		closingBean.setUI_M_POL_DT_FM(currentSQLDate);
		closingBean.setUI_M_POL_DT_TO(currentSQLDate);
		closingBean.setUI_M_RI_ALLOC_TO_DT(currentSQLDate);
		
		closingBean.setUI_M_RI_PREM("N");
		closingBean.setUI_M_RI_CLAIM("N");
		closingBean.setUI_M_CLAIM_OS_YN("N");
	}
	public void pilp039_apac_ri_closing_m_ri_closing_ok_when_button_pressed(RI_CLOSING_ACTION action) throws ValidatorException,Exception{
	    try {
		RI_CLOSING RI_CLOSING_BEAN = action.getRI_CLOSING_BEAN();
		
		ArrayList<OracleParameter> orclList = new PKG_PILP039_APAC().M_RI_CLOSING_OK_W_B_P(
			RI_CLOSING_BEAN.getUI_M_FIN_QTR(),
			RI_CLOSING_BEAN.getUI_M_RI_PREM(), RI_CLOSING_BEAN.getUI_M_RI_CLAIM(),
			RI_CLOSING_BEAN.getUI_M_PROD_FM(), RI_CLOSING_BEAN.getUI_M_PROD_TO(), 
			RI_CLOSING_BEAN.getUI_M_RD_YEAR(), RI_CLOSING_BEAN.getUI_M_CLAIM_OS_YN(),
			CommonUtils.getGlobalVariable("GLOBAL_M_PARAM_11"), 
			CommonUtils.getGlobalVariable("M_BASE_CURR"), null);
		RI_CLOSING_BEAN.setUI_M_STATUS((String)orclList.get(0).getValueObject());
		
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new Exception(e.getMessage());
	    }
	}
	
	/*
    public void pilp039_apac_ri_closing_m_ri_closing_ok_when_button_pressed(RI_CLOSING_ACTION action) throws ValidatorException,Exception{
    	action.getErrorMap().clear();
    	action.getWarningMap().clear();
    	RI_CLOSING closingBean = action.getRI_CLOSING_BEAN();
    	String M_PRCR_CLASS_CODE = null;
		String M_POL_PROD_CODE = null;
		String M_PRCR_COMP_CODE = null;
		String M_PRCR_COVER_CODE = null;
		String M_POL_DIVN_CODE = null;
		String M_POL_DEPT_CODE = null;
		String M_POL_SRC_OF_BUS = null;
		Double M_PRCR_LC_PREM = -1.0;
		Double M_PRCR_FC_PREM = -1.0;
		Double M_PRCR_LC_COMM = -1.0;
		Double M_PRCR_FC_COMM = -1.0;
		double M_PRCR_LC_PREM_1 = -1;
		double M_PRCR_FC_PREM_1 = -1;
		double M_PRCR_LC_COMM_1 = -1;
		double M_PRCR_FC_COMM_1 = -1;
		java.sql.Date M_PRCR_CR_DT = null;
		Double M_RCR_LC_CLM_PAID = -1.0;
		Double M_RCR_FC_CLM_PAID = -1.0;
		String M_RCR_SRNO = null;
		String M_RCR_TREATY_TYPE = null;
		String M_RCR_TREATY_CODE = null;
		String M_PRCR_TREATY_CODE = null;
		String M_PRCR_UW_YEAR = null;
		String M_PRCR_SRNO = null;
		String M_PRCR_TREATY_TYPE = null;
		Double M_PTPC_SHARE_PERC = null;
		double M_RCR_LC_CLM_PAID_1 = -1;
		double M_RCR_FC_CLM_PAID_1 = -1;
		String M_RIA_SYS_ID = null;
		String M_RIPCA_SYS_ID = null;
		String M_PPTP_MON_FM = null;
		String M_PPTP_MON_TO = null;
		java.sql.Date M_RI_START_DT = null;
		java.sql.Date M_RI_END_DT = null;
		String M_RIA_TTY_CODE = null;
		String M_RIA_SRNO = null;
		String M_RIA_TTY_TYPE = null;
		String M_RIA_DEPT_CODE = null;
		String M_RIA_PROD_CODE = null;
		String M_RIA_CLASS_CODE = null;
		String M_RIA_COVER_CODE = null;
		double M_RI_OS_AMT = -1;
		double M_RI_CLAIM_PAID = -1;
		double M_RCR_LC_CLM_PAID_CUST = -1;
		double M_RI_OS_AMT_CUST = -1;
		double M_RI_PAID_AMT_CUST = -1;
		String M_BASE_CURR = null;
		String M_CAY_ACNT_YEAR = null;
		String M_CLAIM_SYS_ID = null;
		String M_TCE_TREATY_CODE = null;
		String M_TCE_CCD_COVER_CODE = null;
		String M_TCE_CCD_SYS_ID = null;
		String M_POL_PROD_CODE_1 = null;
		String M_POL_DIVN_CODE_1 = null;
		String M_POL_DEPT_CODE_1 = null;
		String M_POL_SRC_OF_BUS_1 = null;
		String M_POL_CLASS_CODE_1 = null;
		String M_PTT_SRNO = null;
		String M_PTT_TREATY_TYPE = null;
		String M_PTPC_CUST_CODE = null;
        double M_RI_OS_AMT_1=-1;
        
        // Get Global Values
        String M_PARA_11="";
        String M_FIN_QTR;
        String M_RI_PREM;
        String M_RI_CLAIM;
        String M_CLAIM_OS_YN;
        int rowCount =0;
        int rowCount1 =0;
        int rowCount2 =0;
        int rowCount3 =0; 
        int rowCount4 =0;
        
        
        String M_PROD_FM = closingBean.getUI_M_PROD_FM();
        String M_PROD_TO = closingBean.getUI_M_PROD_TO();
        String M_PRCR_PRD_TO_DT = null;
        String M_RD_YEAR = closingBean.getUI_M_RD_YEAR();
        String M_PRCR_PRD_FM_DT = null ;
        
        M_FIN_QTR = closingBean.getUI_M_FIN_QTR();
        M_RI_PREM = closingBean.getUI_M_RI_PREM();
        M_RI_CLAIM = closingBean.getUI_M_RI_CLAIM();
        M_CLAIM_OS_YN = closingBean.getUI_M_CLAIM_OS_YN();
        
        
        String sql_C1="SELECT PRCR_TREATY_CODE,PRCR_CLASS_CODE,POL_PROD_CODE,PRCR_COVER_CODE,POL_DIVN_CODE,POL_DEPT_CODE,PRCR_UW_YEAR,PRCR_SRNO,PRCR_TREATY_TYPE,POL_SRC_OF_BUS,SUM(NVL(PRCR_LC_PREM, 0)),SUM(NVL(PRCR_FC_PREM, 0)),SUM(NVL(PRCR_LC_COMM, 0)),SUM(NVL(PRCR_FC_COMM, 0)) FROM  PS_IL_PREM_RI_COMP_REG,PT_IL_POLICY  WHERE  POL_SYS_ID  = PRCR_POL_SYS_ID  AND NVL(PRCR_AC_CLOSE_FLAG, 'N')  = 'N'  AND PRCR_UW_YEAR  = PRCR_YEAR  AND POL_PROD_CODE  BETWEEN ?  AND  ?  AND PRCR_PRD_FM_DT  <= ? GROUP BY PRCR_TREATY_CODE,PRCR_CLASS_CODE,POL_PROD_CODE,PRCR_COVER_CODE,POL_DIVN_CODE,POL_DEPT_CODE,PRCR_UW_YEAR,PRCR_SRNO,PRCR_TREATY_TYPE,POL_SRC_OF_BUS  ";
        String sql_C2="SELECT    PRCR_TREATY_CODE,    PRCR_CLASS_CODE,    POL_PROD_CODE,    PRCR_COVER_CODE,    POL_DIVN_CODE,    POL_DEPT_CODE,    PRCR_UW_YEAR,    PRCR_SRNO,    PRCR_TREATY_TYPE,    POL_SRC_OF_BUS,    SUM(NVL(PRCR_LC_PREM, 0)),    SUM(NVL(PRCR_FC_PREM, 0)),    SUM(NVL(PRCR_LC_COMM, 0)),    SUM(NVL(PRCR_FC_COMM, 0)) FROM  PS_IL_PREM_RI_COMP_REG,   PT_IL_POLICY  WHERE  POL_SYS_ID  = PRCR_POL_SYS_ID  AND NVL(PRCR_AC_CLOSE_FLAG, 'N')  = 'N'  AND PRCR_UW_YEAR  != PRCR_YEAR  AND POL_PROD_CODE  BETWEEN '"+M_PROD_FM+"'  AND  '"+M_PROD_TO+"'  AND PRCR_PRD_FM_DT  <= "+M_PRCR_PRD_TO_DT+" GROUP BY PRCR_TREATY_CODE,   PRCR_CLASS_CODE,   POL_PROD_CODE,   PRCR_COVER_CODE,   POL_DIVN_CODE,   POL_DEPT_CODE,   PRCR_UW_YEAR,   PRCR_SRNO,   PRCR_TREATY_TYPE,    POL_SRC_OF_BUS  ";
        String sql_C4="SELECT    PTPC_SHARE_PERC,    PTPC_CUST_CODE FROM  PM_IL_PROP_TREATY_PART_CUST,   PM_IL_PROP_TREATY_TYPE,   PM_IL_PROP_TREATY  WHERE  PTT_SYS_ID  = PTPC_PTT_SYS_ID  AND PTT_PT_SYS_ID  = PT_SYS_ID  AND PT_TREATY_CODE  = ?  AND PT_CLASS_CODE  = ?  AND PT_UW_YEAR  = ?  AND PTT_TREATY_TYPE  = ? ";
        String sql_C5="SELECT 	 P9IL_RIA_SYS_ID.NEXTVAL FROM  DUAL  ";
        String sql_C6="SELECT    PPTP_MON_FM,    PPTP_MON_TO FROM  PM_IL_PROP_TREATY_PERIOD  WHERE  PPTP_PT_TREATY_CODE  = "+M_PRCR_TREATY_CODE+"  AND PPTP_SUB_NO  = :RI_CLOSING.M_FIN_QTR ";
        String sql_C7="SELECT 	 TO_DATE('01/' || "+M_PPTP_MON_FM+" || '/' || '"+M_RD_YEAR+"', 'DD/MM/RRRR') FROM  DUAL  ";
        String sql_C8="SELECT 	 LAST_DAY(TO_DATE('01/' || "+M_PPTP_MON_TO+" || '/' || '"+M_RD_YEAR+"', 'DD/MM/RRRR')) FROM  DUAL ";
        
        String sql_C11="SELECT CAY_ACNT_YEAR FROM  FM_COMP_ACNT_YEAR  WHERE  CAY_PREV_CURR_NEXT  = 'C' ";
        String sql_C12="SELECT    MIN(APER_FRM_DT),    MAX(APER_TO_DT) FROM  FM_ACNT_PERIOD  WHERE  APER_ACNT_YEAR  = ?  AND APER_QTLY  = DECODE(?, 5, APER_QTLY, ?) ";
        
        String sql_C14="SELECT    PTT_SRNO,    PTT_TREATY_TYPE,    PTPC_CUST_CODE FROM  PM_IL_PROP_TREATY,   PM_IL_PROP_TREATY_TYPE,   PM_IL_PROP_TREATY_PART_CUST  WHERE  PT_TREATY_CODE  = "+M_TCE_TREATY_CODE+"  AND PTT_PT_SYS_ID  = PT_SYS_ID  AND PTPC_PTT_SYS_ID  = PTT_SYS_ID ";
        
        
        
        ResultSet rst1 = null;
        ResultSet rst2 = null;
        ResultSet rst3 = null;
        ResultSet rst4 = null;
        ResultSet rst5 = null;
        ResultSet rst6 = null;
        ResultSet rst7 = null;
        ResultSet rst8 = null;
        ResultSet rst9 = null;
        ResultSet rst10 = null;
        ResultSet rst11 = null;
        
        
        DBProcedures dbProcCall = new DBProcedures();
        CRUDHandler handler = null;
        CommonUtils commonUtils = new CommonUtils();
        Connection con = null;
        
        M_PARA_11 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11");
        
        //TODO REMOVE HARD CODE M_PARA_11 VALUE 
        M_PARA_11 = "C";
        
        try {
			con = CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				if("C".equals(MigratingFunctions.nvl(M_PARA_11, "C"))){
					if("1".equals(M_FIN_QTR)){
						M_PRCR_PRD_FM_DT = getM_PRCR_PRD_FM_DT("TO_DATE('0101'||TO_CHAR(SYSDATE,'RRRR'),'DDMMRRRR')");
						M_PRCR_PRD_TO_DT = getM_PRCR_PRD_FM_DT("TO_DATE('3103'||TO_CHAR(SYSDATE,'RRRR'),'DDMMRRRR')");
					}else if("2".equals(M_FIN_QTR)){
						M_PRCR_PRD_FM_DT = getM_PRCR_PRD_FM_DT("TO_DATE('0104'||TO_CHAR(SYSDATE,'RRRR'),'DDMMRRRR')");
						M_PRCR_PRD_TO_DT = getM_PRCR_PRD_FM_DT("TO_DATE('3006'||TO_CHAR(SYSDATE,'RRRR'),'DDMMRRRR')");
					}else if("3".equals(M_FIN_QTR)){
						M_PRCR_PRD_FM_DT = getM_PRCR_PRD_FM_DT("TO_DATE('0107'||TO_CHAR(SYSDATE,'RRRR'),'DDMMRRRR')");
						M_PRCR_PRD_TO_DT = getM_PRCR_PRD_FM_DT("TO_DATE('3009'||TO_CHAR(SYSDATE,'RRRR'),'DDMMRRRR')");
					}else if("4".equals(M_FIN_QTR)){
						M_PRCR_PRD_FM_DT = getM_PRCR_PRD_FM_DT("TO_DATE('0110'||TO_CHAR(SYSDATE,'RRRR'),'DDMMRRRR')");
						M_PRCR_PRD_TO_DT = getM_PRCR_PRD_FM_DT("TO_DATE('3112'||TO_CHAR(SYSDATE,'RRRR'),'DDMMRRRR')");
					}else if("5".equals(M_FIN_QTR)){
						M_PRCR_PRD_FM_DT = getM_PRCR_PRD_FM_DT("TO_DATE('0101'||TO_CHAR(SYSDATE,'RRRR'),'DDMMRRRR')");
						M_PRCR_PRD_TO_DT = getM_PRCR_PRD_FM_DT("TO_DATE('3112'||TO_CHAR(SYSDATE,'RRRR'),'DDMMRRRR')");
					}
				}else if("A".equals(MigratingFunctions.nvl(M_PARA_11,"C"))){
						//1
						rst1 = handler.executeSelectStatement(sql_C11, con);
						if(rst1.next()){
						    M_CAY_ACNT_YEAR=rst1.getString(1);
						}
						//2
						Object[] values = { M_CAY_ACNT_YEAR, M_FIN_QTR, M_FIN_QTR };
						rst2 = handler.executeSelectStatement(sql_C12, con,values);
						if(rst2.next()){
							M_PRCR_PRD_FM_DT = rst2.getString(1);
							M_PRCR_PRD_TO_DT = rst2.getString(2);
						}
					}
				if("N".equals(M_RI_PREM) && "N".equals(M_RI_CLAIM) && "N".equals(M_CLAIM_OS_YN)){
					String[] msg = {Messages.getString("messageProperties_PILP039_APAC", "msg03206")};
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "3206", msg));
				}else{
					if("N".equals(M_RI_CLAIM) && "Y".equals(M_CLAIM_OS_YN)){
						String[] msg = {Messages.getString("messageProperties_PILP039_APAC", "msg13206")};
						throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "3206", msg));
					}else if("Y".equals(M_RI_CLAIM) && "N".equals(M_CLAIM_OS_YN)){
						String[] msg = {Messages.getString("messageProperties_PILP039_APAC", "msg23206")};
						throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "3206", msg));
					}
				}
                if("Y".equals(M_RI_PREM)){
                	Object[] values = { M_PROD_FM, M_PROD_TO, M_PRCR_PRD_TO_DT };
                    //SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"BUSY");
                	rst3 = handler.executeSelectStatement(sql_C1, con, values);
                	while(rst3.next()){
                        M_PRCR_TREATY_CODE=rst3.getString(1);
                        M_PRCR_CLASS_CODE=rst3.getString(2);
                        M_POL_PROD_CODE=rst3.getString(3);
                        M_PRCR_COVER_CODE=rst3.getString(4);
                        M_POL_DIVN_CODE=rst3.getString(5);
                        M_POL_DEPT_CODE=rst3.getString(6);
                        M_PRCR_UW_YEAR=rst3.getString(7);
                        M_PRCR_SRNO=rst3.getString(8);
                        M_PRCR_TREATY_TYPE=rst3.getString(9);
                        M_POL_SRC_OF_BUS=rst3.getString(10);
                        M_PRCR_LC_PREM=rst3.getDouble(11);
                        M_PRCR_FC_PREM=rst3.getDouble(12);
                        M_PRCR_LC_COMM=rst3.getDouble(13);
                        M_PRCR_FC_COMM=rst3.getDouble(14);
                        
                        if(M_PRCR_TREATY_CODE == null){
                        	M_PRCR_TREATY_CODE="";
                        }if(M_PRCR_CLASS_CODE == null){
                        	M_PRCR_CLASS_CODE="";
                        }if(M_POL_PROD_CODE == null){
                        	M_POL_PROD_CODE="";
                        }if(M_PRCR_COVER_CODE == null){
                        	M_PRCR_COVER_CODE="";
                        }if(M_POL_DIVN_CODE == null){
                        	M_POL_DIVN_CODE="";
                        }if(M_POL_DEPT_CODE == null){
                        	M_POL_DEPT_CODE="";
                        }if(M_PRCR_UW_YEAR == null){
                        	M_PRCR_UW_YEAR="";
                        }if(M_PRCR_SRNO == null){
                        	M_PRCR_SRNO="";
                        }if(M_PRCR_TREATY_TYPE == null){
                        	M_PRCR_TREATY_TYPE="";
                        }if(M_POL_SRC_OF_BUS == null){
                        	M_POL_SRC_OF_BUS="";
                        }if(M_PRCR_LC_PREM == null){
                        	M_PRCR_LC_PREM=0.0;
                        }if(M_PRCR_FC_PREM == null){
                        	M_PRCR_FC_PREM=0.0;
                        }if(M_PRCR_LC_COMM == null){
                        	M_PRCR_LC_COMM=0.0;
                        }if(M_PRCR_FC_COMM == null){
                        	M_PRCR_FC_COMM=0.0;
                        }

                        M_RIA_SYS_ID = getSysId();
                        // String sql_vembu1 = "INSERT INTO PT_IL_RI_ALLOC ( RIA_SYS_ID ,RIA_TTY_CODE ,RIA_SRNO ,RIA_TTY_TYPE ,RIA_UW_YEAR ,RIA_FM_DT ,RIA_TO_DT , RIA_APPRV_DT ,RIA_APPRV_STATUS ,RIA_DIVN_CODE ,RIA_DEPT_CODE ,RIA_PROD_CODE ,RIA_COVER_CODE ,RIA_NB_REN_FLAG , RIA_LC_PREMIUM ,RIA_FC_PREMIUM ,RIA_LC_COMMISSION ,RIA_FC_COMMISSION ,RIA_CLM_PAID ,RIA_CLAIMS_OS ,RIA_SRC_OF_BUS )VALUES   (?,?,?,?,?,?,?,null,null,?,?,?,?,N,?,?,?,?,null,null,?)";
                        String sql_vembu1 = "INSERT INTO PT_IL_RI_ALLOC ( RIA_SYS_ID ,RIA_TTY_CODE,RIA_SRNO,RIA_TTY_TYPE,RIA_UW_YEAR,RIA_FM_DT,RIA_TO_DT,RIA_APPRV_DT,RIA_APPRV_STATUS,RIA_DIVN_CODE,RIA_DEPT_CODE,RIA_PROD_CODE,RIA_COVER_CODE,RIA_NB_REN_FLAG,RIA_LC_PREMIUM,RIA_FC_PREMIUM,RIA_LC_COMMISSION,RIA_FC_COMMISSION,RIA_CLM_PAID,RIA_CLAIMS_OS,RIA_SRC_OF_BUS )" +
                        "VALUES   ('"+M_RIA_SYS_ID+"','"+M_PRCR_TREATY_CODE+"','"+M_PRCR_SRNO+"','"+M_PRCR_TREATY_TYPE+"','"+M_PRCR_UW_YEAR+"','"+M_PRCR_PRD_FM_DT+"','"+M_PRCR_PRD_TO_DT+"'" +
                        ",null,null,'"+M_POL_DIVN_CODE+"','"+M_POL_DEPT_CODE+"','"+M_POL_PROD_CODE+"','"+M_PRCR_COVER_CODE+"'," +
                        "'N','"+M_PRCR_LC_PREM+"','"+M_PRCR_FC_PREM+"','"+M_PRCR_LC_COMM+"','"+M_PRCR_FC_COMM+"',null,null,'"+M_POL_SRC_OF_BUS+"')";
                        
                        Object[] insertValue = { M_RIA_SYS_ID, M_PRCR_TREATY_CODE,
                        		M_PRCR_SRNO, M_PRCR_TREATY_TYPE, M_PRCR_UW_YEAR,
                        		M_PRCR_PRD_FM_DT, M_PRCR_PRD_TO_DT, M_POL_DIVN_CODE, 
                        		M_POL_DEPT_CODE, M_POL_PROD_CODE,
                        		M_PRCR_COVER_CODE,M_PRCR_LC_PREM, M_PRCR_FC_PREM,
                        		M_PRCR_LC_COMM ,M_PRCR_FC_COMM,M_POL_SRC_OF_BUS};
                        
                        rowCount = handler.executeInsertStatement(sql_vembu1, con);
                        if(rowCount!=0){
                        	//throw new ValidatorException(new FacesMessage(rowCount+" Record Inserted"));
                        	System.out.println("1.Inserted "+rowCount);
                        }
                        
                        Object[] values2 = { M_PRCR_TREATY_CODE, M_PRCR_CLASS_CODE,M_PRCR_UW_YEAR, M_PRCR_TREATY_TYPE };
                        rst5 = handler.executeSelectStatement(sql_C4, con,values2);
                        if(rst5.next()){
                            M_PTPC_SHARE_PERC=rst5.getDouble(1);
                            M_PRCR_COMP_CODE=rst5.getString(2);
                        }
                        M_BASE_CURR = CommonUtils.getGlobalVariable("M_BASE_CURR");
                        M_PRCR_FC_PREM_1 = MigratingFunctions.nvl(M_PRCR_FC_PREM, 0) * MigratingFunctions.nvl(M_PTPC_SHARE_PERC, 0) / 100;
                        M_PRCR_LC_PREM_1 = MigratingFunctions.nvl(M_PRCR_LC_PREM, 0) * MigratingFunctions.nvl(M_PTPC_SHARE_PERC, 0) / 100;
                        // TODO NEED TO CALL TO MORE PROCEDURES ...
                        dbProcCall.P_VAL_ROUND_AMT(M_BASE_CURR,M_PRCR_FC_PREM,"R",null);
                        dbProcCall.P_VAL_ROUND_AMT(M_BASE_CURR,M_PRCR_LC_PREM,"R",null);
                        M_PRCR_FC_COMM_1=MigratingFunctions.nvl(M_PRCR_FC_COMM,0)*MigratingFunctions.nvl(M_PTPC_SHARE_PERC,0)/100;
                        M_PRCR_LC_COMM_1=MigratingFunctions.nvl(M_PRCR_LC_COMM,0)*MigratingFunctions.nvl(M_PTPC_SHARE_PERC,0)/100;
                        dbProcCall.P_VAL_ROUND_AMT(M_BASE_CURR,M_PRCR_FC_COMM_1,"R",null);
                        dbProcCall.P_VAL_ROUND_AMT(M_BASE_CURR,M_PRCR_LC_COMM_1,"R",null);
                        
                        Object[] insertValue1 ={M_RIA_SYS_ID,M_PRCR_COMP_CODE,M_PTPC_SHARE_PERC,M_PRCR_TREATY_TYPE,M_PRCR_SRNO,M_PRCR_FC_PREM_1,M_PRCR_LC_PREM_1,M_PRCR_FC_COMM_1,M_PRCR_LC_COMM_1};
                        String sql_vembu2="INSERT INTO  PT_IL_RI_PART_CUST_ALLOC      ( RIPCA_SYS_ID ,    RIPCA_RIA_SYS_ID ,    RIPCA_CUST_CODE ,    RIPCA_SHARE_PERC ,    RIPCA_TTY_TYPE ,    RIPCA_SRNO ,    RIPCA_FC_PREMIUM ,    RIPCA_LC_PREMIUM ,    RIPCA_FC_COMMISSION ,    RIPCA_LC_COMMISSION ,    RIPCA_CLM_PAID ,    RIPCA_CLAIMS_OS )    VALUES   ( P9IL_RIPCA_SYS_ID.NEXTVAL ,?,?,?,?,?,?,?,?,?,null,null)   ";
                        rowCount1 = handler.executeInsertStatement(sql_vembu2, con, insertValue1);
                        if (rowCount1 != 0) {
                        	//throw new ValidatorException(new FacesMessage(rowCount+" Record Inserted"));
                        	System.out.println("2. Inserted : "+rowCount1);
                        }
                        dbProcCall.helperP9ILPK_RI_CLOSE$P_PROCESS_TREATY_ACC_PREM(M_PRCR_LC_PREM_1+"",M_PRCR_FC_PREM_1+"",M_PRCR_COVER_CODE,M_POL_DIVN_CODE,M_POL_DEPT_CODE,"N",M_POL_PROD_CODE,M_PRCR_COMP_CODE,M_PRCR_TREATY_TYPE,M_POL_SRC_OF_BUS);
                        dbProcCall.helperP9ILPK_RI_CLOSE$P_PROCESS_TREATY_ACC_COMM(M_PRCR_LC_COMM_1+"",M_PRCR_FC_COMM_1+"",M_PRCR_COVER_CODE,M_POL_DIVN_CODE,M_POL_DEPT_CODE,"R",M_POL_PROD_CODE,M_PRCR_COMP_CODE,M_PRCR_TREATY_TYPE,M_POL_SRC_OF_BUS);
                	}
                    
                    closingBean.setUI_M_STATUS(M_POL_PROD_CODE);
                    M_RIA_SYS_ID = getSysId();
                    String sql_vembu3="UPDATE   PT_IL_RI_ALLOC    SET RIA_APPRV_DT = TRUNC(SYSDATE),      RIA_APPRV_STATUS = 'A'  WHERE  RIA_SYS_ID  = "+M_RIA_SYS_ID+"  ";
                    rowCount3 = handler.executeInsertStatement(sql_vembu3, con);
                    if (rowCount3 != 0) {
                    	//throw new ValidatorException(new FacesMessage(rowCount+" Record Inserted"));
                    }
                    String sql_vembu4="UPDATE   PS_IL_PREM_RI_COMP_REG    SET PRCR_AC_CLOSE_FLAG = 'Y'  WHERE  (PRCR_POL_SYS_ID  , PRCR_SCHD_DT  ) IN  (   SELECT     POL_SYS_ID,     PC_SCHD_PYMT_DT  FROM  PT_IL_POLICY,    PT_IL_PREM_COLL   WHERE  POL_SYS_ID  = PC_POL_SYS_ID   AND POL_PROD_CODE  BETWEEN '"+M_PROD_FM+"'  AND  '"+M_PROD_TO+"'   AND PC_APPRV_DT  <= '"+M_PRCR_PRD_TO_DT+"'  )  AND NVL(PRCR_AC_CLOSE_FLAG, 'N')  = 'N'  AND PRCR_UW_YEAR  = PRCR_YEAR  ";
                    handler.executeInsertStatement(sql_vembu4, con);
                    
                    Object[] insertValue3 = { M_PROD_FM, M_PROD_TO,M_PRCR_PRD_FM_DT, M_PRCR_PRD_TO_DT };
                    String sql_vembu8="UPDATE   PS_IL_PREM_RI_COMP_REG    SET PRCR_AC_CLOSE_FLAG = 'Y'  WHERE  (PRCR_POL_SYS_ID  , PRCR_SCHD_DT  ) IN  (   SELECT     POL_SYS_ID,     PC_SCHD_PYMT_DT  FROM  PT_IL_POLICY,    PT_IL_PREM_COLL   WHERE  POL_SYS_ID  = PC_POL_SYS_ID   AND POL_PROD_CODE  BETWEEN '"+M_PROD_FM+"'  AND  '"+M_PROD_TO+"'   AND PC_APPRV_DT  <= '"+M_PRCR_PRD_TO_DT+"'  )  AND NVL(PRCR_AC_CLOSE_FLAG, 'N')  = 'N'  AND PRCR_UW_YEAR  != PRCR_YEAR  ";
                    rowCount2 = handler.executeInsertStatement(sql_vembu8, con);
                    if (rowCount2 != 0) {
                    	//	throw new ValidatorException(new FacesMessage(rowCount+" Record Inserted"));
                    }
                    
                }
                
                if("Y".equals(M_RI_CLAIM) && "Y".equals(M_CLAIM_OS_YN)){
                	String sql_C13="SELECT    TCE_TREATY_CODE,    POL_PROD_CODE,    TCE_CCD_COVER_CODE,    POL_DIVN_CODE,    POL_DEPT_CODE,    POL_SRC_OF_BUS,    POL_CLASS_CODE,    TCE_CCD_SYS_ID FROM  PT_IL_POLICY,   PT_IL_CLAIM,   PT_IL_TTY_CLAIM_EST  WHERE  POL_SYS_ID  = CLAIM_POL_SYS_ID  AND CLAIM_SYS_ID  = TCE_CLAIM_SYS_ID  AND NVL(TCE_OS_AC_CLOSE_FLAG, 'N')  = 'N'  AND POL_PROD_CODE  BETWEEN '"+M_PROD_FM+"'  AND  '"+M_PROD_TO+"' ";
                	rst4 = handler.executeSelectStatement(sql_C13, con);
                	while(rst4.next()){
                		 M_TCE_TREATY_CODE=rst4.getString(1);
                         M_POL_PROD_CODE_1=rst4.getString(2);
                         M_TCE_CCD_COVER_CODE=rst4.getString(3);
                         M_POL_DIVN_CODE_1=rst4.getString(4);
                         M_POL_DEPT_CODE_1=rst4.getString(5);
                         M_POL_SRC_OF_BUS_1=rst4.getString(6);
                         M_POL_CLASS_CODE_1=rst4.getString(7);
                         M_TCE_CCD_SYS_ID=rst4.getString(8);
                         
                         if(M_TCE_TREATY_CODE == null){
                        	 M_TCE_TREATY_CODE="";
                         }if(M_POL_PROD_CODE_1 == null){
                        	 M_POL_PROD_CODE_1="";
                         }if(M_TCE_CCD_COVER_CODE == null){
                        	 M_TCE_CCD_COVER_CODE="";
                         }if(M_POL_DIVN_CODE_1 == null){
                        	 M_POL_DIVN_CODE_1="";
                         }if(M_POL_DEPT_CODE_1 == null){
                        	 M_POL_DEPT_CODE_1="";
                         }if(M_POL_SRC_OF_BUS_1 == null){
                        	 M_POL_SRC_OF_BUS_1="";
                         }if(M_POL_CLASS_CODE_1 == null){
                        	 M_POL_CLASS_CODE_1="";
                         }if(M_TCE_CCD_SYS_ID == null){
                        	 M_TCE_CCD_SYS_ID="";
                         }
                         
                	}
                    M_RI_OS_AMT_1=0;
                    rst6 = handler.executeSelectStatement(sql_C14, con);
                    if(rst6.next()){
                        M_PTT_SRNO=rst6.getString(1);
                        M_PTT_TREATY_TYPE=rst6.getString(2);
                        M_PTPC_CUST_CODE=rst6.getString(3);
                    }
                    String sql_C18="SELECT (SUM(DECODE('"+M_PTT_SRNO+"', 1, NVL(TCE_QS_LC_CLM_EST, 0), 2, NVL(TCE_1S_LC_CLM_EST, 0), 3, NVL(TCE_2S_LC_CLM_EST, 0), 4, NVL(TCE_3S_LC_CLM_EST, 0)))) RI_OS_AMT_1 FROM  PT_IL_TTY_CLAIM_EST,   PT_IL_CLAIM,   PT_IL_POLICY  WHERE  TCE_CLAIM_SYS_ID  = CLAIM_SYS_ID  AND POL_SYS_ID  = CLAIM_POL_SYS_ID  AND TCE_TREATY_CODE  = '"+M_TCE_TREATY_CODE+"'  AND TCE_CCD_COVER_CODE  = '"+M_TCE_CCD_COVER_CODE+"'  AND POL_CLASS_CODE  = '"+M_POL_CLASS_CODE_1+"'  AND POL_DEPT_CODE  = '"+M_POL_DEPT_CODE_1+"'  AND POL_PROD_CODE  = '"+M_POL_PROD_CODE_1+"'  AND NVL(TCE_OS_AC_CLOSE_FLAG, 'N')  = 'N'  AND TCE_CCD_SYS_ID  NOT IN  (   SELECT RCA_CCD_SYS_ID  FROM  PT_IL_RI_CLAIM_ALLOC   WHERE  RCA_CLM_SYS_ID  = TCE_CLAIM_SYS_ID  )  AND TRUNC(TCE_CCD_RESERVE_DT)  BETWEEN '"+M_PRCR_PRD_FM_DT+"'  AND  '"+M_PRCR_PRD_TO_DT+"' ";
                    rst7 = handler.executeSelectStatement(sql_C18, con);
                    if(rst7.next()){
                        M_RI_OS_AMT_1=rst7.getDouble(1);
                    }
                    if(M_RI_OS_AMT_1>0){
                    	dbProcCall.helperP9ILPK_RI_CLOSE$P_PROCESS_TREATY_ACC_CLM_OS(M_RI_OS_AMT_1+"",M_RI_OS_AMT_1+"",M_TCE_CCD_COVER_CODE,M_POL_DIVN_CODE_1,M_POL_DEPT_CODE_1,"N",M_POL_PROD_CODE_1,M_PTPC_CUST_CODE,M_PTT_TREATY_TYPE,M_POL_SRC_OF_BUS_1);
                    }
                    int rowCount5=0;
                    String sql_vembu9="UPDATE   PT_IL_TTY_CLAIM_EST    SET TCE_OS_AC_CLOSE_FLAG = 'Y'  WHERE  TCE_CCD_SYS_ID  = "+M_TCE_CCD_SYS_ID+"  ";
                    rowCount5 = handler.executeInsertStatement(sql_vembu9, con);
                    if (rowCount5 != 0) {
                    }
                }
                if("Y".equals(M_RI_CLAIM) && "Y".equals(M_CLAIM_OS_YN)){
                	String sql_C3="SELECT    RCR_TREATY_CODE,    RCR_CLASS_CODE,    POL_PROD_CODE,    RCR_CLM_COVER_CODE,    RCR_SRNO,    POL_DIVN_CODE,    POL_DEPT_CODE,    RCR_TREATY_TYPE,    RCR_UW_YEAR,    POL_SRC_OF_BUS,    SUM(NVL(RCR_LC_CLM_PAID, 0)) TOT_RCR_LC_CLM_PAID,    SUM(NVL(RCR_FC_CLM_PAID, 0)) TOT_RCR_FC_CLM_PAID,    CLAIM_SYS_ID FROM  PT_IL_POLICY,   PT_IL_CLAIM,   PS_IL_RI_CLAIM_COMP_REG  WHERE  POL_SYS_ID  = CLAIM_POL_SYS_ID  AND CLAIM_SYS_ID  = RCR_CLAIM_SYS_ID  AND NVL(RCR_AC_CLOSE_FLAG, 'N')  = 'N'  AND RCR_YEAR  = '"+M_RD_YEAR+"'  AND RCR_DT  BETWEEN '"+M_PRCR_PRD_FM_DT+"'  AND  '"+M_PRCR_PRD_TO_DT+"'  AND POL_PROD_CODE  BETWEEN '"+M_PROD_FM+"'  AND  '"+M_PROD_TO+"' GROUP BY RCR_TREATY_CODE,   RCR_CLASS_CODE,   POL_PROD_CODE,   RCR_CLM_COVER_CODE,   RCR_SRNO,   POL_DIVN_CODE,   POL_DEPT_CODE,   RCR_TREATY_TYPE,   RCR_UW_YEAR,   POL_SRC_OF_BUS,    CLAIM_SYS_ID  ";
                	rst8 = handler.executeSelectStatement(sql_C3, con);
                	while(rst8.next()){
                		 M_PRCR_TREATY_CODE=rst8.getString(1);
                         M_PRCR_CLASS_CODE=rst8.getString(2);
                         M_POL_PROD_CODE=rst8.getString(3);
                         M_PRCR_COVER_CODE=rst8.getString(4);
                         M_PRCR_SRNO=rst8.getString(5);
                         M_POL_DIVN_CODE=rst8.getString(6);
                         M_POL_DEPT_CODE=rst8.getString(7);
                         M_PRCR_TREATY_TYPE=rst8.getString(8);
                         M_PRCR_UW_YEAR=rst8.getString(9);
                         M_POL_SRC_OF_BUS=rst8.getString(10);
                         M_RCR_LC_CLM_PAID=rst8.getDouble(11);
                         M_RCR_FC_CLM_PAID=rst8.getDouble(12);
                         M_CLAIM_SYS_ID=rst8.getString(13);
                	}
                	
                	if(M_PRCR_TREATY_CODE == null){
                		M_PRCR_TREATY_CODE="";
                    }if(M_PRCR_CLASS_CODE == null){
                    	M_PRCR_CLASS_CODE="";
                    }if(M_POL_PROD_CODE == null){
                    	M_POL_PROD_CODE="";
                    }if(M_PRCR_COVER_CODE == null){
                    	M_PRCR_COVER_CODE="";
                    }if(M_PRCR_SRNO == null){
                    	M_PRCR_SRNO="";
                    }if(M_POL_DIVN_CODE == null){
                    	M_POL_DIVN_CODE="";
                    }if(M_POL_DEPT_CODE == null){
                    	M_POL_DEPT_CODE="";
                    }if(M_PRCR_TREATY_TYPE == null){
                    	M_PRCR_TREATY_TYPE="";
                    }if(M_PRCR_UW_YEAR == null){
                    	M_PRCR_UW_YEAR="";
                    }if(M_POL_SRC_OF_BUS == null){
                    	M_POL_SRC_OF_BUS="";
                    }if(M_RCR_LC_CLM_PAID == null){
                    	M_RCR_LC_CLM_PAID=0.0;
                    }if(M_RCR_FC_CLM_PAID == null){
                    	M_RCR_FC_CLM_PAID=0.0;
                    }if(M_CLAIM_SYS_ID == null){
                    	M_CLAIM_SYS_ID="";
                    }
                	
                    M_RI_OS_AMT = 0;
                    String sql_C10="SELECT NVL(SUM(RI_OS_AMT), 0) FROM ( SELECT (SUM(RCA_RI_FC_CLM_EST) - NVL(SUM(RCA_RI_FC_CLM_PAID), 0)) RI_OS_AMT  FROM  PT_IL_RI_CLAIM_ALLOC,    PT_IL_CLAIM,    PT_IL_POLICY   WHERE  RCA_CLM_SYS_ID  = CLAIM_SYS_ID   AND POL_SYS_ID  = CLAIM_POL_SYS_ID   AND RCA_TREATY_CODE  = '"+M_PRCR_TREATY_CODE+"'   AND RCA_TREATY_TYPE  = '"+M_PRCR_TREATY_TYPE+"'   AND RCA_SRNO  = '"+M_PRCR_SRNO+"'   AND RCA_CLASS_CODE  = '"+M_PRCR_CLASS_CODE+"'   AND POL_DEPT_CODE  = '"+M_POL_DEPT_CODE+"'   AND POL_PROD_CODE  = '"+M_POL_PROD_CODE+"'   AND RCA_CLAIM_COVER_CODE  = '"+M_PRCR_COVER_CODE+"'   AND NVL(RCA_RI_CLM_CLOSE_FLAG, 'N')  = 'Y'   AND NVL(RCA_RI_ACNT_CLOSE_FLAG, 'N')  = 'N'   AND TRUNC(RCA_DT)  BETWEEN '"+M_PRCR_PRD_FM_DT+"'  AND  '"+M_PRCR_PRD_TO_DT+"'  UNION ALL   SELECT (SUM(DECODE('"+M_PRCR_SRNO+"', 1, TCE_QS_LC_CLM_EST, 2, TCE_1S_LC_CLM_EST, 3, TCE_2S_LC_CLM_EST, 4, TCE_3S_LC_CLM_EST))) RI_OS_AMT  FROM  PT_IL_TTY_CLAIM_EST,    PT_IL_CLAIM,    PT_IL_POLICY   WHERE  TCE_CLAIM_SYS_ID  = CLAIM_SYS_ID   AND POL_SYS_ID  = CLAIM_POL_SYS_ID   AND TCE_TREATY_CODE  = '"+M_PRCR_TREATY_CODE+"'   AND TCE_CCD_COVER_CODE  = '"+M_PRCR_COVER_CODE+"'   AND POL_CLASS_CODE  = '"+M_PRCR_CLASS_CODE+"'   AND POL_DEPT_CODE  = '"+M_POL_DEPT_CODE+"'   AND POL_PROD_CODE  = '"+M_POL_PROD_CODE+"'   AND NVL(TCE_OS_AC_CLOSE_FLAG, 'N')  = 'N'   AND TCE_CCD_SYS_ID  NOT IN   (    SELECT RCA_CCD_SYS_ID   FROM  PT_IL_RI_CLAIM_ALLOC    WHERE  RCA_CLM_SYS_ID  = TCE_CLAIM_SYS_ID   )   AND TRUNC(TCE_CCD_RESERVE_DT)  BETWEEN '"+M_PRCR_PRD_FM_DT+"'  AND  '"+M_PRCR_PRD_TO_DT+"'   )  ";
                    rst9 = handler.executeSelectStatement(sql_C10, con);
                    if(rst9.next()){
                        M_RI_OS_AMT=rst9.getDouble(1);
                    }
                    
                    rst10 = handler.executeSelectStatement(sql_C5, con);
                    if(rst10.next()){
                        M_RI_OS_AMT=rst10.getDouble(1);
                    }
                    int rowCount6=0;
                    
                    String sql_vembu10="INSERT INTO  PT_IL_RI_ALLOC ( RIA_SYS_ID ,    RIA_TTY_CODE ,    RIA_SRNO ,    RIA_TTY_TYPE ,    RIA_UW_YEAR ,    RIA_FM_DT ,    RIA_TO_DT ,    RIA_APPRV_DT ,    RIA_APPRV_STATUS ,    RIA_DIVN_CODE ,    RIA_DEPT_CODE ,    RIA_PROD_CODE ,    RIA_COVER_CODE ,    RIA_NB_REN_FLAG ,    RIA_LC_PREMIUM ,    RIA_FC_PREMIUM ,    RIA_LC_COMMISSION ,    RIA_FC_COMMISSION ,    RIA_CLM_PAID ,    RIA_CLAIMS_OS ,    RIA_SRC_OF_BUS )    VALUES   ( '"+M_RIA_SYS_ID+"' ,    '"+M_PRCR_TREATY_CODE+"' ,    '"+M_PRCR_SRNO+"' ,    '"+M_PRCR_TREATY_TYPE+"' ,    '"+M_PRCR_UW_YEAR+"' ,    '"+M_PRCR_PRD_FM_DT+"' ,    '"+M_PRCR_PRD_TO_DT+"' ,    NULL ,    NULL ,    '"+M_POL_DIVN_CODE+" ',   ' "+M_POL_DEPT_CODE+"' ,    '"+M_POL_PROD_CODE+"' ,    '"+M_PRCR_COVER_CODE+"' ,    'N' ,    NULL ,    NULL ,    NULL ,    NULL ,    "+M_RCR_LC_CLM_PAID+" ,    "+M_RI_OS_AMT+" ,    '"+M_POL_SRC_OF_BUS+" ')   ";
                    rowCount6 = handler.executeInsertStatement(sql_vembu10, con);
                    if (rowCount6 != 0) {
                    	System.out.println("rowCount 6 is Inserted");
                    }
                    Object[] values2 = { M_PRCR_TREATY_CODE, M_PRCR_CLASS_CODE,M_PRCR_UW_YEAR, M_PRCR_TREATY_TYPE };
                    rst11 = handler.executeSelectStatement(sql_C4, con,values2);
                    if(rst11.next()){
                        M_PTPC_SHARE_PERC=rst11.getDouble(1);
                        M_PRCR_COMP_CODE=rst11.getString(2);
                    }
                    if(M_PTPC_SHARE_PERC == null){
                    	M_PTPC_SHARE_PERC=0.0;
                    }
                    M_RI_OS_AMT_CUST=MigratingFunctions.nvl(M_RI_OS_AMT,0)*MigratingFunctions.nvl(M_PTPC_SHARE_PERC,0)/100;
                    dbProcCall.P_VAL_ROUND_AMT(M_BASE_CURR,M_RI_OS_AMT_CUST,"R",null);
                    M_RCR_LC_CLM_PAID_CUST=MigratingFunctions.nvl(M_RCR_LC_CLM_PAID,0)*MigratingFunctions.nvl(M_PTPC_SHARE_PERC,0)/100;
                    dbProcCall.P_VAL_ROUND_AMT(M_BASE_CURR,M_RCR_LC_CLM_PAID_CUST,"R",null);
                    int rowCount7=0;
                    String sql_vembu11="INSERT INTO  PT_IL_RI_PART_CUST_ALLOC      ( RIPCA_SYS_ID ,    RIPCA_RIA_SYS_ID ,    RIPCA_CUST_CODE ,    RIPCA_SHARE_PERC ,    RIPCA_TTY_TYPE ,    RIPCA_SRNO ,    RIPCA_FC_PREMIUM ,    RIPCA_LC_PREMIUM ,    RIPCA_FC_COMMISSION ,    RIPCA_LC_COMMISSION ,    RIPCA_CLM_PAID ,    RIPCA_CLAIMS_OS )    VALUES   ( P9IL_RIPCA_SYS_ID.NEXTVAL ,    '"+M_RIA_SYS_ID+"' ,    '"+M_PRCR_COMP_CODE+"' ,    '"+M_PTPC_SHARE_PERC+"' ,    '"+M_PRCR_TREATY_TYPE+"' ,    '"+M_PRCR_SRNO+"' ,    NULL ,    NULL ,    NULL ,    NULL ,    '"+M_RCR_LC_CLM_PAID_CUST+"' ,    '"+M_RI_OS_AMT_CUST+"' )   ";
                    rowCount7 = handler.executeInsertStatement(sql_vembu11, con);
                    if (rowCount7 != 0) {
                    	System.out.println("rowCount 7 is Inserted");
                    }
                    if(MigratingFunctions.nvl(M_RCR_LC_CLM_PAID,0)>0 && MigratingFunctions.nvl(M_RI_CLAIM,"N")=="Y"){
                    	dbProcCall.helperP9ILPK_RI_CLOSE$P_PROCESS_TREATY_ACC_CLM_PAID(M_RCR_LC_CLM_PAID+"",M_RCR_FC_CLM_PAID+"",M_PRCR_COVER_CODE,M_POL_DIVN_CODE,M_POL_DEPT_CODE,"N",M_POL_PROD_CODE,M_PRCR_COMP_CODE,M_PRCR_TREATY_TYPE,M_POL_SRC_OF_BUS);
                    }
                    if(MigratingFunctions.nvl(M_RI_OS_AMT_CUST,0)>0 && MigratingFunctions.nvl(M_CLAIM_OS_YN,"N")=="Y"){
                    	dbProcCall.helperP9ILPK_RI_CLOSE$P_PROCESS_TREATY_ACC_CLM_OS(M_RI_OS_AMT_CUST+"",M_RI_OS_AMT_CUST+"",M_PRCR_COVER_CODE,M_POL_DIVN_CODE,M_POL_DEPT_CODE,"N",M_POL_PROD_CODE,M_PRCR_COMP_CODE,M_PRCR_TREATY_TYPE,M_POL_SRC_OF_BUS);
                    }
                    closingBean.setUI_M_STATUS(M_POL_PROD_CODE);
                }
                String sql_vembu12="UPDATE   PS_IL_RI_CLAIM_COMP_REG    SET RCR_AC_CLOSE_FLAG = 'Y'  WHERE  (RCR_CP_REF_SYS_ID  , RCR_POL_NO  ) IN  (   SELECT     CP_REF_SYS_ID,     POL_NO  FROM  PT_IL_POLICY,    PT_IL_CLAIM,    PT_IL_CLAIM_PAID   WHERE  POL_SYS_ID  = CLAIM_POL_SYS_ID   AND POL_NO  = CLAIM_POL_NO   AND CP_CLAIM_SYS_ID  = CLAIM_SYS_ID   AND POL_PROD_CODE  BETWEEN '"+M_PROD_FM+"'  AND  '"+M_PROD_TO+"'   AND CP_PAID_DT  BETWEEN '"+M_PRCR_PRD_FM_DT+"'  AND  '"+M_PRCR_PRD_TO_DT+"'  )  AND NVL(RCR_AC_CLOSE_FLAG, 'N')  = 'N'  ";
                handler.executeInsertStatement(sql_vembu12, con);
                String sql_vembu13="UPDATE PT_IL_RI_ALLOC SET RIA_APPRV_DT = TRUNC(SYSDATE), RIA_APPRV_STATUS = 'A'  WHERE  RIA_SYS_ID  = "+M_RIA_SYS_ID+"  ";
                handler.executeInsertStatement(sql_vembu13, con);
                Object[] insertValue5 = { M_CLAIM_SYS_ID };
                String sql_vembu14="UPDATE PT_IL_TTY_CLAIM_EST SET TCE_OS_AC_CLOSE_FLAG = 'Y' WHERE TCE_CLAIM_SYS_ID = ?";
                rowCount4 = handler.executeInsertStatement(sql_vembu14, con, insertValue5);
                if (rowCount4 != 0) {
                	//throw new ValidatorException(new FacesMessage(rowCount+" Record Inserted"));
                }
                closingBean.setUI_M_STATUS("SUCESSFULLY COMPLETED");
                action.getCOMP_UI_M_STATUS().resetValue();
                
                System.out.println("STATUS ::::" + closingBean.getUI_M_STATUS());
			}
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		}catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			ErrorHelpUtil.getErrorsAndWarningforProcedure(con, FacesContext.getCurrentInstance(),action.getCOMP_UI_M_RI_CLOSING_OK().getId() , action.getWarningMap());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			CommonUtils.closeCursor(rst1);
			CommonUtils.closeCursor(rst2);
			CommonUtils.closeCursor(rst3);
			CommonUtils.closeCursor(rst4);
			CommonUtils.closeCursor(rst5);
			CommonUtils.closeCursor(rst6);
			CommonUtils.closeCursor(rst7);
			CommonUtils.closeCursor(rst8);
			CommonUtils.closeCursor(rst9);
			CommonUtils.closeCursor(rst10);
			CommonUtils.closeCursor(rst11);
		}
        
    }
    
   */
    /*-------------------------------------------------------------------*/
    public String getM_PRCR_PRD_FM_DT(String query){
    	String assignDate = "";
    	Date forMatDate;
    	Connection con = null;
    	ResultSet rst = null;
    	CRUDHandler handler = null;
    	String selectQuery = "select "+query+" from dual";
    	try {
			con = CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				if(rst.next()){
					forMatDate = rst.getDate(1);
					assignDate = new SimpleDateFormat("dd-MMM-yyyy").format(forMatDate);
				}
				
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return assignDate;
    }
    
    public String getSysId(){
    	Connection con = null;
    	CRUDHandler handler = null;
    	ResultSet rst = null;
    	String sysID = "";
    	String selectQuery="SELECT 	 P9IL_RIA_SYS_ID.NEXTVAL FROM  DUAL  ";
    	try {
			con = CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				if(rst.next()){
					sysID = rst.getString(1);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysID;
    }
    
    public void prod_fm_when_validate_item(RI_CLOSING_ACTION action) throws ValidatorException {
    	RI_CLOSING valueBean = action.getRI_CLOSING_BEAN();
    	Connection connection = null;
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet resultSet = null;
    	
    	String prod_fm = (String) action.getCOMP_UI_M_PROD_FM().getSubmittedValue();
    	try{
    		if(prod_fm!=null && !prod_fm.trim().equals("")){
	    		connection = CommonUtils.getConnection();
	    		String query = "SELECT PROD_DESC FROM   PM_IL_PRODUCT WHERE  PROD_CODE = ? ";
	    		Object[] values = {prod_fm};
	    		resultSet = handler.executeSelectStatement(query, connection, values);
	    		if(resultSet.next()){
	    			valueBean.setUI_M_PROD_FM_DESC(resultSet.getString(1));
	    		}
	    		action.getRI_CLOSING_BEAN().setUI_M_PROD_FM(prod_fm);
	    		action.getCOMP_UI_M_PROD_FM().setSubmittedValue(prod_fm);
	    		action.getRI_CLOSING_BEAN().setUI_M_PROD_TO(prod_fm);
    		}else{
				prod_fm = (String) new CommonUtils().SET_REP_FIRST_FIELD(prod_fm,"String");
				action.getRI_CLOSING_BEAN().setUI_M_PROD_FM(prod_fm);
				action.getCOMP_UI_M_PROD_FM().setSubmittedValue(prod_fm);
    		}
    	}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
    
    public void prod_to_when_validate_item(RI_CLOSING_ACTION action){
    	Connection connection = null;
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet resultSet = null;
    	
    	String prod_to_code =   action.getRI_CLOSING_BEAN().getUI_M_PROD_TO();
    	String prod_fm_code =   action.getRI_CLOSING_BEAN().getUI_M_PROD_FM();
    	try{
    		connection = CommonUtils.getConnection();
    		String query = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
    		Object[] values = {prod_to_code};
    		if(prod_to_code != null && !prod_to_code.trim().equals("")){
    			resultSet = handler.executeSelectStatement(query, connection, values);
    			if(resultSet.next()){
    				action.getRI_CLOSING_BEAN().setUI_M_PROD_TO_DESC(resultSet.getString(1));
    				action.getCOMP_UI_M_PROD_TO_DESC().setSubmittedValue(resultSet.getString(1));
    			}
    			action.getCOMP_UI_M_PROD_TO().setSubmittedValue(prod_to_code);
    		}else{
    			prod_to_code = (String) action.getCOMP_UI_M_PROD_TO().getSubmittedValue();
    			prod_to_code = (String) new CommonUtils().SET_REP_SECOND_FIELD(prod_fm_code, prod_to_code,"String");
    			action.getCOMP_UI_M_PROD_TO().setSubmittedValue(prod_to_code);
    			action.getRI_CLOSING_BEAN().setUI_M_PROD_TO(prod_to_code);
    		}
    	}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
    }
    
    
}
