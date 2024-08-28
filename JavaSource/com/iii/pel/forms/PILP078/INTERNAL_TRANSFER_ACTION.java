package com.iii.pel.forms.PILP078;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlSimpleTogglePanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD;
import com.iii.pel.forms.PILT013.PILT013_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class INTERNAL_TRANSFER_ACTION extends CommonReportAction {
	
	public PILP078_COMPOSITE_ACTION compositeAction;
	
	private INTERNAL_TRANSFER_HELPER helper;

	private PT_IL_ADJ_HEAD  PT_IL_ADJ_HEAD_BEAN;
	
	private PT_IL_ADJ_PROP_DEP PT_IL_ADJ_PROP_DEP_BEAN;
	
	private  PT_IL_ADJ_PREM_COLL  PT_IL_ADJ_PREM_COLL_BEAN;
	
	private PT_IL_ADJ_LOAN PT_IL_ADJ_LOAN_BEAN;
	
	private HtmlSimpleTogglePanel COMP_DEP_COLL;

	private INTERNAL_TRANSFER_DELEGATE delegate;
	
	private UIData dataTable;
	
	private UIData dataTable1;
	
	private UIData dataTable2;
	
	private UIData dataTable3;
	
	private List<PT_IL_ADJ_HEAD> dataList_PT_IL_ADJ_HEAD = new ArrayList<PT_IL_ADJ_HEAD>();
	
	private List<PT_IL_ADJ_PROP_DEP> dataList_PT_IL_ADJ_PROP_DEP = new ArrayList<PT_IL_ADJ_PROP_DEP>();
	
	private List<PT_IL_ADJ_PREM_COLL> dataList_PT_IL_ADJ_PREM_COLL = new ArrayList<PT_IL_ADJ_PREM_COLL>();
	
	private List<PT_IL_ADJ_LOAN> dataList_PT_IL_ADJ_LOAN = new ArrayList<PT_IL_ADJ_LOAN>();
	
	private List<SelectItem> listAH_REF_TYPE = new ArrayList<SelectItem>();
	
	private List<SelectItem> listAPD_STATUS = new ArrayList<SelectItem>();
	
	private List<SelectItem> listAPC_STATUS = new ArrayList<SelectItem>();
	
	private List<SelectItem> listAL_STATUS = new ArrayList<SelectItem>();
	
	public List<PT_IL_ADJ_LOAN> getDataList_PT_IL_ADJ_LOAN() {
		return dataList_PT_IL_ADJ_LOAN;
	}
	public void setDataList_PT_IL_ADJ_LOAN(
			List<PT_IL_ADJ_LOAN> dataList_PT_IL_ADJ_LOAN) {
		this.dataList_PT_IL_ADJ_LOAN = dataList_PT_IL_ADJ_LOAN;
	}
	public UIData getDataTable3() {
		return dataTable3;
	}
	public void setDataTable3(UIData dataTable3) {
		this.dataTable3 = dataTable3;
	}
	public List<SelectItem> getListAL_STATUS() {
		if (listAL_STATUS.size() == 0) {
			listAL_STATUS.clear();
		    try {
		    	listAL_STATUS = new ArrayList<SelectItem>();
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
		return listAL_STATUS;
	}
	public void setListAL_STATUS(List<SelectItem> listAL_STATUS) {
		this.listAL_STATUS = listAL_STATUS;
	}
	public UIData getDataTable2() {
		return dataTable2;
	}
	public void setDataTable2(UIData dataTable2) {
		this.dataTable2 = dataTable2;
	}
	public List<PT_IL_ADJ_PREM_COLL> getDataList_PT_IL_ADJ_PREM_COLL() {
		return dataList_PT_IL_ADJ_PREM_COLL;
	}
	public void setDataList_PT_IL_ADJ_PREM_COLL(
			List<PT_IL_ADJ_PREM_COLL> dataList_PT_IL_ADJ_PREM_COLL) {
		this.dataList_PT_IL_ADJ_PREM_COLL = dataList_PT_IL_ADJ_PREM_COLL;
	}
	public List<SelectItem> getListAPC_STATUS() {
		if (listAPC_STATUS.size() == 0) {
			listAPC_STATUS.clear();
		    try {
		    	listAPC_STATUS = new ArrayList<SelectItem>();
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
		return listAPC_STATUS;
	}
	public void setListAPC_STATUS(List<SelectItem> listAPC_STATUS) {
		this.listAPC_STATUS = listAPC_STATUS;
	}
	
	public UIData getDataTable1() {
		return dataTable1;
	}
	public void setDataTable1(UIData dataTable1) {
		this.dataTable1 = dataTable1;
	}
	public List<SelectItem> getListAPD_STATUS() {
		if (listAPD_STATUS.size() == 0) {
			listAPD_STATUS.clear();
		    try {
		    	listAPD_STATUS = new ArrayList<SelectItem>();
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
		return listAPD_STATUS;
	}
	public void setListAPD_STATUS(List<SelectItem> listAPD_STATUS) {
		this.listAPD_STATUS = listAPD_STATUS;
	}
	public List<SelectItem> getListAH_REF_TYPE() {
		if (listAH_REF_TYPE.size() == 0) {
			listAH_REF_TYPE.clear();
		    try {
		    	listAH_REF_TYPE = new ArrayList<SelectItem>();
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
		return listAH_REF_TYPE;
	}
	public void setListAH_REF_TYPE(List<SelectItem> listAH_REF_TYPE) {
		this.listAH_REF_TYPE = listAH_REF_TYPE;
	}
	
	public List<PT_IL_ADJ_PROP_DEP> getDataList_PT_IL_ADJ_PROP_DEP() {
		return dataList_PT_IL_ADJ_PROP_DEP;
	}
	public void setDataList_PT_IL_ADJ_PROP_DEP(
			List<PT_IL_ADJ_PROP_DEP> dataList_PT_IL_ADJ_PROP_DEP) {
		this.dataList_PT_IL_ADJ_PROP_DEP = dataList_PT_IL_ADJ_PROP_DEP;
	}

	private HtmlSelectOneMenu COMP_AH_REF_TYPE;
	
	public HtmlSimpleTogglePanel COMP_POL_PREM;
	
	public HtmlSimpleTogglePanel COMP_POL_LOAN;

	public HtmlSimpleTogglePanel COMP_HEAD_PANEL;
	
	public HtmlSimpleTogglePanel getCOMP_HEAD_PANEL() {
		return COMP_HEAD_PANEL;
	}
	public void setCOMP_HEAD_PANEL(HtmlSimpleTogglePanel cOMP_HEAD_PANEL) {
		COMP_HEAD_PANEL = cOMP_HEAD_PANEL;
	}
	public HtmlSimpleTogglePanel getCOMP_POL_LOAN() {
		return COMP_POL_LOAN;
	}
	public void setCOMP_POL_LOAN(HtmlSimpleTogglePanel cOMP_POL_LOAN) {
		COMP_POL_LOAN = cOMP_POL_LOAN;
	}
	public HtmlSimpleTogglePanel getCOMP_POL_PREM() {
		return COMP_POL_PREM;
	}
	public void setCOMP_POL_PREM(HtmlSimpleTogglePanel cOMP_POL_PREM) {
		COMP_POL_PREM = cOMP_POL_PREM;
	}
	public HtmlSelectOneMenu getCOMP_AH_REF_TYPE() {
		return COMP_AH_REF_TYPE;
	}
	public void setCOMP_AH_REF_TYPE(HtmlSelectOneMenu cOMP_AH_REF_TYPE) {
		COMP_AH_REF_TYPE = cOMP_AH_REF_TYPE;
	}
	
	public HtmlSimpleTogglePanel getCOMP_DEP_COLL() {
		return COMP_DEP_COLL;
	}
	public void setCOMP_DEP_COLL(HtmlSimpleTogglePanel cOMP_DEP_COLL) {
		COMP_DEP_COLL = cOMP_DEP_COLL;
	}

	public INTERNAL_TRANSFER_ACTION()
	{
		PT_IL_ADJ_HEAD_BEAN=new PT_IL_ADJ_HEAD();
		PT_IL_ADJ_PROP_DEP_BEAN=new PT_IL_ADJ_PROP_DEP();
		PT_IL_ADJ_LOAN_BEAN=new PT_IL_ADJ_LOAN();
		PT_IL_ADJ_PREM_COLL_BEAN=new PT_IL_ADJ_PREM_COLL();
		helper=new INTERNAL_TRANSFER_HELPER();
		delegate=new INTERNAL_TRANSFER_DELEGATE();
		prepareDropDowns();
		setBlockFlag(true);
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public List<PT_IL_ADJ_HEAD> getDataList_PT_IL_ADJ_HEAD() {
		return dataList_PT_IL_ADJ_HEAD;
	}
	public void setDataList_PT_IL_ADJ_HEAD(
			List<PT_IL_ADJ_HEAD> dataList_PT_IL_ADJ_HEAD) {
		this.dataList_PT_IL_ADJ_HEAD = dataList_PT_IL_ADJ_HEAD;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public PT_IL_ADJ_HEAD getPT_IL_ADJ_HEAD_BEAN() {
		return PT_IL_ADJ_HEAD_BEAN;
	}
	public void setPT_IL_ADJ_HEAD_BEAN(PT_IL_ADJ_HEAD pT_IL_ADJ_HEAD_BEAN) {
		PT_IL_ADJ_HEAD_BEAN = pT_IL_ADJ_HEAD_BEAN;
	}
	public PT_IL_ADJ_PROP_DEP getPT_IL_ADJ_PROP_DEP_BEAN() {
		return PT_IL_ADJ_PROP_DEP_BEAN;
	}
	public void setPT_IL_ADJ_PROP_DEP_BEAN(
			PT_IL_ADJ_PROP_DEP pT_IL_ADJ_PROP_DEP_BEAN) {
		PT_IL_ADJ_PROP_DEP_BEAN = pT_IL_ADJ_PROP_DEP_BEAN;
	}
	public PT_IL_ADJ_PREM_COLL getPT_IL_ADJ_PREM_COLL_BEAN() {
		return PT_IL_ADJ_PREM_COLL_BEAN;
	}
	public void setPT_IL_ADJ_PREM_COLL_BEAN(
			PT_IL_ADJ_PREM_COLL pT_IL_ADJ_PREM_COLL_BEAN) {
		PT_IL_ADJ_PREM_COLL_BEAN = pT_IL_ADJ_PREM_COLL_BEAN;
	}
	public PT_IL_ADJ_LOAN getPT_IL_ADJ_LOAN_BEAN() {
		return PT_IL_ADJ_LOAN_BEAN;
	}
	public void setPT_IL_ADJ_LOAN_BEAN(PT_IL_ADJ_LOAN pT_IL_ADJ_LOAN_BEAN) {
		PT_IL_ADJ_LOAN_BEAN = pT_IL_ADJ_LOAN_BEAN;
	}
	public INTERNAL_TRANSFER_DELEGATE getDelegate() {
		return delegate;
	}

	public void setDelegate(INTERNAL_TRANSFER_DELEGATE delegate) {
		this.delegate = delegate;
	}

	public INTERNAL_TRANSFER_HELPER getHelper() {
		return helper;
	}

	public void setHelper(INTERNAL_TRANSFER_HELPER helper) {
		this.helper = helper;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			COMP_HEAD_PANEL.setOpened(true);
			COMP_DEP_COLL.setOpened(true);
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				getErrorMap().clear();
				getWarningMap().clear();
				helper.executeQuery(compositeAction);
				helper.executeQuery1(compositeAction);
				helper.executeQuery2(compositeAction);
				helper.executeQuery3(compositeAction);
				COMP_UI_PROP_DEPOSIT.setDisabled(true);
				COMP_UI_POL_PREM.setDisabled(true);
				COMP_UI_POL_LOAN.setDisabled(true);
				COMP_UI_POL_TOTAL.setDisabled(true);
				totalSumValue();
				resetAllComponent();
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest) context
						.getExternalContext().getRequest();
				HttpSession session = request.getSession();
				System.out.println("SMV_APPV_FLAG  :"+session.getAttribute("SMV_APPV_FLAG").toString());
				String SMV_APPV_FLAG=session.getAttribute("SMV_APPV_FLAG").toString();
				if(SMV_APPV_FLAG.equalsIgnoreCase("A")){
					disableAllComponent(true);
				}else{
					disableAllComponent(false);
				}
				setBlockFlag(false);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}



	public void saveRecord()throws Exception {

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			totalSumValue();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	public void setAPD_STATUS_Editable(ActionEvent event) {
		 
		CommonUtils.clearMaps(this);
		String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable1.getRowIndex();
		PT_IL_ADJ_PROP_DEP_BEAN=(PT_IL_ADJ_PROP_DEP)dataList_PT_IL_ADJ_PROP_DEP.get(currentIndex);
		PT_IL_ADJ_PROP_DEP_BEAN.setAPD_STATUS(status);
		/*System.out.println("PT_IL_ADJ_PROP_DEP_BEAN.APD_FC_AMOUNT       "+PT_IL_ADJ_PROP_DEP_BEAN.getAPD_FC_AMOUNT());
		if("Y".equalsIgnoreCase(PT_IL_ADJ_PROP_DEP_BEAN.getAPD_STATUS()))
				{
					Double FC_AMT=PT_IL_ADJ_PROP_DEP_BEAN.getAPD_FC_AMOUNT();
					PT_IL_ADJ_HEAD_BEAN.setUI_CURR_TOT_VAL(CommonUtils.nvl(PT_IL_ADJ_HEAD_BEAN.getUI_CURR_TOT_VAL(),0)+FC_AMT);
					System.out.println("CURR_TOT_VAL  :"+PT_IL_ADJ_HEAD_BEAN.getUI_CURR_TOT_VAL());
				}
		else 		if("N".equalsIgnoreCase(PT_IL_ADJ_PROP_DEP_BEAN.getAPD_STATUS()))
		{
			System.out.println("oldValue      "+oldValue);
			if(oldValue != null && oldValue.equalsIgnoreCase("N"))
			{
				Double FC_AMT=PT_IL_ADJ_PROP_DEP_BEAN.getAPD_FC_AMOUNT();
				PT_IL_ADJ_HEAD_BEAN.setUI_CURR_TOT_VAL(CommonUtils.nvl(PT_IL_ADJ_HEAD_BEAN.getUI_CURR_TOT_VAL(),0)-FC_AMT);
				System.out.println("CURR_TOT_VAL  :"+PT_IL_ADJ_HEAD_BEAN.getUI_CURR_TOT_VAL());	
			}
			
		}*/
		
	/*	PT_IL_ADJ_PROP_DEP_BEAN.setUI_CURR_TOT_VAL(PT_IL_ADJ_PROP_DEP_BEAN.getUI_CURR_TOT_VAL()+);*/
		COMP_APD_STATUS.resetValue();
		//COMP_AH_REF_TYPE.resetValue();
	}
	
	public void setAPC_STATUS_Editable(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable2.getRowIndex();
		PT_IL_ADJ_PREM_COLL_BEAN=(PT_IL_ADJ_PREM_COLL)dataList_PT_IL_ADJ_PREM_COLL.get(currentIndex);
		PT_IL_ADJ_PREM_COLL_BEAN.setAPC_STATUS(status);
		COMP_APC_STATUS.resetValue();
		//COMP_AH_REF_TYPE.resetValue();
	}
	public void setAL_STATUS_Editable(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable3.getRowIndex();
		PT_IL_ADJ_LOAN_BEAN=(PT_IL_ADJ_LOAN)dataList_PT_IL_ADJ_LOAN.get(currentIndex);
		PT_IL_ADJ_LOAN_BEAN.setAL_STATUS(status);
		COMP_AL_STATUS.resetValue();
		//COMP_AH_REF_TYPE.resetValue();
	}

	 /*Head Table fields*/
	 public HtmlOutputLabel COMP_AH_REF_TYPE_LABEL;
	 
	 public HtmlOutputLabel COMP_AH_REF_NO_LABEL;
	 
	 public HtmlInputText COMP_AH_REF_NO;
	 
	 public HtmlOutputLabel COMP_AH_CUST_CODE_LABEL;
	 
	 public HtmlInputText COMP_AH_CUST_CODE;
	 
	 public HtmlOutputLabel COMP_UI_M_CUST_DESC_LABEL;
	 
	 public HtmlInputText COMP_UI_M_CUST_DESC;
	 
	public HtmlOutputLabel getCOMP_AH_LC_AMOUNT_LABEL() {
		return COMP_AH_LC_AMOUNT_LABEL;
	}
	public void setCOMP_AH_LC_AMOUNT_LABEL(HtmlOutputLabel cOMP_AH_LC_AMOUNT_LABEL) {
		COMP_AH_LC_AMOUNT_LABEL = cOMP_AH_LC_AMOUNT_LABEL;
	}
	public HtmlInputText getCOMP_AH_LC_AMOUNT() {
		return COMP_AH_LC_AMOUNT;
	}
	public void setCOMP_AH_LC_AMOUNT(HtmlInputText cOMP_AH_LC_AMOUNT) {
		COMP_AH_LC_AMOUNT = cOMP_AH_LC_AMOUNT;
	}
	public HtmlOutputLabel COMP_AH_FC_AMOUNT_LABEL;
	 
	 public HtmlInputText COMP_AH_FC_AMOUNT;

	public HtmlOutputLabel getCOMP_AH_FC_AMOUNT_LABEL() {
		return COMP_AH_FC_AMOUNT_LABEL;
	}
	public void setCOMP_AH_FC_AMOUNT_LABEL(HtmlOutputLabel cOMP_AH_FC_AMOUNT_LABEL) {
		COMP_AH_FC_AMOUNT_LABEL = cOMP_AH_FC_AMOUNT_LABEL;
	}
	public HtmlInputText getCOMP_AH_FC_AMOUNT() {
		return COMP_AH_FC_AMOUNT;
	}
	public void setCOMP_AH_FC_AMOUNT(HtmlInputText cOMP_AH_FC_AMOUNT) {
		COMP_AH_FC_AMOUNT = cOMP_AH_FC_AMOUNT;
	}

	public HtmlOutputLabel COMP_AH_LC_AMOUNT_LABEL;
	 
	 public HtmlInputText COMP_AH_LC_AMOUNT;
	 
     public HtmlOutputLabel getCOMP_UI_M_CUST_DESC_LABEL() {
		return COMP_UI_M_CUST_DESC_LABEL;
	}
	public void setCOMP_UI_M_CUST_DESC_LABEL(
			HtmlOutputLabel cOMP_UI_M_CUST_DESC_LABEL) {
		COMP_UI_M_CUST_DESC_LABEL = cOMP_UI_M_CUST_DESC_LABEL;
	}
	public HtmlInputText getCOMP_UI_M_CUST_DESC() {
		return COMP_UI_M_CUST_DESC;
	}
	public void setCOMP_UI_M_CUST_DESC(HtmlInputText cOMP_UI_M_CUST_DESC) {
		COMP_UI_M_CUST_DESC = cOMP_UI_M_CUST_DESC;
	}

	public HtmlCommandButton COMP_UI_M_POL_HEAD_POST;

	public HtmlCommandButton getCOMP_UI_M_POL_HEAD_POST() {
		return COMP_UI_M_POL_HEAD_POST;
	}
	public void setCOMP_UI_M_POL_HEAD_POST(HtmlCommandButton cOMP_UI_M_POL_HEAD_POST) {
		COMP_UI_M_POL_HEAD_POST = cOMP_UI_M_POL_HEAD_POST;
	}
	public HtmlOutputLabel getCOMP_AH_CUST_CODE_LABEL() {
		return COMP_AH_CUST_CODE_LABEL;
	}
	public void setCOMP_AH_CUST_CODE_LABEL(HtmlOutputLabel cOMP_AH_CUST_CODE_LABEL) {
		COMP_AH_CUST_CODE_LABEL = cOMP_AH_CUST_CODE_LABEL;
	}
	public HtmlInputText getCOMP_AH_CUST_CODE() {
		return COMP_AH_CUST_CODE;
	}
	public void setCOMP_AH_CUST_CODE(HtmlInputText cOMP_AH_CUST_CODE) {
		COMP_AH_CUST_CODE = cOMP_AH_CUST_CODE;
	}
	public HtmlOutputLabel getCOMP_AH_REF_NO_LABEL() {
		return COMP_AH_REF_NO_LABEL;
	}
	public void setCOMP_AH_REF_NO_LABEL(HtmlOutputLabel cOMP_AH_REF_NO_LABEL) {
		COMP_AH_REF_NO_LABEL = cOMP_AH_REF_NO_LABEL;
	}
	public HtmlInputText getCOMP_AH_REF_NO() {
		return COMP_AH_REF_NO;
	}
	public void setCOMP_AH_REF_NO(HtmlInputText cOMP_AH_REF_NO) {
		COMP_AH_REF_NO = cOMP_AH_REF_NO;
	}
	public HtmlOutputLabel getCOMP_AH_REF_TYPE_LABEL() {
		return COMP_AH_REF_TYPE_LABEL;
	}
	public void setCOMP_AH_REF_TYPE_LABEL(HtmlOutputLabel cOMP_AH_REF_TYPE_LABEL) {
		COMP_AH_REF_TYPE_LABEL = cOMP_AH_REF_TYPE_LABEL;
	}

	public void postRecord() {
		String message = null;
		try {
			if (PT_IL_ADJ_HEAD_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PT_IL_ADJ_HEAD_BEAN,CommonUtils.getConnection());
				//CommonUtils.getConnection().commit();
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
				/*dataList_PT_IL_ADJ_HEAD.add(PT_IL_ADJ_HEAD_BEAN);*/
						
			/*	
				Iterator<PT_IL_ADJ_HEAD> PT_IL_ADJ_HEAD = dataList_PT_IL_ADJ_HEAD.iterator();
				PT_IL_ADJ_HEAD PT_IL_ADJ_HEAD_bean = null;
				while (PT_IL_ADJ_HEAD.hasNext()) {
					PT_IL_ADJ_HEAD_bean = (PT_IL_ADJ_HEAD)dataList_PT_IL_ADJ_HEAD.get(0);
					PT_IL_ADJ_HEAD.next().setAH_FC_AMOUNT(PT_IL_ADJ_HEAD_BEAN.getUI_POL_TOTAL());
					//PT_IL_ADJ_HEAD_bean.setAH_FC_AMOUNT(PT_IL_ADJ_HEAD_BEAN.getUI_POL_TOTAL());
					System.out.println("value  :"+PT_IL_ADJ_HEAD_bean.
							getAH_FC_AMOUNT());
				}
				if(PT_IL_ADJ_HEAD_bean != null)
				{
					dataList_PT_IL_ADJ_HEAD.clear();
					dataList_PT_IL_ADJ_HEAD.add(PT_IL_ADJ_HEAD_bean);
				}*/
			}/* else if (PT_IL_ADJ_HEAD_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				//helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PT_IL_ADJ_HEAD_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
			}*/

			PT_IL_ADJ_HEAD_BEAN.setRowSelected(true);
		/*} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}*/
			CommonUtils.getConnection().commit();
			totalSumValue();
			//helper.executeQuery(compositeAction);
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	}
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_ADJ_HEAD_BEAN = (PT_IL_ADJ_HEAD) dataTable.getRowData();
			PT_IL_ADJ_HEAD_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	public void displayRecords1() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow1();
			PT_IL_ADJ_PROP_DEP_BEAN = (PT_IL_ADJ_PROP_DEP) dataTable1.getRowData();
			PT_IL_ADJ_PROP_DEP_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	public void displayRecords2() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow2();
			PT_IL_ADJ_PREM_COLL_BEAN = (PT_IL_ADJ_PREM_COLL) dataTable2.getRowData();
			PT_IL_ADJ_PREM_COLL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	public void displayRecords3() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow3();
			PT_IL_ADJ_LOAN_BEAN = (PT_IL_ADJ_LOAN) dataTable3.getRowData();
			PT_IL_ADJ_LOAN_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	private void resetSelectedRow() {
		Iterator<PT_IL_ADJ_HEAD> PT_IL_ADJ_HEAD = dataList_PT_IL_ADJ_HEAD.iterator();
		while (PT_IL_ADJ_HEAD.hasNext()) {
			PT_IL_ADJ_HEAD.next().setRowSelected(false);
		}
	}
	private void resetSelectedRow1() {
		Iterator<PT_IL_ADJ_PROP_DEP> PT_IL_ADJ_PROP_DEP = dataList_PT_IL_ADJ_PROP_DEP.iterator();
		while (PT_IL_ADJ_PROP_DEP.hasNext()) {
			PT_IL_ADJ_PROP_DEP.next().setRowSelected(false);
		}
	}
	private void resetSelectedRow2() {
		Iterator<PT_IL_ADJ_PREM_COLL> PT_IL_ADJ_PREM_COLL = dataList_PT_IL_ADJ_PREM_COLL.iterator();
		while (PT_IL_ADJ_PREM_COLL.hasNext()) {
			PT_IL_ADJ_PREM_COLL.next().setRowSelected(false);
		}
	}
	private void resetSelectedRow3() {
		Iterator<PT_IL_ADJ_LOAN> PT_IL_ADJ_LOAN = dataList_PT_IL_ADJ_LOAN.iterator();
		while (PT_IL_ADJ_LOAN.hasNext()) {
			PT_IL_ADJ_LOAN.next().setRowSelected(false);
		}
	}
	public void postRecord1() {
		String message = null;
		try {
				if (PT_IL_ADJ_PROP_DEP_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE1(compositeAction);
				new CRUDHandler().executeUpdate(PT_IL_ADJ_PROP_DEP_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
			}
			PT_IL_ADJ_PROP_DEP_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
			totalSumValue();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	}
	
	/*Deposit premium Feilds*/
	public HtmlCommandButton COMP_UI_M_DEP_PREM_POST;
	
	 public HtmlCommandButton getCOMP_UI_M_DEP_PREM_POST() {
		return COMP_UI_M_DEP_PREM_POST;
	}
	public void setCOMP_UI_M_DEP_PREM_POST(HtmlCommandButton cOMP_UI_M_DEP_PREM_POST) {
		COMP_UI_M_DEP_PREM_POST = cOMP_UI_M_DEP_PREM_POST;
	}

	public HtmlInputText COMP_APD_FC_AMOUNT;
	 
	 public HtmlOutputLabel COMP_APD_FC_AMOUNT_LABEL;
	 
	 public HtmlInputText COMP_APD_PROP_NO;
	 
	 public HtmlOutputLabel COMP_APD_PROP_NO_LABEL;
	 
	 public HtmlOutputLabel COMP_APD_STATUS_LABEL;
	 
	 public HtmlSelectOneMenu COMP_APD_STATUS;
	 
	 public HtmlOutputLabel getCOMP_APD_STATUS_LABEL() {
		return COMP_APD_STATUS_LABEL;
	}
	public void setCOMP_APD_STATUS_LABEL(HtmlOutputLabel cOMP_APD_STATUS_LABEL) {
		COMP_APD_STATUS_LABEL = cOMP_APD_STATUS_LABEL;
	}
	public HtmlSelectOneMenu getCOMP_APD_STATUS() {
		return COMP_APD_STATUS;
	}
	public void setCOMP_APD_STATUS(HtmlSelectOneMenu cOMP_APD_STATUS) {
		COMP_APD_STATUS = cOMP_APD_STATUS;
	}
	 
	 public HtmlInputText getCOMP_APD_FC_AMOUNT() {
		return COMP_APD_FC_AMOUNT;
	}
	public void setCOMP_APD_FC_AMOUNT(HtmlInputText cOMP_APD_FC_AMOUNT) {
		COMP_APD_FC_AMOUNT = cOMP_APD_FC_AMOUNT;
	}
	public HtmlOutputLabel getCOMP_APD_FC_AMOUNT_LABEL() {
		return COMP_APD_FC_AMOUNT_LABEL;
	}
	public void setCOMP_APD_FC_AMOUNT_LABEL(HtmlOutputLabel cOMP_APD_FC_AMOUNT_LABEL) {
		COMP_APD_FC_AMOUNT_LABEL = cOMP_APD_FC_AMOUNT_LABEL;
	}
	public HtmlInputText getCOMP_APD_PROP_NO() {
		return COMP_APD_PROP_NO;
	}
	public void setCOMP_APD_PROP_NO(HtmlInputText cOMP_APD_PROP_NO) {
		COMP_APD_PROP_NO = cOMP_APD_PROP_NO;
	}
	public HtmlOutputLabel getCOMP_APD_PROP_NO_LABEL() {
		return COMP_APD_PROP_NO_LABEL;
	}
	public void setCOMP_APD_PROP_NO_LABEL(HtmlOutputLabel cOMP_APD_PROP_NO_LABEL) {
		COMP_APD_PROP_NO_LABEL = cOMP_APD_PROP_NO_LABEL;
	}


	/*Policy Premium Table Feilds*/
	public HtmlOutputLabel COMP_APC_STATUS_LABEL;
	
	public HtmlOutputLabel COMP_APC_FC_INT_LABEL;
	
	public HtmlOutputLabel COMP_APC_FC_PREM_LABEL;
	
	public HtmlOutputLabel COMP_APC_SCHD_PYMT_DT_LABEL;
	
	public HtmlOutputLabel COMP_APC_POL_NO_LABEL;
	
	public HtmlInputText COMP_APC_POL_NO;
	
	public HtmlCalendar COMP_APC_SCHD_PYMT_DT;
	
	public HtmlInputText COMP_APC_FC_PREM;
	
	public HtmlInputText COMP_APC_FC_INT;
	
	public HtmlSelectOneMenu COMP_APC_STATUS;
	
	public HtmlCommandButton COMP_UI_M_POL_PREM_POST;

	public HtmlCommandButton getCOMP_UI_M_POL_PREM_POST() {
		return COMP_UI_M_POL_PREM_POST;
	}
	public void setCOMP_UI_M_POL_PREM_POST(HtmlCommandButton cOMP_UI_M_POL_PREM_POST) {
		COMP_UI_M_POL_PREM_POST = cOMP_UI_M_POL_PREM_POST;
	}
	public HtmlCalendar getCOMP_APC_SCHD_PYMT_DT() {
		return COMP_APC_SCHD_PYMT_DT;
	}
	public void setCOMP_APC_SCHD_PYMT_DT(HtmlCalendar cOMP_APC_SCHD_PYMT_DT) {
		COMP_APC_SCHD_PYMT_DT = cOMP_APC_SCHD_PYMT_DT;
	}
	
	public HtmlInputText getCOMP_APC_POL_NO() {
		return COMP_APC_POL_NO;
	}
	public void setCOMP_APC_POL_NO(HtmlInputText cOMP_APC_POL_NO) {
		COMP_APC_POL_NO = cOMP_APC_POL_NO;
	}
	
	public HtmlInputText getCOMP_APC_FC_PREM() {
		return COMP_APC_FC_PREM;
	}
	public void setCOMP_APC_FC_PREM(HtmlInputText cOMP_APC_FC_PREM) {
		COMP_APC_FC_PREM = cOMP_APC_FC_PREM;
	}
	public HtmlInputText getCOMP_APC_FC_INT() {
		return COMP_APC_FC_INT;
	}
	public void setCOMP_APC_FC_INT(HtmlInputText cOMP_APC_FC_INT) {
		COMP_APC_FC_INT = cOMP_APC_FC_INT;
	}
	public HtmlSelectOneMenu getCOMP_APC_STATUS() {
		return COMP_APC_STATUS;
	}
	public void setCOMP_APC_STATUS(HtmlSelectOneMenu cOMP_APC_STATUS) {
		COMP_APC_STATUS = cOMP_APC_STATUS;
	}
	public HtmlOutputLabel getCOMP_APC_STATUS_LABEL() {
		return COMP_APC_STATUS_LABEL;
	}
	public void setCOMP_APC_STATUS_LABEL(HtmlOutputLabel cOMP_APC_STATUS_LABEL) {
		COMP_APC_STATUS_LABEL = cOMP_APC_STATUS_LABEL;
	}
	public HtmlOutputLabel getCOMP_APC_FC_INT_LABEL() {
		return COMP_APC_FC_INT_LABEL;
	}
	public void setCOMP_APC_FC_INT_LABEL(HtmlOutputLabel cOMP_APC_FC_INT_LABEL) {
		COMP_APC_FC_INT_LABEL = cOMP_APC_FC_INT_LABEL;
	}
	public HtmlOutputLabel getCOMP_APC_FC_PREM_LABEL() {
		return COMP_APC_FC_PREM_LABEL;
	}
	public void setCOMP_APC_FC_PREM_LABEL(HtmlOutputLabel cOMP_APC_FC_PREM_LABEL) {
		COMP_APC_FC_PREM_LABEL = cOMP_APC_FC_PREM_LABEL;
	}
	public HtmlOutputLabel getCOMP_APC_SCHD_PYMT_DT_LABEL() {
		return COMP_APC_SCHD_PYMT_DT_LABEL;
	}
	public void setCOMP_APC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel cOMP_APC_SCHD_PYMT_DT_LABEL) {
		COMP_APC_SCHD_PYMT_DT_LABEL = cOMP_APC_SCHD_PYMT_DT_LABEL;
	}
	public HtmlOutputLabel getCOMP_APC_POL_NO_LABEL() {
		return COMP_APC_POL_NO_LABEL;
	}
	public void setCOMP_APC_POL_NO_LABEL(HtmlOutputLabel cOMP_APC_POL_NO_LABEL) {
		COMP_APC_POL_NO_LABEL = cOMP_APC_POL_NO_LABEL;
	}

	public void postRecord2() {
		String message = null;
		try {
			/*if (PT_IL_ADJ_PREM_COLL_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PT_IL_ADJ_PREM_COLL_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
				dataList_PT_IL_ADJ_PREM_COLL.add(PT_IL_ADJ_PREM_COLL_BEAN);
						
			} else*/ if (PT_IL_ADJ_PREM_COLL_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE2(compositeAction);
				new CRUDHandler().executeUpdate(PT_IL_ADJ_PREM_COLL_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
			}

			PT_IL_ADJ_PREM_COLL_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
			totalSumValue();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	}
	/*Policy Loan Table fields*/
	public HtmlOutputLabel COMP_AL_POL_NO_LABEL;
	
	public HtmlOutputLabel COMP_AL_STATUS_LABEL;
	
	public HtmlOutputLabel COMP_AL_FC_INT_AMT_LABEL;
	
	public HtmlOutputLabel COMP_AL_FC_LOAN_AMT_LABEL;
	
	public HtmlOutputLabel COMP_AL_REPAY_DT_LABEL;
	
	public HtmlInputText COMP_AL_FC_INT_AMT;
	
	public HtmlInputText COMP_AL_FC_LOAN_AMT;
	
	public HtmlCalendar COMP_AL_REPAY_DT;
	
	public HtmlInputText COMP_AL_POL_NO;
	
	public HtmlSelectOneMenu COMP_AL_STATUS;
	
	public HtmlCommandButton COMP_UI_M_POL_LOAN_POSTREC;

	public HtmlCommandButton getCOMP_UI_M_POL_LOAN_POSTREC() {
		return COMP_UI_M_POL_LOAN_POSTREC;
	}
	public void setCOMP_UI_M_POL_LOAN_POSTREC(
			HtmlCommandButton cOMP_UI_M_POL_LOAN_POSTREC) {
		COMP_UI_M_POL_LOAN_POSTREC = cOMP_UI_M_POL_LOAN_POSTREC;
	}
	public HtmlCalendar getCOMP_AL_REPAY_DT() {
		return COMP_AL_REPAY_DT;
	}
	public void setCOMP_AL_REPAY_DT(HtmlCalendar cOMP_AL_REPAY_DT) {
		COMP_AL_REPAY_DT = cOMP_AL_REPAY_DT;
	}
	public HtmlInputText getCOMP_UI_POL_TOTAL() {
		return COMP_UI_POL_TOTAL;
	}
	public void setCOMP_UI_POL_TOTAL(HtmlInputText cOMP_UI_POL_TOTAL) {
		COMP_UI_POL_TOTAL = cOMP_UI_POL_TOTAL;
	}
	public HtmlOutputLabel getCOMP_UI_POL_TOTAL_LABEL() {
		return COMP_UI_POL_TOTAL_LABEL;
	}
	public void setCOMP_UI_POL_TOTAL_LABEL(HtmlOutputLabel cOMP_UI_POL_TOTAL_LABEL) {
		COMP_UI_POL_TOTAL_LABEL = cOMP_UI_POL_TOTAL_LABEL;
	}
	
	public HtmlOutputLabel getCOMP_AL_POL_NO_LABEL() {
		return COMP_AL_POL_NO_LABEL;
	}
	public void setCOMP_AL_POL_NO_LABEL(HtmlOutputLabel cOMP_AL_POL_NO_LABEL) {
		COMP_AL_POL_NO_LABEL = cOMP_AL_POL_NO_LABEL;
	}
	public HtmlOutputLabel getCOMP_AL_STATUS_LABEL() {
		return COMP_AL_STATUS_LABEL;
	}
	public void setCOMP_AL_STATUS_LABEL(HtmlOutputLabel cOMP_AL_STATUS_LABEL) {
		COMP_AL_STATUS_LABEL = cOMP_AL_STATUS_LABEL;
	}
	public HtmlOutputLabel getCOMP_AL_FC_INT_AMT_LABEL() {
		return COMP_AL_FC_INT_AMT_LABEL;
	}
	public void setCOMP_AL_FC_INT_AMT_LABEL(HtmlOutputLabel cOMP_AL_FC_INT_AMT_LABEL) {
		COMP_AL_FC_INT_AMT_LABEL = cOMP_AL_FC_INT_AMT_LABEL;
	}
	public HtmlOutputLabel getCOMP_AL_FC_LOAN_AMT_LABEL() {
		return COMP_AL_FC_LOAN_AMT_LABEL;
	}
	public void setCOMP_AL_FC_LOAN_AMT_LABEL(
			HtmlOutputLabel cOMP_AL_FC_LOAN_AMT_LABEL) {
		COMP_AL_FC_LOAN_AMT_LABEL = cOMP_AL_FC_LOAN_AMT_LABEL;
	}
	public HtmlOutputLabel getCOMP_AL_REPAY_DT_LABEL() {
		return COMP_AL_REPAY_DT_LABEL;
	}
	public void setCOMP_AL_REPAY_DT_LABEL(HtmlOutputLabel cOMP_AL_REPAY_DT_LABEL) {
		COMP_AL_REPAY_DT_LABEL = cOMP_AL_REPAY_DT_LABEL;
	}
	public HtmlInputText getCOMP_AL_FC_INT_AMT() {
		return COMP_AL_FC_INT_AMT;
	}
	public void setCOMP_AL_FC_INT_AMT(HtmlInputText cOMP_AL_FC_INT_AMT) {
		COMP_AL_FC_INT_AMT = cOMP_AL_FC_INT_AMT;
	}
	public HtmlInputText getCOMP_AL_FC_LOAN_AMT() {
		return COMP_AL_FC_LOAN_AMT;
	}
	public void setCOMP_AL_FC_LOAN_AMT(HtmlInputText cOMP_AL_FC_LOAN_AMT) {
		COMP_AL_FC_LOAN_AMT = cOMP_AL_FC_LOAN_AMT;
	}
	
	public HtmlInputText getCOMP_AL_POL_NO() {
		return COMP_AL_POL_NO;
	}
	public void setCOMP_AL_POL_NO(HtmlInputText cOMP_AL_POL_NO) {
		COMP_AL_POL_NO = cOMP_AL_POL_NO;
	}
	public HtmlSelectOneMenu getCOMP_AL_STATUS() {
		return COMP_AL_STATUS;
	}
	public void setCOMP_AL_STATUS(HtmlSelectOneMenu cOMP_AL_STATUS) {
		COMP_AL_STATUS = cOMP_AL_STATUS;
	
	}
	public void postRecord3() {
		String message = null;
		try {
		/*	if (PT_IL_ADJ_LOAN_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PT_IL_ADJ_LOAN_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
				dataList_PT_IL_ADJ_LOAN.add(PT_IL_ADJ_LOAN_BEAN);
						
			} else */if (PT_IL_ADJ_LOAN_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE3(compositeAction);
				new CRUDHandler().executeUpdate(PT_IL_ADJ_LOAN_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord",message);
			}

			PT_IL_ADJ_LOAN_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
			totalSumValue();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		/*} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}*/

	}
	
	/*Summary Fields*/
	private HtmlSimpleTogglePanel COMP_SUMMARY_PANEL;
    
	private HtmlOutputLabel COMP_UI_PROP_DEPOSIT_LABEL;
	
	private HtmlInputText COMP_UI_PROP_DEPOSIT;
	
	private HtmlInputText COMP_UI_POL_PREM;
	
	private HtmlOutputLabel COMP_UI_POL_PREM_LABEL;
	
	private HtmlOutputLabel COMP_UI_POL_LOAN_LABEL;
	
	private HtmlInputText COMP_UI_POL_LOAN;
	
	private HtmlInputText COMP_UI_POL_TOTAL;
	
	private HtmlOutputLabel COMP_UI_POL_TOTAL_LABEL;
	
	private HtmlCommandButton COMP_SURENDER_BTN;
	
	public HtmlCommandButton getCOMP_SURENDER_BTN() {
		return COMP_SURENDER_BTN;
	}
	public void setCOMP_SURENDER_BTN(HtmlCommandButton cOMP_SURENDER_BTN) {
		COMP_SURENDER_BTN = cOMP_SURENDER_BTN;
	}
	/*public HtmlAjaxCommandButton getCOMP_SURENDER_BTN() {
		return COMP_SURENDER_BTN;
	}
	public void setCOMP_SURENDER_BTN(HtmlAjaxCommandButton cOMP_SURENDER_BTN) {
		COMP_SURENDER_BTN = cOMP_SURENDER_BTN;
	}*/
	public HtmlOutputLabel getCOMP_UI_POL_LOAN_LABEL() {
		return COMP_UI_POL_LOAN_LABEL;
	}
	public void setCOMP_UI_POL_LOAN_LABEL(HtmlOutputLabel cOMP_UI_POL_LOAN_LABEL) {
		COMP_UI_POL_LOAN_LABEL = cOMP_UI_POL_LOAN_LABEL;
	}
	public HtmlInputText getCOMP_UI_POL_LOAN() {
		return COMP_UI_POL_LOAN;
	}
	public void setCOMP_UI_POL_LOAN(HtmlInputText cOMP_UI_POL_LOAN) {
		COMP_UI_POL_LOAN = cOMP_UI_POL_LOAN;
	}
	public HtmlInputText getCOMP_UI_POL_PREM() {
		return COMP_UI_POL_PREM;
	}
	public void setCOMP_UI_POL_PREM(HtmlInputText cOMP_UI_POL_PREM) {
		COMP_UI_POL_PREM = cOMP_UI_POL_PREM;
	}
	public HtmlOutputLabel getCOMP_UI_POL_PREM_LABEL() {
		return COMP_UI_POL_PREM_LABEL;
	}
	public void setCOMP_UI_POL_PREM_LABEL(HtmlOutputLabel cOMP_UI_POL_PREM_LABEL) {
		COMP_UI_POL_PREM_LABEL = cOMP_UI_POL_PREM_LABEL;
	}
	public HtmlOutputLabel getCOMP_UI_PROP_DEPOSIT_LABEL() {
		return COMP_UI_PROP_DEPOSIT_LABEL;
	}
	public void setCOMP_UI_PROP_DEPOSIT_LABEL(
			HtmlOutputLabel cOMP_UI_PROP_DEPOSIT_LABEL) {
		COMP_UI_PROP_DEPOSIT_LABEL = cOMP_UI_PROP_DEPOSIT_LABEL;
	}
	public HtmlInputText getCOMP_UI_PROP_DEPOSIT() {
		return COMP_UI_PROP_DEPOSIT;
	}
	public void setCOMP_UI_PROP_DEPOSIT(HtmlInputText cOMP_UI_PROP_DEPOSIT) {
		COMP_UI_PROP_DEPOSIT = cOMP_UI_PROP_DEPOSIT;
	}
	public HtmlSimpleTogglePanel getCOMP_SUMMARY_PANEL() {
		return COMP_SUMMARY_PANEL;
	}
	public void setCOMP_SUMMARY_PANEL(HtmlSimpleTogglePanel cOMP_SUMMARY_PANEL) {
		COMP_SUMMARY_PANEL = cOMP_SUMMARY_PANEL;
	}
	public void instantiateAllComponent(){
		 COMP_AH_REF_NO= new HtmlInputText();
		 COMP_AH_CUST_CODE=new HtmlInputText();
		 COMP_UI_M_CUST_DESC=new HtmlInputText();
		 COMP_APD_FC_AMOUNT=new HtmlInputText();
		 COMP_APD_PROP_NO=new HtmlInputText();
		 COMP_APD_STATUS=new HtmlSelectOneMenu();
		 COMP_APC_POL_NO=new HtmlInputText();
		 COMP_APC_SCHD_PYMT_DT=new HtmlCalendar();
		 COMP_APC_FC_PREM=new HtmlInputText();
		 COMP_APC_FC_INT=new HtmlInputText();
		 COMP_APC_STATUS=new HtmlSelectOneMenu();
		 COMP_UI_M_POL_PREM_POST=new HtmlCommandButton();
		 COMP_AL_FC_INT_AMT=new HtmlInputText();
		 COMP_AL_FC_LOAN_AMT=new HtmlInputText();
		 COMP_AL_REPAY_DT=new HtmlCalendar();
		 COMP_AL_POL_NO=new HtmlInputText();
		 COMP_AL_STATUS=new HtmlSelectOneMenu();
		 COMP_UI_M_POL_LOAN_POSTREC=new HtmlCommandButton();
		 COMP_AH_FC_AMOUNT = new HtmlInputText();
		 
	}
	
	 public void resetAllComponent() {
		 COMP_AH_REF_NO.resetValue();
		 COMP_AH_CUST_CODE.resetValue();
		 COMP_UI_M_CUST_DESC.resetValue();
		 //COMP_AH_LC_AMOUNT.resetValue();
		 COMP_AH_FC_AMOUNT.resetValue();
		 COMP_AH_REF_TYPE.resetValue();
		 COMP_APD_FC_AMOUNT.resetValue();
		 COMP_APD_PROP_NO.resetValue();
		 COMP_APD_STATUS.resetValue();
		 COMP_APC_POL_NO.resetValue();
		 COMP_APC_SCHD_PYMT_DT.resetValue();
		 COMP_APC_FC_PREM.resetValue();
		 COMP_APC_FC_INT.resetValue();
		 COMP_APC_STATUS.resetValue();
		 COMP_AL_FC_INT_AMT.resetValue();
		 COMP_AL_FC_LOAN_AMT.resetValue();
		 COMP_AL_REPAY_DT.resetValue();
		 COMP_AL_POL_NO.resetValue();
		 COMP_AL_STATUS.resetValue();
	 }
	 public void disableAllComponent(Boolean flag) {
		 COMP_UI_M_DEP_PREM_POST.setDisabled(flag);
		 COMP_UI_M_POL_HEAD_POST.setDisabled(flag);
		 COMP_UI_M_POL_PREM_POST.setDisabled(flag);
		 COMP_UI_M_POL_LOAN_POSTREC.setDisabled(flag);
		 COMP_AH_REF_NO.setDisabled(flag);
		 COMP_AH_CUST_CODE.setDisabled(flag);
		 COMP_UI_M_CUST_DESC.setDisabled(flag);
		 //COMP_AH_LC_AMOUNT.setDisabled(flag);
		 COMP_AH_FC_AMOUNT.setDisabled(flag);
		 COMP_AH_REF_TYPE.setDisabled(flag);
		 COMP_APD_FC_AMOUNT.setDisabled(flag);
		 COMP_APD_PROP_NO.setDisabled(flag);
		 COMP_APD_STATUS.setDisabled(flag);
		 COMP_APC_POL_NO.setDisabled(flag);
		 COMP_APC_SCHD_PYMT_DT.setDisabled(flag);
		 COMP_APC_FC_PREM.setDisabled(flag);
		 COMP_APC_FC_INT.setDisabled(flag);
		 COMP_APC_STATUS.setDisabled(flag);
		 COMP_AL_FC_INT_AMT.setDisabled(flag);
		 COMP_AL_FC_LOAN_AMT.setDisabled(flag);
		 COMP_AL_REPAY_DT.setDisabled(flag);
		 COMP_AL_POL_NO.setDisabled(flag);
		 COMP_AL_STATUS.setDisabled(flag);
		 COMP_UI_PROP_DEPOSIT.setDisabled(flag);
		 COMP_UI_POL_PREM.setDisabled(flag);
		 COMP_UI_POL_LOAN.setDisabled(flag);
		 COMP_UI_POL_TOTAL.setDisabled(flag);
	 }
		public void AH_REF_TYPE_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_HEAD_BEAN().setAH_REF_TYPE((String)value);
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_HEAD_BEAN().getAH_REF_NO());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void AH_REF_NO_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_HEAD_BEAN().setAH_REF_NO((String)value);
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_HEAD_BEAN().getAH_REF_NO());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public void AH_CUST_CODE_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_HEAD_BEAN().setAH_CUST_CODE((String)value);
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_HEAD_BEAN().getAH_CUST_CODE());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public void AH_FC_AMOUNT_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_HEAD_BEAN().setAH_FC_AMOUNT((Double)value);
				//getPT_IL_ADJ_HEAD_BEAN().setAH_FC_AMOUNT(PT_IL_ADJ_HEAD_BEAN.getUI_POL_TOTAL());
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_HEAD_BEAN().getAH_FC_AMOUNT());
				COMP_AH_FC_AMOUNT.resetValue();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public String actionSurrder(){
			String outcome = null;
			try {
				//P9ILPK_ADJ_OS.P_UPD_NET_SURR_AMT(P_SMV_SYS_ID IN NUMBER, P_AH_SYS_ID IN NUMBER);
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest) context
						.getExternalContext().getRequest();
				HttpSession session = request.getSession();
				System.out.println("SMV_APPV_FLAG"+session.getAttribute("SMV_APPV_FLAG").toString());
				String SMV_APPV_FLAG=session.getAttribute("SMV_APPV_FLAG").toString();
				if((CommonUtils.nvl(SMV_APPV_FLAG,"N")).equalsIgnoreCase("N")){
				Long AH_REF_SYS_ID=getPT_IL_ADJ_HEAD_BEAN().getAH_REF_SYS_ID();
				System.out.println("Ref_sys_id value"+getPT_IL_ADJ_HEAD_BEAN().getAH_REF_SYS_ID());
				Long AH_SYS_ID=getPT_IL_ADJ_HEAD_BEAN().getAH_SYS_ID();
				System.out.println("AH_SYS_ID "+getPT_IL_ADJ_HEAD_BEAN().getAH_SYS_ID());
				/*P_UPD_NET_SURR_AMT(AH_REF_SYS_ID.toString(),AH_SYS_ID.toString());*/
				 
				System.out.println("pol_no in main :"+PT_IL_ADJ_HEAD_BEAN.getAH_REF_NO());
				P_UPD_NET_PAID_AMT_CALC(PT_IL_ADJ_HEAD_BEAN.getAH_REF_NO().toString(),AH_SYS_ID.toString()); 
				setBlockFlag(true);
				
				 
				PILT013_COMPOSITE_ACTION PILT013_compositeAction = (PILT013_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILT013_COMPOSITE_ACTION");
				System.out.println("PILT013_compositeAction        "+PILT013_compositeAction);
				PILT013_compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().setBlockFlag(true);;
				/*PILT013_compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().onLoad(null);*/
				}
				outcome="PILT013_PT_IL_SURR_MAT_VALUES";
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("MAIN", e.getMessage());
				
				// TODO: handle exception
			}
			return outcome;
			
		}
		public ArrayList<OracleParameter> P_UPD_NET_PAID_AMT_CALC(
				String P_POL_NO,
				String AH_SYS_ID)throws Exception {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN3", "INT", "IN",P_POL_NO);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN4", "DOUBLE", "IN",AH_SYS_ID);
				parameterList.add(param2);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.execute(parameterList, connection,
						"P9ILPK_ADJ_OS.P_UPD_NET_PAID_AMT_CALC");
			} catch(Exception e) {
				e.printStackTrace();
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new Exception(e.getMessage());
			}
			return outputList;
		}
		public ArrayList<OracleParameter> P_UPD_NET_SURR_AMT(
				String P_SMV_SYS_ID,
				String P_AH_SYS_ID)throws Exception {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN3", "INT", "IN",P_SMV_SYS_ID);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN4", "INT", "IN",P_AH_SYS_ID);
				parameterList.add(param2);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.execute(parameterList, connection,
						"P9ILPK_ADJ_OS.P_UPD_NET_SURR_AMT");
			} catch(Exception e) {
				e.printStackTrace();
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new Exception(e.getMessage());
			}
			return outputList;
		}
		private void prepareDropDowns() {
			try {
				setListAPD_STATUS(ListItemUtil.getDropDownListValue(
						CommonUtils.getConnection(), "PILP078",
						"PT_IL_ADJ_PROP_DEP",
						"PT_IL_ADJ_PROP_DEP.APD_STATUS", "IL_PREM_STAT"));
				
				setListAH_REF_TYPE(ListItemUtil.getDropDownListValue(
						CommonUtils.getConnection(), "PILP078",
						"PT_IL_ADJ_HEAD",
						"PT_IL_ADJ_HEAD.AH_REF_TYPE", "IL_ADJ_STAT"));
				
				setListAPC_STATUS(ListItemUtil.getDropDownListValue(
						CommonUtils.getConnection(), "PILP078",
						"PT_IL_ADJ_PREM_COLL",
						"PT_IL_ADJ_PREM_COLL.APC_STATUS", "IL_PREM_STAT"));
				
				setListAL_STATUS(ListItemUtil.getDropDownListValue(
						CommonUtils.getConnection(), "PILP078",
						"PT_IL_ADJ_LOAN",
						"PT_IL_ADJ_LOAN.AL_STATUS", "IL_PREM_STAT"));
			
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
		public void APC_STATUS_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_PREM_COLL_BEAN().setAPC_STATUS((String)value);
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_PREM_COLL_BEAN().getAPC_POL_NO());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public void APC_POL_NO_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_PREM_COLL_BEAN().setAPC_POL_NO((String)value);
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_PREM_COLL_BEAN().getAPC_POL_NO());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public void APC_FC_INT_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_PREM_COLL_BEAN().setAPC_FC_INT((Double)value);
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_PREM_COLL_BEAN().getAPC_FC_INT());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public void APC_FC_PREM_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_PREM_COLL_BEAN().setAPC_FC_PREM((Double)value);
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_PREM_COLL_BEAN().getAPC_FC_PREM());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public void APC_SCHD_PYMT_DT_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_PREM_COLL_BEAN().setAPC_SCHD_PYMT_DT((Date)value);
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_PREM_COLL_BEAN().getAPC_SCHD_PYMT_DT());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void APD_PROP_NO_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_PROP_DEP_BEAN().setAPD_PROP_NO((String)value);
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_PROP_DEP_BEAN().getAPD_PROP_NO());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void APD_FC_AMOUNT_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_PROP_DEP_BEAN().setAPD_FC_AMOUNT((Double)value);
				System.out.println("APD_FC_AMOUNT :"+getPT_IL_ADJ_PROP_DEP_BEAN().getAPD_FC_AMOUNT());
				System.out.println("AH_REF_TYPE value"+getPT_IL_ADJ_PROP_DEP_BEAN().getAPD_FC_AMOUNT());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public void APD_STATUS_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_PROP_DEP_BEAN().setAPD_STATUS((String)value);
				System.out.println("AH_REF_TYPE value  :"+getPT_IL_ADJ_PROP_DEP_BEAN().getAPD_STATUS());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public void AL_POL_NO_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_LOAN_BEAN().setAL_POL_NO((String)value);
				System.out.println("AH_REF_TYPE value  :"+getPT_IL_ADJ_LOAN_BEAN().getAL_POL_NO());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void AL_REPAY_DT_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_LOAN_BEAN().setAL_REPAY_DT((Date)value);
				System.out.println("AH_REF_TYPE value  :"+getPT_IL_ADJ_LOAN_BEAN().getAL_REPAY_DT());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public void AL_FC_LOAN_AMT_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_LOAN_BEAN().setAL_FC_LOAN_AMT((Double)value);
				System.out.println("AH_REF_TYPE value  :"+getPT_IL_ADJ_LOAN_BEAN().getAL_FC_LOAN_AMT());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		public void AL_FC_INT_AMT_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_LOAN_BEAN().setAL_FC_INT_AMT((Double)value);
				System.out.println("AH_REF_TYPE value  :"+getPT_IL_ADJ_LOAN_BEAN().getAL_FC_INT_AMT());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void AL_STATUS_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				getPT_IL_ADJ_LOAN_BEAN().setAL_STATUS((String)value);
				System.out.println("AH_REF_TYPE value  :"+getPT_IL_ADJ_LOAN_BEAN().getAL_STATUS());
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		private void totalSumValue(){
			Double UI_M_SUM_APD_FC_AMOUNT=null;
			Double UI_M_SUM_AL_FC_INT_AMT=null;
			Double UI_M_SUM_APC_FC_PREM=null;
			Double TotalValue=null;
			//Proposal Deposit field value
			if (dataList_PT_IL_ADJ_PROP_DEP.size()!= 0) {
				
				/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
				int count=0;
				
				/*End*/
				
				//Added to check share Ratio percentage during save
				for(PT_IL_ADJ_PROP_DEP  obj: getDataList_PT_IL_ADJ_PROP_DEP()) {
					if(obj.getAPD_STATUS().equalsIgnoreCase("Y")){
						Double value=CommonUtils.nvl(obj.getAPD_FC_AMOUNT(), 0);
						UI_M_SUM_APD_FC_AMOUNT = CommonUtils.nvl(UI_M_SUM_APD_FC_AMOUNT,0)+value;
						PT_IL_ADJ_PROP_DEP_BEAN.setUI_PROP_DEPOSIT(UI_M_SUM_APD_FC_AMOUNT);
						COMP_UI_PROP_DEPOSIT.resetValue();
						/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
						count++;
					}
					if(count<=0)
					{
						PT_IL_ADJ_PROP_DEP_BEAN.setUI_PROP_DEPOSIT(0.00);
						COMP_UI_PROP_DEPOSIT.resetValue();
					}
					/*End*/
				}
			}
			/*End*/
		//Premium field value	
			if (dataList_PT_IL_ADJ_PREM_COLL.size()!= 0) {
				
				/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
				int count=0;
				
				/*End*/
					//Added to check share Ratio percentage during save
					for(PT_IL_ADJ_PREM_COLL  obj: getDataList_PT_IL_ADJ_PREM_COLL()) {
						if(obj.getAPC_STATUS().equalsIgnoreCase("Y")){
							Double value=CommonUtils.nvl(obj.getAPC_FC_PREM(), 0);
							UI_M_SUM_APC_FC_PREM =  CommonUtils.nvl(UI_M_SUM_APC_FC_PREM,0 )+value;
							PT_IL_ADJ_PREM_COLL_BEAN.setUI_POL_PREM(UI_M_SUM_APC_FC_PREM);
							COMP_UI_POL_PREM.resetValue();
						
							/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
							count++;
						}
						if(count<=0)
						{
							PT_IL_ADJ_PREM_COLL_BEAN.setUI_POL_PREM(0.00);
							COMP_UI_POL_PREM.resetValue();
						}
						/*End*/
					}
			}
		/*End*/
			//Loan field Value
			if (dataList_PT_IL_ADJ_LOAN.size()!= 0) {
			
				/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
				int count=0;
				
				/*End*/
				
				//Added to check share Ratio percentage during save
				for(PT_IL_ADJ_LOAN  obj: getDataList_PT_IL_ADJ_LOAN()) {
					if(obj.getAL_STATUS().equalsIgnoreCase("Y")){
						Double value=CommonUtils.nvl(obj.getAL_FC_INT_AMT(), 0);
						UI_M_SUM_AL_FC_INT_AMT = CommonUtils.nvl(UI_M_SUM_AL_FC_INT_AMT,0 )+value;
						PT_IL_ADJ_LOAN_BEAN.setUI_POL_LOAN(UI_M_SUM_AL_FC_INT_AMT);
						COMP_UI_POL_LOAN.resetValue();
						
						/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
						count++;
					}
					if(count<=0)
					{
						PT_IL_ADJ_LOAN_BEAN.setUI_POL_LOAN(0.00);
						COMP_UI_POL_LOAN.resetValue();
					}
					/*End*/	
					
				}
		}
			/*end*/
			//Total Amount
			TotalValue= CommonUtils.nvl(UI_M_SUM_AL_FC_INT_AMT,0)+ CommonUtils.nvl(UI_M_SUM_APC_FC_PREM,0)+ CommonUtils.nvl(UI_M_SUM_APD_FC_AMOUNT,0);
			PT_IL_ADJ_HEAD_BEAN.setUI_POL_TOTAL(TotalValue);
			
			/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/	
			/*FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context
					.getExternalContext().getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("getUI_POL_TOTAL",PT_IL_ADJ_HEAD_BEAN.getUI_POL_TOTAL());

			System.out.println("getUI_POL_TOTAL            "+PT_IL_ADJ_HEAD_BEAN.getUI_POL_TOTAL());*/
			
			/*eND*/
			
			
			COMP_UI_POL_TOTAL.resetValue();
			/*end*/
		}
		
		public void setPOL_LAPS_OVR_DT_Editable(ActionEvent event) {
			CommonUtils.clearMaps(this);
			try
			{
			UIInput input = (UIInput) event.getComponent().getParent();
			String inputdate= (String)input.getSubmittedValue();
			Date dat = new SimpleDateFormat("dd/MM/yyyy").parse(inputdate);
			System.out.println("inputdate ::" + inputdate + "::dat ::" +dat);
			int currentIndex=this.dataTable.getRowIndex();
			PT_IL_ADJ_PREM_COLL_BEAN.setAPC_SCHD_PYMT_DT(dat);
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("postRecord", e.getMessage());	
			}

		}
		
		public void setAL_REPAY_DT_Editable(ActionEvent event) {
			CommonUtils.clearMaps(this);
			try
			{
			UIInput input = (UIInput) event.getComponent().getParent();
			String inputdate= (String)input.getSubmittedValue();
			Date dat = new SimpleDateFormat("dd/MM/yyyy").parse(inputdate);
			System.out.println("inputdate ::" + inputdate + "::dat ::" +dat);
			int currentIndex=this.dataTable.getRowIndex();
			PT_IL_ADJ_LOAN_BEAN.setAL_REPAY_DT(dat);
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("postRecord", e.getMessage());	
			}

		}
}

