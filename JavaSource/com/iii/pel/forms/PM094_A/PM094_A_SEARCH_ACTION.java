package com.iii.pel.forms.PM094_A;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;



public class PM094_A_SEARCH_ACTION extends CommonAction {
	
	ArrayList<PM_AGENT_BONUS_SETUP> agentList;
	
	private int recordPerPage = 10;
	private int currPage = 1;
	
	private String searchBonusCode;
	private String searchBonusType;
	private String filterAbs_code;
	private String filterAbs_desc;
	private String filterAbs_bonus_type;
	
	private void clearMaps(){
		getWarningMap().clear();
		getErrorMap().clear();
	}

	public ArrayList<PM_AGENT_BONUS_SETUP> getAgentList() {
		return agentList;
	}

	public void setAgentList(ArrayList<PM_AGENT_BONUS_SETUP> agentList) {
		this.agentList = agentList;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String getSearchBonusCode() {
		return searchBonusCode;
	}

	public void setSearchBonusCode(String searchBonusCode) {
		this.searchBonusCode = searchBonusCode;
	}

	public String getSearchBonusType() {
		return searchBonusType;
	}

	public void setSearchBonusType(String searchBonusType) {
		this.searchBonusType = searchBonusType;
	}

	public String getFilterAbs_code() {
		return filterAbs_code;
	}

	public void setFilterAbs_code(String filterAbs_code) {
		this.filterAbs_code = filterAbs_code;
	}

	public String getFilterAbs_desc() {
		return filterAbs_desc;
	}

	public void setFilterAbs_desc(String filterAbs_desc) {
		this.filterAbs_desc = filterAbs_desc;
	}

	public String getFilterAbs_bonus_type() {
		return filterAbs_bonus_type;
	}

	public void setFilterAbs_bonus_type(String filterAbs_bonus_type) {
		this.filterAbs_bonus_type = filterAbs_bonus_type;
	}
	
	public ArrayList<PM_AGENT_BONUS_SETUP> searchAgentBonus(){
		String message = null;
		PM_AGENT_BONUS_SETUP_DELEGATE delegate=new PM_AGENT_BONUS_SETUP_DELEGATE();
		// Set current page = 1 for new Search 
		currPage=1;
		// Clear error/warning maps
		clearMaps();
		try {
			agentList=delegate.searchAgentBonusSetupRecord(searchBonusCode,searchBonusType);
			
			if(agentList == null || agentList.size()<1){
				message = Messages.getString(PELConstants.pelMessagePropertiesPath, "Search$NoRecord$Message");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
			}
		} catch(Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		}
		
		return agentList;
		
	}
	
	public String fetchAgentBonusDetails(){
		String message = null;
		PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction=new PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION();
		
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN();
		
		PM_AGENT_BONUS_SETUP_DELEGATE delegate=new PM_AGENT_BONUS_SETUP_DELEGATE();
		
		PM_AGENT_BONUS_SETUP_HELPER pm_agent_bonus_setup_helper=new PM_AGENT_BONUS_SETUP_HELPER();
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		String rowId = request.getParameter("rowid");
		System.out.println("Row Id :"+rowId);
		System.out.println("Agent List :"+this.agentList);
		
		try {
			pm_agent_bonus_setup_helper.when_new_record_instance(compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN());
			//delegate.fetchAgentBonusSetupDetails(rowId,pm_agent_bonus_setup);
			pm_agent_bonus_setup_helper.post_query(pm_agent_bonus_setup);
		}catch(Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		}
		session.setAttribute("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION", compositeAction);
		return "agentbonussetup";
		
	}
	
	public String createNewAgentBonusSetup(){
		PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction=new PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION();
		HttpSession session=(HttpSession)(FacesContext.getCurrentInstance().getExternalContext().getSession(true));
		session.setAttribute("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION",compositeAction);
		PM_AGENT_BONUS_SETUP_HELPER pm_agent_bonus_setup_helper=new PM_AGENT_BONUS_SETUP_HELPER();
		try
		{
			pm_agent_bonus_setup_helper.when_create_record(compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String outcome = "agentbonussetup";
		return outcome;
	}
	
	public String updateButtonAction(String rowId) {
		PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction= new PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION",
				compositeAction);
		compositeAction.getPM_AGENT_BONUS_SETUP_ACTION_BEAN().getPM_AGENT_BONUS_SETUP_BEAN().setROWID(rowId);
	
		outcome = "agentbonussetup";
		return outcome;
    }

    public String insertButtonAction() {
    	PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION compositeAction = new PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION();
    	String outcome = null;
	
		CommonUtils.setGlobalObject("PM094_A_PM_AGENT_BONUS_COMPOSITE_ACTION",
				compositeAction);
		outcome = "agentbonussetup";

		return outcome;
	
    }
	
}
