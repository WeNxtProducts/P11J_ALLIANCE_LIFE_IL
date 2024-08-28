package com.iii.pel.forms.PILT032_APAC;

import javax.faces.component.html.HtmlCommandButton;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;


public class DUMMY_ACTION extends CommonAction {
	
	public PILT032_APAC_COMPOSITE_ACTION compositeAction;
	
	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;
	
	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;
	
	private String UI_M_BUT_PROCESS;
	
	private String UI_M_BUT_APPROVE;
	
	private DUMMY DUMMY_BEAN;
	
	private DUMMY_HELPER helper;
	
	public DUMMY_ACTION(){
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
		instantiateAllComponent();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton comp_ui_m_but_process) {
		COMP_UI_M_BUT_PROCESS = comp_ui_m_but_process;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton comp_ui_m_but_approve) {
		COMP_UI_M_BUT_APPROVE = comp_ui_m_but_approve;
	}

	public String getUI_M_BUT_PROCESS() {
		return UI_M_BUT_PROCESS;
	}

	public void setUI_M_BUT_PROCESS(String ui_m_but_process) {
		UI_M_BUT_PROCESS = ui_m_but_process;
	}

	public String getUI_M_BUT_APPROVE() {
		return UI_M_BUT_APPROVE;
	}

	public void setUI_M_BUT_APPROVE(String ui_m_but_approve) {
		UI_M_BUT_APPROVE = ui_m_but_approve;
	}
	

	/**
	 * Instantiates all components in DUMMY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_PROCESS				 = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVE				 = new HtmlCommandButton();

	}


	 
	public String processButtonAction() {
		String message = null;
		message = "Processed records successfully ..... !";
		
		try{
			
			 System.out.println("enters into processButtonAction");
			
			
			helper.WHEN_VALIDATE_M_BUT_PROCESS(compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().
					getPT_IL_RECEIPT_TRANS_HDR_BEAN(), compositeAction);
			//getWarningMap().put(PELConstants.pelErrorMessagePath,message);
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getWarningMap().put("Process",message);
			
			/*Added by Janani on 10.07.2017 ZBILQC-1719675*/
			
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().onLoad(null);
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().setBlockFlag(true);
			
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
			System.out.println("getCOMP_UI_M_BUT_PROCESS              "+compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().
			getCOMP_UI_M_BUT_PROCESS().isDisabled());
			/*End*/
			
			/* Newly Added By Dhinesh on 21-8-2017 for ssp call id  : ZBILQC-1719675 */
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().displayRecords();
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().getCOMP_RTD_DES_POL_NO().setRequired(true);
			/* End */
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
		}
		return null;
	}
	
	 

	public String approveButtonAction() {
		try{
			
			/*Added by Janani on 11.07.2017 for ZBILQC-1719675*/
			System.out.println("Enters into approveButtonAction");
			
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().
			getasd_char_value_flag();
			
			System.out.println("getasd_char_value_flag                "+compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().
					getasd_char_value_flag());
			
			if(compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().
			getasd_char_value_flag().equalsIgnoreCase("Y"))
			{
			
			/*End*/
				
				
			helper.WHEN_VALIDATE_M_BUT_APPROVE(compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN(),
					compositeAction);
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Approved successfully");
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getWarningMap().put("Approve","Approved successfully");
			
			/*Added by Janani on 11.07.2017 for ZBILQC-1719675*/

			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().onLoad(null);
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().setBlockFlag(true);
			
			System.out.println("after onload call in approve button");
			compositeAction.getPT_IL_RECEIPT_TRANS_DTL_ACTION_BEAN().disableAllComponent(true);
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().disableAllComponent(true);
			
			
			}
			else
			{
				compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"User not authorized to approve");
				compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getErrorMap().put("Approve","User not authorized to approve");
			}
			
			/*End*/
			
		}
		catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			compositeAction.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
		}
		return null;
	}
	 
	

}
