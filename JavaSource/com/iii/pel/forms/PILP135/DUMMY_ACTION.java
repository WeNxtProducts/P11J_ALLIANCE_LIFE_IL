package com.iii.pel.forms.PILP135;


import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.ajax4jsf.component.html.HtmlAjaxCommandLink;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILP203.PT_IL_POL_BROKER_HEAD_ORIGINAL;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_CHARGE;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_MED_EXAM_DTL;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_MED_EXAM_DTL_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction  {
	
	/*Added by saritha on 04-01-2017 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/	
	
	public PILP135_COMPOSITE_ACTION compositeAction;
	private DUMMY_HELPER helper;
	/*private PILP135_DUMMY DUMMY_BEAN;*/
	
	private DUMMY DUMMY_BEAN;
	
	public PILP135_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILP135_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public DUMMY_HELPER getHelper() {
		return helper;
	}
	public void setHelper(DUMMY_HELPER helper) {
		this.helper = helper;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}
	public void setDUMMY_BEAN(DUMMY dUMMY_BEAN) {
		DUMMY_BEAN = dUMMY_BEAN;
	}

	private UIData dataTable;

	private ArrayList<DUMMY> dataList_DUMMY = new ArrayList<DUMMY>();
	
	
	public ArrayList<DUMMY> getDataList_DUMMY() {
		return dataList_DUMMY;
	}
	public void setDataList_DUMMY(ArrayList<DUMMY> dataList_DUMMY) {
		this.dataList_DUMMY = dataList_DUMMY;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	private HtmlOutputLabel COMP_UI_M_EMP_CODE_LABEL;
	
	public HtmlOutputLabel getCOMP_UI_M_EMP_CODE_LABEL() {
		return COMP_UI_M_EMP_CODE_LABEL;
	}
	public void setCOMP_UI_M_EMP_CODE_LABEL(HtmlOutputLabel cOMP_UI_M_EMP_CODE_LABEL) {
		COMP_UI_M_EMP_CODE_LABEL = cOMP_UI_M_EMP_CODE_LABEL;
	}

	private HtmlInputText COMP_UI_M_EMP_CODE;

	public HtmlInputText getCOMP_UI_M_EMP_CODE() {
		return COMP_UI_M_EMP_CODE;
	}
	public void setCOMP_UI_M_EMP_CODE(HtmlInputText cOMP_UI_M_EMP_CODE) {
		COMP_UI_M_EMP_CODE = cOMP_UI_M_EMP_CODE;
	}

	private HtmlInputText COMP_UI_M_EMP_DESC;
	public HtmlInputText getCOMP_UI_M_EMP_DESC() {
		return COMP_UI_M_EMP_DESC;
	}
	public void setCOMP_UI_M_EMP_DESC(HtmlInputText cOMP_UI_M_EMP_DESC) {
		COMP_UI_M_EMP_DESC = cOMP_UI_M_EMP_DESC;
	}

	private HtmlCommandButton COMP_PL_FETCH;
	
	public HtmlCommandButton getCOMP_PL_FETCH() {
		return COMP_PL_FETCH;
	}
	public void setCOMP_PL_FETCH(HtmlCommandButton cOMP_PL_FETCH) {
		COMP_PL_FETCH = cOMP_PL_FETCH;
	}

	private HtmlOutputLabel COMP_UI_EMP_FRZ_FLAG_LABEL;
	
	public HtmlOutputLabel getCOMP_UI_EMP_FRZ_FLAG_LABEL() {
		return COMP_UI_EMP_FRZ_FLAG_LABEL;
	}
	public void setCOMP_UI_EMP_FRZ_FLAG_LABEL(
			HtmlOutputLabel cOMP_UI_EMP_FRZ_FLAG_LABEL) {
		COMP_UI_EMP_FRZ_FLAG_LABEL = cOMP_UI_EMP_FRZ_FLAG_LABEL;
	}
	
	private HtmlSelectBooleanCheckbox COMP_UI_EMP_FRZ_FLAG;
	public HtmlSelectBooleanCheckbox getCOMP_UI_EMP_FRZ_FLAG() {
		return COMP_UI_EMP_FRZ_FLAG;
	}
	public void setCOMP_UI_EMP_FRZ_FLAG(
			HtmlSelectBooleanCheckbox cOMP_UI_EMP_FRZ_FLAG) {
		COMP_UI_EMP_FRZ_FLAG = cOMP_UI_EMP_FRZ_FLAG;
	}
	
	
	public void instantiateAllComponent() {
		//Instantiating HtmlOutputLabel
		COMP_UI_M_EMP_CODE_LABEL=new HtmlOutputLabel();
		//Instantiating HtmlInputText
		COMP_UI_M_EMP_CODE =new HtmlInputText();
		COMP_UI_M_EMP_DESC =new HtmlInputText();
		//Instantiating HtmlAjaxCommandButton
		COMP_PL_FETCH=new HtmlCommandButton();
		
		/*Added by saritha on 22-01-2018 for Stoping of APL Paid up lapse process for stop order/debit order customer for the selected duration*/
		COMP_POL_LAPS_OVR_FRM_DT_LABEL = new HtmlOutputLabel();
		COMP_POL_LAPS_OVR_TO_DT_LABEL  = new HtmlOutputLabel();
		COMP_POL_LAPS_OVR_FRM_DT       = new HtmlCalendar();
		COMP_POL_LAPS_OVR_TO_DT        = new HtmlCalendar();
		COMP_PL_FETCH                  = new HtmlCommandButton();
		COMP_PL_UPDATE                 = new HtmlCommandButton();
		COMP_PL_SAVE                   = new HtmlAjaxCommandLink();
		COMP_PL_SAVE_BUTTON            = new HtmlCommandButton();
		/*End*/
		
	}
	
	
	//Disables all components
	 
	 public void disableAllComponent(boolean disabled) {
		 
	 COMP_UI_M_EMP_CODE.setDisabled(disabled); 
	 COMP_UI_M_EMP_DESC.setDisabled(disabled);
	 COMP_PL_FETCH.setDisabled(disabled);
	 
	 /*Added by saritha on 22-01-2018 for Stoping of APL Paid up lapse process for stop order/debit order customer for the selected duration*/
	 COMP_POL_LAPS_OVR_FRM_DT.setDisabled(disabled);
	 COMP_POL_LAPS_OVR_TO_DT.setDisabled(disabled);
	 COMP_PL_UPDATE.setDisabled(disabled);
	 COMP_PL_SAVE.setDisabled(disabled);
	 COMP_PL_SAVE_BUTTON.setDisabled(disabled);
	 /*End*/
	 
	 }
	
	 private List<SelectItem> listPOL_LAPS_OVR_YN = new ArrayList<SelectItem>();

	 public List<SelectItem> getListPOL_LAPS_OVR_YN() {
		return listPOL_LAPS_OVR_YN;
	}
	public void setListPOL_LAPS_OVR_YN(List<SelectItem> listPOL_LAPS_OVR_YN) {
		this.listPOL_LAPS_OVR_YN = listPOL_LAPS_OVR_YN;
	}
	public DUMMY_ACTION()
		{
			DUMMY_BEAN=new DUMMY();
			helper = new DUMMY_HELPER();
			instantiateAllComponent();
			preparDropDownList();
		}

	public void preparDropDownList() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			listPOL_LAPS_OVR_YN = ListItemUtil.getDropDownListValue(connection,
					"PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_LAPS_OVR_YN", "YESNO");

		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}

	}
		
		public void resetAllComponents(){
			COMP_UI_M_EMP_CODE.resetValue();
			COMP_UI_M_EMP_DESC.resetValue();
			COMP_POL_LAPS_OVR_FRM_DT.resetValue();
			COMP_POL_LAPS_OVR_TO_DT.resetValue();
		}

		private void resetSelectedRow() {
			Iterator<DUMMY> DUMMY = dataList_DUMMY.iterator();
			while (DUMMY.hasNext()) {
				DUMMY.next().setRowSelected(false);
			}
		}
		public void displayRecords() {
			CommonUtils.clearMaps(this);
			try {
				resetSelectedRow();
				DUMMY_BEAN = (DUMMY) dataTable.getRowData();
				DUMMY_BEAN.setRowSelected(true);
				resetAllComponents();
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
				getErrorMap().put("displayRecords", exc.getMessage());
			}
		}
	 
	
	public void onLoad(PhaseEvent event){
		if(isBlockFlag()){
			System.out.println("Onload is called");
			setBlockFlag(false);
		}
	}
	
	public ArrayList<LovBean> prepareSuggestionList_EMP_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILP135";
		String blockName = "DUMMY";
		String fieldName = "M_EMP_CODE";
		Object param1 = "Y";

		try {
			System.out.println("inside lov query");
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
	
	public void saveRecord() {
		/*CommonUtils.clearMaps(this);*/
		try {
			
			if (isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	
	/*Added by saritha on 19-07-2017 for ssp call id ZBILQC-1732158*/
	public void saveRecord(ActionEvent ae) {
		/*CommonUtils.clearMaps(this);*/
		try {
			
			if (isUPDATE_ALLOWED()) {
				/*Validation handled by ganesh on 26-01-2018 as suggestd by ajoy from onsite*/
				validateDate(compositeAction);	
				/*end*/
				helper.PRE_UPDATE(compositeAction);
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	/*End*/
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateUI_M_EMP_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		String UI_M_EMP_CODE = (String) value;
		try {
		System.out.println("validator is called");
		getDUMMY_BEAN().setUI_M_EMP_CODE(UI_M_EMP_CODE);
		System.out.println("Employer code**************"+DUMMY_BEAN.getUI_M_EMP_CODE());
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void setPOL_LAPS_OVR_YN_Editable(ActionEvent event) {
		try
		{
		CommonUtils.clearMaps(this);
		String flag=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		DUMMY_BEAN=(DUMMY)dataList_DUMMY.get(currentIndex);
		DUMMY_BEAN.setPOL_LAPS_OVR_YN(flag);
		
		/*Added by saritha on 22-01-2018 for Stoping of APL Paid up lapse process for stop order/debit order customer for the selected duration*/
		if("N".equalsIgnoreCase(DUMMY_BEAN.getPOL_LAPS_OVR_YN())){
			DUMMY_BEAN.setPOL_LAPS_OVR_FRM_DT(null);
			DUMMY_BEAN.setPOL_LAPS_OVR_TO_DT(null);
		
		}
		/*End*/
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("postRecord", e.getMessage());	
		}
	}
	
	/*Modified by saritha on 19-07-2017 for ssp call id ZBILQC-1732158*/ 
	public void setPOL_LAPS_OVR_FRM_DT_Editable(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try
		{
			
		UIInput input = (UIInput) event.getComponent().getParent();
		String inputdate= (String)input.getSubmittedValue();
		Date dat = new SimpleDateFormat("dd/MM/yyyy").parse(inputdate);
		System.out.println("inputdate ::" + inputdate + "::dat ::" +dat);
		int currentIndex=this.dataTable.getRowIndex();
		//DUMMY_BEAN=(DUMMY)dataList_DUMMY.get(currentIndex);
		DUMMY_BEAN.setPOL_LAPS_OVR_FRM_DT(dat);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("postRecord", e.getMessage());	
		}

	}
	
	public void setPOL_LAPS_OVR_TO_DT_Editable(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try
		{
			
		UIInput input = (UIInput) event.getComponent().getParent();
		String inputdate= (String)input.getSubmittedValue();
		Date dat = new SimpleDateFormat("dd/MM/yyyy").parse(inputdate);
		System.out.println("inputdate ::" + inputdate + "::dat ::" +dat);
		int currentIndex=this.dataTable.getRowIndex();
		DUMMY_BEAN.setPOL_LAPS_OVR_TO_DT(dat);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("postRecord", e.getMessage());	
		}

	}
	
	/*End*/
	
	public void whenButtonPressedFetch(ActionEvent event)
	{

		/*Added by saritha on 22-01-2018 for Stoping of APL Paid up lapse process for stop order/debit order customer for the selected duration*/
		
		ArrayList<OracleParameter> pList = new ArrayList<OracleParameter>();
		Integer P_SEQ_NO=0;
		try {

			pList = helper.callP_EMP_STP_ODR(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_EMP_CODE(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getPOL_LAPS_OVR_FRM_DT(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getPOL_LAPS_OVR_TO_DT(),P_SEQ_NO);
			if(pList!=null && !pList.isEmpty()){

				DUMMY_BEAN.setESP_SYS_ID((Integer) pList.get(0).getValueObject());

			}

			System.out.println("OUT PARAMETER sysid ================>>>>>>>>>>>" + DUMMY_BEAN.getESP_SYS_ID());

			helper.fetch_when_validate_item(compositeAction, DUMMY_BEAN.getESP_SYS_ID());
			 List<DUMMY> dataList =compositeAction.getDUMMY_ACTION_BEAN().getDataList_DUMMY();
						 if(dataList!=null && dataList.size() > 0){
							 DUMMY DUMMY_BEAN = dataList.get(0);
							 DUMMY_BEAN.setRowSelected(true);
							 compositeAction.getDUMMY_ACTION_BEAN().setDUMMY_BEAN(DUMMY_BEAN);
						}
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_PL_UPDATE().setDisabled(false);

			/*End*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*End*/
	
	
	/*Added by saritha on 22-01-2018 for Stoping of APL Paid up lapse process for stop order/debit order customer for the selected duration*/
	
	private HtmlOutputLabel COMP_POL_LAPS_OVR_FRM_DT_LABEL;
	private HtmlCalendar COMP_POL_LAPS_OVR_FRM_DT;
	private HtmlOutputLabel COMP_POL_LAPS_OVR_TO_DT_LABEL;
	private HtmlCalendar COMP_POL_LAPS_OVR_TO_DT;
	private HtmlCommandButton COMP_PL_UPDATE;
	private HtmlCommandButton COMP_PL_SAVE_BUTTON;
	

	private HtmlAjaxCommandLink COMP_PL_SAVE;
	
	public HtmlOutputLabel getCOMP_POL_LAPS_OVR_FRM_DT_LABEL() {
		return COMP_POL_LAPS_OVR_FRM_DT_LABEL;
	}
	public void setCOMP_POL_LAPS_OVR_FRM_DT_LABEL(
			HtmlOutputLabel cOMP_POL_LAPS_OVR_FRM_DT_LABEL) {
		COMP_POL_LAPS_OVR_FRM_DT_LABEL = cOMP_POL_LAPS_OVR_FRM_DT_LABEL;
	}
	
	public HtmlCalendar getCOMP_POL_LAPS_OVR_FRM_DT() {
		return COMP_POL_LAPS_OVR_FRM_DT;
	}
	public void setCOMP_POL_LAPS_OVR_FRM_DT(HtmlCalendar cOMP_POL_LAPS_OVR_FRM_DT) {
		COMP_POL_LAPS_OVR_FRM_DT = cOMP_POL_LAPS_OVR_FRM_DT;
	}
	
	public HtmlOutputLabel getCOMP_POL_LAPS_OVR_TO_DT_LABEL() {
		return COMP_POL_LAPS_OVR_TO_DT_LABEL;
	}
	public void setCOMP_POL_LAPS_OVR_TO_DT_LABEL(
			HtmlOutputLabel cOMP_POL_LAPS_OVR_TO_DT_LABEL) {
		COMP_POL_LAPS_OVR_TO_DT_LABEL = cOMP_POL_LAPS_OVR_TO_DT_LABEL;
	}
	
	public HtmlCalendar getCOMP_POL_LAPS_OVR_TO_DT() {
		return COMP_POL_LAPS_OVR_TO_DT;
	}
	public void setCOMP_POL_LAPS_OVR_TO_DT(HtmlCalendar cOMP_POL_LAPS_OVR_TO_DT) {
		COMP_POL_LAPS_OVR_TO_DT = cOMP_POL_LAPS_OVR_TO_DT;
	}
	
	public HtmlAjaxCommandLink getCOMP_PL_SAVE() {
		return COMP_PL_SAVE;
	}
	public void setCOMP_PL_SAVE(HtmlAjaxCommandLink cOMP_PL_SAVE) {
		COMP_PL_SAVE = cOMP_PL_SAVE;
	}

	public HtmlCommandButton getCOMP_PL_UPDATE() {
		return COMP_PL_UPDATE;
	}
	public void setCOMP_PL_UPDATE(HtmlCommandButton cOMP_PL_UPDATE) {
		COMP_PL_UPDATE = cOMP_PL_UPDATE;
	}

	public HtmlCommandButton getCOMP_PL_SAVE_BUTTON() {
		return COMP_PL_SAVE_BUTTON;
	}
	public void setCOMP_PL_SAVE_BUTTON(HtmlCommandButton cOMP_PL_SAVE_BUTTON) {
		COMP_PL_SAVE_BUTTON = cOMP_PL_SAVE_BUTTON;
	}
	
	public void validatePOL_LAPS_OVR_FRM_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);

		try {
			getDUMMY_BEAN().setPOL_LAPS_OVR_FRM_DT((Date) value);
			/*Added by ganesh for handling date validation on 26-01-2018 as suggested by ajoy*/
			setPOL_LAPS_OVR_MAIN_FRM_DT((Date) value);
			/*end*/

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void validatePOL_LAPS_OVR_TO_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);

		try {
			getDUMMY_BEAN().setPOL_LAPS_OVR_TO_DT((Date) value);
			/*Added by ganesh for handling date validation on 26-01-2018 as suggested by ajoy*/
			setPOL_LAPS_OVR_MAIN_TO_DT((Date) value);
			/*end*/

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	
	public void whenButtonPressedUpdate(ActionEvent event)
	{

		ArrayList<OracleParameter> procList = new ArrayList<OracleParameter>();
		String P_UPD_FLG="";

		try {
			procList = helper.callP_EMP_STP_ODR_UPD(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_EMP_CODE(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getESP_SYS_ID(),P_UPD_FLG);

			CommonUtils.getConnection().commit();
		
			compositeAction.getDUMMY_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Records Updated Successfully");
			
			if(procList!=null && !procList.isEmpty()){
				if("Y".equalsIgnoreCase(procList.get(0).getValueObject().toString())){
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_PL_UPDATE().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_PL_SAVE().setDisabled(true);
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_PL_FETCH().setDisabled(true);

				}
			}
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());

			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, error);
			getErrorMap().put("SAVE", error);
		}

	}

	/*End*/
	
	
	private Date POL_LAPS_OVR_MAIN_FRM_DT;
	private Date POL_LAPS_OVR_MAIN_TO_DT;
	public Date getPOL_LAPS_OVR_MAIN_FRM_DT() {
		return POL_LAPS_OVR_MAIN_FRM_DT;
	}
	public void setPOL_LAPS_OVR_MAIN_FRM_DT(Date pOL_LAPS_OVR_MAIN_FRM_DT) {
		POL_LAPS_OVR_MAIN_FRM_DT = pOL_LAPS_OVR_MAIN_FRM_DT;
	}
	public Date getPOL_LAPS_OVR_MAIN_TO_DT() {
		return POL_LAPS_OVR_MAIN_TO_DT;
	}
	public void setPOL_LAPS_OVR_MAIN_TO_DT(Date pOL_LAPS_OVR_MAIN_TO_DT) {
		POL_LAPS_OVR_MAIN_TO_DT = pOL_LAPS_OVR_MAIN_TO_DT;
	}

	/*Validation handled by ganesh on 26-01-2018 as suggestd by ajoy from onsite*/
	private void validateDate(PILP135_COMPOSITE_ACTION compositeAction)
			throws Exception {

		DUMMY_ACTION DUMMY_ACTION_BEAN = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY DUMMY_BEAN = DUMMY_ACTION_BEAN.getDUMMY_BEAN();
		if (!(CommonUtils.dateGreaterthenOrEqualTo(
				DUMMY_BEAN.getPOL_LAPS_OVR_FRM_DT(),
				DUMMY_ACTION_BEAN.getPOL_LAPS_OVR_MAIN_FRM_DT()) && CommonUtils
				.dateLessthenOrEqualTo(DUMMY_BEAN.getPOL_LAPS_OVR_FRM_DT(),
						DUMMY_ACTION_BEAN.getPOL_LAPS_OVR_MAIN_TO_DT()))) {

			throw new Exception("Lapsation Override From Date should between "
					+ CommonUtils.dateToStringFormat(DUMMY_ACTION_BEAN.getPOL_LAPS_OVR_MAIN_FRM_DT()) + " and"
					+ CommonUtils.dateToStringFormat(DUMMY_ACTION_BEAN.getPOL_LAPS_OVR_MAIN_TO_DT()));

		}
		
		if (!(CommonUtils.dateGreaterthenOrEqualTo(
				DUMMY_BEAN.getPOL_LAPS_OVR_TO_DT(),
				DUMMY_ACTION_BEAN.getPOL_LAPS_OVR_MAIN_FRM_DT()) && CommonUtils
				.dateLessthenOrEqualTo(DUMMY_BEAN.getPOL_LAPS_OVR_TO_DT(),
						DUMMY_ACTION_BEAN.getPOL_LAPS_OVR_MAIN_TO_DT()))) {

			throw new Exception("Lapsation Override To Date should between "
					+ CommonUtils.dateToStringFormat(DUMMY_ACTION_BEAN.getPOL_LAPS_OVR_MAIN_FRM_DT()) + " and"
					+ CommonUtils.dateToStringFormat(DUMMY_ACTION_BEAN.getPOL_LAPS_OVR_MAIN_TO_DT()));

		}

	}
	/*end*/
	
}
