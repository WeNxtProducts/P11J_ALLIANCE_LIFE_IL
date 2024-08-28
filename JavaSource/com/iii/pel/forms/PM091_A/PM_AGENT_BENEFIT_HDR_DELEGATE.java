package com.iii.pel.forms.PM091_A;

import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BENEFIT_HDR_DELEGATE {
	
	public void executeSelectStatement(PM091_A_COMPOSITE_ACTION compositeAction) throws Exception{
		ResultSet resultSet = null;
		String selectQuery = "SELECT PM_AGENT_BENEFIT_HDR.*,ROWID FROM PM_AGENT_BENEFIT_HDR WHERE ROWID = ? ";
		try{
		resultSet = new CRUDHandler().executeSelectStatement(selectQuery,CommonUtils.getConnection(),

				new Object[]{compositeAction.getPM_AGENT_BENEFIT_HDR_ACTION_BEAN().getPM_AGENT_BENEFIT_HDR_BEAN().getROWID()} );
		PM_AGENT_BENEFIT_HDR PM_AGENT_BENEFIT_HDR_BEAN = new PM_AGENT_BENEFIT_HDR();
		while(resultSet.next()){
		PM_AGENT_BENEFIT_HDR_BEAN.setROWID(resultSet.getString("ROWID"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_BNF_CODE(resultSet.getString("ABH_BNF_CODE"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_DESC(resultSet.getString("ABH_DESC"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_SHORT_DESC(resultSet.getString("ABH_SHORT_DESC"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_LONG_DESC(resultSet.getString("ABH_LONG_DESC"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_BL_DESC(resultSet.getString("ABH_BL_DESC"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_BL_SHORT_DESC(resultSet.getString("ABH_BL_SHORT_DESC"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_BL_LONG_DESC(resultSet.getString("ABH_BL_LONG_DESC"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_BNF_TYPE(resultSet.getString("ABH_BNF_TYPE"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_EFF_FM_DT(resultSet.getDate("ABH_EFF_FM_DT"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_EFF_TO_DT(resultSet.getDate("ABH_EFF_TO_DT"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_CR_DT(resultSet.getDate("ABH_CR_DT"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_CR_UID(resultSet.getString("ABH_CR_UID"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_UPD_DT(resultSet.getDate("ABH_UPD_DT"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_UPD_UID(resultSet.getString("ABH_UPD_UID"));
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_TAXABLE_YN(resultSet.getString("ABH_TAXABLE_YN"));
		}
		compositeAction.getPM_AGENT_BENEFIT_HDR_ACTION_BEAN().setPM_AGENT_BENEFIT_HDR_BEAN(PM_AGENT_BENEFIT_HDR_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	

}
