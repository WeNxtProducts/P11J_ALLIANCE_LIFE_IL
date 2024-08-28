package com.iii.pel.forms.PILM086_APAC;

import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.premia.common.utils.DBProcedures;



public class PILM086_APAC_HELPER {
	
	public void postQuery(PILM086_APAC_BEAN bean)
	throws Exception {
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;
		ArrayList<String> list3 = null;
		ArrayList<String> list4 = null;
		


		DBProcedures procedures = new DBProcedures();
		try {
			list1 = DBProcedures.P_VAL_SYSTEM("LIMODCODES", bean.getBRH_GRP_ID(), bean.getBRH_GRP_ID_DESC(), "N", null);
						System.out.println(list1.get(0));	
			if(!list1.isEmpty() && list1.get(0)!=null ){
				bean.setBRH_GRP_ID_DESC(list1.get(0));
			}

			
			/*list1 = DBProcedures.P_VAL_SYSTEM("ILBENFTYPE", beneficiaryBean
					.getPBEN_BNF_TYPE(), beneficiaryBean
					.getUI_M_PBEN_TYPE_DESC(), "N", dummyBean
					.getUI_M_PS_VALUE_DUMMY());
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					beneficiaryBean.setUI_M_PBEN_TYPE_DESC(list1.get(0));
				}
				if (list1.get(1) != null) {
					dummyBean.setUI_M_PS_VALUE_DUMMY(list1.get(1));
				}
			}
			list2 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
					.getPBEN_CATG_CODE(), beneficiaryBean.getUI_M_CATG_DESC(),
					"N", dummyBean.getUI_M_PS_VALUE_DUMMY());
			if (list2 != null && !list2.isEmpty()) {
				if (list2.get(0) != null) {
					beneficiaryBean.setUI_M_CATG_DESC(list2.get(0));
				}
				if (list2.get(1) != null) {
					dummyBean.setUI_M_PS_VALUE_DUMMY(list2.get(1));
				}
			}

			Added by Raja on 8/3/2016 for hide MICR field (Start)
			list3 = procedures.P_VAL_CODES("CITY", beneficiaryBean
					.getPBEN_CITY_CODE(), beneficiaryBean
					.getUI_M_CITY_CODE_DESC(), "N", "N", null);
			
			if(!list3.isEmpty() && list3.get(0)!=null )
			    beneficiaryBean.setUI_M_CITY_CODE_DESC(list3.get(0));
			
			list4 = procedures.L_CHK_BANK(beneficiaryBean
					.getPBEN_BANK_CODE(), null,null);
			
			if(!list4.isEmpty() && list4.get(0)!=null )
			    beneficiaryBean.setUI_M_BANK_CODE_DESC(list4.get(0));*/
			
			/*End*/
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
