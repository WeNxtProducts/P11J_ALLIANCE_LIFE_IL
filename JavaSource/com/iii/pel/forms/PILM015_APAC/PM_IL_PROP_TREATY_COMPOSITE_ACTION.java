package com.iii.pel.forms.PILM015_APAC;

import javax.faces.component.html.HtmlCommandButton;

import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;

public class PM_IL_PROP_TREATY_COMPOSITE_ACTION {

	PM_IL_PROP_TREATY_ACTION PM_IL_PROP_TREATY_ACTION;

	PM_IL_PROP_TREATY_TYPE_ACTION PM_IL_PROP_TREATY_TYPE_ACTION;

	PM_IL_PROP_TREATY_COVER_ACTION PM_IL_PROP_TREATY_COVER_ACTION;

	PM_IL_PROP_TREATY_PART_CUST_ACTION PM_IL_PROP_TREATY_PART_CUST_ACTION;

	PM_IL_MED_EXAM_HDR_ACTION PM_IL_MED_EXAM_HDR_ACTION;

	PM_IL_MED_EXAM_DTL_ACTION PM_IL_MED_EXAM_DTL_ACTION;

	PM_IL_HTWT_DTL_ACTION PM_IL_HTWT_DTL_ACTION;

	PM_IL_PROP_TREATY_TYPE_CVR_ACTION PM_IL_PROP_TREATY_TYPE_CVR_ACTION;

	PM_IL_PROP_TTYCOV_GRP_ACTION PM_IL_PROP_TTYCOV_GRP_ACTION;

	PM_IL_PROP_TREATY_PERIOD_ACTION PM_IL_PROP_TREATY_PERIOD_ACTION;
	
	CTRL_1_ACTION CTRL_1_ACTION;
	
	private UIWizard wizard;

	private TabbedBar tabbedBar;

	public static final int PM_IL_PROP_TREATY_TAB_PAGE_ID = 1;

	public static final int PM_IL_PROP_TREATY_TYPE_TAB_PAGE_ID = 2;

	public static final int PM_IL_PROP_TREATY_HT_WT_DETAILS_TAB_PAGE_ID = 3;

	public static final int PM_IL_PROP_TREATY_MEDICAL_EXAM_DETIALS = 4;
	
	// [BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied	
	public static final int PM_IL_PROP_TREATY_PERIOD = 5;
// BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied	]
	
	private boolean COMP_PTC_SUB_STD_TARIFF_DISABLE_FLAG=false;

	public PM_IL_PROP_TREATY_COMPOSITE_ACTION() {

		tabbedBar = new TabbedBar();
		try {
			// Adding tabs
			// id action value disabled
			//COMMENTED FOR WIZARD IMPLEMENTATION
			/*tabbedBar.addTab(PM_IL_PROP_TREATY_TAB_PAGE_ID,
					"#{PM_IL_PROP_TREATY_COMPOSITE_ACTION.callTreatyMaster}",
					MessagePropertyManager
							.getValue("Tab_Navigation_TreatyMaster"), false);
			tabbedBar.addTab(PM_IL_PROP_TREATY_TYPE_TAB_PAGE_ID,
					"#{PM_IL_PROP_TREATY_COMPOSITE_ACTION.callTreatyType}",
					MessagePropertyManager
							.getValue("Tab_Navigation_TreatyType"), false);
			tabbedBar.addTab(PM_IL_PROP_TREATY_HT_WT_DETAILS_TAB_PAGE_ID,
					"#{PM_IL_PROP_TREATY_COMPOSITE_ACTION.callHtWtDetails}",
					MessagePropertyManager
							.getValue("Tab_Navigation_HtWtDetails"), false);
			tabbedBar
					.addTab(
							PM_IL_PROP_TREATY_MEDICAL_EXAM_DETIALS,
							"#{PM_IL_PROP_TREATY_COMPOSITE_ACTION.callMedicalExamDetails}",
							MessagePropertyManager
									.getValue("Tab_Navigation_MedicalExamDetails"),
							false);*/
			// [BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied				
			/*tabbedBar.addTab(PM_IL_PROP_TREATY_PERIOD,
					"#{PM_IL_PROP_TREATY_COMPOSITE_ACTION.callTreatyPeriod}",
					MessagePropertyManager
					.getValue("Tab_Navigation_TreatyPeriod"),
					false);*/
// BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied	 ]						
		} catch (Exception e) {
			e.printStackTrace();

		}

		PM_IL_PROP_TREATY_ACTION = new PM_IL_PROP_TREATY_ACTION();
		PM_IL_PROP_TREATY_TYPE_ACTION = new PM_IL_PROP_TREATY_TYPE_ACTION();
		PM_IL_PROP_TREATY_COVER_ACTION = new PM_IL_PROP_TREATY_COVER_ACTION();
		PM_IL_PROP_TREATY_PART_CUST_ACTION = new PM_IL_PROP_TREATY_PART_CUST_ACTION();
		PM_IL_MED_EXAM_HDR_ACTION = new PM_IL_MED_EXAM_HDR_ACTION();
		PM_IL_MED_EXAM_DTL_ACTION = new PM_IL_MED_EXAM_DTL_ACTION();
		PM_IL_HTWT_DTL_ACTION = new PM_IL_HTWT_DTL_ACTION();
		PM_IL_PROP_TREATY_TYPE_CVR_ACTION = new PM_IL_PROP_TREATY_TYPE_CVR_ACTION();
		PM_IL_PROP_TTYCOV_GRP_ACTION = new PM_IL_PROP_TTYCOV_GRP_ACTION();
		PM_IL_PROP_TREATY_PERIOD_ACTION = new PM_IL_PROP_TREATY_PERIOD_ACTION();
		CTRL_1_ACTION = new CTRL_1_ACTION();
		
		PM_IL_PROP_TREATY_ACTION.compositeAction = this;
		PM_IL_PROP_TREATY_TYPE_ACTION.compositeAction = this;
		PM_IL_PROP_TREATY_COVER_ACTION.compositeAction = this;
		PM_IL_PROP_TREATY_PART_CUST_ACTION.compositeAction = this;
		PM_IL_MED_EXAM_HDR_ACTION.compositeAction = this;
		PM_IL_MED_EXAM_DTL_ACTION.compositeAction = this;
		PM_IL_HTWT_DTL_ACTION.compositeAction = this;
		PM_IL_PROP_TREATY_TYPE_CVR_ACTION.compositeAction = this;
		PM_IL_PROP_TTYCOV_GRP_ACTION.compositeAction = this;
		PM_IL_PROP_TREATY_PERIOD_ACTION.compositeAction = this;
		CTRL_1_ACTION.compositeAction = this;

	}

	public PM_IL_PROP_TREATY_ACTION getPM_IL_PROP_TREATY_ACTION() {
		return PM_IL_PROP_TREATY_ACTION;
	}

	public void setPM_IL_PROP_TREATY_ACTION(
			PM_IL_PROP_TREATY_ACTION pm_il_prop_treaty_action) {
		PM_IL_PROP_TREATY_ACTION = pm_il_prop_treaty_action;
	}

	public PM_IL_PROP_TREATY_TYPE_ACTION getPM_IL_PROP_TREATY_TYPE_ACTION() {
		return PM_IL_PROP_TREATY_TYPE_ACTION;
	}

	public void setPM_IL_PROP_TREATY_TYPE_ACTION(
			PM_IL_PROP_TREATY_TYPE_ACTION pm_il_prop_treaty_type_action) {
		PM_IL_PROP_TREATY_TYPE_ACTION = pm_il_prop_treaty_type_action;
	}

	public PM_IL_PROP_TREATY_COVER_ACTION getPM_IL_PROP_TREATY_COVER_ACTION() {
		return PM_IL_PROP_TREATY_COVER_ACTION;
	}

	public void setPM_IL_PROP_TREATY_COVER_ACTION(
			PM_IL_PROP_TREATY_COVER_ACTION pm_il_prop_treaty_cover_action) {
		PM_IL_PROP_TREATY_COVER_ACTION = pm_il_prop_treaty_cover_action;
	}

	public PM_IL_PROP_TREATY_PART_CUST_ACTION getPM_IL_PROP_TREATY_PART_CUST_ACTION() {
		return PM_IL_PROP_TREATY_PART_CUST_ACTION;
	}

	public void setPM_IL_PROP_TREATY_PART_CUST_ACTION(
			PM_IL_PROP_TREATY_PART_CUST_ACTION PM_IL_PROP_TREATY_PART_CUST_ACTION) {
		PM_IL_PROP_TREATY_PART_CUST_ACTION = PM_IL_PROP_TREATY_PART_CUST_ACTION;
	}

	public PM_IL_MED_EXAM_HDR_ACTION getPM_IL_MED_EXAM_HDR_ACTION() {
		return PM_IL_MED_EXAM_HDR_ACTION;
	}

	public void setPM_IL_MED_EXAM_HDR_ACTION(
			PM_IL_MED_EXAM_HDR_ACTION pm_il_med_exam_hdr_action) {
		PM_IL_MED_EXAM_HDR_ACTION = pm_il_med_exam_hdr_action;
	}

	public PM_IL_MED_EXAM_DTL_ACTION getPM_IL_MED_EXAM_DTL_ACTION() {
		return PM_IL_MED_EXAM_DTL_ACTION;
	}

	public void setPM_IL_MED_EXAM_DTL_ACTION(
			PM_IL_MED_EXAM_DTL_ACTION pm_il_med_exam_dtl_action) {
		PM_IL_MED_EXAM_DTL_ACTION = pm_il_med_exam_dtl_action;
	}

	public PM_IL_HTWT_DTL_ACTION getPM_IL_HTWT_DTL_ACTION() {
		return PM_IL_HTWT_DTL_ACTION;
	}

	public void setPM_IL_HTWT_DTL_ACTION(
			PM_IL_HTWT_DTL_ACTION pm_il_htwt_dtl_action) {
		PM_IL_HTWT_DTL_ACTION = pm_il_htwt_dtl_action;
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public String callTreatyMaster() {
		System.out.println("Method Called");
		return "TreatyMaster";
	}

	public String callTreatyType() {
		getPM_IL_PROP_TREATY_TYPE_ACTION().setOnLoadFlag(false);
		String name = null;
		try {
			getPM_IL_PROP_TREATY_ACTION().insertAction();
			name = getPM_IL_PROP_TREATY_TYPE_ACTION()
					.fetchTreatyTypeList();
			String PT_RIDER_RI_BASIS = getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN().getPT_RIDER_RI_BASIS();
			if((PT_RIDER_RI_BASIS==null?"":PT_RIDER_RI_BASIS).equals("S")){
				if(getPM_IL_PROP_TREATY_TYPE_ACTION().getCOMP_BUTTON_TYPE_TTY_COVER_DETIALS()!=null)
					getPM_IL_PROP_TREATY_TYPE_ACTION().getCOMP_BUTTON_TYPE_TTY_COVER_DETIALS().setDisabled(true);
				else{
					HtmlCommandButton cb = new HtmlCommandButton();
					cb.setDisabled(true);
					getPM_IL_PROP_TREATY_TYPE_ACTION().setCOMP_BUTTON_TYPE_TTY_COVER_DETIALS(cb);
				}
			}else if((PT_RIDER_RI_BASIS==null?"":PT_RIDER_RI_BASIS).equals("B")){
				if(getPM_IL_PROP_TREATY_TYPE_ACTION().getCOMP_BUTTON_TYPE_TTY_COVER_DETIALS()!=null)
					getPM_IL_PROP_TREATY_TYPE_ACTION().getCOMP_BUTTON_TYPE_TTY_COVER_DETIALS().setDisabled(false);
				else{
					HtmlCommandButton cb = new HtmlCommandButton();
					cb.setDisabled(false);
					getPM_IL_PROP_TREATY_TYPE_ACTION().setCOMP_BUTTON_TYPE_TTY_COVER_DETIALS(cb);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getPM_IL_PROP_TREATY_ACTION().getErrorMap().put("current", e.getMessage());
			getPM_IL_PROP_TREATY_ACTION().setErrorMessages(e.getMessage());
		}
		return name;
	}

	public String callHtWtDetails() {
		return "HtWtDetails";

	}
	// [BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied	
	public String callTreatyPeriod() {
		try {
			this.getPM_IL_PROP_TREATY_PERIOD_ACTION().selectValues();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "TreatyPeriod";
	}
// BugId:PREMIAGDC-266172 MMuthu 09-Jan-09 When treaty is copied, treaty account period submission also copied ]

	public String callMedicalExamDetails() {
		String medName = this.getPM_IL_MED_EXAM_HDR_ACTION().onPageLoad();

		return medName;
	}

	public PM_IL_PROP_TREATY_TYPE_CVR_ACTION getPM_IL_PROP_TREATY_TYPE_CVR_ACTION() {
		return PM_IL_PROP_TREATY_TYPE_CVR_ACTION;
	}

	public void setPM_IL_PROP_TREATY_TYPE_CVR_ACTION(
			PM_IL_PROP_TREATY_TYPE_CVR_ACTION pm_il_prop_treaty_type_cvr_action) {
		PM_IL_PROP_TREATY_TYPE_CVR_ACTION = pm_il_prop_treaty_type_cvr_action;
	}

	public PM_IL_PROP_TTYCOV_GRP_ACTION getPM_IL_PROP_TTYCOV_GRP_ACTION() {
		return PM_IL_PROP_TTYCOV_GRP_ACTION;
	}

	public void setPM_IL_PROP_TTYCOV_GRP_ACTION(
			PM_IL_PROP_TTYCOV_GRP_ACTION pm_il_prop_ttycov_grp_action) {
		PM_IL_PROP_TTYCOV_GRP_ACTION = pm_il_prop_ttycov_grp_action;
	}

	public PM_IL_PROP_TREATY_PERIOD_ACTION getPM_IL_PROP_TREATY_PERIOD_ACTION() {
		return PM_IL_PROP_TREATY_PERIOD_ACTION;
	}

	public void setPM_IL_PROP_TREATY_PERIOD_ACTION(
			PM_IL_PROP_TREATY_PERIOD_ACTION pm_il_prop_treaty_period_action) {
		PM_IL_PROP_TREATY_PERIOD_ACTION = pm_il_prop_treaty_period_action;
	}

	public boolean isCOMP_PTC_SUB_STD_TARIFF_DISABLE_FLAG() {
		return COMP_PTC_SUB_STD_TARIFF_DISABLE_FLAG;
	}

	public void setCOMP_PTC_SUB_STD_TARIFF_DISABLE_FLAG(
			boolean comp_ptc_sub_std_tariff_disable_flag) {
		COMP_PTC_SUB_STD_TARIFF_DISABLE_FLAG = comp_ptc_sub_std_tariff_disable_flag;
	}

	public CTRL_1_ACTION getCTRL_1_ACTION() {
		return CTRL_1_ACTION;
	}

	public void setCTRL_1_ACTION(CTRL_1_ACTION ctrl_1_action) {
		CTRL_1_ACTION = ctrl_1_action;
	}

	public UIWizard getWizard() {
		return wizard;
	}

	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
	}
	
	public String navigationEnabled() {
		//setImmediate(true);
		getWizard().setImmediate("true");
		return "";

	}
	
	public String backTreatyType(){
		return "TreatyType";
	}
	
	public String backMedExamHead(){
		String outcome = "medicalHeader";
		return outcome;
		
	}
	
	public String backCover(){
		String outcome = "DetailCoverGroup";
		return outcome;
	}
}
