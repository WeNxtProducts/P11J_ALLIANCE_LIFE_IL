package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_LOAD_TARIFF_DELEGATE {
	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION PILM035_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = PILM035_APAC_COMPOSITE_ACTION_BEAN
		.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String selectStatement = "SELECT ROWID, PM_IL_PROD_APPL_LOAD_TARIFF.* FROM " +
				"PM_IL_PROD_APPL_LOAD_TARIFF WHERE PALT_PROD_CODE = ?";
		ResultSet  resultSet2=null;
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet  resultSet1=null;
		
		/*Added by Janani for Fidelity on 25.04.2018 as suggested by Ajay */
		ResultSet  resultSet3=null;
		/*End*/
		
		PILM035_APAC_COMPOSITE_ACTION_BEAN
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getDataList_PM_IL_PROD_APPL_LOAD_TARIFF().clear();
		try {
			connection = CommonUtils.getConnection();
			
			
			System.out.println("selectStatement    :  "+selectStatement);
            System.out.println("pm_il_product_bean.getPROD_CODE()   : "+pm_il_product_bean.getPROD_CODE()); 
            
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{pm_il_product_bean.getPROD_CODE()});
			
			while (resultSet.next()) {
				PM_IL_PROD_APPL_LOAD_TARIFF PM_IL_PROD_APPL_LOAD_TARIFF_BEAN = new PM_IL_PROD_APPL_LOAD_TARIFF();
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_PROD_CODE(resultSet.getString("PALT_PROD_CODE"));
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_TH_CODE(resultSet.getString("PALT_TH_CODE"));
				//added by Agalya for product Master- Discont/Loading suggestion field value set into the non-db field on 04/07/2016
                String th_query= "SELECT TH_DESC FROM PM_IL_TAR_HDR WHERE TH_CODE= ?";
				
              
                
                
				resultSet1 = new CRUDHandler().executeSelectStatement(th_query, connection, new Object[]
						{ PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_TH_CODE() });
				while(resultSet1.next())
				{
					PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setUI_M_PALT_TH_CODE_DESC(resultSet1.getString("TH_DESC"));
				}
				//end				
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_CR_DT(resultSet.getDate("PALT_CR_DT"));
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_CR_UID(resultSet.getString("PALT_CR_UID"));
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_UPD_DT(resultSet.getDate("PALT_UPD_DT"));
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_UPD_UID(resultSet.getString("PALT_UPD_UID"));
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_TH_PARAM_TYPE(resultSet.getString("PALT_TH_PARAM_TYPE"));
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_SRNO(resultSet.getInt("PALT_SRNO"));
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_APPLIED_ON(resultSet.getString("PALT_APPLIED_ON"));
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_APPL_UPTO(resultSet.getString("PALT_APPL_UPTO"));
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_DEFAULT_YN(resultSet.getString("PALT_DEFAULT_YN"));
				//added by agalya
				
				
				
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_COVER_CODE(resultSet.getString("PALT_COVER_CODE"));
				
				String query= "SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE=?";
				
				resultSet2 = new CRUDHandler().executeSelectStatement(query, connection, new Object[]
						{ PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_COVER_CODE() });
				while(resultSet2.next())
				{
					PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setUI_M_PALT_COVER_CODE_DESC(resultSet2.getString("COVER_DESC"));
				}
				//end
				
				/*Added by Janani for Fidelity on 25.04.2018 as suggested by Ajay */
				
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setPALT_FORMULA_CODE(resultSet.getString("PALT_FORMULA_CODE"));
				
				String frm_desc_query = "SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA  WHERE  FRM_CODE = ?";
				
				resultSet3 = new CRUDHandler().executeSelectStatement(frm_desc_query, connection, new Object[]
						{ PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getPALT_FORMULA_CODE()});
				while(resultSet3.next())
				{
					PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setUI_M_FORMULA_CODE_DESC(resultSet3.getString("FRM_DESC"));
				}
			
				System.out.println("getUI_M_FORMULA_CODE_DESC                   "+ PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.getUI_M_FORMULA_CODE_DESC());
				
				/*End*/
				
				PILM035_APAC_COMPOSITE_ACTION_BEAN
						.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.getDataList_PM_IL_PROD_APPL_LOAD_TARIFF().add(
								PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
