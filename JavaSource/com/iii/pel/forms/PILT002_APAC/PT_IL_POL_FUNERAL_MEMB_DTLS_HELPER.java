package com.iii.pel.forms.PILT002_APAC;

import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM055_APAC.CompositeAction;
import com.iii.pel.forms.PILT002_APAC_QE.PKG_PILT002_APAC_QE;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_FUNERAL_MEMB_DTLS_HELPER {


	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_POL_FUNERAL_MEMB_DTLS_DELEGATE()
		.executeSelectStatement(compositeAction);

		List<PT_IL_POL_FUNERAL_MEMB_DTLS> dataList = compositeAction
				.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_FUNERAL_MEMB_DTLS PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN = dataList.get(0);
			PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN()
			.setPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
			
			/*added by raja on 02-03-2016 for funeral benifit fsd*/
			
			setClaimStatus(PT_IL_POL_FUNERAL_MEMB_DTLS_BEAN);
			
			/*end*/
		}
		
		
	}


	public void preInsert(PT_IL_POLICY policyBean, CTRL ctrlBean,
			PT_IL_POL_FUNERAL_MEMB_DTLS funeralBean) throws Exception {

		String M_UNQ_ADDL_COVER_YN = null;
		Double M_NO_ASSR = null;
		String M_APPL_ALL = null;
		String CURSOR_C1 = "SELECT PT_IL_PBEN_SYS_ID.NEXTVAL FROM DUAL ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				funeralBean.setPFMD_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			funeralBean.setPFMD_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			funeralBean.setPFMD_CR_DT(new CommonUtils().getCurrentDate());
			funeralBean.setPFMD_CR_UID(ctrlBean.getUSER_ID());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preUpdate(PT_IL_POLICY policyBean, CTRL ctrlBean,
			PT_IL_POL_FUNERAL_MEMB_DTLS funeralBean) throws Exception {
		try {
			funeralBean.setPFMD_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			funeralBean.setPFMD_UPD_DT(new CommonUtils().getCurrentDate());
			funeralBean.setPFMD_CR_UID(ctrlBean.getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void validatePFMD_CUST_CODE(PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_FUNERAL_MEMB_DTLS bean) throws Exception
	{
		try{
			Boolean flag=false;
			ResultSet resultset,resultSet1=null;
			CRUDHandler handler= new CRUDHandler();
			
			PT_IL_POLICY pt_il_policy_bean = compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
			
			/*added by raja on 13-06-2017 for ZBILQC-1724894*/ 
			
			LIFELIB lifelib = new LIFELIB();
			 lifelib.P_VAL_CUST(bean.getPFMD_CUST_CODE(),
					 bean.getPFMD_CUST_DESC(), "N", "N",
					 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());
			 
			/*end*/
			 

			 /*Added by Janani on 23.01.2018 for ZBLIFE-1444238*/
			 String CURSOR_C2 = "SELECT PLAN_TYPE FROM PCOM_APP_PARAMETER,PM_IL_PLAN WHERE PARA_CODE = 'IL_RIDER_TY'"
					 + " AND PARA_VALUE = PLAN_CODE AND PARA_SUB_CODE = (SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER"
					 + " WHERE POAC_COVER_CODE = COVER_CODE AND COVER_TYPE <> 'B' AND COVER_FUNERAL_CVR_YN = 'Y' AND POAC_POL_SYS_ID = ?)";


			 /*End of ZBLIFE-1444238*/
			 
			 
			/*changed by raja for funeral benifit fsd*/
			if(bean.getPFMD_CUST_CODE()!=null)
			{
				/*end*/
				/*ADDED BY SANKARA NARAYANAN ON 29/03/2017*/
					String query="select * from pm_customer where cust_code=?";
					
					/*Modified by Janani on 16.01.2018 for ZBLIFE-1471888*/
					/*String CURSOR_C1 = "select P9ilpk_F_Policy.F_FUN_MEMB_THRES_LMT(?,?) from dual";	
				ResultSet resultSet1 = handler.executeSelectStatement(CURSOR_C1, CommonUtils.getConnection(),
						new Object[] {bean.getPFMD_CUST_CODE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE()});*/
					
					String CURSOR_C1 = "select P9ilpk_F_Policy.F_FUN_MEMB_THRES_LMT(?,?,?) from dual";	
					
					
					/*Added by Janani on 23.01.2018 for ZBLIFE-1444238*/
					
					
					ResultSet resultSet2 = new CRUDHandler().executeSelectStatement(CURSOR_C2, CommonUtils.getConnection(),
							new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
					
				
					
					if (resultSet2.next()) {
						
						String plan_type = resultSet2.getString("PLAN_TYPE");
						
						System.out.println("plan_type in validatePFMD_CUST_CODE      "+plan_type);
						
						 resultSet1 = handler.executeSelectStatement(CURSOR_C1, CommonUtils.getConnection(),
									new Object[] {bean.getPFMD_CUST_CODE(),plan_type,bean.getPFMD_POL_SYS_ID()});
						
					}
					else
					{
						/*End of ZBLIFE-1444238*/
					
					 resultSet1 = handler.executeSelectStatement(CURSOR_C1, CommonUtils.getConnection(),
							new Object[] {bean.getPFMD_CUST_CODE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE(),bean.getPFMD_POL_SYS_ID()});
					
					}
					/*End of ZBLIFE-1471888*/
					
				if (resultSet1.next()) {
					bean.setPFMD_LC_THRESHOLD_LMT(resultSet1.getDouble(1));
					
				}
				/*END*/
				
			resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{bean.getPFMD_CUST_CODE()});
			while(resultset.next())
			{
				flag=true;
				bean.setPFMD_ADDRESS1(resultset.getString("CUST_ADDR1"));
				bean.setPFMD_ADDRESS2(resultset.getString("CUST_ADDR2"));
				bean.setPFMD_ADDRESS3(resultset.getString("CUST_ADDR3"));
				bean.setPFMD_CANTACT(resultset.getString("CUST_CONTACT"));
				bean.setPFMD_MEMB_DOB(resultset.getDate("CUST_DOB"));
				bean.setPFMD_PHONE(resultset.getString("CUST_PHONE"));
				bean.setPFMD_CUST_DESC(resultset.getString("CUST_NAME"));
				bean.setUI_M_NATIONAL_ID(resultset.getString("CUST_REF_ID1"));
				bean.setPFMD_GENDER(resultset.getString("CUST_CATG_CODE"));
				/*added by gopi for ssp call id ZBILQC-1726698 on 12/06/17*/
				bean.setPFMD_AGE_PROOF_FLAG(resultset.getString("CUST_AGE_PROOF_FLAG"));
				bean.setPFMD_AGE_PROOF_OTHERS(resultset.getString("CUST_AGE_PROOF_OTHERS"));
				/*end*/
				
				/*Newly Added By Dhinesh on 15-06-2017 for ssp call id  ZBILQC-1727540*/
				bean.setUI_M_PFMD_MEMB_DOB(CommonUtils.dateToStringFormat(bean.getPFMD_MEMB_DOB()));
				/*End*/
			}
			if(flag==false)
			{
				throw new Exception("Code does not exist in customer Master");
			}
			/*changed by raja for funeral benifit fsd*/
			}
			else
			{
				throw new Exception("Code does required");
			}
			/*end*/
			/*added by raja on 02-03-2016 for funeral benifit fsd*/
			
			setClaimStatus(bean);
			/*end*/
			// age calculation
			ArrayList<OracleParameter> list2 = null;
			PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
			DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
/*added by rja on 16-05-2017*/
			
			if(bean.getPFMD_MEMB_DOB()!=null)
			{
			
			/*end*/	
			/*
			 * Modified parameters by ganesh to update the dependant mainmember alone while changing Life
			 * assured code/Contractor code on 24-01-2018 as suggested by sivaram
			 */	
			/*list2 = localProcedure.P_CALC_ANB(new CommonUtils().getCurrentDate(), bean.getPFMD_MEMB_DOB(),
					dummyBean.getUI_M_PROD_AGE_CALC_FLAG(),bean.getPFMD_MEMB_AGE());*/
			list2 = localProcedure.P_CALC_ANB(pt_il_policy_bean.getPOL_START_DT(), bean.getPFMD_MEMB_DOB(),
					dummyBean.getUI_M_PROD_AGE_CALC_FLAG(),bean.getPFMD_MEMB_AGE());
			/*end*/
			if (list2 != null && !list2.isEmpty()) {
				if (list2.get(0).getValueObject() != null) {
					bean.setPFMD_MEMB_AGE((Integer)list2.get(0).getValueObject());
				}
			}
		}
			
/*added by raja on 22-5-2017*/
			
			ArrayList<String> list3 = null;
			
			
			if (bean.getPFMD_GENDER() != null) {
				list3 = DBProcedures.P_VAL_SYSTEM("CATG", bean.getPFMD_GENDER(), bean
						.getUI_M_PFMD_GENDER_DESC(), "E",null);
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						bean.setUI_M_PFMD_GENDER_DESC(list3.get(0));
					}
					
				}
			}
			
			/*end*/	
			
			/*added by raja on 14-07-2017 for ZBILQC-1731814*/
			custSubStandaredValidation(compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN(),bean);
			/*end*/
		}

		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/*added by raja on 02-03-2016 for funeral benifit fsd*/
	
	public void setClaimStatus(PT_IL_POL_FUNERAL_MEMB_DTLS bean) throws SQLException, DBException
	{
		/*ResultSet resultset1=null;
		String status=null;
		String queryclaim="select CLAIM_STATUS from pt_il_claim where CLAIM_ASSR_CODE=?";
		resultset1=new CRUDHandler().executeSelectStatement(queryclaim, CommonUtils.getConnection(), new Object[]{bean.getPFMD_CUST_CODE()});
		while(resultset1.next())
		{
			status=resultset1.getString("CLAIM_STATUS");
		}
		if(status!=null && status.equalsIgnoreCase("A"))
		{
			bean.setPFMD_STATUS_UI(true);
		}
		else
		{
			bean.setPFMD_STATUS_UI(false);
		}*/
	}

	/*end*/
	public void validatePFMD_RELATION_TYPE(PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_FUNERAL_MEMB_DTLS BEAN,String value) throws Exception
	{
		try{
			int count=0;
			boolean flag=false;
			int rowindex=compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataTable().getRowIndex();
			System.out.println("row index  "+ compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataTable().getRowIndex());
			
			if(compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getROWID()!=null)
			{
				if((compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS().size()==0) || 
						(compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataTable().getRowIndex()==0))
				{
					System.out.println("value ++++++>>"+value );
					if(!(value.equalsIgnoreCase("01")))
					{
						throw new Exception("First Relationship should be Assured");
					}
				}
			}
			else
			{
				if((compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS().size()==0))
				{
					System.out.println("value ++++++>>"+value );
					if(!(value.equalsIgnoreCase("01")))
					{
						throw new Exception("First Relationship should be Assured");
					}
				}
			}

			if(value.equalsIgnoreCase("01"))
			{
				if(BEAN.getROWID()!=null)
				{
				 for(PT_IL_POL_FUNERAL_MEMB_DTLS  bn: compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS()) {
						if((bn.getPFMD_RELATION_TYPE().equalsIgnoreCase("01")))
						{
							count++;
							/*throw new Exception("Assured only can use self relation type");*/
						}
								
				 }
				 if(count>1)
				 {
					 /*changed by raja on 23-05-2017 for ZBILQC-1727275*/
					/* throw new Exception("Multiple Self are not allowed");*/
					 throw new Exception("Multiple Principal are not allowed");
					 /*end*/
				 }
				}
				else
				{
					for(PT_IL_POL_FUNERAL_MEMB_DTLS  bn: compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS()) {
						if((bn.getPFMD_RELATION_TYPE().equalsIgnoreCase("01")))
						{
							 /*changed by raja on 23-05-2017 for ZBILQC-1727275*/
							/*throw new Exception("Multiple Princeple are not allowed");*/
							throw new Exception("Multiple Principal are not allowed");
							 /*end*/
						}
								
				 }
				}
				 
				String query="select 'X' from pm_assured where assr_code=?";
				ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{BEAN.getPFMD_CUST_CODE()});
				if(resultset.next())
				{
					flag=true;
					if(!value.equalsIgnoreCase("01"))
					{
						throw new Exception("First Relationship should be Assured");
					}
				}
				if(flag==false)
				{
					throw new Exception("Code does not exist in assured master");
				}
				query="select ASSR_DOB from pm_assured where assr_code=?";
				resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{BEAN.getPFMD_CUST_CODE()});
				while(resultset.next())
				{
					BEAN.setPFMD_MEMB_DOB(resultset.getDate("ASSR_DOB"));
					
					/*Newly Added By Dhinesh on 15-06-2017 for ssp call id  ZBILQC-1727540*/
					BEAN.setUI_M_PFMD_MEMB_DOB(CommonUtils.dateToStringFormat(BEAN.getPFMD_MEMB_DOB()));
					/*End*/
				}
			}
			
			String queryrel="select 'X' from pt_il_pol_assured_dtls where POAD_POL_SYS_ID=? and POAD_ASSR_CODE=?";
			ResultSet resultsetrel=new CRUDHandler().executeSelectStatement(queryrel, CommonUtils.getConnection(), 
					new Object[]{CommonUtils.getGlobalVariable("GLOBAL.POL_SYS_ID"),BEAN.getPFMD_CUST_CODE()});
			if(resultsetrel.next())
			{
				
				if(!value.equalsIgnoreCase("01"))
				{
					 /*changed by raja on 23-05-2017 for ZBILQC-1727275*/
					/*throw new Exception("Assured should the Self Relation type");*/
					throw new Exception("Assured should the Principal Relation type");
					/*end*/
				}
			}
			
		
		String query="SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE "
				+ "LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
				+ "LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' "
				+ "AND liv_code=?";	
	
		ResultSet resultSet1=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), 
				new Object[]{value});
		
		while(resultSet1.next())
		{
			BEAN.setPFMD_RELATION_DESC(resultSet1.getString("LIV_CODE_DESC"));
		}
		/*added by gopi for showing description for relation type on 01/02/17*/
		/*
		 * commneted by Ameen on 11-07-2017 for ZBILQC-1731204
		 * String query1="SELECT LIV_CODE_DESC,LIV_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = 'FUN_MEM_TYPE' AND LIV_CODE = ? ";	
	
		ResultSet resultSet2=new CRUDHandler().executeSelectStatement(query1, CommonUtils.getConnection(), 
				new Object[]{value});
		
		while(resultSet2.next())
		{
			BEAN.setPFMD_MEMB_TYPE(resultSet2.getString("LIV_CODE_DESC"));
			BEAN.setPFMD_MEMB_TYPE_DESC(resultSet2.getString("LIV_DESC"));
		}*/
		/*END*/
		
		/*Modified by ganesh on 23-10-2017 as suggested by ajoy */
		/*String query1=" SELECT PC_CODE , PC_DESC  FROM PM_IL_PLAN_MEMB, PM_CODES WHERE PC_TYPE='IL_DEP_TYP' AND PMEM_DEP_TYPE = PC_CODE AND PMEM_RELATION_TYPE  = ? AND PMEM_PLAN_CODE = ? AND ROWNUM = 1  ";	
		
		ResultSet resultSet21=new CRUDHandler().executeSelectStatement(query1, CommonUtils.getConnection(), 
				new Object[]{value,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});*/
		
		/*Modified by saritha on 12-01-2018 for 207R rider cover*/
		/*String query1=" SELECT PC_CODE , PC_DESC  FROM PM_IL_PLAN_MEMB, PM_CODES WHERE PC_TYPE='IL_DEP_TYP' AND PMEM_DEP_TYPE = PC_CODE AND PMEM_RELATION_TYPE  = ? AND PMEM_PLAN_CODE = ? AND ? BETWEEN NVL(PMEM_MIN_AGE_ENTRY,0) AND NVL(PMEM_MAX_AGE_ENTRY,0)  ";
		
		
		ResultSet resultSet21=new CRUDHandler().executeSelectStatement(query1, CommonUtils.getConnection(), 
				new Object[]{value,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE(), BEAN.getPFMD_MEMB_AGE()});
		end
		
		while(resultSet21.next())
		{
			BEAN.setPFMD_MEMB_TYPE(resultSet21.getString("PC_CODE"));
			BEAN.setPFMD_MEMB_TYPE_DESC(resultSet21.getString("PC_DESC"));
		}*/
		
		String query1=" SELECT PC_CODE , PC_DESC  FROM PM_IL_PLAN_MEMB, PM_CODES WHERE PC_TYPE='IL_DEP_TYP' AND PMEM_DEP_TYPE = PC_CODE AND PMEM_RELATION_TYPE  = ? AND PMEM_PLAN_CODE = ? AND ? BETWEEN NVL(PMEM_MIN_AGE_ENTRY,0) AND NVL(PMEM_MAX_AGE_ENTRY,0)  ";

		String depQuery = "SELECT PC_CODE , PC_DESC FROM PM_IL_PLAN_MEMB, PM_CODES, PCOM_APP_PARAMETER WHERE PMEM_DEP_TYPE = PC_CODE AND PC_TYPE = 'IL_DEP_TYP' "
				+ "AND PARA_CODE = 'IL_RIDER_TY' AND PMEM_PLAN_CODE = PARA_VALUE AND PMEM_RELATION_TYPE = ?  AND "
				+ "PARA_SUB_CODE = (SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER WHERE POAC_COVER_CODE = COVER_CODE "
				+ "AND COVER_TYPE <> 'B' AND COVER_FUNERAL_CVR_YN = 'Y' AND POAC_POL_SYS_ID = ?) AND ? BETWEEN NVL(PMEM_MIN_AGE_ENTRY, 0) "
				+ "AND NVL(PMEM_MAX_AGE_ENTRY, 0)";


		if(compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPlanTypeLorH()!=null){

			ResultSet rstDependantType=new CRUDHandler().executeSelectStatement(query1, CommonUtils.getConnection(), 
					new Object[]{value,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE(), BEAN.getPFMD_MEMB_AGE()});

			if(rstDependantType.next()){
				BEAN.setPFMD_MEMB_TYPE(rstDependantType.getString("PC_CODE"));
				BEAN.setPFMD_MEMB_TYPE_DESC(rstDependantType.getString("PC_DESC"));
			}

		}else{

			ResultSet rstDependantType207R=new CRUDHandler().executeSelectStatement(depQuery, CommonUtils.getConnection(), 
					new Object[]{value,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),BEAN.getPFMD_MEMB_AGE()});
			
			if(rstDependantType207R.next()){

			BEAN.setPFMD_MEMB_TYPE(rstDependantType207R.getString("PC_CODE"));
			BEAN.setPFMD_MEMB_TYPE_DESC(rstDependantType207R.getString("PC_DESC"));

			}
		}
	
		/*End*/
		
		
		/*compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getCOMP_PFMD_MEMB_TYPE().resetValue();
		compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getCOMP_PFMD_MEMB_TYPE_DESC().resetValue();*/
		
		/*aDDED BY SANKARA NARAYANAN FOR hOSPITAL CASH pLAN ON 25/04/2017*/
		String C2 ="SELECT PMEN_NO_OF_DAYS FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE=? AND PMEM_PLAN_CODE=? ";
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet3 = null;
				resultSet3 = handler.executeSelectStatement(C2, CommonUtils.getConnection(),
					new Object[] {value,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
			if (resultSet3.next()) {
				BEAN.setPFMD_NO_OF_DAYS( resultSet3.getInt("PMEN_NO_OF_DAYS"));
				
			} 
			/*END*/
		
			/* Newly Added By Dhinesh on 19-7-2017 for ssp call id : ZBILQC-1732375 */
			/*added by raja on 24-07-2017 for  ZBILQC-1732855*/
			/*String QUERY_PM_IL_PLAN_MEMB= "SELECT PMEM_DEP_TYPE  FROM PM_IL_PLAN_MEMB WHERE PMEM_PLAN_CODE = ? AND PMEM_RELATION_TYPE= ? ";*/
			
			if(BEAN.getPFMD_MEMB_TYPE()==null)
			{
			String QUERY_PM_IL_PLAN_MEMB= "select * from pm_il_plan_memb where PMEM_PLAN_CODE=? and PMEM_RELATION_TYPE=? "
					+ "and ? between PMEM_MIN_AGE_ENTRY and PMEM_MAX_AGE_ENTRY";
			/*end*/
			
			String QUERY_PM_CODES=" select PC_CODE,PC_DESC  from  pm_codes where pc_type='IL_DEP_TYP' and pc_code= ? ";	
		
			ResultSet resultSet2=new CRUDHandler().executeSelectStatement(QUERY_PM_IL_PLAN_MEMB, CommonUtils.getConnection(), 
					new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE(),value,
				BEAN.getPFMD_MEMB_AGE()});
			
			while(resultSet2.next())
			{
				BEAN.setPFMD_MEMB_TYPE(resultSet2.getString("PMEM_DEP_TYPE"));
			}
		
			ResultSet resultSet4=new CRUDHandler().executeSelectStatement(QUERY_PM_CODES, CommonUtils.getConnection(), 
					new Object[]{BEAN.getPFMD_MEMB_TYPE()});
			
			while(resultSet4.next())
			{
				BEAN.setPFMD_MEMB_TYPE(resultSet4.getString("PC_CODE"));
				BEAN.setPFMD_MEMB_TYPE_DESC(resultSet4.getString("PC_DESC"));
			}
		
			compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getCOMP_PFMD_MEMB_TYPE().resetValue();
			compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getCOMP_PFMD_MEMB_TYPE_DESC().resetValue();
			}
			/* End */
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void checkDuplicate(PT_IL_POL_FUNERAL_MEMB_DTLS_ACTION actionBean) throws Exception
	{
		try{

			Boolean flag=false;
			String query="select * from pm_customer where cust_code=?";
			System.out.println("cust code  >"+actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_CUST_CODE());
			ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_CUST_CODE()});
			while(resultset.next())
			{
				flag=true;

			}
			if(flag==false)
			{
				throw new Exception("Code does not exist in customer Master");
			}


			if(actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getROWID() != null)
			{
				int i=0;
				for(PT_IL_POL_FUNERAL_MEMB_DTLS  bn: actionBean.getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS()) {
					if(bn.getPFMD_CUST_CODE().equalsIgnoreCase(actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_CUST_CODE()))
					{
						i++;
					}
				}
				System.out.println("i value   ==   >"+i);
				if(i>1)
				{
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "90015", new Object[] { "Customer" }));
				}
			}
			else
			{
				for(PT_IL_POL_FUNERAL_MEMB_DTLS  bn: actionBean.getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS()) {
					if(bn.getPFMD_CUST_CODE().equalsIgnoreCase(actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_CUST_CODE()))
					{
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "90015", new Object[] { "Customer" }));
					}
				}
			}
			/*if(actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getROWID()!=null){
				if((actionBean.getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS().size()==0) || (actionBean.getRowindex()==0))
				{
					String value=null;
					String Query="select POAD_ASSR_CODE from PT_IL_POL_ASSURED_DTLS where poad_pol_sys_id=?";
					ResultSet rs=new CRUDHandler().executeSelectStatement(Query, 
							CommonUtils.getConnection(), new Object[]{CommonUtils.getGlobalVariable("GLOBAL.POL_SYS_ID")});
					while(rs.next())
					{
						value=rs.getString("POAD_ASSR_CODE");
					}
					if(!(value.equalsIgnoreCase(actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_CUST_CODE())))
					{
						throw new Exception("Code does not match to assure code");
					}
				}
			}
			else
			{
				if(actionBean.getDataList_PT_IL_POL_FUNERAL_MEMB_DTLS().size()==0)
				{
					String value=null;
					String Query="select POAD_ASSR_CODE from PT_IL_POL_ASSURED_DTLS where poad_pol_sys_id=?";
					ResultSet rs=new CRUDHandler().executeSelectStatement(Query, 
							CommonUtils.getConnection(), new Object[]{CommonUtils.getGlobalVariable("GLOBAL.POL_SYS_ID")});
					while(rs.next())
					{
						value=rs.getString("POAD_ASSR_CODE");
					}
					if(!(value.equalsIgnoreCase(actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_CUST_CODE())))
					{
						actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_CURR_ASSR_UI(false);
						actionBean.getCOMP_PFMD_CURR_ASSR().resetValue();
						throw new Exception("Code does not match to assure code");
					}
					
					}
			}*/
			
			if(actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_RELATION_TYPE().equalsIgnoreCase("01"))
			{
				String value=null;
				/*Modifed by Shankar on 27/03/2017
				 * 
				 * String Query="select POAD_ASSR_CODE from PT_IL_POL_ASSURED_DTLS where poad_pol_sys_id=?";
				 * End
				 * */
				String Query=" SELECT POL_CONT_CODE POAD_ASSR_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID=?";
				
				ResultSet rs=new CRUDHandler().executeSelectStatement(Query, 
						CommonUtils.getConnection(), new Object[]{CommonUtils.getGlobalVariable("GLOBAL.POL_SYS_ID")});
				while(rs.next())
				{
					value=rs.getString("POAD_ASSR_CODE");
				}
				if(!(value.equalsIgnoreCase(actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_CUST_CODE())))
				{
					actionBean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_CURR_ASSR_UI(false);
					actionBean.getCOMP_PFMD_CURR_ASSR().resetValue();
					throw new Exception("Code does not match to assure code");
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


	public void validatePFMD_MEMB_DOB(PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_FUNERAL_MEMB_DTLS BEAN,Date value)
	{
		try{

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	
	
	/*Added by Ram on 01/11/2016 for Age Calculation Issue*/
	public void calculateAge(PILT002_APAC_COMPOSITE_ACTION compositeAction,java.util.Date POAD_DOB) throws Exception
	{
		PT_IL_POLICY policybean=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ArrayList<OracleParameter> list1 = new  ArrayList<OracleParameter>();
		CommonUtils commonUtils = new CommonUtils();
		try {
			
			
			/*Added by Ram on 01/11/2016 for DOB Validation missing issue*/
			if(POAD_DOB == null)
			{
				throw new Exception("Date of Birth Value is Required");
			}
			/*End*/
			if (POAD_DOB.after(commonUtils.getCurrentDate())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71030"));
			}
			if (POAD_DOB != null) {


				ResultSet resultSet = null;

				String VALIDATE_QUERY = "SELECT PROD_AGE_CALC_FLAG FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
				String param_age="";

				resultSet = new CRUDHandler().executeSelectStatement(
						VALIDATE_QUERY, CommonUtils.getConnection(),
						new Object[] { policybean.getPOL_PROD_CODE() });
				if (resultSet.next()) {

					param_age=resultSet.getString("PROD_AGE_CALC_FLAG");
				} else {
					param_age="2";
				}
	         
				if (policybean.getPOL_START_DT().before(POAD_DOB)) {
					throw new Exception(Messages.getString("messageProperties_PILT002_APAC","IL_001"));
				}
				list1 = PKG_PILT002_APAC_QE.P_CALC_ANB(
						policybean.getPOL_START_DT(),
						POAD_DOB, 
						param_age,
						0);
				//CommonUtils.getProcedureValue(Quick_Dtls.getQQAD_AGE()));
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						if((Integer)list1.get(0).getValueObject()>0){
							compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_MEMB_AGE((Integer)list1.get(0).getValueObject());
						//	Quick_Bean.setQUOT_MAX_AGE((Integer)list1.get(0).getValueObject());
						}
						else{
							throw new Exception("Age Must be Greater Than Zero");
						}
					}

				}

			}

		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}


	}
	/*End*/

	
	public void fecthdata(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception
	{
		try{
			
			/*change the quary by raja on 22-02-2017 for default values*/
			
			/*
			 * cOMMENTED BY SANKARA NARAYANAN FOR HOSPITAL CASH PAN ON 25/04/2017
			 * String query="select POAD_SYS_ID,POAD_REF_ID1,POAD_ASSR_CODE,POAD_ASSURED_NAME,POAD_DOB,POAD_AGE"
					+ "(select POL_FC_SUM_ASSURED from pt_il_policy where pol_sys_id = poad_pol_sys_id) "
					+ "SUM_ASSURED from PT_IL_POL_ASSURED_DTLS where poad_pol_sys_id=?";*/
			
			/*CHANGED BY SANKARA NARAYANAN FOR HOSPITAL CASH PAN ON 25/04/2017*/
			PT_IL_POL_FUNERAL_MEMB_DTLS bean=compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN();
			String query="select POAD_SYS_ID,POAD_REF_ID1,POAD_ASSR_CODE,POAD_ASSURED_NAME,POAD_DOB,POAD_AGE,POAD_CATG_CODE,"
					+ "(select POL_FC_SUM_ASSURED from pt_il_policy where pol_sys_id = poad_pol_sys_id) "
					+ "SUM_ASSURED from PT_IL_POL_ASSURED_DTLS where poad_pol_sys_id=?";
			/*end*/
			
			
			/*Modified by Janani on 16.01.2018 for ZBLIFE-1471888*/
			//String CURSOR_C1 = "select P9ilpk_F_Policy.F_FUN_MEMB_THRES_LMT(?,?) from dual";	
			String CURSOR_C1 = "select P9ilpk_F_Policy.F_FUN_MEMB_THRES_LMT(?,?,?) from dual";
			
			
			/*End of ZBLIFE-1471888*/
			
			/*Added by Janani on 23.01.2018 for ZBLIFE-1444238*/
			String CURSOR_C2 = "SELECT PLAN_TYPE FROM PCOM_APP_PARAMETER,PM_IL_PLAN WHERE PARA_CODE = 'IL_RIDER_TY'"
					+ " AND PARA_VALUE = PLAN_CODE AND PARA_SUB_CODE = (SELECT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER"
					+ " WHERE POAC_COVER_CODE = COVER_CODE AND COVER_TYPE <> 'B' AND COVER_FUNERAL_CVR_YN = 'Y' AND POAC_POL_SYS_ID = ?)";
					
			
			/*End of ZBLIFE-1444238*/
			
			
			
			ResultSet resultset=new CRUDHandler().executeSelectStatement(query, 
					CommonUtils.getConnection(), new Object[]{CommonUtils.getGlobalVariable("GLOBAL.POL_SYS_ID")});
			/*Added by ganesh on 17-11-2017 for ZBLIFE-1455133*/
			String relTypeDescQuery = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_PAR_MEMB' AND PC_CODE = ?";
			ResultSet relTypeDescRS,resultSet1 = null;
			
			CRUDHandler relTypeDescCRUD = new CRUDHandler();
			/*end*/
			/*End*/
			while(resultset.next())
			{
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_CUST_CODE(resultset.getString("POAD_ASSR_CODE"));
				
				/*Modified by Janani on 16.01.2018 for ZBLIFE-1471888*/
				
				/*ResultSet resultSet1 = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection(),
						new Object[] {resultset.getString("POAD_ASSR_CODE"),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE()});*/
				
				/*Added by Janani on 23.01.2018 for ZBLIFE-1444238*/
				
				
				ResultSet resultSet2 = new CRUDHandler().executeSelectStatement(CURSOR_C2, CommonUtils.getConnection(),
						new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				
			
				
				if (resultSet2.next()) {
					
					String plan_type = resultSet2.getString("PLAN_TYPE");
					
					System.out.println("plan_type       "+plan_type);
					
					 resultSet1 = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection(),
							new Object[] {resultset.getString("POAD_ASSR_CODE"),plan_type,
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
					
				}
				else
				{
					/*End of ZBLIFE-1444238*/
					
				 resultSet1 = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection(),
						new Object[] {resultset.getString("POAD_ASSR_CODE"),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				
				}
				
				/*End of ZBLIFE-1471888*/
				
				if (resultSet1.next()) {
					compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_LC_THRESHOLD_LMT(resultSet1.getDouble(1));
					
				}
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_CUST_DESC(resultset.getString("POAD_ASSURED_NAME"));
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_SYS_ID(resultset.getLong("POAD_SYS_ID"));
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setUI_M_NATIONAL_ID(resultset.getString("POAD_REF_ID1"));
				/*Modifed by Shankar on 27/03/2017 
				 * 
				 * compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_CUST_DESC(resultset.getString("POAD_ASSURED_NAME"));*/
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_CURR_ASSR_UI(true);
				
				/*change the quary by raja on 22-02-2017 for default values*/
				
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_MEMB_DOB(resultset.getDate("POAD_DOB"));
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_MEMB_AGE(resultset.getInt("POAD_AGE"));
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_SA(resultset.getDouble("SUM_ASSURED"));
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_RELATION_TYPE("01");
				/*Added by ganesh on 17-11-2017 for ZBLIFE-1455133*/
				relTypeDescRS =  relTypeDescCRUD.executeSelectStatement(relTypeDescQuery, CommonUtils.getConnection(), 
						new Object[]{compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_RELATION_TYPE()});
				if(relTypeDescRS.next()){
					compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setUI_M_PFMD_RELATION_DESC(relTypeDescRS.getString("PC_DESC"));
				}
				/*end*/
				/*aDDED BY SANKARA NARAYANAN FOR HOSPITAL CASH PLAN ON 25/04/2017*/
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_GENDER(resultset.getString("POAD_CATG_CODE"));
				/*END*/
				
				/*Newly Added By Dhinesh on 15-06-2017 for ssp call id  */
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setUI_M_PFMD_MEMB_DOB(CommonUtils.dateToStringFormat(resultset.getDate("POAD_DOB")));
				/*end*/
				
			/*end*/
				/*added by gopi for showing description for relation type on 01/02/17*/
				/*
				 * commneted by Ameen on 11-07-2017 for ZBILQC-1731204
				 * String query1="SELECT LIV_CODE_DESC,LIV_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = 'FUN_MEM_TYPE' AND LIV_CODE = ? ";	
			
				ResultSet resultSet2=new CRUDHandler().executeSelectStatement(query1, CommonUtils.getConnection(), 
						new Object[]{compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_RELATION_TYPE()});
				
				while(resultSet2.next())
				{
					compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_MEMB_TYPE(resultSet2.getString("LIV_CODE_DESC"));
					compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_MEMB_TYPE_DESC(resultSet2.getString("LIV_DESC"));
				}*/
				/*END*/
			}

			/*added by raja on 21-07-2017 for ZBILQC-1732674*/
			
			if(bean.getPFMD_CUST_CODE()!=null)
			{
				/*end*/
				/*ADDED BY SANKARA NARAYANAN ON 29/03/2017*/
					String queryCustomer="select * from pm_customer where cust_code=?";
								
			resultset=new CRUDHandler().executeSelectStatement(queryCustomer, CommonUtils.getConnection(), new Object[]{bean.getPFMD_CUST_CODE()});
			while(resultset.next())
			{
				
				bean.setPFMD_ADDRESS1(resultset.getString("CUST_ADDR1"));
				bean.setPFMD_ADDRESS2(resultset.getString("CUST_ADDR2"));
				bean.setPFMD_ADDRESS3(resultset.getString("CUST_ADDR3"));
				bean.setPFMD_CANTACT(resultset.getString("CUST_CONTACT"));
				bean.setPFMD_MEMB_DOB(resultset.getDate("CUST_DOB"));
				bean.setPFMD_PHONE(resultset.getString("CUST_PHONE"));
				bean.setPFMD_CUST_DESC(resultset.getString("CUST_NAME"));
				bean.setUI_M_NATIONAL_ID(resultset.getString("CUST_REF_ID1"));
				bean.setPFMD_GENDER(resultset.getString("CUST_CATG_CODE"));
				/*added by gopi for ssp call id ZBILQC-1726698 on 12/06/17*/
				bean.setPFMD_AGE_PROOF_FLAG(resultset.getString("CUST_AGE_PROOF_FLAG"));
				bean.setPFMD_AGE_PROOF_OTHERS(resultset.getString("CUST_AGE_PROOF_OTHERS"));
				/*end*/
			
				
			}
			
			}
			/*end*/
			
			/*Added by Shankar on 27/03/2017*/
			calculateAge(compositeAction,compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_MEMB_DOB());
/*End*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/*public void callP_CALC_PREMIUM_FUNERAL(long POL_SYS_ID,long POAD_SYS_ID,String POL_PLAN_CODE) throws Exception
	{
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		
		Connection connection = CommonUtils.getConnection();
		
			parameterList = new ArrayList<OracleParameter>();
			outputList=new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN,POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN,POAD_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,POL_PLAN_CODE);
			parameterList.add(param3);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			try {
				
			outputList = procHandler.execute(parameterList, connection,	"P9ilpk_F_Policy.P_CALC_PREMIUM_FUNERAL");
	
			
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			e.printStackTrace();
			throw new ProcedureException(e.getMessage());
		}

	}*/
	
	
	
	public ArrayList<OracleParameter> callP_CALC_PREMIUM_FUNERAL(long POL_SYS_ID,long POAD_SYS_ID,String POL_PLAN_CODE) throws Exception {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, POAD_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, POL_PLAN_CODE);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ilpk_F_Policy.P_CALC_PREMIUM_FUNERAL");
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			e.printStackTrace();
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	
	
	
	/*ADDED BY SANKARA NARAYANAN  ON 29/03/2017*/
	
	
	
	
	
	
	
	
	
	
	
	public void Validatemember(List<PT_IL_POL_FUNERAL_MEMB_DTLS> memberlist)throws Exception{
		
		
		double sumAssued0=0.0;
		double sumAssued1=0.0;
		double sumAssued2=0.0;
		double sumAssued3=0.0;
		double sumAssued4=0.0;
		double sumAssued5=0.0;
		double sumAssued6=0.0;
		
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		int count5=0;
		int count6=0;

		for(PT_IL_POL_FUNERAL_MEMB_DTLS  bean: memberlist) {
			
			System.out.println("SA"+bean.getPFMD_SA());
			if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("01"))
			{
				count1++;
				sumAssued0=sumAssued0+bean.getPFMD_SA();
				Min_Max_value(sumAssued0,bean.getPFMD_RELATION_TYPE().toString());
				/*cust_validation(sumAssued0,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());*/

			}

			if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("02"))
			{
				count1++;
				sumAssued1=sumAssued1+bean.getPFMD_SA();
				no_of_live(count1,bean.getPFMD_RELATION_TYPE().toString());
				Min_Max_value(sumAssued1,bean.getPFMD_RELATION_TYPE().toString());
				
				////cust_validation(sumAssued1,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());

			}
			else if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("03"))
			{
				count2++;
				sumAssued2=sumAssued2+bean.getPFMD_SA();
				no_of_live(count2,bean.getPFMD_RELATION_TYPE().toString());
				Min_Max_value(sumAssued2,bean.getPFMD_RELATION_TYPE().toString());
				
				//cust_validation(sumAssued2,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
			}
			else if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("04"))
			{
				count3++;
				sumAssued3=sumAssued3+bean.getPFMD_SA();
				no_of_live(count3,bean.getPFMD_RELATION_TYPE().toString());
				Min_Max_value(sumAssued3,bean.getPFMD_RELATION_TYPE().toString());
				
				//cust_validation(sumAssued3,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
			}
			else if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("05"))

			{
				count4++;
				sumAssued4=sumAssued4+bean.getPFMD_SA();
				no_of_live(count4,bean.getPFMD_RELATION_TYPE().toString());
				Min_Max_value(sumAssued4,bean.getPFMD_RELATION_TYPE().toString());
				
				//cust_validation(sumAssued4,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
			}
			else if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("06"))
			{
				count5++;
				sumAssued5=sumAssued5+bean.getPFMD_SA();
				no_of_live(count5,bean.getPFMD_RELATION_TYPE().toString());
				Min_Max_value(sumAssued5,bean.getPFMD_RELATION_TYPE().toString());
				
				//cust_validation(sumAssued5,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
			}

			else if(bean.getPFMD_RELATION_TYPE().equalsIgnoreCase("07"))
			{
				count6++;
				sumAssued6=sumAssued6+bean.getPFMD_SA();
				Min_Max_value(sumAssued6,bean.getPFMD_RELATION_TYPE().toString());
				no_of_live(count6,bean.getPFMD_RELATION_TYPE().toString());
				//cust_validation(sumAssued6,bean.getPFMD_RELATION_TYPE(),bean.getPFMD_CUST_CODE());
			}
		}
	}
	
	public void Min_Max_value(double sumAssured, String relation_type) throws Exception {
		/*
		 * 
		 * cOMMENTED BY SANKARA NARAYANAN FOR hOSPITAL CASHPLAN ON 25/04/2017
		 * String query ="SELECT nvl(PMEM_MIN_SA,0) PMEM_MIN_SA,nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? ";*/
		
		String query ="SELECT nvl(PMEM_MIN_SA,0) PMEM_MIN_SA,nvl(PMEM_MAX_SA,0) PMEM_MAX_SA FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE =? AND PMEM_PLAN_CODE=?";
		
		CRUDHandler handler = new CRUDHandler();
		Double PMEM_MIN_SA =0.0;
		Double PMEM_MAX_SA =0.0;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] {relation_type});
			if (resultSet.next()) {
				PMEM_MIN_SA = resultSet.getDouble("PMEM_MIN_SA");
				PMEM_MAX_SA = resultSet.getDouble("PMEM_MAX_SA");
			} 
			Double mem_sumassured=sumAssured;
			
			if(mem_sumassured!=0)
			{
			if(PMEM_MIN_SA!=null && PMEM_MAX_SA!=null)
			{
				String relDesc=null;
			if(mem_sumassured<PMEM_MIN_SA)
			{
				
				String queryreldesc="SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE "
						+ "LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
						+ "LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' "
						+ "AND liv_code=?";	
			
				ResultSet resultSetRelDesc=new CRUDHandler().executeSelectStatement(queryreldesc, connection, 
						new Object[]{relation_type});
				
				while(resultSetRelDesc.next())
				{
					relDesc= resultSetRelDesc.getString("LIV_CODE_DESC");
				}
				
				throw new Exception("Total Sum Assured should be Start from " +PMEM_MIN_SA+ "  for  " +relDesc);
			}else if(mem_sumassured>PMEM_MAX_SA){
				
				double remaining_Sum_Assured=PMEM_MAX_SA-mem_sumassured;
				String queryreldesc="SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE "
						+ "LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
						+ "LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' "
						+ "AND liv_code=?";	
			
				ResultSet resultSetRelDesc=new CRUDHandler().executeSelectStatement(queryreldesc, connection, 
						new Object[]{relation_type});
				
				while(resultSetRelDesc.next())
				{
					relDesc= resultSetRelDesc.getString("LIV_CODE_DESC");
				}
				throw new Exception("Sum assured can be less than or equal to  " +PMEM_MAX_SA+ "  for "  +relDesc);
			}
			}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
	}
	
	
	public void no_of_live(int count, String relation_type) throws Exception {
		String query ="SELECT PMEM_NO_OF_LIFE FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE=? ";
		CRUDHandler handler = new CRUDHandler();
		int live=0;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { relation_type});
			if (resultSet.next()) {
				live = resultSet.getInt("PMEM_NO_OF_LIFE");
				
			} 
			
			
			if(live!=0)
			{
		 
			if(count>live)
			{
				String relDesc=null;
				String queryreldesc="SELECT LIV_CODE, LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE "
						+ "LI_SYS_PARAM = LIV_SYS_PARAM AND  LI_MODULE_NAME  ='PILT002_APAC' AND "
						+ "LI_BLOCK_NAME = 'PT_IL_POL_FUNERAL_MEMB_DTLS' AND LI_ITEM_NAME= 'PT_IL_POL_FUNERAL_MEMB_DTLS.PFMD_RELATION_TYPE' "
						+ "AND liv_code=?";	
			
				ResultSet resultSetRelDesc=new CRUDHandler().executeSelectStatement(queryreldesc, connection, 
						new Object[]{relation_type});
				
				while(resultSetRelDesc.next())
				{
					relDesc= resultSetRelDesc.getString("LIV_CODE_DESC");
				}
				
				throw new Exception("Numer of allowed " +relDesc+" dependant exceeds the limit");
			}
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
	}
	
	/*END*/
	
	/*added by raja on 03-04-2017 for Age proof validation*/
	
	public void PFMD_AGE_PROOF_FLAG_WHEN_VALIDATE_ITEM(PT_IL_POL_FUNERAL_MEMB_DTLS_ACTION action_bean,PILT002_APAC_COMPOSITE_ACTION compositeAction)
	{
		try{
		if("0".equalsIgnoreCase(action_bean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().getPFMD_AGE_PROOF_FLAG()) 
				&& (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()==null 
				|| compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("ADDDEP"))
				&& !compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS().equalsIgnoreCase("A")
				&& !compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("Y"))
		{
			action_bean.getCOMP_PFMD_AGE_PROOF_OTHERS().setDisabled(false);
			action_bean.getCOMP_PFMD_AGE_PROOF_OTHERS().setRequired(true);
			
		}
		else
		{
			action_bean.getCOMP_PFMD_AGE_PROOF_OTHERS().setDisabled(true);
			action_bean.getCOMP_PFMD_AGE_PROOF_OTHERS().setRequired(false);
			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*end*/
	
	public void whenNewRecord(PT_IL_POL_FUNERAL_MEMB_DTLS_ACTION action_bean)
	{
		try
		{
			//action_bean.getPT_IL_POL_FUNERAL_MEMB_DTLS_BEAN().setPFMD_AGE_PROOF_FLAG("2");
			action_bean.getCOMP_PFMD_AGE_PROOF_OTHERS().setDisabled(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/*added by raja on 16-05-2017*/
	public void validateAge(int age,String relationType,String plan_code,String member_type) throws Exception
	{
		try{
			int membAge=0;
			int minage=0;
			String query="SELECT PMEM_MIN_AGE_ENTRY,PMEM_MAX_AGE_ENTRY FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE=? and PMEM_PLAN_CODE=? and PMEM_DEP_TYPE =?"; 
			ResultSet ageRS=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), 
					new Object[]{relationType,plan_code,member_type});
			while(ageRS.next())
			{
				membAge=ageRS.getInt("PMEM_MAX_AGE_ENTRY");
				minage=ageRS.getInt("PMEM_MIN_AGE_ENTRY");
			}
			if(membAge>0)
			{
				if(age>membAge || age<minage)
				{
					/*added by raja on 18-06-2017 for ZBILQC-1723319*/
					/*throw new Exception("Age should be lesser than equal to Member Age Setup");*/
					throw new Exception("Member age should between  "+ minage  + "and"  + membAge);
					/*end*/
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
		/*end*/
	/*Added by Ameen on 11-07-2017 for ZBILQC-1731204*/
	public void PFMD_MEMB_TYPE_WHEN_VALIDATE_ITEM(PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_FUNERAL_MEMB_DTLS FUNERAL_MEMB_DTLS_BEAN) throws Exception{
		/*String query = "SELECT PMEM_MAX_AGE_ENTRY FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE = ? AND PMEM_DEP_TYPE = ? AND PMEM_PLAN_CODE = ?";*/
		String query = "SELECT PMEM_MIN_AGE_ENTRY,PMEM_MAX_AGE_ENTRY FROM PM_IL_PLAN_MEMB WHERE PMEM_RELATION_TYPE = ? AND PMEM_DEP_TYPE = ? AND PMEM_PLAN_CODE = ?";
		ResultSet rs = null;
		Connection con = null;
		
		int MAX_AGE = 0;
		int MIN_AGE = 0;
		try {
			con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, con, 
					new Object[]{FUNERAL_MEMB_DTLS_BEAN.getPFMD_RELATION_TYPE(),FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE(),
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PLAN_CODE()});
			if(rs.next()){
						MIN_AGE= rs.getInt("PMEM_MIN_AGE_ENTRY");
						MAX_AGE = rs.getInt("PMEM_MAX_AGE_ENTRY");
				if(MAX_AGE < FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_AGE() || MIN_AGE > FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_AGE()){
					throw new Exception("Member age should between  " + MIN_AGE + " and " + MAX_AGE);
				}
			}else{
				throw new Exception("As Per Setup Relation Type with Dependent Type doesn't match");
			}
			
			/*Added by Janani on 05.06.2018 for FLA funeral changes*/
			if(FUNERAL_MEMB_DTLS_BEAN.getPFMD_MEMB_TYPE().equalsIgnoreCase("mm"))
			{
				FUNERAL_MEMB_DTLS_BEAN.setPFMD_PREM_CALC_TYPE("I");
				compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().getCOMP_PFMD_PREM_CALC_TYPE().setDisabled(true);
			}
			
			/*End*/
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/*end*/
	/*added by raja on 14-07-2017 for ZBILQC-1731814*/
	public void custSubStandaredValidation(PT_IL_POL_FUNERAL_MEMB_DTLS_ACTION actionBean,PT_IL_POL_FUNERAL_MEMB_DTLS bean)
	{
		try{
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> pValList1 = new ArrayList<OracleParameter>();
		pValList1 = pkg_pilt002_apac.PR_IL_WARNING_MSG_SUB_STD_REG(bean.getPFMD_CUST_CODE(),null);
		String status_msg = null;
		if (pValList1.get(0) != null) {
			//pt_il_policy_bean.setP_STATUS((String) pValList1.get(0).getValueObject());
			status_msg = (String) pValList1.get(0).getValueObject();
		}
		actionBean.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,status_msg);

		
	}
	
	catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	/*end*/
}
