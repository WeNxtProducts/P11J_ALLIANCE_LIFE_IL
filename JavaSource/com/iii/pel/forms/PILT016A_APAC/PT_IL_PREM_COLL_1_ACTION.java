package com.iii.pel.forms.PILT016A_APAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PREM_COLL_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_UI_M_LC_NET_PREM_LABEL;

	private HtmlInputText COMP_UI_M_LC_NET_PREM;

	private HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_PC_PAID_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PC_PAID_FLAG;

	private HtmlOutputLabel COMP_PC_PREM_HOLIDAY_YN_LABEL;

	private HtmlSelectOneMenu COMP_PC_PREM_HOLIDAY_YN;

	private HtmlOutputLabel COMP_UI_M_TOT_OUT_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_TOT_OUT_LC_AMT;
	
	private HtmlInputText COMP_UI_M_PROP_AVLB;
	
	private HtmlInputText COMP_UI_M_POL_AVLB;

	private PT_IL_PREM_COLL_1 PT_IL_PREM_COLL_1_BEAN;

	private List<SelectItem> paidFlagComboList = new ArrayList<SelectItem>();
	private List<SelectItem> holidayComboList = new ArrayList<SelectItem>();

	private UIData collectionTable;
	private List<PT_IL_PREM_COLL_1> collectionDetailList;

	private int currPage;
	private int recordsPerPage = 5;
	private int lastUpdatedRowIndex;
	private int prevRowIndex;
	private String currentMode;

	private HtmlCommandButton UI_BUT_ADD;
	private HtmlCommandButton UI_BUT_POST;
	private HtmlCommandButton UI_BUT_DELETE;

	/**
	 * 
	 * @param e
	 */
	public void loadingBaseValues(PhaseEvent e) {
		try {

			if (isFormFlag()) {
				// preForm();
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				whenNewBLOCK_INSTANCE(compositeAction);
				preQuery(compositeAction);
				executeQuery(compositeAction);
				chkHolidayYN();
				setBlockFlag(false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					ex.getMessage());
			getErrorMap().put("onLoad", ex.getMessage());
		}
		// PT_IL_DEPOSIT_BEAN.setApprovalStatus(true);
	}

	public void chkHolidayYN() throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String planType = null;
		String query = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE IN "
				+ " (SELECT POL_PLAN_CODE FROM PT_IL_POLICY WHERE POL_NO=?)";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query,
					connection, new Object[] { compositeAction
							.getPT_IL_DEPOSIT_ACTION_BEAN()
							.getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO() });
			if (resultSet.next()) {
				planType = resultSet.getString(1);
			}
			if ("U".equals(planType)) {
				COMP_PC_PREM_HOLIDAY_YN.setDisabled(false);
			} else {
				COMP_PC_PREM_HOLIDAY_YN.setDisabled(true);
			}

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

	}

	public List<PT_IL_PREM_COLL_1> getCollectionDetailList() {
		/*
		 * int size = collectionDetailList.size(); if(size < 5 ) { for(int i=0 ;
		 * i < 5-size ; i++ ) { collectionDetailList.add(new
		 * PT_IL_PREM_COLL_1()); } }
		 */

		// collectionDetailList = pre_query();
		/*
		 * if(collectionDetailList.size()>0){ double PC_LC_GROSS_PREM =0.0;
		 * double PC_LC_CHARGE = 0.0; double PC_LC_UNPAID_PREM_INT = 0.0; double
		 * sumAmount = 0.0;
		 * 
		 * for (Iterator iterator = collectionDetailList.iterator();
		 * iterator.hasNext();) { PT_IL_PREM_COLL_1 bean = (PT_IL_PREM_COLL_1)
		 * iterator.next();
		 * 
		 * 
		 * if(bean.getPC_LC_GROSS_PREM()==null){ PC_LC_GROSS_PREM= 0;} else{
		 * PC_LC_GROSS_PREM = bean.getPC_LC_GROSS_PREM(); }
		 * 
		 * if(bean.getPC_LC_CHARGE()==null){ PC_LC_CHARGE= 0;} else{
		 * PC_LC_CHARGE = bean.getPC_LC_CHARGE(); }
		 * 
		 * if(bean.getPC_LC_UNPAID_PREM_INT()==null){ PC_LC_UNPAID_PREM_INT= 0;}
		 * else{ PC_LC_UNPAID_PREM_INT = bean.getPC_LC_UNPAID_PREM_INT(); }
		 * 
		 * bean.setUI_M_LC_NET_PREM(PC_LC_GROSS_PREM+PC_LC_CHARGE+PC_LC_UNPAID_PREM_INT);
		 * sumAmount = sumAmount + PC_LC_GROSS_PREM + PC_LC_CHARGE +
		 * PC_LC_UNPAID_PREM_INT;
		 * 
		 * getCOMP_PC_PAID_FLAG().setSubmittedValue(bean.getPC_PAID_FLAG());
		 * getCOMP_PC_PREM_HOLIDAY_YN().setSubmittedValue(bean.getPC_PREM_HOLIDAY_YN());
		 * getCOMP_UI_M_TOT_OUT_LC_AMT().setSubmittedValue(String.valueOf(sumAmount));
		 * 
		 *  }
		 */// End For
		// }
		for (Iterator iterator = collectionDetailList.iterator();
		  iterator.hasNext();) { PT_IL_PREM_COLL_1 bean = (PT_IL_PREM_COLL_1)
		 iterator.next();
		
		bean.setUI_M_LC_NET_PREM(CommonUtils.nvl(bean.getPC_LC_GROSS_PREM(),0.0)+CommonUtils.nvl(bean.getPC_LC_CHARGE(),0.0)+CommonUtils.nvl(bean.getPC_LC_UNPAID_PREM_INT(),0.0));
		bean.setPC_LC_AVLB_BAL_AMT(CommonUtils.nvl(bean.getPC_LC_AVLB_BAL_AMT(),0.0));
		}
		return collectionDetailList;
	}// end func

	private void pre_query() {
		List fetchList = null;
		ResultSet rs = null;
		ResultSet rs0 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		String DS_TYPE = null;
		String PROP_NO = null;
		
		try {

			FacesContext context = FacesContext.getCurrentInstance();
			Map sessionMap = context.getExternalContext().getSessionMap();
			String DEP_REF_NO = compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO();
			Connection connection = CommonUtils.getConnection();
			/*
			 * PT_IL_DEPOSIT_ACTION actionBean =
			 * (PT_IL_DEPOSIT_ACTION)sessionMap.get("PILT016A_APAC_PT_IL_DEPOSIT_ACTION");
			 * String DEP_REF_NO =
			 * actionBean.getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO();
			 */

			// String query = "SELECT DISTINCT
			// A.PC_SCHD_PYMT_DT,A.PC_LC_AVLB_BAL_AMT,A.PC_PAID_FLAG,A.PC_PREM_HOLIDAY_YN
			// FROM PT_IL_PREM_COLL A,PT_IL_POLICY B, PT_IL_DEPOSIT C WHERE
			// A.PC_PAID_FLAG IN ('A','Y') AND B.POL_NO = C.DEP_REF_NO AND
			// A.PC_POL_SYS_ID = B.POL_SYS_ID AND B.POL_DS_TYPE='2' AND
			// B.POL_NO='SISWA\\2001\\00001\\7'";
			String query0 = "SELECT POL_DS_TYPE FROM PT_IL_POLICY WHERE POL_NO = ?";
			
			String query1 = "SELECT DISTINCT A.*, C.DEP_PLAN_CODE FROM PT_IL_PREM_COLL A,PT_IL_POLICY B, PT_IL_DEPOSIT C WHERE A.PC_PAID_FLAG IN ('N','Y') AND B.POL_NO = C.DEP_REF_NO AND A.PC_POL_SYS_ID = B.POL_SYS_ID AND B.POL_DS_TYPE='2' AND B.POL_NO='"
					+ DEP_REF_NO + "'";
			System.out.println("PT_IL_PREM_COLL_1_ACTION.pre_query() query1: "
					+ query1);
			String DEP_PLAN_CODE = null;
			String M_PLAN_TYPE = null;
			boolean updateAllowed = false;

			CRUDHandler handler = new CRUDHandler();
			
			rs0 = handler.executeSelectStatement(query0, connection, new Object[]{DEP_REF_NO});
			while (rs0.next()) {
				DS_TYPE = rs0.getString(1);
				System.out.println("DS_TYPE" + DS_TYPE);
			}
			
			
			fetchList = handler.fetch(query1,
					"com.iii.pel.forms.PILT016A_APAC.PT_IL_PREM_COLL_1",
					getConnection());

			// When-new-block-instance//
			PreparedStatement psmt = getConnection().prepareStatement(query1);
			rs = psmt.executeQuery(query1);

			while (rs.next()) {
				DEP_PLAN_CODE = rs.getString("DEP_PLAN_CODE");
				System.out.println("DEP_PLAN_CODE" + DEP_PLAN_CODE);
			}

			String cursor1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
			psmt = getConnection().prepareStatement(cursor1);
			psmt.setString(1, DEP_PLAN_CODE);
			while (rs.next()) {
				M_PLAN_TYPE = rs.getString(1);

				if (M_PLAN_TYPE.equalsIgnoreCase("U")) {
					updateAllowed = true;
					// if(rs.getString("DEP_DOC_NO")==null) updateAllowed =
					// true;
				} else {
					updateAllowed = false;
					System.out.println("updateAllowed" + updateAllowed);
				}
			}

			System.out.println("updateAllowed====" + updateAllowed);

			// Calculate M_PROP_AVLB value //
			double M_PROP_AVLB = 0;
			String query2 = "SELECT distinct NVL(B.CONT_LC_PROP_DEP_AMT,0)-NVL(B.CONT_LC_PROP_UTIL_AMT,0) FROM PT_IL_DEPOSIT A,PM_IL_CONTRACTOR B WHERE A.DEP_REF_NO = '"
					+ DEP_REF_NO + "' AND A.DEP_CONT_CODE=B.CONT_CODE";
			System.out
					.println("PT_IL_PREM_COLL_1_ACTION.pre_query() UI_M_PROP_AVLB query2: "
							+ query2);
			if("1".equalsIgnoreCase(DS_TYPE)){
			psmt = getConnection().prepareStatement(query2);
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
				M_PROP_AVLB = Double.valueOf(rs.getString(1));
				/*
				 * getCOMP_UI_M_TOT_OUT_LC_AMT().setSubmittedValue(String.valueOf(M_TOT_OUT_LC_AMT));
				 * getCOMP_UI_M_TOT_OUT_LC_AMT().updateModel(FacesContext.getCurrentInstance());
				 */
				PT_IL_PREM_COLL_1_BEAN.setUI_M_PROP_AVLB(M_PROP_AVLB);
				}
			}else{
				PT_IL_PREM_COLL_1_BEAN.setUI_M_PROP_AVLB(0.0);
			}
			// Calculate M_POL_AVLB value //
			double M_POL_AVLB = 0;
			/*String query3 = "SELECT distinct NVL(B.CONT_LC_POL_DEP_AMT,0)-NVL(B.CONT_LC_POL_UTIL_AMT,0)FROM PT_IL_DEPOSIT A,PM_IL_CONTRACTOR B WHERE A.DEP_REF_NO = ?"
					 +" AND A.DEP_CONT_CODE=B.CONT_CODE";*/
			String query = "SELECT POL_PROP_NO FROM PT_IL_POLICY WHERE POL_NO = ?";
			String query3 ="SELECT distinct NVL(B.CONT_LC_POL_DEP_AMT,0)-NVL(B.CONT_LC_POL_UTIL_AMT,0)FROM PT_IL_DEPOSIT A,PM_IL_CONTRACTOR B WHERE (A.DEP_REF_NO = ? OR A.DEP_REF_NO = ?)   AND A.DEP_CONT_CODE=B.CONT_CODE";
			
			System.out
					.println("PT_IL_PREM_COLL_1_ACTION.pre_query() UI_M_POL_AVLB query3: "
							+ query3);
			if("2".equalsIgnoreCase(DS_TYPE)){
				rs3 = handler.executeSelectStatement(query, connection,new Object[]{DEP_REF_NO});
				while(rs3.next()){
					PROP_NO = rs3.getString(1);
				}
				rs2 = handler.executeSelectStatement(query3, connection, new Object[]{PROP_NO,DEP_REF_NO});
				
			while (rs2.next()) {
				System.out.println(rs2.getString(1));
				M_POL_AVLB = Double.valueOf(rs2.getString(1));
				/*
				 * getCOMP_UI_M_TOT_OUT_LC_AMT().setSubmittedValue(String.valueOf(M_TOT_OUT_LC_AMT));
				 * getCOMP_UI_M_TOT_OUT_LC_AMT().updateModel(FacesContext.getCurrentInstance());
				 */
				PT_IL_PREM_COLL_1_BEAN.setUI_M_POL_AVLB(M_POL_AVLB);
				}
			}else{
				PT_IL_PREM_COLL_1_BEAN.setUI_M_POL_AVLB(0.0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs);
				CommonUtils.closeCursor(rs0);
				CommonUtils.closeCursor(rs2);
				CommonUtils.closeCursor(rs3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//return fetchList;
	}

	/**
	 * 
	 * @param compositeAction
	 */
	public void preQuery(PILT016A_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		Connection connection = null;
		String C1 = "SELECT POL_SYS_ID   FROM   PT_IL_POLICY  WHERE  POL_NO = ? AND POL_DS_TYPE='2' ";
		Long M_POL_SYS_ID = null;
		String M_WHERE = null;
		PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = compositeAction
				.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN();
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
			if (resultSet.next()) {
				M_POL_SYS_ID = resultSet.getLong(1);
			}
			if (M_POL_SYS_ID == null) {
				M_WHERE = "PC_POL_SYS_ID IS " + M_POL_SYS_ID
						+ " AND  PC_PAID_FLAG = 'N'";
			} else {
				M_WHERE = "PC_POL_SYS_ID = '" + M_POL_SYS_ID
						+ "'  AND  PC_PAID_FLAG = 'N'";
			}
			CommonUtils.setGlobalVariable("PT_IL_PREM_COLL_1_DEFAULT_WHERE",
					M_WHERE);
			pre_query();
			COMP_UI_M_PROP_AVLB.resetValue();
			COMP_UI_M_POL_AVLB.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void whenNewBLOCK_INSTANCE(
			PILT016A_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		Connection connection = null;
		String C1 = "SELECT PLAN_TYPE   FROM   PM_IL_PLAN  WHERE  PLAN_CODE = ? ";
		String M_PLAN_TYPE = null;
		PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = compositeAction
				.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN();
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_PLAN_CODE() });
			if (resultSet.next()) {
				M_PLAN_TYPE = resultSet.getString(1);
			}
			if ("U".equalsIgnoreCase(M_PLAN_TYPE)
					&& PT_IL_DEPOSIT_BEAN.getDEP_TXN_CODE() == null
					&& PT_IL_DEPOSIT_BEAN.getDEP_DOC_NO() == 0
			// && PT_IL_DEPOSIT_BEAN.getDEP_DOC_DT()==null
			) {
				compositeAction.getPT_IL_PREM_COLL_1_ACTION_BEAN()
						.getCOMP_PC_PREM_HOLIDAY_YN().setDisabled(false);
			} else {
				compositeAction.getPT_IL_PREM_COLL_1_ACTION_BEAN()
						.getCOMP_PC_PREM_HOLIDAY_YN().setDisabled(true);
			}
		} catch (Exception exception) {
			throw exception;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	/**
	 * 
	 * @param compositeAction
	 */
	public void executeQuery(PILT016A_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		Connection connection = null;
		PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = compositeAction
				.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN();
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String WHERE = CommonUtils
					.getGlobalVariable("PT_IL_PREM_COLL_1_DEFAULT_WHERE");
			String query1 = "SELECT DISTINCT A.*,ROWID FROM PT_IL_PREM_COLL A WHERE "
					+ WHERE;

			List<PT_IL_PREM_COLL_1> fetchList = handler.fetch(query1,
					"com.iii.pel.forms.PILT016A_APAC.PT_IL_PREM_COLL_1",
					getConnection());
			setCollectionDetailList(fetchList);

			if (getCollectionDetailList() != null
					&& !getCollectionDetailList().isEmpty()) {
				PT_IL_PREM_COLL_1 pt_il_prem_coll_1 = getCollectionDetailList()
						.get(0);
				pt_il_prem_coll_1.setRowSelected(true);
				setPT_IL_PREM_COLL_1_BEAN(pt_il_prem_coll_1);
			}
			pre_query();

		} catch (Exception exception) {
			throw exception;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public void whenNewRecordInstance() {
		// null;
	}

	public void setCollectionDetailList(
			List<PT_IL_PREM_COLL_1> collectionDetailList) {
		this.collectionDetailList = collectionDetailList;
	}

	PILT016A_APAC_COMPOSITE_ACTION compositeAction;

	public PT_IL_PREM_COLL_1_ACTION() {
		PT_IL_PREM_COLL_1_BEAN = new PT_IL_PREM_COLL_1();
		collectionDetailList = new ArrayList<PT_IL_PREM_COLL_1>();
		instantiateAllComponent();
	}

	/**
	 * 
	 */
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_PREM_COLL_1_BEAN = (PT_IL_PREM_COLL_1) collectionTable
					.getRowData();
			PT_IL_PREM_COLL_1_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_PREM_COLL_1> PT_GL_POL_EMP_COVER_ITR = collectionDetailList
				.iterator();
		while (PT_GL_POL_EMP_COVER_ITR.hasNext()) {
			PT_GL_POL_EMP_COVER_ITR.next().setRowSelected(false);
		}
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

	public HtmlOutputLabel getCOMP_UI_M_LC_NET_PREM_LABEL() {
		return COMP_UI_M_LC_NET_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_NET_PREM() {
		return COMP_UI_M_LC_NET_PREM;
	}

	public void setCOMP_UI_M_LC_NET_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_LC_NET_PREM_LABEL) {
		this.COMP_UI_M_LC_NET_PREM_LABEL = COMP_UI_M_LC_NET_PREM_LABEL;
	}

	public void setCOMP_UI_M_LC_NET_PREM(HtmlInputText COMP_UI_M_LC_NET_PREM) {
		this.COMP_UI_M_LC_NET_PREM = COMP_UI_M_LC_NET_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_AVLB_BAL_AMT() {
		return COMP_PC_LC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT_LABEL(
			HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_LC_AVLB_BAL_AMT_LABEL = COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT(HtmlInputText COMP_PC_LC_AVLB_BAL_AMT) {
		this.COMP_PC_LC_AVLB_BAL_AMT = COMP_PC_LC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_PAID_FLAG_LABEL() {
		return COMP_PC_PAID_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PC_PAID_FLAG() {
		return COMP_PC_PAID_FLAG;
	}

	public void setCOMP_PC_PAID_FLAG_LABEL(
			HtmlOutputLabel COMP_PC_PAID_FLAG_LABEL) {
		this.COMP_PC_PAID_FLAG_LABEL = COMP_PC_PAID_FLAG_LABEL;
	}

	public void setCOMP_PC_PAID_FLAG(HtmlSelectOneMenu COMP_PC_PAID_FLAG) {
		this.COMP_PC_PAID_FLAG = COMP_PC_PAID_FLAG;
	}

	public HtmlOutputLabel getCOMP_PC_PREM_HOLIDAY_YN_LABEL() {
		return COMP_PC_PREM_HOLIDAY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PC_PREM_HOLIDAY_YN() {
		return COMP_PC_PREM_HOLIDAY_YN;
	}

	public void setCOMP_PC_PREM_HOLIDAY_YN_LABEL(
			HtmlOutputLabel COMP_PC_PREM_HOLIDAY_YN_LABEL) {
		this.COMP_PC_PREM_HOLIDAY_YN_LABEL = COMP_PC_PREM_HOLIDAY_YN_LABEL;
	}

	public void setCOMP_PC_PREM_HOLIDAY_YN(
			HtmlSelectOneMenu COMP_PC_PREM_HOLIDAY_YN) {
		this.COMP_PC_PREM_HOLIDAY_YN = COMP_PC_PREM_HOLIDAY_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOT_OUT_LC_AMT_LABEL() {
		return COMP_UI_M_TOT_OUT_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOT_OUT_LC_AMT() {
		return COMP_UI_M_TOT_OUT_LC_AMT;
	}

	public void setCOMP_UI_M_TOT_OUT_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_TOT_OUT_LC_AMT_LABEL) {
		this.COMP_UI_M_TOT_OUT_LC_AMT_LABEL = COMP_UI_M_TOT_OUT_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_TOT_OUT_LC_AMT(
			HtmlInputText COMP_UI_M_TOT_OUT_LC_AMT) {
		this.COMP_UI_M_TOT_OUT_LC_AMT = COMP_UI_M_TOT_OUT_LC_AMT;
	}

	public PT_IL_PREM_COLL_1 getPT_IL_PREM_COLL_1_BEAN() {
		return PT_IL_PREM_COLL_1_BEAN;
	}

	public void setPT_IL_PREM_COLL_1_BEAN(
			PT_IL_PREM_COLL_1 PT_IL_PREM_COLL_1_BEAN) {
		this.PT_IL_PREM_COLL_1_BEAN = PT_IL_PREM_COLL_1_BEAN;
	}

	/**
	 * @return the collectionTable
	 */
	public UIData getCollectionTable() {
		return collectionTable;
	}

	/**
	 * @param collectionTable
	 *            the collectionTable to set
	 */
	public void setCollectionTable(UIData collectionTable) {
		this.collectionTable = collectionTable;
	}

	public String nextPage() {
		return "nextpage";
	}

	public List<SelectItem> getPaidFlagComboList() {
		if (paidFlagComboList.size() == 0) {
			paidFlagComboList.clear();
			FacesContext fc = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) fc.getExternalContext()
					.getContext();
			SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent) context
					.getAttribute("connectionAgent");
			Connection con = null;
			try {
				// con = connectionAgent.getConnection("123");
				con = CommonUtils.getConnection();
				paidFlagComboList = ListItemUtil.getDropDownListValue(con,
						"PILT016A_APAC", "PT_IL_PREM_COLL_1",
						"PT_IL_PREM_COLL_1.PC_PAID_FLAG", "IL_PREM_STAT");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return paidFlagComboList;
	}

	public void setPaidFlagComboList(List<SelectItem> paidFlagComboList) {
		this.paidFlagComboList = paidFlagComboList;
	}

	public List<SelectItem> getHolidayComboList() {
		if (holidayComboList.size() == 0) {
			holidayComboList.clear();
			FacesContext fc = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) fc.getExternalContext()
					.getContext();
			SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent) context
					.getAttribute("connectionAgent");
			Connection con = null;
			try {
				// con = connectionAgent.getConnection("123");
				con = CommonUtils.getConnection();
				holidayComboList = ListItemUtil.getDropDownListValue(con,
						"PILT016A_APAC", "PT_IL_PREM_COLL_1",
						"PT_IL_PREM_COLL_1.PC_PREM_HOLIDAY_YN", "YESNO");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return holidayComboList;
	}

	public void setHolidayComboList(List<SelectItem> holidayComboList) {
		this.holidayComboList = holidayComboList;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			Map sessionMap = fc.getExternalContext().getSessionMap();
			// con = (Connection)sessionMap.get("CLIENT_CON");
			con = CommonUtils.getConnection();

			/*
			 * ServletContext context = (ServletContext) fc.getExternalContext()
			 * .getContext(); SimpleConnectionAgent connectionAgent =
			 * (SimpleConnectionAgent) context .getAttribute("connectionAgent");
			 * con = connectionAgent.getConnection("123");
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return con;

	}

	public HtmlInputText getCOMP_UI_M_PROP_AVLB() {
		return COMP_UI_M_PROP_AVLB;
	}

	public void setCOMP_UI_M_PROP_AVLB(HtmlInputText comp_ui_m_prop_avlb) {
		COMP_UI_M_PROP_AVLB = comp_ui_m_prop_avlb;
	}

	public HtmlInputText getCOMP_UI_M_POL_AVLB() {
		return COMP_UI_M_POL_AVLB;
	}

	public void setCOMP_UI_M_POL_AVLB(HtmlInputText comp_ui_m_pol_avlb) {
		COMP_UI_M_POL_AVLB = comp_ui_m_pol_avlb;
	}

	/**
	 * Instantiates all components in PT_IL_PREM_COLL_1_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_UI_M_LC_NET_PREM = new HtmlInputText();
		COMP_PC_LC_AVLB_BAL_AMT = new HtmlInputText();
		COMP_UI_M_TOT_OUT_LC_AMT = new HtmlInputText();
		COMP_UI_M_PROP_AVLB = new HtmlInputText();
		COMP_UI_M_POL_AVLB = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_PC_PAID_FLAG = new HtmlSelectOneMenu();
		COMP_PC_PREM_HOLIDAY_YN = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_PC_SCHD_PYMT_DT = new HtmlCalendar();

	}

	/**
	 * Resets all components in PT_IL_PREM_COLL_1_ACTION
	 */
	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_UI_M_LC_NET_PREM.resetValue();
		COMP_PC_LC_AVLB_BAL_AMT.resetValue();
		COMP_UI_M_TOT_OUT_LC_AMT.resetValue();
		COMP_UI_M_PROP_AVLB.resetValue();
		COMP_UI_M_POL_AVLB.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_PC_PAID_FLAG.resetValue();
		COMP_PC_PREM_HOLIDAY_YN.resetValue();

		// Reseting HtmlCalendar
		COMP_PC_SCHD_PYMT_DT.resetValue();

	}

	public void saveRecord() {
		try {

			String message = null;
			CommonUtils.getConnection().commit();
			message = Messages.getString("messageProperties",
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE", message);
			/*
			 * } else { CommonUtils.getConnection().commit(); message =
			 * Messages.getString("messageProperties",
			 * "errorPanel$message$update");
			 * getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			 * message); getWarningMap().put("UPDATE", message); }
			 */

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void postRecord() {
		try {
			/*
			 * if (PT_IL_PREM_COLL_1_BEAN.getROWID() == null) { if
			 * (isINSERT_ALLOWED()) { new
			 * CRUDHandler().executeInsert(PT_IL_PREM_COLL_1_BEAN,
			 * CommonUtils.getConnection());
			 * getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			 * Messages.getString( PELConstants.pelMessagePropertiesPath,
			 * "errorPanel$message$insert")); getWarningMap().put( "postRecord",
			 * Messages.getString( PELConstants.pelMessagePropertiesPath,
			 * "errorPanel$message$insert"));
			 * collectionDetailList.add(PT_IL_PREM_COLL_1_BEAN); } else {
			 * getWarningMap().put( "postRecord", Messages.getString(
			 * PELConstants.pelMessagePropertiesPath,
			 * "errorPanel$message$insertnotallowed")); } } else if
			 * (PT_IL_PREM_COLL_1_BEAN.getROWID() != null) { if
			 * (isUPDATE_ALLOWED()) {
			 */
			new CRUDHandler().executeUpdate(PT_IL_PREM_COLL_1_BEAN, CommonUtils
					.getConnection());
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$Grid$update"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$Grid$update"));
			/*
			 * } else { getWarningMap().put( "postRecord", Messages.getString(
			 * PELConstants.pelMessagePropertiesPath,
			 * "errorPanel$message$updatenotallowed")); } }
			 */

			PT_IL_PREM_COLL_1_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	/**
	 * @return the uI_BUT_ADD
	 */
	public HtmlCommandButton getUI_BUT_ADD() {
		return UI_BUT_ADD;
	}

	/**
	 * @param ui_but_add
	 *            the uI_BUT_ADD to set
	 */
	public void setUI_BUT_ADD(HtmlCommandButton ui_but_add) {
		UI_BUT_ADD = ui_but_add;
	}

	/**
	 * @return the uI_BUT_POST
	 */
	public HtmlCommandButton getUI_BUT_POST() {
		return UI_BUT_POST;
	}

	/**
	 * @param ui_but_post
	 *            the uI_BUT_POST to set
	 */
	public void setUI_BUT_POST(HtmlCommandButton ui_but_post) {
		UI_BUT_POST = ui_but_post;
	}

	/**
	 * @return the uI_BUT_DELETE
	 */
	public HtmlCommandButton getUI_BUT_DELETE() {
		return UI_BUT_DELETE;
	}

	/**
	 * @param ui_but_delete the uI_BUT_DELETE to set
	 */
	public void setUI_BUT_DELETE(HtmlCommandButton ui_but_delete) {
		UI_BUT_DELETE = ui_but_delete;
	}

}
