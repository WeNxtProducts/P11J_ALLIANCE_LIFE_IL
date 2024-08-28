package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_MED_EXAM_DTL_1_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_POL_MED_EXAM_DTL_1_DELEGATE().executeSelectStatement(
													compositeAction,
													compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
													.getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_POL_SYS_ID(),
													compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
													.getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_SYS_ID());

			List<PT_IL_POL_MED_EXAM_DTL_1> dataList = compositeAction
									.getPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN()
									.getDataList_PT_IL_POL_MED_EXAM_DTL_1();
			if (dataList != null && dataList.size() > 0) {
				PT_IL_POL_MED_EXAM_DTL_1 PT_IL_POL_MED_EXAM_DTL_1_BEAN = dataList.get(0);
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN().setPT_IL_POL_MED_EXAM_DTL_1_BEAN(
																			PT_IL_POL_MED_EXAM_DTL_1_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preInsert(PT_IL_POL_MED_EXAM_DTL_1 medicalDetail,
			PT_IL_POL_ASSURED_DTLS_1 assured1Bean,PT_IL_POLICY policyBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Long M_PMED_SYS_ID = 0l;

		String CURSOR_C1 = "SELECT PIL_PMED_SYS_ID.NEXTVAL FROM   DUAL";

		CRUDHandler handler = new CRUDHandler();
		try {
				connection = CommonUtils.getConnection();
				resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
	
				if (resultSet.next()) {
					M_PMED_SYS_ID = resultSet.getLong(1);
				}
	
				medicalDetail.setPMED_SYS_ID(M_PMED_SYS_ID);
				medicalDetail.setPMED_CR_DT(new CommonUtils().getCurrentDate());
				medicalDetail.setPMED_CR_UID("GLOBAL:USER_ID");
				medicalDetail.setPMED_DEL_FLAG("N");
				medicalDetail.setPMED_END_NO_IDX(policyBean.getPOL_END_NO_IDX());
				medicalDetail.setPMED_POL_SYS_ID(policyBean.getPOL_SYS_ID());
				medicalDetail.setPMED_POAD_SYS_ID(assured1Bean.getPOAD_SYS_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void preUpdate(PT_IL_POL_MED_EXAM_DTL_1 examDetail, CTRL ctrlBean)
			throws Exception {
		try {
				examDetail.setPMED_UPD_DT(new CommonUtils().getCurrentDate());
				examDetail.setPMED_UPD_UID(ctrlBean.getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void whenNewBlockInstance(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {
			executeQuery(compositeAction);
			/*compositeAction.getPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN()
									.getCOMP_PMED_GOVT_LC_AMT().setDisabled(true);*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void postQuery(PT_IL_POL_MED_EXAM_DTL_1_ACTION examAction,
			PT_IL_POLICY policyBean) throws Exception {

		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		DBProcedures procedures = new DBProcedures();
		
		PT_IL_POL_MED_EXAM_DTL_1 examDetail = examAction.getPT_IL_POL_MED_EXAM_DTL_1_BEAN();
		try {
				list = procedures.P_VAL_CODES(
											"IL_MED_EXM",
											examDetail.getPMED_EXAM_CODE(),
											examDetail.getUI_M_MED_EXAM_CODE_DESC(),
											"N", "N", null);
				if (list != null && !list.isEmpty()) {
					examDetail.setUI_M_MED_EXAM_CODE_DESC(list.get(0));
				}
				list1 = pkg_pilt002_apac.P_VAL_CLASS_CUST(
														"HOSPITALS", 
														examDetail.getPMED_CLINIC_CODE(),
														examDetail.getUI_M_CLINIC_CODE_DESC(),
														"N", "N",
														policyBean.getPOL_DIVN_CODE());
				if (list1 != null && !list1.isEmpty()) {
					examDetail.setUI_M_CLINIC_CODE_DESC(list1.get(0));
				}
				if ("Y".equals(examDetail.getPMED_DEL_FLAG())) {
					examAction.getCOMP_PMED_DEL_FLAG().setDisabled(false);
				} else {
					examAction.getCOMP_PMED_DEL_FLAG().setDisabled(true);
				}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenCreateRecord(PT_IL_POL_MED_EXAM_DTL_1 examDetail,
			PT_IL_POLICY policyBean) throws Exception {
		
		 
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> pvalOrclList = null;

		try {
				examDetail.setPMED_STATUS("N");
				pvalOrclList = pkg_pilt002_apac.L_GET_CLINIC_CODE(  
													examDetail.getPMED_CLINIC_CODE(),
													policyBean.getPOL_CONT_CODE(),
													policyBean.getPOL_DIVN_CODE(),
													CommonUtils.getProcedureValue(policyBean.getPOL_LC_SUM_ASSURED()));
				if(pvalOrclList != null && !pvalOrclList.isEmpty()){
					if (pvalOrclList.get(0).getValue() != null) {
						examDetail.setPMED_CLINIC_CODE(pvalOrclList.get(0).getValue());
					}
				}
					
		}  catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void keyDelRec(PT_IL_POL_MED_EXAM_DTL_1_ACTION examAction,
			DUMMY dummyBean) throws Exception {

		ResultSet resultSet = null;
		Connection connection = null;
		
		CRUDHandler handler = new CRUDHandler();
		
		String CURSOR_C1 = "SELECT 'X' FROM PT_IL_MEDEX_FEE_DTL WHERE  MFD_POL_SYS_ID  =  ? "
							+ " AND    MFD_CLINIC_CODE = ? AND MFD_EXAM_CODE = ? AND MFD_PAID_FLAG ='Y' ";
		
		PT_IL_POL_MED_EXAM_DTL_1 examBean = examAction.getPT_IL_POL_MED_EXAM_DTL_1_BEAN();

		try {
				connection = CommonUtils.getConnection();
				resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
										new Object[] { 	examBean.getPMED_POL_SYS_ID(),
														examBean.getPMED_CLINIC_CODE(),
														examBean.getPMED_EXAM_CODE() });
				if (resultSet.next()) {
					dummyBean.setUI_M_DUMMY(resultSet.getString(1));
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91583"));
				} else {
					if ("N".equals(CommonUtils.nvl(examBean.getPMED_DEL_FLAG(), "N"))) {
						examBean.setPMED_DEL_FLAG("Y");
					}
				}
			  CommonUtils.closeCursor(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void whenNewRecordInstance(PT_IL_POL_MED_EXAM_DTL_1_ACTION examAction)
			throws Exception {
		PT_IL_POL_MED_EXAM_DTL_1 examBean = examAction.getPT_IL_POL_MED_EXAM_DTL_1_BEAN();
		try {

			if (examAction.isUPDATE_ALLOWED() == true) {
				if ("Y".equals(examBean.getPMED_STATUS())) {
					examAction.getCOMP_PMED_EXAM_CODE().setDisabled(true);
					examAction.getCOMP_PMED_CLINIC_CODE().setDisabled(true);
					examAction.getCOMP_PMED_PVT_LC_AMT().setDisabled(true);
				} else {
					if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(1, 2))) {
						examAction.getCOMP_PMED_EXAM_CODE().setDisabled(false);
						examAction.getCOMP_PMED_CLINIC_CODE().setDisabled(false);
						examAction.getCOMP_PMED_PVT_LC_AMT().setDisabled(false);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}	

	public void PMED_EXAM_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_MED_EXAM_DTL_1 examDetail) throws Exception {

		String M_TEMP = null;
		Double M_PC_VALUE = null;
		String M_PC_REMARKS = null;

		String CURSOR_C1 = "SELECT ROWID FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ? AND "
							+ "PMED_POAD_SYS_ID = ? AND PMED_EXAM_CODE = ? AND NVL(PMED_END_NO_IDX,0) = NVL( ?,0) "
							+ " AND    PMED_DEL_FLAG  = ? ";

		String CURSOR_C2 = "SELECT PC_VALUE,PC_REMARKS FROM PM_CODES WHERE PC_TYPE  ='IL_MED_EXM' "
							+ " AND PC_CODE  = ? ";
		
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Connection connection = null;
		ArrayList<String> list = null;

		DBProcedures procedures = new DBProcedures();
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			if (examDetail.getPMED_EXAM_CODE() != null) {
				list = procedures.P_VAL_CODES(
												"IL_MED_EXM",
												examDetail.getPMED_EXAM_CODE(), 
												examDetail.getUI_M_MED_EXAM_CODE_DESC(),
												"N", "E", null);
				if (list != null && !list.isEmpty()) {
					examDetail.setUI_M_MED_EXAM_CODE_DESC(list.get(0));
				}
				resultSet = handler.executeSelectStatement(CURSOR_C1,connection,
										new Object[] {
													examDetail.getPMED_POL_SYS_ID(),
													examDetail.getPMED_POAD_SYS_ID(),
													examDetail.getPMED_EXAM_CODE(),
													examDetail.getPMED_END_NO_IDX(),
													examDetail.getPMED_DEL_FLAG() });
				if (resultSet.next()) {
					M_TEMP = resultSet.getString(1);
					if (CommonUtils.isDuplicate(examDetail.getROWID(),M_TEMP)) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71018"));
					}
						
				} else {
					resultSet1 = handler.executeSelectStatement(CURSOR_C2,connection, 
											new Object[] { examDetail.getPMED_EXAM_CODE() });
						if (resultSet1.next()) {
							M_PC_VALUE = resultSet1.getDouble(1);
							M_PC_REMARKS = resultSet1.getString(2);
						}
					CommonUtils.closeCursor(resultSet1);
					examDetail.setPMED_PVT_LC_AMT(M_PC_VALUE);
					examDetail.setPMED_GOVT_LC_AMT(Double.parseDouble(CommonUtils.nvl(M_PC_REMARKS,"0")));
				}
			CommonUtils.closeCursor(resultSet);
		}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
		}
	}

	public String PMED_CLINIC_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_MED_EXAM_DTL_1 examDetail, PT_IL_POLICY policyBean)
			throws Exception {

		String M_AREA_CODE = null;
		String M_DUMMY = null;
		String M_CODE_DESC = null;
		Double M_VALUE = null;
		Double M_CUST_LC_SUM_ASSURED = null;
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList<String> pvalList = null;
		ArrayList<String> list1 = null;
		String str=null;
		String CURSOR_C1 = "SELECT CONT_POSTAL_CODE FROM   PM_IL_CONTRACTOR WHERE  CONT_CODE = ? ";
		String CURSOR_C2 = "SELECT 'X' FROM PM_CUSTOMER WHERE CUST_POSTAL_CODE = ? AND  CUST_CODE = ? ";
		String CURSOR_C3 = "SELECT NVL(CUST_LC_SUM_ASSURED,0) FROM   PM_CUSTOMER WHERE  CUST_CODE  =  ? ";
		
		CRUDHandler handler = new CRUDHandler();
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		try {
			connection = CommonUtils.getConnection();
			if (examDetail.getPMED_CLINIC_CODE() != null) {
				pvalList = pkg_pilt002_apac.P_VAL_CLASS_CUST(
															"HOSPITALS", 
															examDetail.getPMED_CLINIC_CODE(), 
															examDetail.getUI_M_CLINIC_CODE_DESC(),
															"N", "E", 
															policyBean.getPOL_DIVN_CODE());
				
				if(!pvalList.isEmpty()){
					examDetail.setUI_M_CLINIC_CODE_DESC(pvalList.get(0));
				}
				
				resultSet = handler.executeSelectStatement(CURSOR_C1,connection,
										new Object[] { policyBean.getPOL_CONT_CODE() });
				if (resultSet.next()) {
					M_AREA_CODE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				resultSet = handler.executeSelectStatement(CURSOR_C2,connection, 
										new Object[] { M_AREA_CODE,examDetail.getPMED_CLINIC_CODE() });
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				} else {
					/*throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"3206",
											new Object[] {*/ 
					str="This clinic is not in the same area" ;
				}
				CommonUtils.closeCursor(resultSet);
				list1 = DBProcedures.P_VAL_SYSTEM(
												"IL_CLINIC_SA",
												"IL_CLINIC_SA",
												M_CODE_DESC, "E",
												CommonUtils.getProcedureValue(M_VALUE));
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						M_CODE_DESC = list1.get(0);
					}if (list1.get(1) != null) {
						M_VALUE = Double.parseDouble(list1.get(1));
					}
				}
				if (M_VALUE == 2) {
					resultSet = handler.executeSelectStatement(CURSOR_C3,connection,
											new Object[] { examDetail.getPMED_CLINIC_CODE() });
					if (resultSet.next()) {
						M_CUST_LC_SUM_ASSURED = resultSet.getDouble(1);
					}
					CommonUtils.closeCursor(resultSet);
					if (M_CUST_LC_SUM_ASSURED < policyBean.getPOL_LC_SUM_ASSURED()) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91206"));
					}
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return str;
	}

	public void PMED_STATUS_WHEN_VALIDATE_ITEM(PT_IL_POL_MED_EXAM_DTL_1_ACTION examAction,PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		String M_DUMMY = null;
		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_MEDEX_FEE_DTL WHERE MFD_POL_SYS_ID  = ? "
				+ "	AND MFD_CLINIC_CODE = ? AND MFD_EXAM_CODE = ? AND  NVL(MFD_END_NO_IDX,0) = NVL( ? ,0) "
				+ "	AND    MFD_PAID_FLAG ='Y' ";
		PT_IL_POL_MED_EXAM_DTL_1 examBean = examAction.getPT_IL_POL_MED_EXAM_DTL_1_BEAN();
		
		ResultSet resultSet = null;
		Connection connection = null;
		
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if ("Y".equals(examBean.getPMED_STATUS())) {
				
				if(examBean.getPMED_REP_REC_DT()==null)
				{
					examBean.setPMED_REP_REC_DT(new CommonUtils().getCurrentDate());	
				}
				examAction.getCOMP_PMED_REP_REC_DT().setRendered(true);
				//commented by saranya
				//examAction.getCOMP_PMED_REP_REC_DT().setDisabled(false);
				examAction.getCOMP_PMED_REP_REC_DT().setDisabled(true);
				examAction.getCOMP_PMED_GOVT_LC_AMT().setDisabled(true);
				
				examAction.getCOMP_PMED_REP_REC_DT().resetValue();
				
			} else if ("N".equals(examBean.getPMED_STATUS())) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,connection,
										new Object[] {	examBean.getPMED_POL_SYS_ID(),
														examBean.getPMED_CLINIC_CODE(),
														examBean.getPMED_EXAM_CODE(),
														examBean.getPMED_END_NO_IDX() });
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					examBean.setPMED_STATUS("Y");
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91581"));
				} else {
					//commented by saranya
					//examAction.getCOMP_PMED_REP_REC_DT().setDisabled(true);
					examAction.getCOMP_PMED_REP_REC_DT().setDisabled(false);
					if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(1, 2))) {
						examAction.getCOMP_PMED_CLINIC_CODE().setDisabled(false);
						examAction.getCOMP_PMED_EXAM_CODE().setDisabled(false);
						examAction.getCOMP_PMED_PVT_LC_AMT().setDisabled(false);
					}
				}
				/*Added by Janani on 07.05.2018 for Fidelity as suggested by Sivaram*/
				examBean.setPMED_REP_REC_DT(null);
				examAction.getCOMP_PMED_REP_REC_DT().resetValue();
				/*End*/
			}else if("NA".equals(examBean.getPMED_STATUS())){
				
				if(examBean.getPMED_REP_REC_DT()==null){
					examBean.setPMED_REP_REC_DT(new CommonUtils().getCurrentDate());
					}
				
			/*	examAction.getCOMP_PMED_REMARKS().setDisabled(false);*/
				
				/*Added by Janani on 19.07.2017 for ZBILQC-1732338*/
				
				String chk_wav_auth=chk_waiverAuthorisation(compositeAction);
			
				System.out.println("chk_wav_auth                  "+chk_wav_auth);
				
				if("N".equalsIgnoreCase(chk_wav_auth))
				{
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath,"3206",
							new Object[] { "The User is not authorized to waive Medical Examination " }));
				}
				
				/*End*/
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}

	public String chk_waiverAuthorisation(PILT002_APAC_COMPOSITE_ACTION compositeAction){
		 
		 String ASD_CHAR_VALUE = null;
		 Connection connection = null;
		Object[] object1= null;
		ResultSet rs1 = null;
		
		String query1 ="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID =? AND"
						+ " ASD_CODE = 'MED_CK_AP_YN' AND ? BETWEEN ASD_FM_PROD_CODE AND  ASD_TO_PROD_CODE";
		
		System.out.println("enters into chk_waiverAuthorisation");
		
		try {
			
			connection = CommonUtils.getConnection();
				
			object1 = new Object[] {	CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()};
			rs1 = new CRUDHandler().executeSelectStatement(query1,connection, object1);
			if (rs1.next()) {
				ASD_CHAR_VALUE= rs1.getString(1);
			}

			System.out.println("ASD_CHAR_VALUE               "+ASD_CHAR_VALUE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ASD_CHAR_VALUE;
	}
	
}
