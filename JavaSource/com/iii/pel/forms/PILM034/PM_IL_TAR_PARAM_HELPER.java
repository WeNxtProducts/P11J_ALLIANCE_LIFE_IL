package com.iii.pel.forms.PILM034;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_TAR_PARAM_HELPER {


	public void executeQuery(PILM034_COMPOSITE_ACTION compositeAction) throws Exception {
		new PM_IL_TAR_PARAM_DELEGATE().executeSelectStatement(compositeAction);

		List<PM_IL_TAR_PARAM> dataList = compositeAction.
		getPM_IL_TAR_PARAM_ACTION_BEAN().getDataList_PM_IL_TAR_PARAM();
		if(dataList!=null && dataList.size() > 0){
			PM_IL_TAR_PARAM PM_IL_TAR_PARAM_BEAN = dataList.get(0);
			PM_IL_TAR_PARAM_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_TAR_PARAM_ACTION_BEAN()
			.setPM_IL_TAR_PARAM_BEAN(PM_IL_TAR_PARAM_BEAN);

			compositeAction.getPM_IL_TAR_PARAM_ACTION_BEAN().setDataListPM_IL_TAR_PARAM(dataList);
		}
	}

	public void preInsert(PM_IL_TAR_PARAM pm_il_tar_param) throws Exception{
		CommonUtils commonUtils = new CommonUtils();
		try {
			L_CHECK_SRNO(pm_il_tar_param);
			pm_il_tar_param.setTP_CR_DT(commonUtils.getCurrentDate());
			pm_il_tar_param.setTP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void key_delrec(PM_IL_TAR_PARAM valueBean) throws Exception{
		int M_PARAM_SRNO=0;
		String M_VAR=null;
		ResultSet resultSet=null;
		String C1 = null;
		Object values[]=null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try{
			connection = CommonUtils.getConnection();
			C1= "SELECT 'X' FROM PM_IL_TAR_HDR WHERE TH_PARA_01 = ? OR TH_PARA_02 = ? " +
			"OR TH_PARA_03 = ? OR TH_PARA_04 = ? OR TH_PARA_05 = ? OR TH_PARA_06 = ?" +
			"OR TH_PARA_07 = ? OR TH_PARA_08 = ? OR TH_PARA_09 = ? OR TH_PARA_10 = ?";
			M_PARAM_SRNO=valueBean.getTP_SRNO();
			values = new Object[10];
			values[0] = M_PARAM_SRNO;
			values[1] = M_PARAM_SRNO;
			values[2] = M_PARAM_SRNO;
			values[3] = M_PARAM_SRNO;
			values[4] = M_PARAM_SRNO;
			values[5] = M_PARAM_SRNO;
			values[6] = M_PARAM_SRNO;
			values[7] = M_PARAM_SRNO;
			values[8] = M_PARAM_SRNO;
			values[9] = M_PARAM_SRNO;

			resultSet = handler.executeSelectStatement(C1, connection, values);

			if(resultSet.next()){
				M_VAR=resultSet.getString(1);
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91050"));
			}else{
				//KEY_DELREC;
			}
		}catch(Exception e)	{
			throw new Exception(e.getMessage());
		}
		finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){e.printStackTrace();}
		}
	} 

	public void preUpdate(PM_IL_TAR_PARAM pm_il_tar_param) throws Exception{
		CommonUtils commonUtils = new CommonUtils();
		try {
			L_CHECK_SRNO(pm_il_tar_param);
			pm_il_tar_param.setTP_UPD_DT(commonUtils.getCurrentDate());
			pm_il_tar_param.setTP_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void preBlock(){
		CommonUtils.setGlobalVariable("GLOBAL.M_CLM_SYS_ID", null);
	}
	public void WHEN_CREATE_RECORD(PM_IL_TAR_PARAM pm_il_tar_param){
		pm_il_tar_param.setTP_DATA_TYPE("C");
	}

	private void L_CHECK_SRNO(PM_IL_TAR_PARAM pm_il_tar_param) throws Exception {
		String M_VAR = null;
		int srno;
		String rowId = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			srno = pm_il_tar_param.getTP_SRNO();
			rowId = pm_il_tar_param.getROWID();
			Object values1[] = { srno };
			Object values2[] = { srno, rowId };
			String C1 = "SELECT 'X' FROM PM_IL_TAR_PARAM WHERE TP_SRNO = ?";
			String C2 = "SELECT 'X' FROM PM_IL_TAR_PARAM WHERE TP_SRNO =  ? AND ROWID != ?";
			if (rowId == null) {
				resultSetC1 = handler.executeSelectStatement(C1, con, values1);
				if (resultSetC1.next()) {
					M_VAR = resultSetC1.getString(1);

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91000"));
				}
			} else if (rowId != null) {
				resultSetC2 = handler.executeSelectStatement(C2, con, values2);
				if (resultSetC2.next()) {
					M_VAR = resultSetC2.getString(1);

					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91000"));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		finally{
			try {CommonUtils.closeCursor(resultSetC1);}catch(Exception e){}
			try {CommonUtils.closeCursor(resultSetC2);}catch (Exception e){}
		}
	}
}
