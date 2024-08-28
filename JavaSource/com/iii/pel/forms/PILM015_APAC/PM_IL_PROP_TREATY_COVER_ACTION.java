package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

/**
 * @author 50180
 * 
 */
public class PM_IL_PROP_TREATY_COVER_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PTC_COVER_CODE_LABEL;

	private HtmlInputText COMP_PTC_COVER_CODE;

	private HtmlOutputLabel COMP_PTC_STD_TREATY_LIMIT_LABEL;

	private HtmlInputText COMP_PTC_STD_TREATY_LIMIT;

	private HtmlOutputLabel COMP_PTC_SUB_STD_TREATY_LIMIT_LABEL;

	private HtmlInputText COMP_PTC_SUB_STD_TREATY_LIMIT;

	private HtmlOutputLabel COMP_PTC_RETN_PERC_LABEL;

	private HtmlInputText COMP_PTC_RETN_PERC;

	private HtmlOutputLabel COMP_PTC_STD_MAX_RETN_LABEL;

	private HtmlInputText COMP_PTC_STD_MAX_RETN;

	private HtmlOutputLabel COMP_PTC_SSTD_MAX_RETN_LABEL;

	private HtmlInputText COMP_PTC_SSTD_MAX_RETN;

	private HtmlOutputLabel COMP_PTC_COMM_PERC_1ST_YR_LABEL;

	private HtmlInputText COMP_PTC_COMM_PERC_1ST_YR;

	private HtmlOutputLabel COMP_PTC_COMM_PERC_SUB_YRS_LABEL;

	private HtmlInputText COMP_PTC_COMM_PERC_SUB_YRS;

	private HtmlOutputLabel COMP_PTC_SSTD_COMM_PERC_1ST_YR_LABEL;

	private HtmlInputText COMP_PTC_SSTD_COMM_PERC_1ST_YR;

	private HtmlOutputLabel COMP_PTC_SSTD_COMM_PERC_SUB_YRS_LABEL;

	private HtmlInputText COMP_PTC_SSTD_COMM_PERC_SUB_YRS;

	private HtmlOutputLabel COMP_PTC_SUB_STD_TARIFF_LABEL;

	private HtmlInputText COMP_PTC_SUB_STD_TARIFF;

	private HtmlOutputLabel COMP_UI_M_PTC_SUB_STD_TARIFF_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PTC_SUB_STD_TARIFF_DESC;

	private HtmlOutputLabel COMP_PTC_GROUP_COVER_YN_LABEL;

	private HtmlSelectOneMenu COMP_PTC_GROUP_COVER_YN;

	private HtmlOutputLabel COMP_PTC_CVR_GRP_CODE_LABEL;

	private HtmlInputText COMP_PTC_CVR_GRP_CODE;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_UI_M_PTC_CVR_GRP_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PTC_CVR_GRP_CODE_DESC;

	private PM_IL_PROP_TREATY_COVER PM_IL_PROP_TREATY_COVER_BEAN;

	private HtmlCommandButton COMP_BUTTON_GRP_CVR;

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

	private int currentPage;

	private int recordsPerPage = 5;

	private int prevRowInd;

	private int lastUpdateRowIndex;

	private ArrayList<PM_IL_PROP_TREATY_COVER> dataTableList;

	private UIData dataTable;

	private List coverCodeList = new ArrayList();

	private List tarriffCodeList = new ArrayList();

	private List groupCodeLovList = new ArrayList();

	private List<SelectItem> groupList = new ArrayList<SelectItem>();

	private PM_IL_PROP_TREATY_COVER_DELEGATE DelegetForCover;

	private PM_IL_PROP_TREATY_COVER_HELPER HelperForCover;

	private PM_IL_PROP_TREATY_TYPE tempTreaty_TypeBean;
	
	private PM_IL_PROP_TREATY_TYPE_HELPER pm_il_prop_treaty_type_helper = new PM_IL_PROP_TREATY_TYPE_HELPER();

	double mySysId;
	
	private boolean onLoadFlag = false;
	
	private boolean retensionDisabled;
	
	//filters
	private String filterByPTC_COVER_CODE;
	
	private String filterByPTC_STD_TREATY_LIMIT;
	
	private String filterByPTC_COMM_PERC_1ST_YR;
	
	private String filterByPTC_SUB_STD_TREATY_LIMIT;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	//ADDED BY KRITHIKA
	private HtmlCommandButton COMP_BUTTON_PART_CUST;

	public HtmlCommandButton getCOMP_BUTTON_PART_CUST() {
		return COMP_BUTTON_PART_CUST;
	}

	public void setCOMP_BUTTON_PART_CUST(HtmlCommandButton cOMP_BUTTON_PART_CUST) {
		COMP_BUTTON_PART_CUST = cOMP_BUTTON_PART_CUST;
	}
	//END
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;	
	

	CommonUtils commonUtils =new CommonUtils() ;
	
	private int lastUpdatedRowIndex;

	public boolean isRetensionDisabled() {
		return retensionDisabled;
	}

	public void setRetensionDisabled(boolean retensionDisabled) {
		this.retensionDisabled = retensionDisabled;
	}

	/**
	 * Contrustor for Initialisation of variables
	 */
	public PM_IL_PROP_TREATY_COVER_ACTION() {
		prevRowInd = 0;
		currentPage = 1;
		PM_IL_PROP_TREATY_COVER_BEAN = new PM_IL_PROP_TREATY_COVER();
		DelegetForCover = new PM_IL_PROP_TREATY_COVER_DELEGATE();
		HelperForCover = new PM_IL_PROP_TREATY_COVER_HELPER();
		dataTableList = new ArrayList<PM_IL_PROP_TREATY_COVER>();
		try {
			groupList = DelegetForCover.comboBoxValues("PILM015_APAC",
					"PM_IL_PROP_TREATY_COVER",
					"PM_IL_PROP_TREATY_COVER.PTC_GROUP_COVER_YN", "YESNO");
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	public List getCoverCodeList() {
		return coverCodeList;
	}

	public void setCoverCodeList(List coverCodeList) {
		this.coverCodeList = coverCodeList;
	}

	public List getTarriffCodeList() {
		return tarriffCodeList;
	}

	public void setTarriffCodeList(List tarriffCodeList) {
		this.tarriffCodeList = tarriffCodeList;
	}

	/**
	 * LOV for cover code
	 * 
	 * @param obj
	 * @return
	 */
	
	private List<LovBean> lovList = new ArrayList<LovBean>();
	
	public List<LovBean> getLovList() {
		return lovList;
	}

	public void setLovList(List<LovBean> lovList) {
		this.lovList = lovList;
	}

	public List<LovBean> prepareCVR_CODE(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM015_APAC", "PM_IL_PROP_TREATY_COVER",
					"PTC_COVER_CODE", null , null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PLAN_CODE_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	
	public List coverCodeLov(Object obj) {
		String coverCode = (String) obj;
		try {
			coverCodeList = DelegetForCover.coverCodeSuggestionBox(
					compositeAction.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN(),
					coverCode,
					coverCodeList);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}

		return coverCodeList;
	}

	/**
	 * LOV for cover description
	 * 
	 * @param event
	 */
	public void getcoverCodeDesc(ActionEvent event) {
		COMP_UI_M_COVER_DESC.setSubmittedValue(null);
		if (COMP_PTC_COVER_CODE.getSubmittedValue() != null) {
			String coverCode = (String) COMP_PTC_COVER_CODE.getSubmittedValue();
			String coverDesc = DelegetForCover.getCoverCodeDesc(coverCode,
					coverCodeList);
			PM_IL_PROP_TREATY_COVER_BEAN.setUI_M_COVER_DESC(coverDesc);
			COMP_UI_M_COVER_DESC.setSubmittedValue(coverDesc);
		}
	}

	/**
	 * LOV for tarriff Code
	 * 
	 * @param obj
	 * @return
	 */
	public List tarriffCodeLov(Object obj) {
		System.out.println("IN THE LOV*****************");
		String tarriffCode = (String) obj;
		try {
			tarriffCodeList = DelegetForCover.TarrifCodeSuggestionBox(tarriffCode,
					tarriffCodeList);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return tarriffCodeList;
	}

	/**
	 * LOV for tarriff Code description
	 * 
	 * @param event
	 */
	public void getTarriffCodeLinkDesc(ActionEvent event) {
		COMP_UI_M_PTC_SUB_STD_TARIFF_DESC.setSubmittedValue(null);
		if (COMP_PTC_SUB_STD_TARIFF.getSubmittedValue() != null) {
			String tarriffCode = (String) COMP_PTC_SUB_STD_TARIFF
					.getSubmittedValue();
			String tarriffDesc = DelegetForCover.gettarrifCodeDesc(tarriffCode,
					tarriffCodeList);
			PM_IL_PROP_TREATY_COVER_BEAN.setUI_M_PTC_SUB_STD_TARIFF_DESC(tarriffDesc);
		}
	}

	public List groupCodeLov(Object obj) throws Exception {
		try {
			String groupCode = (String) obj;
			groupCodeLovList = DelegetForCover.groupCodeSuggestionBox(groupCode,
					groupCodeLovList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return groupCodeLovList;
	}
	
	
	/* public ArrayList<LovBean> groupCodeLov(Object object) {
	    	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
			String query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE  PC_TYPE = 'IL_RI_GR_CVR'  AND " +
							"NVL(PC_FRZ_FLAG,'N') = 'N' AND(PC_CODE LIKE ? OR PC_DESC LIKE ?) AND ROWNUM < ?";
			Object[] values = null;
			String currentValue = (String) object;

			try {
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

				values = new Object[] { currentValue, currentValue,
						PELConstants.suggetionRecordSize };
				lovList = ListItemUtil.prepareSuggestionList(query, values);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return lovList;
	    }*/

	public void getGroupCodeLinkDesc(ActionEvent event) {
		COMP_UI_M_PTC_CVR_GRP_CODE_DESC.setSubmittedValue(null);
		if (COMP_PTC_CVR_GRP_CODE.getSubmittedValue() != null) {
			String groupCode = (String) COMP_PTC_CVR_GRP_CODE
					.getSubmittedValue();
			String groupDesc = DelegetForCover.getGroupCodeDesc(groupCode,
					coverCodeList);
			PM_IL_PROP_TREATY_COVER_BEAN.setUI_M_PTC_CVR_GRP_CODE_DESC(groupDesc);
		}
	}

	/*public String addNew() {

		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		int rowCount = 0;

		if (dataTableList == null) {
			dataTableList = new ArrayList<PM_IL_PROP_TREATY_COVER>();
		}
		
		 * PM_IL_PROP_TREATY_COVER cover = new PM_IL_PROP_TREATY_COVER();
		 * cover.setPTC_PTT_SYS_ID(mySysId); System.out.println("THIS IS MY
		 * SYSID" + cover.getPTC_PTT_SYS_ID()); dataTableList.add(cover);
		 
		 
		//[PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix
		//dataTableList.add(new PM_IL_PROP_TREATY_COVER());
		//PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix]
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction = (PM_IL_PROP_TREATY_COMPOSITE_ACTION) (commonUtils
				.getMappedBeanFromSession("PM_IL_PROP_TREATY_COMPOSITE_ACTION"));
		PM_IL_PROP_TREATY_COVER_HELPER treatyCoverHelper = new PM_IL_PROP_TREATY_COVER_HELPER();
		try {
		//[PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix
			PM_IL_PROP_TREATY_COVER treatyCoverBean = new PM_IL_PROP_TREATY_COVER();
			treatyCoverHelper.newRecordInstance(treatyCoverBean);// when-new-record-instance
			treatyCoverHelper.createNewRecord(treatyCoverBean);// WHEN-CREATE-RECORD
			dataTableList.add(treatyCoverBean);
		//PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix]
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Settings to navigate to last page
		rowCount = getDataTable().getRowCount();
		currentPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currentPage++;
		}

		return "newadded";
	}*/
	
	public void addNew(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()){	
				this.PM_IL_PROP_TREATY_COVER_BEAN = new PM_IL_PROP_TREATY_COVER();
				resetAllComponent();
				/*added by raja on 16-08-2017 for ZBILQC-1735236*/
				resetSelectedRow();
				/*end*/
			}else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	}

	/*public String deleteRow() {

		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		PM_IL_PROP_TREATY_COVER bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataTableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataTableList.size();) {
				bean = dataTableList.get(index);
				if (bean.isSelected()) {
					dataTableList.remove(bean);
					deletedRecordIndex = DelegetForCover.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);

				} else {
					index++;
				}
			}

			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current",
						+deletedRecordList.size() + "Records Deleted");
			}
			lastUpdateRowIndex = -1;
			System.out.println("----------------bye-------------");
		}

		return "";
	}*/
	
	public String deleteRow(ActionEvent ae) {
	try{
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_PROP_TREATY_COVER bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataTableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataTableList.size();) {
				bean = dataTableList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
					dataTableList.remove(bean);
					deletedRecordIndex = DelegetForCover
							.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			double var = 0;
			if(dataTableList.size() > 0) {
				setPM_IL_PROP_TREATY_COVER_BEAN(dataTableList.get(0));
				PM_IL_PROP_TREATY_COVER_BEAN.setRowSelected(true);
			} else {
				addNew(ae);
			}
			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current",
						+deletedRecordList.size() + "Record Deleted ");

			}
			lastUpdatedRowIndex = -1;
		}
		resetAllComponent();
		resetSelectedRow();
		PM_IL_PROP_TREATY_COVER_BEAN.setRowSelected(true);	
		}catch(Exception exception){
		}
		return "";
	}

	public void disableGroup(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String comboValue = (String) input.getSubmittedValue();
		PM_IL_PROP_TREATY_COVER treatyCoverBean = this.PM_IL_PROP_TREATY_COVER_BEAN;
		treatyCoverBean.setPTC_GROUP_COVER_YN(comboValue);
		if (comboValue != null && comboValue.trim().length() > 0) {
			if ("N".equalsIgnoreCase(comboValue)) {
				treatyCoverBean.setPTC_CVR_GRP_CODE(null);
				treatyCoverBean.setUI_M_PTC_CVR_GRP_CODE_DESC(null);
				treatyCoverBean.setPTC_CVR_GRP_CODE_DIS(true);
				COMP_BUTTON_GRP_CVR.setDisabled(true);
			} else {
				treatyCoverBean.setPTC_CVR_GRP_CODE_DIS(false);
				COMP_BUTTON_GRP_CVR.setDisabled(false);
			}
		}
	}

	// [ Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 
	/*public void gridtabListener() {

		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TREATY_COVER gridValueBean = null;
		System.out.println(lastUpdateRowIndex + "   " + currRowIndex + "  "
				+ prevRowInd);
		try {
			if (lastUpdateRowIndex != -1) {
				if (lastUpdateRowIndex != prevRowInd) {
					if (currRowIndex != prevRowInd) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PM_IL_PROP_TREATY_COVER) dataTableList
								.get(prevRowInd);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {
							gridValueBean.setPTC_UPD_DT(new Date());
							gridValueBean.setPTC_UPD_UID("PEL_LIFE");
							rowUpdated = DelegetForCover
									.updateForTreatyCover(gridValueBean);
							getWarningMap().put("current", "Records Updated");

						} else {
							gridValueBean.setPTC_UPD_DT(new Date());
							gridValueBean.setPTC_UPD_UID("PEL_LIFE");
							rowUpdated = DelegetForCover
									.updateForTreatyCover(gridValueBean);
							getWarningMap().put("current", "Records Inserted");

						}

						// Update previous row index
						prevRowInd = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}

		return;
	}*/
	// Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]

	public void lastColumnListener() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TREATY_COVER gridValueBean = null;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String userId = (String) sessionMap.get("GLOBAL.M_USER_ID");
		try {
			gridValueBean = (PM_IL_PROP_TREATY_COVER) dataTableList
					.get(currRowIndex);
			if (gridValueBean.getROWID() != null) {
				gridValueBean.setPTC_UPD_DT(Calendar.getInstance().getTime());
				gridValueBean.setPTC_UPD_UID(userId);
				rowUpdated = DelegetForCover
						.updateForTreatyCover(gridValueBean);
				getWarningMap().put("current", "Records Updated");

			} else {
				PM_IL_PROP_TREATY_TYPE typeValue = compositeAction
						.getPM_IL_PROP_TREATY_TYPE_ACTION()
						.getPM_IL_PROP_TREATY_TYPE_BEAN();
				Double parentSysId = typeValue.getPTT_SYS_ID();
				gridValueBean.setPTC_PTT_SYS_ID(parentSysId);
				Double sysId = DelegetForCover.getSysIdForCover();
				System.out.println("Cover sys id is--------->" + sysId);
				gridValueBean.setPTC_SYS_ID(sysId);
				gridValueBean.setPTC_UPD_DT(Calendar.getInstance().getTime());
				gridValueBean.setPTC_UPD_UID(userId);
				System.out.println(" Treaty Type Cover Sys Id is : " + sysId);
				rowUpdated = DelegetForCover
						.updateForTreatyCover(gridValueBean);
				getWarningMap().put("current", "Records Inserted");

			}
			lastUpdateRowIndex = currRowIndex;

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return;
	}

	/* Validation For Cover */

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void coverCodeValidation(FacesContext context,
			UIComponent component, Object value) throws Exception {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		try{
			if ((COMP_PTC_COVER_CODE.getSubmittedValue() != null)) {
				String coverCode = (String) COMP_PTC_COVER_CODE.getSubmittedValue();
				
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
				if(!(coverCode.equals(pm_il_prop_treaty_cover.getPTC_COVER_CODE()))){
					HelperForCover.coverCodeWhenValidateItem(
							compositeAction, 
							coverCode,
							getTempTreaty_TypeBean());
					HelperForCover.L_DUP_COVER(compositeAction, coverCode);
				}
				pm_il_prop_treaty_cover.setPTC_COVER_CODE(coverCode);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void stdTreatyWhenValidate(FacesContext context,
			UIComponent component, Object value){
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		try {
			if (( (Double)value != null)) {
				double stdTreatyLimit = (Double)value;
					HelperForCover.stdTreatyWhenValidateItem(this, stdTreatyLimit);
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
				pm_il_prop_treaty_cover.setPTC_STD_TREATY_LIMIT(stdTreatyLimit);
	
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void stdSubTreatyWhenValidate(FacesContext context,
			UIComponent component, Object value) {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		try{
			if ((COMP_PTC_SUB_STD_TREATY_LIMIT.getSubmittedValue() != null)) {
				double subStdTreatyLimit = (Double)value;
				HelperForCover.subStandardTreatyLimitWhenValidateItem(this,
						subStdTreatyLimit);
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
				pm_il_prop_treaty_cover
						.setPTC_SUB_STD_TREATY_LIMIT(subStdTreatyLimit);
	
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void standMaxRetWhenValidate(FacesContext context,
			UIComponent component, Object value) {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		try{
			if ((COMP_PTC_STD_MAX_RETN.getSubmittedValue() != null)
					&& (COMP_PTC_STD_TREATY_LIMIT.getSubmittedValue() != null)) {
				double stdMaxLim = (Double)value;
				double treatyLimit =  PM_IL_PROP_TREATY_COVER_BEAN.getPTC_STD_TREATY_LIMIT();
				
				
				
				HelperForCover.stdMaxRetention(compositeAction, this, stdMaxLim, treatyLimit);
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
				pm_il_prop_treaty_cover.setPTC_STD_MAX_RETN(stdMaxLim);
	
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void retentionPercentageWhenValidate(FacesContext context,
			UIComponent component, Object value){
		try{
			if (COMP_PTC_RETN_PERC.getSubmittedValue() != null) {
				double retentionPercentage =(Double)value;
				Double M_STDMAX_RETN= null;
				if (retentionPercentage <= 100) {
					PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
					pm_il_prop_treaty_cover.setPTC_RETN_PERC(retentionPercentage);
					pm_il_prop_treaty_type_helper.chechForNegative(retentionPercentage);
					//pm_il_prop_treaty_type_helper.setstdMaxRetnForRetPerc(pm_il_prop_treaty_cover);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "717171"));
				}
				/*if((PM_IL_PROP_TREATY_COVER_BEAN.getPTC_RETN_PERC()==100)&&(PM_IL_PROP_TREATY_COVER_BEAN.getPTC_STD_MAX_RETN()!=null)){
					if(PM_IL_PROP_TREATY_COVER_BEAN.getPTC_STD_MAX_RETN().doubleValue()!=PM_IL_PROP_TREATY_COVER_BEAN.getPTC_STD_TREATY_LIMIT().doubleValue()){
						throw new Exception("Retention Premium Should be :"+PM_IL_PROP_TREATY_COVER_BEAN.getPTC_RETN_PERC()+" % of Standard Treaty Limit for Cover :"+PM_IL_PROP_TREATY_COVER_BEAN.getPTC_COVER_CODE());
					}*/
				
				if((PM_IL_PROP_TREATY_COVER_BEAN.getPTC_STD_MAX_RETN()!=null)){
					M_STDMAX_RETN= (MigratingFunctions.nvl(PM_IL_PROP_TREATY_COVER_BEAN.getPTC_STD_TREATY_LIMIT(), 0) * retentionPercentage) / 100;
					
					if(PM_IL_PROP_TREATY_COVER_BEAN.getPTC_STD_MAX_RETN() > M_STDMAX_RETN)
					{
						throw new Exception("Retention Premium Should be less than or equal to :"+PM_IL_PROP_TREATY_COVER_BEAN.getPTC_RETN_PERC()+" % of Standard Treaty Limit for Cover :"+PM_IL_PROP_TREATY_COVER_BEAN.getPTC_COVER_CODE());
						
					}
					/*if(!(M_STDMAX_RETN.equals(PM_IL_PROP_TREATY_COVER_BEAN.getPTC_STD_MAX_RETN()))){
						throw new Exception("Retention Premium Should be :"+PM_IL_PROP_TREATY_COVER_BEAN.getPTC_RETN_PERC()+" % of Standard Treaty Limit for Cover :"+PM_IL_PROP_TREATY_COVER_BEAN.getPTC_COVER_CODE());
					}	*/			}
				COMP_PTC_STD_MAX_RETN.resetValue();
				COMP_PTC_SSTD_MAX_RETN.resetValue();
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void subStandMaxRetnWhenValidate(FacesContext context,
			UIComponent component, Object value) {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		try{
			if ((COMP_PTC_SSTD_MAX_RETN.getSubmittedValue() != null)
					&& (COMP_PTC_SUB_STD_TREATY_LIMIT.getSubmittedValue() != null)) {
				double subRetnPerc =(Double)value;
				double subTreatyLimit = PM_IL_PROP_TREATY_COVER_BEAN.getPTC_SUB_STD_TREATY_LIMIT();

				HelperForCover.subStandardMaxReten(compositeAction, this, subRetnPerc,
						subTreatyLimit);
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
				pm_il_prop_treaty_cover.setPTC_SSTD_MAX_RETN(subRetnPerc);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void comm1stYearPercWhenValidate(FacesContext context,
			UIComponent component, Object value) {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		try{
			if ((COMP_PTC_COMM_PERC_1ST_YR.getSubmittedValue() != null)) {
				double comm1stYear =(Double)value;
				HelperForCover.commPerc1stYearWhenValidate(this, comm1stYear);
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
				pm_il_prop_treaty_cover.setPTC_COMM_PERC_1ST_YR(comm1stYear);
	
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void commSubYearPercWhenValidate(FacesContext context,
			UIComponent component, Object value) {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		try{
			if ((COMP_PTC_COMM_PERC_SUB_YRS.getSubmittedValue() != null)) {
				double commSubYear = (Double)value;
				HelperForCover.commPercSubYearsWhenValidate(this, commSubYear);
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
				pm_il_prop_treaty_cover.setPTC_COMM_PERC_SUB_YRS(commSubYear);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void subCommRiComm1st(FacesContext context, UIComponent component,
			Object value) {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		try{
			if ((COMP_PTC_SSTD_COMM_PERC_1ST_YR.getSubmittedValue() != null)) {
				double value1 = (Double) value;
				pm_il_prop_treaty_type_helper.chechForNegative(value1);
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
				pm_il_prop_treaty_cover.setPTC_SSTD_COMM_PERC_1ST_YR(value1);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void subCommRiCommSub(FacesContext context, UIComponent component,
			Object value) {

		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		try{
			if ((COMP_PTC_SSTD_COMM_PERC_SUB_YRS.getSubmittedValue() != null)) {
				double value1 =(Double)value; 
				pm_il_prop_treaty_type_helper.chechForNegative(value1);
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
				pm_il_prop_treaty_cover.setPTC_SSTD_COMM_PERC_SUB_YRS(value1);
	
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void subStandardTariff(FacesContext facesContext,
			UIComponent component, Object value) {
		try{
			if (COMP_PTC_SUB_STD_TARIFF.getSubmittedValue() != null) {
				String tariffCode = (String) COMP_PTC_SUB_STD_TARIFF
						.getSubmittedValue();
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
				pm_il_prop_treaty_cover.setPTC_SUB_STD_TARIFF(tariffCode);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void groupCodeValidation(FacesContext context,
			UIComponent component, Object value) {
		//[PREMIAGDC-TREATYMASTER-0087:CHARAN 28-Feb-09 Internal Fix
		try {
			new PM_IL_PROP_TREATY_COVER_HELPER().PTC_CVR_GRP_CODEWhenValidateItem(
					compositeAction,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		//PREMIAGDC-TREATYMASTER-0087:CHARAN 28-Feb-09 Internal Fix]
	}

	public void saveData() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		CommonUtils commonUtils = new CommonUtils();

		try {
			commonUtils.doComitt();
			//setOnLoadFlag(false);  // Commented by Ameen 30.7.2016
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Saved");
			getWarningMap().put("CURRENT", "Records Saved");
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PTC_COVER_CODE_LABEL() {
		return COMP_PTC_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PTC_COVER_CODE() {
		return COMP_PTC_COVER_CODE;
	}

	public void setCOMP_PTC_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_PTC_COVER_CODE_LABEL) {
		this.COMP_PTC_COVER_CODE_LABEL = COMP_PTC_COVER_CODE_LABEL;
	}

	public void setCOMP_PTC_COVER_CODE(HtmlInputText COMP_PTC_COVER_CODE) {
		this.COMP_PTC_COVER_CODE = COMP_PTC_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_PTC_STD_TREATY_LIMIT_LABEL() {
		return COMP_PTC_STD_TREATY_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_PTC_STD_TREATY_LIMIT() {
		return COMP_PTC_STD_TREATY_LIMIT;
	}

	public void setCOMP_PTC_STD_TREATY_LIMIT_LABEL(
			HtmlOutputLabel COMP_PTC_STD_TREATY_LIMIT_LABEL) {
		this.COMP_PTC_STD_TREATY_LIMIT_LABEL = COMP_PTC_STD_TREATY_LIMIT_LABEL;
	}

	public void setCOMP_PTC_STD_TREATY_LIMIT(
			HtmlInputText COMP_PTC_STD_TREATY_LIMIT) {
		this.COMP_PTC_STD_TREATY_LIMIT = COMP_PTC_STD_TREATY_LIMIT;
	}

	public HtmlOutputLabel getCOMP_PTC_SUB_STD_TREATY_LIMIT_LABEL() {
		return COMP_PTC_SUB_STD_TREATY_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_PTC_SUB_STD_TREATY_LIMIT() {
		return COMP_PTC_SUB_STD_TREATY_LIMIT;
	}

	public void setCOMP_PTC_SUB_STD_TREATY_LIMIT_LABEL(
			HtmlOutputLabel COMP_PTC_SUB_STD_TREATY_LIMIT_LABEL) {
		this.COMP_PTC_SUB_STD_TREATY_LIMIT_LABEL = COMP_PTC_SUB_STD_TREATY_LIMIT_LABEL;
	}

	public void setCOMP_PTC_SUB_STD_TREATY_LIMIT(
			HtmlInputText COMP_PTC_SUB_STD_TREATY_LIMIT) {
		this.COMP_PTC_SUB_STD_TREATY_LIMIT = COMP_PTC_SUB_STD_TREATY_LIMIT;
	}

	public HtmlOutputLabel getCOMP_PTC_RETN_PERC_LABEL() {
		return COMP_PTC_RETN_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PTC_RETN_PERC() {
		return COMP_PTC_RETN_PERC;
	}

	public void setCOMP_PTC_RETN_PERC_LABEL(
			HtmlOutputLabel COMP_PTC_RETN_PERC_LABEL) {
		this.COMP_PTC_RETN_PERC_LABEL = COMP_PTC_RETN_PERC_LABEL;
	}

	public void setCOMP_PTC_RETN_PERC(HtmlInputText COMP_PTC_RETN_PERC) {
		this.COMP_PTC_RETN_PERC = COMP_PTC_RETN_PERC;
	}

	public HtmlOutputLabel getCOMP_PTC_STD_MAX_RETN_LABEL() {
		return COMP_PTC_STD_MAX_RETN_LABEL;
	}

	public HtmlInputText getCOMP_PTC_STD_MAX_RETN() {
		return COMP_PTC_STD_MAX_RETN;
	}

	public void setCOMP_PTC_STD_MAX_RETN_LABEL(
			HtmlOutputLabel COMP_PTC_STD_MAX_RETN_LABEL) {
		this.COMP_PTC_STD_MAX_RETN_LABEL = COMP_PTC_STD_MAX_RETN_LABEL;
	}

	public void setCOMP_PTC_STD_MAX_RETN(HtmlInputText COMP_PTC_STD_MAX_RETN) {
		this.COMP_PTC_STD_MAX_RETN = COMP_PTC_STD_MAX_RETN;
	}

	public HtmlOutputLabel getCOMP_PTC_SSTD_MAX_RETN_LABEL() {
		return COMP_PTC_SSTD_MAX_RETN_LABEL;
	}

	public HtmlInputText getCOMP_PTC_SSTD_MAX_RETN() {
		return COMP_PTC_SSTD_MAX_RETN;
	}

	public void setCOMP_PTC_SSTD_MAX_RETN_LABEL(
			HtmlOutputLabel COMP_PTC_SSTD_MAX_RETN_LABEL) {
		this.COMP_PTC_SSTD_MAX_RETN_LABEL = COMP_PTC_SSTD_MAX_RETN_LABEL;
	}

	public void setCOMP_PTC_SSTD_MAX_RETN(HtmlInputText COMP_PTC_SSTD_MAX_RETN) {
		this.COMP_PTC_SSTD_MAX_RETN = COMP_PTC_SSTD_MAX_RETN;
	}

	public HtmlOutputLabel getCOMP_PTC_COMM_PERC_1ST_YR_LABEL() {
		return COMP_PTC_COMM_PERC_1ST_YR_LABEL;
	}

	public HtmlInputText getCOMP_PTC_COMM_PERC_1ST_YR() {
		return COMP_PTC_COMM_PERC_1ST_YR;
	}

	public void setCOMP_PTC_COMM_PERC_1ST_YR_LABEL(
			HtmlOutputLabel COMP_PTC_COMM_PERC_1ST_YR_LABEL) {
		this.COMP_PTC_COMM_PERC_1ST_YR_LABEL = COMP_PTC_COMM_PERC_1ST_YR_LABEL;
	}

	public void setCOMP_PTC_COMM_PERC_1ST_YR(
			HtmlInputText COMP_PTC_COMM_PERC_1ST_YR) {
		this.COMP_PTC_COMM_PERC_1ST_YR = COMP_PTC_COMM_PERC_1ST_YR;
	}

	public HtmlOutputLabel getCOMP_PTC_COMM_PERC_SUB_YRS_LABEL() {
		return COMP_PTC_COMM_PERC_SUB_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PTC_COMM_PERC_SUB_YRS() {
		return COMP_PTC_COMM_PERC_SUB_YRS;
	}

	public void setCOMP_PTC_COMM_PERC_SUB_YRS_LABEL(
			HtmlOutputLabel COMP_PTC_COMM_PERC_SUB_YRS_LABEL) {
		this.COMP_PTC_COMM_PERC_SUB_YRS_LABEL = COMP_PTC_COMM_PERC_SUB_YRS_LABEL;
	}

	public void setCOMP_PTC_COMM_PERC_SUB_YRS(
			HtmlInputText COMP_PTC_COMM_PERC_SUB_YRS) {
		this.COMP_PTC_COMM_PERC_SUB_YRS = COMP_PTC_COMM_PERC_SUB_YRS;
	}

	public HtmlOutputLabel getCOMP_PTC_SSTD_COMM_PERC_1ST_YR_LABEL() {
		return COMP_PTC_SSTD_COMM_PERC_1ST_YR_LABEL;
	}

	public HtmlInputText getCOMP_PTC_SSTD_COMM_PERC_1ST_YR() {
		return COMP_PTC_SSTD_COMM_PERC_1ST_YR;
	}

	public void setCOMP_PTC_SSTD_COMM_PERC_1ST_YR_LABEL(
			HtmlOutputLabel COMP_PTC_SSTD_COMM_PERC_1ST_YR_LABEL) {
		this.COMP_PTC_SSTD_COMM_PERC_1ST_YR_LABEL = COMP_PTC_SSTD_COMM_PERC_1ST_YR_LABEL;
	}

	public void setCOMP_PTC_SSTD_COMM_PERC_1ST_YR(
			HtmlInputText COMP_PTC_SSTD_COMM_PERC_1ST_YR) {
		this.COMP_PTC_SSTD_COMM_PERC_1ST_YR = COMP_PTC_SSTD_COMM_PERC_1ST_YR;
	}

	public HtmlOutputLabel getCOMP_PTC_SSTD_COMM_PERC_SUB_YRS_LABEL() {
		return COMP_PTC_SSTD_COMM_PERC_SUB_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PTC_SSTD_COMM_PERC_SUB_YRS() {
		return COMP_PTC_SSTD_COMM_PERC_SUB_YRS;
	}

	public void setCOMP_PTC_SSTD_COMM_PERC_SUB_YRS_LABEL(
			HtmlOutputLabel COMP_PTC_SSTD_COMM_PERC_SUB_YRS_LABEL) {
		this.COMP_PTC_SSTD_COMM_PERC_SUB_YRS_LABEL = COMP_PTC_SSTD_COMM_PERC_SUB_YRS_LABEL;
	}

	public void setCOMP_PTC_SSTD_COMM_PERC_SUB_YRS(
			HtmlInputText COMP_PTC_SSTD_COMM_PERC_SUB_YRS) {
		this.COMP_PTC_SSTD_COMM_PERC_SUB_YRS = COMP_PTC_SSTD_COMM_PERC_SUB_YRS;
	}

	public HtmlOutputLabel getCOMP_PTC_SUB_STD_TARIFF_LABEL() {
		return COMP_PTC_SUB_STD_TARIFF_LABEL;
	}

	public HtmlInputText getCOMP_PTC_SUB_STD_TARIFF() {
		return COMP_PTC_SUB_STD_TARIFF;
	}

	public void setCOMP_PTC_SUB_STD_TARIFF_LABEL(
			HtmlOutputLabel COMP_PTC_SUB_STD_TARIFF_LABEL) {
		this.COMP_PTC_SUB_STD_TARIFF_LABEL = COMP_PTC_SUB_STD_TARIFF_LABEL;
	}

	public void setCOMP_PTC_SUB_STD_TARIFF(HtmlInputText COMP_PTC_SUB_STD_TARIFF) {
		this.COMP_PTC_SUB_STD_TARIFF = COMP_PTC_SUB_STD_TARIFF;
	}

	public HtmlOutputLabel getCOMP_UI_M_PTC_SUB_STD_TARIFF_DESC_LABEL() {
		return COMP_UI_M_PTC_SUB_STD_TARIFF_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PTC_SUB_STD_TARIFF_DESC() {
		return COMP_UI_M_PTC_SUB_STD_TARIFF_DESC;
	}

	public void setCOMP_UI_M_PTC_SUB_STD_TARIFF_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PTC_SUB_STD_TARIFF_DESC_LABEL) {
		this.COMP_UI_M_PTC_SUB_STD_TARIFF_DESC_LABEL = COMP_UI_M_PTC_SUB_STD_TARIFF_DESC_LABEL;
	}

	public void setCOMP_UI_M_PTC_SUB_STD_TARIFF_DESC(
			HtmlInputText COMP_UI_M_PTC_SUB_STD_TARIFF_DESC) {
		this.COMP_UI_M_PTC_SUB_STD_TARIFF_DESC = COMP_UI_M_PTC_SUB_STD_TARIFF_DESC;
	}

	public HtmlOutputLabel getCOMP_PTC_GROUP_COVER_YN_LABEL() {
		return COMP_PTC_GROUP_COVER_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PTC_GROUP_COVER_YN() {
		return COMP_PTC_GROUP_COVER_YN;
	}

	public void setCOMP_PTC_GROUP_COVER_YN_LABEL(
			HtmlOutputLabel COMP_PTC_GROUP_COVER_YN_LABEL) {
		this.COMP_PTC_GROUP_COVER_YN_LABEL = COMP_PTC_GROUP_COVER_YN_LABEL;
	}

	public void setCOMP_PTC_GROUP_COVER_YN(
			HtmlSelectOneMenu COMP_PTC_GROUP_COVER_YN) {
		this.COMP_PTC_GROUP_COVER_YN = COMP_PTC_GROUP_COVER_YN;
	}

	public HtmlOutputLabel getCOMP_PTC_CVR_GRP_CODE_LABEL() {
		return COMP_PTC_CVR_GRP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PTC_CVR_GRP_CODE() {
		return COMP_PTC_CVR_GRP_CODE;
	}

	public void setCOMP_PTC_CVR_GRP_CODE_LABEL(
			HtmlOutputLabel COMP_PTC_CVR_GRP_CODE_LABEL) {
		this.COMP_PTC_CVR_GRP_CODE_LABEL = COMP_PTC_CVR_GRP_CODE_LABEL;
	}

	public void setCOMP_PTC_CVR_GRP_CODE(HtmlInputText COMP_PTC_CVR_GRP_CODE) {
		this.COMP_PTC_CVR_GRP_CODE = COMP_PTC_CVR_GRP_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_LABEL() {
		return COMP_UI_M_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL) {
		this.COMP_UI_M_COVER_DESC_LABEL = COMP_UI_M_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText COMP_UI_M_COVER_DESC) {
		this.COMP_UI_M_COVER_DESC = COMP_UI_M_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PTC_CVR_GRP_CODE_DESC_LABEL() {
		return COMP_UI_M_PTC_CVR_GRP_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PTC_CVR_GRP_CODE_DESC() {
		return COMP_UI_M_PTC_CVR_GRP_CODE_DESC;
	}

	public void setCOMP_UI_M_PTC_CVR_GRP_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PTC_CVR_GRP_CODE_DESC_LABEL) {
		this.COMP_UI_M_PTC_CVR_GRP_CODE_DESC_LABEL = COMP_UI_M_PTC_CVR_GRP_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PTC_CVR_GRP_CODE_DESC(
			HtmlInputText COMP_UI_M_PTC_CVR_GRP_CODE_DESC) {
		this.COMP_UI_M_PTC_CVR_GRP_CODE_DESC = COMP_UI_M_PTC_CVR_GRP_CODE_DESC;
	}

	public PM_IL_PROP_TREATY_COVER getPM_IL_PROP_TREATY_COVER_BEAN() {
		return PM_IL_PROP_TREATY_COVER_BEAN;
	}

	public void setPM_IL_PROP_TREATY_COVER_BEAN(
			PM_IL_PROP_TREATY_COVER PM_IL_PROP_TREATY_COVER_BEAN) {
		this.PM_IL_PROP_TREATY_COVER_BEAN = PM_IL_PROP_TREATY_COVER_BEAN;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getPrevRowInd() {
		return prevRowInd;
	}

	public void setPrevRowInd(int prevRowInd) {
		this.prevRowInd = prevRowInd;
	}

	public ArrayList<PM_IL_PROP_TREATY_COVER> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(
			ArrayList<PM_IL_PROP_TREATY_COVER> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<SelectItem> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<SelectItem> groupList) {
		this.groupList = groupList;
	}

	public List getGroupCodeLovList() {
		return groupCodeLovList;
	}

	public void setGroupCodeLovList(List groupCodeLovList) {
		this.groupCodeLovList = groupCodeLovList;
	}

	public int getLastUpdateRowIndex() {
		return lastUpdateRowIndex;
	}

	public void setLastUpdateRowIndex(int lastUpdateRowIndex) {
		this.lastUpdateRowIndex = lastUpdateRowIndex;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	/**
	 * Back To Treaty Type Jsp
	 * 
	 * @return
	 */
	public String backtoTreatyType() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		return "TreatyType";
	}

	/*
	 * public String goToGroup() {
	 * 
	 * FacesContext context = FacesContext.getCurrentInstance();
	 * HttpServletRequest request = (HttpServletRequest) context
	 * .getExternalContext().getRequest(); HttpSession session =
	 * request.getSession();
	 * 
	 * String name = ""; for (int i = 0; i < dataTableList.size(); i++) {
	 * 
	 * PM_IL_PROP_TREATY_COVER tempName = new PM_IL_PROP_TREATY_COVER();
	 * tempName = dataTableList.get(i);
	 * 
	 * System.out.println("Element Selected----->" + tempName); if (tempName !=
	 * null && tempName.isSelected()) {
	 * 
	 * PM_IL_PROP_TREATY_COVER_BEAN = dataTableList.get(i); CommonUtils
	 * commonUtils = new CommonUtils(); CRUDHandler handler = new CRUDHandler();
	 * 
	 * String query = "SELECT * " + "FROM PM_IL_PROP_TTYCOV_GRP " + "WHERE
	 * PTG_PTC_SYS_ID ='" + PM_IL_PROP_TREATY_COVER_BEAN.getPTC_SYS_ID() + "'";
	 * 
	 * try { Connection connection = commonUtils.getConnection(); Map sessionmap =
	 * FacesContext.getCurrentInstance() .getExternalContext().getSessionMap();
	 * PM_IL_PROP_TREATY_COMPOSITE_ACTION compAction =
	 * (PM_IL_PROP_TREATY_COMPOSITE_ACTION) sessionmap
	 * .get("PM_IL_PROP_TREATY_COMPOSITE_ACTION");
	 * 
	 * compAction .getPM_IL_PROP_TTYCOV_GRP_ACTION() .setDataTableList(
	 * (ArrayList<PM_IL_PROP_TTYCOV_GRP>) getList(query)); } catch (Exception
	 * e) { e.printStackTrace(); } System.out.println("Selected Item is
	 * --------> " + i); name = "GroupCoverDetails"; return name; } else { name =
	 * ""; } } return name;
	 * 
	 * return "GroupCoverDetails"; }
	 */

	/**
	 * Gets the List of Records Related to a particular parent record
	 * 
	 * @param query
	 * @return
	 */
	public List<PM_IL_PROP_TTYCOV_GRP> getList(String query) {
		List<PM_IL_PROP_TTYCOV_GRP> arrayList = new ArrayList<PM_IL_PROP_TTYCOV_GRP>();
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			arrayList = handler.fetch(query,
					"com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TTYCOV_GRP",
					connection);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return arrayList;
	}

	public String goToGroup() {
		PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = this.PM_IL_PROP_TREATY_COVER_BEAN;
		String selectQuery = "SELECT ROWID, PM_IL_PROP_TTYCOV_GRP.* FROM PM_IL_PROP_TTYCOV_GRP "
				+ "WHERE PTG_PTC_SYS_ID ='"
				+ pm_il_prop_treaty_cover.getPTC_SYS_ID() + "'";
		compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION().setTempCoverBean(
				pm_il_prop_treaty_cover);
		setPM_IL_PROP_TREATY_COVER_BEAN(pm_il_prop_treaty_cover);
		try {
			/*Added by Janani on 07.02.2018 for ZBLIFE-1468859*/
			
			HelperForCover.executeQuery(compositeAction);
			/*compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION()
					.setDataTableList(
							(ArrayList<PM_IL_PROP_TTYCOV_GRP>) getGroupDetailsList(selectQuery));*/

			/*End of ZBLIFE-1468859*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		Iterator<PM_IL_PROP_TTYCOV_GRP> iterator = compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION().getDataTableList().iterator();
		while(iterator.hasNext()){
			PM_IL_PROP_TTYCOV_GRP pm_il_prop_ttycov_grp = iterator.next();
			pm_il_prop_ttycov_grp.setRowSelected(false);

		}
		
		
		if (compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION().getDataTableList().size() !=0){					
			compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION().setPM_IL_PROP_TTYCOV_GRP_BEAN(compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION().getDataTableList().get(0));
			compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION().getPM_IL_PROP_TTYCOV_GRP_BEAN().setRowSelected(true);
		}
		
		return "GroupCoverDetailsForTreaty";
	}

	public List<PM_IL_PROP_TTYCOV_GRP> getGroupDetailsList(String query) throws Exception {
		List<PM_IL_PROP_TTYCOV_GRP> arrayList = new ArrayList<PM_IL_PROP_TTYCOV_GRP>();
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			arrayList = handler.fetch(query,
					"com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TTYCOV_GRP",
					connection);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return arrayList;
	}

	public void selectedCheckbox(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String selected = (String) (input.getSubmittedValue());
		int row = dataTable.getRowIndex();
		Integer integer = new Integer(row);
		if ("true".equalsIgnoreCase(selected)) {
			if (!selectedList.contains(integer)) {
				selectedList.add(row);
			}
		} else {
			if (selectedList.contains(integer)) {
				selectedList.remove(integer);
			}
		}
		PM_IL_PROP_TREATY_COVER treatyTypeBean = dataTableList.get(row);
		if (selected.equals("true"))
			treatyTypeBean.setSelected(true);
		else
			treatyTypeBean.setSelected(false);
	}

	public void coverDetails(double sysId) {
		mySysId = sysId;
		String name = "";
		CRUDHandler handler = new CRUDHandler();
		String selectQuery = "SELECT P.*,PC.*	"
				+ "FROM PM_IL_PROP_TREATY_TYPE P,PM_IL_PROP_TREATY_COVER PC "
				+ "WHERE PC.PTC_PTT_SYS_ID=P.PTT_SYS_ID AND PC.PTC_PTT_SYS_ID = '"
				+ sysId + "' ";
		try {
			Connection connection = CommonUtils.getConnection();
			dataTableList = (ArrayList<PM_IL_PROP_TREATY_COVER>) getCoverDetailsList(selectQuery);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		selectedList.clear();
		name = "DetailCover";
	}

	public List<PM_IL_PROP_TREATY_COVER> getCoverDetailsList(String query) throws Exception {
		List<PM_IL_PROP_TREATY_COVER> arrayList = new ArrayList<PM_IL_PROP_TREATY_COVER>();
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			arrayList = handler.fetch(query,
					"com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TREATY_COVER",
					connection);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return arrayList;
	}

	public HtmlCommandButton getCOMP_BUTTON_GRP_CVR() {
		return COMP_BUTTON_GRP_CVR;
	}

	public void setCOMP_BUTTON_GRP_CVR(HtmlCommandButton comp_button_grp_cvr) {
		COMP_BUTTON_GRP_CVR = comp_button_grp_cvr;
	}

	public PM_IL_PROP_TREATY_TYPE getTempTreaty_TypeBean() {
		return tempTreaty_TypeBean;
	}

	public void setTempTreaty_TypeBean(
			PM_IL_PROP_TREATY_TYPE tempTreaty_TypeBean) {
		this.tempTreaty_TypeBean = tempTreaty_TypeBean;
	}

	// [ Added for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();
		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
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
	// Added for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009 ]
	
	public void onLoad(PhaseEvent event){
		try{
			if(!isOnLoadFlag()){
				new PM_IL_PROP_TREATY_COVER_HELPER().getCoverDetailsList(compositeAction);
				
				String treatyType = compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION()
					.getTempTreaty_TypeBean().getPTT_TREATY_TYPE();
				
				//[PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix		
				if(treatyType != null && !treatyType.contains("RETN")) {
					setRetensionDisabled(true);
				} else {
					setRetensionDisabled(false);
				}
				
				Iterator<PM_IL_PROP_TREATY_COVER> iterator = getDataTableList().iterator();
				while(iterator.hasNext()){
					PM_IL_PROP_TREATY_COVER_BEAN = iterator.next();
					PM_IL_PROP_TREATY_COVER_BEAN.setRowSelected(false);
				}
				
				if (getDataTableList().size() !=0){					
					setPM_IL_PROP_TREATY_COVER_BEAN(getDataTableList().get(0));
					getPM_IL_PROP_TREATY_COVER_BEAN().setRowSelected(true);
				}
				setOnLoadFlag(true);
				
				if((Integer.parseInt(CommonUtils.getPPSystemParameterValue("IL_RI_COMM").toString())==2))
				{
					COMP_PTC_COMM_PERC_1ST_YR.setRendered(false);
				}
				else
				{
					COMP_PTC_COMM_PERC_1ST_YR.setRendered(true);
				}
			}
			
			/*Added by Janani on 25.01.2018 for ZBLIFE-1468859*/
			
			getCoverType();
					
			/*End of ZBLIFE-1468859*/
			
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	public void post(ActionEvent ae) {
		try{
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
			.getExternalContext().getSessionMap();
			String userId = (String) sessionMap.get("GLOBAL.M_USER_ID");
			if(PM_IL_PROP_TREATY_COVER_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					DelegetForCover.updateForTreatyCover(this.PM_IL_PROP_TREATY_COVER_BEAN);
					//ADDED BY SARANYA ON  17-01-2016
					new CRUDHandler().executeUpdate(PM_IL_PROP_TREATY_COVER_BEAN, commonUtils.getConnection());
					//END
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {
				if(isINSERT_ALLOWED()) {
					PM_IL_PROP_TREATY_TYPE typeValue = compositeAction
							.getPM_IL_PROP_TREATY_TYPE_ACTION()
							.getPM_IL_PROP_TREATY_TYPE_BEAN();
					Double parentSysId = typeValue.getPTT_SYS_ID();
					this.PM_IL_PROP_TREATY_COVER_BEAN.setPTC_PTT_SYS_ID(parentSysId);
					Double sysId = DelegetForCover.getSysIdForCover();
					this.PM_IL_PROP_TREATY_COVER_BEAN.setPTC_SYS_ID(sysId);
					this.PM_IL_PROP_TREATY_COVER_BEAN.setPTC_UPD_DT(Calendar.getInstance().getTime());
					this.PM_IL_PROP_TREATY_COVER_BEAN.setPTC_UPD_UID(userId);
					DelegetForCover.insertValues(this);
					
					
					/*added by raja on 16-08-2017 for ZBILQC-1735236*/
					
					if((Integer.parseInt(CommonUtils.getPPSystemParameterValue("IL_RI_COMM").toString())==2))
					{
						PM_IL_PROP_TREATY_COVER_BEAN.setPTC_COMM_PERC_1ST_YR(0.0);
						PM_IL_PROP_TREATY_COVER_BEAN.setPTC_COMM_PERC_SUB_YRS(0.0);
					}
					
					/*end*/
					new CRUDHandler().executeInsert(PM_IL_PROP_TREATY_COVER_BEAN, commonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					dataTableList.add(PM_IL_PROP_TREATY_COVER_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_PROP_TREATY_COVER_BEAN.setRowSelected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {				
				PM_IL_PROP_TREATY_COVER_BEAN = (PM_IL_PROP_TREATY_COVER) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_PROP_TREATY_COVER_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PTC_COVER_CODE.resetValue();
		COMP_UI_M_COVER_DESC.resetValue();
		COMP_PTC_STD_TREATY_LIMIT.resetValue();
		COMP_PTC_SUB_STD_TREATY_LIMIT.resetValue();
		COMP_PTC_RETN_PERC.resetValue();
		COMP_PTC_STD_MAX_RETN.resetValue();
		COMP_PTC_SSTD_MAX_RETN.resetValue();
		COMP_PTC_COMM_PERC_1ST_YR.resetValue();
		COMP_PTC_COMM_PERC_SUB_YRS.resetValue();
		COMP_PTC_SSTD_COMM_PERC_1ST_YR.resetValue();
		COMP_PTC_SSTD_COMM_PERC_SUB_YRS.resetValue();
		COMP_PTC_SUB_STD_TARIFF.resetValue();
		COMP_UI_M_PTC_SUB_STD_TARIFF_DESC.resetValue();
		COMP_PTC_GROUP_COVER_YN.resetValue();
		COMP_PTC_CVR_GRP_CODE.resetValue();
		COMP_UI_M_PTC_CVR_GRP_CODE_DESC.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_PROP_TREATY_COVER> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String getFilterByPTC_COVER_CODE() {
		return filterByPTC_COVER_CODE;
	}

	public void setFilterByPTC_COVER_CODE(String filterByPTC_COVER_CODE) {
		this.filterByPTC_COVER_CODE = filterByPTC_COVER_CODE;
	}

	public String getFilterByPTC_STD_TREATY_LIMIT() {
		return filterByPTC_STD_TREATY_LIMIT;
	}

	public void setFilterByPTC_STD_TREATY_LIMIT(String filterByPTC_STD_TREATY_LIMIT) {
		this.filterByPTC_STD_TREATY_LIMIT = filterByPTC_STD_TREATY_LIMIT;
	}

	public String getFilterByPTC_COMM_PERC_1ST_YR() {
		return filterByPTC_COMM_PERC_1ST_YR;
	}

	public void setFilterByPTC_COMM_PERC_1ST_YR(String filterByPTC_COMM_PERC_1ST_YR) {
		this.filterByPTC_COMM_PERC_1ST_YR = filterByPTC_COMM_PERC_1ST_YR;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public String getFilterByPTC_SUB_STD_TREATY_LIMIT() {
		return filterByPTC_SUB_STD_TREATY_LIMIT;
	}

	public void setFilterByPTC_SUB_STD_TREATY_LIMIT(
			String filterByPTC_SUB_STD_TREATY_LIMIT) {
		this.filterByPTC_SUB_STD_TREATY_LIMIT = filterByPTC_SUB_STD_TREATY_LIMIT;
		
	}
	public List<PM_IL_PROP_TREATY_PART_CUST> getCustomerDetailsList(String query) throws Exception {
		List<PM_IL_PROP_TREATY_PART_CUST> arrayList = new ArrayList<PM_IL_PROP_TREATY_PART_CUST>();
		ResultSet resultSet = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_PART_CUST pm_il_prop_treaty_part_cust = new PM_IL_PROP_TREATY_PART_CUST();
				pm_il_prop_treaty_part_cust.setPTPC_SYS_ID(resultSet
						.getDouble("PTPC_SYS_ID"));
				pm_il_prop_treaty_part_cust.setPTPC_PTT_SYS_ID(resultSet
						.getDouble("PTPC_PTT_SYS_ID"));
				//ADDED BY SARANYA ON  17-01-2016 FOR TREATY ISSUE
				pm_il_prop_treaty_part_cust.setPTPC_PTC_SYS_ID( resultSet
						.getDouble("PTPC_PTC_SYS_ID"));
				//END
				pm_il_prop_treaty_part_cust.setPTPC_CUST_CODE(resultSet
						.getString("PTPC_CUST_CODE"));
				pm_il_prop_treaty_part_cust.setPTPC_SHARE_PERC(resultSet
						.getDouble("PTPC_SHARE_PERC"));
				pm_il_prop_treaty_part_cust.setPTPC_LEADER_YN(resultSet
						.getString("PTPC_LEADER_YN"));
				pm_il_prop_treaty_part_cust.setPTPC_CR_DT(resultSet
						.getDate("PTPC_CR_DT"));
				pm_il_prop_treaty_part_cust.setPTPC_CR_UID(resultSet
						.getString("PTPC_CR_UID"));
				pm_il_prop_treaty_part_cust.setPTPC_UPD_DT(resultSet
						.getDate("PTPC_UPD_DT"));
				pm_il_prop_treaty_part_cust.setPTPC_UPD_UID(resultSet
						.getString("PTPC_UPD_UID"));
				pm_il_prop_treaty_part_cust.setROWID(resultSet
						.getString("PTPC_ROWID"));
				arrayList.add(pm_il_prop_treaty_part_cust);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return arrayList;
	}

	public String companyDetails() {
		ArrayList<PM_IL_PROP_TREATY_PART_CUST> detailsTableList = null;
		PM_IL_PROP_TREATY_COVER checkedBean = null;
		int totalCheckBoxSelected = 0;
		String returnValue = null;
		try {
			if(dataTableList != null && dataTableList.size() > 0) {
				for(PM_IL_PROP_TREATY_COVER tempBean : dataTableList) {
					if(tempBean!= null) {
						checkedBean = tempBean;
						if ("dataTableSelectedRow".equalsIgnoreCase(checkedBean.getRowSelected())) {
							compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().setPM_IL_PROP_TREATY_COVER_BEAN(checkedBean);
							double sysId = checkedBean.getPTC_SYS_ID();
							double sysIds= checkedBean.getPTC_PTT_SYS_ID();
							System.out.println("value of the sysId------->"+sysId);
							System.out.println("value of the sysIds------->"+sysIds);
						
							String selectQuery = "SELECT P.*,PTPC.*,P.ROWID AS P_ROWID,PTPC.ROWID AS PTPC_ROWID  " +
									"  FROM PM_IL_PROP_TREATY_COVER P, PM_IL_PROP_TREATY_PART_CUST PTPC  "
								+ "  WHERE PTPC.PTPC_PTC_SYS_ID=P.PTC_SYS_ID AND PTPC.PTPC_PTC_SYS_ID= '"+ sysId + "' ";
							compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().setDataTableList
							((ArrayList<PM_IL_PROP_TREATY_PART_CUST>) getCustomerDetailsList(selectQuery));
							new PM_IL_PROP_TREATY_PART_CUST_HELPER().
							pilm015_apac_pm_il_prop_treaty_part_cust__post_query(compositeAction);
							Iterator<PM_IL_PROP_TREATY_PART_CUST> iterator = compositeAction.
								getPM_IL_PROP_TREATY_PART_CUST_ACTION().getDataTableList().iterator();
							while(iterator.hasNext()){
								PM_IL_PROP_TREATY_PART_CUST pm_il_prop_treaty_part_cust = iterator.next();
								pm_il_prop_treaty_part_cust.setRowSelected(false);
							}
							if (compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().getDataTableList().size() !=0){					
								compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().
									setPM_IL_PROP_TREATY_PART_CUST_BEAN(compositeAction.
										getPM_IL_PROP_TREATY_PART_CUST_ACTION().getDataTableList().get(0));
								compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().
									getPM_IL_PROP_TREATY_PART_CUST_BEAN().setRowSelected(true);
								
								compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().getHelper().getRateDetails(compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION());
							}
							else
							{
								System.out.println("Test");
								PM_IL_PROP_TREATY_PART_CUST pm_il_prop_treaty_part_cust=new PM_IL_PROP_TREATY_PART_CUST();
								compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().
								setPM_IL_PROP_TREATY_PART_CUST_BEAN(pm_il_prop_treaty_part_cust);
							}
							compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().getCOMP_PTPC_CUST_CODE().resetValue();
							compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().getCOMP_PTPC_LEADER_YN().resetValue();
							compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().getCOMP_PTPC_SHARE_PERC().resetValue();
							compositeAction.getPM_IL_PROP_TREATY_PART_CUST_ACTION().getCOMP_UI_M_COMP_DESC().resetValue();
							returnValue = "CompanyDetails";
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return returnValue;
	}
	
	
	/*Added by Janani on 25.01.2018 for ZBLIFE-1468859*/
	
	public void getCoverType() throws Exception {
		Connection connection = null;
		ResultSet resultset = null;
		
		String sql_C1 = "SELECT COVER_TYPE FROM  PM_IL_COVER WHERE  COVER_CODE  = ? ";

		
		System.out.println("enters into getCoverType");
		
		try {

			connection = CommonUtils.getConnection();
			resultset = new CRUDHandler().executeSelectStatement(sql_C1, connection,new Object[]{compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().getPTC_COVER_CODE()});
			if(resultset.next()){
				
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setCoverType(resultset.getString("COVER_TYPE"));
			}
			
			System.out.println("getCoverType          "+compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().getCoverType());

			
			if(!compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().getCoverType().equalsIgnoreCase("B") 
					)
			{
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setPTC_GROUP_COVER_YN_DIS(true);
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setPTC_CVR_GRP_CODE_DIS(true);
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setUI_M_COVER_DESC_DIS(true);
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getCOMP_BUTTON_GRP_CVR().setDisabled(true);
				
			}
			else
			{
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setPTC_GROUP_COVER_YN_DIS(false);
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setPTC_CVR_GRP_CODE_DIS(false);
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setUI_M_COVER_DESC_DIS(false);
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getCOMP_BUTTON_GRP_CVR().setDisabled(false);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally {
			CommonUtils.closeCursor(resultset);
		}

	}
	
	
	/*End of ZBLIFE-1468859*/
	
	/*Added by Janani on 31.01.2018 for ZBLIFE-1468859*/
	
	public String getCoverDesc(String coverCode)
	{
		String query = "SELECT COVER_CODE, COVER_DESC FROM PM_IL_COVER " +
				"WHERE COVER_FRZ_FLAG = 'N'  " +
				"AND COVER_TYPE IN ('A','S','B') " +
				"AND COVER_CODE LIKE NVL(?, COVER_CODE) ";
		
		System.out.println("enters into getCoverDesc");
		System.out.println("coverCode                  "+coverCode);
		
		Connection connection = null;
		ResultSet rst = null;
		CRUDHandler handler = new CRUDHandler();
		
		String cover_desc = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(query, connection, new Object[]{coverCode});
			while(rst.next()){
				
				//compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION().getPM_IL_PROP_TTYCOV_GRP_BEAN().setUI_M_PTG_COVER_CODE_DESC(rst.getString(2));
				
				cover_desc = rst.getString(2);
				
				//compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION().getCOMP_UI_M_PTG_COVER_CODE_DESC().resetValue();
				
				System.out.println("cover_desc                 "+cover_desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return cover_desc;
	}
	
	/*End of ZBLIFE-1468859*/
}
