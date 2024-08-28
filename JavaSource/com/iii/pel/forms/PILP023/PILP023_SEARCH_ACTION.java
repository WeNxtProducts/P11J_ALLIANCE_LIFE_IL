package com.iii.pel.forms.PILP023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;

public class PILP023_SEARCH_ACTION {

	private HtmlOutputLabel COMP_CBH_POL_NO_LABEL;

	private HtmlInputText COMP_CBH_POL_NO;

	private HtmlOutputLabel COMP_UI_M_TXN_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TXN_TYPE_DESC;

	private HtmlCommandButton COMP_CLAIM_SEARCH_BUTTON;

	private HtmlCommandButton COMP_M_PRE_FORM_BUTTON;

	private UIData COMP_PT_IL_BOUNCE_SEARCH_DATATABLE;

	private PT_IL_CHEQUE_BOUNCE_HDR BOUNCE_BEAN;

	private PILP023_SEARCH SEARCH_BEAN;

	private List<PT_IL_CHEQUE_BOUNCE_HDR> PT_IL_CHEQUE_BOUNCE_HDR_LIST;

	public PILP023_SEARCH_ACTION() {
		BOUNCE_BEAN = new PT_IL_CHEQUE_BOUNCE_HDR();
		SEARCH_BEAN = new PILP023_SEARCH();

	}

	public List<PT_IL_CHEQUE_BOUNCE_HDR> getPT_IL_CHEQUE_BOUNCE_HDR_LIST() {
		return PT_IL_CHEQUE_BOUNCE_HDR_LIST;
	}

	public void setPT_IL_CHEQUE_BOUNCE_HDR_LIST(
			List<PT_IL_CHEQUE_BOUNCE_HDR> pt_il_cheque_bounce_hdr_list) {
		PT_IL_CHEQUE_BOUNCE_HDR_LIST = pt_il_cheque_bounce_hdr_list;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_NO_LABEL() {
		return COMP_CBH_POL_NO_LABEL;
	}

	public void setCOMP_CBH_POL_NO_LABEL(HtmlOutputLabel comp_cbh_pol_no_label) {
		COMP_CBH_POL_NO_LABEL = comp_cbh_pol_no_label;
	}

	public HtmlInputText getCOMP_CBH_POL_NO() {
		return COMP_CBH_POL_NO;
	}

	public void setCOMP_CBH_POL_NO(HtmlInputText comp_cbh_pol_no) {
		COMP_CBH_POL_NO = comp_cbh_pol_no;
	}

	public HtmlOutputLabel getCOMP_UI_M_TXN_TYPE_DESC_LABEL() {
		return COMP_UI_M_TXN_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_TXN_TYPE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_txn_type_desc_label) {
		COMP_UI_M_TXN_TYPE_DESC_LABEL = comp_ui_m_txn_type_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_TXN_TYPE_DESC() {
		return COMP_UI_M_TXN_TYPE_DESC;
	}

	public void setCOMP_UI_M_TXN_TYPE_DESC(HtmlInputText comp_ui_m_txn_type_desc) {
		COMP_UI_M_TXN_TYPE_DESC = comp_ui_m_txn_type_desc;
	}

	public HtmlCommandButton getCOMP_CLAIM_SEARCH_BUTTON() {
		return COMP_CLAIM_SEARCH_BUTTON;
	}

	public void setCOMP_CLAIM_SEARCH_BUTTON(
			HtmlCommandButton comp_claim_search_button) {
		COMP_CLAIM_SEARCH_BUTTON = comp_claim_search_button;
	}

	public HtmlCommandButton getCOMP_M_PRE_FORM_BUTTON() {
		return COMP_M_PRE_FORM_BUTTON;
	}

	public void setCOMP_M_PRE_FORM_BUTTON(
			HtmlCommandButton comp_m_pre_form_button) {
		COMP_M_PRE_FORM_BUTTON = comp_m_pre_form_button;
	}

	public PT_IL_CHEQUE_BOUNCE_HDR getBOUNCE_BEAN() {
		return BOUNCE_BEAN;
	}

	public void setBOUNCE_BEAN(PT_IL_CHEQUE_BOUNCE_HDR bounce_bean) {
		BOUNCE_BEAN = bounce_bean;
	}

	public PILP023_SEARCH getSEARCH_BEAN() {
		return SEARCH_BEAN;
	}

	public void setSEARCH_BEAN(PILP023_SEARCH search_bean) {
		SEARCH_BEAN = search_bean;
	}

	public void onLoad() throws DBException {
		getCOMP_M_PRE_FORM_BUTTON().setDisabled(true);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		sessionMap.put("PILP023_COMPOSITE_ACTION",
				new PILP023_COMPOSITE_ACTION());
	}

	public UIData getCOMP_PT_IL_BOUNCE_SEARCH_DATATABLE() {
		return COMP_PT_IL_BOUNCE_SEARCH_DATATABLE;
	}

	public void setCOMP_PT_IL_BOUNCE_SEARCH_DATATABLE(
			UIData comp_pt_il_bounce_search_datatable) {
		COMP_PT_IL_BOUNCE_SEARCH_DATATABLE = comp_pt_il_bounce_search_datatable;
	}

	public ArrayList<PT_IL_CHEQUE_BOUNCE_HDR> fetchChequeBounceDetails(
			FacesContext context) {
		// PILP023_SEARCH_ACTION bounceAction = getCurrentActionInstance();
		PILP023_SEARCH bounceBean = this.getSEARCH_BEAN();
		Connection connection = null;
		String initPolNo = null;
		String initTxnNo = null;
		ArrayList<PT_IL_CHEQUE_BOUNCE_HDR> list = null;
		@SuppressWarnings("unused")
		boolean codeFlag = false;

		String query = "SELECT PT_IL_CHEQUE_BOUNCE_HDR.ROWID, CBH_POL_NO,CBH_SYS_ID, CBH_TXN_TYPE, CBH_POL_ISSUE_DT FROM PT_IL_CHEQUE_BOUNCE_HDR";

		if (bounceBean != null) {
			initPolNo = bounceBean.getInitPolNo();
			initTxnNo = bounceBean.getInitTxnType();
			if (initPolNo != null && initPolNo.trim().length() > 0) {
				query = query + "WHERE UPPER(CBH_POL_NO) LIKE '"
						+ initPolNo.toString().toUpperCase() + "%'";
				codeFlag = true;
			}
			if (initTxnNo != null && initTxnNo.trim().length() > 0) {
				if (codeFlag) {
					query = query + "AND CBH_TXN_TYPE LIKE '"
							+ initTxnNo.toString().toUpperCase() + "'";
				} else {
					query = query + "WHERE CBH_TXN_TYPE LIKE '"
							+ initTxnNo.toString().toUpperCase() + "'";
				}
			}
		}
		try {
			connection = CommonUtils.getConnection();
			if (connection != null) {
				CRUDHandler handler = new CRUDHandler();
				ResultSet resultSet = handler.executeSelectStatement(query,
						connection);
				list = new ArrayList<PT_IL_CHEQUE_BOUNCE_HDR>();
				PT_IL_CHEQUE_BOUNCE_HDR details = null;
				while (resultSet.next()) {
					details = new PT_IL_CHEQUE_BOUNCE_HDR();
					details.setROWID(resultSet.getString(1));
					details.setCBH_POL_NO(resultSet.getString("CBH_POL_NO"));
					details
							.setCBH_TXN_TYPE(resultSet
									.getString("CBH_TXN_TYPE"));
					details.setCBH_POL_ISSUE_DT(resultSet
							.getDate("CBH_POL_ISSUE_DT"));
					details.setCBH_SYS_ID(resultSet.getDouble("CBH_SYS_ID"));
					list.add(details);

				}
			}

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public PILP023_SEARCH_ACTION getCurrentActionInstance() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		return (PILP023_SEARCH_ACTION) sessionMap.get("PILP023_SEARCH_ACTION");
	}

	public void fetchRecords() {
		ArrayList<PT_IL_CHEQUE_BOUNCE_HDR> chequeDetails = fetchChequeBounceDetails(FacesContext
				.getCurrentInstance());
		setPT_IL_CHEQUE_BOUNCE_HDR_LIST(chequeDetails);
	}

	public List<PT_IL_CHEQUE_BOUNCE_HDR> fetchChequeMaster(String sysId,
			Object object) {
		PT_IL_CHEQUE_BOUNCE_HDR chequeBounceHdr = (PT_IL_CHEQUE_BOUNCE_HDR) object;
		Connection connection = null;
		PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = null;
		List<PT_IL_CHEQUE_BOUNCE_HDR> hdrList = new ArrayList<PT_IL_CHEQUE_BOUNCE_HDR>();
		try {

			String query = "SELECT CBH_POL_NO, CBH_POL_CONT_NAME, CBH_POL_ISSUE_DT,"
					+ " CBH_POL_START_DT,CBH_POL_EXPIRY_DT,"
					+ " CBH_POL_PROD_CODE, CBH_TXN_TYPE, CBH_SYS_ID"
					+ " FROM PT_IL_CHEQUE_BOUNCE_HDR WHERE CBH_SYS_ID = '"
					+ sysId + "'";

			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = handler.executeSelectStatement(query,
					connection);

			while (resultSet.next()) {
				helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
				chequeBounceHdr
						.setCBH_SYS_ID(resultSet.getDouble("CBH_SYS_ID"));
				chequeBounceHdr
						.setCBH_POL_NO(resultSet.getString("CBH_POL_NO"));
				chequeBounceHdr.setCBH_POL_CONT_NAME(resultSet
						.getString("CBH_POL_CONT_NAME"));
				chequeBounceHdr.setCBH_POL_ISSUE_DT(resultSet
						.getDate("CBH_POL_ISSUE_DT"));
				chequeBounceHdr.setCBH_POL_START_DT(resultSet
						.getDate("CBH_POL_START_DT"));
				chequeBounceHdr.setCBH_POL_EXPIRY_DT(resultSet
						.getDate("CBH_POL_EXPIRY_DT"));
				chequeBounceHdr.setCBH_POL_PROD_CODE(resultSet
						.getString("CBH_POL_PROD_CODE"));
				chequeBounceHdr.setCBH_TXN_TYPE(resultSet
						.getString("CBH_TXN_TYPE"));
				
				chequeBounceHdr.setUI_M_TXN_TYPE_DESC(helper.pilp023_pt_il_cheque_bounce_hdr_post_query(resultSet
						.getString("CBH_TXN_TYPE")));
				
				hdrList.add(chequeBounceHdr);
			}
			

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hdrList;
	}

	public String clearList() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PT_IL_CHEQUE_BOUNCE_HDR_ACTION searchAction = ((PILP023_COMPOSITE_ACTION) session
				.getAttribute("PILP023_COMPOSITE_ACTION"))
				.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();

		String sysId = request.getParameter("cbhSysID");
		String returnStr = "chequeBounce";

		List<PT_IL_CHEQUE_BOUNCE_HDR> list = fetchChequeMaster(sysId,
				searchAction.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN());
		searchAction.setDataList(list);
		// searchAction.setPT_IL_CHEQUE_BOUNCE_HDR_BEAN(chequeBean);
		searchAction.setSearchMode(true);
		this.PT_IL_CHEQUE_BOUNCE_HDR_LIST = null;

		return returnStr;
	}

	public String CBHInsert() {
		return "chequeBounce";
	}

/*Added by Ram on 25/12/2016 for SsaerchPage Concept*/
	public String updateButtonAction(String rowId) throws Exception {
		System.out.println("eNTER");
		PILP023_COMPOSITE_ACTION compositeAction = new PILP023_COMPOSITE_ACTION();
		compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getErrorMap().clear();
		compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getWarningMap().clear();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext()
			.getRequestParameterMap();
	
		CommonUtils.setGlobalObject("PILP023_COMPOSITE_ACTION",
			compositeAction);
		compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN()
			.setROWID(rowId);
	
		outcome = "PILP023_MAIN";
		return outcome;
    }

    public String insertButtonAction() throws Exception {
    	System.out.println("Enter into insertButtonAction");
    	PILP023_COMPOSITE_ACTION compositeAction = new PILP023_COMPOSITE_ACTION();
		compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getErrorMap().clear();
		compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getWarningMap().clear();
		String outcome = null;
		CommonUtils.setGlobalObject("PILP023_COMPOSITE_ACTION",
			compositeAction);
		outcome = "PILP023_MAIN";
		CommonUtils.clearMaps(compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION());
		return outcome;
	
	    }
	
	    public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	    
	    public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
	    	int whereIndex = query.indexOf("WHERE")+6;
	    	System.out.println("query    "+query+"     whereIndex   "+whereIndex);
	    	query.insert(whereIndex, "");
	    	
	    	return query;
	    }
	    
	    /*End*/

}
