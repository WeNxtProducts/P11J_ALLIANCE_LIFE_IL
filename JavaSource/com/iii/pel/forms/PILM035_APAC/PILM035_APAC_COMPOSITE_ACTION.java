package com.iii.pel.forms.PILM035_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.pel.commonimpl.summaryimpl.UISummary;
import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;
import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.errorUtil.Messages;

public class PILM035_APAC_COMPOSITE_ACTION {
	public final static int TAB_PM_IL_PRODUCT = 1;
	public final static int TAB_PM_IL_PROD_APPL_CVR_GRP = 2;
	public final static int TAB_PM_IL_PROD_APPL_COVER = 3;
	public final static int TAB_PM_IL_PROD_APPL_COND = 4;
	public final static int TAB_PM_IL_SA_INST_PYMT = 5;
	public final static int TAB_PM_IL_SA_INST_PYMT1 = 6;
	public final static int TAB_PM_IL_SA_INST_PYMT2 = 7;
	public final static int TAB_PM_IL_PROD_APPL_BONUS = 8;
	public final static int TAB_PM_IL_PROD_APPL_LOAD_TARIFF = 9;
	public final static int TAB_PM_IL_PROD_PREM_LIMIT = 10;
	public final static int TAB_PM_IL_PROD_APPL_FUND = 11;
	public final static int TAB_PM_IL_PROD_PA_BENEFIT = 12;
	public final static int TAB_PM_IL_PROD_INVEST_PREM_DEDC = 13;
	public final static int TAB_PM_IL_PROD_CONTRI_CHARGE = 14;
	//Added by sankar
	public final static int TAB_PM_IL_PROD_INTREST = 15;
	
	private TabbedBar tabbedBar;
	private PM_IL_PRODUCT_ACTION PM_IL_PRODUCT_ACTION_BEAN;
	private PM_IL_PROD_APPL_CVR_GRP_ACTION PM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN;
	private PM_IL_PROD_APPL_COVER_ACTION PM_IL_PROD_APPL_COVER_ACTION_BEAN;
	private PM_IL_PROD_APPL_COVER_1_ACTION PM_IL_PROD_APPL_COVER_1_ACTION_BEAN;
	private PM_IL_PROD_APPL_COND_ACTION PM_IL_PROD_APPL_COND_ACTION_BEAN;
	private PM_IL_SA_INST_PYMT_ACTION PM_IL_SA_INST_PYMT_ACTION_BEAN;
	private PM_IL_SA_INST_PYMT1_ACTION PM_IL_SA_INST_PYMT1_ACTION_BEAN;
	private PM_IL_SA_INST_PYMT2_ACTION PM_IL_SA_INST_PYMT2_ACTION_BEAN;
	private PM_IL_PROD_WD_PARAM_HDR_ACTION PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN;
	private PM_IL_PROD_WD_PARAM_DTL_ACTION PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN;
	private PM_IL_PROD_APPL_BONUS_ACTION PM_IL_PROD_APPL_BONUS_ACTION_BEAN;
	private PM_IL_PROD_APPL_LOAD_TARIFF_ACTION PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN;
	private PM_IL_PROD_PREM_LIMIT_ACTION PM_IL_PROD_PREM_LIMIT_ACTION_BEAN;
	private PM_IL_PROD_APPL_FUND_ACTION PM_IL_PROD_APPL_FUND_ACTION_BEAN;
	private PM_IL_PROD_APPL_FUND_1_ACTION PM_IL_PROD_APPL_FUND_1_ACTION_BEAN;
	private PM_IL_TOP_UP_CHARGE_ACTION PM_IL_TOP_UP_CHARGE_ACTION_BEAN;
	private PM_IL_PROD_TOPUP_PARAM_ACTION PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN;
	private PM_IL_PROD_APPL_PLANS_ACTION PM_IL_PROD_APPL_PLANS_ACTION_BEAN;
	private PM_IL_PROD_ANNUITY_ACTION PM_IL_PROD_ANNUITY_ACTION_BEAN;
	private PM_IL_PROD_PA_BENEFIT_ACTION PM_IL_PROD_PA_BENEFIT_ACTION_BEAN;
	private PM_IL_PROD_INSURER_ACTION PM_IL_PROD_INSURER_ACTION_BEAN;
	private PM_IL_PROD_INVEST_PREM_DEDC_ACTION PM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN;
	private PM_IL_PROD_CONTRI_CHARGE_ACTION PM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN;
	/*Added by sankaranarayanan on 21/04/2017*/
	private PM_IL_PROD_INTREST_ACTION PM_IL_PROD_INTREST_ACTION_BEAN;
	
	private PM_IL_PROD_CASHBCK_INT_ACTION PM_IL_PROD_CASHBCK_INT_ACTION_BEAN;
	
	
	public PM_IL_PROD_CASHBCK_INT_ACTION getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN() {
		return PM_IL_PROD_CASHBCK_INT_ACTION_BEAN;
	}
	public void setPM_IL_PROD_CASHBCK_INT_ACTION_BEAN(
			PM_IL_PROD_CASHBCK_INT_ACTION pM_IL_PROD_CASHBCK_INT_ACTION_BEAN) {
		PM_IL_PROD_CASHBCK_INT_ACTION_BEAN = pM_IL_PROD_CASHBCK_INT_ACTION_BEAN;
	}
	public PM_IL_PROD_INTREST_ACTION getPM_IL_PROD_INTREST_ACTION_BEAN() {
		return PM_IL_PROD_INTREST_ACTION_BEAN;
	}
	public void setPM_IL_PROD_INTREST_ACTION_BEAN(
			PM_IL_PROD_INTREST_ACTION pM_IL_PROD_INTREST_ACTION_BEAN) {
		PM_IL_PROD_INTREST_ACTION_BEAN = pM_IL_PROD_INTREST_ACTION_BEAN;
	}
	/*end*/
	/*Added by saranya on 30/12/2016 for RM018T - FSD_IL_ZB Life_028-Cash Back*/

	private PM_IL_PRODUCT_UPLOAD_ACTION PM_IL_PRODUCT_UPLOAD_ACTION_BEAN;
	
	
	private PM_IL_PROD_CASHBACK_ACTION PM_IL_PROD_CASHBACK_ACTION_BEAN;

	public PM_IL_PROD_CASHBACK_ACTION getPM_IL_PROD_CASHBACK_ACTION_BEAN() {
		return PM_IL_PROD_CASHBACK_ACTION_BEAN;
	}
	public void setPM_IL_PROD_CASHBACK_ACTION_BEAN(
			PM_IL_PROD_CASHBACK_ACTION pM_IL_PROD_CASHBACK_ACTION_BEAN) {
		PM_IL_PROD_CASHBACK_ACTION_BEAN = pM_IL_PROD_CASHBACK_ACTION_BEAN;
	}

	/*End*/
	//ADDED BY SARANYA for ssp call id FALCONQC-1714541
	private PM_IL_PROD_APPL_SURRENDER_ACTION PM_IL_PROD_APPL_SURRENDER_ACTION_BEAN;
	
	public PM_IL_PROD_APPL_SURRENDER_ACTION getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN() {
		return PM_IL_PROD_APPL_SURRENDER_ACTION_BEAN;
	}
	public void setPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN(
			PM_IL_PROD_APPL_SURRENDER_ACTION pM_IL_PROD_APPL_SURRENDER_ACTION_BEAN) {
		PM_IL_PROD_APPL_SURRENDER_ACTION_BEAN = pM_IL_PROD_APPL_SURRENDER_ACTION_BEAN;
	}

	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	private UIWizard wizard=null;
	private UISummary comp=null;

	public String callPM_IL_PRODUCT() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PRODUCT";

	}
	public String callPM_IL_PROD_SURRENDER() {
		preTabClick();
		return "PILM035_APAC_SURRENDER";

	}
	/*Added by saranya for RM018T - FSD_IL_ZB Life_028-Cash Back on 05-02-2017*/
	public String callPM_IL_PROD_CASHBACK() {
		preTabClick();
		return "PILM035_APAC_CASHBACK";

	}
	/*End*/
	public String callPM_IL_PROD_ANNUITY() {
		return "PILM035_APAC_PM_IL_PRODUCT_ANNUITY";
	}

	public String callPM_IL_PROD_APPL_COVER() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_APPL_COVER";

	}

	public String callPM_IL_PROD_APPL_COVER_1() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_APPL_COVER_1";

	}

	public String callPM_IL_PROD_APPL_COND() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_APPL_COND";

	}

	public String callPM_IL_SA_INST_PYMT() {
		preTabClick();
		return "PILM035_APAC_PM_IL_SA_INST_PYMT";

	}

	public String callPM_IL_SA_INST_PYMT1() {
		preTabClick();
		return "PILM035_APAC_PM_IL_SA_INST_PYMT1";

	}

	public String callPM_IL_SA_INST_PYMT2() {
		preTabClick();
		return "PILM035_APAC_PM_IL_SA_INST_PYMT2";

	}

	public String callPM_IL_PROD_WD_PARAM_HDR() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_WD_PARAM_HDR";

	}

	public String callPM_IL_PROD_WD_PARAM_DTL() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_WD_PARAM_DTL";

	}

	public String callPM_IL_PROD_APPL_BONUS() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_APPL_BONUS";

	}

	public String callPM_IL_PROD_APPL_LOAD_TARIFF() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_APPL_LOAD_TARIFF";

	}

	public String callPM_IL_PROD_PREM_LIMIT() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_PREM_LIMIT";

	}

	public String callPM_IL_PROD_APPL_FUND() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_APPL_FUND";

	}

	public String callPM_IL_PROD_APPL_FUND_1() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_APPL_FUND_1";

	}
	
	public String callPM_IL_PROD_APPL_INSURER() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_APPL_INSURER";

	}

	public String callPM_IL_TOP_UP_CHARGE() {
		preTabClick();
		return "PILM035_APAC_PM_IL_TOP_UP_CHARGE";

	}

	public String callPM_IL_PROD_TOPUP_PARAM() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_TOPUP_PARAM";

	}

	public String callPM_IL_PROD_APPL_PLANS() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_APPL_PLANS";

	}

	public String callPM_IL_PROD_PA_BENEFIT() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_PA_BENEFIT";

	}
	
	public String callPM_IL_PROD_APPL_CVR_GRP() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_APPL_CVR_GRP";

	}
	
	public String callPM_IL_PROD_ANUITY() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_ANUITY";
	}
	
	public String callPM_IL_PROD_INVEST_PREM_DEDC() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_INVEST_PREM_DEDC";
	}
	public String callPM_IL_PROD_CONTRI_CHARGE() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_CONTRI_CHARGE";
	}
	
	
	

	public String callCTRL() {
		preTabClick();
		return "PILM035_APAC_CTRL";

	}

	public String callBP() {
		preTabClick();
		return "PILM035_APAC_BP";

	}

	public String navigationEnabled() {
		//setImmediate(true);
		getPM_IL_PROD_APPL_COVER_ACTION_BEAN().getErrorMap().clear();
		getWizard().setImmediate("true");
		return "";

	}

	public String navigationintrestEnabled() {
		//setImmediate(true);
		getPM_IL_PROD_INTREST_ACTION_BEAN().getErrorMap().clear();
		getWizard().setImmediate("true");
		return "";

	}
	private void setImmediate(boolean flag) {
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
			TabItem item = tabIterator.next();
			item.setImmediate(flag);

		}

	}

	private void preTabClick() {
		int currentTabId = tabbedBar.getCurrentTabId();
		switch (currentTabId) {
		case 1:
			PM_IL_PRODUCT_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 2:
			PM_IL_PROD_APPL_COVER_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 3:
			PM_IL_PROD_APPL_COVER_1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 4:
			PM_IL_PROD_APPL_COND_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 5:
			PM_IL_SA_INST_PYMT_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 6:
			PM_IL_SA_INST_PYMT1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 7:
			PM_IL_SA_INST_PYMT2_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 8:
			PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 9:
			PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 10:
			PM_IL_PROD_APPL_BONUS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 11:
			PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 12:
			PM_IL_PROD_PREM_LIMIT_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 13:
			PM_IL_PROD_APPL_FUND_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 14:
			PM_IL_PROD_APPL_FUND_1_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 15:
			PM_IL_TOP_UP_CHARGE_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 16:
			PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 17:
			PM_IL_PROD_APPL_PLANS_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 18:
			PM_IL_PROD_PA_BENEFIT_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 19 :
			PM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;
		case 20 :
			PM_IL_PRODUCT_UPLOAD_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;	
			//added by sankar
		case 21 :
			PM_IL_PROD_INTREST_ACTION_BEAN.setBlockFlag(true);
			setImmediate(false);
			break;	
			
		}

	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;

	}

	public TabbedBar getTabbedBar() {
		return this.tabbedBar;

	}

	public void setPM_IL_PRODUCT_ACTION_BEAN(
			PM_IL_PRODUCT_ACTION PM_IL_PRODUCT_ACTION_BEAN) {
		this.PM_IL_PRODUCT_ACTION_BEAN = PM_IL_PRODUCT_ACTION_BEAN;

	}

	public PM_IL_PRODUCT_ACTION getPM_IL_PRODUCT_ACTION_BEAN() {
		return this.PM_IL_PRODUCT_ACTION_BEAN;

	}

	public void setPM_IL_PROD_APPL_COVER_ACTION_BEAN(
			PM_IL_PROD_APPL_COVER_ACTION PM_IL_PROD_APPL_COVER_ACTION_BEAN) {
		this.PM_IL_PROD_APPL_COVER_ACTION_BEAN = PM_IL_PROD_APPL_COVER_ACTION_BEAN;

	}

	public PM_IL_PROD_APPL_COVER_ACTION getPM_IL_PROD_APPL_COVER_ACTION_BEAN() {
		return this.PM_IL_PROD_APPL_COVER_ACTION_BEAN;

	}

	public void setPM_IL_PROD_APPL_COVER_1_ACTION_BEAN(
			PM_IL_PROD_APPL_COVER_1_ACTION PM_IL_PROD_APPL_COVER_1_ACTION_BEAN) {
		this.PM_IL_PROD_APPL_COVER_1_ACTION_BEAN = PM_IL_PROD_APPL_COVER_1_ACTION_BEAN;

	}

	public PM_IL_PROD_APPL_COVER_1_ACTION getPM_IL_PROD_APPL_COVER_1_ACTION_BEAN() {
		return this.PM_IL_PROD_APPL_COVER_1_ACTION_BEAN;

	}

	public void setPM_IL_PROD_APPL_COND_ACTION_BEAN(
			PM_IL_PROD_APPL_COND_ACTION PM_IL_PROD_APPL_COND_ACTION_BEAN) {
		this.PM_IL_PROD_APPL_COND_ACTION_BEAN = PM_IL_PROD_APPL_COND_ACTION_BEAN;

	}

	public PM_IL_PROD_APPL_COND_ACTION getPM_IL_PROD_APPL_COND_ACTION_BEAN() {
		return this.PM_IL_PROD_APPL_COND_ACTION_BEAN;

	}

	public void setPM_IL_SA_INST_PYMT_ACTION_BEAN(
			PM_IL_SA_INST_PYMT_ACTION PM_IL_SA_INST_PYMT_ACTION_BEAN) {
		this.PM_IL_SA_INST_PYMT_ACTION_BEAN = PM_IL_SA_INST_PYMT_ACTION_BEAN;

	}

	public PM_IL_SA_INST_PYMT_ACTION getPM_IL_SA_INST_PYMT_ACTION_BEAN() {
		return this.PM_IL_SA_INST_PYMT_ACTION_BEAN;

	}

	public void setPM_IL_SA_INST_PYMT1_ACTION_BEAN(
			PM_IL_SA_INST_PYMT1_ACTION PM_IL_SA_INST_PYMT1_ACTION_BEAN) {
		this.PM_IL_SA_INST_PYMT1_ACTION_BEAN = PM_IL_SA_INST_PYMT1_ACTION_BEAN;

	}

	public PM_IL_SA_INST_PYMT1_ACTION getPM_IL_SA_INST_PYMT1_ACTION_BEAN() {
		return this.PM_IL_SA_INST_PYMT1_ACTION_BEAN;

	}

	public void setPM_IL_SA_INST_PYMT2_ACTION_BEAN(
			PM_IL_SA_INST_PYMT2_ACTION PM_IL_SA_INST_PYMT2_ACTION_BEAN) {
		this.PM_IL_SA_INST_PYMT2_ACTION_BEAN = PM_IL_SA_INST_PYMT2_ACTION_BEAN;

	}

	public PM_IL_SA_INST_PYMT2_ACTION getPM_IL_SA_INST_PYMT2_ACTION_BEAN() {
		return this.PM_IL_SA_INST_PYMT2_ACTION_BEAN;

	}

	public void setPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN(
			PM_IL_PROD_WD_PARAM_HDR_ACTION PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN) {
		this.PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN = PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN;

	}

	public PM_IL_PROD_WD_PARAM_HDR_ACTION getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN() {
		return this.PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN;

	}

	public void setPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN(
			PM_IL_PROD_WD_PARAM_DTL_ACTION PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN) {
		this.PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN = PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN;

	}

	public PM_IL_PROD_WD_PARAM_DTL_ACTION getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN() {
		return this.PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN;

	}

	public void setPM_IL_PROD_APPL_BONUS_ACTION_BEAN(
			PM_IL_PROD_APPL_BONUS_ACTION PM_IL_PROD_APPL_BONUS_ACTION_BEAN) {
		this.PM_IL_PROD_APPL_BONUS_ACTION_BEAN = PM_IL_PROD_APPL_BONUS_ACTION_BEAN;

	}

	public PM_IL_PROD_APPL_BONUS_ACTION getPM_IL_PROD_APPL_BONUS_ACTION_BEAN() {
		return this.PM_IL_PROD_APPL_BONUS_ACTION_BEAN;

	}

	public void setPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN(
			PM_IL_PROD_APPL_LOAD_TARIFF_ACTION PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN) {
		this.PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN = PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN;

	}

	public PM_IL_PROD_APPL_LOAD_TARIFF_ACTION getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN() {
		return this.PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN;

	}

	public void setPM_IL_PROD_PREM_LIMIT_ACTION_BEAN(
			PM_IL_PROD_PREM_LIMIT_ACTION PM_IL_PROD_PREM_LIMIT_ACTION_BEAN) {
		this.PM_IL_PROD_PREM_LIMIT_ACTION_BEAN = PM_IL_PROD_PREM_LIMIT_ACTION_BEAN;

	}

	public PM_IL_PROD_PREM_LIMIT_ACTION getPM_IL_PROD_PREM_LIMIT_ACTION_BEAN() {
		return this.PM_IL_PROD_PREM_LIMIT_ACTION_BEAN;

	}

	public void setPM_IL_PROD_APPL_FUND_ACTION_BEAN(
			PM_IL_PROD_APPL_FUND_ACTION PM_IL_PROD_APPL_FUND_ACTION_BEAN) {
		this.PM_IL_PROD_APPL_FUND_ACTION_BEAN = PM_IL_PROD_APPL_FUND_ACTION_BEAN;

	}

	public PM_IL_PROD_APPL_FUND_ACTION getPM_IL_PROD_APPL_FUND_ACTION_BEAN() {
		return this.PM_IL_PROD_APPL_FUND_ACTION_BEAN;

	}

	public void setPM_IL_PROD_APPL_FUND_1_ACTION_BEAN(
			PM_IL_PROD_APPL_FUND_1_ACTION PM_IL_PROD_APPL_FUND_1_ACTION_BEAN) {
		this.PM_IL_PROD_APPL_FUND_1_ACTION_BEAN = PM_IL_PROD_APPL_FUND_1_ACTION_BEAN;

	}

	public PM_IL_PROD_APPL_FUND_1_ACTION getPM_IL_PROD_APPL_FUND_1_ACTION_BEAN() {
		return this.PM_IL_PROD_APPL_FUND_1_ACTION_BEAN;

	}

	public void setPM_IL_TOP_UP_CHARGE_ACTION_BEAN(
			PM_IL_TOP_UP_CHARGE_ACTION PM_IL_TOP_UP_CHARGE_ACTION_BEAN) {
		this.PM_IL_TOP_UP_CHARGE_ACTION_BEAN = PM_IL_TOP_UP_CHARGE_ACTION_BEAN;

	}

	public PM_IL_TOP_UP_CHARGE_ACTION getPM_IL_TOP_UP_CHARGE_ACTION_BEAN() {
		return this.PM_IL_TOP_UP_CHARGE_ACTION_BEAN;

	}

	public void setPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN(
			PM_IL_PROD_TOPUP_PARAM_ACTION PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN) {
		this.PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN = PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN;

	}

	public PM_IL_PROD_TOPUP_PARAM_ACTION getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN() {
		return this.PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN;

	}

	public void setPM_IL_PROD_APPL_PLANS_ACTION_BEAN(
			PM_IL_PROD_APPL_PLANS_ACTION PM_IL_PROD_APPL_PLANS_ACTION_BEAN) {
		this.PM_IL_PROD_APPL_PLANS_ACTION_BEAN = PM_IL_PROD_APPL_PLANS_ACTION_BEAN;

	}

	public PM_IL_PROD_APPL_PLANS_ACTION getPM_IL_PROD_APPL_PLANS_ACTION_BEAN() {
		return this.PM_IL_PROD_APPL_PLANS_ACTION_BEAN;

	}

	public void setPM_IL_PROD_PA_BENEFIT_ACTION_BEAN(
			PM_IL_PROD_PA_BENEFIT_ACTION PM_IL_PROD_PA_BENEFIT_ACTION_BEAN) {
		this.PM_IL_PROD_PA_BENEFIT_ACTION_BEAN = PM_IL_PROD_PA_BENEFIT_ACTION_BEAN;

	}

	public PM_IL_PROD_PA_BENEFIT_ACTION getPM_IL_PROD_PA_BENEFIT_ACTION_BEAN() {
		return this.PM_IL_PROD_PA_BENEFIT_ACTION_BEAN;

	}

	
	
	
	/*Added By Dhinesh on 1.3.2017*/

	public PM_IL_PRODUCT_UPLOAD_ACTION getPM_IL_PRODUCT_UPLOAD_ACTION_BEAN() {
		return PM_IL_PRODUCT_UPLOAD_ACTION_BEAN;
	}
	public void setPM_IL_PRODUCT_UPLOAD_ACTION_BEAN(
			PM_IL_PRODUCT_UPLOAD_ACTION pM_IL_PRODUCT_UPLOAD_ACTION_BEAN) {
		PM_IL_PRODUCT_UPLOAD_ACTION_BEAN = pM_IL_PRODUCT_UPLOAD_ACTION_BEAN;
	}
	
	/*End*/
	
	public PILM035_APAC_COMPOSITE_ACTION() {
		tabbedBar = new TabbedBar();
		PM_IL_PRODUCT_ACTION_BEAN = new PM_IL_PRODUCT_ACTION();
		PM_IL_PROD_APPL_COVER_ACTION_BEAN = new PM_IL_PROD_APPL_COVER_ACTION();
		PM_IL_PROD_APPL_COVER_1_ACTION_BEAN = new PM_IL_PROD_APPL_COVER_1_ACTION();
		PM_IL_PROD_APPL_COND_ACTION_BEAN = new PM_IL_PROD_APPL_COND_ACTION();
		PM_IL_SA_INST_PYMT_ACTION_BEAN = new PM_IL_SA_INST_PYMT_ACTION();
		PM_IL_SA_INST_PYMT1_ACTION_BEAN = new PM_IL_SA_INST_PYMT1_ACTION();
		PM_IL_SA_INST_PYMT2_ACTION_BEAN = new PM_IL_SA_INST_PYMT2_ACTION();
		PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN = new PM_IL_PROD_WD_PARAM_HDR_ACTION();
		PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN = new PM_IL_PROD_WD_PARAM_DTL_ACTION();
		PM_IL_PROD_APPL_BONUS_ACTION_BEAN = new PM_IL_PROD_APPL_BONUS_ACTION();
		PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN = new PM_IL_PROD_APPL_LOAD_TARIFF_ACTION();
		PM_IL_PROD_PREM_LIMIT_ACTION_BEAN = new PM_IL_PROD_PREM_LIMIT_ACTION();
		PM_IL_PROD_APPL_FUND_ACTION_BEAN = new PM_IL_PROD_APPL_FUND_ACTION();
		PM_IL_PROD_APPL_FUND_1_ACTION_BEAN = new PM_IL_PROD_APPL_FUND_1_ACTION();
		PM_IL_TOP_UP_CHARGE_ACTION_BEAN = new PM_IL_TOP_UP_CHARGE_ACTION();
		PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN = new PM_IL_PROD_TOPUP_PARAM_ACTION();
		PM_IL_PROD_APPL_PLANS_ACTION_BEAN = new PM_IL_PROD_APPL_PLANS_ACTION();
		PM_IL_PROD_ANNUITY_ACTION_BEAN = new PM_IL_PROD_ANNUITY_ACTION();
		PM_IL_PROD_PA_BENEFIT_ACTION_BEAN = new PM_IL_PROD_PA_BENEFIT_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		PM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN = new PM_IL_PROD_APPL_CVR_GRP_ACTION();
		PM_IL_PROD_INSURER_ACTION_BEAN = new PM_IL_PROD_INSURER_ACTION();
		PM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN = new PM_IL_PROD_INVEST_PREM_DEDC_ACTION();
		PM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN = new PM_IL_PROD_CONTRI_CHARGE_ACTION();
		PM_IL_PROD_APPL_SURRENDER_ACTION_BEAN=new PM_IL_PROD_APPL_SURRENDER_ACTION();
		/*Added by saranya Added by saranya for RM018T - FSD_IL_ZB Life_028-Cash Back on 05-02-2017*/
		PM_IL_PROD_CASHBACK_ACTION_BEAN=new PM_IL_PROD_CASHBACK_ACTION();
		
		
		
		/*Added By Dhinesh on 16.3.2017*/
		PM_IL_PRODUCT_UPLOAD_ACTION_BEAN = new PM_IL_PRODUCT_UPLOAD_ACTION();
		PM_IL_PRODUCT_UPLOAD_ACTION_BEAN.compositeAction= this;
		
		/*end*/
		/* Newly Added By Dhinesh on 15-7-2017 for ZBILQC-1720021*/
		PM_IL_PROD_CASHBCK_INT_ACTION_BEAN = new PM_IL_PROD_CASHBCK_INT_ACTION();
		PM_IL_PROD_CASHBCK_INT_ACTION_BEAN.compositeAction=this; 
		/* End */
		PM_IL_PROD_CASHBACK_ACTION_BEAN.compositeAction= this;
		/*End*/
		PM_IL_PRODUCT_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_APPL_COVER_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_APPL_COVER_1_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_APPL_COND_ACTION_BEAN.compositeAction = this;
		PM_IL_SA_INST_PYMT_ACTION_BEAN.compositeAction = this;
		PM_IL_SA_INST_PYMT1_ACTION_BEAN.compositeAction = this;
		PM_IL_SA_INST_PYMT2_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_APPL_BONUS_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_PREM_LIMIT_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_APPL_FUND_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_APPL_FUND_1_ACTION_BEAN.compositeAction = this;
		PM_IL_TOP_UP_CHARGE_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_TOPUP_PARAM_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_APPL_PLANS_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_ANNUITY_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_PA_BENEFIT_ACTION_BEAN.compositeAction = this;
		DUMMY_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_INSURER_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN.compositeAction = this;
		PM_IL_PROD_APPL_SURRENDER_ACTION_BEAN.compositeAction=this;
		/*Added by sankaranarayanan on 21/04/2017*/
		PM_IL_PROD_INTREST_ACTION_BEAN = new PM_IL_PROD_INTREST_ACTION();
	PM_IL_PROD_INTREST_ACTION_BEAN.compositeAction=this;
	/*end*/
		try {
			/*Added by sankaranarayanan on 21/04/2017*/
			tabbedBar
			.addTab(
					TAB_PM_IL_PROD_INTREST,
					"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_PROD_INTRES}",
					Messages
							.getString(
									"messageProperties_PILM035_APAC",
									"PILM035_APAC$PM_IL_PRODUCT$displayCaption"),
					false);
			//END
			tabbedBar
					.addTab(
							TAB_PM_IL_PRODUCT,
							"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_PRODUCT}",
							Messages
									.getString(
											"messageProperties_PILM035_APAC",
											"PILM035_APAC$PM_IL_PRODUCT$displayCaption"),
							false);
			
			
			tabbedBar
			.addTab(
					TAB_PM_IL_PROD_APPL_CVR_GRP,
					"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_PROD_APPL_CVR_GRP}",
					Messages
							.getString(
									"messageProperties_PILM035_APAC",
									"PILM035_APAC$PM_IL_PROD_APPL_CVR_GRP$displayCaption"),
					false);
			
			tabbedBar
					.addTab(
							TAB_PM_IL_PROD_APPL_COVER,
							"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_PROD_APPL_COVER}",
							Messages
									.getString(
											"messageProperties_PILM035_APAC",
											"PILM035_APAC$PM_IL_PROD_APPL_COVER$displayCaption"),
							false);
			tabbedBar
					.addTab(
							TAB_PM_IL_PROD_APPL_COND,
							"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_PROD_APPL_COND}",
							Messages
									.getString(
											"messageProperties_PILM035_APAC",
											"PILM035_APAC$PM_IL_PROD_APPL_COND$displayCaption"),
							false);
			tabbedBar.addTab(TAB_PM_IL_SA_INST_PYMT,
					"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_SA_INST_PYMT}",
					Messages.getString("messageProperties_PILM035_APAC",
							"PILM035_APAC$PM_IL_SA_INST_PYMT$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PM_IL_SA_INST_PYMT1,
					"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_SA_INST_PYMT1}",
					Messages.getString("messageProperties_PILM035_APAC",
							"PILM035_APAC$PM_IL_SA_INST_PYMT1$displayCaption"),
					false);
			tabbedBar.addTab(TAB_PM_IL_SA_INST_PYMT2,
					"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_SA_INST_PYMT2}",
					Messages.getString("messageProperties_PILM035_APAC",
							"PILM035_APAC$PM_IL_SA_INST_PYMT2$displayCaption"),
					false);

			tabbedBar
					.addTab(
							TAB_PM_IL_PROD_APPL_BONUS,
							"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_PROD_APPL_BONUS}",
							Messages
									.getString(
											"messageProperties_PILM035_APAC",
											"PILM035_APAC$PM_IL_PROD_APPL_BONUS$displayCaption"),
							false);
			tabbedBar
					.addTab(
							TAB_PM_IL_PROD_APPL_LOAD_TARIFF,
							"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_PROD_APPL_LOAD_TARIFF}",
							Messages
									.getString(
											"messageProperties_PILM035_APAC",
											"PILM035_APAC$PM_IL_PROD_APPL_LOAD_TARIFF$displayCaption"),
							false);
			tabbedBar
					.addTab(
							TAB_PM_IL_PROD_PREM_LIMIT,
							"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_PROD_PREM_LIMIT}",
							Messages
									.getString(
											"messageProperties_PILM035_APAC",
											"PILM035_APAC$PM_IL_PROD_PREM_LIMIT$displayCaption"),
							false);
			tabbedBar
					.addTab(
							TAB_PM_IL_PROD_APPL_FUND,
							"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_PROD_APPL_FUND}",
							Messages
									.getString(
											"messageProperties_PILM035_APAC",
											"PILM035_APAC$PM_IL_PROD_APPL_FUND$displayCaption"),
							false);

			

			tabbedBar
					.addTab(
							TAB_PM_IL_PROD_PA_BENEFIT,
							"#{PILM035_APAC_COMPOSITE_ACTION.callPM_IL_PROD_PA_BENEFIT}",
							Messages
									.getString(
											"messageProperties_PILM035_APAC",
											"PILM035_APAC$PM_IL_PROD_PA_BENEFIT$displayCaption"),
							false);

		} catch (Exception exc) {
			exc.printStackTrace();

		}

	}

	public DUMMY_ACTION getDUMMY_ACTION_BEAN() {
		return DUMMY_ACTION_BEAN;
	}

	public void setDUMMY_ACTION_BEAN(DUMMY_ACTION dummy_action_bean) {
		DUMMY_ACTION_BEAN = dummy_action_bean;
	}

	public PM_IL_PROD_ANNUITY_ACTION getPM_IL_PROD_ANNUITY_ACTION_BEAN() {
		return PM_IL_PROD_ANNUITY_ACTION_BEAN;
	}

	public void setPM_IL_PROD_ANNUITY_ACTION_BEAN(
			PM_IL_PROD_ANNUITY_ACTION pm_il_prod_annuity_action_bean) {
		PM_IL_PROD_ANNUITY_ACTION_BEAN = pm_il_prod_annuity_action_bean;
	}

	public PM_IL_PROD_APPL_CVR_GRP_ACTION getPM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN() {
		return PM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN;
	}

	public void setPM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN(
			PM_IL_PROD_APPL_CVR_GRP_ACTION pm_il_prod_appl_cvr_grp_action_bean) {
		PM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN = pm_il_prod_appl_cvr_grp_action_bean;
	}

	public UIWizard getWizard() {
		return wizard;
	}

	public void setWizard(UIWizard wizard) {
		wizard = new UIWizard();
		this.wizard = wizard;
	}

	public UISummary getComp() {
		return comp;
	}

	public void setComp(UISummary comp) {
		this.comp = comp;
	}

	/**
	 * @return the pM_IL_PROD_INSURER_ACTION_BEAN
	 */
	public PM_IL_PROD_INSURER_ACTION getPM_IL_PROD_INSURER_ACTION_BEAN() {
		return PM_IL_PROD_INSURER_ACTION_BEAN;
	}

	/**
	 * @param pm_il_prod_insurer_action_bean the pM_IL_PROD_INSURER_ACTION_BEAN to set
	 */
	public void setPM_IL_PROD_INSURER_ACTION_BEAN(
			PM_IL_PROD_INSURER_ACTION pm_il_prod_insurer_action_bean) {
		PM_IL_PROD_INSURER_ACTION_BEAN = pm_il_prod_insurer_action_bean;
	}

	public PM_IL_PROD_INVEST_PREM_DEDC_ACTION getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN() {
		return PM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN;
	}

	public void setPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN(
			PM_IL_PROD_INVEST_PREM_DEDC_ACTION pm_il_prod_invest_prem_dedc_action_bean) {
		PM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN = pm_il_prod_invest_prem_dedc_action_bean;
	}

	public PM_IL_PROD_CONTRI_CHARGE_ACTION getPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN() {
		return PM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN;
	}

	public void setPM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN(
			PM_IL_PROD_CONTRI_CHARGE_ACTION pm_il_prod_contri_charge_action_bean) {
		PM_IL_PROD_CONTRI_CHARGE_ACTION_BEAN = pm_il_prod_contri_charge_action_bean;
	}

	/*Added by saranya for RM018T - FSD_IL_ZB Life_028-Cash Back on 05-02-2017*/
	public String callPM_IL_PROD_INTRES() {
		preTabClick();
		return "PILM035_APAC_PM_IL_PROD_INTREST";

	}
	/*End*/

	

}
