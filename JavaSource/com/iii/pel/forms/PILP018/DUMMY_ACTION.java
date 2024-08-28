package com.iii.pel.forms.PILP018;

import java.sql.Connection;
import java.sql.ResultSet;
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.utl_smtp.connection;


public class DUMMY_ACTION extends CommonAction {

	private DUMMY DUMMY_BEAN;
	public PILP018_COMPOSITE_ACTION  compositeAction;
	
private HtmlInputText COMP_UI_M_BANK_CODE;
	
	private HtmlInputText COMP_UI_M_BANK_DESC;
	
	private HtmlInputText COMP_UI_M_CHQ_NO;

	private HtmlInputText COMP_UI_M_CBH_REASON_CODE;
	private HtmlInputText COMP_UI_M_CBH_REMARKS;
	private HtmlInputText COMP_UI_M_REASON_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_REVERSE;
	
	public HtmlCommandButton getCOMP_UI_M_BUT_REVERSE() {
	    return COMP_UI_M_BUT_REVERSE;
	}

	public void setCOMP_UI_M_BUT_REVERSE(HtmlCommandButton comp_ui_m_but_reverse) {
	    COMP_UI_M_BUT_REVERSE = comp_ui_m_but_reverse;
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

	public HtmlInputText getCOMP_UI_M_BANK_CODE() {
	    return COMP_UI_M_BANK_CODE;
	}

	public void setCOMP_UI_M_BANK_CODE(HtmlInputText comp_ui_m_bank_code) {
	    COMP_UI_M_BANK_CODE = comp_ui_m_bank_code;
	}

	public HtmlInputText getCOMP_UI_M_BANK_DESC() {
	    return COMP_UI_M_BANK_DESC;
	}

	public void setCOMP_UI_M_BANK_DESC(HtmlInputText comp_ui_m_bank_desc) {
	    COMP_UI_M_BANK_DESC = comp_ui_m_bank_desc;
	}

	public HtmlInputText getCOMP_UI_M_CHQ_NO() {
	    return COMP_UI_M_CHQ_NO;
	}

	public void setCOMP_UI_M_CHQ_NO(HtmlInputText comp_ui_m_chq_no) {
	    COMP_UI_M_CHQ_NO = comp_ui_m_chq_no;
	}

	public HtmlInputText getCOMP_UI_M_CBH_REASON_CODE() {
	    return COMP_UI_M_CBH_REASON_CODE;
	}

	public void setCOMP_UI_M_CBH_REASON_CODE(HtmlInputText comp_ui_m_cbh_reason_code) {
	    COMP_UI_M_CBH_REASON_CODE = comp_ui_m_cbh_reason_code;
	}

	public HtmlInputText getCOMP_UI_M_CBH_REMARKS() {
	    return COMP_UI_M_CBH_REMARKS;
	}

	public void setCOMP_UI_M_CBH_REMARKS(HtmlInputText comp_ui_m_cbh_remarks) {
	    COMP_UI_M_CBH_REMARKS = comp_ui_m_cbh_remarks;
	}

	public HtmlInputText getCOMP_UI_M_REASON_CODE_DESC() {
	    return COMP_UI_M_REASON_CODE_DESC;
	}

	public void setCOMP_UI_M_REASON_CODE_DESC(
		HtmlInputText comp_ui_m_reason_code_desc) {
	    COMP_UI_M_REASON_CODE_DESC = comp_ui_m_reason_code_desc;
	}
	
	 
	 public void validateUI_M_BANK_CODE(FacesContext facesContext,
		    UIComponent component, Object value) throws ValidatorException {
			CommonUtils.clearMaps(this);
		try {
		    DUMMY_BEAN.setUI_M_BANK_CODE((String)value);
		    new PILP018_HELPER().M_BANK_CODE_when_validate_item(DUMMY_BEAN, 
			    compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().getPT_IL_PYMT_DTLS_BEAN());
		} catch (Exception exception) {
		    exception.printStackTrace();
		    throw new ValidatorException(new FacesMessage(exception
		    		.getMessage()));
		} finally {
		    try {
			ErrorHelpUtil.getWarningForProcedure(CommonUtils
				.getConnection(), "UI_M_BANK_CODE",
				getWarningMap());
			
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	    }
	 public void validateUI_M_CHQ_NO(FacesContext facesContext,
		 UIComponent component, Object value) throws ValidatorException {
	     CommonUtils.clearMaps(this);
	     try {
		 DUMMY_BEAN.setUI_M_CHQ_NO((String)value);
		 new PILP018_HELPER().M_CHQ_NO_When_Validate_Item(compositeAction);
		//  compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().getCOMP_UI_M_PD_CURR_CODE_DESC().resetValue();
	     } catch (Exception exception) {
		 exception.printStackTrace();
		 throw new ValidatorException(new FacesMessage(exception
			 .getMessage()));
	     } finally {
		 try {
		     ErrorHelpUtil.getWarningForProcedure(CommonUtils
			     .getConnection(), "UI_M_CHQ_NO",
			     getWarningMap());
		     
		 } catch (Exception e) {
		     e.printStackTrace();
		 }
	     }
	 }
	 public void validateUI_M_CBH_REASON_CODE(FacesContext facesContext,
		 UIComponent component, Object value) throws ValidatorException {
	     CommonUtils.clearMaps(this);
	     try {
		 DUMMY_BEAN.setUI_M_CBH_REASON_CODE((String)value);
		 new PILP018_HELPER().M_CBH_REASON_CODE_when_validate_item(DUMMY_BEAN);
	     } catch (Exception exception) {
		 exception.printStackTrace();
		 throw new ValidatorException(new FacesMessage(exception
			 .getMessage()));
	     } finally {
		 try {
		     ErrorHelpUtil.getWarningForProcedure(CommonUtils
			     .getConnection(), "UI_M_CBH_REASON_CODE",
			     getWarningMap());
		     
		 } catch (Exception e) {
		     e.printStackTrace();
		 }
	     }
	 }
	public void BlockLevelEvents(ActionEvent event) throws Exception{
			System.out.println("PT_IL_CHEQUE_BOUNCE_HDR_ACTION.BlockLevelEvents()");
			PT_IL_CHEQUE_BOUNCE_HDR_HELPER  helper = new PT_IL_CHEQUE_BOUNCE_HDR_HELPER();
			helper.WHEN_NEW_FORM_INSTANCE(compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN());
			helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
			helper.WHEN_NEW_RECORD_INSTANCE( compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN());
			helper.POST_QUERY(compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN());
		}
	 public ArrayList<com.iii.premia.common.bean.LovBean> lovUI_M_BANK_CODE(
		    Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
		    suggestionList = listitemutil.P_CALL_LOV("PILP018",
				  "DUMMY", "M_BANK_CODE", null,null,
				 null, null, null,  (String) currValue);
		       //P_CALL_LOV('DUMMY.M_BANK_CODE');
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return suggestionList;
	    }
	 public ArrayList<com.iii.premia.common.bean.LovBean> lovM_CBH_REASON_CODE(
		 Object currValue) {
	     ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	     ListItemUtil listitemutil = new ListItemUtil();
	     ResultSet rs=null;
	     Connection con = null;
	     Object[]  values=null;
	     try {
		/* suggestionList = listitemutil.P_CALL_LOV("PILP018",
			 "DUMMY", "M_CBH_REASON_CODE","REV_REASON",null,
			 null, null, null,  (String) currValue);*/
			//getCOMP_BAS_DIVN_FM_CODE().setSubmittedValue(null);
			String query = null;
			if(currValue.toString().equals("*")){
				query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'REV_REASON' AND " +
						" NVL(PC_FRZ_FLAG,'N') = 'N' AND ( PC_CODE LIKE ? OR PC_DESC LIKE ? ) ORDER BY 1";
				values = null;
			}else{
				query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'REV_REASON' AND NVL(PC_FRZ_FLAG,'N') = 'N'  " +
						"  AND  ( PC_CODE LIKE ?  OR  PC_DESC LIKE ? ) ORDER BY 1 " ;
			}
			System.out.println("> qry >> "+query);
			currValue = "*".equals(currValue)?"%":currValue.toString().toUpperCase()+"%";
			values = new Object[]{currValue,currValue};
			suggestionList = listitemutil.prepareSuggestionList(query,values);
			/*rs = new CRUDHandler().executeSelectStatement(query, con);
			rs.setFetchSize(25);
			while(rs.next()){
				LovBean lbean = new LovBean();
				lbean.setCode(rs.getString("PC_CODE"));
				lbean.setName(rs.getString("PC_DESC"));
				suggestionList.add(lbean);
			}*/
		 // P_CALL_LOV('DUMMY.M_CBH_REASON_CODE','REV_REASON');
		 
	     } catch (Exception e) {
		 e.printStackTrace();
	     }
	     return suggestionList;
	 }
	 public void fireFieldValidation(ActionEvent ae) {
	     UIInput input = (UIInput) ae.getComponent().getParent();
	     ErrorHelpUtil.validate(input, getErrorMap());
	}
	 public List ChequeSuggestionBox(Object obj) throws Exception{
 
		List suggestionList = new ArrayList();
		String query = null;
		ResultSet rs=null;
		try {
		    if(DUMMY_BEAN.getUI_M_BANK_CODE()!=null){
			
		    if(obj.toString().equals("*")){
		    	//query = "SELECT PD_CHQ_NO,PD_CHQ_DT  FROM PT_IL_PYMT_DTLS WHERE PD_PAY_MODE IN ('C','L','O')";
			query = "SELECT DPD_CHQ_NO,ROWID FROM PT_IL_DEPOSIT_PYMT_DTLS WHERE DPD_BANK_NAME =? ";
		    }else{
		    	query = "SELECT  DPD_CHQ_NO,ROWID  FROM PT_IL_DEPOSIT_PYMT_DTLS WHERE DPD_BANK_NAME = ? " +
		    			" AND DPD_CHQ_NO LIKE '" +  obj.toString().toUpperCase()+ "%'" ;
		    	
		    	System.out.println("query789"+query);
		    }
		   
		    rs = new CRUDHandler().executeSelectStatement(query,  CommonUtils.getConnection(),
			    new Object[]{DUMMY_BEAN.getUI_M_BANK_CODE()});
		    rs.setFetchSize(25);
		    while(rs.next()){
		    	LovBean lbean = new LovBean();
		    	lbean.setPD_CHQ_NO(rs.getString("DPD_CHQ_NO"));
		    	 
		    	suggestionList.add(lbean);
		    }
		    }else{
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY," Enter Bank Code First");
		    }
		} catch (RuntimeException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		 finally{
		     CommonUtils.closeCursor(rs);
		 }
		return suggestionList;
	}

}
