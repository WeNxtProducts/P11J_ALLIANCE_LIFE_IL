package com.iii.pel.forms.PT005_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT027.PILT027_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT027.PT_IL_DEPOSIT_CHARGE;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PS_IL_DRCR_DELEAGTE {

	public ArrayList fetchAccountsQueryDetailsFromDatabase(
			PS_IL_DRCR_SEARCH_PAGE_ACTION ps_il_drcr_search_page_action){
		ArrayList accountQueryList = new ArrayList();
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> session = ctx.getExternalContext().getSessionMap();
		String query=null;
		System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountsQueryDetailsFromDatabase() PARA1 > "+session.get("GLOBAL.M_PARAM_1"));
		if(session.get("GLOBAL.M_PARAM_1").equals("IL")){
			System.out.println("IL");			
			query=PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_IL_DRCR_SERCH_PAGE_SELECT_ALL;
		}else if(session.get("GLOBAL.M_PARAM_1").equals("GL")){
			System.out.println("GL");
			query = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_GL_DRCR_SERCH_PAGE_SELECT_ALL;
		}else if(session.get("GLOBAL.M_PARAM_1").equals("GP")){
			System.out.println("GP");
			query = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_GP_DRCR_SERCH_PAGE_SELECT_ALL;
		}

		String policyNo=ps_il_drcr_search_page_action.getPolicyNo();
		String custCode=ps_il_drcr_search_page_action.getCustCode();
		String claimNo=ps_il_drcr_search_page_action.getClaimNo();
		String endNo=ps_il_drcr_search_page_action.getEndNo();
		String docNo=ps_il_drcr_search_page_action.getDocNo();
		if(policyNo!=null 
				&& policyNo.trim().length()>0 ||
				custCode!=null 
				&& custCode.trim().length()>0||
				endNo!=null 
				&& endNo.trim().length()>0 ||
				claimNo!=null 
				&& claimNo.trim().length()>0 ||
				docNo!=null 
				&& docNo.trim().length()>0){
			if(session.get("GLOBAL.M_PARAM_1").equals("IL")){
				query=PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_IL_DRCR_SEARCH_PAGE_SELECT_WHERE_DETAILS_LIKE;
			}else if(session.get("GLOBAL.M_PARAM_1").equals("GL")){
				query=PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_GL_DRCR_SEARCH_PAGE_SELECT_WHERE_DETAILS_LIKE;
			}else if(session.get("GLOBAL.M_PARAM_1").equals("GP")){
				query=PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_GP_DRCR_SEARCH_PAGE_SELECT_WHERE_DETAILS_LIKE;
			}
			System.out.println("fetchAccountsQueryDetails :> "+query);
			Object[] object1={policyNo.toUpperCase()+"%",custCode.toUpperCase()+"%",claimNo.toUpperCase()+"%",
					endNo.toUpperCase()+"%",docNo.toUpperCase()+"%"};
			//changed by sateesh 
			String query1="";
			try {
				accountQueryList=getAccountsQueryList(query1,object1);
			} catch (DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Object[] object2={};
			try {
				accountQueryList=getAccountsQueryList(query,object2);
			} catch (DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				new Exception(e.getMessage());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		return accountQueryList;
	}

	public ArrayList getAccountsQueryList(String query,Object[] object) throws DBException, SQLException{
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList accountQueryList = new ArrayList();
       
    	PS_IL_DRCR ps_il_drcr=null;
		connection=CommonUtils.getConnection();
		resultSet=handler.executeSelectStatement(query, connection, object);
		if(resultSet!=null){
			while(resultSet.next()){
				ps_il_drcr=new PS_IL_DRCR();
				ps_il_drcr.setDRCR_POL_NO(resultSet.getString("DRCR_POL_NO"));
				ps_il_drcr.setDRCR_DOC_NO(resultSet.getInt("DRCR_DOC_NO"));
				ps_il_drcr.setDRCR_CUST_CODE(resultSet.getString("DRCR_CUST_CODE"));
				ps_il_drcr.setDRCR_END_NO(resultSet.getString("DRCR_END_NO"));
				ps_il_drcr.setDRCR_CLAIM_NO(resultSet.getString("DRCR_CLAIM_NO"));
				ps_il_drcr.setROWID(resultSet.getString("ROWID"));
				accountQueryList.add(ps_il_drcr);
			}
			
		}
		
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountQueryList;
	}

	public List<PS_IL_DRCR> fetchAccountQueryDetails(PS_IL_DRCR accountingBean,PS_IL_DRCR_SEARCH_PAGE_ACTION PS_IL_DRCR_SEARCH_PAGE_ACTION_BEAN)  {

		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> session = ctx.getExternalContext().getSessionMap();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Connection connection = null;
		DBProcedures procedures=new DBProcedures();
		ArrayList custDesc=null;
		List<PS_IL_DRCR>  beanList=null;
		
		String DRCR_CUST_CODE = PS_IL_DRCR_SEARCH_PAGE_ACTION_BEAN.getCustCode();
		String DRCR_POL_NO = PS_IL_DRCR_SEARCH_PAGE_ACTION_BEAN.getPolicyNo();
		String DRCR_CLAIM_NO = PS_IL_DRCR_SEARCH_PAGE_ACTION_BEAN.getClaimNo();
		String DRCR_END_NO = PS_IL_DRCR_SEARCH_PAGE_ACTION_BEAN.getEndNo();
		String DRCR_DOC_NO = PS_IL_DRCR_SEARCH_PAGE_ACTION_BEAN.getDocNo();
		
		DRCR_CUST_CODE = getStringValue(DRCR_CUST_CODE);
		DRCR_POL_NO = getStringValue(DRCR_POL_NO);
		DRCR_CLAIM_NO = getStringValue(DRCR_CLAIM_NO);
		DRCR_END_NO = getStringValue(DRCR_END_NO);
		DRCR_DOC_NO = getStringValue(DRCR_DOC_NO);
		
		try {
			connection=CommonUtils.getConnection();
			String query = null;
			String query1 = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_IL_DRCR_POST_QUERY_MAIN_ACNT_NAME;
			String query2 = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_IL_DRCR_POST_QUERY_SUB_ACNT_NAME;
			Object[] object= new Object[5];
			System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountQueryDetails(IL)");			
			query = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_IL_DRCR_SERCH_PAGE_SELECT_WHERE_POLICY_NO_LIKE;
			query = buildWhereClause1(PS_IL_DRCR_SEARCH_PAGE_ACTION_BEAN, query);
/*			}else if(session.get("GLOBAL.M_PARAM_1").equals("GL")){
				System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountQueryDetails(GL)");			
				query = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_GL_DRCR_SERCH_PAGE_SELECT_WHERE_POLICY_NO_LIKE;
//				query1 = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_GL_DRCR_POST_QUERY_MAIN_ACNT_NAME;
//				query2 = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_GL_DRCR_POST_QUERY_SUB_ACNT_NAME;
				query = buildWhereClause1(PS_IL_DRCR_SEARCH_PAGE_ACTION_BEAN, query);
			}else if(session.get("GLOBAL.M_PARAM_1").equals("GP")){
				System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountQueryDetails(gp)");			
				query = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_GP_DRCR_SERCH_PAGE_SELECT_WHERE_POLICY_NO_LIKE;
//				query1 = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_GP_DRCR_POST_QUERY_MAIN_ACNT_NAME;
//				query2 = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_GP_DRCR_POST_QUERY_SUB_ACNT_NAME;
				query = buildWhereClause1(PS_IL_DRCR_SEARCH_PAGE_ACTION_BEAN, query);			
			}
*/			
			
			Object[] values={DRCR_CUST_CODE,DRCR_CUST_CODE,DRCR_CUST_CODE,
					 DRCR_POL_NO,DRCR_POL_NO,DRCR_POL_NO,
					 DRCR_CLAIM_NO,DRCR_CLAIM_NO,DRCR_CLAIM_NO,
					 DRCR_END_NO,DRCR_END_NO,DRCR_END_NO,
					 DRCR_DOC_NO,DRCR_DOC_NO,DRCR_DOC_NO};
			System.out.println("Query [ "+query+" ]");	
			resultSet=handler.executeSelectStatement(query, connection,values);
			beanList = new ArrayList<PS_IL_DRCR>();
//			if(resultSet!=null){
				System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountQueryDetails(not null)");		
				while(resultSet.next()){
					PS_IL_DRCR ps_il_drcr_bean=new PS_IL_DRCR();
					ps_il_drcr_bean.setDRCR_TXN_CODE(resultSet.getString("DRCR_TXN_CODE"));
					ps_il_drcr_bean.setDRCR_DOC_NO(resultSet.getInt("DRCR_DOC_NO"));     //san
					ps_il_drcr_bean.setDRCR_SEQ_NO(resultSet.getInt("DRCR_SEQ_NO"));		//san
					ps_il_drcr_bean.setDRCR_DOC_DT(resultSet.getDate("DRCR_DOC_DT"));
					/*ps_il_drcr_bean.setDRCR_INT_DOC_NO(resultSet.getDouble("DRCR_INT_DOC_NO"));
				ps_il_drcr_bean.setDRCR_POL_SYS_ID(resultSet.getDouble("DRCR_POL_SYS_ID"));*/
					ps_il_drcr_bean.setDRCR_POL_NO(resultSet.getString("DRCR_POL_NO"));
					//ps_il_drcr_bean.setDRCR_END_NO_IDX(resultSet.getDouble("DRCR_END_NO_IDX"));
					ps_il_drcr_bean.setDRCR_CLAIM_NO(resultSet.getString("DRCR_CLAIM_NO"));
					//ps_il_drcr_bean.setDRCR_CLM_SYS_ID(resultSet.getDouble("DRCR_CLM_SYS_ID"));
					ps_il_drcr_bean.setDRCR_CUST_CODE(resultSet.getString("DRCR_CUST_CODE"));
					ps_il_drcr_bean.setDRCR_MAIN_ACNT_CODE(resultSet.getString("DRCR_MAIN_ACNT_CODE"));
					ps_il_drcr_bean.setDRCR_SUB_ACNT_CODE(resultSet.getString("DRCR_SUB_ACNT_CODE"));
					/*ps_il_drcr_bean.setDRCR_DIVN_CODE(resultSet.getString("DRCR_DIVN_CODE"));
				ps_il_drcr_bean.setDRCR_DEPT_CODE(resultSet.getString("DRCR_DEPT_CODE"));*/
					ps_il_drcr_bean.setDRCR_ANLY_CODE_1(resultSet.getString("DRCR_ANLY_CODE_1"));
					ps_il_drcr_bean.setDRCR_ANLY_CODE_2(resultSet.getString("DRCR_ANLY_CODE_2"));
					ps_il_drcr_bean.setDRCR_ACTY_CODE_1(resultSet.getString("DRCR_ACTY_CODE_1"));
					ps_il_drcr_bean.setDRCR_ACTY_CODE_2(resultSet.getString("DRCR_ACTY_CODE_2"));
					//ps_il_drcr_bean.setDRCR_INT_ENT_YN(resultSet.getString("DRCR_INT_ENT_YN"));
					ps_il_drcr_bean.setDRCR_DRCR_FLAG(resultSet.getString("DRCR_DRCR_FLAG"));
					ps_il_drcr_bean.setDRCR_CURR_CODE(resultSet.getString("DRCR_CURR_CODE"));
					ps_il_drcr_bean.setDRCR_FC_AMT(resultSet.getDouble("DRCR_FC_AMT"));
					ps_il_drcr_bean.setDRCR_LC_AMT(resultSet.getDouble("DRCR_LC_AMT"));
					/*ps_il_drcr_bean.setDRCR_CHQ_NO(resultSet.getString("DRCR_CHQ_NO"));
				ps_il_drcr_bean.setDRCR_CHQ_DT(resultSet.getDate("DRCR_CHQ_DT"));
				ps_il_drcr_bean.setDRCR_BANK_NAME(resultSet.getString("DRCR_BANK_NAME"));*/
					ps_il_drcr_bean.setDRCR_NARRATION(resultSet.getString("DRCR_NARRATION"));
					ps_il_drcr_bean.setDRCR_BL_NARRATION(resultSet.getString("DRCR_BL_NARRATION"));
					//ps_il_drcr_bean.setDRCR_PRINT_YN(resultSet.getString("DRCR_PRINT_YN"));
					ps_il_drcr_bean.setDRCR_POST_YN(resultSet.getString("DRCR_POST_YN"));
					ps_il_drcr_bean.setDRCR_DOC_TYPE(resultSet.getString("DRCR_DOC_TYPE"));
					ps_il_drcr_bean.setDRCR_CR_UID(resultSet.getString("DRCR_CR_UID"));
					ps_il_drcr_bean.setDRCR_CR_DT(resultSet.getDate("DRCR_CR_DT"));
					//ps_il_drcr_bean.setDRCR_REMARKS(resultSet.getString("DRCR_REMARKS"));
					ps_il_drcr_bean.setDRCR_END_NO(resultSet.getString("DRCR_END_NO"));
					//ps_il_drcr_bean.setDRCR_MATCH_STATUS(resultSet.getString("DRCR_MATCH_STATUS"));
					ps_il_drcr_bean.setDRCR_ACNT_YEAR(resultSet.getDouble("DRCR_ACNT_YEAR"));
					//** Post Query Code*//
					Object[] object1={ps_il_drcr_bean.getDRCR_MAIN_ACNT_CODE()};
System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountQueryDetails() mainActCode "+object1[0]+"\t query1 : "+query1);					
					resultSet1=handler.executeSelectStatement(query1, connection, object1);
					if(resultSet1.next()){
						ps_il_drcr_bean.setUI_M_MAIN_ACNT_DESC(resultSet1.getString(1));
					}
					Object[] object2={ps_il_drcr_bean.getDRCR_SUB_ACNT_CODE()};
System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountQueryDetails() subActCode  "+object2[0]+"\t query1 : "+query2);					
					resultSet2=handler.executeSelectStatement(query2, connection, object2);
					if(resultSet2.next()){
						ps_il_drcr_bean.setUI_M_SUB_ACNT_DESC(resultSet2.getString(1));
					}
					String custCode=ps_il_drcr_bean.getDRCR_CUST_CODE();
					if(custCode!=null){
						custDesc=procedures.helperP_VAL_CUST(custCode, "N", "N");
						if(custDesc!=null && custDesc.size()!=0){
							ps_il_drcr_bean.setUI_M_DRCR_CUST_NAME((String)custDesc.get(0));
						}
					}
					
					//** end of post query code **//
					beanList.add(ps_il_drcr_bean);
					
				}
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return beanList; 
	}
	
	public String buildWhereClause(PS_IL_DRCR accountingBean, String query){
		String whereClause = null;
		if(accountingBean.getDRCR_CLAIM_NO()!= null){
			query = query+ " WHERE DRCR_CLM_NO = '"+accountingBean.getDRCR_CLAIM_NO()+"'";
			
		}
		if(accountingBean.getDRCR_POL_NO()!=null){
			whereClause = query.contains("WHERE")? " AND " : " WHERE  "; 
			query = query + whereClause + " DRCR_POL_NO = '"+accountingBean.getDRCR_POL_NO()+"'";
		}
		if(accountingBean.getDRCR_CUST_CODE()!=null){
			whereClause = query.contains("WHERE")? " AND " : " WHERE  "; 
			query = query + whereClause + " DRCR_CUST_CODE = '"+accountingBean.getDRCR_CUST_CODE()+"'";
		}
		if(accountingBean.getDRCR_END_NO()!=null){
			whereClause = query.contains("WHERE")? " AND " : " WHERE  "; 
			query = query + whereClause + " DRCR_END_NO = '"+accountingBean.getDRCR_END_NO()+"'";
		}
		if(accountingBean.getDRCR_DOC_NO()!=null){
			whereClause = query.contains("WHERE")? " AND " : " WHERE  "; 
			query = query + whereClause + " DRCR_DOC_NO = '"+accountingBean.getDRCR_DOC_NO()+"'";
		}
System.out.println("Buil Whearclause --- [ "+query+" ]---");
		return query;
	}
	
	public String buildWhereClause1(PS_IL_DRCR_SEARCH_PAGE_ACTION PS_IL_DRCR_SEARCH_PAGE_ACTION_BEAN,String query){
		String whereQuery=null;
		whereQuery = " WHERE ( ? IS NULL OR ? IS NOT NULL AND DRCR_CUST_CODE LIKE ? ||'%')"+
					 " AND (? IS NULL OR ? IS NOT NULL AND DRCR_POL_NO LIKE ? ||'%')"+
					 " AND (? IS NULL OR ? IS NOT NULL AND DRCR_CLAIM_NO LIKE ? ||'%')"+
					 " AND (? IS NULL OR ? IS NOT NULL AND DRCR_END_NO LIKE ? ||'%')"+
					 " AND (? IS NULL OR ? IS NOT NULL AND DRCR_DOC_NO = ? ) AND ROWNUM <100";
		query = query + whereQuery;
		return query;
	}

	public String getStringValue(String getValue){
		getValue = getValue==null ? "":getValue;
		return getValue;
	}

	public List<PS_IL_DRCR> getBlockData(PS_IL_DRCR_ACTION ps_il_drcr_action){

		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> session = ctx.getExternalContext().getSessionMap();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		Connection connection = null;
		DBProcedures procedures=new DBProcedures();
		String DRCR_CUST_CODE = null;
		String DRCR_POL_NO = null;
		String DRCR_CLAIM_NO =null;
		String DRCR_END_NO = null;
		Double DRCR_DOC_NO = null;
		ArrayList<String> custDesc=null; 
		List<PS_IL_DRCR>  beanList=null;
		System.out.println("ps_il_drcr_action.getPS_IL_DRCR_BEAN().getROWID()................."+ps_il_drcr_action.getPS_IL_DRCR_BEAN().getROWID()); 
		//PS_IL_DRCR ps_il_drcr_bean=null;
		
		try {
			connection=CommonUtils.getConnection();
			String query = null;
			String query1 = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_IL_DRCR_POST_QUERY_MAIN_ACNT_NAME;
			String query2 = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_IL_DRCR_POST_QUERY_SUB_ACNT_NAME;
			String query3=PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_IL_DRCR_SEARCH_PAGE_SELECT_DETAILS_FOR_ROWID;
			
			resultSet3 = new CRUDHandler().executeSelectStatement(query3,CommonUtils.getConnection(),
	                new Object[]{ps_il_drcr_action.getPS_IL_DRCR_BEAN().getROWID()} );
			beanList = new ArrayList<PS_IL_DRCR>();
			if(resultSet3!=null){
				while(resultSet3.next()){
					PS_IL_DRCR	ps_il_drcr_bean=new PS_IL_DRCR();
					System.out.println("resultSet.getString"+resultSet3.getString("DRCR_POL_NO"));
					DRCR_POL_NO=resultSet3.getString("DRCR_POL_NO");
					System.out.println(resultSet3.getDouble("DRCR_DOC_NO")); 
					DRCR_DOC_NO= resultSet3.getDouble("DRCR_DOC_NO");
					DRCR_CUST_CODE=resultSet3.getString("DRCR_CUST_CODE");
					DRCR_END_NO=resultSet3.getString("DRCR_END_NO");
					DRCR_CLAIM_NO=resultSet3.getString("DRCR_CLAIM_NO");
					ps_il_drcr_bean.setROWID(resultSet3.getString("ROWID"));
				/*}
			}
			DRCR_CUST_CODE = getStringValue(DRCR_CUST_CODE);
			DRCR_POL_NO = getStringValue(DRCR_POL_NO);
			DRCR_CLAIM_NO = getStringValue(DRCR_CLAIM_NO);
			DRCR_END_NO = getStringValue(DRCR_END_NO);
			//DRCR_DOC_NO = getStringValue(DRCR_DOC_NO);
			Object[] object= new Object[5];
			System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountQueryDetails(IL)");			
			query = PS_IL_DRCR_SQL_QUERY_CONSTANTS.PS_IL_DRCR_SERCH_PAGE_SELECT_WHERE_POLICY_NO_LIKE;
			query = buildWhereClause1(query);
			System.out.println("DRCR_CUST_CODE..."+DRCR_CUST_CODE);
			System.out.println("DRCR_POL_NO..."+DRCR_POL_NO);
			System.out.println("DRCR_CLAIM_NO..."+DRCR_CLAIM_NO);
			System.out.println("DRCR_END_NO..."+DRCR_END_NO);
			System.out.println("DRCR_DOC_NO..."+DRCR_DOC_NO);
			Object[] values={DRCR_CUST_CODE,DRCR_CUST_CODE,DRCR_CUST_CODE,
					 DRCR_POL_NO,DRCR_POL_NO,DRCR_POL_NO,
					 DRCR_CLAIM_NO,DRCR_CLAIM_NO,DRCR_CLAIM_NO,
					 DRCR_END_NO,DRCR_END_NO,DRCR_END_NO};
					// DRCR_DOC_NO,DRCR_DOC_NO,DRCR_DOC_NO};
			System.out.println("Query [ "+query+" ]");	
			resultSet=handler.executeSelectStatement(query, connection,values);
			beanList = new ArrayList<PS_IL_DRCR>();
//			if(resultSet!=null){
				System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountQueryDetails(not null)");		
				while(resultSet.next()){
					PS_IL_DRCR ps_il_drcr_bean=new PS_IL_DRCR();*/
					ps_il_drcr_bean.setDRCR_TXN_CODE(resultSet3.getString("DRCR_TXN_CODE"));
					ps_il_drcr_bean.setDRCR_DOC_NO(resultSet3.getInt("DRCR_DOC_NO"));
					ps_il_drcr_bean.setDRCR_SEQ_NO(resultSet3.getInt("DRCR_SEQ_NO"));
					ps_il_drcr_bean.setDRCR_DOC_DT(resultSet3.getDate("DRCR_DOC_DT"));
					/*ps_il_drcr_bean.setDRCR_INT_DOC_NO(resultSet3.getDouble("DRCR_INT_DOC_NO"));
				ps_il_drcr_bean.setDRCR_POL_SYS_ID(resultSet3.getDouble("DRCR_POL_SYS_ID"));*/
					ps_il_drcr_bean.setDRCR_POL_NO(resultSet3.getString("DRCR_POL_NO"));
					//ps_il_drcr_bean.setDRCR_END_NO_IDX(resultSet3.getDouble("DRCR_END_NO_IDX"));
					ps_il_drcr_bean.setDRCR_CLAIM_NO(resultSet3.getString("DRCR_CLAIM_NO"));
					//ps_il_drcr_bean.setDRCR_CLM_SYS_ID(resultSet3.getDouble("DRCR_CLM_SYS_ID"));
					ps_il_drcr_bean.setDRCR_CUST_CODE(resultSet3.getString("DRCR_CUST_CODE"));
					ps_il_drcr_bean.setDRCR_MAIN_ACNT_CODE(resultSet3.getString("DRCR_MAIN_ACNT_CODE"));
					ps_il_drcr_bean.setDRCR_SUB_ACNT_CODE(resultSet3.getString("DRCR_SUB_ACNT_CODE"));
					/*ps_il_drcr_bean.setDRCR_DIVN_CODE(resultSet3.getString("DRCR_DIVN_CODE"));
				    ps_il_drcr_bean.setDRCR_DEPT_CODE(resultSet3.getString("DRCR_DEPT_CODE"));*/
					ps_il_drcr_bean.setDRCR_ANLY_CODE_1(resultSet3.getString("DRCR_ANLY_CODE_1"));
					ps_il_drcr_bean.setDRCR_ANLY_CODE_2(resultSet3.getString("DRCR_ANLY_CODE_2"));
					ps_il_drcr_bean.setDRCR_ACTY_CODE_1(resultSet3.getString("DRCR_ACTY_CODE_1"));
					ps_il_drcr_bean.setDRCR_ACTY_CODE_2(resultSet3.getString("DRCR_ACTY_CODE_2"));
					//ps_il_drcr_bean.setDRCR_INT_ENT_YN(resultSet3.getString("DRCR_INT_ENT_YN"));
					ps_il_drcr_bean.setDRCR_DRCR_FLAG(resultSet3.getString("DRCR_DRCR_FLAG"));
					ps_il_drcr_bean.setDRCR_CURR_CODE(resultSet3.getString("DRCR_CURR_CODE"));
					ps_il_drcr_bean.setDRCR_FC_AMT(resultSet3.getDouble("DRCR_FC_AMT"));
					ps_il_drcr_bean.setDRCR_LC_AMT(resultSet3.getDouble("DRCR_LC_AMT"));
					/*ps_il_drcr_bean.setDRCR_CHQ_NO(resultSet3.getString("DRCR_CHQ_NO"));
				    ps_il_drcr_bean.setDRCR_CHQ_DT(resultSet3.getDate("DRCR_CHQ_DT"));
				    ps_il_drcr_bean.setDRCR_BANK_NAME(resultSet3.getString("DRCR_BANK_NAME"));*/
					ps_il_drcr_bean.setDRCR_NARRATION(resultSet3.getString("DRCR_NARRATION"));
					ps_il_drcr_bean.setDRCR_BL_NARRATION(resultSet3.getString("DRCR_BL_NARRATION"));
					//ps_il_drcr_bean.setDRCR_PRINT_YN(resultSet3.getString("DRCR_PRINT_YN"));
					ps_il_drcr_bean.setDRCR_POST_YN(resultSet3.getString("DRCR_POST_YN"));
					ps_il_drcr_bean.setDRCR_DOC_TYPE(resultSet3.getString("DRCR_DOC_TYPE"));
					ps_il_drcr_bean.setDRCR_CR_UID(resultSet3.getString("DRCR_CR_UID"));
					ps_il_drcr_bean.setDRCR_CR_DT(resultSet3.getDate("DRCR_CR_DT"));
					//ps_il_drcr_bean.setDRCR_REMARKS(resultSet3.getString("DRCR_REMARKS"));
					ps_il_drcr_bean.setDRCR_END_NO(resultSet3.getString("DRCR_END_NO"));
					//ps_il_drcr_bean.setDRCR_MATCH_STATUS(resultSet3.getString("DRCR_MATCH_STATUS"));
					ps_il_drcr_bean.setDRCR_ACNT_YEAR(resultSet3.getDouble("DRCR_ACNT_YEAR"));
					//** Post Query Code*//
					Object[] object1={ps_il_drcr_bean.getDRCR_MAIN_ACNT_CODE()};
                    System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountQueryDetails() mainActCode "+object1[0]+"\t query1 : "+query1);					
					resultSet1=handler.executeSelectStatement(query1, connection, object1);
					if(resultSet1.next()){
						ps_il_drcr_bean.setUI_M_MAIN_ACNT_DESC(resultSet1.getString(1));
					}
					Object[] object2={ps_il_drcr_bean.getDRCR_SUB_ACNT_CODE()};
                    System.out.println("PS_IL_DRCR_DELEAGTE.fetchAccountQueryDetails() subActCode  "+object2[0]+"\t query1 : "+query2);					
					resultSet2=handler.executeSelectStatement(query2, connection, object2);
					if(resultSet2.next()){
						ps_il_drcr_bean.setUI_M_SUB_ACNT_DESC(resultSet2.getString(1));
					}
					String custCode=ps_il_drcr_bean.getDRCR_CUST_CODE();
					if(custCode!=null){
						custDesc=procedures.helperP_VAL_CUST(custCode, "N", "N");
						if(custDesc!=null && custDesc.size()!=0){
							ps_il_drcr_bean.setUI_M_DRCR_CUST_NAME((String)custDesc.get(0));
						}
					}
					
					//** end of post query code **//
					beanList.add(ps_il_drcr_bean);
					
				}
			}
				PS_IL_DRCR PS_IL_DRCR = null;
				Iterator<PS_IL_DRCR> it = beanList.iterator();
				while(it.hasNext()){
					PS_IL_DRCR = it.next();
					PS_IL_DRCR.setRowSelected(false);
	 			}
				
				if (beanList.size()>0){					
					ps_il_drcr_action.setPS_IL_DRCR_BEAN(beanList.get(0));
					ps_il_drcr_action.getPS_IL_DRCR_BEAN().setRowSelected(true);
				}
				
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return beanList; 
	}
	


	private String buildWhereClause1(String query) {
		String whereQuery=null;
		whereQuery = " WHERE ( ? IS NULL OR ? IS NOT NULL AND DRCR_CUST_CODE LIKE ? ||'%')"+
					 " AND (? IS NULL OR ? IS NOT NULL AND DRCR_POL_NO LIKE ? ||'%')"+
					 " AND (? IS NULL OR ? IS NOT NULL AND DRCR_CLAIM_NO LIKE ? ||'%')"+
					 " AND (? IS NULL OR ? IS NOT NULL AND DRCR_END_NO LIKE ? )AND ROWNUM <100 ";
					// " AND (? IS NULL OR ? IS NOT NULL AND DRCR_DOC_NO = ? ) AND ROWNUM <100";
		query = query + whereQuery;
		return query;
	}

	


}



