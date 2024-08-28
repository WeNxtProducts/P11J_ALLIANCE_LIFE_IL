package com.iii.pel.forms.PILP018;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.P9ILPK_CHEQ_DISHONOUR;
import com.iii.pel.utils.PKG_PILP018_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_CHEQUE_BOUNCE_HDR_ACTION  extends CommonAction{
     
	public PILP018_COMPOSITE_ACTION compositeAction;

	private HtmlOutputLabel COMP_UI_M_BANK_CODE_LABEL;

	
	private HtmlOutputLabel COMP_UI_M_BANK_DESC_LABEL;

	private HtmlOutputLabel COMP_UI_M_CHQ_NO_LABEL;

	private HtmlOutputLabel COMP_UI_M_CBH_REASON_CODE_LABEL;
	

	private HtmlOutputLabel COMP_UI_M_REASON_CODE_DESC_LABEL;

	
	private HtmlOutputLabel COMP_UI_M_CBH_REMARKS_LABEL;

	
	private HtmlOutputLabel COMP_CBH_POL_NO_LABEL;

	private HtmlInputText COMP_CBH_POL_NO;

	private HtmlOutputLabel COMP_CBH_POL_CONT_NAME_LABEL;

	private HtmlInputText COMP_CBH_POL_CONT_NAME;

	private HtmlOutputLabel COMP_UI_M_TXN_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_TXN_TYPE_DESC;

	private HtmlOutputLabel COMP_CBH_POL_ISSUE_DT_LABEL;

	private HtmlCalendar COMP_CBH_POL_ISSUE_DT;

	private HtmlOutputLabel COMP_CBH_POL_START_DT_LABEL;

	private HtmlCalendar COMP_CBH_POL_START_DT;

	private HtmlOutputLabel COMP_CBH_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_CBH_POL_EXPIRY_DT;

	private HtmlOutputLabel COMP_CBH_POL_PROD_CODE_LABEL;

	private HtmlInputText COMP_CBH_POL_PROD_CODE;
	
	//added by vijay 
	private HtmlInputText COMP_CBH_TXN_TYPE;

	private HtmlCommandButton COMP_UI_M_EDIT_REMARKS;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_BANK_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CHQ_NO;

	private HtmlCommandButton COMP_UI_M_BUT_LOAN_REPAY_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_PREM_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_DEP_REFUND_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_PRINT;

	private PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN;

	private UIDataTable datatable;
	
	private HtmlCommandButton testButton;

	CRUDHandler handler = new CRUDHandler();

	Connection con = null ;

	ResultSet rs = null;

	List<PT_IL_CHEQUE_BOUNCE_HDR> BeanList = new ArrayList<PT_IL_CHEQUE_BOUNCE_HDR>();
	
	List<PT_IL_PYMT_DTLS> DeanList = new ArrayList<PT_IL_PYMT_DTLS>(); 
	
	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
	 
	public PT_IL_CHEQUE_BOUNCE_HDR_ACTION() {
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN = new PT_IL_CHEQUE_BOUNCE_HDR();
		
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_CODE_LABEL() {
		return COMP_UI_M_BANK_CODE_LABEL;
	}
	 
	public void setCOMP_UI_M_BANK_CODE_LABEL(HtmlOutputLabel COMP_UI_M_BANK_CODE_LABEL) {
		this.COMP_UI_M_BANK_CODE_LABEL = COMP_UI_M_BANK_CODE_LABEL;
	}
	 
	public HtmlOutputLabel getCOMP_UI_M_BANK_DESC_LABEL() {
		return COMP_UI_M_BANK_DESC_LABEL;
	}

	public void setCOMP_UI_M_BANK_DESC_LABEL(HtmlOutputLabel COMP_UI_M_BANK_DESC_LABEL) {
		this.COMP_UI_M_BANK_DESC_LABEL = COMP_UI_M_BANK_DESC_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_CHQ_NO_LABEL() {
		return COMP_UI_M_CHQ_NO_LABEL;
	}

	public void setCOMP_UI_M_CHQ_NO_LABEL(HtmlOutputLabel COMP_UI_M_CHQ_NO_LABEL) {
		this.COMP_UI_M_CHQ_NO_LABEL = COMP_UI_M_CHQ_NO_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBH_REASON_CODE_LABEL() {
		return COMP_UI_M_CBH_REASON_CODE_LABEL;
	}
 
	public void setCOMP_UI_M_CBH_REASON_CODE_LABEL(HtmlOutputLabel COMP_UI_M_CBH_REASON_CODE_LABEL) {
		this.COMP_UI_M_CBH_REASON_CODE_LABEL = COMP_UI_M_CBH_REASON_CODE_LABEL;
	}
	 
	public HtmlOutputLabel getCOMP_UI_M_REASON_CODE_DESC_LABEL() {
		return COMP_UI_M_REASON_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_REASON_CODE_DESC_LABEL) {
		this.COMP_UI_M_REASON_CODE_DESC_LABEL = COMP_UI_M_REASON_CODE_DESC_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBH_REMARKS_LABEL() {
		return COMP_UI_M_CBH_REMARKS_LABEL;
	}

	public void setCOMP_UI_M_CBH_REMARKS_LABEL(HtmlOutputLabel COMP_UI_M_CBH_REMARKS_LABEL) {
		this.COMP_UI_M_CBH_REMARKS_LABEL = COMP_UI_M_CBH_REMARKS_LABEL;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_NO_LABEL() {
		return COMP_CBH_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_CBH_POL_NO() {
		return COMP_CBH_POL_NO;
	}

	public void setCOMP_CBH_POL_NO_LABEL(HtmlOutputLabel COMP_CBH_POL_NO_LABEL) {
		this.COMP_CBH_POL_NO_LABEL = COMP_CBH_POL_NO_LABEL;
	}

	public void setCOMP_CBH_POL_NO(HtmlInputText COMP_CBH_POL_NO) {
		this.COMP_CBH_POL_NO = COMP_CBH_POL_NO;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_CONT_NAME_LABEL() {
		return COMP_CBH_POL_CONT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CBH_POL_CONT_NAME() {
		return COMP_CBH_POL_CONT_NAME;
	}

	public void setCOMP_CBH_POL_CONT_NAME_LABEL(HtmlOutputLabel COMP_CBH_POL_CONT_NAME_LABEL) {
		this.COMP_CBH_POL_CONT_NAME_LABEL = COMP_CBH_POL_CONT_NAME_LABEL;
	}

	public void setCOMP_CBH_POL_CONT_NAME(HtmlInputText COMP_CBH_POL_CONT_NAME) {
		this.COMP_CBH_POL_CONT_NAME = COMP_CBH_POL_CONT_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_TXN_TYPE_DESC_LABEL() {
		return COMP_UI_M_TXN_TYPE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TXN_TYPE_DESC() {
		return COMP_UI_M_TXN_TYPE_DESC;
	}

	public void setCOMP_UI_M_TXN_TYPE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_TXN_TYPE_DESC_LABEL) {
		this.COMP_UI_M_TXN_TYPE_DESC_LABEL = COMP_UI_M_TXN_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_TXN_TYPE_DESC(HtmlInputText COMP_UI_M_TXN_TYPE_DESC) {
		this.COMP_UI_M_TXN_TYPE_DESC = COMP_UI_M_TXN_TYPE_DESC;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_ISSUE_DT_LABEL() {
		return COMP_CBH_POL_ISSUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CBH_POL_ISSUE_DT() {
		return COMP_CBH_POL_ISSUE_DT;
	}

	public void setCOMP_CBH_POL_ISSUE_DT_LABEL(HtmlOutputLabel COMP_CBH_POL_ISSUE_DT_LABEL) {
		this.COMP_CBH_POL_ISSUE_DT_LABEL = COMP_CBH_POL_ISSUE_DT_LABEL;
	}

	public void setCOMP_CBH_POL_ISSUE_DT(HtmlCalendar COMP_CBH_POL_ISSUE_DT) {
		this.COMP_CBH_POL_ISSUE_DT = COMP_CBH_POL_ISSUE_DT;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_START_DT_LABEL() {
		return COMP_CBH_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CBH_POL_START_DT() {
		return COMP_CBH_POL_START_DT;
	}

	public void setCOMP_CBH_POL_START_DT_LABEL(HtmlOutputLabel COMP_CBH_POL_START_DT_LABEL) {
		this.COMP_CBH_POL_START_DT_LABEL = COMP_CBH_POL_START_DT_LABEL;
	}

	public void setCOMP_CBH_POL_START_DT(HtmlCalendar COMP_CBH_POL_START_DT) {
		this.COMP_CBH_POL_START_DT = COMP_CBH_POL_START_DT;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_EXPIRY_DT_LABEL() {
		return COMP_CBH_POL_EXPIRY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CBH_POL_EXPIRY_DT() {
		return COMP_CBH_POL_EXPIRY_DT;
	}

	public void setCOMP_CBH_POL_EXPIRY_DT_LABEL(HtmlOutputLabel COMP_CBH_POL_EXPIRY_DT_LABEL) {
		this.COMP_CBH_POL_EXPIRY_DT_LABEL = COMP_CBH_POL_EXPIRY_DT_LABEL;
	}

	public void setCOMP_CBH_POL_EXPIRY_DT(HtmlCalendar COMP_CBH_POL_EXPIRY_DT) {
		this.COMP_CBH_POL_EXPIRY_DT = COMP_CBH_POL_EXPIRY_DT;
	}

	public HtmlOutputLabel getCOMP_CBH_POL_PROD_CODE_LABEL() {
		return COMP_CBH_POL_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CBH_POL_PROD_CODE() {
		return COMP_CBH_POL_PROD_CODE;
	}

	public void setCOMP_CBH_POL_PROD_CODE_LABEL(HtmlOutputLabel COMP_CBH_POL_PROD_CODE_LABEL) {
		this.COMP_CBH_POL_PROD_CODE_LABEL = COMP_CBH_POL_PROD_CODE_LABEL;
	}

	public void setCOMP_CBH_POL_PROD_CODE(HtmlInputText COMP_CBH_POL_PROD_CODE) {
		this.COMP_CBH_POL_PROD_CODE = COMP_CBH_POL_PROD_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_REMARKS() {
		return COMP_UI_M_EDIT_REMARKS;
	}

	public void setCOMP_UI_M_EDIT_REMARKS(HtmlCommandButton COMP_UI_M_EDIT_REMARKS) {
		this.COMP_UI_M_EDIT_REMARKS = COMP_UI_M_EDIT_REMARKS;
	}

	 
	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_BANK_CODE() {
		return COMP_UI_M_BUT_LOV_BANK_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_BANK_CODE(HtmlCommandButton COMP_UI_M_BUT_LOV_BANK_CODE) {
		this.COMP_UI_M_BUT_LOV_BANK_CODE = COMP_UI_M_BUT_LOV_BANK_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CHQ_NO() {
		return COMP_UI_M_BUT_LOV_CHQ_NO;
	}

	public void setCOMP_UI_M_BUT_LOV_CHQ_NO(HtmlCommandButton COMP_UI_M_BUT_LOV_CHQ_NO) {
		this.COMP_UI_M_BUT_LOV_CHQ_NO = COMP_UI_M_BUT_LOV_CHQ_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOAN_REPAY_DTLS() {
		return COMP_UI_M_BUT_LOAN_REPAY_DTLS;
	}

	public void setCOMP_UI_M_BUT_LOAN_REPAY_DTLS(HtmlCommandButton COMP_UI_M_BUT_LOAN_REPAY_DTLS) {
		this.COMP_UI_M_BUT_LOAN_REPAY_DTLS = COMP_UI_M_BUT_LOAN_REPAY_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PREM_DTLS() {
		return COMP_UI_M_BUT_PREM_DTLS;
	}

	public void setCOMP_UI_M_BUT_PREM_DTLS(HtmlCommandButton COMP_UI_M_BUT_PREM_DTLS) {
		this.COMP_UI_M_BUT_PREM_DTLS = COMP_UI_M_BUT_PREM_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEP_REFUND_DTLS() {
		return COMP_UI_M_BUT_DEP_REFUND_DTLS;
	}

	public void setCOMP_UI_M_BUT_DEP_REFUND_DTLS(HtmlCommandButton COMP_UI_M_BUT_DEP_REFUND_DTLS) {
		this.COMP_UI_M_BUT_DEP_REFUND_DTLS = COMP_UI_M_BUT_DEP_REFUND_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PRINT() {
		return COMP_UI_M_BUT_PRINT;
	}

	public void setCOMP_UI_M_BUT_PRINT(HtmlCommandButton COMP_UI_M_BUT_PRINT) {
		this.COMP_UI_M_BUT_PRINT = COMP_UI_M_BUT_PRINT;
	}

	public PT_IL_CHEQUE_BOUNCE_HDR getPT_IL_CHEQUE_BOUNCE_HDR_BEAN() {
		return PT_IL_CHEQUE_BOUNCE_HDR_BEAN;
	}

	public void setPT_IL_CHEQUE_BOUNCE_HDR_BEAN(PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN) {
		this.PT_IL_CHEQUE_BOUNCE_HDR_BEAN = PT_IL_CHEQUE_BOUNCE_HDR_BEAN;
	}

	public PT_IL_PYMT_DTLS getPT_IL_FAC_CLAIM_EST_BEAN() throws  Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		 
		ELResolver resolver = context.getApplication().getELResolver();
		PT_IL_PYMT_DTLS_ACTION actionBean= (PT_IL_PYMT_DTLS_ACTION)resolver.getValue(context.getELContext(), null, "PILP018_PT_IL_PYMT_DTLS_ACTION");
		PT_IL_PYMT_DTLS valuebean = actionBean.getPT_IL_PYMT_DTLS_BEAN();
		 
		return valuebean;
	}
 
	 public void fireFieldValidation(ActionEvent ae) {
	     UIInput input = (UIInput) ae.getComponent().getParent();
	     ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public List<PT_IL_CHEQUE_BOUNCE_HDR> getBeanList() {
		return BeanList;
	}

	public void setBeanList(List<PT_IL_CHEQUE_BOUNCE_HDR> beanList) {
		BeanList = beanList;
	}


	public void AddRow(ActionEvent event){
		System.out.println("PT_IL_CHEQUE_BOUNCE_HDR_ACTION.AddRow()-Inside");
		BeanList.add(new PT_IL_CHEQUE_BOUNCE_HDR());	
	}

	public String checkBoxStatus(ActionEvent actionEvent)
	{
		return "";
	}

	public void DeleteRow(ActionEvent event) throws  Exception{
		con = CommonUtils.getConnection();
		if(BeanList != null){
					BeanList.remove(PT_IL_CHEQUE_BOUNCE_HDR_BEAN);
					int n = handler.executeDelete(PT_IL_CHEQUE_BOUNCE_HDR_BEAN, con);
					con.commit();
				} 
			 
	}

	public UIDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(UIDataTable datatable) {
		this.datatable = datatable;
	}

	public void LastColumnListener(){
		System.out.println("PT_IL_CHEQUE_BOUNCE_HDR_ACTION.LastColumnListener()-Inside");
		//session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		try{ 
			PT_IL_CHEQUE_BOUNCE_HDR  valueBean = null;
			int RowIndex = getDatatable().getRowIndex();
			valueBean = BeanList.get(RowIndex);
			con = CommonUtils.getConnection();
			//System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.LastColumnListener()-ValueBean"+valueBean.getFPD_EFF_FM_DT());
			System.out.println("The Row Id Is--Vijay" + valueBean.getROWID() );
			 
			//con = getConnection();
			//PM_IL_FUND_PRICE_DTL_BEAN = BeanList.get(rowIndex);
			
			//System.out.println("#########################################################");
			//System.out.println("PM_IL_FUND_PRICE_DTL_BEAN"+session.get("FPD_FS_CODE").toString());
			//String fpd_fs_code = session.get("FPD_FS_CODE").toString();
			//System.out.println("#########################################################");
			//PM_IL_FUND_PRICE_DTL_BEAN.setFPD_FS_CODE(fpd_fs_code);
			
			if(valueBean.getROWID()!= null){
				System.out.println("UPdattion Is Done"); 
				System.out.println("PT_IL_CHEQUE_BOUNCE_HDR_ACTION.LastColumnListener()-Inside");
				int n = handler.executeUpdate(valueBean, con);
				System.out.println("NO ROWS UPDATED" + n);
				//con.commit();
				//con.close();
			}else{
				System.out.println("PT_IL_CHEQUE_BOUNCE_HDR_ACTION.LastColumnListener()-Inside");
				//PM_IL_FUND_PRICE_DTL_PRE_INSERT();
				int n = handler.executeInsert(valueBean, con);
				System.out.println("No Of Rows Inserted Is" + n );
				//con.commit();
				//con.close();
				
			}
		}
	 catch(Exception e){
			e.printStackTrace();
		}
    }
	
	public void CBH_POL_PROD_CODE_When_Validate_item(ActionEvent event){
		LastColumnListener();
	}
	
	public void populateValues(String M_WHERE) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, DBException{
		 
		con = CommonUtils.getConnection();
		String selectQuery = "SELECT * FROM PT_IL_CHEQUE_BOUNCE_HDR WHERE" + M_WHERE;
		List<PT_IL_CHEQUE_BOUNCE_HDR> list = handler.fetch(selectQuery, "com.iii.pel.forms.PILP018.PT_IL_CHEQUE_BOUNCE_HDR",con);
		 setBeanList(list); 
	}
	 
	public HtmlCommandButton getTestButton() {
		return testButton;
	}

	public void setTestButton(HtmlCommandButton testButton) {
		this.testButton = testButton;
	}
  	
	public String nvl(String value1,String value2){
		if("".equals(value1)){
			value1= ""+value2;
		}
		return value1;
	}
	
	public void onLoad( ) {
	    PT_IL_CHEQUE_BOUNCE_HDR_HELPER helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
	    try {
		
		if(isFormFlag()){
		    helper.WHEN_NEW_FORM_INSTANCE(this);
		    setFormFlag(false);
		}
		  if (isBlockFlag()) {
		      helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction );
		      helper.WHEN_NEW_RECORD_INSTANCE(this);
		      
		      helper.POST_QUERY(PT_IL_CHEQUE_BOUNCE_HDR_BEAN);
		      setBlockFlag(false); 
		  }
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	    }
	}
	 public String  UI_M_BUT_REVERSE_Button_Action(FacesContext facesContext,
		 UIComponent component, Object value) throws ValidatorException {
	     CommonUtils.clearMaps(this);
	     try {
		 new PILP018_HELPER().M_BUT_REVERSE_WHEN_BUTTON_PRESSED(
			 compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
			 compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().getPT_IL_PYMT_DTLS_BEAN(), 
			 this);
	     } catch (Exception exception) {
		 exception.printStackTrace();
		 throw new ValidatorException(new FacesMessage(exception
			 .getMessage()));
	     } finally {
		 try {
		     ErrorHelpUtil.getWarningForProcedure(CommonUtils
			     .getConnection(), "UI_M_BUT_REVERSE",
			     getWarningMap());
		     
		 } catch (Exception e) {
		     e.printStackTrace();
		 }
	     }
	     return null;
	 }

    public String gotoLoanRepayDetails(){
    	return "PILP018_LR_DETAILS" ;
     }
    
   public String gotoPremiumDetails(){
	   return "PILP018_PREMIUM_DETAILS";  
  }
   
  public String gotoDepositRefundDetails(){
	  return "PILP018_DEPOSIT_REFUND_DETAILS";
  }
  
public List<PT_IL_PYMT_DTLS> getDeanList() {
	return DeanList;
}

public void setDeanList(List<PT_IL_PYMT_DTLS> deanList) {
	DeanList = deanList;
}
 }
  
   
   

 
	
	
	
