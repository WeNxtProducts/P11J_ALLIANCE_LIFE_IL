package com.iii.pel.forms.PILT032_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

 

public class PT_IL_RECEIPT_TRANS_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_STATUS;

	private HtmlOutputLabel COMP_RTH_APPRV_USER;

	private HtmlOutputLabel COMP_UI_M_RTH_APPRV_DT_LABEL;

	private HtmlCalendar COMP_UI_M_RTH_APPRV_DT;

	private HtmlOutputLabel COMP_RTH_SRC_POL_NO_LABEL;

	private HtmlInputText COMP_RTH_SRC_POL_NO;

	private HtmlOutputLabel COMP_RTH_APPRV_DT_LABEL;

	private HtmlCalendar COMP_RTH_APPRV_DT;

	private HtmlCommandButton COMP_UI_M_BUT_SRC_POL_NO1;

	private HtmlCommandButton COMP_UI_M_BUT_TARGET_POL;

	private HtmlCommandButton COMP_UI_M_BUT_REASON;

	private HtmlCommandButton COMP_UI_M_EDIT_REMARKS;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlInputText COMP_UI_M_RTH_SRC_POL_NO;

	private PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN;

	public PILT032_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_RECEIPT_TRANS_HDR_HELPER helper;
	
	private String DEFAULT_WHERE;

	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}
	
	/*Added by Janani on 11.07.2017 for ZBILQC-1719675*/
	private PT_IL_RECEIPT_TRANS_DTL_ACTION PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN;
	
	private PT_IL_RECEIPT_TRANS_DTL PT_IL_RECEIPT_TRANS_DTL_BEAN;
	
	private PT_IL_RECEIPT_TRANS_DTL_HELPER helper1;
	
	
	public PT_IL_RECEIPT_TRANS_DTL_ACTION getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN() {
		return PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN;
	}

	public void setPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN(
			PT_IL_RECEIPT_TRANS_DTL_ACTION pT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN) {
		PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN = pT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN;
	}

	public PT_IL_RECEIPT_TRANS_DTL_HELPER getHelper1() {
		return helper1;
	}

	public void setHelper1(PT_IL_RECEIPT_TRANS_DTL_HELPER helper1) {
		this.helper1 = helper1;
	}

	public PT_IL_RECEIPT_TRANS_DTL getPT_IL_RECEIPT_TRANS_DTL_BEAN() {
		return PT_IL_RECEIPT_TRANS_DTL_BEAN;
	}

	public void setPT_IL_RECEIPT_TRANS_DTL_BEAN(
			PT_IL_RECEIPT_TRANS_DTL pT_IL_RECEIPT_TRANS_DTL_BEAN) {
		PT_IL_RECEIPT_TRANS_DTL_BEAN = pT_IL_RECEIPT_TRANS_DTL_BEAN;
	}
	
	
	/*End*/

	public PT_IL_RECEIPT_TRANS_HDR_ACTION() {

		PT_IL_RECEIPT_TRANS_HDR_BEAN = new PT_IL_RECEIPT_TRANS_HDR();
		helper = new PT_IL_RECEIPT_TRANS_HDR_HELPER();
		
		/*Added by Janani on 11.07.2017 for ZBILQC-1719675*/
		
		PT_IL_RECEIPT_TRANS_DTL_BEAN = new PT_IL_RECEIPT_TRANS_DTL();
		helper1 = new PT_IL_RECEIPT_TRANS_DTL_HELPER();
		/*End*/
		
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_UI_M_STATUS() {
		return COMP_UI_M_STATUS;
	}

	public void setCOMP_UI_M_STATUS(HtmlOutputLabel COMP_UI_M_STATUS) {
		this.COMP_UI_M_STATUS = COMP_UI_M_STATUS;
	}

	public HtmlOutputLabel getCOMP_RTH_APPRV_USER() {
		return COMP_RTH_APPRV_USER;
	}

	public void setCOMP_RTH_APPRV_USER(HtmlOutputLabel COMP_RTH_APPRV_USER) {
		this.COMP_RTH_APPRV_USER = COMP_RTH_APPRV_USER;
	}

	public HtmlOutputLabel getCOMP_UI_M_RTH_APPRV_DT_LABEL() {
		return COMP_UI_M_RTH_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_RTH_APPRV_DT() {
		return COMP_UI_M_RTH_APPRV_DT;
	}

	public void setCOMP_UI_M_RTH_APPRV_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_RTH_APPRV_DT_LABEL) {
		this.COMP_UI_M_RTH_APPRV_DT_LABEL = COMP_UI_M_RTH_APPRV_DT_LABEL;
	}

	public void setCOMP_UI_M_RTH_APPRV_DT(HtmlCalendar COMP_UI_M_RTH_APPRV_DT) {
		this.COMP_UI_M_RTH_APPRV_DT = COMP_UI_M_RTH_APPRV_DT;
	}

	public HtmlOutputLabel getCOMP_RTH_SRC_POL_NO_LABEL() {
		return COMP_RTH_SRC_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_RTH_SRC_POL_NO() {
		return COMP_RTH_SRC_POL_NO;
	}

	public void setCOMP_RTH_SRC_POL_NO_LABEL(
			HtmlOutputLabel COMP_RTH_SRC_POL_NO_LABEL) {
		this.COMP_RTH_SRC_POL_NO_LABEL = COMP_RTH_SRC_POL_NO_LABEL;
	}

	public void setCOMP_RTH_SRC_POL_NO(HtmlInputText COMP_RTH_SRC_POL_NO) {
		this.COMP_RTH_SRC_POL_NO = COMP_RTH_SRC_POL_NO;
	}

	public HtmlOutputLabel getCOMP_RTH_APPRV_DT_LABEL() {
		return COMP_RTH_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_RTH_APPRV_DT() {
		return COMP_RTH_APPRV_DT;
	}

	public void setCOMP_RTH_APPRV_DT_LABEL(
			HtmlOutputLabel COMP_RTH_APPRV_DT_LABEL) {
		this.COMP_RTH_APPRV_DT_LABEL = COMP_RTH_APPRV_DT_LABEL;
	}

	public void setCOMP_RTH_APPRV_DT(HtmlCalendar COMP_RTH_APPRV_DT) {
		this.COMP_RTH_APPRV_DT = COMP_RTH_APPRV_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SRC_POL_NO1() {
		return COMP_UI_M_BUT_SRC_POL_NO1;
	}

	public void setCOMP_UI_M_BUT_SRC_POL_NO1(
			HtmlCommandButton COMP_UI_M_BUT_SRC_POL_NO1) {
		this.COMP_UI_M_BUT_SRC_POL_NO1 = COMP_UI_M_BUT_SRC_POL_NO1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TARGET_POL() {
		return COMP_UI_M_BUT_TARGET_POL;
	}

	public void setCOMP_UI_M_BUT_TARGET_POL(
			HtmlCommandButton COMP_UI_M_BUT_TARGET_POL) {
		this.COMP_UI_M_BUT_TARGET_POL = COMP_UI_M_BUT_TARGET_POL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REASON() {
		return COMP_UI_M_BUT_REASON;
	}

	public void setCOMP_UI_M_BUT_REASON(HtmlCommandButton COMP_UI_M_BUT_REASON) {
		this.COMP_UI_M_BUT_REASON = COMP_UI_M_BUT_REASON;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_REMARKS() {
		return COMP_UI_M_EDIT_REMARKS;
	}

	public void setCOMP_UI_M_EDIT_REMARKS(
			HtmlCommandButton COMP_UI_M_EDIT_REMARKS) {
		this.COMP_UI_M_EDIT_REMARKS = COMP_UI_M_EDIT_REMARKS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public PT_IL_RECEIPT_TRANS_HDR getPT_IL_RECEIPT_TRANS_HDR_BEAN() {
		return PT_IL_RECEIPT_TRANS_HDR_BEAN;
	}

	public void setPT_IL_RECEIPT_TRANS_HDR_BEAN(
			PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN) {
		this.PT_IL_RECEIPT_TRANS_HDR_BEAN = PT_IL_RECEIPT_TRANS_HDR_BEAN;
	}

	public void saveRecord() {
		String message = null;
		try {
			if (getPT_IL_RECEIPT_TRANS_HDR_BEAN().getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.PRE_UPDATE(PT_IL_RECEIPT_TRANS_HDR_BEAN);
					new CRUDHandler().executeUpdate(PT_IL_RECEIPT_TRANS_HDR_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							"current",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");
				}
			} else {
				if (isINSERT_ALLOWED()) {
					new CRUDHandler().executeInsert(PT_IL_RECEIPT_TRANS_HDR_BEAN,
							CommonUtils.getConnection());
					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
				}
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	

	public ArrayList<com.iii.premia.common.bean.LovBean> lovRTH_SRC_POL_NO(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT032_APAC",
					"PT_IL_RECEIPT_TRANS_HDR", "RTH_SRC_POL_NO", null, null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	// P_CALL_LOV('PT_IL_RECEIPT_TRANS_HDR.RTH_SRC_POL_NO');

	public void fireFieldValidation(ActionEvent actionEvent) {
		   UIInput input = (UIInput) actionEvent.getComponent().getParent();
		   ErrorHelpUtil.validate(input, getErrorMap());
		  
	}
	
	public String backButton(){
		return "PILT032_APAC";
	}
	
	public void validateRTH_SRC_POL_NO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SRC_POL_NO((String) value);
			helper.keyNextItem(PT_IL_RECEIPT_TRANS_HDR_BEAN, compositeAction);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "RTH_SRC_POL_NO",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				
				
				helper.WHEN_NEW_RECORD_INSTSNCE(compositeAction, PT_IL_RECEIPT_TRANS_HDR_BEAN);
				if (PT_IL_RECEIPT_TRANS_HDR_BEAN.getROWID() != null) {
					helper.PRE_QUERY(compositeAction);
					helper.executeQuery(compositeAction);
					
					/*Added by Janani on 11.07.2017 for ZBILQC-1719675*/
					
						System.out.println("HDR row id !null");
						
						/*PT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN.onLoad(event);
						setBlockFlag(true);*/
						
						helper1.executeQuery(compositeAction);
						
						System.out.println("getROWID in onload           "+compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().
								getPT_IL_RECEIPT_TRANS_DTL_BEAN().getROWID());
						
						System.out.println("getRTD_SRC_DEP_SYS_ID  in onload            "+compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().
									getPT_IL_RECEIPT_TRANS_DTL_BEAN().getRTD_SRC_DEP_SYS_ID());
						
						if (compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().
								getPT_IL_RECEIPT_TRANS_DTL_BEAN().getROWID() != null) {
							helper1.POST_QUERY(compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().
									getPT_IL_RECEIPT_TRANS_DTL_BEAN());
						}
						
						disableProcessButton();
					
					/*End*/
					
				}
				
				
				setBlockFlag(false);
				
				/*Added by Janani on 11.07.2017 for ZBILQC-1719675*/
				
				System.out.println("getRTH_APPRV_STATUS                "+PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_APPRV_STATUS());
				if(PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_APPRV_STATUS() != null && PT_IL_RECEIPT_TRANS_HDR_BEAN.getRTH_APPRV_STATUS().equalsIgnoreCase("Y"))
				{
					compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().disableAllComponent(true);
					disableAllComponent(true);
					/*getCOMP_RTH_SRC_POL_NO().setDisabled(true);
					getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
					getCOMP_UI_M_BUT_APPROVE().setDisabled(true);*/
				}
				
				
				System.out.println("getCOMP_UI_M_BUT_PROCESS  in onload            "+compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().
						getCOMP_UI_M_BUT_PROCESS().isDisabled());
				
				System.out.println("getCOMP_UI_M_BUT_APPROVE  in onload            "+compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().
						getCOMP_UI_M_BUT_APPROVE().isDisabled());
				
				
				/*End*/
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	/**
	 * Instantiates all components in PT_IL_RECEIPT_TRANS_HDR_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlCalendar
		COMP_UI_M_RTH_APPRV_DT				 = new HtmlCalendar();
		COMP_RTH_APPRV_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_SRC_POL_NO1			 = new HtmlCommandButton();
		COMP_UI_M_BUT_TARGET_POL			 = new HtmlCommandButton();
		COMP_UI_M_BUT_REASON				 = new HtmlCommandButton();
		COMP_UI_M_EDIT_REMARKS				 = new HtmlCommandButton();
		COMP_UI_M_BUT_PROCESS				 = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVE				 = new HtmlCommandButton();
		

	}

	public HtmlInputText getCOMP_UI_M_RTH_SRC_POL_NO() {
		return COMP_UI_M_RTH_SRC_POL_NO;
	}

	public void setCOMP_UI_M_RTH_SRC_POL_NO(
			HtmlInputText comp_ui_m_rth_src_pol_no) {
		COMP_UI_M_RTH_SRC_POL_NO = comp_ui_m_rth_src_pol_no;
	}

	
	
	/*Added by Janani on 10.07.2017 ZBILQC-1719675*/
	

	public String getasd_char_value_flag()
				throws Exception {
		  System.out.println("*******enter into validate_asd_char_value_flag***");
		
			String C1 ="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID =? "
					+ "AND ASD_CODE = 'RCT_TR_AP_YN' AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
			ResultSet C1_REC = null;
			String CHECK_CODE=null;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				String productCode=getprod_code();
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] {CommonUtils.getControlBean().getUSER_ID(),productCode});
				if (C1_REC.next()) {
					CHECK_CODE =C1_REC.getString(1);
				}
				} catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			/* Added by Shahbaz khan 12/03/2020 for Close the result Set */
			finally {
						try {
							CommonUtils.closeCursor(C1_REC);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			System.out.println("**************value of CHECK_CODE***"+CHECK_CODE);
			return CHECK_CODE;
			
		}
	 public String getprod_code()
				throws Exception {
		  System.out.println("*******enter into getprod_code***");
		
			String C1 ="select pol_prod_code from pt_il_policy where pol_no=?";
			ResultSet C1_REC = null;
			String product_code=null;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] {compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SRC_POL_NO()});
				if (C1_REC.next()) {
					product_code =C1_REC.getString(1);
				}
				} catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			System.out.println("**************value of product_code***"+product_code);
			return product_code;
			
		}
	 
	 
	 public void disableProcessButton()
			 throws Exception {
		 System.out.println("*******enter into disableProcessButton***");

		 String C1 ="SELECT RTD_SYS_ID  FROM PT_IL_RECEIPT_TRANS_DTL WHERE RTD_RTH_SYS_ID = ?";
		 ResultSet C1_REC = null;
		 String product_code=null;
		 try {
			 Connection connection = CommonUtils.getConnection();
			 CRUDHandler handler = new CRUDHandler();

			 System.out.println("getRTH_SYS_ID in disableProcessButton             "+compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN()
					 .getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID());

			 C1_REC = handler.executeSelectStatement(C1, connection,
					 new Object[] {compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getRTH_SYS_ID()});
			 if (C1_REC.next()) 
			 {

				 COMP_UI_M_BUT_PROCESS.setDisabled(true);

			 }

		 } 
		 catch (SQLException e) {
			 throw new Exception(e.getMessage());
		 } 

		 System.out.println("getCOMP_UI_M_BUT_PROCESS  in disableProcessButton            "+compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().
				 getCOMP_UI_M_BUT_PROCESS().isDisabled());
		

	 }
	 
	 
	 public void disableAllComponent(boolean disabled) {
		    COMP_UI_M_RTH_APPRV_DT.setDisabled(disabled);
			COMP_RTH_APPRV_DT.setDisabled(disabled);
			COMP_UI_M_BUT_SRC_POL_NO1.setDisabled(disabled);
			COMP_UI_M_BUT_TARGET_POL.setDisabled(disabled);
			COMP_UI_M_BUT_REASON.setDisabled(disabled);
			COMP_UI_M_EDIT_REMARKS.setDisabled(disabled);
			COMP_UI_M_BUT_PROCESS.setDisabled(disabled);
			COMP_UI_M_BUT_APPROVE.setDisabled(disabled);
			COMP_RTH_SRC_POL_NO.setDisabled(disabled);
		}
	
	/*eND*/
	
}