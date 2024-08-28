package com.iii.pel.forms.PILM038;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_CLAIM_COVER_ACTION extends CommonAction {

	private static final Log logger = LogFactory
			.getLog(PM_IL_CLAIM_COVER_ACTION.class);

	private HtmlOutputLabel COMP_CC_COVER_TYPE_LABEL;

	private HtmlOutputLabel COMP_CC_COVER_CODE_LABEL;

	private HtmlInputText COMP_CC_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_CC_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CC_COVER_CODE_DESC;

	// private HtmlOutputLabel COMP_CC_PROD_CODE_LABEL;

	// private HtmlInputText COMP_CC_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_CC_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CC_PROD_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_LOV_BUT_CODE;

	private HtmlOutputLabel COMP_CC_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_CC_EFF_FM_DT;

	private HtmlOutputLabel COMP_CC_EFF_TO_DT_LABEL;

	private HtmlOutputLabel COMP_CC_FLEX_01_LABEL;
	private HtmlInputText COMP_CC_FLEX_01;

	private HtmlCalendar COMP_CC_EFF_TO_DT;

	private HtmlCommandButton test;

	private HtmlOutputText COMP_ERROR_MESSAGE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_COVER_CODE;

	private HtmlSelectOneMenu COMP_CC_PROD_CODE_S;

	private PM_IL_CLAIM_COVER PM_IL_CLAIM_COVER_BEAN;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DEL;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private String filterByCC_CLAIM_TYPE;

	private String filterByCC_COVER_CODE;

	private List<PM_IL_CLAIM_COVER> beanList;

	Connection connection = null;

	Map session = null;

	private UIData dataTable;

	private UIData datatable;

	private int lastUpdatedRowIndex;

	private int prevRowIndex;

	int rowIndex = 0;

	List<SelectItem> claimTypeList;

	private int recordsPerPage = 5;

	CRUDHandler handler = new CRUDHandler();

	public PM_IL_CLAIM_COVER_ACTION() {
		if (beanList == null) {
			beanList = new ArrayList<PM_IL_CLAIM_COVER>();
		}
		PM_IL_CLAIM_COVER_BEAN = new PM_IL_CLAIM_COVER();
		claimTypeList = claimTyepList();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_CC_COVER_CODE_LABEL() {
		return COMP_CC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CC_COVER_CODE() {
		return COMP_CC_COVER_CODE;
	}

	public void setCOMP_CC_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_CC_COVER_CODE_LABEL) {
		this.COMP_CC_COVER_CODE_LABEL = COMP_CC_COVER_CODE_LABEL;
	}

	public void setCOMP_CC_COVER_CODE(HtmlInputText COMP_CC_COVER_CODE) {
		this.COMP_CC_COVER_CODE = COMP_CC_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CC_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_CC_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CC_COVER_CODE_DESC() {
		return COMP_UI_M_CC_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_CC_COVER_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CC_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_CC_COVER_CODE_DESC_LABEL = COMP_UI_M_CC_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CC_COVER_CODE_DESC(
			HtmlInputText COMP_UI_M_CC_COVER_CODE_DESC) {
		this.COMP_UI_M_CC_COVER_CODE_DESC = COMP_UI_M_CC_COVER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_CC_EFF_FM_DT_LABEL() {
		return COMP_CC_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CC_EFF_FM_DT() {
		return COMP_CC_EFF_FM_DT;
	}

	public void setCOMP_CC_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_CC_EFF_FM_DT_LABEL) {
		this.COMP_CC_EFF_FM_DT_LABEL = COMP_CC_EFF_FM_DT_LABEL;
	}

	public void setCOMP_CC_EFF_FM_DT(HtmlCalendar COMP_CC_EFF_FM_DT) {
		this.COMP_CC_EFF_FM_DT = COMP_CC_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_CC_EFF_TO_DT_LABEL() {
		return COMP_CC_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CC_EFF_TO_DT() {
		return COMP_CC_EFF_TO_DT;
	}

	public void setCOMP_CC_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_CC_EFF_TO_DT_LABEL) {
		this.COMP_CC_EFF_TO_DT_LABEL = COMP_CC_EFF_TO_DT_LABEL;
	}

	public void setCOMP_CC_EFF_TO_DT(HtmlCalendar COMP_CC_EFF_TO_DT) {
		this.COMP_CC_EFF_TO_DT = COMP_CC_EFF_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_COVER_CODE() {
		return COMP_UI_M_BUT_LOV_COVER_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_COVER_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_COVER_CODE) {
		this.COMP_UI_M_BUT_LOV_COVER_CODE = COMP_UI_M_BUT_LOV_COVER_CODE;
	}

	public PM_IL_CLAIM_COVER getPM_IL_CLAIM_COVER_BEAN() {
		return PM_IL_CLAIM_COVER_BEAN;
	}

	public void setPM_IL_CLAIM_COVER_BEAN(
			PM_IL_CLAIM_COVER PM_IL_CLAIM_COVER_BEAN) {
		this.PM_IL_CLAIM_COVER_BEAN = PM_IL_CLAIM_COVER_BEAN;
	}

	public List<PM_IL_CLAIM_COVER> getBeanList() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		ClassMasterSearch search = (ClassMasterSearch) session
				.getAttribute("PILM038_ClassMasterSearch");
		if (search != null) {
			String classCode = search.getInitClasscode();
			System.out.println("CLASSCODE:::::" + classCode);
			PM_IL_CLAIM_COVER_BEAN.setCC_CLAIM_TYPE(classCode);
		}
		return beanList;
	}

	public void setBeanList(List<PM_IL_CLAIM_COVER> beanList) {
		this.beanList = beanList;
	}

	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	public void gridList() {
		beanList.add(new PM_IL_CLAIM_COVER());

	}

	public void onFocusing(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		rowIndex = getDataTable().getRowIndex();
		System.out.println("::::::::[ " + rowIndex + " ]:::::::");
	}

	public void when_onblur(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void lastColumnListener() {
		CRUDHandler handler = new CRUDHandler();
		System.out.println("PM_IL_CLAIM_COVER_ACTION.when_onblur()");
		try {
			connection = CommonUtils.getConnection();
			PM_IL_CLAIM_COVER PM_IL_CLAIM_COVER_BEAN = getCurrentBean();
			Date sysdate = new java.sql.Date(Calendar.getInstance()
					.getTimeInMillis());
			String rowId = PM_IL_CLAIM_COVER_BEAN.getROWID();
			String message = null;
			if (rowId == null) {
				PM_IL_CLAIM_COVER_BEAN.setCC_CR_DT(sysdate);
				PM_IL_CLAIM_COVER_BEAN.setCC_CR_UID(CommonUtils
						.getControlBean().getM_USER_ID());
				message = "inserted";
			} else {
				PM_IL_CLAIM_COVER_BEAN.setCC_UPD_DT(sysdate);
				PM_IL_CLAIM_COVER_BEAN.setCC_UPD_UID(CommonUtils
						.getControlBean().getM_USER_ID());
				message = "updated";
			}
			int result = handler.executeInsert(PM_IL_CLAIM_COVER_BEAN,
					connection);
			getWarningMap().put("current",
					result + " record(s) " + message + ".");
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}

	public void when_PressSave_Button() {
		CRUDHandler handler = new CRUDHandler();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		ClassMasterSearch search = (ClassMasterSearch) session
				.getAttribute("PILM038_ClassMasterSearch");
		// ** added by Varun (50663)**//
		List<PM_IL_CLAIM_COVER> claimCoverValueBeanList = null;
		Iterator itr = null;
		try {
			new CommonUtils().doComitt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pilm038_pm_il_claim_cover_pre_insert() {
		System.out.println("pre_insert CALLED SUCCESSFULLY");
		try {
			getCOMP_UI_M_CC_COVER_CODE_DESC().setSubmittedValue("Joshua");
			connection = CommonUtils.getConnection();
			String sql_C2 = "SELECT 'X' FROM  PM_IL_CLAIM_COVER  WHERE  "
					+ " CC_CLAIM_TYPE  = 'A'  AND CC_COVER_CODE  = 'F' ";
			ResultSet rs_C2 = null;
			PreparedStatement stmt_C2 = connection.prepareStatement(sql_C2);
			String M_TEMP2 = null;
			ControlBean ctrlBean = CommonUtils.getControlBean();
			PM_IL_CLAIM_COVER_BEAN.setCC_CR_DT(new java.sql.Date(Calendar
					.getInstance().getTimeInMillis()));
			PM_IL_CLAIM_COVER_BEAN.setCC_CR_UID(ctrlBean.getM_USER_ID());
			if (rs_C2 != null) {
				rs_C2.close();
			}
			rs_C2 = stmt_C2.executeQuery(sql_C2);
			if (rs_C2.next()) {
				M_TEMP2 = rs_C2.getString(1);
			}
			if (!rs_C2.isLast()) {
				JOptionPane.showMessageDialog(null, "Already Exits");
			}
			rs_C2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ADDROWS(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		gridList();
	}

	public void DELETEROWS(ActionEvent ae) throws Exception {
		CommonUtils.clearMaps(this);
		PM_IL_CLAIM_COVER valuebean = null;
		int DeletedRecordIndex = 0;
		connection = CommonUtils.getConnection();
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
				// if (valuebean.isCHECK_BOX()) {
				if ("dataTableSelectedRow".equalsIgnoreCase(valuebean
						.getRowSelected())) {
					beanList.remove(valuebean);
					int n = handler.executeDelete(valuebean, connection);
					System.out.println("PM_IL_CLAIM_COVER_ACTION.deleteRow()-n"
							+ n);
					connection.commit();
				} else {
					System.out.println("Else_Part_In_Action");
					index++;
				}
			}
		}
	}

	public String deleteRecords() throws Exception {
		CommonUtils.clearMaps(this);

		if (beanList != null) {

			beanList.clear();
			connection.commit();

		}
		return null;
	}

	public void updateBeanList() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		int rowNum = Integer.parseInt(request.getParameter("rowNum"));
		String coverCode = (String) getCOMP_CC_COVER_CODE().getSubmittedValue();
		System.out.println(coverCode + " Cover Code");
		PM_IL_CLAIM_COVER claimCover = beanList.get(rowNum);
		claimCover.setCC_COVER_CODE(coverCode);
	}

	public List PROD_CODE_lovAction(Object obj) throws Exception {
		ResultSet rs = null;
		List lovList = new ArrayList();
		String query = null;
		if (obj.toString().equals("*")) {
			query = "SELECT distinct PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE IS NOT NULL";
		} else {
			query = "SELECT distinct PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE IS NOT NULL AND PROD_CODE LIKE('"
					+ obj.toString() + "%') AND ROWNUM<25 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, connection);
		rs.setFetchSize(25);
		while (rs.next()) {
			PROD_CODE_LOV lovBox = new PROD_CODE_LOV();
			lovBox.setCC_PROD_CODE(rs.getString("PROD_CODE"));
			lovBox.setUI_M_CC_PROD_CODE_DESC(rs.getString("PROD_DESC"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_BUT_CODE() {
		return COMP_UI_M_LOV_BUT_CODE;
	}

	public void setCOMP_UI_M_LOV_BUT_CODE(
			HtmlCommandButton comp_ui_m_lov_but_code) {
		COMP_UI_M_LOV_BUT_CODE = comp_ui_m_lov_but_code;
	}

	public void pilm038_pm_il_claim_cover_pre_block() throws SQLException,
			Exception {
		try {
			connection = CommonUtils.getConnection();
			CommonUtils.getControlBean().setM_DELETE_MSG_FLAG("Y");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		return "";
	}

	public void checkBoxValidation(ActionEvent event) {
	}

	public String update() throws Exception {
		String return_String = "";
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String code = request.getParameter("CoverCode");
		String classCode = request.getParameter("claimType");

		System.out.println(code + "        " + classCode);
		HttpSession session = request.getSession();
		ClassMasterSearch search = (ClassMasterSearch) session
				.getAttribute("PILM038_ClassMasterSearch");
		// String classCode = search.getInitClasscode();
		search.setInitClasscode(classCode);
		if (classCode != null && code != null) {
			PM_IL_CLAIM_COVER_BEAN.setCC_CLAIM_TYPE(classCode);
			CRUDHandler handler = new CRUDHandler();
			String selectQuery = "select ROWID,CC_COVER_CODE,CC_EFF_FM_DT,CC_EFF_TO_DT,CC_CLAIM_TYPE,CC_PROD_CODE,CC_CR_UID,CC_CR_DT FROM PM_IL_CLAIM_COVER where CC_COVER_CODE= '"
					+ code + "' AND CC_CLAIM_TYPE='" + classCode + "'";
			try {
				connection = CommonUtils.getConnection();
				List<PM_IL_CLAIM_COVER> list = handler.fetch(selectQuery,
						"com.iii.pel.forms.PILM038.PM_IL_CLAIM_COVER",
						connection);
				Iterator itr = list.iterator();
				while (itr.hasNext()) {
					PM_IL_CLAIM_COVER pm_il_claim_cover = new PM_IL_CLAIM_COVER();
					pm_il_claim_cover = (PM_IL_CLAIM_COVER) itr.next();
					if (pm_il_claim_cover.getCC_CLAIM_TYPE() != null) {
						pm_il_claim_cover.setClaimTypeDisableFlag(true);
					}
				}
				/*
				 * PM_IL_CLAIM_COVER_BEAN = (PM_IL_CLAIM_COVER) list.get(0);
				 * if(PM_IL_CLAIM_COVER_BEAN.getCC_CLAIM_TYPE()!=null){
				 * PM_IL_CLAIM_COVER_BEAN.setClaimTypeDisableFlag(true); }
				 */
				this.beanList = list;
			} catch (Exception er) {
				er.printStackTrace();
			}

			// postQuery();
			if (beanList != null && !beanList.isEmpty()) {
				for (int i = 0; i < beanList.size(); i++) {
					PM_IL_CLAIM_COVER pm_il_claim_cover = beanList.get(i);
					if (i == 0) {
						pm_il_claim_cover.setRowSelected(true);
						// Set CC Cover Code Desc
						DBProcedures procedures = new DBProcedures();
						ArrayList<String> CodeDescList = procedures
								.helperP_VAL_COVER(pm_il_claim_cover
										.getCC_COVER_CODE(), null, "N", "N");
						if (CodeDescList != null && CodeDescList.size() != 0) {
							pm_il_claim_cover
									.setUI_M_CC_COVER_CODE_DESC(CodeDescList
											.get(0));
						}
						// Set Product Code Desc
						// P_VAL_PROD(pm_il_claim_cover,
						// pm_il_claim_cover.getCC_PROD_CODE(), null, "E");

						setPM_IL_CLAIM_COVER_BEAN(pm_il_claim_cover);
					} else {
						pm_il_claim_cover.setRowSelected(false);
					}
				}
			}

			return_String = "openscreen";
		} else {
		}
		return return_String;
	}

	public void postQuery() {
		ArrayList<String> CodeDescList = new ArrayList<String>();
		try {
			CodeDescList = DBProcedures.helperP_VAL_COVER(
					PM_IL_CLAIM_COVER_BEAN.getCC_COVER_CODE(), null, "N", "N");
			if (!CodeDescList.isEmpty()) {
				PM_IL_CLAIM_COVER_BEAN.setUI_M_CC_COVER_CODE_DESC(CodeDescList
						.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Bring_CC_COVER_CODE_DESC(ActionEvent ae) throws Exception {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) ae.getComponent().getParent();
		String FM_CODE_DESC = (String) input.getSubmittedValue();
		// PM_IL_CLAIM_COVER claimCoverBean = getCurrentBean();
		PM_IL_CLAIM_COVER_BEAN.setCC_COVER_CODE(FM_CODE_DESC);
		ArrayList<String> outputList = new DBProcedures().helperP_VAL_COVER(
				FM_CODE_DESC, null, "N", "E");
		PM_IL_CLAIM_COVER_BEAN.setUI_M_CC_COVER_CODE_DESC(outputList.get(0));
	}

	public void Bring_CC_PROD_CODE_DESC(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		System.out.println("Bring_CC_PROD_CODE_DESC");
		UIInput input = (UIInput) ae.getComponent().getParent();
		String PROD_CODE = (String) input.getSubmittedValue();
		// PM_IL_CLAIM_COVER claimCoverBean = getCurrentBean();
		// PM_IL_CLAIM_COVER PM_IL_CLAIM_COVER_BEAN =
		// this.PM_IL_CLAIM_COVER_BEAN;
		// claimCoverBean.setCC_PROD_CODE(PROD_CODE);
		// claimCoverBean.setUI_M_CC_PROD_CODE_DESC(ui_m_cc_prod_code_desc);
		P_VAL_PROD(PM_IL_CLAIM_COVER_BEAN, PROD_CODE, PM_IL_CLAIM_COVER_BEAN
				.getUI_M_CC_PROD_CODE_DESC(), "E");

	}

	public String getCoverCodeDescription() {

		System.out.println("Into Cover Code description method");
		COMP_UI_M_CC_COVER_CODE_DESC.setSubmittedValue(null);
		ResultSet resultSet = null;
		Connection connection = null;
		String coverCode = getCOMP_CC_COVER_CODE().getSubmittedValue()
				.toString();
		System.out.println("cover code is :" + coverCode);
		String query = "SELECT COVER_DESC " + "FROM PM_IL_COVER "
				+ "WHERE COVER_CODE = '" + coverCode + "'";
		String coverCodeDescription = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				COMP_UI_M_CC_COVER_CODE_DESC.setSubmittedValue(resultSet
						.getString(1));
				PM_IL_CLAIM_COVER_BEAN.setUI_M_CC_COVER_CODE_DESC(resultSet
						.getString(1));
				System.out.println("cover description is:"
						+ resultSet.getString(1));
				coverCodeDescription = resultSet.getString(1);
			}

		} catch (Exception exception) {
			exception.printStackTrace();

		} finally {

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return coverCodeDescription;
	}

	public String PreviousPage() {
		return "PILM038PreviousPage";
	}

	public HtmlOutputLabel getCOMP_UI_M_CC_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_CC_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CC_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_cc_prod_code_desc_label) {
		COMP_UI_M_CC_PROD_CODE_DESC_LABEL = comp_ui_m_cc_prod_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_CC_PROD_CODE_DESC() {
		return COMP_UI_M_CC_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_CC_PROD_CODE_DESC(
			HtmlInputText comp_ui_m_cc_prod_code_desc) {
		COMP_UI_M_CC_PROD_CODE_DESC = comp_ui_m_cc_prod_code_desc;
	}

	public void validator_CC_COVER_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws Exception {
		try {
			PM_IL_CLAIM_COVER_BEAN.setCC_COVER_CODE((String) value);
			when_validate_CC_COVER_CODE();
			COMP_UI_M_CC_COVER_CODE_DESC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}

	}

	public void when_validate_CC_COVER_CODE() throws Exception {
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		String M_TEMP2 = null;
		ArrayList<String> pValList = new ArrayList<String>();

		String sql_C2 = "SELECT ROWID" + "	    FROM   PM_IL_CLAIM_COVER"
				+ "	    WHERE  CC_CLAIM_TYPE = ?"
				+ "	    AND    CC_COVER_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			values = new Object[] { PM_IL_CLAIM_COVER_BEAN.getCC_CLAIM_TYPE(),
					PM_IL_CLAIM_COVER_BEAN.getCC_COVER_CODE() };
			resultSet = handler.executeSelectStatement(sql_C2, connection,
					values);
			if (resultSet.next()) {
				M_TEMP2 = resultSet.getString(1);
				CommonUtils.isDuplicate(M_TEMP2, PM_IL_CLAIM_COVER_BEAN
						.getROWID());
			}
			pValList = DBProcedures.helperP_VAL_COVER(PM_IL_CLAIM_COVER_BEAN
					.getCC_COVER_CODE(), null, "N", "E");
			if (!pValList.isEmpty()) {
				if (pValList.get(0) != null) {
					PM_IL_CLAIM_COVER_BEAN.setUI_M_CC_COVER_CODE_DESC(pValList
							.get(0));
				}
			}
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
	}

	public PM_IL_CLAIM_COVER getCurrentBean() {
		int rowIndex = getDataTable().getRowIndex();
		System.out
				.println("rowIndex>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + rowIndex);
		return getBeanList().get(rowIndex);
	}

	public void P_VAL_PROD(PM_IL_CLAIM_COVER claimCoverBean,
			String P_PROD_CODE, String P_PROD_DESC, String P_ERR_FLAG)
			throws ValidatorException {
		String query = "SELECT PROD_CODE,PROD_DESC,PROD_BL_DESC FROM PM_IL_PRODUCT "
				+ "WHERE  PROD_CODE = ?";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String M_PROD_CODE = null;
		String M_PROD_DESC = null;
		String M_PROD_BL_DESC = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection,
					new Object[] { P_PROD_CODE });
			while (rst.next()) {
				M_PROD_CODE = rst.getString("PROD_CODE");
				M_PROD_DESC = rst.getString("PROD_DESC");
				M_PROD_BL_DESC = rst.getString("PROD_BL_DESC");
			}
			rst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} catch (DBException e) {
			e.printStackTrace();
		}

		if (M_PROD_CODE == null) {
			if (P_ERR_FLAG.equals("W") || P_ERR_FLAG.equals("E")) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages",
						"91074"));
			}
		} else {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String M_FOR_LANG_CODE = (String) sessionMap
					.get("GLOBAL.M_FOR_LANG_CODE");
			String M_LANG_CODE = (String) sessionMap.get("GLOBAL.M_LANG_CODE");
			if (M_LANG_CODE.equals("ENG")
					|| M_FOR_LANG_CODE.substring(5, 6).equals("1")) {
				claimCoverBean.setUI_M_CC_PROD_CODE_DESC(M_PROD_DESC);
			} else {
				claimCoverBean.setUI_M_CC_PROD_CODE_DESC(M_PROD_BL_DESC);
			}
		}
	}

	public void validate_CC_EFF_FM_DATE(FacesContext context,
			UIComponent component, Object value) {
		PM_IL_CLAIM_COVER_BEAN.setCC_EFF_FM_DT((Date) value);
		try {

			if (CommonUtils.nvl(PM_IL_CLAIM_COVER_BEAN.getCC_EFF_FM_DT(),
					(CommonUtils.stringToUtilDate("01-JAN-1900"))).after(
					CommonUtils.nvl(PM_IL_CLAIM_COVER_BEAN.getCC_EFF_TO_DT(),
							(CommonUtils.stringToUtilDate("31-DEC-2999"))))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91010"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validate_CC_EFF_TO_DATE(FacesContext context,
			UIComponent component, Object value) {
		PM_IL_CLAIM_COVER_BEAN.setCC_EFF_TO_DT((Date) value);
		try {
			if (CommonUtils.nvl(PM_IL_CLAIM_COVER_BEAN.getCC_EFF_TO_DT(),
					(CommonUtils.stringToUtilDate("31-DEC-2999"))).before(
					CommonUtils.nvl(PM_IL_CLAIM_COVER_BEAN.getCC_EFF_FM_DT(),
							(CommonUtils.stringToUtilDate("01-JAN-1900"))))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91001"));
			}
			// COMP_CC_EFF_TO_DT.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<SelectItem> getClaimTypeList() {
		return claimTypeList;
	}

	public void setClaimTypeList(List<SelectItem> claimTypeList) {
		this.claimTypeList = claimTypeList;
	}

	public List<SelectItem> claimTyepList() {
		List<SelectItem> claimType = new ArrayList<SelectItem>();
		String claimTypeQuery = "SELECT PS_CODE, PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'IL_CLM_TYPE'";
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(claimTypeQuery,
					connection, new Object[] {});
			while (resultSet.next()) {
				claimType.add(new SelectItem(resultSet.getString("PS_CODE"),
						resultSet.getString("PS_CODE_DESC")));
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return claimType;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void effFromDateListener(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		PM_IL_CLAIM_COVER_BEAN.setCC_EFF_FM_DT(CommonUtils
				.stringToPelUtilDate((String) input.getSubmittedValue()));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void effToDateListener(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		PM_IL_CLAIM_COVER_BEAN.setCC_EFF_TO_DT(CommonUtils
				.stringToPelUtilDate((String) input.getSubmittedValue()));
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateClaimType(FacesContext context, UIComponent component,
			Object value) {

		PM_IL_CLAIM_COVER_BEAN.setCC_CLAIM_TYPE((String) value);
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public void setDescriptionForCoverandProductCode(
			PM_IL_CLAIM_COVER pm_il_claim_cover) {
		String claimCoverCode = pm_il_claim_cover.getCC_COVER_CODE();
		// String claimProductCode=pm_il_claim_cover.getCC_PROD_CODE();
		DBProcedures procedures = new DBProcedures();
		List<String> claimCoverCodeList = null;
		List<String> claimProductCodeList = null;
		try {
			if (claimCoverCode != null) {
				claimCoverCodeList = procedures.helperP_VAL_COVER(
						claimCoverCode, null, "N", "N");
				if (claimCoverCodeList != null
						&& claimCoverCodeList.size() == 0) {
					pm_il_claim_cover
							.setUI_M_CC_COVER_CODE_DESC(claimCoverCodeList
									.get(0));
				}
			}
			/*
			 * if(claimProductCode!=null){
			 * claimProductCodeList=procedures.helperP9GLPK_FMB_PGLT002$P_VAL_PROD(claimProductCode,
			 * "N", "N"); if(claimProductCodeList!=null &&
			 * claimProductCodeList.size()==0){
			 * pm_il_claim_cover.setUI_M_CC_PROD_CODE_DESC(claimProductCodeList.get(0)); } }
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated:
	// 17-Feb-2009 ]
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

	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated:
	// 17-Feb-2009 ]

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add
	 *            the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DEL
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	/**
	 * @param ui_m_but_del
	 *            the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post
	 *            the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public String getFilterByCC_COVER_CODE() {
		return filterByCC_COVER_CODE;
	}

	public void setFilterByCC_COVER_CODE(String filterByCC_COVER_CODE) {
		this.filterByCC_COVER_CODE = filterByCC_COVER_CODE;
	}

	/**
	 * @return the filterByCC_CLAIM_TYPE
	 */
	public String getFilterByCC_CLAIM_TYPE() {
		return filterByCC_CLAIM_TYPE;
	}

	/**
	 * @param filterByCC_CLAIM_TYPE
	 *            the filterByCC_CLAIM_TYPE to set
	 */
	public void setFilterByCC_CLAIM_TYPE(String filterByCC_CLAIM_TYPE) {
		this.filterByCC_CLAIM_TYPE = filterByCC_CLAIM_TYPE;
	}

	public void getDetails() {
		getWarningMap().clear();
		getErrorMap().clear();
		try {
			resetSelectedRow();
			PM_IL_CLAIM_COVER_BEAN = (PM_IL_CLAIM_COVER) dataTable.getRowData();
			postQuery();
			resetAllComponent();
			resetSelectedRow();
			PM_IL_CLAIM_COVER_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_CLAIM_COVER> iterator = beanList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String post() {
		// PM006_A_APAC_HELPER helper = new PM006_A_APAC_HELPER();
		try {
			if (PM_IL_CLAIM_COVER_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					pre_update();
					new CRUDHandler().executeInsert(PM_IL_CLAIM_COVER_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {
					pre_insert();
					new CRUDHandler().executeInsert(PM_IL_CLAIM_COVER_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					beanList.add(PM_IL_CLAIM_COVER_BEAN);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			}
			resetSelectedRow();
			PM_IL_CLAIM_COVER_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}

		return null;
	}

	private void resetAllComponent() {
		// COMP_CC_PROD_CODE.resetValue();
		COMP_CC_COVER_CODE.resetValue();
		COMP_CC_PROD_CODE_S.resetValue();
		COMP_UI_M_CC_COVER_CODE_DESC.resetValue();
		COMP_CC_EFF_FM_DT.resetValue();
		COMP_CC_EFF_TO_DT.resetValue();
		COMP_CC_FLEX_01.resetValue();
	}

	/**
	 * Add New component
	 * 
	 * @param event
	 */
	public void addRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_IL_CLAIM_COVER_BEAN = new PM_IL_CLAIM_COVER();
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

	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */
	/*
	 * public String deleteRow(ActionEvent ae) {
	 * 
	 * try { logger.info("Inside Delete Method"); if
	 * (getErrorMap().containsKey("current") ||
	 * getWarningMap().containsKey("current")) {
	 * getErrorMap().remove("current"); getWarningMap().remove("current"); } if
	 * (beanList != null) { DELETEROWS(ae); } if(beanList!=null &&
	 * !beanList.isEmpty()){ for(int i=0;i<beanList.size();i++){
	 * PM_IL_CLAIM_COVER pm_il_claim_cover = beanList.get(i); if(i==0){
	 * PM_IL_CLAIM_COVER_BEAN.setRowSelected(true);
	 * setPM_IL_CLAIM_COVER_BEAN(pm_il_claim_cover); }else{
	 * pm_il_claim_cover.setRowSelected(false); } } } resetAllComponent();
	 * }catch(Exception exception){ } return ""; }
	 */

	/**
	 * @return the cOMP_CC_COVER_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CC_COVER_TYPE_LABEL() {
		return COMP_CC_COVER_TYPE_LABEL;
	}

	/**
	 * @param comp_cc_cover_type_label
	 *            the cOMP_CC_COVER_TYPE_LABEL to set
	 */
	public void setCOMP_CC_COVER_TYPE_LABEL(
			HtmlOutputLabel comp_cc_cover_type_label) {
		COMP_CC_COVER_TYPE_LABEL = comp_cc_cover_type_label;
	}

	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable
	 *            the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the cOMP_ERROR_MESSAGE
	 */
	public HtmlOutputText getCOMP_ERROR_MESSAGE() {
		return COMP_ERROR_MESSAGE;
	}

	/**
	 * @param comp_error_message
	 *            the cOMP_ERROR_MESSAGE to set
	 */
	public void setCOMP_ERROR_MESSAGE(HtmlOutputText comp_error_message) {
		COMP_ERROR_MESSAGE = comp_error_message;
	}

	/**
	 * @return the lastUpdatedRowIndex
	 */
	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	/**
	 * @param lastUpdatedRowIndex
	 *            the lastUpdatedRowIndex to set
	 */
	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	/**
	 * @return the prevRowIndex
	 */
	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	/**
	 * @param prevRowIndex
	 *            the prevRowIndex to set
	 */
	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	/**
	 * @return the rowIndex
	 */
	public int getRowIndex() {
		return rowIndex;
	}

	/**
	 * @param rowIndex
	 *            the rowIndex to set
	 */
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	/**
	 * @return the handler
	 */
	public CRUDHandler getHandler() {
		return handler;
	}

	/**
	 * @param handler
	 *            the handler to set
	 */
	public void setHandler(CRUDHandler handler) {
		this.handler = handler;
	}

	/**
	 * @return the logger
	 */
	public static Log getLogger() {
		return logger;
	}

	/**
	 * @return the datatable
	 */
	public UIData getDatatable() {
		return datatable;
	}

	/**
	 * @param datatable
	 *            the datatable to set
	 */
	public void setDatatable(UIData datatable) {
		this.datatable = datatable;
	}

	/**
	 * @return the cOMP_CC_PROD_CODE_S
	 */
	public HtmlSelectOneMenu getCOMP_CC_PROD_CODE_S() {
		return COMP_CC_PROD_CODE_S;
	}

	/**
	 * @param comp_cc_prod_code_s
	 *            the cOMP_CC_PROD_CODE_S to set
	 */
	public void setCOMP_CC_PROD_CODE_S(HtmlSelectOneMenu comp_cc_prod_code_s) {
		COMP_CC_PROD_CODE_S = comp_cc_prod_code_s;
	}

	public String saveRecord() {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			String message = null;
			Connection connection = CommonUtils.getConnection();
			CommonUtils utils = new CommonUtils();
			utils.doComitt();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			getWarningMap().put("current", message);
			getWarningMap().put(
					"save",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public ArrayList<LovBean> lovCC_COVER_CODE(Object currValue) {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('PT_IL_POLICY.POL_STAFF_CCLASS_CODE','STAFF');
			suggestionList = listitemutil.P_CALL_LOV("PILM038",
					"PM_IL_CLAIM_COVER", "CC_COVER_CODE", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void pre_insert() throws Exception {
		String M_TEMP2 = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		String C1 = "  SELECT 'X'" + "	    FROM   PM_IL_CLAIM_COVER"
				+ "	    WHERE  CC_CLAIM_TYPE = ?"
				+ "	    AND    CC_COVER_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			PM_IL_CLAIM_COVER_BEAN.setCC_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_CLAIM_COVER_BEAN.setCC_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			values = new Object[] { PM_IL_CLAIM_COVER_BEAN.getCC_CLAIM_TYPE(),
					PM_IL_CLAIM_COVER_BEAN.getCC_COVER_CODE() };
			resultSet = handler.executeSelectStatement(C1, connection, values);
			if (resultSet.next()) {
				M_TEMP2 = resultSet.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91028"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void pre_update() throws SQLException, Exception {
		try {
			connection = CommonUtils.getConnection();

			PM_IL_CLAIM_COVER_BEAN.setCC_UPD_DT(new java.sql.Date(Calendar
					.getInstance().getTimeInMillis()));
			PM_IL_CLAIM_COVER_BEAN.setCC_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				getErrorMap().clear();
				getWarningMap().clear();
				executeQuery();
				postQuery();
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void executeQuery() {
		Connection connection = null;
		ResultSet resultSet = null;
		String C1 = " select ROWID,PM_IL_CLAIM_COVER.* from PM_IL_CLAIM_COVER ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection);
			while (resultSet.next()) {
				PM_IL_CLAIM_COVER pm_il_claim_cover_bean = new PM_IL_CLAIM_COVER();
				pm_il_claim_cover_bean.setROWID(resultSet.getString("ROWID"));
				pm_il_claim_cover_bean.setCC_CLAIM_TYPE(resultSet
						.getString("CC_CLAIM_TYPE"));
				pm_il_claim_cover_bean.setCC_COVER_CODE(resultSet
						.getString("CC_COVER_CODE"));
				pm_il_claim_cover_bean.setCC_CR_DT(resultSet
						.getDate("CC_CR_DT"));
				pm_il_claim_cover_bean.setCC_CR_UID("CC_CR_UID");
				pm_il_claim_cover_bean.setCC_EFF_FM_DT(resultSet
						.getDate("CC_EFF_FM_DT"));
				pm_il_claim_cover_bean.setCC_EFF_TO_DT(resultSet
						.getDate("CC_EFF_TO_DT"));
				pm_il_claim_cover_bean.setCC_UPD_DT(resultSet
						.getDate("CC_UPD_DT"));
				pm_il_claim_cover_bean.setCC_UPD_UID(resultSet
						.getString("CC_UPD_UID"));
				this.getBeanList().add(pm_il_claim_cover_bean);
			}
			if (getBeanList().size() > 0) {
				setPM_IL_CLAIM_COVER_BEAN(getBeanList().get(0));
				PM_IL_CLAIM_COVER_BEAN.setRowSelected(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.commit();
				CommonUtils.closeCursor(resultSet);
			} catch (Exception exception) {
			}
		}
	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(PM_IL_CLAIM_COVER_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				beanList.remove(PM_IL_CLAIM_COVER_BEAN);
				if (beanList.size() > 0) {

					PM_IL_CLAIM_COVER_BEAN = beanList.get(0);
				} else if (beanList.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_CLAIM_COVER_BEAN.setRowSelected(true);
			} else {

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

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}
	

		/**
		 * Instantiates all components in PM_IL_CLAIM_COVER_ACTION
		 */
		public void instantiateAllComponent(){
			// Instantiating HtmlInputText
			COMP_CC_COVER_CODE				 = new HtmlInputText();
			COMP_UI_M_CC_COVER_CODE_DESC			 = new HtmlInputText();
			COMP_UI_M_CC_PROD_CODE_DESC			 = new HtmlInputText();
			COMP_CC_FLEX_01					 = new HtmlInputText();

			// Instantiating HtmlSelectOneMenu
			COMP_CC_PROD_CODE_S				 = new HtmlSelectOneMenu();

			// Instantiating HtmlCalendar
			COMP_CC_EFF_FM_DT				 = new HtmlCalendar();
			COMP_CC_EFF_TO_DT				 = new HtmlCalendar();

			// Instantiating HtmlCommandButton
			COMP_UI_M_LOV_BUT_CODE				 = new HtmlCommandButton();
			test						 = new HtmlCommandButton();
			COMP_UI_M_BUT_LOV_COVER_CODE			 = new HtmlCommandButton();

		}



	public HtmlOutputLabel getCOMP_CC_FLEX_01_LABEL() {
		return COMP_CC_FLEX_01_LABEL;
	}

	public void setCOMP_CC_FLEX_01_LABEL(HtmlOutputLabel comp_cc_flex_01_label) {
		COMP_CC_FLEX_01_LABEL = comp_cc_flex_01_label;
	}

	public HtmlInputText getCOMP_CC_FLEX_01() {
		return COMP_CC_FLEX_01;
	}

	public void setCOMP_CC_FLEX_01(HtmlInputText comp_cc_flex_01) {
		COMP_CC_FLEX_01 = comp_cc_flex_01;
	}
}