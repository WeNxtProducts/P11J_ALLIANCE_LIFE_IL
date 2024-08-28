package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_DELEGATE {
    public void executeSelectStatement(
	    PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	String selectStatement = " SELECT ROWID, PM_IL_DOC_TODO_GROUP.*  FROM PM_IL_DOC_TODO_GROUP WHERE "
		+ "  PM_IL_DOC_TODO_GROUP.DTG_DS_CODE = ? AND "
		+ " PM_IL_DOC_TODO_GROUP.DTG_DS_TYPE = ? ";
	Connection connection = null;
	ResultSet resultSet = null;
	PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN = null;
	compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
		.getDataList_PM_IL_DOC_TODO_GROUP().clear();
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(
		    selectStatement, connection, new Object[] { compositeAction
			    .getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
			    .getPM_IL_DOC_TODO_GROUP_BEAN()
			    .getDTG_DS_CODE(),
			    compositeAction
			    .getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
			    .getPM_IL_DOC_TODO_GROUP_BEAN()
			    .getDTG_DS_TYPE() });
	    while (resultSet.next()) {
		PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
		PM_IL_DOC_TODO_GROUP_BEAN
			.setROWID(resultSet.getString("ROWID"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_TYPE(resultSet
			.getString("DTG_DS_TYPE"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_CODE(resultSet
			.getString("DTG_DS_CODE"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_CODE(resultSet
			.getString("DTG_GROUP_CODE"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_RESULT(resultSet
			.getString("DTG_RESULT"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_CR_DT(resultSet
			.getDate("DTG_CR_DT"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_CR_UID(resultSet
			.getString("DTG_CR_UID"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_UPD_DT(resultSet
			.getDate("DTG_UPD_DT"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_UPD_UID(resultSet
			.getString("DTG_UPD_UID"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_TYPE(resultSet
			.getString("DTG_GROUP_TYPE"));
		PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_DESC(resultSet
			.getString("DTG_GROUP_DESC"));
		
		
		
		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
			.getDataList_PM_IL_DOC_TODO_GROUP().add(
				PM_IL_DOC_TODO_GROUP_BEAN);
	    }
	} finally {
	    CommonUtils.closeCursor(resultSet);
	}
    }
    
    
    /*Added by Raja .R on 04-07-2016.SSP Call ID - FALCONQC-1714757

    Start*/ 
    
    public void executeSelectStatement1(
    	    PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
    	/*
    	 * String selectStatement = " SELECT ROWID, PT_IL_DOC_TODO_LIST_STATUS.*
    	 * FROM PT_IL_DOC_TODO_LIST_STATUS " + "WHERE DTLS_GROUP_CODE = ?";
    	 */
    	/*Commented and modified by pidugu raj dt: 22-09-2020 for Alliance IL
    	 * String selectStatement = " SELECT ROWID,PT_IL_DOC_TODO_LIST_STATUS.* FROM PT_IL_DOC_TODO_LIST_STATUS "
    		+ " WHERE PT_IL_DOC_TODO_LIST_STATUS.DTLS_POL_SYS_ID = ?  "
    		+ " AND  PT_IL_DOC_TODO_LIST_STATUS.DTLS_END_NO_IDX =?  AND DTLS_GROUP_CODE = ? ";
    	*/
    	/*String selectStatement = " SELECT ROWID,PT_IL_DOC_TODO_LIST_STATUS.* FROM PT_IL_DOC_TODO_LIST_STATUS "
        		+ " WHERE PT_IL_DOC_TODO_LIST_STATUS.DTLS_POL_SYS_ID = ?  "
        		+ " AND  PT_IL_DOC_TODO_LIST_STATUS.DTLS_END_NO_IDX =?  AND DTLS_GROUP_CODE = ? ORDER BY DTLS_SR_NO ASC ";
    	*/
    	/*Commented and modified by pidugu raj dt: 02-12-2020 for Alliance IL as suggested by Ashok Sengottuvelu*/
    	String selectStatement = " SELECT ROWID,PT_IL_DOC_TODO_LIST_STATUS.* FROM PT_IL_DOC_TODO_LIST_STATUS "
        		+ " WHERE PT_IL_DOC_TODO_LIST_STATUS.DTLS_POL_SYS_ID = ?  "
        		+ " AND  PT_IL_DOC_TODO_LIST_STATUS.DTLS_END_NO_IDX =?  AND DTLS_GROUP_CODE = ? ORDER BY DTLS_SR_NO ASC ,DTLS_TODO_LIST_ITEM  ";
        		/*End*/
    	Connection connection = null;
    	ResultSet resultSet = null;
    	compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
    		.getDataList_PT_IL_DOC_TODO_LIST_STATUS().clear();

    	PT_IL_POLICY pt_il_policy_bean = compositeAction
    		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
    	PM_IL_DOC_TODO_GROUP groupBean = compositeAction
    		.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
    		.getPM_IL_DOC_TODO_GROUP_BEAN();

    	try {
    	    connection = CommonUtils.getConnection();
    	    PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN = null;
    	    resultSet = new CRUDHandler().executeSelectStatement(
    		    selectStatement, connection, new Object[] {
    			    pt_il_policy_bean.getPOL_SYS_ID(),
    			    pt_il_policy_bean.getPOL_END_NO_IDX(),
    			    groupBean.getDTG_GROUP_CODE() });
    	    while (resultSet.next()) {
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setROWID(resultSet
    			.getString("ROWID"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SYS_ID(resultSet
    			.getLong("DTLS_SYS_ID"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_POL_SYS_ID(resultSet
    			.getLong("DTLS_POL_SYS_ID"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_END_NO_IDX(resultSet
    			.getInt("DTLS_END_NO_IDX"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CLM_SYS_ID(resultSet
    			.getLong("DTLS_CLM_SYS_ID"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SR_NO(resultSet
    			.getDouble("DTLS_SR_NO"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN
    			.setDTLS_TODO_LIST_ITEM(resultSet
    				.getString("DTLS_TODO_LIST_ITEM"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_MANDATORY_YN(resultSet
    			.getString("DTLS_MANDATORY_YN"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS(resultSet
    			.getString("DTLS_APPR_STS"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_REMARKS(resultSet
    			.getString("DTLS_REMARKS"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CR_DT(resultSet
    			.getDate("DTLS_CR_DT"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CR_UID(resultSet
    			.getString("DTLS_CR_UID"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_UPD_DT(resultSet
    			.getDate("DTLS_UPD_DT"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_UPD_UID(resultSet
    			.getString("DTLS_UPD_UID"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_GROUP_CODE(resultSet
    			.getString("DTLS_GROUP_CODE"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_DOC_REC_DT(resultSet
    			.getDate("DTLS_DOC_REC_DT"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SMV_SYS_ID(resultSet
    			.getLong("DTLS_SMV_SYS_ID"));
    		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_WD_SYS_ID(resultSet
    			.getLong("DTLS_WD_SYS_ID"));

    		/*Added by Ram on 15/12/2016 for Enabling fields in Datagrid*/
    		if(compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
        			.getDataList_PT_IL_DOC_TODO_LIST_STATUS() != null && 
        					compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
        	    			.getDataList_PT_IL_DOC_TODO_LIST_STATUS().size() == 0)
    		{
    			System.out.println("PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected()      "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected()+" "+
    					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()+"     "+
    					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()+"     "+
    					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
    		if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected() != null && PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected().equals("dataTableNonSelectedRow"))
    		{
    			if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
    				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("Y")))
    			{
    				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
    				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
    			}
    			else
    			{
    				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");
    				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
    			}
    		}
    		}
    		/*End*/
    		
    		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
    			.getDataList_PT_IL_DOC_TODO_LIST_STATUS().add(
    				PT_IL_DOC_TODO_LIST_STATUS_BEAN);
    	    }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    throw new Exception(e.getMessage());
    	} finally {
    	    CommonUtils.closeCursor(resultSet);
    	}
        }
       
    
	/*End of SSP Call ID - FALCONQC-1714757 */

}
