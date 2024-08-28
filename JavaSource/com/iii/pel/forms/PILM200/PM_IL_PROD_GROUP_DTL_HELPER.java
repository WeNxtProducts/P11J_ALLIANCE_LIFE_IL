package com.iii.pel.forms.PILM200;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PROD_GROUP_DTL_HELPER {
   public void preInsert(PM_IL_PROD_GROUP_DTL detailBean,PILM200_COMPOSITE_ACTION compositeAction) throws Exception{
	   try {
		 detailBean.setPGD_GROUP_CODE(compositeAction.getPM_IL_PROD_GROUP_HDR_ACTION_BEAN().getPM_IL_PROD_GROUP_HDR_BEAN().getPGH_GROUP_CODE());  
		detailBean.setPGD_CR_DT(new CommonUtils().getCurrentDate());
		detailBean.setPGD_CR_UID(CommonUtils.getControlBean().getUSER_ID());
	} catch (ParseException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
   }
   public void preUpdate(PM_IL_PROD_GROUP_DTL detailBean) throws Exception{
	   try {
		detailBean.setPGD_UPD_DT(new CommonUtils().getCurrentDate());
		detailBean.setPGD_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
	} catch (ParseException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
   }
   
   public void postQuery(PM_IL_PROD_GROUP_DTL detailBean) throws Exception{
	   String temp = null;
	   try {
		temp = P_VAL_PROD(detailBean.getPGD_PROD_CODE(), 
				   						detailBean.getUI_M_PROD_DESC(),
				   						"N", "E");
		detailBean.setUI_M_PROD_DESC(temp);
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
   }
   
   public String P_VAL_PROD(String P_PROD_CODE, String P_PROD_DESC,
			String P_NAME_FLAG, String P_ERR_FLAG) throws Exception {

		String C1 = " SELECT DECODE(?,'N',PROD_DESC,PROD_SHORT_DESC), " +
				" DECODE(?,'N',PROD_BL_DESC,PROD_BL_SHORT_DESC) " +
				" FROM PM_IL_PRODUCT WHERE  PROD_CODE = ? ";

		String M_DFLT_VALUES = CommonUtils
				.getGlobalVariable("GLOBAL.M_DFLT_VALUES");
		String M_LANG_CODE = CommonUtils
				.getGlobalVariable("GLOBAL.M_LANG_CODE");
		String M_FOR_LANG_CODE = CommonUtils
				.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");


		String M_NAME = null;
		String M_BL_NAME = null;
		String M_ERR_FLAG = null;
		String M_COMP_CODE = null;
		String P_VAL_PROD = null;

		ResultSet C1_REC = null;
		Connection conn = null;
		CRUDHandler handler = null;
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			M_ERR_FLAG = P_ERR_FLAG;
			if (M_DFLT_VALUES != null) {
				M_COMP_CODE = M_DFLT_VALUES.substring(0, 3);
			}

			C1_REC = handler.executeSelectStatement(C1, conn, new Object[] {
					P_NAME_FLAG, P_NAME_FLAG, P_PROD_CODE });
			if (C1_REC.next()) {
				M_NAME = C1_REC.getString(1);
				M_BL_NAME = C1_REC.getString(2);
			} else {
				if ("W".equalsIgnoreCase(M_ERR_FLAG)
						|| "E".equalsIgnoreCase(M_ERR_FLAG)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "19046"));
				}
			}

			if (M_FOR_LANG_CODE != null
					&& "1".equalsIgnoreCase(CommonUtils.SUBSTR(M_FOR_LANG_CODE, 5, 1))
					|| "ENG".equalsIgnoreCase(M_LANG_CODE)) {
				P_VAL_PROD = M_NAME;
			} else {
				P_VAL_PROD = M_BL_NAME;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
		}
		return P_VAL_PROD;
	}
   
   
   public void  whenCreateRecord(PM_IL_PROD_GROUP_DTL detailBean){
	   detailBean.setPGD_MANDATORY_YN("N");
	   detailBean.setPGD_MANDATORY_STATUS(false);
	   detailBean.setPGD_DEFAULT_YN("N");
	   detailBean.setPGD_DEFAULT_STATUS(false);
   }
public void executeQuery(PILM200_COMPOSITE_ACTION compositeAction) throws Exception {
	try {
		new PM_IL_PROD_GROUP_DTL_DELEGATE().executeSelectStatement(compositeAction);
	

	List<PM_IL_PROD_GROUP_DTL> dataList = compositeAction.getPM_IL_PROD_GROUP_DTL_ACTION_BEAN().getDataList();
	if (dataList != null && dataList.size() > 0) {
		PM_IL_PROD_GROUP_DTL PM_IL_PROD_GROUP_DTL_BEAN = dataList.get(0);
		
		PM_IL_PROD_GROUP_DTL_BEAN.setRowSelected(true);
		compositeAction.getPM_IL_PROD_GROUP_DTL_ACTION_BEAN().setPM_IL_PROD_GROUP_DTL_BEAN(PM_IL_PROD_GROUP_DTL_BEAN);
	}
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
}
public void PGD_PROD_CODE_WHEN_VALIDATE_ITEM(
		PM_IL_PROD_GROUP_DTL detailBean,String groupCode) throws Exception {
	PILM200Procedures procedures = new PILM200Procedures();
	try {
		detailBean.setUI_M_PROD_DESC(procedures.P_VAL_PROD(detailBean.getPGD_PROD_CODE(), detailBean.getUI_M_PROD_DESC(), "N", "E"));
		procedures.L_VAL_PROD_UNIQUE(detailBean.getPGD_PROD_CODE(), groupCode,detailBean.getROWID());
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
}
public void PGD_MAIN_PROD_YN_WHEN_VALIDATE_ITEM(
		PM_IL_PROD_GROUP_DTL_ACTION detailAction,
		PM_IL_PROD_GROUP_DTL detailBean) {
	
	for (PM_IL_PROD_GROUP_DTL tempBean :detailAction.getDataList()) {
		if ("Y".equals(tempBean.getPGD_MAIN_PROD_YN())) {
			detailAction.getCOMP_PGD_MAIN_PROD_YN().setDisabled(true);
			detailBean.setPGD_MANDATORY_YN("Y");
			detailBean.setPGD_MANDATORY_STATUS(true);
			detailBean.setPGD_DEFAULT_YN("Y");
			detailBean.setPGD_DEFAULT_STATUS(true);
			//detailAction.getCOMP_PGD_MANDATORY_YN().setDisabled(true);
			//detailAction.getCOMP_PGD_DEFAULT_YN().setDisabled(true);
		}else{
			detailAction.getCOMP_PGD_MANDATORY_YN().setDisabled(false);
			detailAction.getCOMP_PGD_DEFAULT_YN().setDisabled(false);
		}
		
	}
	
	  
	
}
public void PGD_MANDATORY_YN_WHEN_VALIDATE_ITEM(
		PM_IL_PROD_GROUP_DTL_ACTION detailAction,
		PM_IL_PROD_GROUP_DTL detailBean) {
	/*if ("Y".equals(detailBean.getPGD_MAIN_PROD_YN())) {
		detailBean.setPGD_MANDATORY_YN("Y");
		detailBean.setPGD_MANDATORY_STATUS(true);
		detailBean.setPGD_DEFAULT_YN("Y");
		detailBean.setPGD_DEFAULT_STATUS(true);
		//detailAction.getCOMP_PGD_MANDATORY_YN().setDisabled(true);
		//detailAction.getCOMP_PGD_DEFAULT_YN().setDisabled(true);
	}else {
		detailAction.getCOMP_PGD_MANDATORY_YN().setDisabled(false);
		detailAction.getCOMP_PGD_DEFAULT_YN().setDisabled(false);
	}*/
	if ("Y".equals(detailBean.getPGD_MANDATORY_YN())) {
		detailBean.setPGD_DEFAULT_YN("Y");
		detailBean.setPGD_DEFAULT_STATUS(true);
		if (detailAction.getCOMP_PGD_DEFAULT_YN().isDisabled()== false) {
			detailAction.getCOMP_PGD_DEFAULT_YN().setDisabled(true);
		}
	}else {
		detailAction.getCOMP_PGD_DEFAULT_YN().setDisabled(false);
	}

}

public void PGD_DEFAULT_YN_WHEN_VALIDATE_ITEM(
		PM_IL_PROD_GROUP_DTL detailBean) {
	if ("Y".equals(detailBean.getPGD_MANDATORY_YN())) {
		detailBean.setPGD_DEFAULT_YN("Y");
	}
	
}
}
