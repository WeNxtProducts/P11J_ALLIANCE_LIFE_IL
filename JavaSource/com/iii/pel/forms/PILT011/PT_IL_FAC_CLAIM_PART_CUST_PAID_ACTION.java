package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_FCPCP_CUST_CODE_LABEL;

	private HtmlInputText COMP_FCPCP_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_SHARE_PERC_LABEL;

	private HtmlInputText COMP_UI_M_SHARE_PERC;

	private HtmlOutputLabel COMP_FCPCP_FC_CLM_PAID_LABEL;

	private HtmlInputText COMP_FCPCP_FC_CLM_PAID;

	private HtmlOutputLabel COMP_UI_M_RETRO_PERC_LABEL;
	
	private HtmlInputText COMP_UI_M_RETRO_PERC;

	private HtmlOutputLabel COMP_FCPCP_RETRO_FC_CLM_PAID_LABEL;

	private HtmlInputText COMP_FCPCP_RETRO_FC_CLM_PAID;

	private HtmlOutputLabel COMP_FCPCP_LC_CLM_PAID_LABEL;

	private HtmlInputText COMP_FCPCP_LC_CLM_PAID;

	private HtmlOutputLabel COMP_FCPCP_RETRO_LC_CLM_PAID_LABEL;

	private HtmlInputText COMP_FCPCP_RETRO_LC_CLM_PAID;
	
	private UIDataTable dataTable;
	
	private List<PT_IL_FAC_CLAIM_PART_CUST_PAID>  claimPaidCustList= new ArrayList<PT_IL_FAC_CLAIM_PART_CUST_PAID>();

	private PT_IL_FAC_CLAIM_PART_CUST_PAID PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN;
	private CRUDHandler handler = null;
	private Connection connection = null;
	private ResultSet resultSet = null;
	private Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	private String filterByFCPCP_CUST_CODE;
	
	private String filterByUI_M_SHARE_PERC;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private int lastUpdatedRowIndex = 0;
	
	private int prevRowIndex = 0;
	
	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
	
	public PILT011_COMPOSITE_ACTION compositeAction;
	
	public PT_IL_FAC_CLAIM_PART_CUST_PAID_ACTION() {
		PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN = new PT_IL_FAC_CLAIM_PART_CUST_PAID();
		handler = new CRUDHandler();
		//getPT_IL_FAC_CLAIM_PAID_Dtls();
		//PT_IL_FAC_CLAIM_PART_CUST_PAID_POST_QUERY();
	}

	public HtmlOutputLabel getCOMP_FCPCP_CUST_CODE_LABEL() {
		return COMP_FCPCP_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FCPCP_CUST_CODE() {
		return COMP_FCPCP_CUST_CODE;
	}

	public void setCOMP_FCPCP_CUST_CODE_LABEL(HtmlOutputLabel COMP_FCPCP_CUST_CODE_LABEL) {
		this.COMP_FCPCP_CUST_CODE_LABEL = COMP_FCPCP_CUST_CODE_LABEL;
	}

	public void setCOMP_FCPCP_CUST_CODE(HtmlInputText COMP_FCPCP_CUST_CODE) {
		this.COMP_FCPCP_CUST_CODE = COMP_FCPCP_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_SHARE_PERC_LABEL() {
		return COMP_UI_M_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SHARE_PERC() {
		return COMP_UI_M_SHARE_PERC;
	}

	public void setCOMP_UI_M_SHARE_PERC_LABEL(HtmlOutputLabel COMP_UI_M_SHARE_PERC_LABEL) {
		this.COMP_UI_M_SHARE_PERC_LABEL = COMP_UI_M_SHARE_PERC_LABEL;
	}

	public void setCOMP_UI_M_SHARE_PERC(HtmlInputText COMP_UI_M_SHARE_PERC) {
		this.COMP_UI_M_SHARE_PERC = COMP_UI_M_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_FCPCP_FC_CLM_PAID_LABEL() {
		return COMP_FCPCP_FC_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_FCPCP_FC_CLM_PAID() {
		return COMP_FCPCP_FC_CLM_PAID;
	}

	public void setCOMP_FCPCP_FC_CLM_PAID_LABEL(HtmlOutputLabel COMP_FCPCP_FC_CLM_PAID_LABEL) {
		this.COMP_FCPCP_FC_CLM_PAID_LABEL = COMP_FCPCP_FC_CLM_PAID_LABEL;
	}

	public void setCOMP_FCPCP_FC_CLM_PAID(HtmlInputText COMP_FCPCP_FC_CLM_PAID) {
		this.COMP_FCPCP_FC_CLM_PAID = COMP_FCPCP_FC_CLM_PAID;
	}

	public HtmlOutputLabel getCOMP_UI_M_RETRO_PERC_LABEL() {
		return COMP_UI_M_RETRO_PERC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_RETRO_PERC() {
		return COMP_UI_M_RETRO_PERC;
	}

	public void setCOMP_UI_M_RETRO_PERC_LABEL(HtmlOutputLabel COMP_UI_M_RETRO_PERC_LABEL) {
		this.COMP_UI_M_RETRO_PERC_LABEL = COMP_UI_M_RETRO_PERC_LABEL;
	}

	public void setCOMP_UI_M_RETRO_PERC(HtmlInputText COMP_UI_M_RETRO_PERC) {
		this.COMP_UI_M_RETRO_PERC = COMP_UI_M_RETRO_PERC;
	}

	public HtmlOutputLabel getCOMP_FCPCP_RETRO_FC_CLM_PAID_LABEL() {
		return COMP_FCPCP_RETRO_FC_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_FCPCP_RETRO_FC_CLM_PAID() {
		return COMP_FCPCP_RETRO_FC_CLM_PAID;
	}

	public void setCOMP_FCPCP_RETRO_FC_CLM_PAID_LABEL(HtmlOutputLabel COMP_FCPCP_RETRO_FC_CLM_PAID_LABEL) {
		this.COMP_FCPCP_RETRO_FC_CLM_PAID_LABEL = COMP_FCPCP_RETRO_FC_CLM_PAID_LABEL;
	}

	public void setCOMP_FCPCP_RETRO_FC_CLM_PAID(HtmlInputText COMP_FCPCP_RETRO_FC_CLM_PAID) {
		this.COMP_FCPCP_RETRO_FC_CLM_PAID = COMP_FCPCP_RETRO_FC_CLM_PAID;
	}

	public HtmlOutputLabel getCOMP_FCPCP_LC_CLM_PAID_LABEL() {
		return COMP_FCPCP_LC_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_FCPCP_LC_CLM_PAID() {
		return COMP_FCPCP_LC_CLM_PAID;
	}

	public void setCOMP_FCPCP_LC_CLM_PAID_LABEL(HtmlOutputLabel COMP_FCPCP_LC_CLM_PAID_LABEL) {
		this.COMP_FCPCP_LC_CLM_PAID_LABEL = COMP_FCPCP_LC_CLM_PAID_LABEL;
	}

	public void setCOMP_FCPCP_LC_CLM_PAID(HtmlInputText COMP_FCPCP_LC_CLM_PAID) {
		this.COMP_FCPCP_LC_CLM_PAID = COMP_FCPCP_LC_CLM_PAID;
	}

	public HtmlOutputLabel getCOMP_FCPCP_RETRO_LC_CLM_PAID_LABEL() {
		return COMP_FCPCP_RETRO_LC_CLM_PAID_LABEL;
	}

	public HtmlInputText getCOMP_FCPCP_RETRO_LC_CLM_PAID() {
		return COMP_FCPCP_RETRO_LC_CLM_PAID;
	}

	public void setCOMP_FCPCP_RETRO_LC_CLM_PAID_LABEL(HtmlOutputLabel COMP_FCPCP_RETRO_LC_CLM_PAID_LABEL) {
		this.COMP_FCPCP_RETRO_LC_CLM_PAID_LABEL = COMP_FCPCP_RETRO_LC_CLM_PAID_LABEL;
	}

	public void setCOMP_FCPCP_RETRO_LC_CLM_PAID(HtmlInputText COMP_FCPCP_RETRO_LC_CLM_PAID) {
		this.COMP_FCPCP_RETRO_LC_CLM_PAID = COMP_FCPCP_RETRO_LC_CLM_PAID;
	}

	public PT_IL_FAC_CLAIM_PART_CUST_PAID getPT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN() {
		return PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN;
	}

	public void setPT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN(PT_IL_FAC_CLAIM_PART_CUST_PAID PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN) {
		this.PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN = PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN;
	}
	public void checkBoxStatus(ActionEvent actionEvent){

	}
	public void PT_IL_FAC_CLAIM_PART_CUST_PAID_PRE_INSERT(){
		PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_CR_DT(getSystemDate());
	}

	public void PT_IL_FAC_CLAIM_PART_CUST_PAID_POST_QUERY(){
		PT_IL_FAC_CLAIM_PAID claimPaidBean = compositeAction.getPT_IL_FAC_CLAIM_PAID_ACTION_BEAN().getPT_IL_FAC_CLAIM_PAID_BEAN();
		for(Iterator iterator = claimPaidCustList.iterator();iterator.hasNext();){
			PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN = (PT_IL_FAC_CLAIM_PART_CUST_PAID)iterator.next();
			//PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_CUST_CODE(claimPaidCustList.get(0).getFCPCP_CUST_CODE());
			//PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCPCP_FCPCE_SYS_ID(claimPaidCustList.get(0).getFCPCP_FCPCE_SYS_ID());
			connection = getConnection();
			String C1 = "SELECT FCPCE_FAC_PERC,FCPCE_RETRO_PERC FROM PT_IL_FAC_CLAIM_PART_CUST_EST WHERE  FCPCE_FCE_SYS_ID = "+claimPaidBean.getFCP_FCE_SYS_ID()+" AND FCPCE_SYS_ID = "+PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.getFCPCP_FCPCE_SYS_ID()+" AND FCPCE_CUST_CODE = '"+PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.getFCPCP_CUST_CODE()+"'";
			try {
				resultSet = handler.executeSelectStatement(C1, connection);
				while(resultSet.next()){
					PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setUI_M_SHARE_PERC(resultSet.getDouble("FCPCE_FAC_PERC"));
					PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setUI_M_RETRO_PERC(resultSet.getDouble("FCPCE_RETRO_PERC"));
					//Added for aligning the grid value properly
					this.setClaimPaidCustList(claimPaidCustList);
					if (claimPaidCustList.size() !=0){					
						this.setPT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN(claimPaidCustList.get(0));
						this.getPT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN().setRowSelected(true);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		P_VAL_CUST();
	}
	
	public void P_VAL_CUST(){
		PT_IL_FAC_CLAIM_PAID claimPaidBean = compositeAction.getPT_IL_FAC_CLAIM_PAID_ACTION_BEAN().getPT_IL_FAC_CLAIM_PAID_BEAN();
		paramList.clear();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.getFCPCP_CUST_CODE());
		OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT","");
		OracleParameter param3 = new OracleParameter("in3","STRING","IN","N");
		OracleParameter param4 = new OracleParameter("in4","STRING","IN",CommonUtils.getControlBean().getM_LANG_CODE());		
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		
		List outParamList;
		try {
			outParamList = procHandler.execute(paramList, connection, "P_VAL_CUST");
			OracleParameter planDescPar =(OracleParameter)outParamList.get(0);
			claimPaidBean.setUI_M_CUST_NAME_2(planDescPar.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public PT_IL_FAC_CLAIM_PAID getPT_IL_FAC_CLAIM_PAID_BEAN(){
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_FAC_CLAIM_PAID_ACTION claimPaidAction = (PT_IL_FAC_CLAIM_PAID_ACTION) sessionMap.get("PILT011_PT_IL_FAC_CLAIM_PAID_ACTION");
		PT_IL_FAC_CLAIM_PAID claimPaidBean= claimPaidAction.getPT_IL_FAC_CLAIM_PAID_BEAN();
		return claimPaidBean;
	}
	public void getPT_IL_FAC_CLAIM_PAID_Dtls(){
		PT_IL_FAC_CLAIM_PAID claimPaidAction = getPT_IL_FAC_CLAIM_PAID_BEAN();
		PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setFCP_SYS_ID(claimPaidAction.getFCP_SYS_ID());
		connection =  getConnection();
		String selectQuery = "select * from  PT_IL_FAC_CLAIM_PART_CUST_PAID where PT_IL_FAC_CLAIM_PART_CUST_PAID.FCPCP_FCP_SYS_ID="+PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.getFCP_SYS_ID();
		try {
			claimPaidCustList = handler.fetch(selectQuery, "com.iii.pel.forms.PILT011.PT_IL_FAC_CLAIM_PART_CUST_PAID", connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public Date getSystemDate(){
		Date sysDate = null;
		try {
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/RR') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, getConnection());
			while(resultSet.next())
				sysDate = resultSet.getDate(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysDate;
	}
	public UIDataTable getdataTable() {
		return dataTable;
	}

	public void setdataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}
	public List<PT_IL_FAC_CLAIM_PART_CUST_PAID> getClaimPaidCustList() {
		return claimPaidCustList;
	}

	public void setClaimPaidCustList(List<PT_IL_FAC_CLAIM_PART_CUST_PAID> claimPaidCustList) {
		this.claimPaidCustList = claimPaidCustList;
	}
	
	public void getDetails() {
		try {
			if (claimPaidCustList.size() != 0) {				
				PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN = (PT_IL_FAC_CLAIM_PART_CUST_PAID) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_FAC_CLAIM_PART_CUST_PAID_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
		
	private void resetSelectedRow() {
			Iterator<PT_IL_FAC_CLAIM_PART_CUST_PAID> iterator = claimPaidCustList.iterator();
			while (iterator.hasNext()) {
				iterator.next().setRowSelected(false);
			}
		}
	
	public void resetAllComponent()
	{
		COMP_FCPCP_CUST_CODE.resetValue();
		COMP_UI_M_SHARE_PERC.resetValue();
		COMP_FCPCP_FC_CLM_PAID.resetValue();
		COMP_UI_M_RETRO_PERC.resetValue();
		COMP_FCPCP_RETRO_FC_CLM_PAID.resetValue();
		COMP_FCPCP_LC_CLM_PAID.resetValue();
		COMP_FCPCP_RETRO_LC_CLM_PAID.resetValue();
	}
	
	public void gridtabListener(){
		
		int currRowIndex = getdataTable().getRowIndex();
		int rowUpdated = 0;
		PT_IL_FAC_CLAIM_PART_CUST_PAID gridValueBean = null;
		
		try {
			if(lastUpdatedRowIndex!=-1)
			{
				if(lastUpdatedRowIndex!=prevRowIndex)
				{
					if(currRowIndex != prevRowIndex){
						// Get the bean based on row index
						gridValueBean = (PT_IL_FAC_CLAIM_PART_CUST_PAID)claimPaidCustList.get(prevRowIndex);
						
							// Update the record to database
							if(gridValueBean.getROWID()!=null)
							{
								rowUpdated = 0; //dataGridDelegate.updateData(gridValueBean);
								getErrorMap().put("somekey", rowUpdated+" record updated.");
								getErrorMap().put("current", rowUpdated+" record updated.");
							}else
							{
								rowUpdated = 0; //dataGridDelegate.updateData(gridValueBean);
								getErrorMap().put("somekey", rowUpdated+" record inserted.");
								getErrorMap().put("current", rowUpdated+" record inserted.");
								
							}
						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return ;
	}
	
	
	/**
	 * @return the filterByUI_M_SHARE_PERC
	 */
	public String getFilterByUI_M_SHARE_PERC() {
		return filterByUI_M_SHARE_PERC;
	}

	/**
	 * @param filterByUI_M_SHARE_PERC the filterByUI_M_SHARE_PERC to set
	 */
	public void setFilterByUI_M_SHARE_PERC(String filterByUI_M_SHARE_PERC) {
		this.filterByUI_M_SHARE_PERC = filterByUI_M_SHARE_PERC;
	}

	/**
	 * @return the filterByFCPCP_CUST_CODE
	 */
	public String getFilterByFCPCP_CUST_CODE() {
		return filterByFCPCP_CUST_CODE;
	}

	/**
	 * @param filterByFCPCP_CUST_CODE the filterByFCPCP_CUST_CODE to set
	 */
	public void setFilterByFCPCP_CUST_CODE(String filterByFCPCP_CUST_CODE) {
		this.filterByFCPCP_CUST_CODE = filterByFCPCP_CUST_CODE;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DELETE
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	/**
	 * @param ui_m_but_delete the uI_M_BUT_DELETE to set
	 */
	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public PILT011_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT011_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	
//	public CTRL getControlBean(){
//		FacesContext faces = FacesContext.getCurrentInstance();
//		session = faces.getExternalContext().getSessionMap();
//		return (CTRL)session.get("ctrlbean");
//	}
//	public void setControlBean(CTRL controlBean) {
//		this.controlBean = controlBean;
//	}
}
