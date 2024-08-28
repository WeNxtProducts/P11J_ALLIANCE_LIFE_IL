package com.iii.pel.forms.PILP091_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_CONT_PAID_HDR_HELPER {

	public void executeQuery(PILP091_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PS_IL_CONT_PAID_HDR_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PS_IL_CONT_PAID_HDR> dataList = compositeAction
				.getPS_IL_CONT_PAID_HDR_ACTION_BEAN()
				.getDataList_PS_IL_CONT_PAID_HDR();
		if (dataList != null && dataList.size() > 0) {
			PS_IL_CONT_PAID_HDR PS_IL_CONT_PAID_HDR_BEAN = dataList.get(0);
			PS_IL_CONT_PAID_HDR_BEAN.setRowSelected(true);
			compositeAction.getPS_IL_CONT_PAID_HDR_ACTION_BEAN()
					.setPS_IL_CONT_PAID_HDR_BEAN(PS_IL_CONT_PAID_HDR_BEAN);
		}
	}
	public void WHEN_NEW_FORM_INSTANCE(
			PILP091_APAC_COMPOSITE_ACTION compositeAction){
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
			dummy_bean.setUI_M_REPORT_NAME("D");

	}

	public void WHEN_VALIDATE_ITEM_CPH_CONFIRM_FLAG(
			PILP091_APAC_COMPOSITE_ACTION compositeAction, Object currValue) throws Exception{
		PS_IL_CONT_PAID_HDR ps_il_cont_paid_hdr_bean = compositeAction
				.getPS_IL_CONT_PAID_HDR_ACTION_BEAN()
				.getPS_IL_CONT_PAID_HDR_BEAN();
		String CPH_FREEZE_FLAG = (String) currValue;
			try {
				if ("N".equalsIgnoreCase(CPH_FREEZE_FLAG)) {
					if ("Y".equalsIgnoreCase(ps_il_cont_paid_hdr_bean
							.getCPH_CONFIRM_FLAG())) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "Make the freeze flag Yes" }));

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	public void WHEN_LIST_CHANGED(PILP091_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PS_IL_CONT_PAID_HDR ps_il_cont_paid_hdr_bean = compositeAction
				.getPS_IL_CONT_PAID_HDR_ACTION_BEAN()
				.getPS_IL_CONT_PAID_HDR_BEAN();
			try {
				if ("N".equalsIgnoreCase(ps_il_cont_paid_hdr_bean
						.getCPH_FREEZE_FLAG())) {
					if ("Y".equalsIgnoreCase(ps_il_cont_paid_hdr_bean
							.getCPH_CONFIRM_FLAG())) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { "Make the freeze flag Yes" }));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	public void P_VAL_FINAL_PARAMETER(String P_ID, String P_VALUE,
			String P_ERR_FLAG) throws Exception {
		ResultSet rs = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT PARA_VALUE " + " FROM   FP_PARAMETER "
				+ "WHERE  PARA_ID = P_ID ";
		try {
			con = CommonUtils.getConnection();
			while (rs.next()) {
				P_VALUE = rs.getString(1);
			}
			rs = handler.executeSelectStatement(C1, con);
			if (P_VALUE == null) {
				if (("W".equalsIgnoreCase(P_ERR_FLAG))
						|| ("E".equalsIgnoreCase(P_ERR_FLAG))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1040"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);} catch (Exception e) {}
		}
	}
}
