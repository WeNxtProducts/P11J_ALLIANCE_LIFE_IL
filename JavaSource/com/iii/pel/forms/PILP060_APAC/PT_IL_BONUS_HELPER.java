package com.iii.pel.forms.PILP060_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_BONUS_HELPER {

	public List<PT_IL_BONUS> fetchBlockDataPT_IL_BONUS(DUMMY bean) {
		System.out.println("PT_IL_BONUS_HELPER.fetchBlockDataPT_IL_BONUS()");
		
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_BONUS_ACTION actionBean=compositeActionBean.getPT_IL_BONUS_ACTION_BEAN();
		
		StringBuffer selectQuery=new StringBuffer
			(PILP060_APAC_SQLQUERY_CONSTANTS.SELECT_PT_IL_BONUS);
		Object [] values=new Object[7];
		CRUDHandler handler=new CRUDHandler();
		ResultSet result=null;
		List<PT_IL_BONUS> recordList=new ArrayList<PT_IL_BONUS>();
		try {
			if(actionBean.getWHERE() != null){
				
				selectQuery.append(actionBean.getWHERE());
				System.out
						.println("PT_IL_BONUS_HELPER.fetchBlockDataPT_IL_BONUS---[query]"+selectQuery.toString());
				values[0]=bean.getUI_M_PROCESS_DATE();
				values[1]=bean.getUI_M_BON_CODE_FM();
				values[2]=bean.getUI_M_BON_CODE_TO();
				values[3]=bean.getUI_M_POL_NO_FM();
				values[4]=bean.getUI_M_POL_NO_TO();
				values[5]=bean.getUI_M_PROD_CODE_FM();
				values[6]=bean.getUI_M_PROD_CODE_TO();
				result=handler.executeSelectStatement(selectQuery.toString(), CommonUtils.getConnection(), values);
				int recordSerialNumber=1;
				if(result != null){
					while(result.next()){
						PT_IL_BONUS tempBean=new PT_IL_BONUS();
						tempBean.setBON_ACNT_YEAR(result.getDouble("BON_ACNT_YEAR"));
						tempBean.setBON_BONUS_CODE(result.getString("BON_BONUS_CODE"));
						tempBean.setBON_CN_YN(result.getString("BON_CN_YN"));
						tempBean.setBON_CR_DT(result.getDate("BON_CR_DT"));
						tempBean.setBON_CR_UID(result.getString("BON_CR_UID"));
						tempBean.setBON_DOC_NO(result.getDouble("BON_DOC_NO"));
						tempBean.setBON_FC_BONUS_AMT(result.getDouble("BON_FC_BONUS_AMT"));
						tempBean.setBON_LC_BONUS_AMT(result.getDouble("BON_LC_BONUS_AMT"));
						tempBean.setBON_PAID_YN(result.getString("BON_PAID_YN"));
						tempBean.setBON_PAY_TO(result.getString("BON_PAY_TO"));
						tempBean.setBON_POL_SYS_ID(result.getDouble("BON_POL_SYS_ID"));
						tempBean.setBON_POST_YN(result.getString("BON_POST_YN"));
						tempBean.setBON_PROD_CODE(result.getString("BON_PROD_CODE"));
						tempBean.setBON_PV_YN(result.getString("BON_PV_YN"));
						tempBean.setBON_REF_SYS_ID(result.getDouble("BON_REF_SYS_ID"));
						tempBean.setBON_REF_TYPE(result.getString("BON_REF_TYPE"));
						tempBean.setBON_YEAR(result.getInt("BON_YEAR"));
						tempBean.setBON_SR_NO(recordSerialNumber);
						tempBean.setBON_SYS_ID(result.getDouble("BON_SYS_ID"));
						tempBean.setBON_TXN_CODE(result.getString("BON_TXN_CODE"));
						tempBean.setBON_UPD_DT(result.getDate("BON_UPD_DT"));
						tempBean.setBON_UPD_UID(result.getString("BON_UPD_UID"));
						tempBean.setROWID(result.getString("ROWID"));
						
						recordList.add(tempBean);
						recordSerialNumber++;
					}
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (DBException e) {
			
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return recordList;
	}

	public void preQuery(){
		System.out.println("PT_IL_BONUS_HELPER.preQuery()");
		String mappedBeanName="PILP060_APAC_COMPOSITE_ACTION_BEAN";
		CommonUtils utility=new CommonUtils();
		PILP060_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILP060_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_BONUS_ACTION actionBean=compositeActionBean.getPT_IL_BONUS_ACTION_BEAN();
		String whereClause=" WHERE " +
			" BON_YEAR = TO_NUMBER(TO_CHAR( ? ,'YYYY')) " +
			"AND  BON_REF_TYPE = 'E' AND  NVL(BON_PAID_YN,'N') IN ('N','P') " +
			" AND  BON_BONUS_CODE   BETWEEN ? AND ? " +
			" AND BON_POL_SYS_ID IN (SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE " +
				" POL_NO BETWEEN ? AND ? AND " +
				" POL_PROD_CODE BETWEEN ? AND ?)";
		actionBean.setWHERE(whereClause);
	}
	
	public void postQuery(List<PT_IL_BONUS> dataTableList){
		System.out.println("PT_IL_BONUS_HELPER.postQuery()");
		
		StringBuffer selectQuery=new StringBuffer
			(PILP060_APAC_SQLQUERY_CONSTANTS.PT_IL_BONUS_POST_QUERY_CURSOR_C1);
		
		CRUDHandler handler=new CRUDHandler();
		ResultSet result=null;
		Connection con=null;
		Map<Double, String> polNoMap=new HashMap<Double, String>();
		try {
			con=CommonUtils.getConnection();
			result=handler.executeSelectStatement(selectQuery.toString(),con);
			if(result != null){
				while(result.next()){
					polNoMap.put(result.getDouble("POL_SYS_ID"), result.getString("POL_NO"));
				}
			}
			int iCount=0;
			while(iCount < dataTableList.size()){
				Double key=((PT_IL_BONUS)dataTableList.get(iCount)).getBON_POL_SYS_ID();
				String polNo=polNoMap.get(key);
				((PT_IL_BONUS)dataTableList.get(iCount)).setUI_M_BON_POL_NO(polNo);
				iCount++;
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (DBException e) {
			
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
