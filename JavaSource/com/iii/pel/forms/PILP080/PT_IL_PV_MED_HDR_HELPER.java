package com.iii.pel.forms.PILP080;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PV_MED_HDR_HELPER {

	public void executeQuery(PILP080_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_PV_MED_HDR_DELEGATE().executeSelectStatement(compositeAction);
	}

	public void POST_QUERY(PILP080_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String CURSOR_C_NAME = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE =?";
		String C2 = "SELECT PROD_DESC FROM   PM_IL_PRODUCT WHERE  PROD_CODE = ?";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String M_CLINIC_NAME = null;
		String M_PMH_PROD_NAME = null;
		PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
				.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN();
		try {
			con = CommonUtils.getConnection();
			rs1 = handler
					.executeSelectStatement(CURSOR_C_NAME, con,
							new Object[] { PT_IL_PV_MED_HDR_BEAN
									.getPMH_CLINIC_CODE() });
			while (rs1.next()) {
				M_CLINIC_NAME = rs1.getString(1);

			}
			rs2 = handler.executeSelectStatement(C2, con,
					new Object[] { PT_IL_PV_MED_HDR_BEAN.getPMH_PROD_CODE() });
			while (rs2.next()) {
				M_PMH_PROD_NAME = rs2.getString(1);

			}
			PT_IL_PV_MED_HDR_BEAN.setUI_M_CLINIC_NAME(M_CLINIC_NAME);
			PT_IL_PV_MED_HDR_BEAN.setUI_M_PMH_PROD_NAME(M_PMH_PROD_NAME);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
	
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());

			}

		}

	}

	public void PRE_UPDATE(PILP080_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
					.getPT_IL_PV_MED_HDR_ACTION_BEAN()
					.getPT_IL_PV_MED_HDR_BEAN();
			PT_IL_PV_MED_HDR_BEAN.setPMH_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PT_IL_PV_MED_HDR_BEAN.setPMH_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void pre_insert(PILP080_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String CURSOR_C1 = "SELECT PMH_SYS_ID.NEXTVAL FROM DUAL ";
		Long M_PMH_SYS_ID = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
				.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN();

		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(CURSOR_C1, con);
			while (rs1.next()) {
				M_PMH_SYS_ID = rs1.getLong(1);
				PT_IL_PV_MED_HDR_BEAN.setPMH_SYS_ID(M_PMH_SYS_ID);
			}
			PT_IL_PV_MED_HDR_BEAN.setPMH_CR_DT(new CommonUtils()
					.getCurrentDate());
			PT_IL_PV_MED_HDR_BEAN.setPMH_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());

			}

		}

	}

	public void pre_update(PILP080_COMPOSITE_ACTION compositeAction) throws Exception
			 {
		try {
			PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
					.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN();
			PT_IL_PV_MED_HDR_BEAN.setPMH_UPD_DT(new CommonUtils().getCurrentDate());
			PT_IL_PV_MED_HDR_BEAN.setPMH_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void When_New_Record_Instance(
			PILP080_COMPOSITE_ACTION compositeAction) throws Exception {
		DUMMY_ACTION DUMMY_ACTION_BEAN = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
				.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN();
		PT_IL_PV_MED_HDR_ACTION PT_IL_PV_MED_HDR_ACTION_BEAN = compositeAction
				.getPT_IL_PV_MED_HDR_ACTION_BEAN();
		String M_VALUE = null;
		String M_APPRV_STATUS = null;
		String M_END_STATUS = null;
		String M_END_IDX_TYPE_NO = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			list = P_VAL_APP_PARAMETER("IL_REC_STA", CommonUtils.nvl(
					PT_IL_PV_MED_HDR_BEAN.getPMH_APPRV_STATUS(), "N"),
					M_APPRV_STATUS, "N", M_VALUE);
			DUMMY_BEAN.setUI_M_APPRV_STATUS(list.get(0));

			if ("A".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PV_MED_HDR_BEAN
					.getPMH_APPRV_STATUS(), "N"))) {
				PT_IL_PV_MED_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DTLS().setDisabled(
						true);
				PT_IL_PV_MED_HDR_ACTION_BEAN.setUPDATE_ALLOWED(false);
				PT_IL_PV_MED_HDR_ACTION_BEAN.setINSERT_ALLOWED(false);
				PT_IL_PV_MED_HDR_ACTION_BEAN.setDELETE_ALLOWED(false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_GENERATE().setDisabled(true);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_REP().setDisabled(false);
				//DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_ERR_DTLS().setDisabled(true);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_APPRV_STATUS().setRendered(true);
			} else {
				PT_IL_PV_MED_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DTLS().setDisabled(
						false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_APPRV_STATUS().setRendered(false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_REP().setDisabled(true);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_GENERATE().setDisabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		/*
		 * IF NVL(:PT_IL_PV_MED_HDR.PMH_APPRV_STATUS,'N') = 'A' THEN
		 * SET_ITEM_PROPERTY('PT_IL_PV_MED_HDR.M_BUT_DTLS',ENABLED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVE',ENABLED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_GENERATE',ENABLED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_REP',ENABLED,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_ERR_DTLS',ENABLED,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY('DUMMY.M_APPRV_STATUS',VISIBLE,PROPERTY_TRUE);
		 * SET_BLOCK_PROPERTY('PT_IL_PV_MED_HDR',UPDATE_ALLOWED,PROPERTY_FALSE);
		 * SET_BLOCK_PROPERTY('PT_IL_PV_MED_HDR',INSERT_ALLOWED,PROPERTY_FALSE);
		 * SET_BLOCK_PROPERTY('PT_IL_PV_MED_HDR',DELETE_ALLOWED,PROPERTY_FALSE);
		 * ELSE
		 * SET_ITEM_PROPERTY('PT_IL_PV_MED_HDR.M_BUT_DTLS',ENABLED,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVE',ENABLED,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_GENERATE',ENABLED,PROPERTY_TRUE);
		 * SET_ITEM_PROPERTY('DUMMY.M_APPRV_STATUS',VISIBLE,PROPERTY_FALSE);
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_REP',ENABLED,PROPERTY_FALSE); END IF;
		 */
	}

	public void pre_record(PILP080_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
				.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String M_VALUE = null;
		String M_APPRV_STATUS = null;
		String M_END_STATUS = null;
		String M_END_IDX_TYPE_NO = null;
		try {
			P_VAL_APP_PARAMETER("IL_REC_STA", CommonUtils.nvl(
					PT_IL_PV_MED_HDR_BEAN.getPMH_APPRV_STATUS(), "N"),
					M_APPRV_STATUS, "N", M_VALUE);
			DUMMY_BEAN.setUI_M_APPRV_STATUS(M_APPRV_STATUS);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}

	}

	public void preform() {
		CommonUtils.setGlobalVariable("GLOBAL.M_LOGIN_APP_CODE", "02");
	}

	public ArrayList<String> P_VAL_APP_PARAMETER(String P_PARA_CODE,
			String P_PARA_SUB_CODE, String P_PARA_NAME, String P_ERR_FLAG,
			String P_PARA_VALUE) throws Exception {
		ArrayList<String> returnList = new ArrayList<String>();
		String M_NAME = null;
		String M_BL_NAME = null;
		String M_VALUE = null;
		String M_PARA_APP_CODE = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String c1 = "SELECT PARA_NAME,PARA_BL_NAME,PARA_VALUE"
				+ " FROM   PCOM_APP_PARAMETER" + " WHERE  PARA_APP_CODE  = ?"
				+ " AND    PARA_CODE      =?" + " AND    PARA_SUB_CODE  = ?";
		try {
			con = CommonUtils.getConnection();
			M_PARA_APP_CODE = CommonUtils
					.getGlobalVariable("GLOBAL.M_LOGIN_APP_CODE");
			rs = handler.executeSelectStatement(c1, con, new Object[] {
					M_PARA_APP_CODE, P_PARA_CODE, P_PARA_SUB_CODE });
			/*
			 * BEGIN
			 * 
			 * M_PARA_APP_CODE := NAME_IN('GLOBAL.M_LOGIN_APP_CODE');
			 * 
			 * OPEN C1; FETCH C1 INTO M_NAME,M_BL_NAME,M_VALUE; IF C1%NOTFOUND
			 * THEN IF P_ERR_FLAG IN ('W','E') THEN
			 * STD_MESSAGE_ROUTINE(1000,NAME_IN('GLOBAL.M_LANG_CODE')); IF
			 * P_ERR_FLAG = 'E' THEN RAISE FORM_TRIGGER_FAILURE; END IF ; END
			 * IF; END IF; CLOSE C1; IF
			 * SUBSTR(NAME_IN('GLOBAL.M_FOR_LANG_CODE'),5,1) = '1' OR
			 * NAME_IN('GLOBAL.M_LANG_CODE') = 'ENG' THEN P_PARA_NAME := M_NAME;
			 * ELSE P_PARA_NAME := M_BL_NAME ; END IF; P_PARA_VALUE := M_VALUE;
			 * END;
			 */
			while (rs.next()) {
				M_NAME = rs.getString(1);
				M_BL_NAME = rs.getString(2);
				M_VALUE = rs.getString(3);
			}
			if (CommonUtils.isIN(P_ERR_FLAG, "W", "E")) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "1000"));

			}
			if (CommonUtils.SUBSTR(
					CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"), 1,
					5).equals("1")
					|| CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")
							.equals("ENG")) {
				P_PARA_NAME = M_NAME;
			} else {
				P_PARA_NAME = M_BL_NAME;
			}
			P_PARA_VALUE = M_VALUE;
			returnList.add(P_PARA_NAME);
			returnList.add(P_PARA_VALUE);

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return returnList;
	}

	public void when_create_record(PILP080_COMPOSITE_ACTION compositeAction) throws Exception
			{
		try {
			compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN()
					.getPT_IL_PV_MED_HDR_BEAN().setPMH_PROCESS_DT(
							new CommonUtils().getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_PMH_CLINIC_CODE(
			PILP080_COMPOSITE_ACTION compositeAction) throws Exception {
		String C1 = "SELECT DECODE(?,'ENG',CUST_NAME,CUST_BL_NAME)"
				+ " FROM   PM_CUSTOMER WHERE  CUST_FRZ_FLAG = 'N' AND    CUST_CODE     = ?";
		PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
				.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN();
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String M_CLINIC_NAME = null;
		String M_LANG_CODE = CommonUtils
				.getGlobalVariable("GLOBAL.M_LANG_CODE");
		if (PT_IL_PV_MED_HDR_BEAN.getPMH_CLINIC_CODE() != null) {
			try {
				con = CommonUtils.getConnection();
				rs = handler.executeSelectStatement(C1, con,
						new Object[] { M_LANG_CODE,
								PT_IL_PV_MED_HDR_BEAN.getPMH_CLINIC_CODE() });
				if (rs.next()) {
					M_CLINIC_NAME = rs.getString(1);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1705",
							new Object[] { CommonUtils
									.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
				PT_IL_PV_MED_HDR_BEAN.setUI_M_CLINIC_NAME(M_CLINIC_NAME);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}

	public void M_BUT_DTLS(PILP080_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String M_REF_NO = null;
		String M_WHERE = null;

		String c1 = " UPDATE PT_IL_POL_MED_EXAM_DTL"
				+ " SET    PMED_FLEX_09  = ?"
				+ " WHERE  PMED_CLINIC_CODE = ?"
				+ " AND    PMED_STATUS = 'Y' "
				+ " AND    PMED_REP_REC_DT BETWEEN TO_DATE (?,'DD/MM/RRRR') AND TO_DATE(?,'DD/MM/RRRR')"
				+ "AND    PMED_POL_SYS_ID  IN (SELECT POL_SYS_ID "
				+ " FROM   PT_IL_POLICY " + "WHERE  POL_NO = ?) ";
		String c2 = "UPDATE PT_IL_POL_MED_EXAM_DTL "
				+ "  SET    PMED_FLEX_09  = ?  WHERE  PMED_CLINIC_CODE = ?"
				+ "  AND    PMED_STATUS = 'Y'"
				+ " AND    PMED_REP_REC_DT  BETWEEN TO_DATE (?,'DD/MM/RRRR')"
				+ " AND TO_DATE(?,'DD/MM/RRRR')"
				+ "  AND    PMED_POL_SYS_ID  IN (SELECT POL_SYS_ID "
				+ "  FROM   PT_IL_POLICY   WHERE  POL_DS_TYPE = '1'"
				+ "   UNION SELECT POL_SYS_ID "
				+ "  FROM   PT_IL_POLICY   WHERE  POL_DS_TYPE  = '2'"
				+ "  AND    POL_PROP_NO IS NULL )";
		PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
				.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN();
		Connection con = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		CRUDHandler handler = new CRUDHandler();
		con = CommonUtils.getConnection();
		try {
			if (PT_IL_PV_MED_HDR_BEAN.getPMH_POL_NO() != null
					&& !PT_IL_PV_MED_HDR_BEAN.getPMH_POL_NO().isEmpty()) {
				handler.executeUpdateStatement(c1, con, new Object[] {
						PT_IL_PV_MED_HDR_BEAN.getPMH_SYS_ID(),
						PT_IL_PV_MED_HDR_BEAN.getPMH_CLINIC_CODE(),
						PT_IL_PV_MED_HDR_BEAN.getPMH_FM_PAID_DT(),
						PT_IL_PV_MED_HDR_BEAN.getPMH_TO_PAID_DT(),
						PT_IL_PV_MED_HDR_BEAN.getPMH_POL_NO() });

				M_WHERE = " PMED_POL_SYS_ID IN (SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = "
						+ "'"
						+ PT_IL_PV_MED_HDR_BEAN.getPMH_POL_NO()
						+ "'"
						+ " AND PMED_CLINIC_CODE = "
						+ "'"
						+ PT_IL_PV_MED_HDR_BEAN.getPMH_CLINIC_CODE()
						+ "'"
						+ " AND PMED_REP_REC_DT  BETWEEN  TO_DATE('"
						+ format.format(PT_IL_PV_MED_HDR_BEAN
								.getPMH_FM_PAID_DT())
						+ "','DD/MM/RRRR')  AND TO_DATE('"
						+ format.format(PT_IL_PV_MED_HDR_BEAN
								.getPMH_TO_PAID_DT())
						+ "','DD/MM/RRRR') AND PMED_STATUS = 'Y' AND PMED_FLEX_21 IS NULL)";

				compositeAction.getDUMMY_ACTION_BEAN().setM_WHERE1(M_WHERE);
				/*
				 * SET_BLOCK_PROPERTY('PT_IL_MEDEX_FEE_DTL',DEFAULT_WHERE,M_WHERE);
				 * GO_BLOCK('PT_IL_POL_MED_EXAM_DTL');
				 * GO_ITEM('PT_IL_POL_MED_EXAM_DTL.PMED_EXAM_CODE');
				 */
				// executeQuery(compositeAction);
			} else {
				handler.executeUpdateStatement(c2, con, new Object[] {
						PT_IL_PV_MED_HDR_BEAN.getPMH_SYS_ID(),
						PT_IL_PV_MED_HDR_BEAN.getPMH_CLINIC_CODE(),
						PT_IL_PV_MED_HDR_BEAN.getPMH_FM_PAID_DT(),
						PT_IL_PV_MED_HDR_BEAN.getPMH_TO_PAID_DT() });
				M_WHERE = " PMED_CLINIC_CODE = '"
						+ PT_IL_PV_MED_HDR_BEAN.getPMH_CLINIC_CODE()
						+ "' AND PMED_STATUS = 'Y' AND PMED_REP_REC_DT  BETWEEN  TO_DATE('"
						+ format.format(PT_IL_PV_MED_HDR_BEAN
								.getPMH_FM_PAID_DT())
						+ "','DD/MM/RRRR')  AND TO_DATE('"
						+ format.format(PT_IL_PV_MED_HDR_BEAN
								.getPMH_TO_PAID_DT())
						+ "','DD/MM/RRRR') AND PMED_FLEX_21 IS NULL AND  PMED_POL_SYS_ID IN (SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_DS_TYPE = '1'   UNION SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_DS_TYPE  = '2' AND POL_PROP_NO IS NULL )";

				compositeAction.getDUMMY_ACTION_BEAN().setM_WHERE1(M_WHERE);
				/*SET_BLOCK_PROPERTY('PT_IL_POL_MED_EXAM_DTL',DEFAULT_WHERE,M_WHERE);
				  GO_BLOCK('PT_IL_POL_MED_EXAM_DTL');
				  GO_ITEM('PT_IL_POL_MED_EXAM_DTL.PMED_EXAM_CODE');*/
				//executeQuery(compositeAction);
				con.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getLocalizedMessage());
		}
	}

}
