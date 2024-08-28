package com.iii.pel.forms.PILT002_APAC;

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
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.fileupload.PM_IL_IMAGES;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_MED_EXAM_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PMED_EXAM_CODE_LABEL;

	private HtmlInputText COMP_PMED_EXAM_CODE;

	private HtmlOutputLabel COMP_PMED_CLINIC_CODE_LABEL;

	private HtmlInputText COMP_PMED_CLINIC_CODE;

	private HtmlOutputLabel COMP_UI_M_CLINIC_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CLINIC_CODE_DESC;

	private HtmlOutputLabel COMP_PMED_PVT_LC_AMT_LABEL;

	private HtmlInputText COMP_PMED_PVT_LC_AMT;

	private HtmlOutputLabel COMP_PMED_GOVT_LC_AMT_LABEL;

	private HtmlInputText COMP_PMED_GOVT_LC_AMT;

	private HtmlOutputLabel COMP_PMED_STATUS_LABEL;

	private HtmlSelectOneMenu COMP_PMED_STATUS;

	private HtmlOutputLabel COMP_PMED_REP_REC_DT_LABEL;

	private HtmlCalendar COMP_PMED_REP_REC_DT;

	private HtmlOutputLabel COMP_UI_M_SUM_PVT_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_SUM_PVT_LC_AMT;

	private HtmlOutputLabel COMP_PMED_DEL_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PMED_DEL_FLAG;

	private HtmlOutputLabel COMP_UI_M_SUM_GOVT_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_SUM_GOVT_LC_AMT;

	private HtmlOutputLabel COMP_UI_M_MED_EXAM_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MED_EXAM_CODE_DESC;
	
	//added by saranya 
		private HtmlOutputLabel COMP_PMED_MED_DESC_LABLE;
		
		private HtmlInputTextarea COMP_PMED_MED_DESC;

		public HtmlOutputLabel getCOMP_PMED_MED_DESC_LABLE() {
			return COMP_PMED_MED_DESC_LABLE;
		}

		public void setCOMP_PMED_MED_DESC_LABLE(HtmlOutputLabel cOMP_PMED_MED_DESC_LABLE) {
			COMP_PMED_MED_DESC_LABLE = cOMP_PMED_MED_DESC_LABLE;
		}
		public HtmlInputTextarea getCOMP_PMED_MED_DESC() {
			return COMP_PMED_MED_DESC;
		}

		public void setCOMP_PMED_MED_DESC(HtmlInputTextarea cOMP_PMED_MED_DESC) {
			COMP_PMED_MED_DESC = cOMP_PMED_MED_DESC;
		}

		//end
		
		
		

	private PT_IL_POL_MED_EXAM_DTL PT_IL_POL_MED_EXAM_DTL_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_MED_EXAM_DTL_HELPER helper;

	private List<PT_IL_POL_MED_EXAM_DTL> dataList_PT_IL_POL_MED_EXAM_DTL = new ArrayList<PT_IL_POL_MED_EXAM_DTL>();

	private UIData dataTable;

	private List<SelectItem> listPMED_STATUS = new ArrayList<SelectItem>();

	public PT_IL_POL_MED_EXAM_DTL_ACTION() {

		PT_IL_POL_MED_EXAM_DTL_BEAN = new PT_IL_POL_MED_EXAM_DTL();
		helper = new PT_IL_POL_MED_EXAM_DTL_HELPER();
		instantiateAllComponent();
		preparDropDownList();
	}

	public void preparDropDownList() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			
			/*Enabled the below code by ganesh on 20-03-2017, to display status yes or no in payor medical.
			 * 
			 *  Commented by Ram on 23/03/2017 as per Girish suggestion*/
			/*listPMED_STATUS = ListItemUtil.getDropDownListValue(connection,
					"PILT002_APAC", "PT_IL_POL_MED_EXAM_DTL",
					"PT_IL_POL_MED_EXAM_DTL.PMED_STATUS", "YESNO");*/
			
			/*Below coding commented by ganesh on 20-03-2017, to solve empty list in status dropdown in payor medical*/
			/*Added by saritha on 01-Mar-2017 for Drop Down List add Waived*/
			listPMED_STATUS = ListItemUtil.getDropDownListValue(connection,
					"PILT002_APAC", "PT_IL_POL_MED_EXAM_DTL",
					"PT_IL_POL_MED_EXAM_DTL.PMED_STATUS", "CHKLST_STS");
			
			/*End*/
		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}

	}

	public PT_IL_POL_MED_EXAM_DTL getPT_IL_POL_MED_EXAM_DTL_BEAN() {
		return PT_IL_POL_MED_EXAM_DTL_BEAN;
	}

	public void setPT_IL_POL_MED_EXAM_DTL_BEAN(
			PT_IL_POL_MED_EXAM_DTL PT_IL_POL_MED_EXAM_DTL_BEAN) {
		this.PT_IL_POL_MED_EXAM_DTL_BEAN = PT_IL_POL_MED_EXAM_DTL_BEAN;
	}

	public List<PT_IL_POL_MED_EXAM_DTL> getDataList_PT_IL_POL_MED_EXAM_DTL() {
		return dataList_PT_IL_POL_MED_EXAM_DTL;
	}

	public void setDataListPT_IL_POL_MED_EXAM_DTL(
			List<PT_IL_POL_MED_EXAM_DTL> dataList_PT_IL_POL_MED_EXAM_DTL) {
		this.dataList_PT_IL_POL_MED_EXAM_DTL = dataList_PT_IL_POL_MED_EXAM_DTL;
	}

	public void addRow(ActionEvent event) {
		String message = null;
		try {
			System.out.println("inside addRow");
			getErrorMap().clear();
			getWarningMap().clear();
			
			
			if (isINSERT_ALLOWED()) {
				
				/*added by raja on 25-04-2017*/
				int shareRatioSystemParam =0;
				
				/*int shareRatioSystemParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("MED_EXAM_INS")).intValue();
				if(shareRatioSystemParam == 2){*/
				String query="select ps_value from pp_system where ps_code='MED_EXAM_INS'";
				ResultSet rs =new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
				while(rs.next())
				{
					shareRatioSystemParam=rs.getInt("ps_value");
				}
				if(shareRatioSystemParam == 2){
				helper.accessValidation(getPT_IL_POL_MED_EXAM_DTL_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN());
				}
				/*end*/
				
				
				
				PT_IL_POL_MED_EXAM_DTL_BEAN = new PT_IL_POL_MED_EXAM_DTL();
				helper.whenCreateRecord(getPT_IL_POL_MED_EXAM_DTL_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN());
				resetAllComponent();
				/*Modiifed by Ram on 01/01/2017 for Clear component values
				 * 
				 * resetSelectedRow();*/
				resetRowAtCreate();
				PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
				PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
				/*End*/
				
				disableAllComponent(false);
			} else {
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed");
				getErrorMap().put("addRow", message);

				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	/*Added by Ram on 01/01/2017 for Clear component values*/
    private void resetRowAtCreate() {
    	Iterator<PT_IL_POL_MED_EXAM_DTL> PT_IL_POL_MED_EXAM_DTL_ITR = dataList_PT_IL_POL_MED_EXAM_DTL
				.iterator();
		while (PT_IL_POL_MED_EXAM_DTL_ITR.hasNext()) {
			PT_IL_POL_MED_EXAM_DTL_ITR.next().setRowSelected(false);;
			
		}
	}
    /*End*/
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				helper.keyDelRec(this, compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN());
				new CRUDHandler().executeDelete(PT_IL_POL_MED_EXAM_DTL_BEAN,
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
				dataList_PT_IL_POL_MED_EXAM_DTL
						.remove(PT_IL_POL_MED_EXAM_DTL_BEAN);
				if (dataList_PT_IL_POL_MED_EXAM_DTL.size() > 0) {

					PT_IL_POL_MED_EXAM_DTL_BEAN = dataList_PT_IL_POL_MED_EXAM_DTL
							.get(0);
				} else if (dataList_PT_IL_POL_MED_EXAM_DTL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_MED_EXAM_DTL_BEAN.setRowSelected(true);
				/*Added by saritha on 25-May-2017 for ssp call id ZBILQC-1725269*/
				CommonUtils.getConnection().commit();
				/*End*/
				
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

	public void postRecord(ActionEvent event) {
		String message = null;
		/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_021-Reinstatement Quotation V 1*/
		CommonUtils.clearMaps(this);
		/*End*/
		try {
			System.out.println("Enter into POST BUTTON");
			/*String status=getPT_IL_POL_MED_EXAM_DTL_BEAN().getPMED_STATUS();
			String Clinic_code=getPT_IL_POL_MED_EXAM_DTL_BEAN().getPMED_CLINIC_CODE();
			System.out.println("the clinic code value is:   "+Clinic_code);*/
			/*
			 * modif
			 * if(!CommonUtils.nvl(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_CLINIC_CODE(), "temp").equals("temp"))*/
			if(!CommonUtils.nvl(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_CLINIC_CODE(), "temp").equals("temp") || "NA".equalsIgnoreCase(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_STATUS()))
			{
				/*Condition handled by Ameen on 07-06-2017 for ZBILQC-1726894*/
				if(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_REP_REC_DT() != null && 
						PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_REP_REC_DT().after(new CommonUtils().getCurrentDate())){
					System.out.println("Enter into date checking condition");
					String message1="Date Should not exceed current date";
					getErrorMap().put("current", message1);
				}else{
					
			/*
			 * 
			 * commented by dhinesh on 1-06-2017 call id ZBILQC-1726894
			 * 
			 * helper.PMED_STATUS_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN());*/
			
			if (PT_IL_POL_MED_EXAM_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(getPT_IL_POL_MED_EXAM_DTL_BEAN(),
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN());

				
				/*added by raja on 25-04-2017*/
				double param=0.0;
				/*int shareRatioSystemParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("MED_EXAM_INS")).intValue();
				if(shareRatioSystemParam == 2){*/
				String query="select ps_value from pp_system where ps_code='MED_EXAM_INS'";
				ResultSet rs =new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
				while(rs.next())
				{
					param=rs.getInt("ps_value");
				}
				if(param == 2){
				helper.accessValidation(getPT_IL_POL_MED_EXAM_DTL_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN());
				}
				
				/*end*/
				
				/*Added by saritha on 25-May-2017 for ssp call id ZBILQC-1725269*/
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_FLEX_02("N");			
				/*End*/	
				/*Added by Ameen on 15-12-2017 for ZBLIFE-1461947/automated email triggering for manual med. creation*/
				PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_FLEX_05("N");			
				/*End*/
				/*added by raja on 10-07-2017 for ZBILQC-1731018*/ 
				
				LIFELIB lifelib = new LIFELIB();
				 lifelib.P_VAL_CUST(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_CLINIC_CODE(),
						 PT_IL_POL_MED_EXAM_DTL_BEAN.getUI_M_CLINIC_CODE_DESC(), "N", "N",
						 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());
				 
				/*end*/
				
				new CRUDHandler().executeInsert(PT_IL_POL_MED_EXAM_DTL_BEAN,
						CommonUtils.getConnection());
				
				
				/*Added by Janani on 19.02.2018 for making medical fee as 0 if status is waived,as suggested by Gaurav*/
				
				System.out.println("getPOL_SYS_ID  in insert             "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
				System.out.println("getPMED_EXAM_CODE               "+PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_EXAM_CODE());
				System.out.println("getPMED_STATUS               "+PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_STATUS());
				
				
					new P9ILPK_POLICY().P_UPD_MED_AMT(
							compositeAction.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
									PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_EXAM_CODE(),
									PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_STATUS());				
				
				
					
				/*End*/
				
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

				getWarningMap().put("postRecord", message);
				
				
				/*Newly added by pidugu raj dt: 01-11-2018 as per sivaraman and vijay suggestion*/
				
				new PT_IL_POL_MED_EXAM_DTL_DELEGATE()
				.executeSelectStatement(compositeAction,compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_SYS_ID(),
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_SYS_ID());
				
				
				
				for(PT_IL_POL_MED_EXAM_DTL pt_il_pol_med_exm_dtl:compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().getDataList_PT_IL_POL_MED_EXAM_DTL()){
					if(pt_il_pol_med_exm_dtl.getPMED_EXAM_CODE().equalsIgnoreCase(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_EXAM_CODE())){
						PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_PVT_LC_AMT(pt_il_pol_med_exm_dtl.getPMED_PVT_LC_AMT());
						PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_GOVT_LC_AMT(pt_il_pol_med_exm_dtl.getPMED_GOVT_LC_AMT());
					}
				}
				
				/*End Newly added by pidugu raj dt: 01-11-2018 as per sivaraman and vijay suggestion*/
				
				dataList_PT_IL_POL_MED_EXAM_DTL
						.add(PT_IL_POL_MED_EXAM_DTL_BEAN);
			} else if (PT_IL_POL_MED_EXAM_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				
				/*added by raja on 10-07-2017 for ZBILQC-1731018*/ 
				
				LIFELIB lifelib = new LIFELIB();
				 lifelib.P_VAL_CUST(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_CLINIC_CODE(),
						 PT_IL_POL_MED_EXAM_DTL_BEAN.getUI_M_CLINIC_CODE_DESC(), "N", "N",
						 compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE());
				 
				 
				/*end*/
				/*Added by Ram on 31/03/2017 for Update All Functionality*/
				if(PT_IL_POL_MED_EXAM_DTL_BEAN.isUPDATE_ALL())
				{
					/*
					 * COMMENTED BY DHINESH ON 19-06-2017 FOR SSP CALL ID 
					 * 
					 * CommonUtils.updateAllRecords(dataList_PT_IL_POL_MED_EXAM_DTL, PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(), PT_IL_POL_MED_EXAM_DTL_BEAN.getEndindex());*/
					
					CommonUtils.updateAllRecords(dataList_PT_IL_POL_MED_EXAM_DTL, PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(), dataList_PT_IL_POL_MED_EXAM_DTL.size());
				}
				else
				{
				/*End*/
					
					
				helper.preUpdate(getPT_IL_POL_MED_EXAM_DTL_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_MED_EXAM_DTL_BEAN,
						CommonUtils.getConnection());
				}
				
				 /*Added by Janani on 19.02.2018 for making medical fee as 0 if status is waived,as suggested by Gaurav*/

				System.out.println("getPOL_SYS_ID  in update             "+compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
				System.out.println("getPMED_EXAM_CODE               "+PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_EXAM_CODE());
				System.out.println("getPMED_STATUS               "+PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_STATUS());
				
				new P9ILPK_POLICY().P_UPD_MED_AMT(
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
						PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_EXAM_CODE(),
						PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_STATUS());	
				//resetSelectedRow();
				System.out.println("getRowIndex in save                "+getRow_index());
				
				helper.executeQuery_1(compositeAction,getRow_index());
								
				PT_IL_POL_MED_EXAM_DTL_BEAN.setRowSelected(true);
				
				COMP_PMED_PVT_LC_AMT.resetValue();
				COMP_PMED_GOVT_LC_AMT.resetValue();
				/*End*/
				
				
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

				/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_021-Reinstatement Quotation V 1*/
				/*getWarningMap().put("postRecord", message);*/
				/*End*/

			}
			
			PT_IL_POL_MED_EXAM_DTL_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
			}
			}
			else
			{
				System.out.println("Enter the post condition");
				String message1="Enter the clinic code";
				getErrorMap().put("current", message1);
			}
			/*Added by saritha on 09-Dec-2016 for RM018T - DEV_IL_ZB Life_021-Reinstatement Quotation V 1*/
			
			String POL_STATUS=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS();
			if(POL_STATUS.equalsIgnoreCase("R"))
			{
				System.out.println("Policy Status:::::::::::::::::::::"+POL_STATUS);
				compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Medical examination has been updated");
			}
			/*Added by saritha on 04-Mar-2017 RM018T - DEV_IL_ZB Life_012b_Claim waiting period*/	
			/*Commentted by saritha on 24-May-2017 for ZBILQC-1725269*/
			/*medical_check();*/
			/*
			 * Commented by sankara narayanan on 07/04/2017
			 * 	new CRUDHandler().executeUpdate(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(), CommonUtils.getConnection());*/
				/*End*/
			/*End*/
			
			/*End*/
			
			/*added by Ameen on 28-03-2018 for KIC as per Vaithi sugg.*/
			String autoUW = "N";
			ResultSet rs = new CRUDHandler().executeSelectStatement("SELECT PROD_AUTO_UW FROM PM_IL_PRODUCT A WHERE PROD_CODE = ?", CommonUtils.getConnection(),
												new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE()});
			if(rs.next()){
				autoUW = rs.getString("PROD_AUTO_UW");
			}
			if("Y".equalsIgnoreCase(autoUW)){
				
				/*String medQry="SELECT 'X' FROM PT_IL_POL_MED_EXAM_DTL WHERE  PMED_POL_SYS_ID = ? AND PMED_STATUS ='N'";*/
				/*String medQry="SELECT 'X' FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ? AND PMED_STATUS = 'N'";
				String medStatus="";
				int updateStatus=0;
				
				ResultSet medRS= new CRUDHandler().executeSelectStatement(medQry, CommonUtils.getConnection(), 
											new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				if(medRS.next()){
					medStatus = medRS.getString("X");
				}
				
				String checklistQry="SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_POL_SYS_ID = ? AND DTLS_MANDATORY_YN = 'Y' AND DTLS_APPR_STS = 'N'";
				String checklistStatus="";
				
				ResultSet checklistRS = new CRUDHandler().executeSelectStatement(checklistQry, CommonUtils.getConnection(), 
												new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				if(checklistRS.next()){
					checklistStatus = checklistRS.getString("X");
				}*/
				
				String mergeQry = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_POL_SYS_ID = ? AND DTLS_MANDATORY_YN = 'Y' AND DTLS_APPR_STS = 'N' "
						+ "UNION SELECT 'X' FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ? AND PMED_STATUS = 'N'";
				String mergeStatus = "";
				int updateStatus=0;
				ResultSet mergeRS = new CRUDHandler().executeSelectStatement(mergeQry, CommonUtils.getConnection(),
							new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
										compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				
				/*if("X".equalsIgnoreCase(medStatus) && "X".equalsIgnoreCase(checklistStatus)){
					updateStatus = new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = '004' WHERE POL_SYS_ID = ?", 
							CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				}else */if(mergeRS.next()){
					updateStatus = new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POLICY  SET POL_ADDL_STATUS = '004' WHERE POL_SYS_ID = ?", 
							CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
					
				}else{
					updateStatus = new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POLICY SET POL_ADDL_STATUS = '001' WHERE POL_SYS_ID = ? ", 
							CommonUtils.getConnection(),new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				}
				
				if(updateStatus>0){
					CommonUtils.getConnection().commit();
					System.out.println("POL_ADDL_STATUS UPDATED SUCCESSFULLY in assured medical >>>>>>>>>>>>>>>");
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
					//compositeAction.getPT_IL_POLICY_ACTION_BEAN().onLoad(null);
				}
				
			}
			/*End*/
			
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
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
			/*Added by Janani on 19.02.2018 for making medical fee as 0 if status is waived,as suggested by Gaurav*/
			setRow_index(dataTable.getRowIndex());
			
			System.out.println("getRowIndex                  "+dataTable.getRowIndex()+"        getRowData       "+getRow_index());
			/*End*/
			PT_IL_POL_MED_EXAM_DTL_BEAN = (PT_IL_POL_MED_EXAM_DTL) dataTable
					.getRowData();
			helper.postQuery(this, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
			helper.whenNewRecordInstance(this,compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
			PT_IL_POL_MED_EXAM_DTL_BEAN.setRowSelected(true);
			/*Added by Ram on 16/12/2016 for Policy freeze fields scenario*/
			enableFields();
			/*End*/
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
/*Added by Ram on 16/12/2016 for Policy freeze fields scenario*/
	private void enableFields()
	{
		if(PT_IL_POL_MED_EXAM_DTL_BEAN.getRowSelected() != null && PT_IL_POL_MED_EXAM_DTL_BEAN.getRowSelected().equals("dataTableSelectedRow"))
		{
			System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getRowSelected()      "+PT_IL_POL_MED_EXAM_DTL_BEAN.getRowSelected()+" "+
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()+"     "+
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()+"     "+
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
			if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("Y")))
			{
				PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
				PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
			}
			else
			{
				PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");
				PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
			}
		}
	}
	/*End*/
	public void resetSelectedRow() {
		Iterator<PT_IL_POL_MED_EXAM_DTL> PT_IL_POL_MED_EXAM_DTL_ITR = dataList_PT_IL_POL_MED_EXAM_DTL
				.iterator();
		while (PT_IL_POL_MED_EXAM_DTL_ITR.hasNext()) {
			/*Modified by Ram on 16/12/2016 for Policyfreeze scenario
			 * 
			 * PT_IL_POL_MED_EXAM_DTL_ITR.next().setRowSelected(false);*/
			
			PT_IL_POL_MED_EXAM_DTL_BEAN = PT_IL_POL_MED_EXAM_DTL_ITR.next();
			PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
			PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
			PT_IL_POL_MED_EXAM_DTL_BEAN.setRowSelected(false);
			/*End*/
		}
	}

	private void resetAllComponent() {
		COMP_PMED_EXAM_CODE.resetValue();
		COMP_PMED_CLINIC_CODE.resetValue();
		//COMP_UI_M_CLINIC_CODE_DESC.resetValue();
		COMP_PMED_PVT_LC_AMT.resetValue();
		COMP_PMED_GOVT_LC_AMT.resetValue();
		COMP_PMED_STATUS.resetValue();
		COMP_PMED_REP_REC_DT.resetValue();
		COMP_UI_M_SUM_PVT_LC_AMT.resetValue();
		COMP_UI_M_SUM_GOVT_LC_AMT.resetValue();
		COMP_UI_M_MED_EXAM_CODE_DESC.resetValue();
		COMP_PMED_MED_DESC.resetValue();
		/* Added by ganesh on 16-05-2017 for medica examination remarks field */
		
		COMP_PMED_REMARKS.resetValue();
		/*end*/
		
		/*Added by Ameen on 08-03-2018 for KICLIFEQC-1746096*/
		COMP_PMED_EXM_DN_DT.resetValue();
		/*end*/		
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PMED_EXAM_CODE_LABEL() {
		return COMP_PMED_EXAM_CODE_LABEL;
	}

	public void setCOMP_PMED_EXAM_CODE_LABEL(
			HtmlOutputLabel comp_pmed_exam_code_label) {
		COMP_PMED_EXAM_CODE_LABEL = comp_pmed_exam_code_label;
	}

	public HtmlInputText getCOMP_PMED_EXAM_CODE() {
		return COMP_PMED_EXAM_CODE;
	}

	public void setCOMP_PMED_EXAM_CODE(HtmlInputText comp_pmed_exam_code) {
		COMP_PMED_EXAM_CODE = comp_pmed_exam_code;
	}

	public HtmlOutputLabel getCOMP_PMED_CLINIC_CODE_LABEL() {
		return COMP_PMED_CLINIC_CODE_LABEL;
	}

	public void setCOMP_PMED_CLINIC_CODE_LABEL(
			HtmlOutputLabel comp_pmed_clinic_code_label) {
		COMP_PMED_CLINIC_CODE_LABEL = comp_pmed_clinic_code_label;
	}

	public HtmlInputText getCOMP_PMED_CLINIC_CODE() {
		return COMP_PMED_CLINIC_CODE;
	}

	public void setCOMP_PMED_CLINIC_CODE(HtmlInputText comp_pmed_clinic_code) {
		COMP_PMED_CLINIC_CODE = comp_pmed_clinic_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLINIC_CODE_DESC_LABEL() {
		return COMP_UI_M_CLINIC_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CLINIC_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_clinic_code_desc_label) {
		COMP_UI_M_CLINIC_CODE_DESC_LABEL = comp_ui_m_clinic_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_CLINIC_CODE_DESC() {
		return COMP_UI_M_CLINIC_CODE_DESC;
	}

	public void setCOMP_UI_M_CLINIC_CODE_DESC(
			HtmlInputText comp_ui_m_clinic_code_desc) {
		COMP_UI_M_CLINIC_CODE_DESC = comp_ui_m_clinic_code_desc;
	}

	public HtmlOutputLabel getCOMP_PMED_PVT_LC_AMT_LABEL() {
		return COMP_PMED_PVT_LC_AMT_LABEL;
	}

	public void setCOMP_PMED_PVT_LC_AMT_LABEL(
			HtmlOutputLabel comp_pmed_pvt_lc_amt_label) {
		COMP_PMED_PVT_LC_AMT_LABEL = comp_pmed_pvt_lc_amt_label;
	}

	public HtmlInputText getCOMP_PMED_PVT_LC_AMT() {
		return COMP_PMED_PVT_LC_AMT;
	}

	public void setCOMP_PMED_PVT_LC_AMT(HtmlInputText comp_pmed_pvt_lc_amt) {
		COMP_PMED_PVT_LC_AMT = comp_pmed_pvt_lc_amt;
	}

	public HtmlOutputLabel getCOMP_PMED_GOVT_LC_AMT_LABEL() {
		return COMP_PMED_GOVT_LC_AMT_LABEL;
	}

	public void setCOMP_PMED_GOVT_LC_AMT_LABEL(
			HtmlOutputLabel comp_pmed_govt_lc_amt_label) {
		COMP_PMED_GOVT_LC_AMT_LABEL = comp_pmed_govt_lc_amt_label;
	}

	public HtmlInputText getCOMP_PMED_GOVT_LC_AMT() {
		return COMP_PMED_GOVT_LC_AMT;
	}

	public void setCOMP_PMED_GOVT_LC_AMT(HtmlInputText comp_pmed_govt_lc_amt) {
		COMP_PMED_GOVT_LC_AMT = comp_pmed_govt_lc_amt;
	}

	public HtmlOutputLabel getCOMP_PMED_STATUS_LABEL() {
		return COMP_PMED_STATUS_LABEL;
	}

	public void setCOMP_PMED_STATUS_LABEL(HtmlOutputLabel comp_pmed_status_label) {
		COMP_PMED_STATUS_LABEL = comp_pmed_status_label;
	}

	public HtmlSelectOneMenu getCOMP_PMED_STATUS() {
		return COMP_PMED_STATUS;
	}

	public void setCOMP_PMED_STATUS(HtmlSelectOneMenu comp_pmed_status) {
		COMP_PMED_STATUS = comp_pmed_status;
	}

	public HtmlOutputLabel getCOMP_PMED_REP_REC_DT_LABEL() {
		return COMP_PMED_REP_REC_DT_LABEL;
	}

	public void setCOMP_PMED_REP_REC_DT_LABEL(
			HtmlOutputLabel comp_pmed_rep_rec_dt_label) {
		COMP_PMED_REP_REC_DT_LABEL = comp_pmed_rep_rec_dt_label;
	}

	public HtmlCalendar getCOMP_PMED_REP_REC_DT() {
		return COMP_PMED_REP_REC_DT;
	}

	public void setCOMP_PMED_REP_REC_DT(HtmlCalendar comp_pmed_rep_rec_dt) {
		COMP_PMED_REP_REC_DT = comp_pmed_rep_rec_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_PVT_LC_AMT_LABEL() {
		return COMP_UI_M_SUM_PVT_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_SUM_PVT_LC_AMT_LABEL(
			HtmlOutputLabel comp_ui_m_sum_pvt_lc_amt_label) {
		COMP_UI_M_SUM_PVT_LC_AMT_LABEL = comp_ui_m_sum_pvt_lc_amt_label;
	}

	public HtmlInputText getCOMP_UI_M_SUM_PVT_LC_AMT() {
		return COMP_UI_M_SUM_PVT_LC_AMT;
	}

	public void setCOMP_UI_M_SUM_PVT_LC_AMT(
			HtmlInputText comp_ui_m_sum_pvt_lc_amt) {
		COMP_UI_M_SUM_PVT_LC_AMT = comp_ui_m_sum_pvt_lc_amt;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_GOVT_LC_AMT_LABEL() {
		return COMP_UI_M_SUM_GOVT_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_SUM_GOVT_LC_AMT_LABEL(
			HtmlOutputLabel comp_ui_m_sum_govt_lc_amt_label) {
		COMP_UI_M_SUM_GOVT_LC_AMT_LABEL = comp_ui_m_sum_govt_lc_amt_label;
	}

	public HtmlInputText getCOMP_UI_M_SUM_GOVT_LC_AMT() {
		return COMP_UI_M_SUM_GOVT_LC_AMT;
	}

	public void setCOMP_UI_M_SUM_GOVT_LC_AMT(
			HtmlInputText comp_ui_m_sum_govt_lc_amt) {
		COMP_UI_M_SUM_GOVT_LC_AMT = comp_ui_m_sum_govt_lc_amt;
	}

	public HtmlOutputLabel getCOMP_UI_M_MED_EXAM_CODE_DESC_LABEL() {
		return COMP_UI_M_MED_EXAM_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_MED_EXAM_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_med_exam_code_desc_label) {
		COMP_UI_M_MED_EXAM_CODE_DESC_LABEL = comp_ui_m_med_exam_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_MED_EXAM_CODE_DESC() {
		return COMP_UI_M_MED_EXAM_CODE_DESC;
	}

	public void setCOMP_UI_M_MED_EXAM_CODE_DESC(
			HtmlInputText comp_ui_m_med_exam_code_desc) {
		COMP_UI_M_MED_EXAM_CODE_DESC = comp_ui_m_med_exam_code_desc;
	}

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_MED_EXAM_DTL_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_MED_EXAM_DTL_HELPER helper) {
		this.helper = helper;
	}

	public List<SelectItem> getListPMED_STATUS() {
		return listPMED_STATUS;
	}

	public void setListPMED_STATUS(List<SelectItem> listPMED_STATUS) {
		this.listPMED_STATUS = listPMED_STATUS;
	}

	public void setDataList_PT_IL_POL_MED_EXAM_DTL(
			List<PT_IL_POL_MED_EXAM_DTL> dataList_PT_IL_POL_MED_EXAM_DTL) {
		this.dataList_PT_IL_POL_MED_EXAM_DTL = dataList_PT_IL_POL_MED_EXAM_DTL;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		/*Added by Ameen on 03-11-2017 as per Gourav sugg.*/
		String medCheckQry = "";
		ResultSet medCheckrs = null;
		/*end*/
		try {
		
			if (isBlockFlag()) {
				System.out.println("hash Code =" + this.hashCode());
				System.out.println(" inside block flag");
				
				/*Added by Ram on 10/11/2016 for Editable datagrid*/
				prepareCLINIC_CODElov();
				/*End*/
				
				helper.whenNewBlockInstance(compositeAction);
				helper.executeQuery(compositeAction);
				
				if (PT_IL_POL_MED_EXAM_DTL_BEAN.getROWID() != null) {
					helper.postQuery(this, compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
				} else {
					helper.whenCreateRecord(PT_IL_POL_MED_EXAM_DTL_BEAN,
							compositeAction.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN());
				}
				helper.whenNewRecordInstance(this,compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN());
				/*Modified by saranya on 18-03-2017*/
				/*add the pol_status condition by raja on 16-03-2017 for Query screen issue*/
				if((!compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_STATUS().equalsIgnoreCase("A"))&&(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("N")) && 
						getPT_IL_POL_MED_EXAM_DTL_BEAN().getROWID()==null){
					COMP_PMED_EXAM_CODE.setDisabled(false);	
				}
				/*End*/
				
				/*Added by Ram on 31/03/2017 for SelectAll functionality*/
				PT_IL_POL_MED_EXAM_DTL_BEAN.setDataTable(dataTable);
				/*End*/
				
				setBlockFlag(false);
				 /*added by raja on 28-06-2017 for discussed with ajoy */ 
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS().equalsIgnoreCase("N"))
						{
							setUPDATE_ALLOWED(true);
							PT_IL_POL_MED_EXAM_DTL_BEAN.setUPDATE_ALL(true);
						}
				
				/*end*/
				
				/*Added by saritha on 20-04-2018 for KIC Medical Payment Issues */
				
				 String clinicDetailsParam = String.valueOf(CommonUtils.getPPSystemParameterValue("IL_CLN_DTYN"));
				 System.out.println("clinicDetailsParam ----->" +clinicDetailsParam );
				 
				 if(clinicDetailsParam.equalsIgnoreCase("1")){
					
					 COMP_PMED_EXM_DN_DT.setRequired(true);
					 //COMP_PMED_EXM_DN_DT.setDisabled(false);
					 
				 }else{
					 
					 COMP_PMED_EXM_DN_DT.setRequired(false);
					 COMP_PMED_EXM_DN_DT.setDisabled(true);
				 }
				 
				/*End*/
				 if(getListCLINIC_CODE() != null && PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_CLINIC_CODE() != null){
					 PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CLINIC_CODE(getListCLINIC_CODE().get(0).getValue().toString());
					 PT_IL_POL_MED_EXAM_DTL_BEAN.setUI_M_CLINIC_CODE_DESC(getListCLINIC_CODE().get(0).getLabel().toString());
				 }
			}
			/*Added by Ameen on 03-11-2017 as per Gourav sugg.*/
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()!=null &&
			   !compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("Y") && 
			   compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE() == null){
				medCheckQry = "SELECT PMED_FLEX_04 FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ? AND PMED_EXAM_CODE = ?";
				medCheckrs = new CRUDHandler().executeSelectStatement(medCheckQry, CommonUtils.getConnection(), 
									new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
													PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_EXAM_CODE()});
				
				if(medCheckrs.next()){
					if("Y".equalsIgnoreCase(medCheckrs.getString("PMED_FLEX_04"))){
						COMP_PMED_STATUS.setDisabled(true);
						PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
						COMP_PMED_REP_REC_DT.setDisabled(true);
					}else{
						COMP_PMED_STATUS.setDisabled(false);
						PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
						COMP_PMED_REP_REC_DT.setDisabled(false);
					}
				}
				
			}else if(!compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("Y") &&
					"002".equalsIgnoreCase(CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_TYPE(),"000")) &&
					CommonUtils.isIN(CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE(),"XXX"), "INCSA","ADDDEP","ADDRIDER")){
				medCheckQry = "SELECT 'X' FROM PT_IL_POL_MED_EXAM_DTL WHERE PMED_POL_SYS_ID = ? AND NVL(PMED_STATUS,'X') = 'Y' AND PMED_END_NO_IDX = 0 AND PMED_EXAM_CODE = ?";
				
				medCheckrs = new CRUDHandler().executeSelectStatement(medCheckQry, CommonUtils.getConnection(), 
						new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
										PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_EXAM_CODE()});
				if(medCheckrs.next()){
					COMP_PMED_STATUS.setDisabled(true);
					PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
					COMP_PMED_REP_REC_DT.setDisabled(true);
				}else{
					COMP_PMED_STATUS.setDisabled(false);
					PT_IL_POL_MED_EXAM_DTL_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
					COMP_PMED_REP_REC_DT.setDisabled(false);
				}
			}
			/*end*/
			
			 /*Added by Ameen on 17-05-2018 for waived status */
			if("NA".equalsIgnoreCase(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_STATUS())){
				COMP_PMED_CLINIC_CODE.setRequired(false);
				COMP_PMED_PVT_LC_AMT.setRequired(false);
				COMP_PMED_REP_REC_DT.setRequired(false);
				COMP_PMED_EXM_DN_DT.setRequired(false);
				COMP_PMED_GOVT_LC_AMT.setRequired(false);
			}else{
				COMP_PMED_CLINIC_CODE.setRequired(true);
				COMP_PMED_PVT_LC_AMT.setRequired(true);
				COMP_PMED_REP_REC_DT.setRequired(true);
				COMP_PMED_EXM_DN_DT.setRequired(true);
				COMP_PMED_GOVT_LC_AMT.setRequired(true);
			}
			/*End*/
			
			
			if(compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().getPT_IL_POL_MED_EXAM_DTL_BEAN().getPMED_CLINIC_CODE() == null){
				if(getListCLINIC_CODE() != null){
					compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_CLINIC_CODE(getListCLINIC_CODE().get(0).getValue().toString());
					compositeAction.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN().getPT_IL_POL_MED_EXAM_DTL_BEAN().setUI_M_CLINIC_CODE_DESC(getListCLINIC_CODE().get(0).getLabel().toString());
					COMP_PMED_CLINIC_CODE.resetValue();
					COMP_UI_M_CLINIC_CODE_DESC.resetValue();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PMED_DEL_FLAG_LABEL() {
		return COMP_PMED_DEL_FLAG_LABEL;
	}

	public void setCOMP_PMED_DEL_FLAG_LABEL(
			HtmlOutputLabel comp_pmed_del_flag_label) {
		COMP_PMED_DEL_FLAG_LABEL = comp_pmed_del_flag_label;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PMED_DEL_FLAG() {
		return COMP_PMED_DEL_FLAG;
	}

	public void setCOMP_PMED_DEL_FLAG(
			HtmlSelectBooleanCheckbox comp_pmed_del_flag) {
		COMP_PMED_DEL_FLAG = comp_pmed_del_flag;
	}

	public void PMED_EXAM_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_EXAM_CODE((String) value);
			
			/*Added by saritha on 09-Jun-2017 for ssp call id ZBILQC-1728634*/
			helper
					.PMED_EXAM_CODE_WHEN_VALIDATE_ITEM(getPT_IL_POL_MED_EXAM_DTL_BEAN(),compositeAction);
			/*End*/
			
			validate();
			
/*added by raja on 25-04-2017*/
			
			helper.checkDuplicate(this,getPT_IL_POL_MED_EXAM_DTL_BEAN());
			
			/*End*/
			
			getCOMP_UI_M_MED_EXAM_CODE_DESC().resetValue();
			getCOMP_PMED_MED_DESC().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	//added by saranya for medical description on 25-04-2016
	public void validate() throws Exception
	{
		System.out.println("inside validate function");
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		connection = CommonUtils.getConnection();
		String CURSOR_C1="SELECT PC_CODE,PC_LONG_DESC FROM PM_CODES WHERE PC_TYPE  ='IL_MED_EXM' and PC_CODE=?";
		resultSet = handler.executeSelectStatement(CURSOR_C1,
				connection,new Object[] {PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_EXAM_CODE()});
		if (resultSet.next()) {
			PT_IL_POL_MED_EXAM_DTL_BEAN.setUI_PMED_MED_DESC(resultSet.getString(2));
			System.out.println("value-->"+PT_IL_POL_MED_EXAM_DTL_BEAN.getUI_PMED_MED_DESC());
		}
	}
	//End


	public void PMED_CLINIC_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String str = null;
		try {
			getPT_IL_POL_MED_EXAM_DTL_BEAN()
					.setPMED_CLINIC_CODE((String) value);
			CommonUtils.setGlobalVariable("temp",(String)value);
			System.out.println("Clinic Code"+PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_CLINIC_CODE());
			str = helper.PMED_CLINIC_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_MED_EXAM_DTL_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
		getCOMP_UI_M_CLINIC_CODE_DESC().resetValue();
			getWarningMap().put("mess", str);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {

		}
	}
	public void PMED_GOVT_LC_AMT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_GOVT_LC_AMT((Double) value);
	Double values=(Double) value;
	if(values.equals(null))
	{
		System.out.println("Enter into amt validation"   +values);
		getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_GOVT_LC_AMT(.00);
	}
	}

	public void PMED_STATUS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			System.out.println("Enter into status validation");
			getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_STATUS((String) value);
			
			String status=getPT_IL_POL_MED_EXAM_DTL_BEAN().getPMED_STATUS();
			
			/*Added by Janani on 19.02.2018 for making medical fee as 0 if status is waived,as suggested by Gaurav*/
			if(status.equalsIgnoreCase("na"))
			{
				getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_FLEX_06(null); 
			}
			/*End*/
			/*String Clinic_code=getPT_IL_POL_MED_EXAM_DTL_BEAN().getPMED_CLINIC_CODE();
			System.out.println("the clinic code value is:   "+Clinic_code);
			if(((Clinic_code==null) &&(status.equalsIgnoreCase("Y")))||((Clinic_code==null) &&(status.equalsIgnoreCase("N"))))
			{
				COMP_PMED_CLINIC_CODE.setDisabled(false);
				System.out.println("Enter the if condition");
				String message1="Enter the clinic code";
				getErrorMap().put("current", message1);
			}*/
			
			/*Modified by Janani on 19.07.2017 for ZBILQC-1732338*/
			/*helper.PMED_STATUS_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN());*/
			
			helper.PMED_STATUS_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN(),compositeAction);
			
			/*End*/
			
			COMP_PMED_REP_REC_DT.resetValue();
			
			/*Added by Ameen on 07-06-2017 for ZBILQC-1726894*/
			if("Y".equalsIgnoreCase(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_STATUS())){
				COMP_PMED_REP_REC_DT.setRequired(true);
				COMP_PMED_MED_DESC.setDisabled(true);
			}else{
				COMP_PMED_REP_REC_DT.setRequired(false);
			}
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatePMED_REP_REC_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		try {
			/*Modified by Ameen on 07-06-2017 for ZBILQC-1726894*/
			// Newly added by dhinesh on 1-06-2017 call id ZBILQC-1726894
			PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_REP_REC_DT((Date) value);
			
			//if(CommonUtils.dateGreaterthenOrEqualTo(REP_REC_DT, new CommonUtils().getCurrentDate()))
			if(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_REP_REC_DT().after(new CommonUtils().getCurrentDate()))
			{
				//PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_REP_REC_DT(new CommonUtils().getCurrentDate());
				throw new Exception(" should not exceed current date");
				
			}				
			/*end*/
			/*End*/
			
			PMED_REP_REC_DT_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN(),compositeAction);
			getCOMP_PMED_REP_REC_DT().setRendered(true);

			//COMP_PMED_REP_REC_DT.resetValue();
			
			/*Added by saritha on 03-05-2018 for KIC Medical Exam Date to default Medical Exam Done Date*/
			
			COMP_PMED_EXM_DN_DT.resetValue();
			
			/*End*/
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PMED_REP_REC_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
/*Commented and modified by Janani on 26.04.2018 for Fidelity as discussed with Vinoth*/
	
	/*public void PMED_REP_REC_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		Date POL_START_DT = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_START_DT();
		Date PMED_REP_REC_DT = compositeAction
				.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
				.getPT_IL_POL_MED_EXAM_DTL_BEAN().getPMED_REP_REC_DT();

		if ((PMED_REP_REC_DT.before(POL_START_DT))
				|| (PMED_REP_REC_DT.after(new CommonUtils().getCurrentDate()))) {
			try {
				//throw new Exception("Rec Date should between" +POL_START_DT +"and"+ new CommonUtils().getCurrentDate());
				throw new Exception("Rec date must fall within policy start date and system date");
						
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}

	}
*/	
	public void PMED_REP_REC_DT_WHEN_VALIDATE_ITEM(PT_IL_POL_MED_EXAM_DTL_ACTION examAction,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		Connection connection = null;
		ResultSet resultset = null;
		String query = "SELECT MED_NO_OF_VALID_DAYS FROM PM_IL_MED_EXAM_DTL WHERE MED_EXAM_CODE = ?";
		int med_no_of_valid_days = 0;
		
		try{
		
		Date POL_START_DT = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_START_DT();
		Date PMED_REP_REC_DT = compositeAction
				.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
				.getPT_IL_POL_MED_EXAM_DTL_BEAN().getPMED_REP_REC_DT();
			
/*Added by saritha on 03-05-2018 for KIC Medical Exam Date to default Medical Exam Done Date*/
		
		PT_IL_POL_MED_EXAM_DTL examBean = examAction.getPT_IL_POL_MED_EXAM_DTL_BEAN();
		
		examBean.setPMED_EXM_DN_DT(PMED_REP_REC_DT);
		
		/*End*/
		
		connection = CommonUtils.getConnection();
		
		resultset = new CRUDHandler().executeSelectStatement(query, connection,new Object[]{compositeAction
				.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN()
				.getPT_IL_POL_MED_EXAM_DTL_BEAN().getPMED_EXAM_CODE()});
		
		if(resultset.next()){
			
			med_no_of_valid_days = resultset.getInt("MED_NO_OF_VALID_DAYS");
					
			System.out.println("med_no_of_valid_days is                 "+med_no_of_valid_days);
				
		}
		
		
		int mon_diff = CommonUtils.getMonthDiff(PMED_REP_REC_DT,(new CommonUtils().getCurrentDate()));
		System.out.println("mon_diff1                 "+mon_diff);
		
		/*if ((PMED_REP_REC_DT.before(POL_START_DT))
					|| (PMED_REP_REC_DT.after(new CommonUtils().getCurrentDate()))) */
			if(mon_diff > med_no_of_valid_days)
			{
				
						
					throw new Exception("Rec date is greater than "+med_no_of_valid_days+" months. Med.exam date should be within "+med_no_of_valid_days+" months");					
				
			}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}

	/*End*/
	
	

	public ArrayList<LovBean> prepareSuggestionList_EXAM_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_MED_EXAM_DTL";
		String fieldName = "PMED_EXAM_CODE";
		Object param1 = "IL_MED_EXM";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_CLINIC_CODE(Object object) {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		Object[] values = null;
		String currentValue = (String) object;

		//String subQry="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
		/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
		 * 
		 * String mainQry =

		" SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER "
				+ " WHERE CUST_CLASS IN (  SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
				+ " PP_SYSTEM  WHERE DECODE (PS_VALUE,2,CCLAS_CODE,CCLAS_TYPE) IN (#) "
				+ " AND PS_CODE = ? AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' "
				+ " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE FROM  PM_CUST_DIVN WHERE "
				+ " CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)AND CUST_APPL_ALL_BRAN_YN = 'N')) "
				+ " OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND (CUST_CODE LIKE ?  OR CUST_NAME LIKE ? OR CUST_BL_NAME LIKE ? ) "
				+ " AND ROWNUM < 20 ORDER BY 1 ";*/
		
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
		String mainQry =

				" SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER "
						+ " WHERE CUST_CLASS IN (  SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
						+ " PP_SYSTEM  WHERE DECODE (PS_VALUE,2,CCLAS_CODE,CCLAS_TYPE) IN (#) "
						+ " AND PS_CODE = ? AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' "
						+ " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE FROM  PM_CUST_DIVN WHERE "
						+ " CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)AND CUST_APPL_ALL_BRAN_YN = 'N')) "
						+ " OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND (UPPER(CUST_CODE) LIKE UPPER(?)  OR UPPER(CUST_NAME) LIKE UPPER(?) OR UPPER(CUST_BL_NAME) LIKE UPPER(?) ) "
						+ " AND ROWNUM < 20 ORDER BY 1 ";
		/*end*/
		System.out.println(mainQry);
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			mainQry = prepareCustomerQuery(mainQry,
					new Object[] { "HOSPITALS" });
			values = new Object[] {
					"HOSPITALS",
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE(),
					currentValue, currentValue, currentValue };
			suggestionList = ListItemUtil
					.prepareSuggestionList(mainQry, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public String prepareCustomerQuery(String CustCodeQuery, Object[] values) {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String query_input = "";
		String subQry = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(subQry, connection,
					values);
			if (resultSet.next()) {
				query_input = resultSet.getString("PS_CODE_DESC");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		CustCodeQuery = CustCodeQuery.replaceFirst("#", query_input);
		return CustCodeQuery;
	}

	/**
	 * Disables all components in PT_IL_POL_MED_EXAM_DTL_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_PMED_EXAM_CODE.setDisabled(disabled);
		COMP_PMED_CLINIC_CODE.setDisabled(disabled);
		/*commented by raja on 25-04-2017*/
		//	COMP_UI_M_CLINIC_CODE_DESC.setDisabled(disabled);
			
			/*end*/
		COMP_PMED_PVT_LC_AMT.setDisabled(disabled);
		COMP_PMED_GOVT_LC_AMT.setDisabled(disabled);
		COMP_UI_M_SUM_PVT_LC_AMT.setDisabled(disabled);
		COMP_UI_M_SUM_GOVT_LC_AMT.setDisabled(disabled);
		/*commented by raja on 25-04-2017*/
		//	COMP_UI_M_MED_EXAM_CODE_DESC.setDisabled(disabled);
			/*end*/

		// Disabling HtmlSelectOneMenu
		COMP_PMED_STATUS.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_PMED_REP_REC_DT.setDisabled(disabled);
		
		/*added by raja on 16-03-2017 for Query screen issue*/
		COMP_PMED_MED_DESC.setDisabled(disabled);
		
		/*end*/
		
		/* Added by ganesh on 16-05-2017 for adding remarks field in medical examination */
		COMP_PMED_REMARKS.setDisabled(disabled);
		/*end*/
		/*Added by Ameen on 08-03-2018 for KICLIFEQC-1746096*/
		COMP_PMED_EXM_DN_DT.setDisabled(disabled);
		/*end*/
		/*Added by Sivarajan on 31/10/2019 for sarwa IL*/
		//COMP_PMED_FLEX_25.setDisabled(disabled);
		/*End*/
	}

	/**
	 * Instantiates all components in PT_IL_POL_MED_EXAM_DTL_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_PMED_EXAM_CODE = new HtmlInputText();
		COMP_PMED_CLINIC_CODE = new HtmlInputText();
		COMP_UI_M_CLINIC_CODE_DESC = new HtmlInputText();
		COMP_PMED_PVT_LC_AMT = new HtmlInputText();
		COMP_PMED_GOVT_LC_AMT = new HtmlInputText();
		COMP_UI_M_SUM_PVT_LC_AMT = new HtmlInputText();
		COMP_UI_M_SUM_GOVT_LC_AMT = new HtmlInputText();
		COMP_UI_M_MED_EXAM_CODE_DESC = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_PMED_EXAM_CODE_LABEL = new HtmlOutputLabel();
		COMP_PMED_CLINIC_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_CLINIC_CODE_DESC_LABEL = new HtmlOutputLabel();
		COMP_PMED_PVT_LC_AMT_LABEL = new HtmlOutputLabel();
		COMP_PMED_GOVT_LC_AMT_LABEL = new HtmlOutputLabel();
		COMP_PMED_STATUS_LABEL = new HtmlOutputLabel();
		COMP_PMED_REP_REC_DT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_SUM_PVT_LC_AMT_LABEL = new HtmlOutputLabel();
		COMP_PMED_DEL_FLAG_LABEL = new HtmlOutputLabel();
		COMP_UI_M_SUM_GOVT_LC_AMT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_MED_EXAM_CODE_DESC_LABEL = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_PMED_STATUS = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_PMED_REP_REC_DT = new HtmlCalendar();
		// Instantiating HtmlSelectBooleanCheckbox
		COMP_PMED_DEL_FLAG = new HtmlSelectBooleanCheckbox();
		/*added by raja on 16-03-2017 for Query screen issue*/
		COMP_PMED_MED_DESC=new HtmlInputTextarea();
		/*end*/
		
		/* Added by ganesh on 16-05-2017 for adding remarks field in medical examination */
		COMP_PMED_REMARKS = new HtmlInputTextarea();
		/*end*/
		
		/*Added by Ameen on 08-03-2018 for KICLIFEQC-1746096*/
		COMP_PMED_EXM_DN_DT = new HtmlCalendar();
		/*end*/
	}

	/*Added by Ram on 10/11/2016 for Editable datagrid*/
	public void setPMED_CLINIC_CODE_Editable(ActionEvent event) {
		String str = null;
		try
		{
		CommonUtils.clearMaps(this);
		String clinicCode=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		
 

		PT_IL_POL_MED_EXAM_DTL_BEAN=(PT_IL_POL_MED_EXAM_DTL)dataList_PT_IL_POL_MED_EXAM_DTL.get(currentIndex);
		if(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_STATUS() != null && PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_STATUS().equals("N"))
		{
			
		PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_CLINIC_CODE(clinicCode);
		
Iterator<SelectItem> listCLINIC_CODE_itr = listCLINIC_CODE.iterator();
while(listCLINIC_CODE_itr.hasNext())
{
	SelectItem item = (SelectItem)listCLINIC_CODE_itr.next();
	if(item.getValue() != null && item.getValue().equals(clinicCode))
	{
		PT_IL_POL_MED_EXAM_DTL_BEAN.setUI_M_CLINIC_CODE_DESC((String)item.getLabel());
	}
}
System.out.println(PT_IL_POL_MED_EXAM_DTL_BEAN.getUI_M_CLINIC_CODE_DESC());
COMP_PMED_CLINIC_CODE.resetValue();
COMP_UI_M_CLINIC_CODE_DESC.resetValue();

		}


		}
catch (Exception e) {
	e.printStackTrace();
	getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			e.getMessage());
	getErrorMap().put("postRecord", e.getMessage());	
}
		
}
		
		
	
	
	public void setPMED_STATUS_Editable(ActionEvent event) {
		try
		{
		CommonUtils.clearMaps(this);
		String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		PT_IL_POL_MED_EXAM_DTL_BEAN=(PT_IL_POL_MED_EXAM_DTL)dataList_PT_IL_POL_MED_EXAM_DTL.get(currentIndex);
		PT_IL_POL_MED_EXAM_DTL_BEAN.setPMED_STATUS(status);
		
		/*Modified by Janani on 19.07.2017 for ZBILQC-1732338*/
		
		/*helper.PMED_STATUS_WHEN_VALIDATE_ITEM(compositeAction
				.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN());*/
		
		helper.PMED_STATUS_WHEN_VALIDATE_ITEM(compositeAction
				.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN(),compositeAction);
		
		/*End*/
		
		if(status != null && status.equals("Y"))
		{
			COMP_PMED_CLINIC_CODE.setDisabled(true);
			COMP_UI_M_CLINIC_CODE_DESC.setDisabled(true);
		}
		else
		{
			COMP_PMED_CLINIC_CODE.setDisabled(false);
			//COMP_UI_M_CLINIC_CODE_DESC.setDisabled(false);
		}
		
		COMP_PMED_CLINIC_CODE.resetValue();
		COMP_UI_M_CLINIC_CODE_DESC.resetValue();
		COMP_PMED_REP_REC_DT.resetValue();
		COMP_PMED_STATUS.resetValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("postRecord", e.getMessage());	
		}
	}
	
	private List<SelectItem> listCLINIC_CODE = new ArrayList<SelectItem>();
	
	public List<SelectItem> getListCLINIC_CODE() {
		return listCLINIC_CODE;
	}

	public void setListCLINIC_CODE(List<SelectItem> listCLINIC_CODE) {
		this.listCLINIC_CODE = listCLINIC_CODE;
	}

	public void prepareCLINIC_CODElov() {

		ArrayList<SelectItem> suggestionList = new ArrayList<SelectItem>();
		
		Object[] values = null;
		String currentValue = "*";
		SelectItem selectItem =null;
		 
		String mainQry =

				
				/*Row count has been removed for displaying default clinic code while loading by Janani on 29.05.2018 for Fidelity*/
				
				/*" SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER "
						+ " WHERE CUST_CLASS IN (  SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
						+ " PP_SYSTEM  WHERE DECODE (PS_VALUE,2,CCLAS_CODE,CCLAS_TYPE) IN (#) "
						+ " AND PS_CODE = ? AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' "
						+ " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE FROM  PM_CUST_DIVN WHERE "
						+ " CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)AND CUST_APPL_ALL_BRAN_YN = 'N')) "
						+ " OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND (UPPER(CUST_CODE) LIKE UPPER(?)  OR UPPER(CUST_NAME) LIKE UPPER(?) OR UPPER(CUST_BL_NAME) LIKE UPPER(?) ) "
						+ " AND ROWNUM < 20 ORDER BY 1 ";*/
				
				
				" SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER "
				+ " WHERE CUST_CLASS IN (  SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
				+ " PP_SYSTEM  WHERE DECODE (PS_VALUE,2,CCLAS_CODE,CCLAS_TYPE) IN (#) "
				+ " AND PS_CODE = ? AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' "
				+ " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE FROM  PM_CUST_DIVN WHERE "
				+ " CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)AND CUST_APPL_ALL_BRAN_YN = 'N')) "
				+ " OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND (UPPER(CUST_CODE) LIKE UPPER(?)  OR UPPER(CUST_NAME) LIKE UPPER(?) OR UPPER(CUST_BL_NAME) LIKE UPPER(?) ) "
				+ " ORDER BY 1 ";
				
		/*End of fidleity changes*/
		
		
				
		/*end*/
		System.out.println(mainQry);
		try {
			
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			mainQry = prepareCustomerQuery(mainQry,
					new Object[] { "HOSPITALS" });
			values = new Object[] {
					"HOSPITALS",
					compositeAction.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE(),
					currentValue, currentValue, currentValue };
			ResultSet rs = new CRUDHandler().executeSelectStatement(mainQry, CommonUtils.getConnection(),values);
			while(rs.next())
			{
				System.out.println(rs.getString("CUST_NAME")+"        "+rs.getString("CUST_CODE"));
				selectItem = new SelectItem();
				selectItem.setLabel(rs.getString("CUST_NAME"));
				selectItem.setValue(rs.getString("CUST_CODE"));
				suggestionList.add(selectItem);
			}
			setListCLINIC_CODE(suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();
System.out.println("rowIndex      "+rowIndex);
		try{
			if(rowIndex > -1){
				// Calling last Column listener
				updateRecord();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	
	public void updateRecord(){
		String message = null;
		String str = null;
		try { 
			System.out.println("Welcome to updateRecord     "+PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_STATUS());
			if(!CommonUtils.nvl(PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_CLINIC_CODE(), "temp").equals("temp"))
			{
			CommonUtils.setGlobalVariable("temp",PT_IL_POL_MED_EXAM_DTL_BEAN.getPMED_CLINIC_CODE());
			str = helper.PMED_CLINIC_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_MED_EXAM_DTL_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
			getCOMP_UI_M_CLINIC_CODE_DESC().resetValue();
			getWarningMap().put("mess", str);
		
			/*Modified by Janani on 19.07.2017 for ZBILQC-1732338*/
			
			/*helper.PMED_STATUS_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN());*/
			
			helper.PMED_STATUS_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_MED_EXAM_DTL_ACTION_BEAN(),compositeAction);
			
			/*End*/
			
			helper.preUpdate(getPT_IL_POL_MED_EXAM_DTL_BEAN(),
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			new CRUDHandler().executeUpdate(PT_IL_POL_MED_EXAM_DTL_BEAN,
					CommonUtils.getConnection());
			
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$update");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord", message);
			}
			else
			{

				System.out.println("Enter the post condition");
				String message1="Enter the clinic code";
				getErrorMap().put("current", message1);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}
	
	/*End*/
	
	/*Added by saritha on 02-Mar-2017 RM018T - DEV_IL_ZB Life_012b_Claim waiting period*/
	/*Commentted by saritha on 24-May-2017 for ZBILQC-1725269*/
	/*public void medical_check() throws DBException, SQLException {
		Connection connection = null;
		ResultSet resultSet = null;
		String PS_CODE=null;
		CRUDHandler handler = new CRUDHandler();
		connection = CommonUtils.getConnection();
		String C1 = " SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE='IL_HIV_CODE'";  	
		
		Iterator<PT_IL_POL_MED_EXAM_DTL> dataList_PT_IL_POL_MED_EXAM_DTL_ITR = dataList_PT_IL_POL_MED_EXAM_DTL.iterator();
		int hiv_exam_count=0;
		while(dataList_PT_IL_POL_MED_EXAM_DTL_ITR.hasNext())
		{
			PT_IL_POL_MED_EXAM_DTL bean = dataList_PT_IL_POL_MED_EXAM_DTL_ITR.next();
			
			System.out.println("values are      "+bean.getPMED_EXAM_CODE()+"      "+bean.getPMED_STATUS());
			resultSet = handler.executeSelectStatement(C1, connection);
		if(resultSet.next()){
			PS_CODE = resultSet.getString("PS_CODE");
			System.out.println("PS_CODE::::::::::::"+PS_CODE);

			if(bean.getPMED_EXAM_CODE() != null)
			{
				
				if(PS_CODE.equalsIgnoreCase(bean.getPMED_EXAM_CODE()) && (bean.getPMED_STATUS() != null && !bean.getPMED_STATUS().equalsIgnoreCase("N"))){
					System.out.println("IF getPOAD_HIV_TEST_YN        "+compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_HIV_TEST_YN());
					
					hiv_exam_count++;
					break;
				}	
				
			}
		}
		System.out.println("------------------------------------------");
		}
			System.out.println("hiv_exam_count "+hiv_exam_count);
			if(hiv_exam_count > 0)
			{
				
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_HIV_TEST_YN("Y");
			Added by sankara narayanan of 31/03/2017
				new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POL_ASSURED_DTLS SET POAD_HIV_TEST_YN='Y' WHERE POAD_POL_SYS_ID=?",
						CommonUtils.getConnection(),
						new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				CommonUtils.getConnection().commit();
				end
			}
			
			else
			{
				Added by sankara narayanan of 31/03/2017
				compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().setPOAD_HIV_TEST_YN("N");
				new CRUDHandler().executeUpdateStatement("UPDATE PT_IL_POL_ASSURED_DTLS SET POAD_HIV_TEST_YN='N' WHERE POAD_POL_SYS_ID=?",
						CommonUtils.getConnection(),
						new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
				CommonUtils.getConnection().commit();
				end
			}
			
		
	}*/
	
	/*End*/
	
	
	
	/*Added by Ram on 31/03/2017 for Update All Functionality*/
	public void fireFieldValidationChk(ActionEvent actionEvent) {
		try {

			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG() != null && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG().equals("N"))
			{

				UIInput input = (UIInput) actionEvent.getComponent().getParent();



				System.out.println("Welcome to PACOND_DFLT_YN_ALL_Validator");
				boolean chkFlag = false;
				chkFlag = (boolean)input.getSubmittedValue();
				String defChk = "N";
				if(chkFlag)
				{
					defChk = "Y";
				}
				/*
				 * modified by Ameen on 28-07-2017 for ZBILQC-1728634
				 * System.out.println("defChk        "+defChk+"       "+PT_IL_POL_MED_EXAM_DTL_BEAN.getCOMP_DT_SCROLLER().getPage()+"      "+PT_IL_POL_MED_EXAM_DTL_BEAN.getDataTable().getRows());*/
				System.out.println("defChk        "+defChk+"       "+PT_IL_POL_MED_EXAM_DTL_BEAN.getCOMP_DT_SCROLLER().getPage()+"      "+dataTable.getRows());


				/*
				 * modified by Ameen on 28-07-2017 for ZBILQC-1728634
				 * CommonUtils.setPageIndexing(PT_IL_POL_MED_EXAM_DTL_BEAN,PT_IL_POL_MED_EXAM_DTL_BEAN.getCOMP_DT_SCROLLER(),PT_IL_POL_MED_EXAM_DTL_BEAN.getDataTable());*/
				CommonUtils.setPageIndexing(PT_IL_POL_MED_EXAM_DTL_BEAN,PT_IL_POL_MED_EXAM_DTL_BEAN.getCOMP_DT_SCROLLER(),dataTable);

				System.out.println("page Start from "+PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex()+"    Ended to    "+PT_IL_POL_MED_EXAM_DTL_BEAN.getEndindex());

				/*
				 *COMMENTED BY DHINESH ON 30-05-2017 FOR STATUS FIELD CHANGE IN WHOLE MEDICAL EXAM DATA LIST
				 * 
				 * setDataList_PT_IL_POL_MED_EXAM_DTL(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL(), "PMED_STATUS", defChk,
						 PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(),PT_IL_POL_MED_EXAM_DTL_BEAN.getEndindex()));*/

				setDataList_PT_IL_POL_MED_EXAM_DTL(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL(), "PMED_STATUS", defChk,
						PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(),getDataList_PT_IL_POL_MED_EXAM_DTL().size()));

				if(chkFlag)
				{
				    /*
					 * COMMENTED BY DHINESH ON 30-05-2017 FOR STATUS FIELD CHANGE IN WHOLE MEDICAL EXAM DATA LIST
					 * 
					 *   setDataList_PT_IL_POL_MED_EXAM_DTL(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL(), "PMED_REP_REC_DT", new CommonUtils().getCurrentDate(),
						 PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(),PT_IL_POL_MED_EXAM_DTL_BEAN.getEndindex()));

					 */

					setDataList_PT_IL_POL_MED_EXAM_DTL(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL(), "PMED_REP_REC_DT", new CommonUtils().getCurrentDate(),
							PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(),getDataList_PT_IL_POL_MED_EXAM_DTL().size()));

					getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_REP_REC_DT(new CommonUtils().getCurrentDate());
					
					COMP_PMED_REP_REC_DT.resetValue();
					
					
					/* Newly Added By Dhinesh on 14/06/2018 for KIC Issue */
					setDataList_PT_IL_POL_MED_EXAM_DTL(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL(), "PMED_EXM_DN_DT", new CommonUtils().getCurrentDate(),
							PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(),getDataList_PT_IL_POL_MED_EXAM_DTL().size()));

					getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_EXM_DN_DT(new CommonUtils().getCurrentDate());
					COMP_PMED_EXM_DN_DT.resetValue();
					
					/* End */
					
				}
				else
				{
					/*
					 * COMMENTED BY DHINESH ON 30-05-2017 FOR STATUS FIELD CHANGE IN WHOLE MEDICAL EXAM DATA LIST 
					 *  
					 *  setDataList_PT_IL_POL_MED_EXAM_DTL(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL(), "PMED_REP_REC_DT", null,
							 PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(),PT_IL_POL_MED_EXAM_DTL_BEAN.getEndindex()));*/

					setDataList_PT_IL_POL_MED_EXAM_DTL(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL(), "PMED_REP_REC_DT", null,
							PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(),getDataList_PT_IL_POL_MED_EXAM_DTL().size()));

					getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_REP_REC_DT(null);
					COMP_PMED_REP_REC_DT.resetValue();
					
					
					/* Newly Added By Dhinesh on 14/06/2018 for KIC Issue */
					setDataList_PT_IL_POL_MED_EXAM_DTL(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL(), "PMED_EXM_DN_DT", null,
							PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(),getDataList_PT_IL_POL_MED_EXAM_DTL().size()));

					getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_EXM_DN_DT(null);
					COMP_PMED_EXM_DN_DT.resetValue();
					
					/* End */
				}
				getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_STATUS(defChk);
				COMP_PMED_STATUS.resetValue();


				getPT_IL_POL_MED_EXAM_DTL_BEAN().setUPDATE_ALL(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}  


	}
	/*End*/
	
	/*added by raja on 10-05-2017*/
	public void PMED_PVT_LC_AMT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		
		/*Added by Janani on 19.02.2018 for making medical fee as 0 if status is waived,as suggested by Gaurav*/
		System.out.println("enters into PDL_RATE_WHEN_VALIDATE_ITEM");
		
		Double curr=(Double) value;
		Double prev=getPT_IL_POL_MED_EXAM_DTL_BEAN().getPMED_PVT_LC_AMT();
		
		System.out.println("curr           "+curr+"      prev       "+prev);
		
		if(!curr.equals(prev))
		//if(!(curr == prev))
		{
			System.out.println("curr and previous value is not equal");
			
			getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_FLEX_06("M"); // M -- modified
			getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_PVT_LC_AMT((Double) curr);
		}else
		{
			getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_FLEX_06(null); 
		}
					
		/*End */
		
		
		/*
		 * Commented by Janani on 19.02.2018 for making medical fee as 0 if status is waived,as suggested by Gaurav
		 * 
		 * getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_PVT_LC_AMT((Double) value);
     Double values=(Double) value;
	if(curr.equals(null))
	{
		System.out.println("Enter into amt validation"   +values);
		getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_PVT_LC_AMT(values);
	}*/


	}
	/*end*/
	/* Added by ganesh on 16-05-2017 for adding remarks field in medical examination */
	private HtmlInputTextarea COMP_PMED_REMARKS;
	public HtmlInputTextarea getCOMP_PMED_REMARKS() {
		return COMP_PMED_REMARKS;
	}

	public void setCOMP_PMED_REMARKS(HtmlInputTextarea cOMP_PMED_REMARKS) {
		COMP_PMED_REMARKS = cOMP_PMED_REMARKS;
	}

	public HtmlOutputLabel getCOMP_PMED_REMARKS_LABEL() {
		return COMP_PMED_REMARKS_LABEL;
	}

	public void setCOMP_PMED_REMARKS_LABEL(HtmlOutputLabel cOMP_PMED_REMARKS_LABEL) {
		COMP_PMED_REMARKS_LABEL = cOMP_PMED_REMARKS_LABEL;
	}

	private HtmlOutputLabel COMP_PMED_REMARKS_LABEL;
	
	
	public void PMED_REMARKS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_REMARKS((String) value);
			getCOMP_PMED_REMARKS().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	/*end*/
	/*Added by Janani on 19.02.2018 for making medical fee as 0 if status is waived,as suggested by Gaurav*/
	private int row_index;

	public int getRow_index() {
		return row_index;
	}
	public void setRow_index(int row_index) {
		this.row_index = row_index;
	}
	/*End*/
	
	/*Added by Ameen on 08-03-2018 for KICLIFEQC-1746096*/	
	private HtmlOutputLabel COMP_PMED_EXM_DN_DT_LABEL;
	
	private HtmlCalendar COMP_PMED_EXM_DN_DT;

	public HtmlOutputLabel getCOMP_PMED_EXM_DN_DT_LABEL() {
		return COMP_PMED_EXM_DN_DT_LABEL;
	}

	public void setCOMP_PMED_EXM_DN_DT_LABEL(
			HtmlOutputLabel cOMP_PMED_EXM_DN_DT_LABEL) {
		COMP_PMED_EXM_DN_DT_LABEL = cOMP_PMED_EXM_DN_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PMED_EXM_DN_DT() {
		return COMP_PMED_EXM_DN_DT;
	}

	public void setCOMP_PMED_EXM_DN_DT(HtmlCalendar cOMP_PMED_EXM_DN_DT) {
		COMP_PMED_EXM_DN_DT = cOMP_PMED_EXM_DN_DT;
	}

	public void validatePMED_EXM_DN_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_EXM_DN_DT((Date) value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*eND*/
	
	/*Added by Sivarajan on 31/10/2019 for sarwa IL*/
	private HtmlOutputLabel COMP_PMED_FLEX_25_LABEL;
	private HtmlInputText COMP_PMED_FLEX_25;

	public HtmlOutputLabel getCOMP_PMED_FLEX_25_LABEL() {
		return COMP_PMED_FLEX_25_LABEL;
	}

	public void setCOMP_PMED_FLEX_25_LABEL(HtmlOutputLabel cOMP_PMED_FLEX_25_LABEL) {
		COMP_PMED_FLEX_25_LABEL = cOMP_PMED_FLEX_25_LABEL;
	}

	public HtmlInputText getCOMP_PMED_FLEX_25() {
		return COMP_PMED_FLEX_25;
	}

	public void setCOMP_PMED_FLEX_25(HtmlInputText cOMP_PMED_FLEX_25) {
		COMP_PMED_FLEX_25 = cOMP_PMED_FLEX_25;
	}
	
	
	public void PMED_FLEX_25_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		getPT_IL_POL_MED_EXAM_DTL_BEAN().setPMED_FLEX_25((String) value);
	
	}
}
