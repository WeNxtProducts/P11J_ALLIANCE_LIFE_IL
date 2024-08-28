package com.iii.pel.common.workflow;
/* Added by kavitha for RoadMap*/
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.richfaces.component.html.HtmlTab;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILP134.PILP134_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT006_APAC.PILT006_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT013.PILT013_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT016A_APAC.PILT016A_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT021.PILT021_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT084.PILT084_COMPOSITE_ACTION_BEAN;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class WORKFLOW_DMS_ACTION extends CommonAction {
	private List<PGIM_WORKFLOW_BUCKET> pgimList;
	private List<Pgiw_wf_tran_dtls> pgiwList;
	String appPayment;
	String claimApproved;
	private Pgiw_wf_tran_dtls Pgiw_wf_tran_dtls_bean;
	/* Added by kavitha for RoadMap on 01.11.2019*/
	private List<PGIM_WORKFLOW_BUCKET> pgimUnAssignedList;
	private List<Pgiw_wf_tran_dtls> pgiwUnAssignedList;
	private UIData unAssignedTaskDataTable;
	private List<SelectItem> unassignedUserList = new ArrayList<SelectItem>();
	private UIData dataTable;
	private HtmlCommandButton COMP_SAVE_BUTTON;
	private WORKFLOW_HELPER helper;
	public WORKFLOW_DMS_ACTION(){
		Pgiw_wf_tran_dtls_bean = new Pgiw_wf_tran_dtls();
		helper=new WORKFLOW_HELPER();
		
	}
	
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public String getClaimApproved() {
		return claimApproved;
	}
	public void setClaimApproved(String claimApproved) {
		this.claimApproved = claimApproved;
	}
	public String getAppPayment() {
		return appPayment;
	}
	public void setAppPayment(String appPayment) {
		this.appPayment = appPayment;
	}
	public List<PGIM_WORKFLOW_BUCKET> getPgimList() {
		return pgimList;
	}
	public void setPgimList(List<PGIM_WORKFLOW_BUCKET> pgimList) {
		this.pgimList = pgimList;
	}
	public List<Pgiw_wf_tran_dtls> getPgiwList() {
		return pgiwList;
	}
	public void setPgiwList(List<Pgiw_wf_tran_dtls> pgiwList) {
		this.pgiwList = pgiwList;
	}
	
	
	public void getWorkFlowDetails()
	{
		//WORKFLOW_HELPER helper= new WORKFLOW_HELPER();
		try {
			pgimList=helper.getWorkFlowBucket();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getWorkFlowUnAssignedDetails()
	{
		//WORKFLOW_HELPER helper= new WORKFLOW_HELPER();
		try {
			pgimUnAssignedList=helper.getWorkFlowUnAssignedBucket();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onLoad(PhaseEvent event) {
		try {
			String userId =CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			if(userId!=null){
				Connection connection = CommonUtils.getConnection();
				unassignedUserList= getDropDownListValue(connection,userId);
				CommonUtils.getConnection().commit();
			}
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
       public void saveRecord(){
		
		String message = null;
		CommonUtils.clearMaps(this);
		getErrorMap().clear();
		getWarningMap().clear();
		String UpdateQuery="UPDATE PGIW_WF_TRAN_HDR SET PWTH_USER_ID = ? WHERE PWTH_SYS_ID = ?";
		//String UpdateQuery1="UPDATE PGIW_WF_TRAN_DTLS SET PWTD_CR_UID = ? WHERE PWTD_PWTH_SYS_ID = ?";
		try {
					/*String sys_Id = pgiwUnAssignedList.get(0).getSys_Id();
					String assignTaskTo = pgiwUnAssignedList.get(0).getAssignTaskTo();*/
					
					String sys_Id =Pgiw_wf_tran_dtls_bean.getSys_Id();
					String assignTaskTo = Pgiw_wf_tran_dtls_bean.getAssignTaskTo();
					
					System.out.println("##Save_Sys_Id##" + sys_Id);
					System.out.println("##Save_assignTaskTo##" + assignTaskTo);
					new CRUDHandler().executeUpdateStatement(UpdateQuery,CommonUtils.getConnection(),
							new Object[]{assignTaskTo,sys_Id});
					
					/*new CRUDHandler().executeUpdateStatement(UpdateQuery1,CommonUtils.getConnection(),
							new Object[]{Pgiw_wf_tran_dtls_bean.getAssignTaskTo(),Pgiw_wf_tran_dtls_bean.getSys_Id()});*/
					
					CommonUtils.getConnection().commit();
					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("SAVE", message);
					
	    } catch (Exception e) {
			e.printStackTrace();
			String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, error);
			getErrorMap().put("SAVE", error);

		}
	}
    
    
	
	public static List<SelectItem> getDropDownListValue(Connection connection,String userId)throws Exception{
		List<SelectItem> listValues = null;
		String query = "SELECT * FROM MENU_USER WHERE USER_GROUP_ID IN (SELECT USER_GROUP_ID FROM MENU_USER WHERE USER_ID ='"+userId+"')" ;
		CRUDHandler handler = null;
		ResultSet rst = null;
			try {
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(query, connection);
				listValues = new ArrayList<SelectItem>();
				
				while(rst.next()){
					listValues.add(new SelectItem(rst.getString("USER_ID")));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				try{
					CommonUtils.closeCursor(rst);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			System.out.println("###listValues### " + listValues.size() +" ###listsize### "+ listValues.size());
		return listValues;
	}
	public void setUser(ActionEvent event)throws Exception {
		try{
			CommonUtils.clearMaps(this);
			String labelName = (String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			getUser(labelName);
			Pgiw_wf_tran_dtls_bean.setAssignTaskTo(labelName);
			System.out.println("###setAssignTaskTo### " + Pgiw_wf_tran_dtls_bean.getAssignTaskTo());
			int currentIndex=this.dataTable.getRowIndex();
			System.out.println("Rowid_tobe_selected..........>>>> "	+ currentIndex);		
			
			Pgiw_wf_tran_dtls_bean = (Pgiw_wf_tran_dtls) pgiwUnAssignedList.get(currentIndex);
		
			pgiwUnAssignedList.set(currentIndex, Pgiw_wf_tran_dtls_bean);
			System.out.println("###currentIndex### " + currentIndex +" ##Pgiw_wf_tran_dtls_bean## "+ Pgiw_wf_tran_dtls_bean);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getUser(String labelName){
		String user = null;
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
				String C1 = "SELECT * FROM PGIW_WF_TRAN_HDR WHERE PWTH_SYS_ID= ? ";
				con = CommonUtils.getConnection();
				rs1 = handler.executeSelectStatement(C1, con,
						new Object[] {Pgiw_wf_tran_dtls_bean.getSys_Id()});
				while (rs1.next()) {
					user = rs1.getString("PWTH_USER_ID");
				}
				if(labelName.equals(user)){
					COMP_SAVE_BUTTON.setDisabled(true);
				}else{
					COMP_SAVE_BUTTON.setDisabled(false);
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
					
	}
	
	
	
	public String executeQuery()
	{
		String outcome=null;
		Date dueDate= null;
		String deptCode=CommonUtils.getControlBean().getM_DEPT_CODE();
		String userId=CommonUtils.getControlBean().getUSER_ID();
		CommonUtils.clearMaps(this);
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWB_WORKSTEP_ID = req.getParameter("PWB_WORKSTEP_ID");
		
		String PWB_CODE  = req.getParameter("PWB_CODE");
		String PWB_MAIN_BUKT  = req.getParameter("PWB_MAIN_BUKT");
		
		//WORKFLOW_HELPER helper= new WORKFLOW_HELPER();
		Connection con = null;
		ResultSet rs1 = null;

		CRUDHandler handler = new CRUDHandler();
		try {
			
			pgiwList=helper.getWorkFlowDetails(PWB_WORKSTEP_ID,userId,deptCode);
			/*added by raja on 15-05-17*/
			
			
			outcome=helper.getOutcome(PWB_WORKSTEP_ID);
			
			
				if("CEIL".equals(PWB_WORKSTEP_ID))
				{
				appPayment="AppPayment";
				}
				if("CAL".equals(PWB_WORKSTEP_ID))
				{
				appPayment="claimApproved";
				}
				
				if("PFIL".equals(PWB_WORKSTEP_ID)){
					CommonUtils.setGlobalVariable("WFRCPT", "Y");
				}
			/*commented by raja on 15-05-17*/
			/*if("POIL".equals(PWB_WORKSTEP_ID))
			{
				outcome="WORKFLOW_DMS_DETAIL";
			}
			if("CIIL".equals(PWB_WORKSTEP_ID))
			{
				outcome="WORKFLOW_CLAIM_DETAIL";
			}
			if("CEIIL".equals(PWB_WORKSTEP_ID)||"CEIL".equals(PWB_WORKSTEP_ID)||"CAL".equals(PWB_WORKSTEP_ID))
			{
				if("CEIL".equals(PWB_WORKSTEP_ID))
				{
				appPayment="AppPayment";
				}
				if("CAL".equals(PWB_WORKSTEP_ID))
				{
				appPayment="claimApproved";
				}
				
				
				
				outcome="WORKFLOW_APPENDING_DETAIL";
			}
			if("POAIL".equals(PWB_WORKSTEP_ID)||"PAIL".equals(PWB_WORKSTEP_ID))
			{
				outcome="WORKFLOW_APPROVED_DETAIL";
			}*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
		
	}
	
	
	public String executeUnAssignedQuery()
	{
		String outcome=null;
		String deptCode=CommonUtils.getControlBean().getM_DEPT_CODE();
		String userId=CommonUtils.getControlBean().getUSER_ID();
		CommonUtils.clearMaps(this);
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWB_WORKSTEP_ID = req.getParameter("PWB_WORKSTEP_ID");
		try {
			System.out.println("##workstep## " +PWB_WORKSTEP_ID + "##userId##" + userId + "##deptCode##" +deptCode);
			pgiwUnAssignedList=helper.getWorkFlowUnAssignedDetails(PWB_WORKSTEP_ID,userId,deptCode);
			
			outcome=helper.getToBeOutcome(PWB_WORKSTEP_ID);
			
				if("CEIL".equals(PWB_WORKSTEP_ID))
				{
				appPayment="AppPayment";
				}
				if("CAL".equals(PWB_WORKSTEP_ID))
				{
				appPayment="claimApproved";
				}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outcome;
		
	}
	
	public String executePolicyScreen() {
		String outcome = null;
		//PT_GL_POLICY_SEARCH_ACTION PT_GL_POLICY_SEARCH_ACTION= new PT_GL_POLICY_SEARCH_ACTION();
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		String getRecpt= CommonUtils.getGlobalVariable("WFRCPT");
		try {
			if(getRecpt !=null && "Y".equals(getRecpt)){
				outcome = "PILT016A_APAC_PT_IL_DEPOSIT";
				String polno=this.getPolicyNO(PWTH_DOC_NO);
				CommonUtils.setGlobalVariable("backValue", OUT_COME);
				CommonUtils.setGlobalVariable("WORKFLOW_RECIEPT_POL_NO", polno);
				PILT016A_APAC_COMPOSITE_ACTION compositeAction = new PILT016A_APAC_COMPOSITE_ACTION();
				CommonUtils.setGlobalObject("PILT016A_APAC_COMPOSITE_ACTION", compositeAction);
				if(polno != null){
					String rowId=this.getReceiptNo(polno);
					compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().setROWID(rowId);
				}
				
			}else{
				String rowNo=this.getRowNO(PWTH_DOC_NO);
				PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
				CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
						compositeAction);
				if(!"".equals(rowNo)&&rowNo!=null)
				{
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
					.setROWID(rowNo);
				CommonUtils.setGlobalVariable("backValue", OUT_COME);
					if(OUT_COME.equalsIgnoreCase("WORKFLOW_OCD_REJECTION")){
					CommonUtils.setGlobalVariable("CALLING_FORM", "WF_REVERSE");
					}
				outcome = "PILT002_APAC_PT_IL_POLICY";
				}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"row no is null");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}	
					
				}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executePolicyScreenUnAssigned() throws Exception {
		String outcome = null;
		//PT_GL_POLICY_SEARCH_ACTION PT_GL_POLICY_SEARCH_ACTION= new PT_GL_POLICY_SEARCH_ACTION();
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String userId = getUserId();
			if(userId!=null){
				String rowNo=this.getRowNO(PWTH_DOC_NO);
				PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
				CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
						compositeAction);
				if(!"".equals(rowNo)&&rowNo!=null)
				{
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
					.setROWID(rowNo);
				CommonUtils.setGlobalVariable("backValue", OUT_COME);
				outcome = "PILT002_APAC_PT_IL_POLICY";
				}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"row no is null");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
				}
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Kindly Assign Task To And Click Save");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "Kindly Assign Task To And Click Save");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeClaim(){
		String outcome = null;
		//PT_GL_POLICY_SEARCH_ACTION PT_GL_POLICY_SEARCH_ACTION= new PT_GL_POLICY_SEARCH_ACTION();
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			
				String rowNo=getClaimRowNO(PWTH_DOC_NO);
				PILT006_APAC_COMPOSITE_ACTION compositeAction = new PILT006_APAC_COMPOSITE_ACTION();
				//String outcome = null;
				CommonUtils.setGlobalObject("PILT006_APAC_COMPOSITE_ACTION",compositeAction);
				if(!"".equals(rowNo)&&rowNo!=null)
				{
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setROWID(rowNo);
					CommonUtils.setGlobalVariable("backValue", OUT_COME);
					outcome = "claimsEntry";
				}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"row no is null");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;
		}
		return outcome;
		
	}
	
	public String executeClaimUnAssigned() {
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			
			String userId = getUserId();
			if(userId!=null){
				String rowNo=getClaimRowNO(PWTH_DOC_NO);
				PILT006_APAC_COMPOSITE_ACTION compositeAction = new PILT006_APAC_COMPOSITE_ACTION();
				//String outcome = null;
				CommonUtils.setGlobalObject("PILT006_APAC_COMPOSITE_ACTION",compositeAction);
				if(!"".equals(rowNo)&&rowNo!=null)
				{
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setROWID(rowNo);
					CommonUtils.setGlobalVariable("backValue", OUT_COME);
					outcome = "claimsEntry";
				}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"row no is null");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
				}
			}else{
				//throw new Exception("Kindly Assign Task And Click Save");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Kindly Assign Task And Click Save");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "Kindly Assign Task And Click Save");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;
		}
		return outcome;
		
	}
	public String getUserId(){
		String userId = null;
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			String sys_Id = pgiwUnAssignedList.get(0).getSys_Id();
			String C1 = "SELECT * FROM PGIW_WF_TRAN_HDR WHERE PWTH_SYS_ID= ? ";
			con = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] {sys_Id});
			while (rs1.next()) {
				userId = rs1.getString("PWTH_USER_ID");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userId;
	}
	
	private String getRowNO(String code) throws Exception
	{
		ResultSet result=null;
		ResultSet result1=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String rowno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="select rowid,pol_ds_type from pt_il_policy where pol_no='"+code+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				rowno=result.getString("rowid");
				CommonUtils
				.setGlobalVariable("POL_DS_TYPE",result.getString("pol_ds_type"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return rowno;
	}
	/*Added by Sivarajan on 08/11/2020 for Allaince IL*/
	private String getPolicyNO(String code) throws Exception
	{
		ResultSet result=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String polno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="select pol_no from pt_il_policy where pol_prop_no='"+code+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				polno=result.getString("pol_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
		}
		return polno;
	}
	
	private String getReceiptNo(String code) throws Exception
	{
		ResultSet result=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String rowno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="SELECT ROWID FROM  PT_IL_DEPOSIT WHERE DEP_REF_NO='"+code+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				rowno=result.getString("ROWID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
		
		}
		return rowno;
	}
	/*End*/
	
	
	public String backBtnAction()
	{
		return "premia-home";
	}
	/*public String backBtnDMS(){
		//COMP_UI_M_BUT_WFDMS.setDisabled(true);
		COMP_UI_M_BUT_WFDMS.setActive(true);
		
		
		System.out.println("disable            :"+COMP_UI_M_BUT_WFDMS.isDisabled());
		
		return "premia-home";
	}*/
	private String getClaimRowNO(String code) throws Exception
	{
		ResultSet result=null;
		ResultSet result1=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String rowno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="select rowid from pt_il_claim where claim_no='"+code+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				rowno=result.getString("rowid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return rowno;
	}
	/* Added by kavitha for RoadMap*/
	public String executeWithdrawal(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getWithdrawRowNO(PWTH_DOC_NO);
			PILT021_COMPOSITE_ACTION compositeAction = new PILT021_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT021_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT021_PT_IL_WITHDRAWAL";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeWithdrawalUnAssigned(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String userId = getUserId();
			if(userId!=null){
				String rowNo=this.getWithdrawRowNO(PWTH_DOC_NO);
				PILT021_COMPOSITE_ACTION compositeAction = new PILT021_COMPOSITE_ACTION();
				CommonUtils.setGlobalObject("PILT021_COMPOSITE_ACTION",
						compositeAction);
				if(!"".equals(rowNo)&&rowNo!=null)
				{
					compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN()
					.setROWID(rowNo);
					
				CommonUtils.setGlobalVariable("backValue", OUT_COME);
				outcome = "PILT021_PT_IL_WITHDRAWAL";
				}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"row no is null");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
				}
			}else{
				//throw new Exception("Kindly Assign Task And Click Save");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Kindly Assign Task And Click Save");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "Kindly Assign Task And Click Save");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	private String getWithdrawRowNO(String code) throws Exception
	{
		ResultSet result=null;
		ResultSet result1=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String rowno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="select rowid from pt_il_withdrawal where wd_pol_no='"+code+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				rowno=result.getString("rowid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return rowno;
	}
	
	
	public String executeDataEntryPolicy(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getProRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	//Added by kavitha on 19.11.2019 for orient Workflow
	public String executeReceiptScreen(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getRecRowNO(PWTH_DOC_NO);
			PILT016A_APAC_COMPOSITE_ACTION compositeAction = new PILT016A_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT016A_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT016A_APAC_PT_IL_DEPOSIT";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	//Added by kavitha on 19.11.2019 for orient Workflow
		public String executeOcdScreen(){
			String outcome = null;
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
			String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
			String OUT_COME = req.getParameter("OUT_COME");
			
			try {
				String rowNo=this.getOcdRowNO(PWTH_DOC_NO);
				PILT084_COMPOSITE_ACTION_BEAN compositeAction = new PILT084_COMPOSITE_ACTION_BEAN();
				CommonUtils.setGlobalObject("PILT084_COMPOSITE_ACTION_BEAN",
						compositeAction);
				if(!"".equals(rowNo)&&rowNo!=null)
				{
					compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN()
					.setROWID(rowNo);
					
				CommonUtils.setGlobalVariable("backValue", OUT_COME);
				CommonUtils.setGlobalVariable("CALLING_FORM", "workflow");
				CommonUtils.setGlobalVariable("M_OCD_ROWNO", rowNo);
				outcome = "PILT084";
				}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"row no is null");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return outcome;
		}
		
		public String executeOcdScreenUnAssigned(){
			String outcome = null;
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
			String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
			String OUT_COME = req.getParameter("OUT_COME");
			
			try {
				String userId = getUserId();
				if(userId!=null){
					String rowNo=this.getOcdRowNO(PWTH_DOC_NO);
					PILT084_COMPOSITE_ACTION_BEAN compositeAction = new PILT084_COMPOSITE_ACTION_BEAN();
					CommonUtils.setGlobalObject("PILT084_COMPOSITE_ACTION_BEAN",
							compositeAction);
					if(!"".equals(rowNo)&&rowNo!=null)
					{
						compositeAction.getPT_IL_PAYOUT_PROCESS_ACTION_BEAN().getPT_IL_PAYOUT_PROCESS_BEAN()
						.setROWID(rowNo);
						
					CommonUtils.setGlobalVariable("backValue", OUT_COME);
					outcome = "PILT084";
					}else{
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							"row no is null");
					getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
					}
				}else{
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							"Kindly Assign Task And Click Save");
					getErrorMap().put("SRC_BUS_SUGGESTIONS", "Kindly Assign Task And Click Save");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return outcome;
		}
		
		
	public String executeReceiptScreenUnAssigned(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String userId = getUserId();
			if(userId!=null){
				String rowNo=this.getRecRowNO(PWTH_DOC_NO);
				PILT016A_APAC_COMPOSITE_ACTION compositeAction = new PILT016A_APAC_COMPOSITE_ACTION();
				CommonUtils.setGlobalObject("PILT016A_APAC_COMPOSITE_ACTION",
						compositeAction);
				if(!"".equals(rowNo)&&rowNo!=null)
				{
					compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN()
					.setROWID(rowNo);
					
				CommonUtils.setGlobalVariable("backValue", OUT_COME);
				outcome = "PILT016A_APAC_PT_IL_DEPOSIT";
				}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"row no is null");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
				}
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Kindly Assign Task And Click Save");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "Kindly Assign Task And Click Save");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	
	public String executeDataEntryPolicyUnAssigned(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String userId = getUserId();
			if(userId!=null){
				String rowNo=this.getProRowNO(PWTH_DOC_NO);
				PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
				CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
						compositeAction);
				if(!"".equals(rowNo)&&rowNo!=null)
				{
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
					.setROWID(rowNo);
					
				CommonUtils.setGlobalVariable("backValue", OUT_COME);
				outcome = "PILT002_APAC_PT_IL_POLICY";
				}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"row no is null");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
				}
			
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Kindly Assign Task And Click Save");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "Kindly Assign Task And Click Save");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	private String getPolRowNO(String code) throws Exception
	{
		ResultSet result=null;
		ResultSet result1=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String rowno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="select rowid from pt_il_policy where pol_no='"+code+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				rowno=result.getString("rowid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return rowno;
	}
	
	private String getProRowNO(String code) throws Exception
	{
		ResultSet result=null;
		ResultSet result1=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String rowno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="select rowid from pt_il_policy where pol_prop_no='"+code+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				rowno=result.getString("rowid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return rowno;
	}
	
	private String getRecRowNO(String code) throws Exception
	{
		ResultSet result=null;
		ResultSet result1=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String rowno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="select rowid from pt_il_deposit where dep_ref_no='"+code+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				rowno=result.getString("rowid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return rowno;
	}
	//Added by kavitha on 10.12.2019 for orient ocd orient
	private String getOcdRowNO(String code) throws Exception
	{
		ResultSet result=null;
		ResultSet result1=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String rowno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="SELECT PP.ROWID FROM PT_IL_PAYOUT_PROCESS PP,PT_IL_POLICY P WHERE POL_SYS_ID=PP_POL_SYS_ID AND POL_NO = '"+code+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				rowno=result.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return rowno;
	}
	public Pgiw_wf_tran_dtls getPgiw_wf_tran_dtls_bean() {
		return Pgiw_wf_tran_dtls_bean;
	}
	public void setPgiw_wf_tran_dtls_bean(Pgiw_wf_tran_dtls pgiw_wf_tran_dtls_bean) {
		Pgiw_wf_tran_dtls_bean = pgiw_wf_tran_dtls_bean;
	}
	
	public String executeCsmAddress(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		String NATIONAL_ID = req.getParameter("NATIONAL_ID");
		try {
			String rowNo=this.getCsmAddrRowNO(PWTH_DOC_NO,NATIONAL_ID);
			PILP134_COMPOSITE_ACTION compositeAction = new PILP134_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILP134_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN()
				.setROWID(rowNo);
				compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCUST_DTL_UPD_BEAN().setCDU_CUST_REF_ID1(NATIONAL_ID);
				compositeAction.getCUST_DETL_UPD_ACTION_BEAN().getCOMP_CDU_CUST_CODE().setDisabled(true);
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILP134";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	private String getCsmAddrRowNO(String code,String nationalId) throws Exception
	{
		ResultSet result=null;
		ResultSet result1=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String rowno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="select rowid from pt_il_policy where pol_no='"+code+"' and pol_assrd_ref_id1='"+nationalId+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				rowno=result.getString("rowid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return rowno;
	}
	
	
	
	public String executeCsmSurrMaturity(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		try {
			outcome = "PILT021_PT_IL_WITHDRAWAL";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeCsmClaim(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String NATIONAL_ID = req.getParameter("NATIONAL_ID");
		String OUT_COME = req.getParameter("OUT_COME");
		try {
			PILT006_APAC_COMPOSITE_ACTION compositeAction = new PILT006_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT006_APAC_COMPOSITE_ACTION",compositeAction);
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_POL_NO(PWTH_DOC_NO);
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ASSRD_REF_ID1(NATIONAL_ID);
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT006_APAC_PT_IL_CLAIM";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	
	public String executeCsmIncSA(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	
	public String executeCsmDecSA(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeCsmTerm(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeCsmMop(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	
	public String executeCsmSurrender(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT021_PT_IL_WITHDRAWAL";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeCsmMaturity(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT021_PT_IL_WITHDRAWAL";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	public String executeCsmWithdrawal(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			
			PILT021_COMPOSITE_ACTION compositeAction = new PILT021_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT021_COMPOSITE_ACTION",
					compositeAction);
		    CommonUtils.setGlobalVariable("CSM_WD_POL_NO", PWTH_DOC_NO);
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_UI_M_POL_NO().setDisabled(true);
		    CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT021_PT_IL_WITHDRAWAL";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeCsmCancel(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeCsmLapse(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeCsmBen(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeCsmRider(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	
	public String executeCsmRein(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeSurrender(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			
				String rowNo=getSurrenderRowNO(PWTH_DOC_NO);
				PILT013_COMPOSITE_ACTION compositeAction = new PILT013_COMPOSITE_ACTION();
				CommonUtils.setGlobalObject("PILT013_COMPOSITE_ACTION",compositeAction);
				if(!"".equals(rowNo)&&rowNo!=null)
				{
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setROWID(rowNo);
					CommonUtils.setGlobalVariable("backValue", OUT_COME);
					outcome = "PILT013_PT_IL_POLICY";
				}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"row no is null");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outcome;
		
	}
	
	private String getSurrenderRowNO(String code) throws Exception
	{
		ResultSet result=null;
		ResultSet result1=null;
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		String rowno=null;
		try {
			connection=CommonUtils.getConnection();
			String queryString="SELECT ROWID FROM PT_IL_POLICY WHERE POL_NO='"+code+"'";
			result=handler.executeSelectStatement(queryString.toString(), connection);
			while(result!=null&&result.next()){
				rowno=result.getString("rowid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(result);
			CommonUtils.closeCursor(result1);
		}
		return rowno;
	}
	
	public String executeSurrenderUnAssigned() {
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			
			String userId = getUserId();
			if(userId!=null){
				String rowNo=getClaimRowNO(PWTH_DOC_NO);
				PILT006_APAC_COMPOSITE_ACTION compositeAction = new PILT006_APAC_COMPOSITE_ACTION();
				//String outcome = null;
				CommonUtils.setGlobalObject("PILT006_APAC_COMPOSITE_ACTION",compositeAction);
				if(!"".equals(rowNo)&&rowNo!=null)
				{
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setROWID(rowNo);
					CommonUtils.setGlobalVariable("backValue", OUT_COME);
					outcome = "claimsEntry";
				}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"row no is null");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
				}
			}else{
				//throw new Exception("Kindly Assign Task And Click Save");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Kindly Assign Task And Click Save");
				getErrorMap().put("SRC_BUS_SUGGESTIONS", "Kindly Assign Task And Click Save");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw e;
		}
		return outcome;
		
	}
	
	public String executeCsmGeneral(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String executeCsmDependant(){
		String outcome = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String PWTH_DOC_NO = req.getParameter("PWTH_DOC_NO");
		String OUT_COME = req.getParameter("OUT_COME");
		
		try {
			String rowNo=this.getPolRowNO(PWTH_DOC_NO);
			PILT002_APAC_COMPOSITE_ACTION compositeAction = new PILT002_APAC_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
					compositeAction);
			if(!"".equals(rowNo)&&rowNo!=null)
			{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.setROWID(rowNo);
				
			CommonUtils.setGlobalVariable("backValue", OUT_COME);
			outcome = "PILT002_APAC_PT_IL_POLICY";
			}else{
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"row no is null");
			getErrorMap().put("SRC_BUS_SUGGESTIONS", "row no is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outcome;
	}
	private HtmlTab COMP_UI_M_BUT_WFDMS;
	
	public HtmlTab getCOMP_UI_M_BUT_WFDMS() {
		return COMP_UI_M_BUT_WFDMS;
	}
	public void setCOMP_UI_M_BUT_WFDMS(HtmlTab cOMP_UI_M_BUT_WFDMS) {
		COMP_UI_M_BUT_WFDMS = cOMP_UI_M_BUT_WFDMS;
	}
	public List<PGIM_WORKFLOW_BUCKET> getPgimUnAssignedList() {
		return pgimUnAssignedList;
	}
	public void setPgimUnAssignedList(List<PGIM_WORKFLOW_BUCKET> pgimUnAssignedList) {
		this.pgimUnAssignedList = pgimUnAssignedList;
	}
	public List<Pgiw_wf_tran_dtls> getPgiwUnAssignedList() {
		return pgiwUnAssignedList;
	}
	public void setPgiwUnAssignedList(List<Pgiw_wf_tran_dtls> pgiwUnAssignedList) {
		this.pgiwUnAssignedList = pgiwUnAssignedList;
	}
	public UIData getUnAssignedTaskDataTable() {
		return unAssignedTaskDataTable;
	}
	public void setUnAssignedTaskDataTable(UIData unAssignedTaskDataTable) {
		this.unAssignedTaskDataTable = unAssignedTaskDataTable;
	}
	public List<SelectItem> getUnassignedUserList() {
		return unassignedUserList;
	}
	public void setUnassignedUserList(List<SelectItem> unassignedUserList) {
		this.unassignedUserList = unassignedUserList;
	}
	public HtmlCommandButton getCOMP_SAVE_BUTTON() {
		return COMP_SAVE_BUTTON;
	}
	public void setCOMP_SAVE_BUTTON(HtmlCommandButton cOMP_SAVE_BUTTON) {
		COMP_SAVE_BUTTON = cOMP_SAVE_BUTTON;
	}

	public WORKFLOW_HELPER getHelper() {
		return helper;
	}

	public void setHelper(WORKFLOW_HELPER helper) {
		this.helper = helper;
	}
	
	
	
}
