package com.iii.pel.forms.PM091_A;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BENEFIT_HDR_SearchAction {

	private UIInput uiBenefitCode;
	private UIInput uiDescription;
	private UIInput uiBenefitType;
	private UIData dataTable;
	private PM_AGENT_BENEFIT_HDR searchBean;
	private List<PM_AGENT_BENEFIT_HDR> dataTableBean;

	public PM_AGENT_BENEFIT_HDR_SearchAction() {
		searchBean = new PM_AGENT_BENEFIT_HDR();
	}

	public String insert() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION") != null) {
			session.removeAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
		}
		if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_DTL_ACTION") != null) {
			session.removeAttribute("PM091_A_PM_AGENT_BENEFIT_DTL_ACTION");
		}
		if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_RANK_ACTION") != null) {
			session.removeAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_RANK_ACTION");
		}
		if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_PROD_ACTION") != null) {
			session.removeAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_PROD_ACTION");
		}
		
		Map sessionMap = context.getExternalContext().getSessionMap();
		sessionMap.put("CURRENT_MODE", "INSERT");
		sessionMap.put("CLIENT_CON", getConnection());
		return "masterblock";
	}

	public String fetch() {
		PM091_A_SearchDelegate delegate = new PM091_A_SearchDelegate();
		this.dataTableBean = delegate.fetchMasterBlock(this);

		return null;
	}
	
	public String fetchMasterRecord() {

		System.out.println("PM_IL_WDS_CHARGES_SETUP_SearchAction.fetchMasterRecord()------------------");
		FacesContext context = FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		String benefitCode = (String) map.get("ABH_BNF_CODE");
		String description = (String) map.get("ABH_DESC");
		String benefitType = (String) map.get("ABH_BNF_TYPE");
		String rowId = (String) map.get("ROWID");
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		//PM_AGENT_BENEFIT_HDR_ACTION sessionBean = (PM_AGENT_BENEFIT_HDR_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
		try {
			String selectQuery = "select ROWID, PM_AGENT_BENEFIT_HDR.* FROM  PM_AGENT_BENEFIT_HDR where ROWID='"
					+ rowId
					+ "'and "
					+ "ABH_BNF_CODE='"
					+ benefitCode
					+ "'and  ABH_DESC='"
					+ description
					+ "'and ABH_BNF_TYPE='"
					+ benefitType + "'";
			System.out
					.println("PM_AGENT_PF_COMP_CONT_SearchAction.fetchMasterRecord()---["
							+ selectQuery + "]");

			List list = getHandler().fetch(selectQuery,"com.iii.pel.forms.PM091_A.PM_AGENT_BENEFIT_HDR",
					getConnection());
			PM_AGENT_BENEFIT_HDR valueBean=(PM_AGENT_BENEFIT_HDR)list.get(0);


			//PM_AGENT_BENEFIT_HDR_ACTION actionBean = (PM_AGENT_BENEFIT_HDR_ACTION) resolver
					//.getValue(context.getELContext(), null,
						//	"PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
		
			// valueBean.setUI_M_APCC_MKT_CODE_DESC(getCodeDesc(actionBean,valueBean,"MKTCODE"));
			// valueBean.setUI_M_APCC_RANK_CODE_DESC(getCodeDesc(actionBean,valueBean,"AGNRANK"));
			 //actionBean.setPM_AGENT_BENEFIT_HDR_BEAN(valueBean);
			Map sessionMap = context.getExternalContext().getSessionMap();
			sessionMap.put("CURRENT_MODE", "UPDATE");
			sessionMap.put("CLIENT_CON", getConnection());
			//actionBean.setUpdate(true);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return "masterblock";
	}
	
	
	public String deleteRecords(){
		PM_AGENT_BENEFIT_HDR deleteBean = null;
		int deletedRecordIndex = 0;
		if(dataTableBean.size()!=0){
			PM091_A_SearchDelegate delegate = new PM091_A_SearchDelegate();
			for(int i =0;i<dataTableBean.size();){
				deleteBean = (PM_AGENT_BENEFIT_HDR)dataTableBean.get(i);
				if(deleteBean.isSelected()){
					dataTableBean.remove(deleteBean);
					deletedRecordIndex = delegate .deleteData(deleteBean);
				}else{
					i++;
				}
			}
			
		}
		
		
		
		return null;
	}

	public UIInput getUiBenefitCode() {
		return uiBenefitCode;
	}

	public void setUiBenefitCode(UIInput uiBenefitCode) {
		this.uiBenefitCode = uiBenefitCode;
	}

	public UIInput getUiDescription() {
		return uiDescription;
	}

	public void setUiDescription(UIInput uiDescription) {
		this.uiDescription = uiDescription;
	}

	public UIInput getUiBenefitType() {
		return uiBenefitType;
	}

	public void setUiBenefitType(UIInput uiBenefitType) {
		this.uiBenefitType = uiBenefitType;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	// ***************************UTIL*********************************************

	public Connection getConnection() {
		Connection con = null;
		
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public PM_AGENT_BENEFIT_HDR getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(PM_AGENT_BENEFIT_HDR searchBean) {
		this.searchBean = searchBean;
	}

	public List<PM_AGENT_BENEFIT_HDR> getDataTableBean() {
		return dataTableBean;
	}

	public void setDataTableBean(List<PM_AGENT_BENEFIT_HDR> dataTableBean) {
		this.dataTableBean = dataTableBean;
	}

}
