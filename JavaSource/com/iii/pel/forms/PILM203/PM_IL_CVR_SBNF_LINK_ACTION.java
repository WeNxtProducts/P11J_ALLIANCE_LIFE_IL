package com.iii.pel.forms.PILM203;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_CVR_SBNF_LINK_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_BSBL_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_BSBL_FRZ_FLAG;

	private HtmlOutputLabel COMP_BSBL_SBNF_CODE_LABEL;

	private HtmlInputText COMP_BSBL_SBNF_CODE;

	private HtmlOutputLabel COMP_UI_M_BSBL_BNF_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BSBL_BNF_DESC;

	private HtmlOutputLabel COMP_BSBL_LIMIT_TYP_LABEL;

	private HtmlSelectOneMenu COMP_BSBL_LIMIT_TYP;

	private HtmlOutputLabel COMP_BSBL_PER_DAY_LC_LIMIT_LABEL;

	private HtmlInputText COMP_BSBL_PER_DAY_LC_LIMIT;

	private HtmlOutputLabel COMP_BSBL_LIMIT_DAYS_LABEL;

	private HtmlInputText COMP_BSBL_LIMIT_DAYS;

	private HtmlOutputLabel COMP_BSBL_LIMIT_LC_AMT_LABEL;

	private HtmlInputText COMP_BSBL_LIMIT_LC_AMT;

	private PM_IL_CVR_SBNF_LINK PM_IL_CVR_SBNF_LINK_BEAN;

	private List<SelectItem> listBSBL_LIMIT_TYP = new ArrayList<SelectItem>();

	private UIData dataTablePM_IL_CVR_SBNF_LINK;

	private int lastUpdatedRowIndex;

	private int prevRowIndex;

	private int currPage;

	private int recordsPerPage = 8;

	private List<PM_IL_CVR_SBNF_LINK> listdataTablePM_IL_CVR_SBNF_LINK= new ArrayList<PM_IL_CVR_SBNF_LINK>();

	public DataGridDelegate dataGridDelegate;
	
	private PM_IL_CVR_BNF_LINK tempBean;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
// For Filter by
	
	private String filterByBSBL_SBNF_CODE;
	
	private String filterByBSBL_LIMIT_TYP;
	
	public PM_IL_COVER_ACTION coverAction;
	
	public PM_IL_CVR_SBNF_LINK_ACTION() {
		PM_IL_CVR_SBNF_LINK_BEAN = new PM_IL_CVR_SBNF_LINK();
		dataGridDelegate = new DataGridDelegate();
		prepareDropDowns();
//		listdataTablePM_IL_CVR_SBNF_LINK = new ArrayList<PM_IL_CVR_SBNF_LINK>();
	}
	public void prepareDropDowns(){
		try {
			Connection connection = CommonUtils.getConnection();
			setListBSBL_LIMIT_TYP(ListItemUtil.getDropDownListValue_1(
					connection, "PILM203", "PM_IL_CVR_SBNF_LINK",
					"PM_IL_CVR_SBNF_LINK.BSBL_LIMIT_TYP", null));

		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	

	public HtmlOutputLabel getCOMP_BSBL_FRZ_FLAG_LABEL() {
		return COMP_BSBL_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_BSBL_FRZ_FLAG() {
		return COMP_BSBL_FRZ_FLAG;
	}

	public void setCOMP_BSBL_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_BSBL_FRZ_FLAG_LABEL) {
		this.COMP_BSBL_FRZ_FLAG_LABEL = COMP_BSBL_FRZ_FLAG_LABEL;
	}

	public void setCOMP_BSBL_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_BSBL_FRZ_FLAG) {
		this.COMP_BSBL_FRZ_FLAG = COMP_BSBL_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_BSBL_SBNF_CODE_LABEL() {
		return COMP_BSBL_SBNF_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BSBL_SBNF_CODE() {
		return COMP_BSBL_SBNF_CODE;
	}

	public void setCOMP_BSBL_SBNF_CODE_LABEL(HtmlOutputLabel COMP_BSBL_SBNF_CODE_LABEL) {
		this.COMP_BSBL_SBNF_CODE_LABEL = COMP_BSBL_SBNF_CODE_LABEL;
	}

	public void setCOMP_BSBL_SBNF_CODE(HtmlInputText COMP_BSBL_SBNF_CODE) {
		this.COMP_BSBL_SBNF_CODE = COMP_BSBL_SBNF_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BSBL_BNF_DESC_LABEL() {
		return COMP_UI_M_BSBL_BNF_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BSBL_BNF_DESC() {
		return COMP_UI_M_BSBL_BNF_DESC;
	}

	public void setCOMP_UI_M_BSBL_BNF_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BSBL_BNF_DESC_LABEL) {
		this.COMP_UI_M_BSBL_BNF_DESC_LABEL = COMP_UI_M_BSBL_BNF_DESC_LABEL;
	}

	public void setCOMP_UI_M_BSBL_BNF_DESC(HtmlInputText COMP_UI_M_BSBL_BNF_DESC) {
		this.COMP_UI_M_BSBL_BNF_DESC = COMP_UI_M_BSBL_BNF_DESC;
	}

	public HtmlOutputLabel getCOMP_BSBL_LIMIT_TYP_LABEL() {
		return COMP_BSBL_LIMIT_TYP_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BSBL_LIMIT_TYP() {
		return COMP_BSBL_LIMIT_TYP;
	}

	public void setCOMP_BSBL_LIMIT_TYP_LABEL(HtmlOutputLabel COMP_BSBL_LIMIT_TYP_LABEL) {
		this.COMP_BSBL_LIMIT_TYP_LABEL = COMP_BSBL_LIMIT_TYP_LABEL;
	}

	public void setCOMP_BSBL_LIMIT_TYP(HtmlSelectOneMenu COMP_BSBL_LIMIT_TYP) {
		this.COMP_BSBL_LIMIT_TYP = COMP_BSBL_LIMIT_TYP;
	}

	public HtmlOutputLabel getCOMP_BSBL_PER_DAY_LC_LIMIT_LABEL() {
		return COMP_BSBL_PER_DAY_LC_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_BSBL_PER_DAY_LC_LIMIT() {
		return COMP_BSBL_PER_DAY_LC_LIMIT;
	}

	public void setCOMP_BSBL_PER_DAY_LC_LIMIT_LABEL(HtmlOutputLabel COMP_BSBL_PER_DAY_LC_LIMIT_LABEL) {
		this.COMP_BSBL_PER_DAY_LC_LIMIT_LABEL = COMP_BSBL_PER_DAY_LC_LIMIT_LABEL;
	}

	public void setCOMP_BSBL_PER_DAY_LC_LIMIT(HtmlInputText COMP_BSBL_PER_DAY_LC_LIMIT) {
		this.COMP_BSBL_PER_DAY_LC_LIMIT = COMP_BSBL_PER_DAY_LC_LIMIT;
	}

	public HtmlOutputLabel getCOMP_BSBL_LIMIT_DAYS_LABEL() {
		return COMP_BSBL_LIMIT_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_BSBL_LIMIT_DAYS() {
		return COMP_BSBL_LIMIT_DAYS;
	}

	public void setCOMP_BSBL_LIMIT_DAYS_LABEL(HtmlOutputLabel COMP_BSBL_LIMIT_DAYS_LABEL) {
		this.COMP_BSBL_LIMIT_DAYS_LABEL = COMP_BSBL_LIMIT_DAYS_LABEL;
	}

	public void setCOMP_BSBL_LIMIT_DAYS(HtmlInputText COMP_BSBL_LIMIT_DAYS) {
		this.COMP_BSBL_LIMIT_DAYS = COMP_BSBL_LIMIT_DAYS;
	}

	public HtmlOutputLabel getCOMP_BSBL_LIMIT_LC_AMT_LABEL() {
		return COMP_BSBL_LIMIT_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_BSBL_LIMIT_LC_AMT() {
		return COMP_BSBL_LIMIT_LC_AMT;
	}

	public void setCOMP_BSBL_LIMIT_LC_AMT_LABEL(HtmlOutputLabel COMP_BSBL_LIMIT_LC_AMT_LABEL) {
		this.COMP_BSBL_LIMIT_LC_AMT_LABEL = COMP_BSBL_LIMIT_LC_AMT_LABEL;
	}

	public void setCOMP_BSBL_LIMIT_LC_AMT(HtmlInputText COMP_BSBL_LIMIT_LC_AMT) {
		this.COMP_BSBL_LIMIT_LC_AMT = COMP_BSBL_LIMIT_LC_AMT;
	}

	public PM_IL_CVR_SBNF_LINK getPM_IL_CVR_SBNF_LINK_BEAN() {
		return PM_IL_CVR_SBNF_LINK_BEAN;
	}

	public void setPM_IL_CVR_SBNF_LINK_BEAN(PM_IL_CVR_SBNF_LINK PM_IL_CVR_SBNF_LINK_BEAN) {
		this.PM_IL_CVR_SBNF_LINK_BEAN = PM_IL_CVR_SBNF_LINK_BEAN;
	}

	public List<SelectItem> getListBSBL_LIMIT_TYP() {
		if (listBSBL_LIMIT_TYP.size() == 0) {
			listBSBL_LIMIT_TYP.clear();
			FacesContext fc = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) fc.getExternalContext().getContext();
			SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent) context.getAttribute("connectionAgent");
			Connection con;
			try {
				con = connectionAgent.getConnection("123");
				listBSBL_LIMIT_TYP = ListItemUtil.getDropDownListValue(con,
						"PILM203", "PM_IL_CVR_SBNF_LINK", "PM_IL_CVR_SBNF_LINK.BSBL_LIMIT_TYP",
				"CVRLMTTYP");
				//listBSBL_LIMIT_TYP.add(0,new SelectItem("",""));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listBSBL_LIMIT_TYP;
	}

	public void preInsertPM_IL_CVR_SBNF_LINK(PM_IL_CVR_SBNF_LINK gridBean) {
		gridBean.setBSBL_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		gridBean.setBSBL_CR_DT(new Date());
	}

	public void preUpdatePM_IL_CVR_SBNF_LINK(PM_IL_CVR_SBNF_LINK gridBean) {
//		:PM_IL_CVR_SBNF_LINK.BSBL_UPD_DT  := SYSDATE;
//		:PM_IL_CVR_SBNF_LINK.BSBL_UPD_UID := :CTRL.M_USER_ID;
		gridBean.setBSBL_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());		

		gridBean.setBSBL_UPD_DT(new Date());
	}

	public void whenCreateRecordPM_IL_CVR_SBNF_LINK(PM_IL_CVR_SBNF_LINK gridBean) {
//		:BSBL_FRZ_FLAG := 'N';
//		:PM_IL_CVR_SBNF_LINK.BSBL_LIMIT_TYP        := :PM_IL_COVER.COVER_LIMIT_TYPE;
//		:PM_IL_CVR_SBNF_LINK.BSBL_PER_DAY_LC_LIMIT := :PM_IL_COVER.COVER_PER_DAY_LC_AMT;
//		:PM_IL_CVR_SBNF_LINK.BSBL_LIMIT_DAYS       := :PM_IL_COVER.COVER_LIMIT_DAYS;
//		:PM_IL_CVR_SBNF_LINK.BSBL_LIMIT_LC_AMT     := :PM_IL_COVER.COVER_LC_LIMIT;
		PM_IL_COVER PM_IL_COVER_BEAN = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN();
		gridBean.setBSBL_FRZ_FLAG("N");
		gridBean.setBSBL_LIMIT_TYP(getTempBean().getCBL_LIMIT_TYP());
		gridBean.setBSBL_PER_DAY_LC_LIMIT(getTempBean().getCBL_PER_DAY_LC_LIMIT());
		gridBean.setBSBL_LIMIT_DAYS(getTempBean().getCBL_LIMIT_DAYS());
		gridBean.setBSBL_LIMIT_LC_AMT(getTempBean().getCBL_LIMIT_LC_AMT());

	}

	public void whenNewBlockInstancePM_IL_CVR_SBNF_LINK(PM_IL_CVR_SBNF_LINK gridBean) {
		PM_IL_COVER PM_IL_COVER_BEAN = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN();
		if("D".equals(gridBean.getBSBL_LIMIT_TYP())){
			gridBean.setBSBL_PER_DAY_LC_LIMIT_DISABLE(false);
			gridBean.setBSBL_LIMIT_DAYS_DISABLE(false);
			gridBean.setBSBL_PER_DAY_LC_LIMIT_REQUIRED(true);
			gridBean.setBSBL_LIMIT_DAYS_REQUIRED(true);
			gridBean.setBSBL_LIMIT_LC_AMT_DISABLE(true);
			gridBean.setBSBL_LIMIT_LC_AMT_REQUIRED(false);
		}else{
			gridBean.setBSBL_PER_DAY_LC_LIMIT_DISABLE(true);
			gridBean.setBSBL_LIMIT_DAYS_DISABLE(true);
			gridBean.setBSBL_PER_DAY_LC_LIMIT_REQUIRED(false);
			gridBean.setBSBL_LIMIT_DAYS_REQUIRED(false);
			gridBean.setBSBL_LIMIT_LC_AMT_DISABLE(false);
			gridBean.setBSBL_LIMIT_LC_AMT_REQUIRED(true);
		}
	}
	
	/*public String addNew(ActionEvent ae){
		
		
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PM_IL_CVR_SBNF_LINK_BEAN=null;
			if (isINSERT_ALLOWED()){
				PM_IL_CVR_SBNF_LINK_BEAN = new PM_IL_CVR_SBNF_LINK();
				whenCreateRecordPM_IL_CVR_SBNF_LINK(PM_IL_CVR_SBNF_LINK_BEAN);
				whenNewBlockInstancePM_IL_CVR_SBNF_LINK(PM_IL_CVR_SBNF_LINK_BEAN);
				 
				resetAllComponent();
			}
			else{
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
		if(listdataTablePM_IL_CVR_SBNF_LINK == null){
			listdataTablePM_IL_CVR_SBNF_LINK = new ArrayList<PM_IL_CVR_SBNF_LINK>();
		}
 
		return "newadded";
	}
	*/
/*
	public String deleteRow(ActionEvent ae) {
		PM_IL_CVR_SBNF_LINK bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if(listdataTablePM_IL_CVR_SBNF_LINK!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<listdataTablePM_IL_CVR_SBNF_LINK.size();)
			{
				bean = listdataTablePM_IL_CVR_SBNF_LINK.get(index);
				if("dataTableSelectedRow".equalsIgnoreCase(PM_IL_CVR_SBNF_LINK_BEAN.getRowSelected())){
					listdataTablePM_IL_CVR_SBNF_LINK.remove(bean);
					deletedRecordIndex = dataGridDelegate.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				}else {
					index++;
				}
			}

			if(deletedRecordList.size()>0)
			{
				getErrorMap().put("somekey", deletedRecordList.size()+" records deleted.");
				getErrorMap().put("current", deletedRecordList.size()+" records deleted.");
			} else {
				throwMessage("");
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}
*/

	public void addNew(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_IL_CVR_SBNF_LINK_BEAN = new PM_IL_CVR_SBNF_LINK();
				resetAllComponent();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}

	}
	
	public void deleteRow(ActionEvent ae) {
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();

			if(isDELETE_ALLOWED()) {
				if(PM_IL_CVR_SBNF_LINK_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PM_IL_CVR_SBNF_LINK_BEAN, CommonUtils.getConnection());
					listdataTablePM_IL_CVR_SBNF_LINK.remove(PM_IL_CVR_SBNF_LINK_BEAN);
				}
				
				if(listdataTablePM_IL_CVR_SBNF_LINK.size() > 0) {
					setPM_IL_CVR_SBNF_LINK_BEAN(listdataTablePM_IL_CVR_SBNF_LINK.get(0));
				} else {
					addNew(ae);
				}
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				getWarningMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}

	public void checkBoxValidation(ActionEvent event) {
//		gridtabListener();
		CommonUtils.clearMaps(this);
		int rowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();
		getListdataTablePM_IL_CVR_SBNF_LINK().get(rowIndex).setCHECK_BOX(Boolean.parseBoolean(getCurrentValue(event)));
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		//getCurrentValue(actionEvent);
		CommonUtils.clearMaps(this);
		int rowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();
		getListdataTablePM_IL_CVR_SBNF_LINK().get(rowIndex).setCHECK_BOX(Boolean.parseBoolean(getCurrentValue(actionEvent)));
		System.out.println("Comming to check box status");
		return "";
	}
	
	public void whenValidateBSBL_FRZ_FLAG(ActionEvent event) {
		CommonUtils.clearMaps(this);
	//	int currRowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();
		UIInput component = (UIInput) event.getComponent().getParent();
		String freeze = (String) component.getSubmittedValue();
		 
		if("true".equals(freeze)) {
			PM_IL_CVR_SBNF_LINK_BEAN.setFreezSelect(true);
		} else {
			PM_IL_CVR_SBNF_LINK_BEAN.setFreezSelect(false);
		}
		if(getErrorMap().isEmpty())
		{
			//lastColumnListener();
		}
	}

	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;

		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}


	public void nextBlock_PM_IL_BNF_DEDB_LINK(String code) {
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		PM_IL_BNF_DEDB_LINK_ACTION sbnfLinkAction = (PM_IL_BNF_DEDB_LINK_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_BNF_DEDB_LINK_ACTION");

		String cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();

		String queryForBnfLink = "SELECT ROWID,PM_IL_BNF_DEDB_LINK.* FROM PM_IL_BNF_DEDB_LINK WHERE BDL_COVER_CODE = '"+cover_code+"' AND BDL_BNF_CODE='"+code+"'";
		System.out.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_BNF_DEDB_LINK() query "+queryForBnfLink);

		CRUDHandler handler = new CRUDHandler();
		try {
			List<PM_IL_BNF_DEDB_LINK> list = handler.fetch(queryForBnfLink, "com.iii.pel.forms.PILM203.PM_IL_BNF_DEDB_LINK", CommonUtils.getConnection());
			System.out
			.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_CVR_BNF_LINK() list size "+list.size());

//			if(list != null && list.size() > 0) {
//				sbnfLinkAction.getListdataTablePM_IL_BNF_DEDB_LINK().clear();
//				PM_IL_BNF_DEDB_LINK valueBean = list.get(0);
//				System.out.println(valueBean.getBDEL_DEDB_CODE()+"  "+valueBean.getBDL_DEDB_NO_OF_DAYS());
//				sbnfLinkAction.setListdataTablePM_IL_BNF_DEDB_LINK(list);
//
//				for(int i=0;i<4;i++) {
//					PM_IL_CVR_BNF_LINK dummylist = new PM_IL_CVR_BNF_LINK();
////					bnfLinkAction.getLIST_dataTable().add(dummylist);
//				}
//
//				sbnfLinkAction.setPM_IL_BNF_DEDB_LINK_BEAN(valueBean);
//				sbnfLinkAction.postQueryPM_IL_BNF_DEDB_LINK(valueBean);
//			}
			
			for(int i=0 ; i < list.size() ; i++) {
				PM_IL_BNF_DEDB_LINK valueBean = list.get(i);
				sbnfLinkAction.postQueryPM_IL_BNF_DEDB_LINK(valueBean);
				sbnfLinkAction.setPM_IL_BNF_DEDB_LINK_BEAN(valueBean);
			}
			sbnfLinkAction.setListdataTablePM_IL_BNF_DEDB_LINK(list);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public String saveNext() {
		save();
		//nextBlock_PM_IL_BNF_DEDB_LINK();
		return "nextpage";
	}

	public String next() {
		//nextBlock_PM_IL_BNF_DEDB_LINK();
		return "nextpage";
	}

	public String last() {
		return "lastpage";
	}
	public String prevPage() {
		return "prevpage";
	}


	public void save() {
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
	}
	
	public void setEnableDisable(PM_IL_CVR_SBNF_LINK gridValueBean) {
		
		try {
			if ("D".equalsIgnoreCase(gridValueBean.getBSBL_LIMIT_TYP())) {

				gridValueBean.setBSBL_PER_DAY_LC_LIMIT_DISABLE(false);
				gridValueBean.setBSBL_LIMIT_DAYS_DISABLE(false);

				if (!"".equals(gridValueBean.getROWID())
						&& gridValueBean.getROWID() != null) {
					gridValueBean.setBSBL_PER_DAY_LC_LIMIT_DISABLE(false);
					gridValueBean.setBSBL_LIMIT_DAYS_DISABLE(false);
				}

				gridValueBean.setBSBL_PER_DAY_LC_LIMIT_REQUIRED(true);
				gridValueBean.setBSBL_LIMIT_DAYS_REQUIRED(true);

				gridValueBean.setBSBL_LIMIT_LC_AMT_DISABLE(true);

				if (!"".equals(gridValueBean.getROWID())
						&& gridValueBean.getROWID() != null) {
					gridValueBean.setBSBL_LIMIT_LC_AMT_DISABLE(true);
				}

				gridValueBean.setBSBL_LIMIT_LC_AMT_REQUIRED(false);
			}
			if ("F".equalsIgnoreCase(gridValueBean.getBSBL_LIMIT_TYP())) {
				gridValueBean.setBSBL_PER_DAY_LC_LIMIT(null);
				gridValueBean.setBSBL_LIMIT_DAYS(null);
				gridValueBean.setBSBL_PER_DAY_LC_LIMIT_DISABLE(true);
				gridValueBean.setBSBL_LIMIT_DAYS_DISABLE(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void getDetails() {
		try {
			if ( listdataTablePM_IL_CVR_SBNF_LINK.size() != 0) {				
				 this.PM_IL_CVR_SBNF_LINK_BEAN = (PM_IL_CVR_SBNF_LINK) dataTablePM_IL_CVR_SBNF_LINK.getRowData();
			}
			setEnableDisable(PM_IL_CVR_SBNF_LINK_BEAN);
			resetAllComponent();			
			resetSelectedRow();
			this.PM_IL_CVR_SBNF_LINK_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_BSBL_SBNF_CODE.resetValue();
		COMP_BSBL_LIMIT_DAYS.resetValue();
		 COMP_BSBL_LIMIT_LC_AMT.resetValue();
		 COMP_BSBL_LIMIT_TYP.resetValue();
		 COMP_UI_M_BSBL_BNF_DESC.resetValue();
		 COMP_BSBL_FRZ_FLAG.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_CVR_SBNF_LINK>  iterator = listdataTablePM_IL_CVR_SBNF_LINK.iterator();
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}



	public void postQueryPM_IL_CVR_SBNF_LINK(PM_IL_CVR_SBNF_LINK gridBean) {
//		P_VAL_CODES('IL_SBNF_CODE',
//		:PM_IL_CVR_SBNF_LINK.BSBL_SBNF_CODE,
//		:PM_IL_CVR_SBNF_LINK.M_BSBL_BNF_DESC,
//		'N',
//		'N',NULL);
		
//		
//
//		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
//		OracleParameter param1 = new OracleParameter("in1","STRING","IN","'IL_SBNF_CODE'" );
//		OracleParameter param2 = new OracleParameter("in2","STRING","IN",gridBean.getBSBL_SBNF_CODE());
//		OracleParameter param3 = new OracleParameter("in3","STRING","IN OUT",gridBean.getUI_M_BSBL_BNF_DESC());
//		OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
//		OracleParameter param5 = new OracleParameter("in5","STRING","IN","'N'");
//		OracleParameter param6 = new OracleParameter("in6","STRING","IN",null);
//		paramList.add(param1);
//		paramList.add(param2);
//		paramList.add(param3);
//		paramList.add(param4);
//		paramList.add(param5);
//		paramList.add(param6);
//		OracleProcedureHandler procHandler = new OracleProcedureHandler();
//		List<OracleParameter> list = null;
//		Connection conn = null;
//		try {
//			conn = getConnection();
//			list = procHandler.execute(paramList, getConnection(), "P_VAL_CODES");
//			gridBean.setUI_M_BSBL_BNF_DESC(list.get(0).getValue());
//			throwMessage("");
//		} catch (Exception e) {
//			String errorMessage = e.getLocalizedMessage();
//			throwMessage(errorMessage);
//		}
		
		String UI_M_BSBL_BNF_DESC = "";

		try{
			CallableStatement cs = CommonUtils.getConnection().prepareCall("{call P_VAL_CODES(?,?,?,?,?,?)}");
			cs.setString(1, "IL_SBNF_CODE");
			cs.setString(2, gridBean.getBSBL_SBNF_CODE());
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.setString(4, "N");
			cs.setString(5, "N");
			cs.setNull(6, java.sql.Types.NULL);
			boolean flag = cs.execute();
			UI_M_BSBL_BNF_DESC = cs.getString(3);
			System.out.println("PM_IL_CVR_SBNF_LINK_ACTION.postQueryPM_IL_CVR_SBNF_LINK() desc: "+UI_M_BSBL_BNF_DESC);
			gridBean.setUI_M_BSBL_BNF_DESC(UI_M_BSBL_BNF_DESC);
			getErrorMap().clear();
		} catch(Exception e) {
//			e.printStackTrace();
			String errorMessage = e.getLocalizedMessage();
			throwMessage(errorMessage);
		}
	}

	//save or update the record
	public void post(ActionEvent ae) {
		int rowUpdated=0;
		try{
			String cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
			if(PM_IL_CVR_SBNF_LINK_BEAN.getROWID()!=null){
				if(isUPDATE_ALLOWED()) {
					PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_COVER_CODE(cover_code);
					preUpdatePM_IL_CVR_SBNF_LINK(PM_IL_CVR_SBNF_LINK_BEAN);
					rowUpdated = dataGridDelegate.updateData(PM_IL_CVR_SBNF_LINK_BEAN);
					if(rowUpdated>0)
					{
						getWarningMap().put("current",Messages.getString("messageProperties", "errorPanel$message$update"));
						getWarningMap().put("post", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					}
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			}else{
				if(isINSERT_ALLOWED()) {
					PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_COVER_CODE(cover_code);
					
					PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_BNF_CODE(tempBean.getCBL_BNF_CODE());
					preInsertPM_IL_CVR_SBNF_LINK(PM_IL_CVR_SBNF_LINK_BEAN);
					rowUpdated = dataGridDelegate.updateData(PM_IL_CVR_SBNF_LINK_BEAN);
					if(rowUpdated>0)
					{
						listdataTablePM_IL_CVR_SBNF_LINK.add(PM_IL_CVR_SBNF_LINK_BEAN);
						getWarningMap().put("current",Messages.getString("messageProperties", "errorPanel$message$insert"));
						getWarningMap().put("post", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					}
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_CVR_SBNF_LINK_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	

	public void lastColumnListener() {
		int currRowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();
		int rowUpdated = 0;
		PM_IL_CVR_SBNF_LINK gridValueBean = null;

		String cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
		try {
			gridValueBean = listdataTablePM_IL_CVR_SBNF_LINK.get(currRowIndex) ;

			if(gridValueBean.getROWID()!=null) {
				gridValueBean.setBSBL_COVER_CODE(cover_code);
				preUpdatePM_IL_CVR_SBNF_LINK(gridValueBean);
				rowUpdated = dataGridDelegate.updateData(gridValueBean);
				if(rowUpdated>0)
				{
					getErrorMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "UPDATE_MESSAGE"));
					
				}
			} else {
				gridValueBean.setBSBL_COVER_CODE(cover_code);
				
				gridValueBean.setBSBL_BNF_CODE(tempBean.getCBL_BNF_CODE());
				preInsertPM_IL_CVR_SBNF_LINK(gridValueBean);
				rowUpdated = dataGridDelegate.updateData(gridValueBean);
				System.out.println("INSERT upDATED ROWS::::::::"+rowUpdated);
				if(rowUpdated>0)
				{
					getErrorMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
				}
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return ;
	}


	public void setListBSBL_LIMIT_TYP(List<SelectItem> listBSBL_LIMIT_TYP) {
		this.listBSBL_LIMIT_TYP = listBSBL_LIMIT_TYP;
	}

	public UIData getDataTablePM_IL_CVR_SBNF_LINK() {
		return dataTablePM_IL_CVR_SBNF_LINK;
	}

	public void setDataTablePM_IL_CVR_SBNF_LINK(UIData dataTablePM_IL_CVR_SBNF_LINK) {
		this.dataTablePM_IL_CVR_SBNF_LINK = dataTablePM_IL_CVR_SBNF_LINK;
	}

	public List<PM_IL_CVR_SBNF_LINK> getListdataTablePM_IL_CVR_SBNF_LINK() {
		return listdataTablePM_IL_CVR_SBNF_LINK;
	}

	public void setListdataTablePM_IL_CVR_SBNF_LINK(
			List<PM_IL_CVR_SBNF_LINK> listdataTablePM_IL_CVR_SBNF_LINK) {
		this.listdataTablePM_IL_CVR_SBNF_LINK = listdataTablePM_IL_CVR_SBNF_LINK;
	}

	public void whenValidateBSBL_SBNF_CODE(FacesContext context, UIComponent comp, Object value)throws ValidatorException {
		//int currRowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();

		//UIInput component = (UIInput) event.getComponent().getParent();
		try {
			if(value!=null)
		{
			String BSBL_SBNF_CODE = (String) value;
			
			//PM_IL_CVR_SBNF_LINK gridValueBean = listdataTablePM_IL_CVR_SBNF_LINK.get(currRowIndex) ;
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_SBNF_CODE(BSBL_SBNF_CODE);
	
			//L_VAL_SBNF_UNIQUE procedure calling
			String cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
			
			String M_DUMMY = new PM_IL_COVER_DELEGATE().L_VAL_SBNF_UNIQUE(getTempBean().getCBL_BNF_CODE(),BSBL_SBNF_CODE,cover_code);
			System.out.println("dummy::::::::::::::::"+M_DUMMY);
			if(new CommonUtils().isDuplicate(PM_IL_CVR_SBNF_LINK_BEAN.getROWID(), M_DUMMY)){
					//getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "92018"));
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "92018"));
			}
			String description = P_VAL_CODES(BSBL_SBNF_CODE);
			PM_IL_CVR_SBNF_LINK_BEAN.setUI_M_BSBL_BNF_DESC(description);
		}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	}
	
	public void whenValidateUI_M_BSBL_BNF_DESC(ActionEvent event) {
		CommonUtils.clearMaps(this);
	//	int currRowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();
		UIInput component = (UIInput) event.getComponent().getParent();
		String UI_M_BSBL_BNF_DESC = (String) component.getSubmittedValue();
		//PM_IL_CVR_SBNF_LINK gridValueBean = listdataTablePM_IL_CVR_SBNF_LINK.get(currRowIndex) ;
		PM_IL_CVR_SBNF_LINK_BEAN.setUI_M_BSBL_BNF_DESC(UI_M_BSBL_BNF_DESC);
	}
	
	public void whenValidateBSBL_LIMIT_TYP(ActionEvent event) {
		CommonUtils.clearMaps(this);
	//	int currRowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();
		UIInput component = (UIInput) event.getComponent().getParent();
		String BSBL_LIMIT_TYP = (String) component.getSubmittedValue();
	//	PM_IL_CVR_SBNF_LINK gridValueBean = listdataTablePM_IL_CVR_SBNF_LINK.get(currRowIndex) ;
		PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_TYP(BSBL_LIMIT_TYP);
	}


	private void L_VAL_SBNF_UNIQUE(String BSBL_SBNF_CODE) {
		String CBL_BNF_CODE = (String) getPM_IL_CVR_BNF_LINK_ACTION().getCOMP_CBL_BNF_CODE().getSubmittedValue();
		String PM_IL_COVER = (String) getPM_IL_COVER_ACTION().getCOMP_COVER_CODE().getSubmittedValue();
		String ROWID = ((PM_IL_CVR_BNF_LINK)getDataTablePM_IL_CVR_SBNF_LINK().getRowData()).getROWID();


		String query1 = "SELECT 'X' FROM   PM_IL_CVR_SBNF_LINK " +
		"WHERE BSBL_SBNF_CODE  = '"+BSBL_SBNF_CODE+"' " +
		"AND BSBL_BNF_CODE   = '"+CBL_BNF_CODE+"' " +
		"AND BSBL_COVER_CODE = '"+PM_IL_COVER+"'";

		String query2 = "SELECT 'X' FROM   PM_IL_CVR_SBNF_LINK " +
		"WHERE  BSBL_BNF_CODE   = '"+BSBL_SBNF_CODE+"' " +
		"AND BSBL_BNF_CODE   = '"+CBL_BNF_CODE+"' " +
		"AND BSBL_COVER_CODE = '"+PM_IL_COVER+"' " +
		"AND ROWID <>  '"+ROWID+"'";

	}

	public void fireFieldValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	private PM_IL_CVR_BNF_LINK_ACTION getPM_IL_CVR_BNF_LINK_ACTION() {
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		PM_IL_CVR_BNF_LINK_ACTION bnfLinkAction = (PM_IL_CVR_BNF_LINK_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_CVR_BNF_LINK_ACTION");
		return bnfLinkAction;
	} 

	private PM_IL_COVER_ACTION getPM_IL_COVER_ACTION() {
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		PM_IL_COVER_ACTION coverAction = (PM_IL_COVER_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_COVER_ACTION");
		return coverAction;
	}

	public void whenValidateBSBL_PER_DAY_LC_LIMIT(FacesContext context, UIComponent comp , Object value)throws ValidatorException {

		/*UIInput component = (UIInput) event.getComponent().getParent();
		String BSBL_PER_DAY_LC_LIMIT = (String) component.getSubmittedValue();
		BSBL_PER_DAY_LC_LIMIT = "".equals(BSBL_PER_DAY_LC_LIMIT)?"0":BSBL_PER_DAY_LC_LIMIT;*/
		
		//int currRowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();
		//PM_IL_CVR_SBNF_LINK gridValueBean = listdataTablePM_IL_CVR_SBNF_LINK.get(currRowIndex) ;
		
		try{
			Double doubleBSBL_PER_DAY_LC_LIMIT = (Double)value; 
		PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_PER_DAY_LC_LIMIT(doubleBSBL_PER_DAY_LC_LIMIT);

		String BSBL_LIMIT_TYP = PM_IL_CVR_SBNF_LINK_BEAN.getBSBL_LIMIT_TYP();

		Double CBL_PER_DAY_LC_LIMIT = getTempBean().getCBL_PER_DAY_LC_LIMIT();
//		CBL_PER_DAY_LC_LIMIT = "".equals(CBL_PER_DAY_LC_LIMIT)?"0":CBL_PER_DAY_LC_LIMIT;
		if("D".equalsIgnoreCase(getTempBean().getCBL_LIMIT_TYP())){
			if(doubleBSBL_PER_DAY_LC_LIMIT < 0 || doubleBSBL_PER_DAY_LC_LIMIT > Double.valueOf(CBL_PER_DAY_LC_LIMIT )) {
				//getErrorMap().put("current", Messages.getMessage("com.iii.pel.errorUtil.PELErrorMessages","92013").getSummary());
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "92013"));
			} 
		}
		if(PM_IL_CVR_SBNF_LINK_BEAN.getBSBL_LIMIT_DAYS()!=null)
		{
			Double BSBL_LIMIT_DAYS = PM_IL_CVR_SBNF_LINK_BEAN.getBSBL_LIMIT_DAYS();
			if("D".equalsIgnoreCase(BSBL_LIMIT_TYP)) {
				PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_LC_AMT(BSBL_LIMIT_DAYS * doubleBSBL_PER_DAY_LC_LIMIT); 
				/*if((BSBL_LIMIT_DAYS * doubleBSBL_PER_DAY_LC_LIMIT) > CBL_PER_DAY_LC_LIMIT)
				{
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "92013"));
				}*/
			}
		}
		}
		catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void whenValidateBSBL_LIMIT_LC_AMT(FacesContext context, UIComponent comp , Object value)throws ValidatorException {
		
		try {
			int currRowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();
		/*UIInput component = (UIInput) event.getComponent().getParent();
		String BSBL_LIMIT_LC_AMT = (String) component.getSubmittedValue();
		BSBL_LIMIT_LC_AMT = "".equals(BSBL_LIMIT_LC_AMT)?"0":BSBL_LIMIT_LC_AMT;
		*/
		Double doubleBSBL_LIMIT_LC_AMT = (Double) value;
		
	//	PM_IL_CVR_SBNF_LINK gridValueBean = listdataTablePM_IL_CVR_SBNF_LINK.get(currRowIndex) ;
		PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_LC_AMT(doubleBSBL_LIMIT_LC_AMT);
		
		Double coverLCAmount = getTempBean().getCBL_LIMIT_LC_AMT();
		//lastColumnListener();
		if(doubleBSBL_LIMIT_LC_AMT > coverLCAmount || doubleBSBL_LIMIT_LC_AMT < 0 ) {
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_LC_AMT(coverLCAmount);
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_DAYS(getTempBean().getCBL_LIMIT_DAYS());
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_PER_DAY_LC_LIMIT(getTempBean().getCBL_PER_DAY_LC_LIMIT());
			
			FacesMessage error = Messages.getMessage("com.iii.pel.errorUtil.PELErrorMessages", "92013");
			throw new ValidatorException(error);
		}
		//TODO uncomment this part once flow is done
		/*Double BSBL_LIMIT_DAYS = gridValueBean.getBSBL_LIMIT_DAYS();

		Double BSBL_PER_DAY_LC_LIMIT = gridValueBean.getBSBL_PER_DAY_LC_LIMIT();

		Double COVER_LIMIT_DAYS = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_LIMIT_DAYS();
		
		COVER_LIMIT_DAYS = COVER_LIMIT_DAYS == null ? 0:COVER_LIMIT_DAYS;
		
		if(BSBL_LIMIT_DAYS < 0 || BSBL_LIMIT_DAYS > Double.valueOf(COVER_LIMIT_DAYS)) {
			getErrorMap().put("current", Messages.getMessage("com.iii.pel.errorUtil.PELErrorMessages","91997").getSummary());
		} else {
			throwMessage("");
		}

		String BSBL_LIMIT_TYP = (String) gridValueBean.getBSBL_LIMIT_TYP();

		if("D".equalsIgnoreCase(BSBL_LIMIT_TYP)) {
			gridValueBean.setBSBL_LIMIT_LC_AMT(BSBL_LIMIT_DAYS* Double.valueOf(BSBL_PER_DAY_LC_LIMIT)); 
		}*/
	}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void whenValidateBSBL_LIMIT_DAYS(FacesContext context, UIComponent comp , Object value)throws ValidatorException {
		/*UIInput component = (UIInput) event.getComponent().getParent();
		String BSBL_LIMIT_DAYS = (String) component.getSubmittedValue();
		BSBL_LIMIT_DAYS = "".equals(BSBL_LIMIT_DAYS)?"0":BSBL_LIMIT_DAYS;*/
		
		try {
			Double doubleBSBL_LIMIT_DAYS = (Double) value;

		//int currRowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();
		//PM_IL_CVR_SBNF_LINK gridValueBean = listdataTablePM_IL_CVR_SBNF_LINK.get(currRowIndex) ;
		PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_DAYS(doubleBSBL_LIMIT_DAYS);
		
		

		String BSBL_LIMIT_TYP = PM_IL_CVR_SBNF_LINK_BEAN.getBSBL_LIMIT_TYP();

		Double COVER_LIMIT_DAYS = (Double) getTempBean().getCBL_LIMIT_DAYS();
		COVER_LIMIT_DAYS = COVER_LIMIT_DAYS == null?0.0:COVER_LIMIT_DAYS;
		Double BSBL_PER_DAY_LC_LIMIT = PM_IL_CVR_SBNF_LINK_BEAN.getBSBL_PER_DAY_LC_LIMIT();
		
		if("D".equalsIgnoreCase(BSBL_LIMIT_TYP)) {
			System.out.println("BSBL_LIMIT_TYP"+BSBL_LIMIT_TYP);
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_LC_AMT(doubleBSBL_LIMIT_DAYS * BSBL_PER_DAY_LC_LIMIT); 
			if((doubleBSBL_LIMIT_DAYS * BSBL_PER_DAY_LC_LIMIT) > getTempBean().getCBL_LIMIT_LC_AMT())
			{
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "92013"));
			}
		}
		
		if("D".equalsIgnoreCase(getTempBean().getCBL_LIMIT_TYP()))
		{
			if(doubleBSBL_LIMIT_DAYS < 0 || doubleBSBL_LIMIT_DAYS > Double.valueOf(COVER_LIMIT_DAYS)) {
				
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91997"));
			} else {
				if(getErrorMap().isEmpty()){
					//lastColumnListener();
				}
			}
		}
		
	}
		catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}	
		
	}

	public void whenListChangedBSBL_LIMIT_TYP(ActionEvent event) {
		CommonUtils.clearMaps(this);
		boolean updateAllowed = false;
		UIInput component = (UIInput) event.getComponent().getParent();
		String BSBL_LIMIT_TYP = (String) component.getSubmittedValue();

		//int currRowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowIndex();
		//PM_IL_CVR_SBNF_LINK gridValueBean = listdataTablePM_IL_CVR_SBNF_LINK.get(currRowIndex) ;
		PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_TYP(BSBL_LIMIT_TYP);

		if(!"".equals(PM_IL_CVR_SBNF_LINK_BEAN.getROWID()) && PM_IL_CVR_SBNF_LINK_BEAN.getROWID() != null ) {
			updateAllowed = true;
		}
		
		if("D".equalsIgnoreCase(PM_IL_CVR_SBNF_LINK_BEAN.getBSBL_LIMIT_TYP())) {

			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_PER_DAY_LC_LIMIT_DISABLE(false);
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_DAYS_DISABLE(false);
			
			if(updateAllowed) {
				PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_PER_DAY_LC_LIMIT_DISABLE(false);
				PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_DAYS_DISABLE(false);
			}
			
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_PER_DAY_LC_LIMIT_REQUIRED(true);
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_DAYS_REQUIRED(true);
			
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_LC_AMT_DISABLE(true);
			
			if(updateAllowed) {
				PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_LC_AMT_DISABLE(true);
			}
			
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_LC_AMT_REQUIRED(false);
			
		} else {
			
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_PER_DAY_LC_LIMIT_DISABLE(true);
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_DAYS_DISABLE(true);
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_PER_DAY_LC_LIMIT(null);
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_DAYS(null);
			getCOMP_BSBL_PER_DAY_LC_LIMIT().setSubmittedValue(null);
			getCOMP_BSBL_LIMIT_DAYS().setSubmittedValue(null);
			
			if(updateAllowed) {
				PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_PER_DAY_LC_LIMIT_DISABLE(true);
				PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_DAYS_DISABLE(true);
			}
			
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_PER_DAY_LC_LIMIT_REQUIRED(false);
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_DAYS_REQUIRED(false);
			
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_LC_AMT_DISABLE(false);
			
			if(updateAllowed) {
				PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_LC_AMT_DISABLE(false);
			}
			PM_IL_CVR_SBNF_LINK_BEAN.setBSBL_LIMIT_LC_AMT_REQUIRED(true);
		}
	}


	private String P_VAL_CODES(String BSBL_SBNF_CODE) {
		System.out.println("PM_IL_CVR_SBNF_LINK_ACTION.P_VAL_CODES().....");		
//		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
//		OracleParameter param1 = new OracleParameter("in1","STRING","IN","'IL_SBNF_CODE'" );
//		OracleParameter param2 = new OracleParameter("in2","STRING","IN",BSBL_SBNF_CODE);
//		OracleParameter param3 = new OracleParameter("in3","STRING","IN OUT",(String)getCOMP_UI_M_BSBL_BNF_DESC().getSubmittedValue());
//		OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
//		OracleParameter param5 = new OracleParameter("in5","STRING","IN","'E'");
//		OracleParameter param6 = new OracleParameter("in6","STRING","IN",null);
//		paramList.add(param1);
//		paramList.add(param2);
//		paramList.add(param3);
//		paramList.add(param4);
//		paramList.add(param5);
//		paramList.add(param6);
//		OracleProcedureHandler procHandler = new OracleProcedureHandler();
//		List<OracleParameter> list = null;
//		Connection conn = null;
//		try {
//		conn = getConnection();
//		list = procHandler.execute(paramList, getConnection(), "P_VAL_CODES");
//		getCOMP_UI_M_BSBL_BNF_DESC().setSubmittedValue(list.get(0).getValue());
//		throwMessage("");
//		} catch (Exception e) {
//		String errorMessage = e.getLocalizedMessage();
//		throwMessage(errorMessage);
//		}

		String UI_M_BSBL_BNF_DESC = "";

		try{
			CallableStatement cs = CommonUtils.getConnection().prepareCall("{call P_VAL_CODES(?,?,?,?,?,?)}");
			cs.setString(1, "IL_SBNF_CODE");
			cs.setString(2, BSBL_SBNF_CODE);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.setString(4, "N");
			cs.setString(5, "N");
			cs.setNull(6, java.sql.Types.NULL);
			boolean flag = cs.execute();
			UI_M_BSBL_BNF_DESC = cs.getString(3);
			System.out.println("PM_IL_CVR_SBNF_LINK_ACTION.P_VAL_CODES() desc: "+UI_M_BSBL_BNF_DESC);
			getCOMP_UI_M_BSBL_BNF_DESC().setSubmittedValue(UI_M_BSBL_BNF_DESC);
			//throwMessage("");
		} catch(Exception e) {
//			e.printStackTrace();
			String errorMessage = e.getLocalizedMessage();
			throwMessage(errorMessage);
		}
		return UI_M_BSBL_BNF_DESC;
	}

	void throwMessage(String error) throws ValidatorException {
		getErrorMap().put("current",error);
	}

	public Connection getConnection() throws Exception{
		return CommonUtils.getConnection();
	}

	public List lovBSBL_SBNF_CODE(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String query = "";
		ResultSet rs = null;
		if(obj.toString().equals("*")){
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_SBNF_CODE' AND ROWNUM < 25";
		}else{
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_CODE LIKE '%"+obj+"%' AND PC_TYPE = 'IL_SBNF_CODE' AND ROWNUM < 25";		
		}
		System.out.println("PM_IL_CVR_SBNF_LINK_ACTION.lovBSBL_SBNF_CODE() query: "+query);
		try {
			rs = getHandler().executeSelectStatement(query, getConnection());
			rs.setFetchSize(25);
			while (rs.next()) {
				LovBean bean = new LovBean();
				bean.setCode(rs.getString("PC_CODE"));
				bean.setName(rs.getString("PC_DESC"));
				suggesionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggesionList;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}
	
	
	/*public String deductableButtonAction()
	{
		PM_IL_BNF_DEDB_LINK_ACTION pm_il_bnf_dedb_link_action = new PM_IL_BNF_DEDB_LINK_ACTION();
		HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("PILM203_PM_IL_BNF_DEDB_LINK_ACTION",pm_il_bnf_dedb_link_action);
		
		//PM_IL_BNF_DEDB_LINK_ACTION pm_il_bnf_dedb_link_action=(PM_IL_BNF_DEDB_LINK_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_BNF_DEDB_LINK_ACTION");
		int rowIndex = getDataTablePM_IL_CVR_SBNF_LINK().getRowCount();
		int count = 0;
		String code = null;
		for(int index = 0; index<rowIndex; index++)
		{
			PM_IL_CVR_SBNF_LINK pm_il_cvr_sbnf_link = (PM_IL_CVR_SBNF_LINK)getListdataTablePM_IL_CVR_SBNF_LINK().get(index);
			if(pm_il_cvr_sbnf_link.isCHECK_BOX())
			{
				count = count+1;
				System.out.println("SUB CODe::::::::"+pm_il_cvr_sbnf_link.getBSBL_SBNF_CODE());
				code = pm_il_cvr_sbnf_link.getBSBL_SBNF_CODE();
				pm_il_bnf_dedb_link_action.setTempBean(pm_il_cvr_sbnf_link);
				//pm_il_cvr_sbnf_link.setSelectedSubBenefitCode(pm_il_cvr_sbnf_link.getBSBL_SBNF_CODE());
			}
		}
		if(count>0)
		{
			PM_IL_CVR_SBNF_LINK_ACTION sbnfLinkAction = (PM_IL_CVR_SBNF_LINK_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_CVR_SBNF_LINK_ACTION");
			sbnfLinkAction.nextBlock_PM_IL_BNF_DEDB_LINK(code);
			return "DEDUCTABLES";
		}else{
			getErrorMap().put("current", "Please select only one check box");
			getErrorMap().put("somekey", "Please select only one check box");
			return "";
		}
	}*/
	
	public String goToParentBlock(){
		
		return "CVR_BNF";
	}

	public PM_IL_CVR_BNF_LINK getTempBean() {
		return tempBean;
	}

	public void setTempBean(PM_IL_CVR_BNF_LINK tempBean) {
		this.tempBean = tempBean;
	}
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = dataTablePM_IL_CVR_SBNF_LINK.getRowIndex();

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
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
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

	public String getFilterByBSBL_SBNF_CODE() {
		return filterByBSBL_SBNF_CODE;
	}

	public void setFilterByBSBL_SBNF_CODE(String filterByBSBL_SBNF_CODE) {
		this.filterByBSBL_SBNF_CODE = filterByBSBL_SBNF_CODE;
	}

	public String getFilterByBSBL_LIMIT_TYP() {
		return filterByBSBL_LIMIT_TYP;
	}

	public void setFilterByBSBL_LIMIT_TYP(String filterByBSBL_LIMIT_TYP) {
		this.filterByBSBL_LIMIT_TYP = filterByBSBL_LIMIT_TYP;
	}
}