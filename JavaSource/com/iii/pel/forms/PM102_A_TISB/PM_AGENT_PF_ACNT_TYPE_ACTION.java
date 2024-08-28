package com.iii.pel.forms.PM102_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_PF_ACNT_TYPE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_APAT_CODE_LABEL;

	private HtmlSelectOneMenu COMP_APAT_CODE;

	private HtmlOutputLabel COMP_APAT_RATE_LABEL;

	private HtmlInputText COMP_APAT_RATE;

	private HtmlOutputLabel COMP_APAT_AGE_LABEL;

	private HtmlInputText COMP_APAT_AGE;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private String filterByAPAT_CODE;

	private String filterByAPAT_RATE;

	private PM_AGENT_PF_ACNT_TYPE PM_AGENT_PF_ACNT_TYPE_BEAN;
	private HtmlCommandButton test;
	private UIDataTable dataTable;
	CRUDHandler handler = new CRUDHandler();
	boolean ExitApatCodeFlag;

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	public PM_AGENT_PF_ACNT_TYPE_ACTION() {
		PM_AGENT_PF_ACNT_TYPE_BEAN = new PM_AGENT_PF_ACNT_TYPE();
		loadListValues();
	}

	private void loadListValues() {
		// TODO Auto-generated method stub
		String query = "SELECT PC_DESC,PC_CODE FROM PM_CODES WHERE PC_TYPE = 'APFACCTTYP' ORDER BY 1";
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(query, CommonUtils
					.getConnection());
			while (rst.next()) {
				APAT_CODE_LIST.add(new SelectItem(rst.getString("PC_CODE"), rst
						.getString("PC_DESC")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

	public HtmlOutputLabel getCOMP_APAT_CODE_LABEL() {
		return COMP_APAT_CODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APAT_CODE() {
		return COMP_APAT_CODE;
	}

	public void setCOMP_APAT_CODE_LABEL(HtmlOutputLabel COMP_APAT_CODE_LABEL) {
		this.COMP_APAT_CODE_LABEL = COMP_APAT_CODE_LABEL;
	}

	public void setCOMP_APAT_CODE(HtmlSelectOneMenu COMP_APAT_CODE) {
		this.COMP_APAT_CODE = COMP_APAT_CODE;
	}

	public HtmlOutputLabel getCOMP_APAT_RATE_LABEL() {
		return COMP_APAT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_APAT_RATE() {
		return COMP_APAT_RATE;
	}

	public void setCOMP_APAT_RATE_LABEL(HtmlOutputLabel COMP_APAT_RATE_LABEL) {
		this.COMP_APAT_RATE_LABEL = COMP_APAT_RATE_LABEL;
	}

	public void setCOMP_APAT_RATE(HtmlInputText COMP_APAT_RATE) {
		this.COMP_APAT_RATE = COMP_APAT_RATE;
	}

	public HtmlOutputLabel getCOMP_APAT_AGE_LABEL() {
		return COMP_APAT_AGE_LABEL;
	}

	public HtmlInputText getCOMP_APAT_AGE() {
		return COMP_APAT_AGE;
	}

	public void setCOMP_APAT_AGE_LABEL(HtmlOutputLabel COMP_APAT_AGE_LABEL) {
		this.COMP_APAT_AGE_LABEL = COMP_APAT_AGE_LABEL;
	}

	public void setCOMP_APAT_AGE(HtmlInputText COMP_APAT_AGE) {
		this.COMP_APAT_AGE = COMP_APAT_AGE;
	}

	public PM_AGENT_PF_ACNT_TYPE getPM_AGENT_PF_ACNT_TYPE_BEAN() {
		return PM_AGENT_PF_ACNT_TYPE_BEAN;
	}

	public void setPM_AGENT_PF_ACNT_TYPE_BEAN(
			PM_AGENT_PF_ACNT_TYPE PM_AGENT_PF_ACNT_TYPE_BEAN) {
		this.PM_AGENT_PF_ACNT_TYPE_BEAN = PM_AGENT_PF_ACNT_TYPE_BEAN;
	}

	List<PM_AGENT_PF_ACNT_TYPE> beanList = new ArrayList<PM_AGENT_PF_ACNT_TYPE>();

	private List<SelectItem> APAT_CODE_LIST = new ArrayList<SelectItem>();

	public List<SelectItem> getAPAT_CODE_LIST() throws Exception {
		return APAT_CODE_LIST;
	}

	public void setAPAT_CODE_LIST(List<SelectItem> apat_code_list) {
		APAT_CODE_LIST = apat_code_list;
	}

	int rowIndex = 0;

	Connection conn;
	Map<String, Object> session = null;
	//ControlBean ctrlBean  = null;
	FacesContext ctx = FacesContext.getCurrentInstance();

	public Connection getConnection() throws Exception {
		FacesContext fc = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext) fc.getExternalContext()
				.getContext();
		SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent) context
				.getAttribute("connectionAgent");
		return connectionAgent.getConnection("System.currentTimeMillis()");
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				preForm(event);
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				executeQuery();
				if (PM_AGENT_PF_ACNT_TYPE_BEAN.getROWID() == null) {
					WHEN_CRAETE_RECORD(PM_AGENT_PF_ACNT_TYPE_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void preForm(PhaseEvent ae) throws Exception {
		ArrayList<OracleParameter> list = null;

		try {

			System.out.println("PM_AGENT_PF_ACNT_TYPE_ACTION.preForm()");

			FacesContext fc = FacesContext.getCurrentInstance();

			session = fc.getExternalContext().getSessionMap();
			session.put("GLOBAL.M_PRIVILEGE", "YYY");
			session.put("GLOBAL.M_FAILURE", "FALSE");
			session.put("GLOBAL.M_USER_ID", "LIFEALL");
			session.put("GLOBAL.M_NAME",
					"COMPANY NAME..................PROGRAM NAME");
			session.put("GLOBAL.M_LANG_CODE", "ENG");
			session.put("GLOBAL.M_DFLT_VALUES", "00101    01");
			session.put("GLOBAL.M_PARA_1", " ");
			session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");

			//	    		values should take from GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME)
			//	    		Developing purpose hard coded it.
			session.put("GLOBAL.M_MODULE_NAME", "PM102_A_TISB");
			System.out.println("PM_AGENT_PF_ACNT_TYPE_ACTION.preForm()\n"
					+ fc.getExternalContext().getSessionMap());

			STD_PRE_FORM();
			if (Integer.parseInt(((String) session
					.get("GLOBAL.M_FOR_LANG_CODE")).substring(4, 5)) == 1) {
				System.out
						.println("PM_AGENT_PF_ACNT_TYPE_ACTION.preForm()NULLLLLLLLLLLLLLLLL");
				//	    			NULL ;
			}
			ControlBean ctrlbean = CommonUtils.getControlBean();
			String M_TITLE = ctrlbean.getM_USER_ID() + " "
					+ ctrlbean.getM_SCR_NAME() + " " + new Date();
			System.out.println("PM_AGENT_PF_ACNT_TYPE_ACTION.preForm()---->> "
					+ M_TITLE);
			//M_TITLE=:CTRL.M_USER_ID+"                 "+:CTRL.M_SCR_NAME+"          "+ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
			// SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
			//	    		gridList();
			//getTest().setDisabled(true);
			//	    		resetAllComponent();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	void STD_PRE_FORM() {

		//		P_GET_LOGO;
		//		COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');

		//createCtrlBean();
		ControlBean ctrlBean = CommonUtils.getControlBean();

		System.out
				.println("PM_AGENT_PF_ACNT_TYPE_ACTION.STD_PRE_FORM()\n---------->\n"
						+ session.toString() + "\n----------");
		//ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		//ctrlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID"));
		//		bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		ctrlBean.setM_PROG_NAME("PM102_A_TISB");
		//		COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("PM_AGENT_PF_ACNT_TYPE_ACTION.STD_PRE_FORM(------)"
				+ (String) session.get("GLOBAL.M_NAME"));
		ctrlBean.setM_SCR_NAME(((String) session.get("GLOBAL.M_NAME"))
				.substring(30, 42));
		//		COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		//ctrlBean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
		//ctrlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		//ctrlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		System.out.println("PT_IL_BROK_ADV_HDR_ACTION.STD_PRE_FORM(!!!! ) "
				+ (String) session.get("GLOBAL.M_DFLT_VALUES"));
		//ctrlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));

		//putCtrlBean(ctrlBean);
		System.out.println("PM_AGENT_PF_ACNT_TYPE_ACTION.STD_PRE_FORM()--- \n "
				+ ctrlBean.getM_LANG_CODE() + "\t" + ctrlBean.getM_COMP_CODE()
				+ "\t" + ctrlBean.getM_PARA_1());

	}

	public void ADDROWS(ActionEvent ae) {
		PM_AGENT_PF_ACNT_TYPE pm_agent_pf_acnt_type = new PM_AGENT_PF_ACNT_TYPE();
		WHEN_CRAETE_RECORD(pm_agent_pf_acnt_type);
		//if(beanList.size()<3){
		beanList.add(pm_agent_pf_acnt_type);
		//}
	}

	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_AGENT_PF_ACNT_TYPE_BEAN = new PM_AGENT_PF_ACNT_TYPE();
				resetAllComponent();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}

	public void DeleteRow(ActionEvent ae) throws Exception {
		System.out.println("PM_AGENT_PF_ACNT_TYPE_ACTION.DeleteRow()");
		PM_AGENT_PF_ACNT_TYPE valuebean = null;
		int DeletedRecordIndex = 0;
		conn = getConnection();
		ArrayList deletedRecordList = new ArrayList();
		if (beanList != null) {
			for (int index = 0; index < beanList.size();) {
				valuebean = beanList.get(index);
				if (valuebean.isCHECK_BOX()) {
					int n = handler.executeDelete(valuebean, conn);
					beanList.remove(valuebean);
					deletedRecordList.add(index);
					conn.commit();
				} else {
					index++;
				}
			}
		}

		if (deletedRecordList.size() > 0) {
			getWarningMap().put(
					"current",
					Messages.getString(PELConstants.pelErrorMessagePath,
							"DELETE_MESSAGE"));
			getWarningMap().put(
					"somekey",
					Messages.getString(PELConstants.pelErrorMessagePath,
							"DELETE_MESSAGE"));
		}
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		int rowIndex = getDataTable().getRowIndex();
		getBeanList().get(rowIndex).setCHECK_BOX(
				Boolean.parseBoolean(getCurrentValue(actionEvent)));
		return "";
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}

	public void gridList() {
		String selectQuery = "select ROWID,PM_AGENT_PF_ACNT_TYPE.* from PM_AGENT_PF_ACNT_TYPE";
		try {
			conn = getConnection();
			beanList = handler.fetch(selectQuery,
					"com.iii.pel.forms.PM102_A_TISB.PM_AGENT_PF_ACNT_TYPE",
					conn);
			for (Iterator iterator = beanList.iterator(); iterator.hasNext();) {
				PM_AGENT_PF_ACNT_TYPE_BEAN = (PM_AGENT_PF_ACNT_TYPE) iterator
						.next();
				PM_AGENT_PF_ACNT_TYPE_BEAN.setRowSelected(false);
			}
			setBeanList(beanList);
			if (beanList.size() > 0) {
				this.setPM_AGENT_PF_ACNT_TYPE_BEAN(beanList.get(0));
				this.getPM_AGENT_PF_ACNT_TYPE_BEAN().setRowSelected(true);
			}

		} catch (Exception er) {
			er.printStackTrace();
		}
	}

	public void executeQuery() throws Exception {
		String selectQuery = "select ROWID,PM_AGENT_PF_ACNT_TYPE.* from PM_AGENT_PF_ACNT_TYPE";
		ResultSet rs = null;
		PM_AGENT_PF_ACNT_TYPE PM_AGENT_PF_ACNT_TYPE_BEAN1 = null;
		try {
			conn = getConnection();
			rs = handler.executeSelectStatement(selectQuery, conn);
			beanList.clear();
			while (rs.next()) {
				PM_AGENT_PF_ACNT_TYPE_BEAN1 = new PM_AGENT_PF_ACNT_TYPE();
				PM_AGENT_PF_ACNT_TYPE_BEAN1.setROWID(rs.getString("ROWID"));
				PM_AGENT_PF_ACNT_TYPE_BEAN1.setAPAT_CODE(rs
						.getString("APAT_CODE"));
				PM_AGENT_PF_ACNT_TYPE_BEAN1.setAPAT_CODE_DESC(rs
						.getString("APAT_CODE"));
				PM_AGENT_PF_ACNT_TYPE_BEAN1.setAPAT_RATE(rs
						.getDouble("APAT_RATE"));
				PM_AGENT_PF_ACNT_TYPE_BEAN1.setAPAT_AGE(rs.getInt("APAT_AGE"));
				PM_AGENT_PF_ACNT_TYPE_BEAN1.setAPAT_CR_DT(rs
						.getDate("APAT_CR_DT"));
				PM_AGENT_PF_ACNT_TYPE_BEAN1.setAPAT_CR_UID(rs
						.getString("APAT_CR_UID"));
				PM_AGENT_PF_ACNT_TYPE_BEAN1.setAPAT_UPD_DT(rs
						.getDate("APAT_UPD_DT"));
				PM_AGENT_PF_ACNT_TYPE_BEAN1.setAPAT_UPD_UID(rs
						.getString("APAT_UPD_UID"));

				getAPAT_CODE_DESC(PM_AGENT_PF_ACNT_TYPE_BEAN1);
				beanList.add(PM_AGENT_PF_ACNT_TYPE_BEAN1);

			}
			for (Iterator iterator = beanList.iterator(); iterator.hasNext();) {
				PM_AGENT_PF_ACNT_TYPE_BEAN = (PM_AGENT_PF_ACNT_TYPE) iterator
						.next();
				PM_AGENT_PF_ACNT_TYPE_BEAN.setRowSelected(false);
			}
			setBeanList(beanList);
			if (beanList.size() > 0) {
				this.setPM_AGENT_PF_ACNT_TYPE_BEAN(beanList.get(0));
				this.getPM_AGENT_PF_ACNT_TYPE_BEAN().setRowSelected(true);
			}
		} catch (Exception er) {
			er.printStackTrace();
			throw er;
		}
	}

	private void getAPAT_CODE_DESC(
			PM_AGENT_PF_ACNT_TYPE pm_agent_pf_acnt_type_bean1) throws Exception {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String query = "SELECT PC_DESC,PC_CODE FROM PM_CODES WHERE PC_TYPE = 'APFACCTTYP' AND PC_CODE=? ";
		ResultSet rst = null;
		try {
			rst = handler
					.executeSelectStatement(query, CommonUtils.getConnection(),
							new Object[] { pm_agent_pf_acnt_type_bean1
									.getAPAT_CODE() });
			while (rst.next()) {
				pm_agent_pf_acnt_type_bean1.setAPAT_CODE_DESC(rst.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public void onFocusing(ActionEvent actionEvent) {
		rowIndex = getDataTable().getRowIndex();
		System.out.println("::::::::[ " + rowIndex + " ]:::::::");
	}

	public void whenSelectMenu(FacesContext fc, UIComponent component,
			Object value) throws Exception {
		try {
			getPM_AGENT_PF_ACNT_TYPE_BEAN().setAPAT_CODE(value.toString());
			getAPAT_CODE_DESC(PM_AGENT_PF_ACNT_TYPE_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public String when_PressSave_Button() {
		Connection connection = null;
		try {
			postCommit();
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());

		}
		return null;
	}

	public void when_PressDelete_Button() {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = getConnection();
			//pf_acnt_type_pre_insert();
			//pf_acnt_type_pre_update();
			//pf_acnt_type_when_create_record();
			System.out.println("ROW INDEX : " + rowIndex);
			System.out.println("BEAN LIST SIZE : " + beanList.size());
			PM_AGENT_PF_ACNT_TYPE_BEAN = beanList.get(rowIndex);
			System.out
					.println("PM_AGENT_PF_ACNT_TYPE_ACTION.when_PressDelete_Button()"
							+ PM_AGENT_PF_ACNT_TYPE_BEAN.getAPAT_CODE());
			handler.executeDelete(PM_AGENT_PF_ACNT_TYPE_BEAN, connection);
			beanList.remove(rowIndex);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apat_rate_when_validate_item(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException {
		if (value != null) {
			Double TEST_APAT_RATE = (Double) value;
			if (TEST_APAT_RATE <= 0) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "80001"));
				//getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "80001"));
			}
			getPM_AGENT_PF_ACNT_TYPE_BEAN().setAPAT_RATE(TEST_APAT_RATE);
		}
	}

	public void apat_age_when_validate_item(FacesContext fc,
			UIComponent component, Object value) throws Exception {
		//int rowIndex = getDataTable().getRowIndex();

		if (value != null) {
			Integer TEST_APAT_AGE = (Integer) value;
			if (TEST_APAT_AGE <= 0) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "80001"));
				//getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "80001"));
			} else if (TEST_APAT_AGE >= 100) {
				throw new ValidatorException(new FacesMessage(
						"Minimum age of withdrawal should be less than 100"));
			}
			getPM_AGENT_PF_ACNT_TYPE_BEAN().setAPAT_AGE(TEST_APAT_AGE);
		}

	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		try {
			if ("APAT_AGE".equalsIgnoreCase(input.getId())) {
				// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
				//lastColumnListener();
				// [ Commented for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}

	public void lastColumnListener() throws Exception {

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_AGENT_PF_ACNT_TYPE pm_agent_pf_acnt_type = null;
		try {

			// Get the bean based on row index
			pm_agent_pf_acnt_type = (PM_AGENT_PF_ACNT_TYPE) getBeanList().get(
					currRowIndex);

			// Update the record to database
			if (pm_agent_pf_acnt_type.getROWID() != null) {
				PRE_UPDATE(pm_agent_pf_acnt_type);
				rowUpdated = new PM_AGENT_PF_ACNT_TYPE_DELEGATE()
						.updateData(pm_agent_pf_acnt_type);
				if (rowUpdated > 0) {
					getWarningMap().put("current",
							"Record Updated Successfully");
				}
			} else {
				PRE_INSERT(pm_agent_pf_acnt_type);
				System.out.println("values::::::::::::"
						+ pm_agent_pf_acnt_type.getAPAT_CODE() + "  "
						+ pm_agent_pf_acnt_type.getAPAT_AGE());
				rowUpdated = new PM_AGENT_PF_ACNT_TYPE_DELEGATE()
						.updateData(pm_agent_pf_acnt_type);
				if (rowUpdated > 0) {
					getWarningMap().put("current",
							"Record Inserted Successfully");
				}
			}

			//lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {

			throw e1;
		}
		return;
	}

	public void pf_acnt_type_pre_insert(
			PM_AGENT_PF_ACNT_TYPE PM_AGENT_PF_ACNT_TYPE_BEAN) throws Exception {
		String sql_C1 = "SELECT ROWID FROM  PM_AGENT_PF_ACNT_TYPE  WHERE  APAT_CODE  = ?";
		ResultSet vembu_C1 = null;
		String TEMP = null;
		conn = CommonUtils.getConnection();
		try {
			vembu_C1 = handler.executeSelectStatement(sql_C1, conn,
					new Object[] { PM_AGENT_PF_ACNT_TYPE_BEAN.getAPAT_CODE() });
			if (vembu_C1.next()) {
				TEMP = vembu_C1.getString(1);
				if (CommonUtils.isDuplicate(PM_AGENT_PF_ACNT_TYPE_BEAN
						.getROWID(), TEMP))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "60018_1"));
			}
			PM_AGENT_PF_ACNT_TYPE_BEAN.setAPAT_CR_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PM_AGENT_PF_ACNT_TYPE_BEAN.setAPAT_CR_DT(new CommonUtils()
					.getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void pf_acnt_type_pre_update(
			PM_AGENT_PF_ACNT_TYPE PM_AGENT_PF_ACNT_TYPE_BEAN) throws Exception {
		String sql_C1 = "SELECT 'X' FROM PM_AGENT_PF_ACNT_TYPE WHERE APAT_CODE=?"
				+ " AND   ROWID <>?";
		ResultSet vembu_C1 = null;
		String TEMP = null;
		conn = CommonUtils.getConnection();
		try {
			vembu_C1 = handler.executeSelectStatement(sql_C1, conn,
					new Object[] { PM_AGENT_PF_ACNT_TYPE_BEAN.getAPAT_CODE(),
							PM_AGENT_PF_ACNT_TYPE_BEAN.getROWID() });
			if (vembu_C1.next()) {
				TEMP = vembu_C1.getString(1);
				if (CommonUtils.isDuplicate(PM_AGENT_PF_ACNT_TYPE_BEAN
						.getROWID(), TEMP))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "60018_1"));
			}
			PM_AGENT_PF_ACNT_TYPE_BEAN.setAPAT_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PM_AGENT_PF_ACNT_TYPE_BEAN.setAPAT_UPD_DT(new CommonUtils()
					.getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void pf_acnt_type_when_create_record() throws Exception {
		try {
			PM_AGENT_PF_ACNT_TYPE_BEAN.setAPAT_CODE("ACC001");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void post_database_commit() throws Exception {

		try {

			session.put("GLOBAL.M_FAILURE", "FALSE");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void postCommit() throws Exception {
		try {
			double sum = 0;
			double value = 0;
			for (int index = 0; index < getBeanList().size(); index++) {
				value = getBeanList().get(index).getAPAT_RATE();
				sum = sum + value;
			}
			if (sum > 100) {
				getWarningMap().put("current",
						"Total Of Split Should be Equal To or Less Than 100 ");
				throw new ValidatorException(new FacesMessage(
						"Total Of Split Should be Equal To or Less Than 100"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void post_forms_commit() throws Exception {
		conn = getConnection();
		try {
			String sql_C1 = "SELECT SUM(NVL(APAT_RATE, 0)) FROM  PM_AGENT_PF_ACNT_TYPE  ";
			ResultSet vembu_C1 = null;
			Statement stmt_C1 = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			double M_NUM = -1;

			vembu_C1 = stmt_C1.executeQuery(sql_C1);
			if (vembu_C1.next()) {
				M_NUM = vembu_C1.getDouble(1);
			}
			if (M_NUM > 100) {
				throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "3206", new Object[] {
					  "Total Of Split Should be Equal To or Less Than 100" }));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void getDetails() {
		CommonUtils.clearMaps(this);
		try {
			if (beanList.size() != 0) {
				PM_AGENT_PF_ACNT_TYPE_BEAN = (PM_AGENT_PF_ACNT_TYPE) dataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PM_AGENT_PF_ACNT_TYPE_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void post(ActionEvent ae) {
		try {
			if (PM_AGENT_PF_ACNT_TYPE_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					pf_acnt_type_pre_update(PM_AGENT_PF_ACNT_TYPE_BEAN);
					new CRUDHandler().executeInsert(PM_AGENT_PF_ACNT_TYPE_BEAN,
							CommonUtils.getConnection());
					postCommit();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put("post",	Messages.getString(
							PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",	Messages.getString(
							PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {
				if (isINSERT_ALLOWED()) {
					pf_acnt_type_pre_insert(PM_AGENT_PF_ACNT_TYPE_BEAN);
					new CRUDHandler().executeInsert(PM_AGENT_PF_ACNT_TYPE_BEAN,
							CommonUtils.getConnection());
					postCommit();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put("post",	Messages.getString(
							PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					beanList.add(PM_AGENT_PF_ACNT_TYPE_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",	Messages.getString(
							PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetSelectedRow();
			PM_AGENT_PF_ACNT_TYPE_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_APAT_CODE.resetValue();
		COMP_APAT_RATE.resetValue();
		COMP_APAT_AGE.resetValue();

	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_AGENT_PF_ACNT_TYPE> iterator = beanList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public List<PM_AGENT_PF_ACNT_TYPE> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<PM_AGENT_PF_ACNT_TYPE> beanList) {
		this.beanList = beanList;
	}

	public void WHEN_CRAETE_RECORD(PM_AGENT_PF_ACNT_TYPE pm_agent_pf_acnt_type) {
		pm_agent_pf_acnt_type.setAPAT_CODE("ACC001");
	}

	public void PRE_INSERT(PM_AGENT_PF_ACNT_TYPE pm_agent_pf_acnt_type)
			throws ValidatorException, ParseException {
		String TEMPID = new PM_AGENT_PF_ACNT_TYPE_DELEGATE()
				.duplicateCheck(pm_agent_pf_acnt_type);
		if (new CommonUtils().isDuplicate(pm_agent_pf_acnt_type.getROWID(),
				TEMPID)) {
			throw new ValidatorException(Messages.getMessage(
					PELConstants.pelErrorMessagePath, "60018_1"));
		}
		/*double sum = 0;
		double value = 0;
		for(int index = 0; index<getBeanList().size(); index++)
		{
			value = getBeanList().get(index).getAPAT_RATE();
			sum = sum+value;
		}
		if(sum!=100)
		{
			throw new ValidatorException(new FacesMessage("Sum total of Fund Account Types should be 100%"));
		}*/

		pm_agent_pf_acnt_type.setAPAT_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		pm_agent_pf_acnt_type.setAPAT_CR_DT(new CommonUtils().getCurrentDate());
	}

	public void PRE_UPDATE(PM_AGENT_PF_ACNT_TYPE pm_agent_pf_acnt_type)
			throws ParseException {
		pm_agent_pf_acnt_type.setAPAT_UPD_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		pm_agent_pf_acnt_type
				.setAPAT_UPD_DT(new CommonUtils().getCurrentDate());
	}

	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {

		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				lastColumnListener();
			} else {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					exc.getMessage());
		}
		return outcome;
	}

	// [ Added for grid implementation change, Added by: Amit Kumar, Dated: 16-Feb-2009

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

	public String getFilterByAPAT_CODE() {
		return filterByAPAT_CODE;
	}

	public void setFilterByAPAT_CODE(String filterByAPAT_CODE) {
		this.filterByAPAT_CODE = filterByAPAT_CODE;
	}

	public String getFilterByAPAT_RATE() {
		return filterByAPAT_RATE;
	}

	public void setFilterByAPAT_RATE(String filterByAPAT_RATE) {
		this.filterByAPAT_RATE = filterByAPAT_RATE;
	}

	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PM_AGENT_PF_ACNT_TYPE_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_AGENT_PF_ACNT_TYPE_BEAN,
							CommonUtils.getConnection());
					beanList.remove(PM_AGENT_PF_ACNT_TYPE_BEAN);
				}

				if (beanList.size() > 0) {
					setPM_AGENT_PF_ACNT_TYPE_BEAN(beanList.get(0));
					PM_AGENT_PF_ACNT_TYPE_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$delete"));
				getWarningMap().put("deleteRow", Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put("deleteRow", Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}
}