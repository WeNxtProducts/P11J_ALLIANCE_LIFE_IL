package com.iii.pel.forms.PILQ108_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class POLICY_DETAILS_HELPER {

	private static final Log log = LogFactory.getLog(POLICY_DETAILS_HELPER.class);

	public void executeQuery(PILQ108_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new POLICY_DETAILS_DELEGATE().executeSelectStatement(compositeAction);
	}
	/**
	 * 
	 * @param compositeAction
	 */
	public void postQuery(POLICY_DETAILS POLICY_DETAILS_BEAN) throws Exception{
		 String M_CODE_DESC_1  =null;
		 String M_CODE_DESC_2  =null;
		 int M_PS_VALUE_1 =0;
		 int M_PS_VALUE_2  =0;
		DBProcedures procedures = new DBProcedures();
		try{
			if(POLICY_DETAILS_BEAN.getPOL_STATUS()!=null || !"".equalsIgnoreCase(POLICY_DETAILS_BEAN.getPOL_STATUS())){
				ArrayList<String> recSTALIst = procedures.callP_VAL_SYSTEM("IL_REC_STA", POLICY_DETAILS_BEAN.getPOL_STATUS(), "N");
				if(!recSTALIst.isEmpty()){
					M_CODE_DESC_1 = recSTALIst.get(0);
					if(recSTALIst.get(1)!=null){
						M_PS_VALUE_1 = Integer.parseInt(recSTALIst.get(1));
					}
					POLICY_DETAILS_BEAN.setPOL_STATUS_DESC(M_CODE_DESC_1);
					log.info("=========>M_CODE_DESC_1=======>"+M_CODE_DESC_1);
					log.info("=========>M_PS_VALUE_1=======>"+M_PS_VALUE_1);
				}
			}
			
			if(POLICY_DETAILS_BEAN.getPOL_ADDL_STATUS()!=null || !"".equalsIgnoreCase(POLICY_DETAILS_BEAN.getPOL_ADDL_STATUS())){
				ArrayList<String> addlStatusIst = procedures.callP_VAL_SYSTEM("IL_ADDL_STAT", POLICY_DETAILS_BEAN.getPOL_ADDL_STATUS(), "N");
				if(!addlStatusIst.isEmpty()){
					M_CODE_DESC_2 = addlStatusIst.get(0);
					if(addlStatusIst.get(1)!=null){
						M_PS_VALUE_2 = Integer.parseInt(addlStatusIst.get(1));
					}
					POLICY_DETAILS_BEAN.setUI_M_POL_ADDL_STATUS_DESC(M_CODE_DESC_2);
					log.info("=========>M_CODE_DESC_2=======>"+M_CODE_DESC_2);
					log.info("=========>M_PS_VALUE_2=======>"+M_PS_VALUE_2);
				}
			}
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}
		

	}
	/**
	 * 
	 */
	public void whenNewBlockInstance(){
		//EXECUTE_QUERY;
	}
	
	
	/**
	 * 
	 * @param compositeAction
	 */
	public  void preQuery(PILQ108_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_WHERE = null;
		int M_NO_MONTH = 0;
		Long M_POL_SYS_ID = null;
		String M_END_CODE = null; 
		Connection connection = null;
		CRUDHandler handler = null;
		String C1 = "SELECT NVL(PS_VALUE,0) FROM   PP_SYSTEM WHERE  PS_TYPE='IL_B21_MON'";
		String C2 = "SELECT PS_CODE FROM   PP_SYSTEM WHERE  PS_TYPE='IL_REP_CANCL'";
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			
			C1_REC = handler.executeSelectStatement(C1, connection);
			if(C1_REC.next()){
				M_NO_MONTH = C1_REC.getInt(1);
			}
			
			C2_REC = handler.executeSelectStatement(C2, connection);
			if(C2_REC.next()){
				M_END_CODE = C2_REC.getString(1);
			}
			
			if(DUMMY_BEAN.getUI_M_START_DT()==null){
				DUMMY_BEAN.setUI_M_START_DT(new CommonUtils().getCurrentDate());
			}
			// As suggested By Ganesh . From the below POL_CLASS_CODE ='1' is commented 
			// since this module has to query for all product
			M_WHERE = "POL_SYS_ID IN (SELECT  DISTINCT POL_SYS_ID "
					+ "FROM PT_IL_POLICY A,PT_IL_POL_ASSURED_DTLS B "
					+ "WHERE A.POL_STATUS IN ('A','S','L' ) AND A.POL_DS_TYPE  ='2' "
					+ "/*AND A.POL_CLASS_CODE='1'*/ "
					+ "AND MONTHS_BETWEEN('"
					+ CommonUtils.dateToStringFormatter(DUMMY_BEAN.getUI_M_START_DT())
					+ "',DECODE(A.POL_STATUS,'A',A.POL_APPRV_DT,A.POL_PAIDUP_DT))<="
					+ M_NO_MONTH + " AND (B.POAD_REF_ID1 = '"
					+ DUMMY_BEAN.getPOAD_ASSRD_REF_ID1()
					+ "' OR B.POAD_REF_ID2 = '"
					+ DUMMY_BEAN.getPOAD_ASSRD_REF_ID2() + "') AND"
					+ " A.POL_SYS_ID   =  B.POAD_POL_SYS_ID "+
			
					" UNION SELECT DISTINCT POL_SYS_ID FROM "
					+ "PT_IL_POLICY A,PT_IL_POL_STATUS C,PT_IL_POL_ASSURED_DTLS B "
					+ "WHERE  C.PS_STATUS IN ('I05','I06') AND A.POL_DS_TYPE= '2' "
					+ "/*AND A.POL_CLASS_CODE='1'*/ AND "
					+ "MONTHS_BETWEEN('"
					+ CommonUtils.dateToStringFormatter(DUMMY_BEAN.getUI_M_START_DT())
					+ "',C.PS_STATUS_DT)<= "
					+ M_NO_MONTH
					+ " AND A.POL_SYS_ID =  C.PS_POL_SYS_ID "
					+ "AND   (B.POAD_REF_ID1  = '"+ DUMMY_BEAN.getPOAD_ASSRD_REF_ID1()+"'" +
					" OR B.POAD_REF_ID2  = '"+DUMMY_BEAN.getPOAD_ASSRD_REF_ID2()+"') " +
					"AND  A.POL_SYS_ID = B.POAD_POL_SYS_ID "+
					
					" UNION "
					+ "SELECT DISTINCT POL_SYS_ID  "
					+ "FROM   PT_IL_POLICY A,PT_IL_POL_ASSURED_DTLS B "
					+ "WHERE  A.POL_STATUS IN ('C') AND A.POL_DS_TYPE='2' "
					+ "/*AND    A.POL_CLASS_CODE='1'*/ "
					+ "AND    A.POL_END_CODE='"
					+ M_END_CODE
					+ "'"
					+ "AND MONTHS_BETWEEN('"+CommonUtils.dateToStringFormatter(DUMMY_BEAN.getUI_M_START_DT())+"'"+",A.POL_CANCEL_DT)<= "+
					M_NO_MONTH +" AND (B.POAD_REF_ID1  = '"
					+ DUMMY_BEAN.getPOAD_ASSRD_REF_ID1() + "' "
					+ "OR B.POAD_REF_ID2  = '"
					+ DUMMY_BEAN.getPOAD_ASSRD_REF_ID2() + "') "
					+ "AND    A.POL_SYS_ID  =  B.POAD_POL_SYS_ID "+
			
				   " UNION SELECT DISTINCT POL_SYS_ID "
					+ "FROM PT_IL_POLICY A, PT_IL_POL_ASSURED_DTLS C,PT_IL_WITHDRAWAL B "
					+ "WHERE  A.POL_DS_TYPE ='2' /*AND A.POL_CLASS_CODE  ='1'*/ "
					+ "AND MONTHS_BETWEEN('"+CommonUtils.dateToStringFormatter(DUMMY_BEAN.getUI_M_START_DT())+"',B.WD_DATE)<= "+M_NO_MONTH
					+ " AND A.POL_SYS_ID = B.WD_POL_SYS_ID "
					+ "AND B.WD_APPRV_STATUS ='A' AND "
					+ "(C.POAD_REF_ID1 ='"+DUMMY_BEAN.getPOAD_ASSRD_REF_ID1()+"' OR C.POAD_REF_ID2 ='"
					+DUMMY_BEAN.getPOAD_ASSRD_REF_ID2()+"') AND "
					+ "A.POL_SYS_ID = C.POAD_POL_SYS_ID "+
			
					" UNION "
					+ "SELECT DISTINCT POLH_SYS_ID "
					+ "FROM   PH_IL_POLICY A,PT_IL_POL_ASSURED_DTLS B "
					+ "WHERE  A.POLH_DS_TYPE  = '2' "
					+ "AND POLH_CLASS_CODE='1' "
					+ "AND MONTHS_BETWEEN('"+CommonUtils.dateToStringFormatter(DUMMY_BEAN.getUI_M_START_DT())+"',A.POLH_N_END_EFF_FROM_DT )<="+M_NO_MONTH
					+ " AND A.POLH_N_END_CODE IN (SELECT PS_CODE  "
					+ " FROM PP_SYSTEM "
					+ " WHERE PS_TYPE='IL_DEC_SA' "
					+ "AND A.POLH_SYS_ID = B.POAD_POL_SYS_ID "
					+ "AND (B.POAD_REF_ID1 = '"+DUMMY_BEAN.getPOAD_ASSRD_REF_ID1()
					+ "' OR  B.POAD_REF_ID2 = '"+DUMMY_BEAN.getPOAD_ASSRD_REF_ID2()+"')))";
			
			compositeAction.setWHERE_QUERY( M_WHERE );
			
		}catch(Exception exception){
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
		}
	}

	/**
	 * Formats a date to a string with the format accepted by DB
	 * @param date == java.sql.Date
	 * @return
	 */
	public static String dateToStringFormat(java.util.Date date){
		String dateConvertedToString;
		if(date!=null){

			SimpleDateFormat dateFormat = new SimpleDateFormat(PELConstants.dbDateFormat);
			dateConvertedToString = dateFormat.format(date);
		}else{
			dateConvertedToString = "";
		}
		log.info("dateConvertedToString"+dateConvertedToString);
		return dateConvertedToString;

	}
}
