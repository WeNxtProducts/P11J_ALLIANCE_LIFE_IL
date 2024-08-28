package com.iii.pel.forms.PILQ111_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_RI_PART_CUST_ALLOC_HELPER {

    public void executeQuery(PILQ111_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_IL_RI_PART_CUST_ALLOC_DELEGATE()
		.executeSelectStatement(compositeAction);

	List<PT_IL_RI_PART_CUST_ALLOC> dataList = compositeAction
		.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN()
		.getDataListPT_IL_RI_PART_CUST_ALLOC();
	if (dataList != null && dataList.size() > 0) {
	    compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN()
		    .setPT_IL_RI_PART_CUST_ALLOC_BEAN(dataList.get(0));
	    dataList.get(0).setRowSelected(true);
	}
	compositeAction.getPT_IL_RI_PART_CUST_ALLOC_ACTION_BEAN()
		.resetAllComponent();

    }

    public PT_IL_RI_PART_CUST_ALLOC postQuery(
	    PT_IL_RI_PART_CUST_ALLOC riPartCustAllocBean)
	    throws ValidatorException {
	String sql_C1 = "SELECT CUST_NAME  FROM   PM_CUSTOMER "
		+ "WHERE  CUST_CODE=?";
	ResultSet rst_C1 = null;
	String ripcaCustCode = riPartCustAllocBean.getRIPCA_CUST_CODE();
	CRUDHandler handler = new CRUDHandler();
	try {
	    Connection connection = CommonUtils.getConnection();
	    rst_C1 = handler.executeSelectStatement(sql_C1, connection,
		    new Object[] { ripcaCustCode });
	    while (rst_C1.next()) {
		riPartCustAllocBean.setUI_M_CUST_NAME(rst_C1.getString(1));
	    }
	} catch (Exception e) {
	    throw new ValidatorException(new FacesMessage(e.getMessage()));
	} finally {
	    try {
		CommonUtils.closeCursor(rst_C1);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return riPartCustAllocBean;
    }

    public List<PT_IL_RI_PART_CUST_ALLOC> getPartCustAllocList() {
	String sql_C1 = "";
	return null;
    }

}
