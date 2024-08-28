package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_BENEFICIARY_HELPER {

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_POL_BENEFICIARY_DELEGATE()
		.executeSelectStatement(compositeAction);

		List<PT_IL_POL_BENEFICIARY> dataList = compositeAction
				.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
				.getDataList_PT_IL_POL_BENEFICIARY();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_POL_BENEFICIARY PT_IL_POL_BENEFICIARY_BEAN = dataList.get(0);
			PT_IL_POL_BENEFICIARY_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
			.setPT_IL_POL_BENEFICIARY_BEAN(PT_IL_POL_BENEFICIARY_BEAN);
		}
	}

	public void keyDelRec(PT_IL_POL_BENEFICIARY beneficiaryBean) {

		if (beneficiaryBean.getROWID() != null
				&& beneficiaryBean.getPBEN_BNF_NAME() == null) {
			beneficiaryBean.setPBEN_SR_NO(null);
		}
	}

	
	/*Modified by Janani on 29.03.2018 for KIC*/
	/*public void postQuery(PT_IL_POL_BENEFICIARY beneficiaryBean, DUMMY dummyBean)*/
	
	public void postQuery(PT_IL_POL_BENEFICIARY beneficiaryBean, DUMMY dummyBean,PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction)
	
	/*End*/		
			throws Exception {
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<String> list2 = null;

		/*Added by Raja on 8/3/2016 for hide MICR field (Start)*/
		ArrayList<String> list3=null;
		ArrayList<String> list4=null;
		/*End*/

		DBProcedures procedures = new DBProcedures();
		try {
			list = procedures.P_VAL_CODES("ILBENFREL", beneficiaryBean
					.getPBEN_RELATION_CODE(), beneficiaryBean
					.getUI_M_PBEN_RELATION_DESC(), "N", "N", null);

			if(!list.isEmpty() && list.get(0)!=null )
				beneficiaryBean.setUI_M_PBEN_RELATION_DESC(list.get(0));

			list1 = DBProcedures.P_VAL_SYSTEM("ILBENFTYPE", beneficiaryBean
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

			/*Added by Raja on 8/3/2016 for hide MICR field (Start)*/
			list3 = procedures.P_VAL_CODES("CITY", beneficiaryBean
					.getPBEN_CITY_CODE(), beneficiaryBean
					.getUI_M_CITY_CODE_DESC(), "N", "N", null);

			if(!list3.isEmpty() && list3.get(0)!=null )
				beneficiaryBean.setUI_M_CITY_CODE_DESC(list3.get(0));

			list4 = procedures.L_CHK_BANK(beneficiaryBean
					.getPBEN_BANK_CODE(), null,null);

			if(!list4.isEmpty() && list4.get(0)!=null )
				beneficiaryBean.setUI_M_BANK_CODE_DESC(list4.get(0));

			/*End*/

			/*Added by Janani on 29.03.2018 for KIC*/
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			System.out.println("benfField ====>>" +benfField);
			
			/*
			 * 
			 * commented by Dhinesh on 30-05-2018 
			 * 
			 * if(benfField == 0)*/
			if(benfField == 0 || benfField == 2)
			{
				 if(beneficiaryBean.getPBEN_BNF_TYPE() != null && beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("B"))
				{
					 beneficiaryAction.getCOMP_UI_M_BANK_CODE().setRequired(true);
					 beneficiaryAction.getCOMP_UI_M_BRANCH_CODE().setRequired(true);
					 beneficiaryAction.getCOMP_PBEN_BNF_NAME().setRequired(false);
					 beneficiaryAction.getCOMP_PBEN_NAME_MAND().setRendered(false);
					 beneficiaryAction.getCOMP_PBEN_REF_ID1().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_CATG_CODE().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_AGE().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_ACNT_NO().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_EMAIL().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_REMARKS().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_PERC().setRequired(true);
						beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(false);
				}else if(beneficiaryBean.getPBEN_BNF_TYPE() != null && beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("S"))
				{
					beneficiaryAction.getCOMP_PBEN_REF_ID1().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_CATG_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_AGE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_BNF_NAME().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_NAME_MAND().setRendered(false);
					beneficiaryAction.getCOMP_PBEN_ACNT_NO().setRequired(false);
					beneficiaryAction.getCOMP_UI_M_BANK_CODE().setRequired(false);
					beneficiaryAction.getCOMP_UI_M_BRANCH_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_EMAIL().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_REMARKS().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_PERC().setRequired(true);
					beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(false);
					
				}else
				{
					beneficiaryAction.getCOMP_UI_M_BANK_CODE().setRequired(false);
					beneficiaryAction.getCOMP_UI_M_BRANCH_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_REF_ID1().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_CATG_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_AGE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_BNF_NAME().setRequired(true);
					beneficiaryAction.getCOMP_PBEN_NAME_MAND().setRendered(true);
					beneficiaryAction.getCOMP_PBEN_ACNT_NO().setRequired(false);
					beneficiaryAction.getCOMP_UI_M_BANK_CODE().setRequired(false);
					beneficiaryAction.getCOMP_UI_M_BRANCH_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_EMAIL().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_REMARKS().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_PERC().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(false);
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenNewBlockInstance(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_BENEFICIARY_DELEGATE delegate = new PT_IL_POL_BENEFICIARY_DELEGATE();
		try {
			delegate.executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preUpdate(PT_IL_POLICY policyBean, CTRL ctrlBean,
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		try {
			beneficiaryBean.setPBEN_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			beneficiaryBean.setPBEN_UPD_DT(new CommonUtils().getCurrentDate());
			beneficiaryBean.setPBEN_UPD_UID(ctrlBean.getUSER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		/*
		 * String UPDATE_QUERY = "UPDATE PT_IL_POL_BENEFICIARY SET PBEN_SR_NO =
		 * TO_NUMBER(:SYSTEM.TRIGGER_RECORD) WHERE PBEN_SYS_ID
		 * =:PT_IL_POL_BENEFICIARY.PBEN_SYS_ID AND PBEN_POL_SYS_ID =
		 * :PT_IL_POLICY.POL_SYS_ID;
		 */
	}

	public void preInsert(PT_IL_POLICY policyBean, CTRL ctrlBean,
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {

		String M_UNQ_ADDL_COVER_YN = null;
		Double M_NO_ASSR = null;
		String M_APPL_ALL = null;
		String CURSOR_C1 = "SELECT PT_IL_PBEN_SYS_ID.NEXTVAL FROM DUAL ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				beneficiaryBean.setPBEN_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			beneficiaryBean.setPBEN_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			beneficiaryBean.setPBEN_CR_DT(new CommonUtils().getCurrentDate());
			beneficiaryBean.setPBEN_CR_UID(ctrlBean.getUSER_ID());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		Long POL_SYS_ID = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
		compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN()
		.setDEFAULT_WHERE("PBEN_POL_SYS_ID  = " + POL_SYS_ID + "");
	}

	/* changed the method argument by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
	public void whenCreateRecord(PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction)
			throws Exception {

		Double M_PS_VALUE = null;
		String M_PS_CODE_DESC = null;
		ArrayList<String> list = null;
		try {
			PT_IL_POL_BENEFICIARY beneficiaryBean = beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN();
			if (beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY().size() == 0) {
				beneficiaryBean.setPBEN_SR_NO(1);
			}else{
				beneficiaryBean.setPBEN_SR_NO(
						beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY().size()+1);
			}
			list = DBProcedures.P_VAL_SYSTEM("IL_BNF_ACT", "IL_BNF_ACT",
					M_PS_CODE_DESC, "N", CommonUtils.getProcedureValue(M_PS_VALUE));
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					M_PS_CODE_DESC = list.get(0);
				}
				if (list.get(1) != null) {
					M_PS_VALUE = Double.parseDouble(list.get(1));
				}
			}

			if (M_PS_VALUE == 1) {
				if (beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY().size() == 0) {
					beneficiaryBean.setPBEN_PERC(100.0d);
				} else {
					beneficiaryBean.setPBEN_PERC(0.0d);
				}
				beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(true);
				/*beneficiaryAction.setINSERT_ALLOWED(false);
				beneficiaryAction.setINSERT_ALLOWED(false);*/
			}
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

			beneficiaryBean.setPBEN_EFF_FM_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_START_DT());
			beneficiaryBean.setPBEN_EFF_TO_DT(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_EXPIRY_DT());

			/* End */
			
			/*Added by Janani on 29.03.2018 for KIC*/
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			System.out.println("benfField ====>>" +benfField);
			
			/*
			 * 
			 * commented by Dhinesh on 30-05-2018 
			 * 
			 * if(benfField == 0)*/
			if(benfField == 0 || benfField == 2)
			{
				 if(beneficiaryBean.getPBEN_BNF_TYPE() != null && beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("B"))
				{
					 beneficiaryAction.getCOMP_UI_M_BANK_CODE().setRequired(true);
					 beneficiaryAction.getCOMP_UI_M_BRANCH_CODE().setRequired(true);
					 beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
					 beneficiaryAction.getCOMP_PBEN_DOB().setDisabled(true);
					 beneficiaryAction.getCOMP_PBEN_BNF_NAME().setRequired(false);
					 beneficiaryAction.getCOMP_PBEN_NAME_MAND().setRendered(false);
					 
					 beneficiaryAction.getCOMP_PBEN_REF_ID1().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_CATG_CODE().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_AGE().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_ACNT_NO().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_EMAIL().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_REMARKS().setRequired(false);
						beneficiaryAction.getCOMP_PBEN_PERC().setRequired(true);
						beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(false);
					 
				}else if(beneficiaryBean.getPBEN_BNF_TYPE() != null && beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("S"))
				{
					beneficiaryAction.getCOMP_PBEN_REF_ID1().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_CATG_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_AGE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_BNF_NAME().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_NAME_MAND().setRendered(false);
					beneficiaryAction.getCOMP_PBEN_ACNT_NO().setRequired(false);
					beneficiaryAction.getCOMP_UI_M_BANK_CODE().setRequired(false);
					beneficiaryAction.getCOMP_UI_M_BRANCH_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_EMAIL().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_REMARKS().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_PERC().setRequired(true);
					beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(false);
					
				}else
				{
									
					beneficiaryAction.getCOMP_PBEN_REF_ID1().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_CATG_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_AGE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_BNF_NAME().setRequired(true);
					beneficiaryAction.getCOMP_PBEN_NAME_MAND().setRendered(true);
					beneficiaryAction.getCOMP_PBEN_ACNT_NO().setRequired(false);
					beneficiaryAction.getCOMP_UI_M_BANK_CODE().setRequired(false);
					beneficiaryAction.getCOMP_UI_M_BRANCH_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_EMAIL().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_REMARKS().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_PERC().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(false);
				}
			}
			
			/*End*/
		} catch (DBException e) {
			e.printStackTrace();
			//throw new Exception(e.getMessage());
		}
	}

	public void PBEN_BNF_TYPE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction) throws Exception {

		String CURSOR_C1 = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'ILBENFTYPE' ";
		PT_IL_POL_BENEFICIARY beneficiaryBean = beneficiaryAction
				.getPT_IL_POL_BENEFICIARY_BEAN();
		String M_FLAG = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			if (beneficiaryBean.getPBEN_BNF_TYPE() != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection);
				while (resultSet.next()) {
					if (resultSet.getString(1).equals(
							beneficiaryBean.getPBEN_BNF_TYPE())) {
						beneficiaryBean.setUI_M_PBEN_TYPE_DESC(resultSet
								.getString(2));
						M_FLAG = "Y";
						break;
					} else {
						M_FLAG = "N";
					}
				}
				if ("N".equals(M_FLAG)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71253"));
				}
				/*
				 * 
				 * commented by sankara narayanan this vakodation is handled in action class itswld
				 * 
				 * if ("A".equals(beneficiaryBean.getPBEN_BNF_TYPE())) {
					beneficiaryBean.setPBEN_RELATION_CODE(" ");
					beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(
							false);
				} else {
					beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(
							true);
				}*/
				if ("N".equals(beneficiaryBean.getPBEN_BNF_TYPE())) {
					beneficiaryAction.getCOMP_PBEN_REF_ID2().setRequired(true);
				} else {
					beneficiaryAction.getCOMP_PBEN_REF_ID2().setRequired(false);
				}
			}
			/* Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			for(PT_IL_POL_BENEFICIARY  bn: beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY()) {
				if(!(bn.getPBEN_BNF_TYPE().equalsIgnoreCase(beneficiaryBean.getPBEN_BNF_TYPE())))
				{
					if((bn.getPBEN_BNF_TYPE().equalsIgnoreCase("S") || bn.getPBEN_BNF_TYPE().equalsIgnoreCase("A")))
					{
						if((beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("S") || beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("A")))
						{
							System.out.println("your beneficiary type is added");
						}
						else
						{
							throw new Exception("Cannot have Assignee and Nominee in a single policy");
						}
					}else
					{
						throw new Exception("Cannot have Assignee and Nominee in a single policy");
					}
				}
			}

			if(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("A"))
			{
				/*Modified by Ameen on 04-04-2017 as per vinoth sugg. to avoid benf. % defaulting*/
				int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
				System.out.println("benfField ====>>" +benfField);
				/*
				 * 
				 * commented by Dhinesh on 30-05-2018 
				 * 
				 * if(benfField == 0)*/
				if(benfField == 0 || benfField == 2){
					System.out.println("Falcon Param. no Default value set.");
				}else{
				beneficiaryBean.setPBEN_PERC(100.0);
				}
			}
			else if(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("S"))
			{
				/*Modified by pidugu raj dt: 30-08-2018 for kic
				 * beneficiaryBean.setPBEN_PERC(0.0);*/
				beneficiaryBean.setPBEN_PERC(beneficiaryBean.getPBEN_PERC());
				/*End Modified by pidugu raj dt: 30-08-2018 for kic*/
			}

			/*End*/
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/*public void PBEN_REF_ID1_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		Double M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_DATE_CHAR = null;
		Integer M_GENDER = null;
		Double M_VALUE = null;
		String M_EXIST = null;
		Date M_TEMP_DATE = null;
		Date M_DOB_DT = null;
		String M_CUST_REF_ID1 = null;
		Double M_LENGTH_1 = null;
		Double M_NEW_IC_NO_LENGTH = null;
		Integer M_REF_ID_1_LENGTH = compositeAction
				.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getCOMP_PBEN_REF_ID1()
				.getMaxlength();
		String M_CODE_DESC = null;
		Double M_PS_VALUE = null;
		String CURSOR_C1 = "SELECT  COUNT(PBEN_SYS_ID) FROM PT_IL_POL_BENEFICIARY WHERE PBEN_POL_SYS_ID = ? ";
		String CURSOR_C2 = "SELECT SUBSTR(M_CUST_REF_ID1,1,6) FROM   DUAL";

		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		
		added by raja on 13-05-2017
		PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction=compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();
		end
		
		
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<OracleParameter> list2 = null;
		ArrayList<String> list3 = null;
		DBProcedures procedures = new DBProcedures();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		
		Added by Saranya on 24/04/2017
		ArrayList<String> list4 = null;
		ArrayList<String> list5 = null;
		End
		
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		try {
			connection = CommonUtils.getConnection();


			list1 = DBProcedures.P_VAL_SYSTEM("CUSTREFFMT", "CUSTREFFMT",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_PS_VALUE));
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					M_CODE_DESC = list1.get(0);
				}
				if (list1.get(1) != null) {
					M_PS_VALUE = Double.parseDouble(list1.get(1));
				}
			}


			list = DBProcedures.P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_1",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_NEW_IC_NO_LENGTH));
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					M_CODE_DESC = list.get(0);
				}
				if (list.get(1) != null) {
					M_NEW_IC_NO_LENGTH = Double.parseDouble(list.get(1));
				}
			}
			M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,
					M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);


			if(M_PS_VALUE == 1)
			{
				if (beneficiaryBean.getPBEN_REF_ID1().length() != M_LENGTH_1) {
					 changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee
					throw new Exception("Citizen ID No should have exactly 12 digits");
					End
				}
			}
			else
			{
				M_EXIST = "Y";
			}
			 changed by R. Raja on 08-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee
for(PT_IL_POL_BENEFICIARY  bn: compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getDataList_PT_IL_POL_BENEFICIARY()) {
	if((bn.getPBEN_REF_ID1().equalsIgnoreCase(beneficiaryBean.getPBEN_REF_ID1())))
	{
		throw new Exception("Customer could used be already");
	}
}
End
			System.out.println("M_EXIST      "+M_EXIST);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getDouble(1);
			}
			CommonUtils.closeCursor(resultSet);
			list1 = DBProcedures.P_VAL_SYSTEM("CUSTREFFMT", "CUSTREFFMT",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_PS_VALUE));
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					M_CODE_DESC = list1.get(0);
				}
				if (list1.get(1) != null) {
					M_PS_VALUE = Double.parseDouble(list1.get(1));
				}
			}
			if (M_PS_VALUE == 1 && (CommonUtils.nvl(M_EXIST, "N") != "Y"
					&& "1".equals(policyBean.getPOL_DS_TYPE())
					|| ("2".equals(policyBean.getPOL_DS_TYPE()) || policyBean
							.getPOL_END_NO_IDX() == 0)
							|| "011".equals(policyBean.getPOL_END_TYPE())
							|| "001".equals(policyBean.getPOL_END_TYPE()))) {
				// we used direct java method to find substring
				M_DATE_CHAR = beneficiaryBean.getPBEN_REF_ID1().substring(0,6);
				//M_TEMP_DATE = CommonUtils.stringToPelUtilDate(M_DATE_CHAR);
				M_TEMP_DATE = getFormattedDateFmIcNo(M_DATE_CHAR);
				if (CommonUtils.getYearFromDate(M_TEMP_DATE) > CommonUtils
						.getYearFromDate(new CommonUtils().getCurrentDate())) {
					M_TEMP_DATE = CommonUtils.addMonthsToDate(M_TEMP_DATE,-1200);
				}
				list2 = localProcedure.P_CALC_ANB(
						new CommonUtils().getCurrentDate(), 
						M_TEMP_DATE,
						dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
						beneficiaryBean.getPBEN_AGE());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0).getValueObject() != null) {
						beneficiaryBean.setPBEN_AGE((Integer)list2.get(0).getValueObject());
					}
				}
				M_GENDER = Integer.parseInt(beneficiaryBean.getPBEN_REF_ID1().substring(beneficiaryBean.getPBEN_REF_ID1().length()-1));
				if (M_GENDER % 2 == 0) {
					beneficiaryBean.setPBEN_CATG_CODE("2");
				} else if (M_GENDER % 2 > 0) {
					beneficiaryBean.setPBEN_CATG_CODE("1");
				}
				if (beneficiaryBean.getPBEN_CATG_CODE() != null) {
					list3 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
							.getPBEN_CATG_CODE(), beneficiaryBean
							.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
					if (list3 != null && !list3.isEmpty()) {
						if (list3.get(0) != null) {
							beneficiaryBean.setUI_M_CATG_DESC(list3.get(0));
						}
						if (list3.get(1) != null) {
							M_VALUE = Double.parseDouble(list3.get(1));
						}
					}
				}
				localProcedure.IL_GET_BENEF_DTL_ID(beneficiaryBean
						.getPBEN_REF_ID1(), beneficiaryBean.getPBEN_REF_ID2(),
						beneficiaryBean);
			}
			
			
			added by raja on 23-03-2017 for ZBILQC-1718714 
			if(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().
					getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_REF_ID1().
					equalsIgnoreCase(beneficiaryBean.getPBEN_REF_ID1()))
			{
				throw new Exception("Assured should not be a nominee");
			}
			end
			
			added by raja on 11-04-2017 for citizen id field change
			boolean flag=false;
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			System.out.println("benfField ====>>" +benfField);
			if(benfField == 1){
			
			if(beneficiaryBean.getPBEN_BNF_TYPE()!=null && 
					(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("A") || 
							beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("S")))
					{
				
				String query_Bank="SELECT BANK_CODE,BANK_NAME,BANK_BR_CODE,BANK_EMAIL FROM FM_BANK WHERE BANK_UNIVERSAL_CODE=?";
				
				ResultSet resultset_Bank=new CRUDHandler().executeSelectStatement(
						query_Bank, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1()});
				while(resultset_Bank.next())
				{
					flag=true;
					beneficiaryBean.setPBEN_BNF_NAME(resultset_Bank.getString("BANK_NAME"));
					beneficiaryBean.setPBEN_BNF_CODE(resultset_Bank.getString("BANK_CODE"));
					beneficiaryBean.setPBEN_DIVISION(resultset_Bank.getString("BANK_BR_CODE"));
					beneficiaryBean.setPBEN_EMAIL(resultset_Bank.getString("BANK_EMAIL"));
					beneficiaryBean.setPBEN_BANK_CODE(resultset_Bank.getString("BANK_CODE"));
					beneficiaryBean.setUI_M_BANK_CODE_DESC(resultset_Bank.getString("BANK_NAME"));
					}
				if(flag==false)
				{
					ArrayList<String> listcity = null;
					ArrayList<String> listbank = null;
					
					String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,"
							+ "CUST_ADDR3,CUST_CITY_CODE,CUST_BANK_CODE,CUST_BANK_AC_NO "
							+ "FROM PM_CUSTOMER WHERE CUST_ROC_NO=?";
					ResultSet resultsetcustomer=new CRUDHandler().executeSelectStatement(
							query, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1()});
					while(resultsetcustomer.next())
					{
						flag=true;
						beneficiaryBean.setPBEN_BNF_NAME(resultsetcustomer.getString("CUST_NAME"));
						beneficiaryBean.setPBEN_BNF_CODE(resultsetcustomer.getString("CUST_CODE"));
						beneficiaryBean.setPBEN_ADDRESS_1(resultsetcustomer.getString("CUST_ADDR1"));
						beneficiaryBean.setPBEN_ADDRESS_2(resultsetcustomer.getString("CUST_ADDR2"));
						beneficiaryBean.setPBEN_ADDRESS_3(resultsetcustomer.getString("CUST_ADDR3"));
						beneficiaryBean.setPBEN_CITY_CODE(resultsetcustomer.getString("CUST_CITY_CODE"));
						beneficiaryBean.setPBEN_BANK_CODE(resultsetcustomer.getString("CUST_BANK_CODE"));
						
						beneficiaryBean.setPBEN_ACNT_NO(resultsetcustomer.getLong("CUST_BANK_AC_NO"));
						beneficiaryBean.setPBEN_DIVISION(null);
						beneficiaryBean.setPBEN_ADDRESS_4(null);
						beneficiaryBean.setPBEN_ADDRESS_5(null);
						if(beneficiaryBean.getPBEN_CITY_CODE()!=null)
						{
							listcity = procedures.P_VAL_CODES("CITY", beneficiaryBean
									.getPBEN_CITY_CODE(), beneficiaryBean
									.getUI_M_CITY_CODE_DESC(), "N", "N", null);

							if(!listcity.isEmpty() && listcity.get(0)!=null )
								beneficiaryBean.setUI_M_CITY_CODE_DESC(listcity.get(0));
						}
						else
						{
							beneficiaryBean.setUI_M_CITY_CODE_DESC(null);
						}

						if(beneficiaryBean.getPBEN_BANK_CODE()!=null)
						{
							listbank = procedures.L_CHK_BANK(beneficiaryBean
									.getPBEN_BANK_CODE(), null,null);

							if(!listbank.isEmpty() && listbank.get(0)!=null )
								beneficiaryBean.setUI_M_BANK_CODE_DESC(listbank.get(0));
						}
						else
						{
							beneficiaryBean.setUI_M_BANK_CODE_DESC(null);
							beneficiaryBean.setPBEN_DIVISION(null);
						}
						if(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("N"))
						{
							beneficiaryBean.setPBEN_DOB(resultsetcustomer.getDate("CUST_DOB"));
						}
						else
						{
							beneficiaryBean.setPBEN_DOB(null);	
						}
					}
				}
					}
				else
				{
				End
				
			
			 changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee
			ArrayList<String> listcity = null;
			ArrayList<String> listbank = null;
			
				Modified by sarnaya on 24-04-2017
			 * 
			 * 
			 * String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,"
						+ "CUST_ADDR3,CUST_CITY_CODE,CUST_BANK_CODE,CUST_BANK_AC_NO "
						+ "FROM PM_CUSTOMER WHERE CUST_REF_ID1=?";
				
				String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,"
						+ "CUST_ADDR3,CUST_CITY_CODE,CUST_BANK_CODE,CUST_BANK_AC_NO,CUST_CATG_CODE "
						+ "FROM PM_CUSTOMER WHERE CUST_REF_ID1=?";
				End
				
			ResultSet resultsetcustomer=new CRUDHandler().executeSelectStatement(
					query, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1()});
			while(resultsetcustomer.next())
			{
				flag=true;
				beneficiaryBean.setPBEN_BNF_NAME(resultsetcustomer.getString("CUST_NAME"));
				beneficiaryBean.setPBEN_BNF_CODE(resultsetcustomer.getString("CUST_CODE"));
				beneficiaryBean.setPBEN_ADDRESS_1(resultsetcustomer.getString("CUST_ADDR1"));
				beneficiaryBean.setPBEN_ADDRESS_2(resultsetcustomer.getString("CUST_ADDR2"));
				beneficiaryBean.setPBEN_ADDRESS_3(resultsetcustomer.getString("CUST_ADDR3"));
				beneficiaryBean.setPBEN_CITY_CODE(resultsetcustomer.getString("CUST_CITY_CODE"));
				beneficiaryBean.setPBEN_BANK_CODE(resultsetcustomer.getString("CUST_BANK_CODE"));
				beneficiaryBean.setPBEN_ACNT_NO(resultsetcustomer.getLong("CUST_BANK_AC_NO"));
				
				Added by saranya on 24-04-2017
				beneficiaryBean.setPBEN_CATG_CODE(resultsetcustomer.getString("CUST_CATG_CODE"));
				list4 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
						.getPBEN_CATG_CODE(), beneficiaryBean.getUI_M_CATG_DESC(),
						"N", dummyBean.getUI_M_PS_VALUE_DUMMY());
				if (list4 != null && !list4.isEmpty()) {
					if (list4.get(0) != null) {
						beneficiaryBean.setUI_M_CATG_DESC(list4.get(0));
					}
					if (list4.get(1) != null) {
						dummyBean.setUI_M_PS_VALUE_DUMMY(list4.get(1));
					}
				}
				End
				
				Added by Raja on 13/04/2017
				beneficiaryBean.setPBEN_DOB(resultsetcustomer.getDate("CUST_DOB"));
				End
				
				beneficiaryBean.setPBEN_DIVISION(null);
				beneficiaryBean.setPBEN_ADDRESS_4(null);
				beneficiaryBean.setPBEN_ADDRESS_5(null);
				
				Added by Saranya on 24-04-2017
				if(beneficiaryBean.getPBEN_DOB()!=null)
				{
					
					list2 = localProcedure.P_CALC_ANB(
							new CommonUtils().getCurrentDate(),
							beneficiaryBean.getPBEN_DOB(),
							dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
							beneficiaryBean.getPBEN_AGE());
					if (list2 != null && !list2.isEmpty()) {
						if (list2.get(0).getValueObject() != null) {
							beneficiaryBean.setPBEN_AGE((Integer)list2.get(0).getValueObject());
						}
					}
				}
				
				else
				{
					beneficiaryBean.setPBEN_AGE(null);
				}
				
				if(beneficiaryBean.getPBEN_AGE()!=null){
				PBEN_AGE_WHEN_VALIDATE_ITEM(compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN());
				}
				End
				
				if(beneficiaryBean.getPBEN_CITY_CODE()!=null)
				{
					listcity = procedures.P_VAL_CODES("CITY", beneficiaryBean
							.getPBEN_CITY_CODE(), beneficiaryBean
							.getUI_M_CITY_CODE_DESC(), "N", "N", null);

					if(!listcity.isEmpty() && listcity.get(0)!=null )
						beneficiaryBean.setUI_M_CITY_CODE_DESC(listcity.get(0));
				}
				else
				{
					beneficiaryBean.setUI_M_CITY_CODE_DESC(null);
				}

				if(beneficiaryBean.getPBEN_BANK_CODE()!=null)
				{
					listbank = procedures.L_CHK_BANK(beneficiaryBean
							.getPBEN_BANK_CODE(), null,null);

					if(!listbank.isEmpty() && listbank.get(0)!=null )
						beneficiaryBean.setUI_M_BANK_CODE_DESC(listbank.get(0));
				}
				else
				{
					beneficiaryBean.setUI_M_BANK_CODE_DESC(null);
					beneficiaryBean.setPBEN_DIVISION(null);
				}
				if(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("N"))
				{
					beneficiaryBean.setPBEN_DOB(resultsetcustomer.getDate("CUST_DOB"));
				}
				else
				{
					beneficiaryBean.setPBEN_DOB(null);	
				}
			}
			
			
			
			}
			
		}
		
		else
		{
			ArrayList<String> listcity = null;
			ArrayList<String> listbank = null;
			
			String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,"
					+ "CUST_ADDR3,CUST_CITY_CODE,CUST_BANK_CODE,CUST_BANK_AC_NO "
					+ "FROM PM_CUSTOMER WHERE CUST_REF_ID1=?";
			ResultSet resultsetcustomer=new CRUDHandler().executeSelectStatement(
					query, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1()});
			while(resultsetcustomer.next())
			{
				flag=true;
				beneficiaryBean.setPBEN_BNF_NAME(resultsetcustomer.getString("CUST_NAME"));
				beneficiaryBean.setPBEN_BNF_CODE(resultsetcustomer.getString("CUST_CODE"));
				beneficiaryBean.setPBEN_ADDRESS_1(resultsetcustomer.getString("CUST_ADDR1"));
				beneficiaryBean.setPBEN_ADDRESS_2(resultsetcustomer.getString("CUST_ADDR2"));
				beneficiaryBean.setPBEN_ADDRESS_3(resultsetcustomer.getString("CUST_ADDR3"));
				beneficiaryBean.setPBEN_CITY_CODE(resultsetcustomer.getString("CUST_CITY_CODE"));
				beneficiaryBean.setPBEN_BANK_CODE(resultsetcustomer.getString("CUST_BANK_CODE"));
				beneficiaryBean.setPBEN_ACNT_NO(resultsetcustomer.getLong("CUST_BANK_AC_NO"));
				beneficiaryBean.setPBEN_DIVISION(null);
				beneficiaryBean.setPBEN_ADDRESS_4(null);
				beneficiaryBean.setPBEN_ADDRESS_5(null);
				if(beneficiaryBean.getPBEN_CITY_CODE()!=null)
				{
					listcity = procedures.P_VAL_CODES("CITY", beneficiaryBean
							.getPBEN_CITY_CODE(), beneficiaryBean
							.getUI_M_CITY_CODE_DESC(), "N", "N", null);

					if(!listcity.isEmpty() && listcity.get(0)!=null )
						beneficiaryBean.setUI_M_CITY_CODE_DESC(listcity.get(0));
				}
				else
				{
					beneficiaryBean.setUI_M_CITY_CODE_DESC(null);
				}

				if(beneficiaryBean.getPBEN_BANK_CODE()!=null)
				{
					listbank = procedures.L_CHK_BANK(beneficiaryBean
							.getPBEN_BANK_CODE(), null,null);

					if(!listbank.isEmpty() && listbank.get(0)!=null )
						beneficiaryBean.setUI_M_BANK_CODE_DESC(listbank.get(0));
				}
				else
				{
					beneficiaryBean.setUI_M_BANK_CODE_DESC(null);
					beneficiaryBean.setPBEN_DIVISION(null);
				}
				if(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("N"))
				{
					beneficiaryBean.setPBEN_DOB(resultsetcustomer.getDate("CUST_DOB"));
				}
				else
				{
					beneficiaryBean.setPBEN_DOB(null);	
				}
			}
				}
			if(flag==false)
			{
				throw new Exception("   It not a valid Cititzen id");
			}
			end
			 changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee		

			Added by Raja on 13/04/2017
			if(M_PS_VALUE == 1)
			{
				End
			 
			if(beneficiaryBean.getPBEN_DOB()!=null)
			{
				list2 = localProcedure.P_CALC_ANB(
						new CommonUtils().getCurrentDate(),
						
						 changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee		
						beneficiaryBean.getPBEN_DOB(),
						 end	
						
						dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
						beneficiaryBean.getPBEN_AGE());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0).getValueObject() != null) {
						beneficiaryBean.setPBEN_AGE((Integer)list2.get(0).getValueObject());
					}
				}
			}
			 changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee		
			else
			{
				beneficiaryBean.setPBEN_AGE(null);
			}
			 end

			M_GENDER = Integer.parseInt(beneficiaryBean.getPBEN_REF_ID1().substring(beneficiaryBean.getPBEN_REF_ID1().length()-1));
			if (M_GENDER % 2 == 0) {
				beneficiaryBean.setPBEN_CATG_CODE("2");
			} else if (M_GENDER % 2 > 0) {
				beneficiaryBean.setPBEN_CATG_CODE("1");
			}
			if (beneficiaryBean.getPBEN_CATG_CODE() != null) {
				list3 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
						.getPBEN_CATG_CODE(), beneficiaryBean
						.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						beneficiaryBean.setUI_M_CATG_DESC(list3.get(0));
					}
					if (list3.get(1) != null) {
						M_VALUE = Double.parseDouble(list3.get(1));
					}
				}
			}
		}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}*/
	
	
	public void PBEN_REF_ID1_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		Double M_DUMMY = null;
		String M_DUMMY1 = null;
		String M_PS_CODE = null;
		String M_DATE_CHAR = null;
		Integer M_GENDER = null;
		Double M_VALUE = null;
		String M_EXIST = null;
		Date M_TEMP_DATE = null;
		Date M_DOB_DT = null;
		String M_CUST_REF_ID1 = null;
		Double M_LENGTH_1 = null;
		Double M_NEW_IC_NO_LENGTH = null;
		Integer M_REF_ID_1_LENGTH = compositeAction
				.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getCOMP_PBEN_REF_ID1()
				.getMaxlength();
		String M_CODE_DESC = null;
		Double M_PS_VALUE = null;
		String CURSOR_C1 = "SELECT  COUNT(PBEN_SYS_ID) FROM PT_IL_POL_BENEFICIARY WHERE PBEN_POL_SYS_ID = ? ";
		String CURSOR_C2 = "SELECT SUBSTR(M_CUST_REF_ID1,1,6) FROM   DUAL";

		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		
		/*added by raja on 13-05-2017*/
		PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction=compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN();
		/*end*/
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		ArrayList<OracleParameter> list2 = null;
		ArrayList<String> list3 = null;
		DBProcedures procedures = new DBProcedures();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		try {
			connection = CommonUtils.getConnection();


			list1 = DBProcedures.P_VAL_SYSTEM("CUSTREFFMT", "CUSTREFFMT",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_PS_VALUE));
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					M_CODE_DESC = list1.get(0);
				}
				if (list1.get(1) != null) {
					M_PS_VALUE = Double.parseDouble(list1.get(1));
				}
			}


			list = DBProcedures.P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_1",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_NEW_IC_NO_LENGTH));
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					M_CODE_DESC = list.get(0);
				}
				if (list.get(1) != null) {
					M_NEW_IC_NO_LENGTH = Double.parseDouble(list.get(1));
				}
			}
			M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,
					M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);


			if(M_PS_VALUE == 1)
			{
				if (beneficiaryBean.getPBEN_REF_ID1().length() != M_LENGTH_1) {
					/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
					throw new Exception("Citizen ID No should have exactly 12 digits");
					/*End*/
				}
			}
			else
			{
				M_EXIST = "Y";
			}
			/* changed by R. Raja on 08-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee
for(PT_IL_POL_BENEFICIARY  bn: compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getDataList_PT_IL_POL_BENEFICIARY()) {
	if((bn.getPBEN_REF_ID1().equalsIgnoreCase(beneficiaryBean.getPBEN_REF_ID1())))
	{
		throw new Exception("Customer could used be already");
	}
}
End*/
			System.out.println("M_EXIST      "+M_EXIST);
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				M_DUMMY = resultSet.getDouble(1);
			}
			CommonUtils.closeCursor(resultSet);
			/*list1 = DBProcedures.P_VAL_SYSTEM("CUSTREFFMT", "CUSTREFFMT",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_PS_VALUE));
			if (list1 != null && !list1.isEmpty()) {
				if (list1.get(0) != null) {
					M_CODE_DESC = list1.get(0);
				}
				if (list1.get(1) != null) {
					M_PS_VALUE = Double.parseDouble(list1.get(1));
				}
			}*/
			if (M_PS_VALUE == 1 && (CommonUtils.nvl(M_EXIST, "N") != "Y"
					&& "1".equals(policyBean.getPOL_DS_TYPE())
					|| ("2".equals(policyBean.getPOL_DS_TYPE()) || policyBean
							.getPOL_END_NO_IDX() == 0)
							|| "011".equals(policyBean.getPOL_END_TYPE())
							|| "001".equals(policyBean.getPOL_END_TYPE()))) {
				// we used direct java method to find substring
				M_DATE_CHAR = beneficiaryBean.getPBEN_REF_ID1().substring(0,6);
				//M_TEMP_DATE = CommonUtils.stringToPelUtilDate(M_DATE_CHAR);
				M_TEMP_DATE = getFormattedDateFmIcNo(M_DATE_CHAR);
				if (CommonUtils.getYearFromDate(M_TEMP_DATE) > CommonUtils
						.getYearFromDate(new CommonUtils().getCurrentDate())) {
					M_TEMP_DATE = CommonUtils.addMonthsToDate(M_TEMP_DATE,-1200);
				}
				list2 = localProcedure.P_CALC_ANB(
						new CommonUtils().getCurrentDate(), 
						M_TEMP_DATE,
						dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
						beneficiaryBean.getPBEN_AGE());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0).getValueObject() != null) {
						beneficiaryBean.setPBEN_AGE((Integer)list2.get(0).getValueObject());
					}
				}
				M_GENDER = Integer.parseInt(beneficiaryBean.getPBEN_REF_ID1().substring(beneficiaryBean.getPBEN_REF_ID1().length()-1));
				if (M_GENDER % 2 == 0) {
					beneficiaryBean.setPBEN_CATG_CODE("2");
				} else if (M_GENDER % 2 > 0) {
					beneficiaryBean.setPBEN_CATG_CODE("1");
				}
				if (beneficiaryBean.getPBEN_CATG_CODE() != null) {
					list3 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
							.getPBEN_CATG_CODE(), beneficiaryBean
							.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
					if (list3 != null && !list3.isEmpty()) {
						if (list3.get(0) != null) {
							beneficiaryBean.setUI_M_CATG_DESC(list3.get(0));
						}
						if (list3.get(1) != null) {
							M_VALUE = Double.parseDouble(list3.get(1));
						}
					}
				}
				localProcedure.IL_GET_BENEF_DTL_ID(beneficiaryBean
						.getPBEN_REF_ID1(), beneficiaryBean.getPBEN_REF_ID2(),
						beneficiaryBean);
			}
			
			
			/*added by raja on 23-03-2017 for ZBILQC-1718714 */
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ASSRD_REF_ID1().
					equalsIgnoreCase(beneficiaryBean.getPBEN_REF_ID1()))
			{
				throw new Exception("Assured should not be a nominee");
			}
			/*end*/
			
			
			/*added by raja on 11-04-2017 for citizen id field change*/
			boolean flag=false;
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			
			System.out.println("benfField ====>>" +benfField);
			
			/*Modified by Janani on 15.05.2018 for fidelity as suggested by Ajay*/
			/*if(benfField == 1)*/
			if(benfField == 1 || benfField == 2)
			/*End*/
			
			{
			
			if(beneficiaryBean.getPBEN_BNF_TYPE()!=null && 
					(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("A") || 
							beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("S")))
					{
				
				/*
				 * COMMENTED BY DHINESH ON 09-03-2018
				 * 
				 * String query_Bank="SELECT BANK_CODE,BANK_NAME,BANK_BR_CODE,BANK_EMAIL FROM FM_BANK WHERE BANK_UNIVERSAL_CODE=?";*/
				
				/*Newly Added By Dhiensh on 09-03-2018 suggested by ajay*/
				
				/*Commented by ganesh on 12-03-2018 as suggested by siva*/
				/*String CUST_CLASS_QUERY="SELECT NVL(CCLAS_TYPE,'XXX') CUST_CLASS	FROM PM_CUSTOMER,PM_CUST_CLASS	WHERE CUST_CLASS = CCLAS_CODE AND CUST_REF_ID1 = ? "
						+ "	UNION SELECT NULL  CUST_CLASS FROM FM_BANK WHERE BANK_CODE = ? ";
						
				String query_Bank="SELECT DISTINCT CBAD_CUST_BANK_CODE BANK_CODE, CBAD_ACNT_NO, CBAD_SORT_CODE BANK_BR_CODE, CBAD_ACNT_NAME ,CUST_CODE ,CUST_EMAIL_ID_PER BANK_EMAIL, "
						+ "	(SELECT BANK_NAME FROM FM_BANK WHERE BANK_CODE = CBAD_CUST_BANK_CODE) BANK_NAME  FROM PM_CUSTOMER, PM_CUST_BANK_ACNT_DTLS	 WHERE CUST_CODE = CBAD_CUST_CODE "
						+ "   AND NVL(CBAD_PREF_ACNT_YN,'N') = 'Y'  AND CUST_REF_ID1 LIKE TRIM(?) " ; 
							 End
				
				String customerClassCode = null;
				ResultSet rs_cust_class=new CRUDHandler().executeSelectStatement(
						CUST_CLASS_QUERY, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1(),beneficiaryBean.getPBEN_REF_ID1()});
				while(rs_cust_class.next())
				{
					customerClassCode = rs_cust_class.getString("CUST_CLASS");
				}
				
				
				if("006".equalsIgnoreCase(customerClassCode))
				{
					ResultSet resultset_Bank=new CRUDHandler().executeSelectStatement(
							query_Bank, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1()});
					while(resultset_Bank.next())
					{
						flag=true;
						beneficiaryBean.setPBEN_BNF_NAME(resultset_Bank.getString("BANK_NAME"));
						beneficiaryBean.setPBEN_BNF_CODE(resultset_Bank.getString("BANK_CODE"));
						beneficiaryBean.setPBEN_DIVISION(resultset_Bank.getString("BANK_BR_CODE"));
						beneficiaryBean.setPBEN_EMAIL(resultset_Bank.getString("BANK_EMAIL"));
						beneficiaryBean.setPBEN_BANK_CODE(resultset_Bank.getString("BANK_CODE"));
						beneficiaryBean.setUI_M_BANK_CODE_DESC(resultset_Bank.getString("BANK_NAME"));
						beneficiaryBean.setPBEN_ACNT_NO(resultset_Bank.getLong("CBAD_ACNT_NO"));
						
						}
				}*/
				/*end*/
				
				/*Added by ganesh on 12-03-2018 for assigneee validation suggested by siva*/
				String assigneBankQuery="SELECT DISTINCT CBAD_CUST_BANK_CODE BANK_CODE, CBAD_ACNT_NO, CBAD_DIVISION BANK_BR_CODE, CBAD_ACNT_NAME, "
						+ "CUST_CODE, CUST_EMAIL_ID_PER BANK_EMAIL, (SELECT BANK_NAME FROM PM_BANK WHERE BANK_CODE = CBAD_CUST_BANK_CODE) BANK_NAME  "
						+ "FROM PM_CUSTOMER, PM_CUST_BANK_ACNT_DTLS  WHERE CUST_CODE = CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND CUST_REF_ID1 = TRIM(?) "
						+ "UNION "
						+ "SELECT BANK_CODE, NULL CBAD_ACNT_NO, BANK_BR_CODE, BANK_NAME, BANK_CODE, BANK_EMAIL, BANK_NAME  FROM PM_BANK  WHERE BANK_CODE = ?" ; 
				
				ResultSet rstBankQuery=new CRUDHandler().executeSelectStatement(
						assigneBankQuery, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1(),beneficiaryBean.getPBEN_REF_ID1()});
				
				while(rstBankQuery.next())
				{
					flag=true;
					beneficiaryBean.setPBEN_BNF_NAME(rstBankQuery.getString("BANK_NAME"));
					beneficiaryBean.setPBEN_BNF_CODE(rstBankQuery.getString("BANK_CODE"));
					beneficiaryBean.setPBEN_DIVISION(rstBankQuery.getString("BANK_BR_CODE"));
					beneficiaryBean.setPBEN_EMAIL(rstBankQuery.getString("BANK_EMAIL"));
					beneficiaryBean.setPBEN_BANK_CODE(rstBankQuery.getString("BANK_CODE"));
					beneficiaryBean.setUI_M_BANK_CODE_DESC(rstBankQuery.getString("BANK_NAME"));
					beneficiaryBean.setPBEN_ACNT_NO(rstBankQuery.getLong("CBAD_ACNT_NO"));
					
				}
				/*end*/
				
				
				/*ResultSet resultset_Bank=new CRUDHandler().executeSelectStatement(
						query_Bank, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1()});
				while(resultset_Bank.next())
				{
					flag=true;
					beneficiaryBean.setPBEN_BNF_NAME(resultset_Bank.getString("BANK_NAME"));
					beneficiaryBean.setPBEN_BNF_CODE(resultset_Bank.getString("BANK_CODE"));
					beneficiaryBean.setPBEN_DIVISION(resultset_Bank.getString("BANK_BR_CODE"));
					beneficiaryBean.setPBEN_EMAIL(resultset_Bank.getString("BANK_EMAIL"));
					beneficiaryBean.setPBEN_BANK_CODE(resultset_Bank.getString("BANK_CODE"));
					beneficiaryBean.setUI_M_BANK_CODE_DESC(resultset_Bank.getString("BANK_NAME"));
					}*/
				if(flag==false)
				{
					ArrayList<String> listcity = null;
					ArrayList<String> listbank = null;
					
					/*String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,"
							+ "CUST_ADDR3,CUST_CITY_CODE,CUST_BANK_CODE,CUST_BANK_AC_NO "
							+ "FROM PM_CUSTOMER WHERE CUST_ROC_NO=?";*/
					
					String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,CUST_ADDR3,"
							+ "CUST_CITY_CODE,CUST_BANK_CODE,CBAD_BANK_CODE,CBAD_BANK_NAME,CBAD_DIVISION,CBAD_ACNT_NO,CUST_EMAIL_ID_PER "
							+ "FROM PM_CUSTOMER,PM_CUST_BANK_ACNT_DTLS WHERE CUST_CODE = CBAD_CUST_CODE AND "
							+ "CUST_ROC_NO IN (?) UNION SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,"
							+ "CUST_ADDR2,CUST_ADDR3,CUST_CITY_CODE,NULL CUST_CITY_CODE,NULL CBAD_BANK_CODE,NULL "
							+ "CBAD_BANK_NAME,NULL CBAD_DIVISION,NULL CBAD_ACNT_NO,NULL CUST_EMAIL_ID_PER FROM PM_CUSTOMER WHERE CUST_CODE NOT IN (SELECT "
							+ "CBAD_CUST_CODE FROM PM_CUST_BANK_ACNT_DTLS) AND CUST_ROC_NO IN (?)";
					ResultSet resultsetcustomer=new CRUDHandler().executeSelectStatement(
							query, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1(),beneficiaryBean.getPBEN_REF_ID1()});
					while(resultsetcustomer.next())
					{
						flag=true;
						beneficiaryBean.setPBEN_BNF_NAME(resultsetcustomer.getString("CUST_NAME"));
						beneficiaryBean.setPBEN_BNF_CODE(resultsetcustomer.getString("CUST_CODE"));
						beneficiaryBean.setPBEN_ADDRESS_1(resultsetcustomer.getString("CUST_ADDR1"));
						beneficiaryBean.setPBEN_ADDRESS_2(resultsetcustomer.getString("CUST_ADDR2"));
						beneficiaryBean.setPBEN_ADDRESS_3(resultsetcustomer.getString("CUST_ADDR3"));
						beneficiaryBean.setPBEN_CITY_CODE(resultsetcustomer.getString("CUST_CITY_CODE"));
						beneficiaryBean.setPBEN_BANK_CODE(resultsetcustomer.getString("CBAD_BANK_CODE"));
						beneficiaryBean.setUI_M_BANK_CODE_DESC(resultsetcustomer.getString("CBAD_BANK_NAME"));
						beneficiaryBean.setPBEN_ACNT_NO(resultsetcustomer.getLong("CBAD_ACNT_NO"));
						beneficiaryBean.setPBEN_DIVISION(resultsetcustomer.getString("CBAD_DIVISION"));
						beneficiaryBean.setPBEN_EMAIL(resultsetcustomer.getString("CUST_EMAIL_ID_PER"));
					/*	beneficiaryBean.setPBEN_DIVISION(null);
						beneficiaryBean.setPBEN_ADDRESS_4(null);
						beneficiaryBean.setPBEN_ADDRESS_5(null);*/
						if(beneficiaryBean.getPBEN_CITY_CODE()!=null)
						{
							listcity = procedures.P_VAL_CODES("CITY", beneficiaryBean
									.getPBEN_CITY_CODE(), beneficiaryBean
									.getUI_M_CITY_CODE_DESC(), "N", "N", null);

							if(!listcity.isEmpty() && listcity.get(0)!=null )
								beneficiaryBean.setUI_M_CITY_CODE_DESC(listcity.get(0));
						}
						else
						{
							beneficiaryBean.setUI_M_CITY_CODE_DESC(null);
						}

						if(beneficiaryBean.getPBEN_BANK_CODE()!=null)
						{
							listbank = procedures.L_CHK_BANK(beneficiaryBean
									.getPBEN_BANK_CODE(), null,null);

							if(!listbank.isEmpty() && listbank.get(0)!=null )
								beneficiaryBean.setUI_M_BANK_CODE_DESC(listbank.get(0));
						}
						else
						{
							beneficiaryBean.setUI_M_BANK_CODE_DESC(null);
							beneficiaryBean.setPBEN_DIVISION(null);
						}
						if(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("N"))
						{
							beneficiaryBean.setPBEN_DOB(resultsetcustomer.getDate("CUST_DOB"));
							
							/*added by raja on 12-05-2017*/
							if(beneficiaryBean.getPBEN_DOB()!=null)
							{
							list2 = localProcedure.P_CALC_ANB(
									new CommonUtils().getCurrentDate(), 
									beneficiaryBean.getPBEN_DOB(),
									dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
									beneficiaryBean.getPBEN_AGE());
							if (list2 != null && !list2.isEmpty()) {
								if (list2.get(0).getValueObject() != null) {
									beneficiaryBean.setPBEN_AGE((Integer)list2.get(0).getValueObject());
								}
							}
							}
							
							validateAge(beneficiaryBean,beneficiaryAction);
							
							/*if(beneficiaryBean.getPBEN_AGE()!=null)
							{
								int ageParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_CHILD_AGE")).intValue();
								if(beneficiaryBean.getPBEN_AGE()<=ageParam)
								{
									beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(false);
									beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(true);
									
								} else {

									Added by Ram on 01/12/2016 for configure minimum Beneficiery Age setup
								beneficiaryBeanL_POL_BENEFICIARY_BEAN().setPBEN_GUARDIAN_NAME(null);
									End

									beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(true);
									beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);

									
								}
							}*/
						
							
							beneficiaryBean.setPBEN_CATG_CODE(resultsetcustomer.getString("CUST_CATG_CODE"));
							if (beneficiaryBean.getPBEN_CATG_CODE() != null) {
								list3 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
										.getPBEN_CATG_CODE(), beneficiaryBean
										.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
								if (list3 != null && !list3.isEmpty()) {
									if (list3.get(0) != null) {
										beneficiaryBean.setUI_M_CATG_DESC(list3.get(0));
									}
									if (list3.get(1) != null) {
										M_VALUE = Double.parseDouble(list3.get(1));
									}
								}
							}
							
							/*end*/
						}
						else
						{
							beneficiaryBean.setPBEN_DOB(null);	
						}
					}
				}
					}
				else
				{
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			ArrayList<String> listcity = null;
			ArrayList<String> listbank = null;
			
			/*String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,"
					+ "CUST_ADDR3,CUST_CITY_CODE,CUST_BANK_CODE,CUST_BANK_AC_NO,CUST_DOB "
					+ "FROM PM_CUSTOMER WHERE CUST_REF_ID1=?";*/
			
			String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,CUST_ADDR3,"
					+ "CUST_CITY_CODE,CUST_BANK_CODE,CBAD_BANK_CODE,CBAD_BANK_NAME,CBAD_DIVISION,"
					+ "CBAD_ACNT_NO,CUST_CATG_CODE,CUST_EMAIL_ID_PER "
					+ "FROM PM_CUSTOMER,PM_CUST_BANK_ACNT_DTLS WHERE CUST_CODE = CBAD_CUST_CODE AND "
					+ "CUST_REF_ID1 IN (?) UNION SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,"
					+ "CUST_ADDR2,CUST_ADDR3,CUST_CITY_CODE,NULL CUST_CITY_CODE,NULL CBAD_BANK_CODE,NULL "
					+ "CBAD_BANK_NAME,NULL CBAD_DIVISION,NULL CBAD_ACNT_NO,CUST_CATG_CODE CUST_CATG_CODE,NULL CUST_EMAIL_ID_PER "
					+ "FROM PM_CUSTOMER WHERE CUST_CODE NOT IN (SELECT "
					+ "CBAD_CUST_CODE FROM PM_CUST_BANK_ACNT_DTLS) AND CUST_REF_ID1 IN (?)";
			ResultSet resultsetcustomer=new CRUDHandler().executeSelectStatement(
					query, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1(),beneficiaryBean.getPBEN_REF_ID1()});
			while(resultsetcustomer.next())
			{
				flag=true;
				beneficiaryBean.setPBEN_BNF_NAME(resultsetcustomer.getString("CUST_NAME"));
				beneficiaryBean.setPBEN_BNF_CODE(resultsetcustomer.getString("CUST_CODE"));
				beneficiaryBean.setPBEN_ADDRESS_1(resultsetcustomer.getString("CUST_ADDR1"));
				beneficiaryBean.setPBEN_ADDRESS_2(resultsetcustomer.getString("CUST_ADDR2"));
				beneficiaryBean.setPBEN_ADDRESS_3(resultsetcustomer.getString("CUST_ADDR3"));
				beneficiaryBean.setPBEN_CITY_CODE(resultsetcustomer.getString("CUST_CITY_CODE"));
				beneficiaryBean.setPBEN_BANK_CODE(resultsetcustomer.getString("CBAD_BANK_CODE"));
				beneficiaryBean.setUI_M_BANK_CODE_DESC(resultsetcustomer.getString("CBAD_BANK_NAME"));
				beneficiaryBean.setPBEN_ACNT_NO(resultsetcustomer.getLong("CBAD_ACNT_NO"));
				beneficiaryBean.setPBEN_DIVISION(resultsetcustomer.getString("CBAD_DIVISION"));
				beneficiaryBean.setPBEN_EMAIL(resultsetcustomer.getString("CUST_EMAIL_ID_PER"));
			/*	beneficiaryBean.setPBEN_DIVISION(null);
				beneficiaryBean.setPBEN_ADDRESS_4(null);
				beneficiaryBean.setPBEN_ADDRESS_5(null);*/
				if(beneficiaryBean.getPBEN_CITY_CODE()!=null)
				{
					listcity = procedures.P_VAL_CODES("CITY", beneficiaryBean
							.getPBEN_CITY_CODE(), beneficiaryBean
							.getUI_M_CITY_CODE_DESC(), "N", "N", null);

					if(!listcity.isEmpty() && listcity.get(0)!=null )
						beneficiaryBean.setUI_M_CITY_CODE_DESC(listcity.get(0));
				}
				else
				{
					beneficiaryBean.setUI_M_CITY_CODE_DESC(null);
				}

				if(beneficiaryBean.getPBEN_BANK_CODE()!=null)
				{
					listbank = procedures.L_CHK_BANK(beneficiaryBean
							.getPBEN_BANK_CODE(), null,null);

					if(!listbank.isEmpty() && listbank.get(0)!=null )
						beneficiaryBean.setUI_M_BANK_CODE_DESC(listbank.get(0));
				}
				else
				{
					beneficiaryBean.setUI_M_BANK_CODE_DESC(null);
					beneficiaryBean.setPBEN_DIVISION(null);
				}
				if(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("N"))
				{
					beneficiaryBean.setPBEN_DOB(resultsetcustomer.getDate("CUST_DOB"));
					
					/*added by raja on 12-05-2017*/
					if(beneficiaryBean.getPBEN_DOB()!=null)
					{
					list2 = localProcedure.P_CALC_ANB(
							new CommonUtils().getCurrentDate(), 
							beneficiaryBean.getPBEN_DOB(),
							dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
							beneficiaryBean.getPBEN_AGE());
					if (list2 != null && !list2.isEmpty()) {
						if (list2.get(0).getValueObject() != null) {
							beneficiaryBean.setPBEN_AGE((Integer)list2.get(0).getValueObject());
						}
					}
					}
					
					
					validateAge(beneficiaryBean,beneficiaryAction);
					/*if(beneficiaryBean.getPBEN_AGE()!=null)
					{
						int ageParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_CHILD_AGE")).intValue();
						if(beneficiaryBean.getPBEN_AGE()<=ageParam)
						{
							beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(false);
							beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(true);
							
						} else {

							Added by Ram on 01/12/2016 for configure minimum Beneficiery Age setup
							beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_GUARDIAN_NAME(null);
							End

							beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(true);
							beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);

							
						}
					}
					*/
					beneficiaryBean.setPBEN_CATG_CODE(resultsetcustomer.getString("CUST_CATG_CODE"));
					
					if (beneficiaryBean.getPBEN_CATG_CODE() != null) {
						list3 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
								.getPBEN_CATG_CODE(), beneficiaryBean
								.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
						if (list3 != null && !list3.isEmpty()) {
							if (list3.get(0) != null) {
								beneficiaryBean.setUI_M_CATG_DESC(list3.get(0));
							}
							if (list3.get(1) != null) {
								M_VALUE = Double.parseDouble(list3.get(1));
							}
						}
					}
					
					/*end*/
				}
				else
				{
					beneficiaryBean.setPBEN_DOB(null);	
				}
			}
				}
			
			}
			
			else
			{
				ArrayList<String> listcity = null;
				ArrayList<String> listbank = null;
				
				/*String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,"
						+ "CUST_ADDR3,CUST_CITY_CODE,CUST_BANK_CODE,CUST_BANK_AC_NO "
						+ "FROM PM_CUSTOMER WHERE CUST_REF_ID1=?";*/
				String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,CUST_ADDR3,"
						+ "CUST_CITY_CODE,CUST_BANK_CODE,CBAD_BANK_CODE,CBAD_BANK_NAME,CBAD_DIVISION,CBAD_ACNT_NO,CUST_EMAIL_ID_PER,CUST_CATG_CODE "
						+ "FROM PM_CUSTOMER,PM_CUST_BANK_ACNT_DTLS WHERE CUST_CODE = CBAD_CUST_CODE AND "
						+ "CUST_REF_ID1 IN (?) UNION SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,"
						+ "CUST_ADDR2,CUST_ADDR3,CUST_CITY_CODE,NULL CUST_CITY_CODE,NULL CBAD_BANK_CODE,NULL "
						+ "CBAD_BANK_NAME,NULL CBAD_DIVISION,NULL CBAD_ACNT_NO, NULL CUST_EMAIL_ID_PER,NULL CUST_CATG_CODE FROM PM_CUSTOMER WHERE CUST_CODE NOT IN (SELECT "
						+ "CBAD_CUST_CODE FROM PM_CUST_BANK_ACNT_DTLS) AND CUST_REF_ID1 IN (?)";
				
				ResultSet resultsetcustomer=new CRUDHandler().executeSelectStatement(
						query, connection,  new Object[]{beneficiaryBean.getPBEN_REF_ID1(),beneficiaryBean.getPBEN_REF_ID1()});
				while(resultsetcustomer.next())
				{
					flag=true;
					beneficiaryBean.setPBEN_BNF_NAME(resultsetcustomer.getString("CUST_NAME"));
					beneficiaryBean.setPBEN_BNF_CODE(resultsetcustomer.getString("CUST_CODE"));
					beneficiaryBean.setPBEN_ADDRESS_1(resultsetcustomer.getString("CUST_ADDR1"));
					beneficiaryBean.setPBEN_ADDRESS_2(resultsetcustomer.getString("CUST_ADDR2"));
					beneficiaryBean.setPBEN_ADDRESS_3(resultsetcustomer.getString("CUST_ADDR3"));
					beneficiaryBean.setPBEN_CITY_CODE(resultsetcustomer.getString("CUST_CITY_CODE"));
					beneficiaryBean.setPBEN_BANK_CODE(resultsetcustomer.getString("CBAD_BANK_CODE"));
					beneficiaryBean.setUI_M_BANK_CODE_DESC(resultsetcustomer.getString("CBAD_BANK_NAME"));
					beneficiaryBean.setPBEN_ACNT_NO(resultsetcustomer.getLong("CBAD_ACNT_NO"));
					beneficiaryBean.setPBEN_DIVISION(resultsetcustomer.getString("CBAD_DIVISION"));
					beneficiaryBean.setPBEN_EMAIL(resultsetcustomer.getString("CUST_EMAIL_ID_PER"));
					/*beneficiaryBean.setPBEN_DIVISION(null);
					beneficiaryBean.setPBEN_ADDRESS_4(null);
					beneficiaryBean.setPBEN_ADDRESS_5(null);*/
					if(beneficiaryBean.getPBEN_CITY_CODE()!=null)
					{
						listcity = procedures.P_VAL_CODES("CITY", beneficiaryBean
								.getPBEN_CITY_CODE(), beneficiaryBean
								.getUI_M_CITY_CODE_DESC(), "N", "N", null);

						if(!listcity.isEmpty() && listcity.get(0)!=null )
							beneficiaryBean.setUI_M_CITY_CODE_DESC(listcity.get(0));
					}
					else
					{
						beneficiaryBean.setUI_M_CITY_CODE_DESC(null);
					}

					if(beneficiaryBean.getPBEN_BANK_CODE()!=null)
					{
						listbank = procedures.L_CHK_BANK(beneficiaryBean
								.getPBEN_BANK_CODE(), null,null);

						if(!listbank.isEmpty() && listbank.get(0)!=null )
							beneficiaryBean.setUI_M_BANK_CODE_DESC(listbank.get(0));
					}
					else
					{
						beneficiaryBean.setUI_M_BANK_CODE_DESC(null);
						beneficiaryBean.setPBEN_DIVISION(null);
					}
					if(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("N"))
					{
						beneficiaryBean.setPBEN_DOB(resultsetcustomer.getDate("CUST_DOB"));
						
						/*added by raja on 12-05-2017*/
						if(beneficiaryBean.getPBEN_DOB()!=null)
						{
						list2 = localProcedure.P_CALC_ANB(
								new CommonUtils().getCurrentDate(), 
								beneficiaryBean.getPBEN_DOB(),
								dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
								beneficiaryBean.getPBEN_AGE());
						if (list2 != null && !list2.isEmpty()) {
							if (list2.get(0).getValueObject() != null) {
								beneficiaryBean.setPBEN_AGE((Integer)list2.get(0).getValueObject());
							}
						}
						}
						
						validateAge(beneficiaryBean,beneficiaryAction);
						
						/*if(beneficiaryBean.getPBEN_AGE()!=null)
						{
							int ageParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_CHILD_AGE")).intValue();
							if(beneficiaryBean.getPBEN_AGE()<=ageParam)
							{
								beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(false);
								beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(true);
								
							} else {

								Added by Ram on 01/12/2016 for configure minimum Beneficiery Age setup
								beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_GUARDIAN_NAME(null);
								End

								beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(true);
								beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);

								
							}
						}*/
						
						beneficiaryBean.setPBEN_CATG_CODE(resultsetcustomer.getString("CUST_CATG_CODE"));
						
						if (beneficiaryBean.getPBEN_CATG_CODE() != null) {
							list3 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
									.getPBEN_CATG_CODE(), beneficiaryBean
									.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
							if (list3 != null && !list3.isEmpty()) {
								if (list3.get(0) != null) {
									beneficiaryBean.setUI_M_CATG_DESC(list3.get(0));
								}
								if (list3.get(1) != null) {
									M_VALUE = Double.parseDouble(list3.get(1));
								}
							}
						}
						
						/*end*/
					}
					else
					{
						beneficiaryBean.setPBEN_DOB(null);	
					}
				}
					}	
			
			/*
			 * condition modified by Ameen on 08-03-2018 for KICLIFEQC-1745901
			 * if(flag==false)*/
			/*  
			 * 
			 * commented By Dhinesh on 31-05-2018 
			 * 
			 * if(benfField != 0 && flag==false)  */
			if((benfField != 0 && benfField != 2) && flag==false)
			{
				throw new Exception(" It not a valid Number");
			}
			/*end*/
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/		
if(M_PS_VALUE == 1)
{
			if(beneficiaryBean.getPBEN_DOB()!=null)
			{
				list2 = localProcedure.P_CALC_ANB(
						new CommonUtils().getCurrentDate(),
						
						/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/		
						beneficiaryBean.getPBEN_DOB(),
						/* end*/	
						
						dummyBean.getUI_M_PROD_AGE_CALC_FLAG(), 
						beneficiaryBean.getPBEN_AGE());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0).getValueObject() != null) {
						beneficiaryBean.setPBEN_AGE((Integer)list2.get(0).getValueObject());
					}
				}
			}
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/		
			else
			{
				beneficiaryBean.setPBEN_AGE(null);
			}
			/* end*/

			M_GENDER = Integer.parseInt(beneficiaryBean.getPBEN_REF_ID1().substring(beneficiaryBean.getPBEN_REF_ID1().length()-1));
			if (M_GENDER % 2 == 0) {
				beneficiaryBean.setPBEN_CATG_CODE("2");
			} else if (M_GENDER % 2 > 0) {
				beneficiaryBean.setPBEN_CATG_CODE("1");
			}
			if (beneficiaryBean.getPBEN_CATG_CODE() != null) {
				list3 = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
						.getPBEN_CATG_CODE(), beneficiaryBean
						.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
				if (list3 != null && !list3.isEmpty()) {
					if (list3.get(0) != null) {
						beneficiaryBean.setUI_M_CATG_DESC(list3.get(0));
					}
					if (list3.get(1) != null) {
						M_VALUE = Double.parseDouble(list3.get(1));
					}
				}
			}
}

/*added by raja on 10-07-2017 for ZBILQC-1731018*/ 

LIFELIB lifelib = new LIFELIB();
 lifelib.P_VAL_CUST(beneficiaryBean.getPBEN_BNF_CODE(),
		 beneficiaryBean.getPBEN_BNF_NAME(), "N", "N",
		 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());
 
/*end*/

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	private Date getFormattedDateFmIcNo(String srcDate){
		String selectQuery = "SELECT TO_CHAR(TO_DATE(?,'RRMMDD'),'DD-MON-RRRR') FROM DUAL";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String trgtStrDate = null;
		Date trgtUtilDate = null;

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(selectQuery, con,
					new Object[] { srcDate });
			if (rs.next()) {
				trgtStrDate = rs.getString(1);
			}
			trgtUtilDate = CommonUtils.stringToUtilDate(trgtStrDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trgtUtilDate;
	}

	public void PBEN_REF_ID2_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
		try {
			localProcedure.IL_GET_BENEF_DTL_ID(beneficiaryBean
					.getPBEN_REF_ID1(), beneficiaryBean.getPBEN_REF_ID2(),
					beneficiaryBean);
			if ("N".equals(beneficiaryBean.getPBEN_BNF_TYPE())) {
				if (beneficiaryBean.getPBEN_REF_ID1() == null) {
					if (beneficiaryBean.getPBEN_REF_ID2() == null) {
						throw new Exception((Messages.getString(
								PELConstants.pelErrorMessagePath, "19050")));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PBEN_CATG_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {

		Double M_VALUE = null;
		ArrayList<String> list = null;
		try {
			if (beneficiaryBean.getPBEN_CATG_CODE() != null) {
				list = DBProcedures.P_VAL_SYSTEM("CATG", beneficiaryBean
						.getPBEN_CATG_CODE(), beneficiaryBean
						.getUI_M_CATG_DESC(), "E", CommonUtils.getProcedureValue(M_VALUE));
				if (list != null && !list.isEmpty()) {
					if (list.get(0) != null) {
						beneficiaryBean.setUI_M_CATG_DESC(list.get(0));
					}
					if (list.get(1) != null) {
						M_VALUE = Double.parseDouble(list.get(1));
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PBEN_AGE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction) throws Exception {
		PT_IL_POL_BENEFICIARY beneficiaryBean = beneficiaryAction
				.getPT_IL_POL_BENEFICIARY_BEAN();
		if (beneficiaryBean.getPBEN_AGE() <= 0) {
			throw new Exception((Messages.getString(
					PELConstants.pelErrorMessagePath, "91014",
					new Object[] { "Beneficiary age", "Greater than Zero" })));
		}
		if (beneficiaryBean.getPBEN_AGE() >100) {
			throw new Exception((Messages.getString(
					PELConstants.pelErrorMessagePath, "91014",
					new Object[] { "Beneficiary age", "lesser than or equal to 100" })));
		}

		/*Added by Ram on 01/12/2016 for configure minimum Beneficiery Age setup*/
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		int beneficieryMinimumAge = 0;
		String BeneficieryQuery = "SELECT PS_VALUE FROM PP_SYSTEM where PS_TYPE = ?";

		connection = CommonUtils.getConnection();

		/*Modified by Ram on 11/12/2016 for Common Age limitation*/
		/*resultSet = handler.executeSelectStatement(BeneficieryQuery, connection,new Object[] { "IL_BNFAGELMT" });*/

		resultSet = handler.executeSelectStatement(BeneficieryQuery, connection,new Object[] { "IL_CHILD_AGE" });
		/*End*/

		while (resultSet.next()) {
			beneficieryMinimumAge = resultSet.getInt(1);
		}
		System.out.println("beneficieryMinimumAge      "+beneficieryMinimumAge);
		if(beneficieryMinimumAge == 0)
		{
			throw new Exception("Nominee Minimum age setup is not available.");
		}

		/*if (beneficiaryBean.getPBEN_AGE() < 19 && !"A".equals(beneficiaryBean.getPBEN_BNF_TYPE())) {
		 * 
		 * End*/
		if (beneficiaryBean.getPBEN_AGE() <= beneficieryMinimumAge && !"A".equals(beneficiaryBean.getPBEN_BNF_TYPE())) {

			/*Added by Janani on 29.03.2018 for KIC*/
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			System.out.println("benfField ====>>" +benfField);
			
			/*
			 * 
			 * commented by Dhinesh on 30-05-2018 
			 * 
			 * if(benfField == 0)*/
			if(benfField == 0 || benfField == 2)
			{
				beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(false);
				/*
				 * 
				 * commented by Dhinesh on 31-05-2018 
				 * 
				 * beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);*/
				
				/* Newly Added By Dhinesh on 31-05-2018 */
				//commented by gopi
			//	beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(true);
				
				/* End */
			}
			else
			{
			/*End*/
			beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(false);
			//commented by gopi
		//	beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(true);
			/*Added by Ram on 11/12/2016 for FALCONLIFE-1358413*/
			beneficiaryAction.getCOMP_PBEN_GUAR_REL_CODE().setDisabled(false);
			beneficiaryAction.getCOMP_PBEN_GUAR_REL_CODE().setRequired(true);
			/*End*/
			
			}
		} else {

			/*Added by Ram on 01/12/2016 for configure minimum Beneficiery Age setup*/
			beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_GUARDIAN_NAME(null);
			/*End*/

			/*Added by Ram on 11/12/2016 for FALCONLIFE-1358413*/
			beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_GUAR_REL_CODE(null);
			beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_GUAR_REL_DESC(null);


			beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(true);
			beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);

			beneficiaryAction.getCOMP_PBEN_GUAR_REL_CODE().setDisabled(true);
			beneficiaryAction.getCOMP_PBEN_GUAR_REL_CODE().setRequired(false);
			/*End*/
		}
		/*Added by Ram on 01/12/2016 for configure minimum Beneficiery Age setup*/
		beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().resetValue();
		/*End*/

		/*Added by Ram on 11/12/2016 for FALCONLIFE-1358413*/
		beneficiaryAction.getCOMP_PBEN_GUAR_REL_CODE().resetValue();
		/*End*/
	}

	public void PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		/*Changed By Jagadeesh on 19-jul-2016*/
		String CURSOR_C1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'ILBENFREL' AND PC_CODE = ? ";
		String CURSOR_C2 = "SELECT 'X' FROM PM_CODES WHERE  PC_TYPE = 'ILBENFREL' AND PC_VALUE = DECODE( ? , 'A', '2', '1') AND PC_CODE = ? ";
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		boolean flag=false;
		try {
			connection = CommonUtils.getConnection();
			/*resultSet1 = handler.executeSelectStatement(CURSOR_C2, connection,new Object[] { beneficiaryBean.getPBEN_BNF_TYPE(),beneficiaryBean.getPBEN_RELATION_CODE() });
			if(resultSet1.next()){*/
			/* End */
			/*if(resultSet1.next()){	*/					
				resultSet = handler.executeSelectStatement(CURSOR_C1, connection,new Object[] {beneficiaryBean.getPBEN_RELATION_CODE() });
				while (resultSet.next()) {
					flag=true;
					beneficiaryBean.setUI_M_PBEN_RELATION_DESC(resultSet.getString("PC_DESC"));					
				}
			
			if(flag==false){
				beneficiaryBean.setUI_M_PBEN_RELATION_DESC(null);
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "71254")));
			}
			/*End*/
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			
			if(flag==false)
			{
				beneficiaryBean.setUI_M_PBEN_RELATION_DESC(null);
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "71254")));
			}
		/*End*/
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PBEN_PERC_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction, DUMMY dummyBean,double precentage)
					throws Exception {

		String M_PS_CODE_DESC = null;
		Double M_PS_VALUE = null;
		ArrayList<String> list = null;
		Double UI_M_SUM_PBEN_PERC = 0.0 ;

		PT_IL_POL_BENEFICIARY beneficiaryBean = beneficiaryAction
				.getPT_IL_POL_BENEFICIARY_BEAN();
		try {
			/*changed by raja on 13-0-52017*/
			/*if (beneficiaryBean.getPBEN_PERC() != null && dummyBean.getUI_M_IL_BEN_VALUE() == 0) {*/
			if (precentage >0 && dummyBean.getUI_M_IL_BEN_VALUE() == 0) {
				list = DBProcedures.P_VAL_SYSTEM(
						"IL_BNF_ACT", 
						"IL_BNF_ACT",
						M_PS_CODE_DESC, "N",
						CommonUtils.getProcedureValue(M_PS_VALUE));
				if(list != null && !list.isEmpty()){
					if(list.get(0) != null){
						M_PS_CODE_DESC = list.get(0);
					}
					if(list.get(1) != null){
						M_PS_VALUE = Double.parseDouble(list.get(1));
					}
				}
				if (M_PS_VALUE == 1) {
					if (beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY().size() == 0) {

						beneficiaryBean.setPBEN_PERC(100.00);

					} else {
						beneficiaryBean.setPBEN_PERC(0.00);
					}

				}
				/*changed by raja on 13-0-52017*/
				/*if ((beneficiaryBean.getPBEN_PERC() <0 || beneficiaryBean
						.getPBEN_PERC() > 100)) {*/
				
				/*Modified by Janani on 02.04.2018 for KIC benficiary issue*/
				//if ((precentage <0 || precentage > 100)) 
				
				if ((precentage <= 0 || precentage > 100))
				
				/*End*/
				
				{
					throw new Exception((Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Beneficiary Percentage","greater than 0 or equal to"  ,"100%" })));
				}

				for(PT_IL_POL_BENEFICIARY  bn: beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY()) {
					UI_M_SUM_PBEN_PERC = UI_M_SUM_PBEN_PERC + bn.getPBEN_PERC();
				}
				if(!beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY().contains(beneficiaryBean)){
					/*changed by raja on 13-0-52017*/
					UI_M_SUM_PBEN_PERC = UI_M_SUM_PBEN_PERC + precentage;
					/*end*/
				}


				if(UI_M_SUM_PBEN_PERC != null){
					if (UI_M_SUM_PBEN_PERC > 100.00) {
						throw new Exception((Messages.getString(PELConstants.pelErrorMessagePath, "91136")));
					}
				}
			}
			/*Added by Janani on 02.04.2018 for KIC*/
			else
			{
				
					throw new Exception((Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Beneficiary Percentage","greater than 0 or equal to"  ,"100%" })));
				
			}
			
			/*End*/
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/*Added by Raja on 8/3/2016 for hide MICR field (Start)*/
	public void UI_M_CITY_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		String CURSOR_C2 = "SELECT PC_CODE,PC_DESC FROM   PM_CODES WHERE  PC_TYPE = 'CITY'";
		String M_FLAG = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection);
			while (resultSet.next()) {
				if (beneficiaryBean.getPBEN_CITY_CODE().equals(
						resultSet.getString(1))) {
					beneficiaryBean.setUI_M_CITY_CODE_DESC(resultSet
							.getString(2));
					M_FLAG = "Y";
					break;
				} else {
					M_FLAG = "N";
				}
			}

			if ("N".equals(M_FLAG)
					&& beneficiaryBean.getPBEN_CITY_CODE()!= "S") {
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "71254")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}





	public void UI_M_BANK_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		String CURSOR_C3 = "SELECT BANK_CODE,BANK_NAME FROM FM_BANK";
		String M_FLAG = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection);
			while (resultSet.next()) {
				if (beneficiaryBean.getPBEN_BANK_CODE().equals(
						resultSet.getString(1))) {
					beneficiaryBean.setUI_M_BANK_CODE_DESC(resultSet
							.getString(2));
					M_FLAG = "Y";
					break;
				} else {
					M_FLAG = "N";
				}
			}

			if ("N".equals(M_FLAG)
					&& beneficiaryBean.getPBEN_BANK_CODE()!= "S") {
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "71254")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	/*End*/	

	public static void main(String[] args) {
		try {
			String sample="26-FEB-1989";
			Date date=CommonUtils.stringToUtilDate(sample);
			System.out.println(date);
		}catch (Exception e) {
			System.err.println("Invalid Date");
		}
	}
	/*Added by Ram on 11/12/2016 for FALCONLIFE-1358413*/
	public void PBEN_GUAR_REL_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_BENEFICIARY beneficiaryBean) throws Exception {
		/*Changed By Jagadeesh on 19-jul-2016*/

		String CURSOR_C1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'ILBENFREL' AND PC_DESC = ? ";
		String CURSOR_C2 = "SELECT 'X' FROM PM_CODES WHERE  PC_TYPE = 'ILBENFREL' AND PC_VALUE = DECODE( ? , 'A', '2', '1') AND PC_DESC = ? ";
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(CURSOR_C2, connection,new Object[] { beneficiaryBean.getPBEN_BNF_TYPE(),beneficiaryBean.getPBEN_GUAR_REL_DESC() });
			if(resultSet1.next()){
				resultSet = handler.executeSelectStatement(CURSOR_C1, connection,new Object[] {beneficiaryBean.getPBEN_GUAR_REL_DESC() });
				while (resultSet.next()) {
					beneficiaryBean.setPBEN_GUAR_REL_CODE(resultSet.getString("PC_CODE"));					
				}
			}
			else{
				beneficiaryBean.setPBEN_GUAR_REL_CODE(null);
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "71254")));
			}
			/*End*/
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	/*End*/
	/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

	public void validate_benf_type(PILT002_APAC_COMPOSITE_ACTION compositeAction,PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction) throws Exception
		{
			PT_IL_POL_BENEFICIARY beneficiaryBean = beneficiaryAction
					.getPT_IL_POL_BENEFICIARY_BEAN();
			ArrayList<String> list = null;
			String M_CODE_DESC = null;
			Double M_NEW_IC_NO_LENGTH = null;
			Double M_LENGTH_1 = null;
			Integer M_REF_ID_1_LENGTH = beneficiaryAction.getCOMP_PBEN_REF_ID1()
					.getMaxlength();
			/*Newly added by Dhiensh on 31.3.2017*/
			String CUST_REF_MAN_QUERY ="SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_CODE = 'CUSTREFMAN'";
			String CUST_REF_MAN = null;
			/*End*/
			
			
			try
			{
			for(PT_IL_POL_BENEFICIARY  bn: beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY()) {
				if(!(bn.getPBEN_BNF_TYPE().equalsIgnoreCase(beneficiaryBean.getPBEN_BNF_TYPE())))
				{
					if((bn.getPBEN_BNF_TYPE().equalsIgnoreCase("S") || bn.getPBEN_BNF_TYPE().equalsIgnoreCase("A")))
						{
						if((beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("S") || beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("A")))
						{
							System.out.println("your beneficiary type is added");
						}
						else
						{
					throw new Exception("Cannot have Assingnee and Nominee in a single policy");
						}
						}else
					{
							throw new Exception("Cannot have Assingnee and Nominee in a single policy");
					}
			}
			}
			
			list = DBProcedures.P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_1",
					M_CODE_DESC, "N", CommonUtils.getProcedureValue(M_NEW_IC_NO_LENGTH));
			if (list != null && !list.isEmpty()) {
				if (list.get(0) != null) {
					M_CODE_DESC = list.get(0);
				}
				if (list.get(1) != null) {
					M_NEW_IC_NO_LENGTH = Double.parseDouble(list.get(1));
				}
			}
			M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,
					M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);
			
			
			/*
			 * Commented by Dhinesh on 31.3.2017
			 * 		if (beneficiaryBean.getPBEN_REF_ID1().length() != M_LENGTH_1) {
				throw new Exception("Citizen ID No should have exactly 12 digits");
			}*/
			
			/*Newly Added By Dhinesh on 31.3.2017*/
			ResultSet RS_CUST_REF_MAN=new CRUDHandler().executeSelectStatement(
					CUST_REF_MAN_QUERY, CommonUtils.getConnection());
			while(RS_CUST_REF_MAN.next())
			{
				CUST_REF_MAN=RS_CUST_REF_MAN.getString("PS_VALUE");
				
			}
			System.out.println("CUST_REF_MAN--->["+CUST_REF_MAN+"]-----"+!("1".equalsIgnoreCase(CUST_REF_MAN)));
			
			if(!("1".equalsIgnoreCase(CUST_REF_MAN)))
			{
			
			if (beneficiaryBean.getPBEN_REF_ID1().length() != M_LENGTH_1) {
				throw new Exception("Citizen ID No should have exactly 12 digits");
			}
			
			}
			
			/*End*/
			
			/*for(PT_IL_POL_BENEFICIARY  bn: beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY()) {
				if(!(bn.getPBEN_REF_ID1().equalsIgnoreCase(beneficiaryBean.getPBEN_REF_ID1())))
				{
					throw new Exception("Customer could used be already");
				}
			}*/
		if(beneficiaryBean.getPBEN_REF_ID1()!=null && beneficiaryBean.getPBEN_REF_ID1().length() > 0)
		{
			boolean flag=false;
			
			/*Added by Raja on 13/04/2017*/
			/*
			 * commented by dhiensh on 09-03-2018
			 * 
			 * if(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("A") || 
			 * 
			 * 
			 * */
				if(beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("S"))
			{
				/*End*/
			 
			/*Modifed by Raja on 13/04/2017
			 * 
			 * String query="SELECT CUST_NAME,CUST_DOB,CUST_CODE,CUST_ADDR1,CUST_ADDR2,"
					+ "CUST_ADDR3,CUST_CITY_CODE,CUST_BANK_CODE,CUST_BANK_AC_NO "
					+ "FROM PM_CUSTOMER WHERE CUST_REF_ID1=?";*/
			String query="SELECT 'X' FROM PM_CUSTOMER WHERE CUST_ROC_NO=?";
			/*End*/
			
			ResultSet resultsetcustomer=new CRUDHandler().executeSelectStatement(
					query, CommonUtils.getConnection(),  new Object[]{beneficiaryBean.getPBEN_REF_ID1()});
			while(resultsetcustomer.next())
			{
				flag=true;
				
			}
			
			/*Modified by ganesh on 13-02-2018*/
			/*String Bank_query="SELECT 'X' FROM FM_BANK WHERE BANK_UNIVERSAL_CODE=?";*/
			String Bank_query="SELECT 'X' FROM PM_BANK WHERE BANK_CODE = ?";
			/*end*/
			
			ResultSet resultsetBANK=new CRUDHandler().executeSelectStatement(
					Bank_query, CommonUtils.getConnection(),  new Object[]{beneficiaryBean.getPBEN_REF_ID1()});
			while(resultsetBANK.next())
			{
				flag=true;
				
			}
			
			/*Added by Raja on 13/04/2017*/
			}
			else
			{
				/*Modified by ganesh on 12-03-2018 as suggested by siva */
				/*String query="SELECT 'X' FROM PM_CUSTOMER WHERE CUST_REF_ID1=? ";*/
				String query="SELECT 'X' FROM PM_CUSTOMER WHERE NVL(CUST_REF_ID1,CUST_ROC_NO)=?  UNION  SELECT 'X' FROM PM_BANK WHERE BANK_CODE = ?"; 
				
				ResultSet resultsetcustomer=new CRUDHandler().executeSelectStatement(
						query, CommonUtils.getConnection(),  new Object[]{beneficiaryBean.getPBEN_REF_ID1(),beneficiaryBean.getPBEN_REF_ID1()});
				/*end*/
				while(resultsetcustomer.next())
				{
					flag=true;
					
				}
			}
			/*End*/
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			/*
			 * condition modified by Ameen on 08-03-2018 for KICLIFEQC-1745901
			 * if(flag==false)*/
			/*
			 * 
			 * commented by Dhinesh on 30-05-2018
			 * 
			 * if(benfField != 0 &&flag==false)*/
			if((benfField != 0 && benfField != 2 ) && flag==false )
			{
				throw new Exception("Not a valid Cititzen id");
			}
			
			if(beneficiaryBean.getROWID() != null)
			{
			int i=0;
			for(PT_IL_POL_BENEFICIARY  bn: beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY()) {
				if(bn.getPBEN_REF_ID1().equalsIgnoreCase(beneficiaryBean.getPBEN_REF_ID1()))
				{
					i++;
				}
			}
			System.out.println("i value   ==   >"+i);
			if(i>1)
			{
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "90015", new Object[] { "Beneficiary" }));
			}
			}
			else
			{
				for(PT_IL_POL_BENEFICIARY  bn: beneficiaryAction.getDataList_PT_IL_POL_BENEFICIARY()) {
					if(bn.getPBEN_REF_ID1().equalsIgnoreCase(beneficiaryBean.getPBEN_REF_ID1()))
					{
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "90015", new Object[] { "Beneficiary" }));
					}
				}
			}
		}
		/*added by raja on 23-03-2017 for ZBILQC-1718714 */
		if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ASSRD_REF_ID1().
				equalsIgnoreCase(beneficiaryBean.getPBEN_REF_ID1()))
		{
			throw new Exception("Assured should not be a nominee");
		}
		/*end*/
			
		/*Added by Janani on 29.03.2018 for KIC*/
		int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
		System.out.println("benfField ====>>" +benfField);
		
		/*
		 * 
		 * commented by Dhinesh on 30-05-2018 
		 * 
		 * if(benfField == 0)*/
		if(benfField == 0 || benfField == 2)
		{
			 if(beneficiaryBean.getPBEN_BNF_TYPE() != null && beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("B"))
			{
				 beneficiaryAction.getCOMP_UI_M_BANK_CODE().setRequired(true);
				 beneficiaryAction.getCOMP_UI_M_BRANCH_CODE().setRequired(true);
				 beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
				 beneficiaryAction.getCOMP_PBEN_DOB().setDisabled(true);
				 beneficiaryAction.getCOMP_PBEN_BNF_NAME().setRequired(false);
				 beneficiaryAction.getCOMP_PBEN_NAME_MAND().setRendered(false);
				 
				 beneficiaryAction.getCOMP_PBEN_REF_ID1().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_CATG_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_AGE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_BNF_NAME().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_NAME_MAND().setRendered(false);
					beneficiaryAction.getCOMP_PBEN_ACNT_NO().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_EMAIL().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_REMARKS().setRequired(false);
					beneficiaryAction.getCOMP_PBEN_PERC().setRequired(true);
					beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(false);
				 
			}else if(beneficiaryBean.getPBEN_BNF_TYPE() != null && beneficiaryBean.getPBEN_BNF_TYPE().equalsIgnoreCase("S"))
			{
				beneficiaryAction.getCOMP_PBEN_REF_ID1().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_CATG_CODE().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_AGE().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_BNF_NAME().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_NAME_MAND().setRendered(false);
				beneficiaryAction.getCOMP_PBEN_ACNT_NO().setRequired(false);
				beneficiaryAction.getCOMP_UI_M_BANK_CODE().setRequired(false);
				beneficiaryAction.getCOMP_UI_M_BRANCH_CODE().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_EMAIL().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_REMARKS().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_PERC().setRequired(true);
				beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(false);
				
			}else
			{
								
				beneficiaryAction.getCOMP_PBEN_REF_ID1().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_DOB().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_CATG_CODE().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_AGE().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_RELATION_CODE().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_BNF_NAME().setRequired(true);
				beneficiaryAction.getCOMP_PBEN_NAME_MAND().setRendered(true);
				beneficiaryAction.getCOMP_PBEN_ACNT_NO().setRequired(false);
				beneficiaryAction.getCOMP_UI_M_BANK_CODE().setRequired(false);
				beneficiaryAction.getCOMP_UI_M_BRANCH_CODE().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_EMAIL().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_REMARKS().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_PERC().setRequired(false);
				beneficiaryAction.getCOMP_PBEN_PERC().setDisabled(false);
			}
		}
		
		/*End*/
			
			
		}
			catch (Exception e)
			{
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	/* End */
	
	public void validateAge(PT_IL_POL_BENEFICIARY beneficiaryBean,PT_IL_POL_BENEFICIARY_ACTION beneficiaryAction)
	{
		try
		{
			
		//Commented &modified by Saritha on 22/09/2021 for Alliance - IL
		//if(beneficiaryBean.getPBEN_AGE()>0)
		if(beneficiaryBean.getPBEN_AGE()>=0)
	{
		int ageParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_CHILD_AGE")).intValue();
		if(beneficiaryBean.getPBEN_AGE()<=ageParam)
		{
			beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(false);
			//commented by gopi
		//	beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(true);
			
		} else {

			/*Added by Ram on 01/12/2016 for configure minimum Beneficiery Age setup*/
			beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_GUARDIAN_NAME(null);
			/*End*/

			beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(true);
			beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);

			
		}
	}
	else
	{
		beneficiaryAction.getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_GUARDIAN_NAME(null);
		beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setDisabled(true);
		beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);
	}
	/*Added by Ram on 01/12/2016 for configure minimum Beneficiery Age setup*/
	beneficiaryAction.getCOMP_PBEN_GUARDIAN_NAME().resetValue();
	/*End*/
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/*end*/
}
