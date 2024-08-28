package com.iii.pel.forms.PILM036;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

//[BugId:Fix122 MMuthu 31-Dec-08 Extended CommonAction class
public class PM_IL_BONUS_ACTION extends CommonAction {
	// BugId:Fix122 MMuthu 31-Dec-08 Extended CommonAction class ]

	private HtmlOutputLabel COMP_BONUS_BL_DESC_LABEL;

	private HtmlInputText COMP_BONUS_BL_DESC;

	private HtmlOutputLabel COMP_BONUS_BL_SHORT_DESC_LABEL;

	private HtmlInputText COMP_BONUS_BL_SHORT_DESC;

	private HtmlOutputLabel COMP_BONUS_CODE_LABEL;

	private HtmlInputText COMP_BONUS_CODE;

	private HtmlOutputLabel COMP_BONUS_DESC_LABEL;

	List<SelectItem> BONUS_TYPE_DESC_LIST = new ArrayList<SelectItem>();

	private HtmlInputText COMP_BONUS_DESC;

	private HtmlOutputLabel COMP_BONUS_SHORT_DESC_LABEL;

	private HtmlInputText COMP_BONUS_SHORT_DESC;

	private HtmlOutputLabel COMP_BONUS_YRS_LABEL;

	private HtmlInputText COMP_BONUS_YRS;

	private HtmlOutputLabel COMP_BONUS_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_BONUS_TYPE;

	private HtmlCommandButton COMP_UI_M_BUT_EDIT_BONUS_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_BL;

	private PM_IL_BONUS PM_IL_BONUS_BEAN;

	private HtmlOutputText COMP_ERROR_MESSAGE;
	private Map<String, String> errorMap = new HashMap<String, String>();
	private String errorMessages;
	private boolean update = false;
	Properties messageProperty;
	String realPath;

	public boolean getUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	// [BugId:Fix122 MMuthu 31-Dec-08 commented PM_IL_BONUS_ACTION class errorMap and errorMessages.
	/*public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	public String getErrorMessages() {
		String messageList;
		if((errorMap == null) || (errorMap.size()== 0)){
			messageList = "";
		}else{
			Map<String,String> error = new HashMap<String, String>();
			error.putAll(errorMap);
			error.remove("current");
			messageList = "<FONT SIZE=2><UL>\n";
			for(String message:error.values()){
	
				messageList = messageList+"<LI>"+message+"\n";
			}
			messageList = messageList + "</UL></FONT>\n"; 
		}
	
		return messageList;

	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}*/
	//BugId:Fix122 MMuthu 31-Dec-08 Removed PM_IL_BONUS_ACTION class errorMap and errorMessages. ]
	public PM_IL_BONUS_ACTION() {
		PM_IL_BONUS_BEAN = new PM_IL_BONUS();
		messageProperty = new Properties();
		realPath = (new File(".")).getAbsolutePath();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_BONUS_BL_DESC_LABEL() {
		return COMP_BONUS_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_BONUS_BL_DESC() {
		return COMP_BONUS_BL_DESC;
	}

	public void setCOMP_BONUS_BL_DESC_LABEL(
			HtmlOutputLabel COMP_BONUS_BL_DESC_LABEL) {
		this.COMP_BONUS_BL_DESC_LABEL = COMP_BONUS_BL_DESC_LABEL;
	}

	public void setCOMP_BONUS_BL_DESC(HtmlInputText COMP_BONUS_BL_DESC) {
		this.COMP_BONUS_BL_DESC = COMP_BONUS_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_BONUS_BL_SHORT_DESC_LABEL() {
		return COMP_BONUS_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_BONUS_BL_SHORT_DESC() {
		return COMP_BONUS_BL_SHORT_DESC;
	}

	public void setCOMP_BONUS_BL_SHORT_DESC_LABEL(
			HtmlOutputLabel COMP_BONUS_BL_SHORT_DESC_LABEL) {
		this.COMP_BONUS_BL_SHORT_DESC_LABEL = COMP_BONUS_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_BONUS_BL_SHORT_DESC(
			HtmlInputText COMP_BONUS_BL_SHORT_DESC) {
		this.COMP_BONUS_BL_SHORT_DESC = COMP_BONUS_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_BONUS_CODE_LABEL() {
		return COMP_BONUS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BONUS_CODE() {
		return COMP_BONUS_CODE;
	}

	public void setCOMP_BONUS_CODE_LABEL(HtmlOutputLabel COMP_BONUS_CODE_LABEL) {
		this.COMP_BONUS_CODE_LABEL = COMP_BONUS_CODE_LABEL;
	}

	public void setCOMP_BONUS_CODE(HtmlInputText COMP_BONUS_CODE) {
		this.COMP_BONUS_CODE = COMP_BONUS_CODE;
	}

	public HtmlOutputLabel getCOMP_BONUS_DESC_LABEL() {
		return COMP_BONUS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_BONUS_DESC() {
		return COMP_BONUS_DESC;
	}

	public void setCOMP_BONUS_DESC_LABEL(HtmlOutputLabel COMP_BONUS_DESC_LABEL) {
		this.COMP_BONUS_DESC_LABEL = COMP_BONUS_DESC_LABEL;
	}

	public void setCOMP_BONUS_DESC(HtmlInputText COMP_BONUS_DESC) {
		this.COMP_BONUS_DESC = COMP_BONUS_DESC;
	}

	public HtmlOutputLabel getCOMP_BONUS_SHORT_DESC_LABEL() {
		return COMP_BONUS_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_BONUS_SHORT_DESC() {
		return COMP_BONUS_SHORT_DESC;
	}

	public void setCOMP_BONUS_SHORT_DESC_LABEL(
			HtmlOutputLabel COMP_BONUS_SHORT_DESC_LABEL) {
		this.COMP_BONUS_SHORT_DESC_LABEL = COMP_BONUS_SHORT_DESC_LABEL;
	}

	public void setCOMP_BONUS_SHORT_DESC(HtmlInputText COMP_BONUS_SHORT_DESC) {
		this.COMP_BONUS_SHORT_DESC = COMP_BONUS_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_BONUS_YRS_LABEL() {
		return COMP_BONUS_YRS_LABEL;
	}

	public HtmlInputText getCOMP_BONUS_YRS() {
		return COMP_BONUS_YRS;
	}

	public void setCOMP_BONUS_YRS_LABEL(HtmlOutputLabel COMP_BONUS_YRS_LABEL) {
		this.COMP_BONUS_YRS_LABEL = COMP_BONUS_YRS_LABEL;
	}

	public void setCOMP_BONUS_YRS(HtmlInputText COMP_BONUS_YRS) {
		this.COMP_BONUS_YRS = COMP_BONUS_YRS;
	}

	public HtmlOutputLabel getCOMP_BONUS_TYPE_LABEL() {
		return COMP_BONUS_TYPE_LABEL;
	}

	public void setCOMP_BONUS_TYPE_LABEL(HtmlOutputLabel COMP_BONUS_TYPE_LABEL) {
		this.COMP_BONUS_TYPE_LABEL = COMP_BONUS_TYPE_LABEL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDIT_BONUS_DESC() {
		return COMP_UI_M_BUT_EDIT_BONUS_DESC;
	}

	public void setCOMP_UI_M_BUT_EDIT_BONUS_DESC(
			HtmlCommandButton COMP_UI_M_BUT_EDIT_BONUS_DESC) {
		this.COMP_UI_M_BUT_EDIT_BONUS_DESC = COMP_UI_M_BUT_EDIT_BONUS_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BL() {
		return COMP_UI_M_BUT_BL;
	}

	public void setCOMP_UI_M_BUT_BL(HtmlCommandButton COMP_UI_M_BUT_BL) {
		this.COMP_UI_M_BUT_BL = COMP_UI_M_BUT_BL;
	}

	public PM_IL_BONUS getPM_IL_BONUS_BEAN() {
		return PM_IL_BONUS_BEAN;
	}

	public void setPM_IL_BONUS_BEAN(PM_IL_BONUS PM_IL_BONUS_BEAN) {
		this.PM_IL_BONUS_BEAN = PM_IL_BONUS_BEAN;
	}

	public HtmlOutputText getCOMP_ERROR_MESSAGE() {
		return COMP_ERROR_MESSAGE;
	}

	public void setCOMP_ERROR_MESSAGE(HtmlOutputText comp_error_message) {
		COMP_ERROR_MESSAGE = comp_error_message;
	}

	public void preForm(PhaseEvent event) {
		System.out.println("PREFORM DISABLED");
		COMP_UI_M_BUT_BL.setDisabled(true);
		SWISS_SQL_PILM036 swissSQL = new SWISS_SQL_PILM036();
		swissSQL.PRE_FORM(FacesContext.getCurrentInstance());

	}
	

	/**
	 * Instantiates all components in PM_IL_BONUS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_BONUS_BL_DESC				 = new HtmlInputText();
		COMP_BONUS_BL_SHORT_DESC			 = new HtmlInputText();
		COMP_BONUS_CODE					 = new HtmlInputText();
		COMP_BONUS_DESC					 = new HtmlInputText();
		COMP_BONUS_SHORT_DESC				 = new HtmlInputText();
		COMP_BONUS_YRS					 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_BONUS_TYPE					 = new HtmlSelectOneMenu();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_EDIT_BONUS_DESC			 = new HtmlCommandButton();
		COMP_UI_M_BUT_BL				 = new HtmlCommandButton();

	}



	/*public void isEmptyCheck(ActionEvent ae){
		UIInput input = (UIInput) ae.getComponent().getParent();
		ERROR_HELP.validate(input, input.getId(), getErrorMap());
	}*/

	public void bilingualDesc(ActionEvent ae) {
		UIInput input = (UIInput) ae.getComponent().getParent();
		String bilingualDesc = (String) input.getSubmittedValue();
		if (bilingualDesc != null) {
			String bilingualShortDesc = null;
			if (bilingualDesc.length() > 30) {
				bilingualShortDesc = bilingualDesc.substring(1, 30);
			} else {
				bilingualShortDesc = bilingualDesc;
			}
			COMP_BONUS_BL_SHORT_DESC.setSubmittedValue(bilingualShortDesc);
			getPM_IL_BONUS_BEAN().setBONUS_BL_SHORT_DESC(bilingualShortDesc);
		}
	}

	public void bonusDesc() {
		SWISS_SQL_PILM036 swissSql = new SWISS_SQL_PILM036();
		swissSql.bonusDescWhenValidateItem(FacesContext.getCurrentInstance());
	}

	public void bonusCodeValidator() {

		PM_IL_BONUS_ACTION bonusAction = (PM_IL_BONUS_ACTION) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap().get(
						"PILM036_PM_IL_BONUS_ACTION");

		if (!bonusAction.getUpdate()) {
			SWISS_SQL_PILM036 swissSql = new SWISS_SQL_PILM036();
			swissSql.bonusCodeWhenValidateItem(FacesContext
					.getCurrentInstance());
		}
	}
	public void WHEN_VALIDATE_BONUS_YRS() throws Exception{
		try {
			if(PM_IL_BONUS_BEAN.getBONUS_YRS() != null && PM_IL_BONUS_BEAN.getBONUS_YRS() <= 0 ){
					throw new Exception(Messages.getString(
							    PELConstants.pelErrorMessagePath, "91014",
							    new Object[] { /* CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"), */
							    "Bonus Years", ">", "0" }));
					 //STD_MESSAGE_ROUTINE(91014,:CTRL.M_LANG_CODE,'Bonus Years','>','0');
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	

	 public void fireFieldValidation(ActionEvent actionEvent) {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		    }
	
	 public void validateBONUS_YRS(FacesContext facesContext,
			    UIComponent component, Object value) throws ValidatorException {
			CommonUtils.clearMaps(this);
			try {
				PM_IL_BONUS_BEAN.setBONUS_YRS((Integer)value);
				WHEN_VALIDATE_BONUS_YRS();
			} catch (Exception exception) {
			    exception.printStackTrace();
			    throw new ValidatorException(new FacesMessage(exception
				    .getMessage()));
			} finally {
			    try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
					.getConnection(), "BONUS_YRS",
					getWarningMap());
			    } catch (Exception e) {
				e.printStackTrace();
			    }
			}
		    }

	public void bonusTermValidator(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		new SWISS_SQL_PILM036().bonusYrsWhenValidateItem(FacesContext
				.getCurrentInstance());
	}

	public void bonusTermValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*public void bonusTypeList(){
		List<String> bonusTypeDescList = ListItemUtil.getComboSuggestionValues(new PM_IL_BONUS_DAO().getConnection(), "PILM036", "PM_IL_BONUS", "PM_IL_BONUS.BONUS_TYPE", "IL_BON_TYP");
		PM_IL_BONUS_ACTION bonusAction = (PM_IL_BONUS_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PM_IL_BONUS_ACTION");
		bonusAction.getPM_IL_BONUS_BEAN().setBONUS_TYPE_DESC_LIST(bonusTypeDescList);
	}*/
	public void beforePhase(PhaseEvent event){
		PM_IL_BONUS_ACTION actionBean = (PM_IL_BONUS_ACTION) new CommonUtils().getMappedBeanFromSession("PILM036_PM_IL_BONUS_ACTION");		
		try {
			if(isBlockFlag()){
				if(actionBean.getPM_IL_BONUS_BEAN().getROWID() != null){
					executeSelectStatement(actionBean);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("BEFORE_PHASE", e.getMessage());
		}
	}
	
	public void executeSelectStatement(PM_IL_BONUS_ACTION actionBean) throws Exception{
		String selectQuery = "Select ROWID, PM_IL_BONUS.* from PM_IL_BONUS where ROWID='"+actionBean.getPM_IL_BONUS_BEAN().getROWID()+"'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_BONUS> list = null;
		
		try {
			con = CommonUtils.getConnection();
			list = handler.fetch(selectQuery, 
					"com.iii.pel.forms.PILM036.PM_IL_BONUS", 
					con);
			actionBean.setPM_IL_BONUS_BEAN(list.get(0));
			actionBean.setUpdate(true);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public static Connection getConnection() throws Exception{
		/*ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		Connection con = ((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("12345");*/
		return CommonUtils.getConnection();
	}
	
	/*public String deleteAction() throws Exception {
		CRUDHandler handler = new CRUDHandler();
		try {
			int rows = handler.executeDelete(PM_IL_BONUS_BEAN, getConnection());
			System.out.println("PM_IL_BONUS_ACTION.deleteAction() DELETED ROWS "+rows);
			if(rows>0){
				getConnection().commit();
//			getWarningMap().put("current", rows+" row deleted");
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				session.removeAttribute("PM021_A_PP_SYSTEM_ACTION");
				session.setAttribute("delete", rows+" row deleted");
//			getWarningMap().put("current", rows+" row deleted");
			resetAllComponent();
			PM_IL_BONUS_BEAN.setRowSelected(true);
			}
			else{
				//getWarningMap().put("current",  " No Data Deleted");
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}
			
			//getPREFORMBUTTON().setDisabled(false);
			return "";
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}*/
	
	public String deleteAction(){
		CommonUtils.clearMaps(this);
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_BONUS bonusBean = null;
		bonusBean = getPM_IL_BONUS_BEAN();
		
		try {
			if (bonusBean == null) {
				getErrorMap().put("key", "not to delete");
				getErrorMap().put("current", "not to delete");
			}else{
				String deleteMeaage = Messages.getString("messageProperties","errorPanel$message$delete");
				//helper.pm_broker_comm_hdr_pre_DELETE(headerBean);
				delete_pm_comm_hdr(bonusBean);
				commonUtils.doComitt();
				setPM_IL_BONUS_BEAN(new PM_IL_BONUS());
				getWarningMap().put("errorKey", deleteMeaage);
				getWarningMap().put("current", deleteMeaage);
			}
			bonusBean.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete_pm_comm_hdr(PM_IL_BONUS bonusBean) throws DBException {
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		
		try {
			connection=CommonUtils.getConnection();
			handler.executeDelete(bonusBean, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	}

	

	/**
	 * Resets all components in PM_IL_BONUS_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_BONUS_BL_DESC.resetValue();
		COMP_BONUS_BL_SHORT_DESC.resetValue();
		COMP_BONUS_CODE.resetValue();
		COMP_BONUS_DESC.resetValue();
		COMP_BONUS_SHORT_DESC.resetValue();
		COMP_BONUS_YRS.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_BONUS_TYPE.resetValue();

	}


	
	/*public void saveBonusMaster() {
		try {
			CommonUtils.getConnection().commit();
			new CRUDHandler().executeInsert(getPM_IL_BONUS_BEAN(), CommonUtils.getConnection());
			PM_IL_BONUS_ACTION bonusActionBean = (PM_IL_BONUS_ACTION) FacesContext
					.getCurrentInstance().getExternalContext().getSessionMap()
					.get("PILM036_PM_IL_BONUS_ACTION");
			boolean update = bonusActionBean.getUpdate();
			PM_IL_BONUS bonusBean = bonusActionBean.getPM_IL_BONUS_BEAN();
			SWISS_SQL_PILM036 swiss = new SWISS_SQL_PILM036();
			if (update) {
				swiss.preUpdate(FacesContext.getCurrentInstance());
				updateBonusMaster(bonusBean);
			} else {
				swiss.preInsert(FacesContext.getCurrentInstance());
				//insertBonusMaster(bonusBean);
				swiss.whenCreateRecord(FacesContext.getCurrentInstance());
			}
			swiss.postDatabaseCommit(FacesContext.getCurrentInstance());
			String message ="";
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}*/
	public void saveBonusMaster(){
		CommonUtils.clearMaps(this);
		SWISS_SQL_PILM036 swiss = new SWISS_SQL_PILM036();
		String message = "";
		try {
			if (getPM_IL_BONUS_BEAN().getROWID() == null) {
				swiss.preInsert(FacesContext.getCurrentInstance());
				new CRUDHandler().executeInsert(getPM_IL_BONUS_BEAN(),
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$save");
			} else {
				swiss.preUpdate(FacesContext.getCurrentInstance());
				new CRUDHandler().executeUpdate(getPM_IL_BONUS_BEAN(),
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$update");
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE",
					message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	

	public String bonusDetails() {
		return "PILM036_PM_IL_BONUS";
	}
	

	public void updateBonusMaster(PM_IL_BONUS bonusBean) {
		try {
			new PM_IL_BONUS_DAO().updateBonusMaster(bonusBean);
			//			[BugId:Fix122 MMuthu 31-Dec-08 Getting connection from CommonUtils class getConnection()
			//				and error and warning maps are getting from CommonAction 				
			getWarningMap().put("current", "Record updated successfully");
		} catch (Exception e) {
			getErrorMap().put("current", "Problem in updating the record");
		}
		// BugId:Fix122 MMuthu 31-Dec-08 Getting connection from CommonUtils class getConnection() 
		//			and error and warning maps are getting from CommonAction]		
	}

	public String bonusMasterHome() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PM_IL_BONUS_ACTION bonusAction = new PM_IL_BONUS_ACTION();
		sessionMap.put("PILM036_PM_IL_BONUS_ACTION", bonusAction);
		String actionClass = "PILM036_PM_IL_BONUS_QUERY_ACTION";
		String actionMethod = "queryData";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
		return "back";
	}
	
	public String backToSearch(){
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}

	public List<SelectItem> getBONUS_TYPE_DESC_LIST() throws Exception {

		if (BONUS_TYPE_DESC_LIST.size() == 0) {
			BONUS_TYPE_DESC_LIST.clear();
			BONUS_TYPE_DESC_LIST = ListItemUtil.getDropDownListValue(
					com.iii.premia.common.utils.CommonUtils.getConnection(), "PILM036",
					"PM_IL_BONUS", "PM_IL_BONUS.BONUS_TYPE", "IL_BON_TYP");

		}
		return BONUS_TYPE_DESC_LIST;
	}

	public void bonusTypeValue() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		new SWISS_SQL_PILM036().type(FacesContext.getCurrentInstance());
	}

	public void setBONUS_TYPE_DESC_LIST(List<SelectItem> bonus_type_desc_list) {
		BONUS_TYPE_DESC_LIST = bonus_type_desc_list;
	}

	public void setCOMP_BONUS_TYPE(HtmlSelectOneMenu comp_bonus_type) {
		COMP_BONUS_TYPE = comp_bonus_type;
	}

	public HtmlSelectOneMenu getCOMP_BONUS_TYPE() {
		return COMP_BONUS_TYPE;
	}

	public static void pilm036_dummy_m_but_bl_when_button_pressed()
			throws SQLException, Exception {
		Connection connection = CommonUtils.getConnection();
		try {
			String M_TEMP = null;
			//	            M_TEMP=GET_VIEW_PROPERTY("PM_IL_BONUS_1",VISIBLE);
			if (M_TEMP.equals("" + "FALSE")) {
				//	                SHOW_VIEW("PM_IL_BONUS_1");
				//	                GO_ITEM("BONUS_BL_DESC");
			} else {
				//	                HIDE_VIEW("PM_IL_BONUS_1");
				//	                GO_ITEM("BONUS_DESC");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			/*if(connection != null)
			{
				connection.close();
			}*/
		}
	}

}
