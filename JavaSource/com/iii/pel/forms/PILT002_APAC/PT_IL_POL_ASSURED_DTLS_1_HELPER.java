package com.iii.pel.forms.PILT002_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.component.UIInput;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILP002_APAC.COMPOSITE_ACTION_BEAN;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_ASSURED_DTLS_1_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_POL_ASSURED_DTLS_1_DELEGATE()
				.executeSelectStatement(compositeAction);
	}

	public void preInset(
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		Double M_VALUE = null;
		String CURSOR_C1 = "SELECT PIL_POAD_SYS_ID.NEXTVAL FROM DUAL";
		String CURSOR_C2 = "SELECT NVL(MAX(POAD_SERIAL_NO),0) + 1 FROM PT_IL_POL_ASSURED_DTLS WHERE POAD_POL_SYS_ID = ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		Integer returnValue = null;
		CRUDHandler handler = new CRUDHandler();
		PKG_PILT002_APAC localProcudeure = new PKG_PILT002_APAC();
		CommonUtils commonUtils = new CommonUtils();

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_POL_SYS_ID(PT_IL_POLICY_BEAN.getPOL_SYS_ID());
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_SERIAL_NO(resultSet.getDouble(1));
			}
			CommonUtils.closeCursor(resultSet);

			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE() != null
					&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ADDL_RISK_CODE() != null) {

				returnValue = localProcudeure.IL_DISC_AGE(
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ADDL_RISK_CODE(),
						PT_IL_POLICY_BEAN.getPOL_START_DT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_DISC_AGE());

				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DISC_AGE(returnValue);

			} else {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DISC_AGE(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE());
			}
			
			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			//"2".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())

			if ("1".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD()) || "2".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())) {
				if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE() != null
						&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ADDL_RISK_CODE() != null) {
					if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1() == null
							&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID2() == null) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91152"));
					}
				}
			}
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_CR_DT(commonUtils.getCurrentDate());
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_CR_UID(commonUtils.getGlobalVariable("CTRL.M_USER_ID"));
			/*Modified by kavitha on 19.07.2018 for FLALIFEQC-1758375 */
			if(PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED()!=null){
			/*End of FLALIFEQC-1758375*/
				if(!(PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED().equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_LC_THRESOLD_LMT()))){
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_LC_THRESOLD_LMT(PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED());
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
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
	}

	public void preUpdate(
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		String CURSOR_C1 = "SELECT NVL(DS_AGE_RECALC_YN,'N') FROM   PM_IL_DOC_SETUP WHERE  DS_CODE = ? ";
		String M_DS_AGE_RECALC_YN = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		Integer returnValue = null;
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_END_CODE() });
			if (resultSet.next()) {
				M_DS_AGE_RECALC_YN = resultSet.getString(1);
			}
			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE() != null
					&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ADDL_RISK_CODE() != null) {

				returnValue = localProcedure.IL_DISC_AGE(
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ADDL_RISK_CODE(),
						PT_IL_POLICY_BEAN.getPOL_START_DT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_DISC_AGE());

				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DISC_AGE(returnValue);
			} else {
				if (PT_IL_POLICY_BEAN.getPOL_END_TYPE() != "002" && "N".equals(M_DS_AGE_RECALC_YN)) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DISC_AGE(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE());
				}
			}
			
			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			//"1".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())

			if ("1".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())||"2".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())) {
				if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1() == null
						&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID2() == null) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91152"));
				}
			}

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_UPD_DT(commonUtils.getCurrentDate());
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_UPD_UID(commonUtils.getGlobalVariable("CTRL.M_USER_ID"));
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

		finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {

			}
		}
	}

	public void whenNewBlockInstance(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POL_ASSURED_DTLS_1_ACTION PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1_ACTION PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN = compositeAction
				.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN();
		PT_IL_POL_ASSR_MED_HIST_1 mediHistory =PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN.getPT_IL_POL_ASSR_MED_HIST_1_BEAN(); 
		BP_ACTION BP_ACTION_BEAN = compositeAction.getBP_ACTION_BEAN();
		PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN();
		DUMMY DUMMY_OCC_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String M_TEMP = null;
		String M_EXISTS = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = ? AND  POAD_TYPE = 'E' ";
		String CURSOR_C2 = "SELECT 'X' FROM PM_IL_DOC_MED_HIST WHERE DMH_DS_TYPE =  ? AND DMH_DS_CODE = ? AND DMH_APPL_ON IN ('E','B')";
		PT_IL_POLICY PT_IL_POLICY_BEAN = PT_IL_POLICY_ACTION_BEAN
				.getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_DELEGATE delegate = new PT_IL_POL_ASSURED_DTLS_1_DELEGATE();
		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();

		try {
			CommonUtils.setGlobalVariable("GLOBAL.M_BLOCK", "2");

			if (DUMMY_OCC_BEAN.getUI_M_CHANGE_SA_YN() == null) {
				DUMMY_OCC_BEAN.setUI_M_CHANGE_SA_YN("N");
			}
			delegate.executeSelectStatement(compositeAction);
			PT_IL_POLICY_ACTION_BEAN.getCOMP_POL_JOINT_LIFE_YN().setDisabled(true);
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_TEMP = resultSet.getString(1);
			}
			if ("X".equals(CommonUtils.nvl(M_TEMP, "Y"))) {
				delegate.executeSelectStatement(compositeAction);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] {PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),PT_IL_POLICY_BEAN.getPOL_DS_CODE()});
			if (resultSet.next()) {
				M_EXISTS = resultSet.getString(1);
				PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_UI_M_BUT_FLEX_FIELDS1().setDisabled(false);
				L_LOAD_MEDICAL_HISTORY_1(PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN,PT_IL_POLICY_BEAN, BP_ACTION_BEAN);
			} else {
				PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_UI_M_BUT_FLEX_FIELDS1().setDisabled(true);
			}

			/*if ("001".equals((CommonUtils.nvl(PT_IL_POLICY_BEAN
					.getPOL_END_TYPE(), "000")))) {
				PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_REF_ID1()
						.setDisabled(false);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {

			}
		}

	}

	public void L_LOAD_MEDICAL_HISTORY_1(
			PT_IL_POL_ASSR_MED_HIST_1_ACTION PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, BP_ACTION BP_ACTION_BEAN)
			throws Exception {

		Integer M_COUNT = null;
		String M_DMH_CAPTION = null;
		String M_DMH_BL_CAPTION = null;
		String M_DMH_DATA_TYPE = null;
		String M_DMH_MANDATORY_YN = null;
		String fieldName = null;
		String paddedString = null;
		java.lang.reflect.Method method = null;
		UIInput input = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils CommonUtils = new CommonUtils();
		PT_IL_POL_ASSR_MED_HIST_1 medHistBean = PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN
				.getPT_IL_POL_ASSR_MED_HIST_1_BEAN();
		String CURSOR_C1 = "SELECT  DMH_CAPTION,DMH_DATA_TYPE,NVL(DMH_MANDATORY_YN,'N')FROM PM_IL_DOC_MED_HIST"
				+ " WHERE   DMH_DS_TYPE = ?  AND  DMH_DS_CODE = ?  AND  DMH_APPL_ON IN ('E','B') AND     ROWNUM  < = 20 ";
		String CURSOR_C2 = "SELECT  DMH_BL_CAPTION,DMH_DATA_TYPE,NVL(DMH_MANDATORY_YN,'N')FROM PM_IL_DOC_MED_HIST"
				+ " WHERE   DMH_DS_TYPE = ? AND  DMH_DS_CODE = ?  AND DMH_APPL_ON IN ('E','B') AND ROWNUM  <=20";
		M_COUNT = 1;

		try {
			connection = CommonUtils.getConnection();
			if ("1".equals(CommonUtils.SUBSTR(CommonUtils.getGlobalVariable(
					"GLOBAL.M_FOR_LANG_CODE"),5, 6))
					|| "ENG".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE"))) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] {
								PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
								PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
				while (resultSet.next()) {
					M_DMH_CAPTION = resultSet.getString(1);
					M_DMH_DATA_TYPE = resultSet.getString(2);
					M_DMH_MANDATORY_YN = resultSet.getString(3);
					paddedString = CommonUtils.lpad(M_COUNT.toString(), 2, "0");
					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
							.getMethod("set" + fieldName, String.class);
					method.invoke(BP_ACTION_BEAN.getBP_BEAN(), M_DMH_CAPTION);
					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_1.class.getMethod("set"
							+ fieldName, String.class);
					method.invoke(medHistBean, M_DMH_DATA_TYPE);
					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_1_ACTION.class.getMethod("get"
							+ fieldName);
					input = (UIInput) method.invoke(PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN);
					if ("Y".equals(M_DMH_MANDATORY_YN)) {
						input.setRequired(true);
					} else {
						input.setRequired(false);
					}

					M_COUNT++;
				}
				CommonUtils.closeCursor(resultSet);
			} else {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] {
								PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
								PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
				while (resultSet.next()) {
					M_DMH_CAPTION = resultSet.getString(1);
					M_DMH_DATA_TYPE = resultSet.getString(2);
					M_DMH_MANDATORY_YN = resultSet.getString(3);
					paddedString = CommonUtils.lpad(M_COUNT.toString(), 2, "0");
					fieldName = "UI_B_PAMH_FIELD_" + paddedString;
					method = BP.class
							.getMethod("set" + fieldName, String.class);
					method.invoke(BP_ACTION_BEAN.getBP_BEAN(), M_DMH_CAPTION);

					fieldName = "PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_1.class.getMethod("set"
							+ fieldName, String.class);
					method.invoke(medHistBean, M_DMH_DATA_TYPE);

					fieldName = "COMP_PAMH_FIELD_" + paddedString;
					method = PT_IL_POL_ASSR_MED_HIST_1_ACTION.class.getMethod("get"
							+ fieldName);
					input = (UIInput) method.invoke(PT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN);
					if ("Y".equals(M_DMH_MANDATORY_YN)) {
						input.setRequired(true);
					} else {
						input.setRequired(false);
					}

					M_COUNT++;
				}
				CommonUtils.closeCursor(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
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

	}

	public void whenNewRecordInstance(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_ASSURED_DTLS_1_ACTION PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_1_DELEGATE delegate = new PT_IL_POL_ASSURED_DTLS_1_DELEGATE();
		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		try {
			delegate.executeSelectStatement(compositeAction);
			if ("A".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN
					.getPOL_APPRV_STATUS(), "N"))) {
				PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_REF_ID1().setDisabled(true);
				PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_REF_ID1().setDisabled(true);
			}
			if ("Y".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_SMOKE_YN())) {
				PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setDisabled(true);
				PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setDisabled(false);
			} else {
				PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setDisabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void whenCreateRecord(
			PT_IL_POL_ASSURED_DTLS_1_ACTION PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN,PILT002_APAC_COMPOSITE_ACTION compositeAction ) throws Exception {

		String M_TYPE = null;
		String M_DESC = null;
		String M_DESC_BL = null;
		String M_REL_DESC = null;
		String M_REL_DESC_BL = null;
		String M_PC_CODE = null;
		String passno = null;
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		ArrayList<String> list = null;
		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		String CURSOR_C1 = "SELECT  PC_CODE,PC_DESC,PC_BL_DESC FROM   PM_CODES WHERE  PC_TYPE =  ?  "
				+ "AND   PC_VALUE = 1 AND  NVL(PC_FRZ_FLAG,'N') != 'Y' ";
		

		if (!"KIC".equals(CommonUtils.getGlobalVariable("GLOBAL.M_SITE"))) {
			 
				PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ASSR_CODE(PT_IL_POLICY_BEAN.getPOL_CONT_CODE());
				PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setPOAD_ASSURED_NAME(PT_IL_POLICY_BEAN
								.getPOL_ASSURED_NAME());
			 
		}

		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE_PROOF_FLAG("0");
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_TYPE("E");
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEIGHT_UNIT("C");
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_WEIGHT_UNIT("K");
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_SMOKE_YN("N");
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_POL_OWNER_YN("N");

		if ("N".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_SMOKE_YN())) {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_NO_OF_CIGAR(0);
		} else if (!("N".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_SMOKE_YN()))) {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_NO_OF_CIGAR(1);

		}
		if ("Y".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN())) {
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_TYPE()
					.setRendered(true);
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_TYPE()
					.setDisabled(false);
		} else {
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_TYPE()
					.setDisabled(true);
		}
		/*PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_AGE().setDisabled(
				true);*/
		M_TYPE = "NATLITY";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { M_TYPE });
			if (resultSet.next()) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_NATIONALITY(resultSet
						.getString(1));
				M_DESC = resultSet.getString(2);
				M_DESC_BL = resultSet.getString(3);
			}
			CommonUtils.closeCursor(resultSet);
			M_TYPE = "RELIGION";
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { M_TYPE });
			if (resultSet.next()) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_RELIGION_CODE(resultSet
						.getString(1));
				M_REL_DESC = resultSet.getString(2);
				M_REL_DESC_BL = resultSet.getString(3);
			}
			if ("1".equals(CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"))
					|| "ENG".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE"))) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_NATLITY_DESC(M_DESC);
				PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setUI_M_POAD_REL_CODE_DESC(M_REL_DESC);
			} else {
				PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setUI_M_POAD_NATLITY_DESC(M_DESC_BL);
				PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setUI_M_POAD_REL_CODE_DESC(M_REL_DESC_BL);
			}
			CommonUtils.closeCursor(resultSet);
			M_TYPE = "RACE";
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { M_TYPE });
			if (resultSet.next()) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_RACE(resultSet.getString(1));
				M_DESC = resultSet.getString(2);
				M_DESC_BL = resultSet.getString(3);
			}
			if ("1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"))
					|| "ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"))) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_RACE_CODE_DESC(M_DESC);

			} else {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_RACE_CODE_DESC(M_DESC_BL);

			}
			CommonUtils.closeCursor(resultSet);
			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_OCC_CODE() == null) {
				list = localProcedure.P_DISP_OCCU_CODE_AND_CLASS(
						CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_TYPE(),"X"),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_OCC_CODE()),
						PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),compositeAction);
				if (list != null && !list.isEmpty()) {
					if (list.get(1) != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_OCC_DESC(list.get(1));
					}
				}
			}
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_LC_THRESOLD_LMT(PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED());
			compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getCOMP_UI_M_POAD_LC_THRESOLD_LMT().setValue(PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED());
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {

			}
		}
	}

	public void postQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		Double M_VALUE = 0.0d;
		Double MS_POAD_LC_THRESHOLD_LIMIT = 0.0d;
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;
		ArrayList<String> list3 = null;
		ArrayList<String> list4 = null;
		ArrayList<String> list5 = null;
		ArrayList<String> list6 = null;
		ArrayList<String> list7 = null;
		ArrayList<String> list8 = null;
		ArrayList<String> list9 = null;
		ArrayList<String> list10 = null;
		ArrayList<String> pvalList = null;
		DBProcedures procedures = new DBProcedures();
		try {
			list = procedures.P_VAL_CODES("RACE", PT_IL_POL_ASSURED_DTLS_1_BEAN
					.getPOAD_RACE(), PT_IL_POL_ASSURED_DTLS_1_BEAN
					.getUI_M_POAD_RACE_CODE_DESC(), "N", "N", null);
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_RACE_CODE_DESC(list.get(0));
				}
			}
					
			list1 = procedures.P_VAL_CODES("IL_OCC_CLASS", PT_IL_POL_ASSURED_DTLS_1_BEAN
					.getPOAD_OCC_CLASS(), PT_IL_POL_ASSURED_DTLS_1_BEAN
					.getUI_M_POAD_OCC_CLASS_DESC(), "N", "N", null);
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null ) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_OCC_CLASS_DESC(list1.get(0));
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().
					   getCOMP_UI_M_POAD_OCC_CLASS_DESC().setValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_OCC_CLASS_DESC());
				}
			}
					

			list2 = DBProcedures.P_VAL_SYSTEM("MARI_STAT",
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_MAR_STATUS(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_MS_DESC(), "N",
					CommonUtils.getProcedureValue(M_VALUE));
			if (list2 != null && !list2.isEmpty()) {
				if (list2.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_MS_DESC(list2.get(0));
				}
			}

			list3 = procedures.P_VAL_CODES("IL_ADDL_RISK",
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ADDL_RISK_CODE(),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_ADDL_RISK_DESC()),
					"N", "N", null);
			if (list3 != null && !list3.isEmpty() ) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_ADDL_RISK_DESC(list3.get(0));
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().
				   getCOMP_UI_M_ADDL_RISK_DESC().setValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_ADDL_RISK_DESC());
			}
				

			list4 = procedures.P_VAL_CODES("NATLITY",
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_NATIONALITY(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_NATLITY_DESC(),
					"N", "N", null);
			if (list4 != null && !list4.isEmpty()) {
				if (list4.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_NATLITY_DESC(list4.get(0));
				}
			}
					

			list5 = procedures.P_VAL_CODES("IL_OCCU",
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_OCC_CODE(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_OCC_DESC(), "N",
					"N", null);
			if (list5 != null && !list5.isEmpty()) {
				if (list5.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_OCC_DESC(list5.get(0));
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().
					   getCOMP_UI_M_POAD_OCC_DESC().setValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_OCC_DESC());
				}
			}
					

			list6 = procedures.P_VAL_CODES("IL_HLTH_ST",
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEALTH_CODE(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_HEALTH_DESC(),
					"N", "N", null);
			if (list6 != null && !list6.isEmpty()) {
				if (list6.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_HEALTH_DESC(list6.get(0));
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().
					   getCOMP_UI_M_POAD_HEALTH_DESC().setValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_HEALTH_DESC());
				}
			}
					

			list7 = DBProcedures.P_VAL_SYSTEM("CATG",
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_CATG_DESC(),
					"N", DUMMY_OCC_BEAN.getUI_M_PS_VALUE_DUMMY());
			if (list7 != null && !list7.isEmpty()) {
				if (list7.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_CATG_DESC(list7.get(0));
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().
					   getCOMP_UI_M_POAD_CATG_DESC().setValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_CATG_DESC());
				}
				
			}
					
					

			list8 = procedures.P_VAL_CODES("RELIGION",
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_RELIGION_CODE(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_REL_CODE_DESC(),
					"N", "N", null);
			if (list8 != null && !list8.isEmpty()) {
				if (list8.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_REL_CODE_DESC(list8.get(0));
				}
			}
			list9 = procedures.P_VAL_CODES("ILBENFREL", PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_RELATION_CODE()
					, PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_REL_CODE_DESC()
					, "N", "N", null);
			
			if(!list9.isEmpty() && list9.get(0)!=null ){
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_REL_CODE_DESC(list9.get(0));	
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getCOMP_UI_M_POAD_RELATION_DESC().setValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_REL_CODE_DESC());
			}
		
			if ("Y".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_FRZ_FLAG(),"X"))) {
				list10 = procedures.callCALC_ASSRD_THRESHOLD_LIMIT(
						CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_SYS_ID()));
				if (list10 != null && !list10.isEmpty()) {
					if (list10.get(0) != null) {
						MS_POAD_LC_THRESHOLD_LIMIT = Double.parseDouble(list10.get(0));
					}
				}
						
				PT_IL_POL_ASSURED_DTLS_1_BEAN
						.setUI_M_POAD_LC_THRESOLD_LMT(CommonUtils.nvl(
								MS_POAD_LC_THRESHOLD_LIMIT, 0));
			}
		
		
			
		
				DBProcedures proce = new DBProcedures();
				ArrayList<String> list13 = new ArrayList<String>();
				Double MS_POAD_LC_THRESHOLD_LIMITs = 0.0;
				list13 = new ArrayList<String>();
				list13 = proce.callCALC_ASSRD_THRESHOLD_LIMIT(CommonUtils
						.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN
								.getPOAD_SYS_ID()));
				if (list13 != null && !list13.isEmpty()) {
					if (list13.get(0) != null) {
						MS_POAD_LC_THRESHOLD_LIMITs = Double.parseDouble(list13
								.get(0));
					}

				}
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_LC_THRESOLD_LMT(CommonUtils
						.nvl(MS_POAD_LC_THRESHOLD_LIMITs, 0));
			
			//PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_LC_THRESOLD_LMT(PT_IL_POLICY_BEAN.getPOL_LC_SUM_ASSURED());	
			compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getCOMP_UI_M_POAD_LC_THRESOLD_LMT().setValue(MS_POAD_LC_THRESHOLD_LIMITs);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public String postInsert(PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_BEAN, 
				PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {

		String M_THRESHOLD_MESSAGE = null;
		//DBProcedures procedures = new DBProcedures();
		P9ILPK_POLICY p9ilpkPolicy = new P9ILPK_POLICY();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String Query = "SELECT P9ILPK_POLICY.F_GET_THR_LIMIT_MSG FROM DUAL";
		String Query1 = "SELECT  'X' FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE = ?" +
				" AND PAC_COVER_ASSR_TYPE IN ('E','B')";
		
		try {
		     connection = CommonUtils.getConnection();
		     resultSet = handler.executeSelectStatement(Query1, connection, new Object[]{PT_IL_POLICY_BEAN.getPOL_PROD_CODE()});
		    // 'NR' for normal policy and 'PG' for package policy using  menu parameter_18
		    	if ("NR".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
		    		if(resultSet.next()){
		    	new P9ILPK_POLICY_NR().P_INS_ADDL_COVER(
					PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
					PT_IL_POLICY_BEAN.getPOL_PROD_CODE(),
					DUMMY_BEAN.getUI_M_CHANGE_SA_YN());	
		    		}
				
			 } else if ("PG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
			     p9ilpkPolicy.P_DFLT_APPL_PROD(PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
    				    PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_SYS_ID(),
    	                            PT_IL_POLICY_BEAN.getPOL_PROD_GROUP_CODE());
			 }
			
		
				if ("A".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_APPRV_STATUS(), "N"))
						&& CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(), 0) == 0) {
					p9ilpkPolicy.callP_INS_DISC_LOAD(
							PT_IL_POLICY_BEAN.getPOL_PROD_CODE(), 
							CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SYS_ID()),
							PT_IL_POLICY_BEAN.getPOL_START_DT());
				}
		
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new Exception(e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new Exception(e1.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return M_THRESHOLD_MESSAGE;
	}

	public void onPopulateDetails(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String Relation = null;
		Long POAD_SYS_ID = null;
		Long POAD_POL_SYS_ID = null;

		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		POAD_SYS_ID = PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_SYS_ID();
		POAD_POL_SYS_ID = PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_POL_SYS_ID();
		try {
			if ((POAD_SYS_ID != null) || (POAD_POL_SYS_ID != null)) {
				PT_IL_POL_ASSR_MED_HIST_DELEGATE delegate = new PT_IL_POL_ASSR_MED_HIST_DELEGATE();
				delegate.executeSelectStatement(POAD_SYS_ID, POAD_POL_SYS_ID,
						compositeAction);
			}
			if ((POAD_SYS_ID != null) || (POAD_POL_SYS_ID != null)) {
				PT_IL_POL_MED_EXAM_DTL_DELEGATE delegate = new PT_IL_POL_MED_EXAM_DTL_DELEGATE();
				delegate.executeSelectStatement(POAD_SYS_ID, POAD_POL_SYS_ID,
						compositeAction);
			}
			if ((POAD_SYS_ID != null) || (POAD_POL_SYS_ID != null)) {
				PT_IL_POL_ASSR_ILLNESS_DTLS_DELEGATE delegate = new PT_IL_POL_ASSR_ILLNESS_DTLS_DELEGATE();
				delegate.executeSelectStatement(POAD_SYS_ID, POAD_POL_SYS_ID,
						compositeAction);
			}

			if ((POAD_SYS_ID != null) || (POAD_POL_SYS_ID != null)) {
			    PT_IL_POL_APPL_PROD_DELEGATE delegate = new PT_IL_POL_APPL_PROD_DELEGATE();
				delegate.executeSelectStatement( compositeAction );
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public void preDelete(PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {
		Long POAD_SYS_ID = PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_SYS_ID();
		Long POAD_POL_SYS_ID = PT_IL_POL_ASSURED_DTLS_1_BEAN
				.getPOAD_POL_SYS_ID();
		PT_IL_POL_ADDL_COVER_DELEGATE delegate4 = new PT_IL_POL_ADDL_COVER_DELEGATE();
		PT_IL_POL_ASSR_ILLNESS_DTLS_DELEGATE delegate3 = new PT_IL_POL_ASSR_ILLNESS_DTLS_DELEGATE();
		PT_IL_POL_MED_EXAM_DTL_DELEGATE delegate2 = new PT_IL_POL_MED_EXAM_DTL_DELEGATE();
		PT_IL_POL_ASSR_MED_HIST_DELEGATE delegate1 = new PT_IL_POL_ASSR_MED_HIST_DELEGATE();
		try {
			delegate1.deleteRecord(POAD_SYS_ID,POAD_POL_SYS_ID);
			delegate2.deleteRecord(POAD_SYS_ID,POAD_POL_SYS_ID);
			delegate3.deleteRecord(POAD_SYS_ID,POAD_POL_SYS_ID);
			delegate4.deleteRecord(POAD_SYS_ID,POAD_POL_SYS_ID);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void preQuery(
			PT_IL_POL_ASSURED_DTLS_1_ACTION PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN) {
		Long POL_SYS_ID = PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_POL_SYS_ID();
		PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN
				.setDEFAULT_WHERE("POAD_TYPE = 'R' AND POAD_POL_SYS_ID  = "
						+ POL_SYS_ID + "");
	}

	public void POAD_ASSR_CODE_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		Integer M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_EXIST1 = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] value = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_STATUS PT_IL_POL_STATUS_BEAN = compositeAction
				.getPT_IL_POL_STATUS_ACTION_BEAN().getPT_IL_POL_STATUS_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		DUMMY DUMMY_OCC_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String CURSOR_C1 = "SELECT  COUNT(POAD_SYS_ID) FROM  PT_IL_POL_ASSURED_DTLS WHERE  POAD_POL_SYS_ID = ? ";
		String CURSOR_C3 = "SELECT PS_CODE FROM   PP_SYSTEM  WHERE  PS_TYPE = 'IL_HIV_CODE'";
		String CURSOR_C4 = "SELECT 'X' FROM  PT_IL_POL_ASSURED_DTLS,PT_IL_POL_STATUS WHERE  POAD_POL_SYS_ID = ? "
				+ "AND POAD_ASSR_CODE  =  ?  AND PS_STATUS = 'C' AND  PS_REASON_CODE  = ? ";
		String CURSOR_C5 ="SELECT CONT_REF_ID1,CONT_PASS_NO FROM PM_IL_CONTRACTOR WHERE CONT_CODE = ?";
		
		/*Added by Janani on 02.05.2018 for Fidelity as suggested by Vinoth*/

		String CURSOR_C6 = "SELECT CUST_NATIONALITY_CODE,CUST_CATG_CODE,CUST_DOB,CUST_OCC_CODE,CUST_AGE_ADMITTED,"
				+ "CUST_AGE_PROOF_FLAG,CUST_NATIONALITY_CODE,CUST_OCC_CODE FROM PM_CUSTOMER WHERE CUST_CODE = ?";

		String CURSOR_C7 = "SELECT PC_DESC FROM PM_CODES WHERE PC_CODE = ? AND PC_TYPE LIKE 'IL_OCC%'";
		
		String CURSOR_C8 = "SELECT PC_DESC FROM PM_CODES WHERE PC_CODE= ? AND PC_TYPE LIKE 'NATLITY%'";
		
		String CURSOR_C9 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_OCC_CLASS' AND PC_VALUE = (SELECT PC_VALUE FROM PM_CODES"
				+ " WHERE PC_TYPE = 'IL_OCCU' AND PC_CODE = (SELECT CUST_OCC_CODE FROM PM_CUSTOMER WHERE CUST_CODE = ?))";
		
		ArrayList<String> list3 = null;
		
		
		/*End*/
		
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection);
			if (resultSet.next()) {
				M_PS_CODE = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			value = new Object[] { PT_IL_POL_STATUS_BEAN.getPS_POL_SYS_ID(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ASSR_CODE(),M_PS_CODE };
			resultSet = handler.executeSelectStatement(CURSOR_C4, connection,value);
			if (resultSet.next()) {
				M_DUMMY1 = resultSet.getString(1);
			}
			if ("X".equals(M_DUMMY1)) {
				throw new Exception(Messages
						.getString(PELConstants.pelErrorMessagePath, "91111",
								new Object[] { M_PS_CODE }));
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getInt(1);
			}

			if ("Y".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN())) {
				if (M_DUMMY > 2) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71211"));
				}
			} else {
				if (M_DUMMY > 1) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71212"));
				}
			}

			if (PT_IL_POLICY_BEAN.getPOL_CONT_CODE() != null) {
				IL_UNIQUE_POL_ASSR_CODE(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ASSR_CODE());
			}
			
			//COMMENTED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			
			/*if ("2".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())) {
				ArrayList<String> list3 = localProcedure.IL_POAD_GET_ASSR_DTLS(
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ASSR_CODE(), "N",
						null, null, DUMMY_OCC_BEAN.getUI_M_DUMMY(), "R",compositeAction);
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						M_EXIST1 = list3.get(0);
					}
				}
			}*/
			ResultSet resultset5 = handler.executeSelectStatement(CURSOR_C5, connection, new Object[]{compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_ASSR_CODE()}); 			
			if(resultset5.next()){
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_REF_ID1(resultset5.getString(1));
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_REF_ID2(resultset5.getString(2));
				}
			
			/*Added by Janani on 02.05.2018 for Fidelity as suggested by Vinoth*/
			ResultSet resultset6 = handler.executeSelectStatement(CURSOR_C6, connection, new Object[]{compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().
					getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_ASSR_CODE()}); 			
			if(resultset6.next()){
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_NATIONALITY(resultset6.getString("CUST_NATIONALITY_CODE"));
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_CATG_CODE(resultset6.getString("CUST_CATG_CODE"));
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_DOB(resultset6.getDate("CUST_DOB"));
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_OCC_CODE(resultset6.getString("CUST_OCC_CODE"));
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_AGE_PROOF_FLAG(resultset6.getString("CUST_AGE_PROOF_FLAG"));
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_NATIONALITY(resultset6.getString("CUST_NATIONALITY_CODE"));
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_OCC_CODE(resultset6.getString("CUST_OCC_CODE"));
			}
			
			
			
			ResultSet resultset7 = handler.executeSelectStatement(CURSOR_C7, connection, new Object[]{compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().
					getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_OCC_CODE()}); 			
			if(resultset7.next()){
				
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setUI_M_POAD_OCC_DESC(resultset7.getString("PC_DESC"));
			}
			
			ResultSet resultset8 = handler.executeSelectStatement(CURSOR_C8, connection, new Object[]{compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().
					getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_NATIONALITY()}); 			
			if(resultset8.next()){
				
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setUI_M_POAD_NATLITY_DESC(resultset8.getString("PC_DESC"));
			}
			

			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE() != null) {
				list3 = DBProcedures.P_VAL_SYSTEM(
						"CATG",
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_CATG_DESC(),
						"E",null);
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_CATG_DESC(list3.get(0));
					}
					
				}
			}
			
			
			ResultSet resultset9 = handler.executeSelectStatement(CURSOR_C9, connection, new Object[]{compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().
					getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_ASSR_CODE()}); 			
			if(resultset9.next()){
				
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_OCC_CLASS(resultset9.getString("PC_CODE"));
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setUI_M_POAD_OCC_CLASS_DESC(resultset9.getString("PC_DESC"));
			}
			
			/*End*/
			
			/*Added by Janani on 04.06.2018 for Fidelity as suggested by Sivaram to default
			 age and disc age from assured name tab out	 */
			
			POAD_DOB_WHEN_VALIDATE_ITEM(compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().
					getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_DOB(), compositeAction.
					getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN(), compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
							.getDUMMY_BEAN());
			
			/*End*/
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {

			}
		}
	}

	public void IL_UNIQUE_POL_ASSR_CODE(String P_ASSR_CODE) {

		/*
		 * String M_ASSR_CODE = null;
		 * 
		 * String CURSOR_C1 = "SELECT 'X' FROM PT_IL_POL_ASSURED_DTLS WHERE
		 * POAD_ASSR_CODE = PT_IL_POL_ASSURED_DTLS.POAD_ASSR_CODE AND
		 * POAD_POL_SYS_ID = PT_IL_POLICY.POL_SYS_ID; BEGIN IF C1%ISOPEN THEN
		 * CLOSE C1; END IF; OPEN C1; FETCH C1 INTO M_ASSR_CODE; IF C1%FOUND
		 * THEN STD_MESSAGE_ROUTINE(71216,NAME_IN('GLOBAL.M_LANG_CODE')); CLOSE
		 * C1; RAISE FORM_TRIGGER_FAILURE; END IF; CLOSE C1;
		 */

	}

	public void POAD_REF_ID1_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_ASSURED_DTLS_1_ACTION  assuredAction1) throws Exception {

		Integer M_DUMMY = null;
		
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY DUMMY_OCC_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = assuredAction1.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		Integer M_LENGTH_1 = null;
		Integer M_GENDER = null;
		Integer M_NEW_IC_NO = null;
		Integer M_REF_ID_1_LENGTH = assuredAction1.getCOMP_POAD_REF_ID1()
				.getMaxlength();
		Integer M_NEW_IC_NO_LENGTH = 0;
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_PS_VALUE = null;
		String M_DATE_CHAR = null;
		String M_VALUE = null;
		String M_EXIST = null;
		String M_CONT_REF_ID1 = null;
		Date M_TEMP_DATE = null;
		String M_CUST_VALID = null;
		String M_CODE_DESC = null;
		String M_CUST_REF_ID1 = null;
		String M_POAD_REF_ID1 = null;

		Connection connection = null;
		ResultSet resultSet = null;
		Object[] value = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC localProcudeure = new PKG_PILT002_APAC();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list3 = null;
		
		String CURSOR_C1 = "SELECT  COUNT(POAD_SYS_ID) FROM    PT_IL_POL_ASSURED_DTLS WHERE   POAD_POL_SYS_ID = ? ";
		String CURSOR_C3 = "SELECT SUBSTR(POAD_REF_ID1,1,6) FROM   PT_IL_POL_ASSURED_DTLS "
				+ "WHERE  POAD_POL_SYS_ID = ? AND    POAD_SYS_ID =  ? ";
		String CURSOR_C2 = "SELECT SUBSTR( ? ,1,6) FROM DUAL";

		try {
			connection = CommonUtils.getConnection();
			list = DBProcedures.P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_1",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_NEW_IC_NO_LENGTH));
			M_CODE_DESC = list.get(0);
			M_NEW_IC_NO_LENGTH = Integer.parseInt(list.get(1));
			M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,
					M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);
			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1().length() > M_LENGTH_1) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91240",
						new Object[] {
								CommonUtils
										.getGlobalVariable("CTRL.M_LANG_CODE"),
								M_LENGTH_1 }));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getInt(1);
			}
			if ("Y".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN())
					&& ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) || ("2"
							.equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) && PT_IL_POLICY_BEAN
							.getPOL_END_NO_IDX() == 0))) {
				if (M_DUMMY > 2) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71211"));
				}
			} else if ("N".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN())
					&& ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) || ("2"
							.equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) && PT_IL_POLICY_BEAN
							.getPOL_END_NO_IDX() == 0))) {
				if (M_DUMMY > 1) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71212"));
				}
			}
			
			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			//"2".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())
			
			if (("1".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD()) || "2".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD()))
					&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1() != null
					&& "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
					|| ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) && PT_IL_POLICY_BEAN
							.getPOL_END_NO_IDX() == 0)) {
				M_EXIST = "N";
				/*ArrayList<String> list4 = localProcudeure.IL_POAD_GET_ASSR_DTLS(
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ASSR_CODE(), "N",
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID2(),
						M_EXIST, "E", compositeAction);
				if (list4 != null  && !list4.isEmpty()) {
					if (list4.get(0) != null) {
						M_EXIST = list4.get(0);
					}
				}*/
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_TYPE("E");
				assuredAction1.getCOMP_POAD_REF_ID2().setRequired(false);

			}
			CommonUtils.closeCursor(resultSet);
			list1 = DBProcedures.P_VAL_SYSTEM("CUSTREFFMT", "CUSTREFFMT",
					M_CODE_DESC, "N", M_PS_VALUE);
			M_CODE_DESC = list1.get(0);
			M_PS_VALUE = list1.get(1);
			if ("1".equals(M_PS_VALUE)) {
				if (CommonUtils.nvl(M_EXIST, "N") != "Y"
						&& "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
						|| ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) && PT_IL_POLICY_BEAN
								.getPOL_END_NO_IDX() == 0)
						|| ("001".equals(PT_IL_POLICY_BEAN.getPOL_END_TYPE()))) {
					resultSet = handler.executeSelectStatement(CURSOR_C3,
							connection, new Object[] {
									PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
									PT_IL_POL_ASSURED_DTLS_1_BEAN
											.getPOAD_SYS_ID() });
					if (resultSet.next()) {
						M_NEW_IC_NO = resultSet.getInt(1);
					}
					CommonUtils.closeCursor(resultSet);
					M_CUST_REF_ID1 = PT_IL_POL_ASSURED_DTLS_1_BEAN
							.getPOAD_REF_ID1();
					try {
						resultSet = handler.executeSelectStatement(CURSOR_C2,
								connection, new Object[] { M_CUST_REF_ID1 });
						if (resultSet.next()) {
							M_DATE_CHAR = resultSet.getString(1);
						}
						CommonUtils.closeCursor(resultSet);

						if ("001".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN
								.getPOL_END_TYPE(), "000"))) {
							if (!M_NEW_IC_NO.equals(Integer
									.parseInt(M_DATE_CHAR))) {
								throw new Exception();
							}
						}
						String query = "SELECT TO_CHAR(TO_DATE(?,'RRMMDD'),'dd/MM/RRRR') FROM DUAL";
						resultSet = handler.executeSelectStatement(query, connection,new Object[]{M_DATE_CHAR});
						if(resultSet.next()) {
							M_DATE_CHAR = resultSet.getString(1);
						}
						CommonUtils.closeCursor(resultSet);
						M_TEMP_DATE = CommonUtils.stringToPelUtilDate(M_DATE_CHAR);
						if (CommonUtils.getYearFromDate(M_TEMP_DATE) > CommonUtils
								.getYearFromDate(commonUtils.getCurrentDate())) {
							String temp1 = CommonUtils.dateToStringFormatter(CommonUtils.addMonthsToDate(M_TEMP_DATE, -1200));
							M_TEMP_DATE = CommonUtils.newStringToDate(temp1);
							PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DOB(M_TEMP_DATE);
						} else {
							PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DOB(M_TEMP_DATE);
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91173"));
					}
					try {
						
						M_GENDER = Integer.parseInt(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1().substring(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1().length()-1,PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1().length()));
					} catch (Exception e) {
						e.printStackTrace();
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91173"));
					}

					if (M_GENDER % 2 == 0) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_CATG_CODE("2");
					} else {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_CATG_CODE("1");
					}
					if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE() != null) {
						list3 = DBProcedures.P_VAL_SYSTEM(
								"CATG",
								PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
								PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_CATG_DESC(),
								"E",M_VALUE);
						if (list3 != null && !list3.isEmpty()) {
							if (list3.get(0) != null) {
								PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_CATG_DESC(list3.get(0));
							}
							if (list3.get(1) != null) {
								M_VALUE = list3.get(1);
							}
						}
					}
					/*
					 * Commented By Sujatha to fix the issue, i.e to avoid resetting the pol period 
					 * after coming from Payor details block
					 */
					/*localProcudeure.P_CAL_PLAN_PERIOD(
							PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_DOB(),
							PT_IL_POL_ASSURED_DTLS_BEAN,
							PT_IL_POL_ASSURED_DTLS_1_BEAN, PT_IL_POLICY_BEAN,
							DUMMY_OCC_BEAN);*/
				}
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

			}
		}
	}

	public void POAD_REF_ID2_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		DUMMY DUMMY_OCC_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Integer M_DUMMY = null;
		Integer M_OLD_IC_NO_LENGTH = null;
		Integer M_LENGTH_2 = null;
		Integer M_REF_ID2_LENGTH = null;
		String M_DUMMY1 = null;
		String M_EXIST = null;
		String M_PS_CODE = null;
		String M_CODE_DESC = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;
		String LENTH_QUERY = "SELECT X FROM USER_TAB_COLUMNS WHERE TABLE_NAME = PT_IL_POL_ASSURED_DTLS AND COLUMN_NAME = POAD_REF_ID2";
		String CURSOR_C1 = "SELECT  COUNT(POAD_SYS_ID) FROM    PT_IL_POL_ASSURED_DTLS WHERE   POAD_POL_SYS_ID = ? ";
		try {

			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(LENTH_QUERY, connection);
			if (resultSet.next()) {
				M_REF_ID2_LENGTH = resultSet.getInt("X");
			}
			CommonUtils.closeCursor(resultSet);

			list = DBProcedures.P_VAL_SYSTEM(
					"LEN_REF_ID", "REF_ID_2",
					CommonUtils.getProcedureValue(M_CODE_DESC), 
					"N",CommonUtils.getProcedureValue(M_OLD_IC_NO_LENGTH));
			M_LENGTH_2 = Math.min(CommonUtils.nvl(M_OLD_IC_NO_LENGTH,
					M_REF_ID2_LENGTH), M_REF_ID2_LENGTH);
			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID2().length() > M_LENGTH_2) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91240"));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getInt(1);
			}
			if ("Y".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN())
					&& ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) 
							|| ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) 
							&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0))) {
				if (M_DUMMY > 2) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71211"));
				}
			} else if ("N".equals(PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN())
					&& ("1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
							|| ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) 
							&& PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0))) {
				if (M_DUMMY > 1) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71212"));
				}
			}
			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			//"2".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())
			
			if (("1".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())||"2".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD()))
					&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1() == null
					&& "1".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE())
					|| ("2".equals(PT_IL_POLICY_BEAN.getPOL_DS_TYPE()) && PT_IL_POLICY_BEAN.getPOL_END_NO_IDX() == 0)) {
				list1 = localProcedure.IL_POAD_GET_ASSR_DTLS(
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ASSR_CODE(),"N",
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID2(),
						M_EXIST, "E", compositeAction);
				if (list != null && !list.isEmpty()) {
					M_EXIST = list.get(1);
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_TYPE("E");
				}
					
			}
			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			//"2".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())
			
			if ("1".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD()) || "2".equals(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD())) {
				if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID1() == null && PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_REF_ID2() == null) {
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getCOMP_POAD_REF_ID2().setRequired(true);
				}
			}
			/*localProcedure.P_CAL_PLAN_PERIOD(
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_DOB(),
					PT_IL_POL_ASSURED_DTLS_BEAN,
					PT_IL_POL_ASSURED_DTLS_1_BEAN,
					PT_IL_POLICY_BEAN,
					DUMMY_OCC_BEAN);*/

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
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

	}

	public void POAD_TYPE_WHEN_LIST_CHANGED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();

		try {
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = compositeAction
					.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_OCC_CODE() == null) {
				localProcedure.P_DISP_OCCU_CODE_AND_CLASS(
						CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_TYPE(),"X"),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_OCC_CODE(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE(),compositeAction);
			}
			if (!("E".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_TYPE() ))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206"));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String POAD_CATG_CODE_WHEN_VALIDATE_ITEM(String POAD_CATG_CODE)
			throws Exception {

		Integer M_VALUE = null;
		String M_POAD_CATG_DESC = null;
		ArrayList<String> list = null;
		try {
			if (POAD_CATG_CODE != null) {
				list = DBProcedures.P_VAL_SYSTEM(
						"CATG", 
						POAD_CATG_CODE,
						M_POAD_CATG_DESC, "E", 
						CommonUtils.getProcedureValue(M_VALUE));
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						M_POAD_CATG_DESC = list.get(0);
					}
					if (list.get(1) != null) {
						M_VALUE = Integer.parseInt(list.get(1));
					}
				}
			} else {
				M_POAD_CATG_DESC = null;
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return M_POAD_CATG_DESC;

	}
	
	
	public void POAD_CATG_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_ASSURED_DTLS_1 assuredBean) throws Exception {

		Integer M_VALUE = 0;

		ArrayList<String> list = new ArrayList<String>();
		try {
			if (assuredBean.getPOAD_CATG_CODE() != null) {
				list = DBProcedures.P_VAL_SYSTEM("CATG", assuredBean
						.getPOAD_CATG_CODE(), assuredBean
						.getUI_M_POAD_CATG_DESC(), "E", CommonUtils
						.getProcedureValue(M_VALUE));
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						assuredBean.setUI_M_POAD_CATG_DESC(list.get(0));
					}
					if (list.get(1) != null) {
						M_VALUE = Integer.parseInt(list.get(1));
					}
				}

			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}


	public void POAD_DOB_WHEN_VALIDATE_ITEM(Date  POAD_DOB,
			PT_IL_POL_ASSURED_DTLS_1_ACTION assuredAction,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY policyBean, DUMMY dummy_occ) throws Exception {

		Integer M_DUM_VALUE = null;
		String M_DUM_DESC = null;
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = assuredAction
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		ArrayList<String> list = null;
		ArrayList<OracleParameter> list1 = null;
		ArrayList<String> list3 = null;
		CommonUtils commonUtils = new CommonUtils();
		try {
			if (POAD_DOB.after(commonUtils.getCurrentDate())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71030"));
			}
			if (POAD_DOB != null) {
				if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(2, 3))) {
					assuredAction.getCOMP_POAD_AGE().setDisabled(false);
				}
				assuredAction.getCOMP_POAD_AGE().setDisabled(false);
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE(0);
				list = DBProcedures.P_VAL_SYSTEM("IL_AGE_CAL", "IL_AGE_CAL",
						CommonUtils.getProcedureValue(M_DUM_DESC), "N",
						CommonUtils.getProcedureValue(M_DUM_VALUE));
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						M_DUM_DESC = list.get(0);
					}
					if (list.get(1) != null) {
						M_DUM_VALUE = Integer.parseInt(list.get(1));
					}
				}
						
						
				if (M_DUM_VALUE == 1) {
					if (policyBean.getPOL_START_DT().before(POAD_DOB)) {
						throw new Exception(Messages.getString("messageProperties_PILT002_APAC","IL_001"));
					}
					list1 = localProcedure.P_CALC_ANB(
							policyBean.getPOL_START_DT(),
							POAD_DOB, 
							dummy_occ.getUI_M_PROD_AGE_CALC_FLAG(),
							PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE());
					if (list1 != null && !list1.isEmpty()) {
						if (list1.get(0) != null) {
							PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE((Integer)list1.get(0).getValueObject());
						}
					}
				} else {
					if (policyBean.getPOL_ISSUE_DT().before(POAD_DOB)) {
						throw new Exception(Messages.getString("messageProperties_PILT002_APAC","IL_001"));
					}
					list1 = localProcedure.P_CALC_ANB(
							policyBean.getPOL_START_DT(),
							POAD_DOB, 
							dummy_occ.getUI_M_PROD_AGE_CALC_FLAG(),
						  PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE());
					if (list1 != null && !list1.isEmpty()) {
						if (list1.get(0) != null) {
							PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE((Integer)list1.get(0).getValueObject());
						}
					}
				}
							
              //  if(policyBean.getPOL_PERIOD() == null){
				/*localProcedure.P_CAL_PLAN_PERIOD(
						POAD_DOB,
						PT_IL_POL_ASSURED_DTLS_BEAN,
						PT_IL_POL_ASSURED_DTLS_1_BEAN, policyBean,
						dummy_occ);*/
				list3 = new ArrayList<String>();
				list3 = pilt002Procedures.PKG_PILT002_IL_POAD_AGE_CHECK(
						"E",
						policyBean.getPOL_PLAN_CODE(),
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
						policyBean.getPOL_JOINT_LIFE_YN(),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE()),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE()),
						CommonUtils.getProcedureValue(policyBean.getPOL_PERIOD()),
						CommonUtils.getProcedureValue(dummy_occ.getUI_M_CALC_METHOD()),
						dummy_occ.getUI_M_PLAN_AGE_TERM_FLAG());
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						CommonUtils.setGlobalVariable("GLOBAL.M_PAYER_FOUND", list3.get(0));
					}
				}
               // }
					if ( dummy_occ.getUI_M_PAC_MAX_AGE_ON_MAT() != null) {
					
				
				if ((CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE(), 0) 
						+ CommonUtils.nvl(policyBean.getPOL_PERIOD(), 0)) 
						> (dummy_occ.getUI_M_PAC_MAX_AGE_ON_MAT())) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91081"));
				}
						}
				assuredAction.getCOMP_POAD_AGE().setDisabled(true);
			} else {
				if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").subSequence(2, 3))) {
					assuredAction.getCOMP_POAD_AGE().setDisabled(false);
				}
			}
			Integer list4 = localProcedure.IL_DISC_AGE(
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ADDL_RISK_CODE(),
					policyBean.getPOL_START_DT(), 
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_DISC_AGE());
			if (list4 != null) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DISC_AGE(list4);
			}
				

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

	public void POAD_HEIGHT_WHEN_VALIDATE_ITEM(Double POAD_HEIGHT,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		Double M_STD_WEIGHT = null;
		Double M_STD_HEIGHT = null;
		Double M_WEIGHT_FM = null;
		Double M_WEIGHT_TO = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
		ResultSet resultSet = null;
		ArrayList<OracleParameter> list = null;

		String CURSOR_C1 = "SELECT HTWT_WEIGHT_FM, HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL WHERE  HTWT_PT_SYS_ID = ? "
				+ "AND M_STD_HEIGHT  BETWEEN  HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO ";
		String CURSOR_C2 = "SELECT HTWT_WEIGHT_FM,HTWT_WEIGHT_TO FROM  PM_IL_HTWT_DTL"
				+ " WHERE  M_STD_HEIGHT BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C3 = "SELECT PT_SYS_ID FROM  PM_IL_PROP_TREATY WHERE ? BETWEEN PT_START_DT "
				+ "AND PT_END_DT AND PT_CLASS_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			
			if(!PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("Y"))
			{
				if (POAD_HEIGHT != null) 
				{
					if (POAD_HEIGHT <= 0) 
					{
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007"));
					}
				}

			}
			if ("M".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT_UNIT()) && POAD_HEIGHT > 2) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91431"));
			}
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_ISSUE_DT(),PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });
			if (resultSet.next()) {
				DUMMY_OCC_BEAN.setUI_M_PT_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			if (POAD_HEIGHT != null) {
				if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT() != null) {
					if ("M".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT_UNIT())) {
						M_STD_HEIGHT = CommonUtils.nvl(POAD_HEIGHT, 0);
					} else if ("C".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT_UNIT())) {
						if ((Math.ceil(CommonUtils.nvl(POAD_HEIGHT, 0))) != CommonUtils.nvl(POAD_HEIGHT, 0)) {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91567"));
						}
						M_STD_HEIGHT = CommonUtils.nvl(POAD_HEIGHT, 0) * 0.01;
					} else {
						M_STD_HEIGHT = CommonUtils.nvl(POAD_HEIGHT, 0) * 0.305;
					}
					if ("K".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT_UNIT())) {
						M_STD_WEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT(),0);
					} else {
						M_STD_WEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT(),0) * 0.454;
					}
					if (DUMMY_OCC_BEAN.getUI_M_ILUWMEDHT() == 2) {
						resultSet = handler.executeSelectStatement(CURSOR_C2,connection,
								new Object[] { M_STD_HEIGHT });
						if (resultSet.next()) {
							M_WEIGHT_FM = resultSet.getDouble(1);
							M_WEIGHT_TO = resultSet.getDouble(2);
						}
						if (M_STD_WEIGHT > M_WEIGHT_FM && M_STD_WEIGHT < M_WEIGHT_TO) {

						} else {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90009"));
						}
						CommonUtils.closeCursor(resultSet);
					}
				}
			}

			if (POAD_HEIGHT != null && PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT() != null  && PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT() != 0) {
				list = pilt002Procedures.L_BMI_CALC(
						POAD_HEIGHT,
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT(), 
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_BMI());
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI((Double)list.get(0).getValueObject());
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
		}

		finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void POAD_HEIGHT_UNIT_WHEN_LIST_CHANGED(String POAD_HEIGHT_UNIT,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		Double M_WEIGHT_FM = null;
		Double M_WEIGHT_TO = null;
		Double M_HTWT_HEIGHT_FM = null;
		Double M_HTWT_HEIGHT_TO = null;
		Double M_STD_WEIGHT = null;
		Double M_STD_HEIGHT = null;
		String CURSOR_C1 = "SELECT HTWT_WEIGHT_FM, HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL WHERE  HTWT_PT_SYS_ID =  ? "
				+ "AND  M_STD_HEIGHT  BETWEEN  HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C2 = "SELECT HTWT_WEIGHT_FM,HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL "
				+ "WHERE  M_STD_HEIGHT BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C3 = "SELECT PT_SYS_ID FROM   PM_IL_PROP_TREATY WHERE  ? BETWEEN PT_START_DT"
				+ " AND  PT_END_DT AND  PT_CLASS_CODE = ? ";
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> list = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			if ("M".equals(POAD_HEIGHT_UNIT)
					&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() > 2) {
				throw new Exception(Messages.getString( PELConstants.pelErrorMessagePath, "91431"));
			}
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_ISSUE_DT(),
							PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });
			if (resultSet.next()) {
				DUMMY_OCC_BEAN.setUI_M_PT_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != null) {
				if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT() != null) {
					if ("M".equals(POAD_HEIGHT_UNIT)) {
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),0);
					} else if ("C".equals(POAD_HEIGHT_UNIT)) {
						if ((Math.ceil(CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),0)))
								!= CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),0)) {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91567"));
						}
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),0) * 0.01;
					} else {
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),0) * 0.305;
					}
					if ("K".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT_UNIT())) {
						M_STD_WEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT(),0);
					} else {
						M_STD_WEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT(),0) * 0.454;
					}
					if (DUMMY_OCC_BEAN.getUI_M_ILUWMEDHT() == 2) {
						resultSet = handler.executeSelectStatement(CURSOR_C1,connection,
								new Object[] { DUMMY_OCC_BEAN.getUI_M_PT_SYS_ID() });
						if (resultSet.next()) {
							M_WEIGHT_FM = resultSet.getDouble(1);
							M_WEIGHT_TO = resultSet.getDouble(2);
						}
						if (M_STD_WEIGHT > M_WEIGHT_FM && M_STD_WEIGHT < M_WEIGHT_TO) {

						} else {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90009"));
						}
						CommonUtils.closeCursor(resultSet);
					}
				}
			}

			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != null && PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != 0
					&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT() != null && PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT() != 0 ) {
				list = pilt002Procedures.L_BMI_CALC(
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT(),
						POAD_HEIGHT_UNIT,
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_BMI());
				if (list != null && !list.isEmpty()) {
					if (list.get(0).getValueObject() != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI((Double)list.get(0).getValueObject());
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
		}
	}

	public void POAD_AGE_WHEN_VALIDATE_ITEM(Integer POAD_AGE,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		String CURSOR_C1 = "SELECT NVL(DS_AGE_RECALC_YN,'N') FROM   PM_IL_DOC_SETUP WHERE  DS_CODE = ? ";

		String M_DS_AGE_RECALC_YN = null;
		Double M_AGE = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		ArrayList<String> list = null;
		Integer list1 = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_END_CODE() });
			if (resultSet.next()) {
				M_DS_AGE_RECALC_YN = resultSet.getString(1);
			}
			/*if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_DOB() != null) {
				localProcedure.P_CAL_PLAN_PERIOD(
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_DOB(), 
						PT_IL_POL_ASSURED_DTLS_BEAN,
						PT_IL_POL_ASSURED_DTLS_1_BEAN, 
						PT_IL_POLICY_BEAN,
						DUMMY_OCC_BEAN);
			}
*/
			list = pilt002Procedures.PKG_PILT002_IL_POAD_AGE_CHECK(
					"E",
					PT_IL_POLICY_BEAN.getPOL_PLAN_CODE(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
					PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN(),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE()), 
					CommonUtils.getProcedureValue(POAD_AGE), 
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_PERIOD()),
					CommonUtils.getProcedureValue(DUMMY_OCC_BEAN.getUI_M_CALC_METHOD()),
					DUMMY_OCC_BEAN.getUI_M_PLAN_AGE_TERM_FLAG());

			if (PT_IL_POLICY_BEAN.getPOL_END_TYPE() != "002" && "N".equals(M_DS_AGE_RECALC_YN)) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DISC_AGE(POAD_AGE);
			}

			list1 = localProcedure.IL_DISC_AGE(POAD_AGE,
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_CATG_CODE(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ADDL_RISK_CODE(),
					PT_IL_POLICY_BEAN.getPOL_START_DT(),
					PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_DISC_AGE());
			if (list1 != null ) {
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DISC_AGE(list1);
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
		}

	}

	public void POAD_WEIGHT_WHEN_VALIDATE_ITEM(Double POAD_WEIGHT,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		Double M_STD_WEIGHT = null;
		Double M_STD_HEIGHT = null;
		Double M_WEIGHT_FM = null;
		Double M_WEIGHT_TO = null;
		Double M_HTWT_WEIGHT_FM = null;
		Double M_HTWT_WEIGHT_TO = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
		ResultSet resultSet = null;
		ArrayList<OracleParameter> list = null;

		String CURSOR_C1 = "SELECT HTWT_WEIGHT_FM, HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL WHERE  HTWT_PT_SYS_ID = ? "
				+ "AND ?  BETWEEN  HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO ";
		String CURSOR_C2 = "SELECT HTWT_WEIGHT_FM,HTWT_WEIGHT_TO FROM  PM_IL_HTWT_DTL"
				+ " WHERE  ? BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C3 = "SELECT PT_SYS_ID FROM  PM_IL_PROP_TREATY WHERE ? BETWEEN PT_START_DT "
				+ "AND PT_END_DT AND PT_CLASS_CODE = ? ";

		try {
			connection = CommonUtils.getConnection();
			if(!PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("Y"))
			{
				if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != null) 
				{
					if (POAD_WEIGHT <= 0) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007"));
					}
				}
			}
			
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_ISSUE_DT(),PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });
			if (resultSet.next()) {
				DUMMY_OCC_BEAN.setUI_M_PT_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);

			
			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != null && PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != 0) {
				if (POAD_WEIGHT <= 0) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90007"));
				}
			}
			if ("M".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT_UNIT())) {
				M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(), 0);
			} else if ("C".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT_UNIT())) {

				M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(), 0) * 0.01;
			} else {
				M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(), 0) * 0.305;
			}
			if ("K".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT_UNIT())) {
				M_STD_WEIGHT = CommonUtils.nvl(POAD_WEIGHT, 0);
			} else {
				M_STD_WEIGHT = CommonUtils.nvl(POAD_WEIGHT, 0) * 0.454;
			}
			if (DUMMY_OCC_BEAN.getUI_M_ILUWMEDHT() == 2) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,connection, 
						new Object[] { DUMMY_OCC_BEAN.getUI_M_PT_SYS_ID() });
				if (resultSet.next()) {
					M_WEIGHT_FM = resultSet.getDouble(1);
					M_WEIGHT_TO = resultSet.getDouble(2);
				}
				if (M_STD_WEIGHT > M_WEIGHT_FM && M_STD_WEIGHT < M_WEIGHT_TO) {

				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90009"));

				}

			} else if (DUMMY_OCC_BEAN.getUI_M_ILUWMEDHT() == 1) {
				resultSet = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { M_STD_HEIGHT});
				if (resultSet.next()) {
					M_HTWT_WEIGHT_FM = resultSet.getDouble(1);
					M_HTWT_WEIGHT_TO = resultSet.getDouble(2);
				}
				
				/*Added by Janani on 20.04.2018 for FLA joint life issue*/	
				if(M_HTWT_WEIGHT_FM != null && M_HTWT_WEIGHT_TO!= null ){
					
				/*End*/	
				
				if (M_STD_WEIGHT > M_HTWT_WEIGHT_FM && M_STD_WEIGHT < M_HTWT_WEIGHT_TO) {

				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "90009"));

				}

				}
				CommonUtils.closeCursor(resultSet);
			}

			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != null && POAD_WEIGHT != null && PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != 0 ) {
				list = pilt002Procedures.L_BMI_CALC(
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),
						POAD_WEIGHT,
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_BMI());
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI((Double)list.get(0).getValueObject());
						
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
	}

	public void POAD_WEIGHT_UNIT_WHEN_LIST_CHANGED(String POAD_WEIGHT_UNIT,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		Double M_WEIGHT_FM = null;
		Double M_WEIGHT_TO = null;
		Double M_HTWT_WEIGHT_FM = null;
		Double M_HTWT_WEIGHT_TO = null;
		Double M_STD_WEIGHT = null;
		Double M_STD_HEIGHT = null;

		String CURSOR_C1 = "SELECT HTWT_WEIGHT_FM, HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL WHERE  HTWT_PT_SYS_ID =  ? "
				+ "AND  ? BETWEEN  HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C2 = "SELECT HTWT_WEIGHT_FM,HTWT_WEIGHT_TO FROM   PM_IL_HTWT_DTL "
				+ "WHERE  ? BETWEEN HTWT_HEIGHT_FM AND HTWT_HEIGHT_TO";
		String CURSOR_C3 = "SELECT PT_SYS_ID FROM   PM_IL_PROP_TREATY WHERE  ? BETWEEN PT_START_DT"
				+ " AND  PT_END_DT AND  PT_CLASS_CODE = ? ";

		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> list = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			if(!PT_IL_POLICY_BEAN.getPOL_JOINT_LIFE_YN().equalsIgnoreCase("Y"))
			{
			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != null) {
				if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT() <= 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "90007"));
				}
			}
			}
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_ISSUE_DT(),PT_IL_POLICY_BEAN.getPOL_CLASS_CODE() });
			if (resultSet.next()) {
				DUMMY_OCC_BEAN.setUI_M_PT_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);

			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != null) {
				if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT() != null) {
					if ("M".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT_UNIT())) {
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),0);
					} else if ("C".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT_UNIT())) {

						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),0) * 0.01;
					} else {
						M_STD_HEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),0) * 0.305;
					}

					if ("K".equals(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT_UNIT())) {
						M_STD_WEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT(),0);
					} else {
						M_STD_WEIGHT = CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT(),0) * 0.454;
					}
					if (DUMMY_OCC_BEAN.getUI_M_ILUWMEDHT() == 2) {
						resultSet = handler.executeSelectStatement(CURSOR_C1,connection,
								new Object[] { DUMMY_OCC_BEAN.getUI_M_PT_SYS_ID(),M_STD_HEIGHT });
						if (resultSet.next()) {
							M_WEIGHT_FM = resultSet.getDouble(1);
							M_WEIGHT_TO = resultSet.getDouble(2);
						}
						if (M_STD_WEIGHT > M_WEIGHT_FM && M_STD_WEIGHT < M_WEIGHT_TO) {

						} else {
							throw new Exception(Messages
									.getString(PELConstants.pelErrorMessagePath,"90009"));
						}

					} else if (DUMMY_OCC_BEAN.getUI_M_ILUWMEDHT() == 1) {
						resultSet = handler.executeSelectStatement(CURSOR_C2,
								connection, new Object[] { M_STD_HEIGHT });
						if (resultSet.next()) {
							M_HTWT_WEIGHT_FM = resultSet.getDouble(1);
							M_HTWT_WEIGHT_TO = resultSet.getDouble(2);
						}

						/*Added by Janani on 20.04.2018 for FLA joint life issue*/	
						if(M_HTWT_WEIGHT_FM != null && M_HTWT_WEIGHT_TO!= null ){
							
						/*End*/	
						if (M_STD_WEIGHT > M_HTWT_WEIGHT_FM && M_STD_WEIGHT < M_HTWT_WEIGHT_TO) {

						} else {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90009"));
						}
						}
						CommonUtils.closeCursor(resultSet);
					}
				}
			}

			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != null && PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT() != 0.0 
					&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT() != null && PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT() != 0.0) {
				list = procedures.L_BMI_CALC(
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_WEIGHT_UNIT(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_BMI());
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_BMI(CommonUtils.ROUND( (Double)list.get(0).getValueObject(),5));
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
				// TODO: handle exception
			}
		}
	}

	public void POAD_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(
			String POAD_AGE_PROOF_FLAG,
			PT_IL_POL_ASSURED_DTLS_1_ACTION PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN) {
		if ("0".equalsIgnoreCase(PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_AGE_PROOF_FLAG())) {
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setDisabled(false);
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setRequired(true);
		} else {
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setValue("");
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setSubmittedValue("");
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_AGE_PROOF_OTHERS("");
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_AGE_PROOF_OTHERS().setDisabled(true);
		}
	}

	public void POAD_SMOKE_YN_WHEN_LIST_CHANGED(String POAD_SMOKE_YN,
			PT_IL_POL_ASSURED_DTLS_1_ACTION PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN) {
		PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN = PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		if ("Y".equals(POAD_SMOKE_YN)) {
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setDisabled(false);
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_NO_OF_CIGAR(1);
		} else {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_NO_OF_CIGAR(0);
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getCOMP_POAD_NO_OF_CIGAR().setDisabled(true);
		}

	}

	public void POAD_NATIONALITY_WHEN_VALIDATE_ITEM(String POAD_NATIONALITY,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {

		ArrayList<String> list = null;
		DBProcedures procedures = new DBProcedures();
		try {
			if (POAD_NATIONALITY != null) {
				list = procedures.P_VAL_CODES("NATLITY", POAD_NATIONALITY,
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_NATLITY_DESC()),
						"N", "E", null);
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null)  {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_NATLITY_DESC(list.get(0));
						
					}
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

	public void POAD_MAR_STATUS_WHEN_VALIDATE_ITEM(String POAD_MAR_STATUS,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {

		Double M_VALUE = null;
		ArrayList<String> list = null;
		try {
			if (POAD_MAR_STATUS != null) {
				list = DBProcedures.P_VAL_SYSTEM(
						"MARI_STAT",
						POAD_MAR_STATUS,
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_MS_DESC()),
						"E", CommonUtils.getProcedureValue(M_VALUE));
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_MS_DESC(list.get(0));
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void POAD_OCC_CODE_WHEN_VALIDATE_ITEM(String POAD_OCC_CODE,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<OracleParameter> list = null;
		try {
			if (POAD_OCC_CODE != null) {
				list = procedures.P_DISP_OCCU_CLASS("R",POAD_OCC_CODE,
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_OCC_DESC(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_OCC_CLASS(),
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_OCC_CLASS_DESC());
				
				if (list != null && !list.isEmpty()) {
					if (list.get(1).getValueObject() != null) {
						
						/*Modified by Janani for desc getting defaulted as code issue on 02.05.2018*/ 
						//PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_OCC_DESC((String)list.get(0).getValueObject());
						
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_OCC_DESC((String)list.get(1).getValueObject());
						/*End*/
					}
					if (list.get(2).getValueObject() != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_OCC_CLASS((String)list.get(2).getValueObject());
					}if (list.get(3).getValueObject() != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_OCC_CLASS_DESC((String)list.get(3).getValueObject());
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POAD_OCC_CLASS_WHEN_VALIDATE_ITEM(String POAD_OCC_CLASS,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			if (POAD_OCC_CLASS != null) {
				list = procedures.P_VAL_CODES(
						"IL_OCC_CLASS", POAD_OCC_CLASS,
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_OCC_CLASS_DESC()),
						"N", "E", null);
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_OCC_CLASS_DESC(list.get(0));
						
					}
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

	public void POAD_RELIGION_CODE_VALIDATE_ITEM(String POAD_RELIGION_CODE,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {

		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			if (POAD_RELIGION_CODE != null) {
				list = procedures.P_VAL_CODES(
						"RELIGION",
						POAD_RELIGION_CODE,
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_REL_CODE_DESC()),
						"N", "E", null);
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_REL_CODE_DESC(list.get(0));
					}
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

	public void POAD_OCC_RATE_VALIDATE_ITEM(Double POAD_OCC_RATE,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {

		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_OCC_CLASS() != null) {
				list = procedures.P_VAL_CODES(
						"IL_OCC_CLASS",
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_OCC_CLASS(),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_OCC_CLASS_DESC()),
						"N", "E", null);
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_OCC_CLASS_DESC(list.get(0));
					}
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

	public void POAD_HEALTH_CODE_VALIDATE_ITEM(String POAD_HEALTH_CODE,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {

		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			if (POAD_HEALTH_CODE != null) {
				list = procedures.P_VAL_CODES(
						"IL_HLTH_ST",
						POAD_HEALTH_CODE,
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_HEALTH_DESC()),
						"N", "E", null);
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_HEALTH_DESC(list.get(0));
						
					}
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
	
	public void POAD_ADDL_RISK_CODE_VALIDATE_ITEM(String POAD_ADDL_RISK_CODE,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {

		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			if (POAD_ADDL_RISK_CODE != null) {
				list = procedures.P_VAL_CODES("IL_ADDL_RISK",
						PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ADDL_RISK_CODE(),
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_ADDL_RISK_DESC()),
						"N", "N", null);
				if (list != null && !list.isEmpty() ) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_ADDL_RISK_DESC(list.get(0));
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


	public Double POAD_FC_SALARY_VALIDATE_ITEM(Double POAD_FC_SALARY,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		try {
			list = procedures.P_VAL_ROUND_AMT(
					PT_IL_POLICY_BEAN.getPOL_SA_CURR_CODE(),
					CommonUtils.getProcedureValue(POAD_FC_SALARY),"V");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					POAD_FC_SALARY = Double.parseDouble(list.get(0));
				}
			}
					
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_SALARY(POAD_FC_SALARY * PT_IL_POLICY_BEAN.getPOL_SA_EXCH_RATE());
			list1 = procedures.P_VAL_ROUND_AMT(
					DUMMY_OCC_BEAN.getUI_M_BASE_CURR(), 
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_LC_SALARY()), "R");
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_SALARY(Double.parseDouble(list1.get(0)));
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return POAD_FC_SALARY;
	}

	public Double POAD_LC_SALARY_VALIDATE_ITEM(Double POAD_LC_SALARY,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		LIFELIB lifelib = new LIFELIB();

		ArrayList<String> list1 = null;
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					DUMMY_OCC_BEAN.getUI_M_BASE_CURR(), 
					CommonUtils.getProcedureValue(POAD_LC_SALARY), "V");
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						POAD_LC_SALARY = Double.parseDouble(list1.get(0));
					}
				}
				lifelib.callP_VAL_FC_LC_TOLERANCE(
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_FC_SALARY()),
					CommonUtils.getProcedureValue(POAD_LC_SALARY),
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SA_EXCH_RATE()), "E");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_LC_SALARY;
	}

	public Double POAD_FC_SUM_ASSURED_VALIDATE_ITEM(Double POAD_FC_SUM_ASSURED,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		try {
			/*if (POAD_FC_SUM_ASSURED <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71043"));
			}*/

			list = pilt002Procedures.P_VAL_ROUND_AMT(
					PT_IL_POLICY_BEAN.getPOL_SA_CURR_CODE(),
					CommonUtils.getProcedureValue(POAD_FC_SUM_ASSURED), "V");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					POAD_FC_SUM_ASSURED = Double.parseDouble(list.get(0));
				}
			}
					
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_SUM_ASSURED(POAD_FC_SUM_ASSURED * PT_IL_POLICY_BEAN.getPOL_SA_EXCH_RATE());

			list1 = pilt002Procedures.P_VAL_ROUND_AMT(
					DUMMY_OCC_BEAN.getUI_M_BASE_CURR(), 
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_LC_SUM_ASSURED()), "R");
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_SUM_ASSURED(Double.parseDouble(list1.get(0)));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return POAD_FC_SUM_ASSURED;
	}

	public Double POAD_LC_SUM_ASSURED_VALIDATE_ITEM(Double POAD_LC_SUM_ASSURED,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC pilt002Procedures = new PKG_PILT002_APAC();
		LIFELIB lifelib = new LIFELIB();

		try {
			/*if (POAD_LC_SUM_ASSURED <= 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71043"));
			}*/
			list = pilt002Procedures.P_VAL_ROUND_AMT(
					DUMMY_OCC_BEAN.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(POAD_LC_SUM_ASSURED), "R");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					POAD_LC_SUM_ASSURED = Double.parseDouble(list.get(0));
				}
			}
			lifelib.callP_VAL_FC_LC_TOLERANCE(
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_FC_SUM_ASSURED()),
					CommonUtils.getProcedureValue(POAD_LC_SUM_ASSURED),
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_SA_EXCH_RATE()), "E");
					
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_LC_SUM_ASSURED;
	}

	public Double POAD_FC_AMAN_PREM_VALIDATE_ITEM(Double POAD_FC_AMAN_PREM,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = null;
		ArrayList<String> list = null;
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE(),
					CommonUtils.getProcedureValue(POAD_FC_AMAN_PREM), "V");
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					POAD_FC_AMAN_PREM = Double.parseDouble(list1.get(0));
				}
			}
			
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_AMAN_PREM(POAD_FC_AMAN_PREM
							* PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE());

			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_OCC_BEAN.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_LC_AMAN_PREM()), "R");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_AMAN_PREM(Double.parseDouble(list.get(0)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_FC_AMAN_PREM;
	}

	public Double POAD_LC_AMAN_PREM_VALIDATE_ITEM(Double POAD_LC_AMAN_PREM,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = null;
		ArrayList<String> list = null;
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE(),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_FC_AMAN_PREM()), "V");
			  if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_AMAN_PREM(Double.parseDouble(list1.get(0)));
				}
			  }
					

			POAD_LC_AMAN_PREM = POAD_LC_AMAN_PREM * PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE();

			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_OCC_BEAN.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(POAD_LC_AMAN_PREM), "R");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					POAD_LC_AMAN_PREM = Double.parseDouble(list.get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_LC_AMAN_PREM;

	}

	public Double POAD_FC_AMAN_LOAD_PREM_VALIDATE_ITEM(
			Double POAD_FC_AMAN_LOAD_PREM,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = null;
		ArrayList<String> list = null;
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE(),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_FC_AMAN_PREM()), "V");
			if (list1 != null && list1.isEmpty()) {
				if (list1.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_AMAN_PREM(Double.parseDouble(list1.get(0)));
					
				}
			}

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_AMAN_PREM(PT_IL_POL_ASSURED_DTLS_1_BEAN
							.getPOAD_LC_AMAN_PREM()* PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE());

			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_OCC_BEAN.getUI_M_BASE_CURR(), 
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_LC_AMAN_PREM()), "R");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_AMAN_PREM(Double.parseDouble(list.get(0)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_FC_AMAN_LOAD_PREM;

	}

	public Double POAD_LC_AMAN_LOAD_PREM_VALIDATE_ITEM(
			Double POAD_LC_AMAN_LOAD_PREM,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = null;
		ArrayList<String> list = null;
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE(),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_FC_AMAN_LOAD_PREM()), "V");
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_AMAN_LOAD_PREM(Double.parseDouble(list1.get(0)));
				}
			}
					

			POAD_LC_AMAN_LOAD_PREM = PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_FC_AMAN_LOAD_PREM()
			* PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE();

			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_OCC_BEAN.getUI_M_BASE_CURR(),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_FC_AMAN_LOAD_PREM()), "R");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					POAD_LC_AMAN_LOAD_PREM = Double.parseDouble(list.get(0));
				}
			}
					

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return POAD_LC_AMAN_LOAD_PREM;
	}

	public Double POAD_FC_SENABEL_PREM_VALIDATE_ITEM(
			Double POAD_FC_SENABEL_PREM,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = null;
		ArrayList<String> list = null;
		try {

			list1 = procedures.P_VAL_ROUND_AMT(
					PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE(),
					CommonUtils.getProcedureValue(POAD_FC_SENABEL_PREM), "V");
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					POAD_FC_SENABEL_PREM = Double.parseDouble(list1.get(0));
				}
			}
					

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_SENABEL_PREM(POAD_FC_SENABEL_PREM * PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE());

			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_OCC_BEAN.getUI_M_BASE_CURR(), 
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_LC_AMAN_LOAD_PREM()), "R");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) !=  null) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_AMAN_LOAD_PREM(Double.parseDouble(list.get(0)));
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return POAD_FC_SENABEL_PREM;

	}

	public Double POAD_LC_SENABEL_PREM_VALIDATE_ITEM(
			Double POAD_LC_SENABEL_PREM,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN,
			PT_IL_POLICY PT_IL_POLICY_BEAN, DUMMY DUMMY_OCC_BEAN)
			throws Exception {

		//DBProcedures procedures = new DBProcedures();
		PKG_PILT002_APAC procedures = new PKG_PILT002_APAC();
		ArrayList<String> list1 = null;
		ArrayList<String> list = null;
		try {
			list1 = procedures.P_VAL_ROUND_AMT(
					CommonUtils.getProcedureValue(PT_IL_POLICY_BEAN.getPOL_CUST_CURR_CODE()),
					CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_FC_SENABEL_PREM()), "V");
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
						POAD_LC_SENABEL_PREM = (Double.parseDouble(list1.get(0)));
					}
				}
					

			POAD_LC_SENABEL_PREM = PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_FC_SENABEL_PREM()* PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE();
			list = procedures.P_VAL_ROUND_AMT(
					DUMMY_OCC_BEAN.getUI_M_BASE_CURR(), 
					CommonUtils.getProcedureValue(POAD_LC_SENABEL_PREM), "R");
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					POAD_LC_SENABEL_PREM = Double.parseDouble(list.get(0));
				}
			}
					

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return POAD_LC_SENABEL_PREM;
	}

	public void POAD_REMARKS_KEY_NEXT_ITEM(String POAD_REMARKS,
			PT_IL_POLICY PT_IL_POLICY_BEAN,
			PT_IL_POL_ASSURED_DTLS_1_ACTION PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN) {

		String M_DUMMY = null;
		String CURSOR_C1 = "SELECT 'X' FROM PM_IL_DOC_MED_HIST WHERE DMH_DS_TYPE = ? AND DMH_DS_CODE = ?"
				+ "  AND  DMH_APPL_ON IN ('R','B') AND ROWNUM  <=20 ";
		CommonUtils.setGlobalVariable("GLOBAL.M_BLOCK", "1");
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { PT_IL_POLICY_BEAN.getPOL_DS_TYPE(),
							PT_IL_POLICY_BEAN.getPOL_DS_CODE() });
			PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getM_BUT_FLEX_FIELDS()
					.setRendered(false);
			if (resultSet.next()) {
				M_DUMMY = resultSet.getString(1);

				PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getM_BUT_FLEX_FIELDS()
						.setRendered(true);
				if (CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_END_TYPE(), "000") != "002"
						|| "A".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN
								.getPOL_APPRV_STATUS(), "N"))) {
					// GO_ITEM('PT_IL_POL_ASSURED_DTLS.M_BUT_FLEX_FIELDS');

				} else if ("002".equals(CommonUtils.nvl(PT_IL_POLICY_BEAN
						.getPOL_END_TYPE(), "000"))
						|| "A" != CommonUtils.nvl(PT_IL_POLICY_BEAN
								.getPOL_APPRV_STATUS(), "N")) {
					// GO_ITEM('PT_IL_POL_ADDL_COVER.POAC_COVER_CODE');
				} else {
					PT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN.getM_BUT_FLEX_FIELDS()
							.setRendered(false);
				}
				// GO_ITEM('PT_IL_POL_ADDL_COVER.POAC_COVER_CODE');

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (DBException e) {

			e.printStackTrace();
		}
	}
	
	public void POAD_RACE_VALIDATE_ITEM(String POAD_RACE,
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN)
			throws Exception {
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list1 = null;

		try {
			if (POAD_RACE != null) {
				list1 = procedures.P_VAL_CODES(
						"RACE",POAD_RACE,
						CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_1_BEAN.getUI_M_POAD_RACE_CODE_DESC()),
						"N", "E", null);
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_RACE_CODE_DESC(list1.get(0));
					}
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
	
	
	public void POAD_POL_OWNER_YN_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		try{

			/*Added by Janani for fidelity pol_owner null issue on 02.05.2018*/
			if(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_OWNER_YN() != null &&
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_POL_OWNER_YN() != null)
			{
				/*End*/
				if(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_OWNER_YN().equalsIgnoreCase(compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_POL_OWNER_YN())){
					throw new Exception("Either Payor or Payee should be the Policy Owner");
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
