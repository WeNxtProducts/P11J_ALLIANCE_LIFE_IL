package com.iii.pel.forms.PILQ103_APAC;

import java.sql.Connection;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.utils.CommonUtils;

public class PILQ103_APAC_ACTION_INSTANCE {
	
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
	
	public static PS_IL_DRCR_TREATY_ACTION getPS_IL_DRCR_TREATY_ACTION_INSTANCE() throws ValidatorException {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		return (PS_IL_DRCR_TREATY_ACTION) sessionMap.get("PILQ103_APAC_PS_IL_DRCR_TREATY_ACTION");
	}
	
}
