package com.iii.pel.forms.PILM201;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_CVR_GROUP_DTL_HELPER {

    public void executeQuery(PILM201_COMPOSITE_ACTION compositeAction)
	    throws Exception {
		new PM_IL_CVR_GROUP_DTL_DELEGATE().executeSelectStatement(compositeAction);

		List<PM_IL_CVR_GROUP_DTL> dataList = compositeAction
				.getPM_IL_CVR_GROUP_DTL_ACTION_BEAN()
				.getDataList_PM_IL_CVR_GROUP_DTL();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_CVR_GROUP_DTL PM_IL_CVR_GROUP_DTL_BEAN = dataList.get(0);
			PM_IL_CVR_GROUP_DTL_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_CVR_GROUP_DTL_ACTION_BEAN()
					.setPM_IL_CVR_GROUP_DTL_BEAN(PM_IL_CVR_GROUP_DTL_BEAN);
		}
	}

    public void preInsert(PM_IL_CVR_GROUP_DTL detailBean,
			PM_IL_CVR_GROUP_HDR headerBean) throws Exception {
		try {
			L_VAL_CVR_UNIQUE(detailBean, headerBean);
			detailBean.setCGD_CR_DT(new CommonUtils().getCurrentDate());
			detailBean.setCGD_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
    public void preUpdate(PM_IL_CVR_GROUP_DTL pm_il_cvr_group_dtl_bean) {
		try {
			pm_il_cvr_group_dtl_bean.setCGD_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_cvr_group_dtl_bean.setCGD_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
    public void postQuery(PM_IL_CVR_GROUP_DTL pm_il_cvr_group_dtl_bean) throws Exception {
		try {
			ArrayList<OracleParameter> list = new DBProcedures().P_VAL_CVR(
					pm_il_cvr_group_dtl_bean.getCGD_COVER_CODE(),
					pm_il_cvr_group_dtl_bean.getUI_M_CVR_DESC(), "N", "N");
			pm_il_cvr_group_dtl_bean.setUI_M_CVR_DESC((String) list.get(0)
					.getValueObject());

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
    
    public void CGD_COVER_CODE_WHEN_VALIDATE_ITEM(PM_IL_CVR_GROUP_DTL detailBean, 
    		PM_IL_CVR_GROUP_HDR headerBean) throws Exception {
	try {
	    L_VAL_CVR_UNIQUE(detailBean, headerBean);
	    ArrayList<OracleParameter> list = new DBProcedures().P_VAL_CVR(
	    		detailBean.getCGD_COVER_CODE(),
	    		detailBean.getUI_M_CVR_DESC(),"N","E");
	    
	    detailBean.setUI_M_CVR_DESC((String)list.get(0).getValueObject());
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }
    
    public void L_VAL_CVR_UNIQUE(PM_IL_CVR_GROUP_DTL detailBean,
			PM_IL_CVR_GROUP_HDR headerBean) throws Exception {
		String CURSOR_C1 = " SELECT ROWID  FROM   PM_IL_CVR_GROUP_DTL"
				+ "  WHERE  CGD_COVER_CODE  = ? "
				+ "  AND  CGD_GROUP_CODE  =  ? ";

		String M_DUMMY = null;
		ResultSet rs1 = null;
		Connection connection = null;
		String beanRowId = detailBean.getROWID();
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { detailBean.getCGD_COVER_CODE(),
							headerBean.getCGH_GROUP_CODE() });
			if (rs1.next()) {
				M_DUMMY = rs1.getString(1);
				if (CommonUtils.isDuplicate(beanRowId, M_DUMMY)) {
					System.out.println("Inside Check Duplicate.....");
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80163"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}
    
}
