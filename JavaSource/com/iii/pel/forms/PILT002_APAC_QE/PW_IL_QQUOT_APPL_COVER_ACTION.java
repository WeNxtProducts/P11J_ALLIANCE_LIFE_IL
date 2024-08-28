package com.iii.pel.forms.PILT002_APAC_QE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PW_IL_QQUOT_APPL_COVER_ACTION extends CommonAction {

	private HtmlInputText COMP_QQAC_COVER_CODE;
	
	private HtmlInputText COMP_UI_QQAC_COVER_CODE_DESC;
	
	private HtmlSelectOneMenu COMP_QQAC_PREM_CALC_TYPE;
	
	private HtmlInputText COMP_QQAC_SA_FC;
	
	private HtmlInputText COMP_QQAC_PREM_FC;
	
	private HtmlInputText COMP_QQAC_PERIOD;
	
	private HtmlInputText COMP_QQAC_PREM_PAY_YRS;
	
	private ArrayList<PW_IL_QQUOT_APPL_COVER> PW_IL_QQUOT_APPL_COVER_LIST;
	
	private UIData dataTable;
	
	private List<SelectItem> listQQAC_PREM_CALC_TYPE = new ArrayList<SelectItem>();
	
	private PW_IL_QQUOT_APPL_COVER PW_IL_QQUOT_APPL_COVER_BEAN;
	private PW_IL_QQUOT_APPL_COVER_HELPER helper;
	
	public PILT002_APAC_QE_COMPOSITE_ACTION compositeAction;
	
	public PW_IL_QQUOT_APPL_COVER_ACTION(){
		PW_IL_QQUOT_APPL_COVER_BEAN = new PW_IL_QQUOT_APPL_COVER();
		helper = new PW_IL_QQUOT_APPL_COVER_HELPER();
		prepareDropdowns();
	}
	
	public void prepareDropdowns(){
		try{
			setListQQAC_PREM_CALC_TYPE(ListItemUtil.getDropDownListValue_1(CommonUtils
					.getConnection(), "PGLT002_QE", "PT_GL_POL_COVER",
					"PT_GL_POL_COVER.PC_RATE_TYPE", null));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fireFieldValidation(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void addRow(ActionEvent event) {
		PW_IL_QQUOT_APPL_COVER_BEAN = new PW_IL_QQUOT_APPL_COVER();
		PW_IL_QQUOT_APPL_COVER_LIST.add(PW_IL_QQUOT_APPL_COVER_BEAN);
	}
	
	public void deleteRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String message = null;
		try {
			if (PW_IL_QQUOT_APPL_COVER_LIST.size() > 0) {
				new CRUDHandler().executeDelete(PW_IL_QQUOT_APPL_COVER_BEAN, CommonUtils.getConnection());
				PW_IL_QQUOT_APPL_COVER_LIST.remove(PW_IL_QQUOT_APPL_COVER_BEAN);
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete");
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put("Delete", message);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Delete", e.getMessage());
		}
	}
	
	public void postRecord(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String message = null;
		try {
			if (PW_IL_QQUOT_APPL_COVER_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()) {
					/*helper.preInsert(PW_IL_QQUOT_APPL_COVER_BEAN, compositeAction.
										getPW_GL_POL_APPL_PLAN_ACTION_BEAN().getPW_GL_POL_APPL_PLAN_BEAN());*/
					CommonUtils.objectSysout(PW_IL_QQUOT_APPL_COVER_BEAN);
					new CRUDHandler().executeInsert(PW_IL_QQUOT_APPL_COVER_BEAN,CommonUtils.getConnection());
					
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"); 
				}else{
					throw new Exception(Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
				}
			} else if (PW_IL_QQUOT_APPL_COVER_BEAN.getROWID() != null){
				if(isUPDATE_ALLOWED()) {
					//helper.preUpdate(PW_IL_QQUOT_APPL_COVER_BEAN);
					new CRUDHandler().executeUpdate(PW_IL_QQUOT_APPL_COVER_BEAN,CommonUtils.getConnection());
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$Grid$update");  
				}else {
					throw new Exception(Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$updatenotallowed"));
				}
			}
			
			
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("postRecord",e.getMessage());
		}
	}
	
	public void displayRecords(ActionEvent event) {
		int rowIndex = -1;
		try {
			CommonUtils.clearMaps(this);
			FacesContext context =FacesContext.getCurrentInstance();
			Map requestParameterMap=context.getExternalContext().getRequestParameterMap();
			String currentRow=((String)requestParameterMap.get("COVER_ROW_INDEX"));

			rowIndex = Integer.parseInt(currentRow);
			if (PW_IL_QQUOT_APPL_COVER_LIST.size() > 0) {
					dataTable.setRowIndex(rowIndex);
					PW_IL_QQUOT_APPL_COVER_BEAN = (PW_IL_QQUOT_APPL_COVER)dataTable.getRowData();
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	
	public PW_IL_QQUOT_APPL_COVER getPW_IL_QQUOT_APPL_COVER_BEAN() {
		return PW_IL_QQUOT_APPL_COVER_BEAN;
	}
	public void setPW_IL_QQUOT_APPL_COVER_BEAN(
			PW_IL_QQUOT_APPL_COVER pw_il_qquot_appl_cover_bean) {
		PW_IL_QQUOT_APPL_COVER_BEAN = pw_il_qquot_appl_cover_bean;
	}
	public PW_IL_QQUOT_APPL_COVER_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PW_IL_QQUOT_APPL_COVER_HELPER helper) {
		this.helper = helper;
	}

	public HtmlInputText getCOMP_QQAC_COVER_CODE() {
		return COMP_QQAC_COVER_CODE;
	}

	public void setCOMP_QQAC_COVER_CODE(HtmlInputText comp_qqac_cover_code) {
		COMP_QQAC_COVER_CODE = comp_qqac_cover_code;
	}

	public HtmlInputText getCOMP_UI_QQAC_COVER_CODE_DESC() {
		return COMP_UI_QQAC_COVER_CODE_DESC;
	}

	public void setCOMP_UI_QQAC_COVER_CODE_DESC(
			HtmlInputText comp_ui_qqac_cover_code_desc) {
		COMP_UI_QQAC_COVER_CODE_DESC = comp_ui_qqac_cover_code_desc;
	}

	public HtmlSelectOneMenu getCOMP_QQAC_PREM_CALC_TYPE() {
		return COMP_QQAC_PREM_CALC_TYPE;
	}

	public void setCOMP_QQAC_PREM_CALC_TYPE(
			HtmlSelectOneMenu comp_qqac_prem_calc_type) {
		COMP_QQAC_PREM_CALC_TYPE = comp_qqac_prem_calc_type;
	}

	public HtmlInputText getCOMP_QQAC_SA_FC() {
		return COMP_QQAC_SA_FC;
	}

	public void setCOMP_QQAC_SA_FC(HtmlInputText comp_qqac_sa_fc) {
		COMP_QQAC_SA_FC = comp_qqac_sa_fc;
	}

	public HtmlInputText getCOMP_QQAC_PREM_FC() {
		return COMP_QQAC_PREM_FC;
	}

	public void setCOMP_QQAC_PREM_FC(HtmlInputText comp_qqac_prem_fc) {
		COMP_QQAC_PREM_FC = comp_qqac_prem_fc;
	}

	public HtmlInputText getCOMP_QQAC_PERIOD() {
		return COMP_QQAC_PERIOD;
	}

	public void setCOMP_QQAC_PERIOD(HtmlInputText comp_qqac_period) {
		COMP_QQAC_PERIOD = comp_qqac_period;
	}

	public HtmlInputText getCOMP_QQAC_PREM_PAY_YRS() {
		return COMP_QQAC_PREM_PAY_YRS;
	}

	public void setCOMP_QQAC_PREM_PAY_YRS(HtmlInputText comp_qqac_prem_pay_yrs) {
		COMP_QQAC_PREM_PAY_YRS = comp_qqac_prem_pay_yrs;
	}

	public ArrayList<PW_IL_QQUOT_APPL_COVER> getPW_IL_QQUOT_APPL_COVER_LIST() {
		return PW_IL_QQUOT_APPL_COVER_LIST;
	}

	public void setPW_IL_QQUOT_APPL_COVER_LIST(
			ArrayList<PW_IL_QQUOT_APPL_COVER> pw_il_qquot_appl_cover_list) {
		PW_IL_QQUOT_APPL_COVER_LIST = pw_il_qquot_appl_cover_list;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<SelectItem> getListQQAC_PREM_CALC_TYPE() {
		return listQQAC_PREM_CALC_TYPE;
	}

	public void setListQQAC_PREM_CALC_TYPE(List<SelectItem> listQQAC_PREM_CALC_TYPE) {
		this.listQQAC_PREM_CALC_TYPE = listQQAC_PREM_CALC_TYPE;
	}
}
