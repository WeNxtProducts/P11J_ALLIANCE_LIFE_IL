package com.iii.pel.forms.PILQ137;

import java.sql.ResultSet;
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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILP206.PW_IL_BALANCE_SUM;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PW_IL_AAA_PROCESS_DTLS_ACTION extends CommonAction {
	public PILQ137_COMPOSITE_ACTION compositeAction;
	private PW_IL_AAA_PROCESS_DTLS PW_IL_AAA_PROCESS_DTLS_BEAN;
	private PW_IL_AAA_PROCESS_DTLS_HELPER helper;
	private PW_IL_AAA_PROCESS_DTLS_DELEGATE delegate;
	private List<PW_IL_AAA_PROCESS_DTLS> dataList_PW_IL_AAA_PROCESS_DTLS = new ArrayList<PW_IL_AAA_PROCESS_DTLS>();
	private List<PW_IL_AAA_PROCESS_DTLS> dataList_PW_IL_AAA_PROCESS_DTLS_CA = new ArrayList<PW_IL_AAA_PROCESS_DTLS>();
	private String UI_M_POLICY_NO;
	public String getUI_M_POLICY_NO() {
		return UI_M_POLICY_NO;
	}

	public void setUI_M_POLICY_NO(String ui_M_POLICY_NO) {
		UI_M_POLICY_NO = ui_M_POLICY_NO;
	}
	private UIData dataTable;
	private UIData dataTable1;
	public PW_IL_AAA_PROCESS_DTLS_ACTION()
	{
		PW_IL_AAA_PROCESS_DTLS_BEAN=new PW_IL_AAA_PROCESS_DTLS();
		helper=new PW_IL_AAA_PROCESS_DTLS_HELPER();
		delegate=new PW_IL_AAA_PROCESS_DTLS_DELEGATE();
		
	}
	public UIData getDataTable1() {
		return dataTable1;
	}
	public void setDataTable1(UIData dataTable1) {
		this.dataTable1 = dataTable1;
	}
	public PW_IL_AAA_PROCESS_DTLS getPW_IL_AAA_PROCESS_DTLS_BEAN() {
		return PW_IL_AAA_PROCESS_DTLS_BEAN;
	}
	public void setPW_IL_AAA_PROCESS_DTLS_BEAN(
			PW_IL_AAA_PROCESS_DTLS pW_IL_AAA_PROCESS_DTLS_BEAN) {
		PW_IL_AAA_PROCESS_DTLS_BEAN = pW_IL_AAA_PROCESS_DTLS_BEAN;
	}
	public PW_IL_AAA_PROCESS_DTLS_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PW_IL_AAA_PROCESS_DTLS_HELPER helper) {
		this.helper = helper;
	}
	public PW_IL_AAA_PROCESS_DTLS_DELEGATE getDelegate() {
		return delegate;
	}
	public void setDelegate(PW_IL_AAA_PROCESS_DTLS_DELEGATE delegate) {
		this.delegate = delegate;
	}
	public List<PW_IL_AAA_PROCESS_DTLS> getDataList_PW_IL_AAA_PROCESS_DTLS() {
		return dataList_PW_IL_AAA_PROCESS_DTLS;
	}
	public List<PW_IL_AAA_PROCESS_DTLS> getDataList_PW_IL_AAA_PROCESS_DTLS_CA() {
		return dataList_PW_IL_AAA_PROCESS_DTLS_CA;
	}
	public void setDataList_PW_IL_AAA_PROCESS_DTLS_CA(
			List<PW_IL_AAA_PROCESS_DTLS> dataList_PW_IL_AAA_PROCESS_DTLS_CA) {
		this.dataList_PW_IL_AAA_PROCESS_DTLS_CA = dataList_PW_IL_AAA_PROCESS_DTLS_CA;
	}
	public void setDataList_PW_IL_AAA_PROCESS_DTLS(
			List<PW_IL_AAA_PROCESS_DTLS> dataList_PW_IL_AAA_PROCESS_DTLS) {
		this.dataList_PW_IL_AAA_PROCESS_DTLS = dataList_PW_IL_AAA_PROCESS_DTLS;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public void onLoad(PhaseEvent event){
		if(isBlockFlag()){
			System.out.println("Onload is called");
			
			setBlockFlag(false);
		}
	}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public String whenButtonPressedFetch(ActionEvent event) {
		try {
		System.out.println("Entered into whenButtonPressedFetch");
		/*String Query="SELECT * FROM PW_IL_AAA_PROCESS_DTLS WHERE APRD_POL_NO=?";
		ResultSet resultset=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), 
		new Object[]{PW_IL_AAA_PROCESS_DTLS_BEAN.getUI_M_POLICY_NO()});
		while(resultset.next())
		{
			CUST_DTL_UPD_BEAN.setCDU_CUST_CODE_DESC(resultset.getString("cust_name"));
		}*/
		helper.executeQuery(compositeAction);
		helper.executeQuery1(compositeAction);
		
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("Fetch", exc.getMessage());
		}

		return ""; 
	}
	
	private HtmlOutputLabel COMP_APRD_POL_NO_LABEL;
	
	private HtmlInputText COMP_APRD_POL_NO;
	
	private HtmlInputText COMP_UI_M_APRD_POL_NO_DESC;
	
	private HtmlCommandButton COMP_FETCH_BTN;
	
	public HtmlInputText getCOMP_UI_M_APRD_POL_NO_DESC() {
		return COMP_UI_M_APRD_POL_NO_DESC;
	}
	public void setCOMP_UI_M_APRD_POL_NO_DESC(
			HtmlInputText cOMP_UI_M_APRD_POL_NO_DESC) {
		COMP_UI_M_APRD_POL_NO_DESC = cOMP_UI_M_APRD_POL_NO_DESC;
	}

	public HtmlOutputLabel getCOMP_APRD_POL_NO_LABEL() {
		return COMP_APRD_POL_NO_LABEL;
	}
	public void setCOMP_APRD_POL_NO_LABEL(HtmlOutputLabel cOMP_APRD_POL_NO_LABEL) {
		COMP_APRD_POL_NO_LABEL = cOMP_APRD_POL_NO_LABEL;
	}
	public HtmlInputText getCOMP_APRD_POL_NO() {
		return COMP_APRD_POL_NO;
	}
	public void setCOMP_APRD_POL_NO(HtmlInputText cOMP_APRD_POL_NO) {
		COMP_APRD_POL_NO = cOMP_APRD_POL_NO;
	}
	public HtmlCommandButton getCOMP_FETCH_BTN() {
		return COMP_FETCH_BTN;
	}
	public void setCOMP_FETCH_BTN(HtmlCommandButton cOMP_FETCH_BTN) {
		COMP_FETCH_BTN = cOMP_FETCH_BTN;
	}
	public ArrayList<com.iii.premia.common.bean.LovBean> lovAPRD_POL_NO(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILQ137",
					"DUMMY", "M_POLICY_NO", "PILH039", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PW_IL_AAA_PROCESS_DTLS_BEAN = (PW_IL_AAA_PROCESS_DTLS) dataTable.getRowData();
			PW_IL_AAA_PROCESS_DTLS_BEAN.setRowSelected(true);
			//resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	private void resetSelectedRow() {
		Iterator<PW_IL_AAA_PROCESS_DTLS> PW_IL_AAA_PROCESS_DTLS = dataList_PW_IL_AAA_PROCESS_DTLS.iterator();
		while (PW_IL_AAA_PROCESS_DTLS.hasNext()) {
			PW_IL_AAA_PROCESS_DTLS.next().setRowSelected(false);
		}
	}
 public void validateUI_M_POL_NO(FacesContext facesContext,
			 UIComponent component, Object value) throws ValidatorException {
		 CommonUtils.clearMaps(this);
		 try {
			 this.setUI_M_POLICY_NO((String) value);
		
			} catch (Exception exception) {
				exception.printStackTrace();
				throw new ValidatorException(new FacesMessage(exception
						.getMessage()));
			} 
		}
 
 /*Added by saranya for ok/cancel Panel on 04/04/2017*/
 private HtmlAjaxCommandButton COMP_CANCEL_BUTTON;
 
public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON() {
	return COMP_CANCEL_BUTTON;
}

public void setCOMP_CANCEL_BUTTON(HtmlAjaxCommandButton cOMP_CANCEL_BUTTON) {
	COMP_CANCEL_BUTTON = cOMP_CANCEL_BUTTON;
}
 
 
 /*End*/

	
}
