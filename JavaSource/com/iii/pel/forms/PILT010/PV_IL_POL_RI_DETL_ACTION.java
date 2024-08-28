package com.iii.pel.forms.PILT010;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlSuggestionBox;
import org.richfaces.renderkit.html.iconimages.DisabledCalendarIcon;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class PV_IL_POL_RI_DETL_ACTION extends CommonAction {

	private HtmlOutputText COMP_B_RI_CLOSE;
	
	private HtmlOutputLabel COMP_RD_POL_NO_LABEL;

	private HtmlInputText COMP_RD_POL_NO;

	private HtmlOutputLabel COMP_RD_END_NO_LABEL;

	private HtmlInputText COMP_RD_END_NO;

	private HtmlOutputLabel COMP_RD_YEAR_LABEL;

	private HtmlInputText COMP_RD_YEAR;

	private HtmlOutputLabel COMP_POL_CLASS_CODE_LABEL;

	private HtmlInputText COMP_POL_CLASS_CODE;

	private HtmlOutputLabel COMP_POL_PROD_CODE_LABEL;

	private HtmlInputText COMP_POL_PROD_CODE;

	private HtmlOutputLabel COMP_RD_UW_YEAR_LABEL;

	private HtmlInputText COMP_RD_UW_YEAR;

	private HtmlOutputLabel COMP_POL_PERIOD_LABEL;

	private HtmlInputText COMP_POL_PERIOD;

	private HtmlOutputLabel COMP_POL_CONT_CODE_LABEL;

	private HtmlInputText COMP_POL_CONT_CODE;

	private HtmlOutputLabel COMP_POL_START_DT_LABEL;

	private HtmlCalendar COMP_POL_START_DT;

	private HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_POL_EXPIRY_DT;
	
	private HtmlOutputLabel COMP_RD_END_NO_IDX_LABEL;
	
	private HtmlInputText COMP_RD_END_NO_IDX;
	
	private HtmlCommandButton COMP_RI_BUT_CLOSE;

	private PV_IL_POL_RI_DETL PV_IL_POL_RI_DETL_BEAN;
	
	public PILT010_COMPOSITE_ACTION compositeAction;
	
	private List<PT_IL_RI_DETL> dataList_PV_IL_RI_DETL = new ArrayList<PT_IL_RI_DETL>();
	
	private UIData dataTable;
	
	private boolean onLoadFlag = false;
	
	private List<String> policyRowIdList = null;
	
	PV_IL_POL_RI_DETL_HELPER helper;
	
	public PV_IL_POL_RI_DETL_ACTION() {
		PV_IL_POL_RI_DETL_BEAN = new PV_IL_POL_RI_DETL();
		helper = new PV_IL_POL_RI_DETL_HELPER();
		policyRowIdList = new ArrayList<String>();
	}

	public HtmlOutputLabel getCOMP_RD_POL_NO_LABEL() {
		return COMP_RD_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_RD_POL_NO() {
		return COMP_RD_POL_NO;
	}

	public void setCOMP_RD_POL_NO_LABEL(HtmlOutputLabel COMP_RD_POL_NO_LABEL) {
		this.COMP_RD_POL_NO_LABEL = COMP_RD_POL_NO_LABEL;
	}

	public void setCOMP_RD_POL_NO(HtmlInputText COMP_RD_POL_NO) {
		this.COMP_RD_POL_NO = COMP_RD_POL_NO;
	}

	public HtmlOutputLabel getCOMP_RD_END_NO_LABEL() {
		return COMP_RD_END_NO_LABEL;
	}

	public HtmlInputText getCOMP_RD_END_NO() {
		return COMP_RD_END_NO;
	}

	public void setCOMP_RD_END_NO_LABEL(HtmlOutputLabel COMP_RD_END_NO_LABEL) {
		this.COMP_RD_END_NO_LABEL = COMP_RD_END_NO_LABEL;
	}

	public void setCOMP_RD_END_NO(HtmlInputText COMP_RD_END_NO) {
		this.COMP_RD_END_NO = COMP_RD_END_NO;
	}

	public HtmlOutputLabel getCOMP_RD_YEAR_LABEL() {
		return COMP_RD_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_RD_YEAR() {
		return COMP_RD_YEAR;
	}

	public void setCOMP_RD_YEAR_LABEL(HtmlOutputLabel COMP_RD_YEAR_LABEL) {
		this.COMP_RD_YEAR_LABEL = COMP_RD_YEAR_LABEL;
	}

	public void setCOMP_RD_YEAR(HtmlInputText COMP_RD_YEAR) {
		this.COMP_RD_YEAR = COMP_RD_YEAR;
	}

	public HtmlOutputLabel getCOMP_POL_CLASS_CODE_LABEL() {
		return COMP_POL_CLASS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CLASS_CODE() {
		return COMP_POL_CLASS_CODE;
	}

	public void setCOMP_POL_CLASS_CODE_LABEL(HtmlOutputLabel COMP_POL_CLASS_CODE_LABEL) {
		this.COMP_POL_CLASS_CODE_LABEL = COMP_POL_CLASS_CODE_LABEL;
	}

	public void setCOMP_POL_CLASS_CODE(HtmlInputText COMP_POL_CLASS_CODE) {
		this.COMP_POL_CLASS_CODE = COMP_POL_CLASS_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_PROD_CODE_LABEL() {
		return COMP_POL_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_PROD_CODE() {
		return COMP_POL_PROD_CODE;
	}

	public void setCOMP_POL_PROD_CODE_LABEL(HtmlOutputLabel COMP_POL_PROD_CODE_LABEL) {
		this.COMP_POL_PROD_CODE_LABEL = COMP_POL_PROD_CODE_LABEL;
	}

	public void setCOMP_POL_PROD_CODE(HtmlInputText COMP_POL_PROD_CODE) {
		this.COMP_POL_PROD_CODE = COMP_POL_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_RD_UW_YEAR_LABEL() {
		return COMP_RD_UW_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_RD_UW_YEAR() {
		return COMP_RD_UW_YEAR;
	}

	public void setCOMP_RD_UW_YEAR_LABEL(HtmlOutputLabel COMP_RD_UW_YEAR_LABEL) {
		this.COMP_RD_UW_YEAR_LABEL = COMP_RD_UW_YEAR_LABEL;
	}

	public void setCOMP_RD_UW_YEAR(HtmlInputText COMP_RD_UW_YEAR) {
		this.COMP_RD_UW_YEAR = COMP_RD_UW_YEAR;
	}

	public HtmlOutputLabel getCOMP_POL_PERIOD_LABEL() {
		return COMP_POL_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_POL_PERIOD() {
		return COMP_POL_PERIOD;
	}

	public void setCOMP_POL_PERIOD_LABEL(HtmlOutputLabel COMP_POL_PERIOD_LABEL) {
		this.COMP_POL_PERIOD_LABEL = COMP_POL_PERIOD_LABEL;
	}

	public void setCOMP_POL_PERIOD(HtmlInputText COMP_POL_PERIOD) {
		this.COMP_POL_PERIOD = COMP_POL_PERIOD;
	}

	public HtmlOutputLabel getCOMP_POL_CONT_CODE_LABEL() {
		return COMP_POL_CONT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CONT_CODE() {
		return COMP_POL_CONT_CODE;
	}

	public void setCOMP_POL_CONT_CODE_LABEL(HtmlOutputLabel COMP_POL_CONT_CODE_LABEL) {
		this.COMP_POL_CONT_CODE_LABEL = COMP_POL_CONT_CODE_LABEL;
	}

	public void setCOMP_POL_CONT_CODE(HtmlInputText COMP_POL_CONT_CODE) {
		this.COMP_POL_CONT_CODE = COMP_POL_CONT_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_START_DT_LABEL() {
		return COMP_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_START_DT() {
		return COMP_POL_START_DT;
	}

	public void setCOMP_POL_START_DT_LABEL(HtmlOutputLabel COMP_POL_START_DT_LABEL) {
		this.COMP_POL_START_DT_LABEL = COMP_POL_START_DT_LABEL;
	}

	public void setCOMP_POL_START_DT(HtmlCalendar COMP_POL_START_DT) {
		this.COMP_POL_START_DT = COMP_POL_START_DT;
	}

	public HtmlOutputLabel getCOMP_POL_EXPIRY_DT_LABEL() {
		return COMP_POL_EXPIRY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_EXPIRY_DT() {
		return COMP_POL_EXPIRY_DT;
	}

	public void setCOMP_POL_EXPIRY_DT_LABEL(HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL) {
		this.COMP_POL_EXPIRY_DT_LABEL = COMP_POL_EXPIRY_DT_LABEL;
	}

	public void setCOMP_POL_EXPIRY_DT(HtmlCalendar COMP_POL_EXPIRY_DT) {
		this.COMP_POL_EXPIRY_DT = COMP_POL_EXPIRY_DT;
	}

	public HtmlOutputLabel getCOMP_RD_END_NO_IDX_LABEL() {
		return COMP_RD_END_NO_IDX_LABEL;
	}

	public void setCOMP_RD_END_NO_IDX_LABEL(HtmlOutputLabel comp_rd_end_no_idx_label) {
		COMP_RD_END_NO_IDX_LABEL = comp_rd_end_no_idx_label;
	}

	public HtmlInputText getCOMP_RD_END_NO_IDX() {
		return COMP_RD_END_NO_IDX;
	}

	public void setCOMP_RD_END_NO_IDX(HtmlInputText comp_rd_end_no_idx) {
		COMP_RD_END_NO_IDX = comp_rd_end_no_idx;
	}

	public PV_IL_POL_RI_DETL getPV_IL_POL_RI_DETL_BEAN() {
		return PV_IL_POL_RI_DETL_BEAN;
	}

	public void setPV_IL_POL_RI_DETL_BEAN(PV_IL_POL_RI_DETL PV_IL_POL_RI_DETL_BEAN) {
		this.PV_IL_POL_RI_DETL_BEAN = PV_IL_POL_RI_DETL_BEAN;
	}
	
	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}
	
	public List<String> getPolicyRowIdList() {
		return policyRowIdList;
	}

	public void setPolicyRowIdList(List<String> policyRowIdList) {
		this.policyRowIdList = policyRowIdList;
	}

	public void onLoad(PhaseEvent event) {
		try{
			System.out.println("CALLING_FORM variable          "+CommonUtils.getGlobalVariable("CALLING_FORM"));
		if ("PILT002_APAC"
				.equals(CommonUtils.getGlobalVariable("CALLING_FORM"))) {
			setBlockFlag(true);
		} 
		
		/*changed by janani*/
		
		else if ("".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))
				|| (CommonUtils.getGlobalVariable("CALLING_FORM") == null)) {
			CommonUtils.setGlobalVariable("CALLING_FORM_MK", "PREMALLOC");
			/* added by raja on 18-08-2017 for ZBILQC-1735458 */
			//setBlockFlag(true);
			/*end*/
		}
/*end*/
		
		System.out.println("isBlockFlag        :"+isBlockFlag());
		if (isBlockFlag()) {
			/* added by raja on 18-08-2017 for ZBILQC-1735458 */
			System.out.println("pol no --->"+CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO"));
			CommonUtils.clearMaps(this);
			helper.PV_IL_POL_RI_DETL_whenNewBlockInstance(compositeAction);
			compositeAction.getPILT010_PT_IL_RI_DETL_ACTION().getDataList_PT_IL_RI_DETL1().clear();
			/*end*/
			if (PV_IL_POL_RI_DETL_BEAN.getRD_POL_NO() != null) {

				helper.executeQuery();
				
			}
			new DUMMY_HELPER().getPvPolicyNoList();

			/*added by janani*/
			setBlockFlag(false);
			/*end*/
			
		}
		compositeAction.getPILT010_PT_IL_RI_DETL_ACTION().getPT_IL_RI_DETL_BEAN1().setRowSelected(true);

		CommonUtils.setGlobalVariable("CALLING_FORM", null);

		setBlockFlag(false);
	}catch (Exception e) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("onLoad", e.getMessage());
	}
}

	
	
	/*public void getDetails_P() {
		try {
			compositeAction.getPILT010_PT_IL_RI_DETL_ACTION().getDetails_P();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public List<PV_IL_POL_RI_DETL> RD_POL_NO_SUGGESTION_LIST(Object value){
		List<PV_IL_POL_RI_DETL> suggestionList = null;
		try {
			suggestionList = helper.RD_POL_NOList((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return suggestionList;
	}
	
	public List<PV_IL_POL_RI_DETL> RD_END_NO_IDX_SUGGESTION_LIST(Object value){
		List<PV_IL_POL_RI_DETL> suggestionList = null;
		try {
			suggestionList = helper.RD_END_NO_IDXList((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return suggestionList;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void setRD_POL_NOValidator(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
			String RD_POL_NO = (String) value;
			riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_POL_NO(RD_POL_NO);
			CommonUtils.setGlobalVariable("GLOBAL_MK_POL_NO",PV_IL_POL_RI_DETL_BEAN.getRD_POL_NO());
			helper.executeForm();
			disableAllComponent(true);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void setRD_POL_NOValidator(ActionEvent event){
		try {
			
			helper.clearErrorMap();
			PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
			String RD_POL_NO = (String) riDetlAction.getCOMP_RD_POL_NO().getSubmittedValue();
			riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_POL_NO(RD_POL_NO);
			helper.executeForm();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void setRD_POL_NO(ActionEvent event) {
		try {
			UIComponent component = (UIComponent) event.getComponent().getParent();
			int rowIndex = ((HtmlSuggestionBox) component).getRowIndex();
			System.out.println("Policy No. RowIndex: "+rowIndex);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	
	public void setRD_END_NO_IDXValidator(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			helper.clearErrorMap();
			PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
			String endNoIdx = (String) riDetlAction.getCOMP_RD_END_NO_IDX().getSubmittedValue();
			Integer RD_END_NO_IDX = null;
			if(endNoIdx!=null && !endNoIdx.trim().equals("")){
				RD_END_NO_IDX = new Integer(endNoIdx);
			}else{
				RD_END_NO_IDX = helper.getEndorsementNoIdx();
			}
			riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_END_NO_IDX(RD_END_NO_IDX);
			helper.executeForm();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void setRD_END_NO_IDXValidator(ActionEvent event){
		try {
			helper.clearErrorMap();
			PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
			String endNoIdx = (String) riDetlAction.getCOMP_RD_END_NO_IDX().getSubmittedValue();
			Integer RD_END_NO_IDX = null;
			if(endNoIdx!=null && !endNoIdx.trim().equals("")){
				RD_END_NO_IDX = new Integer(endNoIdx);
			}else{
				RD_END_NO_IDX = helper.getEndorsementNoIdx();
			}
			riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_END_NO_IDX(RD_END_NO_IDX);
			helper.executeForm();
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
	}
	

	/**
	 * Disables all components in PV_IL_POL_RI_DETL_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		//COMP_RD_POL_NO.setDisabled(disabled);
		COMP_RD_END_NO.setDisabled(disabled);
		COMP_RD_YEAR.setDisabled(disabled);
		COMP_POL_CLASS_CODE.setDisabled(disabled);
		COMP_POL_PROD_CODE.setDisabled(disabled);
		COMP_RD_UW_YEAR.setDisabled(disabled);
		COMP_POL_PERIOD.setDisabled(disabled);
		COMP_POL_CONT_CODE.setDisabled(disabled);
		COMP_RD_END_NO_IDX.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_POL_START_DT.setDisabled(disabled);
		COMP_POL_EXPIRY_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		//COMP_RI_BUT_CLOSE.setDisabled(disabled);

	}



	public PILT010_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT010_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlOutputText getCOMP_B_RI_CLOSE() {
		return COMP_B_RI_CLOSE;
	}

	public void setCOMP_B_RI_CLOSE(HtmlOutputText comp_b_ri_close) {
		COMP_B_RI_CLOSE = comp_b_ri_close;
	}

	public HtmlCommandButton getCOMP_RI_BUT_CLOSE() {
		return COMP_RI_BUT_CLOSE;
	}

	public void setCOMP_RI_BUT_CLOSE(HtmlCommandButton comp_ri_but_close) {
		COMP_RI_BUT_CLOSE = comp_ri_but_close;
	}

	public List<PT_IL_RI_DETL> getDataList_PV_IL_RI_DETL() {
		return dataList_PV_IL_RI_DETL;
	}

	public void setDataList_PV_IL_RI_DETL(List<PT_IL_RI_DETL> dataList_PV_IL_RI_DETL) {
		this.dataList_PV_IL_RI_DETL = dataList_PV_IL_RI_DETL;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	

	
}
