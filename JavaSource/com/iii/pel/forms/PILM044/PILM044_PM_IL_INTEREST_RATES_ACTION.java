package com.iii.pel.forms.PILM044;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
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
import javax.jms.Session;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.DUMMY_OCC;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_HELPER;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY_QUERY_CONSTANTS;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_ASSURED_DTLS_ACTION;
import com.iii.pel.forms.PILT006_APAC.PH_IL_CLAIM_COVER_DTLS;
import com.iii.pel.forms.PILT024.PS_IL_POL_INVEST_SUMMARY;
import com.iii.pel.forms.PLM005.PLM005_COMPOSITE_ACTION;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PILM044_PM_IL_INTEREST_RATES_ACTION extends CommonAction{
	
	private HtmlInputText COMP_UI_M_IR_DESC;
	
	private HtmlOutputLabel COMP_IR_INT_TYPE_LABEL;
	
	private HtmlSelectOneMenu COMP_IR_INT_TYPE;
	
	//NEW 
	private HtmlOutputLabel COMP_IR_TOT_CONT_FROM_LABEL;
	
	private HtmlInputText COMP_IR_TOT_CONT_FROM;
	
	private HtmlOutputLabel COMP_IR_TOT_CONT_TO_LABEL;
	
	private HtmlInputText COMP_IR_TOT_CONT_TO;
	
	private HtmlOutputLabel COMP_IR_TERM_FM_LABEL;
	
	private HtmlInputText COMP_IR_TERM_FM;
	
	private HtmlOutputLabel COMP_IR_TERM_TO_LABEL;
	
	private HtmlInputText COMP_IR_TERM_TO;
	
	private HtmlOutputLabel COMP_IR_TOT_CONT_RATE_LABEL;
	
	private HtmlInputText COMP_IR_TOT_CONT_RATE;
	
	private HtmlOutputLabel COMP_IR_TOT_CONT_RATE_PER_LABEL;
	
	private HtmlInputText COMP_IR_TOT_CONT_RATE_PER;
	
	private HtmlOutputLabel COMP_IR_EFF_FM_DT_LABEL;
	
	private HtmlCalendar COMP_IR_EFF_FM_DT;
	
	private HtmlOutputLabel COMP_IR_EFF_TO_DT_LABEL;
	
	private HtmlCalendar COMP_IR_EFF_TO_DT;
	
	private HtmlOutputLabel COMP_IR_COMP_CODE_LABEL;
	
	private HtmlInputText COMP_IR_COMP_CODE;
	
	private HtmlOutputLabel COMP_IR_PROD_CODE_LABEL;
	
	private HtmlInputText COMP_IR_PROD_CODE;
	
	//NEW 
	
	public HtmlOutputLabel getCOMP_IR_PROD_CODE_LABEL() {
		return COMP_IR_PROD_CODE_LABEL;
	}

	public void setCOMP_IR_PROD_CODE_LABEL(HtmlOutputLabel cOMP_IR_PROD_CODE_LABEL) {
		COMP_IR_PROD_CODE_LABEL = cOMP_IR_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_IR_PROD_CODE() {
		return COMP_IR_PROD_CODE;
	}

	public void setCOMP_IR_PROD_CODE(HtmlInputText cOMP_IR_PROD_CODE) {
		COMP_IR_PROD_CODE = cOMP_IR_PROD_CODE;
	}

	private UIData dataTable;
	
	private List<PM_IL_INTEREST_RATES> dataListPM_IL_INTEREST_RATES = new ArrayList<PM_IL_INTEREST_RATES>();
	
	private List<SelectItem> listIR_INT_TYPE = new ArrayList<SelectItem>();
	
	public PILM044_COMPOSITE_ACTION compositeAction;
	
	public PM_IL_INTEREST_RATES PM_IL_INTEREST_RATES_BEAN;
	
	public PM_IL_INTEREST_RATES_HELPER helper;
	
	public PILM044_PM_IL_INTEREST_RATES_ACTION() {
		// TODO Auto-generated constructor stub
		PM_IL_INTEREST_RATES_BEAN = new PM_IL_INTEREST_RATES();
		helper = new PM_IL_INTEREST_RATES_HELPER();
		instantiateAllComponent();
	}

	public HtmlInputText getCOMP_UI_M_IR_DESC() {
		return COMP_UI_M_IR_DESC;
	}

	public void setCOMP_UI_M_IR_DESC(HtmlInputText cOMP_UI_M_IR_DESC) {
		COMP_UI_M_IR_DESC = cOMP_UI_M_IR_DESC;
	}

	public HtmlOutputLabel getCOMP_IR_INT_TYPE_LABEL() {
		return COMP_IR_INT_TYPE_LABEL;
	}

	public void setCOMP_IR_INT_TYPE_LABEL(HtmlOutputLabel cOMP_IR_INT_TYPE_LABEL) {
		COMP_IR_INT_TYPE_LABEL = cOMP_IR_INT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_IR_INT_TYPE() {
		return COMP_IR_INT_TYPE;
	}

	public void setCOMP_IR_INT_TYPE(HtmlSelectOneMenu cOMP_IR_INT_TYPE) {
		COMP_IR_INT_TYPE = cOMP_IR_INT_TYPE;
	}
	
	public HtmlOutputLabel getCOMP_IR_TOT_CONT_FROM_LABEL() {
		return COMP_IR_TOT_CONT_FROM_LABEL;
	}

	public void setCOMP_IR_TOT_CONT_FROM_LABEL(
			HtmlOutputLabel cOMP_IR_TOT_CONT_FROM_LABEL) {
		COMP_IR_TOT_CONT_FROM_LABEL = cOMP_IR_TOT_CONT_FROM_LABEL;
	}

	public HtmlInputText getCOMP_IR_TOT_CONT_FROM() {
		return COMP_IR_TOT_CONT_FROM;
	}

	public void setCOMP_IR_TOT_CONT_FROM(HtmlInputText cOMP_IR_TOT_CONT_FROM) {
		COMP_IR_TOT_CONT_FROM = cOMP_IR_TOT_CONT_FROM;
	}

	public HtmlOutputLabel getCOMP_IR_TOT_CONT_TO_LABEL() {
		return COMP_IR_TOT_CONT_TO_LABEL;
	}

	public void setCOMP_IR_TOT_CONT_TO_LABEL(
			HtmlOutputLabel cOMP_IR_TOT_CONT_TO_LABEL) {
		COMP_IR_TOT_CONT_TO_LABEL = cOMP_IR_TOT_CONT_TO_LABEL;
	}

	public HtmlInputText getCOMP_IR_TOT_CONT_TO() {
		return COMP_IR_TOT_CONT_TO;
	}

	public void setCOMP_IR_TOT_CONT_TO(HtmlInputText cOMP_IR_TOT_CONT_TO) {
		COMP_IR_TOT_CONT_TO = cOMP_IR_TOT_CONT_TO;
	}

	public HtmlOutputLabel getCOMP_IR_TERM_FM_LABEL() {
		return COMP_IR_TERM_FM_LABEL;
	}

	public void setCOMP_IR_TERM_FM_LABEL(HtmlOutputLabel cOMP_IR_TERM_FM_LABEL) {
		COMP_IR_TERM_FM_LABEL = cOMP_IR_TERM_FM_LABEL;
	}

	public HtmlInputText getCOMP_IR_TERM_FM() {
		return COMP_IR_TERM_FM;
	}

	public void setCOMP_IR_TERM_FM(HtmlInputText cOMP_IR_TERM_FM) {
		COMP_IR_TERM_FM = cOMP_IR_TERM_FM;
	}

	public HtmlOutputLabel getCOMP_IR_TERM_TO_LABEL() {
		return COMP_IR_TERM_TO_LABEL;
	}

	public void setCOMP_IR_TERM_TO_LABEL(HtmlOutputLabel cOMP_IR_TERM_TO_LABEL) {
		COMP_IR_TERM_TO_LABEL = cOMP_IR_TERM_TO_LABEL;
	}

	public HtmlInputText getCOMP_IR_TERM_TO() {
		return COMP_IR_TERM_TO;
	}

	public void setCOMP_IR_TERM_TO(HtmlInputText cOMP_IR_TERM_TO) {
		COMP_IR_TERM_TO = cOMP_IR_TERM_TO;
	}

	public HtmlOutputLabel getCOMP_IR_TOT_CONT_RATE_LABEL() {
		return COMP_IR_TOT_CONT_RATE_LABEL;
	}

	public void setCOMP_IR_TOT_CONT_RATE_LABEL(
			HtmlOutputLabel cOMP_IR_TOT_CONT_RATE_LABEL) {
		COMP_IR_TOT_CONT_RATE_LABEL = cOMP_IR_TOT_CONT_RATE_LABEL;
	}

	public HtmlInputText getCOMP_IR_TOT_CONT_RATE() {
		return COMP_IR_TOT_CONT_RATE;
	}

	public void setCOMP_IR_TOT_CONT_RATE(HtmlInputText cOMP_IR_TOT_CONT_RATE) {
		COMP_IR_TOT_CONT_RATE = cOMP_IR_TOT_CONT_RATE;
	}

	public HtmlOutputLabel getCOMP_IR_TOT_CONT_RATE_PER_LABEL() {
		return COMP_IR_TOT_CONT_RATE_PER_LABEL;
	}

	public void setCOMP_IR_TOT_CONT_RATE_PER_LABEL(
			HtmlOutputLabel cOMP_IR_TOT_CONT_RATE_PER_LABEL) {
		COMP_IR_TOT_CONT_RATE_PER_LABEL = cOMP_IR_TOT_CONT_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_IR_TOT_CONT_RATE_PER() {
		return COMP_IR_TOT_CONT_RATE_PER;
	}

	public void setCOMP_IR_TOT_CONT_RATE_PER(HtmlInputText cOMP_IR_TOT_CONT_RATE_PER) {
		COMP_IR_TOT_CONT_RATE_PER = cOMP_IR_TOT_CONT_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_IR_EFF_FM_DT_LABEL() {
		return COMP_IR_EFF_FM_DT_LABEL;
	}

	public void setCOMP_IR_EFF_FM_DT_LABEL(HtmlOutputLabel cOMP_IR_EFF_FM_DT_LABEL) {
		COMP_IR_EFF_FM_DT_LABEL = cOMP_IR_EFF_FM_DT_LABEL;
	}

	public HtmlOutputLabel getCOMP_IR_EFF_TO_DT_LABEL() {
		return COMP_IR_EFF_TO_DT_LABEL;
	}

	public void setCOMP_IR_EFF_TO_DT_LABEL(HtmlOutputLabel cOMP_IR_EFF_TO_DT_LABEL) {
		COMP_IR_EFF_TO_DT_LABEL = cOMP_IR_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_IR_EFF_FM_DT() {
		return COMP_IR_EFF_FM_DT;
	}

	public void setCOMP_IR_EFF_FM_DT(HtmlCalendar cOMP_IR_EFF_FM_DT) {
		COMP_IR_EFF_FM_DT = cOMP_IR_EFF_FM_DT;
	}

	public HtmlCalendar getCOMP_IR_EFF_TO_DT() {
		return COMP_IR_EFF_TO_DT;
	}

	public void setCOMP_IR_EFF_TO_DT(HtmlCalendar cOMP_IR_EFF_TO_DT) {
		COMP_IR_EFF_TO_DT = cOMP_IR_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_IR_COMP_CODE_LABEL() {
		return COMP_IR_COMP_CODE_LABEL;
	}

	public void setCOMP_IR_COMP_CODE_LABEL(HtmlOutputLabel cOMP_IR_COMP_CODE_LABEL) {
		COMP_IR_COMP_CODE_LABEL = cOMP_IR_COMP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_IR_COMP_CODE() {
		return COMP_IR_COMP_CODE;
	}

	public void setCOMP_IR_COMP_CODE(HtmlInputText cOMP_IR_COMP_CODE) {
		COMP_IR_COMP_CODE = cOMP_IR_COMP_CODE;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<PM_IL_INTEREST_RATES> getDataListPM_IL_INTEREST_RATES() {
		return dataListPM_IL_INTEREST_RATES;
	}

	public void setDataListPM_IL_INTEREST_RATES(
			List<PM_IL_INTEREST_RATES> dataListPM_IL_INTEREST_RATES) {
		this.dataListPM_IL_INTEREST_RATES = dataListPM_IL_INTEREST_RATES;
	}

	public List<SelectItem> getListIR_INT_TYPE() {
		return listIR_INT_TYPE;
	}

	public void setListIR_INT_TYPE(List<SelectItem> listIR_INT_TYPE) {
		this.listIR_INT_TYPE = listIR_INT_TYPE;
	}

	public PILM044_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM044_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PM_IL_INTEREST_RATES getPM_IL_INTEREST_RATES_BEAN() {
		return PM_IL_INTEREST_RATES_BEAN;
	}

	public void setPM_IL_INTEREST_RATES_BEAN(
			PM_IL_INTEREST_RATES pM_IL_INTEREST_RATES_BEAN) {
		PM_IL_INTEREST_RATES_BEAN = pM_IL_INTEREST_RATES_BEAN;
	}

	public PM_IL_INTEREST_RATES_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_INTEREST_RATES_HELPER helper) {
		this.helper = helper;
	}
	
	public String backToSearch() {
		return "IL010105";
	 }
	
	/*public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			DUMMY_OCC_BEAN = (DUMMY_OCC) dataTable.getRowData();
			DUMMY_OCC_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}*/
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateIR_PROD_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PM_IL_INTEREST_RATES_BEAN.setIR_PROD_CODE((String) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	//new
	public void validateIR_TOT_CONT_FROM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			/* added by rja on 25-07-2017 for ZBILQC-1730095 */
			if(PM_IL_INTEREST_RATES_BEAN.getIR_TOT_CONT_TO()!=null && PM_IL_INTEREST_RATES_BEAN.getIR_TOT_CONT_TO()<(Double) value)
			{
				throw new Exception("Contribution From value should be lesser than to Contribution To vlaue");
			}
			/*end*/
			PM_IL_INTEREST_RATES_BEAN.setIR_TOT_CONT_FROM((Double) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void validateIR_TOT_CONT_TO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			/* added by rja on 25-07-2017 for ZBILQC-1730095 */
			if(PM_IL_INTEREST_RATES_BEAN.getIR_TOT_CONT_FROM()!=null && PM_IL_INTEREST_RATES_BEAN.getIR_TOT_CONT_FROM()>(Double) value)
			{
				throw new Exception("Contribution To value should be greater than to Contribution From vlaue");
			}
			/*end*/
			PM_IL_INTEREST_RATES_BEAN.setIR_TOT_CONT_TO((Double) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void validateIR_TERM_FM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			/* added by rja on 25-07-2017 for ZBILQC-1730095 */
			if(PM_IL_INTEREST_RATES_BEAN.getIR_TERM_TO()!=null && PM_IL_INTEREST_RATES_BEAN.getIR_TERM_TO()<(Integer)value)
				{
				throw new Exception("Term from Should be lesser than Term to value");
				}
			/*end*/
			PM_IL_INTEREST_RATES_BEAN.setIR_TERM_FM((Integer) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void validateIR_TERM_TO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			/* added by rja on 25-07-2017 for ZBILQC-1730095 */
			if(PM_IL_INTEREST_RATES_BEAN.getIR_TERM_FM()!=null && PM_IL_INTEREST_RATES_BEAN.getIR_TERM_FM()>(Integer)value)
			{
			throw new Exception("Term to Should be greater than Term from value");
			}
			/*end*/
			PM_IL_INTEREST_RATES_BEAN.setIR_TERM_TO((Integer) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void validateIR_TOT_CONT_RATE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PM_IL_INTEREST_RATES_BEAN.setIR_TOT_CONT_RATE((Double) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void validateIR_TOT_CONT_RATE_PER(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PM_IL_INTEREST_RATES_BEAN.setIR_TOT_CONT_RATE_PER((Integer) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void validateIR_EFF_FM_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PM_IL_INTEREST_RATES_BEAN.setIR_EFF_FM_DT((Date) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void validateIR_EFF_TO_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PM_IL_INTEREST_RATES_BEAN.setIR_EFF_TO_DT((Date) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	//new

		public void onLoad(PhaseEvent event){
			//CommonUtils.clearMaps(this);
			System.out.println("INSIDE PILM044 ONLOAD");
			try {
				if (isBlockFlag()) {
					
					//if (PM_IL_INTEREST_RATES_BEAN.getROWID() != null) {
						helper.executeQuery(compositeAction);
					//} 
					setBlockFlag(false);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		public void saveRecord(){
			try {
				chkDuplicate();
					System.out.println("INSIDE PILM044 SAVE");
					CommonUtils.doComitt();
						
						getWarningMap().put( "current",
								"Record Saved Successfully");
						
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
			}	
		}
		
		//NEW
		
		public void postRecord(ActionEvent event) {
			try {
				if (PM_IL_INTEREST_RATES_BEAN.getROWID() == null
						&& isINSERT_ALLOWED()) {
					PM_IL_INTEREST_RATES_BEAN.setIR_CR_DT(new CommonUtils().getCurrentDate());
					PM_IL_INTEREST_RATES_BEAN.setIR_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
					
					chkDuplicate();
					
					new CRUDHandler().executeInsert(PM_IL_INTEREST_RATES_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"Record Posted Successfully"));
					dataListPM_IL_INTEREST_RATES
							.add(PM_IL_INTEREST_RATES_BEAN);
				} else if (PM_IL_INTEREST_RATES_BEAN.getROWID() != null
						&& isUPDATE_ALLOWED()) {
					PM_IL_INTEREST_RATES_BEAN.setIR_UPD_DT(new CommonUtils().getCurrentDate());
					PM_IL_INTEREST_RATES_BEAN.setIR_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
					
					/* added by raja on 07-08-2017 for  ZBILQC-1730095 */
					chkDuplicate_update();
					/*end*/
					
					new CRUDHandler().executeUpdate(PM_IL_INTEREST_RATES_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				}
				/* added by raja on 07-08-2017 for  ZBILQC-1730095 */
				CommonUtils.doComitt();
				/*end*/
				PM_IL_INTEREST_RATES_BEAN.setRowSelected(true);
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Record not Inserted/Updated :: " + exc.getMessage());
				getErrorMap().put("postRecord",
						"Record not Inserted/Updated :: " + exc.getMessage());
			}

		}
		
		public void deleteRow(ActionEvent event) {
			try {
				if (isDELETE_ALLOWED()) {

					new CRUDHandler().executeDelete(PM_IL_INTEREST_RATES_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							"deleteRow",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$delete"));
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"Record Deleted Successfully"));
					dataListPM_IL_INTEREST_RATES
							.remove(PM_IL_INTEREST_RATES_BEAN);
					if (dataListPM_IL_INTEREST_RATES.size() > 0) {

						PM_IL_INTEREST_RATES_BEAN = dataListPM_IL_INTEREST_RATES
								.get(0);
					} else if (dataListPM_IL_INTEREST_RATES.size() == 0) {

						addRow(null);
					}
					CommonUtils.doComitt();
					resetAllComponent();
					PM_IL_INTEREST_RATES_BEAN.setRowSelected(true);
				} else {

					getErrorMap().put(
							"deleteRow",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$deletenotallowed"));
					getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$deletenotallowed"));
				}

			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						exc.getMessage());
				getErrorMap().put("deleteRow", exc.getMessage());
			}

		}
		
		public void addRow(ActionEvent event) {
			try {
				if (isINSERT_ALLOWED()) {

					PM_IL_INTEREST_RATES_BEAN = new PM_IL_INTEREST_RATES();
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
		
		private void resetSelectedRow() {
			Iterator<PM_IL_INTEREST_RATES> PM_IL_INTEREST_RATES_ITR = dataListPM_IL_INTEREST_RATES
					.iterator();
			while (PM_IL_INTEREST_RATES_ITR.hasNext()) {
				PM_IL_INTEREST_RATES_ITR.next().setRowSelected(false);
			}
		}
		
		private void resetAllComponent() {
			COMP_UI_M_IR_DESC.resetValue();
			//COMP_IR_INT_TYPE.resetValue();
			COMP_IR_TOT_CONT_FROM.resetValue();
			COMP_IR_TOT_CONT_TO.resetValue();
			COMP_IR_TERM_FM.resetValue();
			COMP_IR_TERM_TO.resetValue();
			COMP_IR_TOT_CONT_RATE.resetValue();
			COMP_IR_TOT_CONT_RATE_PER.resetValue();
			COMP_IR_EFF_FM_DT.resetValue();
			COMP_IR_EFF_TO_DT.resetValue();
			COMP_IR_COMP_CODE.resetValue();
			
			COMP_IR_PROD_CODE.resetValue();
			COMP_UI_M_IR_DESC.resetValue();
		}

		public void instantiateAllComponent(){
			// Instantiating HtmlInputText
			//COMP_IR_INT_TYPE = new HtmlSelectOneMenu();
			COMP_UI_M_IR_DESC = new HtmlInputText();
			COMP_IR_TOT_CONT_FROM = new HtmlInputText();
			COMP_IR_TOT_CONT_TO = new HtmlInputText();
			COMP_IR_TERM_FM = new HtmlInputText();
			COMP_IR_TERM_TO = new HtmlInputText();
			COMP_IR_TOT_CONT_RATE = new HtmlInputText();
			COMP_IR_TOT_CONT_RATE_PER = new HtmlInputText();
			COMP_IR_EFF_FM_DT = new HtmlCalendar();
			COMP_IR_EFF_TO_DT = new HtmlCalendar();
			COMP_IR_COMP_CODE = new HtmlInputText();
		}
		
		public ArrayList<LovBean> lovPROD_CODE(Object object) {

			ArrayList<LovBean> suggestionList = null;
			ListItemUtil listitemutil = new ListItemUtil();
			String query1 = null;

			try {
				
				/*changed by raja on 30-06-2017 for ZBILQC-1730095*/
				/*query1 = "SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE LIKE ?";*/
				query1 = "SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_INTR_SAVINGS_YN = 'Y' AND PROD_CODE LIKE ?";
				String currentValue = (String) object;
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
				
					suggestionList = ListItemUtil.prepareSuggestionList(query1,
							new Object[] {currentValue });

			} catch (Exception e) {
				e.printStackTrace();
			}
			return suggestionList;
		}
		
		public void getDetails() {
			try {
				resetSelectedRow();
				PM_IL_INTEREST_RATES_BEAN = (PM_IL_INTEREST_RATES) dataTable.getRowData();
				resetAllComponent();
				PM_IL_INTEREST_RATES_BEAN.setRowSelected(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//NEW
		
		public String decimalFormatted(int convertValue,PLM005_COMPOSITE_ACTION PLM005_COMPOSITE_ACTION_BEAN)
		{
			//int decimal = PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_DECIMAL();
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			int decimal = (int) session.get("GLOBAL_DECIMAL_FMT");
			System.out.println("decimal              :"+decimal);
			StringBuilder sb = new StringBuilder();
			sb.append(".");
			for(int i=0;i<decimal;i++)
			{
				sb.append("0");
			}
			DecimalFormat df = new DecimalFormat(sb.toString()); // Set your desired format here.
			
			String finalvalue = df.format(convertValue);
			
			System.out.println("value with decimal             "+finalvalue);
			
			return finalvalue;
		}
		
		public void chkDuplicate() throws Exception
		{
		/*addded by raja on 05-07-2017 for ZBILQC-1730095*/
		String Query="SELECT 'X' FROM PM_IL_INTEREST_RATES WHERE (TO_DATE(?, 'DD/MM/RRRR') "
				+ "BETWEEN IR_EFF_FM_DT AND IR_EFF_TO_DT OR TO_DATE(?, 'DD/MM/RRRR') "
				+ "BETWEEN IR_EFF_FM_DT AND IR_EFF_TO_DT) AND (? BETWEEN IR_TOT_CONT_FROM AND "
				+ "IR_TOT_CONT_TO OR ? BETWEEN IR_TOT_CONT_FROM AND IR_TOT_CONT_TO) AND (? BETWEEN IR_TERM_FM "
				+ "AND IR_TERM_TO OR ? BETWEEN IR_TERM_FM AND IR_TERM_TO)";
		
		ResultSet rst;
		try {
			rst = new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{PM_IL_INTEREST_RATES_BEAN.getIR_EFF_FM_DT(),
				PM_IL_INTEREST_RATES_BEAN.getIR_EFF_TO_DT(),PM_IL_INTEREST_RATES_BEAN.getIR_TOT_CONT_FROM(),PM_IL_INTEREST_RATES_BEAN.getIR_TOT_CONT_TO(),
				PM_IL_INTEREST_RATES_BEAN.getIR_TERM_FM(),PM_IL_INTEREST_RATES_BEAN.getIR_TERM_TO()});
			if(rst.next())
			{
				throw new Exception("This Combination already Exist ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		throw e;
		}
		
		}
		/*end*/
		
		/* added by raja on 07-08-2017 for  ZBILQC-1730095 */
		
		public void chkDuplicate_update() throws Exception
		{
		/*addded by raja on 05-07-2017 for ZBILQC-1730095*/
		String Query="SELECT 'X' FROM PM_IL_INTEREST_RATES WHERE (TO_DATE(?, 'DD/MM/RRRR') "
				+ "BETWEEN IR_EFF_FM_DT AND IR_EFF_TO_DT OR TO_DATE(?, 'DD/MM/RRRR') "
				+ "BETWEEN IR_EFF_FM_DT AND IR_EFF_TO_DT) AND (? BETWEEN IR_TOT_CONT_FROM AND "
				+ "IR_TOT_CONT_TO OR ? BETWEEN IR_TOT_CONT_FROM AND IR_TOT_CONT_TO) AND (? BETWEEN IR_TERM_FM "
				+ "AND IR_TERM_TO OR ? BETWEEN IR_TERM_FM AND IR_TERM_TO) AND ROWID<> ?";
		
		ResultSet rst;
		try {
			rst = new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{PM_IL_INTEREST_RATES_BEAN.getIR_EFF_FM_DT(),
				PM_IL_INTEREST_RATES_BEAN.getIR_EFF_TO_DT(),PM_IL_INTEREST_RATES_BEAN.getIR_TOT_CONT_FROM(),PM_IL_INTEREST_RATES_BEAN.getIR_TOT_CONT_TO(),
				PM_IL_INTEREST_RATES_BEAN.getIR_TERM_FM(),PM_IL_INTEREST_RATES_BEAN.getIR_TERM_TO(),PM_IL_INTEREST_RATES_BEAN.getROWID()});
			if(rst.next())
			{
				throw new Exception("This Combination already Exist ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		throw e;
		}
		
		}
		/*end*/
		
	}
