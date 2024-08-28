package com.iii.pel.forms.PILM036;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_BONUS_QUERY_ACTION  extends CommonAction implements Serializable, Cloneable {
	
	private static Log LOG = LogFactory.getLog(PM_IL_BONUS_QUERY_ACTION.class);
	
	private HtmlDataTable COMP_BONUS_DATATABLE;
	private HtmlOutputLabel COMP_BONUS_CODE_LABEL;
	private HtmlOutputLabel COMP_BONUS_YRS_LABEL;
	private HtmlOutputLabel COMP_BONUS_YRS_LABEL_SEL;
	private HtmlOutputLabel COMP_BONUS_TYPE_LABEL;
	private HtmlCommandButton COMP_UI_M_QUERY_BONUS_MASTER;
	private HtmlCommandButton COMP_M_PRE_FORM_BUTTON;
	private HtmlCommandButton COMP_UI_M_BUT_INSERT;
	private HtmlInputText COMP_BONUS_CODE;
	private HtmlInputText COMP_BONUS_YRS;
	private HtmlSelectOneMenu COMP_BONUS_TYPE;
	private PM_IL_BONUS PM_IL_BONUS;
	private PM_IL_BONUS_QUERY PM_IL_BONUS_QUERY_BEAN;
	private List<PM_IL_BONUS> bonusBeanList;
	List<SelectItem> BONUS_TYPE_LIST = new ArrayList<SelectItem>();
	List<SelectItem> BONUS_TYPE_DESC_LIST = new ArrayList<SelectItem>();
	private UIData dataTable;
	private HtmlInputText COMP_BONUS_YRS_SEL;
	
	private HtmlOutputLabel COMP_BONUS_BL_DESC_LABEL;

	private HtmlInputText COMP_BONUS_BL_DESC;

	private HtmlOutputLabel COMP_BONUS_BL_SHORT_DESC_LABEL;

	private HtmlInputText COMP_BONUS_BL_SHORT_DESC;

	
	private HtmlOutputLabel COMP_BONUS_DESC_LABEL;
	
	private HtmlInputText COMP_BONUS_DESC;

	private HtmlOutputLabel COMP_BONUS_SHORT_DESC_LABEL;

	private HtmlInputText COMP_BONUS_SHORT_DESC;

	
	private HtmlCommandButton COMP_UI_M_BUT_EDIT_BONUS_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_BL;
	
	private HtmlInputText COMP_BONUS_CODE_SEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private int lastUpdateRowIndex;
	
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
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}
	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public PM_IL_BONUS_QUERY_ACTION(){
		PM_IL_BONUS = new PM_IL_BONUS();
		instantiateAllComponent();
		PM_IL_BONUS_QUERY_BEAN = new PM_IL_BONUS_QUERY();
		queryData();
		/*if(bonusBeanList!=null && bonusBeanList.size()!=0){
			PM_IL_BONUS = (PM_IL_BONUS)bonusBeanList.get(0);
		}*/
	}
	public HtmlOutputLabel getCOMP_BONUS_CODE_LABEL() {
		return COMP_BONUS_CODE_LABEL;
	}
	public void setCOMP_BONUS_CODE_LABEL(HtmlOutputLabel comp_bonus_code_label) {
		COMP_BONUS_CODE_LABEL = comp_bonus_code_label;
	}
	public HtmlOutputLabel getCOMP_BONUS_YRS_LABEL() {
		return COMP_BONUS_YRS_LABEL;
	}
	public void setCOMP_BONUS_YRS_LABEL(HtmlOutputLabel comp_bonus_yrs_label) {
		COMP_BONUS_YRS_LABEL = comp_bonus_yrs_label;
	}
	public HtmlOutputLabel getCOMP_BONUS_TYPE_LABEL() {
		return COMP_BONUS_TYPE_LABEL;
	}
	public void setCOMP_BONUS_TYPE_LABEL(HtmlOutputLabel comp_bonus_type_label) {
		COMP_BONUS_TYPE_LABEL = comp_bonus_type_label;
	}
	public HtmlInputText getCOMP_BONUS_CODE() {
		return COMP_BONUS_CODE;
	}
	public void setCOMP_BONUS_CODE(HtmlInputText comp_bonus_code) {
		COMP_BONUS_CODE = comp_bonus_code;
	}
	public HtmlInputText getCOMP_BONUS_YRS() {
		return COMP_BONUS_YRS;
	}
	public void setCOMP_BONUS_YRS(HtmlInputText comp_bonus_yrs) {
		COMP_BONUS_YRS = comp_bonus_yrs;
	}
	public List<PM_IL_BONUS> getBonusBeanList() {
		return bonusBeanList;
	}
	public void setBonusBeanList(List<PM_IL_BONUS> bonusBeanList) {
		this.bonusBeanList = bonusBeanList;
	}
	public PM_IL_BONUS getPM_IL_BONUS() {
		return PM_IL_BONUS;
	}
	public void setPM_IL_BONUS(PM_IL_BONUS pm_il_bonus) {
		PM_IL_BONUS = pm_il_bonus;
	}
	public HtmlCommandButton getCOMP_UI_M_QUERY_BONUS_MASTER() {
		return COMP_UI_M_QUERY_BONUS_MASTER;
	}
	public void setCOMP_UI_M_QUERY_BONUS_MASTER(
			HtmlCommandButton comp_ui_m_query_bonus_master) {
		COMP_UI_M_QUERY_BONUS_MASTER = comp_ui_m_query_bonus_master;
	}
	
	public PM_IL_BONUS_QUERY getPM_IL_BONUS_QUERY_BEAN() {
		return PM_IL_BONUS_QUERY_BEAN;
	}
	public void setPM_IL_BONUS_QUERY_BEAN(PM_IL_BONUS_QUERY pm_il_bonus_query_bean) {
		PM_IL_BONUS_QUERY_BEAN = pm_il_bonus_query_bean;
	}
	public HtmlDataTable getCOMP_BONUS_DATATABLE() {
		return COMP_BONUS_DATATABLE;
	}
	public void setCOMP_BONUS_DATATABLE(HtmlDataTable comp_bonus_datatable) {
		COMP_BONUS_DATATABLE = comp_bonus_datatable;
	}
	
		
	public void queryData(){
		LOG.info("===========Inside Fetch Data============");
		PM_IL_BONUS_QUERY_ACTION bonusQueryAction = (PM_IL_BONUS_QUERY_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILM036_PM_IL_BONUS_QUERY_ACTION");
		if(bonusQueryAction!=null){
			PM_IL_BONUS_QUERY bonusQueryBean = bonusQueryAction.getPM_IL_BONUS_QUERY_BEAN();
			List<PM_IL_BONUS> bonusBeanList = new PM_IL_BONUS_DAO().retreiveTableData(bonusQueryBean);
			bonusQueryAction.setBonusBeanList(bonusBeanList);
			
			Iterator<PM_IL_BONUS> iterator = bonusBeanList.iterator();
			while(iterator.hasNext()){
				PM_IL_BONUS pm_il_bonus = (PM_IL_BONUS)iterator.next();
				pm_il_bonus.setRowSelected(false);
				LOG.info("After Set Row Selected False==========");
			}
			
			if(bonusBeanList!=null && bonusBeanList.size()>0){
				PM_IL_BONUS = (PM_IL_BONUS)bonusBeanList.get(0);
				PM_IL_BONUS.setRowSelected(true);
				setPM_IL_BONUS(PM_IL_BONUS);
				LOG.info("After Set Row Selected True==========");
			}
		}
	}
	
	public String insertBonusMaster(){
		return "insertBonus";
	}
	

	/**
	 * Instantiates all components in PM_IL_BONUS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_BONUS_BL_DESC				 = new HtmlInputText();
		COMP_BONUS_BL_SHORT_DESC			 = new HtmlInputText();
		COMP_BONUS_CODE					 = new HtmlInputText();
		COMP_BONUS_DESC					 = new HtmlInputText();
		COMP_BONUS_SHORT_DESC				 = new HtmlInputText();
		COMP_BONUS_YRS					 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_BONUS_TYPE					 = new HtmlSelectOneMenu();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_EDIT_BONUS_DESC			 = new HtmlCommandButton();
		COMP_UI_M_BUT_BL				 = new HtmlCommandButton();

	}


	
	public String clearList(PhaseEvent event){
		PM_IL_BONUS_DAO bonusDao = new PM_IL_BONUS_DAO();
		PM_IL_BONUS bonusTypeBean = new PM_IL_BONUS();
		String bonusCode = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("BONUS_CODE");
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PM_IL_BONUS_QUERY_ACTION queryAction = (PM_IL_BONUS_QUERY_ACTION) sessionMap.get("PILM036_PM_IL_BONUS_QUERY_ACTION");
		queryAction.setBonusBeanList(null);
		PM_IL_BONUS_QUERY bonusQueryBean = new PM_IL_BONUS_QUERY();
		bonusQueryBean.setBONUS_CODE(bonusCode);
		PM_IL_BONUS bonusBean  = bonusDao.getBonusCodeInfo(bonusCode);
		bonusBean.setBONUS_TYPE_DESC_LIST(queryAction.getPM_IL_BONUS_QUERY_BEAN().getBONUS_TYPE_LIST());
		PM_IL_BONUS_ACTION bonusAction = new PM_IL_BONUS_ACTION();
		bonusAction.setUpdate(true);
		bonusAction.setPM_IL_BONUS_BEAN(bonusBean);
		HtmlCommandButton M_BUT = new HtmlCommandButton();
		M_BUT.setDisabled(true);
		bonusAction.setCOMP_UI_M_BUT_BL(M_BUT);
		sessionMap.put("PILM036_PM_IL_BONUS_ACTION", bonusAction);
		return "insertBonus";
	}
	
	public void preForm(){
		System.out.println("In pre form");
		//getCOMP_M_PRE_FORM_BUTTON().setDisabled(true);
		
		/*List<String> bonusTypeList = ListItemUtil.getComboSuggestionValues(new PM_IL_BONUS_DAO().getConnection(), "PILM036", "PM_IL_BONUS", "PM_IL_BONUS.BONUS_TYPE", "IL_BON_TYP");
		PM_IL_BONUS_QUERY_ACTION queryAction = (PM_IL_BONUS_QUERY_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILM036_PM_IL_BONUS_QUERY_ACTION");
		queryAction.getPM_IL_BONUS_QUERY_BEAN().setBONUS_TYPE_LIST(bonusTypeList);*/
		try {
			getBONUS_TYPE_LIST();
			ControlBean controlBean = new ControlBean();
			controlBean.setM_SCR_NAME("BONUS MASTER");
			
			Connection connection = new PM_IL_BONUS_DAO().getConnection();
			// [BugId:Fix Shankar Bodduluri 19-03-09 resetting the client ID 
			/*String clientId = Constants.M_USER_ID+Calendar.getInstance().getTimeInMillis();
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("CLIENT_ID", clientId);
			session.setAttribute(clientId, connection);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteRows(){
		System.out.println("delete rows");
		Iterator<PM_IL_BONUS> itr = bonusBeanList.iterator();
		SWISS_SQL_PILM036 swiss = new SWISS_SQL_PILM036();
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		
		String recordUsed = null;
		while(itr.hasNext()){
			PM_IL_BONUS bonusBean = itr.next();
			if ("dataTableSelectedRow".equalsIgnoreCase(bonusBean.getRowSelected())) {
				boolean canDelete = swiss.keyDeleteRecord(FacesContext.getCurrentInstance(), bonusBean);
				if(!canDelete){
					if(recordUsed!=null)
						recordUsed += ", "+bonusBean.getBONUS_CODE();
					else
						recordUsed = bonusBean.getBONUS_CODE();
				}
			}
		}
		System.out.println(recordUsed);
		if(recordUsed!=null){
			getErrorMap().put("current", "Records with bonus code "+recordUsed+" can't be deleted");
		}else {
			if(getErrorMap().size()>0)
				getErrorMap().remove("current");
			System.out.println("records deleted");
			Iterator<PM_IL_BONUS> itr2 = bonusBeanList.iterator();
			PM_IL_BONUS_DAO bonusDao = new PM_IL_BONUS_DAO();
			deletedRecordList = new ArrayList();
			while(itr2.hasNext()){
				PM_IL_BONUS bonusBean = itr2.next();
				if ("dataTableSelectedRow".equalsIgnoreCase(bonusBean.getRowSelected())) {
					deletedRecordList.add(deletedRecordIndex);
					bonusDao.deleteBonusMaster(bonusBean.getBONUS_CODE());
					itr2.remove();
				}
				
			}
			
			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current",
						+deletedRecordList.size() + "Record Deleted ");

			}

		}
	}
	
	public HtmlCommandButton getCOMP_M_PRE_FORM_BUTTON() {
		return COMP_M_PRE_FORM_BUTTON;
	}
	public void setCOMP_M_PRE_FORM_BUTTON(HtmlCommandButton comp_m_pre_form_button) {
		COMP_M_PRE_FORM_BUTTON = comp_m_pre_form_button;
	}
	public HtmlSelectOneMenu getCOMP_BONUS_TYPE() {
		return COMP_BONUS_TYPE;
	}
	public void setCOMP_BONUS_TYPE(HtmlSelectOneMenu comp_bonus_type) {
		COMP_BONUS_TYPE = comp_bonus_type;
	}
	public List<SelectItem> getBONUS_TYPE_LIST() throws Exception {
		if (BONUS_TYPE_LIST.size() ==0)
		  { 
			BONUS_TYPE_LIST.clear();
			BONUS_TYPE_LIST = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(),"PILM036", "PM_IL_BONUS", "PM_IL_BONUS.BONUS_TYPE", "IL_BON_TYP");
			
		  }
		return BONUS_TYPE_LIST;
	}
	public void setBONUS_TYPE_LIST(List<SelectItem> bonus_type_list) {
		BONUS_TYPE_LIST = bonus_type_list;
	}
	
	public boolean lDupCheck(FacesContext facesContext){
		boolean isDup = false;
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		PM_IL_BONUS_QUERY_ACTION bonusAction = (PM_IL_BONUS_QUERY_ACTION) sessionMap.get("PILM036_PM_IL_BONUS_QUERY_ACTION");
		String bonusCode = (String) bonusAction.getCOMP_BONUS_CODE().getSubmittedValue();
		if(bonusCode==null){
			bonusCode = bonusAction.getPM_IL_BONUS_QUERY_BEAN().getBONUS_CODE();
		}
		String selectQuery = "SELECT * FROM  PM_IL_BONUS  WHERE  BONUS_CODE  = ?";
		Object[] values = {bonusCode};
		System.out.println(bonusCode);
		//String clientId = (String) sessionMap.get("CLIENT_ID");
		//Connection connection = (Connection) sessionMap.get(clientId);
		CRUDHandler handler = new CRUDHandler();
		try {
			//[BugId:Fix Shankar Bodduluri 19-03-09 getting connection from CommonUtil class getConnection()
			Connection connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(selectQuery, connection, values);
			while(rst.next()){
				isDup = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return isDup;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_INSERT() {
		return COMP_UI_M_BUT_INSERT;
	}
	public void setCOMP_UI_M_BUT_INSERT(HtmlCommandButton comp_ui_m_but_insert) {
		COMP_UI_M_BUT_INSERT = comp_ui_m_but_insert;
	}
	/**
	 * Get Details.
	 */
	public void getDetails() {
		try {
			if (bonusBeanList!=null && bonusBeanList.size() != 0) {				
				PM_IL_BONUS = (PM_IL_BONUS) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_BONUS.setRowSelected(true);	
			setPM_IL_BONUS(PM_IL_BONUS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Resets all components in this Block
	 */
	public void resetAllComponent(){
		COMP_BONUS_CODE_SEL.resetValue();
		COMP_BONUS_BL_DESC.resetValue();
		COMP_BONUS_BL_SHORT_DESC.resetValue();
		COMP_BONUS_DESC.resetValue();
		COMP_BONUS_SHORT_DESC.resetValue();
		COMP_BONUS_YRS_SEL.resetValue();
		COMP_BONUS_TYPE.resetValue();
	}

	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_BONUS> iterator = bonusBeanList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	/**
	 * @return the cOMP_BONUS_BL_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_BONUS_BL_DESC_LABEL() {
		return COMP_BONUS_BL_DESC_LABEL;
	}
	/**
	 * @param comp_bonus_bl_desc_label the cOMP_BONUS_BL_DESC_LABEL to set
	 */
	public void setCOMP_BONUS_BL_DESC_LABEL(HtmlOutputLabel comp_bonus_bl_desc_label) {
		COMP_BONUS_BL_DESC_LABEL = comp_bonus_bl_desc_label;
	}
	/**
	 * @return the cOMP_BONUS_BL_DESC
	 */
	public HtmlInputText getCOMP_BONUS_BL_DESC() {
		return COMP_BONUS_BL_DESC;
	}
	/**
	 * @param comp_bonus_bl_desc the cOMP_BONUS_BL_DESC to set
	 */
	public void setCOMP_BONUS_BL_DESC(HtmlInputText comp_bonus_bl_desc) {
		COMP_BONUS_BL_DESC = comp_bonus_bl_desc;
	}
	/**
	 * @return the cOMP_BONUS_BL_SHORT_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_BONUS_BL_SHORT_DESC_LABEL() {
		return COMP_BONUS_BL_SHORT_DESC_LABEL;
	}
	/**
	 * @param comp_bonus_bl_short_desc_label the cOMP_BONUS_BL_SHORT_DESC_LABEL to set
	 */
	public void setCOMP_BONUS_BL_SHORT_DESC_LABEL(
			HtmlOutputLabel comp_bonus_bl_short_desc_label) {
		COMP_BONUS_BL_SHORT_DESC_LABEL = comp_bonus_bl_short_desc_label;
	}
	/**
	 * @return the cOMP_BONUS_BL_SHORT_DESC
	 */
	public HtmlInputText getCOMP_BONUS_BL_SHORT_DESC() {
		return COMP_BONUS_BL_SHORT_DESC;
	}
	/**
	 * @param comp_bonus_bl_short_desc the cOMP_BONUS_BL_SHORT_DESC to set
	 */
	public void setCOMP_BONUS_BL_SHORT_DESC(HtmlInputText comp_bonus_bl_short_desc) {
		COMP_BONUS_BL_SHORT_DESC = comp_bonus_bl_short_desc;
	}
	/**
	 * @return the cOMP_BONUS_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_BONUS_DESC_LABEL() {
		return COMP_BONUS_DESC_LABEL;
	}
	/**
	 * @param comp_bonus_desc_label the cOMP_BONUS_DESC_LABEL to set
	 */
	public void setCOMP_BONUS_DESC_LABEL(HtmlOutputLabel comp_bonus_desc_label) {
		COMP_BONUS_DESC_LABEL = comp_bonus_desc_label;
	}

	/**
	 * @return the cOMP_BONUS_DESC
	 */
	public HtmlInputText getCOMP_BONUS_DESC() {
		return COMP_BONUS_DESC;
	}
	/**
	 * @param comp_bonus_desc the cOMP_BONUS_DESC to set
	 */
	public void setCOMP_BONUS_DESC(HtmlInputText comp_bonus_desc) {
		COMP_BONUS_DESC = comp_bonus_desc;
	}
	/**
	 * @return the cOMP_BONUS_SHORT_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_BONUS_SHORT_DESC_LABEL() {
		return COMP_BONUS_SHORT_DESC_LABEL;
	}
	/**
	 * @param comp_bonus_short_desc_label the cOMP_BONUS_SHORT_DESC_LABEL to set
	 */
	public void setCOMP_BONUS_SHORT_DESC_LABEL(
			HtmlOutputLabel comp_bonus_short_desc_label) {
		COMP_BONUS_SHORT_DESC_LABEL = comp_bonus_short_desc_label;
	}
	/**
	 * @return the cOMP_BONUS_SHORT_DESC
	 */
	public HtmlInputText getCOMP_BONUS_SHORT_DESC() {
		return COMP_BONUS_SHORT_DESC;
	}
	/**
	 * @param comp_bonus_short_desc the cOMP_BONUS_SHORT_DESC to set
	 */
	public void setCOMP_BONUS_SHORT_DESC(HtmlInputText comp_bonus_short_desc) {
		COMP_BONUS_SHORT_DESC = comp_bonus_short_desc;
	}
	/**
	 * @return the cOMP_UI_M_BUT_EDIT_BONUS_DESC
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_EDIT_BONUS_DESC() {
		return COMP_UI_M_BUT_EDIT_BONUS_DESC;
	}
	/**
	 * @param comp_ui_m_but_edit_bonus_desc the cOMP_UI_M_BUT_EDIT_BONUS_DESC to set
	 */
	public void setCOMP_UI_M_BUT_EDIT_BONUS_DESC(
			HtmlCommandButton comp_ui_m_but_edit_bonus_desc) {
		COMP_UI_M_BUT_EDIT_BONUS_DESC = comp_ui_m_but_edit_bonus_desc;
	}
	/**
	 * @return the cOMP_UI_M_BUT_BL
	 */
	public HtmlCommandButton getCOMP_UI_M_BUT_BL() {
		return COMP_UI_M_BUT_BL;
	}
	/**
	 * @param comp_ui_m_but_bl the cOMP_UI_M_BUT_BL to set
	 */
	public void setCOMP_UI_M_BUT_BL(HtmlCommandButton comp_ui_m_but_bl) {
		COMP_UI_M_BUT_BL = comp_ui_m_but_bl;
	}
	/**
	 * @return the cOMP_BONUS_CODE_SEL
	 */
	public HtmlInputText getCOMP_BONUS_CODE_SEL() {
		return COMP_BONUS_CODE_SEL;
	}
	/**
	 * @param comp_bonus_code_sel the cOMP_BONUS_CODE_SEL to set
	 */
	public void setCOMP_BONUS_CODE_SEL(HtmlInputText comp_bonus_code_sel) {
		COMP_BONUS_CODE_SEL = comp_bonus_code_sel;
	}
	
	/**
	 * Validates Billingal Desc.
	 * @param ae.
	 */
	public void bilingualDesc(ActionEvent ae) {
		UIInput input = (UIInput) ae.getComponent().getParent();
		String bilingualDesc = (String) input.getSubmittedValue();
		this.getErrorMap().remove("current");

		if(bilingualDesc==null || "".equalsIgnoreCase(bilingualDesc)){
			this.getErrorMap().put("current", "Description cannot be empty");
		}else{
			String bilingualShortDesc = null;
			if (bilingualDesc.length() > 30) {
				bilingualShortDesc = bilingualDesc.substring(1, 30);
			} else {
				bilingualShortDesc = bilingualDesc;
			}
			COMP_BONUS_DESC.setSubmittedValue(bilingualShortDesc);
			getPM_IL_BONUS().setBONUS_BL_SHORT_DESC(bilingualShortDesc);
		}
	}
	
	
	/**
	 * Bonus Term Validator.
	 * @param event
	 */
	public void bonusTermValidate(ActionEvent event){
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		String bonusTerm = (String) input.getSubmittedValue();
		ErrorHelpUtil.validate(input, getErrorMap());
		this.getErrorMap().remove("current");
		if(bonusTerm==null || "".equalsIgnoreCase(bonusTerm)){
			this.getErrorMap().put("current", "Bonus Years cannot be empty");
		}else{
			Double double1 = Double.parseDouble(bonusTerm);
			if(double1 <= 0.0 || double1 > 100.0){
				throw new ValidatorException(Messages.getMessage("messageProperties_PILM036", "PILM036$PM_IL_BONUS$BONUS_TYPE$error"));
			}
			
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
				PM_IL_BONUS = new PM_IL_BONUS();
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
		try {
			if (bonusBeanList != null && bonusBeanList.size() > 0) {
				deleteRows();
				this.setPM_IL_BONUS(bonusBeanList.get(0));
				this.getPM_IL_BONUS().setRowSelected(true);
				
				//queryData();
				
			}
			resetAllComponent();
		} catch (Exception exception) {
		}
		return "";
	}
	
	/**
	 * Post the record.
	 * @param ae
	 */
	public void post(ActionEvent ae) {
		try{
			CommonUtils commonUtils = new CommonUtils();
			/*Integer bonusYrs = ((String) COMP_BONUS_YRS_SEL.getSubmittedValue());
			PM_IL_BONUS.setBONUS_YRS(bonusYrs);*/
			ControlBean controlBean = CommonUtils.getControlBean();
			if(this.getPM_IL_BONUS().getROWID() != null) {
				if(isUPDATE_ALLOWED()) {
					LOG.info("Inside Update==========>");
					getPM_IL_BONUS().setBONUS_UPD_UID(controlBean.getM_USER_ID());
					getPM_IL_BONUS().setBONUS_UPD_DT(new CommonUtils().getCurrentDate());
					getPM_IL_BONUS().setBONUS_CODE(COMP_BONUS_CODE_SEL.getSubmittedValue().toString());
					getPM_IL_BONUS().setBONUS_BL_DESC(COMP_BONUS_BL_DESC.getSubmittedValue().toString());
					getPM_IL_BONUS().setBONUS_DESC(COMP_BONUS_DESC.getSubmittedValue().toString());
					getPM_IL_BONUS().setBONUS_SHORT_DESC(COMP_BONUS_SHORT_DESC.getSubmittedValue().toString());
					getPM_IL_BONUS().setBONUS_TYPE(COMP_BONUS_TYPE.getSubmittedValue().toString());
					getPM_IL_BONUS().setBONUS_BL_SHORT_DESC(COMP_BONUS_BL_SHORT_DESC.getSubmittedValue().toString());
					
					new CRUDHandler().executeInsert(PM_IL_BONUS, commonUtils.getConnection());
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					queryData();
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			} else {

				if(isINSERT_ALLOWED()) {
					LOG.info("Inside Inside==========>");
					
					getPM_IL_BONUS().setBONUS_CR_DT(new CommonUtils().getCurrentDate());
					getPM_IL_BONUS().setBONUS_CR_UID(controlBean.getM_USER_ID());
					getPM_IL_BONUS().setBONUS_CODE(COMP_BONUS_CODE_SEL.getSubmittedValue().toString());
					getPM_IL_BONUS().setBONUS_BL_DESC(COMP_BONUS_BL_DESC.getSubmittedValue().toString());
					getPM_IL_BONUS().setBONUS_DESC(COMP_BONUS_DESC.getSubmittedValue().toString());
					getPM_IL_BONUS().setBONUS_SHORT_DESC(COMP_BONUS_SHORT_DESC.getSubmittedValue().toString());
					getPM_IL_BONUS().setBONUS_TYPE(COMP_BONUS_TYPE.getSubmittedValue().toString());
					getPM_IL_BONUS().setBONUS_BL_SHORT_DESC(COMP_BONUS_BL_SHORT_DESC.getSubmittedValue().toString());
					
					new CRUDHandler().executeInsert(PM_IL_BONUS, commonUtils.getConnection());					
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					getWarningMap().put("post",
							Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					bonusBeanList.add(PM_IL_BONUS);
					if (bonusBeanList.size() > 0) {
						//setPM_IL_BONUS(bonusBeanList.get(0));
						queryData();
						this.getPM_IL_BONUS().setRowSelected(true);
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

	/**
	 * Gets the current UserId.
	 * @return
	 */
	private String getUserId() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		return (String) sessionMap.get("GLOBAL.M_USER_ID");
	}
	/**
	 * Gest the current date.
	 * @return
	 */
	private Date getCurrentDate(){
		return new Date(Calendar.getInstance().getTimeInMillis());	
	}

	/**
	 * Commit the sql.
	 */
	public void saveData() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put("current", "Record Saved");
		} catch (Exception e) {
			LOG.error(e);
		}
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<SelectItem> getBONUS_TYPE_DESC_LIST() throws Exception {
		
		if (BONUS_TYPE_DESC_LIST.size() ==0)
		  { 
			BONUS_TYPE_DESC_LIST.clear();
			BONUS_TYPE_DESC_LIST = ListItemUtil.getDropDownListValue(com.iii.premia.common.utils.CommonUtils.getConnection(),"PILM036","PM_IL_BONUS","PM_IL_BONUS.BONUS_TYPE","IL_BON_TYP");
			
		  }
		return BONUS_TYPE_DESC_LIST;
	}
	
	public void bonusCodeValidator(){
	String bonusCode = (String) COMP_BONUS_CODE_SEL.getSubmittedValue();
	this.getErrorMap().remove("current");
	if(bonusCode!=null){
		if(bonusCode.length()>0){
			boolean isExist = lDupCheck(FacesContext.getCurrentInstance());
			if(isExist){
//				message = new FacesMessage("Bonus code already exists");
				this.getErrorMap().put("current", "Bonus Code already exist");
//				bonusAction.getErrorMap().put(bonusAction.getCOMP_BONUS_CODE().getId(), message.getSummary());
			}
		}
		else{
//			message = new FacesMessage("Bonus Code cannot be empty");
			this.getErrorMap().put("current", "Bonus Code cannot be empty");
//			bonusAction.getErrorMap().put(bonusAction.getCOMP_BONUS_CODE().getId(), message.getSummary());
		}
	}
	}
	/**
	 * @return the cOMP_BONUS_YRS_SEL
	 */
	public HtmlInputText getCOMP_BONUS_YRS_SEL() {
		return COMP_BONUS_YRS_SEL;
	}
	/**
	 * @param comp_bonus_yrs_sel the cOMP_BONUS_YRS_SEL to set
	 */
	public void setCOMP_BONUS_YRS_SEL(HtmlInputText comp_bonus_yrs_sel) {
		COMP_BONUS_YRS_SEL = comp_bonus_yrs_sel;
	}
	/**
	 * @return the cOMP_BONUS_YRS_LABEL_SEL
	 */
	public HtmlOutputLabel getCOMP_BONUS_YRS_LABEL_SEL() {
		return COMP_BONUS_YRS_LABEL_SEL;
	}
	/**
	 * @param comp_bonus_yrs_label_sel the cOMP_BONUS_YRS_LABEL_SEL to set
	 */
	public void setCOMP_BONUS_YRS_LABEL_SEL(HtmlOutputLabel comp_bonus_yrs_label_sel) {
		COMP_BONUS_YRS_LABEL_SEL = comp_bonus_yrs_label_sel;
	}
}
