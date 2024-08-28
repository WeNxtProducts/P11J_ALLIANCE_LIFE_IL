package com.iii.pel.forms.PILP090_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP004.DUMMY;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PERSISTENCY_ACTION extends CommonAction {
	public PILP090_APAC_COMPOSITE_ACTION compositeAction;
	private PERSISTENCY PERSISTENCY_BEAN;
	
	public PERSISTENCY getPERSISTENCY_BEAN() {
		return PERSISTENCY_BEAN;
	}
	public void setPERSISTENCY_BEAN(PERSISTENCY pERSISTENCY_BEAN) {
		PERSISTENCY_BEAN = pERSISTENCY_BEAN;
	}
	
public PERSISTENCY_ACTION(){
	PERSISTENCY_BEAN =new PERSISTENCY();
	helper = new PERSISTENCY_HELPER();
	}


private HtmlOutputLabel COMP_UI_M_AGENT_FM_LABEL;

public HtmlOutputLabel getCOMP_UI_M_AGENT_FM_LABEL() {
	return COMP_UI_M_AGENT_FM_LABEL;
}
public void setCOMP_UI_M_AGENT_FM_LABEL(HtmlOutputLabel cOMP_UI_M_AGENT_FM_LABEL) {
	COMP_UI_M_AGENT_FM_LABEL = cOMP_UI_M_AGENT_FM_LABEL;
}

private HtmlInputText COMP_UI_M_AGENT_FM;

public HtmlInputText getCOMP_UI_M_AGENT_FM() {
	return COMP_UI_M_AGENT_FM;
}
public void setCOMP_UI_M_AGENT_FM(HtmlInputText cOMP_UI_M_AGENT_FM) {
	COMP_UI_M_AGENT_FM = cOMP_UI_M_AGENT_FM;
}

private HtmlOutputLabel COMP_UI_M_AGENT_TO_LABEL;

public HtmlOutputLabel getCOMP_UI_M_AGENT_TO_LABEL() {
	return COMP_UI_M_AGENT_TO_LABEL;
}
public void setCOMP_UI_M_AGENT_TO_LABEL(HtmlOutputLabel cOMP_UI_M_AGENT_TO_LABEL) {
	COMP_UI_M_AGENT_TO_LABEL = cOMP_UI_M_AGENT_TO_LABEL;
}

private HtmlInputText COMP_UI_M_AGENT_TO;

public HtmlInputText getCOMP_UI_M_AGENT_TO() {
	return COMP_UI_M_AGENT_TO;
}
public void setCOMP_UI_M_AGENT_TO(HtmlInputText cOMP_UI_M_AGENT_TO) {
	COMP_UI_M_AGENT_TO = cOMP_UI_M_AGENT_TO;
}
ArrayList<LovBean> lovList = new ArrayList<LovBean>();

private HtmlOutputLabel COMP_UI_M_PRODUCT_DT_FM_LABEL;

public HtmlOutputLabel getCOMP_UI_M_PRODUCT_DT_FM_LABEL() {
	return COMP_UI_M_PRODUCT_DT_FM_LABEL;
}
public void setCOMP_UI_M_PRODUCT_DT_FM_LABEL(
		HtmlOutputLabel cOMP_UI_M_PRODUCT_DT_FM_LABEL) {
	COMP_UI_M_PRODUCT_DT_FM_LABEL = cOMP_UI_M_PRODUCT_DT_FM_LABEL;
}

private HtmlCalendar COMP_UI_M_PRODUCT_DT_FM;


public HtmlCalendar getCOMP_UI_M_PRODUCT_DT_FM() {
	return COMP_UI_M_PRODUCT_DT_FM;
}
public void setCOMP_UI_M_PRODUCT_DT_FM(HtmlCalendar cOMP_UI_M_PRODUCT_DT_FM) {
	COMP_UI_M_PRODUCT_DT_FM = cOMP_UI_M_PRODUCT_DT_FM;
}


private HtmlOutputLabel COMP_UI_M_PRODUCT_DT_TO_LABEL;

public HtmlOutputLabel getCOMP_UI_M_PRODUCT_DT_TO_LABEL() {
	return COMP_UI_M_PRODUCT_DT_TO_LABEL;
}
public void setCOMP_UI_M_PRODUCT_DT_TO_LABEL(
		HtmlOutputLabel cOMP_UI_M_PRODUCT_DT_TO_LABEL) {
	COMP_UI_M_PRODUCT_DT_TO_LABEL = cOMP_UI_M_PRODUCT_DT_TO_LABEL;
}

private HtmlCalendar COMP_UI_M_PRODUCT_DT_TO;



public HtmlCalendar getCOMP_UI_M_PRODUCT_DT_TO() {
	return COMP_UI_M_PRODUCT_DT_TO;
}
public void setCOMP_UI_M_PRODUCT_DT_TO(HtmlCalendar cOMP_UI_M_PRODUCT_DT_TO) {
	COMP_UI_M_PRODUCT_DT_TO = cOMP_UI_M_PRODUCT_DT_TO;
}


private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;

public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
	return COMP_UI_M_PROCESS_DT_LABEL;
}
public void setCOMP_UI_M_PROCESS_DT_LABEL(
		HtmlOutputLabel cOMP_UI_M_PROCESS_DT_LABEL) {
	COMP_UI_M_PROCESS_DT_LABEL = cOMP_UI_M_PROCESS_DT_LABEL;
}

private HtmlCalendar COMP_UI_M_PROCESS_DT;


public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
	return COMP_UI_M_PROCESS_DT;
}
public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar cOMP_UI_M_PROCESS_DT) {
	COMP_UI_M_PROCESS_DT = cOMP_UI_M_PROCESS_DT;
}


private HtmlCommandButton COMP_UI_M_COPY_OK;

public HtmlCommandButton getCOMP_UI_M_COPY_OK() {
	return COMP_UI_M_COPY_OK;
}
public void setCOMP_UI_M_COPY_OK(HtmlCommandButton cOMP_UI_M_COPY_OK) {
	COMP_UI_M_COPY_OK = cOMP_UI_M_COPY_OK;
}

private PERSISTENCY_HELPER helper;

public void Validate_M_AGENT_FM(FacesContext context,
		UIComponent component, Object value){
	try{
		String agent_from_value = (String)value;
		PERSISTENCY_BEAN.setAGENT_FM_CODE(agent_from_value);
	
		COMP_UI_M_AGENT_FM.resetValue();
	}catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
		
	}
}

public void listenerM_AGENT_FM(ActionEvent event) {
	UIInput input = (UIInput) event.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		try {
			if (inputValue.isEmpty()) {
				COMP_UI_M_AGENT_FM
						.setSubmittedValue(PELConstants.PROCESS_FROMVALUE);
				PERSISTENCY_BEAN.setAGENT_FM_CODE(PELConstants.PROCESS_TOVALUE);
			} else {
				PERSISTENCY_BEAN.setAGENT_FM_CODE(inputValue);
			}
		}
		
	 catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("UI_M_AGENT_FM", e.getMessage());
	}
}
public ArrayList<com.iii.premia.common.bean.LovBean> preparePOL_NO_FMLOV(Object value) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
		ListItemUtil itemUtil = new ListItemUtil();
		lovList = itemUtil.P_CALL_LOV("PILP004", "MATURITY", "M_POL_NO_FM",
				null, null, null, null, null, (String) value);
	//lovList=getPolicyNumber((String) value);
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
	}
	return lovList;
}

public void Validate_M_AGENT_TO(FacesContext context,
		UIComponent component, Object value){
	try{
		String agent_to_value = (String)value;
		PERSISTENCY_BEAN.setAGENT_TO_CODE(agent_to_value);
	
		COMP_UI_M_AGENT_TO.resetValue();
	}catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
		
	}
}
public void listenerM_AGENT_TO(ActionEvent event) {
	UIInput input = (UIInput) event.getComponent().getParent();
	String inputTextString=(String)input.getSubmittedValue();
	try{
	if(inputTextString == "")
	{
		if(!PELConstants.PROCESS_FROMVALUE.equals(PERSISTENCY_BEAN.getAGENT_FM_CODE()))
		{
			COMP_UI_M_AGENT_TO.setSubmittedValue(PERSISTENCY_BEAN.getAGENT_FM_CODE());
			PERSISTENCY_BEAN.setAGENT_TO_CODE(PERSISTENCY_BEAN.getAGENT_FM_CODE());
		}else{
			COMP_UI_M_AGENT_TO.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
			PERSISTENCY_BEAN.setAGENT_TO_CODE(PELConstants.PROCESS_TOVALUE);
		}
	}else{
		PERSISTENCY_BEAN.setAGENT_TO_CODE(inputTextString);
	}
	}catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("UI_M_AGENT_TO", e.getMessage());
	}
}
public ArrayList<com.iii.premia.common.bean.LovBean> preparePOL_NO_TOLOV(Object value) {
	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
		lovList = listitemutil.P_CALL_LOV("PILP004", "MATURITY", "M_POL_NO_TO",
				null, null, null, null, null, (String) value);
		//lovList=getPolicyNumber((String) value);
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
	}
	return lovList;
}

public void ValidateM_PRODUCT_DT_FM(FacesContext context,
		UIComponent component, Object value) {
	try {
		PERSISTENCY_BEAN.setPRODUCTION_FM_DT((Date) value);
		COMP_UI_M_PRODUCT_DT_FM.resetValue();
	} catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}

public void ValidateM_PRODUCT_DT_TO(FacesContext context,
		UIComponent component, Object value) {
	try {
		PERSISTENCY_BEAN.setPRODUCTION_TO_DT((Date) value);
		COMP_UI_M_PRODUCT_DT_TO.resetValue();
	} catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}


public void ValidateM_PROCESS_DT(FacesContext context,
		UIComponent component, Object value) {
	try {
		PERSISTENCY_BEAN.setPROCESS_DT((Date) value);
		COMP_UI_M_PROCESS_DT.resetValue();
	} catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}

public void onClickOK() {
	
	String P_AGENT_FM_CODE=PERSISTENCY_BEAN.getAGENT_FM_CODE();
	String P_AGENT_TO_CODE=PERSISTENCY_BEAN.getAGENT_TO_CODE();
	Date P_PROD_FM_DT=PERSISTENCY_BEAN.getPRODUCTION_FM_DT();
	Date P_PROD_TO_DT=PERSISTENCY_BEAN.getPRODUCTION_TO_DT();
	Date P_PROCESS_DT=PERSISTENCY_BEAN.getPROCESS_DT();
	try {
		Calc_Agt_Monthly_Persistency(P_AGENT_FM_CODE,P_AGENT_TO_CODE,P_PROD_FM_DT,P_PROD_TO_DT,P_PROCESS_DT);
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Process is completed successfully"
				);
		getWarningMap().put("PERSISTENCE", "Process is completed successfully");
	} catch (ProcedureException e) {
		e.printStackTrace();
	}
	
}

public void onLoad(PhaseEvent event) {
	try {
		if (isBlockFlag()) {
			helper.WHEN_CREATE_RECORD(this.getPERSISTENCY_BEAN());
			setBlockFlag(false);
		}
	} catch (Exception e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("onLoad", e.getMessage());
	}
}
public ArrayList<OracleParameter> Calc_Agt_Monthly_Persistency(String P_AGENT_FM_CODE,String P_AGENT_TO_CODE,Object P_PROD_FM_DT,
		Object P_PROD_TO_DT,Object P_PROCESS_DT) throws ProcedureException {
Connection connection = null;
ArrayList<OracleParameter> parameterList = null;
ArrayList<OracleParameter> outputList = null;
try {
	connection = CommonUtils.getConnection();
parameterList = new ArrayList<OracleParameter>();
outputList = new ArrayList<OracleParameter>();
OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_AGENT_FM_CODE);
parameterList.add(param1);
OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_AGENT_TO_CODE);
parameterList.add(param2);
OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PROD_FM_DT);
parameterList.add(param3);
OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PROD_TO_DT);
parameterList.add(param4);
OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_PROCESS_DT);
parameterList.add(param5);
OracleProcedureHandler procHandler = new OracleProcedureHandler();
outputList = procHandler.executeProc(parameterList, connection,
			"Calc_Agt_Monthly_Persistency");
} catch(Exception e) {
	ErrorHelpUtil.getErrorForProcedure(connection);
	throw new ProcedureException(e.getMessage());
}
return outputList;
}
public ArrayList<LovBean> prepareSuggestionList_BROKER_CODE(Object object) {
	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
	Connection connection = null;
	ResultSet resultSet = null;
	String currentValue = (String) object;
	String query1value = null;
	String query1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'LOV_CUST' "
			+ "AND PS_CODE = 'IL_BROKER'";
	String query2 = null;

	try {
		connection = CommonUtils.getConnection();
		resultSet = new CRUDHandler().executeSelectStatement(query1,
				connection);
		if (resultSet.next()) {
			query1value = resultSet.getString(1);
		}
		/*commented and added by ameen for FALCONLIFE-1344105 on 21-10-2016
		 * 
		 * query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
				+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
				+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
				+ query1value
				+ ") AND PS_CODE = 'IL_BROKER' "
				+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
				+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
				+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
				+ "(CUST_CODE LIKE ? OR  CUST_NAME LIKE ? OR  CUST_BL_NAME LIKE ?) AND ROWNUM < 25 ORDER BY 1";*/
		query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
				+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
				+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
				+ query1value
				+ ") AND PS_CODE = 'IL_BROKER' "
				+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
				+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
				+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
				+ "(UPPER(CUST_CODE) LIKE UPPER(?) OR  UPPER(CUST_NAME) LIKE UPPER(?) OR  UPPER(CUST_BL_NAME) LIKE UPPER(?)) AND ROWNUM < 25 ORDER BY 1";
		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		lovList = ListItemUtil.prepareSuggestionList(query2, new Object[] {CommonUtils.getGlobalVariable("GLOBAL.M_DIVN_CODE"),
				currentValue, currentValue, currentValue });
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("SUGGETION", e.getMessage());
	}
	return lovList;
}

}
