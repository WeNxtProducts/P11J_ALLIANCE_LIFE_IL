package com.iii.pel.forms.PILP005;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT009.PILT009_PROCEDURE;
import com.iii.pel.forms.PILT010.PILT010_PROCEDURE;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;


public class PILP005_HELPER {
	
	public PT_IL_POLICY_ACTION getPILP005Instance(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		return (PT_IL_POLICY_ACTION) sessionMap.get("PILP005_PT_IL_POLICY_ACTION");
	}
	
	public void whenNewFormInstance() throws Exception {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String FORM_NAME = (String) sessionMap.get("CALLING_FORM");
		String M_SCHD_STR = null;
		String M_PC_PAID_STR = null;
		Date M_PC_PAID_DT = null;
		Date M_SCHD_DT = null;
		Long M_POL_SYS_ID = null;
		Long M_PC_SYS_ID =  (Long)CommonUtils.getGlobalObject("GLOBAL.M_PC_SYS_ID");
		String M_POL_NO = (String) sessionMap.get("GLOBAL.M_POL_NO");
		String sql_C1 = "SELECT PC_SCHD_PYMT_DT,PC_APPRV_DT,PC_POL_SYS_ID " +
				"FROM   PT_IL_PREM_COLL " +
				"WHERE  PC_SYS_ID = ? ";
		Connection connection = null;
		ResultSet rst_C1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{M_PC_SYS_ID});
			while(rst_C1.next()){
				M_SCHD_DT = rst_C1.getDate(1);
				M_SCHD_STR = CommonUtils.dateToStringFormatter(M_SCHD_DT);
				M_PC_PAID_DT = rst_C1.getDate(2);
				M_PC_PAID_STR = CommonUtils.dateToStringFormatter(M_PC_PAID_DT);
				M_POL_SYS_ID = rst_C1.getLong(3);
			}
			getPILP005Instance().getPT_IL_POLICY_BEAN().setUI_M_SCHD_DT(M_SCHD_DT);
			getPILP005Instance().getPT_IL_POLICY_BEAN().setUI_M_PC_PAID_DT(M_PC_PAID_DT);
			getPILP005Instance().getPT_IL_POLICY_BEAN().setUI_M_PC_SYS_ID(M_PC_SYS_ID);
			getPILP005Instance().getPT_IL_POLICY_BEAN().setUI_M_POL_SYS_ID(M_POL_SYS_ID);
			
			if((FORM_NAME==null?"":FORM_NAME).equals("PILP003")){
				getPILP005Instance().getPT_IL_POLICY_BEAN().setPOL_NO(M_POL_NO);
				try {
					new PILT010_PROCEDURE().P9ILPK_RI_ALLOC_P_APPRV_FAC(connection, CommonUtils.getProcedureValue(M_POL_SYS_ID), CommonUtils.getProcedureValue(M_PC_SYS_ID), CommonUtils.getProcedureValue(M_SCHD_STR), "Y", "P");
				} catch (Exception e) {
					ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), "PILP005", getPILP005Instance().getErrorMap(), getPILP005Instance().getWarningMap());
					String errorMessage = getPILP005Instance().getErrorMap().get("current");
					if(errorMessage!=null){
						throw new ValidatorException(new FacesMessage(errorMessage));
					}else{
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
				return;
			}else{
				if((FORM_NAME==null?"":FORM_NAME).equals("PILT009")){
					getPILP005Instance().getPT_IL_POLICY_BEAN().setPOL_NO(M_POL_NO);
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
	
	/**
	 * @author 53058
	 * Feb 16, 2009 5:08:09 PM
	 *
	 *
	 * @throws Exception
	 */
	public void whenNewBlockInstance() throws Exception {
		String sql_C1 = "SELECT POL_SYS_ID " +
				"FROM   PT_IL_POLICY " +
				"WHERE  POL_NO      = ? " +
				"AND    POL_DS_TYPE = '2'";
		String POL_NO = getPILP005Instance().getPT_IL_POLICY_BEAN().getPOL_NO();
		Connection connection = null;
		Long M_POL_SYS_ID = null;
		ResultSet rst_C1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{POL_NO});
			while(rst_C1.next()){
				M_POL_SYS_ID = rst_C1.getLong(1);
			}
			getPILP005Instance().getPT_IL_POLICY_BEAN().setUI_M_POL_SYS_ID(M_POL_SYS_ID);
			if(M_POL_SYS_ID==null){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "71153"));
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
	
	public void POL_NO_WhenNewItemInstance() throws Exception {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String callingForm = (String) sessionMap.get("CALLING_FORM");
		if((callingForm==null?"":callingForm).equals("PILT009")){
			getPILP005Instance().getCOMP_POL_NO().setReadonly(true);
		}
	}
	
	public void POL_NO_WhenValidateItem() throws Exception {
		String M_FAC_CLOSE_FLAG = null;
		String sql_C1 = "SELECT 'X', NVL(POL_FAC_CLOSE_FLAG,'N') " +
				"FROM   PT_IL_POLICY " +
				"WHERE  POL_SYS_ID = ?";
		String POL_NO = getPILP005Instance().getPT_IL_POLICY_BEAN().getPOL_NO();
		Long M_POL_SYS_ID = getPILP005Instance().getPT_IL_POLICY_BEAN().getUI_M_POL_SYS_ID();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String callingForm = (String) sessionMap.get("CALLING_FORM");
		Connection connection = null;
		ResultSet rst_C1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			if(POL_NO==null){
				return;
			}
			connection = CommonUtils.getConnection();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{M_POL_SYS_ID});
			String M_TEMP = null;
			while(rst_C1.next()){
				M_TEMP = rst_C1.getString(1);
				M_FAC_CLOSE_FLAG = rst_C1.getString(2);
			}
			if(M_TEMP==null){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "71161"));
			}
			if((M_FAC_CLOSE_FLAG==null?"N":M_FAC_CLOSE_FLAG).equals("Y") && ((callingForm==null?"":callingForm).equals("PILP003") || (callingForm==null?"":callingForm).equals("PILT009"))){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "71162"));
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
	
	public List<PT_IL_POLICY> getPolicyList(String polNo) throws Exception {
		if(polNo!=null){
			if(polNo.equals("*")){
				polNo = "%";
			}else{
				polNo += "%";
			}
		}
		String sql_C1 = "SELECT POL_NO, POL_ISSUE_DT " +
				"FROM PT_IL_POLICY " +
				"WHERE NVL(POL_APPRV_STATUS,'N') = 'A' " +
				"AND POL_NO IS NOT NULL " +
				"AND POL_DS_TYPE = '2' " +
				"AND POL_NO LIKE NVL(?, POL_NO)";
		ResultSet rst_C1 = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_POLICY> policyList = null;
		try {
			connection = CommonUtils.getConnection();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{polNo});
			policyList = new ArrayList<PT_IL_POLICY>();
			while(rst_C1.next()){
				PT_IL_POLICY policyBean = new PT_IL_POLICY();
				policyBean.setPOL_NO(rst_C1.getString(1));
				policyBean.setPOL_ISSUE_DT(rst_C1.getDate(2));
				policyList.add(policyBean);
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
		return policyList;
	}
	
	public String whenOKButtonPressed() throws Exception {
		String M_POL_DS_TYPE1 = null;
		String M_POL_DS_CODE1 = null;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String sql_C1 = "SELECT POL_END_NO_IDX,NVL(POL_END_TYPE,'000'),POL_END_EFF_FROM_DT,POL_FAC_BASIS " +
				"FROM PT_IL_POLICY " +
				"WHERE POL_SYS_ID = ?";
		
		String sql_C2 = "SELECT POL_DS_TYPE ,POL_DS_CODE " +
				"FROM   PT_IL_POLICY " +
				"WHERE  POL_SYS_ID = ?";
		String sql_C3 = "SELECT DS_POST_BO " +
				"FROM   PM_IL_DOC_SETUP " +
				"WHERE  DS_TYPE  = ? " +
				"AND    DS_CODE  = ?";
		String M_DS_POST_BO = null;
		int M_POL_END_NO_IDX = 0;
		String M_POL_END_TYPE = null;
		Date M_POL_END_EFF_FM_DT = null;
		String M_POL_FAC_BASIS = null;
		Connection connection = null;
		ResultSet rst_C1 = null;
		ResultSet rst_C2 = null;
		ResultSet rst_C3 = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POLICY_ACTION policyAction = getPILP005Instance();
		Long M_POL_SYS_ID = policyAction.getPT_IL_POLICY_BEAN().getUI_M_POL_SYS_ID();
		Long M_PC_SYS_ID = (Long) CommonUtils.getGlobalObject("GLOBAL.M_PC_SYS_ID");
		String callingForm = (String) sessionMap.get("CALLING_FORM");
		String M_FAC_YN = policyAction.getPT_IL_POLICY_BEAN().getPOL_FAC_YN();
		Date M_SCHD_DT = policyAction.getPT_IL_POLICY_BEAN().getUI_M_SCHD_DT();
		try {
			String M_SCHD_STR = CommonUtils.dateToStringFormatter(M_SCHD_DT);
			connection = CommonUtils.getConnection();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{M_POL_SYS_ID});
			while(rst_C1.next()){
				M_POL_END_NO_IDX  = rst_C1.getInt(1);
				M_POL_END_TYPE = rst_C1.getString(2);
				M_POL_END_EFF_FM_DT = rst_C1.getDate(3);
				M_POL_FAC_BASIS = rst_C1.getString(4);
			}
			
			rst_C2 = handler.executeSelectStatement(sql_C2, connection, new Object[]{M_POL_SYS_ID});
			while(rst_C1.next()){
				M_POL_DS_TYPE1  = rst_C1.getString(1);
				M_POL_DS_CODE1 = rst_C1.getString(2);
			}
			
			rst_C3 = handler.executeSelectStatement(sql_C3, connection, new Object[]{M_POL_DS_TYPE1, M_POL_DS_CODE1});
			while(rst_C1.next()){
				M_DS_POST_BO  = rst_C1.getString(1);
			}
			
			if(M_POL_END_NO_IDX==0 || !(M_POL_END_TYPE==null?"":M_POL_END_TYPE).equals("002")){
				try {
					new PILT009_PROCEDURE().P9ILPK_RI_ALLOC_P_APPRV_FAC(connection, CommonUtils.getProcedureValue(M_POL_SYS_ID), CommonUtils.getProcedureValue(M_PC_SYS_ID), CommonUtils.getProcedureValue(M_SCHD_STR), CommonUtils.getProcedureValue(M_FAC_YN), "P");
				} catch (Exception e) {
					ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), "PILP005", policyAction.getErrorMap(), policyAction.getWarningMap());
					String errorMessage = policyAction.getErrorMap().get("current");
					if(errorMessage!=null){
						throw new ValidatorException(new FacesMessage(errorMessage));
					}else {
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			} else if((M_POL_END_TYPE==null?"":M_POL_END_TYPE).equals("002")){
				String M_POL_END_EFF_FM_STR = CommonUtils.dateToStringFormatter(M_POL_END_EFF_FM_DT);
				if("A".equalsIgnoreCase(CommonUtils.nvl( M_POL_FAC_BASIS,"N"))){
				try {
					if(M_SCHD_DT.equals(M_POL_END_EFF_FM_DT)){
					new DBProcedures().P9ILPK_RI_ALLOC_P_RI_REALLOCATION(connection, CommonUtils.getProcedureValue(M_POL_SYS_ID), CommonUtils.getProcedureValue(M_POL_END_EFF_FM_STR));
					}
					else{
						new PILT009_PROCEDURE().P9ILPK_RI_ALLOC_P_APPRV_FAC(connection, CommonUtils.getProcedureValue(M_POL_SYS_ID), CommonUtils.getProcedureValue(M_PC_SYS_ID), CommonUtils.getProcedureValue(M_SCHD_STR), CommonUtils.getProcedureValue(M_FAC_YN), "P");
					}
				} catch (Exception e) {
					ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), "PILP005", policyAction.getErrorMap(), policyAction.getWarningMap());
					String errorMessage = policyAction.getErrorMap().get("current");
					if(errorMessage!=null){
						throw new ValidatorException(new FacesMessage(errorMessage));
					}else {
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
				}else if("B".equalsIgnoreCase(CommonUtils.nvl( M_POL_FAC_BASIS,"N"))){
					try {
						new PILT009_PROCEDURE().P9ILPK_RI_ALLOC_P_APPRV_FAC(connection, CommonUtils.getProcedureValue(M_POL_SYS_ID), CommonUtils.getProcedureValue(M_PC_SYS_ID), CommonUtils.getProcedureValue(M_SCHD_STR), CommonUtils.getProcedureValue(M_FAC_YN), "P");
					} catch (Exception e) {
						ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), "PILP005", policyAction.getErrorMap(), policyAction.getWarningMap());
						String errorMessage = policyAction.getErrorMap().get("current");
						if(errorMessage!=null){
							throw new ValidatorException(new FacesMessage(errorMessage));
						}else {
							throw new ValidatorException(new FacesMessage(e.getMessage()));
						}
					}
					
				}
			}
			connection.commit();
			
			if((M_DS_POST_BO==null?"":M_DS_POST_BO).equals("O")){
				sessionMap.put("GLOBAL.M_POL_SYS_ID",M_POL_SYS_ID);
				sessionMap.put("GLOBAL.M_CLM_SYS_ID", 0.0);
				return "PILP010";
			}
			getPILP005Instance().getWarningMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "71172"));
			if((callingForm==null?"":callingForm).equals("PILT009")){
				return "PILT009";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst_C1);
				CommonUtils.closeCursor(rst_C2);
				CommonUtils.closeCursor(rst_C3);
			}catch(Exception e){
			}
		}
		return null;
	}

}
