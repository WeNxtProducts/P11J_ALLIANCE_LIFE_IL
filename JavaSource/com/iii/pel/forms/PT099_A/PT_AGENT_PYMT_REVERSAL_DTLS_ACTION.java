package com.iii.pel.forms.PT099_A;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_AGENT_PYMT_REVERSAL_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_PC_PAID_DT_LABEL;

	private HtmlCalendar COMP_PC_PAID_DT;

	private HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_GROSS_PREM;

	private HtmlOutputLabel COMP_UI_M_PC_ACV_FC_VALUE_LABEL;

	private HtmlInputText COMP_UI_M_PC_ACV_FC_VALUE;

	private HtmlOutputLabel COMP_APRD_DT_LABEL;

	private HtmlCalendar COMP_APRD_DT;

	private HtmlOutputLabel COMP_APRD_GEN_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_APRD_GEN_FLAG;

	private HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_GROSS_PREM;

	private HtmlOutputLabel COMP_UI_M_ACV_LC_VALUE_LABEL;

	private HtmlInputText COMP_UI_M_ACV_LC_VALUE;

	private PT_AGENT_PYMT_REVERSAL_DTLS PT_AGENT_PYMT_REVERSAL_DTLS_BEAN;

	List<PT_AGENT_PYMT_REVERSAL_DTLS> beanList;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private UIDataTable datatable;

	private String filterByPC_FC_GROSS_PREM;  
	
	private String filterByUI_M_PC_ACV_FC_VALUE;
	
	public PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION compositeAction;
	
	private int prevRowIndex;
	int lastUpdatedRowIndex = 0;
	int rowIndex = 0;
	private HtmlCommandButton test;
	private UIDataTable dataTable;
	private int currentpage;
	CRUDHandler handler = new CRUDHandler();
	
	// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper- 1
	private boolean approved = false;

	// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper- 1 ]
	
	private Double PC_LC_GROSS_PREM_Value;
	
	private Double UI_M_ACV_LC_VALUE_Value;
	
	public PT_AGENT_PYMT_REVERSAL_DTLS_ACTION() {
		PT_AGENT_PYMT_REVERSAL_DTLS_BEAN = new PT_AGENT_PYMT_REVERSAL_DTLS();
		
		currentpage = 1;
	}

	public HtmlOutputLabel getCOMP_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_SCHD_PYMT_DT() {
		return COMP_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_PC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_PC_SCHD_PYMT_DT_LABEL = COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_PC_SCHD_PYMT_DT(HtmlCalendar COMP_PC_SCHD_PYMT_DT) {
		this.COMP_PC_SCHD_PYMT_DT = COMP_PC_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_PC_PAID_DT_LABEL() {
		return COMP_PC_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_PAID_DT() {
		return COMP_PC_PAID_DT;
	}

	public void setCOMP_PC_PAID_DT_LABEL(HtmlOutputLabel COMP_PC_PAID_DT_LABEL) {
		this.COMP_PC_PAID_DT_LABEL = COMP_PC_PAID_DT_LABEL;
	}

	public void setCOMP_PC_PAID_DT(HtmlCalendar COMP_PC_PAID_DT) {
		this.COMP_PC_PAID_DT = COMP_PC_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_GROSS_PREM_LABEL() {
		return COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_GROSS_PREM() {
		return COMP_PC_FC_GROSS_PREM;
	}

	public void setCOMP_PC_FC_GROSS_PREM_LABEL(
			HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL) {
		this.COMP_PC_FC_GROSS_PREM_LABEL = COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_FC_GROSS_PREM(HtmlInputText COMP_PC_FC_GROSS_PREM) {
		this.COMP_PC_FC_GROSS_PREM = COMP_PC_FC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_ACV_FC_VALUE_LABEL() {
		return COMP_UI_M_PC_ACV_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_ACV_FC_VALUE() {
		return COMP_UI_M_PC_ACV_FC_VALUE;
	}

	public void setCOMP_UI_M_PC_ACV_FC_VALUE_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_ACV_FC_VALUE_LABEL) {
		this.COMP_UI_M_PC_ACV_FC_VALUE_LABEL = COMP_UI_M_PC_ACV_FC_VALUE_LABEL;
	}

	public void setCOMP_UI_M_PC_ACV_FC_VALUE(
			HtmlInputText COMP_UI_M_PC_ACV_FC_VALUE) {
		this.COMP_UI_M_PC_ACV_FC_VALUE = COMP_UI_M_PC_ACV_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_APRD_DT_LABEL() {
		return COMP_APRD_DT_LABEL;
	}

	public HtmlCalendar getCOMP_APRD_DT() {
		return COMP_APRD_DT;
	}

	public void setCOMP_APRD_DT_LABEL(HtmlOutputLabel COMP_APRD_DT_LABEL) {
		this.COMP_APRD_DT_LABEL = COMP_APRD_DT_LABEL;
	}

	public void setCOMP_APRD_DT(HtmlCalendar COMP_APRD_DT) {
		this.COMP_APRD_DT = COMP_APRD_DT;
	}

	public HtmlOutputLabel getCOMP_APRD_GEN_FLAG_LABEL() {
		return COMP_APRD_GEN_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_APRD_GEN_FLAG() {
		return COMP_APRD_GEN_FLAG;
	}

	public void setCOMP_APRD_GEN_FLAG_LABEL(
			HtmlOutputLabel COMP_APRD_GEN_FLAG_LABEL) {
		this.COMP_APRD_GEN_FLAG_LABEL = COMP_APRD_GEN_FLAG_LABEL;
	}

	public void setCOMP_APRD_GEN_FLAG(HtmlSelectOneMenu COMP_APRD_GEN_FLAG) {
		this.COMP_APRD_GEN_FLAG = COMP_APRD_GEN_FLAG;
	}

	public HtmlOutputLabel getCOMP_PC_LC_GROSS_PREM_LABEL() {
		return COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_GROSS_PREM() {
		return COMP_PC_LC_GROSS_PREM;
	}

	public void setCOMP_PC_LC_GROSS_PREM_LABEL(
			HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL) {
		this.COMP_PC_LC_GROSS_PREM_LABEL = COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_LC_GROSS_PREM(HtmlInputText COMP_PC_LC_GROSS_PREM) {
		this.COMP_PC_LC_GROSS_PREM = COMP_PC_LC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACV_LC_VALUE_LABEL() {
		return COMP_UI_M_ACV_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACV_LC_VALUE() {
		return COMP_UI_M_ACV_LC_VALUE;
	}

	public void setCOMP_UI_M_ACV_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_UI_M_ACV_LC_VALUE_LABEL) {
		this.COMP_UI_M_ACV_LC_VALUE_LABEL = COMP_UI_M_ACV_LC_VALUE_LABEL;
	}

	public void setCOMP_UI_M_ACV_LC_VALUE(HtmlInputText COMP_UI_M_ACV_LC_VALUE) {
		this.COMP_UI_M_ACV_LC_VALUE = COMP_UI_M_ACV_LC_VALUE;
	}

	public PT_AGENT_PYMT_REVERSAL_DTLS getPT_AGENT_PYMT_REVERSAL_DTLS_BEAN() {
		return PT_AGENT_PYMT_REVERSAL_DTLS_BEAN;
	}

	public void setPT_AGENT_PYMT_REVERSAL_DTLS_BEAN(
			PT_AGENT_PYMT_REVERSAL_DTLS PT_AGENT_PYMT_REVERSAL_DTLS_BEAN) {
		this.PT_AGENT_PYMT_REVERSAL_DTLS_BEAN = PT_AGENT_PYMT_REVERSAL_DTLS_BEAN;
	}

	private List<SelectItem> APAT_FLAG_LIST = new ArrayList<SelectItem>();

	public List<SelectItem> getAPAT_FLAG_LIST() throws Exception {

		if (APAT_FLAG_LIST.size() == 0) {
			APAT_FLAG_LIST.clear();
			conn = getConnection();
			APAT_FLAG_LIST = ListItemUtil.getDropDownListValue(conn, "PT099_A",
					"PT_AGENT_PYMT_REVERSAL_DTLS",
					"PT_AGENT_PYMT_REVERSAL_DTLS.APRD_GEN_FLAG", "YESNO");
		}
		return APAT_FLAG_LIST;

	}

	public void setAPAT_FLAG_LIST(List<SelectItem> apat_flag_list) {
		APAT_FLAG_LIST = apat_flag_list;
	}

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

	Connection conn;
	Map<String, Object> session = null;
	//ControlBean ctrlBean = null;
	FacesContext ctx = FacesContext.getCurrentInstance();

	/*public void createCtrlBean() {
		ControlBean bean = new ControlBean();
		FacesContext faces = FacesContext.getCurrentInstance();
		session = faces.getExternalContext().getSessionMap();
		session.put("ctrlbean", bean);
	}

	public void putCtrlBean(ControlBean bean) {
		FacesContext faces1 = FacesContext.getCurrentInstance();
		session = faces1.getExternalContext().getSessionMap();
		session.put("ctrlbean", bean);
	}

	public ControlBean getCtrlBean() {
		FacesContext faces2 = FacesContext.getCurrentInstance();
		session = faces2.getExternalContext().getSessionMap();
		return (ControlBean) session.get("ctrlbean");
	}
*/
	public Connection getConnection() {
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
	
	/*public void preForm() throws Exception {
		ArrayList<OracleParameter> list = null;

		try {

			System.out.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.preForm()");

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
			session.put("GLOBAL.M_MODULE_NAME", "PT099_A");
			System.out.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.preForm()\n"
					+ fc.getExternalContext().getSessionMap());

			STD_PRE_FORM();
			if (Integer.parseInt(((String) session
					.get("GLOBAL.M_FOR_LANG_CODE")).substring(4, 5)) == 1) {
				System.out
						.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.preForm()NULLLLLLLLLLLLLLLLL");
				//	    			NULL ;
			}
			ControlBean ctrlbean = CommonUtils.getControlBean();
			String M_TITLE = ctrlbean.getM_USER_ID() + " "
					+ ctrlbean.getM_SCR_NAME() + " " + new Date();
			System.out
					.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.preForm()---->> "
							+ M_TITLE);
			//M_TITLE=:CTRL.M_USER_ID+"                 "+:CTRL.M_SCR_NAME+"          "+ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
			// SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
			gridList();
			getTest().setDisabled(true);

			
			

			getTest().setDisabled(true);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}*/
	
	public void getDetails() {
		try {
			if (beanList.size() != 0) {				
				PT_AGENT_PYMT_REVERSAL_DTLS_BEAN = (PT_AGENT_PYMT_REVERSAL_DTLS) datatable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
		 COMP_APRD_DT.resetValue();
		 COMP_PC_FC_GROSS_PREM.resetValue();
		 // COMP_PC_LC_GROSS_PREM.resetValue();
		 COMP_PC_PAID_DT.resetValue();
		 COMP_PC_SCHD_PYMT_DT.resetValue();
		 COMP_UI_M_PC_ACV_FC_VALUE.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PT_AGENT_PYMT_REVERSAL_DTLS> iterator = beanList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	void STD_PRE_FORM() {

		//		P_GET_LOGO;
		//		COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');

		//createCtrlBean();
		ControlBean ctrlBean =CommonUtils.getControlBean();

		System.out
				.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.STD_PRE_FORM()\n---------->\n"
						+ session.toString() + "\n----------");
		//ctrlBean.setM_PARA_1((String) session.get("GLOBAL.M_PARA_1"));
		//ctrlBean.setM_USER_ID((String) session.get("GLOBAL.M_USER_ID"));
		//		bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		ctrlBean.setM_PROG_NAME("PT099_A");
		//		COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out
				.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.STD_PRE_FORM(------)"
						+ (String) session.get("GLOBAL.M_NAME"));
		ctrlBean.setM_SCR_NAME(((String) session.get("GLOBAL.M_NAME"))
				.substring(30, 42));
		//		COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		//ctrlBean.setM_LANG_CODE((String) session.get("GLOBAL.M_LANG_CODE"));
		//ctrlBean.setM_COMP_CODE(((String) session.get("GLOBAL.M_DFLT_VALUES")).substring(0, 3));
		//ctrlBean.setM_DIVN_CODE(((String) session.get("GLOBAL.M_DFLT_VALUES")).substring(3, 6));
		System.out.println("PT_IL_BROK_ADV_HDR_ACTION.STD_PRE_FORM(!!!! ) "
				+ (String) session.get("GLOBAL.M_DFLT_VALUES"));
		//ctrlBean.setM_DEPT_CODE(((String) session.get("GLOBAL.M_DFLT_VALUES")).substring(9, 11));

//		putCtrlBean(ctrlBean);
		System.out.println("PT_AGENT_TRAN_HDR_ACTION.STD_PRE_FORM()--- \n "
				+ ctrlBean.getM_LANG_CODE() + "\t" + ctrlBean.getM_COMP_CODE()
				+ "\t" + ctrlBean.getM_PARA_1());

	}
	
	

	public ArrayList<OracleParameter> prepareOracleParam(
			Map<String, Object> session) {
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		System.out
				.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.prepareOracleParam()\n------------! \n"
						+ session.toString());
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				(String) session.get("GLOBAL.M_LANG_CODE"));
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				(String) session.get("GLOBAL.M_FOR_LANG_CODE"));
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				(String) session.get("GLOBAL.M_USER_ID"));
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				CommonUtils.getControlBean().getM_COMP_CODE());
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				((String) session.get("GLOBAL.M_DFLT_VALUES")).substring(3, 6));
		System.out
				.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.prepareOracleParam(.....) "
						+ (String) session.get("GLOBAL.M_DFLT_VALUES"));
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				((String) session.get("GLOBAL.M_DFLT_VALUES")).substring(9, 11));
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				CommonUtils.getControlBean().getM_BASE_CURR());
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN", "2");
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				"PT099_A");
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);
		paramList.add(param7);
		paramList.add(param8);
		paramList.add(param9);
		return paramList;
	}

	/*public void ADDROWS(ActionEvent ae) throws Exception{
	//		if(beanList.size()<3){
		beanList.add(new PT_AGENT_PYMT_REVERSAL_DTLS());
		pre_insert();
	//		}
	}*/

	public void DeleteRow(ActionEvent ae) throws Exception {
		CommonUtils.clearMaps(this);
		System.out.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.DeleteRow()");
		PT_AGENT_PYMT_REVERSAL_DTLS valuebean = null;
		int DeletedRecordIndex = 0;
		conn = getConnection();
		System.out.println("************************");
		System.out.println(beanList.size());
		System.out.println("************************");
		if (beanList != null) {
			for (int index = 0; index < beanList.size();) {
				valuebean = beanList.get(index);
				System.out.println("ValueBean" + valuebean.toString());
				System.out
						.println("DataGridAction.deleteRow()-(bean.isCHECK_BOX()"
								+ valuebean.isCHECK_BOX());
				if (valuebean.isCHECK_BOX()) {
					beanList.remove(valuebean);
					int n = handler.executeDelete(valuebean, conn);
					conn.commit();
					System.out
							.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.deleteRow()-n"
									+ n);
				} else {
					System.out.println("Else_Part_In_Action");
					index++;
				}
			}

		}
	}

	public void checkBoxStatus(ActionEvent event) {

	}

	/*public void gridList() {

		System.out.println("INSIDE GRID LIST");
		String selectQuery = "select ROWID,PT_AGENT_PYMT_REVERSAL_DTLS.* from PT_AGENT_PYMT_REVERSAL_DTLS";

		try {
			conn = getConnection();

			beanList = handler.fetch(selectQuery,
					"com.iii.pel.forms.PT099_A.PT_AGENT_PYMT_REVERSAL_DTLS",
					conn);
			System.out.println("beanList" + beanList.size());
			for (Iterator iterator = beanList.iterator(); iterator.hasNext();) {
				PT_AGENT_PYMT_REVERSAL_DTLS_BEAN = (PT_AGENT_PYMT_REVERSAL_DTLS) iterator
						.next();
				pre_insert();
				System.out.println("beanList>>>>>>" + beanList);
				System.out.println("PT_AGENT_PYMT_REVERSAL_DTLS_BEAN"
						+ PT_AGENT_PYMT_REVERSAL_DTLS_BEAN);
			}
		} catch (Exception er) {
			er.printStackTrace();
		}
	}*/

	/*public void onFocusing(ActionEvent actionEvent) {
		rowIndex = getDataTable().getRowIndex();
		System.out.println("::::::::[ " + rowIndex + " ]:::::::");
	}*/

	public void when_PressSave_Button() {
		/*CRUDHandler handler = new CRUDHandler();
		Connection connection = null;

		try {
			connection = getConnection();
			//			 pre_insert();

			System.out.println("ROW INDEX : " + rowIndex);
			System.out.println("BEAN LIST SIZE : " + beanList.size());
			int rowindx=getDataTable().getRowIndex();
			PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls=beanList.get(rowindx);
			//PT_AGENT_PYMT_REVERSAL_DTLS_BEAN = beanList.get(rowIndex);
			if(pt_agent_pymt_reversal_dtls==null){
				
				pre_insert(pt_agent_pymt_reversal_dtls);
			}

			handler.executeInsert(PT_AGENT_PYMT_REVERSAL_DTLS_BEAN, connection);*/

			try {
				new CommonUtils().doComitt();
				String message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			} catch (Exception e) {
				e.printStackTrace();
			}

		/*} catch (Exception e) {
			e.printStackTrace();
		}*/
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
			PT_AGENT_PYMT_REVERSAL_DTLS_BEAN = beanList.get(rowIndex);
			handler.executeDelete(PT_AGENT_PYMT_REVERSAL_DTLS_BEAN, connection);
			beanList.remove(rowIndex);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void when_create_record() {
		PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setAPRD_GEN_FLAG("N");
		PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setAPRD_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
	}

	/*public void pre_insert(PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls) throws Exception {
		conn = getConnection();
		ResultSet vembu_C1 = null;
		ResultSet vembu_C2 = null;
		ResultSet vembu_C3 = null;
		try {
			String sql_C1 = "SELECT APRD_SYS_ID.NEXTVAL FROM  DUAL";
			Statement stmt_C1 = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			String sql_C3 = "SELECT  SUM(NVL(ACV_FC_VALUE, 0)), SUM(NVL(ACV_LC_VALUE, 0)) FROM  PT_AGENT_COMM_VALUES";

			Statement stmt_C3 = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String sql_C2 = "SELECT  PC_SCHD_PYMT_DT, PC_PAID_DT, PC_FC_GROSS_PREM, PC_LC_GROSS_PREM FROM  PT_IL_PREM_COLL where PC_POL_SYS_ID='73' and PC_SYS_ID='236'";

			Statement stmt_C2 = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			vembu_C1 = stmt_C1.executeQuery(sql_C1);
			if (vembu_C1.next()) {
				pt_agent_pymt_reversal_dtls.setAPRD_SYS_ID(Double
						.parseDouble(vembu_C1.getString(1)));
			}

			vembu_C3 = stmt_C3.executeQuery(sql_C3);
			if (vembu_C3.next()) {
				pt_agent_pymt_reversal_dtls.setUI_M_PC_ACV_FC_VALUE(Double
						.parseDouble(vembu_C3.getString(1)));
				pt_agent_pymt_reversal_dtls.setUI_M_ACV_LC_VALUE(vembu_C3
						.getString(2));
			}

			vembu_C2 = stmt_C2.executeQuery(sql_C2);
			if (vembu_C2.next()) {
				pt_agent_pymt_reversal_dtls.setPC_SCHD_PYMT_DT(vembu_C2
						.getDate(1));
				System.out
						.println("VALUE Date"
								+ PT_AGENT_PYMT_REVERSAL_DTLS_BEAN
										.getPC_SCHD_PYMT_DT());
				pt_agent_pymt_reversal_dtls.setPC_PAID_DT(vembu_C2
						.getDate(2));
				pt_agent_pymt_reversal_dtls.setPC_FC_GROSS_PREM(Double
						.parseDouble(vembu_C2.getString(3)));
				pt_agent_pymt_reversal_dtls.setPC_LC_GROSS_PREM(Double
						.parseDouble(vembu_C2.getString(3)));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			CommonUtils.closeCursor(vembu_C1);
			CommonUtils.closeCursor(vembu_C2);
			CommonUtils.closeCursor(vembu_C3);
		}
	}*/

	/*public List<PT_AGENT_PYMT_REVERSAL_DTLS> postQuery() {
		List<PT_AGENT_PYMT_REVERSAL_DTLS> queryList = new ArrayList<PT_AGENT_PYMT_REVERSAL_DTLS>();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PT_AGENT_TRAN_HDR_ACTION actionBean = (PT_AGENT_TRAN_HDR_ACTION) session
				.getAttribute("PT099_A_PT_AGENT_TRAN_HDR_ACTION");
		double pcSysId = 0;
		double pcPolSysId = 0;
		Connection con = getConnection();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		if (actionBean != null) {
			//double sysId = actionBean.getPT_AGENT_TRAN_HDR_BEAN().getATH_SYS_ID();
			String selectQuery = "select ROWID,PT_AGENT_PYMT_REVERSAL_DTLS.* from PT_AGENT_PYMT_REVERSAL_DTLS WHERE APRD_ATH_SYS_ID ='2887'";
			try {
				ResultSet rs = getHandler().executeSelectStatement(selectQuery,
						con);
				while (rs.next()) {
					pcSysId = rs.getDouble("APRD_PC_SYS_ID");

					pcPolSysId = rs.getDouble("APRD_POL_SYS_ID");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			double polSysId = actionBean.getPT_AGENT_TRAN_HDR_BEAN()
					.getATH_POL_SYS_ID();
			String agentCode = actionBean.getPT_AGENT_TRAN_HDR_BEAN()
					.getATH_AGENT_CODE();

			//String query1 ="SELECT SUM(NVL(ACV_FC_VALUE,0)) as sum1,SUM(NVL(ACV_LC_VALUE ,0)) as sum2 FROM PT_AGENT_COMM_VALUES where ACV_POL_SYS_ID ='"+polSysId+"'and ACV_AGENT_CODE='"+agentCode+"' and ACV_PC_SYS_ID='"+pcSysId+"'";
			String query1 = "SELECT SUM(NVL(ACV_FC_VALUE,0)) as sum1,SUM(NVL(ACV_LC_VALUE ,0)) as sum2 FROM PT_AGENT_COMM_VALUES";
			String query2 = "SELECT PC_SCHD_PYMT_DT,PC_PAID_DT,PC_FC_GROSS_PREM,PC_LC_GROSS_PREM FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID='"
					+ 73 + "' and PC_SYS_ID='239'";

			System.out
					.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.postQuery()-----QUERY1--["
							+ query1 + "]---QUERY2--[" + query2 + "]");
			try {
				rs1 = getHandler().executeSelectStatement(query1, con);
				rs2 = getHandler().executeSelectStatement(query2, con);
				String sum1=null;
				 double sum2=0;
				 while(rs1.next()){
					 sum1 =rs1.getString("sum1");
					 sum2 =rs1.getDouble("sum1");
					 
				 }
				while (rs2.next()) {
					PT_AGENT_PYMT_REVERSAL_DTLS bean = new PT_AGENT_PYMT_REVERSAL_DTLS();
					bean.setPC_SCHD_PYMT_DT(rs2.getDate("PC_SCHD_PYMT_DT"));
					bean.setPC_PAID_DT(rs2.getDate("PC_PAID_DT"));
					bean.setPC_FC_GROSS_PREM(rs2.getDouble("PC_FC_GROSS_PREM"));
					bean.setPC_LC_GROSS_PREM(rs2.getDouble("PC_LC_GROSS_PREM"));
					rs1.next();
					bean.setUI_M_ACV_LC_VALUE(rs1.getString("sum1"));
					bean.setUI_M_PC_ACV_FC_VALUE(rs1.getDouble("sum2"));
					System.out
							.println("PT_AGENT_PYMT_REVERSAL_DTLS_ACTION.postQuery()---BEAN--["
									+ bean.getUI_M_ACV_LC_VALUE() + "]");
					queryList.add(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					CommonUtils.closeCursor(rs1);
					CommonUtils.closeCursor(rs2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return queryList;
	}*/

	/*public void pre_update() throws Exception {
		conn = getConnection();
		ResultSet vembu_C1 = null;
		try {

			//	            String sql_C1="SELECT 'X' FROM  PM_AGENT_PF_INT_SETUP  WHERE  ((APIS_EFF_FM_DT  BETWEEN"+
			//	            (Date)getCOMP_APIS_EFF_FM_DT().getValue()+
			//	            "  AND  "+(Date)getCOMP_APIS_EFF_TO_DT().getValue()+")  OR  (APIS_EFF_TO_DT  BETWEEN"+
			//	            (Date)getCOMP_APIS_EFF_FM_DT().getValue()+
			//	            "  AND  "+(Date)getCOMP_APIS_EFF_TO_DT().getValue()+"))  AND ROWID  <> "
			//	            +PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.getROWID();
			Statement stmt_C1 = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String M_DUMMY_X = null;
			if (vembu_C1 != null) {
				vembu_C1.close();
			}
			//            vembu_C1=stmt_C1.executeQuery(sql_C1);
			if (vembu_C1.next()) {
				M_DUMMY_X = vembu_C1.getString(1);
			}
			if (!vembu_C1.isLast()) {
				System.out
						.println("PM_AGENT_PF_INT_SETUP_ACTION.pre_update() ERROR CODE=60018");
				//                STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(60018,:CTRL.M_LANG_CODE);
				//                throw new FORM_TRIGGER_FAILURE();
			}
			vembu_C1.close();

			//            PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setAPIS_UPD_UID("LIFEALL");
			//            PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setAPIS_UPD_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			CommonUtils.closeCursor(vembu_C1);
		}

	}*/

	/*public void rowChangeListener(ActionEvent event) {
		System.out.println("PM_AGENT_PF_INT_SETUP_ACTION.rowChangeListener()");

		int currRowIndex = rowIndex;
		int rowUpdated = 0;
		PT_AGENT_PYMT_REVERSAL_DTLS gridValueBean = null;
		System.out.println(lastUpdatedRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PT_AGENT_PYMT_REVERSAL_DTLS) beanList
								.get(prevRowIndex);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {
							System.out
									.println("PT_IL_LOAN_CHARGE_ACTION.rowChangeListener-----rowID1"
											+ gridValueBean.getROWID());
							rowUpdated = updateData(gridValueBean);
						} else {

							//gridValueBean.setRSA_PLAN_CODE("dee");
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
*/
	public int updateData(PT_AGENT_PYMT_REVERSAL_DTLS gridValueBean)
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

	public void post(ActionEvent ae) {
		CommonUtils utils =new CommonUtils();
		try{
			
			if(PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setAPRD_UPD_DT(utils.getCurrentDate());
					PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setAPRD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
					new CRUDHandler().executeUpdate(PT_AGENT_PYMT_REVERSAL_DTLS_BEAN, CommonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {

				if(isINSERT_ALLOWED()) {
					
					PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setAPRD_CR_DT(utils.getCurrentDate());
					PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setAPRD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			
					new CRUDHandler().executeInsert(PT_AGENT_PYMT_REVERSAL_DTLS_BEAN, CommonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	public void lastColumnListener() throws Exception{

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PT_AGENT_PYMT_REVERSAL_DTLS gridValueBean = null;
		CommonUtils utils =new CommonUtils();
		String message=null;
		try {

			// Get the bean based on row index
			gridValueBean = (PT_AGENT_PYMT_REVERSAL_DTLS) beanList.get(currRowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				gridValueBean.setAPRD_UPD_DT(utils.getCurrentDate());
				gridValueBean.setAPRD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				handler.executeInsert(gridValueBean, conn);
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
				
			} else {
				Map sessionmap = FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap();
				gridValueBean.setAPRD_CR_DT(utils.getCurrentDate());
				gridValueBean.setAPRD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				//pre_insert(gridValueBean);
				handler.executeInsert(gridValueBean, conn);
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				
			}
			if(message!=null){
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			}
			lastUpdatedRowIndex = currRowIndex;

		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
			throw e1;
		}
		return;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public String goToHeaderBlock() {
		return "HeaderBlock";
	}

	public List<PT_AGENT_PYMT_REVERSAL_DTLS> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<PT_AGENT_PYMT_REVERSAL_DTLS> beanList) {
		this.beanList = beanList;
	}

	public void loadAgentPymtReversalDtls(HashMap<String, String> errorMap) {
		String message = null;
		PT_AGENT_PYMT_REVERSAL_DTLS_HELPER helper=new PT_AGENT_PYMT_REVERSAL_DTLS_HELPER();
		try {
			UI_M_BUT_POST = new HtmlAjaxCommandButton();
			beanList = new ArrayList<PT_AGENT_PYMT_REVERSAL_DTLS>();
			prevRowIndex = 0;
			//currPage = 1;
			helper.execute_query();
			if(beanList.size()>0){
				UI_M_BUT_POST.setDisabled(false);
			}else{
				UI_M_BUT_POST.setDisabled(true);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			errorMap.put("current", message);
			errorMap.put("details", message);
		}	
		
	}
	//[Grid tab listener Method Commented by Phanikumar dated 16-Feb-2009.New Grid changes made 
	/*public void gridtabListener() {

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PT_AGENT_PYMT_REVERSAL_DTLS gridValueBean = null;
		System.out.println(lastUpdatedRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		CommonUtils utils=new CommonUtils();
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PT_AGENT_PYMT_REVERSAL_DTLS) beanList
								.get(prevRowIndex);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {
							gridValueBean.setAPRD_UPD_DT(utils.getCurrentDate());
							gridValueBean.setAPRD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
							handler.executeInsert(gridValueBean, conn);
							getWarningMap().put("current", "Record Updated");
						} else {
							gridValueBean.setAPRD_CR_DT(utils.getCurrentDate());
							gridValueBean.setAPRD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
							//pre_insert(gridValueBean);
							handler.executeInsert(gridValueBean, conn);
							getWarningMap().put("current", "Record Inserted");

						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		return;
	}
*/		//Grid tab listener Method Commented by Phanikumar dated 16-Feb-2009.New Grid changes made]
	public void checkBoxInsert(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		int rowIndx=getDataTable().getRowIndex();
		PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls=beanList.get(rowIndx);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String checkBoxValue=(String)input.getSubmittedValue();
		if(checkBoxValue.equals("true")){
			pt_agent_pymt_reversal_dtls.setCHECK_BOX(true);
		}
	}
	
	public void insertPC_SCHD_PYMT_DT(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		int rowIndx=getDataTable().getRowIndex();
		PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls=beanList.get(rowIndx);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		Date schdPymtDt=(Date)input.getSubmittedValue();
		pt_agent_pymt_reversal_dtls.setPC_SCHD_PYMT_DT(schdPymtDt);
		//Calling of Grid tab listener Method Commented by Phanikumar dated 16-Feb-2009.New Grid changes made]
		//gridtabListener();
		try {
			//lastColumnListener();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertPC_PAID_DT(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		int rowIndx=getDataTable().getRowIndex();
		PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls=beanList.get(rowIndx);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		Date pcPaidDt=(Date)input.getSubmittedValue();
		pt_agent_pymt_reversal_dtls.setPC_PAID_DT(pcPaidDt);
		//Calling of Grid tab listener Method Commented by Phanikumar dated 16-Feb-2009.New Grid changes made]
		//gridtabListener();
		try {
			//lastColumnListener();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertPC_FC_GROSS_PREM(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		int rowIndx=getDataTable().getRowIndex();
		PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls=beanList.get(rowIndx);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		Double pcFCGrossPrem=Double.parseDouble((String) input.getSubmittedValue());
		pt_agent_pymt_reversal_dtls.setPC_FC_GROSS_PREM(pcFCGrossPrem);
		//Calling of Grid tab listener Method Commented by Phanikumar dated 16-Feb-2009.New Grid changes made]
		//gridtabListener();
		try {
			//Calling of Grid tab listener Method Commented by Phanikumar dated 16-Feb-2009.New Grid changes made]
			//lastColumnListener();
		} catch (Exception e) {
			e.printStackTrace();
		}
		calculatePC_LC_Gross_prem(this);
	}
	
	public void insertUI_M_PC_ACV_FC_VALUE(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		int rowIndx=getDataTable().getRowIndex();
		PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls=beanList.get(rowIndx);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		Double acvFCValue=Double.parseDouble((String) input.getSubmittedValue());
		pt_agent_pymt_reversal_dtls.setUI_M_PC_ACV_FC_VALUE(acvFCValue);
		//Calling of Grid tab listener Method Commented by Phanikumar dated 16-Feb-2009.New Grid changes made]
	//	gridtabListener();
		try {
			//Calling of Grid tab listener Method Commented by Phanikumar dated 16-Feb-2009.New Grid changes made]
			//lastColumnListener();
		} catch (Exception e) {
			e.printStackTrace();
		}
		calculateUI_M_ACV_LC_VALUE(this);
	}
	
	public void insertAPRD_DT(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		int rowIndx=getDataTable().getRowIndex();
		PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls=beanList.get(rowIndx);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		Date aprdDate=(Date)input.getSubmittedValue();
		pt_agent_pymt_reversal_dtls.setAPRD_DT(aprdDate);
		//Calling of Grid tab listener Method Commented by Phanikumar dated 16-Feb-2009.New Grid changes made]
		//	gridtabListener();
		try {
		
			//lastColumnListener();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertAPRD_GEN_FLAG(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
	//	int rowIndx=getDataTable().getRowIndex();
	//	PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls=beanList.get(rowIndx);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String aprdGenFlag=(String)input.getSubmittedValue();
		PT_AGENT_PYMT_REVERSAL_DTLS_BEAN.setAPRD_GEN_FLAG(aprdGenFlag);
		//Calling of Grid tab listener Method Commented by Phanikumar dated 16-Feb-2009.New Grid changes made]
		//	gridtabListener();
		try {
		//	lastColumnListener();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void calculatePC_LC_Gross_prem(PT_AGENT_PYMT_REVERSAL_DTLS_ACTION dtlsAction){
		List<PT_AGENT_PYMT_REVERSAL_DTLS> valueBeanList=dtlsAction.getBeanList();
		
		Iterator itr=valueBeanList.iterator();
		Double lcGrossPrem=0.0;
		Double pcFcGrossPrem=null;
		PT_AGENT_PYMT_REVERSAL_DTLS reversalDtls=null;
		while(itr.hasNext()){
			reversalDtls=(PT_AGENT_PYMT_REVERSAL_DTLS) itr.next();
			pcFcGrossPrem=reversalDtls.getPC_FC_GROSS_PREM();
			if(pcFcGrossPrem!=null){
				lcGrossPrem=lcGrossPrem+pcFcGrossPrem;
			}
		}
		System.out.println("PC_LC_GROSS_PREM :"+lcGrossPrem);
		dtlsAction.setPC_LC_GROSS_PREM_Value(lcGrossPrem);
		if(dtlsAction.getCOMP_PC_LC_GROSS_PREM() != null){
			dtlsAction.getCOMP_PC_LC_GROSS_PREM().resetValue();
		}
		
	}
	
	public void calculateUI_M_ACV_LC_VALUE(PT_AGENT_PYMT_REVERSAL_DTLS_ACTION dtlsAction){
		List<PT_AGENT_PYMT_REVERSAL_DTLS> valueBeanList=dtlsAction.getBeanList();
		
		Iterator itr=valueBeanList.iterator();
		Double acvLcValue=0.0;
		Double acvFcValue=null;
		PT_AGENT_PYMT_REVERSAL_DTLS reversalDtls=null;
		while(itr.hasNext()){
			reversalDtls=(PT_AGENT_PYMT_REVERSAL_DTLS) itr.next();
			acvFcValue=reversalDtls.getUI_M_PC_ACV_FC_VALUE();
			if(acvFcValue!=null){
				acvLcValue=acvLcValue+acvFcValue;
			}
		}
		System.out.println("acvLcValue :"+acvLcValue);
		if(dtlsAction.getCOMP_UI_M_ACV_LC_VALUE()==null){
			dtlsAction.setCOMP_UI_M_ACV_LC_VALUE(new HtmlInputText());
		}
		dtlsAction.setUI_M_ACV_LC_VALUE_Value(acvLcValue);
		dtlsAction.getCOMP_UI_M_ACV_LC_VALUE().resetValue();
	}

	public Double getPC_LC_GROSS_PREM_Value() {
		return PC_LC_GROSS_PREM_Value;
	}

	public void setPC_LC_GROSS_PREM_Value(Double value) {
		PC_LC_GROSS_PREM_Value = value;
	}

	public Double getUI_M_ACV_LC_VALUE_Value() {
		return UI_M_ACV_LC_VALUE_Value;
	}

	public void setUI_M_ACV_LC_VALUE_Value(Double value) {
		UI_M_ACV_LC_VALUE_Value = value;
	}

	// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper- 2
	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper- 2 ]
	
	// [ Added for grid implementation change, Added by: Phanikumar, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	// Added for grid implementation change, Added by: Phanikumar, Dated: 16-Feb-2009 ]

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public UIDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(UIDataTable datatable) {
		this.datatable = datatable;
	}
 
	public String getFilterByUI_M_PC_ACV_FC_VALUE() {
		return filterByUI_M_PC_ACV_FC_VALUE;
	}

	public void setFilterByUI_M_PC_ACV_FC_VALUE(String filterByUI_M_PC_ACV_FC_VALUE) {
		this.filterByUI_M_PC_ACV_FC_VALUE = filterByUI_M_PC_ACV_FC_VALUE;
	}

	public String getFilterByPC_FC_GROSS_PREM() {
		return filterByPC_FC_GROSS_PREM;
	}

	public void setFilterByPC_FC_GROSS_PREM(String filterByPC_FC_GROSS_PREM) {
		this.filterByPC_FC_GROSS_PREM = filterByPC_FC_GROSS_PREM;
	}
}
