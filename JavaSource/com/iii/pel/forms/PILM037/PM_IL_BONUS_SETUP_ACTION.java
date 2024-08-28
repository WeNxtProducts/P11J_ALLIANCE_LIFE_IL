package com.iii.pel.forms.PILM037;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM036.SWISS_SQL_PILM036;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_BONUS_SETUP_ACTION extends CommonAction{
	
	private boolean disable = true;
	
	int currentPage = 1;
	
	int recordsPerPage = 5;
	
	private int lastUpdatedRowIndex;
	
	private int prevRowIndex;
	
	private UIData dataTable;
	
	private String planCode = null;
	
	private String bCode = null;

	private HtmlOutputLabel COMP_BSET_PLAN_CODE_LABEL;

	private HtmlInputText COMP_BSET_PLAN_CODE;

	private HtmlInputText COMP_UI_M_PLAN_CODE_DESC;

	private HtmlOutputLabel COMP_BSET_BONUS_CODE_LABEL;

	private HtmlInputText COMP_BSET_BONUS_CODE;

	private HtmlOutputLabel COMP_UI_M_BSET_BONUS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BSET_BONUS_CODE_DESC;

	private HtmlOutputLabel COMP_BSET_YEAR_LABEL;

	private HtmlInputText COMP_BSET_YEAR;

	private HtmlOutputLabel COMP_BSET_RATE_LABEL;

	private HtmlInputText COMP_BSET_RATE;

	private HtmlOutputLabel COMP_BSET_RATE_PER_LABEL;

	private HtmlInputText COMP_BSET_RATE_PER;

	private HtmlCommandButton COMP_UI_M_BUT_PLAN_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_BSET_BONUS_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_COPY;
	
	private HtmlGraphicImage COMP_BSET_PLAN_CODE_LOV_IMG;
	
	private HtmlOutputLabel COMP_BSET_BUY_SELL_LABEL;
	
	private HtmlSelectOneMenu COMP_BSET_BUY_SELL;
	
	private HtmlOutputLabel COMP_BSET_BONUS_GIVEN_IN_LABEL;
	
	private HtmlSelectOneMenu COMP_BSET_BONUS_GIVEN_IN;
	
	private HtmlOutputLabel COMP_BSET_APPLIED_ON_LABEL;
	
	private HtmlSelectOneMenu COMP_BSET_APPLIED_ON;

	private HtmlOutputLabel COMP_BSET_UNIT_PUR_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_BSET_UNIT_PUR_YN;
	
	private List<SelectItem> listBSET_BONUS_GIVEN_IN = new ArrayList<SelectItem>();
	
	private List<SelectItem> listBSET_BUY_SELL = new ArrayList<SelectItem>();
	
	private List<SelectItem> listBSET_APPLIED_ON = new ArrayList<SelectItem>();
	
	private List<SelectItem> listBSET_UNIT_PUR_YN = new ArrayList<SelectItem>();
	
	private PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN;
	
	private PM_IL_PLAN PM_IL_PLAN_BEAN;
	
	private int lastUpdateRowIndex;
	
	private ArrayList<PM_IL_BONUS_SETUP> planCodeList = new ArrayList<PM_IL_BONUS_SETUP>(); 
	
	private ArrayList<PM_IL_BONUS_SETUP> tableList = new ArrayList<PM_IL_BONUS_SETUP>();
	
	private ArrayList<PM_IL_BONUS_SETUP> bcodeList = new ArrayList<PM_IL_BONUS_SETUP>();
	
	//private ArrayList<SelectItem> bonusList = new ArrayList<SelectItem>();
	
	//private ArrayList<SelectItem> appliedOnList = new ArrayList<SelectItem>();
	
	//private ArrayList<SelectItem> unitPerList = new ArrayList<SelectItem>();
	
	PILM037_Helper helper;
	
	 
	
	private boolean backCheck;
	
	private boolean mainCheck;
	
	//filters
	private String filterByBSET_BONUS_CODE;
	private String filterByUI_M_BSET_BONUS_CODE_DESC;
	private String filterBSET_YEAR;
	private String filterBSET_RATE;
	private String filterBSET_RATE_PER;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	public PILM037_COMPOSITE_ACTION compositeAction;
	
	public PILM037_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM037_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DEL
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	/**
	 * @param ui_m_but_del the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	/**
	 * @return the filterByBSET_BONUS_CODE
	 */
	public String getFilterByBSET_BONUS_CODE() {
		return filterByBSET_BONUS_CODE;
	}

	/**
	 * @param filterByBSET_BONUS_CODE the filterByBSET_BONUS_CODE to set
	 */
	public void setFilterByBSET_BONUS_CODE(String filterByBSET_BONUS_CODE) {
		this.filterByBSET_BONUS_CODE = filterByBSET_BONUS_CODE;
	}

	/**
	 * @return the filterByUI_M_BSET_BONUS_CODE_DESC
	 */
	public String getFilterByUI_M_BSET_BONUS_CODE_DESC() {
		return filterByUI_M_BSET_BONUS_CODE_DESC;
	}

	/**
	 * @param filterByUI_M_BSET_BONUS_CODE_DESC the filterByUI_M_BSET_BONUS_CODE_DESC to set
	 */
	public void setFilterByUI_M_BSET_BONUS_CODE_DESC(
			String filterByUI_M_BSET_BONUS_CODE_DESC) {
		this.filterByUI_M_BSET_BONUS_CODE_DESC = filterByUI_M_BSET_BONUS_CODE_DESC;
	}
 
	public PM_IL_BONUS_SETUP_ACTION() {
		PM_IL_BONUS_SETUP_BEAN = new PM_IL_BONUS_SETUP();
		PM_IL_PLAN_BEAN = new PM_IL_PLAN();
		prepareDropDownList();
		//PM_IL_BONUS_SETUP_DETAILS_BEAN = new PM_IL_BONUS_SETUP_DETAILS();
		DelegateDb dbHelper = new DelegateDb();
		helper = new PILM037_Helper();
		
		
	}

	public void prepareDropDownList() {
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			listBSET_BONUS_GIVEN_IN = ListItemUtil.getDropDownListValue(connection, "PILM037", 
					"PM_IL_BONUS_SETUP", "PM_IL_BONUS_SETUP.BSET_BONUS_GIVEN_IN", "IL_BON_GIVN");
			
			listBSET_BUY_SELL = ListItemUtil.getDropDownListValue(connection, "PILM037", 
					"PM_IL_BONUS_SETUP", "PM_IL_BONUS_SETUP.BSET_BUY_SELL", "UNIT_SEL_BUY");
			
			listBSET_APPLIED_ON = ListItemUtil.getDropDownListValue(connection, "PILM037", 
					"PM_IL_BONUS_SETUP", "PM_IL_BONUS_SETUP.BSET_APPLIED_ON", "IL_BON_APP");
			
			listBSET_UNIT_PUR_YN = ListItemUtil.getDropDownListValue(connection, "PILM037", 
					"PM_IL_BONUS_SETUP", "PM_IL_BONUS_SETUP.BSET_UNIT_PUR_YN", "YESNO");
					}
		 catch (DBException e) {
			 e.printStackTrace();
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			 getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}
	
	public List<SelectItem> getListBSET_BONUS_GIVEN_IN() {
		if (listBSET_BONUS_GIVEN_IN.size() == 0) {
			listBSET_BONUS_GIVEN_IN.clear();
			try {
				listBSET_BONUS_GIVEN_IN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBSET_BONUS_GIVEN_IN;
	}

	public List<SelectItem> getListBSET_APPLIED_ON() {
		if (listBSET_APPLIED_ON.size() == 0) {
			listBSET_APPLIED_ON.clear();
			try {
				listBSET_APPLIED_ON = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBSET_APPLIED_ON;
	}
	
	public List<SelectItem> getListBSET_UNIT_PUR_YN() {
		if (listBSET_UNIT_PUR_YN.size() == 0) {
			listBSET_UNIT_PUR_YN.clear();
			try {
				listBSET_UNIT_PUR_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBSET_UNIT_PUR_YN;
	}
	
	public List<SelectItem> getListBSET_BUY_SELL() {
		if (listBSET_BUY_SELL.size() == 0) {
			listBSET_BUY_SELL.clear();
			try {
				listBSET_BUY_SELL = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listBSET_BUY_SELL;
	}
	
	public ArrayList<PM_IL_BONUS_SETUP> getBeanList() {
		return planCodeList;
	}
	
	public void setBeanList(ArrayList<PM_IL_BONUS_SETUP> beanList) {
		this.planCodeList = beanList;
	}
	
	public HtmlOutputLabel getCOMP_BSET_PLAN_CODE_LABEL() {
		return COMP_BSET_PLAN_CODE_LABEL;
	}

	public void setCOMP_BSET_PLAN_CODE_LABEL(
			HtmlOutputLabel comp_bset_plan_code_label) {
		COMP_BSET_PLAN_CODE_LABEL = comp_bset_plan_code_label;
	}

	public HtmlInputText getCOMP_BSET_PLAN_CODE() {
		return COMP_BSET_PLAN_CODE;
	}

	public void setCOMP_BSET_PLAN_CODE(HtmlInputText comp_bset_plan_code) {
		COMP_BSET_PLAN_CODE = comp_bset_plan_code;
	}

	public HtmlInputText getCOMP_UI_M_PLAN_CODE_DESC() {
		return COMP_UI_M_PLAN_CODE_DESC;
	}

	public void setCOMP_UI_M_PLAN_CODE_DESC(HtmlInputText COMP_UI_M_PLAN_CODE_DESC) {
		this.COMP_UI_M_PLAN_CODE_DESC = COMP_UI_M_PLAN_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_BSET_BONUS_CODE_LABEL() {
		return COMP_BSET_BONUS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BSET_BONUS_CODE() {
		return COMP_BSET_BONUS_CODE;
	}

	public void setCOMP_BSET_BONUS_CODE_LABEL(HtmlOutputLabel COMP_BSET_BONUS_CODE_LABEL) {
		this.COMP_BSET_BONUS_CODE_LABEL = COMP_BSET_BONUS_CODE_LABEL;
	}

	public void setCOMP_BSET_BONUS_CODE(HtmlInputText COMP_BSET_BONUS_CODE) {
		this.COMP_BSET_BONUS_CODE = COMP_BSET_BONUS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BSET_BONUS_CODE_DESC_LABEL() {
		return COMP_UI_M_BSET_BONUS_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BSET_BONUS_CODE_DESC() {
		return COMP_UI_M_BSET_BONUS_CODE_DESC;
	}

	public void setCOMP_UI_M_BSET_BONUS_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BSET_BONUS_CODE_DESC_LABEL) {
		this.COMP_UI_M_BSET_BONUS_CODE_DESC_LABEL = COMP_UI_M_BSET_BONUS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_BSET_BONUS_CODE_DESC(HtmlInputText COMP_UI_M_BSET_BONUS_CODE_DESC) {
		this.COMP_UI_M_BSET_BONUS_CODE_DESC = COMP_UI_M_BSET_BONUS_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_BSET_YEAR_LABEL() {
		return COMP_BSET_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_BSET_YEAR() {
		return COMP_BSET_YEAR;
	}

	public void setCOMP_BSET_YEAR_LABEL(HtmlOutputLabel COMP_BSET_YEAR_LABEL) {
		this.COMP_BSET_YEAR_LABEL = COMP_BSET_YEAR_LABEL;
	}

	public void setCOMP_BSET_YEAR(HtmlInputText COMP_BSET_YEAR) {
		this.COMP_BSET_YEAR = COMP_BSET_YEAR;
	}

	public HtmlOutputLabel getCOMP_BSET_RATE_LABEL() {
		return COMP_BSET_RATE_LABEL;
	}

	public HtmlInputText getCOMP_BSET_RATE() {
		return COMP_BSET_RATE;
	}

	public void setCOMP_BSET_RATE_LABEL(HtmlOutputLabel COMP_BSET_RATE_LABEL) {
		this.COMP_BSET_RATE_LABEL = COMP_BSET_RATE_LABEL;
	}

	public void setCOMP_BSET_RATE(HtmlInputText COMP_BSET_RATE) {
		this.COMP_BSET_RATE = COMP_BSET_RATE;
	}

	public HtmlOutputLabel getCOMP_BSET_RATE_PER_LABEL() {
		return COMP_BSET_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_BSET_RATE_PER() {
		return COMP_BSET_RATE_PER;
	}

	public void setCOMP_BSET_RATE_PER_LABEL(HtmlOutputLabel COMP_BSET_RATE_PER_LABEL) {
		this.COMP_BSET_RATE_PER_LABEL = COMP_BSET_RATE_PER_LABEL;
	}

	public void setCOMP_BSET_RATE_PER(HtmlInputText COMP_BSET_RATE_PER) {
		this.COMP_BSET_RATE_PER = COMP_BSET_RATE_PER;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PLAN_CODE_LOV() {
		return COMP_UI_M_BUT_PLAN_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_PLAN_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_PLAN_CODE_LOV) {
		this.COMP_UI_M_BUT_PLAN_CODE_LOV = COMP_UI_M_BUT_PLAN_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BSET_BONUS_CODE_LOV() {
		return COMP_UI_M_BUT_BSET_BONUS_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_BSET_BONUS_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_BSET_BONUS_CODE_LOV) {
		this.COMP_UI_M_BUT_BSET_BONUS_CODE_LOV = COMP_UI_M_BUT_BSET_BONUS_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_COPY() {
		return COMP_UI_M_BUT_COPY;
	}

	public void setCOMP_UI_M_BUT_COPY(HtmlCommandButton COMP_UI_M_BUT_COPY) {
		this.COMP_UI_M_BUT_COPY = COMP_UI_M_BUT_COPY;
	}

	public PM_IL_BONUS_SETUP getPM_IL_BONUS_SETUP_BEAN() {
		return PM_IL_BONUS_SETUP_BEAN;
	}

	public void setPM_IL_BONUS_SETUP_BEAN(PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN) {
		this.PM_IL_BONUS_SETUP_BEAN = PM_IL_BONUS_SETUP_BEAN;
	}
	

	public ArrayList<PM_IL_BONUS_SETUP> getPlanCodeList() {
		return planCodeList;
	}

	public void setPlanCodeList(ArrayList<PM_IL_BONUS_SETUP> planCodeList) {
		this.planCodeList = planCodeList;
	}

	public ArrayList<PM_IL_BONUS_SETUP> getTableList() {
		return tableList;
	}

	public void setTableList(ArrayList<PM_IL_BONUS_SETUP> tableList) {
		this.tableList = tableList;
	}
	
	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}	
	
	
// Removed due to new requirement
	
	/*public HtmlOutputLabel getCOMP_BSET_BONUS_GIVEN_IN_LABEL() {
		return COMP_BSET_BONUS_GIVEN_IN_LABEL;
	}

	public HtmlComboBox getCOMP_BSET_BONUS_GIVEN_IN() {
		return COMP_BSET_BONUS_GIVEN_IN;
	}

	public void setCOMP_BSET_BONUS_GIVEN_IN_LABEL(HtmlOutputLabel COMP_BSET_BONUS_GIVEN_IN_LABEL) {
		this.COMP_BSET_BONUS_GIVEN_IN_LABEL = COMP_BSET_BONUS_GIVEN_IN_LABEL;
	}

	public void setCOMP_BSET_BONUS_GIVEN_IN(HtmlComboBox COMP_BSET_BONUS_GIVEN_IN) {
		this.COMP_BSET_BONUS_GIVEN_IN = COMP_BSET_BONUS_GIVEN_IN;
	}

	public HtmlOutputLabel getCOMP_BSET_APPLIED_ON_LABEL() {
		return COMP_BSET_APPLIED_ON_LABEL;
	}

	public HtmlComboBox getCOMP_BSET_APPLIED_ON() {
		return COMP_BSET_APPLIED_ON;
	}

	public void setCOMP_BSET_APPLIED_ON_LABEL(HtmlOutputLabel COMP_BSET_APPLIED_ON_LABEL) {
		this.COMP_BSET_APPLIED_ON_LABEL = COMP_BSET_APPLIED_ON_LABEL;
	}

	public void setCOMP_BSET_APPLIED_ON(HtmlComboBox COMP_BSET_APPLIED_ON) {
		this.COMP_BSET_APPLIED_ON = COMP_BSET_APPLIED_ON;
	}

	public HtmlOutputLabel getCOMP_BSET_UNIT_PUR_YN_LABEL() {
		return COMP_BSET_UNIT_PUR_YN_LABEL;
	}

	public HtmlComboBox getCOMP_BSET_UNIT_PUR_YN() {
		return COMP_BSET_UNIT_PUR_YN;
	}

	public void setCOMP_BSET_UNIT_PUR_YN_LABEL(HtmlOutputLabel COMP_BSET_UNIT_PUR_YN_LABEL) {
		this.COMP_BSET_UNIT_PUR_YN_LABEL = COMP_BSET_UNIT_PUR_YN_LABEL;
	}

	public void setCOMP_BSET_UNIT_PUR_YN(HtmlComboBox COMP_BSET_UNIT_PUR_YN) {
		this.COMP_BSET_UNIT_PUR_YN = COMP_BSET_UNIT_PUR_YN;
	}*/

	
	
	
	// Removed due to new requirement
	
	/*public ArrayList<SelectItem> getBonusList() {
		return bonusList;
	}

	public void setBonusList(ArrayList<SelectItem> bonusList) {
		this.bonusList = bonusList;
	}

	public ArrayList<SelectItem> getAppliedOnList() {
		return appliedOnList;
	}

	public void setAppliedOnList(ArrayList<SelectItem> appliedOnList) {
		this.appliedOnList = appliedOnList;
	}

	public ArrayList<SelectItem> getUnitPerList() {
		return unitPerList;
	}

	public void setUnitPerList(ArrayList<SelectItem> unitPerList) {
		this.unitPerList = unitPerList;
	}*/
	
	
	
	
	
	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public ArrayList<PM_IL_BONUS_SETUP> getBcodeList() {
		return bcodeList;
	}

	public void setBcodeList(ArrayList<PM_IL_BONUS_SETUP> bcodeList) {
		this.bcodeList = bcodeList;
	}
	
	public String getBCode() {
		return bCode;
	}

	public void setBCode(String code) {
		bCode = code;
	}
	
	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	
	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}	

	
	public ArrayList<PM_IL_BONUS_SETUP> popBonusCodeLov(Object obj){
		
		String bonusCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		bcodeList  = dbHelper.populateBonusCodeLov(bonusCode);
		return bcodeList;
	}

	/**
	 * Grid Tab Listener
	 */
	/*public void gridtabListener(){
		
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		DelegateDb dbHelper = new DelegateDb(); 
		System.out.println(lastUpdatedRowIndex+"   "+currRowIndex+"  "+prevRowIndex);
		try {
			if(lastUpdatedRowIndex!=-1)
			{
				if(lastUpdatedRowIndex!=prevRowIndex)
				{
					if(currRowIndex != prevRowIndex){
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						PM_IL_BONUS_SETUP_BEAN = tableList.get(prevRowIndex);
						
						planCode =(String) getCOMP_BSET_PLAN_CODE().getSubmittedValue();
						
						
							// Update the record to database
							if(PM_IL_BONUS_SETUP_BEAN.getROWID() != null){
								rowUpdated = dbHelper.updateData(PM_IL_BONUS_SETUP_BEAN);
								getErrorMap().put("somekey", rowUpdated+" record updated.");
								getErrorMap().put("current", rowUpdated+" record updated.");
							}else
							{
								//PM_IL_BONUS_SETUP_BEAN
								rowUpdated = dbHelper.updateData(PM_IL_BONUS_SETUP_BEAN);
								getErrorMap().put("somekey", rowUpdated+" record inserted.");
								getErrorMap().put("current", rowUpdated+" record inserted.");
								
							}
						
						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
		}
		
	}*/

	/**
	 * Last Column Listener
	 */
	public void lastColumnListener(){
		System.out.println("LAST COLUMN LISTENER...............");
		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		DelegateDb dbHelper = new DelegateDb();
			
		try {
			
				// Get the bean based on row index
			PM_IL_BONUS_SETUP_BEAN = tableList.get(currRowIndex);
			
			System.out.println("row id>>>>"+PM_IL_BONUS_SETUP_BEAN.getROWID());
			System.out.println("PLAN CODE>>>>"+PM_IL_BONUS_SETUP_BEAN.getBSET_PLAN_CODE());
			System.out.println("Bonus CODE>>>>"+PM_IL_BONUS_SETUP_BEAN.getBSET_BONUS_CODE());
			System.out.println("YEAR>>>>>>"+PM_IL_BONUS_SETUP_BEAN.getBSET_YEAR());
			System.out.println("RATE>>>>>>>"+PM_IL_BONUS_SETUP_BEAN.getBSET_RATE());
			System.out.println("RATE PER>>>>>"+PM_IL_BONUS_SETUP_BEAN.getBSET_RATE_PER());
			
					// Update the record to database
					if(PM_IL_BONUS_SETUP_BEAN.getROWID()!=null)
					{
						helper.pilm037_pm_il_bonus_setup_pre_update(PM_IL_BONUS_SETUP_BEAN, this);
						rowUpdated = dbHelper.updateData(PM_IL_BONUS_SETUP_BEAN);
						getErrorMap().put("somekey", rowUpdated+" record updated.");
						getErrorMap().put("current", rowUpdated+" record updated.");
					}else
					{
						helper.pilm037_pm_il_bonus_setup_pre_insert(PM_IL_BONUS_SETUP_BEAN, this);
						rowUpdated = dbHelper.updateData(PM_IL_BONUS_SETUP_BEAN);
						getErrorMap().put("somekey", rowUpdated+" record inserted.");
						getErrorMap().put("current", rowUpdated+" record inserted.");
						
					}
				
				lastUpdatedRowIndex = currRowIndex;
				
			
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened wrong while updating data
			e1.printStackTrace();
		}
		
	}


	/**
	 * Validator method for BSET BONUS CODE
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateBSET_BOMUS_CODE(FacesContext context, UIComponent component,Object value)
		throws ValidatorException{
		CommonUtils.clearMaps(this);

		try {
		PILM037_Helper validationHelper = new PILM037_Helper();
		PM_IL_BONUS_SETUP_BEAN.setBSET_BONUS_CODE((String) value);
			validationHelper.pilm037_pm_il_bonus_setup_bset_bonus_code_when_validate_item(this);
			COMP_UI_M_BSET_BONUS_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
			
		}

	}	
	
	
	public void refreshTableOnSelect(ActionEvent event){
		System.out.println("PM_IL_BONUS_SETUP_ACTION.refreshTableOnSelect()---------TABLE REFRESH CALLED ----------");
		
			bCode = getCOMP_BSET_BONUS_CODE().getSubmittedValue().toString();
			//DelegateDb dbHelper = new DelegateDb();
			String bCodeDesc = null;

			// Persisting bonus code
			//int rowindex = dataTable.getRowIndex();
			//PM_IL_BONUS_SETUP setupBean = tableList.get(rowindex);
			PM_IL_BONUS_SETUP pm_il_bonus_setup = null;
			if(bcodeList != null){
				Iterator iterator = bcodeList.iterator();
				while(iterator.hasNext()){
					pm_il_bonus_setup = (PM_IL_BONUS_SETUP) iterator.next();
					if(pm_il_bonus_setup!=null && 
							pm_il_bonus_setup.getBSET_BONUS_CODE().equalsIgnoreCase(bCode)){
						bCodeDesc = pm_il_bonus_setup.getUI_M_BSET_BONUS_CODE_DESC();
					}
					
				}
				System.out
				.println("PM_IL_BONUS_SETUP_ACTION.refreshTableOnSelect()+++++++++BONUS DESC+++++++:"+bCodeDesc);

				getCOMP_UI_M_BSET_BONUS_CODE_DESC().setSubmittedValue(bCodeDesc);
				this.PM_IL_BONUS_SETUP_BEAN.setUI_M_BSET_BONUS_CODE_DESC(bCodeDesc);
			}
			
			
			/*PM_IL_BONUS_SETUP setupBean = new PM_IL_BONUS_SETUP();
			for(PM_IL_BONUS_SETUP pm_il_bonus_setup : tableList){
				
			}
			
			setupBean.setBSET_BONUS_CODE(bCode);*/
			
			
	}
	
	public void bonusCode_WhenSelected(ActionEvent event) {
		String value = getCurrentValue(event);
		for (PM_IL_BONUS_SETUP pm_il_bonus_setup : getBcodeList()) {
			if (pm_il_bonus_setup.getBSET_BONUS_CODE().equalsIgnoreCase(value)) {
				getPM_IL_BONUS_SETUP_BEAN().setUI_M_BSET_BONUS_CODE_DESC(
						pm_il_bonus_setup.getUI_M_BSET_BONUS_CODE_DESC());
			}
		}
		System.out
				.println("PM_IL_BONUS_SETUP_ACTION.bonusCode_WhenSelected()<<<<SAVED>>>>>");
	}
	
	/**
	 * Bonus Description
	 * @param event
	 */
	public void bonusCodeDesc(ActionEvent event){
		String value = getCurrentValue(event);
		
		int rowIndex = getDataTable().getRowIndex();
		
		if(value!= null && !value.trim().isEmpty()){
			tableList.get(rowIndex).setUI_M_BSET_BONUS_CODE_DESC(value);
//			gridtabListener();
		}
		System.out.println("PM_IL_BONUS_SETUP_ACTION.bonusCodeDesc()<<<<SAVED>>>>>");
		
	}
	
	
	/*
	 * BSET_RATE validation
	 */

	public void Validate_Bset_Rate (FacesContext context, UIComponent component,Object value){
		System.out.println("inside Validate_Bset_Rate ....!!!!");
		CommonUtils.clearMaps(this);
		try {
			//int rowIndex = getDataTable().getRowIndex();
			//tableList.get(rowIndex).setBSET_RATE((Double) value);
			PM_IL_BONUS_SETUP_BEAN.setBSET_RATE((Double)value);
			helper.pilm037_pm_il_bonus_setup_bset_rate_when_validate_item(this);
//			gridtabListener();
		} 
		catch(Exception ve)
		{
			throw new ValidatorException(new FacesMessage(ve.getMessage()));
		}
	}
	
	public void BSET_RATE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput)e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	/*
	 * BSET_RATE_PER validation
	 */
	public void Validate_Bset_Rate_Per(FacesContext context, UIComponent component,Object value)
	{
		System.out.println("inside Validate_Bset_Rate_Per ....!!!!");
		//int rowIndex = getDataTable().getRowIndex();
		try {
			PM_IL_BONUS_SETUP_BEAN.setBSET_RATE_PER((Double)value);
			helper.pilm037_pm_il_bonus_setup_bset_rate_per_when_validate_item(this);
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "60030").getDetail());
			throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "60030"));
		}
		
//		lastColumnListener(); Commented During Grid Standardisation Implementation
	}
	
	// [ Added for grid implementation change, Added by: Rajesh Kundala, Dated: 18-Feb-2009
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
	// Added for grid implementation change, Added by: Rajesh Kundala, Dated: 18-Feb-2009 ]
	
	
	public void BSET_RATE_PER_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput)e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/*
	 * BSET_YEAR validation
	 */
	public void Validate_Bset_Year (FacesContext context, UIComponent component,Object value)
	{
		System.out.println("inside Validate_Bset_Year ....!!!!");
		PM_IL_BONUS_SETUP_BEAN.setBSET_YEAR((Integer)value);
		helper.pilm037_pm_il_bonus_setup_bset_year_when_validate_item(this);
	}
	
	public void BSET_YEAR_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput)e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
//		gridtabListener();
	}
	
	
	/**
	 * Method to add new
	 * @return String
	 */
	public String addNewRow(){
		int rowCount = 0;
		
		if(tableList == null){
			tableList = new ArrayList<PM_IL_BONUS_SETUP>();
		}
		PM_IL_BONUS_SETUP tempBean = new PM_IL_BONUS_SETUP();
		tempBean.setBSET_PLAN_CODE(getPM_IL_BONUS_SETUP_BEAN().getBSET_PLAN_CODE());
		tableList.add(tempBean);
		
		// Settings to navigate to last page
		rowCount = tableList.size();
		System.out.println("PM_IL_BONUS_SETUP_ACTION.addNewRow()********ROW COUNT*******"+rowCount);
		currentPage = rowCount/recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currentPage++;
		}
		
		return "newAdded";
	}
	
	
	/**
	 * Returns the current value
	 * @param event
	 * @return
	 */
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;
		
		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			System.out.println("<<<<<<<<<<<<<<<<<INPUT>>>>>>>>>>>>>>>>"+input);
			if(input != null){
				value = (String)input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
}
 
 /**
  * Returns check box status
  * @param actionEvent
  * @return
  */	
 public String checkBoxStatus(ActionEvent actionEvent){
		String currentValue = getCurrentValue(actionEvent);
		
		int currRowIndex = dataTable.getRowIndex();
		System.out.println("++++++++++++++Comming to check box status: "+currentValue);
		tableList.get(currRowIndex).setSelected(true);
		return "";
	} 
	
 
 /**
  * Method to delete row(s)
  * @return string
  */
 public String deleteRows() {
		DelegateDb dbHelper = new DelegateDb();
		int deleteCount = 0;

		for (int i = tableList.size()-1; i>=0; i--) {
			PM_IL_BONUS_SETUP_BEAN = tableList.get(i);
			System.out.println(">>>>>>>>>>deleteRows"+PM_IL_BONUS_SETUP_BEAN.isSelected());
			if (PM_IL_BONUS_SETUP_BEAN != null && 
					"dataTableSelectedRow".equalsIgnoreCase(PM_IL_BONUS_SETUP_BEAN.getRowSelected())){
				deleteCount += dbHelper.deleteData(PM_IL_BONUS_SETUP_BEAN);
				tableList.remove(PM_IL_BONUS_SETUP_BEAN);
				System.out.println("PM_IL_BONUS_SETUP_ACTION.deleteRows()DELETING ROW");
			}	
		}	
		if(deleteCount>0)
			{
			getErrorMap().put("somekey", deleteCount+" records deleted.");
			getErrorMap().put("current", deleteCount+" records deleted.");
			}
			lastUpdatedRowIndex = -1;
		
		return "row(s)Deleted";
	}

 

	/**
	 * Saves Data
	 */
	/*public void saveData() {

		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put(
				"current",
				Messages.getString("messageProperties",
						"errorPanel$message$save"));
			getWarningMap().put(
				"save",
				Messages.getString("messageProperties",
						"errorPanel$message$save"));
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}*/
	
	public void saveData(){
		CommonUtils.clearMaps(this);
		try {
			if (getPM_IL_BONUS_SETUP_BEAN().getROWID() == null) {
				new CRUDHandler().executeInsert(getPM_IL_BONUS_SETUP_BEAN(),
						CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeUpdate(getPM_IL_BONUS_SETUP_BEAN(),
						CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
			String message = "";
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE",
					message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
 
	/**
	 * Action method to move back to caller Jsp
	 * @return
	 */
	
	 public String backToSearch() {
	 	return SearchConstants.BACK_TO_SEARCH_PAGE;
	 }

	public boolean isBackCheck() {
		return backCheck;
	}

	public void setBackCheck(boolean backCheck) {
		this.backCheck = backCheck;
	}

	public boolean isMainCheck() {
		return mainCheck;
	}

	public void setMainCheck(boolean mainCheck) {
		this.mainCheck = mainCheck;
	}

	/**
	 * 
	 */
	public void getDetails() {
		try {
			if (tableList!=null && tableList.size() != 0) {				
				PM_IL_BONUS_SETUP_BEAN = (PM_IL_BONUS_SETUP) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_BONUS_SETUP_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
		COMP_BSET_BONUS_CODE.resetValue();
		COMP_UI_M_BSET_BONUS_CODE_DESC.resetValue();
		COMP_BSET_YEAR.resetValue();
		COMP_BSET_RATE.resetValue();
		COMP_BSET_RATE_PER.resetValue();
		COMP_BSET_PLAN_CODE.resetValue();
		COMP_UI_M_PLAN_CODE_DESC.resetValue();
	}
	
	private void resetSelectedRow() {
		Iterator<PM_IL_BONUS_SETUP> iterator = tableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	
	/**
	 * Add Row.
	 * @param event
	 */
	public void AddRow(ActionEvent event){
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){	
				String planCode = getPM_IL_BONUS_SETUP_BEAN().getBSET_PLAN_CODE();
				String planCodeDesc = compositeAction.getCOPY_ACTION_BEAN().L_VAL_PLAN(planCode);
				

				PM_IL_BONUS_SETUP_BEAN = new PM_IL_BONUS_SETUP();
				PM_IL_BONUS_SETUP_BEAN.setBSET_PLAN_CODE(planCode);
				PM_IL_BONUS_SETUP_BEAN.setUI_M_PLAN_CODE_DESC(planCodeDesc);
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
	
	/**
	 * Deletes a Record from Grid/Table
	 * 
	 * @return
	 */
	public String deleteRow(ActionEvent ae) {

		try{
		
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PM_IL_BONUS_SETUP bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		
		if (tableList != null) {
			deletedRecordList = new ArrayList<Integer>();
			//for (int index = 0; index < tableList.size();) {
				//bean = tableList.get(index);
				//if ("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())) {
				//	tableList.remove(bean);
					deleteRows();
					/*deletedRecordIndex = pm_il_med_exam_delegate
							.deleteData(bean);*/
					deletedRecordList.add(deletedRecordIndex);

				//} else {
				//	index++;
				//}
			}
			for(int i=0;i<tableList.size();i++){
				PM_IL_BONUS_SETUP pm_il_bonus_setup = tableList.get(i);
				if(i==0){
					pm_il_bonus_setup.setRowSelected(true);
					setPM_IL_BONUS_SETUP_BEAN(pm_il_bonus_setup);
				}else{
					pm_il_bonus_setup.setRowSelected(false);
				}
			}
			if(tableList!=null && tableList.size()==0){
				PM_IL_BONUS_SETUP_BEAN = new PM_IL_BONUS_SETUP();
				setPM_IL_BONUS_SETUP_BEAN(PM_IL_BONUS_SETUP_BEAN);
			}
		
			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current",
						+deletedRecordList.size() + "Record Deleted ");

			}
			lastUpdateRowIndex = -1;

		//}
		resetAllComponent();
		}catch(Exception exception){
		}
		return "";
	}

	/**
	 * @return the lastUpdateRowIndex
	 */
	public int getLastUpdateRowIndex() {
		return lastUpdateRowIndex;
	}

	/**
	 * @param lastUpdateRowIndex the lastUpdateRowIndex to set
	 */
	public void setLastUpdateRowIndex(int lastUpdateRowIndex) {
		this.lastUpdateRowIndex = lastUpdateRowIndex;
	}


	public void post(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		try{
			ControlBean controlBean = CommonUtils.getControlBean();
			CommonUtils commonUtils = new CommonUtils();
			for(PM_IL_BONUS_SETUP pm_il_bonus_setup : tableList){
				if("dataTableSelectedRow".equalsIgnoreCase(pm_il_bonus_setup.getRowSelected())){
					PM_IL_BONUS_SETUP_BEAN.setBSET_PLAN_CODE(pm_il_bonus_setup.getBSET_PLAN_CODE());
					PM_IL_BONUS_SETUP_BEAN.setUI_M_PLAN_CODE_DESC(pm_il_bonus_setup.getUI_M_PLAN_CODE_DESC());
				}
			}
			
			if(PM_IL_BONUS_SETUP_BEAN.getBSET_PLAN_CODE()==null || "".equals(PM_IL_BONUS_SETUP_BEAN.getBSET_PLAN_CODE())){
				PILM037_COMPOSITE_ACTION compositeAction = (PILM037_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILM037_COMPOSITE_ACTION");
				PM_IL_BONUS_SETUP bonusSetupBean =compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getPM_IL_BONUS_SETUP_BEAN();
				String planCode = bonusSetupBean.getBSET_PLAN_CODE();
				String planCodeDesc = bonusSetupBean.getUI_M_PLAN_CODE_DESC();

				PM_IL_BONUS_SETUP_BEAN.setBSET_PLAN_CODE(planCode);
				PM_IL_BONUS_SETUP_BEAN.setUI_M_PLAN_CODE_DESC(planCodeDesc);
			}
			
			
			if(PM_IL_BONUS_SETUP_BEAN.getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					
					int year = PM_IL_BONUS_SETUP_BEAN.getBSET_YEAR()!=null ? PM_IL_BONUS_SETUP_BEAN.getBSET_YEAR() : 0;
					Double rate = PM_IL_BONUS_SETUP_BEAN.getBSET_RATE()!=null ? PM_IL_BONUS_SETUP_BEAN.getBSET_RATE() : 0.0;
					Double ratePer = PM_IL_BONUS_SETUP_BEAN.getBSET_RATE_PER() !=null ? PM_IL_BONUS_SETUP_BEAN.getBSET_RATE_PER() : 0.0;
					
					//String planCode = COMP_BSET_PLAN_CODE.getSubmittedValue().toString();
					
					//PM_IL_BONUS_SETUP_BEAN.setBSET_PLAN_CODE(planCode);
					PM_IL_BONUS_SETUP_BEAN.setBSET_YEAR(year);
					PM_IL_BONUS_SETUP_BEAN.setBSET_RATE(rate);
					PM_IL_BONUS_SETUP_BEAN.setBSET_RATE_PER(ratePer);
					PM_IL_BONUS_SETUP_BEAN.setBSET_BONUS_CODE(PM_IL_BONUS_SETUP_BEAN.getBSET_BONUS_CODE());
					PM_IL_BONUS_SETUP_BEAN.setBSET_UPD_DT(new CommonUtils().getCurrentDate());
					PM_IL_BONUS_SETUP_BEAN.setBSET_UPD_UID(controlBean.getM_USER_ID());
					helper.L_DUP_CHECK(PM_IL_BONUS_SETUP_BEAN,this);	// Duplicate Check				
					new CRUDHandler().executeInsert(PM_IL_BONUS_SETUP_BEAN, commonUtils.getConnection());
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
					int year = PM_IL_BONUS_SETUP_BEAN.getBSET_YEAR()!=null ? PM_IL_BONUS_SETUP_BEAN.getBSET_YEAR() : 0;
					Double rate = PM_IL_BONUS_SETUP_BEAN.getBSET_RATE() !=null ? PM_IL_BONUS_SETUP_BEAN.getBSET_RATE() : 0.0;
					Double ratePer = PM_IL_BONUS_SETUP_BEAN.getBSET_RATE_PER()!=null ? PM_IL_BONUS_SETUP_BEAN.getBSET_RATE_PER() : 0.0;

					//String planCode = COMP_BSET_PLAN_CODE.getSubmittedValue().toString();
					
					//PM_IL_BONUS_SETUP_BEAN.setBSET_PLAN_CODE(planCode);
					PM_IL_BONUS_SETUP_BEAN.setBSET_BONUS_CODE(PM_IL_BONUS_SETUP_BEAN.getBSET_BONUS_CODE());
					PM_IL_BONUS_SETUP_BEAN.setBSET_YEAR(year);
					PM_IL_BONUS_SETUP_BEAN.setBSET_RATE(rate);
					PM_IL_BONUS_SETUP_BEAN.setBSET_RATE_PER(ratePer);
					PM_IL_BONUS_SETUP_BEAN.setBSET_CR_DT(new CommonUtils().getCurrentDate());
					PM_IL_BONUS_SETUP_BEAN.setBSET_CR_UID(controlBean.getM_USER_ID());
					helper.L_DUP_CHECK(PM_IL_BONUS_SETUP_BEAN,this);	// Duplicate Check	
					new CRUDHandler().executeInsert(PM_IL_BONUS_SETUP_BEAN, commonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					
					tableList.add(PM_IL_BONUS_SETUP_BEAN);
					
					for(int i=0;i<tableList.size();i++){
						PM_IL_BONUS_SETUP_BEAN = (PM_IL_BONUS_SETUP) tableList.get(i);
						if(i==0){
							setPM_IL_BONUS_SETUP_BEAN(PM_IL_BONUS_SETUP_BEAN);
							PM_IL_BONUS_SETUP_BEAN.setRowSelected(true);
						}else{
							PM_IL_BONUS_SETUP_BEAN.setRowSelected(false);
						}
					}
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	private void setBean(ControlBean controlBean) throws ParseException {
		int year = COMP_BSET_YEAR.getSubmittedValue()!=null ? Integer.parseInt(COMP_BSET_YEAR.getSubmittedValue().toString()) : 0;
		Double rate = COMP_BSET_RATE.getSubmittedValue()!=null ? Double.parseDouble(COMP_BSET_RATE.getSubmittedValue().toString()) : 0.0;
		Double ratePer = COMP_BSET_RATE_PER.getSubmittedValue()!=null ? Double.parseDouble(COMP_BSET_RATE_PER.getSubmittedValue().toString()) : 0.0;

		PM_IL_BONUS_SETUP_BEAN.setUI_M_BSET_BONUS_CODE_DESC(String.valueOf(COMP_UI_M_BSET_BONUS_CODE_DESC.getSubmittedValue()));
		PM_IL_BONUS_SETUP_BEAN.setBSET_YEAR(year);
		PM_IL_BONUS_SETUP_BEAN.setBSET_RATE(rate);
		PM_IL_BONUS_SETUP_BEAN.setBSET_RATE_PER(ratePer);
		PM_IL_BONUS_SETUP_BEAN.setBSET_UPD_DT(new CommonUtils().getCurrentDate());
		PM_IL_BONUS_SETUP_BEAN.setBSET_UPD_UID(controlBean.getM_USER_ID());
	}

	/**
	 * @return the filterBSET_YEAR
	 */
	public String getFilterBSET_YEAR() {
		return filterBSET_YEAR;
	}

	/**
	 * @param filterBSET_YEAR the filterBSET_YEAR to set
	 */
	public void setFilterBSET_YEAR(String filterBSET_YEAR) {
		this.filterBSET_YEAR = filterBSET_YEAR;
	}

	/**
	 * @return the filterBSET_RATE
	 */
	public String getFilterBSET_RATE() {
		return filterBSET_RATE;
	}

	/**
	 * @param filterBSET_RATE the filterBSET_RATE to set
	 */
	public void setFilterBSET_RATE(String filterBSET_RATE) {
		this.filterBSET_RATE = filterBSET_RATE;
	}

	/**
	 * @return the filterBSET_RATE_PER
	 */
	public String getFilterBSET_RATE_PER() {
		return filterBSET_RATE_PER;
	}

	/**
	 * @param filterBSET_RATE_PER the filterBSET_RATE_PER to set
	 */
	public void setFilterBSET_RATE_PER(String filterBSET_RATE_PER) {
		this.filterBSET_RATE_PER = filterBSET_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_BSET_BUY_SELL_LABEL() {
		return COMP_BSET_BUY_SELL_LABEL;
	}

	public void setCOMP_BSET_BUY_SELL_LABEL(HtmlOutputLabel comp_bset_buy_sell_label) {
		COMP_BSET_BUY_SELL_LABEL = comp_bset_buy_sell_label;
	}

	public HtmlSelectOneMenu getCOMP_BSET_BUY_SELL() {
		return COMP_BSET_BUY_SELL;
	}

	public void setCOMP_BSET_BUY_SELL(HtmlSelectOneMenu comp_bset_buy_sell) {
		COMP_BSET_BUY_SELL = comp_bset_buy_sell;
	}

	public HtmlOutputLabel getCOMP_BSET_BONUS_GIVEN_IN_LABEL() {
		return COMP_BSET_BONUS_GIVEN_IN_LABEL;
	}

	public void setCOMP_BSET_BONUS_GIVEN_IN_LABEL(
			HtmlOutputLabel comp_bset_bonus_given_in_label) {
		COMP_BSET_BONUS_GIVEN_IN_LABEL = comp_bset_bonus_given_in_label;
	}

	public HtmlSelectOneMenu getCOMP_BSET_BONUS_GIVEN_IN() {
		return COMP_BSET_BONUS_GIVEN_IN;
	}

	public void setCOMP_BSET_BONUS_GIVEN_IN(
			HtmlSelectOneMenu comp_bset_bonus_given_in) {
		COMP_BSET_BONUS_GIVEN_IN = comp_bset_bonus_given_in;
	}

	public HtmlOutputLabel getCOMP_BSET_APPLIED_ON_LABEL() {
		return COMP_BSET_APPLIED_ON_LABEL;
	}

	public void setCOMP_BSET_APPLIED_ON_LABEL(
			HtmlOutputLabel comp_bset_applied_on_label) {
		COMP_BSET_APPLIED_ON_LABEL = comp_bset_applied_on_label;
	}

	public HtmlSelectOneMenu getCOMP_BSET_APPLIED_ON() {
		return COMP_BSET_APPLIED_ON;
	}

	public void setCOMP_BSET_APPLIED_ON(HtmlSelectOneMenu comp_bset_applied_on) {
		COMP_BSET_APPLIED_ON = comp_bset_applied_on;
	}

	public HtmlOutputLabel getCOMP_BSET_UNIT_PUR_YN_LABEL() {
		return COMP_BSET_UNIT_PUR_YN_LABEL;
	}

	public void setCOMP_BSET_UNIT_PUR_YN_LABEL(
			HtmlOutputLabel comp_bset_unit_pur_yn_label) {
		COMP_BSET_UNIT_PUR_YN_LABEL = comp_bset_unit_pur_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_BSET_UNIT_PUR_YN() {
		return COMP_BSET_UNIT_PUR_YN;
	}

	public void setCOMP_BSET_UNIT_PUR_YN(HtmlSelectOneMenu comp_bset_unit_pur_yn) {
		COMP_BSET_UNIT_PUR_YN = comp_bset_unit_pur_yn;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	

	public void setListBSET_BONUS_GIVEN_IN(List<SelectItem> listBSET_BONUS_GIVEN_IN) {
		this.listBSET_BONUS_GIVEN_IN = listBSET_BONUS_GIVEN_IN;
	}

	

	public void setListBSET_BUY_SELL(List<SelectItem> listBSET_BUY_SELL) {
		this.listBSET_BUY_SELL = listBSET_BUY_SELL;
	}

	

	public void setListBSET_APPLIED_ON(List<SelectItem> listBSET_APPLIED_ON) {
		this.listBSET_APPLIED_ON = listBSET_APPLIED_ON;
	}

	

	public void setListBSET_UNIT_PUR_YN(List<SelectItem> listBSET_UNIT_PUR_YN) {
		this.listBSET_UNIT_PUR_YN = listBSET_UNIT_PUR_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	    }
	
	public  void validateBSET_BONUS_GIVEN_IN(FacesContext context,UIComponent component ,Object value){
		try{
			String valueObject = (String)value;
			PM_IL_BONUS_SETUP_BEAN.setBSET_BONUS_GIVEN_IN(valueObject);
			BSET_BONUS_GIVEN_validate(PM_IL_BONUS_SETUP_BEAN);
			
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public  void validateBSET_APPLIED_ON(FacesContext context,UIComponent component ,Object value){
		try{
			String valueObject = (String)value;
			PM_IL_BONUS_SETUP_BEAN.setBSET_APPLIED_ON(valueObject);
			BSET_APPLIED_ON_validate(PM_IL_BONUS_SETUP_BEAN);
			
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public  void validateBSET_UNIT_PUR_YN(FacesContext context,UIComponent component ,Object value){
		try{
			String valueObject = (String)value;
			PM_IL_BONUS_SETUP_BEAN.setBSET_UNIT_PUR_YN(valueObject);
			BSET_UNIT_PUR_YN_validate(PM_IL_BONUS_SETUP_BEAN);
			
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public  void validateBSET_BUY_SELL(FacesContext context,UIComponent component ,Object value){
		try{
			String valueObject = (String)value;
			PM_IL_BONUS_SETUP_BEAN.setBSET_BUY_SELL(valueObject);
		}catch(Exception e){
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void BSET_BONUS_GIVEN_validate(PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN) throws Exception{
		String M_BONUS_TYPE = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		String C1 ="SELECT BONUS_TYPE FROM PM_IL_BONUS WHERE  BONUS_CODE = ? ";
		try {
			handler = new CRUDHandler();
			connection = CommonUtils .getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{PM_IL_BONUS_SETUP_BEAN.getBSET_BONUS_CODE()});
			if(resultSet.next()){
				M_BONUS_TYPE = resultSet.getString(1);
			}
			if(!"U".equals(M_BONUS_TYPE) && !"A".equals(PM_IL_BONUS_SETUP_BEAN.getBSET_BONUS_GIVEN_IN())){
				PM_IL_BONUS_SETUP_BEAN.setBSET_BONUS_GIVEN_IN("A");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Field Can be updated only for Coupon Bonus");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	
	public void BSET_APPLIED_ON_validate(PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN) throws Exception{
		String M_BONUS_TYPE = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		String C1 ="SELECT BONUS_TYPE FROM PM_IL_BONUS WHERE  BONUS_CODE = ? ";
		try {
			handler = new CRUDHandler();
			connection = CommonUtils .getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{PM_IL_BONUS_SETUP_BEAN.getBSET_BONUS_CODE()});
			if(resultSet.next()){
				M_BONUS_TYPE = resultSet.getString(1);
			}
			if((!"U".equals(M_BONUS_TYPE)) && (!"I".equals(M_BONUS_TYPE)) && (!"S".equals(PM_IL_BONUS_SETUP_BEAN.getBSET_APPLIED_ON()))){
				PM_IL_BONUS_SETUP_BEAN.setBSET_APPLIED_ON("S");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Field Can be updated only for Coupon Bonus");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		
		
	}
	
	public void BSET_UNIT_PUR_YN_validate(PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN) throws Exception{
		String M_BONUS_TYPE = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		String C1 ="SELECT BONUS_TYPE FROM PM_IL_BONUS WHERE  BONUS_CODE = ? ";
		try {
			handler = new CRUDHandler();
			connection = CommonUtils .getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{PM_IL_BONUS_SETUP_BEAN.getBSET_BONUS_CODE()});
			if(resultSet.next()){
				M_BONUS_TYPE = resultSet.getString(1);
			}
			if((!"U".equals(M_BONUS_TYPE)) && (!"I".equals(M_BONUS_TYPE)) && (!"N".equals(PM_IL_BONUS_SETUP_BEAN.getBSET_UNIT_PUR_YN()))){
				PM_IL_BONUS_SETUP_BEAN.setBSET_UNIT_PUR_YN("N");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Field Can be updated only for Coupon Bonus");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}

	public String copyAction(){
		String planCode = PM_IL_BONUS_SETUP_BEAN.getBSET_PLAN_CODE();
		String description = PM_IL_BONUS_SETUP_BEAN.getUI_M_PLAN_CODE_DESC();
		
		// Resetting copy block and setting back reference of composite action in the new class
		compositeAction.setCOPY_ACTION_BEAN(new COPY_ACTION());
		compositeAction.getCOPY_ACTION_BEAN().compositeAction = compositeAction;
		
		compositeAction.getCOPY_ACTION_BEAN().getCOPY_BEAN().setUI_M_BSET_PLAN_CODE_SOURCE(planCode);
		compositeAction.getCOPY_ACTION_BEAN().getCOPY_BEAN().setUI_M_BSET_PLAN_CODE_DESC_SOURCE(description);
		return "copy";
	}
	
	public void onLoad(PhaseEvent phaseEvent) {
	    try {
		if (isBlockFlag()) {
			helper.executeQuery(compositeAction);
			if(PM_IL_BONUS_SETUP_BEAN.getROWID() != null){
				getCOMP_BSET_PLAN_CODE().setDisabled(true);
				getCOMP_BSET_PLAN_CODE_LOV_IMG().setRendered(false);
				helper.postQuery(PM_IL_BONUS_SETUP_BEAN);
			}
			setBlockFlag(false);
		}
	    } catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("CURRENT", e.getMessage());
	    }
	    
	}
public ArrayList<PM_IL_BONUS_SETUP> popPlanCodeLov(Object obj){
		
		String planCode= obj.toString();
		DelegateDb dbHelper = new DelegateDb();
		planCodeList  = dbHelper.populatePlanCodeLov(planCode);
		return planCodeList;
	}

	public void validateBSET_PLAN_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);

		try {
			PILM037_Helper validationHelper = new PILM037_Helper();
			PM_IL_BONUS_SETUP_BEAN.setBSET_PLAN_CODE((String) value);
			validationHelper
					.pilm037_pm_il_bonus_setup_bset_plan_code_when_validate_item(PM_IL_BONUS_SETUP_BEAN);
			COMP_UI_M_PLAN_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}

}

	public HtmlGraphicImage getCOMP_BSET_PLAN_CODE_LOV_IMG() {
		return COMP_BSET_PLAN_CODE_LOV_IMG;
	}

	public void setCOMP_BSET_PLAN_CODE_LOV_IMG(
			HtmlGraphicImage comp_bset_plan_code_lov_img) {
		COMP_BSET_PLAN_CODE_LOV_IMG = comp_bset_plan_code_lov_img;
	}

	public PM_IL_PLAN getPM_IL_PLAN_BEAN() {
		return PM_IL_PLAN_BEAN;
	}

	public void setPM_IL_PLAN_BEAN(PM_IL_PLAN pm_il_plan_bean) {
		PM_IL_PLAN_BEAN = pm_il_plan_bean;
	}	

	public String  deleteRecords(){
		CRUDHandler handler=new CRUDHandler();
		Connection connection = null;
		try {
		if(isDELETE_ALLOWED()){
	
			connection = CommonUtils.getConnection();
		 handler.executeDelete(PM_IL_BONUS_SETUP_BEAN, connection);
			connection.commit();
			compositeAction = new PILM037_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILM037_COMPOSITE_ACTION", compositeAction);

			// Assigning message to new action class
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getWarningMap().put(
					"deleteRow",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$delete"));
			compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN().getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$delete"));
		}	else {

			getErrorMap().put("deleteRow", Messages.getString(
					PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
		}
		
	} catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		getErrorMap().put("deleteRow", exc.getMessage());
	}
	return null;
}


}
