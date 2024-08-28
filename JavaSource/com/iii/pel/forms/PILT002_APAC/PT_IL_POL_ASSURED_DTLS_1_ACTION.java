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
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTab;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.PILPK_PILT002;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_ASSURED_DTLS_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POAD_ASSR_CODE_LABEL;

	private HtmlInputText COMP_POAD_ASSR_CODE;

	private HtmlOutputLabel COMP_POAD_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_POAD_ASSURED_NAME;

	private HtmlCommandButton COMP_UI_M_BUT_FLEX_FIELDS1;
	
	private HtmlCommandButton COMP_ADDL_COVER_DTLS1;  
	
	private HtmlOutputLabel COMP_POAD_FC_SALARY_LABEL;

	private HtmlInputText COMP_POAD_FC_SALARY;

	private HtmlOutputLabel COMP_POAD_REF_ID1_LABEL;

	private HtmlInputText COMP_POAD_REF_ID1;

	private HtmlOutputLabel COMP_POAD_REF_ID2_LABEL;

	private HtmlInputText COMP_POAD_REF_ID2;

	private HtmlCommandButton M_BUT_FLEX_FIELDS;

	private HtmlOutputLabel COMP_POAD_LC_SALARY_LABEL;

	private HtmlInputText COMP_POAD_LC_SALARY;

	private HtmlOutputLabel COMP_POAD_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_POAD_TYPE;

	private HtmlOutputLabel COMP_POAD_CATG_CODE_LABEL;

	private HtmlInputText COMP_POAD_CATG_CODE;

	private HtmlOutputLabel COMP_UI_M_POAD_CATG_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_CATG_DESC;

	private HtmlOutputLabel COMP_POAD_NATURE_OF_WORK_LABEL;

	private HtmlInputTextarea COMP_POAD_NATURE_OF_WORK;

	private HtmlOutputLabel COMP_POAD_DOB_LABEL;

	private HtmlCalendar COMP_POAD_DOB;

	private HtmlOutputLabel COMP_POAD_HEIGHT_LABEL;

	private HtmlInputText COMP_POAD_HEIGHT;

	private HtmlOutputLabel COMP_POAD_HEIGHT_UNIT_LABEL;

	private HtmlSelectOneMenu COMP_POAD_HEIGHT_UNIT;

	private HtmlOutputLabel COMP_POAD_BIRTH_PLACE_LABEL;

	private HtmlInputTextarea COMP_POAD_BIRTH_PLACE;

	private HtmlOutputLabel COMP_POAD_AGE_LABEL;

	private HtmlInputText COMP_POAD_AGE;

	private HtmlOutputLabel COMP_POAD_WEIGHT_LABEL;

	private HtmlInputText COMP_POAD_WEIGHT;

	private HtmlOutputLabel COMP_POAD_WEIGHT_UNIT_LABEL;

	private HtmlSelectOneMenu COMP_POAD_WEIGHT_UNIT;

	private HtmlOutputLabel COMP_POAD_RACE_LABEL;

	private HtmlInputText COMP_POAD_RACE;

	private HtmlOutputLabel COMP_UI_M_POAD_RACE_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_RACE_CODE_DESC;

	private HtmlOutputLabel COMP_POAD_ADDL_RISK_CODE_LABEL;

	private HtmlInputText COMP_POAD_ADDL_RISK_CODE;

	private HtmlOutputLabel COMP_UI_M_ADDL_RISK_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ADDL_RISK_DESC;

	private HtmlOutputLabel COMP_POAD_BMI_LABEL;

	private HtmlInputText COMP_POAD_BMI;

	private HtmlOutputLabel COMP_POAD_AGE_PROOF_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_POAD_AGE_PROOF_FLAG;

	private HtmlOutputLabel COMP_POAD_AGE_PROOF_OTHERS_LABEL;

	private HtmlInputText COMP_POAD_AGE_PROOF_OTHERS;

	private HtmlOutputLabel COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL;

	private HtmlInputText COMP_UI_M_POAD_LC_THRESOLD_LMT;

	private HtmlOutputLabel COMP_POAD_DISC_AGE_LABEL;

	private HtmlInputText COMP_POAD_DISC_AGE;

	private HtmlOutputLabel COMP_POAD_SMOKE_YN_LABEL;

	private HtmlSelectOneMenu COMP_POAD_SMOKE_YN;

	private HtmlOutputLabel COMP_POAD_NO_OF_CIGAR_LABEL;

	private HtmlInputText COMP_POAD_NO_OF_CIGAR;

	private HtmlOutputLabel COMP_POAD_LC_THRESHOLD_LMT_LABEL;

	private HtmlInputText COMP_POAD_LC_THRESHOLD_LMT;

	private HtmlOutputLabel COMP_POAD_NATIONALITY_LABEL;

	private HtmlInputText COMP_POAD_NATIONALITY;

	private HtmlOutputLabel COMP_UI_M_POAD_NATLITY_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_NATLITY_DESC;

	private HtmlOutputLabel COMP_POAD_REMARKS_LABEL;

	private HtmlInputText COMP_POAD_REMARKS;

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

	private HtmlCommandButton UI_M_BUT_FLEX_FIELDS1;

	private String DEFAULT_WHERE;
	
	//Added by Kavitha For POC point DPLI59
	private HtmlOutputLabel  COMP_POAD_POL_OWNER_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_POAD_POL_OWNER_YN;
	
	//Added by Akash for POC point DPLI...
	
	private HtmlOutputLabel COMP_POAD_RELATION_CODE_LABEL;
	
	private HtmlInputText COMP_POAD_RELATION_CODE;
	
	private HtmlInputText COMP_UI_M_POAD_RELATION_DESC;
	
	private HtmlTab COMP_MORE_INFO_1;
	//Added by Akash for POC point DPLI...
	
	private HtmlCommandButton COMP_PT_IL_POL_APPL_PROD;

	private  PT_IL_POL_ASSURED_DTLS_1  PT_IL_POL_ASSURED_DTLS_1_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_ASSURED_DTLS_1_HELPER helper;

	private List<SelectItem> listPOAD_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAD_HEIGHT_UNIT = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAD_WEIGHT_UNIT = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAD_AGE_PROOF_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPOAD_SMOKE_YN = new ArrayList<SelectItem>();
	//Added by Kavitha For POC point DPLI59
	private List<SelectItem> listPOAD_POL_OWNER_YN = new ArrayList<SelectItem>();


	public PT_IL_POL_ASSURED_DTLS_1_ACTION() {

		 PT_IL_POL_ASSURED_DTLS_1_BEAN = new PT_IL_POL_ASSURED_DTLS_1();
		helper = new PT_IL_POL_ASSURED_DTLS_1_HELPER();
		
		instantiateAllComponent();
		setlistValues();
		COMP_POAD_FC_SUM_ASSURED = new HtmlInputText();
		COMP_POAD_LC_SUM_ASSURED = new HtmlInputText();
	}

	
	 public void setlistValues(){
			
		 try {
			setListPOAD_AGE_PROOF_FLAG(ListItemUtil.getDropDownListValue(
					    CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POL_ASSURED_DTLS_1",
					    "PT_IL_POL_ASSURED_DTLS_1.POAD_AGE_PROOF_FLAG", "IL_AGE_PROOF"));
			setListPOAD_HEIGHT_UNIT(ListItemUtil.getDropDownListValue(
				    CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POL_ASSURED_DTLS_1",
				    "PT_IL_POL_ASSURED_DTLS_1.POAD_HEIGHT_UNIT", "IL_HEIGHT_UT"));
			setListPOAD_SMOKE_YN(ListItemUtil.getDropDownListValue(
				    CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POL_ASSURED_DTLS_1",
				    "PT_IL_POL_ASSURED_DTLS_1.POAD_SMOKE_YN", "YESNO"));
			setListPOAD_TYPE(ListItemUtil.getDropDownListValue(
				    CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POL_ASSURED_DTLS_1",
				    "PT_IL_POL_ASSURED_DTLS_1.POAD_TYPE", "IL_ASSR_TYP"));
			setListPOAD_WEIGHT_UNIT(ListItemUtil.getDropDownListValue(
				    CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POL_ASSURED_DTLS_1",
				    "PT_IL_POL_ASSURED_DTLS_1.POAD_WEIGHT_UNIT", "IL_WEIGHT_UT"));
			setListPOAD_POL_OWNER_YN(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT002_APAC", "PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_POL_OWNER_YN", "YESNO"));
			/*Added by Saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
			setListPOAD_HIV_TEST_YN(ListItemUtil.getDropDownListValue(
					    CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POL_ASSURED_DTLS",
					    "PT_IL_POL_ASSURED_DTLS.POAD_HIV_TEST_YN", "YESNO"));
			/*End*/
		 } catch (DBException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	 }
	public HtmlOutputLabel getCOMP_POAD_HEIGHT_UNIT_LABEL() {
		return COMP_POAD_HEIGHT_UNIT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_POAD_HEIGHT_UNIT() {
		return COMP_POAD_HEIGHT_UNIT;
	}

	public void setCOMP_POAD_HEIGHT_UNIT_LABEL(
			HtmlOutputLabel COMP_POAD_HEIGHT_UNIT_LABEL) {
		this.COMP_POAD_HEIGHT_UNIT_LABEL = COMP_POAD_HEIGHT_UNIT_LABEL;
	}

	public void setCOMP_POAD_HEIGHT_UNIT(HtmlSelectOneMenu COMP_POAD_HEIGHT_UNIT) {
		this.COMP_POAD_HEIGHT_UNIT = COMP_POAD_HEIGHT_UNIT;
	}

	public HtmlOutputLabel getCOMP_POAD_DISC_AGE_LABEL() {
		return COMP_POAD_DISC_AGE_LABEL;
	}

	public HtmlInputText getCOMP_POAD_DISC_AGE() {
		return COMP_POAD_DISC_AGE;
	}

	public void setCOMP_POAD_DISC_AGE_LABEL(
			HtmlOutputLabel COMP_POAD_DISC_AGE_LABEL) {
		this.COMP_POAD_DISC_AGE_LABEL = COMP_POAD_DISC_AGE_LABEL;
	}

	public void setCOMP_POAD_DISC_AGE(HtmlInputText COMP_POAD_DISC_AGE) {
		this.COMP_POAD_DISC_AGE = COMP_POAD_DISC_AGE;
	}

	public HtmlOutputLabel getCOMP_POAD_FC_AMAN_PREM_LABEL() {
		return COMP_POAD_FC_AMAN_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POAD_FC_AMAN_PREM() {
		return COMP_POAD_FC_AMAN_PREM;
	}

	public void setCOMP_POAD_FC_AMAN_PREM_LABEL(
			HtmlOutputLabel COMP_POAD_FC_AMAN_PREM_LABEL) {
		this.COMP_POAD_FC_AMAN_PREM_LABEL = COMP_POAD_FC_AMAN_PREM_LABEL;
	}

	public void setCOMP_POAD_FC_AMAN_PREM(HtmlInputText COMP_POAD_FC_AMAN_PREM) {
		this.COMP_POAD_FC_AMAN_PREM = COMP_POAD_FC_AMAN_PREM;
	}

	public void saveRecord() {

		String message = null;
		String msg1 = null;
		try {
			if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.preInset(PT_IL_POL_ASSURED_DTLS_1_BEAN, compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				new CRUDHandler().executeInsert(PT_IL_POL_ASSURED_DTLS_1_BEAN, CommonUtils.getConnection());
				msg1 = helper.postInsert(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(), 
						PT_IL_POL_ASSURED_DTLS_1_BEAN);
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			} else if(PT_IL_POL_ASSURED_DTLS_1_BEAN.getROWID() != null && isUPDATE_ALLOWED()){
				helper.preUpdate(PT_IL_POL_ASSURED_DTLS_1_BEAN,  compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_ASSURED_DTLS_1_BEAN, CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
			}
			if(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE_PROOF_FLAG().equalsIgnoreCase("0")){
				if(("".equalsIgnoreCase(PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE_PROOF_OTHERS())|| PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_AGE_PROOF_OTHERS() == null)){
					throw new ValidatorException(new FacesMessage("Others Age proof:Validation Error: Value is required."));
				}
			}
			
			/*Added by Janani for Fidelity joint life issue as suggested by Ajay on 25.04.2018*/

			System.out.println("getPOL_JOINT_LIFE_YN                "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_JOINT_LIFE_YN());

			ArrayList<OracleParameter> pValList2 = new ArrayList<OracleParameter>();

			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
					getPT_IL_POLICY_BEAN().getPOL_JOINT_LIFE_YN().equalsIgnoreCase("y"))
			{
				pValList2 = new PILPK_PILT002().PR_PREM_CAL_JL_AGE(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
						getPT_IL_POLICY_BEAN()
						.getPOL_SYS_ID(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().
						getPT_IL_POLICY_BEAN()
						.getPOL_PLAN_CODE(),compositeAction.getPT_IL_POLICY_ACTION_BEAN().
						getPT_IL_POLICY_BEAN().
						getPOL_START_DT(),null);

				if (pValList2 != null && pValList2.size() > 0) {
					if (pValList2.get(0) != null) {
												
						/*compositeAction.getPT_IL_POLICY_ACTION_BEAN().
						getPT_IL_POLICY_BEAN().setPOL_JOINT_LIFE_AGE((Integer)pValList2.get(0).getValueObject());*/
					}


					System.out.println("getPOL_JOINT_LIFE_AGE                "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().
							getPT_IL_POLICY_BEAN().getPOL_JOINT_LIFE_AGE());
				}
			}
			/*End*/
			
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("SAVE_RECORD", message);
			getWarningMap().put("Warning", msg1);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
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

	public void setListPOAD_TYPE(List<SelectItem> listPOAD_TYPE) {
		this.listPOAD_TYPE = listPOAD_TYPE;
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

	
	public void delete() {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				helper.preDelete(PT_IL_POL_ASSURED_DTLS_1_BEAN);
				new CRUDHandler().executeDelete(PT_IL_POL_ASSURED_DTLS_1_BEAN,
						CommonUtils.getConnection());

				CommonUtils.getConnection().commit();
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete");
				getWarningMap().put("deleteRow", message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
			
				PT_IL_POL_ASSURED_DTLS_1_BEAN = new PT_IL_POL_ASSURED_DTLS_1();
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
				helper.whenNewBlockInstance(compositeAction);
				helper.preQuery(this);
				if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getROWID() != null) {
					helper.executeQuery(compositeAction);
					helper.onPopulateDetails(compositeAction);
					helper.postQuery(compositeAction,PT_IL_POL_ASSURED_DTLS_1_BEAN,
							compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				}else{
					helper.whenCreateRecord(this, compositeAction
							.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),compositeAction);
				}				
				helper.whenNewRecordInstance(compositeAction);
				//COMP_UI_M_POAD_LC_THRESOLD_LMT.resetValue();
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_JOINT_LIFE_YN().equalsIgnoreCase("Y"))
				{
					COMP_POAD_HEIGHT.setRequired(false);
					COMP_POAD_WEIGHT.setRequired(false);
					COMP_POAD_BMI.setRequired(true);
				}
				
				setBlockFlag(false);
				
				/*Added by Janani on 04.06.2018 for Fidelity payee DOB disabled after passing CDOB endorsement*/
				
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null && CommonUtils.isIN(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_END_CODE(),"CDOB") && compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("n"))
				{
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getCOMP_POAD_DOB().setDisabled(false); 
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getCOMP_POAD_DOB().resetValue();
					setUPDATE_ALLOWED(true);
				}
				/*END*/
				
				
			}
			compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_TYPE("E");
			COMP_POAD_TYPE.setDisabled(true);
			changesFor001End();
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	private void changesFor001End(){
		if (null != compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_END_TYPE()) {
			if ("001".equals(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_END_TYPE())
					&& "N".equalsIgnoreCase(compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG())) {
				getCOMP_POAD_ASSURED_NAME().setDisabled(false);
			} else {
				getCOMP_POAD_ASSURED_NAME().setDisabled(true);
			}
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

	public HtmlOutputLabel getCOMP_POAD_NATURE_OF_WORK_LABEL() {
		return COMP_POAD_NATURE_OF_WORK_LABEL;
	}

	public void setCOMP_POAD_NATURE_OF_WORK_LABEL(
			HtmlOutputLabel comp_poad_nature_of_work_label) {
		COMP_POAD_NATURE_OF_WORK_LABEL = comp_poad_nature_of_work_label;
	}

	public HtmlInputTextarea getCOMP_POAD_NATURE_OF_WORK() {
		return COMP_POAD_NATURE_OF_WORK;
	}

	public void setCOMP_POAD_NATURE_OF_WORK(
			HtmlInputTextarea comp_poad_nature_of_work) {
		COMP_POAD_NATURE_OF_WORK = comp_poad_nature_of_work;
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

	public HtmlOutputLabel getCOMP_POAD_BIRTH_PLACE_LABEL() {
		return COMP_POAD_BIRTH_PLACE_LABEL;
	}

	public void setCOMP_POAD_BIRTH_PLACE_LABEL(
			HtmlOutputLabel comp_poad_birth_place_label) {
		COMP_POAD_BIRTH_PLACE_LABEL = comp_poad_birth_place_label;
	}

	public HtmlInputTextarea getCOMP_POAD_BIRTH_PLACE() {
		return COMP_POAD_BIRTH_PLACE;
	}

	public void setCOMP_POAD_BIRTH_PLACE(HtmlInputTextarea comp_poad_birth_place) {
		COMP_POAD_BIRTH_PLACE = comp_poad_birth_place;
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

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_ASSURED_DTLS_1_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_ASSURED_DTLS_1_HELPER helper) {
		this.helper = helper;
	}

	public HtmlCommandButton getUI_M_BUT_FLEX_FIELDS1() {
		return UI_M_BUT_FLEX_FIELDS1;
	}

	public void setUI_M_BUT_FLEX_FIELDS1(HtmlCommandButton ui_m_but_flex_fields1) {
		UI_M_BUT_FLEX_FIELDS1 = ui_m_but_flex_fields1;
	}

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}

	public void POAD_ASSR_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
		   PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_ASSR_CODE((String) value);
		 
			helper.POAD_ASSR_CODE_WHEN_VALIDATE_ITEM(compositeAction);
			helper.POAD_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,this);
			COMP_POAD_REF_ID1.resetValue();
			COMP_POAD_REF_ID2.resetValue();
			COMP_POAD_DOB.resetValue();
			COMP_POAD_CATG_CODE.resetValue();
			COMP_UI_M_POAD_CATG_DESC.resetValue();
			
			/*Added by Janani on 02.05.2018 for Fidelity as suggested by Vinoth*/
			COMP_POAD_OCC_CODE.resetValue();
			COMP_UI_M_POAD_OCC_DESC.resetValue();
			COMP_POAD_NATIONALITY.resetValue();
			COMP_UI_M_POAD_NATLITY_DESC.resetValue();
			COMP_POAD_AGE_PROOF_FLAG.resetValue();
			/*eND*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_REF_ID1_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_REF_ID1((String) value);

			helper.POAD_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,this);
			COMP_POAD_DOB.resetValue();
			COMP_POAD_CATG_CODE.resetValue();
			COMP_UI_M_POAD_CATG_DESC.resetValue();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void UI_M_POAD_LC_THRESOLD_LMT_VALIDATOR(FacesContext context,
			UIComponent component, Object value)  {

		try {
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void POAD_POL_OWNER_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			String val = (String)value;
			
				PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_POL_OWNER_YN(val);
					helper.POAD_POL_OWNER_YN_WHEN_VALIDATE_ITEM(compositeAction);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_CATG_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			
			/*Added by Janani on 20.04.2018 for FLA joint life issue*/
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_CATG_CODE((String) value);
			
 		/*End*/
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_CATG_DESC(
					helper.POAD_CATG_CODE_WHEN_VALIDATE_ITEM((String) value));
			helper.POAD_CATG_CODE_WHEN_VALIDATE_ITEM(getPT_IL_POL_ASSURED_DTLS_1_BEAN());
			COMP_UI_M_POAD_CATG_DESC.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_DOB_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		Date POAD_DOB = (Date) value;
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_DOB(POAD_DOB);
		try {
			helper.POAD_DOB_WHEN_VALIDATE_ITEM(POAD_DOB, this, compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
							.getDUMMY_BEAN());
			COMP_POAD_AGE.resetValue();
			COMP_POAD_DISC_AGE.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_HEIGHT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		Double POAD_HEIGHT = (Double) value;
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEIGHT(POAD_HEIGHT);
		try {
			helper.POAD_HEIGHT_WHEN_VALIDATE_ITEM(POAD_HEIGHT,
					PT_IL_POL_ASSURED_DTLS_1_BEAN, compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void POAD_RACE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_RACE = (String) value;
		try {
			getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_RACE(POAD_RACE);
			helper.POAD_RACE_VALIDATE_ITEM(POAD_RACE,
					getPT_IL_POL_ASSURED_DTLS_1_BEAN());
			COMP_UI_M_POAD_RACE_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_HEIGHT_UNIT_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value)  {
		compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		String POAD_HEIGHT_UNIT = (String) value;
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEIGHT_UNIT(
				POAD_HEIGHT_UNIT);
		try {
			helper.POAD_HEIGHT_UNIT_WHEN_LIST_CHANGED(POAD_HEIGHT_UNIT,
					PT_IL_POL_ASSURED_DTLS_1_BEAN, compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_AGE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		
		Integer POAD_AGE = (Integer) value;
		try {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE(POAD_AGE);
			helper.POAD_AGE_WHEN_VALIDATE_ITEM(POAD_AGE,
					PT_IL_POL_ASSURED_DTLS_1_BEAN, compositeAction
							.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_WEIGHT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		
		Double POAD_WEIGHT = (Double) value;
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_WEIGHT(POAD_WEIGHT);
		try {
			helper.POAD_WEIGHT_WHEN_VALIDATE_ITEM(POAD_WEIGHT,
					PT_IL_POL_ASSURED_DTLS_1_BEAN, compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_WEIGHT_UNIT_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value)  {
		
		String POAD_WEIGHT_UNIT = (String) value;
		try {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_WEIGHT_UNIT(POAD_WEIGHT_UNIT);
			helper.POAD_WEIGHT_UNIT_WHEN_LIST_CHANGED(POAD_WEIGHT_UNIT,
					PT_IL_POL_ASSURED_DTLS_1_BEAN, compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_POAD_BMI.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_AGE_PROOF_FLAG = (String) value;
		try {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE_PROOF_FLAG(POAD_AGE_PROOF_FLAG);
			helper.POAD_AGE_PROOF_FLAG_WHEN_LIST_CHANGED(POAD_AGE_PROOF_FLAG,
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN());
			COMP_POAD_AGE_PROOF_OTHERS.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void POAD_AGE_PROOF_OTHERS_VALIDATOR(FacesContext context,
			UIComponent component, Object value) throws Exception{
		
		String val = (String) value;
		try {
		COMP_POAD_AGE_PROOF_OTHERS.setValue((String)val);
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_AGE_PROOF_OTHERS(val);
		//COMP_POAD_AGE_PROOF_OTHERS.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_SMOKE_YN_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_SMOKE_YN = (String) value;
		try {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_SMOKE_YN(POAD_SMOKE_YN);
			helper.POAD_SMOKE_YN_WHEN_LIST_CHANGED(POAD_SMOKE_YN,
					compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN());
			COMP_POAD_NO_OF_CIGAR.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_NATIONALITY_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_NATIONALITY = (String) value;
		try {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_NATIONALITY(POAD_NATIONALITY);
			helper.POAD_NATIONALITY_WHEN_VALIDATE_ITEM(POAD_NATIONALITY,
					PT_IL_POL_ASSURED_DTLS_1_BEAN);
			COMP_UI_M_POAD_NATLITY_DESC.resetValue();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_MAR_STATUS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_MAR_STATUS = (String) value;
		try {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_MAR_STATUS(POAD_MAR_STATUS);
			helper.POAD_MAR_STATUS_WHEN_VALIDATE_ITEM(POAD_MAR_STATUS,PT_IL_POL_ASSURED_DTLS_1_BEAN);
			COMP_UI_M_POAD_MS_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_OCC_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_OCC_CODE = (String) value;
		try {

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_OCC_CODE(POAD_OCC_CODE);
			helper.POAD_OCC_CODE_WHEN_VALIDATE_ITEM(POAD_OCC_CODE,PT_IL_POL_ASSURED_DTLS_1_BEAN);
			COMP_UI_M_POAD_OCC_DESC.resetValue();
			COMP_POAD_OCC_CLASS.resetValue();
			COMP_UI_M_POAD_OCC_CLASS_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_OCC_CLASS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_OCC_CLASS = (String) value;
		try {

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_OCC_CLASS(POAD_OCC_CLASS);
			helper.POAD_OCC_CLASS_WHEN_VALIDATE_ITEM(POAD_OCC_CLASS,
					PT_IL_POL_ASSURED_DTLS_1_BEAN);
			COMP_UI_M_POAD_OCC_CLASS_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_RELIGION_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_RELIGION_CODE = (String) value;
		try {

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_RELIGION_CODE(
					POAD_RELIGION_CODE);
			helper.POAD_RELIGION_CODE_VALIDATE_ITEM(POAD_RELIGION_CODE,
					PT_IL_POL_ASSURED_DTLS_1_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_OCC_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_OCC_RATE = (Double) value;
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_OCC_RATE(POAD_OCC_RATE);
		try {

			helper.POAD_OCC_RATE_VALIDATE_ITEM(POAD_OCC_RATE,
					PT_IL_POL_ASSURED_DTLS_1_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_HEALTH_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_HEALTH_CODE = (String) value;
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_HEALTH_CODE(
				POAD_HEALTH_CODE);
		try {

			helper.POAD_HEALTH_CODE_VALIDATE_ITEM(POAD_HEALTH_CODE,
					PT_IL_POL_ASSURED_DTLS_1_BEAN);
			COMP_UI_M_POAD_HEALTH_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void POAD_ADDL_RISK_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		String POAD_ADDL_RISK_CODE = (String) value;
		PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_ADDL_RISK_CODE(
				POAD_ADDL_RISK_CODE);
		try {

			helper.POAD_ADDL_RISK_CODE_VALIDATE_ITEM(POAD_ADDL_RISK_CODE,
					PT_IL_POL_ASSURED_DTLS_1_BEAN);
			COMP_UI_M_ADDL_RISK_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void POAD_FC_SALARY_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_FC_SALARY = (Double) value;
		try {
		   
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_SALARY(POAD_FC_SALARY);
			POAD_FC_SALARY = helper.POAD_FC_SALARY_VALIDATE_ITEM(
					POAD_FC_SALARY, PT_IL_POL_ASSURED_DTLS_1_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_POAD_LC_SALARY.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_LC_SALARY_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_LC_SALARY = (Double) value;
		PT_IL_POL_ASSURED_DTLS_1_BEAN
		.setPOAD_LC_SALARY(POAD_LC_SALARY);
		try {

			POAD_LC_SALARY = helper.POAD_LC_SALARY_VALIDATE_ITEM(
					POAD_LC_SALARY, PT_IL_POL_ASSURED_DTLS_1_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_FC_SUM_ASSURED_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_FC_SUM_ASSURED = (Double) value;
		try {

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_SUM_ASSURED(POAD_FC_SUM_ASSURED);
			POAD_FC_SUM_ASSURED = helper.POAD_FC_SUM_ASSURED_VALIDATE_ITEM(
					POAD_FC_SUM_ASSURED, PT_IL_POL_ASSURED_DTLS_1_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_POAD_LC_SUM_ASSURED.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_LC_SUM_ASSURED_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_LC_SUM_ASSURED = (Double) value;
		try {

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_SUM_ASSURED(POAD_LC_SUM_ASSURED);
			POAD_LC_SUM_ASSURED = helper.POAD_LC_SUM_ASSURED_VALIDATE_ITEM(
					POAD_LC_SUM_ASSURED, PT_IL_POL_ASSURED_DTLS_1_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_FC_AMAN_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_FC_AMAN_PREM = (Double) value;
		try {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_AMAN_PREM(POAD_FC_AMAN_PREM);
			POAD_FC_AMAN_PREM = helper.POAD_FC_AMAN_PREM_VALIDATE_ITEM(
					POAD_FC_AMAN_PREM, PT_IL_POL_ASSURED_DTLS_1_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_POAD_LC_AMAN_PREM.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_LC_AMAN_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_LC_AMAN_PREM = (Double) value;
		try {

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_AMAN_PREM(POAD_LC_AMAN_PREM);
			POAD_LC_AMAN_PREM = helper.POAD_LC_AMAN_PREM_VALIDATE_ITEM(
					POAD_LC_AMAN_PREM, PT_IL_POL_ASSURED_DTLS_1_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_FC_AMAN_LOAD_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_FC_AMAN_LOAD_PREM = (Double) value;
		try {

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_AMAN_LOAD_PREM(POAD_FC_AMAN_LOAD_PREM);
			POAD_FC_AMAN_LOAD_PREM = helper.POAD_FC_AMAN_LOAD_PREM_VALIDATE_ITEM(
							POAD_FC_AMAN_LOAD_PREM,PT_IL_POL_ASSURED_DTLS_1_BEAN, 
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
							compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_POAD_LC_AMAN_LOAD_PREM.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_LC_AMAN_LOAD_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_LC_AMAN_LOAD_PREM = (Double) value;
		try {

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_AMAN_LOAD_PREM(POAD_LC_AMAN_LOAD_PREM);
			POAD_LC_AMAN_LOAD_PREM = helper.POAD_LC_AMAN_LOAD_PREM_VALIDATE_ITEM(
							POAD_LC_AMAN_LOAD_PREM,PT_IL_POL_ASSURED_DTLS_1_BEAN, 
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
							compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_FC_SENABEL_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_FC_SENABEL_PREM = (Double) value;
		try {

			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_FC_SENABEL_PREM(POAD_FC_SENABEL_PREM);
			POAD_FC_SENABEL_PREM = helper.POAD_FC_SENABEL_PREM_VALIDATE_ITEM(
					POAD_FC_SENABEL_PREM, PT_IL_POL_ASSURED_DTLS_1_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
						COMP_POAD_LC_SENABEL_PREM.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_LC_SENABEL_PREM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		Double POAD_LC_SENABEL_PREM = (Double) value;
		try {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_LC_SENABEL_PREM(POAD_LC_SENABEL_PREM);

			POAD_LC_SENABEL_PREM = helper.POAD_LC_SENABEL_PREM_VALIDATE_ITEM(
					POAD_LC_SENABEL_PREM, PT_IL_POL_ASSURED_DTLS_1_BEAN,
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void POAD_TYPE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {
		
		try {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_TYPE((String)value);
			helper.POAD_TYPE_WHEN_LIST_CHANGED(compositeAction);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public HtmlCommandButton getM_BUT_FLEX_FIELDS() {
		return M_BUT_FLEX_FIELDS;
	}

	public void setM_BUT_FLEX_FIELDS(HtmlCommandButton m_but_flex_fields) {
		M_BUT_FLEX_FIELDS = m_but_flex_fields;
	}

	public ArrayList<LovBean> prepareSuggestionList_ASSR_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		/*commented and added by ameen for FALCONLIFE-1344105 on 21-10-2016
		 * String query = "SELECT CONT_CODE,CONT_NAME,CONT_CUST_CODE FROM PM_IL_CONTRACTOR  WHERE CONT_FRZ_FLAG = 'N' "
				+ "AND (CONT_CODE LIKE ? OR CONT_NAME LIKE ?) AND ROWNUM < ?";*/
		String query = "SELECT CONT_CODE,CONT_NAME,CONT_CUST_CODE FROM PM_IL_CONTRACTOR  WHERE CONT_FRZ_FLAG = 'N' "
				+ "AND (UPPER(CONT_CODE) LIKE UPPER(?) OR UPPER(CONT_NAME) LIKE UPPER(?)) AND ROWNUM < ?";
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
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_CATG_CODE";
		Object param1 = "CATG";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
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
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_NATIONALITY";
		Object param1 = "NATLITY";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
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
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_MAR_STATUS";
		Object param1 = "MARI_STAT";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
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
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_OCC_CODE";
		Object param1 = "IL_OCCU";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
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
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_OCC_CLASS";
		Object param1 = "IL_OCC_CLASS";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
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
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_OCC_RATE";
		Object param1 = "IL_OCC_CLASS";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
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
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_RELIGION_CODE";
		Object param1 = "RELIGION";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
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
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_HEALTH_CODE";
		Object param1 = "IL_HLTH_ST";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
			if(object	==	null||(object.toString().isEmpty())){
				this.getPT_IL_POL_ASSURED_DTLS_1_BEAN().setUI_M_POAD_HEALTH_DESC(null);
			}
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
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_RACE";
		Object param1 = "RACE";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
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
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_ADDL_RISK_CODE";
		Object param1 = "IL_ADDL_RISK";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
			if(object	==	null||(object.toString().isEmpty())){
				this.getPT_IL_POL_ASSURED_DTLS_1_BEAN().setUI_M_ADDL_RISK_DESC(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	

	/**
	 * Instantiates all components in PT_IL_POL_ASSURED_DTLS_1_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_POAD_ASSR_CODE				 = new HtmlInputText();
		COMP_POAD_ASSURED_NAME				 = new HtmlInputText();
		COMP_POAD_FC_SALARY				 = new HtmlInputText();
		COMP_POAD_REF_ID1				 = new HtmlInputText();
		COMP_POAD_REF_ID2				 = new HtmlInputText();
		COMP_POAD_LC_SALARY				 = new HtmlInputText();
		COMP_POAD_CATG_CODE				 = new HtmlInputText();
		COMP_UI_M_POAD_CATG_DESC			 = new HtmlInputText();
		COMP_POAD_RELATION_CODE          = new HtmlInputText();
		COMP_UI_M_POAD_RELATION_DESC     = new HtmlInputText();
		COMP_POAD_NATURE_OF_WORK		 = new HtmlInputTextarea();
		COMP_POAD_HEIGHT				 = new HtmlInputText();
		COMP_POAD_BIRTH_PLACE			 = new HtmlInputTextarea();
		COMP_POAD_AGE					 = new HtmlInputText();
		COMP_POAD_WEIGHT				 = new HtmlInputText();
		COMP_POAD_RACE					 = new HtmlInputText();
		COMP_UI_M_POAD_RACE_CODE_DESC	= new HtmlInputText();
		COMP_POAD_ADDL_RISK_CODE			 = new HtmlInputText();
		COMP_UI_M_ADDL_RISK_DESC			 = new HtmlInputText();
		COMP_POAD_BMI					 = new HtmlInputText();
		COMP_POAD_AGE_PROOF_OTHERS			 = new HtmlInputText();
		COMP_UI_M_POAD_LC_THRESOLD_LMT			 = new HtmlInputText();
		COMP_POAD_DISC_AGE				 = new HtmlInputText();
		COMP_POAD_NO_OF_CIGAR				 = new HtmlInputText();
		COMP_POAD_LC_THRESHOLD_LMT			 = new HtmlInputText();
		COMP_POAD_NATIONALITY				 = new HtmlInputText();
		COMP_UI_M_POAD_NATLITY_DESC			 = new HtmlInputText();
		COMP_POAD_REMARKS				 = new HtmlInputText();
		COMP_POAD_MAR_STATUS				 = new HtmlInputText();
		COMP_UI_M_POAD_MS_DESC				 = new HtmlInputText();
		COMP_POAD_FC_SUM_ASSURED			 = new HtmlInputText();
		COMP_POAD_LC_SUM_ASSURED			 = new HtmlInputText();
		COMP_POAD_OCC_CODE				 = new HtmlInputText();
		COMP_UI_M_POAD_OCC_DESC				 = new HtmlInputText();
		COMP_POAD_FC_AMAN_PREM				 = new HtmlInputText();
		COMP_POAD_LC_AMAN_PREM				 = new HtmlInputText();
		COMP_POAD_OCC_CLASS				 = new HtmlInputText();
		COMP_UI_M_POAD_OCC_CLASS_DESC			 = new HtmlInputText();
		COMP_POAD_FC_AMAN_LOAD_PREM			 = new HtmlInputText();
		COMP_POAD_LC_AMAN_LOAD_PREM			 = new HtmlInputText();
		COMP_POAD_RELIGION_CODE				 = new HtmlInputText();
		COMP_UI_M_POAD_REL_CODE_DESC			 = new HtmlInputText();
		COMP_POAD_FC_SENABEL_PREM			 = new HtmlInputText();
		COMP_POAD_LC_SENABEL_PREM			 = new HtmlInputText();
		COMP_POAD_HEALTH_CODE				 = new HtmlInputText();
		COMP_UI_M_POAD_HEALTH_DESC			 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_POAD_ASSR_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_ASSURED_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_FC_SALARY_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_REF_ID1_LABEL				 = new HtmlOutputLabel();
		COMP_POAD_REF_ID2_LABEL				 = new HtmlOutputLabel();
		COMP_POAD_LC_SALARY_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_TYPE_LABEL				 = new HtmlOutputLabel();
		COMP_POAD_CATG_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POAD_CATG_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_NATURE_OF_WORK_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_DOB_LABEL				 = new HtmlOutputLabel();
		COMP_POAD_HEIGHT_LABEL				 = new HtmlOutputLabel();
		COMP_POAD_HEIGHT_UNIT_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_BIRTH_PLACE_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_AGE_LABEL				 = new HtmlOutputLabel();
		COMP_POAD_WEIGHT_LABEL				 = new HtmlOutputLabel();
		COMP_POAD_WEIGHT_UNIT_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_RACE_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_POAD_RACE_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POAD_ADDL_RISK_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_ADDL_RISK_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_BMI_LABEL				 = new HtmlOutputLabel();
		COMP_POAD_AGE_PROOF_FLAG_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_AGE_PROOF_OTHERS_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POAD_LC_THRESOLD_LMT_LABEL		 = new HtmlOutputLabel();
		COMP_POAD_DISC_AGE_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_SMOKE_YN_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_NO_OF_CIGAR_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_LC_THRESHOLD_LMT_LABEL		 = new HtmlOutputLabel();
		COMP_POAD_NATIONALITY_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POAD_NATLITY_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POAD_REMARKS_LABEL				 = new HtmlOutputLabel();
		COMP_POAD_MAR_STATUS_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POAD_MS_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_FC_SUM_ASSURED_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_LC_SUM_ASSURED_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_OCC_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POAD_OCC_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_FC_AMAN_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_LC_AMAN_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_OCC_CLASS_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POAD_OCC_CLASS_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POAD_FC_AMAN_LOAD_PREM_LABEL		 = new HtmlOutputLabel();
		COMP_POAD_LC_AMAN_LOAD_PREM_LABEL		 = new HtmlOutputLabel();
		COMP_POAD_RELIGION_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POAD_REL_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_POAD_FC_SENABEL_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_LC_SENABEL_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_POAD_HEALTH_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POAD_HEALTH_DESC_LABEL		 = new HtmlOutputLabel();
		/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
		COMP_POAD_HIV_TEST_YN_LABEL              = new HtmlOutputLabel();
		/*End*/

		// Instantiating HtmlSelectOneMenu
		COMP_POAD_TYPE					 = new HtmlSelectOneMenu();
		COMP_POAD_HEIGHT_UNIT				 = new HtmlSelectOneMenu();
		COMP_POAD_WEIGHT_UNIT				 = new HtmlSelectOneMenu();
		COMP_POAD_AGE_PROOF_FLAG			 = new HtmlSelectOneMenu();
		COMP_POAD_SMOKE_YN				 = new HtmlSelectOneMenu();
		COMP_POAD_POL_OWNER_YN				 = new HtmlSelectOneMenu();
		/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
		COMP_POAD_HIV_TEST_YN = new HtmlSelectOneMenu();
		/*End*/

		// Instantiating HtmlCalendar
		COMP_POAD_DOB					 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_FLEX_FIELDS1			 = new HtmlCommandButton();
		COMP_ADDL_COVER_DTLS1				 = new HtmlCommandButton();
		M_BUT_FLEX_FIELDS				 = new HtmlCommandButton();
		UI_M_BUT_FLEX_FIELDS1				 = new HtmlCommandButton();

	}



	public HtmlCommandButton getCOMP_UI_M_BUT_FLEX_FIELDS1() {
		return COMP_UI_M_BUT_FLEX_FIELDS1;
	}

	public void setCOMP_UI_M_BUT_FLEX_FIELDS1(
			HtmlCommandButton comp_ui_m_but_flex_fields1) {
		COMP_UI_M_BUT_FLEX_FIELDS1 = comp_ui_m_but_flex_fields1;
	}


	public PT_IL_POL_ASSURED_DTLS_1 getPT_IL_POL_ASSURED_DTLS_1_BEAN() {
		return PT_IL_POL_ASSURED_DTLS_1_BEAN;
	}


	public void setPT_IL_POL_ASSURED_DTLS_1_BEAN(
			PT_IL_POL_ASSURED_DTLS_1 pt_il_pol_assured_dtls_1_bean) {
		PT_IL_POL_ASSURED_DTLS_1_BEAN = pt_il_pol_assured_dtls_1_bean;
	}
	public String medicalHistory(ActionEvent event){
		  String outString = null;
		  
		  outString ="PILT002_APAC_PT_IL_POL_ASSR_MED_HIST_1";
		  
		  return outString;
	  }


	public HtmlCommandButton getCOMP_ADDL_COVER_DTLS1() {
		return COMP_ADDL_COVER_DTLS1;
	}


	public void setCOMP_ADDL_COVER_DTLS1(HtmlCommandButton comp_addl_cover_dtls1) {
		COMP_ADDL_COVER_DTLS1 = comp_addl_cover_dtls1;
	}
	
	public String coverDetail1(){
		String reString = null;
		reString = "PILT002_APAC_PT_IL_POL_ADDL_COVER_1";
	return 	reString;
	}


	/**
	 * Disables all components in PT_IL_POL_ASSURED_DTLS_1_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
		COMP_POAD_HIV_TEST_YN.setDisabled(disabled);
		/*End*/
		COMP_POAD_ASSR_CODE.setDisabled(disabled);
		//COMP_POAD_ASSURED_NAME.setDisabled(disabled);
		COMP_POAD_FC_SALARY.setDisabled(disabled);
		COMP_POAD_REF_ID1.setDisabled(disabled);
		COMP_POAD_REF_ID2.setDisabled(disabled);
		//COMP_POAD_LC_SALARY.setDisabled(disabled);
		COMP_POAD_CATG_CODE.setDisabled(disabled);
		COMP_UI_M_POAD_CATG_DESC.setDisabled(disabled);
		COMP_POAD_RELATION_CODE.setDisabled(disabled);
		COMP_UI_M_POAD_RELATION_DESC.setDisabled(disabled);
		COMP_POAD_NATURE_OF_WORK.setDisabled(disabled);
		COMP_POAD_HEIGHT.setDisabled(disabled);
		COMP_POAD_BIRTH_PLACE.setDisabled(disabled);
		COMP_POAD_AGE.setDisabled(disabled);
		COMP_POAD_WEIGHT.setDisabled(disabled);
		COMP_POAD_RACE.setDisabled(disabled);
		//COMP_UI_M_POAD_RACE_CODE_DESC.setDisabled(disabled);
		COMP_POAD_ADDL_RISK_CODE.setDisabled(disabled);
		COMP_UI_M_ADDL_RISK_DESC.setDisabled(disabled);
		COMP_POAD_BMI.setDisabled(disabled);
		COMP_POAD_AGE_PROOF_OTHERS.setDisabled(disabled);
		COMP_UI_M_POAD_LC_THRESOLD_LMT.setDisabled(disabled);
		COMP_POAD_DISC_AGE.setDisabled(disabled);
		COMP_POAD_NO_OF_CIGAR.setDisabled(disabled);
		COMP_POAD_LC_THRESHOLD_LMT.setDisabled(disabled);
		COMP_POAD_NATIONALITY.setDisabled(disabled);
		//COMP_UI_M_POAD_NATLITY_DESC.setDisabled(disabled);
		COMP_POAD_REMARKS.setDisabled(disabled);
		COMP_POAD_MAR_STATUS.setDisabled(disabled);
		COMP_UI_M_POAD_MS_DESC.setDisabled(disabled);
		COMP_POAD_FC_SUM_ASSURED.setDisabled(disabled);
		COMP_POAD_LC_SUM_ASSURED.setDisabled(disabled);
		COMP_POAD_OCC_CODE.setDisabled(disabled);
		//COMP_UI_M_POAD_OCC_DESC.setDisabled(disabled);
		COMP_POAD_FC_AMAN_PREM.setDisabled(disabled);
		COMP_POAD_LC_AMAN_PREM.setDisabled(disabled);
		COMP_POAD_OCC_CLASS.setDisabled(disabled);
		//COMP_UI_M_POAD_OCC_CLASS_DESC.setDisabled(disabled);
		COMP_POAD_FC_AMAN_LOAD_PREM.setDisabled(disabled);
		COMP_POAD_LC_AMAN_LOAD_PREM.setDisabled(disabled);
		COMP_POAD_RELIGION_CODE.setDisabled(disabled);
		//COMP_UI_M_POAD_REL_CODE_DESC.setDisabled(disabled);
		COMP_POAD_FC_SENABEL_PREM.setDisabled(disabled);
		COMP_POAD_LC_SENABEL_PREM.setDisabled(disabled);
		COMP_POAD_HEALTH_CODE.setDisabled(disabled);
		COMP_UI_M_POAD_HEALTH_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_POAD_TYPE.setDisabled(disabled);
		COMP_POAD_HEIGHT_UNIT.setDisabled(disabled);
		COMP_POAD_WEIGHT_UNIT.setDisabled(disabled);
		COMP_POAD_AGE_PROOF_FLAG.setDisabled(disabled);
		COMP_POAD_SMOKE_YN.setDisabled(disabled);
		COMP_POAD_POL_OWNER_YN.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_POAD_DOB.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_FLEX_FIELDS1.setDisabled(disabled);
		COMP_ADDL_COVER_DTLS1.setDisabled(disabled);
		M_BUT_FLEX_FIELDS.setDisabled(disabled);
		UI_M_BUT_FLEX_FIELDS1.setDisabled(disabled);

	}

	public String productDetail(){
		String reString = null;
		reString = "PILT002_APAC_PT_IL_POL_APPL_PROD_1";
	return 	reString;
	}


	public HtmlCommandButton getCOMP_PT_IL_POL_APPL_PROD() {
		return COMP_PT_IL_POL_APPL_PROD;
	}


	public void setCOMP_PT_IL_POL_APPL_PROD(
			HtmlCommandButton comp_pt_il_pol_appl_prod) {
		COMP_PT_IL_POL_APPL_PROD = comp_pt_il_pol_appl_prod;
	}





	public HtmlInputText getCOMP_POAD_RELATION_CODE() {
		return COMP_POAD_RELATION_CODE;
	}


	public HtmlOutputLabel getCOMP_POAD_RELATION_CODE_LABEL() {
		return COMP_POAD_RELATION_CODE_LABEL;
	}


	public void setCOMP_POAD_RELATION_CODE_LABEL(
			HtmlOutputLabel comp_poad_relation_code_label) {
		COMP_POAD_RELATION_CODE_LABEL = comp_poad_relation_code_label;
	}


	public void setCOMP_POAD_RELATION_CODE(HtmlInputText comp_poad_relation_code) {
		COMP_POAD_RELATION_CODE = comp_poad_relation_code;
	}


	public HtmlInputText getCOMP_UI_M_POAD_RELATION_DESC() {
		return COMP_UI_M_POAD_RELATION_DESC;
	}


	public void setCOMP_UI_M_POAD_RELATION_DESC(
			HtmlInputText comp_ui_m_poad_relation_desc) {
		COMP_UI_M_POAD_RELATION_DESC = comp_ui_m_poad_relation_desc;
	}
	
	//[Added By akash For DPLI POC.....
	
		/*Added by saritha on 06-Jan-2017 for lov method name changed*/
		/*public ArrayList<LovBean> prepareSuggestionList_PBEN_RELATION_CODE(Object object) {*/
		public ArrayList<LovBean> prepareSuggestionList_POAD_RELATION_CODE(Object object){
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		/*Commentted by saritha on 06-Jan-2017 for Relation code lov*/
		/*String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_RELATION_CODE";*/
		
		/*Added by saritha on 06-Jan-2017 for Relation code lov*/
		String blockName = "PT_IL_POL_ASSURED_DTLS_1";
		String fieldName = "POAD_RELATION_CODE";
		Object param1 = "ILBENFREL";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	public void PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_RELATION_CODE((String) value);

			PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_ASSURED_DTLS_1_BEAN);
					
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(
			PT_IL_POL_ASSURED_DTLS_1 PT_IL_POL_ASSURED_DTLS_1_BEAN) throws Exception {

		String CURSOR_C1 = "SELECT PC_CODE,PC_DESC FROM   PM_CODES WHERE  PC_TYPE = 'ILBENFREL'";
		String M_FLAG = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			while (resultSet.next()) {
				if (PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_RELATION_CODE().equals(
						resultSet.getString(1))) {
					PT_IL_POL_ASSURED_DTLS_1_BEAN.setUI_M_POAD_RELATION_DESC(resultSet
							.getString(2));
					M_FLAG = "Y";
					break;
				} else {
					M_FLAG = "N";
				}
			}

			if ("N".equals(M_FLAG)
					&& PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_RELATION_CODE() != "S") {
				throw new Exception((Messages.getString(
						PELConstants.pelErrorMessagePath, "71254")));
			}
			
			//End

			//Added by saritha 
			
			/*PT_IL_POL_ASSURED_DTLS_1_BEAN.setPOAD_RELATION_CODE(resultSet.getString("POAD_RELATION_CODE"));
			System.out.println("**********value of Relation code------------>"+PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_RELATION_CODE());*/
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
 
	public HtmlSelectOneMenu getCOMP_POAD_POL_OWNER_YN() {
		return COMP_POAD_POL_OWNER_YN;
	}


	public void setCOMP_POAD_POL_OWNER_YN(HtmlSelectOneMenu comp_poad_pol_owner_yn) {
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


	public HtmlTab getCOMP_MORE_INFO_1() {
		return COMP_MORE_INFO_1;
	}


	public void setCOMP_MORE_INFO_1(HtmlTab comp_more_info_1) {
		COMP_MORE_INFO_1 = comp_more_info_1;
	}

	public String chkNormalOrPakagePolicy() {
		String outCome = null;
		if ("NR".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18"))
				|| CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_18") == null) {
			outCome = coverDetail();
			CommonUtils.setGlobalObject("POAD_SYS_ID", PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_SYS_ID());
			CommonUtils.setGlobalObject("GLOBAL_ASSURED_CODE",PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_ASSR_CODE());
			compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().setBlockFlag(true);
		} else if ("PG".equals(CommonUtils
				.getGlobalVariable("GLOBAL.M_PARAM_18"))) {
			outCome = productDetail();
		}
		CommonUtils.setGlobalObject("GLOBAL_POAD_TYPE",PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_TYPE());

		/*compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_POAC_WOP_FLAG().setDisabled(true);*/
		return outCome;
	}



	public String coverDetail() {
		String reString = null;
		reString = "PILT002_APAC_PT_IL_POL_ADDL_COVER";
		return reString;
	}

	//Added By akash For DPLI POC.....]

/*Added by Saritha on 09-Dec.2016 for RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/

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
		getPT_IL_POL_ASSURED_DTLS_1_BEAN().setPOAD_HIV_TEST_YN(POAD_HIV_TEST_YN);
		System.out.println("POAD_HIV_TEST_YN:::::::::::::::::::::"+PT_IL_POL_ASSURED_DTLS_1_BEAN.getPOAD_HIV_TEST_YN());
		//COMP_POAD_HIV_TEST_YN.resetValue();
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}

/*End*/
	
}

