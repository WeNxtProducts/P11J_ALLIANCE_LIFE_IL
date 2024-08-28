package com.iii.pel.forms.PILQ143;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PT005_A.POLICY_LEDGER_QUERY_SEARCH;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;


public class PS_IL_POL_NET_FUND_DTL_ACTION extends CommonAction{
	
	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;
	
	private HtmlInputText COMP_UI_M_POL_NO;
	
	private HtmlAjaxCommandButton COMP_UI_M_OK_BTN; 
	
	private PS_IL_POL_NET_FUND_DTL PS_IL_POL_NET_FUND_DTL_BEAN;
	
	private UIDataTable dataTable;
	
	private ArrayList<PS_IL_POL_NET_FUND_DTL> PS_IL_POL_NET_FUND_DTL_list = new ArrayList<PS_IL_POL_NET_FUND_DTL>();
	
	public PS_IL_POL_NET_FUND_DTL_ACTION() {
		// TODO Auto-generated constructor stub
		PS_IL_POL_NET_FUND_DTL_BEAN = new PS_IL_POL_NET_FUND_DTL();
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel cOMP_UI_M_POL_NO_LABEL) {
		COMP_UI_M_POL_NO_LABEL = cOMP_UI_M_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText cOMP_UI_M_POL_NO) {
		COMP_UI_M_POL_NO = cOMP_UI_M_POL_NO;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_OK_BTN() {
		return COMP_UI_M_OK_BTN;
	}

	public void setCOMP_UI_M_OK_BTN(HtmlAjaxCommandButton cOMP_UI_M_OK_BTN) {
		COMP_UI_M_OK_BTN = cOMP_UI_M_OK_BTN;
	}

	public PS_IL_POL_NET_FUND_DTL getPS_IL_POL_NET_FUND_DTL_BEAN() {
		return PS_IL_POL_NET_FUND_DTL_BEAN;
	}

	public void setPS_IL_POL_NET_FUND_DTL_BEAN(
			PS_IL_POL_NET_FUND_DTL pS_IL_POL_NET_FUND_DTL_BEAN) {
		PS_IL_POL_NET_FUND_DTL_BEAN = pS_IL_POL_NET_FUND_DTL_BEAN;
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PS_IL_POL_NET_FUND_DTL> getPS_IL_POL_NET_FUND_DTL_list() {
		return PS_IL_POL_NET_FUND_DTL_list;
	}

	public void setPS_IL_POL_NET_FUND_DTL_list(
			ArrayList<PS_IL_POL_NET_FUND_DTL> pS_IL_POL_NET_FUND_DTL_list) {
		PS_IL_POL_NET_FUND_DTL_list = pS_IL_POL_NET_FUND_DTL_list;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateUI_M_POL_NO(FacesContext context, 
			UIComponent component,Object value)  {
			try {
				PS_IL_POL_NET_FUND_DTL_BEAN.setUI_M_POL_NO((String)value);
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	}	
	
	public String fetchDataBaseDetails() {
		String qry = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ?";
		ResultSet sysIdRs =null;
		long polSysId = 0;
		try {
			sysIdRs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection(),
					new Object[]{PS_IL_POL_NET_FUND_DTL_BEAN.getUI_M_POL_NO()});
			if(sysIdRs.next()){
				polSysId = sysIdRs.getLong("POL_SYS_ID");
			}
			
			executeQuery(polSysId);
			
			getWarningMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Search Done Successfully");
			getWarningMap().put("UPDATE", "Search Done Successfully");
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Error While Search");
			getErrorMap().put("UPDATE", "Error While Search");
			
		}
		return "";
	}
	
	void executeQuery(Long POL_SYS_ID){
		String searchQry = "SELECT ROWID,TO_CHAR(TO_DATE(PNFD_DT,'DD-MM-RRRR'),'DD-MM-RRRR') FUND_DATE,PNFD_LC_PREM,PNFD_COI_VAL,PNFD_GROSS_CF_VAL,PFND_NEW_LC_SA,PNFD_NEW_COI_VAL,PNFD_NET_CF_VAL FROM PS_IL_POL_NET_FUND_DTL WHERE PNFD_POL_SYS_ID = ? ORDER BY PNFD_DT";
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			if(!PS_IL_POL_NET_FUND_DTL_list.isEmpty()){
				PS_IL_POL_NET_FUND_DTL_list.clear();
			}
			rs = new CRUDHandler().executeSelectStatement(searchQry, connection,new Object[]{POL_SYS_ID});
			PS_IL_POL_NET_FUND_DTL PS_IL_POL_NET_FUND_DTL_bean;
			while(rs.next()){
				PS_IL_POL_NET_FUND_DTL_bean = new PS_IL_POL_NET_FUND_DTL();
				/*PS_IL_POL_NET_FUND_DTL_bean.setPNFD_MONTH(rs.getInt("PNFD_MONTH"));*/
				PS_IL_POL_NET_FUND_DTL_bean.setUI_M_PNFD_DT(rs.getString("FUND_DATE"));
				PS_IL_POL_NET_FUND_DTL_bean.setPNFD_LC_PREM(rs.getDouble("PNFD_LC_PREM"));
				PS_IL_POL_NET_FUND_DTL_bean.setPNFD_COI_VAL(rs.getDouble("PNFD_COI_VAL"));
				PS_IL_POL_NET_FUND_DTL_bean.setPNFD_GROSS_CF_VAL(rs.getDouble("PNFD_GROSS_CF_VAL"));
				PS_IL_POL_NET_FUND_DTL_bean.setPFND_NEW_LC_SA(rs.getDouble("PFND_NEW_LC_SA"));
				PS_IL_POL_NET_FUND_DTL_bean.setPNFD_NEW_COI_VAL(rs.getDouble("PNFD_NEW_COI_VAL"));
				PS_IL_POL_NET_FUND_DTL_bean.setPNFD_NET_CF_VAL(rs.getDouble("PNFD_NET_CF_VAL"));
				
				PS_IL_POL_NET_FUND_DTL_list.add(PS_IL_POL_NET_FUND_DTL_bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_NO(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP014",
					"DUMMY", "M_POL_NO_FM", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
}
