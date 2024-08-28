package com.iii.pel.forms.PILM074_APAC;

import java.util.ArrayList;

import com.iii.pel.forms.PILM031.PILM031_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class LifeTaxSetUpSearchPageActionBean extends CommonAction {

	private ArrayList<PM_LIFE_TAX_HEADER> searchList = new ArrayList<PM_LIFE_TAX_HEADER>();
	private String taxType;
	private String taxTypeDesc;

	private String taxTypeSearch;
	private String taxTypeDescSearch;

	public ArrayList<PM_LIFE_TAX_HEADER> getSearchList() {
		return searchList;
	}

	public void setSearchList(ArrayList<PM_LIFE_TAX_HEADER> searchList) {
		this.searchList = searchList;
	}

	public String searchedData() {
		PILM074_APAC_DELEGATE delegate = new PILM074_APAC_DELEGATE();
		searchList = delegate.fetchLifeTaxSearchDetails(this);
		System.out.println("Search List Size = " + searchList.size());
		if (searchList.size() == 0) {
			getWarningMap().put(
					"current",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"Search$NoRecord$Message"));
		} else {
			getWarningMap().clear();
		}
		return null;
	}

	/*public String redirectToLifeTax() throws Exception {
		PILM074_APAC_COMPOSITE_ACTION compsiteAction = new PILM074_APAC_COMPOSITE_ACTION();
		PM_LIFE_TAX_HEADER_ACTION headerAction = compsiteAction
				.getPM_LIFE_TAX_HEADER_ACTION_BEAN();
		CommonUtils.setGlobalObject("PILM074_APAC_COMPOSITE_ACTION",
				compsiteAction);
		headerAction.redirectToLifeTaxHead();
		return "PILM074_APAC_LIFE_TAX_HEADER";
	}*/

	public String insertNavigation() {
		PILM074_APAC_COMPOSITE_ACTION compsiteAction = new PILM074_APAC_COMPOSITE_ACTION();
		CommonUtils.setGlobalObject("PILM074_APAC_COMPOSITE_ACTION",
				compsiteAction);
		return "PILM074_APAC_LIFE_TAX_HEADER_INSERT";
	}

	/*
	 * public void searchPageDelete(ActionEvent event) throws Exception{ int
	 * deletedIndex = 0; int count = 0;
	 * 
	 * if(searchList != null){ for(int index = 0; index <
	 * searchList.size();index++){ LifeTaxSetUpSearchPageBean header =
	 * (LifeTaxSetUpSearchPageBean)searchList.get(index);
	 * if(header.isCheckBox()) { count=count+1; } } // System.out.println("No.of
	 * Fields selected for Deletion = "+count); int header = 0; for(int index =
	 * 0; index < searchList.size();){ LifeTaxSetUpSearchPageBean pageBean =
	 * (LifeTaxSetUpSearchPageBean)searchList.get(index);
	 * if(pageBean.isCheckBox()) { int temp = deleteFromHeader(pageBean);
	 * searchList.remove(pageBean); if(temp==1){ header++; } }else{ index++; } }
	 * getWarningMap().put("somekey", header+" records deleted.");
	 * getWarningMap().put("current", header+" records deleted."); } }
	 * 
	 * 
	 * public int deleteFromHeader(LifeTaxSetUpSearchPageBean bean) throws
	 * Exception{ // System.out.println("TAX TYPE = "+bean.getTH_TAX_TYPE());
	 * FacesContext ctx = FacesContext.getCurrentInstance(); Map<String,
	 * Object> sessionMap = ctx.getExternalContext().getSessionMap();
	 * 
	 * String TH_TAX_TYPE = bean.getTH_TAX_TYPE(); String query1 = "DELETE FROM
	 * PM_LIFE_TAX_APPL_CUST WHERE TAC_TH_TAX_TYPE = '"+TH_TAX_TYPE+"'"; String
	 * query2 = "DELETE FROM PM_LIFE_TAX_APPL_PROD WHERE TAP_TH_TAX_TYPE =
	 * '"+TH_TAX_TYPE+"'"; String query3 = "DELETE FROM PM_LIFE_TAX_HEADER WHERE
	 * TH_TAX_TYPE = '"+TH_TAX_TYPE+"'";
	 * 
	 * CRUDHandler handler = new CRUDHandler(); Connection con =
	 * getConnection();
	 * 
	 * int cust = handler.executeDeleteStatement(query1, con);
	 * System.out.println("No. of CUST Fields Deleted = "+cust);
	 * 
	 * int prod = handler.executeDeleteStatement(query2, con);
	 * System.out.println("No. of PROD Fields Deleted = "+prod);
	 * 
	 * int header = handler.executeDeleteStatement(query3, con);
	 * System.out.println("No. of HEADER Fields Deleted = "+header);
	 * 
	 * con.commit(); //con.close(); return header; }
	 */

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getTaxTypeDesc() {
		return taxTypeDesc;
	}

	public void setTaxTypeDesc(String taxTypeDesc) {
		this.taxTypeDesc = taxTypeDesc;
	}

	public String getTaxTypeSearch() {
		return taxTypeSearch;
	}

	public void setTaxTypeSearch(String taxTypeSearch) {
		this.taxTypeSearch = taxTypeSearch;
	}

	public String getTaxTypeDescSearch() {
		return taxTypeDescSearch;
	}

	public void setTaxTypeDescSearch(String taxTypeDescSearch) {
		this.taxTypeDescSearch = taxTypeDescSearch;
	}

	public String updateButtonAction(String rowId) {
		PILM074_APAC_COMPOSITE_ACTION compositeAction = new PILM074_APAC_COMPOSITE_ACTION();
		String outcome = null;
		try {
		PM_LIFE_TAX_HEADER_ACTION headerAction = compositeAction.getPM_LIFE_TAX_HEADER_ACTION_BEAN();
			CommonUtils.setGlobalObject("PILM074_APAC_COMPOSITE_ACTION",
					compositeAction);
			compositeAction.getPM_LIFE_TAX_HEADER_ACTION_BEAN().getPM_LIFE_TAX_HEADER_BEAN().setROWID(rowId);
			headerAction.redirectToLifeTaxHead(rowId);
			outcome = "PILM074_APAC_PM_LIFE_TAX_HEADER";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outcome;

	}

	public String insertButtonAction() {
		PILM074_APAC_COMPOSITE_ACTION compositeAction = new PILM074_APAC_COMPOSITE_ACTION();
		String outcome = null;
			CommonUtils.setGlobalObject("PILM074_APAC_COMPOSITE_ACTION",
					compositeAction);
			outcome = "PILM074_APAC_PM_LIFE_TAX_HEADER";
		return outcome;

	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}
}
