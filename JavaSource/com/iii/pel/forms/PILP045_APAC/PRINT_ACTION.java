package com.iii.pel.forms.PILP045_APAC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PRINT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_UI_M_WD_PROD_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_WD_PROD_TYPE;

	private HtmlOutputLabel COMP_UI_M_WD_STATUS_CODE_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_WD_STATUS_CODE;

	private HtmlOutputLabel COMP_UI_M_PRINTYPE1_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_PRINTYPE1;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private List<SelectItem> LIST_M_WD_PROD_TYPE = new ArrayList<SelectItem>();
	private List<SelectItem> LIST_M_PRINTYPE1 = new ArrayList<SelectItem>();
	private List<SelectItem> LIST_M_WD_STATUS_CODE = new ArrayList<SelectItem>();

	private PRINT PRINT_BEAN;

	private String M_POL_NO;
	private String M_PLAN_TYPE;
	private String M_WD_APPRV_STATUS;
	private String M_WD_STATUS_CODE1;
	Connection con;
	FacesContext facesContext = FacesContext.getCurrentInstance();

	private String M_DUMMY_X;
	private String PC_BL_DESC;
	private String PC_DESC;
	private String CUST_PREFERRED_LANG;
	String PL_NAME = "POLDOC";
	Map session = null;
	private String M_PLSP_REPORT_ID_1;
	private String M_REP_NAME;

	public String getPC_DESC() {
		return PC_DESC;
	}
	public void setPC_DESC(String pc_desc) {
		PC_DESC = pc_desc;
	}
	public PRINT_ACTION() {
		PRINT_BEAN = new PRINT();
		prepareDropDowns();
	}

	private void prepareDropDowns() {
		try {
			setLIST_M_WD_PROD_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILP045_APAC", "PRINT",
					"PRINT.M_WD_PROD_TYPE", "IL_PROD_TYPE"));
			setLIST_M_PRINTYPE1(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILP045_APAC", "PRINT",
					"PRINT.M_PRINTYPE1", "PRINTYPE"));
			setLIST_M_WD_STATUS_CODE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILP045_APAC", "PRINT",
					"PRINT.M_WD_STATUS_CODE", "IL_WD_STAT"));

		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_LABEL) {
		this.COMP_UI_M_POL_NO_LABEL = COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText COMP_UI_M_POL_NO) {
		this.COMP_UI_M_POL_NO = COMP_UI_M_POL_NO;
		System.out
				.println("PRINT_ACTION.setCOMP_UI_M_POL_NO()-----------------------------["
						+ this.COMP_UI_M_POL_NO + "]");
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_PROD_TYPE_LABEL() {
		return COMP_UI_M_WD_PROD_TYPE_LABEL;
	}

	public void setCOMP_UI_M_WD_PROD_TYPE_LABEL(
			HtmlOutputLabel COMP_UI_M_WD_PROD_TYPE_LABEL) {
		this.COMP_UI_M_WD_PROD_TYPE_LABEL = COMP_UI_M_WD_PROD_TYPE_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_WD_STATUS_CODE_LABEL() {
		return COMP_UI_M_WD_STATUS_CODE_LABEL;
	}

	public void setCOMP_UI_M_WD_STATUS_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_WD_STATUS_CODE_LABEL) {
		this.COMP_UI_M_WD_STATUS_CODE_LABEL = COMP_UI_M_WD_STATUS_CODE_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_PRINTYPE1_LABEL() {
		return COMP_UI_M_PRINTYPE1_LABEL;
	}

	public void setCOMP_UI_M_PRINTYPE1_LABEL(
			HtmlOutputLabel COMP_UI_M_PRINTYPE1_LABEL) {
		this.COMP_UI_M_PRINTYPE1_LABEL = COMP_UI_M_PRINTYPE1_LABEL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public PRINT getPRINT_BEAN() {
		return PRINT_BEAN;
	}

	public void setPRINT_BEAN(PRINT PRINT_BEAN) {
		this.PRINT_BEAN = PRINT_BEAN;
	}

	public String getM_POL_NO() {
		return M_POL_NO;
	}

	public void setM_POL_NO(String m_pol_no) {
		M_POL_NO = m_pol_no;
	}

	public String getM_PLAN_TYPE() {
		return M_PLAN_TYPE;
	}

	public void setM_PLAN_TYPE(String m_plan_type) {
		M_PLAN_TYPE = m_plan_type;
	}

	public String getM_WD_APPRV_STATUS() {
		return M_WD_APPRV_STATUS;
	}

	public void setM_WD_APPRV_STATUS(String m_wd_apprv_status) {
		M_WD_APPRV_STATUS = m_wd_apprv_status;
	}

	public String getM_WD_STATUS_CODE1() {
		return M_WD_STATUS_CODE1;
	}

	public void setM_WD_STATUS_CODE1(String m_wd_status_code1) {
		M_WD_STATUS_CODE1 = m_wd_status_code1;
	}

	public String getM_DUMMY_X() {
		return M_DUMMY_X;
	}

	public void setM_DUMMY_X(String m_dummy_x) {
		M_DUMMY_X = m_dummy_x;
	}
	public String getPC_BL_DESC() {
		return PC_BL_DESC;
	}
	public void setPC_BL_DESC(String pc_bl_desc) {
		PC_BL_DESC = pc_bl_desc;
	}
	public String getCUST_PREFERRED_LANG() {
		return CUST_PREFERRED_LANG;
	}
	public void setCUST_PREFERRED_LANG(String cust_preferred_lang) {
		CUST_PREFERRED_LANG = cust_preferred_lang;
	}
	public String getM_PLSP_REPORT_ID_1() {
		return M_PLSP_REPORT_ID_1;
	}
	public void setM_PLSP_REPORT_ID_1(String m_plsp_report_id_1) {
		M_PLSP_REPORT_ID_1 = m_plsp_report_id_1;
	}
	public String getM_REP_NAME() {
		return M_REP_NAME;
	}
	public void setM_REP_NAME(String m_rep_name) {
		M_REP_NAME = m_rep_name;
	}
	public List<SelectItem> getLIST_M_WD_PROD_TYPE() {
		return LIST_M_WD_PROD_TYPE;
	}
	public void setLIST_M_WD_PROD_TYPE(List<SelectItem> list_m_wd_prod_type) {
		LIST_M_WD_PROD_TYPE = list_m_wd_prod_type;
	}
	public List<SelectItem> getLIST_M_PRINTYPE1() {
		return LIST_M_PRINTYPE1;
	}
	public void setLIST_M_PRINTYPE1(List<SelectItem> list_m_printype1) {
		LIST_M_PRINTYPE1 = list_m_printype1;
	}
	public List<SelectItem> getLIST_M_WD_STATUS_CODE() {
		return LIST_M_WD_STATUS_CODE;
	}
	public void setLIST_M_WD_STATUS_CODE(List<SelectItem> list_m_wd_status_code) {
		LIST_M_WD_STATUS_CODE = list_m_wd_status_code;
	}
	public HtmlSelectOneMenu getCOMP_UI_M_WD_PROD_TYPE() {
		return COMP_UI_M_WD_PROD_TYPE;
	}
	public void setCOMP_UI_M_WD_PROD_TYPE(
			HtmlSelectOneMenu comp_ui_m_wd_prod_type) {
		COMP_UI_M_WD_PROD_TYPE = comp_ui_m_wd_prod_type;
	}
	public HtmlSelectOneMenu getCOMP_UI_M_WD_STATUS_CODE() {
		return COMP_UI_M_WD_STATUS_CODE;
	}
	public void setCOMP_UI_M_WD_STATUS_CODE(
			HtmlSelectOneMenu comp_ui_m_wd_status_code) {
		COMP_UI_M_WD_STATUS_CODE = comp_ui_m_wd_status_code;
	}
	public HtmlSelectOneMenu getCOMP_UI_M_PRINTYPE1() {
		return COMP_UI_M_PRINTYPE1;
	}
	public void setCOMP_UI_M_PRINTYPE1(HtmlSelectOneMenu comp_ui_m_printype1) {
		COMP_UI_M_PRINTYPE1 = comp_ui_m_printype1;
	}

	public Connection getConnection() throws Exception {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (Exception er) {
			er.printStackTrace();
		}
		return connection;
	}

	public void whenCreateRecord() {

		ResultSet C1 = null;
		ResultSet C2 = null;
		ResultSet C3 = null;

		session = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();

		String c1Query = "SELECT POL_NO,PLAN_TYPE FROM PT_IL_POLICY,PM_IL_PLAN WHERE POL_PLAN_CODE = PLAN_CODE"
				+ " AND   POL_SYS_ID=" + session.get("GLOBAL.M_POL_SYS_ID");
		System.out.println("THE C1 QUERY IS --" + c1Query);

		String c2Query = "SELECT  NVL(WD_APPRV_STATUS,'N'),NVL(WD_STATUS_CODE,'N') FROM PT_IL_WITHDRAWAL"
				+ " WHERE WD_SYS_ID = " + session.get("GLOBAL.M_WD_SYS_ID");

		String c3Query = "SELECT  NVL(FTH_APPRV_STATUS,'N'),NVL(FTH_STATUS_CODE,'N') FROM "
				+ "PT_IL_FUND_TRAN_HDR WHERE FTH_SYS_ID = "
				+ session.get("GLOBAL.M_FTH_SYS_ID");

		try {
			C1 = executeQuery(c1Query);
			while (C1.next()) {
				PRINT_BEAN.setUI_M_POL_NO(C1.getString("POL_NO"));
				COMP_UI_M_POL_NO.setSubmittedValue(PRINT_BEAN.getUI_M_POL_NO());
				setM_PLAN_TYPE(C1.getString("PLAN_TYPE"));
			}
			if ("U".equalsIgnoreCase(getM_PLAN_TYPE())) {
				PRINT_BEAN.setUI_M_WD_PROD_TYPE("U");
			} else {
				PRINT_BEAN.setUI_M_WD_PROD_TYPE("N");
			}
				COMP_UI_M_WD_PROD_TYPE.setSubmittedValue(PRINT_BEAN.getUI_M_WD_PROD_TYPE());

			C2 = executeQuery(c2Query);
			while (C2.next()) {
				if (!"".equals(C2.getString(1))) {
					setM_WD_APPRV_STATUS(C2.getString(1));
				}
				if (!"".equals(C2.getString(2))) {
					setM_WD_STATUS_CODE1(C2.getString(2));
				}
			}

			C3 = executeQuery(c3Query);
			while (C3.next()) {
				if (!"".equals(C3.getString(1))) {
					setM_WD_APPRV_STATUS(C3.getString(1));
				}
				if (!"".equals(C3.getString(2))) {
					setM_WD_STATUS_CODE1(C3.getString(2));
				}
			}

			if ("A".equalsIgnoreCase(getM_WD_APPRV_STATUS())) {
				PRINT_BEAN.setUI_M_WD_STATUS_CODE("A");
			} else if ("N".equalsIgnoreCase(getM_WD_APPRV_STATUS())) {
				if ("R".equalsIgnoreCase(getM_WD_STATUS_CODE1())
						|| "D".equalsIgnoreCase(getM_WD_STATUS_CODE1())) {
					PRINT_BEAN.setUI_M_WD_STATUS_CODE("R");
				}
			}
			PRINT_BEAN.setUI_M_PRINTYPE1("O");
			
			COMP_UI_M_WD_STATUS_CODE.setSubmittedValue(PRINT_BEAN.getUI_M_WD_STATUS_CODE());
			COMP_UI_M_PRINTYPE1.setSubmittedValue(PRINT_BEAN.getUI_M_PRINTYPE1());
			
			COMP_UI_M_POL_NO.resetValue();
			COMP_UI_M_WD_PROD_TYPE.resetValue();
			COMP_UI_M_WD_STATUS_CODE.resetValue();
			COMP_UI_M_PRINTYPE1.resetValue();

		} catch (Exception er) {
			er.printStackTrace();
		}
	}

	public void WHEN_VALIDATE_ITEM_M_POL_NO() {

		ResultSet rs1 = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT 'X' " + "FROM   PT_IL_POLICY "
				+ "WHERE  POL_NO = ?";
		Object[] values = null;

		try {
			con = CommonUtils.getConnection();
			values = new Object[]{PRINT_BEAN.getUI_M_POL_NO()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			if (!(rs1.next())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91208"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void WHEN_OK_BUTTON_PRESSED(ActionEvent actionEvent) {
		// THE VALUE FOR THE PS_CODE IS TAKEN FROM THE PILT021 PILP042_APAC STM
		String C6Query = "SELECT PC_DESC,PC_BL_DESC FROM PM_CODES WHERE  PC_TYPE = 'IL_REMIN_RPT' AND PC_CODE IN (SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE  PS_TYPE = 'WD_LETTER' AND PS_CODE = 'PAR_WD_LETT') ";
		// THE VALUE 121 IS FROM THE :GLOBAL.M_POL_SYS_ID
		String C7Query = "SELECT CUST_PREFERRED_LANG FROM PM_CUSTOMER WHERE CUST_CODE = (SELECT POL_CUST_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = 121)"; 
		try {
			System.out .println("_______"
							+ PRINT_BEAN.getM_WD_PROD_TYPE());
			System.out.println("The Calling Form is.................."
					+ session.get("CALLING_FORM"));
			if ("PILT021".equalsIgnoreCase(session.get("CALLING_FORM").toString())) {
				if ("U".equalsIgnoreCase(PRINT_BEAN.getM_WD_PROD_TYPE())) {
					if ("A".equalsIgnoreCase(PRINT_BEAN.getM_WD_PROD_TYPE())) {
						if ("Y".equalsIgnoreCase(session.get(
								"GLOBAL.M_WD_FULL_YN").toString())) {
							setM_PLSP_REPORT_ID_1((String) session
									.get("GLOBAL.M_PARA_2")); // THE GLOBAL
																// PARAMETER HAS
																// TO BE TAKEN
																// FROM
																// --'PILR161_APAC';
						} else {
							setM_PLSP_REPORT_ID_1((String) session
									.get("GLOBAL.M_PARA_2")); // THE GLOBAL
																// PARAMETER HAS
																// TO BE TAKEN
																// FROM
																// --'PILR164_APAC';
						}
					} else if ("R".equalsIgnoreCase(PRINT_BEAN
							.getM_WD_PROD_TYPE())) {
						setM_PLSP_REPORT_ID_1((String) session
								.get("GLOBAL.M_PARA_2")); // THE GLOBAL
															// PARAMETER HAS TO
															// BE TAKEN FROM
															// --'PILR162_APAC';
					}
				} else if ("N".equalsIgnoreCase(PRINT_BEAN.getM_WD_PROD_TYPE())) {
					setM_PLSP_REPORT_ID_1((String) session
							.get("GLOBAL.M_PARA_2")); // THE GLOBAL PARAMETER
														// HAS TO BE TAKEN FROM
														// --'PILR197_APAC';

					ResultSet C6 = executeQuery(C6Query);
					while (C6.next()) {
						setPC_DESC(C6.getString(1));
						setPC_BL_DESC(C6.getString(2));
					}
					C6.close();

					ResultSet C7 = executeQuery(C7Query);
					while (C7.next()) {
						setCUST_PREFERRED_LANG(C7.getString(1));
					}

					if ("E".equals(getCUST_PREFERRED_LANG())) {
						setM_REP_NAME(getPC_DESC());
					} else {
						setM_REP_NAME(getPC_BL_DESC());
					}
				}
				// RUN_PRODUCT(REPORTS,M_PLSP_REPORT_ID_1,SYNCHRONOUS,RUNTIME,FILESYSTEM,PL_ID,NULL);
				CallableStatement callableStatement = con
						.prepareCall("{call P9ILPK_UW_LETTERS.PARTIAL_WITHDRAWAL(?,?,?,?)}");
				int M_DSRC_SYS_ID = 0;
				if (!"".equals(getM_REP_NAME())) {
					// P9ILPK_UW_LETTERS.PARTIAL_WITHDRAWAL(M_DSRC_SYS_ID,M_REP_NAME,:GLOBAL.M_POL_SYS_ID,:GLOBAL.M_WD_SYS_ID);
					callableStatement.setString(1, null);
					callableStatement.setString(2, getM_REP_NAME());
					callableStatement.setInt(3, Integer
							.parseInt((String) session
									.get("GLOBAL.M_POL_SYS_ID")));
					callableStatement.setInt(4, Integer
							.parseInt((String) session
									.get("GLOBAL.M_WD_SYS_ID")));
					callableStatement.registerOutParameter(1, Types.INTEGER);
					callableStatement.execute();
					M_DSRC_SYS_ID = callableStatement.getInt(1);
					System.out
							.println("The OutPUT IS ----------------------------"
									+ M_DSRC_SYS_ID);
				}
				System.out.println("The Product Type Value is "
						+ PRINT_BEAN.getM_WD_PROD_TYPE());

			} else if (session.get("CALLING_FORM").toString().equals(
					"PILP042_APAC")) {
				if (PRINT_BEAN.getM_WD_PROD_TYPE().equals("U")) {
					if ("A".equals(PRINT_BEAN.getM_WD_STATUS_CODE())) {
						setM_PLSP_REPORT_ID_1("PILR163_APAC");
					}
				}
			}
		} catch (Exception er) {
			er.printStackTrace();
			try {
				throw er;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("--------------------------------------------"
				+ PRINT_BEAN.getM_WD_PROD_TYPE());
	}

	public ResultSet executeQuery(String query) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			con = getConnection();
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception er) {
			er.printStackTrace();
		}
		return resultSet;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				whenCreateRecord();
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String cancelButAction(){
		String outCome = "";
		if("PILP042_APAC".equalsIgnoreCase(CommonUtils.getGlobalVariable("CALL_FORM_PRINT").toString())){
			outCome = "PILP042_APAC";
		}
		setBlockFlag(true);
		return outCome;
	}
}
