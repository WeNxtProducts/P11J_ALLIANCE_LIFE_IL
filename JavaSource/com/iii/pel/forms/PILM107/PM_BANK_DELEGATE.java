package com.iii.pel.forms.PILM107;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_BANK_DELEGATE {
	
	public void executeSelectStatement(
			PILM107_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = "SELECT ROWID, PM_BANK.* FROM PM_BANK";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPM_BANK_ACTION_BEAN().getDataTableList().clear();
		try {
			connection = CommonUtils.getConnection();
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PM_BANK PM_BANK_BEAN = new PM_BANK();
				PM_BANK_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_BANK_BEAN.setBANK_ADDR1(resultSet.getString("BANK_ADDR1"));
				PM_BANK_BEAN.setBANK_ADDR2(resultSet.getString("BANK_ADDR2"));
				PM_BANK_BEAN.setBANK_ADDR3(resultSet.getString("BANK_ADDR3"));
				PM_BANK_BEAN.setBANK_BR_CODE(resultSet.getString("BANK_BR_CODE"));
				PM_BANK_BEAN.setBANK_CLIENT_ID(resultSet.getString("BANK_CLIENT_ID"));
				PM_BANK_BEAN.setBANK_CODE(resultSet.getString("BANK_CODE"));
				PM_BANK_BEAN.setBANK_EMAIL(resultSet.getString("BANK_EMAIL"));
				PM_BANK_BEAN.setBANK_FAX(resultSet.getString("BANK_FAX"));
				PM_BANK_BEAN.setBANK_FRZ_FLAG_NUM(resultSet.getInt("BANK_FRZ_FLAG_NUM"));
				PM_BANK_BEAN.setBANK_NAME(resultSet.getString("BANK_NAME"));
				PM_BANK_BEAN.setBANK_PHONE(resultSet.getString("BANK_PHONE"));
				PM_BANK_BEAN.setBANK_SHORT_NAME(resultSet.getString("BANK_SHORT_NAME"));
				PM_BANK_BEAN.setBANK_SWIFT_CODE(resultSet.getString("BANK_SWIFT_CODE"));
				PM_BANK_BEAN.setBANK_UNIVERSAL_CODE(resultSet.getString("BANK_UNIVERSAL_CODE"));
				PM_BANK_BEAN.setBANK_WEB_SITE(resultSet.getString("BANK_WEB_SITE"));
				PM_BANK_BEAN.setBANK_ZIP(resultSet.getString("BANK_ZIP"));
				
				if(PM_BANK_BEAN.getBANK_FRZ_FLAG_NUM()!=0 && PM_BANK_BEAN.getBANK_FRZ_FLAG_NUM()==1)
				{
					PM_BANK_BEAN.setUI_M_FREEZE(true);
				}
				else
				{
					PM_BANK_BEAN.setUI_M_FREEZE(false);
				}
				
				
				/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
				PM_BANK_BEAN.setBANK_CONTACT_PERSON(resultSet.getString("BANK_FLEX_01"));
				PM_BANK_BEAN.setBANK_MOBILE(resultSet.getString("BANK_FLEX_02"));
				PM_BANK_BEAN.setBANK_SORT_CODE(resultSet.getString("BANK_FLEX_03"));
				PM_BANK_BEAN.setBANK_LEAD_TIME(resultSet.getString("BANK_FLEX_04"));
				/*END*/

				/*Added by ganesh on 26-10-2017 for bank default issue*/
				PM_BANK_BEAN.setBANK_ACCOUNT_NO(resultSet.getString("BANK_FLEX_05"));
				PM_BANK_BEAN.setBANK_COLLECTION_COMMSN(resultSet.getString("BANK_FLEX_06"));
				PM_BANK_BEAN.setBANK_MOBILE_AREA_CODE(resultSet.getString("BANK_FLEX_07"));
				PM_BANK_BEAN.setBANK_PHONE_AREA_CODE(resultSet.getString("BANK_FLEX_08"));
				PM_BANK_BEAN.setBANK_FAX_AREA_CODE(resultSet.getString("BANK_FLEX_09"));
				PM_BANK_BEAN.setBANK_CONTACT_TITLE(resultSet.getString("BANK_FLEX_10"));
				/*end*/
				compositeAction.getPM_BANK_ACTION_BEAN().getDataTableList().add(PM_BANK_BEAN);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
