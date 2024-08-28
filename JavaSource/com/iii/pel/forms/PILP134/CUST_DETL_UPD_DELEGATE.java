package com.iii.pel.forms.PILP134;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILQ003.PT_IL_POL_BENEFICIARY;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class CUST_DETL_UPD_DELEGATE {
	
	public void executeSelectStatement(
			PILP134_COMPOSITE_ACTION compositeAction) throws Exception {
		System.out.println("inside delegate");
		/*String selectStatement = "SELECT ROWID,PM_CUSTOMER.* FROM PM_CUSTOMER WHERE CUST_CODE = ?";*/
		/*changed by raja on 31-05-2017 for ZBILQC-1724387*/
		/*String selectStatement = "SELECT ROWID,PW_IL_CUST_DTL_UPD.* FROM PW_IL_CUST_DTL_UPD WHERE CDU_CUST_CODE = ?";*/
		//String selectStatement = "SELECT ROWID,PW_IL_CUST_DTL_UPD.* FROM PW_IL_CUST_DTL_UPD WHERE CDU_CUST_REF_ID1 = ?";
		/*end*/
		
		Connection connection = null;
		ResultSet resultSet = null;
		
		/*changed by raja on 20-03-2017 for ssp id -- ZBILQC-1722723*/
		ResultSet resultSet_customer = null;
		boolean flag=false;
		/*end*/
		
		
		
		
		try {
			connection = CommonUtils.getConnection();
			CUST_DTL_UPD_BEAN BEAN = new CUST_DTL_UPD_BEAN();
			/*change the parameter by raja on 31-05-2017 for ZBILQC-1724387*/
			System.out.println("inside delegate cust code  ===>"+compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN().getCDU_CUST_REF_ID1());
			/*resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN().getCDU_CUST_REF_ID1()});*/
			/*end*/
			
			
			/*commented by raja on 04-08-2017 for fetching wrong value ZBILQC-1733435*/
			/*while (resultSet.next()) {
				
				
				changed by raja on 20-03-2017 for ssp id -- ZBILQC-1722723
				flag=true;
				end

				
				BEAN.setCDU_CUST_CODE(resultSet.getString("CUST_CODE"));
				BEAN.setCDU_CORRES_ADDR1(resultSet.getString("CUST_ADDR1"));
				BEAN.setCDU_CORRES_ADDR2(resultSet.getString("CUST_ADDR2"));
				BEAN.setCDU_CORRES_ADDR3(resultSet.getString("CUST_ADDR3"));
				BEAN.setCDU_CORRES_CITY_CODE(resultSet.getString("CUST_CITY_CODE"));
				BEAN.setCDU_CORRES_CITY_DESC(resultSet.getString("CUST_CITY"));
				BEAN.setCDU_CORRES_COUNTRY(resultSet.getString("CUST_COUNT_CODE"));
				BEAN.setCDU_CORRES_PHONE(resultSet.getString("CUST_PHONE"));
				BEAN.setCDU_MOBILE_NO(resultSet.getString("CUST_PHONE2"));
				BEAN.setCDU_MAR_STATUS(resultSet.getString("CUST_MAR_STATUS"));
				BEAN.setCDU_BUS_ADDR1(resultSet.getString("CUST_PHY_ADDR1"));
				BEAN.setCDU_BUS_ADDR2(resultSet.getString("CUST_PHY_ADDR2"));
				BEAN.setCDU_BUS_ADDR3(resultSet.getString("CUST_PHY_ADDR3"));
				BEAN.setCDU_BUS_COUNTRY(resultSet.getString("CUST_PHY_COUNTRY"));
				BEAN.setCDU_BUS_FAX(resultSet.getString("CUST_PHY_FAX"));
				BEAN.setCDU_CORRES_FAX(resultSet.getString("CUST_FAX"));
				BEAN.setCDU_BUS_PHONE(resultSet.getString("CUST_OFFICE_PHONE"));
				BEAN.setCDU_EMAIL_ID_OFF(resultSet.getString("CUST_EMAIL_ID_OFF"));
				BEAN.setCDU_EMAIL_ID_PER(resultSet.getString("CUST_EMAIL_ID_PER"));
				BEAN.setCDU_MAR_STATUS(resultSet.getString("CUST_MAR_STATUS"));
			//	BEAN.setCDU_BUS_CITY_CODE(resultSet.getString("CUST_PHY_CITY_CODE"));
				BEAN.setCDU_PHY_POST_NO(resultSet.getString("CUST_POST_BOX_NO"));
				BEAN.setCDU_CORRES_POST_NO(resultSet.getString("CUST_PIN_NUMBER"));
			//	BEAN.setCDU_BUS_FAX_AREA_CODE(resultSet.getString("CUST_FAX_AREA_CODE2"));
			//	BEAN.setCDU_BUS_TEL_AREA_CODE(resultSet.getString("CUST_PHY_TEL_AREA_CODE"));
				BEAN.setCDU_BUS_MOBILE_NO(resultSet.getString("CUST_MOBILE_NO"));
			//	BEAN.setCDU_BUS_TEL_AREA_CODE2(resultSet.getString("CUST_PHY_MOB_AREA_CODE"));
				BEAN.setCDU_FAX_AREA_CODE(resultSet.getString("CUST_FAX_AREA_CODE"));
				BEAN.setCDU_TEL_AREA_CODE(resultSet.getString("CUST_TEL_AREA_CODE"));
				BEAN.setCDU_TEL_AREA_CODE2(resultSet.getString("CUST_TEL_AREA_CODE2"));
				
				Modifed by Ram on 16/02/2017
				BEAN.setROWID(resultSet.getString("ROWID"));
				
				BEAN.setCDU_SYS_ID(resultSet.getInt("CDU_SYS_ID"));
				BEAN.setCDU_CUST_CODE(resultSet.getString("CDU_CUST_CODE"));
				BEAN.setCDU_CORRES_ADDR1(resultSet.getString("CDU_CORRES_ADDR1"));
				BEAN.setCDU_CORRES_ADDR2(resultSet.getString("CDU_CORRES_ADDR2"));
				BEAN.setCDU_CORRES_ADDR3(resultSet.getString("CDU_CORRES_ADDR3"));
				BEAN.setCDU_CORRES_CITY_CODE(resultSet.getString("CDU_CORRES_CITY_CODE"));
				BEAN.setCDU_CORRES_CITY_DESC(resultSet.getString("CDU_CORRES_CITY_CODE"));
				BEAN.setCDU_CORRES_COUNTRY(resultSet.getString("CDU_CORRES_COUNTRY"));
				BEAN.setCDU_CORRES_PHONE(resultSet.getString("CDU_CORRES_PHONE"));
				BEAN.setCDU_MOBILE_NO(resultSet.getString("CDU_MOBILE_NO"));
				BEAN.setCDU_MAR_STATUS(resultSet.getString("CDU_MAR_STATUS"));
				BEAN.setCDU_BUS_ADDR1(resultSet.getString("CDU_BUS_ADDR1"));
				BEAN.setCDU_BUS_ADDR2(resultSet.getString("CDU_BUS_ADDR2"));
				BEAN.setCDU_BUS_ADDR3(resultSet.getString("CDU_BUS_ADDR3"));
				BEAN.setCDU_BUS_COUNTRY(resultSet.getString("CDU_BUS_COUNTRY"));
				BEAN.setCDU_BUS_FAX(resultSet.getString("CDU_BUS_FAX"));
				BEAN.setCDU_CORRES_FAX(resultSet.getString("CDU_CORRES_FAX"));
				BEAN.setCDU_BUS_PHONE(resultSet.getString("CDU_BUS_PHONE"));
				BEAN.setCDU_EMAIL_ID_OFF(resultSet.getString("CDU_EMAIL_ID_OFF"));
				BEAN.setCDU_EMAIL_ID_PER(resultSet.getString("CDU_EMAIL_ID_PER"));
				BEAN.setCDU_MAR_STATUS(resultSet.getString("CDU_MAR_STATUS"));
				BEAN.setCDU_PHY_POST_NO(resultSet.getString("CDU_PHY_POST_NO"));
				BEAN.setCDU_CORRES_POST_NO(resultSet.getString("CDU_CORRES_POST_NO"));
			    BEAN.setCDU_BUS_MOBILE_NO(resultSet.getString("CDU_BUS_MOBILE_NO"));
			    BEAN.setCDU_FAX_AREA_CODE(resultSet.getString("CDU_FAX_AREA_CODE"));
				BEAN.setCDU_TEL_AREA_CODE(resultSet.getString("CDU_TEL_AREA_CODE"));
				BEAN.setCDU_TEL_AREA_CODE2(resultSet.getString("CDU_TEL_AREA_CODE2"));
				End
				BEAN.setCDU_BUS_CITY_CODE(resultSet.getString("CDU_BUS_CITY_CODE"));
				BEAN.setCDU_BUS_FAX_AREA_CODE(resultSet.getString("CDU_BUS_FAX_AREA_CODE"));
				BEAN.setCDU_BUS_TEL_AREA_CODE(resultSet.getString("CDU_BUS_TEL_AREA_CODE"));
				BEAN.setCDU_BUS_TEL_AREA_CODE2(resultSet.getString("CDU_BUS_TEL_AREA_CODE2"));
				End
				
				added by raja on 31-05-2017 for ZBILQC-1724387
				BEAN.setCDU_CUST_NAME(resultSet.getString("CDU_CUST_NAME"));
				BEAN.setCDU_CUST_REF_ID1(resultSet.getString("CDU_CUST_REF_ID1"));
				end
				
				Added by saritha on 27-06-2017 for ssp call id ZBILQC-1730055
				BEAN.setCDU_FIRST_NAME(resultSet.getString("CDU_FIRST_NAME"));
				BEAN.setCDU_MIDDLE_NAME(resultSet.getString("CDU_MIDDLE_NAME"));
				BEAN.setCDU_SURNAME(resultSet.getString("CDU_SURNAME"));
				End
				
				ADDED BY GOPI 
				BEAN.setCDU_AGE_ADMITTED(resultSet.getString("CDU_AGE_ADMITTED"));
				BEAN.setCDU_AGE_PROOF_FLAG(resultSet.getString("CDU_AGE_PROOF_FLAG"));
				BEAN.setCDU_AGE_PROOF_OTHERS(resultSet.getString("CDU_AGE_PROOF_OTHERS"));
				BEAN.setCDU_BUS_AGE_ADMITTED(resultSet.getString("CDU_BUS_AGE_ADMITTED"));
				BEAN.setCDU_BUS_AGE_PROOF_FLAG(resultSet.getString("CDU_BUS_AGE_PROOF_FLAG"));
				BEAN.setCDU_BUS_AGE_PROOF_OTHERS(resultSet.getString("CDU_BUS_AGE_PROOF_OTHERS"));
				//END
				
				
				
				
				 * 
				 * Commented by Raja  on 20-03-2017 for ssp id -- ZBILQC-1722723
				 * 
				 * 
				 * 
				 * if(BEAN.getCDU_BUS_CITY_CODE()!=null)
				{
					String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' and pc_code=?";
					ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_BUS_CITY_CODE()});
					while(rs.next())
					{
						BEAN.setCDU_BUS_CITY_CODE_DESC(rs.getString("PC_DESC"));
					}
				}
				else
				{
					BEAN.setCDU_BUS_CITY_CODE_DESC(null);
				}
				
				
				if(BEAN.getCDU_MAR_STATUS()!=null)
				{
					String query="SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'MARI_STAT'  AND PS_CODE=?";
					ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_MAR_STATUS()});
					while(rs.next())
					{
						BEAN.setCDU_MAR_STATUS_DESC(rs.getString("PS_CODE_DESC"));
					}
				}
				else
				{
					BEAN.setCDU_MAR_STATUS_DESC(null);
				}
				
				if(BEAN.getCDU_BUS_COUNTRY()!=null)
				{
					String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' and pc_code=?";
					ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_BUS_COUNTRY()});
					while(rs.next())
					{
						BEAN.setCDU_BUS_COUNTRY_DESC(rs.getString("PC_DESC"));
					}
				}
				else
				{
					BEAN.setCDU_BUS_COUNTRY_DESC(null);
				}
				
				
				if(BEAN.getCDU_CORRES_CITY_CODE()!=null)
				{
					String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' and pc_code=?";
					ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_CORRES_CITY_CODE()});
					while(rs.next())
					{
						BEAN.setCDU_CORRES_CITY_DESC(rs.getString("PC_DESC"));
					}
				}
				else
				{
					BEAN.setCDU_CORRES_CITY_DESC(null);
				}
				
				
				if(BEAN.getCDU_CORRES_COUNTRY()!=null)
				{
					String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' and pc_code=?";
					ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_CORRES_COUNTRY()});
					while(rs.next())
					{
						BEAN.setCDU_CORRES_COUNTRY_DESC(rs.getString("PC_DESC"));
					}
				}
				else
				{
					BEAN.setCDU_BUS_COUNTRY_DESC(null);
				}
				
				
				
				Added by Raja  on 20-03-2017 for ssp id -- ZBILQC-1722723
				
				description(BEAN);
			}
			
			
			
			if(flag==false)
			{*/
			
			/*end for ZBILQC-1733435*/
				/*changed by raja on 31-05-2017 for ZBILQC-1724387*/
				/*String selectStatement_customer = "SELECT * FROM PM_CUSTOMER WHERE CUST_CODE = ?";*/
				String selectStatement_customer = "SELECT * FROM PM_CUSTOMER WHERE CUST_REF_ID1 = ?";
				/*end*/
				
				/*change the parameter by raja on 31-05-2017 for ZBILQC-1724387*/
				resultSet_customer=new CRUDHandler().executeSelectStatement(
						selectStatement_customer, connection, new Object[] {compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN().getCDU_CUST_REF_ID1()});
				/*end*/
				while(resultSet_customer.next())
				{
					BEAN.setCDU_CUST_CODE(resultSet_customer.getString("CUST_CODE"));
					BEAN.setCDU_CORRES_ADDR1(resultSet_customer.getString("CUST_ADDR1"));
					BEAN.setCDU_CORRES_ADDR2(resultSet_customer.getString("CUST_ADDR2"));
					BEAN.setCDU_CORRES_ADDR3(resultSet_customer.getString("CUST_ADDR3"));
					BEAN.setCDU_CORRES_CITY_CODE(resultSet_customer.getString("CUST_CITY_CODE"));
					BEAN.setCDU_CORRES_CITY_DESC(resultSet_customer.getString("CUST_CITY"));
					BEAN.setCDU_CORRES_COUNTRY(resultSet_customer.getString("CUST_COUNT_CODE"));
					BEAN.setCDU_CORRES_PHONE(resultSet_customer.getString("CUST_PHONE"));
					BEAN.setCDU_MOBILE_NO(resultSet_customer.getString("CUST_PHONE2"));
					BEAN.setCDU_MAR_STATUS(resultSet_customer.getString("CUST_MAR_STATUS"));
					BEAN.setCDU_BUS_ADDR1(resultSet_customer.getString("CUST_PHY_ADDR1"));
					BEAN.setCDU_BUS_ADDR2(resultSet_customer.getString("CUST_PHY_ADDR2"));
					BEAN.setCDU_BUS_ADDR3(resultSet_customer.getString("CUST_PHY_ADDR3"));
					BEAN.setCDU_BUS_COUNTRY(resultSet_customer.getString("CUST_PHY_COUNTRY"));
					BEAN.setCDU_BUS_FAX(resultSet_customer.getString("CUST_PHY_FAX"));
					BEAN.setCDU_CORRES_FAX(resultSet_customer.getString("CUST_FAX"));
					BEAN.setCDU_BUS_PHONE(resultSet_customer.getString("CUST_OFFICE_PHONE"));
					BEAN.setCDU_EMAIL_ID_OFF(resultSet_customer.getString("CUST_EMAIL_ID_OFF"));
					BEAN.setCDU_EMAIL_ID_PER(resultSet_customer.getString("CUST_EMAIL_ID_PER"));
					BEAN.setCDU_MAR_STATUS(resultSet_customer.getString("CUST_MAR_STATUS"));
					BEAN.setCDU_BUS_CITY_CODE(resultSet_customer.getString("CUST_PHY_CITY_CODE"));
					BEAN.setCDU_PHY_POST_NO(resultSet_customer.getString("CUST_POST_BOX_NO"));
					BEAN.setCDU_CORRES_POST_NO(resultSet_customer.getString("CUST_PIN_NUMBER"));
					BEAN.setCDU_BUS_FAX_AREA_CODE(resultSet_customer.getString("CUST_FAX_AREA_CODE2"));
					BEAN.setCDU_BUS_TEL_AREA_CODE(resultSet_customer.getString("CUST_PHY_TEL_AREA_CODE"));
					BEAN.setCDU_BUS_MOBILE_NO(resultSet_customer.getString("CUST_MOBILE_NO"));
					BEAN.setCDU_BUS_TEL_AREA_CODE2(resultSet_customer.getString("CUST_PHY_MOB_AREA_CODE"));
					BEAN.setCDU_FAX_AREA_CODE(resultSet_customer.getString("CUST_FAX_AREA_CODE"));
					BEAN.setCDU_TEL_AREA_CODE(resultSet_customer.getString("CUST_TEL_AREA_CODE"));
					BEAN.setCDU_TEL_AREA_CODE2(resultSet_customer.getString("CUST_TEL_AREA_CODE2"));
					
					/*added by raja on 31-05-2017 for ZBILQC-1724387*/
					BEAN.setCDU_CUST_NAME(resultSet_customer.getString("CUST_NAME"));
					BEAN.setCDU_CUST_REF_ID1(resultSet_customer.getString("CUST_REF_ID1"));
					/*end*/
					
					/*Added by saritha on 27-06-2017 for ssp call id ZBILQC-1730055*/
					BEAN.setCDU_FIRST_NAME(resultSet_customer.getString("CUST_FIRST_NAME"));
					BEAN.setCDU_MIDDLE_NAME(resultSet_customer.getString("CUST_MIDDLE_NAME"));
					BEAN.setCDU_SURNAME(resultSet_customer.getString("CUST_SURNAME"));
					/*End*/
					
					/*ADDED BY GOPI */
					BEAN.setCDU_AGE_ADMITTED(resultSet_customer.getString("CUST_AGE_ADMITTED"));
					BEAN.setCDU_AGE_PROOF_FLAG(resultSet_customer.getString("CUST_AGE_PROOF_FLAG"));
					BEAN.setCDU_AGE_PROOF_OTHERS(resultSet_customer.getString("CUST_AGE_PROOF_OTHERS"));
					//END
					
					/*Added by Ameen 02-05-2018 fro KIC enabling 3rd address fields*/
					BEAN.setCDU_OTH_ADDR1(resultSet_customer.getString("CUST_CORR_ADDR1"));
					BEAN.setCDU_OTH_ADDR2(resultSet_customer.getString("CUST_CORR_ADDR2"));
					BEAN.setCDU_OTH_ADDR3(resultSet_customer.getString("CUST_CORR_ADDR3"));
					BEAN.setCDU_OTH_CITY_CODE(resultSet_customer.getString("CUST_CORR_CITY_CODE"));
					BEAN.setCDU_OTH_COUNTRY(resultSet_customer.getString("CUST_CORR_COUNTRY"));
					BEAN.setCDU_OTH_POST_NO(resultSet_customer.getString("CUST_CORR_POST_BOX_NO"));
					BEAN.setCDU_OTH_TEL_AREA_CODE(resultSet_customer.getString("CUST_CORR_MOB_AREA_CODE"));
					BEAN.setCDU_OTH_MOBILE_NO(resultSet_customer.getString("CUST_CORR_MOBILE_NO"));
					BEAN.setCDU_OTH_TEL_AREA_CODE2(resultSet_customer.getString("CUST_PHY_ADDR1"));
					BEAN.setCDU_OTH_TEL_AREA_CODE2(resultSet_customer.getString("CUST_CORR_OFFICE_PHONE"));
					BEAN.setCDU_OTH_FAX_AREA_CODE(resultSet_customer.getString("CUST_CORR_FAX_AREA_CODE"));
					BEAN.setCDU_OTH_FAX(resultSet_customer.getString("CUST_CORR_FAX"));
					BEAN.setCDU_EMAIL_ID_OTH(resultSet_customer.getString("CUST_CORR_EMAIL_ID_OFF"));
					
					BEAN.setCDU_CUST_OCC_CODE(resultSet_customer.getString("CUST_OCC_CODE"));
					BEAN.setCDU_CUST_NATIONALITY_CODE(resultSet_customer.getString("CUST_NATIONALITY_CODE"));
					BEAN.setCDU_CUST_REMARKS(resultSet_customer.getString("CUST_REMARKS"));
					BEAN.setCDU_CUST_COMM_ADDR_FLG(resultSet_customer.getString("CUST_COMM_ADDR_FLG"));
				
					/*Added by kavitha on 30.07.2018 for KICLIFEQC-1759654*/
					BEAN.setCDU_TITLE(resultSet_customer.getString("CUST_TITLE"));
					BEAN.setCDU_CATG_CODE(resultSet_customer.getString("CUST_CATG_CODE"));
					/*End*/
					if("H".equalsIgnoreCase(BEAN.getCDU_CUST_COMM_ADDR_FLG())){
						BEAN.setUI_M_CDU_COMM_RES_ADDR_FLG(true);
					}else{
						BEAN.setUI_M_CDU_COMM_RES_ADDR_FLG(false);
					}
					if("O".equalsIgnoreCase(BEAN.getCDU_CUST_COMM_ADDR_FLG())){
						BEAN.setUI_M_CDU_COMM_OFF_ADDR_FLG(true);
					}else{
						BEAN.setUI_M_CDU_COMM_OFF_ADDR_FLG(false);
					}
					if("C".equalsIgnoreCase(BEAN.getCDU_CUST_COMM_ADDR_FLG())){
						BEAN.setUI_M_CDU_COMM_COR_ADDR_FLG(true);
					}else{
						BEAN.setUI_M_CDU_COMM_COR_ADDR_FLG(false);
					}
						
					/*End*/
					
					
					
					description(BEAN);
				
				/*End*/
				
					
				
			}
			
			
		/*} 
			*/
			
			compositeAction.getCUST_DETL_UPD_ACTION_BEAN().setCUST_DTL_UPD_BEAN(BEAN);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public void executeQuery(PILP134_COMPOSITE_ACTION compositeAction)
	{
		System.out.println("inside execute Query ");
		
		/*Query changed by raja on 10-02-2017 for ssp call id - ZBILQC-1719815 */
		/*Query changed by raja on 31-05-2017 for ssp call id - ZBILQC-1724387 */
		
		/*changed by raja on 27-07-2017 for add dependent and beneficiary io n the policy databale*/
		/*String selectStatement = "SELECT POL_NO,(SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE ='IL_REC_STA' AND PS_CODE = POL_STATUS) POL_STATUS,POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_ASSRD_REF_ID1=?";*/
		String selectStatement = "SELECT POL_NO,(SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'IL_REC_STA' "
				+ "AND PS_CODE = POL_STATUS) POL_STATUS, POL_PROD_CODE, 'Policy Holder' CUST_TYPE FROM PT_IL_POLICY "
				+ "WHERE POL_ASSRD_REF_ID1 = ? UNION SELECT POL_NO, (SELECT PS_CODE_DESC FROM "
				+ "PP_SYSTEM WHERE PS_TYPE = 'IL_REC_STA' AND PS_CODE = POL_STATUS) POL_STATUS, POL_PROD_CODE, 'Dependent' "
				+ " CUST_TYPE FROM PT_IL_POLICY, PT_IL_POL_FUNERAL_MEMB_DTLS, PM_CUSTOMER WHERE CUST_REF_ID1 = ? AND"
				+ " CUST_CODE = PFMD_CUST_CODE AND PFMD_RELATION_TYPE <> '01' AND PFMD_POL_SYS_ID = POL_SYS_ID UNION SELECT"
				+ " POL_NO, (SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'IL_REC_STA' AND PS_CODE = POL_STATUS) "
				+ "POL_STATUS, POL_PROD_CODE, (SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_CODE = PBEN_BNF_TYPE AND "
				+ "PS_TYPE = 'ILBENFTYPE') CUST_TYPE FROM PT_IL_POLICY, PT_IL_POL_BENEFICIARY WHERE PBEN_REF_ID1 = ? "
				+ "AND POL_SYS_ID = PBEN_POL_SYS_ID ORDER BY CUST_TYPE DESC";
		
		/*end*/
		
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getDataList_CUST_DTL_UPD().clear();
			connection = CommonUtils.getConnection();
			/*parameter changed by raja on 31-05-2017 for ssp call id - ZBILQC-1724387 */
			System.out.println("inside execute Query cust code  ===>"+compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN().getCDU_CUST_REF_ID1());
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, 
					new Object[] { compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN().getCDU_CUST_REF_ID1(),
							compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN().getCDU_CUST_REF_ID1(),
							compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN().getCDU_CUST_REF_ID1()});
			/*end*/
			while (resultSet.next()) {
				CUST_DTL_UPD_BEAN BEAN = new CUST_DTL_UPD_BEAN();
				
				BEAN.setPOL_NO(resultSet
						.getString("POL_NO"));
				BEAN.setPOL_PROD_CODE(resultSet
						.getString("POL_PROD_CODE"));
				BEAN.setPOL_STATUS(resultSet
						.getString("POL_STATUS"));
				
				BEAN.setCUST_TYPE(resultSet.getString("CUST_TYPE"));
				compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getDataList_CUST_DTL_UPD().add(BEAN);
	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	
	

	/*addded by raja on 20-03-2017 for ssp id -- ZBILQC-1722723*/
	
	public void description(CUST_DTL_UPD_BEAN BEAN) throws SQLException, DBException
	{
		Connection connection=CommonUtils.getConnection();
		
		if(BEAN.getCDU_BUS_CITY_CODE()!=null)
		{
			String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' and pc_code=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_BUS_CITY_CODE()});
			while(rs.next())
			{
				BEAN.setCDU_BUS_CITY_CODE_DESC(rs.getString("PC_DESC"));
			}
		}
		else
		{
			BEAN.setCDU_BUS_CITY_CODE_DESC(null);
		}
		
		
		if(BEAN.getCDU_MAR_STATUS()!=null)
		{
			String query="SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'MARI_STAT'  AND PS_CODE=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_MAR_STATUS()});
			while(rs.next())
			{
				BEAN.setCDU_MAR_STATUS_DESC(rs.getString("PS_CODE_DESC"));
			}
		}
		else
		{
			BEAN.setCDU_MAR_STATUS_DESC(null);
		}
		
		if(BEAN.getCDU_BUS_COUNTRY()!=null)
		{
			String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' and pc_code=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_BUS_COUNTRY()});
			while(rs.next())
			{
				BEAN.setCDU_BUS_COUNTRY_DESC(rs.getString("PC_DESC"));
			}
		}
		else
		{
			BEAN.setCDU_BUS_COUNTRY_DESC(null);
		}
		
		
		if(BEAN.getCDU_CORRES_CITY_CODE()!=null)
		{
			String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' and pc_code=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_CORRES_CITY_CODE()});
			while(rs.next())
			{
				BEAN.setCDU_CORRES_CITY_DESC(rs.getString("PC_DESC"));
			}
		}
		else
		{
			BEAN.setCDU_CORRES_CITY_DESC(null);
		}
		
		
		if(BEAN.getCDU_CORRES_COUNTRY()!=null)
		{
			String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' and pc_code=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_CORRES_COUNTRY()});
			while(rs.next())
			{
				BEAN.setCDU_CORRES_COUNTRY_DESC(rs.getString("PC_DESC"));
			}
		}
		else
		{
			BEAN.setCDU_BUS_COUNTRY_DESC(null);
		}
		
		/*Added by Ameen for KIC enabling 3rd address fields*/
		if(BEAN.getCDU_OTH_CITY_CODE()!=null)
		{
			String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' and pc_code=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_OTH_CITY_CODE()});
			if(rs.next())
			{
				BEAN.setCDU_OTH_CITY_DESC(rs.getString("PC_DESC"));
			}
		}
		else
		{
			BEAN.setCDU_OTH_CITY_DESC(null);
		}
		if(BEAN.getCDU_OTH_COUNTRY()!=null)
		{
			String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' and pc_code=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_OTH_COUNTRY()});
			if(rs.next())
			{
				BEAN.setUI_M_CDU_OTH_COUNTRY_DESC(rs.getString("PC_DESC"));
			}
		}
		else
		{
			BEAN.setUI_M_CDU_OTH_COUNTRY_DESC(null);
		}
		if(BEAN.getCDU_CUST_OCC_CODE()!=null)
		{
			String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'OCCUPATION' and pc_code=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_CUST_OCC_CODE()});
			if(rs.next())
			{
				BEAN.setUI_M_CDU_CUST_OCC_CODE_DESC(rs.getString("PC_DESC"));
			}
		}
		else
		{
			BEAN.setCDU_OTH_CITY_DESC(null);
		}
		if(BEAN.getCDU_CUST_NATIONALITY_CODE()!=null)
		{
			String query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'NATLITY' and pc_code=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_CUST_NATIONALITY_CODE()});
			if(rs.next())
			{
				BEAN.setUI_M_CDU_CUST_NATIONALITY_CODE_DESC(rs.getString("PC_DESC"));
			}
		}
		else
		{
			BEAN.setUI_M_CDU_OTH_COUNTRY_DESC(null);
		}
	
		
		/* Added by kavitha on 30.07.2018 for KICLIFEQC-1759654*/
		if(BEAN.getCDU_CATG_CODE()!=null){
			String query="SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'CATG' AND PS_CODE = ?";
			
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{BEAN.getCDU_CATG_CODE()});
			if(rs.next()){
				BEAN.setUI_M_CDU_CATG_CODE_DESC(rs.getString("PS_CODE_DESC"));
			}
		}
		else{
			BEAN.setUI_M_CDU_CATG_CODE_DESC(null);
		}
		
		/*End*/
		
	}
	
	/*end*/
	/* Added by kavitha on 30.07.2018 for KICLIFEQC-1759654*/
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
	/*end*/
	
}
