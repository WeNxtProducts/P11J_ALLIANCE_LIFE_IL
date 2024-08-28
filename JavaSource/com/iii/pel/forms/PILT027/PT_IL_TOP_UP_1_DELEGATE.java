package com.iii.pel.forms.PILT027;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_TOP_UP_1_DELEGATE {

	public List<PT_IL_TOP_UP_1> getBlockDataForPT_IL_TOP_UP_1() {
		String queryString="SELECT ROWID,PT_IL_TOP_UP.* " +
		"FROM PT_IL_TOP_UP WHERE TU_POL_NO = ?";
	CommonUtils utility=new CommonUtils();
	CRUDHandler handler=new CRUDHandler();
	String mappedBeanName="PILT027_COMPOSITE_ACTION";
	List <PT_IL_TOP_UP_1> dataList=new ArrayList<PT_IL_TOP_UP_1>();
	ResultSet result=null;
	try {
		Connection connection = CommonUtils.getConnection();
		
		PILT027_COMPOSITE_ACTION compositeActionBean=
			(PILT027_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		String id=compositeActionBean.getPT_IL_TOP_UP_ACTION_BEAN().
				getPT_IL_TOP_UP_BEAN().getTU_POL_NO();
		Object []values={id};
		
		System.out.println("queryString....."+queryString);
		
		result=handler.executeSelectStatement(queryString, connection, values);
		if(result!=null){
			while(result.next()){
				PT_IL_TOP_UP_1 bean=new PT_IL_TOP_UP_1();
				bean.setTU_POL_NO(result.getString("TU_POL_NO"));
				bean.setTU_LC_TOPUP_DEP_AMT(result.getDouble("TU_LC_TOPUP_DEP_AMT"));
				bean.setTU_LC_TOPUP_CHRG_AMT(result.getDouble("TU_LC_TOPUP_CHRG_AMT"));
				bean.setTU_LC_TOPUP_NET_AMT(result.getDouble("TU_LC_TOPUP_NET_AMT"));
				bean.setTU_TXN_CODE(result.getString("TU_TXN_CODE"));
				bean.setTU_DOC_NO(result.getDouble("TU_DOC_NO"));
				bean.setTU_DOC_DT(result.getDate("TU_DOC_DT"));
				bean.setTU_REASON_CODE(result.getString("TU_REASON_CODE"));
				bean.setTU_REMARKS(result.getString("TU_REMARKS"));
				bean.setTU_FLEX_01(result.getString("TU_FLEX_01"));
				bean.setTU_FLEX_02(result.getString("TU_FLEX_02"));
				bean.setTU_FLEX_03(result.getString("TU_FLEX_03"));
				bean.setROWID(result.getString("ROWID"));
				dataList.add(bean);
			}
		}
		PT_IL_TOP_UP_1 PT_IL_TOP_UP_1 = null;
		Iterator<PT_IL_TOP_UP_1> it = dataList.iterator();
		while(it.hasNext()){
			PT_IL_TOP_UP_1 = it.next();
			PT_IL_TOP_UP_1.setRowSelected(false);
			}
		
		if (dataList.size()>0){					
			compositeActionBean.getPT_IL_TOP_UP_1_ACTION_BEAN().setPT_IL_TOP_UP_1_BEAN(dataList.get(0));
			compositeActionBean.getPT_IL_TOP_UP_1_ACTION_BEAN().getPT_IL_TOP_UP_1_BEAN().setRowSelected(true);
		}
	} catch (DBException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		try {
			CommonUtils.closeCursor(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	return dataList;
}

	

}
