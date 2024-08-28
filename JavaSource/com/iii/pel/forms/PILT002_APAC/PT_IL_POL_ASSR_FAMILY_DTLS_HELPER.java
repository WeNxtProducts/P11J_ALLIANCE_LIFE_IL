package com.iii.pel.forms.PILT002_APAC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT021.PILT021_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT021.PT_IL_WITHDRAWAL_CHARGE;
import com.iii.pel.forms.PILT021.PT_IL_WITHDRAWAL_CHARGE_DELEGATE;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.pel.utils.PremiaLib;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_ASSR_FAMILY_DTLS_HELPER {

	CommonUtils commonUtils = new CommonUtils();
	
	public PT_IL_POL_ASSR_FAMILY_DTLS_ACTION actionBean;

	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		
		System.out.println("executeQuery for PT_IL_POL_ASSR_FAMILY_DTLS_HELPER class");
		new PT_IL_POL_ASSR_FAMILY_DTLS_DELEGATE()
		.executeSelectStatement(compositeAction);
		
      
		List<PT_IL_POL_ASSR_FAMILY_DTLS> dataList = compositeAction.
		getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_ASSR_FAMILY_DTLS();
		if(dataList!=null && dataList.size() > 0){
			PT_IL_POL_ASSR_FAMILY_DTLS PT_IL_POL_ASSR_FAMILY_DTLS_BEAN = dataList.get(0);
			PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN()
			.setPT_IL_POL_ASSR_FAMILY_DTLS_BEAN(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN);
		}
	
		
		
		
	}

	public void WHEN_CREATE_RECORD(PT_IL_POL_ASSR_FAMILY_DTLS PT_IL_POL_ASSR_FAMILY_DTLS_BEAN,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		//	pt_il_withdrawal_charge.setWDC_CUST_SHARE_PERC(100.00);
		
		if(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.getPAFD_STATUS() != null && 
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.getPAFD_STATUS().equalsIgnoreCase("L"))
		{
			compositeAction.getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN().getCOMP_PAFD_REASON().setDisabled(true);
		}
		else
		{
			compositeAction.getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN().getCOMP_PAFD_REASON().setDisabled(false);
		}
		
	}

	public void preInsert(PILT002_APAC_COMPOSITE_ACTION compositeAction,
			PT_IL_POL_ASSR_FAMILY_DTLS PT_IL_POL_ASSR_FAMILY_DTLS_BEAN) throws Exception{
		String C1 = "SELECT PIL_PAFD_SYS_ID.NEXTVAL FROM DUAL";
		Connection connection = null;
		ResultSet resultSetC1 = null;
		
		CRUDHandler handler = new CRUDHandler();
		
		try {
			
			connection = CommonUtils.getConnection();
			resultSetC1 = handler.executeSelectStatement(C1, connection);
			if (resultSetC1.next()) {
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_SYS_ID(resultSetC1.getLong(1));
			}

			PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_POL_SYS_ID(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_SYS_ID());
			PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_POAD_SYS_ID(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID());
			
			PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_CR_DT(commonUtils.getCurrentDate());
			PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_CR_UID(CommonUtils.getControlBean().getUSER_ID());
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			}
			catch (Exception e)
			{
				e.printStackTrace();}
			}
	}


	public void preUpdate(PT_IL_POL_ASSR_FAMILY_DTLS PT_IL_POL_ASSR_FAMILY_DTLS_BEAN) throws Exception{
		try {
			
			PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_UPD_DT(commonUtils.getCurrentDate());
			PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setPAFD_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
			
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
}


