package com.iii.pel.forms.PILM035_APAC;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PROD_APPL_CVR_GRP_HELPER {

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_PROD_APPL_CVR_GRP_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_PROD_APPL_CVR_GRP> dataList = compositeAction
				.getPM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN()
				.getDataList_PM_IL_PROD_APPL_CVR_GRP();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_PROD_APPL_CVR_GRP PM_IL_PROD_APPL_CVR_GRP_BEAN = dataList
					.get(0);
			PM_IL_PROD_APPL_CVR_GRP_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN()
					.setPM_IL_PROD_APPL_CVR_GRP_BEAN(
							PM_IL_PROD_APPL_CVR_GRP_BEAN);
		}
	}
	
	                                                                                                                                                                              

	
	

	public void preInsert(PM_IL_PROD_APPL_CVR_GRP coverGroupBean,
			PM_IL_PRODUCT ProductBean) throws Exception {
		try {
			coverGroupBean.setPACG_PROD_CODE(ProductBean.getPROD_CODE());
			coverGroupBean.setPACG_CR_DT(new CommonUtils().getCurrentDate());
			coverGroupBean.setPACG_CR_UID(CommonUtils.getControlBean()
					.getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preUpdate(PM_IL_PROD_APPL_CVR_GRP coverGroupBean)
			throws Exception {
		try {
			coverGroupBean.setPACG_UPD_DT(new CommonUtils().getCurrentDate());
			coverGroupBean.setPACG_UPD_UID(CommonUtils.getControlBean()
					.getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void postQuery(PM_IL_PROD_APPL_CVR_GRP coverGroupBean)
			throws Exception {
		DBProcedures procedures = new DBProcedures();
		try {
			coverGroupBean.setUI_M_CVR_GROUP_DESC(PILM035_APAC_DBProcedures.P_VAL_CVR_GRP(
					coverGroupBean.getPACG_CVR_GROUP_CODE(), coverGroupBean
							.getUI_M_CVR_GROUP_DESC(), "N", "E"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preDelete(PM_IL_PROD_APPL_CVR_GRP coverGroupBean)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		String DELETE_QUERY = "DELETE FROM PM_IL_PROD_APPL_COVER  WHERE PAC_GROUP_CVR_CODE = ? ";
		try {
			handler.executeDeleteStatement(DELETE_QUERY, CommonUtils
					.getConnection(), new Object[] { coverGroupBean
					.getPACG_CVR_GROUP_CODE() });
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void PACG_CVR_GROUP_CODE_WHEN_VALIDATE_ITEM(
			PM_IL_PROD_APPL_CVR_GRP coverGroupBean) throws Exception {
		DBProcedures procedures = new DBProcedures();
		try {
			PILM035_APAC_DBProcedures.L_VAL_GRP_UNIQUE(coverGroupBean.getPACG_PROD_CODE(),
					coverGroupBean.getPACG_CVR_GROUP_CODE(), coverGroupBean
							.getROWID());
			coverGroupBean.setUI_M_CVR_GROUP_DESC(PILM035_APAC_DBProcedures.P_VAL_CVR_GRP(
					coverGroupBean.getPACG_CVR_GROUP_CODE(), coverGroupBean
							.getUI_M_CVR_GROUP_DESC(), "N", "E"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void PACG_MANDATORY_YN_WHEN_VALIDATE_ITEM(
			PM_IL_PROD_APPL_CVR_GRP coverGroupBean) {
		if ("Y".equals(coverGroupBean.getPACG_MANDATORY_YN())) {
			coverGroupBean.setPACG_DEFAULT_YN("Y");
		}

	}

	public void PACG_DEFAULT_YN_WHEN_VALIDATE_ITEM(
			PM_IL_PROD_APPL_CVR_GRP coverGroupBean) {

		if ("Y".equals(coverGroupBean.getPACG_MANDATORY_YN())) {
			coverGroupBean.setPACG_DEFAULT_YN("Y");
		}

	}

	public void onPopulateDetail(PILM035_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	    PM_IL_PROD_APPL_CVR_GRP PM_IL_PROD_APPL_CVR_GRP = compositeAction
    		.getPM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN()
    		.getPM_IL_PROD_APPL_CVR_GRP_BEAN();
    	try {
    	    if ((PM_IL_PROD_APPL_CVR_GRP.getPACG_CVR_GROUP_CODE() != null)  ) {
    		PM_IL_PROD_APPL_COVER_DELEGATE delegate = new PM_IL_PROD_APPL_COVER_DELEGATE();
    		delegate.executeSelectStatement(compositeAction);
    	    }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    throw new Exception(e.getMessage());
    	}
	}
	
}
