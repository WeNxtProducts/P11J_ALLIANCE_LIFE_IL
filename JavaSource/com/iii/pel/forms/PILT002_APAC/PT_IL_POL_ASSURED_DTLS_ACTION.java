package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.pel.utils.PremiaLib;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_ASSURED_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POAD_ASSR_CODE_LABEL;

	private HtmlInputText COMP_POAD_ASSR_CODE;

	private HtmlOutputLabel COMP_POAD_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_POAD_ASSURED_NAME;

	private HtmlOutputLabel COMP_POAD_FC_SALARY_LABEL;

	private HtmlInputText COMP_POAD_FC_SALARY;

	private HtmlOutputLabel COMP_POAD_REF_ID1_LABEL;

	private HtmlInputText COMP_POAD_REF_ID1;

	private HtmlOutputLabel COMP_POAD_REF_ID2_LABEL;

	private HtmlInputText COMP_POAD_REF_ID2;

	private HtmlOutputLabel COMP_POAD_LC_SALARY_LABEL;

	private HtmlInputText COMP_POAD_LC_SALARY;

	private HtmlOutputLabel COMP_POAD_ALCOHOL_QUAN_LABEL;

	private HtmlInputText COMP_POAD_ALCOHOL_QUAN;

	private HtmlOutputLabel COMP_POAD_BMI_LABEL;

	private HtmlInputText COMP_POAD_BMI;

	private HtmlOutputLabel COMP_POAD_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_POAD_TYPE;

	private HtmlOutputLabel COMP_POAD_CATG_CODE_LABEL;

	private HtmlInputText COMP_POAD_CATG_CODE;

	private HtmlOutputLabel COMP_UI_M_POAD_CATG_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_CATG_DESC;

	private HtmlOutputLabel COMP_POAD_BIRTH_PLACE_LABEL;

	private HtmlInputText COMP_POAD_BIRTH_PLACE;

	private HtmlOutputLabel COMP_POAD_DOB_LABEL;

	private HtmlCalendar COMP_POAD_DOB;

	private HtmlOutputLabel COMP_POAD_HEIGHT_LABEL;

	private HtmlInputText COMP_POAD_HEIGHT;

	private HtmlOutputLabel COMP_POAD_HEIGHT_UNIT_LABEL;

	private HtmlSelectOneMenu COMP_POAD_HEIGHT_UNIT;

	private HtmlOutputLabel COMP_POAD_RACE_LABEL;

	private HtmlInputText COMP_POAD_RACE;

	private HtmlOutputLabel COMP_UI_M_POAD_RACE_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_RACE_CODE_DESC;

	private HtmlOutputLabel COMP_POAD_AGE_LABEL;

	private HtmlInputText COMP_POAD_AGE;

	private HtmlOutputLabel COMP_POAD_WEIGHT_LABEL;

	private HtmlInputText COMP_POAD_WEIGHT;

	private HtmlOutputLabel COMP_POAD_WEIGHT_UNIT_LABEL;

	private HtmlSelectOneMenu COMP_POAD_WEIGHT_UNIT;

	private HtmlOutputLabel COMP_POAD_NATURE_OF_WORK_LABEL;

	private HtmlInputText COMP_POAD_NATURE_OF_WORK;

	private HtmlOutputLabel COMP_POAD_ADDL_RISK_CODE_LABEL;

	private HtmlInputText COMP_POAD_ADDL_RISK_CODE;

	private HtmlOutputLabel COMP_UI_M_ADDL_RISK_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ADDL_RISK_DESC;

	private HtmlOutputLabel COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL;

	private HtmlInputText COMP_UI_M_POAD_LC_THRESOLD_LMT;

	private HtmlOutputLabel COMP_POAD_AGE_PROOF_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_POAD_AGE_PROOF_FLAG;

	private HtmlOutputLabel COMP_POAD_AGE_PROOF_OTHERS_LABEL;

	private HtmlInputText COMP_POAD_AGE_PROOF_OTHERS;

	private HtmlOutputLabel COMP_POAD_LC_THRESHOLD_LMT_LABEL;

	private HtmlInputText COMP_POAD_LC_THRESHOLD_LMT;

	private HtmlOutputLabel COMP_POAD_DISC_AGE_LABEL;

	private HtmlInputText COMP_POAD_DISC_AGE;

	private HtmlOutputLabel COMP_POAD_SMOKE_YN_LABEL;

	private HtmlSelectOneMenu COMP_POAD_SMOKE_YN;

	private HtmlOutputLabel COMP_POAD_NO_OF_CIGAR_LABEL;

	private HtmlInputText COMP_POAD_NO_OF_CIGAR;

	private HtmlOutputLabel COMP_POAD_REMARKS_LABEL;

	private HtmlInputText COMP_POAD_REMARKS;

	private HtmlOutputLabel COMP_POAD_NATIONALITY_LABEL;

	private HtmlInputText COMP_POAD_NATIONALITY;

	private HtmlOutputLabel COMP_UI_M_POAD_NATLITY_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_NATLITY_DESC;

	private HtmlOutputLabel COMP_POAD_MAR_STATUS_LABEL;

	private HtmlInputText COMP_POAD_MAR_STATUS;

	private HtmlOutputLabel COMP_UI_M_POAD_MS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_MS_DESC;

	private HtmlOutputLabel COMP_POAD_FC_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_POAD_FC_SUM_ASSURED;

	private HtmlOutputLabel COMP_POAD_LC_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_POAD_LC_SUM_ASSURED;

	private HtmlOutputLabel COMP_POAD_OCC_CODE_LABEL;

	private HtmlInputText COMP_POAD_OCC_CODE;

	private HtmlOutputLabel COMP_UI_M_POAD_OCC_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_OCC_DESC;

	private HtmlOutputLabel COMP_POAD_FC_AMAN_PREM_LABEL;

	private HtmlInputText COMP_POAD_FC_AMAN_PREM;

	private HtmlOutputLabel COMP_POAD_LC_AMAN_PREM_LABEL;

	private HtmlInputText COMP_POAD_LC_AMAN_PREM;

	private HtmlOutputLabel COMP_POAD_OCC_CLASS_LABEL;

	private HtmlInputText COMP_POAD_OCC_CLASS;

	private HtmlOutputLabel COMP_UI_M_POAD_OCC_CLASS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_OCC_CLASS_DESC;

	private HtmlOutputLabel COMP_POAD_FC_AMAN_LOAD_PREM_LABEL;

	private HtmlInputText COMP_POAD_FC_AMAN_LOAD_PREM;

	private HtmlOutputLabel COMP_POAD_LC_AMAN_LOAD_PREM_LABEL;

	private HtmlInputText COMP_POAD_LC_AMAN_LOAD_PREM;

	private HtmlOutputLabel COMP_POAD_RELIGION_CODE_LABEL;

	private HtmlInputText COMP_POAD_RELIGION_CODE;

	private HtmlOutputLabel COMP_UI_M_POAD_REL_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_REL_CODE_DESC;

	private HtmlOutputLabel COMP_POAD_FC_SENABEL_PREM_LABEL;

	private HtmlInputText COMP_POAD_FC_SENABEL_PREM;

	private HtmlOutputLabel COMP_POAD_LC_SENABEL_PREM_LABEL;

	private HtmlInputText COMP_POAD_LC_SENABEL_PREM;

	private HtmlOutputLabel COMP_POAD_HEALTH_CODE_LABEL;

	private HtmlInputText COMP_POAD_HEALTH_CODE;

	private HtmlOutputLabel COMP_UI_M_POAD_HEALTH_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_HEALTH_DESC;

	private HtmlTab COMP_MORE_INFO_1;

	private HtmlOutputLabel COMP_POAD_AGE_ADMITTED_LABEL;

	private HtmlSelectOneMenu COMP_POAD_AGE_ADMITTED;
	
	
	
	/* Newly Added By Dhinesh on 09-01-2018 */
	
	private HtmlTabPanel COMP_PERSONAL_INFO_TAB;

	public HtmlTabPanel getCOMP_PERSONAL_INFO_TAB() {
		return COMP_PERSONAL_INFO_TAB;
	}

	public void setCOMP_PERSONAL_INFO_TAB(HtmlTabPanel cOMP_PERSONAL_INFO_TAB) {
		COMP_PERSONAL_INFO_TAB = cOMP_PERSONAL_INFO_TAB;
	}
	
	/* End */
	
	// Added by Kavitha For POC point DPLI59
	private HtmlOutputLabel COMP_POAD_POL_OWNER_YN_LABEL;

	private HtmlSelectOneMenu COMP_POAD_POL_OWNER_YN;

	private HtmlCommandButton COMP_UI_M_BUT_FLEX_FIELDS;

	private HtmlCommandButton COMP_PT_IL_POL_ASS_POL_DTLS;

	private HtmlCommandButton COMP_ADDL_COVER_DTLS;

	private PT_IL_POL_ASSURED_DTLS PT_IL_POL_ASSURED_DTLS_BEAN;

	private ArrayList<PT_IL_POL_ASSURED_DTLS> list = new ArrayList<PT_IL_POL_ASSURED_DTLS>();

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_ASSURED_DTLS_HELPER helper;

	private String DEFAULT_WHERE;

	private HtmlOutputLabel COMP_POAD_ALCHOHALIC_YN_LABEL;
	private HtmlSelectOneMenu COMP_POAD_ALCHOHALIC_YN;

	private List<SelectItem> listPOAD_ALCHOHALIC_YN = new ArrayList<SelectItem>();

	private HtmlCommandButton COMP_PT_IL_POL_APPL_PROD;

	private List<SelectItem> listPOAD_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAD_HEIGHT_UNIT = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAD_WEIGHT_UNIT = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAD_AGE_PROOF_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAD_AGE_ADMITTED = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAD_SMOKE_YN = new ArrayList<SelectItem>();
	// Added by Kavitha For POC point DPLI59
	private List<SelectItem> listPOAD_POL_OWNER_YN = new ArrayList<SelectItem>();
	
	
	
	/*Added by pidugu raj dt:23-08-2018 for KIC*/
	private HtmlInputText COMP_CUST_NAME;
	
	private HtmlOutputLabel COMP_CUST_NAME_LABEL;
	
	private HtmlInputText COMP_CIVIL_ID;
	
	private HtmlOutputLabel COMP_CIVIL_ID_LABEL;
	
	private HtmlCalendar COMP_CUST_DOB;
	
	private HtmlOutputLabel COMP_CUST_DOB_LABEL;
	
	private HtmlInputText COMP_CUST_RELN;
	
	private HtmlOutputLabel COMP_CUST_RELN_LABEL;
	
	private HtmlTab COMP_MORE_INFO_2;
	
	private PT_IL_POL_CUST_DTLS pT_IL_POL_CUST_DTLS_BEAN = new PT_IL_POL_CUST_DTLS();
	
	
	
	

	public PT_IL_POL_ASSURED_DTLS_ACTION() {

		PT_IL_POL_ASSURED_DTLS_BEAN = new PT_IL_POL_ASSURED_DTLS();
		helper = new PT_IL_POL_ASSURED_DTLS_HELPER();
		setlistValues();
		instantiateAllComponent();
		COMP_POAD_FC_SUM_ASSURED = new HtmlInputText();
		COMP_POAD_LC_SUM_ASSURED = new HtmlInputText();

	}

	public void POAD_ALCHOHALIC_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_ALCHOHALIC_YN = (String) value;
		try {
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_ALCHOHALIC_YN(
					POAD_ALCHOHALIC_YN);
			// calling same method because it have same logic for when validate
			// item
			if ("Y".equalsIgnoreCase(PT_IL_POL_ASSURED_DTLS_BEAN
					.getPOAD_ALCHOHALIC_YN())) {
				getCOMP_POAD_ALCOHOL_QUAN().setDisabled(false);
			} else {
				getCOMP_POAD_ALCOHOL_QUAN().setDisabled(true);
			}
			COMP_POAD_ALCOHOL_QUAN.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_ALCOHOL_QUAN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		Double POAD_ALCOHOL_QUAN = (Double) value;
		try {
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_ALCOHOL_QUAN(
					POAD_ALCOHOL_QUAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	// added by saranya for bmi on 13-04-16
	public static String sys_bmi;

	public static String getsysparameter() throws Exception {

		String query = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_Code= ?";
		sys_bmi = new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().selectbmivalue(
				query, "BMI_VAL");

		return sys_bmi;

	}

	// END

	public static String CheckAssured(String Pol_sys_id, String Assured_Code)
			throws Exception {
		String Assured_Name = null;
		String query = "select poad_assured_name from pt_il_pol_assured_dtls where  poad_pol_sys_id=? and poad_assr_code=?";
		Assured_Name = new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE()
				.selectassuredvalue(query, Pol_sys_id, Assured_Code);

		return Assured_Name;

	}

	public void saveRecord() throws Exception {
		CommonUtils.clearMaps(this);
		String message = null;
		/*Added by Ameen on 08-05-2018 for KIC as per Ajoy sugg. for CDOB*/
		PT_IL_POLICY pt_il_policy_bean = compositeAction .getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_POL_ASSURED_DTLS_1 pt_il_pol_assured_dtls_1_bean = compositeAction .getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		String P_M_CUST_AGE = "";
		PKG_PILT002_APAC PKG_PILT002_APAC_BEAN=new PKG_PILT002_APAC();
		List<String> pvalList = new ArrayList<String>();
		/*End*/
		try {
			double BMI = 0.0;
			// added by saranya for BMI on 13-04-2016
			 BMI = CommonUtils.nvl(compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_BMI(),0.0);

			/*
			 * String query ="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_Code= ?";
			 * String value= new
			 * PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().selectbmivalue
			 * (query,"BMI_VAL");
			 */
			String SysBmi_value = getsysparameter();
			System.out.println(SysBmi_value);
			int getbmi = Integer.parseInt(SysBmi_value);
			System.out.println("coverted value of bmi:" + getbmi);
			String Todo = "BMI QUESTIONARIES";
			if (BMI > getbmi){

				new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().updatemandatoryflag(
						compositeAction, "Y", Todo);
				System.out.println("manditary field if part value:"
						+ compositeAction
								.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
								.getPT_IL_DOC_TODO_LIST_STATUS_BEAN()
								.getDTLS_MANDATORY_YN());

			} else {
				new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().updatemandatoryflag(
						compositeAction, "N", Todo);
				System.out.println("manditary field else part value:"
						+ compositeAction
								.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
								.getPT_IL_DOC_TODO_LIST_STATUS_BEAN()
								.getDTLS_MANDATORY_YN());
			}
			// end
			/*cOMMENTED BY SANKARA NARAYANAN ON 07/04/2017 FOR SUMASSURED VALIDATION*/
			if("U".equalsIgnoreCase(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE())){
			if(("Y".equalsIgnoreCase(compositeAction
							.getPT_IL_POLICY_ACTION_BEAN().getPROD_RISK_FLG()))|| (new PILT002_APAC_LOCAL_PROCEDURES().L_RIDER_CHECK(compositeAction
									.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
									.getPOL_SYS_ID()))){
				if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE() == null) {
					
								
					throw new Exception( "Occupation Code:Validation Error: Value is required." );
			
				}
				
			}
			}else{
			 
			// added by krithika occupation code on 27-05-2016
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE() == null) {
				
				/*Modified by Shankar on 27/03/2017
				 * 
				 * throw new Exception(
						(Messages
								.getString(
										PELConstants.pelErrorMessagePath,
										"78888",
										new Object[] { "Occupation Code:Validation Error: Value is required." })));*/
				
				throw new Exception( "Occupation Code:Validation Error: Value is required." );
				
				/*End*/
				
			}
		}
		/*END*/
			helper.POAD_DOB_WHEN_VALIDATE_ITEM(compositeAction, this
					.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_DOB(), this,
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			System.out
					.println(" getPT_IL_POL_ASSURED_DTLS_BEAN().getROWID()    : "
							+ getPT_IL_POL_ASSURED_DTLS_BEAN().getROWID());

			System.out.println("POAD_BPH      "
					+ getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_BPH()
					+ "      POAD_BPL      "
					+ getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_BPL());

			/* Added by Ram on 21/11/2016 for BP High,Low value empty */

			if (CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_BPH(),0.0) == 0.0) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BPH(null);
			}

			if (CommonUtils.nvl(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_BPL(),0.0) == 0.0) {
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_BPL(null);
			}

			/* End */

			/* getPT_IL_POL_ASSURED_DTLS_BEAN().setROWID(null); */
			if (getPT_IL_POL_ASSURED_DTLS_BEAN().getROWID() == null) {

				String Assured_Code = compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_CONT_CODE();
				String Pol_SYS_ID = compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_SYS_ID().toString();
				System.out.println("Assured_Code    : " + Assured_Code);
				String Assured_Name = CheckAssured(Pol_SYS_ID, Assured_Code);
				System.out.println("Assured_Name     : " + Assured_Name);
				if (Assured_Name == null) {
					if (isINSERT_ALLOWED()) {

						helper.preInsert(compositeAction, compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN(), compositeAction
								.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
								PT_IL_POL_ASSURED_DTLS_BEAN);
						/*Added by Ameen on 31-07-2017 for ZBILQC-1733321*/
						P9ILPK_POLICY_NR p9ilpk_policy_nr = new P9ILPK_POLICY_NR();
						/*modified by Ameen on 08-08-2017 to add assrd_code,ht. & wgt. parameter for ZBILQC-1734095*/
						/*p9ilpk_policy_nr.P_UPD_PREM_FLAG(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
									PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HIV_TEST_YN());*/
						p9ilpk_policy_nr.P_UPD_PREM_FLAG(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
								PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE(),PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HIV_TEST_YN(),
								PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(),PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT());
						/*End*/
						new CRUDHandler().executeInsert(
								PT_IL_POL_ASSURED_DTLS_BEAN,
								CommonUtils.getConnection());
						helper.postInsert(compositeAction);
						helper.postQuery(compositeAction);
						message = Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save");
					} else {
						message = "Insert/update not allowed.";
					}
				} else {

					helper.preUpdate(compositeAction,
							getPT_IL_POL_ASSURED_DTLS_BEAN());
					/*Added by Ameen on 31-07-2017 for ZBILQC-1733321*/
					P9ILPK_POLICY_NR p9ilpk_policy_nr = new P9ILPK_POLICY_NR();
					/*modified by Ameen on 08-08-2017 to add assrd_code,ht. & wgt. parameter for ZBILQC-1734095*/
					/*p9ilpk_policy_nr.P_UPD_PREM_FLAG(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
								PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HIV_TEST_YN());*/
					p9ilpk_policy_nr.P_UPD_PREM_FLAG(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
							PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE(),PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HIV_TEST_YN(),
							PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(),PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT());
					/*End*/
					new CRUDHandler().executeUpdate(
							PT_IL_POL_ASSURED_DTLS_BEAN,
							CommonUtils.getConnection());
					helper.postQuery(compositeAction);
					// helper.postUpadte(compositeAction);
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");
				}

			} else if (PT_IL_POL_ASSURED_DTLS_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.preUpdate(compositeAction,
							getPT_IL_POL_ASSURED_DTLS_BEAN());
					/*Added by Ameen on 31-07-2017 for ZBILQC-1733321*/
					P9ILPK_POLICY_NR p9ilpk_policy_nr = new P9ILPK_POLICY_NR();
					/*modified by Ameen on 08-08-2017 to add assrd_code,ht. & wgt. parameter for ZBILQC-1734095*/
					/*p9ilpk_policy_nr.P_UPD_PREM_FLAG(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
								PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HIV_TEST_YN());*/
					p9ilpk_policy_nr.P_UPD_PREM_FLAG(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
							PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE(),PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HIV_TEST_YN(),
							PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HEIGHT(),PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_WEIGHT());
					/*End*/
					new CRUDHandler().executeUpdate(
							PT_IL_POL_ASSURED_DTLS_BEAN,
							CommonUtils.getConnection());
					helper.postQuery(compositeAction);
					// helper.postUpadte(compositeAction);
					/*Newly added by ganesh on 07-06-2017 as suggested by Kuzhandaivel */
					helper.postUpdate(compositeAction);
					/*end*/
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");
				} else {
					message = "Insert/update not allowed.";
				}
			}
			/*
			 * modified by Ameen on 01-02-2018 for KIC
			 * if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE_PROOF_FLAG()
					.equalsIgnoreCase("0")) {*/
			if (PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE_PROOF_FLAG() != null && PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_AGE_PROOF_FLAG()
					.equalsIgnoreCase("0")) {
				if (("".equalsIgnoreCase(PT_IL_POL_ASSURED_DTLS_BEAN
						.getPOAD_AGE_PROOF_OTHERS()) || PT_IL_POL_ASSURED_DTLS_BEAN
						.getPOAD_AGE_PROOF_OTHERS() == null)) {
					throw new ValidatorException(
							new FacesMessage(
									"Others Age proof:Validation Error: Value is required."));
				}
			}
			helper.autoUnderwritingValidate(compositeAction);
			/*Added by Ram on 21/01/2017 for Praganancy field capturing*/
			enablePraganacyField();
			/*End*/
			// compositeAction.setChkpremcalc(true);
			
			/*Added by Ameen on 08-05-2018 for KIC as per Ajoy sugg. for CDOB*/
			
			if("CDOB".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE())){
				
				pvalList = PKG_PILT002_APAC_BEAN.P_CAL_PLAN_PERIOD2(CommonUtils.getProcedureValue(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_DOB()), pt_il_policy_bean.getPOL_PLAN_CODE(), pt_il_policy_bean.getPOL_JOINT_LIFE_YN(), 
						PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE(), pt_il_pol_assured_dtls_1_bean.getPOAD_CATG_CODE(), CommonUtils.getProcedureValue(pt_il_pol_assured_dtls_1_bean.getPOAD_AGE()), 
						CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_START_DT()), dummy_bean.getUI_M_PROD_AGE_CALC_FLAG(), CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_SYS_ID()), 
						CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_ISSUE_DT()),pt_il_policy_bean.getROWID(), CommonUtils.getProcedureValue(dummy_bean.getUI_M_PROD_PERIOD_MULTIPLE()), pt_il_policy_bean.getPOL_END_TYPE(),
						P_M_CUST_AGE, CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_PERIOD()), CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_PREM_PAY_YRS()));
			
			}
			
			/*End*/
			/*Added by Ameen for KIC Endorsement pol_frz_flag issue as per Ajay sugg. on 05-07-2018*/
			if(endChangeFlag){
				 String updFrzFlagQry = "UPDATE PT_IL_POLICY SET POL_FLEX_20 = 'N' WHERE POL_SYS_ID = ?";
				 int updFrzFlag = new CRUDHandler().executeUpdateStatement(
						 updFrzFlagQry, CommonUtils.getConnection(),
						   new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				 System.out.println("POL_FLEX_20 HAS UPDATED IN ASSURED DTLS SCREEN ::::::" + updFrzFlag);
				 CommonUtils.setGlobalVariable("GLOBAL.FRZ_FLAG",null);
				 endChangeFlag = false;
			}
			/*End*/
			
			/*Newly Added by pidugu raj dt: 23-08-2018 for kic*/
			PT_IL_POL_CUST_DTLS polCustDetails = compositeAction .getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getpT_IL_POL_CUST_DTLS_BEAN();
			PT_IL_POL_CUST_DTLS polCustDetailsObj = new PT_IL_POL_CUST_DTLS();
			polCustDetailsObj = doGetPolCustDetails(compositeAction);
			
			if(polCustDetailsObj.getPCD_SYS_ID() == 0){ //For the first time
			polCustDetails = helper.doInsertAlternateCustomerDetails(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),polCustDetails);
			}else{ // if seq_id already present
			polCustDetails.setPCD_SYS_ID(polCustDetailsObj.getPCD_SYS_ID());
			polCustDetails = helper.doUpdateAlternateCustomerDetails(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),polCustDetails);	
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);
		} catch (Exception e) {
			e.printStackTrace();
			// String error
			// =ErrorHelpUtil.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			this.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			this.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
		}
	}

	public String chkNormalOrPakagePolicy() {
		String outCome = null;
		if ("NR".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))
				|| CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18") == null) {
			outCome = coverDetail();
			CommonUtils.setGlobalObject("POAD_SYS_ID",
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_SYS_ID());
			CommonUtils.setGlobalObject("GLOBAL_ASSURED_CODE",
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE());
			CommonUtils.setGlobalObject("GLOBAL_ASSURED_NAME",
					PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSURED_NAME());
		} else if ("PG".equals(CommonUtils
				.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
			outCome = productDetail();
		}
		CommonUtils.setGlobalObject("GLOBAL_POAD_TYPE",
				PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_TYPE());

		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setShow(false);

		return outCome;
	}

	public String coverDetail() {
		String reString = null;
		reString = "PILT002_APAC_PT_IL_POL_ADDL_COVER";
		return reString;
	}

	public String productDetail() {
		String reString = null;

		reString = "PILT002_APAC_PT_IL_POL_APPL_PROD";
		return reString;
	}

	public void delete() {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				helper.preDelete(compositeAction);
				new CRUDHandler().executeDelete(PT_IL_POL_ASSURED_DTLS_BEAN,
						CommonUtils.getConnection());

				CommonUtils.getConnection().commit();
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete");
				getWarningMap().put("deleteRow", message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				resetAllComponent();
				PT_IL_POL_ASSURED_DTLS_BEAN = new PT_IL_POL_ASSURED_DTLS();
				setBlockFlag(false);
			} else {
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_POAD_ASSR_CODE.resetValue();
		COMP_POAD_ASSURED_NAME.resetValue();
		COMP_POAD_FC_SALARY.resetValue();
		COMP_POAD_REF_ID1.resetValue();
		COMP_POAD_REF_ID2.resetValue();
		COMP_POAD_LC_SALARY.resetValue();
		COMP_POAD_BMI.resetValue();
		COMP_POAD_CATG_CODE.resetValue();
		COMP_UI_M_POAD_CATG_DESC.resetValue();
		COMP_POAD_BIRTH_PLACE.resetValue();
		COMP_POAD_HEIGHT.resetValue();
		COMP_POAD_RACE.resetValue();
		COMP_UI_M_POAD_RACE_CODE_DESC.resetValue();
		COMP_POAD_AGE.resetValue();
		COMP_POAD_WEIGHT.resetValue();
		COMP_POAD_NATURE_OF_WORK.resetValue();
		COMP_POAD_ADDL_RISK_CODE.resetValue();
		COMP_UI_M_ADDL_RISK_DESC.resetValue();
		COMP_UI_M_POAD_LC_THRESOLD_LMT.resetValue();
		COMP_POAD_AGE_PROOF_OTHERS.resetValue();
		COMP_POAD_LC_THRESHOLD_LMT.resetValue();
		COMP_POAD_DISC_AGE.resetValue();
		COMP_POAD_NO_OF_CIGAR.resetValue();
		COMP_POAD_REMARKS.resetValue();
		COMP_POAD_NATIONALITY.resetValue();
		COMP_UI_M_POAD_NATLITY_DESC.resetValue();
		COMP_POAD_MAR_STATUS.resetValue();
		COMP_UI_M_POAD_MS_DESC.resetValue();
		COMP_POAD_FC_SUM_ASSURED.resetValue();
		COMP_POAD_LC_SUM_ASSURED.resetValue();
		COMP_POAD_OCC_CODE.resetValue();
		COMP_UI_M_POAD_OCC_DESC.resetValue();
		COMP_POAD_FC_AMAN_PREM.resetValue();
		COMP_POAD_LC_AMAN_PREM.resetValue();
		COMP_POAD_OCC_CLASS.resetValue();
		COMP_UI_M_POAD_OCC_CLASS_DESC.resetValue();
		COMP_POAD_FC_AMAN_LOAD_PREM.resetValue();
		COMP_POAD_LC_AMAN_LOAD_PREM.resetValue();
		COMP_POAD_RELIGION_CODE.resetValue();
		COMP_UI_M_POAD_REL_CODE_DESC.resetValue();
		COMP_POAD_FC_SENABEL_PREM.resetValue();
		COMP_POAD_LC_SENABEL_PREM.resetValue();
		COMP_POAD_HEALTH_CODE.resetValue();
		COMP_UI_M_POAD_HEALTH_DESC.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_POAD_TYPE.resetValue();
		COMP_POAD_HEIGHT_UNIT.resetValue();
		COMP_POAD_WEIGHT_UNIT.resetValue();
		COMP_POAD_AGE_PROOF_FLAG.resetValue();
		COMP_POAD_SMOKE_YN.resetValue();
		COMP_POAD_POL_OWNER_YN.resetValue();

		// Reseting HtmlCalendar
		COMP_POAD_DOB.resetValue();

		
		/*Added by Janani on 07.03.2018 for FSD_FLA_IL_008*/
		
		COMP_POAD_FAMILY_YN_FLAG.resetValue();
		COMP_POAD_OCC_YN_FLAG.resetValue();
		
		/*End of FSD_FLA_IL_008*/
		
		/*Added by Ameen fro Medical occupation class*/
		COMP_POAD_MED_OCC_CLASS.resetValue();
		/*End*/
	}

	public List<SelectItem> getListPOAD_TYPE() {
		if (listPOAD_TYPE.size() == 0) {
			listPOAD_TYPE.clear();
			try {
				listPOAD_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAD_TYPE;
	}

	public List<SelectItem> getListPOAD_HEIGHT_UNIT() {
		if (listPOAD_HEIGHT_UNIT.size() == 0) {
			listPOAD_HEIGHT_UNIT.clear();
			try {
				listPOAD_HEIGHT_UNIT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAD_HEIGHT_UNIT;
	}

	public void setListPOAD_HEIGHT_UNIT(List<SelectItem> listPOAD_HEIGHT_UNIT) {
		this.listPOAD_HEIGHT_UNIT = listPOAD_HEIGHT_UNIT;
	}

	public List<SelectItem> getListPOAD_WEIGHT_UNIT() {
		if (listPOAD_WEIGHT_UNIT.size() == 0) {
			listPOAD_WEIGHT_UNIT.clear();
			try {
				listPOAD_WEIGHT_UNIT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAD_WEIGHT_UNIT;
	}

	public void setListPOAD_WEIGHT_UNIT(List<SelectItem> listPOAD_WEIGHT_UNIT) {
		this.listPOAD_WEIGHT_UNIT = listPOAD_WEIGHT_UNIT;
	}

	public List<SelectItem> getListPOAD_AGE_PROOF_FLAG() {
		if (listPOAD_AGE_PROOF_FLAG.size() == 0) {
			listPOAD_AGE_PROOF_FLAG.clear();
			try {
				listPOAD_AGE_PROOF_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAD_AGE_PROOF_FLAG;
	}

	// added by saranya on 31-03-2016 for BMI
	public void POAD_BMI_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("****Entered into bmi validation***");
			helper.POAD_BMI_VALIDATE_ITEM(this.getPT_IL_POL_ASSURED_DTLS_BEAN()
					.getPOAD_BMI());
			PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_BMI();
			System.out.println(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_BMI());
			// helper.POAD_BMI_VALIDATE_ITEM(this);
			System.out.println("BMI GET VAlUE" + getCOMP_POAD_BMI());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	// end

	public void setListPOAD_AGE_PROOF_FLAG(
			List<SelectItem> listPOAD_AGE_PROOF_FLAG) {
		this.listPOAD_AGE_PROOF_FLAG = listPOAD_AGE_PROOF_FLAG;
	}

	public List<SelectItem> getListPOAD_SMOKE_YN() {
		if (listPOAD_SMOKE_YN.size() == 0) {
			listPOAD_SMOKE_YN.clear();
			try {
				listPOAD_SMOKE_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAD_SMOKE_YN;
	}

	public void setListPOAD_SMOKE_YN(List<SelectItem> listPOAD_SMOKE_YN) {
		this.listPOAD_SMOKE_YN = listPOAD_SMOKE_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void onLoad(PhaseEvent event) {
		try {

			if (isBlockFlag()) {

				/*Added by Shankar on 07/04/2017*/
				getErrorMap()
				.clear();
				getWarningMap()
				.clear();
				
				/*Added by pidugu raj dt: 24-08-2018 for KICLIFEQC-1762429*/
				PT_IL_POL_CUST_DTLS pT_IL_POL_CUST_DTLS1 =compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getpT_IL_POL_CUST_DTLS_BEAN();
				System.out.println("Current Freeze flag value: "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG());
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG().equalsIgnoreCase("Y")){
				/*	COMP_CUST_NAME.setDisabled(true);
					COMP_CUST_RELN.setDisabled(true);
					COMP_CIVIL_ID.setDisabled(true);
					COMP_CUST_DOB.setDisabled(true);*/
				}
				else{
					/*COMP_CUST_NAME.setDisabled(false);
					COMP_CUST_RELN.setDisabled(false);
					COMP_CIVIL_ID.setDisabled(false);
					COMP_CUST_DOB.setDisabled(false);*/
				}
				/*Added by pidugu raj dt: 24-08-2018 for KICLIFEQC-1762429*/
				pT_IL_POL_CUST_DTLS1 = helper.doGetPolCustDetails(compositeAction);
				if(pT_IL_POL_CUST_DTLS1 != null){
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().setpT_IL_POL_CUST_DTLS_BEAN(pT_IL_POL_CUST_DTLS1);
				}
				/*End*/
/*End*/
				/*Added by ganesh on 18-01-2018 for 207R morecover funeral */
				addCoverRider();
				/*end*/
				
				/* Added by Janani on 13.8.2016 for IC no length issue */

				int fieldLength = 0;
				int PS_VALUE = (int) CommonUtils.getGlobalObject("M_PS_VALUE");
				fieldLength = (int) CommonUtils.getGlobalObject("FIELD_LENGTH");

				System.out.println("fieldLength         " + fieldLength);

				if (PS_VALUE == 1) {
					System.out.println("enters into PS_VALUE == 1");
					// compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(12);
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getCOMP_POAD_REF_ID1().setMaxlength(fieldLength);
				} else if (PS_VALUE == 2) {
					System.out.println("enters into PS_VALUE == 2");
					// compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(24);
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getCOMP_POAD_REF_ID1().setMaxlength(fieldLength);
				}

				/* end */

				if ("NR".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_18"))
						|| CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18") == null) {
					COMP_PT_IL_POL_APPL_PROD.setLabel("Cover Details");
				} else if ("PG".equals(CommonUtils
						.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
					COMP_PT_IL_POL_APPL_PROD.setLabel("Product Details");
				}
				compositeAction.getWizard().enableWizardItem(
						"PILT002_APAC_PT_IL_PREM_DTLS");
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.preQuery(compositeAction);

				System.out
						.println("---------- Enter the PT_IL_POL_ASSURED_DTLS_ACTION class ------------");
				System.out.println("Before executeQuery ");
				System.out.println("POAD_FC_SUM_ASSURED    : "
						+ compositeAction
								.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_BEAN()
								.getPOAD_FC_SUM_ASSURED());
				System.out.println("------------------------------------");

				/*
				 * Posted here b Ramkumar on 06-08-2016 for Height and weight
				 * issue
				 */
				helper.executeQuery(compositeAction);
				/* End */
				System.out.println("After executeQuery ");
				System.out.println("POAD_FC_SUM_ASSURED    : "
						+ compositeAction
								.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_BEAN()
								.getPOAD_FC_SUM_ASSURED());
				System.out.println("------------------------------------");

				System.out
						.println("PT_IL_POL_ASSURED_DTLS_BEAN.getROWID()           "
								+ PT_IL_POL_ASSURED_DTLS_BEAN.getROWID());
				if (PT_IL_POL_ASSURED_DTLS_BEAN.getROWID() != null) {
					/* helper.executeQuery(compositeAction); */

					helper.setassured(compositeAction);// ////////ADDED BY GOPI
														// FOR DEFAULTING
														// ASSURED NAME
					if (PT_IL_POL_ASSURED_DTLS_BEAN.getROWID() != null
							&& PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE() == null) {
						helper.forCopiedPolicy(compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN(),
								PT_IL_POL_ASSURED_DTLS_BEAN);
					}
					helper.postQuery(compositeAction);
					helper.on_Populate_Detail(compositeAction);
				} else {
					helper.WHEN_CREATE_RECORD(compositeAction);
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN()
							.setPOAD_FC_SALARY(0.0);
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN()
							.setPOAD_LC_SALARY(0.0);
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_MED_OCC_CLASS("0");
				}
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction,
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN());
				helper.checktakaful(compositeAction);
				/*Commented by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS*/
				/*COMP_POAD_LC_SUM_ASSURED.resetValue();
				COMP_POAD_FC_SUM_ASSURED.resetValue();*/
				/*End*/

				helper.discAgeCodeCheck(compositeAction);
				
				
				/*Added by Janani on 03.04.2017 as part of factory testing feedback Customer Master - Validation point*/
				
				//getNationalityID();
				
	System.out.println("assured dtls bean above                     :"+PT_IL_POL_ASSURED_DTLS_BEAN.getROWID());
				
				/*if(PT_IL_POL_ASSURED_DTLS_BEAN.getROWID() == null)
				{
					*/
					System.out.println("inside assured dtls bean                      :");
					
					
					
			/*	}*/
				
				/*End*/
				/*Added by saritha on 11-May-2017 for ssp call id ZBILQC-1722014*/
				Connection connection = null;
				ResultSet resultSet = null;
				ResultSet resultSet1 = null;
				/*added by gopi for ssp call id ZBILQC-1726698 on 12/06/17*/
				ResultSet resultSet2 = null;
				String CUST_AGE_ADMITTED=null;
				String CUST_AGE_PROOF_FLAG=null;
				String CUST_AGE_PROOF_OTHERS=null;
				
				//END
				/*
				 * commneted by Ameen on 05-08-2017 for resetting the occ. code even after changed issue
				 * String CUST_OCC_CODE= null;*/
				String PC_DESC = null;
				String value = null;
				connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				System.out.println("Assured code:::::"+compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_ASSR_CODE());
				/*
				 * commneted by Ameen on 05-08-2017 for resetting the occ. code even after changed issue
				 * String C1 ="SELECT CUST_OCC_CODE from PM_CUSTOMER where CUST_CODE=?";
				
				resultSet = handler.executeSelectStatement(C1, connection,
						new Object[] {PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE()});

				while(resultSet.next()){

					CUST_OCC_CODE=resultSet.getString(1);
					System.out.println("Ocupation code ------>"+CUST_OCC_CODE);

				}*/
				if(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE()!=null)

				{
					
					/*
					 * commneted by Ameen on 05-08-2017 for resetting the occ. code even after changed issue
					 * if(CUST_OCC_CODE!=null){
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_OCC_CODE(CUST_OCC_CODE);
					COMP_POAD_OCC_CODE.resetValue();
					}*/

					System.out.println("source of business"+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE());
					String C2="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE='IL_OCCU' AND PC_CODE=?";
					resultSet1 = handler.executeSelectStatement(C2, connection,
							new Object[] {PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE()});
					while(resultSet1.next()) {
						PC_DESC =resultSet1.getString("PC_DESC");
						System.out.println("Value Of PC_DESC ------->"+PC_DESC);
						PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_OCC_DESC(PC_DESC);
						COMP_UI_M_POAD_OCC_DESC.resetValue();
					}
	
					if(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE()!= null){
					helper.POAD_OCC_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_CODE(),
							PT_IL_POL_ASSURED_DTLS_BEAN);

				}
					/*added by gopi for ssp call id ZBILQC-1726698 on 12/06/17*/
				/*String query="select CUST_AGE_ADMITTED,CUST_AGE_PROOF_FLAG,CUST_AGE_PROOF_OTHERS FROM PM_CUSTOMER where CUST_CODE=?";
				resultSet2 = handler.executeSelectStatement(query, connection,
						new Object[] {PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_ASSR_CODE()});

				while(resultSet2.next()){

					CUST_AGE_ADMITTED=resultSet2.getString("CUST_AGE_ADMITTED");
					CUST_AGE_PROOF_FLAG=resultSet2.getString("CUST_AGE_PROOF_FLAG");
					CUST_AGE_PROOF_OTHERS=resultSet2.getString("CUST_AGE_PROOF_OTHERS");
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_ADMITTED(CUST_AGE_ADMITTED);
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_FLAG(CUST_AGE_PROOF_FLAG);
					PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_OTHERS(CUST_AGE_PROOF_OTHERS);

				}
					*/
				//end	
					
				}
				
				/*End*/

				
				
				setBlockFlag(false);
				/* } */
				/* Added by saranya for age proof tabing issue on 12-10-16 */

				System.out.println("POAD_AGE_PROOF_FLAG    : "
						+ compositeAction
								.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_BEAN()
								.getPOAD_AGE_PROOF_FLAG());

				System.out.println("ÄFTER POAD_AGE_PROOF_FLAG LINE");
				compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.setPremium_Brk_Flag(true);
				// COMP_POAD_ASSURED_NAME.setDisabled(true);//disable payor name
				// always
				System.out.println("1111");
				if ("001".equalsIgnoreCase(CommonUtils.nvl(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_END_TYPE(), "000"))
						&& "N".equalsIgnoreCase(compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())) {
					PT_IL_POL_ASSURED_DTLS_BEAN
							.setPOAD_ASSURED_NAME(compositeAction
									.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN()
									.getPOL_ASSURED_NAME());
				}
				System.out.println("2222");
				/*
				 * Added By Dhinesh for SSP call id : FALCONLIFE-1344824 on
				 * 29.9.2016
				 */

				System.out
						.println("compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_REF_ID1()   : "
								+ compositeAction
										.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
										.getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_REF_ID1());
				helper.POAD_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_REF_ID1(),
						compositeAction, getPT_IL_POL_ASSURED_DTLS_BEAN());
				System.out.println("33333");
				/* End */

				/*
				 * commented by dhinesh for ssp call id : FALCONLIFE-1351160
				 * 
				 * if("0".equalsIgnoreCase(compositeAction.
				 * getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN
				 * ().getPT_IL_POL_ASSURED_DTLS_BEAN
				 * ().getPOAD_AGE_PROOF_FLAG()))
				 */
				
				/*Modified by Janani on 27.06.2017 for ZBILQC-1730061*/
				
				/*if ("0".equalsIgnoreCase(compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN()
						.getPOAD_AGE_PROOF_FLAG())
						|| compositeAction
								.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_BEAN()
								.getPOAD_AGE_PROOF_FLAG() == null)*/

				System.out.println("getPOL_FRZ_FLAG  in assured dtls               :"+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG());
				System.out.println("getPOL_DS_TYPE in assured dtls                 :"+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE());
				System.out.println("getPOL_APPRV_STATUS in assured dtls            :"+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS());
				
				
				if (("0".equalsIgnoreCase(compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN()
						.getPOAD_AGE_PROOF_FLAG())
						|| compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN()
						.getPOAD_AGE_PROOF_FLAG() == null )&&
						"N".equalsIgnoreCase(compositeAction
								.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())
								&& compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE().equals("1") 
								&& compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS().equalsIgnoreCase("n"))
		
					
					/*End*/
					
				{
					System.out.println("True");
					COMP_POAD_AGE_PROOF_OTHERS.setDisabled(false);
					//COMP_POAD_AGE_PROOF_OTHERS.resetValue();
					
					/*Added by Janani on 16.05.2017 for SSP call ID ZBILQC-1724084*/
					COMP_POAD_AGE_PROOF_OTHERS.setRequired(true);
					/*End*/
					
					
				} else {
					System.out.println("False");
					COMP_POAD_AGE_PROOF_OTHERS.setDisabled(true);
					//COMP_POAD_AGE_PROOF_OTHERS.resetValue();
					
					/*Added by Janani on 16.05.2017 for SSP call ID ZBILQC-1724084*/
					COMP_POAD_AGE_PROOF_OTHERS.setRequired(false);
					/*End*/
				}
				


				/*Added by Shankar on 07/04/2017*/
				if("U".equalsIgnoreCase(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE())){
				if(("Y".equalsIgnoreCase(compositeAction
								.getPT_IL_POLICY_ACTION_BEAN().getPROD_RISK_FLG()))|| (new PILT002_APAC_LOCAL_PROCEDURES().L_RIDER_CHECK(compositeAction
										.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
										.getPOL_SYS_ID()))){
					COMP_POAD_OCC_CLASS.setRequired(true);
					COMP_POAD_OCC_CODE.setRequired(true);
					
				}else{
					COMP_POAD_OCC_CLASS.setRequired(false);
					COMP_POAD_OCC_CODE.setRequired(false);
				}
				}else{
					COMP_POAD_OCC_CLASS.setRequired(true);
					COMP_POAD_OCC_CODE.setRequired(true);
				}
				/*End*/


				
				/*Added by saritha on 02-Mar-2017 RM018T - DEV_IL_ZB Life_012b_Claim waiting period*/
				/*Commentted by saritha on 24-May-2017 for ZBILQC-1725255*/
				/*COMP_POAD_HIV_TEST_YN.setDisabled(true);*/
				/*End*/
				
				/* Newly Added By Dhinesh on 31.7.2017 for ssp call id : ZBILQC-1733516 */
				
				/*Modified by Janani on 04.08.2017 while checking Occupation class not disabled issue*/
				
				System.out.println("getPOL_END_CODE          "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE());
				
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null && CommonUtils.isIN(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE(),"INCSA","DECSA"))
				
				/*if(CommonUtils.isIN(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE(),"INSCA","DECSA"))*/	
					
					
				/*End*/	
				{
					if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("N"))
					{ 
						setUPDATE_ALLOWED(true);
						COMP_POAD_HIV_TEST_YN.setDisabled(false);
						if("Y".equalsIgnoreCase(compositeAction
								.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_HIV_TEST_YN()))
						{

							compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setUPDATE_ALLOWED(true);
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setINSERT_ALLOWED(true);
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setDELETE_ALLOWED(true);
						}
						else
						{
							compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setUPDATE_ALLOWED(false);
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setINSERT_ALLOWED(false);
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setDELETE_ALLOWED(false);
						}
					}


				}
				/*NEWLY ADDED BY DHINESH ON 04-05-2018 */
				/*
				 * modified by Ameen on 08-05-2018 as per Ajoy sugg.
				 * if(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null && CommonUtils.isIN(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE(),"GEN016"))*/
				
				/*Commented and modified by Janani on 04.06.2018 for Fidelity payor DOB enabled after policy approved*/
				/*if(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null && CommonUtils.isIN(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE(),"CDOB"))*/
				
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null && CommonUtils.isIN(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE(),"CDOB") && compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("n"))
					
				/*End*/	
								
				{
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_DOB().setDisabled(false); 
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_DOB().resetValue();
				}
				/*END*/
				
				
				/* End */
		
			
			
			}		
			/*Added by saritha on 12-May-2017 for ssp call id ZBILQC-1722014*/
			COMP_UI_M_POAD_OCC_DESC.setDisabled(true);
			/*End*/
			
			
			/*Added by Janani on 28.06.2017 for ZBILQC-1730061*/
			
			
		if("y".equalsIgnoreCase(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())
					|| compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS().equalsIgnoreCase("A"))
					{
			
			System.out.println("COMP_POAD_OCC_CLASS is disabled");
			
						COMP_POAD_OCC_CLASS.setDisabled(true);
					}
		/*End*/	
		/*Added by Ameen on 14-07-2017 for ZBILQC-1731655 */
		/*
		 * modified by Ameen on 15-03-2018 to add "END" condition as per siva sugg.
		 * if("U".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE())){*/
		if("U".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE()) && !"END".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())){
			String cvrQry = "SELECT 'X' FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ?";
			String checkcvr = "";
			ResultSet rs = null;
			rs = new CRUDHandler().executeSelectStatement(cvrQry, CommonUtils.getConnection(), 
					new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			if(rs.next()){
					System.out.println("inside U plan type field mandotary if");
					COMP_POAD_HEIGHT.setRequired(true);
					COMP_POAD_WEIGHT.setRequired(true);
					COMP_POAD_OCC_CODE.setRequired(true);
					COMP_POAD_OCC_CLASS.setRequired(true);
					/*Modified by ganesh on 23-10-2017 as suggested by ajoy */
					/*Modified by ganesh on 24-11-2017. changed the if Condition.When we add riders we cant able to give height and weight that issue resolved*/ 
					/*if("ADDRIDER".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()) && !"Y".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())){*/
					if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX()==0 || "ADDRIDER".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE())) && !"Y".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())){	
						setUPDATE_ALLOWED(true);
						COMP_POAD_HEIGHT.setDisabled(false);
						COMP_POAD_WEIGHT.setDisabled(false);
						COMP_POAD_HIV_TEST_YN.setRequired(true);
						COMP_POAD_HIV_TEST_YN.setDisabled(false);						
					}else{
						COMP_POAD_HEIGHT.setDisabled(true);
						COMP_POAD_WEIGHT.setDisabled(true);						
						COMP_POAD_HIV_TEST_YN.setDisabled(true);
					}
					/*end*/
			}else{
				System.out.println("inside U plan type field mandotary else");
				COMP_POAD_HEIGHT.setRequired(false);
				COMP_POAD_WEIGHT.setRequired(false);
				COMP_POAD_OCC_CODE.setRequired(false);
				COMP_POAD_OCC_CLASS.setRequired(false);
			}
		}else{
			COMP_POAD_OCC_CODE.setRequired(true);
			COMP_POAD_OCC_CLASS.setRequired(true);
		}
		/*End*/
			
		
		 /*ADDED BY RAJA ON 12-08-2017 for discussed with ajoy*/
		if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE()!=null &&
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equalsIgnoreCase("COCCP"))
		{
			COMP_POAD_OCC_CLASS.setDisabled(true);
		}
		/*end*/

		/* Newly Added By Dhinesh on 09-01-2018 */
		
		if("KIC/".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")))
		{
			COMP_PERSONAL_INFO_TAB.setRendered(false);
			
			/*added by Ameen on 17-01-2018 to set required false for hiding fields*/
			COMP_POAD_CATG_CODE.setRequired(false);
			COMP_POAD_AGE.setRequired(false);
			COMP_POAD_AGE_PROOF_OTHERS.setRequired(false);
			COMP_POAD_HEIGHT.setRequired(true);
			COMP_POAD_WEIGHT.setRequired(true);
			/*End*/
		}
		
		/*added by gopi for toi on 30/05/18*/
		
		String MANT_AND_NONMANT=fetchInstanceData("PT_IL_POL_ASSURED_DTLS","PILT002_APAC","POAD_HEIGHT",5);
		System.out.println("Tested Value-->"+fetchInstanceData("PT_IL_POL_ASSURED_DTLS","PILT002_APAC","POAD_HEIGHT",5));
		if(MANT_AND_NONMANT!=null && "1".equalsIgnoreCase(MANT_AND_NONMANT)){
			compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_HEIGHT().setRequired(false);
			compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_WEIGHT().setRequired(false);
		}else{
			/*Newly added by pidugu raj dt: 07-12-2020 as suggested by Abhilash for Alliance Cusotmer*/
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().equalsIgnoreCase("KMAN001")){
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_HEIGHT().setRequired(false);
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_WEIGHT().setRequired(false);
			}else{//End
			compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_HEIGHT().setRequired(true);
			compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getCOMP_POAD_WEIGHT().setRequired(true);
			}
		}
		
		//end
		
		
		/* End */
		System.out.println("assured category :: " + PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE());
		
		
		
		/*Added by Janani on 07.03.2018 for FSD_FLA_IL_008*/
		
		System.out.println("getPOAD_FAMILY_YN                 "+compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FAMILY_YN());
		
		System.out.println("getPOAD_OCC_YN                 "+compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_OCC_YN());
		
		if(("Y".equalsIgnoreCase(compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FAMILY_YN()))){

			COMP_POAD_FAMILY_YN_BUT.setDisabled(false);

		}else{

			COMP_POAD_FAMILY_YN_BUT.setDisabled(true);
		}


		if(("Y".equalsIgnoreCase(compositeAction
				.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_OCC_YN()))){

			COMP_POAD_OCC_YN_BUT.setDisabled(false);

		}else{

			COMP_POAD_OCC_YN_BUT.setDisabled(true);

		}
		
		/*End of FSD_FLA_IL_008*/
		/*Added by Ameen on 17-04-2018 for KIC to enable medical occ. class for plantye = "U"*/
		if(!"U".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE())){
			COMP_POAD_MED_OCC_CLASS.setDisabled(true);
		}
		/*End*/
		
		/*Added by Janani on 21.06.2018 for FLALIFEQC-1753794 */
		if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().equalsIgnoreCase("jwlp"))
		{
		COMP_POAD_POL_OWNER_YN.setDisabled(true);
		}
		
		/*End of FLALIFEQC-1753794 */
		
		/*Added by Janani on 02.07.2018 for Rider not getting defaulted while coming from Premium dtls*/
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setBlockFlag(true);
		/*End*/
		

		
		/*Added by pidugu raj dt: 27-08-2018 for KICLIFEQC-1762429
		if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG().equalsIgnoreCase("Y")){
			COMP_CUST_NAME.setDisabled(true);
			COMP_CUST_RELN.setDisabled(true);
			COMP_CIVIL_ID.setDisabled(true);
			COMP_CUST_DOB.setDisabled(true);
		}else{
			COMP_CUST_NAME.setDisabled(false);
			COMP_CUST_RELN.setDisabled(false);
			COMP_CIVIL_ID.setDisabled(false);
			COMP_CUST_DOB.setDisabled(false);
		}*/
		/*End added by pidugu raj dt: 27-08-2018 KICLIFEQC-1762429*/
		} catch (Exception e) {
			/*Added by Janani on 04.08.2017 while checking Occupation class not disabled issue*/
			e.printStackTrace();
			
			/*End*/
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	/*Added by pidugu raj dt: 24-08-2018 for kic*/
	public void onLoadNew(){
		try{
			/*Added by pidugu raj dt: 24-08-2018 for KIC*/
			PT_IL_POL_CUST_DTLS pT_IL_POL_CUST_DTLS1 = new PT_IL_POL_CUST_DTLS();
			
			
			pT_IL_POL_CUST_DTLS1 = helper.doGetPolCustDetails(compositeAction);
			if(pT_IL_POL_CUST_DTLS1 != null){
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().setpT_IL_POL_CUST_DTLS_BEAN(pT_IL_POL_CUST_DTLS1);
			}
			/*End*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_POAD_ASSR_CODE_LABEL() {
		return COMP_POAD_ASSR_CODE_LABEL;
	}

	public void setCOMP_POAD_ASSR_CODE_LABEL(
			HtmlOutputLabel comp_poad_assr_code_label) {
		COMP_POAD_ASSR_CODE_LABEL = comp_poad_assr_code_label;
	}

	public HtmlInputText getCOMP_POAD_ASSR_CODE() {
		return COMP_POAD_ASSR_CODE;
	}

	public void setCOMP_POAD_ASSR_CODE(HtmlInputText comp_poad_assr_code) {
		COMP_POAD_ASSR_CODE = comp_poad_assr_code;
	}

	public HtmlOutputLabel getCOMP_POAD_ASSURED_NAME_LABEL() {
		return COMP_POAD_ASSURED_NAME_LABEL;
	}

	public void setCOMP_POAD_ASSURED_NAME_LABEL(
			HtmlOutputLabel comp_poad_assured_name_label) {
		COMP_POAD_ASSURED_NAME_LABEL = comp_poad_assured_name_label;
	}

	public HtmlInputText getCOMP_POAD_ASSURED_NAME() {
		return COMP_POAD_ASSURED_NAME;
	}

	public void setCOMP_POAD_ASSURED_NAME(HtmlInputText comp_poad_assured_name) {
		COMP_POAD_ASSURED_NAME = comp_poad_assured_name;
	}

	public HtmlOutputLabel getCOMP_POAD_FC_SALARY_LABEL() {
		return COMP_POAD_FC_SALARY_LABEL;
	}

	public void setCOMP_POAD_FC_SALARY_LABEL(
			HtmlOutputLabel comp_poad_fc_salary_label) {
		COMP_POAD_FC_SALARY_LABEL = comp_poad_fc_salary_label;
	}

	public HtmlInputText getCOMP_POAD_FC_SALARY() {
		return COMP_POAD_FC_SALARY;
	}

	public void setCOMP_POAD_FC_SALARY(HtmlInputText comp_poad_fc_salary) {
		COMP_POAD_FC_SALARY = comp_poad_fc_salary;
	}

	public HtmlOutputLabel getCOMP_POAD_REF_ID1_LABEL() {
		return COMP_POAD_REF_ID1_LABEL;
	}

	public void setCOMP_POAD_REF_ID1_LABEL(

	HtmlOutputLabel comp_poad_ref_id1_label) {
		COMP_POAD_REF_ID1_LABEL = comp_poad_ref_id1_label;
	}

	public HtmlInputText getCOMP_POAD_REF_ID1() {
		return COMP_POAD_REF_ID1;
	}

	public void setCOMP_POAD_REF_ID1(HtmlInputText comp_poad_ref_id1) {
		COMP_POAD_REF_ID1 = comp_poad_ref_id1;
	}

	public HtmlOutputLabel getCOMP_POAD_REF_ID2_LABEL() {
		return COMP_POAD_REF_ID2_LABEL;
	}

	public void setCOMP_POAD_REF_ID2_LABEL(
			HtmlOutputLabel comp_poad_ref_id2_label) {
		COMP_POAD_REF_ID2_LABEL = comp_poad_ref_id2_label;
	}

	public HtmlInputText getCOMP_POAD_REF_ID2() {
		return COMP_POAD_REF_ID2;
	}

	public void setCOMP_POAD_REF_ID2(HtmlInputText comp_poad_ref_id2) {
		COMP_POAD_REF_ID2 = comp_poad_ref_id2;
	}

	public HtmlOutputLabel getCOMP_POAD_LC_SALARY_LABEL() {
		return COMP_POAD_LC_SALARY_LABEL;
	}

	public void setCOMP_POAD_LC_SALARY_LABEL(
			HtmlOutputLabel comp_poad_lc_salary_label) {
		COMP_POAD_LC_SALARY_LABEL = comp_poad_lc_salary_label;
	}

	public HtmlInputText getCOMP_POAD_LC_SALARY() {
		return COMP_POAD_LC_SALARY;
	}

	public void setCOMP_POAD_LC_SALARY(HtmlInputText comp_poad_lc_salary) {
		COMP_POAD_LC_SALARY = comp_poad_lc_salary;
	}

	public HtmlOutputLabel getCOMP_POAD_BMI_LABEL() {
		return COMP_POAD_BMI_LABEL;
	}

	public void setCOMP_POAD_BMI_LABEL(HtmlOutputLabel comp_poad_bmi_label) {
		COMP_POAD_BMI_LABEL = comp_poad_bmi_label;
	}

	public HtmlInputText getCOMP_POAD_BMI() {
		return COMP_POAD_BMI;
	}

	public void setCOMP_POAD_BMI(HtmlInputText comp_poad_bmi) {
		COMP_POAD_BMI = comp_poad_bmi;
	}

	public HtmlOutputLabel getCOMP_POAD_TYPE_LABEL() {
		return COMP_POAD_TYPE_LABEL;
	}

	public void setCOMP_POAD_TYPE_LABEL(HtmlOutputLabel comp_poad_type_label) {
		COMP_POAD_TYPE_LABEL = comp_poad_type_label;
	}

	public HtmlSelectOneMenu getCOMP_POAD_TYPE() {
		return COMP_POAD_TYPE;
	}

	public void setCOMP_POAD_TYPE(HtmlSelectOneMenu comp_poad_type) {
		COMP_POAD_TYPE = comp_poad_type;
	}

	public HtmlOutputLabel getCOMP_POAD_CATG_CODE_LABEL() {
		return COMP_POAD_CATG_CODE_LABEL;
	}

	public void setCOMP_POAD_CATG_CODE_LABEL(
			HtmlOutputLabel comp_poad_catg_code_label) {
		COMP_POAD_CATG_CODE_LABEL = comp_poad_catg_code_label;
	}

	public HtmlInputText getCOMP_POAD_CATG_CODE() {
		return COMP_POAD_CATG_CODE;
	}

	public void setCOMP_POAD_CATG_CODE(HtmlInputText comp_poad_catg_code) {
		COMP_POAD_CATG_CODE = comp_poad_catg_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_CATG_DESC_LABEL() {
		return COMP_UI_M_POAD_CATG_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAD_CATG_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_poad_catg_desc_label) {
		COMP_UI_M_POAD_CATG_DESC_LABEL = comp_ui_m_poad_catg_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_CATG_DESC() {
		return COMP_UI_M_POAD_CATG_DESC;
	}

	public void setCOMP_UI_M_POAD_CATG_DESC(
			HtmlInputText comp_ui_m_poad_catg_desc) {
		COMP_UI_M_POAD_CATG_DESC = comp_ui_m_poad_catg_desc;
	}

	public HtmlOutputLabel getCOMP_POAD_BIRTH_PLACE_LABEL() {
		return COMP_POAD_BIRTH_PLACE_LABEL;
	}

	public void setCOMP_POAD_BIRTH_PLACE_LABEL(
			HtmlOutputLabel comp_poad_birth_place_label) {
		COMP_POAD_BIRTH_PLACE_LABEL = comp_poad_birth_place_label;
	}

	public HtmlInputText getCOMP_POAD_BIRTH_PLACE() {
		return COMP_POAD_BIRTH_PLACE;
	}

	public void setCOMP_POAD_BIRTH_PLACE(HtmlInputText comp_poad_birth_place) {
		COMP_POAD_BIRTH_PLACE = comp_poad_birth_place;
	}

	public HtmlOutputLabel getCOMP_POAD_DOB_LABEL() {
		return COMP_POAD_DOB_LABEL;
	}

	public void setCOMP_POAD_DOB_LABEL(HtmlOutputLabel comp_poad_dob_label) {
		COMP_POAD_DOB_LABEL = comp_poad_dob_label;
	}

	public HtmlCalendar getCOMP_POAD_DOB() {
		return COMP_POAD_DOB;
	}

	public void setCOMP_POAD_DOB(HtmlCalendar comp_poad_dob) {
		COMP_POAD_DOB = comp_poad_dob;
	}

	public HtmlOutputLabel getCOMP_POAD_HEIGHT_LABEL() {
		return COMP_POAD_HEIGHT_LABEL;
	}

	public void setCOMP_POAD_HEIGHT_LABEL(HtmlOutputLabel comp_poad_height_label) {
		COMP_POAD_HEIGHT_LABEL = comp_poad_height_label;
	}

	public HtmlInputText getCOMP_POAD_HEIGHT() {
		return COMP_POAD_HEIGHT;
	}

	public void setCOMP_POAD_HEIGHT(HtmlInputText comp_poad_height) {
		COMP_POAD_HEIGHT = comp_poad_height;
	}

	public HtmlOutputLabel getCOMP_POAD_HEIGHT_UNIT_LABEL() {
		return COMP_POAD_HEIGHT_UNIT_LABEL;
	}

	public void setCOMP_POAD_HEIGHT_UNIT_LABEL(
			HtmlOutputLabel comp_poad_height_unit_label) {
		COMP_POAD_HEIGHT_UNIT_LABEL = comp_poad_height_unit_label;
	}

	public HtmlSelectOneMenu getCOMP_POAD_HEIGHT_UNIT() {
		return COMP_POAD_HEIGHT_UNIT;
	}

	public void setCOMP_POAD_HEIGHT_UNIT(HtmlSelectOneMenu comp_poad_height_unit) {
		COMP_POAD_HEIGHT_UNIT = comp_poad_height_unit;
	}

	public HtmlOutputLabel getCOMP_POAD_RACE_LABEL() {
		return COMP_POAD_RACE_LABEL;
	}

	public void setCOMP_POAD_RACE_LABEL(HtmlOutputLabel comp_poad_race_label) {
		COMP_POAD_RACE_LABEL = comp_poad_race_label;
	}

	public HtmlInputText getCOMP_POAD_RACE() {
		return COMP_POAD_RACE;
	}

	public void setCOMP_POAD_RACE(HtmlInputText comp_poad_race) {
		COMP_POAD_RACE = comp_poad_race;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_RACE_CODE_DESC_LABEL() {
		return COMP_UI_M_POAD_RACE_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAD_RACE_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_poad_race_code_desc_label) {
		COMP_UI_M_POAD_RACE_CODE_DESC_LABEL = comp_ui_m_poad_race_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_RACE_CODE_DESC() {
		return COMP_UI_M_POAD_RACE_CODE_DESC;
	}

	public void setCOMP_UI_M_POAD_RACE_CODE_DESC(
			HtmlInputText comp_ui_m_poad_race_code_desc) {
		COMP_UI_M_POAD_RACE_CODE_DESC = comp_ui_m_poad_race_code_desc;
	}

	public HtmlOutputLabel getCOMP_POAD_AGE_LABEL() {
		return COMP_POAD_AGE_LABEL;
	}

	public void setCOMP_POAD_AGE_LABEL(HtmlOutputLabel comp_poad_age_label) {
		COMP_POAD_AGE_LABEL = comp_poad_age_label;
	}

	public HtmlInputText getCOMP_POAD_AGE() {
		return COMP_POAD_AGE;
	}

	public void setCOMP_POAD_AGE(HtmlInputText comp_poad_age) {
		COMP_POAD_AGE = comp_poad_age;
	}

	public HtmlOutputLabel getCOMP_POAD_WEIGHT_LABEL() {
		return COMP_POAD_WEIGHT_LABEL;
	}

	public void setCOMP_POAD_WEIGHT_LABEL(HtmlOutputLabel comp_poad_weight_label) {
		COMP_POAD_WEIGHT_LABEL = comp_poad_weight_label;
	}

	public HtmlInputText getCOMP_POAD_WEIGHT() {
		return COMP_POAD_WEIGHT;
	}

	public void setCOMP_POAD_WEIGHT(HtmlInputText comp_poad_weight) {
		COMP_POAD_WEIGHT = comp_poad_weight;
	}

	public HtmlOutputLabel getCOMP_POAD_WEIGHT_UNIT_LABEL() {
		return COMP_POAD_WEIGHT_UNIT_LABEL;
	}

	public void setCOMP_POAD_WEIGHT_UNIT_LABEL(
			HtmlOutputLabel comp_poad_weight_unit_label) {
		COMP_POAD_WEIGHT_UNIT_LABEL = comp_poad_weight_unit_label;
	}

	public HtmlSelectOneMenu getCOMP_POAD_WEIGHT_UNIT() {
		return COMP_POAD_WEIGHT_UNIT;
	}

	public void setCOMP_POAD_WEIGHT_UNIT(HtmlSelectOneMenu comp_poad_weight_unit) {
		COMP_POAD_WEIGHT_UNIT = comp_poad_weight_unit;
	}

	public HtmlOutputLabel getCOMP_POAD_NATURE_OF_WORK_LABEL() {
		return COMP_POAD_NATURE_OF_WORK_LABEL;
	}

	public void setCOMP_POAD_NATURE_OF_WORK_LABEL(
			HtmlOutputLabel comp_poad_nature_of_work_label) {
		COMP_POAD_NATURE_OF_WORK_LABEL = comp_poad_nature_of_work_label;
	}

	public HtmlInputText getCOMP_POAD_NATURE_OF_WORK() {
		return COMP_POAD_NATURE_OF_WORK;
	}

	public void setCOMP_POAD_NATURE_OF_WORK(
			HtmlInputText comp_poad_nature_of_work) {
		COMP_POAD_NATURE_OF_WORK = comp_poad_nature_of_work;
	}

	public HtmlOutputLabel getCOMP_POAD_ADDL_RISK_CODE_LABEL() {
		return COMP_POAD_ADDL_RISK_CODE_LABEL;
	}

	public void setCOMP_POAD_ADDL_RISK_CODE_LABEL(
			HtmlOutputLabel comp_poad_addl_risk_code_label) {
		COMP_POAD_ADDL_RISK_CODE_LABEL = comp_poad_addl_risk_code_label;
	}

	public HtmlInputText getCOMP_POAD_ADDL_RISK_CODE() {
		return COMP_POAD_ADDL_RISK_CODE;
	}

	public void setCOMP_POAD_ADDL_RISK_CODE(
			HtmlInputText comp_poad_addl_risk_code) {
		COMP_POAD_ADDL_RISK_CODE = comp_poad_addl_risk_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_ADDL_RISK_DESC_LABEL() {
		return COMP_UI_M_ADDL_RISK_DESC_LABEL;
	}

	public void setCOMP_UI_M_ADDL_RISK_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_addl_risk_desc_label) {
		COMP_UI_M_ADDL_RISK_DESC_LABEL = comp_ui_m_addl_risk_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_ADDL_RISK_DESC() {
		return COMP_UI_M_ADDL_RISK_DESC;
	}

	public void setCOMP_UI_M_ADDL_RISK_DESC(
			HtmlInputText comp_ui_m_addl_risk_desc) {
		COMP_UI_M_ADDL_RISK_DESC = comp_ui_m_addl_risk_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL() {
		return COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL;
	}

	public void setCOMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL(
			HtmlOutputLabel comp_ui_m_poad_lc_thresold_lmt_label) {
		COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL = comp_ui_m_poad_lc_thresold_lmt_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_LC_THRESOLD_LMT() {
		return COMP_UI_M_POAD_LC_THRESOLD_LMT;
	}

	public void setCOMP_UI_M_POAD_LC_THRESOLD_LMT(
			HtmlInputText comp_ui_m_poad_lc_thresold_lmt) {
		COMP_UI_M_POAD_LC_THRESOLD_LMT = comp_ui_m_poad_lc_thresold_lmt;
	}

	public HtmlOutputLabel getCOMP_POAD_AGE_PROOF_FLAG_LABEL() {
		return COMP_POAD_AGE_PROOF_FLAG_LABEL;
	}

	public void setCOMP_POAD_AGE_PROOF_FLAG_LABEL(
			HtmlOutputLabel comp_poad_age_proof_flag_label) {
		COMP_POAD_AGE_PROOF_FLAG_LABEL = comp_poad_age_proof_flag_label;
	}

	public HtmlSelectOneMenu getCOMP_POAD_AGE_PROOF_FLAG() {
		return COMP_POAD_AGE_PROOF_FLAG;
	}

	public void setCOMP_POAD_AGE_PROOF_FLAG(
			HtmlSelectOneMenu comp_poad_age_proof_flag) {
		COMP_POAD_AGE_PROOF_FLAG = comp_poad_age_proof_flag;
	}

	public HtmlOutputLabel getCOMP_POAD_AGE_PROOF_OTHERS_LABEL() {
		return COMP_POAD_AGE_PROOF_OTHERS_LABEL;
	}

	public void setCOMP_POAD_AGE_PROOF_OTHERS_LABEL(
			HtmlOutputLabel comp_poad_age_proof_others_label) {
		COMP_POAD_AGE_PROOF_OTHERS_LABEL = comp_poad_age_proof_others_label;
	}

	public HtmlInputText getCOMP_POAD_AGE_PROOF_OTHERS() {
		return COMP_POAD_AGE_PROOF_OTHERS;
	}

	public void setCOMP_POAD_AGE_PROOF_OTHERS(
			HtmlInputText comp_poad_age_proof_others) {
		COMP_POAD_AGE_PROOF_OTHERS = comp_poad_age_proof_others;
	}

	public HtmlOutputLabel getCOMP_POAD_LC_THRESHOLD_LMT_LABEL() {
		return COMP_POAD_LC_THRESHOLD_LMT_LABEL;
	}

	public void setCOMP_POAD_LC_THRESHOLD_LMT_LABEL(
			HtmlOutputLabel comp_poad_lc_threshold_lmt_label) {
		COMP_POAD_LC_THRESHOLD_LMT_LABEL = comp_poad_lc_threshold_lmt_label;
	}

	public HtmlInputText getCOMP_POAD_LC_THRESHOLD_LMT() {
		return COMP_POAD_LC_THRESHOLD_LMT;
	}

	public void setCOMP_POAD_LC_THRESHOLD_LMT(
			HtmlInputText comp_poad_lc_threshold_lmt) {
		COMP_POAD_LC_THRESHOLD_LMT = comp_poad_lc_threshold_lmt;
	}

	public HtmlOutputLabel getCOMP_POAD_DISC_AGE_LABEL() {
		return COMP_POAD_DISC_AGE_LABEL;
	}

	public void setCOMP_POAD_DISC_AGE_LABEL(
			HtmlOutputLabel comp_poad_disc_age_label) {
		COMP_POAD_DISC_AGE_LABEL = comp_poad_disc_age_label;
	}

	public HtmlInputText getCOMP_POAD_DISC_AGE() {
		return COMP_POAD_DISC_AGE;
	}

	public void setCOMP_POAD_DISC_AGE(HtmlInputText comp_poad_disc_age) {
		COMP_POAD_DISC_AGE = comp_poad_disc_age;
	}

	public HtmlOutputLabel getCOMP_POAD_SMOKE_YN_LABEL() {
		return COMP_POAD_SMOKE_YN_LABEL;
	}

	public void setCOMP_POAD_SMOKE_YN_LABEL(
			HtmlOutputLabel comp_poad_smoke_yn_label) {
		COMP_POAD_SMOKE_YN_LABEL = comp_poad_smoke_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_POAD_SMOKE_YN() {
		return COMP_POAD_SMOKE_YN;
	}

	public void setCOMP_POAD_SMOKE_YN(HtmlSelectOneMenu comp_poad_smoke_yn) {
		COMP_POAD_SMOKE_YN = comp_poad_smoke_yn;
	}

	public HtmlOutputLabel getCOMP_POAD_NO_OF_CIGAR_LABEL() {
		return COMP_POAD_NO_OF_CIGAR_LABEL;
	}

	public void setCOMP_POAD_NO_OF_CIGAR_LABEL(
			HtmlOutputLabel comp_poad_no_of_cigar_label) {
		COMP_POAD_NO_OF_CIGAR_LABEL = comp_poad_no_of_cigar_label;
	}

	public HtmlInputText getCOMP_POAD_NO_OF_CIGAR() {
		return COMP_POAD_NO_OF_CIGAR;
	}

	public void setCOMP_POAD_NO_OF_CIGAR(HtmlInputText comp_poad_no_of_cigar) {
		COMP_POAD_NO_OF_CIGAR = comp_poad_no_of_cigar;
	}

	public HtmlOutputLabel getCOMP_POAD_REMARKS_LABEL() {
		return COMP_POAD_REMARKS_LABEL;
	}

	public void setCOMP_POAD_REMARKS_LABEL(
			HtmlOutputLabel comp_poad_remarks_label) {
		COMP_POAD_REMARKS_LABEL = comp_poad_remarks_label;
	}

	public HtmlInputText getCOMP_POAD_REMARKS() {
		return COMP_POAD_REMARKS;
	}

	public void setCOMP_POAD_REMARKS(HtmlInputText comp_poad_remarks) {
		COMP_POAD_REMARKS = comp_poad_remarks;
	}

	public HtmlOutputLabel getCOMP_POAD_NATIONALITY_LABEL() {
		return COMP_POAD_NATIONALITY_LABEL;
	}

	public void setCOMP_POAD_NATIONALITY_LABEL(
			HtmlOutputLabel comp_poad_nationality_label) {
		COMP_POAD_NATIONALITY_LABEL = comp_poad_nationality_label;
	}

	public HtmlInputText getCOMP_POAD_NATIONALITY() {
		return COMP_POAD_NATIONALITY;
	}

	public void setCOMP_POAD_NATIONALITY(HtmlInputText comp_poad_nationality) {
		COMP_POAD_NATIONALITY = comp_poad_nationality;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_NATLITY_DESC_LABEL() {
		return COMP_UI_M_POAD_NATLITY_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAD_NATLITY_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_poad_natlity_desc_label) {
		COMP_UI_M_POAD_NATLITY_DESC_LABEL = comp_ui_m_poad_natlity_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_NATLITY_DESC() {
		return COMP_UI_M_POAD_NATLITY_DESC;
	}

	public void setCOMP_UI_M_POAD_NATLITY_DESC(
			HtmlInputText comp_ui_m_poad_natlity_desc) {
		COMP_UI_M_POAD_NATLITY_DESC = comp_ui_m_poad_natlity_desc;
	}

	public HtmlOutputLabel getCOMP_POAD_MAR_STATUS_LABEL() {
		return COMP_POAD_MAR_STATUS_LABEL;
	}

	public void setCOMP_POAD_MAR_STATUS_LABEL(
			HtmlOutputLabel comp_poad_mar_status_label) {
		COMP_POAD_MAR_STATUS_LABEL = comp_poad_mar_status_label;
	}

	public HtmlInputText getCOMP_POAD_MAR_STATUS() {
		return COMP_POAD_MAR_STATUS;
	}

	public void setCOMP_POAD_MAR_STATUS(HtmlInputText comp_poad_mar_status) {
		COMP_POAD_MAR_STATUS = comp_poad_mar_status;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_MS_DESC_LABEL() {
		return COMP_UI_M_POAD_MS_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAD_MS_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_poad_ms_desc_label) {
		COMP_UI_M_POAD_MS_DESC_LABEL = comp_ui_m_poad_ms_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_MS_DESC() {
		return COMP_UI_M_POAD_MS_DESC;
	}

	public void setCOMP_UI_M_POAD_MS_DESC(HtmlInputText comp_ui_m_poad_ms_desc) {
		COMP_UI_M_POAD_MS_DESC = comp_ui_m_poad_ms_desc;
	}

	public HtmlOutputLabel getCOMP_POAD_FC_SUM_ASSURED_LABEL() {
		return COMP_POAD_FC_SUM_ASSURED_LABEL;
	}

	public void setCOMP_POAD_FC_SUM_ASSURED_LABEL(
			HtmlOutputLabel comp_poad_fc_sum_assured_label) {
		COMP_POAD_FC_SUM_ASSURED_LABEL = comp_poad_fc_sum_assured_label;
	}

	public HtmlInputText getCOMP_POAD_FC_SUM_ASSURED() {
		return COMP_POAD_FC_SUM_ASSURED;
	}

	public void setCOMP_POAD_FC_SUM_ASSURED(
			HtmlInputText comp_poad_fc_sum_assured) {
		COMP_POAD_FC_SUM_ASSURED = comp_poad_fc_sum_assured;
	}

	public HtmlOutputLabel getCOMP_POAD_LC_SUM_ASSURED_LABEL() {
		return COMP_POAD_LC_SUM_ASSURED_LABEL;
	}

	public void setCOMP_POAD_LC_SUM_ASSURED_LABEL(
			HtmlOutputLabel comp_poad_lc_sum_assured_label) {
		COMP_POAD_LC_SUM_ASSURED_LABEL = comp_poad_lc_sum_assured_label;
	}

	public HtmlInputText getCOMP_POAD_LC_SUM_ASSURED() {
		return COMP_POAD_LC_SUM_ASSURED;
	}

	public void setCOMP_POAD_LC_SUM_ASSURED(
			HtmlInputText comp_poad_lc_sum_assured) {
		COMP_POAD_LC_SUM_ASSURED = comp_poad_lc_sum_assured;
	}

	public HtmlOutputLabel getCOMP_POAD_OCC_CODE_LABEL() {
		return COMP_POAD_OCC_CODE_LABEL;
	}

	public void setCOMP_POAD_OCC_CODE_LABEL(
			HtmlOutputLabel comp_poad_occ_code_label) {
		COMP_POAD_OCC_CODE_LABEL = comp_poad_occ_code_label;
	}

	public HtmlInputText getCOMP_POAD_OCC_CODE() {
		return COMP_POAD_OCC_CODE;
	}

	public void setCOMP_POAD_OCC_CODE(HtmlInputText comp_poad_occ_code) {
		COMP_POAD_OCC_CODE = comp_poad_occ_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_OCC_DESC_LABEL() {
		return COMP_UI_M_POAD_OCC_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAD_OCC_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_poad_occ_desc_label) {
		COMP_UI_M_POAD_OCC_DESC_LABEL = comp_ui_m_poad_occ_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_OCC_DESC() {
		return COMP_UI_M_POAD_OCC_DESC;
	}

	public void setCOMP_UI_M_POAD_OCC_DESC(HtmlInputText comp_ui_m_poad_occ_desc) {
		COMP_UI_M_POAD_OCC_DESC = comp_ui_m_poad_occ_desc;
	}

	public HtmlOutputLabel getCOMP_POAD_FC_AMAN_PREM_LABEL() {
		return COMP_POAD_FC_AMAN_PREM_LABEL;
	}

	public void setCOMP_POAD_FC_AMAN_PREM_LABEL(
			HtmlOutputLabel comp_poad_fc_aman_prem_label) {
		COMP_POAD_FC_AMAN_PREM_LABEL = comp_poad_fc_aman_prem_label;
	}

	public HtmlInputText getCOMP_POAD_FC_AMAN_PREM() {
		return COMP_POAD_FC_AMAN_PREM;
	}

	public void setCOMP_POAD_FC_AMAN_PREM(HtmlInputText comp_poad_fc_aman_prem) {
		COMP_POAD_FC_AMAN_PREM = comp_poad_fc_aman_prem;
	}

	public HtmlOutputLabel getCOMP_POAD_LC_AMAN_PREM_LABEL() {
		return COMP_POAD_LC_AMAN_PREM_LABEL;
	}

	public void setCOMP_POAD_LC_AMAN_PREM_LABEL(
			HtmlOutputLabel comp_poad_lc_aman_prem_label) {
		COMP_POAD_LC_AMAN_PREM_LABEL = comp_poad_lc_aman_prem_label;
	}

	public HtmlInputText getCOMP_POAD_LC_AMAN_PREM() {
		return COMP_POAD_LC_AMAN_PREM;
	}

	public void setCOMP_POAD_LC_AMAN_PREM(HtmlInputText comp_poad_lc_aman_prem) {
		COMP_POAD_LC_AMAN_PREM = comp_poad_lc_aman_prem;
	}

	public HtmlOutputLabel getCOMP_POAD_OCC_CLASS_LABEL() {
		return COMP_POAD_OCC_CLASS_LABEL;
	}

	public void setCOMP_POAD_OCC_CLASS_LABEL(
			HtmlOutputLabel comp_poad_occ_class_label) {
		COMP_POAD_OCC_CLASS_LABEL = comp_poad_occ_class_label;
	}

	public HtmlInputText getCOMP_POAD_OCC_CLASS() {
		return COMP_POAD_OCC_CLASS;
	}

	public void setCOMP_POAD_OCC_CLASS(HtmlInputText comp_poad_occ_class) {
		COMP_POAD_OCC_CLASS = comp_poad_occ_class;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_OCC_CLASS_DESC_LABEL() {
		return COMP_UI_M_POAD_OCC_CLASS_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAD_OCC_CLASS_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_poad_occ_class_desc_label) {
		COMP_UI_M_POAD_OCC_CLASS_DESC_LABEL = comp_ui_m_poad_occ_class_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_OCC_CLASS_DESC() {
		return COMP_UI_M_POAD_OCC_CLASS_DESC;
	}

	public void setCOMP_UI_M_POAD_OCC_CLASS_DESC(
			HtmlInputText comp_ui_m_poad_occ_class_desc) {
		COMP_UI_M_POAD_OCC_CLASS_DESC = comp_ui_m_poad_occ_class_desc;
	}

	public HtmlOutputLabel getCOMP_POAD_FC_AMAN_LOAD_PREM_LABEL() {
		return COMP_POAD_FC_AMAN_LOAD_PREM_LABEL;
	}

	public void setCOMP_POAD_FC_AMAN_LOAD_PREM_LABEL(
			HtmlOutputLabel comp_poad_fc_aman_load_prem_label) {
		COMP_POAD_FC_AMAN_LOAD_PREM_LABEL = comp_poad_fc_aman_load_prem_label;
	}

	public HtmlInputText getCOMP_POAD_FC_AMAN_LOAD_PREM() {
		return COMP_POAD_FC_AMAN_LOAD_PREM;
	}

	public void setCOMP_POAD_FC_AMAN_LOAD_PREM(
			HtmlInputText comp_poad_fc_aman_load_prem) {
		COMP_POAD_FC_AMAN_LOAD_PREM = comp_poad_fc_aman_load_prem;
	}

	public HtmlOutputLabel getCOMP_POAD_LC_AMAN_LOAD_PREM_LABEL() {
		return COMP_POAD_LC_AMAN_LOAD_PREM_LABEL;
	}

	public void setCOMP_POAD_LC_AMAN_LOAD_PREM_LABEL(
			HtmlOutputLabel comp_poad_lc_aman_load_prem_label) {
		COMP_POAD_LC_AMAN_LOAD_PREM_LABEL = comp_poad_lc_aman_load_prem_label;
	}

	public HtmlInputText getCOMP_POAD_LC_AMAN_LOAD_PREM() {
		return COMP_POAD_LC_AMAN_LOAD_PREM;
	}

	public void setCOMP_POAD_LC_AMAN_LOAD_PREM(
			HtmlInputText comp_poad_lc_aman_load_prem) {
		COMP_POAD_LC_AMAN_LOAD_PREM = comp_poad_lc_aman_load_prem;
	}

	public HtmlOutputLabel getCOMP_POAD_RELIGION_CODE_LABEL() {
		return COMP_POAD_RELIGION_CODE_LABEL;
	}

	public void setCOMP_POAD_RELIGION_CODE_LABEL(
			HtmlOutputLabel comp_poad_religion_code_label) {
		COMP_POAD_RELIGION_CODE_LABEL = comp_poad_religion_code_label;
	}

	public HtmlInputText getCOMP_POAD_RELIGION_CODE() {
		return COMP_POAD_RELIGION_CODE;
	}

	public void setCOMP_POAD_RELIGION_CODE(HtmlInputText comp_poad_religion_code) {
		COMP_POAD_RELIGION_CODE = comp_poad_religion_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_REL_CODE_DESC_LABEL() {
		return COMP_UI_M_POAD_REL_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAD_REL_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_poad_rel_code_desc_label) {
		COMP_UI_M_POAD_REL_CODE_DESC_LABEL = comp_ui_m_poad_rel_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_REL_CODE_DESC() {
		return COMP_UI_M_POAD_REL_CODE_DESC;
	}

	public void setCOMP_UI_M_POAD_REL_CODE_DESC(
			HtmlInputText comp_ui_m_poad_rel_code_desc) {
		COMP_UI_M_POAD_REL_CODE_DESC = comp_ui_m_poad_rel_code_desc;
	}

	public HtmlOutputLabel getCOMP_POAD_FC_SENABEL_PREM_LABEL() {
		return COMP_POAD_FC_SENABEL_PREM_LABEL;
	}

	public void setCOMP_POAD_FC_SENABEL_PREM_LABEL(
			HtmlOutputLabel comp_poad_fc_senabel_prem_label) {
		COMP_POAD_FC_SENABEL_PREM_LABEL = comp_poad_fc_senabel_prem_label;
	}

	public HtmlInputText getCOMP_POAD_FC_SENABEL_PREM() {
		return COMP_POAD_FC_SENABEL_PREM;
	}

	public void setCOMP_POAD_FC_SENABEL_PREM(
			HtmlInputText comp_poad_fc_senabel_prem) {
		COMP_POAD_FC_SENABEL_PREM = comp_poad_fc_senabel_prem;
	}

	public HtmlOutputLabel getCOMP_POAD_LC_SENABEL_PREM_LABEL() {
		return COMP_POAD_LC_SENABEL_PREM_LABEL;
	}

	public void setCOMP_POAD_LC_SENABEL_PREM_LABEL(
			HtmlOutputLabel comp_poad_lc_senabel_prem_label) {
		COMP_POAD_LC_SENABEL_PREM_LABEL = comp_poad_lc_senabel_prem_label;
	}

	public HtmlInputText getCOMP_POAD_LC_SENABEL_PREM() {
		return COMP_POAD_LC_SENABEL_PREM;
	}

	public void setCOMP_POAD_LC_SENABEL_PREM(
			HtmlInputText comp_poad_lc_senabel_prem) {
		COMP_POAD_LC_SENABEL_PREM = comp_poad_lc_senabel_prem;
	}

	public HtmlOutputLabel getCOMP_POAD_HEALTH_CODE_LABEL() {
		return COMP_POAD_HEALTH_CODE_LABEL;
	}

	public void setCOMP_POAD_HEALTH_CODE_LABEL(
			HtmlOutputLabel comp_poad_health_code_label) {
		COMP_POAD_HEALTH_CODE_LABEL = comp_poad_health_code_label;
	}

	public HtmlInputText getCOMP_POAD_HEALTH_CODE() {
		return COMP_POAD_HEALTH_CODE;
	}

	public void setCOMP_POAD_HEALTH_CODE(HtmlInputText comp_poad_health_code) {
		COMP_POAD_HEALTH_CODE = comp_poad_health_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_HEALTH_DESC_LABEL() {
		return COMP_UI_M_POAD_HEALTH_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAD_HEALTH_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_poad_health_desc_label) {
		COMP_UI_M_POAD_HEALTH_DESC_LABEL = comp_ui_m_poad_health_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_HEALTH_DESC() {
		return COMP_UI_M_POAD_HEALTH_DESC;
	}

	public void setCOMP_UI_M_POAD_HEALTH_DESC(
			HtmlInputText comp_ui_m_poad_health_desc) {
		COMP_UI_M_POAD_HEALTH_DESC = comp_ui_m_poad_health_desc;
	}

	public PT_IL_POL_ASSURED_DTLS getPT_IL_POL_ASSURED_DTLS_BEAN() {
		return PT_IL_POL_ASSURED_DTLS_BEAN;
	}

	public void setPT_IL_POL_ASSURED_DTLS_BEAN(
			PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean) {
		PT_IL_POL_ASSURED_DTLS_BEAN = pt_il_pol_assured_dtls_bean;
	}

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_ASSURED_DTLS_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_ASSURED_DTLS_HELPER helper) {
		this.helper = helper;
	}

	public String medicalHistory() {
		String outString = null;

		outString = "PILT002_APAC_PT_IL_POL_ASSR_MED_HIST";

		return outString;
	}

	public String assuredPolicydetails() {

		String outString = null;

		outString = "PILT002_APAC_PT_IL_POL_ASSURED_POLICY_DTLS";
		return outString;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FLEX_FIELDS() {
		return COMP_UI_M_BUT_FLEX_FIELDS;
	}

	public void setCOMP_UI_M_BUT_FLEX_FIELDS(
			HtmlCommandButton comp_ui_m_but_flex_fields) {
		COMP_UI_M_BUT_FLEX_FIELDS = comp_ui_m_but_flex_fields;
	}

	public void setListPOAD_TYPE(List<SelectItem> listPOAD_TYPE) {
		this.listPOAD_TYPE = listPOAD_TYPE;
	}

	public ArrayList<PT_IL_POL_ASSURED_DTLS> getList() {
		return list;
	}

	public void setList(ArrayList<PT_IL_POL_ASSURED_DTLS> list) {
		this.list = list;
	}

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}

	public void POAD_ASSR_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {

		try {
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_ASSR_CODE((String) value);
			helper.POAD_ASSR_CODE_WHEN_VALIDATE_ITEM(compositeAction,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
			COMP_POAD_ASSURED_NAME.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_REF_ID1_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_REF_ID1 = (String) value;
		try {
			/*
			 * String currValue = POAD_REF_ID1; String beanValue =
			 * PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_REF_ID1();
			 * if(!(currValue.equalsIgnoreCase(beanValue))){
			 */
			helper.POAD_REF_ID1_WHEN_VALIDATE_ITEM(POAD_REF_ID1,
					compositeAction, getPT_IL_POL_ASSURED_DTLS_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_REF_ID1(POAD_REF_ID1);
			COMP_POAD_DOB.resetValue();
			COMP_POAD_AGE.resetValue();
			COMP_POAD_DISC_AGE.resetValue();
			COMP_POAD_CATG_CODE.resetValue();
			COMP_UI_M_POAD_CATG_DESC.resetValue();
			COMP_POAD_OCC_CODE.resetValue();
			COMP_POAD_NATIONALITY.resetValue();
			// COMP_POAD_NO_OF_CIGAR.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_MAR_STATUS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_MAR_STATUS = (String) value;
		try {

			helper.POAD_MAR_STATUS_WHEN_VALIDATE_ITEM(POAD_MAR_STATUS,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN()
					.setPOAD_MAR_STATUS(POAD_MAR_STATUS);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_REF_ID2_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {

		try {
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_REF_ID2((String) value);

			helper.POAD_REF_ID2_WHEN_VALIDATE_ITEM(compositeAction,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_TYPE_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value) {

		try {
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_TYPE((String) value);

			helper.POAD_TYPE_WHEN_LIST_CHANGED(compositeAction,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_TYPE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {

		try {
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_TYPE(
					helper.POAD_TYPE_WHEN_VALIDATE_ITEM((String) value));

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_CATG_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {

		try {
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_CATG_CODE((String) value);
			helper.POAD_CATG_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_ASSURED_DTLS_BEAN);
			getCOMP_UI_M_POAD_CATG_DESC().resetValue();
			/*Added by Ram on 21/01/2017 for Praganancy field capturing*/
			enablePraganacyField();
			
			if(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE() != null && !PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_CATG_CODE().equalsIgnoreCase("2"))
			{
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_PREGNENT_YN("N");
			}
			COMP_POAD_PREGNENT_YN.resetValue();
			/*End*/

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*Added by Ameen for KIC Endorsement pol_frz_flag issue as per Ajay sugg. on 05-07-2018*/
	boolean endChangeFlag = false;
	/*End*/
	public void POAD_DOB_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {

		Date POAD_DOB = (Date) value;
		try {
			/*Added by Ameen for KIC Endorsement pol_frz_flag issue as per Ajay sugg. on 05-07-2018*/
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX() > 0 && 
					!"001".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_TYPE())){
				if(!POAD_DOB.equals(PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_DOB())){
					endChangeFlag = true;
				}
			}
			/*End*/
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_DOB(POAD_DOB);
			helper.POAD_DOB_WHEN_VALIDATE_ITEM(compositeAction, POAD_DOB, this,
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_POAD_AGE.resetValue();
			COMP_POAD_DISC_AGE.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_HEIGHT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		Double POAD_HEIGHT = (Double) value;
		try {
			helper.POAD_HEIGHT_WHEN_VALIDATE_ITEM(POAD_HEIGHT,
					getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			
			/*Commented and modified by Janani for Fidelity on 18.04.2018*/
			
			/*if(POAD_HEIGHT > 0.0 && COMP_POAD_HEIGHT.isRequired()){
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_HEIGHT(POAD_HEIGHT);
			}else{
				throw new Exception("Height should greater than 0");
			}*/
			/*Newly added by pidugu raj dt: 07-12-2020 as suggested by Abhilash for Alliance Cusotmer*/
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().equalsIgnoreCase("KMAN001")){
				
			}else{//End

			if(POAD_HEIGHT != 0.0 && COMP_POAD_HEIGHT.isRequired() || (POAD_HEIGHT == 0.0 && !COMP_POAD_HEIGHT.isRequired()) ||
					POAD_HEIGHT != 0.0 && !COMP_POAD_HEIGHT.isRequired()){
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_HEIGHT(POAD_HEIGHT);
			}else{
				throw new Exception("Height should greater than 0");
			}
			}
			
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_HEIGHT_UNIT_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value) {
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		String POAD_HEIGHT_UNIT = (String) value;
		try {
			helper.POAD_HEIGHT_UNIT_WHEN_LIST_CHANGED(POAD_HEIGHT_UNIT,
					getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
							.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_HEIGHT_UNIT(
					POAD_HEIGHT_UNIT);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_AGE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();

		Integer POAD_AGE = (Integer) value;
		try {
			helper.POAD_AGE_WHEN_VALIDATE_ITEM(compositeAction, POAD_AGE,
					getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
							.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
					compositeAction
							.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN()
							.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN());

			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_AGE(POAD_AGE);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_WEIGHT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		Double POAD_WEIGHT = (Double) value;
		try {
			helper.POAD_WEIGHT_WHEN_VALIDATE_ITEM(POAD_WEIGHT,
					getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			/*Commented and modified by Janani for Fidelity on 18.04.2018*/
			
			/*if(POAD_WEIGHT != 0.0 && COMP_POAD_WEIGHT.isRequired()){
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_WEIGHT(POAD_WEIGHT);
			}else{
				throw new Exception("Weight should greater than 0");
			}*/
			
			
			if(POAD_WEIGHT != 0.0 && COMP_POAD_WEIGHT.isRequired()  || (POAD_WEIGHT == 0.0 && !COMP_POAD_WEIGHT.isRequired()) ||
					POAD_WEIGHT != 0.0 && !COMP_POAD_WEIGHT.isRequired()){
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_WEIGHT(POAD_WEIGHT);
			}else{
				throw new Exception("Weight should greater than 0");
			}
			
			/*End*/
			COMP_POAD_BMI.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_WEIGHT_UNIT_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value) {
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		String POAD_WEIGHT_UNIT = (String) value;
		try {
			
			/*Added by Shankar on 07/04/2017*/
			if(("U".equalsIgnoreCase(compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPLAN_TYPE()))){
					if(("Y".equalsIgnoreCase(compositeAction
							.getPT_IL_POLICY_ACTION_BEAN().getPROD_RISK_FLG()))|| (new PILT002_APAC_LOCAL_PROCEDURES().L_RIDER_CHECK(compositeAction
									.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
									.getPOL_SYS_ID()))){
						/*End*/
			helper.POAD_WEIGHT_UNIT_WHEN_LIST_CHANGED(POAD_WEIGHT_UNIT,
					getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
							.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_WEIGHT_UNIT(
					POAD_WEIGHT_UNIT);
			/*Added by Shankar on 07/04/2017*/
					}
			}else{
				helper.POAD_WEIGHT_UNIT_WHEN_LIST_CHANGED(POAD_WEIGHT_UNIT,
						getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
								.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN(), compositeAction
								.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_WEIGHT_UNIT(
						POAD_WEIGHT_UNIT);
			}
			/*End*/
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_FLAG((String) value);
			helper.POAD_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(this);
			COMP_POAD_AGE_PROOF_OTHERS.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_SMOKE_YN_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value) {
		String POAD_SMOKE_YN = (String) value;
		try {
			helper.POAD_SMOKE_YN_WHEN_LIST_CHANGED(POAD_SMOKE_YN,
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_SMOKE_YN(POAD_SMOKE_YN);
			// COMP_POAD_NO_OF_CIGAR.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_SMOKE_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_SMOKE_YN = (String) value;
		try {
			// calling same method because it have same logic for when validate
			// item
			helper.POAD_SMOKE_YN_WHEN_LIST_CHANGED(POAD_SMOKE_YN,
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_SMOKE_YN(POAD_SMOKE_YN);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_OCC_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_OCC_CODE = (String) value;
		try {

			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_OCC_CODE(POAD_OCC_CODE);
			helper.POAD_OCC_CODE_WHEN_VALIDATE_ITEM(POAD_OCC_CODE,
					PT_IL_POL_ASSURED_DTLS_BEAN);
			COMP_UI_M_POAD_OCC_DESC.resetValue();
			COMP_POAD_OCC_CLASS.resetValue();
			COMP_UI_M_POAD_OCC_CLASS_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_OCC_CLASS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_OCC_CLASS = (String) value;
		try {

			helper.POAD_OCC_CLASS_WHEN_VALIDATE_ITEM(POAD_OCC_CLASS,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_OCC_CLASS(POAD_OCC_CLASS);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_NATIONALITY_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_NATIONALITY = (String) value;
		try {

			helper.POAD_NATIONALITY_WHEN_VALIDATE_ITEM(POAD_NATIONALITY,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_NATIONALITY(
					POAD_NATIONALITY);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_OCC_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		Double POAD_OCC_RATE = (Double) value;
		try {

			helper.POAD_OCC_RATE_VALIDATE_ITEM(POAD_OCC_RATE,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_OCC_RATE(POAD_OCC_RATE);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_RELIGION_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_RELIGION_CODE = (String) value;
		try {

			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_RELIGION_CODE(
					POAD_RELIGION_CODE);
			helper.POAD_RELIGION_CODE_VALIDATE_ITEM(POAD_RELIGION_CODE,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
			COMP_UI_M_POAD_REL_CODE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_HEALTH_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_HEALTH_CODE = (String) value;
		try {

			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_HEALTH_CODE(
					POAD_HEALTH_CODE);
			helper.POAD_HEALTH_CODE_VALIDATE_ITEM(POAD_HEALTH_CODE,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
			COMP_UI_M_POAD_HEALTH_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_FC_SALARY_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		Double POAD_FC_SALARY = (Double) value;
		try {

			POAD_FC_SALARY = helper.POAD_FC_SALARY_VALIDATE_ITEM(
					POAD_FC_SALARY, getPT_IL_POL_ASSURED_DTLS_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FC_SALARY(POAD_FC_SALARY);

			System.out
					.println("Before getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_LC_SALARY()    : "
							+ getPT_IL_POL_ASSURED_DTLS_BEAN()
									.getPOAD_LC_SALARY());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_LC_SALARY(POAD_FC_SALARY);
			System.out
					.println("After getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_LC_SALARY()    : "
							+ getPT_IL_POL_ASSURED_DTLS_BEAN()
									.getPOAD_LC_SALARY());

			COMP_POAD_LC_SALARY.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_LC_SALARY_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		Double POAD_LC_SALARY = (Double) value;
		try {

			POAD_LC_SALARY = helper.POAD_LC_SALARY_VALIDATE_ITEM(
					POAD_LC_SALARY, getPT_IL_POL_ASSURED_DTLS_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_LC_SALARY(POAD_LC_SALARY);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_FC_AMAN_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		Double POAD_FC_AMAN_PREM = (Double) value;
		try {

			POAD_FC_AMAN_PREM = helper.POAD_FC_AMAN_PREM_VALIDATE_ITEM(
					POAD_FC_AMAN_PREM, getPT_IL_POL_ASSURED_DTLS_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FC_AMAN_PREM(
					POAD_FC_AMAN_PREM);
			COMP_POAD_LC_AMAN_PREM.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_LC_AMAN_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		Double POAD_LC_AMAN_PREM = (Double) value;
		try {

			POAD_LC_AMAN_PREM = helper.POAD_LC_AMAN_PREM_VALIDATE_ITEM(
					POAD_LC_AMAN_PREM, getPT_IL_POL_ASSURED_DTLS_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_LC_AMAN_PREM(
					POAD_LC_AMAN_PREM);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_FC_AMAN_LOAD_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		Double POAD_FC_AMAN_LOAD_PREM = (Double) value;
		try {

			POAD_FC_AMAN_LOAD_PREM = helper
					.POAD_FC_AMAN_LOAD_PREM_VALIDATE_ITEM(
							POAD_FC_AMAN_LOAD_PREM,
							getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
									.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN(), compositeAction
									.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FC_AMAN_LOAD_PREM(
					POAD_FC_AMAN_LOAD_PREM);
			COMP_POAD_LC_AMAN_LOAD_PREM.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_POL_OWNER_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {

		try {
			String val = (String) value;

			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_POL_OWNER_YN(val);
			helper.POAD_POL_OWNER_YN_WHEN_VALIDATE_ITEM(compositeAction);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_LC_AMAN_LOAD_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		Double POAD_LC_AMAN_LOAD_PREM = (Double) value;
		try {

			POAD_LC_AMAN_LOAD_PREM = helper
					.POAD_LC_AMAN_LOAD_PREM_VALIDATE_ITEM(
							POAD_LC_AMAN_LOAD_PREM,
							getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
									.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN(), compositeAction
									.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_LC_AMAN_LOAD_PREM(
					POAD_LC_AMAN_LOAD_PREM);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_FC_SENABEL_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		Double POAD_FC_SENABEL_PREM = (Double) value;
		try {

			POAD_FC_SENABEL_PREM = helper.POAD_FC_SENABEL_PREM_VALIDATE_ITEM(
					POAD_FC_SENABEL_PREM, getPT_IL_POL_ASSURED_DTLS_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FC_SENABEL_PREM(
					POAD_FC_SENABEL_PREM);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_LC_SENABEL_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		Double POAD_LC_SENABEL_PREM = (Double) value;
		try {

			POAD_LC_SENABEL_PREM = helper.POAD_LC_SENABEL_PREM_VALIDATE_ITEM(
					POAD_LC_SENABEL_PREM, getPT_IL_POL_ASSURED_DTLS_BEAN(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_LC_SENABEL_PREM(
					POAD_LC_SENABEL_PREM);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_RACE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_RACE = (String) value;
		try {
			helper.POAD_RACE_VALIDATE_ITEM(POAD_RACE,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_RACE(POAD_RACE);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_REMARKS_KEY_NEXT_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_REMARKS = (String) value;
		try {
			helper.POAD_REMARKS_KEY_NEXT_ITEM(POAD_REMARKS, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN());
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_REMARKS(POAD_REMARKS);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatePOAD_ADDL_RISK_CODE(FacesContext context,
			UIComponent component, Object value) {
		String RISK_CODE = (String) value;
		try {
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_ADDL_RISK_CODE(RISK_CODE);
			COMP_POAD_ADDL_RISK_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<LovBean> prepareSuggestionList_ASSR_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		/*
		 * 
		 * commented by Ameen for lov lower case issue ssp call id
		 * FALCONLIFE-1344105
		 * 
		 * String query =
		 * "SELECT CONT_CODE,CONT_NAME,CONT_CUST_CODE FROM PM_IL_CONTRACTOR  WHERE CONT_FRZ_FLAG = 'N' "
		 * + "AND (CONT_CODE LIKE ? OR CONT_NAME LIKE ?) AND ROWNUM < ?";
		 */

		/*
		 * Added by Ameen for lov lower case issue ssp call id
		 * FALCONLIFE-1344105
		 */

		String query = "SELECT CONT_CODE,CONT_NAME,CONT_CUST_CODE FROM PM_IL_CONTRACTOR  WHERE CONT_FRZ_FLAG = 'N' "
				+ "AND (UPPER(CONT_CODE) LIKE UPPER(?) OR UPPER(CONT_NAME) LIKE UPPER(?)) AND ROWNUM < ?";
		/* end */
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_CATG_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_CATG_CODE";
		Object param1 = "CATG";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_POAD_NATIONALITY(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_NATIONALITY";
		Object param1 = "NATLITY";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_POAD_MAR_STATUS(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_MAR_STATUS";
		Object param1 = "MARI_STAT";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_POAD_OCC_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_OCC_CODE";
		Object param1 = "IL_OCCU";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_POAD_OCC_CLASS(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_OCC_CLASS";
		Object param1 = "IL_OCC_CLASS";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_POAD_OCC_RATE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_OCC_RATE";
		Object param1 = "IL_OCC_CLASS";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_POAD_RELIGION_CODE(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_RELIGION_CODE";
		Object param1 = "RELIGION";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_POAD_HEALTH_CODE(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_HEALTH_CODE";
		Object param1 = "IL_HLTH_ST";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_POAD_RACE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_RACE";
		Object param1 = "RACE";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, (String) object);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_ADDL_RISK_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_ADDL_RISK_CODE";
		Object param1 = "IL_ADDL_RISK";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public void setlistValues() {

		try {
			setListPOAD_AGE_PROOF_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_AGE_PROOF_FLAG",
					"IL_AGE_PROOF"));
			setListPOAD_HEIGHT_UNIT(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_HEIGHT_UNIT", "IL_HEIGHT_UT"));
			setListPOAD_SMOKE_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_SMOKE_YN", "YESNO"));
			setListPOAD_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_TYPE", "IL_ASSR_TYP"));
			setListPOAD_WEIGHT_UNIT(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_WEIGHT_UNIT", "IL_WEIGHT_UT"));
			setListPOAD_POL_OWNER_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_POL_OWNER_YN", "YESNO"));
			setListPOAD_ALCHOHALIC_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_ALCHOHALIC_YN", "YESNO"));
			setListPOAD_AGE_ADMITTED(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_AGE_ADMITTED", "YESNO_AD"));
			/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
			setListPOAD_HIV_TEST_YN(ListItemUtil.getDropDownListValue(
					    CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POL_ASSURED_DTLS",
					    "PT_IL_POL_ASSURED_DTLS.POAD_HIV_TEST_YN", "YESNO"));
				
			/*End*/
			
			/*Added by Janani on 07.03.2018 for FSD_FLA_IL_008*/
			
			setListPOAD_FAMILY_YN_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_ALCHOHALIC_YN",
					"YESNO"));
			
			setListPOAD_OCC_YN_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_ALCHOHALIC_YN",
					"YESNO"));
			
			/*End*/

		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Instantiates all components in PT_IL_POL_ASSURED_DTLS_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_POAD_ASSR_CODE = new HtmlInputText();
		COMP_POAD_ASSURED_NAME = new HtmlInputText();
		COMP_POAD_FC_SALARY = new HtmlInputText();
		COMP_POAD_REF_ID1 = new HtmlInputText();
		COMP_POAD_REF_ID2 = new HtmlInputText();
		COMP_POAD_LC_SALARY = new HtmlInputText();
		COMP_POAD_BMI = new HtmlInputText();
		COMP_POAD_CATG_CODE = new HtmlInputText();
		COMP_UI_M_POAD_CATG_DESC = new HtmlInputText();
		COMP_POAD_BIRTH_PLACE = new HtmlInputText();
		COMP_POAD_HEIGHT = new HtmlInputText();
		COMP_POAD_RACE = new HtmlInputText();
		COMP_UI_M_POAD_RACE_CODE_DESC = new HtmlInputText();
		COMP_POAD_AGE = new HtmlInputText();
		COMP_POAD_WEIGHT = new HtmlInputText();
		COMP_POAD_NATURE_OF_WORK = new HtmlInputText();
		COMP_POAD_ADDL_RISK_CODE = new HtmlInputText();
		COMP_UI_M_ADDL_RISK_DESC = new HtmlInputText();
		COMP_UI_M_POAD_LC_THRESOLD_LMT = new HtmlInputText();
		COMP_POAD_AGE_PROOF_OTHERS = new HtmlInputText();
		COMP_POAD_LC_THRESHOLD_LMT = new HtmlInputText();
		COMP_POAD_DISC_AGE = new HtmlInputText();
		COMP_POAD_NO_OF_CIGAR = new HtmlInputText();
		COMP_POAD_REMARKS = new HtmlInputText();
		COMP_POAD_NATIONALITY = new HtmlInputText();
		COMP_UI_M_POAD_NATLITY_DESC = new HtmlInputText();
		COMP_POAD_MAR_STATUS = new HtmlInputText();
		COMP_UI_M_POAD_MS_DESC = new HtmlInputText();
		COMP_POAD_FC_SUM_ASSURED = new HtmlInputText();
		COMP_POAD_LC_SUM_ASSURED = new HtmlInputText();
		COMP_POAD_OCC_CODE = new HtmlInputText();
		COMP_UI_M_POAD_OCC_DESC = new HtmlInputText();
		COMP_POAD_FC_AMAN_PREM = new HtmlInputText();
		COMP_POAD_LC_AMAN_PREM = new HtmlInputText();
		COMP_POAD_OCC_CLASS = new HtmlInputText();
		COMP_UI_M_POAD_OCC_CLASS_DESC = new HtmlInputText();
		COMP_POAD_FC_AMAN_LOAD_PREM = new HtmlInputText();
		COMP_POAD_LC_AMAN_LOAD_PREM = new HtmlInputText();
		COMP_POAD_RELIGION_CODE = new HtmlInputText();
		COMP_UI_M_POAD_REL_CODE_DESC = new HtmlInputText();
		COMP_POAD_FC_SENABEL_PREM = new HtmlInputText();
		COMP_POAD_LC_SENABEL_PREM = new HtmlInputText();
		COMP_POAD_HEALTH_CODE = new HtmlInputText();
		COMP_UI_M_POAD_HEALTH_DESC = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_POAD_ASSR_CODE_LABEL = new HtmlOutputLabel();
		COMP_POAD_ASSURED_NAME_LABEL = new HtmlOutputLabel();
		COMP_POAD_FC_SALARY_LABEL = new HtmlOutputLabel();
		COMP_POAD_REF_ID1_LABEL = new HtmlOutputLabel();
		COMP_POAD_REF_ID2_LABEL = new HtmlOutputLabel();
		COMP_POAD_LC_SALARY_LABEL = new HtmlOutputLabel();
		COMP_POAD_BMI_LABEL = new HtmlOutputLabel();
		COMP_POAD_TYPE_LABEL = new HtmlOutputLabel();
		COMP_POAD_CATG_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POAD_CATG_DESC_LABEL = new HtmlOutputLabel();
		COMP_POAD_BIRTH_PLACE_LABEL = new HtmlOutputLabel();
		COMP_POAD_DOB_LABEL = new HtmlOutputLabel();
		COMP_POAD_HEIGHT_LABEL = new HtmlOutputLabel();
		COMP_POAD_HEIGHT_UNIT_LABEL = new HtmlOutputLabel();
		COMP_POAD_RACE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POAD_RACE_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_POAD_AGE_LABEL = new HtmlOutputLabel();
		COMP_POAD_WEIGHT_LABEL = new HtmlOutputLabel();
		COMP_POAD_WEIGHT_UNIT_LABEL = new HtmlOutputLabel();
		COMP_POAD_NATURE_OF_WORK_LABEL = new HtmlOutputLabel();
		COMP_POAD_ADDL_RISK_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_ADDL_RISK_DESC_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL = new HtmlOutputLabel();
		COMP_POAD_AGE_PROOF_FLAG_LABEL = new HtmlOutputLabel();
		COMP_POAD_AGE_PROOF_OTHERS_LABEL = new HtmlOutputLabel();
		COMP_POAD_LC_THRESHOLD_LMT_LABEL = new HtmlOutputLabel();
		COMP_POAD_DISC_AGE_LABEL = new HtmlOutputLabel();
		COMP_POAD_SMOKE_YN_LABEL = new HtmlOutputLabel();
		COMP_POAD_NO_OF_CIGAR_LABEL = new HtmlOutputLabel();
		COMP_POAD_REMARKS_LABEL = new HtmlOutputLabel();
		COMP_POAD_NATIONALITY_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POAD_NATLITY_DESC_LABEL = new HtmlOutputLabel();
		COMP_POAD_MAR_STATUS_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POAD_MS_DESC_LABEL = new HtmlOutputLabel();
		COMP_POAD_FC_SUM_ASSURED_LABEL = new HtmlOutputLabel();
		COMP_POAD_LC_SUM_ASSURED_LABEL = new HtmlOutputLabel();
		COMP_POAD_OCC_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POAD_OCC_DESC_LABEL = new HtmlOutputLabel();
		COMP_POAD_FC_AMAN_PREM_LABEL = new HtmlOutputLabel();
		COMP_POAD_LC_AMAN_PREM_LABEL = new HtmlOutputLabel();
		COMP_POAD_OCC_CLASS_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POAD_OCC_CLASS_DESC_LABEL = new HtmlOutputLabel();
		COMP_POAD_FC_AMAN_LOAD_PREM_LABEL = new HtmlOutputLabel();
		COMP_POAD_LC_AMAN_LOAD_PREM_LABEL = new HtmlOutputLabel();
		COMP_POAD_RELIGION_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POAD_REL_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_POAD_FC_SENABEL_PREM_LABEL = new HtmlOutputLabel();
		COMP_POAD_LC_SENABEL_PREM_LABEL = new HtmlOutputLabel();
		COMP_POAD_HEALTH_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POAD_HEALTH_DESC_LABEL = new HtmlOutputLabel();
		COMP_POAD_POL_OWNER_YN_LABEL = new HtmlOutputLabel();
		/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
		COMP_POAD_HIV_TEST_YN_LABEL = new HtmlOutputLabel();
		/*End*/

		// Instantiating HtmlSelectOneMenu
		COMP_POAD_TYPE = new HtmlSelectOneMenu();
		COMP_POAD_HEIGHT_UNIT = new HtmlSelectOneMenu();
		COMP_POAD_WEIGHT_UNIT = new HtmlSelectOneMenu();
		COMP_POAD_AGE_PROOF_FLAG = new HtmlSelectOneMenu();
		COMP_POAD_SMOKE_YN = new HtmlSelectOneMenu();
		COMP_POAD_POL_OWNER_YN = new HtmlSelectOneMenu();
		COMP_POAD_ALCHOHALIC_YN = new HtmlSelectOneMenu();
		COMP_POAD_AGE_ADMITTED = new HtmlSelectOneMenu();
		/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
		COMP_POAD_HIV_TEST_YN = new HtmlSelectOneMenu();
		/*End*/
		// Instantiating HtmlCalendar
		COMP_POAD_DOB = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_FLEX_FIELDS = new HtmlCommandButton();
		COMP_ADDL_COVER_DTLS = new HtmlCommandButton();
		
		/*added by raja on 16-03-2017 for Query screen issue*/
		COMP_POAD_BPL=new HtmlInputText();
		COMP_POAD_BPH=new HtmlInputText();
		COMP_POAD_OCC_CLASS=new HtmlInputText();
		/*end*/

		/*Added by Ram on 13/03/2017*/
		COMP_POAD_PREGNENT_YN = new HtmlSelectOneMenu();
		/*End*/
		
		/* Newly Added By Dhinesh on 09-01-2018 */
		
		COMP_PERSONAL_INFO_TAB = new HtmlTabPanel();
		
		/* End */
		
		/*Added by Janani on 07.03.2018 for FSD_FLA_IL_008*/
		
		COMP_POAD_FAMILY_YN_FLAG_LABEL = new HtmlOutputLabel(); 
		COMP_POAD_OCC_YN_FLAG_LABEL = new HtmlOutputLabel();
		COMP_POAD_FAMILY_YN_FLAG = new HtmlSelectOneMenu();
		COMP_POAD_OCC_YN_FLAG = new HtmlSelectOneMenu();
		COMP_POAD_FAMILY_YN_BUT = new HtmlCommandButton();
		COMP_POAD_OCC_YN_BUT = new HtmlCommandButton();
		
		/* End of FSD_FLA_IL_008*/
		
		/*Added by Ameen fro Medical occupation class*/
		COMP_POAD_MED_OCC_CLASS = new HtmlInputText();
		/*End*/
		
	}

	public HtmlCommandButton getCOMP_ADDL_COVER_DTLS() {
		return COMP_ADDL_COVER_DTLS;
	}

	public void setCOMP_ADDL_COVER_DTLS(HtmlCommandButton comp_addl_cover_dtls) {
		COMP_ADDL_COVER_DTLS = comp_addl_cover_dtls;
	}

	/**
	 * Disables all components in PT_IL_POL_ASSURED_DTLS_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		//Added by saritha on 09--2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
				COMP_POAD_HIV_TEST_YN.setDisabled(disabled);
				/*End*/

/*Added by Ram on 21/01/2017 for Praganancy field capturing*/
		COMP_POAD_CATG_CODE.setDisabled(disabled);
		/*End*/
		// Disabling HtmlInputText
		COMP_POAD_ASSR_CODE.setDisabled(disabled);
		// COMP_POAD_ASSURED_NAME.setDisabled(disabled);
		COMP_POAD_FC_SALARY.setDisabled(disabled);
		COMP_POAD_REF_ID1.setDisabled(disabled);
		COMP_POAD_REF_ID2.setDisabled(disabled);
		COMP_POAD_LC_SALARY.setDisabled(disabled);
		
		/*commented by R Raja on 03-02-2017 for disable the BMI field*/
		//COMP_POAD_BMI.setDisabled(disabled);
		/*end*/
		COMP_POAD_CATG_CODE.setDisabled(disabled);
		// COMP_UI_M_POAD_CATG_DESC.setDisabled(disabled);
		COMP_POAD_BIRTH_PLACE.setDisabled(disabled);
		COMP_POAD_HEIGHT.setDisabled(disabled);
		COMP_POAD_RACE.setDisabled(disabled);
		// COMP_UI_M_POAD_RACE_CODE_DESC.setDisabled(disabled);
		COMP_POAD_AGE.setDisabled(disabled);
		COMP_POAD_WEIGHT.setDisabled(disabled);
		COMP_POAD_NATURE_OF_WORK.setDisabled(disabled);
		// COMP_POAD_ADDL_RISK_CODE.setDisabled(disabled);
		COMP_UI_M_ADDL_RISK_DESC.setDisabled(disabled);
		COMP_UI_M_POAD_LC_THRESOLD_LMT.setDisabled(disabled);
		COMP_POAD_AGE_PROOF_OTHERS.setDisabled(disabled);
		COMP_POAD_LC_THRESHOLD_LMT.setDisabled(disabled);
		COMP_POAD_DISC_AGE.setDisabled(disabled);
		COMP_POAD_NO_OF_CIGAR.setDisabled(disabled);
		COMP_POAD_REMARKS.setDisabled(disabled);
		COMP_POAD_NATIONALITY.setDisabled(disabled);
		// COMP_UI_M_POAD_NATLITY_DESC.setDisabled(disabled);
		COMP_POAD_MAR_STATUS.setDisabled(disabled);
		COMP_UI_M_POAD_MS_DESC.setDisabled(disabled);
		COMP_POAD_FC_SUM_ASSURED.setDisabled(disabled);
		COMP_POAD_LC_SUM_ASSURED.setDisabled(disabled);
		COMP_POAD_OCC_CODE.setDisabled(disabled);
		COMP_UI_M_POAD_OCC_DESC.setDisabled(disabled);
		COMP_POAD_FC_AMAN_PREM.setDisabled(disabled);
		COMP_POAD_LC_AMAN_PREM.setDisabled(disabled);
		// COMP_POAD_OCC_CLASS.setDisabled(disabled);
		// COMP_UI_M_POAD_OCC_CLASS_DESC.setDisabled(disabled);
		COMP_POAD_FC_AMAN_LOAD_PREM.setDisabled(disabled);
		COMP_POAD_LC_AMAN_LOAD_PREM.setDisabled(disabled);
		COMP_POAD_RELIGION_CODE.setDisabled(disabled);
		// COMP_UI_M_POAD_REL_CODE_DESC.setDisabled(disabled);
		COMP_POAD_FC_SENABEL_PREM.setDisabled(disabled);
		COMP_POAD_LC_SENABEL_PREM.setDisabled(disabled);
		COMP_POAD_HEALTH_CODE.setDisabled(disabled);
		// COMP_UI_M_POAD_HEALTH_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_POAD_TYPE.setDisabled(disabled);
		COMP_POAD_HEIGHT_UNIT.setDisabled(disabled);
		COMP_POAD_WEIGHT_UNIT.setDisabled(disabled);
		COMP_POAD_AGE_PROOF_FLAG.setDisabled(disabled);
		COMP_POAD_SMOKE_YN.setDisabled(disabled);
		COMP_POAD_POL_OWNER_YN.setDisabled(disabled);
		COMP_POAD_ALCHOHALIC_YN.setDisabled(disabled);
		COMP_POAD_AGE_ADMITTED.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_POAD_DOB.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_FLEX_FIELDS.setDisabled(disabled);
		COMP_ADDL_COVER_DTLS.setDisabled(disabled);

		/*added by raja on 16-03-2017 for Query screen issue*/
		COMP_POAD_BPL.setDisabled(disabled);
		COMP_POAD_BPH.setDisabled(disabled);
		COMP_POAD_OCC_CLASS.setDisabled(disabled);
		/*end*/
		
		COMP_POAD_PREGNENT_YN.setDisabled(true);
		
		
		/*Added by Janani on 12.03.2018 for FSD_FLA_IL_008*/

		COMP_POAD_FAMILY_YN_FLAG.setDisabled(disabled);
		COMP_POAD_OCC_YN_FLAG.setDisabled(disabled);

		/*COMP_POAD_FAMILY_YN_BUT.setDisabled(disabled);
		COMP_POAD_OCC_YN_BUT.setDisabled(disabled);*/
		
		/*End of FSD_FLA_IL_008*/
		
		/*Added by Ameen fro Medical occupation class*/
		COMP_POAD_MED_OCC_CLASS.setDisabled(disabled);
		/*End*/
		
	}

	public HtmlCommandButton getCOMP_PT_IL_POL_APPL_PROD() {
		return COMP_PT_IL_POL_APPL_PROD;
	}

	public void setCOMP_PT_IL_POL_APPL_PROD(
			HtmlCommandButton comp_pt_il_pol_appl_prod) {
		COMP_PT_IL_POL_APPL_PROD = comp_pt_il_pol_appl_prod;
	}

	public void POAD_AGE_PROOF_OTHERS_VALIDATOR(FacesContext context,
			UIComponent component, Object value) throws Exception {

		String val = (String) value;
		COMP_POAD_AGE_PROOF_OTHERS.setValue((String) val);
		PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_OTHERS(val);
		// COMP_POAD_AGE_PROOF_OTHERS.resetValue();
	}

	public HtmlSelectOneMenu getCOMP_POAD_POL_OWNER_YN() {
		return COMP_POAD_POL_OWNER_YN;
	}

	public void setCOMP_POAD_POL_OWNER_YN(
			HtmlSelectOneMenu comp_poad_pol_owner_yn) {
		COMP_POAD_POL_OWNER_YN = comp_poad_pol_owner_yn;
	}

	public List<SelectItem> getListPOAD_POL_OWNER_YN() {
		return listPOAD_POL_OWNER_YN;
	}

	public void setListPOAD_POL_OWNER_YN(List<SelectItem> listPOAD_POL_OWNER_YN) {
		this.listPOAD_POL_OWNER_YN = listPOAD_POL_OWNER_YN;
	}

	public HtmlOutputLabel getCOMP_POAD_POL_OWNER_YN_LABEL() {
		return COMP_POAD_POL_OWNER_YN_LABEL;
	}

	public void setCOMP_POAD_POL_OWNER_YN_LABEL(
			HtmlOutputLabel comp_poad_pol_owner_yn_label) {
		COMP_POAD_POL_OWNER_YN_LABEL = comp_poad_pol_owner_yn_label;
	}

	public HtmlOutputLabel getCOMP_POAD_ALCHOHALIC_YN_LABEL() {
		return COMP_POAD_ALCHOHALIC_YN_LABEL;
	}

	public void setCOMP_POAD_ALCHOHALIC_YN_LABEL(
			HtmlOutputLabel comp_poad_alchohalic_yn_label) {
		COMP_POAD_ALCHOHALIC_YN_LABEL = comp_poad_alchohalic_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_POAD_ALCHOHALIC_YN() {
		return COMP_POAD_ALCHOHALIC_YN;
	}

	public void setCOMP_POAD_ALCHOHALIC_YN(
			HtmlSelectOneMenu comp_poad_alchohalic_yn) {
		COMP_POAD_ALCHOHALIC_YN = comp_poad_alchohalic_yn;
	}

	public List<SelectItem> getListPOAD_ALCHOHALIC_YN() {
		return listPOAD_ALCHOHALIC_YN;
	}

	public void setListPOAD_ALCHOHALIC_YN(
			List<SelectItem> listPOAD_ALCHOHALIC_YN) {
		this.listPOAD_ALCHOHALIC_YN = listPOAD_ALCHOHALIC_YN;
	}

	public HtmlInputText getCOMP_POAD_ALCOHOL_QUAN() {
		return COMP_POAD_ALCOHOL_QUAN;
	}

	public void setCOMP_POAD_ALCOHOL_QUAN(HtmlInputText comp_poad_alcohol_quan) {
		COMP_POAD_ALCOHOL_QUAN = comp_poad_alcohol_quan;
	}

	public HtmlOutputLabel getCOMP_POAD_ALCOHOL_QUAN_LABEL() {
		return COMP_POAD_ALCOHOL_QUAN_LABEL;
	}

	public void setCOMP_POAD_ALCOHOL_QUAN_LABEL(
			HtmlOutputLabel comp_poad_alcohol_quan_label) {
		COMP_POAD_ALCOHOL_QUAN_LABEL = comp_poad_alcohol_quan_label;
	}

	public HtmlTab getCOMP_MORE_INFO_1() {
		return COMP_MORE_INFO_1;
	}

	public void setCOMP_MORE_INFO_1(HtmlTab comp_more_info_1) {
		COMP_MORE_INFO_1 = comp_more_info_1;
	}

	public HtmlCommandButton getCOMP_PT_IL_POL_ASS_POL_DTLS() {
		return COMP_PT_IL_POL_ASS_POL_DTLS;
	}

	public void setCOMP_PT_IL_POL_ASS_POL_DTLS(
			HtmlCommandButton comp_pt_il_pol_ass_pol_dtls) {
		COMP_PT_IL_POL_ASS_POL_DTLS = comp_pt_il_pol_ass_pol_dtls;
	}

	public HtmlOutputLabel getCOMP_POAD_AGE_ADMITTED_LABEL() {
		return COMP_POAD_AGE_ADMITTED_LABEL;
	}

	public void setCOMP_POAD_AGE_ADMITTED_LABEL(
			HtmlOutputLabel comp_poad_age_admitted_label) {
		COMP_POAD_AGE_ADMITTED_LABEL = comp_poad_age_admitted_label;
	}

	public HtmlSelectOneMenu getCOMP_POAD_AGE_ADMITTED() {
		return COMP_POAD_AGE_ADMITTED;
	}

	public void setCOMP_POAD_AGE_ADMITTED(
			HtmlSelectOneMenu comp_poad_age_admitted) {
		COMP_POAD_AGE_ADMITTED = comp_poad_age_admitted;
	}

	public List<SelectItem> getListPOAD_AGE_ADMITTED() {
		return listPOAD_AGE_ADMITTED;
	}

	public void setListPOAD_AGE_ADMITTED(List<SelectItem> listPOAD_AGE_ADMITTED) {
		this.listPOAD_AGE_ADMITTED = listPOAD_AGE_ADMITTED;
	}

	/* Added by Ram on 14/11/2016 for BP High & Low factor */

	private HtmlOutputLabel COMP_POAD_BPH_LABEL;
	private HtmlOutputLabel COMP_POAD_BPL_LABEL;
	private HtmlInputText COMP_POAD_BPH;
	private HtmlInputText COMP_POAD_BPL;

	public HtmlOutputLabel getCOMP_POAD_BPH_LABEL() {
		return COMP_POAD_BPH_LABEL;
	}

	public void setCOMP_POAD_BPH_LABEL(HtmlOutputLabel cOMP_POAD_BPH_LABEL) {
		COMP_POAD_BPH_LABEL = cOMP_POAD_BPH_LABEL;
	}

	public HtmlOutputLabel getCOMP_POAD_BPL_LABEL() {
		return COMP_POAD_BPL_LABEL;
	}

	public void setCOMP_POAD_BPL_LABEL(HtmlOutputLabel cOMP_POAD_BPL_LABEL) {
		COMP_POAD_BPL_LABEL = cOMP_POAD_BPL_LABEL;
	}

	public HtmlInputText getCOMP_POAD_BPH() {
		return COMP_POAD_BPH;
	}

	public void setCOMP_POAD_BPH(HtmlInputText cOMP_POAD_BPH) {
		COMP_POAD_BPH = cOMP_POAD_BPH;
	}

	public HtmlInputText getCOMP_POAD_BPL() {
		return COMP_POAD_BPL;
	}

	public void setCOMP_POAD_BPL(HtmlInputText cOMP_POAD_BPL) {
		COMP_POAD_BPL = cOMP_POAD_BPL;
	}

	public void POAD_BPH_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("****Entered into bph validation***");
			Double POAD_BPH = (Double) value;
			try {
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_BPH(POAD_BPH);
				System.out
						.println("getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_BPH()       "
								+ getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_BPH());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_BPL_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("****Entered into bph validation***");
			Double POAD_BPL = (Double) value;
			try {
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_BPL(POAD_BPL);
				System.out
						.println("getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_BPL()       "
								+ getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_BPL());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/* End */

	/*Added by Ram on 09/12/2016 for Medical Info Tab*/
	private HtmlTab COMP_MEDICAL_INFO;
	
	private HtmlOutputLabel COMP_LIPISTRIC_UNIT_LABEL;
	private HtmlOutputLabel COMP_CHOLESTROL_LABEL;
	private HtmlOutputLabel COMP_HDL_LABEL;
	private HtmlOutputLabel COMP_TRIGLY_LABEL;
	private HtmlInputText COMP_POAD_FLEX_01;
	private HtmlInputText COMP_POAD_FLEX_02;
	private HtmlInputText COMP_POAD_FLEX_03;
	
	private HtmlOutputLabel COMP_BLOOD_SUGAR_LABEL;
	private HtmlOutputLabel COMP_FASTING_LABEL;
	private HtmlOutputLabel COMP_RANDOM_LABEL;
	private HtmlOutputLabel COMP_HBA1C_LABEL;
	private HtmlInputText COMP_POAD_FLEX_04;
	private HtmlInputText COMP_POAD_FLEX_05;
	private HtmlInputText COMP_POAD_FLEX_06;
	
	/*Added by Sivarajan on 29/10/2019 for sarwa GL*/
	private HtmlOutputLabel COMP_POAD_FLEX_11_LABEL;
	private HtmlInputText COMP_POAD_FLEX_11;
	private HtmlOutputLabel COMP_POAD_FLEX_12_LABEL;
	private HtmlInputText COMP_POAD_FLEX_12;
	private HtmlOutputLabel COMP_POAD_FLEX_13_LABEL;
	private HtmlInputText COMP_POAD_FLEX_13;
	private HtmlOutputLabel COMP_POAD_FLEX_14_LABEL;
	private HtmlInputText COMP_POAD_FLEX_14;
	private HtmlOutputLabel COMP_POAD_FLEX_15_LABEL;
	private HtmlInputText COMP_POAD_FLEX_15;
	private HtmlOutputLabel COMP_POAD_FLEX_16_LABEL;
	private HtmlInputText COMP_POAD_FLEX_16;
	
	/*private HtmlOutputLabel COMP_POAD_FLEX_17_LABEL;
	private HtmlInputText COMP_POAD_FLEX_17;*/
	
	/*End*/
	
	
	
	public HtmlOutputLabel getCOMP_POAD_FLEX_11_LABEL() {
		return COMP_POAD_FLEX_11_LABEL;
	}

	public void setCOMP_POAD_FLEX_11_LABEL(HtmlOutputLabel cOMP_POAD_FLEX_11_LABEL) {
		COMP_POAD_FLEX_11_LABEL = cOMP_POAD_FLEX_11_LABEL;
	}

	public HtmlInputText getCOMP_POAD_FLEX_11() {
		return COMP_POAD_FLEX_11;
	}

	public void setCOMP_POAD_FLEX_11(HtmlInputText cOMP_POAD_FLEX_11) {
		COMP_POAD_FLEX_11 = cOMP_POAD_FLEX_11;
	}

	public HtmlOutputLabel getCOMP_POAD_FLEX_12_LABEL() {
		return COMP_POAD_FLEX_12_LABEL;
	}

	public void setCOMP_POAD_FLEX_12_LABEL(HtmlOutputLabel cOMP_POAD_FLEX_12_LABEL) {
		COMP_POAD_FLEX_12_LABEL = cOMP_POAD_FLEX_12_LABEL;
	}

	public HtmlInputText getCOMP_POAD_FLEX_12() {
		return COMP_POAD_FLEX_12;
	}

	public void setCOMP_POAD_FLEX_12(HtmlInputText cOMP_POAD_FLEX_12) {
		COMP_POAD_FLEX_12 = cOMP_POAD_FLEX_12;
	}

	public HtmlOutputLabel getCOMP_POAD_FLEX_13_LABEL() {
		return COMP_POAD_FLEX_13_LABEL;
	}

	public void setCOMP_POAD_FLEX_13_LABEL(HtmlOutputLabel cOMP_POAD_FLEX_13_LABEL) {
		COMP_POAD_FLEX_13_LABEL = cOMP_POAD_FLEX_13_LABEL;
	}

	public HtmlInputText getCOMP_POAD_FLEX_13() {
		return COMP_POAD_FLEX_13;
	}

	public void setCOMP_POAD_FLEX_13(HtmlInputText cOMP_POAD_FLEX_13) {
		COMP_POAD_FLEX_13 = cOMP_POAD_FLEX_13;
	}

	public HtmlOutputLabel getCOMP_POAD_FLEX_14_LABEL() {
		return COMP_POAD_FLEX_14_LABEL;
	}

	public void setCOMP_POAD_FLEX_14_LABEL(HtmlOutputLabel cOMP_POAD_FLEX_14_LABEL) {
		COMP_POAD_FLEX_14_LABEL = cOMP_POAD_FLEX_14_LABEL;
	}

	public HtmlInputText getCOMP_POAD_FLEX_14() {
		return COMP_POAD_FLEX_14;
	}

	public void setCOMP_POAD_FLEX_14(HtmlInputText cOMP_POAD_FLEX_14) {
		COMP_POAD_FLEX_14 = cOMP_POAD_FLEX_14;
	}

	public HtmlOutputLabel getCOMP_POAD_FLEX_15_LABEL() {
		return COMP_POAD_FLEX_15_LABEL;
	}

	public void setCOMP_POAD_FLEX_15_LABEL(HtmlOutputLabel cOMP_POAD_FLEX_15_LABEL) {
		COMP_POAD_FLEX_15_LABEL = cOMP_POAD_FLEX_15_LABEL;
	}

	public HtmlInputText getCOMP_POAD_FLEX_15() {
		return COMP_POAD_FLEX_15;
	}

	public void setCOMP_POAD_FLEX_15(HtmlInputText cOMP_POAD_FLEX_15) {
		COMP_POAD_FLEX_15 = cOMP_POAD_FLEX_15;
	}

	public HtmlOutputLabel getCOMP_POAD_FLEX_16_LABEL() {
		return COMP_POAD_FLEX_16_LABEL;
	}

	public void setCOMP_POAD_FLEX_16_LABEL(HtmlOutputLabel cOMP_POAD_FLEX_16_LABEL) {
		COMP_POAD_FLEX_16_LABEL = cOMP_POAD_FLEX_16_LABEL;
	}

	public HtmlInputText getCOMP_POAD_FLEX_16() {
		return COMP_POAD_FLEX_16;
	}

	public void setCOMP_POAD_FLEX_16(HtmlInputText cOMP_POAD_FLEX_16) {
		COMP_POAD_FLEX_16 = cOMP_POAD_FLEX_16;
	}

	private HtmlOutputLabel COMP_BLOOD_PRESSURE_LABEL;
	 
	
	public HtmlTab getCOMP_MEDICAL_INFO() {
		return COMP_MEDICAL_INFO;
	}

	public void setCOMP_MEDICAL_INFO(HtmlTab cOMP_MEDICAL_INFO) {
		COMP_MEDICAL_INFO = cOMP_MEDICAL_INFO;
	}

	public HtmlOutputLabel getCOMP_LIPISTRIC_UNIT_LABEL() {
		return COMP_LIPISTRIC_UNIT_LABEL;
	}

	public void setCOMP_LIPISTRIC_UNIT_LABEL(
			HtmlOutputLabel cOMP_LIPISTRIC_UNIT_LABEL) {
		COMP_LIPISTRIC_UNIT_LABEL = cOMP_LIPISTRIC_UNIT_LABEL;
	}

	public HtmlOutputLabel getCOMP_CHOLESTROL_LABEL() {
		return COMP_CHOLESTROL_LABEL;
	}

	public void setCOMP_CHOLESTROL_LABEL(HtmlOutputLabel cOMP_CHOLESTROL_LABEL) {
		COMP_CHOLESTROL_LABEL = cOMP_CHOLESTROL_LABEL;
	}

	public HtmlOutputLabel getCOMP_HDL_LABEL() {
		return COMP_HDL_LABEL;
	}

	public void setCOMP_HDL_LABEL(HtmlOutputLabel cOMP_HDL_LABEL) {
		COMP_HDL_LABEL = cOMP_HDL_LABEL;
	}

	public HtmlOutputLabel getCOMP_TRIGLY_LABEL() {
		return COMP_TRIGLY_LABEL;
	}

	public void setCOMP_TRIGLY_LABEL(HtmlOutputLabel cOMP_TRIGLY_LABEL) {
		COMP_TRIGLY_LABEL = cOMP_TRIGLY_LABEL;
	}
	
	public HtmlInputText getCOMP_POAD_FLEX_01() {
		return COMP_POAD_FLEX_01;
	}

	public void setCOMP_POAD_FLEX_01(HtmlInputText cOMP_POAD_FLEX_01) {
		COMP_POAD_FLEX_01 = cOMP_POAD_FLEX_01;
	}

	public HtmlInputText getCOMP_POAD_FLEX_02() {
		return COMP_POAD_FLEX_02;
	}

	public void setCOMP_POAD_FLEX_02(HtmlInputText cOMP_POAD_FLEX_02) {
		COMP_POAD_FLEX_02 = cOMP_POAD_FLEX_02;
	}

	public HtmlInputText getCOMP_POAD_FLEX_03() {
		return COMP_POAD_FLEX_03;
	}

	public void setCOMP_POAD_FLEX_03(HtmlInputText cOMP_POAD_FLEX_03) {
		COMP_POAD_FLEX_03 = cOMP_POAD_FLEX_03;
	}

	
	public HtmlOutputLabel getCOMP_BLOOD_SUGAR_LABEL() {
		return COMP_BLOOD_SUGAR_LABEL;
	}

	public void setCOMP_BLOOD_SUGAR_LABEL(HtmlOutputLabel cOMP_BLOOD_SUGAR_LABEL) {
		COMP_BLOOD_SUGAR_LABEL = cOMP_BLOOD_SUGAR_LABEL;
	}

	public HtmlOutputLabel getCOMP_FASTING_LABEL() {
		return COMP_FASTING_LABEL;
	}

	public void setCOMP_FASTING_LABEL(HtmlOutputLabel cOMP_FASTING_LABEL) {
		COMP_FASTING_LABEL = cOMP_FASTING_LABEL;
	}

	public HtmlOutputLabel getCOMP_RANDOM_LABEL() {
		return COMP_RANDOM_LABEL;
	}

	public void setCOMP_RANDOM_LABEL(HtmlOutputLabel cOMP_RANDOM_LABEL) {
		COMP_RANDOM_LABEL = cOMP_RANDOM_LABEL;
	}

	public HtmlOutputLabel getCOMP_HBA1C_LABEL() {
		return COMP_HBA1C_LABEL;
	}

	public void setCOMP_HBA1C_LABEL(HtmlOutputLabel cOMP_HBA1C_LABEL) {
		COMP_HBA1C_LABEL = cOMP_HBA1C_LABEL;
	}

	public HtmlInputText getCOMP_POAD_FLEX_04() {
		return COMP_POAD_FLEX_04;
	}

	public void setCOMP_POAD_FLEX_04(HtmlInputText cOMP_POAD_FLEX_04) {
		COMP_POAD_FLEX_04 = cOMP_POAD_FLEX_04;
	}

	public HtmlInputText getCOMP_POAD_FLEX_05() {
		return COMP_POAD_FLEX_05;
	}

	public void setCOMP_POAD_FLEX_05(HtmlInputText cOMP_POAD_FLEX_05) {
		COMP_POAD_FLEX_05 = cOMP_POAD_FLEX_05;
	}

	public HtmlInputText getCOMP_POAD_FLEX_06() {
		return COMP_POAD_FLEX_06;
	}

	public void setCOMP_POAD_FLEX_06(HtmlInputText cOMP_POAD_FLEX_06) {
		COMP_POAD_FLEX_06 = cOMP_POAD_FLEX_06;
	}

	public HtmlOutputLabel getCOMP_BLOOD_PRESSURE_LABEL() {
		return COMP_BLOOD_PRESSURE_LABEL;
	}

	public void setCOMP_BLOOD_PRESSURE_LABEL(
			HtmlOutputLabel cOMP_BLOOD_PRESSURE_LABEL) {
		COMP_BLOOD_PRESSURE_LABEL = cOMP_BLOOD_PRESSURE_LABEL;
	}

	public void POAD_FLEX_01_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("****Entered into POAD_FLEX_01_VALIDATE_ITEM validation***");
			String POAD_FLEX_01 = (String) value;
			try {
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FLEX_01(POAD_FLEX_01);
				System.out
						.println("getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FLEX_01()       "
								+ getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_FLEX_01());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void POAD_FLEX_02_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("****Entered into POAD_FLEX_02_VALIDATE_ITEM validation***");
			String POAD_FLEX_02 = (String) value;
			try {
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FLEX_02(POAD_FLEX_02);
				System.out
						.println("getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FLEX_02()       "
								+ getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_FLEX_02());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void POAD_FLEX_03_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("****Entered into POAD_FLEX_03_VALIDATE_ITEM validation***");
			String POAD_FLEX_03 = (String) value;
			try {
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FLEX_03(POAD_FLEX_03);
				System.out
						.println("getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FLEX_03()       "
								+ getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_FLEX_03());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void POAD_FLEX_04_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("****Entered into POAD_FLEX_01_VALIDATE_ITEM validation***");
			String POAD_FLEX_04 = (String) value;
			try {
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FLEX_04(POAD_FLEX_04);
				System.out
						.println("getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FLEX_04()       "
								+ getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_FLEX_04());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void POAD_FLEX_05_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("****Entered into POAD_FLEX_02_VALIDATE_ITEM validation***");
			String POAD_FLEX_05 = (String) value;
			try {
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FLEX_05(POAD_FLEX_05);
				System.out
						.println("getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FLEX_05()       "
								+ getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_FLEX_05());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void POAD_FLEX_06_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		try {
			System.out.println("****Entered into POAD_FLEX_03_VALIDATE_ITEM validation***");
			String POAD_FLEX_06 = (String) value;
			try {
				getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FLEX_06(POAD_FLEX_06);
				System.out
						.println("getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FLEX_06()       "
								+ getPT_IL_POL_ASSURED_DTLS_BEAN()
										.getPOAD_FLEX_06());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*End*/
	
/*Added by Saritha on 23.11.2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
	
	private HtmlOutputLabel COMP_POAD_HIV_TEST_YN_LABEL;
	private HtmlSelectOneMenu COMP_POAD_HIV_TEST_YN;

	public HtmlOutputLabel getCOMP_POAD_HIV_TEST_YN_LABEL() {
		return COMP_POAD_HIV_TEST_YN_LABEL;
	}

	public void setCOMP_POAD_HIV_TEST_YN_LABEL(
			HtmlOutputLabel cOMP_POAD_HIV_TEST_YN_LABEL) {
		COMP_POAD_HIV_TEST_YN_LABEL = cOMP_POAD_HIV_TEST_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POAD_HIV_TEST_YN() {
		return COMP_POAD_HIV_TEST_YN;
	}

	public void setCOMP_POAD_HIV_TEST_YN(HtmlSelectOneMenu cOMP_POAD_HIV_TEST_YN) {
		COMP_POAD_HIV_TEST_YN = cOMP_POAD_HIV_TEST_YN;
	}
	
	
	private List<SelectItem> listPOAD_HIV_TEST_YN = new ArrayList<SelectItem>();

	public List<SelectItem> getListPOAD_HIV_TEST_YN() {
		return listPOAD_HIV_TEST_YN;
	}

	public void setListPOAD_HIV_TEST_YN(List<SelectItem> listPOAD_HIV_TEST_YN) {
		this.listPOAD_HIV_TEST_YN = listPOAD_HIV_TEST_YN;
	}

	public void POAD_HIV_TEST_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_HIV_TEST_YN = (String) value;
		try {
			/*helper.POAD_HIV_TEST_YN_WHEN_VALIDATE_ITEM(POAD_HIV_TEST_YN,
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN());*/
			getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_HIV_TEST_YN(POAD_HIV_TEST_YN);
			System.out.println("POAD_HIV_TEST_YN:::::::::::::::::::::"+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_HIV_TEST_YN());
			//COMP_POAD_HIV_TEST_YN.resetValue();
			
			/*Handling if condition nvl by ganesh on 01-08-207 to avoid show stopper issue */
			  if(CommonUtils.isIN(CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_END_CODE(),"XXXX"),"INCSA","DECSA"))					
			{
				  
					if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("N"))
					{ 
						setUPDATE_ALLOWED(true);
						COMP_POAD_HIV_TEST_YN.setDisabled(false);
						if("Y".equalsIgnoreCase(getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_HIV_TEST_YN()))
						{

							compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setUPDATE_ALLOWED(true);
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setINSERT_ALLOWED(true);
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setDELETE_ALLOWED(true);
							CommonUtils.setGlobalVariable("GLOBAL.POAD_HIV_TEST_YN", getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_HIV_TEST_YN());
						}
						else
						{
							compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_MED_EXAM_DTL");
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setUPDATE_ALLOWED(false);
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setINSERT_ALLOWED(false);
							compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().setDELETE_ALLOWED(false);
							CommonUtils.setGlobalVariable("GLOBAL.POAD_HIV_TEST_YN", getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_HIV_TEST_YN());
						}
					}
			
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*End*/
/*Added by Ram on 21/01/2017 for Praganancy field capturing*/
	
	private HtmlOutputLabel COMP_POAD_PREGNENT_YN_LABEL;
	private HtmlSelectOneMenu COMP_POAD_PREGNENT_YN;
	
	public HtmlOutputLabel getCOMP_POAD_PREGNENT_YN_LABEL() {
		return COMP_POAD_PREGNENT_YN_LABEL;
	}

	public void setCOMP_POAD_PREGNENT_YN_LABEL(
			HtmlOutputLabel cOMP_POAD_PREGNENT_YN_LABEL) {
		COMP_POAD_PREGNENT_YN_LABEL = cOMP_POAD_PREGNENT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POAD_PREGNENT_YN() {
		return COMP_POAD_PREGNENT_YN;
	}

	public void setCOMP_POAD_PREGNENT_YN(HtmlSelectOneMenu cOMP_POAD_PREGNENT_YN) {
		COMP_POAD_PREGNENT_YN = cOMP_POAD_PREGNENT_YN;
	}

	public void POAD_PREGNENT_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {

		try {
			String val = (String) value;

			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_PREGNENT_YN(val);

			
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void enablePraganacyField()
	{
		System.out.println("compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_CATG_CODE() in enablePraganacyField      "
				+compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_CATG_CODE()+"    "
				+compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_PREGNENT_YN());


		if(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_CATG_CODE() != null && 
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_CATG_CODE().equalsIgnoreCase("2"))
		{
			COMP_POAD_PREGNENT_YN.setDisabled(false);
			if(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_PREGNENT_YN() == null)
			{
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_PREGNENT_YN("N");	
			}

		}
		else
		{
			COMP_POAD_PREGNENT_YN.setDisabled(true);
			compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_PREGNENT_YN("N");
		}

	}
	/*End*/

/*Added by Janani on 03.04.2017 as part of factory testing feedback Customer Master - Validation point*/
	
	private void getNationalityID() throws Exception {
		
		System.out.println("enters into getNationalityID in assured dtls screen");
		
		String query = "select PC_CODE,PC_DESC from PM_CODES WHERE PC_TYPE = 'NATLITY' and PC_CODE='A00001'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String idCode = null;
		String idDesc = null;

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, con,
					new Object[] {});
			if (rs.next()) {
				
				idCode = rs.getString("PC_CODE");
				PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_NATIONALITY(idCode);
				
				System.out.println("idCode             :"+idCode+"    getPOAD_NATIONALITY           "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_NATIONALITY());
				
				
				idDesc = rs.getString("PC_DESC");
				PT_IL_POL_ASSURED_DTLS_BEAN.setUI_M_POAD_NATLITY_DESC(idDesc);
				
				
				System.out.println("idDesc             :"+idDesc+"    getUI_M_POAD_NATIONALITY_DESC           "+PT_IL_POL_ASSURED_DTLS_BEAN.getUI_M_POAD_NATLITY_DESC());
				
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		
	}
	
	/*End*/
	/*Added by ganesh on 27-10-2017 as suggested by vikram callid ZBLIFE-1449093*/
	public void fireFieldValidationPOAD_AGE_ADMITTED(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String fieldValue = (String)input.getSubmittedValue();
		if(fieldValue.equalsIgnoreCase("N")){
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_AGE_PROOF_FLAG("8");
			COMP_POAD_AGE_PROOF_FLAG.resetValue();
		}
		COMP_POAD_AGE_PROOF_FLAG.resetValue();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	/*end*/
	/*Added by ganesh on 18-01-2018 for 207R morecover funeral */
	public void addCoverRider() throws Exception {
		Connection connection = null;
		ResultSet resultset = null;
		Boolean flag=false;
		String coverCodequery = "SELECT 'X' FROM PM_IL_PLAN,PT_IL_POLICY WHERE PLAN_TYPE IN('L','H') AND PLAN_CODE=POL_PLAN_CODE "
				               + "AND POL_SYS_ID =? UNION SELECT 'X'FROM PT_IL_POL_ADDL_COVER, PM_IL_COVER WHERE POAC_COVER_CODE = COVER_CODE "
				               + "AND COVER_TYPE <> 'B' AND COVER_FUNERAL_CVR_YN = 'Y' AND POAC_POL_SYS_ID = ?";

		try {

			connection = CommonUtils.getConnection();
			resultset = new CRUDHandler().executeSelectStatement(coverCodequery, connection,new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			if(resultset.next()){
				compositeAction.getWizard().enableWizardItem("PILT002_APAC_PT_IL_POL_FUNERAL_MEMB_DTLS");

			}else{
				compositeAction.getWizard().disableWizardItem("PILT002_APAC_PT_IL_POL_FUNERAL_MEMB_DTLS");
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally {
			CommonUtils.closeCursor(resultset);
		}

	}
	/*end*/
	
	/*Added by Janani on 07.03.2018 for FSD_FLA_IL_008*/
	
	private HtmlOutputLabel COMP_POAD_FAMILY_YN_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_POAD_FAMILY_YN_FLAG;
	
	private HtmlOutputLabel COMP_POAD_OCC_YN_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_POAD_OCC_YN_FLAG;
	
	private HtmlCommandButton COMP_POAD_FAMILY_YN_BUT;
	
	private HtmlCommandButton COMP_POAD_OCC_YN_BUT;
	
	private List<SelectItem> listPOAD_FAMILY_YN_FLAG = new ArrayList<SelectItem>();
	
	private List<SelectItem> listPOAD_OCC_YN_FLAG = new ArrayList<SelectItem>();
	
	
	public HtmlCommandButton getCOMP_POAD_OCC_YN_BUT() {
		return COMP_POAD_OCC_YN_BUT;
	}

	public void setCOMP_POAD_OCC_YN_BUT(HtmlCommandButton cOMP_POAD_OCC_YN_BUT) {
		COMP_POAD_OCC_YN_BUT = cOMP_POAD_OCC_YN_BUT;
	}

	public HtmlCommandButton getCOMP_POAD_FAMILY_YN_BUT() {
		return COMP_POAD_FAMILY_YN_BUT;
	}

	public void setCOMP_POAD_FAMILY_YN_BUT(HtmlCommandButton cOMP_POAD_FAMILY_YN_BUT) {
		COMP_POAD_FAMILY_YN_BUT = cOMP_POAD_FAMILY_YN_BUT;
	}

	public HtmlOutputLabel getCOMP_POAD_FAMILY_YN_FLAG_LABEL() {
		return COMP_POAD_FAMILY_YN_FLAG_LABEL;
	}

	public void setCOMP_POAD_FAMILY_YN_FLAG_LABEL(
			HtmlOutputLabel cOMP_POAD_FAMILY_YN_FLAG_LABEL) {
		COMP_POAD_FAMILY_YN_FLAG_LABEL = cOMP_POAD_FAMILY_YN_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POAD_FAMILY_YN_FLAG() {
		return COMP_POAD_FAMILY_YN_FLAG;
	}

	public void setCOMP_POAD_FAMILY_YN_FLAG(
			HtmlSelectOneMenu cOMP_POAD_FAMILY_YN_FLAG) {
		COMP_POAD_FAMILY_YN_FLAG = cOMP_POAD_FAMILY_YN_FLAG;
	}

	public HtmlOutputLabel getCOMP_POAD_OCC_YN_FLAG_LABEL() {
		return COMP_POAD_OCC_YN_FLAG_LABEL;
	}

	public void setCOMP_POAD_OCC_YN_FLAG_LABEL(
			HtmlOutputLabel cOMP_POAD_OCC_YN_FLAG_LABEL) {
		COMP_POAD_OCC_YN_FLAG_LABEL = cOMP_POAD_OCC_YN_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POAD_OCC_YN_FLAG() {
		return COMP_POAD_OCC_YN_FLAG;
	}

	public void setCOMP_POAD_OCC_YN_FLAG(HtmlSelectOneMenu cOMP_POAD_OCC_YN_FLAG) {
		COMP_POAD_OCC_YN_FLAG = cOMP_POAD_OCC_YN_FLAG;
	}

	public List<SelectItem> getListPOAD_FAMILY_YN_FLAG() {
		

		if (listPOAD_FAMILY_YN_FLAG.size() == 0) {
			listPOAD_FAMILY_YN_FLAG.clear();
			try {
				listPOAD_FAMILY_YN_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listPOAD_FAMILY_YN_FLAG;
	}

	public void setListPOAD_FAMILY_YN_FLAG(List<SelectItem> listPOAD_FAMILY_YN_FLAG) {
		this.listPOAD_FAMILY_YN_FLAG = listPOAD_FAMILY_YN_FLAG;
	}
	
	
	
	public List<SelectItem> getListPOAD_OCC_YN_FLAG() {

		if (listPOAD_OCC_YN_FLAG.size() == 0) {
			listPOAD_OCC_YN_FLAG.clear();
			try {
				listPOAD_OCC_YN_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPOAD_OCC_YN_FLAG;
	}

	public void setListPOAD_OCC_YN_FLAG(List<SelectItem> listPOAD_OCC_YN_FLAG) {
		this.listPOAD_OCC_YN_FLAG = listPOAD_OCC_YN_FLAG;
	}

	public void POAD_FAMILY_YN_FLAG_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value) {
		
		try {
			
			compositeAction
			.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_FAMILY_YN((String) value);
			
			 System.out.println("getPOAD_FAMILY_YN  in action                        "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_FAMILY_YN());
			helper.POAD_FAMILY_YN_FLAG_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			/*if(("Y".equalsIgnoreCase(compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_FAMILY_YN()))){
				
				COMP_POAD_FAMILY_YN_BUT.setDisabled(false);
				
			}else{
				
				COMP_POAD_FAMILY_YN_BUT.setDisabled(true);
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void POAD_OCC_YN_FLAG_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value) {
		
		try {
			
			compositeAction
			.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_OCC_YN((String) value);
			
			 System.out.println("getPOAD_OCC_YN   in action                       "+PT_IL_POL_ASSURED_DTLS_BEAN.getPOAD_OCC_YN());
			
			helper.POAD_OCC_YN_FLAG_WHEN_VALIDATE_ITEM(compositeAction,
					value);
			/*if(("Y".equalsIgnoreCase(compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_OCC_YN()))){
				
				COMP_POAD_OCC_YN_BUT.setDisabled(false);
				
			}else{

				COMP_POAD_OCC_YN_BUT.setDisabled(true);
				
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public String familyHistory() {
		String outCome = null;
		outCome = "PILT002_APAC_PT_IL_POL_ASSR_FAMILY_DTLS";
		
		return outCome;
	}

	public String occupationHistory() {
		String outCome = null;
		outCome = "PILT002_APAC_PT_IL_POL_ASSR_OCCU_DTLS";
		
		return outCome;
	}
	
	
	/*End of FSD_FLA_IL_008*/
	
	/*Added by Ameen on 12-04-2018 for KIC medical ocupation code*/
	private HtmlOutputLabel COMP_POAD_MED_OCC_CLASS_LABEL;
	
	private HtmlInputText COMP_POAD_MED_OCC_CLASS;
	
	private HtmlInputText COMP_UI_M_POAD_MED_OCC_CLASS_DESC;

	public HtmlOutputLabel getCOMP_POAD_MED_OCC_CLASS_LABEL() {
		return COMP_POAD_MED_OCC_CLASS_LABEL;
	}

	public void setCOMP_POAD_MED_OCC_CLASS_LABEL(
			HtmlOutputLabel cOMP_POAD_MED_OCC_CLASS_LABEL) {
		COMP_POAD_MED_OCC_CLASS_LABEL = cOMP_POAD_MED_OCC_CLASS_LABEL;
	}

	public HtmlInputText getCOMP_POAD_MED_OCC_CLASS() {
		return COMP_POAD_MED_OCC_CLASS;
	}

	public void setCOMP_POAD_MED_OCC_CLASS(HtmlInputText cOMP_POAD_MED_OCC_CLASS) {
		COMP_POAD_MED_OCC_CLASS = cOMP_POAD_MED_OCC_CLASS;
	}
	
	public HtmlInputText getCOMP_UI_M_POAD_MED_OCC_CLASS_DESC() {
		return COMP_UI_M_POAD_MED_OCC_CLASS_DESC;
	}

	public void setCOMP_UI_M_POAD_MED_OCC_CLASS_DESC(
			HtmlInputText cOMP_UI_M_POAD_MED_OCC_CLASS_DESC) {
		COMP_UI_M_POAD_MED_OCC_CLASS_DESC = cOMP_UI_M_POAD_MED_OCC_CLASS_DESC;
	}

	public void validatePOAD_MED_OCC_CLASS(FacesContext context,
			UIComponent component, Object value) {
		
		try {
			PT_IL_POL_ASSURED_DTLS_BEAN.setPOAD_MED_OCC_CLASS((String)value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public ArrayList<LovBean> prepareSuggestionList_POAD_MED_OCC_CLASS(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_MED_OCC_CLASS";
		Object param1 = "IL_MED_OCC";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	/*Newly Added by pidugu raj dt: 23-08-2018 for KICLIFEQC-1762429*/

	public ArrayList<LovBean> prepareSuggestionList_PBEN_RELATION_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String currentValue = (String) object;		
			String moduleName = "PILT002_APAC";
			String blockName = "PT_IL_POL_CUST_DTLS";
			String fieldName = "PCD_RELATION_TYPE";
			ListItemUtil itemUtil = new ListItemUtil();
			
			

			try {
				/*lovList = helper.doGetLovDetails();*/
				lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
						"IL_ALT_CUST",null, null, null, null, currentValue);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return lovList;
	}
	
	public HtmlInputText getCOMP_CUST_NAME() {
		return COMP_CUST_NAME;
	}

	public void setCOMP_CUST_NAME(HtmlInputText cOMP_CUST_NAME) {
		COMP_CUST_NAME = cOMP_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_CUST_NAME_LABEL() {
		return COMP_CUST_NAME_LABEL;
	}

	public void setCOMP_CUST_NAME_LABEL(HtmlOutputLabel cOMP_CUST_NAME_LABEL) {
		COMP_CUST_NAME_LABEL = cOMP_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CIVIL_ID() {
		return COMP_CIVIL_ID;
	}

	public void setCOMP_CIVIL_ID(HtmlInputText cOMP_CIVIL_ID) {
		COMP_CIVIL_ID = cOMP_CIVIL_ID;
	}

	public HtmlOutputLabel getCOMP_CIVIL_ID_LABEL() {
		return COMP_CIVIL_ID_LABEL;
	}

	public void setCOMP_CIVIL_ID_LABEL(HtmlOutputLabel cOMP_CIVIL_ID_LABEL) {
		COMP_CIVIL_ID_LABEL = cOMP_CIVIL_ID_LABEL;
	}

	public HtmlCalendar getCOMP_CUST_DOB() {
		return COMP_CUST_DOB;
	}

	public void setCOMP_CUST_DOB(HtmlCalendar cOMP_CUST_DOB) {
		COMP_CUST_DOB = cOMP_CUST_DOB;
	}

	public HtmlOutputLabel getCOMP_CUST_DOB_LABEL() {
		return COMP_CUST_DOB_LABEL;
	}

	public void setCOMP_CUST_DOB_LABEL(HtmlOutputLabel cOMP_CUST_DOB_LABEL) {
		COMP_CUST_DOB_LABEL = cOMP_CUST_DOB_LABEL;
	}

	public HtmlTab getCOMP_MORE_INFO_2() {
		return COMP_MORE_INFO_2;
	}

	public void setCOMP_MORE_INFO_2(HtmlTab cOMP_MORE_INFO_2) {
		COMP_MORE_INFO_2 = cOMP_MORE_INFO_2;
	}
	public HtmlInputText getCOMP_CUST_RELN() {
		return COMP_CUST_RELN;
	}

	public void setCOMP_CUST_RELN(HtmlInputText cOMP_CUST_RELN) {
		COMP_CUST_RELN = cOMP_CUST_RELN;
	}

	public HtmlOutputLabel getCOMP_CUST_RELN_LABEL() {
		return COMP_CUST_RELN_LABEL;
	}

	public void setCOMP_CUST_RELN_LABEL(HtmlOutputLabel cOMP_CUST_RELN_LABEL) {
		COMP_CUST_RELN_LABEL = cOMP_CUST_RELN_LABEL;
	}

	public PT_IL_POL_CUST_DTLS getpT_IL_POL_CUST_DTLS_BEAN() {
		return pT_IL_POL_CUST_DTLS_BEAN;
	}

	public void setpT_IL_POL_CUST_DTLS_BEAN(
			PT_IL_POL_CUST_DTLS pT_IL_POL_CUST_DTLS_BEAN) {
		this.pT_IL_POL_CUST_DTLS_BEAN = pT_IL_POL_CUST_DTLS_BEAN;
	}

	private HtmlInputText COMP_UI_M_PFMD_RELATION_DESC;

	public HtmlInputText getCOMP_UI_M_PFMD_RELATION_DESC() {
		return COMP_UI_M_PFMD_RELATION_DESC;
	}
	public void setCOMP_UI_M_PFMD_RELATION_DESC(
			HtmlInputText cOMP_UI_M_PFMD_RELATION_DESC) {
		COMP_UI_M_PFMD_RELATION_DESC = cOMP_UI_M_PFMD_RELATION_DESC;
	}
	
	public PT_IL_POL_CUST_DTLS doGetPolCustDetails(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		Connection connection = null;
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		PT_IL_POL_CUST_DTLS pT_IL_POL_CUST_DTLS  = new PT_IL_POL_CUST_DTLS();
		String  CURSOR_C1 = "select PCD_POL_SYS_ID,PCD_CIVIL_ID, PCD_CUST_NAME,PCD_RELATION_TYPE,PCD_DOB,PCD_SYS_ID from PT_IL_POL_CUST_DTLS WHERE PCD_POL_SYS_ID = ?";
		try{
			connection = CommonUtils.getConnection();
			resultSet1 = handler.executeSelectStatement(CURSOR_C1, connection, new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			if(resultSet1.next()){
				pT_IL_POL_CUST_DTLS.setPCD_POL_SYS_ID(resultSet1.getInt(1));
				pT_IL_POL_CUST_DTLS.setPCD_CIVIL_ID(resultSet1.getString(2));
				pT_IL_POL_CUST_DTLS.setPCD_CUST_NAME(resultSet1.getString(3));
				pT_IL_POL_CUST_DTLS.setPCD_RELATION_TYPE(resultSet1.getString(4));
				pT_IL_POL_CUST_DTLS.setPCD_DOB(resultSet1.getDate(5));
				pT_IL_POL_CUST_DTLS.setPCD_SYS_ID((resultSet1.getInt(6)));
				
			}
			
			CommonUtils.closeCursor(resultSet1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pT_IL_POL_CUST_DTLS;
	}

	
	/*End added by pidugu raj 23-08-2018 for KICLIFEQC-1762429*/

	


	
	/*end*/
	
	
	
}
