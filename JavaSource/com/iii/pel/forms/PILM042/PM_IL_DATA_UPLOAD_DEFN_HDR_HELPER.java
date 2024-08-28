package com.iii.pel.forms.PILM042;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.ConvertFunctions;
import com.iii.premia.runtime.functions.StringFunctions;

public class PM_IL_DATA_UPLOAD_DEFN_HDR_HELPER {
	
    public void preInsert(PM_IL_DATA_UPLOAD_DEFN_HDR headerBean) throws Exception{
    	try {
    		headerBean.setDUDH_CR_DT(new CommonUtils().getCurrentDate());
    		headerBean.setDUDH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
		}
    	
    }
    public void preUpdate(PM_IL_DATA_UPLOAD_DEFN_HDR headerBean) throws Exception{
    	try {
    		headerBean.setDUDH_UPD_DT(new CommonUtils().getCurrentDate());
    		headerBean.setDUDH_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
		}
    }
    	
    
    
    public void defnCodeVaidator(String defCode) throws Exception {
    	Connection con = null;
    	ResultSet rst = null;
    	CRUDHandler handler = null;
    	String selectQuery = PILM042_QUERY_CONSTANTS.DUDH_DEF_CODE_WHEN_VALIDATE_ITEM;

    	try {
    		con = CommonUtils.getConnection();
    		handler = new CRUDHandler();
    		Object[] values = { defCode };
    		rst = handler.executeSelectStatement(selectQuery, con,values);
	
				if (rst.next()) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91249"));
				}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally{try {CommonUtils.closeCursor(rst);} catch (Exception e) {}}
			
    }
   
   
    
    /**
     * 
     * @param headerBean
     */
    public void shortDescValidator(PM_IL_DATA_UPLOAD_DEFN_HDR headerBean){
    	String DUDH_SHORT_DESC = headerBean.getDUDH_SHORT_DESC();
    	String DUDH_DESC = headerBean.getDUDH_DESC();
    	String assignValue = null;
    	assignValue = CommonUtils.SUBSTR(DUDH_DESC, 1, 30);
    	headerBean.setDUDH_SHORT_DESC(assignValue);
    	headerBean.setDUDH_BL_LONG_DESC(DUDH_DESC);
    }
    
    
    public void longDescValidator(PM_IL_DATA_UPLOAD_DEFN_HDR headerBean){
    	String DUDH_LONG_DESC = headerBean.getDUDH_LONG_DESC();
    	String DUDH_DESC = headerBean.getDUDH_DESC();
    	headerBean.setDUDH_LONG_DESC(DUDH_DESC);
    
    }
    
    
    public void effectivFromDateValidator(PM_IL_DATA_UPLOAD_DEFN_HDR headerBean) throws Exception{
    	Date DUDH_EFF_TO_DT = headerBean.getDUDH_EFF_TO_DT();
    	Date DUDH_EFF_FM_DT = headerBean.getDUDH_EFF_FM_DT();
    	try {
    		if(DUDH_EFF_TO_DT!=null && DUDH_EFF_TO_DT.before(DUDH_EFF_FM_DT)){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
    		}
    		if(DUDH_EFF_FM_DT!=null && DUDH_EFF_FM_DT.before(ConvertFunctions.to_date("01/01/1900", PELConstants.dbDateFormat))){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91255"));
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
		}
    }
    
    public void effectiveToDateValidator(PM_IL_DATA_UPLOAD_DEFN_HDR headerBean) throws Exception {
    	Date DUDH_EFF_TO_DT = headerBean.getDUDH_EFF_TO_DT();
    	Date DUDH_EFF_FM_DT = headerBean.getDUDH_EFF_FM_DT();
    	try {
    		if(DUDH_EFF_FM_DT !=null){
    			
    		if(DUDH_EFF_TO_DT.before(DUDH_EFF_FM_DT)){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
    		}
    		if(DUDH_EFF_TO_DT.after(ConvertFunctions.to_date("31/12/2999", PELConstants.dbDateFormat))){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91255"));
    		}
    		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
    }

    
    
    public void pilm042_pm_il_data_upload_defn_hdr_dudh_bl_short_desc_key_next_item(PM_IL_DATA_UPLOAD_DEFN_HDR headerBean) {
    	String DUDH_BL_SHORT_DESC = headerBean.getDUDH_BL_SHORT_DESC();
    	String DUDH_BL_DESC = headerBean.getDUDH_BL_DESC();
    	String assignValue = null;
    	if (DUDH_BL_SHORT_DESC == null) {
    		assignValue = StringFunctions.substr(DUDH_BL_DESC, 1,30);
    		headerBean.setDUDH_DESC(assignValue);
    	}
    }
    public void pilm042_pm_il_data_upload_defn_hdr_dudh_bl_long_desc_key_next_item(PM_IL_DATA_UPLOAD_DEFN_HDR headerBean){
    	String DUDH_BL_LONG_DESC = headerBean.getDUDH_BL_LONG_DESC();
    	String DUDH_BL_DESC = headerBean.getDUDH_BL_DESC();
    	if (DUDH_BL_LONG_DESC == null) {
    		headerBean.setDUDH_BL_LONG_DESC(DUDH_BL_DESC);
    	}
    }
    
    public void executeQuery(PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN){
    	new PM_IL_DATA_UPLOAD_DEFN_HDR_DELEGATE().executeQuery(PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN);
    }
}
