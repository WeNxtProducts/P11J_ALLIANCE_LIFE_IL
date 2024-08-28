package com.iii.pel.forms.PM010_A;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM010_A_COMPANY_MASTER_DELEGATE {
	
	PM010_A_COMPANY_MASTER_ACTION PM010_A_COMPANY_MASTER_ACTION_BEAN;
	PM010_A_COMPOSITE_ACTION PM010_A_COMPOSITE_ACTION_BEAN;
	PM010_A_COMPANY PM_A_COMPANY_BEAN;
	String frezeeValue=null;
	
public PM010_A_COMPANY_MASTER_DELEGATE() {
	// TODO Auto-generated constructor stub
	System.out.println("inside delegate constructor");
	//PM_A_COMPANY_BEAN = new PM010_A_COMPANY();
}

public void executeSelectStatement(
		PM010_A_COMPOSITE_ACTION PM010_A_COMPOSITE_ACTION_BEAN)
		throws Exception {
	System.out.println("indise deeeeeelegate");
	String rowId = PM010_A_COMPOSITE_ACTION_BEAN.getPM010_A_COMPANY_MASTER_ACTION_BEAN().getPM010_A_COMPANY_BEAN().getROWID();
	System.out.println("ROW ID : "+rowId);
	//String selectStatement = "SELECT * FROM PM_COMPANY WHERE ROWID = ? ";
	String selectStatement = "SELECT COMP_CODE,COMP_NAME,COMP_SHORT_NAME,COMP_ADDR1,COMP_ADDR2,COMP_ADDR3,COMP_DFLT_DIVN,DIVN_NAME,COMP_BL_CEO_NAME,COMP_PHONE,COMP_FAX,COMP_DFLT_DEPT,DEPT_NAME,COMP_FRZ_FLAG,COMP_EMAIL,COMP_WEB_SITE,COMP_FRZ_FLAG,COMP_DEF_NATION FROM PM_COMPANY,PM_DIVISION,PM_DEPARTMENT "
			+ "WHERE COMP_DFLT_DIVN = DIVN_CODE AND COMP_DFLT_DEPT = DEPT_CODE and PM_COMPANY.ROWID = ? ";
	Connection connection = null;
	ResultSet resultSet = null;
	
	try {
		connection = CommonUtils.getConnection();
		resultSet = new CRUDHandler().executeSelectStatement(
				selectStatement, connection,new Object[]{rowId});
		 PM_A_COMPANY_BEAN = new PM010_A_COMPANY();
		while (resultSet.next()) {
			System.out.println("ENTER THE RESULTSET");
			
			PM_A_COMPANY_BEAN.setROWID(rowId);
			PM_A_COMPANY_BEAN.setCOMP_CODE(resultSet.getString("COMP_CODE"));
			System.out.println("resultSet.getString(COMP_CODE) =================>>>>>"+resultSet.getString("COMP_CODE"));
			PM_A_COMPANY_BEAN.setCOMP_NAME(resultSet.getString("COMP_NAME"));
			PM_A_COMPANY_BEAN.setCOMP_SHORT_NAME(resultSet.getString("COMP_SHORT_NAME"));
			PM_A_COMPANY_BEAN.setCOMP_ADDR1(resultSet
					.getString("COMP_ADDR1"));
			PM_A_COMPANY_BEAN.setCOMP_ADDR2(resultSet
					.getString("COMP_ADDR2"));
			PM_A_COMPANY_BEAN.setCOMP_ADDR3(resultSet
					.getString("COMP_ADDR3"));
			PM_A_COMPANY_BEAN.setCOMP_DFLT_DIVN(resultSet
					.getString("COMP_DFLT_DIVN"));
			PM_A_COMPANY_BEAN.setCOMP_DFLT_DIVN_NAME(resultSet
					.getString("DIVN_NAME"));
			PM_A_COMPANY_BEAN.setCOMP_BL_CEO_NAME(resultSet
					.getString("COMP_BL_CEO_NAME"));			
			PM_A_COMPANY_BEAN.setCOMP_PHONE(resultSet
					.getString("COMP_PHONE"));
			PM_A_COMPANY_BEAN.setCOMP_FAX(resultSet
					.getString("COMP_FAX"));
			PM_A_COMPANY_BEAN.setCOMP_DFLT_DEPT(resultSet.getString("COMP_DFLT_DEPT"));
			PM_A_COMPANY_BEAN.setCOMP_DFLT_DEPT_NAME(resultSet
					.getString("DEPT_NAME"));
			PM_A_COMPANY_BEAN.setCOMP_FRZ_FLAG(resultSet
					.getString("COMP_FRZ_FLAG"));
			PM_A_COMPANY_BEAN.setCOMP_EMAIL(resultSet
					.getString("COMP_EMAIL"));
			PM_A_COMPANY_BEAN.setCOMP_WEB_SITE(resultSet
					.getString("COMP_WEB_SITE"));
			
			
			/*Added by Janani for factory testing feedback changes on 12.04.2017*/
			
			PM_A_COMPANY_BEAN.setCOMP_DEF_NATION(resultSet
					.getString("COMP_DEF_NATION"));
			
			System.out.println("getCOMP_DEF_NATION                         :"+PM_A_COMPANY_BEAN.getCOMP_DEF_NATION());
			
			/*End*/
			

			System.out.println("teeeeeesting divn_name :"+resultSet.getString("divn_name"));
			System.out.println("teeeeeesting :"+resultSet.getString("divn_name"));
			System.out.println("EXIT RESULT SET ");
			frezeeValue=resultSet.getString("COMP_FRZ_FLAG");
			System.out.println("oooooooooooo"+frezeeValue);
			if(!frezeeValue.equals(null)){
				if(frezeeValue.equals("Y"))
					PM_A_COMPANY_BEAN.setFRZ_FLAG(true);
				else if(frezeeValue.equals("N"))
					PM_A_COMPANY_BEAN.setFRZ_FLAG(false);
			}
			/*PM_A_COMPANY_BEAN.setDIVN_BL_ADDR2(resultSet
					.getString("DIVN_BL_ADDR2"));
			PM_A_COMPANY_BEAN.setDIVN_BL_ADDR3(resultSet
					.getString("DIVN_BL_ADDR3"));
			PM_A_COMPANY_BEAN.setDIVN_BL_MGR_NAME(resultSet
					.getString("DIVN_BL_MGR_NAME"));
			PM_A_COMPANY_BEAN.setDIVN_FRZ_FLAG(resultSet
					.getString("DIVN_FRZ_FLAG"));
			PM_A_COMPANY_BEAN.setDIVN_CR_DT(resultSet.getDate("DIVN_CR_DT"));
			PM_A_COMPANY_BEAN.setDIVN_CR_UID(resultSet
					.getString("DIVN_CR_UID"));
			PM_A_COMPANY_BEAN.setDIVN_UPD_DT(resultSet
					.getDate("DIVN_UPD_DT"));
			PM_A_COMPANY_BEAN.setDIVN_UPD_UID(resultSet
					.getString("DIVN_UPD_UID"));
			PM_A_COMPANY_BEAN.setDIVN_CONTRA_ACNT_CODE(resultSet
					.getString("DIVN_CONTRA_ACNT_CODE"));*/

		}
		PM010_A_COMPOSITE_ACTION_BEAN.getPM010_A_COMPANY_MASTER_ACTION_BEAN().setPM010_A_COMPANY_BEAN(PM_A_COMPANY_BEAN);
		System.out.println("indise deeeeeelegate end");
	} finally {
		CommonUtils.closeCursor(resultSet);
	}
}
public void preDelete(PM010_A_COMPOSITE_ACTION compositeAction, 
		PM010_A_COMPANY pm_il_prop_treaty) throws Exception {
	Connection connection = null;
	CRUDHandler handler = null;
	try {
		String rowId = compositeAction.getPM010_A_COMPANY_MASTER_ACTION_BEAN().getPM010_A_COMPANY_BEAN().getROWID();
		System.out.println("delete rowID"+rowId);
		connection = CommonUtils.getConnection();
		handler = new CRUDHandler();
		String companyMasterDelete = "DELETE FROM PM_COMPANY WHERE ROWID  ='"
				+ rowId + "'";
		
		handler.executeDeleteStatement(companyMasterDelete, connection);
		
		connection.commit();
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
}

}
