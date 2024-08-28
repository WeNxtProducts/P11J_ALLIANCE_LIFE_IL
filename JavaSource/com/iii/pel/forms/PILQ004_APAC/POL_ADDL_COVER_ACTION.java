package com.iii.pel.forms.PILQ004_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class POL_ADDL_COVER_ACTION {

	private HtmlOutputLabel COMP_POAC_COVER_CODE_LABEL;

	private HtmlInputText COMP_POAC_COVER_CODE;

	private HtmlOutputLabel COMP_POAC_LC_SA_LABEL;

	private HtmlInputText COMP_POAC_LC_SA;

	private HtmlOutputLabel COMP_UI_M_POAC_TOTAL_LC_SUM_LABEL;

	private HtmlInputText COMP_UI_M_POAC_TOTAL_LC_SUM;

	private HtmlOutputLabel COMP_POAC_PERIOD_LABEL;

	private HtmlInputText COMP_POAC_PERIOD;

	private HtmlOutputLabel COMP_POAC_PREM_PAY_YRS_LABEL;

	private HtmlInputText COMP_POAC_PREM_PAY_YRS;

	private HtmlOutputLabel COMP_UI_M_TOT_LC_SA_LABEL;

	private HtmlInputText COMP_UI_M_TOT_LC_SA;

	private HtmlOutputLabel COMP_POAC_FM_DT_LABEL;

	private HtmlCalendar COMP_POAC_FM_DT;

	private HtmlOutputLabel COMP_POAC_LC_PREM_LABEL;

	private HtmlInputText COMP_POAC_LC_PREM;

	private HtmlOutputLabel COMP_UI_M_POAC_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAC_COVER_DESC;

	private POL_ADDL_COVER POL_ADDL_COVER_BEAN;

	public POL_ADDL_COVER_ACTION() {
		POL_ADDL_COVER_BEAN = new POL_ADDL_COVER();
	}

	public HtmlOutputLabel getCOMP_POAC_COVER_CODE_LABEL() {
		return COMP_POAC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POAC_COVER_CODE() {
		return COMP_POAC_COVER_CODE;
	}

	public void setCOMP_POAC_COVER_CODE_LABEL(HtmlOutputLabel COMP_POAC_COVER_CODE_LABEL) {
		this.COMP_POAC_COVER_CODE_LABEL = COMP_POAC_COVER_CODE_LABEL;
	}

	public void setCOMP_POAC_COVER_CODE(HtmlInputText COMP_POAC_COVER_CODE) {
		this.COMP_POAC_COVER_CODE = COMP_POAC_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_SA_LABEL() {
		return COMP_POAC_LC_SA_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LC_SA() {
		return COMP_POAC_LC_SA;
	}

	public void setCOMP_POAC_LC_SA_LABEL(HtmlOutputLabel COMP_POAC_LC_SA_LABEL) {
		this.COMP_POAC_LC_SA_LABEL = COMP_POAC_LC_SA_LABEL;
	}

	public void setCOMP_POAC_LC_SA(HtmlInputText COMP_POAC_LC_SA) {
		this.COMP_POAC_LC_SA = COMP_POAC_LC_SA;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_TOTAL_LC_SUM_LABEL() {
		return COMP_UI_M_POAC_TOTAL_LC_SUM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAC_TOTAL_LC_SUM() {
		return COMP_UI_M_POAC_TOTAL_LC_SUM;
	}

	public void setCOMP_UI_M_POAC_TOTAL_LC_SUM_LABEL(HtmlOutputLabel COMP_UI_M_POAC_TOTAL_LC_SUM_LABEL) {
		this.COMP_UI_M_POAC_TOTAL_LC_SUM_LABEL = COMP_UI_M_POAC_TOTAL_LC_SUM_LABEL;
	}

	public void setCOMP_UI_M_POAC_TOTAL_LC_SUM(HtmlInputText COMP_UI_M_POAC_TOTAL_LC_SUM) {
		this.COMP_UI_M_POAC_TOTAL_LC_SUM = COMP_UI_M_POAC_TOTAL_LC_SUM;
	}

	public HtmlOutputLabel getCOMP_POAC_PERIOD_LABEL() {
		return COMP_POAC_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_POAC_PERIOD() {
		return COMP_POAC_PERIOD;
	}

	public void setCOMP_POAC_PERIOD_LABEL(HtmlOutputLabel COMP_POAC_PERIOD_LABEL) {
		this.COMP_POAC_PERIOD_LABEL = COMP_POAC_PERIOD_LABEL;
	}

	public void setCOMP_POAC_PERIOD(HtmlInputText COMP_POAC_PERIOD) {
		this.COMP_POAC_PERIOD = COMP_POAC_PERIOD;
	}

	public HtmlOutputLabel getCOMP_POAC_PREM_PAY_YRS_LABEL() {
		return COMP_POAC_PREM_PAY_YRS_LABEL;
	}

	public HtmlInputText getCOMP_POAC_PREM_PAY_YRS() {
		return COMP_POAC_PREM_PAY_YRS;
	}

	public void setCOMP_POAC_PREM_PAY_YRS_LABEL(HtmlOutputLabel COMP_POAC_PREM_PAY_YRS_LABEL) {
		this.COMP_POAC_PREM_PAY_YRS_LABEL = COMP_POAC_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_POAC_PREM_PAY_YRS(HtmlInputText COMP_POAC_PREM_PAY_YRS) {
		this.COMP_POAC_PREM_PAY_YRS = COMP_POAC_PREM_PAY_YRS;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_LC_SA_LABEL() {
		return COMP_UI_M_TOT_LC_SA_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_LC_SA() {
		return COMP_UI_M_TOT_LC_SA;
	}

	public void setCOMP_UI_M_TOT_LC_SA_LABEL(HtmlOutputLabel COMP_UI_M_TOT_LC_SA_LABEL) {
		this.COMP_UI_M_TOT_LC_SA_LABEL = COMP_UI_M_TOT_LC_SA_LABEL;
	}

	public void setCOMP_UI_M_TOT_LC_SA(HtmlInputText COMP_UI_M_TOT_LC_SA) {
		this.COMP_UI_M_TOT_LC_SA = COMP_UI_M_TOT_LC_SA;
	}

	public HtmlOutputLabel getCOMP_POAC_FM_DT_LABEL() {
		return COMP_POAC_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POAC_FM_DT() {
		return COMP_POAC_FM_DT;
	}

	public void setCOMP_POAC_FM_DT_LABEL(HtmlOutputLabel COMP_POAC_FM_DT_LABEL) {
		this.COMP_POAC_FM_DT_LABEL = COMP_POAC_FM_DT_LABEL;
	}

	public void setCOMP_POAC_FM_DT(HtmlCalendar COMP_POAC_FM_DT) {
		this.COMP_POAC_FM_DT = COMP_POAC_FM_DT;
	}

	public HtmlOutputLabel getCOMP_POAC_LC_PREM_LABEL() {
		return COMP_POAC_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POAC_LC_PREM() {
		return COMP_POAC_LC_PREM;
	}

	public void setCOMP_POAC_LC_PREM_LABEL(HtmlOutputLabel COMP_POAC_LC_PREM_LABEL) {
		this.COMP_POAC_LC_PREM_LABEL = COMP_POAC_LC_PREM_LABEL;
	}

	public void setCOMP_POAC_LC_PREM(HtmlInputText COMP_POAC_LC_PREM) {
		this.COMP_POAC_LC_PREM = COMP_POAC_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAC_COVER_DESC_LABEL() {
		return COMP_UI_M_POAC_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POAC_COVER_DESC() {
		return COMP_UI_M_POAC_COVER_DESC;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POAC_COVER_DESC_LABEL) {
		this.COMP_UI_M_POAC_COVER_DESC_LABEL = COMP_UI_M_POAC_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAC_COVER_DESC(HtmlInputText COMP_UI_M_POAC_COVER_DESC) {
		this.COMP_UI_M_POAC_COVER_DESC = COMP_UI_M_POAC_COVER_DESC;
	}

	public POL_ADDL_COVER getPOL_ADDL_COVER_BEAN() {
		return POL_ADDL_COVER_BEAN;
	}

	public void setPOL_ADDL_COVER_BEAN(POL_ADDL_COVER POL_ADDL_COVER_BEAN) {
		this.POL_ADDL_COVER_BEAN = POL_ADDL_COVER_BEAN;
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public void executeQuery(ASSRD_DTLS_ACTION ASSRD_DTLS_ACTION_BEAN,POLICY_DETAILS POLICY_DETAILS_BEAN) throws SQLException, Exception {
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		String C1 = "select * from PT_IL_POL_ADDL_COVER where POAC_POAD_SYS_ID IN (SELECT POAD_SYS_ID FROM PT_IL_POL_ASSURED_DTLS " +
				" WHERE POAD_ASSR_CODE = ? AND POAD_POL_SYS_ID = ? )";
		List<POL_ADDL_COVER> list = new ArrayList<POL_ADDL_COVER>();
		POL_ADDL_COVER POL_ADDL_COVER_BEAN = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{ASSRD_DTLS_ACTION_BEAN.getASSRD_DTLS_BEAN().getPOAD_ASSR_CODE(),POLICY_DETAILS_BEAN.getPOL_SYS_ID()});
			while(resultSet.next()){
				POL_ADDL_COVER_BEAN = new POL_ADDL_COVER();
				//POL_ADDL_COVER_BEAN.setROWID(resultSet.getString("ROWID"));
				POL_ADDL_COVER_BEAN.setPOAC_COVER_CODE(resultSet.getString("POAC_COVER_CODE"));
				POL_ADDL_COVER_BEAN.setPOAC_FM_DT(resultSet.getDate("POAC_FM_DT"));
				POL_ADDL_COVER_BEAN.setPOAC_LC_PREM(resultSet.getDouble("POAC_LC_PREM"));
				POL_ADDL_COVER_BEAN.setPOAC_LC_SA(resultSet.getDouble("POAC_LC_SA"));
				POL_ADDL_COVER_BEAN.setPOAC_PERIOD(resultSet.getDouble("POAC_PERIOD"));
				POL_ADDL_COVER_BEAN.setPOAC_POL_SYS_ID(resultSet.getDouble("POAC_POL_SYS_ID"));
				POL_ADDL_COVER_BEAN.setPOAC_PREM_PAY_YRS(resultSet.getDouble("POAC_PREM_PAY_YRS"));
				//POL_ADDL_COVER_BEAN.setUI_M_TOT_LC_SA
				
				postQueryPOL_ADDL_COVER(POL_ADDL_COVER_BEAN);
				ASSRD_DTLS_ACTION_BEAN.getCOMP_UI_M_POAC_TOTAL_LC_SUM().setSubmittedValue(POL_ADDL_COVER_BEAN.getUI_M_POAC_TOTAL_LC_SUM()!=null ? String.valueOf(POL_ADDL_COVER_BEAN.getUI_M_POAC_TOTAL_LC_SUM()) : "");
				
				if(POLICY_DETAILS_BEAN.getUI_M_TOT_SA()==null){
					POLICY_DETAILS_BEAN.setUI_M_TOT_SA(0.0);
				}
				if(POL_ADDL_COVER_BEAN.getUI_M_POAC_TOTAL_LC_SUM()==null){
					POL_ADDL_COVER_BEAN.setUI_M_POAC_TOTAL_LC_SUM(0.0);
				}
				
				POL_ADDL_COVER_BEAN.setUI_M_TOT_LC_SA(POLICY_DETAILS_BEAN.getUI_M_TOT_SA() + POL_ADDL_COVER_BEAN.getUI_M_POAC_TOTAL_LC_SUM());
				list.add(POL_ADDL_COVER_BEAN);
			}
			
			ASSRD_DTLS_ACTION_BEAN.setCoverList(list);
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(Exception exception2){exception2.printStackTrace();}
		}
	} 
	
	/**
	 * 
	 * @param preQueryList
	 * @return
	 * @throws Exception
	 */
	public void postQueryPOL_ADDL_COVER(POL_ADDL_COVER POL_ADDL_COVER_BEAN) throws Exception {
		double SA=0;
		double SA1=0;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		Connection connection =null;
		try{
			CRUDHandler handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			String C1 = "SELECT (SUM(POL_LC_SUM_ASSURED)) FROM  PT_IL_POLICY WHERE  POL_SYS_ID  = ? ";
			String C2 = "SELECT SUM(POAC_LC_SA) FROM  PT_IL_POL_ADDL_COVER B  WHERE  B.POAC_POL_SYS_ID  = ? ";
			C1_REC = handler.executeSelectStatement(C1,connection,new Object[]{POL_ADDL_COVER_BEAN.getPOAC_POL_SYS_ID()});
			if(C1_REC.next()){
				SA = C1_REC.getDouble(1);
			}
			C2_REC = handler.executeSelectStatement(C2,connection,new Object[]{POL_ADDL_COVER_BEAN.getPOAC_POL_SYS_ID()});
			if(C2_REC.next()){
				SA1 = C2_REC.getDouble(1);
			}
			
			POL_ADDL_COVER_BEAN.setUI_M_POAC_TOTAL_LC_SUM(CommonUtils.nvl(SA, 0) + CommonUtils.nvl(SA1, 0));
			//getCOMP_UI_M_POAC_TOTAL_LC_SUM().setSubmittedValue(POL_ADDL_COVER_BEAN.getUI_M_POAC_TOTAL_LC_SUM()!=null ? String.valueOf(POL_ADDL_COVER_BEAN.getUI_M_POAC_TOTAL_LC_SUM()) : "");
			
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN", POL_ADDL_COVER_BEAN.getPOAC_COVER_CODE());
			OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT",POL_ADDL_COVER_BEAN.getUI_M_POAC_COVER_DESC());
			OracleParameter param3 = new OracleParameter("in3","STRING","IN","A");
			OracleParameter param4 = new OracleParameter("in4","STRING","IN","N");
			OracleParameter param5 = new OracleParameter("in5","STRING","IN","N");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList<OracleParameter> list = procHandler.execute(paramList, connection, "P_VAL_COVER");
			if(list!=null && list.get(0)!=null){
				POL_ADDL_COVER_BEAN.setUI_M_POAC_COVER_DESC(list.get(0).getValue());
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}

	
	}
}
