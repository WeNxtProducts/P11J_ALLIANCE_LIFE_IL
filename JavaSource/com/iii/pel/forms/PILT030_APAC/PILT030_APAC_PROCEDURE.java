package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILT030_APAC_PROCEDURE {
	
	public void  L_PRO_FRZ() throws ValidatorException {
		Map<String, Object> sessionMap = PILT030_APAC_ACTION_INSTANCE.getSessionMap();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		BP_ACTION bpAction = PILT030_APAC_ACTION_INSTANCE.getBpActionInstance();
		DUMMY dummyBean = dummyAction.getDUMMY_BEAN();
		try
        {
            String M_REF_NO_FM=null;
            String M_REF_NO_TO=null;
            String M_CLAIM_NO_FM=null;
            String M_CLAIM_NO_TO=null;
            String M_CUST_FM=null;
            String M_CUST_TO=null;
            String M_STATUS_FM=null;
            String M_STATUS_TO=null;
            Date M_FM_DATE=null;
            Date M_TO_DATE=null;
            String M_PAH_TYPE=dummyBean.getUI_M_PAH_TYPE();
            String M_DUMMY_ITEM=null;
        	PT_IL_PAYVOU_HDR_ACTION payvouHdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
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
                new PILT030_APAC_PROCEDURE().p9ilpk_payment_voucher_ins_payvou_hdr_drcr_dtl(M_REF_NO_FM,
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
											                		null);
            }
            catch(Exception se){
            	se.printStackTrace();
            	throw new ValidatorException(new FacesMessage(se.getMessage()));
            }
            Double M_PAH_SYS_ID = dummyBean.getUI_M_PAH_SYS_ID();
            System.out.println("M_PAH_SYS_ID********&&&&&&&&&&&&&&&&"+M_PAH_SYS_ID);
            sessionMap.put("GLOBAL.M_PAH_SYS_ID", M_PAH_SYS_ID);
            if(M_PAH_SYS_ID== null)
            {
               /* SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_REF_NO = '"+:GLOBAL.M_CLAIM_NO+"' AND  PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
                EXECUTE_QUERY.EXECUTE_QUERY();*/
            	new PT_IL_PAYVOU_HDR_HELPER().executeQuery();
            }
            else
            {
//                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(3206,:GLOBAL.M_LANG_CODE,"PROCESSED RECORDS SUCCESSFULLY");
//                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_SYS_ID = "+:DUMMY.M_PAH_SYS_ID+" AND  PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
//                EXECUTE_QUERY.EXECUTE_QUERY();
            	payvouHdrAction.getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"PROCESSED RECORDS SUCCESSFULLY"}));
            	new PT_IL_PAYVOU_HDR_HELPER().executeQuery();
            }
//            :BP.B_PROCESSING_MSG=" ";
            bpAction.getBP_BEAN().setB_PROCESSING_MSG(" ");
            if(M_PAH_SYS_ID != null)
            {
               /* if(:SYSTEM.FORM_STATUS=="CHANGED")
                {
                    STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
                    throw new FORM_TRIGGER_FAILURE();
                }*/
//                :BP.B_PROCESSING_MSG="FREEZING RECORDS WAIT ... ";
            	bpAction.getBP_BEAN().setB_PROCESSING_MSG("FREEZING RECORDS WAIT ... ");
//                SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("BP.B_PROCESSING_MSG",VISIBLE,PROPERTY_TRUE);
            	Integer PAH_SYS_ID = payvouHdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
            	sessionMap.put("GLOBAL.M_PAH_SYS_ID", PAH_SYS_ID);
            	System.out.println("PAH_SYS_ID********&&&&&&&&&&&&&&&&"+PAH_SYS_ID);
                try{
                	new PILT030_APAC_PROCEDURE().p9ilpk_payment_voucher_ins_payvou_amt_dtl(PAH_SYS_ID+"");
                }
                catch(Exception se){
                	se.printStackTrace();
                	throw new ValidatorException(new FacesMessage(se.getMessage()));
                }
//                GO_ITEM.GO_ITEM("PT_IL_PAYVOU_HDR.PAH_FM_DT");
//                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_SYS_ID = "+:PT_IL_PAYVOU_HDR.PAH_SYS_ID+" AND  PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
//                EXECUTE_QUERY.EXECUTE_QUERY();
                new PT_IL_PAYVOU_HDR_HELPER().executeQuery();
//                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DEFAULT_WHERE,"PAH_TYPE = "+"'"+:DUMMY.M_PAH_TYPE+"'");
//                :BP.B_PROCESSING_MSG="FREEZING IS COMPLETED";
                bpAction.getBP_BEAN().setB_PROCESSING_MSG(" ");
//                :BP.B_PROCESSING_MSG="";
            }
        }catch(Exception e)
        {
           throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}

	public Double p9ilpk_payment_voucher_ins_payvou_hdr_drcr_dtl(String M_REF_NO_FM,
																	String M_REF_NO_TO,
																	String M_CLAIM_NO_FM,
																	String M_CLAIM_NO_TO,
																	String M_CUST_FM,
																	String M_CUST_TO,
																	String M_STATUS_FM,
																	String M_STATUS_TO,
																	Date M_FM_DATE,
																	Date M_TO_DATE,
																	String M_PAH_TYPE,
																	Double M_PAH_SYS_ID) throws SQLException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String fmDate = df.format(M_FM_DATE);
		String toDate = df.format(M_TO_DATE);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("1", "STRING", "IN", M_REF_NO_FM);
		OracleParameter param2 = new OracleParameter("2", "STRING", "IN", M_REF_NO_TO);
		OracleParameter param3 = new OracleParameter("3", "STRING", "IN", M_CLAIM_NO_FM);
		OracleParameter param4 = new OracleParameter("4", "STRING", "IN", M_CLAIM_NO_TO);
		OracleParameter param5 = new OracleParameter("5", "STRING", "IN", M_CUST_FM);
		OracleParameter param6 = new OracleParameter("6", "STRING", "IN", M_CUST_TO);
		OracleParameter param7 = new OracleParameter("7", "STRING", "IN", M_STATUS_FM);
		OracleParameter param8 = new OracleParameter("8", "STRING", "IN", M_STATUS_TO);
		OracleParameter param9 = new OracleParameter("9", "STRING", "IN", fmDate);
		OracleParameter param10 = new OracleParameter("10", "STRING", "IN", toDate);
		OracleParameter param11 = new OracleParameter("11", "STRING", "IN", M_PAH_TYPE);
		OracleParameter param12 = new OracleParameter("12", "STRING", "OUT", M_PAH_SYS_ID+"");
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		parameterList.add(param7);
		parameterList.add(param8);
		parameterList.add(param9);
		parameterList.add(param10);
		parameterList.add(param11);
		parameterList.add(param12);
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			ArrayList<OracleParameter> outputList = handler.execute(parameterList, connection, "p9ilpk_payment_voucher.ins_payvou_hdr_drcr_dtl");
			String pah_sys_id = outputList.get(0).getValue();
			if(pah_sys_id!=null)
				M_PAH_SYS_ID = new Double(pah_sys_id);
			dummyAction.getDUMMY_BEAN().setUI_M_PAH_SYS_ID(M_PAH_SYS_ID);
		} catch (Exception e) {
			throw new SQLException(e);
		}
		return M_PAH_SYS_ID;
	}
		
	public void p9ilpk_payment_voucher_ins_payvou_amt_dtl(String P_PAH_SYS_ID) throws SQLException {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("1", "STRING", "IN", P_PAH_SYS_ID);
		parameterList.add(param1);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		try {
			handler.execute(parameterList, connection, "p9ilpk_payment_voucher.ins_payvou_amt_dtl");
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public void p9ilpk_payment_voucher_payvou_approval(String P_PAH_SYS_ID) throws SQLException {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("1", "STRING", "IN", P_PAH_SYS_ID);
		parameterList.add(param1);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		try {
			handler.execute(parameterList, connection, "p9ilpk_payment_voucher.payvou_approval");
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public void p9ilpk_payment_voucher_payvou_housecheque(String P_PAH_SYS_ID) throws SQLException {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("1", "STRING", "IN", P_PAH_SYS_ID);
		parameterList.add(param1);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		try {
			handler.execute(parameterList, connection, "p9ilpk_payment_voucher.payvou_housecheque");
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public ArrayList<OracleParameter> P_VAL_CUST(Connection connection, String in1, String inout1, 
				String in2, String in3, String in4) throws ValidatorException {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN", in1);
		OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT", inout1);
		OracleParameter param3 = new OracleParameter("in2","STRING","IN", in2);
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", in3);
		OracleParameter param5 = new OracleParameter("in4","STRING","IN", in4);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		ArrayList<OracleParameter> outputList = null;
		try {
			outputList = handler.execute(parameterList, connection, "P_VAL_CUST");
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return outputList;
	}
	
	public String P_VAL_CODES(Connection connection,String CODE_TYPE,String CODE, String desc, 
				String flag1,String flag2, String flag3) throws ValidatorException
	{
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList  = new ArrayList<OracleParameter>();
		String output = null;
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",CODE_TYPE);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",CODE);
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT",desc);
		OracleParameter param4 = new OracleParameter("in3","STRING","IN", flag1);
		OracleParameter param5 = new OracleParameter("in4","STRING","IN",flag2);
		OracleParameter param6 = new OracleParameter("in5","STRING","IN",flag3);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection, "P_VAL_CODES");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:"+oracleParameter.getValue());
				output = oracleParameter.getValue();
				desc = output;
			}
		} catch (Exception e1) {
			throw new ValidatorException(new FacesMessage(e1.getMessage()));
		}
		return output;
	}
	
	 public String P_VAL_MAIN_ACNT(Connection connection, 
			 												String P_MAIN_ACNT_CODE,
															String P_MAIN_ACNT_NAME,
															String P_NAME_FLAG,
															String P_ERR_FLAG) throws ValidatorException {
	        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	        ArrayList<String> returnList = new ArrayList<String>();
	        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_MAIN_ACNT_CODE);
	        parameterList.add(param1);
	        OracleParameter param2 = new OracleParameter("IN OUT2", "STRING", "IN OUT",P_MAIN_ACNT_NAME);
	        parameterList.add(param2);
	        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_NAME_FLAG);
	        parameterList.add(param3);
	        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_ERR_FLAG);
	        parameterList.add(param4);

	        OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        try {
				outputList = procHandler.execute(parameterList, connection,
				        "P_VAL_MAIN_ACNT");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	        Iterator<OracleParameter> iterator = outputList.iterator();
	        while (iterator.hasNext()) {
	            OracleParameter oracleParameter = iterator.next();
	            System.out.println("Output value:::" + oracleParameter.getValue());
	            P_MAIN_ACNT_NAME = oracleParameter.getValue();
	        }
	        return P_MAIN_ACNT_NAME;
	    }
	 
	    public String P_VAL_SUB_ACNT(Connection connection, 
										            String P_MAIN_ACNT_CODE,
													String P_SUB_ACNT_CODE,
													String P_SUB_ACNT_NAME,
													String P_NAME_FLAG,
													String P_ERR_FLAG) throws ValidatorException {
	        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_MAIN_ACNT_CODE);
	        parameterList.add(param1);
	        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_SUB_ACNT_CODE);
	        parameterList.add(param2);
	        OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_SUB_ACNT_NAME);
	        parameterList.add(param3);
	        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
	        parameterList.add(param4);
	        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
	        parameterList.add(param5);

	        OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        try {
				outputList = procHandler.execute(parameterList, connection,
				        "P_VAL_SUB_ACNT");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	        Iterator<OracleParameter> iterator = outputList.iterator();
	        while (iterator.hasNext()) {
	            OracleParameter oracleParameter = iterator.next();
	            System.out.println("Output value:::" + oracleParameter.getValue());
	            P_SUB_ACNT_NAME = oracleParameter.getValue();
	        }
	        return P_SUB_ACNT_NAME;
	    }
	    
	    public String P_VAL_ANLY(Connection connection, 
									            String P_ANLY_HEAD_NO,
												String P_ANLY_CODE,
												String P_ANLY_NAME,
												String P_NAME_FLAG,
												String P_ERR_FLAG) throws ValidatorException {
	        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_ANLY_HEAD_NO);
	        parameterList.add(param1);
	        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_ANLY_CODE);
	        parameterList.add(param2);
	        OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_ANLY_NAME);
	        parameterList.add(param3);
	        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
	        parameterList.add(param4);
	        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
	        parameterList.add(param5);

	        OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        try {
				outputList = procHandler.execute(parameterList, connection,
				        "P_VAL_ANLY");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	        Iterator<OracleParameter> iterator = outputList.iterator();
	        while (iterator.hasNext()) {
	            OracleParameter oracleParameter = iterator.next();
	            System.out.println("Output value:::" + oracleParameter.getValue());
	            P_ANLY_NAME = oracleParameter.getValue();
	        }
	        return P_ANLY_NAME;
	    }

	    public String P_VAL_ACTY(Connection connection,
								            String P_ACTY_HEAD,
											String P_ACTY_CODE,
											String P_ACTY_NAME,
											String P_NAME_FLAG,
											String P_ERR_FLAG) throws ValidatorException {
	        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_ACTY_HEAD);
	        parameterList.add(param1);
	        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_ACTY_CODE);
	        parameterList.add(param2);
	        OracleParameter param3 = new OracleParameter("IN OUT3", "STRING", "IN OUT",P_ACTY_NAME);
	        parameterList.add(param3);
	        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_NAME_FLAG);
	        parameterList.add(param4);
	        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_ERR_FLAG);
	        parameterList.add(param5);

	        OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        try {
				outputList = procHandler.execute(parameterList, connection,
				        "P_VAL_ACTY");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	        Iterator<OracleParameter> iterator = outputList.iterator();
	        while (iterator.hasNext()) {
	            OracleParameter oracleParameter = iterator.next();
	            System.out.println("Output value:::" + oracleParameter.getValue());
	            P_ACTY_NAME = oracleParameter.getValue();
	        }
	        return P_ACTY_NAME;
	    }

	    public void IL_UNIQUE_MODE_PAYEE(PT_IL_PAYVOU_PAY_DTL payDtlBean) throws ValidatorException {
	    	CRUDHandler handler = new CRUDHandler();
	    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
	    	PT_IL_PAYVOU_AMT_DTL_ACTION amtDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouAmtDtlActionInstance();
	    	PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
	    	String PAPD_PAY_MODE = payDtlBean.getPAPD_PAY_MODE();
	    	String PAPD_PAYEE_NAME = payDtlBean.getPAPD_PAYEE_NAME();
	    	Double PAPD_SYS_ID = payDtlBean.getPAPD_SYS_ID();
	    	String ROWID = payDtlBean.getROWID();
	    	Integer PAD_SYS_ID = amtDtlAction.getPT_IL_PAYVOU_AMT_DTL_BEAN().getPAD_SYS_ID();
	    	Integer PAH_SYS_ID = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
	    	try
	        {
	            String M_PAPD_PAY_MODE=null;
	            String sql_C1="SELECT 'X' FROM  PT_IL_PAYVOU_PAY_DTL  " +
	            		"WHERE  PAPD_PAY_MODE  = ?  " +
	            		"AND PAPD_PAYEE_NAME  = ? " +
	            		"AND PAPD_SYS_ID  = ? " +
	            		"AND PAPD_PAD_SYS_ID  = ? " +
	            		"AND PAPD_PAH_SYS_ID  = ? ";
	            ResultSet vembu_C1=null;
	            String sql_C2="SELECT 'X' FROM  PT_IL_PAYVOU_PAY_DTL  " +
	            		"WHERE  PAPD_PAY_MODE  = ?  " +
	            		"AND PAPD_PAYEE_NAME  = ? " +
	            		"AND PAPD_PAD_SYS_ID  = ? " +
	            		"AND PAPD_PAH_SYS_ID  = ? " +
	            		"AND ROWID  <> ?";
	            ResultSet vembu_C2=null;
	            if(false)
	            {
	                vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{PAPD_PAY_MODE, PAPD_PAYEE_NAME, PAPD_SYS_ID, PAD_SYS_ID, PAH_SYS_ID});
	                if(vembu_C1.next())
	                {
	                    M_PAPD_PAY_MODE=vembu_C1.getString(1);
	                }
	                if(!vembu_C1.isLast())
	                {
	                	CommonUtils.closeCursor(vembu_C1);
	                	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "90015", new Object[]{"PAYMENT MODE AND PAYEE NAME IS "}));
	                }
	                CommonUtils.closeCursor(vembu_C1);
	            }
	            else
	            {
	                vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{PAPD_PAY_MODE, PAPD_PAYEE_NAME, PAD_SYS_ID, PAH_SYS_ID, ROWID});
	                if(vembu_C2.next())
	                {
	                    M_PAPD_PAY_MODE=vembu_C2.getString(1);
	                }
	                if(!vembu_C2.isLast())
	                {
	                	CommonUtils.closeCursor(vembu_C2);
	                	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "90015", new Object[]{"PAYMENT MODE AND PAYEE NAME IS "}));
	                }
	                CommonUtils.closeCursor(vembu_C2);
	            }
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw new ValidatorException(new FacesMessage(e.getMessage()));
	        }
	    }
	    
	    public void L_VALIDATE_PAY_MODE_NULL(PT_IL_PAYVOU_PAY_DTL payDtlBean) throws ValidatorException {
	    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
	    	CRUDHandler handler = new CRUDHandler();
	    	String PAPD_BANK_ACC_NO = payDtlBean.getPAPD_BANK_ACC_NO();
	    	String PAPD_BANK_CODE = payDtlBean.getPAPD_BANK_CODE();
	    	String PAPD_CLE_ZONE_CODE = payDtlBean.getPAPD_CLE_ZONE_CODE();
	    	String PAPD_DES_MTD_CODE = payDtlBean.getPAPD_DES_MTD_CODE();
	    	String PAPD_PAY_MODE = payDtlBean.getPAPD_PAY_MODE();
	    	 try
	         {
	             Double  /** METADATA NOT FOUND *********/ M_PC_VALUE=null;
	             String sql_C9="SELECT PC_VALUE FROM  PM_CODES  " +
	             		"WHERE  PC_CODE  = ? " +
	             		"AND PC_TYPE  = 'IL_CPAY_MODE' ";
	             ResultSet vembu_C9=null;
	             vembu_C9=handler.executeSelectStatement(sql_C9, connection, new Object[]{PAPD_PAY_MODE});
	             if(vembu_C9.next())
	             {
	                 M_PC_VALUE=vembu_C9.getDouble(1);
	             }
	             CommonUtils.closeCursor(vembu_C9);
	             if((M_PC_VALUE==null?0.0:M_PC_VALUE)==4.0)
	             {
	                 /*SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PAYVOU_PAY_DTL.PAPD_BANK_ACC_NO",REQUIRED,PROPERTY_TRUE);
	                 SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PAYVOU_PAY_DTL.PAPD_BANK_CODE",REQUIRED,PROPERTY_TRUE);*/
	                 if(PAPD_BANK_ACC_NO== null)
	                 {
	                	 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "19050"));
	                 }
	                 else if(PAPD_BANK_CODE== null)
	                 {
	                	 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "19050"));
	                 }
	             }
	             else if((M_PC_VALUE==null?0.0:M_PC_VALUE)==2.0)
	             {
	                 /*SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PAYVOU_PAY_DTL.PAPD_CLE_ZONE_CODE",REQUIRED,PROPERTY_TRUE);
	                 SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PAYVOU_PAY_DTL.PAPD_DES_MTD_CODE",REQUIRED,PROPERTY_TRUE);*/
	                 if(PAPD_CLE_ZONE_CODE== null)
	                 {
	                	 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "19050"));
	                 }
	                 else if(PAPD_DES_MTD_CODE== null)
	                 {
	                	 throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "19050"));
	                 }
	             }
	             else
	             {
	                 /*SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PAYVOU_PAY_DTL.PAPD_BANK_ACC_NO",REQUIRED,PROPERTY_FALSE);
	                 SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PAYVOU_PAY_DTL.PAPD_BANK_CODE",REQUIRED,PROPERTY_FALSE);
	                 SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PAYVOU_PAY_DTL.PAPD_CLE_ZONE_CODE",REQUIRED,PROPERTY_FALSE);
	                 SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_PAYVOU_PAY_DTL.PAPD_DES_MTD_CODE",REQUIRED,PROPERTY_FALSE);*/
	             }
	         }catch(Exception e)
	         {
	             e.printStackTrace();
	             throw new ValidatorException(new FacesMessage(e.getMessage()));
	         }
	    }
	    
	    public PT_IL_PAYVOU_PAY_DTL L_INS_PAY_DTL(PT_IL_PAYVOU_PAY_DTL payDtlBean) throws ValidatorException {
	    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
	    	PT_IL_PAYVOU_AMT_DTL_ACTION amtDtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouAmtDtlActionInstance();
	    	CRUDHandler handler = new CRUDHandler();
	    	Integer PAD_SYS_ID = amtDtlAction.getPT_IL_PAYVOU_AMT_DTL_BEAN().getPAD_SYS_ID();
	    	Double PAPD_LC_PAY_AMT = payDtlBean.getPAPD_LC_PAY_AMT();
	    	ControlBean ctrlBean = CommonUtils.getControlBean();
	    	try
	        {
	            String sql_C1="SELECT 'X', NVL(:PT_IL_PAYVOU_AMT_DTL.PAD_FC_BAL_AMT, 0) - SUM(NVL(PAPD_FC_PAY_AMT, 0)) " +
	            		"FROM  PT_IL_PAYVOU_PAY_DTL  " +
	            		"WHERE  PAPD_PAD_SYS_ID  = ? ";
	            ResultSet vembu_C1=null;
	            String sql_C2="SELECT  'X',  PAPD_PAY_MODE,    PAPD_PAYEE_NAME,    PAPD_CURR_CODE,    " +
	            		"PAPD_BANK_ACC_NO,    PAPD_PAYEE_ADDR1,    PAPD_PAYEE_ADDR2,    " +
	            		"PAPD_PAYEE_ADDR3,    PAPD_BANK_CODE,    PAPD_CLE_ZONE_CODE,    " +
	            		"PAPD_DES_MTD_CODE,    PAPD_MAIN_ACNT_CODE,    PAPD_SUB_ACNT_CODE,    " +
	            		"PAPD_ANLY_CODE_1,    PAPD_ANLY_CODE_2,    PAPD_ACTY_CODE_1,    " +
	            		"PAPD_ACTY_CODE_2,    PAPD_PAYEE_ANLY_CODE_1,    PAPD_PAYEE_ANLY_CODE_2 " +
	            		"FROM  PT_IL_PAYVOU_PAY_DTL  " +
	            		"WHERE  PAPD_PAD_SYS_ID  = ?";
	            ResultSet vembu_C2=null;
	            Double  /** METADATA NOT FOUND *********/ M_PAPD_FC_PAY_AMT=null;
	            String M_TEMP = null;
	            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{PAD_SYS_ID});
	            if(vembu_C1.next())
	            {
	                M_PAPD_FC_PAY_AMT=vembu_C1.getDouble(1);
	            }
	            CommonUtils.closeCursor(vembu_C1);
	            if(M_TEMP!=null)
	            {
	                payDtlBean.setPAPD_FC_PAY_AMT(M_PAPD_FC_PAY_AMT);
	                payDtlBean.setPAPD_LC_PAY_AMT(M_PAPD_FC_PAY_AMT);
	             // Commented to avoid compilation error, Dated: 15-Feb, Commented by: Manoj
	                //new PILT006_APAC_PROCEDURE().callP_VAL_ROUND_AMT(connection, ctrlBean.getM_BASE_CURR(),PAPD_LC_PAY_AMT,"R");
	                vembu_C1=handler.executeSelectStatement(sql_C2, connection, new Object[]{PAD_SYS_ID});
	                M_TEMP = null;
	                if(vembu_C2.next())
	                {
	                	M_TEMP = vembu_C2.getString(1);
	    				payDtlBean.setPAPD_PAY_MODE(vembu_C2.getString("PAPD_PAY_MODE"));
	    				payDtlBean.setPAPD_PAYEE_NAME(vembu_C2.getString("PAPD_PAYEE_NAME"));
	    				payDtlBean.setPAPD_PAYEE_ADDR1(vembu_C2.getString("PAPD_PAYEE_ADDR1"));
	    				payDtlBean.setPAPD_PAYEE_ADDR2(vembu_C2.getString("PAPD_PAYEE_ADDR2"));
	    				payDtlBean.setPAPD_PAYEE_ADDR3(vembu_C2.getString("PAPD_PAYEE_ADDR3"));
	    				payDtlBean.setPAPD_CURR_CODE(vembu_C2.getString("PAPD_CURR_CODE"));
	    				payDtlBean.setPAPD_BANK_CODE(vembu_C2.getString("PAPD_BANK_CODE"));
	    				payDtlBean.setPAPD_BANK_ACC_NO(vembu_C2.getString("PAPD_BANK_ACC_NO"));
	    				payDtlBean.setPAPD_CLE_ZONE_CODE(vembu_C2.getString("PAPD_CLE_ZONE_CODE"));
	    				payDtlBean.setPAPD_DES_MTD_CODE(vembu_C2.getString("PAPD_DES_MTD_CODE"));
	    				payDtlBean.setPAPD_MAIN_ACNT_CODE(vembu_C2.getString("PAPD_MAIN_ACNT_CODE"));
	    				payDtlBean.setPAPD_SUB_ACNT_CODE(vembu_C2.getString("PAPD_SUB_ACNT_CODE"));
	    				payDtlBean.setPAPD_ANLY_CODE_1(vembu_C2.getString("PAPD_ANLY_CODE_1"));
	    				payDtlBean.setPAPD_ANLY_CODE_2(vembu_C2.getString("PAPD_ANLY_CODE_2"));
	    				payDtlBean.setPAPD_ACTY_CODE_1(vembu_C2.getString("PAPD_ACTY_CODE_1"));
	    				payDtlBean.setPAPD_ACTY_CODE_2(vembu_C2.getString("PAPD_ACTY_CODE_2"));
	    				payDtlBean.setPAPD_PAYEE_ANLY_CODE_1(vembu_C2.getString("PAPD_PAYEE_ANLY_CODE_1"));
	    				payDtlBean.setPAPD_PAYEE_ANLY_CODE_2(vembu_C2.getString("PAPD_PAYEE_ANLY_CODE_2"));
	                }
	                if(M_TEMP==null)
	                {
	                	payDtlBean.setPAPD_PAY_MODE("C");
	                }
	                CommonUtils.closeCursor(vembu_C2);
	            }
	            else
	            {
	            	throw new Exception();
	            }
	        }catch(Exception e)
	        {
	            throw new ValidatorException(new FacesMessage(e.getMessage()));
	        }
	        return payDtlBean;
	    }
	    
	    public Object P_SET_FIRST_FIELD(Object fieldName) throws ValidatorException {
	    	if(fieldName==null || fieldName.equals("")){
	    		if(fieldName instanceof String){
	    			fieldName = "0";
	    		}else if(fieldName instanceof Double){
	    			fieldName = new Double(0.0);
	    		}
	    	}
	    	return fieldName;
	    }
	    
	    public Object P_SET_SECOND_FIELD(Object fieldName) throws ValidatorException {
	    	if(fieldName==null || fieldName.equals("")){
	    		if(fieldName instanceof String){
	    			fieldName = "zzzzzzzzzzzzzzzzzzzzzz";
	    		}else if(fieldName instanceof Double){
	    			fieldName = new Double(9999999999999999999999.0);
	    		}
	    	}
	    	return fieldName;
	    }
	    
	    public void L_INS_PAY_COMMIT() throws ValidatorException {
	    	Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
	    	DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
	    	PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
	    	Integer PAH_SYS_ID = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
	    	CRUDHandler handler = new CRUDHandler();
	    	String UI_M_PAH_TYPE = dummyAction.getDUMMY_BEAN().getUI_M_PAH_TYPE();
	    	try
	        {
	            Double  /** METADATA NOT FOUND *********/ M_PAD_FC_BAL_AMT=null;
	            String  /** METADATA NOT FOUND *********/ M_PAD_CUST_CODE=null;
	            Double  /** METADATA NOT FOUND *********/ M_TOT_PAPD_FC_PAY_AMT=null;
	            Double  /** METADATA NOT FOUND *********/ M_PAPD_FC_PAY_AMT=null;
	            Double  /** METADATA NOT FOUND *********/ M_PIL_PAPD_SYS_ID=null;
	            Double  /** METADATA NOT FOUND *********/ M_PAD_SYS_ID=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_PYMT_TYPE=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_BANK_CODE=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_BANK_CODE1=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_ADDR1=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_ADDR2=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_ADDR3=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_ADDR4=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_CLE_ZONE_CODE=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_CLE_ZONE_CODE1=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_DES_MTD_CODE=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_DES_MTD_CODE1=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_ALT_PAYEE_NAME=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_ALT_PAYEE_NAME1=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_BANK_AC_NO=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_BANK_AC_NO1=null;
	            String  /** METADATA NOT FOUND *********/ M_CUST_NAME=null;
	            String  /** METADATA NOT FOUND *********/ M_PS_VALUE=null;
	            Double  /** METADATA NOT FOUND *********/ M_PC_VALUE=null;
	            String  /** METADATA NOT FOUND *********/ M_CURR_CODE=null;
	            String  /** METADATA NOT FOUND *********/ M_MAIN_ACNT_CODE=null;
	            String  /** METADATA NOT FOUND *********/ M_SUB_ACNT_CODE=null;
	            String  /** METADATA NOT FOUND *********/ M_ANLY_CODE_1=null;
	            String  /** METADATA NOT FOUND *********/ M_ANLY_CODE_2=null;
	            String  /** METADATA NOT FOUND *********/ M_PAYEE_ANLY_CODE_1=null;
	            String  /** METADATA NOT FOUND *********/ M_PAYEE_ANLY_CODE_2=null;
	            String  /** METADATA NOT FOUND *********/ M_ACTY_CODE_1=null;
	            String  /** METADATA NOT FOUND *********/ M_ACTY_CODE_2=null;
	            String  /** METADATA NOT FOUND *********/ M_DIVN_CODE=null;
	            String  /** METADATA NOT FOUND *********/ M_DEPT_CODE=null;
	            String  /** METADATA NOT FOUND *********/ M_ACC_DIVN_CODE=null;
	            String sql_C1="SELECT    PAD_CUST_CODE,    SUM(NVL(PAD_FC_BAL_AMT, 0)) " +
	            		"FROM  PT_IL_PAYVOU_AMT_DTL  " +
	            		"WHERE  PAD_PAH_SYS_ID  = ? " +
	            		"GROUP BY  PAD_CUST_CODE  ";
	            String sql_C1A="SELECT    PAPD_PAD_SYS_ID,    SUM(PAPD_FC_PAY_AMT) FROM  PT_IL_PAYVOU_PAY_DTL  " +
	            		"WHERE  PAPD_PAH_SYS_ID  = ?  " +
	            		"AND PAPD_CUST_CODE  = ? GROUP BY  PAPD_PAD_SYS_ID  ";
	            String sql_C2="SELECT PIL_PAPD_SYS_ID.NEXTVAL FROM  DUAL  ";
	            String sql_C3="SELECT    CUST_NAME,    CUST_PYMT_TYPE,    CUST_BANK_CODE,    " +
	            		"CUST_BANK_AC_NO,    CCUR_CURR_CODE,    CUST_ADDR1,    CUST_ADDR2,    " +
	            		"CUST_ADDR3,    CUST_CLE_ZONE_CODE,    CUST_DES_MTD_CODE,    NVL(CUST_ALT_PAYEE_NAME, CUST_NAME) " +
	            		"FROM  PM_CUSTOMER,   PM_CUST_CURR  " +
	            		"WHERE  CUST_CODE  = CCUR_CUST_CODE  " +
	            		"AND CUST_CODE  = ? ";
	            String sql_C4="SELECT PC_VALUE FROM  PM_CODES  WHERE  PC_TYPE  = 'IL_CPAY_MODE'  " +
	            		"AND PC_CODE  = ? ";
	            String sql_C5="SELECT PAD_SYS_ID FROM  PT_IL_PAYVOU_AMT_DTL  " +
	            		"WHERE  PAD_PAH_SYS_ID  = ?  " +
	            		"AND PAD_CUST_CODE  = ? ";
	            ResultSet vembu_C1=null;
	            ResultSet vembu_C1A=null;
	            ResultSet vembu_C2=null;
	            ResultSet vembu_C3=null;
	            ResultSet vembu_C4=null;
	            ResultSet vembu_C5=null;
	            vembu_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{PAH_SYS_ID});
	            while((true))
	            {
	                if(vembu_C1.next())
	                {
	                    M_PAD_CUST_CODE=vembu_C1.getString(1);
	                    M_PAD_FC_BAL_AMT=vembu_C1.getDouble(2);
	                }
	                if(vembu_C1.isAfterLast() || vembu_C1.isBeforeFirst())
	                break;
	                M_TOT_PAPD_FC_PAY_AMT=null;
	                if(vembu_C1A!=null)
	                {
	                    vembu_C1A.close();
	                }
	                vembu_C1A=handler.executeSelectStatement(sql_C1A, connection, new Object[]{PAH_SYS_ID, M_PAD_CUST_CODE});
	                if(vembu_C1A.next())
	                {
	                    M_PAD_SYS_ID=vembu_C1A.getDouble(1);
	                    M_TOT_PAPD_FC_PAY_AMT=vembu_C1A.getDouble(2);
	                }
	                vembu_C1A.close();
	                if((M_PAD_FC_BAL_AMT==null?0.0:M_PAD_FC_BAL_AMT)-(M_TOT_PAPD_FC_PAY_AMT==null?0.0:M_TOT_PAPD_FC_PAY_AMT)>0.0)
	                {
	                    M_PAPD_FC_PAY_AMT=(M_PAD_FC_BAL_AMT==null?0.0:M_PAD_FC_BAL_AMT)-(M_TOT_PAPD_FC_PAY_AMT==null?0.0:M_TOT_PAPD_FC_PAY_AMT);
	                    ControlBean ctrlBean = CommonUtils.getControlBean();
	                    ArrayList<String> amtList = null; 
	                 // Commented to avoid compilation error, Dated: 15-Feb, Commented by: Manoj
	                    //amtList = new PILT006_APAC_PROCEDURE().callP_VAL_ROUND_AMT(connection, ctrlBean.getM_BASE_CURR(),M_PAPD_FC_PAY_AMT,"R");
	                    String amtValue = amtList.get(0);
	                    M_PAPD_FC_PAY_AMT = new Double(amtValue==null?"0.0":amtValue);
	                    vembu_C2 = handler.executeSelectStatement(sql_C2, connection, new Object[]{});
	                    if(vembu_C2.next())
	                    {
	                        M_PIL_PAPD_SYS_ID=vembu_C2.getDouble(1);
	                    }
	                    CommonUtils.closeCursor(vembu_C2);
	                    String sql_vembu1="UPDATE   PT_IL_PAYVOU_PAY_DTL    SET (PAPD_FC_PAY_AMT,PAPD_LC_PAY_AMT,PAPD_UPD_DT,PAPD_UPD_UID) = (SELECT    NVL(PAPD_FC_PAY_AMT, 0) + NVL(M_PAPD_FC_PAY_AMT, 0),    NVL(PAPD_FC_PAY_AMT, 0) + NVL(M_PAPD_FC_PAY_AMT, 0),    SYSDATE,    :GLOBAL.M_USER_ID FROM  PT_IL_PAYVOU_PAY_DTL  WHERE  PAPD_SYS_ID  =  (   SELECT MIN(PAPD_SYS_ID)  FROM  PT_IL_PAYVOU_PAY_DTL   WHERE  PAPD_PAH_SYS_ID  = :PT_IL_PAYVOU_HDR.PAH_SYS_ID   AND PAPD_CUST_CODE  = M_PAD_CUST_CODE  ) )  WHERE  PAPD_SYS_ID  =  (   SELECT MIN(PAPD_SYS_ID)  FROM  PT_IL_PAYVOU_PAY_DTL   WHERE  PAPD_PAH_SYS_ID  = :PT_IL_PAYVOU_HDR.PAH_SYS_ID   AND PAPD_CUST_CODE  = "+M_PAD_CUST_CODE+"  )  ";
	                    int ROWCOUNT = handler.executeUpdateStatement(sql_vembu1, connection, new Object[]{});
	                    if(ROWCOUNT==0)
	                    {
	                        M_PAD_SYS_ID=null;
	                        vembu_C3 = handler.executeSelectStatement(sql_C3, connection, new Object[]{M_PAD_CUST_CODE});
	                        if(vembu_C3.next())
	                        {
	                            M_CUST_NAME=vembu_C3.getString(1);
	                            M_CUST_PYMT_TYPE=vembu_C3.getString(2);
	                            M_CUST_BANK_CODE=vembu_C3.getString(3);
	                            M_CUST_BANK_AC_NO=vembu_C3.getString(4);
	                            M_CURR_CODE=vembu_C3.getString(5);
	                            M_CUST_ADDR1=vembu_C3.getString(6);
	                            M_CUST_ADDR2=vembu_C3.getString(7);
	                            M_CUST_ADDR3=vembu_C3.getString(8);
	                            M_CUST_CLE_ZONE_CODE=vembu_C3.getString(9);
	                            M_CUST_DES_MTD_CODE=vembu_C3.getString(10);
	                            M_CUST_ALT_PAYEE_NAME=vembu_C3.getString(11);
	                        }
	                        CommonUtils.closeCursor(vembu_C3);
	                        vembu_C4=handler.executeSelectStatement(sql_C4, connection, new Object[]{M_CUST_PYMT_TYPE});
	                        if(vembu_C4.next())
	                        {
	                            M_PC_VALUE=vembu_C4.getDouble(1);
	                        }
	                        CommonUtils.closeCursor(vembu_C4);
	                        vembu_C5=handler.executeSelectStatement(sql_C5, connection, new Object[]{PAH_SYS_ID, M_PAD_CUST_CODE});
	                        if(vembu_C5.next())
	                        {
	                            M_PAD_SYS_ID=vembu_C5.getDouble(1);
	                        }
	                        CommonUtils.closeCursor(vembu_C5);
	                        if(M_PC_VALUE==4)
	                        {
	                            M_CUST_BANK_CODE1=M_CUST_BANK_CODE;
	                            M_CUST_BANK_AC_NO1=M_CUST_BANK_AC_NO;
	                            M_CUST_CLE_ZONE_CODE1=null;
	                            M_CUST_DES_MTD_CODE1=null;
	                        }
	                        else if(M_PC_VALUE==2)
	                        {
	                            M_CUST_BANK_CODE1=null;
	                            M_CUST_BANK_AC_NO1=null;
	                            M_CUST_CLE_ZONE_CODE1=M_CUST_CLE_ZONE_CODE;
	                            M_CUST_DES_MTD_CODE1=M_CUST_DES_MTD_CODE;
	                        }
	                        else
	                        {
	                            M_CUST_BANK_CODE1=null;
	                            M_CUST_BANK_AC_NO1=null;
	                            M_CUST_CLE_ZONE_CODE1=null;
	                            M_CUST_DES_MTD_CODE1=null;
	                        }
	                        try{
	                        	String dfltValue = (String) PILT030_APAC_ACTION_INSTANCE.getSessionMap().get("GLOBAL.M_DFLT_VALUES");
	                        	if(dfltValue!=null && dfltValue.length()>4){
	                        		M_ACC_DIVN_CODE=dfltValue.substring(4, 6);
	                        	}
	                        	P9ILPK_ACNT_PROC_GET_PYMT_ACNT_SETUP(M_ACC_DIVN_CODE,UI_M_PAH_TYPE,"P",M_CUST_PYMT_TYPE,null,M_CUST_BANK_CODE1,"E",M_MAIN_ACNT_CODE,M_SUB_ACNT_CODE,M_DIVN_CODE,M_DEPT_CODE,M_PAYEE_ANLY_CODE_1,M_PAYEE_ANLY_CODE_2,M_ACTY_CODE_1,M_ACTY_CODE_2, null);
	                        	P9ILPK_ACNT_PROC_GET_PYMT_ACNT_SETUP(M_ACC_DIVN_CODE,UI_M_PAH_TYPE,"P",M_CUST_PYMT_TYPE,null,M_CUST_BANK_CODE1,"R",M_MAIN_ACNT_CODE,M_SUB_ACNT_CODE,M_DIVN_CODE,M_DEPT_CODE,M_ANLY_CODE_1,M_ANLY_CODE_2,M_ACTY_CODE_1,M_ACTY_CODE_2, null);
	                        }
	                        catch(Exception se){
	                            throw new ValidatorException(new FacesMessage(se.getMessage()));
	                        }
	                        if(UI_M_PAH_TYPE.equals("AG"))
	                        {
	                            M_CUST_ALT_PAYEE_NAME1=M_CUST_ALT_PAYEE_NAME;
	                        }
	                        else
	                        {
	                            M_CUST_ALT_PAYEE_NAME1=M_CUST_NAME;
	                        }
	                        String sql_vembu2="INSERT INTO  PT_IL_PAYVOU_PAY_DTL      ( PAPD_SYS_ID ,    PAPD_PAD_SYS_ID ,    PAPD_CUST_CODE ,    PAPD_PAY_MODE ,    PAPD_PAYEE_NAME ,    PAPD_PAYEE_ADDR1 ,    PAPD_PAYEE_ADDR2 ,    PAPD_PAYEE_ADDR3 ,    PAPD_CURR_CODE ,    PAPD_FC_PAY_AMT ,    PAPD_LC_PAY_AMT ,    PAPD_BANK_CODE ,    PAPD_BANK_ACC_NO ,    PAPD_CLE_ZONE_CODE ,    PAPD_DES_MTD_CODE ,    PAPD_MAIN_ACNT_CODE ,    PAPD_SUB_ACNT_CODE ,    PAPD_ANLY_CODE_1 ,    PAPD_ANLY_CODE_2 ,    PAPD_ACTY_CODE_1 ,    PAPD_ACTY_CODE_2 ,    PAPD_CR_DT ,    PAPD_CR_UID ,    PAPD_PAH_SYS_ID ,    PAPD_PAYEE_ANLY_CODE_1 ,    PAPD_PAYEE_ANLY_CODE_2 )    " +
	                        		"VALUES   ( "+M_PIL_PAPD_SYS_ID+" ,    "+M_PAD_SYS_ID+" ,    "+M_PAD_CUST_CODE+" ,    "+M_CUST_PYMT_TYPE+" ,    "+M_CUST_ALT_PAYEE_NAME1+" ,    "+M_CUST_ADDR1+" ,    "+M_CUST_ADDR2+" ,    "+M_CUST_ADDR3+" ,    "+M_CURR_CODE+" ,    "+M_PAPD_FC_PAY_AMT+" ,    "+M_PAPD_FC_PAY_AMT+" ,    "+M_CUST_BANK_CODE1+" ,    "+M_CUST_BANK_AC_NO1+" ,    "+M_CUST_CLE_ZONE_CODE1+" ,    "+M_CUST_DES_MTD_CODE1+" ,    "+M_MAIN_ACNT_CODE+" ,    "+M_SUB_ACNT_CODE+" ,    "+M_ANLY_CODE_1+" ,    "+M_ANLY_CODE_2+" ,    "+M_ACTY_CODE_1+" ,    "+M_ACTY_CODE_2+" ,    SYSDATE ,    :GLOBAL.M_USER_ID ,    :PT_IL_PAYVOU_HDR.PAH_SYS_ID ,    "+M_PAYEE_ANLY_CODE_1+" ,    "+M_PAYEE_ANLY_CODE_2+" )   ";
	                        ROWCOUNT=handler.executeInsertStatement(sql_vembu2, connection);
	                    }
	                }
	                else if((M_PAD_FC_BAL_AMT==null?0.0:M_PAD_FC_BAL_AMT)-(M_TOT_PAPD_FC_PAY_AMT==null?0.0:M_TOT_PAPD_FC_PAY_AMT)<0)
	                {
	                    throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91383", new Object[]{M_PAD_CUST_CODE}));
	                }
	            }
	            CommonUtils.closeCursor(vembu_C1);
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw new ValidatorException(new FacesMessage(e.getMessage()));
	        }
	    }
	    
	    public ArrayList<String> P9ILPK_ACNT_PROC_GET_PYMT_ACNT_SETUP(String P_DIVN_CODE,
															String P_DEPT_CODE,
															String P_TXN_TYPE,
															String P_PYMT_TYPE,
															String P_CUST_BANK_CODE,
															String P_COMP_BANK_CODE,
															String P_ASSURED_TYPE,
															String P_MAIN_ACNT_CODE,
															String P_SUB_ACNT_CODE,
															String P_F_DIVN_CODE,
															String P_F_DEPT_CODE,
															String P_ANLY_CODE_1,
															String P_ANLY_CODE_2,
															String P_ACTY_CODE_1,
															String P_ACTY_CODE_2,
															String P_VALUE) throws ValidatorException {
	        Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
	        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	        ArrayList<String> returnList = new ArrayList<String>();
	        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DIVN_CODE);
	        parameterList.add(param1);
	        OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DEPT_CODE);
	        parameterList.add(param2);
	        OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_TXN_TYPE);
	        parameterList.add(param3);
	        OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_PYMT_TYPE);
	        parameterList.add(param4);
	        OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CUST_BANK_CODE);
	        parameterList.add(param5);
	        OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_COMP_BANK_CODE);
	        parameterList.add(param6);
	        OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_ASSURED_TYPE);
	        parameterList.add(param7);
	        OracleParameter param8 = new OracleParameter("OUT8", "STRING", "OUT","");
	        parameterList.add(param8);
	        OracleParameter param9 = new OracleParameter("OUT9", "STRING", "OUT","");
	        parameterList.add(param9);
	        OracleParameter param10 = new OracleParameter("OUT10", "STRING", "OUT","");
	        parameterList.add(param10);
	        OracleParameter param11 = new OracleParameter("OUT11", "STRING", "OUT","");
	        parameterList.add(param11);
	        OracleParameter param12 = new OracleParameter("OUT12", "STRING", "OUT","");
	        parameterList.add(param12);
	        OracleParameter param13 = new OracleParameter("OUT13", "STRING", "OUT","");
	        parameterList.add(param13);
	        OracleParameter param14 = new OracleParameter("OUT14", "STRING", "OUT","");
	        parameterList.add(param14);
	        OracleParameter param15 = new OracleParameter("OUT15", "STRING", "OUT","");
	        parameterList.add(param15);
	        OracleParameter param16 = new OracleParameter("IN16", "STRING", "IN",P_VALUE);
	        parameterList.add(param16);

	        OracleProcedureHandler procHandler = new OracleProcedureHandler();
	        try {
				outputList = procHandler.execute(parameterList, connection,"P9ILPK_ACNT_PROC.GET_PYMT_ACNT_SETUP");
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	        Iterator<OracleParameter> iterator = outputList.iterator();
	        while (iterator.hasNext()) {
	            OracleParameter oracleParameter = iterator.next();
	            System.out.println("Output value:::" + oracleParameter.getValue());
	            returnList.add(oracleParameter.getValue());
	        }
	        return returnList;
	    }
	    

}
