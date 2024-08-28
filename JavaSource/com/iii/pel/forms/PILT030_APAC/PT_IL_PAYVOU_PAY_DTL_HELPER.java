package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_IL_PAYVOU_PAY_DTL_HELPER {
	
	public void executeQuery(){
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		PT_IL_PAYVOU_PAY_DTL_ACTION dtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
		CRUDHandler handler = new CRUDHandler();
		Double M_PAH_SYS_ID = dummyAction.getDUMMY_BEAN().getUI_M_PAH_SYS_ID();
		String query = "SELECT ROWID, PAPD_SYS_ID,PAPD_PAH_SYS_ID,PAPD_PAD_SYS_ID,PAPD_CUST_CODE," +
				"PAPD_PAY_MODE,PAPD_PAYEE_NAME,PAPD_PAYEE_ADDR1,PAPD_PAYEE_ADDR2,PAPD_PAYEE_ADDR3," +
				"PAPD_CURR_CODE,PAPD_FC_PAY_AMT,PAPD_LC_PAY_AMT,PAPD_BANK_CODE,PAPD_BANK_ACC_NO," +
				"PAPD_CLE_ZONE_CODE,PAPD_DES_MTD_CODE,PAPD_MAIN_ACNT_CODE,PAPD_SUB_ACNT_CODE," +
				"PAPD_ANLY_CODE_1,PAPD_ANLY_CODE_2,PAPD_ACTY_CODE_1,PAPD_ACTY_CODE_2,PAPD_TXN_CODE," +
				"PAPD_DOC_NO,PAPD_DOC_DT,PAPD_ACNT_YEAR,PAPD_PAYEE_ANLY_CODE_1,PAPD_PAYEE_ANLY_CODE_2," +
				"PAPD_NARRATION,PAPD_PAY_APPRV_CODE,PAPD_CITY_CODE,PAPD_STATE_CODE,PAPD_OFF_AREA_CODE," +
				"PAPD_CHQ_ISSUE_USER_ID,PAPD_CHQ_APPR_USER_ID,PAPD_CHQ_DT,PAPD_ATTENTION_TO " +
				"FROM PT_IL_PAYVOU_PAY_DTL " +
				"WHERE PAPD_PAH_SYS_ID=?";
		System.out.println(query);
		System.out.println(M_PAH_SYS_ID);
		List<PT_IL_PAYVOU_PAY_DTL> dtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
		try {
			ResultSet rst = handler.executeSelectStatement(query, connection, new Object[]{M_PAH_SYS_ID});
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL payDtlBean = new PT_IL_PAYVOU_PAY_DTL();
				payDtlBean.setROWID(rst.getString(1));
				payDtlBean.setPAPD_SYS_ID(rst.getDouble("PAPD_SYS_ID"));
				payDtlBean.setPAPD_PAH_SYS_ID(rst.getDouble("PAPD_PAH_SYS_ID"));
				payDtlBean.setPAPD_PAD_SYS_ID(rst.getDouble("PAPD_PAD_SYS_ID"));
				payDtlBean.setPAPD_CUST_CODE(rst.getString("PAPD_CUST_CODE"));
				payDtlBean.setPAPD_PAY_MODE(rst.getString("PAPD_PAY_MODE"));
				payDtlBean.setPAPD_PAYEE_NAME(rst.getString("PAPD_PAYEE_NAME"));
				payDtlBean.setPAPD_PAYEE_ADDR1(rst.getString("PAPD_PAYEE_ADDR1"));
				payDtlBean.setPAPD_PAYEE_ADDR2(rst.getString("PAPD_PAYEE_ADDR2"));
				payDtlBean.setPAPD_PAYEE_ADDR3(rst.getString("PAPD_PAYEE_ADDR3"));
				payDtlBean.setPAPD_CURR_CODE(rst.getString("PAPD_CURR_CODE"));
				payDtlBean.setPAPD_FC_PAY_AMT(rst.getDouble("PAPD_FC_PAY_AMT"));
				payDtlBean.setPAPD_LC_PAY_AMT(rst.getDouble("PAPD_LC_PAY_AMT"));
				payDtlBean.setPAPD_BANK_CODE(rst.getString("PAPD_BANK_CODE"));
				payDtlBean.setPAPD_BANK_ACC_NO(rst.getString("PAPD_BANK_ACC_NO"));
				payDtlBean.setPAPD_CLE_ZONE_CODE(rst.getString("PAPD_CLE_ZONE_CODE"));
				payDtlBean.setPAPD_DES_MTD_CODE(rst.getString("PAPD_DES_MTD_CODE"));
				payDtlBean.setPAPD_MAIN_ACNT_CODE(rst.getString("PAPD_MAIN_ACNT_CODE"));
				payDtlBean.setPAPD_SUB_ACNT_CODE(rst.getString("PAPD_SUB_ACNT_CODE"));
				payDtlBean.setPAPD_ANLY_CODE_1(rst.getString("PAPD_ANLY_CODE_1"));
				payDtlBean.setPAPD_ANLY_CODE_2(rst.getString("PAPD_ANLY_CODE_2"));
				payDtlBean.setPAPD_ACTY_CODE_1(rst.getString("PAPD_ACTY_CODE_1"));
				payDtlBean.setPAPD_ACTY_CODE_2(rst.getString("PAPD_ACTY_CODE_2"));
				payDtlBean.setPAPD_TXN_CODE(rst.getString("PAPD_TXN_CODE"));
				payDtlBean.setPAPD_DOC_NO(rst.getDouble("PAPD_DOC_NO"));
				payDtlBean.setPAPD_DOC_DT(rst.getDate("PAPD_DOC_DT"));
				payDtlBean.setPAPD_ACNT_YEAR(rst.getDouble("PAPD_ACNT_YEAR"));
				payDtlBean.setPAPD_PAYEE_ANLY_CODE_1(rst.getString("PAPD_PAYEE_ANLY_CODE_1"));
				payDtlBean.setPAPD_PAYEE_ANLY_CODE_2(rst.getString("PAPD_PAYEE_ANLY_CODE_2"));
				payDtlBean.setPAPD_NARRATION(rst.getString("PAPD_NARRATION"));
				payDtlBean.setPAPD_PAY_APPRV_CODE(rst.getString("PAPD_PAY_APPRV_CODE"));
				payDtlBean.setPAPD_CITY_CODE(rst.getString("PAPD_CITY_CODE"));
				payDtlBean.setPAPD_STATE_CODE(rst.getString("PAPD_STATE_CODE"));
				payDtlBean.setPAPD_OFF_AREA_CODE(rst.getString("PAPD_OFF_AREA_CODE"));
				payDtlBean.setPAPD_CHQ_ISSUE_USER_ID(rst.getString("PAPD_CHQ_ISSUE_USER_ID"));
				payDtlBean.setPAPD_CHQ_APPR_USER_ID(rst.getString("PAPD_CHQ_APPR_USER_ID"));
				payDtlBean.setPAPD_CHQ_DT(rst.getDate("PAPD_CHQ_DT"));
				payDtlBean.setPAPD_ATTENTION_TO(rst.getString("PAPD_ATTENTION_TO"));
//				payDtlBean = postQuery(payDtlBean);
				dtlList.add(payDtlBean);
				dtlAction.setPT_IL_PAYVOU_PAY_DTL_BEAN(payDtlBean);
			}
			
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
		//dtlAction.setPT_IL_PAYVOU_PAY_DTL_LIST(dtlList);
		//Logic For Default Population
		PT_IL_PAYVOU_PAY_DTL PT_IL_PAYVOU_PAY_DTL_BEAN = null;
		Iterator<PT_IL_PAYVOU_PAY_DTL> it = dtlList.iterator();
		
		while(it.hasNext()){
			PT_IL_PAYVOU_PAY_DTL_BEAN = it.next();
			PT_IL_PAYVOU_PAY_DTL_BEAN.setRowSelected(false);
		}
		dtlAction.setPT_IL_PAYVOU_PAY_DTL_LIST(dtlList);
		if (dtlList.size()>0){					
			dtlAction.setPT_IL_PAYVOU_PAY_DTL_BEAN(dtlList.get(0));
			dtlAction.getPT_IL_PAYVOU_PAY_DTL_BEAN().setRowSelected(true);
		}
		
	}
	
	public PT_IL_PAYVOU_PAY_DTL postQuery(PT_IL_PAYVOU_PAY_DTL payVouPayDtlBean){
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		BP_ACTION bpAction = PILT030_APAC_ACTION_INSTANCE.getBpActionInstance();
		String PAPD_CUST_CODE = payVouPayDtlBean.getPAPD_CUST_CODE();
		String M_PAPD_CUST_DESC = payVouPayDtlBean.getUI_M_PAPD_CUST_DESC();
		String PAPD_BANK_CODE = payVouPayDtlBean.getPAPD_BANK_CODE();
		String PAPD_CLE_ZONE_CODE = payVouPayDtlBean.getPAPD_CLE_ZONE_CODE();
		String M_PAPD_CLE_ZONE_DESC = payVouPayDtlBean.getUI_M_PAPD_CLE_ZONE_DESC();
		String PAPD_DES_MTD_CODE = payVouPayDtlBean.getPAPD_DES_MTD_CODE();
		String M_PAPD_DES_MTD_DESC = payVouPayDtlBean.getUI_M_PAPD_DES_MTD_DESC();
		String PAPD_MAIN_ACNT_CODE = payVouPayDtlBean.getPAPD_MAIN_ACNT_CODE();
		String M_MAIN_ACNT_CODE_DESC = payVouPayDtlBean.getUI_M_MAIN_ACNT_CODE_DESC();
		String PAPD_SUB_ACNT_CODE = payVouPayDtlBean.getPAPD_SUB_ACNT_CODE();
		String M_SUB_ACNT_DESC = payVouPayDtlBean.getUI_M_SUB_ACNT_DESC();
		String PAPD_ANLY_CODE_1 = payVouPayDtlBean.getPAPD_ANLY_CODE_1();
		String M_ANLY_DESC1 = payVouPayDtlBean.getUI_M_ANLY_DESC1();
		String PAPD_ANLY_CODE_2 = payVouPayDtlBean.getPAPD_ANLY_CODE_2();
		String M_ANLY_DESC2 = payVouPayDtlBean.getUI_M_ANLY_DESC2();
		String PAPD_PAYEE_ANLY_CODE_1 = payVouPayDtlBean.getPAPD_PAYEE_ANLY_CODE_1();
		String M_PAYEE_ANLY_DESC1 = payVouPayDtlBean.getUI_M_PAYEE_ANLY_DESC1();
		String PAPD_PAYEE_ANLY_CODE_2 = payVouPayDtlBean.getPAPD_PAYEE_ANLY_CODE_2();
		String M_PAYEE_ANLY_DESC2 = payVouPayDtlBean.getUI_M_PAYEE_ANLY_DESC2();
		String PAPD_ACTY_CODE_1 = payVouPayDtlBean.getPAPD_ACTY_CODE_1();
		String M_ACTY_DESC1 = payVouPayDtlBean.getUI_M_ACTY_DESC1();
		String PAPD_ACTY_CODE_2 = payVouPayDtlBean.getPAPD_ACTY_CODE_2();
		String M_ACTY_DESC2 = payVouPayDtlBean.getUI_M_ACTY_DESC2();
		String PAPD_CITY_CODE = payVouPayDtlBean.getPAPD_CITY_CODE();
		String M_CITY_DESC = payVouPayDtlBean.getUI_M_CITY_DESC();
		String PAPD_STATE_CODE = payVouPayDtlBean.getPAPD_STATE_CODE();
		String M_STATE_DESC = payVouPayDtlBean.getUI_M_STATE_DESC();
		String PAPD_OFF_AREA_CODE = payVouPayDtlBean.getPAPD_OFF_AREA_CODE();
		String M_POSTAL_DESC = payVouPayDtlBean.getUI_M_POSTAL_DESC();
		String PAPD_TXN_CODE = payVouPayDtlBean.getPAPD_TXN_CODE();
		Double PAPD_DOC_NO = payVouPayDtlBean.getPAPD_DOC_NO();
		Date PAPD_DOC_DT = payVouPayDtlBean.getPAPD_DOC_DT();
		String PAPD_PAY_MODE = payVouPayDtlBean.getPAPD_PAY_MODE();
		CRUDHandler handler = new CRUDHandler();
		try
        {
            String sql_C1="SELECT BANK_NAME FROM  FM_BANK  WHERE  BANK_CODE  = ? ";
            ResultSet vembu_C1=null;
            String sql_C2="SELECT CD_PRINT_UID FROM  FT_CHQ_WRITE_CHQ_DETAIL  " +
            		"WHERE  CD_TRAN_CODE  = ?  " +
            		"AND CD_DOC_NO  = ?  " +
            		"AND CD_DOC_DT  = ? ";
            ResultSet vembu_C2=null;
            String  /** METADATA NOT FOUND *********/ M_PC_VALUE=null;
            String sql_C3="SELECT NVL(PC_VALUE, 0) FROM  PM_CODES  " +
            		"WHERE  PC_TYPE  = 'IL_CPAY_MODE'  " +
            		"AND PC_CODE  = ? ";
            ResultSet vembu_C3=null;
            if(PAPD_CUST_CODE != null)
            {
            	ArrayList<OracleParameter> outputList = new PILT030_APAC_PROCEDURE().P_VAL_CUST(connection, PAPD_CUST_CODE,M_PAPD_CUST_DESC,"N","N",null);
            	M_PAPD_CUST_DESC = outputList.get(0).getValue();
            	payVouPayDtlBean.setUI_M_PAPD_CUST_DESC(M_PAPD_CUST_DESC);
            }
            if(PAPD_BANK_CODE != null)
            {
                vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{PAPD_BANK_CODE});
                if(vembu_C1.next())
                {
                	payVouPayDtlBean.setUI_M_BANK_DESC(vembu_C1.getString(1));
                }
                CommonUtils.closeCursor(vembu_C1);
            }
            if(PAPD_CLE_ZONE_CODE != null)
            {
            	M_PAPD_CLE_ZONE_DESC = new PILT030_APAC_PROCEDURE().P_VAL_CODES(connection, "CLE_ZONE",PAPD_CLE_ZONE_CODE,M_PAPD_CLE_ZONE_DESC,"N","N","N");
            	payVouPayDtlBean.setUI_M_PAPD_CLE_ZONE_DESC(M_PAPD_CLE_ZONE_DESC);
            }
            if(PAPD_DES_MTD_CODE != null)
            {
            	M_PAPD_DES_MTD_DESC = new PILT030_APAC_PROCEDURE().P_VAL_CODES(connection, "DES_MTD",PAPD_DES_MTD_CODE,M_PAPD_DES_MTD_DESC,"N","N","N");
            	payVouPayDtlBean.setUI_M_PAPD_DES_MTD_DESC(M_PAPD_DES_MTD_DESC);
            }
            if(PAPD_MAIN_ACNT_CODE != null)
            {
            	M_MAIN_ACNT_CODE_DESC = new PILT030_APAC_PROCEDURE().P_VAL_MAIN_ACNT(connection, PAPD_MAIN_ACNT_CODE,M_MAIN_ACNT_CODE_DESC,"N","N");
            	payVouPayDtlBean.setUI_M_MAIN_ACNT_CODE_DESC(M_MAIN_ACNT_CODE_DESC);
            }
            if(PAPD_SUB_ACNT_CODE != null)
            {
            	M_SUB_ACNT_DESC = new PILT030_APAC_PROCEDURE().P_VAL_SUB_ACNT(connection, PAPD_MAIN_ACNT_CODE,PAPD_SUB_ACNT_CODE,M_SUB_ACNT_DESC,"N","N");
            	payVouPayDtlBean.setUI_M_SUB_ACNT_DESC(M_SUB_ACNT_DESC);
            }
            if(PAPD_ANLY_CODE_1 != null)
            {
            	M_ANLY_DESC1 = new PILT030_APAC_PROCEDURE().P_VAL_ANLY(connection, "1",PAPD_ANLY_CODE_1,M_ANLY_DESC1,"N","N");
            	payVouPayDtlBean.setUI_M_ANLY_DESC1(M_ANLY_DESC1);
            }
            if(PAPD_ANLY_CODE_2 != null)
            {
            	M_ANLY_DESC2 = new PILT030_APAC_PROCEDURE().P_VAL_ANLY(connection,"2",PAPD_ANLY_CODE_2,M_ANLY_DESC2,"N","N");
            	payVouPayDtlBean.setUI_M_ANLY_DESC2(M_ANLY_DESC2);
            }
            if(PAPD_PAYEE_ANLY_CODE_1 != null)
            {
            	M_PAYEE_ANLY_DESC1 = new PILT030_APAC_PROCEDURE().P_VAL_ANLY(connection, "1",PAPD_PAYEE_ANLY_CODE_1,M_PAYEE_ANLY_DESC1,"N","N");
            	payVouPayDtlBean.setUI_M_PAYEE_ANLY_DESC1(M_PAYEE_ANLY_DESC1);
            }
            if(PAPD_PAYEE_ANLY_CODE_2 != null)
            {
            	M_PAYEE_ANLY_DESC2 = new PILT030_APAC_PROCEDURE().P_VAL_ANLY(connection, "2",PAPD_PAYEE_ANLY_CODE_2,M_PAYEE_ANLY_DESC2,"N","N");
            	payVouPayDtlBean.setUI_M_PAYEE_ANLY_DESC2(M_PAYEE_ANLY_DESC2);
            }
            if(PAPD_ACTY_CODE_1 != null)
            {
            	M_ACTY_DESC1 = new PILT030_APAC_PROCEDURE().P_VAL_ACTY(connection, PAPD_MAIN_ACNT_CODE,PAPD_ACTY_CODE_1,M_ACTY_DESC1,"N","N");
            	payVouPayDtlBean.setUI_M_ACTY_DESC1(M_ACTY_DESC1);
            }
            if(PAPD_ACTY_CODE_2 != null)
            {
            	M_ACTY_DESC2 = new PILT030_APAC_PROCEDURE().P_VAL_ACTY(connection, PAPD_MAIN_ACNT_CODE,PAPD_ACTY_CODE_2,M_ACTY_DESC2,"N","N");
            	payVouPayDtlBean.setUI_M_ACTY_DESC2(M_ACTY_DESC2);
            }
            if(PAPD_CITY_CODE != null)
            {
            	M_CITY_DESC = new PILT030_APAC_PROCEDURE().P_VAL_CODES(connection, "CITY",PAPD_CITY_CODE,M_CITY_DESC,"N","E",null);
            	payVouPayDtlBean.setUI_M_CITY_DESC(M_CITY_DESC);
            }
            else
            {
                M_CITY_DESC=null;
                payVouPayDtlBean.setUI_M_CITY_DESC(M_CITY_DESC);
            }
            if(PAPD_STATE_CODE != null)
            {
            	M_STATE_DESC = new PILT030_APAC_PROCEDURE().P_VAL_CODES(connection, "STATE",PAPD_STATE_CODE,M_STATE_DESC,"N","E",null);
            	payVouPayDtlBean.setUI_M_STATE_DESC(M_STATE_DESC);
            }
            else
            {
                M_STATE_DESC=null;
                payVouPayDtlBean.setUI_M_STATE_DESC(M_STATE_DESC);
            }
            if(PAPD_OFF_AREA_CODE != null)
            {
            	M_POSTAL_DESC = new PILT030_APAC_PROCEDURE().P_VAL_CODES(connection, "POSTAL",PAPD_OFF_AREA_CODE,M_POSTAL_DESC,"N","E",null);
            	payVouPayDtlBean.setUI_M_POSTAL_DESC(M_POSTAL_DESC);
            }
            else
            {
                M_POSTAL_DESC=null;
                payVouPayDtlBean.setUI_M_POSTAL_DESC(M_POSTAL_DESC);
            }
            vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{PAPD_TXN_CODE,PAPD_DOC_NO,PAPD_DOC_DT});
            if(vembu_C2.next())
            {
            	payVouPayDtlBean.setPAPD_CHQ_APPR_USER_ID(vembu_C2.getString(1));
            }
            CommonUtils.closeCursor(vembu_C2);
            vembu_C3=handler.executeSelectStatement(sql_C3, connection, new Object[]{PAPD_PAY_MODE});
            if(vembu_C3.next())
            {
                M_PC_VALUE=vembu_C3.getString(1);
            }
            vembu_C3.close();
            if(M_PC_VALUE.equals("3"))
            {
                bpAction.getBP_BEAN().setB_PAPD_PAY_APPRV_CODE("CHEQUE NO");
            }
            else
            {
            	bpAction.getBP_BEAN().setB_PAPD_PAY_APPRV_CODE("TT APPR CODE");
            }
        }catch(Exception e)
        {
        	e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
        return payVouPayDtlBean;
	}
	
	public PT_IL_PAYVOU_PAY_DTL whenCreateRecord() throws ValidatorException {
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		PT_IL_PAYVOU_PAY_DTL_ACTION payDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
		PT_IL_PAYVOU_AMT_DTL_ACTION payAmtDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouAmtDtlActionInstance();
		String M_PAH_TYPE = dummyAction.getDUMMY_BEAN().getUI_M_PAH_TYPE();
		Double M_TOT_PAPD_FC_PAY_AMT = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_BEAN().getUI_M_TOT_PAPD_FC_PAY_AMT();
		Double PAD_FC_BAL_AMT = payAmtDtlAction.getPT_IL_PAYVOU_AMT_DTL_BEAN().getPAD_FC_BAL_AMT();
		PT_IL_PAYVOU_PAY_DTL payDtlBean = new PT_IL_PAYVOU_PAY_DTL();
        try
        {
            if(!(M_PAH_TYPE==null?"":M_PAH_TYPE).equals("CL"))
            {
                new PILT030_APAC_PROCEDURE().IL_UNIQUE_MODE_PAYEE(payDtlBean);
            }
            if(M_TOT_PAPD_FC_PAY_AMT==PAD_FC_BAL_AMT)
            {
            	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91066"));
            }
            payDtlBean = new PILT030_APAC_PROCEDURE().L_INS_PAY_DTL(payDtlBean);
        }catch(Exception e)
        {
           throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
        return payDtlBean;
	}
	
	public void whenNewRecordInstance() throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_ACTION payDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
		try
        {
            executeQuery();
           /* payDtlAction.getCOMP_PAPD_PAYEE_ADDR1().setRequired(true);
            payDtlAction.getCOMP_PAPD_OFF_AREA_CODE().setRequired(true);
            payDtlAction.getCOMP_PAPD_STATE_CODE().setRequired(true);*/
            /*if(:PT_IL_PAYVOU_PAY_DTL.PAPD_CITY_CODE != null)
            {
                P_VAL_CODES.P_VAL_CODES("CITY",:PT_IL_PAYVOU_PAY_DTL.PAPD_CITY_CODE,:PT_IL_PAYVOU_PAY_DTL.M_CITY_DESC,"N","E",null);
            }
            else
            {
                :PT_IL_PAYVOU_PAY_DTL.M_CITY_DESC=null;
            }
            if(:PT_IL_PAYVOU_PAY_DTL.PAPD_STATE_CODE != null)
            {
                P_VAL_CODES.P_VAL_CODES("STATE",:PT_IL_PAYVOU_PAY_DTL.PAPD_STATE_CODE,:PT_IL_PAYVOU_PAY_DTL.M_STATE_DESC,"N","E",null);
            }
            else
            {
                :PT_IL_PAYVOU_PAY_DTL.M_STATE_DESC=null;
            }
            if(:PT_IL_PAYVOU_PAY_DTL.PAPD_OFF_AREA_CODE != null)
            {
                P_VAL_CODES.P_VAL_CODES("POSTAL",:PT_IL_PAYVOU_PAY_DTL.PAPD_OFF_AREA_CODE,:PT_IL_PAYVOU_PAY_DTL.M_POSTAL_DESC,"N","E",null);
            }
            else
            {
                :PT_IL_PAYVOU_PAY_DTL.M_POSTAL_DESC=null;
            }*/
        }catch(Exception e)
        {
            e.printStackTrace();
        }
	}
	
	public void whenNewBlockInstance() throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_ACTION payDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
		try
        {
            executeQuery();
//            payDtlAction.getCOMP_PAPD_CURR_CODE().setReadonly(true);
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void preInsert(PT_IL_PAYVOU_PAY_DTL payDtlBean) throws ValidatorException {
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		String M_PAH_TYPE = dummyAction.getDUMMY_BEAN().getUI_M_PAH_TYPE();
		CRUDHandler handler = new CRUDHandler();
		try
        {
            String sql_C1="SELECT PIL_PAPD_SYS_ID.NEXTVAL FROM  DUAL  ";
            ResultSet vembu_C1=null;
            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{});
            if(vembu_C1.next())
            {
            	payDtlBean.setPAPD_SYS_ID(vembu_C1.getDouble(1));
            }
            CommonUtils.closeCursor(vembu_C1);
//            payDtlBean.setPAPD_CUST_CODE=:PT_IL_PAYVOU_AMT_DTL.PAD_CUST_CODE;
            ControlBean ctrlBean = CommonUtils.getControlBean();
            payDtlBean.setPAPD_CR_UID(ctrlBean.getM_USER_ID());
            payDtlBean.setPAPD_CR_DT(Calendar.getInstance().getTime());
            if(!(M_PAH_TYPE==null?"":M_PAH_TYPE).equals("CL"))
            {
                new PILT030_APAC_PROCEDURE().IL_UNIQUE_MODE_PAYEE(payDtlBean);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void preUpdate(PT_IL_PAYVOU_PAY_DTL payDtlBean) throws ValidatorException {
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		String M_PAH_TYPE = dummyAction.getDUMMY_BEAN().getUI_M_PAH_TYPE();
		try
        {
			ControlBean ctrlBean = CommonUtils.getControlBean();
			payDtlBean.setPAPD_CR_UID(ctrlBean.getM_USER_ID());
			payDtlBean.setPAPD_CR_DT(Calendar.getInstance().getTime());
			if(!(M_PAH_TYPE==null?"":M_PAH_TYPE).equals("CL"))
            {
                new PILT030_APAC_PROCEDURE().IL_UNIQUE_MODE_PAYEE(payDtlBean);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public PT_IL_PAYVOU_PAY_DTL getBeanInstance() throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_ACTION payDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
		PT_IL_PAYVOU_PAY_DTL bean=payDtlAction.getPT_IL_PAYVOU_PAY_DTL_BEAN();
		//int rowIndex = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_DT().getRowIndex();
		//return payDtlAction.getPT_IL_PAYVOU_PAY_DTL_LIST().get(rowIndex);
		return bean;
	}
	
	public void pilt030_apac_pt_il_payvou_pay_dtl_papd_pay_mode_when_list_changed() 
	throws ValidatorException {
		ResultSet resultSet=null;
		String M_PC_VALUE=null;
		String M_APPL_YN=null;
		String M_ACC_DIVN_CODE=null;
		String M_DIVN_CODE=null;
		String M_DEPT_CODE=null;
		PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
		BP bpValueBean = PILT030_APAC_ACTION_INSTANCE.getBpActionInstance().getBP_BEAN();
		Connection connection = null;
		connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		DBProcedures dbProcedures = new DBProcedures();
		DUMMY dummyBean = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance().getDUMMY_BEAN();
		PT_IL_PAYVOU_PAY_DTL_ACTION payDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
        try{
            
            currentRow.setPAPD_PAYEE_ADDR1_REQUIRED(true);
            currentRow.setPAPD_OFF_AREA_CODE_REQUIRED(true);
            currentRow.setPAPD_STATE_CODE_REQUIRED(true);
            
            String sql_C1="SELECT PC_VALUE,PC_RI_APPL_YN FROM PM_CODES WHERE PC_CODE  = ? AND PC_TYPE = 'IL_CPAY_MODE' ";
            Object[] values = {currentRow.getPAPD_PAY_MODE()};
            resultSet = handler.executeSelectStatement(sql_C1, connection, values);
            if(resultSet.next()){
                M_PC_VALUE=resultSet.getString(1);
                M_APPL_YN=resultSet.getString(2);
            }
            
            if("4".equals(MigratingFunctions.nvl(M_PC_VALUE,0+""))){
            	currentRow.setPAPD_BANK_ACC_NO_REQUIRED(true);
            	currentRow.setPAPD_BANK_CODE_REQUIRED(true);
            	currentRow.setPAPD_PAY_APPRV_CODE_DISABLED(true);
            }else if("2".equals(MigratingFunctions.nvl(M_PC_VALUE,0+""))){
            	currentRow.setPAPD_CLE_ZONE_CODE_REQUIRED(true);
            	currentRow.setPAPD_DES_MTD_CODE_REQUIRED(true);
                if("Y".equals(M_APPL_YN)){
                	bpValueBean.setB_PAPD_PAY_APPRV_CODE("TT APPR CODE");
                	currentRow.setPAPD_PAY_APPRV_CODE_DISABLED(false);
                	currentRow.setPAPD_PAY_APPRV_CODE_REQUIRED(true);
                }else{
                	currentRow.setPAPD_PAY_APPRV_CODE_REQUIRED(false);
                }
            }else if("5".equals(MigratingFunctions.nvl(M_PC_VALUE,0+""))){
            	bpValueBean.setB_PAPD_PAY_APPRV_CODE("BANK REF NO");
            	currentRow.setPAPD_PAY_APPRV_CODE_DISABLED(false);
            	currentRow.setPAPD_PAY_APPRV_CODE_REQUIRED(true);
            }else if("3".equals(MigratingFunctions.nvl(M_PC_VALUE,0+""))){
            	bpValueBean.setB_PAPD_PAY_APPRV_CODE("CHEQUE NO");
            }else{
            	currentRow.setPAPD_BANK_ACC_NO_REQUIRED(false);
            	currentRow.setPAPD_BANK_CODE_REQUIRED(false);
            	currentRow.setPAPD_CLE_ZONE_CODE_REQUIRED(false);
            	currentRow.setPAPD_DES_MTD_CODE_REQUIRED(false);
            	currentRow.setPAPD_PAY_APPRV_CODE_REQUIRED(false);
                currentRow.setPAPD_PAY_APPRV_CODE(null);
            }
            try{
                M_ACC_DIVN_CODE=CommonUtils.getGlobalVariable("GLOBAL.M_DIVN_CODE");
                ArrayList<String> list = dbProcedures.callP9ILPK_ACNT_PROC_GET_P_ACC_SETUP(M_ACC_DIVN_CODE, dummyBean.getUI_M_PAH_TYPE(), "P", currentRow.getPAPD_PAY_MODE(), "E");
                if(list!= null && list.size()>0){
                	currentRow.setPAPD_MAIN_ACNT_CODE(list.get(0));
                	currentRow.setPAPD_SUB_ACNT_CODE(list.get(1));
                	M_DIVN_CODE = list.get(2);
                	M_DEPT_CODE = list.get(3);
                	currentRow.setPAPD_PAYEE_ANLY_CODE_1(list.get(4));
                	currentRow.setPAPD_PAYEE_ANLY_CODE_2(list.get(5));
                	currentRow.setPAPD_ACTY_CODE_1(list.get(6));
                	currentRow.setPAPD_ACTY_CODE_2(list.get(7));
                }
                
                ArrayList<String> list2 = dbProcedures.callP9ILPK_ACNT_PROC_GET_P_ACC_SETUP(M_ACC_DIVN_CODE, dummyBean.getUI_M_PAH_TYPE(), "P", currentRow.getPAPD_PAY_MODE(), "R");
                if(list2!= null && list2.size()>0){
                	currentRow.setPAPD_MAIN_ACNT_CODE(list2.get(0));
                	currentRow.setPAPD_SUB_ACNT_CODE(list2.get(1));
                	M_DIVN_CODE = list2.get(2);
                	M_DEPT_CODE = list2.get(3);
                	currentRow.setPAPD_ANLY_CODE_1(list2.get(4));
                	currentRow.setPAPD_ANLY_CODE_2(list2.get(5));
                	currentRow.setPAPD_ACTY_CODE_1(list2.get(6));
                	currentRow.setPAPD_ACTY_CODE_2(list2.get(7));
                }
            }
            catch(SQLException se){
            	se.printStackTrace();
                throw new ValidatorException(new FacesMessage(se.getMessage()));
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
        	ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), "PAPD_PAY_MODE", payDtlAction.getErrorMap(), payDtlAction.getWarningMap());
        	try{
        		CommonUtils.closeCursor(resultSet);
        	}catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
	
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_fc_pay_amt_when_validate_item() 
     throws ValidatorException{
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	PT_IL_PAYVOU_AMT_DTL amtDtlBean = PILT030_APAC_ACTION_INSTANCE.getPayVouAmtDtlActionInstance().getPT_IL_PAYVOU_AMT_DTL_BEAN();
    	
        try{
            if(currentRow.getPAPD_FC_PAY_AMT() != null){
                if(currentRow.getPAPD_FC_PAY_AMT()< 0){
                	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91052"));
                }
            }
            Double M_TOT_PAPD_FC_PAY_AMT = currentRow.getUI_M_TOT_PAPD_FC_PAY_AMT();
            if(currentRow.getPAPD_FC_PAY_AMT() != null && amtDtlBean.getPAD_FC_BAL_AMT() != null){
                if((M_TOT_PAPD_FC_PAY_AMT==null?0.0:M_TOT_PAPD_FC_PAY_AMT)>java.lang.Math.abs(amtDtlBean.getPAD_FC_BAL_AMT())){
                	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91070"));
                }
            }
            currentRow.setPAPD_LC_PAY_AMT(MigratingFunctions.nvl(currentRow.getPAPD_FC_PAY_AMT(),0)*1);
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
	
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_lc_pay_amt_when_validate_item() throws ValidatorException{
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	try{
    		if(currentRow.getPAPD_LC_PAY_AMT() != null){
    			if(currentRow.getPAPD_LC_PAY_AMT()<0){
    				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91052"));
    			}
    		}
    		currentRow.setPAPD_LC_PAY_AMT(currentRow.getPAPD_FC_PAY_AMT());
    		ArrayList<String> list = null; 
    		// Commented to avoid compilation error, Dated: 15-Feb, Commented by: Manoj
    		//list = new PILT006_APAC_PROCEDURE().callP_VAL_ROUND_AMT(connection, CommonUtils.getControlBean().getM_BASE_CURR(), currentRow.getPAPD_LC_PAY_AMT(), "R");
    		if(list!= null && list.size()>0){
    			currentRow.setPAPD_LC_PAY_AMT(CommonUtils.parseToDouble(list.get(0)));
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		throw new ValidatorException(new FacesMessage(e.getMessage()));
    	}
    }

    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_payee_name_when_validate_item() throws ValidatorException {
    	DUMMY dummyBean = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance().getDUMMY_BEAN();
        try{
            if(!dummyBean.getUI_M_PAH_TYPE().equals("CL")){
               IL_UNIQUE_MODE_PAYEE();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void IL_UNIQUE_MODE_PAYEE() throws ValidatorException  {
        Connection connection = null ;
        connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
        PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
        PT_IL_PAYVOU_AMT_DTL amtDtlBean = PILT030_APAC_ACTION_INSTANCE.getPayVouAmtDtlActionInstance().getPT_IL_PAYVOU_AMT_DTL_BEAN();
        PT_IL_PAYVOU_HDR hdrBean = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance().getPT_IL_PAYVOU_HDR_BEAN();
        CRUDHandler handler = null;
        handler = new CRUDHandler();
        String M_PAPD_PAY_MODE=null;
        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;
        try{
            //TODO record status todo
            //if(:SYSTEM.RECORD_STATUS=="INSERT")
            if(true){
            	String sql_C1="SELECT 'X'FROM PT_IL_PAYVOU_PAY_DTL WHERE PAPD_PAY_MODE = ? AND PAPD_PAYEE_NAME = ? AND PAPD_SYS_ID = ? AND PAPD_PAD_SYS_ID = ? AND PAPD_PAH_SYS_ID  = ? ";
                Object[] values = {currentRow.getPAPD_PAY_MODE(),currentRow.getPAPD_PAYEE_NAME(),currentRow.getPAPD_SYS_ID(),amtDtlBean.getPAD_SYS_ID(),hdrBean.getPAH_SYS_ID()};
                resultSet1 = handler.executeSelectStatement(sql_C1, connection, values);
                
                if(resultSet1.next()){
                    M_PAPD_PAY_MODE=resultSet1.getString(1);
                    throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "90015", new Object[]{"PAYMENT MODE AND PAYEE NAME IS"})); 
                }
            }else{
            	String sql_C2="SELECT 'X' FROM  PT_IL_PAYVOU_PAY_DTL  WHERE  PAPD_PAY_MODE  = ?  AND PAPD_PAYEE_NAME  = ?  AND PAPD_PAD_SYS_ID  = ?  AND PAPD_PAH_SYS_ID  = ? AND ROWID  <> ? ";
                Object[] values2 = {currentRow.getPAPD_PAY_MODE(),currentRow.getPAPD_PAYEE_NAME(),amtDtlBean.getPAD_SYS_ID(),hdrBean.getPAH_SYS_ID(),currentRow.getROWID()};
                resultSet2 = handler.executeSelectStatement(sql_C2, connection, values2);
                if(resultSet2.next()){
                    M_PAPD_PAY_MODE=resultSet2.getString(1);
                    throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "90015", new Object[]{"PAYMENT MODE AND PAYEE NAME IS"}));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
            try{
            	CommonUtils.closeCursor(resultSet1);
            	CommonUtils.closeCursor(resultSet2);
            }catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_pay_apprv_code_pre_text_item() throws ValidatorException {
    	Connection connection = null;
    	connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	CRUDHandler handler = null;
    	handler = new CRUDHandler();
    	ResultSet resultSet = null;
    	String M_PC_VALUE=null;
    	String M_APPL_YN=null;
        try{
        	String sql_C1="SELECT    PC_VALUE,    PC_RI_APPL_YN FROM  PM_CODES  WHERE  PC_CODE  = ?  AND PC_TYPE  = 'IL_CPAY_MODE' ";
            Object[] values = {currentRow.getPAPD_PAY_MODE()};
            resultSet = handler.executeSelectStatement(sql_C1, connection, values);
            if(resultSet.next()){
                M_PC_VALUE=resultSet.getString(1);
                M_APPL_YN=resultSet.getString(2);
            }
            
            if("2".equals(MigratingFunctions.nvl(M_PC_VALUE,0+"")) || "5".equals(MigratingFunctions.nvl(M_PC_VALUE,0+""))){
                if(currentRow.getPAPD_PAY_APPRV_CODE()== null){
                    currentRow.setPAPD_PAY_APPRV_CODE(null);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
            try{
            	CommonUtils.closeCursor(resultSet);
            }catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_chq_dt_pre_text_item() 
    	throws ValidatorException {
    	Connection connection = null;
    	connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	CRUDHandler handler = null;
    	handler = new CRUDHandler();
    	ResultSet resultSet = null;
        String M_PC_VALUE=null;
        String M_APPL_YN=null;
        try{
            String sql_C1="SELECT    PC_VALUE,    PC_RI_APPL_YN FROM  PM_CODES WHERE PC_CODE  = ? AND PC_TYPE  = 'IL_CPAY_MODE' ";
            Object[] values = {currentRow.getPAPD_PAY_MODE()};
            resultSet = handler.executeSelectStatement(sql_C1, connection, values);
            if(resultSet.next()){
                M_PC_VALUE=resultSet.getString(1);
                M_APPL_YN=resultSet.getString(2);
            }
            if("2".equals(MigratingFunctions.nvl(M_PC_VALUE,0+"")) || "5".equals(MigratingFunctions.nvl(M_PC_VALUE,0+""))){
                if(currentRow.getPAPD_PAY_APPRV_CODE()== null){
                    currentRow.setPAPD_PAY_APPRV_CODE(null);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
            try{
            	CommonUtils.closeCursor(resultSet);
            }catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_payee_addr1_key_next_item() throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
        try{
            if(currentRow.getPAPD_PAYEE_ADDR1()== null){
            	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "19050"));
            }else{
                //GO_ITEM.GO_ITEM("PT_IL_PAYVOU_PAY_DTL.PAPD_PAYEE_ADDR2");
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_payee_addr1_when_validate_item() 
    throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
        try{
            if(currentRow.getPAPD_PAYEE_ADDR1()== null){
            	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "19050"));
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_off_area_code_when_validate_item() 
     throws ValidatorException {
    	Connection connection = null;
        connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
        PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	CRUDHandler handler = null;
    	handler = new CRUDHandler();
    	ResultSet resultSet = null;
    	DBProcedures dbProcedures = new DBProcedures();
    	try{
    		if(currentRow.getPAPD_OFF_AREA_CODE() != null){
    			ArrayList<String> list = dbProcedures.P_VAL_CODES_PROC_CALL("POSTAL", currentRow.getPAPD_OFF_AREA_CODE(), "N", "E");
    			if(list!= null && list.size()>0){
    				currentRow.setUI_M_POSTAL_DESC(list.get(0));
    			}
    			String sql_C1="SELECT PCM_CITY_CODE,PCM_STATE_CODE FROM PM_POST_CODE_MASTER WHERE  PCM_POSTAL_CODE  = ? ";
    			Object[] values = {currentRow.getPAPD_OFF_AREA_CODE()};
    			resultSet = handler.executeSelectStatement(sql_C1, connection, values);
    			if(resultSet.next()){
    				currentRow.setPAPD_CITY_CODE(resultSet.getString(1));
    				currentRow.setPAPD_STATE_CODE(resultSet.getString(2));
    			}
    		}else{
    			currentRow.setUI_M_POSTAL_DESC(null);
    		}
    	}catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
            try{
            	CommonUtils.closeCursor(resultSet);
            }catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_off_area_code_key_next_item() 
     throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
        try{
            if(currentRow.getPAPD_OFF_AREA_CODE()== null){
            	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "19050"));
            }else{
                //NEXT_ITEM.NEXT_ITEM();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    } 
   
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_city_code_when_validate_item() 
     throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	DBProcedures dbProcedures = new DBProcedures();
        try{
            if(currentRow.getPAPD_CITY_CODE() != null){
            	ArrayList<String> list = dbProcedures.P_VAL_CODES_PROC_CALL("CITY", currentRow.getPAPD_CITY_CODE(), "N", "E");
            	if(list!=null && list.size()>0){
            		currentRow.setUI_M_CITY_DESC(list.get(0));
            	}
            }else{
            	currentRow.setUI_M_CITY_DESC(null);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    } 
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_state_code_when_validate_item() 
    	throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	DBProcedures dbProcedures = new DBProcedures();
        try{
            if(currentRow.getPAPD_STATE_CODE() != null){
            	ArrayList<String> list = dbProcedures.P_VAL_CODES_PROC_CALL("STATE", currentRow.getPAPD_STATE_CODE(), "N", "E");
            	if(list!= null && list.size()>0){
            		currentRow.setUI_M_STATE_DESC(list.get(0));
            	}
            }else{
            	currentRow.setUI_M_STATE_DESC(null);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_state_code_key_next_item() 
    throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
        try{
            if(currentRow.getPAPD_STATE_CODE()== null){
            	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "19050"));
            }else{
                //NEXT_ITEM.NEXT_ITEM();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_bank_code_when_validate_item() 
    throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
        Connection connection = null;
        connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
        CRUDHandler handler = null;
        handler = new CRUDHandler();
        ResultSet resultSet = null;
        try{
            if(currentRow.getPAPD_BANK_CODE() != null){
            	String sql_C1="SELECT BANK_NAME FROM  FM_BANK  WHERE  BANK_CODE  = ? ";
                Object[] values = {currentRow.getPAPD_BANK_CODE()};
                resultSet = handler.executeSelectStatement(sql_C1, connection, values);
                if(resultSet.next()){
                	currentRow.setUI_M_STATE_DESC(resultSet.getString(1));
                }else{
                	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80611"));
                }
            }else{
                currentRow.setUI_M_BANK_DESC(null);
                currentRow.setPAPD_BANK_ACC_NO(null);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
            try{
            	CommonUtils.closeCursor(resultSet);
            }catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_cle_zone_code_when_validate_item() 
     throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	DBProcedures dbProcedures = new DBProcedures();
        try{
            if(currentRow.getPAPD_CLE_ZONE_CODE() != null){
            	ArrayList<String> list = dbProcedures.P_VAL_CODES_PROC_CALL("CLE_ZONE", currentRow.getPAPD_CLE_ZONE_CODE(), "N", "E");
            	if(list!= null && list.size()>0){
            		currentRow.setUI_M_PAPD_CLE_ZONE_DESC(list.get(0));
            	}
            }else{
                currentRow.setUI_M_PAPD_CLE_ZONE_DESC(null);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_des_mtd_code_when_validate_item() 
    throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	DBProcedures dbProcedures = new DBProcedures();
        try{
            if(currentRow.getPAPD_DES_MTD_CODE() != null){
            	ArrayList<String> list = dbProcedures.helperP_VAL_CODES("DES_MTD", currentRow.getPAPD_DES_MTD_CODE(), "N","E","N");
            	if(list!= null && list.size()>0){
            		currentRow.setUI_M_PAPD_DES_MTD_DESC(list.get(0));
            	}
            }else{
            	currentRow.setUI_M_PAPD_DES_MTD_DESC(null);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_main_acnt_code_when_validate_item() 
    throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	DBProcedures dbProcedures = new DBProcedures();
        try{
            if(currentRow.getPAPD_MAIN_ACNT_CODE() != null){
            	ArrayList<String> list = dbProcedures.P_VAL_MAIN_ACNT(currentRow.getPAPD_MAIN_ACNT_CODE(), "N","E");
            	if(list!= null && list.size()>0){
            		currentRow.setUI_M_MAIN_ACNT_CODE_DESC(list.get(0));
            	}
                L_VAL_SUB_ACCOUNT();
            }else{
                currentRow.setUI_M_MAIN_ACNT_CODE_DESC("");
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void L_VAL_SUB_ACCOUNT() throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
    	Connection connection = null;
    	connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = null;
    	handler = new CRUDHandler();
    	String  M_FLAG=null;
    	String  M_ACTY_HEAD_1=null;
    	String  M_ACTY_HEAD_2=null;
    	ResultSet resultSet = null;
        try{
            String sql_C1="SELECT MAIN_CTL_ACNT_FLAG FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = ? ";
            Object[] values = {currentRow.getPAPD_MAIN_ACNT_CODE()};
            resultSet = handler.executeSelectStatement(sql_C1, connection, values);
            if(resultSet.next()){
                M_FLAG=resultSet.getString(1);
            }else{
            	M_FLAG="X";
            }
            
            if(M_FLAG!="C"){
            	currentRow.setPAPD_SUB_ACNT_CODE_INSERT(false);
            	currentRow.setPAPD_SUB_ACNT_CODE_REQUIRED(false);
                if(currentRow.getPAPD_SUB_ACNT_CODE() != null){
                	currentRow.setPAPD_SUB_ACNT_CODE(null);
                	currentRow.setPAPD_SUB_ACNT_CODE(null);
                }
            }else{
            	currentRow.setPAPD_SUB_ACNT_CODE_INSERT(true);
            	currentRow.setPAPD_SUB_ACNT_CODE_REQUIRED(true);
                //:PT_IL_PAYVOU_PAY_DTL.PAPD_SUB_ACNT_CODE=:PT_IL_PAYVOU_PAY_DTL.PAPD_SUB_ACNT_CODE;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }finally{
            try{
            	CommonUtils.closeCursor(resultSet);
            }catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_sub_acnt_code_when_validate_item() 
    	throws ValidatorException {
	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
	DBProcedures dbProcedures = new DBProcedures();
        try{
            if(currentRow.getPAPD_SUB_ACNT_CODE() != null){
            	ArrayList<String> list = dbProcedures.P_VAL_SUB_ACNT(currentRow.getPAPD_MAIN_ACNT_CODE(), currentRow.getPAPD_SUB_ACNT_CODE(), "N","E");
            	if(list!= null && list.size()>0){
            		currentRow.setUI_M_SUB_ACNT_DESC(list.get(0));
            	}
            }else{
                currentRow.setUI_M_SUB_ACNT_DESC("");
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_anly_code_1_when_validate_item() 
	    	throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
		DBProcedures dbProcedures = new DBProcedures();
	    try{
	        if(currentRow.getPAPD_ANLY_CODE_1() != null){
	        	ArrayList<String> list = dbProcedures.P_VAL_ANLY("1", currentRow.getPAPD_ANLY_CODE_1(), "N","E");
	        	if(list!= null && list.size()>0){
	        		currentRow.setUI_M_ANLY_DESC1(list.get(0));
	        	}
	        }else{
	            currentRow.setUI_M_ANLY_DESC1("");
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	        throw new ValidatorException(new FacesMessage(e.getMessage()));
	    }
    }

    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_anly_code_2_when_validate_item() 
    	throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
		DBProcedures dbProcedures = new DBProcedures();
        try{
            if(currentRow.getPAPD_ANLY_CODE_2() != null){
            	ArrayList<String> list = dbProcedures.P_VAL_ANLY("2", currentRow.getPAPD_ANLY_CODE_2(), "N","E");
	        	if(list!= null && list.size()>0){
	        		currentRow.setUI_M_ANLY_DESC2(list.get(0));
	        	}
            }else{
            	currentRow.setUI_M_ANLY_DESC2("");
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }

    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_payee_anly_code_1_when_validate_item() 
      throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
		DBProcedures dbProcedures = new DBProcedures();
        try{
            if(currentRow.getPAPD_PAYEE_ANLY_CODE_1() != null) {
            	ArrayList<String> list = dbProcedures.P_VAL_ANLY("1", currentRow.getPAPD_PAYEE_ANLY_CODE_1(), "N","E");
	        	if(list!= null && list.size()>0){
	        		currentRow.setUI_M_PAYEE_ANLY_DESC1(list.get(0));
	        	}
            }else{
            	currentRow.setUI_M_PAYEE_ANLY_DESC1("");
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_payee_anly_code_2_when_validate_item() 
    	throws ValidatorException  {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
		DBProcedures dbProcedures = new DBProcedures();
        try{
            if(currentRow.getPAPD_PAYEE_ANLY_CODE_2() != null){
            	ArrayList<String> list = dbProcedures.P_VAL_ANLY("2", currentRow.getPAPD_PAYEE_ANLY_CODE_2(), "N","E");
	        	if(list!= null && list.size()>0){
	        		currentRow.setUI_M_PAYEE_ANLY_DESC2(list.get(0));
	        	}
            }
            else{
            	currentRow.setUI_M_PAYEE_ANLY_DESC2("");
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_acty_code_1_when_validate_item() 
    throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
        try{
            if(currentRow.getPAPD_ACTY_CODE_1() != null){
            	ArrayList<String> list = new DBProcedures().P_VAL_ACTY(currentRow.getPAPD_MAIN_ACNT_CODE(), currentRow.getPAPD_ACTY_CODE_1(), "N","E");
            	if(list!= null && list.size()>0){
            		currentRow.setUI_M_ACTY_DESC1(list.get(0));
            	}
            }else{
                currentRow.setUI_M_ACTY_DESC1("");
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void pilt030_apac_pt_il_payvou_pay_dtl_papd_acty_code_2_when_validate_item() 
    throws ValidatorException {
    	PT_IL_PAYVOU_PAY_DTL currentRow = getBeanInstance();
        try{
            if(currentRow.getPAPD_ACTY_CODE_2() != null){
            	ArrayList<String> list = new DBProcedures().P_VAL_ACTY(currentRow.getPAPD_MAIN_ACNT_CODE(), currentRow.getPAPD_ACTY_CODE_2(), "N","E");
            	if(list!= null && list.size()>0){
            		currentRow.setUI_M_ACTY_DESC1(list.get(0));
            	}
            }else{
            	currentRow.setUI_M_ACTY_DESC1("");
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }
    
    public void addNewButton(){
    	PT_IL_PAYVOU_PAY_DTL_ACTION payDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_LIST();
    	PT_IL_PAYVOU_PAY_DTL payDtlBean = null;
    	payDtlAction.getErrorMap().clear();
    	payDtlAction.getWarningMap().clear();
    	try {
        	if(payDtlList!=null){
    	    	for(PT_IL_PAYVOU_PAY_DTL dtlBean: payDtlList){
    	    		String ROWID = dtlBean.getROWID();
    	    		if(ROWID==null){
    	    			return;
    	    		}
    	    	}
    	    	payDtlBean = whenCreateRecord();
    	    	payDtlList.add(payDtlBean);
        	}else{
        		payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
        		payDtlBean = whenCreateRecord();
    	    	payDtlList.add(payDtlBean);
        	}
		} catch (Exception e) {
			payDtlAction.getWarningMap().put("current", e.getMessage());
			payDtlAction.setWarningMessages(e.getMessage());
		}
    }
    
    public void removeButton(){
    	
    }
    
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_ACTY_CODE_1(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	PT_IL_PAYVOU_PAY_DTL payDtlBean = getCurrentRowInstance();
    	String PAPD_MAIN_ACNT_CODE = payDtlBean.getPAPD_MAIN_ACNT_CODE();
    	String query = "SELECT AVAL_CODE,AVAL_VALUE_NAME,AVAL_BL_VALUE_NAME FROM FM_ACTY_VALUE " +
    			"WHERE AVAL_ACTY_CODE=?";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{PAPD_MAIN_ACNT_CODE});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_ACTY_CODE_1(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_ACTY_DESC1(rst.getString(2));
				}else{
					dtlBean.setUI_M_ACTY_DESC1(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_ACTY_CODE_2(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	PT_IL_PAYVOU_PAY_DTL payDtlBean = getCurrentRowInstance();
    	String PAPD_MAIN_ACNT_CODE = payDtlBean.getPAPD_MAIN_ACNT_CODE();
    	String query = "SELECT AVAL_CODE,AVAL_VALUE_NAME,AVAL_BL_VALUE_NAME FROM FM_ACTY_VALUE " +
    			"WHERE AVAL_ACTY_CODE=?";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{PAPD_MAIN_ACNT_CODE});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_ACTY_CODE_2(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_ACTY_DESC2(rst.getString(2));
				}else{
					dtlBean.setUI_M_ACTY_DESC2(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_ANLY_CODE_1(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT ANLY_CODE,ANLY_NAME,ANLY_BL_NAME FROM FM_ANALYSIS " +
    			"WHERE ANLY_HEAD_NO = ? AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{"1"});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_ANLY_CODE_1(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_ANLY_DESC1(rst.getString(2));
				}else{
					dtlBean.setUI_M_ANLY_DESC1(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_ANLY_CODE_2(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT ANLY_CODE,ANLY_NAME,ANLY_BL_NAME FROM FM_ANALYSIS " +
    			"WHERE ANLY_HEAD_NO = ? AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{"1"});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_ANLY_CODE_2(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_ANLY_DESC2(rst.getString(2));
				}else{
					dtlBean.setUI_M_ANLY_DESC2(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_BANK_CODE(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT BANK_CODE,BANK_NAME,BANK_NAME_BL FROM FM_BANK";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_BANK_CODE(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_BANK_DESC(rst.getString(2));
				}else{
					dtlBean.setUI_M_BANK_DESC(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_CITY_CODE(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT PC_CODE,PC_DESC,PC_BL_DESC FROM PM_CODES " +
    			"WHERE PC_TYPE = ? AND NVL(PC_FRZ_FLAG,'N') = 'N'";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{"CITY"});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_CITY_CODE(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_CITY_DESC(rst.getString(2));
				}else{
					dtlBean.setUI_M_CITY_DESC(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_CLE_ZONE_CODE(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT PC_CODE,PC_DESC,PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = ?";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{"CLE_ZONE"});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_CLE_ZONE_CODE(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_PAPD_CLE_ZONE_DESC(rst.getString(2));
				}else{
					dtlBean.setUI_M_PAPD_CLE_ZONE_DESC(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_DES_MTD_CODE(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT PC_CODE,PC_DESC,PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = ?";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{"DES_MTD"});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_DES_MTD_CODE(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_PAPD_DES_MTD_DESC(rst.getString(2));
				}else{
					dtlBean.setUI_M_PAPD_DES_MTD_DESC(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_MAIN_ACNT_CODE(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT MAIN_ACNT_CODE,MAIN_ACNT_NAME,MAIN_BL_ACNT_NAME FROM FM_MAIN_ACCOUNT " +
    			"WHERE NVL(MAIN_FRZ_FLAG,'N') = 'N'";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_MAIN_ACNT_CODE(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_MAIN_ACNT_CODE_DESC(rst.getString(2));
				}else{
					dtlBean.setUI_M_MAIN_ACNT_CODE_DESC(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_OFF_AREA_CODE(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT PC_CODE,PC_DESC,PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = ?";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{"POSTAL"});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_OFF_AREA_CODE(rst.getString(1));
				/*if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.set(rst.getString(2));
				}else{
					dtlBean.set(rst.getString(2));
				}*/
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_PAYEE_ANLY_CODE_1(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT ANLY_CODE,ANLY_NAME,ANLY_BL_NAME FROM FM_ANALYSIS " +
    			"WHERE ANLY_HEAD_NO = ? AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{"1"});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_PAYEE_ANLY_CODE_1(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_PAYEE_ANLY_DESC1(rst.getString(2));
				}else{
					dtlBean.setUI_M_PAYEE_ANLY_DESC1(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_PAYEE_ANLY_CODE_2(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT ANLY_CODE,ANLY_NAME,ANLY_BL_NAME FROM FM_ANALYSIS " +
    			"WHERE ANLY_HEAD_NO = ? AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{"2"});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_PAYEE_ANLY_CODE_2(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_PAYEE_ANLY_DESC2(rst.getString(2));
				}else{
					dtlBean.setUI_M_PAYEE_ANLY_DESC2(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_STATE_CODE(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	String query = "SELECT PC_CODE,PC_DESC,PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = ? AND NVL(PC_FRZ_FLAG,'N') = 'N'";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{"STATE"});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_STATE_CODE(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_STATE_DESC(rst.getString(2));
				}else{
					dtlBean.setUI_M_STATE_DESC(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    public List<PT_IL_PAYVOU_PAY_DTL> PAPD_SUB_ACNT_CODE(String value) throws ValidatorException {
    	if(value!=null){
    		if(value.equals("*")){
    			value = "%";
    		}else{
    			value += "%";
    		}
    	}
    	List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
    	PT_IL_PAYVOU_PAY_DTL payDtlBean = getCurrentRowInstance();
    	String PAPD_MAIN_ACNT_CODE = payDtlBean.getPAPD_MAIN_ACNT_CODE();
    	String query = "SELECT SUB_ACNT_CODE,SUB_ACNT_NAME,SUB_BL_ACNT_NAME " +
    			"FROM FM_SUB_ACCOUNT " +
    			"WHERE SUB_ACNT_CODE IN (" +
    			"SELECT MS_SUB_ACNT_CODE " +
    			"FROM  FM_MAIN_SUB " +
    			"WHERE MS_MAIN_ACNT_CODE = ?) " +
    			"AND NVL(SUB_FRZ_FLAG,'N') = 'N'";
    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet rst = null;
    	try {
    		ControlBean controlBean = CommonUtils.getControlBean();
			rst = handler.executeSelectStatement(query, connection, new Object[]{PAPD_MAIN_ACNT_CODE});
			payDtlList = new ArrayList<PT_IL_PAYVOU_PAY_DTL>();
			while(rst.next()){
				PT_IL_PAYVOU_PAY_DTL dtlBean = new PT_IL_PAYVOU_PAY_DTL();
				dtlBean.setPAPD_SUB_ACNT_CODE(rst.getString(1));
				if(controlBean.getM_LANG_CODE().equals("ENG")){
					dtlBean.setUI_M_SUB_ACNT_DESC(rst.getString(2));
				}else{
					dtlBean.setUI_M_SUB_ACNT_DESC(rst.getString(2));
				}
				payDtlList.add(dtlBean);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return payDtlList;
    }
    
    public int saveRecord(PT_IL_PAYVOU_PAY_DTL payDtlBean) throws ValidatorException {
    	Connection connection  = PILT030_APAC_ACTION_INSTANCE.getConnection();
    	CRUDHandler handler = new CRUDHandler();
    	int result = 0;
    	try {
			result = handler.executeInsert(payDtlBean, connection);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return result;
    }
    
    public PT_IL_PAYVOU_PAY_DTL getCurrentRowInstance(){
    	PT_IL_PAYVOU_PAY_DTL_ACTION payDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouPayDtlActionInstance();
    	int rowIndex = payDtlAction.getPT_IL_PAYVOU_PAY_DTL_DT().getRowIndex();
    	return payDtlAction.getPT_IL_PAYVOU_PAY_DTL_LIST().get(rowIndex);
    }
    
}
