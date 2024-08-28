package com.iii.pel.forms.PILP089_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_CHARGE;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.utl_smtp.connection;

public class PW_IL_PA_PROFIT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PP_POL_NO_LABEL;

	private HtmlInputText COMP_PP_POL_NO;

	private HtmlOutputLabel COMP_PP_POL_PROD_CODE_LABEL;

	private HtmlInputText COMP_PP_POL_PROD_CODE;

	private HtmlOutputLabel COMP_PP_POL_APPRV_DT_LABEL;

	private HtmlCalendar COMP_PP_POL_APPRV_DT;

	private HtmlOutputLabel COMP_PP_PROCESS_YN_LABEL;

	private HtmlSelectOneMenu COMP_PP_PROCESS_YN;

	private PW_IL_PA_PROFIT PW_IL_PA_PROFIT_BEAN;

	public PILP089_APAC_COMPOSITE_ACTION compositeAction;

	private PW_IL_PA_PROFIT_HELPER helper;

	private List<PW_IL_PA_PROFIT> dataList_PW_IL_PA_PROFIT = new ArrayList<PW_IL_PA_PROFIT>();

	private UIData dataTable;

	private List<SelectItem> listPP_PROCESS_YN = new ArrayList<SelectItem>();

	public PW_IL_PA_PROFIT_ACTION() {
		

		SelectItem item = new SelectItem();
		item.setValue("Yes");
		item.setValue("No");
		listPP_PROCESS_YN.add(item);
		
		PW_IL_PA_PROFIT_BEAN = new PW_IL_PA_PROFIT();
		helper = new PW_IL_PA_PROFIT_HELPER();
		dropDownMethod();
		
		
	}
	
	public void dropDownMethod() {
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			listPP_PROCESS_YN = ListItemUtil.getDropDownListValue(con,
					"PILP089_APAC", "PW_IL_PA_PROFIT",
					"PW_IL_PA_PROFIT.PP_PROCESS_YN", "YESNO");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
	}

	public HtmlOutputLabel getCOMP_PP_POL_NO_LABEL() {
		return COMP_PP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_PP_POL_NO() {
		return COMP_PP_POL_NO;
	}

	public void setCOMP_PP_POL_NO_LABEL(HtmlOutputLabel COMP_PP_POL_NO_LABEL) {
		this.COMP_PP_POL_NO_LABEL = COMP_PP_POL_NO_LABEL;
	}

	public void setCOMP_PP_POL_NO(HtmlInputText COMP_PP_POL_NO) {
		this.COMP_PP_POL_NO = COMP_PP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_PP_POL_PROD_CODE_LABEL() {
		return COMP_PP_POL_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PP_POL_PROD_CODE() {
		return COMP_PP_POL_PROD_CODE;
	}

	public void setCOMP_PP_POL_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_PP_POL_PROD_CODE_LABEL) {
		this.COMP_PP_POL_PROD_CODE_LABEL = COMP_PP_POL_PROD_CODE_LABEL;
	}

	public void setCOMP_PP_POL_PROD_CODE(HtmlInputText COMP_PP_POL_PROD_CODE) {
		this.COMP_PP_POL_PROD_CODE = COMP_PP_POL_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_PP_POL_APPRV_DT_LABEL() {
		return COMP_PP_POL_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PP_POL_APPRV_DT() {
		return COMP_PP_POL_APPRV_DT;
	}

	public void setCOMP_PP_POL_APPRV_DT_LABEL(
			HtmlOutputLabel COMP_PP_POL_APPRV_DT_LABEL) {
		this.COMP_PP_POL_APPRV_DT_LABEL = COMP_PP_POL_APPRV_DT_LABEL;
	}

	public void setCOMP_PP_POL_APPRV_DT(HtmlCalendar COMP_PP_POL_APPRV_DT) {
		this.COMP_PP_POL_APPRV_DT = COMP_PP_POL_APPRV_DT;
	}

	public HtmlOutputLabel getCOMP_PP_PROCESS_YN_LABEL() {
		return COMP_PP_PROCESS_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PP_PROCESS_YN() {
		return COMP_PP_PROCESS_YN;
	}

	public void setCOMP_PP_PROCESS_YN_LABEL(
			HtmlOutputLabel COMP_PP_PROCESS_YN_LABEL) {
		this.COMP_PP_PROCESS_YN_LABEL = COMP_PP_PROCESS_YN_LABEL;
	}

	public void setCOMP_PP_PROCESS_YN(HtmlSelectOneMenu COMP_PP_PROCESS_YN) {
		this.COMP_PP_PROCESS_YN = COMP_PP_PROCESS_YN;
	}

	public PW_IL_PA_PROFIT getPW_IL_PA_PROFIT_BEAN() {
		return PW_IL_PA_PROFIT_BEAN;
	}

	public void setPW_IL_PA_PROFIT_BEAN(PW_IL_PA_PROFIT PW_IL_PA_PROFIT_BEAN) {
		this.PW_IL_PA_PROFIT_BEAN = PW_IL_PA_PROFIT_BEAN;
	}

	public List<PW_IL_PA_PROFIT> getDataList_PW_IL_PA_PROFIT() {
		return dataList_PW_IL_PA_PROFIT;
	}

	public void setDataListPW_IL_PA_PROFIT(
			List<PW_IL_PA_PROFIT> dataList_PW_IL_PA_PROFIT) {
		this.dataList_PW_IL_PA_PROFIT = dataList_PW_IL_PA_PROFIT;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PW_IL_PA_PROFIT_BEAN = new PW_IL_PA_PROFIT();
				// resetAllComponent();
				// resetSelectedRow();
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

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	/*public List<String> getListPP_PROCESS_YN() {
		if (listPP_PROCESS_YN.size() == 0) {
			listPP_PROCESS_YN.clear();
			try {
				listPP_PROCESS_YN = new ArrayList<String>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPP_PROCESS_YN;
	}

	public void setListPP_PROCESS_YN(List<String> listPP_PROCESS_YN) {
		this.listPP_PROCESS_YN = listPP_PROCESS_YN;
	}*/

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void setDataList_PW_IL_PA_PROFIT(
			List<PW_IL_PA_PROFIT> dataList_PW_IL_PA_PROFIT) {
		this.dataList_PW_IL_PA_PROFIT = dataList_PW_IL_PA_PROFIT;
	}
	
	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public List<SelectItem> getListPP_PROCESS_YN() {
		if (listPP_PROCESS_YN.size() == 0) {
			listPP_PROCESS_YN.clear();
			try {
				listPP_PROCESS_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPP_PROCESS_YN;
	}

	public void setListPP_PROCESS_YN(List<SelectItem> listPP_PROCESS_YN) {
		this.listPP_PROCESS_YN = listPP_PROCESS_YN;
	}
	
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PW_IL_PA_PROFIT_BEAN = (PW_IL_PA_PROFIT) dataTable.getRowData();
			PW_IL_PA_PROFIT_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	
	private void resetSelectedRow() {
		Iterator<PW_IL_PA_PROFIT> PW_IL_PA_PROFIT_ITR = dataList_PW_IL_PA_PROFIT
		.iterator();
		while (PW_IL_PA_PROFIT_ITR.hasNext()) {
			PW_IL_PA_PROFIT_ITR.next().setRowSelected(false);
		}
	}
	
	
	private void resetAllComponent() {
		COMP_PP_POL_NO.resetValue();
		COMP_PP_POL_PROD_CODE.resetValue();
		COMP_PP_POL_APPRV_DT.resetValue();
		COMP_PP_PROCESS_YN.resetValue();
		
	}
	
	
	public void postRecord(ActionEvent event) {
		CommonUtils.clearMaps(compositeAction.getDUMMY_ACTION_BEAN());
		String message = null;
		try {
			if (PW_IL_PA_PROFIT_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
			
				new CRUDHandler().executeInsert(PW_IL_PA_PROFIT_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$insert"); 
				compositeAction.getDUMMY_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

				compositeAction.getDUMMY_ACTION_BEAN().getWarningMap().put("postRecord",message);
			//	dataList_PW_IL_PA_PROFIT.add(PW_IL_PA_PROFIT_BEAN);
			} else if (PW_IL_PA_PROFIT_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				new CRUDHandler().executeUpdate(PW_IL_PA_PROFIT_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$update"); 
				compositeAction.getDUMMY_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

				compositeAction.getDUMMY_ACTION_BEAN().getWarningMap().put("postRecord",message);

			}

			PW_IL_PA_PROFIT_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}
}