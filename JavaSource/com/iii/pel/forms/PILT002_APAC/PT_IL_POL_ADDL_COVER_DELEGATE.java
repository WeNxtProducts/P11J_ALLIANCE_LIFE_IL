package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ADDL_COVER_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction ) throws Exception {

		Connection connection = null;
		ResultSet resultSet= null; 
		ResultSet rs_mop=null;
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
				.getDataList_PT_IL_POL_ADDL_COVER().clear();
		try {
			
			System.out.println("executeSelectStatement called in cover page");
			connection = CommonUtils.getConnection();
			/*String selectStatement = "SELECT PT_IL_POL_ADDL_COVER.ROWID, PT_IL_POL_ADDL_COVER.* " +
					" FROM PT_IL_POL_ADDL_COVER , PT_IL_POL_COVER_GROUP " +
					" WHERE PT_IL_POL_COVER_GROUP.PCG_POL_SYS_ID=PT_IL_POL_ADDL_COVER.POAC_POL_SYS_ID " +
					" AND PT_IL_POL_COVER_GROUP.PCG_SYS_ID= PT_IL_POL_ADDL_COVER.POAC_PCG_SYS_ID" +
					" AND PT_IL_POL_COVER_GROUP.PCG_POAD_SYS_ID =PT_IL_POL_ADDL_COVER.POAC_POAD_SYS_ID" +
					" AND PT_IL_POL_COVER_GROUP.PCG_PAPP_SYS_ID = PT_IL_POL_ADDL_COVER.POAC_PAPP_SYS_ID " +
					" AND POAC_POAD_SYS_ID = ? AND  POAC_POL_SYS_ID = ? AND  " +
					" POAC_PAPP_SYS_ID = ?  AND  POAC_PCG_SYS_ID= ? ";*/
			
			String selectStatement = "SELECT PT_IL_POL_ADDL_COVER.ROWID, PT_IL_POL_ADDL_COVER.* " +
			" FROM PT_IL_POL_ADDL_COVER  WHERE POAC_POL_SYS_ID =   ?  AND POAC_POAD_SYS_ID = ?  ";
			
			Long poadSysId = (Long) CommonUtils.getGlobalObject("POAD_SYS_ID");

	/*		resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection,
					new Object[] {compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN().getPCG_POAD_SYS_ID(),
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN().getPCG_POL_SYS_ID(),
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN().getPCG_PAPP_SYS_ID(),
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN().getPCG_SYS_ID()});
	*/		
			
			System.out.println("POAD_POL_SYS_ID    : "+compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_SYS_ID()+"     poadSysId    "+poadSysId);
			resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection,
					new Object[] {compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_SYS_ID(),
							poadSysId});
		//	String query_mop = " SELECT PROD_PREM_PAY_YRS  FROM  PM_IL_PRODUCT WHERE   PROD_CODE = ? ";
			
			
			while (resultSet.next()) {
				PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();

				PT_IL_POL_ADDL_COVER_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_SYS_ID(resultSet.getLong("POAC_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_POL_SYS_ID(resultSet.getLong("POAC_POL_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PAPP_SYS_ID(resultSet.getLong("POAC_PAPP_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PCG_SYS_ID(resultSet.getLong("POAC_PCG_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_COVER_CODE(resultSet.getString("POAC_COVER_CODE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_APPL_ALL(resultSet.getString("POAC_APPL_ALL"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ASSR_CODE(resultSet.getString("POAC_ASSR_CODE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE(resultSet.getDouble("POAC_RATE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_PREM(resultSet.getDouble("POAC_LC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_PREM(resultSet.getDouble("POAC_FC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_DEL_FLAG(resultSet.getString("POAC_DEL_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_CR_DT(resultSet.getDate("POAC_CR_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_CR_UID(resultSet.getString("POAC_CR_UID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_UPD_DT(resultSet.getDate("POAC_UPD_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_UPD_UID(resultSet.getString("POAC_UPD_UID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_POAD_SYS_ID(resultSet.getLong("POAC_POAD_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PERIOD(resultSet.getInt("POAC_PERIOD"));
				/*Added By Gopinath 31.5.2016*/

				
				/*if ("Y".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT())
						|| "H".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT())
						|| "M".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT())
						|| "Q".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_MODE_OF_PYMT())) {
					rs_mop = new CRUDHandler().executeSelectStatement(query_mop, connection,
							new Object[] { compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE() });
				if (rs_mop.next()) {
					
					PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PREM_PAY_YRS(rs_mop.getInt(1));
					}
					
				} else {
					
					PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PREM_PAY_YRS(1);
				}*/
				/*End*/
				
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PREM_PAY_YRS(resultSet.getInt("POAC_PREM_PAY_YRS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FM_DT(resultSet.getDate("POAC_FM_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_TO_DT(resultSet.getDate("POAC_TO_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_SA(resultSet.getDouble("POAC_FC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_SA(resultSet.getDouble("POAC_LC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_PER(resultSet.getDouble("POAC_RATE_PER"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_TARIFF_TERM_FLAG(resultSet.getString("POAC_TARIFF_TERM_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_APPLIED_ON(resultSet.getString("POAC_RATE_APPLIED_ON"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_RATE(resultSet.getDouble("POAC_ORG_RATE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_RATE_PER(resultSet.getDouble("POAC_ORG_RATE_PER"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_PERIOD(resultSet.getInt("POAC_ORG_PERIOD"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_PREM_PAY_YRS(resultSet.getDouble("POAC_ORG_PREM_PAY_YRS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_FC_SA(resultSet.getDouble("POAC_ORG_FC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_SA(resultSet.getDouble("POAC_ORG_LC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_PREM(resultSet.getDouble("POAC_ORG_LC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_FC_PREM(resultSet.getDouble("POAC_ORG_FC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_WOP_FLAG(resultSet.getString("POAC_WOP_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_MED_DAYS(resultSet.getDouble("POAC_MED_DAYS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_MED_AMT(resultSet.getDouble("POAC_LC_MED_AMT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_MED_DAYS(resultSet.getDouble("POAC_ORG_MED_DAYS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_MED_AMT(resultSet.getDouble("POAC_ORG_LC_MED_AMT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_MASTER_SYS_ID(resultSet.getLong("POAC_MASTER_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_NO_OF_UNIT(resultSet.getDouble("POAC_NO_OF_UNIT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_NO_OF_UNIT(resultSet.getDouble("POAC_ORG_NO_OF_UNIT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LIMIT_TYPE(resultSet.getString("POAC_LIMIT_TYPE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PER_DAY_LC_AMT(resultSet.getDouble("POAC_PER_DAY_LC_AMT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LIMIT_DAYS(resultSet.getInt("POAC_LIMIT_DAYS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_LIMIT(resultSet.getDouble("POAC_LC_LIMIT"));

/*Added By Dhinesh 27.5.2016*/
				PT_IL_POL_ADDL_COVER_BEAN.setUI_M_POAC_COVER_DESC(FETCH_COVER_DESC(resultSet.getString("POAC_COVER_CODE")));
				/*End*/

				/*added by R. Raja for add the EMR Rate field*/
				
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_EMR_RATE(resultSet.getDouble("POAC_EMR_RATE"));
				String emr=Double.toString(resultSet.getDouble("POAC_EMR_RATE"));
				PT_IL_POL_ADDL_COVER_BEAN.setUI_POAC_EMR_RATE(CommonUtils.Decimal_Convert(emr));
				
				/*End*/
				
				/*Added by Ram on 15/12/2016 for Enabling fields in Datagrid*/
				if(compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getDataList_PT_IL_POL_ADDL_COVER() != null && 
						compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getDataList_PT_IL_POL_ADDL_COVER().size() == 0)
				{
					System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getRowSelected()      "+PT_IL_POL_ADDL_COVER_BEAN.getRowSelected()+" "+
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()+"     "+
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()+"     "+
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
				if(PT_IL_POL_ADDL_COVER_BEAN.getRowSelected() != null && PT_IL_POL_ADDL_COVER_BEAN.getRowSelected().equals("dataTableNonSelectedRow"))
				{
					if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("Y")))
					{
						PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableNonSelectedRow");
						PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableNonSelectedRow");
						PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableNonSelectedRow");
						PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableNonSelectedRow");
						
					}
					 
					else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS().equals("E"))
				{
						if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null &&
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equals("DECSA") || 
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equals("INCSA"))
						{
							PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableSelectedRow");
							PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableSelectedRow");
							/*Modified by ganesh on 28-08-2017, ZBILQC-1736155 as suggested by ajoy*/
							compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_FC_SA().setDisabled(false);							
							/*end*/
						}
						
						 /*Commentted &Modified by saritha on 27-11-2017 for Adding INCTERM & DECTERM as suggested by Ajoy sir*/ 
						/*else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null &&
								compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equals("ALTERM"))
						{*/
						
						else if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null &&
								CommonUtils.isIN(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
										.getPOL_END_CODE(), "ALTERM","INCTERM","DECTERM"))
						
						{
							
						/*End*/
						
							PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableSelectedRow");
							PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableSelectedRow");
						}
					
				}
					else if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("N")))
					{
						PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableSelectedRow");
						PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableSelectedRow");
						PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableSelectedRow");
						PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableSelectedRow");
					}
				}
				else
				{
					PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableNonSelectedRow");
					PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableNonSelectedRow");
					PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableNonSelectedRow");
					PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableNonSelectedRow");
				}
				}
				else
				{
					PT_IL_POL_ADDL_COVER_BEAN.setPERIOD_FIELD_ENABLE("dataTableNonSelectedRow");
					PT_IL_POL_ADDL_COVER_BEAN.setPREMIUM_FIELD_ENABLE("dataTableNonSelectedRow");
					PT_IL_POL_ADDL_COVER_BEAN.setSA_FIELD_ENABLE("dataTableNonSelectedRow");
					PT_IL_POL_ADDL_COVER_BEAN.setEMR_FIELD_ENABLE("dataTableNonSelectedRow");
				}
				/*End*/
				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getDataList_PT_IL_POL_ADDL_COVER().add(PT_IL_POL_ADDL_COVER_BEAN);
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public String FETCH_COVER_DESC(String COVER_CODE) throws Exception 
	{
		System.out.println("inside validate function");
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		connection = CommonUtils.getConnection();
		String CURSOR_C1="SELECT COVER_LONG_DESC FROM PM_IL_COVER WHERE COVER_CODE=?";
		String COVER_LONG_DESC=null;
		
		resultSet = handler.executeSelectStatement(CURSOR_C1,
				connection,new Object[] {COVER_CODE});
		if (resultSet.next()) {
			COVER_LONG_DESC=resultSet.getString("COVER_LONG_DESC");
		}
		return COVER_LONG_DESC;
	}
	public void executeSelectStatement(Long POAD_SYS_ID, Long POAD_POL_SYS_ID,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_ADDL_COVER.* FROM PT_IL_POL_ADDL_COVER WHERE POAC_POAD_SYS_ID = ?  AND POAC_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
				.getDataList_PT_IL_POL_ADDL_COVER().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { POAD_SYS_ID,
							POAD_POL_SYS_ID });
			while (resultSet.next()) {
				PT_IL_POL_ADDL_COVER PT_IL_POL_ADDL_COVER_BEAN = new PT_IL_POL_ADDL_COVER();
				PT_IL_POL_ADDL_COVER_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_SYS_ID(resultSet
						.getLong("POAC_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_POL_SYS_ID(resultSet
						.getLong("POAC_POL_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_COVER_CODE(resultSet
						.getString("POAC_COVER_CODE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_APPL_ALL(resultSet
						.getString("POAC_APPL_ALL"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ASSR_CODE(resultSet
						.getString("POAC_ASSR_CODE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE(resultSet
						.getDouble("POAC_RATE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_PREM(resultSet
						.getDouble("POAC_LC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_PREM(resultSet
						.getDouble("POAC_FC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_DEL_FLAG(resultSet
						.getString("POAC_DEL_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_CR_DT(resultSet
						.getDate("POAC_CR_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_CR_UID(resultSet
						.getString("POAC_CR_UID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_UPD_DT(resultSet
						.getDate("POAC_UPD_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_UPD_UID(resultSet
						.getString("POAC_UPD_UID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_POAD_SYS_ID(resultSet
						.getLong("POAC_POAD_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PERIOD(resultSet
						.getInt("POAC_PERIOD"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_PREM_PAY_YRS(resultSet
						.getInt("POAC_PREM_PAY_YRS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FM_DT(resultSet
						.getDate("POAC_FM_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_TO_DT(resultSet
						.getDate("POAC_TO_DT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_FC_SA(resultSet
						.getDouble("POAC_FC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_SA(resultSet
						.getDouble("POAC_LC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_PER(resultSet
						.getDouble("POAC_RATE_PER"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_TARIFF_TERM_FLAG(resultSet
						.getString("POAC_TARIFF_TERM_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_RATE_APPLIED_ON(resultSet
						.getString("POAC_RATE_APPLIED_ON"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_RATE(resultSet
						.getDouble("POAC_ORG_RATE"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_RATE_PER(resultSet
						.getDouble("POAC_ORG_RATE_PER"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_PERIOD(resultSet
						.getInt("POAC_ORG_PERIOD"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_PREM_PAY_YRS(resultSet
						.getDouble("POAC_ORG_PREM_PAY_YRS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_FC_SA(resultSet
						.getDouble("POAC_ORG_FC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_SA(resultSet
						.getDouble("POAC_ORG_LC_SA"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_PREM(resultSet
						.getDouble("POAC_ORG_LC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_FC_PREM(resultSet
						.getDouble("POAC_ORG_FC_PREM"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_WOP_FLAG(resultSet
						.getString("POAC_WOP_FLAG"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_MED_DAYS(resultSet
						.getDouble("POAC_MED_DAYS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_LC_MED_AMT(resultSet
						.getDouble("POAC_LC_MED_AMT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_MED_DAYS(resultSet
						.getDouble("POAC_ORG_MED_DAYS"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_LC_MED_AMT(resultSet
						.getDouble("POAC_ORG_LC_MED_AMT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_MASTER_SYS_ID(resultSet
						.getLong("POAC_MASTER_SYS_ID"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_NO_OF_UNIT(resultSet
						.getDouble("POAC_NO_OF_UNIT"));
				PT_IL_POL_ADDL_COVER_BEAN.setPOAC_ORG_NO_OF_UNIT(resultSet
						.getDouble("POAC_ORG_NO_OF_UNIT"));

				compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN()
						.getDataList_PT_IL_POL_ADDL_COVER().add(
								PT_IL_POL_ADDL_COVER_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void deleteRecord(Long POAD_SYS_ID, Long POAD_POL_SYS_ID)
			throws Exception {
		String deleteStatement = "DELETE  FROM PT_IL_POL_ADDL_COVER WHERE  POAC_POAD_SYS_ID = ? AND POAC_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					deleteStatement, connection, new Object[] { POAD_SYS_ID,
							POAD_POL_SYS_ID });
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public String Decimal_Convert(String Value)
	{
		if(Value != null)
		{
		int decimalPlaces=0;
		System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
		 decimalPlaces=Integer.parseInt(CommonUtils.getGlobalObject("CURRENCY").toString());//(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
		System.out.println("decimalPlaces   : "+decimalPlaces);
		
		
		BigDecimal bd = new BigDecimal(Value);
	    bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);
	    
	    return bd.toString();
		}
		else
		{
			return "0.000";
		}
	}
}



