package com.iii.pel.forms.PILP042_APAC;

import java.sql.SQLException;
import java.util.ArrayList;
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
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_FUND_TRAN_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_FTD_FUND_CODE_LABEL;

	private HtmlInputText COMP_FTD_FUND_CODE;

	private HtmlOutputLabel COMP_UI_M_PFTD_FUND_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PFTD_FUND_DESC;

	private HtmlOutputLabel COMP_FTD_UNIT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_FTD_UNIT_TYPE;

	private HtmlOutputLabel COMP_FTD_FUND_PERC_LABEL;

	private HtmlInputText COMP_FTD_FUND_PERC;

	private HtmlOutputLabel COMP_FTD_UNIT_PUR_PRICE_LABEL;

	private HtmlInputText COMP_FTD_UNIT_PUR_PRICE;

	private HtmlOutputLabel COMP_FTD_NO_OF_UNITS_LABEL;

	private HtmlInputText COMP_FTD_NO_OF_UNITS;

	private HtmlOutputLabel COMP_FTD_UNIT_SEL_PRICE_LABEL;

	private HtmlInputText COMP_FTD_UNIT_SEL_PRICE;

	private HtmlOutputLabel COMP_FTD_UNIT_LC_AMT_LABEL;

	private HtmlInputText COMP_FTD_UNIT_LC_AMT;

	private PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN;

	private PT_IL_FUND_TRAN_DTL_1 tempBean;

	private UIData dataTable;

	private List<PT_IL_FUND_TRAN_DTL> dataTableList;

	private List codeList = new ArrayList();

	private int prevRowIndex;

	private int currentpage;

	private int recordsperPage = 5;

	private int lastUpdateRowIndex;

	ArrayList deletedIndexList;

	PT_IL_FUND_TRAN_DTL_DELEGATE delegate = new PT_IL_FUND_TRAN_DTL_DELEGATE();

	PT_IL_FUND_TRAN_DTL_HELPER helper = new PT_IL_FUND_TRAN_DTL_HELPER();

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();

	private List<SelectItem> unitTypeList = new ArrayList<SelectItem>();
	
	public PILP042_APAC_COMPOSITE_ACTION compositeAction ;
	
	private HtmlCommandButton COMP_UI_B_CREATE;
	private HtmlCommandButton COMP_UI_B_DELETE;
	private HtmlCommandButton COMP_UI_B_UPDATE;
	
	

	public PT_IL_FUND_TRAN_DTL_ACTION() {
		PT_IL_FUND_TRAN_DTL_BEAN = new PT_IL_FUND_TRAN_DTL();
		tempBean = new PT_IL_FUND_TRAN_DTL_1();
	unitTypeList = delegate.comboBoxValues("PILP042_APAC",
		"PT_IL_FUND_TRAN_DTL", "PT_IL_FUND_TRAN_DTL.FTD_UNIT_TYPE",
				"IL_FUND_DIR");		
		prevRowIndex = 0;
		currentpage = 1;
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_FTD_FUND_CODE_LABEL() {
		return COMP_FTD_FUND_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FTD_FUND_CODE() {
		return COMP_FTD_FUND_CODE;
	}

	public void setCOMP_FTD_FUND_CODE_LABEL(
			HtmlOutputLabel COMP_FTD_FUND_CODE_LABEL) {
		this.COMP_FTD_FUND_CODE_LABEL = COMP_FTD_FUND_CODE_LABEL;
	}

	public void setCOMP_FTD_FUND_CODE(HtmlInputText COMP_FTD_FUND_CODE) {
		this.COMP_FTD_FUND_CODE = COMP_FTD_FUND_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PFTD_FUND_DESC_LABEL() {
		return COMP_UI_M_PFTD_FUND_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PFTD_FUND_DESC() {
		return COMP_UI_M_PFTD_FUND_DESC;
	}

	public void setCOMP_UI_M_PFTD_FUND_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PFTD_FUND_DESC_LABEL) {
		this.COMP_UI_M_PFTD_FUND_DESC_LABEL = COMP_UI_M_PFTD_FUND_DESC_LABEL;
	}

	public void setCOMP_UI_M_PFTD_FUND_DESC(
			HtmlInputText COMP_UI_M_PFTD_FUND_DESC) {
		this.COMP_UI_M_PFTD_FUND_DESC = COMP_UI_M_PFTD_FUND_DESC;
	}

	public HtmlOutputLabel getCOMP_FTD_UNIT_TYPE_LABEL() {
		return COMP_FTD_UNIT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FTD_UNIT_TYPE() {
		return COMP_FTD_UNIT_TYPE;
	}

	public void setCOMP_FTD_UNIT_TYPE_LABEL(
			HtmlOutputLabel COMP_FTD_UNIT_TYPE_LABEL) {
		this.COMP_FTD_UNIT_TYPE_LABEL = COMP_FTD_UNIT_TYPE_LABEL;
	}

	public void setCOMP_FTD_UNIT_TYPE(HtmlSelectOneMenu COMP_FTD_UNIT_TYPE) {
		this.COMP_FTD_UNIT_TYPE = COMP_FTD_UNIT_TYPE;
	}

	public HtmlOutputLabel getCOMP_FTD_FUND_PERC_LABEL() {
		return COMP_FTD_FUND_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FTD_FUND_PERC() {
		return COMP_FTD_FUND_PERC;
	}

	public void setCOMP_FTD_FUND_PERC_LABEL(
			HtmlOutputLabel COMP_FTD_FUND_PERC_LABEL) {
		this.COMP_FTD_FUND_PERC_LABEL = COMP_FTD_FUND_PERC_LABEL;
	}

	public void setCOMP_FTD_FUND_PERC(HtmlInputText COMP_FTD_FUND_PERC) {
		this.COMP_FTD_FUND_PERC = COMP_FTD_FUND_PERC;
	}

	public HtmlOutputLabel getCOMP_FTD_UNIT_PUR_PRICE_LABEL() {
		return COMP_FTD_UNIT_PUR_PRICE_LABEL;
	}

	public HtmlInputText getCOMP_FTD_UNIT_PUR_PRICE() {
		return COMP_FTD_UNIT_PUR_PRICE;
	}

	public void setCOMP_FTD_UNIT_PUR_PRICE_LABEL(
			HtmlOutputLabel COMP_FTD_UNIT_PUR_PRICE_LABEL) {
		this.COMP_FTD_UNIT_PUR_PRICE_LABEL = COMP_FTD_UNIT_PUR_PRICE_LABEL;
	}

	public void setCOMP_FTD_UNIT_PUR_PRICE(HtmlInputText COMP_FTD_UNIT_PUR_PRICE) {
		this.COMP_FTD_UNIT_PUR_PRICE = COMP_FTD_UNIT_PUR_PRICE;
	}

	public HtmlOutputLabel getCOMP_FTD_NO_OF_UNITS_LABEL() {
		return COMP_FTD_NO_OF_UNITS_LABEL;
	}

	public HtmlInputText getCOMP_FTD_NO_OF_UNITS() {
		return COMP_FTD_NO_OF_UNITS;
	}

	public void setCOMP_FTD_NO_OF_UNITS_LABEL(
			HtmlOutputLabel COMP_FTD_NO_OF_UNITS_LABEL) {
		this.COMP_FTD_NO_OF_UNITS_LABEL = COMP_FTD_NO_OF_UNITS_LABEL;
	}

	public void setCOMP_FTD_NO_OF_UNITS(HtmlInputText COMP_FTD_NO_OF_UNITS) {
		this.COMP_FTD_NO_OF_UNITS = COMP_FTD_NO_OF_UNITS;
	}

	public HtmlOutputLabel getCOMP_FTD_UNIT_SEL_PRICE_LABEL() {
		return COMP_FTD_UNIT_SEL_PRICE_LABEL;
	}

	public HtmlInputText getCOMP_FTD_UNIT_SEL_PRICE() {
		return COMP_FTD_UNIT_SEL_PRICE;
	}

	public void setCOMP_FTD_UNIT_SEL_PRICE_LABEL(
			HtmlOutputLabel COMP_FTD_UNIT_SEL_PRICE_LABEL) {
		this.COMP_FTD_UNIT_SEL_PRICE_LABEL = COMP_FTD_UNIT_SEL_PRICE_LABEL;
	}

	public void setCOMP_FTD_UNIT_SEL_PRICE(HtmlInputText COMP_FTD_UNIT_SEL_PRICE) {
		this.COMP_FTD_UNIT_SEL_PRICE = COMP_FTD_UNIT_SEL_PRICE;
	}

	public HtmlOutputLabel getCOMP_FTD_UNIT_LC_AMT_LABEL() {
		return COMP_FTD_UNIT_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_FTD_UNIT_LC_AMT() {
		return COMP_FTD_UNIT_LC_AMT;
	}

	public void setCOMP_FTD_UNIT_LC_AMT_LABEL(
			HtmlOutputLabel COMP_FTD_UNIT_LC_AMT_LABEL) {
		this.COMP_FTD_UNIT_LC_AMT_LABEL = COMP_FTD_UNIT_LC_AMT_LABEL;
	}

	public void setCOMP_FTD_UNIT_LC_AMT(HtmlInputText COMP_FTD_UNIT_LC_AMT) {
		this.COMP_FTD_UNIT_LC_AMT = COMP_FTD_UNIT_LC_AMT;
	}

	public PT_IL_FUND_TRAN_DTL getPT_IL_FUND_TRAN_DTL_BEAN() {
		return PT_IL_FUND_TRAN_DTL_BEAN;
	}

	public void setPT_IL_FUND_TRAN_DTL_BEAN(
			PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN) {
		this.PT_IL_FUND_TRAN_DTL_BEAN = PT_IL_FUND_TRAN_DTL_BEAN;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public List<PT_IL_FUND_TRAN_DTL> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PT_IL_FUND_TRAN_DTL> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public int getRecordsperPage() {
		return recordsperPage;
	}

	public void setRecordsperPage(int recordsperPage) {
		this.recordsperPage = recordsperPage;
	}

	public List getCodeList() {
		return codeList;
	}

	public void setCodeList(List codeList) {
		this.codeList = codeList;
	}

	public ArrayList<Integer> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Integer> selectedList) {
		this.selectedList = selectedList;
	}

	/**
	 * Grid Tab Listener is used to update Component Values.
	 */
	public void gridtabListener() {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PT_IL_FUND_TRAN_DTL gridValueBean = null;
		System.out.println(lastUpdateRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdateRowIndex != -1) {
				if (lastUpdateRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						System.out.println("GRID TAB LISTENER");
						// Get the bean based on row index
						gridValueBean = (PT_IL_FUND_TRAN_DTL) dataTableList
								.get(prevRowIndex);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {

							rowUpdated = delegate.updateData(gridValueBean);
							getWarningMap().put("current", "Record Updated");
						} else {

							rowUpdated = delegate.updateData(gridValueBean);
							getWarningMap().put("current", "Record Inserted");

						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		return;
	}

	/**
	 * Used For inserting & Updating Values after Tabbing out of last column
	 */
	public void lastColumnListener() {

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PT_IL_FUND_TRAN_DTL gridValueBean = null;
		//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]

	//	ControlBean controlBean = new ControlBean();
		try {

			// Get the bean based on row index
			gridValueBean = (PT_IL_FUND_TRAN_DTL) dataTableList
					.get(currRowIndex);

			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				gridValueBean.setFTD_TRAN_FLAG("S");
				gridValueBean.setFTD_TRAN_TYPE("H");
				//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]

				gridValueBean.setFTD_UPD_DT(new CommonUtils().getCurrentDate());
				gridValueBean.setFTD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Updated");
			} else {

				helper.preInsert(gridValueBean,compositeAction);
				rowUpdated = delegate.updateData(gridValueBean);
				getWarningMap().put("current", "Record Inserted");
			}
			lastUpdateRowIndex = currRowIndex;

		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}
		return;
	}

	
	/**
	 * Used for getting list of values for Medical Exam Code
	 * 
	 * @param obj
	 * @return
	 */
	public List suggestionAction(Object obj) {
		System.out.println("IN THE LOV*****************");
		String code = (String) obj;

		codeList = delegate.fetchCodeList(code, codeList);
		return codeList;
	}

	/**
	 * Used for getting list of values for Medical Exam Description
	 * 
	 * @param event
	 */
	public void getCodeDesc(ActionEvent event) {
		CommonUtils.clearMaps(this);
		COMP_UI_M_PFTD_FUND_DESC.setSubmittedValue(null);
		List<PT_IL_FUND_TRAN_DTL_1> tempList = compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
		.getDataTableList1();

		if (COMP_FTD_FUND_CODE.getSubmittedValue() != null) {
			String code = (String) COMP_FTD_FUND_CODE.getSubmittedValue();
			/** [ Mallika 19-Mar-09  System should not allow to select same fund code from which
			 *  the actual switching is done. */
			for (PT_IL_FUND_TRAN_DTL_1 tempBean : tempList) {
				if ("Y".equals(tempBean.getFTD_SELECT_YN())) {
					if (code.equals(tempBean.getFTD_FUND_CODE_1())) {
						String errorMessage = Messages.getString("messageProperties_PILP042_APAC", "PILP042_APAC$PT_IL_FUND_TRAN_DTL_1$ErrorMessage$caption");
						getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,errorMessage);
					}
				}
			}
			
			String codeDesc = delegate.getCodeDesc(code, codeList);
			
			PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl=this.getPT_IL_FUND_TRAN_DTL_BEAN();
			pt_il_fund_tran_dtl.setUI_M_PFTD_FUND_DESC(codeDesc);
//			COMP_UI_M_PFTD_FUND_DESC.setSubmittedValue(codeDesc);

		}
	}

	public void selectedCheckbox(ActionEvent event) {
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

		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = dataTableList.get(row);

		if (selected.equals("true"))
			pt_il_fund_tran_dtl.setSelected(true);
		else
			pt_il_fund_tran_dtl.setSelected(false);
		System.out.println("SELETED LIST" + selectedList);
	}

	
	
	 public void saveData() {
	    	String message = null;
	    	//CommonUtils.clearMaps(this);
		try {
		    if (getPT_IL_FUND_TRAN_DTL_BEAN().getROWID() != null) {
			if(isUPDATE_ALLOWED()){
	        	    	new CRUDHandler().executeUpdate(PT_IL_FUND_TRAN_DTL_BEAN,CommonUtils.getConnection());
	        	    	getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
	        	    	message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
			}
		    } else {
			if(isINSERT_ALLOWED()){
				       helper.preInsert(PT_IL_FUND_TRAN_DTL_BEAN,compositeAction);
	        	    	if(PT_IL_FUND_TRAN_DTL_BEAN.getFTD_SYS_ID() != null){
	        	    		new CRUDHandler().executeInsert(PT_IL_FUND_TRAN_DTL_BEAN,CommonUtils.getConnection());
	        	    		message = Messages.getString("messageProperties","errorPanel$message$save");
	        	    	}else{
	        	    		throw new Exception("Select Switching fund code and Percentage");
	        	    	}
			 }
		    }
		    CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("SAVE_RECORD",message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	    }
	

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validator_FTD_FUND_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		try{
		PT_IL_FUND_TRAN_DTL_BEAN.setFTD_FUND_CODE((String)value);
		compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
		.getCOMP_UI_M_STATUS_BUT().setDisabled(false);
			/*List<PT_IL_FUND_TRAN_DTL_1> tempList = compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getDataTableList1();*/
			
			//for(PT_IL_FUND_TRAN_DTL_1 dtlBean : tempList){
				setTempBean(compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN());
			//}
		helper.when_validate_item_FTD_FUND_CODE(compositeAction);
		if(dataTableList!=null){
			for(int i=0;i<dataTableList.size();i++)
			{
				PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl12=dataTableList.get(i);
				if(!pt_il_fund_tran_dtl12.isFundAllocated())
				{
					PT_IL_FUND_TRAN_DTL_1 upperListBean =executeUpdate(pt_il_fund_tran_dtl12);
					if(upperListBean!=null)
					{
						try{
//					delegate.updateData(upperListBean);
//					lastColumnListener();Commented For Grid Standardisation. 
						}
						catch(Exception e){e.printStackTrace();}
					}
					else
					{
//				lastColumnListener();Commented For Grid Standardisation. 
					}
					pt_il_fund_tran_dtl12.setFundAllocated(true);
				}
			}
			
		}
		COMP_FTD_UNIT_PUR_PRICE.resetValue();
		COMP_FTD_UNIT_SEL_PRICE.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

		public void listenerunitType(ActionEvent event) {
			try {
				UIInput input = (UIInput) event.getComponent().getParent();
				String inputData = input.getSubmittedValue().toString();
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_UNIT_TYPE(inputData);
				helper.when_list_changed_UnitType(compositeAction);
				COMP_FTD_UNIT_LC_AMT.resetValue();
				COMP_FTD_NO_OF_UNITS.resetValue();
				ErrorHelpUtil.validate(input, getErrorMap());
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						exc.getMessage());
			}
		
		}
		
		/*
		 * public void validator_FTD_FUND_PERC(FacesContext context,
				UIComponent component, Object value) throws ValidatorException,
				SQLException, Exception {*/
		public void validator_FTD_FUND_PERC(ActionEvent event) {
			
			UIInput input = (UIInput) event.getComponent().getParent();
			Double inputData = Double.valueOf(input.getSubmittedValue().toString());
		
			try {
				
			PT_IL_FUND_TRAN_DTL_BEAN.setFTD_FUND_PERC((Double)inputData);
			helper.when_validate_iteM_FTD_FUND_PERC(compositeAction);
			//COMP_UI_M_FUND_PERC_P.resetValue();
			COMP_FTD_UNIT_LC_AMT.resetValue();
			COMP_FTD_NO_OF_UNITS.resetValue();
			COMP_FTD_FUND_PERC.resetValue();
			}catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
			}
		}

	public void allocationPercentageWhenValidate(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		if (COMP_FTD_FUND_PERC.getSubmittedValue() != null) {

			double percentage = Double.parseDouble((String) COMP_FTD_FUND_PERC
					.getSubmittedValue());
			PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl=getPT_IL_FUND_TRAN_DTL_BEAN();
			pt_il_fund_tran_dtl.setFTD_FUND_PERC(percentage);
			//helper.fundPercentageWhenValidate(compositeAction);

			compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
					.getCOMP_UI_M_STATUS_BUT().setDisabled(false);
						List tempList = compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN()
					.getDataTableList1();
			//Iterator<PT_IL_FUND_TRAN_DTL_1> iterator = tempList.iterator(); Not Used

			//Iterator<PT_IL_FUND_TRAN_DTL> iterator2 = dataTableList.iterator(); Not Used
			if(dataTableList!=null){
				for(int i=0;i<dataTableList.size();i++)
				{
					PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl12=dataTableList.get(i);
					if(!pt_il_fund_tran_dtl12.isFundAllocated())
					{
						PT_IL_FUND_TRAN_DTL_1 upperListBean =executeUpdate(pt_il_fund_tran_dtl12);
						if(upperListBean!=null)
						{
							try{
//						delegate.updateData(upperListBean);
//						lastColumnListener();Commented For Grid Standardisation. 
							}
							catch(Exception e){e.printStackTrace();}
						}
						else
						{
//					lastColumnListener();Commented For Grid Standardisation. 
						}
						pt_il_fund_tran_dtl12.setFundAllocated(true);
					}
				}
				
			}			
			/*while (iterator2.hasNext()) {

				PT_IL_FUND_TRAN_DTL downBean = iterator2.next();
				while (iterator.hasNext()) {
					PT_IL_FUND_TRAN_DTL_1 upperBean = iterator.next();
					if (downBean.getFTD_FUND_CODE().equals(
							upperBean.getFTD_FUND_CODE())) {
						upperBean.setFTD_NO_OF_UNITS(upperBean
								.getFTD_NO_OF_UNITS()
								+ downBean.getFTD_NO_OF_UNITS());
						System.out.println("FTD_NO_OF_UNITS :"+upperBean.getFTD_NO_OF_UNITS());
						upperBean.setFTD_UNIT_LC_AMT(upperBean
								.getFTD_UNIT_LC_AMT()
								+ downBean.getFTD_UNIT_LC_AMT());
						upperBean.setFTD_TRAN_TYPE("H");
						System.out.println("ROW ID IS :"+upperBean.getROWID());
						System.out.println("FTD_UNIT_LC_AMT :"+upperBean.getFTD_UNIT_LC_AMT());
						try {
							delegate.updateData(upperBean);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else if(!downBean.getFTD_FUND_CODE().equals(upperBean.getFTD_FUND_CODE()))
					{
						lastColumnListener();
					}
					
				}
			}*/

		
		}

	}
	public PT_IL_FUND_TRAN_DTL_1 executeUpdate(PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl)
	{
		PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl_1=null;
		List<PT_IL_FUND_TRAN_DTL_1> list =compositeAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getDataTableList1();
		for(int idx=0;idx<list.size();idx++)
		{
			PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl_12=list.get(idx);
			if(pt_il_fund_tran_dtl.getFTD_FUND_CODE().equals(pt_il_fund_tran_dtl_12.getFTD_FUND_CODE_1()))
			{
				pt_il_fund_tran_dtl_1=pt_il_fund_tran_dtl_12;
				/*pt_il_fund_tran_dtl_1.setFTD_NO_OF_UNITS(pt_il_fund_tran_dtl_1
						.getFTD_NO_OF_UNITS()
						+ pt_il_fund_tran_dtl.getFTD_NO_OF_UNITS());
				
				pt_il_fund_tran_dtl_1.setFTD_UNIT_LC_AMT(pt_il_fund_tran_dtl_1
						.getFTD_UNIT_LC_AMT()
						+ pt_il_fund_tran_dtl.getFTD_UNIT_LC_AMT());*/
				pt_il_fund_tran_dtl_1.setFTD_TRAN_TYPE("H");
				
				
				break;
			}
		}
		return pt_il_fund_tran_dtl_1;
	}
	public void unitBuyPriceWhenValidate(FacesContext context,
			UIComponent component, Object value) {

		if (COMP_FTD_UNIT_PUR_PRICE.getSubmittedValue() != null) {

	
			double buyPrice = Double
					.parseDouble((String) COMP_FTD_UNIT_PUR_PRICE
							.getSubmittedValue());

		
			PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl=this.getPT_IL_FUND_TRAN_DTL_BEAN();
			pt_il_fund_tran_dtl.setFTD_UNIT_PUR_PRICE(buyPrice);

		}

	}

	public void noOfUnitsWhenValidate(FacesContext context,
			UIComponent component, Object value) {

		if (COMP_FTD_NO_OF_UNITS.getSubmittedValue() != null) {

			double noOfUnits = Double.parseDouble((String) COMP_FTD_NO_OF_UNITS
					.getSubmittedValue());
			
			PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl=this.getPT_IL_FUND_TRAN_DTL_BEAN();
			pt_il_fund_tran_dtl.setFTD_NO_OF_UNITS(noOfUnits);

		}

	}

	public void unitSellPriceWhenValidate(FacesContext context,
			UIComponent component, Object value) {

		if (COMP_FTD_UNIT_SEL_PRICE.getSubmittedValue() != null) {

			double sellPrice = Double
					.parseDouble((String) COMP_FTD_UNIT_SEL_PRICE
							.getSubmittedValue());
			
			PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl=this.getPT_IL_FUND_TRAN_DTL_BEAN();
			pt_il_fund_tran_dtl.setFTD_UNIT_SEL_PRICE(sellPrice);

		}

	}

	public void fundValueWhenValidate(FacesContext context,
			UIComponent component, Object value) {

		if (COMP_FTD_UNIT_LC_AMT.getSubmittedValue() != null) {

			double fundValue = Double.parseDouble((String) COMP_FTD_UNIT_LC_AMT
					.getSubmittedValue());
			PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl=this.getPT_IL_FUND_TRAN_DTL_BEAN();
			pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT(fundValue);
	
		}

	}

	// [ Added for grid implementation change, Added by: Rajesh Kundala, Dated: 17-Feb-2009
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
	// Added for grid implementation change, Added by: Rajesh Kundala, Dated: 17-Feb-2009 ]
	
	public List<SelectItem> getUnitTypeList() {
		return unitTypeList;
	}

	public void setUnitTypeList(List<SelectItem> unitTypeList) {
		this.unitTypeList = unitTypeList;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public PT_IL_FUND_TRAN_DTL_1 getTempBean() {
		return tempBean;
	}

	public void setTempBean(PT_IL_FUND_TRAN_DTL_1 tempBean) {
		this.tempBean = tempBean;
	}
	// display method added by Akash Singh date:-8july2011
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			if (dataTableList.size() != 0) {
				PT_IL_FUND_TRAN_DTL_BEAN = (PT_IL_FUND_TRAN_DTL)dataTable
						.getRowData();
			}
			resetAllComponent();
			// Reset selection for other beans
			resetSelectedRow();
			PT_IL_FUND_TRAN_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap()
					.put(com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	public void addRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (dataTableList == null){
				dataTableList = new ArrayList<PT_IL_FUND_TRAN_DTL>();
			}
			if (isINSERT_ALLOWED()) {
				PT_IL_FUND_TRAN_DTL_BEAN = new PT_IL_FUND_TRAN_DTL();
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

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PT_IL_FUND_TRAN_DTL_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_FUND_TRAN_DTL_BEAN,
							CommonUtils.getConnection());
					dataTableList.remove(PT_IL_FUND_TRAN_DTL_BEAN);
				}

				if (dataTableList.size() > 0) {
					setPT_IL_FUND_TRAN_DTL_BEAN(dataTableList.get(0));
					PT_IL_FUND_TRAN_DTL_BEAN.setRowSelected(true);
				} else {
					addRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
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
	}

	public String post() {
		String message = null;
		Long parentSysId = null;
		Long sysId = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			getErrorMap().clear();

			if (PT_IL_FUND_TRAN_DTL_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					// Code copied from last column listener
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TRAN_FLAG("S");
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TRAN_TYPE("H");
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_UPD_DT(new CommonUtils().getCurrentDate());
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
					
					// Updating data into database
					handler.executeUpdate(PT_IL_FUND_TRAN_DTL_BEAN,
							CommonUtils.getConnection());
					// Preparing message
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put("post", message);
				} else {
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put("post", message);
				}
			} else {
				if (isINSERT_ALLOWED()) {
					// Copied code from last column listener
					parentSysId = compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
							.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_SYS_ID();
					sysId = helper.preInsertValidation();
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_CR_DT(new CommonUtils().getCurrentDate());
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TRAN_SYS_ID(parentSysId);
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TRAN_FLAG("B");
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TRAN_TYPE("H");
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_POL_SYS_ID(compositeAction
							.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
							.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_POL_SYS_ID());
					PT_IL_FUND_TRAN_DTL_BEAN.setFTD_SYS_ID(sysId);
					helper.preInsert(PT_IL_FUND_TRAN_DTL_BEAN,compositeAction);
					
					handler.executeInsert(PT_IL_FUND_TRAN_DTL_BEAN,
							CommonUtils.getConnection());
					// Preparing message
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put("post", message);
					
					
					dataTableList.add(PT_IL_FUND_TRAN_DTL_BEAN);
				} else {
					getErrorMap().clear();
					message = Messages.getString(PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put("post", message);
				}
				compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_GET_FUND().setDisabled(true);
			}
			resetAllComponent();
			resetSelectedRow();
			PT_IL_FUND_TRAN_DTL_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
		
		return null;
	}
     

	private void resetSelectedRow() {
		Iterator<PT_IL_FUND_TRAN_DTL> iterator = dataTableList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	public void resetAllComponent() {
		COMP_FTD_FUND_CODE.resetValue();
		COMP_UI_M_PFTD_FUND_DESC.resetValue();
		COMP_FTD_FUND_PERC.resetValue();		
		COMP_FTD_UNIT_TYPE.resetValue();
		COMP_FTD_UNIT_PUR_PRICE.resetValue();
		COMP_FTD_NO_OF_UNITS.resetValue();
		COMP_FTD_UNIT_SEL_PRICE.resetValue();
		COMP_FTD_UNIT_LC_AMT.resetValue();

	}
	

	/**
	 * Instantiates all components in PT_IL_FUND_TRAN_DTL_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_FTD_FUND_CODE				 = new HtmlInputText();
		COMP_UI_M_PFTD_FUND_DESC			 = new HtmlInputText();
		COMP_FTD_FUND_PERC				 = new HtmlInputText();
		COMP_FTD_UNIT_PUR_PRICE				 = new HtmlInputText();
		COMP_FTD_NO_OF_UNITS				 = new HtmlInputText();
		COMP_FTD_UNIT_SEL_PRICE				 = new HtmlInputText();
		COMP_FTD_UNIT_LC_AMT				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_FTD_UNIT_TYPE				 = new HtmlSelectOneMenu();
		COMP_UI_B_CREATE = new HtmlCommandButton();
		COMP_UI_B_DELETE = new HtmlCommandButton();
		COMP_UI_B_UPDATE = new HtmlCommandButton();
	}
	
	public String printButAction(){
		CommonUtils.setGlobalVariable("CALL_FORM_PRINT","PILP042_APAC");
		return "PILP045_APAC";
	}


	
	public void DisabledAllComponent(boolean disabled ) {
		COMP_FTD_FUND_CODE.setDisabled(disabled);
		COMP_UI_M_PFTD_FUND_DESC.setDisabled(disabled);
		COMP_FTD_FUND_PERC.setDisabled(disabled);		
		COMP_FTD_UNIT_TYPE.setDisabled(disabled);
		COMP_FTD_UNIT_PUR_PRICE.setDisabled(disabled);
		COMP_FTD_NO_OF_UNITS.setDisabled(disabled);
		COMP_FTD_UNIT_SEL_PRICE.setDisabled(disabled);
		COMP_FTD_UNIT_LC_AMT.setDisabled(disabled);
	/*	COMP_UI_B_CREATE.setDisabled(disabled);
		COMP_UI_B_DELETE.setDisabled(disabled);
		COMP_UI_B_UPDATE.setDisabled(disabled);*/
	}
}
