package com.iii.pel.forms.PILQ106_APAC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_UNIT_FUND_REG_HDR_HELPER {

	public void executeQuery(PILQ106_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
	    preQuery(compositeAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN());
		new PT_IL_UNIT_FUND_REG_HDR_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_UNIT_FUND_REG_HDR> dataList = compositeAction
				.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN()
				.getDataList_PT_IL_UNIT_FUND_REG_HDR();
		if (dataList != null && dataList.size() > 0) {
			compositeAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN()
					.setPT_IL_UNIT_FUND_REG_HDR_BEAN(dataList.get(0));
			dataList.get(0).setRowSelected(true);
		}
		compositeAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN().resetAllComponent();
		
		// On-populate-deatils to detail block.
		onPopulateDetails(compositeAction.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN().getPT_IL_UNIT_FUND_REG_HDR_BEAN(), 
				compositeAction);
	}
	
	public static void main(String[] args) {
	    Connection connection = null;
            CRUDHandler handler = new CRUDHandler();
            ResultSet resultSet = null;

	    try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@10.44.0.59:1521:orcl","PEL_IL_LIFE","PEL_IL_LIFE");
		String POST_QUERY_CURSOR_C1 =  " SELECT   PC_SCHD_PYMT_DT,PC_APPRV_DT    " 	
		    + "FROM     PT_IL_PREM_COLL "
		    + "WHERE    PC_SYS_ID=? "
		    + "AND      ? IN ('P') "
		    + "AND      ? IN ('B','S' ) "
		    + "AND      PC_PAID_FLAG ='A'   "
		    + "AND      NVL(?,0) <> 0 "  
		    + "UNION "							//2nd
		    + "SELECT   NVL(DDH_DRIP_DATE,ADD_MONTHS(DDH_SUB_DRIP_DATE,-1)),PC_APPRV_DT "     	
		    + "FROM     PT_IL_PREM_COLL,PT_IL_DAILY_DRIP_HDR "
		    + "WHERE    PC_SYS_ID =DDH_PC_SYS_ID "
		    + "AND      PC_PAID_FLAG ='A' "
		    + "AND      DDH_SYS_ID=? "
		    + "AND      ? IN ('R','D','WA') "
		    + "AND      ? IN ('B','S' ) "
		    + "AND      NVL(?,0) <> 0 "	  
		    + "UNION "							//3rd
			//0, H, 0, 
		    //0, H,4th
		 
		    + "SELECT DDH_DRIP_DATE,NULL "
		    + "FROM   PT_IL_DAILY_DRIP_HDR "
		    + "WHERE  DDH_SYS_ID =? "
		    + "AND    NVL(DDH_PC_SYS_ID,0) = 0 "
		    + "AND      ? IN ('R','D','WA') "	 	  
		    + "AND    NVL(?,0) = 0 "
		    + "UNION ALL   "					//4th
		    + "SELECT   TU_APPRV_DT,TU_APPRV_DT " 
		    + "FROM     PT_IL_TOP_UP "
		    + "WHERE    TU_SYS_ID = ? "
		    + "AND      ? ='T' "
		    + "UNION ALL "	
		    //0, 101381, H,
		    //101381, 0, H,
		    + "SELECT FTH_SWITCH_DT,FTH_SWITCH_DT " //5th
		    + "FROM   PT_IL_FUND_TRAN_HDR "
		    + "WHERE  FTH_SYS_ID     =? "
		    + "AND    FTH_POL_SYS_ID =? "
		    + "AND    ? ='H' "
		      + "UNION ALL "						//6th
		    + "SELECT SMV_DATE,SMV_DATE  "
		    + "FROM   PT_IL_SURR_MAT_VALUES    "
		    + "WHERE  SMV_POL_SYS_ID = ? "
		    + "AND    SMV_SYS_ID     = ? "
		    + "AND    ? IN('S','M') "
		       + "UNION ALL "						//7th
		   // 101381, 0, H,
		    //101381, 0, H, 
		    + "SELECT WD_DATE,WD_DATE  "
		    + "FROM   PT_IL_WITHDRAWAL    "
		    + "WHERE  WD_POL_SYS_ID = ? "
		    + "AND    WD_SYS_ID     = ? "
		    + "AND    ? ='W' "
		    + "UNION ALL "						//8th
		    + "SELECT CLAIM_INTM_DT,CLAIM_LOSS_DT "
		    + "FROM   PT_IL_CLAIM    "
		    + "WHERE  CLAIM_POL_SYS_ID = ?     "      
		    + "AND    CLAIM_SYS_ID     = ? "
		    + "AND    ? ='C' "
		       + "UNION  ALL "						//9th
		    //101381, 0, H, 
		     //null, 101381, 80458, H,
		    
		    + "SELECT UFRH_TRAN_DT,UFRH_TRAN_DT "
		    + "FROM   PT_IL_UNIT_FUND_REG_HDR "
		    + "WHERE  UFRH_POL_SYS_ID =?   "        
		    + "AND    UFRH_PC_SYS_ID  = ? "
		    + "AND    ? ='E' "
		  /*     + "UNION ALL "						//10th
		    +  "SELECT UFRH_TRAN_DT,? "
		    + "FROM   PT_IL_UNIT_FUND_REG_HDR "
		    + "WHERE  UFRH_POL_SYS_ID =? "          
		    + "AND    UFRH_SYS_ID  = ? "
		    + "AND    ? ='AJ' " 
		      + "UNION ALL "						//11th
		    //null, 101381, 80458, H, PREMIADMIN, 
		    + "SELECT UFRH_TRAN_DT,? "
		    + "FROM   PT_IL_UNIT_FUND_REG_HDR "
		    + "WHERE  UFRH_POL_SYS_ID =? "          
		    + "AND    UFRH_SYS_ID  = ? "
		    + "AND    ? ='S' "
		    + "AND    ? = 'IM36174P' " */
		     + "UNION ALL "						//12th
		    //0, 101381, H,
		    + "SELECT BON_CR_DT, BON_CR_DT "
		    + "FROM   PT_IL_BONUS "
		    + "WHERE  BON_SYS_ID = ? "
		    + "AND    BON_POL_SYS_ID = ? "
		    + "AND    ? ='B' "
		    + "UNION ALL	   "				//13th
		    // 0, H, S, 0, 
		    + "SELECT   WAK_DA_PC_SCHD_PYMT_DT, WAK_DA_PC_APPRV_DT "
		    + "FROM     PT_LIFE_WAKALAH_dAILY_DRIP,PT_IL_POLICY "
		    + "WHERE    WAK_DA_PC_SYS_ID=? "
		    + "AND      ? IN ('P') "
		    + "AND      ? = 'B'   "
		    + "AND      NVL(?,0) <> 0 "  
		    + "AND      WAK_DA_PC_SCHD_PYMT_DT IS NOT NULL "
		    + "AND      WAK_DA_POL_NO = POL_NO "
		    + "AND      WAK_Da_POL_COVER_CODE = POL_PLAN_CODE "
		    + "AND      NVL(WAK_DA_RISK_FUND,0) >= 0 "
		    + "AND      NOT EXISTS (SELECT 1 FROM PT_IL_PREM_COLL "
		    + "WHERE PC_SYS_ID =WAK_DA_PC_SYS_ID "
		    + "AND   PC_PAID_FLAG ='A') "
		    + "UNION ALL "						//14th
		    //0, H, S, 0]
		    + "SELECT   NVL(DDH_DRIP_DATE,ADD_MONTHS(DDH_SUB_DRIP_DATE,-1)),WAK_DA_PC_APPRV_DT "   	
		    + "FROM     PT_LIFE_WAKALAH_DAILY_DRIP,PT_IL_DAILY_DRIP_HDR "
		    + "WHERE    WAK_dA_PC_SYS_ID =DDH_PC_SYS_ID "
		    + "AND      DDH_SYS_ID=? "
		    + "AND      ? IN ('R','D','WA') "
		    + "AND      ? IN ('S','B')	  " 
		    + "AND      NVL(?,0) <> 0 "	  	  
		    + "AND      WAK_DA_PC_SCHD_PYMT_DT IS NOT NULL "
		    + "AND      NVL(WAK_DA_RISK_FUND,0) >= 0 "
		    + "AND      EXISTS (SELECT 1 FROM PT_IL_POLICY "
		    + "WHERE POL_NO = WAK_DA_POL_NO "
		    + "AND   POL_PLAN_CODE = WAK_DA_POL_COVER_CODE) "
		    + "AND      NOT EXISTS (SELECT 1 FROM PT_IL_PREM_COLL "
		    + "WHERE PC_SYS_ID =WAK_DA_PC_SYS_ID "
		    + "AND   PC_PAID_FLAG ='A')" ;
		Object[] values = new Object[]{
			 0, "H", "S", 0,
			
			0, "H", "S", 0,
			
			0, "H", 0,
			
			0, "H", 
			
			0, 101381, "H",
			
			101381, 0, "H", 
			
			101381, 0, "H",
			
			101381, 0, "H",
			
			101381, 0, "H" , 
			
			/*null, 101381, 80458, "H",
			
			null, 101381, 80458, "H", "PREMIADMIN" ,*/
			
			0, 101381, "H",
			
			0, "H", "S", 0,
			
			0, "H", "S", 0 
		};
		
		resultSet = handler.executeSelectStatement(POST_QUERY_CURSOR_C1, connection, values);
		while(resultSet.next()){
		    System.out.println(resultSet.getDate(1) + ", " + resultSet.getDate(2));
		}
		 
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	    } catch (SQLException e) {
		e.printStackTrace();
	    } finally{
		try {
		    CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }

	}
	
	public void postQuery(PT_IL_UNIT_FUND_REG_HDR fundRegHeader) throws Exception{
		Date M_FTH_SWITCH_DT = null;
		Date M_DATE = null;
		Object[] values = null;
		//[0, H, S, 0,- 
		//0, H, S, 0,- 
	
		String POST_QUERY_CURSOR_C1 = " SELECT   PC_SCHD_PYMT_DT,PC_APPRV_DT    " 	
		    + "FROM     PT_IL_PREM_COLL "
		    + "WHERE    PC_SYS_ID=? "
		    + "AND      ? IN ('P') "
		    + "AND      ? IN ('B','S' ) "
		    + "AND      PC_PAID_FLAG ='A'   "
		    + "AND      NVL(?,0) <> 0 "  
		    + "UNION "							//2nd
		    + "SELECT   NVL(DDH_DRIP_DATE,ADD_MONTHS(DDH_SUB_DRIP_DATE,-1)),PC_APPRV_DT "     	
		    + "FROM     PT_IL_PREM_COLL,PT_IL_DAILY_DRIP_HDR "
		    + "WHERE    PC_SYS_ID =DDH_PC_SYS_ID "
		    + "AND      PC_PAID_FLAG ='A' "
		    + "AND      DDH_SYS_ID=? "
		    + "AND      ? IN ('R','D','WA') "
		    + "AND      ? IN ('B','S' ) "
		    + "AND      NVL(?,0) <> 0 "	  
		    + "UNION "							//3rd
			//0, H, 0, 
		    //0, H,4th
		 
		    /*Commented and Modified by Janani on 09.01.2018 for ZBLIFE-1459615 as per Gauravs suggestion*/ 
		    
		    //+ "SELECT DDH_DRIP_DATE,NULL "
		    + "SELECT DDH_DRIP_DATE,ADD_MONTHS(DDH_SUB_DRIP_DATE, -1) "
		    
		    /*End of ZBLIFE-1459615*/
		    
		    + "FROM   PT_IL_DAILY_DRIP_HDR "
		    + "WHERE  DDH_SYS_ID =? "
		    + "AND    NVL(DDH_PC_SYS_ID,0) = 0 "
		    + "AND      ? IN ('R','D','WA') "	 	  
		    + "AND    NVL(?,0) = 0 "
		    + "UNION ALL   "					//4th
		    + "SELECT   TU_APPRV_DT,TU_APPRV_DT " 
		    + "FROM     PT_IL_TOP_UP "
		    + "WHERE    TU_SYS_ID = ? "
		    + "AND      ? ='T' "
		    + "UNION ALL "	
		    //0, 101381, H,
		    //101381, 0, H,
		    + "SELECT FTH_SWITCH_DT,FTH_SWITCH_DT " //5th
		    + "FROM   PT_IL_FUND_TRAN_HDR "
		    + "WHERE  FTH_SYS_ID     =? "
		    + "AND    FTH_POL_SYS_ID =? "
		    + "AND    ? ='H' "
		    + "UNION ALL "						//6th
		    + "SELECT SMV_DATE,SMV_DATE  "
		    + "FROM   PT_IL_SURR_MAT_VALUES    "
		    + "WHERE  SMV_POL_SYS_ID = ? "
		    + "AND    SMV_SYS_ID     = ? "
		    + "AND    ? IN('S','M') "
		    + "UNION ALL "						//7th
		   // 101381, 0, H,
		    //101381, 0, H, 
		    + "SELECT WD_DATE,WD_DATE  "
		    + "FROM   PT_IL_WITHDRAWAL    "
		    + "WHERE  WD_POL_SYS_ID = ? "
		    + "AND    WD_SYS_ID     = ? "
		    + "AND    ? ='W' "
		    + "UNION ALL "						//8th
		    + "SELECT CLAIM_INTM_DT,CLAIM_LOSS_DT "
		    + "FROM   PT_IL_CLAIM    "
		    + "WHERE  CLAIM_POL_SYS_ID = ?     "      
		    + "AND    CLAIM_SYS_ID     = ? "
		    + "AND    ? ='C' "
		    + "UNION  ALL "						//9th
		    //101381, 0, H, 
		    
		    + "SELECT UFRH_TRAN_DT,UFRH_TRAN_DT "
		    + "FROM   PT_IL_UNIT_FUND_REG_HDR "
		    + "WHERE  UFRH_POL_SYS_ID =?   "        
		    + "AND    UFRH_PC_SYS_ID  = ? "
		    + "AND    ? ='E' "
		    + "UNION ALL "						//10th
		    //null, 101381, 80458, H,
		    //TODO PENDING for technical clarification
		 /*   + "SELECT UFRH_TRAN_DT,? "
		    + "FROM   PT_IL_UNIT_FUND_REG_HDR "
		    + "WHERE  UFRH_POL_SYS_ID =? "          
		    + "AND    UFRH_SYS_ID  = ? "
		    + "AND    ? ='AJ' " 
		    + "UNION ALL "						//11th
		    //null, 101381, 80458, H, PREMIADMIN, 
		    + "SELECT UFRH_TRAN_DT,? "
		    + "FROM   PT_IL_UNIT_FUND_REG_HDR "
		    + "WHERE  UFRH_POL_SYS_ID =? "          
		    + "AND    UFRH_SYS_ID  = ? "
		    + "AND    ? ='S' "
		    + "AND    ? = 'IM36174P' " 
		    + "UNION ALL "	*/					//12th
		    //0, 101381, H,
		    + "SELECT BON_CR_DT, BON_CR_DT "
		    + "FROM   PT_IL_BONUS "
		    + "WHERE  BON_SYS_ID = ? "
		    + "AND    BON_POL_SYS_ID = ? "
		    + "AND    ? ='B' "
		    + "UNION ALL	   "				//13th
		    // 0, H, S, 0, 
		    + "SELECT   WAK_DA_PC_SCHD_PYMT_DT, WAK_DA_PC_APPRV_DT "
		    + "FROM     PT_LIFE_WAKALAH_dAILY_DRIP,PT_IL_POLICY "
		    + "WHERE    WAK_DA_PC_SYS_ID=? "
		    + "AND      ? IN ('P') "
		    + "AND      ? = 'B'   "
		    + "AND      NVL(?,0) <> 0 "  
		    + "AND      WAK_DA_PC_SCHD_PYMT_DT IS NOT NULL "
		    + "AND      WAK_DA_POL_NO = POL_NO "
		    + "AND      WAK_Da_POL_COVER_CODE = POL_PLAN_CODE "
		    + "AND      NVL(WAK_DA_RISK_FUND,0) >= 0 "
		    + "AND      NOT EXISTS (SELECT 1 FROM PT_IL_PREM_COLL "
		    + "WHERE PC_SYS_ID =WAK_DA_PC_SYS_ID "
		    + "AND   PC_PAID_FLAG ='A') "
		    + "UNION ALL "						//14th
		    //0, H, S, 0]
		    + "SELECT   NVL(DDH_DRIP_DATE,ADD_MONTHS(DDH_SUB_DRIP_DATE,-1)),WAK_DA_PC_APPRV_DT "   	
		    + "FROM     PT_LIFE_WAKALAH_DAILY_DRIP,PT_IL_DAILY_DRIP_HDR "
		    + "WHERE    WAK_dA_PC_SYS_ID =DDH_PC_SYS_ID "
		    + "AND      DDH_SYS_ID=? "
		    + "AND      ? IN ('R','D','WA') "
		    + "AND      ? IN ('S','B')	  " 
		    + "AND      NVL(?,0) <> 0 "	  	  
		    + "AND      WAK_DA_PC_SCHD_PYMT_DT IS NOT NULL "
		    + "AND      NVL(WAK_DA_RISK_FUND,0) >= 0 "
		    + "AND      EXISTS (SELECT 1 FROM PT_IL_POLICY "
		    + "WHERE POL_NO = WAK_DA_POL_NO "
		    + "AND   POL_PLAN_CODE = WAK_DA_POL_COVER_CODE) "
		    + "AND      NOT EXISTS (SELECT 1 FROM PT_IL_PREM_COLL "
		    + "WHERE PC_SYS_ID =WAK_DA_PC_SYS_ID "
		    + "AND   PC_PAID_FLAG ='A')";
		values = new Object[]{fundRegHeader.getUFRH_TRANS_SYS_ID(),
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_BUY_SEL(),
				fundRegHeader.getUFRH_PC_SYS_ID(), 
				fundRegHeader.getUFRH_TRANS_SYS_ID(),	//2nd
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_BUY_SEL(),
				fundRegHeader.getUFRH_PC_SYS_ID(),
				fundRegHeader.getUFRH_TRANS_SYS_ID(),	//3rd
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_PC_SYS_ID(),
				fundRegHeader.getUFRH_TRANS_SYS_ID(),	//4th
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_TRANS_SYS_ID(),	//5th
				fundRegHeader.getUFRH_POL_SYS_ID(),
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_POL_SYS_ID(),		//6th
				fundRegHeader.getUFRH_TRANS_SYS_ID(),
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_POL_SYS_ID(),		//7th
				fundRegHeader.getUFRH_TRANS_SYS_ID(),
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_POL_SYS_ID(),		//8th
				fundRegHeader.getUFRH_TRANS_SYS_ID(),
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_POL_SYS_ID(),		//9th
				fundRegHeader.getUFRH_PC_SYS_ID(),
				fundRegHeader.getUFRH_TYPE(),
				//TODO Pending for technical clarification
				/*M_DATE,									//10th
				fundRegHeader.getUFRH_POL_SYS_ID(),		
				fundRegHeader.getUFRH_SYS_ID(),
				fundRegHeader.getUFRH_TYPE(),
				M_DATE,									//11th
				fundRegHeader.getUFRH_POL_SYS_ID(),		
				fundRegHeader.getUFRH_SYS_ID(),
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_CR_UID(),*/
				fundRegHeader.getUFRH_TRANS_SYS_ID(),	//12th
				fundRegHeader.getUFRH_POL_SYS_ID(),
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_PC_SYS_ID(),		//13th
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_BUY_SEL(),
				fundRegHeader.getUFRH_PC_SYS_ID(),
				fundRegHeader.getUFRH_TRANS_SYS_ID(),	//14th
				fundRegHeader.getUFRH_TYPE(),
				fundRegHeader.getUFRH_BUY_SEL(),
				fundRegHeader.getUFRH_PC_SYS_ID()
				};
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(POST_QUERY_CURSOR_C1, connection, values);
			if(resultSet.next()){
				fundRegHeader.setPC_SCHD_PYMT_DT(resultSet.getDate(1));
				fundRegHeader.setPC_PAID_DT(resultSet.getDate(2));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}

	public void onCheckDeleteMaster(PT_IL_UNIT_FUND_REG_HDR fundRegHeaderBean) throws Exception{
		String DUMMY_DEFINE = null;
		Object[] values = null;
		String PT_IL_UNIT_FUND_REG_DTL_CUR = "SELECT 1 FROM PT_IL_UNIT_FUND_REG_DTL P "     
			+ "WHERE P.UFRD_UFRH_SYS_ID = ?";
		String PS_IL_UNIT_FUND_REG_CUR = "SELECT 1 FROM ps_il_unit_fund_reg p "     
			+ "WHERE p.UFR_POL_SYS_ID = ?";
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{fundRegHeaderBean.getUFRH_SYS_ID()};
			resultSet1 = handler.executeSelectStatement(PT_IL_UNIT_FUND_REG_DTL_CUR, 
					connection, values);
			if(resultSet1.next()){
				DUMMY_DEFINE = resultSet1.getString(1);
				throw new Exception("Cannot delete master record when matching detail records exist.");
			}
			
			values = new Object[]{fundRegHeaderBean.getUFRH_POL_SYS_ID()};
			resultSet2 = handler.executeSelectStatement(PS_IL_UNIT_FUND_REG_CUR, 
					connection, values);
			if(resultSet2.next()){
				DUMMY_DEFINE = resultSet1.getString(1);
				throw new Exception("Cannot delete master record when matching detail records exist.");
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet1);}catch(Exception exc){}
			try{CommonUtils.closeCursor(resultSet2);}catch(Exception exc){}
		}
	}
	
	public void preQuery(PT_IL_UNIT_FUND_REG_HDR_ACTION fundRegHdrAction){
		String M_WHERE = null;
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");
		
		if(CALLING_FORM != null && CALLING_FORM.startsWith("PILT003_APAC")){
			M_WHERE = " UFRH_TRANS_SYS_ID = "+CommonUtils.getGlobalVariable("GLOBAL.G_PC_SYS_ID")+" AND UFRH_TYPE ='P' ";
			fundRegHdrAction.setDEFAULT_WHERE(M_WHERE);
		}
	}
	
	public void onPopulateDetails(PT_IL_UNIT_FUND_REG_HDR unitFundHdrBean, 
			PILQ106_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		if(unitFundHdrBean.getUFRH_SYS_ID() != null){
			new PT_IL_UNIT_FUND_REG_DTL_HELPER().executeQuery(compositeAction);
		}
		
		if(unitFundHdrBean.getUFRH_POL_SYS_ID() != null){
			//rel_id := Find_Relation('PT_IL_UNIT_FUND_REG_HDR.PT_IL_UNIT_FUND_PS_IL_UNIT_FUN');   
	    	//Query_Master_Details(rel_id, 'PS_IL_UNIT_FUND_REG');
			new PS_IL_UNIT_FUND_REG_HELPER().executeQuery(compositeAction);
		}
		/*Added by Ameen on 13-04-2018 for KIC*/
		if(unitFundHdrBean.getUFRH_SYS_ID() != null){
			new PT_IL_UNIT_FUND_CHARGE_HELPER().executeQuery(compositeAction);
		}
	}
	
	public void whenNewRecordInstance(PT_IL_UNIT_FUND_REG_HDR regHdrBean, DUMMY dummyBean){
		CommonUtils.setGlobalVariable("GLOBAL.UFRH_POL_NO", dummyBean.getUI_M_POL_NO());
		CommonUtils.setGlobalObject("GLOBAL.UFRH_SYS_ID", regHdrBean.getUFRH_SYS_ID());
		CommonUtils.setGlobalVariable("GLOBAL.UFRH_TYPE", regHdrBean.getUFRH_TYPE());
	}
}
