package com.iii.pel.forms.PQ123;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private DUMMY DUMMY_BEAN;

	private HtmlInputText COMP_CUST_CODE;

	private HtmlInputText COMP_CUST_DESC;
	
	private HtmlCommandButton COMP_UI_BUT_FETCH;

	private List customerCodeList;
	
	public PV_POL_QUERY_COMPOSITE compositeAction;

	PV_POL_QUERY_DELEGATE delegate = new PV_POL_QUERY_DELEGATE();

	public List getCustomerCodeList() {
		return customerCodeList;
	}

	public void setCustomerCodeList(List customerCodeList) {
		this.customerCodeList = customerCodeList;
	}

	public List cutomerCodeLovAction(Object value) {

		String customerCode = (String) value;
		customerCodeList = delegate.getCustomerCodeValues(customerCode);

		return customerCodeList;
	}
	
	public ArrayList<LovBean> lovCUST_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT  CUST_CODE,CUST_NAME  FROM   PM_CUSTOMER WHERE " +
				"CUST_CLASS IN "
					+ "(SELECT CCLAS_CODE FROM PM_CUST_CLASS)"
					+ " AND CUST_FRZ_FLAG = 'N' AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ?) AND ROWNUM < ?";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public void getCustDescription(ActionEvent actionEvent) {
		COMP_CUST_DESC.setSubmittedValue(null);
		if (COMP_CUST_CODE.getSubmittedValue() != null) {

			String custCode = (String) COMP_CUST_CODE.getSubmittedValue();
			String custDesc = delegate.getDescription(custCode,
					customerCodeList);
			DUMMY_BEAN.setCUST_DESC(custDesc);

		}
	}

	/**
	 * 
	 * @param facesContext
	 * @param component
	 * @param value
	 */
	public void customerCodeValidation(FacesContext facesContext,
			UIComponent component, Object value) {
		DUMMY_BEAN.setCUST_CODE((String)value);
		
		/*try{
			if (value != null) {
				List<PV_POL_QUERY> list = delegate.fetchPolicyDetails((String) value);
				if(list!=null && !list.isEmpty()){
					PV_POL_QUERY pv_pol_query = list.get(0);
					pv_pol_query.setRowSelected(true);
					compositeAction.getPV_POL_QUERY_ACTION().setPV_POL_QUERY_BEAN(pv_pol_query);
				}
				
				compositeAction.getPV_POL_QUERY_ACTION().setDataList_PV_POL_QUERY(
						list);
				compositeAction.getPV_POL_QUERY_ACTION().resetAllComponent();
			//	compositeAction.getPV_POL_QUERY_ACTION().
			}
		}catch(Exception exception){
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
*/
	}
	
	/**
	 * 
	 */
	public void fetchPolicyDetails(){
		try{
			if(DUMMY_BEAN.getCUST_CODE()==null || "".equalsIgnoreCase(DUMMY_BEAN.getCUST_CODE())){
				DUMMY_BEAN.setCUST_CODE(COMP_CUST_CODE.getSubmittedValue()!=null ? COMP_CUST_CODE.getSubmittedValue().toString() : "");
			}
			
			List<PV_POL_QUERY> list = delegate.fetchPolicyDetails(DUMMY_BEAN.getCUST_CODE());
			if(list!=null && !list.isEmpty()){
				PV_POL_QUERY pv_pol_query = list.get(0);
				pv_pol_query.setRowSelected(true);
				compositeAction.getPV_POL_QUERY_ACTION().setPV_POL_QUERY_BEAN(pv_pol_query);
				compositeAction.getPV_POL_QUERY_ACTION().fetchDetailsFirstRecord(pv_pol_query);
			}
			
			compositeAction.getPV_POL_QUERY_ACTION().setDataList_PV_POL_QUERY(
					list);
			compositeAction.getPV_POL_QUERY_ACTION().resetAllComponent();
		}catch(Exception exception){
			getErrorMap().put("current", exception.getMessage());
		}
	}
	
	

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public HtmlInputText getCOMP_CUST_CODE() {
		return COMP_CUST_CODE;
	}

	public void setCOMP_CUST_CODE(HtmlInputText comp_cust_code) {
		COMP_CUST_CODE = comp_cust_code;
	}

	public HtmlInputText getCOMP_CUST_DESC() {
		return COMP_CUST_DESC;
	}

	public void setCOMP_CUST_DESC(HtmlInputText comp_cust_desc) {
		COMP_CUST_DESC = comp_cust_desc;
	}

	/**
	 * @return the cOMP_UI_BUT_FETCH
	 */
	public HtmlCommandButton getCOMP_UI_BUT_FETCH() {
		return COMP_UI_BUT_FETCH;
	}

	/**
	 * @param comp_ui_but_fetch the cOMP_UI_BUT_FETCH to set
	 */
	public void setCOMP_UI_BUT_FETCH(HtmlCommandButton comp_ui_but_fetch) {
		COMP_UI_BUT_FETCH = comp_ui_but_fetch;
	}

	/**
	 * @return the compositeAction
	 */
	public PV_POL_QUERY_COMPOSITE getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PV_POL_QUERY_COMPOSITE compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the delegate
	 */
	public PV_POL_QUERY_DELEGATE getDelegate() {
		return delegate;
	}

	/**
	 * @param delegate the delegate to set
	 */
	public void setDelegate(PV_POL_QUERY_DELEGATE delegate) {
		this.delegate = delegate;
	}
}
