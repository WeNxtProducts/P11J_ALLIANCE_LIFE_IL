
package com.iii.pel.forms.PILM039;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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

import org.richfaces.component.html.HtmlComboBox;
import org.richfaces.component.html.HtmlDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM034.PILM034_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;


public class PM_IL_APPR_SETUP_ACTION extends CommonAction{


	private HtmlComboBox COMP_ACMD_PROD_TYPE;

	private HtmlOutputLabel COMP_AS_USER_ID_LABEL;

	private HtmlInputText COMP_AS_USER_ID;

	private HtmlOutputLabel COMP_UI_M_USER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_USER_DESC;

	private HtmlOutputLabel COMP_AS_FM_PROD_CODE_LABEL;

	private HtmlInputText COMP_AS_FM_PROD_CODE;

	private HtmlOutputLabel COMP_AS_TO_PROD_CODE_LABEL;

	private HtmlInputText COMP_AS_TO_PROD_CODE;

	private HtmlOutputLabel COMP_AS_FM_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_AS_FM_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_AS_TO_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_AS_TO_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_USER_GROUP_ID_LABEL;

	private HtmlInputText COMP_USER_GROUP_ID;

	private HtmlCommandButton COMP_AS_FM_PROD_CODE_BUT;

	private HtmlCommandButton COMP_AS_TO_PROD_CODE_BUT;

	private HtmlCommandButton COMP_UI_M_BUT_COPY;

	private HtmlCommandButton COMP_UI_M_LOV_USER_ID;

	private PM_IL_APPR_SETUP PM_IL_APPR_SETUP_BEAN;

	
	private CTRL_1_ACTION CTRL_1_ACTION_BEAN; 
	
	public PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction;

	private HtmlCommandButton PREFORMBUTTON;

	private HtmlDataTable htmlDataTable;

	private UIInput input;

	private boolean nonUpdatable;
	private ArrayList<PM_IL_APPR_SETUP> list = new ArrayList<PM_IL_APPR_SETUP>();
	private PILM039_DELIGATE deligate = new PILM039_DELIGATE();
	private FacesContext ctx = null;
	private static int rowCount = 1;

	private Connection connection = null;

	public PM_IL_APPR_SETUP_ACTION() {
		PM_IL_APPR_SETUP_BEAN = new PM_IL_APPR_SETUP();
		//CTRL_1_BEAN = new CTRL_1();
		CTRL_1_ACTION_BEAN = new CTRL_1_ACTION();
	}

	public HtmlOutputLabel getCOMP_AS_USER_ID_LABEL() {
		return COMP_AS_USER_ID_LABEL;
	}

	public HtmlInputText getCOMP_AS_USER_ID() {
		return COMP_AS_USER_ID;
	}

	public void setCOMP_AS_USER_ID_LABEL(HtmlOutputLabel COMP_AS_USER_ID_LABEL) {
		this.COMP_AS_USER_ID_LABEL = COMP_AS_USER_ID_LABEL;
	}

	public void setCOMP_AS_USER_ID(HtmlInputText COMP_AS_USER_ID) {
		this.COMP_AS_USER_ID = COMP_AS_USER_ID;
	}

	public HtmlOutputLabel getCOMP_UI_M_USER_DESC_LABEL() {
		return COMP_UI_M_USER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_USER_DESC() {
		return COMP_UI_M_USER_DESC;
	}

	public void setCOMP_UI_M_USER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_USER_DESC_LABEL) {
		this.COMP_UI_M_USER_DESC_LABEL = COMP_UI_M_USER_DESC_LABEL;
	}

	public void setCOMP_UI_M_USER_DESC(HtmlInputText COMP_UI_M_USER_DESC) {
		this.COMP_UI_M_USER_DESC = COMP_UI_M_USER_DESC;
	}

	public HtmlOutputLabel getCOMP_AS_FM_PROD_CODE_LABEL() {
		return COMP_AS_FM_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_AS_FM_PROD_CODE() {
		return COMP_AS_FM_PROD_CODE;
	}

	public void setCOMP_AS_FM_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_AS_FM_PROD_CODE_LABEL) {
		this.COMP_AS_FM_PROD_CODE_LABEL = COMP_AS_FM_PROD_CODE_LABEL;
	}

	public void setCOMP_AS_FM_PROD_CODE(HtmlInputText COMP_AS_FM_PROD_CODE) {
		this.COMP_AS_FM_PROD_CODE = COMP_AS_FM_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_AS_TO_PROD_CODE_LABEL() {
		return COMP_AS_TO_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_AS_TO_PROD_CODE() {
		return COMP_AS_TO_PROD_CODE;
	}

	public void setCOMP_AS_TO_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_AS_TO_PROD_CODE_LABEL) {
		this.COMP_AS_TO_PROD_CODE_LABEL = COMP_AS_TO_PROD_CODE_LABEL;
	}

	public void setCOMP_AS_TO_PROD_CODE(HtmlInputText COMP_AS_TO_PROD_CODE) {
		this.COMP_AS_TO_PROD_CODE = COMP_AS_TO_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_AS_FM_PROD_CODE_DESC_LABEL() {
		return COMP_AS_FM_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_AS_FM_PROD_CODE_DESC() {
		return COMP_AS_FM_PROD_CODE_DESC;
	}

	public void setCOMP_AS_FM_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_AS_FM_PROD_CODE_DESC_LABEL) {
		this.COMP_AS_FM_PROD_CODE_DESC_LABEL = COMP_AS_FM_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_AS_FM_PROD_CODE_DESC(
			HtmlInputText COMP_AS_FM_PROD_CODE_DESC) {
		this.COMP_AS_FM_PROD_CODE_DESC = COMP_AS_FM_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_AS_TO_PROD_CODE_DESC_LABEL() {
		return COMP_AS_TO_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_AS_TO_PROD_CODE_DESC() {
		return COMP_AS_TO_PROD_CODE_DESC;
	}

	public void setCOMP_AS_TO_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_AS_TO_PROD_CODE_DESC_LABEL) {
		this.COMP_AS_TO_PROD_CODE_DESC_LABEL = COMP_AS_TO_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_AS_TO_PROD_CODE_DESC(
			HtmlInputText COMP_AS_TO_PROD_CODE_DESC) {
		this.COMP_AS_TO_PROD_CODE_DESC = COMP_AS_TO_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_USER_GROUP_ID_LABEL() {
		return COMP_USER_GROUP_ID_LABEL;
	}

	public HtmlInputText getCOMP_USER_GROUP_ID() {
		return COMP_USER_GROUP_ID;
	}

	public void setCOMP_USER_GROUP_ID_LABEL(
			HtmlOutputLabel COMP_USER_GROUP_ID_LABEL) {
		this.COMP_USER_GROUP_ID_LABEL = COMP_USER_GROUP_ID_LABEL;
	}

	public void setCOMP_USER_GROUP_ID(HtmlInputText COMP_USER_GROUP_ID) {
		this.COMP_USER_GROUP_ID = COMP_USER_GROUP_ID;
	}

	public HtmlCommandButton getCOMP_AS_FM_PROD_CODE_BUT() {
		return COMP_AS_FM_PROD_CODE_BUT;
	}

	public void setCOMP_AS_FM_PROD_CODE_BUT(
			HtmlCommandButton COMP_AS_FM_PROD_CODE_BUT) {
		this.COMP_AS_FM_PROD_CODE_BUT = COMP_AS_FM_PROD_CODE_BUT;
	}

	public HtmlCommandButton getCOMP_AS_TO_PROD_CODE_BUT() {
		return COMP_AS_TO_PROD_CODE_BUT;
	}

	public void setCOMP_AS_TO_PROD_CODE_BUT(
			HtmlCommandButton COMP_AS_TO_PROD_CODE_BUT) {
		this.COMP_AS_TO_PROD_CODE_BUT = COMP_AS_TO_PROD_CODE_BUT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_COPY() {
		return COMP_UI_M_BUT_COPY;
	}

	public void setCOMP_UI_M_BUT_COPY(HtmlCommandButton COMP_UI_M_BUT_COPY) {
		this.COMP_UI_M_BUT_COPY = COMP_UI_M_BUT_COPY;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_USER_ID() {
		return COMP_UI_M_LOV_USER_ID;
	}

	public void setCOMP_UI_M_LOV_USER_ID(HtmlCommandButton COMP_UI_M_LOV_USER_ID) {
		this.COMP_UI_M_LOV_USER_ID = COMP_UI_M_LOV_USER_ID;
	}

	public PM_IL_APPR_SETUP getPM_IL_APPR_SETUP_BEAN() {
		return PM_IL_APPR_SETUP_BEAN;
	}

	public void setPM_IL_APPR_SETUP_BEAN(PM_IL_APPR_SETUP PM_IL_APPR_SETUP_BEAN) {
		this.PM_IL_APPR_SETUP_BEAN = PM_IL_APPR_SETUP_BEAN;
	}

	public void invokeUserGroupAndUserDesc(ActionEvent event) {
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();

		String assignUserId = getCOMP_AS_USER_ID().getSubmittedValue()
				.toString();
		if (!assignUserId.isEmpty() && assignUserId != null) {
			Object obj = deligate.fetchUserGroup(getCOMP_AS_USER_ID()
					.getSubmittedValue().toString());
			setPM_IL_APPR_SETUP_BEAN((PM_IL_APPR_SETUP) obj);
			getCOMP_UI_M_USER_DESC().setSubmittedValue(
					getPM_IL_APPR_SETUP_BEAN().getUI_M_USER_DESC());
			getCOMP_USER_GROUP_ID().setSubmittedValue(
					getPM_IL_APPR_SETUP_BEAN().getUSER_GROUP_ID());
		} 
	}

	public void fetchFromProductDesc(ActionEvent event) {
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		String fromProductCode = getCOMP_AS_FM_PROD_CODE().getSubmittedValue()
				.toString();

		if (fromProductCode != null && !fromProductCode.isEmpty()) {
			Object obj = deligate
					.fetchFromProductDesc(getCOMP_AS_FM_PROD_CODE()
							.getSubmittedValue().toString());
			setPM_IL_APPR_SETUP_BEAN((PM_IL_APPR_SETUP) obj);
			getCOMP_AS_FM_PROD_CODE_DESC().setSubmittedValue(
					getPM_IL_APPR_SETUP_BEAN().getAS_FM_PROD_CODE_DESC());

		} else {
			getCOMP_AS_FM_PROD_CODE().setSubmittedValue("0");
			getCOMP_AS_FM_PROD_CODE_DESC().setSubmittedValue(
					" Default Description ");

		}

	}

	public void fetchToProductDesc1(ActionEvent event) {
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();

		String toProductCode = (String) getCOMP_AS_TO_PROD_CODE().getSubmittedValue();
		if (toProductCode != null && !toProductCode.isEmpty()) {
			Object obj = deligate.fetchToProductDesc((String) getCOMP_AS_TO_PROD_CODE().getSubmittedValue());
			setPM_IL_APPR_SETUP_BEAN((PM_IL_APPR_SETUP) obj);
			getCOMP_AS_TO_PROD_CODE_DESC().setSubmittedValue(getPM_IL_APPR_SETUP_BEAN().getAS_TO_PROD_CODE_DESC());
		} else {
			getCOMP_AS_TO_PROD_CODE().setSubmittedValue("zzzzzzzzzzzz");
			getCOMP_AS_TO_PROD_CODE_DESC().setSubmittedValue(
					" Default Description ");
		}
	}

	public void fetchToProductDesc(ActionEvent event) {
		PILM039Helper helper = new PILM039Helper();
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();

		String AS_TO_PROD_CODE = (String) getCOMP_AS_TO_PROD_CODE().getSubmittedValue();
		String AS_FM_PROD_CODE = (String) getCOMP_AS_FM_PROD_CODE().getSubmittedValue();
		boolean isFromStringCode = helper.isValidNumber(AS_FM_PROD_CODE);
		boolean isToStringCode = helper.isValidNumber(AS_TO_PROD_CODE);
		if (AS_TO_PROD_CODE.length() > 0 && AS_FM_PROD_CODE.length() > 0) {
			if (!isFromStringCode) {
				Object obj = deligate.fetchToProductDesc(AS_TO_PROD_CODE);
				setPM_IL_APPR_SETUP_BEAN((PM_IL_APPR_SETUP) obj);
				getCOMP_AS_TO_PROD_CODE_DESC().setSubmittedValue(
						getPM_IL_APPR_SETUP_BEAN().getAS_TO_PROD_CODE_DESC());
			} else {
				if (isToStringCode) {
					Object obj = deligate.fetchToProductDesc(AS_TO_PROD_CODE);
					setPM_IL_APPR_SETUP_BEAN((PM_IL_APPR_SETUP) obj);
					getCOMP_AS_TO_PROD_CODE_DESC().setSubmittedValue(
							getPM_IL_APPR_SETUP_BEAN()
									.getAS_TO_PROD_CODE_DESC());
				} else {
					System.out.println("Not Allowed");
				}
			}
		} else {
			getCOMP_AS_TO_PROD_CODE().setSubmittedValue("zzzzzzzzzzzz");
			getCOMP_AS_TO_PROD_CODE_DESC().setSubmittedValue(" Default Description ");
		}
	}
	public HtmlCommandButton getPREFORMBUTTON() {
		return PREFORMBUTTON;
	}

	public void setPREFORMBUTTON(HtmlCommandButton preformbutton) {
		PREFORMBUTTON = preformbutton;
	}

	public HtmlComboBox getCOMP_ACMD_PROD_TYPE() {
		return COMP_ACMD_PROD_TYPE;
	}

	public void setCOMP_ACMD_PROD_TYPE(HtmlComboBox comp_acmd_prod_type) {
		COMP_ACMD_PROD_TYPE = comp_acmd_prod_type;
	}

	public UIInput getInput() {
		return input;
	}

	public void setInput(UIInput input) {
		this.input = input;
	}

	public ArrayList<PM_IL_APPR_SETUP> getList() {
		return list;
	}

	public void setList(ArrayList<PM_IL_APPR_SETUP> list) {
		this.list = list;
	}

	public String limitsPage() {
		ArrayList<PM_IL_APPR_SETUP_DET1> dataList = new ArrayList<PM_IL_APPR_SETUP_DET1>();
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		CommonUtils commonUtils =new CommonUtils();
		PM_IL_APPR_SETUP_DET1_ACTION listAction = null;
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;

		compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
								// PREMIAGDC-0135 –  for ASD_APPR_GRP , Added by: Shankar Bodduluri, Dated: 13-Mar-2009
		String ASD_APPR_GRP = compositeAction.getPM_IL_APPR_SETUP_DET1_ACTION_BEAN().getPM_IL_APPR_SETUP_DET1_BEAN().getASD_APPR_GRP();
		dataList = deligate.loadLimitsValues(this,ASD_APPR_GRP);
		listAction = compositeAction.getPM_IL_APPR_SETUP_DET1_ACTION_BEAN();
		if (listAction == null) {
			listAction = new PM_IL_APPR_SETUP_DET1_ACTION();
			compositeAction.setPM_IL_APPR_SETUP_DET1_ACTION_BEAN(listAction);
		}
		listAction.setList(dataList);

		return "limits";
	}

	public String rightsPage() {
		ArrayList<PM_IL_APPR_SETUP_DET> dataList = new ArrayList<PM_IL_APPR_SETUP_DET>();
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		CommonUtils commonUtils =new CommonUtils();
		PM_IL_APPR_SETUP_DET_ACTION listAction = null;
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
		

		compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
									// PREMIAGDC-0135 –  for ASD_APPR_GRP , Added by: Shankar Bodduluri, Dated: 13-Mar-2009
		String ASD_APPR_GRP = compositeAction.getPM_IL_APPR_SETUP_DET_ACTION_BEAN().getPM_IL_APPR_SETUP_DET_BEAN().getASD_APPR_GRP();
		dataList = deligate.loadRightsValues(this,ASD_APPR_GRP);

		listAction = compositeAction.getPM_IL_APPR_SETUP_DET_ACTION_BEAN();
		if (listAction == null) {
			listAction = new PM_IL_APPR_SETUP_DET_ACTION();
			compositeAction.setPM_IL_APPR_SETUP_DET_ACTION_BEAN(listAction);
		}
		listAction.setList(dataList);

		return "rights";
	}

	public void callRightPage() {

		ArrayList<PM_IL_APPR_SETUP_DET> dataList = new ArrayList<PM_IL_APPR_SETUP_DET>();
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		CommonUtils commonUtils =new CommonUtils();
		PM_IL_APPR_SETUP_DET_ACTION listAction = null;
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;

							// PREMIAGDC-0135 –  for ASD_APPR_GRP , Added by: Shankar Bodduluri, Dated: 13-Mar-2009
		compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		String ASD_APPR_GRP = compositeAction.getPM_IL_APPR_SETUP_DET_ACTION_BEAN().getPM_IL_APPR_SETUP_DET_BEAN().getASD_APPR_GRP();
		dataList = deligate.loadRightsValues(this,ASD_APPR_GRP);
		
		listAction = compositeAction.getPM_IL_APPR_SETUP_DET_ACTION_BEAN();
		if (listAction == null) {
			listAction = new PM_IL_APPR_SETUP_DET_ACTION();
			compositeAction.setPM_IL_APPR_SETUP_DET_ACTION_BEAN(listAction);
		}
		listAction.setList(dataList);
	}
	public String deleteRow(){
		try{
			if (isDELETE_ALLOWED()){
				new CRUDHandler().executeDelete(PM_IL_APPR_SETUP_BEAN,CommonUtils.getConnection());
				compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN().setPM_IL_APPR_SETUP_BEAN(new PM_IL_APPR_SETUP());				
				getWarningMap().put(
						"deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
			}else{
				getErrorMap().put("deleteRow",Messages.getString(PELConstants.
						pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
			}
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}
		return "";
	}

	public String divisionPage() {
		ArrayList<PM_IL_APPR_DEPT_SETUP> dataList = new ArrayList<PM_IL_APPR_DEPT_SETUP>();
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_APPR_DEPT_SETUP_ACTION listAction = null;
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;

		dataList = deligate.loadDeptAndBranchValues(this);
		compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
		compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");

		listAction = compositeAction.getPM_IL_APPR_DEPT_SETUP_ACTION_BEAN();
		if (listAction == null) {
			listAction = new PM_IL_APPR_DEPT_SETUP_ACTION();
			compositeAction.setPM_IL_APPR_DEPT_SETUP_ACTION_BEAN(listAction);
		}
		listAction.setList(dataList);

		return "division";
	}

	public String headerPage() {
		return "header";
	}

	public String processPage() {
		ArrayList<PM_IL_END_APPR_SETUP> dataList = new ArrayList<PM_IL_END_APPR_SETUP>();
		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
		CommonUtils commonUtils =new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
		PM_IL_END_APPR_SETUP_ACTION listAction = null;

		try {
			dataList = deligate.loadProcessEndosmentValues();
			compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
			compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
			listAction = compositeAction.getPM_IL_END_APPR_SETUP_ACTION_BEAN();
			if (listAction == null) {
				listAction = new PM_IL_END_APPR_SETUP_ACTION();
				compositeAction.setPM_IL_END_APPR_SETUP_ACTION_BEAN(listAction);
			}
			listAction.setList(dataList);
		} catch (Exception e) {
			e.printStackTrace();
		}


		return "process";
	}

	public String mainPage() {
		return "MainPage";
	}

	public HtmlDataTable getHtmlDataTable() {
		return htmlDataTable;
	}

	public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
		this.htmlDataTable = htmlDataTable;
	}

	public void validatePILM039User(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void P_VAL_USER_ID(FacesContext fc, UIComponent component,Object value) throws Exception{
		UIInput inputText = (UIInput) component;
		PILM039_DELIGATE newDeligate = new PILM039_DELIGATE();
		ArrayList P_VAL_USER_IDList;
		
			try {
				if (inputText.getSubmittedValue() != null) {
					String USER_ID = (String) inputText.getSubmittedValue();
					P_VAL_USER_IDList = (ArrayList) newDeligate.P_VAL_USER_ID(USER_ID);
					System.out.println(P_VAL_USER_IDList);
					String ERRORMESSAGE = newDeligate.P_VAL_USER_ID_Validation();
					if (P_VAL_USER_IDList != null && P_VAL_USER_IDList.size() > 0) {
						getCOMP_UI_M_USER_DESC().setSubmittedValue(P_VAL_USER_IDList.get(0).toString());
						getCOMP_USER_GROUP_ID().setSubmittedValue(P_VAL_USER_IDList.get(1));
						PM_IL_APPR_SETUP_BEAN.setUSER_GROUP_ID((String)P_VAL_USER_IDList.get(1));
					} else {
						getCOMP_UI_M_USER_DESC().setSubmittedValue("");
						getCOMP_USER_GROUP_ID().setSubmittedValue("");
						throw new ValidatorException(new FacesMessage(ERRORMESSAGE));
					}
				}
				else{
					getCOMP_UI_M_USER_DESC().setSubmittedValue("");
					getCOMP_USER_GROUP_ID().setSubmittedValue("");
				}
			} catch (Exception e) {
				e.printStackTrace();
				//ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
			finally {
				try {
					ErrorHelpUtil.getWarningForProcedure(CommonUtils
							.getConnection(), "AS_USER_ID",
							getWarningMap());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	public void whenValidateItemAS_FM_PROD_CODE(ActionEvent event){
		//ErrorHelpUtil.validate(COMP_AS_FM_PROD_CODE, getErrorMap());
		PILM039_HELPER helper=new PILM039_HELPER();
		try {
			getWarningMap().clear();
			getErrorMap().clear();
			helper.validateAS_FM_PROD_CODE((String)COMP_AS_FM_PROD_CODE.getSubmittedValue());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("key", e.getMessage());
		}
	}
	
	public void validateAS_FM_PROD_CODE(FacesContext fc, UIComponent component,Object value){
		//Logic shifted to helper class
		/*
		UIInput inputText = (UIInput) component;
		PILM039_DELIGATE newDeligate = new PILM039_DELIGATE();
		PILM039_HELPER helper=new PILM039_HELPER();
		List<String> L_VAL_PRODList;
		if (inputText.getSubmittedValue() != null) {
			String PROD_CODE = (String) inputText.getSubmittedValue();
			L_VAL_PRODList =helper.L_VAL_PROD(PROD_CODE, CommonUtils.getConnection(), getErrorMap(), getWarningMap());
			if (L_VAL_PRODList != null && L_VAL_PRODList.size() > 0) {
				getCOMP_AS_FM_PROD_CODE_DESC().setSubmittedValue(L_VAL_PRODList.get(0).toString());
			} else {
				getCOMP_AS_FM_PROD_CODE_DESC().setSubmittedValue("");
				throw new ValidatorException(new FacesMessage("From product code not available"));
			}
		}
		else{
			getCOMP_AS_FM_PROD_CODE_DESC().setSubmittedValue("");
		}*/
		PILM039_HELPER helper=new PILM039_HELPER();
		try {
			helper.validateAS_FM_PROD_CODE((String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void whenValidateItemAS_TO_PROD_CODE(ActionEvent event){
	//	ErrorHelpUtil.validate(COMP_AS_TO_PROD_CODE, getErrorMap());
		PILM039_HELPER helper=new PILM039_HELPER();
		try {
			getWarningMap().clear();
			getErrorMap().clear();
			helper.validateAS_TO_PROD_CODE((String)COMP_AS_TO_PROD_CODE.getSubmittedValue());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("key", e.getMessage());
		}
	}
	
	public void validateAS_TO_PROD_CODE(FacesContext fc, UIComponent component,
			Object value) throws UserApprovalException{
		//Logic shifted to helper class
	/*	UIInput inputText = (UIInput) component;
		PILM039_DELIGATE newDeligate = new PILM039_DELIGATE();
		PILM039_HELPER helper=new PILM039_HELPER();
		List<String> L_VAL_PRODList;

		try {
			if (inputText.getSubmittedValue() != null) {
				String PROD_CODE = (String) inputText.getSubmittedValue();
				//String ERRORMESSAGE = newDeligate.P_VAL_USER_ID_Validation();
				L_VAL_PRODList = helper.L_VAL_PROD(PROD_CODE,CommonUtils.getConnection(),getErrorMap(),getWarningMap());
				if (L_VAL_PRODList != null && L_VAL_PRODList.size() > 0) {
					getCOMP_AS_TO_PROD_CODE_DESC().setSubmittedValue(L_VAL_PRODList.get(0).toString());
				} else {
					getCOMP_AS_TO_PROD_CODE_DESC().setSubmittedValue("");
					System.out.println("To product code not available");
					throw new ValidatorException(new FacesMessage("To product code not available"));
				}
			} else{
				getCOMP_AS_TO_PROD_CODE_DESC().setSubmittedValue("");
			}
		}catch (DBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		PILM039_HELPER helper=new PILM039_HELPER();
		try {
			helper.validateAS_TO_PROD_CODE((String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
			
	
	public void loadingBaseValues(PhaseEvent e) throws SQLException {
		FacesContext fc = FacesContext.getCurrentInstance();
		System.out.println("ENTERE PHASE EVENT");
		Map<String, Object> session = fc.getExternalContext().getSessionMap();
		if (session.get("PM_IL_CONTRACTOR_ACTION_FORM") == null) {
			try {
				System.out.println("BEFORE PHASE EVENT");
				preForm();
				System.out.println("AFTER PHASE EVENT");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session.put("PM_IL_APPR_SETUP_COMPOSITE_ACTION", "true");
		}
	}
	
	public String preForm() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		//session.setAttribute("GLOBAL.M_PRIVILEGE", "YYY");
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
		//session.setAttribute("GLOBAL.M_USER_ID", "PREMIA");
		//session.setAttribute("GLOBAL.M_NAME","COMPANY NAME..................PROGRAM NAME");
	//	session.setAttribute("GLOBAL.M_LANG_CODE", "ENG");
	//	session.setAttribute("GLOBAL.M_PARA_1", " ");
	//	session.setAttribute("GLOBAL.M_FOR_LANG_CODE", "ARBR2");
	//	session.setAttribute("GLOBAL.M_MODULE_NAME", "PILM039");
	//	session.setAttribute("GLOBAL.M_DFLT_VALUES", "00101    01    ");

		return null;
	}
	
	
	
	/*
	 * New Action
	 * */
	

	public void CHECK_DUPLICATE_VALUE(ActionEvent event)
	{
		System.out.println("PM_IL_APPR_SETUP_ACTION.CHECK_DUPLICATE_VALUE()-------------------->>>>>>>");
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		PILM039_HELPER helper=new PILM039_HELPER();
		getErrorMap().clear();
		getWarningMap().clear();
		String userId =(String) getCOMP_AS_USER_ID().getSubmittedValue();
		String fromCode =(String) getCOMP_AS_FM_PROD_CODE().getSubmittedValue();
		String toCode =(String) getCOMP_AS_TO_PROD_CODE().getSubmittedValue();
		String rowId=PM_IL_APPR_SETUP_BEAN.getROWID();
		try {
			if(fromCode != null && toCode != null && userId != null){
				
				helper.CHECK_DUPLICATE(userId, fromCode, toCode ,rowId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("somekey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
    }
	
	
	public void saveButtonAction(ActionEvent event){
		getErrorMap().clear();
		getWarningMap().clear();
		PRE_INSERT();
		try {
			//to check if method is called on save button click or tabbed bar click
			//1. on click of save button jsf will call method and action event parameter
			//	is passed .
			//2. on tabbed bar click method is invoked explicitly and with null
			//	action event
			if(event != null){
				new CommonUtils().doComitt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("saveError", e.getMessage());
		}
	}
	
	public void PRE_INSERT() {
		
		
		
		PILM039_HELPER helper = new PILM039_HELPER();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeACtion = null;
		PM_IL_APPR_SETUP valueBean = null;
		PILM039_DELIGATE deligate =new PILM039_DELIGATE();
		CommonUtils commonUtils =new CommonUtils();
		compositeACtion = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		valueBean = compositeACtion.getPM_IL_APPR_SETUP_ACTION_BEAN().getPM_IL_APPR_SETUP_BEAN();
		String rowId=null;
		String userId = valueBean.getAS_USER_ID();
		String fromprodCode = valueBean.getAS_FM_PROD_CODE();
		String toProdCode = valueBean.getAS_TO_PROD_CODE();
		try {
			getWarningMap().clear();
			getErrorMap().clear();
			validateFormPM_IL_APPR_SET_UP();
			rowId = valueBean.getROWID();
			helper.CHECK_DUPLICATE(userId, fromprodCode, toProdCode,rowId);

			//CommonUtils.objectSysout(valueBean);
			//helper.hePILM039_detail_pre_insert(detailBean,userId,fromprodCode,toProdCode);
			//rowCount = deligate.updateDetailBean(detailBean);
			if (rowId == null) {
				helper.hePILM039_pre_insert(valueBean);
				//Duplicate check is not required. The PRE_INSERT procedure call has to be made 
				//without checking for duplicates in the details block.
				//This is as per code written in pre insert trigger of FMB
				//deligate.checkInsert(valueBean);
			}else{
				deligate.pilm039_pm_il_appr_setup_pre_update(valueBean);
			}
			
			deligate.updatePILM039Setup(valueBean);
			if (rowId == null) {
				String message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
				getWarningMap().put("somekey", message);
				getWarningMap().put("current", message);
			}else{
				String message = Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update");
				getWarningMap().put("somekey", message);
				getWarningMap().put("current", message);
			}
			setNonUpdatable(true);
			
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("somekey", e.getMessage());
			getErrorMap().put("value", e.getMessage());
		}

	}
	
	/**
	 * 
	 * USER ID LOV 
	 */
	
	public List userIdSuggestion(Object userLOVObject) throws SQLException, UserApprovalException{
		List list = new ArrayList();
		PILM039_DELIGATE delgate =new PILM039_DELIGATE();
		String value = userLOVObject.toString();
		
		String query = null ;
		if(value.equalsIgnoreCase("*")){
			query = PILM039_QUERY_CONSTANT.PILM039_LOV_USERID_SUGGESTION;
			Object[] values={};
			list = delgate.userIdList(query,values);
		}else{
			query =PILM039_QUERY_CONSTANT.PILM039_LOV_USERID_SUGGESTION_LIKE;
			Object[] values={value+"%",value+"%"};
			list = delgate.userIdList(query,values);
		}
		
		return list;
	}
	public void userAutoPopulate(ActionEvent ae) throws Exception{
		PILM039_DELIGATE newDeligate = new PILM039_DELIGATE();

		if (getCOMP_AS_USER_ID().getSubmittedValue() != null) {
			String USER_ID = (String) getCOMP_AS_USER_ID().getSubmittedValue();
			List list = (ArrayList) newDeligate.P_VAL_USER_ID(USER_ID);
			String ERRORMESSAGE = newDeligate.P_VAL_USER_ID_Validation();
			if (list != null && list.size() > 0) {
				getCOMP_UI_M_USER_DESC().setSubmittedValue(list.get(0).toString());
				getCOMP_USER_GROUP_ID().setSubmittedValue(list.get(1));
			} else {
				getCOMP_UI_M_USER_DESC().setSubmittedValue("");
				getCOMP_USER_GROUP_ID().setSubmittedValue("");
				throw new ValidatorException(new FacesMessage(ERRORMESSAGE));
			}
		}
		else{
			getCOMP_UI_M_USER_DESC().setSubmittedValue("");
			getCOMP_USER_GROUP_ID().setSubmittedValue("");
		}
	}
	
	
	public List productCodeSuggestion(Object userLOVObject) throws SQLException, UserApprovalException{
		List list = new ArrayList();
		PILM039_DELIGATE delgate =new PILM039_DELIGATE();
		String value = userLOVObject.toString();
		
		String query = null ;
		if(value.equalsIgnoreCase("*")){
			query = PILM039_QUERY_CONSTANT.PILM039_LOV_PRODUCTCODE;
			Object[] values={};
			list = delgate.fromProductCodeList(query,values);
		}else{
			query =PILM039_QUERY_CONSTANT.PILM039_LOV_PRODUCTCODE_LIKE;
			Object[] values={value+"%",value+"%"};
			list = delgate.fromProductCodeList(query,values);
		}
		return list;
	}
	public void fromProdCodeAutoPopulate(ActionEvent ae) throws UserApprovalException{
		PILM039_DELIGATE newDeligate = new PILM039_DELIGATE();
		PILM039_HELPER helper=new PILM039_HELPER();

		try {
			if (getCOMP_AS_FM_PROD_CODE().getSubmittedValue() != null) {
				String fromProdCode = (String) getCOMP_AS_FM_PROD_CODE().getSubmittedValue();
				List list;
				list = (ArrayList) helper.L_VAL_PROD(fromProdCode,CommonUtils.getConnection(),getErrorMap(),getWarningMap());
				if (list != null && list.size() > 0) {
					PM_IL_APPR_SETUP_BEAN.setAS_FM_PROD_CODE(fromProdCode);
					COMP_AS_FM_PROD_CODE.resetValue();
					PM_IL_APPR_SETUP_BEAN.setAS_FM_PROD_CODE_DESC((String)list.get(0));
					COMP_AS_FM_PROD_CODE_DESC.resetValue();
				} /*else {
					getCOMP_AS_FM_PROD_CODE_DESC().setSubmittedValue("");
					throw new ValidatorException(new FacesMessage("From product code not available"));
				}*/
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public List productCodeToSuggestion(Object userLOVObject) throws SQLException, UserApprovalException{
		List list = new ArrayList();
		PILM039_DELIGATE delgate =new PILM039_DELIGATE();
		String value = userLOVObject.toString();
		
		String query = null ;
		if(value.equalsIgnoreCase("*")){
			query = PILM039_QUERY_CONSTANT.PILM039_LOV_PRODUCTCODE;
			System.out.println(query);
			Object[] values={};
			list = delgate.toProductCodeList(query,values);
		}else{
			query =PILM039_QUERY_CONSTANT.PILM039_LOV_PRODUCTCODE_LIKE;
			System.out.println(query);
			Object[] values={value+"%",value+"%"};
			list = delgate.toProductCodeList(query,values);
		}
		return list;
	}
	public void toProdCodeAutoPopulate(ActionEvent ae) throws UserApprovalException{
		PILM039_DELIGATE newDeligate = new PILM039_DELIGATE();
		PILM039_HELPER helper=new PILM039_HELPER();

		try {
			if (getCOMP_AS_TO_PROD_CODE().getSubmittedValue() != null) {
				String toProdCode = (String) getCOMP_AS_TO_PROD_CODE().getSubmittedValue();
				List<String> list = helper.L_VAL_PROD(toProdCode,CommonUtils.getConnection(),getErrorMap(),getWarningMap());
				if (list != null && list.size() > 0) {
					PM_IL_APPR_SETUP_BEAN.setAS_TO_PROD_CODE(toProdCode);
					COMP_AS_TO_PROD_CODE.resetValue();
					PM_IL_APPR_SETUP_BEAN.setAS_TO_PROD_CODE_DESC((String)list.get(0));
					COMP_AS_TO_PROD_CODE_DESC.resetValue();
				} /*else {
					getCOMP_AS_TO_PROD_CODE_DESC().setSubmittedValue("");
					throw new ValidatorException(new FacesMessage("From product code not available"));
				}*/
			}
			/*else{
				getCOMP_AS_TO_PROD_CODE_DESC().setSubmittedValue("");
			}*/
		} catch (DBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public void validateFormPM_IL_APPR_SET_UP() throws Exception{
		PILM039_HELPER helper=new PILM039_HELPER();
		try {
			getErrorMap().clear();
			helper.validateAS_FM_PROD_CODE(PM_IL_APPR_SETUP_BEAN.getAS_FM_PROD_CODE());
			helper.validateAS_TO_PROD_CODE(PM_IL_APPR_SETUP_BEAN.getAS_TO_PROD_CODE());
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("val", e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
	public String copyButtonAction() {
		System.out.println("gone...");
		PILM039_HELPER helper = new PILM039_HELPER();
		
		helper.pilm039_pm_il_appr_setup_m_but_copy_when_button_pressed(this);
		
		return "goToCTRL_1";
	}

	public CTRL_1_ACTION getCTRL_1_ACTION_BEAN() {
		return CTRL_1_ACTION_BEAN;
	}

	public void setCTRL_1_ACTION_BEAN(CTRL_1_ACTION ctrl_1_action_bean) {
		CTRL_1_ACTION_BEAN = ctrl_1_action_bean;
	}

	public boolean isNonUpdatable() {
		return nonUpdatable;
	}

	public void setNonUpdatable(boolean nonUpdatable) {
		this.nonUpdatable = nonUpdatable;
	}

	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				deligate.fetchUpprovalDetailValues(compositeAction);
				setBlockFlag(false);
			}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
}
