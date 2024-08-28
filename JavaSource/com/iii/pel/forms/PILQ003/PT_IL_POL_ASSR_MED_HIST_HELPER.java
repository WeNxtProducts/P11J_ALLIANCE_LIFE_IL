package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILQ003;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_ASSR_MED_HIST_HELPER {

	public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception
			 {
		try {
			
			new PT_IL_POL_ASSR_MED_HIST_DELEGATE().executeSelectStatement(
					compositeAction, compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_SYS_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preInsert(PT_IL_POL_ASSURED_DTLS assuredDetail,
			PT_IL_POLICY pt_il_policy,
			PT_IL_POL_ASSR_MED_HIST medicalHistry, CTRL ctrlBean)
			throws Exception {

		String CURSOR_C1 = "SELECT PIL_PAMH_SYS_ID.NEXTVAL FROM   DUAL";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				medicalHistry.setPAMH_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			
			medicalHistry.setPAMH_POAD_SYS_ID(assuredDetail.getPOAD_SYS_ID());
			medicalHistry.setPAMH_CR_DT(new CommonUtils().getCurrentDate());
			medicalHistry.setPAMH_CR_UID(ctrlBean.getUSER_ID());
			medicalHistry.setPAMH_POL_SYS_ID(pt_il_policy.getPOL_SYS_ID());
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
			try {CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void whenCreateRecord(PT_IL_POL_ASSURED_DTLS assuredDetail,
			PT_IL_POL_ASSR_MED_HIST medicalHistry) {
		medicalHistry.setUI_M_POAD_ASSR_CODE(assuredDetail.getPOAD_ASSR_CODE());
		medicalHistry.setUI_M_POAD_ASSR_CODE_DESC(assuredDetail
				.getPOAD_ASSURED_NAME());
	}

	public void preUpdate(PT_IL_POL_ASSR_MED_HIST medicalHistry, CTRL ctrlBean)
			throws Exception {
		try {
			medicalHistry.setPAMH_UPD_DT(new CommonUtils().getCurrentDate());
			medicalHistry.setPAMH_UPD_UID(ctrlBean.getUSER_ID());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}

	}

	public void postQuery(PT_IL_POL_ASSURED_DTLS assuredDetail,
			PT_IL_POL_ASSR_MED_HIST medicalHistry) throws Exception {
		try{
		medicalHistry.setUI_M_POAD_ASSR_CODE(assuredDetail.getPOAD_ASSR_CODE());
		medicalHistry.setUI_M_POAD_ASSR_CODE_DESC(assuredDetail
				.getPOAD_ASSURED_NAME());
		}catch(Exception e ){
			throw new Exception(e.getMessage());
		}
	}

	public void whenNewBlockInstance(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_ASSR_MED_HIST medicalHistry = compositeAction
				.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN()
				.getPT_IL_POL_ASSR_MED_HIST_BEAN();
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		BP bpBean = compositeAction.getBP_ACTION_BEAN().getBP_BEAN();
		PT_IL_POL_ASSURED_DTLS assuredDetail = compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
				.getPT_IL_POL_ASSURED_DTLS_BEAN();
		PKG_PILQ003 localProcedure = new PKG_PILQ003();

		try {
			medicalHistry.setUI_M_POAD_ASSR_CODE(assuredDetail
					.getPOAD_ASSR_CODE());
			medicalHistry.setUI_M_POAD_ASSR_CODE_DESC(assuredDetail
					.getPOAD_ASSURED_NAME());
			localProcedure.L_LOAD_MEDICAL_HISTORY(policyBean, compositeAction
					.getPT_IL_POL_ASSR_MED_HIST_ACTION_BEAN(),
					bpBean);
		} catch (Exception e) {
			
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
			
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}

	}

}
