package com.iii.pel.forms.PM103_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_DELEGATE;
import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_PF_INT_SETUP_ACTION extends CommonAction {

	private HtmlInputText COMP_APIS_RATE;
	private HtmlOutputLabel COMP_APIS_RATE_LABEL;
	private HtmlInputText COMP_APIS_RATE_PER;
	private HtmlOutputLabel COMP_APIS_RATE_PER_LABEL;
	private HtmlCalendar COMP_APIS_EFF_FM_DT;
	private HtmlOutputLabel COMP_APIS_EFF_FM_DT_LABEL;
	private HtmlCalendar COMP_APIS_EFF_TO_DT;
	private HtmlOutputLabel COMP_APIS_EFF_TO_DT_LABEL;

	public HtmlInputText getCOMP_APIS_RATE() {
		return COMP_APIS_RATE;
	}

	public void setCOMP_APIS_RATE(HtmlInputText comp_apis_rate) {
		COMP_APIS_RATE = comp_apis_rate;
	}

	public HtmlInputText getCOMP_APIS_RATE_PER() {
		return COMP_APIS_RATE_PER;
	}

	public void setCOMP_APIS_RATE_PER(HtmlInputText comp_apis_rate_per) {
		COMP_APIS_RATE_PER = comp_apis_rate_per;
	}

	public HtmlCalendar getCOMP_APIS_EFF_FM_DT() {
		return COMP_APIS_EFF_FM_DT;
	}

	public void setCOMP_APIS_EFF_FM_DT(HtmlCalendar comp_apis_eff_fm_dt) {
		COMP_APIS_EFF_FM_DT = comp_apis_eff_fm_dt;
	}

	public HtmlCalendar getCOMP_APIS_EFF_TO_DT() {
		return COMP_APIS_EFF_TO_DT;
	}

	public void setCOMP_APIS_EFF_TO_DT(HtmlCalendar comp_apis_eff_to_dt) {
		COMP_APIS_EFF_TO_DT = comp_apis_eff_to_dt;
	}

	private PM_AGENT_PF_INT_SETUP PM_AGENT_PF_INT_SETUP_BEAN;

	private HtmlCommandButton test;
	private UIDataTable dataTable;
	CRUDHandler handler = new CRUDHandler();
	private String errorMessages;
	private Map<String, String> errorMap = new HashMap<String, String>();

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

	public PM_AGENT_PF_INT_SETUP_ACTION() {
		prevRowIndex = 0;
		PM_AGENT_PF_INT_SETUP_BEAN = new PM_AGENT_PF_INT_SETUP();
		setBlockFlag(true);
	}

	public PM_AGENT_PF_INT_SETUP getPM_AGENT_PF_INT_SETUP_BEAN() {
		return PM_AGENT_PF_INT_SETUP_BEAN;
	}

	public void setPM_AGENT_PF_INT_SETUP_BEAN(
			PM_AGENT_PF_INT_SETUP PM_AGENT_PF_INT_SETUP_BEAN) {
		this.PM_AGENT_PF_INT_SETUP_BEAN = PM_AGENT_PF_INT_SETUP_BEAN;
	}

	List<PM_AGENT_PF_INT_SETUP> beanList = new ArrayList<PM_AGENT_PF_INT_SETUP>();

	private int prevRowIndex;
	int lastUpdatedRowIndex = 0;
	int rowIndex = 0;

	Connection conn;
	Map<String, Object> session = null;
	// ControlBean ctrlBean = null;
	FacesContext ctx = FacesContext.getCurrentInstance();

	/*
	 * public void createCtrlBean(){ ControlBean bean = new ControlBean();
	 * FacesContext faces = FacesContext.getCurrentInstance(); session =
	 * faces.getExternalContext().getSessionMap(); session.put("ctrlbean",
	 * bean); }
	 * 
	 * public void putCtrlBean(ControlBean bean){ FacesContext faces1 =
	 * FacesContext.getCurrentInstance(); session =
	 * faces1.getExternalContext().getSessionMap(); session.put("ctrlbean",
	 * bean); }
	 * 
	 * 
	 * public ControlBean getCtrlBean(){ FacesContext faces2 =
	 * FacesContext.getCurrentInstance(); session =
	 * faces2.getExternalContext().getSessionMap(); return (ControlBean)
	 * session.get("ctrlbean"); }
	 */
	public Connection getConnection() throws Exception {
		Connection connection = CommonUtils.getConnection();
		return connection;
		/*
		 * FacesContext fc = FacesContext.getCurrentInstance(); ServletContext
		 * context = (ServletContext)fc.getExternalContext().getContext();
		 * SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent)
		 * context.getAttribute("connectionAgent"); return
		 * connectionAgent.getConnection("System.currentTimeMillis()");
		 */
	}

	public void preForm(PhaseEvent ae) throws Exception {
		ArrayList<OracleParameter> list = null;

		try {
			
			if(isBlockFlag()){
			System.out.println("PM_AGENT_PF_INT_SETUP_ACTION.preForm()");
			FacesContext fc = FacesContext.getCurrentInstance();
			session = fc.getExternalContext().getSessionMap();
			// [ Removed Hard coded user id: added by: Shankar bodduluri Dated:
			// 19-Mar-2009 ]
			/*
			 * session.put("GLOBAL.M_PRIVILEGE", "YYY");
			 * session.put("GLOBAL.M_FAILURE", "FALSE");
			 * session.put("GLOBAL.M_USER_ID", "LIFEALL");
			 * session.put("GLOBAL.M_NAME", "COMPANY
			 * NAME..................PROGRAM NAME");
			 * session.put("GLOBAL.M_LANG_CODE", "ENG");
			 * session.put("GLOBAL.M_DFLT_VALUES", "00101 01");
			 * session.put("GLOBAL.M_PARA_1", " ");
			 * session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
			 */

			// values should take from
			// GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME)
			// Developing purpose hard coded it.
			session.put("GLOBAL.M_MODULE_NAME", "PILT018");
			System.out.println("PM_AGENT_PF_INT_SETUP_ACTION.preForm()\n"
					+ fc.getExternalContext().getSessionMap());

			STD_PRE_FORM();
			/*if (Integer.parseInt(((String) session
					.get("GLOBAL.M_FOR_LANG_CODE")).substring(4, 5)) == 1) {
				System.out
						.println("PM_AGENT_PF_INT_SETUP_ACTION.preForm()NULLLLLLLLLLLLLLLLL");
				// NULL ;
			}*/
			ControlBean ctrlbean = CommonUtils.getControlBean();
			String M_TITLE = ctrlbean.getM_USER_ID() + " "
					+ ctrlbean.getM_SCR_NAME() + " " + new Date();
			System.out.println("PM_AGENT_PF_INT_SETUP_ACTION.preForm()---->> "
					+ M_TITLE);
			// M_TITLE=:CTRL.M_USER_ID+" "+:CTRL.M_SCR_NAME+"
			// "+ConvertFunctions.to_char(new
			// java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
			// SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
			gridList();
			if(this.getPM_AGENT_PF_INT_SETUP_BEAN().getROWID()==null){
				when_create_record();
			}
			getTest().setDisabled(true);
			setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	void STD_PRE_FORM() {

		// P_GET_LOGO;
		// COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');

		// createCtrlBean();
		ControlBean ctrlBean = CommonUtils.getControlBean();

		System.out
				.println("PM_AGENT_PF_INT_SETUP_ACTION.STD_PRE_FORM()\n---------->\n"
						+ session.toString() + "\n----------");
		// ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		// ctrlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID"));
		// bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		ctrlBean.setM_PROG_NAME("PM103_A_TISB");
		// COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30),
		// 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("PM_AGENT_PF_INT_SETUP_ACTION.STD_PRE_FORM(------)"
				+ (String) session.get("GLOBAL.M_NAME"));
		if(session.get("GLOBAL.M_NAME")!=null)
		ctrlBean.setM_SCR_NAME(((String) session.get("GLOBAL.M_NAME"))
				.substring(30, 42));
		// COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		// ctrlBean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
		// ctrlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		// ctrlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		System.out.println("PT_IL_BROK_ADV_HDR_ACTION.STD_PRE_FORM(!!!! ) "
				+ (String) session.get("GLOBAL.M_DFLT_VALUES"));
		// ctrlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));

		// putCtrlBean(ctrlBean);
		System.out.println("PM_AGENT_PF_INT_SETUP_ACTION.STD_PRE_FORM()--- \n "
				+ ctrlBean.getM_LANG_CODE() + "\t" + ctrlBean.getM_COMP_CODE()
				+ "\t" + ctrlBean.getM_PARA_1());

	}

	public void ADDROWS(ActionEvent ae) {
		// if(beanList.size()<3){
		beanList.add(new PM_AGENT_PF_INT_SETUP());
		// }
	}

	public void DeleteRow(ActionEvent ae) throws Exception {
		System.out.println("PM_AGENT_PF_INT_SETUP_ACTION.DeleteRow()");
		PM_AGENT_PF_INT_SETUP valuebean = null;
		int DeletedRecordIndex = 0;
		conn = getConnection();
		System.out.println(beanList.size());
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

	public void checkBoxStatus(ActionEvent event) {

		int rowIndex = getDataTable().getRowIndex();
		getBeanList().get(rowIndex).setCHECK_BOX(
				Boolean.parseBoolean(getCurrentValue(event)));
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

		String selectQuery = "select ROWID,PM_AGENT_PF_INT_SETUP.* from PM_AGENT_PF_INT_SETUP";
		try {
			conn = getConnection();

			beanList = handler.fetch(selectQuery,
					"com.iii.pel.forms.PM103_A_TISB.PM_AGENT_PF_INT_SETUP",
					conn);
			for (Iterator iterator = beanList.iterator(); iterator.hasNext();) {
				PM_AGENT_PF_INT_SETUP_BEAN = (PM_AGENT_PF_INT_SETUP) iterator
						.next();
				PM_AGENT_PF_INT_SETUP_BEAN.setRowSelected(false);
			}
			
			this.setBeanList(beanList);
			if (beanList.size() !=0){					
				this.setPM_AGENT_PF_INT_SETUP_BEAN(beanList.get(0));
				this.getPM_AGENT_PF_INT_SETUP_BEAN().setRowSelected(true);
			}
		} catch (Exception er) {
			er.printStackTrace();
		}
	}

	public void onFocusing(ActionEvent actionEvent) {
		rowIndex = getDataTable().getRowIndex();
		System.out.println("::::::::[ " + rowIndex + " ]:::::::");
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		if ("APIS_EFF_TO_DT".equalsIgnoreCase(input.getId())) {
			try {
				// lastColumnListener(); commented Due to Grid Changes
			} catch (Exception e) {
				System.out.println("catch block...........");
				e.printStackTrace();
				getErrorMap().put("current", e.getMessage());
			}
		}
	}

	public String when_PressSave_Button() {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = getConnection();

			/*
			 * System.out.println("ROW INDEX : "+rowIndex);
			 * System.out.println("BEAN LIST SIZE : "+beanList.size());
			 * PM_AGENT_PF_INT_SETUP_BEAN = beanList.get(rowIndex);
			 * pre_insert(); // PM_AGENT_PF_INT_SETUP_BEAN.setAPIS_CR_DT(new
			 * java.sql.Date(Calendar.getInstance().getTimeInMillis())); //
			 * PM_AGENT_PF_INT_SETUP_BEAN.setAPIS_CR_UID("LIFEALL"); System.out
			 * .println("COMP_APIS_RATE>>>"+PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_RATE());
			 * System.out
			 * .println("COMP_APIS_RATE_PER>>>"+PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_RATE_PER());
			 * handler.executeInsert(PM_AGENT_PF_INT_SETUP_BEAN, connection);
			 * if(PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_RATE_PER() <=0 ||
			 * PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_RATE()<=0){ conn.rollback();
			 * gridList(); }else {
			 */
			conn.commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
			getWarningMap().put("SAVE",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			 }catch (Exception e) {
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
			// pf_acnt_type_pre_insert();
			// pf_acnt_type_pre_update();
			// pf_acnt_type_when_create_record();
			System.out.println("ROW INDEX : " + rowIndex);
			System.out.println("BEAN LIST SIZE : " + beanList.size());
			PM_AGENT_PF_INT_SETUP_BEAN = beanList.get(rowIndex);
			System.out
					.println("PM_AGENT_PF_INT_SETUP_ACTION.when_PressDelete_Button()"
							+ PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_RATE());
			handler.executeDelete(PM_AGENT_PF_INT_SETUP_BEAN, connection);
			beanList.remove(rowIndex);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apis_eff_fm_dt_when_validate_item() {

		Date fm_date = null;
		Date to_date = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat(getCOMP_APIS_EFF_FM_DT()
					.getDatePattern());
			fm_date = df.parse((String) getCOMP_APIS_EFF_FM_DT()
					.getSubmittedValue());
			System.out
					.println("PM_AGENT_PF_INT_SETUP_ACTION.COMP_APIS_EFF_FM_DT....>>>"
							+ fm_date);
			to_date = df.parse((String) getCOMP_APIS_EFF_TO_DT()
					.getSubmittedValue());
			System.out
					.println("PM_AGENT_PF_INT_SETUP_ACTION.COMP_APIS_EFF_TO_DT....>>>"
							+ to_date);

			if (fm_date.before(to_date)) {

				System.out
						.println("PM_AGENT_PF_INT_SETUP_ACTION.COMP_APIS_EFF_TO_DT....>>>when_validate_item()======= --LESS THAN OR EQUAL TO SYSTEM DATE");
				// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71145,:CTRL.M_LANG_CODE);
				// throw new FORM_TRIGGER_FAILURE();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void apis_eff_to_dt_when_validate_item() throws Exception {

		Date fm_date = null;
		Date to_date = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat(getCOMP_APIS_EFF_FM_DT()
					.getDatePattern());
			fm_date = df.parse((String) getCOMP_APIS_EFF_FM_DT()
					.getSubmittedValue());
			System.out
					.println("PM_AGENT_PF_INT_SETUP_ACTION.COMP_APIS_EFF_FM_DT....>>>"
							+ fm_date);
			to_date = df.parse((String) getCOMP_APIS_EFF_TO_DT()
					.getSubmittedValue());
			System.out
					.println("PM_AGENT_PF_INT_SETUP_ACTION.COMP_APIS_EFF_TO_DT....>>>"
							+ to_date);

			if (to_date.before(fm_date)) {

				System.out
						.println("PM_AGENT_PF_INT_SETUP_ACTION.COMP_APIS_EFF_TO_DT....>>>when_validate_item()======= --LESS THAN OR EQUAL TO SYSTEM DATE");
				// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(21602,:CTRL.M_LANG_CODE);
				// throw new FORM_TRIGGER_FAILURE();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void apis_rate_per_when_validate_item(PM_AGENT_PF_INT_SETUP PM_AGENT_PF_INT_SETUP_BEAN) throws Exception{
		try {
			if(PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_RATE_PER() <= 0)
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80001D"));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}

	}

	public void apis_rate_when_validate_item(PM_AGENT_PF_INT_SETUP PM_AGENT_PF_INT_SETUP_BEAN) throws Exception{
		try {
			 if(PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_RATE() <= 0 ||
					 PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_RATE() >100)
					 
				 throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80001"));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}

	}

	public void pre_insert(PM_AGENT_PF_INT_SETUP pm_agent_pf_int_setup)
			throws Exception {
		conn = getConnection();
		String TEMPROWID = new PM_AGENT_PF_INT_SETUP_DELEGATE()
				.duplicateCheck(pm_agent_pf_int_setup);
		if (new CommonUtils().isDuplicate(pm_agent_pf_int_setup.getROWID(),
				TEMPROWID)) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "60018"));
		}

		PM_AGENT_PF_INT_SETUP_BEAN.setAPIS_CR_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		PM_AGENT_PF_INT_SETUP_BEAN.setAPIS_CR_DT(new CommonUtils()
				.getCurrentDate());

	}

	public void pre_update(PM_AGENT_PF_INT_SETUP PM_AGENT_PF_INT_SETUP_BEAN)throws Exception{
		String M_DUMMY_X =null;
		String C1 ="SELECT 'X' FROM PM_AGENT_PF_INT_SETUP " +
				"WHERE((APIS_EFF_FM_DT BETWEEN ? AND ?) " +
				"OR (APIS_EFF_TO_DT BETWEEN ? AND ?)) " +
				"AND ROWID <>?";
		
		Connection con = null;
		ResultSet rs = null;
						
		try{
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con, new Object[]{CommonUtils.dateToStringFormatter(PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_EFF_FM_DT()),
																	  CommonUtils.dateToStringFormatter(PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_EFF_TO_DT()),
																	  CommonUtils.dateToStringFormatter(PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_EFF_FM_DT()),
																	  CommonUtils.dateToStringFormatter(PM_AGENT_PF_INT_SETUP_BEAN.getAPIS_EFF_TO_DT()),
																	  PM_AGENT_PF_INT_SETUP_BEAN.getROWID()});

			while(rs.next()){
				M_DUMMY_X = rs.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60018"));
			}
						
			PM_AGENT_PF_INT_SETUP_BEAN.setAPIS_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PM_AGENT_PF_INT_SETUP_BEAN.setAPIS_UPD_DT(new CommonUtils()
					.getCurrentDate());
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		}
	public void pre_update() throws Exception {
		conn = getConnection();
		try {

			String sql_C1 = "SELECT 'X' FROM  PM_AGENT_PF_INT_SETUP  WHERE  ((APIS_EFF_FM_DT  BETWEEN"
					+ (Date) getCOMP_APIS_EFF_FM_DT().getValue()
					+ "  AND  "
					+ (Date) getCOMP_APIS_EFF_TO_DT().getValue()
					+ ")  OR  (APIS_EFF_TO_DT  BETWEEN"
					+ (Date) getCOMP_APIS_EFF_FM_DT().getValue()
					+ "  AND  "
					+ (Date) getCOMP_APIS_EFF_TO_DT().getValue()
					+ "))  AND ROWID  <> "
					+ PM_AGENT_PF_INT_SETUP_BEAN.getROWID();
			ResultSet vembu_C1 = null;
			Statement stmt_C1 = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String M_DUMMY_X = null;
			if (vembu_C1 != null) {
				vembu_C1.close();
			}
			vembu_C1 = stmt_C1.executeQuery(sql_C1);
			if (vembu_C1.next()) {
				M_DUMMY_X = vembu_C1.getString(1);
			}
			if (!vembu_C1.isLast()) {
				System.out
						.println("PM_AGENT_PF_INT_SETUP_ACTION.pre_update() ERROR CODE=60018");
				// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(60018,:CTRL.M_LANG_CODE);
				// throw new FORM_TRIGGER_FAILURE();
			}
			vembu_C1.close();

			PM_AGENT_PF_INT_SETUP_BEAN.setAPIS_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PM_AGENT_PF_INT_SETUP_BEAN.setAPIS_UPD_DT(new CommonUtils()
					.getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void when_create_record() throws Exception {

		try {

			PM_AGENT_PF_INT_SETUP_BEAN.setAPIS_EFF_FM_DT(new CommonUtils()
					.getCurrentDate());
			PM_AGENT_PF_INT_SETUP_BEAN.setAPIS_EFF_TO_DT(new CommonUtils()
					.getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private void rowChangeListener(ActionEvent event) {
		System.out.println("PM_AGENT_PF_INT_SETUP_ACTION.rowChangeListener()");

		int currRowIndex = rowIndex;
		int rowUpdated = 0;
		PM_AGENT_PF_INT_SETUP gridValueBean = null;
		System.out.println(lastUpdatedRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PM_AGENT_PF_INT_SETUP) beanList
								.get(prevRowIndex);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {
							System.out
									.println("PT_IL_LOAN_CHARGE_ACTION.rowChangeListener-----rowID1"
											+ gridValueBean.getROWID());
							rowUpdated = updateData(gridValueBean);
						} else {

							// gridValueBean.setRSA_PLAN_CODE("dee");
							// Setting Bean Values here//

							System.out
									.println("PT_IL_LOAN_CHARGE_ACTION.rowChangeListener-----rowID2"
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

	private int updateData(PM_AGENT_PF_INT_SETUP gridValueBean)
			throws Exception {
		/*
		 * if(currentMode.equalsIgnoreCase("INSERT")){ preInsert(); }
		 */

		{
			Connection connection = null;
			CRUDHandler dbHandler = new CRUDHandler();
			int rowUpdated = 0;

			try {
				connection = getConnection();
				// dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
				rowUpdated = dbHandler.executeInsert(gridValueBean, connection);
				connection.commit();
			} catch (Exception exc) {
				throw exc;
			}
			return rowUpdated;
		}
	}

	public void lastColumnListener() throws Exception {
		int currRowIndex = rowIndex;
		int rowUpdated = 0;
		PM_AGENT_PF_INT_SETUP gridValueBean = null;
		int rowIndex = getDataTable().getRowIndex();

		try {

			// Get the bean based on row index
			gridValueBean = (PM_AGENT_PF_INT_SETUP) beanList.get(rowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				pre_insert(gridValueBean);
				rowUpdated = updateData(gridValueBean);

			} else {
				// Setting Values//
				pre_insert(gridValueBean);
				rowUpdated = updateData(gridValueBean);

			}
			if (rowUpdated > 0) {
				if (gridValueBean.getROWID() == null) {
					getWarningMap().put("current",
							"Record Inserted Successfully");
				} else {
					getWarningMap().put("current",
							"Record Updated Successfully");
				}
			}

			lastUpdatedRowIndex = currRowIndex;

		} catch (Exception e1) {
			System.out.println("catch 1111111111111111111111");
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
			throw e1;
		}

		return;

	}

	public List<PM_AGENT_PF_INT_SETUP> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<PM_AGENT_PF_INT_SETUP> beanList) {
		this.beanList = beanList;
	}

	public void negativeValueChecking(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		if (input.getSubmittedValue() != null) {
			if (isNegativevalue(input.getSubmittedValue().toString())) {
				// Commented to avoid compilation error, Dated: 15-Feb, Commented by: Manoj
				/*getErrorMap().put("current",
						PM_IL_PLAN_ACTION_CONSTANTS.PM_IL_PLAN_NEGATIVE_VALUE);
				getErrorMap().put("some",
						PM_IL_PLAN_ACTION_CONSTANTS.PM_IL_PLAN_NEGATIVE_VALUE);*/

				// throw new ValidatorException(new
				// FacesMessage(PM_IL_PLAN_ACTION_CONSTANTS.PM_IL_PLAN_NEGATIVE_VALUE));
			} else {
				getErrorMap().clear();
			}
		}
	}

	public boolean isNegativevalue(String value) {
		boolean flag = false;
		try {
			value = value.trim();
			System.out.println("VALUE:::::::::::" + value.substring(0, 1));
			if (value.substring(0, 1).equals("-")) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public void validateAPIS_RATE(FacesContext fc, UIComponent component,
			Object value) {
		try{
		getPM_AGENT_PF_INT_SETUP_BEAN().setAPIS_RATE((Double)value);
		apis_rate_when_validate_item(PM_AGENT_PF_INT_SETUP_BEAN);
		}catch (Exception e) {
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

	public void validateAPIS_RATE_PER(FacesContext fc, UIComponent component,
			Object value) {
		try{
			getPM_AGENT_PF_INT_SETUP_BEAN().setAPIS_RATE_PER((Double)value);
			apis_rate_per_when_validate_item(PM_AGENT_PF_INT_SETUP_BEAN);
			}catch (Exception e) {
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

	public void validateAPIS_EFF_FM_DT(FacesContext fc, UIComponent component,
			Object value) throws Exception {
		CommonUtils.clearMaps(this);
		getPM_AGENT_PF_INT_SETUP_BEAN().setAPIS_EFF_FM_DT((Date)value);
		try{
		if (value != null) {
			Date fm_date = (Date) value;
			if (getPM_AGENT_PF_INT_SETUP_BEAN().getAPIS_EFF_TO_DT() != null) {
				if (fm_date.after(getPM_AGENT_PF_INT_SETUP_BEAN()
						.getAPIS_EFF_TO_DT()))
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "71145"));
			}
		}
		}catch (Exception e) {
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


	public void validateAPIS_EFF_TO_DT(FacesContext fc, UIComponent component,
			Object value) throws Exception {
		CommonUtils.clearMaps(this);
		getPM_AGENT_PF_INT_SETUP_BEAN().setAPIS_EFF_TO_DT((Date)value);
		try{
		if (value != null) {
			Date to_date = (Date) value;
			if (getPM_AGENT_PF_INT_SETUP_BEAN().getAPIS_EFF_FM_DT() != null) {
				if (to_date.before(getPM_AGENT_PF_INT_SETUP_BEAN()
						.getAPIS_EFF_FM_DT()))
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "71145"));
			}
		}
		
		}catch (Exception e) {
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

	// [ Added for grid implementation change, Added by: Rajesh Kundala,
	// Dated: 17-Feb-2009
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
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}

		return outcome;
	}

	// Added for grid implementation change, Added by: Rajesh Kundala, Dated:
	// 17-Feb-2009 ]

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			if (beanList.size() != 0) {
				PM_AGENT_PF_INT_SETUP_BEAN = (PM_AGENT_PF_INT_SETUP) dataTable
						.getRowData();
			}
			resetAllComponent();
			// Reset selection for other beans
			resetSelectedRow();
			PM_AGENT_PF_INT_SETUP_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap()
					.put(com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PM_AGENT_PF_INT_SETUP> iterator = beanList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_APIS_RATE.resetValue();
		COMP_APIS_RATE_PER.resetValue();
		COMP_APIS_EFF_TO_DT.resetValue();
		COMP_APIS_EFF_FM_DT.resetValue();

	}

	public HtmlOutputLabel getCOMP_APIS_RATE_LABEL() {
		return COMP_APIS_RATE_LABEL;
	}

	public void setCOMP_APIS_RATE_LABEL(HtmlOutputLabel comp_apis_rate_label) {
		COMP_APIS_RATE_LABEL = comp_apis_rate_label;
	}

	public HtmlOutputLabel getCOMP_APIS_RATE_PER_LABEL() {
		return COMP_APIS_RATE_PER_LABEL;
	}

	public void setCOMP_APIS_RATE_PER_LABEL(
			HtmlOutputLabel comp_apis_rate_per_label) {
		COMP_APIS_RATE_PER_LABEL = comp_apis_rate_per_label;
	}

	public HtmlOutputLabel getCOMP_APIS_EFF_FM_DT_LABEL() {
		return COMP_APIS_EFF_FM_DT_LABEL;
	}

	public void setCOMP_APIS_EFF_FM_DT_LABEL(
			HtmlOutputLabel comp_apis_eff_fm_dt_label) {
		COMP_APIS_EFF_FM_DT_LABEL = comp_apis_eff_fm_dt_label;
	}

	public HtmlOutputLabel getCOMP_APIS_EFF_TO_DT_LABEL() {
		return COMP_APIS_EFF_TO_DT_LABEL;
	}

	public void setCOMP_APIS_EFF_TO_DT_LABEL(
			HtmlOutputLabel comp_apis_eff_to_dt_label) {
		COMP_APIS_EFF_TO_DT_LABEL = comp_apis_eff_to_dt_label;
	}

	public void addRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_AGENT_PF_INT_SETUP_BEAN = new PM_AGENT_PF_INT_SETUP();
				when_create_record();				
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

	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PM_AGENT_PF_INT_SETUP_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_AGENT_PF_INT_SETUP_BEAN,
							CommonUtils.getConnection());
					beanList.remove(PM_AGENT_PF_INT_SETUP_BEAN);
				}

				if (beanList.size() > 0) {
					setPM_AGENT_PF_INT_SETUP_BEAN(beanList.get(0));
					PM_AGENT_PF_INT_SETUP_BEAN.setRowSelected(true);
				} else {
					addRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
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
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
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

	public void post(ActionEvent ae) {
		PM006_A_APAC_DELEGATE delegate = new PM006_A_APAC_DELEGATE();
		PM006_A_APAC_HELPER helper = new PM006_A_APAC_HELPER();

		try {
			if (PM_AGENT_PF_INT_SETUP_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					pre_update(PM_AGENT_PF_INT_SETUP_BEAN);
					new CRUDHandler().executeInsert(PM_AGENT_PF_INT_SETUP_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {
					pre_insert(this.PM_AGENT_PF_INT_SETUP_BEAN);
					new CRUDHandler().executeInsert(PM_AGENT_PF_INT_SETUP_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					beanList.add(PM_AGENT_PF_INT_SETUP_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_AGENT_PF_INT_SETUP_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

}
