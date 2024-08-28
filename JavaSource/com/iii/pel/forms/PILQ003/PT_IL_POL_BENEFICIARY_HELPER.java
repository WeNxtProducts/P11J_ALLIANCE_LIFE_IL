package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.PKG_PILQ003;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_BENEFICIARY_HELPER {

	public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction)
	throws Exception {
		new PT_IL_POL_BENEFICIARY_DELEGATE()
		.executeSelectStatement(compositeAction);

		List<PT_IL_POL_BENEFICIARY> dataList = compositeAction
		.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
		.getDataList_PT_IL_POL_BENEFICIARY();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_BENEFICIARY PT_IL_POL_BENEFICIARY_BEAN = dataList.get(0);
			PT_IL_POL_BENEFICIARY_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
			.setPT_IL_POL_BENEFICIARY_BEAN(PT_IL_POL_BENEFICIARY_BEAN);
		}
	}

	public void keyDelRec(PT_IL_POL_BENEFICIARY beneficiaryBean) {

		if (beneficiaryBean.getROWID() != null
				&& beneficiaryBean.getPBEN_BNF_NAME() == null) {
			beneficiaryBean.setPBEN_SR_NO(null);
		}
	}

	public void postQuery(PT_IL_POL_BENEFICIARY beneficiaryBean, DUMMY dummyBean)
	throws Exception {
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;
		DBProcedures procedures = new DBProcedures();
		try {
			list = procedures.P_VAL_CODES("ILBENFREL", beneficiaryBean
					.getPBEN_RELATION_CODE(), beneficiaryBean
					.getUI_M_PBEN_RELATION_DESC(), "N", "N", null);
			
			if(!list.isEmpty() && list.get(0)!=null )
			    beneficiaryBean.setUI_M_PBEN_RELATION_DESC(list.get(0));
			
			list1 = DBProcedures.P_VAL_SYSTEM("ILBENFTYPE", beneficiaryBean
					.getPBEN_BNF_TYPE(), beneficiaryBean
					.getUI_M_PBEN_TYPE_DESC(), "N", dummyBean
					.getUI_M_PS_VALUE_DUMMY());
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					beneficiaryBean.setUI_M_PBEN_TYPE_DESC(list1.get(0));
				}
				if (list1.get(1) != null) {
					dummyBean.setUI_M_PS_VALUE_DUMMY(list1.get(1));
				}
			}
			list2 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
					.getPBEN_CATG_CODE(), beneficiaryBean.getUI_M_CATG_DESC(),
					"N", dummyBean.getUI_M_PS_VALUE_DUMMY());
			if (list2 != null && !list2.isEmpty()) {
				if (list2.get(0) != null) {
					beneficiaryBean.setUI_M_CATG_DESC(list2.get(0));
				}
				if (list2.get(1) != null) {
					dummyBean.setUI_M_PS_VALUE_DUMMY(list2.get(1));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenNewBlockInstance(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_BENEFICIARY_DELEGATE delegate = new PT_IL_POL_BENEFICIARY_DELEGATE();
		try {
			delegate.executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preUpdate(PT_IL_POLICY policyBean, CTRL ctrlBean,
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		try {
			beneficiaryBean.setPBEN_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			beneficiaryBean.setPBEN_UPD_DT(new CommonUtils().getCurrentDate());
			beneficiaryBean.setPBEN_UPD_UID(ctrlBean.getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		/*
		 * String UPDATE_QUERY = "UPDATE PT_IL_POL_BENEFICIARY SET PBEN_SR_NO =
		 * TO_NUMBER(:SYSTEM.TRIGGER_RECORD) WHERE PBEN_SYS_ID
		 * =:PT_IL_POL_BENEFICIARY.PBEN_SYS_ID AND PBEN_POL_SYS_ID =
		 * :PT_IL_POLICY.POL_SYS_ID;
		 */
	}

	public void preInsert(PT_IL_POLICY policyBean, CTRL ctrlBean,
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {

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
				beneficiaryBean.setPBEN_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			beneficiaryBean.setPBEN_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			beneficiaryBean.setPBEN_CR_DT(new CommonUtils().getCurrentDate());
			beneficiaryBean.setPBEN_CR_UID(ctrlBean.getUSER_ID());
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

	public void preQuery(PILQ003_COMPOSITE_ACTION compositeAction) {
		Long POL_SYS_ID = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
		.getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
		compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
		.setDEFAULT_WHERE("PBEN_POL_SYS_ID  = " + POL_SYS_ID + "");
	}

	public void whenCreateRecord(PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction)
	throws Exception {

		Double M_PS_VALUE = null;
		String M_PS_CODE_DESC = null;
		ArrayList<String> list = null;
		try {
			PT_IL_POL_BENEFICIARY beneficiaryBean = beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN();
			if (beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY().size() == 0) {
				beneficiaryBean.setPBEN_SR_NO(1);
			}else{
				beneficiaryBean.setPBEN_SR_NO(
						beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY().size()+1);
			}
			list = DBProcedures.P_VAL_SYSTEM("IL_BNF_ACT", "IL_BNF_ACT",
					M_PS_CODE_DESC, "N", CommonUtils.getProcedureValue(M_PS_VALUE));
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					M_PS_CODE_DESC = list.get(0);
				}
				if (list.get(1) != null) {
					M_PS_VALUE = Double.parseDouble(list.get(1));
				}
			}

			if (M_PS_VALUE == 1) {
				if (beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY().size() == 0) {
					beneficiaryBean.setPBEN_PERC(100.0d);
				} else {
					beneficiaryBean.setPBEN_PERC(0.0d);
				}
				beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(true);
				beneficiaryAction.setINSERT_ALLOWED(false);
				beneficiaryAction.setINSERT_ALLOWED(false);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PBEN_BNF_TYPE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction) throws Exception {

		String CURSOR_C1 = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'ILBENFTYPE' ";
		PT_IL_POL_BENEFICIARY beneficiaryBean = beneficiaryAction
		.getPT_IL_POL_BENEFICIARY_BEAN();
		String M_FLAG = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (beneficiaryBean.getPBEN_BNF_TYPE() != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection);
				while (resultSet.next()) {
					if (resultSet.getString(1).equals(
							beneficiaryBean.getPBEN_BNF_TYPE())) {
						beneficiaryBean.setUI_M_PBEN_TYPE_DESC(resultSet
								.getString(2));
						M_FLAG = "Y";
						break;
					} else {
						M_FLAG = "N";
					}
				}
				if ("N".equals(M_FLAG)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71253"));
				}
				if ("A".equals(beneficiaryBean.getPBEN_BNF_TYPE())) {
					beneficiaryBean.setPBEN_RELATION_CODE(" ");
					beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(
							false);
				} else {
					beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(
							true);
				}
				if ("N".equals(beneficiaryBean.getPBEN_BNF_TYPE())) {
					beneficiaryAction.getCOMP_PBEN_REF_ID2().setRequired(true);
				} else {
					beneficiaryAction.getCOMP_PBEN_REF_ID2().setRequired(false);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PBEN_REF_ID1_WHEN_VALIDATE_ITEM(
			PILQ003_COMPOSITE_ACTION compositeAction,PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		Double M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_DATE_CHAR = null;
		Integer M_GENDER = null;
		Double M_VALUE = null;
		String M_EXIST = null;
		Date M_TEMP_DATE = null;
		Date M_DOB_DT = null;
		String M_CUST_REF_ID1 = null;
		Double M_LENGTH_1 = null;
		Double M_NEW_IC_NO_LENGTH = null;
		Integer M_REF_ID_1_LENGTH = compositeAction
		.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getCOMP_PBEN_REF_ID1()
		.getMaxlength();
		String M_CODE_DESC = null;
		Double M_PS_VALUE = null;
		String CURSOR_C1 = "SELECT  COUNT(PBEN_SYS_ID) FROM PT_IL_POL_BENEFICIARY WHERE PBEN_POL_SYS_ID = ? ";
		String CURSOR_C2 = "SELECT SUBSTR(M_CUST_REF_ID1,1,6) FROM   DUAL";
		
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
		.getPT_IL_POLICY_BEAN();
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
		.getDUMMY_BEAN();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<OracleParameter> list2 = null;
		ArrayList<String> list3 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		try {
			connection = CommonUtils.getConnection();
			list = DBProcedures.P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_1",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_NEW_IC_NO_LENGTH));
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					M_CODE_DESC = list.get(0);
				}
				if (list.get(1) != null) {
					M_NEW_IC_NO_LENGTH = Double.parseDouble(list.get(1));
				}
			}
			M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,
					M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);

			if (beneficiaryBean.getPBEN_REF_ID1().length() > M_LENGTH_1) {
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "91240")));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getDouble(1);
			}
			CommonUtils.closeCursor(resultSet);
			list1 = DBProcedures.P_VAL_SYSTEM("CUSTREFFMT", "CUSTREFFMT",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_PS_VALUE));
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					M_CODE_DESC = list1.get(0);
				}
				if (list1.get(1) != null) {
					M_PS_VALUE = Double.parseDouble(list1.get(1));
				}
			}
			if (CommonUtils.nvl(M_EXIST, "N") != "Y"
				&& "1".equals(policyBean.getPOL_DS_TYPE())
				|| ("2".equals(policyBean.getPOL_DS_TYPE()) || policyBean
						.getPOL_END_NO_IDX() == 0)
						|| "011".equals(policyBean.getPOL_END_TYPE())
						|| "001".equals(policyBean.getPOL_END_TYPE())) {
				// we used direct java method to find substring
				M_DATE_CHAR = beneficiaryBean.getPBEN_REF_ID1().substring(0,6);
				M_TEMP_DATE = CommonUtils.stringToPelUtilDate(M_DATE_CHAR);
				if (CommonUtils.getYearFromDate(M_TEMP_DATE) > CommonUtils
						.getYearFromDate(new CommonUtils().getCurrentDate())) {
					M_TEMP_DATE = CommonUtils.addMonthsToDate(M_TEMP_DATE,-1200);
				}
				list2 = localProcedure.P_CALC_ANB(
						new CommonUtils().getCurrentDate(), 
						M_TEMP_DATE,
						dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
						beneficiaryBean.getPBEN_AGE());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0).getValueObject() != null) {
						beneficiaryBean.setPBEN_AGE((Integer)list2.get(0).getValueObject());
					}
				}
				M_GENDER = Integer.parseInt(beneficiaryBean.getPBEN_REF_ID1().substring(beneficiaryBean.getPBEN_REF_ID1().length()-1));
				if (M_GENDER % 2 == 0) {
					beneficiaryBean.setPBEN_CATG_CODE("2");
				} else if (M_GENDER % 2 > 0) {
					beneficiaryBean.setPBEN_CATG_CODE("1");
				}
				if (beneficiaryBean.getPBEN_CATG_CODE() != null) {
					list3 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
							.getPBEN_CATG_CODE(), beneficiaryBean
							.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
					if (list3 != null && !list3.isEmpty()) {
						if (list3.get(0) != null) {
							beneficiaryBean.setUI_M_CATG_DESC(list3.get(0));
						}
						if (list3.get(1) != null) {
							M_VALUE = Double.parseDouble(list3.get(1));
						}
					}
				}
				localProcedure.IL_GET_BENEF_DTL_ID(beneficiaryBean
						.getPBEN_REF_ID1(), beneficiaryBean.getPBEN_REF_ID2(),
						beneficiaryBean);
			}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
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

	public void PBEN_REF_ID2_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		try {
			localProcedure.IL_GET_BENEF_DTL_ID(beneficiaryBean
					.getPBEN_REF_ID1(), beneficiaryBean.getPBEN_REF_ID2(),
					beneficiaryBean);
			if ("N".equals(beneficiaryBean.getPBEN_BNF_TYPE())) {
				if (beneficiaryBean.getPBEN_REF_ID1() == null) {
					if (beneficiaryBean.getPBEN_REF_ID2() == null) {
						throw new Exception((Messages.getString(
								PELConstants.pelErrorMessagePath, "19050")));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PBEN_CATG_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {

		Double M_VALUE = null;
		ArrayList<String> list = null;
		try {
			if (beneficiaryBean.getPBEN_CATG_CODE() != null) {
				list = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
						.getPBEN_CATG_CODE(), beneficiaryBean
						.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						beneficiaryBean.setUI_M_CATG_DESC(list.get(0));
					}
					if (list.get(1) != null) {
						M_VALUE = Double.parseDouble(list.get(1));
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PBEN_AGE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction) throws Exception {
		PT_IL_POL_BENEFICIARY beneficiaryBean = beneficiaryAction
		.getPT_IL_POL_BENEFICIARY_BEAN();
		if (beneficiaryBean.getPBEN_AGE() <= 0) {
			throw new Exception((Messages.getString(
					PELConstants.pelErrorMessagePath, "91014",
					new Object[] { "Beneficiary age", "Greater than Zero" })));
		}
		if (beneficiaryBean.getPBEN_AGE() < 19) {
			beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(false);
			beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(true);
		} else {
			beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(true);
		}
	}

	public void PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {

		String CURSOR_C1 = "SELECT PC_CODE,PC_DESC FROM   PM_CODES WHERE  PC_TYPE = 'ILBENFREL'";
		String M_FLAG = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			while (resultSet.next()) {
				if (beneficiaryBean.getPBEN_RELATION_CODE().equals(
						resultSet.getString(1))) {
					beneficiaryBean.setUI_M_PBEN_RELATION_DESC(resultSet
							.getString(2));
					M_FLAG = "Y";
					break;
				} else {
					M_FLAG = "N";
				}
			}

			if ("N".equals(M_FLAG)
					&& beneficiaryBean.getPBEN_RELATION_CODE() != "S") {
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "71254")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PBEN_PERC_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction, DUMMY dummyBean)
	throws Exception {

		String M_PS_CODE_DESC = null;
		Double M_PS_VALUE = null;
		ArrayList<String> list = null;
		Double UI_M_SUM_PBEN_PERC = 0.0 ;
		
		PT_IL_POL_BENEFICIARY beneficiaryBean = beneficiaryAction
		.getPT_IL_POL_BENEFICIARY_BEAN();
		try {
			if (beneficiaryBean.getPBEN_PERC() != null && dummyBean.getUI_M_IL_BEN_VALUE() == 0) {
				list = DBProcedures.P_VAL_SYSTEM(
													"IL_BNF_ACT", 
													"IL_BNF_ACT",
													M_PS_CODE_DESC, "N",
													CommonUtils.getProcedureValue(M_PS_VALUE));
				if(list != null && !list.isEmpty()){
					if(list.get(0) != null){
						M_PS_CODE_DESC = list.get(0);
					}
					if(list.get(1) != null){
						M_PS_VALUE = Double.parseDouble(list.get(1));
					}
				}
				if (M_PS_VALUE == 1) {
					if (beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY().size() == 0) {
						
						beneficiaryBean.setPBEN_PERC(100.00);
						
					} else {
						beneficiaryBean.setPBEN_PERC(0.00);
					}
						
				}
				if ((beneficiaryBean.getPBEN_PERC() <0 || beneficiaryBean
						.getPBEN_PERC() > 100)) {
					throw new Exception((Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { " Beneficiary%",">= 0"  ,"AND <= 100" })));
				}

				for(PT_IL_POL_BENEFICIARY  bn: beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY()) {
					UI_M_SUM_PBEN_PERC = UI_M_SUM_PBEN_PERC + bn.getPBEN_PERC();
				}
				if(!beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY().contains(beneficiaryBean)){
					UI_M_SUM_PBEN_PERC = UI_M_SUM_PBEN_PERC + beneficiaryBean.getPBEN_PERC();
				}
				
				
				if(UI_M_SUM_PBEN_PERC != null){
					if (UI_M_SUM_PBEN_PERC > 100.00) {
						throw new Exception((Messages.getString(PELConstants.pelErrorMessagePath, "91136")));
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
