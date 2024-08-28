package com.iii.pel.forms.PILM035_APAC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlDatascroller;
import org.richfaces.event.DataScrollerEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_APPL_COND_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PACOND_COND_CODE_LABEL;

	private HtmlInputText COMP_PACOND_COND_CODE;

	private HtmlOutputLabel COMP_UI_M_PACOND_COND_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PACOND_COND_CODE_DESC;

	private PM_IL_PROD_APPL_COND PM_IL_PROD_APPL_COND_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_APPL_COND_HELPER helper;

	private List<PM_IL_PROD_APPL_COND> dataList_PM_IL_PROD_APPL_COND = new ArrayList<PM_IL_PROD_APPL_COND>();

	/*private UIData dataTable;*/

	public PM_IL_PROD_APPL_COND_ACTION() {

		PM_IL_PROD_APPL_COND_BEAN = new PM_IL_PROD_APPL_COND();
		helper = new PM_IL_PROD_APPL_COND_HELPER();
	}

	public HtmlOutputLabel getCOMP_PACOND_COND_CODE_LABEL() {
		return COMP_PACOND_COND_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PACOND_COND_CODE() {
		return COMP_PACOND_COND_CODE;
	}

	public void setCOMP_PACOND_COND_CODE_LABEL(
			HtmlOutputLabel COMP_PACOND_COND_CODE_LABEL) {
		this.COMP_PACOND_COND_CODE_LABEL = COMP_PACOND_COND_CODE_LABEL;
	}

	public void setCOMP_PACOND_COND_CODE(HtmlInputText COMP_PACOND_COND_CODE) {
		this.COMP_PACOND_COND_CODE = COMP_PACOND_COND_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PACOND_COND_CODE_DESC_LABEL() {
		return COMP_UI_M_PACOND_COND_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PACOND_COND_CODE_DESC() {
		return COMP_UI_M_PACOND_COND_CODE_DESC;
	}

	public void setCOMP_UI_M_PACOND_COND_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PACOND_COND_CODE_DESC_LABEL) {
		this.COMP_UI_M_PACOND_COND_CODE_DESC_LABEL = COMP_UI_M_PACOND_COND_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PACOND_COND_CODE_DESC(
			HtmlInputText COMP_UI_M_PACOND_COND_CODE_DESC) {
		this.COMP_UI_M_PACOND_COND_CODE_DESC = COMP_UI_M_PACOND_COND_CODE_DESC;
	}

	public PM_IL_PROD_APPL_COND getPM_IL_PROD_APPL_COND_BEAN() {
		return PM_IL_PROD_APPL_COND_BEAN;
	}

	public void setPM_IL_PROD_APPL_COND_BEAN(
			PM_IL_PROD_APPL_COND PM_IL_PROD_APPL_COND_BEAN) {
		this.PM_IL_PROD_APPL_COND_BEAN = PM_IL_PROD_APPL_COND_BEAN;
	}

	public List<PM_IL_PROD_APPL_COND> getDataList_PM_IL_PROD_APPL_COND() {
		return dataList_PM_IL_PROD_APPL_COND;
	}

	public void setDataListPM_IL_PROD_APPL_COND(
			List<PM_IL_PROD_APPL_COND> dataList_PM_IL_PROD_APPL_COND) {
		this.dataList_PM_IL_PROD_APPL_COND = dataList_PM_IL_PROD_APPL_COND;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_PROD_APPL_COND_BEAN = new PM_IL_PROD_APPL_COND();
				
				/*Added by Ram on 16/03/2017 for Handling Covercode in Conditions screen*/
				disableAllComponents(false);
				/*End*/
				
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

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				helper.PRE_DELETE(compositeAction);
				new CRUDHandler().executeDelete(PM_IL_PROD_APPL_COND_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PM_IL_PROD_APPL_COND.remove(PM_IL_PROD_APPL_COND_BEAN);
				if (dataList_PM_IL_PROD_APPL_COND.size() > 0) {

					PM_IL_PROD_APPL_COND_BEAN = dataList_PM_IL_PROD_APPL_COND
							.get(0);
				} else if (dataList_PM_IL_PROD_APPL_COND.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_APPL_COND_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		try {
			/*Added by Ram on 16/03/2017 for Handling Condition handling in Datatable*/
			System.out.println("isUPDATE_ALL          "+isUPDATE_ALL());
			if(!isUPDATE_ALL())
			{
			 /*End*/
			if (PM_IL_PROD_APPL_COND_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_APPL_COND_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_PM_IL_PROD_APPL_COND.add(PM_IL_PROD_APPL_COND_BEAN);
			} else if (PM_IL_PROD_APPL_COND_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PROD_APPL_COND_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PM_IL_PROD_APPL_COND_BEAN.setRowSelected(true);
			
			
		}
			/*Added by Ram on 16/03/2017 for Handling Condition handling in Datatable*/
			else
			{
				if (PM_IL_PROD_APPL_COND_BEAN.getROWID() != null
						&& isUPDATE_ALLOWED())
				{
				 
				 Iterator<PM_IL_PROD_APPL_COND> PM_IL_PROD_APPL_COND_itr = dataList_PM_IL_PROD_APPL_COND.iterator();
				 int count = 0;
				 while(PM_IL_PROD_APPL_COND_itr.hasNext())
				 {
					 PM_IL_PROD_APPL_COND bean = PM_IL_PROD_APPL_COND_itr.next();
					
					 if(count >= PM_IL_PROD_APPL_COND_BEAN.getStartIndex() && count <= PM_IL_PROD_APPL_COND_BEAN.getEndindex())
					 {
						 System.out.println("getStartIndex() in save       "+PM_IL_PROD_APPL_COND_BEAN.getStartIndex()+"         "+PM_IL_PROD_APPL_COND_BEAN.getEndindex()+"      "+count);
						 
					 new CRUDHandler().executeUpdate(bean, CommonUtils.getConnection());
					 
					 }
					 count++;
				 }
				 
				 getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save"));
			}
			}
			
		CommonUtils.getConnection().commit();
		/*End*/
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PROD_APPL_COND_BEAN = (PM_IL_PROD_APPL_COND) PM_IL_PROD_APPL_COND_BEAN.getDataTable()
					.getRowData();
			PM_IL_PROD_APPL_COND_BEAN.setRowSelected(true);
			helper.POST_QUERY(compositeAction);
			
			/*Added by Ram on 16/03/2017 for Handling Covercode in Conditions screen*/
			disableAllComponents(true);
			/*End*/
			
			resetAllComponent();
			
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_APPL_COND> PM_IL_PROD_APPL_COND_ITR = dataList_PM_IL_PROD_APPL_COND
				.iterator();
		while (PM_IL_PROD_APPL_COND_ITR.hasNext()) {
			PM_IL_PROD_APPL_COND_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PACOND_COND_CODE.resetValue();
		COMP_UI_M_PACOND_COND_CODE_DESC.resetValue();
		
		COMP_PACOND_COND_CODE_MAIN.resetValue();
		COMP_PACOND_DFLT_YN.resetValue();
		COMP_PACOND_MAND_YN.resetValue();
		COMP_PACOND_COVER_CODE.resetValue();
		
		/*added by raja on 21-03-2017 for set description*/
		COMP_UI_M_PACOND_COVER_CODE_DESC.resetValue();
		/*end*/
	}

	/*public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}*/

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
				if(getPM_IL_PROD_APPL_COND_BEAN().getROWID() != null){
					helper.POST_QUERY(compositeAction);
					
					/*Added by Ram on 16/03/2017 for Handling Covercode in Conditions screen*/
					disableAllComponents(true);
					/*End*/
				}
				setBlockFlag(false);
				
				/*Added by Ram on 16/03/2017 for Handling Condition handling in Datatable*/
				setListDEF_YN(ListItemUtil.getDropDownListValue(CommonUtils
						.getConnection(), "PILM035_APAC", "PM_IL_PROD_APPL_COVER",
						"PM_IL_PROD_APPL_COVER.PAC_DEFAULT_YN", "YESNO"));
				setListMAND_YN(ListItemUtil.getDropDownListValue(CommonUtils
						.getConnection(), "PILM035_APAC", "PM_IL_PROD_APPL_COVER",
						"PM_IL_PROD_APPL_COVER.PAC_DEFAULT_YN", "YESNO"));
				
				PM_IL_PROD_APPL_COND_BEAN.setCurrentPage(PM_IL_PROD_APPL_COND_BEAN.getCOMP_DT_SCROLLER().getPage());
				PM_IL_PROD_APPL_COND_BEAN.setRowsPerPage(PM_IL_PROD_APPL_COND_BEAN.getDataTable().getRows());
				PM_IL_PROD_APPL_COND_BEAN.setStartIndex(0);
				PM_IL_PROD_APPL_COND_BEAN.setEndindex(0);
				
				/*End*/
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public void PACOND_COND_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			System.out.println("Welcome to PACOND_COND_CODE_Validator");
			getPM_IL_PROD_APPL_COND_BEAN().setPACOND_COND_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_PACOND_COND_CODE(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public List<LovBean> lovPACOND_COND_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
					"PM_IL_PROD_APPL_COND", "PACOND_COND_CODE", "IL_COND",null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	/*Added by Ram on 16/03/2017 for Handling Condition handling in Datatable*/
private List<SelectItem> listDEF_YN = new ArrayList<SelectItem>();
private List<SelectItem> listMAND_YN = new ArrayList<SelectItem>();

public List<SelectItem> getListDEF_YN() {
	return listDEF_YN;
}

public void setListDEF_YN(List<SelectItem> listDEF_YN) {
	this.listDEF_YN = listDEF_YN;
}




public List<SelectItem> getListMAND_YN() {
	return listMAND_YN;
}

public void setListMAND_YN(List<SelectItem> listMAND_YN) {
	this.listMAND_YN = listMAND_YN;
}

private boolean DEF_YN_ALL;
 

public boolean isDEF_YN_ALL() {
	return DEF_YN_ALL;
}

public void setDEF_YN_ALL(boolean dEF_YN_ALL) {
	DEF_YN_ALL = dEF_YN_ALL;
}

private boolean UPDATE_ALL;


public boolean isUPDATE_ALL() {
	return UPDATE_ALL;
}

public void setUPDATE_ALL(boolean uPDATE_ALL) {
	UPDATE_ALL = uPDATE_ALL;
}

//private int currentPage = COMP_DT_SCROLLER.getPage(),rowsPerPage = dataTable.getRows(),startIndex=0,endindex=0;




public void PACOND_DFLT_YN_Validator(FacesContext context,
		UIComponent component, Object value) throws ValidatorException {
	try {
		
		getPM_IL_PROD_APPL_COND_BEAN().setPACOND_DFLT_YN((String) value);
		COMP_PACOND_DFLT_YN.resetValue();
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}  
}

public void fireFieldValidationChk(ActionEvent actionEvent) {
	try {
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		
		

		System.out.println("Welcome to PACOND_DFLT_YN_ALL_Validator");
		 boolean chkFlag = false;
		 chkFlag = (boolean)input.getSubmittedValue();
		 String defChk = "N";
		 if(chkFlag)
		 {
			 defChk = "Y";
		 }
		 System.out.println("defChk        "+defChk+"       "+PM_IL_PROD_APPL_COND_BEAN.getCOMP_DT_SCROLLER().getPage()+"      "+PM_IL_PROD_APPL_COND_BEAN.getDataTable().getRows());
		 
		 
		 CommonUtils.setPageIndexing(PM_IL_PROD_APPL_COND_BEAN,PM_IL_PROD_APPL_COND_BEAN.getCOMP_DT_SCROLLER(),PM_IL_PROD_APPL_COND_BEAN.getDataTable());
		 
		     System.out.println("page Start from "+PM_IL_PROD_APPL_COND_BEAN.getStartIndex()+"    Ended to    "+PM_IL_PROD_APPL_COND_BEAN.getEndindex());
		 
		     setDataListPM_IL_PROD_APPL_COND(CommonUtils.returnCheckedList(getDataList_PM_IL_PROD_APPL_COND(), "PACOND_DFLT_YN", defChk,
					 PM_IL_PROD_APPL_COND_BEAN.getStartIndex(),PM_IL_PROD_APPL_COND_BEAN.getEndindex()));
		     
		 getPM_IL_PROD_APPL_COND_BEAN().setPACOND_DFLT_YN(defChk);
		 COMP_PACOND_DFLT_YN.resetValue();
		 setUPDATE_ALL(true);
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}  
}

public void fireFieldValidationMandChk(ActionEvent actionEvent) {
	try {
		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		
		

		System.out.println("Welcome to PACOND_DFLT_YN_ALL_Validator");
		 boolean chkFlag = false;
		 chkFlag = (boolean)input.getSubmittedValue();
		 String defChk = "N";
		 if(chkFlag)
		 {
			 defChk = "Y";
		 }
		 System.out.println("defChk       "+defChk);
		 CommonUtils.setPageIndexing(PM_IL_PROD_APPL_COND_BEAN,PM_IL_PROD_APPL_COND_BEAN.getCOMP_DT_SCROLLER(),PM_IL_PROD_APPL_COND_BEAN.getDataTable());
		 
		 System.out.println("Start Index     "+PM_IL_PROD_APPL_COND_BEAN.getStartIndex()+"       "+PM_IL_PROD_APPL_COND_BEAN.getEndindex());
		 setDataListPM_IL_PROD_APPL_COND(CommonUtils.returnCheckedList(getDataList_PM_IL_PROD_APPL_COND(), "PACOND_FLEX_01", defChk,
				 PM_IL_PROD_APPL_COND_BEAN.getStartIndex(),PM_IL_PROD_APPL_COND_BEAN.getEndindex()));
		 
		 getPM_IL_PROD_APPL_COND_BEAN().setPACOND_FLEX_01(defChk);
		 COMP_PACOND_MAND_YN.resetValue();
		 setUPDATE_ALL(true);
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}  
}
 


public void PACOND_MAND_YN_Validator(FacesContext context,
		UIComponent component, Object value) throws ValidatorException {
	try {
		System.out.println("Welcome to PACOND_MAND_YN_Validator");
		getPM_IL_PROD_APPL_COND_BEAN().setPACOND_FLEX_01((String) value);
		COMP_PACOND_MAND_YN.resetValue();
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}  
}

public void PACOND_COVER_CODE_Validator(FacesContext context,
		UIComponent component, Object value) throws ValidatorException {
	try {
		
		getPM_IL_PROD_APPL_COND_BEAN().setPACOND_COVER_CODE((String) value);
		COMP_PACOND_COVER_CODE.resetValue();
	} catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	} finally {
		try {
			ErrorHelpUtil.getWarningForProcedure(CommonUtils
					.getConnection(), component.getParent().getId(),
					getWarningMap());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}

public List<LovBean> lovPACOND_COVER_CODE(Object currValue) {
	ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
	ListItemUtil listitemutil = new ListItemUtil();
	try {
		/*Commented by raja on 21-03-2017 for set description
		 * 
		 * suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC",
				"PM_IL_PROD_APPL_COVER", "PAC_COVER_CODE", "S", null, null, null,
				null, (String) currValue);
*/
		
		
		/*added by raja on 21-03-2017 for set description*/
		suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
				"PT_IL_POL_ADDL_COVER", "POAC_COVER_CODE", 
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE(), 
				"R", null, null,null, (String) currValue);
		/*end*/
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return suggestionList;
}

private HtmlInputText COMP_PACOND_COND_CODE_MAIN;

public HtmlInputText getCOMP_PACOND_COND_CODE_MAIN() {
	return COMP_PACOND_COND_CODE_MAIN;
}

public void setCOMP_PACOND_COND_CODE_MAIN(
		HtmlInputText cOMP_PACOND_COND_CODE_MAIN) {
	COMP_PACOND_COND_CODE_MAIN = cOMP_PACOND_COND_CODE_MAIN;
}

private HtmlOutputLabel COMP_PACOND_DEFLT_YN_LABEL;


public HtmlOutputLabel getCOMP_PACOND_DEFLT_YN_LABEL() {
	return COMP_PACOND_DEFLT_YN_LABEL;
}

public void setCOMP_PACOND_DEFLT_YN_LABEL(
		HtmlOutputLabel cOMP_PACOND_DEFLT_YN_LABEL) {
	COMP_PACOND_DEFLT_YN_LABEL = cOMP_PACOND_DEFLT_YN_LABEL;
}

private HtmlSelectOneMenu COMP_PACOND_DFLT_YN;
private HtmlSelectOneMenu COMP_PACOND_MAND_YN;
private HtmlInputText COMP_PACOND_COVER_CODE;
private HtmlOutputLabel COMP_PACOND_MAND_YN_LABEL;
private HtmlOutputLabel COMP_PACOND_COVER_CODE_LABEL;
private HtmlOutputLabel COMP_PACOND_DISP_SEQ_NO_LABEL;
private HtmlInputText COMP_PACOND_DISP_SEQ_NO;
/*private HtmlDatascroller COMP_DT_SCROLLER;*/

public HtmlSelectOneMenu getCOMP_PACOND_DFLT_YN() {
	return COMP_PACOND_DFLT_YN;
}

public void setCOMP_PACOND_DFLT_YN(HtmlSelectOneMenu cOMP_PACOND_DFLT_YN) {
	COMP_PACOND_DFLT_YN = cOMP_PACOND_DFLT_YN;
}

public HtmlSelectOneMenu getCOMP_PACOND_MAND_YN() {
	return COMP_PACOND_MAND_YN;
}

public void setCOMP_PACOND_MAND_YN(HtmlSelectOneMenu cOMP_PACOND_MAND_YN) {
	COMP_PACOND_MAND_YN = cOMP_PACOND_MAND_YN;
}

public HtmlInputText getCOMP_PACOND_COVER_CODE() {
	return COMP_PACOND_COVER_CODE;
}

public void setCOMP_PACOND_COVER_CODE(HtmlInputText cOMP_PACOND_COVER_CODE) {
	COMP_PACOND_COVER_CODE = cOMP_PACOND_COVER_CODE;
}

public HtmlOutputLabel getCOMP_PACOND_MAND_YN_LABEL() {
	return COMP_PACOND_MAND_YN_LABEL;
}

public void setCOMP_PACOND_MAND_YN_LABEL(
		HtmlOutputLabel cOMP_PACOND_MAND_YN_LABEL) {
	COMP_PACOND_MAND_YN_LABEL = cOMP_PACOND_MAND_YN_LABEL;
}

public HtmlOutputLabel getCOMP_PACOND_COVER_CODE_LABEL() {
	return COMP_PACOND_COVER_CODE_LABEL;
}

public void setCOMP_PACOND_COVER_CODE_LABEL(
		HtmlOutputLabel cOMP_PACOND_COVER_CODE_LABEL) {
	COMP_PACOND_COVER_CODE_LABEL = cOMP_PACOND_COVER_CODE_LABEL;
}

public HtmlOutputLabel getCOMP_PACOND_DISP_SEQ_NO_LABEL() {
	return COMP_PACOND_DISP_SEQ_NO_LABEL;
}

public void setCOMP_PACOND_DISP_SEQ_NO_LABEL(
		HtmlOutputLabel cOMP_PACOND_DISP_SEQ_NO_LABEL) {
	COMP_PACOND_DISP_SEQ_NO_LABEL = cOMP_PACOND_DISP_SEQ_NO_LABEL;
}
 
public HtmlInputText getCOMP_PACOND_DISP_SEQ_NO() {
	return COMP_PACOND_DISP_SEQ_NO;
}

public void setCOMP_PACOND_DISP_SEQ_NO(HtmlInputText cOMP_PACOND_DISP_SEQ_NO) {
	COMP_PACOND_DISP_SEQ_NO = cOMP_PACOND_DISP_SEQ_NO;
}

/*
public HtmlDatascroller getCOMP_DT_SCROLLER() {
	return COMP_DT_SCROLLER;
}

public void setCOMP_DT_SCROLLER(HtmlDatascroller cOMP_DT_SCROLLER) {
	COMP_DT_SCROLLER = cOMP_DT_SCROLLER;
}*/

public void disableAllComponents(boolean disabled)
{
	COMP_PACOND_COND_CODE_MAIN.setDisabled(disabled);
	COMP_PACOND_DFLT_YN.setDisabled(disabled);
	COMP_PACOND_MAND_YN.setDisabled(disabled);
	COMP_PACOND_COVER_CODE.setDisabled(disabled);
	COMP_PACOND_DISP_SEQ_NO.setDisabled(disabled);
}


public void PACOND_DISP_SEQ_NO_Validator(FacesContext context,
		UIComponent component, Object value) throws ValidatorException {
	try {
		System.out.println("Welcome to PACOND_DISP_SEQ_NO_Validator");
		
		helper.WHEN_VALIDATE_ITEM_PACOND_DISP_SEQ_NO(compositeAction,(int) value);
		getPM_IL_PROD_APPL_COND_BEAN().setPACOND_DISP_SEQ_NO((int) value);
	} catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	} finally {
		try {
			ErrorHelpUtil.getWarningForProcedure(CommonUtils
					.getConnection(), component.getParent().getId(),
					getWarningMap());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}
/*End*/



/*added by raja on 21-03-2017 for set description*/

private HtmlInputText COMP_UI_M_PACOND_COVER_CODE_DESC;

public HtmlInputText getCOMP_UI_M_PACOND_COVER_CODE_DESC() {
	return COMP_UI_M_PACOND_COVER_CODE_DESC;
}

public void setCOMP_UI_M_PACOND_COVER_CODE_DESC(
		HtmlInputText cOMP_UI_M_PACOND_COVER_CODE_DESC) {
	COMP_UI_M_PACOND_COVER_CODE_DESC = cOMP_UI_M_PACOND_COVER_CODE_DESC;
}

/*end*/



	
}
