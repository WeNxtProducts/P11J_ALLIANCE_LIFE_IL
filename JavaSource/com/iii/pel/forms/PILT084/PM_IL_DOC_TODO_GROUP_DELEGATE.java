package com.iii.pel.forms.PILT084;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_DELEGATE {
    public void executeSelectStatement(
    		PILT084_COMPOSITE_ACTION_BEAN compositeAction) throws Exception {
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
    		PILT084_COMPOSITE_ACTION_BEAN compositeAction) throws Exception {
    	/*
    	 * String selectStatement = " SELECT ROWID, PT_IL_DOC_TODO_LIST_STATUS.*
    	 * FROM PT_IL_DOC_TODO_LIST_STATUS " + "WHERE DTL_GROUP_CODE = ?";
    	 */
    	/*String selectStatement = " SELECT ROWID,PT_IL_OCD_DOC_TODO_LIST.* FROM PT_IL_OCD_DOC_TODO_LIST "
    		+ " WHERE PT_IL_OCD_DOC_TODO_LIST.OCD_DTL_POL_SYS_ID = ?  "
    		+ " AND  PT_IL_OCD_DOC_TODO_LIST.DTL_END_NO_IDX =?  AND DTL_GROUP_CODE = ? ";*/
    	String selectStatement = " SELECT ROWID,PT_IL_OCD_DOC_TODO_LIST.* FROM PT_IL_OCD_DOC_TODO_LIST "
        		+ " WHERE PT_IL_OCD_DOC_TODO_LIST.OCD_DTL_POL_SYS_ID = ?  AND PT_IL_OCD_DOC_TODO_LIST.OCD_DTL_TRANS_SYS_ID = ?"
        		+ " AND OCD_DTL_GROUP_CODE = ? ";
    	Connection connection = null;
    	ResultSet resultSet = null;
    	compositeAction.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN()
    		.getDataList_PT_IL_OCD_DOC_TODO_LIST().clear();

    	PT_IL_PAYOUT_PROCESS pt_il_payout_process_bean = compositeAction
    		.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN();
    	PM_IL_DOC_TODO_GROUP groupBean = compositeAction
    		.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
    		.getPM_IL_DOC_TODO_GROUP_BEAN();

    	try {
    	    connection = CommonUtils.getConnection();
    	    PT_IL_OCD_DOC_TODO_LIST PT_IL_OCD_DOC_TODO_LIST_BEAN = null;
    	    resultSet = new CRUDHandler().executeSelectStatement(
    		    selectStatement, connection, new Object[] {
    		    		(Long) CommonUtils.getGlobalObject("OCD_POL_SYS_ID"),
    		    		(Long) CommonUtils.getGlobalObject("OCD_TRANS_SYS_ID"),
    			    groupBean.getDTG_GROUP_CODE() });
    	    while (resultSet.next()) {
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN = new PT_IL_OCD_DOC_TODO_LIST();
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setROWID(resultSet
    			.getString("ROWID"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_SYS_ID(resultSet
    			.getLong("OCD_DTL_SYS_ID"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_POL_SYS_ID(resultSet
    			.getLong("OCD_DTL_POL_SYS_ID"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_END_NO_IDX(resultSet
    			.getInt("OCD_DTL_END_NO_IDX"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_CLM_SYS_ID(resultSet
    			.getLong("OCD_DTL_CLM_SYS_ID"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_SR_NO(resultSet
    			.getDouble("OCD_DTL_SR_NO"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN
    			.setOCD_DTL_TODO_LIST_ITEM(resultSet
    				.getString("OCD_DTL_TODO_LIST_ITEM"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_MANDATORY_YN(resultSet
    			.getString("OCD_DTL_MANDATORY_YN"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_APPR_STS(resultSet
    			.getString("OCD_DTL_APPR_STS"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_REMARKS(resultSet
    			.getString("OCD_DTL_REMARKS"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_CR_DT(resultSet
    			.getDate("OCD_DTL_CR_DT"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_CR_UID(resultSet
    			.getString("OCD_DTL_CR_UID"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_UPD_DT(resultSet
    			.getDate("OCD_DTL_UPD_DT"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_UPD_UID(resultSet
    			.getString("OCD_DTL_UPD_UID"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_GROUP_CODE(resultSet
    			.getString("OCD_DTL_GROUP_CODE"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_DOC_REC_DT(resultSet
    			.getDate("OCD_DTL_DOC_REC_DT"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_SMV_SYS_ID(resultSet
    			.getLong("OCD_DTL_SMV_SYS_ID"));
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_WD_SYS_ID(resultSet
    			.getLong("OCD_DTL_WD_SYS_ID"));
				PT_IL_OCD_DOC_TODO_LIST_BEAN.setOCD_DTL_TRANS_SYS_ID(resultSet
						.getLong("OCD_DTL_TRANS_SYS_ID"));
    	    	
    		
    	    	PT_IL_OCD_DOC_TODO_LIST_BEAN.setUI_M_GRP_CHKLST_DESC(compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_DESC());
    		if(PT_IL_OCD_DOC_TODO_LIST_BEAN.getOCD_DTL_APPR_STS().equalsIgnoreCase("Y"))
    		{
    			PT_IL_OCD_DOC_TODO_LIST_BEAN.setUI_M_CHKLST_STATUS("YES");
    		}
    		else
    		{
    			PT_IL_OCD_DOC_TODO_LIST_BEAN.setUI_M_CHKLST_STATUS("NO");
    		}
    		
    		
    		
    		
    		if(compositeAction.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN()
        			.getDataList_PT_IL_OCD_DOC_TODO_LIST() != null && 
        					compositeAction.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN()
        	    			.getDataList_PT_IL_OCD_DOC_TODO_LIST().size() == 0)
    		{
    			
    		if(PT_IL_OCD_DOC_TODO_LIST_BEAN.getRowSelected() != null && PT_IL_OCD_DOC_TODO_LIST_BEAN.getRowSelected().equals("dataTableNonSelectedRow"))
    		{
    			if((compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN().getPP_PAYOUT_STATUS() != null && 
    					compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN().getPP_PAYOUT_STATUS().equals("S")))
    			{
    				PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
    				PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
    			}
    			else
    			{
    				PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");
    				PT_IL_OCD_DOC_TODO_LIST_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
    			}
    		}
    		}
    		
    		

    		compositeAction.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN()
    			.getDataList_PT_IL_OCD_DOC_TODO_LIST().add(
    					PT_IL_OCD_DOC_TODO_LIST_BEAN);

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
