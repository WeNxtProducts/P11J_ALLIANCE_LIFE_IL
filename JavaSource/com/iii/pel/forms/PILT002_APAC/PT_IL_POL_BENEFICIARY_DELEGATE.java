package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_BENEFICIARY_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		/*Modifed by Raja on 13/04/2017
		 * 
		 * String selectStatement = "SELECT ROWID, PT_IL_POL_BENEFICIARY.* FROM PT_IL_POL_BENEFICIARY WHERE  PBEN_POL_SYS_ID  = ?";*/
		
		String selectStatement = "SELECT ROWID, PT_IL_POL_BENEFICIARY.* FROM PT_IL_POL_BENEFICIARY WHERE  PBEN_POL_SYS_ID  = ? ORDER BY PBEN_SR_NO";
		/*End*/
		
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
				.getDataList_PT_IL_POL_BENEFICIARY().clear();
		try {
			connection = CommonUtils.getConnection();
			connection.rollback();
			// Relation And Default Where is same
			// if(compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getDEFAULT_WHERE()
			// != null){
			// selectStatement = selectStatement +
			// compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getDEFAULT_WHERE();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_POL_BENEFICIARY PT_IL_POL_BENEFICIARY_BEAN = new PT_IL_POL_BENEFICIARY();
				PT_IL_POL_BENEFICIARY_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_SYS_ID(resultSet
						.getLong("PBEN_SYS_ID"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_POL_SYS_ID(resultSet
						.getLong("PBEN_POL_SYS_ID"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_SR_NO(resultSet
						.getInt("PBEN_SR_NO"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_TYPE(resultSet
						.getString("PBEN_BNF_TYPE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_NAME(resultSet
						.getString("PBEN_BNF_NAME"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_NAME_BL(resultSet
						.getString("PBEN_BNF_NAME_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_PERC(resultSet
						.getDouble("PBEN_PERC"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE(resultSet
						.getString("PBEN_RELATION_CODE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_1(resultSet
						.getString("PBEN_ADDRESS_1"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_2(resultSet
						.getString("PBEN_ADDRESS_2"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_3(resultSet
						.getString("PBEN_ADDRESS_3"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_4(resultSet
						.getString("PBEN_ADDRESS_4"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_5(resultSet
						.getString("PBEN_ADDRESS_5"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_1_BL(resultSet
						.getString("PBEN_ADDRESS_1_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_2_BL(resultSet
						.getString("PBEN_ADDRESS_2_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_3_BL(resultSet
						.getString("PBEN_ADDRESS_3_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_4_BL(resultSet
						.getString("PBEN_ADDRESS_4_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_5_BL(resultSet
						.getString("PBEN_ADDRESS_5_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REMARKS(resultSet
						.getString("PBEN_REMARKS"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REMARKS_BL(resultSet
						.getString("PBEN_REMARKS_BL"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_CR_UID(resultSet
						.getString("PBEN_CR_UID"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_CR_DT(resultSet
						.getDate("PBEN_CR_DT"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_UPD_UID(resultSet
						.getString("PBEN_UPD_UID"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_UPD_DT(resultSet
						.getDate("PBEN_UPD_DT"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_CATG_CODE(resultSet
						.getString("PBEN_CATG_CODE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_AGE(resultSet
						.getInt("PBEN_AGE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_GUARDIAN_NAME(resultSet
						.getString("PBEN_GUARDIAN_NAME"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_DEL_FLAG(resultSet
						.getString("PBEN_DEL_FLAG"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REF_ID1(resultSet
						.getString("PBEN_REF_ID1"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REF_ID2(resultSet
						.getString("PBEN_REF_ID2"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_MICR_CODE(resultSet
						.getLong("PBEN_MICR_CODE") == 0 ? null : resultSet
						.getLong("PBEN_MICR_CODE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ACNT_NO(resultSet
						.getLong("PBEN_ACNT_NO"));

				/*Added by Raja on 8/3/2016 for hide MICR field (Start)*/
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_CITY_CODE(resultSet
						.getString("PBEN_CITY_CODE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BANK_CODE(resultSet
						.getString("PBEN_BANK_CODE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_DIVISION(resultSet
						.getString("PBEN_DIVISION"));

				//Added by ameen on 17-03-2017 for email default for claim
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_EMAIL(resultSet
						.getString("PBEN_EMAIL"));
				
				/*End*/
				/*End*/
				/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_CODE(resultSet.getString("PBEN_BNF_CODE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_DOB(resultSet.getDate("PBEN_DOB"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_EFF_FM_DT(resultSet.getDate("PBEN_EFF_FM_DT"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_EFF_TO_DT(resultSet.getDate("PBEN_EFF_TO_DT"));
				/*Newly added by pidugu raj for Alliance IL dt: 22-09-2020*/
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_GUARDIAN_ID_TYPE(resultSet.getString("PBEN_GUARDIAN_ID_TYPE"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BENEF_ID_TYPE(resultSet.getString("PBEN_BENEF_ID_TYPE"));
				
				/*End Newly added by pidugu raj for Alliance IL dt: 22-09-2020*/
				/*Newly added by pidugu raj for Alliance IL dt: 28-09-2020*/
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_MOBILE_NO(resultSet
						.getInt("PBEN_MOBILE_NO"));
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_AREA_CODE(resultSet.getString("PBEN_AREA_CODE"));

				/*End Newly added by pidugu raj for Alliance IL dt: 28-09-2020*/
				
				/*Added by Ram on 11/12/2016 for FALCONLIFE-1358413*/
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_GUAR_REL_CODE(resultSet
						.getString("PBEN_GUAR_REL_CODE"));
				String CURSOR_C1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'ILBENFREL' AND PC_CODE = ? ";
				ResultSet resultSet_CURSOR_C1 = null;
				CRUDHandler handler = new CRUDHandler();
				resultSet_CURSOR_C1 = handler.executeSelectStatement(CURSOR_C1, connection,new Object[] {PT_IL_POL_BENEFICIARY_BEAN.getPBEN_GUAR_REL_CODE() });
				while (resultSet_CURSOR_C1.next()) {
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_GUAR_REL_DESC(resultSet_CURSOR_C1.getString("PC_DESC"));
				}
				/*End*/
				/*Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_GUARDIAN_NATN_ID(resultSet.getString("PBEN_GUARDIAN_NATN_ID"));
				/*End Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REL_OTHER(resultSet.getString("PBEN_REL_OTHER"));
				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
						.getDataList_PT_IL_POL_BENEFICIARY().add(
								PT_IL_POL_BENEFICIARY_BEAN);
				
			}
			// }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	/*Newly added by pidugu raj for Alliance IL dt: 22-09-2020*/
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
	/*Newly added by pidugu raj for Alliance IL dt: 22-09-2020*/

}
