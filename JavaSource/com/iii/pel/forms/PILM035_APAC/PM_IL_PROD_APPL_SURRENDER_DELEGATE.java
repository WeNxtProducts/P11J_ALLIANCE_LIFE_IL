package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_SURRENDER_DELEGATE {

		public void executeSelectStatement(PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
				throws Exception {
			//PM_IL_PROD_APPL_SURRENDER PM_IL_PROD_APPL_SURRENDER_BEAN=PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN().getPM_IL_PROD_APPL_SURRENDER_BEAN();
			/*PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
					.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
					sysout
*/		
			
			System.out.println("PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE() "+PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());
			String selectStatement = "SELECT ROWID, PM_IL_PROD_SURR_DTL.* FROM PM_IL_PROD_SURR_DTL "
					+ "WHERE PSD_PROD_CODE = ?";
			Connection connection = null;
			ResultSet resultSet = null;
			PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN().getDataList_PM_IL_PROD_SURRENDER().clear();
			try {
				connection = CommonUtils.getConnection();
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection,
						new Object[] { PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE() });
				while (resultSet.next()) {
					PM_IL_PROD_APPL_SURRENDER PM_IL_PROD_APPL_SURRENDER_BEAN = new PM_IL_PROD_APPL_SURRENDER();
					PM_IL_PROD_APPL_SURRENDER_BEAN.setROWID(resultSet
							.getString("ROWID"));
					PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_PROD_CODE(resultSet
							.getString("PSD_PROD_CODE"));
					PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_TERM_FM(resultSet
							.getInt("PSD_TERM_FM"));
					PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_TERM_TO(resultSet
							.getInt("PSD_TERM_TO"));
					PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_SURR_YRS(resultSet
							.getInt("PSD_SURR_YRS"));

					PILM035_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN().getDataList_PM_IL_PROD_SURRENDER().add(PM_IL_PROD_APPL_SURRENDER_BEAN);
							/*.getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN()
							.getDataList_PM_IL_PROD_PREM_LIMIT().add(
									PM_IL_PROD_PREM_LIMIT_BEAN);
*/				}
			} catch (DBException e) {
				e.printStackTrace();
				throw e;
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}
	}

}
