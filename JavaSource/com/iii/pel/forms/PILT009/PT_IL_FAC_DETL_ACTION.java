package com.iii.pel.forms.PILT009;

import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY;
import com.iii.pel.forms.PILT010.PILT010_ACTION_INSTANCE;
import com.iii.pel.forms.PILT010.PV_IL_POL_RI_DETL_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_DETL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_FPCUD_YEAR_LABEL;

	private HtmlInputText COMP_UI_M_FPCUD_YEAR;

	private HtmlOutputLabel COMP_UI_M_FPCUD_AGE_LABEL;

	private HtmlInputText COMP_UI_M_FPCUD_AGE;

	private HtmlOutputLabel COMP_UI_M_FPCUD_TAR_RATE_LABEL;

	private HtmlInputText COMP_UI_M_FPCUD_TAR_RATE;

	private HtmlOutputLabel COMP_UI_M_FCRD_YEAR_LABEL;

	private HtmlInputText COMP_UI_M_FCRD_YEAR;

	private HtmlOutputLabel COMP_UI_M_FCRD_AGE_LABEL;

	private HtmlInputText COMP_UI_M_FCRD_AGE;

	private HtmlOutputLabel COMP_UI_M_FCRD_RATE_LABEL;

	private HtmlInputText COMP_UI_M_FCRD_RATE;

	private HtmlOutputLabel COMP_FD_YEAR_LABEL;

	private HtmlInputText COMP_FD_YEAR;

	private HtmlOutputLabel COMP_FD_ASSURED_AGE_LABEL;

	private HtmlInputText COMP_FD_ASSURED_AGE;

	private HtmlOutputLabel COMP_FD_TAR_RATE_LABEL;

	private HtmlInputText COMP_FD_TAR_RATE;

	private HtmlOutputLabel COMP_FD_TAR_RATE_PER_LABEL;

	private HtmlInputText COMP_FD_TAR_RATE_PER;

	private HtmlOutputLabel COMP_FD_FC_SA_LABEL;

	private HtmlInputText COMP_FD_FC_SA;

	private HtmlOutputLabel COMP_FD_FC_PREM_LABEL;

	private HtmlInputText COMP_FD_FC_PREM;

	private HtmlOutputLabel COMP_FD_FC_FAC_SA_LABEL;

	private HtmlInputText COMP_FD_FC_FAC_SA;

	private HtmlOutputLabel COMP_FD_FC_FAC_PREM_LABEL;

	private HtmlInputText COMP_FD_FC_FAC_PREM;

	private HtmlOutputLabel COMP_FD_LC_FAC_SA_LABEL;

	private HtmlInputText COMP_FD_LC_FAC_SA;

	private HtmlOutputLabel COMP_FD_LC_SA_LABEL;

	private HtmlInputText COMP_FD_LC_SA;

	private HtmlOutputLabel COMP_FD_LC_PREM_LABEL;

	private HtmlInputText COMP_FD_LC_PREM;

	private HtmlOutputLabel COMP_FD_LC_FAC_PREM_LABEL;

	private HtmlInputText COMP_FD_LC_FAC_PREM;
	
	private HtmlOutputLabel COMP_UI_M_FD_COVER_CODE_LABEL;

	private HtmlInputText COMP_UI_M_FD_COVER_CODE;

	private HtmlInputText COMP_UI_M_FD_COVER_DESC;

	private PT_IL_FAC_OUT PT_IL_FAC_OUT_BEAN;
	
	private PT_IL_FAC_DETL  PT_IL_FAC_DETL_BEAN;

	private ArrayList<PT_IL_FAC_DETL> dataListPT_IL_FAC_DETL = null;
	
	private boolean fcFacSAreadOnly;
	
	private boolean onLoadFlag;
	
	private UIData dataTable;
	
	private HtmlCommandButton UI_M_FAC_DISC_LOAD_BUT;
	
	PILT009_COMPOSITE_ACTION compositeAction;

	public HtmlCommandButton getUI_M_FAC_DISC_LOAD_BUT() {
		return UI_M_FAC_DISC_LOAD_BUT;
	}

	public void setUI_M_FAC_DISC_LOAD_BUT(HtmlCommandButton ui_m_fac_disc_load_but) {
		UI_M_FAC_DISC_LOAD_BUT = ui_m_fac_disc_load_but;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public PT_IL_FAC_DETL_ACTION() {
		dataListPT_IL_FAC_DETL = new ArrayList<PT_IL_FAC_DETL>();
		 PT_IL_FAC_DETL_BEAN=new PT_IL_FAC_DETL();
	}
	
	/*public ArrayList<PT_IL_FAC_DETL> getList(){
		return (ArrayList<PT_IL_FAC_DETL>) dataListPT_IL_FAC_DETL;
	}
	public void setList(ArrayList<PT_IL_FAC_DETL> list){
		dataListPT_IL_FAC_DETL = list;
	}*/

	public HtmlOutputLabel getCOMP_UI_M_FPCUD_YEAR_LABEL() {
		return COMP_UI_M_FPCUD_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPCUD_YEAR() {
		return COMP_UI_M_FPCUD_YEAR;
	}

	public void setCOMP_UI_M_FPCUD_YEAR_LABEL(HtmlOutputLabel COMP_UI_M_FPCUD_YEAR_LABEL) {
		this.COMP_UI_M_FPCUD_YEAR_LABEL = COMP_UI_M_FPCUD_YEAR_LABEL;
	}

	public void setCOMP_UI_M_FPCUD_YEAR(HtmlInputText COMP_UI_M_FPCUD_YEAR) {
		this.COMP_UI_M_FPCUD_YEAR = COMP_UI_M_FPCUD_YEAR;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPCUD_AGE_LABEL() {
		return COMP_UI_M_FPCUD_AGE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPCUD_AGE() {
		return COMP_UI_M_FPCUD_AGE;
	}

	public void setCOMP_UI_M_FPCUD_AGE_LABEL(HtmlOutputLabel COMP_UI_M_FPCUD_AGE_LABEL) {
		this.COMP_UI_M_FPCUD_AGE_LABEL = COMP_UI_M_FPCUD_AGE_LABEL;
	}

	public void setCOMP_UI_M_FPCUD_AGE(HtmlInputText COMP_UI_M_FPCUD_AGE) {
		this.COMP_UI_M_FPCUD_AGE = COMP_UI_M_FPCUD_AGE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FPCUD_TAR_RATE_LABEL() {
		return COMP_UI_M_FPCUD_TAR_RATE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FPCUD_TAR_RATE() {
		return COMP_UI_M_FPCUD_TAR_RATE;
	}

	public void setCOMP_UI_M_FPCUD_TAR_RATE_LABEL(HtmlOutputLabel COMP_UI_M_FPCUD_TAR_RATE_LABEL) {
		this.COMP_UI_M_FPCUD_TAR_RATE_LABEL = COMP_UI_M_FPCUD_TAR_RATE_LABEL;
	}

	public void setCOMP_UI_M_FPCUD_TAR_RATE(HtmlInputText COMP_UI_M_FPCUD_TAR_RATE) {
		this.COMP_UI_M_FPCUD_TAR_RATE = COMP_UI_M_FPCUD_TAR_RATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FCRD_YEAR_LABEL() {
		return COMP_UI_M_FCRD_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FCRD_YEAR() {
		return COMP_UI_M_FCRD_YEAR;
	}

	public void setCOMP_UI_M_FCRD_YEAR_LABEL(HtmlOutputLabel COMP_UI_M_FCRD_YEAR_LABEL) {
		this.COMP_UI_M_FCRD_YEAR_LABEL = COMP_UI_M_FCRD_YEAR_LABEL;
	}

	public void setCOMP_UI_M_FCRD_YEAR(HtmlInputText COMP_UI_M_FCRD_YEAR) {
		this.COMP_UI_M_FCRD_YEAR = COMP_UI_M_FCRD_YEAR;
	}

	public HtmlOutputLabel getCOMP_UI_M_FCRD_AGE_LABEL() {
		return COMP_UI_M_FCRD_AGE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FCRD_AGE() {
		return COMP_UI_M_FCRD_AGE;
	}

	public void setCOMP_UI_M_FCRD_AGE_LABEL(HtmlOutputLabel COMP_UI_M_FCRD_AGE_LABEL) {
		this.COMP_UI_M_FCRD_AGE_LABEL = COMP_UI_M_FCRD_AGE_LABEL;
	}

	public void setCOMP_UI_M_FCRD_AGE(HtmlInputText COMP_UI_M_FCRD_AGE) {
		this.COMP_UI_M_FCRD_AGE = COMP_UI_M_FCRD_AGE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FCRD_RATE_LABEL() {
		return COMP_UI_M_FCRD_RATE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FCRD_RATE() {
		return COMP_UI_M_FCRD_RATE;
	}

	public void setCOMP_UI_M_FCRD_RATE_LABEL(HtmlOutputLabel COMP_UI_M_FCRD_RATE_LABEL) {
		this.COMP_UI_M_FCRD_RATE_LABEL = COMP_UI_M_FCRD_RATE_LABEL;
	}

	public void setCOMP_UI_M_FCRD_RATE(HtmlInputText COMP_UI_M_FCRD_RATE) {
		this.COMP_UI_M_FCRD_RATE = COMP_UI_M_FCRD_RATE;
	}

	public HtmlOutputLabel getCOMP_FD_YEAR_LABEL() {
		return COMP_FD_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_FD_YEAR() {
		return COMP_FD_YEAR;
	}

	public void setCOMP_FD_YEAR_LABEL(HtmlOutputLabel COMP_FD_YEAR_LABEL) {
		this.COMP_FD_YEAR_LABEL = COMP_FD_YEAR_LABEL;
	}

	public void setCOMP_FD_YEAR(HtmlInputText COMP_FD_YEAR) {
		this.COMP_FD_YEAR = COMP_FD_YEAR;
	}

	public HtmlOutputLabel getCOMP_FD_ASSURED_AGE_LABEL() {
		return COMP_FD_ASSURED_AGE_LABEL;
	}

	public HtmlInputText getCOMP_FD_ASSURED_AGE() {
		return COMP_FD_ASSURED_AGE;
	}

	public void setCOMP_FD_ASSURED_AGE_LABEL(HtmlOutputLabel COMP_FD_ASSURED_AGE_LABEL) {
		this.COMP_FD_ASSURED_AGE_LABEL = COMP_FD_ASSURED_AGE_LABEL;
	}

	public void setCOMP_FD_ASSURED_AGE(HtmlInputText COMP_FD_ASSURED_AGE) {
		this.COMP_FD_ASSURED_AGE = COMP_FD_ASSURED_AGE;
	}

	public HtmlOutputLabel getCOMP_FD_TAR_RATE_LABEL() {
		return COMP_FD_TAR_RATE_LABEL;
	}

	public HtmlInputText getCOMP_FD_TAR_RATE() {
		return COMP_FD_TAR_RATE;
	}

	public void setCOMP_FD_TAR_RATE_LABEL(HtmlOutputLabel COMP_FD_TAR_RATE_LABEL) {
		this.COMP_FD_TAR_RATE_LABEL = COMP_FD_TAR_RATE_LABEL;
	}

	public void setCOMP_FD_TAR_RATE(HtmlInputText COMP_FD_TAR_RATE) {
		this.COMP_FD_TAR_RATE = COMP_FD_TAR_RATE;
	}

	public HtmlOutputLabel getCOMP_FD_TAR_RATE_PER_LABEL() {
		return COMP_FD_TAR_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_FD_TAR_RATE_PER() {
		return COMP_FD_TAR_RATE_PER;
	}

	public void setCOMP_FD_TAR_RATE_PER_LABEL(HtmlOutputLabel COMP_FD_TAR_RATE_PER_LABEL) {
		this.COMP_FD_TAR_RATE_PER_LABEL = COMP_FD_TAR_RATE_PER_LABEL;
	}

	public void setCOMP_FD_TAR_RATE_PER(HtmlInputText COMP_FD_TAR_RATE_PER) {
		this.COMP_FD_TAR_RATE_PER = COMP_FD_TAR_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_FD_FC_SA_LABEL() {
		return COMP_FD_FC_SA_LABEL;
	}

	public HtmlInputText getCOMP_FD_FC_SA() {
		return COMP_FD_FC_SA;
	}

	public void setCOMP_FD_FC_SA_LABEL(HtmlOutputLabel COMP_FD_FC_SA_LABEL) {
		this.COMP_FD_FC_SA_LABEL = COMP_FD_FC_SA_LABEL;
	}

	public void setCOMP_FD_FC_SA(HtmlInputText COMP_FD_FC_SA) {
		this.COMP_FD_FC_SA = COMP_FD_FC_SA;
	}

	public HtmlOutputLabel getCOMP_FD_FC_PREM_LABEL() {
		return COMP_FD_FC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_FD_FC_PREM() {
		return COMP_FD_FC_PREM;
	}

	public void setCOMP_FD_FC_PREM_LABEL(HtmlOutputLabel COMP_FD_FC_PREM_LABEL) {
		this.COMP_FD_FC_PREM_LABEL = COMP_FD_FC_PREM_LABEL;
	}

	public void setCOMP_FD_FC_PREM(HtmlInputText COMP_FD_FC_PREM) {
		this.COMP_FD_FC_PREM = COMP_FD_FC_PREM;
	}

	public HtmlOutputLabel getCOMP_FD_FC_FAC_SA_LABEL() {
		return COMP_FD_FC_FAC_SA_LABEL;
	}

	public HtmlInputText getCOMP_FD_FC_FAC_SA() {
		return COMP_FD_FC_FAC_SA;
	}

	public void setCOMP_FD_FC_FAC_SA_LABEL(HtmlOutputLabel COMP_FD_FC_FAC_SA_LABEL) {
		this.COMP_FD_FC_FAC_SA_LABEL = COMP_FD_FC_FAC_SA_LABEL;
	}

	public void setCOMP_FD_FC_FAC_SA(HtmlInputText COMP_FD_FC_FAC_SA) {
		this.COMP_FD_FC_FAC_SA = COMP_FD_FC_FAC_SA;
	}

	public HtmlOutputLabel getCOMP_FD_FC_FAC_PREM_LABEL() {
		return COMP_FD_FC_FAC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_FD_FC_FAC_PREM() {
		return COMP_FD_FC_FAC_PREM;
	}

	public void setCOMP_FD_FC_FAC_PREM_LABEL(HtmlOutputLabel COMP_FD_FC_FAC_PREM_LABEL) {
		this.COMP_FD_FC_FAC_PREM_LABEL = COMP_FD_FC_FAC_PREM_LABEL;
	}

	public void setCOMP_FD_FC_FAC_PREM(HtmlInputText COMP_FD_FC_FAC_PREM) {
		this.COMP_FD_FC_FAC_PREM = COMP_FD_FC_FAC_PREM;
	}

	public HtmlOutputLabel getCOMP_FD_LC_FAC_SA_LABEL() {
		return COMP_FD_LC_FAC_SA_LABEL;
	}

	public HtmlInputText getCOMP_FD_LC_FAC_SA() {
		return COMP_FD_LC_FAC_SA;
	}

	public void setCOMP_FD_LC_FAC_SA_LABEL(HtmlOutputLabel COMP_FD_LC_FAC_SA_LABEL) {
		this.COMP_FD_LC_FAC_SA_LABEL = COMP_FD_LC_FAC_SA_LABEL;
	}

	public void setCOMP_FD_LC_FAC_SA(HtmlInputText COMP_FD_LC_FAC_SA) {
		this.COMP_FD_LC_FAC_SA = COMP_FD_LC_FAC_SA;
	}

	public HtmlOutputLabel getCOMP_FD_LC_SA_LABEL() {
		return COMP_FD_LC_SA_LABEL;
	}

	public HtmlInputText getCOMP_FD_LC_SA() {
		return COMP_FD_LC_SA;
	}

	public void setCOMP_FD_LC_SA_LABEL(HtmlOutputLabel COMP_FD_LC_SA_LABEL) {
		this.COMP_FD_LC_SA_LABEL = COMP_FD_LC_SA_LABEL;
	}

	public void setCOMP_FD_LC_SA(HtmlInputText COMP_FD_LC_SA) {
		this.COMP_FD_LC_SA = COMP_FD_LC_SA;
	}

	public HtmlOutputLabel getCOMP_FD_LC_PREM_LABEL() {
		return COMP_FD_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_FD_LC_PREM() {
		return COMP_FD_LC_PREM;
	}

	public void setCOMP_FD_LC_PREM_LABEL(HtmlOutputLabel COMP_FD_LC_PREM_LABEL) {
		this.COMP_FD_LC_PREM_LABEL = COMP_FD_LC_PREM_LABEL;
	}

	public void setCOMP_FD_LC_PREM(HtmlInputText COMP_FD_LC_PREM) {
		this.COMP_FD_LC_PREM = COMP_FD_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_FD_LC_FAC_PREM_LABEL() {
		return COMP_FD_LC_FAC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_FD_LC_FAC_PREM() {
		return COMP_FD_LC_FAC_PREM;
	}

	public void setCOMP_FD_LC_FAC_PREM_LABEL(HtmlOutputLabel COMP_FD_LC_FAC_PREM_LABEL) {
		this.COMP_FD_LC_FAC_PREM_LABEL = COMP_FD_LC_FAC_PREM_LABEL;
	}

	public void setCOMP_FD_LC_FAC_PREM(HtmlInputText COMP_FD_LC_FAC_PREM) {
		this.COMP_FD_LC_FAC_PREM = COMP_FD_LC_FAC_PREM;
	}

	public PT_IL_FAC_OUT getPT_IL_FAC_OUT_BEAN() {
		return PT_IL_FAC_OUT_BEAN;
	}

	public void setPT_IL_FAC_OUT_BEAN(PT_IL_FAC_OUT bean) {
		PT_IL_FAC_OUT_BEAN = bean;
	}

public  ArrayList<PT_IL_FAC_DETL> getDataListPT_IL_FAC_DETL() {
		return dataListPT_IL_FAC_DETL;
	}

	public void setDataListPT_IL_FAC_DETL(
			ArrayList<PT_IL_FAC_DETL> dataListPT_IL_FAC_DETL) {
		this.dataListPT_IL_FAC_DETL = dataListPT_IL_FAC_DETL;
	}
	
	public HtmlOutputLabel getCOMP_UI_M_FD_COVER_CODE_LABEL() {
		return COMP_UI_M_FD_COVER_CODE_LABEL;
	}

	public void setCOMP_UI_M_FD_COVER_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_fd_cover_code_label) {
		COMP_UI_M_FD_COVER_CODE_LABEL = comp_ui_m_fd_cover_code_label;
	}

	public HtmlInputText getCOMP_UI_M_FD_COVER_CODE() {
		return COMP_UI_M_FD_COVER_CODE;
	}

	public void setCOMP_UI_M_FD_COVER_CODE(HtmlInputText comp_ui_m_fd_cover_code) {
		COMP_UI_M_FD_COVER_CODE = comp_ui_m_fd_cover_code;
	}

	public HtmlInputText getCOMP_UI_M_FD_COVER_DESC() {
		return COMP_UI_M_FD_COVER_DESC;
	}

	public void setCOMP_UI_M_FD_COVER_DESC(HtmlInputText comp_ui_m_fd_cover_desc) {
		COMP_UI_M_FD_COVER_DESC = comp_ui_m_fd_cover_desc;
	}

	public boolean isFcFacSAreadOnly() {
		return fcFacSAreadOnly;
	}

	public void setFcFacSAreadOnly(boolean fcFacSAreadOnly) {
		this.fcFacSAreadOnly = fcFacSAreadOnly;
	}
	
	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	private String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}
	
	public void checkBoxStatus(ActionEvent actionEvent)	{

		boolean check = Boolean.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDataTable().getRowIndex();
		getDataListPT_IL_FAC_DETL().get(rowIndex).setCHECK_BOX(check);
	}

	public void onPageLoad(PhaseEvent event) {
		
		if (isBlockFlag()) {
			PT_IL_FAC_DETL_HELPER helper = new PT_IL_FAC_DETL_HELPER();
			try {
				helper.PT_IL_FAC_DETL_WHEN_NEW_BLOCK_INSTANCE(this);
				COMP_UI_M_FD_COVER_CODE.resetValue();
				//setBlockFlag(false);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put("current",
						"Error occured while loading the page");
				getErrorMap().put("detail",
						"Error occured while loading the page");
			}
			//setOnLoadFlag(true);
		}
	}
	
	public String backToFAC_OUT() {
		
		return "gotoFacOut";
	}
	
	private PT_IL_FAC_DETL getSelectedBean() throws Exception {

		PT_IL_FAC_DETL facDetlBean = null;
		int clickCount = 0;

		for(PT_IL_FAC_DETL tempBean : getDataListPT_IL_FAC_DETL()) {

			if(tempBean.isCHECK_BOX()) {
				facDetlBean = tempBean;
				clickCount++;
			}
		}

		if(clickCount < 1) {
			throw new Exception("Please select one row");
		} else if(clickCount > 1) {
			throw new Exception("Please select only one row");
		}

		return facDetlBean;
	}
	
	public String goToDiscLoad() {
		
		String returnValue = null;
		CommonUtils commonUtils = new CommonUtils();

		try {

			PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils
			.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
			PT_IL_FAC_DETL facDetlBean = getPT_IL_FAC_DETL_BEAN();
			compositeAction.getPILT009_PT_IL_FAC_DISC_LOAD_ACTION().setPT_IL_FAC_DETL_BEAN(facDetlBean);
			compositeAction.getPILT009_PT_IL_FAC_DISC_LOAD_ACTION().setPT_IL_FAC_OUT_BEAN(getPT_IL_FAC_OUT_BEAN());
			returnValue = "gotoDiscLoad";

		} catch (Exception e) {
			getWarningMap().put("current", e.getMessage());
			getWarningMap().put("detail", e.getMessage());
		}

		return returnValue;
	}

	public PT_IL_FAC_DETL getPT_IL_FAC_DETL_BEAN() {
		return PT_IL_FAC_DETL_BEAN;
	}

	public void setPT_IL_FAC_DETL_BEAN(PT_IL_FAC_DETL pt_il_fac_detl_bean) {
		PT_IL_FAC_DETL_BEAN = pt_il_fac_detl_bean;
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_FAC_DETL_BEAN = (PT_IL_FAC_DETL) dataTable.getRowData();
			resetSelectedRow();
			resetAllComponent();
			PT_IL_FAC_DETL_BEAN.setRowSelected(true);
		} catch (Exception e) {
			getErrorMap()
					.put(
							com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			getErrorMap().put("displayRecords", e.getMessage());
		}
	}

	public void resetSelectedRow() {
		Iterator<PT_IL_FAC_DETL> iterator = dataListPT_IL_FAC_DETL.iterator();

		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_UI_M_FPCUD_YEAR.resetValue();
		COMP_UI_M_FPCUD_AGE.resetValue();
		COMP_UI_M_FPCUD_TAR_RATE.resetValue();
		COMP_UI_M_FCRD_YEAR.resetValue();
		COMP_UI_M_FCRD_AGE.resetValue();
		COMP_UI_M_FCRD_RATE.resetValue();
		COMP_FD_YEAR.resetValue();
		COMP_FD_ASSURED_AGE.resetValue();
		COMP_FD_TAR_RATE.resetValue();
		COMP_FD_TAR_RATE_PER.resetValue();
		COMP_FD_FC_SA.resetValue();
		COMP_FD_FC_PREM.resetValue();
		COMP_FD_FC_FAC_SA.resetValue();
		COMP_FD_FC_FAC_PREM.resetValue();
		COMP_FD_LC_FAC_SA.resetValue();
		COMP_FD_LC_SA.resetValue();
		COMP_FD_LC_PREM.resetValue();
		COMP_FD_LC_FAC_PREM.resetValue();
		COMP_UI_M_FD_COVER_CODE.resetValue();
		COMP_UI_M_FD_COVER_DESC.resetValue();


	}
	
	/*added by raja on 29-06-2017 for disscussed with siva sir*/
	
	public void saveRecord(ActionEvent event) {
		String message = null;
		try {
				
				new CRUDHandler().executeUpdate(PT_IL_FAC_DETL_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
		
					
				PT_IL_FAC_DETL_BEAN.setRowSelected(true);
		
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put("SAVE",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	}

	/*end*/
	
	/*Added by Ameen on 14-09-2017 as per Siva sugg. for ZBILQC-1736379*/
	public void validateFD_FC_FAC_SA(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			Double RD_POL_NO = (Double) value;
			PT_IL_FAC_DETL_BEAN.setFD_FC_FAC_SA(RD_POL_NO);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	private HtmlOutputLabel COMP_FD_SCHD_PYMT_DT_LABEL;
	
	private HtmlCalendar COMP_FD_SCHD_PYMT_DT;

	public HtmlOutputLabel getCOMP_FD_SCHD_PYMT_DT_LABEL() {
		return COMP_FD_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_FD_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel cOMP_FD_SCHD_PYMT_DT_LABEL) {
		COMP_FD_SCHD_PYMT_DT_LABEL = cOMP_FD_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FD_SCHD_PYMT_DT() {
		return COMP_FD_SCHD_PYMT_DT;
	}

	public void setCOMP_FD_SCHD_PYMT_DT(HtmlCalendar cOMP_FD_SCHD_PYMT_DT) {
		COMP_FD_SCHD_PYMT_DT = cOMP_FD_SCHD_PYMT_DT;
	}

	/*end*/
}
