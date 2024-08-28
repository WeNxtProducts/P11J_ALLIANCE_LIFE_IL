package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROP_TTYCOV_GRP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PTG_PTC_CVR_GRP_CODE_LABEL;

	private HtmlInputText COMP_PTG_PTC_CVR_GRP_CODE;

	private HtmlOutputLabel COMP_PTG_COVER_CODE_LABEL;

	private HtmlInputText COMP_PTG_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_PTG_COVER_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PTG_COVER_CODE_DESC;

	private HtmlOutputLabel COMP_PTG_SR_NO_LABEL;

	private HtmlInputText COMP_PTG_SR_NO;

	private HtmlCommandButton COMP_PUSH_BUTTON534;

	private PM_IL_PROP_TTYCOV_GRP PM_IL_PROP_TTYCOV_GRP_BEAN;

	private HtmlCommandButton COMP_BUTTON_GRP_CVR;

	private int currentPage;

	private int recordsPerPage = 5;

	private int prevRowInd;

	private int lastUpdateRowIndex;

	private UIData dataTable;

	private ArrayList<PM_IL_PROP_TTYCOV_GRP> dataTableList;

	PM_IL_PROP_TTYCOV_GRP_DELEGATE DELEGATEFORGROUPCVR;
	PM_IL_PROP_TTYCOV_GRP_HELPER groupHelper;

	private PM_IL_PROP_TREATY_COVER tempCoverBean;
	
	//filters
	private String filterByPTG_PTC_CVR_GRP_CODE;
	
	private String filterByPTG_COVER_CODE;
	
	private String filterByPTG_SR_NO;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	CommonUtils commonUtils =new CommonUtils() ;
	
	private int lastUpdatedRowIndex;
	
	
	/*Commented and Added by Janani on 10.01.2018 for ZBLIFE-1468859*/
	
	//private List<PM_IL_PROP_TTYCOV_GRP> ttyCovGroupList = new ArrayList<PM_IL_PROP_TTYCOV_GRP>();
	
	private List<PM_IL_PROP_TTYCOV_GRP> ttyCovGroupList = null;
		
	public List<PM_IL_PROP_TTYCOV_GRP> getTtyCovGroupList() {
		return ttyCovGroupList;
	}

	public void setTtyCovGroupList(List<PM_IL_PROP_TTYCOV_GRP> ttyCovGroupList) {
		this.ttyCovGroupList = ttyCovGroupList;
	}

	
	/*End of ZBLIFE-1468859*/
	
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;

	public PM_IL_PROP_TTYCOV_GRP_ACTION() {
		groupHelper = new PM_IL_PROP_TTYCOV_GRP_HELPER();
		PM_IL_PROP_TTYCOV_GRP_BEAN = new PM_IL_PROP_TTYCOV_GRP();
		dataTableList = new ArrayList<PM_IL_PROP_TTYCOV_GRP>();
		DELEGATEFORGROUPCVR = new PM_IL_PROP_TTYCOV_GRP_DELEGATE();
		prevRowInd = 0;
		currentPage = 1;
	}

	public String backtoTreatyCover() {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		return "DetailCoverGroup";

	}

	/*public String addNew() {
		int rowCount = 0;

		if (dataTableList == null) {
			dataTableList = new ArrayList<PM_IL_PROP_TTYCOV_GRP>();
		}

		double PTG_SR_NO = dataTableList.size();

		PM_IL_PROP_TTYCOV_GRP pm_il_prop_ttycov_grp = new PM_IL_PROP_TTYCOV_GRP();
		String groupCode = tempCoverBean.getPTC_CVR_GRP_CODE();
		pm_il_prop_ttycov_grp.setPTG_SR_NO(++PTG_SR_NO);
		pm_il_prop_ttycov_grp.setPTG_PTC_CVR_GRP_CODE(groupCode);
		dataTableList.add(pm_il_prop_ttycov_grp);
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
				double PTG_SR_NO = dataTableList.size();
				this.PM_IL_PROP_TTYCOV_GRP_BEAN = new PM_IL_PROP_TTYCOV_GRP();
				String groupCode = tempCoverBean.getPTC_CVR_GRP_CODE();
				this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_SR_NO(++PTG_SR_NO);
				this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_PTC_CVR_GRP_CODE(groupCode);
				resetAllComponent();
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

		System.out.println("-----hi------");

		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataTableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			//[PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix
			for (int index = 0; index < dataTableList.size();index++) {
			//PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix]
				PM_IL_PROP_TTYCOV_GRP bean = dataTableList.get(index);
				if (bean.isSelected()) {
					dataTableList.remove(bean);
					deletedRecordIndex = DELEGATEFORGROUPCVR.delete(bean);
					deletedRecordList.add(deletedRecordIndex);
					//[PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix
					index--;
				}
				//PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix] 
			}

			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current", "Records Deleted");
			}
			lastUpdateRowIndex = -1;

		}

		double var = 0;
		if (dataTableList.size() > 0) {
			Iterator iterator = dataTableList.iterator();
			while (iterator.hasNext()) {

				PM_IL_PROP_TTYCOV_GRP bean = (PM_IL_PROP_TTYCOV_GRP) iterator
						.next();
				var++;
				bean.setPTG_SR_NO(var);
			}
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
		PM_IL_PROP_TTYCOV_GRP bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (dataTableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < dataTableList.size();) {
				bean = dataTableList.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
					dataTableList.remove(bean);
					deletedRecordIndex = DELEGATEFORGROUPCVR.delete(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			double var = 0;
			if(dataTableList.size() > 0) {
				setPM_IL_PROP_TTYCOV_GRP_BEAN(dataTableList.get(0));
				PM_IL_PROP_TTYCOV_GRP_BEAN.setRowSelected(true);
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
		PM_IL_PROP_TTYCOV_GRP_BEAN.setRowSelected(true);	
		}catch(Exception exception){
		}
		return "";
	}

	// [ Commented for grid implementation change, Added by: Ashutosh Sharma, Dated: 16-Feb-2009
	/*public void gridtabListener() {

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TTYCOV_GRP gridValueBean = null;

		PM_IL_PROP_TTYCOV_GRP_HELPER groupHelper = new PM_IL_PROP_TTYCOV_GRP_HELPER();
		System.out.println(lastUpdateRowIndex + "   " + currRowIndex + "  "
				+ prevRowInd);
		try {
			if (lastUpdateRowIndex != -1) {
				if (lastUpdateRowIndex != prevRowInd) {
					if (currRowIndex != prevRowInd) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PM_IL_PROP_TTYCOV_GRP) dataTableList
								.get(prevRowInd);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {

							rowUpdated = DELEGATEFORGROUPCVR
									.update(gridValueBean);
							getWarningMap().put("current", "Records Updated");

						} else {

							rowUpdated = DELEGATEFORGROUPCVR
									.update(gridValueBean);
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
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_PROP_TTYCOV_GRP gridValueBean = null;
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_PROP_TTYCOV_GRP_HELPER groupHelper = new PM_IL_PROP_TTYCOV_GRP_HELPER();
		try {
			// Get the bean based on row index
			gridValueBean = (PM_IL_PROP_TTYCOV_GRP) dataTableList
					.get(currRowIndex);
			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				//[ Removed Hard coded user id and changed place of adding the values to bean: added by: Shankar bodduluri Dated: 19-Mar-2009 ]
				gridValueBean.setPTG_UPD_DT(commonUtils.getCurrentDate());
				gridValueBean.setPTG_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				rowUpdated = DELEGATEFORGROUPCVR.update(gridValueBean);
				getWarningMap().put("current", "Records Updated");
			} else {
				double sysIdTreatyType = tempCoverBean.getPTC_PTT_SYS_ID();
				double sysIdCover = tempCoverBean.getPTC_SYS_ID();
				double sysIdGroupCover = groupHelper.getSysIdForGroupCover();
				gridValueBean.setPTG_PTT_SYS_ID(sysIdTreatyType);
				gridValueBean.setPTG_PTC_SYS_ID(sysIdCover);
				gridValueBean.setPTG_SYS_ID(sysIdGroupCover);
				//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]
				gridValueBean.setPTG_CR_DT(commonUtils.getCurrentDate());
				gridValueBean.setPTG_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				rowUpdated = DELEGATEFORGROUPCVR.update(gridValueBean);
				getWarningMap().put("current", "Records Inserted");
			}
			lastUpdateRowIndex = currRowIndex;

		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}
		return;
	}

	/* when validate for all the components */

	public void fireFieldValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void sNoWhenValidate(FacesContext facesContext,
			UIComponent component, Object value) {
		if (value != null) {
			double sNo = Double.parseDouble((String) value);
			this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_SR_NO(sNo);
		}
	}

	public void groupCodeWhenValidate(FacesContext facesContext, UIComponent component,
			Object value) {
		if ((String)value != null) {
			String groupCode = (String) value;
			this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_PTC_CVR_GRP_CODE(groupCode);
		}
	}

	public void coverCodeWhenValidate(FacesContext facesContext,
			UIComponent component, Object value) {
		if ((String)value != null) {
			String coverCode = (String) value;
			this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_COVER_CODE(coverCode);
			String M_COVER_TYPE = null;
			String M_DUMMY = null;
			
			/*Modified by Janani on 12.01.2018 for ZBLIFE-1468859*/
			/*String sql_C1 = " SELECT 'X' FROM   PM_IL_COVER WHERE  COVER_TYPE IN ('A') " +
							" AND    COVER_CODE = ?";*/
			
			String sql_C1 = " SELECT 'X' FROM   PM_IL_COVER WHERE  COVER_TYPE IN ('A','B') " +
					" AND    COVER_CODE = ?";
			
			/*End of ZBLIFE-1468859*/
			
			ResultSet rst_C1 = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				Connection connection = CommonUtils.getConnection();
				rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{coverCode});
				while(rst_C1.next()){
					M_DUMMY = rst_C1.getString(1);
				}
				if(!(M_DUMMY==null?"Y":M_DUMMY).equals("X")){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1010"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	}
	
	/**
	 * LOV for cover description
	 * 
	 * @param event
	 */
	public void getUI_M_PTG_COVER_CODE_DESC(ActionEvent event) {
		COMP_UI_M_PTG_COVER_CODE_DESC.setSubmittedValue(null);
		if (COMP_PTG_COVER_CODE.getSubmittedValue() != null) {
			String coverCode = (String) COMP_PTG_COVER_CODE.getSubmittedValue();
			String coverDesc = DELEGATEFORGROUPCVR.getCoverCodeDesc(coverCode,
					ttyCovGroupList);
			PM_IL_PROP_TTYCOV_GRP_BEAN.setUI_M_PTG_COVER_CODE_DESC(coverDesc);
			COMP_UI_M_PTG_COVER_CODE_DESC.setSubmittedValue(coverDesc);
		}
	}
	
	
	
	public void saveData() {
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY , "Records Saved");
			getWarningMap().put("CURRENT", "Records Saved");
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PTG_PTC_CVR_GRP_CODE_LABEL() {
		return COMP_PTG_PTC_CVR_GRP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PTG_PTC_CVR_GRP_CODE() {
		return COMP_PTG_PTC_CVR_GRP_CODE;
	}

	public void setCOMP_PTG_PTC_CVR_GRP_CODE_LABEL(
			HtmlOutputLabel COMP_PTG_PTC_CVR_GRP_CODE_LABEL) {
		this.COMP_PTG_PTC_CVR_GRP_CODE_LABEL = COMP_PTG_PTC_CVR_GRP_CODE_LABEL;
	}

	public void setCOMP_PTG_PTC_CVR_GRP_CODE(
			HtmlInputText COMP_PTG_PTC_CVR_GRP_CODE) {
		this.COMP_PTG_PTC_CVR_GRP_CODE = COMP_PTG_PTC_CVR_GRP_CODE;
	}

	public HtmlOutputLabel getCOMP_PTG_COVER_CODE_LABEL() {
		return COMP_PTG_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PTG_COVER_CODE() {
		return COMP_PTG_COVER_CODE;
	}

	public void setCOMP_PTG_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_PTG_COVER_CODE_LABEL) {
		this.COMP_PTG_COVER_CODE_LABEL = COMP_PTG_COVER_CODE_LABEL;
	}

	public void setCOMP_PTG_COVER_CODE(HtmlInputText COMP_PTG_COVER_CODE) {
		this.COMP_PTG_COVER_CODE = COMP_PTG_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PTG_COVER_CODE_DESC_LABEL() {
		return COMP_UI_M_PTG_COVER_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PTG_COVER_CODE_DESC() {
		return COMP_UI_M_PTG_COVER_CODE_DESC;
	}

	public void setCOMP_UI_M_PTG_COVER_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PTG_COVER_CODE_DESC_LABEL) {
		this.COMP_UI_M_PTG_COVER_CODE_DESC_LABEL = COMP_UI_M_PTG_COVER_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PTG_COVER_CODE_DESC(
			HtmlInputText COMP_UI_M_PTG_COVER_CODE_DESC) {
		this.COMP_UI_M_PTG_COVER_CODE_DESC = COMP_UI_M_PTG_COVER_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PTG_SR_NO_LABEL() {
		return COMP_PTG_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_PTG_SR_NO() {
		return COMP_PTG_SR_NO;
	}

	public void setCOMP_PTG_SR_NO_LABEL(HtmlOutputLabel COMP_PTG_SR_NO_LABEL) {
		this.COMP_PTG_SR_NO_LABEL = COMP_PTG_SR_NO_LABEL;
	}

	public void setCOMP_PTG_SR_NO(HtmlInputText COMP_PTG_SR_NO) {
		this.COMP_PTG_SR_NO = COMP_PTG_SR_NO;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON534() {
		return COMP_PUSH_BUTTON534;
	}

	public void setCOMP_PUSH_BUTTON534(HtmlCommandButton COMP_PUSH_BUTTON534) {
		this.COMP_PUSH_BUTTON534 = COMP_PUSH_BUTTON534;
	}

	public PM_IL_PROP_TTYCOV_GRP getPM_IL_PROP_TTYCOV_GRP_BEAN() {
		return PM_IL_PROP_TTYCOV_GRP_BEAN;
	}

	public void setPM_IL_PROP_TTYCOV_GRP_BEAN(
			PM_IL_PROP_TTYCOV_GRP PM_IL_PROP_TTYCOV_GRP_BEAN) {
		this.PM_IL_PROP_TTYCOV_GRP_BEAN = PM_IL_PROP_TTYCOV_GRP_BEAN;
	}

	public HtmlCommandButton getCOMP_BUTTON_GRP_CVR() {
		return COMP_BUTTON_GRP_CVR;
	}

	public void setCOMP_BUTTON_GRP_CVR(HtmlCommandButton comp_button_grp_cvr) {
		COMP_BUTTON_GRP_CVR = comp_button_grp_cvr;
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

	public int getLastUpdateRowIndex() {
		return lastUpdateRowIndex;
	}

	public void setLastUpdateRowIndex(int lastUpdateRowIndex) {
		this.lastUpdateRowIndex = lastUpdateRowIndex;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PM_IL_PROP_TTYCOV_GRP> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(ArrayList<PM_IL_PROP_TTYCOV_GRP> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public PM_IL_PROP_TREATY_COVER getTempCoverBean() {
		return tempCoverBean;
	}

	public void setTempCoverBean(PM_IL_PROP_TREATY_COVER tempCoverBean) {
		this.tempCoverBean = tempCoverBean;
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
	
	public List<PM_IL_PROP_TTYCOV_GRP> coverCodeLov(Object value){
		
		/*Added by Janani on 10.01.2018 for ZBLIFE-1468859*/
		
		ttyCovGroupList = new ArrayList<PM_IL_PROP_TTYCOV_GRP>();
		
		/*End of ZBLIFE-1468859*/
		
		String coverCode = (String) value;
		if(coverCode!=null){
			if(coverCode.equals("*")) {
				coverCode = "%";
			} else {
				coverCode += "%";
			}
		}
		
		
		/*Modified by Janani on 12.01.2018 for ZBLIFE-1468859*/
		/*String query = "SELECT COVER_CODE, COVER_DESC FROM PM_IL_COVER " +
				"WHERE COVER_FRZ_FLAG = 'N'  " +
				"AND COVER_TYPE IN ('A','S') " +
				"AND COVER_CODE LIKE NVL(?, COVER_CODE) ";*/
		
		String query = "SELECT COVER_CODE, COVER_DESC FROM PM_IL_COVER " +
				"WHERE COVER_FRZ_FLAG = 'N'  " +
				"AND COVER_TYPE IN ('A','S','B') " +
				"AND COVER_CODE LIKE NVL(?, COVER_CODE) ";
		
		/*End of ZBLIFE-1468859*/
		Connection connection = null;
		ResultSet rst = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(query, connection, new Object[]{coverCode});
			while(rst.next()){
				PM_IL_PROP_TTYCOV_GRP ttyCovGroup = new PM_IL_PROP_TTYCOV_GRP();
				ttyCovGroup.setPTG_COVER_CODE(rst.getString(1));
				ttyCovGroup.setUI_M_PTG_COVER_CODE_DESC(rst.getString(2));
				ttyCovGroupList.add(ttyCovGroup);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return ttyCovGroupList;
	}
	
	public void post(ActionEvent ae) {
		try{
			PM_IL_PROP_TREATY_COVER tempCoverBean = compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN();
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
			.getExternalContext().getSessionMap();
			String userId = (String) sessionMap.get("GLOBAL.M_USER_ID");
			if(PM_IL_PROP_TTYCOV_GRP_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_UPD_DT(commonUtils.getCurrentDate());
					this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
					DELEGATEFORGROUPCVR.update(this.PM_IL_PROP_TTYCOV_GRP_BEAN);
					new CRUDHandler().executeInsert(PM_IL_PROP_TTYCOV_GRP_BEAN, commonUtils.getConnection());
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
					double sysIdTreatyType = tempCoverBean.getPTC_PTT_SYS_ID();
					double sysIdCover = tempCoverBean.getPTC_SYS_ID();
					double sysIdGroupCover = groupHelper.getSysIdForGroupCover();
					this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_PTT_SYS_ID(sysIdTreatyType);
					this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_PTC_SYS_ID(sysIdCover);
					this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_SYS_ID(sysIdGroupCover);
					this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_CR_DT(commonUtils.getCurrentDate());
					this.PM_IL_PROP_TTYCOV_GRP_BEAN.setPTG_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
					DELEGATEFORGROUPCVR.update(this.PM_IL_PROP_TTYCOV_GRP_BEAN);
					new CRUDHandler().executeInsert(PM_IL_PROP_TTYCOV_GRP_BEAN, commonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					dataTableList.add(PM_IL_PROP_TTYCOV_GRP_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_PROP_TTYCOV_GRP_BEAN.setRowSelected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	
	public void getDetails() {
		try {
			if (dataTableList.size() != 0) {				
				PM_IL_PROP_TTYCOV_GRP_BEAN = (PM_IL_PROP_TTYCOV_GRP) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_PROP_TTYCOV_GRP_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PTG_SR_NO.resetValue();
		COMP_PTG_COVER_CODE.resetValue();
		COMP_UI_M_PTG_COVER_CODE_DESC.resetValue();
		COMP_PTG_PTC_CVR_GRP_CODE.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_PROP_TTYCOV_GRP> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public String getFilterByPTG_PTC_CVR_GRP_CODE() {
		return filterByPTG_PTC_CVR_GRP_CODE;
	}

	public void setFilterByPTG_PTC_CVR_GRP_CODE(String filterByPTG_PTC_CVR_GRP_CODE) {
		this.filterByPTG_PTC_CVR_GRP_CODE = filterByPTG_PTC_CVR_GRP_CODE;
	}

	public String getFilterByPTG_COVER_CODE() {
		return filterByPTG_COVER_CODE;
	}

	public void setFilterByPTG_COVER_CODE(String filterByPTG_COVER_CODE) {
		this.filterByPTG_COVER_CODE = filterByPTG_COVER_CODE;
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

	public String getFilterByPTG_SR_NO() {
		return filterByPTG_SR_NO;
	}

	public void setFilterByPTG_SR_NO(String filterByPTG_SR_NO) {
		this.filterByPTG_SR_NO = filterByPTG_SR_NO;
	}
}
