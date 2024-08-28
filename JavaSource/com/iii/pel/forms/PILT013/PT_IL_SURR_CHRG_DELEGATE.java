package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_DFLT_CHARGE_CONSTANTS;
import com.iii.pel.forms.PILT006_APAC.PILT006_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT006_APAC.PT_IL_CLAIM_CHRG;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_SURR_CHRG_DELEGATE {
	public void executeSelectStatement(
			PILT013_COMPOSITE_ACTION PILT013_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN();
		String selectStatement = "SELECT ROWID, PT_IL_SURR_CHRG.* FROM PT_IL_SURR_CHRG WHERE SRC_SMV_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_CHRG_ACTION_BEAN()
				.getDataList_PT_IL_SURR_CHRG().clear();
		try {
			
			/*added by raja on 19-04-2017*/
			ArrayList<String> list = null;
			DBProcedures procedures = new  DBProcedures();
			/*end*/
			
			connection = CommonUtils.getConnection();
			
			
			/*Modified  by Janani on 14.07.2017 for ZBILQC-1724475*/
			
			
			System.out.println("getSMV_SYS_ID                "+pt_il_surr_mat_values_bean.getSMV_SYS_ID());
			
			
			System.out.println("getSRC_SMV_SYS_ID                "+PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_CHRG_ACTION_BEAN().
					getPT_IL_SURR_CHRG_BEAN().getSRC_SMV_SYS_ID());
			
			System.out.println("getSMV_POL_SYS_ID                "+	pt_il_surr_mat_values_bean.getSMV_POL_SYS_ID());
			
			System.out.println("getSRC_SYS_ID                "+PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_CHRG_ACTION_BEAN().
					getPT_IL_SURR_CHRG_BEAN().getSRC_SYS_ID());
			
			
			/*resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{pt_il_surr_mat_values_bean.getSMV_POL_SYS_ID()});*/

			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{pt_il_surr_mat_values_bean.getSMV_SYS_ID()});
			
			
			Double totlcchrg = 0.0;
			Double totfcchrg = 0.0;
			
			/*End*/
			
			
			while (resultSet.next()) {
				PT_IL_SURR_CHRG PT_IL_SURR_CHRG_BEAN = new PT_IL_SURR_CHRG();
				PT_IL_SURR_CHRG_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_SURR_CHRG_BEAN.setSRC_SYS_ID(resultSet
						.getLong("SRC_SYS_ID"));
				PT_IL_SURR_CHRG_BEAN.setSRC_SMV_SYS_ID(resultSet
						.getLong("SRC_SMV_SYS_ID"));
				PT_IL_SURR_CHRG_BEAN.setSRC_CHRG_CODE(resultSet
						.getString("SRC_CHRG_CODE"));
				PT_IL_SURR_CHRG_BEAN.setSRC_RATE(resultSet
						.getDouble("SRC_RATE"));
				PT_IL_SURR_CHRG_BEAN.setSRC_RATE_PER(resultSet
						.getDouble("SRC_RATE_PER"));
				PT_IL_SURR_CHRG_BEAN.setSRC_CUST_SHARE_PERC(resultSet
						.getDouble("SRC_CUST_SHARE_PERC"));
				PT_IL_SURR_CHRG_BEAN.setSRC_CHG_LC_VALUE(resultSet
						.getDouble("SRC_CHG_LC_VALUE"));
				PT_IL_SURR_CHRG_BEAN.setSRC_CHG_FC_VALUE(resultSet
						.getDouble("SRC_CHG_FC_VALUE"));
				PT_IL_SURR_CHRG_BEAN.setSRC_SMV_LC_VALUE(resultSet
						.getDouble("SRC_SMV_LC_VALUE"));
				PT_IL_SURR_CHRG_BEAN.setSRC_SMV_FC_VALUE(resultSet
						.getDouble("SRC_SMV_FC_VALUE"));
				PT_IL_SURR_CHRG_BEAN.setSRC_CR_DT(resultSet
						.getDate("SRC_CR_DT"));
				PT_IL_SURR_CHRG_BEAN.setSRC_CR_UID(resultSet
						.getString("SRC_CR_UID"));
				PT_IL_SURR_CHRG_BEAN.setSRC_UPD_DT(resultSet
						.getDate("SRC_UPD_DT"));
				PT_IL_SURR_CHRG_BEAN.setSRC_UPD_UID(resultSet
						.getString("SRC_UPD_UID"));

				
				/*added by raja on 20-04-2017*/
				if(PT_IL_SURR_CHRG_BEAN.getSRC_CHRG_CODE()!=null)
				{
				list = procedures.P_VAL_CODES("IL_CHARGE",PT_IL_SURR_CHRG_BEAN.getSRC_CHRG_CODE(),
						PT_IL_SURR_CHRG_BEAN.getUI_M_SRC_CHRG_DESC(),"N","N",null);
				if (list != null && !list.isEmpty()) {
					if (list.get(0)!= null) {
						/*Modified by Janani on 13.02.2018 for ZB as per Sivaram's suggs.*/
						PT_IL_SURR_CHRG_BEAN.setUI_M_SRC_CHRG_DESC(list.get(0));
						PT_IL_SURR_CHRG_BEAN.setUI_M_SRC_CHRG_CODE_DESC(list.get(0));
						
						System.out.println("getUI_M_SRC_CHRG_CODE_DESC                      "+ PT_IL_SURR_CHRG_BEAN.getUI_M_SRC_CHRG_CODE_DESC());
						
						/*End*/   
					}
				}
				}
				/*end*/
				
				/*Added  by Janani on 09.02.2018 for surrender null issue*/
				
				Double tot_chrg = PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_CHRG_ACTION_BEAN().getTotalCharge();
				
				PT_IL_SURR_CHRG_BEAN.setSRC_CHG_SUM_FC(tot_chrg);
				PT_IL_SURR_CHRG_BEAN.setSRC_SUM_CHG(tot_chrg);
				
				System.out.println("getSRC_SUM_CHG in delegate           "+PT_IL_SURR_CHRG_BEAN.getSRC_SUM_CHG());
				System.out.println("getSRC_CHG_SUM_FC  in delegate           "+PT_IL_SURR_CHRG_BEAN.getSRC_CHG_SUM_FC());
				
				
				PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_SURR_CHRG_ACTION_BEAN()
						.getDataList_PT_IL_SURR_CHRG()
						.add(PT_IL_SURR_CHRG_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	
	/*Added by Janani on 16.02.2018 for showing only charges in setup as per Thiags and Sivaram sugges.*/
	
	public List prepareCatgCodeList(String catgCode,List catgCodeList, PILT013_COMPOSITE_ACTION compositeAction) 
			throws Exception
	
	 {

		String query = null;
		Connection connection = CommonUtils.getConnection();
		
		CRUDHandler handler = new CRUDHandler();
		ResultSet C1_REC = null;
		String POL_PROD_CODE = null;
		
		try {
			
			String C1 = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID= ?";
			
			C1_REC= handler.executeSelectStatement(C1, connection,
					new Object[] {compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_POL_SYS_ID()});
			while (C1_REC.next()) {
				POL_PROD_CODE = C1_REC.getString("POL_PROD_CODE");
			}
			
			System.out.println("POL_PROD_CODE                "+POL_PROD_CODE);
			
			if ("*".equalsIgnoreCase(catgCode)) {
				
				/*query ="SELECT DDCHG_CODE, PC_DESC FROM PM_IL_DOC_DFLT_CHARGE, PM_CODES WHERE DDCHG_DS_TYPE = '4' AND DDCHG_DS_CODE = 'CLM' "
						+ "AND PC_TYPE = 'IL_CHARGE' AND PC_CODE = DDCHG_CODE AND ? BETWEEN DDCHG_PROD_CODE_FM AND DDCHG_PROD_CODE_TO";*/
				
				query = "SELECT WCS_CHARGE_CODE, PC_DESC FROM PM_IL_WDS_CHARGES_SETUP, PM_CODES"
						+ " WHERE  WCS_SETUP_TYPE = 'S' AND PC_TYPE = 'IL_CHARGE'"
						+ " AND PC_CODE = WCS_CHARGE_CODE AND WCS_PROD_CODE = ?";

				Object[] object = {POL_PROD_CODE};
				
				catgCodeList = catgLOV(connection, query, object);
								

			} else {
				catgCode = catgCode + "%";
				
				Object[] object = { catgCode ,POL_PROD_CODE};
							
				/*query="SELECT DDCHG_CODE, PC_DESC FROM PM_IL_DOC_DFLT_CHARGE, PM_CODES WHERE DDCHG_DS_TYPE = '4' AND DDCHG_DS_CODE = 'CLM'"
						+ " AND PC_TYPE = 'IL_CHARGE' AND PC_CODE LIKE ? AND PC_CODE = DDCHG_CODE AND ? BETWEEN DDCHG_PROD_CODE_FM AND DDCHG_PROD_CODE_TO";*/
				
				query = "SELECT WCS_CHARGE_CODE, PC_DESC FROM PM_IL_WDS_CHARGES_SETUP, PM_CODES"
						+ " WHERE  WCS_SETUP_TYPE = 'S' AND PC_TYPE = 'IL_CHARGE'"
						+ " AND PC_CODE LIKE ? AND PC_CODE = WCS_CHARGE_CODE AND WCS_PROD_CODE = ?";
				
				
				catgCodeList = catgLOV(connection, query, object);
			}
			
			} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
						
		}
		return catgCodeList;
	}
	

	public List<PT_IL_SURR_CHRG> catgLOV(Connection connection,
			String query, Object[] object) throws Exception {
		List<PT_IL_SURR_CHRG> catgCodeList = new ArrayList<PT_IL_SURR_CHRG>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			resultSet = handler.executeSelectStatement(query, connection,
					object);
			while (resultSet.next()) {
				PT_IL_SURR_CHRG pt_il_surr_chrg = new PT_IL_SURR_CHRG();
				pt_il_surr_chrg.setSRC_CHRG_CODE(resultSet.getString(1));
				pt_il_surr_chrg.setUI_M_SRC_CHRG_CODE_DESC(resultSet
						.getString(2));
				catgCodeList.add(pt_il_surr_chrg);
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
	
	/*End*/
}
