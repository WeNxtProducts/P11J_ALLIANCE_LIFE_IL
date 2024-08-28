package com.iii.pel.forms.PILQ004_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class POL_DISC_LOAD_ACTION {

	private HtmlOutputLabel COMP_PDL_DISC_LOAD_CODE_LABEL;

	private HtmlInputText COMP_PDL_DISC_LOAD_CODE;

	private HtmlOutputLabel COMP_PDL_RATE_LABEL;

	private HtmlInputText COMP_PDL_RATE;

	private HtmlOutputLabel COMP_PDL_RATE_PER_LABEL;

	private HtmlInputText COMP_PDL_RATE_PER;

	private HtmlOutputLabel COMP_PDL_LC_DISC_LOAD_VALUE_LABEL;

	private HtmlInputText COMP_PDL_LC_DISC_LOAD_VALUE;

	private HtmlOutputLabel COMP_UI_M_DISCLOAD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DISCLOAD_DESC;

	private POL_DISC_LOAD POL_DISC_LOAD_BEAN;

	public POL_DISC_LOAD_ACTION() {
		POL_DISC_LOAD_BEAN = new POL_DISC_LOAD();
	}

	public HtmlOutputLabel getCOMP_PDL_DISC_LOAD_CODE_LABEL() {
		return COMP_PDL_DISC_LOAD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PDL_DISC_LOAD_CODE() {
		return COMP_PDL_DISC_LOAD_CODE;
	}

	public void setCOMP_PDL_DISC_LOAD_CODE_LABEL(HtmlOutputLabel COMP_PDL_DISC_LOAD_CODE_LABEL) {
		this.COMP_PDL_DISC_LOAD_CODE_LABEL = COMP_PDL_DISC_LOAD_CODE_LABEL;
	}

	public void setCOMP_PDL_DISC_LOAD_CODE(HtmlInputText COMP_PDL_DISC_LOAD_CODE) {
		this.COMP_PDL_DISC_LOAD_CODE = COMP_PDL_DISC_LOAD_CODE;
	}

	public HtmlOutputLabel getCOMP_PDL_RATE_LABEL() {
		return COMP_PDL_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PDL_RATE() {
		return COMP_PDL_RATE;
	}

	public void setCOMP_PDL_RATE_LABEL(HtmlOutputLabel COMP_PDL_RATE_LABEL) {
		this.COMP_PDL_RATE_LABEL = COMP_PDL_RATE_LABEL;
	}

	public void setCOMP_PDL_RATE(HtmlInputText COMP_PDL_RATE) {
		this.COMP_PDL_RATE = COMP_PDL_RATE;
	}

	public HtmlOutputLabel getCOMP_PDL_RATE_PER_LABEL() {
		return COMP_PDL_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_PDL_RATE_PER() {
		return COMP_PDL_RATE_PER;
	}

	public void setCOMP_PDL_RATE_PER_LABEL(HtmlOutputLabel COMP_PDL_RATE_PER_LABEL) {
		this.COMP_PDL_RATE_PER_LABEL = COMP_PDL_RATE_PER_LABEL;
	}

	public void setCOMP_PDL_RATE_PER(HtmlInputText COMP_PDL_RATE_PER) {
		this.COMP_PDL_RATE_PER = COMP_PDL_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_PDL_LC_DISC_LOAD_VALUE_LABEL() {
		return COMP_PDL_LC_DISC_LOAD_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_PDL_LC_DISC_LOAD_VALUE() {
		return COMP_PDL_LC_DISC_LOAD_VALUE;
	}

	public void setCOMP_PDL_LC_DISC_LOAD_VALUE_LABEL(HtmlOutputLabel COMP_PDL_LC_DISC_LOAD_VALUE_LABEL) {
		this.COMP_PDL_LC_DISC_LOAD_VALUE_LABEL = COMP_PDL_LC_DISC_LOAD_VALUE_LABEL;
	}

	public void setCOMP_PDL_LC_DISC_LOAD_VALUE(HtmlInputText COMP_PDL_LC_DISC_LOAD_VALUE) {
		this.COMP_PDL_LC_DISC_LOAD_VALUE = COMP_PDL_LC_DISC_LOAD_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DISCLOAD_DESC_LABEL() {
		return COMP_UI_M_DISCLOAD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DISCLOAD_DESC() {
		return COMP_UI_M_DISCLOAD_DESC;
	}

	public void setCOMP_UI_M_DISCLOAD_DESC_LABEL(HtmlOutputLabel COMP_UI_M_DISCLOAD_DESC_LABEL) {
		this.COMP_UI_M_DISCLOAD_DESC_LABEL = COMP_UI_M_DISCLOAD_DESC_LABEL;
	}

	public void setCOMP_UI_M_DISCLOAD_DESC(HtmlInputText COMP_UI_M_DISCLOAD_DESC) {
		this.COMP_UI_M_DISCLOAD_DESC = COMP_UI_M_DISCLOAD_DESC;
	}

	public POL_DISC_LOAD getPOL_DISC_LOAD_BEAN() {
		return POL_DISC_LOAD_BEAN;
	}

	public void setPOL_DISC_LOAD_BEAN(POL_DISC_LOAD POL_DISC_LOAD_BEAN) {
		this.POL_DISC_LOAD_BEAN = POL_DISC_LOAD_BEAN;
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
		String C1 = "SELECT * FROM PT_IL_POL_DISC_LOAD WHERE PDL_POL_SYS_ID =? ";
		List<POL_DISC_LOAD> list = new ArrayList<POL_DISC_LOAD>();
		POL_DISC_LOAD POL_DISC_LOAD_BEAN = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{POLICY_DETAILS_BEAN.getPOL_SYS_ID()});
			while(resultSet.next()){
				POL_DISC_LOAD_BEAN = new POL_DISC_LOAD();
			//	POL_DISC_LOAD_BEAN.setROWID(resultSet.getString("ROWID"));
				POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_CODE(resultSet.getString("PDL_DISC_LOAD_CODE"));
				POL_DISC_LOAD_BEAN.setPDL_DISC_LOAD_TYPE(resultSet.getString("PDL_DISC_LOAD_TYPE"));
				POL_DISC_LOAD_BEAN.setPDL_RATE(resultSet.getDouble("PDL_RATE"));
				POL_DISC_LOAD_BEAN.setPDL_RATE_PER(resultSet.getDouble("PDL_RATE_PER"));
				POL_DISC_LOAD_BEAN.setPDL_LC_DISC_LOAD_VALUE(resultSet.getDouble("PDL_LC_DISC_LOAD_VALUE"));
				POL_DISC_LOAD_BEAN.setPDL_POL_SYS_ID(resultSet.getDouble("PDL_POL_SYS_ID"));
				
				postQueryPOL_DISC_LOAD(POL_DISC_LOAD_BEAN);
				list.add(POL_DISC_LOAD_BEAN);
			}
			
			ASSRD_DTLS_ACTION_BEAN.setLoadList(list);
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(Exception exception2){exception2.printStackTrace();}
		}
	} 
	
	private void postQueryPOL_DISC_LOAD(POL_DISC_LOAD POL_DISC_LOAD_BEAN)
			throws Exception {

		String M_TYPE = null;
		try {
			if (POL_DISC_LOAD_BEAN.getPDL_DISC_LOAD_CODE() != null) {
				if ("D".equalsIgnoreCase(POL_DISC_LOAD_BEAN.getPDL_DISC_LOAD_TYPE())) {
					M_TYPE = "IL_DISC";
				} else {
					M_TYPE = "IL_LOAD";
				}

				ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1", "STRING",
						"IN", M_TYPE);
				OracleParameter param2 = new OracleParameter("in2", "STRING",
						"IN", POL_DISC_LOAD_BEAN.getPDL_DISC_LOAD_CODE());
				OracleParameter param3 = new OracleParameter("in3", "STRING",
						"IN OUT", POL_DISC_LOAD_BEAN.getUI_M_DISCLOAD_DESC());
				OracleParameter param4 = new OracleParameter("in4", "STRING",
						"IN", "'N'");
				OracleParameter param5 = new OracleParameter("in5", "STRING",
						"IN", "'N'");
				OracleParameter param6 = new OracleParameter("in6", "STRING",
						"IN", null);
				paramList.add(param1);
				paramList.add(param2);
				paramList.add(param3);
				paramList.add(param4);
				paramList.add(param5);
				paramList.add(param6);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				ArrayList<OracleParameter> list = procHandler.execute(
						paramList, CommonUtils.getConnection(), "P_VAL_CODES");
				if(list!=null && list.get(0)!=null){
					POL_DISC_LOAD_BEAN
					.setUI_M_DISCLOAD_DESC(list.get(0).getValue());
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}

	}
}
