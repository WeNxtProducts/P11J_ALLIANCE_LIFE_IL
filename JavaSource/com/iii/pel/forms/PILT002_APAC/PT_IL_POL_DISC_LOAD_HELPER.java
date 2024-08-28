package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_DISC_LOAD_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_POL_DISC_LOAD_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_POL_DISC_LOAD> dataList = compositeAction
				.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
				.getDataList_PT_IL_POL_DISC_LOAD();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN = dataList.get(0);
			PT_IL_POL_DISC_LOAD_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
					.setPT_IL_POL_DISC_LOAD_BEAN(PT_IL_POL_DISC_LOAD_BEAN);
		}
	}

	public void preInsert(PT_IL_POL_DISC_LOAD loadBean,
			PT_IL_POLICY policyBean, CTRL ctrlBean) throws Exception {

		String CURSOR_C1 = "SELECT PIL_PDL_SYS_ID.NEXTVAL FROM   DUAL";
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			localProcedure.IL_UNIQUE_DISCLOAD_SRNO(loadBean);
			if (loadBean.getPDL_COVER_CODE() == null) {
				localProcedure.IL_UNIQUE_DISC_LOAD_CODE(null, loadBean,
						policyBean);
			} else {
				localProcedure.IL_UNIQUE_DISC_LOAD_CODE(loadBean
						.getPDL_COVER_CODE(), loadBean, policyBean);
			}
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				loadBean.setPDL_SYS_ID(resultSet.getLong(1));
			}
			loadBean.setPDL_CR_DT(new CommonUtils().getCurrentDate());
			loadBean.setPDL_CR_UID(ctrlBean.getUSER_ID());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);}catch (Exception e) {}
		}
	}

	public void whenNewRecordInstance(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			executeQuery(compositeAction);
			PT_IL_POL_DISC_LOAD_ACTION loadAction = compositeAction
					.getPT_IL_POL_DISC_LOAD_ACTION_BEAN();
			PT_IL_POL_DISC_LOAD loadBean = loadAction
					.getPT_IL_POL_DISC_LOAD_BEAN();
			if ("3".equals(loadBean.getPDL_APPLIED_ON())
					|| "6".equals(loadBean.getPDL_APPLIED_ON())
					|| "7".equals(loadBean.getPDL_APPLIED_ON())
					|| "8".equals(loadBean.getPDL_APPLIED_ON())
					|| "9".equals(loadBean.getPDL_APPLIED_ON())
					|| "10".equals(loadBean.getPDL_APPLIED_ON())) {
				loadAction.getCOMP_PDL_COVER_CODE().setDisabled(false);
				loadAction.getCOMP_PDL_COVER_CODE().setRequired(true);

			} else {
				loadAction.getCOMP_PDL_COVER_CODE().setDisabled(true);
			}

			if ("11".equals(loadBean.getPDL_APPLIED_ON())) {
				loadBean.setPDL_APPLY_UPTO_SRNO(0);
				loadAction.getCOMP_PDL_APPLY_UPTO_SRNO().setDisabled(true);
			} else {
				loadAction.getCOMP_PDL_APPLY_UPTO_SRNO().setDisabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void preUpdate(PT_IL_POL_DISC_LOAD loadBean,
			PT_IL_POLICY policyBean, CTRL ctrlBean) throws Exception {

		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();

		try {

			localProcedure.IL_UNIQUE_DISCLOAD_SRNO(loadBean);
			if (loadBean.getPDL_COVER_CODE() == null) {
				localProcedure.IL_UNIQUE_DISC_LOAD_CODE(null, loadBean,
						policyBean);
			} else {
				localProcedure.IL_UNIQUE_DISC_LOAD_CODE(loadBean
						.getPDL_COVER_CODE(), loadBean, policyBean);
			}

			loadBean.setPDL_CR_DT(new CommonUtils().getCurrentDate());
			loadBean.setPDL_CR_UID(ctrlBean.getUSER_ID());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenCreateRecord(PT_IL_POL_DISC_LOAD loadBean, Long POL_SYS_ID) {
		loadBean.setPDL_DISC_LOAD_TYPE("D");
		loadBean.setPDL_APPLIED_ON("1");
		loadBean.setPDL_APPLY_UPTO_SRNO(0);
		loadBean.setPDL_POL_SYS_ID(POL_SYS_ID);
	}

	public void postQuery(PT_IL_POL_DISC_LOAD_ACTION loadAction)
			throws Exception {

		String M_TYPE = null;
		PT_IL_POL_DISC_LOAD loadBean = loadAction.getPT_IL_POL_DISC_LOAD_BEAN();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		DBProcedures procedures = new DBProcedures();

		try {
			if (loadBean.getPDL_DISC_LOAD_CODE() != null) {
				if ("D".equals(loadBean.getPDL_DISC_LOAD_TYPE())) {
					M_TYPE = "IL_DISC";
				} else {
					M_TYPE = "IL_LOAD";
				}
				list = procedures.P_VAL_CODES(M_TYPE, loadBean
						.getPDL_DISC_LOAD_CODE(), loadBean
						.getUI_M_DISCLOAD_DESC(), "N", "N", null);
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						loadBean.setUI_M_DISCLOAD_DESC(list.get(0));
					}
				}
						
			}

			list1 = procedures.helperP_VAL_COVER(loadBean.getPDL_COVER_CODE(), null,"N", "N");
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					loadBean.setUI_M_DLCVR_DESC(list1.get(0));
				}
			}
					
				
			if ("3".equals(loadBean.getPDL_APPLIED_ON())
					|| "6".equals(loadBean.getPDL_APPLIED_ON())
					|| "7".equals(loadBean.getPDL_APPLIED_ON())
					|| "8".equals(loadBean.getPDL_APPLIED_ON())
					|| "9".equals(loadBean.getPDL_APPLIED_ON())
					|| "10".equals(loadBean.getPDL_APPLIED_ON())) {
				loadAction.getCOMP_PDL_COVER_CODE().setDisabled(false);
				loadAction.getCOMP_PDL_COVER_CODE().setRequired(true);

			} else {
				loadAction.getCOMP_PDL_COVER_CODE().setDisabled(true);
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
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_DISC_LOAD WHERE  PDL_POL_SYS_ID =  ? ";
		String M_TEMP = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_TEMP = resultSet.getString(1);
				executeQuery(compositeAction);
				postQuery(compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN());
			} else {
				compositeAction.getPT_IL_POL_DISC_LOAD_ACTION_BEAN()
						.getDataList_PT_IL_POL_DISC_LOAD().clear();
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
				// TODO: handle exception
			}
		}

	}

	public void keyDelRec(PT_IL_POL_DISC_LOAD_ACTION loadAction,
			PT_IL_POLICY policyBean,
			PT_IL_POL_ASSURED_DTLS_ACTION assuredAction, CTRL ctrlBean)
			throws Exception {

		Integer M_REC_NO = null;
		Integer M_SRNO = null;
		PT_IL_POL_ASSURED_DTLS assuredBean = assuredAction
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		List<PT_IL_POL_DISC_LOAD> datalist = loadAction
				.getDataList_PT_IL_POL_DISC_LOAD();
		PT_IL_POL_DISC_LOAD loadBean1 = null;
		PT_IL_POL_DISC_LOAD loadBean = loadAction.getPT_IL_POL_DISC_LOAD_BEAN();
		M_SRNO = loadBean.getPDL_SRNO().intValue();
		M_REC_NO = datalist.indexOf(loadBean);
		try {
			for (int index = 0; index < datalist.size(); index++) {
				if (M_REC_NO != index) {
					loadBean1 = new PT_IL_POL_DISC_LOAD();
					loadBean1 = datalist.get(index);
					if (M_SRNO == loadBean1.getPDL_APPLY_UPTO_SRNO().intValue()) {
						throw new ValidatorException(new FacesMessage(Messages
								.getString(PELConstants.pelErrorMessagePath,
										"91126")));
					}
				}
			}
			if (("11".equals(loadBean.getPDL_APPLIED_ON()) || "12"
					.equals(loadBean.getPDL_APPLIED_ON()))
					&& CommonUtils.nvl(policyBean.getPOL_END_NO_IDX(), 0) == 0) {
				assuredBean.setPOAD_DISC_AGE(assuredBean.getPOAD_DISC_AGE()
						- Integer.parseInt(String.valueOf(Math.round(loadBean.getPDL_RATE()))));
			}
			if (("11".equals(loadBean.getPDL_APPLIED_ON()) || "12"
					.equals(loadBean.getPDL_APPLIED_ON()))
					&& "014".equals(CommonUtils.nvl(policyBean
							.getPOL_END_TYPE(), "000"))) {
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(1, 2))) {
					assuredAction.setUPDATE_ALLOWED(true);
				}
				assuredBean.setPOAD_DISC_AGE(assuredBean.getPOAD_DISC_AGE()
						- Integer.parseInt(String.valueOf(Math.round(loadBean.getPDL_RATE()))));
				assuredAction.setUPDATE_ALLOWED(false);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void PDL_SRNO_WHEN_VALIDATE_ITEM(PT_IL_POL_DISC_LOAD loadBean)
			throws Exception {
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();

		try {
			localProcedure.IL_UNIQUE_DISCLOAD_SRNO(loadBean);
			if (loadBean.getPDL_SRNO() <= 0) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PDL_DISC_LOAD_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_DISC_LOAD loadBean, PT_IL_POLICY policyBean,
			PT_IL_POL_ASSURED_DTLS assuredBean) throws Exception {

		String M_TYPE = null;
		Double M_PC_VALUE = null;
		Integer M_VALUE = null;
		String M_PLAN_TYPE = null;
		String M_CODE_DESC = null;
		String CURSOR_C2 = "SELECT  PLAN_TYPE FROM    PM_IL_PLAN WHERE   PLAN_CODE = ? ";
		String CURSOR_C3 = "SELECT  PS_VALUE FROM  PP_SYSTEM WHERE  PS_TYPE ='IL_MTLD_CODE' "
				+ "AND PS_CODE IN ('IL_MLOD_DTH','IL_MLOD_TPD') AND PS_CODE_DESC = ? ";
		String CURSOR_C4 = "SELECT PS_TYPE FROM   PP_SYSTEM WHERE  PS_CODE_DESC = ? ";
		String CURSOR_C5 = "SELECT NVL(TD_RATE,0) FROM   PM_IL_TAR_DTL WHERE  TD_TH_CODE =  ?  "
				+ "AND    TD_PARAM_TYPE = 'L' AND  ?  BETWEEN TD_PARA_01_FM AND TD_PARA_01_TO "
				+ "AND    ?  BETWEEN TD_PARA_02_FM AND TD_PARA_02_TO ";
		String CURSOR_C6 = "SELECT NVL(TH_RATE_PER,1) FROM PM_IL_TAR_HDR WHERE TH_CODE = ?  AND  TH_PARAM_TYPE = 'L' ";
		String CURSOR_C7 = "SELECT PALT_LOAD_APPL_PERC,PALT_APPLIED_ON, PALT_APPL_UPTO FROM   PM_IL_PROD_APPL_LOAD_TARIFF "
				+ "WHERE  PALT_PROD_CODE= ? AND    PALT_TH_CODE  = ? ";
		String M_PS_TYPE = null;
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (loadBean.getPDL_DISC_LOAD_CODE() != null
					&& loadBean.getPDL_COVER_CODE() != null) {
				localProcedure.IL_UNIQUE_DISC_LOAD_CODE(loadBean
						.getPDL_COVER_CODE(), loadBean, policyBean);
			}

			if (loadBean.getPDL_DISC_LOAD_CODE() != null) {
				if ("D".equals(loadBean.getPDL_DISC_LOAD_TYPE())) {
					M_TYPE = "IL_DISC";
				} else {
					M_TYPE = "IL_LOAD";
				}
				list = procedures.P_VAL_CODES(M_TYPE, loadBean
						.getPDL_DISC_LOAD_CODE(), loadBean
						.getUI_M_DISCLOAD_DESC(), "N", "E", null);
				if (list != null && list.size() > 0) {
					loadBean.setUI_M_DISCLOAD_DESC(list.get(0));
				}
					
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { policyBean
								.getPOL_PLAN_CODE() });
				if (resultSet.next()) {
					M_PLAN_TYPE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				if ("M".equals(M_PLAN_TYPE)) {
					resultSet = handler.executeSelectStatement(CURSOR_C3,
							connection, new Object[] { loadBean
									.getPDL_DISC_LOAD_CODE() });
					if (resultSet.next()) {
						M_VALUE = resultSet.getInt(1);
						loadBean.setPDL_APPL_PERC(CommonUtils.nvl(M_VALUE, 100)
								.doubleValue());
					} else {
						if(loadBean.getPDL_APPL_PERC() == null){
						loadBean.setPDL_APPL_PERC(100.00);
						}
					}
					CommonUtils.closeCursor(resultSet);
				} else {
					if(loadBean.getPDL_APPL_PERC() == null){
						loadBean.setPDL_APPL_PERC(100.00);
					}
				}

				resultSet = handler.executeSelectStatement(CURSOR_C4,
						connection, new Object[] { loadBean
								.getPDL_DISC_LOAD_CODE() });
				if (resultSet.next()) {
					M_PS_TYPE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				if ("IL_UWOC_LOAD".equals(M_PS_TYPE)) {
					resultSet = handler.executeSelectStatement(CURSOR_C5,
							connection, new Object[] {
									loadBean.getPDL_DISC_LOAD_CODE(),
									assuredBean.getPOAD_OCC_CODE(),
									assuredBean.getPOAD_OCC_CLASS() });
					if (resultSet.next()) {
						loadBean.setPDL_RATE(resultSet.getDouble(1));
					}
					CommonUtils.closeCursor(resultSet);
					resultSet = handler.executeSelectStatement(CURSOR_C6,
							connection, new Object[] { loadBean
									.getPDL_DISC_LOAD_CODE() });
					if (resultSet.next()) {
						loadBean.setPDL_RATE_PER(resultSet.getDouble(1));
					}
					CommonUtils.closeCursor(resultSet);
				}
				resultSet = handler.executeSelectStatement(CURSOR_C7,
						connection, new Object[] {
								policyBean.getPOL_PROD_CODE(),
								loadBean.getPDL_DISC_LOAD_CODE() });
				if (resultSet.next()) {
					if(loadBean.getPDL_APPL_PERC() == null){
						loadBean.setPDL_APPL_PERC(resultSet.getDouble(1));
					}
					loadBean.setPDL_APPLIED_ON(resultSet.getString(2));
					loadBean.setPDL_APPLY_UPTO_SRNO(resultSet.getInt(3));
				}
				CommonUtils.closeCursor(resultSet);

			}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void PDL_APPL_PERC_WHEN_VALIDATE_ITEM(PT_IL_POL_DISC_LOAD loadBean) {
		if (CommonUtils.nvl(loadBean.getPDL_APPL_PERC(), 0) < 0) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "71042")));
		}
	}

	public void PDL_APPLIED_ON_WHEN_VALIDATE_ITEM(
			PT_IL_POL_DISC_LOAD_ACTION loadAction, PT_IL_POLICY policyBean,
			PT_IL_POL_ASSURED_DTLS assuredBean, DUMMY dummyBean)
			throws Exception {

		String CURSOR_C1 = "SELECT PS_VALUE FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_TAR_DATE'";
		String CURSOR_C2 = "SELECT PLAN_TYPE FROM  PM_IL_PLAN WHERE  PLAN_CODE = ?  AND  NVL(PLAN_FRZ_FLAG,'N') != 'Y' ";
		String CURSOR_C3 = "SELECT POAD_SYS_ID FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = ? AND    POAD_TYPE = 'R' ";
		String CURSOR_C4 = "SELECT POAD_SYS_ID FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = ? AND  POAD_TYPE = 'E'";
		Long M_PAYOR_SYS_ID = null;
		Long M_PAYEE_SYS_ID = null;
		Long M_ASSURED_SYS_ID = null;
		Integer M_PS_VALUE = null;
		Date M_EFF_DT = null;
		String M_PLAN_TYPE = null;
		String M_TD_CHAR_RATE = null;
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList<OracleParameter> list = null;
		ArrayList<String> list1 = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POL_DISC_LOAD loadBean = loadAction.getPT_IL_POL_DISC_LOAD_BEAN();
		P9ILPK_POLICY policyProcedure = new P9ILPK_POLICY();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				M_PS_VALUE = resultSet.getInt(1);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { policyBean.getPOL_PROD_CODE() });
			if (resultSet.next()) {
				M_PLAN_TYPE = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if (!("N".equalsIgnoreCase(M_PLAN_TYPE))
					&& "Y".equalsIgnoreCase(CommonUtils.nvl(policyBean
							.getPOL_JOINT_LIFE_YN(), "N"))
					&& ("4".equals(loadBean.getPDL_APPLIED_ON())
							|| "5".equals(loadBean.getPDL_APPLIED_ON())
							|| "7".equals(loadBean.getPDL_APPLIED_ON())
							|| "8".equals(loadBean.getPDL_APPLIED_ON())
							|| "9".equals(loadBean.getPDL_APPLIED_ON()) || "10"
							.equals(loadBean.getPDL_APPLIED_ON()))) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "91022")));
			}
			if ("N".equalsIgnoreCase(policyBean.getPOL_JOINT_LIFE_YN())
					&& ("5".equals(loadBean.getPDL_APPLIED_ON())
							|| "8".equals(loadBean.getPDL_APPLIED_ON())
							|| "10".equals(loadBean.getPDL_APPLIED_ON()) || "12"
							.equals(loadBean.getPDL_APPLIED_ON()))) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "91022")));
			}
			if (loadBean.getPDL_RATE() == null) {
				if (M_PS_VALUE == 1) {
					M_EFF_DT = CommonUtils.nvl(policyBean
							.getPOL_END_EFF_FROM_DT(), policyBean
							.getPOL_START_DT());
				} else if (M_PS_VALUE == 2) {
					M_EFF_DT = CommonUtils.nvl(policyBean.getPOL_END_DT(),
							policyBean.getPOL_ISSUE_DT());
				}
				if ("2".equals(dummyBean.getUI_M_CALC_METHOD())) {
					list = policyProcedure.GET_TAR_PARAM_RATE(
							loadBean.getPDL_DISC_LOAD_CODE(), policyBean.getPOL_PLAN_CODE(), 
							loadBean.getPDL_DISC_LOAD_TYPE(), CommonUtils.getProcedureValue(
							policyBean.getPOL_SYS_ID()), CommonUtils.getProcedureValue(
							assuredBean.getPOAD_SYS_ID()),CommonUtils.getProcedureValue(M_EFF_DT), 
							"E", CommonUtils.getProcedureValue(loadBean.getPDL_RATE()), 
							CommonUtils.getProcedureValue(loadBean.getPDL_RATE_PER()), M_TD_CHAR_RATE);
					loadBean.setPDL_RATE(Double.parseDouble(list.get(0)
							.getValue()));
					loadBean.setPDL_RATE_PER(Double.parseDouble(list.get(1)
							.getValue()));
				}
				resultSet = handler
						.executeSelectStatement(CURSOR_C3, connection,
								new Object[] { policyBean.getPOL_SYS_ID() });
				if (resultSet.next()) {
					M_PAYOR_SYS_ID = resultSet.getLong(1);
				}
				CommonUtils.closeCursor(resultSet);
				resultSet = handler
						.executeSelectStatement(CURSOR_C4, connection,
								new Object[] { policyBean.getPOL_SYS_ID() });
				if (resultSet.next()) {
					M_PAYEE_SYS_ID = resultSet.getLong(1);
				}
				CommonUtils.closeCursor(resultSet);
				if ("4".equals(loadBean.getPDL_APPLIED_ON())
						|| "7".equals(loadBean.getPDL_APPLIED_ON())
						|| "9".equals(loadBean.getPDL_APPLIED_ON())
						|| "11".equals(loadBean.getPDL_APPLIED_ON())) {
					M_ASSURED_SYS_ID = M_PAYOR_SYS_ID;
				} else if ("5".equals(loadBean.getPDL_APPLIED_ON())
						|| "8".equals(loadBean.getPDL_APPLIED_ON())
						|| "10".equals(loadBean.getPDL_APPLIED_ON())
						|| "12".equals(loadBean.getPDL_APPLIED_ON())) {
					M_ASSURED_SYS_ID = M_PAYEE_SYS_ID;
				} else if ("1".equals(loadBean.getPDL_APPLIED_ON())
						|| "2".equals(loadBean.getPDL_APPLIED_ON())
						|| "3".equals(loadBean.getPDL_APPLIED_ON())
						|| "6".equals(loadBean.getPDL_APPLIED_ON())) {
					M_ASSURED_SYS_ID = assuredBean.getPOAD_SYS_ID();
				}
				if ("1".equals(dummyBean.getUI_M_CALC_METHOD())
						&& CommonUtils.nvl(M_PLAN_TYPE, "N") != "M"
						&& loadBean.getPDL_RATE() == null
						&& ("1".equals(loadBean.getPDL_APPLIED_ON())
								|| "2".equals(loadBean.getPDL_APPLIED_ON())
								|| "4".equals(loadBean.getPDL_APPLIED_ON())
								|| "5".equals(loadBean.getPDL_APPLIED_ON())
								|| "11".equals(loadBean.getPDL_APPLIED_ON()) || "12"
								.equals(loadBean.getPDL_APPLIED_ON()))) {

					list = policyProcedure.GET_TAR_PARAM_RATE(
							loadBean.getPDL_DISC_LOAD_CODE(), policyBean.getPOL_PLAN_CODE(), 
							loadBean.getPDL_DISC_LOAD_TYPE(), CommonUtils.getProcedureValue(
							policyBean.getPOL_SYS_ID()), CommonUtils.getProcedureValue(
							assuredBean.getPOAD_SYS_ID()), CommonUtils.getProcedureValue(M_EFF_DT), 
							"E", CommonUtils.getProcedureValue(loadBean.getPDL_RATE()), 
							CommonUtils.getProcedureValue(loadBean.getPDL_RATE_PER()), M_TD_CHAR_RATE);
					loadBean.setPDL_RATE(Double.parseDouble(list.get(0)
							.getValue()));
					loadBean.setPDL_RATE_PER(Double.parseDouble(list.get(1)
							.getValue()));
				} else if ("1".equals(dummyBean.getUI_M_CALC_METHOD())
						&& "M".equals(CommonUtils.nvl(M_PLAN_TYPE, "N"))
						&& "T".equals(dummyBean.getUI_M_PROD_PREM_CALC_MTHD())
						&& loadBean.getPDL_RATE() == null
						&& ("1".equals(loadBean.getPDL_APPLIED_ON())
								|| "2".equals(loadBean.getPDL_APPLIED_ON())
								|| "4".equals(loadBean.getPDL_APPLIED_ON())
								|| "5".equals(loadBean.getPDL_APPLIED_ON())
								|| "11".equals(loadBean.getPDL_APPLIED_ON()) || "12"
								.equals(loadBean.getPDL_APPLIED_ON()))) {
					list = policyProcedure.GET_TAR_PARAM_RATE(loadBean
							.getPDL_DISC_LOAD_CODE(), policyBean
							.getPOL_PLAN_CODE(), loadBean
							.getPDL_DISC_LOAD_TYPE(), policyBean
							.getPOL_SYS_ID().toString(), assuredBean
							.getPOAD_SYS_ID().toString(), CommonUtils
							.getProcedureValue(M_EFF_DT), "E", loadBean
							.getPDL_RATE().toString(), loadBean
							.getPDL_RATE_PER().toString(), M_TD_CHAR_RATE);
					loadBean.setPDL_RATE(Double.parseDouble(list.get(0)
							.getValue()));
					loadBean.setPDL_RATE_PER(Double.parseDouble(list.get(1)
							.getValue()));
				}
			}
			if ("3".equals(loadBean.getPDL_APPLIED_ON())
					|| "6".equals(loadBean.getPDL_APPLIED_ON())
					|| "7".equals(loadBean.getPDL_APPLIED_ON())
					|| "8".equals(loadBean.getPDL_APPLIED_ON())
					|| "9".equals(loadBean.getPDL_APPLIED_ON())
					|| "10".equals(loadBean.getPDL_APPLIED_ON())) {
				loadAction.getCOMP_PDL_COVER_CODE().setDisabled(false);
				loadAction.getCOMP_PDL_COVER_CODE().setRequired(true);
				if (loadBean.getPDL_COVER_CODE() == null) {
					loadBean.setPDL_COVER_CODE(policyBean.getPOL_PLAN_CODE());
				}
			} else {
				loadBean.setPDL_COVER_CODE(null);
				loadAction.getCOMP_PDL_COVER_CODE().setDisabled(true);
			}
			
			//COMMENTED BY AKASH 17/JAN/2013, APPLIED ON CONCEPT IS WORKING FOR TOTAL PREMIUM .
			
		/*	if ("11".equals(loadBean.getPDL_APPLIED_ON())
					|| "12".equals(loadBean.getPDL_APPLIED_ON())) {
				loadBean.setPDL_APPLY_UPTO_SRNO(0);
				loadAction.getCOMP_PDL_APPLY_UPTO_SRNO().setDisabled(true);

			} else {
				loadAction.getCOMP_PDL_APPLY_UPTO_SRNO().setDisabled(false);
			}*/
			
		if (!"2".equals(loadBean.getPDL_APPLIED_ON())) {
		loadBean.setPDL_APPLY_UPTO_SRNO(0);
		loadAction.getCOMP_PDL_APPLY_UPTO_SRNO().setDisabled(true);

	} else {
		loadAction.getCOMP_PDL_APPLY_UPTO_SRNO().setDisabled(false);
	}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
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
				// TODO: handle exception
			}
		}
	}

	public void PDL_COVER_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_DISC_LOAD loadBean,
			PT_IL_POLICY policyBean, PT_IL_POL_ASSURED_DTLS assuredBean,
			DUMMY dummyBean) throws Exception {

		String CURSOR_C1 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_SYS_ID = ? AND " +
				"POL_PLAN_CODE = ? UNION SELECT 'X' FROM PT_IL_POL_ADDL_COVER WHERE " +
				"POAC_POL_SYS_ID = ? AND POAC_COVER_CODE = ? ";
		String CURSOR_C2 = "SELECT COVER_DESC,COVER_BL_DESC FROM PM_IL_COVER WHERE COVER_CODE = ? ";
		String CURSOR_C3 = "SELECT POAD_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE " +
				"POAD_POL_SYS_ID = ? AND POAD_TYPE = 'R' ";
		String CURSOR_C4 = "SELECT POAD_SYS_ID FROM PT_IL_POL_ASSURED_DTLS WHERE " +
				"POAD_POL_SYS_ID = ? AND POAD_TYPE = 'E' ";
		String CURSOR_C5 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ? AND " +
				"NVL(PLAN_FRZ_FLAG,'N') != 'Y' ";
		String M_DUMMY = null;
		String M_COVER_DESC = null;
		String M_COVER_BL_DESC = null;
		Long M_PAYOR_SYS_ID = null;
		Long M_PAYEE_SYS_ID = null;
		Long M_ASSURED_SYS_ID = null;
		String M_PLAN_TYPE = null;
		Date M_EFF_DT = null;
		String M_TD_CHAR_RATE = null;
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		P9ILPK_POLICY policyProcedure = new P9ILPK_POLICY();
		DBProcedures procedures = new DBProcedures();
		ArrayList<OracleParameter> list = null;
		ArrayList<String> list1 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (loadBean.getPDL_COVER_CODE() == null) {
				localProcedure.IL_UNIQUE_DISC_LOAD_CODE(null, loadBean,
						policyBean);
			} else {
				localProcedure.IL_UNIQUE_DISC_LOAD_CODE(loadBean
						.getPDL_COVER_CODE(), loadBean, policyBean);
			}
			if (loadBean.getPDL_COVER_CODE() != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { 
						policyBean.getPOL_SYS_ID(),policyBean.getPOL_PLAN_CODE(), 
						policyBean.getPOL_SYS_ID(), loadBean.getPDL_COVER_CODE()});
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					list1 = procedures.helperP_VAL_COVER(loadBean.getPDL_COVER_CODE(), null, "N", "E");
					loadBean.setUI_M_DLCVR_DESC(list1.get(0));
				} else {
					throw new ValidatorException(new FacesMessage(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"71043")));
				}
				CommonUtils.closeCursor(resultSet);
				resultSet = handler.executeSelectStatement(CURSOR_C5,
						connection, new Object[] { policyBean
								.getPOL_PLAN_CODE() });
				if (resultSet.next()) {
					M_PLAN_TYPE = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				resultSet = handler
						.executeSelectStatement(CURSOR_C3, connection,
								new Object[] { policyBean.getPOL_SYS_ID() });
				if (resultSet.next()) {
					M_PAYOR_SYS_ID = resultSet.getLong(1);
				}
				CommonUtils.closeCursor(resultSet);
				resultSet = handler
						.executeSelectStatement(CURSOR_C4, connection,
								new Object[] { policyBean.getPOL_SYS_ID() });
				if (resultSet.next()) {
					M_PAYEE_SYS_ID = resultSet.getLong(1);
				}
				CommonUtils.closeCursor(resultSet);
				M_EFF_DT = CommonUtils.nvl(policyBean.getPOL_END_DT(),
						policyBean.getPOL_ISSUE_DT());
				if ("4".equals(loadBean.getPDL_APPLIED_ON())
						|| "7".equals(loadBean.getPDL_APPLIED_ON())
						|| "9".equals(loadBean.getPDL_APPLIED_ON())) {
					M_ASSURED_SYS_ID = M_PAYOR_SYS_ID;
				} else if ("5".equals(loadBean.getPDL_APPLIED_ON())
						|| "8".equals(loadBean.getPDL_APPLIED_ON())
						|| "10".equals(loadBean.getPDL_APPLIED_ON())) {
					M_ASSURED_SYS_ID = M_PAYEE_SYS_ID;
				} else if ("1".equals(loadBean.getPDL_APPLIED_ON())
						|| "2".equals(loadBean.getPDL_APPLIED_ON())
						|| "3".equals(loadBean.getPDL_APPLIED_ON())
						|| "6".equals(loadBean.getPDL_APPLIED_ON())) {
					M_ASSURED_SYS_ID = assuredBean.getPOAD_SYS_ID();
				}

				//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
				//|| "2".equals(dummyBean.getUI_M_CALC_METHOD()
				
				if (("1".equals(dummyBean.getUI_M_CALC_METHOD()) || "2".equals(dummyBean.getUI_M_CALC_METHOD()))
						&& CommonUtils.nvl(M_PLAN_TYPE, "N") != "M"
						&& dummyBean.getUI_M_PROD_PREM_CALC_MTHD() != "X") {
					list = policyProcedure.GET_TAR_PARAM_RATE(
							loadBean.getPDL_DISC_LOAD_CODE(), loadBean.getPDL_COVER_CODE(), 
							loadBean.getPDL_DISC_LOAD_TYPE(), CommonUtils.getProcedureValue(
							policyBean.getPOL_SYS_ID()), CommonUtils.getProcedureValue(
							M_ASSURED_SYS_ID), CommonUtils.getProcedureValue(M_EFF_DT), 
							"E", CommonUtils.getProcedureValue(loadBean.getPDL_RATE()), 
							CommonUtils.getProcedureValue(loadBean.getPDL_RATE_PER()), M_TD_CHAR_RATE);
					loadBean.setPDL_RATE(Double.parseDouble(list.get(0).getValue()));
					loadBean.setPDL_RATE_PER(Double.parseDouble(list.get(1).getValue()));
					M_TD_CHAR_RATE = list.get(2).getValue();
				} else if (("1".equals(dummyBean.getUI_M_CALC_METHOD())|| "2".equals(dummyBean.getUI_M_CALC_METHOD()))
						&& "M".equals(CommonUtils.nvl(M_PLAN_TYPE, "N"))
						&& "T".equals(dummyBean.getUI_M_PROD_PREM_CALC_MTHD())
						&& loadBean.getPDL_RATE() == null
						&& "3".equals(loadBean.getPDL_APPLIED_ON())
						|| "6".equals(loadBean.getPDL_APPLIED_ON())
						|| "7".equals(loadBean.getPDL_APPLIED_ON())
						|| "9".equals(loadBean.getPDL_APPLIED_ON())) {
					list = policyProcedure.GET_TAR_PARAM_RATE(loadBean.getPDL_DISC_LOAD_CODE(), 
							loadBean.getPDL_COVER_CODE(), loadBean.getPDL_DISC_LOAD_TYPE(), 
							CommonUtils.getProcedureValue(policyBean.getPOL_SYS_ID()), 
							CommonUtils.getProcedureValue(M_ASSURED_SYS_ID), 
							CommonUtils.getProcedureValue(M_EFF_DT), "E", 
							CommonUtils.getProcedureValue(loadBean.getPDL_RATE()), 
							loadBean.getPDL_RATE_PER().toString(), M_TD_CHAR_RATE);
					loadBean.setPDL_RATE(Double.parseDouble(list.get(0)
							.getValue()));
					loadBean.setPDL_RATE_PER(Double.parseDouble(list.get(1)
							.getValue()));
					M_TD_CHAR_RATE = list.get(2).getValue();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}
		}
	}

	public void PDL_APPLY_UPTO_SRNO_WHEN_VALIDATE_ITEM(
			PT_IL_POL_DISC_LOAD loadBean) throws Exception {
		try {
			if (loadBean.getPDL_APPLY_UPTO_SRNO() >= loadBean.getPDL_SRNO()) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "91083")));
			}
			if (loadBean.getPDL_APPLY_UPTO_SRNO() < 0 ||loadBean.getPDL_APPLY_UPTO_SRNO() == null) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PDL_RATE_WHEN_VALIDATE_ITEM(PT_IL_POL_DISC_LOAD loadbean)
			throws Exception {
		try {
			if (loadbean.getPDL_RATE() < 0) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public void PDL_RATE_PER_WHEN_VALIDATE_ITEM(PT_IL_POL_DISC_LOAD loadbean)
			throws Exception {
		try {
			if (loadbean.getPDL_RATE_PER() < 0) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public void PDL_FC_DISC_LOAD_VALUE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_DISC_LOAD loadBean, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		try {
			if (loadBean.getPDL_FC_DISC_LOAD_VALUE() < 0) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}

			list = procedures.P_VAL_ROUND_AMT(policyBean
					.getPOL_SA_CURR_CODE(), loadBean
					.getPDL_FC_DISC_LOAD_VALUE().toString(), "V", null);
			loadBean.setPDL_FC_DISC_LOAD_VALUE(Double.parseDouble(list.get(0)));
			loadBean.setPDL_LC_DISC_LOAD_VALUE(loadBean
					.getPDL_FC_DISC_LOAD_VALUE()
					* policyBean.getPOL_SA_EXCH_RATE());
			list1 = procedures.P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR(), loadBean.getPDL_LC_DISC_LOAD_VALUE()
					.toString(), "V", null);
			loadBean
					.setPDL_LC_DISC_LOAD_VALUE(Double.parseDouble(list1.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void PDL_LC_DISC_LOAD_VALUE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_DISC_LOAD loadBean,
			PT_IL_POLICY policyBean, DUMMY dummyBean) throws Exception {
		
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		LIFELIB lifelib = new LIFELIB();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		try {
			if (loadBean.getPDL_LC_DISC_LOAD_VALUE() < 0) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}

			
			loadBean.setPDL_LC_DISC_LOAD_VALUE(loadBean
					.getPDL_FC_DISC_LOAD_VALUE()
					* policyBean.getPOL_SA_EXCH_RATE());
			list1 = procedures.P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR(), loadBean.getPDL_LC_DISC_LOAD_VALUE()
					.toString(), "V", null);
			loadBean
					.setPDL_LC_DISC_LOAD_VALUE(Double.parseDouble(list1.get(0)));
			lifelib.callP_VAL_FC_LC_TOLERANCE(loadBean.getPDL_FC_DISC_LOAD_VALUE().toString(),
                    loadBean.getPDL_LC_DISC_LOAD_VALUE().toString() ,policyBean.getPOL_SA_EXCH_RATE().toString(),"E");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	
	
}
