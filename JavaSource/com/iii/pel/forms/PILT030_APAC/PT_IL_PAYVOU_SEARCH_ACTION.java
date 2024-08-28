package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PAYVOU_SEARCH_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_PAH_REF_NO_LABEL;

	private HtmlInputText COMP_UI_M_PAH_REF_NO;

	private HtmlOutputLabel COMP_UI_M_PAH_TYPE_LABEL;

	private HtmlInputText COMP_UI_M_PAH_TYPE;

	private HtmlOutputLabel COMP_UI_M_PAH_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PAH_DT;

	private UIData PT_IL_PAYVOU_SEARCH_DT;

	private List<PT_IL_PAYVOU_HDR> PT_IL_PAYVOU_SEARCH_LIST;

	private PT_IL_PAYVOU_SEARCH PT_IL_PAYVOU_SEARCH_BEAN;

	public PT_IL_PAYVOU_SEARCH_ACTION() {
		PT_IL_PAYVOU_SEARCH_BEAN = new PT_IL_PAYVOU_SEARCH();
		PT_IL_PAYVOU_SEARCH_LIST = new ArrayList<PT_IL_PAYVOU_HDR>();
	}

	public HtmlOutputLabel getCOMP_UI_M_PAH_REF_NO_LABEL() {
		return COMP_UI_M_PAH_REF_NO_LABEL;
	}

	public void setCOMP_UI_M_PAH_REF_NO_LABEL(
			HtmlOutputLabel comp_ui_m_pah_ref_no_label) {
		COMP_UI_M_PAH_REF_NO_LABEL = comp_ui_m_pah_ref_no_label;
	}

	public HtmlInputText getCOMP_UI_M_PAH_REF_NO() {
		return COMP_UI_M_PAH_REF_NO;
	}

	public void setCOMP_UI_M_PAH_REF_NO(HtmlInputText comp_ui_m_pah_ref_no) {
		COMP_UI_M_PAH_REF_NO = comp_ui_m_pah_ref_no;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAH_TYPE_LABEL() {
		return COMP_UI_M_PAH_TYPE_LABEL;
	}

	public void setCOMP_UI_M_PAH_TYPE_LABEL(
			HtmlOutputLabel comp_ui_m_pah_type_label) {
		COMP_UI_M_PAH_TYPE_LABEL = comp_ui_m_pah_type_label;
	}

	public HtmlInputText getCOMP_UI_M_PAH_TYPE() {
		return COMP_UI_M_PAH_TYPE;
	}

	public void setCOMP_UI_M_PAH_TYPE(HtmlInputText comp_ui_m_pah_type) {
		COMP_UI_M_PAH_TYPE = comp_ui_m_pah_type;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAH_DT_LABEL() {
		return COMP_UI_M_PAH_DT_LABEL;
	}

	public void setCOMP_UI_M_PAH_DT_LABEL(HtmlOutputLabel comp_ui_m_pah_dt_label) {
		COMP_UI_M_PAH_DT_LABEL = comp_ui_m_pah_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_PAH_DT() {
		return COMP_UI_M_PAH_DT;
	}

	public void setCOMP_UI_M_PAH_DT(HtmlCalendar comp_ui_m_pah_dt) {
		COMP_UI_M_PAH_DT = comp_ui_m_pah_dt;
	}

	public UIData getPT_IL_PAYVOU_SEARCH_DT() {
		return PT_IL_PAYVOU_SEARCH_DT;
	}

	public void setPT_IL_PAYVOU_SEARCH_DT(UIData pt_il_payvou_search_dt) {
		PT_IL_PAYVOU_SEARCH_DT = pt_il_payvou_search_dt;
	}

	public List<PT_IL_PAYVOU_HDR> getPT_IL_PAYVOU_SEARCH_LIST() {
		return PT_IL_PAYVOU_SEARCH_LIST;
	}

	public void setPT_IL_PAYVOU_SEARCH_LIST(
			List<PT_IL_PAYVOU_HDR> pt_il_payvou_search_list) {
		PT_IL_PAYVOU_SEARCH_LIST = pt_il_payvou_search_list;
	}

	public PT_IL_PAYVOU_SEARCH getPT_IL_PAYVOU_SEARCH_BEAN() {
		return PT_IL_PAYVOU_SEARCH_BEAN;
	}

	public void setPT_IL_PAYVOU_SEARCH_BEAN(
			PT_IL_PAYVOU_SEARCH pt_il_payvou_search_bean) {
		PT_IL_PAYVOU_SEARCH_BEAN = pt_il_payvou_search_bean;
	}

	public void fetchRecords() {
		// Map<String, Object> sessionMap =
		// PILT030_APAC_ACTION_INSTANCE.getSessionMap();
		String M_PARAM_1 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		System.out.println("M_PARAM_1::::::::::************&&&&&&&&&&&&&&&"
				+ M_PARAM_1);
		PT_IL_PAYVOU_SEARCH_ACTION searchAction = PILT030_APAC_ACTION_INSTANCE
				.getSearchActionInstance();
		String M_PAH_REF_NO = searchAction.getPT_IL_PAYVOU_SEARCH_BEAN()
				.getPAH_REF_NO();
		if (M_PAH_REF_NO == null) {
			M_PAH_REF_NO = "%";
		} else {
			M_PAH_REF_NO += "%";
		}
		Date M_PAH_DT = searchAction.getPT_IL_PAYVOU_SEARCH_BEAN().getPAH_DT();
		String sql_C1 = null;
		Object[] values = null;
		List<PT_IL_PAYVOU_HDR> hdrList = new ArrayList<PT_IL_PAYVOU_HDR>();
		if (M_PAH_DT != null) {
			SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String PAH_DATE = df.format(M_PAH_DT);
			sql_C1 = "SELECT PT_IL_PAYVOU_HDR.ROWID, PAH_CONTROL_NO,PAH_REF_NO,PAH_PRO_DT, PAH_APPRV_DT "
					+ "FROM PT_IL_PAYVOU_HDR"
					+ "WHERE PAH_TYPE = ? "
					+ "AND PAH_REF_NO LIKE ? "
					+ "AND TO_DATE(?,'DD/MM/RRRR') BETWEEN TO_DATE(PAH_FM_DT,'DD/MM/RRRR') "
					+ "AND TO_DATE(PAH_TO_DT,'DD/MM/RRRR')";
			values = new Object[] { M_PARAM_1, M_PAH_REF_NO, PAH_DATE };
		} else {

			if (null == M_PAH_REF_NO || M_PAH_REF_NO.isEmpty()||M_PAH_REF_NO.equalsIgnoreCase("%")) { 
				sql_C1 = "SELECT PT_IL_PAYVOU_HDR.ROWID, PAH_CONTROL_NO,PAH_REF_NO,PAH_PRO_DT, PAH_APPRV_DT "
						+ "FROM PT_IL_PAYVOU_HDR " + "WHERE PAH_TYPE = ? ";
				values = new Object[] { M_PARAM_1 };
			} else {
				sql_C1 = "SELECT PT_IL_PAYVOU_HDR.ROWID, PAH_CONTROL_NO,PAH_REF_NO,PAH_PRO_DT, PAH_APPRV_DT "
						+ "FROM PT_IL_PAYVOU_HDR "
						+ "WHERE PAH_TYPE = ? "
						+ "AND PAH_REF_NO LIKE ? ";
				values = new Object[] { M_PARAM_1, M_PAH_REF_NO };

			}
		}
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		if (M_PARAM_1 != null) {
			if (M_PARAM_1.equals("CL")) {
				ResultSet rst_C1 = null;
				try {
					rst_C1 = handler.executeSelectStatement(sql_C1, connection,
							values);
					if(rst_C1.next()) {
						PT_IL_PAYVOU_HDR hdrBean = new PT_IL_PAYVOU_HDR();
						hdrBean.setROWID(rst_C1.getString(1));
						hdrBean.setPAH_CONTROL_NO(rst_C1
								.getString("PAH_CONTROL_NO"));
						hdrBean.setPAH_REF_NO(rst_C1.getString("PAH_REF_NO"));
						hdrBean.setPAH_PRO_DT(rst_C1.getDate("PAH_PRO_DT"));
						hdrBean.setPAH_APPRV_DT(rst_C1.getDate("PAH_APPRV_DT"));
						hdrBean
								.setUI_M_CLAIM_POL_NO(getClaimPolicyNumber(M_PAH_REF_NO));
						hdrList.add(hdrBean);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				} finally {
					try {
						CommonUtils.closeCursor(rst_C1);
					} catch (Exception e) {
						throw new ValidatorException(new FacesMessage(e
								.getMessage()));
					}
				}
			} else if (M_PARAM_1.equals("PS")) {
				ResultSet rst_C1 = null;
				try {
					rst_C1 = handler.executeSelectStatement(sql_C1, connection,
							values);
					while (rst_C1.next()) {
						PT_IL_PAYVOU_HDR hdrBean = new PT_IL_PAYVOU_HDR();
						hdrBean.setROWID(rst_C1.getString(1));
						hdrBean.setPAH_CONTROL_NO(rst_C1
								.getString("PAH_CONTROL_NO"));
						hdrBean.setPAH_REF_NO(rst_C1.getString("PAH_REF_NO"));
						hdrBean.setPAH_PRO_DT(rst_C1.getDate("PAH_PRO_DT"));
						hdrBean.setPAH_APPRV_DT(rst_C1.getDate("PAH_APPRV_DT"));
						hdrList.add(hdrBean);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new ValidatorException(new FacesMessage(e
							.getMessage()));
				} finally {
					try {
						CommonUtils.closeCursor(rst_C1);
					} catch (Exception e) {
						throw new ValidatorException(new FacesMessage(e
								.getMessage()));
					}
				}
			}
		}
		setPT_IL_PAYVOU_SEARCH_LIST(hdrList);
	}

	public String getClaimPolicyNumber(String M_PAH_REF_NO)
			throws ValidatorException {
		String sql_C2 = "SELECT CLAIM_POL_NO FROM PT_IL_CLAIM WHERE CLAIM_NO=?";
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst_C2 = null;
		String policyNo = null;
		try {
			rst_C2 = handler.executeSelectStatement(sql_C2, connection,
					new Object[] { M_PAH_REF_NO });
			while (rst_C2.next()) {
				policyNo = rst_C2.getString("CLAIM_POL_NO");
			}
		} catch (SQLException e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst_C2);
			} catch (Exception e) {
			}
		}
		return policyNo;
	}

	public String clearList() {
		setPT_IL_PAYVOU_SEARCH_LIST(null);
		PILT030_APAC_ACTION_INSTANCE.getSessionMap().put("CALLING_FORM",
				"PILT030_APAC_SEARCH");
		
		
		
		String M_PARAM_1 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		
		System.out.println("M_PARAM_1........."+M_PARAM_1);
		
		CommonUtils.setGlobalVariable("DUMMY.M_PAH_TYPE", M_PARAM_1);
		
		System.out.println("CommonUtils.getGlobalVariable DUMMY.M_PAH_TYPE "+CommonUtils.getGlobalVariable("DUMMY.M_PAH_TYPE"));
		
		return "payVoucherHeader";
	}

	public String insertClaim() {
		setPT_IL_PAYVOU_SEARCH_LIST(null);
		PILT030_APAC_ACTION_INSTANCE.getSessionMap().put("CALLING_FORM",
				"PILT030_APAC_SEARCH");
		String M_PARAM_1 = (String) PILT030_APAC_ACTION_INSTANCE
				.getSessionMap().get("GLOBAL.M_PARAM_1");
		PILT030_APAC_ACTION_INSTANCE.getSessionMap().put("DUMMY.M_PAH_TYPE",
				M_PARAM_1);
		return "payVoucherHeader";
	}

}
