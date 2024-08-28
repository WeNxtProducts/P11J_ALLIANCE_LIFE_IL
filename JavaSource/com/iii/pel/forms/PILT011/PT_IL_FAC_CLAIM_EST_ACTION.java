package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.GNMNF002.GNMNF002_PILT011;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_CLAIM_EST_ACTION extends CommonAction {

	private Connection connection = null;
	private ResultSet resultSet = null;
	public CRUDHandler handler = null;
	private String M_WHERE = "";
	private String M_TITLE;
	private String M_FAC_REC;
	private String M_RI_REC;
	private String M_NAME;
	private String M_BL_NAME;
	private String M_FRZ_FLAG;
	private String M_CUST_CODE;
	private String M_DUMMY;
	String query;
	private BUTTON_PALETTE buttonPallete = null;
	
	GNMNF002_PILT011 gnmnfoo2 = null;
	
	private HtmlOutputLabel COMP_UI_M_POL_NO_1_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_1;

	private HtmlOutputLabel COMP_UI_M_CLM_NO_1_LABEL;

	private HtmlInputText COMP_UI_M_CLM_NO_1;

	private HtmlOutputLabel COMP_FCE_CCD_COVER_CODE_LABEL;

	private HtmlInputText COMP_FCE_CCD_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_1_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC_1;

	private HtmlOutputLabel COMP_UI_M_CURR_DESC_1_LABEL;

	private HtmlInputText COMP_UI_M_CURR_DESC_1;

	private HtmlInputText COMP_UI_M_COVER_DESC_3;

	private HtmlOutputLabel COMP_FCE_CLAIM_CURR_CODE_LABEL;

	private HtmlInputText COMP_FCE_CLAIM_CURR_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_ESTIMATE;

	private HtmlCommandButton COMP_UI_M_BUT_FAC_SETTLEMENT;

	private PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN;

	private HtmlCommandButton testButton;

	private PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION custEstAction;
	
	private PT_IL_FAC_CLAIM_EST_HELPER helper = new PT_IL_FAC_CLAIM_EST_HELPER();

	private List<PT_IL_FAC_CLAIM_PART_CUST_EST> claimPartCustList=new ArrayList<PT_IL_FAC_CLAIM_PART_CUST_EST>();
	
	public PILT011_COMPOSITE_ACTION compositeAction;

	public PT_IL_FAC_CLAIM_EST_ACTION() {
		handler = new CRUDHandler();
		custEstAction = new PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION();
		PT_IL_FAC_CLAIM_EST_BEAN = new PT_IL_FAC_CLAIM_EST();
	//	PILT011_PRE_FORM();
		//load_PT_IL_FAC_CLAIM_EST_Dtls();
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_1_LABEL() {
		return COMP_UI_M_POL_NO_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_1() {
		return COMP_UI_M_POL_NO_1;
	}

	public void setCOMP_UI_M_POL_NO_1_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_NO_1_LABEL) {
		this.COMP_UI_M_POL_NO_1_LABEL = COMP_UI_M_POL_NO_1_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_1(HtmlInputText COMP_UI_M_POL_NO_1) {
		this.COMP_UI_M_POL_NO_1 = COMP_UI_M_POL_NO_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLM_NO_1_LABEL() {
		return COMP_UI_M_CLM_NO_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLM_NO_1() {
		return COMP_UI_M_CLM_NO_1;
	}

	public void setCOMP_UI_M_CLM_NO_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CLM_NO_1_LABEL) {
		this.COMP_UI_M_CLM_NO_1_LABEL = COMP_UI_M_CLM_NO_1_LABEL;
	}

	public void setCOMP_UI_M_CLM_NO_1(HtmlInputText COMP_UI_M_CLM_NO_1) {
		this.COMP_UI_M_CLM_NO_1 = COMP_UI_M_CLM_NO_1;
	}

	public HtmlOutputLabel getCOMP_FCE_CCD_COVER_CODE_LABEL() {
		return COMP_FCE_CCD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FCE_CCD_COVER_CODE() {
		return COMP_FCE_CCD_COVER_CODE;
	}

	public void setCOMP_FCE_CCD_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_FCE_CCD_COVER_CODE_LABEL) {
		this.COMP_FCE_CCD_COVER_CODE_LABEL = COMP_FCE_CCD_COVER_CODE_LABEL;
	}

	public void setCOMP_FCE_CCD_COVER_CODE(HtmlInputText COMP_FCE_CCD_COVER_CODE) {
		this.COMP_FCE_CCD_COVER_CODE = COMP_FCE_CCD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_1_LABEL() {
		return COMP_UI_M_COVER_DESC_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC_1() {
		return COMP_UI_M_COVER_DESC_1;
	}

	public void setCOMP_UI_M_COVER_DESC_1_LABEL(
			HtmlOutputLabel COMP_UI_M_COVER_DESC_1_LABEL) {
		this.COMP_UI_M_COVER_DESC_1_LABEL = COMP_UI_M_COVER_DESC_1_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC_1(HtmlInputText COMP_UI_M_COVER_DESC_1) {
		this.COMP_UI_M_COVER_DESC_1 = COMP_UI_M_COVER_DESC_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_CURR_DESC_1_LABEL() {
		return COMP_UI_M_CURR_DESC_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CURR_DESC_1() {
		return COMP_UI_M_CURR_DESC_1;
	}

	public void setCOMP_UI_M_CURR_DESC_1_LABEL(
			HtmlOutputLabel COMP_UI_M_CURR_DESC_1_LABEL) {
		this.COMP_UI_M_CURR_DESC_1_LABEL = COMP_UI_M_CURR_DESC_1_LABEL;
	}

	public void setCOMP_UI_M_CURR_DESC_1(HtmlInputText COMP_UI_M_CURR_DESC_1) {
		this.COMP_UI_M_CURR_DESC_1 = COMP_UI_M_CURR_DESC_1;
	}

	public HtmlOutputLabel getCOMP_FCE_CLAIM_CURR_CODE_LABEL() {
		return COMP_FCE_CLAIM_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FCE_CLAIM_CURR_CODE() {
		return COMP_FCE_CLAIM_CURR_CODE;
	}

	public void setCOMP_FCE_CLAIM_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_FCE_CLAIM_CURR_CODE_LABEL) {
		this.COMP_FCE_CLAIM_CURR_CODE_LABEL = COMP_FCE_CLAIM_CURR_CODE_LABEL;
	}

	public void setCOMP_FCE_CLAIM_CURR_CODE(
			HtmlInputText COMP_FCE_CLAIM_CURR_CODE) {
		this.COMP_FCE_CLAIM_CURR_CODE = COMP_FCE_CLAIM_CURR_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ESTIMATE() {
		return COMP_UI_M_BUT_ESTIMATE;
	}

	public void setCOMP_UI_M_BUT_ESTIMATE(
			HtmlCommandButton COMP_UI_M_BUT_ESTIMATE) {
		this.COMP_UI_M_BUT_ESTIMATE = COMP_UI_M_BUT_ESTIMATE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC_SETTLEMENT() {
		return COMP_UI_M_BUT_FAC_SETTLEMENT;
	}

	public void setCOMP_UI_M_BUT_FAC_SETTLEMENT(
			HtmlCommandButton COMP_UI_M_BUT_FAC_SETTLEMENT) {
		this.COMP_UI_M_BUT_FAC_SETTLEMENT = COMP_UI_M_BUT_FAC_SETTLEMENT;
	}

	public PT_IL_FAC_CLAIM_EST getPT_IL_FAC_CLAIM_EST_BEAN() {
		return PT_IL_FAC_CLAIM_EST_BEAN;
	}

	public void setPT_IL_FAC_CLAIM_EST_BEAN(
			PT_IL_FAC_CLAIM_EST PT_IL_FAC_CLAIM_EST_BEAN) {
		this.PT_IL_FAC_CLAIM_EST_BEAN = PT_IL_FAC_CLAIM_EST_BEAN;
	}

	public HtmlCommandButton getTestButton() {
		return testButton;
	}

	public void setTestButton(HtmlCommandButton testButton) {
		this.testButton = testButton;
	}

	public String getM_TITLE() {
		return M_TITLE;
	}

	public void setM_TITLE(String m_title) {
		M_TITLE = m_title;
	}

	//	public void createCtrlBean(){
	//		CTRL control = new CTRL();
	//		FacesContext faces = FacesContext.getCurrentInstance();
	//		session = faces.getExternalContext().getSessionMap();
	//		session.put("ctrlbean", control);
	//	}

	public String getM_FAC_REC() {
		return M_FAC_REC;
	}

	public void setM_FAC_REC(String m_fac_rec) {
		M_FAC_REC = m_fac_rec;
	}

	public String getM_RI_REC() {
		return M_RI_REC;
	}

	public void setM_RI_REC(String m_ri_rec) {
		M_RI_REC = m_ri_rec;
	}

	public String getM_NAME() {
		return M_NAME;
	}

	public void setM_NAME(String m_name) {
		M_NAME = m_name;
	}

	public String getM_BL_NAME() {
		return M_BL_NAME;
	}

	public void setM_BL_NAME(String m_bl_name) {
		M_BL_NAME = m_bl_name;
	}

	public String getM_FRZ_FLAG() {
		return M_FRZ_FLAG;
	}

	public void setM_FRZ_FLAG(String m_frz_flag) {
		M_FRZ_FLAG = m_frz_flag;
	}

	public String getM_CUST_CODE() {
		return M_CUST_CODE;
	}

	public void setM_CUST_CODE(String m_cust_code) {
		M_CUST_CODE = m_cust_code;
	}

	/*public void PILT011_PRE_FORM(PhaseEvent ae) throws ParseException {
		gnmnfoo2 = new GNMNF002_PILT011();
		gnmnfoo2.setGlobalParameters();
		FacesContext faces = FacesContext.getCurrentInstance();
		if (CommonUtils.getGlobalVariable("GLOBAL.CALLING_FORM") == null) {

		setM_TITLE(CommonUtils.getControlBean().getM_USER_ID()
				+ CommonUtils.getControlBean().getM_SCR_NAME()
				+ new CommonUtils().getCurrentDate());

		PT_IL_FAC_CLAIM_EST_BEAN.setPT_IL_FAC_CLAIM_EST_CF("P");
		PT_IL_FAC_CLAIM_EST_BEAN.setPT_IL_FAC_CLAIM_PAID_CF("P");
		PT_IL_FAC_CLAIM_EST_BEAN.setPT_IL_FAC_CLAIM_PART_CUST_ES("N");
		PT_IL_FAC_CLAIM_EST_BEAN.setPT_IL_FAC_CLAIM_PART_CUST_PA("N");
		PT_IL_FAC_CLAIM_EST_BEAN.setM_POL_SYS_ID(CommonUtils.getGlobalVariable(
				"GLOBAL.POL_SYS_ID").toString());
		PT_IL_FAC_CLAIM_EST_BEAN.setM_CLM_SYS_ID(CommonUtils.getGlobalVariable(
				"GLOBAL.CLM_SYS_ID").toString());
		PT_IL_FAC_CLAIM_EST_BEAN.setM_COVER_CODE((String) CommonUtils.getGlobalVariable("GLOBAL.COVER_CODE"));
		PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CCD_COVER_CODE((String) CommonUtils.getGlobalVariable("GLOBAL.COVER_CODE"));
		
			compositeAction.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN().getPT_IL_TTY_CLAIM_EST_BEAN()
					.setTCE_CCD_COVER_CODE(
							(String) CommonUtils.getGlobalVariable("GLOBAL.COVER_CODE"));
		
		query = "SELECT CLAIM_POL_NO,CLAIM_NO FROM PT_IL_CLAIM WHERE CLAIM_POL_SYS_ID = '"
				+ PT_IL_FAC_CLAIM_EST_BEAN.getM_POL_SYS_ID()
				+ "' AND CLAIM_SYS_ID = '"
				+ PT_IL_FAC_CLAIM_EST_BEAN.getM_CLM_SYS_ID() + "'";
		try {
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				PT_IL_FAC_CLAIM_EST_BEAN.setUI_M_POL_NO_1(resultSet
						.getString(1));
				PT_IL_FAC_CLAIM_EST_BEAN.setUI_M_CLM_NO_1(resultSet
						.getString(2));
			}
		} catch (Exception ex) {
		} finally {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		PT_IL_FAC_CLAIM_EST_BEAN.setM_POL_NO_2(PT_IL_FAC_CLAIM_EST_BEAN
				.getUI_M_POL_NO_1());
		PT_IL_FAC_CLAIM_EST_BEAN.setM_CLM_NO_2(PT_IL_FAC_CLAIM_EST_BEAN
				.getUI_M_CLM_NO_1());

		
		//PILT011_WHEN_NEW_FORM_INSTANCE();
		PT_IL_FAC_CLAIM_EST_WHEN_NEW_RECORD_INSTANCE();
		FCE_CCD_COVER_CODE_WHEN_NEW_ITEM_INSTANCE();
		getPT_IL_FAC_CLAIM_EST_Dtls();
		getPT_IL_FAC_CLAIM_EST_PART_CUST_Dtls();
		//PT_IL_FAC_CLAIM_EST_POST_QUERY();
	}
	}*/


	public PT_IL_FAC_CLAIM_PAID_ACTION getPT_IL_FAC_CLAIM_PAID_BEAN() {
			PT_IL_FAC_CLAIM_PAID_ACTION claimPaidAction = compositeAction.getPT_IL_FAC_CLAIM_PAID_ACTION_BEAN();
		return claimPaidAction;
	}

	public void PILT011_PRE_COMMIT() {
		if (CommonUtils.getControlBean().getM_COMM_DEL().equals("")) {
			CommonUtils.getControlBean().setM_COMM_DEL("X");
		} else {
			if (CommonUtils.getControlBean().getM_COMM_DEL().equals("C")
					|| CommonUtils.getControlBean().getM_COMM_DEL().equals("P")
					|| CommonUtils.getControlBean().getM_COMM_DEL().equals("D")) {
				String errMessage = GET_ALERT_MSG("09");
			}
		}
	}

	public String GET_ALERT_MSG(String errNo) {
		String M_MESSAGE = "";
		if (!CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE").toString().equals("ENG")) {
			/*			RG_ID	:= FIND_GROUP('RG_ALERT_MSG') ;
			 IF ID_NULL(RG_ID) THEN
			 M_MESSAGE := P_MSG_NO || ' Record Group does not exists Message Not Found' ;
			 */
		} else {
			if (errNo.equals("01")) {
				M_MESSAGE = "Changes Made..Do you want to Exit without Saving";
			} else if (errNo.equals("02")) {
				M_MESSAGE = "Do You want to Clear";
			} else if (errNo.equals("03")) {
				M_MESSAGE = "Cannot Move to Next Block without filling Details in the Parent Block";
			} else if (errNo.equals("04")) {
				M_MESSAGE = "Please Commit the Changes and then Move";
			} else if (errNo.equals("05")) {
				M_MESSAGE = "Last Block in this Form";
			} else if (errNo.equals("06")) {
				M_MESSAGE = "Cannot Move to Next Block Before Filling Details in this Block";
			} else if (errNo.equals("07")) {
				M_MESSAGE = "This Function has no meaning in this Context";
			} else if (errNo.equals("08")) {
				M_MESSAGE = "Unknown Error Number";
			} else if (errNo.equals("09")) {
				M_MESSAGE = "Cannot Commit Record , Save through Proper Option";
			} else if (errNo.equals("10")) {
				M_MESSAGE = "Choose Option";
			}
		}
		return M_MESSAGE;
	}

	public void PILT011_POST_DATABASE_COMMIT() {
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
	}

	public void PILT011_POST_FORMS_COMMIT() {
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
	}

	public String getSubStringM_NAME(int startIndex, int length) {
		String def_Values = gnmnfoo2.returnGlobalValues().get(":GLOBAL.M_NAME")
				.toString();
		String res_String = def_Values.substring(startIndex - 1,
				(startIndex - 1 + length));
		while (res_String.endsWith(" ")) {
			res_String = res_String.substring(0, res_String.length() - 1);
		}
		return res_String;
	}

	public String getSubStringM_DFLT_VALUES(int startIndex, int length) {
		String def_Values = CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES").toString();
		String res_String = def_Values.substring(startIndex - 1,
				(startIndex - 1 + length));
		while (res_String.endsWith(" ")) {
			res_String = res_String.substring(0, res_String.length() - 1);
		}
		return res_String;
	}

	public void PT_IL_FAC_CLAIM_EST_ON_POPULATE_DETAILS() {
		
	}

	public void PT_IL_FAC_CLAIM_EST_WHEN_NEW_RECORD_INSTANCE() {
		Connection connection = null;
		String C1 = "SELECT 'X' FROM  PT_IL_FAC_CLAIM_PAID WHERE FCP_FCE_SYS_ID = "
				+ PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID();
		String C2 = "SELECT FCE_CCD_COVER_CODE FROM PT_IL_FAC_CLAIM_EST WHERE FCE_CLAIM_SYS_ID IN (SELECT CLAIM_SYS_ID FROM PT_IL_CLAIM WHERE  CLAIM_NO = '"
				+ PT_IL_FAC_CLAIM_EST_BEAN.getUI_M_CLM_NO_1() + "')";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection);
			if (resultSet != null) {
				while (resultSet.next()) {
					setM_DUMMY(resultSet.getString(1));
				}
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			resultSet = handler.executeSelectStatement(C2, connection);
			while (resultSet.next()) {
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CCD_COVER_CODE(resultSet
						.getString(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//		}
	}

	public String getM_DUMMY() {
		return M_DUMMY;
	}

	public void setM_DUMMY(String m_dummy) {
		M_DUMMY = m_dummy;
	}

	public void FCE_CCD_COVER_CODE_WHEN_NEW_ITEM_INSTANCE() {

		String callingForm = (String) CommonUtils.getGlobalVariable("GLOBAL.CALLING_FORM");
		if ((callingForm == null ? "" : callingForm).equals("PILT006_APAC")) {
			if (CommonUtils.getGlobalVariable("GLOBAL.FAC_RI_BUT").equals("R")) {
				if (!PT_IL_FAC_CLAIM_EST_BEAN.getM_COVER_CODE().equals("")) {
					M_WHERE = "TCE_CLAIM_SYS_ID = "
							+ PT_IL_FAC_CLAIM_EST_BEAN.getM_CLM_SYS_ID()
							+ " AND TCE_CCD_COVER_CODE = '"
							+ PT_IL_FAC_CLAIM_EST_BEAN.getM_COVER_CODE() + "'";
				} else {
					M_WHERE = "TCE_CLAIM_SYS_ID = "
							+ PT_IL_FAC_CLAIM_EST_BEAN.getM_CLM_SYS_ID();
				}
				CommonUtils.setGlobalVariable("PT_IL_TTY_CLAIM_EST.DEFAULT_WHERE", M_WHERE);
				query = "select * from PT_IL_TTY_CLAIM_EST where "
						+ CommonUtils.getGlobalVariable("PT_IL_TTY_CLAIM_EST.DEFAULT_WHERE");
				//				SET_BLOCK_PROPERTY('PT_IL_TTY_CLAIM_EST',DEFAULT_WHERE,M_WHERE);
				//				EXECUTE_QUERY;
			}
		}

		
	}

	public void FCE_CLAIM_CURR_CODE_WHEN_VALIDATE_ITEM(ActionEvent ae) {
		//		String P_CURR_NAME = P_VAL_CURR(getCOMP_FCE_CLAIM_CURR_CODE().getSubmittedValue().toString(),PT_IL_FAC_CLAIM_EST_BEAN.getUI_M_CURR_DESC_1(),"N",controlBean.getM_LANG_CODE());
	}
	/* Modified by saranya for RI recovery details to be shown at Claim registration stage itself on 18/02/2017 */
	public String UI_M_BUT_ESTIMATE_WHEN_BUTTON_PRESSED() {
		/*Added by Raja on 25/04/2017*/
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		//String callingForm = (String) sessionMap.get("PILT011_CALLING_FORM");
		String outcome = null;
		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
		if ((callingForm == null ? "" : callingForm).equals("PILT006_APAC")) {
			outcome = "PILT006_APAC_claimCoverDetails";
		} else if ((callingForm == null ? "" : callingForm).equals("PILT007")) {
			outcome = "PILT007_claimPaid";
			/*End*/
		/*} else if ((callingForm == null ? "" : callingForm).equals("PILT012")) {
			outcome = "PILT012_claimRi";*/
		}
		/*return "RIDetailsPage" ;*/
		return outcome;
	}
	/*End*/

	public String UI_M_BUT_FAC_SETTLEMENT_BUTTON_PRESSED() {
		CommonUtils.setGlobalObject("M_FCE_SYS_ID", PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID());
		CommonUtils.setGlobalObject("CUST_CODE",custEstAction.getPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN().getFCPCE_CUST_CODE());
		CommonUtils.setGlobalObject("POL_NO", PT_IL_FAC_CLAIM_EST_BEAN.getUI_M_POL_NO_1());
		CommonUtils.setGlobalObject("CLAIM_NO", PT_IL_FAC_CLAIM_EST_BEAN.getUI_M_CLM_NO_1());
		return "fac_settlement";
	}

	public void getPT_IL_FAC_CLAIM_EST_PART_CUST_Dtls() {
		Connection connection = null;
		PT_IL_FAC_CLAIM_PART_CUST_EST PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN = null;
		String selectQuery = "SELECT * FROM PT_IL_FAC_CLAIM_PART_CUST_EST where PT_IL_FAC_CLAIM_PART_CUST_EST.FCPCE_FCE_SYS_ID="
				+ PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID();
		try {
			connection = CommonUtils.getConnection();
			claimPartCustList = new ArrayList<PT_IL_FAC_CLAIM_PART_CUST_EST>();
			ResultSet rst = null;
			rst = handler.executeSelectStatement(selectQuery, connection);
			if (rst.next()) {
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN = new PT_IL_FAC_CLAIM_PART_CUST_EST();
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_CUST_CODE(rst
						.getString("FCPCE_CUST_CODE"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_FAC_PERC(rst
						.getDouble("FCPCE_FAC_PERC"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_FC_CLM_EST(rst
						.getDouble("FCPCE_FC_CLM_EST"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_LC_CLM_EST(rst
						.getDouble("FCPCE_LC_CLM_EST"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN
						.setFCPCE_RETRO_FC_CLM_EST(rst
								.getDouble("FCPCE_RETRO_FC_CLM_EST"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN
						.setFCPCE_RETRO_LC_CLM_EST(rst
								.getDouble("FCPCE_RETRO_LC_CLM_EST"));
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_RETRO_PERC(rst
						.getDouble("FCPCE_RETRO_PERC"));
				claimPartCustList.add(PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN);
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setRowSelected(false);
			}

			if (rst != null) {
				rst.close();
			}
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION pt_il_fac_claim_part_cust_est_action = (PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION) sessionMap
					.get("PILT011_PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION");
			if (pt_il_fac_claim_part_cust_est_action ==null){
				pt_il_fac_claim_part_cust_est_action= new PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION();
				sessionMap.put("PILT011_PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION",pt_il_fac_claim_part_cust_est_action);
			}
			if (claimPartCustList.size() != 0) {
				PT_IL_FAC_CLAIM_PART_CUST_EST pt_il_fac_claim_part_cust_est = claimPartCustList
						.get(0);
				pt_il_fac_claim_part_cust_est.setRowSelected(true);
				pt_il_fac_claim_part_cust_est_action
						.setPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN(pt_il_fac_claim_part_cust_est);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getPT_IL_FAC_CLAIM_EST_Dtls() {
		Connection connection = null;
		query = "select FCE_CLAIM_CURR_CODE from PT_IL_FAC_CLAIM_EST where FCE_CLAIM_SYS_ID="
				+ PT_IL_FAC_CLAIM_EST_BEAN.getM_CLM_SYS_ID();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CLAIM_CURR_CODE(resultSet
						.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<PT_IL_FAC_CLAIM_PART_CUST_EST> getClaimPartCustList() {
		return claimPartCustList;
	}

	public void setClaimPartCustList(
			List<PT_IL_FAC_CLAIM_PART_CUST_EST> claimPartCustList) {
		this.claimPartCustList = claimPartCustList;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC_3() {
		return COMP_UI_M_COVER_DESC_3;
	}

	public void setCOMP_UI_M_COVER_DESC_3(HtmlInputText comp_ui_m_cover_desc_3) {
		COMP_UI_M_COVER_DESC_3 = comp_ui_m_cover_desc_3;
	}

	public void load_PT_IL_FAC_CLAIM_EST_Dtls() {
		query = "SELECT FCE_CCD_COVER_CODE,FCE_CLAIM_CURR_CODE,FCE_CLAIM_SYS_ID,FCE_CCD_SYS_ID FROM PT_IL_FAC_CLAIM_EST WHERE FCE_SYS_ID = "
				+ PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID();
		try {
			resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection());
			while (resultSet.next()) {
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CCD_COVER_CODE(resultSet
						.getString("FCE_CCD_COVER_CODE"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CLAIM_CURR_CODE(resultSet
						.getString("FCE_CLAIM_CURR_CODE"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CLAIM_SYS_ID(resultSet
						.getDouble("FCE_CLAIM_SYS_ID"));
				PT_IL_FAC_CLAIM_EST_BEAN.setFCE_CCD_SYS_ID(resultSet
						.getString("FCE_CCD_SYS_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onLoad(PhaseEvent event){
		try{
			if(isFormFlag()){
				helper.pre_form(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				helper.WHEN_NEW_FORM_INSTANCE(compositeAction);
				setFormFlag(false);
			}
			if(isBlockFlag()){
				
				if(PT_IL_FAC_CLAIM_EST_BEAN.getROWID() != null){
					//helper.PT_IL_FAC_CLAIM_EST_POST_QUERY(PT_IL_FAC_CLAIM_EST_BEAN);
				}
				helper.executeQuery(compositeAction);
				helper.fetch(compositeAction);
				helper.PT_IL_FAC_CLAIM_EST_POST_QUERY(PT_IL_FAC_CLAIM_EST_BEAN);
				if (claimPartCustList.size() != 0) {
					PT_IL_FAC_CLAIM_PART_CUST_EST pt_il_fac_claim_part_cust_est = claimPartCustList
							.get(0);
					pt_il_fac_claim_part_cust_est.setRowSelected(true);
					compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_EST_ACTION_BEAN().setPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN(pt_il_fac_claim_part_cust_est);
				}
			
				helper.when_new_record_instance(PT_IL_FAC_CLAIM_EST_BEAN, compositeAction.getDUMMY_ACTION_BEAN());
				/*Added by saranya for RI recovery details to be shown at Claim registration stage itself on 18-02-2017*/
				String value=FacButton_Disable();
				if("X".equalsIgnoreCase(value)){
					COMP_UI_M_BUT_FAC_SETTLEMENT.setDisabled(false);
				}else{
					COMP_UI_M_BUT_FAC_SETTLEMENT.setDisabled(true);
				}
				
				/*End*/
					setBlockFlag(false);
			}
			
			//compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_EST_ACTION_BEAN().getPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN().setRowSelected(true);
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	/*Added by saranya for RI recovery details to be shown at Claim registration stage itself on 18-02-2017*/
	public String  FacButton_Disable(){
		
			 String Fac_Button = null;
			 Connection connection = null;
			 ResultSet rs = null;
			String query = " SELECT 'X' FROM  PT_IL_FAC_CLAIM_PAID WHERE FCP_FCE_SYS_ID = ?";
				try {
			
				 connection = CommonUtils.getConnection();
				 rs = new CRUDHandler().executeSelectStatement(query, connection,
						 new Object[] { PT_IL_FAC_CLAIM_EST_BEAN.getFCE_SYS_ID()});
				 if(rs.next()) {
					 Fac_Button = rs.getString(1);
					 System.out.println("Fac_Button "+Fac_Button);
				 }
				
				} catch (Exception e) {
				 e.printStackTrace();
			 } 
			 return Fac_Button;
		 }
	
	/*End*/
	
}

