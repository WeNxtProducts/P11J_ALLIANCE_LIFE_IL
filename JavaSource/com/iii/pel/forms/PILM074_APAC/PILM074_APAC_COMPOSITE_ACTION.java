package com.iii.pel.forms.PILM074_APAC;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILM074_APAC_COMPOSITE_ACTION extends CommonAction {
	
	private TabbedBar tabbedBar;
	
	private LifeTaxSetUpSearchPageActionBean searchPageActionBean;
	
	private PM_LIFE_TAX_HEADER_ACTION PM_LIFE_TAX_HEADER_ACTION_BEAN;
	
	private PM_LIFE_TAX_APPL_PROD_ACTION PM_LIFE_TAX_APPL_PROD_ACTION_BEAN;
	
	private PM_LIFE_TAX_APPL_CUST_ACTION PM_LIFE_TAX_APPL_CUST_ACTION_BEAN;
	
	public PILM074_APAC_COMPOSITE_ACTION(){
		
		tabbedBar = new TabbedBar();
		searchPageActionBean = new LifeTaxSetUpSearchPageActionBean();
		PM_LIFE_TAX_HEADER_ACTION_BEAN = new PM_LIFE_TAX_HEADER_ACTION();
		PM_LIFE_TAX_APPL_CUST_ACTION_BEAN = new PM_LIFE_TAX_APPL_CUST_ACTION();
		PM_LIFE_TAX_APPL_PROD_ACTION_BEAN = new PM_LIFE_TAX_APPL_PROD_ACTION();
		try{
			tabbedBar.addTab(1, "#{PILM074_APAC_COMPOSITE_ACTION.callTaxSetup}",Messages.getString("messageProperties_PILM074_APAC", "PILM074_APAC$PM_LIFE_TAX_APPL_CUST$Navigation$TaxSetup"), false);
			tabbedBar.addTab(2, "#{PILM074_APAC_COMPOSITE_ACTION.callApplicableProducts}",Messages.getString("messageProperties_PILM074_APAC", "PILM074_APAC$PM_LIFE_TAX_APPL_CUST$Navigation$ApplicableProd"), false);
			/*commented by senthilnathan as suggested by girish and siva on 13/10/19*/
			/*tabbedBar.addTab(3, "#{PILM074_APAC_COMPOSITE_ACTION.callApplicableClass}",Messages.getString("messageProperties_PILM074_APAC", "PILM074_APAC$PM_LIFE_TAX_APPL_CUST$Navigation$ApplicableClass"), false);*/
		}catch (Exception e) {
		}
		
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public LifeTaxSetUpSearchPageActionBean getSearchPageActionBean() {
		return searchPageActionBean;
	}

	public void setSearchPageActionBean(
			LifeTaxSetUpSearchPageActionBean searchPageActionBean) {
		this.searchPageActionBean = searchPageActionBean;
	}

	public PM_LIFE_TAX_HEADER_ACTION getPM_LIFE_TAX_HEADER_ACTION_BEAN() {
		return PM_LIFE_TAX_HEADER_ACTION_BEAN;
	}

	public void setPM_LIFE_TAX_HEADER_ACTION_BEAN(
			PM_LIFE_TAX_HEADER_ACTION pm_life_tax_header_action_bean) {
		PM_LIFE_TAX_HEADER_ACTION_BEAN = pm_life_tax_header_action_bean;
	}

	public PM_LIFE_TAX_APPL_PROD_ACTION getPM_LIFE_TAX_APPL_PROD_ACTION_BEAN() {
		return PM_LIFE_TAX_APPL_PROD_ACTION_BEAN;
	}

	public void setPM_LIFE_TAX_APPL_PROD_ACTION_BEAN(
			PM_LIFE_TAX_APPL_PROD_ACTION pm_life_tax_appl_prod_action_bean) {
		PM_LIFE_TAX_APPL_PROD_ACTION_BEAN = pm_life_tax_appl_prod_action_bean;
	}

	public PM_LIFE_TAX_APPL_CUST_ACTION getPM_LIFE_TAX_APPL_CUST_ACTION_BEAN() {
		return PM_LIFE_TAX_APPL_CUST_ACTION_BEAN;
	}

	public void setPM_LIFE_TAX_APPL_CUST_ACTION_BEAN(
			PM_LIFE_TAX_APPL_CUST_ACTION pm_life_tax_appl_cust_action_bean) {
		PM_LIFE_TAX_APPL_CUST_ACTION_BEAN = pm_life_tax_appl_cust_action_bean;
	}
	

	public String callTaxSetup() {
		String outcome = PILM074_APAC_CONSTANTS.HEADER_OUTCOME;
		return outcome;
	}
	
	public String callApplicableProducts() {
		PM_LIFE_TAX_APPL_PROD_ACTION_BEAN.onPageLoad();
		String outcome = PILM074_APAC_CONSTANTS.PRODUCT_OUTCOME;
		return outcome;
	}
	
	public String callApplicableClass() {
		PM_LIFE_TAX_APPL_CUST_ACTION_BEAN.onPageLoad();
		String outcome = PILM074_APAC_CONSTANTS.CUST_CLASS_OUTCOME;
		return outcome;
	}
	
	public String navigateToHeader() {
		String navigateToHeader = PILM074_APAC_CONSTANTS.NAVIGATE_TO_HEADER;
		return navigateToHeader;
	}
	
	public String navigateToProduct() {
		String navigateToProduct = PILM074_APAC_CONSTANTS.NAVIGATE_TO_PRODUCT;
		return navigateToProduct;
	}
	
	public String navigateToClass() {
		String navigateToClass = PILM074_APAC_CONSTANTS.NAVIGATE_TO_CLASS;
		return navigateToClass;
	}

}
