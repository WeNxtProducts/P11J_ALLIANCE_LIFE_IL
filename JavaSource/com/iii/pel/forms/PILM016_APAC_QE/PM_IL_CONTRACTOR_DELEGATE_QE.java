package com.iii.pel.forms.PILM016_APAC_QE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM016_APAC.P_VAL_SYSTEM;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_CONTRACTOR_DELEGATE_QE {

	public void executeQuery(PM_IL_CONTRACTOR_ACTION_QE PM_IL_CONTRACTOR_ACTION_QE_BEAN) {
		ResultSet resultSet = null;
		PM_IL_CONTRACTOR_QE PM_IL_CONTRACTOR_BEAN = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			String selectQuery1 = "SELECT PM_IL_CONTRACTOR.* ,PM_IL_CONTRACTOR.ROWID FROM PM_IL_CONTRACTOR  WHERE CONT_CODE = ?  ";
			String contCode = CommonUtils
					.getGlobalVariable("GLOBAL.M_POL_CONT_CODE");
			if (contCode != null) {
				resultSet = handler.executeSelectStatement(selectQuery1,
						connection, new Object[] { contCode });
			}
			/*Added by Ameen on 14-06-2017 for ZBILQC-1724437*/
			String socialQry = "SELECT CUST_SOCIAL_MEDIA_MAIL_ID FROM PM_CUSTOMER WHERE CUST_CODE = ?";
			ResultSet socialRS = null;
			if (contCode != null) {
				socialRS = handler.executeSelectStatement(socialQry,
						connection, new Object[] { contCode });
			}
			/*End*/
			PM_IL_CONTRACTOR_BEAN = PM_IL_CONTRACTOR_ACTION_QE_BEAN.getPM_IL_CONTRACTOR_QE_BEAN();
			while (resultSet.next()) {
				PM_IL_CONTRACTOR_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CODE(resultSet
						.getString("CONT_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_NAME(resultSet
						.getString("CONT_NAME"));
				PM_IL_CONTRACTOR_BEAN.setCONT_ADDR1(resultSet
						.getString("CONT_ADDR1"));
				PM_IL_CONTRACTOR_BEAN.setCONT_ADDR2(resultSet
						.getString("CONT_ADDR2"));
				PM_IL_CONTRACTOR_BEAN.setCONT_ADDR3(resultSet
						.getString("CONT_ADDR3"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CONTACT(resultSet
						.getString("CONT_CONTACT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_PHONE(resultSet
						.getString("CONT_PHONE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_FAX(resultSet
						.getString("CONT_FAX"));
				PM_IL_CONTRACTOR_BEAN.setCONT_REMARKS(resultSet
						.getString("CONT_REMARKS"));
				PM_IL_CONTRACTOR_BEAN.setCONT_DFLT_YN(resultSet
						.getString("CONT_DFLT_YN"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CUST_CODE(resultSet
						.getString("CONT_CUST_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_FRZ_FLAG(resultSet
						.getString("CONT_FRZ_FLAG"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BL_NAME(resultSet
						.getString("CONT_BL_NAME"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BL_ADDR1(resultSet
						.getString("CONT_BL_ADDR1"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BL_ADDR2(resultSet
						.getString("CONT_BL_ADDR2"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BL_ADDR3(resultSet
						.getString("CONT_BL_ADDR3"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BL_CONTACT(resultSet
						.getString("CONT_BL_CONTACT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CR_DT(resultSet
						.getDate("CONT_CR_DT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CR_UID(resultSet
						.getString("CONT_CR_UID"));
				PM_IL_CONTRACTOR_BEAN.setCONT_UPD_DT(resultSet
						.getDate("CONT_UPD_DT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_UPD_UID(resultSet
						.getString("CONT_UPD_UID"));
				PM_IL_CONTRACTOR_BEAN.setCONT_EMPLOYER_YN(resultSet
						.getString("CONT_EMPLOYER_YN"));
				PM_IL_CONTRACTOR_BEAN.setCONT_LC_PROP_DEP_AMT(resultSet
						.getDouble("CONT_LC_PROP_DEP_AMT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_LC_PROP_UTIL_AMT(resultSet
						.getDouble("CONT_LC_PROP_UTIL_AMT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_LC_POL_DEP_AMT(resultSet
						.getDouble("CONT_LC_POL_DEP_AMT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_LC_POL_UTIL_AMT(resultSet
						.getDouble("CONT_LC_POL_UTIL_AMT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_EFF_FM_DT(resultSet
						.getDate("CONT_EFF_FM_DT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_EFF_TO_DT(resultSet
						.getDate("CONT_EFF_TO_DT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_REF_NO(resultSet
						.getString("CONT_REF_NO"));
				PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID1(resultSet
						.getString("CONT_REF_ID1"));
				PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID2(resultSet
						.getString("CONT_REF_ID2"));
				PM_IL_CONTRACTOR_BEAN.setCONT_TEL_AREA_CODE(resultSet
						.getString("CONT_TEL_AREA_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_MOBILE_NO(resultSet
						.getString("CONT_MOBILE_NO"));
				PM_IL_CONTRACTOR_BEAN.setCONT_FAX_AREA_CODE(resultSet
						.getString("CONT_FAX_AREA_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_PREFERRED_LANG(resultSet
						.getString("CONT_PREFERRED_LANG"));
				PM_IL_CONTRACTOR_BEAN.setCONT_EMAIL_ID(resultSet
						.getString("CONT_EMAIL_ID"));
				PM_IL_CONTRACTOR_BEAN.setCONT_POSTAL_CODE(resultSet
						.getString("CONT_POSTAL_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CITY(resultSet
						.getString("CONT_CITY"));
				PM_IL_CONTRACTOR_BEAN.setCONT_STATE(resultSet
						.getString("CONT_STATE"));
				PM_IL_CONTRACTOR_BEAN
						.setCONT_DOB(resultSet.getDate("CONT_DOB"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BIRTH_CERT_NO(resultSet
						.getString("CONT_BIRTH_CERT_NO"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CATG_CODE(resultSet
						.getString("CONT_CATG_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_MAR_STATUS(resultSet
						.getString("CONT_MAR_STATUS"));
				PM_IL_CONTRACTOR_BEAN.setCONT_NATIONALITY_CODE(resultSet
						.getString("CONT_NATIONALITY_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_RACE(resultSet
						.getString("CONT_RACE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_RELIGION(resultSet
						.getString("CONT_RELIGION"));
				PM_IL_CONTRACTOR_BEAN.setCONT_AREA(resultSet
						.getString("CONT_AREA"));
				PM_IL_CONTRACTOR_BEAN.setCONT_REGION(resultSet
						.getString("CONT_REGION"));
				PM_IL_CONTRACTOR_BEAN.setCONT_AD_BANK_CODE(resultSet
						.getString("CONT_AD_BANK_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_AD_ACC_NO(resultSet
						.getString("CONT_AD_ACC_NO"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CITY_CODE(resultSet
						.getString("CONT_CITY_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_STATE_CODE(resultSet
						.getString("CONT_STATE_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_COUNT_CODE(resultSet
						.getString("CONT_COUNT_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_COUNTRY(resultSet
						.getString("CONT_COUNTRY"));
				PM_IL_CONTRACTOR_BEAN.setCONT_PASS_NO(resultSet
						.getString("CONT_PASS_NO"));
				/*Added by Ameen on 14-06-2017 for ZBILQC-1724437*/
				if(socialRS.next()){
					PM_IL_CONTRACTOR_BEAN.setCONT_SOCIAL_MEDIA_MAIL_ID(socialRS.getString("CUST_SOCIAL_MEDIA_MAIL_ID"));
				}
				 /*End*/
				
				/*Added by Janani on 26.07.2017 for ZBILQC-1724437*/
				
				PM_IL_CONTRACTOR_BEAN.setCONT_MOB_AREA_CODE(resultSet
                        .getString("CONT_MOB_AREA_CODE"));
				
				/*End*/

				pilm016_apac_pm_il_contractor_post_query(PM_IL_CONTRACTOR_BEAN);

			}

			resultSet.getStatement().close();
			resultSet.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pilm016_apac_pm_il_contractor_post_query(PM_IL_CONTRACTOR_QE PM_IL_CONTRACTOR_BEAN)throws Exception{
		Connection connection = null;
		try{
			connection = CommonUtils.getConnection();
			if (PM_IL_CONTRACTOR_BEAN.getCONT_CATG_CODE() != null) {
				ArrayList categoryList = P_VAL_SYSTEM.P_VAL_SYSTEM(
						connection,
						PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PM_IL_CONTRACTOR_REF_ID1_TYPE,
						PM_IL_CONTRACTOR_BEAN.getCONT_CATG_CODE(),
						PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.N_FLAG);
				if (categoryList != null || !categoryList.isEmpty()) {
					PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_CATG_CODE_DESC(categoryList.get(0).toString());
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/*Added by Janani on 08.06.2017 for SSP id ZBILQC-1726439*/
	
	
	public static List<SelectItem> getDropDownListValue(String formName,
			String blockName, String blockFieldName, String filedName) {
		List<SelectItem> listValues = null;
		try {
			listValues = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), formName, blockName, blockFieldName,filedName);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return listValues;
	}
	
	/*eND*/
}
