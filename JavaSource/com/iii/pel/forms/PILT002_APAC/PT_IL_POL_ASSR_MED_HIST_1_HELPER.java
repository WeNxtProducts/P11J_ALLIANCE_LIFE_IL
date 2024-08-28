package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_ASSR_MED_HIST_1_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try{
		new PT_IL_POL_ASSR_MED_HIST_1_DELEGATE().executeSelectStatement(
				compositeAction, compositeAction
						.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_SYS_ID(),
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_1_BEAN()
						.getPOAD_POL_SYS_ID());
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	public void preInsert(PT_IL_POL_ASSURED_DTLS_1 assuredDetail,
			PT_IL_POLICY policyBean,
			PT_IL_POL_ASSR_MED_HIST_1 medical_1_Histry, CTRL ctrlBean)
			throws Exception {

		String CURSOR_C1 = "SELECT PIL_PAMH_SYS_ID.NEXTVAL FROM  DUAL ";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1 , connection);
			if (resultSet.next()) {
				medical_1_Histry.setPAMH_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			medical_1_Histry
					.setPAMH_POAD_SYS_ID(assuredDetail.getPOAD_SYS_ID());
			medical_1_Histry.setPAMH_CR_DT(new CommonUtils().getCurrentDate());
			medical_1_Histry.setPAMH_CR_UID(ctrlBean.getUSER_ID());
			medical_1_Histry.setPAMH_POL_SYS_ID(policyBean.getPOL_SYS_ID());
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
				e.printStackTrace();
			}
		}

	}

	public void whenCreateRecord(PT_IL_POL_ASSURED_DTLS_1 assuredDetail,
			PT_IL_POL_ASSR_MED_HIST_1 medical_1_Histry) {
		medical_1_Histry.setUI_M_POAD_ASSR_CODE(assuredDetail
				.getPOAD_ASSR_CODE());
		medical_1_Histry.setUI_M_POAD_ASSR_CODE_DESC(assuredDetail
				.getPOAD_ASSURED_NAME());
	}

	public void preUpdate(PT_IL_POL_ASSR_MED_HIST_1 medical_1_Histry,
			CTRL ctrlBean) throws Exception {
		try {
			medical_1_Histry.setPAMH_UPD_DT(new CommonUtils().getCurrentDate());
			medical_1_Histry.setPAMH_UPD_UID(ctrlBean.getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void postQuery(PT_IL_POL_ASSURED_DTLS_1 assuredDetail,
			PT_IL_POL_ASSR_MED_HIST_1 medical_1_Histry) {
		medical_1_Histry.setUI_M_POAD_ASSR_CODE(assuredDetail.getPOAD_ASSR_CODE());
		medical_1_Histry.setUI_M_POAD_ASSR_CODE_DESC(assuredDetail.getPOAD_ASSURED_NAME());
	}

	public void whenNewBlockInstance(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_ASSR_MED_HIST_1 medical_1_Histry = compositeAction
				.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN()
				.getPT_IL_POL_ASSR_MED_HIST_1_BEAN();
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		BP bpBean = compositeAction.getBP_ACTION_BEAN().getBP_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 assuredDetail = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();

		try {
			medical_1_Histry.setUI_M_POAD_ASSR_CODE(assuredDetail
					.getPOAD_ASSR_CODE());
			medical_1_Histry.setUI_M_POAD_ASSR_CODE_DESC(assuredDetail
					.getPOAD_ASSURED_NAME());
			localProcedure.L_LOAD_MEDICAL_HISTORY_1(policyBean,
					compositeAction
					.getPT_IL_POL_ASSR_MED_HIST_1_ACTION_BEAN(), bpBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PAMH_FIELD_WHEN_VALIDATE_ITEM(String fieldName,
			String PAMH_FIELD) throws Exception {
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		try {
			if (PAMH_FIELD != null) {
				list = procedures.L_CHK_DATA_TYPE(fieldName, PAMH_FIELD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
}
