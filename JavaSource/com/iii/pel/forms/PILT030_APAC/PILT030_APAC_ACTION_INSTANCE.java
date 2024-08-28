package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILT030_APAC_ACTION_INSTANCE {
	
	public static Connection getConnection() throws ValidatorException {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (DBException e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return connection;
	}
	
	public static Map<String, Object> getSessionMap(){
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}
	
	public static PT_IL_PAYVOU_SEARCH_ACTION getSearchActionInstance(){
		return (PT_IL_PAYVOU_SEARCH_ACTION) getSessionMap().get("PILT030_APAC_PT_IL_PAYVOU_SEARCH_ACTION");
	}
	
	public static PILT030_APAC_COMPOSITE_ACTION getCompositeActionInstance(){
		return (PILT030_APAC_COMPOSITE_ACTION) getSessionMap().get("PILT030_APAC_COMPOSITE_ACTION");
	}
	
	public static DUMMY_ACTION getDummyActionInstance(){
		return getCompositeActionInstance().getPILT030_APAC_DUMMY_ACTION();
	}
	
	public static PT_IL_PAYVOU_HDR_ACTION getPayVouHdrActionInstance(){
		return getCompositeActionInstance().getPILT030_APAC_PT_IL_PAYVOU_HDR_ACTION();
	}
	
	public static PT_IL_PAYVOU_PAY_DTL_ACTION getPayVouPayDtlActionInstance(){
		return getCompositeActionInstance().getPILT030_APAC_PT_IL_PAYVOU_PAY_DTL_ACTION();
	}
	
	public static PT_IL_PAYVOU_DRCR_DTL_ACTION getPayVouDrctDtlActionInstance(){
		return getCompositeActionInstance().getPILT030_APAC_PT_IL_PAYVOU_DRCR_DTL_ACTION();
	}
	
	public static PT_IL_PAYVOU_AMT_DTL_ACTION getPayVouAmtDtlActionInstance(){
		return getCompositeActionInstance().getPILT030_APAC_PT_IL_PAYVOU_AMT_DTL_ACTION();
	}
	
	public static BP_ACTION getBpActionInstance(){
		return getCompositeActionInstance().getPILT030_APAC_BP_ACTION();
	}

}
