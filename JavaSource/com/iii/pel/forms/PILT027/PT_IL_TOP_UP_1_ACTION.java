package com.iii.pel.forms.PILT027;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_TOP_UP_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_TU_POL_NO_LABEL;

	private HtmlInputText COMP_TU_POL_NO;

	private HtmlOutputLabel COMP_TU_LC_TOPUP_DEP_AMT_LABEL;

	private HtmlInputText COMP_TU_LC_TOPUP_DEP_AMT;

	private HtmlOutputLabel COMP_TU_LC_TOPUP_CHRG_AMT_LABEL;

	private HtmlInputText COMP_TU_LC_TOPUP_CHRG_AMT;

	private HtmlOutputLabel COMP_TU_LC_TOPUP_NET_AMT_LABEL;

	private HtmlInputText COMP_TU_LC_TOPUP_NET_AMT;

	private HtmlOutputLabel COMP_TU_TXN_CODE_LABEL;

	private HtmlInputText COMP_TU_TXN_CODE;

	private HtmlOutputLabel COMP_TU_DOC_NO_LABEL;

	private HtmlInputText COMP_TU_DOC_NO;

	private HtmlOutputLabel COMP_TU_DOC_DT_LABEL;

	private HtmlCalendar COMP_TU_DOC_DT;

	private HtmlOutputLabel COMP_UI_M_SUM_DEP_LABEL;

	private HtmlInputText COMP_UI_M_SUM_DEP;

	private HtmlOutputLabel COMP_TU_REASON_CODE_LABEL;

	private HtmlInputText COMP_TU_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_REASON_DESC_LABEL;

	private HtmlInputText COMP_UI_M_REASON_DESC;

	private HtmlOutputLabel COMP_TU_FLEX_01_LABEL;

	private HtmlInputText COMP_TU_FLEX_01;

	private HtmlOutputLabel COMP_TU_REMARKS_LABEL;

	private HtmlInputText COMP_TU_REMARKS;

	private HtmlOutputLabel COMP_TU_FLEX_02_LABEL;

	private HtmlInputText COMP_TU_FLEX_02;

	private HtmlOutputLabel COMP_UI_M_TU_REVERSE_FLAG_LABEL;

	private HtmlInputText COMP_UI_M_TU_REVERSE_FLAG;

	private HtmlOutputLabel COMP_TU_FLEX_03_LABEL;

	private HtmlInputText COMP_TU_FLEX_03;

	private PT_IL_TOP_UP_1 PT_IL_TOP_UP_1_BEAN;
	
	private UIData topup1Table;
	
	private List<PT_IL_TOP_UP_1> fetchList;

	public PT_IL_TOP_UP_1_ACTION() {
		PT_IL_TOP_UP_1_BEAN = new PT_IL_TOP_UP_1();
		fetchList = new ArrayList<PT_IL_TOP_UP_1>();

		 COMP_TU_POL_NO=new HtmlInputText();
		 COMP_TU_LC_TOPUP_DEP_AMT=new HtmlInputText();
 	 	 COMP_TU_LC_TOPUP_CHRG_AMT=new HtmlInputText();
		 COMP_TU_LC_TOPUP_NET_AMT=new HtmlInputText();
		 COMP_TU_TXN_CODE=new HtmlInputText();
		 COMP_TU_DOC_NO=new HtmlInputText();
		 COMP_TU_DOC_DT=new HtmlCalendar();
		 COMP_UI_M_SUM_DEP=new HtmlInputText();
		 COMP_TU_REASON_CODE=new HtmlInputText();
		 COMP_UI_M_REASON_DESC=new HtmlInputText();
		 COMP_TU_FLEX_01=new HtmlInputText();
		 COMP_TU_REMARKS=new HtmlInputText();
		 COMP_TU_FLEX_02=new HtmlInputText();
		 COMP_UI_M_TU_REVERSE_FLAG=new HtmlInputText();
		 COMP_TU_FLEX_03=new HtmlInputText();
	}

	public HtmlOutputLabel getCOMP_TU_POL_NO_LABEL() {
		return COMP_TU_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_TU_POL_NO() {
		return COMP_TU_POL_NO;
	}

	public void setCOMP_TU_POL_NO_LABEL(HtmlOutputLabel COMP_TU_POL_NO_LABEL) {
		this.COMP_TU_POL_NO_LABEL = COMP_TU_POL_NO_LABEL;
	}

	public void setCOMP_TU_POL_NO(HtmlInputText COMP_TU_POL_NO) {
		this.COMP_TU_POL_NO = COMP_TU_POL_NO;
	}

	public HtmlOutputLabel getCOMP_TU_LC_TOPUP_DEP_AMT_LABEL() {
		return COMP_TU_LC_TOPUP_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_TU_LC_TOPUP_DEP_AMT() {
		return COMP_TU_LC_TOPUP_DEP_AMT;
	}

	public void setCOMP_TU_LC_TOPUP_DEP_AMT_LABEL(HtmlOutputLabel COMP_TU_LC_TOPUP_DEP_AMT_LABEL) {
		this.COMP_TU_LC_TOPUP_DEP_AMT_LABEL = COMP_TU_LC_TOPUP_DEP_AMT_LABEL;
	}

	public void setCOMP_TU_LC_TOPUP_DEP_AMT(HtmlInputText COMP_TU_LC_TOPUP_DEP_AMT) {
		this.COMP_TU_LC_TOPUP_DEP_AMT = COMP_TU_LC_TOPUP_DEP_AMT;
	}

	public HtmlOutputLabel getCOMP_TU_LC_TOPUP_CHRG_AMT_LABEL() {
		return COMP_TU_LC_TOPUP_CHRG_AMT_LABEL;
	}

	public HtmlInputText getCOMP_TU_LC_TOPUP_CHRG_AMT() {
		return COMP_TU_LC_TOPUP_CHRG_AMT;
	}

	public void setCOMP_TU_LC_TOPUP_CHRG_AMT_LABEL(HtmlOutputLabel COMP_TU_LC_TOPUP_CHRG_AMT_LABEL) {
		this.COMP_TU_LC_TOPUP_CHRG_AMT_LABEL = COMP_TU_LC_TOPUP_CHRG_AMT_LABEL;
	}

	public void setCOMP_TU_LC_TOPUP_CHRG_AMT(HtmlInputText COMP_TU_LC_TOPUP_CHRG_AMT) {
		this.COMP_TU_LC_TOPUP_CHRG_AMT = COMP_TU_LC_TOPUP_CHRG_AMT;
	}

	public HtmlOutputLabel getCOMP_TU_LC_TOPUP_NET_AMT_LABEL() {
		return COMP_TU_LC_TOPUP_NET_AMT_LABEL;
	}

	public HtmlInputText getCOMP_TU_LC_TOPUP_NET_AMT() {
		return COMP_TU_LC_TOPUP_NET_AMT;
	}

	public void setCOMP_TU_LC_TOPUP_NET_AMT_LABEL(HtmlOutputLabel COMP_TU_LC_TOPUP_NET_AMT_LABEL) {
		this.COMP_TU_LC_TOPUP_NET_AMT_LABEL = COMP_TU_LC_TOPUP_NET_AMT_LABEL;
	}

	public void setCOMP_TU_LC_TOPUP_NET_AMT(HtmlInputText COMP_TU_LC_TOPUP_NET_AMT) {
		this.COMP_TU_LC_TOPUP_NET_AMT = COMP_TU_LC_TOPUP_NET_AMT;
	}

	public HtmlOutputLabel getCOMP_TU_TXN_CODE_LABEL() {
		return COMP_TU_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TU_TXN_CODE() {
		return COMP_TU_TXN_CODE;
	}

	public void setCOMP_TU_TXN_CODE_LABEL(HtmlOutputLabel COMP_TU_TXN_CODE_LABEL) {
		this.COMP_TU_TXN_CODE_LABEL = COMP_TU_TXN_CODE_LABEL;
	}

	public void setCOMP_TU_TXN_CODE(HtmlInputText COMP_TU_TXN_CODE) {
		this.COMP_TU_TXN_CODE = COMP_TU_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_TU_DOC_NO_LABEL() {
		return COMP_TU_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_TU_DOC_NO() {
		return COMP_TU_DOC_NO;
	}

	public void setCOMP_TU_DOC_NO_LABEL(HtmlOutputLabel COMP_TU_DOC_NO_LABEL) {
		this.COMP_TU_DOC_NO_LABEL = COMP_TU_DOC_NO_LABEL;
	}

	public void setCOMP_TU_DOC_NO(HtmlInputText COMP_TU_DOC_NO) {
		this.COMP_TU_DOC_NO = COMP_TU_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_TU_DOC_DT_LABEL() {
		return COMP_TU_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TU_DOC_DT() {
		return COMP_TU_DOC_DT;
	}

	public void setCOMP_TU_DOC_DT_LABEL(HtmlOutputLabel COMP_TU_DOC_DT_LABEL) {
		this.COMP_TU_DOC_DT_LABEL = COMP_TU_DOC_DT_LABEL;
	}

	public void setCOMP_TU_DOC_DT(HtmlCalendar COMP_TU_DOC_DT) {
		this.COMP_TU_DOC_DT = COMP_TU_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_DEP_LABEL() {
		return COMP_UI_M_SUM_DEP_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUM_DEP() {
		return COMP_UI_M_SUM_DEP;
	}

	public void setCOMP_UI_M_SUM_DEP_LABEL(HtmlOutputLabel COMP_UI_M_SUM_DEP_LABEL) {
		this.COMP_UI_M_SUM_DEP_LABEL = COMP_UI_M_SUM_DEP_LABEL;
	}

	public void setCOMP_UI_M_SUM_DEP(HtmlInputText COMP_UI_M_SUM_DEP) {
		this.COMP_UI_M_SUM_DEP = COMP_UI_M_SUM_DEP;
	}

	public HtmlOutputLabel getCOMP_TU_REASON_CODE_LABEL() {
		return COMP_TU_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TU_REASON_CODE() {
		return COMP_TU_REASON_CODE;
	}

	public void setCOMP_TU_REASON_CODE_LABEL(HtmlOutputLabel COMP_TU_REASON_CODE_LABEL) {
		this.COMP_TU_REASON_CODE_LABEL = COMP_TU_REASON_CODE_LABEL;
	}

	public void setCOMP_TU_REASON_CODE(HtmlInputText COMP_TU_REASON_CODE) {
		this.COMP_TU_REASON_CODE = COMP_TU_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_REASON_DESC_LABEL() {
		return COMP_UI_M_REASON_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_REASON_DESC() {
		return COMP_UI_M_REASON_DESC;
	}

	public void setCOMP_UI_M_REASON_DESC_LABEL(HtmlOutputLabel COMP_UI_M_REASON_DESC_LABEL) {
		this.COMP_UI_M_REASON_DESC_LABEL = COMP_UI_M_REASON_DESC_LABEL;
	}

	public void setCOMP_UI_M_REASON_DESC(HtmlInputText COMP_UI_M_REASON_DESC) {
		this.COMP_UI_M_REASON_DESC = COMP_UI_M_REASON_DESC;
	}

	public HtmlOutputLabel getCOMP_TU_FLEX_01_LABEL() {
		return COMP_TU_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_TU_FLEX_01() {
		return COMP_TU_FLEX_01;
	}

	public void setCOMP_TU_FLEX_01_LABEL(HtmlOutputLabel COMP_TU_FLEX_01_LABEL) {
		this.COMP_TU_FLEX_01_LABEL = COMP_TU_FLEX_01_LABEL;
	}

	public void setCOMP_TU_FLEX_01(HtmlInputText COMP_TU_FLEX_01) {
		this.COMP_TU_FLEX_01 = COMP_TU_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_TU_REMARKS_LABEL() {
		return COMP_TU_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_TU_REMARKS() {
		return COMP_TU_REMARKS;
	}

	public void setCOMP_TU_REMARKS_LABEL(HtmlOutputLabel COMP_TU_REMARKS_LABEL) {
		this.COMP_TU_REMARKS_LABEL = COMP_TU_REMARKS_LABEL;
	}

	public void setCOMP_TU_REMARKS(HtmlInputText COMP_TU_REMARKS) {
		this.COMP_TU_REMARKS = COMP_TU_REMARKS;
	}

	public HtmlOutputLabel getCOMP_TU_FLEX_02_LABEL() {
		return COMP_TU_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_TU_FLEX_02() {
		return COMP_TU_FLEX_02;
	}

	public void setCOMP_TU_FLEX_02_LABEL(HtmlOutputLabel COMP_TU_FLEX_02_LABEL) {
		this.COMP_TU_FLEX_02_LABEL = COMP_TU_FLEX_02_LABEL;
	}

	public void setCOMP_TU_FLEX_02(HtmlInputText COMP_TU_FLEX_02) {
		this.COMP_TU_FLEX_02 = COMP_TU_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_UI_M_TU_REVERSE_FLAG_LABEL() {
		return COMP_UI_M_TU_REVERSE_FLAG_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TU_REVERSE_FLAG() {
		return COMP_UI_M_TU_REVERSE_FLAG;
	}

	public void setCOMP_UI_M_TU_REVERSE_FLAG_LABEL(HtmlOutputLabel COMP_UI_M_TU_REVERSE_FLAG_LABEL) {
		this.COMP_UI_M_TU_REVERSE_FLAG_LABEL = COMP_UI_M_TU_REVERSE_FLAG_LABEL;
	}

	public void setCOMP_UI_M_TU_REVERSE_FLAG(HtmlInputText COMP_UI_M_TU_REVERSE_FLAG) {
		this.COMP_UI_M_TU_REVERSE_FLAG = COMP_UI_M_TU_REVERSE_FLAG;
	}

	public HtmlOutputLabel getCOMP_TU_FLEX_03_LABEL() {
		return COMP_TU_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_TU_FLEX_03() {
		return COMP_TU_FLEX_03;
	}

	public void setCOMP_TU_FLEX_03_LABEL(HtmlOutputLabel COMP_TU_FLEX_03_LABEL) {
		this.COMP_TU_FLEX_03_LABEL = COMP_TU_FLEX_03_LABEL;
	}

	public void setCOMP_TU_FLEX_03(HtmlInputText COMP_TU_FLEX_03) {
		this.COMP_TU_FLEX_03 = COMP_TU_FLEX_03;
	}

	public PT_IL_TOP_UP_1 getPT_IL_TOP_UP_1_BEAN() {
		return PT_IL_TOP_UP_1_BEAN;
	}

	public void setPT_IL_TOP_UP_1_BEAN(PT_IL_TOP_UP_1 PT_IL_TOP_UP_1_BEAN) {
		this.PT_IL_TOP_UP_1_BEAN = PT_IL_TOP_UP_1_BEAN;
	}
	
	public String previousPageButtonClickAction(){
		String returnString="GO_TO_PILT027_PT_IL_DEPOSIT_CHARGE";
		return returnString;
	}
	
	// [ Added for grid implementation change, Added by: S.Mallika, Dated:
	// 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = topup1Table.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				//lastColumnListener();
			} else {
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}

		return outcome;
	}
	// Added for grid implementation change, Added by: S.Mallika, Dated:
	// 17-Feb-2009 ]

	public UIData getTopup1Table() {
		return topup1Table;
	}

	public void setTopup1Table(UIData topup1Table) {
		this.topup1Table = topup1Table;
	}

	public List<PT_IL_TOP_UP_1> getFetchList() {
		return fetchList;
	}

	public void setFetchList(List<PT_IL_TOP_UP_1> fetchList) {
		this.fetchList = fetchList;
	}

	public void getDetails(ActionEvent event) {
		try {
				resetSelectedRow();
				PT_IL_TOP_UP_1_BEAN = (PT_IL_TOP_UP_1) topup1Table.getRowData();
				PT_IL_TOP_UP_1_BEAN.setRowSelected(true);
				resetAllComponent(); 
			 
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void resetAllComponent() {

		 COMP_TU_POL_NO.resetValue();
		 COMP_TU_LC_TOPUP_DEP_AMT.resetValue();
 	 	 COMP_TU_LC_TOPUP_CHRG_AMT.resetValue();
		 COMP_TU_LC_TOPUP_NET_AMT.resetValue();
		 COMP_TU_TXN_CODE.resetValue();
		 COMP_TU_DOC_NO.resetValue();
		 COMP_TU_DOC_DT.resetValue();
		 COMP_UI_M_SUM_DEP.resetValue();
		 COMP_TU_REASON_CODE.resetValue();
		 COMP_UI_M_REASON_DESC.resetValue();
		 COMP_TU_FLEX_01.resetValue();
		 COMP_TU_REMARKS.resetValue();
		 COMP_TU_FLEX_02.resetValue();
		 COMP_UI_M_TU_REVERSE_FLAG.resetValue();
		 COMP_TU_FLEX_03.resetValue();
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_TOP_UP_1> iterator = fetchList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
		
	}
	
	
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PT_IL_TOP_UP_1_BEAN=null;
			if (isINSERT_ALLOWED()){		
				PT_IL_TOP_UP_1_BEAN = new PT_IL_TOP_UP_1();
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
	
	
	public void deleteRow(ActionEvent ae) {
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();

			if(isDELETE_ALLOWED()) {
				if(PT_IL_TOP_UP_1_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_TOP_UP_1_BEAN, CommonUtils.getConnection());
					fetchList.remove(PT_IL_TOP_UP_1_BEAN);
				}
				
				if(fetchList.size() > 0) {
					setPT_IL_TOP_UP_1_BEAN(fetchList.get(0));
					PT_IL_TOP_UP_1_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
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
   public void post(ActionEvent ae) {
	   PT_IL_TOP_UP_1_DELEGATE delegate= new PT_IL_TOP_UP_1_DELEGATE();
	   try{
		if(PT_IL_TOP_UP_1_BEAN.getROWID() != null) {
			if(isUPDATE_ALLOWED()) {
				//delegate.preInsert();
				//helper.pmAgentContestApplRankPreUpdate(PT_IL_DEPOSIT_CHARGE_BEAN);
			    new CRUDHandler().executeInsert(PT_IL_TOP_UP_1_BEAN, CommonUtils.getConnection());
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
				
				//delegate.preInsert();
				//helper.pmAgentContestApplRankPreInsert(PT_IL_DEPOSIT_CHARGE_BEAN);
				new CRUDHandler().executeInsert(PT_IL_TOP_UP_1_BEAN, CommonUtils.getConnection());					
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				getWarningMap().put("post",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				fetchList.add(PT_IL_TOP_UP_1_BEAN);
				
			} else {
				getErrorMap().clear();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
			}
		}
		resetAllComponent();
		resetSelectedRow();
		PT_IL_TOP_UP_1_BEAN.setRowSelected(true);

	} catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("post", e.getMessage());
	}
}

public void populateBlockPT_IL_TOP_UP_1() {
	//get details from database for the block
	PT_IL_TOP_UP_1_DELEGATE delegate= new PT_IL_TOP_UP_1_DELEGATE();
	List<PT_IL_TOP_UP_1> dataList=new ArrayList<PT_IL_TOP_UP_1>();
	dataList=delegate.getBlockDataForPT_IL_TOP_UP_1();
	System.out.println("size of list-------------"+dataList.size());
	//Populate the block
	String mappedBeanName="PILT027_COMPOSITE_ACTION";
	CommonUtils utility=new CommonUtils();
	PILT027_COMPOSITE_ACTION compositeActionBean=
		(PILT027_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
	compositeActionBean.getPT_IL_TOP_UP_1_ACTION_BEAN().setFetchList(dataList);

}


}
