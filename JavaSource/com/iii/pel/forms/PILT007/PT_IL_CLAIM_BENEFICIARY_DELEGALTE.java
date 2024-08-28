package com.iii.pel.forms.PILT007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_CLAIM_BENEFICIARY_DELEGALTE {
	
	/*Added by sankara narayanan for ZBILQC-1721754 on 09-03-2017*/
	public void executeQuery(PILT007_COMPOSITE_ACTION compositeAction) {
		String queryString = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY11;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
		Long CP_SYS_ID = null;
		if (compositeAction.getReturnString().equals("claimToBePaid")) {
			PT_IL_CLAIM_PAID_ACTION claimPaidAction = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_ACTION();
			CP_SYS_ID = claimPaidAction.getPT_IL_CLAIM_PAID_BEAN()
					.getCP_SYS_ID();
		} else if (compositeAction.getReturnString().equals("claimPaid")) {
			PT_IL_CLAIM_PAID_1_ACTION claimPaidAction = compositeAction
					.getPILT007_PT_IL_CLAIM_PAID_1_ACTION();
			CP_SYS_ID = claimPaidAction.getPT_IL_CLAIM_PAID_1_BEAN()
					.getCP_SYS_ID();
		}
		PT_IL_CLAIM_BENEFICIARY_ACTION claimBeneficiaryAction = compositeAction
				.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();
		List<PT_IL_CLAIM_BENEFICIARY> beneficiaryList = claimBeneficiaryAction
				.getPT_IL_CLAIM_BENEFICIARY_LIST();

		if (claimBeneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_LIST().size() > 0) {
			claimBeneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_LIST().clear();
			// claimBeneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_LIST().clear();
		}

		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			
			/*Commentted &Modified by saritha on 03-01-2017 for ssp call id : ZBLIFE-1464092*/
			
			/*ResultSet rst = handler.executeSelectStatement(queryString,
					connection, new Object[] { CLAIM_SYS_ID  , CP_SYS_ID });*/
			
			ResultSet rst = handler.executeSelectStatement(queryString,
					connection, new Object[] { CP_SYS_ID });
			
			/*End*/
			
			connection.commit();
			while (rst.next()) {
				PT_IL_CLAIM_BENEFICIARY beneficiaryBean = new PT_IL_CLAIM_BENEFICIARY();
				beneficiaryBean.setROWID(rst.getString(1));
				beneficiaryBean.setCBEN_SYS_ID(rst.getLong("CBEN_SYS_ID"));
				beneficiaryBean.setCBEN_CLAIM_SYS_ID(rst
						.getLong("CBEN_CLAIM_SYS_ID"));
				beneficiaryBean
						.setCBEN_CP_SYS_ID(rst.getLong("CBEN_CP_SYS_ID"));
				beneficiaryBean.setCBEN_PBEN_SYS_ID(rst
						.getLong("CBEN_PBEN_SYS_ID"));
				beneficiaryBean
						.setCBEN_BNF_TYPE(rst.getString("CBEN_BNF_TYPE"));
				beneficiaryBean.setCBEN_RELATION_CODE(rst
						.getString("CBEN_RELATION_CODE"));
				beneficiaryBean
						.setCBEN_BNF_NAME(rst.getString("CBEN_BNF_NAME"));
				beneficiaryBean.setCBEN_PERC(rst.getDouble("CBEN_PERC"));
				beneficiaryBean.setCBEN_LC_PAID_AMT(rst
						.getDouble("CBEN_LC_PAID_AMT"));
				beneficiaryBean.setCBEN_FC_PAID_AMT(rst
						.getDouble("CBEN_FC_PAID_AMT"));
				beneficiaryBean.setCBEN_BANK_CODE(rst
						.getString("CBEN_BANK_CODE"));
				beneficiaryBean.setCBEN_ACCT_CODE(rst
						.getString("CBEN_ACCT_CODE"));
				beneficiaryBean.setCBEN_REF_ID1(rst.getString("CBEN_REF_ID1"));
				beneficiaryBean.setCBEN_REF_ID2(rst.getString("CBEN_REF_ID2"));
				beneficiaryBean
						.setCBEN_ADDRESS1(rst.getString("CBEN_ADDRESS1"));
				beneficiaryBean
						.setCBEN_ADDRESS2(rst.getString("CBEN_ADDRESS2"));
				beneficiaryBean
						.setCBEN_ADDRESS3(rst.getString("CBEN_ADDRESS3"));
				beneficiaryBean.setCBEN_STAT_CODE(rst
						.getString("CBEN_STAT_CODE"));
				beneficiaryBean.setCBEN_POSTAL_CODE(rst
						.getString("CBEN_POSTAL_CODE"));
				beneficiaryBean.setCBEN_CITY_CODE(rst
						.getString("CBEN_CITY_CODE"));
				beneficiaryBean
						.setCBEN_ADDRESS4(rst.getString("CBEN_ADDRESS4"));
				beneficiaryBean
						.setCBEN_ADDRESS5(rst.getString("CBEN_ADDRESS5"));
				beneficiaryBean.setCBEN_REMARKS(rst.getString("CBEN_REMARKS"));
				beneficiaryBean.setCBEN_CATG_CODE(rst
						.getString("CBEN_CATG_CODE"));
				beneficiaryBean.setCBEN_AGE(rst.getInt("CBEN_AGE"));
				beneficiaryBean.setCBEN_GUARDIAN_NAME(rst
						.getString("CBEN_GUARDIAN_NAME"));
				beneficiaryBean
						.setCBEN_MICR_CODE(rst.getLong("CBEN_MICR_CODE"));
				beneficiaryBean.setCBEN_DIVN_CODE(rst
						.getString("CBEN_DIVN_CODE"));
				/*added by gopi for hands on feed back points,serial no 12 in zb on 02/02/17*/
				beneficiaryBean.setCBEN_SR_NO(rst.getInt("CBEN_SR_NO"));
				beneficiaryBean.setCBEN_DOB(rst.getDate("CBEN_DOB"));
				beneficiaryBean.setCBEN_BNF_CODE(rst.getString("CBEN_BNF_CODE"));
				/*end*/
				
				/*Added by Ameen on 30-12-2017 for ZBLIFE-1458892*/
				beneficiaryBean.setCBEN_BANK_CODE(rst.getString("CBEN_BANK_CODE"));
				if(beneficiaryBean.getCBEN_BANK_CODE()!=null){
					String bankNameQry = "SELECT BANK_NAME FROM FM_BANK WHERE BANK_CODE=?";
					ResultSet bankNameRS = null;
					bankNameRS = new CRUDHandler().executeSelectStatement(bankNameQry, connection,new Object[]{beneficiaryBean.getCBEN_BANK_CODE()});
					if(bankNameRS.next()){
						beneficiaryBean.setUI_M_CBEN_BANK_CODE_DESC(bankNameRS.getString("BANK_NAME"));
					}
				}
				beneficiaryBean.setCBEN_DIVN_CODE(rst.getString("CBEN_DIVN_CODE"));
				if(beneficiaryBean.getCBEN_DIVN_CODE()!=null){
					String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
					ResultSet sortCodeRS = null;
					sortCodeRS = new CRUDHandler().executeSelectStatement(sortCodeQry, connection,new Object[]{beneficiaryBean.getCBEN_BANK_CODE(),beneficiaryBean.getCBEN_DIVN_CODE()});
					if(sortCodeRS.next()){
						beneficiaryBean.setUI_M_CBEN_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
					}
				}
				beneficiaryBean.setCBEN_FLEX_01(rst.getString("CBEN_FLEX_01"));
				beneficiaryBean.setCBEN_FLEX_02(rst.getString("CBEN_FLEX_02"));
				beneficiaryBean.setCBEN_FLEX_03(rst.getString("CBEN_FLEX_03"));
				beneficiaryBean.setCBEN_FLEX_04(rst.getString("CBEN_FLEX_04"));
				/*end*/
				
				// beneficiaryBean = postQuery(beneficiaryBean,
				// compositeAction);
				
				
				/*added by raja on 09-03-2017 for ZBILQC-1721754 */
				ArrayList<String> list = null;
				ArrayList<String> list1 = null;
				ArrayList<String> list2 = null;
				ArrayList<String> list4=null;
				

				DBProcedures procedures = new DBProcedures();

				list = procedures.P_VAL_CODES("ILBENFREL", beneficiaryBean
						.getCBEN_RELATION_CODE(), beneficiaryBean
						.getUI_M_CBEN_RELATION_DESC(), "N", "N", null);

				if(!list.isEmpty() && list.get(0)!=null )
					beneficiaryBean.setUI_M_CBEN_RELATION_DESC(list.get(0));
				
				
				
			
				if(beneficiaryBean.getCBEN_BNF_TYPE()!=null)
				{
				String CURSOR_C1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE ='ILBENFTYPE' AND PS_CODE=? ";
				ResultSet resultSet_CURSOR_C1 = null;
				CRUDHandler handlerDESC = new CRUDHandler();
				resultSet_CURSOR_C1 = handlerDESC.executeSelectStatement(CURSOR_C1, connection,new Object[] {beneficiaryBean.getCBEN_BNF_TYPE()});
				while (resultSet_CURSOR_C1.next()) {
					 beneficiaryBean.setUI_M_BNF_DESC(resultSet_CURSOR_C1.getString("PS_CODE_DESC"));
				}
				}
				
						if(beneficiaryBean.getCBEN_CATG_CODE()!=null)
						{
						String CURSOR_CATG = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE ='CATG' AND PS_CODE=? ";
						ResultSet resultSetCATG = null;
						CRUDHandler handlerCATG = new CRUDHandler();
						resultSetCATG = handlerCATG.executeSelectStatement(CURSOR_CATG, connection,new Object[] {beneficiaryBean.getCBEN_CATG_CODE()});
						while (resultSetCATG.next()) {
							 beneficiaryBean.setUI_M_CATG_DESC(resultSetCATG.getString("PS_CODE_DESC"));
						}
						}		
				/*list1 = DBProcedures.P_VAL_SYSTEM("ILBENFTYPE", beneficiaryBean
						.getCBEN_BNF_TYPE(), beneficiaryBean
						.getUI_M_BNF_DESC(), "N", dummyBean
						.getUI_M_PS_VALUE_DUMMY());
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						beneficiaryBean.setUI_M_BNF_DESC(list1.get(0));
					}
				}
				
				
				list2 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
						.getCBEN_CATG_CODE(), beneficiaryBean.getUI_M_CATG_DESC(),
						"N", dummyBean.getUI_M_PS_VALUE_DUMMY());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0) != null) {
						beneficiaryBean.setUI_M_CATG_DESC(list2.get(0));
					}
					if (list2.get(1) != null) {
						dummyBean.setUI_M_PS_VALUE_DUMMY(list2.get(1));
					}
				}*/
				
				list4 = procedures.L_CHK_BANK(beneficiaryBean
						.getCBEN_BANK_CODE(), null,null);

				if(!list4.isEmpty() && list4.get(0)!=null )
					beneficiaryBean.setUI_M_CBEN_BANK_CODE_DESC(list4.get(0));

				
				/*end*/
				
				beneficiaryList.add(beneficiaryBean);
			}
			compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
					.setPT_IL_CLAIM_BENEFICIARY_LIST(beneficiaryList);

			CommonUtils.closeCursor(rst);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//end

}
