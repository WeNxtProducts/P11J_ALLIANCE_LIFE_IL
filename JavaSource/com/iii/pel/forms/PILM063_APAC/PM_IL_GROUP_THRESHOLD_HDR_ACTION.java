package com.iii.pel.forms.PILM063_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_GROUP_THRESHOLD_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_GTH_GROUP_CODE_LABEL;

	private HtmlInputText COMP_GTH_GROUP_CODE;

	private HtmlOutputLabel COMP_GTH_GROUP_DESC_LABEL;

	private HtmlInputText COMP_GTH_GROUP_DESC;

	private HtmlOutputLabel COMP_GTH_GROUP_SHORT_DESC_LABEL;

	private HtmlInputText COMP_GTH_GROUP_SHORT_DESC;

	private HtmlOutputLabel COMP_GTH_GROUP_LONG_DESC_LABEL;

	private HtmlInputText COMP_GTH_GROUP_LONG_DESC;

	private HtmlOutputLabel COMP_GTH_VALIDATION_CODE_LABEL;

	private HtmlInputText COMP_GTH_VALIDATION_CODE;

	private HtmlOutputLabel COMP_UI_M_GTH_VALIDATION_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_GTH_VALIDATION_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_LOV_GTD_COVER_CODE;

	private HtmlCommandButton COMP_UI_M_EDITOR_GTH_GROUP_LONG_DESC;

	private HtmlCommandButton COMP_UI_M_LOV_GTH_VALIDATION_CODE;

	private PM_IL_GROUP_THRESHOLD_HDR PM_IL_GROUP_THRESHOLD_HDR_BEAN;
	
	private boolean update = false;

	/** LOV is Handled Here. */
	PILM063_APAC_ActionDelegate actionDelegate = new PILM063_APAC_ActionDelegate();
	
	ArrayList<PM_IL_GROUP_THRESHOLD_HDR> searchList = new ArrayList<PM_IL_GROUP_THRESHOLD_HDR>();
	/** LOV is Handled Here. */

	/* Variables Required For Form-Level Events */
	private String insertFlag = "";
	private String focusOn;
	private HtmlCommandButton button;
	private TabbedBar tabbedBar = null;
	FacesContext facesCtx = null;

	Map<String, Object> sessionMap = null;
	HttpSession session = null;
	CRUDHandler handler = new CRUDHandler();

	public Map<String, Object> getSessionMap() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	/* Variables Required For Form-Level Events */

	public PM_IL_GROUP_THRESHOLD_HDR_ACTION() {
		tabbedBar = new TabbedBar();
		PM_IL_GROUP_THRESHOLD_HDR_BEAN = new PM_IL_GROUP_THRESHOLD_HDR();

		try {
			tabbedBar.addTab(1, "", "Group Threshold Limit Header", false);
			tabbedBar
					.addTab(
							2,
							"#{PILM063_APAC_PM_IL_GROUP_THRESHOLD_HDR_ACTION.NextPageNavigation}",
							"Group Threshold Limit Detail", false);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public HtmlOutputLabel getCOMP_GTH_GROUP_CODE_LABEL() {
		return COMP_GTH_GROUP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_GTH_GROUP_CODE() {
		return COMP_GTH_GROUP_CODE;
	}

	public void setCOMP_GTH_GROUP_CODE_LABEL(
			HtmlOutputLabel COMP_GTH_GROUP_CODE_LABEL) {
		this.COMP_GTH_GROUP_CODE_LABEL = COMP_GTH_GROUP_CODE_LABEL;
	}

	public void setCOMP_GTH_GROUP_CODE(HtmlInputText COMP_GTH_GROUP_CODE) {
		this.COMP_GTH_GROUP_CODE = COMP_GTH_GROUP_CODE;
	}

	public HtmlOutputLabel getCOMP_GTH_GROUP_DESC_LABEL() {
		return COMP_GTH_GROUP_DESC_LABEL;
	}

	public HtmlInputText getCOMP_GTH_GROUP_DESC() {
		return COMP_GTH_GROUP_DESC;
	}

	public void setCOMP_GTH_GROUP_DESC_LABEL(
			HtmlOutputLabel COMP_GTH_GROUP_DESC_LABEL) {
		this.COMP_GTH_GROUP_DESC_LABEL = COMP_GTH_GROUP_DESC_LABEL;
	}

	public void setCOMP_GTH_GROUP_DESC(HtmlInputText COMP_GTH_GROUP_DESC) {
		this.COMP_GTH_GROUP_DESC = COMP_GTH_GROUP_DESC;
	}

	public HtmlOutputLabel getCOMP_GTH_GROUP_SHORT_DESC_LABEL() {
		return COMP_GTH_GROUP_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_GTH_GROUP_SHORT_DESC() {
		return COMP_GTH_GROUP_SHORT_DESC;
	}

	public void setCOMP_GTH_GROUP_SHORT_DESC_LABEL(
			HtmlOutputLabel COMP_GTH_GROUP_SHORT_DESC_LABEL) {
		this.COMP_GTH_GROUP_SHORT_DESC_LABEL = COMP_GTH_GROUP_SHORT_DESC_LABEL;
	}

	public void setCOMP_GTH_GROUP_SHORT_DESC(
			HtmlInputText COMP_GTH_GROUP_SHORT_DESC) {
		this.COMP_GTH_GROUP_SHORT_DESC = COMP_GTH_GROUP_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_GTH_GROUP_LONG_DESC_LABEL() {
		return COMP_GTH_GROUP_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_GTH_GROUP_LONG_DESC() {
		return COMP_GTH_GROUP_LONG_DESC;
	}

	public void setCOMP_GTH_GROUP_LONG_DESC_LABEL(
			HtmlOutputLabel COMP_GTH_GROUP_LONG_DESC_LABEL) {
		this.COMP_GTH_GROUP_LONG_DESC_LABEL = COMP_GTH_GROUP_LONG_DESC_LABEL;
	}

	public void setCOMP_GTH_GROUP_LONG_DESC(
			HtmlInputText COMP_GTH_GROUP_LONG_DESC) {
		this.COMP_GTH_GROUP_LONG_DESC = COMP_GTH_GROUP_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_GTH_VALIDATION_CODE_LABEL() {
		return COMP_GTH_VALIDATION_CODE_LABEL;
	}

	public HtmlInputText getCOMP_GTH_VALIDATION_CODE() {
		return COMP_GTH_VALIDATION_CODE;
	}

	public void setCOMP_GTH_VALIDATION_CODE_LABEL(
			HtmlOutputLabel COMP_GTH_VALIDATION_CODE_LABEL) {
		this.COMP_GTH_VALIDATION_CODE_LABEL = COMP_GTH_VALIDATION_CODE_LABEL;
	}

	public void setCOMP_GTH_VALIDATION_CODE(
			HtmlInputText COMP_GTH_VALIDATION_CODE) {
		this.COMP_GTH_VALIDATION_CODE = COMP_GTH_VALIDATION_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_GTH_VALIDATION_CODE_DESC_LABEL() {
		return COMP_UI_M_GTH_VALIDATION_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_GTH_VALIDATION_CODE_DESC() {
		return COMP_UI_M_GTH_VALIDATION_CODE_DESC;
	}

	public void setCOMP_UI_M_GTH_VALIDATION_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_GTH_VALIDATION_CODE_DESC_LABEL) {
		this.COMP_UI_M_GTH_VALIDATION_CODE_DESC_LABEL = COMP_UI_M_GTH_VALIDATION_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_GTH_VALIDATION_CODE_DESC(
			HtmlInputText COMP_UI_M_GTH_VALIDATION_CODE_DESC) {
		this.COMP_UI_M_GTH_VALIDATION_CODE_DESC = COMP_UI_M_GTH_VALIDATION_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_GTD_COVER_CODE() {
		return COMP_UI_M_LOV_GTD_COVER_CODE;
	}

	public void setCOMP_UI_M_LOV_GTD_COVER_CODE(
			HtmlCommandButton COMP_UI_M_LOV_GTD_COVER_CODE) {
		this.COMP_UI_M_LOV_GTD_COVER_CODE = COMP_UI_M_LOV_GTD_COVER_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_EDITOR_GTH_GROUP_LONG_DESC() {
		return COMP_UI_M_EDITOR_GTH_GROUP_LONG_DESC;
	}

	public void setCOMP_UI_M_EDITOR_GTH_GROUP_LONG_DESC(
			HtmlCommandButton COMP_UI_M_EDITOR_GTH_GROUP_LONG_DESC) {
		this.COMP_UI_M_EDITOR_GTH_GROUP_LONG_DESC = COMP_UI_M_EDITOR_GTH_GROUP_LONG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_GTH_VALIDATION_CODE() {
		return COMP_UI_M_LOV_GTH_VALIDATION_CODE;
	}

	public void setCOMP_UI_M_LOV_GTH_VALIDATION_CODE(
			HtmlCommandButton COMP_UI_M_LOV_GTH_VALIDATION_CODE) {
		this.COMP_UI_M_LOV_GTH_VALIDATION_CODE = COMP_UI_M_LOV_GTH_VALIDATION_CODE;
	}

	public PM_IL_GROUP_THRESHOLD_HDR getPM_IL_GROUP_THRESHOLD_HDR_BEAN() {
		return PM_IL_GROUP_THRESHOLD_HDR_BEAN;
	}

	public void setPM_IL_GROUP_THRESHOLD_HDR_BEAN(
			PM_IL_GROUP_THRESHOLD_HDR PM_IL_GROUP_THRESHOLD_HDR_BEAN) {
		this.PM_IL_GROUP_THRESHOLD_HDR_BEAN = PM_IL_GROUP_THRESHOLD_HDR_BEAN;
	}

	/** Navigation for Next Page is Handled Here */
	public String NextPageNavigation() {
		return "PILM063_APAC_GroupThresholdDetail";
	}

	/** Navigation for Next Page is Handled Here */

	/** Navigation To The Previous Page is Handled Here. */
	public String previousPageNavigation() {
		return "PILM063_APAC";
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public String deleteAction(){
		CommonUtils commonUtils = new CommonUtils();
		try {
			if (PM_IL_GROUP_THRESHOLD_HDR_BEAN == null) {
				getErrorMap().put("key", "not to delete");
				getErrorMap().put("current", "not to delete");
			}else{
				String deleteMeaage = Messages.getString("messageProperties","errorPanel$message$delete");
				//helper.pm_broker_comm_hdr_pre_DELETE(headerBean);
				delete_pm_comm_hdr();
				commonUtils.doComitt();
				setPM_IL_GROUP_THRESHOLD_HDR_BEAN(new PM_IL_GROUP_THRESHOLD_HDR());
				getWarningMap().put("errorKey", deleteMeaage);
				getWarningMap().put("current", deleteMeaage);
			}
			PM_IL_GROUP_THRESHOLD_HDR_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete_pm_comm_hdr() throws DBException {
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		
		try {
			connection=CommonUtils.getConnection();
			handler.executeDelete(PM_IL_GROUP_THRESHOLD_HDR_BEAN, connection);
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

	
	public void GTH_GROUP_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		CommonUtils.clearMaps(this);
		try {
			getPM_IL_GROUP_THRESHOLD_HDR_BEAN().setGTH_GROUP_CODE((String)value);
			GTH_GROUP_CODE_WhenValidateItem(PM_IL_GROUP_THRESHOLD_HDR_BEAN);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {

				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void GTH_VALIDATION_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		CommonUtils.clearMaps(this);
		try {
			getPM_IL_GROUP_THRESHOLD_HDR_BEAN().setGTH_VALIDATION_CODE((String)value);
			GTH_VALIDATION_CODE_WhenValidateItem(PM_IL_GROUP_THRESHOLD_HDR_BEAN);
			COMP_UI_M_GTH_VALIDATION_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {

				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	/** Navigation To The Previous Page is Handled Here. */

	/**
	 * Field Level Triggers are Handled Here.
	 * 
	 * @throws Exception
	 * @throws SQLException
	 */
	public void GTH_GROUP_CODE_WhenValidateItem(PM_IL_GROUP_THRESHOLD_HDR PM_IL_GROUP_THRESHOLD_HDR_BEAN)
			throws Exception {
		String selectQuery1 = "SELECT ROWID FROM PM_IL_GROUP_THRESHOLD_HDR WHERE GTH_GROUP_CODE = '"
				+ PM_IL_GROUP_THRESHOLD_HDR_BEAN.getGTH_GROUP_CODE() + "'";
		ResultSet rs1 = null;
		String M_DUMMY = null;
		try{
		rs1 = handler.executeSelectStatement(selectQuery1,getConnection());
		while (rs1.next()) {
			M_DUMMY = rs1.getString(1);
			if(CommonUtils.isDuplicate(PM_IL_GROUP_THRESHOLD_HDR_BEAN.getROWID(), M_DUMMY))
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "1801"));
		}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
			
		}finally{try{
			CommonUtils.closeCursor(rs1);
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		}
		
	}

	public void GTH_VALIDATION_CODE_WhenValidateItem(PM_IL_GROUP_THRESHOLD_HDR PM_IL_GROUP_THRESHOLD_HDR_BEAN)
			throws Exception {
		if (PM_IL_GROUP_THRESHOLD_HDR_BEAN.getGTH_VALIDATION_CODE()!=null) {
			P_VAL_CODES("IL_VAL_TAR", PM_IL_GROUP_THRESHOLD_HDR_BEAN.getGTH_VALIDATION_CODE(), "", "N", "E", null);
		}
	}

	/** Field Level Triggers are Handled Here. */

	/** Database Connection */
	private Connection getConnection() throws Exception {
		Connection con = CommonUtils.getConnection();
		return con;
	}

	/** Database Connection */

	/**
	 * Helper Methods For Triggers
	 * 
	 * @throws Exception
	 */
	public void P_VAL_CODES(String var1, String var2, String var3, String var4,
			String var5, String var6) throws Exception {
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();

		Connection con = getConnection();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				var1);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				var2);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN OUT",
				var3);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				var4);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				var5);
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				var6);

		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);
		try {
			List resultList = procHandler
					.execute(paramList, con, "P_VAL_CODES");
			// System.out.println("P_VAL_CODES Result = "+resultList.size());
			Iterator iterator = resultList.iterator();
			while (iterator.hasNext()) {
				OracleParameter object = (OracleParameter) iterator.next();
				if (object.getFieldName().equals("in3")) {
					System.out.println("Value =  " + object.getValue());
					getCOMP_UI_M_GTH_VALIDATION_CODE_DESC().setSubmittedValue(
							object.getValue());
					getPM_IL_GROUP_THRESHOLD_HDR_BEAN().setUI_M_GTH_VALIDATION_CODE_DESC(
							object.getValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
		}
		return;
	}

	/**
	 * CRUD Operations for this block are Handled Here.
	 * 
	 * @throws Exception
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */

	public void GTLHDR_InsertUpdate() {
		CommonUtils.clearMaps(this);
		String rowid = getPM_IL_GROUP_THRESHOLD_HDR_BEAN().getROWID();
		Connection con = null;
		String message = "";
		try {
		if (rowid != null) {
			con = getConnection();
			PRE_UPDATE_HDR();
			int x = handler.executeUpdate(getPM_IL_GROUP_THRESHOLD_HDR_BEAN(), con);
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
		} else if ((rowid == null) || ("".equals(rowid))) {
			// System.out.println("Data is Inserted");
			con = getConnection();
			PRE_INSERT_HDR();
			int y = handler.executeInsert(
			getPM_IL_GROUP_THRESHOLD_HDR_BEAN(), con);
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
		}
		con.commit();
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				message);
		getWarningMap().put("SAVE",
				message);
			} catch (Exception e) {
				getErrorMap().put("current", "Data Cannot Be Inserted.");
				e.printStackTrace();
				getWarningMap().clear();
			}
	}

	/** CRUD Operations for this block are Handled Here. */

	/** BLOCK-LEVEL Triggers are Handled Here. 
	 * @throws ParseException */
	public void PRE_INSERT_HDR() throws Exception {
		  PM_IL_GROUP_THRESHOLD_HDR_BEAN.setGTH_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		  PM_IL_GROUP_THRESHOLD_HDR_BEAN.setGTH_CR_DT(new CommonUtils().getCurrentDate());
	}

	public void PRE_QUERY_HDR() {
		// :PM_IL_GROUP_THRESHOLD_HDR.GTH_TYPE:=:GLOBAL.M_PARA_2;

		return;
	}

	public void PRE_UPDATE_HDR() throws Exception {
		  PM_IL_GROUP_THRESHOLD_HDR_BEAN.setGTH_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		  PM_IL_GROUP_THRESHOLD_HDR_BEAN.setGTH_UPD_DT(new CommonUtils().getCurrentDate());
	}

	public void POST_QUERY_HDR() throws Exception {
		String GTH_VALIDATION_CODE = PM_IL_GROUP_THRESHOLD_HDR_BEAN
				.getGTH_VALIDATION_CODE();
		String M_GTH_VALIDATION_CODE_DESC = PM_IL_GROUP_THRESHOLD_HDR_BEAN
				.getUI_M_GTH_VALIDATION_CODE_DESC();

		if (!"".equals(GTH_VALIDATION_CODE)) {
			P_VAL_CODES("IL_VAL_TAR", GTH_VALIDATION_CODE,
					M_GTH_VALIDATION_CODE_DESC, "N", "N", null);
		}
		return;
	}

	/** BLOCK-LEVEL Triggers are Handled Here. */

	/** FORM-LEVEL Triggers are Handled Here */

	public void onLoadEvents(ActionEvent actionEvent) {
		getButton().setDisabled(true);
		PILM063_APAC_PREFORM();
		PILM063_APAC_WhenNewFormInstance();
		PILM063_APAC_WhenCreateRecord();
	}

	public String PILM063_APAC_PREFORM() {
		System.out.println("PILM063_APAC_PREFORM");
		facesCtx = FacesContext.getCurrentInstance();
		sessionMap = getSessionMap();
		sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
		STD_PRE_FORM();

		String M_TITLE = CommonUtils.getControlBean().getM_USER_ID() + " "
				+ CommonUtils.getControlBean().getM_SCR_NAME() + " " + new Date();

		return "";
	}

	public String PILM063_APAC_WhenNewFormInstance() {
		// NULL;
		System.out.println("PILM063_APAC_WhenNewFormInstance");
		return "";
	}

	public String PILM063_APAC_WhenCreateRecord() {
		System.out.println("PILM063_APAC_WhenCreateRecord");
		return "";
	}

	/** FORM-LEVEL Triggers are Handled Here */

	/** Methods Required for FORM-LEVEL Triggers */
	private void STD_PRE_FORM() {
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1((String) sessionMap.get("GLOBAL.M_PARA_1"));
		ctrlBean.setM_PROG_NAME("PILT005");
		sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
	}

	/** Methods Required for FORM-LEVEL Triggers */

	public void requiredValidation(ActionEvent event) {

		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		try {
			// GTH_GROUP_CODE_WhenValidateItem();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** LOV is Handled Here */
	public List HDRLov(Object obj) {
		ArrayList<GTH_VALIDATION_CODE_LOVBean> list = new ArrayList<GTH_VALIDATION_CODE_LOVBean>();
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String query = null;
		try {
			if(obj.toString().equalsIgnoreCase("*")){
				query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_VAL_TAR' AND NVL(PC_FRZ_FLAG,'N') = 'N' ORDER BY 1 ASC";
			}else{
				query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_VAL_TAR' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE LIKE '"+obj.toString()+"%' ORDER BY 1 ASC";
			}
			rs = handler.executeSelectStatement(query, getConnection());
				if (rs != null) {
					while (rs.next()) {
						GTH_VALIDATION_CODE_LOVBean bean = new GTH_VALIDATION_CODE_LOVBean();
						bean.setPC_CODE(rs.getString(1));
						bean.setPC_DESC(rs.getString(2));
						list.add(bean);
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					CommonUtils.closeCursor(rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovGTH_VALIDATION_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
		    suggestionList = listitemutil.P_CALL_LOV("PILM063_APAC",
			    "PM_IL_GROUP_THRESHOLD_HDR", "GTH_VALIDATION_CODE", "IL_VAL_TAR", null, null, null,
			    null, (String) currValue);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return suggestionList;
	    }
	
	//P_CALL_LOV('PM_IL_GROUP_THRESHOLD_HDR.GTH_VALIDATION_CODE','IL_VAL_TAR');
	
	public String beforePhase(PhaseEvent event){
		try {
			if(PM_IL_GROUP_THRESHOLD_HDR_BEAN.getROWID() != null){
				if(isBlockFlag()){
					executeSelectStatement(PM_IL_GROUP_THRESHOLD_HDR_BEAN.getROWID());
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("BEFORE_PHASE", e.getMessage());
		}
		return "";
	}
	
	public void executeSelectStatement(String rowId) throws Exception{
		String selectQuery = "Select ROWID, PM_IL_GROUP_THRESHOLD_HDR.* from PM_IL_GROUP_THRESHOLD_HDR where ROWID='"+rowId+"'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_GROUP_THRESHOLD_HDR> list = null;
		
		try {
			con = CommonUtils.getConnection();
			list = handler.fetch(selectQuery, 
					"com.iii.pel.forms.PILM063_APAC.PM_IL_GROUP_THRESHOLD_HDR", 
					con);
			setPM_IL_GROUP_THRESHOLD_HDR_BEAN(list.get(0));
			setUpdate(true);
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
	
	/*public void searchedData() throws Exception{
		ResultSet rs = null;
		try {
			searchList.clear();
			String query = "SELECT ROWID,GTH_GROUP_CODE,GTH_GROUP_DESC FROM PM_IL_GROUP_THRESHOLD_HDR WHERE GTH_GROUP_CODE LIKE ? AND GTH_GROUP_DESC LIKE ?";
			System.out.println("Query = "+query);
//			String query = "SELECT ROWID,GTH_GROUP_CODE,GTH_GROUP_DESC,GTH_GROUP_LONG_DESC FROM PM_IL_GROUP_THRESHOLD_HDR WHERE GTH_GROUP_CODE LIKE '"+thresholdLimitSearchBean.getGTH_GROUP_CODE()+"%' AND GTH_GROUP_DESC LIKE '"+thresholdLimitSearchBean.getGTH_GROUP_DESC()+"%' AND GTH_GROUP_LONG_DESC LIKE '"+thresholdLimitSearchBean.getGTH_GROUP_LONG_DESC()+"%'";
			CRUDHandler handler = new CRUDHandler();
			rs = handler.executeSelectStatement(query, getConnection(),
					new Object[]{PM_IL_GROUP_THRESHOLD_HDR_BEAN.getGTH_GROUP_CODE(),
				PM_IL_GROUP_THRESHOLD_HDR_BEAN.getGTH_GROUP_DESC()});
			while(rs.next()){
				PM_IL_GROUP_THRESHOLD_HDR_BEAN.setROWID(rs.getString(1));
				PM_IL_GROUP_THRESHOLD_HDR_BEAN.setGTH_GROUP_CODE(rs.getString(2));
				PM_IL_GROUP_THRESHOLD_HDR_BEAN.setGTH_GROUP_DESC(rs.getString(3));
				searchList.add(PM_IL_GROUP_THRESHOLD_HDR_BEAN);
			}
			
			if(searchList.size() == 0){
				getWarningMap().put("current", "There is no record for this search criteria");
			}else{
				getWarningMap().clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	}*/
	
	
	
	public ArrayList<PM_IL_GROUP_THRESHOLD_HDR> getSearchList() {
		searchList.add(PM_IL_GROUP_THRESHOLD_HDR_BEAN);
		return searchList;
	}
	
	public void setSearchList(
			ArrayList<PM_IL_GROUP_THRESHOLD_HDR> searchList) {
		this.searchList = searchList;
	}
	/** LOV is Handled Here */

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public HtmlCommandButton getButton() {
		return button;
	}

	public void setButton(HtmlCommandButton button) {
		this.button = button;
	}

	public String getFocusOn() {
		return focusOn;
	}

	public void setFocusOn(String focusOn) {
		this.focusOn = focusOn;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public void GTH_GROUP_DESCValidator(FacesContext context,
			UIComponent component, Object value)  {
		CommonUtils.clearMaps(this);
		try {
			getPM_IL_GROUP_THRESHOLD_HDR_BEAN().setGTH_GROUP_DESC((String)value);
			if(getPM_IL_GROUP_THRESHOLD_HDR_BEAN().getGTH_GROUP_DESC()!=null ||
					(!(getPM_IL_GROUP_THRESHOLD_HDR_BEAN().getGTH_GROUP_DESC().isEmpty()))){
			getPM_IL_GROUP_THRESHOLD_HDR_BEAN().setGTH_GROUP_SHORT_DESC(CommonUtils.SUBSTR(getPM_IL_GROUP_THRESHOLD_HDR_BEAN().getGTH_GROUP_DESC(), 1, 30));
			}
			COMP_GTH_GROUP_SHORT_DESC.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {

				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}


}
