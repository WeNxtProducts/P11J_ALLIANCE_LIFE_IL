package com.iii.pel.forms.PILM015_APAC;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class SearchValueBean extends CommonAction{

	private String intiTreatyCode;
	private String initUwYear;
	private ArrayList<PM_IL_PROP_TREATY> treatyDetailsList = null;
	private PM_IL_PROP_TREATY name;
	private ArrayList<Integer> deleteMasterList=new ArrayList<Integer>();

	public ArrayList<Integer> getDeleteMasterList() {
		return deleteMasterList;
	}

	public void setDeleteMasterList(ArrayList<Integer> deleteMasterList) {
		this.deleteMasterList = deleteMasterList;
	}

	public String fetchDetails() {

		try {
			System.out.println("Called Fetched Details");
			treatyDetailsList = new SearchHelperClass()
					.fetchSearchDetails(this);
		} catch (Exception exception) {

		}
		return null;
	}

	public String getIntiTreatyCode() {
		return intiTreatyCode;
	}

	public void setIntiTreatyCode(String intiTreatyCode) {
		this.intiTreatyCode = intiTreatyCode;
	}

	public ArrayList<PM_IL_PROP_TREATY> getTreatyDetailsList() {
		return treatyDetailsList;
	}

	public void setTreatyDetailsList(
			ArrayList<PM_IL_PROP_TREATY> treatyDetailsList) {
		this.treatyDetailsList = treatyDetailsList;
	}

	public String getInitUwYear() {
		return initUwYear;
	}

	public void setInitUwYear(String initUwYear) {
		this.initUwYear = initUwYear;
	}

	public PM_IL_PROP_TREATY getName() {
		return name;
	}

	public void setName(PM_IL_PROP_TREATY name) {
		this.name = name;
	}

	public String clearList() {
		treatyDetailsList = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String treatycode = req.getParameter("treatyCode");
		System.out.println("TREAT CODE "+treatycode);
		prepareTreatyMasterDetails(treatycode);
		String returnStr = "TreatyMaster";
		return returnStr;
	}

	public String clearSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("PM_IL_PROP_TREATY_ACTION") != null) {
			session.removeAttribute("PM_IL_PROP_TREATY_ACTION");
		}
		
		return "TreatyMaster";
	}

	public Object prepareTreatyMasterDetails(String code) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_PROP_TREATY_ACTION pi_lm_action = new PM_IL_PROP_TREATY_ACTION();
		PM_IL_PROP_TREATY_COMPOSITE_ACTION Pm_il_prop_treaty_composite_action=new PM_IL_PROP_TREATY_COMPOSITE_ACTION();
		session.setAttribute("PM_IL_PROP_TREATY_COMPOSITE_ACTION",Pm_il_prop_treaty_composite_action);
		Pm_il_prop_treaty_composite_action.getPM_IL_PROP_TREATY_ACTION().setUpdate(true);
		PM_IL_PROP_TREATY treaty_class=Pm_il_prop_treaty_composite_action.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN();
		treaty_class.setPT_TREATY_CODE(code);
		new SearchHelperClass().TreatyMasterDetails(treaty_class);
		PM_IL_PROP_TREATY_MASTER_HELPER helper=new PM_IL_PROP_TREATY_MASTER_HELPER();
		try {
			helper.pilm015_apac_pm_il_prop_treaty_post_query(Pm_il_prop_treaty_composite_action);
			System.out.println("Currency Description :"+treaty_class.getUI_M_CURR_DESC());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String preBack()
	{
		
		String actionClass = "ValueBean";
		String actionMethod = "fetchDetails";
//		String returnString= "goToPropTreatySearchPage";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
		System.out.println("** Return String :*"+"goToPropTreatySearchPage");
		return "goToPropTreatySearchPage";
	}
	
	
	public String goToTreatyMaster() throws DBException, SQLException,Exception{
		String returnStr = "TreatyMasterRi";
		this.treatyDetailsList = null;

		// Set the action of next page
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_PROP_TREATY_COMPOSITE_ACTION pm_il_prop_treaty_composite_action = new PM_IL_PROP_TREATY_COMPOSITE_ACTION();
		pm_il_prop_treaty_composite_action.getPM_IL_PROP_TREATY_ACTION().setUpdate(false);
		session.setAttribute("PM_IL_PROP_TREATY_COMPOSITE_ACTION", pm_il_prop_treaty_composite_action);
		return returnStr;
	}
	
	public String updateButtonAction(String rowId) {
		PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction= new PM_IL_PROP_TREATY_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM_IL_PROP_TREATY_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN().setROWID(rowId);
	
		outcome = "TreatyMaster";
		return outcome;
    }

    public String insertButtonAction() {
    	PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction = new PM_IL_PROP_TREATY_COMPOSITE_ACTION();
    	String outcome = null;
	
		CommonUtils.setGlobalObject("PM_IL_PROP_TREATY_COMPOSITE_ACTION",
				compositeAction);
		outcome = "TreatyMaster";

		return outcome;
	
    }
	
}
