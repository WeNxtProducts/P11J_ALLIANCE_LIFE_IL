package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILM035_PROCEDURES {

	public static ArrayList<String> P_VAL_COVER_1(String P_COVER_CODE,
			String P_COVER_DESC, String P_NAME_FLAG, String P_ERR_FLAG)
			throws Exception {

		String M_NAME = null;
		String M_BL_NAME = null;
		String M_FRZ_FLAG = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		ResultSet rs1 = null;
		ArrayList<String> retList = new ArrayList<String>();

		String C1 = "SELECT DECODE(?, 'N', COVER_DESC, COVER_LONG_DESC), "
				+ "DECODE(?,'N',COVER_BL_DESC,COVER_BL_LONG_DESC), "
				+ "COVER_FRZ_FLAG " + "FROM   PM_IL_COVER "
				+ "WHERE  COVER_CODE = ? " + "AND    COVER_TYPE IN ('A','S')";

		try {
			con = CommonUtils.getConnection();
			values = new Object[] { P_NAME_FLAG, P_NAME_FLAG, P_COVER_CODE };
			rs1 = handler.executeSelectStatement(C1, con, values);
			if (rs1.next()) {
				M_NAME = rs1.getString(1);
				M_BL_NAME = rs1.getString(2);
				M_FRZ_FLAG = rs1.getString(3);
			} else {
				if ("W".equalsIgnoreCase(P_ERR_FLAG)
						|| "E".equalsIgnoreCase(P_ERR_FLAG)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71006"));
				}
			}
			if ("Y".equalsIgnoreCase(M_FRZ_FLAG)) {
				if ("W".equalsIgnoreCase(P_ERR_FLAG)
						|| "E".equalsIgnoreCase(P_ERR_FLAG)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71007"));
				}
			}
			if ("1".equals(CommonUtils.SUBSTR(CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"), 5, 1))
					|| ("ENG".equalsIgnoreCase(CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE")))) {
				P_COVER_DESC = M_NAME;
			} else {
				P_COVER_DESC = M_BL_NAME;
			}
			retList.add(P_COVER_DESC);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return retList;
	}

	public static ArrayList<String> P_VAL_CODES(String P_CODE_TYPE,
			String P_CODE, String P_CODE_DESC, String P_NAME_FLAG,
			String P_ERR_FLAG, String P_CLASS_CODE) throws Exception {
		String M_NAME = null;
		String M_BL_NAME = null;
		String M_FRZ_FLAG = null;
		String M_DESC = null;
		Integer M_VALUE = 0;
		ArrayList<String> retList = new ArrayList<String>();
		ArrayList<String> retList1 = new ArrayList<String>();
		String M_CLASS_CODE = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		ResultSet rs1 = null;
		String C1 = "SELECT DECODE(?,'N',PC_DESC ,'L',NVL(PC_LONG_DESC,PC_DESC),PC_DESC), "
				+ "DECODE(?,'N',PC_BL_DESC ,'L',NVL(PC_BL_LONG_DESC,PC_DESC),PC_BL_DESC), "
				+ "PC_FRZ_FLAG "
				+ "FROM   PM_CODES "
				+ "WHERE  PC_TYPE = ? "
				+ "AND    PC_CODE = ?  "
				+ "AND    NVL(PC_CLASS_CODE,'*******') = NVL(? ,'*******')";
		try {
			con = CommonUtils.getConnection();
			retList1 = P_VAL_SYSTEM("CODES", P_CODE_TYPE, M_DESC, "E", M_VALUE);
			M_DESC = retList1.get(0);
			if (retList1.get(1) != null) {
				M_VALUE = Integer.parseInt(retList1.get(1));
			}

			if (CommonUtils.nvl(M_VALUE, 0) == 1) {
				M_CLASS_CODE = P_CLASS_CODE;
			} else {
				M_CLASS_CODE = null;
			}
			values = new Object[] { P_NAME_FLAG, P_NAME_FLAG, P_CODE_TYPE,
					P_CODE, M_CLASS_CODE };
			rs1 = handler.executeSelectStatement(C1, con, values);
			if (rs1.next()) {
				M_NAME = rs1.getString(1);
				M_BL_NAME = rs1.getString(2);
				M_FRZ_FLAG = rs1.getString(3);
			}

			else {
				if ("W".equalsIgnoreCase(P_ERR_FLAG)
						|| "E".equalsIgnoreCase(P_ERR_FLAG)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1010"));
				}
			}
			if ("Y".equalsIgnoreCase(M_FRZ_FLAG)) {
				if ("W".equalsIgnoreCase(P_ERR_FLAG)
						|| "E".equalsIgnoreCase(P_ERR_FLAG)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1020"));
				}
			}
			if ("1".equals(CommonUtils.SUBSTR(CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"), 5, 1))
					|| ("ENG".equalsIgnoreCase(CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE")))) {
				P_CODE_DESC = M_NAME;
			} else {
				P_CODE_DESC = M_BL_NAME;
			}
			retList.add(P_CODE_DESC);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return retList;
	}

	public static ArrayList<String> P_VAL_SYSTEM(String P_TYPE, String P_CODE,
			String P_CODE_DESC, String P_ERR_FLAG, Integer P_VALUE)
			throws Exception {
		String C1 = "SELECT PS_CODE_DESC,PS_BL_CODE_DESC,PS_VALUE "
				+ "FROM   PP_SYSTEM " + "WHERE  PS_TYPE  = ? "
				+ "AND    PS_CODE  = ?";

		String M_NAME = null;
		String M_BL_NAME = null;
		Integer M_VALUE = 0;
		ArrayList<String> retList = new ArrayList<String>();
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		ResultSet rs1 = null;

		try {
			con = CommonUtils.getConnection();
			values = new Object[] { P_TYPE, P_CODE };
			rs1 = handler.executeSelectStatement(C1, con, values);
			if (rs1.next()) {
				M_NAME = rs1.getString(1);
				M_BL_NAME = rs1.getString(2);
				M_VALUE = rs1.getInt(3);
			} else {
				if ("W".equalsIgnoreCase(P_ERR_FLAG)
						|| "E".equalsIgnoreCase(P_ERR_FLAG)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1000"));
				}
			}
			if ("1".equals(CommonUtils.SUBSTR(CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"), 5, 1))
					|| ("ENG".equalsIgnoreCase(CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE")))) {
				P_CODE_DESC = M_NAME;
			} else {
				P_CODE_DESC = M_BL_NAME;
			}
			P_VALUE = M_VALUE;
			retList.add(P_CODE_DESC);
			if (P_VALUE != null) {
				retList.add(String.valueOf(P_VALUE));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retList;
	}
}
