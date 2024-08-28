package com.iii.pel.forms.PILT023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
/*import com.iii.pel.forms.PILP205.PILP205_COMPOSITE_ACTION;
import com.iii.pel.forms.PILP205.PT_IL_WAK_STATUS;*/
import com.iii.premia.common.utils.CommonUtils;


public class PILT023_MEDICAL_CLINIC_PAYMENTS_DELEGATE {
	PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_bean;

	public void executeSelectStatementData(PILT023_COMPOSITE_ACTION	compositeAction)throws Exception{
		System.out.println("PILT023_A datatable delegate");
		String selectStatement = "SELECT ROWID,PT_IL_MEDEX_FEE_DTL.* FROM PT_IL_MEDEX_FEE_DTL WHERE ROWID= ? ";
		String icQuery="SELECT POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2 FROM PT_IL_POLICY WHERE POL_PROP_NO=?";
		//PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_bean = new PT_IL_MEDEX_FEE_DTL();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		System.out.println("PT_IL_MEDEX_FEE_DTL_bean ROWID" +compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getROWID());
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getROWID()});
			connection = CommonUtils.getConnection();
			
			ArrayList<PT_IL_MEDEX_FEE_DTL> obj=new ArrayList<PT_IL_MEDEX_FEE_DTL>();
			while (resultSet.next()) {
				
				//PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_bean = new PT_IL_MEDEX_FEE_DTL();
				PT_IL_MEDEX_FEE_DTL_bean = new PT_IL_MEDEX_FEE_DTL();
				
				PT_IL_MEDEX_FEE_DTL_bean.setROWID(resultSet.getString("ROWID"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_PROP_NO(resultSet.getString("MFD_PROP_NO"));
				
				//PT_IL_MEDEX_FEE_DTL_bean.setNEW_ICNO(resultSet.getString("NEW_ICNO"));
				//PT_IL_MEDEX_FEE_DTL_bean.setOLD_ICNO(resultSet.getString("OLD_ICNO"));
				//System.out.println("PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO() *******************"+PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO());
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_EXAM_CODE(resultSet.getString("MFD_EXAM_CODE"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_EXAM_DT(resultSet.getDate("MFD_EXAM_DT"));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CURR_CODE(resultSet.getString("MFD_CURR_CODE"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FC_VALUE(resultSet.getDouble("MFD_FC_VALUE"));	

				PT_IL_MEDEX_FEE_DTL_bean.setMFD_INV_REF_NO(resultSet.getString("MFD_INV_REF_NO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_PYMT_TO(resultSet.getString("MFD_PYMT_TO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FRZ_FLAG(resultSet.getString("MFD_FRZ_FLAG"));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_LC_VALUE(resultSet.getDouble("MFD_LC_VALUE"));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_POL_NO(resultSet.getString("MFD_POL_NO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_POL_CONT_CODE(resultSet.getString("MFD_POL_CONT_CODE"));
				
				//PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_EXAM_CODE_DESC(resultSet.getString("MFD_CURR_CODE"));
				/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
				PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_EXAM_CODE_DESC(getEXAM_CODEDESC(resultSet.getString("MFD_EXAM_CODE")));
				PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_CURR_CODE_DESC(getCURRENCY_DESC(resultSet.getString("MFD_CURR_CODE")));
				/* End */
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_REMARKS(resultSet.getString("MFD_REMARKS"));
				//System.out.println("******test****"+PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO());
				resultSet2 = new CRUDHandler().executeSelectStatement(
						icQuery, connection,new Object[]{PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO()});
				while (resultSet2.next()) {
					System.out.println("INSIDE ID RS");
					PT_IL_MEDEX_FEE_DTL_bean.setNEW_ICNO(resultSet2.getString("POL_ASSRD_REF_ID1"));
					PT_IL_MEDEX_FEE_DTL_bean.setOLD_ICNO(resultSet2.getString("POL_ASSRD_REF_ID2"));
				}
				
				/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CR_DT(resultSet.getDate("MFD_CR_DT"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_PAID_FLAG(resultSet.getString("MFD_PAID_FLAG"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CUST_CODE(resultSet.getString("MFD_CUST_CODE"));
				/*End*/
				
				obj.add(PT_IL_MEDEX_FEE_DTL_bean);				
			}
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().setMedicalDataList(obj);
			System.out.println("medicallll dataList       ::"+compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getMedicalDataList());
			
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
		
	}
	
	public void executeSelectStatement(PILT023_COMPOSITE_ACTION	compositeAction)throws Exception{
		System.out.println("PILT023_A search delegate");
		String selectStatement = "SELECT ROWID,PT_IL_MEDEX_FEE_DTL.* FROM PT_IL_MEDEX_FEE_DTL WHERE ROWID = ?";
		String icQuery="SELECT POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_APPRV_STATUS,POL_APPRV_DT FROM PT_IL_POLICY WHERE POL_NO=?";
		String contNameQuery="SELECT CONT_NAME FROM PM_IL_CONTRACTOR WHERE CONT_CODE = ?";
		String custNameQuery="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?";
		String flagQuery="SELECT MFD_PAID_FLAG FROM PT_IL_MEDEX_FEE_DTL B WHERE MFD_PROP_NO = ? AND MFD_EXAM_CODE = ?";
		
		//String policyQuery="SELECT POL_APPRV_STATUS,POL_APPRV_DT FROM PT_IL_POLICY WHERE POL_PROP_NO = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		String MFD_PAID_FLAG = null;
	
		CommonUtils commonUtils = new CommonUtils();
		System.out.println("******rowid****"+compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getROWID());
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getROWID()});
			PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_bean = new PT_IL_MEDEX_FEE_DTL();
			ArrayList<PT_IL_MEDEX_FEE_DTL> obj=new ArrayList<PT_IL_MEDEX_FEE_DTL>();
			while (resultSet.next()) {
				//PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_bean = new PT_IL_MEDEX_FEE_DTL();
				PT_IL_MEDEX_FEE_DTL_bean.setROWID(resultSet.getString("ROWID"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_SYS_ID(resultSet.getLong("MFD_SYS_ID"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_POL_SYS_ID(resultSet.getLong("MFD_POL_SYS_ID"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_PROP_NO(resultSet.getString("MFD_PROP_NO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CLINIC_CODE(resultSet.getString("MFD_CLINIC_CODE"));
				
				compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().setMFD_CLINIC_CODE(resultSet.getString("MFD_CLINIC_CODE"));
				
				System.out.println("PT_IL_MEDEX_FEE_DTL_bean.getMFD_CLINIC_CODE      "+PT_IL_MEDEX_FEE_DTL_bean.getMFD_CLINIC_CODE());
				//PT_IL_MEDEX_FEE_DTL_bean.setNEW_ICNO(resultSet.getString("NEW_ICNO"));
				//PT_IL_MEDEX_FEE_DTL_bean.setOLD_ICNO(resultSet.getString("OLD_ICNO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_EXAM_CODE(resultSet.getString("MFD_EXAM_CODE"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_EXAM_DT(resultSet.getDate("MFD_EXAM_DT"));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CURR_CODE(resultSet.getString("MFD_CURR_CODE"));
				/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
				PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_CURR_CODE_DESC(getCURRENCY_DESC(resultSet.getString("MFD_CURR_CODE")));
				/* End */
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FC_VALUE(resultSet.getDouble("MFD_FC_VALUE"));	

				PT_IL_MEDEX_FEE_DTL_bean.setMFD_INV_REF_NO(resultSet.getString("MFD_INV_REF_NO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_PYMT_TO(resultSet.getString("MFD_PYMT_TO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FRZ_FLAG(resultSet.getString("MFD_FRZ_FLAG"));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_LC_VALUE(resultSet.getDouble("MFD_LC_VALUE"));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_POL_NO(resultSet.getString("MFD_POL_NO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_POL_CONT_CODE(resultSet.getString("MFD_POL_CONT_CODE"));
				/*Added by Ameen on 04-12-2017 for ZBLIFE-1458892*/
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_01(resultSet.getString("MFD_FLEX_01"));
				if(PT_IL_MEDEX_FEE_DTL_bean.getMFD_FLEX_01()!=null){
				String bankQry= "SELECT BANK_NAME FROM FM_BANK WHERE BANK_CODE = ?";
				ResultSet bankRS = new CRUDHandler().executeSelectStatement(bankQry, connection,
						new Object[]{PT_IL_MEDEX_FEE_DTL_bean.getMFD_FLEX_01()});
					if(bankRS.next()){
						PT_IL_MEDEX_FEE_DTL_bean.setUI_M_MFD_BANK_DESC(bankRS.getString("BANK_NAME"));
					}
				}
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_02(resultSet.getString("MFD_FLEX_02"));
				if(PT_IL_MEDEX_FEE_DTL_bean.getMFD_FLEX_02()!=null){
					String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
					ResultSet sortCodeRS = null;
					sortCodeRS = new CRUDHandler().executeSelectStatement
							(sortCodeQry, connection,new Object[]{PT_IL_MEDEX_FEE_DTL_bean.getMFD_FLEX_01(),PT_IL_MEDEX_FEE_DTL_bean.getMFD_FLEX_02()});
					if(sortCodeRS.next()){
						PT_IL_MEDEX_FEE_DTL_bean.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
					}
				}
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_03(resultSet.getString("MFD_FLEX_03"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_04(resultSet.getString("MFD_FLEX_04"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_05(resultSet.getString("MFD_FLEX_05"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_06(resultSet.getString("MFD_FLEX_06"));
				/*End*/
				
				System.out.println("******test****"+PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO());
				resultSet2 = new CRUDHandler().executeSelectStatement(
						icQuery, connection,new Object[]{PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO()});
				while (resultSet2.next()) {
					System.out.println("INSIDE ID RS");
					PT_IL_MEDEX_FEE_DTL_bean.setNEW_ICNO(resultSet2.getString("POL_ASSRD_REF_ID1"));
					PT_IL_MEDEX_FEE_DTL_bean.setOLD_ICNO(resultSet2.getString("POL_ASSRD_REF_ID2"));
					/*if(resultSet2.getString("POL_APPRV_STATUS").equalsIgnoreCase("A"))
					{
						PT_IL_MEDEX_FEE_DTL_bean.setWM_APPRV_STATUS("APPROVED");
						SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
						PT_IL_MEDEX_FEE_DTL_bean.setWM_APPRV_DT(sdf.format(resultSet2.getDate("POL_APPRV_DT")));
						PT_IL_MEDEX_FEE_DTL_bean.setWM_APPRV_DT(commonUtils.dateToStringFormatter(commonUtils.getCurrentDate()));
						
					}*/
					
				}
					
				/*Added by saritha on 16-11-2017 for ssp call id ZBILQC-1736304*/
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_PAID_FLAG(resultSet.getString("MFD_PAID_FLAG"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_UPD_DT (resultSet.getDate("MFD_UPD_DT"));
				
				System.out.println("proposalNo "+PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO());
				resultSet5 = new CRUDHandler().executeSelectStatement(
						flagQuery, connection,new Object[]{PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO(),PT_IL_MEDEX_FEE_DTL_bean.getMFD_EXAM_CODE()});
				if(resultSet5.next()){
					MFD_PAID_FLAG = resultSet5.getString(1);
					System.out.println("paidFlag " +MFD_PAID_FLAG);

				}
				if(MFD_PAID_FLAG!=null && MFD_PAID_FLAG.equalsIgnoreCase("Y")){
					PT_IL_MEDEX_FEE_DTL_bean.setWM_APPRV_STATUS("APPROVED");
					PT_IL_MEDEX_FEE_DTL_bean.setWM_APPRV_DT(commonUtils.dateToStringFormat(PT_IL_MEDEX_FEE_DTL_bean.getMFD_UPD_DT()));
					System.out.println("Approval Date" + PT_IL_MEDEX_FEE_DTL_bean.getWM_APPRV_DT());
					
				}else{
					PT_IL_MEDEX_FEE_DTL_bean.setWM_APPRV_STATUS("");
					PT_IL_MEDEX_FEE_DTL_bean.setWM_APPRV_DT(null);
					PT_IL_MEDEX_FEE_DTL_bean.setUI_M_TOTAL_PAID_AMT(null);
					
				}

				/*End*/
				
				System.out.println("********test contractor name**********"+PT_IL_MEDEX_FEE_DTL_bean.getMFD_POL_CONT_CODE());
				resultSet3 = new CRUDHandler().executeSelectStatement(
						contNameQuery, connection,new Object[]{PT_IL_MEDEX_FEE_DTL_bean.getMFD_POL_CONT_CODE()});
				while(resultSet3.next()){
					System.out.println("contractor name");
					PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_POL_CONT_NAME(resultSet3.getString("CONT_NAME"));
					System.out.println("contName"+PT_IL_MEDEX_FEE_DTL_bean.getWM_MFD_POL_CONT_NAME());
				}
				
				
				//PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_EXAM_CODE_DESC(resultSet.getString("MFD_CURR_CODE"));
				PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_EXAM_CODE_DESC(getEXAM_CODEDESC(resultSet.getString("MFD_EXAM_CODE")));
				PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_CURR_CODE_DESC(getCURRENCY_DESC(resultSet.getString("MFD_CURR_CODE")));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_REMARKS(resultSet.getString("MFD_REMARKS"));	
				
				
				/*Added by saritha on 13-11-2017 for ssp call id ZBILQC-1736304*/ 
				
				resultSet4 = new CRUDHandler().executeSelectStatement(
						custNameQuery, connection,new Object[]{compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE()});
				while(resultSet4.next()){
					compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().setWM_CLINIC_CODE_DESC(resultSet4.getString("CUST_NAME"));
					
				}
				
				/*End*/

				/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CR_DT(resultSet.getDate("MFD_CR_DT"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CUST_CODE(resultSet.getString("MFD_CUST_CODE"));
				/*End*/
				
				/*Added by saritha on 26-04-2018 for KIC Medical Clinic Payment Issues*/
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FROM_DT(resultSet.getDate("MFD_FROM_DT"));
	            PT_IL_MEDEX_FEE_DTL_bean.setMFD_TO_DT(resultSet.getDate("MFD_TO_DT"));
	            compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().setMFD_FROM_DT(resultSet.getDate("MFD_FROM_DT"));
				compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().setMFD_TO_DT(resultSet.getDate("MFD_TO_DT"));

				/*End*/
				
				obj.add(PT_IL_MEDEX_FEE_DTL_bean);
			}
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().setMedicalDataList(obj);
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().setPT_IL_MEDEX_FEE_DTL_BEAN(PT_IL_MEDEX_FEE_DTL_bean);
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
		
	}
	
	
	public void getClinicDetails(PILT023_COMPOSITE_ACTION	compositeAction)throws Exception{
		System.out.println("PILT023_A datatable delegate");
		/*String selectStatement = "SELECT ROWID,PT_IL_MEDEX_FEE_DTL.*  FROM PT_IL_MEDEX_FEE_DTL  WHERE MFD_SYS_ID IN (SELECT MFD_SYS_ID FROM PT_IL_MEDEX_FEE_DTL WHERE MFD_CLINIC_CODE = ?"
				+ " AND MFD_PAID_FLAG = 'N' AND MFD_PROP_NO IS NOT NULL  AND MFD_POL_NO IS NULL AND MFD_PROP_NO IN (SELECT POL_NO FROM PT_IL_POLICY A "
				+ "WHERE NVL(POL_CONVERT_YN, 'N') = 'N' AND POL_END_NO_IDX = (SELECT MAX(POL_END_NO_IDX) FROM PT_IL_POLICY B WHERE B.POL_NO = A.POL_NO))"
				+ " UNION "
				+ "SELECT MFD_SYS_ID FROM PT_IL_MEDEX_FEE_DTL A WHERE MFD_CLINIC_CODE = ? AND MFD_PAID_FLAG = 'N' AND MFD_PROP_NO IS NOT NULL "
				+ "AND MFD_POL_NO IS NOT NULL AND MFD_PROP_NO IN (SELECT POL_NO FROM PT_IL_POLICY WHERE POL_CONVERT_YN = 'Y') AND NOT EXISTS (SELECT 'X' "
				+ "FROM PT_IL_MEDEX_FEE_DTL B WHERE A.MFD_PROP_NO = B.MFd_PROP_NO AND B.MFD_PAID_FLAG = 'Y' AND B.MFD_EXAM_CODE = A.MFD_EXAM_CODE "
				+ "AND B.MFD_CLINIC_CODE = A.MFD_CLINIC_CODE AND B.MFD_POL_NO IS NULL))";*/
		
		String icQuery="SELECT POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2 FROM PT_IL_POLICY WHERE POL_PROP_NO=?";
		
		//Added by saritha on 13-03-2018
		String contNameQuery="SELECT CONT_NAME FROM PM_IL_CONTRACTOR WHERE CONT_CODE = ?";
		//End
		
		//PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_bean = new PT_IL_MEDEX_FEE_DTL();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet bankResultSet =  null;
		String selectStatement = null;
		String clinicDetailsQuery = null;
		Object[] clinicDtlParams = null;
		String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
		ResultSet sortCodeRS = null;
		CRUDHandler crudHandler = new CRUDHandler();
		System.out.println("PT_IL_MEDEX_FEE_DTL_bean getMFD_CLINIC_CODE       "
		+compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE());
		
		try {
			connection = CommonUtils.getConnection();
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getMedicalDataList().clear();
			
			/*Added by saritha on 20-04-2018 for KIC Medical Clinic Payment Issues*/
			
			String clinicCode=compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE();
			Date fromDate= compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_FROM_DT();
			Date toDate= compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_TO_DT();
			
			String clinicDetailsParam = String.valueOf(CommonUtils.getPPSystemParameterValue("IL_CLN_DTYN"));
			System.out.println("clinicDetailsParam ----->" +clinicDetailsParam );

			if(clinicDetailsParam.equalsIgnoreCase("1")){
				
				clinicDetailsQuery = "SELECT ROWID, PT_IL_MEDEX_FEE_DTL.* FROM PT_IL_MEDEX_FEE_DTL WHERE MFD_SYS_ID IN (SELECT DISTINCT MFD_SYS_ID "
						+ "FROM PT_IL_MEDEX_FEE_DTL, PT_IL_POL_MED_EXAM_DTL WHERE MFD_CLINIC_CODE = ? AND MFD_PAID_FLAG = 'N' AND MFD_PROP_NO IS NOT NULL "
						+ "AND MFD_POL_NO IS NULL AND TO_DATE(PMED_EXM_DN_DT, 'DD/MM/RRRR') BETWEEN TO_DATE(?, 'DD/MM/RRRR') AND TO_DATE(?, 'DD/MM/RRRR') "
						+ "AND PMED_POL_SYS_ID = MFD_POL_SYS_ID AND PMED_CLINIC_CODE = MFD_CLINIC_CODE AND MFD_PROP_NO IN(SELECT POL_NO FROM PT_IL_POLICY "
						+ "A WHERE NVL(POL_CONVERT_YN, 'N') = 'N' AND POL_END_NO_IDX =(SELECT MAX(POL_END_NO_IDX) FROM PT_IL_POLICY B "
						+ "WHERE B.POL_NO = A.POL_NO)) UNION SELECT DISTINCT MFD_SYS_ID FROM PT_IL_MEDEX_FEE_DTL A, PT_IL_POL_MED_EXAM_DTL WHERE"
						+ " MFD_CLINIC_CODE = ? AND PMED_POL_SYS_ID = MFD_POL_SYS_ID AND PMED_CLINIC_CODE = MFD_CLINIC_CODE AND MFD_PAID_FLAG = 'N' "
						+ "AND MFD_PROP_NO IS NOT NULL AND MFD_POL_NO IS NOT NULL AND TO_DATE(PMED_EXM_DN_DT, 'DD/MM/RRRR') BETWEEN TO_DATE(?, 'DD/MM/RRRR') "
						+ "AND TO_DATE(?, 'DD/MM/RRRR') AND MFD_PROP_NO IN(SELECT POL_NO FROM PT_IL_POLICY WHERE POL_CONVERT_YN = 'Y') "
						+ "AND NOT EXISTS (SELECT 'X' FROM PT_IL_MEDEX_FEE_DTL B WHERE A.MFD_PROP_NO = B.MFd_PROP_NO AND B.MFD_PAID_FLAG = 'Y' AND "
						+ "B.MFD_EXAM_CODE = A.MFD_EXAM_CODE AND B.MFD_CLINIC_CODE = A.MFD_CLINIC_CODE AND B.MFD_POL_NO IS NULL))";
                   
				clinicDtlParams =  new Object[]{clinicCode,fromDate,toDate,clinicCode,fromDate,toDate};
				resultSet = new CRUDHandler().executeSelectStatement(clinicDetailsQuery, connection, clinicDtlParams);
				
			}else{
				selectStatement = "SELECT ROWID,PT_IL_MEDEX_FEE_DTL.*  FROM PT_IL_MEDEX_FEE_DTL  WHERE MFD_SYS_ID IN (SELECT MFD_SYS_ID FROM PT_IL_MEDEX_FEE_DTL WHERE MFD_CLINIC_CODE = ?"
						+ " AND MFD_PAID_FLAG = 'N' AND MFD_PROP_NO IS NOT NULL  AND MFD_POL_NO IS NULL AND MFD_PROP_NO IN (SELECT POL_NO FROM PT_IL_POLICY A "
						+ "WHERE NVL(POL_CONVERT_YN, 'N') = 'N' AND POL_END_NO_IDX = (SELECT MAX(POL_END_NO_IDX) FROM PT_IL_POLICY B WHERE B.POL_NO = A.POL_NO))"
						+ " UNION "
						+ "SELECT MFD_SYS_ID FROM PT_IL_MEDEX_FEE_DTL A WHERE MFD_CLINIC_CODE = ? AND MFD_PAID_FLAG = 'N' AND MFD_PROP_NO IS NOT NULL "
						+ "AND MFD_POL_NO IS NOT NULL AND MFD_PROP_NO IN (SELECT POL_NO FROM PT_IL_POLICY WHERE POL_CONVERT_YN = 'Y') AND NOT EXISTS (SELECT 'X' "
						+ "FROM PT_IL_MEDEX_FEE_DTL B WHERE A.MFD_PROP_NO = B.MFd_PROP_NO AND B.MFD_PAID_FLAG = 'Y' AND B.MFD_EXAM_CODE = A.MFD_EXAM_CODE "
						+ "AND B.MFD_CLINIC_CODE = A.MFD_CLINIC_CODE AND B.MFD_POL_NO IS NULL))";
				
				clinicDtlParams =  new Object[]{clinicCode,clinicCode};
				resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection, clinicDtlParams);
				
			}
			
			/*End*/
			
			connection = CommonUtils.getConnection();
			
			ArrayList<PT_IL_MEDEX_FEE_DTL> obj=new ArrayList<PT_IL_MEDEX_FEE_DTL>();
			//PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_BEAN = compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN();
			
			while (resultSet.next()) {
				
				//PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_bean = new PT_IL_MEDEX_FEE_DTL();
				PT_IL_MEDEX_FEE_DTL_bean = new PT_IL_MEDEX_FEE_DTL();
				
				PT_IL_MEDEX_FEE_DTL_bean.setROWID(resultSet.getString("ROWID"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_PROP_NO(resultSet.getString("MFD_PROP_NO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_SYS_ID(resultSet.getLong("MFD_SYS_ID"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_POL_SYS_ID(resultSet.getLong("MFD_POL_SYS_ID"));
				
				//PT_IL_MEDEX_FEE_DTL_bean.setNEW_ICNO(resultSet.getString("NEW_ICNO"));
				//PT_IL_MEDEX_FEE_DTL_bean.setOLD_ICNO(resultSet.getString("OLD_ICNO"));
				//System.out.println("PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO() *******************"+PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO());
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_EXAM_CODE(resultSet.getString("MFD_EXAM_CODE"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_EXAM_DT(resultSet.getDate("MFD_EXAM_DT"));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CURR_CODE(resultSet.getString("MFD_CURR_CODE"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FC_VALUE(resultSet.getDouble("MFD_FC_VALUE"));	

				PT_IL_MEDEX_FEE_DTL_bean.setMFD_INV_REF_NO(resultSet.getString("MFD_INV_REF_NO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_PYMT_TO(resultSet.getString("MFD_PYMT_TO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FRZ_FLAG(resultSet.getString("MFD_FRZ_FLAG"));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_LC_VALUE(resultSet.getDouble("MFD_LC_VALUE"));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_POL_NO(resultSet.getString("MFD_POL_NO"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_POL_CONT_CODE(resultSet.getString("MFD_POL_CONT_CODE"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_POAD_SYS_ID(resultSet.getLong("MFD_POAD_SYS_ID"));
				/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CLINIC_CODE(compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE());
				/* End */
				//PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_EXAM_CODE_DESC(resultSet.getString("MFD_CURR_CODE"));
				PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_EXAM_CODE_DESC(getEXAM_CODEDESC(resultSet.getString("MFD_EXAM_CODE")));
				PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_CURR_CODE_DESC(getCURRENCY_DESC(resultSet.getString("MFD_CURR_CODE")));
				
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_REMARKS(resultSet.getString("MFD_REMARKS"));
				//System.out.println("******test****"+PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO());
				resultSet2 = crudHandler.executeSelectStatement(
						icQuery, connection,new Object[]{PT_IL_MEDEX_FEE_DTL_bean.getMFD_PROP_NO()});
				while (resultSet2.next()) {
					//System.out.println("INSIDE ID RS");
					PT_IL_MEDEX_FEE_DTL_bean.setNEW_ICNO(resultSet2.getString("POL_ASSRD_REF_ID1"));
					PT_IL_MEDEX_FEE_DTL_bean.setOLD_ICNO(resultSet2.getString("POL_ASSRD_REF_ID2"));
				}
				
				
				bankResultSet = compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().validateBankDetails(PT_IL_MEDEX_FEE_DTL_bean);
				if(bankResultSet!=null && bankResultSet.next()){					
					PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_01(bankResultSet.getString("CBAD_CUST_BANK_CODE"));
					PT_IL_MEDEX_FEE_DTL_bean.setUI_M_MFD_BANK_DESC(bankResultSet.getString("BANK_NAME"));
					PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_02(bankResultSet.getString("CBAD_DIVISION"));

					if(PT_IL_MEDEX_FEE_DTL_bean.getMFD_FLEX_02()!=null){
						sortCodeRS = crudHandler.executeSelectStatement(sortCodeQry, connection, new Object[]{PT_IL_MEDEX_FEE_DTL_bean.getMFD_FLEX_01(),PT_IL_MEDEX_FEE_DTL_bean.getMFD_FLEX_02()});
						if(sortCodeRS.next()){
							PT_IL_MEDEX_FEE_DTL_bean.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
						}
					}

					PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_03(bankResultSet.getString("CBAD_ACNT_NO"));
					PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_04(bankResultSet.getString("CBAD_ACNT_NAME"));
					PT_IL_MEDEX_FEE_DTL_bean.setMFD_FLEX_05(bankResultSet.getString("CUST_MOBILE"));

				}
				
				/*Added by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CR_DT(resultSet.getDate("MFD_CR_DT"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_PAID_FLAG(resultSet.getString("MFD_PAID_FLAG"));
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_CUST_CODE(resultSet.getString("MFD_CUST_CODE"));	
		
				resultSet3 = new CRUDHandler().executeSelectStatement(
						contNameQuery, connection,new Object[]{PT_IL_MEDEX_FEE_DTL_bean.getMFD_POL_CONT_CODE()});
				
				while(resultSet3.next()){
					PT_IL_MEDEX_FEE_DTL_bean.setWM_MFD_POL_CONT_NAME(resultSet3.getString("CONT_NAME"));
					System.out.println("Contractor Name" +PT_IL_MEDEX_FEE_DTL_bean.getWM_MFD_POL_CONT_NAME());
				}

				/*End*/
				
				/*Added by saritha on 19-04-2018 for KIC Medical Clinic Payment Issues*/
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_FROM_DT(compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_FROM_DT());
				PT_IL_MEDEX_FEE_DTL_bean.setMFD_TO_DT(compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_TO_DT());
				/*End*/

				obj.add(PT_IL_MEDEX_FEE_DTL_bean);				
			}
			//System.out.println("Payment To "+PT_IL_MEDEX_FEE_DTL_bean.getMFD_PYMT_TO());
			compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().setMedicalDataList(obj);
			System.out.println("medicallll dataList       ::"+compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getMedicalDataList());
			
			/*Commentted &Modified by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
			
			//System.out.println("Payment To1 "+PT_IL_MEDEX_FEE_DTL_bean.getMFD_PYMT_TO());
			//callMFD_PYMT_TO_PROC(compositeAction,PT_IL_MEDEX_FEE_DTL_bean.getMFD_PYMT_TO());
			if(obj!=null && obj.size() > 0){
				compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getCOMP_MFD_PYMT_TO().setDisabled(false);
			}
			
			/*End*/
	
		} 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
		
	}
	
	public void callMFD_PYMT_TO_PROC(PILT023_COMPOSITE_ACTION compositeAction,String PYMT_TO) throws Exception
	{
		Connection con=CommonUtils.getConnection();
		ArrayList<String> returnList = new ArrayList<String>();
		String P_CUST_CODE = null;
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		//OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",current);
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",(String.valueOf(
				compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_POL_SYS_ID()) ));
	    parameterList.add(param1);
	    OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getDUMMY_BEAN().getMFD_CLINIC_CODE());
	    parameterList.add(param2);
	    OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",PYMT_TO);
	    parameterList.add(param3);
	    OracleParameter param4 = new OracleParameter("OUT1", "STRING", "OUT",P_CUST_CODE);
	    parameterList.add(param4); 
		
	    OracleProcedureHandler procHandler = new OracleProcedureHandler();
	    outputList = procHandler.execute(parameterList, con,"P9ILPK_MEDICAL_FEES.P_ASSIGN_CUST_CODE");
	    
	  Iterator<OracleParameter> iterator = outputList.iterator();
	    while (iterator.hasNext()) {
	        OracleParameter oracleParameter = iterator.next();
	        System.out.println("Output value:::" + oracleParameter.getValue());
	        
	        returnList.add(oracleParameter.getValue());
	    }
	    
	    /*Commentted by Saritha on 14.03.2018 for In medical and clinic payment screen need to default the Bank details from customer master*/
	    
	    /*compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().setMFD_CUST_CODE(returnList.get(0));*/
	    
	    /*End*/
	    System.out.println("PT_IL_MEDEX_FEE_DTL_BEAN.getMFD_CUST_CODE           "+
	    compositeAction.getPILT023_MEDICAL_CLINIC_PAYMENTS_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().getMFD_CUST_CODE());
	}
	
	
	/* Newly Added By Dhinesh on 4/9/2017 for ssp call id : ZBILQC-1736304 */
	public String getEXAM_CODEDESC(String CODE)
			throws Exception {
		ResultSet resultSet = null;
		String Codedesc="";
		
		try {
			
			String C1 =" SELECT PC_LONG_DESC FROM PM_CODES WHERE  PC_TYPE = 'IL_MED_EXM' AND PC_CODE= ? ";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection(),new Object[] { CODE });
			if (resultSet.next()) {
				Codedesc=resultSet.getString("PC_LONG_DESC");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return Codedesc;

	}
	
	public String getCURRENCY_DESC(String CODE)
			throws Exception {
		ResultSet resultSet = null;
		String Codedesc="";
		
		try {
			
			String C1 =" SELECT CURR_NAME FROM FM_CURRENCY WHERE CURR_CODE =? ";
			resultSet = new CRUDHandler().executeSelectStatement(C1,
					CommonUtils.getConnection(),new Object[] { CODE });
			if (resultSet.next()) {
				Codedesc=resultSet.getString("CURR_NAME");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return Codedesc;

	}


/* End */	
	
}
