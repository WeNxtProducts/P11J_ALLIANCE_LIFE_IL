package com.iii.pel.forms.PILM201;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CVR_GROUP_HDR_HELPER {

    public void executeQuery(PILM201_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PM_IL_CVR_GROUP_HDR_DELEGATE()
		.executeSelectStatement(compositeAction);
	
	   if(compositeAction.getPM_IL_CVR_GROUP_HDR_ACTION_BEAN().getPM_IL_CVR_GROUP_HDR_BEAN().getROWID()!=null){
		new PM_IL_CVR_GROUP_DTL_DELEGATE().executeSelectStatement(compositeAction);
	    }
    }

    public void whenCreateRecord(PM_IL_CVR_GROUP_HDR pm_il_cvr_group_hdr_bean) throws Exception {
	try {
	    pm_il_cvr_group_hdr_bean.setCGH_FRZ_FLAG("N");

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }
    public void preUpdate(PM_IL_CVR_GROUP_HDR pm_il_cvr_group_hdr_bean) throws Exception {
	try {
	    pm_il_cvr_group_hdr_bean.setCGH_UPD_DT(new CommonUtils().getCurrentDate());
	    pm_il_cvr_group_hdr_bean.setCGH_UPD_UID(CommonUtils.getControlBean().getM_USER_ID()); 
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }
    public void preInsert(PM_IL_CVR_GROUP_HDR pm_il_cvr_group_hdr_bean) {
	try {
	    pm_il_cvr_group_hdr_bean.setCGH_FRZ_FLAG("N");
	    pm_il_cvr_group_hdr_bean.setCGH_CR_DT(new CommonUtils().getCurrentDate());
	    pm_il_cvr_group_hdr_bean.setCGH_CR_UID(CommonUtils.getControlBean().getM_USER_ID()); 
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    public void preDelete(PM_IL_CVR_GROUP_HDR pm_il_cvr_group_hdr_bean) {
	String delQuery = "  DELETE FROM PM_IL_CVR_GROUP_DTL P" +
			" WHERE P.CGD_GROUP_CODE = ? ";
	Connection connection = null;
	int resultSet = 0;
	try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeDeleteStatement( delQuery,connection,
		    new Object[]{pm_il_cvr_group_hdr_bean.getCGH_GROUP_CODE()});
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    public void onPopulateDetails() {
	try {
	    
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    public void CGH_GROUP_CODE_WHEN_VALIDATE_ITEM(PM_IL_CVR_GROUP_HDR pm_il_cvr_group_hdr_bean,String  currValue) throws Exception {
	try {
	    pm_il_cvr_group_hdr_bean.setCGH_GROUP_CODE(currValue);
	    L_VAL_GROUP_UNIQUE(pm_il_cvr_group_hdr_bean);	    
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }
    public void CGH_DESC_WHEN_VALIDATE_ITEM(PM_IL_CVR_GROUP_HDR pm_il_cvr_group_hdr_bean,String  currValue) throws Exception {
	try {
	    pm_il_cvr_group_hdr_bean.setCGH_SHORT_DESC(CommonUtils.SUBSTR( currValue,1,30));
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }
    
    public void CGH_BL_DESC_WHEN_VALIDATE_ITEM(PM_IL_CVR_GROUP_HDR pm_il_cvr_group_hdr_bean,String  currValue) throws Exception {
	try {
	    pm_il_cvr_group_hdr_bean.setCGH_BL_SHORT_DESC(CommonUtils.SUBSTR( currValue,1,30));
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }
    
    public void L_VAL_GROUP_UNIQUE(PM_IL_CVR_GROUP_HDR pm_il_cvr_group_hdr) throws Exception {
	String CURSOR_C1  = " SELECT ROWID FROM   PM_IL_CVR_GROUP_HDR " +
						"  WHERE  CGH_GROUP_CODE = ? ";
	
	String M_DUMMY=null;  
	String beanRowId = pm_il_cvr_group_hdr.getROWID();
	ResultSet rs1 = null, rs2=null;
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	try {
		
	    connection = CommonUtils.getConnection();
        rs1 = handler.executeSelectStatement(CURSOR_C1, connection, 
	       new Object[]{pm_il_cvr_group_hdr.getCGH_GROUP_CODE() });
        if(rs1.next()){
	    M_DUMMY = rs1.getString(1);
	    if(CommonUtils.isDuplicate(beanRowId, M_DUMMY)){
	    throw new Exception( Messages.getString( PELConstants.pelErrorMessagePath,
	   						"92002"));
	    }
        }
	}catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
	
    }
}
