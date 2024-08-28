package com.iii.pel.forms.PILT084;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlDataTable;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP002_APAC.COMPOSITE_ACTION_BEAN;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT013.PILT013_COMPOSITE_ACTION;
import com.iii.pel.jasperreports.IP_REP_INFO;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class PT_IL_PAYOUT_PROCESS_ACTION extends /*CommonAction*/CommonReportAction {
	
	/*Added by saritha on 21.01.2020 for Orient Desc : DMS Integration RedirectUrl*/
	
	private ResourceBundle resourceBundleApp = ResourceBundle.getBundle("Application");
	
	/*End*/

	private UIData dataTable;

	public PILT084_COMPOSITE_ACTION_BEAN compositeAction;

	private PT_IL_PAYOUT_PROCESS_HELPER helper;

	private PT_IL_PAYOUT_PROCESS PT_IL_PAYOUT_PROCESS_BEAN;
	
	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PILT084_COMPOSITE_ACTION_BEAN getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT084_COMPOSITE_ACTION_BEAN compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_PAYOUT_PROCESS getPT_IL_PAYOUT_PROCESS_BEAN() {
		return PT_IL_PAYOUT_PROCESS_BEAN;
	}

	public void setPT_IL_PAYOUT_PROCESS_BEAN(
			PT_IL_PAYOUT_PROCESS pT_IL_PAYOUT_PROCESS_BEAN) {
		PT_IL_PAYOUT_PROCESS_BEAN = pT_IL_PAYOUT_PROCESS_BEAN;
	}

	public List<PT_IL_PAYOUT_PROCESS> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PT_IL_PAYOUT_PROCESS> dataTableList) {
		this.dataTableList = dataTableList;
	}
	
	public PT_IL_PAYOUT_PROCESS_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_PAYOUT_PROCESS_HELPER helper) {
		this.helper = helper;
	}



	private List<PT_IL_PAYOUT_PROCESS> dataTableList = new ArrayList<PT_IL_PAYOUT_PROCESS>();
	
    
    public PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN;

	public PT_IL_PAYOUT_PROCESS_ACTION() {
		PT_IL_PAYOUT_PROCESS_BEAN = new PT_IL_PAYOUT_PROCESS();
		helper= new PT_IL_PAYOUT_PROCESS_HELPER();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			dataTable = new HtmlDataTable();
			instantiateAllComponent();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public void instantiateAllComponent() {
		COMP_PP_PAYOUT_TYPE = new HtmlInputText();
		COMP_PP_PAYOUT_DT_LABEL = new HtmlOutputLabel();
		COMP_PP_PAYOUT_DT = new HtmlCalendar();
		COMP_PP_PAYOUT_AMT_LABEL = new HtmlOutputLabel();
		COMP_PP_PAYOUT_AMT = new HtmlInputText();
		COMP_PP_PAYOUT_STATUS_LABEL = new HtmlOutputLabel();
		COMP_PP_PAYOUT_STATUS = new HtmlInputText();
		COMP_PP_PAYOUT_REMARK_LABEL = new HtmlOutputLabel();
		COMP_PP_PAYOUT_REMARK = new HtmlInputText();
		COMP_PP_PAYOUT_TYPE_LABEL = new HtmlOutputLabel();
		COMP_PP_PAYOUT_APPROVE = new HtmlCommandButton();
		COMP_PP_PAYOUT_REJECT = new HtmlCommandButton();
		COMP_UI_M_TRANSACTION = new HtmlCommandButton();
		COMP_UI_M_CHKLST = new HtmlCommandButton();
		COMP_STATUS_MODAL_PANEL = new HtmlModalPanel();
		COMP_UI_M_PAYOUT_STATUS_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PAYOUT_STATUS = new HtmlSelectOneMenu();
		
		/*Added by saritha on 03-01-2020 for ORIENT - OCD Payout Process Policy No.&Payee Name column added*/
		
		 COMP_PP_POL_NO_LABEL = new HtmlOutputLabel();
		 COMP_PP_POL_NO = new HtmlInputText();
	     COMP_PP_PAYEE_NAME_LABEL = new HtmlOutputLabel();
		 COMP_PP_PAYEE_NAME = new HtmlInputText();
		 
		 /*End*/
		
	}

	public void resetAllComponent() {
		COMP_PP_POL_NO.resetValue();
		COMP_PP_PAYOUT_TYPE.resetValue();
		COMP_PP_PAYOUT_DT.resetValue();
		COMP_PP_PAYOUT_AMT.resetValue();
		COMP_PP_PAYOUT_STATUS.resetValue();
		COMP_PP_PAYOUT_REMARK.resetValue();
		COMP_UI_M_PAYOUT_STATUS.resetValue();
		
		/*Added by saritha on 03-01-2020 for ORIENT - OCD Payout Process Policy No.&Payee Name column added*/
		
		 COMP_PP_POL_NO.resetValue();
		 COMP_PP_PAYEE_NAME.resetValue();
		 
		 /*End*/
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				// CommonUtils.clearMaps(this);
				executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
	public void executeQuery(PILT084_COMPOSITE_ACTION_BEAN compositeAction)
			throws Exception {
		List<PT_IL_PAYOUT_PROCESS> dataList = null;
		try {
			executeSelectStatement(compositeAction);
			/*dataList = compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getDataTableList();
			if (dataList != null && dataList.size() > 0) {
				dataList.clear();
			}*/
			
			dataList = compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getDataTableList();
			if (dataList != null && dataList.size() > 0) {
				PT_IL_PAYOUT_PROCESS PT_IL_PAYOUT_PROCESS_BEAN = dataList.get(0);
				PT_IL_PAYOUT_PROCESS_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN()
				.setPT_IL_PAYOUT_PROCESS_BEAN(PT_IL_PAYOUT_PROCESS_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void executeSelectStatement(
			PILT084_COMPOSITE_ACTION_BEAN compositeAction2) throws Exception {
		 String selectStatement = null;
		 //Added by kavitha on 11.12.2019 for orient ocd process 
		 if(CommonUtils.getGlobalVariable("CALLING_FORM")!=null && CommonUtils.getGlobalVariable("CALLING_FORM").equals("workflow")){
			 if(CommonUtils.getGlobalObject("M_OCD_ROWNO")!= null){
				 selectStatement = "SELECT ROWID, PT_IL_PAYOUT_PROCESS.* FROM PT_IL_PAYOUT_PROCESS WHERE ROWID = '"+CommonUtils.getGlobalObject("M_OCD_ROWNO")+"'";
				 COMP_BACK_BUTTON.setRendered(true);
			 }
		 }else{
			  selectStatement = "SELECT ROWID, PT_IL_PAYOUT_PROCESS.* FROM PT_IL_PAYOUT_PROCESS"; // WHERE  PP_PAYOUT_STATUS ='A'
			  COMP_BACK_BUTTON.setRendered(false);																				
		 }																						
																									

		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN()
				.getDataTableList().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PT_IL_PAYOUT_PROCESS PT_IL_PAYOUT_PROCESS_BEAN = new PT_IL_PAYOUT_PROCESS();
				PT_IL_PAYOUT_PROCESS_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_TYPE(resultSet
						.getString("PP_PAYOUT_TYPE"));
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_DT(resultSet
						.getDate("PP_PAYOUT_DT"));
				/*Commented and modified by senthilnathan on 25.06.2020 issues desc: Net amount should be shown instead of Gross amount*/
				/*PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_AMT(resultSet
						.getDouble("PP_PAYOUT_AMT"));*/
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_NET_AMT(resultSet
						.getDouble("PP_PAYOUT_NET_AMT"));
				//PT_IL_PAYOUT_PROCESS_BEAN.setUI_M_PAYOUT_STATUS(resultSet.getString("PP_PAYOUT_STATUS"));
				String status = resultSet.getString("PP_PAYOUT_STATUS");
				
				if(status!=null){
					if (status.equalsIgnoreCase("N")) {
						
						/*Modified by Janani on 27.04.2020 for Orient UAT as suggested by Girish
						 desc :To update status for each process */
						
						/*PT_IL_PAYOUT_PROCESS_BEAN
								.setPP_PAYOUT_STATUS("Approved by Operations");*/
						
						PT_IL_PAYOUT_PROCESS_BEAN
						.setPP_PAYOUT_STATUS("Approved by Operations & Pending with OCD");
						
						/*End*/
					} else if (status.equalsIgnoreCase("A")) {
						PT_IL_PAYOUT_PROCESS_BEAN
								.setPP_PAYOUT_STATUS("Approved by OCD");
					} else if(status.equalsIgnoreCase("R")) {
						PT_IL_PAYOUT_PROCESS_BEAN
								.setPP_PAYOUT_STATUS("Rejected by OCD");
					}else if(status.equalsIgnoreCase("S")) {
						PT_IL_PAYOUT_PROCESS_BEAN
						.setPP_PAYOUT_STATUS("Settled by OCD");
					}else if(status.equalsIgnoreCase("CPO")) {
						PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Cheque Provided to Operations");
					}else if(status.equalsIgnoreCase("CHC")) {
						PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Cheque Handed-over to Client");
					}
					//Added by rakesh on 06-1-2020 for ACD00030_IL_016
					else if(status.equalsIgnoreCase("US")) {
						PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Under Signature");
					}
					//END
					
					/*Added by saritha on 07-01-2020 for Orient - OCD Payout Process(Premium Position not Statisfied - Email Trigger)*/
					else if(status.equalsIgnoreCase("P")) {
						PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Premium Possiession not Statisfied");
					}
					/*End*/
					//Added by kavitha on 23.01.2020 for OCD 
					else if(status.equalsIgnoreCase("D")) {
						PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Request For Details");
					}
					
				}
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_REMARK(resultSet
						.getString("PP_PAYOUT_REMARK"));
				
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_POL_SYS_ID(resultSet.getLong("PP_POL_SYS_ID"));
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_TRANS_SYS_ID(resultSet.getLong("PP_TRANS_SYS_ID"));
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_CR_UID(resultSet.getString("PP_CR_UID"));
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_CR_DT(resultSet.getDate("PP_CR_DT"));
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_UPD_UID(resultSet.getString("PP_UPD_UID"));
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_UPD_DT(resultSet.getDate("PP_UPD_DT"));
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_SYS_ID(resultSet.getLong("PP_SYS_ID"));
				
				/*Added by saritha on 03-01-2020 for ORIENT OCD Payout Process Policy No.&Payee Name column added*/
				
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_POL_NO(resultSet.getString("PP_POL_NO"));
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYEE_NAME(resultSet.getString("PP_PAYEE_NAME"));
				
				/*End*/
				
				compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN()
						.getDataTableList().add(PT_IL_PAYOUT_PROCESS_BEAN);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	private HtmlInputText COMP_PP_PAYOUT_TYPE;
	private HtmlOutputLabel COMP_PP_PAYOUT_DT_LABEL;
	private HtmlCalendar COMP_PP_PAYOUT_DT;
	private HtmlOutputLabel COMP_PP_PAYOUT_AMT_LABEL;
	private HtmlInputText COMP_PP_PAYOUT_AMT;
	private HtmlOutputLabel COMP_PP_PAYOUT_STATUS_LABEL;
	private HtmlInputText COMP_PP_PAYOUT_STATUS;
	private HtmlOutputLabel COMP_PP_PAYOUT_REMARK_LABEL;
	private HtmlInputText COMP_PP_PAYOUT_REMARK;
	private HtmlOutputLabel COMP_PP_PAYOUT_TYPE_LABEL;
	private HtmlCommandButton COMP_PP_PAYOUT_APPROVE;
	private HtmlCommandButton COMP_PP_PAYOUT_REJECT;
	private HtmlCommandButton COMP_UI_M_TRANSACTION;
	private HtmlCommandButton COMP_UI_M_CHKLST;

	public HtmlOutputLabel getCOMP_PP_PAYOUT_TYPE_LABEL() {
		return COMP_PP_PAYOUT_TYPE_LABEL;
	}

	public void setCOMP_PP_PAYOUT_TYPE_LABEL(
			HtmlOutputLabel cOMP_PP_PAYOUT_TYPE_LABEL) {
		COMP_PP_PAYOUT_TYPE_LABEL = cOMP_PP_PAYOUT_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_PP_PAYOUT_TYPE() {
		return COMP_PP_PAYOUT_TYPE;
	}

	public void setCOMP_PP_PAYOUT_TYPE(HtmlInputText cOMP_PP_PAYOUT_TYPE) {
		COMP_PP_PAYOUT_TYPE = cOMP_PP_PAYOUT_TYPE;
	}

	public HtmlOutputLabel getCOMP_PP_PAYOUT_DT_LABEL() {
		return COMP_PP_PAYOUT_DT_LABEL;
	}

	public void setCOMP_PP_PAYOUT_DT_LABEL(
			HtmlOutputLabel cOMP_PP_PAYOUT_DT_LABEL) {
		COMP_PP_PAYOUT_DT_LABEL = cOMP_PP_PAYOUT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PP_PAYOUT_DT() {
		return COMP_PP_PAYOUT_DT;
	}

	public void setCOMP_PP_PAYOUT_DT(HtmlCalendar cOMP_PP_PAYOUT_DT) {
		COMP_PP_PAYOUT_DT = cOMP_PP_PAYOUT_DT;
	}

	public HtmlOutputLabel getCOMP_PP_PAYOUT_AMT_LABEL() {
		return COMP_PP_PAYOUT_AMT_LABEL;
	}

	public void setCOMP_PP_PAYOUT_AMT_LABEL(
			HtmlOutputLabel cOMP_PP_PAYOUT_AMT_LABEL) {
		COMP_PP_PAYOUT_AMT_LABEL = cOMP_PP_PAYOUT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PP_PAYOUT_AMT() {
		return COMP_PP_PAYOUT_AMT;
	}

	public void setCOMP_PP_PAYOUT_AMT(HtmlInputText cOMP_PP_PAYOUT_AMT) {
		COMP_PP_PAYOUT_AMT = cOMP_PP_PAYOUT_AMT;
	}

	public HtmlOutputLabel getCOMP_PP_PAYOUT_STATUS_LABEL() {
		return COMP_PP_PAYOUT_STATUS_LABEL;
	}

	public void setCOMP_PP_PAYOUT_STATUS_LABEL(
			HtmlOutputLabel cOMP_PP_PAYOUT_STATUS_LABEL) {
		COMP_PP_PAYOUT_STATUS_LABEL = cOMP_PP_PAYOUT_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_PP_PAYOUT_STATUS() {
		return COMP_PP_PAYOUT_STATUS;
	}

	public void setCOMP_PP_PAYOUT_STATUS(HtmlInputText cOMP_PP_PAYOUT_STATUS) {
		COMP_PP_PAYOUT_STATUS = cOMP_PP_PAYOUT_STATUS;
	}

	public HtmlOutputLabel getCOMP_PP_PAYOUT_REMARK_LABEL() {
		return COMP_PP_PAYOUT_REMARK_LABEL;
	}

	public void setCOMP_PP_PAYOUT_REMARK_LABEL(
			HtmlOutputLabel cOMP_PP_PAYOUT_REMARK_LABEL) {
		COMP_PP_PAYOUT_REMARK_LABEL = cOMP_PP_PAYOUT_REMARK_LABEL;
	}

	public HtmlInputText getCOMP_PP_PAYOUT_REMARK() {
		return COMP_PP_PAYOUT_REMARK;
	}

	public void setCOMP_PP_PAYOUT_REMARK(HtmlInputText cOMP_PP_PAYOUT_REMARK) {
		COMP_PP_PAYOUT_REMARK = cOMP_PP_PAYOUT_REMARK;
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_PAYOUT_PROCESS_BEAN = (PT_IL_PAYOUT_PROCESS) dataTable
					.getRowData();
			PT_IL_PAYOUT_PROCESS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_PAYOUT_PROCESS> PT_IL_PAYOUT_PROCESS_ITR = dataTableList
				.iterator();
		while (PT_IL_PAYOUT_PROCESS_ITR.hasNext()) {
			PT_IL_PAYOUT_PROCESS_ITR.next().setRowSelected(false);
		}
	}

	public String approveOK()throws Exception{
		Connection conn = null;
		try {
			/*conn = CommonUtils.getConnection();
			if (PT_IL_PAYOUT_PROCESS_BEAN.getROWID() != null) {
				checklistStatus(PT_IL_PAYOUT_PROCESS_BEAN);
				
				if (isUPDATE_ALLOWED()) {
					PRE_UPDATE(compositeAction);
					new CRUDHandler().executeUpdate(PT_IL_PAYOUT_PROCESS_BEAN,conn);
				}
				conn.commit();
				executeQuery(compositeAction);
				getWarningMap().put(
						"current","Approved Successfully");
			}*/
			resetAllComponent();
			getCOMP_STATUS_MODAL_PANEL().setShowWhenRendered(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		return null;
	}

	/*public String rejectOK()throws Exception{
		Connection conn = null;
		try {
			conn = CommonUtils.getConnection();
			if (PT_IL_PAYOUT_PROCESS_BEAN.getROWID() != null) {
				checklistStatus(PT_IL_PAYOUT_PROCESS_BEAN);
				if (isUPDATE_ALLOWED()) {
					PRE_UPDATE(compositeAction);
					new CRUDHandler().executeUpdate(PT_IL_PAYOUT_PROCESS_BEAN,conn);
				}
				conn.commit();
				executeQuery(compositeAction);
				getWarningMap().put(
						"current","Rejected Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		return null;
	}*/

	public HtmlCommandButton getCOMP_PP_PAYOUT_APPROVE() {
		return COMP_PP_PAYOUT_APPROVE;
	}

	public void setCOMP_PP_PAYOUT_APPROVE(
			HtmlCommandButton cOMP_PP_PAYOUT_APPROVE) {
		COMP_PP_PAYOUT_APPROVE = cOMP_PP_PAYOUT_APPROVE;
	}

	public HtmlCommandButton getCOMP_PP_PAYOUT_REJECT() {
		return COMP_PP_PAYOUT_REJECT;
	}

	public void setCOMP_PP_PAYOUT_REJECT(
			HtmlCommandButton cOMP_PP_PAYOUT_REJECT) {
		COMP_PP_PAYOUT_REJECT = cOMP_PP_PAYOUT_REJECT;
	}

	public HtmlCommandButton getCOMP_UI_M_TRANSACTION() {
		return COMP_UI_M_TRANSACTION;
	}

	public void setCOMP_UI_M_TRANSACTION(HtmlCommandButton cOMP_UI_M_TRANSACTION) {
		COMP_UI_M_TRANSACTION = cOMP_UI_M_TRANSACTION;
	}
	
	public void PRE_UPDATE(PILT084_COMPOSITE_ACTION_BEAN compositeAction)
			throws Exception {
		/*PT_IL_PAYOUT_PROCESS PT_IL_PAYOUT_PROCESS_BEAN = compositeAction
				.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN();*/
		try {
			//Added by kavitha on 10.12.2019  for orint OCD process
			PT_IL_PAYOUT_PROCESS_BEAN.setPP_SYS_ID(PT_IL_PAYOUT_PROCESS_BEAN.getPP_SYS_ID());
			PT_IL_PAYOUT_PROCESS_BEAN.setPP_UPD_DT(new CommonUtils().getCurrentDate());
			PT_IL_PAYOUT_PROCESS_BEAN.setPP_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			if(PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS().equalsIgnoreCase("ABO"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("A");
			}
			else if(PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS().equalsIgnoreCase("RBO"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("R");
			}
			else if(PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS().equalsIgnoreCase("RFD"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("D");
			}
			else if(PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS().equalsIgnoreCase("CPO"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("CPO");
			}
			else if(PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS().equalsIgnoreCase("CHC"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("CHC");
			}
			else if(PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS().equalsIgnoreCase("SBO"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("S");
			}
			
			/*Added by saritha on 07-01-2020 for Orient - OCD Payout Process(Premium Position not Statisfied - Email Trigger)*/
			
			else if(PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS().equalsIgnoreCase("PPS"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("P");
			}
			
			/*End*/
			
			else
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("N");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public HtmlCommandButton getCOMP_UI_M_CHKLST() {
		return COMP_UI_M_CHKLST;
	}

	public void setCOMP_UI_M_CHKLST(HtmlCommandButton cOMP_UI_M_CHKLST) {
		COMP_UI_M_CHKLST = cOMP_UI_M_CHKLST;
	}

	public String actionchklist() throws Exception {
		String outCome = null;
		String query = "SELECT * FROM PT_IL_PAYOUT_PROCESS WHERE ROWID=?";
		Connection con = null;
		ResultSet rs= null;
		Long pol_sys_id = null;
		Long trans_sys_id = null;
		try {
			con = CommonUtils.getConnection();
			
			if (PT_IL_PAYOUT_PROCESS_BEAN.getROWID() != null) {
				
				rs = new CRUDHandler().executeSelectStatement(query, con, new Object[] {PT_IL_PAYOUT_PROCESS_BEAN.getROWID()});
				while(rs.next())
				{
					pol_sys_id = rs.getLong("PP_POL_SYS_ID");
					trans_sys_id = rs.getLong("PP_TRANS_SYS_ID");
				}

				CommonUtils.setGlobalObject("OCD_POL_SYS_ID",pol_sys_id);
				CommonUtils.setGlobalObject("OCD_TRANS_SYS_ID",trans_sys_id);
				compositeAction.getPT_IL_OCD_DOC_TODO_LIST_ACTION_BEAN()
						.setBlockFlag(true);
				/*Added by Janani on 24.04.2020 for Orient UAT
				desc :Checklist not defaulting*/
				
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.setBlockFlag(true);
				
				/*End*/
				outCome = "PILT084_PT_IL_PAYOUT_CHKLST";
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		return outCome;
	}
	
	
	public String actionUI_M_TRANSACTION_OK()throws Exception{
		String outcome = "";
		/*String CLAIM_CALLING_FORM = CommonUtils
				.getGlobalVariable("CLAIM_CALLING_FORM");
		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");*/
		try {
			Long polsysid = PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID();
			Long transsysid = PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID();
			
			CommonUtils.setGlobalObject("OCD_POL_SYS_ID", polsysid);
			CommonUtils.setGlobalObject("OCD_TRANS_SYS_ID", transsysid);
			String payouttype = PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE();
			/*Added by senthilnathan for orient issue desc: survival benefit moved  */
			if(payouttype.equalsIgnoreCase("SURRENDER") || payouttype.equalsIgnoreCase("PARTIAL SURRENDER") || payouttype.equalsIgnoreCase("MATURITY") || payouttype.equalsIgnoreCase("SURVIVAL BENEFIT"))
			{
				CommonUtils.setGlobalObject("CLAIM_CALLING_FORM","OCD_SPM");
				/*Modified by Sivarajan on 18/04/2020 for orient IL*/
				//outcome = "PILT013_PT_IL_SURR_MAT_VALUES";
				outcome = "PILT013_PT_IL_POLICY";
				/*End*/
			}
			else if(payouttype.equalsIgnoreCase("CLAIM"))
			{
				CommonUtils.setGlobalObject("CLAIM_CALLING_FORM","CLAIM");
				outcome = "PILT007_PT_IL_CLAIM_PAID";
			}
			else if(payouttype.equalsIgnoreCase("LOAN"))
			{
				CommonUtils.setGlobalObject("CLAIM_CALLING_FORM","LOAN");
				outcome = "PILT004_PT_IL_LOAN";
			}
			else 
			{
				outcome = "";
			}
			
			/*helper.policyButPressed(compositeAction);
			if (compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
					.getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO() != null) {
				if (CLAIM_CALLING_FORM != null && !CLAIM_CALLING_FORM.isEmpty()
						&& CLAIM_CALLING_FORM.equalsIgnoreCase("PILT002_APAC")) {
					CommonUtils.setGlobalVariable("CLAIM_CALLING_FORM",
							"PILT002_APAC");
				} else {
					if (!"PILT002_APAC".equalsIgnoreCase(CommonUtils
							.getGlobalVariable("CALLING_FORM"))) {
						CommonUtils.setGlobalVariable("CLAIM_CALLING_FORM",
								"PILT006_APAC");
					}
				}
				System.out.println(CommonUtils
						.getGlobalVariable("CALLING_FORM"));
				System.out.println(CommonUtils
						.getGlobalVariable("CLAIM_CALLING_FORM"));
				CommonUtils.setGlobalVariable("CLAIM_ROW_ID", compositeAction
						.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
						.getROWID());
				CommonUtils.setGlobalObject("GLOBAL.M_CLM_SYS_ID",
						compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
								.getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());*/
			//}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		return outcome;
	}
	
	public String checklistStatus(PT_IL_PAYOUT_PROCESS PT_IL_PAYOUT_PROCESS_BEAN)
			throws Exception {
		Connection con = null;
		ResultSet rs = null;
		String msg = null;
		String selectQuery ="SELECT 'X' FROM PT_IL_OCD_DOC_TODO_LIST WHERE (OCD_DTL_POL_SYS_ID,OCD_DTL_TRANS_SYS_ID) IN (SELECT PP_POL_SYS_ID,PP_TRANS_SYS_ID FROM PT_IL_PAYOUT_PROCESS WHERE ROWID = ? AND OCD_DTL_APPR_STS = 'N')";
		try {
			con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(selectQuery, con, new Object[] { PT_IL_PAYOUT_PROCESS_BEAN.getROWID() });
			if(rs.next())
			{
				//compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getErrorMap().put("current", "Kindly Verify the Checklist");
				//throw new Exception("Kindly Verify the Checklist");
				msg = "Kindly Verify the Checklist";
			
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getErrorMap().put("current", e.getMessage());
			//throw new Exception(e.getMessage());
		}
		return msg;
	}
	
	private HtmlModalPanel COMP_STATUS_MODAL_PANEL;
	
	private HtmlAjaxCommandButton COMP_UI_M_BUT_OK;
	
	public HtmlModalPanel getCOMP_STATUS_MODAL_PANEL() {
		return COMP_STATUS_MODAL_PANEL;
	}

	public void setCOMP_STATUS_MODAL_PANEL(HtmlModalPanel cOMP_STATUS_MODAL_PANEL) {
		COMP_STATUS_MODAL_PANEL = cOMP_STATUS_MODAL_PANEL;
	}
	
	
	
	public String onclickCancel() {
		compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().setBlockFlag(true);
		CommonUtils.clearMaps(this);
		getCOMP_STATUS_MODAL_PANEL().setShowWhenRendered(false);
		return "PILT084_PT_IL_PAYOUT_PROCESS";
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlAjaxCommandButton cOMP_UI_M_BUT_OK) {
		COMP_UI_M_BUT_OK = cOMP_UI_M_BUT_OK;
	}

	/*Ok Button Action starts*/
	//Modified by kavitha on 10.02.2020 for orient
	//public String onclickOK() {
		//PILT084_COMPOSITE_ACTION_BEAN compositeAction = null;
	public void onclickOK(ActionEvent event) {
		String outCome = null;
		Connection conn =null;
		CommonUtils.clearMaps(this);
		try {
			
			conn = CommonUtils.getConnection();
			String message = null;
			String errormsg = null;
			String trans_type = null;
			if (PT_IL_PAYOUT_PROCESS_BEAN.getROWID() != null) {
				if(PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS().equalsIgnoreCase("ABO") )
				{
					errormsg = checklistStatus(PT_IL_PAYOUT_PROCESS_BEAN);
					if(errormsg != null)
					{
						compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getErrorMap().put("current", errormsg);
					}
					else
					{
						if (isUPDATE_ALLOWED()) {
							PRE_UPDATE(compositeAction);
							new CRUDHandler().executeUpdate(PT_IL_PAYOUT_PROCESS_BEAN,conn);
							conn.commit();
							
							/*Modified by Janani on 27.04.2020 for Orient UAT as suggested by Girish
							 desc :To update status for each process */
							
							
							P_OCD_UPD_ADDL_STATUS(PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),
									 PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID(),
									 PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE(),
									 PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS());
							
							
							//Added by kavitha on 09.01.2020 for ocd process
							/*if("CLAIM".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
								getClaimApproval(PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO());
								//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
								String updateQuery = "UPDATE PT_IL_CLAIM_PAID SET CP_SETL_STATUS = 'A' WHERE CP_SETL_STATUS = 'PO' AND CP_CLAIM_SYS_ID =  ?";
								new CRUDHandler().executeUpdateStatement(updateQuery, conn,
						    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
								conn.commit();
								//END
								
							}else if("POLICY CANCELLATION".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
//								getPolicyApproval(PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO());
								//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
								String updateQuery = "UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = 'I00' WHERE POL_ADDL_STATUS = 'PO' AND POL_SYS_ID =  ?";
								new CRUDHandler().executeUpdateStatement(updateQuery, conn,
						    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
								conn.commit();
								
								//END
								
							}else if("MATURITY".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
//								compositeAction.getPILT013_COMPOSITE_ACTION_BEAN().getDUMMY_ACTION_BEAN().approvalFromOcd(compositeAction.getPILT013_COMPOSITE_ACTION_BEAN(),
//										PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID());
								//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
								String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_ADDL_STATUS = 'A' WHERE SMV_ADDL_STATUS = 'PO' AND SMV_SYS_ID =  ?";
								new CRUDHandler().executeUpdateStatement(updateQuery, conn,
						    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
								conn.commit();
								//END
							}else if("SURRENDER".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
//								compositeAction.getPILT013_COMPOSITE_ACTION_BEAN().getDUMMY_ACTION_BEAN().approvalFromOcd(compositeAction.getPILT013_COMPOSITE_ACTION_BEAN(),
//										PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID());
								//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
								String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_ADDL_STATUS = 'A' WHERE SMV_ADDL_STATUS = 'PO' AND SMV_SYS_ID =  ?";
								new CRUDHandler().executeUpdateStatement(updateQuery, conn,
						    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
								conn.commit();
								//END
							}else if("PARTIAL SURRENDER".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
//								compositeAction.getPILT013_COMPOSITE_ACTION_BEAN().getDUMMY_ACTION_BEAN().approvalFromOcd(compositeAction.getPILT013_COMPOSITE_ACTION_BEAN(),
//										PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID());
								//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
								String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_ADDL_STATUS = 'A' WHERE SMV_ADDL_STATUS = 'PO' AND SMV_SYS_ID =  ?";
								new CRUDHandler().executeUpdateStatement(updateQuery, conn,
						    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
								conn.commit();
								//END
							}
							//Added by kavitha on 09.01.2020 for ocd process
							else if("SURVIVAL BENEFIT".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
//								compositeAction.getPILT013_COMPOSITE_ACTION_BEAN().getDUMMY_ACTION_BEAN().approvalFromOcd(compositeAction.getPILT013_COMPOSITE_ACTION_BEAN(),
//										PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID());
								//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
								String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_ADDL_STATUS = 'A' WHERE SMV_ADDL_STATUS = 'PO' AND SMV_SYS_ID =  ?";
								new CRUDHandler().executeUpdateStatement(updateQuery, conn,
						    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
								//END
							}
							else if("DEPOSIT REFUND".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
//								compositeAction.getPILT013_COMPOSITE_ACTION_BEAN().getDUMMY_ACTION_BEAN().approvalFromOcd(compositeAction.getPILT013_COMPOSITE_ACTION_BEAN(),
//										PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID());
								//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
								String updateQuery = "UPDATE PT_IL_RECEIPT_TRANS_DTL SET RTD_ADDL_STATUS = 'A' WHERE RTD_ADDL_STATUS = 'PO' AND RTD_SYS_ID =  ?";
								new CRUDHandler().executeUpdateStatement(updateQuery, conn,
						    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
								//END
							}
							conn.commit();
							*
							*/
							
							
							/*End*/
							
						}
						
					
					message = "Approved Successfully";
					}
				}
				else if(PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS().equalsIgnoreCase("RBO"))
				{
					if (isUPDATE_ALLOWED()) {
						PRE_UPDATE(compositeAction);
						new CRUDHandler().executeUpdate(PT_IL_PAYOUT_PROCESS_BEAN,conn);
					}
					conn.commit();
					if (PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE()
							.equalsIgnoreCase("SURRENDER")
							|| PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE()
									.equalsIgnoreCase("MATURITY")
							|| PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE()
									.equalsIgnoreCase("PARTIAL SURRENDER")) {
						trans_type = "SM";
					}
					else if(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE()
							.equalsIgnoreCase("CLAIM"))
					{
						trans_type = "C";
					}
					else
					{
						trans_type = "L";
					}
					
					
					/*Modified by Janani on 27.04.2020 for Orient UAT as suggested by Girish
					 desc :To update status for each process */
					
					
					P_OCD_UPD_ADDL_STATUS(PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),
							 PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID(),
							 PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE(),
							 PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS());
					
					
					//Added by kavitha on 09.01.2020 for ocd process
					/*if("CLAIM".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
						getClaimApproval(PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO());
						//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
						String updateQuery = "UPDATE PT_IL_CLAIM_PAID SET CP_SETL_STATUS = 'R' WHERE CP_SETL_STATUS = 'PO' AND CP_CLAIM_SYS_ID =  ?";
						new CRUDHandler().executeUpdateStatement(updateQuery, conn,
				    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
						//END
						
					}else if("POLICY CANCELLATION".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
						getPolicyApproval(PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO());
						//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
						String updateQuery = "UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = 'R' WHERE POL_ADDL_STATUS = 'PO' AND POL_SYS_ID =  ?";
						new CRUDHandler().executeUpdateStatement(updateQuery, conn,
				    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
						//END
						
					}else if("MATURITY".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
						compositeAction.getPILT013_COMPOSITE_ACTION_BEAN().getDUMMY_ACTION_BEAN().approvalFromOcd(compositeAction.getPILT013_COMPOSITE_ACTION_BEAN(),
								PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID());
						//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
						String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_ADDL_STATUS = 'R' WHERE SMV_ADDL_STATUS = 'PO' AND SMV_SYS_ID =  ?";
						new CRUDHandler().executeUpdateStatement(updateQuery, conn,
				    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
						//END
					}else if("SURRENDER".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
						compositeAction.getPILT013_COMPOSITE_ACTION_BEAN().getDUMMY_ACTION_BEAN().approvalFromOcd(compositeAction.getPILT013_COMPOSITE_ACTION_BEAN(),
								PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID());
						//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
						String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_ADDL_STATUS = 'R' WHERE SMV_ADDL_STATUS = 'PO' AND SMV_SYS_ID =  ?";
						new CRUDHandler().executeUpdateStatement(updateQuery, conn,
				    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
						//END
					}else if("PARTIAL SURRENDER".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
						compositeAction.getPILT013_COMPOSITE_ACTION_BEAN().getDUMMY_ACTION_BEAN().approvalFromOcd(compositeAction.getPILT013_COMPOSITE_ACTION_BEAN(),
								PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID());
						//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
						String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_ADDL_STATUS = 'R' WHERE SMV_ADDL_STATUS = 'PO' AND SMV_SYS_ID =  ?";
						new CRUDHandler().executeUpdateStatement(updateQuery, conn,
				    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
						//END
					}
					//Added by kavitha on 09.01.2020 for ocd process
					else if("SURVIVAL BENEFIT".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
						compositeAction.getPILT013_COMPOSITE_ACTION_BEAN().getDUMMY_ACTION_BEAN().approvalFromOcd(compositeAction.getPILT013_COMPOSITE_ACTION_BEAN(),
								PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID());
						//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
						String updateQuery = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_ADDL_STATUS = 'R' WHERE SMV_ADDL_STATUS = 'PO' AND SMV_SYS_ID =  ?";
						new CRUDHandler().executeUpdateStatement(updateQuery, conn,
				    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
						//END
					}
					else if("DEPOSIT REFUND".equalsIgnoreCase(PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_TYPE())){
						compositeAction.getPILT013_COMPOSITE_ACTION_BEAN().getDUMMY_ACTION_BEAN().approvalFromOcd(compositeAction.getPILT013_COMPOSITE_ACTION_BEAN(),
								PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_NO(),PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID());
						//Added by rakesh on 27-03-2020 for claims approval from ocd Status updation
						String updateQuery = "UPDATE PT_IL_RECEIPT_TRANS_DTL SET RTD_ADDL_STATUS = 'R' WHERE RTD_ADDL_STATUS = 'PO' AND RTD_SYS_ID =  ?";
						new CRUDHandler().executeUpdateStatement(updateQuery, conn,
				    			new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_TRANS_SYS_ID()}); 
						//END
					}
					conn.commit();
					*
					*
					*/
					/*End*/
					
					
					//END
				
					message = "Rejected Successfully";
				}
				else
				{
					if (isUPDATE_ALLOWED()) {
						PRE_UPDATE(compositeAction);
						new CRUDHandler().executeUpdate(PT_IL_PAYOUT_PROCESS_BEAN,conn);
					}
					conn.commit();
					System.out.println("success");
				}
				
				String status = PT_IL_PAYOUT_PROCESS_BEAN.getPP_PAYOUT_STATUS();
				
				if(status!=null){
					if (status.equalsIgnoreCase("N")) {
						PT_IL_PAYOUT_PROCESS_BEAN
								.setPP_PAYOUT_STATUS("Approved by Operations");
					} else if (status.equalsIgnoreCase("A")) {
						PT_IL_PAYOUT_PROCESS_BEAN
								.setPP_PAYOUT_STATUS("Approved by OCD");
					} else if(status.equalsIgnoreCase("R")) {
						PT_IL_PAYOUT_PROCESS_BEAN
								.setPP_PAYOUT_STATUS("Rejected by OCD");
					}else if(status.equalsIgnoreCase("S")) {
						PT_IL_PAYOUT_PROCESS_BEAN
						.setPP_PAYOUT_STATUS("Settled by OCD");
					}else if(status.equalsIgnoreCase("CPO")) {
						PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Cheque Provided to Operations");
					}else if(status.equalsIgnoreCase("CHC")) {
						PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Cheque Handed-over to Client");
					}
					else if(status.equalsIgnoreCase("US")) {
						PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Under Signature");
					}
					
					else if(status.equalsIgnoreCase("P")) {
						PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Premium Possiession not Statisfied");
					}
					else if(status.equalsIgnoreCase("D")) {
						PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Request For Details");
					}
					
				}
			}
			
			/*Added by saritha on 07-01-2020 for Orient - OCD Payout Process(Premium Position not Statisfied - Email Trigger)*/
			
			String query = "SELECT POL_SYS_ID,POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ? ";
			ResultSet resultset= null;
			String pol_Sys_Id= null;
			String pol_Prod_Code=null;
			
			resultset = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
					new Object[]{PT_IL_PAYOUT_PROCESS_BEAN.getPP_POL_SYS_ID()});
			if(resultset.next()){
				pol_Sys_Id = resultset.getString("POL_SYS_ID");
				pol_Prod_Code=resultset.getString("POL_PROD_CODE");

			}
			
			if(PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS()!=null &&PT_IL_PAYOUT_PROCESS_BEAN.getUI_M_PAYOUT_STATUS().equalsIgnoreCase("PPS")){
				
				message = emailStatusMsg(pol_Prod_Code, "PPNS", pol_Sys_Id.toString(), "C", "");
			
			}
			
			//executeQuery(compositeAction);
			//CommonUtils.setGlobalVariable("CALLING_FORM", "OCD_APPRV");
			//CommonUtils.setGlobalVariable("M_OCD_ROWNO", PT_IL_PAYOUT_PROCESS_BEAN.getPP_SYS_ID().toString());
			
			/*End*/		
			
			getWarningMap().put(
					"current",message);
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getErrorMap().put("current", e.getMessage());
			outCome = "";
			
		}
		//return outCome;
	}
	
	//END
	
	//Added by kavitha on 09.01.2020 for ocd process
	public void getClaimApproval(Long trans_sys_id, String pol_no){
		//String query = "SELECT CP_CE_SYS_ID FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID = ?";
		String query = "SELECT CP_CE_SYS_ID,CLAIM_NO FROM PT_IL_CLAIM_PAID,PT_IL_CLAIM WHERE CLAIM_SYS_ID=CP_CLAIM_SYS_ID AND CP_CLAIM_SYS_ID = ?";
		String query1 = "SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ? AND POL_DS_TYPE='2'";
		ResultSet rs = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		Long CP_CE_SYS_ID = null;
		String P_CUST_TYPE="C";
		String prod_code = null;
		Long pol_sys_id = null;
		String claim_no=null;
		String message = null;
		try{
			rs = handler.executeSelectStatement(query,
					CommonUtils.getConnection(), new Object[] {trans_sys_id});
			while (rs.next()) {
				CP_CE_SYS_ID = rs.getLong(1);
				claim_no = rs.getString(2);
			}
			
			
			rs1 = handler.executeSelectStatement(query1,
					CommonUtils.getConnection(), new Object[] {pol_no});
			while (rs1.next()) {
				prod_code = rs1.getString("POL_PROD_CODE");
				pol_sys_id = rs1.getLong("POL_SYS_ID");
			}
			//Added by kavitha on 22.01.2020 for ocd claim RI
		  	 CommonUtils.setGlobalVariable("CALLING_FORM","OCD");
			 /*compositeAction.getPILP008_DUMMY_ACTION_BEAN().claimApproval(trans_sys_id,pol_no,CP_CE_SYS_ID,claim_no);*/
			 
			 
			 String emailStatusmessage = Email_Procedure_Call.emailStatusMsg(prod_code,"OCDCLM",String.valueOf(pol_sys_id),P_CUST_TYPE,"");
			 message =  emailStatusmessage;
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//END
	
	//Added by kavitha on 30.01.2020 for ocd process
	public void getPolicyApproval(Long M_POL_SYS_ID,String M_POL_NO){
		String query = "SELECT POL_END_CODE,POL_APL_YN,POL_END_TYPE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String message = null;
		String M_POL_END_CODE = null;
		String M_POL_APL_YN = null;
		String M_POL_END_TYPE = null;
		try{
			rs = handler.executeSelectStatement(query,
					CommonUtils.getConnection(), new Object[] {M_POL_SYS_ID});
			while (rs.next()) {
				M_POL_END_CODE = rs.getString("POL_END_CODE");
				M_POL_APL_YN = rs.getString("POL_APL_YN");
				M_POL_END_TYPE = rs.getString("POL_END_TYPE");
			}
			
			/*compositeAction.getDUMMY_ACTION_BEAN().policyCancelApproval(M_POL_END_CODE,M_POL_APL_YN,M_POL_END_TYPE,M_POL_NO,M_POL_SYS_ID);*/
		
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//END
	private List<SelectItem> PP_PAYOUT_STATUS_LIST = new ArrayList<SelectItem>();
	
	public List<SelectItem> getPP_PAYOUT_STATUS_LIST() throws Exception {

		if (PP_PAYOUT_STATUS_LIST.size() == 0) {
			PP_PAYOUT_STATUS_LIST.clear();
			PP_PAYOUT_STATUS_LIST = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(),
					"PILT084", "PT_IL_PAYOUT_PROCESS",
					"PT_IL_PAYOUT_PROCESS.PP_PAYOUT_STATUS", "PAYOUT_STAT");

		}
		return PP_PAYOUT_STATUS_LIST;
	}

	public void setPP_PAYOUT_STATUS_LIST(List<SelectItem> pP_PAYOUT_STATUS_LIST) {
		PP_PAYOUT_STATUS_LIST = pP_PAYOUT_STATUS_LIST;
	}

	
	public void validatorUI_M_PAYOUT_STATUS(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			String objValue = (String)value;
			getPT_IL_PAYOUT_PROCESS_BEAN().setUI_M_PAYOUT_STATUS(objValue);
			if(objValue.equalsIgnoreCase("ABO"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Approved By OCD");
			}
			else if(objValue.equalsIgnoreCase("RBO"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Rejected by OCD");
			}
			else if(objValue.equalsIgnoreCase("RFD"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Request for Details");
			}
			
			/*Added by saritha on 07-01-2020 for Orient - OCD Payout Process(Premium Position not Statisfied - Email Trigger)*/
			else if(objValue.equalsIgnoreCase("PPS"))
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Premium Possiession not Statisfied");
			}
			/*End*/
			else
			{
				PT_IL_PAYOUT_PROCESS_BEAN.setPP_PAYOUT_STATUS("Approved by Operations");
			}
			
			getPT_IL_PAYOUT_PROCESS_BEAN().setPP_PAYOUT_STATUS(objValue);
			compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getCOMP_PP_PAYOUT_STATUS().resetValue();
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(
						CommonUtils.getConnection(), context,
						component.getId(), getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public HtmlOutputLabel getCOMP_UI_M_PAYOUT_STATUS_LABEL() {
		return COMP_UI_M_PAYOUT_STATUS_LABEL;
	}

	public void setCOMP_UI_M_PAYOUT_STATUS_LABEL(
			HtmlOutputLabel cOMP_UI_M_PAYOUT_STATUS_LABEL) {
		COMP_UI_M_PAYOUT_STATUS_LABEL = cOMP_UI_M_PAYOUT_STATUS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PAYOUT_STATUS() {
		return COMP_UI_M_PAYOUT_STATUS;
	}

	public void setCOMP_UI_M_PAYOUT_STATUS(HtmlSelectOneMenu cOMP_UI_M_PAYOUT_STATUS) {
		COMP_UI_M_PAYOUT_STATUS = cOMP_UI_M_PAYOUT_STATUS;
	}

	private HtmlOutputLabel COMP_UI_M_PAYOUT_STATUS_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_PAYOUT_STATUS;
	 
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public HtmlOutputLabel getCOMP_UI_M_REMARKS_LABEL() {
		return COMP_UI_M_REMARKS_LABEL;
	}

	public void setCOMP_UI_M_REMARKS_LABEL(HtmlOutputLabel cOMP_UI_M_REMARKS_LABEL) {
		COMP_UI_M_REMARKS_LABEL = cOMP_UI_M_REMARKS_LABEL;
	}

	public HtmlInputTextarea getCOMP_UI_M_REMARKS() {
		return COMP_UI_M_REMARKS;
	}

	public void setCOMP_UI_M_REMARKS(HtmlInputTextarea cOMP_UI_M_REMARKS) {
		COMP_UI_M_REMARKS = cOMP_UI_M_REMARKS;
	}

	private HtmlOutputLabel COMP_UI_M_REMARKS_LABEL;
	private HtmlInputTextarea COMP_UI_M_REMARKS;

	
	public void validatorUI_M_REMARKS(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			String objValue = (String)value;
			getPT_IL_PAYOUT_PROCESS_BEAN().setUI_M_REMARKS(objValue);
			
			getPT_IL_PAYOUT_PROCESS_BEAN().setPP_PAYOUT_REMARK(objValue);
			compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getCOMP_PP_PAYOUT_REMARK().resetValue();
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(
						CommonUtils.getConnection(), context,
						component.getId(), getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public ArrayList<OracleParameter>  P_GEN_CLM_REJECT_DB_NOTE(Object P_TRANS_SYS_ID,
			Object P_POL_SYS_ID, Object P_TRANS_TYPE)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_TRANS_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_TRANS_TYPE);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_GEN_CLM_REJECT_DB_NOTE");
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	/*Added by kavitha for RoadMap*/
	public String backButton() {
		String outcome = null;

		String todmsworkflow=CommonUtils.getGlobalVariable("backValue");
		if(!"".equals(todmsworkflow)&&todmsworkflow!=null)
		{
			outcome=todmsworkflow;
			CommonUtils.setGlobalVariable("backValue", "");
		}else{
			outcome = "";
		}
		return outcome;
		
	}
	


	private HtmlCommandLink COMP_BACK_BUTTON;


	public HtmlCommandLink getCOMP_BACK_BUTTON() {
		return COMP_BACK_BUTTON;
	}

	public void setCOMP_BACK_BUTTON(HtmlCommandLink cOMP_BACK_BUTTON) {
		COMP_BACK_BUTTON = cOMP_BACK_BUTTON;
	}

/*End*/
	
	/*Added by saritha on 03-01-2020 for ORIENT - OCD Payout Process Policy No.&Payee Name column added*/
	
	private HtmlOutputLabel COMP_PP_POL_NO_LABEL;
	private HtmlInputText COMP_PP_POL_NO;
	private HtmlOutputLabel COMP_PP_PAYEE_NAME_LABEL;
	private HtmlInputText COMP_PP_PAYEE_NAME;

	public HtmlOutputLabel getCOMP_PP_POL_NO_LABEL() {
		return COMP_PP_POL_NO_LABEL;
	}

	public void setCOMP_PP_POL_NO_LABEL(HtmlOutputLabel cOMP_PP_POL_NO_LABEL) {
		COMP_PP_POL_NO_LABEL = cOMP_PP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_PP_POL_NO() {
		return COMP_PP_POL_NO;
	}

	public void setCOMP_PP_POL_NO(HtmlInputText cOMP_PP_POL_NO) {
		COMP_PP_POL_NO = cOMP_PP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_PP_PAYEE_NAME_LABEL() {
		return COMP_PP_PAYEE_NAME_LABEL;
	}

	public void setCOMP_PP_PAYEE_NAME_LABEL(HtmlOutputLabel cOMP_PP_PAYEE_NAME_LABEL) {
		COMP_PP_PAYEE_NAME_LABEL = cOMP_PP_PAYEE_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PP_PAYEE_NAME() {
		return COMP_PP_PAYEE_NAME;
	}

	public void setCOMP_PP_PAYEE_NAME(HtmlInputText cOMP_PP_PAYEE_NAME) {
		COMP_PP_PAYEE_NAME = cOMP_PP_PAYEE_NAME;
	}
	
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
	HttpSession session = request.getSession();
	
	private HtmlCommandButton COMP_UI_M_BUT_REPORT;

	public HtmlCommandButton getCOMP_UI_M_BUT_REPORT() {
		return COMP_UI_M_BUT_REPORT;
	}

	public void setCOMP_UI_M_BUT_REPORT(HtmlCommandButton cOMP_UI_M_BUT_REPORT) {
		COMP_UI_M_BUT_REPORT = cOMP_UI_M_BUT_REPORT;
	}
	
	private IP_REP_INFO  IP_REP_INFO_BEAN; 
	
	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO iP_REP_INFO_BEAN) {
		IP_REP_INFO_BEAN = iP_REP_INFO_BEAN;
	}
	
    private HtmlModalPanel COMP_REPORT_MODAL_PANEL;
	
	private HtmlAjaxCommandButton COMP_CANCEL_BUTTON;

	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
	}

	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_REPORT_MODAL_PANEL) {
		COMP_REPORT_MODAL_PANEL = cOMP_REPORT_MODAL_PANEL;
	}

	public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON() {
		return COMP_CANCEL_BUTTON;
	}

	public void setCOMP_CANCEL_BUTTON(HtmlAjaxCommandButton cOMP_CANCEL_BUTTON) {
		COMP_CANCEL_BUTTON = cOMP_CANCEL_BUTTON;
	}

	StringBuffer url=null;
	public String runActionAfterValidate() {CommonUtils.clearMaps(this);
	HttpServletResponse response = null;
	
	try {

	   IP_REP_INFO repInfo = new IP_REP_INFO();

		String REPIdQry = "SELECT PMRTH_REP_ID FROM PM_REP_TAB_HDR WHERE PMRTH_REP_TYPE='PREPO' AND PMRTH_REP_CATG='LJ'";
		ResultSet rs= new CRUDHandler().executeSelectStatement(REPIdQry, CommonUtils.getConnection());
		String Report_Id = null;
		if(rs.next()){
			Report_Id = rs.getString("PMRTH_REP_ID");
		}
		Report_Id = "PREOCD600";
		String User_Id = (String) session.getAttribute("GLOBAL.M_USER_ID");
		String REP_KEY_NO = new ReportUtils().getRepKeyNo();
		String reportNames = null;
		
		String reportQuery = "SELECT PMRTH_MULTIPLE_REPORT_NAMES FROM pm_rep_tab_hdr WHERE pmrth_rep_id = ?";
		ResultSet reportRS = new CRUDHandler().executeSelectStatement(reportQuery, CommonUtils.getConnection(),new Object[]{Report_Id});
		while(reportRS.next())
		{
			reportNames = reportRS.getString(1);
		}

		String url5 = System.getProperty("user.home");
		System.out.println(url5);
	
		System.out.println("REP_KEY_NO          :"+REP_KEY_NO);
		repInfo.setREP_KEY_NO(REP_KEY_NO);
		repInfo.setREP_ID(Report_Id);
		repInfo.setREP_VALUE_1("1");
		repInfo.setREP_VALUE_3("PP_SYS_ID"+"&&&"+PT_IL_PAYOUT_PROCESS_BEAN.getPP_SYS_ID());
		if(reportNames != null)
		{
			repInfo.setREP_VALUE_59(reportNames);	
		}
			
		Connection conn = CommonUtils.getConnection();
		int ins = new CRUDHandler().executeInsert(repInfo, conn);
		conn.commit();
					
		url=new StringBuffer(getRedirectUrl());
		System.out.println("this is url"+url.toString());
		url.append("REP_KEY_NO="+REP_KEY_NO+"&REP_ID="+Report_Id);	
		setRedirectUrl(url.toString());	
		
		if (getRedirectUrl() != null) {
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			System.out.println("CommonReportAction.runActionAfterValidate: "+getRedirectUrl());
			
			response.sendRedirect(getRedirectUrl());
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("runAction", e.getMessage());
	}
	return null;
	}
	

	public String runAction(){
		try {
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
		
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}
	
	
	public String printButtonAction() {

		System.out.println("Enter printButtonAction");
		callReportModalPanel();

		return getRedirectUrl();
	}
	

	
	
	/*End*/
	
	
	/*Added by saritha on 07-01-2020 for Orient - OCD Payout Process(Premium Position not Statisfied - Email Trigger)*/
	
	public static String emailStatusMsg(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH) throws Exception

	{
		StringBuilder statusMessge =  new StringBuilder(" - ");

		String mailFlag = Email_Procedure_Call.emailTriggerProcCall(P_PROD_CODE, P_MAIL_TYPE, P_POL_SYS_ID, P_CUST_TYPE, P_MAIL_PATH,CommonUtils.getConnection());


		System.out.println("Mail status Flag--->["+mailFlag+"]--- P_CUST_TYPE ["+P_CUST_TYPE+"]");

		if((P_CUST_TYPE.equalsIgnoreCase("B"))){

			if(mailFlag!=null && mailFlag.equals("YY")){

				statusMessge.append("Your Proposal Status Mail sent sucessfully");

			}else if(mailFlag!=null && mailFlag.equals("T")){

				statusMessge.append("Email template is unavailable in master setup "+Email_Procedure_Call.templateDescription(P_MAIL_TYPE));

			}else if(mailFlag!=null && mailFlag.equalsIgnoreCase("NN")){

				statusMessge.append("Unable to send the email due to the unavailability of both Customer and Agent email id");

			}else if(mailFlag!=null && mailFlag.equalsIgnoreCase("NY")){

				statusMessge.append("Unable to send the email due to the unavailability of Customer email id");

			}else if(mailFlag!=null && mailFlag.equalsIgnoreCase("YN")){

				statusMessge.append("Unable to send the email due to the unavailability of Agent email id");

			}
			else if(mailFlag!=null && mailFlag.equalsIgnoreCase("Y")){   

				statusMessge.append("Your Proposal Status Mail sent sucessfully");
			}else{
				statusMessge.append("Unable to send the email due to the unavailability of both Customer and Agent email id");
			}

		}else{

			if(mailFlag!=null && mailFlag.equals("Y")){

				statusMessge.append("Your Proposal Status Mail sent sucessfully");

			}else if(mailFlag!=null && mailFlag.equals("T")){

				statusMessge.append("Email template is unavailable in master setup "+Email_Procedure_Call.templateDescription(P_MAIL_TYPE));

			}else {

				if(P_CUST_TYPE.equalsIgnoreCase("C")){
					statusMessge.append("Mail sent sucessfully");
				}else if(P_CUST_TYPE.equalsIgnoreCase("A")){
					statusMessge.append("Unable to send the email due to the unavailability of Agent email id");
				}

			}


		}

		return statusMessge.toString();   

	}
	
    /*End*/
	
	/*Added by saritha on 21.01.2020 for Orient Desc : DMS Integration RedirectUrl*/

	public void callDMSModalPanel(ActionEvent event) {
		String input = event.getComponent().getId();
		runActionDMS();
		try {

			String dmsUrl = resourceBundleApp.getString("dms_url");
			setRedirectUrl(dmsUrl);

			/*if (getRedirectUrl() != null) {
				getCOMP_DMS_MODAL_PANEL().setShowWhenRendered(true);
			} else {
				getCOMP_DMS_MODAL_PANEL().setShowWhenRendered(false);
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public String runActionDMS(){
		try {
			
			String dmsUrl = resourceBundleApp.getString("dms_url");
			setRedirectUrl(dmsUrl);
		
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("DMS", e.getMessage());
		}
		return getRedirectUrl();
	}
	

	 /*End*/
	
	
	/*Modified by Janani on 27.04.2020 for Orient UAT as suggested by Girish
	 desc :To update status for each process */
	
	public ArrayList<OracleParameter>  P_OCD_UPD_ADDL_STATUS(
			Object P_POL_SYS_ID,
			Object P_TRANS_SYS_ID,
			 Object P_PAYOUT_TYPE,
			 Object P_STATUS)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_TRANS_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PAYOUT_TYPE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_STATUS);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_PROCESS.P_OCD_UPD_ADDL_STATUS");
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	 
	
}