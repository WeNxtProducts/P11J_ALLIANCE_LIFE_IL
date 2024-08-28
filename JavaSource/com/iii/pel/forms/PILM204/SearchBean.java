package com.iii.pel.forms.PILM204;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

/**
 * Rajesh Kundala
 * 
 * @author 50180
 * 
 */
public class SearchBean {

	private String formulaCode;

	private String formula;

	private boolean selected;

	private List<PM_IL_FORMULA> formulaList = null;

	public String getFormulaCode() {
		return formulaCode;
	}

	public void setFormulaCode(String formulaCode) {
		this.formulaCode = formulaCode;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public List<PM_IL_FORMULA> getFormulaList() {
		return formulaList;
	}

	public void setFormulaList(List<PM_IL_FORMULA> formulaList) {
		this.formulaList = formulaList;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * This method is used to fetch a particular record/all records in database
	 * from pm_il_formula
	 * 
	 */
	public void fetchFormulaMasterDetails() {
		System.out.println("Inside fetch method");
		PM_IL_FORMULA_DELEGATE delegate = new PM_IL_FORMULA_DELEGATE();

		formulaList = delegate.prepareSearchList(this);

	}

	/**
	 * This Method is used to fetch records on formula master screen on clicking
	 * a particular code in search page
	 * 
	 * @return
	 */
	public String clearSearchPage() {

		formulaList = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest servletRequest = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession httpSession = servletRequest.getSession();
		String code = servletRequest.getParameter("Code");
		PM_IL_FORMULA_COMPOSITEBEAN compositeBean = new PM_IL_FORMULA_COMPOSITEBEAN();
		httpSession.setAttribute("PM_IL_FORMULA_COMPOSITEBEAN", compositeBean);
		PM_IL_FORMULA formulaBean = compositeBean.getPM_IL_FORMULA_ACTION()
				.getPM_IL_FORMULA_BEAN();
		formulaBean.setFRM_CODE(code);

		PM_IL_FORMULA_DELEGATE delegate = new PM_IL_FORMULA_DELEGATE();
		delegate.makeSearchList(compositeBean);
		String formulaScreen = "goToHeader";
		return formulaScreen;

	}

	public String goToEmptyFormulaMaster() {

		String name = "goToHeader";

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest servletRequest = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession httpSession = servletRequest.getSession();
		PM_IL_FORMULA_COMPOSITEBEAN compositeBean = new PM_IL_FORMULA_COMPOSITEBEAN();
		httpSession.setAttribute("PM_IL_FORMULA_COMPOSITEBEAN", compositeBean);
		return name;
	}
	
	public String preBack()
	{
		
		String actionClass = "formulaSearchBean";
		String actionMethod = "fetchFormulaMasterDetails";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
		System.out.println("goFormulaSearchPage");
		return "goFormulaSearchPage";
	}

	public String updateButtonAction(String rowId) {
		PM_IL_FORMULA_COMPOSITEBEAN compositeAction= new PM_IL_FORMULA_COMPOSITEBEAN();
		String outcome = null;
		CommonUtils.setGlobalObject("PM_IL_FORMULA_COMPOSITEBEAN",
				compositeAction);
		compositeAction.getPM_IL_FORMULA_ACTION().getPM_IL_FORMULA_BEAN().setROWID(rowId);
	
		outcome = "PILM204_PM_IL_FORMULA_NEW";
		return outcome;
    }

    public String insertButtonAction() {
    	PM_IL_FORMULA_COMPOSITEBEAN compositeAction = new PM_IL_FORMULA_COMPOSITEBEAN();
    	String outcome = null;
	
		CommonUtils.setGlobalObject("PM_IL_FORMULA_COMPOSITEBEAN",
				compositeAction);
		outcome = "PILM204_PM_IL_FORMULA_NEW";

		return outcome;
	
    }
	
    public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
    }

}
