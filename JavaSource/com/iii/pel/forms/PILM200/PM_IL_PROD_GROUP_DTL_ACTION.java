package com.iii.pel.forms.PILM200;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_GROUP_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PGD_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PGD_FRZ_FLAG;

	private HtmlOutputLabel COMP_PGD_PROD_CODE_LABEL;

	private HtmlInputText COMP_PGD_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PROD_DESC;

	private HtmlOutputLabel COMP_PGD_MAIN_PROD_YN_LABEL;

	private HtmlSelectOneMenu COMP_PGD_MAIN_PROD_YN;

	private HtmlOutputLabel COMP_PGD_MANDATORY_YN_LABEL;

	private HtmlSelectOneMenu COMP_PGD_MANDATORY_YN;

	private HtmlOutputLabel COMP_PGD_DEFAULT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PGD_DEFAULT_YN;

	public PM_IL_PROD_GROUP_DTL PM_IL_PROD_GROUP_DTL_BEAN;
	
	
	public PM_IL_PROD_GROUP_DTL_HELPER helper; 

	private UIDataTable dataGrid;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private String filterByPGD_PROD_CODE;
	private String filterByUI_M_PROD_DESC;

	private HtmlSelectBooleanCheckbox check;
	CRUDHandler handler = null;

	//ControlBean ctrlBean;

	
	 public List<PM_IL_PROD_GROUP_DTL> dataList = new ArrayList<PM_IL_PROD_GROUP_DTL>();
	
	List<SelectItem> mainYN = new ArrayList<SelectItem>();
	List<SelectItem> mandYN = new ArrayList<SelectItem>();
	List<SelectItem> defaultYN = new ArrayList<SelectItem>();
	
	
	
	
	

	
	String desc = null;
	boolean flag = false;
	int mainYNCnt = 0;

	public  PILM200_COMPOSITE_ACTION compositeAction;

	public PM_IL_PROD_GROUP_DTL_ACTION() {
		
		PM_IL_PROD_GROUP_DTL_BEAN = new PM_IL_PROD_GROUP_DTL();
		helper = new PM_IL_PROD_GROUP_DTL_HELPER();
		setlistvaues();
		
		
		
		
	}

	public HtmlOutputLabel getCOMP_PGD_FRZ_FLAG_LABEL() {
		return COMP_PGD_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PGD_FRZ_FLAG() {
		return COMP_PGD_FRZ_FLAG;
	}

	public void setCOMP_PGD_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_PGD_FRZ_FLAG_LABEL) {
		this.COMP_PGD_FRZ_FLAG_LABEL = COMP_PGD_FRZ_FLAG_LABEL;
	}

	public void setCOMP_PGD_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_PGD_FRZ_FLAG) {
		this.COMP_PGD_FRZ_FLAG = COMP_PGD_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_PGD_PROD_CODE_LABEL() {
		return COMP_PGD_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PGD_PROD_CODE() {
		return COMP_PGD_PROD_CODE;
	}

	public void setCOMP_PGD_PROD_CODE_LABEL(HtmlOutputLabel COMP_PGD_PROD_CODE_LABEL) {
		this.COMP_PGD_PROD_CODE_LABEL = COMP_PGD_PROD_CODE_LABEL;
	}

	public void setCOMP_PGD_PROD_CODE(HtmlInputText COMP_PGD_PROD_CODE) {
		this.COMP_PGD_PROD_CODE = COMP_PGD_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROD_DESC_LABEL() {
		return COMP_UI_M_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROD_DESC() {
		return COMP_UI_M_PROD_DESC;
	}

	public void setCOMP_UI_M_PROD_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PROD_DESC_LABEL) {
		this.COMP_UI_M_PROD_DESC_LABEL = COMP_UI_M_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_PROD_DESC(HtmlInputText COMP_UI_M_PROD_DESC) {
		this.COMP_UI_M_PROD_DESC = COMP_UI_M_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_PGD_MAIN_PROD_YN_LABEL() {
		return COMP_PGD_MAIN_PROD_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PGD_MAIN_PROD_YN() {
		return COMP_PGD_MAIN_PROD_YN;
	}

	public void setCOMP_PGD_MAIN_PROD_YN_LABEL(HtmlOutputLabel COMP_PGD_MAIN_PROD_YN_LABEL) {
		this.COMP_PGD_MAIN_PROD_YN_LABEL = COMP_PGD_MAIN_PROD_YN_LABEL;
	}

	public void setCOMP_PGD_MAIN_PROD_YN(HtmlSelectOneMenu COMP_PGD_MAIN_PROD_YN) {
		this.COMP_PGD_MAIN_PROD_YN = COMP_PGD_MAIN_PROD_YN;
	}

	public HtmlOutputLabel getCOMP_PGD_MANDATORY_YN_LABEL() {
		return COMP_PGD_MANDATORY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PGD_MANDATORY_YN() {
		return COMP_PGD_MANDATORY_YN;
	}

	public void setCOMP_PGD_MANDATORY_YN_LABEL(HtmlOutputLabel COMP_PGD_MANDATORY_YN_LABEL) {
		this.COMP_PGD_MANDATORY_YN_LABEL = COMP_PGD_MANDATORY_YN_LABEL;
	}

	public void setCOMP_PGD_MANDATORY_YN(HtmlSelectOneMenu COMP_PGD_MANDATORY_YN) {
		this.COMP_PGD_MANDATORY_YN = COMP_PGD_MANDATORY_YN;
	}

	public HtmlOutputLabel getCOMP_PGD_DEFAULT_YN_LABEL() {
		return COMP_PGD_DEFAULT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PGD_DEFAULT_YN() {
		return COMP_PGD_DEFAULT_YN;
	}

	public void setCOMP_PGD_DEFAULT_YN_LABEL(HtmlOutputLabel COMP_PGD_DEFAULT_YN_LABEL) {
		this.COMP_PGD_DEFAULT_YN_LABEL = COMP_PGD_DEFAULT_YN_LABEL;
	}

	public void setCOMP_PGD_DEFAULT_YN(HtmlSelectOneMenu COMP_PGD_DEFAULT_YN) {
		this.COMP_PGD_DEFAULT_YN = COMP_PGD_DEFAULT_YN;
	}

	public PM_IL_PROD_GROUP_DTL getPM_IL_PROD_GROUP_DTL_BEAN() {
		return PM_IL_PROD_GROUP_DTL_BEAN;
	}

	public void setPM_IL_PROD_GROUP_DTL_BEAN(PM_IL_PROD_GROUP_DTL PM_IL_PROD_GROUP_DTL_BEAN) {
		this.PM_IL_PROD_GROUP_DTL_BEAN = PM_IL_PROD_GROUP_DTL_BEAN;
	}
	
	
public void setlistvaues(){
		
			mainYN.add(new SelectItem("Y"));
			mainYN.add(new SelectItem("N"));
			mandYN.add(new SelectItem("Y"));
			mandYN.add(new SelectItem("N"));
			defaultYN.add(new SelectItem("Y"));
			defaultYN.add(new SelectItem("N"));

	}
		

	

	

	public UIDataTable getDataGrid() {
		return dataGrid;
	}

	public void setDataGrid(UIDataTable dataGrid) {
		this.dataGrid = dataGrid;
	}

	public List<PM_IL_PROD_GROUP_DTL> getDataList() {
		return dataList;
	}

	public void setDataList(List<PM_IL_PROD_GROUP_DTL> dataList) {
		this.dataList = dataList;
	}

	public Map<String, Object> getSession(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}
	
	

	public void getDetails() {
		try {
			if ( dataList.size() != 0) {				
				 PM_IL_PROD_GROUP_DTL_BEAN = (PM_IL_PROD_GROUP_DTL) dataGrid.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PM_IL_PROD_GROUP_DTL_BEAN.setRowSelected(true);
			this.PM_IL_PROD_GROUP_DTL_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
			COMP_PGD_PROD_CODE.resetValue();
			COMP_UI_M_PROD_DESC.resetValue();
		// COMP_PGD_FRZ_FLAG.resetValue();
		 COMP_PGD_MAIN_PROD_YN.resetValue();
		 COMP_PGD_MANDATORY_YN.resetValue();
		 COMP_PGD_DEFAULT_YN.resetValue();
		 COMP_PGD_FRZ_FLAG.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_GROUP_DTL>  iterator = dataList.iterator();
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	

		
	public String validateNoMainProdCode(){
		int count = 0;
		for(int i=0; i<getDataList().size(); i++) {
			PM_IL_PROD_GROUP_DTL bean = getDataList().get(i) ;
			if("Y".equalsIgnoreCase(bean.getPGD_MAIN_PROD_YN())){
				count++ ;
			}
		}
		System.out.println("********The main product code count: "+count);
		if(count>1){
			getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91988").getSummary());
			getErrorMap().put("somekey", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91988").getSummary());
			return "failure";
		}else if(count ==0 ){
			getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91996").getSummary());
			getErrorMap().put("somekey", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91996").getSummary());
			System.out.println("Atleast one record should be main 91996");
			return "failure";
//			getErrorMap().clear();
		}else{
			System.out.println("Testing");
			getErrorMap().clear();
		}
		return "ok";
	}
	
	public void checkBoxValidation(ActionEvent event){
		CommonUtils.clearMaps(this);
		//dataColoumListener();
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void PGD_PROD_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			PM_IL_PROD_GROUP_DTL_BEAN.setPGD_PROD_CODE((String)value);
			helper.PGD_PROD_CODE_WHEN_VALIDATE_ITEM(PM_IL_PROD_GROUP_DTL_BEAN,compositeAction.getPM_IL_PROD_GROUP_HDR_ACTION_BEAN().getPM_IL_PROD_GROUP_HDR_BEAN().getPGH_GROUP_CODE());
			COMP_UI_M_PROD_DESC.resetValue();
			

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void PGD_MAIN_PROD_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			getPM_IL_PROD_GROUP_DTL_BEAN().setPGD_MAIN_PROD_YN((String)value);
			helper.PGD_MAIN_PROD_YN_WHEN_VALIDATE_ITEM(this,getPM_IL_PROD_GROUP_DTL_BEAN());
			COMP_PGD_MANDATORY_YN.resetValue();
			COMP_PGD_DEFAULT_YN.resetValue();
			

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void PGD_MANDATORY_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			getPM_IL_PROD_GROUP_DTL_BEAN().setPGD_MANDATORY_YN((String)value);
			helper.PGD_MANDATORY_YN_WHEN_VALIDATE_ITEM(this,getPM_IL_PROD_GROUP_DTL_BEAN());
			COMP_PGD_DEFAULT_YN.resetValue();
			
			

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void PGD_DEFAULT_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			getPM_IL_PROD_GROUP_DTL_BEAN().setPGD_DEFAULT_YN((String)value);
			helper.PGD_DEFAULT_YN_WHEN_VALIDATE_ITEM(getPM_IL_PROD_GROUP_DTL_BEAN());
			COMP_PGD_DEFAULT_YN.resetValue();
			
			

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void save(){
		CommonUtils.clearMaps(this);
		getErrorMap().clear();
		getWarningMap().clear();
		String message = null;
		try {
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("SAVE_RECORD",message);
		} catch (SQLException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				
				helper.executeQuery(compositeAction);
				/*for (PM_IL_PROD_GROUP_DTL  Bean : this.getDataList()) {
					if ("Y".equals(Bean.getPGD_MAIN_PROD_YN())) {
						this.getCOMP_PGD_MAIN_PROD_YN().setDisabled(true);
					}
				}*/
				if(PM_IL_PROD_GROUP_DTL_BEAN.getROWID() != null){
					
					helper.postQuery(PM_IL_PROD_GROUP_DTL_BEAN);
					
				}else{
					helper.whenCreateRecord(PM_IL_PROD_GROUP_DTL_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
				
			

	
	
	
	public String deleteRow(ActionEvent event) {
		String message = null;
		getWarningMap().clear();
		getErrorMap().clear();
		try {
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(PM_IL_PROD_GROUP_DTL_BEAN,CommonUtils.getConnection());
				dataList.remove(PM_IL_PROD_GROUP_DTL_BEAN);
				if (dataList.size() > 0) {
					PM_IL_PROD_GROUP_DTL_BEAN = dataList.get(0);
				} else if (dataList.size() == 0) {
					addNew(null);
				}
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$Grid$delete");
				getWarningMap().put("deleteRow", message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				resetAllComponent();
				PM_IL_PROD_GROUP_DTL_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
		return message;
	}





	public void addNew(ActionEvent ae){
    
			try {
				getErrorMap().clear();
				getWarningMap().clear();
				if (isINSERT_ALLOWED()){
						PM_IL_PROD_GROUP_DTL_BEAN = new PM_IL_PROD_GROUP_DTL();
						resetAllComponent();
						resetSelectedRow();
				}
				else{
					getErrorMap().put(
							"addRow",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));				}
				// Row highlight changes
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						exc.getMessage());
				getErrorMap().put("addRow", exc.getMessage());
			}	
			
	}
	
	
	public HtmlSelectBooleanCheckbox getCheck() {
		return check;
	}

	public void setCheck(HtmlSelectBooleanCheckbox check) {
		this.check = check;
	}

	
	
	public ArrayList<LovBean> prepareSuggestionList_PGH_APPL_PLAN_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "   SELECT DISTINCT PROD_CODE,PROD_DESC,PROD_BL_DESC FROM PM_IL_PRODUCT " 
   + " WHERE PROD_PLAN_CODE IN ( SELECT PLAN_CODE FROM  PM_IL_PLAN WHERE PLAN_TYPE IN ( {0} )) AND PROD_CODE LIKE ? AND ROWNUM < ? ORDER BY PROD_CODE";
		Object[] values = null;
		String currentValue = (String) object;
		String PLAN_TYPE = compositeAction.getPM_IL_PROD_GROUP_HDR_ACTION_BEAN().getPM_IL_PROD_GROUP_HDR_BEAN().getUI_M_PLAN_TYPE();

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			query = query.replace("{0}",PLAN_TYPE);
			values = new Object[] {  currentValue,PELConstants.suggetionRecordSize};
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

		
	
	
	

	public void postRecord(ActionEvent event) {
		String message = null;
		getWarningMap().clear();
		getErrorMap().clear();
		
		try {
			if (PM_IL_PROD_GROUP_DTL_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.preInsert(PM_IL_PROD_GROUP_DTL_BEAN,compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_GROUP_DTL_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				dataList.add(PM_IL_PROD_GROUP_DTL_BEAN);
			} else if (PM_IL_PROD_GROUP_DTL_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				helper.preUpdate(PM_IL_PROD_GROUP_DTL_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_PROD_GROUP_DTL_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$Grid$update");
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord", message);
			resetSelectedRow();
			PM_IL_PROD_GROUP_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: " + exc.getMessage());
				
				
		}

	}
	
	public void FRZ_FLAG_CLICK(ActionEvent ae){
		  CommonUtils.clearMaps(this);
		  UIInput component = (UIInput) ae.getComponent().getParent();
			String PGD_FRZ_FLAG = (String) component.getSubmittedValue();
		
			if("true".equals(PGD_FRZ_FLAG)) {
				PM_IL_PROD_GROUP_DTL_BEAN.setPGD_FRZ_FLAG("Y");
			} else {
				PM_IL_PROD_GROUP_DTL_BEAN.setPGD_FRZ_FLAG("N");
			}
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

	public String getFilterByPGD_PROD_CODE() {
		return filterByPGD_PROD_CODE;
	}

	public void setFilterByPGD_PROD_CODE(String filterByPGD_PROD_CODE) {
		this.filterByPGD_PROD_CODE = filterByPGD_PROD_CODE;
	}

	public String getFilterByUI_M_PROD_DESC() {
		return filterByUI_M_PROD_DESC;
	}

	public void setFilterByUI_M_PROD_DESC(String filterByUI_M_PROD_DESC) {
		this.filterByUI_M_PROD_DESC = filterByUI_M_PROD_DESC;
	}

	public List<SelectItem> getmainYN() {
		if (mainYN.size() == 0) {
			mainYN.clear();
			try {
				mainYN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mainYN;
	}

	public void setmainYN(List<SelectItem> mainYN) {
		this.mainYN = mainYN;
	}
	
	public List<SelectItem> getmandYN() {
		if (mandYN.size() == 0) {
			mandYN.clear();
			try {
				mandYN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mandYN;
	}

	public void setmandYN(List<SelectItem> mandYN) {
		this.mandYN = mandYN;
	}

	public List<SelectItem> getdefaultYN() {
		if (defaultYN.size() == 0) {
			defaultYN.clear();
			try {
				defaultYN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return defaultYN;
	}

	public void setdefaultYN(List<SelectItem> defaultYN) {
		this.defaultYN = defaultYN;
	}
	
	
}
