package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_BROKER_HEAD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POBH_SRNO_LABEL;

	private HtmlInputText COMP_POBH_SRNO;

	private HtmlOutputLabel COMP_POBH_BROKER_CODE_LABEL;

	private HtmlInputText COMP_POBH_BROKER_CODE;

	private HtmlOutputLabel COMP_POBH_COMM_CODE_LABEL;

	private HtmlInputText COMP_POBH_COMM_CODE;

	private HtmlOutputLabel COMP_POBH_COVER_CODE_LABEL;

	private HtmlInputText COMP_POBH_COVER_CODE;

	private HtmlOutputLabel COMP_POBH_APPLY_ON_SRNO_LABEL;

	private HtmlInputText COMP_POBH_APPLY_ON_SRNO;

	private HtmlOutputLabel COMP_POBH_BROKER_CURR_CODE_LABEL;

	private HtmlInputText COMP_POBH_BROKER_CURR_CODE;

	private HtmlOutputLabel COMP_POBH_ACTING_AGENT_YN_LABEL;

	private HtmlSelectOneMenu COMP_POBH_ACTING_AGENT_YN;

	private HtmlOutputLabel COMP_POBH_REMARKS_LABEL;

	private HtmlInputText COMP_POBH_REMARKS;

	private HtmlOutputLabel COMP_UI_M_POBH_BROKER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POBH_BROKER_DESC;

	private HtmlOutputLabel COMP_UI_M_POBH_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POBH_COVER_DESC;

	private HtmlOutputLabel COMP_UI_M_POBH_CURR_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POBH_CURR_DESC;

	private HtmlOutputLabel COMP_UI_M_PS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PS_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_SHOW_AGENT;

	private HtmlCommandButton COMP_UI_M_BTN_BROKER_DTL;
	private HtmlCommandButton COMP_UI_M_BTN_BROKER_DEDUCTION;


	private HtmlOutputLabel COMP_POBH_FC_COMMISSION_LABEL;
	private HtmlInputText COMP_POBH_FC_COMMISSION;

	private HtmlOutputLabel COMP_POBH_LC_COMMISSION_LABEL;
	private HtmlInputText COMP_POBH_LC_COMMISSION;

	private HtmlAjaxCommandButton COMP_UI_M_BUT_OVERRIDE_COMM;

	private PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_BROKER_HEAD_HELPER helper;
	
	
	
	
	

	private List<PT_IL_POL_BROKER_HEAD> dataList_PT_IL_POL_BROKER_HEAD = new ArrayList<PT_IL_POL_BROKER_HEAD>();

	private UIData dataTable;

	private List<SelectItem> listPOBH_ACTING_AGENT_YN = new ArrayList<SelectItem>();
	
	//Added by saranya on 8-4-16 for email capture
	private HtmlOutputLabel COMP_BROKER_MAIL_ID_LABEL;
	
	private HtmlInputText COMP_BROKER_MAIL_ID;

	public HtmlOutputLabel getCOMP_BROKER_MAIL_ID_LABEL() {
		return COMP_BROKER_MAIL_ID_LABEL;
	}

	public void setCOMP_BROKER_MAIL_ID_LABELL(
			HtmlOutputLabel cOMP_BROKER_MAIL_ID_LABEL) {
	COMP_BROKER_MAIL_ID_LABEL = cOMP_BROKER_MAIL_ID_LABEL;
	}

	public HtmlInputText getCOMP_BROKER_MAIL_ID() {
		return COMP_BROKER_MAIL_ID;
	}

	public void setCOMP_BROKER_MAIL_ID(HtmlInputText cOMP_BROKER_MAIL_ID) {
		COMP_BROKER_MAIL_ID = cOMP_BROKER_MAIL_ID;
	}
	//end 
	/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 26-12-2016 */
	private HtmlOutputLabel COMP_POBH_PARENT_BROKER_LABEL;
	
	private HtmlInputText COMP_POBH_PARENT_BROKER;

	public HtmlOutputLabel getCOMP_POBH_PARENT_BROKER_LABEL() {
		return COMP_POBH_PARENT_BROKER_LABEL;
	}

	public void setCOMP_POBH_PARENT_BROKER_LABEL(
			HtmlOutputLabel cOMP_POBH_PARENT_BROKER_LABEL) {
		COMP_POBH_PARENT_BROKER_LABEL = cOMP_POBH_PARENT_BROKER_LABEL;
	}

	public HtmlInputText getCOMP_POBH_PARENT_BROKER() {
		return COMP_POBH_PARENT_BROKER;
	}

	public void setCOMP_POBH_PARENT_BROKER(HtmlInputText cOMP_POBH_PARENT_BROKER) {
		COMP_POBH_PARENT_BROKER = cOMP_POBH_PARENT_BROKER;
	}
	/*End*/
	/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 25-01-2017 */
	private HtmlOutputLabel COMP_UI_M_COMM_TYPE_LABEL;
	
	private HtmlInputText COMP_UI_M_COMM_TYPE;

	public HtmlOutputLabel getCOMP_UI_M_COMM_TYPE_LABEL() {
		return COMP_UI_M_COMM_TYPE_LABEL;
	}

	public void setCOMP_UI_M_COMM_TYPE_LABEL(
			HtmlOutputLabel cOMP_UI_M_COMM_TYPE_LABEL) {
		COMP_UI_M_COMM_TYPE_LABEL = cOMP_UI_M_COMM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COMM_TYPE() {
		return COMP_UI_M_COMM_TYPE;
	}

	
	
	public void setCOMP_UI_M_COMM_TYPE(HtmlInputText cOMP_UI_M_COMM_TYPE) {
		COMP_UI_M_COMM_TYPE = cOMP_UI_M_COMM_TYPE;
	}
	
	/*End*/

	/*Added by Janani for RM018T - FSD_IL_ZB Life_007_Multiple agents on 20-12-2016	*/
	
private HtmlOutputLabel COMP_POBH_SHARE_RATIO_LABEL;
	
	private HtmlInputText COMP_POBH_SHARE_RATIO;

	public HtmlOutputLabel getCOMP_POBH_SHARE_RATIO_LABEL() {
		return COMP_POBH_SHARE_RATIO_LABEL;
	}

	public void setCOMP_POBH_SHARE_RATIO_LABEL(
			HtmlOutputLabel cOMP_POBH_SHARE_RATIO_LABEL) {
		COMP_POBH_SHARE_RATIO_LABEL = cOMP_POBH_SHARE_RATIO_LABEL;
	}

	public HtmlInputText getCOMP_POBH_SHARE_RATIO() {
		return COMP_POBH_SHARE_RATIO;
	}

	public void setCOMP_POBH_SHARE_RATIO(HtmlInputText cOMP_POBH_SHARE_RATIO) {
		COMP_POBH_SHARE_RATIO = cOMP_POBH_SHARE_RATIO;
	}

	public void POBH_SHARE_PERC_WHEN_VALIDATE_ITEM(FacesContext context,UIComponent component, Object value){
		try {
			PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_SHARE_PERC((Double) value);
			helper.POBH_SHARE_PERC_WHEN_VALIDATE_ITEM(this,PT_IL_POL_BROKER_HEAD_BEAN);
			
			COMP_POBH_SHARE_RATIO.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*End*/
	//added by krithika

	private  PT_IL_POLICY_ACTION PT_IL_POLICY_ACTION_BEAN;
	
	public PT_IL_POLICY_ACTION getPT_IL_POLICY_ACTION_BEAN() {
		return PT_IL_POLICY_ACTION_BEAN;
	}

	public void setPT_IL_POLICY_ACTION_BEAN(
			PT_IL_POLICY_ACTION pT_IL_POLICY_ACTION_BEAN) {
		PT_IL_POLICY_ACTION_BEAN = pT_IL_POLICY_ACTION_BEAN;
	}
	//end

	public PT_IL_POL_BROKER_HEAD_ACTION() {
		PT_IL_POL_BROKER_HEAD_BEAN = new PT_IL_POL_BROKER_HEAD();
		PT_IL_POLICY_ACTION_BEAN=new PT_IL_POLICY_ACTION();
		helper = new PT_IL_POL_BROKER_HEAD_HELPER();
		instantiateAllComponent();
		prepareDropDownList();
	}

	public void prepareDropDownList() {
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			listPOBH_ACTING_AGENT_YN = ListItemUtil.getDropDownListValue(
					connection, "PILT002_APAC", "PT_IL_POL_BROKER_HEAD",
					"PT_IL_POL_BROKER_HEAD.POBH_ACTING_AGENT_YN", "YESNO");

		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_POBH_SRNO_LABEL() {
		return COMP_POBH_SRNO_LABEL;
	}

	public void setCOMP_POBH_SRNO_LABEL(HtmlOutputLabel comp_pobh_srno_label) {
		COMP_POBH_SRNO_LABEL = comp_pobh_srno_label;
	}

	public HtmlInputText getCOMP_POBH_SRNO() {
		return COMP_POBH_SRNO;
	}

	public void setCOMP_POBH_SRNO(HtmlInputText comp_pobh_srno) {
		COMP_POBH_SRNO = comp_pobh_srno;
	}

	public HtmlOutputLabel getCOMP_POBH_BROKER_CODE_LABEL() {
		return COMP_POBH_BROKER_CODE_LABEL;
	}

	public void setCOMP_POBH_BROKER_CODE_LABEL(
			HtmlOutputLabel comp_pobh_broker_code_label) {
		COMP_POBH_BROKER_CODE_LABEL = comp_pobh_broker_code_label;
	}

	public HtmlInputText getCOMP_POBH_BROKER_CODE() {
		return COMP_POBH_BROKER_CODE;
	}

	public void setCOMP_POBH_BROKER_CODE(HtmlInputText comp_pobh_broker_code) {
		COMP_POBH_BROKER_CODE = comp_pobh_broker_code;
	}

	public HtmlOutputLabel getCOMP_POBH_COMM_CODE_LABEL() {
		return COMP_POBH_COMM_CODE_LABEL;
	}

	public void setCOMP_POBH_COMM_CODE_LABEL(
			HtmlOutputLabel comp_pobh_comm_code_label) {
		COMP_POBH_COMM_CODE_LABEL = comp_pobh_comm_code_label;
	}

	public HtmlInputText getCOMP_POBH_COMM_CODE() {
		return COMP_POBH_COMM_CODE;
	}

	public void setCOMP_POBH_COMM_CODE(HtmlInputText comp_pobh_comm_code) {
		COMP_POBH_COMM_CODE = comp_pobh_comm_code;
	}

	public HtmlOutputLabel getCOMP_POBH_COVER_CODE_LABEL() {
		return COMP_POBH_COVER_CODE_LABEL;
	}

	public void setCOMP_POBH_COVER_CODE_LABEL(
			HtmlOutputLabel comp_pobh_cover_code_label) {
		COMP_POBH_COVER_CODE_LABEL = comp_pobh_cover_code_label;
	}

	public HtmlInputText getCOMP_POBH_COVER_CODE() {
		return COMP_POBH_COVER_CODE;
	}

	public void setCOMP_POBH_COVER_CODE(HtmlInputText comp_pobh_cover_code) {
		COMP_POBH_COVER_CODE = comp_pobh_cover_code;
	}

	public HtmlOutputLabel getCOMP_POBH_APPLY_ON_SRNO_LABEL() {
		return COMP_POBH_APPLY_ON_SRNO_LABEL;
	}

	public void setCOMP_POBH_APPLY_ON_SRNO_LABEL(
			HtmlOutputLabel comp_pobh_apply_on_srno_label) {
		COMP_POBH_APPLY_ON_SRNO_LABEL = comp_pobh_apply_on_srno_label;
	}

	public HtmlInputText getCOMP_POBH_APPLY_ON_SRNO() {
		return COMP_POBH_APPLY_ON_SRNO;
	}

	public void setCOMP_POBH_APPLY_ON_SRNO(HtmlInputText comp_pobh_apply_on_srno) {
		COMP_POBH_APPLY_ON_SRNO = comp_pobh_apply_on_srno;
	}

	public HtmlOutputLabel getCOMP_POBH_BROKER_CURR_CODE_LABEL() {
		return COMP_POBH_BROKER_CURR_CODE_LABEL;
	}

	public void setCOMP_POBH_BROKER_CURR_CODE_LABEL(
			HtmlOutputLabel comp_pobh_broker_curr_code_label) {
		COMP_POBH_BROKER_CURR_CODE_LABEL = comp_pobh_broker_curr_code_label;
	}

	public HtmlInputText getCOMP_POBH_BROKER_CURR_CODE() {
		return COMP_POBH_BROKER_CURR_CODE;
	}

	public void setCOMP_POBH_BROKER_CURR_CODE(
			HtmlInputText comp_pobh_broker_curr_code) {
		COMP_POBH_BROKER_CURR_CODE = comp_pobh_broker_curr_code;
	}

	public HtmlOutputLabel getCOMP_POBH_ACTING_AGENT_YN_LABEL() {
		return COMP_POBH_ACTING_AGENT_YN_LABEL;
	}

	public void setCOMP_POBH_ACTING_AGENT_YN_LABEL(
			HtmlOutputLabel comp_pobh_acting_agent_yn_label) {
		COMP_POBH_ACTING_AGENT_YN_LABEL = comp_pobh_acting_agent_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_POBH_ACTING_AGENT_YN() {
		return COMP_POBH_ACTING_AGENT_YN;
	}

	public void setCOMP_POBH_ACTING_AGENT_YN(
			HtmlSelectOneMenu comp_pobh_acting_agent_yn) {
		COMP_POBH_ACTING_AGENT_YN = comp_pobh_acting_agent_yn;
	}

	public HtmlOutputLabel getCOMP_POBH_REMARKS_LABEL() {
		return COMP_POBH_REMARKS_LABEL;
	}

	public void setCOMP_POBH_REMARKS_LABEL(
			HtmlOutputLabel comp_pobh_remarks_label) {
		COMP_POBH_REMARKS_LABEL = comp_pobh_remarks_label;
	}

	public HtmlInputText getCOMP_POBH_REMARKS() {
		return COMP_POBH_REMARKS;
	}

	public void setCOMP_POBH_REMARKS(HtmlInputText comp_pobh_remarks) {
		COMP_POBH_REMARKS = comp_pobh_remarks;
	}

	public HtmlOutputLabel getCOMP_UI_M_POBH_BROKER_DESC_LABEL() {
		return COMP_UI_M_POBH_BROKER_DESC_LABEL;
	}

	public void setCOMP_UI_M_POBH_BROKER_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_pobh_broker_desc_label) {
		COMP_UI_M_POBH_BROKER_DESC_LABEL = comp_ui_m_pobh_broker_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POBH_BROKER_DESC() {
		return COMP_UI_M_POBH_BROKER_DESC;
	}

	public void setCOMP_UI_M_POBH_BROKER_DESC(
			HtmlInputText comp_ui_m_pobh_broker_desc) {
		COMP_UI_M_POBH_BROKER_DESC = comp_ui_m_pobh_broker_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_POBH_COVER_DESC_LABEL() {
		return COMP_UI_M_POBH_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_POBH_COVER_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_pobh_cover_desc_label) {
		COMP_UI_M_POBH_COVER_DESC_LABEL = comp_ui_m_pobh_cover_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POBH_COVER_DESC() {
		return COMP_UI_M_POBH_COVER_DESC;
	}

	public void setCOMP_UI_M_POBH_COVER_DESC(
			HtmlInputText comp_ui_m_pobh_cover_desc) {
		COMP_UI_M_POBH_COVER_DESC = comp_ui_m_pobh_cover_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_POBH_CURR_DESC_LABEL() {
		return COMP_UI_M_POBH_CURR_DESC_LABEL;
	}

	public void setCOMP_UI_M_POBH_CURR_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_pobh_curr_desc_label) {
		COMP_UI_M_POBH_CURR_DESC_LABEL = comp_ui_m_pobh_curr_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POBH_CURR_DESC() {
		return COMP_UI_M_POBH_CURR_DESC;
	}

	public void setCOMP_UI_M_POBH_CURR_DESC(
			HtmlInputText comp_ui_m_pobh_curr_desc) {
		COMP_UI_M_POBH_CURR_DESC = comp_ui_m_pobh_curr_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_DESC_LABEL() {
		return COMP_UI_M_PS_DESC_LABEL;
	}

	public void setCOMP_UI_M_PS_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_ps_desc_label) {
		COMP_UI_M_PS_DESC_LABEL = comp_ui_m_ps_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_PS_DESC() {
		return COMP_UI_M_PS_DESC;
	}

	public void setCOMP_UI_M_PS_DESC(HtmlInputText comp_ui_m_ps_desc) {
		COMP_UI_M_PS_DESC = comp_ui_m_ps_desc;
	}

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_BROKER_HEAD_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_BROKER_HEAD_HELPER helper) {
		this.helper = helper;
	}

	public void setDataList_PT_IL_POL_BROKER_HEAD(
			List<PT_IL_POL_BROKER_HEAD> dataList_PT_IL_POL_BROKER_HEAD) {
		this.dataList_PT_IL_POL_BROKER_HEAD = dataList_PT_IL_POL_BROKER_HEAD;
	}

	public PT_IL_POL_BROKER_HEAD getPT_IL_POL_BROKER_HEAD_BEAN() {
		return PT_IL_POL_BROKER_HEAD_BEAN;
	}

	public void setPT_IL_POL_BROKER_HEAD_BEAN(
			PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN) {
		this.PT_IL_POL_BROKER_HEAD_BEAN = PT_IL_POL_BROKER_HEAD_BEAN;
	}

	public List<PT_IL_POL_BROKER_HEAD> getDataList_PT_IL_POL_BROKER_HEAD() {
		return dataList_PT_IL_POL_BROKER_HEAD;
	}

	public void setDataListPT_IL_POL_BROKER_HEAD(
			List<PT_IL_POL_BROKER_HEAD> dataList_PT_IL_POL_BROKER_HEAD) {
		this.dataList_PT_IL_POL_BROKER_HEAD = dataList_PT_IL_POL_BROKER_HEAD;
	}
	
	
	

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_POL_BROKER_HEAD_BEAN = new PT_IL_POL_BROKER_HEAD();
				helper.whenCreateRecord(this, compositeAction
						.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event) {
		String message = null;

		try {
			
			if (isDELETE_ALLOWED()) {
				helper.preDelete(getPT_IL_POL_BROKER_HEAD_BEAN());
				helper.keyDelRec(getPT_IL_POL_BROKER_HEAD_BEAN(),
						dataList_PT_IL_POL_BROKER_HEAD);
				new CRUDHandler().executeDelete(PT_IL_POL_BROKER_HEAD_BEAN,
						CommonUtils.getConnection());
				/*added by raja on 24-04-2017*/
				CommonUtils.getConnection().commit();
				/*end*/
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete");
				dataList_PT_IL_POL_BROKER_HEAD
						.remove(PT_IL_POL_BROKER_HEAD_BEAN);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
						message);
				if (dataList_PT_IL_POL_BROKER_HEAD.size() > 0) {

					PT_IL_POL_BROKER_HEAD_BEAN = dataList_PT_IL_POL_BROKER_HEAD
							.get(0);
				} else if (dataList_PT_IL_POL_BROKER_HEAD.size() == 0) {

					addRow(null);
				}
				flag=true;
				resetAllComponent();
				PT_IL_POL_BROKER_HEAD_BEAN.setRowSelected(true);
				
				/*Newly Added By Dhinesh on 22-06-2017 */
				
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().onLoad(null);
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().setBlockFlag(true);
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().getCOMP_POBD_RATE().setDisabled(true);
				
				/*End*/
				
				
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
	
	boolean flag=false;
	
	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			if (PT_IL_POL_BROKER_HEAD_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				/* Commented by ganesh on 07-07-2017, as suggested by gaurav. This can be handled in business rule itself */
				/*ADDED BY SANKARA NARAYANAN FOR ZBILQC-1721049 ON 29/03/2017*/
				//helper.Validate_Brocker(this);
				/*END*/
				/*end*/
				
				helper.preInsert(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN(),
						getPT_IL_POL_BROKER_HEAD_BEAN(), compositeAction
								.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				System.out.println(PT_IL_POL_BROKER_HEAD_BEAN.getMAIL_ID());
				AGENT_HEIRCHY(compositeAction);
				/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 25-01-2017 */
				if(compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_BEAN().getUI_M_COMM_TYPE()==null){
					if(compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_BEAN().getPOBH_SRNO()==1){
					compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_BEAN().setUI_M_COMM_TYPE("Basic");
					}
				}
				/*End*/
				
				new CRUDHandler().executeInsert(PT_IL_POL_BROKER_HEAD_BEAN,
						CommonUtils.getConnection());
				helper.postInsert(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN(), PT_IL_POL_BROKER_HEAD_BEAN,
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("postRecord", message);
				// loadAgentHirarchy();
				dataList_PT_IL_POL_BROKER_HEAD.add(PT_IL_POL_BROKER_HEAD_BEAN);
				/*Commented by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on  26-12-2016*/
				/*helper.loadAgentHirarchy(compositeAction,this);*/
				/*End*/
				// helper.getParentsListOfAgent(PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE(),
				// compositeAction);
			} else if (PT_IL_POL_BROKER_HEAD_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN(),
						getPT_IL_POL_BROKER_HEAD_BEAN(), compositeAction
								.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_BROKER_HEAD_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("postRecord", message);
			}
			
			
			flag=true;
			
			PT_IL_POL_BROKER_HEAD_BEAN.setRowSelected(true);
			
			/*Added by Ram on 14/03/2017 for Premia Product Merging concept*/
			showShareRatio();
			/*End*/
			
			/*added by raja on 24-04-2017*/
			helper.brokerSave(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		
			helper.loadAgentHirarchy(compositeAction,this);
			
			CommonUtils.getConnection().commit();
			
			/*end*/
			
			/* Newly Added By Dhinesh on 12-7-2017 */
			compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().onLoad(null);
			compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().setBlockFlag(true);
			compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().getCOMP_POBD_RATE().setDisabled(true);
			/* End */
		} catch (Exception exc) {
			
			/*Added by Janani on 08.06.2017 for ZBILQC-1726394*/
			
			exc.printStackTrace();
			
			/*End*/
			
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_BROKER_HEAD_BEAN = (PT_IL_POL_BROKER_HEAD) dataTable
					.getRowData();
			System.out.println("myemail-->"+PT_IL_POL_BROKER_HEAD_BEAN.getMAIL_ID());
			helper.postQuery(getPT_IL_POL_BROKER_HEAD_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			PT_IL_POL_BROKER_HEAD_BEAN.setRowSelected(true);
			/*Added by saranya for ssp call id ZBILQC-1720061  on 11-02-2017*/
			System.out.println("Comm Type   :"+PT_IL_POL_BROKER_HEAD_BEAN.getUI_M_COMM_TYPE());
			
			/*Added by Ram on 13/04/2017*/
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG() != null && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG().equals("Y"))
			{
				COMP_POBH_SHARE_RATIO.setDisabled(true);
			}
			else
			{
				/*End*/
				if("Override".equalsIgnoreCase(PT_IL_POL_BROKER_HEAD_BEAN.getUI_M_COMM_TYPE()))
				{
					COMP_POBH_SHARE_RATIO.setDisabled(true);
				}else
				{
					COMP_POBH_SHARE_RATIO.setDisabled(false);
				}	
			}
			
			/*End*/
			resetAllComponent();
			compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().onLoad(null);
			compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().setBlockFlag(true);
			compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().getCOMP_POBD_RATE().setDisabled(true);
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_BROKER_HEAD> PT_IL_POL_BROKER_HEAD_ITR = dataList_PT_IL_POL_BROKER_HEAD
				.iterator();
		while (PT_IL_POL_BROKER_HEAD_ITR.hasNext()) {
			PT_IL_POL_BROKER_HEAD_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_POBH_SRNO.resetValue();
		COMP_POBH_SRNO.resetValue();
		COMP_POBH_BROKER_CODE.resetValue();
		COMP_POBH_BROKER_CODE.resetValue();
		COMP_POBH_COMM_CODE.resetValue();
		COMP_POBH_COMM_CODE.resetValue();
		COMP_POBH_COVER_CODE.resetValue();
		COMP_POBH_COVER_CODE.resetValue();
		COMP_POBH_APPLY_ON_SRNO.resetValue();
		COMP_POBH_APPLY_ON_SRNO.resetValue();
		COMP_POBH_BROKER_CURR_CODE.resetValue();
		COMP_POBH_ACTING_AGENT_YN.resetValue();
		COMP_POBH_ACTING_AGENT_YN.resetValue();
		COMP_POBH_REMARKS.resetValue();
		COMP_POBH_REMARKS.resetValue();
		COMP_POBH_BROKER_CURR_CODE.resetValue();
		COMP_UI_M_POBH_BROKER_DESC.resetValue();
		COMP_UI_M_POBH_BROKER_DESC.resetValue();
		COMP_UI_M_POBH_COVER_DESC.resetValue();
		COMP_UI_M_POBH_COVER_DESC.resetValue();
		COMP_UI_M_POBH_CURR_DESC.resetValue();
		COMP_UI_M_POBH_CURR_DESC.resetValue();
		COMP_UI_M_PS_DESC.resetValue();
		COMP_UI_M_PS_DESC.resetValue();
		COMP_BROKER_MAIL_ID.resetValue();
		/*Added by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 26-12-2016*/
		COMP_POBH_SHARE_RATIO.resetValue();
		/*End*/
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	/*Modified by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 26-12-2016*/
	public void saveRecord()throws Exception {
		String message = null;
		Double UI_M_SUM_POBH_SHARE_PERC = 0.0 ;
	/*End*/
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if(flag==true)
			{
			/*Modified by ganesh on 01-04-2016, to handle validation based on the shareration system parama */
			/*Added by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 26-12-2016*/
			int shareRatioSystemParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BRKR_SHAR")).intValue();
			if(shareRatioSystemParam == 1){
			if (dataList_PT_IL_POL_BROKER_HEAD.size()!= 0) {
				//Added to check share Ratio percentage during save
				for(PT_IL_POL_BROKER_HEAD  obj: getDataList_PT_IL_POL_BROKER_HEAD()) {
					if(obj.getPOBH_SRNO()==1){
						Double value=CommonUtils.nvl(obj.getPOBH_SHARE_PERC(), 0);
						UI_M_SUM_POBH_SHARE_PERC = UI_M_SUM_POBH_SHARE_PERC +value;
					}
				}
				if(UI_M_SUM_POBH_SHARE_PERC != null){
					if (!(UI_M_SUM_POBH_SHARE_PERC == 100.00)){
						throw new Exception("Total Share Ratio % Should be 100%");
					}
				}
			}
			}
			
			/*if(!("X".equalsIgnoreCase(CommonUtils.nvl(CallProc(compositeAction),"Y")))){*/
			helper.brokerSave(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN().getPT_IL_POL_BROKER_HEAD_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		//	}
			helper.loadAgentHirarchy(compositeAction,this);
			/*End*/
			CommonUtils.getConnection().commit();
			flag=false;
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		}
		else
		{
			throw new Exception("After Click post Or delete then click save");
		}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPOBH_ACTING_AGENT_YN() {
		if (listPOBH_ACTING_AGENT_YN.size() == 0) {
			listPOBH_ACTING_AGENT_YN.clear();
			try {
				listPOBH_ACTING_AGENT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("ListPOBH_ACTING_AGENT_YN", e.getMessage());
			}
		}
		return listPOBH_ACTING_AGENT_YN;
	}

	public void setListPOBH_ACTING_AGENT_YN(
			List<SelectItem> listPOBH_ACTING_AGENT_YN) {
		this.listPOBH_ACTING_AGENT_YN = listPOBH_ACTING_AGENT_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				
				/*Added by ganesh on 31-03-2017 to render or hide share ration & Original broker details based on the system parameters*/ 
				showShareRatio();
				/*end*/

				
				helper.whenNewBlockInstance(compositeAction);
				helper.executeQuery(compositeAction);
				if (PT_IL_POL_BROKER_HEAD_BEAN.getROWID() != null) {
					helper.postQuery(getPT_IL_POL_BROKER_HEAD_BEAN(),
							compositeAction.getDUMMY_ACTION_BEAN()
									.getDUMMY_BEAN());
				} else {
					helper.whenCreateRecord(this, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				}
				
				
				
				setBlockFlag(false);
				
				/*Newly  Added By Dhinesh on 22-06-2017 */
				
				helper.fetchPROD_BROK_CALC_MTHD(compositeAction);
				
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().onLoad(null);
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().setBlockFlag(true);
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().getCOMP_POBD_RATE().setDisabled(true);
				/*End*/
				
				
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SHOW_AGENT() {
		return COMP_UI_M_BUT_SHOW_AGENT;
	}

	public void setCOMP_UI_M_BUT_SHOW_AGENT(
			HtmlCommandButton comp_ui_m_but_show_agent) {
		COMP_UI_M_BUT_SHOW_AGENT = comp_ui_m_but_show_agent;
	}

	public void POBH_BROKER_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			String currValue = (String) value;
			helper.checkAgentValid(currValue);
			if (!(currValue.equalsIgnoreCase(PT_IL_POL_BROKER_HEAD_BEAN
					.getPOBH_BROKER_CODE()))) {
				/*
				 * moved to next t the below method by Ameen on 11-10-2017 for ZBLIFE-1446680
				 * PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_BROKER_CODE((String) value);*/
				helper.POBH_BROKER_CODE_WHEN_VALIDATE_ITEM(this,
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN(), compositeAction
								.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),currValue);
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_BROKER_CODE((String) value);
				//added by krithika
				COMP_BROKER_MAIL_ID.resetValue();
				String emailid=selectquerybrokermail  ();
				getPT_IL_POL_BROKER_HEAD_BEAN().setMAIL_ID(emailid);
//end
				/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 26-12-2016 */
				COMP_POBH_PARENT_BROKER.resetValue();
				/*End*/
				COMP_POBH_COMM_CODE.resetValue();
				COMP_UI_M_POBH_BROKER_DESC.resetValue();
				COMP_POBH_COVER_CODE.resetValue();
				COMP_POBH_BROKER_CURR_CODE.resetValue();
				COMP_POBH_APPLY_ON_SRNO.resetValue();
				COMP_UI_M_PS_DESC.resetValue();

			}

		} catch (Exception e) {
			/*added by gopi for for ZBILQC_12-JAN-2017_Issue_Flow */
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("Broker", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBH_COMM_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_COMM_CODE((String) value);
			helper.POBH_COMM_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_BROKER_HEAD_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());

			COMP_UI_M_PS_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBH_COVER_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_COVER_CODE((String) value);
			helper.POBH_COVER_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_BROKER_HEAD_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
			COMP_UI_M_POBH_COVER_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBH_APPLY_ON_SRNO_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_APPLY_ON_SRNO(
					(Integer) value);
			helper
					.POBH_APPLY_ON_SRNO_WHEN_VALIDATE_ITEM(getPT_IL_POL_BROKER_HEAD_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBH_ACTING_AGENT_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_ACTING_AGENT_YN(
					(String) value);
			helper.POBH_ACTING_AGENT_YN_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_BROKER_HEAD_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBH_BROKER_CURR_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_BROKER_CURR_CODE(
					(String) value);
			helper
					.POBH_BROKER_CURR_CODE_WHEN_VALIDATE_ITEM(getPT_IL_POL_BROKER_HEAD_BEAN());
		
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	// added by krithika 
	public String selectquerybrokermail  () throws SQLException, DBException
	{
		Connection connection = null;
		connection = CommonUtils.getConnection();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();	
		/*Modified by ganesh on 21-06-2017,ZBILQC-1725314*/
		//String cust_code=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_CUST_CODE();
		String selectedBrCode=getPT_IL_POL_BROKER_HEAD_BEAN().getPOBH_BROKER_CODE();
		System.out.println("value of cust in broker "+selectedBrCode);
		String email_id="";
		System.out.println("value of cust_code"+selectedBrCode);
		String query= "select Cust_email_id_per from pm_customer where cust_code='"+selectedBrCode+"' and cust_class IN ('AG01','FINT')";
		/*end*/
		System.out.println("query--------->"+query);
			resultSet = new CRUDHandler().executeSelectStatement(query, connection);

		while (resultSet.next()) {
			email_id=resultSet.getString("CUST_EMAIL_ID_PER");	
		}
		return email_id;
	
	}
	//end
	

	public ArrayList<LovBean> prepareSuggestionList_BROKER_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		Connection connection = null;
		ResultSet resultSet = null;
		String currentValue = (String) object;
		String query1value = null;
		String query1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'LOV_CUST' "
				+ "AND PS_CODE = 'IL_BROKER'";
		String query2 = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection);
			if (resultSet.next()) {
				query1value = resultSet.getString(1);
			}
			/*commented and added by ameen for FALCONLIFE-1344105 on 21-10-2016
			 * 
			 * query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
					+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
					+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
					+ query1value
					+ ") AND PS_CODE = 'IL_BROKER' "
					+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
					+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
					+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
					+ "(CUST_CODE LIKE ? OR  CUST_NAME LIKE ? OR  CUST_BL_NAME LIKE ?) AND ROWNUM < 25 ORDER BY 1";*/
		/*
		 * -- COMMENTED BY dhinesh on 28-02-2018 suggessted by AJAY THIS LOGIC NOT REQUIRED
		 * 
		 * 	query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
					+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
					+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
					+ query1value
					+ ") AND PS_CODE = 'IL_BROKER' "
					+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
					+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
					+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
					+ "(UPPER(CUST_CODE) LIKE UPPER(?) OR  UPPER(CUST_NAME) LIKE UPPER(?) OR  UPPER(CUST_BL_NAME) LIKE UPPER(?))"
					+ "AND CUST_AGENCY_BRANCH_CODE = ? "
					+ "AND ROWNUM < 25 ORDER BY 1";*/
			
			query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
					+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
					+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
					+ query1value
					+ ") AND PS_CODE = 'IL_BROKER' "
					+ "AND PS_TYPE ='LOV_CUST') "
					/*Added by Sivarajan on 18/02/2018 for ajoy suggestion */
					+ "AND TRUNC(SYSDATE) BETWEEN CUST_EFF_FM_DT AND CUST_EFF_TO_DT " 
					/*End*/
					+ "AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
					+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
					+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
					+ "(UPPER(CUST_CODE) LIKE UPPER(?) OR  UPPER(CUST_NAME) LIKE UPPER(?) OR  UPPER(CUST_BL_NAME) LIKE UPPER(?))"
					/*+ "AND CUST_AGENCY_BRANCH_CODE = ? "*/ /*COMMENTED BY AJAY THIS LOGIC NOT REQUIRED*/
					+ "AND ROWNUM < 25 ORDER BY 1";
			
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			
			/*Modified by Saranya on 04/04/2017
			 * 
			 * System.out.println("CommonUtils.getGlobalVariable(GLOBAL.X_DIVN_CODE)         "+CommonUtils.getGlobalVariable("GLOBAL.X_DIVN_CODE"));
			lovList = ListItemUtil.prepareSuggestionList(query2, new Object[] {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE(),
					currentValue, currentValue, currentValue,CommonUtils.getGlobalVariable("GLOBAL.X_DIVN_CODE")});*/
		
			System.out.println("CommonUtils.getGlobalVariable(GLOBAL.X_DIVN_CODE)         "+CommonUtils.getGlobalVariable("GLOBAL.M_DIVN_CODE"));
			/*
			 * 
			 * 
			 * lovList = ListItemUtil.prepareSuggestionList(query2, new Object[] {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE(),
					currentValue, currentValue, currentValue,CommonUtils.getGlobalVariable("GLOBAL.M_DIVN_CODE")});*/
			
			lovList = ListItemUtil.prepareSuggestionList(query2, new Object[] {
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE(),
					currentValue, currentValue, currentValue/*,CommonUtils.getGlobalVariable("GLOBAL.M_DIVN_CODE")  COMMENTED BY AJAY THIS LOGIC NOT REQUIRED*/});
			
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_BROKER_CURR_CODE(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BROKER_HEAD";
		String fieldName = "POBH_BROKER_CURR_CODE";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					null, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_COMM_CODE(Object object)
			throws Exception {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BROKER_HEAD";
		String fieldName = "POBH_COMM_CODE";
		Object param1 = "IL_COMM_HIER";
		/*commented and added by ameen for lov case sensitive on 21-10-2016
		 * String qry = "SELECT BCH_CODE, BCH_DESC FROM PM_BROKER_COMM_HDR WHERE "
				+ "(BCH_CODE LIKE ? OR BCH_DESC LIKE ?)";*/
		String qry = "SELECT BCH_CODE, BCH_DESC FROM PM_BROKER_COMM_HDR WHERE "
				+ "(UPPER(BCH_CODE) LIKE UPPER(?) OR UPPER(BCH_DESC) LIKE UPPER(?))";

		DUMMY dummybean = null;

		try {
			dummybean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			if (dummybean.getUI_M_IL_BROK_CALC() == 1) {
				lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
						param1, null, null, null, null, currentValue);
			} else {
				lovList = ListItemUtil.prepareSuggestionList(qry, new Object[] {
						currentValue, currentValue });
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_COVER_CODE(Object object)
			throws Exception {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BROKER_HEAD";
		String fieldName = "POBH_COVER_CODE";
		Object param1 = String.valueOf(compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
				.getPOL_SYS_ID());

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lovList;
	}

	/**
	 * Disables all components in PT_IL_POL_BROKER_HEAD_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_POBH_SRNO.setDisabled(disabled);
		COMP_POBH_BROKER_CODE.setDisabled(disabled);
		COMP_POBH_COMM_CODE.setDisabled(disabled);
		COMP_POBH_COVER_CODE.setDisabled(disabled);
		COMP_POBH_APPLY_ON_SRNO.setDisabled(disabled);
		COMP_POBH_BROKER_CURR_CODE.setDisabled(disabled);
		COMP_POBH_REMARKS.setDisabled(disabled);
		COMP_UI_M_POBH_BROKER_DESC.setDisabled(disabled);
		COMP_UI_M_POBH_COVER_DESC.setDisabled(disabled);
		COMP_UI_M_POBH_CURR_DESC.setDisabled(disabled);
		COMP_UI_M_PS_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_POBH_ACTING_AGENT_YN.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_SHOW_AGENT.setDisabled(disabled);
		COMP_BROKER_MAIL_ID.setDisabled(disabled);
		/*Added by Janani for RM018T - FSD_IL_ZB Life_007_Multiple agents on 20-12-2016 */
		COMP_POBH_SHARE_RATIO.setDisabled(disabled);
		/*end*/
	}

	/**
	 * Instantiates all components in PT_IL_POL_BROKER_HEAD_ACTION
	 */
	public void instantiateAllComponent() {
		/*Added by saranya for RM018T - FSD_IL_ZB Life_007_Multiple agents on 20-12-2016 */
		COMP_POBH_SHARE_RATIO_LABEL=new HtmlOutputLabel();
		COMP_POBH_SHARE_RATIO=new HtmlInputText();
		/*end*/
		/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 26-12-2016 */
		COMP_POBH_PARENT_BROKER=new HtmlInputText();
		COMP_UI_M_COMM_TYPE=new HtmlInputText();
		/*End*/
		// Instantiating HtmlInputText
		COMP_POBH_SRNO = new HtmlInputText();
		COMP_POBH_BROKER_CODE = new HtmlInputText();
		COMP_POBH_COMM_CODE = new HtmlInputText();
		COMP_POBH_COVER_CODE = new HtmlInputText();
		COMP_POBH_APPLY_ON_SRNO = new HtmlInputText();
		COMP_POBH_BROKER_CURR_CODE = new HtmlInputText();
		COMP_POBH_REMARKS = new HtmlInputText();
		COMP_UI_M_POBH_BROKER_DESC = new HtmlInputText();
		COMP_UI_M_POBH_COVER_DESC = new HtmlInputText();
		COMP_UI_M_POBH_CURR_DESC = new HtmlInputText();
		COMP_UI_M_PS_DESC = new HtmlInputText();
		COMP_BROKER_MAIL_ID=new HtmlInputText();
		// Instantiating HtmlOutputLabel
		COMP_POBH_SRNO_LABEL = new HtmlOutputLabel();
		COMP_POBH_BROKER_CODE_LABEL = new HtmlOutputLabel();
		COMP_POBH_COMM_CODE_LABEL = new HtmlOutputLabel();
		COMP_POBH_COVER_CODE_LABEL = new HtmlOutputLabel();
		COMP_POBH_APPLY_ON_SRNO_LABEL = new HtmlOutputLabel();
		COMP_POBH_BROKER_CURR_CODE_LABEL = new HtmlOutputLabel();
		COMP_POBH_ACTING_AGENT_YN_LABEL = new HtmlOutputLabel();
		COMP_POBH_REMARKS_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POBH_BROKER_DESC_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POBH_COVER_DESC_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POBH_CURR_DESC_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PS_DESC_LABEL = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_POBH_ACTING_AGENT_YN = new HtmlSelectOneMenu();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_SHOW_AGENT = new HtmlCommandButton();
		COMP_UI_M_BTN_BROKER_DEDUCTION =new HtmlCommandButton();
		
		/*Added by Ameen on 13-07-2018 for TOI*/
		COMP_POBH_SHARE_RATIO_IMG = new HtmlGraphicImage();
		COMP_UI_M_ORI_BTN_BROKER_DTL = new HtmlCommandButton();
		/*End*/
	}

	public String brokerDetail() {
		return "PILT002_APAC_PT_IL_POL_BROKER_DTL";
	}

	public String brokerDeduction() {
		return "PILT002_APAC_PT_IL_POL_BROKER_DEDUCTION";
	}

	public String navigationEnabled() {
		getErrorMap().clear();
		compositeAction.getWizard().setImmediate("true");
		return "";
	}

	public HtmlCommandButton getCOMP_UI_M_BTN_BROKER_DTL() {
		return COMP_UI_M_BTN_BROKER_DTL;
	}

	public void setCOMP_UI_M_BTN_BROKER_DTL(
			HtmlCommandButton comp_ui_m_btn_broker_dtl) {
		COMP_UI_M_BTN_BROKER_DTL = comp_ui_m_btn_broker_dtl;
	}

	public HtmlOutputLabel getCOMP_POBH_FC_COMMISSION_LABEL() {
		return COMP_POBH_FC_COMMISSION_LABEL;
	}

	public void setCOMP_POBH_FC_COMMISSION_LABEL(
			HtmlOutputLabel comp_pobh_fc_commission_label) {
		COMP_POBH_FC_COMMISSION_LABEL = comp_pobh_fc_commission_label;
	}

	public HtmlInputText getCOMP_POBH_FC_COMMISSION() {
		return COMP_POBH_FC_COMMISSION;
	}

	public void setCOMP_POBH_FC_COMMISSION(HtmlInputText comp_pobh_fc_commission) {
		COMP_POBH_FC_COMMISSION = comp_pobh_fc_commission;
	}

	public HtmlOutputLabel getCOMP_POBH_LC_COMMISSION_LABEL() {
		return COMP_POBH_LC_COMMISSION_LABEL;
	}

	public void setCOMP_POBH_LC_COMMISSION_LABEL(
			HtmlOutputLabel comp_pobh_lc_commission_label) {
		COMP_POBH_LC_COMMISSION_LABEL = comp_pobh_lc_commission_label;
	}

	public HtmlInputText getCOMP_POBH_LC_COMMISSION() {
		return COMP_POBH_LC_COMMISSION;
	}

	public void setCOMP_POBH_LC_COMMISSION(HtmlInputText comp_pobh_lc_commission) {
		COMP_POBH_LC_COMMISSION = comp_pobh_lc_commission;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_OVERRIDE_COMM() {
		return COMP_UI_M_BUT_OVERRIDE_COMM;
	}

	public void setCOMP_UI_M_BUT_OVERRIDE_COMM(
			HtmlAjaxCommandButton comp_ui_m_but_override_comm) {
		COMP_UI_M_BUT_OVERRIDE_COMM = comp_ui_m_but_override_comm;
	}

	public String overrideCommisionAction() {
		try {
			helper.getParentsListOfAgent(PT_IL_POL_BROKER_HEAD_BEAN
					.getPOBH_BROKER_CODE(), compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public HtmlCommandButton getCOMP_UI_M_BTN_BROKER_DEDUCTION() {
		return COMP_UI_M_BTN_BROKER_DEDUCTION;
	}

	public void setCOMP_UI_M_BTN_BROKER_DEDUCTION(
			HtmlCommandButton comp_ui_m_btn_broker_deduction) {
		COMP_UI_M_BTN_BROKER_DEDUCTION = comp_ui_m_btn_broker_deduction;
	}

	//added by saranya on 8-4-16 for email capture field
	public void  mailIdAction(ActionEvent event) {
		      System.out.println("Ënter mailIdAction");
				UIInput input = (UIInput) event.getComponent().getParent();
				System.out.println( (String)input.getSubmittedValue());
				getPT_IL_POL_BROKER_HEAD_BEAN().setMAIL_ID((String) input.getSubmittedValue());
				System.out.println("Email value onChange  "+getPT_IL_POL_BROKER_HEAD_BEAN().getMAIL_ID());
				//ErrorHelpUtil.validate(input, getErrorMap());

	}
	/*Added by saranya for  FSD_IL_ZB Life_007_Multiple agents on 20-01-2017 */
	String M_POBH_AGENT_HEIRCHY=null;
	public String AGENT_HEIRCHY(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		String query = "SELECT MAX(NVL(POBH_AGENT_HEIRCHY,0)) FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ? AND POBH_SRNO=1";
		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { policyBean.getPOL_SYS_ID()});
			if(rs.next()) {
				M_POBH_AGENT_HEIRCHY = CommonUtils.nvl(rs.getString(1),"0");
				System.out.println("M_POBH_AGENT_HEIRCHY  :"+M_POBH_AGENT_HEIRCHY);
				PT_IL_POL_BROKER_HEAD_BEAN.setPOBH_AGENT_HEIRCHY(String.valueOf((Integer.parseInt(M_POBH_AGENT_HEIRCHY)+1)));
				System.out.println("PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_AGENT_HEIRCHY()  :"+PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_AGENT_HEIRCHY());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return M_POBH_AGENT_HEIRCHY;
	}
	/*end*/
	
	/*public String CallProc(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		String value=null;
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		Connection connection = null;
		ResultSet rs = null;
		String query = "SELECT 'X' FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ? AND POBH_BROKER_CODE =?";
		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[] { policyBean.getPOL_SYS_ID(),PT_IL_POL_BROKER_HEAD_BEAN.getPOBH_BROKER_CODE()});
			while(rs.next()) {
				value= rs.getString(1);
				System.out.println("value  :"+value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value; 
		
	}*/
	
	/*Added by saritha on 20-02-2017 for RM018T - DEV_IL_ZB Life_027-Replacement Policy*/
	private HtmlCommandButton COMP_UI_M_ORI_BTN_BROKER_DTL;

	public HtmlCommandButton getCOMP_UI_M_ORI_BTN_BROKER_DTL() {
		return COMP_UI_M_ORI_BTN_BROKER_DTL;
	}

	public void setCOMP_UI_M_ORI_BTN_BROKER_DTL(
			HtmlCommandButton cOMP_UI_M_ORI_BTN_BROKER_DTL) {
		COMP_UI_M_ORI_BTN_BROKER_DTL = cOMP_UI_M_ORI_BTN_BROKER_DTL;
	}
	
	public String BrokerDetails() {
		return "PILT002_APAC_PT_IL_POL_BROKER_DETAILS";
	}
	
	/*End*/
	
	/*Added by Ram on 14/03/2017 for Premia Product Merging concept*/
	public void showShareRatio() throws Exception
	{
		String ratioViewQuery = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_BRKR_SHAR'";
		ResultSet ratioViewRS = null;
		try
		{
		ratioViewRS = new CRUDHandler().executeSelectStatement(ratioViewQuery, CommonUtils.getConnection());
		int PS_VALUE = 0;
		while(ratioViewRS.next())
		{
			PS_VALUE = ratioViewRS.getInt(1);
		}
		if(PS_VALUE == 1)
		{
			COMP_POBH_SHARE_RATIO.setRendered(true);
			COMP_POBH_SHARE_RATIO_LABEL.setRendered(true);
			
			/*Added by Janani for issue reported by Sivaram on 11.04.2017*/
			
			/*COMP_POBH_SHARE_RATIO_IMG.setRendered(false);*/
			COMP_POBH_SHARE_RATIO_IMG.setRendered(true);
			
			/*End*/
			
			
			/* Added by ganesh on 31-03-2017, Original broker detail button display*/
			COMP_UI_M_ORI_BTN_BROKER_DTL.setRendered(true);
			/*end*/
			

		}
		else
		{
			COMP_POBH_SHARE_RATIO.setRendered(false);
			COMP_POBH_SHARE_RATIO_LABEL.setRendered(false);
			COMP_POBH_SHARE_RATIO_IMG.setRendered(false);
			
			/* Added by ganesh on 31-03-2017, Original broker detail button display*/
			COMP_UI_M_ORI_BTN_BROKER_DTL.setRendered(false);
			/*end*/
			

		}
		COMP_POBH_SHARE_RATIO.resetValue();
		
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}
	
	private HtmlGraphicImage COMP_POBH_SHARE_RATIO_IMG;

	public HtmlGraphicImage getCOMP_POBH_SHARE_RATIO_IMG() {
		return COMP_POBH_SHARE_RATIO_IMG;
	}

	public void setCOMP_POBH_SHARE_RATIO_IMG(
			HtmlGraphicImage cOMP_POBH_SHARE_RATIO_IMG) {
		COMP_POBH_SHARE_RATIO_IMG = cOMP_POBH_SHARE_RATIO_IMG;
	}
	/*End*/
}
