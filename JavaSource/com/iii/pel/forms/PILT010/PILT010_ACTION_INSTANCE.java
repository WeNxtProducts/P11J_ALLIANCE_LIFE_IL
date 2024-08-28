package com.iii.pel.forms.PILT010;

import java.sql.Connection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.utils.CommonUtils;

public class PILT010_ACTION_INSTANCE {
	
	public static Connection getConnection() throws ValidatorException {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return connection;
	}
	
	public static PILT010_COMPOSITE_ACTION getPILT010_COMPOSITE_ACTION_INSTANCE(){
		return (PILT010_COMPOSITE_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILT010_COMPOSITE_ACTION");
	}
	
	public static PV_IL_POL_RI_DETL_ACTION getPV_IL_POL_RI_DETL_ACTION_INSTANCE(){
		return getPILT010_COMPOSITE_ACTION_INSTANCE().getPILT010_PV_IL_POL_RI_DETL_ACTION();
	}
	
	public static PT_IL_RI_DETL_ACTION getPT_IL_RI_DETL_ACTION_INSTANCE(){
		return getPILT010_COMPOSITE_ACTION_INSTANCE().getPILT010_PT_IL_RI_DETL_ACTION();
	}
	
	public static PT_IL_RI_DETL_1_ACTION getPT_IL_RI_DETL_1_ACTION_INSTANCE(){
		return getPILT010_COMPOSITE_ACTION_INSTANCE().getPILT010_PT_IL_RI_DETL_1_ACTION();
	}
	
	public static PT_IL_RI_PREM_ALLOC_ACTION getPT_IL_RI_PREM_ALLOC_ACTION_INSTANCE() {
		return getPILT010_COMPOSITE_ACTION_INSTANCE().getPILT010_PT_IL_RI_PREM_ALLOC_ACTION();
	}
	
	public static PT_IL_RI_PREM_ALLOC_1_ACTION getPT_IL_RI_PREM_ALLOC_1_ACTION_INSTANCE() {
		return getPILT010_COMPOSITE_ACTION_INSTANCE().getPILT010_PT_IL_RI_PREM_ALLOC_1_ACTION();
	}
	
	public static PT_IL_RI_DISC_LOAD_ACTION	getPT_IL_RI_DISC_LOAD_ACTION_INSTANCE() {
		return getPILT010_COMPOSITE_ACTION_INSTANCE().getPILT010_PT_IL_RI_DISC_LOAD_ACTION();
	}

}
