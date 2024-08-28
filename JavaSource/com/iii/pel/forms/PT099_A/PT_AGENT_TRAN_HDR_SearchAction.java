package com.iii.pel.forms.PT099_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_TRAN_HDR_SearchAction  extends CommonAction{
	
	private UIData dataTable;
	ArrayList<PT_AGENT_TRAN_HDR> dataTableBean;
	private String ATH_AGENT_CODE;
	private String UI_M_ATH_POL_NO;
	private String ATH_NEW_AGENT_CODE;
	
	private String uiPolNo;
	private String agentCode;
	private String newAgentCode;

	public String insertInTranHeader() {
		System.out.println("iNSERT bUTTON CALLING ");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION compositeAction=new PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION();
		session.setAttribute("PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION", compositeAction);
		return "agentTranHeader";
	}

	public String fetch() {
		String outcome = null;
		PT099_A_SearchDelegate delegate = new PT099_A_SearchDelegate();
		
		try {
			System.out.println("pol No :"+getUI_M_ATH_POL_NO());
			dataTableBean = delegate.fetchMasterBlock(this);
			if(dataTableBean == null || dataTableBean.size() == 0){
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString("messageProperties", "Search$NoRecord$Message"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}

		//return dataTableBean;
		return outcome;
	}
	
	public String insertButtonAction() throws Exception {
		String outcome = null;
		try {
			
			PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION compositeAction = new PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION",
					compositeAction);
			outcome = "agentTranHeader";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;

	}
	
	public String updateButtonAction(String rowId) throws Exception {
		String outcome = null;
		try {
			PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION compositeAction = new PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION",
					compositeAction);
			compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN().setROWID(rowId);
			outcome = "agentTranHeader";

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;
	}


	public String fetchMasterRecord() {

		System.out.println("PM_IL_WDS_CHARGES_SETUP_SearchAction.fetchMasterRecord()------------------");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		String sysId =null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String query=null;
		CRUDHandler handler=new CRUDHandler();
		String rowId = request.getParameter("rowid");
		String polNo=request.getParameter("polno");
		System.out.println("ROWID :"+rowId);
		System.out.println("polno :"+polNo);
		PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION compositeAction=new PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION();
		PT_AGENT_TRAN_HDR_ACTION headerAction = compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN();
		
		PT_AGENT_TRAN_HDR pt_agent_tran_hdr = headerAction.getPT_AGENT_TRAN_HDR_BEAN();
		try {
			Connection connection=CommonUtils.getConnection();
			query="SELECT ROWID,PT_AGENT_TRAN_HDR.* FROM PT_AGENT_TRAN_HDR WHERE ROWID='"+rowId+"'";
			rs1=handler.executeSelectStatement(query, connection);
			if(rs1.next()){
				pt_agent_tran_hdr.setROWID(rs1.getString("ROWID"));
				
				pt_agent_tran_hdr.setATH_SYS_ID(rs1.getDouble("ATH_SYS_ID"));
				pt_agent_tran_hdr.setATH_AGENT_CODE(rs1.getString("ATH_AGENT_CODE"));
				pt_agent_tran_hdr.setATH_AGENT_RANK_CODE(rs1.getString("ATH_AGENT_RANK_CODE"));
				pt_agent_tran_hdr.setATH_PARENT_CODE(rs1.getString("ATH_PARENT_CODE"));
				pt_agent_tran_hdr.setATH_DATE(rs1.getDate("ATH_DATE"));
				pt_agent_tran_hdr.setATH_EFF_FM_DT(rs1.getDate("ATH_EFF_FM_DT"));
				pt_agent_tran_hdr.setATH_APPRV_FLAG(rs1.getString("ATH_APPRV_FLAG"));
				pt_agent_tran_hdr.setATH_TYPE(rs1.getString("ATH_TYPE"));
				pt_agent_tran_hdr.setATH_CR_DT(rs1.getDate("ATH_CR_DT"));
				pt_agent_tran_hdr.setATH_CR_UID(rs1.getString("ATH_CR_UID"));
				pt_agent_tran_hdr.setATH_UPD_DT(rs1.getDate("ATH_UPD_DT"));
				pt_agent_tran_hdr.setATH_UPD_UID(rs1.getString("ATH_UPD_UID"));
				pt_agent_tran_hdr.setATH_TERMINATION_TYPE(rs1.getString("ATH_TERMINATION_TYPE"));
				pt_agent_tran_hdr.setATH_AGENT_NEW_RANK_CODE(rs1.getString("ATH_AGENT_NEW_RANK_CODE"));
				pt_agent_tran_hdr.setATH_REVIEW1_DT(rs1.getDate("ATH_REVIEW1_DT"));
				pt_agent_tran_hdr.setATH_REVIEW2_DT(rs1.getDate("ATH_REVIEW2_DT"));
				pt_agent_tran_hdr.setATH_REVIEW3_DT(rs1.getDate("ATH_REVIEW3_DT"));
				pt_agent_tran_hdr.setATH_REVIEW4_DT(rs1.getDate("ATH_REVIEW4_DT"));
				pt_agent_tran_hdr.setATH_NEW_AGENT_CODE(rs1.getString("ATH_NEW_AGENT_CODE"));
				pt_agent_tran_hdr.setATH_POL_SYS_ID(rs1.getDouble("ATH_POL_SYS_ID"));
				
				pt_agent_tran_hdr.setATH_PRODN_TRANSFER_YN(rs1.getString("ATH_PRODN_TRANSFER_YN"));
				pt_agent_tran_hdr.setATH_FLEX_01(rs1.getString("ATH_FLEX_01"));
				pt_agent_tran_hdr.setATH_FLEX_02(rs1.getString("ATH_FLEX_02"));
				pt_agent_tran_hdr.setATH_FLEX_03(rs1.getString("ATH_FLEX_03"));
				pt_agent_tran_hdr.setATH_FLEX_04(rs1.getString("ATH_FLEX_04"));
				pt_agent_tran_hdr.setATH_FLEX_05(rs1.getString("ATH_FLEX_05"));
				
				/*Iterator itr=dataTableBean.iterator();
				boolean keepLooking = true;
				while(itr.hasNext() && keepLooking){
					PT_AGENT_TRAN_HDR pt_agent_tran_hdr2=(PT_AGENT_TRAN_HDR) itr.next();
					if(pt_agent_tran_hdr2.getROWID().equals(rowId)){
						System.out.println("pol no :"+pt_agent_tran_hdr2.getUI_M_ATH_POL_NO());
						pt_agent_tran_hdr.setUI_M_ATH_POL_NO(pt_agent_tran_hdr2.getUI_M_ATH_POL_NO());
						keepLooking = false;
					}
				}*/
				pt_agent_tran_hdr.setUI_M_ATH_POL_NO(polNo);
				
				headerAction.setCOMP_ATH_EFF_FM_DT(new HtmlCalendar());
				headerAction.getCOMP_ATH_EFF_FM_DT().setDisabled(true);
			}
			session.setAttribute("PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION", compositeAction);

			// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper- 2 
			
			// Setting components enable/disable
			if("A".equals(pt_agent_tran_hdr.getATH_APPRV_FLAG())){
				compositeAction.setRecordApproved(true);
			}else{
				compositeAction.setRecordApproved(false);
			}
			
			// Setting approval status
			headerAction.setApprovalStatus(pt_agent_tran_hdr.getATH_APPRV_FLAG());
			// Fetch selling agent name
			pt_agent_tran_hdr.setUI_M_ATH_AGENT_NAME(headerAction.fetchAgentNameForAgentCode(pt_agent_tran_hdr.getATH_AGENT_CODE()));
			// Fetch new agent name
			pt_agent_tran_hdr.setUI_M_ATH_NEW_AGENT_NAME(headerAction.fetchAgentNameForAgentCode(pt_agent_tran_hdr.getATH_NEW_AGENT_CODE()));

			// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper- 2 ] 
			
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "agentTranHeader";
	}
	
	
	public String deleteRecords(){
		PT_AGENT_TRAN_HDR deleteBean = null;
		int deletedRecordIndex = 0;
		if(dataTableBean.size()!=0){
			PT099_A_SearchDelegate delegate = new PT099_A_SearchDelegate();
			for(int i =0;i<dataTableBean.size();){
				deleteBean = (PT_AGENT_TRAN_HDR)dataTableBean.get(i);
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

	

/*	public void setSearchBean(PT_AGENT_TRAN_HDR searchBean) {
		this.searchBean = searchBean;
	}*/

	public void setDataTableBean(ArrayList<PT_AGENT_TRAN_HDR> dataTableBean) {
		this.dataTableBean = dataTableBean;
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
			e.printStackTrace();
		}
		return con;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	/*public PT_AGENT_TRAN_HDR getSearchBean() {
		return searchBean;
	}*/

	public ArrayList<PT_AGENT_TRAN_HDR> getDataTableBean() {
		return dataTableBean;
	}

	public String getATH_AGENT_CODE() {
		return ATH_AGENT_CODE;
	}

	public void setATH_AGENT_CODE(String ath_agent_code) {
		ATH_AGENT_CODE = ath_agent_code;
	}

	public String getUI_M_ATH_POL_NO() {
		System.out.println("getter UI_M_ATH_POL_NO :"+UI_M_ATH_POL_NO);
		return UI_M_ATH_POL_NO;
	}

	public void setUI_M_ATH_POL_NO(String ath_pol_no) {
		System.out.println("setter UI_M_ATH_POL_NO :"+ath_pol_no);
		UI_M_ATH_POL_NO = ath_pol_no;
	}

	public String getATH_NEW_AGENT_CODE() {
		return ATH_NEW_AGENT_CODE;
	}

	public void setATH_NEW_AGENT_CODE(String ath_new_agent_code) {
		ATH_NEW_AGENT_CODE = ath_new_agent_code;
	}

	public String getUiPolNo() {
		return uiPolNo;
	}

	public void setUiPolNo(String uiPolNo) {
		this.uiPolNo = uiPolNo;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getNewAgentCode() {
		return newAgentCode;
	}

	public void setNewAgentCode(String newAgentCode) {
		this.newAgentCode = newAgentCode;
	}
	
}
