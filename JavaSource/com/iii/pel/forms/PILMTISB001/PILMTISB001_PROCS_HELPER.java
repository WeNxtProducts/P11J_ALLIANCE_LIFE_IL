package com.iii.pel.forms.PILMTISB001;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILMTISB001_PROCS_HELPER {

	CRUDHandler handler = new CRUDHandler();

	public String L_GET_ANLY1_DESC(String currValue) throws Exception {
		String C1 = "SELECT ANLY_NAME FROM   FM_ANALYSIS WHERE  ANLY_HEAD_NO = '1' "
				+ "AND    ANLY_CODE = ?";
		ResultSet rs1 = null;
		Connection con = null;
		String desc = null;
		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { currValue });
			if (rs1.next()) {
				desc = rs1.getString(1);
			}else
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, ""));
			return desc;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String L_GET_ANLY2_DESC(String currValue) throws Exception {
		String C1 = "SELECT ANLY_NAME FROM   FM_ANALYSIS WHERE  ANLY_HEAD_NO = '2' "
				+ "AND    ANLY_CODE = ?";
		ResultSet rs1 = null;
		Connection con = null;
		String desc = null;
		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { currValue });
			if (rs1.next()) {
				desc = rs1.getString(1);
			}else
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, ""));
			return desc;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String L_GET_COVER_DESC(String currValue) throws Exception {
		// TODO Auto-generated method stub
		String C1 = " SELECT COVER_DESC FROM   PM_IL_COVER WHERE  COVER_CODE = ?";
		ResultSet rs1 = null;
		Connection con = null;
		String desc = null;
		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { currValue });
			if (rs1.next()) {
				desc = rs1.getString(1);
			}else
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71006"));
			return desc;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String L_GET_PROD_DESC(String currValue) throws Exception {
		// TODO Auto-generated method stub
		String C1 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
		ResultSet rs1 = null;
		Connection con = null;
		String desc = null;
		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { currValue });
			if (rs1.next()) {
				desc = rs1.getString(1);
			}else
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91074"));
			return desc;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String L_GET_EXP_CODE_DESC(String currValue) throws Exception {
		// TODO Auto-generated method stub
		String C1 = "SELECT TH_DESC FROM PM_IL_TAR_HDR WHERE TH_PARAM_TYPE ='M' AND   TH_CODE = ?";
		ResultSet rs1 = null;
		Connection con = null;
		String desc = null;
		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { currValue });
			if (rs1.next()) {
				desc = rs1.getString(1);
			}
			return desc;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public String L_GET_MORT_CODE_DESC(String currValue) throws Exception {
		// TODO Auto-generated method stub
		String C1 = "SELECT TH_DESC FROM PM_IL_TAR_HDR WHERE TH_PARAM_TYPE ='M' AND   TH_CODE = ?";
		ResultSet rs1 = null;
		Connection con = null;
		String desc = null;
		try {
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { currValue });
			if (rs1.next()) {
				desc = rs1.getString(1);
			}else
				throw new Exception( "Tariff setup is mssing '" + currValue+'"');
			return desc;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
