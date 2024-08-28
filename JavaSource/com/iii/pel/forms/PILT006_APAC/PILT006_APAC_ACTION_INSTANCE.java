package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILT006_APAC_ACTION_INSTANCE {

	public static Map<String, Object> getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
	}

	public static PILT006_APAC_COMPOSITE_ACTION getCompositeActionInstance() {
		return (PILT006_APAC_COMPOSITE_ACTION) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap().get(
						"PILT006_APAC_COMPOSITE_ACTION");
	}

	public static PT_IL_CLAIM_ACTION getClaimActionInstance() {
		return getCompositeActionInstance().getPT_IL_CLAIM_ACTION_BEAN();
	}

	public static PT_IL_CLAIM_COVER_DTLS_ACTION getClaimCoverDtlsActionInstance() {
		return getCompositeActionInstance()
				.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN();
	}

	public static PT_IL_CLAIM_ESTIMATE_ACTION getClaimEstimateActionInstance() {
		return getCompositeActionInstance()
				.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN();
	}

	public static PT_IL_CLAIM_STATUS_ACTION getClaimStatusActionInstance() {
		return getCompositeActionInstance().getPT_IL_CLAIM_STATUS_ACTION_BEAN();
	}

	public static PT_IL_CLAIM_STATUS_1_ACTION getClaimStatus1ActionInstance() {
		return getCompositeActionInstance()
				.getPT_IL_CLAIM_STATUS_1_ACTION_BEAN();
	}

	public static PT_IL_CLAIM_STATUS_3_ACTION getClaimStatus3ActionInstance() {
		return getCompositeActionInstance()
				.getPT_IL_CLAIM_STATUS_3_ACTION_BEAN();
	}

	public static PT_IL_CLAIM_STATUS_2_ACTION getClaimStatus2ActionInstance() {
		return getCompositeActionInstance()
				.getPT_IL_CLAIM_STATUS_2_ACTION_BEAN();
	}

	public static PT_IL_BONUS_ACTION getBonusActionInstance() {
		return getCompositeActionInstance().getPT_IL_BONUS_ACTION_BEAN();
	}

	public static PT_IL_CLAIM_ACC_FIR_DTLS_ACTION getClaimAccFirDtlsActionInstance() {
		return getCompositeActionInstance()
				.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN();
	}

	public static PT_IL_DOC_TODO_LIST_STATUS_ACTION getToDoListStatusActionInstance() {
		return getCompositeActionInstance()
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
	}

	public static PT_IL_FUND_TRAN_DTL_ACTION getFundTranDtlActionInstance() {
		return getCompositeActionInstance()
				.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN();
	}

	public static PH_IL_CLAIM_COVER_DTLS_ACTION getPhClaimCoverDtlsActionInstance() {
		return getCompositeActionInstance()
				.getPH_IL_CLAIM_COVER_DTLS_ACTION_BEAN();
	}

	public static PM_IL_DOC_TODO_GROUP_ACTION getToDoGroupActionInstance() {
		return getCompositeActionInstance()
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN();
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
