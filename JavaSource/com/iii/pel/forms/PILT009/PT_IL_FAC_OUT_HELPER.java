package com.iii.pel.forms.PILT009;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILP005.PT_IL_POLICY_ACTION;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_IL_FAC_OUT_HELPER {
	CRUDHandler handler = new CRUDHandler();
	public void PILT009_PRE_FORM(PILT009_COMPOSITE_ACTION compositeAction) throws Exception {
		//Moved C1 this query from M_BUT_APPR button pressed before calling PILP005 
		//Since this should be called after calling PILP005
		String C1 =" SELECT PC_FAC_CLOSE_FLAG FROM   PT_IL_PREM_COLL WHERE  PC_SYS_ID    = ?";
		PT_IL_FAC_OUT_ACTION facOutAction = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		
		DUMMY dummyBean = facOutAction.getDUMMY_BEAN();
		
		try {
			connection = CommonUtils.getConnection();
			
			if(CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO") != null) {
				dummyBean.setUI_M_POL_NO(CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO"));
			}else if(CommonUtils.getGlobalVariable("GLOBAL_MK_POL_NO") != null) {
				dummyBean.setUI_M_POL_NO(CommonUtils.getGlobalVariable("GLOBAL_MK_POL_NO"));
			}
			
			values = new Object[1];
//			Double M_PC_SYS_ID = (Double) CommonUtils.getGlobalObject("GLOBAL.M_PC_SYS_ID");
//			values[0] = M_PC_SYS_ID;
			
			resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_PREM_COLL, connection, new Object[]{dummyBean.getUI_M_POL_NO(),CommonUtils.getGlobalObject("GLOBAL.M_PC_SYS_ID")});
			
			if(resultSet.next()) {
				dummyBean.setUI_M_PREM_TYPE(resultSet.getString(1));
				dummyBean.setUI_M_SCHD_DT(resultSet.getDate(2));
				dummyBean.setUI_M_PC_SYS_ID(resultSet.getLong(3));
			}
			
			dummyBean.setPT_IL_FAC_OUT_CF("P");
			dummyBean.setPT_IL_FAC_DETL_CF("N");
			dummyBean.setPT_IL_FAC_PART_CUST_CF("P");
			dummyBean.setPT_IL_FAC_CUST_RETRO_CF("P");
			dummyBean.setPT_IL_FAC_PART_CUST_DETL_CF("N");
			dummyBean.setPT_IL_FAC_CUST_RETRO_DETL_CF("N");
			
			
			
			//Moved C1 this query from M_BUT_APPR button pressed before calling PILP005 
			//Since this should be called after calling PILP005
			
			resultSet1 = handler.executeSelectStatement(C1, connection, new Object[]{dummyBean.getUI_M_PC_SYS_ID()});
			while(resultSet1.next()){
				dummyBean.setUI_M_FAC_CLOSE_FLAG(resultSet1.getString(1));
			}
			   if(CommonUtils.nvl(dummyBean.getUI_M_FAC_CLOSE_FLAG(),"N").equals("Y")){
				   facOutAction.getCOMP_UI_M_BUT_APPRV().setDisabled(true);
				   facOutAction.setUPDATE_ALLOWED(false);
				   facOutAction.setDELETE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_DETL_ACTION().setUPDATE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_DETL_ACTION().setDELETE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_PART_CUST_ACTION().setUPDATE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_PART_CUST_ACTION().setDELETE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_PART_CUST_DETL_ACTION().setUPDATE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_PART_CUST_DETL_ACTION().setDELETE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_CUST_RETRO_ACTION().setUPDATE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_CUST_RETRO_ACTION().setDELETE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_CUST_RETRO_DETL_ACTION().setUPDATE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_CUST_RETRO_DETL_ACTION().setDELETE_ALLOWED(false);

				   compositeAction.getPILT009_PT_IL_FAC_DISC_LOAD_ACTION().setUPDATE_ALLOWED(false);
				   compositeAction.getPILT009_PT_IL_FAC_DISC_LOAD_ACTION().setDELETE_ALLOWED(false);      

			//      DISP_ALERT('Fac has been closed');
			//      STD_MESSAGE_ROUTINE(2464,:CTRL.M_LANG_CODE);      
			   }
			// End
			
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public void PILT009_WHEN_NEW_FORM_INSTANCE(PT_IL_FAC_OUT_ACTION facOutAction) throws Exception {

		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2= null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		String M_APPRV_STATUS = null;

		DUMMY dummyBean = facOutAction.getDUMMY_BEAN();

		try {
			connection = CommonUtils.getConnection();

			if(dummyBean.getUI_M_POL_NO() != null) {
				///facOutAction.getCOMP_UI_M_POL_NO().setReadonly(true);
			}

			values = new Object[1];
			values[0] = dummyBean.getUI_M_POL_NO();
			
			resultSet1 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_WHEN_NEW_FORM_INSTANCE, connection, values);
			if(resultSet1.next()){

				dummyBean.setUI_M_PDS_CURR_RATE_BS(resultSet1.getString(1));
				M_APPRV_STATUS = resultSet1.getString(2);
				dummyBean.setUI_M_POL_NO(resultSet1.getString(3));
				dummyBean.setUI_M_POL_CQS_YN(resultSet1.getString(4));
				dummyBean.setUI_M_POL_CQS_PERC(resultSet1.getDouble(5));
			} else {
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71153"));
			}

			L_POPULATE_DUMMY(facOutAction);

//			P_VAL_FINAL_PARAMETER('BASE.CURR', :DUMMY.M_BASE_CURR, 'E') ;

			values = new Object[1];
			values[0] = dummyBean.getUI_M_POL_NO();

			resultSet2 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PLAN_TYPE, connection, values);
			if (resultSet2.next()) {
				dummyBean.setUI_M_PLAN_TYPE(resultSet2.getString(1));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
		}
	}
	
	private void L_POPULATE_DUMMY(PT_IL_FAC_OUT_ACTION facOutAction) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2= null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		
		DUMMY dummyBean = facOutAction.getDUMMY_BEAN();
		
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		
		try {
			connection = CommonUtils.getConnection();
		
			values = new Object[1];
			values[0] = dummyBean.getUI_M_POL_NO();
			
			resultSet1 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_POLICY1, connection, values);
			
			if(resultSet1.next()) {
				
				dummyBean.setUI_M_FO_POL_SYS_ID(resultSet1.getLong(1));
				dummyBean.setUI_M_FAC_YN(resultSet1.getString(2));
				dummyBean.setUI_M_COINS_YN(resultSet1.getString(3));
				dummyBean.setUI_M_FACIN_YN(resultSet1.getString(4));
				dummyBean.setUI_M_POL_CUST_CURR_CODE(resultSet1.getString(5));
				dummyBean.setUI_M_POL_ISSUE_DT(resultSet1.getDate(6));
				dummyBean.setUI_M_POL_END_NO_IDX(resultSet1.getString(7));
				dummyBean.setUI_M_APPRV_STATUS(resultSet1.getString(8));
				dummyBean.setUI_M_POL_CUST_CURR_RATE(resultSet1.getDouble(9));
				dummyBean.setUI_M_SI_CURR_RATE(resultSet1.getDouble(10));
				dummyBean.setUI_M_FAC_CLOSE_FLAG(resultSet1.getString(11));
			}
			
			values = new Object[2];
			values[0] = dummyBean.getUI_M_FO_POL_SYS_ID();
			values[1] = dummyBean.getUI_M_PC_SYS_ID();
			
			resultSet2 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PC_FAC_CLOSE_FLAG, connection, values);
			
			if(resultSet2.next()) {
				dummyBean.setUI_M_FAC_CLOSE_FLAG(resultSet2.getString(1));
			}
			
			if("N".equals(MigratingFunctions.nvl(dummyBean.getUI_M_FAC_CLOSE_FLAG(), "N"))) {
				HtmlCommandButton cb = new HtmlCommandButton();
				if(facOutAction.getCOMP_UI_M_BUT_APPRV()==null){
					cb.setDisabled(false);
					facOutAction.setCOMP_UI_M_BUT_APPRV(cb);
				}else
					facOutAction.getCOMP_UI_M_BUT_APPRV().setDisabled(false);
			} else {
				HtmlCommandButton cb = new HtmlCommandButton();
				if(facOutAction.getCOMP_UI_M_BUT_APPRV()==null){
					cb.setDisabled(true);
					facOutAction.setCOMP_UI_M_BUT_APPRV(cb);
				}else
					facOutAction.getCOMP_UI_M_BUT_APPRV().setDisabled(true);
			}
			
			if("Y".equals(MigratingFunctions.nvl(dummyBean.getUI_M_FAC_CLOSE_FLAG(), "N"))) {
				//TODO mode change for different blocks
			}
			
			if("Y".equals(dummyBean.getUI_M_FACIN_YN())) {
				compositeAction.getPILT009_PT_IL_FAC_PART_CUST_ACTION().getCOMP_FPCU_RETRO_YN().setDisabled(true);
			}
			
			if("Y".equals(dummyBean.getUI_M_PREM_TYPE())) {
				//TODO mode change for different blocks
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
		}
	}
	
	public void fetchRecord(PILT009_COMPOSITE_ACTION compositeAction) throws Exception {
		
		
		PT_IL_FAC_OUT_ACTION facOutAction = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION();
		
		facOutAction.setDataListPT_IL_FAC_OUT(EXECUTE_QUERY(facOutAction.getDUMMY_BEAN()));
		
			for(PT_IL_FAC_OUT facOutBean : facOutAction.getDataListPT_IL_FAC_OUT()) {
				PT_IL_FAC_OUT_POST_QUERY(facOutBean);
		}
			if (facOutAction.getDataListPT_IL_FAC_OUT().size() > 0) {
				facOutAction.setPT_IL_FAC_OUT_BEAN(facOutAction.getDataListPT_IL_FAC_OUT().get(0));
				facOutAction.getPT_IL_FAC_OUT_BEAN().setRowSelected(true);
			}
	}
	
	public List<PT_IL_FAC_OUT> EXECUTE_QUERY(DUMMY dummyBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		
		PT_IL_FAC_OUT facOutBean = null;
		List<PT_IL_FAC_OUT> list = null;
		try {
			connection = CommonUtils.getConnection();
			String statment ="SELECT PT_IL_FAC_OUT.ROWID, PT_IL_FAC_OUT.* FROM PT_IL_FAC_OUT, PT_IL_POLICY WHERE POL_SYS_ID = FO_POL_SYS_ID AND FO_PC_SYS_ID=? AND POL_NO = ?";
			values = new Object[1];
			values[0] = dummyBean.getUI_M_POL_NO();
			if("PILT003".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALLING_FORM"))){
				if(CommonUtils.getGlobalVariable("GLOBAL.M_PC_SYS_ID")!=null){
					resultSet = handler.executeSelectStatement(statment, connection, new Object[]{ Long.valueOf(CommonUtils.getGlobalVariable("GLOBAL.M_PC_SYS_ID")),
										dummyBean.getUI_M_POL_NO()});
				}
			}else{
				resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_FAC_OUT, connection, values);
			}
			
			list = new ArrayList<PT_IL_FAC_OUT>();

			while(resultSet.next()) {
				facOutBean = new PT_IL_FAC_OUT();
				
				facOutBean.setROWID(resultSet.getString(1));
				facOutBean.setFO_SYS_ID(resultSet.getDouble(2));
				facOutBean.setFO_POL_SYS_ID(resultSet.getDouble(3));
				facOutBean.setFO_COVER_SYS_ID(resultSet.getDouble(4));
				facOutBean.setFO_COVER_CODE(resultSet.getString(5));
				facOutBean.setFO_COVER_TYPE(resultSet.getString(6));
				facOutBean.setFO_SA_CURR_CODE(resultSet.getString(7));
				facOutBean.setFO_FAC_PERC(resultSet.getDouble(8));
				facOutBean.setFO_FC_FAC_SI(resultSet.getDouble(9));
				facOutBean.setFO_LC_FAC_SI(resultSet.getDouble(10));
				facOutBean.setFO_DEL_FLAG(resultSet.getString(11));
				facOutBean.setFO_CR_DT(resultSet.getDate(12));
				facOutBean.setFO_CR_UID(resultSet.getString(13));
				facOutBean.setFO_UPD_DT(resultSet.getDate(14));
				facOutBean.setFO_UPD_UID(resultSet.getString(15));
				facOutBean.setFO_ASSR_CODE(resultSet.getString(16));
				facOutBean.setFO_PC_SYS_ID(resultSet.getDouble(17));
				facOutBean.setFO_AC_CLOSE_YN(resultSet.getString(18));
				facOutBean.setRowSelected(false);
				
				list.add(facOutBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return list;
	}
	
	public void PT_IL_FAC_OUT_WHEN_NEW_BLOCK_INSTANCE(PT_IL_FAC_OUT_ACTION facOutAction) throws Exception {
		
		CommonUtils commonUtils = new CommonUtils();
		
		PILT009_COMPOSITE_ACTION compositeAction =null;
		compositeAction=(PILT009_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		
		if("PILT010".equals(compositeAction.getCALLING_FORM())) {
			fetchRecord(compositeAction);
		} else {
			if(!facOutAction.isPreFormFlag()){
				new PILT009_PROCEDURE().L_UPD_DEL_FLAG();
				new PILT009_PROCEDURE().L_INSERT_FAC_OUT_RISK();
				fetchRecord(compositeAction);
			}
		}
	}
	
	public void PT_IL_FAC_OUT_WHEN_NEW_RECORD_INSTANCE(PT_IL_FAC_OUT facOutBean) throws Exception {
		
		String M_TEMP = null;
		String M_FAC_YN = null;
		String M_COINS_YN = null;
		
		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Object[] values = null;
		ArrayList<String> valueList = null;
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		PT_IL_FAC_OUT_ACTION facOutAction = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION();
		DUMMY dummyBean = facOutAction.getDUMMY_BEAN();
		
		try {
			connection = CommonUtils.getConnection();
			
			L_POPULATE_DUMMY(facOutAction);
			
			//TODO match with FMB
			
			if(facOutAction.getPT_IL_FAC_OUT_BEAN()==null) {
				
				facOutAction.getCOMP_UI_M_BUT_DUPLICATE().setDisabled(true);
			} else {
				
				values = new Object[1];
				values[0] = facOutBean.getFO_SYS_ID();
				
				resultSet1 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.CHECK_PT_IL_FAC_PART_CUST, connection, values);
				
				if(resultSet1.next()) {
					M_TEMP = resultSet1.getString(1);
					
					facOutAction.getCOMP_UI_M_BUT_DUPLICATE().setDisabled(true);
				} else {
					
					if(!"PT006".equals(compositeAction.getCALLING_FORM())) {
						
						facOutAction.getCOMP_UI_M_BUT_DUPLICATE().setDisabled(false);
					} else {
						
						facOutAction.getCOMP_UI_M_BUT_DUPLICATE().setDisabled(true);
					}
				}
			}
			
			values = new Object[1];
			values[0] = facOutBean.getFO_POL_SYS_ID();
			
			resultSet2 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_POLICY2, connection, values);
			
			if(resultSet2.next()) {
				
				M_FAC_YN = resultSet2.getString(1);
				M_COINS_YN = resultSet2.getString(2);
				dummyBean.setUI_M_SI_CURR_RATE(resultSet2.getDouble(3));
				dummyBean.setUI_M_POL_CUST_CURR_CODE(resultSet2.getString(4));
				dummyBean.setUI_M_POL_CUST_CURR_RATE(resultSet2.getDouble(5));
				
			}
			
			if("Y".equals(MigratingFunctions.nvl(M_FAC_YN, "N"))
					&& (MigratingFunctions.nvl(facOutBean.getFO_LC_FAC_SI(), 0) != 0)
						|| "Y".equals(dummyBean.getUI_M_FAC_CLOSE_FLAG())) {
				
				facOutAction.getCOMP_UI_M_BUT_PART_CUST().setDisabled(false);
				//compositeAction.getTabbedBar().setTabEnabled(PILT009_COMPOSITE_ACTION.TAB_PT_IL_FAC_PART_CUST);
			} else {
				
				facOutAction.getCOMP_UI_M_BUT_PART_CUST().setDisabled(true);
				//compositeAction.getTabbedBar().setTabDisabled(PILT009_COMPOSITE_ACTION.TAB_PT_IL_FAC_PART_CUST);
			}
			
			valueList = procedures.helperP_VAL_CURR(
					facOutBean.getFO_SA_CURR_CODE(),
					facOutBean.getUI_M_FO_SI_CURR_CODE_DESC(),
					"S", "N", null);
			
			if(valueList != null && valueList.size() > 0) {
				facOutBean.setUI_M_FO_SI_CURR_CODE_DESC(valueList.get(0));
			}
			
			valueList = procedures.helperP_VAL_CURR(
					facOutBean.getUI_M_POL_CUST_CURR_CODE(),
					facOutBean.getUI_M_POL_CUST_CURR_DESC(),
					"S", "N", null);
			
			if(valueList != null && valueList.size() > 0) {
				facOutBean.setUI_M_POL_CUST_CURR_DESC(valueList.get(0));
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, FacesContext.getCurrentInstance(),
					"PILT009", facOutAction.getErrorMap());
		} finally {
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
		}
	}
	
	private void PT_IL_FAC_OUT_POST_QUERY(PT_IL_FAC_OUT facOutBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Object[] values = null;
		ArrayList<String> valueList = null;
		CRUDHandler handler = new CRUDHandler();
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		DUMMY dummyBean = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION().getDUMMY_BEAN();
		
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = facOutBean.getFO_ASSR_CODE();
			
			resultSet1 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_POAD_ASSURED_NAME, connection, values);
			
			if(resultSet1.next()) {
				facOutBean.setUI_M_ASSR_NAME(resultSet1.getString(1));
			}
			
			values = new Object[1];
			values[0] = facOutBean.getFO_PC_SYS_ID();
			
			resultSet2 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PC_DOC_NO, connection, values);
			
			if(resultSet2.next()) {
				dummyBean.setUI_M_DOC_NO(resultSet2.getString(1));
			}
			
			valueList = procedures.callP_VAL_COVER_PROC(
					facOutBean.getFO_COVER_CODE(),
					facOutBean.getUI_M_COVER_DESC(),
					facOutBean.getFO_COVER_TYPE(),
					"N", "N");
			
			if(valueList != null && valueList.size() > 0) {
				facOutBean.setUI_M_COVER_DESC(valueList.get(0));
			}
			
			valueList = procedures.helperP_VAL_CURR(
					facOutBean.getFO_SA_CURR_CODE(),
					facOutBean.getUI_M_SI_CURR_DESC(),
					"N", "N", null);
			
			if(valueList != null && valueList.size() > 0) {
				facOutBean.setUI_M_SI_CURR_DESC(valueList.get(0));
			}
			
			if("Y".equals(MigratingFunctions.nvl(dummyBean.getUI_M_POL_CQS_YN(), "N"))) {
				facOutBean.setUI_M_FO_CQS_SI((MigratingFunctions.nvl(facOutBean.getFO_FC_FAC_SI(), 0) * MigratingFunctions.nvl(dummyBean.getUI_M_POL_CQS_PERC(), 0)) / 100);
			}
			
			//TODO call when validate FO_FAC_PERC
			FO_FAC_PERC_WHEN_VALIDATE_ITEM(facOutBean);
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, FacesContext.getCurrentInstance(),
					"PILT009", compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION().getErrorMap());
		} finally {
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
		}
	}
	
	public void FO_FAC_PERC_WHEN_VALIDATE_ITEM(PT_IL_FAC_OUT pt_il_fac_out) throws Exception {

		String M_FAC_YN = null;
		String M_FACIN_YN = null;
		int M_FD_YEAR = 0;
		int M_FD_AGE = 0;
		Double M_FD_FC_SA = null;
		Double M_FD_LC_SA = null;
		Double M_FD_FC_PREM = null;
		Double M_FD_LC_PREM = null;
		Double M_FD_SYS_ID = null;
		Double M_FD_TAR_RATE = null;
		Double M_FD_TAR_RATE_PER = null;
		Double M_FC_FAC_SA = null;
		Double M_LC_FAC_SA = null;
		Double M_FC_FAC_PREM = null;
		Double M_LC_FAC_PREM = null;
		
		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();

		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		PT_IL_FAC_OUT_ACTION facOutAction = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION();
		DUMMY dummyBean = facOutAction.getDUMMY_BEAN();
		PT_IL_FAC_OUT facOutBean = pt_il_fac_out;

		try {
			connection = CommonUtils.getConnection();

		//	if(rowIndex == 0) {
				facOutAction.getCOMP_UI_M_BUT_DUPLICATE().setDisabled(true);
			//} else {
				//facOutAction.getCOMP_UI_M_BUT_DUPLICATE().setDisabled(true);
			//}
			
			values = new Object[1];
			values[0] = facOutBean.getFO_POL_SYS_ID();
			
			resultSet1 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_POLICY3, connection, values);
			
			if(resultSet1.next()) {
				M_FAC_YN = resultSet1.getString(1);
				M_FACIN_YN = resultSet1.getString(2);
			}
			
			if("N".equals(M_FAC_YN)) {
				facOutAction.getCOMP_UI_M_BUT_PART_CUST().setDisabled(true);
				//compositeAction.getTabbedBar().setTabDisabled(PILT009_COMPOSITE_ACTION.TAB_PT_IL_FAC_PART_CUST);
			} else {
				facOutAction.getCOMP_UI_M_BUT_PART_CUST().setDisabled(false);
				//compositeAction.getTabbedBar().setTabEnabled(PILT009_COMPOSITE_ACTION.TAB_PT_IL_FAC_PART_CUST);
			}
			
			values = new Object[2];
			values[0] = facOutBean.getFO_POL_SYS_ID();
			values[1] = facOutBean.getFO_POL_SYS_ID();
			
			resultSet2 = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_FAC_DETL1, connection, values);
			
			if(resultSet2.next()) {
				M_FD_YEAR = resultSet2.getInt(1);
				M_FD_AGE = resultSet2.getInt(2);
				M_FD_FC_SA = resultSet2.getDouble(3);
				M_FD_LC_SA = resultSet2.getDouble(4);
				M_FD_FC_PREM = resultSet2.getDouble(5);
				M_FD_LC_PREM = resultSet2.getDouble(6);
				M_FD_SYS_ID = resultSet2.getDouble(7);
				M_FD_TAR_RATE = resultSet2.getDouble(8);
				M_FD_TAR_RATE_PER = resultSet2.getDouble(9);
			}
			
			if("Y".equals(MigratingFunctions.nvl(dummyBean.getUI_M_POL_CQS_YN(), "N"))) {
				facOutBean.setUI_M_FO_CQS_SI((MigratingFunctions.nvl(M_FD_FC_SA, 0) * MigratingFunctions.nvl(dummyBean.getUI_M_POL_CQS_PERC(), 0)) / 100);
				M_FD_FC_SA = MigratingFunctions.nvl(M_FD_FC_SA, 0);
			}
			
			M_FC_FAC_SA = CommonUtils.roundDouble((MigratingFunctions.nvl(M_FD_FC_SA, 0) * MigratingFunctions.nvl(facOutBean.getFO_FAC_PERC(), 0)) / 100);
			M_LC_FAC_SA = M_FC_FAC_SA * MigratingFunctions.nvl(dummyBean.getUI_M_SI_CURR_RATE(), 0);
			
			if(facOutBean.getFO_SA_CURR_CODE() != null 
					&& facOutBean.getFO_SA_CURR_CODE().equals(dummyBean.getUI_M_POL_CUST_CURR_CODE())) {
				
				M_FC_FAC_PREM = MigratingFunctions.nvl(M_FC_FAC_SA, 0) * MigratingFunctions.nvl(M_FD_TAR_RATE, 0) / MigratingFunctions.nvl(M_FD_TAR_RATE_PER, 1);
				M_LC_FAC_PREM = MigratingFunctions.nvl(M_FC_FAC_PREM, 0) * MigratingFunctions.nvl(dummyBean.getUI_M_POL_CUST_CURR_RATE(), 0);
			} else {
				
				M_LC_FAC_PREM = MigratingFunctions.nvl(M_LC_FAC_SA, 0) * MigratingFunctions.nvl(M_FD_TAR_RATE, 0) / MigratingFunctions.nvl(M_FD_TAR_RATE_PER, 1);
				M_FC_FAC_PREM = MigratingFunctions.nvl(M_LC_FAC_PREM, 0) / MigratingFunctions.nvl(dummyBean.getUI_M_POL_CUST_CURR_RATE(), 1);
			}
		
			values = new Object[8];
			values[0] = M_FC_FAC_SA;
			values[1] = M_LC_FAC_SA;
			values[2] = M_FC_FAC_PREM;
			values[3] = M_LC_FAC_PREM;
			values[4] = M_FC_FAC_PREM;
			values[5] = M_LC_FAC_PREM;
			values[6] = facOutBean.getFO_SYS_ID();
			values[7] = M_FD_YEAR;
			
			handler.executeUpdateStatement(PILT009_SQL_CONSTANTS.UPDATE_PT_IL_FAC_DETL, connection, values);
			//TODO call L_FAC_INS_LOAD proc
			
			
		
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
		}
	}
	
	public void PT_IL_FAC_OUT_PRE_INSERT(PT_IL_FAC_OUT facOutBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		
		facOutBean.setFO_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		facOutBean.setFO_CR_DT(commonUtils.getCurrentDate());
		
		try {
			connection = CommonUtils.getConnection();
			
			resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PIL_FO_SYS_ID, connection);
			
			if(resultSet.next()) {
				facOutBean.setFO_SYS_ID(resultSet.getDouble(1));
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public void PT_IL_FAC_OUT_PRE_UPDATE(PT_IL_FAC_OUT facOutBean) {
		
		CommonUtils commonUtils = new CommonUtils();
		
		try {
			facOutBean.setFO_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			facOutBean.setFO_UPD_DT(commonUtils.getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public int updateData(PT_IL_FAC_OUT PT_IL_FAC_OUT_BEAN) throws Exception {

		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();

			rowUpdated = handler.executeInsert(PT_IL_FAC_OUT_BEAN, connection);

		} catch (Exception exc) {
			exc.printStackTrace();
			throw exc;
		}
		return rowUpdated;
	}
	
	public String approveButton() throws Exception {
		Double M_FO_SYS_ID = null;
		Double M_TOT_FPCU_FAC_PERC = 0.0;
		Double M_FPCU_SHARE_PERC = 0.0;
		Double M_FPCU_RETRO_SHARE_PERC = 0.0;
		String PARAM_NAME = null;
		String PARAM_ID = null;
		String M_POL_ENDT_CODE =null;
		
		String sql_C2 = "SELECT FO_FAC_PERC,FO_SYS_ID,FO_COVER_CODE " +
				"FROM   PT_IL_FAC_OUT " +
				"WHERE  FO_POL_SYS_ID = ?";
		String sql_C3 = "SELECT NVL(FPCU_SHARE_PERC,0),NVL(FPCU_RETRO_SHARE_PERC,0) " +
				"FROM   PT_IL_FAC_PART_CUST " +
				"WHERE  FPCU_FO_SYS_ID = ?";      
		   /*IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
		      STD_MESSAGE_ROUTINE(71165,:CTRL.M_LANG_CODE);      
		      RAISE FORM_TRIGGER_FAILURE ;
		   END IF;*/
		
		//ADDED BY SIVARAM FOR FSD-25
		String M_PC_PREM_TYPE       = null;
		String M_POL_PROD_CODE      = null;
		String M_ESD_CHAR_VALUE     = null;
		String M_ASD_CHAR_VALUE		=null;
		Integer endidx=0;
		String C4 ="SELECT PC_PREM_TYPE FROM PT_IL_PREM_COLL " +
				"WHERE PC_SYS_ID = ?";

		String C5 =" SELECT POL_PROD_CODE,POL_END_NO_IDX,POL_END_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";

		String C6 =" SELECT ESD_CHAR_VALUE FROM   PM_IL_END_SETUP_DET WHERE  ESD_USER_ID = :CTRL.M_USER_ID " +
				"AND    ESD_CODE = 'FAC_RI_YN' AND    M_POL_PROD_CODE BETWEEN NVL(ESD_FM_PROD_CODE,'0') AND NVL(ESD_TO_PROD_CODE,'zzzzzzzzzzzz')";    
		String C7 ="SELECT ASD_CHAR_VALUE "
			+ "FROM   PM_IL_APPR_SETUP_DET " 
			+ "WHERE  ASD_CODE = 'FAC_RI_YN' "   
			+ "AND    ASD_USER_ID = ? "
			+ "AND    ? BETWEEN NVL(ASD_FM_PROD_CODE,0) AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";

		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		PT_IL_FAC_OUT_ACTION facOutAction = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION();
		DUMMY dummyBean = facOutAction.getDUMMY_BEAN();
		Long M_FO_POL_SYS_ID = dummyBean.getUI_M_FO_POL_SYS_ID();
		Long M_PC_SYS_ID = dummyBean.getUI_M_PC_SYS_ID();
		String M_POL_NO = dummyBean.getUI_M_POL_NO();
		
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst_C2 = null;
		ResultSet rst_C3 = null;
		ResultSet rst_C4 = null;
		ResultSet rst_C5 = null;
		ResultSet rst_C7 = null;
		try {
			connection = CommonUtils.getConnection();
			
			rst_C4 = handler.executeSelectStatement(C4, connection, new Object[]{dummyBean.getUI_M_PC_SYS_ID()});
			while(rst_C4.next()){
				M_PC_PREM_TYPE = rst_C4.getString(1);
			}
		 
			
				rst_C5 = handler.executeSelectStatement(C5, connection, new Object[]{facOutAction.getPT_IL_FAC_OUT_BEAN().getFO_POL_SYS_ID()});
				while(rst_C5.next()){
					M_POL_PROD_CODE = rst_C5.getString(1);
					endidx=rst_C5.getInt(2);
					M_POL_ENDT_CODE=rst_C5.getString(3);
				}
			if(endidx>0){
				M_ESD_CHAR_VALUE = 	P_VAL_ENDT_FAC_APPROVAL(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),"FAC_RI_YN",M_POL_PROD_CODE,M_POL_ENDT_CODE,"2",M_ESD_CHAR_VALUE);
		 	 
				if("N".equalsIgnoreCase(CommonUtils.nvl(M_ESD_CHAR_VALUE,"N")))
		 		 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91498",new Object[]{"approve FAC"}));
			}else{
				rst_C7 = handler.executeSelectStatement(C7, connection, new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),M_POL_PROD_CODE});
				while(rst_C7.next()){
					M_ASD_CHAR_VALUE = rst_C7.getString(1);
				}
				if("N".equalsIgnoreCase(CommonUtils.nvl(M_ASD_CHAR_VALUE,"N")))
			 		 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91498",new Object[]{"approve FAC"}));
			}
		 //END OF ADDITION BY SIVARAM
		 	 
/*	   IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
	      STD_MESSAGE_ROUTINE(71165,:CTRL.M_LANG_CODE);      
	      RAISE FORM_TRIGGER_FAILURE ;
	   END IF;*/
			
			rst_C2 = handler.executeSelectStatement(sql_C2, connection, new Object[]{M_FO_POL_SYS_ID});
			Double FO_FAC_PERC = 0.0;
			String FO_COVER_CODE = null;
			while(rst_C2.next()){
				FO_FAC_PERC += rst_C2.getDouble(1);
				M_FO_SYS_ID = rst_C2.getDouble(2);
				FO_COVER_CODE = rst_C2.getString(3);
				
				rst_C3 = handler.executeSelectStatement(sql_C3, connection, new Object[]{M_FO_SYS_ID});
				while(rst_C3.next()){
					M_FPCU_SHARE_PERC = rst_C3.getDouble(1);
					M_FPCU_RETRO_SHARE_PERC = rst_C3.getDouble(2);
					
					M_TOT_FPCU_FAC_PERC += M_FPCU_SHARE_PERC+M_FPCU_RETRO_SHARE_PERC;
				}
				DecimalFormat df = new DecimalFormat("#.###");
				Double val= Double.valueOf(df.format(M_TOT_FPCU_FAC_PERC));
				Double val1 = Double.valueOf(df.format(FO_FAC_PERC));
				
				if(! val.equals(val1)){
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "71152", new Object[]{FO_COVER_CODE, FO_FAC_PERC, M_TOT_FPCU_FAC_PERC}));
				}
				
				/*if(M_TOT_FPCU_FAC_PERC!=FO_FAC_PERC){
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "71152", new Object[]{FO_COVER_CODE, FO_FAC_PERC, M_TOT_FPCU_FAC_PERC}));
				}*/
			}
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", M_POL_NO);
			CommonUtils.setGlobalObject("GLOBAL.M_PC_SYS_ID",M_PC_SYS_ID);
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT009");
			
			PT_IL_POLICY_ACTION policyAction = (PT_IL_POLICY_ACTION) sessionMap.get("PILP005_PT_IL_POLICY_ACTION");
			if(policyAction!=null){
				policyAction.setOnLoadFlag(false);
				policyAction.setPreFormFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst_C2);
				CommonUtils.closeCursor(rst_C3);
				CommonUtils.closeCursor(rst_C7);
			}catch(Exception e){
			}
		}
		return "PILP005";
	}
	
	private String P_VAL_ENDT_FAC_APPROVAL(String P_USER_ID, String P_CODE,
			String P_PROD_CODE,String M_POL_ENDT_CODE,String P_FLAG, String P_VALUE) throws Exception{
		// TODO Auto-generated method stub
			String C0=" SELECT ESD_CHAR_VALUE FROM   PM_IL_END_SETUP_DET " +
					"WHERE  ESD_USER_ID = ? AND    ESD_CODE    = ? " +
					"AND    ? BETWEEN NVL(ESD_FM_PROD_CODE,'0') AND NVL(ESD_TO_PROD_CODE,'zzzzzzzzzzzz')";
			
			
			/*Modified by Janani on 22.06.2017 for ZBILQC-1721216*/
			
			/*String C1 =" SELECT ESD_CHAR_VALUE FROM PM_IL_END_APPR_SETUP, PM_IL_END_SETUP_DET "+
					" WHERE EAS_AS_USER_ID = ?  AND  ? BETWEEN NVL(EAS_AS_FM_PROD_CODE, '0') AND "+
	            " NVL(EAS_AS_TO_PROD_CODE, 'ZZZZZZZZZZZ')AND ? BETWEEN NVL(EAS_FM_END_CODE ,'0' )AND NVL(EAS_TO_END_CODE,''ZZZZZZZZZZZ') AND ESD_EAS_SYS_ID = EAS_SYS_ID AND ESD_CODE =?";*/
			
			String C1 =" SELECT ESD_CHAR_VALUE FROM PM_IL_END_APPR_SETUP, PM_IL_END_SETUP_DET "+
					" WHERE EAS_AS_USER_ID = ?  AND  ? BETWEEN NVL(EAS_AS_FM_PROD_CODE, '0') AND "+
	            " NVL(EAS_AS_TO_PROD_CODE, 'ZZZZZZZZZZZ') AND ? BETWEEN NVL(EAS_FM_END_CODE ,'0' )AND NVL(EAS_TO_END_CODE,'ZZZZZZZZZZZ') AND ESD_EAS_SYS_ID = EAS_SYS_ID AND ESD_CODE =?";
			
			
			/*End*/
			
			String M_ESD_CHAR_VALUE  = null;
			Connection con = null;
			ResultSet rs = null;
			try{
				con = CommonUtils.getConnection();
				/*Modified by ganesh on 02-02-2018 to avoid missing parenthesis issue*/
				//rs = handler.executeSelectStatement(C1, con, new Object[]{P_USER_ID,P_PROD_CODE,P_CODE});
				rs = handler.executeSelectStatement(C1, con, new Object[]{P_USER_ID,P_PROD_CODE, M_POL_ENDT_CODE, P_CODE});
				/*end*/
				if(rs.next())
					M_ESD_CHAR_VALUE = rs.getString(1);
				else
					throw new Exception (Messages.getString(PELConstants.pelErrorMessagePath, "69009", new Object[]{"Endorsement Approval Setup"}));
			
				P_VALUE = M_ESD_CHAR_VALUE;
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
			
				return P_VALUE; 
	}

	public void afterApproveButton() throws Exception {
		String M_FAC_CLOSE_FLAG = null;
		String sql_C1 = "SELECT PC_FAC_CLOSE_FLAG " +
				"FROM   PT_IL_PREM_COLL " +
				"WHERE  PC_SYS_ID    = ?";
		Connection connection = null;
		ResultSet rst_C1 = null;
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		PT_IL_FAC_OUT_ACTION facOutAction = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION();
		DUMMY dummyBean = facOutAction.getDUMMY_BEAN();
		Long M_PC_SYS_ID = dummyBean.getUI_M_PC_SYS_ID();
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{M_PC_SYS_ID});
			while(rst_C1.next()){
				M_FAC_CLOSE_FLAG = rst_C1.getString(1);
			}
			
			if((M_FAC_CLOSE_FLAG==null?"N":M_FAC_CLOSE_FLAG).equals("Y")){
				if(facOutAction.getCOMP_UI_M_BUT_APPRV()!=null){
					facOutAction.getCOMP_UI_M_BUT_APPRV().setDisabled(true);
				}else{
					HtmlCommandButton cb = new HtmlCommandButton();
					cb.setDisabled(true);
					facOutAction.setCOMP_UI_M_BUT_APPRV(cb);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst_C1);
			}catch(Exception e){
			}
		}
	}
	
	public void keyCommit() throws Exception {
		String M_FIELD_NAME=null;
		int M_CHOICE=0;
		String M_MESSAGE=null;
		String M_POL_PROD_CODE=null;
		String M_POL_PLAN_CODE=null;
		String M_POL_DIVN_CODE=null;
		String M_POL_CLASS_CODE=null;		
		int M_POL_UW_YEAR=0;			

		String M_DUMMY=null; 
		String M_DUMMY1=null; 
		Date M_PC_SCHD_PYMT_DT = null;
		String M_PC_DOC_NO = null;
		
		String sql_C2 = "SELECT 'X',PC_SCHD_PYMT_DT,PC_DOC_NO " +
				"FROM PT_IL_PREM_COLL " +
				"WHERE PC_SYS_ID=?";
		String sql_C6 = "SELECT POL_DIVN_CODE, POL_CLASS_CODE, POL_PLAN_CODE, POL_PROD_CODE, POL_UW_YEAR " +
				"FROM PT_IL_POLICY " +
				"WHERE POL_SYS_ID =?";
		String sql_C3 = "SELECT 'X' " +
				"FROM PT_IL_PREM_COLL " +
				"WHERE PC_SYS_ID<>? " +
				"AND PC_DOC_NO=?";
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		PT_IL_FAC_OUT_ACTION facOutAction = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION();
		DUMMY dummyBean = facOutAction.getDUMMY_BEAN();
		Long M_FO_POL_SYS_ID = dummyBean.getUI_M_FO_POL_SYS_ID();
		Long M_PC_SYS_ID = dummyBean.getUI_M_PC_SYS_ID();
		String M_POL_NO = dummyBean.getUI_M_POL_NO();
		String M_DOC_NO = dummyBean.getUI_M_DOC_NO();
		String M_PARAM_5 = (String) sessionMap.get("GLOBAL.M_PARAM_5");
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst_C2 = null;
		ResultSet rst_C6 = null;
		ResultSet rst_C3 = null;
		Double FPCUD_SYS_ID = null;
		Double FO_SYS_ID = null;
		String FPCU_CUST_CODE = null;
		Double FO_PC_SYS_ID = null;
		try {
			connection = CommonUtils.getConnection();
			List<PT_IL_FAC_OUT> facOutList = facOutAction.getDataListPT_IL_FAC_OUT();
			if(facOutList!=null && facOutList.size()>0){
				FO_SYS_ID = facOutList.get(0).getFO_SYS_ID();
			}
			List<PT_IL_FAC_PART_CUST> facPartCustList = compositeAction.getPILT009_PT_IL_FAC_PART_CUST_ACTION().getDataListPT_IL_FAC_PART_CUST();
			if(facPartCustList!=null && facPartCustList.size()>0){
				FPCU_CUST_CODE = facPartCustList.get(0).getFPCU_CUST_CODE();
			}
			List<PT_IL_FAC_PART_CUST_DETL> facPartCustDetlList = compositeAction.getPILT009_PT_IL_FAC_PART_CUST_DETL_ACTION().getDataListPT_IL_FAC_PART_CUST_DETL();
			if(facPartCustDetlList!=null && facPartCustDetlList.size()>0){
				for(int i=0;i<facPartCustDetlList.size();i++){
					FPCUD_SYS_ID = facPartCustDetlList.get(i).getFPCUD_SYS_ID();
					try {
						new PILT009_PROCEDURE().P9ILPK_FAC_ALLOC_P_INS_FAC_PART_CHRG(connection, 
								FPCUD_SYS_ID+"", FO_SYS_ID+"", FPCU_CUST_CODE);
					} catch (Exception e) {
						ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), "PILT009", facOutAction.getErrorMap(), facOutAction.getWarningMap());
					}
				}
			}
			
			rst_C2 = handler.executeSelectStatement(sql_C2, connection, new Object[]{FO_PC_SYS_ID});
			while(rst_C2.next()){
				M_DUMMY = rst_C2.getString(1);
				M_PC_SCHD_PYMT_DT = rst_C2.getDate(2);
				M_PC_DOC_NO = rst_C2.getString(3);
			}
			String M_PC_SCHD_PYMT_STR = CommonUtils.dateToStringFormatter(M_PC_SCHD_PYMT_DT);
			if((M_DUMMY==null?"N":M_DUMMY).equals("X")){
				rst_C3 = handler.executeSelectStatement(sql_C3, connection, new Object[]{FO_PC_SYS_ID, M_DOC_NO});
				while(rst_C3.next()){
					M_DUMMY1 = rst_C3.getString(1);
				}
				if((M_DUMMY1==null?"N":M_DUMMY1).equals("X")){
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "3206", new Object[]{"Duplicate Reference No."}));
				}
				if(M_DOC_NO==null){
					rst_C6 = handler.executeSelectStatement(sql_C6, connection, new Object[]{FO_PC_SYS_ID});
					while(rst_C6.next()){
						M_POL_DIVN_CODE = rst_C6.getString(1);
						M_POL_CLASS_CODE = rst_C6.getString(2);
						M_POL_PLAN_CODE = rst_C6.getString(3);
						M_POL_PROD_CODE = rst_C6.getString(4);
						M_POL_UW_YEAR = rst_C6.getInt(5);
					}
					try {
						new DBProcedures().call_PKG_PILT002_P_SET_DOC_NO_PROP("A", M_PARAM_5, M_POL_DIVN_CODE, 
								M_POL_CLASS_CODE, M_POL_PLAN_CODE, 
								M_POL_PROD_CODE, M_POL_UW_YEAR+"", M_DOC_NO, "DUMMY", "Y",
								M_PC_SCHD_PYMT_STR, null, M_PC_SCHD_PYMT_STR, null);
					} catch (Exception e) {
						ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), "PILT009", facOutAction.getErrorMap(), facOutAction.getWarningMap());
					}
				}
				if(M_DOC_NO==null){
					try {
						new DBProcedures().callP_GEN_DOC_NO("A", M_PARAM_5, M_POL_DIVN_CODE, 
								M_POL_CLASS_CODE, M_POL_PLAN_CODE, M_POL_PROD_CODE, M_POL_UW_YEAR+"", 
								M_DOC_NO, "DUMMY", "Y", M_PC_SCHD_PYMT_STR, null, M_PC_SCHD_PYMT_STR, null);
					} catch (Exception e) {
						ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), "PILT009", facOutAction.getErrorMap(), facOutAction.getWarningMap());
					}
				}
				if(M_PC_DOC_NO==null){
					String sql_update1 = "UPDATE PT_IL_PREM_COLL " +
							"SET PC_DOC_NO= ? " +
							"WHERE PC_SYS_ID=?";
					handler.executeUpdateStatement(sql_update1, connection, new Object[]{M_DOC_NO, FO_PC_SYS_ID});
				}
			}
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst_C2);
				CommonUtils.closeCursor(rst_C3);
				CommonUtils.closeCursor(rst_C6);
			}catch(Exception e){
			}
		}
	}
	
	public void clearErrorPanel(){
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		PT_IL_FAC_OUT_ACTION facOutAction = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION();
		facOutAction.getErrorMap().clear();
		facOutAction.getWarningMap().clear();
	}
}

