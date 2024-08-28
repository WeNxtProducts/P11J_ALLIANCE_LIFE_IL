package com.iii.pel.forms.PM100_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_PF_SETUP_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_APS_MKT_CODE_LABEL;

	private HtmlInputText COMP_APS_MKT_CODE;

	private HtmlOutputLabel COMP_APS_RANK_CODE_LABEL;

	private HtmlInputText COMP_APS_RANK_CODE;

	private HtmlOutputLabel COMP_APS_EXP_MONTHS_LABEL;

	private HtmlInputText COMP_APS_EXP_MONTHS;

	private HtmlOutputLabel COMP_APS_COMM_PER_LABEL;

	private HtmlInputText COMP_APS_COMM_PER;

	private HtmlOutputLabel COMP_APS_COMM_RATE_PER_LABEL;

	private HtmlInputText COMP_APS_COMM_RATE_PER;

	private HtmlOutputLabel COMP_APS_COMM_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_APS_COMM_TYPE;

	private HtmlOutputLabel COMP_APS_PROMOTE_YN_LABEL;

	private HtmlSelectOneMenu COMP_APS_PROMOTE_YN;

	private HtmlOutputLabel COMP_APS_DEDUCT_YN_LABEL;

	private HtmlSelectOneMenu COMP_APS_DEDUCT_YN;

	private HtmlOutputLabel COMP_UI_M_APS_MKT_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_APS_MKT_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_APS_RANK_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_APS_RANK_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_APS_MKT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_APS_RANK_CODE_LOV;

	private PM_AGENT_PF_SETUP PM_AGENT_PF_SETUP_BEAN;
	
	private boolean update;
	
	private Map<String,String> errorMap = new HashMap<String, String>();
	private String errorMessages;
	
	private List<SelectItem> LIST_APS_PROMOTE_YN = new ArrayList<SelectItem>();
	private List<SelectItem> LIST_APS_DEDUCT_YN = new ArrayList<SelectItem>()  ;
	private List<SelectItem> LIST_APS_COMM_TYPE = new ArrayList<SelectItem>();
	
	
	List<SuggestionBean> mktCodeLOV = new ArrayList<SuggestionBean>();
	List<SuggestionBean>rankCodeLOV = new ArrayList<SuggestionBean>();
	
	private HtmlCommandButton dum;
	 
	public PM_AGENT_PF_SETUP_ACTION() {
		PM_AGENT_PF_SETUP_BEAN = new PM_AGENT_PF_SETUP();
		try {
			LIST_APS_PROMOTE_YN = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PM100_A_TISB", "PM_AGENT_PF_SETUP","PM_AGENT_PF_SETUP.APS_PROMOTE_YN", "YESNO");
			 LIST_APS_DEDUCT_YN = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PM100_A_TISB", "PM_AGENT_PF_SETUP", "PM_AGENT_PF_SETUP.APS_DEDUCT_YN", "YESNO");
			 LIST_APS_COMM_TYPE = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PM100_A_TISB","PM_AGENT_PF_SETUP", "PM_AGENT_PF_SETUP.APS_COMM_TYPE","APFCOMMTYPE");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
	
	public HtmlCommandButton getDum() {
		return dum;
	}

	public void setDum(HtmlCommandButton dum) {
		this.dum = dum;
	}


	public HtmlOutputLabel getCOMP_APS_MKT_CODE_LABEL() {
		return COMP_APS_MKT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_MKT_CODE() {
		return COMP_APS_MKT_CODE;
	}

	public void setCOMP_APS_MKT_CODE_LABEL(HtmlOutputLabel COMP_APS_MKT_CODE_LABEL) {
		this.COMP_APS_MKT_CODE_LABEL = COMP_APS_MKT_CODE_LABEL;
	}

	public void setCOMP_APS_MKT_CODE(HtmlInputText COMP_APS_MKT_CODE) {
		this.COMP_APS_MKT_CODE = COMP_APS_MKT_CODE;
	}

	public HtmlOutputLabel getCOMP_APS_RANK_CODE_LABEL() {
		return COMP_APS_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APS_RANK_CODE() {
		return COMP_APS_RANK_CODE;
	}

	public void setCOMP_APS_RANK_CODE_LABEL(HtmlOutputLabel COMP_APS_RANK_CODE_LABEL) {
		this.COMP_APS_RANK_CODE_LABEL = COMP_APS_RANK_CODE_LABEL;
	}

	public void setCOMP_APS_RANK_CODE(HtmlInputText COMP_APS_RANK_CODE) {
		this.COMP_APS_RANK_CODE = COMP_APS_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_APS_EXP_MONTHS_LABEL() {
		return COMP_APS_EXP_MONTHS_LABEL;
	}

	public HtmlInputText getCOMP_APS_EXP_MONTHS() {
		return COMP_APS_EXP_MONTHS;
	}

	public void setCOMP_APS_EXP_MONTHS_LABEL(HtmlOutputLabel COMP_APS_EXP_MONTHS_LABEL) {
		this.COMP_APS_EXP_MONTHS_LABEL = COMP_APS_EXP_MONTHS_LABEL;
	}

	public void setCOMP_APS_EXP_MONTHS(HtmlInputText COMP_APS_EXP_MONTHS) {
		this.COMP_APS_EXP_MONTHS = COMP_APS_EXP_MONTHS;
	}

	public HtmlOutputLabel getCOMP_APS_COMM_PER_LABEL() {
		return COMP_APS_COMM_PER_LABEL;
	}

	public HtmlInputText getCOMP_APS_COMM_PER() {
		return COMP_APS_COMM_PER;
	}

	public void setCOMP_APS_COMM_PER_LABEL(HtmlOutputLabel COMP_APS_COMM_PER_LABEL) {
		this.COMP_APS_COMM_PER_LABEL = COMP_APS_COMM_PER_LABEL;
	}

	public void setCOMP_APS_COMM_PER(HtmlInputText COMP_APS_COMM_PER) {
		this.COMP_APS_COMM_PER = COMP_APS_COMM_PER;
	}

	public HtmlOutputLabel getCOMP_APS_COMM_RATE_PER_LABEL() {
		return COMP_APS_COMM_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_APS_COMM_RATE_PER() {
		return COMP_APS_COMM_RATE_PER;
	}

	public void setCOMP_APS_COMM_RATE_PER_LABEL(HtmlOutputLabel COMP_APS_COMM_RATE_PER_LABEL) {
		this.COMP_APS_COMM_RATE_PER_LABEL = COMP_APS_COMM_RATE_PER_LABEL;
	}

	public void setCOMP_APS_COMM_RATE_PER(HtmlInputText COMP_APS_COMM_RATE_PER) {
		this.COMP_APS_COMM_RATE_PER = COMP_APS_COMM_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_APS_COMM_TYPE_LABEL() {
		return COMP_APS_COMM_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APS_COMM_TYPE() {
		return COMP_APS_COMM_TYPE;
	}

	public void setCOMP_APS_COMM_TYPE_LABEL(HtmlOutputLabel COMP_APS_COMM_TYPE_LABEL) {
		this.COMP_APS_COMM_TYPE_LABEL = COMP_APS_COMM_TYPE_LABEL;
	}

	public void setCOMP_APS_COMM_TYPE(HtmlSelectOneMenu COMP_APS_COMM_TYPE) {
		this.COMP_APS_COMM_TYPE = COMP_APS_COMM_TYPE;
	}

	public HtmlOutputLabel getCOMP_APS_PROMOTE_YN_LABEL() {
		return COMP_APS_PROMOTE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APS_PROMOTE_YN() {
		return COMP_APS_PROMOTE_YN;
	}

	public void setCOMP_APS_PROMOTE_YN_LABEL(HtmlOutputLabel COMP_APS_PROMOTE_YN_LABEL) {
		this.COMP_APS_PROMOTE_YN_LABEL = COMP_APS_PROMOTE_YN_LABEL;
	}

	public void setCOMP_APS_PROMOTE_YN(HtmlSelectOneMenu COMP_APS_PROMOTE_YN) {
		this.COMP_APS_PROMOTE_YN = COMP_APS_PROMOTE_YN;
	}

	public HtmlOutputLabel getCOMP_APS_DEDUCT_YN_LABEL() {
		return COMP_APS_DEDUCT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APS_DEDUCT_YN() {
		return COMP_APS_DEDUCT_YN;
	}

	public void setCOMP_APS_DEDUCT_YN_LABEL(HtmlOutputLabel COMP_APS_DEDUCT_YN_LABEL) {
		this.COMP_APS_DEDUCT_YN_LABEL = COMP_APS_DEDUCT_YN_LABEL;
	}

	public void setCOMP_APS_DEDUCT_YN(HtmlSelectOneMenu COMP_APS_DEDUCT_YN) {
		this.COMP_APS_DEDUCT_YN = COMP_APS_DEDUCT_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_APS_MKT_CODE_DESC_LABEL() {
		return COMP_UI_M_APS_MKT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_APS_MKT_CODE_DESC() {
		return COMP_UI_M_APS_MKT_CODE_DESC;
	}

	public void setCOMP_UI_M_APS_MKT_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_APS_MKT_CODE_DESC_LABEL) {
		this.COMP_UI_M_APS_MKT_CODE_DESC_LABEL = COMP_UI_M_APS_MKT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_APS_MKT_CODE_DESC(HtmlInputText COMP_UI_M_APS_MKT_CODE_DESC) {
		this.COMP_UI_M_APS_MKT_CODE_DESC = COMP_UI_M_APS_MKT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_APS_RANK_CODE_DESC_LABEL() {
		return COMP_UI_M_APS_RANK_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_APS_RANK_CODE_DESC() {
		return COMP_UI_M_APS_RANK_CODE_DESC;
	}

	public void setCOMP_UI_M_APS_RANK_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_APS_RANK_CODE_DESC_LABEL) {
		this.COMP_UI_M_APS_RANK_CODE_DESC_LABEL = COMP_UI_M_APS_RANK_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_APS_RANK_CODE_DESC(HtmlInputText COMP_UI_M_APS_RANK_CODE_DESC) {
		this.COMP_UI_M_APS_RANK_CODE_DESC = COMP_UI_M_APS_RANK_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_MKT_CODE_LOV() {
		return COMP_UI_M_APS_MKT_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_MKT_CODE_LOV(HtmlCommandButton COMP_UI_M_APS_MKT_CODE_LOV) {
		this.COMP_UI_M_APS_MKT_CODE_LOV = COMP_UI_M_APS_MKT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APS_RANK_CODE_LOV() {
		return COMP_UI_M_APS_RANK_CODE_LOV;
	}

	public void setCOMP_UI_M_APS_RANK_CODE_LOV(HtmlCommandButton COMP_UI_M_APS_RANK_CODE_LOV) {
		this.COMP_UI_M_APS_RANK_CODE_LOV = COMP_UI_M_APS_RANK_CODE_LOV;
	}

	public PM_AGENT_PF_SETUP getPM_AGENT_PF_SETUP_BEAN() {
		return PM_AGENT_PF_SETUP_BEAN;
	}

	public void setPM_AGENT_PF_SETUP_BEAN(PM_AGENT_PF_SETUP PM_AGENT_PF_SETUP_BEAN) {
		this.PM_AGENT_PF_SETUP_BEAN = PM_AGENT_PF_SETUP_BEAN;
		
		}
	
	public List getLIST_APS_PROMOTE_YN() {
		return LIST_APS_PROMOTE_YN;
	}

	public void setLIST_APS_PROMOTE_YN(List list_aps_promote_yn) {
		LIST_APS_PROMOTE_YN = list_aps_promote_yn;
	}

	public List getLIST_APS_DEDUCT_YN() {
		return LIST_APS_DEDUCT_YN;
	}

	public void setLIST_APS_DEDUCT_YN(List list_aps_deduct_yn) {
		LIST_APS_DEDUCT_YN = list_aps_deduct_yn;
	}

	public List getLIST_APS_COMM_TYPE() {
		return LIST_APS_COMM_TYPE;
	}

	public void setLIST_APS_COMM_TYPE(List list_aps_comm_type) {
		LIST_APS_COMM_TYPE = list_aps_comm_type;
	}
	
	public Map<String, Object> getSessionMap(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}
	
	
	/*public String preForm() throws Exception {
		Map<String, Object> session = getSessionMap();
		session.put("GLOBAL.M_FAILURE", "FALSE");
		 if(!isUpdate()){
		WHEN_CREATE_RECORD();
		 }
		return null;
	}*/
	
	
	public String fetchRecord() throws Exception{
		
		ResultSet recordset=null;
		List recordList = null;
		recordList = getHandler().fetch("SELECT ROWID,PM_AGENT_PF_SETUP.* FROM PM_AGENT_PF_SETUP", "com.iii.pel.forms.PM100_A_TISB.PM_AGENT_PF_SETUP",CommonUtils.getConnection());
		if(!recordList.equals(null)){
		PM_AGENT_PF_SETUP fetchRecord = (PM_AGENT_PF_SETUP)recordList.get(0);
		setPM_AGENT_PF_SETUP_BEAN((PM_AGENT_PF_SETUP)(recordList.get(0)));
		/*getCOMP_APS_COMM_PER().setSubmittedValue(String.valueOf(fetchRecord.getAPS_COMM_PER()));
		getCOMP_APS_COMM_RATE_PER().setSubmittedValue(String.valueOf(fetchRecord.getAPS_COMM_RATE_PER()));
		getCOMP_APS_EXP_MONTHS().setSubmittedValue(String.valueOf(fetchRecord.getAPS_EXP_MONTHS()));
		getCOMP_APS_MKT_CODE().setSubmittedValue(fetchRecord.getAPS_MKT_CODE());
		getCOMP_APS_RANK_CODE().setSubmittedValue(fetchRecord.getAPS_RANK_CODE());*/
		}
		

		return null;
	}
	
	
	public String deleteRecord(){
		try{
			Connection con =CommonUtils.getConnection();
		int i=getHandler().executeDelete(getPM_AGENT_PF_SETUP_BEAN(),con);
		con.commit();
		getWarningMap().put("current",i+" "+"row/rows deleted");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String save() {
		CommonUtils.clearMaps(this);
		try{
		int rowsUpdated = 0;
		Connection con =CommonUtils.getConnection();
		if(getPM_AGENT_PF_SETUP_BEAN().getROWID() == null)
		{
			PRE_INSERT(PM_AGENT_PF_SETUP_BEAN);
			rowsUpdated = getHandler().executeInsert(getPM_AGENT_PF_SETUP_BEAN(), con);
			con.commit();
			if(rowsUpdated>0)
			{
				getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$save"));
				getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$save"));
			}
		}else{
			PRE_UPDATE(PM_AGENT_PF_SETUP_BEAN);
			rowsUpdated = getHandler().executeUpdate(getPM_AGENT_PF_SETUP_BEAN(), con);
			con.commit();
			if(rowsUpdated>0)
			{
				getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$update"));
				getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$update"));
	
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
		return null;
		

	}
	 
	 public ArrayList<com.iii.premia.common.bean.LovBean> lovAPS_RANK_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
		    suggestionList = listitemutil.P_CALL_LOV("PM100_A_APAC",
			    "PM_AGENT_PF_SETUP", "APS_RANK_CODE", "AGNRANK", null, null, null,
			    null, (String) currValue);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return suggestionList;
	    }
	 public ArrayList<com.iii.premia.common.bean.LovBean> lovAPS_MKT_CODE(Object currValue) {
	     ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	     ListItemUtil listitemutil = new ListItemUtil();
	     try {
		 suggestionList = listitemutil.P_CALL_LOV("PM100_A_APAC",
			 "PM_AGENT_PF_SETUP", "APS_MKT_CODE", "MKTCODE", null, null, null,
			 null, (String) currValue);
	     } catch (Exception e) {
		 e.printStackTrace();
	     }
	     return suggestionList;
	 }

	 
	public String popMktCodeDesc() throws Exception{
		ResultSet rs =null;
		String mktDesc=null;
		String codeValue= getCOMP_APS_MKT_CODE().getSubmittedValue().toString();
		if(!codeValue.equals("")|| codeValue!=null){
		String desc = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'MKTCODE' and PC_CODE ='"+
							codeValue+"'";
				
		 rs = getHandler().executeSelectStatement(desc, CommonUtils.getConnection());
		if(rs.next()){
			mktDesc = rs.getString(1);
			getCOMP_UI_M_APS_MKT_CODE_DESC().setSubmittedValue(mktDesc);
		}
		rs.close();
		}
		return mktDesc;
		
	}
	
	 
	public String popRankCodeDesc() throws Exception{
		ResultSet rs=null;
		String rankDesc=null;
		String codeValue = getCOMP_APS_RANK_CODE().getSubmittedValue().toString();
		if(!codeValue.equals("")|| codeValue!=null){
		String desc = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' and PC_CODE ='"+
		getCOMP_APS_RANK_CODE().getSubmittedValue().toString()+"'";

		rs = getHandler().executeSelectStatement(desc, CommonUtils.getConnection());
		if(rs.next()){
			rankDesc=rs.getString(1);
			getCOMP_UI_M_APS_RANK_CODE_DESC().setSubmittedValue(rankDesc);
		}
		rs.close();
		}
		return rankDesc;
		
		
	}
	 
	public void fireFieldValidation(ActionEvent ae){
		UIInput input = (UIInput)ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		
	}
	 
	public void validatorExpInMonths(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		PM_AGENT_PF_SETUP_BEAN.setAPS_EXP_MONTHS((Integer) value);
		CommonUtils.clearMaps(this);
		String exp =(String)(((UIInput)component).getSubmittedValue());
		if(exp!=null&&!"".equals(exp)){
			Integer IExp=Integer.valueOf(exp);
			if(IExp<1){
				String message="Must be in a range greater than 1";
				FacesMessage errorMessage = new FacesMessage(message);
				throw new ValidatorException(errorMessage);
			}
		}
	}
	
	
	public void validatorCommRate(FacesContext context, UIComponent component,
	Object value) throws ValidatorException {
		PM_AGENT_PF_SETUP_BEAN.setAPS_COMM_PER((Double) value);
		CommonUtils.clearMaps(this);
		String rate = (String)(((UIInput)component).getSubmittedValue());
		if(rate!=null&&!"".equals(rate)){
			Double dRate=Double.valueOf(rate);
			if(dRate<0){
				String message="Must be in a range greater than .0000";
				FacesMessage errorMessage = new FacesMessage(message);
				throw new ValidatorException(errorMessage);
			}
		}
	}
	
	
	/*public void validatorCommRatePer(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
			PM_AGENT_PF_SETUP_BEAN.setAPS_COMM_RATE_PER((Double) value);
				if(rate!=null&&!"".equals(rate)){
					Double dRate=Double.valueOf(rate);
					if(dRate<0){
						String message="Must be in a range greater than 0";
						FacesMessage errorMessage = new FacesMessage(message);
						throw new ValidatorException(errorMessage);
						
						
					}
				}
			}*/
	
	public void WHEN_CREATE_RECORD(){
		System.out.println("PM_AGENT_PF_SETUP_ACTION.WHEN_CREATE_RECORD()-------");
		getPM_AGENT_PF_SETUP_BEAN().setAPS_COMM_TYPE("F");
		getPM_AGENT_PF_SETUP_BEAN().setAPS_PROMOTE_YN("Y");
		getPM_AGENT_PF_SETUP_BEAN().setAPS_DEDUCT_YN("Y");
	    getPM_AGENT_PF_SETUP_BEAN().setAPS_EXP_MONTHS(Integer.parseInt("0"));
	    getPM_AGENT_PF_SETUP_BEAN().setAPS_COMM_PER(Double.parseDouble("0"));
	    getPM_AGENT_PF_SETUP_BEAN().setAPS_COMM_RATE_PER(Double.parseDouble("0"));
	
	    /*getCOMP_APS_COMM_TYPE().setSubmittedValue(null);
	    getCOMP_APS_PROMOTE_YN().setSubmittedValue(null);
	    getCOMP_APS_DEDUCT_YN().setSubmittedValue(null);
	    getCOMP_APS_EXP_MONTHS().setSubmittedValue(null);
	    getCOMP_APS_COMM_PER().setSubmittedValue(null);
	    getCOMP_APS_COMM_RATE_PER().setSubmittedValue(null);*/
	    
		
	}
	

	public void PRE_INSERT(PM_AGENT_PF_SETUP pm_agent_pf_setup)throws Exception
	{
		String TEMPROWID = new PM100_A_TISB_SearchDelegate().duplicateCheck(pm_agent_pf_setup);
		if(CommonUtils.isDuplicate(pm_agent_pf_setup.getROWID(), TEMPROWID))
		{
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "60018"));
		}
		pm_agent_pf_setup.setAPS_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		pm_agent_pf_setup.setAPS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
	
	public void PRE_UPDATE(PM_AGENT_PF_SETUP pm_agent_pf_setup)throws Exception
	{
	    String TEMPROWID = new PM100_A_TISB_SearchDelegate().duplicateCheck(pm_agent_pf_setup);
	    if(CommonUtils.isDuplicate(pm_agent_pf_setup.getROWID(), TEMPROWID))
	    {
		throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "60018"));
	    }
	    pm_agent_pf_setup.setAPS_UPD_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
	    pm_agent_pf_setup.setAPS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
	

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				new PM_AGENT_PF_SETUP_DELEGATE().executeSelectStatement(this);
			if (PM_AGENT_PF_SETUP_BEAN.getROWID() != null) {
				//popMktCodeDesc();
				//popRankCodeDesc();
			}else{
				WHEN_CREATE_RECORD();
			}
			setBlockFlag(false);
			}
		} catch (Exception e) {
		 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
		 getErrorMap().put("onLoad",e.getMessage());
		}
	}
	
	public void validateAPS_MKT_CODE(FacesContext context,UIComponent component,Object value) {
	    try {
		if(value!=null){
		    PM_AGENT_PF_SETUP_BEAN.setAPS_MKT_CODE((String)value);
		    new DBProcedures().P_VAL_CODES("MKTCODE",(String)value,
			    PM_AGENT_PF_SETUP_BEAN.getUI_M_APS_MKT_CODE_DESC(),"N","E",null );
		}
	    } catch (Exception exception) {
		    exception.printStackTrace();
		    throw new ValidatorException(new FacesMessage(exception
		    		.getMessage()));
		} finally {
		    try {
			ErrorHelpUtil.getWarningForProcedure(CommonUtils
				.getConnection(), "APS_MKT_CODE",
				getWarningMap());
			
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	}
	public void validateAPS_RANK_CODE(FacesContext context,UIComponent component,Object value) {
	    try {
		if(value!=null){
		   
		    PM_AGENT_PF_SETUP_BEAN.setAPS_RANK_CODE((String)value);
		    new DBProcedures().P_VAL_CODES("AGNRANK",(String)value,
			    PM_AGENT_PF_SETUP_BEAN.getUI_M_APS_RANK_CODE_DESC(),"N","E",null );
		}
	    } catch (Exception exception) {
		exception.printStackTrace();
		throw new ValidatorException(new FacesMessage(exception
			.getMessage()));
	    } finally {
		try {
		    ErrorHelpUtil.getWarningForProcedure(CommonUtils
			    .getConnection(), "APS_RANK_CODE",
			    getWarningMap());
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	
	/*public void onLoad(PhaseEvent event){
		try{
		if(isBlockFlag()){
			fetchRecord();
			if(PM_AGENT_PF_SETUP_BEAN.getROWID() != null){
				popMktCodeDesc();
				popRankCodeDesc();
			}else{
				WHEN_CREATE_RECORD();
			}
			setBlockFlag(false);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	
}
