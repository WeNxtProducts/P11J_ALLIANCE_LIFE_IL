package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PLAN_MEMBERS_HELPER {
	
public void WHEN_NEW_BLOCK_INSTANCE(PM_IL_PLAN_MEMBERS PM_IL_PLAN_MEMBERS_BEAN , PILM003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PLAN planBean = null;
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
	
	}
	public void executeQuery(PILM003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_PLAN_MEMBERS_DELEGATE().executeSelectStatement(compositeAction);

		List<PM_IL_PLAN_MEMBERS> dataList = compositeAction.getPM_IL_PLAN_MEMBERS_ACTION_BEAN().getDataList_PM_IL_PLAN_MEMBERS();//dataList_PM_IL_PLAN_MEMBERS
		if (dataList != null && dataList.size() > 0) {
			PM_IL_PLAN_MEMBERS PM_IL_PLAN_MEMBERS_BEAN = dataList.get(0);
			PM_IL_PLAN_MEMBERS_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_PLAN_MEMBERS_ACTION_BEAN().setPM_IL_PLAN_MEMBERS_BEAN(PM_IL_PLAN_MEMBERS_BEAN);
		}
	}
	public void WHEN_CREATE_RECORD(PM_IL_PLAN_MEMBERS PM_IL_PLAN_MEMBERS_BEAN,PILM003_APAC_COMPOSITE_ACTION compositeAction) {
	
		PM_IL_PLAN_MEMBERS_BEAN.setPMEM_PLAN_CODE(compositeAction.getPM_IL_PLAN_MEMBERS_ACTION_BEAN().getPM_IL_PLAN_MEMBERS_BEAN().getPMEM_PLAN_CODE());
		PM_IL_PLAN_MEMBERS_BEAN.setPMEM_RELATION_TYPE("01");
		PM_IL_PLAN_MEMBERS_BEAN.setPMEM_MIN_SA(0.0);
		PM_IL_PLAN_MEMBERS_BEAN.setPMEM_MAX_SA(0.0);
		}
	public void PRE_INSERT(PM_IL_PLAN_MEMBERS PM_IL_PLAN_MEMBERS_BEAN, PILM003_APAC_COMPOSITE_ACTION compositeAction ) throws Exception{
		try {
			
			PM_IL_PLAN_MEMBERS_BEAN.setPMEM_PLAN_CODE(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE());
			PM_IL_PLAN_MEMBERS_BEAN.setPMEM_CR_DT(new CommonUtils().getCurrentDate());
			PM_IL_PLAN_MEMBERS_BEAN.setPMEM_CR_UID(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void PRE_UPDATE(PM_IL_PLAN_MEMBERS PM_IL_PLAN_MEMBERS_BEAN,PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	try {
		
			PM_IL_PLAN_MEMBERS_BEAN.setPMEM_UPD_DT(new CommonUtils().getCurrentDate());
			PM_IL_PLAN_MEMBERS_BEAN.setPMEM_UPD_UID(CommonUtils.getControlBean()
					.getUSER_ID());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
	}
	
	public String check_duplicate(String PM_IL_PLAN_MEMB,String PMEM_RELATION_TYPE,String PMEM_RELATION_TYPE_VALUE,String PMEM_PLAN_CODE,String PMEM_PLAN_CODE_VALUE,String PMEM_DEP_TYPE) throws Exception {
		
		String CURSOR_C1 = "select PCOPK_GENERAL.CHK_DUPLICATE(?,?,?,?,?,?) from dual";
		ResultSet resultSet = null;
		Connection connection = null;
		String CHK_DUPLICATE=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] {PM_IL_PLAN_MEMB,PMEM_RELATION_TYPE,PMEM_RELATION_TYPE_VALUE,PMEM_PLAN_CODE,PMEM_PLAN_CODE_VALUE,PMEM_DEP_TYPE});
			if (resultSet.next()) {
				CHK_DUPLICATE= resultSet.getString(1);
				
			}
			} catch (DBException e) {
			throw new Exception(e.getMessage());
		}
		return CHK_DUPLICATE;  
		}
	
	
}
