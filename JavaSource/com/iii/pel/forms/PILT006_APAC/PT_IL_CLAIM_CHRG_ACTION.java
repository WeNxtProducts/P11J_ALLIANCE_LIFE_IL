package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
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
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_DFLT_CHARGE;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_CLAIM_CHRG_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CC_CHRG_CODE_LABEL;

	public HtmlOutputLabel getCOMP_CC_CHRG_CODE_LABEL() {
		return COMP_CC_CHRG_CODE_LABEL;
	}



	public void setCOMP_CC_CHRG_CODE_LABEL(HtmlOutputLabel cOMP_CC_CHRG_CODE_LABEL) {
		COMP_CC_CHRG_CODE_LABEL = cOMP_CC_CHRG_CODE_LABEL;
	}

	private HtmlInputText COMP_CC_CHRG_CODE;

	public HtmlInputText getCOMP_CC_CHRG_CODE() {
		return COMP_CC_CHRG_CODE;
	}



	public void setCOMP_CC_CHRG_CODE(HtmlInputText cOMP_CC_CHRG_CODE) {
		COMP_CC_CHRG_CODE = cOMP_CC_CHRG_CODE;
	}

	private HtmlOutputLabel COMP_CC_RATE_LABEL;
	
	

	public HtmlOutputLabel getCOMP_CC_RATE_LABEL() {
		return COMP_CC_RATE_LABEL;
	}



	public void setCOMP_CC_RATE_LABEL(HtmlOutputLabel cOMP_CC_RATE_LABEL) {
		COMP_CC_RATE_LABEL = cOMP_CC_RATE_LABEL;
	}

	private HtmlInputText COMP_CC_RATE;

	public HtmlInputText getCOMP_CC_RATE() {
		return COMP_CC_RATE;
	}



	public void setCOMP_CC_RATE(HtmlInputText cOMP_CC_RATE) {
		COMP_CC_RATE = cOMP_CC_RATE;
	}

	private HtmlOutputLabel COMP_CC_RATE_PER_LABEL;

	public HtmlOutputLabel getCOMP_CC_RATE_PER_LABEL() {
		return COMP_CC_RATE_PER_LABEL;
	}



	public void setCOMP_CC_RATE_PER_LABEL(HtmlOutputLabel cOMP_CC_RATE_PER_LABEL) {
		COMP_CC_RATE_PER_LABEL = cOMP_CC_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_CC_RATE_PER() {
		return COMP_CC_RATE_PER;
	}



	public void setCOMP_CC_RATE_PER(HtmlInputText cOMP_CC_RATE_PER) {
		COMP_CC_RATE_PER = cOMP_CC_RATE_PER;
	}

	private HtmlInputText COMP_CC_RATE_PER;
	
	
	private HtmlOutputLabel COMP_CC_REMARKS_LABEL;
	

	public HtmlOutputLabel getCOMP_CC_REMARKS_LABEL() {
		return COMP_CC_REMARKS_LABEL;
	}



	public void setCOMP_CC_REMARKS_LABEL(HtmlOutputLabel cOMP_CC_REMARKS_LABEL) {
		COMP_CC_REMARKS_LABEL = cOMP_CC_REMARKS_LABEL;
	}

	private HtmlInputText COMP_CC_REMARKS;
	
	
	
	
	
	public HtmlInputText getCOMP_CC_REMARKS() {
		return COMP_CC_REMARKS;
	}



	public void setCOMP_CC_REMARKS(HtmlInputText cOMP_CC_REMARKS) {
		COMP_CC_REMARKS = cOMP_CC_REMARKS;
	}

	private HtmlOutputLabel COMP_CC_CHRG_FC_VALUE_LABEL;
	
	

	public HtmlOutputLabel getCOMP_CC_CHRG_FC_VALUE_LABEL() {
		return COMP_CC_CHRG_FC_VALUE_LABEL;
	}



	public void setCOMP_CC_CHRG_FC_VALUE_LABEL(
			HtmlOutputLabel cOMP_CC_CHRG_FC_VALUE_LABEL) {
		COMP_CC_CHRG_FC_VALUE_LABEL = cOMP_CC_CHRG_FC_VALUE_LABEL;
	}

	private HtmlInputText COMP_CC_CHRG_FC_VALUE;

	public HtmlInputText getCOMP_CC_CHRG_FC_VALUE() {
		return COMP_CC_CHRG_FC_VALUE;
	}



	public void setCOMP_CC_CHRG_FC_VALUE(HtmlInputText cOMP_CC_CHRG_FC_VALUE) {
		COMP_CC_CHRG_FC_VALUE = cOMP_CC_CHRG_FC_VALUE;
	}

	private HtmlOutputLabel COMP_CC_CHRG_LC_VALUE_LABEL;

	public HtmlOutputLabel getCOMP_CC_CHRG_LC_VALUE_LABEL() {
		return COMP_CC_CHRG_LC_VALUE_LABEL;
	}



	public void setCOMP_CC_CHRG_LC_VALUE_LABEL(
			HtmlOutputLabel cOMP_CC_CHRG_LC_VALUE_LABEL) {
		COMP_CC_CHRG_LC_VALUE_LABEL = cOMP_CC_CHRG_LC_VALUE_LABEL;
	}

	private HtmlInputText COMP_CC_CHRG_LC_VALUE;
	
	

	public HtmlInputText getCOMP_CC_CHRG_LC_VALUE() {
		return COMP_CC_CHRG_LC_VALUE;
	}



	public void setCOMP_CC_CHRG_LC_VALUE(HtmlInputText cOMP_CC_CHRG_LC_VALUE) {
		COMP_CC_CHRG_LC_VALUE = cOMP_CC_CHRG_LC_VALUE;
	}

	


	private PT_IL_CLAIM_CHRG PT_IL_CLAIM_CHRG_BEAN;

	public PT_IL_CLAIM_CHRG getPT_IL_CLAIM_CHRG_BEAN() {
		return PT_IL_CLAIM_CHRG_BEAN;
	}



	public void setPT_IL_CLAIM_CHRG_BEAN(PT_IL_CLAIM_CHRG pT_IL_CLAIM_CHRG_BEAN) {
		PT_IL_CLAIM_CHRG_BEAN = pT_IL_CLAIM_CHRG_BEAN;
	}

	private HtmlInputText COMP_UI_M_CC_CHRG_CODE_DESC;
	
	public HtmlInputText getCOMP_UI_M_CC_CHRG_CODE_DESC() {
		return COMP_UI_M_CC_CHRG_CODE_DESC;
	}



	public void setCOMP_UI_M_CC_CHRG_CODE_DESC(
			HtmlInputText cOMP_UI_M_CC_CHRG_CODE_DESC) {
		COMP_UI_M_CC_CHRG_CODE_DESC = cOMP_UI_M_CC_CHRG_CODE_DESC;
	}

	PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_CLAIM_CHRG_HELPER helper;
	
	private PT_IL_CLAIM_CHRG_DELEGATE pt_il_claim_chrg_delegate;

	private List<PT_IL_CLAIM_CHRG> dataList_PT_IL_SURR_CHRG = new ArrayList<PT_IL_CLAIM_CHRG>();

	private UIData dataTable;

	
	private List catgCodeList;
	
	public List getCatgCodeList() {
		return catgCodeList;
	}



	public void setCatgCodeList(List catgCodeList) {
		this.catgCodeList = catgCodeList;
	}



	public PT_IL_CLAIM_CHRG_ACTION() {

		PT_IL_CLAIM_CHRG_BEAN = new PT_IL_CLAIM_CHRG();
		helper = new PT_IL_CLAIM_CHRG_HELPER();
		pt_il_claim_chrg_delegate = new PT_IL_CLAIM_CHRG_DELEGATE();
		/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
		initialize();
		//END
		
		/*added by raja on 25-04-2017*/
		preparDropDownList();
		/*end*/
	}

	
	



	public List<PT_IL_CLAIM_CHRG> getDataList_PT_IL_SURR_CHRG() {
		return dataList_PT_IL_SURR_CHRG;
	}

	public void setDataListPT_IL_SURR_CHRG(
			List<PT_IL_CLAIM_CHRG> dataList_PT_IL_SURR_CHRG) {
		this.dataList_PT_IL_SURR_CHRG = dataList_PT_IL_SURR_CHRG;
	}

	public void addRow(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_CLAIM_CHRG_BEAN = new PT_IL_CLAIM_CHRG();
				resetAllComponent();
				resetSelectedRow();
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_IL_CLAIM_CHRG_BEAN,
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
								"errorPanel$message$delete"));
				dataList_PT_IL_SURR_CHRG.remove(PT_IL_CLAIM_CHRG_BEAN);
				if (dataList_PT_IL_SURR_CHRG.size() > 0) {

					PT_IL_CLAIM_CHRG_BEAN = dataList_PT_IL_SURR_CHRG.get(0);
				} else if (dataList_PT_IL_SURR_CHRG.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_CLAIM_CHRG_BEAN.setRowSelected(true);
			} else {

				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		CommonUtils.clearMaps(this);
		
		/*Added by Janani on 13.02.2018 for ZB charge duplicate check as per Sivaram's suggs.*/
		String exst_chk_query = null;
		Object[] params = null;
		CRUDHandler handler;
		ResultSet resultSet = null;
		
		/*End*/
		
		try {
			if (PT_IL_CLAIM_CHRG_BEAN.getROWID() == null) {
				if(isINSERT_ALLOWED()){
					helper.preInsert(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(),PT_IL_CLAIM_CHRG_BEAN);
					
					
					/*Added by Janani on 13.02.2018 for ZB charge duplicate check as per Sivaram's suggs.*/	
				
						exst_chk_query = "SELECT 'X' FROM PT_IL_CLAIM_CHARGES where CC_CHRG_CODE = ? AND CC_CLM_SYS_ID = ?";
						params = new Object[]{PT_IL_CLAIM_CHRG_BEAN.getCC_CHRG_CODE(),compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getPT_IL_CLAIM_CHRG_BEAN().getCC_CLM_SYS_ID()};
				

					handler = new CRUDHandler();
					Connection connection = CommonUtils.getConnection();

					resultSet = handler.executeSelectStatement(exst_chk_query,connection,params);
					if(resultSet.next()){

						throw new Exception("Charge already exists.");
					}else
					{
					/*End*/
					
					
					new CRUDHandler().executeInsert(PT_IL_CLAIM_CHRG_BEAN,
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
							"errorPanel$message$save"));
					dataList_PT_IL_SURR_CHRG.add(PT_IL_CLAIM_CHRG_BEAN);
					
					}
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PT_IL_CLAIM_CHRG_BEAN.getROWID() != null) {

				if(isUPDATE_ALLOWED()){
					
					/*Added by Janani on 13.02.2018 for ZB charge duplicate check as per Sivaram's suggs.*/	
				
						exst_chk_query = "SELECT 'X' FROM PT_IL_CLAIM_CHARGES where CC_CHRG_CODE = ? AND CC_CLM_SYS_ID = ? AND ROWID<> ?";
						params = new Object[]{PT_IL_CLAIM_CHRG_BEAN.getCC_CHRG_CODE(),compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getPT_IL_CLAIM_CHRG_BEAN().getCC_CLM_SYS_ID(),
								PT_IL_CLAIM_CHRG_BEAN.getROWID()};

					
					handler = new CRUDHandler();
					Connection connection = CommonUtils.getConnection();

					resultSet = handler.executeSelectStatement(exst_chk_query,connection,params);
					if(resultSet.next()){

						throw new Exception("Charge already exists.");
					}else
					{
					/*End*/
					
					
					new CRUDHandler().executeUpdate(PT_IL_CLAIM_CHRG_BEAN,
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
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
			}
			
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().keyCommitt();
			PT_IL_CLAIM_CHRG_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_CLAIM_CHRG_BEAN = (PT_IL_CLAIM_CHRG) dataTable.getRowData();
			//helper.POST_QUERY(compositeAction);
			/*added by raja on 25-04-2017*/
			checkBefCode();
			/*end*/			
			
			PT_IL_CLAIM_CHRG_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_CLAIM_CHRG> PT_IL_SURR_CHRG_ITR = dataList_PT_IL_SURR_CHRG
				.iterator();
		while (PT_IL_SURR_CHRG_ITR.hasNext()) {
			PT_IL_SURR_CHRG_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_CC_CHRG_CODE.resetValue();
		COMP_CC_RATE.resetValue();
		COMP_CC_RATE_PER.resetValue();
		COMP_CC_CHRG_FC_VALUE.resetValue();
		COMP_CC_CHRG_LC_VALUE.resetValue();
		COMP_CC_REMARKS.resetValue();

		
		/*added by raja on 25-04-2017*/
		COMP_CC_PAID_TO.resetValue();
		COMP_CC_BENF_CODE.resetValue();
		COMP_CC_BENF_CODE_DESC.resetValue();
		/*end*/
		
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*public void CC_RATE_Validator(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			PT_IL_CLAIM_CHRG_BEAN.setCC_RATE((Double) value);
			helper.CC_RATE_WHEN_VALIDATE_ITEM(compositeAction, value);
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
*/
	/*public void SRC_RATE_PER_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_CHRG_BEAN().setSRC_RATE_PER((Double) value);
			helper.SRC_RATE_PER_WHEN_VALIDATE_ITEM(compositeAction, value);
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
	}*/

/*	public void SRC_CUST_SHARE_PERC_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_SURR_CHRG_BEAN().setSRC_CUST_SHARE_PERC((Double) value);
			helper.SRC_CUST_SHARE_PERC_WHEN_VALIDATE_ITEM(compositeAction,
					value);
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
	}*/
	
	
//GOPI
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				//helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.executeQuery(compositeAction);
				if(compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getPT_IL_CLAIM_CHRG_BEAN().getROWID()!=null)
				//helper.POST_QUERY(compositeAction);
			
					/*added by raja on 25-04-2017*/
					checkBefCode();
					/*end*/
					
					setBlockFlag(false);
				
				/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
				if (("Y".equalsIgnoreCase(compositeAction
						.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
						.getCLAIM_FRZ_FLAG()))
						|| ("Y".equalsIgnoreCase(compositeAction
								.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
								.getCLAIM_CLOSE_FLAG()))
						|| ("CL05".equalsIgnoreCase(compositeAction
								.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
								.getCLAIM_ADDL_STATUS()))		) {
					
					disableall(true);
					
				} 
				/*END*/
				
				/*Added by saritha on 21-02-2018 for Claim Charge Screen Create,Delete &Post button enable/disable as per siva sir sugg.*/
				
				if("Y".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG()) &&
						"Y".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_CONFIRM_FLAG())){
					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_ADD().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_DEL().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_POST().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getCOMP_CC_RATE().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getCOMP_CC_RATE_PER().setDisabled(true);

				}else{

					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_ADD().setDisabled(false);
					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_DEL().setDisabled(false);
					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_POST().setDisabled(false);
					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getCOMP_CC_RATE().setDisabled(false);
					compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getCOMP_CC_RATE_PER().setDisabled(false);
				}
				
				/*End*/
				
			}
			
			
			/*added by raja on 14-08-2017 for ZBILQC-1726834*/
			
			
			if(PT_IL_CLAIM_CHRG_BEAN.getROWID()!=null)
			{
				
				boolean flag=false;
				
				if(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getDataList_PT_IL_CLAIM_COVER_DTLS().size()>0)
				{
				
			for(PT_IL_CLAIM_COVER_DTLS bean:compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getDataList_PT_IL_CLAIM_COVER_DTLS())
			{
			 if(bean.getCCD_FRZ_FLAG().equalsIgnoreCase("N"))
			 {
				 flag=true; 
			 }
			}
				}
				else
				{
					flag=true; 
				}
			
			if(flag==true)
			{
				
				/*Added by saritha on 28-02-2018 for Charge Foreign Currency Amount calculation Issues*/
				/*COMP_CC_CHRG_CODE.setDisabled(true);
				COMP_CC_RATE.setDisabled(true);
				COMP_CC_RATE_PER.setDisabled(true);*/
				/*End*/
				COMP_CC_REMARKS.setDisabled(true);
				COMP_CC_CHRG_FC_VALUE.setDisabled(true);
				COMP_CC_CHRG_LC_VALUE.setDisabled(true);

				/*Added by Janani on 06.09.2017 for ZBILQC-1726834*/
				//COMP_CC_PAID_TO.setDisabled(true);
				//COMP_CC_BENF_CODE.setDisabled(true);

				String chrg_code = compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getPT_IL_CLAIM_CHRG_BEAN().getCC_CHRG_CODE();
				
				System.out.println("getCC_CHRG_CODE               "+chrg_code);
				
				if(chrg_code != null && chrg_code.equalsIgnoreCase("HOSP-FEE"))
				{
					COMP_CC_PAID_TO.setDisabled(false);
					COMP_CC_BENF_CODE.setDisabled(false);
				}
				else
				{
					COMP_CC_PAID_TO.setDisabled(true);
					COMP_CC_BENF_CODE.setDisabled(true);
				}
				
				
				/*End of ZBILQC-1726834*/
								
			}
			else
			{
				COMP_CC_CHRG_CODE.setDisabled(true);
				COMP_CC_RATE.setDisabled(true);
				COMP_CC_RATE_PER.setDisabled(true);
				COMP_CC_REMARKS.setDisabled(true);
				COMP_CC_CHRG_FC_VALUE.setDisabled(true);
				COMP_CC_CHRG_LC_VALUE.setDisabled(true);
				COMP_CC_PAID_TO.setDisabled(true);
				COMP_CC_BENF_CODE.setDisabled(true);
				/*Added by saritha on 21-02-2018 for Claim Charge Screen Create,Delete &Post button enable/disable as per siva sir sugg.*/
				/*UI_CHA_BUT_ADD.setDisabled(true);
				UI_CHA_BUT_DEL.setDisabled(true);
				UI_CHA_BUT_POST.setDisabled(true);*/
				/*End*/
			}
			}
			
			else
			{
				COMP_CC_CHRG_CODE.setDisabled(false);
				COMP_CC_RATE.setDisabled(false);
				COMP_CC_RATE_PER.setDisabled(false);
				COMP_CC_REMARKS.setDisabled(false);
				/*Added by saritha on 28-02-2018 for Charge Foreign Currency Amount calculation Issues*/
				/*COMP_CC_CHRG_FC_VALUE.setDisabled(false);
				  COMP_CC_CHRG_LC_VALUE.setDisabled(false);*/
				/*End*/
				COMP_CC_CHRG_FC_VALUE.setDisabled(true);
				COMP_CC_CHRG_LC_VALUE.setDisabled(true);
				COMP_CC_PAID_TO.setDisabled(false);
				COMP_CC_BENF_CODE.setDisabled(false);
			}
			/*end*/
		} catch (Exception e) {
			
			e.printStackTrace();
			
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public List suggestionActionCatgCode(Object event) {
		String catgCode = (String) event;
		try {
/*Modified by Janani on 05.09.2017 for ZBILQC-1732454*/
			
			/*catgCodeList = pt_il_claim_chrg_delegate.prepareCatgCodeList(
					catgCode, catgCodeList);*/
			
			catgCodeList = pt_il_claim_chrg_delegate.prepareCatgCodeList(
					catgCode, catgCodeList,compositeAction);
			
			/*End of ZBILQC-1732454*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catgCodeList;
	}

	public String getCatgDescforCode(String catgCode, List catgCodeList) {
		Iterator iterator = catgCodeList.iterator();
		String catgDesc = null;
		while (iterator.hasNext()) {
			PT_IL_CLAIM_CHRG pm_il_contractor = (PT_IL_CLAIM_CHRG) iterator
					.next();
			// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
			if (catgCode.equalsIgnoreCase(pm_il_contractor.getCC_CHRG_CODE())) {
				catgDesc = pm_il_contractor.getUI_M_CC_CHRG_CODE_DESC();
			}
		}
		return catgDesc;
	}

	public void getCatgCodeDesc(ActionEvent event) {
		if (COMP_CC_CHRG_CODE.getSubmittedValue() != null) {
			String catgCode = (String) COMP_CC_CHRG_CODE.getSubmittedValue();
			String catgCodeDesc = getCatgDescforCode(catgCode, catgCodeList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PT_IL_CLAIM_CHRG_BEAN.setUI_M_CC_CHRG_CODE_DESC(catgCodeDesc);
			COMP_UI_M_CC_CHRG_CODE_DESC.setSubmittedValue(catgCodeDesc);
		}
	}
	public void validateDDCHG_CODE(FacesContext fc, UIComponent component,
			Object value) {
		try {
			
			helper.DDCHG_CODE_WHEN_VALIDATE_ITEM(
					(String) value,this.PT_IL_CLAIM_CHRG_BEAN);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
	
	private HtmlAjaxCommandButton UI_CHA_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_CHA_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_CHA_BUT_POST;
	
	
	
	
	public HtmlAjaxCommandButton getUI_CHA_BUT_ADD() {
		return UI_CHA_BUT_ADD;
	}



	public void setUI_CHA_BUT_ADD(HtmlAjaxCommandButton uI_CHA_BUT_ADD) {
		UI_CHA_BUT_ADD = uI_CHA_BUT_ADD;
	}



	public HtmlAjaxCommandButton getUI_CHA_BUT_DEL() {
		return UI_CHA_BUT_DEL;
	}



	public void setUI_CHA_BUT_DEL(HtmlAjaxCommandButton uI_CHA_BUT_DEL) {
		UI_CHA_BUT_DEL = uI_CHA_BUT_DEL;
	}



	public HtmlAjaxCommandButton getUI_CHA_BUT_POST() {
		return UI_CHA_BUT_POST;
	}



	public void setUI_CHA_BUT_POST(HtmlAjaxCommandButton uI_CHA_BUT_POST) {
		UI_CHA_BUT_POST = uI_CHA_BUT_POST;
	}



	void disableall(Boolean flag){
		COMP_CC_CHRG_CODE.setDisabled(flag);
		COMP_CC_RATE.setDisabled(flag);
		COMP_CC_RATE_PER.setDisabled(flag);
		COMP_CC_REMARKS.setDisabled(flag);
		COMP_CC_CHRG_FC_VALUE.setDisabled(flag);
		COMP_CC_CHRG_LC_VALUE.setDisabled(flag);
		UI_CHA_BUT_ADD.setDisabled(flag);
		UI_CHA_BUT_DEL.setDisabled(flag);
		 UI_CHA_BUT_POST.setDisabled(flag);
		 
		 /*added by raja on 25-04-2017*/
			COMP_CC_PAID_TO.setDisabled(flag);
			COMP_CC_BENF_CODE.setDisabled(flag);
			/*end*/
		
	}
	
	void initialize(){
		COMP_CC_CHRG_CODE = new HtmlInputText();
		COMP_CC_RATE=new HtmlInputText();
		COMP_CC_RATE_PER=new HtmlInputText();
		COMP_CC_REMARKS=new HtmlInputText();
		COMP_CC_CHRG_FC_VALUE=new HtmlInputText();
		COMP_CC_CHRG_LC_VALUE=new HtmlInputText();
		/*added by sankara narayanan for disable all component while the status cl05*/
		UI_CHA_BUT_ADD = new HtmlAjaxCommandButton();
		UI_CHA_BUT_DEL= new HtmlAjaxCommandButton();
		 UI_CHA_BUT_POST= new HtmlAjaxCommandButton();
		 /*end*/
		
		 /*added by raja on 25-04-2017*/
			COMP_CC_PAID_TO=new HtmlSelectOneMenu();
			COMP_CC_BENF_CODE=new HtmlInputText();
			COMP_CC_BENF_CODE_DESC=new HtmlInputText();
			/*end*/
		 
		 
	}
	/*END*/
	
	
	/*added by raja on 25-04-2017*/
	private HtmlOutputLabel COMP_CC_PAID_TO_LABEL;
	private HtmlOutputLabel COMP_CC_BENF_CODE_LABEL;
	private HtmlSelectOneMenu COMP_CC_PAID_TO;
	private HtmlInputText COMP_CC_BENF_CODE;
	private HtmlInputText COMP_CC_BENF_CODE_DESC;
	
	
	public HtmlInputText getCOMP_CC_BENF_CODE_DESC() {
		return COMP_CC_BENF_CODE_DESC;
	}



	public void setCOMP_CC_BENF_CODE_DESC(HtmlInputText cOMP_CC_BENF_CODE_DESC) {
		COMP_CC_BENF_CODE_DESC = cOMP_CC_BENF_CODE_DESC;
	}



	public HtmlOutputLabel getCOMP_CC_PAID_TO_LABEL() {
		return COMP_CC_PAID_TO_LABEL;
	}

	public void setCOMP_CC_PAID_TO_LABEL(HtmlOutputLabel cOMP_CC_PAID_TO_LABEL) {
		COMP_CC_PAID_TO_LABEL = cOMP_CC_PAID_TO_LABEL;
	}

	public HtmlOutputLabel getCOMP_CC_BENF_CODE_LABEL() {
		return COMP_CC_BENF_CODE_LABEL;
	}

	public void setCOMP_CC_BENF_CODE_LABEL(HtmlOutputLabel cOMP_CC_BENF_CODE_LABEL) {
		COMP_CC_BENF_CODE_LABEL = cOMP_CC_BENF_CODE_LABEL;
	}

	
	public HtmlSelectOneMenu getCOMP_CC_PAID_TO() {
		return COMP_CC_PAID_TO;
	}



	public void setCOMP_CC_PAID_TO(HtmlSelectOneMenu cOMP_CC_PAID_TO) {
		COMP_CC_PAID_TO = cOMP_CC_PAID_TO;
	}



	public HtmlInputText getCOMP_CC_BENF_CODE() {
		return COMP_CC_BENF_CODE;
	}

	public void setCOMP_CC_BENF_CODE(HtmlInputText cOMP_CC_BENF_CODE) {
		COMP_CC_BENF_CODE = cOMP_CC_BENF_CODE;
	}
	
	private List<SelectItem> listCC_PAID_TO = new ArrayList<SelectItem>();

	public List<SelectItem> getListCC_PAID_TO() {
		return listCC_PAID_TO;
	}

	public void setListCC_PAID_TO(List<SelectItem> listCC_PAID_TO) {
		this.listCC_PAID_TO = listCC_PAID_TO;
	}
	
	public void preparDropDownList() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			
			
			listCC_PAID_TO = ListItemUtil.getDropDownListValue(connection,
					"PILT006_APAC", "PT_IL_CLAIM_CHARGES",
					"PT_IL_CLAIM_CHARGES.CC_PAID_TO", "IL_CLM_CHRG");
			/*listCC_PAID_TO = ListItemUtil.getDropDownListValue(connection,
					"PILT002_APAC", "PT_IL_POL_MED_EXAM_DTL",
					"PT_IL_POL_MED_EXAM_DTL.PMED_STATUS", "CHKLST_STS");*/
			
			/*End*/
		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}

	}
	
	public ArrayList<LovBean> lovCC_BENF_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT006_APAC";
		String blockName = "PT_IL_CLAIM_CHARGES";
		String fieldName = "CC_BENF_CODE";
		String param1=null;
		
		try {
			
			if(PT_IL_CLAIM_CHRG_BEAN.getCC_PAID_TO()!=null)
			{
				if( PT_IL_CLAIM_CHRG_BEAN.getCC_PAID_TO().equalsIgnoreCase("H"))
				{
					param1="CLNC";
				}
				else if(PT_IL_CLAIM_CHRG_BEAN.getCC_PAID_TO().equalsIgnoreCase("D"))
				{
					param1="DOC";
				}
				else
				{
					param1=null;
				}
			}
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
	
	
	
	public void validateCC_PAID_TO(FacesContext fc, UIComponent component,
			Object value) {
		try {
			PT_IL_CLAIM_CHRG_BEAN.setCC_PAID_TO(value.toString());
			
			checkBefCode();
			
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void checkBefCode()
	{
		
		/*CONDITION CHANGED BY RAJA ON 18-05-2017*/
		if(PT_IL_CLAIM_CHRG_BEAN.getCC_PAID_TO()!=null && !PT_IL_CLAIM_CHRG_BEAN.getCC_PAID_TO().equalsIgnoreCase("A") /*&&
				!compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_STATUS().equalsIgnoreCase("A")*/)
		{
			COMP_CC_BENF_CODE.setDisabled(false);
		}
		else
		{
			COMP_CC_BENF_CODE.setDisabled(true);
			PT_IL_CLAIM_CHRG_BEAN.setCC_BENF_CODE(null);
			PT_IL_CLAIM_CHRG_BEAN.setCC_BENF_CODE_DESC(null);
			COMP_CC_BENF_CODE.resetValue();
			COMP_CC_BENF_CODE_DESC.resetValue();
		}
		if(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_STATUS().equalsIgnoreCase("A"))
		{
			COMP_CC_BENF_CODE.setDisabled(true);
		}
	}
	/*end*/
	
	
	public void validateCC_BENF_CODE(FacesContext fc, UIComponent component,
			Object value) {
		try {
			
/*added by raja on 10-07-2017 for ZBILQC-1731018*/ 
			
			LIFELIB lifelib = new LIFELIB();
			 lifelib.P_VAL_CUST(PT_IL_CLAIM_CHRG_BEAN.getCC_BENF_CODE(),
					 PT_IL_CLAIM_CHRG_BEAN.getCC_BENF_CODE_DESC(), "N", "N",
					 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());
			 
			/*end*/
			PT_IL_CLAIM_CHRG_BEAN.setCC_BENF_CODE(value.toString());
			
		
			
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*added by raja on 14-08-2017 for ZBILQC-1726834*/
	
	public void validateCC_CHRG_FC_VALUE(FacesContext fc, UIComponent component,
			Object value) {
		try {
			
			PT_IL_CLAIM_CHRG_BEAN.setCC_CHRG_FC_VALUE((Double)value);
			/*Added by saritha on 28-02-2018 for Charge Foreign Currency Amount calculation Issues*/
			//PT_IL_CLAIM_CHRG_BEAN.setCC_CHRG_LC_VALUE(PT_IL_CLAIM_CHRG_BEAN.getCC_CHRG_FC_VALUE());
			//COMP_CC_CHRG_LC_VALUE.resetValue();
			/*End*/
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*end*/
	
	/*Added by saritha on 28-02-2018 for Charge Foreign Currency Amount calculation Issues*/
	
	public void validatorCC_RATE(FacesContext fc, UIComponent component,
			Object value)  throws ValidatorException {
		try {
			
			PT_IL_CLAIM_CHRG_BEAN.setCC_RATE((Double)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCC_RATE_PER(FacesContext fc, UIComponent component,
			Object value)  throws ValidatorException{

		ArrayList<OracleParameter> procList = new ArrayList<OracleParameter>();
		double FC_Charge_Amt=0.0;
		double P_CC_CHRG_FC_VALUE = 0.0;

		try {

			PT_IL_CLAIM_CHRG_BEAN.setCC_RATE_PER((Double)value);

			procList=helper.callP_INS_CLM_ADD_DEL_CHRGS(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID(),getPT_IL_CLAIM_CHRG_BEAN().getCC_CHRG_CODE(),
					getPT_IL_CLAIM_CHRG_BEAN().getCC_RATE(),getPT_IL_CLAIM_CHRG_BEAN().getCC_RATE_PER(),P_CC_CHRG_FC_VALUE);

			if (procList != null && !procList.isEmpty()) {
				if (procList.get(0).getValueObject() != null) {
					FC_Charge_Amt = (double)procList.get(0).getValueObject();
					PT_IL_CLAIM_CHRG_BEAN.setCC_CHRG_FC_VALUE(FC_Charge_Amt);
					PT_IL_CLAIM_CHRG_BEAN.setCC_CHRG_LC_VALUE(FC_Charge_Amt);

				}
			}

			COMP_CC_CHRG_FC_VALUE.resetValue();
			COMP_CC_CHRG_LC_VALUE.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*End*/
	
}
