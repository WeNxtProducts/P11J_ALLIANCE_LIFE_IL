package com.iii.pel.forms.PILM035_APAC;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_ANNUITY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PROD_DEF_PERIOD_FM_LABEL;

	private HtmlInputText COMP_PROD_DEF_PERIOD_FM;

	private HtmlOutputLabel COMP_PROD_DEF_PERIOD_TO_LABEL;

	private HtmlInputText COMP_PROD_DEF_PERIOD_TO;

	private HtmlOutputLabel COMP_PROD_WAQAF_PERIOD_FM_LABEL;

	private HtmlInputText COMP_PROD_WAQAF_PERIOD_FM;

	private HtmlOutputLabel COMP_PROD_WAQAF_PERIOD_TO_LABEL;

	private HtmlInputText COMP_PROD_WAQAF_PERIOD_TO;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	public PM_IL_PROD_ANNUITY PM_IL_PROD_ANNUITY_BEAN;

	public PM_IL_PROD_ANNUITY getPM_IL_PROD_ANNUITY_BEAN() {
		return PM_IL_PROD_ANNUITY_BEAN;
	}

	public void setPM_IL_PROD_ANNUITY_BEAN(
			PM_IL_PROD_ANNUITY pm_il_prod_annuity_bean) {
		PM_IL_PROD_ANNUITY_BEAN = pm_il_prod_annuity_bean;
	}

	public PM_IL_PROD_ANNUITY_ACTION() {
		PM_IL_PROD_ANNUITY_BEAN = new PM_IL_PROD_ANNUITY();
	}

	public void onLoad(PhaseEvent event) {
				PM_IL_PRODUCT pm_il_product_bean = compositeAction
						.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
				PM_IL_PROD_ANNUITY_BEAN.setPROD_DEF_PERIOD_FM(pm_il_product_bean
						.getPROD_DEF_PERIOD_FM());
				PM_IL_PROD_ANNUITY_BEAN.setPROD_DEF_PERIOD_TO(pm_il_product_bean
						.getPROD_DEF_PERIOD_TO());
				PM_IL_PROD_ANNUITY_BEAN.setPROD_WAQAF_PERIOD_FM(pm_il_product_bean
						.getPROD_WAQAF_PERIOD_FM());
				PM_IL_PROD_ANNUITY_BEAN.setPROD_WAQAF_PERIOD_TO(pm_il_product_bean
						.getPROD_WAQAF_PERIOD_TO());
	}

	public void saveRecord() {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();

				pm_il_product_bean.setPROD_DEF_PERIOD_FM(PM_IL_PROD_ANNUITY_BEAN
						.getPROD_DEF_PERIOD_FM());
				pm_il_product_bean.setPROD_DEF_PERIOD_TO(PM_IL_PROD_ANNUITY_BEAN
						.getPROD_DEF_PERIOD_TO());
				pm_il_product_bean.setPROD_WAQAF_PERIOD_FM(PM_IL_PROD_ANNUITY_BEAN
						.getPROD_WAQAF_PERIOD_FM());
				pm_il_product_bean.setPROD_WAQAF_PERIOD_TO(PM_IL_PROD_ANNUITY_BEAN
						.getPROD_WAQAF_PERIOD_TO());

		try {
			new CRUDHandler().executeUpdate(pm_il_product_bean, CommonUtils
					.getConnection());
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_PROD_DEF_PERIOD_FM_LABEL() {
		return COMP_PROD_DEF_PERIOD_FM_LABEL;
	}

	public void setCOMP_PROD_DEF_PERIOD_FM_LABEL(
			HtmlOutputLabel comp_prod_def_period_fm_label) {
		COMP_PROD_DEF_PERIOD_FM_LABEL = comp_prod_def_period_fm_label;
	}

	public HtmlInputText getCOMP_PROD_DEF_PERIOD_FM() {
		return COMP_PROD_DEF_PERIOD_FM;
	}

	public void setCOMP_PROD_DEF_PERIOD_FM(HtmlInputText comp_prod_def_period_fm) {
		COMP_PROD_DEF_PERIOD_FM = comp_prod_def_period_fm;
	}

	public HtmlOutputLabel getCOMP_PROD_DEF_PERIOD_TO_LABEL() {
		return COMP_PROD_DEF_PERIOD_TO_LABEL;
	}

	public void setCOMP_PROD_DEF_PERIOD_TO_LABEL(
			HtmlOutputLabel comp_prod_def_period_to_label) {
		COMP_PROD_DEF_PERIOD_TO_LABEL = comp_prod_def_period_to_label;
	}

	public HtmlInputText getCOMP_PROD_DEF_PERIOD_TO() {
		return COMP_PROD_DEF_PERIOD_TO;
	}

	public void setCOMP_PROD_DEF_PERIOD_TO(HtmlInputText comp_prod_def_period_to) {
		COMP_PROD_DEF_PERIOD_TO = comp_prod_def_period_to;
	}

	public HtmlOutputLabel getCOMP_PROD_WAQAF_PERIOD_FM_LABEL() {
		return COMP_PROD_WAQAF_PERIOD_FM_LABEL;
	}

	public void setCOMP_PROD_WAQAF_PERIOD_FM_LABEL(
			HtmlOutputLabel comp_prod_waqaf_period_fm_label) {
		COMP_PROD_WAQAF_PERIOD_FM_LABEL = comp_prod_waqaf_period_fm_label;
	}

	public HtmlInputText getCOMP_PROD_WAQAF_PERIOD_FM() {
		return COMP_PROD_WAQAF_PERIOD_FM;
	}

	public void setCOMP_PROD_WAQAF_PERIOD_FM(
			HtmlInputText comp_prod_waqaf_period_fm) {
		COMP_PROD_WAQAF_PERIOD_FM = comp_prod_waqaf_period_fm;
	}

	public HtmlOutputLabel getCOMP_PROD_WAQAF_PERIOD_TO_LABEL() {
		return COMP_PROD_WAQAF_PERIOD_TO_LABEL;
	}

	public void setCOMP_PROD_WAQAF_PERIOD_TO_LABEL(
			HtmlOutputLabel comp_prod_waqaf_period_to_label) {
		COMP_PROD_WAQAF_PERIOD_TO_LABEL = comp_prod_waqaf_period_to_label;
	}

	public HtmlInputText getCOMP_PROD_WAQAF_PERIOD_TO() {
		return COMP_PROD_WAQAF_PERIOD_TO;
	}

	public void setCOMP_PROD_WAQAF_PERIOD_TO(
			HtmlInputText comp_prod_waqaf_period_to) {
		COMP_PROD_WAQAF_PERIOD_TO = comp_prod_waqaf_period_to;
	}
}
