/**
 * 
 */
package com.iii.pel.forms.PILM041;

import java.sql.Connection;
import java.sql.ResultSet;



import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55368
 * 
 */
public class PM_IL_DATA_UPLOAD_MAPPING_Helper {

	/**
	 * 
	 * @param PM_IL_DATA_UPLOAD_MAPPING_BEAN
	 * @throws Exception
	 */
	public void preInsert(
			PM_IL_DATA_UPLOAD_MAPPING PM_IL_DATA_UPLOAD_MAPPING_BEAN)
			throws Exception {
		try {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_CR_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			// L_PARA_CHECK();
		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * 
	 * @param PM_IL_DATA_UPLOAD_MAPPING_BEAN
	 * @throws Exception
	 */
	public void preUpdate(
			PM_IL_DATA_UPLOAD_MAPPING PM_IL_DATA_UPLOAD_MAPPING_BEAN)
			throws Exception {
		try {
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_UPD_DT(new CommonUtils().getCurrentDate());
			PM_IL_DATA_UPLOAD_MAPPING_BEAN.setDUM_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			//L_PARA_CHECK(PM_IL_DATA_UPLOAD_MAPPING_BEAN);
		} catch (Exception exception) {
			throw exception;
		}
	}

/*	public void L_PARA_CHECK(PM_IL_DATA_UPLOAD_MAPPING mappingBean) {
		
		String M_DUDD_RET_PARA = null;
		String M_DUDD_PARA_TYPE = null;
		ResultSet resultSet = null;
		String CURSOR_C1 = "SELECT DUDD_RET_PARA,DUDD_PARA_TYPE FROM PM_IL_DATA_UPLOAD_DEFN_DTL WHERE DUDD_SERIAL_NO = ?  AND DUDD_DUDH_DEF_CODE = ? ";
		resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection(), new Object[]{}); 
		
		   
		      

			 IF :GLOBAL.M_PARA_1 = 'CO' THEN 
			 M_RG_ID := FIND_GROUP('FIELD_NAMES');
			 M_FIELD_ID := FIND_COLUMN('FIELD_NAMES.NAME');
			 M_CNT_ROWS := GET_GROUP_ROW_COUNT(M_RG_ID);
			 FOR I IN 1..M_CNT_ROWS
			 LOOP
		      M_FIELD_VALUE := NAME_IN(GET_GROUP_CHAR_CELL(M_FIELD_ID,I));
		      IF M_FIELD_VALUE IS NOT NULL THEN
		      	 FOR REC IN C1(M_FIELD_VALUE)
		         LOOP
		      	   IF REC.DUDD_RET_PARA IN  ( '1','2','3','4')  THEN
		      		    M_CNT := M_CNT+1;
		      	   END IF;
		         END LOOP;
			    END IF;
			 END LOOP;
			 IF M_CNT <> 4 THEN
			 	  STD_MESSAGE_ROUTINE(91248,:CTRL.M_LANG_CODE);
			 	  RAISE FORM_TRIGGER_FAILURE;
			 END IF;
			 ELSIF :GLOBAL.M_PARA_1 = 'BO' THEN 
			 M_RG_ID := FIND_GROUP('FIELD_NAMES');
			 M_FIELD_ID := FIND_COLUMN('FIELD_NAMES.NAME');
			 M_CNT_ROWS := GET_GROUP_ROW_COUNT(M_RG_ID);
			 FOR I IN 1..M_CNT_ROWS
			 LOOP
		      M_FIELD_VALUE := NAME_IN(GET_GROUP_CHAR_CELL(M_FIELD_ID,I));
		      IF M_FIELD_VALUE IS NOT NULL THEN
		      	 FOR REC IN C1(M_FIELD_VALUE)
		         LOOP
		      	   IF REC.DUDD_RET_PARA IN  ( '1','2','4')  THEN
		      		    M_CNT := M_CNT+1;
		      	   END IF;
		         END LOOP;
			    END IF;
			 END LOOP;
			 IF M_CNT <> 3 THEN
			 	  STD_MESSAGE_ROUTINE(91248,:CTRL.M_LANG_CODE);
			 	  RAISE FORM_TRIGGER_FAILURE;
			 END IF;
			 	
		   END IF;	 	
		END;
	}*/

	/**
	 * 
	 * @param PM_IL_DATA_UPLOAD_MAPPING_ACTION
	 * @throws Exception
	 */
	public void executeQuery(
			PM_IL_DATA_UPLOAD_MAPPING_ACTION PM_IL_DATA_UPLOAD_MAPPING_ACTION)
			throws Exception {
		PM_IL_DATA_UPLOAD_SEARCH_PAGE_DELEGATE delegate = new PM_IL_DATA_UPLOAD_SEARCH_PAGE_DELEGATE();
		delegate.executeQuery(PM_IL_DATA_UPLOAD_MAPPING_ACTION);
	}

	/**
	 * 
	 * @param PM_IL_DATA_UPLOAD_MAPPING_BEAN
	 * @throws Exception
	 */
	public void whenValidateMapCode(
			PM_IL_DATA_UPLOAD_MAPPING PM_IL_DATA_UPLOAD_MAPPING_BEAN)
			throws Exception {
		String C1 = " SELECT DUM_MAP_CODE FROM   PM_IL_DATA_UPLOAD_MAPPING WHERE  DUM_MAP_CODE=?";

		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String M_FOUND = null;

		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if (PM_IL_DATA_UPLOAD_MAPPING_BEAN.getDUM_MAP_CODE() != null) {
				C1_REC = handler.executeSelectStatement(C1, conn,
						new Object[] { PM_IL_DATA_UPLOAD_MAPPING_BEAN
								.getDUM_MAP_CODE() });
				if (C1_REC.next()) {
					M_FOUND = C1_REC.getString(1);
				    if(M_FOUND.equalsIgnoreCase(PM_IL_DATA_UPLOAD_MAPPING_BEAN.getDUM_MAP_CODE())){
				    	if(PM_IL_DATA_UPLOAD_MAPPING_BEAN.getROWID() == null){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91244",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));
				    	}
					}
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}

		}
	}

	/**
	 * 
	 * @param PM_IL_DATA_UPLOAD_MAPPING_BEAN
	 * @throws Exception
	 */
	public void whenValidateDefCode(
			PM_IL_DATA_UPLOAD_MAPPING PM_IL_DATA_UPLOAD_MAPPING_BEAN)
			throws Exception {
		String C1 = "SELECT DUDH_DEF_CODE,DUDH_DESC FROM PM_IL_DATA_UPLOAD_DEFN_HDR "
				+ "WHERE DUDH_DEF_CODE = ? ";

		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet DEF_CUR = null;
		String M_FOUND = null;
		String P_ITEM_DESC = null;
		String M_VALUE = null;

		int M_SERIAL_NO = 0;
		String M_DUDD_PARA_TYPE = null;
		String M_DUDD_PARA_NAME = null;

		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			DEF_CUR = handler.executeSelectStatement(C1, conn,
					new Object[] { PM_IL_DATA_UPLOAD_MAPPING_BEAN
							.getDUM_DEF_CODE() });
			if (DEF_CUR.next()) {
				P_ITEM_DESC = DEF_CUR.getString(2);
				PM_IL_DATA_UPLOAD_MAPPING_BEAN.setUI_M_DEF_CODE_DESC(P_ITEM_DESC);
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91245",
						new Object[] { CommonUtils.getControlBean()
								.getM_USER_ID() }));
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(DEF_CUR);
			} catch (Exception exception2) {
			}

		}
	}

	/**
	 * 
	 * @param P_CURR_ITEM
	 *            It is the current selected value.
	 * @param PM_IL_DATA_UPLOAD_MAPPING_BEAN
	 * @return
	 * @throws Exception
	 */
	public String L_VALUE_CHECKING(String P_CURR_ITEM,
			PM_IL_DATA_UPLOAD_MAPPING PM_IL_DATA_UPLOAD_MAPPING_BEAN)
			throws Exception {
		String C1 = "SELECT DUDH_DEF_CODE,DUDH_DESC FROM PM_IL_DATA_UPLOAD_DEFN_HDR "
				+ "WHERE DUDH_DEF_CODE = ? ";
		String C2 = "SELECT DUDD_SERIAL_NO,DUDD_PARA_TYPE,DUDD_PARA_NAME "
				+ "FROM PM_IL_DATA_UPLOAD_DEFN_DTL  "
				+ "WHERE DUDD_DUDH_DEF_CODE = ? AND DUDD_SERIAL_NO = ?";

		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet DEF_CUR = null;
		String M_FOUND = null;
		String P_ITEM_DESC = null;
		String M_VALUE = null;

		int M_SERIAL_NO = 0;
		String M_DUDD_PARA_TYPE = null;
		String M_DUDD_PARA_NAME = null;

		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			if ("DUM_DEF_CODE".equalsIgnoreCase(P_CURR_ITEM)) {

				DEF_CUR = handler.executeSelectStatement(C1, conn,
						new Object[] { PM_IL_DATA_UPLOAD_MAPPING_BEAN
								.getDUM_DEF_CODE() });
				if (DEF_CUR.next()) {
					P_ITEM_DESC = DEF_CUR.getString(2);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91245",
							new Object[] { CommonUtils.getControlBean()
									.getM_USER_ID() }));
				}
			} else {
				// M_VALUE :=
				// NAME_IN('PM_IL_DATA_UPLOAD_MAPPING.'||P_CURR_ITEM);
				M_VALUE = P_CURR_ITEM;
				DEF_CUR = handler.executeSelectStatement(C2, conn,
						new Object[] {
								PM_IL_DATA_UPLOAD_MAPPING_BEAN
										.getDUM_DEF_CODE(), M_VALUE });
				if (DEF_CUR.next()) {
					M_SERIAL_NO = DEF_CUR.getInt(1);
					M_DUDD_PARA_TYPE = DEF_CUR.getString(2);
					M_DUDD_PARA_NAME = DEF_CUR.getString(3);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91246",
							new Object[] { CommonUtils.getControlBean()
									.getM_USER_ID() }));
				}

				if (!"P".equalsIgnoreCase(M_DUDD_PARA_TYPE)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91247",
							new Object[] { CommonUtils.getControlBean()
									.getM_USER_ID() }));
				}

				P_ITEM_DESC = M_DUDD_PARA_NAME;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(DEF_CUR);
			} catch (Exception exception2) {
			}

		}

		return P_ITEM_DESC;
	}

	public boolean validateAlphaNumeric(String str) {
		if (str.matches("[0-9]")) {
			return true;
		} else {
			return false;
		}
	}
}
