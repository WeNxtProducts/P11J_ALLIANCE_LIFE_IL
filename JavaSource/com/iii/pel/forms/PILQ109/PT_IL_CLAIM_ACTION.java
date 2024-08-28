package com.iii.pel.forms.PILQ109;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

/**
 * 
 * @author 55944
 *
 */
    public class PT_IL_CLAIM_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_CLAIM_NO;

	private HtmlInputText COMP_CLAIM_DATE;
	
	private HtmlOutputLabel COMP_CLAIM_DATE_LABEL;

	private HtmlOutputLabel COMP_UI_M_CLAIM_NO_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_CLAIM_AMOUNT_LABEL;

	private HtmlInputText COMP_CLAIM_AMOUNT;

	private HtmlCommandButton COMP_UI_M_BUT_QUERY;
	
	private String filterByCLAIM_NO;
	
    private PT_IL_CLAIM PTI_IL_CLAIM_BEAN;
    
    private DUMMY DUMMY_BEAN;

	private List<LovBean> suggestionList = null;
	
	private String POL_NO;
	
	private Double PT_HF_AMT; 

	public PT_IL_CLAIM_ACTION() throws Exception {
		PTI_IL_CLAIM_BEAN = new PT_IL_CLAIM();
		DUMMY_BEAN = new DUMMY();
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * 
	 * @param policyNo
	 * @throws Exception
	 */
	public void validatePolicyNo(String policyNo) throws Exception {
		Object[] values = null;
		ResultSet rs = null;
		String M_TEMP = null;
		String C1_Validate = "SELECT 'X' FROM   PT_IL_POLICY WHERE  POL_NO = ? ";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { policyNo };
			rs = handler
					.executeSelectStatement(C1_Validate, connection, values);
			if (rs.next()) {
				M_TEMP = rs.getString(1);
			} else {
				throw new Exception("Invalid Policy No Please re enter");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rs != null) {
				CommonUtils.closeCursor(rs);
			}
		}
	}

	public void L_CHK_POL_NO(String M_POL_NO) throws Exception {
		String C1 = " SELECT 'X'" + " FROM   PT_IL_POLICY"
				+ " WHERE  POL_NO = ?";
		String M_TEMP = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Object[] values = null;
		CRUDHandler handler = null;
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			values = new Object[] { M_POL_NO };
			resultSet = handler.executeSelectStatement(C1, connection, values);
			if (resultSet.next()) {
				M_TEMP = resultSet.getString(1);
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "2411"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				setFormFlag(false);
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}

	}

	
	

	/**
	 * 
	 */
	public void buttonPressQuery() throws Exception {
		//String polNoFrom = DUMMY_BEAN.getUI_M_POL_NO_FM();
		try {
			getWarningMap().put("current", "Process Completed Sucessfully");
		} catch (Exception exception) {
			exception.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new ProcedureException(exception.getMessage());
		} finally {
			CommonUtils.getConnection().commit();
		}
	}
	
	public List<LovBean> UI_M_POL_NO_lovAction(Object currValue) {
		/*	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
			ListItemUtil listitemutil = new ListItemUtil();
			try {
				suggestionList = listitemutil.P_CALL_LOV("PILP014",
						"DUMMY", "M_POL_NO_FM", null, null, null, null,
						null, (String) currValue);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			suggestionList = DUMMY_HELPER.getPolicyNumber((String)currValue);
			return suggestionList;
		}

	

	public HtmlCommandButton getCOMP_UI_M_BUT_QUERY() {
		return COMP_UI_M_BUT_QUERY;
	}

	public void setCOMP_UI_M_BUT_QUERY(HtmlCommandButton comp_ui_m_but_query) {
		COMP_UI_M_BUT_QUERY = comp_ui_m_but_query;
	}


	public List<LovBean> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<LovBean> suggestionList) {
		this.suggestionList = suggestionList;
	}

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String pol_no) {
		POL_NO = pol_no;
	}

	public Double getPT_HF_AMT() {
		return PT_HF_AMT;
	}

	public void setPT_HF_AMT(Double pt_hf_amt) {
		PT_HF_AMT = pt_hf_amt;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_NO() {
		return COMP_UI_M_CLAIM_NO;
	}

	public void setCOMP_UI_M_CLAIM_NO(HtmlOutputLabel comp_ui_m_claim_no) {
		COMP_UI_M_CLAIM_NO = comp_ui_m_claim_no;
	}

	public HtmlInputText getCOMP_CLAIM_DATE() {
		return COMP_CLAIM_DATE;
	}

	public void setCOMP_CLAIM_DATE(HtmlInputText comp_claim_date) {
		COMP_CLAIM_DATE = comp_claim_date;
	}

	public HtmlOutputLabel getCOMP_CLAIM_DATE_LABEL() {
		return COMP_CLAIM_DATE_LABEL;
	}

	public void setCOMP_CLAIM_DATE_LABEL(HtmlOutputLabel comp_claim_date_label) {
		COMP_CLAIM_DATE_LABEL = comp_claim_date_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_NO_LABEL() {
		return COMP_UI_M_CLAIM_NO_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_NO_LABEL(HtmlOutputLabel comp_ui_m_claim_no_label) {
		COMP_UI_M_CLAIM_NO_LABEL = comp_ui_m_claim_no_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_AMOUNT_LABEL() {
		return COMP_UI_M_CLAIM_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_AMOUNT_LABEL(
			HtmlOutputLabel comp_ui_m_claim_amount_label) {
		COMP_UI_M_CLAIM_AMOUNT_LABEL = comp_ui_m_claim_amount_label;
	}

	public HtmlInputText getCOMP_CLAIM_AMOUNT() {
		return COMP_CLAIM_AMOUNT;
	}

	public void setCOMP_CLAIM_AMOUNT(HtmlInputText comp_claim_amount) {
		COMP_CLAIM_AMOUNT = comp_claim_amount;
	}

	public PT_IL_CLAIM getPTI_IL_CLAIM_BEAN() {
		return PTI_IL_CLAIM_BEAN;
	}

	public void setPTI_IL_CLAIM_BEAN(PT_IL_CLAIM pti_il_claim_bean) {
		PTI_IL_CLAIM_BEAN = pti_il_claim_bean;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public String getFilterByCLAIM_NO() {
		return filterByCLAIM_NO;
	}

	public void setFilterByCLAIM_NO(String filterByCLAIM_NO) {
		this.filterByCLAIM_NO = filterByCLAIM_NO;
	}

}
