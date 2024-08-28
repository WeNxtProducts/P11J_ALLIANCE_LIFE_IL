package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

import java.sql.ResultSet;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PT_IL_PREM_COLL_DELEGATE {
	public void executeSelectStatement(
			PILT003_APAC_COMPOSITE_ACTION PILT003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		/*String selectStatement = "SELECT ROWID, PT_IL_PREM_COLL.* FROM " +
		"PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? ORDER BY PC_SCHD_PYMT_DT ASC ";*/

		/*Modified by Ram on 23/02/2017 for fetch Records by Statuswise*/
		String selectStatement = null;
		String selectStatement1 = null;
		if(PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPOL_STS_FLAG() != null &&
				PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPOL_STS_FLAG().equals("A"))
		{
			selectStatement = "SELECT ROWID, PT_IL_PREM_COLL.* FROM " +
					"PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND PC_PAID_FLAG = 'A' ORDER BY PC_SCHD_PYMT_DT ASC ";
		}
		else if(PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPOL_STS_FLAG() != null &&
				PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPOL_STS_FLAG().equals("B"))
		{
			selectStatement = "SELECT ROWID, PT_IL_PREM_COLL.* FROM " +
					"PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ?   ORDER BY PC_SCHD_PYMT_DT ASC ";
			
			
		}
		else 
		{
			selectStatement = "SELECT ROWID, PT_IL_PREM_COLL.* FROM " +
					"PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND PC_PAID_FLAG != 'A' ORDER BY PC_SCHD_PYMT_DT ASC ";
		}
		
		System.out.println("Values      "+PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()+"        "+
							PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPOL_STS_FLAG()+"         "+
				selectStatement);
		/*End*/
		
		selectStatement1 = "SELECT DEP_DOC_NO,DEP_DOC_DT FROM PT_IL_PYMT_DTLS,PT_IL_DEPOSIT,PT_IL_DEPOSIT_PYMT_DTLS WHERE DEP_SYS_ID = DPD_DEP_SYS_ID AND DPD_REF_ID = PD_DPD_REF_ID AND PD_TXN_SYS_ID = ? ";
		
		
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		
		PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN =null;
		PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getDataList_PT_IL_PREM_COLL().clear();
		try {
			connection = CommonUtils.getConnection();
			
			/*Modified by Ram on 23/02/2017 for fetch Records by Statuswise
			 * resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[]{PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});*/
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[]{ PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			/*End*/
					while (resultSet.next()) {
				  PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
				PT_IL_PREM_COLL_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_PREM_COLL_BEAN.setPC_SYS_ID(resultSet
						.getLong("PC_SYS_ID"));
				PT_IL_PREM_COLL_BEAN.setPC_POL_SYS_ID(resultSet
						.getLong("PC_POL_SYS_ID"));
				PT_IL_PREM_COLL_BEAN.setPC_END_NO_IDX(resultSet
						.getDouble("PC_END_NO_IDX"));
				PT_IL_PREM_COLL_BEAN.setPC_SCHD_PYMT_DT(resultSet
						.getDate("PC_SCHD_PYMT_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_PAID_DT(resultSet
						.getDate("PC_PAID_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_FACIN_YN(resultSet
						.getString("PC_FACIN_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_GROSS_PREM(resultSet
						.getDouble("PC_LC_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_GROSS_PREM(resultSet
						.getDouble("PC_FC_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_DISCOUNT(resultSet
						.getDouble("PC_LC_DISCOUNT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_DISCOUNT(resultSet
						.getDouble("PC_FC_DISCOUNT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_CHARGE(resultSet
						.getDouble("PC_LC_CHARGE"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_CHARGE(resultSet
						.getDouble("PC_FC_CHARGE"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_FI_COMM(resultSet
						.getDouble("PC_LC_FI_COMM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_FI_COMM(resultSet
						.getDouble("PC_FC_FI_COMM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_FI_TAX(resultSet
						.getDouble("PC_LC_FI_TAX"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_FI_TAX(resultSet
						.getDouble("PC_FC_FI_TAX"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_FO_PREM(resultSet
						.getDouble("PC_LC_FO_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_FO_PREM(resultSet
						.getDouble("PC_FC_FO_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_FO_COMM(resultSet
						.getDouble("PC_LC_FO_COMM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_FO_COMM(resultSet
						.getDouble("PC_FC_FO_COMM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_FO_TAX(resultSet
						.getDouble("PC_LC_FO_TAX"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_FO_TAX(resultSet
						.getDouble("PC_FC_FO_TAX"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_FO_RETRO_PREM(resultSet
						.getDouble("PC_LC_FO_RETRO_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_FO_RETRO_PREM(resultSet
						.getDouble("PC_FC_FO_RETRO_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_FO_RETRO_COMM(resultSet
						.getDouble("PC_LC_FO_RETRO_COMM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_FO_RETRO_COMM(resultSet
						.getDouble("PC_FC_FO_RETRO_COMM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_FO_RETRO_TAX(resultSet
						.getDouble("PC_LC_FO_RETRO_TAX"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_FO_RETRO_TAX(resultSet
						.getDouble("PC_FC_FO_RETRO_TAX"));
				PT_IL_PREM_COLL_BEAN.setPC_PREM_TYPE(resultSet
						.getString("PC_PREM_TYPE"));
				PT_IL_PREM_COLL_BEAN.setPC_PAID_FLAG(resultSet
						.getString("PC_PAID_FLAG"));
				PT_IL_PREM_COLL_BEAN.setPC_UNPAID_PREM(resultSet
						.getString("PC_UNPAID_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_APPRV_DT(resultSet
						.getDate("PC_APPRV_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_FAC_CLOSE_FLAG(resultSet
						.getString("PC_FAC_CLOSE_FLAG"));
				PT_IL_PREM_COLL_BEAN.setPC_RI_CLOSE_FLAG(resultSet
						.getString("PC_RI_CLOSE_FLAG"));
				PT_IL_PREM_COLL_BEAN.setPC_CR_DT(resultSet.getDate("PC_CR_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_CR_UID(resultSet
						.getString("PC_CR_UID"));
				PT_IL_PREM_COLL_BEAN.setPC_UPD_DT(resultSet
						.getDate("PC_UPD_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_UPD_UID(resultSet
						.getString("PC_UPD_UID"));
				PT_IL_PREM_COLL_BEAN.setPC_UNPAID_PREM_INT_CODE(resultSet
						.getString("PC_UNPAID_PREM_INT_CODE"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_UNPAID_PREM_INT(resultSet
						.getDouble("PC_FC_UNPAID_PREM_INT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(resultSet
						.getDouble("PC_LC_UNPAID_PREM_INT"));
				PT_IL_PREM_COLL_BEAN.setPC_OBJ_ID(resultSet
						.getString("PC_OBJ_ID"));
				PT_IL_PREM_COLL_BEAN.setPC_OBJ_SYS_ID(resultSet
						.getLong("PC_OBJ_SYS_ID"));
				PT_IL_PREM_COLL_BEAN.setPC_REF_NO(resultSet
						.getString("PC_REF_NO"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_AMAN_PREM(resultSet
						.getDouble("PC_FC_AMAN_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_AMAN_PREM(resultSet
						.getDouble("PC_LC_AMAN_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_SENABEL_PREM(resultSet
						.getDouble("PC_FC_SENABEL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_SENABEL_PREM(resultSet
						.getDouble("PC_LC_SENABEL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_SURPLUS_CONSIDER_YN(resultSet
						.getString("PC_SURPLUS_CONSIDER_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_EMPLOYER_CODE(resultSet
						.getString("PC_EMPLOYER_CODE"));
				PT_IL_PREM_COLL_BEAN.setPC_CONT_CODE(resultSet
						.getString("PC_CONT_CODE"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_BASIC_PREM(resultSet
						.getDouble("PC_FC_BASIC_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_BASIC_PREM(resultSet
						.getDouble("PC_LC_BASIC_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_ADDL_PREM(resultSet
						.getDouble("PC_FC_ADDL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_ADDL_PREM(resultSet
						.getDouble("PC_LC_ADDL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_LOAD_AMT(resultSet
						.getDouble("PC_FC_LOAD_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_LOAD_AMT(resultSet
						.getDouble("PC_LC_LOAD_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_CHARGE_AMT(resultSet
						.getDouble("PC_FC_CHARGE_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_CHARGE_AMT(resultSet
						.getDouble("PC_LC_CHARGE_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_EXC_INT_PERC(resultSet
						.getDouble("PC_EXC_INT_PERC"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_EXC_INT_AMT(resultSet
						.getDouble("PC_FC_EXC_INT_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_EXC_INT_AMT(resultSet
						.getDouble("PC_LC_EXC_INT_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_AVLB_BAL_AMT(resultSet
						.getDouble("PC_FC_AVLB_BAL_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_AVLB_BAL_AMT(resultSet
						.getDouble("PC_LC_AVLB_BAL_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_AMT(resultSet
						.getDouble("PC_FC_PAID_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_AMT(resultSet
						.getDouble("PC_LC_PAID_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_DRIP_YN(resultSet
						.getString("PC_DRIP_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_TEMP_RCPT_NO(resultSet
						.getString("PC_TEMP_RCPT_NO"));
				PT_IL_PREM_COLL_BEAN.setPC_DRCR_ACNT_YEAR(resultSet
						.getDouble("PC_DRCR_ACNT_YEAR"));
				PT_IL_PREM_COLL_BEAN.setPC_DRCR_TXN_CODE(resultSet
						.getString("PC_DRCR_TXN_CODE"));
				PT_IL_PREM_COLL_BEAN.setPC_DRCR_DOC_NO(resultSet
						.getInt("PC_DRCR_DOC_NO")== 0.0 ? null
								: resultSet.getInt("PC_DRCR_DOC_NO"));
				PT_IL_PREM_COLL_BEAN.setPC_DRCR_DOC_DT(resultSet
						.getDate("PC_DRCR_DOC_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_COLL_TYPE(resultSet
						.getString("PC_COLL_TYPE"));
				PT_IL_PREM_COLL_BEAN.setPC_DU_REF_ID(resultSet
						.getString("PC_DU_REF_ID"));
				PT_IL_PREM_COLL_BEAN.setPC_FLEX_01(resultSet
						.getString("PC_FLEX_01"));
				PT_IL_PREM_COLL_BEAN.setPC_FLEX_02(resultSet
						.getString("PC_FLEX_02"));
				PT_IL_PREM_COLL_BEAN.setPC_FLEX_03(resultSet
						.getString("PC_FLEX_03"));
				PT_IL_PREM_COLL_BEAN.setPC_FLEX_04(resultSet
						.getString("PC_FLEX_04"));
				PT_IL_PREM_COLL_BEAN.setPC_FLEX_05(resultSet
						.getString("PC_FLEX_05"));
				PT_IL_PREM_COLL_BEAN.setPC_FLEX_06(resultSet
						.getString("PC_FLEX_06"));
				PT_IL_PREM_COLL_BEAN.setPC_UNIT_YN(resultSet
						.getString("PC_UNIT_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_PREM_HOLIDAY_YN(resultSet
						.getString("PC_PREM_HOLIDAY_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_RI_ALLOC_YN(resultSet
						.getString("PC_RI_ALLOC_YN"));
				PT_IL_PREM_COLL_BEAN.setPC_DOC_NO(resultSet
						.getString("PC_DOC_NO"));
				
				/*Newly added By Dhinesh on 23-06-2017 for ssp call id :*/ 
					
				/*End*/	
				

				/*Added by Ram on 08/02/2017 for BankCode field capturing*/
				/*Modified by Ram on 09/02/2017 as per Ajoy's suggestion*/
				System.out.println("resultSet.getString(PD_BANK_CODE)       "+resultSet.getString("PD_BANK_CODE"));
				/*PT_IL_PREM_COLL_BEAN.setBANK_CODE(resultSet.getString("BANK_CODE"));*/
				if(resultSet.getDate("PC_APPRV_DT") == null)
				{
					PT_IL_PREM_COLL_BEAN.setBANK_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20"));
				}
				else
				{
					/*Modified by Ram on 23/02/2017 for default Bankcode
					 * 
					 * PT_IL_PREM_COLL_BEAN.setBANK_CODE(resultSet.getString("PD_BANK_CODE"));*/
					if(resultSet.getString("PD_BANK_CODE") == null)
					{
						PT_IL_PREM_COLL_BEAN.setBANK_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20"));	
					}
					else
					{
						PT_IL_PREM_COLL_BEAN.setBANK_CODE(resultSet.getString("PD_BANK_CODE"));
					}
					}
					/*End*/
				/*End*/
				
				CommonUtils.setGlobalVariable("GLOBAL.PC_REF_NO", resultSet.getString("PC_REF_NO"));
				CommonUtils.setGlobalVariable("GLOBAL.PC_DRCR_DOC_NO",resultSet.getString("PC_DRCR_DOC_NO"));
				System.out.println("PC_DRCR_DOC_NO"+	CommonUtils.getGlobalVariable("GLOBAL.PC_REF_NO"));
				System.out.println("PC_DRCR_DOC_NO1"+	CommonUtils.getGlobalVariable("GLOBAL.PC_DRCR_DOC_NO"));
				/* FacesContext context = FacesContext.getCurrentInstance();
					HttpServletRequest request = (HttpServletRequest) context
							.getExternalContext().getRequest();
					HttpSession session = request.getSession();
					
						session.setAttribute("PC_REF_NO",resultSet.getString("PC_REF_NO"));
						session.setAttribute("PC_DRCR_DOC_NO",resultSet.getString("PC_DRCR_DOC_NO"));*/
			       /* 
			        System.out.println("session---->"+session. getAttribute("PC_REF_NO"));
			        System.out.println("session1---->"+session. getAttribute("PC_DRCR_DOC_NO"));*/
			        
				PT_IL_PREM_COLL_BEAN.setPC_FC_UNPAID_WAIVE_PREM_INT(resultSet
						.getDouble("PC_FC_UNPAID_WAIVE_PREM_INT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_WAIVE_PREM_INT(resultSet
						.getDouble("PC_LC_UNPAID_WAIVE_PREM_INT"));
				PT_IL_PREM_COLL_BEAN.setPC_WAIVE_PREM_YN(resultSet
						.getString("PC_WAIVE_PREM_YN"));
				/*Added by Ram on 05/03/2017 for DepRefId is null issue*/
				PT_IL_PREM_COLL_BEAN.setOLD_PC_FC_PAID_AMT(resultSet.getDouble("PC_FC_PAID_AMT"));
				/*End*/
				
				/*Added by Ram on 08/02/2017 for BankCode field capturing*/
				/*Modified by Ram on 09/02/2017 as per Ajoy's suggestion*/
				System.out.println("resultSet.getString(PD_BANK_CODE)       "+resultSet.getString("PD_BANK_CODE"));
				/*PT_IL_PREM_COLL_BEAN.setBANK_CODE(resultSet.getString("BANK_CODE"));*/
				if(resultSet.getDate("PC_APPRV_DT") == null)
				{
					PT_IL_PREM_COLL_BEAN.setBANK_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20"));
				}
				else
				{
					/*Modified by Ram on 23/02/2017 for default Bankcode
					 * 
					 * PT_IL_PREM_COLL_BEAN.setBANK_CODE(resultSet.getString("PD_BANK_CODE"));*/
					if(resultSet.getString("PD_BANK_CODE") == null)
					{
						PT_IL_PREM_COLL_BEAN.setBANK_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20"));	
					}
					else
					{
						PT_IL_PREM_COLL_BEAN.setBANK_CODE(resultSet.getString("PD_BANK_CODE"));
					}
					/*End*/
				}
				
				/*End*/
				/*Added by Ram on 05/03/2017 for DepRefId is null issue*/
				PT_IL_PREM_COLL_BEAN.setOLD_PC_FC_PAID_AMT(resultSet.getDouble("PC_FC_PAID_AMT"));
				/*End*/
				
				
				/*Newly Added By Dhinesh on 23-06-2017 for ssp call id : ZBILQC-1727457 */
				
				resultSet1 = new CRUDHandler().executeSelectStatement(
						selectStatement1, connection,
						new Object[]{ PT_IL_PREM_COLL_BEAN.getPC_SYS_ID() });
				
				while (resultSet1.next()) {
				
				PT_IL_PREM_COLL_BEAN.setPC_DEP_REF_DOC_NO(resultSet1.getInt("DEP_DOC_NO"));
				PT_IL_PREM_COLL_BEAN.setPC_DEP_REF_DOC_DT(resultSet1.getDate("DEP_DOC_DT"));
				
				}
				
				/*End*/
				
				PT_IL_PREM_COLL_HELPER helper = new PT_IL_PREM_COLL_HELPER();
				helper.postQuery(PILT003_APAC_COMPOSITE_ACTION_BEAN,PT_IL_PREM_COLL_BEAN);//For add value

				PILT003_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getDataList_PT_IL_PREM_COLL()
						.add(PT_IL_PREM_COLL_BEAN);
				
			
		
			//added by agalya 12/07/2016
			//to avoid duplicate report pages in premia receipt.
			/*FacesContext context = FacesContext.getCurrentInstance();
			Map<String, Object> session = context.getExternalContext()
					.getSessionMap();
			session.put("PC_REF_NO", PT_IL_PREM_COLL_BEAN.getPC_REF_NO()+"");
			session.put("PC_DRCR_DOC_NO", PT_IL_PREM_COLL_BEAN.getPC_DRCR_DOC_NO());*/
			//end
			
			
			
					}	
		}catch(Exception e)
		{
			e.printStackTrace();
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}