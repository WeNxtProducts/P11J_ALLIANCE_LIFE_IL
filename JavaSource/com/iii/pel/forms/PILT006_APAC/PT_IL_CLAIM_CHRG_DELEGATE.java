package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_DFLT_CHARGE_CONSTANTS;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_CLAIM_CHRG_DELEGATE{
	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION PILT006_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PT_IL_CLAIM pt_il_claim_bean = PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		String selectStatement ="SELECT ROWID, PT_IL_CLAIM_CHARGES.* FROM PT_IL_CLAIM_CHARGES WHERE CC_CLM_SYS_ID =? ";

		String query ="SELECT PC_DESC FROM PM_CODES where PC_CODE=?";

		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSetDesc = null;
		PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_CHRG_ACTION_BEAN()
				.getDataList_PT_IL_SURR_CHRG().clear();
		try {
			
			
			/*added by raja on 25-04-2017*/
			ArrayList<String> list = null;
			DBProcedures procedures = new DBProcedures();
			/*end*/
			
			
			
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{pt_il_claim_bean.getCLAIM_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_CLAIM_CHRG PT_IL_CLAIM_CHRG_BEAN = new PT_IL_CLAIM_CHRG();
				PT_IL_CLAIM_CHRG_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_CLAIM_CHRG_BEAN.setCC_SYS_ID(resultSet.getLong("CC_SYS_ID"));
				PT_IL_CLAIM_CHRG_BEAN.setCC_CLM_SYS_ID(resultSet.getLong("CC_CLM_SYS_ID"));
				PT_IL_CLAIM_CHRG_BEAN.setCC_CHRG_CODE(resultSet.getString("CC_CHRG_CODE"));
				PT_IL_CLAIM_CHRG_BEAN.setCC_RATE(resultSet.getDouble("CC_RATE"));
				PT_IL_CLAIM_CHRG_BEAN.setCC_RATE_PER(resultSet.getDouble("CC_RATE_PER"));
				PT_IL_CLAIM_CHRG_BEAN.setCC_CHRG_LC_VALUE(resultSet.getDouble("CC_CHRG_LC_VALUE"));
				PT_IL_CLAIM_CHRG_BEAN.setCC_CHRG_FC_VALUE(resultSet.getDouble("CC_CHRG_FC_VALUE"));
				PT_IL_CLAIM_CHRG_BEAN.setCC_REMARKS(resultSet.getString("CC_REMARKS"));
				resultSetDesc = new CRUDHandler().executeSelectStatement(
						query, connection,new Object[]{PT_IL_CLAIM_CHRG_BEAN.getCC_CHRG_CODE()});
				if(resultSetDesc.next()){
					PT_IL_CLAIM_CHRG_BEAN.setUI_M_CC_CHRG_CODE_DESC(resultSetDesc.getString("PC_DESC"));
				}
				
				
				/*added by raja on 25-04-2017*/
				PT_IL_CLAIM_CHRG_BEAN.setCC_PAID_TO(resultSet.getString("CC_PAID_TO"));
				PT_IL_CLAIM_CHRG_BEAN.setCC_BENF_CODE(resultSet.getString("CC_BENF_CODE"));
				if(PT_IL_CLAIM_CHRG_BEAN.getCC_BENF_CODE()!=null)
				{
				list = procedures.helperP_VAL_CUST(
						PT_IL_CLAIM_CHRG_BEAN.getCC_BENF_CODE(), "N", "N");
				if (!list.isEmpty() && list.get(0) != null)
					PT_IL_CLAIM_CHRG_BEAN.setCC_BENF_CODE_DESC(list.get(0));
				}
				/*end*/
				
				
				
				PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_CHRG_ACTION_BEAN()
				.getDataList_PT_IL_SURR_CHRG()
						.add(PT_IL_CLAIM_CHRG_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	/*Modified by Janani on 05.09.2017 for ZBILQC-1732454*/
	
	/*public List prepareCatgCodeList(String catgCode, List catgCodeList)*/
	
	public List prepareCatgCodeList(String catgCode,List catgCodeList, PILT006_APAC_COMPOSITE_ACTION compositeAction) 
			throws Exception
	
	/*eND */
	 {

		String query = null;
		Connection connection = CommonUtils.getConnection();
		
		/*Modified by Janani on 05.09.2017 for ZBILQC-1732454*/
		CRUDHandler handler = new CRUDHandler();
		ResultSet C1_REC = null;
		String POL_PROD_CODE = null;
		
		//List catgCodeList = new ArrayList<String>();
		/*End of ZBILQC-1732454*/
		try {
			
			/*Modified by Janani on 05.09.2017 for ZBILQC-1732454*/
			String C1 = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID= ?";
			
			C1_REC= handler.executeSelectStatement(C1, connection,
					new Object[] {compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()});
			while (C1_REC.next()) {
				POL_PROD_CODE = C1_REC.getString("POL_PROD_CODE");
			}
			
			System.out.println("POL_PROD_CODE                "+POL_PROD_CODE);
			
			/*End of ZBILQC-1732454*/
			
			if ("*".equalsIgnoreCase(catgCode)) {
				query = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.QUERY$PILM013_APAC$DFLT_CHRG_CODE;
				
				/*Modified by Janani on 05.09.2017 for ZBILQC-1732454*/
				
				//Object[] object = {};
				Object[] object = {POL_PROD_CODE};
				
				/*End of ZBILQC-1732454*/
				
				catgCodeList = catgLOV(connection, query, object);
								

			} else {
				catgCode = catgCode + "%";
				
				/*Modified by Janani on 05.09.2017 for ZBILQC-1732454*/
				
				//Object[] object = { catgCode };
				Object[] object = { catgCode ,POL_PROD_CODE};
				
				/*End of ZBILQC-1732454*/
								
				query = PM_IL_DOC_DFLT_CHARGE_CONSTANTS.QUERY1$PILM013_APAC$DFLT_CHRG_CODE;
				catgCodeList = catgLOV(connection, query, object);
			}
			
			} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
						
		}
		return catgCodeList;
	}
	
	public List<PT_IL_CLAIM_CHRG> catgLOV(Connection connection,
			String query, Object[] object) throws Exception {
		List<PT_IL_CLAIM_CHRG> catgCodeList = new ArrayList<PT_IL_CLAIM_CHRG>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			resultSet = handler.executeSelectStatement(query, connection,
					object);
			while (resultSet.next()) {
				PT_IL_CLAIM_CHRG pm_il_doc_dflt_charge = new PT_IL_CLAIM_CHRG();
				pm_il_doc_dflt_charge.setCC_CHRG_CODE(resultSet.getString(1));
				pm_il_doc_dflt_charge.setUI_M_CC_CHRG_CODE_DESC(resultSet
						.getString(2));
				catgCodeList.add(pm_il_doc_dflt_charge);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return catgCodeList;
	}
	
	
}
