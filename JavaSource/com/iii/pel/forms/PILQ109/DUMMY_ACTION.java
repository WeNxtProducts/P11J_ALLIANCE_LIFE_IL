package com.iii.pel.forms.PILQ109;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.UIDataTable;

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
public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_UI_M_HF_AMT_LABEL;

	private HtmlInputText COMP_UI_M_HF_AMT;

	private HtmlOutputLabel COMP_UI_M_HF_DATE_LABEL;

	private HtmlOutputText COMP_UI_M_TOTAL_HF_AMT;

	private HtmlCommandButton COMP_UI_M_BUT_QUERY;
	
	private String filterByCLAIM_NO;
	
	private String filterByCLAIM_DATE;
	
	private String filterByCLAIM_AMOUNT;
	
	private List<PT_IL_CLAIM> dataList = new ArrayList<PT_IL_CLAIM>();

	private DUMMY_HELPER DUMMY_HELPER;
	
	private PT_IL_CLAIM PT_IL_CLAIM_BEAN;

	private List<LovBean> suggestionList = null;
	
	private String POL_NO;
	
	private Double PT_HF_AMT; 

	public DUMMY_ACTION() throws Exception {
		DUMMY_HELPER = new DUMMY_HELPER();
		PT_IL_CLAIM_BEAN = new PT_IL_CLAIM();
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
	
	private UIDataTable dataTable;
	
	public void getDetails() {
		try {
			if (dataList.size() != 0) {
				PT_IL_CLAIM_BEAN = (PT_IL_CLAIM) dataTable.getRowData();
			}
			//resetAllComponents();
			PT_IL_CLAIM_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel comp_ui_m_pol_no_label) {
		COMP_UI_M_POL_NO_LABEL = comp_ui_m_pol_no_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText comp_ui_m_pol_no) {
		COMP_UI_M_POL_NO = comp_ui_m_pol_no;
	}

	public HtmlOutputLabel getCOMP_UI_M_HF_AMT_LABEL() {
		return COMP_UI_M_HF_AMT_LABEL;
	}

	public void setCOMP_UI_M_HF_AMT_LABEL(HtmlOutputLabel comp_ui_m_hf_amt_label) {
		COMP_UI_M_HF_AMT_LABEL = comp_ui_m_hf_amt_label;
	}

	public HtmlInputText getCOMP_UI_M_HF_AMT() {
		return COMP_UI_M_HF_AMT;
	}

	public void setCOMP_UI_M_HF_AMT(HtmlInputText comp_ui_m_hf_amt) {
		COMP_UI_M_HF_AMT = comp_ui_m_hf_amt;
	}

	public HtmlOutputLabel getCOMP_UI_M_HF_DATE_LABEL() {
		return COMP_UI_M_HF_DATE_LABEL;
	}

	public void setCOMP_UI_M_HF_DATE_LABEL(
			HtmlOutputLabel comp_ui_m_hf_date_label) {
		COMP_UI_M_HF_DATE_LABEL = comp_ui_m_hf_date_label;
	}

	public HtmlOutputText getCOMP_UI_M_TOTAL_HF_AMT() {
		return COMP_UI_M_TOTAL_HF_AMT;
	}

	public void setCOMP_UI_M_TOTAL_HF_AMT(HtmlOutputText comp_ui_m_total_hf_amt) {
		COMP_UI_M_TOTAL_HF_AMT = comp_ui_m_total_hf_amt;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_QUERY() {
		return COMP_UI_M_BUT_QUERY;
	}

	public void setCOMP_UI_M_BUT_QUERY(HtmlCommandButton comp_ui_m_but_query) {
		COMP_UI_M_BUT_QUERY = comp_ui_m_but_query;
	}

	public DUMMY_HELPER getDUMMY_HELPER() {
		return DUMMY_HELPER;
	}

	public void setDUMMY_HELPER(DUMMY_HELPER dummy_helper) {
		DUMMY_HELPER = dummy_helper;
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

	public List<PT_IL_CLAIM> getDataList() {
		return dataList;
	}

	public void setDataList(List<PT_IL_CLAIM> dataList) {
		this.dataList = dataList;
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public String getFilterByCLAIM_NO() {
		return filterByCLAIM_NO;
	}

	public void setFilterByCLAIM_NO(String filterByCLAIM_NO) {
		this.filterByCLAIM_NO = filterByCLAIM_NO;
	}

	public String getFilterByCLAIM_DATE() {
		return filterByCLAIM_DATE;
	}

	public void setFilterByCLAIM_DATE(String filterByCLAIM_DATE) {
		this.filterByCLAIM_DATE = filterByCLAIM_DATE;
	}

	public String getFilterByCLAIM_AMOUNT() {
		return filterByCLAIM_AMOUNT;
	}

	public void setFilterByCLAIM_AMOUNT(String filterByCLAIM_AMOUNT) {
		this.filterByCLAIM_AMOUNT = filterByCLAIM_AMOUNT;
	}

}
