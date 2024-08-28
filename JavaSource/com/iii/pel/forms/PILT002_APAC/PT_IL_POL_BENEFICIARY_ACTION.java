package com.iii.pel.forms.PILT002_APAC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.utl_smtp.connection;

public class PT_IL_POL_BENEFICIARY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PBEN_SR_NO_LABEL;

	private HtmlInputText COMP_PBEN_SR_NO;

	private HtmlOutputLabel COMP_PBEN_BNF_TYPE_LABEL;

	private HtmlInputText COMP_PBEN_BNF_TYPE;

	private HtmlOutputLabel COMP_PBEN_REF_ID1_LABEL;

	private HtmlInputText COMP_PBEN_REF_ID1;

	private HtmlOutputLabel COMP_PBEN_REF_ID2_LABEL;

	private HtmlInputText COMP_PBEN_REF_ID2;

	private String DEFAULT_WHERE;

	private HtmlOutputLabel COMP_PBEN_CATG_CODE_LABEL;

	private HtmlInputText COMP_PBEN_CATG_CODE;

	private HtmlOutputLabel COMP_PBEN_AGE_LABEL;

	private HtmlInputText COMP_PBEN_AGE;

	private HtmlOutputLabel COMP_PBEN_RELATION_CODE_LABEL;

	private HtmlInputText COMP_PBEN_RELATION_CODE;

	private HtmlOutputLabel COMP_PBEN_PERC_LABEL;

	private HtmlInputText COMP_PBEN_PERC;

	private HtmlOutputLabel COMP_PBEN_GUARDIAN_NAME_LABEL;

	private HtmlInputText COMP_PBEN_GUARDIAN_NAME;

	private HtmlOutputLabel COMP_PBEN_ADDRESS_1_LABEL;

	private HtmlInputText COMP_PBEN_ADDRESS_1;

	private HtmlOutputLabel COMP_PBEN_BNF_NAME_LABEL;

	private HtmlInputText COMP_PBEN_BNF_NAME;

	private HtmlOutputLabel COMP_PBEN_ADDRESS_3_LABEL;

	private HtmlInputText COMP_PBEN_ADDRESS_3;

	private HtmlOutputLabel COMP_PBEN_ADDRESS_2_LABEL;

	private HtmlInputText COMP_PBEN_ADDRESS_2;

	private HtmlOutputLabel COMP_PBEN_REMARKS_LABEL;

	private HtmlInputText COMP_PBEN_REMARKS;

	private HtmlOutputLabel COMP_PBEN_ADDRESS_4_LABEL;

	private HtmlInputText COMP_PBEN_ADDRESS_4;

	private HtmlOutputLabel COMP_UI_M_CATG_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CATG_DESC;

	private HtmlOutputLabel COMP_PBEN_ADDRESS_5_LABEL;

	private HtmlInputText COMP_PBEN_ADDRESS_5;

	private HtmlOutputLabel COMP_UI_M_PBEN_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PBEN_TYPE_DESC;

	private HtmlOutputLabel COMP_UI_M_PBEN_RELATION_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PBEN_RELATION_DESC;



	//[ADDED BY AKASH TO IMPLEMENT DIRECT DEBIT AND CREDIT 

	private HtmlOutputLabel COMP_PBEN_MICR_CODE_LABEL;

	private HtmlInputText COMP_PBEN_MICR_CODE;


	private HtmlOutputLabel COMP_PBEN_ACNT_NO_LABEL;

	private HtmlInputText COMP_PBEN_ACNT_NO ;


	private HtmlOutputLabel COMP_UI_M_CITY_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CITY_CODE;
	private HtmlInputText COMP_UI_M_CITY_CODE_DESC;


	private HtmlOutputLabel COMP_UI_M_BANK_CODE_LABEL;

	private HtmlInputText COMP_UI_M_BANK_CODE;
	private HtmlInputText COMP_UI_M_BANK_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_BRANCH_CODE_LABEL;

	private HtmlInputText COMP_UI_M_BRANCH_CODE;
	private HtmlInputText COMP_UI_M_BRANCH_CODE_DESC;

	//ADDED BY AKASH TO IMPLEMENT DIRECT DEBIT AND CREDIT]


	private PT_IL_POL_BENEFICIARY PT_IL_POL_BENEFICIARY_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_BENEFICIARY_HELPER helper;

	private List<PT_IL_POL_BENEFICIARY> dataList_PT_IL_POL_BENEFICIARY = new ArrayList<PT_IL_POL_BENEFICIARY>();

	private UIData dataTable;

	private Double PBEN_SUM_PERC;

	public Double getPBEN_SUM_PERC() {
		return PBEN_SUM_PERC;
	}



	public void setPBEN_SUM_PERC(Double pben_sum_perc) {
		PBEN_SUM_PERC = pben_sum_perc;
	}



	public PT_IL_POL_BENEFICIARY_ACTION() {

		PT_IL_POL_BENEFICIARY_BEAN = new PT_IL_POL_BENEFICIARY();
		helper = new PT_IL_POL_BENEFICIARY_HELPER();
		instantiateAllComponent();
		itemListGUARD_IC_TYPE=PT_IL_POL_BENEFICIARY_DELEGATE
				.getDropDownListValue("PILT002_APAC", "PT_IL_POL_BENEFICIARY", "PT_IL_POL_BENEFICIARY.PBEN_GUARDIAN_ID_TYPE", "IC_TYPE");
		itemListBENF_IC_TYPE = PT_IL_POL_BENEFICIARY_DELEGATE
				.getDropDownListValue("PILT002_APAC", "PT_IL_POL_BENEFICIARY", "PT_IL_POL_BENEFICIARY.PBEN_BENEF_ID_TYPE", "IC_TYPE");
	}



	public HtmlOutputLabel getCOMP_PBEN_ADDRESS_3_LABEL() {
		return COMP_PBEN_ADDRESS_3_LABEL;
	}

	public HtmlInputText getCOMP_PBEN_ADDRESS_3() {
		return COMP_PBEN_ADDRESS_3;
	}

	public void setCOMP_PBEN_ADDRESS_3_LABEL(
			HtmlOutputLabel COMP_PBEN_ADDRESS_3_LABEL) {
		this.COMP_PBEN_ADDRESS_3_LABEL = COMP_PBEN_ADDRESS_3_LABEL;
	}

	public void setCOMP_PBEN_ADDRESS_3(HtmlInputText COMP_PBEN_ADDRESS_3) {
		this.COMP_PBEN_ADDRESS_3 = COMP_PBEN_ADDRESS_3;
	}

	public void setCOMP_UI_M_PBEN_RELATION_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PBEN_RELATION_DESC_LABEL) {
		this.COMP_UI_M_PBEN_RELATION_DESC_LABEL = COMP_UI_M_PBEN_RELATION_DESC_LABEL;
	}

	public void setCOMP_UI_M_PBEN_RELATION_DESC(
			HtmlInputText COMP_UI_M_PBEN_RELATION_DESC) {
		this.COMP_UI_M_PBEN_RELATION_DESC = COMP_UI_M_PBEN_RELATION_DESC;
	}

	public PT_IL_POL_BENEFICIARY getPT_IL_POL_BENEFICIARY_BEAN() {
		return PT_IL_POL_BENEFICIARY_BEAN;
	}

	public void setPT_IL_POL_BENEFICIARY_BEAN(
			PT_IL_POL_BENEFICIARY PT_IL_POL_BENEFICIARY_BEAN) {
		this.PT_IL_POL_BENEFICIARY_BEAN = PT_IL_POL_BENEFICIARY_BEAN;
	}

	public List<PT_IL_POL_BENEFICIARY> getDataList_PT_IL_POL_BENEFICIARY() {
		return dataList_PT_IL_POL_BENEFICIARY;
	}

	public void setDataListPT_IL_POL_BENEFICIARY(
			List<PT_IL_POL_BENEFICIARY> dataList_PT_IL_POL_BENEFICIARY) {
		this.dataList_PT_IL_POL_BENEFICIARY = dataList_PT_IL_POL_BENEFICIARY;
	}

	public void addRow(ActionEvent event) {
		String message = null;
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_POL_BENEFICIARY_BEAN = new PT_IL_POL_BENEFICIARY();
				/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				helper.whenCreateRecord(compositeAction,this);
				/*End*/
				resetAllComponent();
				resetSelectedRow();
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"); 
				getErrorMap().put("addRow",message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}

		} catch (Exception exc) {
			/*commented by saranya*/

			/*getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());*/
			exc.printStackTrace();
		}

	}
	/*Modified by saranya for Avoidance of POST button required in all screens on 22-02-2017*/
	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				helper.keyDelRec(PT_IL_POL_BENEFICIARY_BEAN);
				new CRUDHandler().executeDelete(PT_IL_POL_BENEFICIARY_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
				dataList_PT_IL_POL_BENEFICIARY.remove(PT_IL_POL_BENEFICIARY_BEAN);
				if (dataList_PT_IL_POL_BENEFICIARY.size() > 0) {
					PT_IL_POL_BENEFICIARY_BEAN = dataList_PT_IL_POL_BENEFICIARY.get(0);
				} 
				/* commented by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				else if (dataList_PT_IL_POL_BENEFICIARY.size() == 0) {
				addRow(null);
			}
				/*end*/
				resetAllComponent();
				PT_IL_POL_BENEFICIARY_BEAN.setRowSelected(true);
				CommonUtils.getConnection().commit();
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
			}

			getWarningMap().put("deleteRow",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}
	/*End*/
	/*Modified by saranya for Avoidance of POST button required in all screens on 22-02-2017*/
	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			/*Modified by Ganesh on 27-10-2017 for ssp call id ZBLIFE-1437658*/
			//commneted by gopi
			/*if(COMP_PBEN_GUARDIAN_NAME.isRequired() && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_GUARDIAN_NAME()==null){
				
				throw new Exception("Guardian Name:Validation Error: Value is required.");
			}*/
			
			if (PT_IL_POL_BENEFICIARY_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				if("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())){
					if(dataList_PT_IL_POL_BENEFICIARY.size()>=1){
						
						throw new Exception("Unable to add more than 1 Beneficiary for this Product");
			/*End*/
					}
				}
				helper.preInsert(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(),PT_IL_POL_BENEFICIARY_BEAN);
				/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				
				/*changed by R. Raja on 24-03-2017 for ssp call ZBILQC-1719436*/
				
//				helper.validate_benf_type(this);
				
				
				helper.validate_benf_type(compositeAction,this);
				/*end*/	
				
				/*Added by Ameen on 04-04-2017 as per vinoth sugg. to validate the benf. % value*/ 
				Double UI_M_SUM_PBEN_PERC = 0.0 ;
				for(PT_IL_POL_BENEFICIARY  bn: getDataList_PT_IL_POL_BENEFICIARY()) {
					UI_M_SUM_PBEN_PERC = UI_M_SUM_PBEN_PERC + bn.getPBEN_PERC();
				}
				if(!getDataList_PT_IL_POL_BENEFICIARY().contains(PT_IL_POL_BENEFICIARY_BEAN)){
					UI_M_SUM_PBEN_PERC = UI_M_SUM_PBEN_PERC + PT_IL_POL_BENEFICIARY_BEAN.getPBEN_PERC();
				}

				if(UI_M_SUM_PBEN_PERC != null){
					if (UI_M_SUM_PBEN_PERC > 100.00) {
						throw new Exception((Messages.getString(PELConstants.pelErrorMessagePath, "91136")));
					}
				}

			

				/*End*/
				
				/*added by raja on 10-07-2017 for ZBILQC-1731018*/ 

				LIFELIB lifelib = new LIFELIB();
				 lifelib.P_VAL_CUST(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_CODE(),
						 PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_NAME(), "N", "N",
						 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());
				 
				/*end*/
				 
				 /*added by Ganesh on 04-09-2017 as suggested by Ajoy*/ 
				if (CommonUtils.nvl(compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
						.getPOL_END_NO_IDX(), 0) > 0
						&& CommonUtils.nvl(
								compositeAction.getPT_IL_POLICY_ACTION_BEAN()
										.getPT_IL_POLICY_BEAN()
										.getPOL_END_CODE(), "000")
								.equalsIgnoreCase("GEN002")) {
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REC_TYPE(3);

				} else {
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REC_TYPE(1);
				}
				 /*end*/
				
				
				/*Added by Janani on 29.03.2018 for KIC*/
				int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
				System.out.println("benfField ====>>" +benfField);
				
				/*
				 * 
				 * commented by Dhinesh on 30-05-2018 
				 * 
				 * if(benfField == 0)*/
				if(benfField == 0 || benfField == 2)
				{
					if((getCOMP_PBEN_BNF_NAME().isRequired() == true) && 
							PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_NAME().isEmpty() || PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_NAME() == null)
					{
						throw new Exception("Beneficiary Name: Validation Error: Value is required.");
					}else
					{
				
						/*End*/
						
				new CRUDHandler().executeInsert(PT_IL_POL_BENEFICIARY_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				dataList_PT_IL_POL_BENEFICIARY.add(PT_IL_POL_BENEFICIARY_BEAN);
				
					}

			} else
			{
				new CRUDHandler().executeInsert(PT_IL_POL_BENEFICIARY_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				dataList_PT_IL_POL_BENEFICIARY.add(PT_IL_POL_BENEFICIARY_BEAN);
			}
				
			}
				else if (PT_IL_POL_BENEFICIARY_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				helper.preUpdate(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(),PT_IL_POL_BENEFICIARY_BEAN);

				/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

				/*changed by R. Raja on 24-03-2017 for ssp call ZBILQC-1719436*/
				
				//helper.validate_benf_type(this);
				
				helper.validate_benf_type(compositeAction,this);
				/*end*/
				
				
				/*Added by Ameen on 04-04-2017 as per vinoth sugg. to validate the benf. % value*/ 
				Double UI_M_SUM_PBEN_PERC = 0.0 ;
				for(PT_IL_POL_BENEFICIARY  bn: getDataList_PT_IL_POL_BENEFICIARY()) {
					UI_M_SUM_PBEN_PERC = UI_M_SUM_PBEN_PERC + bn.getPBEN_PERC();
				}
				if(!getDataList_PT_IL_POL_BENEFICIARY().contains(PT_IL_POL_BENEFICIARY_BEAN)){
					UI_M_SUM_PBEN_PERC = UI_M_SUM_PBEN_PERC + PT_IL_POL_BENEFICIARY_BEAN.getPBEN_PERC();
				}

				if(UI_M_SUM_PBEN_PERC != null){
					if (UI_M_SUM_PBEN_PERC > 100.00) {
						throw new Exception((Messages.getString(PELConstants.pelErrorMessagePath, "91136")));
					}
				}


				/*End*/
				
				/*added by raja on 10-07-2017 for ZBILQC-1731018*/ 

				LIFELIB lifelib = new LIFELIB();
				 lifelib.P_VAL_CUST(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_CODE(),
						 PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_NAME(), "N", "N",
						 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());
				 
				/*end*/
				 
				 /*added by Ganesh on 04-09-2017 as suggested by Ajoy*/ 
				 if (CommonUtils.nvl(compositeAction
							.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
							.getPOL_END_NO_IDX(), 0) > 0
							&& CommonUtils.nvl(
									compositeAction.getPT_IL_POLICY_ACTION_BEAN()
											.getPT_IL_POLICY_BEAN()
											.getPOL_END_CODE(), "000")
									.equalsIgnoreCase("GEN002")) {
						PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REC_TYPE(3);

					} else {
						PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REC_TYPE(1);
					}
				 /*end*/
				 
					
					/*Added by Janani on 29.03.2018 for KIC*/
					int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
					System.out.println("benfField ====>>" +benfField);
					
					/*
					 * 
					 * commented by Dhinesh on 30-05-2018 
					 * 
					 * if(benfField == 0)*/
					if(benfField == 0 || benfField == 2)
					{
						if((getCOMP_PBEN_BNF_NAME().isRequired() == true) && 
								PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_NAME().isEmpty() || PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_NAME() == null)
						{
							throw new Exception("Beneficiary Name: Validation Error: Value is required.");
						}else
						{
							/*End*/
							new CRUDHandler().executeUpdate(PT_IL_POL_BENEFICIARY_BEAN,CommonUtils.getConnection());
							message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
						}
					
					}else
					{
						new CRUDHandler().executeUpdate(PT_IL_POL_BENEFICIARY_BEAN,CommonUtils.getConnection());
						message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
					}
					
				
				 
			
			}
			
			/*getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);*/
			PT_IL_POL_BENEFICIARY_BEAN.setRowSelected(true);
		/*} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: " + exc.getMessage());
		}*/
		
			
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put("SAVE",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	}
	/*End*/

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_BENEFICIARY_BEAN = (PT_IL_POL_BENEFICIARY) dataTable.getRowData();

			
/*added by raja on 11-04-2017 for change nation id label change*/
			
			labelChanged();
			
			/*end*/
			
			/*added by raja on 13-04-2017 for disable fields*/
			disableField();
			/*end*/
			
			/*added by raja on 13-05-2017 */
			helper.validateAge(PT_IL_POL_BENEFICIARY_BEAN,this);
			/*end*/
			
			
			/*Added by Raja on 9/3/2016 for onload Beneficiary Type field issue*/
			/* change the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee 
			String typefieldvalue2=compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getPT_IL_POL_BENEFICIARY_BEAN().getPBEN_BNF_TYPE();
			System.out.println("typefieldvalue        "+typefieldvalue2);
			if(typefieldvalue2.equals("A") || typefieldvalue2.equalsIgnoreCase("S")){
				/* change the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				/*COMP_UI_M_CITY_CODE.setDisabled(false);*/
				/*end 
				COMP_UI_M_BANK_CODE.setDisabled(false);
				COMP_UI_M_BRANCH_CODE.setDisabled(false);
			}
			else
			{
				/* Commentted by saranya for Avoidance of POST button required in all screens on 22-02-2017 */
				/*COMP_UI_M_CITY_CODE.setDisabled(true);*/
				/*End 
				COMP_UI_M_BANK_CODE.setDisabled(true);
				COMP_UI_M_BRANCH_CODE.setDisabled(true);
			}
			/*End*/

			//helper.postQuery(PT_IL_POL_BENEFICIARY_BEAN,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			
			helper.postQuery(PT_IL_POL_BENEFICIARY_BEAN,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN());
			
			/* commented the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			//defaultMICRDetails();
			/* end */
			PT_IL_POL_BENEFICIARY_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_BENEFICIARY> PT_IL_POL_BENEFICIARY_ITR = dataList_PT_IL_POL_BENEFICIARY.iterator();
		while (PT_IL_POL_BENEFICIARY_ITR.hasNext()) {
			PT_IL_POL_BENEFICIARY_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PBEN_SR_NO.resetValue();
		COMP_PBEN_BNF_TYPE.resetValue();
		COMP_PBEN_REF_ID1.resetValue();
		COMP_PBEN_REF_ID2.resetValue();
		COMP_PBEN_CATG_CODE.resetValue();
		COMP_PBEN_AGE.resetValue();
		COMP_PBEN_RELATION_CODE.resetValue();
		COMP_PBEN_PERC.resetValue();
		COMP_PBEN_GUARDIAN_NAME.resetValue();
		COMP_PBEN_ADDRESS_1.resetValue();
		COMP_PBEN_BNF_NAME.resetValue();
		COMP_PBEN_ADDRESS_3.resetValue();
		COMP_PBEN_ADDRESS_2.resetValue();
		COMP_PBEN_REMARKS.resetValue();
		COMP_PBEN_ADDRESS_4.resetValue();
		COMP_UI_M_CATG_DESC.resetValue();
		COMP_PBEN_ADDRESS_5.resetValue();
		COMP_UI_M_PBEN_TYPE_DESC.resetValue();
		COMP_UI_M_PBEN_RELATION_DESC.resetValue();
		COMP_PBEN_MICR_CODE.resetValue();
		COMP_UI_M_BANK_CODE.resetValue();
		COMP_UI_M_BANK_CODE_DESC.resetValue();
		COMP_UI_M_BRANCH_CODE.resetValue();
		//COMP_UI_M_BRANCH_CODE_DESC.resetValue();
		/* Modified by saranya for Avoidance of POST button required in all screens on 22-02-2017 */
		//COMP_UI_M_CITY_CODE.resetValue();
		//COMP_UI_M_CITY_CODE_DESC.resetValue();
		/*End*/
		COMP_PBEN_ACNT_NO.resetValue();
		/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
		COMP_PBEN_DOB.resetValue();
		COMP_PBEN_EFF_FM_DT.resetValue();
		COMP_PBEN_EFF_TO_DT.resetValue();
		COMP_PBEN_BNF_CODE.resetValue();

		/* end */
		
		/*Added by Shinesh on 04/04/2017*/
		COMP_PBEN_EMAIL.resetValue();
		COMP_UI_M_CITY_CODE.resetValue();
		/*End*/
		
		/*Added by Ameen for KIC*/
		COMP_PBEN_REF_ID1_NEW.resetValue();
		/*End*/
		/*Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
		COMP_PBEN_GUARDIAN_NATN_ID.resetValue();
		/*End Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
		 /*Newly added by pidugu raj dt: 22-09-2020 for Alliance IL*/
		COMP_PBEN_GUARDIAN_NATN_ID_TYPE.resetValue();
		COMP_PBEN_BENEF_ID_TYPE.resetValue();
		/*End Newly added by pidugu raj dt: 22-09-2020 for Alliance IL*/
		COMP_PBEN_AREA_CODE.resetValue();
		COMP_PBEN_MOBILE_NO.resetValue();
		COMP_PBEN_REL_OTHER.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		String message = null;
		Double UI_M_SUM_PBEN_PERC = 0.0 ;
		try {
		/*Commentted by saranya for Avoidance of POST button required in all screens on 22-02-2017*/
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			/*if (dataList_PT_IL_POL_BENEFICIARY.size()!= 0) {
				End
				//Added to check benificiary percentage during save
				for(PT_IL_POL_BENEFICIARY  bn: this.getDataList_PT_IL_POL_BENEFICIARY()) {
					UI_M_SUM_PBEN_PERC = UI_M_SUM_PBEN_PERC + bn.getPBEN_PERC();
				}
				if(UI_M_SUM_PBEN_PERC != null){
					if (UI_M_SUM_PBEN_PERC > 100.00) {
						throw new Exception((Messages.getString(PELConstants.pelErrorMessagePath, "91136")));
					}else if(UI_M_SUM_PBEN_PERC < 100.00){
						throw new Exception((Messages.getString(PELConstants.pelErrorMessagePath, "91971")));
					}
				}
			}*/
			
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

			/*if (dataList_PT_IL_POL_BENEFICIARY.size() == 0) {

				PT_IL_POL_BENEFICIARY_BEAN=new PT_IL_POL_BENEFICIARY();	
				resetAllComponent();
			}*/


			/*End*/
			/*End*/
			getErrorMap().clear();
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put("SAVE",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				System.out.println("Welcome to Beneficery Body Onload");
				/*Added by Ram on 26/01/2017 for BankCode dynamic Mandatory concept*/
				setBankCodeMandatory();
				/*End*/

				/*Added BY Ameen for ssp call id :  FALCONQC-1714579   ---- Start ----*/
				if(
						(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS() != null && (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS().equals("E")))
						&&
						(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() != null && (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equals("GEN002") || compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE().equals("GEN003")))
						)
				{
					setINSERT_ALLOWED(true);	
					setUPDATE_ALLOWED(true);
				}


				/*Added by Ram on 25/11/2016 for IC no length issue*/


				int fieldLength = 0;
				int PS_VALUE= (int) CommonUtils.getGlobalObject("M_PS_VALUE");
				fieldLength = 	(int) CommonUtils.getGlobalObject("FIELD_LENGTH");
				System.out.println("fieldLength         "+fieldLength);

				compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getCOMP_PBEN_REF_ID1().setMaxlength(fieldLength);



				/*end*/

				/*Added BY Ameen for ssp call id :  FALCONQC-1714579   ---- End ----*/

				helper.whenNewBlockInstance(compositeAction);
				helper.preQuery(compositeAction);
				helper.executeQuery(compositeAction);
				if(PT_IL_POL_BENEFICIARY_BEAN.getROWID() != null){


					/*added by raja on 11-04-2017 for change nation id label change*/
					
					labelChanged();
					
					/*end*/
					
					/*added by raja on 13-04-2017 for disable fields*/
					disableField();
					/*end*/
					
					/*Added by Raja on 9/3/2016 for onload Beneficiary Type field issue*/
					/* change the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee 

					String typefieldvalue2=compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getPT_IL_POL_BENEFICIARY_BEAN().getPBEN_BNF_TYPE();
					System.out.println("typefieldvalue        "+typefieldvalue2);
					
					/*Added by Ram on 12/04/2017 for Policy freeze handling 
					System.out.println("compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG()       "
					+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG());
					if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG() != null && 
							compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG().equals("Y"))
					{
						COMP_UI_M_BANK_CODE.setDisabled(true);
						COMP_UI_M_BRANCH_CODE.setDisabled(true);
					}
					else
					{
						/*End 
						if(typefieldvalue2.equals("A") || typefieldvalue2.equalsIgnoreCase("S")){
							
							/* change the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
							
							/*COMP_UI_M_CITY_CODE.setDisabled(false);*/
							
							/*end 
							
							COMP_UI_M_BANK_CODE.setDisabled(false);
							COMP_UI_M_BRANCH_CODE.setDisabled(false);
						}
						else
						{
							/* change the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
							
							/*COMP_UI_M_CITY_CODE.setDisabled(true);*/
							
							/*end 
							
							COMP_UI_M_BANK_CODE.setDisabled(true);
							COMP_UI_M_BRANCH_CODE.setDisabled(true);
						}
					}
					
					/*End*/

					/*helper.postQuery(PT_IL_POL_BENEFICIARY_BEAN,
							compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());*/
					
					helper.postQuery(PT_IL_POL_BENEFICIARY_BEAN,
							compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN());
					
					
					//defaultMICRDetails();
				}else{
					/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

					helper.whenCreateRecord(compositeAction,this);

					/*end*/
				}
				
				/*Added by Ameen on 31-03-2017 for enabling benf. det. based on sys. param.*/
				int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
				System.out.println("benfField ====>>" +benfField);
				/*
				 * 
				 * commented by Dhinesh on 30-05-2018 
				 * 
				 * if(benfField == 0)*/
				if(benfField == 0 || benfField == 2){
					System.out.println("SYSTEM PARAM. 0");
					COMP_PBEN_CATG_CODE.setDisabled(false);
					COMP_PBEN_AGE.setDisabled(false);
					//COMP_PBEN_BNF_CODE.setDisabled(false);
					COMP_PBEN_BNF_CODE.setRendered(false);
					COMP_PBEN_BNF_NAME.setDisabled(false);
					COMP_PBEN_EFF_FM_DT.setRendered(false);
					COMP_PBEN_EFF_TO_DT.setRendered(false);
					COMP_PBEN_EFF_FM_DT_LABEL.setRendered(false);
					COMP_PBEN_EFF_TO_DT_LABEL.setRendered(false);

					/*Added by Janani on 29.03.2018 for KIC*/
					/*
					 * 
					 * COMMENTED BY DHINESH ON 30-05-2018 
					 * 
					 * if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE() != null && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("B"))*/
					if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE() != null && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("N"))
					{
						if(benfField == 2)
						{
							COMP_UI_M_BANK_CODE.setRequired(false);
							COMP_UI_M_BRANCH_CODE.setRequired(false);
							COMP_PBEN_AGE.setRequired(false);
							COMP_PBEN_AGE.setDisabled(true);
							//commeneted by gopi
						//	COMP_PBEN_DOB.setRequired(true);
							COMP_PBEN_DOB.setDisabled(false);
							COMP_PBEN_BNF_NAME.setRequired(true);
							COMP_PBEN_NAME_MAND.setRendered(true);
							COMP_PBEN_REF_ID1.setRequired(false);
							COMP_PBEN_REF_ID1.setDisabled(false);
							COMP_PBEN_CATG_CODE.setRequired(false);
							COMP_PBEN_CATG_CODE.setDisabled(false);
							COMP_PBEN_RELATION_CODE.setRequired(true);
							COMP_PBEN_RELATION_CODE.setDisabled(false);
							COMP_PBEN_ACNT_NO.setRequired(false);
							COMP_PBEN_ACNT_NO.setDisabled(false);
							COMP_PBEN_EMAIL.setRequired(false);
							COMP_PBEN_REMARKS.setRequired(false);
							COMP_PBEN_PERC.setRequired(true);
							COMP_PBEN_PERC.setDisabled(false);
							COMP_PBEN_GUARDIAN_NAME.setDisabled(false);
							
						}else
						{
							/*
							 * 
							 * Commented by Dhinesh on 06-06-2018 for KIC  Bankcode and BranchCode not mandatory
							 * 
							 * COMP_UI_M_BANK_CODE.setRequired(true);
							COMP_UI_M_BRANCH_CODE.setRequired(true);*/
							
							COMP_UI_M_BANK_CODE.setRequired(false);
							COMP_UI_M_BRANCH_CODE.setRequired(false);
							
							COMP_PBEN_AGE.setRequired(false);
							COMP_PBEN_DOB.setRequired(false);
							getCOMP_PBEN_DOB().setDisabled(true);
							COMP_PBEN_BNF_NAME.setRequired(false);
							COMP_PBEN_NAME_MAND.setRendered(false);
							COMP_PBEN_REF_ID1.setRequired(false);
							COMP_PBEN_DOB.setRequired(false);
							COMP_PBEN_CATG_CODE.setRequired(false);
							COMP_PBEN_AGE.setRequired(false);
							COMP_PBEN_RELATION_CODE.setRequired(false);
							COMP_PBEN_BNF_NAME.setRequired(false);
							COMP_PBEN_NAME_MAND.setRendered(false);
							COMP_PBEN_ACNT_NO.setRequired(false);
							COMP_PBEN_EMAIL.setRequired(false);
							COMP_PBEN_REMARKS.setRequired(false);
							COMP_PBEN_PERC.setRequired(true);
						}
						
						
					}else if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE() != null && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("S"))
					{
						if(benfField == 2)
						{
							COMP_PBEN_BNF_NAME.setRequired(true);
							COMP_PBEN_AGE.setRequired(false);
							COMP_PBEN_AGE.setDisabled(true);
							COMP_PBEN_DOB.setRequired(false);
							COMP_PBEN_DOB.setDisabled(true);
							COMP_PBEN_CATG_CODE.setRequired(false);
							COMP_PBEN_CATG_CODE.setDisabled(true);
							COMP_PBEN_RELATION_CODE.setRequired(true);
							COMP_PBEN_PERC.setRequired(true);
							COMP_PBEN_PERC.setDisabled(false);
							COMP_UI_M_BANK_CODE.setRequired(true);
							COMP_UI_M_BANK_CODE.setDisabled(false);
							COMP_PBEN_GUARDIAN_NAME.setRequired(false);
							COMP_PBEN_GUARDIAN_NAME.setDisabled(true);
							COMP_PBEN_ACNT_NO.setRequired(false);
							COMP_PBEN_ACNT_NO.setDisabled(false);
							COMP_UI_M_BRANCH_CODE.setRequired(false);
							COMP_UI_M_BRANCH_CODE.setDisabled(false);
							COMP_PBEN_EMAIL.setRequired(false);
							COMP_PBEN_EMAIL.setDisabled(false);
							COMP_PBEN_REMARKS.setRequired(false);
							COMP_PBEN_REMARKS.setDisabled(false);
							COMP_PBEN_REF_ID1.setRequired(false);
							COMP_PBEN_REF_ID1.setDisabled(true);
							
							COMP_PBEN_NAME_MAND.setRendered(false);
							COMP_PBEN_BNF_NAME.setRequired(false);
							COMP_PBEN_NAME_MAND.setRendered(false);
							
							
						
						}
						else
						{
						
						COMP_PBEN_REF_ID1.setRequired(false);
						COMP_PBEN_DOB.setRequired(false);
						COMP_PBEN_CATG_CODE.setRequired(false);
						COMP_PBEN_AGE.setRequired(false);
						COMP_PBEN_RELATION_CODE.setRequired(false);
						COMP_PBEN_BNF_NAME.setRequired(false);
						COMP_PBEN_NAME_MAND.setRendered(false);
						COMP_PBEN_ACNT_NO.setRequired(false);
						COMP_UI_M_BANK_CODE.setRequired(false);
						COMP_UI_M_BRANCH_CODE.setRequired(false);
						COMP_PBEN_EMAIL.setRequired(false);
						COMP_PBEN_REMARKS.setRequired(false);
						COMP_PBEN_PERC.setRequired(true);
						}				
					}else
					{
						if(benfField == 2)
						{
							COMP_PBEN_BNF_NAME.setRequired(true);
							COMP_PBEN_AGE.setRequired(false);
							COMP_PBEN_AGE.setDisabled(true);
							COMP_PBEN_DOB.setRequired(false);
							COMP_PBEN_DOB.setDisabled(true);
							COMP_PBEN_CATG_CODE.setRequired(false);
							COMP_PBEN_CATG_CODE.setDisabled(true);
							COMP_PBEN_RELATION_CODE.setRequired(true);
							COMP_PBEN_PERC.setRequired(true);
							COMP_PBEN_PERC.setDisabled(false);
							COMP_UI_M_BANK_CODE.setRequired(true);
							COMP_UI_M_BANK_CODE.setDisabled(false);
							COMP_PBEN_GUARDIAN_NAME.setRequired(false);
							COMP_PBEN_GUARDIAN_NAME.setDisabled(true);
							COMP_PBEN_ACNT_NO.setRequired(false);
							COMP_PBEN_ACNT_NO.setDisabled(false);
							COMP_UI_M_BRANCH_CODE.setRequired(false);
							COMP_UI_M_BRANCH_CODE.setDisabled(false);
							COMP_PBEN_EMAIL.setRequired(false);
							COMP_PBEN_EMAIL.setDisabled(false);
							COMP_PBEN_REMARKS.setRequired(false);
							COMP_PBEN_REMARKS.setDisabled(false);
							COMP_PBEN_REF_ID1.setRequired(false);
							COMP_PBEN_REF_ID1.setDisabled(true);
							
							COMP_PBEN_NAME_MAND.setRendered(false);
							COMP_PBEN_BNF_NAME.setRequired(false);
							COMP_PBEN_NAME_MAND.setRendered(false);
						
						}
						else
						{					
						COMP_PBEN_REF_ID1.setRequired(false);
						COMP_PBEN_DOB.setRequired(false);
						COMP_PBEN_CATG_CODE.setRequired(false);
						COMP_PBEN_AGE.setRequired(false);
						COMP_PBEN_RELATION_CODE.setRequired(false);
						COMP_PBEN_BNF_NAME.setRequired(false);
						COMP_PBEN_NAME_MAND.setRendered(true);
						COMP_PBEN_ACNT_NO.setRequired(false);
						COMP_UI_M_BANK_CODE.setRequired(false);
						COMP_UI_M_BRANCH_CODE.setRequired(false);
						COMP_PBEN_EMAIL.setRequired(false);
						COMP_PBEN_REMARKS.setRequired(false);
						COMP_PBEN_PERC.setRequired(false);
						getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);
						}
					}
					/*End*/
				}
				
				/*Added by Janani on 12.05.2018 for Fidelity as suggested by Sivaram,National Id non mandatory */
				
				else
				{
					
					/*Modified by Janani on 15.05.2018 for fidelity as suggested by Ajay*/
					if(benfField == 2)
					/*End*/
					{
						COMP_PBEN_REF_ID1.setRequired(false);
					}
					else
					{
					System.out.println("benf fld non mandatory");
					COMP_PBEN_REF_ID1.setRequired(true);
					}
				}
					
				/*End*/
				}
				/*end enabling benf. det. based on sys. param.*/
				
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG() != null && 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG().equals("Y"))
				{
					disableAllComponent(true);
				}
				
				setBlockFlag(false);

			
			/*Added by Ameen for KIC national ID non lov field*/
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			System.out.println("benfField ====>>" +benfField);
			
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG() != null && 
					!compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG().equals("Y"))
			{
			
			
				/*
				 * 
				 * commented by Dhinesh on 30-05-2018 
				 * 
				 * if(benfField == 0)*/
				if(benfField == 0 || benfField == 2){
				System.out.println("SYSTEM PARAM. 1 out blockflag ..");
				
				COMP_PBEN_REF_ID1_NEW.setRendered(true);
				COMP_PBEN_REF_ID1.setRendered(false);
				
				/*Added by Janani on 29.03.2018 for KIC*/ 
				COMP_PBEN_REF_ID1_MAND.setRendered(false);
				/*COMP_PBEN_DOB.setDisabled(false);
				getCOMP_PBEN_GUARDIAN_NAME().setDisabled(false);
				getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);*/
				COMP_UI_M_BANK_CODE.setDisabled(false);
				COMP_UI_M_BRANCH_CODE.setDisabled(false);
				/*End*/
				
			}else{
				COMP_PBEN_REF_ID1_NEW.setRendered(false);
				COMP_PBEN_REF_ID1.setRendered(true);
				
				/*Added by Janani on 29.03.2018 for KIC*/ 

				/*Modified by Janani on 12.05.2018 for Fidelity */
				if(benfField == 2){

					COMP_PBEN_REF_ID1_MAND.setRendered(false);
				}else
				{
					COMP_PBEN_REF_ID1_MAND.setRendered(true);	
				}
				/*End*/
				COMP_PBEN_DOB.setDisabled(true);
				/*End*/
			}
			
			}
			else
			{
				/*
				 * 
				 * COMMENTED BY DHINESH ON 01-06-2018 
				 * 
				 * if(benfField == 0)*/
				if(benfField == 0  || benfField == 2 )
				{
					System.out.println("SYSTEM PARAM. 1 out blockflag ..");
					
					COMP_PBEN_REF_ID1_NEW.setRendered(true);
					COMP_PBEN_REF_ID1.setRendered(false);
					COMP_PBEN_REF_ID1_MAND.setRendered(false);
				}
			}
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PBEN_SR_NO_LABEL() {
		return COMP_PBEN_SR_NO_LABEL;
	}

	public void setCOMP_PBEN_SR_NO_LABEL(HtmlOutputLabel comp_pben_sr_no_label) {
		COMP_PBEN_SR_NO_LABEL = comp_pben_sr_no_label;
	}

	public HtmlInputText getCOMP_PBEN_SR_NO() {
		return COMP_PBEN_SR_NO;
	}

	public void setCOMP_PBEN_SR_NO(HtmlInputText comp_pben_sr_no) {
		COMP_PBEN_SR_NO = comp_pben_sr_no;
	}

	public HtmlOutputLabel getCOMP_PBEN_RELATION_CODE_LABEL() {
		return COMP_PBEN_RELATION_CODE_LABEL;
	}

	public void setCOMP_PBEN_RELATION_CODE_LABEL(
			HtmlOutputLabel comp_pben_relation_code_label) {
		COMP_PBEN_RELATION_CODE_LABEL = comp_pben_relation_code_label;
	}

	public HtmlOutputLabel getCOMP_PBEN_REMARKS_LABEL() {
		return COMP_PBEN_REMARKS_LABEL;
	}

	public void setCOMP_PBEN_REMARKS_LABEL(
			HtmlOutputLabel comp_pben_remarks_label) {
		COMP_PBEN_REMARKS_LABEL = comp_pben_remarks_label;
	}

	public HtmlInputText getCOMP_PBEN_REMARKS() {
		return COMP_PBEN_REMARKS;
	}

	public void setCOMP_PBEN_REMARKS(HtmlInputText comp_pben_remarks) {
		COMP_PBEN_REMARKS = comp_pben_remarks;
	}

	public HtmlOutputLabel getCOMP_UI_M_CATG_DESC_LABEL() {
		return COMP_UI_M_CATG_DESC_LABEL;
	}

	public void setCOMP_UI_M_CATG_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_catg_desc_label) {
		COMP_UI_M_CATG_DESC_LABEL = comp_ui_m_catg_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_CATG_DESC() {
		return COMP_UI_M_CATG_DESC;
	}

	public void setCOMP_UI_M_CATG_DESC(HtmlInputText comp_ui_m_catg_desc) {
		COMP_UI_M_CATG_DESC = comp_ui_m_catg_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_PBEN_TYPE_DESC_LABEL() {
		return COMP_UI_M_PBEN_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PBEN_TYPE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_pben_type_desc_label) {
		COMP_UI_M_PBEN_TYPE_DESC_LABEL = comp_ui_m_pben_type_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_PBEN_TYPE_DESC() {
		return COMP_UI_M_PBEN_TYPE_DESC;
	}

	public void setCOMP_UI_M_PBEN_TYPE_DESC(
			HtmlInputText comp_ui_m_pben_type_desc) {
		COMP_UI_M_PBEN_TYPE_DESC = comp_ui_m_pben_type_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_PBEN_RELATION_DESC_LABEL() {
		return COMP_UI_M_PBEN_RELATION_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PBEN_RELATION_DESC() {
		return COMP_UI_M_PBEN_RELATION_DESC;
	}

	public void setDataList_PT_IL_POL_BENEFICIARY(
			List<PT_IL_POL_BENEFICIARY> dataList_PT_IL_POL_BENEFICIARY) {
		this.dataList_PT_IL_POL_BENEFICIARY = dataList_PT_IL_POL_BENEFICIARY;
	}

	public HtmlOutputLabel getCOMP_PBEN_BNF_TYPE_LABEL() {
		return COMP_PBEN_BNF_TYPE_LABEL;
	}

	public void setCOMP_PBEN_BNF_TYPE_LABEL(
			HtmlOutputLabel comp_pben_bnf_type_label) {
		COMP_PBEN_BNF_TYPE_LABEL = comp_pben_bnf_type_label;
	}

	public HtmlInputText getCOMP_PBEN_BNF_TYPE() {
		return COMP_PBEN_BNF_TYPE;
	}

	public void setCOMP_PBEN_BNF_TYPE(HtmlInputText comp_pben_bnf_type) {
		COMP_PBEN_BNF_TYPE = comp_pben_bnf_type;
	}

	public HtmlOutputLabel getCOMP_PBEN_REF_ID1_LABEL() {
		return COMP_PBEN_REF_ID1_LABEL;
	}

	public void setCOMP_PBEN_REF_ID1_LABEL(
			HtmlOutputLabel comp_pben_ref_id1_label) {
		COMP_PBEN_REF_ID1_LABEL = comp_pben_ref_id1_label;
	}

	public HtmlInputText getCOMP_PBEN_REF_ID1() {
		return COMP_PBEN_REF_ID1;
	}

	public void setCOMP_PBEN_REF_ID1(HtmlInputText comp_pben_ref_id1) {
		COMP_PBEN_REF_ID1 = comp_pben_ref_id1;
	}

	public HtmlOutputLabel getCOMP_PBEN_REF_ID2_LABEL() {
		return COMP_PBEN_REF_ID2_LABEL;
	}

	public void setCOMP_PBEN_REF_ID2_LABEL(
			HtmlOutputLabel comp_pben_ref_id2_label) {
		COMP_PBEN_REF_ID2_LABEL = comp_pben_ref_id2_label;
	}

	public HtmlInputText getCOMP_PBEN_REF_ID2() {
		return COMP_PBEN_REF_ID2;
	}

	public void setCOMP_PBEN_REF_ID2(HtmlInputText comp_pben_ref_id2) {
		COMP_PBEN_REF_ID2 = comp_pben_ref_id2;
	}

	public HtmlOutputLabel getCOMP_PBEN_CATG_CODE_LABEL() {
		return COMP_PBEN_CATG_CODE_LABEL;
	}

	public void setCOMP_PBEN_CATG_CODE_LABEL(
			HtmlOutputLabel comp_pben_catg_code_label) {
		COMP_PBEN_CATG_CODE_LABEL = comp_pben_catg_code_label;
	}

	public HtmlInputText getCOMP_PBEN_CATG_CODE() {
		return COMP_PBEN_CATG_CODE;
	}

	public void setCOMP_PBEN_CATG_CODE(HtmlInputText comp_pben_catg_code) {
		COMP_PBEN_CATG_CODE = comp_pben_catg_code;
	}

	public HtmlOutputLabel getCOMP_PBEN_AGE_LABEL() {
		return COMP_PBEN_AGE_LABEL;
	}

	public void setCOMP_PBEN_AGE_LABEL(HtmlOutputLabel comp_pben_age_label) {
		COMP_PBEN_AGE_LABEL = comp_pben_age_label;
	}

	public HtmlInputText getCOMP_PBEN_AGE() {
		return COMP_PBEN_AGE;
	}

	public void setCOMP_PBEN_AGE(HtmlInputText comp_pben_age) {
		COMP_PBEN_AGE = comp_pben_age;
	}

	public HtmlInputText getCOMP_PBEN_RELATION_CODE() {
		return COMP_PBEN_RELATION_CODE;
	}

	public void setCOMP_PBEN_RELATION_CODE(HtmlInputText comp_pben_relation_code) {
		COMP_PBEN_RELATION_CODE = comp_pben_relation_code;
	}

	public HtmlOutputLabel getCOMP_PBEN_PERC_LABEL() {
		return COMP_PBEN_PERC_LABEL;
	}

	public void setCOMP_PBEN_PERC_LABEL(HtmlOutputLabel comp_pben_perc_label) {
		COMP_PBEN_PERC_LABEL = comp_pben_perc_label;
	}

	public HtmlInputText getCOMP_PBEN_PERC() {
		return COMP_PBEN_PERC;
	}

	public void setCOMP_PBEN_PERC(HtmlInputText comp_pben_perc) {
		COMP_PBEN_PERC = comp_pben_perc;
	}

	public HtmlOutputLabel getCOMP_PBEN_GUARDIAN_NAME_LABEL() {
		return COMP_PBEN_GUARDIAN_NAME_LABEL;
	}

	public void setCOMP_PBEN_GUARDIAN_NAME_LABEL(
			HtmlOutputLabel comp_pben_guardian_name_label) {
		COMP_PBEN_GUARDIAN_NAME_LABEL = comp_pben_guardian_name_label;
	}

	public HtmlInputText getCOMP_PBEN_GUARDIAN_NAME() {
		return COMP_PBEN_GUARDIAN_NAME;
	}

	public void setCOMP_PBEN_GUARDIAN_NAME(HtmlInputText comp_pben_guardian_name) {
		COMP_PBEN_GUARDIAN_NAME = comp_pben_guardian_name;
	}

	public HtmlOutputLabel getCOMP_PBEN_ADDRESS_1_LABEL() {
		return COMP_PBEN_ADDRESS_1_LABEL;
	}

	public void setCOMP_PBEN_ADDRESS_1_LABEL(
			HtmlOutputLabel comp_pben_address_1_label) {
		COMP_PBEN_ADDRESS_1_LABEL = comp_pben_address_1_label;
	}

	public HtmlInputText getCOMP_PBEN_ADDRESS_1() {
		return COMP_PBEN_ADDRESS_1;
	}

	public void setCOMP_PBEN_ADDRESS_1(HtmlInputText comp_pben_address_1) {
		COMP_PBEN_ADDRESS_1 = comp_pben_address_1;
	}

	public HtmlOutputLabel getCOMP_PBEN_BNF_NAME_LABEL() {
		return COMP_PBEN_BNF_NAME_LABEL;
	}

	public void setCOMP_PBEN_BNF_NAME_LABEL(
			HtmlOutputLabel comp_pben_bnf_name_label) {
		COMP_PBEN_BNF_NAME_LABEL = comp_pben_bnf_name_label;
	}

	public HtmlInputText getCOMP_PBEN_BNF_NAME() {
		return COMP_PBEN_BNF_NAME;
	}

	public void setCOMP_PBEN_BNF_NAME(HtmlInputText comp_pben_bnf_name) {
		COMP_PBEN_BNF_NAME = comp_pben_bnf_name;
	}

	public HtmlOutputLabel getCOMP_PBEN_ADDRESS_2_LABEL() {
		return COMP_PBEN_ADDRESS_2_LABEL;
	}

	public void setCOMP_PBEN_ADDRESS_2_LABEL(
			HtmlOutputLabel comp_pben_address_2_label) {
		COMP_PBEN_ADDRESS_2_LABEL = comp_pben_address_2_label;
	}

	public HtmlInputText getCOMP_PBEN_ADDRESS_2() {
		return COMP_PBEN_ADDRESS_2;
	}

	public void setCOMP_PBEN_ADDRESS_2(HtmlInputText comp_pben_address_2) {
		COMP_PBEN_ADDRESS_2 = comp_pben_address_2;
	}

	public HtmlOutputLabel getCOMP_PBEN_ADDRESS_4_LABEL() {
		return COMP_PBEN_ADDRESS_4_LABEL;
	}

	public void setCOMP_PBEN_ADDRESS_4_LABEL(
			HtmlOutputLabel comp_pben_address_4_label) {
		COMP_PBEN_ADDRESS_4_LABEL = comp_pben_address_4_label;
	}

	public HtmlInputText getCOMP_PBEN_ADDRESS_4() {
		return COMP_PBEN_ADDRESS_4;
	}

	public void setCOMP_PBEN_ADDRESS_4(HtmlInputText comp_pben_address_4) {
		COMP_PBEN_ADDRESS_4 = comp_pben_address_4;
	}

	public HtmlOutputLabel getCOMP_PBEN_ADDRESS_5_LABEL() {
		return COMP_PBEN_ADDRESS_5_LABEL;
	}

	public void setCOMP_PBEN_ADDRESS_5_LABEL(
			HtmlOutputLabel comp_pben_address_5_label) {
		COMP_PBEN_ADDRESS_5_LABEL = comp_pben_address_5_label;
	}

	public HtmlInputText getCOMP_PBEN_ADDRESS_5() {
		return COMP_PBEN_ADDRESS_5;
	}

	public void setCOMP_PBEN_ADDRESS_5(HtmlInputText comp_pben_address_5) {
		COMP_PBEN_ADDRESS_5 = comp_pben_address_5;
	}

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}

	/* changed the method arguments by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
	public void PBEN_BNF_TYPE_WHEN_VALIDATE_ITEM(ActionEvent actionEvent){
		try { 
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			getErrorMap().clear();
			getWarningMap().clear();
			/*End*/
			if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE()!=null){
				/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				if(!PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equals(COMP_PBEN_BNF_TYPE.getSubmittedValue().toString())){
					/*End*/
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE(null);
					PT_IL_POL_BENEFICIARY_BEAN.setUI_M_PBEN_RELATION_DESC(null);
					/*Added by Raja on 13/04/2017*/
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REF_ID1(null);
					/*End*/
					
					COMP_PBEN_RELATION_CODE.resetValue();
					COMP_UI_M_PBEN_RELATION_DESC.resetValue();
					
					/*Added by Raja on 13/04/2017*/
					COMP_PBEN_REF_ID1.resetValue();
					/*End*/
				}
			}
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_TYPE(COMP_PBEN_BNF_TYPE.getSubmittedValue().toString());
			/*end*/

			helper.PBEN_BNF_TYPE_WHEN_VALIDATE_ITEM(this);

/*Changed by Raja on 3/3/2016 for MIMC code hide and enable BankBranch,City fields.(Start)*/			
			
			COMP_PBEN_PERC.resetValue();
			
			
			/*End*/
			/*Changed by Raja on 3/3/2016 for MIMC code hide and enable BankBranch,City fields.(Start)*/


			String typefieldvalue=compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getPT_IL_POL_BENEFICIARY_BEAN().getPBEN_BNF_TYPE();
			System.out.println("typefieldvalue        "+typefieldvalue);
			/* changed if the condotion by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			if(typefieldvalue.equals("A") || typefieldvalue.equalsIgnoreCase("S")){
				
				/* change the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				/*COMP_UI_M_CITY_CODE.setDisabled(false);*/
				/*end*/
				COMP_UI_M_BRANCH_CODE.setDisabled(false);
				COMP_UI_M_BANK_CODE.setDisabled(false);
				/* commented  by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				/*	COMP_PBEN_AGE.setDisabled(false);
					COMP_PBEN_CATG_CODE.setDisabled(false);*/
				/*End*/
				
				/*added by raja on 12-05-2017*/
				COMP_UI_M_BRANCH_CODE.setRequired(true);
				COMP_UI_M_BANK_CODE.setRequired(true);
				
				/*end*/
				
			}
			else{
				/* change the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				/*COMP_UI_M_CITY_CODE.setDisabled(true);*/
				/*end*/
				COMP_UI_M_BRANCH_CODE.setDisabled(true);
				COMP_UI_M_BANK_CODE.setDisabled(true);
				/*Added By Jagadeesh on 19-jul-2016*/
				/*COMP_PBEN_AGE.setDisabled(false);
				COMP_PBEN_CATG_CODE.setDisabled(false);*/
				/*End*/
				/*added by raja on 12-05-2017*/
				COMP_UI_M_BRANCH_CODE.setRequired(false);
				COMP_UI_M_BANK_CODE.setRequired(false);
				
				/*end*/
				
			}
			
			
			
			

			/*End*/

		} catch (Exception e) {

			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			getErrorMap().put("current", e.getMessage());

			/*End*/
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	
	

	/*added by sankaranarayanan for ssp ZBILQC-1719274*/
	
	public void Validate_type(FacesContext context,
			UIComponent component, Object value){

		try {
			
			String Current=(String) value ; 

			if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE()!=null){
							
				
				/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				if(!PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equals(Current)){
					/*End*/
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE(null);	
					PT_IL_POL_BENEFICIARY_BEAN.setUI_M_PBEN_RELATION_DESC(null);
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REF_ID1(null);
					COMP_PBEN_RELATION_CODE.resetValue();
					COMP_UI_M_PBEN_RELATION_DESC.resetValue();
					COMP_PBEN_REF_ID1.resetValue();
				}
			}
			
			/*changed by rja on 12-05-2017*/
			
			/*PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_TYPE(Current);*/
			
			/*
			 * 
			 * COMMENTED BY DHINESH ON 30-05-2018 
			 * 
			 * PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_TYPE(COMP_PBEN_BNF_TYPE.getSubmittedValue().toString());*/
			
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_TYPE(Current);
			
			/*end*/
			
			/*Newly added by pidugu raj dt: 30-09-2018 as suggested by sivaraman and vaitheeswaran*/
			if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("S")){
				if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_NAME() == null || PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_NAME().isEmpty()){
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_NAME("الورثة الشرعيون حسب الأنصبة الشرعية");
					COMP_PBEN_BNF_NAME.resetValue();
				}
				if(!PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_NAME().equals("الورثة الشرعيون حسب الأنصبة الشرعية")){
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_NAME(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_NAME());
					COMP_PBEN_BNF_NAME.resetValue();
				}else{
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_NAME("الورثة الشرعيون حسب الأنصبة الشرعية");
				COMP_PBEN_BNF_NAME.resetValue();
				}
			}/*else{
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_NAME("");
				COMP_PBEN_BNF_NAME.resetValue();
			}*/
			/*End Newly added by pidugu raj dt: 30-09-2018 as suggested by sivaraman and vaitheeswaran*/
			
			
			/*added by raja on 11-04-2017 for change nation id label change*/
			
			labelChanged();
			
			/*end*/
			helper.PBEN_BNF_TYPE_WHEN_VALIDATE_ITEM(this);
			COMP_PBEN_PERC.resetValue();
				
		
			/*Added by Janani on 29.03.2018 for KIC*/
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			System.out.println("benfField ====>>" +benfField);
			
			/*
			 * 
			 * commented by Dhinesh on 30-05-2018 
			 * 
			 * if(benfField == 0)*/
			if(benfField == 0 || benfField == 2)
			{
				 /*
				  * 
				  * COMMENTED BY DHINESH ON 30-05-2018 
				  * 
				  * if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE() != null && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("B"))*/
				if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE() != null && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("N"))
				{
					if(benfField == 2)
					{
						COMP_UI_M_BANK_CODE.setRequired(false);
						COMP_UI_M_BRANCH_CODE.setRequired(false);
						COMP_PBEN_AGE.setRequired(false);
						COMP_PBEN_AGE.setDisabled(true);
//commented by gopi
						//COMP_PBEN_DOB.setRequired(true);
						COMP_PBEN_DOB.setDisabled(false);
						COMP_PBEN_BNF_NAME.setRequired(true);
						COMP_PBEN_NAME_MAND.setRendered(true);
						COMP_PBEN_REF_ID1.setRequired(false);
						COMP_PBEN_REF_ID1.setDisabled(false);
						COMP_PBEN_CATG_CODE.setRequired(false);
						COMP_PBEN_CATG_CODE.setDisabled(false);
						COMP_PBEN_RELATION_CODE.setRequired(true);
						COMP_PBEN_RELATION_CODE.setDisabled(false);
						COMP_PBEN_ACNT_NO.setRequired(false);
						COMP_PBEN_ACNT_NO.setDisabled(false);
						COMP_PBEN_EMAIL.setRequired(false);
						COMP_PBEN_REMARKS.setRequired(false);
						COMP_PBEN_PERC.setRequired(true);
						COMP_PBEN_PERC.setDisabled(false);
						COMP_PBEN_GUARDIAN_NAME.setDisabled(false);
						
					}else
					{
						/*
						 * 
						 * Commented by Dhinesh on 06-06-2018 for KIC  Bankcode and BranchCode not mandatory
						 * 
						 * COMP_UI_M_BANK_CODE.setRequired(true);
						COMP_UI_M_BRANCH_CODE.setRequired(true);*/
						
						COMP_UI_M_BANK_CODE.setRequired(false);
						COMP_UI_M_BRANCH_CODE.setRequired(false);

						COMP_PBEN_AGE.setRequired(false);
						COMP_PBEN_DOB.setRequired(false);
						getCOMP_PBEN_DOB().setDisabled(false);
						COMP_PBEN_BNF_NAME.setRequired(false);
						COMP_PBEN_NAME_MAND.setRendered(false);
						COMP_PBEN_REF_ID1.setRequired(false);
						COMP_PBEN_CATG_CODE.setRequired(false);
						COMP_PBEN_AGE.setDisabled(false);
						COMP_PBEN_RELATION_CODE.setRequired(false);
						COMP_PBEN_BNF_NAME.setRequired(false);
						COMP_PBEN_NAME_MAND.setRendered(false);
						COMP_PBEN_ACNT_NO.setRequired(false);
						COMP_PBEN_EMAIL.setRequired(false);
						COMP_PBEN_REMARKS.setRequired(false);
						COMP_PBEN_PERC.setRequired(true);
					}
					
					
				}else if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE() != null && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("S"))
				{
					if(benfField == 2)
					{
						COMP_PBEN_BNF_NAME.setRequired(true);
						COMP_PBEN_AGE.setRequired(false);
						COMP_PBEN_AGE.setDisabled(true);
						COMP_PBEN_DOB.setRequired(false);
						COMP_PBEN_DOB.setDisabled(true);
						COMP_PBEN_CATG_CODE.setRequired(false);
						COMP_PBEN_CATG_CODE.setDisabled(true);
						COMP_PBEN_RELATION_CODE.setRequired(true);
						COMP_PBEN_PERC.setRequired(true);
						COMP_PBEN_PERC.setDisabled(false);
						COMP_UI_M_BANK_CODE.setRequired(true);
						COMP_UI_M_BANK_CODE.setDisabled(false);
						COMP_PBEN_GUARDIAN_NAME.setRequired(false);
						COMP_PBEN_GUARDIAN_NAME.setDisabled(true);
						COMP_PBEN_ACNT_NO.setRequired(false);
						COMP_PBEN_ACNT_NO.setDisabled(false);
						COMP_UI_M_BRANCH_CODE.setRequired(false);
						COMP_UI_M_BRANCH_CODE.setDisabled(false);
						COMP_PBEN_EMAIL.setRequired(false);
						COMP_PBEN_EMAIL.setDisabled(false);
						COMP_PBEN_REMARKS.setRequired(false);
						COMP_PBEN_REMARKS.setDisabled(false);
						COMP_PBEN_REF_ID1.setRequired(false);
						COMP_PBEN_REF_ID1.setDisabled(true);
						
						COMP_PBEN_NAME_MAND.setRendered(true);
						COMP_PBEN_BNF_NAME.setRequired(true);
						
						
					
					}
					else
					{
					
					COMP_PBEN_REF_ID1.setRequired(false);
					COMP_PBEN_DOB.setRequired(false);
					COMP_PBEN_CATG_CODE.setRequired(false);
					COMP_PBEN_AGE.setRequired(false);
					COMP_PBEN_RELATION_CODE.setRequired(false);
					COMP_PBEN_BNF_NAME.setRequired(false);
					COMP_PBEN_NAME_MAND.setRendered(false);
					COMP_PBEN_ACNT_NO.setRequired(false);
					COMP_UI_M_BANK_CODE.setRequired(false);
					COMP_UI_M_BRANCH_CODE.setRequired(false);
					COMP_PBEN_EMAIL.setRequired(false);
					COMP_PBEN_REMARKS.setRequired(false);
					COMP_PBEN_PERC.setRequired(true);
					}				
				}else
				{
					if(benfField == 2)
					{
						COMP_PBEN_BNF_NAME.setRequired(true);
						COMP_PBEN_AGE.setRequired(false);
						COMP_PBEN_AGE.setDisabled(true);
						COMP_PBEN_DOB.setRequired(false);
						COMP_PBEN_DOB.setDisabled(true);
						COMP_PBEN_CATG_CODE.setRequired(false);
						COMP_PBEN_CATG_CODE.setDisabled(true);
						COMP_PBEN_RELATION_CODE.setRequired(true);
						COMP_PBEN_PERC.setRequired(true);
						COMP_PBEN_PERC.setDisabled(false);
						COMP_UI_M_BANK_CODE.setRequired(true);
						COMP_UI_M_BANK_CODE.setDisabled(false);
						COMP_PBEN_GUARDIAN_NAME.setRequired(false);
						COMP_PBEN_GUARDIAN_NAME.setDisabled(true);
						COMP_PBEN_ACNT_NO.setRequired(false);
						COMP_PBEN_ACNT_NO.setDisabled(false);
						COMP_UI_M_BRANCH_CODE.setRequired(false);
						COMP_UI_M_BRANCH_CODE.setDisabled(false);
						COMP_PBEN_EMAIL.setRequired(false);
						COMP_PBEN_EMAIL.setDisabled(false);
						COMP_PBEN_REMARKS.setRequired(false);
						COMP_PBEN_REMARKS.setDisabled(false);
						COMP_PBEN_REF_ID1.setRequired(false);
						COMP_PBEN_REF_ID1.setDisabled(true);
						
						COMP_PBEN_NAME_MAND.setRendered(true);
						COMP_PBEN_BNF_NAME.setRequired(true);
					
					}
					else
					{					
					COMP_PBEN_REF_ID1.setRequired(false);
					COMP_PBEN_DOB.setRequired(false);
					COMP_PBEN_CATG_CODE.setRequired(false);
					COMP_PBEN_AGE.setRequired(false);
					COMP_PBEN_RELATION_CODE.setRequired(false);
					COMP_PBEN_BNF_NAME.setRequired(false);
					COMP_PBEN_NAME_MAND.setRendered(true);
					COMP_PBEN_ACNT_NO.setRequired(false);
					COMP_UI_M_BANK_CODE.setRequired(false);
					COMP_UI_M_BRANCH_CODE.setRequired(false);
					COMP_PBEN_EMAIL.setRequired(false);
					COMP_PBEN_REMARKS.setRequired(false);
					COMP_PBEN_PERC.setRequired(false);
					getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);
					}
				}
			}
			else
			{
			
			/*End of KIC changes*/	
				
			if("A".equals(Current) || "S".equalsIgnoreCase(Current)){
				/*PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE("");
				PT_IL_POL_BENEFICIARY_BEAN.setUI_M_PBEN_RELATION_DESC("");*/
				
				/*Modified by Janani to disable relationship for Assignee as suggested by Vinoth and Sivaram on 02.05.2018*/
				//COMP_PBEN_RELATION_CODE.setRequired(true);
				COMP_PBEN_RELATION_CODE.setRequired(false);
				COMP_PBEN_RELATION_CODE.setDisabled(true);
				
				/*End*/
				/*COMP_PBEN_RELATION_CODE.resetValue();
				COMP_UI_M_PBEN_RELATION_DESC.resetValue();*/
				COMP_UI_M_BRANCH_CODE.setDisabled(false);
				COMP_UI_M_BANK_CODE.setDisabled(false);
				
				/*added by raja on 12-05-2017*/
				//commented by gopi
				/*COMP_UI_M_BRANCH_CODE.setRequired(true);
				COMP_UI_M_BANK_CODE.setRequired(true);*/
				
				/*end*/
				
			}
			else{
				
				COMP_UI_M_BRANCH_CODE.setDisabled(true);
				COMP_UI_M_BANK_CODE.setDisabled(true);
				COMP_PBEN_RELATION_CODE.setRequired(true);
				COMP_PBEN_RELATION_CODE.setDisabled(false);
				/*COMP_PBEN_RELATION_CODE.resetValue();*/
				/*added by raja on 12-05-2017*/
				COMP_UI_M_BRANCH_CODE.setRequired(false);
				COMP_UI_M_BANK_CODE.setRequired(false);
				
				/*end*/
			}
			
			}
			

			//resetAllComponent();
			
		
					
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	
	public void Validate_type(ActionEvent actionEvent){

		try {
			String Current=(String) COMP_PBEN_BNF_TYPE.getSubmittedValue();
			if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE()!=null){
							
				
				/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				if(!PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equals(Current)){
					/*End*/
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE(null);	
					PT_IL_POL_BENEFICIARY_BEAN.setUI_M_PBEN_RELATION_DESC(null);
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REF_ID1(null);
					COMP_PBEN_RELATION_CODE.resetValue();
					COMP_UI_M_PBEN_RELATION_DESC.resetValue();
					COMP_PBEN_REF_ID1.resetValue();
				}
			}
			
			/*changed by rja on 12-05-2017*/
			
			/*PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_TYPE(Current);*/
			
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_TYPE(COMP_PBEN_BNF_TYPE.getSubmittedValue().toString());
			
			/*end*/
			
			/*added by raja on 11-04-2017 for change nation id label change*/
			
			labelChanged();
			
			/*end*/
			helper.PBEN_BNF_TYPE_WHEN_VALIDATE_ITEM(this);
			COMP_PBEN_PERC.resetValue();
				
		
			/*Added by Janani on 29.03.2018 for KIC*/
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			System.out.println("benfField ====>>" +benfField);
			
			/*
			 * 
			 * commented by Dhinesh on 30-05-2018 
			 * 
			 * if(benfField == 0)*/
			if(benfField == 0 || benfField == 2)
			{
				 /*
				  * 
				  * COMMENTED BY DHINESH ON 30-05-2018 
				  * 
				  * if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE() != null && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("B"))*/
				if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE() != null && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("N"))
				{
					if(benfField == 2)
					{
						COMP_UI_M_BANK_CODE.setRequired(true);
						COMP_UI_M_BRANCH_CODE.setRequired(true);
						COMP_PBEN_AGE.setRequired(false);
						COMP_PBEN_AGE.setDisabled(false);
						//commented by gopi

					//	COMP_PBEN_DOB.setRequired(true);
						COMP_PBEN_DOB.setDisabled(false);
						COMP_PBEN_BNF_NAME.setRequired(false);
						COMP_PBEN_BNF_NAME.setRequired(false);
						COMP_PBEN_NAME_MAND.setRendered(false);
						COMP_PBEN_NAME_MAND.setRendered(false);
						COMP_PBEN_REF_ID1.setRequired(false);
						COMP_PBEN_REF_ID1.setDisabled(false);
						COMP_PBEN_CATG_CODE.setRequired(false);
						COMP_PBEN_CATG_CODE.setDisabled(false);
						COMP_PBEN_RELATION_CODE.setRequired(false);
						COMP_PBEN_RELATION_CODE.setDisabled(false);
						COMP_PBEN_ACNT_NO.setRequired(false);
						COMP_PBEN_ACNT_NO.setDisabled(false);
						COMP_PBEN_EMAIL.setRequired(false);
						COMP_PBEN_REMARKS.setRequired(false);
						COMP_PBEN_PERC.setRequired(true);
						COMP_PBEN_PERC.setDisabled(false);
						COMP_PBEN_GUARDIAN_NAME.setDisabled(false);
						
					}else
					{
						COMP_UI_M_BANK_CODE.setRequired(true);
						COMP_UI_M_BRANCH_CODE.setRequired(true);
						COMP_PBEN_AGE.setRequired(false);
						COMP_PBEN_DOB.setRequired(false);
						getCOMP_PBEN_DOB().setDisabled(true);
						COMP_PBEN_BNF_NAME.setRequired(false);
						COMP_PBEN_NAME_MAND.setRendered(false);
						COMP_PBEN_REF_ID1.setRequired(false);
						COMP_PBEN_DOB.setRequired(false);
						COMP_PBEN_CATG_CODE.setRequired(false);
						COMP_PBEN_AGE.setRequired(false);
						COMP_PBEN_RELATION_CODE.setRequired(false);
						COMP_PBEN_BNF_NAME.setRequired(false);
						COMP_PBEN_NAME_MAND.setRendered(false);
						COMP_PBEN_ACNT_NO.setRequired(false);
						COMP_PBEN_EMAIL.setRequired(false);
						COMP_PBEN_REMARKS.setRequired(false);
						COMP_PBEN_PERC.setRequired(true);
					}
					
					
				}else if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE() != null && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("S"))
				{
					if(benfField == 2)
					{
						COMP_PBEN_BNF_NAME.setRequired(true);
						COMP_PBEN_NAME_MAND.setRendered(true);
						COMP_PBEN_REF_ID1.setDisabled(true);
						COMP_PBEN_DOB.setDisabled(true);
						COMP_PBEN_CATG_CODE.setDisabled(true);
						COMP_PBEN_AGE.setDisabled(true);
						COMP_PBEN_RELATION_CODE.setDisabled(false);
						COMP_PBEN_PERC.setDisabled(false);
						COMP_PBEN_PERC.setRequired(true);
						COMP_PBEN_GUARDIAN_NAME.setDisabled(true);
						COMP_UI_M_BANK_CODE.setRequired(true);
						COMP_UI_M_BANK_CODE.setDisabled(false);
						COMP_PBEN_ACNT_NO.setRequired(false);
						COMP_PBEN_ACNT_NO.setDisabled(false);
						COMP_UI_M_BRANCH_CODE.setRequired(false);
						COMP_UI_M_BRANCH_CODE.setDisabled(false);
						COMP_PBEN_EMAIL.setRequired(false);
						COMP_PBEN_EMAIL.setDisabled(false);
						COMP_PBEN_REMARKS.setRequired(false);
						COMP_PBEN_REMARKS.setDisabled(false);
					
					}
					else
					{
					
					COMP_PBEN_REF_ID1.setRequired(false);
					COMP_PBEN_DOB.setRequired(false);
					COMP_PBEN_CATG_CODE.setRequired(false);
					COMP_PBEN_AGE.setRequired(false);
					COMP_PBEN_RELATION_CODE.setRequired(false);
					COMP_PBEN_BNF_NAME.setRequired(false);
					COMP_PBEN_NAME_MAND.setRendered(false);
					COMP_PBEN_ACNT_NO.setRequired(false);
					COMP_UI_M_BANK_CODE.setRequired(false);
					COMP_UI_M_BRANCH_CODE.setRequired(false);
					COMP_PBEN_EMAIL.setRequired(false);
					COMP_PBEN_REMARKS.setRequired(false);
					COMP_PBEN_PERC.setRequired(true);
					}				
				}else
				{
					if(benfField == 2)
					{
						COMP_PBEN_BNF_NAME.setRequired(true);
						COMP_PBEN_NAME_MAND.setRendered(true);
						COMP_PBEN_REF_ID1.setDisabled(true);
						COMP_PBEN_DOB.setDisabled(true);
						COMP_PBEN_CATG_CODE.setDisabled(true);
						COMP_PBEN_AGE.setDisabled(true);
						COMP_PBEN_RELATION_CODE.setDisabled(false);
						COMP_PBEN_PERC.setDisabled(false);
						COMP_PBEN_PERC.setRequired(true);
						COMP_PBEN_GUARDIAN_NAME.setDisabled(true);
						COMP_UI_M_BANK_CODE.setRequired(true);
						COMP_UI_M_BANK_CODE.setDisabled(false);
						COMP_PBEN_ACNT_NO.setRequired(false);
						COMP_PBEN_ACNT_NO.setDisabled(false);
						COMP_UI_M_BRANCH_CODE.setRequired(false);
						COMP_UI_M_BRANCH_CODE.setDisabled(false);
						COMP_PBEN_EMAIL.setRequired(false);
						COMP_PBEN_EMAIL.setDisabled(false);
						COMP_PBEN_REMARKS.setRequired(false);
						COMP_PBEN_REMARKS.setDisabled(false);
					
					}
					else
					{					
					COMP_PBEN_REF_ID1.setRequired(false);
					COMP_PBEN_DOB.setRequired(false);
					COMP_PBEN_CATG_CODE.setRequired(false);
					COMP_PBEN_AGE.setRequired(false);
					COMP_PBEN_RELATION_CODE.setRequired(false);
					COMP_PBEN_BNF_NAME.setRequired(false);
					COMP_PBEN_NAME_MAND.setRendered(true);
					COMP_PBEN_ACNT_NO.setRequired(false);
					COMP_UI_M_BANK_CODE.setRequired(false);
					COMP_UI_M_BRANCH_CODE.setRequired(false);
					COMP_PBEN_EMAIL.setRequired(false);
					COMP_PBEN_REMARKS.setRequired(false);
					COMP_PBEN_PERC.setRequired(false);
					getCOMP_PBEN_GUARDIAN_NAME().setRequired(false);
					}
				}
			}
			else
			{
			
			/*End of KIC changes*/	
				
			if("A".equals(Current) || "S".equalsIgnoreCase(Current)){
				/*PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE("");
				PT_IL_POL_BENEFICIARY_BEAN.setUI_M_PBEN_RELATION_DESC("");*/
				
				/*Modified by Janani to disable relationship for Assignee as suggested by Vinoth and Sivaram on 02.05.2018*/
				//COMP_PBEN_RELATION_CODE.setRequired(true);
				COMP_PBEN_RELATION_CODE.setRequired(false);
				COMP_PBEN_RELATION_CODE.setDisabled(true);
				
				/*End*/
				/*COMP_PBEN_RELATION_CODE.resetValue();
				COMP_UI_M_PBEN_RELATION_DESC.resetValue();*/
				COMP_UI_M_BRANCH_CODE.setDisabled(false);
				COMP_UI_M_BANK_CODE.setDisabled(false);
				
				/*added by raja on 12-05-2017*/
				COMP_UI_M_BRANCH_CODE.setRequired(true);
				COMP_UI_M_BANK_CODE.setRequired(true);
				
				/*end*/
				
			}
			else{
				
				COMP_UI_M_BRANCH_CODE.setDisabled(true);
				COMP_UI_M_BANK_CODE.setDisabled(true);
				COMP_PBEN_RELATION_CODE.setRequired(true);
				COMP_PBEN_RELATION_CODE.setDisabled(false);
				/*COMP_PBEN_RELATION_CODE.resetValue();*/
				/*added by raja on 12-05-2017*/
				COMP_UI_M_BRANCH_CODE.setRequired(false);
				COMP_UI_M_BANK_CODE.setRequired(false);
				
				/*end*/
			}
			
			}
			

			//resetAllComponent();
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			/*throw new ValidatorException(new FacesMessage(e.getMessage()));*/
		}
	}
	
/*	
	public void Validate_type(FacesContext context,
			UIComponent component, Object value){

		try {
			String Current=(String) value;
			if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE()!=null){
				 changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee
				if(!PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equals((String)value)){
					End
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE(null);	
					PT_IL_POL_BENEFICIARY_BEAN.setUI_M_PBEN_RELATION_DESC(null);
					COMP_PBEN_RELATION_CODE.resetValue();
					COMP_UI_M_PBEN_RELATION_DESC.resetValue();
				}
			}
			
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_TYPE(Current);
			helper.PBEN_BNF_TYPE_WHEN_VALIDATE_ITEM(this);
		COMP_PBEN_PERC.resetValue();
				
		
			if("A".equals(Current) || "S".equalsIgnoreCase(Current)){
				
				Modifed by Janani on 11/04/2017 for Delete Space
				 * 
				 * PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE(" ");
				 * 
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE("");
				End
				
				PT_IL_POL_BENEFICIARY_BEAN.setUI_M_PBEN_RELATION_DESC(" ");
				COMP_PBEN_RELATION_CODE.setRequired(false);
				COMP_PBEN_RELATION_CODE.resetValue();
				COMP_UI_M_PBEN_RELATION_DESC.resetValue();
				COMP_UI_M_BRANCH_CODE.setDisabled(false);
				COMP_UI_M_BANK_CODE.setDisabled(false);
				
			}
			else{
				
				COMP_UI_M_BRANCH_CODE.setDisabled(true);
				COMP_UI_M_BANK_CODE.setDisabled(true);
				COMP_PBEN_RELATION_CODE.setRequired(true);
				COMP_PBEN_RELATION_CODE.resetValue();
				
			}
			
			
			

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}*/
/*end*/
	
	/* changed the method arguments by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

	//public void PBEN_REF_ID1_WHEN_VALIDATE_ITEM(ActionEvent actionEvent){
	public void PBEN_REF_ID1_WHEN_VALIDATE_ITEM(FacesContext context,
						UIComponent component, Object value){
		/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
		getErrorMap().clear();
		getWarningMap().clear();
		/*End*/
		/*Added by Ameen on 28-09-2017 as per siva sugg.*/
		String eduPlanQuery = "SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_CODE = 'IL_BEN_AGE'";
		ResultSet eduPlanRS = null;
		int eduAge = 0;
		/*End*/
		try {
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

			//PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REF_ID1(COMP_PBEN_REF_ID1.getSubmittedValue().toString());
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REF_ID1((String)value);
			/*added by sankaranarayanan for ssp ZBILQC-1719274*/
			if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_REF_ID1()!=null&&!("".equalsIgnoreCase(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_REF_ID1()))){
			helper.PBEN_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,PT_IL_POL_BENEFICIARY_BEAN);
			}
			/*end*/
			COMP_PBEN_CATG_CODE.resetValue();
			COMP_UI_M_CATG_DESC.resetValue();
			COMP_PBEN_AGE.resetValue();
			COMP_PBEN_ADDRESS_1.resetValue();
			COMP_PBEN_ADDRESS_2.resetValue();
			COMP_PBEN_ADDRESS_3.resetValue();
			COMP_PBEN_ADDRESS_4.resetValue();
			COMP_PBEN_ADDRESS_5.resetValue();
			COMP_UI_M_BRANCH_CODE.resetValue();
			COMP_PBEN_BNF_CODE.resetValue();
			COMP_PBEN_BNF_NAME.resetValue();
			COMP_PBEN_DOB.resetValue();
			COMP_UI_M_BANK_CODE.resetValue();
			COMP_UI_M_BANK_CODE_DESC.resetValue();
			
			/*added by raja on 12-05-2017*/
			COMP_UI_M_BRANCH_CODE.resetValue();
			COMP_PBEN_EMAIL.resetValue();
			/*end*/
			
			/* change the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			
			/*COMP_UI_M_CITY_CODE_DESC.resetValue();
			COMP_UI_M_CITY_CODE.resetValue();*/
			
			/*end*/
			
/* Enabled by Janani on 11/04/2017 */
		
			COMP_UI_M_CITY_CODE_DESC.resetValue();
			COMP_UI_M_CITY_CODE.resetValue();
			
			/*End*/
			
			COMP_PBEN_ACNT_NO.resetValue();
			
			/*Added by Raja on 13/04/2017*/
			COMP_UI_M_BRANCH_CODE.resetValue();
			COMP_PBEN_EMAIL.resetValue();
			/*End*/
			
			/*Added by Ameen on 28-09-2017 as per siva sugg.*/
			eduPlanRS = new CRUDHandler().executeSelectStatement(eduPlanQuery, CommonUtils.getConnection());
			if(eduPlanRS.next()){
				eduAge = eduPlanRS.getInt("PS_VALUE");
			}
			
			if("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())){
				if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_AGE() > eduAge){
					
					/*Modified by ganesh on 27-10-2017 as suggested by thiyags*/
					//throw new Exception("Age Should be 10 or below 10 for this Product");
					throw new Exception("Child age should be less than "+eduAge+" for Education Plan");
					/*end*/
				}
			}
			/*End*/
		} catch (Exception e) {
			/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

			getErrorMap().put("current", e.getMessage());

			/*End*/
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PBEN_REF_ID2_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REF_ID2((String) value);

			helper.PBEN_REF_ID2_WHEN_VALIDATE_ITEM(PT_IL_POL_BENEFICIARY_BEAN);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void PBEN_CATG_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			String val = (String) value ;
			if(!(val.equalsIgnoreCase(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_CATG_CODE()))){
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_CATG_CODE((String) value);
				helper.PBEN_CATG_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_BENEFICIARY_BEAN);
			}		
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PBEN_AGE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			Integer val = (Integer) value;
		/*	if(!(val==PT_IL_POL_BENEFICIARY_BEAN.getPBEN_AGE())){*/
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_AGE((Integer) value);
				
				/*Added by Janani on 29.03.2018 for KIC*/
				int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
				System.out.println("benfField ====>>" +benfField);
				
				/*
				 * 
				 * commented by Dhinesh on 30-05-2018 
				 * 
				 * if(benfField == 0)*/
				if(benfField == 0 || benfField == 2)
				{
					 if(COMP_PBEN_AGE.isRequired() == true)
					{
						 helper.PBEN_AGE_WHEN_VALIDATE_ITEM(this);
					}
				}else
				{
					/*End*/
				helper.PBEN_AGE_WHEN_VALIDATE_ITEM(this);
				
				}
			//}		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	
	
	public void PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			String Current =(String) value;
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_RELATION_CODE(Current);
			/*added by sankaranarayanan for ssp ZBILQC-1719274*/
/*Modifed by Raja on 13/04/2017
 * 
 * if(Current!=null && !(" ".equalsIgnoreCase(Current))){*/
			if(Current!=null && !("".equalsIgnoreCase(Current))){
				/*End*/
				
			helper.PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_BENEFICIARY_BEAN);
}
/*end*/	
COMP_UI_M_PBEN_RELATION_DESC.resetValue();

			/*Added by Ameen on 28-09-2017 as per siva sugg.*/
			if("EDU".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getUnit_link_typ())){
				
				if(CommonUtils.isIN(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_RELATION_CODE(), "REL007","REL020","REL021","REL008")){
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_PERC(100.0);
					COMP_PBEN_PERC.setDisabled(true);
					COMP_PBEN_PERC.resetValue();
				}else{
					throw new Exception("Unable to add relation " + PT_IL_POL_BENEFICIARY_BEAN.getPBEN_RELATION_CODE() + " for this Product");
				}
				
			}
			/*end*/	

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void PBEN_PERC_WHEN_VALIDATE_ITEM(FacesContext context,UIComponent component, Object value){
		try {
			/*added by  raja on 15-05-2017*/
			double precentage=(Double) value;
			/*end*/
			
			
			/*changed by  raja on 15-05-2017*/
			/*helper.PBEN_PERC_WHEN_VALIDATE_ITEM(this,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());*/
			helper.PBEN_PERC_WHEN_VALIDATE_ITEM(this,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),precentage);
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_PERC((Double) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<LovBean> prepareSuggestionList_PBEN_BNF_TYPE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_BNF_TYPE";
		Object param1 = "ILBENFTYPE";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList =	itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_PBEN_CATG_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_CATG_CODE";
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

	/*public ArrayList<LovBean> prepareSuggestionList_PBEN_RELATION_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_RELATION_CODE";
		Object param1 = "ILBENFREL";

		try {

			Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (Start)

			Object param2;
			String value=compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getPT_IL_POL_BENEFICIARY_BEAN().getPBEN_BNF_TYPE();
			 changed the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee
			if(value.equals("A") || value.equalsIgnoreCase("S"))
				param2="2";			
			else
				param2="1";
			System.out.println("param2      "+param2);
			System.out.println("value      "+value);
			Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (End)

			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
			Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (Start)
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, param2,
					null, null, null, currentValue);
			Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (End)

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}*/
	
	public ArrayList<LovBean> prepareSuggestionList_PBEN_RELATION_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String currentValue = (String) object;
		String query = null;
		String query2 = null;
		try {
			/*
			 * modified by Ameen on 15-11-2017 for ZBLIFE-1455133
			 * query = "SELECT PC_CODE, PC_DESC, PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = 'ILBENFREL'"
					+ " AND PC_VALUE = '1' AND (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?) "
					+ "OR UPPER(PC_BL_DESC) LIKE UPPER(?)) AND ROWNUM < 30 ORDER BY 1";*/
			
			 query = "SELECT PC_CODE, PC_DESC, PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = 'ILBENFREL' AND PC_VALUE = '1' AND "
			 		+ "PC_CLASS_CODE  = '0' UNION SELECT PC_CODE, PC_DESC, PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = 'ILBENFREL' "
			 		+ "AND PC_VALUE = '1' AND PC_CLASS_CODE = ? AND (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?) "
			 		+ "OR UPPER(PC_BL_DESC) LIKE UPPER(?)) AND ROWNUM < 30 ORDER BY 1";
			
			 query2= "SELECT PC_CODE, PC_DESC, PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = 'ILBENFREL' AND PC_VALUE = '2' "
			 		+ " AND (UPPER(PC_CODE) LIKE UPPER( ? ) OR UPPER(PC_DESC) LIKE UPPER( ? ) OR  UPPER(PC_BL_DESC) LIKE UPPER( ? ))  AND ROWNUM < 30  ORDER BY 1";
			 
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			
			if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE() != null && PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("N"))
			{
				lovList = ListItemUtil.prepareSuggestionList(query, new Object[] {PT_IL_POL_BENEFICIARY_BEAN.getPBEN_CATG_CODE(),
						currentValue, currentValue, currentValue});	
			}else
			{
				lovList = ListItemUtil.prepareSuggestionList(query2, new Object[] { currentValue, currentValue, currentValue });
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
	 * Disables all components in PT_IL_POL_BENEFICIARY_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		
		/*ADDED BY RAJA ON 13-04-2017 FOR DISABLE COMPONENT*/
		COMP_UI_M_BANK_CODE.setDisabled(disabled);
		COMP_UI_M_BRANCH_CODE.setDisabled(disabled);
		COMP_PBEN_CATG_CODE.setDisabled(disabled);
		/*END*/
		
		
		COMP_PBEN_SR_NO.setDisabled(disabled);
		COMP_PBEN_BNF_TYPE.setDisabled(disabled);
		COMP_PBEN_REF_ID1.setDisabled(disabled);
		COMP_PBEN_REF_ID2.setDisabled(disabled);
		COMP_PBEN_CATG_CODE.setDisabled(disabled);
		COMP_PBEN_AGE.setDisabled(disabled);
		COMP_PBEN_RELATION_CODE.setDisabled(disabled);
		COMP_PBEN_PERC.setDisabled(disabled);
		COMP_PBEN_GUARDIAN_NAME.setDisabled(disabled);
		COMP_PBEN_ADDRESS_1.setDisabled(disabled);
		COMP_PBEN_BNF_NAME.setDisabled(disabled);
		COMP_PBEN_ADDRESS_3.setDisabled(disabled);
		COMP_PBEN_ADDRESS_2.setDisabled(disabled);
		COMP_PBEN_REMARKS.setDisabled(disabled);
		COMP_PBEN_ADDRESS_4.setDisabled(disabled);
		COMP_UI_M_CATG_DESC.setDisabled(disabled);
		COMP_PBEN_ADDRESS_5.setDisabled(disabled);
		COMP_UI_M_PBEN_TYPE_DESC.setDisabled(disabled);
		COMP_UI_M_PBEN_RELATION_DESC.setDisabled(disabled);
		COMP_PBEN_MICR_CODE.setDisabled(disabled);
		COMP_PBEN_ACNT_NO.setDisabled(disabled);
		/* changed by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/


		COMP_PBEN_DOB.setDisabled(disabled);

		COMP_PBEN_EFF_FM_DT.setDisabled(disabled);

		COMP_PBEN_EFF_TO_DT.setDisabled(disabled);

		COMP_PBEN_BNF_CODE.setDisabled(disabled);

		/* end */
		
		
		
		/*changed by R. Raja on 24-03-2017 for ssp call ZBILQC-1719436*/
		COMP_PBEN_EMAIL.setDisabled(disabled);
	/*end*/
		
		/*Added by Ram on 17/04/2017*/
		COMP_UI_M_CITY_CODE.setDisabled(disabled);
		/*End*/
		
		/*Added by Ameen for KIC*/
		COMP_PBEN_REF_ID1_NEW.setDisabled(disabled);
		/*End*/

		/*Added by Janani on 02.04.2018 for KIC*/
		
		 COMP_UI_M_BANK_CODE.setDisabled(disabled);
		 COMP_UI_M_BRANCH_CODE.setDisabled(disabled);
		
		/*End*/
		 /*Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
		 COMP_PBEN_GUARDIAN_NATN_ID.setDisabled(disabled);
		 /*End Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
		 /*Newly added by pidugu raj dt: 22-09-2020 for Alliance IL*/
			COMP_PBEN_GUARDIAN_NATN_ID_TYPE.setDisabled(disabled);
			COMP_PBEN_BENEF_ID_TYPE.setDisabled(disabled);
			/*End Newly added by pidugu raj dt: 22-09-2020 for Alliance IL*/
			COMP_PBEN_AREA_CODE.setDisabled(disabled);
			COMP_PBEN_MOBILE_NO.setDisabled(disabled);
			COMP_PBEN_REL_OTHER.setDisabled(disabled);
	}


	/**
	 * Instantiates all components in PT_IL_POL_BENEFICIARY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PBEN_SR_NO					 = new HtmlInputText();
		COMP_PBEN_BNF_TYPE				 = new HtmlInputText();
		COMP_PBEN_REF_ID1				 = new HtmlInputText();
		COMP_PBEN_REF_ID2				 = new HtmlInputText();
		COMP_PBEN_CATG_CODE				 = new HtmlInputText();
		COMP_PBEN_AGE					 = new HtmlInputText();
		COMP_PBEN_RELATION_CODE				 = new HtmlInputText();
		COMP_PBEN_PERC					 = new HtmlInputText();
		COMP_PBEN_GUARDIAN_NAME				 = new HtmlInputText();
		COMP_PBEN_ADDRESS_1				 = new HtmlInputText();
		COMP_PBEN_BNF_NAME				 = new HtmlInputText();
		COMP_PBEN_ADDRESS_3				 = new HtmlInputText();
		COMP_PBEN_ADDRESS_2				 = new HtmlInputText();
		COMP_PBEN_REMARKS				 = new HtmlInputText();
		COMP_PBEN_ADDRESS_4				 = new HtmlInputText();
		COMP_UI_M_CATG_DESC				 = new HtmlInputText();
		COMP_PBEN_ADDRESS_5				 = new HtmlInputText();
		COMP_UI_M_PBEN_TYPE_DESC			 = new HtmlInputText();
		COMP_UI_M_PBEN_RELATION_DESC			 = new HtmlInputText();
		COMP_PBEN_MICR_CODE               = new HtmlInputText();
		COMP_PBEN_ACNT_NO                = new HtmlInputText();
		
		// Instantiating HtmlOutputLabel
		COMP_PBEN_SR_NO_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_BNF_TYPE_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_REF_ID1_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_REF_ID2_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_CATG_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_AGE_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_RELATION_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_PERC_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_GUARDIAN_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_ADDRESS_1_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_BNF_NAME_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_ADDRESS_3_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_ADDRESS_2_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_REMARKS_LABEL				 = new HtmlOutputLabel();
		COMP_PBEN_ADDRESS_4_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_CATG_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_PBEN_ADDRESS_5_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PBEN_TYPE_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PBEN_RELATION_DESC_LABEL		 = new HtmlOutputLabel();
		
		/*Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (Start)*/
		
		COMP_PBEN_DOB_LABEL=new HtmlOutputLabel();
		COMP_PBEN_DOB=new HtmlCalendar();
		COMP_PBEN_EFF_FM_DT_LABEL=new HtmlOutputLabel();
		COMP_PBEN_EFF_FM_DT=new HtmlCalendar();
		COMP_PBEN_EFF_TO_DT_LABEL=new HtmlOutputLabel();
		COMP_PBEN_EFF_TO_DT=new HtmlCalendar();
		COMP_PBEN_BNF_CODE=new HtmlInputText();
		COMP_PBEN_EMAIL=new HtmlInputText();
		COMP_PBEN_GUAR_REL_CODE = new HtmlInputText();
		/*end*/

		
		/*ADDED BY RAJA ON 13-04-2017 FOR DISABLE COMPONENT*/
		COMP_UI_M_BANK_CODE=new HtmlInputText();
		COMP_UI_M_BRANCH_CODE=new HtmlInputText();
		COMP_PBEN_CATG_CODE=new HtmlInputText();
		/*END*/
		
		/*Added by Ram on 20/04/2017*/
		COMP_UI_M_CITY_CODE= new HtmlInputText();
		/*End*/
		
		/*Added by Ameen for KIC*/
		COMP_PBEN_REF_ID1_NEW = new HtmlInputText();
		/*End*/
		
		/*Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
		COMP_PBEN_GUARDIAN_NATN_ID_LABEL = new HtmlOutputLabel();
		COMP_PBEN_GUARDIAN_NATN_ID = new HtmlInputText();
		COMP_PBEN_GUARDIAN_NATN_ID_TYPE = new HtmlSelectOneMenu();
		COMP_PBEN_GUARDIAN_NATN_ID_TYPE_LABEL = new HtmlOutputLabel();
		COMP_PBEN_BENEF_ID_TYPE = new HtmlSelectOneMenu();
		COMP_PBEN_BENEF_ID_TYPE_LABEL = new HtmlOutputLabel();
		COMP_PBEN_AREA_CODE = new HtmlInputText();
		COMP_PBEN_MOBILE_NO = new HtmlInputText();
		COMP_PBEN_MOBILE_NUMBER_LABEL = new HtmlOutputLabel();
		COMP_PBEN_REL_OTHER = new HtmlInputText();
		COMP_PBEN_REL_OTHER_LABEL = new HtmlOutputLabel();
	}



	public HtmlOutputLabel getCOMP_PBEN_MICR_CODE_LABEL() {
		return COMP_PBEN_MICR_CODE_LABEL;
	}



	public void setCOMP_PBEN_MICR_CODE_LABEL(
			HtmlOutputLabel comp_pben_micr_code_label) {
		COMP_PBEN_MICR_CODE_LABEL = comp_pben_micr_code_label;
	}



	public HtmlInputText getCOMP_PBEN_MICR_CODE() {
		return COMP_PBEN_MICR_CODE;
	}



	public void setCOMP_PBEN_MICR_CODE(HtmlInputText comp_pben_micr_code) {
		COMP_PBEN_MICR_CODE = comp_pben_micr_code;
	}



	public HtmlOutputLabel getCOMP_UI_M_CITY_CODE_LABEL() {
		return COMP_UI_M_CITY_CODE_LABEL;
	}



	public void setCOMP_UI_M_CITY_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_city_code_label) {
		COMP_UI_M_CITY_CODE_LABEL = comp_ui_m_city_code_label;
	}



	public HtmlInputText getCOMP_UI_M_CITY_CODE() {
		return COMP_UI_M_CITY_CODE;
	}



	public void setCOMP_UI_M_CITY_CODE(HtmlInputText comp_ui_m_city_code) {
		COMP_UI_M_CITY_CODE = comp_ui_m_city_code;
	}



	public HtmlInputText getCOMP_UI_M_CITY_CODE_DESC() {
		return COMP_UI_M_CITY_CODE_DESC;
	}



	public void setCOMP_UI_M_CITY_CODE_DESC(HtmlInputText comp_ui_m_city_code_desc) {
		COMP_UI_M_CITY_CODE_DESC = comp_ui_m_city_code_desc;
	}



	public HtmlOutputLabel getCOMP_UI_M_BANK_CODE_LABEL() {
		return COMP_UI_M_BANK_CODE_LABEL;
	}



	public void setCOMP_UI_M_BANK_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_bank_code_label) {
		COMP_UI_M_BANK_CODE_LABEL = comp_ui_m_bank_code_label;
	}



	public HtmlInputText getCOMP_UI_M_BANK_CODE() {
		return COMP_UI_M_BANK_CODE;
	}



	public void setCOMP_UI_M_BANK_CODE(HtmlInputText comp_ui_m_bank_code) {
		COMP_UI_M_BANK_CODE = comp_ui_m_bank_code;
	}



	public HtmlInputText getCOMP_UI_M_BANK_CODE_DESC() {
		return COMP_UI_M_BANK_CODE_DESC;
	}



	public void setCOMP_UI_M_BANK_CODE_DESC(HtmlInputText comp_ui_m_bank_code_desc) {
		COMP_UI_M_BANK_CODE_DESC = comp_ui_m_bank_code_desc;
	}



	public HtmlOutputLabel getCOMP_UI_M_BRANCH_CODE_LABEL() {
		return COMP_UI_M_BRANCH_CODE_LABEL;
	}



	public void setCOMP_UI_M_BRANCH_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_branch_code_label) {
		COMP_UI_M_BRANCH_CODE_LABEL = comp_ui_m_branch_code_label;
	}



	public HtmlInputText getCOMP_UI_M_BRANCH_CODE() {
		return COMP_UI_M_BRANCH_CODE;
	}



	public void setCOMP_UI_M_BRANCH_CODE(HtmlInputText comp_ui_m_branch_code) {
		COMP_UI_M_BRANCH_CODE = comp_ui_m_branch_code;
	}



	public HtmlInputText getCOMP_UI_M_BRANCH_CODE_DESC() {
		return COMP_UI_M_BRANCH_CODE_DESC;
	}



	public void setCOMP_UI_M_BRANCH_CODE_DESC(
			HtmlInputText comp_ui_m_branch_code_desc) {
		COMP_UI_M_BRANCH_CODE_DESC = comp_ui_m_branch_code_desc;
	}



	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}



	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}



	public PT_IL_POL_BENEFICIARY_HELPER getHelper() {
		return helper;
	}



	public void setHelper(PT_IL_POL_BENEFICIARY_HELPER helper) {
		this.helper = helper;
	}

	// [ Added by vinoj as suggested by Akash

	public void chkMICRCode(Long micrCode) throws Exception{
		String query = "SELECT 'X' FROM PM_BANK_DTLS WHERE PMD_MICR_CODE = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[]{micrCode});
			if(resultSet.next()){
				//return x
			}else{
				throw new Exception("Invalid MICR Code.");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}

	}


	//[ADDED BY AKASH  TO IMPLEMENT DIRECT DEBIT /CREDIT.

	String citycode=null;
	String bankcode=null;
	String branchcode=null;

	public void  validateMICRCODE(FacesContext context,UIComponent component,Object value){

		try{
			Long value_1 = (Long) value;
			chkMICRCode(value_1);
			getPT_IL_POL_BENEFICIARY_BEAN().setPBEN_MICR_CODE(value_1);
			//getPW_PAYING_SLIP_DTLS_BEAN().setPSL_CHK_NO(value_1 );
			String str= String.valueOf(getPT_IL_POL_BENEFICIARY_BEAN().getPBEN_MICR_CODE());
			System.out.println("------>"+str.length());
			if(str.length() > 9 || str.length() < 9){
				throw new Exception("Enter valid MICR No.");
			}


			citycode=str.substring(0, 3);
			bankcode=str.substring(3, 6);
			branchcode=str.substring(6, 9);
			System.out.println(""+citycode);
			System.out.println(""+bankcode);
			System.out.println(""+branchcode);
			getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_CITY_CODE(citycode);
			getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_BANK_CODE(bankcode);
			getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_BRANCH_CODE(branchcode);
			getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_CITY_CODE_DESC(getCityDesc(citycode));
			getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_BANK_CODE_DESC(getBankDesc(bankcode));
			getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_BRANCH_CODE_DESC(getBranchDesc(branchcode, bankcode, citycode));

			COMP_UI_M_BANK_CODE.resetValue();
			COMP_UI_M_BANK_CODE_DESC.resetValue();
			COMP_UI_M_BRANCH_CODE.resetValue();
			COMP_UI_M_BRANCH_CODE_DESC.resetValue();
			
			/* change the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			/*COMP_UI_M_CITY_CODE.resetValue();
			COMP_UI_M_CITY_CODE_DESC.resetValue();*/
			/*end*/


		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void defaultMICRDetails() throws Exception{
		try{
			if(getPT_IL_POL_BENEFICIARY_BEAN().getPBEN_MICR_CODE() != null){
				String str= String.valueOf(getPT_IL_POL_BENEFICIARY_BEAN().getPBEN_MICR_CODE());
				if(str.length() == 9){ 
					citycode=str.substring(0, 3);
					bankcode=str.substring(3, 6);
					branchcode=str.substring(6, 9);
					getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_CITY_CODE(citycode);
					getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_BANK_CODE(bankcode);
					getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_BRANCH_CODE(branchcode);
					getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_CITY_CODE_DESC(getCityDesc(citycode));
					getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_BANK_CODE_DESC(getBankDesc(bankcode));
					getPT_IL_POL_BENEFICIARY_BEAN().setUI_M_BRANCH_CODE_DESC(getBranchDesc(branchcode, bankcode, citycode));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}



	public String getCityDesc(String cityCode) throws Exception{
		Connection connection = null;
		ResultSet resultSet =null;
		String desc = null;
		String query ="SELECT PMD_CITY_DESC  FROM PM_BANK_DTLS WHERE PMD_CITY_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{cityCode});
			if(resultSet.next()){
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}


	public String getBankDesc(String cityCode) throws Exception{
		Connection connection = null;
		ResultSet resultSet =null;
		String desc = null;
		String query ="SELECT PMD_BANK_NAME  FROM PM_BANK_DTLS WHERE PMD_BANK_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{cityCode});
			if(resultSet.next()){
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}

	public String getBranchDesc(String branchCode ,String bank ,String cityCode) throws Exception{
		Connection connection = null;
		ResultSet resultSet =null;
		String desc = null;
		String query ="SELECT PMD_BRANCH_NAME  FROM PM_BANK_DTLS WHERE PMD_BRANCH_CODE = ?  " +
				" AND PMD_BANK_CODE = ? AND PMD_CITY_CODE = ?  ";
		try {
			connection = CommonUtils.getConnection();
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{branchCode,bank,cityCode});
			if(resultSet.next()){
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return desc;
	}


	public void validatePBEN_ACNT_NO(ActionEvent actionEvent) {
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String)input.getSubmittedValue();		
		
		PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ACNT_NO(Long.valueOf(value));
		
		Connection connection = null;
		ResultSet resultset = null,resultSet1 = null;
		String branchCode = null;
		String query1 = "SELECT COVER_SA_CALC FROM PM_IL_COVER WHERE COVER_CODE= ?";

		try {
			
			connection = CommonUtils.getConnection();
			resultSet1 = new CRUDHandler().executeSelectStatement(query1, connection,new Object[]{PT_IL_POL_BENEFICIARY_BEAN.getPBEN_ACNT_NO()});
			if(resultSet1.next())
			{
				branchCode = resultSet1.getString("COVER_SA_CALC");
			}
			
			if(branchCode != null )
			{
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_DIVISION(branchCode);
				COMP_UI_M_BRANCH_CODE.resetValue();
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
		COMP_PBEN_ACNT_NO.resetValue();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void validatePBEN_ACNT_NO(FacesContext context ,UIComponent component,Object object){

		try {
			
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ACNT_NO((Long)object);


		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public HtmlOutputLabel getCOMP_PBEN_ACNT_NO_LABEL() {
		return COMP_PBEN_ACNT_NO_LABEL;
	}



	public void setCOMP_PBEN_ACNT_NO_LABEL(HtmlOutputLabel comp_pben_acnt_no_label) {
		COMP_PBEN_ACNT_NO_LABEL = comp_pben_acnt_no_label;
	}



	public HtmlInputText getCOMP_PBEN_ACNT_NO() {
		return COMP_PBEN_ACNT_NO;
	}



	public void setCOMP_PBEN_ACNT_NO(HtmlInputText comp_pben_acnt_no) {
		COMP_PBEN_ACNT_NO = comp_pben_acnt_no;
	}

	//[ADDED BY AKASH  TO IMPLEMENT DIRECT DEBIT /CREDIT.]	

	/*Added by Raja on 8/3/2016 for hide MICR field (Start)*/
	public void UI_M_CITY_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_CITY_CODE((String) value);



			helper.UI_M_CITY_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_BENEFICIARY_BEAN);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}



	public void UI_M_BANK_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BANK_CODE((String) value);

/*commented by raja on 22-05-2017 for hans on points*/

			/*helper.UI_M_BANK_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_BENEFICIARY_BEAN);*/
			
			/*end*/

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void validatePBEN_DIVISION(FacesContext context ,UIComponent component,Object 

			object){
		try{
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_DIVISION((String)object);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	/*add mathod for suggestion box:*/


	public ArrayList<LovBean> prepareSuggestionList_UI_M_CITY_CODE(Object object){
		System.out.println("i         am            suggestion         box");

		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_CITY_CODE";
		Object param1 = "CITY";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, 

					param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}




	public ArrayList<LovBean> prepareSuggestionList_UI_M_BANK_CODE(Object object){

		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_BANK_CODE";


		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,null, 

					null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	/*End*/	

	/*Added by Ram on 11/12/2016 for FALCONLIFE-1358413*/
	private HtmlInputText COMP_PBEN_GUAR_REL_CODE;

	public HtmlInputText getCOMP_PBEN_GUAR_REL_CODE() {
		return COMP_PBEN_GUAR_REL_CODE;
	}



	public void setCOMP_PBEN_GUAR_REL_CODE(HtmlInputText cOMP_PBEN_GUAR_REL_CODE) {
		COMP_PBEN_GUAR_REL_CODE = cOMP_PBEN_GUAR_REL_CODE;
	}

	public ArrayList<LovBean> prepareSuggestionList_PBEN_GUAR_REL_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_RELATION_CODE";
		Object param1 = "ILBENFREL";

		try {

			/*Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (Start)*/

			Object param2;
			String value=compositeAction.getPT_IL_POL_BENEFICIARY_ACTION_BEAN().getPT_IL_POL_BENEFICIARY_BEAN().getPBEN_BNF_TYPE();
			if(value.equals("A"))
				param2="2";			
			else
				param2="1";
			System.out.println("param2      "+param2);
			System.out.println("value      "+value);
			/*Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (End)*/

			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			/*lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
				null, null, null, currentValue);*/
			/*Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (Start)*/
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, param2,
					null, null, null, currentValue);
			/*Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (End)*/

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public void PBEN_GUAR_REL_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_GUAR_REL_DESC((String) value);

			helper.PBEN_GUAR_REL_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_BENEFICIARY_BEAN);

			COMP_UI_M_PBEN_RELATION_DESC.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*End*/
	/* Added by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

	public void validatePBEN_ADDRESS_2(FacesContext context,
			UIComponent component, Object value){

		try {
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_2((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatePBEN_ADDRESS_3(FacesContext context,
			UIComponent component, Object value){

		try {
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_ADDRESS_3((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public ArrayList<LovBean> lovASH_CITIZEN_CODE(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			/*Added by Raja on 13/04/2017*/
			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			System.out.println("benfField ====>>" +benfField);
			
			/*Modified by Janani on 15.05.2018 for fidelity as suggested by Ajay*/
			/*if(benfField == 1)*/
			if(benfField == 1 || benfField == 2)
			/*End*/
			{
			if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE()!=null && 
					(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("A") || 
							PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("S")))
			{
				if ("*".equals(code)) {
					object = new Object[] { PELConstants.suggetionRecordSize , PELConstants.suggetionRecordSize};
					query = PT_IL_POLICY_QUERY_CONSTANTS.BANK_REF_ID1_QUERY;
				} else {
					/*object = new Object[] { code + "%", code + "%",PELConstants.suggetionRecordSize ,
							code + "%", code + "%",	PELConstants.suggetionRecordSize };*/
					object = new Object[] { code + "%", code + "%",code + "%", code + "%", code + "%"};
					query = PT_IL_POLICY_QUERY_CONSTANTS.BANK_REF_ID1_QUERY_LIKE;
				}
			}
			else
			{
			/*End*/
				
				if ("*".equals(code)) {
					object = new Object[] { PELConstants.suggetionRecordSize };
					query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY;
				} else {
					object = new Object[] { code + "%", code + "%",
							PELConstants.suggetionRecordSize };
					query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY_LIKE;
				}
				
			}
			/*Added by Raja on 13/04/2017*/
			}
			else
			{
				if ("*".equals(code)) {
					object = new Object[] { PELConstants.suggetionRecordSize };
					query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY;
				} else {
					object = new Object[] { code + "%", code + "%",
							PELConstants.suggetionRecordSize };
					query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY_LIKE;
				}
			}
			/*End*/
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	private HtmlOutputLabel COMP_PBEN_DOB_LABEL;

	private HtmlCalendar COMP_PBEN_DOB;

	private HtmlOutputLabel COMP_PBEN_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_PBEN_EFF_FM_DT;

	private HtmlOutputLabel COMP_PBEN_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_PBEN_EFF_TO_DT;

	private HtmlInputText COMP_PBEN_BNF_CODE;

	public HtmlOutputLabel getCOMP_PBEN_DOB_LABEL() {
		return COMP_PBEN_DOB_LABEL;
	}



	public void setCOMP_PBEN_DOB_LABEL(HtmlOutputLabel cOMP_PBEN_DOB_LABEL) {
		COMP_PBEN_DOB_LABEL = cOMP_PBEN_DOB_LABEL;
	}



	public HtmlCalendar getCOMP_PBEN_DOB() {
		return COMP_PBEN_DOB;
	}



	public void setCOMP_PBEN_DOB(HtmlCalendar cOMP_PBEN_DOB) {
		COMP_PBEN_DOB = cOMP_PBEN_DOB;
	}



	public HtmlOutputLabel getCOMP_PBEN_EFF_FM_DT_LABEL() {
		return COMP_PBEN_EFF_FM_DT_LABEL;
	}



	public void setCOMP_PBEN_EFF_FM_DT_LABEL(
			HtmlOutputLabel cOMP_PBEN_EFF_FM_DT_LABEL) {
		COMP_PBEN_EFF_FM_DT_LABEL = cOMP_PBEN_EFF_FM_DT_LABEL;
	}



	public HtmlCalendar getCOMP_PBEN_EFF_FM_DT() {
		return COMP_PBEN_EFF_FM_DT;
	}



	public void setCOMP_PBEN_EFF_FM_DT(HtmlCalendar cOMP_PBEN_EFF_FM_DT) {
		COMP_PBEN_EFF_FM_DT = cOMP_PBEN_EFF_FM_DT;
	}



	public HtmlOutputLabel getCOMP_PBEN_EFF_TO_DT_LABEL() {
		return COMP_PBEN_EFF_TO_DT_LABEL;
	}



	public void setCOMP_PBEN_EFF_TO_DT_LABEL(
			HtmlOutputLabel cOMP_PBEN_EFF_TO_DT_LABEL) {
		COMP_PBEN_EFF_TO_DT_LABEL = cOMP_PBEN_EFF_TO_DT_LABEL;
	}



	public HtmlCalendar getCOMP_PBEN_EFF_TO_DT() {
		return COMP_PBEN_EFF_TO_DT;
	}



	public void setCOMP_PBEN_EFF_TO_DT(HtmlCalendar cOMP_PBEN_EFF_TO_DT) {
		COMP_PBEN_EFF_TO_DT = cOMP_PBEN_EFF_TO_DT;
	}



	public HtmlInputText getCOMP_PBEN_BNF_CODE() {
		return COMP_PBEN_BNF_CODE;
	}



	public void setCOMP_PBEN_BNF_CODE(HtmlInputText cOMP_PBEN_BNF_CODE) {
		COMP_PBEN_BNF_CODE = cOMP_PBEN_BNF_CODE;
	}



	/*End*/
	
	
	/* Added by R. Raja on 28-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/

	public void validatePBEN_EFF_FM_DT(FacesContext context,
			UIComponent component, Object value){

		try {
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX()!=null && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX()>0)
			{
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_EFF_FM_DT(new CommonUtils().getCurrentDate());
			}
			else
			{
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_EFF_FM_DT((Date) value);
			/*if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_EFF_FM_DT().before(
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_START_DT()))
			{
				throw new Exception("Beneficiary from date Effective should not be Lesser then Policy Start Date");
			}
			else if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_EFF_FM_DT().after(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_EFF_TO_DT()))
			{
				throw new Exception("Beneficiary Effective from date should not be greater then Policy End Date");
			}*/
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	

	public void validatePBEN_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value){

		try {
			PT_IL_POL_BENEFICIARY_BEAN.setPBEN_EFF_TO_DT((Date) value);
			if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_EFF_TO_DT().after(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_EXPIRY_DT()))
			{
				throw new Exception("Beneficiary Effective to date should not be greater then Policy End Date");
			}
			else if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_EFF_TO_DT().before(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_EFF_FM_DT()))
			{
				throw new Exception("Beneficiary Effective to date should not be Lesser then Policy Start Date");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*end*/
	/*Added by Ram on 26/01/2017 for BankCode dynamic Mandatory concept*/
	private HtmlGraphicImage  COMP_UI_M_BANK_CODE_SUG_IMG;
	private HtmlGraphicImage  COMP_UI_M_BRANCH_CODE_SUG_IMG;

	public HtmlGraphicImage getCOMP_UI_M_BANK_CODE_SUG_IMG() {
		return COMP_UI_M_BANK_CODE_SUG_IMG;
	}

	public void setCOMP_UI_M_BANK_CODE_SUG_IMG(
			HtmlGraphicImage cOMP_UI_M_BANK_CODE_SUG_IMG) {
		COMP_UI_M_BANK_CODE_SUG_IMG = cOMP_UI_M_BANK_CODE_SUG_IMG;
	}

	public HtmlGraphicImage getCOMP_UI_M_BRANCH_CODE_SUG_IMG() {
		return COMP_UI_M_BRANCH_CODE_SUG_IMG;
	}



	public void setCOMP_UI_M_BRANCH_CODE_SUG_IMG(
			HtmlGraphicImage cOMP_UI_M_BRANCH_CODE_SUG_IMG) {
		COMP_UI_M_BRANCH_CODE_SUG_IMG = cOMP_UI_M_BRANCH_CODE_SUG_IMG;
	}



	public void setBankCodeMandatory()
	{
		Connection conn = null;
		ResultSet rs = null;
		try
		{
			rs = new CRUDHandler().executeSelectStatement("SELECT * FROM PP_SYSTEM1 WHERE PS_TYPE = 'IL_BENF_MAND' AND PS_CODE = ?", CommonUtils.getConnection(),
					new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()});
			
			if(rs.next())
			{
				COMP_UI_M_BANK_CODE_SUG_IMG.setRendered(false);
				COMP_UI_M_BRANCH_CODE_SUG_IMG.setRendered(false);
				
				COMP_UI_M_BANK_CODE.setRequired(false);
				COMP_UI_M_BRANCH_CODE.setRequired(false);
			}
			else
			{
				COMP_UI_M_BANK_CODE_SUG_IMG.setRendered(true);
				COMP_UI_M_BRANCH_CODE_SUG_IMG.setRendered(true);
				
				COMP_UI_M_BANK_CODE.setRequired(true);
				COMP_UI_M_BRANCH_CODE.setRequired(true);
			}
			
		}
		catch(Exception e)
		{
			
		}
	}
	/*End*/
	//ADDED BY AMEEN ON 15-03-2017 AS PER VINOTH SUGG.

		private HtmlOutputLabel COMP_PBEN_EMAIL_LABEL;
		
		private HtmlInputText COMP_PBEN_EMAIL;

		public HtmlOutputLabel getCOMP_PBEN_EMAIL_LABEL() {
			return COMP_PBEN_EMAIL_LABEL;
		}

		public void setCOMP_PBEN_EMAIL_LABEL(HtmlOutputLabel cOMP_PBEN_EMAIL_LABEL) {
			COMP_PBEN_EMAIL_LABEL = cOMP_PBEN_EMAIL_LABEL;
		}

		public HtmlInputText getCOMP_PBEN_EMAIL() {
			return COMP_PBEN_EMAIL;
		}

		public void setCOMP_PBEN_EMAIL(HtmlInputText cOMP_PBEN_EMAIL) {
			COMP_PBEN_EMAIL = cOMP_PBEN_EMAIL;
		}
		
		public void validatorPBEN_EMAIL(FacesContext context,
				UIComponent component, Object value){

			try {
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_EMAIL((String) value);
				
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

		//End
		
		/*Added by Raja on 13/04/2017*/
		
		public void labelChanged()
		{
			try{
				
				int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
				System.out.println("benfField ====>>" +benfField);
				/*KIC condition handled by Ameen on 16-02-2018*/
				/*if(!"KIC".equalsIgnoreCase(CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")))
					{*/
				/*Modified by Janani on 15.05.2018 for fidelity as suggested by Ajay*/
				/*if(benfField == 1)*/
				if(benfField == 1 || benfField == 2)
				{
				/*End*/
						
						if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE()!=null && 
								(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("A") || 
										PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("S")))
								{
							COMP_PBEN_REF_ID1_LABEL.setValue("Identification Number");
							
								}
						else
						{
							/*
							 * modified by Ameen on 12-09-2017 for ZBILQC-1725637
							 * COMP_PBEN_REF_ID1_LABEL.setValue("Nation ID");*/
							COMP_PBEN_REF_ID1_LABEL.setValue("National ID");
						}
						}
						/*else if(benfField == 0){
							
							 * modified by Ameen on 12-09-2017 for ZBILQC-1725637
							 * COMP_PBEN_REF_ID1_LABEL.setValue("Nation ID");
							//COMP_PBEN_REF_ID1_LABEL.setValue("National ID");
							COMP_PBEN_REF_ID1_LABEL
						    .setValue(
							    Messages
								    .getString(
								    		CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE")+"messageProperties_PILT002_APAC",
									    "PILT002_APAC$PT_IL_POL_BENEFICIARY$PBEN_REF_ID1$caption")); // civil ID
							System.out.println("teeeeeest : " + COMP_PBEN_REF_ID1_LABEL.getValue());
						}*/
					/*}*/
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void disableField()
		{
			
			
			if(!(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("Y") 
					&& compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS().equalsIgnoreCase("A")))
			{
			if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE()!=null && (PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equals("A") || 
					PT_IL_POL_BENEFICIARY_BEAN.getPBEN_BNF_TYPE().equalsIgnoreCase("S"))){
				/* change the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				/*COMP_UI_M_CITY_CODE.setDisabled(false);*/
				/*end*/
				COMP_UI_M_BANK_CODE.setDisabled(false);
				COMP_UI_M_BRANCH_CODE.setDisabled(false);
			}
			else
			{
				/* Commentted by saranya for Avoidance of POST button required in all screens on 22-02-2017 */
				/*COMP_UI_M_CITY_CODE.setDisabled(true);*/
				/*End*/
				COMP_UI_M_BANK_CODE.setDisabled(true);
				COMP_UI_M_BRANCH_CODE.setDisabled(true);
			}
		}
		}
/*End*/
		
		/*Added by Ganesh on 27-10-2017 for ssp call id ZBLIFE-1437658*/
		public void validatePBEN_GUARDIAN_NAME(FacesContext context,
				UIComponent component, Object value){

			try {
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_GUARDIAN_NAME((String) value);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		/*End*/
		
		private HtmlInputText COMP_PBEN_REF_ID1_NEW;

		public HtmlInputText getCOMP_PBEN_REF_ID1_NEW() {
			return COMP_PBEN_REF_ID1_NEW;
		}

		public void setCOMP_PBEN_REF_ID1_NEW(HtmlInputText cOMP_PBEN_REF_ID1_NEW) {
			COMP_PBEN_REF_ID1_NEW = cOMP_PBEN_REF_ID1_NEW;
		}
		
		 /*Added by Ameen on 15-03-2018*/
		 public void validatorPBEN_BNF_NAME(FacesContext context,
					UIComponent component, Object value){

				try {
					PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BNF_NAME((String) value);
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}
			}
		/*End*/

		 
	    /*Added by Janani on 29.03.2018 for KIC*/ 
		private HtmlGraphicImage COMP_PBEN_REF_ID1_MAND;

		private HtmlGraphicImage COMP_PBEN_NAME_MAND;
		
		public HtmlGraphicImage getCOMP_PBEN_REF_ID1_MAND() {
			return COMP_PBEN_REF_ID1_MAND;
		}

		public HtmlGraphicImage getCOMP_PBEN_NAME_MAND() {
			return COMP_PBEN_NAME_MAND;
		}



		public void setCOMP_PBEN_NAME_MAND(HtmlGraphicImage cOMP_PBEN_NAME_MAND) {
			COMP_PBEN_NAME_MAND = cOMP_PBEN_NAME_MAND;
		}



		public void setCOMP_PBEN_REF_ID1_MAND(HtmlGraphicImage cOMP_PBEN_REF_ID1_MAND) {
			COMP_PBEN_REF_ID1_MAND = cOMP_PBEN_REF_ID1_MAND;
		}

	    /*End*/ 
		
		
		/*Added by saritha on 10-05-2018 for KIC Beneficiary Screen DOB field value reseting.*/
		
		public void validatorPBEN_DOB(FacesContext context,
				UIComponent component, Object value){

			try {
				
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_DOB((Date) value);
				/*  Newly  Added By Dhinesh on 01-06-2018*/
				ArrayList<OracleParameter> list2 = null;
				PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
				DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
				
				list2 = localProcedure.P_CALC_ANB(new CommonUtils().getCurrentDate(), PT_IL_POL_BENEFICIARY_BEAN.getPBEN_DOB(),
						dummyBean.getUI_M_PROD_AGE_CALC_FLAG(),PT_IL_POL_BENEFICIARY_BEAN.getPBEN_AGE());
				if (list2 != null && !list2.isEmpty()) {
					if (list2.get(0).getValueObject() != null) {
						PT_IL_POL_BENEFICIARY_BEAN.setPBEN_AGE((Integer)list2.get(0).getValueObject());
						COMP_PBEN_AGE.resetValue();
					}
				}
				
				/*  End */
				
				
				/*
				 * 
				 * 
				 * Commented By Dhinesh on 01-06-2018 
				 * 
				 * String CURSOR_C1 = "SELECT TRUNC(MONTHS_BETWEEN( ? , ? )/12) age FROM DUAL ";
				ResultSet resultSet = null;
				Connection connection = null;
				CRUDHandler handler = new CRUDHandler();
				connection = CommonUtils.getConnection();
				
				if(PT_IL_POL_BENEFICIARY_BEAN.getPBEN_DOB() != null )
				{
					
						resultSet = handler.executeSelectStatement(CURSOR_C1, connection,new Object[] {new CommonUtils().getCurrentDate(),PT_IL_POL_BENEFICIARY_BEAN.getPBEN_DOB() });
						while (resultSet.next()) {
							PT_IL_POL_BENEFICIARY_BEAN.setPBEN_AGE(resultSet.getInt("age"));					
						}
						
						COMP_PBEN_AGE.resetValue();

				}
				
				*
				*
				* End
				*
				*/
				
				
				if( PT_IL_POL_BENEFICIARY_BEAN.getPBEN_AGE() != 0 )
				{
					 helper.PBEN_AGE_WHEN_VALIDATE_ITEM(this);
				}
					
				
			
				

			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		/*End*/
		
		/*Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
		private HtmlOutputLabel COMP_PBEN_GUARDIAN_NATN_ID_LABEL;
		private HtmlInputText COMP_PBEN_GUARDIAN_NATN_ID;
		
		public HtmlOutputLabel getCOMP_PBEN_GUARDIAN_NATN_ID_LABEL() {
			return COMP_PBEN_GUARDIAN_NATN_ID_LABEL;
		}



		public void setCOMP_PBEN_GUARDIAN_NATN_ID_LABEL(
				HtmlOutputLabel cOMP_PBEN_GUARDIAN_NATN_ID_LABEL) {
			COMP_PBEN_GUARDIAN_NATN_ID_LABEL = cOMP_PBEN_GUARDIAN_NATN_ID_LABEL;
		}



		public HtmlInputText getCOMP_PBEN_GUARDIAN_NATN_ID() {
			return COMP_PBEN_GUARDIAN_NATN_ID;
		}



		public void setCOMP_PBEN_GUARDIAN_NATN_ID(
				HtmlInputText cOMP_PBEN_GUARDIAN_NATN_ID) {
			COMP_PBEN_GUARDIAN_NATN_ID = cOMP_PBEN_GUARDIAN_NATN_ID;
		}



		public void PBEN_GUARDIAN_NATN_ID_WHEN_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value){

			try {
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_GUARDIAN_NATN_ID((String) value);
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		/*End Newly added by pidugu raj dt: 16-09-2020 for Alliance IL*/
		private HtmlSelectOneMenu COMP_PBEN_GUARDIAN_NATN_ID_TYPE;
		private HtmlOutputLabel COMP_PBEN_GUARDIAN_NATN_ID_TYPE_LABEL;
		
		public HtmlOutputLabel getCOMP_PBEN_GUARDIAN_NATN_ID_TYPE_LABEL() {
			return COMP_PBEN_GUARDIAN_NATN_ID_TYPE_LABEL;
		}



		public void setCOMP_PBEN_GUARDIAN_NATN_ID_TYPE_LABEL(
				HtmlOutputLabel cOMP_PBEN_GUARDIAN_NATN_ID_TYPE_LABEL) {
			COMP_PBEN_GUARDIAN_NATN_ID_TYPE_LABEL = cOMP_PBEN_GUARDIAN_NATN_ID_TYPE_LABEL;
		}



		public HtmlSelectOneMenu getCOMP_PBEN_GUARDIAN_NATN_ID_TYPE() {
			return COMP_PBEN_GUARDIAN_NATN_ID_TYPE;
		}



		public void setCOMP_PBEN_GUARDIAN_NATN_ID_TYPE(
				HtmlSelectOneMenu cOMP_PBEN_GUARDIAN_NATN_ID_TYPE) {
			COMP_PBEN_GUARDIAN_NATN_ID_TYPE = cOMP_PBEN_GUARDIAN_NATN_ID_TYPE;
		}



		public void PBEN_GUARDIAN_NATN_ID_TYPE_WHEN_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) {
			try {
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_GUARDIAN_ID_TYPE((String) value);
				COMP_PBEN_GUARDIAN_NATN_ID_TYPE.resetValue();
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
		
		}
		}
		List<SelectItem> itemListGUARD_IC_TYPE = new ArrayList<SelectItem>();

		public List<SelectItem> getItemListGUARD_IC_TYPE() {
			return itemListGUARD_IC_TYPE;
		}

		public void setItemListGUARD_IC_TYPE(List<SelectItem> itemListGUARD_IC_TYPE) {
			this.itemListGUARD_IC_TYPE = itemListGUARD_IC_TYPE;
		}
		
		
		public void PBEN_BENF_ID_TYPE_WHEN_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) {
			try {
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_BENEF_ID_TYPE((String) value);
				COMP_PBEN_BENEF_ID_TYPE.resetValue();
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
		
		}
			
		}
		List<SelectItem> itemListBENF_IC_TYPE = new ArrayList<SelectItem>();

		public List<SelectItem> getItemListBENF_IC_TYPE() {
			return itemListBENF_IC_TYPE;
		}

		public void setItemListBENF_IC_TYPE(List<SelectItem> itemListBENF_IC_TYPE) {
			this.itemListBENF_IC_TYPE = itemListBENF_IC_TYPE;
		}
		private HtmlSelectOneMenu COMP_PBEN_BENEF_ID_TYPE;
		private HtmlOutputLabel COMP_PBEN_BENEF_ID_TYPE_LABEL;

		public HtmlSelectOneMenu getCOMP_PBEN_BENEF_ID_TYPE() {
			return COMP_PBEN_BENEF_ID_TYPE;
		}



		public void setCOMP_PBEN_BENEF_ID_TYPE(HtmlSelectOneMenu cOMP_PBEN_BENEF_ID_TYPE) {
			COMP_PBEN_BENEF_ID_TYPE = cOMP_PBEN_BENEF_ID_TYPE;
		}



		public HtmlOutputLabel getCOMP_PBEN_BENEF_ID_TYPE_LABEL() {
			return COMP_PBEN_BENEF_ID_TYPE_LABEL;
		}



		public void setCOMP_PBEN_BENEF_ID_TYPE_LABEL(
				HtmlOutputLabel cOMP_PBEN_BENEF_ID_TYPE_LABEL) {
			COMP_PBEN_BENEF_ID_TYPE_LABEL = cOMP_PBEN_BENEF_ID_TYPE_LABEL;
		}
		
		/*End*/
		/*Newly added by pdiugu raj dt: 28-09-2020 for Beneficiary Mobile Number in Alliance IL*/
		private HtmlOutputLabel COMP_PBEN_MOBILE_NUMBER_LABEL;
		private HtmlInputText COMP_PBEN_MOBILE_NO;
		private HtmlInputText COMP_PBEN_AREA_CODE;

		public HtmlOutputLabel getCOMP_PBEN_MOBILE_NUMBER_LABEL() {
			return COMP_PBEN_MOBILE_NUMBER_LABEL;
		}



		public void setCOMP_PBEN_MOBILE_NUMBER_LABEL(
				HtmlOutputLabel cOMP_PBEN_MOBILE_NUMBER_LABEL) {
			COMP_PBEN_MOBILE_NUMBER_LABEL = cOMP_PBEN_MOBILE_NUMBER_LABEL;
		}



		public HtmlInputText getCOMP_PBEN_MOBILE_NO() {
			return COMP_PBEN_MOBILE_NO;
		}



		public void setCOMP_PBEN_MOBILE_NO(HtmlInputText cOMP_PBEN_MOBILE_NO) {
			COMP_PBEN_MOBILE_NO = cOMP_PBEN_MOBILE_NO;
		}



		public HtmlInputText getCOMP_PBEN_AREA_CODE() {
			return COMP_PBEN_AREA_CODE;
		}



		public void setCOMP_PBEN_AREA_CODE(HtmlInputText cOMP_PBEN_AREA_CODE) {
			COMP_PBEN_AREA_CODE = cOMP_PBEN_AREA_CODE;
		}
		
		public void COMP_PBEN_AREA_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) {
			try {
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_AREA_CODE((String) value);
				COMP_PBEN_AREA_CODE.resetValue();
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
		
		}
			
		}
		
		public void COMP_PBEN_MOBILE_NO_WHEN_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) {
			try {
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_MOBILE_NO((int) value);
				COMP_PBEN_MOBILE_NO.resetValue();
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
		
		}
			
		}
		
		/*Newly added by pidugu raj dt: 06-10-2020 for Alliance IL*/
		private HtmlOutputLabel COMP_PBEN_REL_OTHER_LABEL;
		private HtmlInputText COMP_PBEN_REL_OTHER;

		public HtmlOutputLabel getCOMP_PBEN_REL_OTHER_LABEL() {
			return COMP_PBEN_REL_OTHER_LABEL;
		}



		public void setCOMP_PBEN_REL_OTHER_LABEL(
				HtmlOutputLabel cOMP_PBEN_REL_OTHER_LABEL) {
			COMP_PBEN_REL_OTHER_LABEL = cOMP_PBEN_REL_OTHER_LABEL;
		}



		public HtmlInputText getCOMP_PBEN_REL_OTHER() {
			return COMP_PBEN_REL_OTHER;
		}



		public void setCOMP_PBEN_REL_OTHER(HtmlInputText cOMP_PBEN_REL_OTHER) {
			COMP_PBEN_REL_OTHER = cOMP_PBEN_REL_OTHER;
		}
		
		public void COMP_PBEN_REL_OTHER_WHEN_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) {
			try {
				PT_IL_POL_BENEFICIARY_BEAN.setPBEN_REL_OTHER((String) value);
				COMP_PBEN_REL_OTHER.resetValue();
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
		
		}
			
		}
		
		
}
