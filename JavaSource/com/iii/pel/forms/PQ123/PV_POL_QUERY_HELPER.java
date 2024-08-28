package com.iii.pel.forms.PQ123;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PV_POL_QUERY_HELPER {
	
	/**
	 * 
	 * @param compositeAction
	 * @param PV_POL_QUERY_BEAN
	 * @throws Exception
	 */
	public void populateDetails(PV_POL_QUERY_COMPOSITE compositeAction,PV_POL_QUERY PV_POL_QUERY_BEAN) throws Exception{
		PV_POL_QUERY_DELEGATE delegate = new PV_POL_QUERY_DELEGATE();
		try{
			compositeAction.getPM_CUSTOMER_ACTION().setPM_CUSTOMER_BEAN(delegate.customerDetails(compositeAction,PV_POL_QUERY_BEAN));
			compositeAction.getPV_CLM_QUERY_ACTION().setDataList_PV_CLM_QUERY(delegate.claimDetails(PV_POL_QUERY_BEAN));
			//compositeAction.getPV_FAC_IN_QUERY_ACTION().setPV_FAC_IN_QUERY_BEAN((PV_FAC_IN_QUERY) delegate.facInDetails(PV_POL_QUERY_BEAN));//TODO
		}catch(Exception exception){
			throw exception;
		}
	}
	/**
	 * 
	 * @param compositeAction
	 */
	public void whenNewRecordInstance(PV_POL_QUERY_COMPOSITE compositeAction) throws Exception{
		Double polSysId = compositeAction.getPV_POL_QUERY_ACTION().getPV_POL_QUERY_BEAN().getPOL_SYS_ID();
		Connection connection =null;
		CRUDHandler handler =null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
		ResultSet C7_REC = null;
		ResultSet C8_REC = null;
		ResultSet C9_REC = null;
		ResultSet C10_REC = null;
		ResultSet C11_REC = null;
		ResultSet C12_REC = null;
		ResultSet C13_REC = null;
		ResultSet C14_REC = null;
		ResultSet C15_REC = null;
		ResultSet C16_REC = null;
		ResultSet C17_REC = null;
		ResultSet C18_REC = null;
		
		Double M_TOT_PREM=0.0;
		Double M_TOT_CHARGE=0.0;
		Double M_TOT_DISC=0.0;
		Double M_TOT_LOAD=0.0;
		Double M_ORGI_FC_SI=0.0;
		Double M_ORGI_LC_SI=0.0;
		Double M_ORGI_FC_PREM =0.0;
		Double M_ORGI_LC_PREM=0.0;
		Double M_TOT_PREM1=0.0;
		Double M_TOT_DISC1=0.0;
		Double M_TOT_LOAD1=0.0;
		Double M_TOT_CHARGE1=0.0;
		Double M_ORGI_FC_SI1=0.0;
		Double M_ORGI_LC_SI1=0.0;
		Double M_ORGI_FC_PREM1=0.0;
		Double M_ORGI_LC_PREM1=0.0;
		Double M_TOT_PREM2=0.0;
		Double M_TOT_CHARGE2=0.0;
		Double M_TOT_DISC2=0.0;
		Double M_TOT_LOAD2=0.0;
		Double M_ORGI_FC_SI2=0.0;
		Double M_ORGI_LC_SI2=0.0;
		Double M_ORGI_FC_PREM2=0.0;
		Double M_ORGI_LC_PREM2=0.0;
		Double M_OUR_SHARE_PER=0.0;
		Double M_OUR_SHARE_FC_SI=0.0;
		Double M_OUR_SHARE_LC_SI =0.0;
		Double M_OUR_SHARE_PREM_FC=0.0;
		Double M_OUR_SHARE_PREM_LC =0.0;
		Double M_COMMISSION_PAID_FC=0.0;
		Double M_COMMISSION_PAID_LC =0.0;
		Double M_RISK_ID =0.0;
		Double M_TOTAL_LC_SI  =0.0;
		Double M_TOTAL_LC_PREM  =0.0;
		String M_CUST_CODE =null;
		String M_CUST_NAME  =null;
		Double M_SHAREPER =null;
		Double M_RETRO =0.0;
		Double M_RETRO_FC_SI  =0.0;
		
		String C1 = "SELECT NVL(POL_FC_PREM,0) FROM   PT_GL_POLICY WHERE  POL_SYS_ID = ? ";
		String C2 = "SELECT SUM (NVL(POL_LC_ADDL_PREM,0)+ NVL(POL_LC_BASIC_PREM,0))	FROM   PT_IL_POLICY	WHERE  POL_SYS_ID = ?";
		String C3 = "SELECT NVL(RISK_FC_PREM,0), NVL(RISK_FC_DISC,0), NVL(RISK_FC_LOAD,0)  FROM   PT_RISK  WHERE  RISK_POL_SYS_ID = ?";
		String C4 = "SELECT NVL(SUM(PDL_LC_DISC_LOAD_VALUE),0) FROM   PT_GL_POL_DISC_LOAD WHERE  " +
				"PDL_POL_SYS_ID = ? AND    PDL_APPLY_LEVEL IN ('E','P') AND    PDL_DISC_LOAD_TYPE = 'C'";
		String C5 = "SELECT NVL(SUM(PDL_LC_DISC_LOAD_VALUE),0)	FROM   PT_GL_POL_DISC_LOAD WHERE  PDL_POL_SYS_ID = ? AND PDL_APPLY_LEVEL IN ('E','P') AND PDL_DISC_LOAD_TYPE = 'D'";
		String C6 = "SELECT NVL(SUM(PDL_LC_DISC_LOAD_VALUE),0)	FROM   PT_GL_POL_DISC_LOAD "+
					"WHERE  PDL_POL_SYS_ID = ? AND    PDL_APPLY_LEVEL IN ('E','P') AND    PDL_DISC_LOAD_TYPE = 'L'";
		String C7 = "SELECT NVL(SUM(PDL_LC_DISC_LOAD_VALUE),0)	FROM   PT_GL_POL_DISC_LOAD WHERE  PDL_POL_SYS_ID = ? AND PDL_APPLY_LEVEL IN ('E','P') "+
					"AND PDL_DISC_LOAD_TYPE = 'L'";
		String C8 = "SELECT NVL(CHG_FC_VALUE,0) FROM   PT_POL_CHARGE WHERE  CHG_POL_SYS_ID = ?";
		String C9 = "SELECT NVL(PDL_FC_DISC_LOAD_VALUE,0) FROM   PT_IL_POL_DISC_LOAD  WHERE  PDL_POL_SYS_ID = ? "+
					"AND    PDL_DISC_LOAD_TYPE = 'D'";
		String C10 = "SELECT NVL(PDL_FC_DISC_LOAD_VALUE,0) FROM   PT_IL_POL_DISC_LOAD "+
						"WHERE  PDL_POL_SYS_ID = ? AND    PDL_DISC_LOAD_TYPE = 'L'";
		String C11 = "SELECT  NVL(POC_LC_VALUE,0) FROM    PT_IL_POL_CHARGE WHERE   POC_POL_SYS_ID = ?";
		String C12 = "";
		String C13 = "";
		String C14 = "";
		String C15 = "";
		String C16 = "";
		String C17 = "	SELECT NVL(RISK_ID,0),NVL(RISK_FC_PREM,0), "
				+ " NVL(RISK_FC_SI,0),NVL(FI_SHARE_PERC,0) "
				+ "FROM   PT_RISK, PT_FAC_IN WHERE  RISK_POL_SYS_ID = ? "
				+ "AND    FI_POL_SYS_ID = ? ";
		String C18 = "	SELECT NVL(FPCU_CUST_CODE,0), " + "	       CUST_NAME, "
				+ "	       NVL(FPCU_SHARE_PERC,0), "
				+ "	       NVL(FPCU_RETRO_SHARE_PERC,0), "
				+ "	       NVL(FPCU_RETRO_FC_SI,0) "
				+ "FROM   PT_FAC_PART_CUST, PM_CUSTOMER,  PT_FAC_OUT, "
				+ "     PT_POLICY " + "WHERE FO_POL_SYS_ID = POL_SYS_ID "
				+ "AND   FPCU_FO_SYS_ID =FO_SYS_ID "
				+ "AND   POL_SYS_ID = ? "
				+ "AND   CUST_CODE = FPCU_CUST_CODE";
		Object obj[] =new Object[]{polSysId};
		
		PREMIUM PREMIUM_BEAN = compositeAction.getPREMIUM_ACTION().getPREMIUM_BEAN();
		FAC_CO_INS FAC_CO_INS_BEAN = null;//compositeAction.getFAC_CO_INS_ACTION().getFAC_CO_INS_BEAN();
		List<FAC_CO_INS> listFAC = new ArrayList<FAC_CO_INS>();
		
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			if("GL".equalsIgnoreCase(compositeAction.getPV_POL_QUERY_ACTION().getPV_POL_QUERY_BEAN().getPOL_MODULE())){
				C1_REC = handler.executeSelectStatement(C1, connection,obj);
				if(C1_REC.next()){
					M_TOT_PREM = C1_REC.getDouble(1);
				}
				PREMIUM_BEAN.setTOT_PREM(CommonUtils.nvl(M_TOT_PREM, 0.0));
				
				C4_REC = handler.executeSelectStatement(C4, connection,obj);
				if(C4_REC.next()){
					M_TOT_CHARGE = C4_REC.getDouble(1);
				}
				PREMIUM_BEAN.setTOT_CHARGES(CommonUtils.nvl(M_TOT_CHARGE, 0.0));
				
				C5_REC = handler.executeSelectStatement(C5, connection,obj);
				if(C5_REC.next()){
					M_TOT_DISC = C5_REC.getDouble(1);
				}
				PREMIUM_BEAN.setTOT_DISCOUNT(CommonUtils.nvl(M_TOT_DISC, 0.0));
				
				C6_REC = handler.executeSelectStatement(C6, connection,obj);
				if(C6_REC.next()){
					M_TOT_LOAD = C6_REC.getDouble(1);
				}
				PREMIUM_BEAN.setTOT_LOADING(CommonUtils.nvl(M_TOT_LOAD, 0.0));
				
				PREMIUM_BEAN.setSUB_TOT_PREM(CommonUtils.nvl(PREMIUM_BEAN.getTOT_PREM(), 0.0) - CommonUtils.nvl(PREMIUM_BEAN.getTOT_DISCOUNT(), 0) - CommonUtils.nvl(PREMIUM_BEAN.getTOT_LOADING(), 0));
				PREMIUM_BEAN.setNET_PREM(CommonUtils.nvl(PREMIUM_BEAN.getSUB_TOT_PREM(), 0.0) + CommonUtils.nvl(PREMIUM_BEAN.getTOT_PREM(), 0));
				
			}else if("IL".equalsIgnoreCase(compositeAction.getPV_POL_QUERY_ACTION().getPV_POL_QUERY_BEAN().getPOL_MODULE())){
				
				C2_REC = handler.executeSelectStatement(C2, connection,obj);
				if(C2_REC.next()){
					M_TOT_PREM1 = C2_REC.getDouble(1);
				}
				PREMIUM_BEAN.setTOT_PREM(CommonUtils.nvl(M_TOT_PREM1, 0.0));
				
				C9_REC = handler.executeSelectStatement(C9, connection,obj);
				if(C9_REC.next()){
					M_TOT_DISC1 = C9_REC.getDouble(1);
				}
				PREMIUM_BEAN.setTOT_DISCOUNT(CommonUtils.nvl(M_TOT_DISC1, 0.0));
				
				C10_REC = handler.executeSelectStatement(C10, connection,obj);
				if(C10_REC.next()){
					M_TOT_LOAD1 = C10_REC.getDouble(1);
				}
				PREMIUM_BEAN.setTOT_LOADING(CommonUtils.nvl(M_TOT_LOAD1, 0.0));
				
				C11_REC = handler.executeSelectStatement(C11, connection,obj);
				if(C11_REC.next()){
					M_TOT_CHARGE1 = C11_REC.getDouble(1);
				}
				PREMIUM_BEAN.setTOT_CHARGES(CommonUtils.nvl(M_TOT_CHARGE1, 0.0));
				
				PREMIUM_BEAN.setSUB_TOT_PREM(CommonUtils.nvl(PREMIUM_BEAN.getTOT_PREM(), 0.0) - CommonUtils.nvl(PREMIUM_BEAN.getTOT_DISCOUNT(), 0) - CommonUtils.nvl(PREMIUM_BEAN.getTOT_LOADING(), 0));
				PREMIUM_BEAN.setNET_PREM(CommonUtils.nvl(PREMIUM_BEAN.getSUB_TOT_PREM(), 0.0) + CommonUtils.nvl(PREMIUM_BEAN.getTOT_PREM(), 0));
			}else if("GI".equalsIgnoreCase(compositeAction.getPV_POL_QUERY_ACTION().getPV_POL_QUERY_BEAN().getPOL_MODULE())){
				C3_REC = handler.executeSelectStatement(C3, connection,obj);
				if(C3_REC.next()){
					M_TOT_PREM2 = C3_REC.getDouble(1);
					M_TOT_DISC2 = C3_REC.getDouble(2);
					M_TOT_LOAD2 = C3_REC.getDouble(3);
				}
				PREMIUM_BEAN.setTOT_PREM(CommonUtils.nvl(M_TOT_PREM2, 0.0));
				PREMIUM_BEAN.setTOT_DISCOUNT(CommonUtils.nvl(M_TOT_DISC2, 0.0));
				PREMIUM_BEAN.setTOT_LOADING(CommonUtils.nvl(M_TOT_LOAD2, 0.0));
				
				C8_REC = handler.executeSelectStatement(C8, connection,obj);
				if(C8_REC.next()){
					M_TOT_CHARGE2 = C8_REC.getDouble(1);
				}
				PREMIUM_BEAN.setTOT_CHARGES(CommonUtils.nvl(M_TOT_CHARGE2, 0.0));
				
				C17_REC = handler.executeSelectStatement(C17, connection,new Object[]{polSysId,polSysId});
				while(C17_REC.next()){
					FAC_CO_INS_BEAN = new FAC_CO_INS();
					M_RISK_ID = C17_REC.getDouble(1);
					M_TOTAL_LC_SI = C17_REC.getDouble(2);
					M_TOTAL_LC_PREM = C17_REC.getDouble(3);
					M_OUR_SHARE_PER = C17_REC.getDouble(4);
					FAC_CO_INS_BEAN.setRISK_ID(CommonUtils.nvl(M_RISK_ID, 0.0));
					FAC_CO_INS_BEAN.setTOTAL_LC_SI(CommonUtils.nvl(M_TOTAL_LC_SI, 0.0));
					FAC_CO_INS_BEAN.setTOTAL_LC_PREM(CommonUtils.nvl(M_TOTAL_LC_PREM, 0.0));
					FAC_CO_INS_BEAN.setTOTAL_FAC_PER(CommonUtils.nvl(M_OUR_SHARE_PER, 0.0));
					listFAC.add(FAC_CO_INS_BEAN);
				}
				compositeAction.getFAC_CO_INS_ACTION().setDataList_FAC_CO_INS(listFAC);
				if(listFAC!=null){
					listFAC.clear();
				}
				boolean valid = true;
				C18_REC = handler.executeSelectStatement(C18, connection,new Object[]{polSysId,polSysId});
				while(C18_REC.next()){
					valid = false;
					FAC_CO_INS_BEAN = new FAC_CO_INS();
					M_CUST_CODE = C17_REC.getString(1);
					M_CUST_NAME = C17_REC.getString(2);
					M_SHAREPER = C17_REC.getDouble(3);
					M_RETRO = C17_REC.getDouble(4);
					M_RETRO_FC_SI = C17_REC.getDouble(5);
					FAC_CO_INS_BEAN.setCUST_CODE(M_CUST_CODE);
					FAC_CO_INS_BEAN.setSHAREPER(CommonUtils.nvl(M_SHAREPER, 0.0));
					FAC_CO_INS_BEAN.setRETRO(CommonUtils.nvl(M_RETRO, 0.0));
					FAC_CO_INS_BEAN.setRETRO_LC_SI(CommonUtils.nvl(M_RETRO_FC_SI, 0.0));
					FAC_CO_INS_BEAN.setCUST_NAME(M_CUST_NAME);
					
					listFAC.add(FAC_CO_INS_BEAN);
					compositeAction.getFAC_CO_INS_ACTION().setDataList_FAC_CO_INS_PARTI_COM(listFAC);
					
					PREMIUM_BEAN.setSUB_TOT_PREM(CommonUtils.nvl(PREMIUM_BEAN.getTOT_PREM(), 0.0) - CommonUtils.nvl(PREMIUM_BEAN.getTOT_DISCOUNT(), 0) - CommonUtils.nvl(PREMIUM_BEAN.getTOT_LOADING(), 0));
					PREMIUM_BEAN.setNET_PREM(CommonUtils.nvl(PREMIUM_BEAN.getSUB_TOT_PREM(), 0.0) + CommonUtils.nvl(PREMIUM_BEAN.getTOT_PREM(), 0));
				}
				
				if(valid){
					FAC_CO_INS_BEAN = new FAC_CO_INS();
					FAC_CO_INS_BEAN.setRISK_ID(0.0);
					FAC_CO_INS_BEAN.setCUST_CODE("");
					FAC_CO_INS_BEAN.setSHAREPER(0.0);
					FAC_CO_INS_BEAN.setRETRO(0.0);
					FAC_CO_INS_BEAN.setRETRO_LC_SI(0.0);
					FAC_CO_INS_BEAN.setTOTAL_LC_PREM(0.0);
					FAC_CO_INS_BEAN.setCUST_NAME("");
					listFAC.add(FAC_CO_INS_BEAN);
					compositeAction.getFAC_CO_INS_ACTION().setDataList_FAC_CO_INS_PARTI_COM(listFAC);

				}
				
				PM_CUSTOMER PM_CUSTOMER_BEAN = compositeAction.getPM_CUSTOMER_ACTION().getPM_CUSTOMER_BEAN();
				PM_CUSTOMER_BEAN.setTOTAL_LC_SI(compositeAction.getPV_POL_QUERY_ACTION().getPV_POL_QUERY_BEAN().getPOL_LC_SUM_ASSURED());
				PM_CUSTOMER_BEAN.setTOTAL_CLAIM_EST(compositeAction.getPV_CLM_QUERY_ACTION().getPV_CLM_QUERY_BEAN().getCLM_EST_AMT());
				PM_CUSTOMER_BEAN.setTOTAL_LC_PREM(compositeAction.getPREMIUM_ACTION().getPREMIUM_BEAN().getTOT_PREM());
				PM_CUSTOMER_BEAN.setTOTAL_CLAIM_PAID(compositeAction.getPV_CLM_QUERY_ACTION().getPV_CLM_QUERY_BEAN().getCLM_PAID_AMT());
				PM_CUSTOMER_BEAN.setLOSS_RATIO("");
			}else{
				compositeAction.getPREMIUM_ACTION().setPREMIUM_BEAN(new PREMIUM());
				compositeAction.getFAC_CO_INS_ACTION().setFAC_CO_INS_BEAN(new FAC_CO_INS());
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}finally{
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);
			CommonUtils.closeCursor(C6_REC);
			CommonUtils.closeCursor(C7_REC);
			CommonUtils.closeCursor(C8_REC);
			CommonUtils.closeCursor(C9_REC);
			CommonUtils.closeCursor(C10_REC);
			CommonUtils.closeCursor(C11_REC);
			CommonUtils.closeCursor(C12_REC);
			CommonUtils.closeCursor(C13_REC);
			CommonUtils.closeCursor(C14_REC);
			CommonUtils.closeCursor(C15_REC);
			CommonUtils.closeCursor(C16_REC);
			CommonUtils.closeCursor(C17_REC);
			CommonUtils.closeCursor(C18_REC);
		}
	}
}
