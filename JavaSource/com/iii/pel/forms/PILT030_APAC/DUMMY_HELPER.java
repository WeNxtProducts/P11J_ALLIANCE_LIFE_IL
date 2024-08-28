package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {
	
	public void whenCreateRecord(){
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		dummyAction.getDUMMY_BEAN().setUI_M_AG_PROCESS_FM_DT(Calendar.getInstance().getTime());
		dummyAction.getDUMMY_BEAN().setUI_M_AG_PROCESS_TO_DT(Calendar.getInstance().getTime());
		dummyAction.getDUMMY_BEAN().setUI_M_UW_PROCESS_FM_DT(Calendar.getInstance().getTime());
		dummyAction.getDUMMY_BEAN().setUI_M_UW_PROCESS_TO_DT(Calendar.getInstance().getTime());
		dummyAction.getDUMMY_BEAN().setUI_M_PS_PROCESS_FM_DT(Calendar.getInstance().getTime());
		dummyAction.getDUMMY_BEAN().setUI_M_PS_PROCESS_TO_DT(Calendar.getInstance().getTime());
		dummyAction.getDUMMY_BEAN().setUI_M_CL_PROCESS_FM_DT(Calendar.getInstance().getTime());
		dummyAction.getDUMMY_BEAN().setUI_M_CL_PROCESS_TO_DT(Calendar.getInstance().getTime());
	}
	
	public void whenNewBlockInstance(){
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		String M_PAH_TYPE = dummyAction.getDUMMY_BEAN().getUI_M_PAH_TYPE();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("PAYVOU_TYPE", M_PAH_TYPE);
		try
        {
//            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("BP.B_PROCESSING_MSG",VISIBLE,PROPERTY_FALSE);
//            HIDE_VIEW.HIDE_VIEW("MORE_INFO");
            if((M_PAH_TYPE==null?"X":M_PAH_TYPE).equals("AG"))
            {
                /*GO_ITEM.GO_ITEM("DUMMY.M_AG_AGENT_FM_CODE");
                SHOW_VIEW.SHOW_VIEW("PAYVOU_AG");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_UW");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_PS");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_CL");*/
            }
            else if((M_PAH_TYPE==null?"X":M_PAH_TYPE).startsWith("UW"))
            {
                /*GO_ITEM.GO_ITEM("DUMMY.M_UW_STATUS_FM_CODE");
                SHOW_VIEW.SHOW_VIEW("PAYVOU_UW");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_AG");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_PS");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_CL");*/
            }
            else if((M_PAH_TYPE==null?"X":M_PAH_TYPE).equals("CL"))
            {
                /*GO_ITEM.GO_ITEM("DUMMY.M_CL_CLAIM_FM_NO");
                SHOW_VIEW.SHOW_VIEW("PAYVOU_CL");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_UW");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_PS");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_AG");*/
            }
            else if((M_PAH_TYPE==null?"X":M_PAH_TYPE).equals("PS"))
            {
                /*GO_ITEM.GO_ITEM("DUMMY.M_PS_POLICY_FM_NO");
                SHOW_VIEW.SHOW_VIEW("PAYVOU_PS");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_UW");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_AG");
                HIDE_VIEW.HIDE_VIEW("PAYVOU_CL");*/
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
	}
	
	public void processButton() throws ValidatorException {
		try
		{
	        String M_REF_NO_FM=null;
	        String M_REF_NO_TO=null;
	        String  /** METADATA NOT FOUND *********/ M_CLAIM_NO_FM=null;
	        String  /** METADATA NOT FOUND *********/ M_CLAIM_NO_TO=null;
	        String  /** METADATA NOT FOUND *********/ M_CUST_FM=null;
	        String  /** METADATA NOT FOUND *********/ M_CUST_TO=null;
	        String M_STATUS_FM=null;
	        String M_STATUS_TO=null;
	        Date M_FM_DATE=null;
	        Date M_TO_DATE=null;
	        String  /** METADATA NOT FOUND *********/ M_PAH_TYPE=null;
	        String M_DUMMY_ITEM=null;
	        
	        DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
	        BP_ACTION bpAction = PILT030_APAC_ACTION_INSTANCE.getBpActionInstance();
	        DUMMY dummyBean = dummyAction.getDUMMY_BEAN();
	        M_PAH_TYPE = dummyBean.getUI_M_PAH_TYPE();
	        System.out.println("M_PAH_TYPE:::::::::::::::"+M_PAH_TYPE);
	        Double M_PAH_SYS_ID = dummyBean.getUI_M_PAH_SYS_ID();
//	        SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("BP.B_PROCESSING_MSG",VISIBLE,PROPERTY_TRUE);
	        if((M_PAH_TYPE==null?"X":M_PAH_TYPE).equals("AG"))
	        {
	            M_REF_NO_FM="0";
	            M_REF_NO_TO="ZZZZZZZZZZZZ";
	            M_CLAIM_NO_FM="0";
	            M_CLAIM_NO_TO="ZZZZZZZZZZZZ";
	            M_CUST_FM=dummyBean.getUI_M_AG_AGENT_FM_CODE();
	            M_CUST_TO=dummyBean.getUI_M_AG_AGENT_TO_CODE();
	            M_STATUS_FM="0";
	            M_STATUS_TO="ZZZZZZZZZZZZ";
	            M_FM_DATE=dummyBean.getUI_M_AG_PROCESS_FM_DT();
	            M_TO_DATE=dummyBean.getUI_M_AG_PROCESS_TO_DT();
	            M_DUMMY_ITEM="DUMMY.M_AG_AGENT_FM_CODE";
	        }
	        else if((M_PAH_TYPE==null?"X":M_PAH_TYPE).startsWith("UW"))
	        {
	            M_REF_NO_FM=dummyBean.getUI_M_UW_PROPOSAL_FM_NO();
	            M_REF_NO_TO=dummyBean.getUI_M_UW_PROPOSAL_TO_NO();
	            M_CLAIM_NO_FM="0";
	            M_CLAIM_NO_TO="ZZZZZZZZZZZZ";
	            M_CUST_FM="0";
	            M_CUST_TO="ZZZZZZZZZZZZ";
	            M_STATUS_FM=dummyBean.getUI_M_UW_STATUS_FM_CODE();
	            M_STATUS_TO=dummyBean.getUI_M_UW_STATUS_TO_CODE();
	            M_FM_DATE=dummyBean.getUI_M_UW_PROCESS_FM_DT();
	            M_TO_DATE=dummyBean.getUI_M_UW_PROCESS_TO_DT();
	            M_DUMMY_ITEM="DUMMY.M_UW_PROPOSAL_FM_NO";
	        }
	        else if((M_PAH_TYPE==null?"X":M_PAH_TYPE).equals("CL"))
	        {
	            M_REF_NO_FM=dummyBean.getUI_M_CL_POLICY_FM_NO();
	            M_REF_NO_TO=dummyBean.getUI_M_CL_POLICY_TO_NO();
	            M_CLAIM_NO_FM=dummyBean.getUI_M_CL_CLAIM_FM_NO();
	            M_CLAIM_NO_TO=dummyBean.getUI_M_CL_CLAIM_TO_NO();
	            M_CUST_FM="0";
	            M_CUST_TO="ZZZZZZZZZZZZ";
	            M_STATUS_FM="0";
	            M_STATUS_TO="ZZZZZZZZZZZZ";
	            M_FM_DATE=dummyBean.getUI_M_CL_PROCESS_FM_DT();
	            M_TO_DATE=dummyBean.getUI_M_CL_PROCESS_TO_DT();
	            M_DUMMY_ITEM="DUMMY.M_CL_POLICY_FM_NO";
	        }
	        else if((M_PAH_TYPE==null?"X":M_PAH_TYPE).equals("PS"))
	        {
	            M_REF_NO_FM=dummyBean.getUI_M_PS_POLICY_FM_NO();
	            M_REF_NO_TO=dummyBean.getUI_M_PS_POLICY_TO_NO();
	            M_CLAIM_NO_FM="0";
	            M_CLAIM_NO_TO="ZZZZZZZZZZZZ";
	            M_CUST_FM="0";
	            M_CUST_TO="ZZZZZZZZZZZZ";
	            M_STATUS_FM="0";
	            M_STATUS_TO="ZZZZZZZZZZZZ";
	            M_FM_DATE=dummyBean.getUI_M_PS_PROCESS_FM_DT();
	            M_TO_DATE=dummyBean.getUI_M_PS_PROCESS_TO_DT();
	            M_DUMMY_ITEM="DUMMY.M_PS_POLICY_FM_NO";
	        }
	        try{
	        	
	        	System.out.println("inside process button....... ");
	        	System.out.println("M_REF_NO_FM.."+M_REF_NO_FM);
	        	System.out.println("M_REF_NO_TO..."+M_REF_NO_TO);
	           	System.out.println("M_CLAIM_NO_FM..."+M_CLAIM_NO_FM);
	        	System.out.println("M_CLAIM_NO_TO..."+M_CLAIM_NO_TO);
	        	System.out.println("M_CUST_FM..."+M_CUST_FM);
	        	System.out.println("M_STATUS_FM..."+M_STATUS_FM);
	        	System.out.println("M_STATUS_TO..."+M_STATUS_TO);
	        	System.out.println("M_FM_DATE..."+M_FM_DATE);
	        	System.out.println("M_TO_DATE..."+M_TO_DATE);
	        	System.out.println("M_DUMMY_ITEM..."+M_DUMMY_ITEM);
	        	M_PAH_SYS_ID = new PILT030_APAC_PROCEDURE().p9ilpk_payment_voucher_ins_payvou_hdr_drcr_dtl(M_REF_NO_FM,
											            		M_REF_NO_TO,
											            		M_CLAIM_NO_FM,
											            		M_CLAIM_NO_TO,
											            		M_CUST_FM,
											            		M_CUST_TO,
											            		M_STATUS_FM,
											            		M_STATUS_TO,
											            		M_FM_DATE,
											            		M_TO_DATE,
											            		M_PAH_TYPE,
											            		M_PAH_SYS_ID);
	        }
	        catch(Exception se){
	        	se.printStackTrace();
	        	throw new ValidatorException(new FacesMessage(se.getMessage()));
	        }
	        PILT030_APAC_ACTION_INSTANCE.getSessionMap().put("GLOBAL.M_PAH_SYS_ID", dummyBean.getUI_M_PAH_SYS_ID());
	        if(M_PAH_SYS_ID== null)
	        {
	        	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"NO RECORDS ARE FOUND ..... !"}));
	        }
	        else
	        {
//	        	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"PROCESSED RECORDS SUCCESSFULLY"}));
//	            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_SYS_ID = "+:DUMMY.M_PAH_SYS_ID+" AND  PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
//	            EXECUTE_QUERY.EXECUTE_QUERY();
	        	PT_IL_PAYVOU_HDR_HELPER helper = new PT_IL_PAYVOU_HDR_HELPER();
	        	helper.executeQuery();
	        }
	        bpAction.getBP_BEAN().setB_PROCESSING_MSG(" ");
	    }catch(Exception e)
	    {
	       throw new ValidatorException(new FacesMessage(e.getMessage()));
	    }
    }
	
	public String approveButton() throws ValidatorException {
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		PT_IL_PAYVOU_HDR_ACTION headerAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		PT_IL_PAYVOU_AMT_DTL_ACTION amtDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouAmtDtlActionInstance();
		PT_IL_PAYVOU_PAY_DTL_ACTION payDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
		BP_ACTION bpAction = PILT030_APAC_ACTION_INSTANCE.getBpActionInstance();
		Map<String, Object> sessionMap = PILT030_APAC_ACTION_INSTANCE.getSessionMap();
		CRUDHandler handler = new CRUDHandler();
		Integer PAH_SYS_ID = headerAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
		String PAPD_PAYEE_NAME = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_BEAN().getPAPD_PAYEE_NAME();
		String PAPD_PAY_MODE = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_BEAN().getPAPD_PAY_MODE();
		String PAPD_PAY_APPRV_CODE = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_BEAN().getPAPD_PAY_APPRV_CODE();
		String PAPD_STATE_CODE = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_BEAN().getPAPD_STATE_CODE();
		String PAPD_OFF_AREA_CODE = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_BEAN().getPAPD_OFF_AREA_CODE();
		String PAPD_PAYEE_ADDR1 = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_BEAN().getPAPD_PAYEE_ADDR1();
		Integer PAD_SYS_ID = amtDtlAction.getPT_IL_PAYVOU_AMT_DTL_BEAN().getPAD_SYS_ID();
		try
        {
            String  /** METADATA NOT FOUND *********/ M_PAPD_PAYEE_NAME=null;
            String M_DUMMY=null;
            String  /** METADATA NOT FOUND *********/ M_PAH_APPRV_STATUS=null;
            Double  /** METADATA NOT FOUND *********/ M_PC_VALUE=null;
            String  /** METADATA NOT FOUND *********/ M_APPL_YN=null;
            String sql_C4="SELECT    PC_VALUE,    PC_RI_APPL_YN " +
            		"FROM  PM_CODES  " +
            		"WHERE  PC_CODE  = ?  " +
            		"AND PC_TYPE  = ? ";
            String sql_C1="SELECT 'X',PAPD_PAYEE_NAME " +
            		"FROM  PT_IL_PAYVOU_PAY_DTL  " +
            		"WHERE  PAPD_PAH_SYS_ID  = ?  " +
            		"AND PAPD_PAD_SYS_ID  = ? ";
            String sql_C2="SELECT 'X' FROM  PM_IL_APPR_SETUP_DET  " +
            		"WHERE  ASD_USER_ID  = ?  " +
            		"AND ASD_CODE  = 'PAY_POST_MAT'  " +
            		"AND ASD_CHAR_VALUE  = 'Y' ";
            String sql_C3="SELECT PAH_APPRV_STATUS FROM  PT_IL_PAYVOU_HDR  WHERE  PAH_SYS_ID  = :PT_IL_PAYVOU_HDR.PAH_SYS_ID ";
            String sql_C5="SELECT    CUST_PYMT_TYPE,    CUST_BANK_CODE " +
            		"FROM  PM_CUSTOMER,   PT_IL_PAYVOU_AMT_DTL  " +
            		"WHERE  CUST_CODE  = PAD_CUST_CODE  " +
            		"AND PAD_PAH_SYS_ID  = ? ";
            String  /** METADATA NOT FOUND *********/ M_CUST_PYMT_TYPE=null;
            String  /** METADATA NOT FOUND *********/ M_ACC_DIVN_CODE=null;
            String  /** METADATA NOT FOUND *********/ M_ACC_DEPT_CODE=null;
            Double  /** METADATA NOT FOUND *********/ M_BAS_MAX_PAYEE_CHAR=null;
            String  /** METADATA NOT FOUND *********/ M_CUST_BANK_CODE=null;
            String  /** METADATA NOT FOUND *********/ M_CUST_BANK_CODE1=null;
            String  /** METADATA NOT FOUND *********/ M_PC_VALUE_1=null;
            
            ResultSet vembu_C1=null;
            ResultSet vembu_C2=null;
            ResultSet vembu_C3=null;
            ResultSet vembu_C4=null;
            ResultSet vembu_C5=null;
            ResultSet vembu_C6=null;
            String sql_C7="SELECT PC_VALUE FROM  PM_CODES  " +
            		"WHERE  PC_TYPE  = ?  " +
            		"AND PC_CODE  = ? ";
            ResultSet vembu_C7=null;
            String defaultValues = (String)sessionMap.get("GLOBAL.M_DFLT_VALUES");
            if(defaultValues!=null && defaultValues.length()>4)
            	M_ACC_DIVN_CODE=defaultValues.substring(4, 6);
            M_ACC_DEPT_CODE=dummyAction.getDUMMY_BEAN().getUI_M_PAH_TYPE();
            vembu_C5 = handler.executeSelectStatement(sql_C5, connection, new Object[]{PAH_SYS_ID});
            if(vembu_C5.next())
            {
                M_CUST_PYMT_TYPE=vembu_C5.getString(1);
                M_CUST_BANK_CODE=vembu_C5.getString(2);
            }
            CommonUtils.closeCursor(vembu_C5);
            vembu_C7 = handler.executeSelectStatement(sql_C7, connection, new Object[]{"IL_CPAY_MODE",M_CUST_PYMT_TYPE});
            if(vembu_C7.next())
            {
                M_PC_VALUE_1=vembu_C7.getString(1);
            }
            CommonUtils.closeCursor(vembu_C7);
            if((M_PC_VALUE_1==null?"":M_PC_VALUE_1).equals("4"))
            {
                M_CUST_BANK_CODE1=M_CUST_BANK_CODE;
            }
            else if((M_PC_VALUE_1==null?"":M_PC_VALUE_1).equals("2"))
            {
                M_CUST_BANK_CODE1=null;
            }
            else
            {
                M_CUST_BANK_CODE1=null;
            }
            String sql_C6="SELECT BAS_MAX_PAYEE_CHAR " +
		    		"FROM  PM_IL_BANK_ACCOUNT_SETUP  " +
		    		"WHERE  '"+M_ACC_DIVN_CODE+"'  BETWEEN NVL(BAS_DIVN_FM_CODE, '0')  " +
		    		"AND  NVL(BAS_DIVN_TO_CODE, 'ZZZZZZZZZZZZ')  " +
		    		"AND '"+M_ACC_DEPT_CODE+"'  BETWEEN NVL(BAS_DEPT_FM_CODE, '0')  " +
		    		"AND  NVL(BAS_DEPT_TO_CODE, 'ZZZZZZZZZZZZ')  " +
		    		"AND BAS_TXN_TYPE  = 'P'  " +
		    		"AND BAS_SETUP_FOR  = ?  " +
		    		"AND NVL(BAS_FRZ_FLAG, 'N')  = 'N'  " +
		    		"AND NVL(BAS_ASSURED_TYPE, 'R')  = 'R'  " +
		    		"AND NVL(BAS_OUR_BANK_CODE, 'X')  = NVL(?, NVL(BAS_OUR_BANK_CODE, 'X')) ";
            System.out.println(sql_C6);
            vembu_C6 = handler.executeSelectStatement(sql_C6, connection, new Object[]{M_CUST_PYMT_TYPE,M_CUST_BANK_CODE1});
            if(vembu_C6.next())
            {
                M_BAS_MAX_PAYEE_CHAR=vembu_C6.getDouble(1);
            }
            CommonUtils.closeCursor(vembu_C6);
            if(M_BAS_MAX_PAYEE_CHAR== null)
            {
//                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91972,:CTRL.M_LANG_CODE);
            	headerAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91972"));
            }
            if((PAPD_PAYEE_NAME==null?"":PAPD_PAYEE_NAME).length()>M_BAS_MAX_PAYEE_CHAR)
            {
//                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91971,:CTRL.M_LANG_CODE);
            	headerAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91971"));
            }
            vembu_C4 = handler.executeSelectStatement(sql_C4, connection, new Object[]{PAPD_PAY_MODE, "IL_CPAY_MODE"});
            if(vembu_C4.next())
            {
                M_PC_VALUE=vembu_C4.getDouble(1);
                M_APPL_YN=vembu_C4.getString(2);
            }
            CommonUtils.closeCursor(vembu_C4);
            if((M_PC_VALUE==null?0.0:M_PC_VALUE)==5.0)
            {
                if(PAPD_PAY_APPRV_CODE== null)
                {
//                    STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91550,:CTRL.M_LANG_CODE,"BANK REF NO");
                	headerAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91550", new Object[]{"BANK REF NO"}));
                }
            }
            if((M_PC_VALUE==null?0.0:M_PC_VALUE)==2.0)
            {
                if(M_APPL_YN=="Y")
                {
                    if(PAPD_PAY_APPRV_CODE== null)
                    {
//                        STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91550,:CTRL.M_LANG_CODE,"TT APPR CODE");
                    	headerAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91550", new Object[]{"TT APPR CODE"}));
                    }
                }
            }
            if(PAPD_STATE_CODE== null)
            {
//                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91550,:CTRL.M_LANG_CODE,"STATE CODE");
            	headerAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91550", new Object[]{"STATE CODE"}));
            }
            else if(PAPD_OFF_AREA_CODE== null)
            {
//                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91550,:CTRL.M_LANG_CODE,"POSTAL CODE");
            	headerAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91550", new Object[]{"POSTAL CODE"}));
            }
            else if(PAPD_PAYEE_ADDR1== null)
            {
//                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91550,:CTRL.M_LANG_CODE,"ADDRESS1");
            	headerAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91550", new Object[]{"ADDRESS1"}));
            }
            /*if(:SYSTEM.FORM_STATUS=="CHANGED")
            {
                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
            }*/
            String userId = (String) sessionMap.get("GLOBAL.M_USER_ID");
            vembu_C2 = handler.executeSelectStatement(sql_C2, connection, new Object[]{userId});
            if(vembu_C2.next())
            {
                M_DUMMY=vembu_C2.getString(1);
            }
            CommonUtils.closeCursor(vembu_C2);
            if((M_DUMMY==null?"N":M_DUMMY).equals("N"))
            {
//                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91571,:GLOBAL.M_LANG_CODE);
            	headerAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91571"));
            }
            vembu_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{PAH_SYS_ID, PAD_SYS_ID});
            String M_TEMP = null;
            if(vembu_C1.next()){
            	M_TEMP = vembu_C1.getString(1);
            	M_PAPD_PAYEE_NAME=vembu_C1.getString(2);
            }
            if(M_TEMP==null)
            	return null;
            if(M_PAPD_PAYEE_NAME== null)
            {
//                    STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91543,:GLOBAL.M_LANG_CODE);
                	headerAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91543"));
            }
            CommonUtils.closeCursor(vembu_C1);
            bpAction.getBP_BEAN().setB_PROCESSING_MSG("APPROVAL  PROCESSING  WAIT ... ");
            try{
                new PILT030_APAC_PROCEDURE().p9ilpk_payment_voucher_payvou_approval(PAH_SYS_ID+"");
            }
            catch(Exception se){
            	se.printStackTrace();
            	throw new ValidatorException(new FacesMessage(se.getMessage()));
            }
            sessionMap.put("GLOBAL.M_PAH_SYS_ID", PAH_SYS_ID);
            dummyAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
            dummyAction.getCOMP_UI_M_BUT_FREEZE().setDisabled(true);
            dummyAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
            dummyAction.getCOMP_UI_M_BUT_UNFREEZE().setDisabled(true);
            dummyAction.getCOMP_UI_M_BUT_REPORT().setDisabled(false);
            bpAction.getBP_BEAN().setB_PROCESSING_MSG(" ");
//            GO_ITEM.GO_ITEM("PT_IL_PAYVOU_HDR.PAH_FM_DT");
//            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_SYS_ID = "+:PT_IL_PAYVOU_HDR.PAH_SYS_ID+" AND  PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
//            EXECUTE_QUERY.EXECUTE_QUERY();
            new PT_IL_PAYVOU_HDR_HELPER().executeQuery();
//            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
//            STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91071,:CTRL.M_LANG_CODE);
            headerAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91071"));
            headerAction.getErrorMap().put("description", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91071"));
           // headerAction.setWarningMessages(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91071"));
            bpAction.getBP_BEAN().setB_PROCESSING_MSG("POSTING IS GOING   WAIT ... ");
            Integer M_PAH_SYS_ID = headerAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
//            CALL_FORM.CALL_FORM("PILP010",NO_HIDE,NO_REPLACE);
            if(M_PAH_SYS_ID!=null){
            	headerAction.setOnLoadFlag(false);
            	sessionMap.put("GLOBAL.M_PAH_SYS_ID", M_PAH_SYS_ID);
            	sessionMap.put("CALLING_FORM", "PILT030_APAC_1");
            	return "PILP010";
            }
            postApproval();
        }catch (Exception e) {
        	headerAction.getErrorMap().put("current", e.getMessage());
            headerAction.setErrorMessages(e.getMessage());
		}
        return null;
	}
	
	public void postApproval() throws ValidatorException {
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		PT_IL_PAYVOU_HDR_ACTION headerAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		BP_ACTION bpAction = PILT030_APAC_ACTION_INSTANCE.getBpActionInstance();
		new PT_IL_PAYVOU_HDR_HELPER().executeQuery();
		dummyAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
        dummyAction.getCOMP_UI_M_BUT_FREEZE().setDisabled(true);
        dummyAction.getCOMP_UI_M_BUT_UNFREEZE().setDisabled(true);
        bpAction.getBP_BEAN().setB_PROCESSING_MSG(" ");
        headerAction.getWarningMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"POSTING DONE SUCCESSFULLY"}));
        headerAction.setWarningMessages(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"POSTING DONE SUCCESSFULLY"}));
        try{
            new PILT030_APAC_PROCEDURE().p9ilpk_payment_voucher_payvou_housecheque(headerAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID()+"");
        }
        catch(Exception se){
        	ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(),"PT_IL_PAYVOU_HDR", headerAction.getErrorMap(), headerAction.getWarningMap());
        }
        headerAction.getWarningMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"MATCHING DONE SUCCESSFULLY"}));
        headerAction.setWarningMessages(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"MATCHING DONE SUCCESSFULLY"}));
	}
	
	public void freezeButton() throws ValidatorException {
		BP_ACTION bpAction = PILT030_APAC_ACTION_INSTANCE.getBpActionInstance();
		PT_IL_PAYVOU_HDR_ACTION headerAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		Map<String, Object> sessionMap = PILT030_APAC_ACTION_INSTANCE.getSessionMap();
		Integer PAH_SYS_ID = headerAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
		try
        {
            /*if(:SYSTEM.FORM_STATUS=="CHANGED")
            {
                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
                throw new FORM_TRIGGER_FAILURE();
            }*/
			if(PAH_SYS_ID== null)
	        {
	        	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"NO RECORDS ARE FOUND ..... !"}));
	        }
            bpAction.getBP_BEAN().setB_PROCESSING_MSG("FREEZING RECORDS WAIT ... ");
//            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("BP.B_PROCESSING_MSG",VISIBLE,PROPERTY_TRUE);
            sessionMap.put("GLOBAL.M_PAH_SYS_ID", PAH_SYS_ID);
            try{
                new PILT030_APAC_PROCEDURE().p9ilpk_payment_voucher_ins_payvou_amt_dtl(PAH_SYS_ID+"");
            }
            catch(Exception se){
            	se.printStackTrace();
            }
//            GO_ITEM.GO_ITEM("PT_IL_PAYVOU_HDR.PAH_FM_DT");
//            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_SYS_ID = "+:PT_IL_PAYVOU_HDR.PAH_SYS_ID+" AND  PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
//            EXECUTE_QUERY.EXECUTE_QUERY();
            new PT_IL_PAYVOU_HDR_HELPER().executeQuery();
//            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
            bpAction.getBP_BEAN().setB_PROCESSING_MSG("FREEZING IS COMPLETED");
//            STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:GLOBAL.M_LANG_CODE,"FREEZED RECORDS SUCCESSFULLY");
            headerAction.getWarningMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"FREEZED RECORDS SUCCESSFULLY"}));
            bpAction.getBP_BEAN().setB_PROCESSING_MSG(" ");
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void unFreezeButton() throws ValidatorException {
		BP_ACTION bpAction = PILT030_APAC_ACTION_INSTANCE.getBpActionInstance();
		PT_IL_PAYVOU_HDR_ACTION headerAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		Map<String, Object> sessionMap = PILT030_APAC_ACTION_INSTANCE.getSessionMap();
		Integer PAH_SYS_ID = headerAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
		CRUDHandler handler = new CRUDHandler();
		ControlBean ctrlBean  = CommonUtils.getControlBean();
		try
        {
            /*if(:SYSTEM.FORM_STATUS=="CHANGED")
            {
                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
                throw new FORM_TRIGGER_FAILURE();
            }*/
			if(PAH_SYS_ID== null)
	        {
	        	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"NO RECORDS ARE FOUND ..... !"}));
	        }
            bpAction.getBP_BEAN().setB_PROCESSING_MSG("UNFREEZING RECORDS WAIT ... ");
//            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("BP.B_PROCESSING_MSG",VISIBLE,PROPERTY_TRUE);
            sessionMap.put("GLOBAL.M_PAH_SYS_ID", PAH_SYS_ID);
            String sql_vembu1="UPDATE   PT_IL_PAYVOU_HDR    " +
            		"SET PAH_FREEZE_FLAG = 'N'  WHERE  PAH_SYS_ID  = ? ";
            int result = handler.executeUpdateStatement(sql_vembu1, connection, new Object[]{PAH_SYS_ID});
            ctrlBean.setM_COMM_DEL("C");
            connection.commit();
            ctrlBean.setM_COMM_DEL(null);
//            GO_ITEM.GO_ITEM("PT_IL_PAYVOU_HDR.PAH_FM_DT");
//            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_SYS_ID = "+:PT_IL_PAYVOU_HDR.PAH_SYS_ID+" AND  PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
//            EXECUTE_QUERY.EXECUTE_QUERY();
            new PT_IL_PAYVOU_HDR_HELPER().executeQuery();
//            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
//            STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:GLOBAL.M_LANG_CODE,"UNFREEZED RECORDS SUCCESSFULLY");
            headerAction.getWarningMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"UNFREEZED RECORDS SUCCESSFULLY"}));
            bpAction.getBP_BEAN().setB_PROCESSING_MSG("UNFREEZING IS COMPLETED");
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void matchButton() throws ValidatorException {
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		PT_IL_PAYVOU_HDR_ACTION headerAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		PT_IL_PAYVOU_HDR_HELPER hdrHelper = new PT_IL_PAYVOU_HDR_HELPER();
		Double M_PAH_SYS_ID = dummyAction.getDUMMY_BEAN().getUI_M_PAH_SYS_ID();
		try
        {
            /*if(:SYSTEM.FORM_STATUS=="CHANGED")
            {
                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
                throw new FORM_TRIGGER_FAILURE();
            }*/
			if(M_PAH_SYS_ID== null)
	        {
	        	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"NO RECORDS ARE FOUND ..... !"}));
	        }
            try{
            	new PILT030_APAC_PROCEDURE().p9ilpk_payment_voucher_payvou_housecheque(M_PAH_SYS_ID+"");
            }
            catch(Exception se){
                throw new ValidatorException(new FacesMessage(se.getMessage()));
            }
            /*GO_ITEM.GO_ITEM("PT_IL_PAYVOU_HDR.PAH_FM_DT");
            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_SYS_ID = "+:PT_IL_PAYVOU_HDR.PAH_SYS_ID+" AND  PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");*/
            hdrHelper.executeQuery();
            /*SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY_BUTTON.M_BUT_MATCH",ENABLED,PROPERTY_FALSE);
            SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY_BUTTON.M_BUT_UNMATCH",ENABLED,PROPERTY_TRUE);*/
//            STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:GLOBAL.M_LANG_CODE,);
            dummyAction.getCOMP_UI_M_BUT_MATCH().setDisabled(true);
            dummyAction.getCOMP_UI_M_BUT_UNMATCH().setDisabled(false);
            headerAction.getWarningMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"MATCHED RECORDS SUCCESSFULLY"}));
        }catch(Exception e)
        {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void unMatchButton() throws ValidatorException {
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		Map<String, Object> sessionMap = PILT030_APAC_ACTION_INSTANCE.getSessionMap();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		String PAH_CONTROL_NO = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_CONTROL_NO();
		Integer PAH_SYS_ID = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
		PT_IL_PAYVOU_HDR_HELPER hdrHelper = new PT_IL_PAYVOU_HDR_HELPER();
		try
        {
/*            if(:SYSTEM.FORM_STATUS=="CHANGED")
            {
                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
                throw new FORM_TRIGGER_FAILURE();
            }*/
			if(PAH_SYS_ID== null)
	        {
	        	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"NO RECORDS ARE FOUND ..... !"}));
	        }
			sessionMap.put("GLOBAL.P_PAH_CONTROL_NO", PAH_CONTROL_NO);
			sessionMap.put("GLOBAL.M_PAH_SYS_ID", PAH_SYS_ID);
            /*CALL_FORM.CALL_FORM("FT018_TISB",NO_HIDE,NO_REPLACE);
            GO_ITEM.GO_ITEM("PT_IL_PAYVOU_HDR.PAH_FM_DT");
            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_SYS_ID = "+:PT_IL_PAYVOU_HDR.PAH_SYS_ID+" AND  PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");*/
            hdrHelper.executeQuery();
//            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
            dummyAction.getCOMP_UI_M_BUT_MATCH().setDisabled(false);
            hdrAction.getWarningMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"UNMATCHED RECORDS SUCCESSFULLY"}));
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public String postButton() throws ValidatorException {
		BP_ACTION bpAction = PILT030_APAC_ACTION_INSTANCE.getBpActionInstance();
		Map<String, Object> sessionMap = PILT030_APAC_ACTION_INSTANCE.getSessionMap();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		Integer PAH_SYS_ID = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
		PT_IL_PAYVOU_HDR_HELPER helper = new PT_IL_PAYVOU_HDR_HELPER();
		try
        {
            /*if(:SYSTEM.FORM_STATUS=="CHANGED")
            {
                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
                throw new FORM_TRIGGER_FAILURE();
            }*/
			if(PAH_SYS_ID== null)
	        {
	        	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"NO RECORDS ARE FOUND ..... !"}));
	        }
			bpAction.getBP_BEAN().setB_PROCESSING_MSG("POSTING IS GOING   WAIT ... ");
			sessionMap.put("GLOBAL.M_PAH_SYS_ID", PAH_SYS_ID);
//            CALL_FORM.CALL_FORM("PILP010",NO_HIDE,NO_REPLACE);
			dummyAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
			dummyAction.getCOMP_UI_M_BUT_FREEZE().setDisabled(true);
			dummyAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
			dummyAction.getCOMP_UI_M_BUT_UNFREEZE().setDisabled(true);
			dummyAction.getCOMP_UI_M_BUT_MATCH().setDisabled(false);
            
            bpAction.getBP_BEAN().setB_PROCESSING_MSG(" ");
            if(PAH_SYS_ID!=null){
            	sessionMap.put("CALLING_FORM", "PILT030_APAC");
            	return "PILP010";
            }
            /*GO_ITEM.GO_ITEM("PT_IL_PAYVOU_HDR.PAH_FM_DT");
            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_SYS_ID = "+:PT_IL_PAYVOU_HDR.PAH_SYS_ID+" AND  PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");*/
            helper.executeQuery();
//            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
            hdrAction.getWarningMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"POSTING IS DONE SUCCESSFULLY"}));
        }catch(Exception e)
        {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
        return null;
	}
	
	public void okButton(){
		/*try
        {
            PARAMLIST P_PARAM_ID;
            String M_REP_NAME=null;
            if(ID_NULL.ID_NULL(P_PARAM_ID))
            {
                P_PARAM_ID=CREATE_PARAMETER_LIST.CREATE_PARAMETER_LIST("DUMMY");
                if(ID_NULL.ID_NULL(P_PARAM_ID))
                {
                    DISP_ALERT.DISP_ALERT("ERROR WHILE CREATING PARAMETER LIST");
                    throw new FORM_TRIGGER_FAILURE();
                }
            }
            else
            {
                DESTROY_PARAMETER_LIST.DESTROY_PARAMETER_LIST(P_PARAM_ID);
                P_PARAM_ID=CREATE_PARAMETER_LIST.CREATE_PARAMETER_LIST("DUMMY");
                if(ID_NULL.ID_NULL(P_PARAM_ID))
                {
                    DISP_ALERT.DISP_ALERT("ERROR WHILE CREATING PARAMETER LIST");
                    throw new FORM_TRIGGER_FAILURE();
                }
            }
            if(:DUMMY_BUTTON.M_REPORT_NAME=="PVF")
            {
                M_REP_NAME=:GLOBAL.M_PARA_12;
            }
            else if(:DUMMY_BUTTON.M_REPORT_NAME=="PVA")
            {
                M_REP_NAME=:GLOBAL.M_PARA_13;
            }
            else if(:DUMMY_BUTTON.M_REPORT_NAME=="PVS")
            {
                M_REP_NAME=:GLOBAL.M_PARA_14;
            }
            else if(:DUMMY_BUTTON.M_REPORT_NAME=="PI")
            {
                M_REP_NAME=:GLOBAL.M_PARA_15;
            }
            else if(:DUMMY_BUTTON.M_REPORT_NAME=="PC")
            {
                M_REP_NAME=:GLOBAL.M_PARA_16;
            }
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_FM_TXN_CODE",TEXT_PARAMETER,"0");
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_TO_TXN_CODE",TEXT_PARAMETER,"ZZZZZZZZZZZ");
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_FM_DOC_NO",TEXT_PARAMETER,0);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_TO_DOC_NO",TEXT_PARAMETER,999999);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_FM_DOC_DT",TEXT_PARAMETER,"01/JAN/2000");
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_TO_DOC_DT",TEXT_PARAMETER,ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MON/RRRR"));
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_FM_DEPT_CODE",TEXT_PARAMETER,:PT_IL_PAYVOU_HDR.PAH_TYPE);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_TO_DEPT_CODE",TEXT_PARAMETER,:PT_IL_PAYVOU_HDR.PAH_TYPE);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_FM_CONTROL_NO",TEXT_PARAMETER,:PT_IL_PAYVOU_HDR.PAH_CONTROL_NO);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_TO_CONTROL_NO",TEXT_PARAMETER,:PT_IL_PAYVOU_HDR.PAH_CONTROL_NO);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_FM_CR_UID",TEXT_PARAMETER,:PT_IL_PAYVOU_HDR.PAH_CR_UID);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_TO_CR_UID",TEXT_PARAMETER,:PT_IL_PAYVOU_HDR.PAH_CR_UID);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_FM_LC_AMT",TEXT_PARAMETER,0);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_TO_LC_AMT",TEXT_PARAMETER,9999999999);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"P_TITLE_14",TEXT_PARAMETER,M_REP_NAME);
            ADD_PARAMETER.ADD_PARAMETER(P_PARAM_ID,"PARAMFORM",TEXT_PARAMETER,"NO");
            RUN_PRODUCT.RUN_PRODUCT(REPORTS,M_REP_NAME,SYNCHRONOUS,RUNTIME,FILESYSTEM,P_PARAM_ID,null);
            P_PARAM_ID=GET_PARAMETER_LIST.GET_PARAMETER_LIST("DUMMY");
            if(!(ID_NULL.ID_NULL(P_PARAM_ID)))
            {
                DESTROY_PARAMETER_LIST.DESTROY_PARAMETER_LIST(P_PARAM_ID);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }*/
	}
	
	public void preForm() throws ValidatorException {
		Map<String, Object> sessionMap = PILT030_APAC_ACTION_INSTANCE.getSessionMap();
		String callingForm = (String) sessionMap.get("CALLING_FORM");
		if(callingForm==null || callingForm.equals("PILT030_APAC_SEARCH")){
			sessionMap.put("GLOBAL.M_FAILURE","FALSE");
			sessionMap.put("GLOBAL.M_NAME", "PILT030_APAC");
			sessionMap.put("GLOBAL.M_DFLT_VALUES", "");
			System.out.println("GLOBAL.M_FOR_LANG_CODE******"+sessionMap.get("GLOBAL.M_FOR_LANG_CODE"));
		}
		String M_PARAM_1 = (String) sessionMap.get("GLOBAL.M_PARAM_1");
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		dummyAction.getDUMMY_BEAN().setUI_M_PAH_TYPE(M_PARAM_1);
	}
	
	public  void WHEN_NEW_FORM_INSTANCE() throws ValidatorException {
		Map<String, Object> sessionMap = PILT030_APAC_ACTION_INSTANCE.getSessionMap();
		String callingForm = (String) sessionMap.get("CALLING_FORM");
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		if((callingForm==null?"":callingForm).equals("PILT007")){
			dummyAction.getDUMMY_BEAN().setUI_M_PAH_TYPE("CL");
			/*dummyAction.getCOMP_UI_M_PS_POLICY_FM_NO().setSubmittedValue(sessionMap.get("GLOBAL.M_POL_NO"));
			dummyAction.getCOMP_UI_M_PS_POLICY_TO_NO().setSubmittedValue(sessionMap.get("GLOBAL.M_POL_NO"));*/
			dummyAction.getDUMMY_BEAN().setUI_M_CL_CLAIM_FM_NO((String)sessionMap.get("GLOBAL.M_CLAIM_NO"));
			dummyAction.getDUMMY_BEAN().setUI_M_CL_CLAIM_TO_NO((String)sessionMap.get("GLOBAL.M_CLAIM_NO"));
			dummyAction.getDUMMY_BEAN().setUI_M_CL_POLICY_FM_NO((String)sessionMap.get("GLOBAL.M_POL_NO"));
			dummyAction.getDUMMY_BEAN().setUI_M_CL_POLICY_TO_NO((String)sessionMap.get("GLOBAL.M_POL_NO"));
			dummyAction.getDUMMY_BEAN().setUI_M_AG_PROCESS_FM_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_AG_PROCESS_TO_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_UW_PROCESS_FM_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_UW_PROCESS_TO_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_PS_PROCESS_FM_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_PS_PROCESS_TO_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_CL_PROCESS_FM_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_CL_PROCESS_TO_DT(Calendar.getInstance().getTime());
			new PILT030_APAC_PROCEDURE().L_PRO_FRZ();
		}else if((callingForm==null?"":callingForm).equals("PILT030_APAC_SEARCH")){
			executeQueryFromSearch();
		}else{
			dummyAction.getDUMMY_BEAN().setUI_M_AG_PROCESS_FM_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_AG_PROCESS_TO_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_UW_PROCESS_FM_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_UW_PROCESS_TO_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_PS_PROCESS_FM_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_PS_PROCESS_TO_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_CL_PROCESS_FM_DT(Calendar.getInstance().getTime());
			dummyAction.getDUMMY_BEAN().setUI_M_CL_PROCESS_TO_DT(Calendar.getInstance().getTime());
		}
	}
	
	public void executeQueryFromSearch() throws ValidatorException {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String rowId = request.getParameter("rowId");
		System.out.println("executeQueryFromSearch::::::"+rowId);
		String query = "SELECT PT_IL_PAYVOU_HDR.ROWID, PAH_SYS_ID, PAH_CONTROL_NO,PAH_REF_NO,PAH_PRO_DT, PAH_APPRV_DT " +
							"FROM PT_IL_PAYVOU_HDR " +
							"WHERE PT_IL_PAYVOU_HDR.ROWID=? ";
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{rowId});
			while(rst.next()){
				dummyAction.getDUMMY_BEAN().setUI_M_PAH_SYS_ID(rst.getDouble("PAH_SYS_ID"));
				String M_PAH_REF_NO = rst.getString("PAH_REF_NO");
				if(M_PAH_REF_NO.equals("0")){
					dummyAction.getDUMMY_BEAN().setUI_M_CL_CLAIM_FM_NO("0");
					dummyAction.getDUMMY_BEAN().setUI_M_CL_CLAIM_TO_NO("zzzzzzzzzzzzzzzzzzzzzz");
				}else{
					dummyAction.getDUMMY_BEAN().setUI_M_CL_CLAIM_FM_NO(M_PAH_REF_NO);
					dummyAction.getDUMMY_BEAN().setUI_M_CL_CLAIM_TO_NO(M_PAH_REF_NO);
				}
				String policyNo = getClaimPolicyNumber(M_PAH_REF_NO);
				if(policyNo!=null && !policyNo.trim().isEmpty()){
					dummyAction.getDUMMY_BEAN().setUI_M_CL_POLICY_FM_NO(policyNo);
					dummyAction.getDUMMY_BEAN().setUI_M_CL_POLICY_TO_NO(policyNo);
				}else{
					dummyAction.getDUMMY_BEAN().setUI_M_CL_POLICY_FM_NO("0");
					dummyAction.getDUMMY_BEAN().setUI_M_CL_POLICY_TO_NO("zzzzzzzzzzzzzzzzzzzzzz");
				}
				dummyAction.getDUMMY_BEAN().setUI_M_AG_PROCESS_FM_DT(rst.getDate("PAH_PRO_DT"));
				dummyAction.getDUMMY_BEAN().setUI_M_AG_PROCESS_TO_DT(rst.getDate("PAH_PRO_DT"));
				dummyAction.getDUMMY_BEAN().setUI_M_UW_PROCESS_FM_DT(rst.getDate("PAH_PRO_DT"));
				dummyAction.getDUMMY_BEAN().setUI_M_UW_PROCESS_TO_DT(rst.getDate("PAH_PRO_DT"));
				dummyAction.getDUMMY_BEAN().setUI_M_PS_PROCESS_FM_DT(rst.getDate("PAH_PRO_DT"));
				dummyAction.getDUMMY_BEAN().setUI_M_PS_PROCESS_TO_DT(rst.getDate("PAH_PRO_DT"));
				dummyAction.getDUMMY_BEAN().setUI_M_CL_PROCESS_FM_DT(rst.getDate("PAH_PRO_DT"));
				dummyAction.getDUMMY_BEAN().setUI_M_CL_PROCESS_TO_DT(rst.getDate("PAH_PRO_DT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public String getClaimPolicyNumber(String M_PAH_REF_NO) throws ValidatorException {
		String sql_C2 = "SELECT CLAIM_POL_NO FROM PT_IL_CLAIM WHERE CLAIM_NO = ? ";
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst_C2=null;
		String policyNo = null;
		try {
			rst_C2 = handler.executeSelectStatement(sql_C2, connection, new Object[]{M_PAH_REF_NO});
			while(rst_C2.next()){
				policyNo = rst_C2.getString("CLAIM_POL_NO");
			}
		} catch (SQLException e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst_C2);
			} catch (Exception e) {
			}
		}
		return policyNo;
	}
	
	public void UI_M_CL_CLAIM_FM_NOValidator() throws ValidatorException {
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
    	String M_CL_CLAIM_FM_NO = dummyAction.getDUMMY_BEAN().getUI_M_CL_CLAIM_FM_NO();
    	System.out.println("M_CL_CLAIM_FM_NO::::::::::::::::::"+M_CL_CLAIM_FM_NO);
    	CRUDHandler handler = new CRUDHandler();
    	String M_TEMP=null;
    	String sql_C1="SELECT 'X' FROM  PT_IL_CLAIM  WHERE  CLAIM_NO  = ?";
    	ResultSet vembu_C1=null;
    	try
        {
            if(M_CL_CLAIM_FM_NO != null && !M_CL_CLAIM_FM_NO.trim().equals("") && !M_CL_CLAIM_FM_NO.equals("0"))
            {
            	vembu_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{M_CL_CLAIM_FM_NO});
                if(vembu_C1.next())
                {
                    M_TEMP=vembu_C1.getString(1);
                }
                if(M_TEMP==null)
                {
                	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71105"));
                }
            }
            else
            {
            	M_CL_CLAIM_FM_NO = (String) new PILT030_APAC_PROCEDURE().P_SET_FIRST_FIELD(M_CL_CLAIM_FM_NO);
            	dummyAction.getDUMMY_BEAN().setUI_M_CL_CLAIM_FM_NO(M_CL_CLAIM_FM_NO);
            }
        }catch(Exception e)
        {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
        	try {
				CommonUtils.closeCursor(vembu_C1);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        dummyAction.getCOMP_UI_M_CL_CLAIM_NO_FM().setSubmittedValue(null);
    }
	
	public void UI_M_CL_CLAIM_TO_NOValidator() throws ValidatorException {
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
    	CRUDHandler handler = new CRUDHandler();
    	String M_CL_CLAIM_TO_NO = dummyAction.getDUMMY_BEAN().getUI_M_CL_CLAIM_TO_NO();
    	String M_TEMP=null;
    	String sql_C1="SELECT 'X' FROM  PT_IL_CLAIM  WHERE  CLAIM_NO  = ?";
    	ResultSet vembu_C1=null;
    	try
        {
            if(M_CL_CLAIM_TO_NO != null && !M_CL_CLAIM_TO_NO.trim().equals("") && !M_CL_CLAIM_TO_NO.equals("zzzzzzzzzzzzzzzzzzzzzz"))
            {
            	vembu_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{M_CL_CLAIM_TO_NO});
                if(vembu_C1.next())
                {
                    M_TEMP=vembu_C1.getString(1);
                }
                if(M_TEMP==null)
                {
                	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71105"));
                }
            }
            else
            {
            	M_CL_CLAIM_TO_NO = (String) new PILT030_APAC_PROCEDURE().P_SET_SECOND_FIELD(M_CL_CLAIM_TO_NO);
            	dummyAction.getDUMMY_BEAN().setUI_M_CL_CLAIM_TO_NO(M_CL_CLAIM_TO_NO);
            }
        }catch(Exception e)
        {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
        	try {
				CommonUtils.closeCursor(vembu_C1);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        dummyAction.getCOMP_UI_M_CL_CLAIM_NO_TO().setSubmittedValue(null);
	}
	
	public void UI_M_CL_POLICY_FM_NOValidator() throws ValidatorException {
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
    	CRUDHandler handler = new CRUDHandler();
    	String M_CL_POLICY_FM_NO = dummyAction.getDUMMY_BEAN().getUI_M_CL_POLICY_FM_NO();
		String M_TEMP=null;
		String sql_C1="SELECT 'X' FROM  PT_IL_POLICY  WHERE  POL_DS_TYPE  = '2'  " +
				"AND POL_NO  = ? ";
		ResultSet vembu_C1=null;
		try
        {
            if(M_CL_POLICY_FM_NO != null && !M_CL_POLICY_FM_NO.trim().equals("") && !M_CL_POLICY_FM_NO.equals("0"))
            {
                vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{M_CL_POLICY_FM_NO});
                if(vembu_C1.next())
                {
                    M_TEMP=vembu_C1.getString(1);
                }
                if(M_TEMP==null)
                {
                	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91169"));
                }
            }
            else
            {
            	M_CL_POLICY_FM_NO = (String) new PILT030_APAC_PROCEDURE().P_SET_FIRST_FIELD(M_CL_POLICY_FM_NO);
            	dummyAction.getDUMMY_BEAN().setUI_M_CL_POLICY_FM_NO(M_CL_POLICY_FM_NO);
            }
        }catch(Exception e)
        {
           throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
        	try {
				CommonUtils.closeCursor(vembu_C1);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        dummyAction.getCOMP_UI_M_CL_POLICY_NO_FM().setSubmittedValue(null);
	}
	
	public void UI_M_CL_POLICY_TO_NOValidator() throws ValidatorException {
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
    	CRUDHandler handler = new CRUDHandler();
    	String M_CL_POLICY_TO_NO = dummyAction.getDUMMY_BEAN().getUI_M_CL_POLICY_TO_NO();
		String M_TEMP=null;
		String sql_C1="SELECT 'X' FROM  PT_IL_POLICY  WHERE  POL_DS_TYPE  = '2'  " +
				"AND POL_NO  = ? ";
		ResultSet vembu_C1=null;
		try
        {
            if(M_CL_POLICY_TO_NO != null && !M_CL_POLICY_TO_NO.trim().equals("") && !M_CL_POLICY_TO_NO.equals("zzzzzzzzzzzzzzzzzzzzzz"))
            {
                vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{M_CL_POLICY_TO_NO});
                if(vembu_C1.next())
                {
                    M_TEMP=vembu_C1.getString(1);
                }
                if(M_TEMP==null)
                {
                	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91169"));
                }
            }
            else
            {
            	M_CL_POLICY_TO_NO = (String) new PILT030_APAC_PROCEDURE().P_SET_SECOND_FIELD(M_CL_POLICY_TO_NO);
                dummyAction.getDUMMY_BEAN().setUI_M_CL_POLICY_TO_NO(M_CL_POLICY_TO_NO);
            }
        }catch(Exception e)
        {
           throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
        	try {
				CommonUtils.closeCursor(vembu_C1);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        dummyAction.getCOMP_UI_M_CL_POLICY_NO_TO().setSubmittedValue(null);
	}
	
	public void UI_M_CL_PROCESS_FM_DTValidator() throws ValidatorException {
    	DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
    	Date M_CL_PROCESS_FM_DT = dummyAction.getDUMMY_BEAN().getUI_M_CL_PROCESS_FM_DT();
		try
        {
			if(M_CL_PROCESS_FM_DT!=null){
				if(M_CL_PROCESS_FM_DT.compareTo(Calendar.getInstance().getTime())>0)
				{
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "2181"));
				}
			}
        }catch(Exception e)
        {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void UI_M_CL_PROCESS_TO_DTValidator() throws ValidatorException {
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
    	Date M_CL_PROCESS_FM_DT = dummyAction.getDUMMY_BEAN().getUI_M_CL_PROCESS_FM_DT();
    	Date M_CL_PROCESS_TO_DT = dummyAction.getDUMMY_BEAN().getUI_M_CL_PROCESS_TO_DT();
		try
        {
            if(M_CL_PROCESS_TO_DT.compareTo(Calendar.getInstance().getTime())>0)
            {
            	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "2181"));
            }
            else if(M_CL_PROCESS_TO_DT.compareTo(M_CL_PROCESS_FM_DT)<0)
            {
            	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1902"));
            }
        }catch(Exception e)
        {
        	throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public List<DUMMY> M_CL_CLAIM_NO_LIST(String claimNo) throws ValidatorException {
		if(claimNo!=null){
			if(claimNo.equals("*"))
				claimNo = "%";
			else
				claimNo += "%";
		}
		String query = "SELECT CLAIM_NO, to_char(CLAIM_LOSS_DT,'dd/mm/yyyy')" +
				"FROM PT_IL_CLAIM " +
				"WHERE CLAIM_NO LIKE NVL(?,CLAIM_NO) AND ROWNUM < 21";
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		List<DUMMY> claimList = null;
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{claimNo});
			claimList = new ArrayList<DUMMY>();
			while(rst.next()){
				DUMMY dummyBean = new DUMMY();
				dummyBean.setUI_M_CLAIM_NO(rst.getString(1));
				dummyBean.setUI_M_LOSS_DT(rst.getString(2));
				claimList.add(dummyBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		return claimList;
	}
	
	public List<DUMMY> M_CL_POLICY_NO_LIST(String policyNo) throws ValidatorException {
		if(policyNo!=null){
			if(policyNo.equals("*"))
				policyNo = "%";
			else
				policyNo += "%";
		}
		String query = "SELECT POL_NO, to_char(POL_ISSUE_DT,'dd/mm/yyyy')" +
				"FROM PT_IL_POLICY " +
				"WHERE NVL(POL_STATUS,'N') IN ('A', 'E', 'P') " +
				"AND POL_NO IS NOT NULL " +
				"AND POL_DS_TYPE = '2' " +
				"AND POL_NO LIKE NVL(?,POL_NO) AND ROWNUM<21";
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		List<DUMMY> polList = null;
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{policyNo});
			polList = new ArrayList<DUMMY>();
			while(rst.next()){
				DUMMY dummyBean = new DUMMY();
				dummyBean.setUI_M_POL_NO(rst.getString(1));
				dummyBean.setUI_M_POL_ISSUE_DT(rst.getString(2));
				polList.add(dummyBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		return polList;
	}
	
	public void keyCommit(){
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		PT_IL_PAYVOU_PAY_DTL_ACTION payDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_LIST();
		String UI_M_PAH_TYPE = dummyAction.getDUMMY_BEAN().getUI_M_PAH_TYPE();
		String PAH_FREEZE_FLAG = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_FREEZE_FLAG();
		Integer PAH_SYS_ID = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
		CRUDHandler handler  = new CRUDHandler();
		try
        {
            String sql_C1="SELECT    'X', PADD_ACNT_YEAR,    PADD_CUST_CODE,    PADD_DRCR_FLAG,    " +
            		"PADD_TXN_CODE,    PADD_DOC_NO FROM ( SELECT     PADD_ACNT_YEAR,     " +
            		"PADD_CUST_CODE,     PADD_DRCR_FLAG,     PADD_TXN_CODE,     " +
            		"PADD_DOC_NO,     DECODE(NVL(PADD_SELECTED_YN, 'N'), 'Y', 1, 0) COUNT_SEL_Y,     " +
            		"DECODE(NVL(PADD_SELECTED_YN, 'N'), 'N', 1, 0) COUNT_SEL_N  " +
            		"FROM  PT_IL_PAYVOU_DRCR_DTL   " +
            		"WHERE  PADD_PAH_SYS_ID  = ? )  " +
            		"GROUP BY PADD_ACNT_YEAR,   PADD_CUST_CODE,   PADD_DRCR_FLAG,   PADD_TXN_CODE,    " +
            		"PADD_DOC_NO  HAVING SUM(COUNT_SEL_Y)  > 0  AND SUM(COUNT_SEL_N)  > 0   ";
            String sql_C2="SELECT    'X', PADD_CUST_CODE,    SUM(CREDIT_AMT),    SUM(DEBIT_AMT) " +
            		"FROM ( SELECT     PADD_CUST_CODE,     DECODE(PADD_DRCR_FLAG, 'C', NVL(PADD_FC_AMT, 0), 0) CREDIT_AMT,     " +
            		"DECODE(PADD_DRCR_FLAG, 'D', NVL(PADD_FC_AMT, 0), 0) DEBIT_AMT  " +
            		"FROM  PT_IL_PAYVOU_DRCR_DTL   " +
            		"WHERE  NVL(PADD_SELECTED_YN, 'N')  = 'Y'   " +
            		"AND PADD_PAH_SYS_ID  = ?)  " +
            		"GROUP BY  PADD_CUST_CODE  ";
            ResultSet vembu_C1=null;
            ResultSet vembu_C2=null;
            String  /** METADATA NOT FOUND *********/ M_PADD_DRCR_FLAG=null;
            String  /** METADATA NOT FOUND *********/ M_PADD_TXN_CODE=null;
            String  /** METADATA NOT FOUND *********/ M_PADD_DOC_NO=null;
            String  /** METADATA NOT FOUND *********/ M_PADD_ACNT_YEAR=null;
            String  /** METADATA NOT FOUND *********/ M_PADD_CUST_CODE=null;
            Double  /** METADATA NOT FOUND *********/ M_CR_PADD_FC_AMT=null;
            Double  /** METADATA NOT FOUND *********/ M_DR_PADD_FC_AMT=null;
            String M_TEMP = null;
            if(!(PAH_FREEZE_FLAG==null?"N":PAH_FREEZE_FLAG).equals("N"))
            {
                if(!UI_M_PAH_TYPE.equals("CL"))
                {
                	for(PT_IL_PAYVOU_PAY_DTL payDtlBean:payDtlList){
                		new PILT030_APAC_PROCEDURE().IL_UNIQUE_MODE_PAYEE(payDtlBean);
                	}
                }
                for(PT_IL_PAYVOU_PAY_DTL payDtlBean:payDtlList){
                	new PILT030_APAC_PROCEDURE().L_VALIDATE_PAY_MODE_NULL(payDtlBean);
            	}
            }
            /*if(:SYSTEM.FORM_STATUS == ("QUERY") || :SYSTEM.FORM_STATUS == ("CHANGED"))
            {
                :CTRL.M_COMM_DEL="P";
                POST.POST();
                :CTRL.M_COMM_DEL=null;
            }*/
            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{PAH_SYS_ID});
            while(vembu_C1.next())
            {
            	M_TEMP = vembu_C1.getString(1);
                M_PADD_ACNT_YEAR=vembu_C1.getString(2);
                M_PADD_CUST_CODE=vembu_C1.getString(3);
                M_PADD_DRCR_FLAG=vembu_C1.getString(4);
                M_PADD_TXN_CODE=vembu_C1.getString(5);
                M_PADD_DOC_NO=vembu_C1.getString(6);
                if(M_TEMP==null){
                	hdrAction.getWarningMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91380"));
                	hdrAction.setWarningMessages(Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "91380"));
                }
                String sql_vembu1="UPDATE   PT_IL_PAYVOU_DRCR_DTL    SET PADD_SELECTED_YN = 'Y'  " +
			                "WHERE  PADD_PAH_SYS_ID  = ?  " +
			                "AND PADD_CUST_CODE  = ?  " +
			                "AND PADD_TXN_CODE  = ?  " +
			                "AND PADD_DOC_NO  = ? " +
			                "AND NVL(PADD_ACNT_YEAR, 0)  = NVL(?, 0)  ";
                int ROWCOUNT=handler.executeUpdateStatement(sql_vembu1, connection, new Object[]{PAH_SYS_ID,M_PADD_CUST_CODE,M_PADD_TXN_CODE,M_PADD_DOC_NO,M_PADD_ACNT_YEAR});
            }
            CommonUtils.closeCursor(vembu_C1);
            vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{PAH_SYS_ID});
            while(vembu_C2.next())
            {
            	M_TEMP = vembu_C2.getString(1);
                M_PADD_CUST_CODE=vembu_C2.getString(2);
                M_CR_PADD_FC_AMT=vembu_C2.getDouble(3);
                M_DR_PADD_FC_AMT=vembu_C2.getDouble(4);
                if(M_TEMP==null)
                	break;
                String sql_vembu2="UPDATE   PT_IL_PAYVOU_AMT_DTL    " +
                		"SET PAD_FC_CR_TOT_AMT = ?,      " +
                				"PAD_LC_CR_TOT_AMT = ?,      " +
                						"PAD_FC_DR_TOT_AMT = ?,      " +
                								"PAD_LC_DR_TOT_AMT = ?,      " +
                										"PAD_FC_BAL_AMT = ?,      " +
                												"PAD_LC_BAL_AMT = ?  " +
                														"WHERE  PAD_PAH_SYS_ID  = ?  " +
                														"AND PAD_CUST_CODE  = ? ";
                int ROWCOUNT=handler.executeUpdateStatement(sql_vembu2, connection, new Object[]{M_CR_PADD_FC_AMT, M_CR_PADD_FC_AMT, M_DR_PADD_FC_AMT, M_DR_PADD_FC_AMT, M_CR_PADD_FC_AMT - M_DR_PADD_FC_AMT, M_CR_PADD_FC_AMT - M_DR_PADD_FC_AMT, PAH_SYS_ID, M_PADD_CUST_CODE});
            }
            CommonUtils.closeCursor(vembu_C2);
            if(!(PAH_FREEZE_FLAG==null?"N":PAH_FREEZE_FLAG).equals("N"))
            {
                new PILT030_APAC_PROCEDURE().L_INS_PAY_COMMIT();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}

	public void preInsert(PT_IL_PAYVOU_HDR pt_il_payvou_hdr_bean) {
		String query = "SELECT PAH_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet rs = null;
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		String M_PARAM_1 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		try {
			
			connection=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(query, connection);
			while(rs.next()){
				pt_il_payvou_hdr_bean.setPAH_TYPE(M_PARAM_1);
				pt_il_payvou_hdr_bean.setPAH_SYS_ID(rs.getInt(1)); 
				pt_il_payvou_hdr_bean.setPAH_CR_DT(new CommonUtils().getCurrentDate());
				pt_il_payvou_hdr_bean.setPAH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			}
		} catch (Exception e) {
			
		}
	}
}
