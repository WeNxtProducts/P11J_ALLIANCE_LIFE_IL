package com.iii.pel.forms.PILT004;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_LOAND_PROD_CODE_LABEL;

	private HtmlInputText COMP_LOAND_PROD_CODE;

	private HtmlOutputLabel COMP_LOAND_FC_PERM_AMT_LABEL;

	private HtmlInputText COMP_LOAND_FC_PERM_AMT;

	private HtmlOutputLabel COMP_LOAND_LC_PERM_AMT_LABEL;

	private HtmlInputText COMP_LOAND_LC_PERM_AMT;

	private HtmlOutputLabel COMP_LOAND_FC_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAND_FC_AMOUNT;

	private HtmlOutputLabel COMP_LOAND_LC_AMOUNT_LABEL;

	private HtmlInputText COMP_LOAND_LC_AMOUNT;

	private HtmlOutputLabel COMP_UI_M_LOAND_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_LOAND_PROD_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private PT_IL_LOAN_DTL PT_IL_LOAN_DTL_BEAN;
	
	
	
	private String filterByLOAND_PROD_CODE;
	
	private String filterByLOAND_FC_PERM_AMT;
	
	private String filterByLOAND_LC_PERM_AMT;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private List<PT_IL_LOAN_DTL> loanDetailList;
	
	private UIDataTable loanDetailTable;
	
	private UIData dataTable;

	private int currPage;
	private int recordsPerPage = 5;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;
	private String currentMode="insert";

	
	public List<PT_IL_LOAN_DTL> getLoanDetailList() {
		return loanDetailList;
	}

	public void setLoanDetailList(List<PT_IL_LOAN_DTL> loanDetailList) {
		this.loanDetailList = loanDetailList;
	}

	public UIDataTable getLoanDetailTable() {
		return loanDetailTable;
	}

	public void setLoanDetailTable(UIDataTable loanDetailTable) {
		this.loanDetailTable = loanDetailTable;
	}

	public PT_IL_LOAN_DTL_ACTION() {
		PT_IL_LOAN_DTL_BEAN = new PT_IL_LOAN_DTL();
		loanDetailList = new ArrayList<PT_IL_LOAN_DTL>();
		//setFormFlag(true);
		prevRowIndex = 0;
		currPage = 1;
		/*Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		currentMode = (String) session.get("CURRENT_MODE");
*/
		if (currentMode.equalsIgnoreCase("INSERT")) {
			preInsert();
					
		}
	}

	private void preInsert() {
		System.out.println("PT_IL_LOAN_DTL_ACTION.preInsert()");
		
		// Get the bean based on row index
		}

	public HtmlOutputLabel getCOMP_LOAND_PROD_CODE_LABEL() {
		return COMP_LOAND_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_LOAND_PROD_CODE() {
		return COMP_LOAND_PROD_CODE;
	}

	public void setCOMP_LOAND_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_LOAND_PROD_CODE_LABEL) {
		this.COMP_LOAND_PROD_CODE_LABEL = COMP_LOAND_PROD_CODE_LABEL;
	}

	public void setCOMP_LOAND_PROD_CODE(HtmlInputText COMP_LOAND_PROD_CODE) {
		this.COMP_LOAND_PROD_CODE = COMP_LOAND_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_LOAND_FC_PERM_AMT_LABEL() {
		return COMP_LOAND_FC_PERM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LOAND_FC_PERM_AMT() {
		return COMP_LOAND_FC_PERM_AMT;
	}

	public void setCOMP_LOAND_FC_PERM_AMT_LABEL(
			HtmlOutputLabel COMP_LOAND_FC_PERM_AMT_LABEL) {
		this.COMP_LOAND_FC_PERM_AMT_LABEL = COMP_LOAND_FC_PERM_AMT_LABEL;
	}

	public void setCOMP_LOAND_FC_PERM_AMT(HtmlInputText COMP_LOAND_FC_PERM_AMT) {
		this.COMP_LOAND_FC_PERM_AMT = COMP_LOAND_FC_PERM_AMT;
	}

	public HtmlOutputLabel getCOMP_LOAND_LC_PERM_AMT_LABEL() {
		return COMP_LOAND_LC_PERM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LOAND_LC_PERM_AMT() {
		return COMP_LOAND_LC_PERM_AMT;
	}

	public void setCOMP_LOAND_LC_PERM_AMT_LABEL(
			HtmlOutputLabel COMP_LOAND_LC_PERM_AMT_LABEL) {
		this.COMP_LOAND_LC_PERM_AMT_LABEL = COMP_LOAND_LC_PERM_AMT_LABEL;
	}

	public void setCOMP_LOAND_LC_PERM_AMT(HtmlInputText COMP_LOAND_LC_PERM_AMT) {
		this.COMP_LOAND_LC_PERM_AMT = COMP_LOAND_LC_PERM_AMT;
	}

	public HtmlOutputLabel getCOMP_LOAND_FC_AMOUNT_LABEL() {
		return COMP_LOAND_FC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_LOAND_FC_AMOUNT() {
		return COMP_LOAND_FC_AMOUNT;
	}

	public void setCOMP_LOAND_FC_AMOUNT_LABEL(
			HtmlOutputLabel COMP_LOAND_FC_AMOUNT_LABEL) {
		this.COMP_LOAND_FC_AMOUNT_LABEL = COMP_LOAND_FC_AMOUNT_LABEL;
	}

	public void setCOMP_LOAND_FC_AMOUNT(HtmlInputText COMP_LOAND_FC_AMOUNT) {
		this.COMP_LOAND_FC_AMOUNT = COMP_LOAND_FC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_LOAND_LC_AMOUNT_LABEL() {
		return COMP_LOAND_LC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_LOAND_LC_AMOUNT() {
		return COMP_LOAND_LC_AMOUNT;
	}

	public void setCOMP_LOAND_LC_AMOUNT_LABEL(
			HtmlOutputLabel COMP_LOAND_LC_AMOUNT_LABEL) {
		this.COMP_LOAND_LC_AMOUNT_LABEL = COMP_LOAND_LC_AMOUNT_LABEL;
	}

	public void setCOMP_LOAND_LC_AMOUNT(HtmlInputText COMP_LOAND_LC_AMOUNT) {
		this.COMP_LOAND_LC_AMOUNT = COMP_LOAND_LC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAND_PROD_DESC_LABEL() {
		return COMP_UI_M_LOAND_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAND_PROD_DESC() {
		return COMP_UI_M_LOAND_PROD_DESC;
	}

	public void setCOMP_UI_M_LOAND_PROD_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_LOAND_PROD_DESC_LABEL) {
		this.COMP_UI_M_LOAND_PROD_DESC_LABEL = COMP_UI_M_LOAND_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_LOAND_PROD_DESC(
			HtmlInputText COMP_UI_M_LOAND_PROD_DESC) {
		this.COMP_UI_M_LOAND_PROD_DESC = COMP_UI_M_LOAND_PROD_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton COMP_UI_M_BUT_MAIN) {
		this.COMP_UI_M_BUT_MAIN = COMP_UI_M_BUT_MAIN;
	}

	public PT_IL_LOAN_DTL getPT_IL_LOAN_DTL_BEAN() {
		return PT_IL_LOAN_DTL_BEAN;
	}

	public void setPT_IL_LOAN_DTL_BEAN(PT_IL_LOAN_DTL PT_IL_LOAN_DTL_BEAN) {
		this.PT_IL_LOAN_DTL_BEAN = PT_IL_LOAN_DTL_BEAN;
	}

	public String mainBtnAction() {
		System.out.println("PT_IL_LOAN_DTL_ACTION.mainBtnAction()");
		return "main";
	}

	private void rowChangeListener(ActionEvent event) {
		int currRowIndex = getLoanDetailTable().getRowIndex();
		int rowUpdated = 0;
		PT_IL_LOAN_DTL gridValueBean = null;
		System.out.println(lastUpdatedRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {

						// Get the bean based on row index
						gridValueBean = (PT_IL_LOAN_DTL) loanDetailList
								.get(prevRowIndex);
						// Update the record to database
						if (gridValueBean.getROWID() != null) {
							System.out
									.println("PT_IL_LOAN_DTL_ACTION.rowChangeListener-----rowID1"
											+ gridValueBean.getROWID());
							rowUpdated = updateData(gridValueBean);
						} else {

							//gridValueBean.setRSA_PLAN_CODE("dee");
							// Setting Bean Values here//

							System.out
									.println("PT_IL_LOAN_DTL_ACTION.rowChangeListener-----rowID2"
											+ gridValueBean.getROWID());
							rowUpdated = updateData(gridValueBean);
						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}						
		} catch (Exception e1) {
		}

	}

	private int updateData(PT_IL_LOAN_DTL gridValueBean) throws Exception {
		if (currentMode.equalsIgnoreCase("INSERT")) {
			preInsert();
		}

		{
			CRUDHandler dbHandler = new CRUDHandler();
			int rowUpdated = 0;

			try {
				Connection connection = CommonUtils.getConnection();
				//dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
				rowUpdated = dbHandler.executeInsert(gridValueBean, connection);
				connection.commit();
				//Added for aligning the grid value properly
				Iterator<PT_IL_LOAN_DTL> it = loanDetailList.iterator();
				PT_IL_LOAN_DTL PT_IL_LOAN_DTL_BEAN = null;
				while(it.hasNext()){
					PT_IL_LOAN_DTL_BEAN = it.next();
					PT_IL_LOAN_DTL_BEAN.setRowSelected(false);
				}
				
				this.setLoanDetailList(loanDetailList);
				if (loanDetailList.size() !=0){					
					this.setPT_IL_LOAN_DTL_BEAN(loanDetailList.get(0));
					this.getPT_IL_LOAN_DTL_BEAN().setRowSelected(true);
				}
			} catch (Exception exc) {
				throw exc;
			}
			return rowUpdated;
		}
	}

	public void lastColumnListener(ActionEvent event) {

		int currRowIndex = getLoanDetailTable().getRowIndex();
		int rowUpdated = 0;
		PT_IL_LOAN_DTL gridValueBean = null;
		
		//PRE_INSERT
		/*gridValueBean = (PT_IL_LOAN_DTL)loanDetailList.get(currRowIndex);
		gridValueBean.setLOAN_CR_UID(CommonUtils.getGlobalVariable("PILT004_GLOBAL_M_USER_ID"));
		gridValueBean.setLOAN_CURR_CODE(CommonUtils.getGlobalVariable("PILT004_BASE_CURR"));
		gridValueBean.setLOAN_CR_DT(new Date());*/
		//PRE_INSERT
		

		try {

			// Get the bean based on row index
			gridValueBean = (PT_IL_LOAN_DTL)loanDetailList.get(currRowIndex);
			System.out.println("SYSID---------------->" + gridValueBean.getLOAND_SYS_ID());

			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				rowUpdated = updateData(gridValueBean); 

			} else {
				//Setting Values//
				//gridValueBean.setRSA_PLAN_CODE("dee");
				preInsert();
				rowUpdated = updateData(gridValueBean);

			}

			lastUpdatedRowIndex = currRowIndex;		
			
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
		}

		return;

	}
	
	public void getDetails() {
		try {
			if (loanDetailList.size() != 0) {				
				PT_IL_LOAN_DTL_BEAN = (PT_IL_LOAN_DTL)loanDetailTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_LOAN_DTL_BEAN.setRowSelected(true);
			setPT_IL_LOAN_DTL_BEAN(PT_IL_LOAN_DTL_BEAN);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Det", e.getMessage());
		}
	  }
	
	private void resetSelectedRow() {
		Iterator<PT_IL_LOAN_DTL> iterator = loanDetailList.iterator();
		while (iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	public void resetAllComponent()
	{
		COMP_LOAND_PROD_CODE.resetValue();
		COMP_LOAND_FC_PERM_AMT.resetValue();
		COMP_LOAND_LC_PERM_AMT.resetValue();
		COMP_LOAND_FC_AMOUNT.resetValue();
		COMP_LOAND_LC_AMOUNT.resetValue();
		COMP_UI_M_LOAND_PROD_DESC.resetValue();
		
	}

	
	

	/**
	 * @return the filterByLOAND_PROD_CODE
	 */
	public String getFilterByLOAND_PROD_CODE() {
		return filterByLOAND_PROD_CODE;
	}

	/**
	 * @param filterByLOAND_PROD_CODE the filterByLOAND_PROD_CODE to set
	 */
	public void setFilterByLOAND_PROD_CODE(String filterByLOAND_PROD_CODE) {
		this.filterByLOAND_PROD_CODE = filterByLOAND_PROD_CODE;
	}

	/**
	 * @return the filterByLOAND_FC_PERM_AMT
	 */
	public String getFilterByLOAND_FC_PERM_AMT() {
		return filterByLOAND_FC_PERM_AMT;
	}

	/**
	 * @param filterByLOAND_FC_PERM_AMT the filterByLOAND_FC_PERM_AMT to set
	 */
	public void setFilterByLOAND_FC_PERM_AMT(String filterByLOAND_FC_PERM_AMT) {
		this.filterByLOAND_FC_PERM_AMT = filterByLOAND_FC_PERM_AMT;
	}

	/**
	 * @return the filterByLOAND_LC_PERM_AMT
	 */
	public String getFilterByLOAND_LC_PERM_AMT() {
		return filterByLOAND_LC_PERM_AMT;
	}

	/**
	 * @param filterByLOAND_LC_PERM_AMT the filterByLOAND_LC_PERM_AMT to set
	 */
	public void setFilterByLOAND_LC_PERM_AMT(String filterByLOAND_LC_PERM_AMT) {
		this.filterByLOAND_LC_PERM_AMT = filterByLOAND_LC_PERM_AMT;
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

	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the currPage
	 */
	public int getCurrPage() {
		return currPage;
	}

	/**
	 * @param currPage the currPage to set
	 */
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	/**
	 * @return the recordsPerPage
	 */
	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	/**
	 * @param recordsPerPage the recordsPerPage to set
	 */
	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	/**
	 * @return the lastUpdatedRowIndex
	 */
	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	/**
	 * @param lastUpdatedRowIndex the lastUpdatedRowIndex to set
	 */
	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	/**
	 * @return the prevRowIndex
	 */
	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	/**
	 * @param prevRowIndex the prevRowIndex to set
	 */
	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	/**
	 * @return the currentMode
	 */
	public String getCurrentMode() {
		return currentMode;
	}

	/**
	 * @param currentMode the currentMode to set
	 */
	public void setCurrentMode(String currentMode) {
		this.currentMode = currentMode;
	}
	
	public void onLoad(PhaseEvent event){
		if(isBlockFlag()){
			this.getListData();
			setBlockFlag(false);
		}
	}
	
	public void getListData() {
			Connection con = null;
			
			int size = loanDetailList.size();
			if(loanDetailList!=null && !loanDetailList.isEmpty()){
				loanDetailList.clear();
				setPT_IL_LOAN_DTL_BEAN(new PT_IL_LOAN_DTL());
			}
			
			//if(size < 1 ) {
				    PT_IL_LOAN_DTL bean = new PT_IL_LOAN_DTL();
			   try {
				    con = CommonUtils.getConnection();
				    FacesContext context = FacesContext.getCurrentInstance();
					Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
					PT_IL_LOAN_ACTION actionBean = (PT_IL_LOAN_ACTION) sessionMap.get("PILT004_PT_IL_LOAN_ACTION");
					PT_IL_LOAN valueBean = actionBean.getPT_IL_LOAN_BEAN();
				    
					
					double LOAND_SYS_ID = valueBean.getLOAN_SYS_ID();
					//double LOAND_POL_SYS_ID = ptILLoanBean.getLOAN_POL_SYS_ID();
				    System.out.println("-LOAND_SYS_ID-------------------------------------" + LOAND_SYS_ID);
				    
					/*bean.setLOAND_SYS_ID(LOAND_SYS_ID);
					bean.setLOAND_LOAN_SYS_ID(LOAND_SYS_ID);
					bean.setLOAND_POL_SYS_ID(LOAND_POL_SYS_ID);
			*/
					String query = " select ROWID,LOAND_SYS_ID,LOAND_LOAN_SYS_ID,LOAND_POL_SYS_ID,LOAND_PROD_CODE,LOAND_FC_PERM_AMT,LOAND_LC_PERM_AMT,LOAND_FC_AMOUNT,LOAND_LC_AMOUNT  from  PT_IL_LOAN_DTL where LOAND_LOAN_SYS_ID= '" + LOAND_SYS_ID + "' ";
					CRUDHandler handler = new CRUDHandler();
					loanDetailList = handler.fetch(query, "com.iii.pel.forms.PILT004.PT_IL_LOAN_DTL", con);
					//Added for aligning the grid value properly
					Iterator<PT_IL_LOAN_DTL> it = loanDetailList.iterator();
					PT_IL_LOAN_DTL PT_IL_LOAN_DTL_BEAN = null;
					while(it.hasNext()){
						PT_IL_LOAN_DTL_BEAN = it.next();
						PT_IL_LOAN_DTL_BEAN.setRowSelected(false);
					}
					
					this.setLoanDetailList(loanDetailList);
					if (loanDetailList.size() !=0){					
						this.setPT_IL_LOAN_DTL_BEAN(loanDetailList.get(0));
						this.getPT_IL_LOAN_DTL_BEAN().setRowSelected(true);
					}			 	
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//loanDetailList.add(bean);
				
			//}
			
	}

}
