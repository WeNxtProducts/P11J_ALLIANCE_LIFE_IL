package com.iii.pel.forms.PLM005;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
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

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM001.PM_IL_CLASS;
import com.iii.pel.forms.PILM001.PM_IL_CLASS_ACTION;
import com.iii.pel.forms.PILM031.PILM031_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM031.PM_IL_DISC_AGE;
import com.iii.pel.forms.PILM031.PM_IL_DISC_AGE_HELPER;
import com.iii.pel.forms.PM105_A_TISB.PM_IL_CODES_ACCOUNT_SETUP_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CURRENCY_ACTION extends CommonAction{

	/*Added by saritha */
	
	
	private HtmlCalendar COMP_CM_EX_EFF_TO_DT;
	
	public HtmlCalendar getCOMP_CM_EX_EFF_TO_DT() {
		return COMP_CM_EX_EFF_TO_DT;
	}

	public void setCOMP_CM_EX_EFF_TO_DT(HtmlCalendar cOMP_CM_EX_EFF_TO_DT) {
		COMP_CM_EX_EFF_TO_DT = cOMP_CM_EX_EFF_TO_DT;
	}

	private HtmlOutputLabel COMP_CM_EX_EFF_TO_DT_LABEL;


	public HtmlOutputLabel getCOMP_CM_EX_EFF_TO_DT_LABEL() {
		return COMP_CM_EX_EFF_TO_DT_LABEL;
	}

	public void setCOMP_CM_EX_EFF_TO_DT_LABEL(
			HtmlOutputLabel cOMP_CM_EX_EFF_TO_DT_LABEL) {
		COMP_CM_EX_EFF_TO_DT_LABEL = cOMP_CM_EX_EFF_TO_DT_LABEL;
	}

	/*End*/

	private HtmlOutputLabel COMP_CM_CODE_LABEL;

	private HtmlInputText COMP_CM_CODE;

	private HtmlOutputLabel COMP_CM_NAME_LABEL;

	private HtmlInputText COMP_CM_NAME;

	private HtmlOutputLabel COMP_CM_SHORT_NAME_LABEL;

	private HtmlInputText COMP_CM_SHORT_NAME;

	private HtmlOutputLabel COMP_CM_UNIT_NAME_LABEL;

	private HtmlInputText COMP_CM_UNIT_NAME;

	private HtmlOutputLabel COMP_CM_DECIMALS_LABEL;

	private HtmlInputText COMP_CM_DECIMALS;


	private HtmlOutputLabel COMP_CM_EX_EFF_DT_LABEL;

	private HtmlCalendar COMP_CM_EX_EFF_DT;

	private HtmlOutputLabel COMP_CM_EX_BUYING_LABEL;

	private HtmlInputText COMP_CM_EX_BUYING;

	private HtmlOutputLabel COMP_CM_EX_SELLING_LABEL;

	private HtmlInputText COMP_CM_EX_SELLING;

	private HtmlOutputLabel COMP_CM_EX_AVERAGE_LABEL;

	private HtmlInputText COMP_CM_EX_AVERAGE;

	private HtmlOutputLabel COMP_CM_EX_FIXED_LABEL;

	private HtmlInputText COMP_CM_EX_FIXED;


	private HtmlOutputLabel  COMP_CURR_FRZ_FLAG_LABEL;

	private HtmlCommandButton COMP_BACK_BUTTON;
	private PM_CURRENCY PM_CURRENCY_BEAN;
	private PM_IL_CURRENCY_HELPER helper;
	CRUDHandler handler = new CRUDHandler();
	public PLM005_COMPOSITE_ACTION compositeAction;
	private HtmlTabPanel COMP_TAB_PANEL;
	private HtmlTab COMP_MORE_INFO_1;

	/*Added by dhinesh 9.3.2016*/

	private PM_IL_CURRENCY_DELEGATE delegate=null;

	public PM_IL_CURRENCY_DELEGATE getDelegate() {
		return delegate;
	}

	public void setDelegate(PM_IL_CURRENCY_DELEGATE delegate) {
		this.delegate = delegate;
	}




	/*end*/





	/*for Exchange Rate*/
	private FM_EXCHANGE_RATE FM_EXCHANGE_RATE_BEAN;
	private PM_IL_EXC_RATE_HELPER exc_rate_helper;

	private List<FM_EXCHANGE_RATE> dataList_FM_EXCHANGE_RATE = new ArrayList<FM_EXCHANGE_RATE>();

	private HtmlSelectOneMenu COMP_EXC_RATE_FLAG;

	private List<SelectItem> listEXC_RATE_FLAG = new ArrayList<SelectItem>();

       private String exc_rate_label;

       

	public List<SelectItem> getListEXC_RATE_FLAG() {

		/*if (listEXC_RATE_FLAG.size() == 0) {
			listEXC_RATE_FLAG.clear();
			try {
				listEXC_RATE_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/

		try {
			System.out.println("Enter the getListEXC_RATE_FLAG  ");

			listEXC_RATE_FLAG=delegate.EXC_RATE_FLAGLIST();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return listEXC_RATE_FLAG;
	}

	
	
	public String getExc_rate_label() {
		return exc_rate_label;
	}

	public void setExc_rate_label(String exc_rate_label) {
		this.exc_rate_label = exc_rate_label;
	}

	public void setListEXC_RATE_FLAG(List<SelectItem> listEXC_RATE_FLAG) {
		this.listEXC_RATE_FLAG = listEXC_RATE_FLAG;
	}


	public HtmlSelectOneMenu getCOMP_EXC_RATE_FLAG() {
		return COMP_EXC_RATE_FLAG;
	}

	public void setCOMP_EXC_RATE_FLAG(HtmlSelectOneMenu cOMP_EXC_RATE_FLAG) {
		COMP_EXC_RATE_FLAG = cOMP_EXC_RATE_FLAG;
	}

	public FM_EXCHANGE_RATE getFM_EXCHANGE_RATE_BEAN() {
		return FM_EXCHANGE_RATE_BEAN;
	}

	public void setFM_EXCHANGE_RATE_BEAN(FM_EXCHANGE_RATE fM_EXCHANGE_RATE_BEAN) {
		FM_EXCHANGE_RATE_BEAN = fM_EXCHANGE_RATE_BEAN;
	}

	public PM_IL_EXC_RATE_HELPER getExc_rate_helper() {
		return exc_rate_helper;
	}

	public void setExc_rate_helper(PM_IL_EXC_RATE_HELPER exc_rate_helper) {
		this.exc_rate_helper = exc_rate_helper;
	}

	public List<FM_EXCHANGE_RATE> getDataList_FM_EXCHANGE_RATE() {
		return dataList_FM_EXCHANGE_RATE;
	}

	public void setDataList_FM_EXCHANGE_RATE(
			List<FM_EXCHANGE_RATE> dataList_FM_EXCHANGE_RATE) {
		this.dataList_FM_EXCHANGE_RATE = dataList_FM_EXCHANGE_RATE;
	}

	public HtmlTabPanel getCOMP_TAB_PANEL() {
		return COMP_TAB_PANEL;
	}

	public void setCOMP_TAB_PANEL(HtmlTabPanel cOMP_TAB_PANEL) {
		COMP_TAB_PANEL = cOMP_TAB_PANEL;
	}

	public HtmlTab getCOMP_MORE_INFO_1() {
		return COMP_MORE_INFO_1;
	}

	public void setCOMP_MORE_INFO_1(HtmlTab cOMP_MORE_INFO_1) {
		COMP_MORE_INFO_1 = cOMP_MORE_INFO_1;
	}

	public PM_IL_CURRENCY_ACTION() {
		PM_CURRENCY_BEAN = new PM_CURRENCY();
		FM_EXCHANGE_RATE_BEAN = new FM_EXCHANGE_RATE();
		helper = new PM_IL_CURRENCY_HELPER();
		exc_rate_helper = new PM_IL_EXC_RATE_HELPER();
		delegate=new PM_IL_CURRENCY_DELEGATE();
		getListEXC_RATE_FLAG();
		/*Added by Ameen for KIC exchange rate as per siva sugg.*/
		PM_EXCHANGE_RATE_BEAN = new PM_EXCHANGE_RATE();
		/*End*/
	}



	/*public void prepareDropDownList(){



		Connection connection = null;
		ResultSet resultSet = null;



         try{

        		connection=CommonUtils.getConnection();
				//	CRUDHandler handler=new CRUDHandler();


        		Statement stmt=connection.createStatement();  


        		resultSet=stmt.executeQuery("SELECT LIV_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM = 'UNIT_SEL_BUY'");  




						while(resultSet.next())
					{

	                 FM_EXCHANGE_RATE_BEAN.setLIV_DESC(resultSet.getString("LIV_DESC"));	

	                  listEXC_RATE_FLAG.add()


					}



		}catch(Exception e)
		{

		}


	}*/


	private UIDataTable dataTable;


	private boolean update = false;


	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}


	private HtmlTab COMP_MORE_INFO_2; 





	public HtmlTab getCOMP_MORE_INFO_2() {
		return COMP_MORE_INFO_2;
	}

	public void setCOMP_MORE_INFO_2(HtmlTab cOMP_MORE_INFO_2) {
		COMP_MORE_INFO_2 = cOMP_MORE_INFO_2;
	}

	public HtmlOutputLabel getCOMP_CURR_FRZ_FLAG_LABEL() {
		return COMP_CURR_FRZ_FLAG_LABEL;
	}

	public void setCOMP_CURR_FRZ_FLAG_LABEL(HtmlOutputLabel cOMP_CURR_FRZ_FLAG_LABEL) {
		COMP_CURR_FRZ_FLAG_LABEL = cOMP_CURR_FRZ_FLAG_LABEL;
	}


	public HtmlCommandButton getCOMP_BACK_BUTTON() {
		return COMP_BACK_BUTTON;
	}

	public void setCOMP_BACK_BUTTON(HtmlCommandButton cOMP_BACK_BUTTON) {
		COMP_BACK_BUTTON = cOMP_BACK_BUTTON;
	}

	public HtmlOutputLabel getCOMP_CM_EX_EFF_DT_LABEL() {
		return COMP_CM_EX_EFF_DT_LABEL;
	}

	public void setCOMP_CM_EX_EFF_DT_LABEL(HtmlOutputLabel cOMP_CM_EX_EFF_DT_LABEL) {
		COMP_CM_EX_EFF_DT_LABEL = cOMP_CM_EX_EFF_DT_LABEL;
	}


	public HtmlCalendar getCOMP_CM_EX_EFF_DT() {
		return COMP_CM_EX_EFF_DT;
	}

	public void setCOMP_CM_EX_EFF_DT(HtmlCalendar cOMP_CM_EX_EFF_DT) {
		COMP_CM_EX_EFF_DT = cOMP_CM_EX_EFF_DT;
	}

	public HtmlOutputLabel getCOMP_CM_EX_BUYING_LABEL() {
		return COMP_CM_EX_BUYING_LABEL;
	}

	public void setCOMP_CM_EX_BUYING_LABEL(HtmlOutputLabel cOMP_CM_EX_BUYING_LABEL) {
		COMP_CM_EX_BUYING_LABEL = cOMP_CM_EX_BUYING_LABEL;
	}

	public HtmlInputText getCOMP_CM_EX_BUYING() {
		return COMP_CM_EX_BUYING;
	}

	public void setCOMP_CM_EX_BUYING(HtmlInputText cOMP_CM_EX_BUYING) {
		COMP_CM_EX_BUYING = cOMP_CM_EX_BUYING;
	}

	public HtmlOutputLabel getCOMP_CM_EX_SELLING_LABEL() {
		return COMP_CM_EX_SELLING_LABEL;
	}

	public void setCOMP_CM_EX_SELLING_LABEL(HtmlOutputLabel cOMP_CM_EX_SELLING_LABEL) {
		COMP_CM_EX_SELLING_LABEL = cOMP_CM_EX_SELLING_LABEL;
	}

	public HtmlInputText getCOMP_CM_EX_SELLING() {
		return COMP_CM_EX_SELLING;
	}

	public void setCOMP_CM_EX_SELLING(HtmlInputText cOMP_CM_EX_SELLING) {
		COMP_CM_EX_SELLING = cOMP_CM_EX_SELLING;
	}

	public HtmlOutputLabel getCOMP_CM_EX_AVERAGE_LABEL() {
		return COMP_CM_EX_AVERAGE_LABEL;
	}

	public void setCOMP_CM_EX_AVERAGE_LABEL(HtmlOutputLabel cOMP_CM_EX_AVERAGE_LABEL) {
		COMP_CM_EX_AVERAGE_LABEL = cOMP_CM_EX_AVERAGE_LABEL;
	}

	public HtmlInputText getCOMP_CM_EX_AVERAGE() {
		return COMP_CM_EX_AVERAGE;
	}

	public void setCOMP_CM_EX_AVERAGE(HtmlInputText cOMP_CM_EX_AVERAGE) {
		COMP_CM_EX_AVERAGE = cOMP_CM_EX_AVERAGE;
	}

	public HtmlOutputLabel getCOMP_CM_EX_FIXED_LABEL() {
		return COMP_CM_EX_FIXED_LABEL;
	}

	public void setCOMP_CM_EX_FIXED_LABEL(HtmlOutputLabel cOMP_CM_EX_FIXED_LABEL) {
		COMP_CM_EX_FIXED_LABEL = cOMP_CM_EX_FIXED_LABEL;
	}

	public HtmlInputText getCOMP_CM_EX_FIXED() {
		return COMP_CM_EX_FIXED;
	}

	public void setCOMP_CM_EX_FIXED(HtmlInputText cOMP_CM_EX_FIXED) {
		COMP_CM_EX_FIXED = cOMP_CM_EX_FIXED;
	}


	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public PM_CURRENCY getPM_CURRENCY_BEAN() {
		return PM_CURRENCY_BEAN;
	}

	public void setPM_CURRENCY_BEAN(PM_CURRENCY pM_CURRENCY_BEAN) {
		PM_CURRENCY_BEAN = pM_CURRENCY_BEAN;
	}

	public PLM005_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PLM005_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlOutputLabel getCOMP_CM_CODE_LABEL() {
		return COMP_CM_CODE_LABEL;
	}

	public void setCOMP_CM_CODE_LABEL(HtmlOutputLabel cOMP_CM_CODE_LABEL) {
		COMP_CM_CODE_LABEL = cOMP_CM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CM_CODE() {
		return COMP_CM_CODE;
	}

	public void setCOMP_CM_CODE(HtmlInputText cOMP_CM_CODE) {
		COMP_CM_CODE = cOMP_CM_CODE;
	}

	public HtmlOutputLabel getCOMP_CM_NAME_LABEL() {
		return COMP_CM_NAME_LABEL;
	}

	public void setCOMP_CM_NAME_LABEL(HtmlOutputLabel cOMP_CM_NAME_LABEL) {
		COMP_CM_NAME_LABEL = cOMP_CM_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CM_NAME() {
		return COMP_CM_NAME;
	}

	public void setCOMP_CM_NAME(HtmlInputText cOMP_CM_NAME) {
		COMP_CM_NAME = cOMP_CM_NAME;
	}

	public HtmlOutputLabel getCOMP_CM_SHORT_NAME_LABEL() {
		return COMP_CM_SHORT_NAME_LABEL;
	}

	public void setCOMP_CM_SHORT_NAME_LABEL(HtmlOutputLabel cOMP_CM_SHORT_NAME_LABEL) {
		COMP_CM_SHORT_NAME_LABEL = cOMP_CM_SHORT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CM_SHORT_NAME() {
		return COMP_CM_SHORT_NAME;
	}

	public void setCOMP_CM_SHORT_NAME(HtmlInputText cOMP_CM_SHORT_NAME) {
		COMP_CM_SHORT_NAME = cOMP_CM_SHORT_NAME;
	}

	public HtmlOutputLabel getCOMP_CM_UNIT_NAME_LABEL() {
		return COMP_CM_UNIT_NAME_LABEL;
	}

	public void setCOMP_CM_UNIT_NAME_LABEL(HtmlOutputLabel cOMP_CM_UNIT_NAME_LABEL) {
		COMP_CM_UNIT_NAME_LABEL = cOMP_CM_UNIT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CM_UNIT_NAME() {
		return COMP_CM_UNIT_NAME;
	}

	public void setCOMP_CM_UNIT_NAME(HtmlInputText cOMP_CM_UNIT_NAME) {
		COMP_CM_UNIT_NAME = cOMP_CM_UNIT_NAME;
	}

	public HtmlOutputLabel getCOMP_CM_DECIMALS_LABEL() {
		return COMP_CM_DECIMALS_LABEL;
	}

	public void setCOMP_CM_DECIMALS_LABEL(HtmlOutputLabel cOMP_CM_DECIMALS_LABEL) {
		COMP_CM_DECIMALS_LABEL = cOMP_CM_DECIMALS_LABEL;
	}

	public HtmlInputText getCOMP_CM_DECIMALS() {
		return COMP_CM_DECIMALS;
	}

	public void setCOMP_CM_DECIMALS(HtmlInputText cOMP_CM_DECIMALS) {
		COMP_CM_DECIMALS = cOMP_CM_DECIMALS;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}


	public void instantiateAllComponent() {


		COMP_BACK_BUTTON = new HtmlCommandButton();

		/*Added by Janani on 13.06.2018 for FSD_IL_FLA_019*/
		COMP_CER_CONV_FM_CURR_CODE_LABEL = new HtmlOutputLabel();
		COMP_CER_CONV_FM_CURR_CODE = new HtmlInputText();
		COMP_CER_CONV_TO_CURR_CODE_LABEL = new HtmlOutputLabel();
		COMP_CER_CONV_TO_CURR_CODE = new HtmlInputText();
		/*End*/

	}



	/*
	 * modified by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.
	 * public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			FM_EXCHANGE_RATE_BEAN = (FM_EXCHANGE_RATE) dataTable.getRowData();

			System.out.println("getCER_EFF_FRM_DT in display record               "+FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT());
			FM_EXCHANGE_RATE_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}*/
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_EXCHANGE_RATE_BEAN = (PM_EXCHANGE_RATE) dataTable.getRowData();

			System.out.println("getCER_EFF_FRM_DT in display record               "+PM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT());
			PM_EXCHANGE_RATE_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	/*Added by saritha*/
	
	public void displayRecord() {
		CommonUtils.clearMaps(this);
		try {

			resetSelectedRow();
			FM_EXCHANGE_RATE_BEAN = (FM_EXCHANGE_RATE) dataTable.getRowData();
			System.out.println("getCER_EFF_TO_DT in display record   "+FM_EXCHANGE_RATE_BEAN.getCER_EFF_TO_DT());
			FM_EXCHANGE_RATE_BEAN.setRowSelected(true);
			resetAllComponent();
	}catch (Exception exc) {
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				exc.getMessage());
		getErrorMap().put("displayRecords", exc.getMessage());
	}

}

	/*End*/
	
		
	private void resetAllComponent() {


		COMP_CM_EX_EFF_DT.resetValue();

		COMP_EXC_RATE_FLAG.resetValue();

		COMP_CM_EX_SELLING.resetValue();

		COMP_CM_EX_AVERAGE.resetValue();

		COMP_CM_EX_FIXED.resetValue();
		
		COMP_CM_EX_EFF_TO_DT.resetValue();

		// TODO Auto-generated method stub
		
		/*Added by Janani on 13.06.2018 for FSD_IL_FLA_019*/
		COMP_CER_CONV_FM_CURR_CODE.resetValue();
		COMP_CER_CONV_TO_CURR_CODE.resetValue();
		/*End*/

	}

	/*
	 * modified by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.
	 * public void resetSelectedRow() {
		Iterator<FM_EXCHANGE_RATE> FM_EXCHANGE_RATE = dataList_FM_EXCHANGE_RATE
				.iterator();
		while (FM_EXCHANGE_RATE.hasNext()) {
			FM_EXCHANGE_RATE.next().setRowSelected(false);
		}
	}*/
	
	public void resetSelectedRow() {
		Iterator<PM_EXCHANGE_RATE> PM_EXCHANGE_RATE = dataList_PM_EXCHANGE_RATE
				.iterator();
		while (PM_EXCHANGE_RATE.hasNext()) {
			PM_EXCHANGE_RATE.next().setRowSelected(false);
		}
	}

	public void validateCER_EFF_FRM_DT(FacesContext context, UIComponent component,
			Object value) {
		String currValue = (String) value;
		String beanValue = FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT_STR();
		try {
			if(!(currValue.equalsIgnoreCase(beanValue))){
				FM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT_STR((String) value);
				//helper.L_UNIQUE_DEPT_CODE(compositeAction);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}



	public void validateCER_EXG_RATE_TYPE(FacesContext context, UIComponent component,
			Object value) {
		try {
			FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE_TYPE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCER_AVG_EXGE_RATE(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_EXCHANGE_RATE_BEAN.setCER_AVG_EXGE_RATE( (String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCER_FIX_EXGE_RATE(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_EXCHANGE_RATE_BEAN.setCER_FIX_EXGE_RATE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void onLoad(PhaseEvent event) {

		System.out.println("WELCOME TO CURRENCY ONLOAD");

		System.out.println("ActionBean is calling");

		try {
			if(isBlockFlag()){

				System.out.println("isBlockFlag        :"+isBlockFlag());

				/*PM_IL_CURRENCY_ACTION actionBean = (PM_IL_CURRENCY_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_CURRENCY_ACTION");
				compositeAction.setPM_IL_CURRENCY_ACTION_BEAN(actionBean);*/
				PM_IL_CURRENCY_ACTION actionBean = compositeAction.getPM_IL_CURRENCY_ACTION_BEAN();
				System.out.println("actionBean      "+actionBean);
				
							
			/*	actionBean.getFM_EXCHANGE_RATE_BEAN().setCER_EXG_RATE("0.0");
				actionBean.getFM_EXCHANGE_RATE_BEAN().setCER_AVG_EXGE_RATE("0.0");
				actionBean.getFM_EXCHANGE_RATE_BEAN().setCER_FIX_EXGE_RATE("0.0");*/
				
				if(actionBean.getPM_CURRENCY_BEAN().getROWID() != null){

					System.out.println("getROWID() != null");
					System.out.println("getROWID   :"+actionBean.getPM_CURRENCY_BEAN().getROWID());
					System.out.println(actionBean.getPM_CURRENCY_BEAN().getCURR_CODE());
					COMP_CM_EX_SELLING_LABEL.setValue("Selling");
					
					System.out.println("COMP_CM_EX_SELLING_LABEL in onload     :"+COMP_CM_EX_SELLING_LABEL.getValue());
									
					helper.executeQuery(compositeAction);
					/*
					 * modified by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.
					 * exc_rate_helper.executeExc_rate_Query(compositeAction);*/
					exc_rate_helper.pm_executeExc_rate_Query(compositeAction);
					instantiateAllComponent();



				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("BEFORE_PHASE", e.getMessage());
		}



	}





	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}






	public void saveRecord() {

		System.out.println("INSIDE saveRecord");


		String message = null;
		CommonUtils.clearMaps(this);
		//PM_IL_CURRENCY_ACTION actionBean = (PM_IL_CURRENCY_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_CURRENCY_ACTION");

		try {
			if (getPM_CURRENCY_BEAN().getROWID() == null && this.isINSERT_ALLOWED() == true) {

				System.out.println("NOT isUPDATE_ALLOWED");

				//	helper.preInsert(compositeAction);

				PM_CURRENCY_BEAN.setCURR_CR_UID(CommonUtils.getControlBean().getUSER_ID());
				PM_CURRENCY_BEAN.setCURR_CR_DT(new CommonUtils().getCurrentDate());

				new CRUDHandler().executeInsert(PM_CURRENCY_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));
				getWarningMap().put(
						"save",
						Messages.getString("messageProperties",
								"errorPanel$message$save"));	


			}else
			{

				System.out.println("ROW ID !=NULL");

				System.out.println("isUPDATE_ALLOWED");
				//	helper.PRE_UPDATE(compositeAction);

				PM_CURRENCY_BEAN.setCURR_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
				PM_CURRENCY_BEAN.setCURR_UPD_DT(new CommonUtils().getCurrentDate());

				new CRUDHandler().executeUpdate(PM_CURRENCY_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"current",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));
				getWarningMap().put(
						"update",
						Messages.getString("messageProperties",
								"errorPanel$message$update"));
			}






		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}








	}


	/*
	 * MODIFIED by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.
	 * public void addRow(ActionEvent event) {

		System.out.println("INSIDE ADD ROW");
		try {

			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {


				System.out.println("INSIDE isINSERT_ALLOWEDW");

				FM_EXCHANGE_RATE_BEAN = new FM_EXCHANGE_RATE();


				resetAllComponent();
				resetSelectedRow();
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}*/
	
	public void addRow(ActionEvent event) {

		System.out.println("INSIDE ADD ROW");
		try {

			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {


				System.out.println("INSIDE isINSERT_ALLOWEDW");

				PM_EXCHANGE_RATE_BEAN = new PM_EXCHANGE_RATE();
				PM_EXCHANGE_RATE_BEAN.setCER_CONV_TO_CURR_CODE(PM_EXCHANGE_RATE_BEAN.getCER_CONV_TO_CURR_CODE());
				PM_EXCHANGE_RATE_BEAN.setCER_CLIENT_ID(PM_EXCHANGE_RATE_BEAN.getCER_CLIENT_ID());

				resetAllComponent();
				resetSelectedRow();
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	/*
	 * MODIFIED by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.
	 * public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();



			if (isDELETE_ALLOWED()) {
				System.out.println("inside delete row");


				if (FM_EXCHANGE_RATE_BEAN.getROWID() != null) {
					FM_EXCHANGE_RATE_BEAN.setCER_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
					FM_EXCHANGE_RATE_BEAN.setCER_UPD_DT(new CommonUtils().getCurrentDate());
					new CRUDHandler().executeDelete(FM_EXCHANGE_RATE_BEAN,
							CommonUtils.getConnection());
					dataList_FM_EXCHANGE_RATE.remove(FM_EXCHANGE_RATE_BEAN);
				}

				if (dataList_FM_EXCHANGE_RATE.size() > 0) {
					setFM_EXCHANGE_RATE_BEAN(dataList_FM_EXCHANGE_RATE.get(0));

				} else {
					addRow(null);
				}
				resetAllComponent();
				FM_EXCHANGE_RATE_BEAN.setRowSelected(true);
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}*/
	
	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();



			if (isDELETE_ALLOWED()) {
				System.out.println("inside delete row");


				if (PM_EXCHANGE_RATE_BEAN.getROWID() != null) {
					PM_EXCHANGE_RATE_BEAN.setCER_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
					PM_EXCHANGE_RATE_BEAN.setCER_UPD_DT(new CommonUtils().getCurrentDate());
					new CRUDHandler().executeDelete(PM_EXCHANGE_RATE_BEAN,
							CommonUtils.getConnection());
					dataList_PM_EXCHANGE_RATE.remove(PM_EXCHANGE_RATE_BEAN);
				}

				if (dataList_PM_EXCHANGE_RATE.size() > 0) {
					setPM_EXCHANGE_RATE_BEAN(dataList_PM_EXCHANGE_RATE.get(0));

				} else {
					addRow(null);
				}
				resetAllComponent();
				PM_EXCHANGE_RATE_BEAN.setRowSelected(true);
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$delete"));
				resetAllComponent();
				CommonUtils.getConnection().commit();
			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}

	//ADDED BY SOWMYA & AGALYA

	/*public String exchange_rate_saverecord() {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(" MMM dd HH:mm:ss z yyyy",
                        Locale.ENGLISH);
				Date parsedDate = sdf.parse(date);
				SimpleDateFormat print = new SimpleDateFormat("MMM d, yyyy HH:mm:ss");
				System.out.println(print.format(parsedDate));
				getErrorMap().clear();
				getWarningMap().clear();
				String message = null;
				Connection connection = CommonUtils.getConnection();
				CommonUtils utils = new CommonUtils();
				utils.doComitt();
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save");
				getWarningMap().put("current", message);
				getWarningMap().put(
						"save",
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}*/



	public String exchange_rate_saverecord() {
		try {
			System.out.println("into exchange_rate_saverecord");
			System.out.println("getCER_EFF_FRM_DT      :"+FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT());

			System.out.println("getCER_EFF_FRM_DT_STR       :"+FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT_STR());


			System.out.println("GetCER_CONV_FM_CURR_CODE in save method     :"+FM_EXCHANGE_RATE_BEAN.getCER_CONV_FM_CURR_CODE());
			//	Tue Jan 01 00:00:00 IST 1901

			String dateStr = FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT_STR();

			System.out.println("dateStr         :"+dateStr);
			/*DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
				Date date = (Date)formatter.parse(dateStr);
				System.out.println(date);        

				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +         cal.get(Calendar.YEAR);
				System.out.println("formatedDate : " + formatedDate);    

				formatter = new SimpleDateFormat("yyyy/MM/dd");

				 date = formatter.parse(formatedDate);


				 System.out.println("converted date            "+formatter.format(date));
			 */
			CommonUtils.getConnection().commit();
			getWarningMap().put("commkey", "Save successful");
			getWarningMap().put("current", "Record saved successfully");
		} catch (Exception e) {
			System.out.println("into exchange_rate_saverecord exception");


			e.printStackTrace();
			getErrorMap().put("commkey", "Error on commit, cause: "+e.getMessage());
			getErrorMap().put("current", "Error on commit");
		}
		return null;
	}	

	/*
	 * MODIFIED by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.
	 * public void postRecord(ActionEvent ae) {
		try {
			if (FM_EXCHANGE_RATE_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {

					System.out.println(" Date field start          " +compositeAction.getPM_IL_CURRENCY_ACTION_BEAN()
							.getFM_EXCHANGE_RATE_BEAN().getCER_EFF_FRM_DT());

					System.out.println("fm_curr_code      :"+compositeAction.getPM_IL_CURRENCY_ACTION_BEAN().getFM_EXCHANGE_RATE_BEAN().getCER_CONV_FM_CURR_CODE());	

					System.out.println("getCER_EFF_FRM_DT_STR       :"+FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT());

					//FM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT(new CommonUtils().getCurrentDate());

					System.out.println("GET DATE IN POST            :"+FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT());

					FM_EXCHANGE_RATE_BEAN.setCER_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
					FM_EXCHANGE_RATE_BEAN.setCER_UPD_DT(new CommonUtils().getCurrentDate());
					//pm_il_disc_age_pre_update(FM_EXCHANGE_RATE_BEAN);
					new CRUDHandler().executeUpdate(FM_EXCHANGE_RATE_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {
				if (isINSERT_ALLOWED()) {


					System.out.println("INSIDE POST INSERT");
					//pm_il_disc_age_pre_insert(FM_EXCHANGE_RATE_BEAN);
					FM_EXCHANGE_RATE_BEAN.setCER_CR_UID(CommonUtils.getControlBean().getUSER_ID());
					FM_EXCHANGE_RATE_BEAN.setCER_CR_DT(new CommonUtils().getCurrentDate());
					FM_EXCHANGE_RATE_BEAN.setCER_CONV_FM_CURR_CODE(compositeAction.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_CODE());

					System.out.println("GetCER_CONV_FM_CURR_CODE        :"+FM_EXCHANGE_RATE_BEAN.getCER_CONV_FM_CURR_CODE());


					new CRUDHandler().executeInsert(FM_EXCHANGE_RATE_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					dataList_FM_EXCHANGE_RATE.add(FM_EXCHANGE_RATE_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			FM_EXCHANGE_RATE_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}*/
	
	public void postRecord(ActionEvent ae) {
		try {
			
			if (PM_EXCHANGE_RATE_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {

					System.out.println(" Date field start          " +compositeAction.getPM_IL_CURRENCY_ACTION_BEAN()
							.getPM_EXCHANGE_RATE_BEAN().getCER_EFF_FRM_DT());

					System.out.println("fm_curr_code      :"+compositeAction.getPM_IL_CURRENCY_ACTION_BEAN().getPM_EXCHANGE_RATE_BEAN().getCER_CONV_FM_CURR_CODE());	

					System.out.println("getCER_EFF_FRM_DT_STR       :"+PM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT());

					//FM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT(new CommonUtils().getCurrentDate());

					System.out.println("GET DATE IN POST            :"+PM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT());

					PM_EXCHANGE_RATE_BEAN.setCER_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
					PM_EXCHANGE_RATE_BEAN.setCER_UPD_DT(new CommonUtils().getCurrentDate());
					//pm_il_disc_age_pre_update(FM_EXCHANGE_RATE_BEAN);
					new CRUDHandler().executeUpdate(PM_EXCHANGE_RATE_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {
				if (isINSERT_ALLOWED()) {


					System.out.println("INSIDE POST INSERT");
					//pm_il_disc_age_pre_insert(FM_EXCHANGE_RATE_BEAN);
					PM_EXCHANGE_RATE_BEAN.setCER_CR_UID(CommonUtils.getControlBean().getUSER_ID());
					PM_EXCHANGE_RATE_BEAN.setCER_CR_DT(new CommonUtils().getCurrentDate());
					//PM_EXCHANGE_RATE_BEAN.setCER_CONV_FM_CURR_CODE(compositeAction.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_CODE());
					/*newly added*/
					//PM_EXCHANGE_RATE_BEAN.setCER_CONV_TO_CURR_CODE(compositeAction.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_CODE());
					PM_EXCHANGE_RATE_BEAN.setCER_CLIENT_ID(compositeAction.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_CODE());
					/*End*/

					System.out.println("GetCER_CONV_FM_CURR_CODE        :"+PM_EXCHANGE_RATE_BEAN.getCER_CONV_FM_CURR_CODE());


					new CRUDHandler().executeInsert(PM_EXCHANGE_RATE_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					dataList_PM_EXCHANGE_RATE.add(PM_EXCHANGE_RATE_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			System.out.println("demooooooooooooooooooooooooooooooo ::::" + PM_EXCHANGE_RATE_BEAN.getCER_FIX_EXGE_RATE());
			System.out.println("demooooooooooooooooooooooooooooooo ::::" + PM_EXCHANGE_RATE_BEAN.getCER_AVG_EXGE_RATE());
			PM_EXCHANGE_RATE_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}


	public void validatorCER_EFF_FRM_DT(FacesContext context,
			UIComponent component, Object value) {
		try {

			/*String EFF_FRM_DT = value.toString();
				System.out.println("EFF_FRM_DT : "+EFF_FRM_DT);

				//String str = "Fri Mar 1, 2013 4:30 PM";          
				SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
				Date date = sdf1.parse(EFF_FRM_DT);
				System.out.println("Date Object:" + date);
				SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
				System.out.println("Formatted Date  :" + sdf2.format(date));
				String EFFORT_FROM_DATE=sdf2.format(date);
				System.out.println("EFFORT_FROM_DATE    : "+EFFORT_FROM_DATE);

				System.out.println(" ****** ENTER THE PM_IL_CURRENCY_ACTION ******** ");
				System.out.println("validatorCER_EFF_FRM_DT");*/

			/*
			 * MODIFIED by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.
			 * FM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT((Date) value);*/
			PM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT((Date) value);
			if(PM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT() != null){
				PM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT_STR(new SimpleDateFormat("dd/MM/yyyy").format(PM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT()));
			}
			/*exc_rate_helper.whenValidateCER_EFF_FRM_DT(FM_EXCHANGE_RATE_BEAN);
				COMP_CM_EX_EFF_DT.resetValue();*/
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}	

	/*Added by saritha*/
	
	public void  validatorCER_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value) {
		try {                                             
			/*
			 * MODIFIED by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.
			 * FM_EXCHANGE_RATE_BEAN.setCER_EFF_TO_DT((Date) value);*/
			PM_EXCHANGE_RATE_BEAN.setCER_EFF_TO_DT((Date) value);
			if(PM_EXCHANGE_RATE_BEAN.getCER_EFF_TO_DT().before(PM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT())){
				throw new Exception("To Date should be Greater than From Date");
			}
			if(PM_EXCHANGE_RATE_BEAN.getCER_EFF_TO_DT() != null){
				PM_EXCHANGE_RATE_BEAN.setCER_EFF_TO_DT_STR(new SimpleDateFormat("dd/MM/yyyy").format(PM_EXCHANGE_RATE_BEAN.getCER_EFF_TO_DT()));
			}
			/*exc_rate_helper.whenValidateCER_EFF_FRM_DT(FM_EXCHANGE_RATE_BEAN);
				COMP_CM_EX_EFF_DT.resetValue();*/
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}	
		
	/*End*/
			
	public void validateCURR_FRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {


		PM_CURRENCY_BEAN.setCURR_FRZ_FLAG(CommonUtils.booleanToStriingConvertor((Boolean) value));			

	}

	public void validateEXC_RATE_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		System.out.println("Value   : "+value.toString());
		System.out.println("Before bean Assign  ********");
		System.out.println("FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE_TYPE   : "+FM_EXCHANGE_RATE_BEAN.getCER_EXG_RATE_TYPE());
		/*
		 * MODIFIED by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.
		 * FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE_TYPE((String) value);	*/
		PM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE_TYPE((String) value);	
		System.out.println("After Bean Assign **********");
		System.out.println("FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE_TYPE   : "+PM_EXCHANGE_RATE_BEAN.getCER_EXG_RATE_TYPE());
	
	
		/*
		 * MODIFIED by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.
		 * if(FM_EXCHANGE_RATE_BEAN.getCER_EXG_RATE_TYPE().equalsIgnoreCase("b")){*/
		if(PM_EXCHANGE_RATE_BEAN.getCER_EXG_RATE_TYPE().equalsIgnoreCase("b")){
			
			setExc_rate_label("Buying");
			
			COMP_CM_EX_SELLING_LABEL.setValue("Buying");
			
			System.out.println("getExc_rate_label        :"+getExc_rate_label());
			
			System.out.println("COMP_CM_EX_SELLING_LABEL        :"+COMP_CM_EX_SELLING_LABEL.getValue());
			
		}else{
			
			setExc_rate_label("Selling");
			COMP_CM_EX_SELLING_LABEL.setValue("Selling");
			
			System.out.println("COMP_CM_EX_SELLING_LABEL in else        :"+COMP_CM_EX_SELLING_LABEL.getValue());
			
		}
		
	
	}
	
	/*added by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.*/
	private PM_EXCHANGE_RATE PM_EXCHANGE_RATE_BEAN;
	
	private List<PM_EXCHANGE_RATE> dataList_PM_EXCHANGE_RATE = new ArrayList<PM_EXCHANGE_RATE>();

	public PM_EXCHANGE_RATE getPM_EXCHANGE_RATE_BEAN() {
		return PM_EXCHANGE_RATE_BEAN;
	}

	public void setPM_EXCHANGE_RATE_BEAN(PM_EXCHANGE_RATE pM_EXCHANGE_RATE_BEAN) {
		PM_EXCHANGE_RATE_BEAN = pM_EXCHANGE_RATE_BEAN;
	}

	public List<PM_EXCHANGE_RATE> getDataList_PM_EXCHANGE_RATE() {
		return dataList_PM_EXCHANGE_RATE;
	}

	public void setDataList_PM_EXCHANGE_RATE(
			List<PM_EXCHANGE_RATE> dataList_PM_EXCHANGE_RATE) {
		this.dataList_PM_EXCHANGE_RATE = dataList_PM_EXCHANGE_RATE;
	}
	
	public void validateCER_EXG_RATE(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*eND*/
	
	 /*Added by Janani on 13.06.2018 for FSD_IL_FLA_019*/
	
	private HtmlOutputLabel COMP_CER_CONV_FM_CURR_CODE_LABEL;

	private HtmlInputText COMP_CER_CONV_FM_CURR_CODE;
	
	private HtmlOutputLabel COMP_CER_CONV_TO_CURR_CODE_LABEL;

	private HtmlInputText COMP_CER_CONV_TO_CURR_CODE;

	public HtmlOutputLabel getCOMP_CER_CONV_FM_CURR_CODE_LABEL() {
		return COMP_CER_CONV_FM_CURR_CODE_LABEL;
	}

	public void setCOMP_CER_CONV_FM_CURR_CODE_LABEL(
			HtmlOutputLabel cOMP_CER_CONV_FM_CURR_CODE_LABEL) {
		COMP_CER_CONV_FM_CURR_CODE_LABEL = cOMP_CER_CONV_FM_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CER_CONV_FM_CURR_CODE() {
		return COMP_CER_CONV_FM_CURR_CODE;
	}

	public void setCOMP_CER_CONV_FM_CURR_CODE(
			HtmlInputText cOMP_CER_CONV_FM_CURR_CODE) {
		COMP_CER_CONV_FM_CURR_CODE = cOMP_CER_CONV_FM_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_CER_CONV_TO_CURR_CODE_LABEL() {
		return COMP_CER_CONV_TO_CURR_CODE_LABEL;
	}

	public void setCOMP_CER_CONV_TO_CURR_CODE_LABEL(
			HtmlOutputLabel cOMP_CER_CONV_TO_CURR_CODE_LABEL) {
		COMP_CER_CONV_TO_CURR_CODE_LABEL = cOMP_CER_CONV_TO_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CER_CONV_TO_CURR_CODE() {
		return COMP_CER_CONV_TO_CURR_CODE;
	}

	public void setCOMP_CER_CONV_TO_CURR_CODE(
			HtmlInputText cOMP_CER_CONV_TO_CURR_CODE) {
		COMP_CER_CONV_TO_CURR_CODE = cOMP_CER_CONV_TO_CURR_CODE;
	}
	

	public void validateCER_CONV_FM_CURR_CODE(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_EXCHANGE_RATE_BEAN.setCER_CONV_FM_CURR_CODE((String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validateCER_CONV_TO_CURR_CODE(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_EXCHANGE_RATE_BEAN.setCER_CONV_TO_CURR_CODE((String)value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*End*/
}
