package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.login.util.PropertyManager;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.MigratingFunctions;


@Deprecated
public class PILT006_APAC_HELPER {

	Map<String, Object> session = null;
	ControlBean ctrlBean = null;
	FacesContext ctx = null;

	public PILT006_APAC_HELPER() {
		ctx = FacesContext.getCurrentInstance();
	}

	/*public void createCtrlBean() {
		ControlBean bean = new ControlBean();
		session = ctx.getExternalContext().getSessionMap();
		session.put("ctrlbean", bean);
	}*/

	public ControlBean getCtrlBean() {
		/*session = ctx.getExternalContext().getSessionMap();
		return (ControlBean) session.get("ctrlbean");*/
		
		return CommonUtils.getControlBean();
	}

	Connection connection = null;

	public Connection getConnection() throws Exception {
		/*ServletContext context = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		Connection connection = ((SimpleConnectionAgent) context
				.getAttribute("connectionAgent")).getConnection("123456");*/

		Connection connection = CommonUtils.getConnection();
		return connection;
	}

	public void pilt006_apac_pt_il_claim_cover_dtls_ccd_cover_code_when_validate_item()
			throws SQLException, Exception {
		// Connection vembu_conn =
		// SwisSqlConnection.getInstance().getConnection();
		Connection connection = null;
		PT_IL_CLAIM PT_IL_CLAIM_BEAN = null;
		PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN = null;
		PT_IL_CLAIM_COVER_DTLS_ACTION CLAIM_COVER_DTLS_ACTION = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = getConnection();
			// final dbms_output dbms_output1=new dbms_output();
			String /** METADATA NOT FOUND ******** */
			M_POL_SYS_ID = null;
			String /** METADATA NOT FOUND ******** */
			M_COVER_CLASS = null;
			String /** METADATA NOT FOUND ******** */
			M_POAC_MED_DAYS = null;
			String /** METADATA NOT FOUND ******** */
			M_CCD_NO_OF_DAYS = null;

			String claimSysId = "SELECT CLAIM_POL_SYS_ID FROM PT_IL_CLAIM WHERE CLAIM_PCI_REF_NO='"
					+ PT_IL_CLAIM_BEAN.getCLAIM_PCI_REF_NO() + "'";

			String sql_C1 = "SELECT SUM(CCD_FC_EST_AMT) FROM  PT_IL_CLAIM_COVER_DTLS,   PT_IL_CLAIM  WHERE  CLAIM_POL_SYS_ID  = "
					+ claimSysId
					+ "  AND CLAIM_SYS_ID  = CCD_CLAIM_SYS_ID  AND CLAIM_ASSR_CODE  = ?  AND CCD_COVER_CODE  = ? ";
			ResultSet resultSet_C1 = null;
			// Statement
			// stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			String sql_C2 = "SELECT POAC_FC_SA FROM  PT_IL_POL_ADDL_COVER  WHERE  POAC_COVER_CODE  = ?  AND POAC_ASSR_CODE  = ?  AND POAC_POL_SYS_ID  = "
					+ M_POL_SYS_ID + " ";
			ResultSet resultSet_C2 = null;
			// Statement
			// stmt_C2=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql_C3 = "SELECT DECODE(POL_INCORPORATED_YN, 'N', POL_FC_SUM_ASSURED, 'Y', POL_LC_TOT_SA) FROM  PT_IL_POLICY  WHERE  POL_PLAN_CODE  = ?  AND POL_SYS_ID  = "
					+ M_POL_SYS_ID + "  AND POL_DS_TYPE  = '2' ";
			ResultSet resultSet_C3 = null;
			// Statement
			// stmt_C3=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql_C4 = "SELECT POL_SYS_ID FROM  PT_IL_POLICY  WHERE  POL_NO  = ?  AND POL_DS_TYPE  = '2' ";
			ResultSet resultSet_C4 = null;
			// Statement
			// stmt_C4=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql_C5 = "SELECT COVER_CLASS FROM  PM_IL_COVER  WHERE  COVER_CODE  = ? ";
			ResultSet resultSet_C5 = null;
			// Statement
			// stmt_C5=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql_C6 = "SELECT POAC_MED_DAYS FROM  PT_IL_POL_ADDL_COVER  WHERE  POAC_COVER_CODE  = ?  AND POAC_POL_SYS_ID  = "
					+ M_POL_SYS_ID + " ";
			ResultSet resultSet_C6 = null;
			// Statement
			// stmt_C6=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql_C7 = "SELECT SUM(CCD_NO_OF_DAYS) FROM  PT_IL_CLAIM_COVER_DTLS  WHERE  CCD_COVER_CODE  = :PT_IL_CLAIM_COVER_DTLS.CCD_COVER_CODE  AND CCD_CLAIM_SYS_ID  IN  (   SELECT CLAIM_SYS_ID  FROM  PT_IL_CLAIM   WHERE  CLAIM_POL_NO  = :PT_IL_CLAIM.CLAIM_POL_NO   AND CLAIM_ADDL_STATUS  = 'CL05'  ) ";
			ResultSet resultSet_C7 = null;
			// Statement
			// stmt_C7=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			if (resultSet_C4 != null) {
				resultSet_C4.close();
			}
			resultSet_C4 = handler.executeSelectStatement(sql_C4, connection,
					new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_POL_NO() });
			if (resultSet_C4.next()) {
				M_POL_SYS_ID = resultSet_C4.getString(1);
			}
			resultSet_C4.close();
			if (resultSet_C1 != null) {
				resultSet_C1.close();
			}
			resultSet_C1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE(),
							PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE() });
			if (resultSet_C1.next()) {
			}
			resultSet_C1.close();
			if (resultSet_C2 != null) {
				resultSet_C2.close();
			}
			resultSet_C2 = handler.executeSelectStatement(sql_C2, connection,
					new Object[] {
							PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),
							PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE() });
			if (resultSet_C2.next()) {
			}
			resultSet_C2.close();
			if (resultSet_C3 != null) {
				resultSet_C3.close();
			}
			resultSet_C3 = handler.executeSelectStatement(sql_C3, connection,
					new Object[] { PT_IL_CLAIM_COVER_DTLS_BEAN
							.getCCD_COVER_CODE() });
			if (resultSet_C3.next()) {
			}
			resultSet_C3.close();
			if (resultSet_C6 != null) {
				resultSet_C6.close();
			}
			resultSet_C6 = handler.executeSelectStatement(sql_C6, connection,
					new Object[] { PT_IL_CLAIM_COVER_DTLS_BEAN
							.getCCD_COVER_CODE() });
			if (resultSet_C6.next()) {
				M_POAC_MED_DAYS = resultSet_C6.getString(1);
			}
			resultSet_C6.close();
			if (resultSet_C7 != null) {
				resultSet_C7.close();
			}
			resultSet_C7 = handler.executeSelectStatement(sql_C7, connection,
					new Object[] {
							PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),
							PT_IL_CLAIM_BEAN.getCLAIM_POL_NO() });
			if (resultSet_C7.next()) {
				M_CCD_NO_OF_DAYS = resultSet_C7.getString(1);
			}
			resultSet_C7.close();
			if (resultSet_C5 != null) {
				resultSet_C5.close();
			}
			resultSet_C5 = handler.executeSelectStatement(sql_C5, connection,
					new Object[] { PT_IL_CLAIM_COVER_DTLS_BEAN
							.getCCD_COVER_CODE() });
			if (resultSet_C5.next()) {
				M_COVER_CLASS = resultSet_C5.getString(1);
			}
			resultSet_C5.close();
			if (MigratingFunctions.nvl(M_COVER_CLASS, "X") == "M") {
				// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CLAIM_COVER_DTLS.CCD_NO_OF_DAYS",ENABLED,PROPERTY_TRUE);
				CLAIM_COVER_DTLS_ACTION.getCOMP_CCD_NO_OF_DAYS().setDisabled(
						false);
				// actionBean.getCOMP_CCD_NO_OF_DAYS().setDisabled(false);
				if (M_POAC_MED_DAYS == M_CCD_NO_OF_DAYS) {
					/*
					 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91531,NAME_IN.NAME_IN("GLOBAL.M_LANG_CODE"));
					 * throw new FORM_TRIGGER_FAILURE();
					 */

					throw new ValidatorException(new FacesMessage(
							PropertyManager.getValue("91531")));
				}
				// else
				// if((M_CCD_NO_OF_DAYS+MigratingFunctions.nvl(PT_IL_CLAIM_COVER_DTLS.CCD_NO_OF_DAYS,0))>M_POAC_MED_DAYS)
				{
					/*
					 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91532,NAME_IN.NAME_IN("GLOBAL.M_LANG_CODE"),M_CCD_NO_OF_DAYS,M_POAC_MED_DAYS);
					 * throw new FORM_TRIGGER_FAILURE();
					 */

					throw new ValidatorException(new FacesMessage(
							PropertyManager.getValue("91532")));
				}
			} else {
				// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_CLAIM_COVER_DTLS.CCD_NO_OF_DAYS",ENABLED,PROPERTY_FALSE);
				CLAIM_COVER_DTLS_ACTION.getCOMP_CCD_NO_OF_DAYS().setDisabled(
						true);
			}
			/*
			 * L_CLM_EST_COVER_VALID.L_CLM_EST_COVER_VALID();
			 * P_VAL_COVER.P_VAL_COVER(:PT_IL_CLAIM_COVER_DTLS.CCD_COVER_CODE,:PT_IL_CLAIM_COVER_DTLS.M_CCD_COVER_CODE_DESC,null,"N","E");
			 * PT_IL_CLAIM_COVER_DTLS.CCD_DISAB_TYPE=:PT_IL_CLAIM_COVER_DTLS.CCD_DISAB_TYPE;
			 * L_CALC_CLM_CVR_EST_AMT.L_CALC_CLM_CVR_EST_AMT();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

		}
	}

	public void pt_il_claim_claim_lc_rla_amount_when_validate_item(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		/*Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            if(:PT_IL_CLAIM.CLAIM_INTM_DT<:PT_IL_CLAIM.CLAIM_LOSS_DT || :PT_IL_CLAIM.CLAIM_INTM_DT>new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
            {
                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71100,NAME_IN.NAME_IN("GLOBAL.M_LANG_CODE"));
                throw new FORM_TRIGGER_FAILURE();
            }
            P_SET_DOC_NO_PROP.P_SET_DOC_NO_PROP("4",:GLOBAL.M_PARA_1,:DUMMY.M_POL_DIVN_CODE,:DUMMY.M_POL_CLASS_CODE,:DUMMY.M_POL_PLAN_CODE,:DUMMY.M_POL_PROD_CODE,ConvertFunctions.to_char(:DUMMY.M_POL_UW_YEAR),"PT_IL_CLAIM.CLAIM_NO","PT_IL_CLAIM","Y",:PT_IL_CLAIM.CLAIM_INTM_DT,:PT_IL_CLAIM.CLAIM_TYPE,:PT_IL_CLAIM.CLAIM_INTM_DT);
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }*/
		Double CLAIM_LC_RLA_AMOUNT = (Double) ((UIInput) component).getSubmittedValue();
		Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
		PT_IL_CLAIM_ACTION claimAction = (PT_IL_CLAIM_ACTION) sessionMap.get("PILT006_APAC_PT_IL_CLAIM_ACTION");
	}
	
	public void pt_il_claim_claim_curr_code_when_validate_item(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		PILT006_APAC_PROCEDURE procedure = new PILT006_APAC_PROCEDURE();
		Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
		String clientId = (String) sessionMap.get("CLIENT_ID");
		Connection connection = (Connection) sessionMap.get(clientId);
		PT_IL_CLAIM_ACTION claimAction = (PT_IL_CLAIM_ACTION) sessionMap.get("PILT006_APAC_PT_IL_CLAIM_ACTION");
		String CLAIM_CURR_CODE_DESC = claimAction.getPT_IL_CLAIM_BEAN().getUI_M_CLAIM_CURR_CODE_DESC();
		String CLAIM_CURR_CODE = (String) ((UIInput) component).getSubmittedValue();
		ArrayList<String> paramList = null;//procedure.P_VAL_CURR(connection, CLAIM_CURR_CODE, null, "N", "E", null);
		String M_CLAIM_CURR_CODE_DESC = paramList.get(0);
		//not complete
	}
	
}
