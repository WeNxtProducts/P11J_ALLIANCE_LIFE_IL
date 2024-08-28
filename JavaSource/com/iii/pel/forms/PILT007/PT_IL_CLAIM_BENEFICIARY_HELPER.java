package com.iii.pel.forms.PILT007;

import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT002_APAC.DUMMY;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_FUNERAL_MEMB_DTLS;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_CLAIM_BENEFICIARY_HELPER {

	Map<String, Object> session = null;
	ControlBean ctrlBean = null;
	FacesContext ctx ;

	public ControlBean getCtrlBean() {
		/*added by gopi for hands on feed back points,serial no 12 in zb on 10/02/17*/
		ctx = FacesContext.getCurrentInstance();
		//end
		session = ctx.getExternalContext().getSessionMap();
		return (ControlBean) session.get("ctrlbean");
	}

	public void cbenBankCodeWhenValidateItem(String bankCode,
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		String bankDesc = null;
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY1;
		// ControlBean controlBean = getCtrlBean();
		String langCode = CommonUtils.getControlBean().getM_LANG_CODE();
		// controlBean.getM_LANG_CODE();
		Object[] values = { langCode, bankCode };
		CRUDHandler handler = new CRUDHandler();
		PT_IL_CLAIM_BENEFICIARY_ACTION beneficiaryAction = compositeAction
				.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();
		ResultSet rst = null;
		try {
			Connection connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(sql_C1, connection, values);
			while (rst.next()) {
				bankDesc = rst.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (rst != null) {
					CommonUtils.closeCursor(rst);
				}
			} catch (Exception e) {
			}
		}
		beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
				.setUI_M_CBEN_BANK_CODE_DESC(bankDesc);
	}

	public void cbenBnfNameWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		String claimPolNo = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO();

		CRUDHandler handler = new CRUDHandler();
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY2;
		String M_POL_PROD_CODE = null;

		Map<String, Object> sessionMap = new CommonUtils().getSessionMap();
		String userId = (String) sessionMap.get("GLOBAL.M_USER_ID");

		String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY3;
		String ASD_CHAR_VALUE = null;

		Connection connection = null;
		ResultSet rst1 = null;
		ResultSet rst2 = null;
		try {
			connection = CommonUtils.getConnection();
			rst1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { claimPolNo });
			while (rst1.next()) {
				M_POL_PROD_CODE = rst1.getString(1);
			}

			rst2 = handler.executeSelectStatement(sql_C2, connection,
					new Object[] { userId, M_POL_PROD_CODE });
			while (rst2.next()) {
				ASD_CHAR_VALUE = rst2.getString(1);
			}
			if ((ASD_CHAR_VALUE == null ? "N" : ASD_CHAR_VALUE).equals("N")) {
				// throw exception
				throw new Exception(Messages.getString(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"91566"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
			} catch (Exception e) {
			}
		}
	}

	public void cbenBnfTypeWhenValidateItem(Object value,
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY4;
		String M_FLAG = null;
		Connection connection = null;
		PT_IL_CLAIM_BENEFICIARY_ACTION beneficiaryAction = compositeAction
				.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();
		/*
		 * int rowIndex =
		 * beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_DATATABLE()
		 * .getRowIndex(); PT_IL_CLAIM_BENEFICIARY beneficiaryBean =
		 * beneficiaryAction .getPT_IL_CLAIM_BENEFICIARY_LIST().get(rowIndex);
		 */
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		
		
		if ((String) value != null) {
			try {
				connection = CommonUtils.getConnection();
				rst = handler.executeSelectStatement(sql_C1, connection,
						new Object[] {});
				while (rst.next()) {
					String ps_code = rst.getString("PS_CODE");
					String ps_code_desc = rst.getString("PS_CODE_DESC");
					if (ps_code.equals((String) value)) {
						beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
								.setUI_M_BNF_DESC(ps_code_desc);
						M_FLAG = "Y";
						break;
					} else {
						M_FLAG = "N";
					}
				}
				if (M_FLAG.equals("N")) {
					throw new Exception(Messages.getString(
							"com.iii.premia.common.errorUtil.PELErrorMessages",
							"71253"));
				}
				/*changed by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
				if (((String) value).equals("A") && ((String) value).equals("S")) {
					// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CLAIM_BENEFICIARY.CBEN_RELATION_CODE",REQUIRED,PROPERTY_FALSE);
					/*added by gopi for hands on feed back points,serial no 12 in zb on 10/02/17*/
					beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN().setCBEN_RELATION_CODE("");
					beneficiaryAction.getCOMP_CBEN_RELATION_CODE().setRequired(false);
					/*end*/
				} else {
					/*added by gopi for hands on feed back points,serial no 12 in zb on 10/02/17*/
					beneficiaryAction.getCOMP_CBEN_RELATION_CODE().setRequired(true);
					/*end*/
					// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CLAIM_BENEFICIARY.CBEN_RELATION_CODE",REQUIRED,PROPERTY_TRUE);
				}
				/*added by gopi for hands on feed back points,serial no 12 in zb on 10/02/17*/
				/* Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				
				String cben_Type=value.toString();
				for(PT_IL_CLAIM_BENEFICIARY  bn: beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_LIST()) {
					if(!(bn.getCBEN_BNF_TYPE().equalsIgnoreCase(cben_Type)))
					{
						if((bn.getCBEN_BNF_TYPE().equalsIgnoreCase("S") || bn.getCBEN_BNF_TYPE().equalsIgnoreCase("A")))
						{
							if((cben_Type.equalsIgnoreCase("S") || cben_Type.equalsIgnoreCase("A")))
							{
								System.out.println("your beneficiary type is added");
							}
							else
							{
								throw new Exception("Cannot have Assignee and Nominee in a single policy");
							}
						}else
						{
							throw new Exception("Cannot have Assignee and Nominee in a single policy");
						}
					}
				}

				
				
				if(beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_BNF_TYPE().equalsIgnoreCase("A"))
				{
					beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN().setCBEN_PERC(100.0);	
				}
				else if(beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_BNF_TYPE().equalsIgnoreCase("S"))
				{
					beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN().setCBEN_PERC(0.0);
				}

				/*End*/
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} finally {
				try {
					if (rst != null) {
						CommonUtils.closeCursor(rst);
					}
				} catch (Exception e) {
				}
			}
		}
	}

	public void cbenCityCodeWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			Connection connection = CommonUtils.getConnection();
			PT_IL_CLAIM_BENEFICIARY_ACTION beneficiaryAction = compositeAction
					.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();

			String CODE_TYPE = beneficiaryAction
					.getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_CITY_CODE();
			String CODE_DESC = beneficiaryAction
					.getPT_IL_CLAIM_BENEFICIARY_BEAN().getUI_M_CBEN_CITY_DESC();
			CODE_DESC = new PILT007_PROCEDURE().P_VAL_CODES(connection, "CITY",
					CODE_TYPE, CODE_DESC, "N", "E", null);
			beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
					.setUI_M_CBEN_CITY_DESC(CODE_DESC);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void cbenFcPaidAmtWhenValidateItem(Double value,
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_BENEFICIARY_ACTION claimBenfAction = compositeAction
				.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();

		claimBenfAction.getPT_IL_CLAIM_BENEFICIARY_BEAN().setCBEN_FC_PAID_AMT(
				value);
		String CLAIM_CURR_CODE = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_CURR_CODE();
		String M_BASE_CURR = claimAction.getPT_IL_CLAIM_BEAN()
				.getUI_M_BASE_CURR();
		Double CLAIM_EXCH_RATE = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_EXCH_RATE();
		Double CBEN_FC_PAID_AMT = claimBenfAction
				.getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_FC_PAID_AMT();

		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ArrayList<String> roundAmtList = new PILT007_PROCEDURE()
					.callP_VAL_ROUND_AMT(connection, CLAIM_CURR_CODE,
							CBEN_FC_PAID_AMT, "V");
			String output = roundAmtList.get(0);
			CBEN_FC_PAID_AMT = new Double(output == null ? "0.0" : output);
			claimBenfAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
					.setCBEN_FC_PAID_AMT(CBEN_FC_PAID_AMT);
			Double CBEN_LC_PAID_AMT = CBEN_FC_PAID_AMT
					* (CLAIM_EXCH_RATE == null ? 0.0 : CLAIM_EXCH_RATE);
			roundAmtList = new PILT007_PROCEDURE().callP_VAL_ROUND_AMT(
					connection, M_BASE_CURR, CBEN_LC_PAID_AMT, "R");
			output = roundAmtList.get(0);
			CBEN_LC_PAID_AMT = new Double(output == null ? "0.0" : output);
			claimBenfAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
					.setCBEN_LC_PAID_AMT(CBEN_LC_PAID_AMT);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void cbenLcPaidAmtWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction, Double value)
			throws Exception {
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_BENEFICIARY_ACTION claimBenfAction = compositeAction
				.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();
		/*
		 * int rowIndex =
		 * claimBenfAction.getPT_IL_CLAIM_BENEFICIARY_DATATABLE().getRowIndex();
		 * PT_IL_CLAIM_BENEFICIARY beneficiaryBean =
		 * claimBenfAction.getPT_IL_CLAIM_BENEFICIARY_LIST().get(rowIndex);
		 */
		claimBenfAction.getPT_IL_CLAIM_BENEFICIARY_BEAN().setCBEN_LC_PAID_AMT(
				value);
		String M_BASE_CURR = claimAction.getPT_IL_CLAIM_BEAN()
				.getUI_M_BASE_CURR();
		Double CLAIM_EXCH_RATE = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_EXCH_RATE();
		Double CBEN_LC_PAID_AMT = claimBenfAction
				.getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_LC_PAID_AMT();
		Double CBEN_FC_PAID_AMT = claimBenfAction
				.getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_FC_PAID_AMT();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ArrayList<String> outputList = new PILT007_PROCEDURE()
					.callP_VAL_ROUND_AMT(connection, M_BASE_CURR,
							CBEN_LC_PAID_AMT, "V");
			String lcPaidAmt = outputList.get(0);
			CBEN_LC_PAID_AMT = new Double(lcPaidAmt == null ? "0.0" : lcPaidAmt);
			claimBenfAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
					.setCBEN_LC_PAID_AMT(CBEN_LC_PAID_AMT);
			new PILT007_PROCEDURE().callP_VAL_FC_LC_TOLERANCE(connection,
					CBEN_FC_PAID_AMT, CBEN_LC_PAID_AMT, CLAIM_EXCH_RATE, "E");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void cbenPercWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PT_IL_CLAIM_BENEFICIARY_ACTION beneficiaryAction = compositeAction
				.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();
		/*
		 * int rowIndex =
		 * beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_DATATABLE().getRowIndex();
		 * PT_IL_CLAIM_BENEFICIARY beneficiaryBean =
		 * beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_LIST().get(rowIndex);
		 */
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		String selectQuery = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY5;
		Long CBEN_CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_SYS_ID();
		System.out.println("CBEN_CP_SYS_ID:::::::::::::::" + CBEN_CLAIM_SYS_ID);
		CRUDHandler handler = new CRUDHandler();
		Double CP_FC_PAID_AMT = 0.0;
		Double CP_LC_PAID_AMT = 0.0;
		ResultSet rst = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { CBEN_CLAIM_SYS_ID });
			while (rst.next()) {
				CP_FC_PAID_AMT = rst.getDouble(1);
				CP_LC_PAID_AMT = rst.getDouble(2);
			}

			System.out.println("CP_FC_PAID_AMT:::::::::::" + CP_FC_PAID_AMT);
			System.out.println("CP_LC_PAID_AMT:::::::::::" + CP_LC_PAID_AMT);
			System.out.println((String) sessionMap.get("GLOBAL.M_BNF_VALUE"));
			System.out
					.println("claimAction.getPT_IL_CLAIM_BEAN().getUI_M_IL_BEN_VALUE()>>>>>>>>>>>>>"
							+ claimAction.getPT_IL_CLAIM_BEAN()
									.getUI_M_IL_BEN_VALUE());
			String M_BNF_VALUE = (String) sessionMap.get("GLOBAL.M_BNF_VALUE");
			Double M_IL_BEN_VALUE = claimAction.getPT_IL_CLAIM_BEAN()
					.getUI_M_IL_BEN_VALUE();
			if ((M_BNF_VALUE == null ? "1" : M_BNF_VALUE).equals("1")) {
				if (beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
						.getCBEN_PERC() != null
						&& (M_IL_BEN_VALUE == null ? 0.0 : M_IL_BEN_VALUE) == 0.0) {
					if (beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
							.getCBEN_PERC() < 0.0
							&& beneficiaryAction
									.getPT_IL_CLAIM_BENEFICIARY_BEAN()
									.getCBEN_PERC() > 100.0) {
						throw new Exception(
								Messages
										.getString(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"91014"));
					}
					Double CBEN_PERC = beneficiaryAction
							.getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_PERC();
					if (CBEN_PERC > 100.0) {
						throw new Exception(
								Messages
										.getString(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"91136"));
					}
					Double CBEN_FC_PAID_AMT = (CP_FC_PAID_AMT == null ? 0.0
							: CP_FC_PAID_AMT)
							* (CBEN_PERC == null ? 0.0 : CBEN_PERC) / 100;

					ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
					OracleParameter param1 = new OracleParameter("in1",
							"STRING", "IN", claimAction.getPT_IL_CLAIM_BEAN()
									.getCLAIM_CURR_CODE());
					OracleParameter param2 = new OracleParameter("inout1",
							"INTEGER", "IN OUT", CBEN_FC_PAID_AMT.toString());
					OracleParameter param3 = new OracleParameter("in2",
							"STRING", "IN", "R");
					parameterList.add(param1);
					parameterList.add(param2);
					parameterList.add(param3);
					OracleProcedureHandler procHandler = new OracleProcedureHandler();
					ArrayList<OracleParameter> paramOutput = null;
					paramOutput = procHandler.execute(parameterList,
							connection, "P_VAL_ROUND_AMT");

					OracleParameter outputParam = paramOutput.get(0);
					System.out
							.println("FC:::outputParam.getValue()::::::::::::::::::"
									+ outputParam.getValue());
					CBEN_FC_PAID_AMT = new Double(outputParam.getValue());
					beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
							.setCBEN_FC_PAID_AMT(CP_FC_PAID_AMT);
					beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
							.setCBEN_FC_PAID_AMT(CBEN_FC_PAID_AMT);
					Double M_CLAIM_EXCH_RATE = claimAction
							.getPT_IL_CLAIM_BEAN().getCLAIM_EXCH_RATE();
					System.out.println(beneficiaryAction
							.getPT_IL_CLAIM_BENEFICIARY_BEAN()
							.getCBEN_FC_PAID_AMT()
							* (M_CLAIM_EXCH_RATE == null ? 1.0
									: M_CLAIM_EXCH_RATE));
					beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
							.setCBEN_LC_PAID_AMT(CP_LC_PAID_AMT);
					beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
							.setCBEN_LC_PAID_AMT(
									beneficiaryAction
											.getPT_IL_CLAIM_BENEFICIARY_BEAN()
											.getCBEN_FC_PAID_AMT()
											* (M_CLAIM_EXCH_RATE == null ? 1.0
													: M_CLAIM_EXCH_RATE));
					System.out.println("M_BASE_CURR::::"
							+ claimAction.getPT_IL_CLAIM_BEAN()
									.getUI_M_BASE_CURR());
					parameterList = new ArrayList<OracleParameter>();
					param1 = new OracleParameter("in1", "STRING", "IN",
							claimAction.getPT_IL_CLAIM_BEAN()
									.getUI_M_BASE_CURR());
					param2 = new OracleParameter("inout1", "NUMBER", "IN OUT",
							beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
									.getCBEN_LC_PAID_AMT().toString());
					param3 = new OracleParameter("in2", "STRING", "IN", "R");
					parameterList.add(param1);
					parameterList.add(param2);
					parameterList.add(param3);

					procHandler = new OracleProcedureHandler();
					paramOutput = procHandler.execute(parameterList,
							connection, "P_VAL_ROUND_AMT");

					outputParam = paramOutput.get(0);
					System.out
							.println("LC::::outputParam.getValue()::::::::::::::::::"
									+ outputParam.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (rst != null) {
					CommonUtils.closeCursor(rst);
				}
			} catch (Exception e) {
			}
		}
	}

	public void cbenPostalCodeWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			Connection connection = CommonUtils.getConnection();
			PT_IL_CLAIM_BENEFICIARY_ACTION beneficiaryAction = compositeAction
					.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();

			String CBEN_POSTAL_CODE = beneficiaryAction
					.getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_POSTAL_CODE();
			String M_CBEN_POSTAL_CODE_DESC = beneficiaryAction
					.getPT_IL_CLAIM_BENEFICIARY_BEAN()
					.getUI_M_CBEN_POSTAL_CODE_DESC();
			M_CBEN_POSTAL_CODE_DESC = new PILT007_PROCEDURE().P_VAL_CODES(
					connection, "POSTAL", CBEN_POSTAL_CODE,
					M_CBEN_POSTAL_CODE_DESC, "N", "E", null);
			beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
					.setUI_M_CBEN_POSTAL_CODE_DESC(M_CBEN_POSTAL_CODE_DESC);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void cbenRelationCodeWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM_BENEFICIARY_ACTION beneficiaryAction = compositeAction
				.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();
		UIData PT_IL_CLAIM_BENEFICIARY_DATATABLE = beneficiaryAction
				.getPT_IL_CLAIM_BENEFICIARY_DATATABLE();
		List<PT_IL_CLAIM_BENEFICIARY> PT_IL_CLAIM_BENEFICIARY_LIST = beneficiaryAction
				.getPT_IL_CLAIM_BENEFICIARY_LIST();

		String query = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY6;
		CRUDHandler handler = new CRUDHandler();
		String PC_CODE = null;
		String PC_DESC = null;
		ResultSet rst = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(query, connection,
					new Object[] {
							"ILBENFREL",
							beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
									.getCBEN_RELATION_CODE() });
			while (rst.next()) {
				PC_CODE = rst.getString("PC_CODE");
				PC_DESC = rst.getString("PC_DESC");
			}

			System.out.println(PC_CODE + "   " + PC_DESC);
			if (PC_CODE == null && PC_DESC == null) {
				// throw exeception
				String CBEN_RELATION_CODE = beneficiaryAction
						.getPT_IL_CLAIM_BENEFICIARY_BEAN()
						.getCBEN_RELATION_CODE();
				if (!(CBEN_RELATION_CODE == null ? "" : CBEN_RELATION_CODE)
						.equals("S")) {
					throw new Exception(Messages.getString(
							"com.iii.premia.common.errorUtil.PELErrorMessages",
							"71254"));
				}
			} else {
				// beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN().setUI_M_CBEN_RELATION_DESC(PC_DESC);
				beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
						.setUI_M_CBEN_RELATION_DESC(PC_DESC);
				beneficiaryAction.getCOMP_UI_M_CBEN_RELATION_DESC()
						.setSubmittedValue(PC_DESC);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (rst != null) {
					CommonUtils.closeCursor(rst);
				}
			} catch (Exception e) {
			}
		}
	}

	public void cbenStatCodeWhenValidateItem(
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			Connection connection = CommonUtils.getConnection();
			PT_IL_CLAIM_BENEFICIARY_ACTION beneficiaryAction = compositeAction
					.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();

			String CBEN_STAT_CODE = beneficiaryAction
					.getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_STAT_CODE();
			String M_CBEN_STAT_CODE_DESC = beneficiaryAction
					.getPT_IL_CLAIM_BENEFICIARY_BEAN()
					.getUI_M_CBEN_STAT_CODE_DESC();
			if (CBEN_STAT_CODE != null) {
				M_CBEN_STAT_CODE_DESC = new PILT007_PROCEDURE().P_VAL_CODES(
						connection, "STATE", CBEN_STAT_CODE,
						M_CBEN_STAT_CODE_DESC, "N", "E", null);
				beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
						.setUI_M_CBEN_STAT_CODE_DESC(M_CBEN_STAT_CODE_DESC);
			} else {
				beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN()
						.setUI_M_CBEN_STAT_CODE_DESC(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public PT_IL_CLAIM_BENEFICIARY postQuery(
			PT_IL_CLAIM_BENEFICIARY beneficiaryBean,
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY7;
		String query = "SELECT PMD_BANK_NAME  FROM PM_BANK_DTLS WHERE PMD_BANK_CODE = ?";
		String query1 = "SELECT PMD_BRANCH_NAME  FROM PM_BANK_DTLS WHERE PMD_BRANCH_CODE = ?  "
				+ " AND PMD_BANK_CODE = ? AND PMD_CITY_CODE = ?  ";
		String query2 ="SELECT PMD_CITY_DESC  FROM PM_BANK_DTLS WHERE PMD_CITY_CODE = ? ";
		// ControlBean controlBean = getCtrlBean();
		String langCode = CommonUtils.getControlBean().getM_LANG_CODE();
		// String langCode = controlBean.getM_LANG_CODE();
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		String bankCode = beneficiaryBean.getCBEN_BANK_CODE();
		Object[] values = { langCode, bankCode };
		PILT007_PROCEDURE procedureHelper = new PILT007_PROCEDURE();
		CRUDHandler handler = new CRUDHandler();
		String M_CBEN_BANK_CODE_DESC = null;
		String M_CBEN_BRANCH_DESC = null;
		Connection connection = null;
		Double M_VALUE= null;
		Double M_VAL= null;
		 ArrayList<String> list1=null;
		 ArrayList<String> list2=null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { beneficiaryBean.getCBEN_BANK_CODE() });
			while (rst.next()) {
				M_CBEN_BANK_CODE_DESC = rst.getString(1);
			}
			rst.close();
			beneficiaryBean.setUI_M_CBEN_BANK_CODE_DESC(M_CBEN_BANK_CODE_DESC);

			ResultSet rst1 = handler.executeSelectStatement(query1, connection,
					new Object[] {beneficiaryBean.getCBEN_DIVN_CODE(), beneficiaryBean.getCBEN_BANK_CODE(),
							beneficiaryBean.getCBEN_CITY_CODE()});
			while (rst1.next()) {
				M_CBEN_BRANCH_DESC = rst1.getString(1);

			}rst.close();
			beneficiaryBean.setUI_M_CBEN_DIVN_CODE(M_CBEN_BRANCH_DESC);
			String CBEN_RELATION_CODE = beneficiaryBean.getCBEN_RELATION_CODE();
			String M_CBEN_RELATION_DESC = beneficiaryBean
					.getUI_M_CBEN_RELATION_DESC();
			String CBEN_BNF_TYPE = beneficiaryBean.getCBEN_BNF_TYPE();
			String M_BNF_DESC = beneficiaryBean.getUI_M_BNF_DESC();
			String CBEN_STAT_CODE = beneficiaryBean.getCBEN_STAT_CODE();
			String M_CBEN_STAT_CODE_DESC = beneficiaryBean
					.getUI_M_CBEN_STAT_CODE_DESC();
			String CBEN_POSTAL_CODE = beneficiaryBean.getCBEN_POSTAL_CODE();
			String M_CBEN_POSTAL_CODE_DESC = beneficiaryBean
					.getUI_M_CBEN_POSTAL_CODE_DESC();
			String CBEN_CITY_CODE = beneficiaryBean.getCBEN_CITY_CODE();
			String M_CBEN_CITY_DESC = beneficiaryBean.getUI_M_CBEN_CITY_DESC();

			M_CBEN_RELATION_DESC = procedureHelper.P_VAL_CODES(connection,
					"ILBENFREL", CBEN_RELATION_CODE, M_CBEN_RELATION_DESC, "N",
					"N", null);
			beneficiaryBean.setUI_M_CBEN_RELATION_DESC(M_CBEN_RELATION_DESC);

			/*M_BNF_DESC = procedureHelper.P_VAL_SYSTEM(connection, "ILBENFTYPE",
					CBEN_BNF_TYPE, "N", claimAction.getPT_IL_CLAIM_BEAN()
							.getUI_M_PS_VALUE());*/
			
			/* if condition added by raja on 08-03-2017 for onload error message*/
			if(CBEN_BNF_TYPE!=null)
			{
				
			list2 = DBProcedures.P_VAL_SYSTEM("ILBENFTYPE",
					CBEN_BNF_TYPE, beneficiaryBean.getUI_M_BNF_DESC(),"E", CommonUtils.getProcedureValue(M_VAL));
			if (list2 != null && !list2.isEmpty()) {
				if (list2.get(0) != null) {
					beneficiaryBean.setUI_M_BNF_DESC(list2.get(0));
				}
				if (list2.get(1) != null) {
					M_VAL = Double.parseDouble(list2.get(1));
				}
			}
			}
			
			/*end*/
			//beneficiaryBean.setUI_M_BNF_DESC(M_BNF_DESC);
			if (beneficiaryBean.getCBEN_CATG_CODE() != null) {
				list1 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
						.getCBEN_CATG_CODE(), beneficiaryBean
						.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						beneficiaryBean.setUI_M_CATG_DESC(list1.get(0));
					}
					if (list1.get(1) != null) {
						M_VALUE = Double.parseDouble(list1.get(1));
					}
				}
			}
			M_CBEN_STAT_CODE_DESC = procedureHelper.P_VAL_CODES(connection,
					"STATE", CBEN_STAT_CODE, M_CBEN_STAT_CODE_DESC, "N", "N",
					null);
			beneficiaryBean.setUI_M_CBEN_STAT_CODE_DESC(M_CBEN_STAT_CODE_DESC);

			M_CBEN_POSTAL_CODE_DESC = procedureHelper.P_VAL_CODES(connection,
					"POSTAL", CBEN_POSTAL_CODE, M_CBEN_POSTAL_CODE_DESC, "N",
					"N", null);
			beneficiaryBean
					.setUI_M_CBEN_POSTAL_CODE_DESC(M_CBEN_POSTAL_CODE_DESC);
ResultSet rst2 = handler.executeSelectStatement(query2, connection, new Object[]{beneficiaryBean.getCBEN_CITY_CODE()});
while(rst2.next()){
	M_CBEN_CITY_DESC =rst2.getString(1);
}

beneficiaryBean.setUI_M_CBEN_CITY_DESC(M_CBEN_CITY_DESC);
			 
				/*procedureHelper.P_VAL_CODES(connection, "CITY",
					CBEN_CITY_CODE, M_CBEN_CITY_DESC, "N", "N", null);*/

			return beneficiaryBean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preInsert(PT_IL_CLAIM_BENEFICIARY claimBeneficiaryBean,
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY8;
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		CRUDHandler handler = new CRUDHandler();
		Long cbenSysId = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(sql_C1, connection);
			while (rst.next()) {
				cbenSysId = rst.getLong(1);
			}

			String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY9;
			Object[] values = {
					claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID(),
					"1" };
			handler = new CRUDHandler();
			Long pbenSysId = null;
			rst1 = handler.executeSelectStatement(sql_C2, connection, values);
			while (rst1.next()) {
				pbenSysId = rst1.getLong("PBEN_SYS_ID");
			}
			String userId = getCtrlBean().getM_USER_ID();
			Map<String, Object> sessionMap = new CommonUtils().getSessionMap();
			String M_BNF_VALUE = (String) sessionMap.get("GLOBAL.M_BNF_VALUE");
			if ((M_BNF_VALUE == null ? "1" : M_BNF_VALUE).equals("1")) {
				claimBeneficiaryBean.setCBEN_CLAIM_SYS_ID(claimAction
						.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
				claimBeneficiaryBean.setCBEN_SYS_ID(cbenSysId);
				claimBeneficiaryBean.setCBEN_PBEN_SYS_ID(pbenSysId);
				claimBeneficiaryBean.setCBEN_CP_SYS_ID(compositeAction
						.getPILT007_PT_IL_CLAIM_PAID_ACTION()
						.getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID());
				claimBeneficiaryBean.setCBEN_CR_UID(userId);
				claimBeneficiaryBean.setCBEN_CR_DT(new Date(Calendar
						.getInstance().getTimeInMillis()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (rst != null) {
					CommonUtils.closeCursor(rst);
				}
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void preUpdate(PT_IL_CLAIM_BENEFICIARY claimBeneficiaryBean,
			PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY8;
		CRUDHandler handler = new CRUDHandler();
		Long claimSysId = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(sql_C1, connection);
			while (rst.next()) {
				claimSysId = rst.getLong(1);
			}

			String sql_C2 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY9;
			Object[] values = {
					compositeAction.getPILT007_PT_IL_CLAIM_ACTION()
							.getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID(), "1" };
			handler = new CRUDHandler();
			Long pbenSysId = null;
			rst1 = handler.executeSelectStatement(sql_C2, connection, values);
			while (rst1.next()) {
				pbenSysId = rst1.getLong("PBEN_SYS_ID");
			}
			String userId = getCtrlBean().getM_USER_ID();

			Map<String, Object> sessionMap = new CommonUtils().getSessionMap();
			String M_BNF_VALUE = (String) sessionMap.get("GLOBAL.M_BNF_VALUE");
			if ((M_BNF_VALUE == null ? "1" : M_BNF_VALUE).equals("1")) {
				// claimBeneficiaryBean.setCBEN_CLAIM_SYS_ID(claimSysId);
				claimBeneficiaryBean.setCBEN_PBEN_SYS_ID(pbenSysId);
				claimBeneficiaryBean.setCBEN_UPD_UID(userId);
				claimBeneficiaryBean.setCBEN_UPD_DT(new Date(Calendar
						.getInstance().getTimeInMillis()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (rst != null) {
					CommonUtils.closeCursor(rst);
				}
				if (rst1 != null) {
					CommonUtils.closeCursor(rst1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public PT_IL_CLAIM_BENEFICIARY whenCreateRecord(
			PILT007_COMPOSITE_ACTION compositeAction) {
		/*added by gopi for hands on feed back points,serial no 12 in zb on 10/02/17*/
		PT_IL_CLAIM_BENEFICIARY beneficiaryBean = compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN();
		//end
		PT_IL_CLAIM_PAID_ACTION paidAction = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION();
		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();

		Map<String, Object> sessionMap = new CommonUtils().getSessionMap();
		String M_BNF_VALUE = (String) sessionMap.get("GLOBAL.M_BNF_VALUE");
		System.out.println("M_BNF_VALUE:::::::::::::::::::" + M_BNF_VALUE);
		if ((M_BNF_VALUE == null ? "0" : M_BNF_VALUE).equals("1")) {
			beneficiaryBean.setCBEN_CLAIM_SYS_ID(claimAction
					.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
			beneficiaryBean.setCBEN_CP_SYS_ID(paidAction
					.getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID());
			ControlBean controlBean = getCtrlBean();
			beneficiaryBean.setCBEN_CR_UID(controlBean.getM_USER_ID());
			beneficiaryBean.setCBEN_CR_DT(new Date(Calendar.getInstance()
					.getTimeInMillis()));
		}
		return beneficiaryBean;
	}
	
	/*added by sankara narayanan for ZBILQC-1721754 on 09-03-2017*/
	public void executeselectstatement(PILT007_COMPOSITE_ACTION compositeAction)
	{
		try{
			
				
		new PT_IL_CLAIM_BENEFICIARY_DELEGALTE().executeQuery(compositeAction);

		if (compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
				.getPT_IL_CLAIM_BENEFICIARY_LIST().size() > 0) {
			compositeAction
					.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
					.setPT_IL_CLAIM_BENEFICIARY_BEAN(
							compositeAction
									.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
									.getPT_IL_CLAIM_BENEFICIARY_LIST().get(0));
			compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
					.getPT_IL_CLAIM_BENEFICIARY_BEAN().setRowSelected(true);
			
			
			
			
			
			
			
			Map<String, Object> sessionMap = new CommonUtils().getSessionMap();
			String M_BNF_VALUE = (String) sessionMap.get("GLOBAL.M_BNF_VALUE");
			// String M_BNF_VALUE =
			// claimAction.getPT_IL_CLAIM_BEAN().getUI_M_BNF_VALUE();
			String BNF_TYPE =compositeAction
			.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
			.getPT_IL_CLAIM_BENEFICIARY_LIST().get(0).getCBEN_BNF_TYPE();
			
			if ((M_BNF_VALUE == null ? "1" : M_BNF_VALUE).equals("2")) {
				// update/insert false
			} else if ((M_BNF_VALUE == null ? "1" : M_BNF_VALUE).equals("1")) {
				if ((BNF_TYPE == null ? "N" : BNF_TYPE).equals("A")) {
					compositeAction
					.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_BANK_CODE()
							.setRequired(true);
				} else {
					compositeAction
					.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_BANK_CODE().setRequired(
							false);
				}
			}
			
			
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//end

	/*
	 * 
	 * commented  by sankara narayanan this functionality already handled in Executeselect statement on 09-03-2017
	 * 
	 * 
	 * public void whenNewBlockInstance(PILT007_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PT_IL_CLAIM_ACTION claimAction = compositeAction
				.getPILT007_PT_IL_CLAIM_ACTION();
		PT_IL_CLAIM_BENEFICIARY_ACTION beneficiaryAction = compositeAction
				.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION();
		String sql_C1 = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY11;
		Long CLAIM_SYS_ID = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID();
		Long CLAIM_PAID_SYS_ID = compositeAction
				.getPILT007_PT_IL_CLAIM_PAID_ACTION()
				.getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID();
		CRUDHandler handler = new CRUDHandler();
		executeQuery(compositeAction);
		
		 * claimBeneficiaryAction
		 * .setPT_IL_CLAIM_BENEFICIARY_LIST(beneficiaryList);
		 
		if (compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
				.getPT_IL_CLAIM_BENEFICIARY_LIST().size() > 0) {
			compositeAction
					.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
					.setPT_IL_CLAIM_BENEFICIARY_BEAN(
							compositeAction
									.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
									.getPT_IL_CLAIM_BENEFICIARY_LIST().get(0));
			compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
					.getPT_IL_CLAIM_BENEFICIARY_BEAN().setRowSelected(true);
		}
		postQuery(beneficiaryAction.getPT_IL_CLAIM_BENEFICIARY_BEAN(),
				compositeAction);
		String PLAN_TYPE = null;
		ResultSet rst = null;

		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			rst = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { CLAIM_SYS_ID  , CLAIM_PAID_SYS_ID });
			while (rst.next()) {
				PLAN_TYPE = rst.getString(1);
			}

			Map<String, Object> sessionMap = new CommonUtils().getSessionMap();
			String M_BNF_VALUE = (String) sessionMap.get("GLOBAL.M_BNF_VALUE");
			// String M_BNF_VALUE =
			// claimAction.getPT_IL_CLAIM_BEAN().getUI_M_BNF_VALUE();
			if ((M_BNF_VALUE == null ? "1" : M_BNF_VALUE).equals("2")) {
				// update/insert false
			} else if ((M_BNF_VALUE == null ? "1" : M_BNF_VALUE).equals("1")) {
				if ((PLAN_TYPE == null ? "N" : PLAN_TYPE).equals("M")) {
					beneficiaryAction.getCOMP_CBEN_BANK_CODE()
							.setRequired(true);
				} else {
					beneficiaryAction.getCOMP_CBEN_BANK_CODE().setRequired(
							false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (rst != null) {
					CommonUtils.closeCursor(rst);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
*/
	public boolean checkingBeneficiaryinTx(String claim_pol_no)
			throws Exception {
		String selectQuery = "SELECT 'X' " + "FROM PT_IL_POL_BENEFICIARY "
				+ "WHERE PBEN_POL_SYS_ID IN " + "(SELECT CLAIM_POL_SYS_ID "
				+ "FROM PT_IL_CLAIM " + "WHERE CLAIM_POL_NO = ?)";

		boolean chkFlag = false;
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con,
					new Object[] { claim_pol_no });
			if (rs.next()) {
				chkFlag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return chkFlag;

	}

	public void validateBeneficiaryPerc(PT_IL_CLAIM_BENEFICIARY_ACTION action)
			throws Exception {
		String query = "SELECT SUM(CBEN_PERC) FROM PT_IL_CLAIM_BENEFICIARY WHERE "
				+ "CBEN_CLAIM_SYS_ID=? AND CBEN_CP_SYS_ID=?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Double claimPerc = 0.0;
		PT_IL_CLAIM_BENEFICIARY PT_IL_CLAIM_BENEFICIARY_BEAN = action
				.getPT_IL_CLAIM_BENEFICIARY_BEAN();

		try {
			/*
			 * con = CommonUtils.getConnection();
			 * 
			 * rs = handler.executeSelectStatement(query, con, new Object[] {
			 * PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_CLAIM_SYS_ID(),
			 * PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_CP_SYS_ID() });
			 */
			/*for (PT_IL_CLAIM_BENEFICIARY bean : action
					.getPT_IL_CLAIM_BENEFICIARY_LIST()) {
				claimPerc = claimPerc + bean.getCBEN_PERC();
			}*/
			
			/*changed by raja 24-06-2017 for hands on points*/
			
			/*Commentted &Modified by saritha on 03-01-2017 for ssp call id : ZBLIFE-1464092*/
			
			//String Query="SELECT SUM(CBEN_PERC) FROM PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CLAIM_SYS_ID=?";
			String Query="SELECT SUM(CBEN_PERC) FROM PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CP_SYS_ID=?";
			
			ResultSet rs1=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_CP_SYS_ID()});
			
			/*End*/
			
			while(rs1.next())
			{
				claimPerc=rs1.getDouble(1);
			}
			if(claimPerc!=100)
			{
				throw new Exception("Total Beneficiary share percentage should be equal to 100");
			}

			/*end*/

			if (claimPerc != 100) {
				throw new Exception(
						"Total Beneficiary share percentage should be equal to 100");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validateBeneficiaryPerc1(PT_IL_CLAIM_BENEFICIARY_ACTION action)
			throws Exception {
		String query = "SELECT SUM(CBEN_PERC) FROM PT_IL_CLAIM_BENEFICIARY WHERE "
				+ "CBEN_CLAIM_SYS_ID=? AND CBEN_CP_SYS_ID=?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Double claimPerc = 0.0;
		PT_IL_CLAIM_BENEFICIARY PT_IL_CLAIM_BENEFICIARY_BEAN = action
				.getPT_IL_CLAIM_BENEFICIARY_BEAN();

		try {
			/*
			 * con = CommonUtils.getConnection(); rs =
			 * handler.executeSelectStatement(query, con, new Object[] {
			 * PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_CLAIM_SYS_ID(),
			 * PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_CP_SYS_ID() }); if
			 * (rs.next()) { claimPerc = rs.getDouble(1); }
			 */
			for (PT_IL_CLAIM_BENEFICIARY bean : action
					.getPT_IL_CLAIM_BENEFICIARY_LIST()) {
				claimPerc = claimPerc + bean.getCBEN_PERC();
			}
			/*commented by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
			/*if (claimPerc == 100) {
				throw new Exception(
						"You cannot create records! The total Claim Perc. should be equal to 100%");
			}*/
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

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
			ResultSet rst = handler.executeSelectStatement(queryString,
					connection, new Object[] { CLAIM_SYS_ID /* , CP_SYS_ID */});
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
				// beneficiaryBean = postQuery(beneficiaryBean,
				// compositeAction);
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

	public List<PT_IL_CLAIM_BENEFICIARY> bankCodeLOV(String value)
			throws Exception {
		if (value != null) {
			if (value.equals("*")) {
				value = "%";
			} else {
				value += "%";
			}
		}
		String query = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY12;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM_BENEFICIARY> bankCodeList = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { value });
			PT_IL_CLAIM_BENEFICIARY beneficiaryBean = null;
			bankCodeList = new ArrayList<PT_IL_CLAIM_BENEFICIARY>();
			while (rst.next()) {
				beneficiaryBean = new PT_IL_CLAIM_BENEFICIARY();
				beneficiaryBean.setCBEN_BANK_CODE(rst.getString("BANK_CODE"));
				beneficiaryBean.setUI_M_CBEN_CITY_DESC(rst
						.getString("BANK_NAME"));
				bankCodeList.add(beneficiaryBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return bankCodeList;
	}

	public List<PT_IL_CLAIM_BENEFICIARY> bnfTypeLOV(String value)
			throws Exception {
		if (value != null) {
			if (value.equals("*")) {
				value = "%";
			} else {
				value += "%";
			}
		}
		String query = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY13;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM_BENEFICIARY> beneficiaryList = new ArrayList<PT_IL_CLAIM_BENEFICIARY>();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { value });
			PT_IL_CLAIM_BENEFICIARY beneficiaryBean = null;
			while (rst.next()) {
				beneficiaryBean = new PT_IL_CLAIM_BENEFICIARY();
				beneficiaryBean.setCBEN_BNF_TYPE(rst.getString("PS_CODE"));
				beneficiaryBean.setUI_M_BNF_DESC(rst.getString("PS_CODE_DESC"));
				beneficiaryList.add(beneficiaryBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return beneficiaryList;
	}

	public List<PT_IL_CLAIM_BENEFICIARY> cityCodeLOV(String value)
			throws Exception {
		if (value != null) {
			if (value.equals("*")) {
				value = "%";
			} else {
				value += "%";
			}
		}
		String query = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY14;
		List<PT_IL_CLAIM_BENEFICIARY> beneficiaryList = new ArrayList<PT_IL_CLAIM_BENEFICIARY>();
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { value });
			PT_IL_CLAIM_BENEFICIARY beneficiaryBean = null;
			while (rst.next()) {
				beneficiaryBean = new PT_IL_CLAIM_BENEFICIARY();
				beneficiaryBean.setCBEN_CITY_CODE(rst.getString("PC_CODE"));
				beneficiaryBean
						.setUI_M_CBEN_CITY_DESC(rst.getString("PC_DESC"));
				beneficiaryList.add(beneficiaryBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return beneficiaryList;
	}

	public List<PT_IL_CLAIM_BENEFICIARY> postalCodeLOV(String value)
			throws Exception {
		if (value != null) {
			if (value.equals("*")) {
				value = "%";
			} else {
				value += "%";
			}
		}
		String query = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY15;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM_BENEFICIARY> beneficiaryList = new ArrayList<PT_IL_CLAIM_BENEFICIARY>();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { value });
			PT_IL_CLAIM_BENEFICIARY beneficiaryBean = null;
			while (rst.next()) {
				beneficiaryBean = new PT_IL_CLAIM_BENEFICIARY();
				beneficiaryBean.setCBEN_POSTAL_CODE(rst.getString("PC_CODE"));
				beneficiaryBean.setUI_M_CBEN_POSTAL_CODE_DESC(rst
						.getString("PC_DESC"));
				beneficiaryList.add(beneficiaryBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return beneficiaryList;
	}

	public List<PT_IL_CLAIM_BENEFICIARY> relationCodeLOV(String value)
			throws Exception {
		if (value != null) {
			if (value.equals("*")) {
				value = "%";
			} else {
				value += "%";
			}
		}
		String query = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY16;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM_BENEFICIARY> beneficiaryList = new ArrayList<PT_IL_CLAIM_BENEFICIARY>();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { value });
			PT_IL_CLAIM_BENEFICIARY beneficiaryBean = null;
			while (rst.next()) {
				beneficiaryBean = new PT_IL_CLAIM_BENEFICIARY();
				beneficiaryBean.setCBEN_RELATION_CODE(rst.getString("PC_CODE"));
				beneficiaryBean.setUI_M_CBEN_RELATION_DESC(rst
						.getString("PC_DESC"));
				beneficiaryList.add(beneficiaryBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return beneficiaryList;
	}

	public List<PT_IL_CLAIM_BENEFICIARY> statCodeLOV(String value)
			throws Exception {
		if (value != null) {
			if (value.equals("*")) {
				value = "%";
			} else {
				value += "%";
			}
		}
		String query = PILT007_SQL_QUERY_CONSTANTS.SWISS_SQL_CLAIM_BENEFICIARY_QUERY17;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM_BENEFICIARY> beneficiaryList = new ArrayList<PT_IL_CLAIM_BENEFICIARY>();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { value });
			PT_IL_CLAIM_BENEFICIARY beneficiaryBean = null;
			while (rst.next()) {
				beneficiaryBean = new PT_IL_CLAIM_BENEFICIARY();
				beneficiaryBean.setCBEN_STAT_CODE(rst.getString("PC_CODE"));
				beneficiaryBean.setUI_M_CBEN_STAT_CODE_DESC(rst
						.getString("PC_DESC"));
				beneficiaryList.add(beneficiaryBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return beneficiaryList;
	}

	public int saveRecord(PT_IL_CLAIM_BENEFICIARY beneficiaryBean)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		int result = 0;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			result = handler.executeInsert(beneficiaryBean, connection);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return result;
	}
	
	/*added by gopi for hands on feed back points,serial no 12 in zb on 03/02/17*/
	public void PBEN_REF_ID1_WHEN_VALIDATE_ITEM(
			PILT007_COMPOSITE_ACTION compositeAction,PT_IL_CLAIM_BENEFICIARY beneficiaryBean) throws Exception {
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
		Integer M_REF_ID_1_LENGTH =compositeAction
				.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_REF_ID1()
				.getMaxlength();
		String M_CODE_DESC = null;
		Double M_PS_VALUE = null;
		String CURSOR_C1 = "SELECT  COUNT(PBEN_SYS_ID) FROM PT_IL_POL_BENEFICIARY WHERE PBEN_POL_SYS_ID = ? ";
		String CURSOR_C2 = "SELECT SUBSTR(M_CUST_REF_ID1,1,6) FROM   DUAL";

		
		String PROD_AGE_CALC_FLAG =validateProd_code(compositeAction);
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<OracleParameter> list2 = null;
		ArrayList<String> list3 = null;
		DBProcedures procedures = new DBProcedures();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		try {
			connection = CommonUtils.getConnection();


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


			if(M_PS_VALUE == 1)
			{
				if (beneficiaryBean.getCBEN_REF_ID1().length() != M_LENGTH_1) {
					/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
					throw new Exception("Citizen ID No should have exactly 12 digits");
					/*End*/
				}
			}
			else
			{
				M_EXIST = "Y";
			}
			/* changed by R. Raja on 08-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee
for(PT_IL_POL_BENEFICIARY  bn: compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getDataList_PT_IL_POL_BENEFICIARY()) {
	if((bn.getPBEN_REF_ID1().equalsIgnoreCase(beneficiaryBean.getPBEN_REF_ID1())))
	{
		throw new Exception("Customer could used be already");
	}
}
End*//*
			System.out.println("M_EXIST      "+M_EXIST);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getDouble(1);
			}
			CommonUtils.closeCursor(resultSet);*/
			/*list1 = DBProcedures.P_VAL_SYSTEM("CUSTREFFMT", "CUSTREFFMT",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_PS_VALUE));
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					M_CODE_DESC = list1.get(0);
				}
				if (list1.get(1) != null) {
					M_PS_VALUE = Double.parseDouble(list1.get(1));
				}
			}*/
		/*	if (M_PS_VALUE == 1 && (CommonUtils.nvl(M_EXIST, "N") != "Y"
					&& "1".equals(policyBean.getPOL_DS_TYPE())
					|| ("2".equals(policyBean.getPOL_DS_TYPE()) || policyBean
							.getPOL_END_NO_IDX() == 0)
							|| "011".equals(policyBean.getPOL_END_TYPE())
							|| "001".equals(policyBean.getPOL_END_TYPE()))) {
				// we used direct java method to find substring
*/			
			
			
			if(M_PS_VALUE==1)
			{
			M_DATE_CHAR = beneficiaryBean.getCBEN_REF_ID1().substring(0,6);
				//M_TEMP_DATE = CommonUtils.stringToPelUtilDate(M_DATE_CHAR);
				M_TEMP_DATE = getFormattedDateFmIcNo(M_DATE_CHAR);
				if (CommonUtils.getYearFromDate(M_TEMP_DATE) > CommonUtils
						.getYearFromDate(new CommonUtils().getCurrentDate())) {
					M_TEMP_DATE =CommonUtils.addMonthsToDate(M_TEMP_DATE,-1200);
				}
				list2 = localProcedure.P_CALC_ANB(
						new CommonUtils().getCurrentDate(), 
						M_TEMP_DATE,
						PROD_AGE_CALC_FLAG, 
						beneficiaryBean.getCBEN_AGE());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0).getValueObject() != null) {
						beneficiaryBean.setCBEN_AGE((Integer)list2.get(0).getValueObject());
					}
				}
				M_GENDER = Integer.parseInt(beneficiaryBean.getCBEN_REF_ID1().substring(beneficiaryBean.getCBEN_REF_ID1().length()-1));
				if (M_GENDER % 2 == 0) {
					beneficiaryBean.setCBEN_CATG_CODE("2");
				} else if (M_GENDER % 2 > 0) {
					beneficiaryBean.setCBEN_CATG_CODE("1");
				}
				if (beneficiaryBean.getCBEN_CATG_CODE() != null) {
					list3 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
							.getCBEN_CATG_CODE(), beneficiaryBean
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
			}
				/*localProcedure.IL_GET_BENEF_DTL_ID(beneficiaryBean
						.getCBEN_REF_ID1(), beneficiaryBean.getCBEN_REF_ID2(),
						beneficiaryBean);*/
			
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			ArrayList<String> listcity = null;
			ArrayList<String> listbank = null;
			boolean flag=false;
			String query="SELECT * FROM PM_CUSTOMER WHERE CUST_REF_ID1=?";
			ResultSet resultsetcustomer=new CRUDHandler().executeSelectStatement(
					query, connection,  new Object[]{beneficiaryBean.getCBEN_REF_ID1()});
			while(resultsetcustomer.next())
			{
				flag=true;
				beneficiaryBean.setCBEN_BNF_NAME(resultsetcustomer.getString("CUST_NAME"));
				beneficiaryBean.setCBEN_BNF_CODE(resultsetcustomer.getString("CUST_CODE"));
				/*added by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
				
				beneficiaryBean.setCBEN_DOB(resultsetcustomer.getDate("CUST_DOB"));
				beneficiaryBean.setCBEN_CATG_CODE(resultsetcustomer.getString("CUST_CATG_CODE"));
				/*end*/
				//beneficiaryBean.setCBEN_ADDRESS_1(resultsetcustomer.getString("CUST_ADDR1"));
				//beneficiaryBean.setCBEN_ADDRESS_2(resultsetcustomer.getString("CUST_ADDR2"));
				//beneficiaryBean.setCBEN_ADDRESS_3(resultsetcustomer.getString("CUST_ADDR3"));
				//beneficiaryBean.setCBEN_CITY_CODE(resultsetcustomer.getString("CUST_CITY_CODE"));
				
				/*commented by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
				//beneficiaryBean.setCBEN_BANK_CODE(resultsetcustomer.getString("CUST_BANK_CODE"));
				//beneficiaryBean.setCBEN_ACCT_CODE(resultsetcustomer.getString("CUST_BANK_AC_NO"));
			//	beneficiaryBean.setCBEN_DIVN_CODE(null);
				/*end*/
				//beneficiaryBean.setCBEN_ADDRESS_4(null);
				//beneficiaryBean.setCBEN_ADDRESS_5(null);
				
			/*	if(beneficiaryBean.getCBEN_CITY_CODE()!=null)
				{
					listcity = procedures.P_VAL_CODES("CITY", beneficiaryBean
							.getCBEN_CITY_CODE(), beneficiaryBean
							.getUI_M_CBEN_CITY_DESC(), "N", "N", null);

					if(!listcity.isEmpty() && listcity.get(0)!=null )
						beneficiaryBean.setUI_M_CITY_CODE_DESC(listcity.get(0));
				}
				else
				{
					beneficiaryBean.setUI_M_CITY_CODE_DESC(null);
				}*/

				if(beneficiaryBean.getCBEN_BANK_CODE()!=null)
				{
					listbank = procedures.L_CHK_BANK(beneficiaryBean
							.getCBEN_BANK_CODE(), null,null);

					if(!listbank.isEmpty() && listbank.get(0)!=null )
						beneficiaryBean.setUI_M_CBEN_BANK_CODE_DESC(listbank.get(0));
				}
				else
				{
					beneficiaryBean.setUI_M_CBEN_BANK_CODE_DESC(null);
					beneficiaryBean.setCBEN_DIVN_CODE(null);
				}
				if(beneficiaryBean.getCBEN_BNF_TYPE().equalsIgnoreCase("N"))
				{
					beneficiaryBean.setCBEN_DOB(resultsetcustomer.getDate("CUST_DOB"));
				}
				else
				{
					beneficiaryBean.setCBEN_DOB(null);
					
				}
			}
			if(flag==false)
			{
				throw new Exception("   It not a valid Cititzen id");
			}
			/*end*/
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/		

			if(beneficiaryBean.getCBEN_DOB()!=null)
			{
				list2 = localProcedure.P_CALC_ANB(
						new CommonUtils().getCurrentDate(),
						
						/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/		
						beneficiaryBean.getCBEN_DOB(),
						/* end*/	
						
						PROD_AGE_CALC_FLAG, 
						beneficiaryBean.getCBEN_AGE());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0).getValueObject() != null) {
						beneficiaryBean.setCBEN_AGE((Integer)list2.get(0).getValueObject());
					}
				}
			}
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/		
			else
			{
				beneficiaryBean.setCBEN_AGE(null);
			}
		
			/*added by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
			/*	M_GENDER = Integer.parseInt(beneficiaryBean.getCBEN_REF_ID1().substring(beneficiaryBean.getCBEN_REF_ID1().length()-1));
			if (M_GENDER % 2 == 0) {
				beneficiaryBean.setCBEN_CATG_CODE("2");
			} else if (M_GENDER % 2 > 0) {
				beneficiaryBean.setCBEN_CATG_CODE("1");
			}*/
			/*end*/
			if(beneficiaryBean.getCBEN_AGE()!=null)
			{
				
				ResultSet resultSetage = null;
				int beneficieryMinimumAge = 0;
				String BeneficieryQuery = "SELECT PS_VALUE FROM PP_SYSTEM where PS_TYPE = ?";

				connection = CommonUtils.getConnection();

				/*Modified by Ram on 11/12/2016 for Common Age limitation*/
				/*resultSet = handler.executeSelectStatement(BeneficieryQuery, connection,new Object[] { "IL_BNFAGELMT" });*/

				resultSet = handler.executeSelectStatement(BeneficieryQuery, connection,new Object[] { "IL_CHILD_AGE" });
				/*End*/

				while (resultSet.next()) {
					beneficieryMinimumAge = resultSet.getInt(1);
				}
				System.out.println("beneficieryMinimumAge      "+beneficieryMinimumAge);
				if(beneficieryMinimumAge == 0)
				{
					throw new Exception("Nominee Minimum age setup is not available.");
				}

				/*if (beneficiaryBean.getPBEN_AGE() < 19 && !"A".equals(beneficiaryBean.getPBEN_BNF_TYPE())) {
				 * 
				 * End*/
				if (beneficiaryBean.getCBEN_AGE() <= beneficieryMinimumAge && !("A".equals(beneficiaryBean.getCBEN_BNF_TYPE()) || "S".equals(beneficiaryBean.getCBEN_BNF_TYPE()))) {

					compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_GUARDIAN_NAME().setDisabled(false);
					compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_GUARDIAN_NAME().setRequired(true);
					/*Added by Ram on 11/12/2016 for FALCONLIFE-1358413*/
					/*beneficiaryAction.getCOMP_PBEN_GUAR_REL_CODE().setDisabled(false);
					beneficiaryAction.getCOMP_PBEN_GUAR_REL_CODE().setRequired(true);*/
					/*End*/
				} else {

					/*Added by Ram on 01/12/2016 for configure minimum Beneficiery Age setup*/
					compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().setCBEN_GUARDIAN_NAME(null);
					/*End*/

					/*Added by Ram on 11/12/2016 for FALCONLIFE-1358413*/
					/*beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_GUAR_REL_CODE(null);
					beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_GUAR_REL_DESC(null);
*/

					compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_GUARDIAN_NAME().setDisabled(true);
					compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_GUARDIAN_NAME().setRequired(false);

					/*beneficiaryAction.getCOMP_PBEN_GUAR_REL_CODE().setDisabled(true);
					beneficiaryAction.getCOMP_PBEN_GUAR_REL_CODE().setRequired(false);*/
					/*End*/
				}
				/*Added by Ram on 01/12/2016 for configure minimum Beneficiery Age setup*/
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_GUARDIAN_NAME().resetValue();
				/*End*/

				/*Added by Ram on 11/12/2016 for FALCONLIFE-1358413*/
				//beneficiaryAction.getCOMP_PBEN_GUAR_REL_CODE().resetValue();
				/*End*/
			}
			/* end*/

			/*if(M_PS_VALUE==1)
			{
			M_GENDER = Integer.parseInt(beneficiaryBean.getCBEN_REF_ID1().substring(beneficiaryBean.getCBEN_REF_ID1().length()-1));
			if (M_GENDER % 2 == 0) {
				beneficiaryBean.setCBEN_CATG_CODE("2");
			} else if (M_GENDER % 2 > 0) {
				beneficiaryBean.setCBEN_CATG_CODE("1");
			}
			}
			*/
			
			if(beneficiaryBean.getCBEN_BNF_TYPE().equalsIgnoreCase("N"))
			{
			if (beneficiaryBean.getCBEN_CATG_CODE() != null) {
				list3 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
						.getCBEN_CATG_CODE(), beneficiaryBean
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
			}
			else
			{
				beneficiaryBean.setCBEN_CATG_CODE(null);
				beneficiaryBean.setUI_M_CATG_DESC(null);
			}

			/*added by raja on 10-07-2017 for ZBILQC-1731018*/ 

			LIFELIB lifelib = new LIFELIB();
			 lifelib.P_VAL_CUST(beneficiaryBean.getCBEN_BNF_CODE(),
					 beneficiaryBean.getCBEN_BNF_NAME(), "N", "N",
					 new CommonUtils().getControlBean().getM_DIVN_CODE());
			 
			/*end*/
			 
			 /*Added by Ameen on 30-12-2017 for ZBLIFE-1458892*/
				String bankQuery = "SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,CBAD_DIVISION,"
						+ "(CUST_TEL_AREA_CODE2||'-'||CUST_PHONE2) CUST_MOBILE,BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS,"
						+ "PM_CUSTOMER,FM_BANK WHERE CUST_CODE = CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN,'N') = 'Y' "
						+ "AND CBAD_CUST_CODE = ? AND BANK_CODE = CBAD_CUST_BANK_CODE";
				
				ResultSet rs = null;
				
				/*Added by Janani on 19.02.2018 for ZB bank details enabling as per Thiags sugges*/
				
				System.out.println("getCP_PYMT_MTD in PBEN_REF_ID1_WHEN_VALIDATE_ITEM        "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
						getPT_IL_CLAIM_PAID_BEAN().getCP_PYMT_MTD());
				
				 if(CommonUtils.isIN(CommonUtils.nvl(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().
							getPT_IL_CLAIM_PAID_BEAN().getCP_PYMT_MTD(),""),"1","3"))
					 
				 {
					 /*End of ZB bank details enabling as per Thiags sugges*/
				
				rs = new CRUDHandler().executeSelectStatement(bankQuery, CommonUtils.getConnection(),new Object[]{beneficiaryBean.getCBEN_BNF_CODE()});
				if(rs.next()){
					if(rs.getString("CBAD_CUST_BANK_CODE")==null || rs.getString("CBAD_ACNT_NAME")==null || 
							rs.getString("CBAD_ACNT_NO")==null || rs.getString("CBAD_DIVISION")==null){
						throw new Exception("Enter the Bank Details in Customer Master");
					}else{
						beneficiaryBean.setCBEN_BANK_CODE(rs.getString("CBAD_CUST_BANK_CODE"));
						beneficiaryBean.setUI_M_CBEN_BANK_CODE_DESC(rs.getString("BANK_NAME"));
						beneficiaryBean.setCBEN_DIVN_CODE(rs.getString("CBAD_DIVISION"));
						if(beneficiaryBean.getCBEN_DIVN_CODE()!=null){
							String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
							ResultSet sortCodeRS = null;
							sortCodeRS = new CRUDHandler().executeSelectStatement
									(sortCodeQry, CommonUtils.getConnection(),new Object[]{beneficiaryBean.getCBEN_BANK_CODE(),beneficiaryBean.getCBEN_DIVN_CODE()});
							if(sortCodeRS.next()){
								beneficiaryBean.setUI_M_CBEN_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
							}
						}
						beneficiaryBean.setCBEN_FLEX_01(rs.getString("CBAD_ACNT_NO"));
						beneficiaryBean.setCBEN_FLEX_02(rs.getString("CBAD_ACNT_NAME"));
						beneficiaryBean.setCBEN_FLEX_03(rs.getString("CUST_MOBILE"));
						
					}
				}else{
					throw new Exception("Enter the Bank Details in Customer Master");
				}
				
				 }
				 
				/*End*/

			
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
	private Date getFormattedDateFmIcNo(String srcDate){
		String selectQuery = "SELECT TO_CHAR(TO_DATE(?,'RRMMDD'),'DD-MON-RRRR') FROM DUAL";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String trgtStrDate = null;
		Date trgtUtilDate = null;

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con,
					new Object[] { srcDate });
			if (rs.next()) {
				trgtStrDate = rs.getString(1);
			}
			trgtUtilDate =CommonUtils.stringToUtilDate(trgtStrDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trgtUtilDate;
	}

	public String validateProd_code(PILT007_COMPOSITE_ACTION compositeAction) throws Exception
	{
		String PROD_AGE_CALC_FLAG=null;
		try{
			
		String query1="SELECT PROD_PERIOD, PROD_AGE_CALC_FLAG, NVL(PROD_AUTO_UW, 'N'),pol_plan_code FROM PM_IL_PRODUCT,pt_il_policy "
				+ "WHERE PROD_CODE = pol_plan_code and pol_no= ? ";	
	
		ResultSet resultSet2=new CRUDHandler().executeSelectStatement(query1, CommonUtils.getConnection(), 
				new Object[]{compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()});
		
		if(resultSet2.next())
		{
			PROD_AGE_CALC_FLAG=resultSet2.getString("PROD_AGE_CALC_FLAG");
		}
	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return PROD_AGE_CALC_FLAG;
	}

	/*public void whenCreateRecord(PILT007_COMPOSITE_ACTION compositeAction,PT_IL_CLAIM_BENEFICIARY beneficiaryAction)
			throws Exception {
		try {
			if (compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
					.getPT_IL_CLAIM_BENEFICIARY_LIST().size() == 0) {
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN()
				.setCBEN_SR_NO(1);
			}else{
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN()
				.setCBEN_SR_NO(
						compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
						.getPT_IL_CLAIM_BENEFICIARY_LIST().size()+1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

/*	end*/
	
	/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

	public void validate_benf_type(PILT007_COMPOSITE_ACTION compositeAction,PT_IL_CLAIM_BENEFICIARY beneficiaryBean) throws Exception
		{
			
		try
		{
		/*PT_IL_POL_BENEFICIARY beneficiaryBean = beneficiaryAction
					.getPT_IL_POL_BENEFICIARY_BEAN();
			ArrayList<String> list = null;
			String M_CODE_DESC = null;
			Double M_NEW_IC_NO_LENGTH = null;
			Double M_LENGTH_1 = null;
			Integer M_REF_ID_1_LENGTH = beneficiaryAction.getCOMP_PBEN_REF_ID1()
					.getMaxlength();
			try
			{
			for(PT_IL_POL_BENEFICIARY  bn: beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY()) {
				if(!(bn.getPBEN_BNF_TYPE().equalsIgnoreCase(beneficiaryBean.getPBEN_BNF_TYPE())))
				{
					if((bn.getPBEN_BNF_TYPE().equalsIgnoreCase("S") || bn.getPBEN_BNF_TYPE().equalsIgnoreCase("A")))
						{
						if((beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("S") || beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("A")))
						{
							System.out.println("your beneficiary type is added");
						}
						else
						{
					throw new Exception("Cannot have Assingnee and Nominee in a single policy");
						}
						}else
					{
							throw new Exception("Cannot have Assingnee and Nominee in a single policy");
					}
			}
			}
			
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
			
			

			if (beneficiaryBean.getPBEN_REF_ID1().length() != M_LENGTH_1) {
				throw new Exception("Citizen ID No should have exactly 12 digits");
			}
			
			for(PT_IL_POL_BENEFICIARY  bn: beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY()) {
				if(!(bn.getPBEN_REF_ID1().equalsIgnoreCase(beneficiaryBean.getPBEN_REF_ID1())))
				{
					throw new Exception("Customer could used be already");
				}
			}
			
			boolean flag=false;
			String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,"
					+ "CUST_ADDR3,CUST_CITY_CODE,CUST_BANK_CODE,CUST_BANK_AC_NO "
					+ "FROM PM_CUSTOMER WHERE CUST_REF_ID1=?";
			ResultSet resultsetcustomer=new CRUDHandler().executeSelectStatement(
					query, CommonUtils.getConnection(),  new Object[]{beneficiaryBean.getPBEN_REF_ID1()});
			while(resultsetcustomer.next())
			{
				flag=true;
				
			}
			if(flag==false)
			{
				throw new Exception("Not a valid Cititzen id");
			}
			*/
			if(beneficiaryBean.getROWID() != null)
			{
			int i=0;
			for(PT_IL_CLAIM_BENEFICIARY  bn: compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_LIST()) {
				if(beneficiaryBean.getCBEN_REF_ID1()!=null && bn.getCBEN_REF_ID1().equalsIgnoreCase(beneficiaryBean.getCBEN_REF_ID1()))
				{
					i++;
				}
			}
			System.out.println("i value   ==   >"+i);
			if(i>1)
			{
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "90015", new Object[] { "Beneficiary" }));
			}
			}
			else
			{
				for(PT_IL_CLAIM_BENEFICIARY  bn: compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_LIST()) {
					if(beneficiaryBean.getCBEN_REF_ID1()!=null && bn.getCBEN_REF_ID1().equalsIgnoreCase(beneficiaryBean.getCBEN_REF_ID1()))
					{
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "90015", new Object[] { "Beneficiary" }));
					}
				}
			}
			
			/*Added by saritha on 08-01-2018 for ssp call id : ZBLIFE-1464092*/
			
			getBeneficiaryPercent(compositeAction);
			
			/*End*/
				
		}
	
			catch (Exception e)
			{
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	/* End */
	
	
	/*Added by Ganesh on 08-01-2018 for ssp call id : ZBLIFE-1464092*/
	
	public void getBeneficiaryPercent(PILT007_COMPOSITE_ACTION compositeAction) throws Exception {

		ResultSet rstBenfPercent = null;
		Double benfPercent = 0.0;	

		try {
			String benfPercentQuery = "";
			Object benfParameter[] = null;
			if(compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().getROWID()!=null){
				benfPercentQuery = "SELECT SUM(CBEN_PERC) FROM PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CP_SYS_ID=? AND ROWID<>?";
				benfParameter = new Object[]{compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_CP_SYS_ID(), compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().getROWID()};

			}else{
				benfPercentQuery = "SELECT SUM(CBEN_PERC) FROM PT_IL_CLAIM_BENEFICIARY WHERE CBEN_CP_SYS_ID=?";
				benfParameter = new Object[]{compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_CP_SYS_ID()};
			}


			rstBenfPercent=new CRUDHandler().executeSelectStatement(benfPercentQuery, CommonUtils.getConnection(), benfParameter);

			if(rstBenfPercent.next()){
				benfPercent=rstBenfPercent.getDouble(1);
			}
			benfPercent += compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_PERC();

			if(benfPercent>100){

				throw new Exception("Total Beneficiary share percentage should be equal to 100");

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(rstBenfPercent);
		}
	}

	/*End*/
	
}
