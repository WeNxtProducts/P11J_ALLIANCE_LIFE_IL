package com.iii.pel.forms.PILP042_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class DUMMY_HELPER {
	
	public void pilp042_apac_dummy_m_wd_status_dt_when_validate() throws Exception{
		CommonUtils commonUtils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction =(PILP042_APAC_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummyBean = dummyAction.getDUMMY_BEAN();
		try{
			if(dummyBean.getM_WD_STATUS_DT().after(commonUtils.getCurrentDate())){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91014",new Object[]{"Less than or equal to"+commonUtils.getCurrentDate()}));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pilp042_apac_dummy_m_wd_status_code_when_validate_item() throws Exception{
		CommonUtils commonUtils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction =(PILP042_APAC_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION hdrAction = compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR hdrBean = hdrAction.getPT_IL_FUND_TRAN_HDR_BEAN();
		DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummyBean = dummyAction.getDUMMY_BEAN();
		DBProcedures dbProcedures = new DBProcedures();
		
		String M_PS_VALUE=null;
		String M_DUMMY=null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		handler = new CRUDHandler();
        try{
            String sql_C1="SELECT FTH_STATUS_CODE FROM  PT_IL_FUND_TRAN_HDR  WHERE  FTH_SYS_ID  = ?  AND FTH_POL_SYS_ID  = ? ";
            Object[] object = {hdrBean.getFTH_SYS_ID(),hdrBean.getFTH_POL_SYS_ID()};
            resultSet = handler.executeSelectStatement(sql_C1, connection, object);
            if(resultSet.next()){
                M_DUMMY=resultSet.getString(1);
            }
            
            if(dummyBean.getM_WD_STATUS_CODE() != null){
                if(M_DUMMY.equals(dummyBean.getM_WD_STATUS_CODE())){
                	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91156"));
                }
                ArrayList<String> list = dbProcedures.callP_VAL_SYSTEM("IL_TRAN_STAT", dummyBean.getM_WD_STATUS_CODE(), "E");
                if(list!= null && list.size()>0){
                	dummyBean.setM_WD_STATUS_CODE_DESC(list.get(0));
                	M_PS_VALUE = list.get(1);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
	
}
