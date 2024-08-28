package com.iii.pel.forms.PILM202;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM034.PILM034_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_AGE_SLAB_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_AS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_AS_FRZ_FLAG;

	private HtmlOutputLabel COMP_AS_CODE_LABEL;

	private HtmlInputText COMP_AS_CODE;

	private HtmlOutputLabel COMP_AS_DESC_LABEL;

	private HtmlInputText COMP_AS_DESC;

	private HtmlOutputLabel COMP_AS_SHORT_DESC_LABEL;

	private HtmlInputText COMP_AS_SHORT_DESC;

	private HtmlOutputLabel COMP_AS_LONG_DESC_LABEL;

	private HtmlInputText COMP_AS_LONG_DESC;

	private HtmlOutputLabel COMP_AS_BL_DESC_LABEL;

	private HtmlInputText COMP_AS_BL_DESC;

	private HtmlOutputLabel COMP_AS_BL_SHORT_DESC_LABEL;

	private HtmlInputText COMP_AS_BL_SHORT_DESC;

	private HtmlOutputLabel COMP_AS_BL_LONG_DESC_LABEL;

	private HtmlInputText COMP_AS_BL_LONG_DESC;

	private HtmlOutputLabel COMP_AS_MIN_AGE_LABEL;

	private HtmlInputText COMP_AS_MIN_AGE;

	private HtmlOutputLabel COMP_AS_MAX_AGE_LABEL;

	private HtmlInputText COMP_AS_MAX_AGE;

	private PM_IL_AGE_SLAB PM_IL_AGE_SLAB_BEAN;

	private boolean update;

	private HtmlCommandButton dum;

	public PM_IL_AGE_SLAB_ACTION()  {
		PM_IL_AGE_SLAB_BEAN = new PM_IL_AGE_SLAB();
		//executeQuery();
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}
	public HtmlOutputLabel getCOMP_AS_FRZ_FLAG_LABEL() {
		return COMP_AS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_AS_FRZ_FLAG() {
		return COMP_AS_FRZ_FLAG;
	}

	public void setCOMP_AS_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_AS_FRZ_FLAG_LABEL) {
		this.COMP_AS_FRZ_FLAG_LABEL = COMP_AS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_AS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_AS_FRZ_FLAG) {
		this.COMP_AS_FRZ_FLAG = COMP_AS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_AS_CODE_LABEL() {
		return COMP_AS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_AS_CODE() {
		return COMP_AS_CODE;
	}

	public void setCOMP_AS_CODE_LABEL(HtmlOutputLabel COMP_AS_CODE_LABEL) {
		this.COMP_AS_CODE_LABEL = COMP_AS_CODE_LABEL;
	}

	public void setCOMP_AS_CODE(HtmlInputText COMP_AS_CODE) {
		this.COMP_AS_CODE = COMP_AS_CODE;
	}

	public HtmlOutputLabel getCOMP_AS_DESC_LABEL() {
		return COMP_AS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_AS_DESC() {
		return COMP_AS_DESC;
	}

	public void setCOMP_AS_DESC_LABEL(HtmlOutputLabel COMP_AS_DESC_LABEL) {
		this.COMP_AS_DESC_LABEL = COMP_AS_DESC_LABEL;
	}

	public void setCOMP_AS_DESC(HtmlInputText COMP_AS_DESC) {
		this.COMP_AS_DESC = COMP_AS_DESC;
	}

	public HtmlOutputLabel getCOMP_AS_SHORT_DESC_LABEL() {
		return COMP_AS_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_AS_SHORT_DESC() {
		return COMP_AS_SHORT_DESC;
	}

	public void setCOMP_AS_SHORT_DESC_LABEL(HtmlOutputLabel COMP_AS_SHORT_DESC_LABEL) {
		this.COMP_AS_SHORT_DESC_LABEL = COMP_AS_SHORT_DESC_LABEL;
	}

	public void setCOMP_AS_SHORT_DESC(HtmlInputText COMP_AS_SHORT_DESC) {
		this.COMP_AS_SHORT_DESC = COMP_AS_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_AS_LONG_DESC_LABEL() {
		return COMP_AS_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_AS_LONG_DESC() {
		return COMP_AS_LONG_DESC;
	}

	public void setCOMP_AS_LONG_DESC_LABEL(HtmlOutputLabel COMP_AS_LONG_DESC_LABEL) {
		this.COMP_AS_LONG_DESC_LABEL = COMP_AS_LONG_DESC_LABEL;
	}

	public void setCOMP_AS_LONG_DESC(HtmlInputText COMP_AS_LONG_DESC) {
		this.COMP_AS_LONG_DESC = COMP_AS_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_AS_BL_DESC_LABEL() {
		return COMP_AS_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_AS_BL_DESC() {
		return COMP_AS_BL_DESC;
	}

	public void setCOMP_AS_BL_DESC_LABEL(HtmlOutputLabel COMP_AS_BL_DESC_LABEL) {
		this.COMP_AS_BL_DESC_LABEL = COMP_AS_BL_DESC_LABEL;
	}

	public void setCOMP_AS_BL_DESC(HtmlInputText COMP_AS_BL_DESC) {
		this.COMP_AS_BL_DESC = COMP_AS_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_AS_BL_SHORT_DESC_LABEL() {
		return COMP_AS_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_AS_BL_SHORT_DESC() {
		return COMP_AS_BL_SHORT_DESC;
	}

	public void setCOMP_AS_BL_SHORT_DESC_LABEL(HtmlOutputLabel COMP_AS_BL_SHORT_DESC_LABEL) {
		this.COMP_AS_BL_SHORT_DESC_LABEL = COMP_AS_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_AS_BL_SHORT_DESC(HtmlInputText COMP_AS_BL_SHORT_DESC) {
		this.COMP_AS_BL_SHORT_DESC = COMP_AS_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_AS_BL_LONG_DESC_LABEL() {
		return COMP_AS_BL_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_AS_BL_LONG_DESC() {
		return COMP_AS_BL_LONG_DESC;
	}

	public void setCOMP_AS_BL_LONG_DESC_LABEL(HtmlOutputLabel COMP_AS_BL_LONG_DESC_LABEL) {
		this.COMP_AS_BL_LONG_DESC_LABEL = COMP_AS_BL_LONG_DESC_LABEL;
	}

	public void setCOMP_AS_BL_LONG_DESC(HtmlInputText COMP_AS_BL_LONG_DESC) {
		this.COMP_AS_BL_LONG_DESC = COMP_AS_BL_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_AS_MIN_AGE_LABEL() {
		return COMP_AS_MIN_AGE_LABEL;
	}

	public HtmlInputText getCOMP_AS_MIN_AGE() {
		return COMP_AS_MIN_AGE;
	}

	public void setCOMP_AS_MIN_AGE_LABEL(HtmlOutputLabel COMP_AS_MIN_AGE_LABEL) {
		this.COMP_AS_MIN_AGE_LABEL = COMP_AS_MIN_AGE_LABEL;
	}

	public void setCOMP_AS_MIN_AGE(HtmlInputText COMP_AS_MIN_AGE) {
		this.COMP_AS_MIN_AGE = COMP_AS_MIN_AGE;
	}

	public HtmlOutputLabel getCOMP_AS_MAX_AGE_LABEL() {
		return COMP_AS_MAX_AGE_LABEL;
	}

	public HtmlInputText getCOMP_AS_MAX_AGE() {
		return COMP_AS_MAX_AGE;
	}

	public void setCOMP_AS_MAX_AGE_LABEL(HtmlOutputLabel COMP_AS_MAX_AGE_LABEL) {
		this.COMP_AS_MAX_AGE_LABEL = COMP_AS_MAX_AGE_LABEL;
	}

	public void setCOMP_AS_MAX_AGE(HtmlInputText COMP_AS_MAX_AGE) {
		this.COMP_AS_MAX_AGE = COMP_AS_MAX_AGE;
	}

	public PM_IL_AGE_SLAB getPM_IL_AGE_SLAB_BEAN() {
		return PM_IL_AGE_SLAB_BEAN;
	}

	public void setPM_IL_AGE_SLAB_BEAN(PM_IL_AGE_SLAB PM_IL_AGE_SLAB_BEAN) {
		this.PM_IL_AGE_SLAB_BEAN = PM_IL_AGE_SLAB_BEAN;
	}
	public void executeQuery() throws Exception{
		String query="SELECT PM_IL_AGE_SLAB.ROWID,PM_IL_AGE_SLAB.* FROM PM_IL_AGE_SLAB";
		CRUDHandler handler =new CRUDHandler();
		List list=handler.fetch(query, "com.iii.pel.forms.PILM202.PM_IL_AGE_SLAB", CommonUtils.getConnection());
		PM_IL_AGE_SLAB_BEAN=(PM_IL_AGE_SLAB) list.get(0);
	}
	
	
	
	
	public String save()throws Exception{
		Integer i=0;
		try{
			String rowId = null;	
			//Map<String, Object> sessionMap =FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			rowId = PM_IL_AGE_SLAB_BEAN.getROWID();
			if(PM_IL_AGE_SLAB_BEAN.getROWID()==null){
				System.out.println("PM_IL_AGE_SLAB_ACTION.save() for insertion of records");
				CRUDHandler handler =new CRUDHandler();
				PRE_INSERT_AGE_SLAP();
				if(PM_IL_AGE_SLAB_BEAN.isCHECK_BOX()){
					PM_IL_AGE_SLAB_BEAN.setAS_FRZ_FLAG("Y");
					System.out.println("PM_IL_AGE_SLAB_ACTION.save() &&&&  "+PM_IL_AGE_SLAB_BEAN.getAS_FRZ_FLAG());
				}
				i=handler.executeInsert(PM_IL_AGE_SLAB_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				System.out.println("PM_IL_AGE_SLAB_ACTION.save() for insertoin of records>>>> "+i);
			}
			if(PM_IL_AGE_SLAB_BEAN.getROWID()!=null){
				CRUDHandler handler =new CRUDHandler();
				PRE_UPDATE_AGE_SLAP();
				i=handler.executeUpdate(PM_IL_AGE_SLAB_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				System.out.println("PM_IL_AGE_SLAB_ACTION.save() for updation of records>>>> "+i);
				/*if(i>0){
				getWarningMap().put("current", i+" record saved");
			}*/
			}
			if (rowId == null) {
				String insertMessage = Messages.getString("messageProperties", "errorPanel$message$save");
				getWarningMap().put("somekey", insertMessage);
				getWarningMap().put("current", insertMessage);
			}else{
				String updateMessage = Messages.getString("messageProperties", "errorPanel$message$update");
				getWarningMap().put("somekey", updateMessage);
				getWarningMap().put("current", updateMessage);
			}
		}catch(Exception e){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("current",e.getMessage());
			e.printStackTrace();
		}
		return "";
	}
	public String showPrevious(){
		//getCOMP_AS_CODE().getAttributes().put("validator", null);
		return "PILM202_previous";	
	}

	public HtmlCommandButton getDum() {
		return dum;
	}

	public void setDum(HtmlCommandButton dum) {
		this.dum = dum;
	}
	public void executePreform(ActionEvent ae){
		getWarningMap().clear();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
		session.setAttribute("GLOBAL.M_NAME", "PILM202");
		session.setAttribute("GLOBAL.M_MODULE_NAME", "Age Slab Master");
		STD_PRE_FORM();
		getDum().setDisabled(true);
	}
	public void STD_PRE_FORM(){
		ControlBean ctrlBean = CommonUtils.getControlBean();
		Map<String, Object> session =FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 
		System.out.println("PM_IL_AGE_SLAB_ACTION.STD_PRE_FORM()???????? "+(String)session.get("GLOBAL.M_USER_ID"));
		ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		System.out.println("Age slab.STD_PRE_FORM()--- \n "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
	}
	public void PRE_INSERT_AGE_SLAP(){
		ControlBean ctrlBean= CommonUtils.getControlBean();
		PM_IL_AGE_SLAB_BEAN.setAS_FRZ_FLAG("N");
		PM_IL_AGE_SLAB_BEAN.setAS_CR_DT(new java.util.Date());
		PM_IL_AGE_SLAB_BEAN.setAS_CR_UID(ctrlBean.getM_USER_ID());
	}
	public void PRE_UPDATE_AGE_SLAP(){
		ControlBean ctrlBean= CommonUtils.getControlBean();
		PM_IL_AGE_SLAB_BEAN.setAS_UPD_DT(new java.util.Date());
		PM_IL_AGE_SLAB_BEAN.setAS_UPD_UID(ctrlBean.getM_USER_ID());
	}
	public void WHEN_VALIDATE_AS_CODE(ActionEvent ae) throws Exception{ 
		String slapcode=(String) getCOMP_AS_CODE().getSubmittedValue();
		System.out.println("PM_IL_AGE_SLAB_ACTION.WHEN_VALIDATE_ASS_CODE()...."+slapcode);
		if(slapcode.trim()!=null || slapcode.trim().length()>0 ||!"".equals(slapcode)){
			System.out
			.println("PM_IL_AGE_SLAB_ACTION.WHEN_VALIDATE_ASS_CODE()");
			UIInput input = (UIInput) ae.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		}
		if(slapcode.trim()==null || slapcode.trim().length()==0 || "".equals(slapcode.trim()) ){
			System.out
			.println("PM_AGENT_BONUS_SETUP_ACTION.WHEN_VALIDATE_ABS_CODE() FOCUS TEST for empty input >>>");
			//PM_IL_AGE_SLAB_BEAN.setFocusTest("PM_IL_AGE_SLAB:AS_CODE");
		}
	}
	public void validatorAS_CODE(FacesContext context, UIComponent component,Object value) throws SQLException, Exception {
		String CURSORC1="SELECT 'X' FROM PM_IL_AGE_SLAB WHERE AS_CODE =?";
		String CURSORC2="SELECT 'X' FROM PM_IL_AGE_SLAB WHERE AS_CODE =? AND ROWID <> ?";	
		String M_DUMMY ="";
		Map<String, Object> sessionMap =FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if(PM_IL_AGE_SLAB_BEAN.getROWID()==null){
			PreparedStatement ps=null;
			ResultSet rs=null;
			ps=CommonUtils.getConnection().prepareStatement(CURSORC1);
			ps.setString(1, ((String) getCOMP_AS_CODE().getSubmittedValue()).trim());
			rs=ps.executeQuery();
			while(rs.next()){
				M_DUMMY=rs.getString(1);
				System.out.println("PM_IL_AGE_SLAB_ACTION.validatorAS_CODE() for dummy "+M_DUMMY);
			}
			if(!"".equals(M_DUMMY.trim())){
				//throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "90015", new Object[]{"Age Slap Code"})); 
				//RAISE FORM_TRIGGER_FAILURE;	
			}
			ps=CommonUtils.getConnection().prepareStatement(CURSORC2);
			ps.setString(1, ((String) getCOMP_AS_CODE().getSubmittedValue()).trim());
			ps.setString(2, PM_IL_AGE_SLAB_BEAN.getROWID());
			rs=ps.executeQuery();
			while(rs.next()){
				M_DUMMY=rs.getString(1);
			}
			if(!"".equals(M_DUMMY.trim()) || M_DUMMY.trim().length()>0){
				//PM_IL_AGE_SLAB_BEAN.setFocusTest("PM_IL_AGE_SLAB:AS_CODE");
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "92003", new Object[]{"Age Slap Code"})); 
				//RAISE FORM_TRIGGER_FAILURE;	
			}
		}
	}
	public void FRZ_FLAG_CLICK(ActionEvent ae){
		System.out.println("PM_IL_AGE_SLAB_ACTION.FRZ_FLAG_CLICK()");
		//PM_IL_AGE_SLAB_BEAN.setAS_FRZ_FLAG("Y");
	}
	public String WHEN_VALIDATE_AS_DESC(){
		System.out.println("PM_IL_AGE_SLAB_ACTION.WHEN_VALIDATE_AS_DESC()");
		String desc=(String)getCOMP_AS_DESC().getSubmittedValue();
		System.out.println("PM_IL_AGE_SLAB_ACTION.WHEN_VALIDATE_AS_DESC() *****"+desc);
		if(desc!=null && desc.trim().length()>30){
			getCOMP_AS_SHORT_DESC().setSubmittedValue(desc.substring(0, 30));
		}else if(desc!=null && desc.trim().length()<=30){
			getCOMP_AS_SHORT_DESC().setSubmittedValue(desc);
		}
		return"";
	}
	public String WHEN_VALIDATE_AS_BL_DESC(){
		String desc=(String)getCOMP_AS_BL_DESC().getSubmittedValue();
		System.out.println("PM_IL_AGE_SLAB_ACTION.WHEN_VALIDATE_AS_DESC() *****"+desc);
		if(desc!=null && desc.trim().length()>30){
			getCOMP_AS_BL_SHORT_DESC().setSubmittedValue(desc.substring(0, 30));
		}else if(desc!=null && desc.trim().length()<=30){
			getCOMP_AS_BL_SHORT_DESC().setSubmittedValue(desc);
		}
		return"";
	}
	public void WHEN_VALIDATE_AS_MIN_AGE(ActionEvent ae){
		if(getCOMP_AS_MIN_AGE().getSubmittedValue()!=null){
			UIInput input = (UIInput) ae.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		}

	}
	public void validatorAS_MIN_AGE(FacesContext context, UIComponent component,Object value){
		try {
			String  minage_str=(String)getCOMP_AS_MIN_AGE().getSubmittedValue();
			System.out.println("PM_IL_AGE_SLAB_ACTION.validatorAS_MIN_AGE()@@@@@@@ "+minage_str);

			double minage_dou=Double.parseDouble(minage_str.trim());
			if(minage_dou<0 || minage_dou>999){
				//		 STD_MESSAGE_ROUTINE(92004,:CTRL.M_LANG_CODE);
				// RAISE FORM_TRIGGER_FAILURE;
				String errorMessage = Messages.getString(PELConstants.pelErrorMessagePath, "92004", new Object[]{"Age Min Age"});
				getErrorMap().put("select", errorMessage);
				getErrorMap().put("current", errorMessage);
				throw new ValidatorException(new FacesMessage(errorMessage));

			}
			if(getCOMP_AS_MAX_AGE().getSubmittedValue()!=null){
				System.out.println("PM_IL_AGE_SLAB_ACTION.validatorAS_MIN_AGE()111111111");
				/*double  maxage=Double.parseDouble(((String) getCOMP_AS_MAX_AGE().getSubmittedValue()).trim());
			System.out.println("PM_IL_AGE_SLAB_ACTION.validatorAS_MIN_AGE()33333333333333");
			if(minage_dou>maxage){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71013", new Object[]{"Age Min Age"}));  
			}*/

			}
			P_VAL_AGE((int)minage_dou);

		} catch (NumberFormatException e) {
			String errorMessage = "Must be a number constisting one or more digit";
			getErrorMap().put("select", errorMessage);
			getErrorMap().put("current", errorMessage);
			throw new ValidatorException(new FacesMessage(errorMessage));
		}
	}
	public void WHEN_VALIDATE_AS_MAX_AGE(ActionEvent ae){
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void validatorAS_MAX_AGE(FacesContext context, UIComponent component,Object value){
		try {
			String  maxage_str=(String)getCOMP_AS_MAX_AGE().getSubmittedValue();
			System.out.println("PM_IL_AGE_SLAB_ACTION.validatorAS_MAX_AGE()@@@@@@@ "+maxage_str);
			Double maxage_dou=Double.parseDouble(maxage_str.trim());
			String errorMessage = Messages.getString(PELConstants.pelErrorMessagePath, "92005", new Object[]{"Age Min Age"});
			if(maxage_dou.intValue()<0 || maxage_dou.intValue()>999){
				//		 STD_MESSAGE_ROUTINE(92004,:CTRL.M_LANG_CODE);
				// RAISE FORM_TRIGGER_FAILURE;
				getErrorMap().put("select", errorMessage);
				getErrorMap().put("current", errorMessage);
				throw new ValidatorException(new FacesMessage(errorMessage));

			}
			if(getCOMP_AS_MIN_AGE().getSubmittedValue()!=null && getCOMP_AS_MIN_AGE().getSubmittedValue()!=null){
				Double  minage=Double.parseDouble(((String) getCOMP_AS_MIN_AGE().getSubmittedValue()).trim());
				if(minage.intValue()>maxage_dou.intValue()){
					getErrorMap().put("select", errorMessage);
					getErrorMap().put("current", errorMessage);
					throw new ValidatorException(new FacesMessage(errorMessage));  
				}
			}
			P_VAL_AGE(maxage_dou.intValue());

		} catch (NumberFormatException e) {
			String errorMessage = "Must be a number constisting one or more digit";
			getErrorMap().put("select", errorMessage);
			getErrorMap().put("current", errorMessage);
			throw new ValidatorException(new FacesMessage(errorMessage));
		}

	}
	public String delete() throws Exception{
		FacesContext context=FacesContext.getCurrentInstance();
		HttpSession session=((HttpServletRequest)context.getExternalContext().getRequest()).getSession();
		try{
			CRUDHandler handler=new CRUDHandler();
			Integer i=handler.executeDelete(PM_IL_AGE_SLAB_BEAN, CommonUtils.getConnection());
			if(i>0){
				session.setAttribute("PILM202_PM_IL_AGE_SLAB_ACTION", new PM_IL_AGE_SLAB_ACTION());
				getWarningMap().put("current", i+" record deleted");
			}
		}catch(Exception e){

		}
		return"";
	}
	
	// Newly added for delete button
	
	public String deleteRow(){
		try{
			if (isDELETE_ALLOWED()){
				new CRUDHandler().executeDelete(PM_IL_AGE_SLAB_BEAN,CommonUtils.getConnection());
				PM_IL_AGE_SLAB_BEAN = new PM_IL_AGE_SLAB();
				resetAllComponent();
				getWarningMap().put(
						"deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
			}else{
				getErrorMap().put("deleteRow",Messages.getString(PELConstants.
						pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
			}
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}
		return "";
	}


	private void P_VAL_AGE(Integer age) {
		Integer M_COUNT = 0;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		String query = "SELECT COUNT(*) FROM PM_IL_AGE_SLAB WHERE AS_FRZ_FLAG = 'N' AND ? BETWEEN AS_MIN_AGE AND AS_MAX_AGE";

		try {

			values = new Object[1];
			values[0] = age;		
			resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection(), values);

			if(resultSet.next()) {
				M_COUNT = resultSet.getInt(1);
			}

			if(M_COUNT > 0) {
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "92024"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	public void onLoad(PhaseEvent event) {
		try {
			if(isBlockFlag()){
			PM_IL_AGE_SLAB_ACTION action = (PM_IL_AGE_SLAB_ACTION) CommonUtils.getGlobalObject("PILM202_PM_IL_AGE_SLAB_ACTION");
			String rowId = action.getPM_IL_AGE_SLAB_BEAN().getROWID();
			if(rowId != null){
				showDetails(rowId);
			}else{
				setPM_IL_AGE_SLAB_BEAN(new PM_IL_AGE_SLAB());
			}
			setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("BEFORE_PHASE", e.getMessage());
		}
	}

	public void showDetails(String rowid)  {
		try{
		String selectQuery = "Select PM_IL_AGE_SLAB.ROWID,PM_IL_AGE_SLAB.* FROM PM_IL_AGE_SLAB where ROWID='"+rowid+"'";
		CRUDHandler handler = new CRUDHandler();
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PILM202.PM_IL_AGE_SLAB", CommonUtils.getConnection());
		PM_IL_AGE_SLAB dtl = new PM_IL_AGE_SLAB();
		dtl = (PM_IL_AGE_SLAB) list.get(0);
		if(dtl.getAS_FRZ_FLAG().trim().equals("Y")){
			dtl.setCHECK_BOX(true);
			//getCOMP_AS_FRZ_FLAG().setSelected(true);
		}
		this.setPM_IL_AGE_SLAB_BEAN(dtl);
		resetAllComponent();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Resets all components in PM_IL_AGE_SLAB_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_AS_CODE.resetValue();
		COMP_AS_DESC.resetValue();
		COMP_AS_SHORT_DESC.resetValue();
		COMP_AS_LONG_DESC.resetValue();
		COMP_AS_BL_DESC.resetValue();
		COMP_AS_BL_SHORT_DESC.resetValue();
		COMP_AS_BL_LONG_DESC.resetValue();
		COMP_AS_MIN_AGE.resetValue();
		COMP_AS_MAX_AGE.resetValue();

		// Reseting HtmlCommandButton
		

	}

}
