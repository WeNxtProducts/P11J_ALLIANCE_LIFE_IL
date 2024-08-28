package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PAYVOU_DRCR_DTL_HELPER {
	
	public void executeQuery(){
		String query  = "SELECT ROWID, PADD_SYS_ID,PADD_PAH_SYS_ID,PADD_TXN_CODE,PADD_DOC_NO,PADD_SEQ_NO," +
				"PADD_DOC_DT,PADD_POL_SYS_ID,PADD_POL_NO,PADD_CLAIM_NO,PADD_CLM_SYS_ID,PADD_CUST_CODE," +
				"PADD_CURR_CODE,PADD_MAIN_ACNT_CODE,PADD_SUB_ACNT_CODE,PADD_ANLY_CODE_1,PADD_ANLY_CODE_2," +
				"PADD_DRCR_FLAG,PADD_POST_YN,PADD_FC_AMT,PADD_LC_AMT,PADD_DOC_TYPE,PADD_ACNT_YEAR," +
				"PADD_SELECTED_YN,PADD_TYPE " +
				"FROM PT_IL_PAYVOU_DRCR_DTL " +
				"WHERE PADD_PAH_SYS_ID = ? " +
				"ORDER BY PADD_DRCR_FLAG,PADD_TXN_CODE, PADD_DOC_NO, PADD_SEQ_NO, PADD_DOC_DT";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		PT_IL_PAYVOU_DRCR_DTL_ACTION dtlAction = PILT030_APAC_ACTION_INSTANCE.getPayVouDrctDtlActionInstance();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		Double M_PAH_SYS_ID = dummyAction.getDUMMY_BEAN().getUI_M_PAH_SYS_ID();
		List<PT_IL_PAYVOU_DRCR_DTL> dtlList = new ArrayList<PT_IL_PAYVOU_DRCR_DTL>();
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{M_PAH_SYS_ID});
			while(rst.next()){
				PT_IL_PAYVOU_DRCR_DTL dtlBean = new PT_IL_PAYVOU_DRCR_DTL();
				dtlBean.setROWID(rst.getString("ROWID"));
				dtlBean.setPADD_SYS_ID(rst.getDouble("PADD_SYS_ID"));
				dtlBean.setPADD_PAH_SYS_ID(rst.getDouble("PADD_PAH_SYS_ID"));
				dtlBean.setPADD_TXN_CODE(rst.getString("PADD_TXN_CODE"));
				dtlBean.setPADD_DOC_NO(rst.getDouble("PADD_DOC_NO"));
				dtlBean.setPADD_SEQ_NO(rst.getDouble("PADD_SEQ_NO"));
				dtlBean.setPADD_DOC_DT(rst.getDate("PADD_DOC_DT"));
				dtlBean.setPADD_POL_SYS_ID(rst.getDouble("PADD_POL_SYS_ID"));
				dtlBean.setPADD_POL_NO(rst.getString("PADD_POL_NO"));
				dtlBean.setPADD_CLAIM_NO(rst.getString("PADD_CLAIM_NO"));
				dtlBean.setPADD_CLM_SYS_ID(rst.getDouble("PADD_CLM_SYS_ID"));
				dtlBean.setPADD_CUST_CODE(rst.getString("PADD_CUST_CODE"));
				dtlBean.setPADD_CURR_CODE(rst.getString("PADD_CURR_CODE"));
				dtlBean.setPADD_MAIN_ACNT_CODE(rst.getString("PADD_MAIN_ACNT_CODE"));
				dtlBean.setPADD_SUB_ACNT_CODE(rst.getString("PADD_SUB_ACNT_CODE"));
				dtlBean.setPADD_ANLY_CODE_1(rst.getString("PADD_ANLY_CODE_1"));
				dtlBean.setPADD_ANLY_CODE_2(rst.getString("PADD_ANLY_CODE_2"));
				dtlBean.setPADD_DRCR_FLAG(rst.getString("PADD_DRCR_FLAG"));
				dtlBean.setPADD_POST_YN(rst.getString("PADD_POST_YN"));
				dtlBean.setPADD_FC_AMT(rst.getDouble("PADD_FC_AMT"));
				dtlBean.setPADD_LC_AMT(rst.getDouble("PADD_LC_AMT"));
				dtlBean.setPADD_DOC_TYPE(rst.getString("PADD_DOC_TYPE"));
				dtlBean.setPADD_ACNT_YEAR(rst.getDouble("PADD_ACNT_YEAR"));
				dtlBean.setPADD_SELECTED_YN(rst.getString("PADD_SELECTED_YN"));
				dtlBean.setPADD_TYPE(rst.getString("PADD_TYPE"));
				postQuery(dtlBean);
				dtlAction.setPT_IL_PAYVOU_DRCR_DTL_BEAN(dtlBean);
				dtlBean.setRowSelected(true);
				dtlList.add(dtlBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	//	dtlAction.setPT_IL_PAYVOU_DRCR_DTL_LIST(dtlList);
		
		//Logic For Default Population
		PT_IL_PAYVOU_DRCR_DTL PT_IL_PAYVOU_DRCR_DTL_BEAN = null;
		Iterator<PT_IL_PAYVOU_DRCR_DTL> it = dtlList.iterator();
		
		while(it.hasNext()){
			PT_IL_PAYVOU_DRCR_DTL_BEAN = it.next();
			PT_IL_PAYVOU_DRCR_DTL_BEAN.setRowSelected(false);
		}
		dtlAction.setPT_IL_PAYVOU_DRCR_DTL_LIST(dtlList);
		if (dtlList.size()>0){					
			dtlAction.setPT_IL_PAYVOU_DRCR_DTL_BEAN(dtlList.get(0));
			dtlAction.getPT_IL_PAYVOU_DRCR_DTL_BEAN().setRowSelected(true);
		}
	}
	
	public void postQuery(PT_IL_PAYVOU_DRCR_DTL drcrDtlBean){
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		String PADD_CUST_CODE = drcrDtlBean.getPADD_CUST_CODE();
		String M_PADD_CUST_DESC = drcrDtlBean.getUI_M_PADD_CUST_DESC();
		ArrayList<OracleParameter> outputList = new PILT030_APAC_PROCEDURE().P_VAL_CUST(connection, PADD_CUST_CODE, M_PADD_CUST_DESC, "N", "N", null);
		M_PADD_CUST_DESC = outputList.get(0).getValue();
		drcrDtlBean.setUI_M_PADD_CUST_DESC(M_PADD_CUST_DESC);
	}
	
	public void whenNewBlockInstance(){
		executeQuery();
	}

}
