package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_MED_EXAM_DTL_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction,Long POAD_SYS_ID,Long POAD_POL_SYS_ID) throws Exception {

		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet rstmedDescQuery =null;
		compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
				.getDataList_PT_IL_POL_MED_EXAM_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			PKG_PILT002_APAC pkg_pilt002_apac =  null; 
			 ArrayList<String> pvalList = null;	
		
			
			/*Added by saritha on 09-01-2018 for Medical Code Description*/
			String medDescQuery = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_MED_EXM' AND PC_CODE = ?";
			/*End*/
			
			if (POAD_POL_SYS_ID != null &&  POAD_SYS_ID !=  null) {
				String selectStatement = "SELECT ROWID, PT_IL_POL_MED_EXAM_DTL.* FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ?  AND PMED_POAD_SYS_ID = ?";
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection, new Object[] {POAD_POL_SYS_ID ,POAD_SYS_ID});
				System.out.println("first value  :"+POAD_POL_SYS_ID);
				System.out.println("sec value  :"+POAD_SYS_ID);
				
				
				
			}else {
				String selectStatement = "SELECT ROWID, PT_IL_POL_MED_EXAM_DTL.* FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ?";
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection, new Object[] {POAD_POL_SYS_ID });
				System.out.println("value  :"+POAD_SYS_ID);
				
			}
			while (resultSet.next()) {
				PT_IL_POL_MED_EXAM_DTL PT_IL_POL_MED_EXAM_DTL_BEAN = new PT_IL_POL_MED_EXAM_DTL();
				PT_IL_POL_MED_EXAM_DTL_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_SYS_ID(resultSet
						.getLong("PMED_SYS_ID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_POL_SYS_ID(resultSet
						.getLong("PMED_POL_SYS_ID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_END_NO_IDX(resultSet
						.getInt("PMED_END_NO_IDX"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_POAD_SYS_ID(resultSet
						.getLong("PMED_POAD_SYS_ID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_EXAM_CODE(resultSet
						.getString("PMED_EXAM_CODE"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_STATUS(resultSet
						.getString("PMED_STATUS"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CR_DT(resultSet
						.getDate("PMED_CR_DT"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CR_UID(resultSet
						.getString("PMED_CR_UID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_UPD_DT(resultSet
						.getDate("PMED_UPD_DT"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_UPD_UID(resultSet
						.getString("PMED_UPD_UID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CLINIC_CODE(resultSet
						.getString("PMED_CLINIC_CODE"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_PVT_LC_AMT(resultSet
						.getDouble("PMED_PVT_LC_AMT"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_GOVT_LC_AMT(resultSet
						.getDouble("PMED_GOVT_LC_AMT"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_REP_REC_DT(resultSet
						.getDate("PMED_REP_REC_DT"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_DEL_FLAG(resultSet
						.getString("PMED_DEL_FLAG"));
				/*Added by Sivarajan on 31/10/2019 for sarwa GL*/
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_FLEX_25(resultSet.getString("PMED_FLEX_25"));
				/*End*/
				
				/*added by saranya*/
				PT_IL_POL_MED_EXAM_DTL_BEAN.setUI_PMED_MED_DESC(validate(resultSet.getString("PMED_EXAM_CODE")));
                /* End*/
			
				
				/* Newly Added By Dhinesh on 11-05-2018 */
				if(PT_IL_POL_MED_EXAM_DTL_BEAN
						.getPMED_CLINIC_CODE() != null){
					pkg_pilt002_apac = 	new PKG_PILT002_APAC();
					pvalList = pkg_pilt002_apac.P_VAL_CLASS_CUST("HOSPITALS", PT_IL_POL_MED_EXAM_DTL_BEAN
							.getPMED_CLINIC_CODE(), PT_IL_POL_MED_EXAM_DTL_BEAN
							.getUI_M_CLINIC_CODE_DESC(), "N", "E", compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());
	
					if(!pvalList.isEmpty()){
						PT_IL_POL_MED_EXAM_DTL_BEAN.setUI_M_CLINIC_CODE_DESC(pvalList.get(0));
					}
				}
				/* End */
				
				/*Added by saritha on 09-01-2018 for Medical Code Description*/
				
				rstmedDescQuery = new CRUDHandler().executeSelectStatement(medDescQuery, CommonUtils.getConnection(),new Object[]{PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_EXAM_CODE()});
				if(rstmedDescQuery.next()){
					PT_IL_POL_MED_EXAM_DTL_BEAN.setUI_M_MED_EXAM_CODE_DESC(rstmedDescQuery.getString("PC_DESC"));
				}
				
				/*End*/
				
				/*added by Ganesh on 16-05-2016*/
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_REMARKS(resultSet.getString("PMED_FLEX_01"));
                /* End*/
				
				/*Added by Ameen on 15-12-2017 for ZBLIFE-1461947/automated email triggering for manual med. creation*/
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_FLEX_05(resultSet.getString("PMED_FLEX_05"));			
				/*End*/

				/*Added by Ram on 15/12/2016 for Enabling fields in Datagrid*/
				if(compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
						.getDataList_PT_IL_POL_MED_EXAM_DTL() != null && 
								compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
								.getDataList_PT_IL_POL_MED_EXAM_DTL().size() == 0)
				{
					System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getRowSelected()      "+PT_IL_POL_MED_EXAM_DTL_BEAN.getRowSelected()+" "+
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()+"     "+
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()+"     "+
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
				if(PT_IL_POL_MED_EXAM_DTL_BEAN.getRowSelected() != null && PT_IL_POL_MED_EXAM_DTL_BEAN.getRowSelected().equals("dataTableNonSelectedRow"))
				{
					if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("Y")))
					{
						PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
						PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
					}
					else
					{
						PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");
						PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
					}
				}
				}
				/*End*/
				
				/*Added by Janani on 19.02.2018 for making medical fee as 0 if status is waived,as suggested by Gaurav*/
				
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_FLEX_06(resultSet.getString("PMED_FLEX_06"));
				/*End*/
				
				/*Added by saritha on 20-04-2018 for KIC KICLIFEQC-1746096*/
				
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_EXM_DN_DT(resultSet.getDate("PMED_EXM_DN_DT"));
				
				/*End*/
				
				
				compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
						.getDataList_PT_IL_POL_MED_EXAM_DTL().add(
								PT_IL_POL_MED_EXAM_DTL_BEAN);
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(rstmedDescQuery);
		}
	}

	//added by saranya for medical long description on 26-05-2016
		public String validate(String EXAM_CODE) throws Exception
		{
			System.out.println("inside validate function");
			ResultSet resultSet = null;
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			String CURSOR_C1="SELECT PC_CODE,PC_LONG_DESC FROM PM_CODES WHERE PC_TYPE  ='IL_MED_EXM' and PC_CODE=?";
			String Exam_code=null;
			
			resultSet = handler.executeSelectStatement(CURSOR_C1,
					connection,new Object[] {EXAM_CODE});
			if (resultSet.next()) {
				Exam_code=resultSet.getString(2);
			}
			return Exam_code;
		}
		/*end*/
	public void executeSelectStatement(Long POAD_SYS_ID, Long POAD_POL_SYS_ID,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_MED_EXAM_DTL.* FROM PT_IL_POL_MED_EXAM_DTL WHERE  PMED_POAD_SYS_ID = ? AND PMED_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
				.getDataList_PT_IL_POL_MED_EXAM_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { POAD_SYS_ID,
							POAD_POL_SYS_ID });
			while (resultSet.next()) {
				PT_IL_POL_MED_EXAM_DTL PT_IL_POL_MED_EXAM_DTL_BEAN = new PT_IL_POL_MED_EXAM_DTL();
				PT_IL_POL_MED_EXAM_DTL_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_SYS_ID(resultSet
						.getLong("PMED_SYS_ID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_POL_SYS_ID(resultSet
						.getLong("PMED_POL_SYS_ID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_END_NO_IDX(resultSet
						.getInt("PMED_END_NO_IDX"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_POAD_SYS_ID(resultSet
						.getLong("PMED_POAD_SYS_ID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_EXAM_CODE(resultSet
						.getString("PMED_EXAM_CODE"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_STATUS(resultSet
						.getString("PMED_STATUS"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CR_DT(resultSet
						.getDate("PMED_CR_DT"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CR_UID(resultSet
						.getString("PMED_CR_UID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_UPD_DT(resultSet
						.getDate("PMED_UPD_DT"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_UPD_UID(resultSet
						.getString("PMED_UPD_UID"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CLINIC_CODE(resultSet
						.getString("PMED_CLINIC_CODE"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_PVT_LC_AMT(resultSet
						.getDouble("PMED_PVT_LC_AMT"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_GOVT_LC_AMT(resultSet
						.getDouble("PMED_GOVT_LC_AMT"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_REP_REC_DT(resultSet
						.getDate("PMED_REP_REC_DT"));
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_DEL_FLAG(resultSet
						.getString("PMED_DEL_FLAG"));

				compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
						.getDataList_PT_IL_POL_MED_EXAM_DTL().add(
								PT_IL_POL_MED_EXAM_DTL_BEAN);
			}
		} catch(Exception e){
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void deleteRecord(Long POAD_SYS_ID, Long POAD_POL_SYS_ID)
			throws Exception {
		String selectStatement = "DELETE FROM PT_IL_POL_MED_EXAM_DTL WHERE  PMED_POAD_SYS_ID = ? AND PMED_POL_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { POAD_SYS_ID,
							POAD_POL_SYS_ID });
		} catch(Exception e){
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
