package com.iii.pel.forms.PILQ015;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POLICY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CUST_REF_ID1_LABEL;

	private HtmlInputText COMP_CUST_REF_ID1;

	private HtmlOutputLabel COMP_CUST_REF_ID2_LABEL;

	private HtmlInputText COMP_CUST_REF_ID2;

	private HtmlOutputLabel COMP_POL_CUST_CODE_LABEL;

	private HtmlInputText COMP_POL_CUST_CODE;

	private HtmlOutputLabel COMP_CUST_NAME_LABEL;

	private HtmlInputText COMP_CUST_NAME;

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_PROP_NO_LABEL;

	private HtmlInputText COMP_POL_PROP_NO;

	private PT_IL_POLICY PT_IL_POLICY_BEAN;
	
	PT_IL_POLICY_DELEGATE delegate = new PT_IL_POLICY_DELEGATE();
	
	private List newIcList;
	
	private List oldIcList;
	
	private List custCodeList;
	
	private List policyList;
	
	private List proposalList;
	List<LovBean> suggestionList = null;

	public PT_IL_POLICY_ACTION() {
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
	}
	
	
	public List newICAction(Object event) {
		String code = (String) event;
		newIcList = delegate.fetchNewCodeList(code, newIcList);
		return newIcList;
	/*	ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILQ015", "PT_IL_POLICY",
					"CUST_REF_ID1", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
*/
	}
	
	public List oldICAction(Object obj) {
		String code = (String) obj;
		oldIcList = delegate.fetchOldCodeList(code, oldIcList);
		return oldIcList;
		/*ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILQ015", "PT_IL_POLICY",
					"CUST_REF_ID2", null, null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
*/	}
	
	public List custCodeAction(Object obj) {
		String code = (String) obj;
		custCodeList = delegate.fetchCustCodeList(code, custCodeList);
		return custCodeList;
	}
	
	public List getPolicyList() {
		return policyList;
	}


	public void setPolicyList(List policyList) {
		this.policyList = policyList;
	}


	public List getProposalList() {
		return proposalList;
	}


	public void setProposalList(List proposalList) {
		this.proposalList = proposalList;
	}


	public void getCodeDesc(ActionEvent event) {
		COMP_CUST_NAME.setSubmittedValue(null);
		System.out.println("<--------hi----->");

		if (COMP_POL_CUST_CODE.getSubmittedValue() != null) {
			String code = (String) COMP_POL_CUST_CODE.getSubmittedValue();
			String codeDesc = delegate.getCodeDesc(code, custCodeList);
			PT_IL_POLICY_BEAN.setCUST_NAME(codeDesc);

		}
	}
	
	public List policyAction(Object obj) {
		String code = (String) obj;
		policyList = delegate.fetchPolicyList(code, policyList);
		return policyList;
			}
	
	public List proposalAction(Object obj) {
		String code = (String) obj;
		proposalList = delegate.fetchProposalList(code, proposalList);
		return proposalList;
		/*
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILQ015", "PT_IL_POLICY",
					"POL_PROP_NO", PT_IL_POLICY_BEAN.getCUST_REF_ID1(), PT_IL_POLICY_BEAN.getCUST_REF_ID2(), null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	*/}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void policyNowhenValidate(FacesContext facesContext,UIComponent component,Object object ){
		
		if(object!=null){
			String policyNo = (String)object;
			PT_IL_POLICY_BEAN.setPOL_NO(policyNo);
		}
			
	}
  
	public void proposalNowhenValidate(FacesContext facesContext,UIComponent component,Object object ){
		
		if(object!=null){
			String proposalNo = (String)object;
			PT_IL_POLICY_BEAN.setPOL_PROP_NO(proposalNo);
		
		}
	}
	
	public void fetchDetails(){
	    	try {
	    	PT_IL_POLICY_COMPOSITE compAction = (PT_IL_POLICY_COMPOSITE) new CommonUtils()
		    .getMappedBeanFromSession("PT_IL_POLICY_COMPOSITE");
	    	
	    	compAction.getPS_IL_DRCR_ACTION().setDataListPS_IL_DRCR(delegate.fetchDetails());
		    /*List<PS_IL_DRCR> list = compAction.getPS_IL_DRCR_ACTION().getDataList_PS_IL_DRCR();
		    for(int i=0;i<list.size();i++){
			PS_IL_DRCR ps_il_drcr = list.get(i); 
			if(i==0){
			    ps_il_drcr.setRowSelected(true);
			    compAction.getPS_IL_DRCR_ACTION().setPS_IL_DRCR_BEAN(ps_il_drcr);
			}else{
			    ps_il_drcr.setRowSelected(false);
			}
		    }*/
		   
		} catch (RuntimeException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
	}
	
	

	public HtmlOutputLabel getCOMP_CUST_REF_ID1_LABEL() {
		return COMP_CUST_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_CUST_REF_ID1() {
		return COMP_CUST_REF_ID1;
	}

	public void setCOMP_CUST_REF_ID1_LABEL(HtmlOutputLabel COMP_CUST_REF_ID1_LABEL) {
		this.COMP_CUST_REF_ID1_LABEL = COMP_CUST_REF_ID1_LABEL;
	}

	public void setCOMP_CUST_REF_ID1(HtmlInputText COMP_CUST_REF_ID1) {
		this.COMP_CUST_REF_ID1 = COMP_CUST_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_CUST_REF_ID2_LABEL() {
		return COMP_CUST_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_CUST_REF_ID2() {
		return COMP_CUST_REF_ID2;
	}

	public void setCOMP_CUST_REF_ID2_LABEL(HtmlOutputLabel COMP_CUST_REF_ID2_LABEL) {
		this.COMP_CUST_REF_ID2_LABEL = COMP_CUST_REF_ID2_LABEL;
	}

	public void setCOMP_CUST_REF_ID2(HtmlInputText COMP_CUST_REF_ID2) {
		this.COMP_CUST_REF_ID2 = COMP_CUST_REF_ID2;
	}

	public HtmlOutputLabel getCOMP_POL_CUST_CODE_LABEL() {
		return COMP_POL_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CUST_CODE() {
		return COMP_POL_CUST_CODE;
	}

	public void setCOMP_POL_CUST_CODE_LABEL(HtmlOutputLabel COMP_POL_CUST_CODE_LABEL) {
		this.COMP_POL_CUST_CODE_LABEL = COMP_POL_CUST_CODE_LABEL;
	}

	public void setCOMP_POL_CUST_CODE(HtmlInputText COMP_POL_CUST_CODE) {
		this.COMP_POL_CUST_CODE = COMP_POL_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_CUST_NAME_LABEL() {
		return COMP_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CUST_NAME() {
		return COMP_CUST_NAME;
	}

	public void setCOMP_CUST_NAME_LABEL(HtmlOutputLabel COMP_CUST_NAME_LABEL) {
		this.COMP_CUST_NAME_LABEL = COMP_CUST_NAME_LABEL;
	}

	public void setCOMP_CUST_NAME(HtmlInputText COMP_CUST_NAME) {
		this.COMP_CUST_NAME = COMP_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_PROP_NO_LABEL() {
		return COMP_POL_PROP_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_PROP_NO() {
		return COMP_POL_PROP_NO;
	}

	public void setCOMP_POL_PROP_NO_LABEL(HtmlOutputLabel COMP_POL_PROP_NO_LABEL) {
		this.COMP_POL_PROP_NO_LABEL = COMP_POL_PROP_NO_LABEL;
	}

	public void setCOMP_POL_PROP_NO(HtmlInputText COMP_POL_PROP_NO) {
		this.COMP_POL_PROP_NO = COMP_POL_PROP_NO;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}

	public List getNewIcList() {
		return newIcList;
	}

	public void setNewIcList(List newIcList) {
		this.newIcList = newIcList;
	}

	public List getOldIcList() {
		return oldIcList;
	}

	public void setOldIcList(List oldIcList) {
		this.oldIcList = oldIcList;
	}

	public List getCustCodeList() {
		return custCodeList;
	}

	public void setCustCodeList(List custCodeList) {
		this.custCodeList = custCodeList;
	}
	
	 public void validateCUST_REF_ID1(FacesContext facesContext,
	    		UIComponent component, Object value) throws ValidatorException {
	    	CommonUtils.clearMaps(this);
	    	try {
	    		String query = "SELECT CUST_REF_ID1 FROM   PM_CUSTOMER"
				+ " WHERE  CUST_REF_ID1 = ?  AND CUST_FRZ_FLAG = 'N'" + " AND ROWNUM<20";
	    		
	    		PT_IL_POLICY_BEAN.setCUST_REF_ID1((String)value);
	    		
	    		PT_IL_POLICY_DELEGATE pt_il_policy_delegate = new PT_IL_POLICY_DELEGATE();
	    		pt_il_policy_delegate.validateItem(query, new Object[]{PT_IL_POLICY_BEAN.getCUST_REF_ID1()});
	    		
	    	} catch (Exception exception) {
	    		exception.printStackTrace();
	    		throw new ValidatorException(new FacesMessage(exception
	    				.getMessage()));
	    	} finally {
	    		try {
	    			ErrorHelpUtil.getWarningForProcedure(CommonUtils
	    					.getConnection(), "POL_PAYOR_SDCODE", getWarningMap());
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
}
