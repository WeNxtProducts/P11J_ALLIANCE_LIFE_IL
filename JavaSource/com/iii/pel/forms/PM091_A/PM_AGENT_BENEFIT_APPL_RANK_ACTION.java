package com.iii.pel.forms.PM091_A;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BENEFIT_APPL_RANK_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ABAR_RANK_CODE_LABEL;

	private HtmlInputText COMP_ABAR_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_ABAR_RANK_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ABAR_RANK_CODE_DESC;

	private PM_AGENT_BENEFIT_APPL_RANK PM_AGENT_BENEFIT_APPL_RANK_BEAN;
	
	private UIData rankTable;
	
	private List<PM_AGENT_BENEFIT_APPL_RANK> rankTableList;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
    private String filterByABAR_RANK_CODE;
		
	private String filterByUI_M_ABAR_RANK_CODE_DESC;
	
	
	
	
	private HtmlCommandButton addButton;
	
	private List<PM_AGENT_BENEFIT_APPL_RANK_SuggestionBean> rankCodeLov = new ArrayList<PM_AGENT_BENEFIT_APPL_RANK_SuggestionBean>();
	

	

	public List<PM_AGENT_BENEFIT_APPL_RANK_SuggestionBean> getRankCodeLov() {
		return rankCodeLov;
	}

	public void setRankCodeLov(List<PM_AGENT_BENEFIT_APPL_RANK_SuggestionBean> rankCodeLov) {
		this.rankCodeLov = rankCodeLov;
	}

	 public PM091_A_COMPOSITE_ACTION compositeAction;
	
	public PM_AGENT_BENEFIT_APPL_RANK_ACTION() {
		PM_AGENT_BENEFIT_APPL_RANK_BEAN = new PM_AGENT_BENEFIT_APPL_RANK();
		rankTableList = new ArrayList<PM_AGENT_BENEFIT_APPL_RANK>();
		
	}
	
	public void onLoad(PhaseEvent event){
		try {
			if (isBlockFlag()) {
				fetchRecord();
			setBlockFlag(false);
		}
		
		if(PM_AGENT_BENEFIT_APPL_RANK_BEAN.getROWID() == null){
			
		}else {
			
		}
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public HtmlOutputLabel getCOMP_ABAR_RANK_CODE_LABEL() {
		return COMP_ABAR_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ABAR_RANK_CODE() {
		return COMP_ABAR_RANK_CODE;
	}

	public void setCOMP_ABAR_RANK_CODE_LABEL(HtmlOutputLabel COMP_ABAR_RANK_CODE_LABEL) {
		this.COMP_ABAR_RANK_CODE_LABEL = COMP_ABAR_RANK_CODE_LABEL;
	}

	public void setCOMP_ABAR_RANK_CODE(HtmlInputText COMP_ABAR_RANK_CODE) {
		this.COMP_ABAR_RANK_CODE = COMP_ABAR_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABAR_RANK_CODE_DESC_LABEL() {
		return COMP_UI_M_ABAR_RANK_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ABAR_RANK_CODE_DESC() {
		return COMP_UI_M_ABAR_RANK_CODE_DESC;
	}

	public void setCOMP_UI_M_ABAR_RANK_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ABAR_RANK_CODE_DESC_LABEL) {
		this.COMP_UI_M_ABAR_RANK_CODE_DESC_LABEL = COMP_UI_M_ABAR_RANK_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_ABAR_RANK_CODE_DESC(HtmlInputText COMP_UI_M_ABAR_RANK_CODE_DESC) {
		this.COMP_UI_M_ABAR_RANK_CODE_DESC = COMP_UI_M_ABAR_RANK_CODE_DESC;
	}

	public PM_AGENT_BENEFIT_APPL_RANK getPM_AGENT_BENEFIT_APPL_RANK_BEAN() {
		return PM_AGENT_BENEFIT_APPL_RANK_BEAN;
	}

	public void setPM_AGENT_BENEFIT_APPL_RANK_BEAN(PM_AGENT_BENEFIT_APPL_RANK PM_AGENT_BENEFIT_APPL_RANK_BEAN) {
		this.PM_AGENT_BENEFIT_APPL_RANK_BEAN = PM_AGENT_BENEFIT_APPL_RANK_BEAN;
	}

	public UIData getRankTable() {
		return rankTable;
	}

	public void setRankTable(UIData rankTable) {
		this.rankTable = rankTable;
	}

	public List getRankTableList() {
		return rankTableList;
	}

	public void setRankTableList(List rankTableList) {
		this.rankTableList = rankTableList;
	}
	
	
	
	//****************************Validations************************************
	
	
	
	public void preInsert() throws Exception{
		
		try {
			String dtlBenefitCode = compositeAction.getPM_AGENT_BENEFIT_HDR_ACTION_BEAN().getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
			
			PM_AGENT_BENEFIT_APPL_RANK_BEAN.setABAR_ABH_BNF_CODE(dtlBenefitCode);
			PM_AGENT_BENEFIT_APPL_RANK_BEAN.setABAR_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			PM_AGENT_BENEFIT_APPL_RANK_BEAN.setABAR_CR_DT(new CommonUtils().getCurrentDate());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		
		
	}
	
	
	public void preUpdate() throws Exception{
		try{
		PM_AGENT_BENEFIT_APPL_RANK_BEAN.setABAR_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		PM_AGENT_BENEFIT_APPL_RANK_BEAN.setABAR_UPD_DT(new CommonUtils().getCurrentDate());
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	

	public void validateRankCode(ActionEvent ae){
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput)ae.getComponent().getParent();
		String rankCode=(String)input.getSubmittedValue();
		getPM_AGENT_BENEFIT_APPL_RANK_BEAN().setABAR_RANK_CODE(rankCode);
		validateRankCodeValue(getPM_AGENT_BENEFIT_APPL_RANK_BEAN().getABAR_RANK_CODE());
	}
	

	/*public void validatorRankCode(FacesContext fc,UIComponent component, Object value)throws ValidatorException{
		String checkValue = validateRankCodeValue(value.toString());
		if(checkValue.equals("X")){
			FacesMessage errorMessage =Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91049");
			throw new ValidatorException(errorMessage);
		}
	}	*/
	public String validateRankCodeValue(String code){
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();	
		HttpSession session = request.getSession();
		String rankCode = code;
		PM_AGENT_BENEFIT_APPL_RANK valueBean =(PM_AGENT_BENEFIT_APPL_RANK)getRankTable().getRowData();
		String benefitCode = valueBean.getABAR_ABH_BNF_CODE();
		 ResultSet rs=null;
		String query = null;
		 String X = null;
		
	    if (valueBean.getROWID()!=null){
	    	query = "SELECT 'X' FROM  PM_AGENT_BENEFIT_APPL_RANK  WHERE ABAR_RANK_CODE='"+rankCode+"'AND ABAR_ABH_BNF_CODE ='"+benefitCode+"' and ROWID !='"+valueBean.getROWID()+"'"; 
	    }else{
	    	PM_AGENT_BENEFIT_HDR_ACTION actionBean = (PM_AGENT_BENEFIT_HDR_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");		
			// Get the bean based on row index
			
			String dtlBenefitCode = actionBean.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
	    	query = "SELECT 'X' FROM  PM_AGENT_BENEFIT_APPL_RANK  WHERE ABAR_RANK_CODE='"+rankCode+"'AND ABAR_ABH_BNF_CODE ='"+dtlBenefitCode+"'"; 
	    }
	    System.out.println("PM_AGENT_BENEFIT_APPL_RANK_ACTION.validateRankCode()*****+++++++****["+query+"]");
	    CRUDHandler handler =new CRUDHandler();
	    try{
	    rs =handler.executeSelectStatement(query, CommonUtils.getConnection());
	    while(rs.next()){
	 	   X= rs.getString("X");
	    }
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    
	    }finally{
	    	try{
	    		rs.close();
	    	}catch (Exception e) {
	    	e.printStackTrace();
	    	}
	    }
	   
	    System.out.println("VALUE OF X----["+X+"]");
	    
	    if("X".equals(X)){
			FacesMessage errorMessage =Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91049");
			getErrorMap().put("current",errorMessage.getSummary());
			//throw new ValidatorException(errorMessage);
		}
	    else
	    {
	    	// [Commented for grid implementation change, Added by: Varun Dayal Mathur, Dated: 16-Feb-2009 
			//lastColumnListener();
			// Commented for grid implementation change, Added by: Varun Dayal Mathur, Dated: 16-Feb-2009 ]
	    }
	    return X;
	    
	   /* if("X".equals(X)){
	    	getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91049").getSummary());
	    	return;
	    }else{
	    	getErrorMap().clear();
	    }*/
	    
	}
	
	
	//*********************CRUD***************************************************
	
	
	
	
	
	
	
	public void post(ActionEvent ae) {
		PM_AGENT_BENEFIT_APPL_RANK_DataGridDelegate delegate= new PM_AGENT_BENEFIT_APPL_RANK_DataGridDelegate();
	
		try{
			if(PM_AGENT_BENEFIT_APPL_RANK_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				preUpdate();
					new CRUDHandler().executeInsert(PM_AGENT_BENEFIT_APPL_RANK_BEAN, CommonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				 
			} else {

				if( PM_AGENT_BENEFIT_APPL_RANK_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
					preInsert();
					new CRUDHandler().executeInsert(PM_AGENT_BENEFIT_APPL_RANK_BEAN, CommonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					rankTableList.add(PM_AGENT_BENEFIT_APPL_RANK_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_AGENT_BENEFIT_APPL_RANK_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	

	
	
	
	
	
	
	
	
	public String deleteRow(){
		try{
			if (isDELETE_ALLOWED()){

				new CRUDHandler().executeDelete(PM_AGENT_BENEFIT_APPL_RANK_BEAN,CommonUtils.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				rankTableList.remove(PM_AGENT_BENEFIT_APPL_RANK_BEAN);
				if(rankTableList.size()>0){

					PM_AGENT_BENEFIT_APPL_RANK_BEAN=rankTableList.get(0);
				}else if(rankTableList.size()==0){
					AddRow(null);
				}
				resetAllComponent();
				PM_AGENT_BENEFIT_APPL_RANK_BEAN.setRowSelected(true);
			}else{
				getErrorMap().put("deleteRow",Messages.getString(
						PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}
		return null;
	}
	

	public String Save() throws Exception{
		CommonUtils.getConnection().commit();
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Records Saved Successfully");
		getWarningMap().put("SAVE","Records Saved Successfully");
		
		return null;
	}

	
	public String combinedSave(){
		PM_AGENT_BENEFIT_APPL_RANK_DataGridDelegate gridDelegate = new PM_AGENT_BENEFIT_APPL_RANK_DataGridDelegate();
	
		gridDelegate.saveData(this);
		getWarningMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_UPDATE_MESSAGE"));
		getWarningMap().put("somekey", Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_UPDATE_MESSAGE"));
		return null;
	}
	
	
	
	//***********************************************LOV*************************************
	
	
	
	public List<PM_AGENT_BENEFIT_APPL_RANK_SuggestionBean> popLov4RankCode(Object event){
		String suggestQuery = null;
		String textEntered = event.toString();
		ResultSet rsSug=null;
		rankCodeLov.clear();
		if(event.toString().equals("*")){
			suggestQuery="select PC_CODE, PC_DESC from pm_codes where PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL";
		}

		else
		{
			suggestQuery="select PC_CODE, PC_DESC from pm_codes where PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL and PC_CODE like '"+textEntered+"%'";
		}
		try{
			rsSug = new CRUDHandler().executeSelectStatement(suggestQuery, CommonUtils.getConnection());
			while(rsSug.next()){
			PM_AGENT_BENEFIT_APPL_RANK_SuggestionBean sugBean =new PM_AGENT_BENEFIT_APPL_RANK_SuggestionBean();
			sugBean.setLOV_ABAR_RANK_CODE(rsSug.getString(1));
			sugBean.setLOV_UI_M_ABAR_RANK_CODE_DESC(rsSug.getString(2));
			rankCodeLov.add(sugBean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
				rsSug.close();
			}
			catch (Exception ev) {
				ev.printStackTrace();
			}
		}
		return rankCodeLov;
		
		
	}
	
	  public void fireFieldValidation(ActionEvent actionEvent) {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		    }

	
	public void popRankCodeDesc(FacesContext context,UIComponent component,Object object){
		 
		CommonUtils.clearMaps(this);
		ResultSet rs =null;
		PM_AGENT_BENEFIT_APPL_RANK_BEAN.setABAR_RANK_CODE((String)object);
		String codeValue= PM_AGENT_BENEFIT_APPL_RANK_BEAN.getABAR_RANK_CODE(); 
		try{		
		if(!codeValue.equals("")|| codeValue!=null){
			String desc = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL AND PC_CODE = ? ";
			rs = new CRUDHandler().executeSelectStatement(desc,CommonUtils.getConnection(), new Object[]{codeValue});
			if(rs.next()){
				String rankDesc = rs.getString(1);
				getCOMP_UI_M_ABAR_RANK_CODE_DESC().setSubmittedValue(rankDesc);
				PM_AGENT_BENEFIT_APPL_RANK_BEAN.setUI_M_ABAR_RANK_CODE_DESC(rankDesc);
			}
			else{
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80302")); 
			}
			
				
			COMP_UI_M_ABAR_RANK_CODE_DESC.resetValue();
		}
		}catch(Exception ex){ex.printStackTrace();
		throw new ValidatorException(new FacesMessage(ex.getMessage()));
		}
		finally{try{rs.close();}catch(Exception ex){}}
	}
		
		
	
	
	
	public void postQuery(PM_AGENT_BENEFIT_APPL_RANK rankBean){
		 
		CommonUtils.clearMaps(this);
		ResultSet rs =null;
		String rankDesc=null;
		String codeValue= rankBean.getABAR_RANK_CODE();
		try{		
			if(codeValue!=null){
				String desc = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL AND PC_CODE = ? ";
				rs = new CRUDHandler().executeSelectStatement(desc,CommonUtils.getConnection(), new Object[]{codeValue});
				if(rs.next()){
					rankDesc = rs.getString(1);
					rankBean.setUI_M_ABAR_RANK_CODE_DESC(rankDesc);
				}
			}
		
			}catch(Exception ex){ex.printStackTrace();}
		finally{try{rs.close();}catch(Exception ex){}}

	}
	
	
	
	
	
	public String getProductCodeDesc(String productcode,String moduleid){
		ResultSet rs =null;
		String productDesc=null;
		String ModuleId = moduleid;
		String codeValue= productcode;
		if(!codeValue.equals("")|| codeValue!=null){
		String desc = "SELECT PROD_DESC FROM   PV_LIFE_PRODUCTS WHERE  MODULE_ID ='"+ModuleId+"' and  PROD_CODE ='"+codeValue+"'";
		
		System.out
				.println("PM_AGENT_BENEFIT_APPL_RANK_ACTION.getProductCodeDesc()--QQQQQUERY--["+desc+"]");
		try{		
		 rs = new CRUDHandler().executeSelectStatement(desc, CommonUtils.getConnection());
		if(rs.next()){
			productDesc = rs.getString(1);
		}else{
			
			//WHEN-VALIDATE-ITEM
			/*STD_MESSAGE_ROUTINE(80223,:CTRL.M_LANG_CODE);   
			RAISE FORM_TRIGGER_FAILURE;*/
		}
		
		
		
		
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		finally{
			try{
				rs.close();
			}catch(Exception ex){
				ex.printStackTrace();
				
			}
		}
		}
		return productDesc;
		
	}
	
	
	public String goToBenefitDetailBlock(){
		return "BenefitDetailBlock";
	}
	
	public String goToApplicableRankBlock(){
		return null;
	}
	
	
	
	
	
	
	
	
	

	public HtmlCommandButton getAddButton() {
		return addButton;
	}

	public void setAddButton(HtmlCommandButton addButton) {
		this.addButton = addButton;
	}

	public String setSelectStatus(ActionEvent event){
		int rowIndex = rankTable.getRowIndex();
		String status = (String)((UIInput)event.getComponent().getParent()).getSubmittedValue();
		rankTableList.get(rowIndex).setSelected(Boolean.parseBoolean(status));
		
		return null;
	}
	public void resetAllComponent(){
		
		
		// Reseting HtmlInputText
		COMP_ABAR_RANK_CODE.resetValue();
		COMP_UI_M_ABAR_RANK_CODE_DESC.resetValue();
	 
	}
// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_AGENT_BENEFIT_APPL_RANK> iterator = rankTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void getDetails() {
		try {
			if (rankTableList.size() != 0) {				
				PM_AGENT_BENEFIT_APPL_RANK_BEAN = (PM_AGENT_BENEFIT_APPL_RANK) rankTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_AGENT_BENEFIT_APPL_RANK_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){		
				PM_AGENT_BENEFIT_APPL_RANK_BEAN = new PM_AGENT_BENEFIT_APPL_RANK();
				resetAllComponent();
			}else{
				getErrorMap().put("somekey",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	}
			
public void deleteRow(ActionEvent ae) {
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();

			if(isDELETE_ALLOWED()) {
				if(PM_AGENT_BENEFIT_APPL_RANK_BEAN.getROWID() != null) {
					new CRUDHandler().executeDelete(PM_AGENT_BENEFIT_APPL_RANK_BEAN, CommonUtils.getConnection());
					rankTableList.remove(PM_AGENT_BENEFIT_APPL_RANK_BEAN);
					getWarningMap().put("current","Record Deleted Sucessfully");
					getWarningMap().put("details","Record Deleted Sucessfully");
					//getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
					//getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
					resetAllComponent();
				}
				if(rankTableList.size() > 0) {
					setPM_AGENT_BENEFIT_APPL_RANK_BEAN(rankTableList.get(0));
					PM_AGENT_BENEFIT_APPL_RANK_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}
			} else {

				getErrorMap().clear();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
}


	

	
	
	
	// [ Added for grid implementation change, Added by: Varun Dayal Mathur, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		try{
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record Saved Successfully");
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	// Added for grid implementation change, Added by: Varun Dayal Mathur, Dated: 16-Feb-2009 ]

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public String getFilterByABAR_RANK_CODE() {
		return filterByABAR_RANK_CODE;
	}

	public void setFilterByABAR_RANK_CODE(String filterByABAR_RANK_CODE) {
		this.filterByABAR_RANK_CODE = filterByABAR_RANK_CODE;
	}

	public String getFilterByUI_M_ABAR_RANK_CODE_DESC() {
		return filterByUI_M_ABAR_RANK_CODE_DESC;
	}

	public void setFilterByUI_M_ABAR_RANK_CODE_DESC(
			String filterByUI_M_ABAR_RANK_CODE_DESC) {
		this.filterByUI_M_ABAR_RANK_CODE_DESC = filterByUI_M_ABAR_RANK_CODE_DESC;
	}
	
	public void fetchRecord() throws Exception{
		String selectQuery = "SELECT PM_AGENT_BENEFIT_APPL_RANK.*,PM_AGENT_BENEFIT_APPL_RANK.ROWID FROM  PM_AGENT_BENEFIT_APPL_RANK WHERE  ABAR_ABH_BNF_CODE = ? ";
		ResultSet resultSet = null;
		try {
			resultSet = new CRUDHandler().executeSelectStatement(selectQuery, CommonUtils.getConnection(), new Object[]{compositeAction.getPM_AGENT_BENEFIT_HDR_ACTION_BEAN().getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE()});
				PM_AGENT_BENEFIT_APPL_RANK PM_AGENT_BENEFIT_APPL_RANK_BEAN1 = null;
				rankTableList.clear();
		while(resultSet.next()){
			PM_AGENT_BENEFIT_APPL_RANK_BEAN1 = new PM_AGENT_BENEFIT_APPL_RANK();
			PM_AGENT_BENEFIT_APPL_RANK_BEAN1.setROWID(resultSet.getString("ROWID"));
			PM_AGENT_BENEFIT_APPL_RANK_BEAN1.setABAR_ABH_BNF_CODE(resultSet.getString("ABAR_ABH_BNF_CODE"));
			PM_AGENT_BENEFIT_APPL_RANK_BEAN1.setABAR_RANK_CODE(resultSet.getString("ABAR_RANK_CODE"));
			PM_AGENT_BENEFIT_APPL_RANK_BEAN1.setABAR_CR_DT(resultSet.getDate("ABAR_CR_DT"));
			PM_AGENT_BENEFIT_APPL_RANK_BEAN1.setABAR_CR_UID(resultSet.getString("ABAR_CR_UID"));
			PM_AGENT_BENEFIT_APPL_RANK_BEAN1.setABAR_UPD_DT(resultSet.getDate("ABAR_UPD_DT"));
			PM_AGENT_BENEFIT_APPL_RANK_BEAN1.setABAR_UPD_UID(resultSet.getString("ABAR_UPD_UID"));
			postQuery(PM_AGENT_BENEFIT_APPL_RANK_BEAN1);
			getRankTableList().add(PM_AGENT_BENEFIT_APPL_RANK_BEAN1);
		}
		if (rankTableList.size() > 0) {
			PM_AGENT_BENEFIT_APPL_RANK_BEAN = rankTableList.get(0);
			PM_AGENT_BENEFIT_APPL_RANK_BEAN.setRowSelected(true);
			
		}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{CommonUtils.closeCursor(resultSet);}
			
	}

		 
}
